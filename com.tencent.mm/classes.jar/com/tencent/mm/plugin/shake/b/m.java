package com.tencent.mm.plugin.shake.b;

import android.os.Looper;
import com.tencent.mm.ah.e.a;
import com.tencent.mm.cf.h.d;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bx;
import com.tencent.mm.model.bx.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.shake.c.a.f;
import com.tencent.mm.plugin.shake.d.a.o;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bd.a;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.be.a;
import java.util.HashMap;

public final class m
  implements ar
{
  private static HashMap<Integer, h.d> dgp;
  private be.a dVR = new m.2(this);
  private com.tencent.mm.sdk.b.c dmt = new m.7(this);
  private bd.a mCF = new bd.a()
  {
    public final void a(bd paramAnonymousbd, ad paramAnonymousad)
    {
      if ((paramAnonymousbd != null) && (paramAnonymousad != null) && (paramAnonymousad.Bg())) {
        m.bzU().Mu(paramAnonymousad.field_username);
      }
    }
  };
  private ah mHandler = new ah(Looper.getMainLooper());
  private com.tencent.mm.sdk.b.c mzB = new m.6(this);
  private e nYZ;
  private g nZa;
  private f nZb;
  private com.tencent.mm.plugin.shake.c.a.d nZc;
  private o nZd;
  private n nZe = new n();
  com.tencent.mm.pluginsdk.c.d nZf = new m.1(this);
  private bx.a nZg = new m.13(this);
  private com.tencent.mm.sdk.b.c nZh = new m.3(this);
  private bx.a nZi = new m.4(this);
  private bx.a nZj = new bx.a()
  {
    public final void a(e.a paramAnonymousa)
    {
      String str = aa.a(paramAnonymousa.dBs.svH);
      if ((str == null) || (str.length() == 0))
      {
        y.e("MicroMsg.SubCoreShake", "onReceiveMsg, ShakeCardRedDotMsg msgContent is null");
        return;
      }
      m.a(m.this).post(new m.5.1(this, str, paramAnonymousa));
    }
  };
  
  static
  {
    HashMap localHashMap = new HashMap();
    dgp = localHashMap;
    localHashMap.put(Integer.valueOf("SHAKEITEM_TABLE".hashCode()), new m.8());
    dgp.put(Integer.valueOf("SHAKEMSG_TABLE".hashCode()), new m.9());
    dgp.put(Integer.valueOf("SHAKETVHISTORY_TABLE".hashCode()), new m.10());
    dgp.put(Integer.valueOf("SHAKENEWYEARFRIENDINFO_TABLE".hashCode()), new m.11());
  }
  
  public static com.tencent.mm.plugin.shake.c.a.d bAa()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (bzT().nZc == null) {
      bzT().nZc = new com.tencent.mm.plugin.shake.c.a.d();
    }
    return bzT().nZc;
  }
  
  private static m bzT()
  {
    au.Hq();
    m localm2 = (m)com.tencent.mm.model.bu.iR("plugin.shake");
    m localm1 = localm2;
    if (localm2 == null)
    {
      localm1 = new m();
      au.Hq().a("plugin.shake", localm1);
    }
    return localm1;
  }
  
  public static e bzU()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (bzT().nYZ == null)
    {
      m localm = bzT();
      au.Hx();
      localm.nYZ = new e(com.tencent.mm.model.c.Dv());
    }
    return bzT().nYZ;
  }
  
  public static g bzV()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (bzT().nZa == null)
    {
      m localm = bzT();
      au.Hx();
      localm.nZa = new g(com.tencent.mm.model.c.Dv());
    }
    return bzT().nZa;
  }
  
  public static o bzW()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (bzT().nZd == null)
    {
      m localm = bzT();
      au.Hx();
      localm.nZd = new o(com.tencent.mm.model.c.Dv());
    }
    return bzT().nZd;
  }
  
  public static void bzX()
  {
    bzU().bzL();
    com.tencent.mm.bh.d.Sa().aUK();
  }
  
  public static i bzY()
  {
    com.tencent.mm.kernel.g.DN().CX();
    return i.nYO;
  }
  
  public static f bzZ()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (bzT().nZb == null) {
      bzT().nZb = new f();
    }
    return bzT().nZb;
  }
  
  public static String eA(String paramString1, String paramString2)
  {
    if ((au.DK()) && (!bk.bl(paramString1)))
    {
      au.Hx();
      return String.format("%s/Sk%s_%s", new Object[] { com.tencent.mm.model.c.FM(), paramString2, com.tencent.mm.a.g.o(paramString1.getBytes()) });
    }
    return "";
  }
  
  public static String mm(String paramString)
  {
    if (au.DK())
    {
      au.Hx();
      return String.format("%s/Sk_%s", new Object[] { com.tencent.mm.model.c.FM(), com.tencent.mm.a.g.o(paramString.getBytes()) });
    }
    return "";
  }
  
  public final void bh(boolean paramBoolean)
  {
    com.tencent.mm.pluginsdk.o.a.rSE = new h();
    au.Hx();
    com.tencent.mm.model.c.FB().c(this.dVR);
    com.tencent.mm.sdk.b.a.udP.c(this.dmt);
    com.tencent.mm.sdk.b.a.udP.c(this.nZh);
    com.tencent.mm.sdk.b.a.udP.c(this.nZe);
    com.tencent.mm.sdk.b.a.udP.c(this.mzB);
    au.Hx();
    com.tencent.mm.model.c.Fw().a(this.mCF);
    au.DS().O(new m.12(this));
    au.getSysCmdMsgExtension().a("shake", this.nZg, true);
    au.getSysCmdMsgExtension().a("ShakeCardEntrance", this.nZi, true);
    au.getSysCmdMsgExtension().a("ShakeCardRedDot", this.nZj, true);
    this.nZb = null;
    this.nZc = null;
  }
  
  public final void bi(boolean paramBoolean) {}
  
  public final void gf(int paramInt) {}
  
  public final void onAccountRelease()
  {
    au.Hx();
    com.tencent.mm.model.c.FB().d(this.dVR);
    com.tencent.mm.sdk.b.a.udP.d(this.dmt);
    com.tencent.mm.sdk.b.a.udP.d(this.nZh);
    com.tencent.mm.sdk.b.a.udP.d(this.nZe);
    com.tencent.mm.sdk.b.a.udP.d(this.mzB);
    au.Hx();
    com.tencent.mm.model.c.Fw().b(this.mCF);
    au.getSysCmdMsgExtension().b("shake", this.nZg, true);
    au.getSysCmdMsgExtension().b("ShakeCardEntrance", this.nZi, true);
    au.getSysCmdMsgExtension().b("ShakeCardRedDot", this.nZj, true);
    com.tencent.mm.pluginsdk.o.a.rSE = null;
  }
  
  public final HashMap<Integer, h.d> xe()
  {
    return dgp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.b.m
 * JD-Core Version:    0.7.0.1
 */