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
import com.tencent.mm.al.n;
import com.tencent.mm.cd.a;
import com.tencent.mm.pluginsdk.g;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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
  public static String zYc = "key_countrycode";
  public static String zYd = "key_provincecode";
  public static String zYe = "key_citycode";
  public static String zYf = "key_zone";
  public static String zYg = "key_address";
  public static String zYh = "key_exclude_country";
  private String cityCode;
  private String countryCode;
  private String hdQ;
  private boolean mEv;
  private String provinceCode;
  private int srD;
  private WalletFormView zXP;
  private WalletFormView zXY;
  private Button zXZ;
  private InputPanelLinearLayout zYa;
  private int zYb;
  private String zYi;
  private Bundle zYj;
  private ArrayList<String> zYk;
  
  public WcPayRealnameInputAddressUI()
  {
    AppMethodBeat.i(174450);
    this.zYb = 1;
    this.zYj = new Bundle();
    this.zYk = new ArrayList();
    AppMethodBeat.o(174450);
  }
  
  private void av(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(182523);
    this.mEv = paramBoolean1;
    if (paramBoolean2)
    {
      if (paramBoolean1) {}
      for (ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.zXZ, "translationY", new float[] { this.zXZ.getTranslationY(), this.zXZ.getTranslationY() - this.srD });; localObjectAnimator = ObjectAnimator.ofFloat(this.zXZ, "translationY", new float[] { this.zXZ.getTranslationY(), this.zXZ.getTranslationY() + this.srD }))
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
      this.zXZ.setTranslationY(this.zXZ.getTranslationY() - this.srD);
      AppMethodBeat.o(182523);
      return;
    }
    this.zXZ.setTranslationY(this.zXZ.getTranslationY() + this.srD);
    AppMethodBeat.o(182523);
  }
  
  private void ebr()
  {
    boolean bool2 = false;
    AppMethodBeat.i(174453);
    boolean bool1 = true;
    if (bt.isNullOrNil(this.zXY.getText())) {
      bool1 = false;
    }
    if (bt.isNullOrNil(this.zXP.getText())) {
      bool1 = bool2;
    }
    for (;;)
    {
      this.zXZ.setEnabled(bool1);
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
    this.zXY = ((WalletFormView)findViewById(2131307063));
    this.zXP = ((WalletFormView)findViewById(2131307059));
    this.zXZ = ((Button)findViewById(2131307060));
    this.zYa = ((InputPanelLinearLayout)findViewById(2131307061));
    this.zYa.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(187152);
        WcPayRealnameInputAddressUI.this.hideVKB();
        AppMethodBeat.o(187152);
      }
    });
    this.zXP.getContentEt().setInputType(131073);
    int i = getResources().getDimensionPixelSize(2131165480);
    int j = getResources().getDimensionPixelSize(2131165274);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(i, i);
    localLayoutParams.gravity = 17;
    localLayoutParams.rightMargin = j;
    this.zXP.getInfoIv().setLayoutParams(localLayoutParams);
    this.zXP.getInfoIv().setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.zXP.getInfoIv().setClearBtnDrawableId$255f295(getResources().getColor(2131099735));
    this.zXP.setText(this.hdQ);
    this.zXP.a(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(187153);
        WcPayRealnameInputAddressUI.c(WcPayRealnameInputAddressUI.this);
        AppMethodBeat.o(187153);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.zXY.setText(this.zYi);
    this.zXY.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(174449);
        WcPayRealnameInputAddressUI.d(WcPayRealnameInputAddressUI.this);
        AppMethodBeat.o(174449);
      }
    });
    this.zXZ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(187154);
        WcPayRealnameInputAddressUI.this.hideVKB();
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra(WcPayRealnameInputAddressUI.zYc, WcPayRealnameInputAddressUI.e(WcPayRealnameInputAddressUI.this));
        paramAnonymousView.putExtra(WcPayRealnameInputAddressUI.zYd, WcPayRealnameInputAddressUI.f(WcPayRealnameInputAddressUI.this));
        paramAnonymousView.putExtra(WcPayRealnameInputAddressUI.zYe, WcPayRealnameInputAddressUI.g(WcPayRealnameInputAddressUI.this));
        paramAnonymousView.putExtra(WcPayRealnameInputAddressUI.zYf, WcPayRealnameInputAddressUI.h(WcPayRealnameInputAddressUI.this).getText());
        paramAnonymousView.putExtra(WcPayRealnameInputAddressUI.zYg, WcPayRealnameInputAddressUI.i(WcPayRealnameInputAddressUI.this).getText());
        WcPayRealnameInputAddressUI.this.setResult(-1, paramAnonymousView);
        WcPayRealnameInputAddressUI.this.finish();
        AppMethodBeat.o(187154);
      }
    });
    ebr();
    this.zYa.setExternalListener(new b.a()
    {
      public final void g(boolean paramAnonymousBoolean, int paramAnonymousInt)
      {
        AppMethodBeat.i(187155);
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
          n = n - ap.jA(WcPayRealnameInputAddressUI.this.getContext()) - ap.eb(WcPayRealnameInputAddressUI.this.getContext()) - g.dL(WcPayRealnameInputAddressUI.this.getContext()) - WcPayRealnameInputAddressUI.i(WcPayRealnameInputAddressUI.this).getBottom();
          ad.d("MicroMsg.WcPayRealnameInputAddressUI", "marginBottomOriginPix：%s, marginBottomNewPix: %s, marginTopMinPix: %s, buttonHeightPix: %s, height: %s, offset: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(n - m - paramAnonymousInt - j) });
          if (n - m - paramAnonymousInt - j <= k) {
            break label282;
          }
          WcPayRealnameInputAddressUI.a(WcPayRealnameInputAddressUI.this, paramAnonymousInt - (i - j));
        }
        for (;;)
        {
          WcPayRealnameInputAddressUI.a(WcPayRealnameInputAddressUI.this, paramAnonymousBoolean);
          ad.i("MicroMsg.WcPayRealnameInputAddressUI", "onInputPanelChange() isKeyboardShow:%s keyboardHeight:%s moveHeight:%s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf(paramAnonymousInt), Integer.valueOf(WcPayRealnameInputAddressUI.j(WcPayRealnameInputAddressUI.this)) });
          AppMethodBeat.o(187155);
          return;
          label282:
          WcPayRealnameInputAddressUI.a(WcPayRealnameInputAddressUI.this, n - k - m - i);
        }
      }
    });
    float f1 = this.zXP.getTitleMeasuredWidth();
    float f2 = this.zXY.getTitleMeasuredWidth();
    ad.d("MicroMsg.WcPayRealnameInputAddressUI", "measured width: %s, %s", new Object[] { Float.valueOf(f1), Float.valueOf(f2) });
    f1 = Math.max(f1, f2) + 10.0F;
    this.zXP.setTitleWidth((int)f1);
    this.zXY.setTitleWidth((int)f1);
    e.a(new WalletFormView[] { this.zXP, this.zXY });
    AppMethodBeat.o(174452);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(174454);
    if ((paramInt1 == this.zYb) && (paramInt2 == -1))
    {
      String str1 = paramIntent.getStringExtra("CountryName");
      String str2 = paramIntent.getStringExtra("ProviceName");
      String str3 = paramIntent.getStringExtra("CityName");
      this.countryCode = paramIntent.getStringExtra("Country");
      this.provinceCode = paramIntent.getStringExtra("Contact_Province");
      this.cityCode = paramIntent.getStringExtra("Contact_City");
      StringBuilder localStringBuilder = new StringBuilder();
      if (!bt.isNullOrNil(str1))
      {
        localStringBuilder.append(str1);
        localStringBuilder.append(" ");
      }
      if (!bt.isNullOrNil(str2))
      {
        localStringBuilder.append(str2);
        localStringBuilder.append(" ");
      }
      if (!bt.isNullOrNil(str3)) {
        localStringBuilder.append(str3);
      }
      this.zYi = localStringBuilder.toString();
      this.zXY.setText(localStringBuilder.toString());
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
    this.countryCode = getIntent().getStringExtra(zYc);
    this.provinceCode = getIntent().getStringExtra(zYd);
    this.cityCode = getIntent().getStringExtra(zYe);
    this.zYi = getIntent().getStringExtra(zYf);
    this.hdQ = getIntent().getStringExtra(zYg);
    paramBundle = getIntent().getStringArrayExtra(zYh);
    if ((paramBundle != null) && (paramBundle.length > 0))
    {
      this.zYk.addAll(Arrays.asList(paramBundle));
      this.zYk.remove("CN");
      this.zYk.remove("TW");
      this.zYk.remove("HK");
      this.zYk.remove("MO");
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
    if (this.mEv)
    {
      hideVKB();
      av(false, false);
      this.zYa.getInputPanelHelper().HyL = false;
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