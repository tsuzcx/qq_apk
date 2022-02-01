package com.tencent.mm.plugin.wallet_core.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.wallet_core.d.k;
import com.tencent.mm.protocal.protobuf.cee;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.mm.wallet_core.ui.f.b;
import com.tencent.mm.wallet_core.ui.f.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class an
{
  int CQC;
  int CQD;
  public Bankcard CRg;
  private ArrayList<Bankcard> CXu;
  private ArrayList<Bankcard> CXv;
  public al DsA;
  public n DsB;
  public b DsC;
  private List<c> DsD;
  public Bankcard DsE;
  public cee DsF;
  public long DsG;
  long DsH;
  public long DsI;
  private String DsJ;
  public int DsK;
  public String DsL;
  public String DsM;
  public ArrayList<Bankcard> Dsv;
  private ArrayList<Bankcard> Dsw;
  private ArrayList<Bankcard> Dsx;
  public am Dsy;
  public Bankcard Dsz;
  public int mRetryCount;
  
  public an()
  {
    AppMethodBeat.i(70494);
    this.Dsv = new ArrayList();
    this.Dsw = new ArrayList();
    this.Dsx = new ArrayList();
    this.CXu = new ArrayList();
    this.CXv = new ArrayList();
    this.Dsy = null;
    this.Dsz = null;
    this.CRg = null;
    this.DsA = null;
    this.DsB = null;
    this.DsC = null;
    this.DsD = new LinkedList();
    this.DsE = null;
    this.CQC = 0;
    this.CQD = 0;
    this.DsG = bu.aRi();
    this.DsH = 0L;
    this.DsI = -1L;
    this.DsJ = "";
    this.DsK = 10000;
    this.mRetryCount = 0;
    this.DsL = "";
    this.DsM = "";
    eJV();
    AppMethodBeat.o(70494);
  }
  
  public static void aFP(String paramString)
  {
    AppMethodBeat.i(70523);
    if (!bu.isNullOrNil(paramString))
    {
      g.ajS();
      g.ajR().ajA().set(196612, paramString);
    }
    AppMethodBeat.o(70523);
  }
  
  private static void aFQ(String paramString)
  {
    AppMethodBeat.i(70528);
    if (paramString != null)
    {
      g.ajS();
      g.ajR().ajA().set(196633, paramString);
    }
    AppMethodBeat.o(70528);
  }
  
  public static void aFR(String paramString)
  {
    AppMethodBeat.i(70532);
    ae.i("MicroMsg.WalletUserInfoManger", "setSelectBindSerial %s %s", new Object[] { paramString, bu.fpN().toString() });
    aFQ(paramString);
    AppMethodBeat.o(70532);
  }
  
  @Deprecated
  private Bankcard b(ArrayList<Bankcard> paramArrayList, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(70526);
    Object localObject1 = paramArrayList;
    if (paramArrayList == null) {
      localObject1 = this.CXu;
    }
    paramArrayList = paramString;
    if (bu.isNullOrNil(paramString)) {
      paramArrayList = eKk();
    }
    if ((paramBoolean1) && (this.CRg != null))
    {
      if (eJI())
      {
        paramArrayList = this.CRg;
        AppMethodBeat.o(70526);
        return paramArrayList;
      }
      if ((paramArrayList != null) && (paramArrayList.equals(this.CRg.field_bindSerial)))
      {
        paramArrayList = this.CRg;
        AppMethodBeat.o(70526);
        return paramArrayList;
      }
      if ((this.DsE != null) && (this.Dsy != null) && (this.Dsy.field_lqt_state == 1) && (paramArrayList != null) && (paramArrayList.equals(this.DsE.field_bindSerial)))
      {
        paramArrayList = this.DsE;
        AppMethodBeat.o(70526);
        return paramArrayList;
      }
      if ((!eJJ()) && ((localObject1 == null) || (((ArrayList)localObject1).size() == 0)))
      {
        paramArrayList = this.CRg;
        AppMethodBeat.o(70526);
        return paramArrayList;
      }
    }
    if ((localObject1 == null) || (((ArrayList)localObject1).size() <= 0))
    {
      ae.e("MicroMsg.WalletUserInfoManger", "not found bankcard!");
      AppMethodBeat.o(70526);
      return null;
    }
    if ((((ArrayList)localObject1).size() == 1) && (paramBoolean2))
    {
      ae.e("MicroMsg.WalletUserInfoManger", "only one bankcard!");
      paramArrayList = (Bankcard)((ArrayList)localObject1).get(0);
      AppMethodBeat.o(70526);
      return paramArrayList;
    }
    ae.i("MicroMsg.WalletUserInfoManger", "have multiple bankcards!");
    if (!bu.isNullOrNil(paramArrayList))
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
          if ((!paramBoolean3) || (!((Bankcard)localObject2).eIC())) {
            break;
          }
          ae.i("MicroMsg.WalletUserInfoManger", "default card is honeypay");
          if ((paramBoolean1) && (this.CRg != null))
          {
            paramArrayList = this.CRg;
            AppMethodBeat.o(70526);
            return paramArrayList;
          }
          localObject2 = ((ArrayList)localObject1).iterator();
        }
        localBankcard = (Bankcard)((Iterator)localObject2).next();
      } while (localBankcard.eIC());
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
  
  private boolean eKh()
  {
    AppMethodBeat.i(70515);
    if (((this.DsA != null) && (this.DsA.eJv())) || ((this.CXv != null) && (this.CXv.size() > 0)))
    {
      AppMethodBeat.o(70515);
      return true;
    }
    AppMethodBeat.o(70515);
    return false;
  }
  
  private static String eKk()
  {
    AppMethodBeat.i(70522);
    g.ajS();
    String str = (String)g.ajR().ajA().get(196612, null);
    AppMethodBeat.o(70522);
    return str;
  }
  
  public static String eKm()
  {
    AppMethodBeat.i(70529);
    g.ajS();
    String str = (String)g.ajR().ajA().get(196633, null);
    AppMethodBeat.o(70529);
    return str;
  }
  
  private void eKr()
  {
    AppMethodBeat.i(70531);
    ae.i("MicroMsg.WalletUserInfoManger", "recordDataState()");
    if (this.Dsy == null) {
      ae.i("MicroMsg.WalletUserInfoManger", "userInfo == null");
    }
    if (this.CXu == null)
    {
      ae.i("MicroMsg.WalletUserInfoManger", "bankcards == null");
      if (this.CXv != null) {
        break label163;
      }
      ae.i("MicroMsg.WalletUserInfoManger", "virtualBankcards == null");
      label59:
      if (this.CRg != null) {
        break label215;
      }
      ae.i("MicroMsg.WalletUserInfoManger", "balance == null");
      label74:
      if (this.Dsz != null) {
        break label226;
      }
      ae.i("MicroMsg.WalletUserInfoManger", "historyBankcard == null");
    }
    for (;;)
    {
      if (this.DsB != null) {
        break label237;
      }
      ae.i("MicroMsg.WalletUserInfoManger", "mLoanEntryInfo == null");
      AppMethodBeat.o(70531);
      return;
      if (this.CXu.size() == 0)
      {
        ae.i("MicroMsg.WalletUserInfoManger", "bankcards.size() == 0");
        break;
      }
      ae.i("MicroMsg.WalletUserInfoManger", "bankcards.size() == " + this.CXu.size());
      break;
      label163:
      if (this.CXv.size() == 0)
      {
        ae.i("MicroMsg.WalletUserInfoManger", "virtualBankcards.size() == 0");
        break label59;
      }
      ae.i("MicroMsg.WalletUserInfoManger", "virtualBankcards.size() == " + this.CXv.size());
      break label59;
      label215:
      ae.i("MicroMsg.WalletUserInfoManger", "balance != null");
      break label74;
      label226:
      ae.i("MicroMsg.WalletUserInfoManger", "historyBankcard != null");
    }
    label237:
    ae.i("MicroMsg.WalletUserInfoManger", "mLoanEntryInfo != null");
    AppMethodBeat.o(70531);
  }
  
  public static Bankcard eKs()
  {
    AppMethodBeat.i(70533);
    Bankcard localBankcard = t.eJf().a(null, null, true, true);
    if (localBankcard == null) {
      ae.e("MicroMsg.WalletUserInfoManger", "defaultBankcards == null");
    }
    AppMethodBeat.o(70533);
    return localBankcard;
  }
  
  private static boolean gS(List<Bankcard> paramList)
  {
    AppMethodBeat.i(70517);
    if (paramList.size() == 0)
    {
      AppMethodBeat.o(70517);
      return false;
    }
    g.ajS();
    Object localObject = (String)g.ajR().ajA().get(196659, null);
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
  
  public final void Zq()
  {
    AppMethodBeat.i(70505);
    if (this.Dsy != null)
    {
      this.Dsy.field_is_reg = -1;
      this.Dsy = null;
    }
    if (this.DsA != null) {
      this.DsA = null;
    }
    if (this.CRg != null) {
      this.CRg = null;
    }
    if (this.CXu != null)
    {
      this.CXu.clear();
      this.CXu = null;
    }
    if (this.CXv != null)
    {
      this.CXv.clear();
      this.CXv = null;
    }
    if (this.DsF != null) {
      this.DsF = null;
    }
    this.DsH = 0L;
    f.a(new f.c[] { new f.c("wallet_balance_version", Integer.valueOf(-1)), new f.c("wallet_balance_last_update_time", Integer.valueOf(-1)), new f.c("wallet_balance", Integer.valueOf(-1)) });
    this.DsG = bu.aRi();
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
  
  public final void a(am paramam)
  {
    AppMethodBeat.i(70521);
    this.Dsy = paramam;
    t.eJa().aTi();
    t.eJa().b(paramam);
    AppMethodBeat.o(70521);
  }
  
  public final void a(am paramam, ArrayList<Bankcard> paramArrayList1, ArrayList<Bankcard> paramArrayList2, Bankcard paramBankcard1, Bankcard paramBankcard2, n paramn, b paramb, Bankcard paramBankcard3, int paramInt1, int paramInt2, List<c> paramList)
  {
    AppMethodBeat.i(70520);
    ae.i("MicroMsg.WalletUserInfoManger", "setBankcards scene %d", new Object[] { Integer.valueOf(paramInt2) });
    if (paramInt2 == 8)
    {
      this.Dsv = paramArrayList1;
      this.DsD = paramList;
    }
    if ((paramInt2 == 24) || (paramInt2 == 25)) {
      this.Dsw = paramArrayList1;
    }
    if (paramInt2 == 12) {
      this.Dsx = paramArrayList1;
    }
    this.CXu = paramArrayList1;
    this.CXv = paramArrayList2;
    this.CRg = paramBankcard1;
    this.DsA = new al(paramam.field_switchConfig, paramam.field_wallet_entrance_balance_switch_state);
    this.Dsz = paramBankcard2;
    this.DsB = paramn;
    this.DsC = paramb;
    this.DsE = paramBankcard3;
    ae.i("MicroMsg.WalletUserInfoManger", "setBankcards()! " + paramam.field_switchConfig);
    eKr();
    int i = paramInt1;
    if (paramInt1 < 0) {
      i = 600;
    }
    this.DsG = (bu.aRi() + i);
    this.DsH = (bu.aRi() + 600L);
    ae.i("MicroMsg.WalletUserInfoManger", "hy: cache time: %d, dead time: %d, cacheDeadTime: %s", new Object[] { Integer.valueOf(i), Long.valueOf(this.DsG), Long.valueOf(this.DsH) });
    com.tencent.mm.plugin.wallet_core.utils.d.Wr(paramInt2);
    if ((paramInt2 != 24) && (paramInt2 != 25) && (paramArrayList1 != null)) {
      com.tencent.mm.plugin.wallet_core.utils.d.y(paramArrayList1, paramInt2);
    }
    if (paramArrayList2 != null) {
      com.tencent.mm.plugin.wallet_core.utils.d.y(paramArrayList2, paramInt2);
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
    a(paramam);
    t.eJh().aTi();
    if (paramn != null) {
      t.eJh().insert(paramn);
    }
    AppMethodBeat.o(70520);
  }
  
  public final Bankcard aFN(String paramString)
  {
    AppMethodBeat.i(190195);
    if ((this.CXu != null) && (!this.CXu.isEmpty()))
    {
      Iterator localIterator = this.CXu.iterator();
      while (localIterator.hasNext())
      {
        Bankcard localBankcard = (Bankcard)localIterator.next();
        if (localBankcard.field_bindSerial.equals(paramString))
        {
          AppMethodBeat.o(190195);
          return localBankcard;
        }
      }
    }
    AppMethodBeat.o(190195);
    return null;
  }
  
  public final boolean aFO(String paramString)
  {
    AppMethodBeat.i(70518);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(70518);
      return false;
    }
    Iterator localIterator;
    Bankcard localBankcard;
    if (this.CXu != null)
    {
      localIterator = this.CXu.iterator();
      while (localIterator.hasNext())
      {
        localBankcard = (Bankcard)localIterator.next();
        if ((paramString.equals(localBankcard.field_bankcardType)) && (localBankcard.eIx()))
        {
          AppMethodBeat.o(70518);
          return false;
        }
      }
    }
    if (this.CXv != null)
    {
      localIterator = this.CXv.iterator();
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
  
  public final void c(cee paramcee)
  {
    AppMethodBeat.i(70519);
    this.DsF = paramcee;
    ai.a(paramcee);
    AppMethodBeat.o(70519);
  }
  
  public final boolean eJH()
  {
    AppMethodBeat.i(70496);
    if ((this.Dsy != null) && (this.Dsy.eJH()))
    {
      AppMethodBeat.o(70496);
      return true;
    }
    AppMethodBeat.o(70496);
    return false;
  }
  
  public final boolean eJI()
  {
    AppMethodBeat.i(70498);
    if ((this.Dsy != null) && (this.Dsy.eJI()))
    {
      AppMethodBeat.o(70498);
      return true;
    }
    AppMethodBeat.o(70498);
    return false;
  }
  
  public final boolean eJJ()
  {
    AppMethodBeat.i(70497);
    if ((this.Dsy != null) && (this.Dsy.eJJ()))
    {
      AppMethodBeat.o(70497);
      return true;
    }
    AppMethodBeat.o(70497);
    return false;
  }
  
  public final boolean eJL()
  {
    AppMethodBeat.i(70499);
    if ((this.Dsy != null) && (this.Dsy.eJL()))
    {
      AppMethodBeat.o(70499);
      return true;
    }
    AppMethodBeat.o(70499);
    return false;
  }
  
  public final boolean eJM()
  {
    AppMethodBeat.i(70495);
    if ((this.Dsy == null) || ((this.Dsy != null) && (this.Dsy.eJK())))
    {
      AppMethodBeat.o(70495);
      return true;
    }
    AppMethodBeat.o(70495);
    return false;
  }
  
  public final int eJN()
  {
    if (this.Dsy != null) {
      return this.Dsy.field_soter_pay_open_type;
    }
    return 0;
  }
  
  public final String eJO()
  {
    if (this.Dsy != null) {
      return this.Dsy.field_ftf_pay_url;
    }
    return null;
  }
  
  public final al eJP()
  {
    AppMethodBeat.i(70501);
    if (this.DsA == null)
    {
      localal = new al();
      AppMethodBeat.o(70501);
      return localal;
    }
    al localal = this.DsA;
    AppMethodBeat.o(70501);
    return localal;
  }
  
  public final boolean eJQ()
  {
    return (this.Dsy != null) && (this.Dsy.field_isDomesticUser);
  }
  
  public final int eJR()
  {
    if (this.Dsy != null) {
      return this.Dsy.field_cre_type;
    }
    return 1;
  }
  
  public final String eJS()
  {
    AppMethodBeat.i(70502);
    g.ajS();
    String str = (String)g.ajR().ajA().get(am.a.IVA, null);
    if (!bu.isNullOrNil(str))
    {
      AppMethodBeat.o(70502);
      return str;
    }
    if (this.Dsy != null)
    {
      str = this.Dsy.field_lct_wording;
      AppMethodBeat.o(70502);
      return str;
    }
    AppMethodBeat.o(70502);
    return null;
  }
  
  public final String eJT()
  {
    if (this.Dsy != null) {
      return this.Dsy.field_lct_url;
    }
    return null;
  }
  
  public final String eJU()
  {
    if (this.Dsy != null) {
      return this.Dsy.field_forget_passwd_url;
    }
    return "";
  }
  
  public final void eJV()
  {
    AppMethodBeat.i(70503);
    if (!g.ajP().aiZ())
    {
      ae.w("MicroMsg.WalletUserInfoManger", "Account Not Ready!");
      AppMethodBeat.o(70503);
      return;
    }
    this.Dsy = t.eJa().eKO();
    if (this.Dsy != null) {
      this.DsA = new al(this.Dsy.field_switchConfig, this.Dsy.field_wallet_entrance_balance_switch_state);
    }
    for (;;)
    {
      if (!bu.isNullOrNil(this.Dsy.field_bank_priority)) {}
      try
      {
        this.DsD = ai.bq(new JSONObject(this.Dsy.field_bank_priority));
        this.CRg = t.eJc().eKJ();
        this.DsE = t.eJc().eKK();
        f.a("wallet_balance", new f.b()
        {
          public final void dr(Object paramAnonymousObject)
          {
            AppMethodBeat.i(70493);
            if ((paramAnonymousObject != null) && ((paramAnonymousObject instanceof Double)))
            {
              if (((Double)paramAnonymousObject).doubleValue() < 0.0D) {
                ae.v("MicroMsg.WalletUserInfoManger", "val is zero %s", new Object[] { bu.fpN().toString() });
              }
              if (an.this.CRg != null)
              {
                an.this.CRg.Dmj = ((Double)paramAnonymousObject).doubleValue();
                AppMethodBeat.o(70493);
              }
            }
            else
            {
              ae.i("MicroMsg.WalletUserInfoManger", "hy: no balance info. set to negative");
              if (an.this.CRg != null) {
                an.this.CRg.Dmj = -1.0D;
              }
            }
            AppMethodBeat.o(70493);
          }
        });
        this.CXu = t.eJc().eKb();
        this.Dsv = com.tencent.mm.plugin.wallet_core.utils.d.Ws(8);
        this.Dsx = com.tencent.mm.plugin.wallet_core.utils.d.Ws(12);
        this.CXv = t.eJc().eKL();
        this.Dsz = t.eJc().eKM();
        this.DsB = t.eJh().eKH();
        ae.i("MicroMsg.WalletUserInfoManger", "loadDbData!");
        eKr();
        this.DsF = ai.eJs();
        AppMethodBeat.o(70503);
        return;
        this.DsA = new al();
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          ae.printErrStackTrace("MicroMsg.WalletUserInfoManger", localJSONException, "", new Object[0]);
        }
      }
    }
  }
  
  public final boolean eJW()
  {
    AppMethodBeat.i(70504);
    if (ac.iSI)
    {
      AppMethodBeat.o(70504);
      return true;
    }
    g.ajS();
    int i = ((Integer)g.ajR().ajA().get(am.a.IVz, Integer.valueOf(-1))).intValue();
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
    if (this.Dsy != null)
    {
      if (this.Dsy.field_lqt_state == 1)
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
  
  public final int eJX()
  {
    if (this.Dsy != null) {
      return this.Dsy.field_is_show_lqb;
    }
    return 0;
  }
  
  public final boolean eJY()
  {
    if (this.Dsy != null) {
      return this.Dsy.field_is_open_lqb == 1;
    }
    return false;
  }
  
  public final String eJZ()
  {
    if (this.Dsy != null) {
      return this.Dsy.field_lqb_open_url;
    }
    return null;
  }
  
  public final boolean eKa()
  {
    if (this.Dsy != null) {
      return this.Dsy.field_paymenu_use_new == 1;
    }
    return false;
  }
  
  public final ArrayList<Bankcard> eKb()
  {
    AppMethodBeat.i(70506);
    if ((this.CXu == null) || (this.CXu.size() <= 0)) {
      this.CXu = t.eJc().eKb();
    }
    if ((this.CXu == null) || (this.CXu.size() <= 0))
    {
      AppMethodBeat.o(70506);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.CXu.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add((Bankcard)localIterator.next());
    }
    AppMethodBeat.o(70506);
    return localArrayList;
  }
  
  public final List<c> eKc()
  {
    AppMethodBeat.i(70507);
    if ((this.DsD == null) || (this.DsD.size() <= 0))
    {
      AppMethodBeat.o(70507);
      return null;
    }
    List localList = this.DsD;
    AppMethodBeat.o(70507);
    return localList;
  }
  
  public final ArrayList<Bankcard> eKd()
  {
    AppMethodBeat.i(70508);
    if ((this.CXu == null) || (this.CXu.size() <= 0))
    {
      AppMethodBeat.o(70508);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.CXu.iterator();
    while (localIterator.hasNext())
    {
      Bankcard localBankcard = (Bankcard)localIterator.next();
      if ((!localBankcard.eIA()) && (!localBankcard.eIC())) {
        localArrayList.add(localBankcard);
      }
    }
    AppMethodBeat.o(70508);
    return localArrayList;
  }
  
  public final ArrayList<Bankcard> eKe()
  {
    AppMethodBeat.i(70511);
    ArrayList localArrayList = new ArrayList();
    if ((this.CRg != null) && (!eJJ())) {
      localArrayList.add(this.CRg);
    }
    if ((this.DsE != null) && (!eJJ())) {
      localArrayList.add(this.DsE);
    }
    Iterator localIterator;
    if ((this.Dsv != null) && (this.Dsv.size() > 0)) {
      localIterator = this.Dsv.iterator();
    }
    while (localIterator.hasNext())
    {
      localArrayList.add((Bankcard)localIterator.next());
      continue;
      if ((this.CXu != null) && (this.CXu.size() > 0))
      {
        localIterator = this.CXu.iterator();
        while (localIterator.hasNext()) {
          localArrayList.add((Bankcard)localIterator.next());
        }
      }
    }
    AppMethodBeat.o(70511);
    return localArrayList;
  }
  
  public final ArrayList<Bankcard> eKf()
  {
    AppMethodBeat.i(70512);
    ArrayList localArrayList = new ArrayList();
    if ((this.CRg != null) && (!eJJ())) {
      localArrayList.add(this.CRg);
    }
    if ((this.Dsw != null) && (this.CXu != null) && (this.Dsw.size() > 0))
    {
      Iterator localIterator = this.Dsw.iterator();
      while (localIterator.hasNext())
      {
        Bankcard localBankcard = (Bankcard)localIterator.next();
        if (!localBankcard.eIC()) {
          localArrayList.add(localBankcard);
        }
      }
    }
    AppMethodBeat.o(70512);
    return localArrayList;
  }
  
  public final boolean eKg()
  {
    AppMethodBeat.i(70514);
    if (eKh())
    {
      AppMethodBeat.o(70514);
      return false;
    }
    if ((this.CXu != null) && (this.CXu.size() > 0))
    {
      AppMethodBeat.o(70514);
      return false;
    }
    AppMethodBeat.o(70514);
    return true;
  }
  
  public final boolean eKi()
  {
    AppMethodBeat.i(70516);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    f(localArrayList1, localArrayList2);
    if (gS(localArrayList2))
    {
      AppMethodBeat.o(70516);
      return true;
    }
    AppMethodBeat.o(70516);
    return false;
  }
  
  public final int eKj()
  {
    if (this.DsK > 0) {
      return this.DsK;
    }
    return 10000;
  }
  
  public final String eKl()
  {
    AppMethodBeat.i(70527);
    if ((this.CXu == null) || (this.CXu.size() <= 0))
    {
      ae.e("MicroMsg.WalletUserInfoManger", "not found bankcard!");
      AppMethodBeat.o(70527);
      return null;
    }
    Object localObject = this.CXu.iterator();
    if (((Iterator)localObject).hasNext())
    {
      localObject = ((Bankcard)((Iterator)localObject).next()).field_bindSerial;
      AppMethodBeat.o(70527);
      return localObject;
    }
    AppMethodBeat.o(70527);
    return null;
  }
  
  public final boolean eKn()
  {
    AppMethodBeat.i(70530);
    long l = bu.rZ(this.DsI);
    ae.d("MicroMsg.WalletUserInfoManger", "pass time ".concat(String.valueOf(l)));
    if (l > 300L)
    {
      AppMethodBeat.o(70530);
      return true;
    }
    AppMethodBeat.o(70530);
    return false;
  }
  
  public final int eKo()
  {
    if (this.Dsy != null) {
      return this.Dsy.field_lqt_cell_is_show;
    }
    return 0;
  }
  
  public final String eKp()
  {
    if (this.Dsy != null) {
      return this.Dsy.field_lqt_cell_lqt_title;
    }
    return null;
  }
  
  public final String eKq()
  {
    if (this.Dsy != null) {
      return this.Dsy.field_lqt_cell_lqt_wording;
    }
    return null;
  }
  
  public final void f(ArrayList<Bankcard> paramArrayList1, ArrayList<Bankcard> paramArrayList2)
  {
    AppMethodBeat.i(70513);
    if ((paramArrayList1 == null) || (paramArrayList2 == null))
    {
      ae.e("MicroMsg.WalletUserInfoManger", "error list,bankcardsClone == null || virtualBankcardsClone == null");
      AppMethodBeat.o(70513);
      return;
    }
    if ((this.Dsx == null) && (this.CXu != null))
    {
      ae.e("MicroMsg.WalletUserInfoManger", "listManageUIbankcards == null && bankcards != null");
      this.Dsx = this.CXu;
    }
    if (this.Dsx == null)
    {
      ae.e("MicroMsg.WalletUserInfoManger", "error list, listManageUIbankcards == null");
      AppMethodBeat.o(70513);
      return;
    }
    paramArrayList1.clear();
    paramArrayList2.clear();
    Iterator localIterator;
    if (this.Dsx != null)
    {
      localIterator = this.Dsx.iterator();
      while (localIterator.hasNext()) {
        paramArrayList1.add((Bankcard)localIterator.next());
      }
    }
    if (this.CXv != null)
    {
      localIterator = this.CXv.iterator();
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
    if (this.Dsy != null) {
      return this.Dsy.field_true_name;
    }
    return null;
  }
  
  public final ArrayList<Bankcard> uv(boolean paramBoolean)
  {
    AppMethodBeat.i(70509);
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean)
    {
      if ((this.CRg != null) && (!eJJ())) {
        localArrayList.add(this.CRg);
      }
      if ((this.DsE != null) && (!eJJ())) {
        localArrayList.add(this.DsE);
      }
    }
    if ((this.CXu != null) && (this.CXu.size() > 0))
    {
      Iterator localIterator = this.CXu.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add((Bankcard)localIterator.next());
      }
    }
    AppMethodBeat.o(70509);
    return localArrayList;
  }
  
  @Deprecated
  public final ArrayList<Bankcard> uw(boolean paramBoolean)
  {
    AppMethodBeat.i(224237);
    ArrayList localArrayList = uv(paramBoolean);
    AppMethodBeat.o(224237);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.an
 * JD-Core Version:    0.7.0.1
 */