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
import com.tencent.mm.ak.q;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.au;
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
  public static String HRI = "key_countrycode";
  public static String HRJ = "key_provincecode";
  public static String HRK = "key_citycode";
  public static String HRL = "key_zone";
  public static String HRM = "key_address";
  public static String HRN = "key_exclude_country";
  private WalletFormView HRE;
  private Button HRF;
  private InputPanelLinearLayout HRG;
  private int HRH;
  private String HRO;
  private Bundle HRP;
  private ArrayList<String> HRQ;
  private WalletFormView HRv;
  private String cityCode;
  private String countryCode;
  private boolean hwq;
  private String iUO;
  private String provinceCode;
  private int ygg;
  
  public WcPayRealnameInputAddressUI()
  {
    AppMethodBeat.i(174450);
    this.HRH = 1;
    this.HRP = new Bundle();
    this.HRQ = new ArrayList();
    AppMethodBeat.o(174450);
  }
  
  private void aS(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(182523);
    this.hwq = paramBoolean1;
    if (paramBoolean2)
    {
      if (paramBoolean1) {}
      for (ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.HRF, "translationY", new float[] { this.HRF.getTranslationY(), this.HRF.getTranslationY() - this.ygg });; localObjectAnimator = ObjectAnimator.ofFloat(this.HRF, "translationY", new float[] { this.HRF.getTranslationY(), this.HRF.getTranslationY() + this.ygg }))
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
      this.HRF.setTranslationY(this.HRF.getTranslationY() - this.ygg);
      AppMethodBeat.o(182523);
      return;
    }
    this.HRF.setTranslationY(this.HRF.getTranslationY() + this.ygg);
    AppMethodBeat.o(182523);
  }
  
  private void fPX()
  {
    boolean bool2 = false;
    AppMethodBeat.i(174453);
    boolean bool1 = true;
    if (Util.isNullOrNil(this.HRE.getText())) {
      bool1 = false;
    }
    if (Util.isNullOrNil(this.HRv.getText())) {
      bool1 = bool2;
    }
    for (;;)
    {
      this.HRF.setEnabled(bool1);
      AppMethodBeat.o(174453);
      return;
    }
  }
  
  public int getLayoutId()
  {
    return 2131497042;
  }
  
  public void initView()
  {
    AppMethodBeat.i(174452);
    this.HRE = ((WalletFormView)findViewById(2131310587));
    this.HRv = ((WalletFormView)findViewById(2131310583));
    this.HRF = ((Button)findViewById(2131310584));
    this.HRG = ((InputPanelLinearLayout)findViewById(2131310585));
    this.HRG.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(214167);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameInputAddressUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        WcPayRealnameInputAddressUI.this.hideVKB();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameInputAddressUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(214167);
      }
    });
    this.HRv.getContentEt().setInputType(131073);
    int i = getResources().getDimensionPixelSize(2131165498);
    int j = getResources().getDimensionPixelSize(2131165277);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(i, i);
    localLayoutParams.gravity = 17;
    localLayoutParams.rightMargin = j;
    this.HRv.getInfoIv().setLayoutParams(localLayoutParams);
    this.HRv.getInfoIv().setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.HRv.getInfoIv().setClearBtnDrawableId$255f295(getResources().getColor(2131099749));
    this.HRv.setText(this.iUO);
    this.HRv.a(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(214168);
        WcPayRealnameInputAddressUI.c(WcPayRealnameInputAddressUI.this);
        AppMethodBeat.o(214168);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.HRE.setText(this.HRO);
    this.HRE.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(174449);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameInputAddressUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        WcPayRealnameInputAddressUI.d(WcPayRealnameInputAddressUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameInputAddressUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(174449);
      }
    });
    this.HRF.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(214169);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameInputAddressUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        WcPayRealnameInputAddressUI.this.hideVKB();
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra(WcPayRealnameInputAddressUI.HRI, WcPayRealnameInputAddressUI.e(WcPayRealnameInputAddressUI.this));
        paramAnonymousView.putExtra(WcPayRealnameInputAddressUI.HRJ, WcPayRealnameInputAddressUI.f(WcPayRealnameInputAddressUI.this));
        paramAnonymousView.putExtra(WcPayRealnameInputAddressUI.HRK, WcPayRealnameInputAddressUI.g(WcPayRealnameInputAddressUI.this));
        paramAnonymousView.putExtra(WcPayRealnameInputAddressUI.HRL, WcPayRealnameInputAddressUI.h(WcPayRealnameInputAddressUI.this).getText());
        paramAnonymousView.putExtra(WcPayRealnameInputAddressUI.HRM, WcPayRealnameInputAddressUI.i(WcPayRealnameInputAddressUI.this).getText());
        WcPayRealnameInputAddressUI.this.setResult(-1, paramAnonymousView);
        WcPayRealnameInputAddressUI.this.finish();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameInputAddressUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(214169);
      }
    });
    fPX();
    this.HRG.setExternalListener(new b.a()
    {
      public final void f(boolean paramAnonymousBoolean, int paramAnonymousInt)
      {
        AppMethodBeat.i(214170);
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
          n = n - au.ay(WcPayRealnameInputAddressUI.this.getContext()) - au.aD(WcPayRealnameInputAddressUI.this.getContext()) - h.eu(WcPayRealnameInputAddressUI.this.getContext()) - WcPayRealnameInputAddressUI.i(WcPayRealnameInputAddressUI.this).getBottom();
          Log.d("MicroMsg.WcPayRealnameInputAddressUI", "marginBottomOriginPix：%s, marginBottomNewPix: %s, marginTopMinPix: %s, buttonHeightPix: %s, height: %s, offset: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(n - m - paramAnonymousInt - j) });
          if (n - m - paramAnonymousInt - j <= k) {
            break label282;
          }
          WcPayRealnameInputAddressUI.a(WcPayRealnameInputAddressUI.this, paramAnonymousInt - (i - j));
        }
        for (;;)
        {
          WcPayRealnameInputAddressUI.a(WcPayRealnameInputAddressUI.this, paramAnonymousBoolean);
          Log.i("MicroMsg.WcPayRealnameInputAddressUI", "onInputPanelChange() isKeyboardShow:%s keyboardHeight:%s moveHeight:%s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf(paramAnonymousInt), Integer.valueOf(WcPayRealnameInputAddressUI.j(WcPayRealnameInputAddressUI.this)) });
          AppMethodBeat.o(214170);
          return;
          label282:
          WcPayRealnameInputAddressUI.a(WcPayRealnameInputAddressUI.this, n - k - m - i);
        }
      }
    });
    float f1 = this.HRv.getTitleMeasuredWidth();
    float f2 = this.HRE.getTitleMeasuredWidth();
    Log.d("MicroMsg.WcPayRealnameInputAddressUI", "measured width: %s, %s", new Object[] { Float.valueOf(f1), Float.valueOf(f2) });
    f1 = Math.max(f1, f2) + 10.0F;
    this.HRv.setTitleWidth((int)f1);
    this.HRE.setTitleWidth((int)f1);
    f.a(new WalletFormView[] { this.HRv, this.HRE });
    AppMethodBeat.o(174452);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(174454);
    if ((paramInt1 == this.HRH) && (paramInt2 == -1))
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
      this.HRO = localStringBuilder.toString();
      this.HRE.setText(localStringBuilder.toString());
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
    this.countryCode = getIntent().getStringExtra(HRI);
    this.provinceCode = getIntent().getStringExtra(HRJ);
    this.cityCode = getIntent().getStringExtra(HRK);
    this.HRO = getIntent().getStringExtra(HRL);
    this.iUO = getIntent().getStringExtra(HRM);
    paramBundle = getIntent().getStringArrayExtra(HRN);
    if ((paramBundle != null) && (paramBundle.length > 0))
    {
      this.HRQ.addAll(Arrays.asList(paramBundle));
      this.HRQ.remove("CN");
      this.HRQ.remove("TW");
      this.HRQ.remove("HK");
      this.HRQ.remove("MO");
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
    }, 2131689494);
    AppMethodBeat.o(174451);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(182522);
    super.onPause();
    if (this.hwq)
    {
      hideVKB();
      aS(false, false);
      this.HRG.getInputPanelHelper().AxH = false;
    }
    AppMethodBeat.o(182522);
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
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameInputAddressUI
 * JD-Core Version:    0.7.0.1
 */