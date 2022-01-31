package com.tencent.mm.plugin.remittance.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ah.m;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.b.i;
import com.tencent.mm.plugin.remittance.a.b;
import com.tencent.mm.plugin.remittance.model.ab;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.c.mu;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.e;
import java.util.List;

@com.tencent.mm.ui.base.a(19)
public class RemittanceResultNewUI
  extends RemittanceResultUI
{
  private b.a.a.c nBp;
  private WalletSuccPageAwardWidget nBq;
  private Orders nEh;
  private String nEi;
  private boolean nEj;
  private TextView nEk;
  private ViewGroup nEl;
  private TextView nEm;
  private WalletTextView nEn;
  private ViewGroup nEo;
  private ViewGroup nEp;
  private ViewGroup nEq;
  private TextView nEr;
  private TextView nEs;
  private WalletTextView nEt;
  private mu nEu;
  private Button nEv;
  private PayInfo nqa;
  private int nzY;
  
  private ViewGroup aU(String paramString, boolean paramBoolean)
  {
    y.i("MicroMsg.RemittanceResultNewUI", "setF2FNameView");
    if (paramBoolean)
    {
      localViewGroup = (ViewGroup)getLayoutInflater().inflate(a.g.f2f_transfer_single_big_avatar_detail_item, this.nEp, false);
      localImageView = (ImageView)localViewGroup.findViewById(a.f.remittance_busi_logo);
      localTextView = (TextView)localViewGroup.findViewById(a.f.rbru_rcvr_tv);
      a.b.a(localImageView, this.nEi, 0.06F, false);
      localTextView.setText(paramString);
      this.nEp.addView(localViewGroup);
      return localViewGroup;
    }
    ViewGroup localViewGroup = (ViewGroup)getLayoutInflater().inflate(a.g.f2f_transfer_new_detail_item, this.nEp, false);
    ImageView localImageView = (ImageView)localViewGroup.findViewById(a.f.remittance_busi_logo);
    TextView localTextView = (TextView)localViewGroup.findViewById(a.f.rbru_rcvr_tv);
    a.b.a(localImageView, this.nEi, 0.06F, false);
    localTextView.setText(paramString);
    this.nEp.addView(localViewGroup);
    return localViewGroup;
  }
  
  private View bwJ()
  {
    boolean bool = true;
    if (this.nEh != null)
    {
      if (this.nEh.nyC > 0.0D) {}
      for (;;)
      {
        y.i("MicroMsg.RemittanceResultNewUI", "need set charge fee: %s", new Object[] { Boolean.valueOf(bool) });
        if (this.nEh.nyC <= 0.0D) {
          break;
        }
        String str1 = getString(a.i.remittance_result_charge_fee_wording);
        String str2 = e.d(this.nEh.nyC, this.nEh.mOZ);
        ViewGroup localViewGroup = (ViewGroup)getLayoutInflater().inflate(a.g.f2f_transfer_detail_item, this.nEp, false);
        TextView localTextView1 = (TextView)localViewGroup.findViewById(a.f.title_tv);
        ImageView localImageView = (ImageView)localViewGroup.findViewById(a.f.avatar_iv);
        TextView localTextView2 = (TextView)localViewGroup.findViewById(a.f.desc_tv);
        localTextView1.setText(str1);
        localImageView.setVisibility(8);
        localTextView2.setText(str2);
        this.nEp.addView(localViewGroup);
        return localViewGroup;
        bool = false;
      }
    }
    return null;
  }
  
  private void bwK()
  {
    y.i("MicroMsg.RemittanceResultNewUI", "endRemittance");
    if (this.BX.containsKey("key_realname_guide_helper"))
    {
      RealnameGuideHelper localRealnameGuideHelper = (RealnameGuideHelper)this.BX.getParcelable("key_realname_guide_helper");
      if (localRealnameGuideHelper != null)
      {
        Bundle localBundle = new Bundle();
        localBundle.putString("realname_verify_process_jump_activity", ".ui.RemittanceResultUI");
        localBundle.putString("realname_verify_process_jump_plugin", "remittance");
        localRealnameGuideHelper.b(this, localBundle, new RemittanceResultNewUI.2(this));
        localRealnameGuideHelper.a(this, localBundle, new RemittanceResultNewUI.3(this));
        this.BX.remove("key_realname_guide_helper");
      }
      return;
    }
    bwL();
  }
  
  private void bwL()
  {
    y.i("MicroMsg.RemittanceResultNewUI", "doEndRemittance");
    cNj().b(this, this.BX);
    new ah().postDelayed(new RemittanceResultNewUI.4(this), 100L);
  }
  
  protected final boolean bwM()
  {
    return false;
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if (WalletSuccPageAwardWidget.a(this.nBp)) {
      return this.nBq.c(paramInt1, paramInt2, paramString, paramm);
    }
    return super.c(paramInt1, paramInt2, paramString, paramm);
  }
  
  protected final int getLayoutId()
  {
    return a.g.remittance_result_new_ui;
  }
  
  protected final void initView()
  {
    setBackBtn(null);
    showHomeBtn(false);
    enableBackMenu(false);
    this.nEk = ((TextView)findViewById(a.f.pay_succ_wording_tv));
    this.nEl = ((ViewGroup)findViewById(a.f.f2f_transfer_result_money_layout));
    this.nEm = ((TextView)findViewById(a.f.f2f_money_unit_tv));
    this.nEn = ((WalletTextView)findViewById(a.f.f2f_money_amount_tv));
    this.nEo = ((ViewGroup)findViewById(a.f.f2f_transfer_detail_layout));
    this.nEp = ((ViewGroup)findViewById(a.f.f2f_transfer_detail_list_layout));
    this.nEq = ((ViewGroup)findViewById(a.f.normal_transfer_result_money_layout));
    this.nEr = ((TextView)findViewById(a.f.normal_transfer_desc_tv));
    this.nEs = ((TextView)findViewById(a.f.normal_money_unit_tv));
    this.nEt = ((WalletTextView)findViewById(a.f.normal_money_amount_tv));
    this.nEv = ((Button)findViewById(a.f.transfer_finish_button));
    this.nEv.setOnClickListener(new RemittanceResultNewUI.1(this));
    this.nBq = ((WalletSuccPageAwardWidget)findViewById(a.f.award_widget));
    Object localObject1 = e.gV(this.nEi);
    if ((this.nzY == 31) || (this.nzY == 5))
    {
      this.nEs.setText(e.afg(this.nEh.mOZ));
      this.nEt.setText(e.A(this.nEh.nCq));
      if (this.nzY == 31)
      {
        localObject1 = getString(a.i.remittance_result_receiver_desc, new Object[] { localObject1 });
        if (!bk.bl((String)localObject1)) {
          this.nEr.setText(j.a(this, (CharSequence)localObject1, this.nEr.getTextSize()));
        }
        for (;;)
        {
          this.nEq.setVisibility(0);
          if (this.nEh.nyC > 0.0D)
          {
            bwJ();
            ((ViewGroup.MarginLayoutParams)this.nEo.getLayoutParams()).topMargin = com.tencent.mm.cb.a.fromDPToPix(this, 20);
            this.nEo.setVisibility(0);
            this.nEp.setVisibility(0);
          }
          ((i)g.r(i.class)).f(this);
          return;
          this.nEr.setVisibility(8);
        }
      }
      if ((this.nqa.snX == null) || (!this.nqa.snX.getBoolean("extinfo_key_10"))) {
        break label1331;
      }
    }
    label1281:
    label1296:
    label1302:
    label1321:
    label1326:
    label1331:
    for (boolean bool = true;; bool = false) {
      for (;;)
      {
        y.i("MicroMsg.RemittanceResultNewUI", "isEmojiReward: %s", new Object[] { Boolean.valueOf(bool) });
        if (bool)
        {
          this.nEr.setText(getString(a.i.remittance_emoji_reward_desc));
          break;
        }
        if ((this.nEh.qwN == null) || (this.nEh.qwN.get(0) == null) || (TextUtils.isEmpty(((Orders.Commodity)this.nEh.qwN.get(0)).mOO))) {
          break;
        }
        this.nEr.setText(((Orders.Commodity)this.nEh.qwN.get(0)).mOO);
        break;
        localObject1 = this.BX.getByteArray("key_succpage_resp");
        if (localObject1 != null) {
          this.nEu = new mu();
        }
        try
        {
          this.nEu.aH((byte[])localObject1);
          this.nBp = this.nEu.qxJ;
          localObject4 = e.gV(this.nEi);
          this.nEm.setText(e.afg(this.nEh.mOZ));
          this.nEn.setText(e.A(this.nEh.nCq));
          this.nEp.removeAllViews();
          if ((this.nzY == 32) || (this.nzY == 33) || (this.nzY == 48))
          {
            localObject1 = "";
            if (this.nqa.snX != null) {
              localObject1 = this.nqa.snX.getString("extinfo_key_2");
            }
            localObject3 = localObject4;
            if (localObject4 != null)
            {
              localObject3 = localObject4;
              if (((String)localObject4).length() > 10) {
                localObject3 = ((String)localObject4).substring(0, 10) + "...";
              }
            }
            if (bk.bl((String)localObject1)) {
              break label1326;
            }
            if (bk.bl((String)localObject3)) {
              break label1258;
            }
            localObject1 = e.afj((String)localObject1);
            localObject1 = (String)localObject3 + "(" + (String)localObject1 + ")";
            y.i("MicroMsg.RemittanceResultNewUI", "setF2FReceiverRemarkView");
            localObject4 = this.nqa.snX.getString("extinfo_key_3");
            String str = this.nqa.snX.getString("extinfo_key_8");
            if (bk.bl((String)localObject4)) {
              break label1276;
            }
            localObject3 = (ViewGroup)getLayoutInflater().inflate(a.g.f2f_transfer_detail_item_2, this.nEp, false);
            localObject5 = (TextView)((ViewGroup)localObject3).findViewById(a.f.title_tv);
            localTextView1 = (TextView)((ViewGroup)localObject3).findViewById(a.f.desc_tv);
            if (bk.bl(str)) {
              break label1261;
            }
            ((TextView)localObject5).setText(str);
            localTextView1.setText((CharSequence)localObject4);
            y.i("MicroMsg.RemittanceResultNewUI", "setF2FPayerRemarkView");
            str = this.nqa.snX.getString("extinfo_key_6");
            localObject5 = this.nqa.snX.getString("extinfo_key_7");
            if (bk.bl((String)localObject5)) {
              break label1296;
            }
            localObject4 = (ViewGroup)getLayoutInflater().inflate(a.g.f2f_transfer_detail_item_2, this.nEp, false);
            localTextView1 = (TextView)((ViewGroup)localObject4).findViewById(a.f.title_tv);
            TextView localTextView2 = (TextView)((ViewGroup)localObject4).findViewById(a.f.desc_tv);
            if (bk.bl(str)) {
              break label1281;
            }
            localTextView1.setText(str);
            localTextView2.setText((CharSequence)localObject5);
            localObject5 = bwJ();
            if ((localObject3 == null) && (localObject4 == null) && (localObject5 == null)) {
              break label1321;
            }
            bool = false;
            this.nEo.setVisibility(0);
            this.nEp.setVisibility(0);
            if (!WalletSuccPageAwardWidget.a(this.nBp)) {
              break label1302;
            }
            str = "";
            if (this.nEh.qwN.size() > 0) {
              str = ((Orders.Commodity)this.nEh.qwN.get(0)).bMY;
            }
            y.i("MicroMsg.RemittanceResultNewUI", "transId: %s", new Object[] { str });
            this.nBq.a(this, this.nBp, str, true, (ImageView)findViewById(a.f.background));
            this.nBq.init();
            this.nBq.setVisibility(0);
            aU((String)localObject1, false);
            if (localObject3 != null) {
              this.nEp.addView((View)localObject3);
            }
            if (localObject4 != null) {
              this.nEp.addView((View)localObject4);
            }
            if (localObject5 != null) {
              this.nEp.addView((View)localObject5);
            }
          }
          this.nEl.setVisibility(0);
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Object localObject5;
            TextView localTextView1;
            this.nEu = null;
            this.nBp = null;
            y.printErrStackTrace("MicroMsg.RemittanceResultNewUI", localException, "parse f2FPaySucPageResp error: %s", new Object[] { localException.getMessage() });
            continue;
            label1258:
            continue;
            label1261:
            ((TextView)localObject5).setText(getString(a.i.collect_create_qrcode_receiver_msg_title));
            continue;
            label1276:
            Object localObject3 = null;
            continue;
            localTextView1.setText(getString(a.i.collect_create_qrcode_payer_msg_title));
            continue;
            Object localObject4 = null;
            continue;
            this.nBq.setVisibility(8);
            aU(localException, bool);
            continue;
            bool = true;
            continue;
            Object localObject2 = localObject3;
          }
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (d.gF(21))
    {
      if (d.gF(23))
      {
        getWindow().setStatusBarColor(-1);
        getWindow().getDecorView().setSystemUiVisibility(8192);
      }
    }
    else
    {
      if (getSupportActionBar() != null) {
        getSupportActionBar().hide();
      }
      this.nEh = ((Orders)this.BX.getParcelable("key_orders"));
      this.nqa = ((PayInfo)this.BX.getParcelable("key_pay_info"));
      if (this.nqa != null) {
        break label126;
      }
      y.e("MicroMsg.RemittanceResultNewUI", "payInfo is null!!!");
      finish();
    }
    label126:
    do
    {
      return;
      getWindow().setStatusBarColor(Color.parseColor("#E5E5E5"));
      break;
      String str = "";
      paramBundle = "";
      if (this.nqa.snX != null)
      {
        this.nEj = this.nqa.snX.getBoolean("extinfo_key_4");
        str = this.nqa.snX.getString("extinfo_key_1");
        paramBundle = this.nqa.snX.getString("extinfo_key_16");
      }
      int i = this.nqa.bUV;
      this.nzY = i;
      this.nEi = str;
      y.i("MicroMsg.RemittanceResultNewUI", "payScene: %s", new Object[] { Integer.valueOf(i) });
      initView();
    } while (this.nzY != 31);
    y.i("MicroMsg.RemittanceResultNewUI", "transId: %s", new Object[] { paramBundle });
    b.bvS().bvV().ex(paramBundle, this.nEi);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (WalletSuccPageAwardWidget.a(this.nBp)) {
      this.nBq.onDestroy();
    }
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      bwK();
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public void onResume()
  {
    super.onResume();
    if (WalletSuccPageAwardWidget.a(this.nBp)) {
      this.nBq.onResume();
    }
  }
  
  public final void vN(int paramInt)
  {
    this.mController.contentView.setVisibility(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceResultNewUI
 * JD-Core Version:    0.7.0.1
 */