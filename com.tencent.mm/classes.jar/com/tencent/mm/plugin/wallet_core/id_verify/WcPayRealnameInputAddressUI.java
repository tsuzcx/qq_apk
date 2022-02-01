package com.tencent.mm.plugin.wallet_core.id_verify;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.view.b.b;
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
import com.tencent.mm.cc.a;
import com.tencent.mm.pluginsdk.g;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.ap;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;
import com.tencent.mm.ui.widget.b.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.util.ArrayList;
import java.util.Arrays;

public class WcPayRealnameInputAddressUI
  extends WalletBaseUI
{
  public static String BqA = "key_address";
  public static String BqB = "key_exclude_country";
  public static String Bqw = "key_countrycode";
  public static String Bqx = "key_provincecode";
  public static String Bqy = "key_citycode";
  public static String Bqz = "key_zone";
  private String BqC;
  private Bundle BqD;
  private ArrayList<String> BqE;
  private WalletFormView Bqj;
  private WalletFormView Bqs;
  private Button Bqt;
  private InputPanelLinearLayout Bqu;
  private int Bqv;
  private String cityCode;
  private String countryCode;
  private boolean gmZ;
  private String hEt;
  private String provinceCode;
  private int tzu;
  
  public WcPayRealnameInputAddressUI()
  {
    AppMethodBeat.i(174450);
    this.Bqv = 1;
    this.BqD = new Bundle();
    this.BqE = new ArrayList();
    AppMethodBeat.o(174450);
  }
  
  private void az(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(182523);
    this.gmZ = paramBoolean1;
    if (paramBoolean2)
    {
      if (paramBoolean1) {}
      for (ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.Bqt, "translationY", new float[] { this.Bqt.getTranslationY(), this.Bqt.getTranslationY() - this.tzu });; localObjectAnimator = ObjectAnimator.ofFloat(this.Bqt, "translationY", new float[] { this.Bqt.getTranslationY(), this.Bqt.getTranslationY() + this.tzu }))
      {
        localObjectAnimator.setDuration(175L);
        localObjectAnimator.setInterpolator(new b());
        localObjectAnimator.start();
        AppMethodBeat.o(182523);
        return;
      }
    }
    if (paramBoolean1)
    {
      this.Bqt.setTranslationY(this.Bqt.getTranslationY() - this.tzu);
      AppMethodBeat.o(182523);
      return;
    }
    this.Bqt.setTranslationY(this.Bqt.getTranslationY() + this.tzu);
    AppMethodBeat.o(182523);
  }
  
  private void eqN()
  {
    boolean bool2 = false;
    AppMethodBeat.i(174453);
    boolean bool1 = true;
    if (bs.isNullOrNil(this.Bqs.getText())) {
      bool1 = false;
    }
    if (bs.isNullOrNil(this.Bqj.getText())) {
      bool1 = bool2;
    }
    for (;;)
    {
      this.Bqt.setEnabled(bool1);
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
    this.Bqs = ((WalletFormView)findViewById(2131307063));
    this.Bqj = ((WalletFormView)findViewById(2131307059));
    this.Bqt = ((Button)findViewById(2131307060));
    this.Bqu = ((InputPanelLinearLayout)findViewById(2131307061));
    this.Bqu.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(207273);
        WcPayRealnameInputAddressUI.this.hideVKB();
        AppMethodBeat.o(207273);
      }
    });
    this.Bqj.getContentEt().setInputType(131073);
    int i = getResources().getDimensionPixelSize(2131165480);
    int j = getResources().getDimensionPixelSize(2131165274);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(i, i);
    localLayoutParams.gravity = 17;
    localLayoutParams.rightMargin = j;
    this.Bqj.getInfoIv().setLayoutParams(localLayoutParams);
    this.Bqj.getInfoIv().setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.Bqj.getInfoIv().setClearBtnDrawableId$255f295(getResources().getColor(2131099735));
    this.Bqj.setText(this.hEt);
    this.Bqj.a(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(207274);
        WcPayRealnameInputAddressUI.c(WcPayRealnameInputAddressUI.this);
        AppMethodBeat.o(207274);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.Bqs.setText(this.BqC);
    this.Bqs.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(174449);
        WcPayRealnameInputAddressUI.d(WcPayRealnameInputAddressUI.this);
        AppMethodBeat.o(174449);
      }
    });
    this.Bqt.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(207275);
        WcPayRealnameInputAddressUI.this.hideVKB();
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra(WcPayRealnameInputAddressUI.Bqw, WcPayRealnameInputAddressUI.e(WcPayRealnameInputAddressUI.this));
        paramAnonymousView.putExtra(WcPayRealnameInputAddressUI.Bqx, WcPayRealnameInputAddressUI.f(WcPayRealnameInputAddressUI.this));
        paramAnonymousView.putExtra(WcPayRealnameInputAddressUI.Bqy, WcPayRealnameInputAddressUI.g(WcPayRealnameInputAddressUI.this));
        paramAnonymousView.putExtra(WcPayRealnameInputAddressUI.Bqz, WcPayRealnameInputAddressUI.h(WcPayRealnameInputAddressUI.this).getText());
        paramAnonymousView.putExtra(WcPayRealnameInputAddressUI.BqA, WcPayRealnameInputAddressUI.i(WcPayRealnameInputAddressUI.this).getText());
        WcPayRealnameInputAddressUI.this.setResult(-1, paramAnonymousView);
        WcPayRealnameInputAddressUI.this.finish();
        AppMethodBeat.o(207275);
      }
    });
    eqN();
    this.Bqu.setExternalListener(new b.a()
    {
      public final void g(boolean paramAnonymousBoolean, int paramAnonymousInt)
      {
        AppMethodBeat.i(207276);
        int n;
        int i;
        int k;
        int m;
        if (paramAnonymousBoolean)
        {
          n = ((WindowManager)WcPayRealnameInputAddressUI.this.getSystemService("window")).getDefaultDisplay().getHeight();
          i = a.fromDPToPix(WcPayRealnameInputAddressUI.this.getContext(), 96);
          int j = a.fromDPToPix(WcPayRealnameInputAddressUI.this.getContext(), 40);
          k = a.fromDPToPix(WcPayRealnameInputAddressUI.this.getContext(), 32);
          m = a.fromDPToPix(WcPayRealnameInputAddressUI.this.getContext(), 40);
          n = n - ap.jL(WcPayRealnameInputAddressUI.this.getContext()) - ap.ej(WcPayRealnameInputAddressUI.this.getContext()) - g.dT(WcPayRealnameInputAddressUI.this.getContext()) - WcPayRealnameInputAddressUI.i(WcPayRealnameInputAddressUI.this).getBottom();
          ac.d("MicroMsg.WcPayRealnameInputAddressUI", "marginBottomOriginPix：%s, marginBottomNewPix: %s, marginTopMinPix: %s, buttonHeightPix: %s, height: %s, offset: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(n - m - paramAnonymousInt - j) });
          if (n - m - paramAnonymousInt - j <= k) {
            break label282;
          }
          WcPayRealnameInputAddressUI.a(WcPayRealnameInputAddressUI.this, paramAnonymousInt - (i - j));
        }
        for (;;)
        {
          WcPayRealnameInputAddressUI.a(WcPayRealnameInputAddressUI.this, paramAnonymousBoolean);
          ac.i("MicroMsg.WcPayRealnameInputAddressUI", "onInputPanelChange() isKeyboardShow:%s keyboardHeight:%s moveHeight:%s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf(paramAnonymousInt), Integer.valueOf(WcPayRealnameInputAddressUI.j(WcPayRealnameInputAddressUI.this)) });
          AppMethodBeat.o(207276);
          return;
          label282:
          WcPayRealnameInputAddressUI.a(WcPayRealnameInputAddressUI.this, n - k - m - i);
        }
      }
    });
    float f1 = this.Bqj.getTitleMeasuredWidth();
    float f2 = this.Bqs.getTitleMeasuredWidth();
    ac.d("MicroMsg.WcPayRealnameInputAddressUI", "measured width: %s, %s", new Object[] { Float.valueOf(f1), Float.valueOf(f2) });
    f1 = Math.max(f1, f2) + 10.0F;
    this.Bqj.setTitleWidth((int)f1);
    this.Bqs.setTitleWidth((int)f1);
    e.a(new WalletFormView[] { this.Bqj, this.Bqs });
    AppMethodBeat.o(174452);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(174454);
    if ((paramInt1 == this.Bqv) && (paramInt2 == -1))
    {
      String str1 = paramIntent.getStringExtra("CountryName");
      String str2 = paramIntent.getStringExtra("ProviceName");
      String str3 = paramIntent.getStringExtra("CityName");
      this.countryCode = paramIntent.getStringExtra("Country");
      this.provinceCode = paramIntent.getStringExtra("Contact_Province");
      this.cityCode = paramIntent.getStringExtra("Contact_City");
      StringBuilder localStringBuilder = new StringBuilder();
      if (!bs.isNullOrNil(str1))
      {
        localStringBuilder.append(str1);
        localStringBuilder.append(" ");
      }
      if (!bs.isNullOrNil(str2))
      {
        localStringBuilder.append(str2);
        localStringBuilder.append(" ");
      }
      if (!bs.isNullOrNil(str3)) {
        localStringBuilder.append(str3);
      }
      this.BqC = localStringBuilder.toString();
      this.Bqs.setText(localStringBuilder.toString());
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
    this.countryCode = getIntent().getStringExtra(Bqw);
    this.provinceCode = getIntent().getStringExtra(Bqx);
    this.cityCode = getIntent().getStringExtra(Bqy);
    this.BqC = getIntent().getStringExtra(Bqz);
    this.hEt = getIntent().getStringExtra(BqA);
    paramBundle = getIntent().getStringArrayExtra(BqB);
    if ((paramBundle != null) && (paramBundle.length > 0))
    {
      this.BqE.addAll(Arrays.asList(paramBundle));
      this.BqE.remove("CN");
      this.BqE.remove("TW");
      this.BqE.remove("HK");
      this.BqE.remove("MO");
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
    if (this.gmZ)
    {
      hideVKB();
      az(false, false);
      this.Bqu.getInputPanelHelper().IZi = false;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameInputAddressUI
 * JD-Core Version:    0.7.0.1
 */