package com.tencent.mm.plugin.wallet_core.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.wallet_core.d.a;
import com.tencent.mm.plugin.wallet_core.d.d;
import com.tencent.mm.protocal.protobuf.dvr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.wallet_core.ui.i;
import com.tencent.mm.wallet_core.ui.i.b;
import com.tencent.mm.wallet_core.ui.i.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class am
{
  private ArrayList<Bankcard> VJZ;
  private ArrayList<Bankcard> VKa;
  private ArrayList<Bankcard> VKb;
  public al VKc;
  public Bankcard VKd;
  public ak VKe;
  public n VKf;
  public b VKg;
  private List<c> VKh;
  public Bankcard VKi;
  public dvr VKj;
  public long VKk;
  long VKl;
  public long VKm;
  private String VKn;
  public int VKo;
  public String VKp;
  public String VKq;
  int VbU;
  int VbV;
  public Bankcard VcF;
  private ArrayList<Bankcard> Vkp;
  private ArrayList<Bankcard> Vkq;
  public int mRetryCount;
  
  public am()
  {
    AppMethodBeat.i(70494);
    this.VJZ = new ArrayList();
    this.VKa = new ArrayList();
    this.VKb = new ArrayList();
    this.Vkp = new ArrayList();
    this.Vkq = new ArrayList();
    this.VKc = null;
    this.VKd = null;
    this.VcF = null;
    this.VKe = null;
    this.VKf = null;
    this.VKg = null;
    this.VKh = new LinkedList();
    this.VKi = null;
    this.VbU = 0;
    this.VbV = 0;
    this.VKk = Util.nowSecond();
    this.VKl = 0L;
    this.VKm = -1L;
    this.VKn = "";
    this.VKo = 10000;
    this.mRetryCount = 0;
    this.VKp = "";
    this.VKq = "";
    ijv();
    AppMethodBeat.o(70494);
  }
  
  @Deprecated
  private Bankcard b(ArrayList<Bankcard> paramArrayList, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(70526);
    Object localObject1 = paramArrayList;
    if (paramArrayList == null) {
      localObject1 = this.Vkp;
    }
    paramArrayList = paramString;
    if (Util.isNullOrNil(paramString))
    {
      Log.i("MicroMsg.WalletUserInfoManger", "bindSerial is null ");
      paramArrayList = ijM();
    }
    Log.i("MicroMsg.WalletUserInfoManger", "getDefaultRecommendBankcard bindSerial:%s", new Object[] { paramArrayList });
    if ((paramBoolean1) && (this.VcF != null))
    {
      if (ijg())
      {
        paramArrayList = this.VcF;
        AppMethodBeat.o(70526);
        return paramArrayList;
      }
      if ((paramArrayList != null) && (paramArrayList.equals(this.VcF.field_bindSerial)))
      {
        paramArrayList = this.VcF;
        AppMethodBeat.o(70526);
        return paramArrayList;
      }
      if ((this.VKi != null) && (this.VKc != null) && (this.VKc.field_lqt_state == 1) && (paramArrayList != null) && (paramArrayList.equals(this.VKi.field_bindSerial)))
      {
        paramArrayList = this.VKi;
        AppMethodBeat.o(70526);
        return paramArrayList;
      }
      if ((!ijh()) && ((localObject1 == null) || (((ArrayList)localObject1).size() == 0)))
      {
        paramArrayList = this.VcF;
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
          if ((!paramBoolean3) || (!((Bankcard)localObject2).ihZ())) {
            break;
          }
          Log.i("MicroMsg.WalletUserInfoManger", "default card is honeypay");
          if ((paramBoolean1) && (this.VcF != null))
          {
            Log.i("MicroMsg.WalletUserInfoManger", "return balance");
            paramArrayList = this.VcF;
            AppMethodBeat.o(70526);
            return paramArrayList;
          }
          localObject2 = ((ArrayList)localObject1).iterator();
        }
        localBankcard = (Bankcard)((Iterator)localObject2).next();
      } while (localBankcard.ihZ());
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
  
  public static void bgG(String paramString)
  {
    AppMethodBeat.i(70523);
    if (!Util.isNullOrNil(paramString))
    {
      h.baF();
      h.baE().ban().B(196612, paramString);
    }
    AppMethodBeat.o(70523);
  }
  
  private static void bgH(String paramString)
  {
    AppMethodBeat.i(70528);
    if (paramString != null)
    {
      h.baF();
      h.baE().ban().B(196633, paramString);
    }
    AppMethodBeat.o(70528);
  }
  
  public static void bgI(String paramString)
  {
    AppMethodBeat.i(70532);
    Log.i("MicroMsg.WalletUserInfoManger", "setSelectBindSerial %s %s", new Object[] { paramString, Util.getStack().toString() });
    bgH(paramString);
    AppMethodBeat.o(70532);
  }
  
  public static void bgJ(String paramString)
  {
    AppMethodBeat.i(301162);
    h.baE().ban().set(at.a.acVJ, paramString);
    AppMethodBeat.o(301162);
  }
  
  private boolean ijI()
  {
    AppMethodBeat.i(70515);
    if (((this.VKe != null) && (this.VKe.iiS())) || ((this.Vkq != null) && (this.Vkq.size() > 0)))
    {
      AppMethodBeat.o(70515);
      return true;
    }
    AppMethodBeat.o(70515);
    return false;
  }
  
  private static String ijM()
  {
    AppMethodBeat.i(70522);
    h.baF();
    String str = (String)h.baE().ban().d(196612, null);
    AppMethodBeat.o(70522);
    return str;
  }
  
  public static String ijO()
  {
    AppMethodBeat.i(70529);
    h.baF();
    String str = (String)h.baE().ban().d(196633, null);
    AppMethodBeat.o(70529);
    return str;
  }
  
  private void ijT()
  {
    AppMethodBeat.i(70531);
    Log.i("MicroMsg.WalletUserInfoManger", "recordDataState()");
    if (this.VKc == null) {
      Log.i("MicroMsg.WalletUserInfoManger", "userInfo == null");
    }
    if (this.Vkp == null)
    {
      Log.i("MicroMsg.WalletUserInfoManger", "bankcards == null");
      if (this.Vkq != null) {
        break label163;
      }
      Log.i("MicroMsg.WalletUserInfoManger", "virtualBankcards == null");
      label59:
      if (this.VcF != null) {
        break label215;
      }
      Log.i("MicroMsg.WalletUserInfoManger", "balance == null");
      label74:
      if (this.VKd != null) {
        break label226;
      }
      Log.i("MicroMsg.WalletUserInfoManger", "historyBankcard == null");
    }
    for (;;)
    {
      if (this.VKf != null) {
        break label237;
      }
      Log.i("MicroMsg.WalletUserInfoManger", "mLoanEntryInfo == null");
      AppMethodBeat.o(70531);
      return;
      if (this.Vkp.size() == 0)
      {
        Log.i("MicroMsg.WalletUserInfoManger", "bankcards.size() == 0");
        break;
      }
      Log.i("MicroMsg.WalletUserInfoManger", "bankcards.size() == " + this.Vkp.size());
      break;
      label163:
      if (this.Vkq.size() == 0)
      {
        Log.i("MicroMsg.WalletUserInfoManger", "virtualBankcards.size() == 0");
        break label59;
      }
      Log.i("MicroMsg.WalletUserInfoManger", "virtualBankcards.size() == " + this.Vkq.size());
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
  
  public static Bankcard ijU()
  {
    AppMethodBeat.i(70533);
    Bankcard localBankcard = u.iiC().a(null, null, true, true);
    if (localBankcard == null) {
      Log.e("MicroMsg.WalletUserInfoManger", "defaultBankcards == null");
    }
    AppMethodBeat.o(70533);
    return localBankcard;
  }
  
  private static boolean lW(List<Bankcard> paramList)
  {
    AppMethodBeat.i(70517);
    if (paramList.size() == 0)
    {
      AppMethodBeat.o(70517);
      return false;
    }
    h.baF();
    Object localObject = (String)h.baE().ban().d(196659, null);
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
  
  public final ArrayList<Bankcard> HJ(boolean paramBoolean)
  {
    AppMethodBeat.i(70509);
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean)
    {
      if ((this.VcF != null) && (!ijh())) {
        localArrayList.add(this.VcF);
      }
      if ((this.VKi != null) && (!ijh())) {
        localArrayList.add(this.VKi);
      }
    }
    if ((this.Vkp != null) && (this.Vkp.size() > 0))
    {
      Iterator localIterator = this.Vkp.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add((Bankcard)localIterator.next());
      }
    }
    AppMethodBeat.o(70509);
    return localArrayList;
  }
  
  @Deprecated
  public final ArrayList<Bankcard> HK(boolean paramBoolean)
  {
    AppMethodBeat.i(369881);
    ArrayList localArrayList = HJ(paramBoolean);
    AppMethodBeat.o(369881);
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
  
  public final void a(al paramal)
  {
    AppMethodBeat.i(70521);
    this.VKc = paramal;
    u.iix().bwy();
    u.iix().b(paramal);
    AppMethodBeat.o(70521);
  }
  
  public final void a(al paramal, ArrayList<Bankcard> paramArrayList1, ArrayList<Bankcard> paramArrayList2, Bankcard paramBankcard1, Bankcard paramBankcard2, n paramn, b paramb, Bankcard paramBankcard3, int paramInt1, int paramInt2, List<c> paramList)
  {
    AppMethodBeat.i(70520);
    Log.i("MicroMsg.WalletUserInfoManger", "setBankcards scene %d", new Object[] { Integer.valueOf(paramInt2) });
    if (paramInt2 == 8)
    {
      this.VJZ = paramArrayList1;
      this.VKh = paramList;
    }
    if ((paramInt2 == 24) || (paramInt2 == 25)) {
      this.VKa = paramArrayList1;
    }
    if (paramInt2 == 12) {
      this.VKb = paramArrayList1;
    }
    this.Vkp = paramArrayList1;
    this.Vkq = paramArrayList2;
    this.VcF = paramBankcard1;
    this.VKe = new ak(paramal.field_switchConfig, paramal.field_wallet_entrance_balance_switch_state);
    this.VKd = paramBankcard2;
    this.VKf = paramn;
    this.VKg = paramb;
    this.VKi = paramBankcard3;
    Log.i("MicroMsg.WalletUserInfoManger", "setBankcards()! " + paramal.field_switchConfig);
    ijT();
    int i = paramInt1;
    if (paramInt1 < 0) {
      i = 600;
    }
    this.VKk = (Util.nowSecond() + i);
    this.VKl = (Util.nowSecond() + 600L);
    Log.i("MicroMsg.WalletUserInfoManger", "hy: cache time: %d, dead time: %d, cacheDeadTime: %s", new Object[] { Integer.valueOf(i), Long.valueOf(this.VKk), Long.valueOf(this.VKl) });
    com.tencent.mm.plugin.wallet_core.utils.k.asA(paramInt2);
    if ((paramInt2 != 24) && (paramInt2 != 25) && (paramArrayList1 != null)) {
      com.tencent.mm.plugin.wallet_core.utils.k.X(paramArrayList1, paramInt2);
    }
    if (paramArrayList2 != null) {
      com.tencent.mm.plugin.wallet_core.utils.k.X(paramArrayList2, paramInt2);
    }
    if (paramBankcard1 != null) {
      com.tencent.mm.plugin.wallet_core.utils.k.a(paramBankcard1, paramInt2);
    }
    if (paramBankcard2 != null) {
      com.tencent.mm.plugin.wallet_core.utils.k.a(paramBankcard2, paramInt2);
    }
    if (paramBankcard3 != null) {
      com.tencent.mm.plugin.wallet_core.utils.k.a(paramBankcard3, paramInt2);
    }
    a(paramal);
    u.iiE().bwy();
    if (paramn != null) {
      u.iiE().insert(paramn);
    }
    AppMethodBeat.o(70520);
  }
  
  public final void aNm()
  {
    AppMethodBeat.i(70505);
    if (this.VKc != null)
    {
      this.VKc.field_is_reg = -1;
      this.VKc = null;
    }
    if (this.VKe != null) {
      this.VKe = null;
    }
    if (this.VcF != null) {
      this.VcF = null;
    }
    if (this.Vkp != null)
    {
      this.Vkp.clear();
      this.Vkp = null;
    }
    if (this.Vkq != null)
    {
      this.Vkq.clear();
      this.Vkq = null;
    }
    if (this.VKj != null) {
      this.VKj = null;
    }
    this.VKl = 0L;
    i.a(new i.c[] { new i.c("wallet_balance_version", Integer.valueOf(-1)), new i.c("wallet_balance_last_update_time", Integer.valueOf(-1)), new i.c("wallet_balance", Integer.valueOf(-1)) });
    this.VKk = Util.nowSecond();
    AppMethodBeat.o(70505);
  }
  
  public final Bankcard bgD(String paramString)
  {
    AppMethodBeat.i(301171);
    if ((this.Vkp != null) && (!this.Vkp.isEmpty()))
    {
      Iterator localIterator = this.Vkp.iterator();
      while (localIterator.hasNext())
      {
        Bankcard localBankcard = (Bankcard)localIterator.next();
        if (localBankcard.field_bindSerial.equals(paramString))
        {
          AppMethodBeat.o(301171);
          return localBankcard;
        }
      }
    }
    AppMethodBeat.o(301171);
    return null;
  }
  
  public final Bankcard bgE(String paramString)
  {
    AppMethodBeat.i(301184);
    Object localObject = ijE();
    if ((!Util.isNullOrNil(paramString)) && (localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Bankcard localBankcard = (Bankcard)((Iterator)localObject).next();
        if (localBankcard.field_bindSerial.equals(paramString))
        {
          AppMethodBeat.o(301184);
          return localBankcard;
        }
      }
    }
    AppMethodBeat.o(301184);
    return null;
  }
  
  public final boolean bgF(String paramString)
  {
    AppMethodBeat.i(70518);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(70518);
      return false;
    }
    Iterator localIterator;
    Bankcard localBankcard;
    if (this.Vkp != null)
    {
      localIterator = this.Vkp.iterator();
      while (localIterator.hasNext())
      {
        localBankcard = (Bankcard)localIterator.next();
        if ((paramString.equals(localBankcard.field_bankcardType)) && (localBankcard.ihU()))
        {
          AppMethodBeat.o(70518);
          return false;
        }
      }
    }
    if (this.Vkq != null)
    {
      localIterator = this.Vkq.iterator();
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
  
  public final void c(dvr paramdvr)
  {
    AppMethodBeat.i(70519);
    this.VKj = paramdvr;
    ah.a(paramdvr);
    AppMethodBeat.o(70519);
  }
  
  public final String getTrueName()
  {
    if (this.VKc != null) {
      return this.VKc.field_true_name;
    }
    return null;
  }
  
  public final boolean ijA()
  {
    if (this.VKc != null) {
      return this.VKc.field_paymenu_use_new == 1;
    }
    return false;
  }
  
  public final ArrayList<Bankcard> ijB()
  {
    AppMethodBeat.i(70506);
    if ((this.Vkp == null) || (this.Vkp.size() <= 0)) {
      this.Vkp = u.iiz().ijB();
    }
    if ((this.Vkp == null) || (this.Vkp.size() <= 0))
    {
      AppMethodBeat.o(70506);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.Vkp.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add((Bankcard)localIterator.next());
    }
    AppMethodBeat.o(70506);
    return localArrayList;
  }
  
  public final List<c> ijC()
  {
    AppMethodBeat.i(70507);
    if ((this.VKh == null) || (this.VKh.size() <= 0))
    {
      AppMethodBeat.o(70507);
      return null;
    }
    List localList = this.VKh;
    AppMethodBeat.o(70507);
    return localList;
  }
  
  public final ArrayList<Bankcard> ijD()
  {
    AppMethodBeat.i(70508);
    if ((this.Vkp == null) || (this.Vkp.size() <= 0))
    {
      AppMethodBeat.o(70508);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.Vkp.iterator();
    while (localIterator.hasNext())
    {
      Bankcard localBankcard = (Bankcard)localIterator.next();
      if ((!localBankcard.ihX()) && (!localBankcard.ihZ())) {
        localArrayList.add(localBankcard);
      }
    }
    AppMethodBeat.o(70508);
    return localArrayList;
  }
  
  public final ArrayList<Bankcard> ijE()
  {
    AppMethodBeat.i(301181);
    if (this.VJZ == null)
    {
      AppMethodBeat.o(301181);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    if ((this.VcF != null) && (!ijh())) {
      localArrayList.add(this.VcF);
    }
    if ((this.VKi != null) && (!ijh())) {
      localArrayList.add(this.VKi);
    }
    if (this.VJZ.size() > 0)
    {
      Iterator localIterator = this.VJZ.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add((Bankcard)localIterator.next());
      }
    }
    AppMethodBeat.o(301181);
    return localArrayList;
  }
  
  public final ArrayList<Bankcard> ijF()
  {
    AppMethodBeat.i(70511);
    ArrayList localArrayList = new ArrayList();
    if ((this.VcF != null) && (!ijh())) {
      localArrayList.add(this.VcF);
    }
    if ((this.VKi != null) && (!ijh())) {
      localArrayList.add(this.VKi);
    }
    Iterator localIterator;
    if ((this.VJZ != null) && (this.VJZ.size() > 0)) {
      localIterator = this.VJZ.iterator();
    }
    while (localIterator.hasNext())
    {
      localArrayList.add((Bankcard)localIterator.next());
      continue;
      if ((this.Vkp != null) && (this.Vkp.size() > 0))
      {
        localIterator = this.Vkp.iterator();
        while (localIterator.hasNext()) {
          localArrayList.add((Bankcard)localIterator.next());
        }
      }
    }
    AppMethodBeat.o(70511);
    return localArrayList;
  }
  
  public final ArrayList<Bankcard> ijG()
  {
    AppMethodBeat.i(70512);
    ArrayList localArrayList = new ArrayList();
    if ((this.VcF != null) && (!ijh())) {
      localArrayList.add(this.VcF);
    }
    if ((this.VKa != null) && (this.Vkp != null) && (this.VKa.size() > 0))
    {
      Iterator localIterator = this.VKa.iterator();
      while (localIterator.hasNext())
      {
        Bankcard localBankcard = (Bankcard)localIterator.next();
        if (!localBankcard.ihZ()) {
          localArrayList.add(localBankcard);
        }
      }
    }
    AppMethodBeat.o(70512);
    return localArrayList;
  }
  
  public final boolean ijH()
  {
    AppMethodBeat.i(70514);
    if (ijI())
    {
      AppMethodBeat.o(70514);
      return false;
    }
    if ((this.Vkp != null) && (this.Vkp.size() > 0))
    {
      AppMethodBeat.o(70514);
      return false;
    }
    AppMethodBeat.o(70514);
    return true;
  }
  
  public final boolean ijJ()
  {
    AppMethodBeat.i(70516);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    l(localArrayList1, localArrayList2);
    if (lW(localArrayList2))
    {
      AppMethodBeat.o(70516);
      return true;
    }
    AppMethodBeat.o(70516);
    return false;
  }
  
  public final al ijK()
  {
    AppMethodBeat.i(301195);
    if (this.VKc == null) {
      this.VKc = u.iix().ijK();
    }
    al localal = this.VKc;
    AppMethodBeat.o(301195);
    return localal;
  }
  
  public final int ijL()
  {
    if (this.VKo > 0) {
      return this.VKo;
    }
    return 10000;
  }
  
  public final String ijN()
  {
    AppMethodBeat.i(70527);
    if ((this.Vkp == null) || (this.Vkp.size() <= 0))
    {
      Log.e("MicroMsg.WalletUserInfoManger", "not found bankcard!");
      AppMethodBeat.o(70527);
      return null;
    }
    Object localObject = this.Vkp.iterator();
    if (((Iterator)localObject).hasNext())
    {
      localObject = ((Bankcard)((Iterator)localObject).next()).field_bindSerial;
      AppMethodBeat.o(70527);
      return localObject;
    }
    AppMethodBeat.o(70527);
    return null;
  }
  
  public final boolean ijP()
  {
    AppMethodBeat.i(70530);
    long l = Util.secondsToNow(this.VKm);
    Log.d("MicroMsg.WalletUserInfoManger", "pass time ".concat(String.valueOf(l)));
    if (l > 300L)
    {
      AppMethodBeat.o(70530);
      return true;
    }
    AppMethodBeat.o(70530);
    return false;
  }
  
  public final int ijQ()
  {
    if (this.VKc != null) {
      return this.VKc.field_lqt_cell_is_show;
    }
    return 0;
  }
  
  public final String ijR()
  {
    if (this.VKc != null) {
      return this.VKc.field_lqt_cell_lqt_title;
    }
    return null;
  }
  
  public final String ijS()
  {
    if (this.VKc != null) {
      return this.VKc.field_lqt_cell_lqt_wording;
    }
    return null;
  }
  
  public final boolean ijf()
  {
    AppMethodBeat.i(70496);
    if ((this.VKc != null) && (this.VKc.ijf()))
    {
      AppMethodBeat.o(70496);
      return true;
    }
    AppMethodBeat.o(70496);
    return false;
  }
  
  public final boolean ijg()
  {
    AppMethodBeat.i(70498);
    if ((this.VKc != null) && (this.VKc.ijg()))
    {
      AppMethodBeat.o(70498);
      return true;
    }
    AppMethodBeat.o(70498);
    return false;
  }
  
  public final boolean ijh()
  {
    AppMethodBeat.i(70497);
    if ((this.VKc != null) && (this.VKc.ijh()))
    {
      AppMethodBeat.o(70497);
      return true;
    }
    AppMethodBeat.o(70497);
    return false;
  }
  
  public final boolean ijj()
  {
    AppMethodBeat.i(70499);
    if ((this.VKc != null) && (this.VKc.ijj()))
    {
      AppMethodBeat.o(70499);
      return true;
    }
    AppMethodBeat.o(70499);
    return false;
  }
  
  public final boolean ijl()
  {
    AppMethodBeat.i(70495);
    if ((this.VKc == null) || ((this.VKc != null) && (this.VKc.iji())))
    {
      AppMethodBeat.o(70495);
      return true;
    }
    AppMethodBeat.o(70495);
    return false;
  }
  
  public final int ijm()
  {
    if (this.VKc != null) {
      return this.VKc.field_soter_pay_open_type;
    }
    return 0;
  }
  
  public final boolean ijn()
  {
    AppMethodBeat.i(301170);
    if (this.VKc == null)
    {
      AppMethodBeat.o(301170);
      return false;
    }
    if ((this.VKc.ijf()) && (this.VKc.field_isDomesticUser) && (this.VKc.ijk()))
    {
      AppMethodBeat.o(301170);
      return true;
    }
    AppMethodBeat.o(301170);
    return false;
  }
  
  public final String ijo()
  {
    if (this.VKc != null) {
      return this.VKc.field_ftf_pay_url;
    }
    return null;
  }
  
  public final ak ijp()
  {
    AppMethodBeat.i(70501);
    if (this.VKe == null)
    {
      localak = new ak();
      AppMethodBeat.o(70501);
      return localak;
    }
    ak localak = this.VKe;
    AppMethodBeat.o(70501);
    return localak;
  }
  
  public final boolean ijq()
  {
    return (this.VKc != null) && (this.VKc.field_isDomesticUser);
  }
  
  public final int ijr()
  {
    if (this.VKc != null) {
      return this.VKc.field_cre_type;
    }
    return 1;
  }
  
  public final String ijs()
  {
    AppMethodBeat.i(70502);
    h.baF();
    String str = (String)h.baE().ban().get(at.a.acTH, null);
    if (!Util.isNullOrNil(str))
    {
      AppMethodBeat.o(70502);
      return str;
    }
    if (this.VKc != null)
    {
      str = this.VKc.field_lct_wording;
      AppMethodBeat.o(70502);
      return str;
    }
    AppMethodBeat.o(70502);
    return null;
  }
  
  public final String ijt()
  {
    if (this.VKc != null) {
      return this.VKc.field_lct_url;
    }
    return null;
  }
  
  public final String iju()
  {
    if (this.VKc != null) {
      return this.VKc.field_forget_passwd_url;
    }
    return "";
  }
  
  public final void ijv()
  {
    AppMethodBeat.i(70503);
    if (!h.baC().aZN())
    {
      Log.w("MicroMsg.WalletUserInfoManger", "Account Not Ready!");
      AppMethodBeat.o(70503);
      return;
    }
    this.VKc = u.iix().ijK();
    if (this.VKc != null) {
      this.VKe = new ak(this.VKc.field_switchConfig, this.VKc.field_wallet_entrance_balance_switch_state);
    }
    for (;;)
    {
      if (!Util.isNullOrNil(this.VKc.field_bank_priority)) {}
      try
      {
        this.VKh = ah.cx(new JSONObject(this.VKc.field_bank_priority));
        this.VcF = u.iiz().ikl();
        this.VKi = u.iiz().ikm();
        i.a("wallet_balance", new i.b()
        {
          public final void fS(Object paramAnonymousObject)
          {
            AppMethodBeat.i(70493);
            if ((paramAnonymousObject != null) && ((paramAnonymousObject instanceof Double)))
            {
              if (((Double)paramAnonymousObject).doubleValue() < 0.0D) {
                Log.v("MicroMsg.WalletUserInfoManger", "val is zero %s", new Object[] { Util.getStack().toString() });
              }
              if (am.this.VcF != null)
              {
                am.this.VcF.VDo = ((Double)paramAnonymousObject).doubleValue();
                AppMethodBeat.o(70493);
              }
            }
            else
            {
              Log.i("MicroMsg.WalletUserInfoManger", "hy: no balance info. set to negative");
              if (am.this.VcF != null) {
                am.this.VcF.VDo = -1.0D;
              }
            }
            AppMethodBeat.o(70493);
          }
        });
        this.Vkp = u.iiz().ijB();
        this.VJZ = com.tencent.mm.plugin.wallet_core.utils.k.asB(8);
        this.VKb = com.tencent.mm.plugin.wallet_core.utils.k.asB(12);
        this.Vkq = u.iiz().ikn();
        this.VKd = u.iiz().iko();
        this.VKf = u.iiE().ikj();
        Log.i("MicroMsg.WalletUserInfoManger", "loadDbData!");
        ijT();
        this.VKj = ah.iiP();
        AppMethodBeat.o(70503);
        return;
        this.VKe = new ak();
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
  
  public final boolean ijw()
  {
    AppMethodBeat.i(70504);
    if (z.pDn)
    {
      AppMethodBeat.o(70504);
      return true;
    }
    h.baF();
    int i = ((Integer)h.baE().ban().get(at.a.acTG, Integer.valueOf(-1))).intValue();
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
    if (this.VKc != null)
    {
      if (this.VKc.field_lqt_state == 1)
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
  
  public final int ijx()
  {
    if (this.VKc != null) {
      return this.VKc.field_is_show_lqb;
    }
    return 0;
  }
  
  public final boolean ijy()
  {
    if (this.VKc != null) {
      return this.VKc.field_is_open_lqb == 1;
    }
    return false;
  }
  
  public final String ijz()
  {
    if (this.VKc != null) {
      return this.VKc.field_lqb_open_url;
    }
    return null;
  }
  
  public final void l(ArrayList<Bankcard> paramArrayList1, ArrayList<Bankcard> paramArrayList2)
  {
    AppMethodBeat.i(70513);
    if ((paramArrayList1 == null) || (paramArrayList2 == null))
    {
      Log.e("MicroMsg.WalletUserInfoManger", "error list,bankcardsClone == null || virtualBankcardsClone == null");
      AppMethodBeat.o(70513);
      return;
    }
    if ((this.VKb == null) && (this.Vkp != null))
    {
      Log.e("MicroMsg.WalletUserInfoManger", "listManageUIbankcards == null && bankcards != null");
      this.VKb = this.Vkp;
    }
    if (this.VKb == null)
    {
      Log.e("MicroMsg.WalletUserInfoManger", "error list, listManageUIbankcards == null");
      AppMethodBeat.o(70513);
      return;
    }
    paramArrayList1.clear();
    paramArrayList2.clear();
    Iterator localIterator;
    if (this.VKb != null)
    {
      localIterator = this.VKb.iterator();
      while (localIterator.hasNext()) {
        paramArrayList1.add((Bankcard)localIterator.next());
      }
    }
    if (this.Vkq != null)
    {
      localIterator = this.Vkq.iterator();
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
  
  public final Bankcard p(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(301172);
    if ((paramBoolean1) && (this.VcF != null) && (this.VcF.field_bindSerial.equals(paramString)))
    {
      paramString = this.VcF;
      AppMethodBeat.o(301172);
      return paramString;
    }
    if ((paramBoolean2) && (this.VKi != null) && (this.VKi.field_bindSerial.equals(paramString)))
    {
      paramString = this.VKi;
      AppMethodBeat.o(301172);
      return paramString;
    }
    Log.i("MicroMsg.WalletUserInfoManger", "need get bankcard is ：%s ", new Object[] { paramString });
    Iterator localIterator;
    Bankcard localBankcard;
    if ((this.VJZ != null) && (!this.VJZ.isEmpty()))
    {
      localIterator = this.VJZ.iterator();
      while (localIterator.hasNext())
      {
        localBankcard = (Bankcard)localIterator.next();
        Log.i("MicroMsg.WalletUserInfoManger", "compared offline offlinebankcards:%s", new Object[] { localBankcard.field_bindSerial });
        if (localBankcard.field_bindSerial.equals(paramString))
        {
          AppMethodBeat.o(301172);
          return localBankcard;
        }
      }
    }
    if ((this.Vkp != null) && (!this.Vkp.isEmpty()))
    {
      localIterator = this.Vkp.iterator();
      while (localIterator.hasNext())
      {
        localBankcard = (Bankcard)localIterator.next();
        Log.i("MicroMsg.WalletUserInfoManger", "compared bankcards:%s", new Object[] { localBankcard.field_bindSerial });
        if (localBankcard.field_bindSerial.equals(paramString))
        {
          AppMethodBeat.o(301172);
          return localBankcard;
        }
      }
    }
    AppMethodBeat.o(301172);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.am
 * JD-Core Version:    0.7.0.1
 */