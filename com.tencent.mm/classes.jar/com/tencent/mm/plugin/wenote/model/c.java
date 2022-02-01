package com.tencent.mm.plugin.wenote.model;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cm;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bz;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.ao;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storagebase.h.b;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;

public final class c
  implements aw
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private com.tencent.mm.plugin.wenote.a.b CUC;
  private com.tencent.mm.plugin.wenote.a.c CUD;
  private com.tencent.mm.plugin.wenote.a.a CUE;
  private com.tencent.mm.sdk.b.c<cm> CUF;
  public d CUG;
  private com.tencent.mm.sdk.b.c ney;
  
  static
  {
    AppMethodBeat.i(30297);
    baseDBFactories = new HashMap();
    AppMethodBeat.o(30297);
  }
  
  public c()
  {
    AppMethodBeat.i(30293);
    this.CUC = new com.tencent.mm.plugin.wenote.a.b();
    this.CUD = new com.tencent.mm.plugin.wenote.a.c();
    this.CUE = new com.tencent.mm.plugin.wenote.a.a();
    this.CUF = new c.1(this);
    this.CUG = null;
    this.ney = new c.2(this);
    AppMethodBeat.o(30293);
  }
  
  public static c eHP()
  {
    AppMethodBeat.i(30294);
    az.ayG();
    c localc2 = (c)bz.yz("plugin.wenote");
    c localc1 = localc2;
    if (localc2 == null)
    {
      localc1 = new c();
      az.ayG().a("plugin.wenote", localc1);
    }
    AppMethodBeat.o(30294);
    return localc1;
  }
  
  public final void clearPluginData(int paramInt) {}
  
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    Object localObject2 = null;
    AppMethodBeat.i(30295);
    ac.d("MicroMsg.SubCoreWNNoteMsg", "on account post reset");
    com.tencent.mm.sdk.b.a.GpY.c(this.CUC);
    ((com.tencent.mm.plugin.record.a.a)g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a(this.CUD);
    ((af)g.ad(af.class)).getFavCdnStorage().a(this.CUD);
    com.tencent.mm.sdk.b.a.GpY.c(this.CUE);
    com.tencent.mm.sdk.b.a.GpY.c(this.CUF);
    com.tencent.mm.sdk.b.a.GpY.c(this.ney);
    Object localObject1 = new com.tencent.mm.vfs.e(i.awX());
    if ((!((com.tencent.mm.vfs.e)localObject1).exists()) || (!((com.tencent.mm.vfs.e)localObject1).isDirectory()))
    {
      ac.d("MicroMsg.SubCoreWNNoteMsg", "record stg dir[%s] not exsit, create it");
      ((com.tencent.mm.vfs.e)localObject1).mkdirs();
    }
    Object localObject3 = new com.tencent.mm.vfs.e(ao.cpW());
    ac.i("MicroMsg.SubCoreWNNoteMsg", "copy to path %s", new Object[] { com.tencent.mm.vfs.q.B(((com.tencent.mm.vfs.e)localObject3).fxV()) });
    if (com.tencent.mm.protocal.d.DIf)
    {
      ac.i("MicroMsg.SubCoreWNNoteMsg", "copyAssertTemplateFile develop version delete template");
      com.tencent.mm.vfs.i.cU(com.tencent.mm.vfs.q.B(((com.tencent.mm.vfs.e)localObject3).mUri), true);
      if (!((com.tencent.mm.vfs.e)localObject3).exists()) {
        ((com.tencent.mm.vfs.e)localObject3).mkdirs();
      }
      localObject1 = ai.getContext().getAssets();
    }
    for (;;)
    {
      Closeable localCloseable;
      com.tencent.mm.vfs.e locale;
      try
      {
        localObject1 = ((AssetManager)localObject1).open("WNNote.zip");
        if (localObject1 == null)
        {
          ac.e("MicroMsg.SubCoreWNNoteMsg", "file inputStream not found");
          com.tencent.mm.plugin.wenote.b.b.bdf();
          AppMethodBeat.o(30295);
          return;
          ao.qJR = ao.aEh();
          if (paramBoolean)
          {
            i = ao.aEi();
            ac.i("MicroMsg.SubCoreWNNoteMsg", "copyAssertTemplateFile need update assetVersion=%d currentVersion=%d", new Object[] { Integer.valueOf(i), Integer.valueOf(ao.qJR) });
            if (ao.qJR >= i) {
              break;
            }
            com.tencent.mm.vfs.i.cU(com.tencent.mm.vfs.q.B(((com.tencent.mm.vfs.e)localObject3).mUri), true);
            break;
          }
          if (ao.qJR == 1)
          {
            ac.i("MicroMsg.SubCoreWNNoteMsg", "copyAssertTemplateFile need init template");
            com.tencent.mm.vfs.i.cU(com.tencent.mm.vfs.q.B(((com.tencent.mm.vfs.e)localObject3).mUri), true);
            break;
          }
          ac.i("MicroMsg.SubCoreWNNoteMsg", "copyAssertTemplateFile currentVersion=%d", new Object[] { Integer.valueOf(ao.qJR) });
        }
      }
      catch (IOException localIOException1)
      {
        ac.printErrStackTrace("MicroMsg.SubCoreWNNoteMsg", localIOException1, "", new Object[0]);
        localCloseable = null;
        continue;
        locale = new com.tencent.mm.vfs.e((com.tencent.mm.vfs.e)localObject3, "WNNote.zip");
        if (locale.exists())
        {
          ac.i("MicroMsg.SubCoreWNNoteMsg", "wenote template already exists");
          bs.d(localCloseable);
          continue;
        }
      }
      try
      {
        localObject3 = com.tencent.mm.vfs.i.ah(locale);
        localObject2 = localObject3;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        for (;;)
        {
          ac.printErrStackTrace("MicroMsg.SubCoreWNNoteMsg", localFileNotFoundException, "", new Object[0]);
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
          bs.d(localCloseable);
        }
        catch (IOException localIOException2)
        {
          ac.printErrStackTrace("MicroMsg.SubCoreWNNoteMsg", localIOException2, "", new Object[0]);
        }
      }
      bs.d(localObject2);
      int i = com.tencent.mm.vfs.i.fp(com.tencent.mm.vfs.q.B(locale.fxV()), locale.getParent());
      if (i < 0) {
        ac.e("MicroMsg.SubCoreWNNoteMsg", "unzip fail, ret = " + i + ", zipFilePath = " + com.tencent.mm.vfs.q.B(locale.fxV()) + ", unzipPath = " + locale.getParent());
      }
    }
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(30296);
    ac.d("MicroMsg.SubCoreWNNoteMsg", "on account post release");
    com.tencent.mm.sdk.b.a.GpY.d(this.CUC);
    if (((com.tencent.mm.plugin.record.a.a)g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage() != null) {
      ((com.tencent.mm.plugin.record.a.a)g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(this.CUD);
    }
    if (((af)g.ad(af.class)).getFavCdnStorage() != null) {
      ((af)g.ad(af.class)).getFavCdnStorage().b(this.CUD);
    }
    com.tencent.mm.sdk.b.a.GpY.d(this.CUE);
    com.tencent.mm.sdk.b.a.GpY.d(this.CUF);
    com.tencent.mm.sdk.b.a.GpY.d(this.ney);
    com.tencent.mm.plugin.wenote.b.b.bdg();
    AppMethodBeat.o(30296);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.c
 * JD-Core Version:    0.7.0.1
 */