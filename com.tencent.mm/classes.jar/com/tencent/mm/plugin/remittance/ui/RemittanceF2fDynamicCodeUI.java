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
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.gh;
import com.tencent.mm.g.a.qt;
import com.tencent.mm.g.a.qt.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.air;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.w;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.wallet_core.c.ag;
import com.tencent.mm.wallet_core.c.r;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.f;
import java.util.ArrayList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class RemittanceF2fDynamicCodeUI
  extends WalletBaseUI
{
  private static int yvs = 60000;
  private String dte;
  private String lYA;
  private PayInfo mPayInfo;
  private String nickname;
  private int plG;
  private String plV;
  private u.a pmp;
  private String username;
  private int vxx;
  private String wSN;
  private String yoD;
  private String yva;
  private String yvb;
  private String yvc;
  private String yvd;
  private String yve;
  private String yvf;
  private List<air> yvg;
  private boolean yvh;
  private TextView yvi;
  private TextView yvj;
  private Button yvk;
  private LinearLayout yvl;
  private ImageView yvm;
  private LinearLayout yvn;
  private WalletTextView yvo;
  private boolean yvp;
  private long yvq;
  private long yvr;
  private aw yvt;
  
  public RemittanceF2fDynamicCodeUI()
  {
    AppMethodBeat.i(68188);
    this.yvg = new ArrayList();
    this.yvh = false;
    this.yvp = false;
    this.yvq = 0L;
    this.yvr = 0L;
    this.yvt = new aw(new a((byte)0), true);
    this.pmp = new u.a()
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
          ae.i("MicroMsg.RemittanceF2fDynamicCodeUI", "cdnImageDownloadListener mchPhoto = %s notifyKey = %s", new Object[] { RemittanceF2fDynamicCodeUI.a(RemittanceF2fDynamicCodeUI.this), paramAnonymousString });
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
  
  private boolean dNi()
  {
    AppMethodBeat.i(68196);
    boolean bool = getIntent().getBooleanExtra("from_patch_ui", false);
    AppMethodBeat.o(68196);
    return bool;
  }
  
  public int getLayoutId()
  {
    return 2131495255;
  }
  
  public void initView()
  {
    AppMethodBeat.i(68190);
    if (dNi())
    {
      this.yvi = ((TextView)findViewById(2131304167));
      this.yvj = ((TextView)findViewById(2131304166));
      this.yvk = ((Button)findViewById(2131304165));
      this.yvm = ((ImageView)findViewById(2131304163));
      this.yvl = ((LinearLayout)findViewById(2131304164));
      this.yvn = ((LinearLayout)findViewById(2131305142));
      this.yvo = ((WalletTextView)findViewById(2131303151));
      this.yvo.setText(getString(2131762528, new Object[] { f.D(this.vxx / 100.0D) }));
      this.yvk.setOnClickListener(new w()
      {
        public final void ccc()
        {
          AppMethodBeat.i(68183);
          RemittanceF2fDynamicCodeUI.a(RemittanceF2fDynamicCodeUI.this, 2);
          AppMethodBeat.o(68183);
        }
      });
      this.yvm.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(68184);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceF2fDynamicCodeUI$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahF());
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
    if (dNi())
    {
      ae.i("MicroMsg.RemittanceF2fDynamicCodeUI", "onActivityResult requestCode:%s resultCode:%s %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent });
      if (paramInt1 == 1)
      {
        qt localqt = new qt();
        qt.a locala = localqt.dGs;
        if (paramInt2 == -1)
        {
          locala.dpK = bool;
          if (paramIntent == null) {
            break label143;
          }
        }
        label143:
        for (localqt.dGs.dGt = paramIntent.getIntExtra("key_pay_reslut_type", 3);; localqt.dGs.dGt = 3)
        {
          com.tencent.mm.sdk.b.a.IvT.l(localqt);
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
        if (ag.bx(paramIntent))
        {
          setResult(0, paramIntent);
          finish();
          AppMethodBeat.o(68194);
          return;
        }
        if (ag.by(paramIntent))
        {
          AppMethodBeat.o(68194);
          return;
        }
        paramIntent = new gh();
        paramIntent.dtb.dtc = false;
        com.tencent.mm.sdk.b.a.IvT.l(paramIntent);
      }
    }
    AppMethodBeat.o(68194);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(68189);
    super.onCreate(paramBundle);
    if (dNi())
    {
      if (getSupportActionBar() != null)
      {
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(2131100804)));
        paramBundle = getSupportActionBar().getCustomView();
        if (paramBundle != null)
        {
          View localView = paramBundle.findViewById(2131299154);
          if (localView != null) {
            localView.setBackgroundColor(getResources().getColor(2131099662));
          }
          paramBundle = paramBundle.findViewById(16908308);
          if ((paramBundle != null) && ((paramBundle instanceof TextView))) {
            ((TextView)paramBundle).setTextColor(getResources().getColor(2131100711));
          }
        }
      }
      if (Build.VERSION.SDK_INT >= 21)
      {
        paramBundle = getWindow();
        paramBundle.addFlags(-2147483648);
        paramBundle.setStatusBarColor(getResources().getColor(2131100804));
      }
      if ((d.lA(21)) && (!d.lA(23))) {
        getWindow().setStatusBarColor(getContext().getResources().getColor(2131099679));
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
      }, 2131689727);
      addSceneEndListener(2736);
      setMMTitle(2131762434);
      this.mPayInfo = ((PayInfo)getIntent().getParcelableExtra("key_pay_info"));
      if (this.mPayInfo == null)
      {
        ae.e("MicroMsg.RemittanceF2fDynamicCodeUI", "payinfo is null");
        finish();
      }
      setContentViewVisibility(4);
      this.vxx = this.mPayInfo.hwN.getInt("extinfo_key_15");
      this.username = this.mPayInfo.hwN.getString("extinfo_key_1");
      this.wSN = this.mPayInfo.hwN.getString("extinfo_key_2");
      this.yvb = this.mPayInfo.hwN.getString("extinfo_key_17");
      this.yvc = this.mPayInfo.hwN.getString("extinfo_key_18");
      this.lYA = getIntent().getStringExtra("key_rcvr_open_id");
      this.yvd = getIntent().getStringExtra("key_mch_info");
      this.yva = getIntent().getStringExtra("key_transfer_qrcode_id");
      this.plV = getIntent().getStringExtra("key_mch_photo");
      this.yoD = getIntent().getStringExtra("show_paying_wording");
      this.yve = getIntent().getStringExtra("dynamic_code_spam_wording");
      this.yvh = getIntent().getBooleanExtra("show_avatar_type", false);
      this.nickname = f.zP(this.username);
      initView();
    }
    AppMethodBeat.o(68189);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(68193);
    if (dNi()) {
      removeSceneEndListener(2736);
    }
    super.onDestroy();
    AppMethodBeat.o(68193);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(68192);
    super.onPause();
    if (dNi())
    {
      this.yvt.stopTimer();
      ae.d("MicroMsg.RemittanceF2fDynamicCodeUI", "stop timer");
    }
    AppMethodBeat.o(68192);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(68191);
    super.onResume();
    e.dMU().gi(this);
    if (dNi())
    {
      l = System.currentTimeMillis();
      if (this.yvq > 0L) {
        break label120;
      }
    }
    label120:
    for (long l = 0L;; l = yvs - (l - this.yvq))
    {
      this.yvr = l;
      ae.i("MicroMsg.RemittanceF2fDynamicCodeUI", "last time: %s, delay: %s", new Object[] { Long.valueOf(this.yvq), Long.valueOf(this.yvr) });
      if (this.yvr < 0L) {
        this.yvr = 0L;
      }
      this.yvt.ay(this.yvr, yvs);
      ae.d("MicroMsg.RemittanceF2fDynamicCodeUI", "start timer");
      AppMethodBeat.o(68191);
      return;
    }
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(68195);
    if ((dNi()) && ((paramn instanceof com.tencent.mm.plugin.remittance.model.n)))
    {
      this.yvp = false;
      paramString = (com.tencent.mm.plugin.remittance.model.n)paramn;
      setContentViewVisibility(0);
      paramString.a(new RemittanceF2fDynamicCodeUI.2(this, paramString)).b(new RemittanceF2fDynamicCodeUI.10(this)).c(new RemittanceF2fDynamicCodeUI.9(this));
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
    implements aw.a
  {
    private a() {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(68187);
      ae.d("MicroMsg.RemittanceF2fDynamicCodeUI", "timer expired");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceF2fDynamicCodeUI
 * JD-Core Version:    0.7.0.1
 */