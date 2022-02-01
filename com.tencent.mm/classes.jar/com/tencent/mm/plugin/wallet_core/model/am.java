package com.tencent.mm.plugin.wallet_core.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.wallet_core.d.k;
import com.tencent.mm.protocal.protobuf.byt;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.wallet_core.ui.e.b;
import com.tencent.mm.wallet_core.ui.e.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class am
{
  int AYN;
  int AYO;
  public Bankcard AZp;
  private ArrayList<Bankcard> BAA;
  private ArrayList<Bankcard> BAB;
  public al BAC;
  public Bankcard BAD;
  public ak BAE;
  public n BAF;
  public b BAG;
  private List<c> BAH;
  public Bankcard BAI;
  public byt BAJ;
  public long BAK;
  long BAL;
  public long BAM;
  private String BAN;
  public int BAO;
  public String BAP;
  public String BAQ;
  public ArrayList<Bankcard> BAz;
  private ArrayList<Bankcard> BfA;
  private ArrayList<Bankcard> BfB;
  public int mRetryCount;
  
  public am()
  {
    AppMethodBeat.i(70494);
    this.BAz = new ArrayList();
    this.BAA = new ArrayList();
    this.BAB = new ArrayList();
    this.BfA = new ArrayList();
    this.BfB = new ArrayList();
    this.BAC = null;
    this.BAD = null;
    this.AZp = null;
    this.BAE = null;
    this.BAF = null;
    this.BAG = null;
    this.BAH = new LinkedList();
    this.BAI = null;
    this.AYN = 0;
    this.AYO = 0;
    this.BAK = bs.aNx();
    this.BAL = 0L;
    this.BAM = -1L;
    this.BAN = "";
    this.BAO = 10000;
    this.mRetryCount = 0;
    this.BAP = "";
    this.BAQ = "";
    eso();
    AppMethodBeat.o(70494);
  }
  
  public static void azn(String paramString)
  {
    AppMethodBeat.i(70523);
    if (!bs.isNullOrNil(paramString))
    {
      g.agS();
      g.agR().agA().set(196612, paramString);
    }
    AppMethodBeat.o(70523);
  }
  
  private static void azo(String paramString)
  {
    AppMethodBeat.i(70528);
    if (paramString != null)
    {
      g.agS();
      g.agR().agA().set(196633, paramString);
    }
    AppMethodBeat.o(70528);
  }
  
  public static void azp(String paramString)
  {
    AppMethodBeat.i(70532);
    ac.i("MicroMsg.WalletUserInfoManger", "setSelectBindSerial %s %s", new Object[] { paramString, bs.eWi().toString() });
    azo(paramString);
    AppMethodBeat.o(70532);
  }
  
  @Deprecated
  private Bankcard b(ArrayList<Bankcard> paramArrayList, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(70526);
    Object localObject1 = paramArrayList;
    if (paramArrayList == null) {
      localObject1 = this.BfA;
    }
    paramArrayList = paramString;
    if (bs.isNullOrNil(paramString)) {
      paramArrayList = esD();
    }
    if ((paramBoolean1) && (this.AZp != null))
    {
      if (esb())
      {
        paramArrayList = this.AZp;
        AppMethodBeat.o(70526);
        return paramArrayList;
      }
      if ((paramArrayList != null) && (paramArrayList.equals(this.AZp.field_bindSerial)))
      {
        paramArrayList = this.AZp;
        AppMethodBeat.o(70526);
        return paramArrayList;
      }
      if ((this.BAI != null) && (this.BAC != null) && (this.BAC.field_lqt_state == 1) && (paramArrayList != null) && (paramArrayList.equals(this.BAI.field_bindSerial)))
      {
        paramArrayList = this.BAI;
        AppMethodBeat.o(70526);
        return paramArrayList;
      }
      if ((!esc()) && ((localObject1 == null) || (((ArrayList)localObject1).size() == 0)))
      {
        paramArrayList = this.AZp;
        AppMethodBeat.o(70526);
        return paramArrayList;
      }
    }
    if ((localObject1 == null) || (((ArrayList)localObject1).size() <= 0))
    {
      ac.e("MicroMsg.WalletUserInfoManger", "not found bankcard!");
      AppMethodBeat.o(70526);
      return null;
    }
    if ((((ArrayList)localObject1).size() == 1) && (paramBoolean2))
    {
      ac.e("MicroMsg.WalletUserInfoManger", "only one bankcard!");
      paramArrayList = (Bankcard)((ArrayList)localObject1).get(0);
      AppMethodBeat.o(70526);
      return paramArrayList;
    }
    ac.i("MicroMsg.WalletUserInfoManger", "have multiple bankcards!");
    if (!bs.isNullOrNil(paramArrayList))
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
          if ((!paramBoolean3) || (!((Bankcard)localObject2).eqV())) {
            break;
          }
          ac.i("MicroMsg.WalletUserInfoManger", "default card is honeypay");
          if ((paramBoolean1) && (this.AZp != null))
          {
            paramArrayList = this.AZp;
            AppMethodBeat.o(70526);
            return paramArrayList;
          }
          localObject2 = ((ArrayList)localObject1).iterator();
        }
        localBankcard = (Bankcard)((Iterator)localObject2).next();
      } while (localBankcard.eqV());
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
  
  private boolean esA()
  {
    AppMethodBeat.i(70515);
    if (((this.BAE != null) && (this.BAE.erO())) || ((this.BfB != null) && (this.BfB.size() > 0)))
    {
      AppMethodBeat.o(70515);
      return true;
    }
    AppMethodBeat.o(70515);
    return false;
  }
  
  private static String esD()
  {
    AppMethodBeat.i(70522);
    g.agS();
    String str = (String)g.agR().agA().get(196612, null);
    AppMethodBeat.o(70522);
    return str;
  }
  
  public static String esF()
  {
    AppMethodBeat.i(70529);
    g.agS();
    String str = (String)g.agR().agA().get(196633, null);
    AppMethodBeat.o(70529);
    return str;
  }
  
  private void esK()
  {
    AppMethodBeat.i(70531);
    ac.i("MicroMsg.WalletUserInfoManger", "recordDataState()");
    if (this.BAC == null) {
      ac.i("MicroMsg.WalletUserInfoManger", "userInfo == null");
    }
    if (this.BfA == null)
    {
      ac.i("MicroMsg.WalletUserInfoManger", "bankcards == null");
      if (this.BfB != null) {
        break label163;
      }
      ac.i("MicroMsg.WalletUserInfoManger", "virtualBankcards == null");
      label59:
      if (this.AZp != null) {
        break label215;
      }
      ac.i("MicroMsg.WalletUserInfoManger", "balance == null");
      label74:
      if (this.BAD != null) {
        break label226;
      }
      ac.i("MicroMsg.WalletUserInfoManger", "historyBankcard == null");
    }
    for (;;)
    {
      if (this.BAF != null) {
        break label237;
      }
      ac.i("MicroMsg.WalletUserInfoManger", "mLoanEntryInfo == null");
      AppMethodBeat.o(70531);
      return;
      if (this.BfA.size() == 0)
      {
        ac.i("MicroMsg.WalletUserInfoManger", "bankcards.size() == 0");
        break;
      }
      ac.i("MicroMsg.WalletUserInfoManger", "bankcards.size() == " + this.BfA.size());
      break;
      label163:
      if (this.BfB.size() == 0)
      {
        ac.i("MicroMsg.WalletUserInfoManger", "virtualBankcards.size() == 0");
        break label59;
      }
      ac.i("MicroMsg.WalletUserInfoManger", "virtualBankcards.size() == " + this.BfB.size());
      break label59;
      label215:
      ac.i("MicroMsg.WalletUserInfoManger", "balance != null");
      break label74;
      label226:
      ac.i("MicroMsg.WalletUserInfoManger", "historyBankcard != null");
    }
    label237:
    ac.i("MicroMsg.WalletUserInfoManger", "mLoanEntryInfo != null");
    AppMethodBeat.o(70531);
  }
  
  public static Bankcard esL()
  {
    AppMethodBeat.i(70533);
    Bankcard localBankcard = s.ery().a(null, null, true, true);
    if (localBankcard == null) {
      ac.e("MicroMsg.WalletUserInfoManger", "defaultBankcards == null");
    }
    AppMethodBeat.o(70533);
    return localBankcard;
  }
  
  private static boolean gw(List<Bankcard> paramList)
  {
    AppMethodBeat.i(70517);
    if (paramList.size() == 0)
    {
      AppMethodBeat.o(70517);
      return false;
    }
    g.agS();
    Object localObject = (String)g.agR().agA().get(196659, null);
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
  
  public final void WN()
  {
    AppMethodBeat.i(70505);
    if (this.BAC != null)
    {
      this.BAC.field_is_reg = -1;
      this.BAC = null;
    }
    if (this.BAE != null) {
      this.BAE = null;
    }
    if (this.AZp != null) {
      this.AZp = null;
    }
    if (this.BfA != null)
    {
      this.BfA.clear();
      this.BfA = null;
    }
    if (this.BfB != null)
    {
      this.BfB.clear();
      this.BfB = null;
    }
    if (this.BAJ != null) {
      this.BAJ = null;
    }
    this.BAL = 0L;
    com.tencent.mm.wallet_core.ui.e.a(new e.c[] { new e.c("wallet_balance_version", Integer.valueOf(-1)), new e.c("wallet_balance_last_update_time", Integer.valueOf(-1)), new e.c("wallet_balance", Integer.valueOf(-1)) });
    this.BAK = bs.aNx();
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
    this.BAC = paramal;
    s.ert().aPx();
    s.ert().b(paramal);
    AppMethodBeat.o(70521);
  }
  
  public final void a(al paramal, ArrayList<Bankcard> paramArrayList1, ArrayList<Bankcard> paramArrayList2, Bankcard paramBankcard1, Bankcard paramBankcard2, n paramn, b paramb, Bankcard paramBankcard3, int paramInt1, int paramInt2, List<c> paramList)
  {
    AppMethodBeat.i(70520);
    ac.i("MicroMsg.WalletUserInfoManger", "setBankcards scene %d", new Object[] { Integer.valueOf(paramInt2) });
    if (paramInt2 == 8)
    {
      this.BAz = paramArrayList1;
      this.BAH = paramList;
    }
    if ((paramInt2 == 24) || (paramInt2 == 25)) {
      this.BAA = paramArrayList1;
    }
    if (paramInt2 == 12) {
      this.BAB = paramArrayList1;
    }
    this.BfA = paramArrayList1;
    this.BfB = paramArrayList2;
    this.AZp = paramBankcard1;
    this.BAE = new ak(paramal.field_switchConfig, paramal.field_wallet_entrance_balance_switch_state);
    this.BAD = paramBankcard2;
    this.BAF = paramn;
    this.BAG = paramb;
    this.BAI = paramBankcard3;
    ac.i("MicroMsg.WalletUserInfoManger", "setBankcards()! " + paramal.field_switchConfig);
    esK();
    int i = paramInt1;
    if (paramInt1 < 0) {
      i = 600;
    }
    this.BAK = (bs.aNx() + i);
    this.BAL = (bs.aNx() + 600L);
    ac.i("MicroMsg.WalletUserInfoManger", "hy: cache time: %d, dead time: %d, cacheDeadTime: %s", new Object[] { Integer.valueOf(i), Long.valueOf(this.BAK), Long.valueOf(this.BAL) });
    com.tencent.mm.plugin.wallet_core.utils.d.TS(paramInt2);
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
    s.erA().aPx();
    if (paramn != null) {
      s.erA().insert(paramn);
    }
    AppMethodBeat.o(70520);
  }
  
  public final Bankcard azl(String paramString)
  {
    AppMethodBeat.i(207286);
    if ((this.BfA != null) && (!this.BfA.isEmpty()))
    {
      Iterator localIterator = this.BfA.iterator();
      while (localIterator.hasNext())
      {
        Bankcard localBankcard = (Bankcard)localIterator.next();
        if (localBankcard.field_bindSerial.equals(paramString))
        {
          AppMethodBeat.o(207286);
          return localBankcard;
        }
      }
    }
    AppMethodBeat.o(207286);
    return null;
  }
  
  public final boolean azm(String paramString)
  {
    AppMethodBeat.i(70518);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(70518);
      return false;
    }
    Iterator localIterator;
    Bankcard localBankcard;
    if (this.BfA != null)
    {
      localIterator = this.BfA.iterator();
      while (localIterator.hasNext())
      {
        localBankcard = (Bankcard)localIterator.next();
        if ((paramString.equals(localBankcard.field_bankcardType)) && (localBankcard.eqQ()))
        {
          AppMethodBeat.o(70518);
          return false;
        }
      }
    }
    if (this.BfB != null)
    {
      localIterator = this.BfB.iterator();
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
  
  public final void c(byt parambyt)
  {
    AppMethodBeat.i(70519);
    this.BAJ = parambyt;
    ah.a(parambyt);
    AppMethodBeat.o(70519);
  }
  
  public final boolean esB()
  {
    AppMethodBeat.i(70516);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    f(localArrayList1, localArrayList2);
    if (gw(localArrayList2))
    {
      AppMethodBeat.o(70516);
      return true;
    }
    AppMethodBeat.o(70516);
    return false;
  }
  
  public final int esC()
  {
    if (this.BAO > 0) {
      return this.BAO;
    }
    return 10000;
  }
  
  public final String esE()
  {
    AppMethodBeat.i(70527);
    if ((this.BfA == null) || (this.BfA.size() <= 0))
    {
      ac.e("MicroMsg.WalletUserInfoManger", "not found bankcard!");
      AppMethodBeat.o(70527);
      return null;
    }
    Object localObject = this.BfA.iterator();
    if (((Iterator)localObject).hasNext())
    {
      localObject = ((Bankcard)((Iterator)localObject).next()).field_bindSerial;
      AppMethodBeat.o(70527);
      return localObject;
    }
    AppMethodBeat.o(70527);
    return null;
  }
  
  public final boolean esG()
  {
    AppMethodBeat.i(70530);
    long l = bs.pN(this.BAM);
    ac.d("MicroMsg.WalletUserInfoManger", "pass time ".concat(String.valueOf(l)));
    if (l > 300L)
    {
      AppMethodBeat.o(70530);
      return true;
    }
    AppMethodBeat.o(70530);
    return false;
  }
  
  public final int esH()
  {
    if (this.BAC != null) {
      return this.BAC.field_lqt_cell_is_show;
    }
    return 0;
  }
  
  public final String esI()
  {
    if (this.BAC != null) {
      return this.BAC.field_lqt_cell_lqt_title;
    }
    return null;
  }
  
  public final String esJ()
  {
    if (this.BAC != null) {
      return this.BAC.field_lqt_cell_lqt_wording;
    }
    return null;
  }
  
  public final boolean esa()
  {
    AppMethodBeat.i(70496);
    if ((this.BAC != null) && (this.BAC.esa()))
    {
      AppMethodBeat.o(70496);
      return true;
    }
    AppMethodBeat.o(70496);
    return false;
  }
  
  public final boolean esb()
  {
    AppMethodBeat.i(70498);
    if ((this.BAC != null) && (this.BAC.esb()))
    {
      AppMethodBeat.o(70498);
      return true;
    }
    AppMethodBeat.o(70498);
    return false;
  }
  
  public final boolean esc()
  {
    AppMethodBeat.i(70497);
    if ((this.BAC != null) && (this.BAC.esc()))
    {
      AppMethodBeat.o(70497);
      return true;
    }
    AppMethodBeat.o(70497);
    return false;
  }
  
  public final boolean ese()
  {
    AppMethodBeat.i(70499);
    if ((this.BAC != null) && (this.BAC.ese()))
    {
      AppMethodBeat.o(70499);
      return true;
    }
    AppMethodBeat.o(70499);
    return false;
  }
  
  public final boolean esf()
  {
    AppMethodBeat.i(70495);
    if ((this.BAC == null) || ((this.BAC != null) && (this.BAC.esd())))
    {
      AppMethodBeat.o(70495);
      return true;
    }
    AppMethodBeat.o(70495);
    return false;
  }
  
  public final int esg()
  {
    if (this.BAC != null) {
      return this.BAC.field_soter_pay_open_type;
    }
    return 0;
  }
  
  public final String esh()
  {
    if (this.BAC != null) {
      return this.BAC.field_ftf_pay_url;
    }
    return null;
  }
  
  public final ak esi()
  {
    AppMethodBeat.i(70501);
    if (this.BAE == null)
    {
      localak = new ak();
      AppMethodBeat.o(70501);
      return localak;
    }
    ak localak = this.BAE;
    AppMethodBeat.o(70501);
    return localak;
  }
  
  public final boolean esj()
  {
    return (this.BAC != null) && (this.BAC.field_isDomesticUser);
  }
  
  public final int esk()
  {
    if (this.BAC != null) {
      return this.BAC.field_cre_type;
    }
    return 1;
  }
  
  public final String esl()
  {
    AppMethodBeat.i(70502);
    g.agS();
    String str = (String)g.agR().agA().get(ah.a.GOG, null);
    if (!bs.isNullOrNil(str))
    {
      AppMethodBeat.o(70502);
      return str;
    }
    if (this.BAC != null)
    {
      str = this.BAC.field_lct_wording;
      AppMethodBeat.o(70502);
      return str;
    }
    AppMethodBeat.o(70502);
    return null;
  }
  
  public final String esm()
  {
    if (this.BAC != null) {
      return this.BAC.field_lct_url;
    }
    return null;
  }
  
  public final String esn()
  {
    if (this.BAC != null) {
      return this.BAC.field_forget_passwd_url;
    }
    return "";
  }
  
  public final void eso()
  {
    AppMethodBeat.i(70503);
    if (!g.agP().afY())
    {
      ac.w("MicroMsg.WalletUserInfoManger", "Account Not Ready!");
      AppMethodBeat.o(70503);
      return;
    }
    this.BAC = s.ert().eta();
    if (this.BAC != null) {
      this.BAE = new ak(this.BAC.field_switchConfig, this.BAC.field_wallet_entrance_balance_switch_state);
    }
    for (;;)
    {
      if (!bs.isNullOrNil(this.BAC.field_bank_priority)) {}
      try
      {
        this.BAH = ah.bh(new JSONObject(this.BAC.field_bank_priority));
        this.AZp = s.erv().esV();
        this.BAI = s.erv().esW();
        com.tencent.mm.wallet_core.ui.e.a("wallet_balance", new e.b()
        {
          public final void dn(Object paramAnonymousObject)
          {
            AppMethodBeat.i(70493);
            if ((paramAnonymousObject != null) && ((paramAnonymousObject instanceof Double)))
            {
              if (((Double)paramAnonymousObject).doubleValue() < 0.0D) {
                ac.v("MicroMsg.WalletUserInfoManger", "val is zero %s", new Object[] { bs.eWi().toString() });
              }
              if (am.this.AZp != null)
              {
                am.this.AZp.Buo = ((Double)paramAnonymousObject).doubleValue();
                AppMethodBeat.o(70493);
              }
            }
            else
            {
              ac.i("MicroMsg.WalletUserInfoManger", "hy: no balance info. set to negative");
              if (am.this.AZp != null) {
                am.this.AZp.Buo = -1.0D;
              }
            }
            AppMethodBeat.o(70493);
          }
        });
        this.BfA = s.erv().esu();
        this.BAz = com.tencent.mm.plugin.wallet_core.utils.d.TT(8);
        this.BAB = com.tencent.mm.plugin.wallet_core.utils.d.TT(12);
        this.BfB = s.erv().esX();
        this.BAD = s.erv().esY();
        this.BAF = s.erA().esT();
        ac.i("MicroMsg.WalletUserInfoManger", "loadDbData!");
        esK();
        this.BAJ = ah.erL();
        AppMethodBeat.o(70503);
        return;
        this.BAE = new ak();
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          ac.printErrStackTrace("MicroMsg.WalletUserInfoManger", localJSONException, "", new Object[0]);
        }
      }
    }
  }
  
  public final boolean esp()
  {
    AppMethodBeat.i(70504);
    if (ab.iwH)
    {
      AppMethodBeat.o(70504);
      return true;
    }
    g.agS();
    int i = ((Integer)g.agR().agA().get(ah.a.GOF, Integer.valueOf(-1))).intValue();
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
    if (this.BAC != null)
    {
      if (this.BAC.field_lqt_state == 1)
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
  
  public final int esq()
  {
    if (this.BAC != null) {
      return this.BAC.field_is_show_lqb;
    }
    return 0;
  }
  
  public final boolean esr()
  {
    if (this.BAC != null) {
      return this.BAC.field_is_open_lqb == 1;
    }
    return false;
  }
  
  public final String ess()
  {
    if (this.BAC != null) {
      return this.BAC.field_lqb_open_url;
    }
    return null;
  }
  
  public final boolean est()
  {
    if (this.BAC != null) {
      return this.BAC.field_paymenu_use_new == 1;
    }
    return false;
  }
  
  public final ArrayList<Bankcard> esu()
  {
    AppMethodBeat.i(70506);
    if ((this.BfA == null) || (this.BfA.size() <= 0)) {
      this.BfA = s.erv().esu();
    }
    if ((this.BfA == null) || (this.BfA.size() <= 0))
    {
      AppMethodBeat.o(70506);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.BfA.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add((Bankcard)localIterator.next());
    }
    AppMethodBeat.o(70506);
    return localArrayList;
  }
  
  public final List<c> esv()
  {
    AppMethodBeat.i(70507);
    if ((this.BAH == null) || (this.BAH.size() <= 0))
    {
      AppMethodBeat.o(70507);
      return null;
    }
    List localList = this.BAH;
    AppMethodBeat.o(70507);
    return localList;
  }
  
  public final ArrayList<Bankcard> esw()
  {
    AppMethodBeat.i(70508);
    if ((this.BfA == null) || (this.BfA.size() <= 0))
    {
      AppMethodBeat.o(70508);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.BfA.iterator();
    while (localIterator.hasNext())
    {
      Bankcard localBankcard = (Bankcard)localIterator.next();
      if ((!localBankcard.eqT()) && (!localBankcard.eqV())) {
        localArrayList.add(localBankcard);
      }
    }
    AppMethodBeat.o(70508);
    return localArrayList;
  }
  
  public final ArrayList<Bankcard> esx()
  {
    AppMethodBeat.i(70511);
    ArrayList localArrayList = new ArrayList();
    if ((this.AZp != null) && (!esc())) {
      localArrayList.add(this.AZp);
    }
    if ((this.BAI != null) && (!esc())) {
      localArrayList.add(this.BAI);
    }
    Iterator localIterator;
    if ((this.BAz != null) && (this.BAz.size() > 0)) {
      localIterator = this.BAz.iterator();
    }
    while (localIterator.hasNext())
    {
      localArrayList.add((Bankcard)localIterator.next());
      continue;
      if ((this.BfA != null) && (this.BfA.size() > 0))
      {
        localIterator = this.BfA.iterator();
        while (localIterator.hasNext()) {
          localArrayList.add((Bankcard)localIterator.next());
        }
      }
    }
    AppMethodBeat.o(70511);
    return localArrayList;
  }
  
  public final ArrayList<Bankcard> esy()
  {
    AppMethodBeat.i(70512);
    ArrayList localArrayList = new ArrayList();
    if ((this.AZp != null) && (!esc())) {
      localArrayList.add(this.AZp);
    }
    if ((this.BAA != null) && (this.BfA != null) && (this.BAA.size() > 0))
    {
      Iterator localIterator = this.BAA.iterator();
      while (localIterator.hasNext())
      {
        Bankcard localBankcard = (Bankcard)localIterator.next();
        if (!localBankcard.eqV()) {
          localArrayList.add(localBankcard);
        }
      }
    }
    AppMethodBeat.o(70512);
    return localArrayList;
  }
  
  public final boolean esz()
  {
    AppMethodBeat.i(70514);
    if (esA())
    {
      AppMethodBeat.o(70514);
      return false;
    }
    if ((this.BfA != null) && (this.BfA.size() > 0))
    {
      AppMethodBeat.o(70514);
      return false;
    }
    AppMethodBeat.o(70514);
    return true;
  }
  
  public final void f(ArrayList<Bankcard> paramArrayList1, ArrayList<Bankcard> paramArrayList2)
  {
    AppMethodBeat.i(70513);
    if ((paramArrayList1 == null) || (paramArrayList2 == null))
    {
      ac.e("MicroMsg.WalletUserInfoManger", "error list,bankcardsClone == null || virtualBankcardsClone == null");
      AppMethodBeat.o(70513);
      return;
    }
    if ((this.BAB == null) && (this.BfA != null))
    {
      ac.e("MicroMsg.WalletUserInfoManger", "listManageUIbankcards == null && bankcards != null");
      this.BAB = this.BfA;
    }
    if (this.BAB == null)
    {
      ac.e("MicroMsg.WalletUserInfoManger", "error list, listManageUIbankcards == null");
      AppMethodBeat.o(70513);
      return;
    }
    paramArrayList1.clear();
    paramArrayList2.clear();
    Iterator localIterator;
    if (this.BAB != null)
    {
      localIterator = this.BAB.iterator();
      while (localIterator.hasNext()) {
        paramArrayList1.add((Bankcard)localIterator.next());
      }
    }
    if (this.BfB != null)
    {
      localIterator = this.BfB.iterator();
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
    if (this.BAC != null) {
      return this.BAC.field_true_name;
    }
    return null;
  }
  
  public final ArrayList<Bankcard> tD(boolean paramBoolean)
  {
    AppMethodBeat.i(70509);
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean)
    {
      if ((this.AZp != null) && (!esc())) {
        localArrayList.add(this.AZp);
      }
      if ((this.BAI != null) && (!esc())) {
        localArrayList.add(this.BAI);
      }
    }
    if ((this.BfA != null) && (this.BfA.size() > 0))
    {
      Iterator localIterator = this.BfA.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add((Bankcard)localIterator.next());
      }
    }
    AppMethodBeat.o(70509);
    return localArrayList;
  }
  
  @Deprecated
  public final ArrayList<Bankcard> tE(boolean paramBoolean)
  {
    AppMethodBeat.i(210295);
    ArrayList localArrayList = tD(paramBoolean);
    AppMethodBeat.o(210295);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.am
 * JD-Core Version:    0.7.0.1
 */