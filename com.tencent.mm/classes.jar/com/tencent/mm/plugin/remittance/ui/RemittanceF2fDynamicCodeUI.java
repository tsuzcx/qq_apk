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
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.gg;
import com.tencent.mm.g.a.qs;
import com.tencent.mm.g.a.qs.a;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.aih;
import com.tencent.mm.protocal.protobuf.ug;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.wallet_core.c.ag;
import com.tencent.mm.wallet_core.c.r;
import com.tencent.mm.wallet_core.c.r.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import java.util.ArrayList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class RemittanceF2fDynamicCodeUI
  extends WalletBaseUI
{
  private static int yfB = 60000;
  private String drY;
  private String lTX;
  private PayInfo mPayInfo;
  private String nickname;
  private u.a pfJ;
  private int pfa;
  private String pfp;
  private String username;
  private int vls;
  private String wDc;
  private String xYL;
  private long yfA;
  private av yfC;
  private String yfj;
  private String yfk;
  private String yfl;
  private String yfm;
  private String yfn;
  private String yfo;
  private List<aih> yfp;
  private boolean yfq;
  private TextView yfr;
  private TextView yfs;
  private Button yft;
  private LinearLayout yfu;
  private ImageView yfv;
  private LinearLayout yfw;
  private WalletTextView yfx;
  private boolean yfy;
  private long yfz;
  
  public RemittanceF2fDynamicCodeUI()
  {
    AppMethodBeat.i(68188);
    this.yfp = new ArrayList();
    this.yfq = false;
    this.yfy = false;
    this.yfz = 0L;
    this.yfA = 0L;
    this.yfC = new av(new RemittanceF2fDynamicCodeUI.a(this, (byte)0), true);
    this.pfJ = new u.a()
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
          ad.i("MicroMsg.RemittanceF2fDynamicCodeUI", "cdnImageDownloadListener mchPhoto = %s notifyKey = %s", new Object[] { RemittanceF2fDynamicCodeUI.a(RemittanceF2fDynamicCodeUI.this), paramAnonymousString });
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
  
  private boolean dJQ()
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
    if (dJQ())
    {
      this.yfr = ((TextView)findViewById(2131304167));
      this.yfs = ((TextView)findViewById(2131304166));
      this.yft = ((Button)findViewById(2131304165));
      this.yfv = ((ImageView)findViewById(2131304163));
      this.yfu = ((LinearLayout)findViewById(2131304164));
      this.yfw = ((LinearLayout)findViewById(2131305142));
      this.yfx = ((WalletTextView)findViewById(2131303151));
      this.yfx.setText(getString(2131762528, new Object[] { com.tencent.mm.wallet_core.ui.e.D(this.vls / 100.0D) }));
      this.yft.setOnClickListener(new RemittanceF2fDynamicCodeUI.4(this));
      this.yfv.setOnLongClickListener(new RemittanceF2fDynamicCodeUI.5(this));
    }
    AppMethodBeat.o(68190);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool = true;
    AppMethodBeat.i(68194);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (dJQ())
    {
      ad.i("MicroMsg.RemittanceF2fDynamicCodeUI", "onActivityResult requestCode:%s resultCode:%s %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent });
      if (paramInt1 == 1)
      {
        qs localqs = new qs();
        qs.a locala = localqs.dFn;
        if (paramInt2 == -1)
        {
          locala.doF = bool;
          if (paramIntent == null) {
            break label143;
          }
        }
        label143:
        for (localqs.dFn.dFo = paramIntent.getIntExtra("key_pay_reslut_type", 3);; localqs.dFn.dFo = 3)
        {
          com.tencent.mm.sdk.b.a.IbL.l(localqs);
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
        if (ag.bw(paramIntent))
        {
          setResult(0, paramIntent);
          finish();
          AppMethodBeat.o(68194);
          return;
        }
        if (ag.bx(paramIntent))
        {
          AppMethodBeat.o(68194);
          return;
        }
        paramIntent = new gg();
        paramIntent.drV.drW = false;
        com.tencent.mm.sdk.b.a.IbL.l(paramIntent);
      }
    }
    AppMethodBeat.o(68194);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(68189);
    super.onCreate(paramBundle);
    if (dJQ())
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
      if ((d.ly(21)) && (!d.ly(23))) {
        getWindow().setStatusBarColor(getContext().getResources().getColor(2131099679));
      }
      setBackBtn(new RemittanceF2fDynamicCodeUI.3(this), 2131689727);
      addSceneEndListener(2736);
      setMMTitle(2131762434);
      this.mPayInfo = ((PayInfo)getIntent().getParcelableExtra("key_pay_info"));
      if (this.mPayInfo == null)
      {
        ad.e("MicroMsg.RemittanceF2fDynamicCodeUI", "payinfo is null");
        finish();
      }
      setContentViewVisibility(4);
      this.vls = this.mPayInfo.htZ.getInt("extinfo_key_15");
      this.username = this.mPayInfo.htZ.getString("extinfo_key_1");
      this.wDc = this.mPayInfo.htZ.getString("extinfo_key_2");
      this.yfk = this.mPayInfo.htZ.getString("extinfo_key_17");
      this.yfl = this.mPayInfo.htZ.getString("extinfo_key_18");
      this.lTX = getIntent().getStringExtra("key_rcvr_open_id");
      this.yfm = getIntent().getStringExtra("key_mch_info");
      this.yfj = getIntent().getStringExtra("key_transfer_qrcode_id");
      this.pfp = getIntent().getStringExtra("key_mch_photo");
      this.xYL = getIntent().getStringExtra("show_paying_wording");
      this.yfn = getIntent().getStringExtra("dynamic_code_spam_wording");
      this.yfq = getIntent().getBooleanExtra("show_avatar_type", false);
      this.nickname = com.tencent.mm.wallet_core.ui.e.zf(this.username);
      initView();
    }
    AppMethodBeat.o(68189);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(68193);
    if (dJQ()) {
      removeSceneEndListener(2736);
    }
    super.onDestroy();
    AppMethodBeat.o(68193);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(68192);
    super.onPause();
    if (dJQ())
    {
      this.yfC.stopTimer();
      ad.d("MicroMsg.RemittanceF2fDynamicCodeUI", "stop timer");
    }
    AppMethodBeat.o(68192);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(68191);
    super.onResume();
    e.dJC().gc(this);
    if (dJQ())
    {
      l = System.currentTimeMillis();
      if (this.yfz > 0L) {
        break label120;
      }
    }
    label120:
    for (long l = 0L;; l = yfB - (l - this.yfz))
    {
      this.yfA = l;
      ad.i("MicroMsg.RemittanceF2fDynamicCodeUI", "last time: %s, delay: %s", new Object[] { Long.valueOf(this.yfz), Long.valueOf(this.yfA) });
      if (this.yfA < 0L) {
        this.yfA = 0L;
      }
      this.yfC.az(this.yfA, yfB);
      ad.d("MicroMsg.RemittanceF2fDynamicCodeUI", "start timer");
      AppMethodBeat.o(68191);
      return;
    }
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(68195);
    if ((dJQ()) && ((paramn instanceof com.tencent.mm.plugin.remittance.model.n)))
    {
      this.yfy = false;
      paramString = (com.tencent.mm.plugin.remittance.model.n)paramn;
      setContentViewVisibility(0);
      paramString.a(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.n paramAnonymousn)
        {
          AppMethodBeat.i(68181);
          RemittanceF2fDynamicCodeUI.a(RemittanceF2fDynamicCodeUI.this, paramString.xYc.paB);
          RemittanceF2fDynamicCodeUI.b(RemittanceF2fDynamicCodeUI.this, ag.ago(paramString.xYc.FTC));
          RemittanceF2fDynamicCodeUI.b(RemittanceF2fDynamicCodeUI.this, paramString.xYc.FTA);
          RemittanceF2fDynamicCodeUI.a(RemittanceF2fDynamicCodeUI.this, paramString.xYc.FTB);
          RemittanceF2fDynamicCodeUI.b(RemittanceF2fDynamicCodeUI.this);
          AppMethodBeat.o(68181);
        }
      }).b(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.n paramAnonymousn) {}
      }).c(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.n paramAnonymousn) {}
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceF2fDynamicCodeUI
 * JD-Core Version:    0.7.0.1
 */