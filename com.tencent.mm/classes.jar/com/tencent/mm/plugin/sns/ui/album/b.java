package com.tencent.mm.plugin.sns.ui.album;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.bm;
import com.tencent.mm.plugin.sns.ui.d;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class b
  extends d<a.b>
{
  private a ETv;
  private boolean dJM;
  private Map<String, List<SnsInfo>> map;
  private String sNG;
  private String userName;
  private boolean vUk;
  
  public b(a parama, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(99866);
    this.userName = "";
    this.dJM = false;
    this.sNG = "";
    this.vUk = false;
    this.ETv = null;
    this.map = new LinkedHashMap();
    this.ETv = parama;
    this.userName = paramString;
    this.dJM = paramBoolean;
    AppMethodBeat.o(99866);
  }
  
  public final List<a.b> anm()
  {
    AppMethodBeat.i(99869);
    this.map.clear();
    ArrayList localArrayList = new ArrayList();
    Log.i("MicroMsg.SnsAlbumAdapterHelper", "loadData isSelf=%s limitSeq=%s isPrivate=%s", new Object[] { Boolean.valueOf(this.dJM), this.sNG, Boolean.valueOf(this.vUk) });
    List localList = an.E(this.dJM, this.sNG);
    Object localObject3 = localList.iterator();
    Object localObject2;
    while (((Iterator)localObject3).hasNext())
    {
      SnsInfo localSnsInfo = (SnsInfo)((Iterator)localObject3).next();
      if (((localSnsInfo.field_type == 1) || (localSnsInfo.field_type == 15)) && (localSnsInfo.getTimeLine() != null) && (localSnsInfo.getTimeLine().ContentObj != null) && (!localSnsInfo.getTimeLine().ContentObj.LoV.isEmpty()))
      {
        long l = localSnsInfo.getCreateTime();
        String str = bm.JU(1000L * l).toString();
        Log.i("MicroMsg.SnsAlbumAdapterHelper", "key:%s createTime:%s info.id:%s", new Object[] { str, Long.valueOf(l * 1000L), Long.valueOf(localSnsInfo.field_snsId) });
        localObject2 = (List)this.map.get(str);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new ArrayList();
          this.map.put(str, localObject1);
        }
        ((List)localObject1).add(localSnsInfo);
      }
    }
    Object localObject1 = this.map.entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      localObject3 = new a.b();
      ((a.b)localObject3).label = ((String)((Map.Entry)localObject2).getKey());
      ((a.b)localObject3).ETm = ((List)((Map.Entry)localObject2).getValue());
      Log.i("MicroMsg.SnsAlbumAdapterHelper", "%s", new Object[] { localObject3 });
      localArrayList.add(localObject3);
    }
    Log.i("MicroMsg.SnsAlbumAdapterHelper", "loadData thread: %d count: %d  realCount:%s", new Object[] { Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(localList.size()), Integer.valueOf(localArrayList.size()) });
    AppMethodBeat.o(99869);
    return localArrayList;
  }
  
  public final void gZ(List<a.b> paramList)
  {
    AppMethodBeat.i(99868);
    if (this.ETv != null) {
      this.ETv.hg(paramList);
    }
    AppMethodBeat.o(99868);
  }
  
  public final void k(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(99867);
    Log.d("MicroMsg.SnsAlbumAdapterHelper", "limitSeq ".concat(String.valueOf(paramString)));
    this.sNG = paramString;
    this.vUk = paramBoolean1;
    pN(paramBoolean2);
    AppMethodBeat.o(99867);
  }
  
  public static abstract interface a
  {
    public abstract void hg(List<a.b> paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.album.b
 * JD-Core Version:    0.7.0.1
 */