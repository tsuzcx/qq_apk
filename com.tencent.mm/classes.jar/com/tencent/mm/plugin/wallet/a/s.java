package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.g.a.zm;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.cj;
import com.tencent.mm.model.y;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.plugin.wallet_core.model.ab;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.PhoneFormater;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.vfs.o;
import com.tencent.mm.wallet_core.d.a;
import com.tencent.mm.y.c;
import java.util.HashMap;
import java.util.Map;

public class s
  implements bd
{
  private int HEY;
  private r HEZ;
  private ab HFa;
  private k HFb;
  private MStorageEx.IOnStorageChange HFc;
  private d.a HFd;
  private IListener HFe;
  private q HFf;
  private l HFg;
  private int efI;
  
  static
  {
    AppMethodBeat.i(69200);
    com.tencent.mm.wallet_core.a.j("ForgotPwdProcess", com.tencent.mm.plugin.wallet.pwd.a.class);
    com.tencent.mm.wallet_core.a.j("BindCardProcess", com.tencent.mm.plugin.wallet_core.b.b.class);
    AppMethodBeat.o(69200);
  }
  
  public s()
  {
    AppMethodBeat.i(69193);
    this.HEY = 0;
    this.efI = 0;
    this.HEZ = new r();
    this.HFa = new ab();
    this.HFb = new k();
    this.HFc = new MStorageEx.IOnStorageChange()
    {
      public final void onNotifyChange(int paramAnonymousInt, MStorageEx paramAnonymousMStorageEx, Object paramAnonymousObject)
      {
        AppMethodBeat.i(69189);
        if (Util.nullAsInt(paramAnonymousObject, 0) == 339975)
        {
          g.aAi();
          paramAnonymousInt = ((Integer)g.aAh().azQ().get(339975, Integer.valueOf(0))).intValue();
          if (paramAnonymousInt != s.a(s.this))
          {
            ap.gni().reset();
            s.a(s.this, paramAnonymousInt);
          }
          AppMethodBeat.o(69189);
          return;
        }
        if (ar.a.NXG.equals(paramAnonymousObject))
        {
          g.aAi();
          paramAnonymousInt = ((Integer)g.aAh().azQ().get(ar.a.NXG, Integer.valueOf(0))).intValue();
          if (paramAnonymousInt != s.b(s.this))
          {
            ap.gni().reset();
            s.b(s.this, paramAnonymousInt);
          }
        }
        AppMethodBeat.o(69189);
      }
    };
    this.HFd = new s.2(this);
    this.HFe = new IListener() {};
    this.HFf = new q()
    {
      public final void onNewXmlReceived(String paramAnonymousString, Map<String, String> paramAnonymousMap, h.a paramAnonymousa)
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
          c.axV().b(ar.a.Odt, true);
          if (j != 1) {
            break label273;
          }
          c.axV().b(ar.a.Odu, true);
        }
        for (;;)
        {
          if (!Util.isNullOrNil(paramAnonymousString))
          {
            g.aAi();
            g.aAh().azQ().set(ar.a.Odw, paramAnonymousString);
          }
          if (!Util.isNullOrNil(paramAnonymousa))
          {
            g.aAi();
            paramAnonymousMap = (String)g.aAh().azQ().get(ar.a.Odx, "");
            paramAnonymousString = paramAnonymousa;
            if (!Util.isNullOrNil(paramAnonymousMap)) {
              paramAnonymousString = paramAnonymousMap + "," + paramAnonymousa;
            }
            g.aAi();
            g.aAh().azQ().set(ar.a.Odx, paramAnonymousString);
          }
          AppMethodBeat.o(69192);
          return;
          label260:
          c.axV().b(ar.a.Odt, false);
          break;
          label273:
          c.axV().b(ar.a.Odu, false);
        }
      }
    };
    this.HFg = new l();
    o localo = new o(com.tencent.mm.plugin.wallet_core.d.b.fSn());
    if (!localo.exists()) {
      localo.mkdirs();
    }
    AppMethodBeat.o(69193);
  }
  
  public static String bbI()
  {
    AppMethodBeat.i(69198);
    g.aAi();
    String str1 = (String)g.aAh().azQ().get(6, null);
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
  
  public static s fOg()
  {
    AppMethodBeat.i(69194);
    s locals = (s)y.at(s.class);
    AppMethodBeat.o(69194);
    return locals;
  }
  
  public static an fOh()
  {
    AppMethodBeat.i(69197);
    an localan = t.fQI();
    AppMethodBeat.o(69197);
    return localan;
  }
  
  public static String fOi()
  {
    AppMethodBeat.i(69199);
    g.aAi();
    String str1 = (String)g.aAh().azQ().get(6, null);
    if (Util.isNullOrNil(str1))
    {
      str1 = "";
      str2 = str1;
      if (Util.isNullOrNil(str1)) {
        if (!z.aUo()) {
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
    g.aAi();
    this.HEY = ((Integer)g.aAh().azQ().get(339975, Integer.valueOf(0))).intValue();
    g.aAi();
    this.efI = ((Integer)g.aAh().azQ().get(ar.a.NXG, Integer.valueOf(0))).intValue();
    ((com.tencent.mm.plugin.messenger.foundation.a.s)g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().a("paymsg", this.HFf);
    EventCenter.instance.addListener(this.HEZ);
    EventCenter.instance.addListener(this.HFa);
    EventCenter.instance.addListener(this.HFb);
    this.HFe.alive();
    this.HFg.alive();
    g.aAi();
    g.aAh().azQ().add(this.HFc);
    g.aAi();
    g.aAh().azQ().set(ar.a.Ogk, Boolean.FALSE);
    AppMethodBeat.o(69195);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(69196);
    ((com.tencent.mm.plugin.messenger.foundation.a.s)g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().b("paymsg", this.HFf);
    EventCenter.instance.removeListener(this.HEZ);
    EventCenter.instance.removeListener(this.HFa);
    EventCenter.instance.removeListener(this.HFb);
    this.HFe.dead();
    this.HFg.dead();
    g.aAi();
    g.aAh().azQ().remove(this.HFc);
    AppMethodBeat.o(69196);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.s
 * JD-Core Version:    0.7.0.1
 */