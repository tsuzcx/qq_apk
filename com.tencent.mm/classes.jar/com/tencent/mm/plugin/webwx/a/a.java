package com.tencent.mm.plugin.webwx.a;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.av.e.a;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.t.a;
import com.tencent.mm.modelvideo.t.a.a;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bx;
import java.io.IOException;
import java.util.HashMap;

public final class a
  implements com.tencent.mm.ak.f, t.a
{
  private static int EPk = 1048576;
  private static int EPl = 26214400;
  private bx EPm;
  private HashMap<String, bv> EPn;
  
  public a()
  {
    AppMethodBeat.i(30159);
    this.EPn = new HashMap();
    this.EPm = new bx();
    Object localObject = new StringBuilder();
    g.ajS();
    localObject = com.tencent.mm.vfs.o.bb(g.ajR().cachePath + "syncmsgid.ini", 0, -1);
    if (!bu.cF((byte[])localObject)) {}
    try
    {
      this.EPm.parseFrom((byte[])localObject);
      com.tencent.mm.modelvideo.o.aNh().a(this, Looper.getMainLooper());
      g.ajj().a(221, this);
      AppMethodBeat.o(30159);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.w("MicroMsg.MultiTerminalSyncMgr", "task parse Error");
      }
    }
  }
  
  private void cGI()
  {
    AppMethodBeat.i(30163);
    try
    {
      byte[] arrayOfByte = this.EPm.toByteArray();
      StringBuilder localStringBuilder = new StringBuilder();
      g.ajS();
      com.tencent.mm.vfs.o.f(g.ajR().cachePath + "syncmsgid.ini", arrayOfByte, arrayOfByte.length);
      AppMethodBeat.o(30163);
      return;
    }
    catch (IOException localIOException)
    {
      ae.w("MicroMsg.MultiTerminalSyncMgr", "task to file Error");
      AppMethodBeat.o(30163);
    }
  }
  
  public final void CS(final long paramLong)
  {
    AppMethodBeat.i(30160);
    bc.aCg();
    if (!((Boolean)c.ajA().get(am.a.IRR, Boolean.TRUE)).booleanValue())
    {
      ae.i("MicroMsg.MultiTerminalSyncMgr", "autoSyncState close");
      AppMethodBeat.o(30160);
      return;
    }
    new aq(Looper.getMainLooper()).post(new Runnable()
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
  
  public final void CT(final long paramLong)
  {
    AppMethodBeat.i(30161);
    new aq(Looper.getMainLooper()).post(new Runnable()
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
  
  public final void a(t.a.a parama)
  {
    AppMethodBeat.i(30164);
    parama = (bv)this.EPn.get(parama.fileName);
    if (parama == null)
    {
      AppMethodBeat.o(30164);
      return;
    }
    s locals = u.Ia(parama.field_imgPath);
    if (locals == null)
    {
      AppMethodBeat.o(30164);
      return;
    }
    if ((parama.fvU()) || (locals.status == 199))
    {
      ae.i("MicroMsg.MultiTerminalSyncMgr", "download video end: %d, status:%d", new Object[] { Long.valueOf(parama.field_msgId), Integer.valueOf(locals.status) });
      CT(parama.field_msgId);
      this.EPn.remove(parama.field_imgPath);
      AppMethodBeat.o(30164);
      return;
    }
    if (parama.field_status == 198) {
      this.EPn.remove(parama.field_imgPath);
    }
    AppMethodBeat.o(30164);
  }
  
  public final void eZU()
  {
    AppMethodBeat.i(30162);
    new aq(Looper.getMainLooper()).post(new Runnable()
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
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramn instanceof com.tencent.mm.plugin.record.b.f)))
    {
      long l = ((com.tencent.mm.plugin.record.b.f)paramn).msgId;
      CT(l);
      ae.i("MicroMsg.MultiTerminalSyncMgr", "download attach end: %d", new Object[] { Long.valueOf(l) });
    }
    AppMethodBeat.o(30165);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.a.a
 * JD-Core Version:    0.7.0.1
 */