package com.tencent.mm.plugin.remittance.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.gk;
import com.tencent.mm.g.a.rn;
import com.tencent.mm.g.a.rn.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.remittance.model.n;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.alf;
import com.tencent.mm.protocal.protobuf.vp;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.ui.x;
import com.tencent.mm.wallet_core.c.ag;
import com.tencent.mm.wallet_core.c.r;
import com.tencent.mm.wallet_core.c.r.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.f;
import java.util.ArrayList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class RemittanceF2fDynamicCodeUI
  extends WalletBaseUI
{
  private static int Cwo = 60000;
  private String AOH;
  private String Cpt;
  private String CvW;
  private String CvX;
  private String CvY;
  private String CvZ;
  private String Cwa;
  private String Cwb;
  private List<alf> Cwc;
  private boolean Cwd;
  private TextView Cwe;
  private TextView Cwf;
  private Button Cwg;
  private LinearLayout Cwh;
  private ImageView Cwi;
  private LinearLayout Cwj;
  private WalletTextView Cwk;
  private boolean Cwl;
  private long Cwm;
  private long Cwn;
  private MTimerHandler Cwp;
  private String dKo;
  private PayInfo mPayInfo;
  private String ngg;
  private String nickname;
  private int qAW;
  private u.a qBH;
  private String qBl;
  private String username;
  private int yRL;
  
  public RemittanceF2fDynamicCodeUI()
  {
    AppMethodBeat.i(68188);
    this.Cwc = new ArrayList();
    this.Cwd = false;
    this.Cwl = false;
    this.Cwm = 0L;
    this.Cwn = 0L;
    this.Cwp = new MTimerHandler(new a((byte)0), true);
    this.qBH = new u.a()
    {
      public final void k(String paramAnonymousString, Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(68180);
        if ((paramAnonymousString == null) || (RemittanceF2fDynamicCodeUI.a(RemittanceF2fDynamicCodeUI.this) == null))
        {
          AppMethodBeat.o(68180);
          return;
        }
        if (paramAnonymousString.equals(RemittanceF2fDynamicCodeUI.a(RemittanceF2fDynamicCodeUI.this)))
        {
          Log.i("MicroMsg.RemittanceF2fDynamicCodeUI", "cdnImageDownloadListener mchPhoto = %s notifyKey = %s", new Object[] { RemittanceF2fDynamicCodeUI.a(RemittanceF2fDynamicCodeUI.this), paramAnonymousString });
          RemittanceF2fDynamicCodeUI.this.runOnUiThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(68179);
              RemittanceF2fDynamicCodeUI.b(RemittanceF2fDynamicCodeUI.this);
              AppMethodBeat.o(68179);
            }
          });
        }
        AppMethodBeat.o(68180);
      }
    };
    AppMethodBeat.o(68188);
  }
  
  private boolean eOi()
  {
    AppMethodBeat.i(68196);
    boolean bool = getIntent().getBooleanExtra("from_patch_ui", false);
    AppMethodBeat.o(68196);
    return bool;
  }
  
  public int getLayoutId()
  {
    return 2131496102;
  }
  
  public void initView()
  {
    AppMethodBeat.i(68190);
    if (eOi())
    {
      this.Cwe = ((TextView)findViewById(2131307067));
      this.Cwf = ((TextView)findViewById(2131307066));
      this.Cwg = ((Button)findViewById(2131307065));
      this.Cwi = ((ImageView)findViewById(2131307063));
      this.Cwh = ((LinearLayout)findViewById(2131307064));
      this.Cwj = ((LinearLayout)findViewById(2131308321));
      this.Cwk = ((WalletTextView)findViewById(2131305808));
      this.Cwk.setText(getString(2131764595, new Object[] { f.D(this.yRL / 100.0D) }));
      this.Cwg.setOnClickListener(new x()
      {
        public final void czW()
        {
          AppMethodBeat.i(68183);
          RemittanceF2fDynamicCodeUI.a(RemittanceF2fDynamicCodeUI.this, 2);
          AppMethodBeat.o(68183);
        }
      });
      this.Cwi.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(68184);
          b localb = new b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceF2fDynamicCodeUI$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.axR());
          RemittanceF2fDynamicCodeUI.d(RemittanceF2fDynamicCodeUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/remittance/ui/RemittanceF2fDynamicCodeUI$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(68184);
          return false;
        }
      });
    }
    AppMethodBeat.o(68190);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool = true;
    AppMethodBeat.i(68194);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (eOi())
    {
      Log.i("MicroMsg.RemittanceF2fDynamicCodeUI", "onActivityResult requestCode:%s resultCode:%s %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent });
      if (paramInt1 == 1)
      {
        rn localrn = new rn();
        rn.a locala = localrn.dYd;
        if (paramInt2 == -1)
        {
          locala.dGX = bool;
          if (paramIntent == null) {
            break label143;
          }
        }
        label143:
        for (localrn.dYd.dYe = paramIntent.getIntExtra("key_pay_reslut_type", 3);; localrn.dYd.dYe = 3)
        {
          EventCenter.instance.publish(localrn);
          if (paramInt2 != -1) {
            break label155;
          }
          setResult(-1, paramIntent);
          finish();
          AppMethodBeat.o(68194);
          return;
          bool = false;
          break;
        }
        label155:
        if (ag.bH(paramIntent))
        {
          setResult(0, paramIntent);
          finish();
          AppMethodBeat.o(68194);
          return;
        }
        if (ag.bI(paramIntent))
        {
          AppMethodBeat.o(68194);
          return;
        }
        paramIntent = new gk();
        paramIntent.dKl.dKm = false;
        EventCenter.instance.publish(paramIntent);
      }
    }
    AppMethodBeat.o(68194);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(68189);
    super.onCreate(paramBundle);
    if (eOi())
    {
      if (getSupportActionBar() != null)
      {
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(2131101000)));
        paramBundle = getSupportActionBar().getCustomView();
        if (paramBundle != null)
        {
          View localView = paramBundle.findViewById(2131299682);
          if (localView != null) {
            localView.setBackgroundColor(getResources().getColor(2131099665));
          }
          paramBundle = paramBundle.findViewById(16908308);
          if ((paramBundle != null) && ((paramBundle instanceof TextView))) {
            ((TextView)paramBundle).setTextColor(getResources().getColor(2131100904));
          }
        }
      }
      if (Build.VERSION.SDK_INT >= 21)
      {
        paramBundle = getWindow();
        paramBundle.addFlags(-2147483648);
        paramBundle.setStatusBarColor(getResources().getColor(2131101000));
      }
      if ((d.oD(21)) && (!d.oD(23))) {
        getWindow().setStatusBarColor(getContext().getResources().getColor(2131099689));
      }
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(68182);
          if (RemittanceF2fDynamicCodeUI.c(RemittanceF2fDynamicCodeUI.this))
          {
            RemittanceF2fDynamicCodeUI.this.hideVKB();
            RemittanceF2fDynamicCodeUI.this.showDialog(1000);
          }
          for (;;)
          {
            AppMethodBeat.o(68182);
            return true;
            RemittanceF2fDynamicCodeUI.this.setResult(0, new Intent().putExtra("key_pay_reslut_type", 4));
            RemittanceF2fDynamicCodeUI.this.finish();
          }
        }
      }, 2131689734);
      addSceneEndListener(2736);
      setMMTitle(2131764500);
      this.mPayInfo = ((PayInfo)getIntent().getParcelableExtra("key_pay_info"));
      if (this.mPayInfo == null)
      {
        Log.e("MicroMsg.RemittanceF2fDynamicCodeUI", "payinfo is null");
        finish();
      }
      setContentViewVisibility(4);
      this.yRL = this.mPayInfo.iqp.getInt("extinfo_key_15");
      this.username = this.mPayInfo.iqp.getString("extinfo_key_1");
      this.AOH = this.mPayInfo.iqp.getString("extinfo_key_2");
      this.CvX = this.mPayInfo.iqp.getString("extinfo_key_17");
      this.CvY = this.mPayInfo.iqp.getString("extinfo_key_18");
      this.ngg = getIntent().getStringExtra("key_rcvr_open_id");
      this.CvZ = getIntent().getStringExtra("key_mch_info");
      this.CvW = getIntent().getStringExtra("key_transfer_qrcode_id");
      this.qBl = getIntent().getStringExtra("key_mch_photo");
      this.Cpt = getIntent().getStringExtra("show_paying_wording");
      this.Cwa = getIntent().getStringExtra("dynamic_code_spam_wording");
      this.Cwd = getIntent().getBooleanExtra("show_avatar_type", false);
      this.nickname = f.getDisplayName(this.username);
      initView();
    }
    AppMethodBeat.o(68189);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(68193);
    if (eOi()) {
      removeSceneEndListener(2736);
    }
    u.c(this.qBH);
    super.onDestroy();
    AppMethodBeat.o(68193);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(68192);
    super.onPause();
    if (eOi())
    {
      this.Cwp.stopTimer();
      Log.d("MicroMsg.RemittanceF2fDynamicCodeUI", "stop timer");
    }
    AppMethodBeat.o(68192);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(68191);
    super.onResume();
    e.eNU().gS(this);
    if (eOi())
    {
      l = System.currentTimeMillis();
      if (this.Cwm > 0L) {
        break label120;
      }
    }
    label120:
    for (long l = 0L;; l = Cwo - (l - this.Cwm))
    {
      this.Cwn = l;
      Log.i("MicroMsg.RemittanceF2fDynamicCodeUI", "last time: %s, delay: %s", new Object[] { Long.valueOf(this.Cwm), Long.valueOf(this.Cwn) });
      if (this.Cwn < 0L) {
        this.Cwn = 0L;
      }
      this.Cwp.startTimer(this.Cwn, Cwo);
      Log.d("MicroMsg.RemittanceF2fDynamicCodeUI", "start timer");
      AppMethodBeat.o(68191);
      return;
    }
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, q paramq)
  {
    AppMethodBeat.i(68195);
    if ((eOi()) && ((paramq instanceof n)))
    {
      this.Cwl = false;
      paramString = (n)paramq;
      setContentViewVisibility(0);
      paramString.a(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
        {
          AppMethodBeat.i(68181);
          RemittanceF2fDynamicCodeUI.a(RemittanceF2fDynamicCodeUI.this, paramString.CoK.qwo);
          RemittanceF2fDynamicCodeUI.b(RemittanceF2fDynamicCodeUI.this, ag.aqj(paramString.CoK.LgF));
          RemittanceF2fDynamicCodeUI.b(RemittanceF2fDynamicCodeUI.this, paramString.CoK.LgD);
          RemittanceF2fDynamicCodeUI.a(RemittanceF2fDynamicCodeUI.this, paramString.CoK.LgE);
          RemittanceF2fDynamicCodeUI.b(RemittanceF2fDynamicCodeUI.this);
          AppMethodBeat.o(68181);
        }
      }).b(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq) {}
      }).c(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq) {}
      });
    }
    AppMethodBeat.o(68195);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    implements MTimerHandler.CallBack
  {
    private a() {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(68187);
      Log.d("MicroMsg.RemittanceF2fDynamicCodeUI", "timer expired");
      if (RemittanceF2fDynamicCodeUI.e(RemittanceF2fDynamicCodeUI.this))
      {
        AppMethodBeat.o(68187);
        return true;
      }
      RemittanceF2fDynamicCodeUI.a(RemittanceF2fDynamicCodeUI.this, System.currentTimeMillis());
      RemittanceF2fDynamicCodeUI.f(RemittanceF2fDynamicCodeUI.this);
      AppMethodBeat.o(68187);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceF2fDynamicCodeUI
 * JD-Core Version:    0.7.0.1
 */