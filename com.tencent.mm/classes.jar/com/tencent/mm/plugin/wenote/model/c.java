package com.tencent.mm.plugin.wenote.model;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.cx;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.be;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.ch;
import com.tencent.mm.plugin.fav.a.ag;
import com.tencent.mm.plugin.fav.a.ap;
import com.tencent.mm.plugin.fav.a.r;
import com.tencent.mm.plugin.record.a.e;
import com.tencent.mm.plugin.taskbar.api.b.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
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
  private com.tencent.mm.plugin.wenote.a.b QFZ;
  private com.tencent.mm.plugin.wenote.a.c QGa;
  private com.tencent.mm.plugin.wenote.a.a QGb;
  private IListener<cx> QGc;
  public d QGd;
  private IListener rXj;
  
  static
  {
    AppMethodBeat.i(30297);
    baseDBFactories = new HashMap();
    AppMethodBeat.o(30297);
  }
  
  public c()
  {
    AppMethodBeat.i(30293);
    this.QFZ = new com.tencent.mm.plugin.wenote.a.b();
    this.QGa = new com.tencent.mm.plugin.wenote.a.c();
    this.QGb = new com.tencent.mm.plugin.wenote.a.a();
    this.QGc = new IListener() {};
    this.QGd = null;
    this.rXj = new c.2(this);
    AppMethodBeat.o(30293);
  }
  
  public static c hdm()
  {
    AppMethodBeat.i(30294);
    bh.beC();
    c localc2 = (c)ch.RZ("plugin.wenote");
    c localc1 = localc2;
    if (localc2 == null)
    {
      localc1 = new c();
      bh.beC().a("plugin.wenote", localc1);
    }
    AppMethodBeat.o(30294);
    return localc1;
  }
  
  public final void a(d paramd)
  {
    this.QGd = paramd;
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
    EventCenter.instance.addListener(this.QFZ);
    ((com.tencent.mm.plugin.record.a.a)h.ag(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a(this.QGa);
    ((ag)h.ag(ag.class)).getFavCdnStorage().a(this.QGa);
    EventCenter.instance.addListener(this.QGb);
    EventCenter.instance.addListener(this.QGc);
    EventCenter.instance.addListener(this.rXj);
    Object localObject1 = new q(i.bci());
    if ((!((q)localObject1).ifE()) || (!((q)localObject1).isDirectory()))
    {
      Log.d("MicroMsg.SubCoreWNNoteMsg", "record stg dir[%s] not exsit, create it");
      ((q)localObject1).ifL();
    }
    Object localObject3 = new q(ap.dkm());
    Log.i("MicroMsg.SubCoreWNNoteMsg", "copy to path %s", new Object[] { ((q)localObject3).bOF() });
    if (com.tencent.mm.protocal.d.RAG)
    {
      Log.i("MicroMsg.SubCoreWNNoteMsg", "copyAssertTemplateFile develop version delete template");
      u.deleteDir(((q)localObject3).getPath());
    }
    for (;;)
    {
      if (!((q)localObject3).ifE()) {
        ((q)localObject3).ifL();
      }
      localObject1 = MMApplicationContext.getContext().getAssets();
      try
      {
        localObject1 = ((AssetManager)localObject1).open("WNNote.zip");
        if (localObject1 == null)
        {
          Log.e("MicroMsg.SubCoreWNNoteMsg", "file inputStream not found");
          com.tencent.mm.plugin.wenote.b.b.bNZ();
          localObject1 = com.tencent.mm.plugin.wenote.c.a.QIG;
          ((com.tencent.mm.plugin.multitask.d)h.ag(com.tencent.mm.plugin.multitask.d.class)).registerMultiTaskUIC(3, com.tencent.mm.plugin.wenote.c.c.class);
          localObject1 = com.tencent.mm.plugin.wenote.c.a.QIG;
          localObject1 = (com.tencent.mm.plugin.taskbar.api.b)h.ae(com.tencent.mm.plugin.taskbar.api.b.class);
          if (localObject1 == null) {
            break label622;
          }
          ((com.tencent.mm.plugin.taskbar.api.b)localObject1).a(3, (b.a)com.tencent.mm.plugin.wenote.c.a.hdQ());
          AppMethodBeat.o(30295);
          return;
          ap.wHP = ap.bkM();
          if (paramBoolean)
          {
            i = ap.bkN();
            Log.i("MicroMsg.SubCoreWNNoteMsg", "copyAssertTemplateFile need update assetVersion=%d currentVersion=%d", new Object[] { Integer.valueOf(i), Integer.valueOf(ap.wHP) });
            if (ap.wHP >= i) {
              continue;
            }
            u.deleteDir(((q)localObject3).getPath());
            continue;
          }
          if (ap.wHP == 1)
          {
            Log.i("MicroMsg.SubCoreWNNoteMsg", "copyAssertTemplateFile need init template");
            u.deleteDir(((q)localObject3).getPath());
            continue;
          }
          Log.i("MicroMsg.SubCoreWNNoteMsg", "copyAssertTemplateFile currentVersion=%d", new Object[] { Integer.valueOf(ap.wHP) });
        }
      }
      catch (IOException localIOException1)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.SubCoreWNNoteMsg", localIOException1, "", new Object[0]);
          Closeable localCloseable = null;
          continue;
          q localq = new q((q)localObject3, "WNNote.zip");
          if (localq.ifE())
          {
            Log.i("MicroMsg.SubCoreWNNoteMsg", "wenote template already exists");
            Util.qualityClose(localCloseable);
          }
          try
          {
            localObject3 = u.an(localq);
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
          int i = u.gj(localq.bOF(), localq.ifA());
          if (i < 0) {
            Log.e("MicroMsg.SubCoreWNNoteMsg", "unzip fail, ret = " + i + ", zipFilePath = " + localq.bOF() + ", unzipPath = " + localq.ifA());
          }
        }
        label622:
        AppMethodBeat.o(30295);
      }
    }
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(30296);
    Log.d("MicroMsg.SubCoreWNNoteMsg", "on account post release");
    EventCenter.instance.removeListener(this.QFZ);
    if (((com.tencent.mm.plugin.record.a.a)h.ag(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage() != null) {
      ((com.tencent.mm.plugin.record.a.a)h.ag(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(this.QGa);
    }
    if (((ag)h.ag(ag.class)).getFavCdnStorage() != null) {
      ((ag)h.ag(ag.class)).getFavCdnStorage().b(this.QGa);
    }
    EventCenter.instance.removeListener(this.QGb);
    EventCenter.instance.removeListener(this.QGc);
    EventCenter.instance.removeListener(this.rXj);
    com.tencent.mm.plugin.wenote.b.b.bOa();
    Object localObject = com.tencent.mm.plugin.wenote.c.a.QIG;
    localObject = (com.tencent.mm.plugin.taskbar.api.b)h.ae(com.tencent.mm.plugin.taskbar.api.b.class);
    if (localObject != null)
    {
      ((com.tencent.mm.plugin.taskbar.api.b)localObject).b(3, (b.a)com.tencent.mm.plugin.wenote.c.a.hdQ());
      AppMethodBeat.o(30296);
      return;
    }
    AppMethodBeat.o(30296);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.c
 * JD-Core Version:    0.7.0.1
 */