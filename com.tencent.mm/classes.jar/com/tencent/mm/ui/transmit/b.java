package com.tencent.mm.ui.transmit;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.contact.a.e;
import com.tencent.mm.ui.contact.a.i;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.o.a;
import com.tencent.mm.ui.contact.p;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public final class b
  extends o
{
  private l KMA;
  private MMCreateChatroomUI KMz;
  private ap handler;
  String query;
  k tuZ;
  private com.tencent.mm.plugin.fts.a.a.a tvk;
  
  public b(MMCreateChatroomUI paramMMCreateChatroomUI, int paramInt)
  {
    super(paramMMCreateChatroomUI, false, paramInt);
    AppMethodBeat.i(39232);
    this.handler = new ap(Looper.getMainLooper());
    this.KMA = new l()
    {
      public final void b(k paramAnonymousk)
      {
        AppMethodBeat.i(39231);
        if (paramAnonymousk.bZU == 0) {
          b.a(b.this, paramAnonymousk);
        }
        for (;;)
        {
          if (paramAnonymousk.tvl.size() == 0)
          {
            m localm = new m();
            localm.tuh = "no_result​";
            paramAnonymousk.tvl = new ArrayList();
            paramAnonymousk.tvl.add(localm);
          }
          b.this.clearCache();
          b.this.notifyDataSetChanged();
          b.a(b.this).y(paramAnonymousk.trv.query, paramAnonymousk.tvl.size(), true);
          AppMethodBeat.o(39231);
          return;
          b.a(b.this, null);
        }
      }
    };
    this.KMz = paramMMCreateChatroomUI;
    AppMethodBeat.o(39232);
  }
  
  public final void b(String paramString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(39233);
    this.query = paramString;
    paramArrayOfInt = new j();
    paramArrayOfInt.handler = this.handler;
    paramArrayOfInt.tvj = this.KMA;
    paramArrayOfInt.query = paramString;
    paramArrayOfInt.tvi = com.tencent.mm.plugin.fts.a.c.b.tvI;
    paramArrayOfInt.tve = new int[] { 131072 };
    paramArrayOfInt.tvh.add("filehelper");
    paramArrayOfInt.tvh.add(u.aAm());
    paramArrayOfInt.tvh.addAll(this.KMz.KMD.fKR());
    this.tvk = ((n)g.ad(n.class)).search(2, paramArrayOfInt);
    AppMethodBeat.o(39233);
  }
  
  public final void clearData()
  {
    AppMethodBeat.i(39234);
    if (this.tvk != null) {
      ((n)g.ad(n.class)).cancelSearchTask(this.tvk);
    }
    this.query = null;
    AppMethodBeat.o(39234);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(39236);
    if ((this.tuZ != null) && (this.tuZ.tvl != null))
    {
      int i = this.tuZ.tvl.size();
      AppMethodBeat.o(39236);
      return i;
    }
    AppMethodBeat.o(39236);
    return 0;
  }
  
  public final com.tencent.mm.ui.contact.a.a rh(int paramInt)
  {
    AppMethodBeat.i(39235);
    m localm = (m)this.tuZ.tvl.get(paramInt);
    Object localObject;
    if (localm.tuh.equals("no_result​")) {
      localObject = new i(paramInt);
    }
    for (;;)
    {
      ((com.tencent.mm.ui.contact.a.a)localObject).query = this.query;
      ((com.tencent.mm.ui.contact.a.a)localObject).scene = this.scene;
      ((com.tencent.mm.ui.contact.a.a)localObject).KmP = false;
      AppMethodBeat.o(39235);
      return localObject;
      localObject = new e(paramInt);
      ((e)localObject).kjY = localm;
      ((com.tencent.mm.ui.contact.a.a)localObject).tun = this.tuZ.tun;
      ((com.tencent.mm.ui.contact.a.a)localObject).KmP = dQK();
      ((e)localObject).gvn = true;
      ((e)localObject).tvV = (paramInt + 1);
      ((e)localObject).gf(((e)localObject).kjY.type, ((e)localObject).kjY.tug);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.b
 * JD-Core Version:    0.7.0.1
 */