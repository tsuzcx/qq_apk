package com.tencent.mm.plugin.wallet_core.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.wallet_core.d.a;
import com.tencent.mm.plugin.wallet_core.d.d;
import com.tencent.mm.plugin.wallet_core.d.k;
import com.tencent.mm.protocal.protobuf.ddt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.wallet_core.ui.g;
import com.tencent.mm.wallet_core.ui.g.b;
import com.tencent.mm.wallet_core.ui.g.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class ao
{
  private ArrayList<Bankcard> OTT;
  private ArrayList<Bankcard> OTU;
  private ArrayList<Bankcard> OTV;
  public an OTW;
  public Bankcard OTX;
  public am OTY;
  public n OTZ;
  public b OUa;
  private List<c> OUb;
  public Bankcard OUc;
  public ddt OUd;
  public long OUe;
  long OUf;
  public long OUg;
  private String OUh;
  public int OUi;
  public String OUj;
  public String OUk;
  public Bankcard OnP;
  int Ong;
  int Onh;
  private ArrayList<Bankcard> Ovb;
  private ArrayList<Bankcard> Ovc;
  public int mRetryCount;
  
  public ao()
  {
    AppMethodBeat.i(70494);
    this.OTT = new ArrayList();
    this.OTU = new ArrayList();
    this.OTV = new ArrayList();
    this.Ovb = new ArrayList();
    this.Ovc = new ArrayList();
    this.OTW = null;
    this.OTX = null;
    this.OnP = null;
    this.OTY = null;
    this.OTZ = null;
    this.OUa = null;
    this.OUb = new LinkedList();
    this.OUc = null;
    this.Ong = 0;
    this.Onh = 0;
    this.OUe = Util.nowSecond();
    this.OUf = 0L;
    this.OUg = -1L;
    this.OUh = "";
    this.OUi = 10000;
    this.mRetryCount = 0;
    this.OUj = "";
    this.OUk = "";
    gKe();
    AppMethodBeat.o(70494);
  }
  
  @Deprecated
  private Bankcard b(ArrayList<Bankcard> paramArrayList, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(70526);
    Object localObject1 = paramArrayList;
    if (paramArrayList == null) {
      localObject1 = this.Ovb;
    }
    paramArrayList = paramString;
    if (Util.isNullOrNil(paramString))
    {
      Log.i("MicroMsg.WalletUserInfoManger", "bindSerial is null ");
      paramArrayList = gKu();
    }
    Log.i("MicroMsg.WalletUserInfoManger", "getDefaultRecommendBankcard bindSerial:%s", new Object[] { paramArrayList });
    if ((paramBoolean1) && (this.OnP != null))
    {
      if (gJR())
      {
        paramArrayList = this.OnP;
        AppMethodBeat.o(70526);
        return paramArrayList;
      }
      if ((paramArrayList != null) && (paramArrayList.equals(this.OnP.field_bindSerial)))
      {
        paramArrayList = this.OnP;
        AppMethodBeat.o(70526);
        return paramArrayList;
      }
      if ((this.OUc != null) && (this.OTW != null) && (this.OTW.field_lqt_state == 1) && (paramArrayList != null) && (paramArrayList.equals(this.OUc.field_bindSerial)))
      {
        paramArrayList = this.OUc;
        AppMethodBeat.o(70526);
        return paramArrayList;
      }
      if ((!gJS()) && ((localObject1 == null) || (((ArrayList)localObject1).size() == 0)))
      {
        paramArrayList = this.OnP;
        AppMethodBeat.o(70526);
        return paramArrayList;
      }
    }
    if ((localObject1 == null) || (((ArrayList)localObject1).size() <= 0))
    {
      Log.e("MicroMsg.WalletUserInfoManger", "return not found bankcard!");
      AppMethodBeat.o(70526);
      return null;
    }
    if ((((ArrayList)localObject1).size() == 1) && (paramBoolean2))
    {
      Log.e("MicroMsg.WalletUserInfoManger", "return only one bankcard：%s", new Object[] { ((Bankcard)((ArrayList)localObject1).get(0)).field_bindSerial });
      paramArrayList = (Bankcard)((ArrayList)localObject1).get(0);
      AppMethodBeat.o(70526);
      return paramArrayList;
    }
    Log.i("MicroMsg.WalletUserInfoManger", "have multiple bankcards!");
    if (!Util.isNullOrNil(paramArrayList))
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
            Log.i("MicroMsg.WalletUserInfoManger", "bankcard serial ：%s，title :%s", new Object[] { ((Bankcard)localObject2).field_bindSerial, ((Bankcard)localObject2).field_forbid_title });
          } while ((localObject2 == null) || (!paramArrayList.equals(((Bankcard)localObject2).field_bindSerial)));
          if ((!paramBoolean3) || (!((Bankcard)localObject2).gIL())) {
            break;
          }
          Log.i("MicroMsg.WalletUserInfoManger", "default card is honeypay");
          if ((paramBoolean1) && (this.OnP != null))
          {
            Log.i("MicroMsg.WalletUserInfoManger", "return balance");
            paramArrayList = this.OnP;
            AppMethodBeat.o(70526);
            return paramArrayList;
          }
          localObject2 = ((ArrayList)localObject1).iterator();
        }
        localBankcard = (Bankcard)((Iterator)localObject2).next();
      } while (localBankcard.gIL());
      Log.i("MicroMsg.WalletUserInfoManger", "return bankcard1:%s", new Object[] { localBankcard.field_bindSerial });
      AppMethodBeat.o(70526);
      return localBankcard;
      Log.i("MicroMsg.WalletUserInfoManger", "return bankcard:%s", new Object[] { ((Bankcard)localObject2).field_bindSerial });
      AppMethodBeat.o(70526);
      return localObject2;
    }
    if (paramBoolean2)
    {
      Log.i("MicroMsg.WalletUserInfoManger", "return bankcardList.get(0):%s", new Object[] { ((Bankcard)((ArrayList)localObject1).get(0)).field_bindSerial });
      paramArrayList = (Bankcard)((ArrayList)localObject1).get(0);
      AppMethodBeat.o(70526);
      return paramArrayList;
    }
    AppMethodBeat.o(70526);
    return null;
  }
  
  public static void bgX(String paramString)
  {
    AppMethodBeat.i(70523);
    if (!Util.isNullOrNil(paramString))
    {
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHG().aHp().i(196612, paramString);
    }
    AppMethodBeat.o(70523);
  }
  
  private static void bgY(String paramString)
  {
    AppMethodBeat.i(70528);
    if (paramString != null)
    {
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHG().aHp().i(196633, paramString);
    }
    AppMethodBeat.o(70528);
  }
  
  public static void bgZ(String paramString)
  {
    AppMethodBeat.i(70532);
    Log.i("MicroMsg.WalletUserInfoManger", "setSelectBindSerial %s %s", new Object[] { paramString, Util.getStack().toString() });
    bgY(paramString);
    AppMethodBeat.o(70532);
  }
  
  private void gKB()
  {
    AppMethodBeat.i(70531);
    Log.i("MicroMsg.WalletUserInfoManger", "recordDataState()");
    if (this.OTW == null) {
      Log.i("MicroMsg.WalletUserInfoManger", "userInfo == null");
    }
    if (this.Ovb == null)
    {
      Log.i("MicroMsg.WalletUserInfoManger", "bankcards == null");
      if (this.Ovc != null) {
        break label163;
      }
      Log.i("MicroMsg.WalletUserInfoManger", "virtualBankcards == null");
      label59:
      if (this.OnP != null) {
        break label215;
      }
      Log.i("MicroMsg.WalletUserInfoManger", "balance == null");
      label74:
      if (this.OTX != null) {
        break label226;
      }
      Log.i("MicroMsg.WalletUserInfoManger", "historyBankcard == null");
    }
    for (;;)
    {
      if (this.OTZ != null) {
        break label237;
      }
      Log.i("MicroMsg.WalletUserInfoManger", "mLoanEntryInfo == null");
      AppMethodBeat.o(70531);
      return;
      if (this.Ovb.size() == 0)
      {
        Log.i("MicroMsg.WalletUserInfoManger", "bankcards.size() == 0");
        break;
      }
      Log.i("MicroMsg.WalletUserInfoManger", "bankcards.size() == " + this.Ovb.size());
      break;
      label163:
      if (this.Ovc.size() == 0)
      {
        Log.i("MicroMsg.WalletUserInfoManger", "virtualBankcards.size() == 0");
        break label59;
      }
      Log.i("MicroMsg.WalletUserInfoManger", "virtualBankcards.size() == " + this.Ovc.size());
      break label59;
      label215:
      Log.i("MicroMsg.WalletUserInfoManger", "balance != null");
      break label74;
      label226:
      Log.i("MicroMsg.WalletUserInfoManger", "historyBankcard != null");
    }
    label237:
    Log.i("MicroMsg.WalletUserInfoManger", "mLoanEntryInfo != null");
    AppMethodBeat.o(70531);
  }
  
  public static Bankcard gKC()
  {
    AppMethodBeat.i(70533);
    Bankcard localBankcard = u.gJo().a(null, null, true, true);
    if (localBankcard == null) {
      Log.e("MicroMsg.WalletUserInfoManger", "defaultBankcards == null");
    }
    AppMethodBeat.o(70533);
    return localBankcard;
  }
  
  private boolean gKr()
  {
    AppMethodBeat.i(70515);
    if (((this.OTY != null) && (this.OTY.gJE())) || ((this.Ovc != null) && (this.Ovc.size() > 0)))
    {
      AppMethodBeat.o(70515);
      return true;
    }
    AppMethodBeat.o(70515);
    return false;
  }
  
  private static String gKu()
  {
    AppMethodBeat.i(70522);
    com.tencent.mm.kernel.h.aHH();
    String str = (String)com.tencent.mm.kernel.h.aHG().aHp().b(196612, null);
    AppMethodBeat.o(70522);
    return str;
  }
  
  public static String gKw()
  {
    AppMethodBeat.i(70529);
    com.tencent.mm.kernel.h.aHH();
    String str = (String)com.tencent.mm.kernel.h.aHG().aHp().b(196633, null);
    AppMethodBeat.o(70529);
    return str;
  }
  
  private static boolean iO(List<Bankcard> paramList)
  {
    AppMethodBeat.i(70517);
    if (paramList.size() == 0)
    {
      AppMethodBeat.o(70517);
      return false;
    }
    com.tencent.mm.kernel.h.aHH();
    Object localObject = (String)com.tencent.mm.kernel.h.aHG().aHp().b(196659, null);
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
  
  public final ArrayList<Bankcard> Ce(boolean paramBoolean)
  {
    AppMethodBeat.i(70509);
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean)
    {
      if ((this.OnP != null) && (!gJS())) {
        localArrayList.add(this.OnP);
      }
      if ((this.OUc != null) && (!gJS())) {
        localArrayList.add(this.OUc);
      }
    }
    if ((this.Ovb != null) && (this.Ovb.size() > 0))
    {
      Iterator localIterator = this.Ovb.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add((Bankcard)localIterator.next());
      }
    }
    AppMethodBeat.o(70509);
    return localArrayList;
  }
  
  @Deprecated
  public final ArrayList<Bankcard> Cf(boolean paramBoolean)
  {
    AppMethodBeat.i(293269);
    ArrayList localArrayList = Ce(paramBoolean);
    AppMethodBeat.o(293269);
    return localArrayList;
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
  
  public final void a(an paraman)
  {
    AppMethodBeat.i(70521);
    this.OTW = paraman;
    u.gJj().byd();
    u.gJj().b(paraman);
    AppMethodBeat.o(70521);
  }
  
  public final void a(an paraman, ArrayList<Bankcard> paramArrayList1, ArrayList<Bankcard> paramArrayList2, Bankcard paramBankcard1, Bankcard paramBankcard2, n paramn, b paramb, Bankcard paramBankcard3, int paramInt1, int paramInt2, List<c> paramList)
  {
    AppMethodBeat.i(70520);
    Log.i("MicroMsg.WalletUserInfoManger", "setBankcards scene %d", new Object[] { Integer.valueOf(paramInt2) });
    if (paramInt2 == 8)
    {
      this.OTT = paramArrayList1;
      this.OUb = paramList;
    }
    if ((paramInt2 == 24) || (paramInt2 == 25)) {
      this.OTU = paramArrayList1;
    }
    if (paramInt2 == 12) {
      this.OTV = paramArrayList1;
    }
    this.Ovb = paramArrayList1;
    this.Ovc = paramArrayList2;
    this.OnP = paramBankcard1;
    this.OTY = new am(paraman.field_switchConfig, paraman.field_wallet_entrance_balance_switch_state);
    this.OTX = paramBankcard2;
    this.OTZ = paramn;
    this.OUa = paramb;
    this.OUc = paramBankcard3;
    Log.i("MicroMsg.WalletUserInfoManger", "setBankcards()! " + paraman.field_switchConfig);
    gKB();
    int i = paramInt1;
    if (paramInt1 < 0) {
      i = 600;
    }
    this.OUe = (Util.nowSecond() + i);
    this.OUf = (Util.nowSecond() + 600L);
    Log.i("MicroMsg.WalletUserInfoManger", "hy: cache time: %d, dead time: %d, cacheDeadTime: %s", new Object[] { Integer.valueOf(i), Long.valueOf(this.OUe), Long.valueOf(this.OUf) });
    com.tencent.mm.plugin.wallet_core.utils.h.amL(paramInt2);
    if ((paramInt2 != 24) && (paramInt2 != 25) && (paramArrayList1 != null)) {
      com.tencent.mm.plugin.wallet_core.utils.h.F(paramArrayList1, paramInt2);
    }
    if (paramArrayList2 != null) {
      com.tencent.mm.plugin.wallet_core.utils.h.F(paramArrayList2, paramInt2);
    }
    if (paramBankcard1 != null) {
      com.tencent.mm.plugin.wallet_core.utils.h.a(paramBankcard1, paramInt2);
    }
    if (paramBankcard2 != null) {
      com.tencent.mm.plugin.wallet_core.utils.h.a(paramBankcard2, paramInt2);
    }
    if (paramBankcard3 != null) {
      com.tencent.mm.plugin.wallet_core.utils.h.a(paramBankcard3, paramInt2);
    }
    a(paraman);
    u.gJq().byd();
    if (paramn != null) {
      u.gJq().insert(paramn);
    }
    AppMethodBeat.o(70520);
  }
  
  public final void ate()
  {
    AppMethodBeat.i(70505);
    if (this.OTW != null)
    {
      this.OTW.field_is_reg = -1;
      this.OTW = null;
    }
    if (this.OTY != null) {
      this.OTY = null;
    }
    if (this.OnP != null) {
      this.OnP = null;
    }
    if (this.Ovb != null)
    {
      this.Ovb.clear();
      this.Ovb = null;
    }
    if (this.Ovc != null)
    {
      this.Ovc.clear();
      this.Ovc = null;
    }
    if (this.OUd != null) {
      this.OUd = null;
    }
    this.OUf = 0L;
    g.a(new g.c[] { new g.c("wallet_balance_version", Integer.valueOf(-1)), new g.c("wallet_balance_last_update_time", Integer.valueOf(-1)), new g.c("wallet_balance", Integer.valueOf(-1)) });
    this.OUe = Util.nowSecond();
    AppMethodBeat.o(70505);
  }
  
  public final Bankcard bgV(String paramString)
  {
    AppMethodBeat.i(268149);
    if ((this.Ovb != null) && (!this.Ovb.isEmpty()))
    {
      Iterator localIterator = this.Ovb.iterator();
      while (localIterator.hasNext())
      {
        Bankcard localBankcard = (Bankcard)localIterator.next();
        if (localBankcard.field_bindSerial.equals(paramString))
        {
          AppMethodBeat.o(268149);
          return localBankcard;
        }
      }
    }
    AppMethodBeat.o(268149);
    return null;
  }
  
  public final boolean bgW(String paramString)
  {
    AppMethodBeat.i(70518);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(70518);
      return false;
    }
    Iterator localIterator;
    Bankcard localBankcard;
    if (this.Ovb != null)
    {
      localIterator = this.Ovb.iterator();
      while (localIterator.hasNext())
      {
        localBankcard = (Bankcard)localIterator.next();
        if ((paramString.equals(localBankcard.field_bankcardType)) && (localBankcard.gIG()))
        {
          AppMethodBeat.o(70518);
          return false;
        }
      }
    }
    if (this.Ovc != null)
    {
      localIterator = this.Ovc.iterator();
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
  
  public final void c(ddt paramddt)
  {
    AppMethodBeat.i(70519);
    this.OUd = paramddt;
    aj.a(paramddt);
    AppMethodBeat.o(70519);
  }
  
  public final boolean gJQ()
  {
    AppMethodBeat.i(70496);
    if ((this.OTW != null) && (this.OTW.gJQ()))
    {
      AppMethodBeat.o(70496);
      return true;
    }
    AppMethodBeat.o(70496);
    return false;
  }
  
  public final boolean gJR()
  {
    AppMethodBeat.i(70498);
    if ((this.OTW != null) && (this.OTW.gJR()))
    {
      AppMethodBeat.o(70498);
      return true;
    }
    AppMethodBeat.o(70498);
    return false;
  }
  
  public final boolean gJS()
  {
    AppMethodBeat.i(70497);
    if ((this.OTW != null) && (this.OTW.gJS()))
    {
      AppMethodBeat.o(70497);
      return true;
    }
    AppMethodBeat.o(70497);
    return false;
  }
  
  public final boolean gJU()
  {
    AppMethodBeat.i(70499);
    if ((this.OTW != null) && (this.OTW.gJU()))
    {
      AppMethodBeat.o(70499);
      return true;
    }
    AppMethodBeat.o(70499);
    return false;
  }
  
  public final boolean gJV()
  {
    AppMethodBeat.i(70495);
    if ((this.OTW == null) || ((this.OTW != null) && (this.OTW.gJT())))
    {
      AppMethodBeat.o(70495);
      return true;
    }
    AppMethodBeat.o(70495);
    return false;
  }
  
  public final int gJW()
  {
    if (this.OTW != null) {
      return this.OTW.field_soter_pay_open_type;
    }
    return 0;
  }
  
  public final String gJX()
  {
    if (this.OTW != null) {
      return this.OTW.field_ftf_pay_url;
    }
    return null;
  }
  
  public final am gJY()
  {
    AppMethodBeat.i(70501);
    if (this.OTY == null)
    {
      localam = new am();
      AppMethodBeat.o(70501);
      return localam;
    }
    am localam = this.OTY;
    AppMethodBeat.o(70501);
    return localam;
  }
  
  public final boolean gJZ()
  {
    return (this.OTW != null) && (this.OTW.field_isDomesticUser);
  }
  
  public final String gKA()
  {
    if (this.OTW != null) {
      return this.OTW.field_lqt_cell_lqt_wording;
    }
    return null;
  }
  
  public final int gKa()
  {
    if (this.OTW != null) {
      return this.OTW.field_cre_type;
    }
    return 1;
  }
  
  public final String gKb()
  {
    AppMethodBeat.i(70502);
    com.tencent.mm.kernel.h.aHH();
    String str = (String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vsd, null);
    if (!Util.isNullOrNil(str))
    {
      AppMethodBeat.o(70502);
      return str;
    }
    if (this.OTW != null)
    {
      str = this.OTW.field_lct_wording;
      AppMethodBeat.o(70502);
      return str;
    }
    AppMethodBeat.o(70502);
    return null;
  }
  
  public final String gKc()
  {
    if (this.OTW != null) {
      return this.OTW.field_lct_url;
    }
    return null;
  }
  
  public final String gKd()
  {
    if (this.OTW != null) {
      return this.OTW.field_forget_passwd_url;
    }
    return "";
  }
  
  public final void gKe()
  {
    AppMethodBeat.i(70503);
    if (!com.tencent.mm.kernel.h.aHE().aGM())
    {
      Log.w("MicroMsg.WalletUserInfoManger", "Account Not Ready!");
      AppMethodBeat.o(70503);
      return;
    }
    this.OTW = u.gJj().gKZ();
    if (this.OTW != null) {
      this.OTY = new am(this.OTW.field_switchConfig, this.OTW.field_wallet_entrance_balance_switch_state);
    }
    for (;;)
    {
      if (!Util.isNullOrNil(this.OTW.field_bank_priority)) {}
      try
      {
        this.OUb = aj.cb(new JSONObject(this.OTW.field_bank_priority));
        this.OnP = u.gJl().gKT();
        this.OUc = u.gJl().gKU();
        g.a("wallet_balance", new g.b()
        {
          public final void dB(Object paramAnonymousObject)
          {
            AppMethodBeat.i(70493);
            if ((paramAnonymousObject != null) && ((paramAnonymousObject instanceof Double)))
            {
              if (((Double)paramAnonymousObject).doubleValue() < 0.0D) {
                Log.v("MicroMsg.WalletUserInfoManger", "val is zero %s", new Object[] { Util.getStack().toString() });
              }
              if (ao.this.OnP != null)
              {
                ao.this.OnP.OND = ((Double)paramAnonymousObject).doubleValue();
                AppMethodBeat.o(70493);
              }
            }
            else
            {
              Log.i("MicroMsg.WalletUserInfoManger", "hy: no balance info. set to negative");
              if (ao.this.OnP != null) {
                ao.this.OnP.OND = -1.0D;
              }
            }
            AppMethodBeat.o(70493);
          }
        });
        this.Ovb = u.gJl().gKk();
        this.OTT = com.tencent.mm.plugin.wallet_core.utils.h.amM(8);
        this.OTV = com.tencent.mm.plugin.wallet_core.utils.h.amM(12);
        this.Ovc = u.gJl().gKV();
        this.OTX = u.gJl().gKW();
        this.OTZ = u.gJq().gKR();
        Log.i("MicroMsg.WalletUserInfoManger", "loadDbData!");
        gKB();
        this.OUd = aj.gJB();
        AppMethodBeat.o(70503);
        return;
        this.OTY = new am();
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.WalletUserInfoManger", localJSONException, "", new Object[0]);
        }
      }
    }
  }
  
  public final boolean gKf()
  {
    AppMethodBeat.i(70504);
    if (ac.mGN)
    {
      AppMethodBeat.o(70504);
      return true;
    }
    com.tencent.mm.kernel.h.aHH();
    int i = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vsc, Integer.valueOf(-1))).intValue();
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
    if (this.OTW != null)
    {
      if (this.OTW.field_lqt_state == 1)
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
  
  public final int gKg()
  {
    if (this.OTW != null) {
      return this.OTW.field_is_show_lqb;
    }
    return 0;
  }
  
  public final boolean gKh()
  {
    if (this.OTW != null) {
      return this.OTW.field_is_open_lqb == 1;
    }
    return false;
  }
  
  public final String gKi()
  {
    if (this.OTW != null) {
      return this.OTW.field_lqb_open_url;
    }
    return null;
  }
  
  public final boolean gKj()
  {
    if (this.OTW != null) {
      return this.OTW.field_paymenu_use_new == 1;
    }
    return false;
  }
  
  public final ArrayList<Bankcard> gKk()
  {
    AppMethodBeat.i(70506);
    if ((this.Ovb == null) || (this.Ovb.size() <= 0)) {
      this.Ovb = u.gJl().gKk();
    }
    if ((this.Ovb == null) || (this.Ovb.size() <= 0))
    {
      AppMethodBeat.o(70506);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.Ovb.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add((Bankcard)localIterator.next());
    }
    AppMethodBeat.o(70506);
    return localArrayList;
  }
  
  public final List<c> gKl()
  {
    AppMethodBeat.i(70507);
    if ((this.OUb == null) || (this.OUb.size() <= 0))
    {
      AppMethodBeat.o(70507);
      return null;
    }
    List localList = this.OUb;
    AppMethodBeat.o(70507);
    return localList;
  }
  
  public final ArrayList<Bankcard> gKm()
  {
    AppMethodBeat.i(70508);
    if ((this.Ovb == null) || (this.Ovb.size() <= 0))
    {
      AppMethodBeat.o(70508);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.Ovb.iterator();
    while (localIterator.hasNext())
    {
      Bankcard localBankcard = (Bankcard)localIterator.next();
      if ((!localBankcard.gIJ()) && (!localBankcard.gIL())) {
        localArrayList.add(localBankcard);
      }
    }
    AppMethodBeat.o(70508);
    return localArrayList;
  }
  
  public final ArrayList<Bankcard> gKn()
  {
    AppMethodBeat.i(268159);
    if (this.OTT == null)
    {
      AppMethodBeat.o(268159);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    if ((this.OnP != null) && (!gJS())) {
      localArrayList.add(this.OnP);
    }
    if ((this.OUc != null) && (!gJS())) {
      localArrayList.add(this.OUc);
    }
    if (this.OTT.size() > 0)
    {
      Iterator localIterator = this.OTT.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add((Bankcard)localIterator.next());
      }
    }
    AppMethodBeat.o(268159);
    return localArrayList;
  }
  
  public final ArrayList<Bankcard> gKo()
  {
    AppMethodBeat.i(70511);
    ArrayList localArrayList = new ArrayList();
    if ((this.OnP != null) && (!gJS())) {
      localArrayList.add(this.OnP);
    }
    if ((this.OUc != null) && (!gJS())) {
      localArrayList.add(this.OUc);
    }
    Iterator localIterator;
    if ((this.OTT != null) && (this.OTT.size() > 0)) {
      localIterator = this.OTT.iterator();
    }
    while (localIterator.hasNext())
    {
      localArrayList.add((Bankcard)localIterator.next());
      continue;
      if ((this.Ovb != null) && (this.Ovb.size() > 0))
      {
        localIterator = this.Ovb.iterator();
        while (localIterator.hasNext()) {
          localArrayList.add((Bankcard)localIterator.next());
        }
      }
    }
    AppMethodBeat.o(70511);
    return localArrayList;
  }
  
  public final ArrayList<Bankcard> gKp()
  {
    AppMethodBeat.i(70512);
    ArrayList localArrayList = new ArrayList();
    if ((this.OnP != null) && (!gJS())) {
      localArrayList.add(this.OnP);
    }
    if ((this.OTU != null) && (this.Ovb != null) && (this.OTU.size() > 0))
    {
      Iterator localIterator = this.OTU.iterator();
      while (localIterator.hasNext())
      {
        Bankcard localBankcard = (Bankcard)localIterator.next();
        if (!localBankcard.gIL()) {
          localArrayList.add(localBankcard);
        }
      }
    }
    AppMethodBeat.o(70512);
    return localArrayList;
  }
  
  public final boolean gKq()
  {
    AppMethodBeat.i(70514);
    if (gKr())
    {
      AppMethodBeat.o(70514);
      return false;
    }
    if ((this.Ovb != null) && (this.Ovb.size() > 0))
    {
      AppMethodBeat.o(70514);
      return false;
    }
    AppMethodBeat.o(70514);
    return true;
  }
  
  public final boolean gKs()
  {
    AppMethodBeat.i(70516);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    i(localArrayList1, localArrayList2);
    if (iO(localArrayList2))
    {
      AppMethodBeat.o(70516);
      return true;
    }
    AppMethodBeat.o(70516);
    return false;
  }
  
  public final int gKt()
  {
    if (this.OUi > 0) {
      return this.OUi;
    }
    return 10000;
  }
  
  public final String gKv()
  {
    AppMethodBeat.i(70527);
    if ((this.Ovb == null) || (this.Ovb.size() <= 0))
    {
      Log.e("MicroMsg.WalletUserInfoManger", "not found bankcard!");
      AppMethodBeat.o(70527);
      return null;
    }
    Object localObject = this.Ovb.iterator();
    if (((Iterator)localObject).hasNext())
    {
      localObject = ((Bankcard)((Iterator)localObject).next()).field_bindSerial;
      AppMethodBeat.o(70527);
      return localObject;
    }
    AppMethodBeat.o(70527);
    return null;
  }
  
  public final boolean gKx()
  {
    AppMethodBeat.i(70530);
    long l = Util.secondsToNow(this.OUg);
    Log.d("MicroMsg.WalletUserInfoManger", "pass time ".concat(String.valueOf(l)));
    if (l > 300L)
    {
      AppMethodBeat.o(70530);
      return true;
    }
    AppMethodBeat.o(70530);
    return false;
  }
  
  public final int gKy()
  {
    if (this.OTW != null) {
      return this.OTW.field_lqt_cell_is_show;
    }
    return 0;
  }
  
  public final String gKz()
  {
    if (this.OTW != null) {
      return this.OTW.field_lqt_cell_lqt_title;
    }
    return null;
  }
  
  public final String getTrueName()
  {
    if (this.OTW != null) {
      return this.OTW.field_true_name;
    }
    return null;
  }
  
  public final void i(ArrayList<Bankcard> paramArrayList1, ArrayList<Bankcard> paramArrayList2)
  {
    AppMethodBeat.i(70513);
    if ((paramArrayList1 == null) || (paramArrayList2 == null))
    {
      Log.e("MicroMsg.WalletUserInfoManger", "error list,bankcardsClone == null || virtualBankcardsClone == null");
      AppMethodBeat.o(70513);
      return;
    }
    if ((this.OTV == null) && (this.Ovb != null))
    {
      Log.e("MicroMsg.WalletUserInfoManger", "listManageUIbankcards == null && bankcards != null");
      this.OTV = this.Ovb;
    }
    if (this.OTV == null)
    {
      Log.e("MicroMsg.WalletUserInfoManger", "error list, listManageUIbankcards == null");
      AppMethodBeat.o(70513);
      return;
    }
    paramArrayList1.clear();
    paramArrayList2.clear();
    Iterator localIterator;
    if (this.OTV != null)
    {
      localIterator = this.OTV.iterator();
      while (localIterator.hasNext()) {
        paramArrayList1.add((Bankcard)localIterator.next());
      }
    }
    if (this.Ovc != null)
    {
      localIterator = this.Ovc.iterator();
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
  
  public final Bankcard l(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(268151);
    if ((paramBoolean1) && (this.OnP != null) && (this.OnP.field_bindSerial.equals(paramString)))
    {
      paramString = this.OnP;
      AppMethodBeat.o(268151);
      return paramString;
    }
    if ((paramBoolean2) && (this.OUc != null) && (this.OUc.field_bindSerial.equals(paramString)))
    {
      paramString = this.OUc;
      AppMethodBeat.o(268151);
      return paramString;
    }
    Log.i("MicroMsg.WalletUserInfoManger", "need get bankcard is ：%s ", new Object[] { paramString });
    Iterator localIterator;
    Bankcard localBankcard;
    if ((this.OTT != null) && (!this.OTT.isEmpty()))
    {
      localIterator = this.OTT.iterator();
      while (localIterator.hasNext())
      {
        localBankcard = (Bankcard)localIterator.next();
        Log.i("MicroMsg.WalletUserInfoManger", "compared offline offlinebankcards:%s", new Object[] { localBankcard.field_bindSerial });
        if (localBankcard.field_bindSerial.equals(paramString))
        {
          AppMethodBeat.o(268151);
          return localBankcard;
        }
      }
    }
    if ((this.Ovb != null) && (!this.Ovb.isEmpty()))
    {
      localIterator = this.Ovb.iterator();
      while (localIterator.hasNext())
      {
        localBankcard = (Bankcard)localIterator.next();
        Log.i("MicroMsg.WalletUserInfoManger", "compared bankcards:%s", new Object[] { localBankcard.field_bindSerial });
        if (localBankcard.field_bindSerial.equals(paramString))
        {
          AppMethodBeat.o(268151);
          return localBankcard;
        }
      }
    }
    AppMethodBeat.o(268151);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.ao
 * JD-Core Version:    0.7.0.1
 */