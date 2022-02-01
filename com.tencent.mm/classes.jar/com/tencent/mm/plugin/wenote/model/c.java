package com.tencent.mm.plugin.wenote.model;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ak;
import com.tencent.mm.g.a.ct;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.cg;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.ao;
import com.tencent.mm.plugin.fav.a.q;
import com.tencent.mm.plugin.record.a.e;
import com.tencent.mm.plugin.taskbar.api.c.a;
import com.tencent.mm.plugin.wenote.multitask.NoteMultiTaskUIC;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class c
  implements bd
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private com.tencent.mm.plugin.wenote.a.b JGH;
  private com.tencent.mm.plugin.wenote.a.c JGI;
  private com.tencent.mm.plugin.wenote.a.a JGJ;
  private IListener<ct> JGK;
  public d JGL;
  private IListener oVk;
  
  static
  {
    AppMethodBeat.i(30297);
    baseDBFactories = new HashMap();
    AppMethodBeat.o(30297);
  }
  
  public c()
  {
    AppMethodBeat.i(30293);
    this.JGH = new com.tencent.mm.plugin.wenote.a.b();
    this.JGI = new com.tencent.mm.plugin.wenote.a.c();
    this.JGJ = new com.tencent.mm.plugin.wenote.a.a();
    this.JGK = new IListener() {};
    this.JGL = null;
    this.oVk = new IListener() {};
    AppMethodBeat.o(30293);
  }
  
  public static c gjz()
  {
    AppMethodBeat.i(30294);
    bg.aVz();
    c localc2 = (c)cg.KG("plugin.wenote");
    c localc1 = localc2;
    if (localc2 == null)
    {
      localc1 = new c();
      bg.aVz().a("plugin.wenote", localc1);
    }
    AppMethodBeat.o(30294);
    return localc1;
  }
  
  public final void a(d paramd)
  {
    this.JGL = paramd;
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
    EventCenter.instance.addListener(this.JGH);
    ((com.tencent.mm.plugin.record.a.a)g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a(this.JGI);
    ((af)g.ah(af.class)).getFavCdnStorage().a(this.JGI);
    EventCenter.instance.addListener(this.JGJ);
    EventCenter.instance.addListener(this.JGK);
    EventCenter.instance.addListener(this.oVk);
    Object localObject1 = new o(i.aTk());
    if ((!((o)localObject1).exists()) || (!((o)localObject1).isDirectory()))
    {
      Log.d("MicroMsg.SubCoreWNNoteMsg", "record stg dir[%s] not exsit, create it");
      ((o)localObject1).mkdirs();
    }
    Object localObject3 = new o(ao.cVg());
    Log.i("MicroMsg.SubCoreWNNoteMsg", "copy to path %s", new Object[] { aa.z(((o)localObject3).her()) });
    if (com.tencent.mm.protocal.d.KyR)
    {
      Log.i("MicroMsg.SubCoreWNNoteMsg", "copyAssertTemplateFile develop version delete template");
      s.dy(aa.z(((o)localObject3).mUri), true);
    }
    for (;;)
    {
      if (!((o)localObject3).exists()) {
        ((o)localObject3).mkdirs();
      }
      localObject1 = MMApplicationContext.getContext().getAssets();
      try
      {
        localObject1 = ((AssetManager)localObject1).open("WNNote.zip");
        if (localObject1 == null)
        {
          Log.e("MicroMsg.SubCoreWNNoteMsg", "file inputStream not found");
          com.tencent.mm.plugin.wenote.b.a.bCE();
          localObject1 = com.tencent.mm.plugin.wenote.multitask.a.JJo;
          ((com.tencent.mm.plugin.multitask.d)g.ah(com.tencent.mm.plugin.multitask.d.class)).registerMultiTaskUIC(3, NoteMultiTaskUIC.class);
          localObject1 = com.tencent.mm.plugin.wenote.multitask.a.JJo;
          localObject1 = (com.tencent.mm.plugin.taskbar.api.c)g.af(com.tencent.mm.plugin.taskbar.api.c.class);
          if (localObject1 == null) {
            break label645;
          }
          ((com.tencent.mm.plugin.taskbar.api.c)localObject1).a(3, (c.a)com.tencent.mm.plugin.wenote.multitask.a.gkc());
          AppMethodBeat.o(30295);
          return;
          ao.tbK = ao.bbw();
          if (paramBoolean)
          {
            i = ao.bbx();
            Log.i("MicroMsg.SubCoreWNNoteMsg", "copyAssertTemplateFile need update assetVersion=%d currentVersion=%d", new Object[] { Integer.valueOf(i), Integer.valueOf(ao.tbK) });
            if (ao.tbK >= i) {
              continue;
            }
            s.dy(aa.z(((o)localObject3).mUri), true);
            continue;
          }
          if (ao.tbK == 1)
          {
            Log.i("MicroMsg.SubCoreWNNoteMsg", "copyAssertTemplateFile need init template");
            s.dy(aa.z(((o)localObject3).mUri), true);
            continue;
          }
          Log.i("MicroMsg.SubCoreWNNoteMsg", "copyAssertTemplateFile currentVersion=%d", new Object[] { Integer.valueOf(ao.tbK) });
        }
      }
      catch (IOException localIOException1)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.SubCoreWNNoteMsg", localIOException1, "", new Object[0]);
          Closeable localCloseable = null;
          continue;
          o localo = new o((o)localObject3, "WNNote.zip");
          if (localo.exists())
          {
            Log.i("MicroMsg.SubCoreWNNoteMsg", "wenote template already exists");
            Util.qualityClose(localCloseable);
          }
          try
          {
            localObject3 = s.ap(localo);
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
          int i = s.fW(aa.z(localo.her()), localo.getParent());
          if (i < 0) {
            Log.e("MicroMsg.SubCoreWNNoteMsg", "unzip fail, ret = " + i + ", zipFilePath = " + aa.z(localo.her()) + ", unzipPath = " + localo.getParent());
          }
        }
        label645:
        AppMethodBeat.o(30295);
      }
    }
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(30296);
    Log.d("MicroMsg.SubCoreWNNoteMsg", "on account post release");
    EventCenter.instance.removeListener(this.JGH);
    if (((com.tencent.mm.plugin.record.a.a)g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage() != null) {
      ((com.tencent.mm.plugin.record.a.a)g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(this.JGI);
    }
    if (((af)g.ah(af.class)).getFavCdnStorage() != null) {
      ((af)g.ah(af.class)).getFavCdnStorage().b(this.JGI);
    }
    EventCenter.instance.removeListener(this.JGJ);
    EventCenter.instance.removeListener(this.JGK);
    EventCenter.instance.removeListener(this.oVk);
    com.tencent.mm.plugin.wenote.b.a.bCF();
    Object localObject = com.tencent.mm.plugin.wenote.multitask.a.JJo;
    localObject = (com.tencent.mm.plugin.taskbar.api.c)g.af(com.tencent.mm.plugin.taskbar.api.c.class);
    if (localObject != null)
    {
      ((com.tencent.mm.plugin.taskbar.api.c)localObject).b(3, (c.a)com.tencent.mm.plugin.wenote.multitask.a.gkc());
      AppMethodBeat.o(30296);
      return;
    }
    AppMethodBeat.o(30296);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.c
 * JD-Core Version:    0.7.0.1
 */