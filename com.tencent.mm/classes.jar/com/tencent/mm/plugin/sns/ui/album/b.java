package com.tencent.mm.plugin.sns.ui.album;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.bg;
import com.tencent.mm.plugin.sns.ui.d;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.yk;
import com.tencent.mm.sdk.platformtools.ad;
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
  private boolean diE;
  private Map<String, List<p>> map;
  private String pLA;
  private String userName;
  private boolean xEc;
  private a xNH;
  
  public b(a parama, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(99866);
    this.userName = "";
    this.diE = false;
    this.pLA = "";
    this.xEc = false;
    this.xNH = null;
    this.map = new LinkedHashMap();
    this.xNH = parama;
    this.userName = paramString;
    this.diE = paramBoolean;
    AppMethodBeat.o(99866);
  }
  
  public final List<a.b> VZ()
  {
    AppMethodBeat.i(99869);
    this.map.clear();
    ArrayList localArrayList = new ArrayList();
    ad.i("MicroMsg.SnsAlbumAdapterHelper", "loadData isSelf=%s limitSeq=%s isPrivate=%s", new Object[] { Boolean.valueOf(this.diE), this.pLA, Boolean.valueOf(this.xEc) });
    List localList = aj.v(this.diE, this.pLA);
    Object localObject3 = localList.iterator();
    Object localObject2;
    while (((Iterator)localObject3).hasNext())
    {
      p localp = (p)((Iterator)localObject3).next();
      if (((localp.field_type == 1) || (localp.field_type == 15)) && (localp.dxy() != null) && (localp.dxy().Etm != null) && (!localp.dxy().Etm.DaC.isEmpty()))
      {
        long l = localp.field_createTime;
        String str = bg.tq(1000L * l).toString();
        ad.i("MicroMsg.SnsAlbumAdapterHelper", "key:%s createTime:%s info.id:%s", new Object[] { str, Long.valueOf(l * 1000L), Long.valueOf(localp.field_snsId) });
        localObject2 = (List)this.map.get(str);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new ArrayList();
          this.map.put(str, localObject1);
        }
        ((List)localObject1).add(localp);
      }
    }
    Object localObject1 = this.map.entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      localObject3 = new a.b();
      ((a.b)localObject3).label = ((String)((Map.Entry)localObject2).getKey());
      ((a.b)localObject3).xNy = ((List)((Map.Entry)localObject2).getValue());
      ad.i("MicroMsg.SnsAlbumAdapterHelper", "%s", new Object[] { localObject3 });
      localArrayList.add(localObject3);
    }
    ad.i("MicroMsg.SnsAlbumAdapterHelper", "loadData thread: %d count: %d  realCount:%s", new Object[] { Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(localList.size()), Integer.valueOf(localArrayList.size()) });
    AppMethodBeat.o(99869);
    return localArrayList;
  }
  
  public final void fB(List<a.b> paramList)
  {
    AppMethodBeat.i(99868);
    if (this.xNH != null) {
      this.xNH.fH(paramList);
    }
    AppMethodBeat.o(99868);
  }
  
  public final void g(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(99867);
    ad.d("MicroMsg.SnsAlbumAdapterHelper", "limitSeq ".concat(String.valueOf(paramString)));
    this.pLA = paramString;
    this.xEc = paramBoolean1;
    lQ(paramBoolean2);
    AppMethodBeat.o(99867);
  }
  
  public static abstract interface a
  {
    public abstract void fH(List<a.b> paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.album.b
 * JD-Core Version:    0.7.0.1
 */