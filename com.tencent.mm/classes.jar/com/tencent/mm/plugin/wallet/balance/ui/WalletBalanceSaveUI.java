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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet.balance.model.lqt.w;
import com.tencent.mm.plugin.wallet_core.c.ag;
import com.tencent.mm.plugin.wallet_core.c.ak;
import com.tencent.mm.plugin.wallet_core.c.al;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.ui.l;
import com.tencent.mm.plugin.wallet_core.ui.view.c;
import com.tencent.mm.protocal.protobuf.dhn;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.widget.a.g.a;
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
  private com.tencent.mm.plugin.wallet.ui.a ALJ;
  private final int HARDCODE_TENPAY_KEYBOARD_HEIGHT;
  protected boolean HvA;
  private Runnable HvB;
  private ArrayList<Bankcard> Hva;
  protected Bankcard Hvb;
  private String Hvc;
  protected LinearLayout Hve;
  private TextView HwA;
  private al HwB;
  private boolean HwC;
  private LinearLayout Hwy;
  private TextView Hwz;
  protected double jVp;
  public Runnable jVx;
  private ViewGroup nmW;
  protected WalletFormView qAh;
  private int state;
  private HashMap<String, Integer> yNN;
  
  public WalletBalanceSaveUI()
  {
    AppMethodBeat.i(68709);
    this.HARDCODE_TENPAY_KEYBOARD_HEIGHT = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 270);
    this.HwC = false;
    this.state = 0;
    this.HvA = false;
    this.jVx = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(213922);
        if ((WalletBalanceSaveUI.e(WalletBalanceSaveUI.this) == 2) && (WalletBalanceSaveUI.this.isHandleAutoShowNormalStWcKb())) {
          WalletBalanceSaveUI.this.showNormalStWcKb();
        }
        AppMethodBeat.o(213922);
      }
    };
    this.HvB = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(213923);
        WalletBalanceSaveUI.this.showNormalStWcKb();
        AppMethodBeat.o(213923);
      }
    };
    this.yNN = new HashMap();
    AppMethodBeat.o(68709);
  }
  
  private void fNd()
  {
    AppMethodBeat.i(213929);
    if ((Util.getDouble(this.qAh.getText(), 0.0D) <= 0.0D) || (!this.qAh.bql()))
    {
      this.mWcKeyboard.DH(false);
      AppMethodBeat.o(213929);
      return;
    }
    this.mWcKeyboard.DH(true);
    AppMethodBeat.o(213929);
  }
  
  private void fNn()
  {
    AppMethodBeat.i(68719);
    doSceneProgress(new ag(), false);
    AppMethodBeat.o(68719);
  }
  
  private void fNs()
  {
    AppMethodBeat.i(68711);
    if (this.HwB == null)
    {
      this.Hwy.setVisibility(8);
      AppMethodBeat.o(68711);
      return;
    }
    this.Hwy.setVisibility(0);
    this.Hwz.setText(this.HwB.title);
    this.HwA.setText(this.HwB.oqZ);
    this.Hwy.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68693);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceSaveUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        Log.i("MicroMsg.WalletBalanceSaveUI", "click lqt entrance: %s", new Object[] { Boolean.valueOf(WalletBalanceSaveUI.a(WalletBalanceSaveUI.this).HQD) });
        com.tencent.mm.plugin.report.service.h.CyF.a(17084, new Object[] { Integer.valueOf(5) });
        if (WalletBalanceSaveUI.a(WalletBalanceSaveUI.this).HQD)
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
    s.fOg();
    Object localObject = s.fOh();
    this.Hva = ((an)localObject).fRG();
    this.Hvb = ((an)localObject).a(this.Hva, null, false, true);
    int i;
    if ((this.Hvb != null) && (Util.isNullOrNil(this.Hvb.field_forbidWord)))
    {
      this.Hvb = null;
      i = 0;
    }
    for (;;)
    {
      if (i < this.Hva.size())
      {
        if ((this.Hva.get(i) != null) && (Util.isNullOrNil(((Bankcard)this.Hva.get(i)).field_forbidWord))) {
          this.Hvb = ((Bankcard)this.Hva.get(i));
        }
      }
      else
      {
        if ((this.Hvb != null) && (!Util.isNullOrNil(this.Hvb.field_forbidWord))) {
          this.Hvb = null;
        }
        localObject = this.Hva;
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
  
  private void updateView()
  {
    AppMethodBeat.i(68717);
    final ImageView localImageView;
    Object localObject;
    if (this.Hve != null)
    {
      if (this.Hvb == null) {
        break label310;
      }
      localImageView = (ImageView)this.Hve.findViewById(2131297310);
      localObject = "";
      com.tencent.mm.plugin.wallet_core.model.e locale = com.tencent.mm.plugin.wallet_core.d.b.j(this, this.Hvb.field_bankcardType, this.Hvb.fQa());
      if (locale != null) {
        localObject = locale.AAU;
      }
      localImageView.setImageBitmap(null);
      if (!this.Hvb.fQb()) {
        break label214;
      }
      localImageView.setBackgroundResource(2131235574);
      ((TextView)this.Hve.findViewById(2131297236)).setText(getString(2131767467, new Object[] { this.Hvb.field_bankName, this.Hvb.field_bankcardTail }));
      if (Util.isNullOrNil(this.Hvb.field_avail_save_wording)) {
        break label280;
      }
      ((TextView)this.Hve.findViewById(2131302329)).setText(this.Hvb.field_avail_save_wording);
      ((TextView)this.Hve.findViewById(2131302329)).setVisibility(0);
    }
    for (;;)
    {
      ((TextView)this.Hve.findViewById(2131310298)).setText(2131767466);
      AppMethodBeat.o(68717);
      return;
      label214:
      localObject = com.tencent.mm.platformtools.u.a(new c((String)localObject));
      com.tencent.mm.platformtools.u.a(new u.a()
      {
        public final void k(String paramAnonymousString, final Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(213921);
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(213920);
              if ((WalletBalanceSaveUI.this.Hvb != null) && (WalletBalanceSaveUI.9.this.HvT != null) && (WalletBalanceSaveUI.9.this.HvT.getTag() != null) && (WalletBalanceSaveUI.9.this.HvT.getTag().equals(WalletBalanceSaveUI.this.Hvb.field_bindSerial))) {
                WalletBalanceSaveUI.9.this.HvT.setImageBitmap(paramAnonymousBitmap);
              }
              AppMethodBeat.o(213920);
            }
          });
          AppMethodBeat.o(213921);
        }
      });
      if ((localObject == null) || (localObject == null)) {
        break;
      }
      localImageView.setImageBitmap(BitmapUtil.extractThumbNail((Bitmap)localObject, getResources().getDimensionPixelOffset(2131167138), getResources().getDimensionPixelOffset(2131167138), true, false));
      break;
      label280:
      Log.i("MicroMsg.WalletBalanceSaveUI", "hy: wording's missing. use default");
      ((TextView)this.Hve.findViewById(2131302329)).setText("");
      continue;
      label310:
      ((TextView)this.Hve.findViewById(2131297236)).setText(this.Hvc);
      ((TextView)this.Hve.findViewById(2131302329)).setText("");
      ((ImageView)this.Hve.findViewById(2131297310)).setImageBitmap(null);
    }
  }
  
  public final void bO(float paramFloat)
  {
    AppMethodBeat.i(68720);
    if (this.nmW != null)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.nmW.getLayoutParams();
      localLayoutParams.bottomMargin = ((int)paramFloat);
      Log.d("MicroMsg.WalletBalanceSaveUI", "onUpdateWcPayKeyboardHeight() height: %s rootView.height: %s", new Object[] { Float.valueOf(paramFloat), Integer.valueOf(localLayoutParams.height) });
      this.nmW.setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(68720);
  }
  
  protected void fNt()
  {
    AppMethodBeat.i(68718);
    if (this.Hvb != null)
    {
      doSceneProgress(new com.tencent.mm.plugin.wallet.balance.model.e(this.jVp, "CNY", this.Hvb.field_bindSerial, this.Hvb.field_bankcardType));
      AppMethodBeat.o(68718);
      return;
    }
    com.tencent.mm.plugin.wallet_core.model.g localg = com.tencent.mm.plugin.wallet_core.model.g.fQl();
    if (localg.bJw())
    {
      com.tencent.mm.ui.base.h.c(this, localg.ANp, getString(2131755998), true);
      AppMethodBeat.o(68718);
      return;
    }
    doSceneProgress(new com.tencent.mm.plugin.wallet.balance.model.e(this.jVp, "CNY", "", ""));
    AppMethodBeat.o(68718);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131496887;
  }
  
  public void initView()
  {
    AppMethodBeat.i(68715);
    setMMTitle(2131767476);
    this.nmW = ((ViewGroup)findViewById(2131307214));
    this.qAh = ((WalletFormView)findViewById(2131304847));
    this.Hwy = ((LinearLayout)findViewById(2131303958));
    this.Hwz = ((TextView)findViewById(2131303959));
    this.HwA = ((TextView)findViewById(2131303957));
    this.mWcKeyboard = new WcPayKeyboard(this);
    com.tencent.mm.wallet_core.ui.formview.a.f(this.qAh);
    this.qAh.getTitleTv().setText(ah.hhz());
    this.mWcKeyboard.s(this);
    setWPKeyboard(this.qAh.getContentEt(), true, false);
    this.mWcKeyboard.setActionText(getString(2131767450));
    this.qAh.a(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(213924);
        if (paramAnonymousEditable.toString().startsWith(".")) {
          paramAnonymousEditable.insert(0, "0");
        }
        paramAnonymousEditable = paramAnonymousEditable.toString();
        int i = paramAnonymousEditable.indexOf(".");
        int j = paramAnonymousEditable.length();
        if ((i >= 0) && (j - i > 3)) {
          WalletFormView.a(WalletBalanceSaveUI.this.qAh.getContentEt(), paramAnonymousEditable, i + 3, j);
        }
        for (;;)
        {
          WalletBalanceSaveUI.f(WalletBalanceSaveUI.this);
          AppMethodBeat.o(213924);
          return;
          if (i > 10) {
            WalletFormView.a(WalletBalanceSaveUI.this.qAh.getContentEt(), paramAnonymousEditable, 10, i);
          } else if ((i == -1) && (j > 10)) {
            WalletFormView.a(WalletBalanceSaveUI.this.qAh.getContentEt(), paramAnonymousEditable, 10, j);
          }
        }
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    View.OnClickListener local17 = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68708);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceSaveUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        WalletBalanceSaveUI.this.jVp = Util.getDouble(WalletBalanceSaveUI.this.qAh.getText(), 0.0D);
        if ((WalletBalanceSaveUI.this.jVp > 0.0D) && (WalletBalanceSaveUI.this.qAh.bql()))
        {
          WalletBalanceSaveUI.this.hideWcKb();
          WalletBalanceSaveUI.this.fNt();
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceSaveUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(68708);
          return;
          com.tencent.mm.ui.base.u.makeText(WalletBalanceSaveUI.this.getContext(), 2131767474, 0).show();
        }
      }
    };
    this.qAh.getContentEt().setOnEditorActionListener(new WalletBalanceSaveUI.2(this, local17));
    this.Hve = ((LinearLayout)findViewById(2131297235));
    if (this.Hve != null)
    {
      com.tencent.mm.wallet_core.ui.f.G((TextView)this.Hve.findViewById(2131297236));
      this.Hve.setOnClickListener(new WalletBalanceSaveUI.3(this));
    }
    setTenpayKBStateListener(new com.tencent.mm.wallet_core.ui.a()
    {
      public final void onVisibleStateChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(213913);
        if (paramAnonymousBoolean)
        {
          WalletBalanceSaveUI.fNu();
          AppMethodBeat.o(213913);
          return;
        }
        WalletBalanceSaveUI.h(WalletBalanceSaveUI.this).scrollTo(0, 0);
        AppMethodBeat.o(213913);
      }
    });
    AppMethodBeat.o(68715);
  }
  
  public boolean isHandleAutoShowNormalStWcKb()
  {
    AppMethodBeat.i(213928);
    Log.d("MicroMsg.WalletBalanceSaveUI", "isHandleAutoShowNormalStWcKb() mWxKbInterceptState:%s isAutoShowNormalStWcKb:%s", new Object[] { Boolean.valueOf(this.HvA), Boolean.valueOf(this.mWcKeyboard.hgR()) });
    if ((!this.HvA) && (this.mWcKeyboard.hgR()))
    {
      AppMethodBeat.o(213928);
      return true;
    }
    AppMethodBeat.o(213928);
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
    if (!z.aUo()) {
      fNn();
    }
    setActionbarColor(getResources().getColor(2131099697));
    hideActionbarLine();
    fetchData();
    this.Hvc = getString(2131767469);
    initView();
    paramBundle = (String)((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(ar.a.Ofz, "");
    if (!Util.isNullOrNil(paramBundle)) {}
    try
    {
      this.HwB = al.bx(new JSONObject(paramBundle));
      fNs();
      updateView();
      ab.mg(3, 0);
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
    AppMethodBeat.i(213926);
    super.onDestroy();
    MMHandlerThread.removeRunnable(this.jVx);
    MMHandlerThread.removeRunnable(this.HvB);
    AppMethodBeat.o(213926);
  }
  
  public void onDialogDismiss(Dialog paramDialog)
  {
    AppMethodBeat.i(213927);
    Log.i("MicroMsg.WalletBalanceSaveUI", "onDialogDismiss()");
    MMHandlerThread.postToMainThreadDelayed(this.jVx, 300L);
    AppMethodBeat.o(213927);
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
    AppMethodBeat.i(213925);
    super.onPause();
    if (!this.mWcKeyboard.hgQ()) {
      this.state = 3;
    }
    AppMethodBeat.o(213925);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(68712);
    super.onResume();
    if (this.HwC) {
      fNn();
    }
    if ((this.state == 3) && (isHandleAutoShowNormalStWcKb())) {
      MMHandlerThread.postToMainThreadDelayed(this.HvB, 300L);
    }
    this.state = 2;
    fNd();
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
        if ("1".equals(paramString.egd))
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
          if ("2".equals(paramString.egd))
          {
            Log.i("MicroMsg.WalletBalanceSaveUI", "need upload credit");
            bool = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, paramString.ege, paramString.egh, paramString.egf, paramString.egg, isTransparent(), null);
          }
          else
          {
            Log.i("MicroMsg.WalletBalanceSaveUI", "realnameGuideFlag =  " + paramString.egd);
            bool = false;
          }
        }
        paramq = ((com.tencent.mm.plugin.wallet.balance.model.e)paramq).dNQ;
        af.z(11, paramq, paramInt2);
        if (this.Hvb == null)
        {
          paramString = "";
          com.tencent.mm.pluginsdk.wallet.f.b(this, paramString, paramq, "", 11, 1);
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(68710);
      return false;
      paramString = this.Hvb.field_bindSerial;
      break;
      if ((paramq instanceof ag))
      {
        paramString = (ag)paramq;
        if (!this.HwC)
        {
          fetchData();
          updateView();
        }
        this.HwC = false;
        this.HwB = paramString.HwB;
        fNs();
        continue;
        if ((paramq instanceof com.tencent.mm.plugin.wallet.balance.model.e))
        {
          af.z(11, "", paramInt2);
          MMHandlerThread.postToMainThreadDelayed(this.jVx, 300L);
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