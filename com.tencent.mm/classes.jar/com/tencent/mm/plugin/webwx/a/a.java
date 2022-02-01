package com.tencent.mm.plugin.webwx.a;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.aw.d.a;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.t.a;
import com.tencent.mm.modelvideo.t.a.a;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.bn;
import com.tencent.mm.vfs.i;
import java.io.IOException;
import java.util.HashMap;

public final class a
  implements com.tencent.mm.al.g, t.a
{
  private static int BAG = 1048576;
  private static int BAH = 26214400;
  private bn BAI;
  private HashMap<String, bl> BAJ;
  
  public a()
  {
    AppMethodBeat.i(30159);
    this.BAJ = new HashMap();
    this.BAI = new bn();
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.g.afC();
    localObject = i.aR(com.tencent.mm.kernel.g.afB().cachePath + "syncmsgid.ini", 0, -1);
    if (!bt.cw((byte[])localObject)) {}
    try
    {
      this.BAI.parseFrom((byte[])localObject);
      o.aCI().a(this, Looper.getMainLooper());
      com.tencent.mm.kernel.g.aeS().a(221, this);
      AppMethodBeat.o(30159);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.w("MicroMsg.MultiTerminalSyncMgr", "task parse Error");
      }
    }
  }
  
  private void cos()
  {
    AppMethodBeat.i(30163);
    try
    {
      byte[] arrayOfByte = this.BAI.toByteArray();
      StringBuilder localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.g.afC();
      i.f(com.tencent.mm.kernel.g.afB().cachePath + "syncmsgid.ini", arrayOfByte, arrayOfByte.length);
      AppMethodBeat.o(30163);
      return;
    }
    catch (IOException localIOException)
    {
      ad.w("MicroMsg.MultiTerminalSyncMgr", "task to file Error");
      AppMethodBeat.o(30163);
    }
  }
  
  public final void a(t.a.a parama)
  {
    AppMethodBeat.i(30164);
    parama = (bl)this.BAJ.get(parama.fileName);
    if (parama == null)
    {
      AppMethodBeat.o(30164);
      return;
    }
    s locals = u.Ae(parama.field_imgPath);
    if (locals == null)
    {
      AppMethodBeat.o(30164);
      return;
    }
    if ((parama.eMl()) || (locals.status == 199))
    {
      ad.i("MicroMsg.MultiTerminalSyncMgr", "download video end: %d, status:%d", new Object[] { Long.valueOf(parama.field_msgId), Integer.valueOf(locals.status) });
      vd(parama.field_msgId);
      this.BAJ.remove(parama.field_imgPath);
      AppMethodBeat.o(30164);
      return;
    }
    if (parama.field_status == 198) {
      this.BAJ.remove(parama.field_imgPath);
    }
    AppMethodBeat.o(30164);
  }
  
  public final void erV()
  {
    AppMethodBeat.i(30162);
    new ap(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(30157);
        a.a(a.this);
        AppMethodBeat.o(30157);
      }
    });
    AppMethodBeat.o(30162);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(30165);
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramn instanceof com.tencent.mm.plugin.record.b.e)))
    {
      long l = ((com.tencent.mm.plugin.record.b.e)paramn).msgId;
      vd(l);
      ad.i("MicroMsg.MultiTerminalSyncMgr", "download attach end: %d", new Object[] { Long.valueOf(l) });
    }
    AppMethodBeat.o(30165);
  }
  
  public final void vc(final long paramLong)
  {
    AppMethodBeat.i(30160);
    az.arV();
    if (!((Boolean)c.afk().get(ae.a.Fnm, Boolean.TRUE)).booleanValue())
    {
      ad.i("MicroMsg.MultiTerminalSyncMgr", "autoSyncState close");
      AppMethodBeat.o(30160);
      return;
    }
    new ap(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(30155);
        a.a(a.this, paramLong);
        AppMethodBeat.o(30155);
      }
    });
    AppMethodBeat.o(30160);
  }
  
  public final void vd(final long paramLong)
  {
    AppMethodBeat.i(30161);
    new ap(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(30156);
        a.b(a.this, paramLong);
        AppMethodBeat.o(30156);
      }
    });
    AppMethodBeat.o(30161);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.a.a
 * JD-Core Version:    0.7.0.1
 */