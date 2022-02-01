package com.tencent.mm.plugin.wallet.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.c;
import com.tencent.mm.am.g.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.be;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.y;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.plugin.wallet_core.model.WalletGetUserInfoEventListener;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.pluginsdk.model.app.at;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.PhoneFormater;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.wallet_core.e.a;
import java.util.HashMap;
import java.util.Map;

public class p
  implements be
{
  private int Vmc;
  private SaveBankLogoEventListener Vmd;
  private WalletGetUserInfoEventListener Vme;
  private GetFtfNecessaryElementsListener Vmf;
  private MStorageEx.IOnStorageChange Vmg;
  private e.a Vmh;
  private IListener Vmi;
  private t Vmj;
  private HandleWCPayWalletBufferListener Vmk;
  private int igf;
  
  static
  {
    AppMethodBeat.i(69200);
    com.tencent.mm.wallet_core.a.n("ForgotPwdProcess", com.tencent.mm.plugin.wallet.pwd.a.class);
    com.tencent.mm.wallet_core.a.n("BindCardProcess", com.tencent.mm.plugin.wallet_core.b.b.class);
    AppMethodBeat.o(69200);
  }
  
  public p()
  {
    AppMethodBeat.i(69193);
    this.Vmc = 0;
    this.igf = 0;
    this.Vmd = new SaveBankLogoEventListener();
    this.Vme = new WalletGetUserInfoEventListener();
    this.Vmf = new GetFtfNecessaryElementsListener();
    this.Vmg = new MStorageEx.IOnStorageChange()
    {
      public final void onNotifyChange(int paramAnonymousInt, MStorageEx paramAnonymousMStorageEx, Object paramAnonymousObject)
      {
        AppMethodBeat.i(69189);
        if (Util.nullAsInt(paramAnonymousObject, 0) == 339975)
        {
          h.baF();
          paramAnonymousInt = ((Integer)h.baE().ban().d(339975, Integer.valueOf(0))).intValue();
          if (paramAnonymousInt != p.a(p.this))
          {
            at.iIM().reset();
            p.a(p.this, paramAnonymousInt);
          }
          AppMethodBeat.o(69189);
          return;
        }
        if (at.a.acNa.equals(paramAnonymousObject))
        {
          h.baF();
          paramAnonymousInt = ((Integer)h.baE().ban().get(at.a.acNa, Integer.valueOf(0))).intValue();
          if (paramAnonymousInt != p.b(p.this))
          {
            at.iIM().reset();
            p.b(p.this, paramAnonymousInt);
          }
        }
        AppMethodBeat.o(69189);
      }
    };
    this.Vmh = new p.2(this);
    this.Vmi = new SubCoreWallet.3(this, com.tencent.mm.app.f.hfK);
    this.Vmj = new t()
    {
      public final void onNewXmlReceived(String paramAnonymousString, Map<String, String> paramAnonymousMap, g.a paramAnonymousa)
      {
        AppMethodBeat.i(69192);
        if (("paymsg".equals(paramAnonymousString)) && ("30".equals(paramAnonymousMap.get(".sysmsg.paymsg.PayMsgType"))))
        {
          int i = Util.getInt((String)paramAnonymousMap.get(".sysmsg.paymsg.WalletRedDot"), 0);
          int j = Util.getInt((String)paramAnonymousMap.get(".sysmsg.paymsg.BankCardRedDot"), 0);
          paramAnonymousa = (String)paramAnonymousMap.get(".sysmsg.paymsg.NewTagBankSerial");
          paramAnonymousString = (String)paramAnonymousMap.get(".sysmsg.paymsg.WalletRedDotWording");
          Log.i("MicroMsg.SubCoreMMWallet", "moreTabWallet: %s, walletBankCard: %s, bankSerial: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), paramAnonymousa });
          if (i != 1) {
            break label260;
          }
          c.aYo().b(at.a.acTi, true);
          if (j != 1) {
            break label273;
          }
          c.aYo().b(at.a.acTj, true);
        }
        for (;;)
        {
          if (!Util.isNullOrNil(paramAnonymousString))
          {
            h.baF();
            h.baE().ban().set(at.a.acTl, paramAnonymousString);
          }
          if (!Util.isNullOrNil(paramAnonymousa))
          {
            h.baF();
            paramAnonymousMap = (String)h.baE().ban().get(at.a.acTm, "");
            paramAnonymousString = paramAnonymousa;
            if (!Util.isNullOrNil(paramAnonymousMap)) {
              paramAnonymousString = paramAnonymousMap + "," + paramAnonymousa;
            }
            h.baF();
            h.baE().ban().set(at.a.acTm, paramAnonymousString);
          }
          AppMethodBeat.o(69192);
          return;
          label260:
          c.aYo().b(at.a.acTi, false);
          break;
          label273:
          c.aYo().b(at.a.acTj, false);
        }
      }
    };
    this.Vmk = new HandleWCPayWalletBufferListener();
    com.tencent.mm.vfs.u localu = new com.tencent.mm.vfs.u(com.tencent.mm.plugin.wallet_core.d.b.ikk());
    if (!localu.jKS()) {
      localu.jKY();
    }
    AppMethodBeat.o(69193);
  }
  
  public static String bIS()
  {
    AppMethodBeat.i(69198);
    h.baF();
    String str1 = (String)h.baE().ban().d(6, null);
    String str2 = PhoneFormater.extractCountryCode(str1);
    if (Util.isNullOrNil(str1))
    {
      AppMethodBeat.o(69198);
      return "";
    }
    str1 = str1.substring(str2.length() + 1);
    AppMethodBeat.o(69198);
    return str1;
  }
  
  public static p ifO()
  {
    AppMethodBeat.i(69194);
    p localp = (p)y.aL(p.class);
    AppMethodBeat.o(69194);
    return localp;
  }
  
  public static am ifP()
  {
    AppMethodBeat.i(69197);
    am localam = com.tencent.mm.plugin.wallet_core.model.u.iiC();
    AppMethodBeat.o(69197);
    return localam;
  }
  
  public static String ifQ()
  {
    AppMethodBeat.i(69199);
    h.baF();
    String str1 = (String)h.baE().ban().d(6, null);
    if (Util.isNullOrNil(str1))
    {
      str1 = "";
      str2 = str1;
      if (Util.isNullOrNil(str1)) {
        if (!z.bBi()) {
          break label75;
        }
      }
    }
    label75:
    for (String str2 = "27";; str2 = "86")
    {
      AppMethodBeat.o(69199);
      return str2;
      str1 = PhoneFormater.extractCountryCode(str1.replace("+", ""));
      break;
    }
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(69195);
    h.baF();
    this.Vmc = ((Integer)h.baE().ban().d(339975, Integer.valueOf(0))).intValue();
    h.baF();
    this.igf = ((Integer)h.baE().ban().get(at.a.acNa, Integer.valueOf(0))).intValue();
    ((v)h.az(v.class)).getSysCmdMsgExtension().a("paymsg", this.Vmj);
    this.Vmd.alive();
    this.Vme.alive();
    this.Vmf.alive();
    this.Vmi.alive();
    this.Vmk.alive();
    h.baF();
    h.baE().ban().add(this.Vmg);
    h.baF();
    h.baE().ban().set(at.a.acWj, Boolean.FALSE);
    AppMethodBeat.o(69195);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(69196);
    ((v)h.az(v.class)).getSysCmdMsgExtension().b("paymsg", this.Vmj);
    this.Vmd.dead();
    this.Vme.dead();
    this.Vmf.dead();
    this.Vmi.dead();
    this.Vmk.dead();
    h.baF();
    h.baE().ban().remove(this.Vmg);
    AppMethodBeat.o(69196);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.model.p
 * JD-Core Version:    0.7.0.1
 */