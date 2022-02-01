package com.tencent.mm.plugin.wallet.balance.ui;

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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.acx;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.platformtools.r.a;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.wallet.balance.model.lqt.y;
import com.tencent.mm.plugin.wallet_core.c.ah;
import com.tencent.mm.plugin.wallet_core.c.al;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.g;
import com.tencent.mm.plugin.wallet_core.ui.n;
import com.tencent.mm.plugin.wallet_core.ui.view.c;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.protocal.protobuf.ekd;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard.a;
import com.tencent.mm.wallet_core.model.ab;
import com.tencent.mm.wallet_core.model.ac;
import com.tencent.mm.wallet_core.model.ag;
import com.tencent.mm.wallet_core.model.ai;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.WcPayBannerView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.i;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(2)
public class WalletBalanceSaveUI
  extends WalletBaseUI
  implements WcPayKeyboard.a
{
  private final int HARDCODE_TENPAY_KEYBOARD_HEIGHT;
  private HashMap<String, Integer> Kkr;
  private com.tencent.mm.plugin.wallet.ui.a MBw;
  private ArrayList<Bankcard> Vbt;
  protected Bankcard Vbu;
  private String Vbv;
  protected LinearLayout Vbx;
  protected boolean Vcb;
  private Runnable Vcc;
  private LinearLayout Vdb;
  private TextView Vdc;
  private TextView Vdd;
  private com.tencent.mm.plugin.wallet_core.c.am Vde;
  private boolean Vdf;
  public boolean Vdg;
  protected double pJk;
  public Runnable pJs;
  private WcPayBannerView pLM;
  private String qYC;
  private int state;
  private ViewGroup tth;
  protected WalletFormView xcz;
  
  public WalletBalanceSaveUI()
  {
    AppMethodBeat.i(68709);
    this.HARDCODE_TENPAY_KEYBOARD_HEIGHT = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 270);
    this.Vdf = false;
    this.Vdg = false;
    this.state = 0;
    this.Vcb = false;
    this.pJs = new WalletBalanceSaveUI.15(this);
    this.Vcc = new WalletBalanceSaveUI.16(this);
    this.Kkr = new HashMap();
    AppMethodBeat.o(68709);
  }
  
  private void a(double paramDouble, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(316346);
    Bundle localBundle = new Bundle();
    localBundle.putInt("payScene", 11);
    localBundle.putString("totalFee", i.c(String.valueOf(paramDouble), "100", 0, RoundingMode.HALF_UP).toString());
    localBundle.putString("feeType", paramString1);
    localBundle.putString("bankType", paramString3);
    localBundle.putString("bindSerial", paramString2);
    localBundle.putString("reportSessionId", this.qYC);
    Log.i("MicroMsg.WalletBalanceSaveUI", "startWalletBalanceSaveUseCase totalFee：%s reportSessionId %s", new Object[] { i.c(String.valueOf(paramDouble), "100", 0, RoundingMode.HALF_UP).toString(), this.qYC });
    this.Vdg = true;
    ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.pluginsdk.wallet.a.class)).startWalletBalanceSaveUseCase(this, localBundle);
    AppMethodBeat.o(316346);
  }
  
  private void fetchData()
  {
    AppMethodBeat.i(68713);
    com.tencent.mm.plugin.wallet.model.p.ifO();
    Object localObject = com.tencent.mm.plugin.wallet.model.p.ifP();
    this.Vbt = ((com.tencent.mm.plugin.wallet_core.model.am)localObject).ijD();
    this.Vbu = ((com.tencent.mm.plugin.wallet_core.model.am)localObject).a(this.Vbt, null, false, true);
    int i;
    if ((this.Vbu != null) && (Util.isNullOrNil(this.Vbu.field_forbidWord)))
    {
      this.Vbu = null;
      i = 0;
    }
    for (;;)
    {
      if (i < this.Vbt.size())
      {
        if ((this.Vbt.get(i) != null) && (Util.isNullOrNil(((Bankcard)this.Vbt.get(i)).field_forbidWord))) {
          this.Vbu = ((Bankcard)this.Vbt.get(i));
        }
      }
      else
      {
        if ((this.Vbu != null) && (!Util.isNullOrNil(this.Vbu.field_forbidWord))) {
          this.Vbu = null;
        }
        localObject = this.Vbt;
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
  
  private static boolean gLY()
  {
    AppMethodBeat.i(316344);
    com.tencent.mm.wallet_core.b.jNX();
    boolean bool1 = com.tencent.mm.wallet_core.b.b(c.a.yRc, true);
    com.tencent.mm.wallet_core.b.jNX();
    boolean bool2 = com.tencent.mm.wallet_core.b.b(c.a.yWS, false);
    Log.i("MicroMsg.WalletBalanceSaveUI", "wallet balance save isOpenKinda isKindaEnable: %s，isKindaWalletBalanceSave: %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    if ((bool1) && (bool2))
    {
      AppMethodBeat.o(316344);
      return true;
    }
    AppMethodBeat.o(316344);
    return false;
  }
  
  private void ieF()
  {
    AppMethodBeat.i(316336);
    if ((Util.getDouble(this.xcz.getText(), 0.0D) <= 0.0D) || (!this.xcz.bZp()))
    {
      this.mWcKeyboard.Oi(false);
      AppMethodBeat.o(316336);
      return;
    }
    this.mWcKeyboard.Oi(true);
    AppMethodBeat.o(316336);
  }
  
  private void ieQ()
  {
    AppMethodBeat.i(68719);
    doSceneProgress(new ah(), false);
    AppMethodBeat.o(68719);
  }
  
  private void ieV()
  {
    AppMethodBeat.i(68711);
    if (this.Vde == null)
    {
      this.Vdb.setVisibility(8);
      AppMethodBeat.o(68711);
      return;
    }
    this.Vdb.setVisibility(0);
    this.Vdc.setText(this.Vde.title);
    this.Vdd.setText(this.Vde.uCW);
    this.Vdb.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
    {
      public final void dr(View paramAnonymousView)
      {
        AppMethodBeat.i(316341);
        Log.i("MicroMsg.WalletBalanceSaveUI", "click lqt entrance: %s", new Object[] { Boolean.valueOf(WalletBalanceSaveUI.a(WalletBalanceSaveUI.this).Vyx) });
        com.tencent.mm.plugin.report.service.h.OAn.b(17084, new Object[] { Integer.valueOf(5) });
        if (WalletBalanceSaveUI.a(WalletBalanceSaveUI.this).Vyx)
        {
          WalletBalanceSaveUI.this.hideWcKb();
          WalletBalanceSaveUI.b(WalletBalanceSaveUI.this);
          AppMethodBeat.o(316341);
          return;
        }
        WalletBalanceSaveUI.c(WalletBalanceSaveUI.this);
        AppMethodBeat.o(316341);
      }
    });
    AppMethodBeat.o(68711);
  }
  
  private void updateView()
  {
    AppMethodBeat.i(68717);
    final ImageView localImageView;
    Object localObject;
    if (this.Vbx != null)
    {
      if (this.Vbu == null) {
        break label310;
      }
      localImageView = (ImageView)this.Vbx.findViewById(a.f.bankcard_logo_iv);
      localObject = "";
      com.tencent.mm.plugin.wallet_core.model.e locale = com.tencent.mm.plugin.wallet_core.d.b.j(this, this.Vbu.field_bankcardType, this.Vbu.ihU());
      if (locale != null) {
        localObject = locale.MpW;
      }
      localImageView.setImageBitmap(null);
      if (!this.Vbu.ihV()) {
        break label214;
      }
      localImageView.setBackgroundResource(a.e.wallet_balance_manager_logo_small);
      ((TextView)this.Vbx.findViewById(a.f.balance_bankcard_tv)).setText(getString(a.i.wallet_balance_save_bankcard_tips, new Object[] { this.Vbu.field_bankName, this.Vbu.field_bankcardTail }));
      if (Util.isNullOrNil(this.Vbu.field_avail_save_wording)) {
        break label280;
      }
      ((TextView)this.Vbx.findViewById(a.f.hint_1)).setText(this.Vbu.field_avail_save_wording);
      ((TextView)this.Vbx.findViewById(a.f.hint_1)).setVisibility(0);
    }
    for (;;)
    {
      ((TextView)this.Vbx.findViewById(a.f.wallet_title)).setText(a.i.wallet_balance_save_bankcard_default_tips);
      AppMethodBeat.o(68717);
      return;
      label214:
      localObject = r.a(new c((String)localObject));
      r.a(new r.a()
      {
        public final void k(String paramAnonymousString, final Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(316348);
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(316360);
              if ((WalletBalanceSaveUI.this.Vbu != null) && (WalletBalanceSaveUI.10.this.Vci != null) && (WalletBalanceSaveUI.10.this.Vci.getTag() != null) && (WalletBalanceSaveUI.10.this.Vci.getTag().equals(WalletBalanceSaveUI.this.Vbu.field_bindSerial))) {
                WalletBalanceSaveUI.10.this.Vci.setImageBitmap(paramAnonymousBitmap);
              }
              AppMethodBeat.o(316360);
            }
          });
          AppMethodBeat.o(316348);
        }
      });
      if ((localObject == null) || (localObject == null)) {
        break;
      }
      localImageView.setImageBitmap(BitmapUtil.extractThumbNail((Bitmap)localObject, getResources().getDimensionPixelOffset(a.d.wallet_offline_bank_logo_width), getResources().getDimensionPixelOffset(a.d.wallet_offline_bank_logo_width), true, false));
      break;
      label280:
      Log.i("MicroMsg.WalletBalanceSaveUI", "hy: wording's missing. use default");
      ((TextView)this.Vbx.findViewById(a.f.hint_1)).setText("");
      continue;
      label310:
      ((TextView)this.Vbx.findViewById(a.f.balance_bankcard_tv)).setText(this.Vbv);
      ((TextView)this.Vbx.findViewById(a.f.hint_1)).setText("");
      ((ImageView)this.Vbx.findViewById(a.f.bankcard_logo_iv)).setImageBitmap(null);
    }
  }
  
  public final void cY(float paramFloat)
  {
    AppMethodBeat.i(68720);
    if (this.tth != null)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.tth.getLayoutParams();
      localLayoutParams.bottomMargin = ((int)paramFloat);
      Log.d("MicroMsg.WalletBalanceSaveUI", "onUpdateWcPayKeyboardHeight() height: %s rootView.height: %s", new Object[] { Float.valueOf(paramFloat), Integer.valueOf(localLayoutParams.height) });
      this.tth.setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(68720);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return a.g.wallet_balance_save_ui;
  }
  
  protected void ieW()
  {
    AppMethodBeat.i(68718);
    if (this.Vbu != null)
    {
      if (gLY())
      {
        a(this.pJk, "CNY", this.Vbu.field_bindSerial, this.Vbu.field_bankcardType);
        AppMethodBeat.o(68718);
        return;
      }
      doSceneProgress(new com.tencent.mm.plugin.wallet.balance.model.e(this.pJk, "CNY", this.Vbu.field_bindSerial, this.Vbu.field_bankcardType));
      AppMethodBeat.o(68718);
      return;
    }
    g localg = g.iif();
    if (localg.cvt())
    {
      com.tencent.mm.ui.base.k.c(this, localg.MDu, getString(a.i.app_tip), true);
      AppMethodBeat.o(68718);
      return;
    }
    if (gLY())
    {
      a(this.pJk, "CNY", "", "");
      AppMethodBeat.o(68718);
      return;
    }
    doSceneProgress(new com.tencent.mm.plugin.wallet.balance.model.e(this.pJk, "CNY", "", ""));
    AppMethodBeat.o(68718);
  }
  
  public void initView()
  {
    AppMethodBeat.i(68715);
    setMMTitle(a.i.wallet_balance_save_title);
    this.tth = ((ViewGroup)findViewById(a.f.save_root_view));
    this.xcz = ((WalletFormView)findViewById(a.f.money_ev));
    this.Vdb = ((LinearLayout)findViewById(a.f.lqt_entrance_layout));
    this.Vdc = ((TextView)findViewById(a.f.lqt_entrance_title_tv));
    this.Vdd = ((TextView)findViewById(a.f.lqt_entrance_desc_tv));
    this.mWcKeyboard = new WcPayKeyboard(this);
    this.pLM = ((WcPayBannerView)findViewById(a.f.wc_pay_banner_layout));
    this.pLM.jPz();
    com.tencent.mm.wallet_core.ui.formview.a.f(this.xcz);
    this.xcz.getTitleTv().setText(ai.jOX());
    this.mWcKeyboard.y(this);
    setWPKeyboard(this.xcz.getContentEt(), true, false);
    this.mWcKeyboard.setActionText(getString(a.i.wallet_balance_manager_save));
    Object localObject = new acx();
    ((acx)localObject).igk.scene = "19";
    ((acx)localObject).callback = new WalletBalanceSaveUI..ExternalSyntheticLambda0(this, (acx)localObject);
    ((acx)localObject).publish();
    this.xcz.a(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(316331);
        if (paramAnonymousEditable.toString().startsWith(".")) {
          paramAnonymousEditable.insert(0, "0");
        }
        paramAnonymousEditable = paramAnonymousEditable.toString();
        int i = paramAnonymousEditable.indexOf(".");
        int j = paramAnonymousEditable.length();
        if ((i >= 0) && (j - i > 3)) {
          WalletFormView.a(WalletBalanceSaveUI.this.xcz.getContentEt(), paramAnonymousEditable, i + 3, j);
        }
        for (;;)
        {
          WalletBalanceSaveUI.f(WalletBalanceSaveUI.this);
          AppMethodBeat.o(316331);
          return;
          if (i > 10) {
            WalletFormView.a(WalletBalanceSaveUI.this.xcz.getContentEt(), paramAnonymousEditable, 10, i);
          } else if ((i == -1) && (j > 10)) {
            WalletFormView.a(WalletBalanceSaveUI.this.xcz.getContentEt(), paramAnonymousEditable, 10, j);
          }
        }
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    localObject = new com.tencent.mm.wallet_core.ui.k()
    {
      public final void dr(View paramAnonymousView)
      {
        AppMethodBeat.i(316328);
        WalletBalanceSaveUI.this.pJk = Util.getDouble(WalletBalanceSaveUI.this.xcz.getText(), 0.0D);
        if ((WalletBalanceSaveUI.this.pJk > 0.0D) && (WalletBalanceSaveUI.this.xcz.bZp()))
        {
          WalletBalanceSaveUI.this.hideWcKb();
          WalletBalanceSaveUI.this.ieW();
          AppMethodBeat.o(316328);
          return;
        }
        aa.makeText(WalletBalanceSaveUI.this.getContext(), a.i.wallet_balance_save_input_invalid, 0).show();
        AppMethodBeat.o(316328);
      }
    };
    this.xcz.getContentEt().setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(316347);
        if ((paramAnonymousKeyEvent != null) && (paramAnonymousKeyEvent.getAction() == 1) && (paramAnonymousKeyEvent.getKeyCode() == 66)) {
          this.pJE.onClick(null);
        }
        AppMethodBeat.o(316347);
        return true;
      }
    });
    this.Vbx = ((LinearLayout)findViewById(a.f.balance_bankcard_layout));
    if (this.Vbx != null)
    {
      i.Q((TextView)this.Vbx.findViewById(a.f.balance_bankcard_tv));
      this.Vbx.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
      {
        public final void dr(View paramAnonymousView)
        {
          AppMethodBeat.i(316345);
          WalletBalanceSaveUI.g(WalletBalanceSaveUI.this);
          AppMethodBeat.o(316345);
        }
      });
    }
    setTenpayKBStateListener(new com.tencent.mm.wallet_core.ui.a()
    {
      public final void onVisibleStateChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(316343);
        if (paramAnonymousBoolean)
        {
          WalletBalanceSaveUI.ieX();
          AppMethodBeat.o(316343);
          return;
        }
        WalletBalanceSaveUI.h(WalletBalanceSaveUI.this).scrollTo(0, 0);
        AppMethodBeat.o(316343);
      }
    });
    AppMethodBeat.o(68715);
  }
  
  public boolean isHandleAutoShowNormalStWcKb()
  {
    AppMethodBeat.i(316404);
    Log.d("MicroMsg.WalletBalanceSaveUI", "isHandleAutoShowNormalStWcKb() mWxKbInterceptState:%s isAutoShowNormalStWcKb:%s", new Object[] { Boolean.valueOf(this.Vcb), Boolean.valueOf(this.mWcKeyboard.jOo()) });
    if ((!this.Vcb) && (this.mWcKeyboard.jOo()))
    {
      AppMethodBeat.o(316404);
      return true;
    }
    AppMethodBeat.o(316404);
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
    this.qYC = UUID.randomUUID().toString();
    if (!z.bBi()) {
      ieQ();
    }
    setActionbarColor(getResources().getColor(a.c.BW_BG_95));
    hideActionbarLine();
    fetchData();
    this.Vbv = getString(a.i.wallet_balance_save_bind_new_card_to_save);
    initView();
    paramBundle = (String)((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(at.a.acVq, "");
    if (!Util.isNullOrNil(paramBundle)) {}
    try
    {
      this.Vde = com.tencent.mm.plugin.wallet_core.c.am.cd(new JSONObject(paramBundle));
      ieV();
      updateView();
      ac.pu(3, 0);
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
    AppMethodBeat.i(316401);
    super.onDestroy();
    MMHandlerThread.removeRunnable(this.pJs);
    MMHandlerThread.removeRunnable(this.Vcc);
    AppMethodBeat.o(316401);
  }
  
  public void onDialogDismiss(Dialog paramDialog)
  {
    AppMethodBeat.i(316403);
    Log.i("MicroMsg.WalletBalanceSaveUI", "onDialogDismiss()");
    MMHandlerThread.postToMainThreadDelayed(this.pJs, 300L);
    AppMethodBeat.o(316403);
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
    AppMethodBeat.i(316400);
    super.onPause();
    if (!this.mWcKeyboard.jOn()) {
      this.state = 3;
    }
    AppMethodBeat.o(316400);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(68712);
    super.onResume();
    if (this.Vdf) {
      ieQ();
    }
    if ((this.state == 3) && (isHandleAutoShowNormalStWcKb()) && (!this.Vdg)) {
      MMHandlerThread.postToMainThreadDelayed(this.Vcc, 300L);
    }
    this.state = 2;
    ieF();
    AppMethodBeat.o(68712);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(68710);
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if ((paramp instanceof com.tencent.mm.plugin.wallet.balance.model.e))
      {
        paramString = (com.tencent.mm.plugin.wallet.balance.model.e)paramp;
        boolean bool;
        if ("1".equals(paramString.igC))
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
          if ("2".equals(paramString.igC))
          {
            Log.i("MicroMsg.WalletBalanceSaveUI", "need upload credit");
            bool = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, paramString.igD, paramString.igG, paramString.igE, paramString.igF, isTransparent(), null);
          }
          else
          {
            Log.i("MicroMsg.WalletBalanceSaveUI", "realnameGuideFlag =  " + paramString.igC);
            bool = false;
          }
        }
        paramp = ((com.tencent.mm.plugin.wallet.balance.model.e)paramp).hMy;
        ag.G(11, paramp, paramInt2);
        if (this.Vbu == null)
        {
          paramString = "";
          f.b(this, paramString, paramp, "", 11, 1);
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(68710);
      return false;
      paramString = this.Vbu.field_bindSerial;
      break;
      if ((paramp instanceof ah))
      {
        paramString = (ah)paramp;
        if (!this.Vdf)
        {
          fetchData();
          updateView();
        }
        this.Vdf = false;
        this.Vde = paramString.Vde;
        ieV();
        continue;
        if ((paramp instanceof com.tencent.mm.plugin.wallet.balance.model.e))
        {
          ag.G(11, "", paramInt2);
          MMHandlerThread.postToMainThreadDelayed(this.pJs, 300L);
        }
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(316410);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(com.tencent.mm.plugin.wallet.a.a.class);
    AppMethodBeat.o(316410);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceSaveUI
 * JD-Core Version:    0.7.0.1
 */