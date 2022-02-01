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
import com.tencent.mm.g.a.lx;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.bry;
import com.tencent.mm.protocal.protobuf.bsm;
import com.tencent.mm.protocal.protobuf.dpr;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.tools.p;
import com.tencent.mm.wallet_core.c.l;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import java.util.LinkedList;

public class MobileRemitResultUI
  extends MobileRemitBaseUI
{
  private TextView lDu;
  private View mLine;
  private String mReqKey;
  private Button tXG;
  private TextView vky;
  public String wxW;
  private LinearLayout xVZ;
  private ImageView xWi;
  private LinearLayout xWj;
  private TextView xWk;
  private WalletTextView xWl;
  private LinearLayout xWm;
  public String xWn;
  public String xWo;
  public String xWp;
  public int xWq;
  public String xWr;
  public String xWs;
  public int xWt;
  private String xWu;
  private String xWv;
  private PayInfo xnF;
  
  private void Oc(int paramInt)
  {
    AppMethodBeat.i(67751);
    if (paramInt == 0)
    {
      this.xWi.setImageDrawable(com.tencent.mm.cc.a.l(this, 2131690392));
      this.xWi.getDrawable().setColorFilter(getResources().getColor(2131099699), PorterDuff.Mode.SRC_ATOP);
      AppMethodBeat.o(67751);
      return;
    }
    this.xWi.setImageDrawable(com.tencent.mm.cc.a.l(this, 2131690487));
    this.xWi.getDrawable().setColorFilter(getResources().getColor(2131099689), PorterDuff.Mode.SRC_ATOP);
    AppMethodBeat.o(67751);
  }
  
  private void a(final dpr paramdpr)
  {
    AppMethodBeat.i(67750);
    if (paramdpr == null)
    {
      Oc(this.xWt);
      this.xWj.post(new Runnable()
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
      this.xWl.setText(com.tencent.mm.wallet_core.ui.e.d(this.xWq / 100.0D, "CNY"));
      this.mLine.setVisibility(8);
      this.xWm.setVisibility(8);
    }
    for (;;)
    {
      p.a(getContext(), (ScrollView)findViewById(2131304251), findViewById(2131297457), findViewById(2131297476), findViewById(2131297452), 48);
      AppMethodBeat.o(67750);
      return;
      Oc(paramdpr.HDB);
      if (paramdpr.HDz != null)
      {
        this.xVZ.setVisibility(0);
        this.vky.setText(paramdpr.HDz.dxD);
        this.xVZ.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(67746);
            b localb = new b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitResultUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            ad.i("MicroMsg.mobileRemit.MobileRemitResultUI", "notice click!");
            l.a(MobileRemitResultUI.this.getContext(), paramdpr.HDz, null, new com.tencent.mm.plugin.remittance.mobile.a.a()
            {
              public final void dF(Object paramAnonymous2Object)
              {
                AppMethodBeat.i(67745);
                ad.i("MicroMsg.mobileRemit.MobileRemitResultUI", "notice click jumpItem.action:continue");
                AppMethodBeat.o(67745);
              }
              
              public final void dJf()
              {
                AppMethodBeat.i(67744);
                ad.i("MicroMsg.mobileRemit.MobileRemitResultUI", "notice click jumpItem.action:exit");
                MobileRemitResultUI.this.dJe();
                AppMethodBeat.o(67744);
              }
            });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitResultUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(67746);
          }
        });
      }
      if ((paramdpr.HDJ != null) && (!paramdpr.HDJ.isEmpty()))
      {
        int i = 0;
        while (i < paramdpr.HDJ.size())
        {
          bsm localbsm = (bsm)paramdpr.HDJ.get(i);
          View localView = getLayoutInflater().inflate(2131494931, null);
          ((TextView)localView.findViewById(2131301250)).setText(localbsm.key);
          ((TextView)localView.findViewById(2131306265)).setText(localbsm.value);
          this.xWm.addView(localView);
          i += 1;
        }
        this.xWm.setVisibility(0);
        this.mLine.setVisibility(0);
      }
      else
      {
        this.xWm.setVisibility(8);
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
    this.xVZ = ((LinearLayout)findViewById(2131302405));
    this.vky = ((TextView)findViewById(2131297186));
    this.xWi = ((ImageView)findViewById(2131302399));
    this.xWj = ((LinearLayout)findViewById(2131302398));
    this.lDu = ((TextView)findViewById(2131302397));
    this.xWk = ((TextView)findViewById(2131302400));
    this.xWl = ((WalletTextView)findViewById(2131302401));
    this.xWl.setTypeface(0);
    this.mLine = findViewById(2131302403);
    this.xWm = ((LinearLayout)findViewById(2131302404));
    this.tXG = ((Button)findViewById(2131302402));
    this.tXG.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67742);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitResultUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        ad.i("MicroMsg.mobileRemit.MobileRemitResultUI", "mFinishBt click");
        MobileRemitResultUI.this.dJe();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitResultUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
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
    this.xnF = ((PayInfo)getInput().getParcelable("key_pay_info"));
    if ((this.xnF != null) && (this.xnF.htZ != null))
    {
      paramBundle = this.xnF.htZ;
      this.xWn = paramBundle.getString("extinfo_key_1");
      this.wxW = paramBundle.getString("extinfo_key_2");
      this.xWo = paramBundle.getString("extinfo_key_3");
      this.xWp = paramBundle.getString("extinfo_key_4");
      this.xWq = paramBundle.getInt("extinfo_key_5");
      this.xWr = paramBundle.getString("extinfo_key_6");
      this.xWs = paramBundle.getString("extinfo_key_7");
      this.xWt = paramBundle.getInt("extinfo_key_8");
      this.xWu = paramBundle.getString("extinfo_key_9");
      this.xWv = paramBundle.getString("extinfo_key_10");
      this.mReqKey = paramBundle.getString("extinfo_key_11");
    }
    for (;;)
    {
      initView();
      doSceneProgress(new com.tencent.mm.plugin.remittance.mobile.cgi.e(this.xWn, this.wxW, this.xWo, this.xWp, this.xWq, this.xWr, this.xWs));
      addSceneEndListener(1903);
      paramBundle = new lx();
      paramBundle.dzl.dlu = this.mReqKey;
      com.tencent.mm.sdk.b.a.IbL.l(paramBundle);
      AppMethodBeat.o(67747);
      return;
      ad.i("MicroMsg.mobileRemit.MobileRemitResultUI", "payInfo != null && payInfo.extInfo != null");
      dJe();
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
      dJe();
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
      if (paramString.xVh == null) {}
      for (paramString = null; paramString == null; paramString = paramString.xVh)
      {
        ad.e("MicroMsg.mobileRemit.MobileRemitResultUI", "NetSceneMobileRemitGetSuccPage succPageResp is null");
        AppMethodBeat.o(67753);
        return true;
      }
      if (paramString.ozR != 0) {
        break label143;
      }
      a(paramString);
    }
    for (;;)
    {
      AppMethodBeat.o(67753);
      return false;
      label143:
      ad.i("MicroMsg.mobileRemit.MobileRemitResultUI", "NetSceneMobileRemitGetSuccPage ret_code:%s ret_msg:%s", new Object[] { Integer.valueOf(paramString.ozR), paramString.ozS });
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.ui.MobileRemitResultUI
 * JD-Core Version:    0.7.0.1
 */