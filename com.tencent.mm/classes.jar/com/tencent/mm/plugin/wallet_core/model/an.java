package com.tencent.mm.plugin.wallet_core.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.wallet_core.d.k;
import com.tencent.mm.protocal.protobuf.cdk;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.wallet_core.ui.e.b;
import com.tencent.mm.wallet_core.ui.e.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class an
{
  private ArrayList<Bankcard> CFO;
  private ArrayList<Bankcard> CFP;
  int CyX;
  int CyY;
  public Bankcard CzB;
  public ArrayList<Bankcard> DaR;
  private ArrayList<Bankcard> DaS;
  private ArrayList<Bankcard> DaT;
  public am DaU;
  public Bankcard DaV;
  public al DaW;
  public n DaX;
  public b DaY;
  private List<c> DaZ;
  public Bankcard Dba;
  public cdk Dbb;
  public long Dbc;
  long Dbd;
  public long Dbe;
  private String Dbf;
  public int Dbg;
  public String Dbh;
  public String Dbi;
  public int mRetryCount;
  
  public an()
  {
    AppMethodBeat.i(70494);
    this.DaR = new ArrayList();
    this.DaS = new ArrayList();
    this.DaT = new ArrayList();
    this.CFO = new ArrayList();
    this.CFP = new ArrayList();
    this.DaU = null;
    this.DaV = null;
    this.CzB = null;
    this.DaW = null;
    this.DaX = null;
    this.DaY = null;
    this.DaZ = new LinkedList();
    this.Dba = null;
    this.CyX = 0;
    this.CyY = 0;
    this.Dbc = bt.aQJ();
    this.Dbd = 0L;
    this.Dbe = -1L;
    this.Dbf = "";
    this.Dbg = 10000;
    this.mRetryCount = 0;
    this.Dbh = "";
    this.Dbi = "";
    eGo();
    AppMethodBeat.o(70494);
  }
  
  public static void aEv(String paramString)
  {
    AppMethodBeat.i(70523);
    if (!bt.isNullOrNil(paramString))
    {
      g.ajD();
      g.ajC().ajl().set(196612, paramString);
    }
    AppMethodBeat.o(70523);
  }
  
  private static void aEw(String paramString)
  {
    AppMethodBeat.i(70528);
    if (paramString != null)
    {
      g.ajD();
      g.ajC().ajl().set(196633, paramString);
    }
    AppMethodBeat.o(70528);
  }
  
  public static void aEx(String paramString)
  {
    AppMethodBeat.i(70532);
    ad.i("MicroMsg.WalletUserInfoManger", "setSelectBindSerial %s %s", new Object[] { paramString, bt.flS().toString() });
    aEw(paramString);
    AppMethodBeat.o(70532);
  }
  
  @Deprecated
  private Bankcard b(ArrayList<Bankcard> paramArrayList, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(70526);
    Object localObject1 = paramArrayList;
    if (paramArrayList == null) {
      localObject1 = this.CFO;
    }
    paramArrayList = paramString;
    if (bt.isNullOrNil(paramString)) {
      paramArrayList = eGD();
    }
    if ((paramBoolean1) && (this.CzB != null))
    {
      if (eGb())
      {
        paramArrayList = this.CzB;
        AppMethodBeat.o(70526);
        return paramArrayList;
      }
      if ((paramArrayList != null) && (paramArrayList.equals(this.CzB.field_bindSerial)))
      {
        paramArrayList = this.CzB;
        AppMethodBeat.o(70526);
        return paramArrayList;
      }
      if ((this.Dba != null) && (this.DaU != null) && (this.DaU.field_lqt_state == 1) && (paramArrayList != null) && (paramArrayList.equals(this.Dba.field_bindSerial)))
      {
        paramArrayList = this.Dba;
        AppMethodBeat.o(70526);
        return paramArrayList;
      }
      if ((!eGc()) && ((localObject1 == null) || (((ArrayList)localObject1).size() == 0)))
      {
        paramArrayList = this.CzB;
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
          if ((!paramBoolean3) || (!((Bankcard)localObject2).eEV())) {
            break;
          }
          ad.i("MicroMsg.WalletUserInfoManger", "default card is honeypay");
          if ((paramBoolean1) && (this.CzB != null))
          {
            paramArrayList = this.CzB;
            AppMethodBeat.o(70526);
            return paramArrayList;
          }
          localObject2 = ((ArrayList)localObject1).iterator();
        }
        localBankcard = (Bankcard)((Iterator)localObject2).next();
      } while (localBankcard.eEV());
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
  
  private boolean eGA()
  {
    AppMethodBeat.i(70515);
    if (((this.DaW != null) && (this.DaW.eFO())) || ((this.CFP != null) && (this.CFP.size() > 0)))
    {
      AppMethodBeat.o(70515);
      return true;
    }
    AppMethodBeat.o(70515);
    return false;
  }
  
  private static String eGD()
  {
    AppMethodBeat.i(70522);
    g.ajD();
    String str = (String)g.ajC().ajl().get(196612, null);
    AppMethodBeat.o(70522);
    return str;
  }
  
  public static String eGF()
  {
    AppMethodBeat.i(70529);
    g.ajD();
    String str = (String)g.ajC().ajl().get(196633, null);
    AppMethodBeat.o(70529);
    return str;
  }
  
  private void eGK()
  {
    AppMethodBeat.i(70531);
    ad.i("MicroMsg.WalletUserInfoManger", "recordDataState()");
    if (this.DaU == null) {
      ad.i("MicroMsg.WalletUserInfoManger", "userInfo == null");
    }
    if (this.CFO == null)
    {
      ad.i("MicroMsg.WalletUserInfoManger", "bankcards == null");
      if (this.CFP != null) {
        break label163;
      }
      ad.i("MicroMsg.WalletUserInfoManger", "virtualBankcards == null");
      label59:
      if (this.CzB != null) {
        break label215;
      }
      ad.i("MicroMsg.WalletUserInfoManger", "balance == null");
      label74:
      if (this.DaV != null) {
        break label226;
      }
      ad.i("MicroMsg.WalletUserInfoManger", "historyBankcard == null");
    }
    for (;;)
    {
      if (this.DaX != null) {
        break label237;
      }
      ad.i("MicroMsg.WalletUserInfoManger", "mLoanEntryInfo == null");
      AppMethodBeat.o(70531);
      return;
      if (this.CFO.size() == 0)
      {
        ad.i("MicroMsg.WalletUserInfoManger", "bankcards.size() == 0");
        break;
      }
      ad.i("MicroMsg.WalletUserInfoManger", "bankcards.size() == " + this.CFO.size());
      break;
      label163:
      if (this.CFP.size() == 0)
      {
        ad.i("MicroMsg.WalletUserInfoManger", "virtualBankcards.size() == 0");
        break label59;
      }
      ad.i("MicroMsg.WalletUserInfoManger", "virtualBankcards.size() == " + this.CFP.size());
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
  
  public static Bankcard eGL()
  {
    AppMethodBeat.i(70533);
    Bankcard localBankcard = t.eFy().a(null, null, true, true);
    if (localBankcard == null) {
      ad.e("MicroMsg.WalletUserInfoManger", "defaultBankcards == null");
    }
    AppMethodBeat.o(70533);
    return localBankcard;
  }
  
  private static boolean gJ(List<Bankcard> paramList)
  {
    AppMethodBeat.i(70517);
    if (paramList.size() == 0)
    {
      AppMethodBeat.o(70517);
      return false;
    }
    g.ajD();
    Object localObject = (String)g.ajC().ajl().get(196659, null);
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
  
  public final void Zh()
  {
    AppMethodBeat.i(70505);
    if (this.DaU != null)
    {
      this.DaU.field_is_reg = -1;
      this.DaU = null;
    }
    if (this.DaW != null) {
      this.DaW = null;
    }
    if (this.CzB != null) {
      this.CzB = null;
    }
    if (this.CFO != null)
    {
      this.CFO.clear();
      this.CFO = null;
    }
    if (this.CFP != null)
    {
      this.CFP.clear();
      this.CFP = null;
    }
    if (this.Dbb != null) {
      this.Dbb = null;
    }
    this.Dbd = 0L;
    com.tencent.mm.wallet_core.ui.e.a(new e.c[] { new e.c("wallet_balance_version", Integer.valueOf(-1)), new e.c("wallet_balance_last_update_time", Integer.valueOf(-1)), new e.c("wallet_balance", Integer.valueOf(-1)) });
    this.Dbc = bt.aQJ();
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
    this.DaU = paramam;
    t.eFt().aSJ();
    t.eFt().b(paramam);
    AppMethodBeat.o(70521);
  }
  
  public final void a(am paramam, ArrayList<Bankcard> paramArrayList1, ArrayList<Bankcard> paramArrayList2, Bankcard paramBankcard1, Bankcard paramBankcard2, n paramn, b paramb, Bankcard paramBankcard3, int paramInt1, int paramInt2, List<c> paramList)
  {
    AppMethodBeat.i(70520);
    ad.i("MicroMsg.WalletUserInfoManger", "setBankcards scene %d", new Object[] { Integer.valueOf(paramInt2) });
    if (paramInt2 == 8)
    {
      this.DaR = paramArrayList1;
      this.DaZ = paramList;
    }
    if ((paramInt2 == 24) || (paramInt2 == 25)) {
      this.DaS = paramArrayList1;
    }
    if (paramInt2 == 12) {
      this.DaT = paramArrayList1;
    }
    this.CFO = paramArrayList1;
    this.CFP = paramArrayList2;
    this.CzB = paramBankcard1;
    this.DaW = new al(paramam.field_switchConfig, paramam.field_wallet_entrance_balance_switch_state);
    this.DaV = paramBankcard2;
    this.DaX = paramn;
    this.DaY = paramb;
    this.Dba = paramBankcard3;
    ad.i("MicroMsg.WalletUserInfoManger", "setBankcards()! " + paramam.field_switchConfig);
    eGK();
    int i = paramInt1;
    if (paramInt1 < 0) {
      i = 600;
    }
    this.Dbc = (bt.aQJ() + i);
    this.Dbd = (bt.aQJ() + 600L);
    ad.i("MicroMsg.WalletUserInfoManger", "hy: cache time: %d, dead time: %d, cacheDeadTime: %s", new Object[] { Integer.valueOf(i), Long.valueOf(this.Dbc), Long.valueOf(this.Dbd) });
    com.tencent.mm.plugin.wallet_core.utils.d.VK(paramInt2);
    if ((paramInt2 != 24) && (paramInt2 != 25) && (paramArrayList1 != null)) {
      com.tencent.mm.plugin.wallet_core.utils.d.x(paramArrayList1, paramInt2);
    }
    if (paramArrayList2 != null) {
      com.tencent.mm.plugin.wallet_core.utils.d.x(paramArrayList2, paramInt2);
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
    t.eFA().aSJ();
    if (paramn != null) {
      t.eFA().insert(paramn);
    }
    AppMethodBeat.o(70520);
  }
  
  public final Bankcard aEt(String paramString)
  {
    AppMethodBeat.i(199316);
    if ((this.CFO != null) && (!this.CFO.isEmpty()))
    {
      Iterator localIterator = this.CFO.iterator();
      while (localIterator.hasNext())
      {
        Bankcard localBankcard = (Bankcard)localIterator.next();
        if (localBankcard.field_bindSerial.equals(paramString))
        {
          AppMethodBeat.o(199316);
          return localBankcard;
        }
      }
    }
    AppMethodBeat.o(199316);
    return null;
  }
  
  public final boolean aEu(String paramString)
  {
    AppMethodBeat.i(70518);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(70518);
      return false;
    }
    Iterator localIterator;
    Bankcard localBankcard;
    if (this.CFO != null)
    {
      localIterator = this.CFO.iterator();
      while (localIterator.hasNext())
      {
        localBankcard = (Bankcard)localIterator.next();
        if ((paramString.equals(localBankcard.field_bankcardType)) && (localBankcard.eEQ()))
        {
          AppMethodBeat.o(70518);
          return false;
        }
      }
    }
    if (this.CFP != null)
    {
      localIterator = this.CFP.iterator();
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
  
  public final void c(cdk paramcdk)
  {
    AppMethodBeat.i(70519);
    this.Dbb = paramcdk;
    ai.a(paramcdk);
    AppMethodBeat.o(70519);
  }
  
  public final boolean eGB()
  {
    AppMethodBeat.i(70516);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    f(localArrayList1, localArrayList2);
    if (gJ(localArrayList2))
    {
      AppMethodBeat.o(70516);
      return true;
    }
    AppMethodBeat.o(70516);
    return false;
  }
  
  public final int eGC()
  {
    if (this.Dbg > 0) {
      return this.Dbg;
    }
    return 10000;
  }
  
  public final String eGE()
  {
    AppMethodBeat.i(70527);
    if ((this.CFO == null) || (this.CFO.size() <= 0))
    {
      ad.e("MicroMsg.WalletUserInfoManger", "not found bankcard!");
      AppMethodBeat.o(70527);
      return null;
    }
    Object localObject = this.CFO.iterator();
    if (((Iterator)localObject).hasNext())
    {
      localObject = ((Bankcard)((Iterator)localObject).next()).field_bindSerial;
      AppMethodBeat.o(70527);
      return localObject;
    }
    AppMethodBeat.o(70527);
    return null;
  }
  
  public final boolean eGG()
  {
    AppMethodBeat.i(70530);
    long l = bt.rM(this.Dbe);
    ad.d("MicroMsg.WalletUserInfoManger", "pass time ".concat(String.valueOf(l)));
    if (l > 300L)
    {
      AppMethodBeat.o(70530);
      return true;
    }
    AppMethodBeat.o(70530);
    return false;
  }
  
  public final int eGH()
  {
    if (this.DaU != null) {
      return this.DaU.field_lqt_cell_is_show;
    }
    return 0;
  }
  
  public final String eGI()
  {
    if (this.DaU != null) {
      return this.DaU.field_lqt_cell_lqt_title;
    }
    return null;
  }
  
  public final String eGJ()
  {
    if (this.DaU != null) {
      return this.DaU.field_lqt_cell_lqt_wording;
    }
    return null;
  }
  
  public final boolean eGa()
  {
    AppMethodBeat.i(70496);
    if ((this.DaU != null) && (this.DaU.eGa()))
    {
      AppMethodBeat.o(70496);
      return true;
    }
    AppMethodBeat.o(70496);
    return false;
  }
  
  public final boolean eGb()
  {
    AppMethodBeat.i(70498);
    if ((this.DaU != null) && (this.DaU.eGb()))
    {
      AppMethodBeat.o(70498);
      return true;
    }
    AppMethodBeat.o(70498);
    return false;
  }
  
  public final boolean eGc()
  {
    AppMethodBeat.i(70497);
    if ((this.DaU != null) && (this.DaU.eGc()))
    {
      AppMethodBeat.o(70497);
      return true;
    }
    AppMethodBeat.o(70497);
    return false;
  }
  
  public final boolean eGe()
  {
    AppMethodBeat.i(70499);
    if ((this.DaU != null) && (this.DaU.eGe()))
    {
      AppMethodBeat.o(70499);
      return true;
    }
    AppMethodBeat.o(70499);
    return false;
  }
  
  public final boolean eGf()
  {
    AppMethodBeat.i(70495);
    if ((this.DaU == null) || ((this.DaU != null) && (this.DaU.eGd())))
    {
      AppMethodBeat.o(70495);
      return true;
    }
    AppMethodBeat.o(70495);
    return false;
  }
  
  public final int eGg()
  {
    if (this.DaU != null) {
      return this.DaU.field_soter_pay_open_type;
    }
    return 0;
  }
  
  public final String eGh()
  {
    if (this.DaU != null) {
      return this.DaU.field_ftf_pay_url;
    }
    return null;
  }
  
  public final al eGi()
  {
    AppMethodBeat.i(70501);
    if (this.DaW == null)
    {
      localal = new al();
      AppMethodBeat.o(70501);
      return localal;
    }
    al localal = this.DaW;
    AppMethodBeat.o(70501);
    return localal;
  }
  
  public final boolean eGj()
  {
    return (this.DaU != null) && (this.DaU.field_isDomesticUser);
  }
  
  public final int eGk()
  {
    if (this.DaU != null) {
      return this.DaU.field_cre_type;
    }
    return 1;
  }
  
  public final String eGl()
  {
    AppMethodBeat.i(70502);
    g.ajD();
    String str = (String)g.ajC().ajl().get(al.a.IBb, null);
    if (!bt.isNullOrNil(str))
    {
      AppMethodBeat.o(70502);
      return str;
    }
    if (this.DaU != null)
    {
      str = this.DaU.field_lct_wording;
      AppMethodBeat.o(70502);
      return str;
    }
    AppMethodBeat.o(70502);
    return null;
  }
  
  public final String eGm()
  {
    if (this.DaU != null) {
      return this.DaU.field_lct_url;
    }
    return null;
  }
  
  public final String eGn()
  {
    if (this.DaU != null) {
      return this.DaU.field_forget_passwd_url;
    }
    return "";
  }
  
  public final void eGo()
  {
    AppMethodBeat.i(70503);
    if (!g.ajA().aiK())
    {
      ad.w("MicroMsg.WalletUserInfoManger", "Account Not Ready!");
      AppMethodBeat.o(70503);
      return;
    }
    this.DaU = t.eFt().eHg();
    if (this.DaU != null) {
      this.DaW = new al(this.DaU.field_switchConfig, this.DaU.field_wallet_entrance_balance_switch_state);
    }
    for (;;)
    {
      if (!bt.isNullOrNil(this.DaU.field_bank_priority)) {}
      try
      {
        this.DaZ = ai.bq(new JSONObject(this.DaU.field_bank_priority));
        this.CzB = t.eFv().eHb();
        this.Dba = t.eFv().eHc();
        com.tencent.mm.wallet_core.ui.e.a("wallet_balance", new e.b()
        {
          public final void dq(Object paramAnonymousObject)
          {
            AppMethodBeat.i(70493);
            if ((paramAnonymousObject != null) && ((paramAnonymousObject instanceof Double)))
            {
              if (((Double)paramAnonymousObject).doubleValue() < 0.0D) {
                ad.v("MicroMsg.WalletUserInfoManger", "val is zero %s", new Object[] { bt.flS().toString() });
              }
              if (an.this.CzB != null)
              {
                an.this.CzB.CUD = ((Double)paramAnonymousObject).doubleValue();
                AppMethodBeat.o(70493);
              }
            }
            else
            {
              ad.i("MicroMsg.WalletUserInfoManger", "hy: no balance info. set to negative");
              if (an.this.CzB != null) {
                an.this.CzB.CUD = -1.0D;
              }
            }
            AppMethodBeat.o(70493);
          }
        });
        this.CFO = t.eFv().eGu();
        this.DaR = com.tencent.mm.plugin.wallet_core.utils.d.VL(8);
        this.DaT = com.tencent.mm.plugin.wallet_core.utils.d.VL(12);
        this.CFP = t.eFv().eHd();
        this.DaV = t.eFv().eHe();
        this.DaX = t.eFA().eGZ();
        ad.i("MicroMsg.WalletUserInfoManger", "loadDbData!");
        eGK();
        this.Dbb = ai.eFL();
        AppMethodBeat.o(70503);
        return;
        this.DaW = new al();
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
  
  public final boolean eGp()
  {
    AppMethodBeat.i(70504);
    if (ac.iPP)
    {
      AppMethodBeat.o(70504);
      return true;
    }
    g.ajD();
    int i = ((Integer)g.ajC().ajl().get(al.a.IBa, Integer.valueOf(-1))).intValue();
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
    if (this.DaU != null)
    {
      if (this.DaU.field_lqt_state == 1)
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
  
  public final int eGq()
  {
    if (this.DaU != null) {
      return this.DaU.field_is_show_lqb;
    }
    return 0;
  }
  
  public final boolean eGr()
  {
    if (this.DaU != null) {
      return this.DaU.field_is_open_lqb == 1;
    }
    return false;
  }
  
  public final String eGs()
  {
    if (this.DaU != null) {
      return this.DaU.field_lqb_open_url;
    }
    return null;
  }
  
  public final boolean eGt()
  {
    if (this.DaU != null) {
      return this.DaU.field_paymenu_use_new == 1;
    }
    return false;
  }
  
  public final ArrayList<Bankcard> eGu()
  {
    AppMethodBeat.i(70506);
    if ((this.CFO == null) || (this.CFO.size() <= 0)) {
      this.CFO = t.eFv().eGu();
    }
    if ((this.CFO == null) || (this.CFO.size() <= 0))
    {
      AppMethodBeat.o(70506);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.CFO.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add((Bankcard)localIterator.next());
    }
    AppMethodBeat.o(70506);
    return localArrayList;
  }
  
  public final List<c> eGv()
  {
    AppMethodBeat.i(70507);
    if ((this.DaZ == null) || (this.DaZ.size() <= 0))
    {
      AppMethodBeat.o(70507);
      return null;
    }
    List localList = this.DaZ;
    AppMethodBeat.o(70507);
    return localList;
  }
  
  public final ArrayList<Bankcard> eGw()
  {
    AppMethodBeat.i(70508);
    if ((this.CFO == null) || (this.CFO.size() <= 0))
    {
      AppMethodBeat.o(70508);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.CFO.iterator();
    while (localIterator.hasNext())
    {
      Bankcard localBankcard = (Bankcard)localIterator.next();
      if ((!localBankcard.eET()) && (!localBankcard.eEV())) {
        localArrayList.add(localBankcard);
      }
    }
    AppMethodBeat.o(70508);
    return localArrayList;
  }
  
  public final ArrayList<Bankcard> eGx()
  {
    AppMethodBeat.i(70511);
    ArrayList localArrayList = new ArrayList();
    if ((this.CzB != null) && (!eGc())) {
      localArrayList.add(this.CzB);
    }
    if ((this.Dba != null) && (!eGc())) {
      localArrayList.add(this.Dba);
    }
    Iterator localIterator;
    if ((this.DaR != null) && (this.DaR.size() > 0)) {
      localIterator = this.DaR.iterator();
    }
    while (localIterator.hasNext())
    {
      localArrayList.add((Bankcard)localIterator.next());
      continue;
      if ((this.CFO != null) && (this.CFO.size() > 0))
      {
        localIterator = this.CFO.iterator();
        while (localIterator.hasNext()) {
          localArrayList.add((Bankcard)localIterator.next());
        }
      }
    }
    AppMethodBeat.o(70511);
    return localArrayList;
  }
  
  public final ArrayList<Bankcard> eGy()
  {
    AppMethodBeat.i(70512);
    ArrayList localArrayList = new ArrayList();
    if ((this.CzB != null) && (!eGc())) {
      localArrayList.add(this.CzB);
    }
    if ((this.DaS != null) && (this.CFO != null) && (this.DaS.size() > 0))
    {
      Iterator localIterator = this.DaS.iterator();
      while (localIterator.hasNext())
      {
        Bankcard localBankcard = (Bankcard)localIterator.next();
        if (!localBankcard.eEV()) {
          localArrayList.add(localBankcard);
        }
      }
    }
    AppMethodBeat.o(70512);
    return localArrayList;
  }
  
  public final boolean eGz()
  {
    AppMethodBeat.i(70514);
    if (eGA())
    {
      AppMethodBeat.o(70514);
      return false;
    }
    if ((this.CFO != null) && (this.CFO.size() > 0))
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
      ad.e("MicroMsg.WalletUserInfoManger", "error list,bankcardsClone == null || virtualBankcardsClone == null");
      AppMethodBeat.o(70513);
      return;
    }
    if ((this.DaT == null) && (this.CFO != null))
    {
      ad.e("MicroMsg.WalletUserInfoManger", "listManageUIbankcards == null && bankcards != null");
      this.DaT = this.CFO;
    }
    if (this.DaT == null)
    {
      ad.e("MicroMsg.WalletUserInfoManger", "error list, listManageUIbankcards == null");
      AppMethodBeat.o(70513);
      return;
    }
    paramArrayList1.clear();
    paramArrayList2.clear();
    Iterator localIterator;
    if (this.DaT != null)
    {
      localIterator = this.DaT.iterator();
      while (localIterator.hasNext()) {
        paramArrayList1.add((Bankcard)localIterator.next());
      }
    }
    if (this.CFP != null)
    {
      localIterator = this.CFP.iterator();
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
    if (this.DaU != null) {
      return this.DaU.field_true_name;
    }
    return null;
  }
  
  public final ArrayList<Bankcard> un(boolean paramBoolean)
  {
    AppMethodBeat.i(70509);
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean)
    {
      if ((this.CzB != null) && (!eGc())) {
        localArrayList.add(this.CzB);
      }
      if ((this.Dba != null) && (!eGc())) {
        localArrayList.add(this.Dba);
      }
    }
    if ((this.CFO != null) && (this.CFO.size() > 0))
    {
      Iterator localIterator = this.CFO.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add((Bankcard)localIterator.next());
      }
    }
    AppMethodBeat.o(70509);
    return localArrayList;
  }
  
  @Deprecated
  public final ArrayList<Bankcard> uo(boolean paramBoolean)
  {
    AppMethodBeat.i(221335);
    ArrayList localArrayList = un(paramBoolean);
    AppMethodBeat.o(221335);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.an
 * JD-Core Version:    0.7.0.1
 */