package com.tencent.mm.plugin.walletlock.fingerprint.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.ada;
import com.tencent.mm.autogen.a.ada.a;
import com.tencent.mm.autogen.mmdata.rpt.rn;
import com.tencent.mm.plugin.walletlock.a.a;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.plugin.walletlock.a.d;
import com.tencent.mm.plugin.walletlock.a.e;
import com.tencent.mm.plugin.walletlock.a.g;
import com.tencent.mm.plugin.walletlock.fingerprint.a.d;
import com.tencent.mm.plugin.walletlock.fingerprint.a.d.a;
import com.tencent.mm.plugin.walletlock.fingerprint.a.h.1;
import com.tencent.mm.plugin.walletlock.fingerprint.a.h.2;
import com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.a;
import com.tencent.soter.a.g.b.a;
import com.tencent.soter.core.c.j;
import java.lang.ref.WeakReference;
import java.util.HashSet;

public class FingerprintWalletLockUI
  extends MMActivity
  implements com.tencent.mm.plugin.walletlock.ui.a
{
  private int HgB = 0;
  private boolean Law = true;
  private boolean WfR = false;
  private TextView WfX;
  private TextView WfY;
  private TextView WfZ;
  private Animation Wga;
  private String Wgb;
  private String Wgc;
  private d Wgd;
  private com.tencent.mm.plugin.walletlock.fingerprint.a.h Wge;
  private com.tencent.mm.plugin.walletlock.model.b Wgf;
  private String Wgg = "-1";
  private int Wgh = -1;
  private int Wgi = -1;
  private String eb;
  private boolean isCancelled = false;
  private String mToken;
  private TextView ngm;
  private String qgt = null;
  private e skS = null;
  private ProgressDialog wQT = null;
  
  private void U(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(266862);
    Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo finish with result, resultCode: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    release();
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("key_err_code", paramInt2);
    ((Intent)localObject).putExtra("key_err_msg", paramString);
    setResult(paramInt1, (Intent)localObject);
    finish();
    if ((paramInt2 == 4) || (paramInt2 == 0))
    {
      paramString = new ada();
      localObject = paramString.igZ;
      if (paramInt2 != 4) {
        break label131;
      }
    }
    label131:
    for (paramInt1 = 5;; paramInt1 = 6)
    {
      ((ada.a)localObject).ihb = paramInt1;
      paramString.igZ.activity = this;
      paramString.publish();
      AppMethodBeat.o(266862);
      return;
    }
  }
  
  private void aDM()
  {
    AppMethodBeat.i(129728);
    bQa();
    if ((this.skS != null) && (this.skS.isShowing())) {
      this.skS.dismiss();
    }
    AppMethodBeat.o(129728);
  }
  
  private void afy(String paramString)
  {
    AppMethodBeat.i(129735);
    int i = (int)(System.currentTimeMillis() / 1000L);
    if (i - this.HgB > 1)
    {
      this.HgB = i;
      aDM();
      if (this.WfX != null)
      {
        this.WfX.setText(paramString);
        this.WfX.setTextColor(getResources().getColor(a.b.red));
        this.WfX.setVisibility(4);
        if (this.Wga == null) {
          this.Wga = AnimationUtils.loadAnimation(getContext(), a.a.Wei);
        }
        this.WfX.startAnimation(this.Wga);
        MMHandlerThread.postToMainThreadDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(129707);
            FingerprintWalletLockUI.j(FingerprintWalletLockUI.this).setVisibility(0);
            AppMethodBeat.o(129707);
          }
        }, this.Wga.getDuration());
      }
      AppMethodBeat.o(129735);
      return;
    }
    AppMethodBeat.o(129735);
  }
  
  private void aoP(String paramString)
  {
    AppMethodBeat.i(129734);
    String str = paramString;
    if (Util.isNullOrNil(paramString)) {
      str = getString(a.g.Wfo);
    }
    aDM();
    this.skS = k.d(this, str, "", new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(129706);
        FingerprintWalletLockUI.this.finish();
        AppMethodBeat.o(129706);
      }
    });
    this.skS.setCanceledOnTouchOutside(false);
    AppMethodBeat.o(129734);
  }
  
  private void asF(int paramInt)
  {
    AppMethodBeat.i(129732);
    Intent localIntent = new Intent();
    if (paramInt == 1) {
      localIntent.putExtra("action", "action.touchlock_verify_by_paypwd");
    }
    for (;;)
    {
      localIntent.putExtra("key_wallet_lock_type", 2);
      com.tencent.mm.br.c.b(this, "wallet", ".pwd.ui.WalletLockCheckPwdUI", localIntent, paramInt);
      AppMethodBeat.o(129732);
      return;
      if (paramInt == 2)
      {
        localIntent.putExtra("action", "action.touchlock_need_verify_paypwd");
        localIntent.putExtra("key_wallet_lock_input_new_fp_tips", getString(a.g.Wft));
      }
    }
  }
  
  private void bQa()
  {
    AppMethodBeat.i(129733);
    if ((this.wQT != null) && (this.wQT.isShowing())) {
      this.wQT.dismiss();
    }
    AppMethodBeat.o(129733);
  }
  
  private void imJ()
  {
    AppMethodBeat.i(129726);
    if (this.eb.equals("action.verify_pattern"))
    {
      this.WfX.setText(a.g.Wfp);
      this.WfX.setTextColor(getResources().getColor(a.b.normal_text_color));
      this.WfZ.setVisibility(0);
      AppMethodBeat.o(129726);
      return;
    }
    this.WfX.setText(a.g.Wfj);
    this.WfX.setTextColor(getResources().getColor(a.b.normal_text_color));
    this.WfZ.setVisibility(8);
    AppMethodBeat.o(129726);
  }
  
  private void imK()
  {
    AppMethodBeat.i(129727);
    bQa();
    e.a locala = new e.a(this);
    Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo mAuthType: %d", new Object[] { Integer.valueOf(this.Wgh) });
    if (this.Wgh == 2) {
      locala.aEO(a.g.Wfv).aER(a.g.WfB).c(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(129714);
          FingerprintWalletLockUI.i(FingerprintWalletLockUI.this);
          AppMethodBeat.o(129714);
        }
      }).aES(a.g.app_cancel).d(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(129713);
          Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo click negative button");
          AppMethodBeat.o(129713);
        }
      });
    }
    for (;;)
    {
      this.skS = locala.jHH();
      this.skS.setCanceledOnTouchOutside(false);
      this.skS.show();
      AppMethodBeat.o(129727);
      return;
      locala.aEO(a.g.Wfu).bDC(getString(a.g.app_ok)).c(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(129715);
          FingerprintWalletLockUI.imN();
          FingerprintWalletLockUI.c(FingerprintWalletLockUI.this, -1, "need set finger print in system");
          AppMethodBeat.o(129715);
        }
      });
    }
  }
  
  private void imL()
  {
    AppMethodBeat.i(129730);
    Log.i("MicroMsg.FingerprintWalletLockUI", "currentAction: %s", new Object[] { this.Wgc });
    if (Util.isNullOrNil(this.Wgc))
    {
      finish();
      AppMethodBeat.o(129730);
      return;
    }
    Object localObject1 = this.Wgc;
    int i = -1;
    switch (((String)localObject1).hashCode())
    {
    default: 
      switch (i)
      {
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(129730);
      return;
      if (!((String)localObject1).equals("action.switch_on_pattern")) {
        break;
      }
      i = 0;
      break;
      if (!((String)localObject1).equals("action.verify_pattern")) {
        break;
      }
      i = 1;
      break;
      if (!((String)localObject1).equals("next_action.switch_on_pattern")) {
        break;
      }
      i = 2;
      break;
      if (!((String)localObject1).equals("next_action.goto_protected_page")) {
        break;
      }
      i = 3;
      break;
      this.Wgf = new a(this);
      this.Wgg = "-1";
      if (this.Wge == null) {
        this.Wge = new com.tencent.mm.plugin.walletlock.fingerprint.a.h();
      }
      localObject1 = this.Wge;
      Object localObject2 = this.Wgf;
      Object localObject3 = new h.1((com.tencent.mm.plugin.walletlock.fingerprint.a.h)localObject1, (com.tencent.mm.plugin.walletlock.model.b)localObject2);
      ((com.tencent.mm.plugin.walletlock.fingerprint.a.h)localObject1).WfU = new com.tencent.soter.a.a.a();
      localObject3 = new b.a().os(this).aHl(1).a(((com.tencent.mm.plugin.walletlock.fingerprint.a.h)localObject1).WfU).a((com.tencent.soter.a.a.b)localObject3).bFL(com.tencent.mm.plugin.walletlock.model.f.WhM.WhN).aHk(3).ahys;
      com.tencent.mm.plugin.walletlock.model.f.WhM.WhO = null;
      Log.i("MicroMsg.SoterFingerprintAuthManager", "alvinluo start auth");
      com.tencent.soter.a.a.a(new h.2((com.tencent.mm.plugin.walletlock.fingerprint.a.h)localObject1, (com.tencent.mm.plugin.walletlock.model.b)localObject2), (com.tencent.soter.a.g.b)localObject3);
      AppMethodBeat.o(129730);
      return;
      localObject2 = com.tencent.mm.plugin.walletlock.model.f.WhM.WhO;
      if (localObject2 == null)
      {
        afy(getString(a.g.Wfk));
        AppMethodBeat.o(129730);
        return;
      }
      localObject1 = ((j)localObject2).ahxs;
      localObject2 = ((j)localObject2).signature;
      if (this.Wgd != null)
      {
        this.wQT = k.a(this, getString(a.g.Wfq), false, null);
        this.Wgd.a(new d.a()
        {
          public final void bL(int paramAnonymousInt, String paramAnonymousString)
          {
            AppMethodBeat.i(129708);
            Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo open fingerprint lock onFinish errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
            if (paramAnonymousInt == 0)
            {
              FingerprintWalletLockUI.k(FingerprintWalletLockUI.this);
              AppMethodBeat.o(129708);
              return;
            }
            FingerprintWalletLockUI.a(FingerprintWalletLockUI.this, FingerprintWalletLockUI.this.getString(a.g.Wfh));
            AppMethodBeat.o(129708);
          }
        }, this.mToken, (String)localObject1, (String)localObject2);
      }
      AppMethodBeat.o(129730);
      return;
      com.tencent.mm.plugin.walletlock.fingerprint.a.a.xB(SystemClock.elapsedRealtime());
      imM();
    }
  }
  
  private void imM()
  {
    AppMethodBeat.i(129731);
    this.Law = false;
    MMHandlerThread.postToMainThreadDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(129705);
        FingerprintWalletLockUI.this.finish();
        AppMethodBeat.o(129705);
      }
    }, 200L);
    Object localObject = (Intent)getIntent().getParcelableExtra("page_intent");
    if (localObject != null)
    {
      Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo go to protected page");
      com.tencent.mm.plugin.walletlock.model.h.WhQ.Ih(true);
      com.tencent.mm.plugin.walletlock.model.h.WhQ.Ii(true);
      ((Intent)localObject).addFlags(131072);
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/walletlock/fingerprint/ui/FingerprintWalletLockUI", "goToProtectedPage", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/walletlock/fingerprint/ui/FingerprintWalletLockUI", "goToProtectedPage", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      overridePendingTransition(a.a.slide_left_in, a.a.slide_right_out);
      AppMethodBeat.o(129731);
      return;
    }
    Log.i("MicroMsg.FingerprintWalletLockUI", "Protected page's intent not found, finish myself only.");
    AppMethodBeat.o(129731);
  }
  
  private void release()
  {
    AppMethodBeat.i(129736);
    Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo fingerprint lock ui release isCancelled: %b", new Object[] { Boolean.valueOf(this.isCancelled) });
    if (this.isCancelled)
    {
      AppMethodBeat.o(129736);
      return;
    }
    this.isCancelled = true;
    if (this.Wge != null) {
      this.Wge.release();
    }
    if (this.Wgd != null) {
      this.Wgd.release();
    }
    com.tencent.soter.a.g.f.jYD().jYE();
    AppMethodBeat.o(129736);
  }
  
  public void finish()
  {
    AppMethodBeat.i(129738);
    super.finish();
    release();
    AppMethodBeat.o(129738);
  }
  
  public int getLayoutId()
  {
    return a.e.Wey;
  }
  
  public void initView()
  {
    AppMethodBeat.i(129725);
    super.initView();
    this.WfX = ((TextView)findViewById(a.d.Wes));
    this.WfY = ((TextView)findViewById(a.d.Wew));
    this.ngm = ((TextView)findViewById(a.d.Weq));
    this.WfZ = ((TextView)findViewById(a.d.Wer));
    this.WfY.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(129703);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/walletlock/fingerprint/ui/FingerprintWalletLockUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        FingerprintWalletLockUI.g(FingerprintWalletLockUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/walletlock/fingerprint/ui/FingerprintWalletLockUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(129703);
      }
    });
    this.ngm.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(129710);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/walletlock/fingerprint/ui/FingerprintWalletLockUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        FingerprintWalletLockUI.imN();
        FingerprintWalletLockUI.c(FingerprintWalletLockUI.this, 0, "user cancel setting fingerprint lock");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/walletlock/fingerprint/ui/FingerprintWalletLockUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(129710);
      }
    });
    this.WfZ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(129711);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/walletlock/fingerprint/ui/FingerprintWalletLockUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        FingerprintWalletLockUI.g(FingerprintWalletLockUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/walletlock/fingerprint/ui/FingerprintWalletLockUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(129711);
      }
    });
    AppMethodBeat.o(129725);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(129739);
    Log.v("MicroMsg.FingerprintWalletLockUI", "alvinluo onActivityResult requestCode: %d, resultCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramIntent == null)
    {
      Log.e("MicroMsg.FingerprintWalletLockUI", "alvinluo data is null");
      AppMethodBeat.o(129739);
      return;
    }
    paramInt2 = paramIntent.getIntExtra("key_err_code", -1);
    Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo onActivityResult errCode: %d", new Object[] { Integer.valueOf(paramInt2) });
    if (paramInt1 == 1)
    {
      if (paramInt2 == 0)
      {
        imM();
        com.tencent.mm.plugin.walletlock.model.g.inr();
        AppMethodBeat.o(129739);
        return;
      }
      if (paramInt2 == -1)
      {
        this.Law = false;
        aoP(getString(a.g.WfG));
        AppMethodBeat.o(129739);
      }
    }
    else if (paramInt1 == 2)
    {
      if (paramInt2 == 0)
      {
        com.tencent.mm.plugin.walletlock.fingerprint.a.a.bhw(this.Wgg);
        com.tencent.mm.plugin.walletlock.fingerprint.a.a.xB(SystemClock.elapsedRealtime());
        imM();
        AppMethodBeat.o(129739);
        return;
      }
      if (paramInt2 == -1)
      {
        this.Law = false;
        aoP(getString(a.g.WfG));
        AppMethodBeat.o(129739);
      }
    }
    else
    {
      if (paramInt1 == 3)
      {
        if (paramInt2 == 0)
        {
          imM();
          AppMethodBeat.o(129739);
          return;
        }
        com.tencent.mm.plugin.walletlock.model.h.WhQ.inx();
        U(-1, paramInt2, "user cancel when set wallet lock");
        AppMethodBeat.o(129739);
        return;
      }
      if (paramInt1 == 4)
      {
        if (paramInt2 == 0)
        {
          imM();
          AppMethodBeat.o(129739);
          return;
        }
        if (paramInt2 == -1)
        {
          this.Law = false;
          aoP(getString(a.g.Wfr));
          AppMethodBeat.o(129739);
          return;
        }
        com.tencent.mm.plugin.walletlock.model.h.WhQ.inx();
        U(-1, paramInt2, "user cancel when open gesture");
        AppMethodBeat.o(129739);
        return;
      }
      if (paramInt1 == 5)
      {
        if (paramInt2 == 0)
        {
          ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.walletlock.a.b.class)).asE(0);
          paramIntent = com.tencent.mm.plugin.walletlock.model.f.WhM;
          com.tencent.mm.plugin.walletlock.model.f.imH();
          Toast.makeText(this, getString(a.g.Wfd), 0).show();
          imM();
          AppMethodBeat.o(129739);
          return;
        }
        if (paramInt2 == -1)
        {
          this.Law = false;
          aoP(getString(a.g.Wfe));
          AppMethodBeat.o(129739);
          return;
        }
        if (paramInt2 == 4)
        {
          com.tencent.mm.plugin.walletlock.model.h.WhQ.inx();
          U(-1, paramInt2, "user cancel when close wallet lock");
        }
      }
    }
    AppMethodBeat.o(129739);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(129729);
    Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo onBackPressed");
    com.tencent.mm.plugin.walletlock.model.h.WhQ.inx();
    U(0, 4, "user click back button");
    AppMethodBeat.o(129729);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(129722);
    super.onCreate(paramBundle);
    Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo onCreate %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    if (getSupportActionBar() != null) {
      getSupportActionBar().hide();
    }
    initView();
    paramBundle = getIntent();
    this.eb = paramBundle.getStringExtra("action");
    this.Wgc = this.eb;
    this.Wgb = paramBundle.getStringExtra("next_action");
    this.mToken = paramBundle.getStringExtra("token");
    this.qgt = paramBundle.getStringExtra("key_pay_passwd");
    this.Wgi = paramBundle.getIntExtra("scene", -1);
    Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo mAction: %s, mNextAction: %s", new Object[] { this.eb, this.Wgb });
    if (this.eb.equals("action.verify_pattern"))
    {
      this.Wgh = 2;
      com.tencent.mm.plugin.walletlock.model.g.jdMethod_int();
      AppMethodBeat.o(129722);
      return;
    }
    if (this.eb.equals("action.switch_on_pattern")) {
      this.Wgh = 1;
    }
    AppMethodBeat.o(129722);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(129724);
    super.onPause();
    Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo FingerprintWalletLockUI onPause");
    aDM();
    release();
    this.Law = true;
    AppMethodBeat.o(129724);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(129723);
    super.onResume();
    Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo needResume: %b", new Object[] { Boolean.valueOf(this.Law) });
    if (!this.Law)
    {
      AppMethodBeat.o(129723);
      return;
    }
    this.Wgd = new com.tencent.mm.plugin.walletlock.fingerprint.a.c();
    this.Wge = new com.tencent.mm.plugin.walletlock.fingerprint.a.h();
    this.isCancelled = false;
    com.tencent.soter.a.g.f.jYD().jYE();
    this.wQT = k.a(this, getString(a.g.app_waiting), false, null);
    imJ();
    Object localObject;
    if (this.eb.equals("action.switch_on_pattern"))
    {
      this.WfR = false;
      Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo start prepare, time: %d, isOffline: %b", new Object[] { Long.valueOf(System.currentTimeMillis()), Boolean.valueOf(this.WfR) });
      localObject = com.tencent.mm.plugin.walletlock.model.f.WhM;
      boolean bool = com.tencent.mm.plugin.walletlock.model.f.inp();
      localObject = com.tencent.mm.plugin.walletlock.model.f.WhM;
      if ((!com.tencent.mm.plugin.walletlock.model.f.imE()) || (bool)) {
        break label624;
      }
      Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo user opend fingerprint lock but device not support soter, isSupportFingerprintLock: %b", new Object[] { Boolean.valueOf(bool) });
      if (!com.tencent.mm.plugin.walletlock.gesture.a.g.imQ()) {
        break label522;
      }
      Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo user opened gesture, then switch to gesture");
      ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.walletlock.a.b.class)).asE(1);
      localObject = com.tencent.mm.plugin.walletlock.model.f.WhM;
      com.tencent.mm.plugin.walletlock.model.f.inn();
      finish();
      localObject = new Intent(this, GestureGuardLogicUI.class);
      ((Intent)localObject).addFlags(131072);
      ((Intent)localObject).putExtra("action", "action.verify_pattern");
      ((Intent)localObject).putExtra("next_action", "next_action.goto_protected_page");
      ((Intent)localObject).putExtra("page_intent", (Intent)getIntent().getParcelableExtra("page_intent"));
      ((Intent)localObject).setPackage(MMApplicationContext.getPackageName());
      bool = com.tencent.mm.kernel.h.baE().ban().getBoolean(at.a.acTQ, false);
      if (!bool)
      {
        ((Intent)localObject).putExtra("verify_title", getString(a.g.WfF));
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acTQ, Boolean.TRUE);
        com.tencent.mm.kernel.h.baE().ban().iZy();
      }
      Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo start gesture protect ui, isShowed: %b", new Object[] { Boolean.valueOf(bool) });
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/walletlock/fingerprint/ui/FingerprintWalletLockUI", "startGestureProtect", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/walletlock/fingerprint/ui/FingerprintWalletLockUI", "startGestureProtect", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.plugin.report.service.h.OAn.b(12097, new Object[] { Integer.valueOf(8), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
    }
    for (;;)
    {
      Log.i("MicroMsg.FingerprintWalletLockUI", "onResume end: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
      AppMethodBeat.o(129723);
      return;
      this.WfR = true;
      break;
      label522:
      Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo show not support fingerprint dialog");
      bQa();
      this.skS = new e.a(this).aEO(a.g.Wfw).aER(a.g.WfC).c(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(129717);
          Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo user click set gesture");
          ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.walletlock.a.b.class)).c(FingerprintWalletLockUI.this, 1, 4);
          AppMethodBeat.o(129717);
        }
      }).e(new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(129716);
          Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo cancel not support fingerprint dialog");
          FingerprintWalletLockUI.imN();
          FingerprintWalletLockUI.c(FingerprintWalletLockUI.this, 0, "user cancel reset wallet lock");
          AppMethodBeat.o(129716);
        }
      }).jHH();
      this.skS.setCanceledOnTouchOutside(false);
      this.skS.b(getString(a.g.Wfc), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(129704);
          Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo user click close wallet lock");
          ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.walletlock.a.b.class)).p(FingerprintWalletLockUI.this, 5);
          AppMethodBeat.o(129704);
        }
      });
      this.skS.show();
      continue;
      label624:
      if (!com.tencent.soter.core.a.oo(this))
      {
        imK();
      }
      else
      {
        localObject = new Bundle();
        ((Bundle)localObject).putString("key_pay_passwd", this.qgt);
        ((Bundle)localObject).putBoolean("key_fp_lock_offline_mode", this.WfR);
        this.Wgd.a(new d.a()
        {
          public final void bL(int paramAnonymousInt, String paramAnonymousString)
          {
            AppMethodBeat.i(129712);
            Log.i("MicroMsg.FingerprintWalletLockUI", "prepare onFinish errCode: %d, errMsg: %s, time: %d", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString, Long.valueOf(System.currentTimeMillis()) });
            if (FingerprintWalletLockUI.c(FingerprintWalletLockUI.this))
            {
              Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo has cancelled and return");
              AppMethodBeat.o(129712);
              return;
            }
            if (paramAnonymousInt == 0)
            {
              FingerprintWalletLockUI.h(FingerprintWalletLockUI.this);
              AppMethodBeat.o(129712);
              return;
            }
            FingerprintWalletLockUI.a(FingerprintWalletLockUI.this, FingerprintWalletLockUI.this.getString(a.g.Wfg));
            AppMethodBeat.o(129712);
          }
        }, (Bundle)localObject);
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
    AppMethodBeat.i(266932);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(com.tencent.mm.plugin.walletlock.gesture.a.a.class);
    AppMethodBeat.o(266932);
  }
  
  public final class a
    implements com.tencent.mm.plugin.walletlock.model.b
  {
    private WeakReference<FingerprintWalletLockUI> GgK;
    
    public a(FingerprintWalletLockUI paramFingerprintWalletLockUI)
    {
      AppMethodBeat.i(129718);
      this.GgK = null;
      this.GgK = new WeakReference(paramFingerprintWalletLockUI);
      AppMethodBeat.o(129718);
    }
    
    private FingerprintWalletLockUI imO()
    {
      AppMethodBeat.i(129719);
      if (this.GgK != null)
      {
        FingerprintWalletLockUI localFingerprintWalletLockUI = (FingerprintWalletLockUI)this.GgK.get();
        AppMethodBeat.o(129719);
        return localFingerprintWalletLockUI;
      }
      AppMethodBeat.o(129719);
      return null;
    }
    
    public final void imP()
    {
      AppMethodBeat.i(129720);
      FingerprintWalletLockUI.a(FingerprintWalletLockUI.this);
      FingerprintWalletLockUI.b(FingerprintWalletLockUI.this);
      AppMethodBeat.o(129720);
    }
    
    public final void onResult(int paramInt, String paramString)
    {
      AppMethodBeat.i(129721);
      Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo onResult result: %d, errMsg: %s, isCancelled: %b", new Object[] { Integer.valueOf(paramInt), paramString, Boolean.valueOf(FingerprintWalletLockUI.c(FingerprintWalletLockUI.this)) });
      if ((FingerprintWalletLockUI.d(FingerprintWalletLockUI.this) != null) && (FingerprintWalletLockUI.d(FingerprintWalletLockUI.this).equals("action.switch_on_pattern")))
      {
        paramString = new rn();
        paramString.iPe = 3L;
        paramString.jvX = 1L;
        paramString.bMH();
      }
      if ((FingerprintWalletLockUI.d(FingerprintWalletLockUI.this) != null) && (FingerprintWalletLockUI.d(FingerprintWalletLockUI.this).equals("action.verify_pattern")))
      {
        if (FingerprintWalletLockUI.e(FingerprintWalletLockUI.this) != 1) {
          break label167;
        }
        paramString = new rn();
        paramString.iPe = 7L;
        paramString.jvX = 1L;
        paramString.bMH();
      }
      while (FingerprintWalletLockUI.c(FingerprintWalletLockUI.this))
      {
        AppMethodBeat.o(129721);
        return;
        label167:
        if (FingerprintWalletLockUI.e(FingerprintWalletLockUI.this) == 2)
        {
          paramString = new rn();
          paramString.iPe = 9L;
          paramString.jvX = 1L;
          paramString.bMH();
        }
      }
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(129721);
        return;
        Log.i("MicroMsg.FingerprintWalletLockUI", "identify success");
        if (imO() != null) {
          FingerprintWalletLockUI.f(imO());
        }
        if ((FingerprintWalletLockUI.d(FingerprintWalletLockUI.this) != null) && (FingerprintWalletLockUI.d(FingerprintWalletLockUI.this).equals("action.switch_on_pattern")))
        {
          paramString = new rn();
          paramString.iPe = 3L;
          paramString.jvX = 2L;
          paramString.bMH();
        }
        if ((FingerprintWalletLockUI.d(FingerprintWalletLockUI.this) != null) && (FingerprintWalletLockUI.d(FingerprintWalletLockUI.this).equals("action.verify_pattern")))
        {
          if (FingerprintWalletLockUI.e(FingerprintWalletLockUI.this) == 1)
          {
            paramString = new rn();
            paramString.iPe = 7L;
            paramString.jvX = 2L;
            paramString.bMH();
            AppMethodBeat.o(129721);
            return;
          }
          if (FingerprintWalletLockUI.e(FingerprintWalletLockUI.this) == 2)
          {
            paramString = new rn();
            paramString.iPe = 9L;
            paramString.jvX = 2L;
            paramString.bMH();
            AppMethodBeat.o(129721);
            return;
            Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo user cancel");
            AppMethodBeat.o(129721);
            return;
            Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo identify ERR_NO_MATCH");
            if (imO() != null)
            {
              FingerprintWalletLockUI.a(imO(), paramInt, FingerprintWalletLockUI.this.getString(a.g.Wfn));
              AppMethodBeat.o(129721);
              return;
              Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo identify TIMEOUT");
              if (imO() != null)
              {
                FingerprintWalletLockUI.a(imO(), paramInt, FingerprintWalletLockUI.this.getString(a.g.Wfn));
                AppMethodBeat.o(129721);
                return;
                if (imO() != null)
                {
                  FingerprintWalletLockUI.b(imO(), paramInt, FingerprintWalletLockUI.this.getString(a.g.Wfg));
                  AppMethodBeat.o(129721);
                  return;
                  if (imO() != null)
                  {
                    FingerprintWalletLockUI.b(imO(), paramInt, FingerprintWalletLockUI.this.getString(a.g.Wfv));
                    AppMethodBeat.o(129721);
                    return;
                    Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo on error: %d", new Object[] { Integer.valueOf(paramInt) });
                    if (imO() != null) {
                      FingerprintWalletLockUI.b(imO(), paramInt, FingerprintWalletLockUI.this.getString(a.g.Wfm));
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.fingerprint.ui.FingerprintWalletLockUI
 * JD-Core Version:    0.7.0.1
 */