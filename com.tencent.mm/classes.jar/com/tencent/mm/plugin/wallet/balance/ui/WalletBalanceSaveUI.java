package com.tencent.mm.plugin.wallet.balance.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet_core.c.ag;
import com.tencent.mm.plugin.wallet_core.c.ak;
import com.tencent.mm.plugin.wallet_core.c.al;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.ui.view.c;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.LayoutListenerView;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.d;
import com.tencent.mm.wallet_core.c.aa;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.c.af;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(2)
public class WalletBalanceSaveUI
  extends WalletBaseUI
  implements WcPayKeyboard.a
{
  private al CAa;
  private boolean CAb;
  private d CAc;
  private ArrayList<Bankcard> CyC;
  protected Bankcard CyD;
  private String CyE;
  protected LinearLayout CyG;
  private LinearLayout CzX;
  private TextView CzY;
  private TextView CzZ;
  private final int HARDCODE_TENPAY_KEYBOARD_HEIGHT;
  private ViewGroup lYb;
  protected WalletFormView peq;
  private HashMap<String, Integer> vhT;
  protected double xXb;
  
  public WalletBalanceSaveUI()
  {
    AppMethodBeat.i(68709);
    this.HARDCODE_TENPAY_KEYBOARD_HEIGHT = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 270);
    this.CAb = false;
    this.vhT = new HashMap();
    AppMethodBeat.o(68709);
  }
  
  private void eCD()
  {
    AppMethodBeat.i(68711);
    if (this.CAa == null)
    {
      this.CzX.setVisibility(8);
      AppMethodBeat.o(68711);
      return;
    }
    this.CzX.setVisibility(0);
    this.CzY.setText(this.CAa.title);
    this.CzZ.setText(this.CAa.nch);
    this.CzX.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68693);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceSaveUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        ad.i("MicroMsg.WalletBalanceSaveUI", "click lqt entrance: %s", new Object[] { Boolean.valueOf(WalletBalanceSaveUI.a(WalletBalanceSaveUI.this).CPG) });
        com.tencent.mm.plugin.report.service.g.yhR.f(17084, new Object[] { Integer.valueOf(5) });
        if (WalletBalanceSaveUI.a(WalletBalanceSaveUI.this).CPG)
        {
          WalletBalanceSaveUI.this.hideWcKb();
          WalletBalanceSaveUI.b(WalletBalanceSaveUI.this);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceSaveUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(68693);
          return;
          WalletBalanceSaveUI.c(WalletBalanceSaveUI.this);
        }
      }
    });
    AppMethodBeat.o(68711);
  }
  
  private void eCy()
  {
    AppMethodBeat.i(68719);
    doSceneProgress(new ag(), false);
    AppMethodBeat.o(68719);
  }
  
  private void fetchData()
  {
    AppMethodBeat.i(68713);
    s.eDp();
    Object localObject = s.eDq();
    this.CyC = ((an)localObject).eGw();
    this.CyD = ((an)localObject).a(this.CyC, null, false, true);
    int i;
    if ((this.CyD != null) && (bt.isNullOrNil(this.CyD.field_forbidWord)))
    {
      this.CyD = null;
      i = 0;
    }
    for (;;)
    {
      if (i < this.CyC.size())
      {
        if ((this.CyC.get(i) != null) && (bt.isNullOrNil(((Bankcard)this.CyC.get(i)).field_forbidWord))) {
          this.CyD = ((Bankcard)this.CyC.get(i));
        }
      }
      else
      {
        if ((this.CyD != null) && (!bt.isNullOrNil(this.CyD.field_forbidWord))) {
          this.CyD = null;
        }
        localObject = this.CyC;
        if (localObject == null) {
          break;
        }
        i = 0;
        while (i < ((ArrayList)localObject).size())
        {
          ad.v("MicroMsg.WalletBalanceSaveUI", "pos %s word %s", new Object[] { Integer.valueOf(i), ((Bankcard)((ArrayList)localObject).get(i)).field_forbidWord });
          i += 1;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(68713);
  }
  
  private void updateView()
  {
    AppMethodBeat.i(68717);
    final ImageView localImageView;
    Object localObject;
    if (this.CyG != null)
    {
      if (this.CyD == null) {
        break label310;
      }
      localImageView = (ImageView)this.CyG.findViewById(2131297166);
      localObject = "";
      com.tencent.mm.plugin.wallet_core.model.e locale = com.tencent.mm.plugin.wallet_core.d.b.i(this, this.CyD.field_bankcardType, this.CyD.eEQ());
      if (locale != null) {
        localObject = locale.wqa;
      }
      localImageView.setImageBitmap(null);
      if (!this.CyD.eER()) {
        break label214;
      }
      localImageView.setBackgroundResource(2131234612);
      ((TextView)this.CyG.findViewById(2131297091)).setText(getString(2131765024, new Object[] { this.CyD.field_bankName, this.CyD.field_bankcardTail }));
      if (bt.isNullOrNil(this.CyD.field_avail_save_wording)) {
        break label280;
      }
      ((TextView)this.CyG.findViewById(2131300742)).setText(this.CyD.field_avail_save_wording);
      ((TextView)this.CyG.findViewById(2131300742)).setVisibility(0);
    }
    for (;;)
    {
      ((TextView)this.CyG.findViewById(2131306836)).setText(2131765023);
      AppMethodBeat.o(68717);
      return;
      label214:
      localObject = com.tencent.mm.platformtools.u.a(new c((String)localObject));
      com.tencent.mm.platformtools.u.a(new u.a()
      {
        public final void k(String paramAnonymousString, final Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(68700);
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(68699);
              if ((WalletBalanceSaveUI.this.CyD != null) && (WalletBalanceSaveUI.5.this.Czq != null) && (WalletBalanceSaveUI.5.this.Czq.getTag() != null) && (WalletBalanceSaveUI.5.this.Czq.getTag().equals(WalletBalanceSaveUI.this.CyD.field_bindSerial))) {
                WalletBalanceSaveUI.5.this.Czq.setImageBitmap(paramAnonymousBitmap);
              }
              AppMethodBeat.o(68699);
            }
          });
          AppMethodBeat.o(68700);
        }
      });
      if ((localObject == null) || (localObject == null)) {
        break;
      }
      localImageView.setImageBitmap(com.tencent.mm.sdk.platformtools.g.a((Bitmap)localObject, getResources().getDimensionPixelOffset(2131167003), getResources().getDimensionPixelOffset(2131167003), true, false));
      break;
      label280:
      ad.i("MicroMsg.WalletBalanceSaveUI", "hy: wording's missing. use default");
      ((TextView)this.CyG.findViewById(2131300742)).setText("");
      continue;
      label310:
      ((TextView)this.CyG.findViewById(2131297091)).setText(this.CyE);
      ((TextView)this.CyG.findViewById(2131300742)).setText("");
      ((ImageView)this.CyG.findViewById(2131297166)).setImageBitmap(null);
    }
  }
  
  public final void bv(float paramFloat)
  {
    AppMethodBeat.i(68720);
    if (this.lYb != null)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.lYb.getLayoutParams();
      localLayoutParams.bottomMargin = ((int)paramFloat);
      ad.d("MicroMsg.WalletBalanceSaveUI", "onUpdateWcPayKeyboardHeight() height: %s rootView.height: %s", new Object[] { Float.valueOf(paramFloat), Integer.valueOf(localLayoutParams.height) });
      this.lYb.setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(68720);
  }
  
  protected void eCE()
  {
    AppMethodBeat.i(68718);
    if (this.CyD != null)
    {
      doSceneProgress(new com.tencent.mm.plugin.wallet.balance.model.e(this.xXb, "CNY", this.CyD.field_bindSerial, this.CyD.field_bankcardType));
      AppMethodBeat.o(68718);
      return;
    }
    com.tencent.mm.plugin.wallet_core.model.g localg = com.tencent.mm.plugin.wallet_core.model.g.eFb();
    if (localg.bni())
    {
      h.c(this, localg.wBJ, getString(2131755906), true);
      AppMethodBeat.o(68718);
      return;
    }
    doSceneProgress(new com.tencent.mm.plugin.wallet.balance.model.e(this.xXb, "CNY", "", ""));
    AppMethodBeat.o(68718);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131495907;
  }
  
  public void initView()
  {
    AppMethodBeat.i(68715);
    setMMTitle(2131765033);
    this.lYb = ((ViewGroup)findViewById(2131304286));
    this.peq = ((WalletFormView)findViewById(2131302446));
    this.CzX = ((LinearLayout)findViewById(2131301673));
    this.CzY = ((TextView)findViewById(2131301674));
    this.CzZ = ((TextView)findViewById(2131301672));
    this.mWcKeyboard = new WcPayKeyboard(this);
    com.tencent.mm.wallet_core.ui.formview.a.f(this.peq);
    this.peq.getTitleTv().setText(ah.fRG());
    Object localObject = this.mWcKeyboard;
    LayoutListenerView localLayoutListenerView = (LayoutListenerView)findViewById(2131302320);
    localLayoutListenerView.setBackgroundColor(-1);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
    localLayoutParams.gravity = 80;
    localLayoutListenerView.addView((View)localObject, localLayoutParams);
    ((WcPayKeyboard)localObject).setVisibility(8);
    ((WcPayKeyboard)localObject).LwK = localLayoutListenerView.getChildAt(0);
    ((WcPayKeyboard)localObject).LwN = true;
    setWPKeyboard(this.peq.getContentEt(), true, false);
    this.mWcKeyboard.setActionText(getString(2131765007));
    this.peq.a(new WalletBalanceSaveUI.10(this));
    localObject = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68706);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceSaveUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        WalletBalanceSaveUI.this.xXb = bt.getDouble(WalletBalanceSaveUI.this.peq.getText(), 0.0D);
        if ((WalletBalanceSaveUI.this.xXb > 0.0D) && (WalletBalanceSaveUI.this.peq.aVa()))
        {
          WalletBalanceSaveUI.this.hideWcKb();
          WalletBalanceSaveUI.this.eCE();
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceSaveUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(68706);
          return;
          t.makeText(WalletBalanceSaveUI.this.getContext(), 2131765031, 0).show();
        }
      }
    };
    this.peq.getContentEt().setOnEditorActionListener(new WalletBalanceSaveUI.12(this, (View.OnClickListener)localObject));
    this.CyG = ((LinearLayout)findViewById(2131297090));
    if (this.CyG != null) {
      this.CyG.setOnClickListener(new WalletBalanceSaveUI.13(this));
    }
    setTenpayKBStateListener(new com.tencent.mm.wallet_core.ui.a()
    {
      public final void onVisibleStateChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(68694);
        if (paramAnonymousBoolean)
        {
          WalletBalanceSaveUI.eCF();
          AppMethodBeat.o(68694);
          return;
        }
        WalletBalanceSaveUI.g(WalletBalanceSaveUI.this).scrollTo(0, 0);
        AppMethodBeat.o(68694);
      }
    });
    AppMethodBeat.o(68715);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(68716);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(68716);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(68714);
    super.onCreate(paramBundle);
    if (!com.tencent.mm.model.u.aAB()) {
      eCy();
    }
    setActionbarColor(getResources().getColor(2131099687));
    hideActionbarLine();
    fetchData();
    this.CyE = getString(2131765026);
    initView();
    paramBundle = (String)((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(al.a.ICG, "");
    if (!bt.isNullOrNil(paramBundle)) {}
    try
    {
      this.CAa = al.aX(new JSONObject(paramBundle));
      eCD();
      updateView();
      ab.kB(3, 0);
      AppMethodBeat.o(68714);
      return;
    }
    catch (JSONException paramBundle)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.WalletBalanceSaveUI", paramBundle, "", new Object[0]);
      }
    }
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(68721);
    if ((this.mWcKeyboard != null) && (this.mWcKeyboard.onKeyUp(paramInt, paramKeyEvent)))
    {
      AppMethodBeat.o(68721);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(68721);
    return bool;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(68712);
    super.onResume();
    if (this.CAb) {
      eCy();
    }
    AppMethodBeat.o(68712);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(68710);
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if ((paramn instanceof com.tencent.mm.plugin.wallet.balance.model.e))
      {
        paramString = (com.tencent.mm.plugin.wallet.balance.model.e)paramn;
        boolean bool;
        if ("1".equals(paramString.dMS))
        {
          ad.i("MicroMsg.WalletBalanceSaveUI", "need realname verify");
          paramString = new Bundle();
          paramString.putString("realname_verify_process_jump_activity", ".balance.ui.WalletBalanceSaveUI");
          paramString.putString("realname_verify_process_jump_plugin", "wallet");
          isTransparent();
          bool = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, paramString, null, 0);
        }
        while (bool)
        {
          AppMethodBeat.o(68710);
          return false;
          if ("2".equals(paramString.dMS))
          {
            ad.i("MicroMsg.WalletBalanceSaveUI", "need upload credit");
            bool = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, paramString.dMT, paramString.dMW, paramString.dMU, paramString.dMV, isTransparent(), null);
          }
          else
          {
            ad.i("MicroMsg.WalletBalanceSaveUI", "realnameGuideFlag =  " + paramString.dMS);
            bool = false;
          }
        }
        paramn = ((com.tencent.mm.plugin.wallet.balance.model.e)paramn).dve;
        af.w(11, paramn, paramInt2);
        if (this.CyD == null)
        {
          paramString = "";
          f.a(this, paramString, paramn, "", 11, 1);
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(68710);
      return false;
      paramString = this.CyD.field_bindSerial;
      break;
      if ((paramn instanceof ag))
      {
        paramString = (ag)paramn;
        if (!this.CAb)
        {
          fetchData();
          updateView();
        }
        this.CAb = false;
        this.CAa = paramString.CAa;
        eCD();
        continue;
        if ((paramn instanceof com.tencent.mm.plugin.wallet.balance.model.e)) {
          af.w(11, "", paramInt2);
        }
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceSaveUI
 * JD-Core Version:    0.7.0.1
 */