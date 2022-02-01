package com.tencent.mm.plugin.sns.ui.album;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.bj;
import com.tencent.mm.plugin.sns.ui.d;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.sdk.platformtools.ae;
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
  private a AJC;
  private boolean dsB;
  private Map<String, List<p>> map;
  private String rmb;
  private boolean sVq;
  private String userName;
  
  public b(a parama, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(99866);
    this.userName = "";
    this.dsB = false;
    this.rmb = "";
    this.sVq = false;
    this.AJC = null;
    this.map = new LinkedHashMap();
    this.AJC = parama;
    this.userName = paramString;
    this.dsB = paramBoolean;
    AppMethodBeat.o(99866);
  }
  
  public final List<a.b> Zz()
  {
    AppMethodBeat.i(99869);
    this.map.clear();
    ArrayList localArrayList = new ArrayList();
    ae.i("MicroMsg.SnsAlbumAdapterHelper", "loadData isSelf=%s limitSeq=%s isPrivate=%s", new Object[] { Boolean.valueOf(this.dsB), this.rmb, Boolean.valueOf(this.sVq) });
    List localList = al.D(this.dsB, this.rmb);
    Object localObject3 = localList.iterator();
    Object localObject2;
    while (((Iterator)localObject3).hasNext())
    {
      p localp = (p)((Iterator)localObject3).next();
      if (((localp.field_type == 1) || (localp.field_type == 15)) && (localp.ebP() != null) && (localp.ebP().HUG != null) && (!localp.ebP().HUG.Gtx.isEmpty()))
      {
        long l = localp.field_createTime;
        String str = bj.AP(1000L * l).toString();
        ae.i("MicroMsg.SnsAlbumAdapterHelper", "key:%s createTime:%s info.id:%s", new Object[] { str, Long.valueOf(l * 1000L), Long.valueOf(localp.field_snsId) });
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
      ((a.b)localObject3).AJt = ((List)((Map.Entry)localObject2).getValue());
      ae.i("MicroMsg.SnsAlbumAdapterHelper", "%s", new Object[] { localObject3 });
      localArrayList.add(localObject3);
    }
    ae.i("MicroMsg.SnsAlbumAdapterHelper", "loadData thread: %d count: %d  realCount:%s", new Object[] { Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(localList.size()), Integer.valueOf(localArrayList.size()) });
    AppMethodBeat.o(99869);
    return localArrayList;
  }
  
  public final void gd(List<a.b> paramList)
  {
    AppMethodBeat.i(99868);
    if (this.AJC != null) {
      this.AJC.gj(paramList);
    }
    AppMethodBeat.o(99868);
  }
  
  public final void j(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(99867);
    ae.d("MicroMsg.SnsAlbumAdapterHelper", "limitSeq ".concat(String.valueOf(paramString)));
    this.rmb = paramString;
    this.sVq = paramBoolean1;
    nh(paramBoolean2);
    AppMethodBeat.o(99867);
  }
  
  public static abstract interface a
  {
    public abstract void gj(List<a.b> paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.album.b
 * JD-Core Version:    0.7.0.1
 */