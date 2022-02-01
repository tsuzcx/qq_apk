package com.tencent.mm.plugin.wenote.model;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.dh;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.be;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.ci;
import com.tencent.mm.plugin.fav.a.aq;
import com.tencent.mm.plugin.fav.a.r;
import com.tencent.mm.plugin.record.a.e;
import com.tencent.mm.plugin.taskbar.api.b.a;
import com.tencent.mm.plugin.wenote.event.NotifyWNNoteOperationListener;
import com.tencent.mm.plugin.wenote.event.OpenNoteFromSessionListener;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;

public final class c
  implements be
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private IListener<dh> XzA;
  public d XzB;
  private OpenNoteFromSessionListener Xzx;
  private com.tencent.mm.plugin.wenote.event.a Xzy;
  private NotifyWNNoteOperationListener Xzz;
  private IListener viA;
  
  static
  {
    AppMethodBeat.i(30297);
    baseDBFactories = new HashMap();
    AppMethodBeat.o(30297);
  }
  
  public c()
  {
    AppMethodBeat.i(30293);
    this.Xzx = new OpenNoteFromSessionListener();
    this.Xzy = new com.tencent.mm.plugin.wenote.event.a();
    this.Xzz = new NotifyWNNoteOperationListener();
    this.XzA = new SubCoreWNNoteMsg.1(this, f.hfK);
    this.XzB = null;
    this.viA = new SubCoreWNNoteMsg.2(this, f.hfK);
    AppMethodBeat.o(30293);
  }
  
  public static c iDT()
  {
    AppMethodBeat.i(30294);
    bh.bCt();
    c localc2 = (c)ci.Ka("plugin.wenote");
    c localc1 = localc2;
    if (localc2 == null)
    {
      localc1 = new c();
      bh.bCt().a("plugin.wenote", localc1);
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
    Log.d("MicroMsg.SubCoreWNNoteMsg", "on account post reset");
    this.Xzx.alive();
    ((com.tencent.mm.plugin.record.a.a)h.az(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a(this.Xzy);
    ((com.tencent.mm.plugin.fav.a.ah)h.az(com.tencent.mm.plugin.fav.a.ah.class)).getFavCdnStorage().a(this.Xzy);
    this.Xzz.alive();
    this.XzA.alive();
    this.viA.alive();
    Object localObject1 = new u(i.bzX());
    if ((!((u)localObject1).jKS()) || (!((u)localObject1).isDirectory()))
    {
      Log.d("MicroMsg.SubCoreWNNoteMsg", "record stg dir[%s] not exsit, create it");
      ((u)localObject1).jKY();
    }
    Object localObject3 = new u(aq.dQY());
    Log.i("MicroMsg.SubCoreWNNoteMsg", "copy to path %s", new Object[] { com.tencent.mm.vfs.ah.v(((u)localObject3).jKT()) });
    if (com.tencent.mm.protocal.d.Yxk)
    {
      Log.i("MicroMsg.SubCoreWNNoteMsg", "copyAssertTemplateFile develop version delete template");
      y.ew(com.tencent.mm.vfs.ah.v(((u)localObject3).mUri), true);
      if (!((u)localObject3).jKS()) {
        ((u)localObject3).jKY();
      }
      localObject1 = MMApplicationContext.getContext().getAssets();
    }
    for (;;)
    {
      Closeable localCloseable;
      u localu;
      try
      {
        localObject1 = ((AssetManager)localObject1).open("WNNote.zip");
        if (localObject1 == null)
        {
          Log.e("MicroMsg.SubCoreWNNoteMsg", "file inputStream not found");
          com.tencent.mm.plugin.wenote.a.b.con();
          localObject1 = com.tencent.mm.plugin.wenote.b.a.XCd;
          ((com.tencent.mm.plugin.multitask.d)h.az(com.tencent.mm.plugin.multitask.d.class)).registerMultiTaskUIC(3, com.tencent.mm.plugin.wenote.b.c.class);
          localObject1 = com.tencent.mm.plugin.wenote.b.a.XCd;
          localObject1 = (com.tencent.mm.plugin.taskbar.api.b)h.ax(com.tencent.mm.plugin.taskbar.api.b.class);
          if (localObject1 != null) {
            ((com.tencent.mm.plugin.taskbar.api.b)localObject1).a(3, (b.a)com.tencent.mm.plugin.wenote.b.a.iEx());
          }
          AppMethodBeat.o(30295);
          return;
          aq.Aed = aq.bIG();
          if (paramBoolean)
          {
            i = aq.bIH();
            Log.i("MicroMsg.SubCoreWNNoteMsg", "copyAssertTemplateFile need update assetVersion=%d currentVersion=%d", new Object[] { Integer.valueOf(i), Integer.valueOf(aq.Aed) });
            if (aq.Aed >= i) {
              break;
            }
            y.ew(com.tencent.mm.vfs.ah.v(((u)localObject3).mUri), true);
            break;
          }
          if (aq.Aed == 1)
          {
            Log.i("MicroMsg.SubCoreWNNoteMsg", "copyAssertTemplateFile need init template");
            y.ew(com.tencent.mm.vfs.ah.v(((u)localObject3).mUri), true);
            break;
          }
          Log.i("MicroMsg.SubCoreWNNoteMsg", "copyAssertTemplateFile currentVersion=%d", new Object[] { Integer.valueOf(aq.Aed) });
        }
      }
      catch (IOException localIOException1)
      {
        Log.printErrStackTrace("MicroMsg.SubCoreWNNoteMsg", localIOException1, "", new Object[0]);
        localCloseable = null;
        continue;
        localu = new u((u)localObject3, "WNNote.zip");
        if (localu.jKS())
        {
          Log.i("MicroMsg.SubCoreWNNoteMsg", "wenote template already exists");
          Util.qualityClose(localCloseable);
          continue;
        }
      }
      try
      {
        localObject3 = y.ap(localu);
        localObject2 = localObject3;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.SubCoreWNNoteMsg", localFileNotFoundException, "", new Object[0]);
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
          Util.qualityClose(localCloseable);
        }
        catch (IOException localIOException2)
        {
          Log.printErrStackTrace("MicroMsg.SubCoreWNNoteMsg", localIOException2, "", new Object[0]);
        }
      }
      Util.qualityClose(localObject2);
      int i = y.aA(com.tencent.mm.vfs.ah.v(localu.jKT()), localu.jKO());
      if (i < 0) {
        Log.e("MicroMsg.SubCoreWNNoteMsg", "unzip fail, ret = " + i + ", zipFilePath = " + com.tencent.mm.vfs.ah.v(localu.jKT()) + ", unzipPath = " + localu.jKO());
      }
    }
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(30296);
    Log.d("MicroMsg.SubCoreWNNoteMsg", "on account post release");
    this.Xzx.dead();
    if (((com.tencent.mm.plugin.record.a.a)h.az(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage() != null) {
      ((com.tencent.mm.plugin.record.a.a)h.az(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(this.Xzy);
    }
    if (((com.tencent.mm.plugin.fav.a.ah)h.az(com.tencent.mm.plugin.fav.a.ah.class)).getFavCdnStorage() != null) {
      ((com.tencent.mm.plugin.fav.a.ah)h.az(com.tencent.mm.plugin.fav.a.ah.class)).getFavCdnStorage().b(this.Xzy);
    }
    this.Xzz.dead();
    this.XzA.dead();
    this.viA.dead();
    com.tencent.mm.plugin.wenote.a.b.coo();
    Object localObject = com.tencent.mm.plugin.wenote.b.a.XCd;
    localObject = (com.tencent.mm.plugin.taskbar.api.b)h.ax(com.tencent.mm.plugin.taskbar.api.b.class);
    if (localObject != null) {
      ((com.tencent.mm.plugin.taskbar.api.b)localObject).b(3, (b.a)com.tencent.mm.plugin.wenote.b.a.iEx());
    }
    AppMethodBeat.o(30296);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.c
 * JD-Core Version:    0.7.0.1
 */