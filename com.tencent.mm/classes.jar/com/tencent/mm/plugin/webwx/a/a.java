package com.tencent.mm.plugin.webwx.a;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.t.a;
import com.tencent.mm.modelvideo.t.a.a;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.z;
import java.io.IOException;
import java.util.HashMap;

public final class a
  implements f, t.a
{
  private static int vuc = 1048576;
  private static int vud = 26214400;
  private bk vue;
  private HashMap<String, bi> vuf;
  
  public a()
  {
    AppMethodBeat.i(26484);
    this.vuf = new HashMap();
    this.vue = new bk();
    Object localObject = new StringBuilder();
    g.RM();
    localObject = com.tencent.mm.a.e.j(g.RL().cachePath + "syncmsgid.ini", 0, -1);
    if (!bo.ce((byte[])localObject)) {}
    try
    {
      this.vue.parseFrom((byte[])localObject);
      o.alE().a(this, Looper.getMainLooper());
      g.Rc().a(221, this);
      AppMethodBeat.o(26484);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.w("MicroMsg.MultiTerminalSyncMgr", "task parse Error");
      }
    }
  }
  
  private void dhg()
  {
    AppMethodBeat.i(26488);
    try
    {
      byte[] arrayOfByte = this.vue.toByteArray();
      StringBuilder localStringBuilder = new StringBuilder();
      g.RM();
      com.tencent.mm.a.e.b(g.RL().cachePath + "syncmsgid.ini", arrayOfByte, arrayOfByte.length);
      AppMethodBeat.o(26488);
      return;
    }
    catch (IOException localIOException)
    {
      ab.w("MicroMsg.MultiTerminalSyncMgr", "task to file Error");
      AppMethodBeat.o(26488);
    }
  }
  
  public final void a(t.a.a parama)
  {
    AppMethodBeat.i(26489);
    parama = (bi)this.vuf.get(parama.fileName);
    if (parama == null)
    {
      AppMethodBeat.o(26489);
      return;
    }
    s locals = u.vr(parama.field_imgPath);
    if (locals == null)
    {
      AppMethodBeat.o(26489);
      return;
    }
    if ((parama.dyc()) || (locals.status == 199))
    {
      ab.i("MicroMsg.MultiTerminalSyncMgr", "download video end: %d, status:%d", new Object[] { Long.valueOf(parama.field_msgId), Integer.valueOf(locals.status) });
      ns(parama.field_msgId);
      this.vuf.remove(parama.field_imgPath);
      AppMethodBeat.o(26489);
      return;
    }
    if (parama.field_status == 198) {
      this.vuf.remove(parama.field_imgPath);
    }
    AppMethodBeat.o(26489);
  }
  
  public final void dhf()
  {
    AppMethodBeat.i(26487);
    new ak(Looper.getMainLooper()).post(new a.3(this));
    AppMethodBeat.o(26487);
  }
  
  public final void nr(final long paramLong)
  {
    AppMethodBeat.i(26485);
    aw.aaz();
    if (!((Boolean)c.Ru().get(ac.a.yEG, Boolean.TRUE)).booleanValue())
    {
      ab.i("MicroMsg.MultiTerminalSyncMgr", "autoSyncState close");
      AppMethodBeat.o(26485);
      return;
    }
    new ak(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(26480);
        a.a(a.this, paramLong);
        AppMethodBeat.o(26480);
      }
    });
    AppMethodBeat.o(26485);
  }
  
  public final void ns(long paramLong)
  {
    AppMethodBeat.i(26486);
    new ak(Looper.getMainLooper()).post(new a.2(this, paramLong));
    AppMethodBeat.o(26486);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(26490);
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramm instanceof com.tencent.mm.plugin.record.b.e)))
    {
      long l = ((com.tencent.mm.plugin.record.b.e)paramm).cpO;
      ns(l);
      ab.i("MicroMsg.MultiTerminalSyncMgr", "download attach end: %d", new Object[] { Long.valueOf(l) });
    }
    AppMethodBeat.o(26490);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.a.a
 * JD-Core Version:    0.7.0.1
 */