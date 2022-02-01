package com.tencent.mm.plugin.wallet_core.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.wallet_core.d.k;
import com.tencent.mm.protocal.protobuf.cul;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
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
  private ArrayList<Bankcard> HDi;
  private ArrayList<Bankcard> HDj;
  int Hvt;
  int Hvu;
  public Bankcard Hwc;
  private ArrayList<Bankcard> IbH;
  private ArrayList<Bankcard> IbI;
  private ArrayList<Bankcard> IbJ;
  public am IbK;
  public Bankcard IbL;
  public al IbM;
  public n IbN;
  public b IbO;
  private List<c> IbP;
  public Bankcard IbQ;
  public cul IbR;
  public long IbS;
  long IbT;
  public long IbU;
  private String IbV;
  public int IbW;
  public String IbX;
  public String IbY;
  public int mRetryCount;
  
  public an()
  {
    AppMethodBeat.i(70494);
    this.IbH = new ArrayList();
    this.IbI = new ArrayList();
    this.IbJ = new ArrayList();
    this.HDi = new ArrayList();
    this.HDj = new ArrayList();
    this.IbK = null;
    this.IbL = null;
    this.Hwc = null;
    this.IbM = null;
    this.IbN = null;
    this.IbO = null;
    this.IbP = new LinkedList();
    this.IbQ = null;
    this.Hvt = 0;
    this.Hvu = 0;
    this.IbS = Util.nowSecond();
    this.IbT = 0L;
    this.IbU = -1L;
    this.IbV = "";
    this.IbW = 10000;
    this.mRetryCount = 0;
    this.IbX = "";
    this.IbY = "";
    fRy();
    AppMethodBeat.o(70494);
  }
  
  public static void aVo(String paramString)
  {
    AppMethodBeat.i(70523);
    if (!Util.isNullOrNil(paramString))
    {
      g.aAi();
      g.aAh().azQ().set(196612, paramString);
    }
    AppMethodBeat.o(70523);
  }
  
  private static void aVp(String paramString)
  {
    AppMethodBeat.i(70528);
    if (paramString != null)
    {
      g.aAi();
      g.aAh().azQ().set(196633, paramString);
    }
    AppMethodBeat.o(70528);
  }
  
  public static void aVq(String paramString)
  {
    AppMethodBeat.i(70532);
    Log.i("MicroMsg.WalletUserInfoManger", "setSelectBindSerial %s %s", new Object[] { paramString, Util.getStack().toString() });
    aVp(paramString);
    AppMethodBeat.o(70532);
  }
  
  @Deprecated
  private Bankcard b(ArrayList<Bankcard> paramArrayList, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(70526);
    Object localObject1 = paramArrayList;
    if (paramArrayList == null) {
      localObject1 = this.HDi;
    }
    paramArrayList = paramString;
    if (Util.isNullOrNil(paramString))
    {
      Log.i("MicroMsg.WalletUserInfoManger", "bindSerial is null ");
      paramArrayList = fRP();
    }
    Log.i("MicroMsg.WalletUserInfoManger", "getDefaultRecommendBankcard bindSerial:%s", new Object[] { paramArrayList });
    if ((paramBoolean1) && (this.Hwc != null))
    {
      if (fRl())
      {
        paramArrayList = this.Hwc;
        AppMethodBeat.o(70526);
        return paramArrayList;
      }
      if ((paramArrayList != null) && (paramArrayList.equals(this.Hwc.field_bindSerial)))
      {
        paramArrayList = this.Hwc;
        AppMethodBeat.o(70526);
        return paramArrayList;
      }
      if ((this.IbQ != null) && (this.IbK != null) && (this.IbK.field_lqt_state == 1) && (paramArrayList != null) && (paramArrayList.equals(this.IbQ.field_bindSerial)))
      {
        paramArrayList = this.IbQ;
        AppMethodBeat.o(70526);
        return paramArrayList;
      }
      if ((!fRm()) && ((localObject1 == null) || (((ArrayList)localObject1).size() == 0)))
      {
        paramArrayList = this.Hwc;
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
          if ((!paramBoolean3) || (!((Bankcard)localObject2).fQf())) {
            break;
          }
          Log.i("MicroMsg.WalletUserInfoManger", "default card is honeypay");
          if ((paramBoolean1) && (this.Hwc != null))
          {
            Log.i("MicroMsg.WalletUserInfoManger", "return balance");
            paramArrayList = this.Hwc;
            AppMethodBeat.o(70526);
            return paramArrayList;
          }
          localObject2 = ((ArrayList)localObject1).iterator();
        }
        localBankcard = (Bankcard)((Iterator)localObject2).next();
      } while (localBankcard.fQf());
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
  
  private boolean fRL()
  {
    AppMethodBeat.i(70515);
    if (((this.IbM != null) && (this.IbM.fQY())) || ((this.HDj != null) && (this.HDj.size() > 0)))
    {
      AppMethodBeat.o(70515);
      return true;
    }
    AppMethodBeat.o(70515);
    return false;
  }
  
  private static String fRP()
  {
    AppMethodBeat.i(70522);
    g.aAi();
    String str = (String)g.aAh().azQ().get(196612, null);
    AppMethodBeat.o(70522);
    return str;
  }
  
  public static String fRR()
  {
    AppMethodBeat.i(70529);
    g.aAi();
    String str = (String)g.aAh().azQ().get(196633, null);
    AppMethodBeat.o(70529);
    return str;
  }
  
  private void fRW()
  {
    AppMethodBeat.i(70531);
    Log.i("MicroMsg.WalletUserInfoManger", "recordDataState()");
    if (this.IbK == null) {
      Log.i("MicroMsg.WalletUserInfoManger", "userInfo == null");
    }
    if (this.HDi == null)
    {
      Log.i("MicroMsg.WalletUserInfoManger", "bankcards == null");
      if (this.HDj != null) {
        break label163;
      }
      Log.i("MicroMsg.WalletUserInfoManger", "virtualBankcards == null");
      label59:
      if (this.Hwc != null) {
        break label215;
      }
      Log.i("MicroMsg.WalletUserInfoManger", "balance == null");
      label74:
      if (this.IbL != null) {
        break label226;
      }
      Log.i("MicroMsg.WalletUserInfoManger", "historyBankcard == null");
    }
    for (;;)
    {
      if (this.IbN != null) {
        break label237;
      }
      Log.i("MicroMsg.WalletUserInfoManger", "mLoanEntryInfo == null");
      AppMethodBeat.o(70531);
      return;
      if (this.HDi.size() == 0)
      {
        Log.i("MicroMsg.WalletUserInfoManger", "bankcards.size() == 0");
        break;
      }
      Log.i("MicroMsg.WalletUserInfoManger", "bankcards.size() == " + this.HDi.size());
      break;
      label163:
      if (this.HDj.size() == 0)
      {
        Log.i("MicroMsg.WalletUserInfoManger", "virtualBankcards.size() == 0");
        break label59;
      }
      Log.i("MicroMsg.WalletUserInfoManger", "virtualBankcards.size() == " + this.HDj.size());
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
  
  public static Bankcard fRX()
  {
    AppMethodBeat.i(70533);
    Bankcard localBankcard = t.fQI().a(null, null, true, true);
    if (localBankcard == null) {
      Log.e("MicroMsg.WalletUserInfoManger", "defaultBankcards == null");
    }
    AppMethodBeat.o(70533);
    return localBankcard;
  }
  
  private static boolean hY(List<Bankcard> paramList)
  {
    AppMethodBeat.i(70517);
    if (paramList.size() == 0)
    {
      AppMethodBeat.o(70517);
      return false;
    }
    g.aAi();
    Object localObject = (String)g.aAh().azQ().get(196659, null);
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
    this.IbK = paramam;
    t.fQD().bnU();
    t.fQD().b(paramam);
    AppMethodBeat.o(70521);
  }
  
  public final void a(am paramam, ArrayList<Bankcard> paramArrayList1, ArrayList<Bankcard> paramArrayList2, Bankcard paramBankcard1, Bankcard paramBankcard2, n paramn, b paramb, Bankcard paramBankcard3, int paramInt1, int paramInt2, List<c> paramList)
  {
    AppMethodBeat.i(70520);
    Log.i("MicroMsg.WalletUserInfoManger", "setBankcards scene %d", new Object[] { Integer.valueOf(paramInt2) });
    if (paramInt2 == 8)
    {
      this.IbH = paramArrayList1;
      this.IbP = paramList;
    }
    if ((paramInt2 == 24) || (paramInt2 == 25)) {
      this.IbI = paramArrayList1;
    }
    if (paramInt2 == 12) {
      this.IbJ = paramArrayList1;
    }
    this.HDi = paramArrayList1;
    this.HDj = paramArrayList2;
    this.Hwc = paramBankcard1;
    this.IbM = new al(paramam.field_switchConfig, paramam.field_wallet_entrance_balance_switch_state);
    this.IbL = paramBankcard2;
    this.IbN = paramn;
    this.IbO = paramb;
    this.IbQ = paramBankcard3;
    Log.i("MicroMsg.WalletUserInfoManger", "setBankcards()! " + paramam.field_switchConfig);
    fRW();
    int i = paramInt1;
    if (paramInt1 < 0) {
      i = 600;
    }
    this.IbS = (Util.nowSecond() + i);
    this.IbT = (Util.nowSecond() + 600L);
    Log.i("MicroMsg.WalletUserInfoManger", "hy: cache time: %d, dead time: %d, cacheDeadTime: %s", new Object[] { Integer.valueOf(i), Long.valueOf(this.IbS), Long.valueOf(this.IbT) });
    com.tencent.mm.plugin.wallet_core.utils.d.aeX(paramInt2);
    if ((paramInt2 != 24) && (paramInt2 != 25) && (paramArrayList1 != null)) {
      com.tencent.mm.plugin.wallet_core.utils.d.E(paramArrayList1, paramInt2);
    }
    if (paramArrayList2 != null) {
      com.tencent.mm.plugin.wallet_core.utils.d.E(paramArrayList2, paramInt2);
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
    t.fQK().bnU();
    if (paramn != null) {
      t.fQK().insert(paramn);
    }
    AppMethodBeat.o(70520);
  }
  
  public final Bankcard aVm(String paramString)
  {
    AppMethodBeat.i(214199);
    if ((this.HDi != null) && (!this.HDi.isEmpty()))
    {
      Iterator localIterator = this.HDi.iterator();
      while (localIterator.hasNext())
      {
        Bankcard localBankcard = (Bankcard)localIterator.next();
        if (localBankcard.field_bindSerial.equals(paramString))
        {
          AppMethodBeat.o(214199);
          return localBankcard;
        }
      }
    }
    AppMethodBeat.o(214199);
    return null;
  }
  
  public final boolean aVn(String paramString)
  {
    AppMethodBeat.i(70518);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(70518);
      return false;
    }
    Iterator localIterator;
    Bankcard localBankcard;
    if (this.HDi != null)
    {
      localIterator = this.HDi.iterator();
      while (localIterator.hasNext())
      {
        localBankcard = (Bankcard)localIterator.next();
        if ((paramString.equals(localBankcard.field_bankcardType)) && (localBankcard.fQa()))
        {
          AppMethodBeat.o(70518);
          return false;
        }
      }
    }
    if (this.HDj != null)
    {
      localIterator = this.HDj.iterator();
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
  
  public final void and()
  {
    AppMethodBeat.i(70505);
    if (this.IbK != null)
    {
      this.IbK.field_is_reg = -1;
      this.IbK = null;
    }
    if (this.IbM != null) {
      this.IbM = null;
    }
    if (this.Hwc != null) {
      this.Hwc = null;
    }
    if (this.HDi != null)
    {
      this.HDi.clear();
      this.HDi = null;
    }
    if (this.HDj != null)
    {
      this.HDj.clear();
      this.HDj = null;
    }
    if (this.IbR != null) {
      this.IbR = null;
    }
    this.IbT = 0L;
    f.a(new f.c[] { new f.c("wallet_balance_version", Integer.valueOf(-1)), new f.c("wallet_balance_last_update_time", Integer.valueOf(-1)), new f.c("wallet_balance", Integer.valueOf(-1)) });
    this.IbS = Util.nowSecond();
    AppMethodBeat.o(70505);
  }
  
  public final void c(cul paramcul)
  {
    AppMethodBeat.i(70519);
    this.IbR = paramcul;
    ai.a(paramcul);
    AppMethodBeat.o(70519);
  }
  
  public final int fRA()
  {
    if (this.IbK != null) {
      return this.IbK.field_is_show_lqb;
    }
    return 0;
  }
  
  public final boolean fRB()
  {
    if (this.IbK != null) {
      return this.IbK.field_is_open_lqb == 1;
    }
    return false;
  }
  
  public final String fRC()
  {
    if (this.IbK != null) {
      return this.IbK.field_lqb_open_url;
    }
    return null;
  }
  
  public final boolean fRD()
  {
    if (this.IbK != null) {
      return this.IbK.field_paymenu_use_new == 1;
    }
    return false;
  }
  
  public final ArrayList<Bankcard> fRE()
  {
    AppMethodBeat.i(70506);
    if ((this.HDi == null) || (this.HDi.size() <= 0)) {
      this.HDi = t.fQF().fRE();
    }
    if ((this.HDi == null) || (this.HDi.size() <= 0))
    {
      AppMethodBeat.o(70506);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.HDi.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add((Bankcard)localIterator.next());
    }
    AppMethodBeat.o(70506);
    return localArrayList;
  }
  
  public final List<c> fRF()
  {
    AppMethodBeat.i(70507);
    if ((this.IbP == null) || (this.IbP.size() <= 0))
    {
      AppMethodBeat.o(70507);
      return null;
    }
    List localList = this.IbP;
    AppMethodBeat.o(70507);
    return localList;
  }
  
  public final ArrayList<Bankcard> fRG()
  {
    AppMethodBeat.i(70508);
    if ((this.HDi == null) || (this.HDi.size() <= 0))
    {
      AppMethodBeat.o(70508);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.HDi.iterator();
    while (localIterator.hasNext())
    {
      Bankcard localBankcard = (Bankcard)localIterator.next();
      if ((!localBankcard.fQd()) && (!localBankcard.fQf())) {
        localArrayList.add(localBankcard);
      }
    }
    AppMethodBeat.o(70508);
    return localArrayList;
  }
  
  public final ArrayList<Bankcard> fRH()
  {
    AppMethodBeat.i(214201);
    if (this.IbH == null)
    {
      AppMethodBeat.o(214201);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    if ((this.Hwc != null) && (!fRm())) {
      localArrayList.add(this.Hwc);
    }
    if ((this.IbQ != null) && (!fRm())) {
      localArrayList.add(this.IbQ);
    }
    if (this.IbH.size() > 0)
    {
      Iterator localIterator = this.IbH.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add((Bankcard)localIterator.next());
      }
    }
    AppMethodBeat.o(214201);
    return localArrayList;
  }
  
  public final ArrayList<Bankcard> fRI()
  {
    AppMethodBeat.i(70511);
    ArrayList localArrayList = new ArrayList();
    if ((this.Hwc != null) && (!fRm())) {
      localArrayList.add(this.Hwc);
    }
    if ((this.IbQ != null) && (!fRm())) {
      localArrayList.add(this.IbQ);
    }
    Iterator localIterator;
    if ((this.IbH != null) && (this.IbH.size() > 0)) {
      localIterator = this.IbH.iterator();
    }
    while (localIterator.hasNext())
    {
      localArrayList.add((Bankcard)localIterator.next());
      continue;
      if ((this.HDi != null) && (this.HDi.size() > 0))
      {
        localIterator = this.HDi.iterator();
        while (localIterator.hasNext()) {
          localArrayList.add((Bankcard)localIterator.next());
        }
      }
    }
    AppMethodBeat.o(70511);
    return localArrayList;
  }
  
  public final ArrayList<Bankcard> fRJ()
  {
    AppMethodBeat.i(70512);
    ArrayList localArrayList = new ArrayList();
    if ((this.Hwc != null) && (!fRm())) {
      localArrayList.add(this.Hwc);
    }
    if ((this.IbI != null) && (this.HDi != null) && (this.IbI.size() > 0))
    {
      Iterator localIterator = this.IbI.iterator();
      while (localIterator.hasNext())
      {
        Bankcard localBankcard = (Bankcard)localIterator.next();
        if (!localBankcard.fQf()) {
          localArrayList.add(localBankcard);
        }
      }
    }
    AppMethodBeat.o(70512);
    return localArrayList;
  }
  
  public final boolean fRK()
  {
    AppMethodBeat.i(70514);
    if (fRL())
    {
      AppMethodBeat.o(70514);
      return false;
    }
    if ((this.HDi != null) && (this.HDi.size() > 0))
    {
      AppMethodBeat.o(70514);
      return false;
    }
    AppMethodBeat.o(70514);
    return true;
  }
  
  public final boolean fRM()
  {
    AppMethodBeat.i(70516);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    g(localArrayList1, localArrayList2);
    if (hY(localArrayList2))
    {
      AppMethodBeat.o(70516);
      return true;
    }
    AppMethodBeat.o(70516);
    return false;
  }
  
  public final am fRN()
  {
    AppMethodBeat.i(214203);
    if (this.IbK == null) {
      this.IbK = t.fQD().fRN();
    }
    am localam = this.IbK;
    AppMethodBeat.o(214203);
    return localam;
  }
  
  public final int fRO()
  {
    if (this.IbW > 0) {
      return this.IbW;
    }
    return 10000;
  }
  
  public final String fRQ()
  {
    AppMethodBeat.i(70527);
    if ((this.HDi == null) || (this.HDi.size() <= 0))
    {
      Log.e("MicroMsg.WalletUserInfoManger", "not found bankcard!");
      AppMethodBeat.o(70527);
      return null;
    }
    Object localObject = this.HDi.iterator();
    if (((Iterator)localObject).hasNext())
    {
      localObject = ((Bankcard)((Iterator)localObject).next()).field_bindSerial;
      AppMethodBeat.o(70527);
      return localObject;
    }
    AppMethodBeat.o(70527);
    return null;
  }
  
  public final boolean fRS()
  {
    AppMethodBeat.i(70530);
    long l = Util.secondsToNow(this.IbU);
    Log.d("MicroMsg.WalletUserInfoManger", "pass time ".concat(String.valueOf(l)));
    if (l > 300L)
    {
      AppMethodBeat.o(70530);
      return true;
    }
    AppMethodBeat.o(70530);
    return false;
  }
  
  public final int fRT()
  {
    if (this.IbK != null) {
      return this.IbK.field_lqt_cell_is_show;
    }
    return 0;
  }
  
  public final String fRU()
  {
    if (this.IbK != null) {
      return this.IbK.field_lqt_cell_lqt_title;
    }
    return null;
  }
  
  public final String fRV()
  {
    if (this.IbK != null) {
      return this.IbK.field_lqt_cell_lqt_wording;
    }
    return null;
  }
  
  public final boolean fRk()
  {
    AppMethodBeat.i(70496);
    if ((this.IbK != null) && (this.IbK.fRk()))
    {
      AppMethodBeat.o(70496);
      return true;
    }
    AppMethodBeat.o(70496);
    return false;
  }
  
  public final boolean fRl()
  {
    AppMethodBeat.i(70498);
    if ((this.IbK != null) && (this.IbK.fRl()))
    {
      AppMethodBeat.o(70498);
      return true;
    }
    AppMethodBeat.o(70498);
    return false;
  }
  
  public final boolean fRm()
  {
    AppMethodBeat.i(70497);
    if ((this.IbK != null) && (this.IbK.fRm()))
    {
      AppMethodBeat.o(70497);
      return true;
    }
    AppMethodBeat.o(70497);
    return false;
  }
  
  public final boolean fRo()
  {
    AppMethodBeat.i(70499);
    if ((this.IbK != null) && (this.IbK.fRo()))
    {
      AppMethodBeat.o(70499);
      return true;
    }
    AppMethodBeat.o(70499);
    return false;
  }
  
  public final boolean fRp()
  {
    AppMethodBeat.i(70495);
    if ((this.IbK == null) || ((this.IbK != null) && (this.IbK.fRn())))
    {
      AppMethodBeat.o(70495);
      return true;
    }
    AppMethodBeat.o(70495);
    return false;
  }
  
  public final int fRq()
  {
    if (this.IbK != null) {
      return this.IbK.field_soter_pay_open_type;
    }
    return 0;
  }
  
  public final String fRr()
  {
    if (this.IbK != null) {
      return this.IbK.field_ftf_pay_url;
    }
    return null;
  }
  
  public final al fRs()
  {
    AppMethodBeat.i(70501);
    if (this.IbM == null)
    {
      localal = new al();
      AppMethodBeat.o(70501);
      return localal;
    }
    al localal = this.IbM;
    AppMethodBeat.o(70501);
    return localal;
  }
  
  public final boolean fRt()
  {
    return (this.IbK != null) && (this.IbK.field_isDomesticUser);
  }
  
  public final int fRu()
  {
    if (this.IbK != null) {
      return this.IbK.field_cre_type;
    }
    return 1;
  }
  
  public final String fRv()
  {
    AppMethodBeat.i(70502);
    g.aAi();
    String str = (String)g.aAh().azQ().get(ar.a.OdS, null);
    if (!Util.isNullOrNil(str))
    {
      AppMethodBeat.o(70502);
      return str;
    }
    if (this.IbK != null)
    {
      str = this.IbK.field_lct_wording;
      AppMethodBeat.o(70502);
      return str;
    }
    AppMethodBeat.o(70502);
    return null;
  }
  
  public final String fRw()
  {
    if (this.IbK != null) {
      return this.IbK.field_lct_url;
    }
    return null;
  }
  
  public final String fRx()
  {
    if (this.IbK != null) {
      return this.IbK.field_forget_passwd_url;
    }
    return "";
  }
  
  public final void fRy()
  {
    AppMethodBeat.i(70503);
    if (!g.aAf().azp())
    {
      Log.w("MicroMsg.WalletUserInfoManger", "Account Not Ready!");
      AppMethodBeat.o(70503);
      return;
    }
    this.IbK = t.fQD().fRN();
    if (this.IbK != null) {
      this.IbM = new al(this.IbK.field_switchConfig, this.IbK.field_wallet_entrance_balance_switch_state);
    }
    for (;;)
    {
      if (!Util.isNullOrNil(this.IbK.field_bank_priority)) {}
      try
      {
        this.IbP = ai.bQ(new JSONObject(this.IbK.field_bank_priority));
        this.Hwc = t.fQF().fSo();
        this.IbQ = t.fQF().fSp();
        f.a("wallet_balance", new f.b()
        {
          public final void dy(Object paramAnonymousObject)
          {
            AppMethodBeat.i(70493);
            if ((paramAnonymousObject != null) && ((paramAnonymousObject instanceof Double)))
            {
              if (((Double)paramAnonymousObject).doubleValue() < 0.0D) {
                Log.v("MicroMsg.WalletUserInfoManger", "val is zero %s", new Object[] { Util.getStack().toString() });
              }
              if (an.this.Hwc != null)
              {
                an.this.Hwc.HVC = ((Double)paramAnonymousObject).doubleValue();
                AppMethodBeat.o(70493);
              }
            }
            else
            {
              Log.i("MicroMsg.WalletUserInfoManger", "hy: no balance info. set to negative");
              if (an.this.Hwc != null) {
                an.this.Hwc.HVC = -1.0D;
              }
            }
            AppMethodBeat.o(70493);
          }
        });
        this.HDi = t.fQF().fRE();
        this.IbH = com.tencent.mm.plugin.wallet_core.utils.d.aeY(8);
        this.IbJ = com.tencent.mm.plugin.wallet_core.utils.d.aeY(12);
        this.HDj = t.fQF().fSq();
        this.IbL = t.fQF().fSr();
        this.IbN = t.fQK().fSm();
        Log.i("MicroMsg.WalletUserInfoManger", "loadDbData!");
        fRW();
        this.IbR = ai.fQV();
        AppMethodBeat.o(70503);
        return;
        this.IbM = new al();
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
  
  public final boolean fRz()
  {
    AppMethodBeat.i(70504);
    if (ac.jPD)
    {
      AppMethodBeat.o(70504);
      return true;
    }
    g.aAi();
    int i = ((Integer)g.aAh().azQ().get(ar.a.OdR, Integer.valueOf(-1))).intValue();
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
    if (this.IbK != null)
    {
      if (this.IbK.field_lqt_state == 1)
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
  
  public final void g(ArrayList<Bankcard> paramArrayList1, ArrayList<Bankcard> paramArrayList2)
  {
    AppMethodBeat.i(70513);
    if ((paramArrayList1 == null) || (paramArrayList2 == null))
    {
      Log.e("MicroMsg.WalletUserInfoManger", "error list,bankcardsClone == null || virtualBankcardsClone == null");
      AppMethodBeat.o(70513);
      return;
    }
    if ((this.IbJ == null) && (this.HDi != null))
    {
      Log.e("MicroMsg.WalletUserInfoManger", "listManageUIbankcards == null && bankcards != null");
      this.IbJ = this.HDi;
    }
    if (this.IbJ == null)
    {
      Log.e("MicroMsg.WalletUserInfoManger", "error list, listManageUIbankcards == null");
      AppMethodBeat.o(70513);
      return;
    }
    paramArrayList1.clear();
    paramArrayList2.clear();
    Iterator localIterator;
    if (this.IbJ != null)
    {
      localIterator = this.IbJ.iterator();
      while (localIterator.hasNext()) {
        paramArrayList1.add((Bankcard)localIterator.next());
      }
    }
    if (this.HDj != null)
    {
      localIterator = this.HDj.iterator();
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
    if (this.IbK != null) {
      return this.IbK.field_true_name;
    }
    return null;
  }
  
  public final Bankcard l(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(214200);
    if ((paramBoolean1) && (this.Hwc != null) && (this.Hwc.field_bindSerial.equals(paramString)))
    {
      paramString = this.Hwc;
      AppMethodBeat.o(214200);
      return paramString;
    }
    if ((paramBoolean2) && (this.IbQ != null) && (this.IbQ.field_bindSerial.equals(paramString)))
    {
      paramString = this.IbQ;
      AppMethodBeat.o(214200);
      return paramString;
    }
    Log.i("MicroMsg.WalletUserInfoManger", "need get bankcard is ：%s ", new Object[] { paramString });
    Iterator localIterator;
    Bankcard localBankcard;
    if ((this.IbH != null) && (!this.IbH.isEmpty()))
    {
      localIterator = this.IbH.iterator();
      while (localIterator.hasNext())
      {
        localBankcard = (Bankcard)localIterator.next();
        Log.i("MicroMsg.WalletUserInfoManger", "compared offline offlinebankcards:%s", new Object[] { localBankcard.field_bindSerial });
        if (localBankcard.field_bindSerial.equals(paramString))
        {
          AppMethodBeat.o(214200);
          return localBankcard;
        }
      }
    }
    if ((this.HDi != null) && (!this.HDi.isEmpty()))
    {
      localIterator = this.HDi.iterator();
      while (localIterator.hasNext())
      {
        localBankcard = (Bankcard)localIterator.next();
        Log.i("MicroMsg.WalletUserInfoManger", "compared bankcards:%s", new Object[] { localBankcard.field_bindSerial });
        if (localBankcard.field_bindSerial.equals(paramString))
        {
          AppMethodBeat.o(214200);
          return localBankcard;
        }
      }
    }
    AppMethodBeat.o(214200);
    return null;
  }
  
  public final ArrayList<Bankcard> yj(boolean paramBoolean)
  {
    AppMethodBeat.i(70509);
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean)
    {
      if ((this.Hwc != null) && (!fRm())) {
        localArrayList.add(this.Hwc);
      }
      if ((this.IbQ != null) && (!fRm())) {
        localArrayList.add(this.IbQ);
      }
    }
    if ((this.HDi != null) && (this.HDi.size() > 0))
    {
      Iterator localIterator = this.HDi.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add((Bankcard)localIterator.next());
      }
    }
    AppMethodBeat.o(70509);
    return localArrayList;
  }
  
  @Deprecated
  public final ArrayList<Bankcard> yk(boolean paramBoolean)
  {
    AppMethodBeat.i(258350);
    ArrayList localArrayList = yj(paramBoolean);
    AppMethodBeat.o(258350);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.an
 * JD-Core Version:    0.7.0.1
 */