package com.tencent.mm.plugin.webwx.a;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.av.d.a;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.t.a;
import com.tencent.mm.modelvideo.t.a.a;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.bq;
import com.tencent.mm.vfs.i;
import java.io.IOException;
import java.util.HashMap;

public final class a
  implements com.tencent.mm.ak.g, t.a
{
  private static int CSN = 1048576;
  private static int CSO = 26214400;
  private bq CSP;
  private HashMap<String, bo> CSQ;
  
  public a()
  {
    AppMethodBeat.i(30159);
    this.CSQ = new HashMap();
    this.CSP = new bq();
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.g.agS();
    localObject = i.aU(com.tencent.mm.kernel.g.agR().cachePath + "syncmsgid.ini", 0, -1);
    if (!bs.cv((byte[])localObject)) {}
    try
    {
      this.CSP.parseFrom((byte[])localObject);
      o.aJy().a(this, Looper.getMainLooper());
      com.tencent.mm.kernel.g.agi().a(221, this);
      AppMethodBeat.o(30159);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.w("MicroMsg.MultiTerminalSyncMgr", "task parse Error");
      }
    }
  }
  
  private void cxP()
  {
    AppMethodBeat.i(30163);
    try
    {
      byte[] arrayOfByte = this.CSP.toByteArray();
      StringBuilder localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.g.agS();
      i.f(com.tencent.mm.kernel.g.agR().cachePath + "syncmsgid.ini", arrayOfByte, arrayOfByte.length);
      AppMethodBeat.o(30163);
      return;
    }
    catch (IOException localIOException)
    {
      ac.w("MicroMsg.MultiTerminalSyncMgr", "task to file Error");
      AppMethodBeat.o(30163);
    }
  }
  
  public final void a(t.a.a parama)
  {
    AppMethodBeat.i(30164);
    parama = (bo)this.CSQ.get(parama.fileName);
    if (parama == null)
    {
      AppMethodBeat.o(30164);
      return;
    }
    s locals = u.Ej(parama.field_imgPath);
    if (locals == null)
    {
      AppMethodBeat.o(30164);
      return;
    }
    if ((parama.fbQ()) || (locals.status == 199))
    {
      ac.i("MicroMsg.MultiTerminalSyncMgr", "download video end: %d, status:%d", new Object[] { Long.valueOf(parama.field_msgId), Integer.valueOf(locals.status) });
      zG(parama.field_msgId);
      this.CSQ.remove(parama.field_imgPath);
      AppMethodBeat.o(30164);
      return;
    }
    if (parama.field_status == 198) {
      this.CSQ.remove(parama.field_imgPath);
    }
    AppMethodBeat.o(30164);
  }
  
  public final void eHp()
  {
    AppMethodBeat.i(30162);
    new ao(Looper.getMainLooper()).post(new Runnable()
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
      zG(l);
      ac.i("MicroMsg.MultiTerminalSyncMgr", "download attach end: %d", new Object[] { Long.valueOf(l) });
    }
    AppMethodBeat.o(30165);
  }
  
  public final void zF(final long paramLong)
  {
    AppMethodBeat.i(30160);
    az.ayM();
    if (!((Boolean)c.agA().get(ah.a.GLb, Boolean.TRUE)).booleanValue())
    {
      ac.i("MicroMsg.MultiTerminalSyncMgr", "autoSyncState close");
      AppMethodBeat.o(30160);
      return;
    }
    new ao(Looper.getMainLooper()).post(new Runnable()
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
  
  public final void zG(final long paramLong)
  {
    AppMethodBeat.i(30161);
    new ao(Looper.getMainLooper()).post(new Runnable()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.a.a
 * JD-Core Version:    0.7.0.1
 */