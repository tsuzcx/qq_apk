package com.tencent.mm.plugin.wallet.balance.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
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
import com.tencent.mm.ak.n;
import com.tencent.mm.model.v;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet_core.c.ag;
import com.tencent.mm.plugin.wallet_core.c.al;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.ui.view.c;
import com.tencent.mm.protocal.protobuf.cpo;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.LayoutListenerView;
import com.tencent.mm.ui.MMActivity;
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
  private ArrayList<Bankcard> CQh;
  protected Bankcard CQi;
  private String CQj;
  protected LinearLayout CQl;
  private LinearLayout CRC;
  private TextView CRD;
  private TextView CRE;
  private al CRF;
  private boolean CRG;
  private d CRH;
  private final int HARDCODE_TENPAY_KEYBOARD_HEIGHT;
  private ViewGroup mcI;
  protected WalletFormView pkW;
  private HashMap<String, Integer> vtZ;
  protected double ymU;
  
  public WalletBalanceSaveUI()
  {
    AppMethodBeat.i(68709);
    this.HARDCODE_TENPAY_KEYBOARD_HEIGHT = com.tencent.mm.cb.a.fromDPToPix(com.tencent.mm.sdk.platformtools.ak.getContext(), 270);
    this.CRG = false;
    this.vtZ = new HashMap();
    AppMethodBeat.o(68709);
  }
  
  private void eGf()
  {
    AppMethodBeat.i(68719);
    doSceneProgress(new ag(), false);
    AppMethodBeat.o(68719);
  }
  
  private void eGk()
  {
    AppMethodBeat.i(68711);
    if (this.CRF == null)
    {
      this.CRC.setVisibility(8);
      AppMethodBeat.o(68711);
      return;
    }
    this.CRC.setVisibility(0);
    this.CRD.setText(this.CRF.title);
    this.CRE.setText(this.CRF.nhq);
    this.CRC.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68693);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceSaveUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        ae.i("MicroMsg.WalletBalanceSaveUI", "click lqt entrance: %s", new Object[] { Boolean.valueOf(WalletBalanceSaveUI.a(WalletBalanceSaveUI.this).Dhk) });
        com.tencent.mm.plugin.report.service.g.yxI.f(17084, new Object[] { Integer.valueOf(5) });
        if (WalletBalanceSaveUI.a(WalletBalanceSaveUI.this).Dhk)
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
  
  private void fetchData()
  {
    AppMethodBeat.i(68713);
    s.eGW();
    Object localObject = s.eGX();
    this.CQh = ((an)localObject).eKd();
    this.CQi = ((an)localObject).a(this.CQh, null, false, true);
    int i;
    if ((this.CQi != null) && (bu.isNullOrNil(this.CQi.field_forbidWord)))
    {
      this.CQi = null;
      i = 0;
    }
    for (;;)
    {
      if (i < this.CQh.size())
      {
        if ((this.CQh.get(i) != null) && (bu.isNullOrNil(((Bankcard)this.CQh.get(i)).field_forbidWord))) {
          this.CQi = ((Bankcard)this.CQh.get(i));
        }
      }
      else
      {
        if ((this.CQi != null) && (!bu.isNullOrNil(this.CQi.field_forbidWord))) {
          this.CQi = null;
        }
        localObject = this.CQh;
        if (localObject == null) {
          break;
        }
        i = 0;
        while (i < ((ArrayList)localObject).size())
        {
          ae.v("MicroMsg.WalletBalanceSaveUI", "pos %s word %s", new Object[] { Integer.valueOf(i), ((Bankcard)((ArrayList)localObject).get(i)).field_forbidWord });
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
    if (this.CQl != null)
    {
      if (this.CQi == null) {
        break label310;
      }
      localImageView = (ImageView)this.CQl.findViewById(2131297166);
      localObject = "";
      com.tencent.mm.plugin.wallet_core.model.e locale = com.tencent.mm.plugin.wallet_core.d.b.i(this, this.CQi.field_bankcardType, this.CQi.eIx());
      if (locale != null) {
        localObject = locale.wFJ;
      }
      localImageView.setImageBitmap(null);
      if (!this.CQi.eIy()) {
        break label214;
      }
      localImageView.setBackgroundResource(2131234612);
      ((TextView)this.CQl.findViewById(2131297091)).setText(getString(2131765024, new Object[] { this.CQi.field_bankName, this.CQi.field_bankcardTail }));
      if (bu.isNullOrNil(this.CQi.field_avail_save_wording)) {
        break label280;
      }
      ((TextView)this.CQl.findViewById(2131300742)).setText(this.CQi.field_avail_save_wording);
      ((TextView)this.CQl.findViewById(2131300742)).setVisibility(0);
    }
    for (;;)
    {
      ((TextView)this.CQl.findViewById(2131306836)).setText(2131765023);
      AppMethodBeat.o(68717);
      return;
      label214:
      localObject = com.tencent.mm.platformtools.u.a(new c((String)localObject));
      com.tencent.mm.platformtools.u.a(new u.a()
      {
        public final void k(String paramAnonymousString, final Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(68700);
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(68699);
              if ((WalletBalanceSaveUI.this.CQi != null) && (WalletBalanceSaveUI.5.this.CQV != null) && (WalletBalanceSaveUI.5.this.CQV.getTag() != null) && (WalletBalanceSaveUI.5.this.CQV.getTag().equals(WalletBalanceSaveUI.this.CQi.field_bindSerial))) {
                WalletBalanceSaveUI.5.this.CQV.setImageBitmap(paramAnonymousBitmap);
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
      localImageView.setImageBitmap(com.tencent.mm.sdk.platformtools.h.a((Bitmap)localObject, getResources().getDimensionPixelOffset(2131167003), getResources().getDimensionPixelOffset(2131167003), true, false));
      break;
      label280:
      ae.i("MicroMsg.WalletBalanceSaveUI", "hy: wording's missing. use default");
      ((TextView)this.CQl.findViewById(2131300742)).setText("");
      continue;
      label310:
      ((TextView)this.CQl.findViewById(2131297091)).setText(this.CQj);
      ((TextView)this.CQl.findViewById(2131300742)).setText("");
      ((ImageView)this.CQl.findViewById(2131297166)).setImageBitmap(null);
    }
  }
  
  public final void bv(float paramFloat)
  {
    AppMethodBeat.i(68720);
    if (this.mcI != null)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.mcI.getLayoutParams();
      localLayoutParams.bottomMargin = ((int)paramFloat);
      ae.d("MicroMsg.WalletBalanceSaveUI", "onUpdateWcPayKeyboardHeight() height: %s rootView.height: %s", new Object[] { Float.valueOf(paramFloat), Integer.valueOf(localLayoutParams.height) });
      this.mcI.setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(68720);
  }
  
  protected void eGl()
  {
    AppMethodBeat.i(68718);
    if (this.CQi != null)
    {
      doSceneProgress(new com.tencent.mm.plugin.wallet.balance.model.e(this.ymU, "CNY", this.CQi.field_bindSerial, this.CQi.field_bankcardType));
      AppMethodBeat.o(68718);
      return;
    }
    com.tencent.mm.plugin.wallet_core.model.g localg = com.tencent.mm.plugin.wallet_core.model.g.eII();
    if (localg.bnS())
    {
      com.tencent.mm.ui.base.h.c(this, localg.wRu, getString(2131755906), true);
      AppMethodBeat.o(68718);
      return;
    }
    doSceneProgress(new com.tencent.mm.plugin.wallet.balance.model.e(this.ymU, "CNY", "", ""));
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
    this.mcI = ((ViewGroup)findViewById(2131304286));
    this.pkW = ((WalletFormView)findViewById(2131302446));
    this.CRC = ((LinearLayout)findViewById(2131301673));
    this.CRD = ((TextView)findViewById(2131301674));
    this.CRE = ((TextView)findViewById(2131301672));
    this.mWcKeyboard = new WcPayKeyboard(this);
    com.tencent.mm.wallet_core.ui.formview.a.f(this.pkW);
    this.pkW.getTitleTv().setText(ah.fWc());
    Object localObject = this.mWcKeyboard;
    LayoutListenerView localLayoutListenerView = (LayoutListenerView)findViewById(2131302320);
    localLayoutListenerView.setBackgroundColor(-1);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
    localLayoutParams.gravity = 80;
    localLayoutListenerView.addView((View)localObject, localLayoutParams);
    ((WcPayKeyboard)localObject).setVisibility(8);
    ((WcPayKeyboard)localObject).LTx = localLayoutListenerView.getChildAt(0);
    ((WcPayKeyboard)localObject).LTA = true;
    setWPKeyboard(this.pkW.getContentEt(), true, false);
    this.mWcKeyboard.setActionText(getString(2131765007));
    this.pkW.a(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(68705);
        if (paramAnonymousEditable.toString().startsWith(".")) {
          paramAnonymousEditable.insert(0, "0");
        }
        paramAnonymousEditable = paramAnonymousEditable.toString();
        int i = paramAnonymousEditable.indexOf(".");
        int j = paramAnonymousEditable.length();
        if ((i >= 0) && (j - i > 3)) {
          WalletFormView.a(WalletBalanceSaveUI.this.pkW.getContentEt(), paramAnonymousEditable, i + 3, j);
        }
        for (;;)
        {
          WalletBalanceSaveUI.e(WalletBalanceSaveUI.this);
          AppMethodBeat.o(68705);
          return;
          if (i > 10) {
            WalletFormView.a(WalletBalanceSaveUI.this.pkW.getContentEt(), paramAnonymousEditable, 10, i);
          } else if ((i == -1) && (j > 10)) {
            WalletFormView.a(WalletBalanceSaveUI.this.pkW.getContentEt(), paramAnonymousEditable, 10, j);
          }
        }
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    localObject = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68706);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceSaveUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        WalletBalanceSaveUI.this.ymU = bu.getDouble(WalletBalanceSaveUI.this.pkW.getText(), 0.0D);
        if ((WalletBalanceSaveUI.this.ymU > 0.0D) && (WalletBalanceSaveUI.this.pkW.aVz()))
        {
          WalletBalanceSaveUI.this.hideWcKb();
          WalletBalanceSaveUI.this.eGl();
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
    this.pkW.getContentEt().setOnEditorActionListener(new WalletBalanceSaveUI.12(this, (View.OnClickListener)localObject));
    this.CQl = ((LinearLayout)findViewById(2131297090));
    if (this.CQl != null) {
      this.CQl.setOnClickListener(new WalletBalanceSaveUI.13(this));
    }
    setTenpayKBStateListener(new com.tencent.mm.wallet_core.ui.a()
    {
      public final void onVisibleStateChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(68694);
        if (paramAnonymousBoolean)
        {
          WalletBalanceSaveUI.eGm();
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
    if (!v.aAR()) {
      eGf();
    }
    setActionbarColor(getResources().getColor(2131099687));
    hideActionbarLine();
    fetchData();
    this.CQj = getString(2131765026);
    initView();
    paramBundle = (String)((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(am.a.IXg, "");
    if (!bu.isNullOrNil(paramBundle)) {}
    try
    {
      this.CRF = al.aX(new JSONObject(paramBundle));
      eGk();
      updateView();
      ab.kI(3, 0);
      AppMethodBeat.o(68714);
      return;
    }
    catch (JSONException paramBundle)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.WalletBalanceSaveUI", paramBundle, "", new Object[0]);
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
    if (this.CRG) {
      eGf();
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
        if ("1".equals(paramString.dOi))
        {
          ae.i("MicroMsg.WalletBalanceSaveUI", "need realname verify");
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
          if ("2".equals(paramString.dOi))
          {
            ae.i("MicroMsg.WalletBalanceSaveUI", "need upload credit");
            bool = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, paramString.dOj, paramString.dOm, paramString.dOk, paramString.dOl, isTransparent(), null);
          }
          else
          {
            ae.i("MicroMsg.WalletBalanceSaveUI", "realnameGuideFlag =  " + paramString.dOi);
            bool = false;
          }
        }
        paramn = ((com.tencent.mm.plugin.wallet.balance.model.e)paramn).dwj;
        af.w(11, paramn, paramInt2);
        if (this.CQi == null)
        {
          paramString = "";
          com.tencent.mm.pluginsdk.wallet.f.a(this, paramString, paramn, "", 11, 1);
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(68710);
      return false;
      paramString = this.CQi.field_bindSerial;
      break;
      if ((paramn instanceof ag))
      {
        paramString = (ag)paramn;
        if (!this.CRG)
        {
          fetchData();
          updateView();
        }
        this.CRG = false;
        this.CRF = paramString.CRF;
        eGk();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceSaveUI
 * JD-Core Version:    0.7.0.1
 */