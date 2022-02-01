package com.tencent.mm.plugin.webwx.a;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.aw.e.a;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ba;
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
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.bw;
import com.tencent.mm.vfs.i;
import java.io.IOException;
import java.util.HashMap;

public final class a
  implements com.tencent.mm.al.f, t.a
{
  private static int EwO = 1048576;
  private static int EwP = 26214400;
  private bw EwQ;
  private HashMap<String, bu> EwR;
  
  public a()
  {
    AppMethodBeat.i(30159);
    this.EwR = new HashMap();
    this.EwQ = new bw();
    Object localObject = new StringBuilder();
    g.ajD();
    localObject = i.aY(g.ajC().cachePath + "syncmsgid.ini", 0, -1);
    if (!bt.cC((byte[])localObject)) {}
    try
    {
      this.EwQ.parseFrom((byte[])localObject);
      o.aMJ().a(this, Looper.getMainLooper());
      g.aiU().a(221, this);
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
  
  private void cEM()
  {
    AppMethodBeat.i(30163);
    try
    {
      byte[] arrayOfByte = this.EwQ.toByteArray();
      StringBuilder localStringBuilder = new StringBuilder();
      g.ajD();
      i.f(g.ajC().cachePath + "syncmsgid.ini", arrayOfByte, arrayOfByte.length);
      AppMethodBeat.o(30163);
      return;
    }
    catch (IOException localIOException)
    {
      ad.w("MicroMsg.MultiTerminalSyncMgr", "task to file Error");
      AppMethodBeat.o(30163);
    }
  }
  
  public final void Cu(final long paramLong)
  {
    AppMethodBeat.i(30160);
    ba.aBQ();
    if (!((Boolean)c.ajl().get(al.a.Ixt, Boolean.TRUE)).booleanValue())
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
  
  public final void Cv(final long paramLong)
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
  
  public final void a(t.a.a parama)
  {
    AppMethodBeat.i(30164);
    parama = (bu)this.EwR.get(parama.fileName);
    if (parama == null)
    {
      AppMethodBeat.o(30164);
      return;
    }
    s locals = u.Hy(parama.field_imgPath);
    if (locals == null)
    {
      AppMethodBeat.o(30164);
      return;
    }
    if ((parama.frT()) || (locals.status == 199))
    {
      ad.i("MicroMsg.MultiTerminalSyncMgr", "download video end: %d, status:%d", new Object[] { Long.valueOf(parama.field_msgId), Integer.valueOf(locals.status) });
      Cv(parama.field_msgId);
      this.EwR.remove(parama.field_imgPath);
      AppMethodBeat.o(30164);
      return;
    }
    if (parama.field_status == 198) {
      this.EwR.remove(parama.field_imgPath);
    }
    AppMethodBeat.o(30164);
  }
  
  public final void eWi()
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
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramn instanceof com.tencent.mm.plugin.record.b.f)))
    {
      long l = ((com.tencent.mm.plugin.record.b.f)paramn).msgId;
      Cv(l);
      ad.i("MicroMsg.MultiTerminalSyncMgr", "download attach end: %d", new Object[] { Long.valueOf(l) });
    }
    AppMethodBeat.o(30165);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.a.a
 * JD-Core Version:    0.7.0.1
 */