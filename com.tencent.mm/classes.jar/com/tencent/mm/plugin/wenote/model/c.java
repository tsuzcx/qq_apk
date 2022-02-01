package com.tencent.mm.plugin.wenote.model;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cp;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.ca;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.ao;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storagebase.h.b;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;

public final class c
  implements ax
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private com.tencent.mm.plugin.wenote.a.c EyA;
  private com.tencent.mm.plugin.wenote.a.a EyB;
  private com.tencent.mm.sdk.b.c<cp> EyC;
  public d EyD;
  private com.tencent.mm.plugin.wenote.a.b Eyz;
  private com.tencent.mm.sdk.b.c nEU;
  
  static
  {
    AppMethodBeat.i(30297);
    baseDBFactories = new HashMap();
    AppMethodBeat.o(30297);
  }
  
  public c()
  {
    AppMethodBeat.i(30293);
    this.Eyz = new com.tencent.mm.plugin.wenote.a.b();
    this.EyA = new com.tencent.mm.plugin.wenote.a.c();
    this.EyB = new com.tencent.mm.plugin.wenote.a.a();
    this.EyC = new com.tencent.mm.sdk.b.c() {};
    this.EyD = null;
    this.nEU = new c.2(this);
    AppMethodBeat.o(30293);
  }
  
  public static c eWI()
  {
    AppMethodBeat.i(30294);
    ba.aBK();
    c localc2 = (c)ca.By("plugin.wenote");
    c localc1 = localc2;
    if (localc2 == null)
    {
      localc1 = new c();
      ba.aBK().a("plugin.wenote", localc1);
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
    ad.d("MicroMsg.SubCoreWNNoteMsg", "on account post reset");
    com.tencent.mm.sdk.b.a.IbL.c(this.Eyz);
    ((com.tencent.mm.plugin.record.a.a)g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a(this.EyA);
    ((af)g.ad(af.class)).getFavCdnStorage().a(this.EyA);
    com.tencent.mm.sdk.b.a.IbL.c(this.EyB);
    com.tencent.mm.sdk.b.a.IbL.c(this.EyC);
    com.tencent.mm.sdk.b.a.IbL.c(this.nEU);
    Object localObject1 = new com.tencent.mm.vfs.e(i.azM());
    if ((!((com.tencent.mm.vfs.e)localObject1).exists()) || (!((com.tencent.mm.vfs.e)localObject1).isDirectory()))
    {
      ad.d("MicroMsg.SubCoreWNNoteMsg", "record stg dir[%s] not exsit, create it");
      ((com.tencent.mm.vfs.e)localObject1).mkdirs();
    }
    Object localObject3 = new com.tencent.mm.vfs.e(ao.cvB());
    ad.i("MicroMsg.SubCoreWNNoteMsg", "copy to path %s", new Object[] { com.tencent.mm.vfs.q.B(((com.tencent.mm.vfs.e)localObject3).fOK()) });
    if (com.tencent.mm.protocal.d.Fnm)
    {
      ad.i("MicroMsg.SubCoreWNNoteMsg", "copyAssertTemplateFile develop version delete template");
      com.tencent.mm.vfs.i.cZ(com.tencent.mm.vfs.q.B(((com.tencent.mm.vfs.e)localObject3).mUri), true);
      if (!((com.tencent.mm.vfs.e)localObject3).exists()) {
        ((com.tencent.mm.vfs.e)localObject3).mkdirs();
      }
      localObject1 = aj.getContext().getAssets();
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
          ad.e("MicroMsg.SubCoreWNNoteMsg", "file inputStream not found");
          com.tencent.mm.plugin.wenote.b.b.bgJ();
          AppMethodBeat.o(30295);
          return;
          ao.rtT = ao.aHm();
          if (paramBoolean)
          {
            i = ao.aHn();
            ad.i("MicroMsg.SubCoreWNNoteMsg", "copyAssertTemplateFile need update assetVersion=%d currentVersion=%d", new Object[] { Integer.valueOf(i), Integer.valueOf(ao.rtT) });
            if (ao.rtT >= i) {
              break;
            }
            com.tencent.mm.vfs.i.cZ(com.tencent.mm.vfs.q.B(((com.tencent.mm.vfs.e)localObject3).mUri), true);
            break;
          }
          if (ao.rtT == 1)
          {
            ad.i("MicroMsg.SubCoreWNNoteMsg", "copyAssertTemplateFile need init template");
            com.tencent.mm.vfs.i.cZ(com.tencent.mm.vfs.q.B(((com.tencent.mm.vfs.e)localObject3).mUri), true);
            break;
          }
          ad.i("MicroMsg.SubCoreWNNoteMsg", "copyAssertTemplateFile currentVersion=%d", new Object[] { Integer.valueOf(ao.rtT) });
        }
      }
      catch (IOException localIOException1)
      {
        ad.printErrStackTrace("MicroMsg.SubCoreWNNoteMsg", localIOException1, "", new Object[0]);
        localCloseable = null;
        continue;
        locale = new com.tencent.mm.vfs.e((com.tencent.mm.vfs.e)localObject3, "WNNote.zip");
        if (locale.exists())
        {
          ad.i("MicroMsg.SubCoreWNNoteMsg", "wenote template already exists");
          bt.d(localCloseable);
          continue;
        }
      }
      try
      {
        localObject3 = com.tencent.mm.vfs.i.aj(locale);
        localObject2 = localObject3;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.SubCoreWNNoteMsg", localFileNotFoundException, "", new Object[0]);
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
          bt.d(localCloseable);
        }
        catch (IOException localIOException2)
        {
          ad.printErrStackTrace("MicroMsg.SubCoreWNNoteMsg", localIOException2, "", new Object[0]);
        }
      }
      bt.d(localObject2);
      int i = com.tencent.mm.vfs.i.fz(com.tencent.mm.vfs.q.B(locale.fOK()), locale.getParent());
      if (i < 0) {
        ad.e("MicroMsg.SubCoreWNNoteMsg", "unzip fail, ret = " + i + ", zipFilePath = " + com.tencent.mm.vfs.q.B(locale.fOK()) + ", unzipPath = " + locale.getParent());
      }
    }
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(30296);
    ad.d("MicroMsg.SubCoreWNNoteMsg", "on account post release");
    com.tencent.mm.sdk.b.a.IbL.d(this.Eyz);
    if (((com.tencent.mm.plugin.record.a.a)g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage() != null) {
      ((com.tencent.mm.plugin.record.a.a)g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(this.EyA);
    }
    if (((af)g.ad(af.class)).getFavCdnStorage() != null) {
      ((af)g.ad(af.class)).getFavCdnStorage().b(this.EyA);
    }
    com.tencent.mm.sdk.b.a.IbL.d(this.EyB);
    com.tencent.mm.sdk.b.a.IbL.d(this.EyC);
    com.tencent.mm.sdk.b.a.IbL.d(this.nEU);
    com.tencent.mm.plugin.wenote.b.b.bgK();
    AppMethodBeat.o(30296);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.c
 * JD-Core Version:    0.7.0.1
 */