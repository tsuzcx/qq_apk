package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
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
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.ConfigHelper;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.FocusOrderHelper;
import com.tencent.mm.accessibility.base.ViewSetter;
import com.tencent.mm.autogen.mmdata.rpt.rn;
import com.tencent.mm.plugin.wallet_core.model.al;
import com.tencent.mm.plugin.wallet_core.model.am;
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
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.a;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.c;
import com.tencent.mm.wallet_core.ui.formview.a.a;
import com.tencent.mm.wallet_core.ui.k;
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.util.HashSet;

@com.tencent.mm.ui.base.a(3)
public class WalletIdCardCheckUI
  extends WalletBaseUI
  implements TextView.OnEditorActionListener, WalletFormView.a
{
  private WalletFormView Vre;
  private TextView Vrf;
  private TextView Vrg;
  private Button Vrh;
  private RelativeLayout Vri;
  private int Vrj = 1;
  private TextView mll;
  
  private void HA(final boolean paramBoolean)
  {
    AppMethodBeat.i(315647);
    this.mKeyboard.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(315637);
        if (paramBoolean)
        {
          int i = WalletIdCardCheckUI.e(WalletIdCardCheckUI.this).getHeight();
          int j = WalletIdCardCheckUI.b(WalletIdCardCheckUI.this).getTop();
          int k = WalletIdCardCheckUI.b(WalletIdCardCheckUI.this).getHeight();
          int m = com.tencent.mm.cd.a.fromDPToPix(WalletIdCardCheckUI.this.getContext(), 32);
          if (WalletIdCardCheckUI.d(WalletIdCardCheckUI.this).getHeight() + com.tencent.mm.cd.a.fromDPToPix(WalletIdCardCheckUI.this.getContext(), 32) + WalletIdCardCheckUI.f(WalletIdCardCheckUI.this).getHeight() + com.tencent.mm.cd.a.fromDPToPix(WalletIdCardCheckUI.this.getContext(), 30) > i - j - k - m)
          {
            localLayoutParams = (RelativeLayout.LayoutParams)WalletIdCardCheckUI.g(WalletIdCardCheckUI.this).getLayoutParams();
            localLayoutParams.topMargin = com.tencent.mm.cd.a.fromDPToPix(WalletIdCardCheckUI.this.getContext(), 25);
            WalletIdCardCheckUI.g(WalletIdCardCheckUI.this).setLayoutParams(localLayoutParams);
            localLayoutParams = (RelativeLayout.LayoutParams)WalletIdCardCheckUI.d(WalletIdCardCheckUI.this).getLayoutParams();
            localLayoutParams.removeRule(12);
            localLayoutParams.addRule(3, a.f.identity_et);
            localLayoutParams.topMargin = com.tencent.mm.cd.a.fromDPToPix(WalletIdCardCheckUI.this.getContext(), 32);
            WalletIdCardCheckUI.d(WalletIdCardCheckUI.this).setLayoutParams(localLayoutParams);
            AppMethodBeat.o(315637);
            return;
          }
          localLayoutParams = (RelativeLayout.LayoutParams)WalletIdCardCheckUI.d(WalletIdCardCheckUI.this).getLayoutParams();
          localLayoutParams.removeRule(3);
          localLayoutParams.addRule(12);
          localLayoutParams.bottomMargin = (com.tencent.mm.cd.a.fromDPToPix(WalletIdCardCheckUI.this.getContext(), 32) + WalletIdCardCheckUI.h(WalletIdCardCheckUI.this).getHeight() + com.tencent.mm.cd.a.fromDPToPix(WalletIdCardCheckUI.this.getContext(), 30));
          WalletIdCardCheckUI.d(WalletIdCardCheckUI.this).setLayoutParams(localLayoutParams);
          AppMethodBeat.o(315637);
          return;
        }
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)WalletIdCardCheckUI.d(WalletIdCardCheckUI.this).getLayoutParams();
        localLayoutParams.removeRule(3);
        localLayoutParams.addRule(12);
        localLayoutParams.bottomMargin = com.tencent.mm.cd.a.fromDPToPix(WalletIdCardCheckUI.this.getContext(), 96);
        WalletIdCardCheckUI.d(WalletIdCardCheckUI.this).setLayoutParams(localLayoutParams);
        AppMethodBeat.o(315637);
      }
    });
    AppMethodBeat.o(315647);
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
    boolean bool = true;
    AppMethodBeat.i(69708);
    this.Vre = ((WalletFormView)findViewById(a.f.identity_et));
    this.Vrg = ((TextView)findViewById(a.f.wallet_card_identify_err_hint));
    this.Vrf = ((TextView)findViewById(a.f.wallet_card_identify_tipmsg));
    this.Vri = ((RelativeLayout)findViewById(a.f.root_container));
    this.mll = ((TextView)findViewById(a.f.wallet_check_id_card_title));
    aw.a(this.mll.getPaint(), 0.8F);
    this.Vre.setOnInputValidChangeListener(this);
    this.Vre.setOnEditorActionListener(this);
    int i = com.tencent.mm.cd.a.fromDPToPix(getContext(), 19);
    int j = com.tencent.mm.cd.a.fromDPToPix(getContext(), 8);
    Object localObject1 = new LinearLayout.LayoutParams(i, i);
    ((LinearLayout.LayoutParams)localObject1).gravity = 17;
    ((LinearLayout.LayoutParams)localObject1).rightMargin = j;
    ((LinearLayout.LayoutParams)localObject1).leftMargin = j;
    this.Vre.getInfoIv().setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.Vre.getInfoIv().setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.Vre.getInfoIv().setClearBtnDrawableId(a.h.icons_filled_close2, getResources().getColor(a.c.FG_2));
    this.Vrg.setVisibility(4);
    this.Vrh = ((Button)findViewById(a.f.install_query));
    com.tencent.mm.wallet_core.ui.formview.a.d(this.Vre);
    setEditFocusListener(this.Vre, 1, false, false, true);
    this.Vre.getContentEt().setSingleLine(false);
    localObject1 = this.Vre.getContentEt();
    this.Vre.getContentEt().setPadding(((View)localObject1).getPaddingLeft(), ((View)localObject1).getPaddingTop(), ((View)localObject1).getPaddingLeft(), getBodyView().getPaddingBottom());
    findViewById(a.f.tenpay_keyboard_layout).setVisibility(8);
    this.Vrh.setOnClickListener(new k()
    {
      public final void dr(View paramAnonymousView)
      {
        AppMethodBeat.i(315636);
        if (WalletIdCardCheckUI.a(WalletIdCardCheckUI.this))
        {
          paramAnonymousView = new rn();
          paramAnonymousView.iPe = 1L;
          paramAnonymousView.jvX = 1L;
          paramAnonymousView.bMH();
          com.tencent.mm.plugin.report.service.h.OAn.b(13731, new Object[] { Integer.valueOf(2) });
          paramAnonymousView = WalletIdCardCheckUI.b(WalletIdCardCheckUI.this).getText();
          int i = WalletIdCardCheckUI.c(WalletIdCardCheckUI.this);
          u.iiC().getTrueName();
          paramAnonymousView = new com.tencent.mm.wallet_core.model.p(paramAnonymousView, i);
          WalletIdCardCheckUI.this.doSceneProgress(paramAnonymousView);
        }
        AppMethodBeat.o(315636);
      }
    });
    this.Vrj = u.iiC().ijr();
    localObject1 = u.iiC();
    if (((am)localObject1).VKc != null)
    {
      localObject1 = ((am)localObject1).VKc.field_cre_name;
      Log.i("Micromsg.WalletIdCardCheckUI", "mIdentityType %d %s", new Object[] { Integer.valueOf(this.Vrj), localObject1 });
      if (!Util.isNullOrNil((String)localObject1)) {
        break label634;
      }
      localObject1 = u.iiK().bf(this, this.Vrj);
    }
    label527:
    label629:
    label634:
    for (;;)
    {
      Object localObject2 = this.Vre;
      i = this.Vrj;
      localObject2 = ((WalletFormView)localObject2).getLogicDelegate();
      if ((localObject2 instanceof a.a)) {
        ((a.a)localObject2).aGB(i);
      }
      this.Vre.setTitleText((String)localObject1);
      localObject1 = this.Vre.getTitleTv().getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).width = -2;
      this.Vre.getTitleTv().setLayoutParams((ViewGroup.LayoutParams)localObject1);
      if (Util.isNullOrNil(this.Vre.getText())) {
        this.Vrh.setEnabled(false);
      }
      this.Vre.gGd();
      if (this.Vrj == 1)
      {
        setEditFocusListener(this.Vre, 1, false, false, true);
        localObject1 = u.iiC().getTrueName();
        this.Vre.setHint(getString(a.i.wallet_password_setting_digitalcert_hint, new Object[] { com.tencent.mm.wallet_core.ui.i.bEQ((String)localObject1) }));
        setTenpayKBStateListener(new com.tencent.mm.wallet_core.ui.a()
        {
          public final void onVisibleStateChange(boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(315635);
            WalletIdCardCheckUI.a(WalletIdCardCheckUI.this, paramAnonymousBoolean);
            AppMethodBeat.o(315635);
          }
        });
        if (this.mKeyboard.getVisibility() != 0) {
          break label629;
        }
      }
      for (;;)
      {
        HA(bool);
        this.Vre.setmWalletFormViewListener(new WalletFormView.c()
        {
          public final void f(CharSequence paramAnonymousCharSequence)
          {
            AppMethodBeat.i(315630);
            if (paramAnonymousCharSequence.length() > 0)
            {
              WalletIdCardCheckUI.d(WalletIdCardCheckUI.this).setEnabled(true);
              AppMethodBeat.o(315630);
              return;
            }
            WalletIdCardCheckUI.d(WalletIdCardCheckUI.this).setEnabled(false);
            AppMethodBeat.o(315630);
          }
        });
        AppMethodBeat.o(69708);
        return;
        localObject1 = "";
        break;
        setEditFocusListener(this.Vre, 1, true);
        break label527;
        bool = false;
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
    this.Vrg.setVisibility(4);
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
  
  public boolean onPreSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(69710);
    Log.d("Micromsg.WalletIdCardCheckUI", " errCode: " + paramInt2 + " errMsg :" + paramString);
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramp instanceof com.tencent.mm.wallet_core.model.p)))
    {
      paramString = new rn();
      paramString.iPe = 1L;
      paramString.jvX = 2L;
      paramString.bMH();
      paramString = Toast.makeText(getContext(), "", 0);
      paramp = View.inflate(getContext(), a.g.center_toast, null);
      ((WeImageView)paramp.findViewById(a.f.toast_img)).setImageResource(a.h.icons_filled_done);
      ((TextView)paramp.findViewById(a.f.toast_text)).setText(getString(a.i.wallet_password_setting_digitalcert_install_ok));
      paramString.setGravity(17, 0, 0);
      paramString.setView(paramp);
      paramString.show();
      com.tencent.threadpool.h.ahAA.o(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(315629);
          paramString.cancel();
          WalletIdCardCheckUI.this.setResult(-1);
          WalletIdCardCheckUI.this.finish();
          AppMethodBeat.o(315629);
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
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(315691);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(a.class);
    AppMethodBeat.o(315691);
  }
  
  public static class a
    extends MMBaseAccessibilityConfig
  {
    public a(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
    
    public void initConfig()
    {
      AppMethodBeat.i(315628);
      MMBaseAccessibilityConfig.ConfigHelper localConfigHelper = root(a.g.wallet_check_id_card);
      localConfigHelper.disable(a.f.root_container);
      localConfigHelper.disable(a.f.bottom_line_up);
      localConfigHelper.disable(a.f.bottom_line_down);
      localConfigHelper.disable(a.f.identity_et);
      localConfigHelper.disable(a.f.wallet_form_common_root);
      localConfigHelper.disable(a.f.wallet_prefilled);
      localConfigHelper.focusFirst(a.f.wallet_check_id_card_title);
      localConfigHelper.focusOrder().next(a.f.input_tip).next(a.f.wallet_title).next(a.f.wallet_content).next(a.f.wallet_info).next(a.f.install_query).next(a.f.tenpay_push_down).next(a.f.tenpay_keyboard_1).next(a.f.tenpay_keyboard_2).next(a.f.tenpay_keyboard_3).next(a.f.tenpay_keyboard_4).next(a.f.tenpay_keyboard_5).next(a.f.tenpay_keyboard_6).next(a.f.tenpay_keyboard_7).next(a.f.tenpay_keyboard_8).next(a.f.tenpay_keyboard_9).next(a.f.tenpay_keyboard_x).next(a.f.tenpay_keyboard_0).next(a.f.tenpay_keyboard_d).next(a.f.actionbar_up_indicator);
      int i = com.tencent.mm.cd.a.fromDPToPix(getContext(), 24);
      localConfigHelper.view(a.f.wallet_info).expand(i, i, i, i);
      AppMethodBeat.o(315628);
    }
    
    public void onResume()
    {
      AppMethodBeat.i(315632);
      super.onResume();
      AppMethodBeat.o(315632);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletIdCardCheckUI
 * JD-Core Version:    0.7.0.1
 */