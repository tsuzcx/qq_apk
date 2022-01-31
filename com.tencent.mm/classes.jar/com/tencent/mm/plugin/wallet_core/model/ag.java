package com.tencent.mm.plugin.wallet_core.model;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.d.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.wallet_core.ui.e.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ag
{
  public int mRetryCount = 0;
  public Bankcard qhj = null;
  public ArrayList<Bankcard> qjX = new ArrayList();
  ArrayList<Bankcard> qjY = new ArrayList();
  private ArrayList<Bankcard> qzb = new ArrayList();
  private ArrayList<Bankcard> qzc = new ArrayList();
  public af qzd = null;
  public Bankcard qze = null;
  ae qzf = null;
  public k qzg = null;
  public b qzh = null;
  private List<c> qzi = new LinkedList();
  public Bankcard qzj = null;
  public long qzk = bk.UX();
  long qzl = 0L;
  public long qzm = -1L;
  private String qzn = "";
  public int qzo = 10000;
  public String qzp = "";
  public String qzq = "";
  
  public ag()
  {
    bVX();
  }
  
  public static void Qu(String paramString)
  {
    if (!bk.bl(paramString))
    {
      g.DQ();
      g.DP().Dz().o(196612, paramString);
    }
  }
  
  private void bWe()
  {
    y.i("MicroMsg.WalletUserInfoManger", "recordDataState()");
    if (this.qzd == null) {
      y.i("MicroMsg.WalletUserInfoManger", "userInfo == null");
    }
    if (this.qjX == null)
    {
      y.i("MicroMsg.WalletUserInfoManger", "bankcards == null");
      if (this.qjY != null) {
        break label142;
      }
      y.i("MicroMsg.WalletUserInfoManger", "virtualBankcards == null");
      label49:
      if (this.qhj != null) {
        break label192;
      }
      y.i("MicroMsg.WalletUserInfoManger", "balance == null");
      label63:
      if (this.qze != null) {
        break label202;
      }
      y.i("MicroMsg.WalletUserInfoManger", "historyBankcard == null");
    }
    for (;;)
    {
      if (this.qzg != null) {
        break label212;
      }
      y.i("MicroMsg.WalletUserInfoManger", "mLoanEntryInfo == null");
      return;
      if (this.qjX.size() == 0)
      {
        y.i("MicroMsg.WalletUserInfoManger", "bankcards.size() == 0");
        break;
      }
      y.i("MicroMsg.WalletUserInfoManger", "bankcards.size() == " + this.qjX.size());
      break;
      label142:
      if (this.qjY.size() == 0)
      {
        y.i("MicroMsg.WalletUserInfoManger", "virtualBankcards.size() == 0");
        break label49;
      }
      y.i("MicroMsg.WalletUserInfoManger", "virtualBankcards.size() == " + this.qjY.size());
      break label49;
      label192:
      y.i("MicroMsg.WalletUserInfoManger", "balance != null");
      break label63;
      label202:
      y.i("MicroMsg.WalletUserInfoManger", "historyBankcard != null");
    }
    label212:
    y.i("MicroMsg.WalletUserInfoManger", "mLoanEntryInfo != null");
  }
  
  public static boolean cS(List<Bankcard> paramList)
  {
    if (paramList.size() == 0) {}
    int j;
    do
    {
      return false;
      g.DQ();
      Object localObject = (String)g.DP().Dz().get(196659, null);
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        return true;
      }
      localObject = ((String)localObject).split("&");
      if ((localObject == null) || (localObject.length == 0)) {
        return true;
      }
      int i = 0;
      j = 0;
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
    } while (j >= paramList.size());
    return true;
  }
  
  public final boolean Qt(String paramString)
  {
    if (bk.bl(paramString)) {
      return false;
    }
    Iterator localIterator;
    Bankcard localBankcard;
    if (this.qjX != null)
    {
      localIterator = this.qjX.iterator();
      while (localIterator.hasNext())
      {
        localBankcard = (Bankcard)localIterator.next();
        if ((paramString.equals(localBankcard.field_bankcardType)) && (localBankcard.bUP())) {
          return false;
        }
      }
    }
    if (this.qjY != null)
    {
      localIterator = this.qjY.iterator();
      while (localIterator.hasNext())
      {
        localBankcard = (Bankcard)localIterator.next();
        if ((paramString.equals(localBankcard.field_bankcardType)) && (localBankcard.field_bankcardState == 0)) {
          return false;
        }
      }
    }
    return true;
  }
  
  public final Bankcard a(ArrayList<Bankcard> paramArrayList, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(paramArrayList, paramString, paramBoolean1, paramBoolean2, false);
  }
  
  public final Bankcard a(ArrayList<Bankcard> paramArrayList, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Object localObject = paramArrayList;
    if (paramArrayList == null) {
      localObject = this.qjX;
    }
    paramArrayList = paramString;
    if (bk.bl(paramString))
    {
      g.DQ();
      paramArrayList = (String)g.DP().Dz().get(196612, null);
    }
    if ((paramBoolean1) && (this.qhj != null))
    {
      if (bVO())
      {
        paramString = this.qhj;
        return paramString;
      }
      if ((paramArrayList != null) && (paramArrayList.equals(this.qhj.field_bindSerial))) {
        return this.qhj;
      }
      if ((this.qzj != null) && (this.qzd != null) && (this.qzd.field_lqt_state == 1) && (paramArrayList != null) && (paramArrayList.equals(this.qzj.field_bindSerial))) {
        return this.qzj;
      }
      if ((!bVK()) && ((localObject == null) || (((ArrayList)localObject).size() == 0))) {
        return this.qhj;
      }
    }
    if ((localObject == null) || (((ArrayList)localObject).size() <= 0))
    {
      y.e("MicroMsg.WalletUserInfoManger", "not found bankcard!");
      return null;
    }
    if ((((ArrayList)localObject).size() == 1) && (paramBoolean2))
    {
      y.e("MicroMsg.WalletUserInfoManger", "only one bankcard!");
      return (Bankcard)((ArrayList)localObject).get(0);
    }
    y.i("MicroMsg.WalletUserInfoManger", "have multiple bankcards!");
    if (!bk.bl(paramArrayList))
    {
      Iterator localIterator = ((ArrayList)localObject).iterator();
      Bankcard localBankcard;
      do
      {
        while (!paramString.hasNext())
        {
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            localBankcard = (Bankcard)localIterator.next();
          } while ((localBankcard == null) || (!paramArrayList.equals(localBankcard.field_bindSerial)));
          paramString = localBankcard;
          if (!paramBoolean3) {
            break;
          }
          paramString = localBankcard;
          if (!localBankcard.bUU()) {
            break;
          }
          y.i("MicroMsg.WalletUserInfoManger", "default card is honeypay");
          if ((paramBoolean1) && (this.qhj != null)) {
            return this.qhj;
          }
          paramString = ((ArrayList)localObject).iterator();
        }
        localBankcard = (Bankcard)paramString.next();
      } while (localBankcard.bUU());
      return localBankcard;
    }
    if (paramBoolean2) {
      return (Bankcard)((ArrayList)localObject).get(0);
    }
    return null;
  }
  
  public final void a(af paramaf, ArrayList<Bankcard> paramArrayList1, ArrayList<Bankcard> paramArrayList2, Bankcard paramBankcard1, Bankcard paramBankcard2, k paramk, b paramb, Bankcard paramBankcard3, int paramInt1, int paramInt2, List<c> paramList)
  {
    y.i("MicroMsg.WalletUserInfoManger", "setBankcards scene %d", new Object[] { Integer.valueOf(paramInt2) });
    if (paramInt2 == 8) {
      this.qzb = paramArrayList1;
    }
    if ((paramInt2 == 24) || (paramInt2 == 25)) {
      this.qzc = paramArrayList1;
    }
    this.qzi = paramList;
    this.qzd = paramaf;
    this.qjX = paramArrayList1;
    this.qjY = paramArrayList2;
    this.qhj = paramBankcard1;
    this.qzf = new ae(paramaf.field_switchConfig);
    this.qze = paramBankcard2;
    this.qzg = paramk;
    this.qzh = paramb;
    this.qzj = paramBankcard3;
    y.i("MicroMsg.WalletUserInfoManger", "setBankcards()! " + paramaf.field_switchConfig);
    bWe();
    int i = paramInt1;
    if (paramInt1 < 0) {
      i = 600;
    }
    this.qzk = (bk.UX() + i);
    this.qzl = (bk.UX() + 600L);
    y.i("MicroMsg.WalletUserInfoManger", "hy: cache time: %d, dead time: %d, cacheDeadTime: %s", new Object[] { Integer.valueOf(i), Long.valueOf(this.qzk), Long.valueOf(this.qzl) });
    o.bVq().dXw.gk("WalletBankcard", "delete from WalletBankcard");
    if ((paramInt2 != 24) && (paramInt2 != 25) && (paramArrayList1 != null)) {
      o.bVq().cV(paramArrayList1);
    }
    if (paramArrayList2 != null) {
      o.bVq().cV(paramArrayList2);
    }
    if (paramBankcard1 != null) {
      o.bVq().e(paramBankcard1);
    }
    if (paramBankcard2 != null) {
      o.bVq().e(paramBankcard2);
    }
    if (paramBankcard3 != null) {
      o.bVq().e(paramBankcard3);
    }
    o.bVo().dXw.gk("WalletUserInfo", "delete from WalletUserInfo");
    o.bVo().a(paramaf);
    o.bVu().dXw.gk("LoanEntryInfo", "delete from LoanEntryInfo");
    if (paramk != null) {
      o.bVu().b(paramk);
    }
  }
  
  public final String aEZ()
  {
    if (this.qzd != null) {
      return this.qzd.field_true_name;
    }
    return null;
  }
  
  public final boolean bVK()
  {
    return (this.qzd != null) && (this.qzd.bVK());
  }
  
  public final boolean bVM()
  {
    return (this.qzd == null) || ((this.qzd != null) && (this.qzd.bVL()));
  }
  
  public final boolean bVN()
  {
    if (this.qzd != null)
    {
      if (this.qzd.field_is_reg == 1) {}
      for (int i = 1; i != 0; i = 0) {
        return true;
      }
    }
    return false;
  }
  
  public final boolean bVO()
  {
    if (this.qzd != null)
    {
      if (this.qzd.field_is_reg == 2) {}
      for (int i = 1; i != 0; i = 0) {
        return true;
      }
    }
    return false;
  }
  
  public final boolean bVP()
  {
    if (this.qzd != null)
    {
      if (this.qzd.field_is_open_touch == 1) {}
      for (int i = 1; i != 0; i = 0) {
        return true;
      }
    }
    return false;
  }
  
  public final String bVQ()
  {
    if (this.qzd != null) {
      return this.qzd.field_ftf_pay_url;
    }
    return null;
  }
  
  public final ae bVR()
  {
    if (this.qzf == null) {
      return new ae();
    }
    return this.qzf;
  }
  
  public final boolean bVS()
  {
    return (this.qzd != null) && (this.qzd.field_isDomesticUser);
  }
  
  public final int bVT()
  {
    if (this.qzd != null) {
      return this.qzd.field_cre_type;
    }
    return 1;
  }
  
  public final String bVU()
  {
    g.DQ();
    String str = (String)g.DP().Dz().get(ac.a.uxK, null);
    if (!bk.bl(str)) {
      return str;
    }
    if (this.qzd != null) {
      return this.qzd.field_lct_wording;
    }
    return null;
  }
  
  public final String bVV()
  {
    if (this.qzd != null) {
      return this.qzd.field_lct_url;
    }
    return null;
  }
  
  public final String bVW()
  {
    if (this.qzd != null) {
      return this.qzd.field_forget_passwd_url;
    }
    return "";
  }
  
  public final void bVX()
  {
    Object localObject3 = null;
    Object localObject2 = null;
    if (!g.DN().Dc())
    {
      y.w("MicroMsg.WalletUserInfoManger", "Account Not Ready!");
      return;
    }
    this.qzd = o.bVo().bWq();
    if (this.qzd != null) {}
    Object localObject1;
    Object localObject4;
    for (this.qzf = new ae(this.qzd.field_switchConfig);; this.qzf = new ae())
    {
      localObject1 = o.bVq();
      localObject4 = "select * from WalletBankcard where cardType & " + Bankcard.qto + " != 0 ";
      localObject4 = ((com.tencent.mm.plugin.wallet_core.d.c)localObject1).dXw.a((String)localObject4, null, 2);
      if (localObject4 != null) {
        break;
      }
      localObject1 = null;
      this.qhj = ((Bankcard)localObject1);
      localObject1 = o.bVq();
      localObject4 = "select * from WalletBankcard where cardType & " + Bankcard.qtr + " != 0 ";
      localObject4 = ((com.tencent.mm.plugin.wallet_core.d.c)localObject1).dXw.a((String)localObject4, null, 2);
      if (localObject4 != null) {
        break label356;
      }
      localObject1 = null;
      this.qzj = ((Bankcard)localObject1);
      com.tencent.mm.wallet_core.ui.e.a("wallet_balance", new ag.1(this));
      this.qjX = o.bVq().bVZ();
      this.qjY = o.bVq().bWo();
      localObject1 = o.bVq();
      localObject4 = "select * from WalletBankcard where cardType & " + Bankcard.qtp + " != 0 ";
      localObject4 = ((com.tencent.mm.plugin.wallet_core.d.c)localObject1).dXw.a((String)localObject4, null, 2);
      if (localObject4 != null) {
        break label390;
      }
      localObject1 = null;
      this.qze = ((Bankcard)localObject1);
      localObject4 = o.bVu().dXw.a("select * from LoanEntryInfo", null, 2);
      if (localObject4 != null) {
        break label424;
      }
      localObject1 = localObject2;
      label290:
      this.qzg = ((k)localObject1);
      y.i("MicroMsg.WalletUserInfoManger", "loadDbData!");
      bWe();
      return;
    }
    if (((Cursor)localObject4).moveToFirst())
    {
      localObject1 = new Bankcard();
      ((Bankcard)localObject1).d((Cursor)localObject4);
    }
    for (;;)
    {
      ((Cursor)localObject4).close();
      break;
      label356:
      if (((Cursor)localObject4).moveToFirst())
      {
        localObject1 = new Bankcard();
        ((Bankcard)localObject1).d((Cursor)localObject4);
      }
      for (;;)
      {
        ((Cursor)localObject4).close();
        break;
        label390:
        if (((Cursor)localObject4).moveToNext())
        {
          localObject1 = new Bankcard();
          ((Bankcard)localObject1).d((Cursor)localObject4);
        }
        for (;;)
        {
          ((Cursor)localObject4).close();
          break;
          label424:
          localObject1 = localObject3;
          if (((Cursor)localObject4).moveToFirst())
          {
            localObject1 = new k();
            ((k)localObject1).d((Cursor)localObject4);
          }
          ((Cursor)localObject4).close();
          break label290;
          localObject1 = null;
        }
        localObject1 = null;
      }
      localObject1 = null;
    }
  }
  
  public final boolean bVY()
  {
    if (com.tencent.mm.platformtools.ae.eTL) {
      return true;
    }
    g.DQ();
    int i = ((Integer)g.DP().Dz().get(ac.a.uxJ, Integer.valueOf(-1))).intValue();
    if (i != -1) {
      return i == 1;
    }
    if (this.qzd != null) {
      return this.qzd.field_lqt_state == 1;
    }
    return false;
  }
  
  public final ArrayList<Bankcard> bVZ()
  {
    if ((this.qjX == null) || (this.qjX.size() <= 0)) {
      this.qjX = o.bVq().bVZ();
    }
    if ((this.qjX == null) || (this.qjX.size() <= 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.qjX.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add((Bankcard)localIterator.next());
    }
    return localArrayList;
  }
  
  public final List<c> bWa()
  {
    if (this.qzi != null) {
      this.qzi.size();
    }
    if ((this.qzi == null) || (this.qzi.size() <= 0)) {
      return null;
    }
    return this.qzi;
  }
  
  public final ArrayList<Bankcard> bWb()
  {
    if ((this.qjX == null) || (this.qjX.size() <= 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.qjX.iterator();
    while (localIterator.hasNext())
    {
      Bankcard localBankcard = (Bankcard)localIterator.next();
      if ((!localBankcard.bUS()) && (!localBankcard.bUU())) {
        localArrayList.add(localBankcard);
      }
    }
    return localArrayList;
  }
  
  public final ArrayList<Bankcard> bWc()
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.qhj != null) && (!bVK())) {
      localArrayList.add(this.qhj);
    }
    if ((this.qzc != null) && (this.qjX != null) && (this.qzc.size() > 0))
    {
      Iterator localIterator = this.qzc.iterator();
      while (localIterator.hasNext())
      {
        Bankcard localBankcard = (Bankcard)localIterator.next();
        if (!localBankcard.bUU()) {
          localArrayList.add(localBankcard);
        }
      }
    }
    return localArrayList;
  }
  
  public final String bWd()
  {
    if ((this.qjX == null) || (this.qjX.size() <= 0)) {
      y.e("MicroMsg.WalletUserInfoManger", "not found bankcard!");
    }
    Iterator localIterator;
    do
    {
      return null;
      localIterator = this.qjX.iterator();
    } while (!localIterator.hasNext());
    return ((Bankcard)localIterator.next()).field_bindSerial;
  }
  
  public final void k(ArrayList<Bankcard> paramArrayList1, ArrayList<Bankcard> paramArrayList2)
  {
    if ((this.qjX == null) || (paramArrayList1 == null) || (paramArrayList2 == null)) {
      y.e("MicroMsg.WalletUserInfoManger", "error list, bankcards == null || bankcardsClone == null || virtualBankcardsClone == null");
    }
    for (;;)
    {
      return;
      paramArrayList1.clear();
      paramArrayList2.clear();
      Iterator localIterator;
      if (this.qjX != null)
      {
        localIterator = this.qjX.iterator();
        while (localIterator.hasNext()) {
          paramArrayList1.add((Bankcard)localIterator.next());
        }
      }
      if (this.qjY != null)
      {
        localIterator = this.qjY.iterator();
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
    }
  }
  
  public final ArrayList<Bankcard> kB(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean)
    {
      if ((this.qhj != null) && (!bVK())) {
        localArrayList.add(this.qhj);
      }
      if ((this.qzj != null) && (!bVK())) {
        localArrayList.add(this.qzj);
      }
    }
    Iterator localIterator;
    if ((this.qzb != null) && (this.qjX != null) && (this.qzb.size() == this.qjX.size()) && (this.qzb.size() > 0)) {
      localIterator = this.qzb.iterator();
    }
    while (localIterator.hasNext())
    {
      localArrayList.add((Bankcard)localIterator.next());
      continue;
      if ((this.qjX != null) && (this.qjX.size() > 0))
      {
        localIterator = this.qjX.iterator();
        while (localIterator.hasNext()) {
          localArrayList.add((Bankcard)localIterator.next());
        }
      }
    }
    return localArrayList;
  }
  
  public final ArrayList<Bankcard> kt(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean)
    {
      if ((this.qhj != null) && (!bVK())) {
        localArrayList.add(this.qhj);
      }
      if ((this.qzj != null) && (!bVK())) {
        localArrayList.add(this.qzj);
      }
    }
    if ((this.qjX != null) && (this.qjX.size() > 0))
    {
      Iterator localIterator = this.qjX.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add((Bankcard)localIterator.next());
      }
    }
    return localArrayList;
  }
  
  public final void xO()
  {
    if (this.qzd != null)
    {
      this.qzd.field_is_reg = -1;
      this.qzd = null;
    }
    if (this.qzf != null) {
      this.qzf = null;
    }
    if (this.qhj != null) {
      this.qhj = null;
    }
    if (this.qjX != null)
    {
      this.qjX.clear();
      this.qjX = null;
    }
    if (this.qjY != null)
    {
      this.qjY.clear();
      this.qjY = null;
    }
    this.qzl = 0L;
    com.tencent.mm.wallet_core.ui.e.a(new e.c[] { new e.c("wallet_balance_version", Integer.valueOf(-1)), new e.c("wallet_balance_last_update_time", Integer.valueOf(-1)), new e.c("wallet_balance", Integer.valueOf(-1)) });
    this.qzk = bk.UX();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.ag
 * JD-Core Version:    0.7.0.1
 */