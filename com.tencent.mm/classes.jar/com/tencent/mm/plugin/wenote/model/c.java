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
  implements aw
{
  private static HashMap<Integer, h.b> baseDBFactories;
  public d BCA;
  private com.tencent.mm.plugin.wenote.a.b BCw;
  private com.tencent.mm.plugin.wenote.a.c BCx;
  private com.tencent.mm.plugin.wenote.a.a BCy;
  private com.tencent.mm.sdk.b.c<cm> BCz;
  private com.tencent.mm.sdk.b.c mCw;
  
  static
  {
    AppMethodBeat.i(30297);
    baseDBFactories = new HashMap();
    AppMethodBeat.o(30297);
  }
  
  public c()
  {
    AppMethodBeat.i(30293);
    this.BCw = new com.tencent.mm.plugin.wenote.a.b();
    this.BCx = new com.tencent.mm.plugin.wenote.a.c();
    this.BCy = new com.tencent.mm.plugin.wenote.a.a();
    this.BCz = new com.tencent.mm.sdk.b.c() {};
    this.BCA = null;
    this.mCw = new c.2(this);
    AppMethodBeat.o(30293);
  }
  
  public static c esw()
  {
    AppMethodBeat.i(30294);
    az.arP();
    c localc2 = (c)bz.ut("plugin.wenote");
    c localc1 = localc2;
    if (localc2 == null)
    {
      localc1 = new c();
      az.arP().a("plugin.wenote", localc1);
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
    com.tencent.mm.sdk.b.a.ESL.c(this.BCw);
    ((com.tencent.mm.plugin.record.a.a)g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a(this.BCx);
    ((af)g.ad(af.class)).getFavCdnStorage().a(this.BCx);
    com.tencent.mm.sdk.b.a.ESL.c(this.BCy);
    com.tencent.mm.sdk.b.a.ESL.c(this.BCz);
    com.tencent.mm.sdk.b.a.ESL.c(this.mCw);
    Object localObject1 = new com.tencent.mm.vfs.e(i.aqi());
    if ((!((com.tencent.mm.vfs.e)localObject1).exists()) || (!((com.tencent.mm.vfs.e)localObject1).isDirectory()))
    {
      ad.d("MicroMsg.SubCoreWNNoteMsg", "record stg dir[%s] not exsit, create it");
      ((com.tencent.mm.vfs.e)localObject1).mkdirs();
    }
    Object localObject3 = new com.tencent.mm.vfs.e(ao.cip());
    ad.i("MicroMsg.SubCoreWNNoteMsg", "copy to path %s", new Object[] { com.tencent.mm.vfs.q.B(((com.tencent.mm.vfs.e)localObject3).fhU()) });
    if (com.tencent.mm.protocal.d.CpN)
    {
      ad.i("MicroMsg.SubCoreWNNoteMsg", "copyAssertTemplateFile develop version delete template");
      com.tencent.mm.vfs.i.cO(com.tencent.mm.vfs.q.B(((com.tencent.mm.vfs.e)localObject3).mUri), true);
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
          com.tencent.mm.plugin.wenote.b.b.aWh();
          AppMethodBeat.o(30295);
          return;
          ao.qbl = ao.axp();
          if (paramBoolean)
          {
            i = ao.axq();
            ad.i("MicroMsg.SubCoreWNNoteMsg", "copyAssertTemplateFile need update assetVersion=%d currentVersion=%d", new Object[] { Integer.valueOf(i), Integer.valueOf(ao.qbl) });
            if (ao.qbl >= i) {
              break;
            }
            com.tencent.mm.vfs.i.cO(com.tencent.mm.vfs.q.B(((com.tencent.mm.vfs.e)localObject3).mUri), true);
            break;
          }
          if (ao.qbl == 1)
          {
            ad.i("MicroMsg.SubCoreWNNoteMsg", "copyAssertTemplateFile need init template");
            com.tencent.mm.vfs.i.cO(com.tencent.mm.vfs.q.B(((com.tencent.mm.vfs.e)localObject3).mUri), true);
            break;
          }
          ad.i("MicroMsg.SubCoreWNNoteMsg", "copyAssertTemplateFile currentVersion=%d", new Object[] { Integer.valueOf(ao.qbl) });
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
        localObject3 = com.tencent.mm.vfs.i.ai(locale);
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
      int i = com.tencent.mm.vfs.i.fc(com.tencent.mm.vfs.q.B(locale.fhU()), locale.getParent());
      if (i < 0) {
        ad.e("MicroMsg.SubCoreWNNoteMsg", "unzip fail, ret = " + i + ", zipFilePath = " + com.tencent.mm.vfs.q.B(locale.fhU()) + ", unzipPath = " + locale.getParent());
      }
    }
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(30296);
    ad.d("MicroMsg.SubCoreWNNoteMsg", "on account post release");
    com.tencent.mm.sdk.b.a.ESL.d(this.BCw);
    if (((com.tencent.mm.plugin.record.a.a)g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage() != null) {
      ((com.tencent.mm.plugin.record.a.a)g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(this.BCx);
    }
    if (((af)g.ad(af.class)).getFavCdnStorage() != null) {
      ((af)g.ad(af.class)).getFavCdnStorage().b(this.BCx);
    }
    com.tencent.mm.sdk.b.a.ESL.d(this.BCy);
    com.tencent.mm.sdk.b.a.ESL.d(this.BCz);
    com.tencent.mm.sdk.b.a.ESL.d(this.mCw);
    com.tencent.mm.plugin.wenote.b.b.aWi();
    AppMethodBeat.o(30296);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.c
 * JD-Core Version:    0.7.0.1
 */