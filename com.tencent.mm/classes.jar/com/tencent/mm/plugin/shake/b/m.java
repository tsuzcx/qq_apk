package com.tencent.mm.plugin.shake.b;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.g.a.oo;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.at;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bw;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.bz.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.shake.c.a.f;
import com.tencent.mm.plugin.shake.d.a.o;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bd.a;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.be.a;
import com.tencent.mm.storage.bu;
import java.util.HashMap;

public final class m
  implements at
{
  private static HashMap<Integer, h.d> baseDBFactories;
  private com.tencent.mm.sdk.b.c edW;
  private be.a fmb;
  private ak mHandler;
  private com.tencent.mm.sdk.b.c oZH;
  private bd.a pcw;
  private e qNj;
  private g qNk;
  private f qNl;
  private com.tencent.mm.plugin.shake.c.a.d qNm;
  private o qNn;
  private n qNo;
  com.tencent.mm.pluginsdk.c.d qNp;
  private bz.a qNq;
  private com.tencent.mm.sdk.b.c qNr;
  private bz.a qNs;
  private bz.a qNt;
  
  static
  {
    AppMethodBeat.i(24505);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("SHAKEITEM_TABLE".hashCode()), new m.8());
    baseDBFactories.put(Integer.valueOf("SHAKEMSG_TABLE".hashCode()), new m.9());
    baseDBFactories.put(Integer.valueOf("SHAKETVHISTORY_TABLE".hashCode()), new m.10());
    baseDBFactories.put(Integer.valueOf("SHAKENEWYEARFRIENDINFO_TABLE".hashCode()), new m.11());
    AppMethodBeat.o(24505);
  }
  
  public m()
  {
    AppMethodBeat.i(24491);
    this.mHandler = new ak(Looper.getMainLooper());
    this.qNo = new n();
    this.qNp = new m.1(this);
    this.edW = new m.7(this);
    this.qNq = new m.13(this);
    this.pcw = new bd.a()
    {
      public final void a(bd paramAnonymousbd, ad paramAnonymousad)
      {
        AppMethodBeat.i(24490);
        if ((paramAnonymousbd != null) && (paramAnonymousad != null) && (paramAnonymousad.NW())) {
          m.cln().Za(paramAnonymousad.field_username);
        }
        AppMethodBeat.o(24490);
      }
    };
    this.fmb = new m.2(this);
    this.qNr = new com.tencent.mm.sdk.b.c() {};
    this.qNs = new m.4(this);
    this.qNt = new bz.a()
    {
      public final void a(e.a paramAnonymousa)
      {
        AppMethodBeat.i(24482);
        String str = aa.a(paramAnonymousa.eyJ.woR);
        if ((str == null) || (str.length() == 0))
        {
          ab.e("MicroMsg.SubCoreShake", "onReceiveMsg, ShakeCardRedDotMsg msgContent is null");
          AppMethodBeat.o(24482);
          return;
        }
        m.a(m.this).post(new m.5.1(this, str, paramAnonymousa));
        AppMethodBeat.o(24482);
      }
    };
    this.oZH = new m.6(this);
    AppMethodBeat.o(24491);
  }
  
  private static m clm()
  {
    AppMethodBeat.i(24492);
    aw.aat();
    m localm2 = (m)bw.pF("plugin.shake");
    m localm1 = localm2;
    if (localm2 == null)
    {
      localm1 = new m();
      aw.aat().a("plugin.shake", localm1);
    }
    AppMethodBeat.o(24492);
    return localm1;
  }
  
  public static e cln()
  {
    AppMethodBeat.i(24493);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (clm().qNj == null)
    {
      localObject = clm();
      aw.aaz();
      ((m)localObject).qNj = new e(com.tencent.mm.model.c.Rq());
    }
    Object localObject = clm().qNj;
    AppMethodBeat.o(24493);
    return localObject;
  }
  
  public static g clo()
  {
    AppMethodBeat.i(24494);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (clm().qNk == null)
    {
      localObject = clm();
      aw.aaz();
      ((m)localObject).qNk = new g(com.tencent.mm.model.c.Rq());
    }
    Object localObject = clm().qNk;
    AppMethodBeat.o(24494);
    return localObject;
  }
  
  public static o clp()
  {
    AppMethodBeat.i(24495);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (clm().qNn == null)
    {
      localObject = clm();
      aw.aaz();
      ((m)localObject).qNn = new o(com.tencent.mm.model.c.Rq());
    }
    Object localObject = clm().qNn;
    AppMethodBeat.o(24495);
    return localObject;
  }
  
  public static void clq()
  {
    AppMethodBeat.i(24497);
    cln().clc();
    com.tencent.mm.bi.d.alk().axH();
    AppMethodBeat.o(24497);
  }
  
  public static i clr()
  {
    AppMethodBeat.i(24499);
    com.tencent.mm.kernel.g.RJ().QQ();
    i locali = i.qMY;
    AppMethodBeat.o(24499);
    return locali;
  }
  
  public static f cls()
  {
    AppMethodBeat.i(24502);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (clm().qNl == null) {
      clm().qNl = new f();
    }
    f localf = clm().qNl;
    AppMethodBeat.o(24502);
    return localf;
  }
  
  public static com.tencent.mm.plugin.shake.c.a.d clt()
  {
    AppMethodBeat.i(24503);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (clm().qNm == null) {
      clm().qNm = new com.tencent.mm.plugin.shake.c.a.d();
    }
    com.tencent.mm.plugin.shake.c.a.d locald = clm().qNm;
    AppMethodBeat.o(24503);
    return locald;
  }
  
  public static String gb(String paramString1, String paramString2)
  {
    AppMethodBeat.i(24501);
    if ((aw.RG()) && (!bo.isNullOrNil(paramString1)))
    {
      aw.aaz();
      paramString1 = String.format("%s/Sk%s_%s", new Object[] { com.tencent.mm.model.c.YQ(), paramString2, com.tencent.mm.a.g.w(paramString1.getBytes()) });
      AppMethodBeat.o(24501);
      return paramString1;
    }
    AppMethodBeat.o(24501);
    return "";
  }
  
  public static String tr(String paramString)
  {
    AppMethodBeat.i(24500);
    if (aw.RG())
    {
      aw.aaz();
      paramString = String.format("%s/Sk_%s", new Object[] { com.tencent.mm.model.c.YQ(), com.tencent.mm.a.g.w(paramString.getBytes()) });
      AppMethodBeat.o(24500);
      return paramString;
    }
    AppMethodBeat.o(24500);
    return "";
  }
  
  public final void clearPluginData(int paramInt) {}
  
  public final HashMap<Integer, h.d> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(24498);
    com.tencent.mm.pluginsdk.p.a.vJB = new h();
    aw.aaz();
    com.tencent.mm.model.c.YF().c(this.fmb);
    com.tencent.mm.sdk.b.a.ymk.c(this.edW);
    com.tencent.mm.sdk.b.a.ymk.c(this.qNr);
    com.tencent.mm.sdk.b.a.ymk.c(this.qNo);
    com.tencent.mm.sdk.b.a.ymk.c(this.oZH);
    aw.aaz();
    com.tencent.mm.model.c.YA().a(this.pcw);
    aw.RO().ac(new m.12(this));
    aw.getSysCmdMsgExtension().a("shake", this.qNq, true);
    aw.getSysCmdMsgExtension().a("ShakeCardEntrance", this.qNs, true);
    aw.getSysCmdMsgExtension().a("ShakeCardRedDot", this.qNt, true);
    this.qNl = null;
    this.qNm = null;
    AppMethodBeat.o(24498);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(24496);
    aw.aaz();
    com.tencent.mm.model.c.YF().d(this.fmb);
    com.tencent.mm.sdk.b.a.ymk.d(this.edW);
    com.tencent.mm.sdk.b.a.ymk.d(this.qNr);
    com.tencent.mm.sdk.b.a.ymk.d(this.qNo);
    com.tencent.mm.sdk.b.a.ymk.d(this.oZH);
    aw.aaz();
    com.tencent.mm.model.c.YA().b(this.pcw);
    aw.getSysCmdMsgExtension().b("shake", this.qNq, true);
    aw.getSysCmdMsgExtension().b("ShakeCardEntrance", this.qNs, true);
    aw.getSysCmdMsgExtension().b("ShakeCardRedDot", this.qNt, true);
    com.tencent.mm.pluginsdk.p.a.vJB = null;
    AppMethodBeat.o(24496);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.b.m
 * JD-Core Version:    0.7.0.1
 */