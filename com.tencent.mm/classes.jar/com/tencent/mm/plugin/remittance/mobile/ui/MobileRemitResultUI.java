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
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.lo;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.bnn;
import com.tencent.mm.protocal.protobuf.boa;
import com.tencent.mm.protocal.protobuf.dkc;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.tools.p;
import com.tencent.mm.wallet_core.c.l;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import java.util.LinkedList;

public class MobileRemitResultUI
  extends MobileRemitBaseUI
{
  private TextView lgw;
  private View mLine;
  private String mReqKey;
  private Button sZP;
  private TextView uhO;
  public String vsE;
  private ImageView wIB;
  private LinearLayout wIC;
  private TextView wID;
  private WalletTextView wIE;
  private LinearLayout wIF;
  public String wIG;
  public String wIH;
  public String wII;
  public int wIJ;
  public String wIK;
  public String wIL;
  public int wIM;
  private String wIN;
  private String wIO;
  private LinearLayout wIs;
  private PayInfo wfX;
  
  private void MA(int paramInt)
  {
    AppMethodBeat.i(67751);
    if (paramInt == 0)
    {
      this.wIB.setImageDrawable(com.tencent.mm.cc.a.l(this, 2131690392));
      this.wIB.getDrawable().setColorFilter(getResources().getColor(2131099699), PorterDuff.Mode.SRC_ATOP);
      AppMethodBeat.o(67751);
      return;
    }
    this.wIB.setImageDrawable(com.tencent.mm.cc.a.l(this, 2131690487));
    this.wIB.getDrawable().setColorFilter(getResources().getColor(2131099689), PorterDuff.Mode.SRC_ATOP);
    AppMethodBeat.o(67751);
  }
  
  private void a(final dkc paramdkc)
  {
    AppMethodBeat.i(67750);
    if (paramdkc == null)
    {
      MA(this.wIM);
      this.wIC.post(new Runnable()
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
      this.wIE.setText(com.tencent.mm.wallet_core.ui.e.d(this.wIJ / 100.0D, "CNY"));
      this.mLine.setVisibility(8);
      this.wIF.setVisibility(8);
    }
    for (;;)
    {
      p.a(getContext(), (ScrollView)findViewById(2131304251), findViewById(2131297457), findViewById(2131297476), findViewById(2131297452), 48);
      AppMethodBeat.o(67750);
      return;
      MA(paramdkc.FSS);
      if (paramdkc.FSQ != null)
      {
        this.wIs.setVisibility(0);
        this.uhO.setText(paramdkc.FSQ.dlQ);
        this.wIs.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(67746);
            ac.i("MicroMsg.mobileRemit.MobileRemitResultUI", "notice click!");
            l.a(MobileRemitResultUI.this.getContext(), paramdkc.FSQ, null, new com.tencent.mm.plugin.remittance.mobile.a.a()
            {
              public final void dC(Object paramAnonymous2Object)
              {
                AppMethodBeat.i(67745);
                ac.i("MicroMsg.mobileRemit.MobileRemitResultUI", "notice click jumpItem.action:continue");
                AppMethodBeat.o(67745);
              }
              
              public final void dxN()
              {
                AppMethodBeat.i(67744);
                ac.i("MicroMsg.mobileRemit.MobileRemitResultUI", "notice click jumpItem.action:exit");
                MobileRemitResultUI.this.dxM();
                AppMethodBeat.o(67744);
              }
            });
            AppMethodBeat.o(67746);
          }
        });
      }
      if ((paramdkc.FTa != null) && (!paramdkc.FTa.isEmpty()))
      {
        int i = 0;
        while (i < paramdkc.FTa.size())
        {
          boa localboa = (boa)paramdkc.FTa.get(i);
          View localView = getLayoutInflater().inflate(2131494931, null);
          ((TextView)localView.findViewById(2131301250)).setText(localboa.key);
          ((TextView)localView.findViewById(2131306265)).setText(localboa.value);
          this.wIF.addView(localView);
          i += 1;
        }
        this.wIF.setVisibility(0);
        this.mLine.setVisibility(0);
      }
      else
      {
        this.wIF.setVisibility(8);
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
    this.wIs = ((LinearLayout)findViewById(2131302405));
    this.uhO = ((TextView)findViewById(2131297186));
    this.wIB = ((ImageView)findViewById(2131302399));
    this.wIC = ((LinearLayout)findViewById(2131302398));
    this.lgw = ((TextView)findViewById(2131302397));
    this.wID = ((TextView)findViewById(2131302400));
    this.wIE = ((WalletTextView)findViewById(2131302401));
    this.wIE.setTypeface(0);
    this.mLine = findViewById(2131302403);
    this.wIF = ((LinearLayout)findViewById(2131302404));
    this.sZP = ((Button)findViewById(2131302402));
    this.sZP.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67742);
        ac.i("MicroMsg.mobileRemit.MobileRemitResultUI", "mFinishBt click");
        MobileRemitResultUI.this.dxM();
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
    this.wfX = ((PayInfo)getInput().getParcelable("key_pay_info"));
    if ((this.wfX != null) && (this.wfX.hbR != null))
    {
      paramBundle = this.wfX.hbR;
      this.wIG = paramBundle.getString("extinfo_key_1");
      this.vsE = paramBundle.getString("extinfo_key_2");
      this.wIH = paramBundle.getString("extinfo_key_3");
      this.wII = paramBundle.getString("extinfo_key_4");
      this.wIJ = paramBundle.getInt("extinfo_key_5");
      this.wIK = paramBundle.getString("extinfo_key_6");
      this.wIL = paramBundle.getString("extinfo_key_7");
      this.wIM = paramBundle.getInt("extinfo_key_8");
      this.wIN = paramBundle.getString("extinfo_key_9");
      this.wIO = paramBundle.getString("extinfo_key_10");
      this.mReqKey = paramBundle.getString("extinfo_key_11");
    }
    for (;;)
    {
      initView();
      doSceneProgress(new com.tencent.mm.plugin.remittance.mobile.cgi.e(this.wIG, this.vsE, this.wIH, this.wII, this.wIJ, this.wIK, this.wIL));
      addSceneEndListener(1903);
      paramBundle = new lo();
      paramBundle.dnx.dac = this.mReqKey;
      com.tencent.mm.sdk.b.a.GpY.l(paramBundle);
      AppMethodBeat.o(67747);
      return;
      ac.i("MicroMsg.mobileRemit.MobileRemitResultUI", "payInfo != null && payInfo.extInfo != null");
      dxM();
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
      ac.i("MicroMsg.mobileRemit.MobileRemitResultUI", "onKeyUp KEYCODE_BACK click");
      dxM();
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(67749);
    return bool;
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(67753);
    ac.i("MicroMsg.mobileRemit.MobileRemitResultUI", "errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scenetype:" + paramn.getType());
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramn instanceof com.tencent.mm.plugin.remittance.mobile.cgi.e)))
    {
      paramString = (com.tencent.mm.plugin.remittance.mobile.cgi.e)paramn;
      if (paramString.wHA == null) {}
      for (paramString = null; paramString == null; paramString = paramString.wHA)
      {
        ac.e("MicroMsg.mobileRemit.MobileRemitResultUI", "NetSceneMobileRemitGetSuccPage succPageResp is null");
        AppMethodBeat.o(67753);
        return true;
      }
      if (paramString.nWx != 0) {
        break label143;
      }
      a(paramString);
    }
    for (;;)
    {
      AppMethodBeat.o(67753);
      return false;
      label143:
      ac.i("MicroMsg.mobileRemit.MobileRemitResultUI", "NetSceneMobileRemitGetSuccPage ret_code:%s ret_msg:%s", new Object[] { Integer.valueOf(paramString.nWx), paramString.nWy });
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