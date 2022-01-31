package com.tencent.mm.plugin.sns.ui.album;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.ak;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.ax;
import com.tencent.mm.plugin.sns.ui.d;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.sdk.platformtools.ab;
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
  private boolean ctJ;
  private Map<String, List<n>> map;
  private String meP;
  private boolean rVp;
  private b.a sez;
  private String userName;
  
  public b(b.a parama, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(39976);
    this.userName = "";
    this.ctJ = false;
    this.meP = "";
    this.rVp = false;
    this.sez = null;
    this.map = new LinkedHashMap();
    this.sez = parama;
    this.userName = paramString;
    this.ctJ = paramBoolean;
    AppMethodBeat.o(39976);
  }
  
  public final List<a.b> Kq()
  {
    AppMethodBeat.i(39979);
    this.map.clear();
    ArrayList localArrayList = new ArrayList();
    ab.i("MicroMsg.SnsAlbumAdapterHelper", "loadData isSelf=%s limitSeq=%s isPrivate=%s", new Object[] { Boolean.valueOf(this.ctJ), this.meP, Boolean.valueOf(this.rVp) });
    List localList = ak.c(this.userName, this.ctJ, this.meP);
    Object localObject3 = localList.iterator();
    Object localObject2;
    while (((Iterator)localObject3).hasNext())
    {
      n localn = (n)((Iterator)localObject3).next();
      if (((localn.field_type == 1) || (localn.field_type == 15)) && (localn.csh() != null) && (localn.csh().xTS != null) && (!localn.csh().xTS.wOa.isEmpty()))
      {
        long l = localn.field_createTime;
        String str = ax.mh(1000L * l).toString();
        ab.i("MicroMsg.SnsAlbumAdapterHelper", "key:%s createTime:%s info.id:%s", new Object[] { str, Long.valueOf(l * 1000L), Long.valueOf(localn.field_snsId) });
        localObject2 = (List)this.map.get(str);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new ArrayList();
          this.map.put(str, localObject1);
        }
        ((List)localObject1).add(localn);
      }
    }
    Object localObject1 = this.map.entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      localObject3 = new a.b();
      ((a.b)localObject3).label = ((String)((Map.Entry)localObject2).getKey());
      ((a.b)localObject3).seq = ((List)((Map.Entry)localObject2).getValue());
      ab.i("MicroMsg.SnsAlbumAdapterHelper", "%s", new Object[] { localObject3 });
      localArrayList.add(localObject3);
    }
    ab.i("MicroMsg.SnsAlbumAdapterHelper", "loadData thread: %d count: %d  realCount:%s", new Object[] { Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(localList.size()), Integer.valueOf(localArrayList.size()) });
    AppMethodBeat.o(39979);
    return localArrayList;
  }
  
  public final void dl(List<a.b> paramList)
  {
    AppMethodBeat.i(39978);
    if (this.sez != null) {
      this.sez.dp(paramList);
    }
    AppMethodBeat.o(39978);
  }
  
  public final void h(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(39977);
    ab.d("MicroMsg.SnsAlbumAdapterHelper", "limitSeq ".concat(String.valueOf(paramString)));
    this.meP = paramString;
    this.rVp = paramBoolean1;
    ie(paramBoolean2);
    AppMethodBeat.o(39977);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.album.b
 * JD-Core Version:    0.7.0.1
 */