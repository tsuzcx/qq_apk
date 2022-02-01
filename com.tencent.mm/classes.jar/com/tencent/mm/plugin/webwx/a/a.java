package com.tencent.mm.plugin.webwx.a;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.av.e.a;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t.a;
import com.tencent.mm.modelvideo.t.a.a;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.record.b.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.cc;
import java.io.IOException;
import java.util.HashMap;

public final class a
  implements i, t.a
{
  private static int JEZ = 1048576;
  private static int JFa = 26214400;
  private cc JFb;
  private HashMap<String, ca> JFc;
  
  public a()
  {
    AppMethodBeat.i(30159);
    this.JFc = new HashMap();
    this.JFb = new cc();
    Object localObject = new StringBuilder();
    g.aAi();
    localObject = com.tencent.mm.vfs.s.aW(g.aAh().cachePath + "syncmsgid.ini", 0, -1);
    if (!Util.isNullOrNil((byte[])localObject)) {}
    try
    {
      this.JFb.parseFrom((byte[])localObject);
      o.bhj().a(this, Looper.getMainLooper());
      g.azz().a(221, this);
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
  
  private void dpX()
  {
    AppMethodBeat.i(30163);
    try
    {
      byte[] arrayOfByte = this.JFb.toByteArray();
      StringBuilder localStringBuilder = new StringBuilder();
      g.aAi();
      com.tencent.mm.vfs.s.f(g.aAh().cachePath + "syncmsgid.ini", arrayOfByte, arrayOfByte.length);
      AppMethodBeat.o(30163);
      return;
    }
    catch (IOException localIOException)
    {
      Log.w("MicroMsg.MultiTerminalSyncMgr", "task to file Error");
      AppMethodBeat.o(30163);
    }
  }
  
  public final void Mh(final long paramLong)
  {
    AppMethodBeat.i(30160);
    bg.aVF();
    if (!((Boolean)c.azQ().get(ar.a.NZT, Boolean.TRUE)).booleanValue())
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
  
  public final void Mi(final long paramLong)
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
  
  public final void a(t.a.a parama)
  {
    AppMethodBeat.i(30164);
    parama = (ca)this.JFc.get(parama.fileName);
    if (parama == null)
    {
      AppMethodBeat.o(30164);
      return;
    }
    com.tencent.mm.modelvideo.s locals = u.QN(parama.field_imgPath);
    if (locals == null)
    {
      AppMethodBeat.o(30164);
      return;
    }
    if ((parama.gDB()) || (locals.status == 199))
    {
      Log.i("MicroMsg.MultiTerminalSyncMgr", "download video end: %d, status:%d", new Object[] { Long.valueOf(parama.field_msgId), Integer.valueOf(locals.status) });
      Mi(parama.field_msgId);
      this.JFc.remove(parama.field_imgPath);
      AppMethodBeat.o(30164);
      return;
    }
    if (parama.field_status == 198) {
      this.JFc.remove(parama.field_imgPath);
    }
    AppMethodBeat.o(30164);
  }
  
  public final void gja()
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
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramq instanceof f)))
    {
      long l = ((f)paramq).msgId;
      Mi(l);
      Log.i("MicroMsg.MultiTerminalSyncMgr", "download attach end: %d", new Object[] { Long.valueOf(l) });
    }
    AppMethodBeat.o(30165);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.a.a
 * JD-Core Version:    0.7.0.1
 */