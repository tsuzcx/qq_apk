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
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet_core.c.al;
import com.tencent.mm.plugin.wallet_core.c.am;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ao;
import com.tencent.mm.plugin.wallet_core.ui.m;
import com.tencent.mm.plugin.wallet_core.ui.view.c;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.wallet_core.c.aa;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.c.af;
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
  private HashMap<String, Integer> ErL;
  private com.tencent.mm.plugin.wallet.ui.a GEV;
  private final int HARDCODE_TENPAY_KEYBOARD_HEIGHT;
  private ArrayList<Bankcard> OmN;
  protected Bankcard OmO;
  private String OmP;
  protected LinearLayout OmR;
  protected boolean Onn;
  private Runnable Ono;
  private LinearLayout Ool;
  private TextView Oom;
  private TextView Oon;
  private am Ooo;
  private boolean Oop;
  protected double mMC;
  public Runnable mMK;
  private ViewGroup qoE;
  private int state;
  protected WalletFormView tZh;
  
  public WalletBalanceSaveUI()
  {
    AppMethodBeat.i(68709);
    this.HARDCODE_TENPAY_KEYBOARD_HEIGHT = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 270);
    this.Oop = false;
    this.state = 0;
    this.Onn = false;
    this.mMK = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(274379);
        if ((WalletBalanceSaveUI.e(WalletBalanceSaveUI.this) == 2) && (WalletBalanceSaveUI.this.isHandleAutoShowNormalStWcKb())) {
          WalletBalanceSaveUI.this.showNormalStWcKb();
        }
        AppMethodBeat.o(274379);
      }
    };
    this.Ono = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(250252);
        WalletBalanceSaveUI.this.showNormalStWcKb();
        AppMethodBeat.o(250252);
      }
    };
    this.ErL = new HashMap();
    AppMethodBeat.o(68709);
  }
  
  private void fetchData()
  {
    AppMethodBeat.i(68713);
    s.gGL();
    Object localObject = s.gGM();
    this.OmN = ((ao)localObject).gKm();
    this.OmO = ((ao)localObject).a(this.OmN, null, false, true);
    int i;
    if ((this.OmO != null) && (Util.isNullOrNil(this.OmO.field_forbidWord)))
    {
      this.OmO = null;
      i = 0;
    }
    for (;;)
    {
      if (i < this.OmN.size())
      {
        if ((this.OmN.get(i) != null) && (Util.isNullOrNil(((Bankcard)this.OmN.get(i)).field_forbidWord))) {
          this.OmO = ((Bankcard)this.OmN.get(i));
        }
      }
      else
      {
        if ((this.OmO != null) && (!Util.isNullOrNil(this.OmO.field_forbidWord))) {
          this.OmO = null;
        }
        localObject = this.OmN;
        if (localObject == null) {
          break;
        }
        i = 0;
        while (i < ((ArrayList)localObject).size())
        {
          Log.v("MicroMsg.WalletBalanceSaveUI", "pos %s word %s", new Object[] { Integer.valueOf(i), ((Bankcard)((ArrayList)localObject).get(i)).field_forbidWord });
          i += 1;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(68713);
  }
  
  private void gFH()
  {
    AppMethodBeat.i(277935);
    if ((Util.getDouble(this.tZh.getText(), 0.0D) <= 0.0D) || (!this.tZh.bAz()))
    {
      this.mWcKeyboard.Ih(false);
      AppMethodBeat.o(277935);
      return;
    }
    this.mWcKeyboard.Ih(true);
    AppMethodBeat.o(277935);
  }
  
  private void gFR()
  {
    AppMethodBeat.i(68719);
    doSceneProgress(new com.tencent.mm.plugin.wallet_core.c.ah(), false);
    AppMethodBeat.o(68719);
  }
  
  private void gFW()
  {
    AppMethodBeat.i(68711);
    if (this.Ooo == null)
    {
      this.Ool.setVisibility(8);
      AppMethodBeat.o(68711);
      return;
    }
    this.Ool.setVisibility(0);
    this.Oom.setText(this.Ooo.title);
    this.Oon.setText(this.Ooo.rsw);
    this.Ool.setOnClickListener(new WalletBalanceSaveUI.1(this));
    AppMethodBeat.o(68711);
  }
  
  private void updateView()
  {
    AppMethodBeat.i(68717);
    final ImageView localImageView;
    Object localObject;
    if (this.OmR != null)
    {
      if (this.OmO == null) {
        break label310;
      }
      localImageView = (ImageView)this.OmR.findViewById(a.f.bankcard_logo_iv);
      localObject = "";
      com.tencent.mm.plugin.wallet_core.model.e locale = com.tencent.mm.plugin.wallet_core.d.b.j(this, this.OmO.field_bankcardType, this.OmO.gIG());
      if (locale != null) {
        localObject = locale.GtW;
      }
      localImageView.setImageBitmap(null);
      if (!this.OmO.gIH()) {
        break label214;
      }
      localImageView.setBackgroundResource(a.e.wallet_balance_manager_logo_small);
      ((TextView)this.OmR.findViewById(a.f.balance_bankcard_tv)).setText(getString(a.i.wallet_balance_save_bankcard_tips, new Object[] { this.OmO.field_bankName, this.OmO.field_bankcardTail }));
      if (Util.isNullOrNil(this.OmO.field_avail_save_wording)) {
        break label280;
      }
      ((TextView)this.OmR.findViewById(a.f.hint_1)).setText(this.OmO.field_avail_save_wording);
      ((TextView)this.OmR.findViewById(a.f.hint_1)).setVisibility(0);
    }
    for (;;)
    {
      ((TextView)this.OmR.findViewById(a.f.wallet_title)).setText(a.i.wallet_balance_save_bankcard_default_tips);
      AppMethodBeat.o(68717);
      return;
      label214:
      localObject = u.a(new c((String)localObject));
      u.a(new u.a()
      {
        public final void k(String paramAnonymousString, final Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(186977);
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(273061);
              if ((WalletBalanceSaveUI.this.OmO != null) && (WalletBalanceSaveUI.9.this.OnG != null) && (WalletBalanceSaveUI.9.this.OnG.getTag() != null) && (WalletBalanceSaveUI.9.this.OnG.getTag().equals(WalletBalanceSaveUI.this.OmO.field_bindSerial))) {
                WalletBalanceSaveUI.9.this.OnG.setImageBitmap(paramAnonymousBitmap);
              }
              AppMethodBeat.o(273061);
            }
          });
          AppMethodBeat.o(186977);
        }
      });
      if ((localObject == null) || (localObject == null)) {
        break;
      }
      localImageView.setImageBitmap(BitmapUtil.extractThumbNail((Bitmap)localObject, getResources().getDimensionPixelOffset(a.d.wallet_offline_bank_logo_width), getResources().getDimensionPixelOffset(a.d.wallet_offline_bank_logo_width), true, false));
      break;
      label280:
      Log.i("MicroMsg.WalletBalanceSaveUI", "hy: wording's missing. use default");
      ((TextView)this.OmR.findViewById(a.f.hint_1)).setText("");
      continue;
      label310:
      ((TextView)this.OmR.findViewById(a.f.balance_bankcard_tv)).setText(this.OmP);
      ((TextView)this.OmR.findViewById(a.f.hint_1)).setText("");
      ((ImageView)this.OmR.findViewById(a.f.bankcard_logo_iv)).setImageBitmap(null);
    }
  }
  
  public final void bU(float paramFloat)
  {
    AppMethodBeat.i(68720);
    if (this.qoE != null)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.qoE.getLayoutParams();
      localLayoutParams.bottomMargin = ((int)paramFloat);
      Log.d("MicroMsg.WalletBalanceSaveUI", "onUpdateWcPayKeyboardHeight() height: %s rootView.height: %s", new Object[] { Float.valueOf(paramFloat), Integer.valueOf(localLayoutParams.height) });
      this.qoE.setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(68720);
  }
  
  protected void gFX()
  {
    AppMethodBeat.i(68718);
    if (this.OmO != null)
    {
      doSceneProgress(new com.tencent.mm.plugin.wallet.balance.model.e(this.mMC, "CNY", this.OmO.field_bindSerial, this.OmO.field_bankcardType));
      AppMethodBeat.o(68718);
      return;
    }
    com.tencent.mm.plugin.wallet_core.model.g localg = com.tencent.mm.plugin.wallet_core.model.g.gIR();
    if (localg.bVd())
    {
      com.tencent.mm.ui.base.h.c(this, localg.GGD, getString(a.i.app_tip), true);
      AppMethodBeat.o(68718);
      return;
    }
    doSceneProgress(new com.tencent.mm.plugin.wallet.balance.model.e(this.mMC, "CNY", "", ""));
    AppMethodBeat.o(68718);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return a.g.wallet_balance_save_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(68715);
    setMMTitle(a.i.wallet_balance_save_title);
    this.qoE = ((ViewGroup)findViewById(a.f.save_root_view));
    this.tZh = ((WalletFormView)findViewById(a.f.money_ev));
    this.Ool = ((LinearLayout)findViewById(a.f.lqt_entrance_layout));
    this.Oom = ((TextView)findViewById(a.f.lqt_entrance_title_tv));
    this.Oon = ((TextView)findViewById(a.f.lqt_entrance_desc_tv));
    this.mWcKeyboard = new WcPayKeyboard(this);
    com.tencent.mm.wallet_core.ui.formview.a.f(this.tZh);
    this.tZh.getTitleTv().setText(com.tencent.mm.wallet_core.c.ah.ijb());
    this.mWcKeyboard.t(this);
    setWPKeyboard(this.tZh.getContentEt(), true, false);
    this.mWcKeyboard.setActionText(getString(a.i.wallet_balance_manager_save));
    this.tZh.a(new WalletBalanceSaveUI.16(this));
    final WalletBalanceSaveUI.17 local17 = new WalletBalanceSaveUI.17(this);
    this.tZh.getContentEt().setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(275589);
        if ((paramAnonymousKeyEvent != null) && (paramAnonymousKeyEvent.getAction() == 1) && (paramAnonymousKeyEvent.getKeyCode() == 66)) {
          local17.onClick(null);
        }
        AppMethodBeat.o(275589);
        return true;
      }
    });
    this.OmR = ((LinearLayout)findViewById(a.f.balance_bankcard_layout));
    if (this.OmR != null)
    {
      com.tencent.mm.wallet_core.ui.g.N((TextView)this.OmR.findViewById(a.f.balance_bankcard_tv));
      this.OmR.setOnClickListener(new WalletBalanceSaveUI.3(this));
    }
    setTenpayKBStateListener(new com.tencent.mm.wallet_core.ui.a()
    {
      public final void onVisibleStateChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(196386);
        if (paramAnonymousBoolean)
        {
          WalletBalanceSaveUI.gFY();
          AppMethodBeat.o(196386);
          return;
        }
        WalletBalanceSaveUI.h(WalletBalanceSaveUI.this).scrollTo(0, 0);
        AppMethodBeat.o(196386);
      }
    });
    AppMethodBeat.o(68715);
  }
  
  public boolean isHandleAutoShowNormalStWcKb()
  {
    AppMethodBeat.i(277928);
    Log.d("MicroMsg.WalletBalanceSaveUI", "isHandleAutoShowNormalStWcKb() mWxKbInterceptState:%s isAutoShowNormalStWcKb:%s", new Object[] { Boolean.valueOf(this.Onn), Boolean.valueOf(this.mWcKeyboard.iit()) });
    if ((!this.Onn) && (this.mWcKeyboard.iit()))
    {
      AppMethodBeat.o(277928);
      return true;
    }
    AppMethodBeat.o(277928);
    return false;
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
    if (!z.bdq()) {
      gFR();
    }
    setActionbarColor(getResources().getColor(a.c.BW_BG_95));
    hideActionbarLine();
    fetchData();
    this.OmP = getString(a.i.wallet_balance_save_bind_new_card_to_save);
    initView();
    paramBundle = (String)((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(ar.a.VtL, "");
    if (!Util.isNullOrNil(paramBundle)) {}
    try
    {
      this.Ooo = am.bI(new JSONObject(paramBundle));
      gFW();
      updateView();
      ab.ny(3, 0);
      AppMethodBeat.o(68714);
      return;
    }
    catch (JSONException paramBundle)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.WalletBalanceSaveUI", paramBundle, "", new Object[0]);
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(277925);
    super.onDestroy();
    MMHandlerThread.removeRunnable(this.mMK);
    MMHandlerThread.removeRunnable(this.Ono);
    AppMethodBeat.o(277925);
  }
  
  public void onDialogDismiss(Dialog paramDialog)
  {
    AppMethodBeat.i(277927);
    Log.i("MicroMsg.WalletBalanceSaveUI", "onDialogDismiss()");
    MMHandlerThread.postToMainThreadDelayed(this.mMK, 300L);
    AppMethodBeat.o(277927);
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
  
  public void onPause()
  {
    AppMethodBeat.i(277923);
    super.onPause();
    if (!this.mWcKeyboard.iis()) {
      this.state = 3;
    }
    AppMethodBeat.o(277923);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(68712);
    super.onResume();
    if (this.Oop) {
      gFR();
    }
    if ((this.state == 3) && (isHandleAutoShowNormalStWcKb())) {
      MMHandlerThread.postToMainThreadDelayed(this.Ono, 300L);
    }
    this.state = 2;
    gFH();
    AppMethodBeat.o(68712);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(68710);
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if ((paramq instanceof com.tencent.mm.plugin.wallet.balance.model.e))
      {
        paramString = (com.tencent.mm.plugin.wallet.balance.model.e)paramq;
        boolean bool;
        if ("1".equals(paramString.gat))
        {
          Log.i("MicroMsg.WalletBalanceSaveUI", "need realname verify");
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
          if ("2".equals(paramString.gat))
          {
            Log.i("MicroMsg.WalletBalanceSaveUI", "need upload credit");
            bool = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, paramString.gau, paramString.gax, paramString.gav, paramString.gaw, isTransparent(), null);
          }
          else
          {
            Log.i("MicroMsg.WalletBalanceSaveUI", "realnameGuideFlag =  " + paramString.gat);
            bool = false;
          }
        }
        paramq = ((com.tencent.mm.plugin.wallet.balance.model.e)paramq).fHb;
        af.B(11, paramq, paramInt2);
        if (this.OmO == null)
        {
          paramString = "";
          f.b(this, paramString, paramq, "", 11, 1);
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(68710);
      return false;
      paramString = this.OmO.field_bindSerial;
      break;
      if ((paramq instanceof com.tencent.mm.plugin.wallet_core.c.ah))
      {
        paramString = (com.tencent.mm.plugin.wallet_core.c.ah)paramq;
        if (!this.Oop)
        {
          fetchData();
          updateView();
        }
        this.Oop = false;
        this.Ooo = paramString.Ooo;
        gFW();
        continue;
        if ((paramq instanceof com.tencent.mm.plugin.wallet.balance.model.e))
        {
          af.B(11, "", paramInt2);
          MMHandlerThread.postToMainThreadDelayed(this.mMK, 300L);
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