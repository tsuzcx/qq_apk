package com.tencent.mm.plugin.remittance.ui;

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
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.h.a.ft;
import com.tencent.mm.platformtools.x.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.c.wv;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.n;
import com.tencent.mm.wallet_core.c.n.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class RemittanceF2fDynamicCodeUI
  extends WalletBaseUI
{
  private static int nDN = 60000;
  private int amount;
  private String bMS;
  private String iLB;
  private x.a iLK = new RemittanceF2fDynamicCodeUI.1(this);
  private String mPw;
  private Button nBL;
  private String nDA;
  private String nDB;
  private List<wv> nDC = new ArrayList();
  private boolean nDD = false;
  private TextView nDE;
  private TextView nDF;
  private LinearLayout nDG;
  private ImageView nDH;
  private LinearLayout nDI;
  private WalletTextView nDJ;
  private boolean nDK = false;
  private long nDL = 0L;
  private long nDM = 0L;
  private am nDO = new am(new RemittanceF2fDynamicCodeUI.a(this, (byte)0), true);
  private PayInfo nDu;
  private String nDv;
  private String nDw;
  private String nDx;
  private String nDy;
  private String nDz;
  private String nickname;
  private String nyX;
  private String username;
  
  private boolean bwI()
  {
    return getIntent().getBooleanExtra("from_patch_ui", false);
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    if ((bwI()) && ((paramm instanceof com.tencent.mm.plugin.remittance.model.m)))
    {
      this.nDK = false;
      paramString = (com.tencent.mm.plugin.remittance.model.m)paramm;
      vN(0);
      paramString.a(new RemittanceF2fDynamicCodeUI.2(this, paramString)).b(new n.a()
      {
        public final void f(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ah.m paramAnonymousm) {}
      }).c(new RemittanceF2fDynamicCodeUI.9(this));
    }
    return true;
  }
  
  protected final int getLayoutId()
  {
    return a.g.remittance_f2f_dynamic_code_ui;
  }
  
  protected final void initView()
  {
    if (bwI())
    {
      this.nDE = ((TextView)findViewById(a.f.rfdc_supervision_tv));
      this.nDF = ((TextView)findViewById(a.f.rfdc_spam_tv));
      this.nBL = ((Button)findViewById(a.f.rfdc_pay_btn));
      this.nDH = ((ImageView)findViewById(a.f.rfdc_code_iv));
      this.nDG = ((LinearLayout)findViewById(a.f.rfdc_items_layout));
      this.nDI = ((LinearLayout)findViewById(a.f.spam_ll));
      this.nDJ = ((WalletTextView)findViewById(a.f.pay_fee_tv));
      this.nDJ.setText(getString(a.i.remittance_scan_qrcode_amount, new Object[] { e.B(this.amount / 100.0D) }));
      this.nBL.setOnClickListener(new RemittanceF2fDynamicCodeUI.4(this));
      this.nDH.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          RemittanceF2fDynamicCodeUI.d(RemittanceF2fDynamicCodeUI.this);
          return false;
        }
      });
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (bwI())
    {
      y.i("MicroMsg.RemittanceF2fDynamicCodeUI", "onActivityResult requestCode:%s resultCode:%s %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent });
      if (paramInt1 == 1)
      {
        if (paramInt2 != -1) {
          break label66;
        }
        setResult(-1, paramIntent);
        finish();
      }
    }
    return;
    label66:
    paramIntent = new ft();
    paramIntent.bMP.bMQ = false;
    com.tencent.mm.sdk.b.a.udP.m(paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (bwI())
    {
      if (getSupportActionBar() != null)
      {
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(a.c.remittance_busi_common_bg)));
        paramBundle = getSupportActionBar().getCustomView();
        if (paramBundle != null)
        {
          View localView = paramBundle.findViewById(a.f.divider);
          if (localView != null) {
            localView.setBackgroundColor(getResources().getColor(a.c.half_alpha_white));
          }
          paramBundle = paramBundle.findViewById(16908308);
          if ((paramBundle != null) && ((paramBundle instanceof TextView))) {
            ((TextView)paramBundle).setTextColor(getResources().getColor(a.c.black));
          }
        }
      }
      if (Build.VERSION.SDK_INT >= 21)
      {
        paramBundle = getWindow();
        paramBundle.addFlags(-2147483648);
        paramBundle.setStatusBarColor(getResources().getColor(a.c.remittance_busi_common_bg));
      }
      if (d.gF(21))
      {
        if (!d.gF(23)) {
          break label451;
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
          if (RemittanceF2fDynamicCodeUI.c(RemittanceF2fDynamicCodeUI.this))
          {
            RemittanceF2fDynamicCodeUI.this.XM();
            RemittanceF2fDynamicCodeUI.this.showDialog(1000);
          }
          for (;;)
          {
            return true;
            RemittanceF2fDynamicCodeUI.this.finish();
          }
        }
      }, a.h.back_icon_normal_black);
      kh(2736);
      setMMTitle(a.i.remittance_busi_pay);
      this.nDu = ((PayInfo)getIntent().getParcelableExtra("key_pay_info"));
      if (this.nDu == null)
      {
        y.e("MicroMsg.RemittanceF2fDynamicCodeUI", "payinfo is null");
        finish();
      }
      vN(4);
      this.amount = this.nDu.snX.getInt("extinfo_key_15");
      this.username = this.nDu.snX.getString("extinfo_key_1");
      this.mPw = this.nDu.snX.getString("extinfo_key_2");
      this.nDx = this.nDu.snX.getString("extinfo_key_17");
      this.nDy = this.nDu.snX.getString("extinfo_key_18");
      this.nDv = getIntent().getStringExtra("key_rcvr_open_id");
      this.nDz = getIntent().getStringExtra("key_mch_info");
      this.nDw = getIntent().getStringExtra("key_transfer_qrcode_id");
      this.iLB = getIntent().getStringExtra("key_mch_photo");
      this.nyX = getIntent().getStringExtra("show_paying_wording");
      this.nDA = getIntent().getStringExtra("dynamic_code_spam_wording");
      this.nDD = getIntent().getBooleanExtra("show_avatar_type", false);
      this.nickname = e.gV(this.username);
      initView();
      return;
      label451:
      getWindow().setStatusBarColor(Color.parseColor("#E5E5E5"));
    }
  }
  
  public void onDestroy()
  {
    if (bwI()) {
      ki(2736);
    }
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    if (bwI())
    {
      this.nDO.stopTimer();
      y.d("MicroMsg.RemittanceF2fDynamicCodeUI", "stop timer");
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (bwI())
    {
      l = System.currentTimeMillis();
      if (this.nDL > 0L) {
        break label103;
      }
    }
    label103:
    for (long l = 0L;; l = nDN - (l - this.nDL))
    {
      this.nDM = l;
      y.i("MicroMsg.RemittanceF2fDynamicCodeUI", "last time: %s, delay: %s", new Object[] { Long.valueOf(this.nDL), Long.valueOf(this.nDM) });
      if (this.nDM < 0L) {
        this.nDM = 0L;
      }
      this.nDO.S(this.nDM, nDN);
      y.d("MicroMsg.RemittanceF2fDynamicCodeUI", "start timer");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceF2fDynamicCodeUI
 * JD-Core Version:    0.7.0.1
 */