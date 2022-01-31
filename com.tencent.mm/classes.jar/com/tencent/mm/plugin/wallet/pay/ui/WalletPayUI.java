package com.tencent.mm.plugin.wallet.pay.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ah.m;
import com.tencent.mm.h.a.tg;
import com.tencent.mm.h.a.to;
import com.tencent.mm.h.a.tp;
import com.tencent.mm.h.a.tp.a;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet.pay.a.c.d;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c.aa;
import com.tencent.mm.wallet_core.ui.MMScrollView;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class WalletPayUI
  extends WalletBaseUI
  implements a.a
{
  private static boolean qnk = false;
  public String frT = null;
  public int mCount = 0;
  private String nAo;
  public Button nBL;
  private com.tencent.mm.sdk.b.c nCz = new WalletPayUI.1(this);
  public PayInfo nDu = null;
  public Orders nEh = null;
  protected com.tencent.mm.plugin.wallet.a nzT = null;
  public com.tencent.mm.plugin.wallet_core.ui.o qgo;
  public ArrayList<Bankcard> qgr = null;
  public Bankcard qgs = null;
  public FavorPayInfo qmA = null;
  private a qmB;
  com.tencent.mm.plugin.wallet_core.ui.c qmC;
  private com.tencent.mm.plugin.wallet.pay.a.c qmo = null;
  protected TextView qnA;
  protected ImageView qnB;
  private TextView qnC;
  private TextView qnD;
  protected LinearLayout qnE;
  protected WalletPayUI.a qnF;
  private long qnG = 0L;
  private TextView qnH;
  private LinearLayout qnI;
  private boolean qnJ = true;
  private boolean qnK = false;
  private boolean qnL = false;
  private boolean qnM = false;
  private boolean qnN = false;
  private int qnO = -1;
  private boolean qnP = false;
  private boolean qnQ = false;
  private com.tencent.mm.plugin.wallet.pay.a.c.e qnR;
  private boolean qnS = false;
  private boolean qnT = false;
  private long qnU = 0L;
  private com.tencent.mm.plugin.wallet.pay.a.c.e qnl = null;
  protected com.tencent.mm.plugin.wallet_core.ui.a qnm = null;
  private boolean qnn = false;
  private boolean qno = false;
  public boolean qnp = false;
  protected boolean qnq = false;
  protected String qnr = "";
  protected boolean qns = false;
  public Bundle qnt = null;
  protected boolean qnu = false;
  protected TextView qnv;
  protected TextView qnw;
  private TextView qnx;
  protected TextView qny;
  protected TextView qnz;
  
  private static Bankcard Ql(String paramString)
  {
    p.bTK();
    Object localObject = p.bTL().kt(true);
    if (((ArrayList)localObject).size() != 0)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Bankcard localBankcard = (Bankcard)((Iterator)localObject).next();
        if (bk.pm(paramString).equals(localBankcard.field_bindSerial))
        {
          y.i("MicroMsg.WalletPayUI", "hy: get given bankcard");
          return localBankcard;
        }
      }
    }
    return null;
  }
  
  private void a(com.tencent.mm.plugin.wallet.pay.a.c.e parame)
  {
    y.i("MicroMsg.WalletPayUI", "stopRealname realnameGuideFlag %s guide_type %s", new Object[] { parame.cdl, Integer.valueOf(parame.qmn) });
    label100:
    Object localObject;
    label135:
    int j;
    if (("1".equals(parame.cdl)) || ("2".equals(parame.cdl)))
    {
      this.qnR = parame;
      this.qmo = parame.qmo;
      this.qnP = true;
      this.nEh = parame.nEh;
      if (this.nEh == null) {
        break label506;
      }
      i = this.nEh.qwN.size();
      this.mCount = i;
      localObject = new StringBuilder("get mOrders! bankcardTag : ");
      if (this.nEh == null) {
        break label511;
      }
      parame = Integer.valueOf(this.nEh.qqY);
      y.d("MicroMsg.WalletPayUI", parame);
      YH();
      if ((this.nEh != null) && (this.nEh.qwO != null))
      {
        this.qnm = com.tencent.mm.plugin.wallet_core.ui.b.qAd.a(this.nEh);
        if (this.qnm != null)
        {
          if (this.qnm.bWr().size() > 0) {
            this.qnn = true;
          }
          this.qmA = this.qnm.QI(this.nEh.qwO.qkW);
          this.qmA.qvC = this.qnm.QJ(this.qmA.qvC);
          y.i("MicroMsg.WalletPayUI", "onSceneEnd init favInfo id favorComposeId %s selectedFavorCompId %s selectedFavorCompId %s  mFavorPayInfo %s", new Object[] { this.nEh.qwO.qkW, this.qmA.qvC, this.qmA.qvC, this.qmA.toString() });
        }
      }
      if ((this.nEh != null) && (this.qgr != null) && (this.nDu != null))
      {
        com.tencent.mm.plugin.wallet_core.e.c.a(this.nDu, this.nEh);
        parame = com.tencent.mm.plugin.report.service.h.nFQ;
        j = this.nDu.bUV;
        p.bTK();
        if (!p.bTL().bVN()) {
          break label517;
        }
      }
    }
    label517:
    for (int i = 2;; i = 1)
    {
      parame.f(10690, new Object[] { Integer.valueOf(j), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf((int)(this.nEh.nCq * 100.0D)), this.nEh.mOZ });
      if ((this.nEh == null) || (this.nEh.qwN == null)) {
        break label581;
      }
      parame = new LinkedList();
      localObject = this.nEh.qwN.iterator();
      while (((Iterator)localObject).hasNext()) {
        parame.add(((Orders.Commodity)((Iterator)localObject).next()).bMY);
      }
      this.qnR = null;
      break;
      label506:
      i = 0;
      break label100;
      label511:
      parame = "";
      break label135;
    }
    if (parame.size() > 0)
    {
      localObject = new to();
      ((to)localObject).cdN.cdP = parame;
      com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
      if (this.nzT != null) {
        this.nzT.aO(10001, (String)parame.get(0));
      }
    }
    label581:
    p.bTK();
    this.qgr = p.bTL().kt(bTV());
    p.bTK();
    this.qgs = p.bTL().a(null, null, bTV(), false);
    parame = bk.aM(getIntent().getStringExtra("key_is_use_default_card"), "");
    if (!bk.bl(parame)) {
      this.qgs = Ql(parame);
    }
    this.nBL.setClickable(true);
    if (!bk.bl(com.tencent.mm.plugin.wallet_core.model.o.bVs().qzq))
    {
      this.qnC.setVisibility(0);
      this.qnC.setText(com.tencent.mm.plugin.wallet_core.model.o.bVs().qzq);
      if ((this.nEh != null) && (this.qgr != null) && (this.nDu != null))
      {
        com.tencent.mm.plugin.wallet_core.e.c.a(this.nDu, this.nEh);
        parame = com.tencent.mm.plugin.report.service.h.nFQ;
        j = this.nDu.bUV;
        p.bTK();
        if (!p.bTL().bVN()) {
          break label941;
        }
        i = 2;
        label751:
        parame.f(10690, new Object[] { Integer.valueOf(j), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf((int)(this.nEh.nCq * 100.0D)), this.nEh.mOZ });
      }
      if (this.qnK) {
        ac(0, false);
      }
      if (bUr().snX != null) {
        break label946;
      }
    }
    label941:
    label946:
    for (long l = 0L;; l = bUr().snX.getLong("wallet_pay_key_check_time"))
    {
      if (l > 0L)
      {
        com.tencent.mm.plugin.report.service.h.nFQ.a(641L, 4L, 1L, true);
        com.tencent.mm.plugin.report.service.h.nFQ.a(641L, 5L, bk.co(l), true);
      }
      if (this.qnU > 0L)
      {
        com.tencent.mm.plugin.report.service.h.nFQ.a(641L, 7L, 1L, true);
        com.tencent.mm.plugin.report.service.h.nFQ.a(641L, 8L, bk.co(this.qnU), true);
      }
      return;
      this.qnC.setVisibility(8);
      this.qnC.setText("");
      break;
      i = 1;
      break label751;
    }
  }
  
  private boolean b(com.tencent.mm.plugin.wallet.pay.a.c.e parame)
  {
    int i = 0;
    if ("1".equals(parame.cdl))
    {
      y.i("MicroMsg.WalletPayUI", "need realname verify");
      this.qnM = true;
      Bundle localBundle = new Bundle();
      localBundle.putString("realname_verify_process_jump_activity", ".pay.ui.WalletPayUI");
      localBundle.putString("realname_verify_process_jump_plugin", "wallet");
      String str = parame.cdm;
      str = parame.cdn;
      parame = parame.cdo;
      aSk();
      if (this.nDu != null) {
        i = this.nDu.bUV;
      }
      return com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, localBundle, null, i);
    }
    if ("2".equals(parame.cdl))
    {
      y.i("MicroMsg.WalletPayUI", "need upload credit");
      return com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, parame.cdm, parame.cdp, parame.cdn, parame.cdo, aSk(), null);
    }
    y.i("MicroMsg.WalletPayUI", "realnameGuideFlag =  " + parame.cdl);
    return false;
  }
  
  private boolean bUe()
  {
    Bundle localBundle = getIntent().getExtras();
    if ((localBundle != null) && (localBundle.containsKey("intent_pay_end")))
    {
      y.i("MicroMsg.WalletPayUI", "hy: pay end. finish the activity");
      if (localBundle.getBoolean("intent_pay_end", false))
      {
        y.d("MicroMsg.WalletPayUI", "pay done... errCode:" + localBundle.getInt("intent_pay_end_errcode"));
        y.d("MicroMsg.WalletPayUI", "pay done INTENT_PAY_APP_URL:" + localBundle.getString("intent_pay_app_url"));
        y.d("MicroMsg.WalletPayUI", "pay done INTENT_PAY_END:" + localBundle.getBoolean("intent_pay_end", false));
        f(-1, getIntent());
        this.qno = true;
        return true;
      }
      y.d("MicroMsg.WalletPayUI", "pay cancel");
      f(0, getIntent());
      this.qno = false;
      return true;
    }
    if ((localBundle != null) && (localBundle.getBoolean("key_is_realname_verify_process")))
    {
      switch (localBundle.getInt("realname_verify_process_ret", 0))
      {
      }
      return false;
    }
    y.i("MicroMsg.WalletPayUI", "hy: pay not end");
    return false;
  }
  
  private void bUg()
  {
    if (this.nEh == null)
    {
      y.e("MicroMsg.WalletPayUI", "updatePaymentMethodForFavor mOrders is null");
      return;
    }
    this.qnA.setVisibility(8);
    this.qnz.setVisibility(8);
    this.nBL.setText(a.i.wallet_pay);
    this.qnH.setVisibility(0);
    this.qnI.setVisibility(0);
    View localView = this.qnI.findViewById(a.f.balance_layout);
    Object localObject = this.qnI.findViewById(a.f.add_bankcard_layout);
    CheckedTextView localCheckedTextView1;
    CheckedTextView localCheckedTextView2;
    int i;
    if ("CFT".equals(this.nEh.qwJ))
    {
      ((View)localObject).setVisibility(8);
      localCheckedTextView1 = (CheckedTextView)this.qnI.findViewById(a.f.balance_check);
      localCheckedTextView2 = (CheckedTextView)this.qnI.findViewById(a.f.add_bank_check);
      localView.setEnabled(true);
      if ((this.nEh == null) || (this.nEh.qwN == null) || (this.nEh.qwN.size() <= 0)) {
        break label750;
      }
      if (this.nEh.qwy != 1) {
        break label552;
      }
      i = 1;
    }
    for (;;)
    {
      label186:
      if (this.qgs == null)
      {
        localView.setVisibility(8);
        label199:
        ((View)localObject).setOnClickListener(new WalletPayUI.31(this, localCheckedTextView1, localCheckedTextView2));
        this.qnH.setVisibility(0);
        this.qnI.setVisibility(0);
        if (this.qmA == null) {
          break label745;
        }
        this.qnm = com.tencent.mm.plugin.wallet_core.ui.b.qAd.a(this.nEh);
        localObject = this.qnm.QF(this.qmA.qvC);
        if ((localObject == null) || (((com.tencent.mm.plugin.wallet.a.h)localObject).qkV != 0.0D)) {
          break label745;
        }
        this.qnI.setVisibility(8);
        this.qnH.setVisibility(8);
      }
      label470:
      label745:
      for (int j = 1;; j = 0)
      {
        this.qnJ = true;
        if (j != 0) {
          this.qnJ = false;
        }
        localCheckedTextView1.setChecked(false);
        localCheckedTextView2.setChecked(true);
        y.i("MicroMsg.WalletPayUI", "updatePaymentMethodForFavor needbindcardtoshowfavinfo is " + this.nEh.qwP);
        if (this.nEh.qwP == 1)
        {
          this.qnI.findViewById(a.f.discount_wording_layout).setVisibility(0);
          ((TextView)this.qnI.findViewById(a.f.discount_wording)).setText(this.nEh.qwQ);
          if (!TextUtils.isEmpty(this.nEh.qwR))
          {
            ((TextView)this.qnI.findViewById(a.f.favor_rule_wording)).setText(" (" + this.nEh.qwR + ")");
            if ((this.qgs != null) && (this.qgs.bUQ()) && (!TextUtils.isEmpty(this.qgs.field_forbidWord)))
            {
              localView.setEnabled(false);
              localCheckedTextView1.setVisibility(8);
              ((TextView)this.qnI.findViewById(a.f.balance_tips)).setText(this.qgs.field_forbidWord);
            }
          }
        }
        for (;;)
        {
          bUh();
          return;
          ((View)localObject).setVisibility(0);
          break;
          i = 0;
          break label186;
          localView.setVisibility(0);
          localView.setOnClickListener(new WalletPayUI.30(this, localCheckedTextView1, localCheckedTextView2));
          break label199;
          ((TextView)this.qnI.findViewById(a.f.favor_rule_wording)).setText("");
          break label470;
          this.qnI.findViewById(a.f.discount_wording_layout).setVisibility(8);
          if ((this.qgs != null) && (this.qgs.bUQ()) && (!TextUtils.isEmpty(this.qgs.field_forbidWord)))
          {
            localView.setEnabled(false);
            localCheckedTextView1.setVisibility(8);
            ((TextView)this.qnI.findViewById(a.f.balance_tips)).setText(this.qgs.field_forbidWord);
          }
          else if ((this.qgs != null) && (this.qgs.bUQ()) && (TextUtils.isEmpty(this.qgs.field_forbidWord)) && (i == 0))
          {
            localCheckedTextView1.setChecked(true);
            localCheckedTextView2.setChecked(false);
            this.qnJ = false;
          }
        }
      }
      label552:
      label750:
      i = 0;
    }
  }
  
  private void bUh()
  {
    if (this.qnJ)
    {
      this.nBL.setOnClickListener(new WalletPayUI.2(this));
      return;
    }
    this.nBL.setOnClickListener(new WalletPayUI.3(this));
  }
  
  private void bUm()
  {
    int i = 1;
    int j = 0;
    int k = 0;
    com.tencent.mm.plugin.report.service.h.nFQ.f(13958, new Object[] { Integer.valueOf(1) });
    if ((this.nDu != null) && (8 == this.nDu.bUV))
    {
      com.tencent.mm.plugin.report.service.h.nFQ.f(13955, new Object[] { Integer.valueOf(2) });
      if (this.nDu.snX != null)
      {
        long l = this.nDu.snX.getLong("extinfo_key_9");
        com.tencent.mm.plugin.report.service.h.nFQ.f(13956, new Object[] { Integer.valueOf(1), Long.valueOf(System.currentTimeMillis() - l) });
      }
    }
    Object localObject;
    if (this.qmA != null)
    {
      this.qnm = com.tencent.mm.plugin.wallet_core.ui.b.qAd.a(this.nEh);
      localObject = this.qnm.QF(this.qmA.qvC);
      if ((localObject == null) || (((com.tencent.mm.plugin.wallet.a.h)localObject).qkV != 0.0D)) {}
    }
    for (;;)
    {
      if (i != 0)
      {
        p.bTK();
        if (p.bTL().bVO())
        {
          y.i("MicroMsg.WalletPayUI", "payWithoutPassword zeroPay");
          if (this.nDu == null)
          {
            i = k;
            if (this.nDu != null) {
              break label244;
            }
          }
          label244:
          for (localObject = "";; localObject = this.nDu.bMX)
          {
            aa.d(i, (String)localObject, 3, "");
            bUn();
            return;
            i = this.nDu.bUV;
            break;
          }
        }
        y.i("MicroMsg.WalletPayUI", "has useful bankcard ! payWithOldBankcard zeroPay");
        bTY();
        return;
      }
      if (this.qnq)
      {
        y.i("MicroMsg.WalletPayUI", "hy: start do pay with force use given bankcard");
        if (!bk.bl(this.qnr))
        {
          this.qgs = bUp();
          bTY();
          return;
        }
        p.bTK();
        if (p.bTL().bVK()) {
          if (this.nDu == null)
          {
            i = 0;
            if (this.nDu != null) {
              break label370;
            }
            localObject = "";
            label340:
            aa.d(i, (String)localObject, 17, "");
          }
        }
        label370:
        do
        {
          b(false, 0, "");
          return;
          i = this.nDu.bUV;
          break;
          localObject = this.nDu.bMX;
          break label340;
          p.bTK();
        } while (!p.bTL().bVO());
        if (this.nDu == null)
        {
          i = 0;
          label404:
          if (this.nDu != null) {
            break label438;
          }
        }
        label438:
        for (localObject = "";; localObject = this.nDu.bMX)
        {
          aa.d(i, (String)localObject, 5, "");
          break;
          i = this.nDu.bUV;
          break label404;
        }
      }
      localObject = bk.aM(getIntent().getStringExtra("key_is_use_default_card"), "");
      if (!bk.bl((String)localObject)) {
        this.qgs = Ql((String)localObject);
      }
      if (this.qgs == null)
      {
        if ((this.qgr != null) && (this.qgr.size() > 0))
        {
          y.i("MicroMsg.WalletPayUI", " no last pay bankcard ! jump to select bankcard!");
          c(false, 8, "");
          return;
        }
        y.i("MicroMsg.WalletPayUI", "default bankcard not found! payWithNewBankcard");
        p.bTK();
        if (p.bTL().bVK()) {
          if (this.nDu == null)
          {
            i = 0;
            if (this.nDu != null) {
              break label597;
            }
            localObject = "";
            label567:
            aa.d(i, (String)localObject, 17, "");
          }
        }
        label597:
        do
        {
          b(false, 0, "");
          return;
          i = this.nDu.bUV;
          break;
          localObject = this.nDu.bMX;
          break label567;
          p.bTK();
        } while (!p.bTL().bVO());
        if (this.nDu == null)
        {
          i = 0;
          label631:
          if (this.nDu != null) {
            break label665;
          }
        }
        label665:
        for (localObject = "";; localObject = this.nDu.bMX)
        {
          aa.d(i, (String)localObject, 5, "");
          break;
          i = this.nDu.bUV;
          break label631;
        }
      }
      i = this.qgs.a(this.nEh.qqY, this.nEh);
      if (this.nzT != null) {
        this.nzT.aO(10002, "");
      }
      if (i != 0)
      {
        y.i("MicroMsg.WalletPayUI", "main bankcard(" + i + ") is useless! jump to select bankcard!");
        c(false, i, "");
        return;
      }
      p.bTK();
      if (p.bTL().bVO())
      {
        y.i("MicroMsg.WalletPayUI", "payWithoutPassword");
        if (this.nDu == null)
        {
          i = j;
          if (this.nDu != null) {
            break label822;
          }
        }
        label822:
        for (localObject = "";; localObject = this.nDu.bMX)
        {
          aa.d(i, (String)localObject, 3, "");
          bUn();
          return;
          i = this.nDu.bUV;
          break;
        }
      }
      y.i("MicroMsg.WalletPayUI", "has useful bankcard ! payWithOldBankcard");
      bTY();
      return;
      i = 0;
    }
  }
  
  private void bUn()
  {
    kx(true);
    com.tencent.mm.plugin.wallet_core.e.c.bXt();
  }
  
  private Bankcard bUp()
  {
    p.bTK();
    Object localObject = p.bTL().kt(true);
    if (((ArrayList)localObject).size() != 0)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Bankcard localBankcard = (Bankcard)((Iterator)localObject).next();
        if (bk.pm(this.qnr).equals(localBankcard.field_bindSerial))
        {
          y.i("MicroMsg.WalletPayUI", "hy: get given bankcard");
          return localBankcard;
        }
      }
    }
    return null;
  }
  
  private boolean bUq()
  {
    if (aSk())
    {
      vN(4);
      return false;
    }
    vN(0);
    return true;
  }
  
  private void f(int paramInt, Intent paramIntent)
  {
    if ((this.nDu != null) && (this.nDu.bUV == 46) && (this.nEh != null))
    {
      paramIntent.putExtra("key_total_fee", this.nEh.nCq);
      y.i("MicroMsg.WalletPayUI", "sentCancelEvent set fee:%s", new Object[] { Double.valueOf(this.nEh.nCq) });
    }
    tp localtp = new tp();
    localtp.cdQ.intent = paramIntent;
    localtp.cdQ.result = paramInt;
    tp.a locala = localtp.cdQ;
    if (this.nDu == null) {}
    for (paramIntent = "";; paramIntent = this.nDu.bMX)
    {
      locala.bMX = paramIntent;
      localtp.cdQ.cdR = 1;
      if ((this.nDu != null) && (paramInt == 0)) {
        com.tencent.mm.plugin.wallet.pay.a.b.b.ad(this.nDu.bMX, this.nDu.bUV, this.nDu.bUR);
      }
      com.tencent.mm.sdk.b.a.udP.m(localtp);
      return;
    }
  }
  
  public void I(Bundle paramBundle)
  {
    this.qnp = true;
    if (this.nEh != null)
    {
      paramBundle.putInt("key_support_bankcard", this.nEh.qqY);
      paramBundle.putString("key_reqKey", this.nEh.bMX);
      if ((this.nEh.qwN != null) && (this.nEh.qwN.size() > 0)) {
        paramBundle.putString("key_TransId", ((Orders.Commodity)this.nEh.qwN.get(0)).bMY);
      }
      paramBundle.putLong("key_SessionId", this.qnG);
    }
    if (this.nDu != null) {
      paramBundle.putInt("key_scene", this.nDu.bUV);
    }
    if (!bUk()) {}
    for (boolean bool = true;; bool = false)
    {
      paramBundle.putBoolean("key_is_oversea", bool);
      paramBundle.putInt("is_deduct_open", this.qnO);
      com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.pay.b.class, paramBundle, new WalletPayUI.25(this));
      return;
    }
  }
  
  public final boolean YH()
  {
    if ((this.nEh == null) || (this.nEh.qwN == null) || (this.nEh.qwN.size() <= 0))
    {
      y.w("MicroMsg.WalletPayUI", "mOrders info is Illegal!");
      if ((this.qnl == null) || (!this.qnl.cMv())) {}
    }
    do
    {
      return false;
      com.tencent.mm.ui.base.h.a(this.mController.uMN, a.i.wallet_order_info_err, 0, new WalletPayUI.18(this));
      return false;
      if ((!this.qnq) || (bk.bl(this.qnr)) || (bUp() != null)) {
        break;
      }
    } while ((this.qnl != null) && (this.qnl.cMv()));
    y.w("MicroMsg.WalletPayUI", "hy: should use given bankcard, but resolved as null. show error msg and quit");
    com.tencent.mm.ui.base.h.a(this.mController.uMN, a.i.wallet_order_info_err, 0, new WalletPayUI.19(this));
    return false;
    return true;
  }
  
  public final boolean aSk()
  {
    if (this.qnP)
    {
      boolean bool1;
      label69:
      int i;
      if ((bUr() == null) || (!bUr().kPR))
      {
        bool1 = true;
        y.i("MicroMsg.WalletPayUI", "case 1 %s,  stack %s", new Object[] { Boolean.valueOf(bool1), bk.csb().toString() });
        p.bTK();
        if (p.bTL().bVN()) {
          break label164;
        }
        bool1 = true;
        y.d("MicroMsg.WalletPayUI", "case 2 %s,", new Object[] { Boolean.valueOf(bool1) });
        if (this.qgr != null) {
          break label169;
        }
        i = 0;
        label97:
        if (this.qgs != null) {
          break label180;
        }
      }
      label164:
      label169:
      label180:
      for (String str = "";; str = this.qgs.field_forbidWord)
      {
        y.d("MicroMsg.WalletPayUI", "case 3 mBankcardList %s, mDefaultBankcard %s", new Object[] { Integer.valueOf(i), str });
        if ((bUr() != null) && (bUr().kPR)) {
          break label192;
        }
        y.i("MicroMsg.WalletPayUI", "get isTransparent1");
        return false;
        bool1 = false;
        break;
        bool1 = false;
        break label69;
        i = this.qgr.size();
        break label97;
      }
      label192:
      p.bTK();
      if (!p.bTL().bVN())
      {
        y.i("MicroMsg.WalletPayUI", "get isTransparent2");
        return false;
      }
      if ((this.qgr != null) && ((this.qgr.size() == 0) || ((this.qgs != null) && (!bk.bl(this.qgs.field_forbidWord)))))
      {
        if ((this.qgr != null) && (this.qgr.size() == 0))
        {
          bool1 = true;
          if ((this.qgs == null) || (bk.bl(this.qgs.field_forbidWord))) {
            break label326;
          }
        }
        label326:
        for (boolean bool2 = true;; bool2 = false)
        {
          y.i("MicroMsg.WalletPayUI", "get isTransparent3 1 %s 2 %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
          return false;
          bool1 = false;
          break;
        }
      }
      y.i("MicroMsg.WalletPayUI", "get isTransparent4");
      return true;
    }
    y.i("MicroMsg.WalletPayUI", "get isTransparent5");
    return true;
  }
  
  protected final boolean aSl()
  {
    boolean bool2 = false;
    y.i("MicroMsg.WalletPayUI", "onProgressFinish isFromH5RealNameVerify %s", new Object[] { Boolean.valueOf(this.qnS) });
    com.tencent.mm.sdk.b.a.udP.m(new tg());
    int i;
    int j;
    label85:
    Object localObject;
    label96:
    boolean bool1;
    if ((this.nEh != null) && (this.nEh.qwS != null) && (!this.qnN))
    {
      i = 1;
      if ((i == 0) && (!bUq()))
      {
        if (this.nDu != null) {
          break label126;
        }
        j = 0;
        if (this.nDu != null) {
          break label137;
        }
        localObject = "";
        aa.d(j, (String)localObject, 2, "");
      }
      if (!this.qnS) {
        break label149;
      }
      kw(true);
      bool1 = true;
    }
    label126:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return bool1;
              i = 0;
              break;
              j = this.nDu.bUV;
              break label85;
              localObject = this.nDu.bMX;
              break label96;
              if (this.qnM) {
                return true;
              }
              if (i != 0)
              {
                localObject = new Intent(this, WalletPayDeductUI.class);
                ((Intent)localObject).putExtra("orders", this.nEh);
                startActivityForResult((Intent)localObject, 0);
                return true;
              }
              if (this.mController.contentView.getVisibility() != 0)
              {
                if ((!this.qnu) && (YH()))
                {
                  kw(true);
                  this.qnu = true;
                }
                return true;
              }
              bool1 = bool2;
            } while (this.mController.contentView.getVisibility() != 0);
            bool1 = bool2;
          } while (this.nEh == null);
          bool1 = bool2;
        } while (this.nEh.qwS == null);
        bool1 = bool2;
      } while (!this.nBL.isEnabled());
      bool1 = bool2;
    } while (this.qnQ);
    label137:
    label149:
    this.nBL.performClick();
    this.qnQ = true;
    return false;
  }
  
  public final void aZ()
  {
    if ((this.nEh != null) && (this.nEh.qwN != null) && (this.nEh.qwN.size() > 0))
    {
      this.qnv.setText(com.tencent.mm.wallet_core.ui.e.A(this.nEh.nCq));
      this.qny.setText(com.tencent.mm.wallet_core.ui.e.afh(this.nEh.mOZ));
      this.qnF.notifyDataSetChanged();
      if (this.nEh.qwN.size() > 1)
      {
        this.qnB.setVisibility(0);
        this.qnw.setText(getString(a.i.wallet_pay_ui_title_desc, new Object[] { ((Orders.Commodity)this.nEh.qwN.get(0)).desc, this.nEh.qwN.size() }));
        this.qns = false;
        i = this.nEh.qwy;
      }
    }
    else
    {
      if ((this.nDu != null) && (this.nDu.bUV == 48)) {
        this.qnw.setText(a.i.qr_reward_grant_btn);
      }
      this.qnz.setVisibility(8);
      this.qnA.setVisibility(8);
      this.qnH.setVisibility(8);
      this.qnI.setVisibility(8);
      this.nBL.setText(a.i.wallet_pay);
      if ((this.qgs == null) || (!this.qgs.bUQ())) {
        break label538;
      }
      if (bk.bl(this.qgs.field_forbidWord)) {
        break label518;
      }
      this.qnz.setText(this.qgs.field_forbidWord);
      this.qnz.setVisibility(4);
      this.qnA.setVisibility(8);
      p.bTK();
      if (p.bTL().bVO()) {
        bUg();
      }
      label331:
      p.bTK();
      if (!p.bTL().bVO())
      {
        p.bTK();
        if (!p.bTL().bVK()) {
          break label586;
        }
      }
    }
    label426:
    label567:
    label586:
    for (int i = 1;; i = 0)
    {
      LinearLayout localLinearLayout = (LinearLayout)findViewById(a.f.wallet_order_info_favor_ll);
      if ((i != 0) && (this.qmA != null) && (this.qnm != null) && (this.qnn) && (this.nEh != null))
      {
        bUi();
        this.qnD.setOnClickListener(new WalletPayUI.29(this));
        localLinearLayout.setVisibility(0);
        if ((this.nEh == null) || (this.qgr == null) || (this.nDu == null)) {
          break label567;
        }
        this.nBL.setClickable(true);
        this.nBL.setEnabled(true);
      }
      for (;;)
      {
        if (this.nEh == null) {
          this.qnA.setVisibility(8);
        }
        return;
        this.qnw.setText(((Orders.Commodity)this.nEh.qwN.get(0)).desc);
        this.qnB.setVisibility(8);
        break;
        p.bTK();
        if (!p.bTL().bVO()) {
          break label331;
        }
        bUg();
        break label331;
        p.bTK();
        if (!p.bTL().bVK()) {
          break label331;
        }
        bUg();
        break label331;
        localLinearLayout.setVisibility(8);
        break label426;
        this.nBL.setClickable(false);
        this.nBL.setEnabled(false);
      }
    }
  }
  
  protected final void ac(int paramInt, boolean paramBoolean)
  {
    int i = 0;
    com.tencent.mm.plugin.report.service.h.nFQ.f(13958, new Object[] { Integer.valueOf(2) });
    com.tencent.mm.plugin.report.service.h.nFQ.f(13955, new Object[] { Integer.valueOf(4) });
    if (this.nDu == null) {
      if (this.nDu != null) {
        break label214;
      }
    }
    label214:
    for (Object localObject = "";; localObject = this.nDu.bMX)
    {
      aa.d(i, (String)localObject, 11, "");
      localObject = this.BX;
      ((Bundle)localObject).putInt("key_main_bankcard_state", paramInt);
      ((Bundle)localObject).putParcelable("key_orders", this.nEh);
      ((Bundle)localObject).putParcelable("key_pay_info", this.nDu);
      ((Bundle)localObject).putParcelable("key_authen", bUj());
      ((Bundle)localObject).putString("key_pwd1", this.frT);
      ((Bundle)localObject).putInt("key_pay_flag", 3);
      ((Bundle)localObject).putInt("key_err_code", -1004);
      ((Bundle)localObject).putParcelable("key_favor_pay_info", this.qmA);
      ((Bundle)localObject).putBoolean("key_is_filter_bank_type", paramBoolean);
      if (this.qgs != null) {
        ((Bundle)localObject).putString("key_is_cur_bankcard_bind_serial", this.qgs.field_bindSerial);
      }
      I((Bundle)localObject);
      return;
      i = this.nDu.bUV;
      break;
    }
  }
  
  public final void b(boolean paramBoolean, int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("pay with new bankcard! user's wxpay register status :");
    p.bTK();
    y.d("MicroMsg.WalletPayUI", p.bTL().bVN() + ", need confirm ? " + paramBoolean);
    if (paramBoolean)
    {
      if (!bk.bl(paramString)) {
        break label106;
      }
      paramString = Bankcard.N(this, paramInt);
    }
    label106:
    for (;;)
    {
      com.tencent.mm.ui.base.h.a(this, paramString, "", getString(a.i.wallet_pay_bankcard_add), getString(a.i.app_cancel), new WalletPayUI.10(this), new WalletPayUI.11(this));
      return;
      bUo();
      return;
    }
  }
  
  public final void b(boolean paramBoolean, String paramString1, String paramString2)
  {
    y.i("MicroMsg.WalletPayUI", "onGenFinish callback");
    if (paramBoolean)
    {
      y.i("MicroMsg.WalletPayUI", "onGenFinish callback, result.isSuccess is true");
      this.nDu.bOU = paramString1;
      this.nDu.bOV = paramString2;
      kx(false);
      com.tencent.mm.plugin.wallet_core.e.c.bXt();
      return;
    }
    y.e("MicroMsg.WalletPayUI", "onGenFinish callback, result.isSuccess is false");
    kx(false);
    com.tencent.mm.plugin.wallet_core.e.c.bXt();
  }
  
  public final boolean bTV()
  {
    return (this.nDu != null) && (this.nDu.bUV != 11);
  }
  
  public void bTY()
  {
    boolean bool = false;
    if (!YH()) {
      return;
    }
    y.i("MicroMsg.WalletPayUI", "pay with old bankcard! from statck %s", new Object[] { bk.csb().toString() });
    int i;
    if (this.nDu == null)
    {
      i = 0;
      if (this.nDu != null) {
        break label141;
      }
    }
    label141:
    for (String str = "";; str = this.nDu.bMX)
    {
      aa.d(i, str, 8, "");
      if (!this.qnq) {
        bool = true;
      }
      this.qgo = com.tencent.mm.plugin.wallet_core.ui.o.a(this, bool, this.nEh, this.qmA, this.qgs, this.nDu, this.nAo, new WalletPayUI.7(this), new WalletPayUI.8(this), new WalletPayUI.9(this));
      this.qmC = this.qgo;
      return;
      i = this.nDu.bUV;
      break;
    }
  }
  
  protected final boolean bTZ()
  {
    return true;
  }
  
  public void bUf()
  {
    int i = 2;
    com.tencent.mm.plugin.report.service.h.nFQ.f(11850, new Object[] { Integer.valueOf(2), Integer.valueOf(this.nDu.bUV) });
    if (this.nDu.bUV == 11)
    {
      i = 3;
      if (com.tencent.mm.plugin.wallet.b.a.bUG())
      {
        this.nEh = new Orders();
        localObject = new Orders.Commodity();
        ((Orders.Commodity)localObject).mOO = getString(a.i.wallet_balance_manager_save);
        this.nEh.qwN.add(localObject);
        this.nEh.nCq = this.nDu.soe;
        this.nEh.mOZ = "CNY";
        kw(true);
        this.qnu = true;
        return;
      }
    }
    Object localObject = this.nDu;
    if ((localObject == null) || (bk.bl(((PayInfo)localObject).bMX)))
    {
      y.i("MicroMsg.CgiManager", "no payInfo or reqKey");
      localObject = null;
      label164:
      if (localObject == null) {
        break label445;
      }
      ((com.tencent.mm.wallet_core.c.s)localObject).dIA = "PayProcess";
      ((com.tencent.mm.wallet_core.c.s)localObject).fKz = this.qnG;
      if ((this.nDu.bUV != 6) || (this.nDu.snU != 100)) {
        break label447;
      }
      ((com.tencent.mm.wallet_core.c.s)localObject).fzn = 100;
      label213:
      if (!this.nDu.snV) {
        break label461;
      }
    }
    label445:
    label447:
    label461:
    for (boolean bool = true;; bool = false)
    {
      a((m)localObject, true, bool);
      return;
      String str = ((PayInfo)localObject).bMX;
      y.i("MicroMsg.CgiManager", "qrorderinfo reqKey: %s", new Object[] { str });
      y.i("MicroMsg.CgiManager", "qrorderinfo go new split cgi");
      if (str.startsWith("sns_aa_"))
      {
        localObject = new com.tencent.mm.plugin.wallet.pay.a.c.a((PayInfo)localObject, i);
        break label164;
      }
      if (str.startsWith("sns_tf_"))
      {
        localObject = new com.tencent.mm.plugin.wallet.pay.a.c.g((PayInfo)localObject, i);
        break label164;
      }
      if (str.startsWith("sns_ff_"))
      {
        localObject = new com.tencent.mm.plugin.wallet.pay.a.c.b((PayInfo)localObject, i);
        break label164;
      }
      if (str.startsWith("ts_"))
      {
        localObject = new com.tencent.mm.plugin.wallet.pay.a.c.c((PayInfo)localObject, i);
        break label164;
      }
      if (str.startsWith("sns_"))
      {
        localObject = new com.tencent.mm.plugin.wallet.pay.a.c.f((PayInfo)localObject, i);
        break label164;
      }
      if (str.startsWith("offline_"))
      {
        localObject = new d((PayInfo)localObject, i);
        break label164;
      }
      if (str.startsWith("up_"))
      {
        localObject = new com.tencent.mm.plugin.wallet.pay.a.c.h((PayInfo)localObject, i);
        break label164;
      }
      localObject = new com.tencent.mm.plugin.wallet.pay.a.c.e((PayInfo)localObject, i);
      break label164;
      break;
      ((com.tencent.mm.wallet_core.c.s)localObject).fzn = this.nDu.bUV;
      break label213;
    }
  }
  
  public final void bUi()
  {
    com.tencent.mm.plugin.wallet.a.h localh = this.qnm.QF(this.qmA.qvC);
    List localList = this.qnm.bWr();
    com.tencent.mm.plugin.wallet.a.f localf = this.qnm.qzX;
    Object localObject1 = "";
    double d2;
    Object localObject2;
    int i;
    double d1;
    if (localh != null)
    {
      d2 = localh.qld;
      if (d2 > 0.0D)
      {
        localObject2 = localh.qlf;
        int j = 1;
        localObject1 = localObject2;
        i = j;
        d1 = d2;
        if (!bk.bl(localh.qlg))
        {
          localObject1 = (String)localObject2 + "," + localh.qlg;
          d1 = d2;
          i = j;
        }
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (i == 0)
      {
        localObject2 = localObject1;
        if (localList.size() > 0) {
          localObject2 = (String)localObject1 + this.mController.uMN.getString(a.i.wallet_pwd_dialog_more_favors);
        }
      }
      if ((d1 > 0.0D) && (localf != null) && (localf.qkZ == 0))
      {
        if (localh != null) {
          this.qnv.setText(com.tencent.mm.wallet_core.ui.e.A(localh.qlc));
        }
        this.qny.setText(com.tencent.mm.wallet_core.ui.e.afh(this.nEh.mOZ));
        this.qnx.setText(com.tencent.mm.wallet_core.ui.e.d(this.nEh.nCq, this.nEh.mOZ));
        this.qnx.setVisibility(0);
      }
      for (;;)
      {
        if (!bk.bl((String)localObject2)) {
          this.qnD.setText((CharSequence)localObject2);
        }
        return;
        this.qnv.setText(com.tencent.mm.wallet_core.ui.e.A(this.nEh.nCq));
        this.qny.setText(com.tencent.mm.wallet_core.ui.e.afh(this.nEh.mOZ));
        this.qnx.setVisibility(8);
      }
      i = 0;
      d1 = d2;
      continue;
      i = 0;
      d1 = 0.0D;
    }
  }
  
  public final Authen bUj()
  {
    Authen localAuthen = new Authen();
    if (bUk()) {}
    for (localAuthen.bcw = 3;; localAuthen.bcw = 6)
    {
      if (!bk.bl(this.frT)) {
        localAuthen.qsI = this.frT;
      }
      if (this.qgs != null)
      {
        localAuthen.mOc = this.qgs.field_bindSerial;
        localAuthen.mOb = this.qgs.field_bankcardType;
      }
      if (this.qmA != null)
      {
        localAuthen.qsU = this.qmA.qvC;
        localAuthen.qsT = this.qmA.qvF;
      }
      localAuthen.nqa = this.nDu;
      return localAuthen;
    }
  }
  
  public final boolean bUk()
  {
    if ((this.qgs != null) && (this.nEh != null) && (this.nEh.qqY == 3)) {
      if (!this.qgs.bUT()) {}
    }
    while ((this.nEh != null) && (!Bankcard.AM(this.nEh.qqY)))
    {
      return true;
      return false;
    }
    return false;
  }
  
  protected final void bUl()
  {
    kw(true);
  }
  
  protected final void bUo()
  {
    Bundle localBundle = getIntent().getExtras();
    p.bTK();
    if (p.bTL().bVN()) {}
    for (int i = 2;; i = 1)
    {
      localBundle.putInt("key_pay_flag", i);
      localBundle.putParcelable("key_orders", this.nEh);
      localBundle.putParcelable("key_pay_info", this.nDu);
      localBundle.putParcelable("key_favor_pay_info", this.qmA);
      I(localBundle);
      return;
    }
  }
  
  public final PayInfo bUr()
  {
    if (this.nDu == null) {
      this.nDu = ((PayInfo)getIntent().getParcelableExtra("key_pay_info"));
    }
    return this.nDu;
  }
  
  public final boolean bgK()
  {
    return false;
  }
  
  public final void c(boolean paramBoolean, int paramInt, String paramString)
  {
    y.d("MicroMsg.WalletPayUI", "pay with select bankcard! need confirm ? " + paramBoolean);
    if (paramBoolean)
    {
      if (!bk.bl(paramString)) {
        break label86;
      }
      paramString = Bankcard.N(this, paramInt);
    }
    label86:
    for (;;)
    {
      com.tencent.mm.ui.base.h.a(this, paramString, "", getString(a.i.wallet_pay_bankcard_select), getString(a.i.app_cancel), new WalletPayUI.13(this, paramInt), new WalletPayUI.14(this));
      return;
      ac(paramInt, false);
      return;
    }
  }
  
  public boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.WalletPayUI", "errorType %s errCode %s, errmsg %s, scene %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramm });
    boolean bool;
    Object localObject;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramm instanceof com.tencent.mm.plugin.wallet.pay.a.c.e))
      {
        this.qnl = ((com.tencent.mm.plugin.wallet.pay.a.c.e)paramm);
        paramString = (com.tencent.mm.plugin.wallet.pay.a.c.e)paramm;
        if (paramString.cMv())
        {
          paramm = paramString.lQQ;
          paramm.a(this, new WalletPayUI.15(this, paramm, paramString));
          return true;
        }
        a(paramString);
      }
      while (!(paramm instanceof com.tencent.mm.plugin.wallet.pay.a.a.b))
      {
        aZ();
        return true;
      }
      paramm = (com.tencent.mm.plugin.wallet.pay.a.a.b)paramm;
      paramString = this.BX;
      paramString.putParcelable("key_pay_info", this.nDu);
      paramString.putParcelable("key_bankcard", this.qgs);
      paramString.putString("key_bank_type", this.qgs.field_bankcardType);
      if (!bk.bl(this.frT)) {
        paramString.putString("key_pwd1", this.frT);
      }
      paramString.putString("kreq_token", paramm.token);
      paramString.putParcelable("key_authen", paramm.qmd);
      if (!paramm.qmb)
      {
        bool = true;
        paramString.putBoolean("key_need_verify_sms", bool);
        paramString.putInt("key_can_verify_tail", paramm.qmh);
        paramString.putString("key_verify_tail_wording", paramm.qmi);
        localObject = this.BX;
        if (paramm.qmj != 1) {
          break label553;
        }
        bool = true;
        label273:
        ((Bundle)localObject).putBoolean("key_block_bind_new_card", bool);
        if (!bk.bl(paramm.qme)) {
          break label559;
        }
        paramString.putString("key_mobile", this.qgs.field_mobile);
        label308:
        paramString.putString("key_QADNA_URL", paramm.qmf);
        if (!paramm.qno) {
          break label574;
        }
        if (this.nzT != null)
        {
          this.nzT.aO(10003, "");
          localObject = this.nzT;
          com.tencent.mm.plugin.report.service.h.nFQ.f(13455, new Object[] { ((com.tencent.mm.plugin.wallet.a)localObject).qff, Long.valueOf(System.currentTimeMillis()), ((com.tencent.mm.plugin.wallet.a)localObject).qfg });
        }
        paramString.putParcelable("key_orders", paramm.qmc);
        if (this.nDu != null)
        {
          y.i("MicroMsg.WalletPayUI", "payscene %d", new Object[] { Integer.valueOf(this.nDu.bUV) });
          if (8 == this.nDu.bUV)
          {
            com.tencent.mm.kernel.g.DQ();
            com.tencent.mm.kernel.g.DP().Dz().c(ac.a.utD, Boolean.valueOf(true));
          }
        }
      }
      for (;;)
      {
        localObject = new Bundle();
        ((Bundle)localObject).putString("pwd", this.frT);
        ((com.tencent.mm.pluginsdk.k)com.tencent.mm.kernel.g.r(com.tencent.mm.pluginsdk.k.class)).a(paramm.bTQ(), true, (Bundle)localObject);
        paramString.putInt("key_pay_flag", 3);
        paramm = paramm.mKP;
        if (paramm != null) {
          paramString.putParcelable("key_realname_guide_helper", paramm);
        }
        I(paramString);
        return true;
        bool = false;
        break;
        label553:
        bool = false;
        break label273;
        label559:
        paramString.putString("key_mobile", paramm.qme);
        break label308;
        label574:
        paramString.putParcelable("key_orders", this.nEh);
      }
    }
    if ((paramm instanceof com.tencent.mm.plugin.wallet.pay.a.a.b))
    {
      localObject = new Bundle();
      ((Bundle)localObject).putString("pwd", this.frT);
      com.tencent.mm.pluginsdk.k localk = (com.tencent.mm.pluginsdk.k)com.tencent.mm.kernel.g.r(com.tencent.mm.pluginsdk.k.class);
      if (this.nDu.qFX == 1) {}
      for (bool = true;; bool = false)
      {
        localk.a(bool, false, (Bundle)localObject);
        switch (paramInt2)
        {
        default: 
          return false;
        }
      }
      paramm = (com.tencent.mm.plugin.wallet.pay.a.a.b)paramm;
      this.qnt = this.BX;
      this.qnt.putParcelable("key_pay_info", this.nDu);
      this.qnt.putParcelable("key_bankcard", this.qgs);
      if (!bk.bl(this.frT)) {
        this.qnt.putString("key_pwd1", this.frT);
      }
      this.qnt.putString("kreq_token", paramm.token);
      this.qnt.putParcelable("key_authen", paramm.qmd);
      localObject = this.qnt;
      if (!paramm.qmb)
      {
        bool = true;
        label862:
        ((Bundle)localObject).putBoolean("key_need_verify_sms", bool);
        this.qnt.putString("key_mobile", this.qgs.field_mobile);
        this.qnt.putInt("key_err_code", paramInt2);
        this.qnt.putParcelable("key_orders", this.nEh);
        if (!bk.bl(paramString)) {
          break label1285;
        }
        paramString = getString(a.i.wallet_pay_reset_info_tips, new Object[] { this.qgs.field_desc, this.qgs.field_mobile });
      }
    }
    label1285:
    for (;;)
    {
      com.tencent.mm.ui.base.h.a(this, paramString, "", getString(a.i.wallet_pay_reset_info), getString(a.i.app_cancel), new WalletPayUI.16(this), new WalletPayUI.17(this));
      return true;
      bool = false;
      break label862;
      this.nDu.snY = paramInt2;
      bTY();
      return true;
      this.nDu.snY = paramInt2;
      bool = false;
      if (paramInt2 == 100100) {
        bool = true;
      }
      if (this.qmB == null) {
        this.qmB = new a(this, this);
      }
      this.qmB.a(bool, this.nDu.bOS, this.nDu.bMX);
      y.i("MicroMsg.WalletPayUI", "mRegenFingerPrintRsaKey.genRsaKey isGenRsa is " + bool);
      return true;
      if ((this.qgs == null) || (this.nEh == null)) {
        break;
      }
      this.qgs.qtx = this.nEh.bMX;
      if ((this.qgr != null) && (this.qgr.size() > 1)) {
        c(true, 4, paramString);
      }
      for (;;)
      {
        return true;
        b(true, 4, paramString);
      }
      if (!(paramm instanceof com.tencent.mm.plugin.wallet.pay.a.c.e)) {
        break;
      }
      this.qnP = true;
      bUq();
      if (paramInt2 == 416)
      {
        y.e("MicroMsg.WalletPayUI", "errCode is 416 need real name verify!");
        this.qnM = true;
        paramString = new Bundle();
        paramString.putString("realname_verify_process_jump_activity", ".pay.ui.WalletPayUI");
        paramString.putString("realname_verify_process_jump_plugin", "wallet");
        if (this.nDu != null) {}
        for (paramInt1 = this.nDu.bUV;; paramInt1 = 0) {
          return com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, paramInt2, paramm, paramString, paramInt1);
        }
      }
      y.i("MicroMsg.WalletPayUI", "errCode is %d , not need real name verify!", new Object[] { Integer.valueOf(paramInt2) });
      break;
    }
  }
  
  public void finish()
  {
    int j = 0;
    int i = 0;
    y.i("MicroMsg.WalletPayUI", "finish %s ", new Object[] { bk.csb().toString() });
    y.i("MicroMsg.WalletPayUI", "finish %s ", new Object[] { bk.csb().toString() });
    cNg();
    if ((this.nEh != null) && (!this.nEh.qwN.isEmpty())) {
      getIntent().putExtra("key_trans_id", ((Orders.Commodity)this.nEh.qwN.get(0)).bMY);
    }
    if (this.nDu != null) {
      getIntent().putExtra("key_reqKey", this.nDu.bMX);
    }
    if (this.qno)
    {
      if (this.nEh != null) {
        getIntent().putExtra("key_total_fee", this.nEh.nCq);
      }
      f(-1, getIntent());
      setResult(-1, getIntent());
      super.finish();
      return;
    }
    if ((this.nDu != null) && (this.nDu.bUV == 8) && (this.nEh != null))
    {
      this.nDu.sod = 0;
      a(com.tencent.mm.plugin.wallet.pay.a.a.a(bUj(), this.nEh, true), false, false);
      if (this.nDu.snX != null)
      {
        long l = this.nDu.snX.getLong("extinfo_key_9");
        com.tencent.mm.plugin.report.service.h.nFQ.f(13956, new Object[] { Integer.valueOf(3), Long.valueOf(System.currentTimeMillis() - l) });
      }
    }
    f(0, getIntent());
    setResult(0, getIntent());
    p.bTK();
    if (p.bTL().bVK())
    {
      if (this.nDu == null)
      {
        i = 0;
        label329:
        if (this.nDu != null) {
          break label364;
        }
      }
      label364:
      for (str = "";; str = this.nDu.bMX)
      {
        aa.d(i, str, 18, "");
        break;
        i = this.nDu.bUV;
        break label329;
      }
    }
    p.bTK();
    if (p.bTL().bVO())
    {
      if (this.nDu == null) {
        label396:
        if (this.nDu != null) {
          break label430;
        }
      }
      label430:
      for (str = "";; str = this.nDu.bMX)
      {
        aa.d(i, str, 4, "");
        break;
        i = this.nDu.bUV;
        break label396;
      }
    }
    if (this.nDu == null)
    {
      i = j;
      label451:
      if (this.nDu != null) {
        break label486;
      }
    }
    label486:
    for (String str = "";; str = this.nDu.bMX)
    {
      aa.d(i, str, 7, "");
      break;
      i = this.nDu.bUV;
      break label451;
    }
  }
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  protected final int getLayoutId()
  {
    return a.g.wallet_pay_ui;
  }
  
  protected final void initView()
  {
    MMScrollView localMMScrollView = (MMScrollView)findViewById(a.f.wallet_sv);
    localMMScrollView.a(localMMScrollView, localMMScrollView);
    this.nBL = ((Button)findViewById(a.f.wallet_pay_pay));
    this.nBL.setClickable(false);
    this.nBL.setEnabled(false);
    this.qnv = ((TextView)findViewById(a.f.wallet_order_info_total_fee));
    this.qnw = ((TextView)findViewById(a.f.wallet_order_info_total_desc));
    this.qny = ((TextView)findViewById(a.f.wallet_order_info_fee_type));
    this.qnD = ((TextView)findViewById(a.f.wallet_order_info_favor));
    this.qnx = ((TextView)findViewById(a.f.wallet_order_info_origin_fee));
    this.qnC = ((TextView)findViewById(a.f.wallet_pay_anti_trick_tips));
    this.qnx.getPaint().setFlags(16);
    this.qnz = ((TextView)findViewById(a.f.wallet_pay_tips));
    this.qnA = ((TextView)findViewById(a.f.wallet_pay_bind_bankcard));
    this.qnA.setOnClickListener(new WalletPayUI.26(this));
    this.qnB = ((ImageView)findViewById(a.f.wallet_order_info_desc_more_btn));
    this.qnB.setOnClickListener(new WalletPayUI.27(this));
    this.qnE = ((LinearLayout)findViewById(a.f.wallet_order_info_lv));
    this.qnF = new WalletPayUI.a(this);
    this.nBL.setOnClickListener(new WalletPayUI.28(this));
    this.nBL.setText(a.i.wallet_pay);
    this.qnH = ((TextView)findViewById(a.f.payment_method_tips));
    this.qnI = ((LinearLayout)findViewById(a.f.payment_method_layout));
    aZ();
  }
  
  protected final void kw(boolean paramBoolean)
  {
    Object localObject1;
    if (paramBoolean)
    {
      if ((this.nEh != null) && (this.nEh.qwF))
      {
        com.tencent.mm.kernel.g.DQ();
        if (((Boolean)com.tencent.mm.kernel.g.DP().Dz().get(196614, Boolean.valueOf(true))).booleanValue())
        {
          Object localObject2 = getLayoutInflater().inflate(a.g.wallet_pay_oversea_tip, null);
          localObject1 = (CheckBox)((View)localObject2).findViewById(a.f.tips_cb);
          TextView localTextView = (TextView)((View)localObject2).findViewById(a.f.network_tips_content);
          localTextView.setText(Html.fromHtml(String.format(getResources().getString(a.i.wallet_pay_oversea_content), new Object[] { getResources().getString(a.i.wallet_agreen_oversea) })));
          localTextView.setMovementMethod(LinkMovementMethod.getInstance());
          ((TextView)((View)localObject2).findViewById(a.f.tips_tv)).setOnClickListener(new WalletPayUI.20(this, (CheckBox)localObject1));
          localObject2 = com.tencent.mm.ui.base.h.a(this, getString(a.i.wallet_pay_oversea_title), (View)localObject2, getString(a.i.wallet_card_wx_check_agree), getString(a.i.wallet_refuse_message), new WalletPayUI.21(this, (CheckBox)localObject1), new WalletPayUI.22(this));
          ((com.tencent.mm.ui.widget.a.c)localObject2).setCancelable(false);
          ((CheckBox)localObject1).setOnCheckedChangeListener(new WalletPayUI.24(this, (com.tencent.mm.ui.widget.a.c)localObject2));
        }
      }
      for (i = 0; i == 0; i = 1) {
        return;
      }
    }
    if (this.qmA != null)
    {
      this.qnm = com.tencent.mm.plugin.wallet_core.ui.b.qAd.a(this.nEh);
      localObject1 = this.qnm.QF(this.qmA.qvC);
      if ((localObject1 == null) || (((com.tencent.mm.plugin.wallet.a.h)localObject1).qkV != 0.0D)) {}
    }
    for (int i = 1;; i = 0)
    {
      if (this.qnR != null)
      {
        if (this.qnR.qmn == 0)
        {
          y.i("MicroMsg.WalletPayUI", "need real name,stop");
          b(this.qnR);
          return;
        }
        if ((this.qnR.qmn == 1) && (i != 0))
        {
          y.i("MicroMsg.WalletPayUI", "need real name, zero stop");
          b(this.qnR);
        }
      }
      if (this.qmo != null)
      {
        if ((this.qmo.qlX == 1) && (!bk.bl(this.qmo.lRE)) && (!bk.bl(this.qmo.lRF)) && (!bk.bl(this.qmo.qlY)))
        {
          if ((this.nDu != null) && (this.nEh != null) && (this.nEh.qwN != null) && (this.nEh.qwN.size() > 0))
          {
            if (this.nDu.bUV != 8) {
              break label569;
            }
            com.tencent.mm.plugin.report.service.h.nFQ.f(15368, new Object[] { Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(1), ((Orders.Commodity)this.nEh.qwN.get(0)).bMY });
          }
          for (;;)
          {
            com.tencent.mm.ui.base.h.a(this.mController.uMN, this.qmo.qlY, "", this.qmo.lRF, this.qmo.lRE, false, new WalletPayUI.4(this), new WalletPayUI.5(this));
            return;
            label569:
            com.tencent.mm.plugin.report.service.h.nFQ.f(15368, new Object[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1), ((Orders.Commodity)this.nEh.qwN.get(0)).bMY });
          }
        }
        if ((this.qmo.qlX == 2) && (!bk.bl(this.qmo.qlY)) && (!bk.bl(this.qmo.qlZ)))
        {
          y.i("MicroMsg.WalletPayUI", "pay has been blocked");
          if ((this.nDu != null) && (this.nEh != null) && (this.nEh.qwN != null) && (this.nEh.qwN.size() > 0))
          {
            if (this.nDu.bUV != 8) {
              break label817;
            }
            com.tencent.mm.plugin.report.service.h.nFQ.f(15368, new Object[] { Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(1), ((Orders.Commodity)this.nEh.qwN.get(0)).bMY });
          }
          for (;;)
          {
            com.tencent.mm.ui.base.h.a(this.mController.uMN, this.qmo.qlY, "", this.qmo.qlZ, false, new WalletPayUI.6(this));
            return;
            label817:
            com.tencent.mm.plugin.report.service.h.nFQ.f(15368, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), ((Orders.Commodity)this.nEh.qwN.get(0)).bMY });
          }
        }
      }
      bUm();
      return;
    }
  }
  
  public void kx(boolean paramBoolean)
  {
    com.tencent.mm.plugin.wallet.pay.a.a.b localb = com.tencent.mm.plugin.wallet.pay.a.a.a(bUj(), this.nEh, paramBoolean);
    if (this.nEh != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("key_reqKey", this.nEh.bMX);
      if ((this.nEh.qwN != null) && (this.nEh.qwN.size() > 0)) {
        localBundle.putString("key_TransId", ((Orders.Commodity)this.nEh.qwN.get(0)).bMY);
      }
      localBundle.putLong("key_SessionId", this.qnG);
      localb.dIA = "PayProcess";
      localb.BX = localBundle;
    }
    if (this.nDu != null) {
      if ((this.nDu.bUV != 6) || (this.nDu.snU != 100)) {
        break label245;
      }
    }
    label245:
    for (localb.fzn = 100;; localb.fzn = this.nDu.bUV)
    {
      a(localb, true, true);
      if ((this.nDu != null) && (8 == this.nDu.bUV) && (this.nDu.snX != null))
      {
        long l = this.nDu.snX.getLong("extinfo_key_9");
        com.tencent.mm.plugin.report.service.h.nFQ.f(13956, new Object[] { Integer.valueOf(2), Long.valueOf(System.currentTimeMillis() - l) });
      }
      return;
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    y.i("MicroMsg.WalletPayUI", "onAcvityResult requestCode:" + paramInt1 + ", resultCode:" + paramInt2);
    switch (paramInt1)
    {
    default: 
      return;
    }
    if (paramInt2 == -1)
    {
      if (paramIntent != null)
      {
        this.qnO = paramIntent.getIntExtra("auto_deduct_flag", -1);
        this.nEh.qwS.qnO = this.qnO;
        bUr().soa = this.qnO;
        if (this.qnO == 1)
        {
          bUr().sob = paramIntent.getStringExtra("deduct_bank_type");
          bUr().soc = paramIntent.getStringExtra("deduct_bind_serial");
        }
      }
      this.qnN = true;
      aSl();
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.nFQ.f(13958, new Object[] { Integer.valueOf(3) });
      return;
      finish();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (qnk)
    {
      y.w("MicroMsg.WalletPayUI", "has Undestory WalletPayUI!");
      finish();
      return;
    }
    qnk = true;
    if (!com.tencent.mm.kernel.g.DK())
    {
      y.e("MicroMsg.WalletPayUI", "hy: account not ready. finish now");
      finish();
      return;
    }
    getWindow().getDecorView().postDelayed(new WalletPayUI.12(this), 600L);
    this.qnU = bk.UY();
    com.tencent.mm.sdk.b.a.udP.c(this.nCz);
    com.tencent.mm.plugin.wallet_core.model.i.AN(5);
    this.nzT = com.tencent.mm.plugin.wallet.a.Y(getIntent());
    setMMTitle(a.i.wallet_pay_ui_title);
    this.nDu = bUr();
    this.qnq = getIntent().getBooleanExtra("key_is_force_use_given_card", false);
    this.qnr = bk.aM(getIntent().getStringExtra("key_force_use_bind_serail"), "");
    this.nAo = getIntent().getStringExtra("key_receiver_true_name");
    int i;
    if ((this.nDu == null) || (this.nDu.snZ == 0L))
    {
      this.qnG = System.currentTimeMillis();
      p.bTK();
      if (!p.bTL().bVN())
      {
        if (this.nDu != null) {
          break label306;
        }
        i = 0;
        label213:
        if (this.nDu != null) {
          break label317;
        }
      }
    }
    label306:
    label317:
    for (paramBundle = "";; paramBundle = this.nDu.bMX)
    {
      aa.d(i, paramBundle, 1, "");
      if (bUe()) {
        break label386;
      }
      y.d("MicroMsg.WalletPayUI", "PayInfo = " + this.nDu);
      if ((this.nDu == null) || (bk.bl(this.nDu.bMX))) {
        break label328;
      }
      bUf();
      initView();
      return;
      this.qnG = this.nDu.snZ;
      break;
      i = this.nDu.bUV;
      break label213;
    }
    label328:
    if ((this.nDu != null) && (!bk.bl(this.nDu.aox))) {}
    for (paramBundle = this.nDu.aox;; paramBundle = getString(a.i.wallet_pay_orders_illegal))
    {
      com.tencent.mm.ui.base.h.a(this, paramBundle, null, false, new WalletPayUI.23(this));
      break;
    }
    label386:
    y.i("MicroMsg.WalletPayUI", "hy: pay end on create. finish");
    finish();
  }
  
  public void onDestroy()
  {
    if (this.qmB != null)
    {
      this.qmB.bTT();
      this.qmB.release();
    }
    com.tencent.mm.sdk.b.a.udP.d(this.nCz);
    this.qmC = null;
    qnk = false;
    super.onDestroy();
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if ((this.qgo != null) && (this.nDu != null) && (this.nDu.kPR) && (!this.wCh.bfI())) {
        finish();
      }
      for (;;)
      {
        return true;
        XM();
        showDialog(1000);
      }
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    int j = 1;
    y.v("MicroMsg.WalletPayUI", "onNewIntent");
    setIntent(paramIntent);
    if (!bUe())
    {
      y.w("MicroMsg.WalletPayUI", "hy: pay not end if judge from intent, but should finish this ui, and set cancel event");
      f(0, getIntent());
      this.qno = false;
    }
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("intent_bind_end", false))) {
      this.qnK = true;
    }
    for (int i = 1; i != 0; i = 0)
    {
      y.i("MicroMsg.WalletPayUI", "isFromBindCard is true");
      bUf();
      return;
    }
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("key_is_realname_verify_process", false)))
    {
      this.qnL = true;
      i = j;
      if (i == 0) {
        break label136;
      }
      y.i("MicroMsg.WalletPayUI", "isFromRealNameVerify is true");
      finish();
    }
    for (;;)
    {
      finish();
      return;
      i = 0;
      break;
      label136:
      y.e("MicroMsg.WalletPayUI", "isFromBindCard is false,isFromRealNameVerify is false");
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.qmC != null) {
      this.qmC.bWt();
    }
  }
  
  public void onResume()
  {
    y.i("MicroMsg.WalletPayUI", "hy: onResume isFromH5RealNameVerify %s", new Object[] { Boolean.valueOf(this.qnS) });
    if (!this.wCh.bfI())
    {
      if (this.qgs == null)
      {
        p.bTK();
        this.qgs = p.bTL().a(null, null, bTV(), false);
      }
    }
    else
    {
      if (!this.qnT) {
        break label115;
      }
      y.i("MicroMsg.WalletPayUI", "onResume isResumePassFinish");
      this.qnT = false;
    }
    for (;;)
    {
      super.onResume();
      return;
      p.bTK();
      this.qgs = p.bTL().a(null, this.qgs.field_bindSerial, bTV(), false);
      break;
      label115:
      if ((this.qnp) && (this.mController.contentView.getVisibility() != 0) && ((this.qgo == null) || (!this.qgo.isShowing())))
      {
        y.i("MicroMsg.WalletPayUI", "hy: has started process and is transparent and no pwd appeared. finish self");
        finish();
      }
      else if (this.qmC != null)
      {
        this.qmC.bWs();
      }
    }
  }
  
  public final void st(int paramInt)
  {
    if (paramInt == 0) {
      if (aSk()) {
        finish();
      }
    }
    while (paramInt != 1) {
      return;
    }
    bTY();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI
 * JD-Core Version:    0.7.0.1
 */