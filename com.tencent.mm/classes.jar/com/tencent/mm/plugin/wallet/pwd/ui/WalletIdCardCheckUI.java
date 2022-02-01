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
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.f.b.a.nv;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.ao;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wallet_core.model.y;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.wallet_core.c.p;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.a;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.c;
import com.tencent.mm.wallet_core.ui.formview.a.a;
import com.tencent.mm.wallet_core.ui.g;
import com.tenpay.android.wechat.MyKeyboardWindow;

@com.tencent.mm.ui.base.a(3)
public class WalletIdCardCheckUI
  extends WalletBaseUI
  implements TextView.OnEditorActionListener, WalletFormView.a
{
  private WalletFormView OBS;
  private TextView OBT;
  private TextView OBU;
  private Button OBV;
  private RelativeLayout OBW;
  private int OBX = 1;
  private TextView jMg;
  
  private void BV(final boolean paramBoolean)
  {
    AppMethodBeat.i(273069);
    this.mKeyboard.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(188876);
        if (paramBoolean)
        {
          int i = WalletIdCardCheckUI.e(WalletIdCardCheckUI.this).getHeight();
          int j = WalletIdCardCheckUI.a(WalletIdCardCheckUI.this).getTop();
          int k = WalletIdCardCheckUI.a(WalletIdCardCheckUI.this).getHeight();
          int m = com.tencent.mm.ci.a.fromDPToPix(WalletIdCardCheckUI.this.getContext(), 32);
          if (WalletIdCardCheckUI.d(WalletIdCardCheckUI.this).getHeight() + com.tencent.mm.ci.a.fromDPToPix(WalletIdCardCheckUI.this.getContext(), 32) + WalletIdCardCheckUI.f(WalletIdCardCheckUI.this).getHeight() + com.tencent.mm.ci.a.fromDPToPix(WalletIdCardCheckUI.this.getContext(), 30) > i - j - k - m)
          {
            localLayoutParams = (RelativeLayout.LayoutParams)WalletIdCardCheckUI.g(WalletIdCardCheckUI.this).getLayoutParams();
            localLayoutParams.topMargin = com.tencent.mm.ci.a.fromDPToPix(WalletIdCardCheckUI.this.getContext(), 25);
            WalletIdCardCheckUI.g(WalletIdCardCheckUI.this).setLayoutParams(localLayoutParams);
            localLayoutParams = (RelativeLayout.LayoutParams)WalletIdCardCheckUI.d(WalletIdCardCheckUI.this).getLayoutParams();
            localLayoutParams.removeRule(12);
            localLayoutParams.addRule(3, a.f.identity_et);
            localLayoutParams.topMargin = com.tencent.mm.ci.a.fromDPToPix(WalletIdCardCheckUI.this.getContext(), 32);
            WalletIdCardCheckUI.d(WalletIdCardCheckUI.this).setLayoutParams(localLayoutParams);
            AppMethodBeat.o(188876);
            return;
          }
          localLayoutParams = (RelativeLayout.LayoutParams)WalletIdCardCheckUI.d(WalletIdCardCheckUI.this).getLayoutParams();
          localLayoutParams.removeRule(3);
          localLayoutParams.addRule(12);
          localLayoutParams.bottomMargin = (com.tencent.mm.ci.a.fromDPToPix(WalletIdCardCheckUI.this.getContext(), 32) + WalletIdCardCheckUI.h(WalletIdCardCheckUI.this).getHeight() + com.tencent.mm.ci.a.fromDPToPix(WalletIdCardCheckUI.this.getContext(), 30));
          WalletIdCardCheckUI.d(WalletIdCardCheckUI.this).setLayoutParams(localLayoutParams);
          AppMethodBeat.o(188876);
          return;
        }
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)WalletIdCardCheckUI.d(WalletIdCardCheckUI.this).getLayoutParams();
        localLayoutParams.removeRule(3);
        localLayoutParams.addRule(12);
        localLayoutParams.bottomMargin = com.tencent.mm.ci.a.fromDPToPix(WalletIdCardCheckUI.this.getContext(), 96);
        WalletIdCardCheckUI.d(WalletIdCardCheckUI.this).setLayoutParams(localLayoutParams);
        AppMethodBeat.o(188876);
      }
    });
    AppMethodBeat.o(273069);
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
    return a.g.wallet_check_id_card;
  }
  
  public void initView()
  {
    AppMethodBeat.i(69708);
    this.OBS = ((WalletFormView)findViewById(a.f.identity_et));
    this.OBU = ((TextView)findViewById(a.f.wallet_card_identify_err_hint));
    this.OBT = ((TextView)findViewById(a.f.wallet_card_identify_tipmsg));
    this.OBW = ((RelativeLayout)findViewById(a.f.root_container));
    this.jMg = ((TextView)findViewById(a.f.wallet_check_id_card_title));
    ar.a(this.jMg.getPaint(), 0.8F);
    this.OBS.setOnInputValidChangeListener(this);
    this.OBS.setOnEditorActionListener(this);
    int i = com.tencent.mm.ci.a.fromDPToPix(getContext(), 16);
    int j = com.tencent.mm.ci.a.fromDPToPix(getContext(), 8);
    Object localObject1 = new LinearLayout.LayoutParams(i, i);
    ((LinearLayout.LayoutParams)localObject1).gravity = 17;
    ((LinearLayout.LayoutParams)localObject1).rightMargin = j;
    this.OBS.getInfoIv().setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.OBS.getInfoIv().setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.OBS.getInfoIv().setClearBtnDrawableId(a.h.icons_filled_close2, getResources().getColor(a.c.FG_2));
    this.OBU.setVisibility(4);
    this.OBV = ((Button)findViewById(a.f.install_query));
    com.tencent.mm.wallet_core.ui.formview.a.d(this.OBS);
    setEditFocusListener(this.OBS, 1, false);
    this.OBS.getContentEt().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(69700);
        WalletIdCardCheckUI.a(WalletIdCardCheckUI.this).getContentEt().requestFocus();
        AppMethodBeat.o(69700);
      }
    });
    this.OBS.getContentEt().setSingleLine(false);
    this.OBV.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(69701);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/pwd/ui/WalletIdCardCheckUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (WalletIdCardCheckUI.b(WalletIdCardCheckUI.this))
        {
          paramAnonymousView = new nv();
          paramAnonymousView.gCd = 1L;
          paramAnonymousView.han = 1L;
          paramAnonymousView.bpa();
          com.tencent.mm.plugin.report.service.h.IzE.a(13731, new Object[] { Integer.valueOf(2) });
          paramAnonymousView = WalletIdCardCheckUI.a(WalletIdCardCheckUI.this).getText();
          int i = WalletIdCardCheckUI.c(WalletIdCardCheckUI.this);
          u.gJo().getTrueName();
          paramAnonymousView = new p(paramAnonymousView, i);
          WalletIdCardCheckUI.this.doSceneProgress(paramAnonymousView);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pwd/ui/WalletIdCardCheckUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(69701);
      }
    });
    this.OBX = u.gJo().gKa();
    localObject1 = u.gJo();
    if (((ao)localObject1).OTW != null)
    {
      localObject1 = ((ao)localObject1).OTW.field_cre_name;
      Log.i("Micromsg.WalletIdCardCheckUI", "mIdentityType %d %s", new Object[] { Integer.valueOf(this.OBX), localObject1 });
      if (!Util.isNullOrNil((String)localObject1)) {
        break label590;
      }
      localObject1 = u.gJw().aN(this, this.OBX);
    }
    label585:
    label590:
    for (;;)
    {
      Object localObject2 = this.OBS;
      i = this.OBX;
      localObject2 = ((WalletFormView)localObject2).getLogicDelegate();
      if ((localObject2 instanceof a.a)) {
        ((a.a)localObject2).azL(i);
      }
      this.OBS.setTitleText((String)localObject1);
      localObject1 = this.OBS.getTitleTv().getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).width = -2;
      this.OBS.getTitleTv().setLayoutParams((ViewGroup.LayoutParams)localObject1);
      if (Util.isNullOrNil(this.OBS.getText())) {
        this.OBV.setEnabled(false);
      }
      this.OBS.fuo();
      if (this.OBX == 1)
      {
        setEditFocusListener(this.OBS, 1, false);
        label481:
        localObject1 = u.gJo().getTrueName();
        this.OBS.setHint(getString(a.i.wallet_password_setting_digitalcert_hint, new Object[] { g.bCs((String)localObject1) }));
        setTenpayKBStateListener(new com.tencent.mm.wallet_core.ui.a()
        {
          public final void onVisibleStateChange(boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(273946);
            WalletIdCardCheckUI.a(WalletIdCardCheckUI.this, paramAnonymousBoolean);
            AppMethodBeat.o(273946);
          }
        });
        if (this.mKeyboard.getVisibility() != 0) {
          break label585;
        }
      }
      for (boolean bool = true;; bool = false)
      {
        BV(bool);
        this.OBS.setmWalletFormViewListener(new WalletFormView.c()
        {
          public final void f(CharSequence paramAnonymousCharSequence)
          {
            AppMethodBeat.i(260394);
            if (paramAnonymousCharSequence.length() > 0)
            {
              WalletIdCardCheckUI.d(WalletIdCardCheckUI.this).setEnabled(true);
              AppMethodBeat.o(260394);
              return;
            }
            WalletIdCardCheckUI.d(WalletIdCardCheckUI.this).setEnabled(false);
            AppMethodBeat.o(260394);
          }
        });
        AppMethodBeat.o(69708);
        return;
        localObject1 = "";
        break;
        setEditFocusListener(this.OBS, 1, true);
        break label481;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(69703);
    super.onCreate(paramBundle);
    setMMTitle("");
    setActionbarColor(getResources().getColor(a.c.white));
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
    this.OBU.setVisibility(4);
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
      paramString = new nv();
      paramString.gCd = 1L;
      paramString.han = 2L;
      paramString.bpa();
      paramString = Toast.makeText(getContext(), "", 0);
      paramq = View.inflate(getContext(), a.g.center_toast, null);
      ((WeImageView)paramq.findViewById(a.f.toast_img)).setImageResource(a.h.icons_filled_done);
      ((TextView)paramq.findViewById(a.f.toast_text)).setText(getString(a.i.wallet_password_setting_digitalcert_install_ok));
      paramString.setGravity(17, 0, 0);
      paramString.setView(paramq);
      paramString.show();
      com.tencent.e.h.ZvG.n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(276727);
          paramString.cancel();
          WalletIdCardCheckUI.this.setResult(-1);
          WalletIdCardCheckUI.this.finish();
          AppMethodBeat.o(276727);
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