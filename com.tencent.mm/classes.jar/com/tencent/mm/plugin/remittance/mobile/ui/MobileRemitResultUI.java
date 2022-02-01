package com.tencent.mm.plugin.remittance.mobile.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.nf;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.remittance.mobile.cgi.e;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.coi;
import com.tencent.mm.protocal.protobuf.cov;
import com.tencent.mm.protocal.protobuf.euo;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.l;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.g;
import java.util.LinkedList;

public class MobileRemitResultUI
  extends MobileRemitBaseUI
{
  private Button CFb;
  private TextView EuQ;
  public String GCu;
  private PayInfo HzF;
  private LinearLayout IjL;
  private ImageView IjU;
  private LinearLayout IjV;
  private TextView IjW;
  private WalletTextView IjX;
  private LinearLayout IjY;
  public String IjZ;
  public String Ika;
  public String Ikb;
  public int Ikc;
  public String Ikd;
  public String Ike;
  public int Ikf;
  private String Ikg;
  private String Ikh;
  private View mLine;
  private TextView mMA;
  private String mReqKey;
  
  private void a(final euo parameuo)
  {
    AppMethodBeat.i(67750);
    if (parameuo == null)
    {
      acR(this.Ikf);
      this.IjV.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(67743);
          int i = MobileRemitResultUI.a(MobileRemitResultUI.this).getMeasuredWidth();
          String str1 = MobileRemitResultUI.this.getString(a.i.mobile_remit_result_desc, new Object[] { MobileRemitResultUI.b(MobileRemitResultUI.this) });
          String str2 = MobileRemitResultUI.this.getString(a.i.mobile_remit_result_desc2, new Object[] { MobileRemitResultUI.c(MobileRemitResultUI.this) });
          if (i != 0)
          {
            float f1 = MobileRemitResultUI.d(MobileRemitResultUI.this).getPaint().measureText(str1);
            float f2 = MobileRemitResultUI.e(MobileRemitResultUI.this).getPaint().measureText(str2);
            if (f1 + f2 > i)
            {
              LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)MobileRemitResultUI.d(MobileRemitResultUI.this).getLayoutParams();
              localLayoutParams.width = ((int)(i - f2));
              MobileRemitResultUI.d(MobileRemitResultUI.this).setLayoutParams(localLayoutParams);
            }
          }
          MobileRemitResultUI.d(MobileRemitResultUI.this).setText(str1);
          MobileRemitResultUI.e(MobileRemitResultUI.this).setText(str2);
          AppMethodBeat.o(67743);
        }
      });
      this.IjX.setText(g.d(this.Ikc / 100.0D, "CNY"));
      this.mLine.setVisibility(8);
      this.IjY.setVisibility(8);
    }
    for (;;)
    {
      com.tencent.mm.ui.tools.q.a(getContext(), (ScrollView)findViewById(a.f.root_view), findViewById(a.f.bottom_parent_ll), findViewById(a.f.bottom_up_ll), findViewById(a.f.bottom_layout), 48);
      AppMethodBeat.o(67750);
      return;
      acR(parameuo.Uwc);
      if (parameuo.Uwa != null)
      {
        this.IjL.setVisibility(0);
        this.EuQ.setText(parameuo.Uwa.wording);
        this.IjL.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(67746);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitResultUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            Log.i("MicroMsg.mobileRemit.MobileRemitResultUI", "notice click!");
            l.a(MobileRemitResultUI.this.getContext(), parameuo.Uwa, null, new com.tencent.mm.plugin.remittance.mobile.a.a()
            {
              public final void dS(Object paramAnonymous2Object)
              {
                AppMethodBeat.i(67745);
                Log.i("MicroMsg.mobileRemit.MobileRemitResultUI", "notice click jumpItem.action:continue");
                AppMethodBeat.o(67745);
              }
              
              public final void fAl()
              {
                AppMethodBeat.i(67744);
                Log.i("MicroMsg.mobileRemit.MobileRemitResultUI", "notice click jumpItem.action:exit");
                MobileRemitResultUI.this.fAk();
                AppMethodBeat.o(67744);
              }
            });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitResultUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(67746);
          }
        });
      }
      if ((parameuo.Uwj != null) && (!parameuo.Uwj.isEmpty()))
      {
        int i = 0;
        while (i < parameuo.Uwj.size())
        {
          cov localcov = (cov)parameuo.Uwj.get(i);
          View localView = getLayoutInflater().inflate(a.g.mobile_remit_result_item, null);
          ((TextView)localView.findViewById(a.f.key_tv)).setText(localcov.key);
          ((TextView)localView.findViewById(a.f.value_tv)).setText(localcov.value);
          this.IjY.addView(localView);
          i += 1;
        }
        this.IjY.setVisibility(0);
        this.mLine.setVisibility(0);
      }
      else
      {
        this.IjY.setVisibility(8);
        this.mLine.setVisibility(8);
      }
    }
  }
  
  private void acR(int paramInt)
  {
    AppMethodBeat.i(67751);
    if (paramInt == 0)
    {
      this.IjU.setImageDrawable(com.tencent.mm.ci.a.m(this, a.h.icons_filled_done2));
      this.IjU.getDrawable().setColorFilter(getResources().getColor(a.c.Brand), PorterDuff.Mode.SRC_ATOP);
      AppMethodBeat.o(67751);
      return;
    }
    this.IjU.setImageDrawable(com.tencent.mm.ci.a.m(this, a.h.icons_filled_time));
    this.IjU.getDrawable().setColorFilter(getResources().getColor(a.c.Blue), PorterDuff.Mode.SRC_ATOP);
    AppMethodBeat.o(67751);
  }
  
  public int getLayoutId()
  {
    return a.g.mobile_remit_result_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(67748);
    super.initView();
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(a.c.white));
    setBackGroundColorResource(a.c.white);
    setBackBtn(null);
    setBackBtnVisible(false);
    this.IjL = ((LinearLayout)findViewById(a.f.mobile_remit_result_notice_ui));
    this.EuQ = ((TextView)findViewById(a.f.banner_tips));
    this.IjU = ((ImageView)findViewById(a.f.mobile_remit_result_desc_icon));
    this.IjV = ((LinearLayout)findViewById(a.f.mobile_remit_result_desc_container));
    this.mMA = ((TextView)findViewById(a.f.mobile_remit_result_desc));
    this.IjW = ((TextView)findViewById(a.f.mobile_remit_result_desc_suffix));
    this.IjX = ((WalletTextView)findViewById(a.f.mobile_remit_result_fee));
    this.IjX.setTypeface(0);
    this.mLine = findViewById(a.f.mobile_remit_result_line1);
    this.IjY = ((LinearLayout)findViewById(a.f.mobile_remit_result_list_layout));
    this.CFb = ((Button)findViewById(a.f.mobile_remit_result_finish_btn));
    this.CFb.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67742);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitResultUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        Log.i("MicroMsg.mobileRemit.MobileRemitResultUI", "mFinishBt click");
        MobileRemitResultUI.this.fAk();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitResultUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(67742);
      }
    });
    a(null);
    AppMethodBeat.o(67748);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int i = 1;
    AppMethodBeat.i(67747);
    super.onCreate(paramBundle);
    com.tencent.mm.wallet_core.b.iie();
    boolean bool1 = com.tencent.mm.wallet_core.b.b(b.a.vCG, true);
    com.tencent.mm.wallet_core.b.iie();
    boolean bool2 = com.tencent.mm.wallet_core.b.b(b.a.vHa, false);
    Log.i("MicroMsg.mobileRemit.MobileRemitResultUI", "isKindaEnable: %s，isKindaMobileRemittanceEnable ：%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    if ((bool1) && (bool2))
    {
      if (i == 0) {
        break label323;
      }
      Log.i("MicroMsg.mobileRemit.MobileRemitResultUI", "use Kinda");
      if ((getIntent() == null) || (getIntent().getExtras() == null)) {
        break label323;
      }
      paramBundle = getIntent().getExtras();
      this.IjZ = paramBundle.getString("extinfo_key_1");
      this.GCu = paramBundle.getString("extinfo_key_2");
      this.Ika = paramBundle.getString("extinfo_key_3");
      this.Ikb = paramBundle.getString("extinfo_key_4");
      this.Ikc = paramBundle.getInt("extinfo_key_5");
      this.Ikd = paramBundle.getString("extinfo_key_6");
      this.Ike = paramBundle.getString("extinfo_key_7");
      this.Ikf = paramBundle.getInt("extinfo_key_8");
      this.Ikg = paramBundle.getString("extinfo_key_9");
      this.Ikh = paramBundle.getString("extinfo_key_10");
      this.mReqKey = paramBundle.getString("extinfo_key_11");
    }
    for (;;)
    {
      initView();
      doSceneProgress(new e(this.IjZ, this.GCu, this.Ika, this.Ikb, this.Ikc, this.Ikd, this.Ike));
      addSceneEndListener(1903);
      paramBundle = new nf();
      paramBundle.fLA.fwv = this.mReqKey;
      EventCenter.instance.publish(paramBundle);
      AppMethodBeat.o(67747);
      return;
      i = 0;
      break;
      label323:
      this.HzF = ((PayInfo)getInput().getParcelable("key_pay_info"));
      if ((this.HzF != null) && (this.HzF.lfu != null))
      {
        Log.i("MicroMsg.mobileRemit.MobileRemitResultUI", "use native");
        paramBundle = this.HzF.lfu;
        this.IjZ = paramBundle.getString("extinfo_key_1");
        this.GCu = paramBundle.getString("extinfo_key_2");
        this.Ika = paramBundle.getString("extinfo_key_3");
        this.Ikb = paramBundle.getString("extinfo_key_4");
        this.Ikc = paramBundle.getInt("extinfo_key_5");
        this.Ikd = paramBundle.getString("extinfo_key_6");
        this.Ike = paramBundle.getString("extinfo_key_7");
        this.Ikf = paramBundle.getInt("extinfo_key_8");
        this.Ikg = paramBundle.getString("extinfo_key_9");
        this.Ikh = paramBundle.getString("extinfo_key_10");
        this.mReqKey = paramBundle.getString("extinfo_key_11");
      }
      else
      {
        Log.i("MicroMsg.mobileRemit.MobileRemitResultUI", "payInfo != null && payInfo.extInfo != null");
        fAk();
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(67752);
    super.onDestroy();
    removeSceneEndListener(1903);
    AppMethodBeat.o(67752);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(67749);
    if (paramInt == 4)
    {
      Log.i("MicroMsg.mobileRemit.MobileRemitResultUI", "onKeyUp KEYCODE_BACK click");
      fAk();
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(67749);
    return bool;
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(67753);
    Log.i("MicroMsg.mobileRemit.MobileRemitResultUI", "errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scenetype:" + paramq.getType());
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramq instanceof e)))
    {
      paramString = (e)paramq;
      if (paramString.IiT == null) {}
      for (paramString = null; paramString == null; paramString = paramString.IiT)
      {
        Log.e("MicroMsg.mobileRemit.MobileRemitResultUI", "NetSceneMobileRemitGetSuccPage succPageResp is null");
        AppMethodBeat.o(67753);
        return true;
      }
      if (paramString.tqa != 0) {
        break label143;
      }
      a(paramString);
    }
    for (;;)
    {
      AppMethodBeat.o(67753);
      return false;
      label143:
      Log.i("MicroMsg.mobileRemit.MobileRemitResultUI", "NetSceneMobileRemitGetSuccPage ret_code:%s ret_msg:%s", new Object[] { Integer.valueOf(paramString.tqa), paramString.tqb });
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.ui.MobileRemitResultUI
 * JD-Core Version:    0.7.0.1
 */