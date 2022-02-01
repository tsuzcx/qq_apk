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
import com.tencent.mm.al.n;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.ar;
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
  public static String CQL = "key_countrycode";
  public static String CQM = "key_provincecode";
  public static String CQN = "key_citycode";
  public static String CQO = "key_zone";
  public static String CQP = "key_address";
  public static String CQQ = "key_exclude_country";
  private WalletFormView CQH;
  private Button CQI;
  private InputPanelLinearLayout CQJ;
  private int CQK;
  private String CQR;
  private Bundle CQS;
  private ArrayList<String> CQT;
  private WalletFormView CQy;
  private String cityCode;
  private String countryCode;
  private boolean gGI;
  private String hWY;
  private String provinceCode;
  private int uCd;
  
  public WcPayRealnameInputAddressUI()
  {
    AppMethodBeat.i(174450);
    this.CQK = 1;
    this.CQS = new Bundle();
    this.CQT = new ArrayList();
    AppMethodBeat.o(174450);
  }
  
  private void aG(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(182523);
    this.gGI = paramBoolean1;
    if (paramBoolean2)
    {
      if (paramBoolean1) {}
      for (ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.CQI, "translationY", new float[] { this.CQI.getTranslationY(), this.CQI.getTranslationY() - this.uCd });; localObjectAnimator = ObjectAnimator.ofFloat(this.CQI, "translationY", new float[] { this.CQI.getTranslationY(), this.CQI.getTranslationY() + this.uCd }))
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
      this.CQI.setTranslationY(this.CQI.getTranslationY() - this.uCd);
      AppMethodBeat.o(182523);
      return;
    }
    this.CQI.setTranslationY(this.CQI.getTranslationY() + this.uCd);
    AppMethodBeat.o(182523);
  }
  
  private void eEN()
  {
    boolean bool2 = false;
    AppMethodBeat.i(174453);
    boolean bool1 = true;
    if (bt.isNullOrNil(this.CQH.getText())) {
      bool1 = false;
    }
    if (bt.isNullOrNil(this.CQy.getText())) {
      bool1 = bool2;
    }
    for (;;)
    {
      this.CQI.setEnabled(bool1);
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
    this.CQH = ((WalletFormView)findViewById(2131307063));
    this.CQy = ((WalletFormView)findViewById(2131307059));
    this.CQI = ((Button)findViewById(2131307060));
    this.CQJ = ((InputPanelLinearLayout)findViewById(2131307061));
    this.CQJ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(199301);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameInputAddressUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        WcPayRealnameInputAddressUI.this.hideVKB();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameInputAddressUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(199301);
      }
    });
    this.CQy.getContentEt().setInputType(131073);
    int i = getResources().getDimensionPixelSize(2131165480);
    int j = getResources().getDimensionPixelSize(2131165274);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(i, i);
    localLayoutParams.gravity = 17;
    localLayoutParams.rightMargin = j;
    this.CQy.getInfoIv().setLayoutParams(localLayoutParams);
    this.CQy.getInfoIv().setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.CQy.getInfoIv().setClearBtnDrawableId$255f295(getResources().getColor(2131099735));
    this.CQy.setText(this.hWY);
    this.CQy.a(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(199302);
        WcPayRealnameInputAddressUI.c(WcPayRealnameInputAddressUI.this);
        AppMethodBeat.o(199302);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.CQH.setText(this.CQR);
    this.CQH.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(174449);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameInputAddressUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        WcPayRealnameInputAddressUI.d(WcPayRealnameInputAddressUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameInputAddressUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(174449);
      }
    });
    this.CQI.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(199303);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameInputAddressUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        WcPayRealnameInputAddressUI.this.hideVKB();
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra(WcPayRealnameInputAddressUI.CQL, WcPayRealnameInputAddressUI.e(WcPayRealnameInputAddressUI.this));
        paramAnonymousView.putExtra(WcPayRealnameInputAddressUI.CQM, WcPayRealnameInputAddressUI.f(WcPayRealnameInputAddressUI.this));
        paramAnonymousView.putExtra(WcPayRealnameInputAddressUI.CQN, WcPayRealnameInputAddressUI.g(WcPayRealnameInputAddressUI.this));
        paramAnonymousView.putExtra(WcPayRealnameInputAddressUI.CQO, WcPayRealnameInputAddressUI.h(WcPayRealnameInputAddressUI.this).getText());
        paramAnonymousView.putExtra(WcPayRealnameInputAddressUI.CQP, WcPayRealnameInputAddressUI.i(WcPayRealnameInputAddressUI.this).getText());
        WcPayRealnameInputAddressUI.this.setResult(-1, paramAnonymousView);
        WcPayRealnameInputAddressUI.this.finish();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameInputAddressUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(199303);
      }
    });
    eEN();
    this.CQJ.setExternalListener(new b.a()
    {
      public final void g(boolean paramAnonymousBoolean, int paramAnonymousInt)
      {
        AppMethodBeat.i(199304);
        int n;
        int i;
        int k;
        int m;
        if (paramAnonymousBoolean)
        {
          n = ((WindowManager)WcPayRealnameInputAddressUI.this.getSystemService("window")).getDefaultDisplay().getHeight();
          i = com.tencent.mm.cc.a.fromDPToPix(WcPayRealnameInputAddressUI.this.getContext(), 96);
          int j = com.tencent.mm.cc.a.fromDPToPix(WcPayRealnameInputAddressUI.this.getContext(), 40);
          k = com.tencent.mm.cc.a.fromDPToPix(WcPayRealnameInputAddressUI.this.getContext(), 32);
          m = com.tencent.mm.cc.a.fromDPToPix(WcPayRealnameInputAddressUI.this.getContext(), 40);
          n = n - ar.jW(WcPayRealnameInputAddressUI.this.getContext()) - ar.ej(WcPayRealnameInputAddressUI.this.getContext()) - h.dT(WcPayRealnameInputAddressUI.this.getContext()) - WcPayRealnameInputAddressUI.i(WcPayRealnameInputAddressUI.this).getBottom();
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
          AppMethodBeat.o(199304);
          return;
          label282:
          WcPayRealnameInputAddressUI.a(WcPayRealnameInputAddressUI.this, n - k - m - i);
        }
      }
    });
    float f1 = this.CQy.getTitleMeasuredWidth();
    float f2 = this.CQH.getTitleMeasuredWidth();
    ad.d("MicroMsg.WcPayRealnameInputAddressUI", "measured width: %s, %s", new Object[] { Float.valueOf(f1), Float.valueOf(f2) });
    f1 = Math.max(f1, f2) + 10.0F;
    this.CQy.setTitleWidth((int)f1);
    this.CQH.setTitleWidth((int)f1);
    e.a(new WalletFormView[] { this.CQy, this.CQH });
    AppMethodBeat.o(174452);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(174454);
    if ((paramInt1 == this.CQK) && (paramInt2 == -1))
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
      this.CQR = localStringBuilder.toString();
      this.CQH.setText(localStringBuilder.toString());
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
    this.countryCode = getIntent().getStringExtra(CQL);
    this.provinceCode = getIntent().getStringExtra(CQM);
    this.cityCode = getIntent().getStringExtra(CQN);
    this.CQR = getIntent().getStringExtra(CQO);
    this.hWY = getIntent().getStringExtra(CQP);
    paramBundle = getIntent().getStringArrayExtra(CQQ);
    if ((paramBundle != null) && (paramBundle.length > 0))
    {
      this.CQT.addAll(Arrays.asList(paramBundle));
      this.CQT.remove("CN");
      this.CQT.remove("TW");
      this.CQT.remove("HK");
      this.CQT.remove("MO");
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
    if (this.gGI)
    {
      hideVKB();
      aG(false, false);
      this.CQJ.getInputPanelHelper().KpO = false;
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