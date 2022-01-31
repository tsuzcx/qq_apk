package com.tencent.mm.plugin.remittance.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
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
import com.tencent.mm.g.a.fw;
import com.tencent.mm.g.a.oi;
import com.tencent.mm.g.a.oi.a;
import com.tencent.mm.platformtools.x.a;
import com.tencent.mm.plugin.wallet_core.utils.c;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.aba;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.wallet_core.c.p;
import com.tencent.mm.wallet_core.c.p.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import java.util.ArrayList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class RemittanceF2fDynamicCodeUI
  extends WalletBaseUI
{
  private static int qqG = 60000;
  private String cum;
  private int kRS;
  private String kSi;
  private x.a kSu;
  private PayInfo mPayInfo;
  private String nickname;
  private int okH;
  private String ppM;
  private String qjX;
  private ImageView qqA;
  private LinearLayout qqB;
  private WalletTextView qqC;
  private boolean qqD;
  private long qqE;
  private long qqF;
  private ap qqH;
  private String qqn;
  private String qqo;
  private String qqp;
  private String qqq;
  private String qqr;
  private String qqs;
  private String qqt;
  private List<aba> qqu;
  private boolean qqv;
  private TextView qqw;
  private TextView qqx;
  private Button qqy;
  private LinearLayout qqz;
  private String username;
  
  public RemittanceF2fDynamicCodeUI()
  {
    AppMethodBeat.i(45059);
    this.qqu = new ArrayList();
    this.qqv = false;
    this.qqD = false;
    this.qqE = 0L;
    this.qqF = 0L;
    this.qqH = new ap(new RemittanceF2fDynamicCodeUI.a(this, (byte)0), true);
    this.kSu = new RemittanceF2fDynamicCodeUI.1(this);
    AppMethodBeat.o(45059);
  }
  
  private boolean chz()
  {
    AppMethodBeat.i(45067);
    boolean bool = getIntent().getBooleanExtra("from_patch_ui", false);
    AppMethodBeat.o(45067);
    return bool;
  }
  
  public int getLayoutId()
  {
    return 2130970572;
  }
  
  public void initView()
  {
    AppMethodBeat.i(45061);
    if (chz())
    {
      this.qqw = ((TextView)findViewById(2131827290));
      this.qqx = ((TextView)findViewById(2131827295));
      this.qqy = ((Button)findViewById(2131827296));
      this.qqA = ((ImageView)findViewById(2131827292));
      this.qqz = ((LinearLayout)findViewById(2131827293));
      this.qqB = ((LinearLayout)findViewById(2131827294));
      this.qqC = ((WalletTextView)findViewById(2131827291));
      this.qqC.setText(getString(2131302622, new Object[] { com.tencent.mm.wallet_core.ui.e.F(this.okH / 100.0D) }));
      this.qqy.setOnClickListener(new RemittanceF2fDynamicCodeUI.4(this));
      this.qqA.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(45055);
          RemittanceF2fDynamicCodeUI.d(RemittanceF2fDynamicCodeUI.this);
          AppMethodBeat.o(45055);
          return false;
        }
      });
    }
    AppMethodBeat.o(45061);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool = true;
    AppMethodBeat.i(45065);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (chz())
    {
      ab.i("MicroMsg.RemittanceF2fDynamicCodeUI", "onActivityResult requestCode:%s resultCode:%s %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent });
      if (paramInt1 == 1)
      {
        oi localoi = new oi();
        oi.a locala = localoi.cET;
        if (paramInt2 == -1)
        {
          locala.cqS = bool;
          if (paramIntent == null) {
            break label143;
          }
        }
        label143:
        for (localoi.cET.cEU = paramIntent.getIntExtra("key_pay_reslut_type", 3);; localoi.cET.cEU = 3)
        {
          com.tencent.mm.sdk.b.a.ymk.l(localoi);
          if (paramInt2 != -1) {
            break label155;
          }
          setResult(-1, paramIntent);
          finish();
          AppMethodBeat.o(45065);
          return;
          bool = false;
          break;
        }
        label155:
        if (c.av(paramIntent))
        {
          setResult(0, paramIntent);
          finish();
          AppMethodBeat.o(45065);
          return;
        }
        if (c.aw(paramIntent))
        {
          AppMethodBeat.o(45065);
          return;
        }
        paramIntent = new fw();
        paramIntent.cuj.cuk = false;
        com.tencent.mm.sdk.b.a.ymk.l(paramIntent);
      }
    }
    AppMethodBeat.o(45065);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(45060);
    super.onCreate(paramBundle);
    if (chz())
    {
      if (getSupportActionBar() != null)
      {
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(2131690396)));
        paramBundle = getSupportActionBar().getCustomView();
        if (paramBundle != null)
        {
          View localView = paramBundle.findViewById(2131821148);
          if (localView != null) {
            localView.setBackgroundColor(getResources().getColor(2131690161));
          }
          paramBundle = paramBundle.findViewById(16908308);
          if ((paramBundle != null) && ((paramBundle instanceof TextView))) {
            ((TextView)paramBundle).setTextColor(getResources().getColor(2131689763));
          }
        }
      }
      if (Build.VERSION.SDK_INT >= 21)
      {
        paramBundle = getWindow();
        paramBundle.addFlags(-2147483648);
        paramBundle.setStatusBarColor(getResources().getColor(2131690396));
      }
      if (d.fv(21))
      {
        if (!d.fv(23)) {
          break label462;
        }
        getWindow().getDecorView().setSystemUiVisibility(8192);
      }
    }
    for (;;)
    {
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(45053);
          if (RemittanceF2fDynamicCodeUI.c(RemittanceF2fDynamicCodeUI.this))
          {
            RemittanceF2fDynamicCodeUI.this.hideVKB();
            RemittanceF2fDynamicCodeUI.this.showDialog(1000);
          }
          for (;;)
          {
            AppMethodBeat.o(45053);
            return true;
            RemittanceF2fDynamicCodeUI.this.setResult(0, new Intent().putExtra("key_pay_reslut_type", 4));
            RemittanceF2fDynamicCodeUI.this.finish();
          }
        }
      }, 2131230946);
      addSceneEndListener(2736);
      setMMTitle(2131302530);
      this.mPayInfo = ((PayInfo)getIntent().getParcelableExtra("key_pay_info"));
      if (this.mPayInfo == null)
      {
        ab.e("MicroMsg.RemittanceF2fDynamicCodeUI", "payinfo is null");
        finish();
      }
      setContentViewVisibility(4);
      this.okH = this.mPayInfo.wgv.getInt("extinfo_key_15");
      this.username = this.mPayInfo.wgv.getString("extinfo_key_1");
      this.ppM = this.mPayInfo.wgv.getString("extinfo_key_2");
      this.qqp = this.mPayInfo.wgv.getString("extinfo_key_17");
      this.qqq = this.mPayInfo.wgv.getString("extinfo_key_18");
      this.qqn = getIntent().getStringExtra("key_rcvr_open_id");
      this.qqr = getIntent().getStringExtra("key_mch_info");
      this.qqo = getIntent().getStringExtra("key_transfer_qrcode_id");
      this.kSi = getIntent().getStringExtra("key_mch_photo");
      this.qjX = getIntent().getStringExtra("show_paying_wording");
      this.qqs = getIntent().getStringExtra("dynamic_code_spam_wording");
      this.qqv = getIntent().getBooleanExtra("show_avatar_type", false);
      this.nickname = com.tencent.mm.wallet_core.ui.e.nE(this.username);
      initView();
      AppMethodBeat.o(45060);
      return;
      label462:
      getWindow().setStatusBarColor(Color.parseColor("#E5E5E5"));
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(45064);
    if (chz()) {
      removeSceneEndListener(2736);
    }
    super.onDestroy();
    AppMethodBeat.o(45064);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(45063);
    super.onPause();
    if (chz())
    {
      this.qqH.stopTimer();
      ab.d("MicroMsg.RemittanceF2fDynamicCodeUI", "stop timer");
    }
    AppMethodBeat.o(45063);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(45062);
    super.onResume();
    e.chr().eN(this);
    if (chz())
    {
      l = System.currentTimeMillis();
      if (this.qqE > 0L) {
        break label120;
      }
    }
    label120:
    for (long l = 0L;; l = qqG - (l - this.qqE))
    {
      this.qqF = l;
      ab.i("MicroMsg.RemittanceF2fDynamicCodeUI", "last time: %s, delay: %s", new Object[] { Long.valueOf(this.qqE), Long.valueOf(this.qqF) });
      if (this.qqF < 0L) {
        this.qqF = 0L;
      }
      this.qqH.ag(this.qqF, qqG);
      ab.d("MicroMsg.RemittanceF2fDynamicCodeUI", "start timer");
      AppMethodBeat.o(45062);
      return;
    }
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(45066);
    if ((chz()) && ((paramm instanceof com.tencent.mm.plugin.remittance.model.m)))
    {
      this.qqD = false;
      paramString = (com.tencent.mm.plugin.remittance.model.m)paramm;
      setContentViewVisibility(0);
      paramString.a(new RemittanceF2fDynamicCodeUI.2(this, paramString)).b(new p.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ai.m paramAnonymousm) {}
      }).c(new RemittanceF2fDynamicCodeUI.9(this));
    }
    AppMethodBeat.o(45066);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceF2fDynamicCodeUI
 * JD-Core Version:    0.7.0.1
 */