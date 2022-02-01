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
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.mo;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.remittance.mobile.cgi.e;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.cfl;
import com.tencent.mm.protocal.protobuf.cfz;
import com.tencent.mm.protocal.protobuf.ekk;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.tools.p;
import com.tencent.mm.wallet_core.c.l;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.f;
import java.util.LinkedList;

public class MobileRemitResultUI
  extends MobileRemitBaseUI
{
  public String AJn;
  private PayInfo BDB;
  private LinearLayout CmS;
  private ImageView Cnb;
  private LinearLayout Cnc;
  private TextView Cnd;
  private WalletTextView Cne;
  private LinearLayout Cnf;
  public String Cng;
  public String Cnh;
  public String Cni;
  public int Cnj;
  public String Cnk;
  public String Cnl;
  public int Cnm;
  private String Cnn;
  private String Cno;
  private TextView jVn;
  private View mLine;
  private String mReqKey;
  private Button xBa;
  private TextView yQS;
  
  private void Wd(int paramInt)
  {
    AppMethodBeat.i(67751);
    if (paramInt == 0)
    {
      this.Cnb.setImageDrawable(com.tencent.mm.cb.a.l(this, 2131690538));
      this.Cnb.getDrawable().setColorFilter(getResources().getColor(2131099710), PorterDuff.Mode.SRC_ATOP);
      AppMethodBeat.o(67751);
      return;
    }
    this.Cnb.setImageDrawable(com.tencent.mm.cb.a.l(this, 2131690692));
    this.Cnb.getDrawable().setColorFilter(getResources().getColor(2131099700), PorterDuff.Mode.SRC_ATOP);
    AppMethodBeat.o(67751);
  }
  
  private void a(final ekk paramekk)
  {
    AppMethodBeat.i(67750);
    if (paramekk == null)
    {
      Wd(this.Cnm);
      this.Cnc.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(67743);
          int i = MobileRemitResultUI.a(MobileRemitResultUI.this).getMeasuredWidth();
          String str1 = MobileRemitResultUI.this.getString(2131763110, new Object[] { MobileRemitResultUI.b(MobileRemitResultUI.this) });
          String str2 = MobileRemitResultUI.this.getString(2131763111, new Object[] { MobileRemitResultUI.c(MobileRemitResultUI.this) });
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
      this.Cne.setText(f.d(this.Cnj / 100.0D, "CNY"));
      this.mLine.setVisibility(8);
      this.Cnf.setVisibility(8);
    }
    for (;;)
    {
      p.a(getContext(), (ScrollView)findViewById(2131307173), findViewById(2131297690), findViewById(2131297713), findViewById(2131297682), 48);
      AppMethodBeat.o(67750);
      return;
      Wd(paramekk.Nju);
      if (paramekk.Njs != null)
      {
        this.CmS.setVisibility(0);
        this.yQS.setText(paramekk.Njs.dQx);
        this.CmS.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(67746);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitResultUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            Log.i("MicroMsg.mobileRemit.MobileRemitResultUI", "notice click!");
            l.a(MobileRemitResultUI.this.getContext(), paramekk.Njs, null, new com.tencent.mm.plugin.remittance.mobile.a.a()
            {
              public final void dP(Object paramAnonymous2Object)
              {
                AppMethodBeat.i(67745);
                Log.i("MicroMsg.mobileRemit.MobileRemitResultUI", "notice click jumpItem.action:continue");
                AppMethodBeat.o(67745);
              }
              
              public final void eNw()
              {
                AppMethodBeat.i(67744);
                Log.i("MicroMsg.mobileRemit.MobileRemitResultUI", "notice click jumpItem.action:exit");
                MobileRemitResultUI.this.eNv();
                AppMethodBeat.o(67744);
              }
            });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitResultUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(67746);
          }
        });
      }
      if ((paramekk.NjC != null) && (!paramekk.NjC.isEmpty()))
      {
        int i = 0;
        while (i < paramekk.NjC.size())
        {
          cfz localcfz = (cfz)paramekk.NjC.get(i);
          View localView = getLayoutInflater().inflate(2131495673, null);
          ((TextView)localView.findViewById(2131302946)).setText(localcfz.key);
          ((TextView)localView.findViewById(2131309676)).setText(localcfz.value);
          this.Cnf.addView(localView);
          i += 1;
        }
        this.Cnf.setVisibility(0);
        this.mLine.setVisibility(0);
      }
      else
      {
        this.Cnf.setVisibility(8);
        this.mLine.setVisibility(8);
      }
    }
  }
  
  public int getLayoutId()
  {
    return 2131495674;
  }
  
  public void initView()
  {
    AppMethodBeat.i(67748);
    super.initView();
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(2131101424));
    setBackGroundColorResource(2131101424);
    setBackBtn(null);
    setBackBtnVisible(false);
    this.CmS = ((LinearLayout)findViewById(2131304802));
    this.yQS = ((TextView)findViewById(2131297330));
    this.Cnb = ((ImageView)findViewById(2131304796));
    this.Cnc = ((LinearLayout)findViewById(2131304795));
    this.jVn = ((TextView)findViewById(2131304794));
    this.Cnd = ((TextView)findViewById(2131304797));
    this.Cne = ((WalletTextView)findViewById(2131304798));
    this.Cne.setTypeface(0);
    this.mLine = findViewById(2131304800);
    this.Cnf = ((LinearLayout)findViewById(2131304801));
    this.xBa = ((Button)findViewById(2131304799));
    this.xBa.setOnClickListener(new MobileRemitResultUI.1(this));
    a(null);
    AppMethodBeat.o(67748);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int i = 1;
    AppMethodBeat.i(67747);
    super.onCreate(paramBundle);
    com.tencent.mm.wallet_core.b.hgC();
    boolean bool1 = com.tencent.mm.wallet_core.b.b(b.a.rWd, true);
    com.tencent.mm.wallet_core.b.hgC();
    boolean bool2 = com.tencent.mm.wallet_core.b.b(b.a.rZY, false);
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
      this.Cng = paramBundle.getString("extinfo_key_1");
      this.AJn = paramBundle.getString("extinfo_key_2");
      this.Cnh = paramBundle.getString("extinfo_key_3");
      this.Cni = paramBundle.getString("extinfo_key_4");
      this.Cnj = paramBundle.getInt("extinfo_key_5");
      this.Cnk = paramBundle.getString("extinfo_key_6");
      this.Cnl = paramBundle.getString("extinfo_key_7");
      this.Cnm = paramBundle.getInt("extinfo_key_8");
      this.Cnn = paramBundle.getString("extinfo_key_9");
      this.Cno = paramBundle.getString("extinfo_key_10");
      this.mReqKey = paramBundle.getString("extinfo_key_11");
    }
    for (;;)
    {
      initView();
      doSceneProgress(new e(this.Cng, this.AJn, this.Cnh, this.Cni, this.Cnj, this.Cnk, this.Cnl));
      addSceneEndListener(1903);
      paramBundle = new mo();
      paramBundle.dSd.dDL = this.mReqKey;
      EventCenter.instance.publish(paramBundle);
      AppMethodBeat.o(67747);
      return;
      i = 0;
      break;
      label323:
      this.BDB = ((PayInfo)getInput().getParcelable("key_pay_info"));
      if ((this.BDB != null) && (this.BDB.iqp != null))
      {
        Log.i("MicroMsg.mobileRemit.MobileRemitResultUI", "use native");
        paramBundle = this.BDB.iqp;
        this.Cng = paramBundle.getString("extinfo_key_1");
        this.AJn = paramBundle.getString("extinfo_key_2");
        this.Cnh = paramBundle.getString("extinfo_key_3");
        this.Cni = paramBundle.getString("extinfo_key_4");
        this.Cnj = paramBundle.getInt("extinfo_key_5");
        this.Cnk = paramBundle.getString("extinfo_key_6");
        this.Cnl = paramBundle.getString("extinfo_key_7");
        this.Cnm = paramBundle.getInt("extinfo_key_8");
        this.Cnn = paramBundle.getString("extinfo_key_9");
        this.Cno = paramBundle.getString("extinfo_key_10");
        this.mReqKey = paramBundle.getString("extinfo_key_11");
      }
      else
      {
        Log.i("MicroMsg.mobileRemit.MobileRemitResultUI", "payInfo != null && payInfo.extInfo != null");
        eNv();
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
      eNv();
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(67749);
    return bool;
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(67753);
    Log.i("MicroMsg.mobileRemit.MobileRemitResultUI", "errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scenetype:" + paramq.getType());
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramq instanceof e)))
    {
      paramString = (e)paramq;
      if (paramString.Cma == null) {}
      for (paramString = null; paramString == null; paramString = paramString.Cma)
      {
        Log.e("MicroMsg.mobileRemit.MobileRemitResultUI", "NetSceneMobileRemitGetSuccPage succPageResp is null");
        AppMethodBeat.o(67753);
        return true;
      }
      if (paramString.pTZ != 0) {
        break label143;
      }
      a(paramString);
    }
    for (;;)
    {
      AppMethodBeat.o(67753);
      return false;
      label143:
      Log.i("MicroMsg.mobileRemit.MobileRemitResultUI", "NetSceneMobileRemitGetSuccPage ret_code:%s ret_msg:%s", new Object[] { Integer.valueOf(paramString.pTZ), paramString.pUa });
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