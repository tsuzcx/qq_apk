package com.tencent.mm.plugin.wallet.bind.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ah.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wxpay.a.b;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;

public class WalletBankcardDetailUI
  extends WalletBaseUI
{
  public Bankcard qhv;
  protected TextView qjP;
  private TextView qjQ;
  private View qjR;
  protected LinearLayout qjS;
  protected LinearLayout qjT;
  protected LinearLayout qjU;
  
  private void kr(boolean paramBoolean)
  {
    if ((!q.Gw()) && (!paramBoolean) && (!((com.tencent.mm.plugin.walletlock.a.b)g.r(com.tencent.mm.plugin.walletlock.a.b.class)).bXM()))
    {
      e.Jc(0);
      h.a(this, a.i.wallet_bankcard_detail_unbind_dialog_tip, -1, a.i.wallet_bankcard_detail_unbind_dialog_open_gesture, a.i.wallet_bankcard_detail_unbind_dialog_unbind_btn, true, new WalletBankcardDetailUI.6(this), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          WalletBankcardDetailUI.b(WalletBankcardDetailUI.this);
          e.Jc(2);
        }
      });
      return;
    }
    this.BX.putBoolean("offline_pay", false);
    com.tencent.mm.wallet_core.a.j(this, this.BX);
  }
  
  public final void bTB()
  {
    this.qjS.setVisibility(0);
    this.qjT.setVisibility(8);
    ((TextView)findViewById(a.f.wallet_bankcard_detail_expired_bankphone)).setOnClickListener(new WalletBankcardDetailUI.3(this));
    ((TextView)findViewById(a.f.wallet_bankcard_detail_unbind)).setOnClickListener(new WalletBankcardDetailUI.4(this));
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if ((paramm instanceof com.tencent.mm.plugin.wallet.bind.a.b)) {
        if (this.qjP != null) {
          this.qjP.setVisibility(0);
        }
      }
    }
    while (!(paramm instanceof com.tencent.mm.plugin.wallet.bind.a.a))
    {
      do
      {
        return false;
      } while (!(paramm instanceof com.tencent.mm.plugin.wallet.bind.a.a));
      paramString = (com.tencent.mm.plugin.wallet.bind.a.a)paramm;
      y.e("MicroMsg.WalletBankcardDetailUI", "NetSceneGetUnbindInfo succ and level = " + paramString.qjp);
      switch (paramString.qjp)
      {
      default: 
        kr(false);
        return false;
      }
      paramInt1 = paramString.qjp;
      h.a(this, paramString.qjq, null, false, new WalletBankcardDetailUI.9(this, paramInt1));
      return false;
    }
    y.e("MicroMsg.WalletBankcardDetailUI", "NetSceneGetUnbindInfo error");
    kr(false);
    return true;
  }
  
  protected final int getLayoutId()
  {
    return a.g.wallet_bankcard_detail;
  }
  
  protected final void initView()
  {
    this.qhv = ((Bankcard)this.BX.getParcelable("key_bankcard"));
    if (this.qhv == null) {
      return;
    }
    this.qjS = ((LinearLayout)findViewById(a.f.wallet_bankcard_detail_expired));
    this.qjT = ((LinearLayout)findViewById(a.f.wallet_bankcard_detail_ll));
    this.qjU = ((LinearLayout)findViewById(a.f.wallet_bankcard_detail_international_ll));
    this.qjQ = ((TextView)findViewById(a.f.wallet_bankcard_detail_finance));
    this.qjR = findViewById(a.f.wallet_bankcard_detail_repay_layout);
    this.qjR.setOnClickListener(new WalletBankcardDetailUI.1(this));
    if (1 == this.qhv.field_bankcardState)
    {
      bTB();
      return;
    }
    String str;
    if (this.qhv.bUT())
    {
      kq(true);
      this.qjP = ((TextView)findViewById(a.f.wallet_bankcard_detail_default));
      p.bTK();
      p.bTL();
      str = this.qhv.field_bindSerial;
      this.qjP.setVisibility(8);
    }
    for (;;)
    {
      addIconOptionMenu(0, a.e.mm_title_btn_menu, new WalletBankcardDetailUI.5(this));
      return;
      kq(false);
      this.qjP = ((TextView)findViewById(a.f.wallet_bankcard_detail_international_default));
      p.bTK();
      p.bTL();
      str = this.qhv.field_bindSerial;
      this.qjP.setVisibility(8);
    }
  }
  
  public final void kq(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.qjS.setVisibility(8);
      this.qjT.setVisibility(0);
      ((TextView)findViewById(a.f.wallet_bankcard_detail_bankphone)).setOnClickListener(new WalletBankcardDetailUI.2(this));
      TextView localTextView1 = (TextView)findViewById(a.f.wallet_bankcard_detail_per_order_kind);
      TextView localTextView2 = (TextView)findViewById(a.f.wallet_bankcard_detail_per_order_virtual);
      TextView localTextView3 = (TextView)findViewById(a.f.wallet_bankcard_detail_per_day_kind);
      TextView localTextView4 = (TextView)findViewById(a.f.wallet_bankcard_detail_per_day_virtual);
      localTextView1.setText(e.d(this.qhv.field_onceQuotaKind, null));
      localTextView2.setText(e.d(this.qhv.field_onceQuotaVirtual, null));
      localTextView3.setText(e.d(this.qhv.field_dayQuotaKind, null));
      localTextView4.setText(e.d(this.qhv.field_dayQuotaVirtual, null));
      if (!bk.bl(this.qhv.field_repay_url))
      {
        this.qjQ.setVisibility(0);
        this.qjR.setVisibility(0);
      }
      return;
    }
    this.qjS.setVisibility(8);
    this.qjT.setVisibility(8);
    this.qjU.setVisibility(0);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    kh(621);
    setMMTitle(a.i.wallet_bankcard_detail_title);
    initView();
  }
  
  @Deprecated
  protected Dialog onCreateDialog(int paramInt)
  {
    return h.a(this.mController.uMN, getString(a.i.wallet_bankcard_detail_bankphone_tips), getResources().getStringArray(a.b.wallet_phone_call), "", new WalletBankcardDetailUI.8(this));
  }
  
  public void onDestroy()
  {
    ki(621);
    super.onDestroy();
  }
  
  public void onResume()
  {
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardDetailUI
 * JD-Core Version:    0.7.0.1
 */