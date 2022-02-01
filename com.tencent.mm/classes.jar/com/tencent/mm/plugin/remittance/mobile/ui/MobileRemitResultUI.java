package com.tencent.mm.plugin.remittance.mobile.ui;

import android.app.Activity;
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
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.lf;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.bjt;
import com.tencent.mm.protocal.protobuf.bkg;
import com.tencent.mm.protocal.protobuf.den;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.tools.p;
import com.tencent.mm.wallet_core.c.l;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import java.util.LinkedList;

public class MobileRemitResultUI
  extends MobileRemitBaseUI
{
  private TextView kFd;
  private View mLine;
  private String mReqKey;
  private Button rRZ;
  private TextView sZA;
  private PayInfo uXi;
  public String ujI;
  private LinearLayout vyA;
  public String vyB;
  public String vyC;
  public String vyD;
  public int vyE;
  public String vyF;
  public String vyG;
  public int vyH;
  private String vyI;
  private String vyJ;
  private LinearLayout vyn;
  private ImageView vyw;
  private LinearLayout vyx;
  private TextView vyy;
  private WalletTextView vyz;
  
  private void KB(int paramInt)
  {
    AppMethodBeat.i(67751);
    if (paramInt == 0)
    {
      this.vyw.setImageDrawable(com.tencent.mm.cd.a.l(this, 2131690392));
      this.vyw.getDrawable().setColorFilter(getResources().getColor(2131099699), PorterDuff.Mode.SRC_ATOP);
      AppMethodBeat.o(67751);
      return;
    }
    this.vyw.setImageDrawable(com.tencent.mm.cd.a.l(this, 2131690487));
    this.vyw.getDrawable().setColorFilter(getResources().getColor(2131099689), PorterDuff.Mode.SRC_ATOP);
    AppMethodBeat.o(67751);
  }
  
  private void a(final den paramden)
  {
    AppMethodBeat.i(67750);
    if (paramden == null)
    {
      KB(this.vyH);
      this.vyx.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(67743);
          int i = MobileRemitResultUI.a(MobileRemitResultUI.this).getMeasuredWidth();
          String str1 = MobileRemitResultUI.this.getString(2131761284, new Object[] { MobileRemitResultUI.b(MobileRemitResultUI.this) });
          String str2 = MobileRemitResultUI.this.getString(2131761285, new Object[] { MobileRemitResultUI.c(MobileRemitResultUI.this) });
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
      this.vyz.setText(com.tencent.mm.wallet_core.ui.e.d(this.vyE / 100.0D, "CNY"));
      this.mLine.setVisibility(8);
      this.vyA.setVisibility(8);
    }
    for (;;)
    {
      p.a(getContext(), (ScrollView)findViewById(2131304251), findViewById(2131297457), findViewById(2131297476), findViewById(2131297452), 48);
      AppMethodBeat.o(67750);
      return;
      KB(paramden.EvP);
      if (paramden.EvN != null)
      {
        this.vyn.setVisibility(0);
        this.sZA.setText(paramden.EvN.doh);
        this.vyn.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(67746);
            ad.i("MicroMsg.mobileRemit.MobileRemitResultUI", "notice click!");
            l.a(MobileRemitResultUI.this.getContext(), paramden.EvN, null, new com.tencent.mm.plugin.remittance.mobile.a.a()
            {
              public final void dB(Object paramAnonymous2Object)
              {
                AppMethodBeat.i(67745);
                ad.i("MicroMsg.mobileRemit.MobileRemitResultUI", "notice click jumpItem.action:continue");
                AppMethodBeat.o(67745);
              }
              
              public final void djL()
              {
                AppMethodBeat.i(67744);
                ad.i("MicroMsg.mobileRemit.MobileRemitResultUI", "notice click jumpItem.action:exit");
                MobileRemitResultUI.this.djK();
                AppMethodBeat.o(67744);
              }
            });
            AppMethodBeat.o(67746);
          }
        });
      }
      if ((paramden.EvX != null) && (!paramden.EvX.isEmpty()))
      {
        int i = 0;
        while (i < paramden.EvX.size())
        {
          bkg localbkg = (bkg)paramden.EvX.get(i);
          View localView = getLayoutInflater().inflate(2131494931, null);
          ((TextView)localView.findViewById(2131301250)).setText(localbkg.key);
          ((TextView)localView.findViewById(2131306265)).setText(localbkg.value);
          this.vyA.addView(localView);
          i += 1;
        }
        this.vyA.setVisibility(0);
        this.mLine.setVisibility(0);
      }
      else
      {
        this.vyA.setVisibility(8);
        this.mLine.setVisibility(8);
      }
    }
  }
  
  public int getLayoutId()
  {
    return 2131494932;
  }
  
  public void initView()
  {
    AppMethodBeat.i(67748);
    super.initView();
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(2131101179));
    setBackGroundColorResource(2131101179);
    setBackBtn(null);
    setBackBtnVisible(false);
    this.vyn = ((LinearLayout)findViewById(2131302405));
    this.sZA = ((TextView)findViewById(2131297186));
    this.vyw = ((ImageView)findViewById(2131302399));
    this.vyx = ((LinearLayout)findViewById(2131302398));
    this.kFd = ((TextView)findViewById(2131302397));
    this.vyy = ((TextView)findViewById(2131302400));
    this.vyz = ((WalletTextView)findViewById(2131302401));
    this.vyz.setTypeface(0);
    this.mLine = findViewById(2131302403);
    this.vyA = ((LinearLayout)findViewById(2131302404));
    this.rRZ = ((Button)findViewById(2131302402));
    this.rRZ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67742);
        ad.i("MicroMsg.mobileRemit.MobileRemitResultUI", "mFinishBt click");
        MobileRemitResultUI.this.djK();
        AppMethodBeat.o(67742);
      }
    });
    a(null);
    AppMethodBeat.o(67748);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(67747);
    super.onCreate(paramBundle);
    this.uXi = ((PayInfo)getInput().getParcelable("key_pay_info"));
    if ((this.uXi != null) && (this.uXi.Cos != null))
    {
      paramBundle = this.uXi.Cos;
      this.vyB = paramBundle.getString("extinfo_key_1");
      this.ujI = paramBundle.getString("extinfo_key_2");
      this.vyC = paramBundle.getString("extinfo_key_3");
      this.vyD = paramBundle.getString("extinfo_key_4");
      this.vyE = paramBundle.getInt("extinfo_key_5");
      this.vyF = paramBundle.getString("extinfo_key_6");
      this.vyG = paramBundle.getString("extinfo_key_7");
      this.vyH = paramBundle.getInt("extinfo_key_8");
      this.vyI = paramBundle.getString("extinfo_key_9");
      this.vyJ = paramBundle.getString("extinfo_key_10");
      this.mReqKey = paramBundle.getString("extinfo_key_11");
    }
    for (;;)
    {
      initView();
      doSceneProgress(new com.tencent.mm.plugin.remittance.mobile.cgi.e(this.vyB, this.ujI, this.vyC, this.vyD, this.vyE, this.vyF, this.vyG));
      addSceneEndListener(1903);
      paramBundle = new lf();
      paramBundle.dpM.dcE = this.mReqKey;
      com.tencent.mm.sdk.b.a.ESL.l(paramBundle);
      AppMethodBeat.o(67747);
      return;
      ad.i("MicroMsg.mobileRemit.MobileRemitResultUI", "payInfo != null && payInfo.extInfo != null");
      djK();
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
      ad.i("MicroMsg.mobileRemit.MobileRemitResultUI", "onKeyUp KEYCODE_BACK click");
      djK();
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(67749);
    return bool;
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(67753);
    ad.i("MicroMsg.mobileRemit.MobileRemitResultUI", "errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scenetype:" + paramn.getType());
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramn instanceof com.tencent.mm.plugin.remittance.mobile.cgi.e)))
    {
      paramString = (com.tencent.mm.plugin.remittance.mobile.cgi.e)paramn;
      if (paramString.vxv == null) {}
      for (paramString = null; paramString == null; paramString = paramString.vxv)
      {
        ad.e("MicroMsg.mobileRemit.MobileRemitResultUI", "NetSceneMobileRemitGetSuccPage succPageResp is null");
        AppMethodBeat.o(67753);
        return true;
      }
      if (paramString.ntx != 0) {
        break label143;
      }
      a(paramString);
    }
    for (;;)
    {
      AppMethodBeat.o(67753);
      return false;
      label143:
      ad.i("MicroMsg.mobileRemit.MobileRemitResultUI", "NetSceneMobileRemitGetSuccPage ret_code:%s ret_msg:%s", new Object[] { Integer.valueOf(paramString.ntx), paramString.nty });
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