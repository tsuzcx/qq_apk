package com.tencent.mm.plugin.remittance.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.a.hc;
import com.tencent.mm.autogen.a.ub;
import com.tencent.mm.autogen.a.ub.a;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.remittance.model.q;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.apy;
import com.tencent.mm.protocal.protobuf.xj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.ui.ac;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.model.ah;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.i;
import java.util.ArrayList;
import java.util.List;

@a(3)
public class RemittanceF2fDynamicCodeUI
  extends WalletBaseUI
{
  private static int OrR = 60000;
  private String MEL;
  private String OjY;
  private String OrA;
  private String OrB;
  private String OrC;
  private String OrD;
  private String OrE;
  private List<apy> OrF;
  private boolean OrG;
  private TextView OrH;
  private TextView OrI;
  private Button OrJ;
  private LinearLayout OrK;
  private ImageView OrL;
  private LinearLayout OrM;
  private WalletTextView OrN;
  private boolean OrO;
  private long OrP;
  private long OrQ;
  private MTimerHandler OrS;
  private String Orz;
  private int amount;
  private String hHS;
  private PayInfo mPayInfo;
  private String nickname;
  private String tlB;
  private String username;
  private String xdD;
  private com.tencent.mm.platformtools.r.a xdZ;
  private int xdo;
  
  public RemittanceF2fDynamicCodeUI()
  {
    AppMethodBeat.i(68188);
    this.OrF = new ArrayList();
    this.OrG = false;
    this.OrO = false;
    this.OrP = 0L;
    this.OrQ = 0L;
    this.OrS = new MTimerHandler(new a((byte)0), true);
    this.xdZ = new com.tencent.mm.platformtools.r.a()
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
  
  private boolean gMW()
  {
    AppMethodBeat.i(68196);
    boolean bool = getIntent().getBooleanExtra("from_patch_ui", false);
    AppMethodBeat.o(68196);
    return bool;
  }
  
  public int getLayoutId()
  {
    return a.g.remittance_f2f_dynamic_code_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(68190);
    if (gMW())
    {
      this.OrH = ((TextView)findViewById(a.f.rfdc_supervision_tv));
      this.OrI = ((TextView)findViewById(a.f.rfdc_spam_tv));
      this.OrJ = ((Button)findViewById(a.f.rfdc_pay_btn));
      this.OrL = ((ImageView)findViewById(a.f.rfdc_code_iv));
      this.OrK = ((LinearLayout)findViewById(a.f.rfdc_items_layout));
      this.OrM = ((LinearLayout)findViewById(a.f.spam_ll));
      this.OrN = ((WalletTextView)findViewById(a.f.pay_fee_tv));
      this.OrN.setText(getString(a.i.remittance_scan_qrcode_amount, new Object[] { i.X(this.amount / 100.0D) }));
      this.OrJ.setOnClickListener(new ac()
      {
        public final void dsb()
        {
          AppMethodBeat.i(68183);
          RemittanceF2fDynamicCodeUI.a(RemittanceF2fDynamicCodeUI.this, 2);
          AppMethodBeat.o(68183);
        }
      });
      this.OrL.setOnLongClickListener(new RemittanceF2fDynamicCodeUI.5(this));
    }
    AppMethodBeat.o(68190);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool = true;
    AppMethodBeat.i(68194);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (gMW())
    {
      Log.i("MicroMsg.RemittanceF2fDynamicCodeUI", "onActivityResult requestCode:%s resultCode:%s %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent });
      if (paramInt1 == 1)
      {
        ub localub = new ub();
        ub.a locala = localub.hXP;
        if (paramInt2 == -1)
        {
          locala.hEn = bool;
          if (paramIntent == null) {
            break label140;
          }
        }
        label140:
        for (localub.hXP.hXQ = paramIntent.getIntExtra("key_pay_reslut_type", 3);; localub.hXP.hXQ = 3)
        {
          localub.publish();
          if (paramInt2 != -1) {
            break label152;
          }
          setResult(-1, paramIntent);
          finish();
          AppMethodBeat.o(68194);
          return;
          bool = false;
          break;
        }
        label152:
        if (ah.cq(paramIntent))
        {
          setResult(0, paramIntent);
          finish();
          AppMethodBeat.o(68194);
          return;
        }
        if (ah.cr(paramIntent))
        {
          AppMethodBeat.o(68194);
          return;
        }
        paramIntent = new hc();
        paramIntent.hHP.hHQ = false;
        paramIntent.publish();
      }
    }
    AppMethodBeat.o(68194);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(68189);
    super.onCreate(paramBundle);
    if (gMW())
    {
      if (getSupportActionBar() != null)
      {
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(a.c.remittance_busi_common_bg)));
        paramBundle = getSupportActionBar().getCustomView();
        if (paramBundle != null)
        {
          View localView = paramBundle.findViewById(a.f.divider);
          if (localView != null) {
            localView.setBackgroundColor(getResources().getColor(a.c.BW_0_Alpha_0_5));
          }
          paramBundle = paramBundle.findViewById(16908308);
          if ((paramBundle != null) && ((paramBundle instanceof TextView))) {
            ((TextView)paramBundle).setTextColor(getResources().getColor(a.c.normal_text_color));
          }
        }
      }
      if (Build.VERSION.SDK_INT >= 21)
      {
        paramBundle = getWindow();
        paramBundle.addFlags(-2147483648);
        paramBundle.setStatusBarColor(getResources().getColor(a.c.remittance_busi_common_bg));
      }
      if ((d.rb(21)) && (!d.rb(23))) {
        getWindow().setStatusBarColor(getContext().getResources().getColor(a.c.BW_93));
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
      }, a.h.back_icon_normal_black);
      addSceneEndListener(2736);
      setMMTitle(a.i.remittance_busi_pay);
      this.mPayInfo = ((PayInfo)getIntent().getParcelableExtra("key_pay_info"));
      if (this.mPayInfo == null)
      {
        Log.e("MicroMsg.RemittanceF2fDynamicCodeUI", "payinfo is null");
        finish();
      }
      setContentViewVisibility(4);
      this.amount = this.mPayInfo.nKf.getInt("extinfo_key_15");
      this.username = this.mPayInfo.nKf.getString("extinfo_key_1");
      this.MEL = this.mPayInfo.nKf.getString("extinfo_key_2");
      this.OrA = this.mPayInfo.nKf.getString("extinfo_key_17");
      this.OrB = this.mPayInfo.nKf.getString("extinfo_key_18");
      this.tlB = getIntent().getStringExtra("key_rcvr_open_id");
      this.OrC = getIntent().getStringExtra("key_mch_info");
      this.Orz = getIntent().getStringExtra("key_transfer_qrcode_id");
      this.xdD = getIntent().getStringExtra("key_mch_photo");
      this.OjY = getIntent().getStringExtra("show_paying_wording");
      this.OrD = getIntent().getStringExtra("dynamic_code_spam_wording");
      this.OrG = getIntent().getBooleanExtra("show_avatar_type", false);
      this.nickname = i.getDisplayName(this.username);
      initView();
    }
    AppMethodBeat.o(68189);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(68193);
    if (gMW()) {
      removeSceneEndListener(2736);
    }
    com.tencent.mm.platformtools.r.c(this.xdZ);
    super.onDestroy();
    AppMethodBeat.o(68193);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(68192);
    super.onPause();
    if (gMW())
    {
      this.OrS.stopTimer();
      Log.d("MicroMsg.RemittanceF2fDynamicCodeUI", "stop timer");
    }
    AppMethodBeat.o(68192);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(68191);
    super.onResume();
    f.gMD().jt(this);
    if (gMW())
    {
      l = System.currentTimeMillis();
      if (this.OrP > 0L) {
        break label120;
      }
    }
    label120:
    for (long l = 0L;; l = OrR - (l - this.OrP))
    {
      this.OrQ = l;
      Log.i("MicroMsg.RemittanceF2fDynamicCodeUI", "last time: %s, delay: %s", new Object[] { Long.valueOf(this.OrP), Long.valueOf(this.OrQ) });
      if (this.OrQ < 0L) {
        this.OrQ = 0L;
      }
      this.OrS.startTimer(this.OrQ, OrR);
      Log.d("MicroMsg.RemittanceF2fDynamicCodeUI", "start timer");
      AppMethodBeat.o(68191);
      return;
    }
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, p paramp)
  {
    AppMethodBeat.i(68195);
    if ((gMW()) && ((paramp instanceof q)))
    {
      this.OrO = false;
      paramString = (q)paramp;
      setContentViewVisibility(0);
      paramString.a(new com.tencent.mm.wallet_core.model.r.a()
      {
        public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
        {
          AppMethodBeat.i(68181);
          RemittanceF2fDynamicCodeUI.a(RemittanceF2fDynamicCodeUI.this, paramString.Ojd.wYJ);
          RemittanceF2fDynamicCodeUI.b(RemittanceF2fDynamicCodeUI.this, ah.aGs(paramString.Ojd.ZfZ));
          RemittanceF2fDynamicCodeUI.b(RemittanceF2fDynamicCodeUI.this, paramString.Ojd.ZfX);
          RemittanceF2fDynamicCodeUI.a(RemittanceF2fDynamicCodeUI.this, paramString.Ojd.ZfY);
          RemittanceF2fDynamicCodeUI.b(RemittanceF2fDynamicCodeUI.this);
          AppMethodBeat.o(68181);
        }
      }).b(new com.tencent.mm.wallet_core.model.r.a()
      {
        public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp) {}
      }).c(new com.tencent.mm.wallet_core.model.r.a()
      {
        public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp) {}
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceF2fDynamicCodeUI
 * JD-Core Version:    0.7.0.1
 */