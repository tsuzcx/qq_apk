package com.tencent.mm.plugin.wallet.pwd.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.b.a.kz;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.model.x;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.wallet_core.c.p;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.a;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.c;
import com.tencent.mm.wallet_core.ui.formview.a.a;
import com.tenpay.android.wechat.MyKeyboardWindow;

@com.tencent.mm.ui.base.a(3)
public class WalletIdCardCheckUI
  extends WalletBaseUI
  implements TextView.OnEditorActionListener, WalletFormView.a
{
  private WalletFormView HJY;
  private TextView HJZ;
  private TextView HKa;
  private Button HKb;
  private RelativeLayout HKc;
  private int HKd = 1;
  private TextView hbb;
  
  private void ya(final boolean paramBoolean)
  {
    AppMethodBeat.i(214088);
    this.mKeyboard.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(214087);
        if (paramBoolean)
        {
          int i = WalletIdCardCheckUI.e(WalletIdCardCheckUI.this).getHeight();
          int j = WalletIdCardCheckUI.a(WalletIdCardCheckUI.this).getTop();
          int k = WalletIdCardCheckUI.a(WalletIdCardCheckUI.this).getHeight();
          int m = com.tencent.mm.cb.a.fromDPToPix(WalletIdCardCheckUI.this.getContext(), 32);
          if (WalletIdCardCheckUI.d(WalletIdCardCheckUI.this).getHeight() + com.tencent.mm.cb.a.fromDPToPix(WalletIdCardCheckUI.this.getContext(), 32) + WalletIdCardCheckUI.f(WalletIdCardCheckUI.this).getHeight() + com.tencent.mm.cb.a.fromDPToPix(WalletIdCardCheckUI.this.getContext(), 30) > i - j - k - m)
          {
            localLayoutParams = (RelativeLayout.LayoutParams)WalletIdCardCheckUI.g(WalletIdCardCheckUI.this).getLayoutParams();
            localLayoutParams.topMargin = com.tencent.mm.cb.a.fromDPToPix(WalletIdCardCheckUI.this.getContext(), 25);
            WalletIdCardCheckUI.g(WalletIdCardCheckUI.this).setLayoutParams(localLayoutParams);
            localLayoutParams = (RelativeLayout.LayoutParams)WalletIdCardCheckUI.d(WalletIdCardCheckUI.this).getLayoutParams();
            localLayoutParams.removeRule(12);
            localLayoutParams.addRule(3, 2131302521);
            localLayoutParams.topMargin = com.tencent.mm.cb.a.fromDPToPix(WalletIdCardCheckUI.this.getContext(), 32);
            WalletIdCardCheckUI.d(WalletIdCardCheckUI.this).setLayoutParams(localLayoutParams);
            AppMethodBeat.o(214087);
            return;
          }
          localLayoutParams = (RelativeLayout.LayoutParams)WalletIdCardCheckUI.d(WalletIdCardCheckUI.this).getLayoutParams();
          localLayoutParams.removeRule(3);
          localLayoutParams.addRule(12);
          localLayoutParams.bottomMargin = (com.tencent.mm.cb.a.fromDPToPix(WalletIdCardCheckUI.this.getContext(), 32) + WalletIdCardCheckUI.h(WalletIdCardCheckUI.this).getHeight() + com.tencent.mm.cb.a.fromDPToPix(WalletIdCardCheckUI.this.getContext(), 30));
          WalletIdCardCheckUI.d(WalletIdCardCheckUI.this).setLayoutParams(localLayoutParams);
          AppMethodBeat.o(214087);
          return;
        }
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)WalletIdCardCheckUI.d(WalletIdCardCheckUI.this).getLayoutParams();
        localLayoutParams.removeRule(3);
        localLayoutParams.addRule(12);
        localLayoutParams.bottomMargin = com.tencent.mm.cb.a.fromDPToPix(WalletIdCardCheckUI.this.getContext(), 96);
        WalletIdCardCheckUI.d(WalletIdCardCheckUI.this).setLayoutParams(localLayoutParams);
        AppMethodBeat.o(214087);
      }
    });
    AppMethodBeat.o(214088);
  }
  
  public void forceCancel()
  {
    AppMethodBeat.i(69704);
    Log.d("Micromsg.WalletIdCardCheckUI", "check pwd ");
    cleanScenes();
    AppMethodBeat.o(69704);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131496915;
  }
  
  public void initView()
  {
    AppMethodBeat.i(69708);
    this.HJY = ((WalletFormView)findViewById(2131302521));
    this.HKa = ((TextView)findViewById(2131310172));
    this.HJZ = ((TextView)findViewById(2131310173));
    this.HKc = ((RelativeLayout)findViewById(2131307160));
    this.hbb = ((TextView)findViewById(2131310179));
    ao.a(this.hbb.getPaint(), 0.8F);
    this.HJY.setOnInputValidChangeListener(this);
    this.HJY.setOnEditorActionListener(this);
    int i = com.tencent.mm.cb.a.fromDPToPix(getContext(), 16);
    int j = com.tencent.mm.cb.a.fromDPToPix(getContext(), 8);
    Object localObject1 = new LinearLayout.LayoutParams(i, i);
    ((LinearLayout.LayoutParams)localObject1).gravity = 17;
    ((LinearLayout.LayoutParams)localObject1).rightMargin = j;
    this.HJY.getInfoIv().setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.HJY.getInfoIv().setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.HJY.getInfoIv().setClearBtnDrawableId$255f295(getResources().getColor(2131099749));
    this.HKa.setVisibility(4);
    this.HKb = ((Button)findViewById(2131302690));
    com.tencent.mm.wallet_core.ui.formview.a.d(this.HJY);
    setEditFocusListener(this.HJY, 1, false);
    this.HJY.getContentEt().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(69700);
        WalletIdCardCheckUI.a(WalletIdCardCheckUI.this).getContentEt().requestFocus();
        AppMethodBeat.o(69700);
      }
    });
    this.HJY.getContentEt().setSingleLine(false);
    this.HKb.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(69701);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/pwd/ui/WalletIdCardCheckUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (WalletIdCardCheckUI.b(WalletIdCardCheckUI.this))
        {
          paramAnonymousView = new kz();
          paramAnonymousView.eEH = 1L;
          paramAnonymousView.eXI = 1L;
          paramAnonymousView.bfK();
          com.tencent.mm.plugin.report.service.h.CyF.a(13731, new Object[] { Integer.valueOf(2) });
          paramAnonymousView = WalletIdCardCheckUI.a(WalletIdCardCheckUI.this).getText();
          int i = WalletIdCardCheckUI.c(WalletIdCardCheckUI.this);
          t.fQI();
          paramAnonymousView = new p(paramAnonymousView, i);
          WalletIdCardCheckUI.this.doSceneProgress(paramAnonymousView);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pwd/ui/WalletIdCardCheckUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(69701);
      }
    });
    this.HKd = t.fQI().fRu();
    localObject1 = t.fQI();
    if (((an)localObject1).IbK != null)
    {
      localObject1 = ((an)localObject1).IbK.field_cre_name;
      Log.i("Micromsg.WalletIdCardCheckUI", "mIdentityType %d %s", new Object[] { Integer.valueOf(this.HKd), localObject1 });
      if (!Util.isNullOrNil((String)localObject1)) {
        break label580;
      }
      localObject1 = t.fQQ().av(this, this.HKd);
    }
    label575:
    label580:
    for (;;)
    {
      Object localObject2 = this.HJY;
      i = this.HKd;
      localObject2 = ((WalletFormView)localObject2).getLogicDelegate();
      if ((localObject2 instanceof a.a)) {
        ((a.a)localObject2).aqn(i);
      }
      this.HJY.setTitleText((String)localObject1);
      localObject1 = this.HJY.getTitleTv().getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).width = -2;
      this.HJY.getTitleTv().setLayoutParams((ViewGroup.LayoutParams)localObject1);
      if (Util.isNullOrNil(this.HJY.getText())) {
        this.HKb.setEnabled(false);
      }
      this.HJY.eIj();
      if (this.HKd == 1)
      {
        setEditFocusListener(this.HJY, 1, false);
        label471:
        localObject1 = t.fQI().getTrueName();
        this.HJY.setHint(getString(2131768060, new Object[] { f.bpv((String)localObject1) }));
        setTenpayKBStateListener(new com.tencent.mm.wallet_core.ui.a()
        {
          public final void onVisibleStateChange(boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(214083);
            WalletIdCardCheckUI.a(WalletIdCardCheckUI.this, paramAnonymousBoolean);
            AppMethodBeat.o(214083);
          }
        });
        if (this.mKeyboard.getVisibility() != 0) {
          break label575;
        }
      }
      for (boolean bool = true;; bool = false)
      {
        ya(bool);
        this.HJY.setmWalletFormViewListener(new WalletFormView.c()
        {
          public final void p(CharSequence paramAnonymousCharSequence)
          {
            AppMethodBeat.i(214084);
            if (paramAnonymousCharSequence.length() > 0)
            {
              WalletIdCardCheckUI.d(WalletIdCardCheckUI.this).setEnabled(true);
              AppMethodBeat.o(214084);
              return;
            }
            WalletIdCardCheckUI.d(WalletIdCardCheckUI.this).setEnabled(false);
            AppMethodBeat.o(214084);
          }
        });
        AppMethodBeat.o(69708);
        return;
        localObject1 = "";
        break;
        setEditFocusListener(this.HJY, 1, true);
        break label471;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(69703);
    super.onCreate(paramBundle);
    setMMTitle("");
    setActionbarColor(getResources().getColor(2131101424));
    addSceneEndListener(1580);
    initView();
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(69699);
        Log.i("Micromsg.WalletIdCardCheckUI", "onbackbtn click");
        WalletIdCardCheckUI.this.finish();
        AppMethodBeat.o(69699);
        return false;
      }
    });
    AppMethodBeat.o(69703);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(69707);
    super.onDestroy();
    removeSceneEndListener(1580);
    AppMethodBeat.o(69707);
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public final void onInputValidChange(boolean paramBoolean)
  {
    AppMethodBeat.i(69711);
    this.HKa.setVisibility(4);
    AppMethodBeat.o(69711);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(69709);
    if ((this.mKBLayout != null) && (this.mKBLayout.isShown()))
    {
      this.mKBLayout.setVisibility(8);
      AppMethodBeat.o(69709);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(69709);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(69706);
    super.onPause();
    AppMethodBeat.o(69706);
  }
  
  public boolean onPreSceneEnd(int paramInt1, int paramInt2, final String paramString, q paramq)
  {
    AppMethodBeat.i(69710);
    Log.d("Micromsg.WalletIdCardCheckUI", " errCode: " + paramInt2 + " errMsg :" + paramString);
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramq instanceof p)))
    {
      paramString = new kz();
      paramString.eEH = 1L;
      paramString.eXI = 2L;
      paramString.bfK();
      paramString = Toast.makeText(getContext(), "", 0);
      paramq = View.inflate(getContext(), 2131493459, null);
      ((WeImageView)paramq.findViewById(2131309259)).setImageResource(2131690537);
      ((TextView)paramq.findViewById(2131309260)).setText(getString(2131768063));
      paramString.setGravity(17, 0, 0);
      paramString.setView(paramq);
      paramString.show();
      com.tencent.f.h.RTc.n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(214085);
          paramString.cancel();
          WalletIdCardCheckUI.this.setResult(-1);
          WalletIdCardCheckUI.this.finish();
          AppMethodBeat.o(214085);
        }
      }, 750L);
    }
    AppMethodBeat.o(69710);
    return true;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(69705);
    super.onResume();
    AppMethodBeat.o(69705);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletIdCardCheckUI
 * JD-Core Version:    0.7.0.1
 */