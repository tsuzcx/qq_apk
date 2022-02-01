package com.tencent.mm.plugin.webwx.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.modelimage.f.a;
import com.tencent.mm.modelvideo.aa;
import com.tencent.mm.modelvideo.aa.a;
import com.tencent.mm.modelvideo.aa.a.a;
import com.tencent.mm.modelvideo.ab;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.modelvideo.z;
import com.tencent.mm.plugin.record.model.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storage.ce;
import com.tencent.mm.vfs.y;
import java.io.IOException;
import java.util.HashMap;

public final class a
  implements com.tencent.mm.am.h, aa.a
{
  private static int XwF = 1048576;
  private static int XwG = 26214400;
  private ce XwH;
  private HashMap<String, cc> XwI;
  
  public a()
  {
    AppMethodBeat.i(30159);
    this.XwI = new HashMap();
    this.XwH = new ce();
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.h.baF();
    localObject = y.bi(com.tencent.mm.kernel.h.baE().cachePath + "syncmsgid.ini", 0, -1);
    if (!Util.isNullOrNil((byte[])localObject)) {}
    try
    {
      this.XwH.parseFrom((byte[])localObject);
      v.bOh().a(this, Looper.getMainLooper());
      com.tencent.mm.kernel.h.aZW().a(221, this);
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
  
  private void eDv()
  {
    AppMethodBeat.i(30163);
    try
    {
      byte[] arrayOfByte = this.XwH.toByteArray();
      StringBuilder localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.h.baF();
      y.f(com.tencent.mm.kernel.h.baE().cachePath + "syncmsgid.ini", arrayOfByte, arrayOfByte.length);
      AppMethodBeat.o(30163);
      return;
    }
    catch (IOException localIOException)
    {
      Log.w("MicroMsg.MultiTerminalSyncMgr", "task to file Error");
      AppMethodBeat.o(30163);
    }
  }
  
  public final void a(aa.a.a parama)
  {
    AppMethodBeat.i(30164);
    parama = (cc)this.XwI.get(parama.fileName);
    if (parama == null)
    {
      AppMethodBeat.o(30164);
      return;
    }
    z localz = ab.Qo(parama.field_imgPath);
    if (localz == null)
    {
      AppMethodBeat.o(30164);
      return;
    }
    if ((parama.isClean()) || (localz.status == 199))
    {
      Log.i("MicroMsg.MultiTerminalSyncMgr", "download video end: %d, status:%d", new Object[] { Long.valueOf(parama.field_msgId), Integer.valueOf(localz.status) });
      xS(parama.field_msgId);
      this.XwI.remove(parama.field_imgPath);
      AppMethodBeat.o(30164);
      return;
    }
    if (parama.field_status == 198) {
      this.XwI.remove(parama.field_imgPath);
    }
    AppMethodBeat.o(30164);
  }
  
  public final void iDt()
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
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(30165);
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramp instanceof g)))
    {
      long l = ((g)paramp).msgId;
      xS(l);
      Log.i("MicroMsg.MultiTerminalSyncMgr", "download attach end: %d", new Object[] { Long.valueOf(l) });
    }
    AppMethodBeat.o(30165);
  }
  
  public final void xR(final long paramLong)
  {
    AppMethodBeat.i(30160);
    bh.bCz();
    if (!((Boolean)c.ban().get(at.a.acPp, Boolean.TRUE)).booleanValue())
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
  
  public final void xS(final long paramLong)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.model.a
 * JD-Core Version:    0.7.0.1
 */