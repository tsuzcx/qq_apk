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
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.ly;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.remittance.mobile.cgi.e;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.bss;
import com.tencent.mm.protocal.protobuf.btg;
import com.tencent.mm.protocal.protobuf.dqo;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.tools.p;
import com.tencent.mm.wallet_core.c.l;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.f;
import java.util.LinkedList;

public class MobileRemitResultUI
  extends MobileRemitBaseUI
{
  private TextView lHT;
  private View mLine;
  private String mReqKey;
  private Button uiG;
  private TextView vwD;
  public String wNH;
  private PayInfo xDC;
  private LinearLayout ylS;
  private ImageView ymb;
  private LinearLayout ymc;
  private TextView ymd;
  private WalletTextView yme;
  private LinearLayout ymf;
  public String ymg;
  public String ymh;
  public String ymi;
  public int ymj;
  public String ymk;
  public String yml;
  public int ymm;
  private String ymn;
  private String ymo;
  
  private void OI(int paramInt)
  {
    AppMethodBeat.i(67751);
    if (paramInt == 0)
    {
      this.ymb.setImageDrawable(com.tencent.mm.cb.a.l(this, 2131690392));
      this.ymb.getDrawable().setColorFilter(getResources().getColor(2131099699), PorterDuff.Mode.SRC_ATOP);
      AppMethodBeat.o(67751);
      return;
    }
    this.ymb.setImageDrawable(com.tencent.mm.cb.a.l(this, 2131690487));
    this.ymb.getDrawable().setColorFilter(getResources().getColor(2131099689), PorterDuff.Mode.SRC_ATOP);
    AppMethodBeat.o(67751);
  }
  
  private void a(final dqo paramdqo)
  {
    AppMethodBeat.i(67750);
    if (paramdqo == null)
    {
      OI(this.ymm);
      this.ymc.post(new Runnable()
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
      this.yme.setText(f.d(this.ymj / 100.0D, "CNY"));
      this.mLine.setVisibility(8);
      this.ymf.setVisibility(8);
    }
    for (;;)
    {
      p.a(getContext(), (ScrollView)findViewById(2131304251), findViewById(2131297457), findViewById(2131297476), findViewById(2131297452), 48);
      AppMethodBeat.o(67750);
      return;
      OI(paramdqo.HXo);
      if (paramdqo.HXm != null)
      {
        this.ylS.setVisibility(0);
        this.vwD.setText(paramdqo.HXm.dyI);
        this.ylS.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(67746);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitResultUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            ae.i("MicroMsg.mobileRemit.MobileRemitResultUI", "notice click!");
            l.a(MobileRemitResultUI.this.getContext(), paramdqo.HXm, null, new com.tencent.mm.plugin.remittance.mobile.a.a()
            {
              public final void dG(Object paramAnonymous2Object)
              {
                AppMethodBeat.i(67745);
                ae.i("MicroMsg.mobileRemit.MobileRemitResultUI", "notice click jumpItem.action:continue");
                AppMethodBeat.o(67745);
              }
              
              public final void dMw()
              {
                AppMethodBeat.i(67744);
                ae.i("MicroMsg.mobileRemit.MobileRemitResultUI", "notice click jumpItem.action:exit");
                MobileRemitResultUI.this.dMv();
                AppMethodBeat.o(67744);
              }
            });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitResultUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(67746);
          }
        });
      }
      if ((paramdqo.HXw != null) && (!paramdqo.HXw.isEmpty()))
      {
        int i = 0;
        while (i < paramdqo.HXw.size())
        {
          btg localbtg = (btg)paramdqo.HXw.get(i);
          View localView = getLayoutInflater().inflate(2131494931, null);
          ((TextView)localView.findViewById(2131301250)).setText(localbtg.key);
          ((TextView)localView.findViewById(2131306265)).setText(localbtg.value);
          this.ymf.addView(localView);
          i += 1;
        }
        this.ymf.setVisibility(0);
        this.mLine.setVisibility(0);
      }
      else
      {
        this.ymf.setVisibility(8);
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
    this.ylS = ((LinearLayout)findViewById(2131302405));
    this.vwD = ((TextView)findViewById(2131297186));
    this.ymb = ((ImageView)findViewById(2131302399));
    this.ymc = ((LinearLayout)findViewById(2131302398));
    this.lHT = ((TextView)findViewById(2131302397));
    this.ymd = ((TextView)findViewById(2131302400));
    this.yme = ((WalletTextView)findViewById(2131302401));
    this.yme.setTypeface(0);
    this.mLine = findViewById(2131302403);
    this.ymf = ((LinearLayout)findViewById(2131302404));
    this.uiG = ((Button)findViewById(2131302402));
    this.uiG.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67742);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitResultUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        ae.i("MicroMsg.mobileRemit.MobileRemitResultUI", "mFinishBt click");
        MobileRemitResultUI.this.dMv();
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
    com.tencent.mm.wallet_core.b.fVf();
    boolean bool1 = com.tencent.mm.wallet_core.b.b(b.a.qDk, true);
    com.tencent.mm.wallet_core.b.fVf();
    boolean bool2 = com.tencent.mm.wallet_core.b.b(b.a.qGH, false);
    ae.i("MicroMsg.mobileRemit.MobileRemitResultUI", "isKindaEnable: %s，isKindaMobileRemittanceEnable ：%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    if ((bool1) && (bool2))
    {
      if (i == 0) {
        break label323;
      }
      ae.i("MicroMsg.mobileRemit.MobileRemitResultUI", "use Kinda");
      if ((getIntent() == null) || (getIntent().getExtras() == null)) {
        break label323;
      }
      paramBundle = getIntent().getExtras();
      this.ymg = paramBundle.getString("extinfo_key_1");
      this.wNH = paramBundle.getString("extinfo_key_2");
      this.ymh = paramBundle.getString("extinfo_key_3");
      this.ymi = paramBundle.getString("extinfo_key_4");
      this.ymj = paramBundle.getInt("extinfo_key_5");
      this.ymk = paramBundle.getString("extinfo_key_6");
      this.yml = paramBundle.getString("extinfo_key_7");
      this.ymm = paramBundle.getInt("extinfo_key_8");
      this.ymn = paramBundle.getString("extinfo_key_9");
      this.ymo = paramBundle.getString("extinfo_key_10");
      this.mReqKey = paramBundle.getString("extinfo_key_11");
    }
    for (;;)
    {
      initView();
      doSceneProgress(new e(this.ymg, this.wNH, this.ymh, this.ymi, this.ymj, this.ymk, this.yml));
      addSceneEndListener(1903);
      paramBundle = new ly();
      paramBundle.dAq.dmw = this.mReqKey;
      com.tencent.mm.sdk.b.a.IvT.l(paramBundle);
      AppMethodBeat.o(67747);
      return;
      i = 0;
      break;
      label323:
      this.xDC = ((PayInfo)getInput().getParcelable("key_pay_info"));
      if ((this.xDC != null) && (this.xDC.hwN != null))
      {
        ae.i("MicroMsg.mobileRemit.MobileRemitResultUI", "use native");
        paramBundle = this.xDC.hwN;
        this.ymg = paramBundle.getString("extinfo_key_1");
        this.wNH = paramBundle.getString("extinfo_key_2");
        this.ymh = paramBundle.getString("extinfo_key_3");
        this.ymi = paramBundle.getString("extinfo_key_4");
        this.ymj = paramBundle.getInt("extinfo_key_5");
        this.ymk = paramBundle.getString("extinfo_key_6");
        this.yml = paramBundle.getString("extinfo_key_7");
        this.ymm = paramBundle.getInt("extinfo_key_8");
        this.ymn = paramBundle.getString("extinfo_key_9");
        this.ymo = paramBundle.getString("extinfo_key_10");
        this.mReqKey = paramBundle.getString("extinfo_key_11");
      }
      else
      {
        ae.i("MicroMsg.mobileRemit.MobileRemitResultUI", "payInfo != null && payInfo.extInfo != null");
        dMv();
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
      ae.i("MicroMsg.mobileRemit.MobileRemitResultUI", "onKeyUp KEYCODE_BACK click");
      dMv();
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(67749);
    return bool;
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(67753);
    ae.i("MicroMsg.mobileRemit.MobileRemitResultUI", "errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scenetype:" + paramn.getType());
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramn instanceof e)))
    {
      paramString = (e)paramn;
      if (paramString.yla == null) {}
      for (paramString = null; paramString == null; paramString = paramString.yla)
      {
        ae.e("MicroMsg.mobileRemit.MobileRemitResultUI", "NetSceneMobileRemitGetSuccPage succPageResp is null");
        AppMethodBeat.o(67753);
        return true;
      }
      if (paramString.oGt != 0) {
        break label143;
      }
      a(paramString);
    }
    for (;;)
    {
      AppMethodBeat.o(67753);
      return false;
      label143:
      ae.i("MicroMsg.mobileRemit.MobileRemitResultUI", "NetSceneMobileRemitGetSuccPage ret_code:%s ret_msg:%s", new Object[] { Integer.valueOf(paramString.oGt), paramString.oGu });
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