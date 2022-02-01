package com.tencent.mm.plugin.webwx.a;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.ay.e.a;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.w;
import com.tencent.mm.modelvideo.x;
import com.tencent.mm.modelvideo.x.a;
import com.tencent.mm.modelvideo.x.a.a;
import com.tencent.mm.modelvideo.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.cc;
import com.tencent.mm.vfs.u;
import java.io.IOException;
import java.util.HashMap;

public final class a
  implements i, x.a
{
  private static int QDN = 1048576;
  private static int QDO = 26214400;
  private cc QDP;
  private HashMap<String, ca> QDQ;
  
  public a()
  {
    AppMethodBeat.i(30159);
    this.QDQ = new HashMap();
    this.QDP = new cc();
    Object localObject = new StringBuilder();
    h.aHH();
    localObject = u.aY(h.aHG().cachePath + "syncmsgid.ini", 0, -1);
    if (!Util.isNullOrNil((byte[])localObject)) {}
    try
    {
      this.QDP.parseFrom((byte[])localObject);
      s.bqB().a(this, Looper.getMainLooper());
      h.aGY().a(221, this);
      AppMethodBeat.o(30159);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.w("MicroMsg.MultiTerminalSyncMgr", "task parse Error");
      }
    }
  }
  
  private void dRe()
  {
    AppMethodBeat.i(30163);
    try
    {
      byte[] arrayOfByte = this.QDP.toByteArray();
      StringBuilder localStringBuilder = new StringBuilder();
      h.aHH();
      u.f(h.aHG().cachePath + "syncmsgid.ini", arrayOfByte, arrayOfByte.length);
      AppMethodBeat.o(30163);
      return;
    }
    catch (IOException localIOException)
    {
      Log.w("MicroMsg.MultiTerminalSyncMgr", "task to file Error");
      AppMethodBeat.o(30163);
    }
  }
  
  public final void TH(final long paramLong)
  {
    AppMethodBeat.i(30160);
    bh.beI();
    if (!((Boolean)c.aHp().get(ar.a.VnU, Boolean.TRUE)).booleanValue())
    {
      Log.i("MicroMsg.MultiTerminalSyncMgr", "autoSyncState close");
      AppMethodBeat.o(30160);
      return;
    }
    new MMHandler(Looper.getMainLooper()).post(new Runnable()
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
  
  public final void TI(final long paramLong)
  {
    AppMethodBeat.i(30161);
    new MMHandler(Looper.getMainLooper()).post(new Runnable()
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
  
  public final void a(x.a.a parama)
  {
    AppMethodBeat.i(30164);
    parama = (ca)this.QDQ.get(parama.fileName);
    if (parama == null)
    {
      AppMethodBeat.o(30164);
      return;
    }
    w localw = y.Yk(parama.field_imgPath);
    if (localw == null)
    {
      AppMethodBeat.o(30164);
      return;
    }
    if ((parama.Ic()) || (localw.status == 199))
    {
      Log.i("MicroMsg.MultiTerminalSyncMgr", "download video end: %d, status:%d", new Object[] { Long.valueOf(parama.field_msgId), Integer.valueOf(localw.status) });
      TI(parama.field_msgId);
      this.QDQ.remove(parama.field_imgPath);
      AppMethodBeat.o(30164);
      return;
    }
    if (parama.field_status == 198) {
      this.QDQ.remove(parama.field_imgPath);
    }
    AppMethodBeat.o(30164);
  }
  
  public final void hcL()
  {
    AppMethodBeat.i(30162);
    new MMHandler(Looper.getMainLooper()).post(new Runnable()
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
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(30165);
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramq instanceof com.tencent.mm.plugin.record.b.f)))
    {
      long l = ((com.tencent.mm.plugin.record.b.f)paramq).msgId;
      TI(l);
      Log.i("MicroMsg.MultiTerminalSyncMgr", "download attach end: %d", new Object[] { Long.valueOf(l) });
    }
    AppMethodBeat.o(30165);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.a.a
 * JD-Core Version:    0.7.0.1
 */