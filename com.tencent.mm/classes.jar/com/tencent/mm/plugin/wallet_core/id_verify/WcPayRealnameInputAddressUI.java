package com.tencent.mm.plugin.wallet_core.id_verify;

import android.animation.ObjectAnimator;
import android.app.Activity;
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
import com.tencent.mm.ak.n;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;
import com.tencent.mm.ui.widget.b.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.util.ArrayList;
import java.util.Arrays;

public class WcPayRealnameInputAddressUI
  extends WalletBaseUI
{
  public static String Dip = "key_countrycode";
  public static String Diq = "key_provincecode";
  public static String Dir = "key_citycode";
  public static String Dis = "key_zone";
  public static String Dit = "key_address";
  public static String Diu = "key_exclude_country";
  private WalletFormView Dic;
  private WalletFormView Dil;
  private Button Dim;
  private InputPanelLinearLayout Din;
  private int Dio;
  private String Div;
  private Bundle Diw;
  private ArrayList<String> Dix;
  private String cityCode;
  private String countryCode;
  private boolean gJr;
  private String hZQ;
  private String provinceCode;
  private int uNI;
  
  public WcPayRealnameInputAddressUI()
  {
    AppMethodBeat.i(174450);
    this.Dio = 1;
    this.Diw = new Bundle();
    this.Dix = new ArrayList();
    AppMethodBeat.o(174450);
  }
  
  private void aF(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(182523);
    this.gJr = paramBoolean1;
    if (paramBoolean2)
    {
      if (paramBoolean1) {}
      for (ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.Dim, "translationY", new float[] { this.Dim.getTranslationY(), this.Dim.getTranslationY() - this.uNI });; localObjectAnimator = ObjectAnimator.ofFloat(this.Dim, "translationY", new float[] { this.Dim.getTranslationY(), this.Dim.getTranslationY() + this.uNI }))
      {
        localObjectAnimator.setDuration(175L);
        localObjectAnimator.setInterpolator(new android.support.v4.view.b.b());
        localObjectAnimator.start();
        AppMethodBeat.o(182523);
        return;
      }
    }
    if (paramBoolean1)
    {
      this.Dim.setTranslationY(this.Dim.getTranslationY() - this.uNI);
      AppMethodBeat.o(182523);
      return;
    }
    this.Dim.setTranslationY(this.Dim.getTranslationY() + this.uNI);
    AppMethodBeat.o(182523);
  }
  
  private void eIu()
  {
    boolean bool2 = false;
    AppMethodBeat.i(174453);
    boolean bool1 = true;
    if (bu.isNullOrNil(this.Dil.getText())) {
      bool1 = false;
    }
    if (bu.isNullOrNil(this.Dic.getText())) {
      bool1 = bool2;
    }
    for (;;)
    {
      this.Dim.setEnabled(bool1);
      AppMethodBeat.o(174453);
      return;
    }
  }
  
  public int getLayoutId()
  {
    return 2131496062;
  }
  
  public void initView()
  {
    AppMethodBeat.i(174452);
    this.Dil = ((WalletFormView)findViewById(2131307063));
    this.Dic = ((WalletFormView)findViewById(2131307059));
    this.Dim = ((Button)findViewById(2131307060));
    this.Din = ((InputPanelLinearLayout)findViewById(2131307061));
    this.Din.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(190165);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameInputAddressUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        WcPayRealnameInputAddressUI.this.hideVKB();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameInputAddressUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(190165);
      }
    });
    this.Dic.getContentEt().setInputType(131073);
    int i = getResources().getDimensionPixelSize(2131165480);
    int j = getResources().getDimensionPixelSize(2131165274);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(i, i);
    localLayoutParams.gravity = 17;
    localLayoutParams.rightMargin = j;
    this.Dic.getInfoIv().setLayoutParams(localLayoutParams);
    this.Dic.getInfoIv().setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.Dic.getInfoIv().setClearBtnDrawableId$255f295(getResources().getColor(2131099735));
    this.Dic.setText(this.hZQ);
    this.Dic.a(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(190166);
        WcPayRealnameInputAddressUI.c(WcPayRealnameInputAddressUI.this);
        AppMethodBeat.o(190166);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.Dil.setText(this.Div);
    this.Dil.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(174449);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameInputAddressUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        WcPayRealnameInputAddressUI.d(WcPayRealnameInputAddressUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameInputAddressUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(174449);
      }
    });
    this.Dim.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(190167);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameInputAddressUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        WcPayRealnameInputAddressUI.this.hideVKB();
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra(WcPayRealnameInputAddressUI.Dip, WcPayRealnameInputAddressUI.e(WcPayRealnameInputAddressUI.this));
        paramAnonymousView.putExtra(WcPayRealnameInputAddressUI.Diq, WcPayRealnameInputAddressUI.f(WcPayRealnameInputAddressUI.this));
        paramAnonymousView.putExtra(WcPayRealnameInputAddressUI.Dir, WcPayRealnameInputAddressUI.g(WcPayRealnameInputAddressUI.this));
        paramAnonymousView.putExtra(WcPayRealnameInputAddressUI.Dis, WcPayRealnameInputAddressUI.h(WcPayRealnameInputAddressUI.this).getText());
        paramAnonymousView.putExtra(WcPayRealnameInputAddressUI.Dit, WcPayRealnameInputAddressUI.i(WcPayRealnameInputAddressUI.this).getText());
        WcPayRealnameInputAddressUI.this.setResult(-1, paramAnonymousView);
        WcPayRealnameInputAddressUI.this.finish();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameInputAddressUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(190167);
      }
    });
    eIu();
    this.Din.setExternalListener(new b.a()
    {
      public final void g(boolean paramAnonymousBoolean, int paramAnonymousInt)
      {
        AppMethodBeat.i(190168);
        int n;
        int i;
        int k;
        int m;
        if (paramAnonymousBoolean)
        {
          n = ((WindowManager)WcPayRealnameInputAddressUI.this.getSystemService("window")).getDefaultDisplay().getHeight();
          i = com.tencent.mm.cb.a.fromDPToPix(WcPayRealnameInputAddressUI.this.getContext(), 96);
          int j = com.tencent.mm.cb.a.fromDPToPix(WcPayRealnameInputAddressUI.this.getContext(), 40);
          k = com.tencent.mm.cb.a.fromDPToPix(WcPayRealnameInputAddressUI.this.getContext(), 32);
          m = com.tencent.mm.cb.a.fromDPToPix(WcPayRealnameInputAddressUI.this.getContext(), 40);
          n = n - ar.kd(WcPayRealnameInputAddressUI.this.getContext()) - ar.en(WcPayRealnameInputAddressUI.this.getContext()) - h.dX(WcPayRealnameInputAddressUI.this.getContext()) - WcPayRealnameInputAddressUI.i(WcPayRealnameInputAddressUI.this).getBottom();
          ae.d("MicroMsg.WcPayRealnameInputAddressUI", "marginBottomOriginPix：%s, marginBottomNewPix: %s, marginTopMinPix: %s, buttonHeightPix: %s, height: %s, offset: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(n - m - paramAnonymousInt - j) });
          if (n - m - paramAnonymousInt - j <= k) {
            break label282;
          }
          WcPayRealnameInputAddressUI.a(WcPayRealnameInputAddressUI.this, paramAnonymousInt - (i - j));
        }
        for (;;)
        {
          WcPayRealnameInputAddressUI.a(WcPayRealnameInputAddressUI.this, paramAnonymousBoolean);
          ae.i("MicroMsg.WcPayRealnameInputAddressUI", "onInputPanelChange() isKeyboardShow:%s keyboardHeight:%s moveHeight:%s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf(paramAnonymousInt), Integer.valueOf(WcPayRealnameInputAddressUI.j(WcPayRealnameInputAddressUI.this)) });
          AppMethodBeat.o(190168);
          return;
          label282:
          WcPayRealnameInputAddressUI.a(WcPayRealnameInputAddressUI.this, n - k - m - i);
        }
      }
    });
    float f1 = this.Dic.getTitleMeasuredWidth();
    float f2 = this.Dil.getTitleMeasuredWidth();
    ae.d("MicroMsg.WcPayRealnameInputAddressUI", "measured width: %s, %s", new Object[] { Float.valueOf(f1), Float.valueOf(f2) });
    f1 = Math.max(f1, f2) + 10.0F;
    this.Dic.setTitleWidth((int)f1);
    this.Dil.setTitleWidth((int)f1);
    f.a(new WalletFormView[] { this.Dic, this.Dil });
    AppMethodBeat.o(174452);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(174454);
    if ((paramInt1 == this.Dio) && (paramInt2 == -1))
    {
      String str1 = paramIntent.getStringExtra("CountryName");
      String str2 = paramIntent.getStringExtra("ProviceName");
      String str3 = paramIntent.getStringExtra("CityName");
      this.countryCode = paramIntent.getStringExtra("Country");
      this.provinceCode = paramIntent.getStringExtra("Contact_Province");
      this.cityCode = paramIntent.getStringExtra("Contact_City");
      StringBuilder localStringBuilder = new StringBuilder();
      if (!bu.isNullOrNil(str1))
      {
        localStringBuilder.append(str1);
        localStringBuilder.append(" ");
      }
      if (!bu.isNullOrNil(str2))
      {
        localStringBuilder.append(str2);
        localStringBuilder.append(" ");
      }
      if (!bu.isNullOrNil(str3)) {
        localStringBuilder.append(str3);
      }
      this.Div = localStringBuilder.toString();
      this.Dil.setText(localStringBuilder.toString());
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(174454);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(174451);
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(2131099653));
    hideActionbarLine();
    setMMTitle("");
    this.countryCode = getIntent().getStringExtra(Dip);
    this.provinceCode = getIntent().getStringExtra(Diq);
    this.cityCode = getIntent().getStringExtra(Dir);
    this.Div = getIntent().getStringExtra(Dis);
    this.hZQ = getIntent().getStringExtra(Dit);
    paramBundle = getIntent().getStringArrayExtra(Diu);
    if ((paramBundle != null) && (paramBundle.length > 0))
    {
      this.Dix.addAll(Arrays.asList(paramBundle));
      this.Dix.remove("CN");
      this.Dix.remove("TW");
      this.Dix.remove("HK");
      this.Dix.remove("MO");
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
    }, 2131689492);
    AppMethodBeat.o(174451);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(182522);
    super.onPause();
    if (this.gJr)
    {
      hideVKB();
      aF(false, false);
      this.Din.getInputPanelHelper().KMi = false;
    }
    AppMethodBeat.o(182522);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameInputAddressUI
 * JD-Core Version:    0.7.0.1
 */