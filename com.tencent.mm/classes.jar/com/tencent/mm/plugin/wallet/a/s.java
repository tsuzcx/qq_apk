package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.c;
import com.tencent.mm.an.h.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.be;
import com.tencent.mm.model.ck;
import com.tencent.mm.model.y;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.plugin.wallet_core.model.ac;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.PhoneFormater;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.vfs.q;
import com.tencent.mm.wallet_core.d.a;
import java.util.HashMap;
import java.util.Map;

public class s
  implements be
{
  private int OwR;
  private r OwS;
  private ac OwT;
  private k OwU;
  private MStorageEx.IOnStorageChange OwV;
  private d.a OwW;
  private IListener OwX;
  private t OwY;
  private l OwZ;
  private int fZX;
  
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
    this.OwR = 0;
    this.fZX = 0;
    this.OwS = new r();
    this.OwT = new ac();
    this.OwU = new k();
    this.OwV = new MStorageEx.IOnStorageChange()
    {
      public final void onNotifyChange(int paramAnonymousInt, MStorageEx paramAnonymousMStorageEx, Object paramAnonymousObject)
      {
        AppMethodBeat.i(69189);
        if (Util.nullAsInt(paramAnonymousObject, 0) == 339975)
        {
          h.aHH();
          paramAnonymousInt = ((Integer)h.aHG().aHp().b(339975, Integer.valueOf(0))).intValue();
          if (paramAnonymousInt != s.a(s.this))
          {
            ap.hhK().reset();
            s.a(s.this, paramAnonymousInt);
          }
          AppMethodBeat.o(69189);
          return;
        }
        if (ar.a.VlG.equals(paramAnonymousObject))
        {
          h.aHH();
          paramAnonymousInt = ((Integer)h.aHG().aHp().get(ar.a.VlG, Integer.valueOf(0))).intValue();
          if (paramAnonymousInt != s.b(s.this))
          {
            ap.hhK().reset();
            s.b(s.this, paramAnonymousInt);
          }
        }
        AppMethodBeat.o(69189);
      }
    };
    this.OwW = new s.2(this);
    this.OwX = new s.3(this);
    this.OwY = new t()
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
          c.aFn().b(ar.a.VrE, true);
          if (j != 1) {
            break label273;
          }
          c.aFn().b(ar.a.VrF, true);
        }
        for (;;)
        {
          if (!Util.isNullOrNil(paramAnonymousString))
          {
            h.aHH();
            h.aHG().aHp().set(ar.a.VrH, paramAnonymousString);
          }
          if (!Util.isNullOrNil(paramAnonymousa))
          {
            h.aHH();
            paramAnonymousMap = (String)h.aHG().aHp().get(ar.a.VrI, "");
            paramAnonymousString = paramAnonymousa;
            if (!Util.isNullOrNil(paramAnonymousMap)) {
              paramAnonymousString = paramAnonymousMap + "," + paramAnonymousa;
            }
            h.aHH();
            h.aHG().aHp().set(ar.a.VrI, paramAnonymousString);
          }
          AppMethodBeat.o(69192);
          return;
          label260:
          c.aFn().b(ar.a.VrE, false);
          break;
          label273:
          c.aFn().b(ar.a.VrF, false);
        }
      }
    };
    this.OwZ = new l();
    q localq = new q(com.tencent.mm.plugin.wallet_core.d.b.gKS());
    if (!localq.ifE()) {
      localq.ifK();
    }
    AppMethodBeat.o(69193);
  }
  
  public static String bkY()
  {
    AppMethodBeat.i(69198);
    h.aHH();
    String str1 = (String)h.aHG().aHp().b(6, null);
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
  
  public static s gGL()
  {
    AppMethodBeat.i(69194);
    s locals = (s)y.as(s.class);
    AppMethodBeat.o(69194);
    return locals;
  }
  
  public static com.tencent.mm.plugin.wallet_core.model.ao gGM()
  {
    AppMethodBeat.i(69197);
    com.tencent.mm.plugin.wallet_core.model.ao localao = u.gJo();
    AppMethodBeat.o(69197);
    return localao;
  }
  
  public static String gGN()
  {
    AppMethodBeat.i(69199);
    h.aHH();
    String str1 = (String)h.aHG().aHp().b(6, null);
    if (Util.isNullOrNil(str1))
    {
      str1 = "";
      str2 = str1;
      if (Util.isNullOrNil(str1)) {
        if (!z.bdq()) {
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
    h.aHH();
    this.OwR = ((Integer)h.aHG().aHp().b(339975, Integer.valueOf(0))).intValue();
    h.aHH();
    this.fZX = ((Integer)h.aHG().aHp().get(ar.a.VlG, Integer.valueOf(0))).intValue();
    ((v)h.ag(v.class)).getSysCmdMsgExtension().a("paymsg", this.OwY);
    EventCenter.instance.addListener(this.OwS);
    EventCenter.instance.addListener(this.OwT);
    EventCenter.instance.addListener(this.OwU);
    this.OwX.alive();
    this.OwZ.alive();
    h.aHH();
    h.aHG().aHp().add(this.OwV);
    h.aHH();
    h.aHG().aHp().set(ar.a.VuA, Boolean.FALSE);
    AppMethodBeat.o(69195);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(69196);
    ((v)h.ag(v.class)).getSysCmdMsgExtension().b("paymsg", this.OwY);
    EventCenter.instance.removeListener(this.OwS);
    EventCenter.instance.removeListener(this.OwT);
    EventCenter.instance.removeListener(this.OwU);
    this.OwX.dead();
    this.OwZ.dead();
    h.aHH();
    h.aHG().aHp().remove(this.OwV);
    AppMethodBeat.o(69196);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.s
 * JD-Core Version:    0.7.0.1
 */