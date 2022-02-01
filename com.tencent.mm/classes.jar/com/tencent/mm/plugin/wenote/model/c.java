package com.tencent.mm.plugin.wenote.model;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.cc;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.ao;
import com.tencent.mm.plugin.fav.a.q;
import com.tencent.mm.plugin.record.a.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.w;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;

public final class c
  implements az
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private com.tencent.mm.plugin.wenote.a.b EQV;
  private com.tencent.mm.plugin.wenote.a.c EQW;
  private com.tencent.mm.plugin.wenote.a.a EQX;
  private com.tencent.mm.sdk.b.c<cq> EQY;
  public d EQZ;
  private com.tencent.mm.sdk.b.c nKp;
  
  static
  {
    AppMethodBeat.i(30297);
    baseDBFactories = new HashMap();
    AppMethodBeat.o(30297);
  }
  
  public c()
  {
    AppMethodBeat.i(30293);
    this.EQV = new com.tencent.mm.plugin.wenote.a.b();
    this.EQW = new com.tencent.mm.plugin.wenote.a.c();
    this.EQX = new com.tencent.mm.plugin.wenote.a.a();
    this.EQY = new com.tencent.mm.sdk.b.c() {};
    this.EQZ = null;
    this.nKp = new c.2(this);
    AppMethodBeat.o(30293);
  }
  
  public static c fau()
  {
    AppMethodBeat.i(30294);
    bc.aCa();
    c localc2 = (c)cc.Ca("plugin.wenote");
    c localc1 = localc2;
    if (localc2 == null)
    {
      localc1 = new c();
      bc.aCa().a("plugin.wenote", localc1);
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
    ae.d("MicroMsg.SubCoreWNNoteMsg", "on account post reset");
    com.tencent.mm.sdk.b.a.IvT.c(this.EQV);
    ((com.tencent.mm.plugin.record.a.a)g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a(this.EQW);
    ((af)g.ad(af.class)).getFavCdnStorage().a(this.EQW);
    com.tencent.mm.sdk.b.a.IvT.c(this.EQX);
    com.tencent.mm.sdk.b.a.IvT.c(this.EQY);
    com.tencent.mm.sdk.b.a.IvT.c(this.nKp);
    Object localObject1 = new k(i.aAc());
    if ((!((k)localObject1).exists()) || (!((k)localObject1).isDirectory()))
    {
      ae.d("MicroMsg.SubCoreWNNoteMsg", "record stg dir[%s] not exsit, create it");
      ((k)localObject1).mkdirs();
    }
    Object localObject3 = new k(ao.cxc());
    ae.i("MicroMsg.SubCoreWNNoteMsg", "copy to path %s", new Object[] { w.B(((k)localObject3).fTh()) });
    if (com.tencent.mm.protocal.d.FFK)
    {
      ae.i("MicroMsg.SubCoreWNNoteMsg", "copyAssertTemplateFile develop version delete template");
      o.dd(w.B(((k)localObject3).mUri), true);
      if (!((k)localObject3).exists()) {
        ((k)localObject3).mkdirs();
      }
      localObject1 = ak.getContext().getAssets();
    }
    for (;;)
    {
      Closeable localCloseable;
      k localk;
      try
      {
        localObject1 = ((AssetManager)localObject1).open("WNNote.zip");
        if (localObject1 == null)
        {
          ae.e("MicroMsg.SubCoreWNNoteMsg", "file inputStream not found");
          com.tencent.mm.plugin.wenote.b.b.bhr();
          AppMethodBeat.o(30295);
          return;
          ao.rCf = ao.aHD();
          if (paramBoolean)
          {
            i = ao.aHE();
            ae.i("MicroMsg.SubCoreWNNoteMsg", "copyAssertTemplateFile need update assetVersion=%d currentVersion=%d", new Object[] { Integer.valueOf(i), Integer.valueOf(ao.rCf) });
            if (ao.rCf >= i) {
              break;
            }
            o.dd(w.B(((k)localObject3).mUri), true);
            break;
          }
          if (ao.rCf == 1)
          {
            ae.i("MicroMsg.SubCoreWNNoteMsg", "copyAssertTemplateFile need init template");
            o.dd(w.B(((k)localObject3).mUri), true);
            break;
          }
          ae.i("MicroMsg.SubCoreWNNoteMsg", "copyAssertTemplateFile currentVersion=%d", new Object[] { Integer.valueOf(ao.rCf) });
        }
      }
      catch (IOException localIOException1)
      {
        ae.printErrStackTrace("MicroMsg.SubCoreWNNoteMsg", localIOException1, "", new Object[0]);
        localCloseable = null;
        continue;
        localk = new k((k)localObject3, "WNNote.zip");
        if (localk.exists())
        {
          ae.i("MicroMsg.SubCoreWNNoteMsg", "wenote template already exists");
          bu.d(localCloseable);
          continue;
        }
      }
      try
      {
        localObject3 = o.aj(localk);
        localObject2 = localObject3;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        for (;;)
        {
          ae.printErrStackTrace("MicroMsg.SubCoreWNNoteMsg", localFileNotFoundException, "", new Object[0]);
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
          bu.d(localCloseable);
        }
        catch (IOException localIOException2)
        {
          ae.printErrStackTrace("MicroMsg.SubCoreWNNoteMsg", localIOException2, "", new Object[0]);
        }
      }
      bu.d(localObject2);
      int i = o.fD(w.B(localk.fTh()), localk.getParent());
      if (i < 0) {
        ae.e("MicroMsg.SubCoreWNNoteMsg", "unzip fail, ret = " + i + ", zipFilePath = " + w.B(localk.fTh()) + ", unzipPath = " + localk.getParent());
      }
    }
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(30296);
    ae.d("MicroMsg.SubCoreWNNoteMsg", "on account post release");
    com.tencent.mm.sdk.b.a.IvT.d(this.EQV);
    if (((com.tencent.mm.plugin.record.a.a)g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage() != null) {
      ((com.tencent.mm.plugin.record.a.a)g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(this.EQW);
    }
    if (((af)g.ad(af.class)).getFavCdnStorage() != null) {
      ((af)g.ad(af.class)).getFavCdnStorage().b(this.EQW);
    }
    com.tencent.mm.sdk.b.a.IvT.d(this.EQX);
    com.tencent.mm.sdk.b.a.IvT.d(this.EQY);
    com.tencent.mm.sdk.b.a.IvT.d(this.nKp);
    com.tencent.mm.plugin.wenote.b.b.bhs();
    AppMethodBeat.o(30296);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.c
 * JD-Core Version:    0.7.0.1
 */