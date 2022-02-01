package com.tencent.mm.plugin.sns.ui.album;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.bg;
import com.tencent.mm.plugin.sns.ui.d;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.zf;
import com.tencent.mm.sdk.platformtools.ac;
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
  private boolean dfZ;
  private Map<String, List<p>> map;
  private String qui;
  private String userName;
  private boolean yQQ;
  private a zax;
  
  public b(a parama, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(99866);
    this.userName = "";
    this.dfZ = false;
    this.qui = "";
    this.yQQ = false;
    this.zax = null;
    this.map = new LinkedHashMap();
    this.zax = parama;
    this.userName = paramString;
    this.dfZ = paramBoolean;
    AppMethodBeat.o(99866);
  }
  
  public final List<a.b> WX()
  {
    AppMethodBeat.i(99869);
    this.map.clear();
    ArrayList localArrayList = new ArrayList();
    ac.i("MicroMsg.SnsAlbumAdapterHelper", "loadData isSelf=%s limitSeq=%s isPrivate=%s", new Object[] { Boolean.valueOf(this.dfZ), this.qui, Boolean.valueOf(this.yQQ) });
    List localList = aj.w(this.dfZ, this.qui);
    Object localObject3 = localList.iterator();
    Object localObject2;
    while (((Iterator)localObject3).hasNext())
    {
      p localp = (p)((Iterator)localObject3).next();
      if (((localp.field_type == 1) || (localp.field_type == 15)) && (localp.dLV() != null) && (localp.dLV().FQo != null) && (!localp.dLV().FQo.Etz.isEmpty()))
      {
        long l = localp.field_createTime;
        String str = bg.xT(1000L * l).toString();
        ac.i("MicroMsg.SnsAlbumAdapterHelper", "key:%s createTime:%s info.id:%s", new Object[] { str, Long.valueOf(l * 1000L), Long.valueOf(localp.field_snsId) });
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
      ((a.b)localObject3).zao = ((List)((Map.Entry)localObject2).getValue());
      ac.i("MicroMsg.SnsAlbumAdapterHelper", "%s", new Object[] { localObject3 });
      localArrayList.add(localObject3);
    }
    ac.i("MicroMsg.SnsAlbumAdapterHelper", "loadData thread: %d count: %d  realCount:%s", new Object[] { Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(localList.size()), Integer.valueOf(localArrayList.size()) });
    AppMethodBeat.o(99869);
    return localArrayList;
  }
  
  public final void fJ(List<a.b> paramList)
  {
    AppMethodBeat.i(99868);
    if (this.zax != null) {
      this.zax.fP(paramList);
    }
    AppMethodBeat.o(99868);
  }
  
  public final void h(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(99867);
    ac.d("MicroMsg.SnsAlbumAdapterHelper", "limitSeq ".concat(String.valueOf(paramString)));
    this.qui = paramString;
    this.yQQ = paramBoolean1;
    mJ(paramBoolean2);
    AppMethodBeat.o(99867);
  }
  
  public static abstract interface a
  {
    public abstract void fP(List<a.b> paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.album.b
 * JD-Core Version:    0.7.0.1
 */