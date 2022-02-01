package com.tencent.mm.plugin.remittance.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.f.a.gr;
import com.tencent.mm.f.a.sm;
import com.tencent.mm.f.a.sm.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.remittance.model.p;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.amg;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.wallet_core.c.ag;
import com.tencent.mm.wallet_core.c.r;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.g;
import java.util.ArrayList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class RemittanceF2fDynamicCodeUI
  extends WalletBaseUI
{
  private static int Iuj = 60000;
  private String GHV;
  private String ImI;
  private String ItR;
  private String ItS;
  private String ItT;
  private String ItU;
  private String ItV;
  private String ItW;
  private List<amg> ItX;
  private boolean ItY;
  private TextView ItZ;
  private TextView Iua;
  private Button Iub;
  private LinearLayout Iuc;
  private ImageView Iud;
  private LinearLayout Iue;
  private WalletTextView Iuf;
  private boolean Iug;
  private long Iuh;
  private long Iui;
  private MTimerHandler Iuk;
  private int amount;
  private String fDd;
  private PayInfo mPayInfo;
  private String nickname;
  private String qgQ;
  private int tZW;
  private u.a uaH;
  private String ual;
  private String username;
  
  public RemittanceF2fDynamicCodeUI()
  {
    AppMethodBeat.i(68188);
    this.ItX = new ArrayList();
    this.ItY = false;
    this.Iug = false;
    this.Iuh = 0L;
    this.Iui = 0L;
    this.Iuk = new MTimerHandler(new a((byte)0), true);
    this.uaH = new u.a()
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
  
  private boolean fAX()
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
    if (fAX())
    {
      this.ItZ = ((TextView)findViewById(a.f.rfdc_supervision_tv));
      this.Iua = ((TextView)findViewById(a.f.rfdc_spam_tv));
      this.Iub = ((Button)findViewById(a.f.rfdc_pay_btn));
      this.Iud = ((ImageView)findViewById(a.f.rfdc_code_iv));
      this.Iuc = ((LinearLayout)findViewById(a.f.rfdc_items_layout));
      this.Iue = ((LinearLayout)findViewById(a.f.spam_ll));
      this.Iuf = ((WalletTextView)findViewById(a.f.pay_fee_tv));
      this.Iuf.setText(getString(a.i.remittance_scan_qrcode_amount, new Object[] { g.F(this.amount / 100.0D) }));
      this.Iub.setOnClickListener(new aa()
      {
        public final void cOw()
        {
          AppMethodBeat.i(68183);
          RemittanceF2fDynamicCodeUI.a(RemittanceF2fDynamicCodeUI.this, 2);
          AppMethodBeat.o(68183);
        }
      });
      this.Iud.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(68184);
          b localb = new b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/remittance/ui/RemittanceF2fDynamicCodeUI$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aFi());
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
    if (fAX())
    {
      Log.i("MicroMsg.RemittanceF2fDynamicCodeUI", "onActivityResult requestCode:%s resultCode:%s %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent });
      if (paramInt1 == 1)
      {
        sm localsm = new sm();
        sm.a locala = localsm.fRU;
        if (paramInt2 == -1)
        {
          locala.fzO = bool;
          if (paramIntent == null) {
            break label143;
          }
        }
        label143:
        for (localsm.fRU.fRV = paramIntent.getIntExtra("key_pay_reslut_type", 3);; localsm.fRU.fRV = 3)
        {
          EventCenter.instance.publish(localsm);
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
        if (ag.bL(paramIntent))
        {
          setResult(0, paramIntent);
          finish();
          AppMethodBeat.o(68194);
          return;
        }
        if (ag.bM(paramIntent))
        {
          AppMethodBeat.o(68194);
          return;
        }
        paramIntent = new gr();
        paramIntent.fDa.fDb = false;
        EventCenter.instance.publish(paramIntent);
      }
    }
    AppMethodBeat.o(68194);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(68189);
    super.onCreate(paramBundle);
    if (fAX())
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
      if ((d.qV(21)) && (!d.qV(23))) {
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
      this.amount = this.mPayInfo.lfu.getInt("extinfo_key_15");
      this.username = this.mPayInfo.lfu.getString("extinfo_key_1");
      this.GHV = this.mPayInfo.lfu.getString("extinfo_key_2");
      this.ItS = this.mPayInfo.lfu.getString("extinfo_key_17");
      this.ItT = this.mPayInfo.lfu.getString("extinfo_key_18");
      this.qgQ = getIntent().getStringExtra("key_rcvr_open_id");
      this.ItU = getIntent().getStringExtra("key_mch_info");
      this.ItR = getIntent().getStringExtra("key_transfer_qrcode_id");
      this.ual = getIntent().getStringExtra("key_mch_photo");
      this.ImI = getIntent().getStringExtra("show_paying_wording");
      this.ItV = getIntent().getStringExtra("dynamic_code_spam_wording");
      this.ItY = getIntent().getBooleanExtra("show_avatar_type", false);
      this.nickname = g.PJ(this.username);
      initView();
    }
    AppMethodBeat.o(68189);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(68193);
    if (fAX()) {
      removeSceneEndListener(2736);
    }
    u.c(this.uaH);
    super.onDestroy();
    AppMethodBeat.o(68193);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(68192);
    super.onPause();
    if (fAX())
    {
      this.Iuk.stopTimer();
      Log.d("MicroMsg.RemittanceF2fDynamicCodeUI", "stop timer");
    }
    AppMethodBeat.o(68192);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(68191);
    super.onResume();
    e.fAJ().fB(this);
    if (fAX())
    {
      l = System.currentTimeMillis();
      if (this.Iuh > 0L) {
        break label120;
      }
    }
    label120:
    for (long l = 0L;; l = Iuj - (l - this.Iuh))
    {
      this.Iui = l;
      Log.i("MicroMsg.RemittanceF2fDynamicCodeUI", "last time: %s, delay: %s", new Object[] { Long.valueOf(this.Iuh), Long.valueOf(this.Iui) });
      if (this.Iui < 0L) {
        this.Iui = 0L;
      }
      this.Iuk.startTimer(this.Iui, Iuj);
      Log.d("MicroMsg.RemittanceF2fDynamicCodeUI", "start timer");
      AppMethodBeat.o(68191);
      return;
    }
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(68195);
    if ((fAX()) && ((paramq instanceof p)))
    {
      this.Iug = false;
      paramString = (p)paramq;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceF2fDynamicCodeUI
 * JD-Core Version:    0.7.0.1
 */