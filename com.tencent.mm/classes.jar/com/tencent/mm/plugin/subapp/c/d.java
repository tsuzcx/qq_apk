package com.tencent.mm.plugin.subapp.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import com.tencent.mm.cf.h.d;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.al;
import com.tencent.mm.model.am.d;
import com.tencent.mm.model.am.f;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bu;
import com.tencent.mm.model.s;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.platformtools.t.a;
import com.tencent.mm.plugin.subapp.ui.voicereminder.RemindDialog;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.e.f;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@SuppressLint({"UseSparseArrays"})
public class d
  implements am.f, ar
{
  private static HashMap<Integer, h.d> iiX;
  private static d pvz;
  private String dKt;
  private final Set<am.d> dup = new HashSet();
  private t.a iiZ;
  private j pvA;
  private List<Long> pvB = new ArrayList();
  private com.tencent.mm.sdk.b.c pvC = new d.3(this);
  private com.tencent.mm.sdk.b.c pvD = new d.4(this);
  private com.tencent.mm.sdk.b.c pvE = new d.5(this);
  private k pvy;
  
  static
  {
    HashMap localHashMap = new HashMap();
    iiX = localHashMap;
    localHashMap.put(Integer.valueOf("VOICEREMIND_TABLE".hashCode()), new d.2());
  }
  
  public static d bLW()
  {
    au.Hq();
    com.tencent.mm.plugin.subapp.a locala = (com.tencent.mm.plugin.subapp.a)bu.iR("plugin.subapp");
    if (locala == null) {}
    for (d locald = null;; locald = (d)locala.Py(d.class.getName()))
    {
      pvz = locald;
      y.i("MicroMsg.SubCoreVoiceRemind", "summervoice SubCoreVoiceRemind getCore subCoreSubapp[%s], theCore[%s], stack[%s]", new Object[] { locala, pvz, bk.csb() });
      if (pvz == null)
      {
        locald = new d();
        pvz = locald;
        com.tencent.mm.model.am.a.dVB = locald;
        locala.b(d.class.getName(), pvz);
      }
      return pvz;
    }
  }
  
  public static k bLX()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (bLW().pvy == null)
    {
      d locald = bLW();
      bLW();
      if (bLW().iiZ == null)
      {
        Object localObject = new StringBuilder();
        au.Hx();
        localObject = com.tencent.mm.model.c.FT() + "CommonOneMicroMsg.db";
        bLW().iiZ = t.a(d.class.hashCode(), (String)localObject, iiX, false);
      }
      locald.pvy = new k(bLW().iiZ);
    }
    return bLW().pvy;
  }
  
  public static j bLY()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (bLW().pvA == null) {
      bLW().pvA = new j();
    }
    return bLW().pvA;
  }
  
  public final void Hj()
  {
    bLY().run();
  }
  
  public final void a(am.d paramd)
  {
    y.d("MicroMsg.SubCoreVoiceRemind", "addVoiceRemind ");
    if (paramd != null) {
      this.dup.add(paramd);
    }
  }
  
  public final void b(am.d paramd)
  {
    y.d("MicroMsg.SubCoreVoiceRemind", "removeVoiceRemind ");
    if (paramd != null) {
      this.dup.remove(paramd);
    }
  }
  
  public final boolean bB(long paramLong)
  {
    boolean bool = this.pvB.contains(Long.valueOf(paramLong));
    y.d("MicroMsg.SubCoreVoiceRemind", "silent " + bool + "  mid " + paramLong);
    return bool;
  }
  
  public final void bh(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    au.Hx();
    localStringBuilder.append(com.tencent.mm.model.c.FT()).append("CommonOneMicroMsg.db");
    bLX();
    com.tencent.mm.sdk.b.a.udP.c(this.pvC);
    com.tencent.mm.sdk.b.a.udP.c(this.pvD);
    com.tencent.mm.sdk.b.a.udP.c(this.pvE);
    y.d("MicroMsg.SubCoreVoiceRemind", "summervoiceremind onAccountPostReset hash[%d]", new Object[] { Integer.valueOf(hashCode()) });
  }
  
  public final void bi(boolean paramBoolean)
  {
    au.Hx();
    Object localObject = com.tencent.mm.model.c.FU();
    if ((bk.bl((String)localObject)) || (bk.bl(this.dKt)) || (!((String)localObject).equals(this.dKt)))
    {
      y.d("MicroMsg.SubCoreVoiceRemind", "setVoiceRemindPath core on accPath : " + (String)localObject);
      this.dKt = ((String)localObject);
      localObject = new File((String)localObject);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      au.Hx();
      localObject = new File(com.tencent.mm.model.c.FR());
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
    }
  }
  
  public final void f(String paramString1, String paramString2, long paramLong)
  {
    Context localContext = ae.getContext();
    if (localContext == null)
    {
      y.d("MicroMsg.SubCoreVoiceRemind", "notifyVoiceRemind context null");
      return;
    }
    for (;;)
    {
      try
      {
        bool1 = com.tencent.mm.m.f.zV();
        bool2 = com.tencent.mm.m.f.zT();
        y.d("MicroMsg.SubCoreVoiceRemind", "shake " + bool1 + "sound " + bool2);
        if (!s.hI(au.getNotification().wo())) {
          continue;
        }
        if (bool1) {
          bk.v(localContext, true);
        }
      }
      catch (Exception localException2)
      {
        boolean bool1;
        boolean bool2;
        label88:
        Object localObject;
        com.tencent.mm.compatible.b.j localj;
        y.printErrStackTrace("MicroMsg.SubCoreVoiceRemind", localException2, "", new Object[0]);
        continue;
        localUri = Uri.parse(localException2);
        continue;
        localj.setAudioStreamType(5);
        localj.setLooping(true);
        localj.prepare();
        localj.setLooping(false);
        localj.start();
        continue;
        paramString1 = this.dup.iterator();
      }
      if ((this.dup == null) || (this.dup.size() == 0))
      {
        RemindDialog.t(localContext, paramString1, paramString2);
        return;
        if (bool1) {
          bk.v(localContext, true);
        }
        if (!bool2) {
          continue;
        }
        localObject = com.tencent.mm.m.f.zU();
        if (localObject == e.f.dAe)
        {
          localObject = RingtoneManager.getDefaultUri(2);
          localj = new com.tencent.mm.compatible.b.j();
        }
      }
    }
    for (;;)
    {
      int j;
      try
      {
        localj.setDataSource(localContext, (Uri)localObject);
        localj.setOnCompletionListener(new d.1(this));
        if (au.Hy().getStreamVolume(5) == 0) {
          break label88;
        }
        if (!au.Hy().yt()) {
          break label388;
        }
        int k = au.Hy().getStreamVolume(8);
        i = au.Hy().getStreamMaxVolume(8);
        j = au.Hy().getStreamVolume(5);
        if (j <= i) {
          break label457;
        }
        au.Hy().aX(8, i);
        localj.setAudioStreamType(8);
        localj.setLooping(true);
        localj.prepare();
        localj.setLooping(false);
        localj.start();
        au.Hy().aX(8, k);
        y.d("MicroMsg.SubCoreVoiceRemind", "oldVolume is %d, toneVolume is %d", new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.SubCoreVoiceRemind", localException1, "", new Object[0]);
          try
          {
            localj.release();
          }
          catch (Throwable localThrowable)
          {
            y.printErrStackTrace("MicroMsg.SubCoreVoiceRemind", localThrowable, "relese error", new Object[0]);
          }
        }
      }
      break label88;
      Uri localUri;
      label388:
      while (paramString1.hasNext()) {
        ((am.d)paramString1.next()).n(paramString2, paramLong);
      }
      break;
      label457:
      int i = j;
    }
  }
  
  public final void gf(int paramInt) {}
  
  public final void iE(String paramString)
  {
    au.Hx();
    com.tencent.mm.model.c.FB().abx(paramString);
    this.pvB.clear();
    au.Hx();
    Cursor localCursor = com.tencent.mm.model.c.Fy().HK(paramString);
    localCursor.moveToFirst();
    y.d("MicroMsg.SubCoreVoiceRemind", "resetSilentQuene");
    while (!localCursor.isAfterLast())
    {
      bi localbi = new bi();
      localbi.d(localCursor);
      long l = localbi.field_msgId;
      y.d("MicroMsg.SubCoreVoiceRemind", "resetSilentQuene: msgId = " + l + " status = " + localbi.field_status);
      localCursor.moveToNext();
      this.pvB.add(Long.valueOf(l));
    }
    localCursor.close();
    au.Hx();
    com.tencent.mm.model.c.Fy().HI(paramString);
  }
  
  public final void onAccountRelease()
  {
    if (this.pvA != null) {
      this.pvA.bDY = 0;
    }
    if (pvz != null)
    {
      y.d("MicroMsg.SubCoreVoiceRemind", "SubCoreVoiceRemind close db");
      d locald = pvz;
      if (locald.iiZ != null)
      {
        locald.iiZ.jK(locald.hashCode());
        locald.iiZ = null;
      }
      locald.dKt = "";
    }
    com.tencent.mm.sdk.b.a.udP.d(this.pvC);
    com.tencent.mm.sdk.b.a.udP.d(this.pvD);
    com.tencent.mm.sdk.b.a.udP.d(this.pvE);
  }
  
  public final HashMap<Integer, h.d> xe()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.c.d
 * JD-Core Version:    0.7.0.1
 */