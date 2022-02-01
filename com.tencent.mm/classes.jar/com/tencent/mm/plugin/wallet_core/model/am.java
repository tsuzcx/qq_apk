package com.tencent.mm.plugin.wallet_core.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.d.k;
import com.tencent.mm.protocal.protobuf.buc;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.wallet_core.ui.e.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class am
{
  public ArrayList<Bankcard> Aif;
  private ArrayList<Bankcard> Aig;
  public al Aih;
  public Bankcard Aii;
  public ak Aij;
  public n Aik;
  public b Ail;
  private List<c> Aim;
  public Bankcard Ain;
  public buc Aio;
  public long Aip;
  long Aiq;
  public long Air;
  private String Ais;
  public int Ait;
  public String Aiu;
  public String Aiv;
  public int mRetryCount;
  int zGB;
  int zGC;
  public Bankcard zHd;
  private ArrayList<Bankcard> zNg;
  private ArrayList<Bankcard> zNh;
  
  public am()
  {
    AppMethodBeat.i(70494);
    this.Aif = new ArrayList();
    this.Aig = new ArrayList();
    this.zNg = new ArrayList();
    this.zNh = new ArrayList();
    this.Aih = null;
    this.Aii = null;
    this.zHd = null;
    this.Aij = null;
    this.Aik = null;
    this.Ail = null;
    this.Aim = new LinkedList();
    this.Ain = null;
    this.zGB = 0;
    this.zGC = 0;
    this.Aip = bt.aGK();
    this.Aiq = 0L;
    this.Air = -1L;
    this.Ais = "";
    this.Ait = 10000;
    this.mRetryCount = 0;
    this.Aiu = "";
    this.Aiv = "";
    ecT();
    AppMethodBeat.o(70494);
  }
  
  public static void atV(String paramString)
  {
    AppMethodBeat.i(70523);
    if (!bt.isNullOrNil(paramString))
    {
      g.afC();
      g.afB().afk().set(196612, paramString);
    }
    AppMethodBeat.o(70523);
  }
  
  private static void atW(String paramString)
  {
    AppMethodBeat.i(70528);
    if (paramString != null)
    {
      g.afC();
      g.afB().afk().set(196633, paramString);
    }
    AppMethodBeat.o(70528);
  }
  
  public static void atX(String paramString)
  {
    AppMethodBeat.i(70532);
    ad.i("MicroMsg.WalletUserInfoManger", "setSelectBindSerial %s %s", new Object[] { paramString, bt.eGN().toString() });
    atW(paramString);
    AppMethodBeat.o(70532);
  }
  
  @Deprecated
  private Bankcard b(ArrayList<Bankcard> paramArrayList, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(70526);
    Object localObject1 = paramArrayList;
    if (paramArrayList == null) {
      localObject1 = this.zNg;
    }
    paramArrayList = paramString;
    if (bt.isNullOrNil(paramString)) {
      paramArrayList = edi();
    }
    if ((paramBoolean1) && (this.zHd != null))
    {
      if (ecG())
      {
        paramArrayList = this.zHd;
        AppMethodBeat.o(70526);
        return paramArrayList;
      }
      if ((paramArrayList != null) && (paramArrayList.equals(this.zHd.field_bindSerial)))
      {
        paramArrayList = this.zHd;
        AppMethodBeat.o(70526);
        return paramArrayList;
      }
      if ((this.Ain != null) && (this.Aih != null) && (this.Aih.field_lqt_state == 1) && (paramArrayList != null) && (paramArrayList.equals(this.Ain.field_bindSerial)))
      {
        paramArrayList = this.Ain;
        AppMethodBeat.o(70526);
        return paramArrayList;
      }
      if ((!ecH()) && ((localObject1 == null) || (((ArrayList)localObject1).size() == 0)))
      {
        paramArrayList = this.zHd;
        AppMethodBeat.o(70526);
        return paramArrayList;
      }
    }
    if ((localObject1 == null) || (((ArrayList)localObject1).size() <= 0))
    {
      ad.e("MicroMsg.WalletUserInfoManger", "not found bankcard!");
      AppMethodBeat.o(70526);
      return null;
    }
    if ((((ArrayList)localObject1).size() == 1) && (paramBoolean2))
    {
      ad.e("MicroMsg.WalletUserInfoManger", "only one bankcard!");
      paramArrayList = (Bankcard)((ArrayList)localObject1).get(0);
      AppMethodBeat.o(70526);
      return paramArrayList;
    }
    ad.i("MicroMsg.WalletUserInfoManger", "have multiple bankcards!");
    if (!bt.isNullOrNil(paramArrayList))
    {
      Object localObject2;
      Bankcard localBankcard;
      do
      {
        paramString = ((ArrayList)localObject1).iterator();
        while (!((Iterator)localObject2).hasNext())
        {
          do
          {
            if (!paramString.hasNext()) {
              break;
            }
            localObject2 = (Bankcard)paramString.next();
          } while ((localObject2 == null) || (!paramArrayList.equals(((Bankcard)localObject2).field_bindSerial)));
          if ((!paramBoolean3) || (!((Bankcard)localObject2).ebz())) {
            break;
          }
          ad.i("MicroMsg.WalletUserInfoManger", "default card is honeypay");
          if ((paramBoolean1) && (this.zHd != null))
          {
            paramArrayList = this.zHd;
            AppMethodBeat.o(70526);
            return paramArrayList;
          }
          localObject2 = ((ArrayList)localObject1).iterator();
        }
        localBankcard = (Bankcard)((Iterator)localObject2).next();
      } while (localBankcard.ebz());
      AppMethodBeat.o(70526);
      return localBankcard;
      AppMethodBeat.o(70526);
      return localObject2;
    }
    if (paramBoolean2)
    {
      paramArrayList = (Bankcard)((ArrayList)localObject1).get(0);
      AppMethodBeat.o(70526);
      return paramArrayList;
    }
    AppMethodBeat.o(70526);
    return null;
  }
  
  private boolean edf()
  {
    AppMethodBeat.i(70515);
    if (((this.Aij != null) && (this.Aij.ecs())) || ((this.zNh != null) && (this.zNh.size() > 0)))
    {
      AppMethodBeat.o(70515);
      return true;
    }
    AppMethodBeat.o(70515);
    return false;
  }
  
  private static String edi()
  {
    AppMethodBeat.i(70522);
    g.afC();
    String str = (String)g.afB().afk().get(196612, null);
    AppMethodBeat.o(70522);
    return str;
  }
  
  public static String edk()
  {
    AppMethodBeat.i(70529);
    g.afC();
    String str = (String)g.afB().afk().get(196633, null);
    AppMethodBeat.o(70529);
    return str;
  }
  
  private void edp()
  {
    AppMethodBeat.i(70531);
    ad.i("MicroMsg.WalletUserInfoManger", "recordDataState()");
    if (this.Aih == null) {
      ad.i("MicroMsg.WalletUserInfoManger", "userInfo == null");
    }
    if (this.zNg == null)
    {
      ad.i("MicroMsg.WalletUserInfoManger", "bankcards == null");
      if (this.zNh != null) {
        break label163;
      }
      ad.i("MicroMsg.WalletUserInfoManger", "virtualBankcards == null");
      label59:
      if (this.zHd != null) {
        break label215;
      }
      ad.i("MicroMsg.WalletUserInfoManger", "balance == null");
      label74:
      if (this.Aii != null) {
        break label226;
      }
      ad.i("MicroMsg.WalletUserInfoManger", "historyBankcard == null");
    }
    for (;;)
    {
      if (this.Aik != null) {
        break label237;
      }
      ad.i("MicroMsg.WalletUserInfoManger", "mLoanEntryInfo == null");
      AppMethodBeat.o(70531);
      return;
      if (this.zNg.size() == 0)
      {
        ad.i("MicroMsg.WalletUserInfoManger", "bankcards.size() == 0");
        break;
      }
      ad.i("MicroMsg.WalletUserInfoManger", "bankcards.size() == " + this.zNg.size());
      break;
      label163:
      if (this.zNh.size() == 0)
      {
        ad.i("MicroMsg.WalletUserInfoManger", "virtualBankcards.size() == 0");
        break label59;
      }
      ad.i("MicroMsg.WalletUserInfoManger", "virtualBankcards.size() == " + this.zNh.size());
      break label59;
      label215:
      ad.i("MicroMsg.WalletUserInfoManger", "balance != null");
      break label74;
      label226:
      ad.i("MicroMsg.WalletUserInfoManger", "historyBankcard != null");
    }
    label237:
    ad.i("MicroMsg.WalletUserInfoManger", "mLoanEntryInfo != null");
    AppMethodBeat.o(70531);
  }
  
  public static Bankcard edq()
  {
    AppMethodBeat.i(70533);
    Bankcard localBankcard = s.ecc().a(null, null, true, true);
    if (localBankcard == null) {
      ad.e("MicroMsg.WalletUserInfoManger", "defaultBankcards == null");
    }
    AppMethodBeat.o(70533);
    return localBankcard;
  }
  
  private static boolean gl(List<Bankcard> paramList)
  {
    AppMethodBeat.i(70517);
    if (paramList.size() == 0)
    {
      AppMethodBeat.o(70517);
      return false;
    }
    g.afC();
    Object localObject = (String)g.afB().afk().get(196659, null);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      AppMethodBeat.o(70517);
      return true;
    }
    localObject = ((String)localObject).split("&");
    if ((localObject == null) || (localObject.length == 0))
    {
      AppMethodBeat.o(70517);
      return true;
    }
    int i = 0;
    int j = 0;
    if (i < localObject.length)
    {
      CharSequence localCharSequence = localObject[i];
      int k = j;
      int m;
      if (!TextUtils.isEmpty(localCharSequence)) {
        m = 0;
      }
      for (;;)
      {
        k = j;
        if (m < paramList.size())
        {
          Bankcard localBankcard = (Bankcard)paramList.get(m);
          if ((localBankcard != null) && (localCharSequence.equals(localBankcard.field_bankcardType))) {
            k = j + 1;
          }
        }
        else
        {
          i += 1;
          j = k;
          break;
        }
        m += 1;
      }
    }
    if (j < paramList.size())
    {
      AppMethodBeat.o(70517);
      return true;
    }
    AppMethodBeat.o(70517);
    return false;
  }
  
  public final void VP()
  {
    AppMethodBeat.i(70505);
    if (this.Aih != null)
    {
      this.Aih.field_is_reg = -1;
      this.Aih = null;
    }
    if (this.Aij != null) {
      this.Aij = null;
    }
    if (this.zHd != null) {
      this.zHd = null;
    }
    if (this.zNg != null)
    {
      this.zNg.clear();
      this.zNg = null;
    }
    if (this.zNh != null)
    {
      this.zNh.clear();
      this.zNh = null;
    }
    if (this.Aio != null) {
      this.Aio = null;
    }
    this.Aiq = 0L;
    com.tencent.mm.wallet_core.ui.e.a(new e.c[] { new e.c("wallet_balance_version", Integer.valueOf(-1)), new e.c("wallet_balance_last_update_time", Integer.valueOf(-1)), new e.c("wallet_balance", Integer.valueOf(-1)) });
    this.Aip = bt.aGK();
    AppMethodBeat.o(70505);
  }
  
  @Deprecated
  public final Bankcard a(ArrayList<Bankcard> paramArrayList, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(70524);
    paramArrayList = a(paramArrayList, paramString, paramBoolean1, paramBoolean2, false);
    AppMethodBeat.o(70524);
    return paramArrayList;
  }
  
  public final Bankcard a(ArrayList<Bankcard> paramArrayList, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(70525);
    paramArrayList = b(paramArrayList, paramString, paramBoolean1, paramBoolean2, paramBoolean3);
    AppMethodBeat.o(70525);
    return paramArrayList;
  }
  
  public final void a(al paramal)
  {
    AppMethodBeat.i(70521);
    this.Aih = paramal;
    s.ebX().aIG();
    s.ebX().b(paramal);
    AppMethodBeat.o(70521);
  }
  
  public final void a(al paramal, ArrayList<Bankcard> paramArrayList1, ArrayList<Bankcard> paramArrayList2, Bankcard paramBankcard1, Bankcard paramBankcard2, n paramn, b paramb, Bankcard paramBankcard3, int paramInt1, int paramInt2, List<c> paramList)
  {
    AppMethodBeat.i(70520);
    ad.i("MicroMsg.WalletUserInfoManger", "setBankcards scene %d", new Object[] { Integer.valueOf(paramInt2) });
    if (paramInt2 == 8)
    {
      this.Aif = paramArrayList1;
      this.Aim = paramList;
    }
    if ((paramInt2 == 24) || (paramInt2 == 25)) {
      this.Aig = paramArrayList1;
    }
    this.zNg = paramArrayList1;
    this.zNh = paramArrayList2;
    this.zHd = paramBankcard1;
    this.Aij = new ak(paramal.field_switchConfig, paramal.field_wallet_entrance_balance_switch_state);
    this.Aii = paramBankcard2;
    this.Aik = paramn;
    this.Ail = paramb;
    this.Ain = paramBankcard3;
    ad.i("MicroMsg.WalletUserInfoManger", "setBankcards()! " + paramal.field_switchConfig);
    edp();
    int i = paramInt1;
    if (paramInt1 < 0) {
      i = 600;
    }
    this.Aip = (bt.aGK() + i);
    this.Aiq = (bt.aGK() + 600L);
    ad.i("MicroMsg.WalletUserInfoManger", "hy: cache time: %d, dead time: %d, cacheDeadTime: %s", new Object[] { Integer.valueOf(i), Long.valueOf(this.Aip), Long.valueOf(this.Aiq) });
    com.tencent.mm.plugin.wallet_core.utils.d.RJ(paramInt2);
    if ((paramInt2 != 24) && (paramInt2 != 25) && (paramArrayList1 != null)) {
      com.tencent.mm.plugin.wallet_core.utils.d.v(paramArrayList1, paramInt2);
    }
    if (paramArrayList2 != null) {
      com.tencent.mm.plugin.wallet_core.utils.d.v(paramArrayList2, paramInt2);
    }
    if (paramBankcard1 != null) {
      com.tencent.mm.plugin.wallet_core.utils.d.a(paramBankcard1, paramInt2);
    }
    if (paramBankcard2 != null) {
      com.tencent.mm.plugin.wallet_core.utils.d.a(paramBankcard2, paramInt2);
    }
    if (paramBankcard3 != null) {
      com.tencent.mm.plugin.wallet_core.utils.d.a(paramBankcard3, paramInt2);
    }
    a(paramal);
    s.ece().aIG();
    if (paramn != null) {
      s.ece().insert(paramn);
    }
    AppMethodBeat.o(70520);
  }
  
  public final Bankcard atT(String paramString)
  {
    AppMethodBeat.i(187165);
    if ((this.zNg != null) && (!this.zNg.isEmpty()))
    {
      Iterator localIterator = this.zNg.iterator();
      while (localIterator.hasNext())
      {
        Bankcard localBankcard = (Bankcard)localIterator.next();
        if (localBankcard.field_bindSerial.equals(paramString))
        {
          AppMethodBeat.o(187165);
          return localBankcard;
        }
      }
    }
    AppMethodBeat.o(187165);
    return null;
  }
  
  public final boolean atU(String paramString)
  {
    AppMethodBeat.i(70518);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(70518);
      return false;
    }
    Iterator localIterator;
    Bankcard localBankcard;
    if (this.zNg != null)
    {
      localIterator = this.zNg.iterator();
      while (localIterator.hasNext())
      {
        localBankcard = (Bankcard)localIterator.next();
        if ((paramString.equals(localBankcard.field_bankcardType)) && (localBankcard.ebu()))
        {
          AppMethodBeat.o(70518);
          return false;
        }
      }
    }
    if (this.zNh != null)
    {
      localIterator = this.zNh.iterator();
      while (localIterator.hasNext())
      {
        localBankcard = (Bankcard)localIterator.next();
        if ((paramString.equals(localBankcard.field_bankcardType)) && (localBankcard.field_bankcardState == 0))
        {
          AppMethodBeat.o(70518);
          return false;
        }
      }
    }
    AppMethodBeat.o(70518);
    return true;
  }
  
  public final void c(buc parambuc)
  {
    AppMethodBeat.i(70519);
    this.Aio = parambuc;
    ah.a(parambuc);
    AppMethodBeat.o(70519);
  }
  
  public final boolean ecF()
  {
    AppMethodBeat.i(70496);
    if ((this.Aih != null) && (this.Aih.ecF()))
    {
      AppMethodBeat.o(70496);
      return true;
    }
    AppMethodBeat.o(70496);
    return false;
  }
  
  public final boolean ecG()
  {
    AppMethodBeat.i(70498);
    if ((this.Aih != null) && (this.Aih.ecG()))
    {
      AppMethodBeat.o(70498);
      return true;
    }
    AppMethodBeat.o(70498);
    return false;
  }
  
  public final boolean ecH()
  {
    AppMethodBeat.i(70497);
    if ((this.Aih != null) && (this.Aih.ecH()))
    {
      AppMethodBeat.o(70497);
      return true;
    }
    AppMethodBeat.o(70497);
    return false;
  }
  
  public final boolean ecJ()
  {
    AppMethodBeat.i(70499);
    if ((this.Aih != null) && (this.Aih.ecJ()))
    {
      AppMethodBeat.o(70499);
      return true;
    }
    AppMethodBeat.o(70499);
    return false;
  }
  
  public final boolean ecK()
  {
    AppMethodBeat.i(70495);
    if ((this.Aih == null) || ((this.Aih != null) && (this.Aih.ecI())))
    {
      AppMethodBeat.o(70495);
      return true;
    }
    AppMethodBeat.o(70495);
    return false;
  }
  
  public final int ecL()
  {
    if (this.Aih != null) {
      return this.Aih.field_soter_pay_open_type;
    }
    return 0;
  }
  
  public final String ecM()
  {
    if (this.Aih != null) {
      return this.Aih.field_ftf_pay_url;
    }
    return null;
  }
  
  public final ak ecN()
  {
    AppMethodBeat.i(70501);
    if (this.Aij == null)
    {
      localak = new ak();
      AppMethodBeat.o(70501);
      return localak;
    }
    ak localak = this.Aij;
    AppMethodBeat.o(70501);
    return localak;
  }
  
  public final boolean ecO()
  {
    return (this.Aih != null) && (this.Aih.field_isDomesticUser);
  }
  
  public final int ecP()
  {
    if (this.Aih != null) {
      return this.Aih.field_cre_type;
    }
    return 1;
  }
  
  public final String ecQ()
  {
    AppMethodBeat.i(70502);
    g.afC();
    String str = (String)g.afB().afk().get(ae.a.FqQ, null);
    if (!bt.isNullOrNil(str))
    {
      AppMethodBeat.o(70502);
      return str;
    }
    if (this.Aih != null)
    {
      str = this.Aih.field_lct_wording;
      AppMethodBeat.o(70502);
      return str;
    }
    AppMethodBeat.o(70502);
    return null;
  }
  
  public final String ecR()
  {
    if (this.Aih != null) {
      return this.Aih.field_lct_url;
    }
    return null;
  }
  
  public final String ecS()
  {
    if (this.Aih != null) {
      return this.Aih.field_forget_passwd_url;
    }
    return "";
  }
  
  public final void ecT()
  {
    AppMethodBeat.i(70503);
    if (!g.afz().aeI())
    {
      ad.w("MicroMsg.WalletUserInfoManger", "Account Not Ready!");
      AppMethodBeat.o(70503);
      return;
    }
    this.Aih = s.ebX().edF();
    if (this.Aih != null) {
      this.Aij = new ak(this.Aih.field_switchConfig, this.Aih.field_wallet_entrance_balance_switch_state);
    }
    for (;;)
    {
      if (!bt.isNullOrNil(this.Aih.field_bank_priority)) {}
      try
      {
        this.Aim = ah.bg(new JSONObject(this.Aih.field_bank_priority));
        this.zHd = s.ebZ().edA();
        this.Ain = s.ebZ().edB();
        com.tencent.mm.wallet_core.ui.e.a("wallet_balance", new am.1(this));
        this.zNg = s.ebZ().ecZ();
        this.Aif = com.tencent.mm.plugin.wallet_core.utils.d.efs();
        this.zNh = s.ebZ().edC();
        this.Aii = s.ebZ().edD();
        this.Aik = s.ece().edy();
        ad.i("MicroMsg.WalletUserInfoManger", "loadDbData!");
        edp();
        this.Aio = ah.ecp();
        AppMethodBeat.o(70503);
        return;
        this.Aij = new ak();
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.WalletUserInfoManger", localJSONException, "", new Object[0]);
        }
      }
    }
  }
  
  public final boolean ecU()
  {
    AppMethodBeat.i(70504);
    if (com.tencent.mm.platformtools.ab.hWD)
    {
      AppMethodBeat.o(70504);
      return true;
    }
    g.afC();
    int i = ((Integer)g.afB().afk().get(ae.a.FqP, Integer.valueOf(-1))).intValue();
    if (i != -1)
    {
      if (i == 1)
      {
        AppMethodBeat.o(70504);
        return true;
      }
      AppMethodBeat.o(70504);
      return false;
    }
    if (this.Aih != null)
    {
      if (this.Aih.field_lqt_state == 1)
      {
        AppMethodBeat.o(70504);
        return true;
      }
      AppMethodBeat.o(70504);
      return false;
    }
    AppMethodBeat.o(70504);
    return false;
  }
  
  public final int ecV()
  {
    if (this.Aih != null) {
      return this.Aih.field_is_show_lqb;
    }
    return 0;
  }
  
  public final boolean ecW()
  {
    if (this.Aih != null) {
      return this.Aih.field_is_open_lqb == 1;
    }
    return false;
  }
  
  public final String ecX()
  {
    if (this.Aih != null) {
      return this.Aih.field_lqb_open_url;
    }
    return null;
  }
  
  public final boolean ecY()
  {
    if (this.Aih != null) {
      return this.Aih.field_paymenu_use_new == 1;
    }
    return false;
  }
  
  public final ArrayList<Bankcard> ecZ()
  {
    AppMethodBeat.i(70506);
    if ((this.zNg == null) || (this.zNg.size() <= 0)) {
      this.zNg = s.ebZ().ecZ();
    }
    if ((this.zNg == null) || (this.zNg.size() <= 0))
    {
      AppMethodBeat.o(70506);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.zNg.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add((Bankcard)localIterator.next());
    }
    AppMethodBeat.o(70506);
    return localArrayList;
  }
  
  public final List<c> eda()
  {
    AppMethodBeat.i(70507);
    if ((this.Aim == null) || (this.Aim.size() <= 0))
    {
      AppMethodBeat.o(70507);
      return null;
    }
    List localList = this.Aim;
    AppMethodBeat.o(70507);
    return localList;
  }
  
  public final ArrayList<Bankcard> edb()
  {
    AppMethodBeat.i(70508);
    if ((this.zNg == null) || (this.zNg.size() <= 0))
    {
      AppMethodBeat.o(70508);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.zNg.iterator();
    while (localIterator.hasNext())
    {
      Bankcard localBankcard = (Bankcard)localIterator.next();
      if ((!localBankcard.ebx()) && (!localBankcard.ebz())) {
        localArrayList.add(localBankcard);
      }
    }
    AppMethodBeat.o(70508);
    return localArrayList;
  }
  
  public final ArrayList<Bankcard> edc()
  {
    AppMethodBeat.i(70511);
    ArrayList localArrayList = new ArrayList();
    if ((this.zHd != null) && (!ecH())) {
      localArrayList.add(this.zHd);
    }
    if ((this.Ain != null) && (!ecH())) {
      localArrayList.add(this.Ain);
    }
    Iterator localIterator;
    if ((this.Aif != null) && (this.zNg != null) && (this.Aif.size() > 0)) {
      localIterator = this.Aif.iterator();
    }
    while (localIterator.hasNext())
    {
      localArrayList.add((Bankcard)localIterator.next());
      continue;
      if ((this.zNg != null) && (this.zNg.size() > 0))
      {
        localIterator = this.zNg.iterator();
        while (localIterator.hasNext()) {
          localArrayList.add((Bankcard)localIterator.next());
        }
      }
    }
    AppMethodBeat.o(70511);
    return localArrayList;
  }
  
  public final ArrayList<Bankcard> edd()
  {
    AppMethodBeat.i(70512);
    ArrayList localArrayList = new ArrayList();
    if ((this.zHd != null) && (!ecH())) {
      localArrayList.add(this.zHd);
    }
    if ((this.Aig != null) && (this.zNg != null) && (this.Aig.size() > 0))
    {
      Iterator localIterator = this.Aig.iterator();
      while (localIterator.hasNext())
      {
        Bankcard localBankcard = (Bankcard)localIterator.next();
        if (!localBankcard.ebz()) {
          localArrayList.add(localBankcard);
        }
      }
    }
    AppMethodBeat.o(70512);
    return localArrayList;
  }
  
  public final boolean ede()
  {
    AppMethodBeat.i(70514);
    if (edf())
    {
      AppMethodBeat.o(70514);
      return false;
    }
    if ((this.zNg != null) && (this.zNg.size() > 0))
    {
      AppMethodBeat.o(70514);
      return false;
    }
    AppMethodBeat.o(70514);
    return true;
  }
  
  public final boolean edg()
  {
    AppMethodBeat.i(70516);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    f(localArrayList1, localArrayList2);
    if (gl(localArrayList2))
    {
      AppMethodBeat.o(70516);
      return true;
    }
    AppMethodBeat.o(70516);
    return false;
  }
  
  public final int edh()
  {
    if (this.Ait > 0) {
      return this.Ait;
    }
    return 10000;
  }
  
  public final String edj()
  {
    AppMethodBeat.i(70527);
    if ((this.zNg == null) || (this.zNg.size() <= 0))
    {
      ad.e("MicroMsg.WalletUserInfoManger", "not found bankcard!");
      AppMethodBeat.o(70527);
      return null;
    }
    Object localObject = this.zNg.iterator();
    if (((Iterator)localObject).hasNext())
    {
      localObject = ((Bankcard)((Iterator)localObject).next()).field_bindSerial;
      AppMethodBeat.o(70527);
      return localObject;
    }
    AppMethodBeat.o(70527);
    return null;
  }
  
  public final boolean edl()
  {
    AppMethodBeat.i(70530);
    long l = bt.lZ(this.Air);
    ad.d("MicroMsg.WalletUserInfoManger", "pass time ".concat(String.valueOf(l)));
    if (l > 300L)
    {
      AppMethodBeat.o(70530);
      return true;
    }
    AppMethodBeat.o(70530);
    return false;
  }
  
  public final int edm()
  {
    if (this.Aih != null) {
      return this.Aih.field_lqt_cell_is_show;
    }
    return 0;
  }
  
  public final String edn()
  {
    if (this.Aih != null) {
      return this.Aih.field_lqt_cell_lqt_title;
    }
    return null;
  }
  
  public final String edo()
  {
    if (this.Aih != null) {
      return this.Aih.field_lqt_cell_lqt_wording;
    }
    return null;
  }
  
  public final void f(ArrayList<Bankcard> paramArrayList1, ArrayList<Bankcard> paramArrayList2)
  {
    AppMethodBeat.i(70513);
    if ((this.zNg == null) || (paramArrayList1 == null) || (paramArrayList2 == null))
    {
      ad.e("MicroMsg.WalletUserInfoManger", "error list, bankcards == null || bankcardsClone == null || virtualBankcardsClone == null");
      AppMethodBeat.o(70513);
      return;
    }
    paramArrayList1.clear();
    paramArrayList2.clear();
    Iterator localIterator;
    if (this.zNg != null)
    {
      localIterator = this.zNg.iterator();
      while (localIterator.hasNext()) {
        paramArrayList1.add((Bankcard)localIterator.next());
      }
    }
    if (this.zNh != null)
    {
      localIterator = this.zNh.iterator();
      while (localIterator.hasNext())
      {
        Bankcard localBankcard = (Bankcard)localIterator.next();
        if (localBankcard.field_wxcreditState == 0) {
          paramArrayList2.add(localBankcard);
        } else {
          paramArrayList1.add(localBankcard);
        }
      }
    }
    AppMethodBeat.o(70513);
  }
  
  public final String getTrueName()
  {
    if (this.Aih != null) {
      return this.Aih.field_true_name;
    }
    return null;
  }
  
  public final ArrayList<Bankcard> sC(boolean paramBoolean)
  {
    AppMethodBeat.i(70509);
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean)
    {
      if ((this.zHd != null) && (!ecH())) {
        localArrayList.add(this.zHd);
      }
      if ((this.Ain != null) && (!ecH())) {
        localArrayList.add(this.Ain);
      }
    }
    if ((this.zNg != null) && (this.zNg.size() > 0))
    {
      Iterator localIterator = this.zNg.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add((Bankcard)localIterator.next());
      }
    }
    AppMethodBeat.o(70509);
    return localArrayList;
  }
  
  @Deprecated
  public final ArrayList<Bankcard> sD(boolean paramBoolean)
  {
    AppMethodBeat.i(201271);
    ArrayList localArrayList = sC(paramBoolean);
    AppMethodBeat.o(201271);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.am
 * JD-Core Version:    0.7.0.1
 */