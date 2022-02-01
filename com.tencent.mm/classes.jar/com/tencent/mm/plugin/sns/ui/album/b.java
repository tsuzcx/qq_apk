package com.tencent.mm.plugin.sns.ui.album;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.bp;
import com.tencent.mm.plugin.sns.ui.d;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agh;
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
  private boolean Gdb;
  private a RHM;
  private boolean hHq;
  private Map<String, List<SnsInfo>> map;
  private String userName;
  private String zPH;
  
  public b(a parama, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(99866);
    this.userName = "";
    this.hHq = false;
    this.zPH = "";
    this.Gdb = false;
    this.RHM = null;
    this.map = new LinkedHashMap();
    this.RHM = parama;
    this.userName = paramString;
    this.hHq = paramBoolean;
    AppMethodBeat.o(99866);
  }
  
  public final List<a.b> aNv()
  {
    AppMethodBeat.i(99869);
    this.map.clear();
    ArrayList localArrayList = new ArrayList();
    Log.i("MicroMsg.SnsAlbumAdapterHelper", "loadData isSelf=%s limitSeq=%s isPrivate=%s", new Object[] { Boolean.valueOf(this.hHq), this.zPH, Boolean.valueOf(this.Gdb) });
    List localList = ap.ay(this.hHq, this.zPH);
    Object localObject3 = localList.iterator();
    Object localObject2;
    while (((Iterator)localObject3).hasNext())
    {
      SnsInfo localSnsInfo = (SnsInfo)((Iterator)localObject3).next();
      if (((localSnsInfo.field_type == 1) || (localSnsInfo.field_type == 15)) && (localSnsInfo.getTimeLine() != null) && (localSnsInfo.getTimeLine().ContentObj != null) && (!localSnsInfo.getTimeLine().ContentObj.Zpr.isEmpty()))
      {
        l = localSnsInfo.getCreateTime();
        String str = bp.vu(1000L * l).toString();
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
      ((a.b)localObject3).RHC = ((List)((Map.Entry)localObject2).getValue());
      Log.i("MicroMsg.SnsAlbumAdapterHelper", "%s", new Object[] { localObject3 });
      localArrayList.add(localObject3);
    }
    long l = Thread.currentThread().getId();
    if (localList == null) {}
    for (int i = 0;; i = localList.size())
    {
      Log.i("MicroMsg.SnsAlbumAdapterHelper", "loadData thread: %d count: %d  realCount:%s", new Object[] { Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(localArrayList.size()) });
      AppMethodBeat.o(99869);
      return localArrayList;
    }
  }
  
  public final void kI(List<a.b> paramList)
  {
    AppMethodBeat.i(99868);
    if (this.RHM != null) {
      this.RHM.kQ(paramList);
    }
    AppMethodBeat.o(99868);
  }
  
  public final void m(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(99867);
    Log.d("MicroMsg.SnsAlbumAdapterHelper", "limitSeq ".concat(String.valueOf(paramString)));
    this.zPH = paramString;
    this.Gdb = paramBoolean1;
    wq(paramBoolean2);
    AppMethodBeat.o(99867);
  }
  
  public static abstract interface a
  {
    public abstract void kQ(List<a.b> paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.album.b
 * JD-Core Version:    0.7.0.1
 */