package com.tencent.mm.plugin.wallet.balance.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
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
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet_core.c.ag;
import com.tencent.mm.plugin.wallet_core.c.al;
import com.tencent.mm.plugin.wallet_core.d.b;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.ui.view.c;
import com.tencent.mm.protocal.protobuf.cju;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.LayoutListenerView;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
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
  private ArrayList<Bankcard> AYt;
  protected Bankcard AYu;
  private String AYv;
  protected LinearLayout AYx;
  private LinearLayout AZK;
  private TextView AZL;
  private TextView AZM;
  private al AZN;
  private boolean AZO;
  private d AZP;
  private final int HARDCODE_TENPAY_KEYBOARD_HEIGHT;
  private ViewGroup lyD;
  protected WalletFormView oAV;
  private HashMap<String, Integer> ufk;
  protected double wJu;
  
  public WalletBalanceSaveUI()
  {
    AppMethodBeat.i(68709);
    this.HARDCODE_TENPAY_KEYBOARD_HEIGHT = com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 270);
    this.AZO = false;
    this.ufk = new HashMap();
    AppMethodBeat.o(68709);
  }
  
  private void cL()
  {
    AppMethodBeat.i(68717);
    final ImageView localImageView;
    Object localObject;
    if (this.AYx != null)
    {
      if (this.AYu == null) {
        break label305;
      }
      localImageView = (ImageView)this.AYx.findViewById(2131297166);
      localObject = "";
      com.tencent.mm.plugin.wallet_core.model.e locale = b.i(this, this.AYu.field_bankcardType, this.AYu.eqQ());
      if (locale != null) {
        localObject = locale.vkI;
      }
      localImageView.setImageBitmap(null);
      if (!this.AYu.eqR()) {
        break label210;
      }
      localImageView.setBackgroundResource(2131234612);
      ((TextView)this.AYx.findViewById(2131297091)).setText(getString(2131765024, new Object[] { this.AYu.field_bankName, this.AYu.field_bankcardTail }));
      if (bs.isNullOrNil(this.AYu.field_avail_save_wording)) {
        break label276;
      }
      ((TextView)this.AYx.findViewById(2131300742)).setText(this.AYu.field_avail_save_wording);
      ((TextView)this.AYx.findViewById(2131300742)).setVisibility(0);
    }
    for (;;)
    {
      ((TextView)this.AYx.findViewById(2131306836)).setText(2131765023);
      AppMethodBeat.o(68717);
      return;
      label210:
      localObject = com.tencent.mm.platformtools.u.a(new c((String)localObject));
      com.tencent.mm.platformtools.u.a(new u.a()
      {
        public final void k(String paramAnonymousString, final Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(68700);
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(68699);
              if ((WalletBalanceSaveUI.this.AYu != null) && (WalletBalanceSaveUI.5.this.AZe != null) && (WalletBalanceSaveUI.5.this.AZe.getTag() != null) && (WalletBalanceSaveUI.5.this.AZe.getTag().equals(WalletBalanceSaveUI.this.AYu.field_bindSerial))) {
                WalletBalanceSaveUI.5.this.AZe.setImageBitmap(paramAnonymousBitmap);
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
      localImageView.setImageBitmap(com.tencent.mm.sdk.platformtools.f.a((Bitmap)localObject, getResources().getDimensionPixelOffset(2131167003), getResources().getDimensionPixelOffset(2131167003), true, false));
      break;
      label276:
      ac.i("MicroMsg.WalletBalanceSaveUI", "hy: wording's missing. use default");
      ((TextView)this.AYx.findViewById(2131300742)).setText("");
      continue;
      label305:
      ((TextView)this.AYx.findViewById(2131297091)).setText(this.AYv);
      ((TextView)this.AYx.findViewById(2131300742)).setText("");
      ((ImageView)this.AYx.findViewById(2131297166)).setImageBitmap(null);
    }
  }
  
  private void eoD()
  {
    AppMethodBeat.i(68711);
    if (this.AZN == null)
    {
      this.AZK.setVisibility(8);
      AppMethodBeat.o(68711);
      return;
    }
    this.AZK.setVisibility(0);
    this.AZL.setText(this.AZN.title);
    this.AZM.setText(this.AZN.mBH);
    this.AZK.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68693);
        ac.i("MicroMsg.WalletBalanceSaveUI", "click lqt entrance: %s", new Object[] { Boolean.valueOf(WalletBalanceSaveUI.a(WalletBalanceSaveUI.this).Bpr) });
        com.tencent.mm.plugin.report.service.h.wUl.f(17084, new Object[] { Integer.valueOf(5) });
        if (WalletBalanceSaveUI.a(WalletBalanceSaveUI.this).Bpr)
        {
          WalletBalanceSaveUI.this.hideWcKb();
          WalletBalanceSaveUI.b(WalletBalanceSaveUI.this);
          AppMethodBeat.o(68693);
          return;
        }
        WalletBalanceSaveUI.c(WalletBalanceSaveUI.this);
        AppMethodBeat.o(68693);
      }
    });
    AppMethodBeat.o(68711);
  }
  
  private void eoz()
  {
    AppMethodBeat.i(68719);
    doSceneProgress(new ag(), false);
    AppMethodBeat.o(68719);
  }
  
  private void fetchData()
  {
    AppMethodBeat.i(68713);
    s.epp();
    Object localObject = s.epq();
    this.AYt = ((am)localObject).esw();
    this.AYu = ((am)localObject).a(this.AYt, null, false, true);
    int i;
    if ((this.AYu != null) && (bs.isNullOrNil(this.AYu.field_forbidWord)))
    {
      this.AYu = null;
      i = 0;
    }
    for (;;)
    {
      if (i < this.AYt.size())
      {
        if ((this.AYt.get(i) != null) && (bs.isNullOrNil(((Bankcard)this.AYt.get(i)).field_forbidWord))) {
          this.AYu = ((Bankcard)this.AYt.get(i));
        }
      }
      else
      {
        if ((this.AYu != null) && (!bs.isNullOrNil(this.AYu.field_forbidWord))) {
          this.AYu = null;
        }
        localObject = this.AYt;
        if (localObject == null) {
          break;
        }
        i = 0;
        while (i < ((ArrayList)localObject).size())
        {
          ac.v("MicroMsg.WalletBalanceSaveUI", "pos %s word %s", new Object[] { Integer.valueOf(i), ((Bankcard)((ArrayList)localObject).get(i)).field_forbidWord });
          i += 1;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(68713);
  }
  
  public final void bs(float paramFloat)
  {
    AppMethodBeat.i(68720);
    if (this.lyD != null)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.lyD.getLayoutParams();
      localLayoutParams.bottomMargin = ((int)paramFloat);
      ac.d("MicroMsg.WalletBalanceSaveUI", "onUpdateWcPayKeyboardHeight() height: %s rootView.height: %s", new Object[] { Float.valueOf(paramFloat), Integer.valueOf(localLayoutParams.height) });
      this.lyD.setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(68720);
  }
  
  protected void eoE()
  {
    AppMethodBeat.i(68718);
    if (this.AYu != null)
    {
      doSceneProgress(new com.tencent.mm.plugin.wallet.balance.model.e(this.wJu, "CNY", this.AYu.field_bindSerial, this.AYu.field_bankcardType));
      AppMethodBeat.o(68718);
      return;
    }
    com.tencent.mm.plugin.wallet_core.model.g localg = com.tencent.mm.plugin.wallet_core.model.g.erb();
    if (localg.bjw())
    {
      com.tencent.mm.ui.base.h.c(this, localg.vwp, getString(2131755906), true);
      AppMethodBeat.o(68718);
      return;
    }
    doSceneProgress(new com.tencent.mm.plugin.wallet.balance.model.e(this.wJu, "CNY", "", ""));
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
    this.lyD = ((ViewGroup)findViewById(2131304286));
    this.oAV = ((WalletFormView)findViewById(2131302446));
    this.AZK = ((LinearLayout)findViewById(2131301673));
    this.AZL = ((TextView)findViewById(2131301674));
    this.AZM = ((TextView)findViewById(2131301672));
    this.mWcKeyboard = new WcPayKeyboard(this);
    com.tencent.mm.wallet_core.ui.formview.a.f(this.oAV);
    this.oAV.getTitleTv().setText(ah.fAw());
    Object localObject = this.mWcKeyboard;
    LayoutListenerView localLayoutListenerView = (LayoutListenerView)findViewById(2131302320);
    localLayoutListenerView.setBackgroundColor(-1);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
    localLayoutParams.gravity = 80;
    localLayoutListenerView.addView((View)localObject, localLayoutParams);
    ((WcPayKeyboard)localObject).setVisibility(8);
    ((WcPayKeyboard)localObject).JDE = localLayoutListenerView.getChildAt(0);
    ((WcPayKeyboard)localObject).JDH = true;
    setWPKeyboard(this.oAV.getContentEt(), true, false);
    this.mWcKeyboard.setActionText(getString(2131765007));
    this.oAV.a(new TextWatcher()
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
          WalletFormView.a(WalletBalanceSaveUI.this.oAV.getContentEt(), paramAnonymousEditable, i + 3, j);
        }
        for (;;)
        {
          WalletBalanceSaveUI.e(WalletBalanceSaveUI.this);
          AppMethodBeat.o(68705);
          return;
          if (i > 10) {
            WalletFormView.a(WalletBalanceSaveUI.this.oAV.getContentEt(), paramAnonymousEditable, 10, i);
          } else if ((i == -1) && (j > 10)) {
            WalletFormView.a(WalletBalanceSaveUI.this.oAV.getContentEt(), paramAnonymousEditable, 10, j);
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
        WalletBalanceSaveUI.this.wJu = bs.getDouble(WalletBalanceSaveUI.this.oAV.getText(), 0.0D);
        if ((WalletBalanceSaveUI.this.wJu > 0.0D) && (WalletBalanceSaveUI.this.oAV.aRO()))
        {
          WalletBalanceSaveUI.this.hideWcKb();
          WalletBalanceSaveUI.this.eoE();
          AppMethodBeat.o(68706);
          return;
        }
        t.makeText(WalletBalanceSaveUI.this.getContext(), 2131765031, 0).show();
        AppMethodBeat.o(68706);
      }
    };
    this.oAV.getContentEt().setOnEditorActionListener(new WalletBalanceSaveUI.12(this, (View.OnClickListener)localObject));
    this.AYx = ((LinearLayout)findViewById(2131297090));
    if (this.AYx != null) {
      this.AYx.setOnClickListener(new WalletBalanceSaveUI.13(this));
    }
    setTenpayKBStateListener(new com.tencent.mm.wallet_core.ui.a()
    {
      public final void onVisibleStateChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(68694);
        if (paramAnonymousBoolean)
        {
          WalletBalanceSaveUI.eoF();
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
    if (!com.tencent.mm.model.u.axL()) {
      eoz();
    }
    setActionbarColor(getResources().getColor(2131099687));
    hideActionbarLine();
    fetchData();
    this.AYv = getString(2131765026);
    initView();
    paramBundle = (String)((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(ah.a.GQm, "");
    if (!bs.isNullOrNil(paramBundle)) {}
    try
    {
      this.AZN = al.aP(new JSONObject(paramBundle));
      eoD();
      cL();
      ab.km(3, 0);
      AppMethodBeat.o(68714);
      return;
    }
    catch (JSONException paramBundle)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.WalletBalanceSaveUI", paramBundle, "", new Object[0]);
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
    if (this.AZO) {
      eoz();
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
        if ("1".equals(paramString.dAF))
        {
          ac.i("MicroMsg.WalletBalanceSaveUI", "need realname verify");
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
          if ("2".equals(paramString.dAF))
          {
            ac.i("MicroMsg.WalletBalanceSaveUI", "need upload credit");
            bool = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, paramString.dAG, paramString.dAJ, paramString.dAH, paramString.dAI, isTransparent(), null);
          }
          else
          {
            ac.i("MicroMsg.WalletBalanceSaveUI", "realnameGuideFlag =  " + paramString.dAF);
            bool = false;
          }
        }
        paramn = ((com.tencent.mm.plugin.wallet.balance.model.e)paramn).djr;
        af.x(11, paramn, paramInt2);
        if (this.AYu == null)
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
      paramString = this.AYu.field_bindSerial;
      break;
      if ((paramn instanceof ag))
      {
        paramString = (ag)paramn;
        if (!this.AZO)
        {
          fetchData();
          cL();
        }
        this.AZO = false;
        this.AZN = paramString.AZN;
        eoD();
        continue;
        if ((paramn instanceof com.tencent.mm.plugin.wallet.balance.model.e)) {
          af.x(11, "", paramInt2);
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