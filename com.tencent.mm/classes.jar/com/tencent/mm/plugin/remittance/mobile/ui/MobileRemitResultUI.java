package com.tencent.mm.plugin.remittance.mobile.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.om;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.remittance.mobile.cgi.e;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.dfc;
import com.tencent.mm.protocal.protobuf.dfp;
import com.tencent.mm.protocal.protobuf.fqb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.model.l;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.i;
import com.tencent.mm.wallet_core.ui.k;
import java.util.HashSet;
import java.util.LinkedList;

public class MobileRemitResultUI
  extends MobileRemitBaseUI
{
  private Button Ize;
  private TextView Knx;
  public String MyF;
  private PayInfo Nxi;
  private ImageView OgG;
  private LinearLayout OgH;
  private TextView OgI;
  private WalletTextView OgJ;
  private LinearLayout OgK;
  public String OgL;
  public String OgM;
  public String OgN;
  public int OgO;
  public String OgP;
  public String OgQ;
  public int OgR;
  private String OgS;
  private String OgT;
  private LinearLayout Ogx;
  private View mLine;
  private String mReqKey;
  private TextView pJi;
  
  private void a(final fqb paramfqb)
  {
    AppMethodBeat.i(67750);
    if (paramfqb == null)
    {
      ahk(this.OgR);
      this.OgH.post(new Runnable()
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
      this.OgJ.setText(i.e(this.OgO / 100.0D, "CNY"));
      this.mLine.setVisibility(8);
      this.OgK.setVisibility(8);
    }
    for (;;)
    {
      com.tencent.mm.ui.tools.p.a(getContext(), (ScrollView)findViewById(a.f.root_view), findViewById(a.f.bottom_parent_ll), findViewById(a.f.bottom_up_ll), findViewById(a.f.bottom_layout), 48);
      AppMethodBeat.o(67750);
      return;
      ahk(paramfqb.abPI);
      if (paramfqb.abPG != null)
      {
        this.Ogx.setVisibility(0);
        this.Knx.setText(paramfqb.abPG.wording);
        this.Ogx.setOnClickListener(new k()
        {
          public final void dr(View paramAnonymousView)
          {
            AppMethodBeat.i(288902);
            Log.i("MicroMsg.mobileRemit.MobileRemitResultUI", "notice click!");
            l.a(MobileRemitResultUI.this.getContext(), paramfqb.abPG, null, new com.tencent.mm.plugin.remittance.mobile.a.a()
            {
              public final void dJE()
              {
                AppMethodBeat.i(67744);
                Log.i("MicroMsg.mobileRemit.MobileRemitResultUI", "notice click jumpItem.action:exit");
                MobileRemitResultUI.this.gLX();
                AppMethodBeat.o(67744);
              }
              
              public final void go(Object paramAnonymous2Object)
              {
                AppMethodBeat.i(67745);
                Log.i("MicroMsg.mobileRemit.MobileRemitResultUI", "notice click jumpItem.action:continue");
                AppMethodBeat.o(67745);
              }
            });
            AppMethodBeat.o(288902);
          }
        });
      }
      if ((paramfqb.abPP != null) && (!paramfqb.abPP.isEmpty()))
      {
        int i = 0;
        while (i < paramfqb.abPP.size())
        {
          dfp localdfp = (dfp)paramfqb.abPP.get(i);
          View localView = getLayoutInflater().inflate(a.g.mobile_remit_result_item, null);
          ((TextView)localView.findViewById(a.f.key_tv)).setText(localdfp.key);
          ((TextView)localView.findViewById(a.f.value_tv)).setText(localdfp.value);
          this.OgK.addView(localView);
          i += 1;
        }
        this.OgK.setVisibility(0);
        this.mLine.setVisibility(0);
      }
      else
      {
        this.OgK.setVisibility(8);
        this.mLine.setVisibility(8);
      }
    }
  }
  
  private void ahk(int paramInt)
  {
    AppMethodBeat.i(67751);
    if (paramInt == 0)
    {
      this.OgG.setImageDrawable(com.tencent.mm.cd.a.m(this, a.h.icons_filled_done2));
      this.OgG.getDrawable().setColorFilter(getResources().getColor(a.c.Brand), PorterDuff.Mode.SRC_ATOP);
      AppMethodBeat.o(67751);
      return;
    }
    this.OgG.setImageDrawable(com.tencent.mm.cd.a.m(this, a.h.icons_filled_time));
    this.OgG.getDrawable().setColorFilter(getResources().getColor(a.c.Blue), PorterDuff.Mode.SRC_ATOP);
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
    this.Ogx = ((LinearLayout)findViewById(a.f.mobile_remit_result_notice_ui));
    this.Knx = ((TextView)findViewById(a.f.banner_tips));
    this.OgG = ((ImageView)findViewById(a.f.mobile_remit_result_desc_icon));
    this.OgH = ((LinearLayout)findViewById(a.f.mobile_remit_result_desc_container));
    this.pJi = ((TextView)findViewById(a.f.mobile_remit_result_desc));
    this.OgI = ((TextView)findViewById(a.f.mobile_remit_result_desc_suffix));
    this.OgJ = ((WalletTextView)findViewById(a.f.mobile_remit_result_fee));
    this.OgJ.setTypeface(0);
    this.mLine = findViewById(a.f.mobile_remit_result_line1);
    this.OgK = ((LinearLayout)findViewById(a.f.mobile_remit_result_list_layout));
    this.Ize = ((Button)findViewById(a.f.mobile_remit_result_finish_btn));
    this.Ize.setOnClickListener(new k()
    {
      public final void dr(View paramAnonymousView)
      {
        AppMethodBeat.i(288903);
        Log.i("MicroMsg.mobileRemit.MobileRemitResultUI", "mFinishBt click");
        MobileRemitResultUI.this.gLX();
        AppMethodBeat.o(288903);
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
    b.jNX();
    boolean bool1 = b.b(c.a.yRc, true);
    b.jNX();
    boolean bool2 = b.b(c.a.yWU, true);
    Log.i("MicroMsg.mobileRemit.MobileRemitResultUI", "isKindaEnable: %s，isKindaMobileRemittanceEnable ：%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    if ((bool1) && (bool2))
    {
      if (i == 0) {
        break label320;
      }
      Log.i("MicroMsg.mobileRemit.MobileRemitResultUI", "use Kinda");
      if ((getIntent() == null) || (getIntent().getExtras() == null)) {
        break label320;
      }
      paramBundle = getIntent().getExtras();
      this.OgL = paramBundle.getString("extinfo_key_1");
      this.MyF = paramBundle.getString("extinfo_key_2");
      this.OgM = paramBundle.getString("extinfo_key_3");
      this.OgN = paramBundle.getString("extinfo_key_4");
      this.OgO = paramBundle.getInt("extinfo_key_5");
      this.OgP = paramBundle.getString("extinfo_key_6");
      this.OgQ = paramBundle.getString("extinfo_key_7");
      this.OgR = paramBundle.getInt("extinfo_key_8");
      this.OgS = paramBundle.getString("extinfo_key_9");
      this.OgT = paramBundle.getString("extinfo_key_10");
      this.mReqKey = paramBundle.getString("extinfo_key_11");
    }
    for (;;)
    {
      initView();
      doSceneProgress(new e(this.OgL, this.MyF, this.OgM, this.OgN, this.OgO, this.OgP, this.OgQ));
      addSceneEndListener(1903);
      paramBundle = new om();
      paramBundle.hRi.hAT = this.mReqKey;
      paramBundle.publish();
      AppMethodBeat.o(67747);
      return;
      i = 0;
      break;
      label320:
      this.Nxi = ((PayInfo)getInput().getParcelable("key_pay_info"));
      if ((this.Nxi != null) && (this.Nxi.nKf != null))
      {
        Log.i("MicroMsg.mobileRemit.MobileRemitResultUI", "use native");
        paramBundle = this.Nxi.nKf;
        this.OgL = paramBundle.getString("extinfo_key_1");
        this.MyF = paramBundle.getString("extinfo_key_2");
        this.OgM = paramBundle.getString("extinfo_key_3");
        this.OgN = paramBundle.getString("extinfo_key_4");
        this.OgO = paramBundle.getInt("extinfo_key_5");
        this.OgP = paramBundle.getString("extinfo_key_6");
        this.OgQ = paramBundle.getString("extinfo_key_7");
        this.OgR = paramBundle.getInt("extinfo_key_8");
        this.OgS = paramBundle.getString("extinfo_key_9");
        this.OgT = paramBundle.getString("extinfo_key_10");
        this.mReqKey = paramBundle.getString("extinfo_key_11");
      }
      else
      {
        Log.i("MicroMsg.mobileRemit.MobileRemitResultUI", "payInfo != null && payInfo.extInfo != null");
        gLX();
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
      gLX();
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(67749);
    return bool;
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(67753);
    Log.i("MicroMsg.mobileRemit.MobileRemitResultUI", "errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scenetype:" + paramp.getType());
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramp instanceof e)))
    {
      paramString = (e)paramp;
      if (paramString.OfE == null) {}
      for (paramString = null; paramString == null; paramString = paramString.OfE)
      {
        Log.e("MicroMsg.mobileRemit.MobileRemitResultUI", "NetSceneMobileRemitGetSuccPage succPageResp is null");
        AppMethodBeat.o(67753);
        return true;
      }
      if (paramString.wuz != 0) {
        break label143;
      }
      a(paramString);
    }
    for (;;)
    {
      AppMethodBeat.o(67753);
      return false;
      label143:
      Log.i("MicroMsg.mobileRemit.MobileRemitResultUI", "NetSceneMobileRemitGetSuccPage ret_code:%s ret_msg:%s", new Object[] { Integer.valueOf(paramString.wuz), paramString.wuA });
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(288908);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(MobileRemitResultUI.a.class);
    AppMethodBeat.o(288908);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.ui.MobileRemitResultUI
 * JD-Core Version:    0.7.0.1
 */