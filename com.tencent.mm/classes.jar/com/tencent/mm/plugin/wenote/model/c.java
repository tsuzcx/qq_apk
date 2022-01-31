package com.tencent.mm.plugin.wenote.model;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bw;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.an;
import com.tencent.mm.plugin.fav.a.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.j;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;

public final class c
  implements at
{
  private static HashMap<Integer, h.d> baseDBFactories;
  private com.tencent.mm.sdk.b.c gSJ;
  private com.tencent.mm.plugin.wenote.a.b vvN;
  private com.tencent.mm.plugin.wenote.a.c vvO;
  private com.tencent.mm.plugin.wenote.a.a vvP;
  public d vvQ;
  
  static
  {
    AppMethodBeat.i(26604);
    baseDBFactories = new HashMap();
    AppMethodBeat.o(26604);
  }
  
  public c()
  {
    AppMethodBeat.i(26600);
    this.vvN = new com.tencent.mm.plugin.wenote.a.b();
    this.vvO = new com.tencent.mm.plugin.wenote.a.c();
    this.vvP = new com.tencent.mm.plugin.wenote.a.a();
    this.vvQ = null;
    this.gSJ = new c.1(this);
    AppMethodBeat.o(26600);
  }
  
  public static c dhH()
  {
    AppMethodBeat.i(26601);
    aw.aat();
    c localc2 = (c)bw.pF("plugin.wenote");
    c localc1 = localc2;
    if (localc2 == null)
    {
      localc1 = new c();
      aw.aat().a("plugin.wenote", localc1);
    }
    AppMethodBeat.o(26601);
    return localc1;
  }
  
  public final void clearPluginData(int paramInt) {}
  
  public final HashMap<Integer, h.d> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    Object localObject2 = null;
    AppMethodBeat.i(26602);
    ab.d("MicroMsg.SubCoreWNNoteMsg", "on account post reset");
    com.tencent.mm.sdk.b.a.ymk.c(this.vvN);
    ((com.tencent.mm.plugin.record.a.a)g.G(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a(this.vvO);
    ((ae)g.G(ae.class)).getFavCdnStorage().a(this.vvO);
    com.tencent.mm.sdk.b.a.ymk.c(this.vvP);
    com.tencent.mm.sdk.b.a.ymk.c(this.gSJ);
    Object localObject1 = new com.tencent.mm.vfs.b(i.YW());
    if ((!((com.tencent.mm.vfs.b)localObject1).exists()) || (!((com.tencent.mm.vfs.b)localObject1).isDirectory()))
    {
      ab.d("MicroMsg.SubCoreWNNoteMsg", "record stg dir[%s] not exsit, create it");
      ((com.tencent.mm.vfs.b)localObject1).mkdirs();
    }
    Object localObject3 = new com.tencent.mm.vfs.b(an.bwZ());
    ab.i("MicroMsg.SubCoreWNNoteMsg", "copy to path %s", new Object[] { j.p(((com.tencent.mm.vfs.b)localObject3).dQJ()) });
    if (com.tencent.mm.protocal.d.whK)
    {
      ab.i("MicroMsg.SubCoreWNNoteMsg", "copyAssertTemplateFile develop version delete template");
      com.tencent.mm.vfs.e.O(j.p(((com.tencent.mm.vfs.b)localObject3).mUri), true);
    }
    Closeable localCloseable;
    com.tencent.mm.vfs.b localb;
    for (;;)
    {
      if (!((com.tencent.mm.vfs.b)localObject3).exists()) {
        ((com.tencent.mm.vfs.b)localObject3).mkdirs();
      }
      localObject1 = ah.getContext().getAssets();
      try
      {
        localObject1 = ((AssetManager)localObject1).open("WNNote.zip");
        if (localObject1 == null)
        {
          ab.e("MicroMsg.SubCoreWNNoteMsg", "file inputStream not found");
          AppMethodBeat.o(26602);
          return;
          an.muD = an.agn();
          if (paramBoolean)
          {
            i = an.ago();
            ab.i("MicroMsg.SubCoreWNNoteMsg", "copyAssertTemplateFile need update assetVersion=%d currentVersion=%d", new Object[] { Integer.valueOf(i), Integer.valueOf(an.muD) });
            if (an.muD >= i) {
              continue;
            }
            com.tencent.mm.vfs.e.O(j.p(((com.tencent.mm.vfs.b)localObject3).mUri), true);
            continue;
          }
          if (an.muD == 1)
          {
            ab.i("MicroMsg.SubCoreWNNoteMsg", "copyAssertTemplateFile need init template");
            com.tencent.mm.vfs.e.O(j.p(((com.tencent.mm.vfs.b)localObject3).mUri), true);
            continue;
          }
          ab.i("MicroMsg.SubCoreWNNoteMsg", "copyAssertTemplateFile currentVersion=%d", new Object[] { Integer.valueOf(an.muD) });
        }
      }
      catch (IOException localIOException1)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.SubCoreWNNoteMsg", localIOException1, "", new Object[0]);
          localCloseable = null;
        }
        localb = new com.tencent.mm.vfs.b((com.tencent.mm.vfs.b)localObject3, "WNNote.zip");
        if (localb.exists())
        {
          ab.i("MicroMsg.SubCoreWNNoteMsg", "wenote template already exists");
          bo.b(localCloseable);
          AppMethodBeat.o(26602);
          return;
        }
      }
    }
    try
    {
      localObject3 = com.tencent.mm.vfs.e.r(localb);
      localObject2 = localObject3;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.SubCoreWNNoteMsg", localFileNotFoundException, "", new Object[0]);
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
        bo.b(localCloseable);
      }
      catch (IOException localIOException2)
      {
        ab.printErrStackTrace("MicroMsg.SubCoreWNNoteMsg", localIOException2, "", new Object[0]);
      }
    }
    bo.b(localObject2);
    int i = com.tencent.mm.vfs.e.iH(j.p(localb.dQJ()), localb.getParent());
    if (i < 0) {
      ab.e("MicroMsg.SubCoreWNNoteMsg", "unzip fail, ret = " + i + ", zipFilePath = " + j.p(localb.dQJ()) + ", unzipPath = " + localb.getParent());
    }
    AppMethodBeat.o(26602);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(26603);
    ab.d("MicroMsg.SubCoreWNNoteMsg", "on account post release");
    com.tencent.mm.sdk.b.a.ymk.d(this.vvN);
    if (((com.tencent.mm.plugin.record.a.a)g.G(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage() != null) {
      ((com.tencent.mm.plugin.record.a.a)g.G(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(this.vvO);
    }
    if (((ae)g.G(ae.class)).getFavCdnStorage() != null) {
      ((ae)g.G(ae.class)).getFavCdnStorage().b(this.vvO);
    }
    com.tencent.mm.sdk.b.a.ymk.d(this.vvP);
    com.tencent.mm.sdk.b.a.ymk.d(this.gSJ);
    AppMethodBeat.o(26603);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.c
 * JD-Core Version:    0.7.0.1
 */