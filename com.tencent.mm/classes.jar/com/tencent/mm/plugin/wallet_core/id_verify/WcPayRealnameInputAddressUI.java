package com.tencent.mm.plugin.wallet_core.id_verify;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Display;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.wallet_core.utils.g;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;
import com.tencent.mm.ui.widget.c.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class WcPayRealnameInputAddressUI
  extends WalletBaseUI
{
  public static String VzB = "key_countrycode";
  public static String VzC = "key_provincecode";
  public static String VzD = "key_citycode";
  public static String VzE = "key_zone";
  public static String VzF = "key_address";
  public static String VzG = "key_exclude_country";
  private Button BoW;
  private int JjQ;
  private int VzA;
  private String VzH;
  private Bundle VzI;
  private ArrayList<String> VzJ;
  private WalletFormView Vzp;
  private WalletFormView Vzy;
  private InputPanelLinearLayout Vzz;
  private String cityCode;
  private String countryCode;
  private boolean mJk;
  private String oDI;
  private String provinceCode;
  
  public WcPayRealnameInputAddressUI()
  {
    AppMethodBeat.i(174450);
    this.VzA = 1;
    this.VzI = new Bundle();
    this.VzJ = new ArrayList();
    AppMethodBeat.o(174450);
  }
  
  private void bz(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(182523);
    this.mJk = paramBoolean1;
    if (paramBoolean2)
    {
      if (paramBoolean1) {}
      for (ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.BoW, "translationY", new float[] { this.BoW.getTranslationY(), this.BoW.getTranslationY() - this.JjQ });; localObjectAnimator = ObjectAnimator.ofFloat(this.BoW, "translationY", new float[] { this.BoW.getTranslationY(), this.BoW.getTranslationY() + this.JjQ }))
      {
        localObjectAnimator.setDuration(175L);
        localObjectAnimator.setInterpolator(new androidx.g.a.a.b());
        localObjectAnimator.start();
        AppMethodBeat.o(182523);
        return;
      }
    }
    if (paramBoolean1)
    {
      this.BoW.setTranslationY(this.BoW.getTranslationY() - this.JjQ);
      AppMethodBeat.o(182523);
      return;
    }
    this.BoW.setTranslationY(this.BoW.getTranslationY() + this.JjQ);
    AppMethodBeat.o(182523);
  }
  
  private void ihR()
  {
    boolean bool2 = false;
    AppMethodBeat.i(174453);
    boolean bool1 = true;
    if (Util.isNullOrNil(this.Vzy.getText())) {
      bool1 = false;
    }
    if (Util.isNullOrNil(this.Vzp.getText())) {
      bool1 = bool2;
    }
    for (;;)
    {
      this.BoW.setEnabled(bool1);
      AppMethodBeat.o(174453);
      return;
    }
  }
  
  public int getLayoutId()
  {
    return a.g.wc_pay_realname_input_address_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(174452);
    this.Vzy = ((WalletFormView)findViewById(a.f.wpra_zone_et));
    this.Vzp = ((WalletFormView)findViewById(a.f.wpra_address_et));
    this.BoW = ((Button)findViewById(a.f.wpra_ok_btn));
    this.Vzz = ((InputPanelLinearLayout)findViewById(a.f.wpra_root_content_layout));
    this.Vzz.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(301383);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameInputAddressUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        WcPayRealnameInputAddressUI.this.hideVKB();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameInputAddressUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(301383);
      }
    });
    this.Vzp.getContentEt().setInputType(131073);
    int i = getResources().getDimensionPixelSize(a.d.LargePadding);
    int j = getResources().getDimensionPixelSize(a.d.Edge_0_5_A);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(i, i);
    localLayoutParams.gravity = 17;
    localLayoutParams.rightMargin = j;
    this.Vzp.getInfoIv().setLayoutParams(localLayoutParams);
    this.Vzp.getInfoIv().setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.Vzp.getInfoIv().setClearBtnDrawableId(a.h.icons_filled_close2, getResources().getColor(a.c.FG_2));
    this.Vzp.setText(this.oDI);
    this.Vzp.a(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(301382);
        WcPayRealnameInputAddressUI.c(WcPayRealnameInputAddressUI.this);
        AppMethodBeat.o(301382);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.Vzy.setText(this.VzH);
    this.Vzy.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(174449);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameInputAddressUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        WcPayRealnameInputAddressUI.d(WcPayRealnameInputAddressUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameInputAddressUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(174449);
      }
    });
    this.BoW.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(301380);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameInputAddressUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        WcPayRealnameInputAddressUI.this.hideVKB();
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra(WcPayRealnameInputAddressUI.VzB, WcPayRealnameInputAddressUI.e(WcPayRealnameInputAddressUI.this));
        paramAnonymousView.putExtra(WcPayRealnameInputAddressUI.VzC, WcPayRealnameInputAddressUI.f(WcPayRealnameInputAddressUI.this));
        paramAnonymousView.putExtra(WcPayRealnameInputAddressUI.VzD, WcPayRealnameInputAddressUI.g(WcPayRealnameInputAddressUI.this));
        paramAnonymousView.putExtra(WcPayRealnameInputAddressUI.VzE, WcPayRealnameInputAddressUI.h(WcPayRealnameInputAddressUI.this).getText());
        paramAnonymousView.putExtra(WcPayRealnameInputAddressUI.VzF, WcPayRealnameInputAddressUI.i(WcPayRealnameInputAddressUI.this).getText());
        WcPayRealnameInputAddressUI.this.setResult(-1, paramAnonymousView);
        WcPayRealnameInputAddressUI.this.finish();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameInputAddressUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(301380);
      }
    });
    ihR();
    this.Vzz.setExternalListener(new c.a()
    {
      public final void onInputPanelChange(boolean paramAnonymousBoolean, int paramAnonymousInt)
      {
        AppMethodBeat.i(301379);
        int n;
        int i;
        int k;
        int m;
        if (paramAnonymousBoolean)
        {
          n = ((WindowManager)WcPayRealnameInputAddressUI.this.getSystemService("window")).getDefaultDisplay().getHeight();
          i = com.tencent.mm.cd.a.fromDPToPix(WcPayRealnameInputAddressUI.this.getContext(), 96);
          int j = com.tencent.mm.cd.a.fromDPToPix(WcPayRealnameInputAddressUI.this.getContext(), 40);
          k = com.tencent.mm.cd.a.fromDPToPix(WcPayRealnameInputAddressUI.this.getContext(), 32);
          m = com.tencent.mm.cd.a.fromDPToPix(WcPayRealnameInputAddressUI.this.getContext(), 40);
          n = n - bf.be(WcPayRealnameInputAddressUI.this.getContext()) - bf.bk(WcPayRealnameInputAddressUI.this.getContext()) - h.fs(WcPayRealnameInputAddressUI.this.getContext()) - WcPayRealnameInputAddressUI.i(WcPayRealnameInputAddressUI.this).getBottom();
          int i1 = n - m - paramAnonymousInt - j;
          Log.d("MicroMsg.WcPayRealnameInputAddressUI", "marginBottomOriginPix：%s, marginBottomNewPix: %s, marginTopMinPix: %s, buttonHeightPix: %s, height: %s, offset: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1) });
          if (i1 <= k) {
            break label278;
          }
          WcPayRealnameInputAddressUI.a(WcPayRealnameInputAddressUI.this, paramAnonymousInt - (i - j));
        }
        for (;;)
        {
          WcPayRealnameInputAddressUI.a(WcPayRealnameInputAddressUI.this, paramAnonymousBoolean);
          Log.i("MicroMsg.WcPayRealnameInputAddressUI", "onInputPanelChange() isKeyboardShow:%s keyboardHeight:%s moveHeight:%s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf(paramAnonymousInt), Integer.valueOf(WcPayRealnameInputAddressUI.j(WcPayRealnameInputAddressUI.this)) });
          AppMethodBeat.o(301379);
          return;
          label278:
          WcPayRealnameInputAddressUI.a(WcPayRealnameInputAddressUI.this, n - k - m - i);
        }
      }
    });
    float f1 = this.Vzp.getTitleMeasuredWidth();
    float f2 = this.Vzy.getTitleMeasuredWidth();
    Log.d("MicroMsg.WcPayRealnameInputAddressUI", "measured width: %s, %s", new Object[] { Float.valueOf(f1), Float.valueOf(f2) });
    f1 = Math.max(f1, f2) + 10.0F;
    this.Vzp.setTitleWidth((int)f1);
    this.Vzy.setTitleWidth((int)f1);
    i.a(new WalletFormView[] { this.Vzp, this.Vzy });
    AppMethodBeat.o(174452);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(174454);
    if ((paramInt1 == this.VzA) && (paramInt2 == -1))
    {
      String str1 = paramIntent.getStringExtra("CountryName");
      String str2 = paramIntent.getStringExtra("ProviceName");
      String str3 = paramIntent.getStringExtra("CityName");
      this.countryCode = paramIntent.getStringExtra("Country");
      this.provinceCode = paramIntent.getStringExtra("Contact_Province");
      this.cityCode = paramIntent.getStringExtra("Contact_City");
      StringBuilder localStringBuilder = new StringBuilder();
      if (!Util.isNullOrNil(str1))
      {
        localStringBuilder.append(str1);
        localStringBuilder.append(" ");
      }
      if (!Util.isNullOrNil(str2))
      {
        localStringBuilder.append(str2);
        localStringBuilder.append(" ");
      }
      if (!Util.isNullOrNil(str3)) {
        localStringBuilder.append(str3);
      }
      this.VzH = localStringBuilder.toString();
      this.Vzy.setText(localStringBuilder.toString());
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(174454);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(174451);
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(a.c.BG_5));
    hideActionbarLine();
    setMMTitle("");
    this.countryCode = getIntent().getStringExtra(VzB);
    this.provinceCode = getIntent().getStringExtra(VzC);
    this.cityCode = getIntent().getStringExtra(VzD);
    this.VzH = getIntent().getStringExtra(VzE);
    this.oDI = getIntent().getStringExtra(VzF);
    paramBundle = getIntent().getStringArrayExtra(VzG);
    if ((paramBundle != null) && (paramBundle.length > 0))
    {
      this.VzJ.addAll(Arrays.asList(paramBundle));
      this.VzJ.remove("CN");
      this.VzJ.remove("TW");
      this.VzJ.remove("HK");
      this.VzJ.remove("MO");
    }
    initView();
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(174446);
        if (WcPayRealnameInputAddressUI.a(WcPayRealnameInputAddressUI.this))
        {
          WcPayRealnameInputAddressUI.this.hideVKB();
          WcPayRealnameInputAddressUI.b(WcPayRealnameInputAddressUI.this);
        }
        for (;;)
        {
          AppMethodBeat.o(174446);
          return false;
          WcPayRealnameInputAddressUI.this.setResult(0);
          WcPayRealnameInputAddressUI.this.finish();
        }
      }
    }, a.h.actionbar_icon_dark_close);
    AppMethodBeat.o(174451);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(182522);
    super.onPause();
    if (this.mJk)
    {
      hideVKB();
      bz(false, false);
      this.Vzz.getInputPanelHelper().Mik = false;
    }
    AppMethodBeat.o(182522);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
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
    AppMethodBeat.i(301434);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(g.class);
    AppMethodBeat.o(301434);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameInputAddressUI
 * JD-Core Version:    0.7.0.1
 */