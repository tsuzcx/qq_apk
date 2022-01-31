package com.tencent.mm.plugin.wallet.pay.ui;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ah.m;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.Orders.DeductInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.DeductShowInfo;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.ui.h;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import java.util.ArrayList;
import java.util.List;

public class WalletPayDeductUI
  extends MMPreference
  implements View.OnClickListener, com.tencent.mm.ah.f
{
  protected Button frP;
  private Dialog ftk = null;
  protected com.tencent.mm.ui.base.preference.f hcp;
  private String imZ;
  private LinearLayout lkL;
  protected Orders nEh;
  protected MMSwitchBtn qmV;
  protected ArrayList<Preference> qmW;
  protected TextView qmX;
  private TextView qmY;
  private TextView qmZ;
  private String qna;
  private String qnb;
  private Bankcard qnc;
  protected boolean qnd = false;
  private int qne = 0;
  private String qnf;
  
  private void bUc()
  {
    com.tencent.mm.plugin.wallet.a.p.bTK();
    ag localag = com.tencent.mm.plugin.wallet.a.p.bTL();
    if (this.qnc == null) {
      this.qnc = localag.a(null, null, true, true, true);
    }
    if (this.qnc == null)
    {
      y.i("MicroMsg.WalletPayDeductUI", "no bank card!");
      finish();
      return;
    }
    SpannableString localSpannableString = new SpannableString(this.qnc.field_desc);
    h localh = new h(this.mController.uMN);
    localh.qDo = new WalletPayDeductUI.3(this, localag.kt(true));
    localSpannableString.setSpan(localh, 0, localSpannableString.length(), 18);
    this.qmY.setText(localSpannableString);
    this.qmY.setMovementMethod(LinkMovementMethod.getInstance());
  }
  
  private void bUd()
  {
    if ((this.qmW == null) || (this.qmW.size() <= 0)) {
      return;
    }
    int j = this.qmW.size();
    int i = 0;
    while (i < j)
    {
      this.hcp.bJ(((Preference)this.qmW.get(i)).mKey, false);
      i += 1;
    }
    this.hcp.notifyDataSetChanged();
  }
  
  private void cR(List<Orders.DeductShowInfo> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      y.e("MicroMsg.WalletPayDeductUI", "showinfos is null or length is 0");
    }
    while (this.qmW != null) {
      return;
    }
    int j = paramList.size();
    this.qmW = new ArrayList();
    int i = 0;
    label48:
    Object localObject;
    com.tencent.mm.plugin.wallet_core.ui.d locald;
    if (i < j)
    {
      localObject = (Orders.DeductShowInfo)paramList.get(i);
      if ((localObject != null) && (!bk.bl(((Orders.DeductShowInfo)localObject).name)))
      {
        locald = new com.tencent.mm.plugin.wallet_core.ui.d(this);
        locald.setTitle(((Orders.DeductShowInfo)localObject).name);
        if (((Orders.DeductShowInfo)localObject).qxv <= 0) {
          break label228;
        }
        locald.mRq = getResources().getColor(a.c.link_color);
        String str = ((Orders.DeductShowInfo)localObject).value;
        localObject = new WalletPayDeductUI.4(this, (Orders.DeductShowInfo)localObject);
        locald.kPW = str;
        locald.kQa = true;
        locald.jFZ = ((View.OnClickListener)localObject);
      }
    }
    for (;;)
    {
      locald.setKey("deduct_info_" + i);
      this.qmW.add(locald);
      this.hcp.a(locald);
      this.hcp.bJ(locald.mKey, true);
      i += 1;
      break label48;
      break;
      label228:
      locald.kPW = ((Orders.DeductShowInfo)localObject).value;
      locald.kQa = false;
    }
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    return false;
  }
  
  protected final int getLayoutId()
  {
    return a.g.wallet_pay_deduct_ui;
  }
  
  protected final void initView()
  {
    this.qmX = ((TextView)this.mController.contentView.findViewById(a.f.bindcard_tip_tv));
    this.frP = ((Button)this.mController.contentView.findViewById(a.f.next_btn));
    this.lkL = ((LinearLayout)findViewById(a.f.pay_way_ll));
    ((TextView)findViewById(a.f.deduct_title)).setText(this.nEh.qwS.title);
    ((TextView)findViewById(a.f.title)).setText(((Orders.Commodity)this.nEh.qwN.get(0)).desc);
    Object localObject1 = (WalletTextView)findViewById(a.f.fee_type);
    ((WalletTextView)localObject1).setTypeface(0);
    ((WalletTextView)localObject1).setText(com.tencent.mm.wallet_core.ui.e.afh(this.nEh.mOZ));
    ((TextView)findViewById(a.f.fee)).setText(((Orders.Commodity)this.nEh.qwN.get(0)).iHP);
    localObject1 = (TextView)findViewById(a.f.footer_tips);
    Object localObject2 = (TextView)findViewById(a.f.deduct_desc);
    boolean bool;
    if (!bk.bl(this.nEh.qwS.qxt))
    {
      ((TextView)localObject2).setText(this.nEh.qwS.qxt);
      if (!bk.bl(this.nEh.qwS.qxu)) {
        ((TextView)localObject2).setTextColor(Color.parseColor(this.nEh.qwS.qxu));
      }
      this.qmY = ((TextView)findViewById(a.f.default_bankCard_tv));
      this.qmZ = ((TextView)findViewById(a.f.bankCard_tip_tv));
      if (this.nEh.qwS.qnO != 1) {
        break label771;
      }
      bool = true;
      label313:
      this.qnd = bool;
      this.qne = this.nEh.qwS.qne;
      this.imZ = this.nEh.qwS.imZ;
      this.qnf = this.nEh.qwS.qnf;
      y.i("MicroMsg.WalletPayDeductUI", "open: %s, show_type: %s", new Object[] { Boolean.valueOf(this.qnd), Integer.valueOf(this.qne) });
      if (this.qne != 0) {
        break label776;
      }
      this.qmV = ((MMSwitchBtn)findViewById(a.f.checkbox));
      this.qmV.setCheck(this.qnd);
      this.qmV.setSwitchListener(new WalletPayDeductUI.2(this));
      kv(this.qnd);
      label447:
      y.d("MicroMsg.WalletPayDeductUI", "show pay way layout: %d", new Object[] { Integer.valueOf(this.nEh.qwS.qxs) });
      if (this.nEh.qwS.qxs != 1) {
        break label863;
      }
      com.tencent.mm.kernel.g.DQ();
      this.qnb = ((String)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.usz, ""));
      com.tencent.mm.kernel.g.DQ();
      this.qna = ((String)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.usy, ""));
      if ((!bk.bl(this.qna)) && (!bk.bl(this.qna))) {
        break label845;
      }
      y.i("MicroMsg.WalletPayDeductUI", "need do pay manager");
      this.ftk = com.tencent.mm.wallet_core.ui.g.a(this.mController.uMN, false, null);
      localObject2 = new com.tencent.mm.plugin.wallet.pwd.a.d();
      com.tencent.mm.kernel.g.DQ();
      com.tencent.mm.kernel.g.DO().dJT.a((m)localObject2, 0);
      label609:
      if (bk.bl(this.nEh.qwS.qxq)) {
        break label875;
      }
      Object localObject3 = getString(a.i.wallet_deduct_foot_tips_part1);
      localObject2 = getString(a.i.wallet_deduct_foot_tips_part2);
      localObject3 = j.b(this, getString(a.i.wallet_deduct_foot_tips, new Object[] { localObject3, localObject2 }));
      h localh = new h(this.mController.uMN);
      SpannableString localSpannableString = new SpannableString((CharSequence)localObject3);
      localSpannableString.setSpan(localh, ((CharSequence)localObject3).length() - ((String)localObject2).length(), ((CharSequence)localObject3).length(), 33);
      ((TextView)localObject1).setTextColor(getResources().getColor(a.c.hint_text_color));
      ((TextView)localObject1).setText(localSpannableString);
      ((TextView)localObject1).setOnClickListener(this);
      ((TextView)localObject1).setVisibility(0);
    }
    for (;;)
    {
      this.frP.setOnClickListener(this);
      return;
      ((TextView)localObject2).setVisibility(8);
      break;
      label771:
      bool = false;
      break label313;
      label776:
      if (!bk.bl(this.imZ)) {
        this.frP.setText(this.imZ);
      }
      if (!bk.bl(this.qnf))
      {
        this.qmX.setText(this.qnf);
        this.qmX.setVisibility(0);
      }
      findViewById(a.f.deduct_checkbox_layout).setVisibility(8);
      bUd();
      break label447;
      label845:
      this.qmZ.setText(this.qnb);
      bUc();
      break label609;
      label863:
      this.lkL.setVisibility(8);
      break label609;
      label875:
      ((TextView)localObject1).setVisibility(8);
    }
  }
  
  protected final void kv(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      findViewById(16908298).setVisibility(0);
      if (this.nEh.qwS.qxs == 1)
      {
        this.lkL.setVisibility(0);
        bUd();
        if (!o.bVs().bVN()) {
          break label110;
        }
        this.qmX.setVisibility(8);
        this.frP.setText(a.i.wallet_deduct_pay_open_button_txt);
      }
    }
    for (;;)
    {
      y.i("MicroMsg.WalletPayDeductUI", "isCheck=" + this.qmV.wjS);
      return;
      this.lkL.setVisibility(8);
      break;
      label110:
      this.qmX.setVisibility(0);
      this.qmX.setText(a.i.wallet_deduct_pay_need_bind_card_txt);
      this.frP.setText(a.i.wallet_deduct_pay_bind_card_button_txt);
      continue;
      if ((this.qmW != null) && (this.qmW.size() > 0))
      {
        int j = this.qmW.size();
        int i = 0;
        while (i < j)
        {
          this.hcp.bJ(((Preference)this.qmW.get(i)).mKey, true);
          i += 1;
        }
      }
      findViewById(16908298).setVisibility(8);
      this.lkL.setVisibility(8);
      this.qmX.setVisibility(8);
      this.frP.setText(a.i.wallet_deduct_pay_button_txt);
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == a.f.next_btn)
    {
      paramView = new Intent();
      if (this.qne == 0) {
        if (this.qmV.wjS)
        {
          i = 1;
          paramView.putExtra("auto_deduct_flag", i);
          if (this.qnc != null)
          {
            paramView.putExtra("deduct_bank_type", this.qnc.field_bankcardType);
            paramView.putExtra("deduct_bind_serial", this.qnc.field_bindSerial);
            y.i("MicroMsg.WalletPayDeductUI", "deduct bankType: %s", new Object[] { this.qnc.field_bankcardType });
          }
          setResult(-1, paramView);
          finish();
        }
      }
    }
    while ((i != a.f.footer_tips) || (bk.bl(this.nEh.qwS.qxq))) {
      for (;;)
      {
        return;
        i = 0;
        continue;
        paramView.putExtra("auto_deduct_flag", this.nEh.qwS.qnO);
      }
    }
    paramView = new Intent();
    paramView.putExtra("rawUrl", this.nEh.qwS.qxq);
    paramView.putExtra("showShare", false);
    com.tencent.mm.br.d.b(this, "webview", ".ui.tools.WebViewUI", paramView);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.hcp = this.vdd;
    getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(a.c.white)));
    paramBundle = getSupportActionBar().getCustomView();
    if (paramBundle != null)
    {
      View localView = paramBundle.findViewById(a.f.divider);
      if (localView != null) {
        localView.setBackgroundColor(getResources().getColor(a.c.transparent));
      }
      paramBundle = paramBundle.findViewById(16908309);
      if ((paramBundle != null) && ((paramBundle instanceof TextView))) {
        ((TextView)paramBundle).setTextColor(getResources().getColor(a.c.white));
      }
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle = getWindow();
      paramBundle.addFlags(-2147483648);
      if (!com.tencent.mm.compatible.util.d.gF(23)) {
        break label188;
      }
      paramBundle.setStatusBarColor(getResources().getColor(a.c.wallet_deduct_status_bar_bg));
      getWindow().getDecorView().setSystemUiVisibility(8192);
    }
    for (;;)
    {
      paramBundle = getIntent();
      if (paramBundle != null) {
        break;
      }
      y.e("MicroMsg.WalletPayDeductUI", "intent is null");
      finish();
      return;
      label188:
      getWindow().setStatusBarColor(Color.parseColor("#E5E5E5"));
    }
    this.nEh = ((Orders)paramBundle.getParcelableExtra("orders"));
    if ((this.nEh == null) || (this.nEh.qwS == null))
    {
      y.e("MicroMsg.WalletPayDeductUI", "Orders data or deductInfo is null   : " + this.nEh);
      finish();
    }
    cR(this.nEh.qwS.qxr);
    setResult(0);
    setBackBtn(new WalletPayDeductUI.1(this), a.h.actionbar_icon_dark_back);
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.a(385, this);
    initView();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.b(385, this);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onResume()
  {
    super.onResume();
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.WalletPayDeductUI", "errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramm instanceof com.tencent.mm.plugin.wallet.pwd.a.d)) {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.kernel.g.DQ();
        this.qnb = ((String)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.usz, getString(a.i.wallet_pay_deduct_change_pay_way_tip)));
        com.tencent.mm.kernel.g.DQ();
        this.qna = ((String)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.usy, getString(a.i.wallet_pay_deduct_select_pay_way_label)));
        this.qmZ.setText(this.qnb);
        bUc();
      }
    }
    for (;;)
    {
      if (this.ftk != null) {
        this.ftk.dismiss();
      }
      return;
      y.d("MicroMsg.WalletPayDeductUI", "other tenpay scene");
    }
  }
  
  public final int xj()
  {
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletPayDeductUI
 * JD-Core Version:    0.7.0.1
 */