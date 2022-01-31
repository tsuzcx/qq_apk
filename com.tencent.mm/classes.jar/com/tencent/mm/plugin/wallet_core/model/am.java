package com.tencent.mm.plugin.wallet_core.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.wallet_core.d.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.wallet_core.ui.e.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class am
{
  public int mRetryCount;
  public Bankcard tOD;
  int tOb;
  int tOc;
  private ArrayList<Bankcard> tSX;
  private ArrayList<Bankcard> tSY;
  private ArrayList<Bankcard> ulL;
  private ArrayList<Bankcard> ulM;
  public al ulN;
  public Bankcard ulO;
  public ak ulP;
  public p ulQ;
  public c ulR;
  private List<e> ulS;
  public Bankcard ulT;
  public long ulU;
  long ulV;
  public long ulW;
  private String ulX;
  public int ulY;
  public String ulZ;
  public String uma;
  
  public am()
  {
    AppMethodBeat.i(46964);
    this.ulL = new ArrayList();
    this.ulM = new ArrayList();
    this.tSX = new ArrayList();
    this.tSY = new ArrayList();
    this.ulN = null;
    this.ulO = null;
    this.tOD = null;
    this.ulP = null;
    this.ulQ = null;
    this.ulR = null;
    this.ulS = new LinkedList();
    this.ulT = null;
    this.tOb = 0;
    this.tOc = 0;
    this.ulU = bo.aox();
    this.ulV = 0L;
    this.ulW = -1L;
    this.ulX = "";
    this.ulY = 10000;
    this.mRetryCount = 0;
    this.ulZ = "";
    this.uma = "";
    cUz();
    AppMethodBeat.o(46964);
  }
  
  public static void afm(String paramString)
  {
    AppMethodBeat.i(46992);
    if (!bo.isNullOrNil(paramString))
    {
      g.RM();
      g.RL().Ru().set(196612, paramString);
    }
    AppMethodBeat.o(46992);
  }
  
  private static void afn(String paramString)
  {
    AppMethodBeat.i(46997);
    if (paramString != null)
    {
      g.RM();
      g.RL().Ru().set(196633, paramString);
    }
    AppMethodBeat.o(46997);
  }
  
  public static void afo(String paramString)
  {
    AppMethodBeat.i(47000);
    ab.i("MicroMsg.WalletUserInfoManger", "setSelectBindSerial %s %s", new Object[] { paramString, bo.dtY().toString() });
    afn(paramString);
    AppMethodBeat.o(47000);
  }
  
  @Deprecated
  private Bankcard b(ArrayList<Bankcard> paramArrayList, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(46995);
    Object localObject1 = paramArrayList;
    if (paramArrayList == null) {
      localObject1 = this.tSX;
    }
    paramArrayList = paramString;
    if (bo.isNullOrNil(paramString)) {
      paramArrayList = cUO();
    }
    if ((paramBoolean1) && (this.tOD != null))
    {
      if (cUm())
      {
        paramArrayList = this.tOD;
        AppMethodBeat.o(46995);
        return paramArrayList;
      }
      if ((paramArrayList != null) && (paramArrayList.equals(this.tOD.field_bindSerial)))
      {
        paramArrayList = this.tOD;
        AppMethodBeat.o(46995);
        return paramArrayList;
      }
      if ((this.ulT != null) && (this.ulN != null) && (this.ulN.field_lqt_state == 1) && (paramArrayList != null) && (paramArrayList.equals(this.ulT.field_bindSerial)))
      {
        paramArrayList = this.ulT;
        AppMethodBeat.o(46995);
        return paramArrayList;
      }
      if ((!cUn()) && ((localObject1 == null) || (((ArrayList)localObject1).size() == 0)))
      {
        paramArrayList = this.tOD;
        AppMethodBeat.o(46995);
        return paramArrayList;
      }
    }
    if ((localObject1 == null) || (((ArrayList)localObject1).size() <= 0))
    {
      ab.e("MicroMsg.WalletUserInfoManger", "not found bankcard!");
      AppMethodBeat.o(46995);
      return null;
    }
    if ((((ArrayList)localObject1).size() == 1) && (paramBoolean2))
    {
      ab.e("MicroMsg.WalletUserInfoManger", "only one bankcard!");
      paramArrayList = (Bankcard)((ArrayList)localObject1).get(0);
      AppMethodBeat.o(46995);
      return paramArrayList;
    }
    ab.i("MicroMsg.WalletUserInfoManger", "have multiple bankcards!");
    if (!bo.isNullOrNil(paramArrayList))
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
          if ((!paramBoolean3) || (!((Bankcard)localObject2).cTj())) {
            break;
          }
          ab.i("MicroMsg.WalletUserInfoManger", "default card is honeypay");
          if ((paramBoolean1) && (this.tOD != null))
          {
            paramArrayList = this.tOD;
            AppMethodBeat.o(46995);
            return paramArrayList;
          }
          localObject2 = ((ArrayList)localObject1).iterator();
        }
        localBankcard = (Bankcard)((Iterator)localObject2).next();
      } while (localBankcard.cTj());
      AppMethodBeat.o(46995);
      return localBankcard;
      AppMethodBeat.o(46995);
      return localObject2;
    }
    if (paramBoolean2)
    {
      paramArrayList = (Bankcard)((ArrayList)localObject1).get(0);
      AppMethodBeat.o(46995);
      return paramArrayList;
    }
    AppMethodBeat.o(46995);
    return null;
  }
  
  private boolean cUL()
  {
    AppMethodBeat.i(46985);
    if (((this.ulP != null) && (this.ulP.cUb())) || ((this.tSY != null) && (this.tSY.size() > 0)))
    {
      AppMethodBeat.o(46985);
      return true;
    }
    AppMethodBeat.o(46985);
    return false;
  }
  
  private static String cUO()
  {
    AppMethodBeat.i(46991);
    g.RM();
    String str = (String)g.RL().Ru().get(196612, null);
    AppMethodBeat.o(46991);
    return str;
  }
  
  private void cUU()
  {
    AppMethodBeat.i(46999);
    ab.i("MicroMsg.WalletUserInfoManger", "recordDataState()");
    if (this.ulN == null) {
      ab.i("MicroMsg.WalletUserInfoManger", "userInfo == null");
    }
    if (this.tSX == null)
    {
      ab.i("MicroMsg.WalletUserInfoManger", "bankcards == null");
      if (this.tSY != null) {
        break label163;
      }
      ab.i("MicroMsg.WalletUserInfoManger", "virtualBankcards == null");
      label59:
      if (this.tOD != null) {
        break label215;
      }
      ab.i("MicroMsg.WalletUserInfoManger", "balance == null");
      label74:
      if (this.ulO != null) {
        break label226;
      }
      ab.i("MicroMsg.WalletUserInfoManger", "historyBankcard == null");
    }
    for (;;)
    {
      if (this.ulQ != null) {
        break label237;
      }
      ab.i("MicroMsg.WalletUserInfoManger", "mLoanEntryInfo == null");
      AppMethodBeat.o(46999);
      return;
      if (this.tSX.size() == 0)
      {
        ab.i("MicroMsg.WalletUserInfoManger", "bankcards.size() == 0");
        break;
      }
      ab.i("MicroMsg.WalletUserInfoManger", "bankcards.size() == " + this.tSX.size());
      break;
      label163:
      if (this.tSY.size() == 0)
      {
        ab.i("MicroMsg.WalletUserInfoManger", "virtualBankcards.size() == 0");
        break label59;
      }
      ab.i("MicroMsg.WalletUserInfoManger", "virtualBankcards.size() == " + this.tSY.size());
      break label59;
      label215:
      ab.i("MicroMsg.WalletUserInfoManger", "balance != null");
      break label74;
      label226:
      ab.i("MicroMsg.WalletUserInfoManger", "historyBankcard != null");
    }
    label237:
    ab.i("MicroMsg.WalletUserInfoManger", "mLoanEntryInfo != null");
    AppMethodBeat.o(46999);
  }
  
  public static Bankcard cUV()
  {
    AppMethodBeat.i(47001);
    Bankcard localBankcard = t.cTN().a(null, null, true, true);
    if (localBankcard == null) {
      ab.e("MicroMsg.WalletUserInfoManger", "defaultBankcards == null");
    }
    AppMethodBeat.o(47001);
    return localBankcard;
  }
  
  private static boolean dV(List<Bankcard> paramList)
  {
    AppMethodBeat.i(46987);
    if (paramList.size() == 0)
    {
      AppMethodBeat.o(46987);
      return false;
    }
    g.RM();
    Object localObject = (String)g.RL().Ru().get(196659, null);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      AppMethodBeat.o(46987);
      return true;
    }
    localObject = ((String)localObject).split("&");
    if ((localObject == null) || (localObject.length == 0))
    {
      AppMethodBeat.o(46987);
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
      AppMethodBeat.o(46987);
      return true;
    }
    AppMethodBeat.o(46987);
    return false;
  }
  
  public final void Kg()
  {
    AppMethodBeat.i(46975);
    if (this.ulN != null)
    {
      this.ulN.field_is_reg = -1;
      this.ulN = null;
    }
    if (this.ulP != null) {
      this.ulP = null;
    }
    if (this.tOD != null) {
      this.tOD = null;
    }
    if (this.tSX != null)
    {
      this.tSX.clear();
      this.tSX = null;
    }
    if (this.tSY != null)
    {
      this.tSY.clear();
      this.tSY = null;
    }
    this.ulV = 0L;
    com.tencent.mm.wallet_core.ui.e.a(new e.c[] { new e.c("wallet_balance_version", Integer.valueOf(-1)), new e.c("wallet_balance_last_update_time", Integer.valueOf(-1)), new e.c("wallet_balance", Integer.valueOf(-1)) });
    this.ulU = bo.aox();
    AppMethodBeat.o(46975);
  }
  
  @Deprecated
  public final Bankcard a(ArrayList<Bankcard> paramArrayList, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(46993);
    paramArrayList = a(paramArrayList, paramString, paramBoolean1, paramBoolean2, false);
    AppMethodBeat.o(46993);
    return paramArrayList;
  }
  
  public final Bankcard a(ArrayList<Bankcard> paramArrayList, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(46994);
    paramArrayList = b(paramArrayList, paramString, paramBoolean1, paramBoolean2, paramBoolean3);
    AppMethodBeat.o(46994);
    return paramArrayList;
  }
  
  public final void a(al paramal)
  {
    AppMethodBeat.i(46990);
    this.ulN = paramal;
    t.cTJ().aql();
    t.cTJ().b(paramal);
    AppMethodBeat.o(46990);
  }
  
  public final void a(al paramal, ArrayList<Bankcard> paramArrayList1, ArrayList<Bankcard> paramArrayList2, Bankcard paramBankcard1, Bankcard paramBankcard2, p paramp, c paramc, Bankcard paramBankcard3, int paramInt1, int paramInt2, List<e> paramList)
  {
    AppMethodBeat.i(46989);
    ab.i("MicroMsg.WalletUserInfoManger", "setBankcards scene %d", new Object[] { Integer.valueOf(paramInt2) });
    if (paramInt2 == 8) {
      this.ulL = paramArrayList1;
    }
    if ((paramInt2 == 24) || (paramInt2 == 25)) {
      this.ulM = paramArrayList1;
    }
    this.ulS = paramList;
    this.tSX = paramArrayList1;
    this.tSY = paramArrayList2;
    this.tOD = paramBankcard1;
    this.ulP = new ak(paramal.field_switchConfig, paramal.field_wallet_entrance_balance_switch_state);
    this.ulO = paramBankcard2;
    this.ulQ = paramp;
    this.ulR = paramc;
    this.ulT = paramBankcard3;
    ab.i("MicroMsg.WalletUserInfoManger", "setBankcards()! " + paramal.field_switchConfig);
    cUU();
    int i = paramInt1;
    if (paramInt1 < 0) {
      i = 600;
    }
    this.ulU = (bo.aox() + i);
    this.ulV = (bo.aox() + 600L);
    ab.i("MicroMsg.WalletUserInfoManger", "hy: cache time: %d, dead time: %d, cacheDeadTime: %s", new Object[] { Integer.valueOf(i), Long.valueOf(this.ulU), Long.valueOf(this.ulV) });
    t.cTL().aql();
    if ((paramInt2 != 24) && (paramInt2 != 25) && (paramArrayList1 != null)) {
      t.cTL().dY(paramArrayList1);
    }
    if (paramArrayList2 != null) {
      t.cTL().dY(paramArrayList2);
    }
    if (paramBankcard1 != null) {
      t.cTL().f(paramBankcard1);
    }
    if (paramBankcard2 != null) {
      t.cTL().f(paramBankcard2);
    }
    if (paramBankcard3 != null) {
      t.cTL().f(paramBankcard3);
    }
    a(paramal);
    t.cTP().aql();
    if (paramp != null) {
      t.cTP().insert(paramp);
    }
    AppMethodBeat.o(46989);
  }
  
  public final boolean afl(String paramString)
  {
    AppMethodBeat.i(46988);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(46988);
      return false;
    }
    Iterator localIterator;
    Bankcard localBankcard;
    if (this.tSX != null)
    {
      localIterator = this.tSX.iterator();
      while (localIterator.hasNext())
      {
        localBankcard = (Bankcard)localIterator.next();
        if ((paramString.equals(localBankcard.field_bankcardType)) && (localBankcard.cTe()))
        {
          AppMethodBeat.o(46988);
          return false;
        }
      }
    }
    if (this.tSY != null)
    {
      localIterator = this.tSY.iterator();
      while (localIterator.hasNext())
      {
        localBankcard = (Bankcard)localIterator.next();
        if ((paramString.equals(localBankcard.field_bankcardType)) && (localBankcard.field_bankcardState == 0))
        {
          AppMethodBeat.o(46988);
          return false;
        }
      }
    }
    AppMethodBeat.o(46988);
    return true;
  }
  
  public final boolean cUA()
  {
    AppMethodBeat.i(46974);
    if (ae.glG)
    {
      AppMethodBeat.o(46974);
      return true;
    }
    g.RM();
    int i = ((Integer)g.RL().Ru().get(ac.a.yHT, Integer.valueOf(-1))).intValue();
    if (i != -1)
    {
      if (i == 1)
      {
        AppMethodBeat.o(46974);
        return true;
      }
      AppMethodBeat.o(46974);
      return false;
    }
    if (this.ulN != null)
    {
      if (this.ulN.field_lqt_state == 1)
      {
        AppMethodBeat.o(46974);
        return true;
      }
      AppMethodBeat.o(46974);
      return false;
    }
    AppMethodBeat.o(46974);
    return false;
  }
  
  public final int cUB()
  {
    if (this.ulN != null) {
      return this.ulN.field_is_show_lqb;
    }
    return 0;
  }
  
  public final boolean cUC()
  {
    if (this.ulN != null) {
      return this.ulN.field_is_open_lqb == 1;
    }
    return false;
  }
  
  public final String cUD()
  {
    if (this.ulN != null) {
      return this.ulN.field_lqb_open_url;
    }
    return null;
  }
  
  public final boolean cUE()
  {
    if (this.ulN != null) {
      return this.ulN.field_paymenu_use_new == 1;
    }
    return false;
  }
  
  public final ArrayList<Bankcard> cUF()
  {
    AppMethodBeat.i(46976);
    if ((this.tSX == null) || (this.tSX.size() <= 0)) {
      this.tSX = t.cTL().cUF();
    }
    if ((this.tSX == null) || (this.tSX.size() <= 0))
    {
      AppMethodBeat.o(46976);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.tSX.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add((Bankcard)localIterator.next());
    }
    AppMethodBeat.o(46976);
    return localArrayList;
  }
  
  public final List<e> cUG()
  {
    AppMethodBeat.i(46977);
    if ((this.ulS == null) || (this.ulS.size() <= 0))
    {
      AppMethodBeat.o(46977);
      return null;
    }
    List localList = this.ulS;
    AppMethodBeat.o(46977);
    return localList;
  }
  
  public final ArrayList<Bankcard> cUH()
  {
    AppMethodBeat.i(46978);
    if ((this.tSX == null) || (this.tSX.size() <= 0))
    {
      AppMethodBeat.o(46978);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.tSX.iterator();
    while (localIterator.hasNext())
    {
      Bankcard localBankcard = (Bankcard)localIterator.next();
      if ((!localBankcard.cTh()) && (!localBankcard.cTj())) {
        localArrayList.add(localBankcard);
      }
    }
    AppMethodBeat.o(46978);
    return localArrayList;
  }
  
  public final ArrayList<Bankcard> cUI()
  {
    AppMethodBeat.i(46981);
    ArrayList localArrayList = new ArrayList();
    if ((this.tOD != null) && (!cUn())) {
      localArrayList.add(this.tOD);
    }
    if ((this.ulT != null) && (!cUn())) {
      localArrayList.add(this.ulT);
    }
    Iterator localIterator;
    if ((this.ulL != null) && (this.tSX != null) && (this.ulL.size() == this.tSX.size()) && (this.ulL.size() > 0)) {
      localIterator = this.ulL.iterator();
    }
    while (localIterator.hasNext())
    {
      localArrayList.add((Bankcard)localIterator.next());
      continue;
      if ((this.tSX != null) && (this.tSX.size() > 0))
      {
        localIterator = this.tSX.iterator();
        while (localIterator.hasNext()) {
          localArrayList.add((Bankcard)localIterator.next());
        }
      }
    }
    AppMethodBeat.o(46981);
    return localArrayList;
  }
  
  public final ArrayList<Bankcard> cUJ()
  {
    AppMethodBeat.i(46982);
    ArrayList localArrayList = new ArrayList();
    if ((this.tOD != null) && (!cUn())) {
      localArrayList.add(this.tOD);
    }
    if ((this.ulM != null) && (this.tSX != null) && (this.ulM.size() > 0))
    {
      Iterator localIterator = this.ulM.iterator();
      while (localIterator.hasNext())
      {
        Bankcard localBankcard = (Bankcard)localIterator.next();
        if (!localBankcard.cTj()) {
          localArrayList.add(localBankcard);
        }
      }
    }
    AppMethodBeat.o(46982);
    return localArrayList;
  }
  
  public final boolean cUK()
  {
    AppMethodBeat.i(46984);
    if (cUL())
    {
      AppMethodBeat.o(46984);
      return false;
    }
    if ((this.tSX != null) && (this.tSX.size() > 0))
    {
      AppMethodBeat.o(46984);
      return false;
    }
    AppMethodBeat.o(46984);
    return true;
  }
  
  public final boolean cUM()
  {
    AppMethodBeat.i(46986);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    f(localArrayList1, localArrayList2);
    if (dV(localArrayList2))
    {
      AppMethodBeat.o(46986);
      return true;
    }
    AppMethodBeat.o(46986);
    return false;
  }
  
  public final int cUN()
  {
    if (this.ulY > 0) {
      return this.ulY;
    }
    return 10000;
  }
  
  public final String cUP()
  {
    AppMethodBeat.i(46996);
    if ((this.tSX == null) || (this.tSX.size() <= 0))
    {
      ab.e("MicroMsg.WalletUserInfoManger", "not found bankcard!");
      AppMethodBeat.o(46996);
      return null;
    }
    Object localObject = this.tSX.iterator();
    if (((Iterator)localObject).hasNext())
    {
      localObject = ((Bankcard)((Iterator)localObject).next()).field_bindSerial;
      AppMethodBeat.o(46996);
      return localObject;
    }
    AppMethodBeat.o(46996);
    return null;
  }
  
  public final boolean cUQ()
  {
    AppMethodBeat.i(46998);
    long l = bo.gz(this.ulW);
    ab.d("MicroMsg.WalletUserInfoManger", "pass time ".concat(String.valueOf(l)));
    if (l > 300L)
    {
      AppMethodBeat.o(46998);
      return true;
    }
    AppMethodBeat.o(46998);
    return false;
  }
  
  public final int cUR()
  {
    if (this.ulN != null) {
      return this.ulN.field_lqt_cell_is_show;
    }
    return 0;
  }
  
  public final String cUS()
  {
    if (this.ulN != null) {
      return this.ulN.field_lqt_cell_lqt_title;
    }
    return null;
  }
  
  public final String cUT()
  {
    if (this.ulN != null) {
      return this.ulN.field_lqt_cell_lqt_wording;
    }
    return null;
  }
  
  public final boolean cUl()
  {
    AppMethodBeat.i(46966);
    if ((this.ulN != null) && (this.ulN.cUl()))
    {
      AppMethodBeat.o(46966);
      return true;
    }
    AppMethodBeat.o(46966);
    return false;
  }
  
  public final boolean cUm()
  {
    AppMethodBeat.i(46968);
    if ((this.ulN != null) && (this.ulN.cUm()))
    {
      AppMethodBeat.o(46968);
      return true;
    }
    AppMethodBeat.o(46968);
    return false;
  }
  
  public final boolean cUn()
  {
    AppMethodBeat.i(46967);
    if ((this.ulN != null) && (this.ulN.cUn()))
    {
      AppMethodBeat.o(46967);
      return true;
    }
    AppMethodBeat.o(46967);
    return false;
  }
  
  public final boolean cUp()
  {
    AppMethodBeat.i(46969);
    if ((this.ulN != null) && (this.ulN.cUp()))
    {
      AppMethodBeat.o(46969);
      return true;
    }
    AppMethodBeat.o(46969);
    return false;
  }
  
  public final boolean cUq()
  {
    AppMethodBeat.i(46965);
    if ((this.ulN == null) || ((this.ulN != null) && (this.ulN.cUo())))
    {
      AppMethodBeat.o(46965);
      return true;
    }
    AppMethodBeat.o(46965);
    return false;
  }
  
  public final int cUr()
  {
    if (this.ulN != null) {
      return this.ulN.field_soter_pay_open_type;
    }
    return 0;
  }
  
  public final String cUs()
  {
    if (this.ulN != null) {
      return this.ulN.field_ftf_pay_url;
    }
    return null;
  }
  
  public final ak cUt()
  {
    AppMethodBeat.i(46971);
    if (this.ulP == null)
    {
      localak = new ak();
      AppMethodBeat.o(46971);
      return localak;
    }
    ak localak = this.ulP;
    AppMethodBeat.o(46971);
    return localak;
  }
  
  public final boolean cUu()
  {
    return (this.ulN != null) && (this.ulN.field_isDomesticUser);
  }
  
  public final int cUv()
  {
    if (this.ulN != null) {
      return this.ulN.field_cre_type;
    }
    return 1;
  }
  
  public final String cUw()
  {
    AppMethodBeat.i(46972);
    g.RM();
    String str = (String)g.RL().Ru().get(ac.a.yHU, null);
    if (!bo.isNullOrNil(str))
    {
      AppMethodBeat.o(46972);
      return str;
    }
    if (this.ulN != null)
    {
      str = this.ulN.field_lct_wording;
      AppMethodBeat.o(46972);
      return str;
    }
    AppMethodBeat.o(46972);
    return null;
  }
  
  public final String cUx()
  {
    if (this.ulN != null) {
      return this.ulN.field_lct_url;
    }
    return null;
  }
  
  public final String cUy()
  {
    if (this.ulN != null) {
      return this.ulN.field_forget_passwd_url;
    }
    return "";
  }
  
  public final void cUz()
  {
    AppMethodBeat.i(46973);
    if (!g.RJ().QU())
    {
      ab.w("MicroMsg.WalletUserInfoManger", "Account Not Ready!");
      AppMethodBeat.o(46973);
      return;
    }
    this.ulN = t.cTJ().cVl();
    if (this.ulN != null) {
      this.ulP = new ak(this.ulN.field_switchConfig, this.ulN.field_wallet_entrance_balance_switch_state);
    }
    for (;;)
    {
      if (!bo.isNullOrNil(this.ulN.field_bank_priority)) {}
      try
      {
        this.ulS = ah.aJ(new JSONObject(this.ulN.field_bank_priority));
        this.tOD = t.cTL().cVg();
        this.ulT = t.cTL().cVh();
        com.tencent.mm.wallet_core.ui.e.a("wallet_balance", new am.1(this));
        this.tSX = t.cTL().cUF();
        this.tSY = t.cTL().cVi();
        this.ulO = t.cTL().cVj();
        this.ulQ = t.cTP().cVd();
        ab.i("MicroMsg.WalletUserInfoManger", "loadDbData!");
        cUU();
        AppMethodBeat.o(46973);
        return;
        this.ulP = new ak();
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.WalletUserInfoManger", localJSONException, "", new Object[0]);
        }
      }
    }
  }
  
  public final void f(ArrayList<Bankcard> paramArrayList1, ArrayList<Bankcard> paramArrayList2)
  {
    AppMethodBeat.i(46983);
    if ((this.tSX == null) || (paramArrayList1 == null) || (paramArrayList2 == null))
    {
      ab.e("MicroMsg.WalletUserInfoManger", "error list, bankcards == null || bankcardsClone == null || virtualBankcardsClone == null");
      AppMethodBeat.o(46983);
      return;
    }
    paramArrayList1.clear();
    paramArrayList2.clear();
    Iterator localIterator;
    if (this.tSX != null)
    {
      localIterator = this.tSX.iterator();
      while (localIterator.hasNext()) {
        paramArrayList1.add((Bankcard)localIterator.next());
      }
    }
    if (this.tSY != null)
    {
      localIterator = this.tSY.iterator();
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
    AppMethodBeat.o(46983);
  }
  
  public final String getTrueName()
  {
    if (this.ulN != null) {
      return this.ulN.field_true_name;
    }
    return null;
  }
  
  public final Bankcard i(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(46970);
    if ((paramBoolean1) && (this.tOD != null) && (this.tOD.field_bindSerial.equals(paramString)))
    {
      paramString = this.tOD;
      AppMethodBeat.o(46970);
      return paramString;
    }
    if ((paramBoolean2) && (this.ulT != null) && (this.ulT.field_bindSerial.equals(paramString)))
    {
      paramString = this.ulT;
      AppMethodBeat.o(46970);
      return paramString;
    }
    if ((this.tSX != null) && (!this.tSX.isEmpty()))
    {
      Iterator localIterator = this.tSX.iterator();
      while (localIterator.hasNext())
      {
        Bankcard localBankcard = (Bankcard)localIterator.next();
        if (localBankcard.field_bindSerial.equals(paramString))
        {
          AppMethodBeat.o(46970);
          return localBankcard;
        }
      }
    }
    AppMethodBeat.o(46970);
    return null;
  }
  
  public final ArrayList<Bankcard> nH(boolean paramBoolean)
  {
    AppMethodBeat.i(46979);
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean)
    {
      if ((this.tOD != null) && (!cUn())) {
        localArrayList.add(this.tOD);
      }
      if ((this.ulT != null) && (!cUn())) {
        localArrayList.add(this.ulT);
      }
    }
    if ((this.tSX != null) && (this.tSX.size() > 0))
    {
      Iterator localIterator = this.tSX.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add((Bankcard)localIterator.next());
      }
    }
    AppMethodBeat.o(46979);
    return localArrayList;
  }
  
  @Deprecated
  public final ArrayList<Bankcard> nI(boolean paramBoolean)
  {
    AppMethodBeat.i(156740);
    ArrayList localArrayList = nH(paramBoolean);
    AppMethodBeat.o(156740);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.am
 * JD-Core Version:    0.7.0.1
 */