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
import com.tencent.mm.g.a.gd;
import com.tencent.mm.g.a.qh;
import com.tencent.mm.g.a.qh.a;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.afr;
import com.tencent.mm.protocal.protobuf.sl;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.w;
import com.tencent.mm.ui.widget.a.e.b;
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
  private static int wRT = 60000;
  private String dgC;
  private String luO;
  private PayInfo mPayInfo;
  private String nickname;
  private int oBF;
  private String oBU;
  private u.a oCo;
  private int uiK;
  private String username;
  private String vxI;
  private String wLe;
  private String wRB;
  private String wRC;
  private String wRD;
  private String wRE;
  private String wRF;
  private String wRG;
  private List<afr> wRH;
  private boolean wRI;
  private TextView wRJ;
  private TextView wRK;
  private Button wRL;
  private LinearLayout wRM;
  private ImageView wRN;
  private LinearLayout wRO;
  private WalletTextView wRP;
  private boolean wRQ;
  private long wRR;
  private long wRS;
  private au wRU;
  
  public RemittanceF2fDynamicCodeUI()
  {
    AppMethodBeat.i(68188);
    this.wRH = new ArrayList();
    this.wRI = false;
    this.wRQ = false;
    this.wRR = 0L;
    this.wRS = 0L;
    this.wRU = new au(new a((byte)0), true);
    this.oCo = new u.a()
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
          ac.i("MicroMsg.RemittanceF2fDynamicCodeUI", "cdnImageDownloadListener mchPhoto = %s notifyKey = %s", new Object[] { RemittanceF2fDynamicCodeUI.a(RemittanceF2fDynamicCodeUI.this), paramAnonymousString });
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
  
  private boolean dyy()
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
    if (dyy())
    {
      this.wRJ = ((TextView)findViewById(2131304167));
      this.wRK = ((TextView)findViewById(2131304166));
      this.wRL = ((Button)findViewById(2131304165));
      this.wRN = ((ImageView)findViewById(2131304163));
      this.wRM = ((LinearLayout)findViewById(2131304164));
      this.wRO = ((LinearLayout)findViewById(2131305142));
      this.wRP = ((WalletTextView)findViewById(2131303151));
      this.wRP.setText(getString(2131762528, new Object[] { com.tencent.mm.wallet_core.ui.e.D(this.uiK / 100.0D) }));
      this.wRL.setOnClickListener(new w()
      {
        public final void bWk()
        {
          AppMethodBeat.i(68183);
          RemittanceF2fDynamicCodeUI.a(RemittanceF2fDynamicCodeUI.this, 2);
          AppMethodBeat.o(68183);
        }
      });
      this.wRN.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(68184);
          RemittanceF2fDynamicCodeUI.d(RemittanceF2fDynamicCodeUI.this);
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
    if (dyy())
    {
      ac.i("MicroMsg.RemittanceF2fDynamicCodeUI", "onActivityResult requestCode:%s resultCode:%s %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent });
      if (paramInt1 == 1)
      {
        qh localqh = new qh();
        qh.a locala = localqh.dtl;
        if (paramInt2 == -1)
        {
          locala.ddj = bool;
          if (paramIntent == null) {
            break label143;
          }
        }
        label143:
        for (localqh.dtl.dtm = paramIntent.getIntExtra("key_pay_reslut_type", 3);; localqh.dtl.dtm = 3)
        {
          com.tencent.mm.sdk.b.a.GpY.l(localqh);
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
        if (ag.br(paramIntent))
        {
          setResult(0, paramIntent);
          finish();
          AppMethodBeat.o(68194);
          return;
        }
        if (ag.bs(paramIntent))
        {
          AppMethodBeat.o(68194);
          return;
        }
        paramIntent = new gd();
        paramIntent.dgz.dgA = false;
        com.tencent.mm.sdk.b.a.GpY.l(paramIntent);
      }
    }
    AppMethodBeat.o(68194);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(68189);
    super.onCreate(paramBundle);
    if (dyy())
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
      if ((d.kZ(21)) && (!d.kZ(23))) {
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
        ac.e("MicroMsg.RemittanceF2fDynamicCodeUI", "payinfo is null");
        finish();
      }
      setContentViewVisibility(4);
      this.uiK = this.mPayInfo.hbR.getInt("extinfo_key_15");
      this.username = this.mPayInfo.hbR.getString("extinfo_key_1");
      this.vxI = this.mPayInfo.hbR.getString("extinfo_key_2");
      this.wRC = this.mPayInfo.hbR.getString("extinfo_key_17");
      this.wRD = this.mPayInfo.hbR.getString("extinfo_key_18");
      this.luO = getIntent().getStringExtra("key_rcvr_open_id");
      this.wRE = getIntent().getStringExtra("key_mch_info");
      this.wRB = getIntent().getStringExtra("key_transfer_qrcode_id");
      this.oBU = getIntent().getStringExtra("key_mch_photo");
      this.wLe = getIntent().getStringExtra("show_paying_wording");
      this.wRF = getIntent().getStringExtra("dynamic_code_spam_wording");
      this.wRI = getIntent().getBooleanExtra("show_avatar_type", false);
      this.nickname = com.tencent.mm.wallet_core.ui.e.wk(this.username);
      initView();
    }
    AppMethodBeat.o(68189);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(68193);
    if (dyy()) {
      removeSceneEndListener(2736);
    }
    super.onDestroy();
    AppMethodBeat.o(68193);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(68192);
    super.onPause();
    if (dyy())
    {
      this.wRU.stopTimer();
      ac.d("MicroMsg.RemittanceF2fDynamicCodeUI", "stop timer");
    }
    AppMethodBeat.o(68192);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(68191);
    super.onResume();
    e.dyk().fX(this);
    if (dyy())
    {
      l = System.currentTimeMillis();
      if (this.wRR > 0L) {
        break label120;
      }
    }
    label120:
    for (long l = 0L;; l = wRT - (l - this.wRR))
    {
      this.wRS = l;
      ac.i("MicroMsg.RemittanceF2fDynamicCodeUI", "last time: %s, delay: %s", new Object[] { Long.valueOf(this.wRR), Long.valueOf(this.wRS) });
      if (this.wRS < 0L) {
        this.wRS = 0L;
      }
      this.wRU.au(this.wRS, wRT);
      ac.d("MicroMsg.RemittanceF2fDynamicCodeUI", "start timer");
      AppMethodBeat.o(68191);
      return;
    }
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(68195);
    if ((dyy()) && ((paramn instanceof com.tencent.mm.plugin.remittance.model.n)))
    {
      this.wRQ = false;
      paramString = (com.tencent.mm.plugin.remittance.model.n)paramn;
      setContentViewVisibility(0);
      paramString.a(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn)
        {
          AppMethodBeat.i(68181);
          RemittanceF2fDynamicCodeUI.a(RemittanceF2fDynamicCodeUI.this, paramString.wKv.oxg);
          RemittanceF2fDynamicCodeUI.b(RemittanceF2fDynamicCodeUI.this, ag.adO(paramString.wKv.Emt));
          RemittanceF2fDynamicCodeUI.b(RemittanceF2fDynamicCodeUI.this, paramString.wKv.Emr);
          RemittanceF2fDynamicCodeUI.a(RemittanceF2fDynamicCodeUI.this, paramString.wKv.Ems);
          RemittanceF2fDynamicCodeUI.b(RemittanceF2fDynamicCodeUI.this);
          AppMethodBeat.o(68181);
        }
      }).b(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn) {}
      }).c(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn) {}
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
    implements au.a
  {
    private a() {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(68187);
      ac.d("MicroMsg.RemittanceF2fDynamicCodeUI", "timer expired");
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