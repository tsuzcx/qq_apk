package com.tencent.mm.plugin.webwx.a;

import android.os.Looper;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.t.a;
import com.tencent.mm.modelvideo.t.a.a;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.pluginsdk.model.app.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import java.io.IOException;
import java.util.HashMap;

public final class a
  implements f, t.a
{
  private static int rDA = 1048576;
  private static int rDB = 26214400;
  private com.tencent.mm.storage.bk rDC = new com.tencent.mm.storage.bk();
  private HashMap<String, bi> rDD = new HashMap();
  
  public a()
  {
    Object localObject = new StringBuilder();
    g.DQ();
    localObject = com.tencent.mm.a.e.d(g.DP().cachePath + "syncmsgid.ini", 0, -1);
    if (!com.tencent.mm.sdk.platformtools.bk.bE((byte[])localObject)) {}
    try
    {
      this.rDC.aH((byte[])localObject);
      o.Sr().a(this, Looper.getMainLooper());
      g.Dk().a(221, this);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.w("MicroMsg.MultiTerminalSyncMgr", "task parse Error");
      }
    }
  }
  
  private void cgY()
  {
    try
    {
      byte[] arrayOfByte = this.rDC.toByteArray();
      StringBuilder localStringBuilder = new StringBuilder();
      g.DQ();
      com.tencent.mm.a.e.b(g.DP().cachePath + "syncmsgid.ini", arrayOfByte, arrayOfByte.length);
      return;
    }
    catch (IOException localIOException)
    {
      y.w("MicroMsg.MultiTerminalSyncMgr", "task to file Error");
    }
  }
  
  public final void a(t.a.a parama)
  {
    parama = (bi)this.rDD.get(parama.fileName);
    if (parama == null) {}
    do
    {
      s locals;
      do
      {
        return;
        locals = u.oe(parama.field_imgPath);
      } while (locals == null);
      if ((parama.cvx()) || (locals.status == 199))
      {
        y.i("MicroMsg.MultiTerminalSyncMgr", "download video end: %d, status:%d", new Object[] { Long.valueOf(parama.field_msgId), Integer.valueOf(locals.status) });
        gV(parama.field_msgId);
        this.rDD.remove(parama.field_imgPath);
        return;
      }
    } while (parama.field_status != 198);
    this.rDD.remove(parama.field_imgPath);
  }
  
  public final void cgX()
  {
    new ah(Looper.getMainLooper()).post(new a.3(this));
  }
  
  public final void gU(final long paramLong)
  {
    au.Hx();
    if (!((Boolean)c.Dz().get(ac.a.uuD, Boolean.valueOf(true))).booleanValue())
    {
      y.i("MicroMsg.MultiTerminalSyncMgr", "autoSyncState close");
      return;
    }
    new ah(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        a.a(a.this, paramLong);
      }
    });
  }
  
  public final void gV(long paramLong)
  {
    new ah(Looper.getMainLooper()).post(new a.2(this, paramLong));
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramm instanceof ac)))
    {
      long l = ((ac)paramm).bIt;
      gV(l);
      y.i("MicroMsg.MultiTerminalSyncMgr", "download attach end: %d", new Object[] { Long.valueOf(l) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.a.a
 * JD-Core Version:    0.7.0.1
 */