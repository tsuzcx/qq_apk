package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Dialog;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.ah.m;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.c.t;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.ae;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.ListViewInScrollView;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.a.c.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.a;
import java.util.List;

@com.tencent.mm.ui.base.a(19)
public class WalletBankcardIdUI
  extends WalletBaseUI
  implements WalletFormView.a
{
  private Button fpF;
  private int fzn = -1;
  private boolean qAA = false;
  private boolean qAB;
  protected WalletFormView qAw;
  protected WalletFormView qAx;
  private Bankcard qAy;
  private WalletBankcardIdUI.a qAz;
  com.tencent.mm.sdk.b.c qkv = new WalletBankcardIdUI.1(this);
  com.tencent.mm.sdk.b.c qoS = new WalletBankcardIdUI.2(this);
  
  private boolean YH()
  {
    if (this.qAw.eq(null))
    {
      this.fpF.setEnabled(true);
      this.fpF.setClickable(true);
      return true;
    }
    this.fpF.setEnabled(false);
    this.fpF.setClickable(false);
    return false;
  }
  
  protected final void XX()
  {
    if (cNj() == null)
    {
      y.e("Micromsg.WalletInputCardIDUI", "WalletBankcardIdUI doNext, process is null");
      return;
    }
    Object localObject = cNj().kke.getString("kreq_token");
    int i = this.BX.getInt("entry_scene", -1);
    if (this.qAy != null)
    {
      localObject = new t(bTO(), null, (PayInfo)this.BX.getParcelable("key_pay_info"), (String)localObject, this.fzn, i);
      ((t)localObject).nxa = this.qAy.field_bankcardType;
      this.BX.putParcelable("key_history_bankcard", this.qAy);
      a((m)localObject, true, true);
      return;
    }
    if (YH())
    {
      String str = this.qAw.getText();
      a(new t(bTO(), str, (PayInfo)this.BX.getParcelable("key_pay_info"), (String)localObject, this.fzn, i), true, true);
      return;
    }
    com.tencent.mm.ui.base.h.h(this, a.i.wallet_not_exist, a.i.app_tip);
  }
  
  protected final boolean bTZ()
  {
    return true;
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.d("Micromsg.WalletInputCardIDUI", " errCode: " + paramInt2 + " errMsg :" + paramString);
    paramString = new Bundle();
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if ((paramm instanceof t))
      {
        paramm = (t)paramm;
        paramString.putBoolean("key_need_area", paramm.bUJ());
        paramString.putBoolean("key_need_profession", paramm.bUK());
        paramString.putParcelableArray("key_profession_list", paramm.qrb);
        if (paramm.qqX != null)
        {
          if ((paramm.qqX.qvd) && (paramm.qqX.isError()))
          {
            com.tencent.mm.ui.base.h.h(this, a.i.wallet_bank_broken, a.i.app_tip);
            return true;
          }
          paramString.putString("bank_name", paramm.qqX.lnT);
          paramString.putParcelable("elemt_query", paramm.qqX);
          paramString.putString("key_card_id", this.qAw.getText());
          com.tencent.mm.wallet_core.a.j(this, paramString);
          return true;
        }
        paramString.putString("bank_name", "");
        paramString.putParcelable("elemt_query", new ElementQuery());
        paramString.putString("key_card_id", this.qAw.getText());
        com.tencent.mm.wallet_core.a.j(this, paramString);
      }
    }
    while ((paramInt2 != 1) || (!(paramm instanceof t))) {
      return false;
    }
    paramString.putString("bank_name", "");
    paramString.putParcelable("elemt_query", new ElementQuery());
    paramString.putString("key_card_id", this.qAw.getText());
    com.tencent.mm.wallet_core.a.j(this, paramString);
    return true;
  }
  
  public final void gG(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.qAy = null;
      this.BX.putParcelable("key_history_bankcard", null);
    }
    YH();
  }
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  protected final int getLayoutId()
  {
    return a.g.wallet_bankcard_id_ui;
  }
  
  protected final void initView()
  {
    this.fpF = ((Button)findViewById(a.f.next_btn));
    this.qAw = ((WalletFormView)findViewById(a.f.card_num_et));
    com.tencent.mm.wallet_core.ui.formview.a.b(this.qAw);
    this.qAx = ((WalletFormView)findViewById(a.f.name_et));
    Object localObject1;
    label118:
    Object localObject2;
    if (this.BX.getBoolean("key_bind_show_change_card", false))
    {
      com.tencent.mm.wallet_core.ui.formview.a.d(this, this.qAx);
      this.qAw.setOnInputValidChangeListener(this);
      this.fpF.setOnClickListener(new WalletBankcardIdUI.3(this));
      localObject1 = cNj();
      if (localObject1 == null) {
        break label663;
      }
      this.qAB = ((com.tencent.mm.wallet_core.c)localObject1).kke.getBoolean("key_is_realname_verify_process", false);
      if (!this.qAB) {
        break label671;
      }
      setMMTitle(a.i.wallet_real_name_verify_title);
      label132:
      localObject1 = (TextView)findViewById(a.f.input_tip);
      if ((!o.bVs().bVK()) && (!o.bVs().bVO())) {
        break label681;
      }
      localObject2 = new h(this);
      ((h)localObject2).qDo = new WalletBankcardIdUI.4(this);
      Object localObject3 = getString(a.i.wallet_input_card_first_bind_tips);
      SpannableString localSpannableString = new SpannableString((CharSequence)localObject3);
      localSpannableString.setSpan(localObject2, ((String)localObject3).length() - 6, ((String)localObject3).length(), 33);
      ((TextView)localObject1).setText(localSpannableString);
      ((TextView)localObject1).setMovementMethod(LinkMovementMethod.getInstance());
      label232:
      localObject1 = (FavorPayInfo)this.BX.getParcelable("key_favor_pay_info");
      localObject2 = (Orders)this.BX.getParcelable("key_orders");
      if ((localObject1 != null) && (localObject2 != null))
      {
        localObject3 = b.qAd.a((Orders)localObject2);
        localObject2 = (TextView)findViewById(a.f.wallet_card_favor_tips);
        if (localObject3 == null) {
          break label721;
        }
        localObject1 = ((a)localObject3).QE(((a)localObject3).QH(((FavorPayInfo)localObject1).qvC));
        if (((List)localObject1).size() <= 0) {
          break label712;
        }
        this.qAz = new WalletBankcardIdUI.a(this.mController.uMN, (List)localObject1);
        ((TextView)localObject2).setText(a.i.wallet_input_card_favor_tips);
        ((TextView)localObject2).setOnClickListener(new WalletBankcardIdUI.5(this));
        ((TextView)localObject2).setVisibility(0);
      }
      label356:
      localObject1 = o.bVs();
      if ((!((ag)localObject1).bVN()) || (((ag)localObject1).aEZ() == null) || (bk.bl(((ag)localObject1).aEZ().trim())) || (!((ag)localObject1).bVS())) {
        break label738;
      }
      this.qAx.setVisibility(0);
      this.qAx.setText(((ag)localObject1).aEZ());
      this.qAw.setHint(getString(a.i.wallet_card_num_hint));
      this.qAx.setClickable(false);
      this.qAx.setEnabled(false);
    }
    for (;;)
    {
      if ((this.BX.getInt("key_bind_scene") == 18) || (this.BX.getInt("key_bind_scene") == 19)) {
        this.qAw.setHint(getString(a.i.wallet_input_card_only_debit_card_hint));
      }
      g.DQ();
      localObject1 = (String)g.DP().Dz().get(ac.a.uoE, null);
      if (!bk.bl((String)localObject1)) {
        this.qAw.setHint((CharSequence)localObject1);
      }
      this.qAy = ((Bankcard)this.BX.getParcelable("key_history_bankcard"));
      if (this.qAy != null)
      {
        this.qAw.setText(this.qAy.qtu);
        this.qAw.a(new WalletBankcardIdUI.6(this));
      }
      YH();
      com.tencent.mm.plugin.wallet_core.e.c.a(this, this.BX, 2);
      e(this.qAw, 0, false);
      this.qAw.setOnInfoIvClickListener(new WalletBankcardIdUI.7(this));
      if (o.bVs().bVR().bVG())
      {
        this.qAw.getInfoIv().setVisibility(0);
        this.qAw.getInfoIv().setImageResource(a.h.wallet_scan_camera);
      }
      return;
      com.tencent.mm.wallet_core.ui.formview.a.e(this, this.qAx);
      break;
      label663:
      this.qAB = false;
      break label118;
      label671:
      setMMTitle(a.i.wallet_input_card_ui_title);
      break label132;
      label681:
      ((TextView)localObject1).setVisibility(0);
      localObject2 = this.BX.getString("key_custom_bind_tips");
      if (bk.bl((String)localObject2)) {
        break label232;
      }
      ((TextView)localObject1).setText((CharSequence)localObject2);
      break label232;
      label712:
      ((TextView)localObject2).setVisibility(8);
      break label356;
      label721:
      y.w("Micromsg.WalletInputCardIDUI", "favorlogichelper null");
      ((TextView)localObject2).setVisibility(8);
      break label356;
      label738:
      this.qAx.setVisibility(8);
      this.qAw.setHint(getString(a.i.wallet_input_card_num_hint));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setMMTitle(a.i.wallet_input_card_ui_title);
    initView();
    com.tencent.mm.sdk.b.a.udP.c(this.qkv);
    com.tencent.mm.sdk.b.a.udP.c(this.qoS);
    this.fzn = this.BX.getInt("key_bind_scene");
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    Object localObject1;
    Object localObject2;
    if (paramInt == 1)
    {
      localObject1 = getLayoutInflater().inflate(a.g.wallet_list_dialog, null);
      ((ListViewInScrollView)((View)localObject1).findViewById(a.f.address_contactlist)).setAdapter(this.qAz);
      localObject2 = new c.a(this);
      ((c.a)localObject2).Ip(a.i.wallet_input_card_bank_favor_title);
      ((c.a)localObject2).ei((View)localObject1);
      ((c.a)localObject2).e(null);
      ((c.a)localObject2).Is(a.i.wallet_i_know_it);
      return ((c.a)localObject2).aoP();
    }
    if ((this.qAB) && (paramInt == 1000))
    {
      localObject1 = getString(a.i.wallet_input_card_finish_confirm);
      localObject2 = com.tencent.mm.wallet_core.a.aj(this);
      if (localObject2 == null) {
        break label171;
      }
    }
    label171:
    for (paramInt = ((com.tencent.mm.wallet_core.c)localObject2).a(this, 1);; paramInt = -1)
    {
      if (paramInt != -1) {
        localObject1 = getString(paramInt);
      }
      return com.tencent.mm.ui.base.h.a(this, true, (String)localObject1, "", getString(a.i.app_yes), getString(a.i.app_no), new WalletBankcardIdUI.8(this), new WalletBankcardIdUI.9(this));
      return super.onCreateDialog(paramInt);
    }
  }
  
  public void onDestroy()
  {
    com.tencent.mm.sdk.b.a.udP.d(this.qkv);
    com.tencent.mm.sdk.b.a.udP.d(this.qoS);
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI
 * JD-Core Version:    0.7.0.1
 */