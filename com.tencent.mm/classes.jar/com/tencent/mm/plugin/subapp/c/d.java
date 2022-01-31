package com.tencent.mm.plugin.subapp.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.j.a;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.m.f;
import com.tencent.mm.model.an;
import com.tencent.mm.model.ao.d;
import com.tencent.mm.model.ao.f;
import com.tencent.mm.model.at;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bw;
import com.tencent.mm.platformtools.t.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.subapp.ui.voicereminder.RemindDialog;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.e.h;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@SuppressLint({"UseSparseArrays"})
public class d
  implements ao.f, at
{
  private static HashMap<Integer, h.d> kjX;
  private static d sXe;
  private j.a appForegroundListener;
  private final Set<ao.d> bLQ;
  private String eHR;
  private t.a kjZ;
  private k sXd;
  private j sXf;
  private List<Long> sXg;
  private com.tencent.mm.sdk.b.c sXh;
  private com.tencent.mm.sdk.b.c sXi;
  private com.tencent.mm.sdk.b.c sXj;
  
  static
  {
    AppMethodBeat.i(25280);
    HashMap localHashMap = new HashMap();
    kjX = localHashMap;
    localHashMap.put(Integer.valueOf("VOICEREMIND_TABLE".hashCode()), new d.2());
    AppMethodBeat.o(25280);
  }
  
  public d()
  {
    AppMethodBeat.i(25267);
    this.sXg = new ArrayList();
    this.bLQ = new HashSet();
    this.sXh = new d.3(this);
    this.appForegroundListener = new d.4(this);
    this.sXi = new d.5(this);
    this.sXj = new d.6(this);
    AppMethodBeat.o(25267);
  }
  
  public static d cGS()
  {
    AppMethodBeat.i(25274);
    aw.aat();
    com.tencent.mm.plugin.subapp.a locala = (com.tencent.mm.plugin.subapp.a)bw.pF("plugin.subapp");
    if (locala == null) {}
    for (d locald = null;; locald = (d)locala.adN(d.class.getName()))
    {
      sXe = locald;
      ab.i("MicroMsg.SubCoreVoiceRemind", "summervoice SubCoreVoiceRemind getCore subCoreSubapp[%s], theCore[%s], stack[%s]", new Object[] { locala, sXe, bo.dtY() });
      if (sXe == null)
      {
        locald = new d();
        sXe = locald;
        com.tencent.mm.model.ao.a.flL = locald;
        locala.b(d.class.getName(), sXe);
      }
      locald = sXe;
      AppMethodBeat.o(25274);
      return locald;
    }
  }
  
  public static k cGT()
  {
    AppMethodBeat.i(25275);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (cGS().sXd == null)
    {
      localObject1 = cGS();
      cGS();
      if (cGS().kjZ == null)
      {
        Object localObject2 = new StringBuilder();
        aw.aaz();
        localObject2 = com.tencent.mm.model.c.Rp() + "CommonOneMicroMsg.db";
        cGS().kjZ = com.tencent.mm.platformtools.t.a(d.class.hashCode(), (String)localObject2, kjX, false);
      }
      ((d)localObject1).sXd = new k(cGS().kjZ);
    }
    Object localObject1 = cGS().sXd;
    AppMethodBeat.o(25275);
    return localObject1;
  }
  
  public static j cGU()
  {
    AppMethodBeat.i(25279);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (cGS().sXf == null) {
      cGS().sXf = new j();
    }
    j localj = cGS().sXf;
    AppMethodBeat.o(25279);
    return localj;
  }
  
  public final void a(ao.d paramd)
  {
    AppMethodBeat.i(25268);
    ab.d("MicroMsg.SubCoreVoiceRemind", "addVoiceRemind ");
    if (paramd != null) {
      this.bLQ.add(paramd);
    }
    AppMethodBeat.o(25268);
  }
  
  public final void aal()
  {
    AppMethodBeat.i(25272);
    cGU().run();
    AppMethodBeat.o(25272);
  }
  
  public final void b(ao.d paramd)
  {
    AppMethodBeat.i(25269);
    ab.d("MicroMsg.SubCoreVoiceRemind", "removeVoiceRemind ");
    if (paramd != null) {
      this.bLQ.remove(paramd);
    }
    AppMethodBeat.o(25269);
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.d> getBaseDBFactories()
  {
    return null;
  }
  
  public final boolean gv(long paramLong)
  {
    AppMethodBeat.i(25273);
    boolean bool = this.sXg.contains(Long.valueOf(paramLong));
    ab.d("MicroMsg.SubCoreVoiceRemind", "silent " + bool + "  mid " + paramLong);
    AppMethodBeat.o(25273);
    return bool;
  }
  
  public final void n(String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(25270);
    Context localContext = ah.getContext();
    if (localContext == null)
    {
      ab.d("MicroMsg.SubCoreVoiceRemind", "notifyVoiceRemind context null");
      AppMethodBeat.o(25270);
      return;
    }
    for (;;)
    {
      try
      {
        bool1 = f.MD();
        bool2 = f.MB();
        ab.d("MicroMsg.SubCoreVoiceRemind", "shake " + bool1 + "sound " + bool2);
        if (!com.tencent.mm.model.t.or(aw.getNotification().IF())) {
          continue;
        }
        if (bool1) {
          bo.z(localContext, true);
        }
      }
      catch (Exception localException2)
      {
        boolean bool1;
        boolean bool2;
        Object localObject;
        com.tencent.mm.compatible.b.k localk;
        ab.printErrStackTrace("MicroMsg.SubCoreVoiceRemind", localException2, "", new Object[0]);
        continue;
        localUri = Uri.parse(localException2);
        continue;
        localk.setAudioStreamType(5);
        localk.setLooping(true);
        localk.prepare();
        localk.setLooping(false);
        localk.start();
        continue;
        paramString1 = this.bLQ.iterator();
        if (!paramString1.hasNext()) {
          continue;
        }
        ((ao.d)paramString1.next()).w(paramString2, paramLong);
        continue;
        AppMethodBeat.o(25270);
        return;
      }
      if ((this.bLQ == null) || (this.bLQ.size() == 0))
      {
        RemindDialog.y(localContext, paramString1, paramString2);
        AppMethodBeat.o(25270);
        return;
        if (bool1) {
          bo.z(localContext, true);
        }
        if (!bool2) {
          continue;
        }
        localObject = f.MF();
        if (localObject == e.h.etD)
        {
          localObject = RingtoneManager.getDefaultUri(2);
          localk = new com.tencent.mm.compatible.b.k();
        }
      }
    }
    for (;;)
    {
      int j;
      try
      {
        localk.setDataSource(localContext, (Uri)localObject);
        localk.setOnCompletionListener(new d.1(this));
        if (aw.aaA().getStreamVolume(5) == 0) {
          break;
        }
        if (!aw.aaA().KN()) {
          break label406;
        }
        int k = aw.aaA().getStreamVolume(8);
        i = aw.aaA().getStreamMaxVolume(8);
        j = aw.aaA().getStreamVolume(5);
        if (j <= i) {
          break label482;
        }
        aw.aaA().bW(8, i);
        localk.setAudioStreamType(8);
        localk.setLooping(true);
        localk.prepare();
        localk.setLooping(false);
        localk.start();
        aw.aaA().bW(8, k);
        ab.d("MicroMsg.SubCoreVoiceRemind", "oldVolume is %d, toneVolume is %d", new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.SubCoreVoiceRemind", localException1, "", new Object[0]);
          try
          {
            localk.release();
          }
          catch (Throwable localThrowable)
          {
            ab.printErrStackTrace("MicroMsg.SubCoreVoiceRemind", localThrowable, "relese error", new Object[0]);
          }
        }
      }
      break;
      Uri localUri;
      label406:
      label482:
      int i = j;
    }
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(25276);
    StringBuilder localStringBuilder = new StringBuilder();
    aw.aaz();
    localStringBuilder.append(com.tencent.mm.model.c.Rp()).append("CommonOneMicroMsg.db");
    cGT();
    com.tencent.mm.sdk.b.a.ymk.c(this.sXh);
    com.tencent.mm.sdk.b.a.ymk.c(this.sXi);
    com.tencent.mm.sdk.b.a.ymk.c(this.sXj);
    this.appForegroundListener.alive();
    ab.d("MicroMsg.SubCoreVoiceRemind", "summervoiceremind onAccountPostReset hash[%d]", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(25276);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(25278);
    if (this.sXf != null) {
      this.sXf.ckM = 0;
    }
    this.appForegroundListener.dead();
    if (sXe != null)
    {
      ab.d("MicroMsg.SubCoreVoiceRemind", "SubCoreVoiceRemind close db");
      d locald = sXe;
      if (locald.kjZ != null)
      {
        locald.kjZ.mG(locald.hashCode());
        locald.kjZ = null;
      }
      locald.eHR = "";
    }
    com.tencent.mm.sdk.b.a.ymk.d(this.sXh);
    com.tencent.mm.sdk.b.a.ymk.d(this.sXi);
    com.tencent.mm.sdk.b.a.ymk.d(this.sXj);
    AppMethodBeat.o(25278);
  }
  
  public void onSdcardMount(boolean paramBoolean)
  {
    AppMethodBeat.i(25277);
    aw.aaz();
    Object localObject = com.tencent.mm.model.c.getAccPath();
    if ((bo.isNullOrNil((String)localObject)) || (bo.isNullOrNil(this.eHR)) || (!((String)localObject).equals(this.eHR)))
    {
      ab.d("MicroMsg.SubCoreVoiceRemind", "setVoiceRemindPath core on accPath : ".concat(String.valueOf(localObject)));
      this.eHR = ((String)localObject);
      localObject = new File((String)localObject);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      aw.aaz();
      localObject = new File(com.tencent.mm.model.c.YV());
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
    }
    AppMethodBeat.o(25277);
  }
  
  public final void pn(String paramString)
  {
    AppMethodBeat.i(25271);
    aw.aaz();
    com.tencent.mm.model.c.YF().arJ(paramString);
    this.sXg.clear();
    aw.aaz();
    Cursor localCursor = com.tencent.mm.model.c.YC().Tv(paramString);
    localCursor.moveToFirst();
    ab.d("MicroMsg.SubCoreVoiceRemind", "resetSilentQuene");
    while (!localCursor.isAfterLast())
    {
      bi localbi = new bi();
      localbi.convertFrom(localCursor);
      long l = localbi.field_msgId;
      ab.d("MicroMsg.SubCoreVoiceRemind", "resetSilentQuene: msgId = " + l + " status = " + localbi.field_status);
      localCursor.moveToNext();
      this.sXg.add(Long.valueOf(l));
    }
    localCursor.close();
    aw.aaz();
    com.tencent.mm.model.c.YC().Tt(paramString);
    AppMethodBeat.o(25271);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.c.d
 * JD-Core Version:    0.7.0.1
 */