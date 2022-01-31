package com.tencent.mm.plugin.wenote.model;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.mm.cf.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bu;
import com.tencent.mm.plugin.fav.a.an;
import com.tencent.mm.plugin.fav.a.q;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.j;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;

public final class c
  implements ar
{
  private static HashMap<Integer, h.d> dgp = new HashMap();
  private com.tencent.mm.sdk.b.c fAU = new c.1(this);
  private com.tencent.mm.plugin.wenote.a.b rFe = new com.tencent.mm.plugin.wenote.a.b();
  private com.tencent.mm.plugin.wenote.a.c rFf = new com.tencent.mm.plugin.wenote.a.c();
  private com.tencent.mm.plugin.wenote.a.a rFg = new com.tencent.mm.plugin.wenote.a.a();
  public d rFh = null;
  
  public static c chu()
  {
    au.Hq();
    c localc2 = (c)bu.iR("plugin.wenote");
    c localc1 = localc2;
    if (localc2 == null)
    {
      localc1 = new c();
      au.Hq().a("plugin.wenote", localc1);
    }
    return localc1;
  }
  
  public final void bh(boolean paramBoolean)
  {
    Object localObject2 = null;
    y.d("MicroMsg.SubCoreWNNoteMsg", "on account post reset");
    com.tencent.mm.sdk.b.a.udP.c(this.rFe);
    ((com.tencent.mm.plugin.record.a.a)g.t(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a(this.rFf);
    ((com.tencent.mm.plugin.fav.a.ae)g.t(com.tencent.mm.plugin.fav.a.ae.class)).getFavCdnStorage().a(this.rFf);
    com.tencent.mm.sdk.b.a.udP.c(this.rFg);
    com.tencent.mm.sdk.b.a.udP.c(this.fAU);
    Object localObject1 = new com.tencent.mm.vfs.b(i.FS());
    if ((!((com.tencent.mm.vfs.b)localObject1).exists()) || (!((com.tencent.mm.vfs.b)localObject1).isDirectory()))
    {
      y.d("MicroMsg.SubCoreWNNoteMsg", "record stg dir[%s] not exsit, create it");
      ((com.tencent.mm.vfs.b)localObject1).mkdirs();
    }
    Object localObject3 = new com.tencent.mm.vfs.b(an.aQK());
    y.i("MicroMsg.SubCoreWNNoteMsg", "copy to path %s", new Object[] { j.n(((com.tencent.mm.vfs.b)localObject3).cLr()) });
    if (com.tencent.mm.protocal.d.spd)
    {
      y.i("MicroMsg.SubCoreWNNoteMsg", "copyAssertTemplateFile develop version delete template");
      e.K(j.n(((com.tencent.mm.vfs.b)localObject3).mUri), true);
      if (!((com.tencent.mm.vfs.b)localObject3).exists()) {
        ((com.tencent.mm.vfs.b)localObject3).mkdirs();
      }
      localObject1 = com.tencent.mm.sdk.platformtools.ae.getContext().getAssets();
    }
    int i;
    com.tencent.mm.vfs.b localb;
    do
    {
      Closeable localCloseable;
      try
      {
        localObject1 = ((AssetManager)localObject1).open("WNNote.zip");
        if (localObject1 == null)
        {
          y.e("MicroMsg.SubCoreWNNoteMsg", "file inputStream not found");
          return;
          an.kah = an.NA();
          if (paramBoolean)
          {
            i = an.NB();
            y.i("MicroMsg.SubCoreWNNoteMsg", "copyAssertTemplateFile need update assetVersion=%d currentVersion=%d", new Object[] { Integer.valueOf(i), Integer.valueOf(an.kah) });
            if (an.kah >= i) {
              break;
            }
            e.K(j.n(((com.tencent.mm.vfs.b)localObject3).mUri), true);
            break;
          }
          if (an.kah == 1)
          {
            y.i("MicroMsg.SubCoreWNNoteMsg", "copyAssertTemplateFile need init template");
            e.K(j.n(((com.tencent.mm.vfs.b)localObject3).mUri), true);
            break;
          }
          y.i("MicroMsg.SubCoreWNNoteMsg", "copyAssertTemplateFile currentVersion=%d", new Object[] { Integer.valueOf(an.kah) });
        }
      }
      catch (IOException localIOException1)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.SubCoreWNNoteMsg", localIOException1, "", new Object[0]);
          localCloseable = null;
        }
        localb = new com.tencent.mm.vfs.b((com.tencent.mm.vfs.b)localObject3, "WNNote.zip");
        if (localb.exists())
        {
          y.i("MicroMsg.SubCoreWNNoteMsg", "wenote template already exists");
          bk.b(localCloseable);
          return;
        }
      }
      try
      {
        localObject3 = e.p(localb);
        localObject2 = localObject3;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.SubCoreWNNoteMsg", localFileNotFoundException, "", new Object[0]);
        }
      }
      if (localObject2 != null) {
        try
        {
          localObject3 = new byte[1024];
          for (;;)
          {
            i = localCloseable.read((byte[])localObject3);
            if (i == -1) {
              break;
            }
            localObject2.write((byte[])localObject3, 0, i);
          }
          bk.b(localCloseable);
        }
        catch (IOException localIOException2)
        {
          y.printErrStackTrace("MicroMsg.SubCoreWNNoteMsg", localIOException2, "", new Object[0]);
        }
      }
      bk.b(localObject2);
      i = e.gE(j.n(localb.cLr()), localb.getParent());
    } while (i >= 0);
    y.e("MicroMsg.SubCoreWNNoteMsg", "unzip fail, ret = " + i + ", zipFilePath = " + j.n(localb.cLr()) + ", unzipPath = " + localb.getParent());
  }
  
  public final void bi(boolean paramBoolean) {}
  
  public final void gf(int paramInt) {}
  
  public final void onAccountRelease()
  {
    y.d("MicroMsg.SubCoreWNNoteMsg", "on account post release");
    com.tencent.mm.sdk.b.a.udP.d(this.rFe);
    if (((com.tencent.mm.plugin.record.a.a)g.t(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage() != null) {
      ((com.tencent.mm.plugin.record.a.a)g.t(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(this.rFf);
    }
    if (((com.tencent.mm.plugin.fav.a.ae)g.t(com.tencent.mm.plugin.fav.a.ae.class)).getFavCdnStorage() != null) {
      ((com.tencent.mm.plugin.fav.a.ae)g.t(com.tencent.mm.plugin.fav.a.ae.class)).getFavCdnStorage().b(this.rFf);
    }
    com.tencent.mm.sdk.b.a.udP.d(this.rFg);
    com.tencent.mm.sdk.b.a.udP.d(this.fAU);
  }
  
  public final HashMap<Integer, h.d> xe()
  {
    return dgp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.c
 * JD-Core Version:    0.7.0.1
 */