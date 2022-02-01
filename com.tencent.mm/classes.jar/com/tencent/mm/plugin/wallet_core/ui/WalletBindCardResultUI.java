package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.adb;
import com.tencent.mm.autogen.a.na;
import com.tencent.mm.autogen.a.na.a;
import com.tencent.mm.autogen.a.zp;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wallet_core.model.BindCardOrder;
import com.tencent.mm.plugin.wallet_core.model.s.a;
import com.tencent.mm.plugin.wallet_core.model.s.b;
import com.tencent.mm.plugin.wxpay.a.b;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.e;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.i;
import java.util.HashMap;

@com.tencent.mm.ui.base.a(3)
public class WalletBindCardResultUI
  extends WalletBaseUI
{
  private String MCK;
  private String MCL;
  private IListener MCd;
  private String MFC;
  private String OqR;
  private TextView OsL;
  private ViewGroup Urc;
  private int VGE;
  private boolean VMA;
  private e VMB;
  private BindCardOrder VMi;
  private boolean VMj;
  private s.b VMk;
  private WalletOrderInfoNewUI.b VMl;
  private HashMap<String, WalletOrderInfoNewUI.a> VMm;
  private String VMn;
  private BindCardOrder VMo;
  private String VMp;
  private Button VMq;
  private ImageView VMr;
  private ViewGroup VMs;
  private CdnImageView VMt;
  private TextView VMu;
  private TextView VMv;
  private View VMw;
  private Button VMx;
  private boolean VMy;
  private boolean VMz;
  private PayInfo mPayInfo;
  
  public WalletBindCardResultUI()
  {
    AppMethodBeat.i(70755);
    this.MFC = null;
    this.VMj = false;
    this.VMm = new HashMap();
    this.VMo = null;
    this.VMp = "-1";
    this.VMy = false;
    this.VMz = false;
    this.VMA = false;
    this.MCd = new IListener(f.hfK) {};
    AppMethodBeat.o(70755);
  }
  
  private void aiT(String paramString)
  {
    AppMethodBeat.i(70762);
    ikB();
    i.p(this, paramString, false);
    AppMethodBeat.o(70762);
  }
  
  private void ikA()
  {
    AppMethodBeat.i(70761);
    this.VMs.setVisibility(4);
    this.VMz = false;
    this.VMy = false;
    if (this.VMi != null) {
      if (this.VMi.VEu != null)
      {
        Log.i("MicroMsg.WalletBindCardResultUI", "activityPromotions: %s", new Object[] { this.VMo });
        if ((this.VMi == null) || ((!this.VMi.iic()) && (!this.VMi.iie())) || (this.VMi.VEu.ehe <= 0L) || (Util.isNullOrNil(this.VMi.VEv.VGz))) {
          break label854;
        }
        this.VMo = this.VMi;
        this.VMw.setVisibility(8);
        this.VMt.setRoundCorner(true);
        this.VMx.setEnabled(true);
        this.VMx.setBackgroundResource(a.e.btn_solid_green);
        this.VMv.setCompoundDrawables(null, null, null, null);
        localObject = (WalletOrderInfoNewUI.a)this.VMm.get(this.VMo.VEu.ehe);
        if (localObject == null) {
          break label639;
        }
        if (!Util.isNullOrNil(((WalletOrderInfoNewUI.a)localObject).icon)) {
          this.VMt.setUrl(((WalletOrderInfoNewUI.a)localObject).icon);
        }
        if (!Util.isNullOrNil(((WalletOrderInfoNewUI.a)localObject).wording)) {
          this.VMu.setText(((WalletOrderInfoNewUI.a)localObject).wording);
        }
        if (!Util.isNullOrNil(((WalletOrderInfoNewUI.a)localObject).VQT))
        {
          this.VMx.setText(((WalletOrderInfoNewUI.a)localObject).VQT);
          this.VMx.setBackgroundResource(a.e.wallet_order_info_solid_green_disabled);
        }
        localLayoutParams = (RelativeLayout.LayoutParams)this.VMv.getLayoutParams();
        if ((localObject == null) || (Util.isNullOrNil(((WalletOrderInfoNewUI.a)localObject).title))) {
          break label693;
        }
        this.VMv.setText(((WalletOrderInfoNewUI.a)localObject).title);
        localLayoutParams.addRule(15, 0);
        this.VMv.setLayoutParams(localLayoutParams);
        this.VMx.setVisibility(0);
        this.VMx.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
        {
          public final void dr(View paramAnonymousView)
          {
            AppMethodBeat.i(301290);
            Log.i("MicroMsg.WalletBindCardResultUI", "click activity button");
            WalletBindCardResultUI.b(WalletBindCardResultUI.this);
            AppMethodBeat.o(301290);
          }
        });
        if (this.VMo.VEu.VGu != 1L) {
          this.VMs.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(70751);
              b localb = new b();
              localb.cH(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletBindCardResultUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
              Log.i("MicroMsg.WalletBindCardResultUI", "click activity layout");
              WalletBindCardResultUI.b(WalletBindCardResultUI.this);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletBindCardResultUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(70751);
            }
          });
        }
        localObject = this.VMp;
        i = -1;
        switch (((String)localObject).hashCode())
        {
        default: 
          switch (i)
          {
          default: 
            localObject = this.VMu.getText();
            if ((!Util.isNullOrNil((CharSequence)localObject)) && (((CharSequence)localObject).length() > 9))
            {
              this.VMu.setText(((CharSequence)localObject).subSequence(0, 9));
              this.VMu.append("...");
            }
            localObject = (ViewGroup.MarginLayoutParams)this.VMs.getLayoutParams();
            ((ViewGroup.MarginLayoutParams)localObject).topMargin = com.tencent.mm.cd.a.fromDPToPix(this, 50);
            this.VMs.setLayoutParams((ViewGroup.LayoutParams)localObject);
            this.VMs.setVisibility(0);
          }
          break;
        }
      }
    }
    label639:
    while ((this.VMi.VEw == null) || (Util.isNullOrNil(this.VMi.VEw.VcU)) || (!this.VMi.iid())) {
      for (;;)
      {
        RelativeLayout.LayoutParams localLayoutParams;
        int i;
        if (this.VMu.getVisibility() == 0) {
          this.VMu.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(70753);
              if ((WalletBindCardResultUI.g(WalletBindCardResultUI.this).getVisibility() == 0) && (WalletBindCardResultUI.h(WalletBindCardResultUI.this).getRight() >= WalletBindCardResultUI.g(WalletBindCardResultUI.this).getLeft()) && (!Util.isNullOrNil(WalletBindCardResultUI.h(WalletBindCardResultUI.this).getText())))
              {
                float f1 = WalletBindCardResultUI.h(WalletBindCardResultUI.this).getTextSize();
                Log.i("MicroMsg.WalletBindCardResultUI", "tinyAppDescTv size exceed, tinyAppDescTv.getRight(): %s, tinyAppButton.getLeft(): %s", new Object[] { Integer.valueOf(WalletBindCardResultUI.h(WalletBindCardResultUI.this).getRight()), Integer.valueOf(WalletBindCardResultUI.g(WalletBindCardResultUI.this).getLeft()) });
                Paint localPaint = new Paint();
                localPaint.setTextSize(f1);
                String str = WalletBindCardResultUI.h(WalletBindCardResultUI.this).getText().toString();
                f1 = localPaint.measureText(str);
                float f2 = WalletBindCardResultUI.h(WalletBindCardResultUI.this).getRight() - WalletBindCardResultUI.g(WalletBindCardResultUI.this).getLeft();
                int i = 1;
                while ((localPaint.measureText(str.substring(0, str.length() - i - 1)) > f1 - f2) && (i <= str.length() - 1)) {
                  i += 1;
                }
                Log.i("MicroMsg.WalletBindCardResultUI", "tinyAppDescTv, exceed len, final search count: %s, text.length: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(str.length()) });
                WalletBindCardResultUI.h(WalletBindCardResultUI.this).setText(str.substring(0, str.length() - i - 1));
                WalletBindCardResultUI.h(WalletBindCardResultUI.this).append("...");
              }
              AppMethodBeat.o(70753);
            }
          });
        }
        if (this.VMs.getVisibility() == 8)
        {
          localObject = (ViewGroup.MarginLayoutParams)this.VMr.getLayoutParams();
          ((ViewGroup.MarginLayoutParams)localObject).topMargin = com.tencent.mm.cd.a.fromDPToPix(this, 91);
          this.VMr.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        AppMethodBeat.o(70761);
        return;
        this.VMt.setUrl(this.VMi.VEv.MRI);
        this.VMu.setText(this.VMi.VEv.name);
        this.VMx.setText(this.VMi.VEv.VGz);
        continue;
        if (!Util.isNullOrNil(this.VMi.VEv.title))
        {
          this.VMv.setText(this.VMi.VEv.title);
          localLayoutParams.addRule(15, 0);
        }
        else
        {
          this.VMv.setVisibility(8);
          localLayoutParams.addRule(15, -1);
          continue;
          if (((String)localObject).equals("0"))
          {
            i = 0;
            continue;
            if (((String)localObject).equals("-1"))
            {
              i = 1;
              continue;
              if (((String)localObject).equals("3"))
              {
                i = 2;
                continue;
                if (((String)localObject).equals("4"))
                {
                  i = 3;
                  continue;
                  if (((String)localObject).equals("2"))
                  {
                    i = 4;
                    continue;
                    if (((String)localObject).equals("1"))
                    {
                      i = 5;
                      continue;
                      this.VMx.setEnabled(false);
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    label693:
    label854:
    this.MCK = this.VMi.VEw.VcU;
    this.MCL = this.VMi.VEw.VcV;
    this.VGE = this.VMi.VEw.VGE;
    this.VMk = this.VMi.VEw;
    this.VMt.setUrl(this.VMi.VEw.VGB);
    this.VMu.setText(this.VMi.VEw.VGC);
    this.VMv.setText(getString(a.i.wallet_app_brand_entrance));
    this.VMv.setVisibility(0);
    this.VMt.setRoundCorner(true);
    this.VMx.setEnabled(true);
    this.VMx.setBackgroundResource(a.e.btn_solid_green);
    Object localObject = (RelativeLayout.LayoutParams)this.VMv.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).addRule(15, 0);
    this.VMv.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (this.VMi.VEu.ehe > 0L)
    {
      if (!Util.isNullOrNil(this.VMi.VEw.VGD))
      {
        this.VMx.setVisibility(0);
        this.VMx.setText(this.VMi.VEw.VGD);
        this.VMw.setVisibility(8);
      }
      localObject = (WalletOrderInfoNewUI.a)this.VMm.get(this.VMi.VEu.ehe);
      if (localObject != null)
      {
        if (!Util.isNullOrNil(((WalletOrderInfoNewUI.a)localObject).VGB)) {
          this.VMt.setUrl(((WalletOrderInfoNewUI.a)localObject).VGB);
        }
        if (!Util.isNullOrNil(((WalletOrderInfoNewUI.a)localObject).VGC)) {
          this.VMu.setText(((WalletOrderInfoNewUI.a)localObject).VGC);
        }
        if (!Util.isNullOrNil(((WalletOrderInfoNewUI.a)localObject).VGD))
        {
          this.VMx.setText(((WalletOrderInfoNewUI.a)localObject).VGD);
          this.VMx.setBackgroundResource(a.e.wallet_order_info_solid_green_disabled);
        }
        if (!Util.isNullOrNil(((WalletOrderInfoNewUI.a)localObject).VcU)) {
          this.MCK = ((WalletOrderInfoNewUI.a)localObject).VcU;
        }
        if (!Util.isNullOrNil(((WalletOrderInfoNewUI.a)localObject).VcV)) {
          this.MCL = ((WalletOrderInfoNewUI.a)localObject).VcV;
        }
      }
    }
    for (;;)
    {
      localObject = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(70752);
          b localb = new b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletBindCardResultUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          Log.i("MicroMsg.WalletBindCardResultUI", "click tiny app, userName: %s, path: %s, version: %s", new Object[] { WalletBindCardResultUI.c(WalletBindCardResultUI.this), WalletBindCardResultUI.d(WalletBindCardResultUI.this), Integer.valueOf(WalletBindCardResultUI.e(WalletBindCardResultUI.this)) });
          WalletBindCardResultUI.this.sK(2);
          paramAnonymousView = new zp();
          paramAnonymousView.icM.userName = WalletBindCardResultUI.c(WalletBindCardResultUI.this);
          paramAnonymousView.icM.icO = Util.nullAs(WalletBindCardResultUI.d(WalletBindCardResultUI.this), "");
          paramAnonymousView.icM.scene = 1034;
          paramAnonymousView.icM.icP = 0;
          if (WalletBindCardResultUI.e(WalletBindCardResultUI.this) > 0) {
            paramAnonymousView.icM.appVersion = WalletBindCardResultUI.e(WalletBindCardResultUI.this);
          }
          paramAnonymousView.publish();
          if ((!Util.isNullOrNil(WalletBindCardResultUI.f(WalletBindCardResultUI.this).VEw.VGD)) && (WalletBindCardResultUI.f(WalletBindCardResultUI.this).VEu.ehe > 0L)) {
            WalletBindCardResultUI.a(WalletBindCardResultUI.this, true);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletBindCardResultUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(70752);
            return;
            WalletBindCardResultUI.a(WalletBindCardResultUI.this, false);
          }
        }
      };
      this.VMs.setOnClickListener((View.OnClickListener)localObject);
      this.VMx.setOnClickListener((View.OnClickListener)localObject);
      localObject = this.VMu.getText();
      if ((Util.isNullOrNil((CharSequence)localObject)) || (((CharSequence)localObject).length() <= 9)) {
        break;
      }
      this.VMu.setText(((CharSequence)localObject).subSequence(0, 9));
      this.VMu.append("...");
      break;
      this.VMx.setVisibility(8);
      this.VMw.setVisibility(8);
    }
  }
  
  private void ikB()
  {
    int i = 0;
    AppMethodBeat.i(70768);
    if (!this.VMj)
    {
      na localna = new na();
      localna.hPl.hPm = 4;
      na.a locala = localna.hPl;
      if (getInput().getBoolean("intent_pay_end", false)) {
        i = -1;
      }
      locala.resultCode = i;
      localna.publish();
      this.VMj = true;
    }
    AppMethodBeat.o(70768);
  }
  
  private void iky()
  {
    AppMethodBeat.i(70759);
    this.Urc.setVisibility(0);
    AppMethodBeat.o(70759);
  }
  
  private void ikz()
  {
    AppMethodBeat.i(70760);
    this.OsL.setText(this.VMi.VEo);
    AppMethodBeat.o(70760);
  }
  
  public final void done()
  {
    AppMethodBeat.i(70765);
    Bundle localBundle = new Bundle();
    if (this.VMB != null)
    {
      this.VMB.a(this, 0, localBundle);
      AppMethodBeat.o(70765);
      return;
    }
    finish();
    AppMethodBeat.o(70765);
  }
  
  public int getLayoutId()
  {
    return a.g.wallet_bind_card_result_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(70758);
    if (getSupportActionBar() != null) {
      getSupportActionBar().hide();
    }
    this.VMr = ((ImageView)findViewById(a.f.wxpay_logo_iv));
    this.OsL = ((TextView)findViewById(a.f.pay_succ_wording));
    this.VMq = ((Button)findViewById(a.f.pay_finish_button));
    showHomeBtn(false);
    enableBackMenu(false);
    String str = getString(a.i.app_finish);
    if ((this.VMi != null) && (!Util.isNullOrNil(this.VMi.VEn))) {
      this.VMq.setText(this.VMi.VEn);
    }
    for (;;)
    {
      this.VMq.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
      {
        public final void dr(View paramAnonymousView)
        {
          AppMethodBeat.i(301291);
          WalletBindCardResultUI.this.done();
          AppMethodBeat.o(301291);
        }
      });
      this.Urc = ((ViewGroup)findViewById(a.f.wallet_order_info_bottom_layout));
      this.VMs = ((ViewGroup)findViewById(a.f.tinyapp_info_layout));
      this.VMt = ((CdnImageView)findViewById(a.f.tinyapp_logo_iv));
      this.VMt.setUseSdcardCache(true);
      this.VMu = ((TextView)findViewById(a.f.tinyapp_desc_tv));
      this.VMv = ((TextView)findViewById(a.f.tinyapp_name_tv));
      this.VMx = ((Button)findViewById(a.f.tinyapp_button));
      this.VMw = findViewById(a.f.tinyapp_info_touch_mask);
      this.Urc.setVisibility(4);
      ikz();
      ikA();
      iky();
      if ((!Util.isNullOrNil(this.VMi.VEp)) && (!Util.isNullOrNil(this.VMi.VEq))) {
        ((TextView)findViewById(a.f.pay_succ_wording_tip)).setText(getString(a.i.wallet_bind_card_info_tip, new Object[] { this.VMi.VEp, this.VMi.VEq }));
      }
      AppMethodBeat.o(70758);
      return;
      this.VMq.setText(str);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(70763);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Log.i("MicroMsg.WalletBindCardResultUI", "onActivityResult %d %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 1)
    {
      Log.i("MicroMsg.WalletBindCardResultUI", "do query pay arawrd");
      doSceneProgress(new ad(this.VMl.Vyi, this.VMl.VQV, this.VMl.VQW, this.VMl.VQX, this.VMl.VIF, this.VMl.VQY, this.VMi.hAk, this.VMi.VEr, this.VMi.VEs, this.VMi.VEs));
    }
    AppMethodBeat.o(70763);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(70756);
    super.onCreate(paramBundle);
    if (d.rb(21))
    {
      if (!d.rb(23)) {
        break label168;
      }
      getWindow().setStatusBarColor(getResources().getColor(a.c.white));
    }
    for (;;)
    {
      setContentViewVisibility(4);
      com.tencent.mm.wallet_core.a.cm(this);
      this.mPayInfo = ((PayInfo)getInput().getParcelable("key_pay_info"));
      getInput().getInt("key_pay_type", -1);
      BindCardOrder localBindCardOrder = (BindCardOrder)getInput().getParcelable("key_bindcard_value_result");
      paramBundle = localBindCardOrder;
      if (localBindCardOrder == null) {
        paramBundle = new BindCardOrder();
      }
      this.VMi = paramBundle;
      setContentViewVisibility(0);
      initView();
      this.VMB = getProcess();
      ikz();
      sK(1);
      addSceneEndListener(1979);
      this.MCd.alive();
      this.VMA = true;
      AppMethodBeat.o(70756);
      return;
      label168:
      getWindow().setStatusBarColor(getResources().getColor(a.c.BW_90));
    }
  }
  
  @Deprecated
  public Dialog onCreateDialog(int paramInt)
  {
    AppMethodBeat.i(70764);
    Dialog localDialog = com.tencent.mm.ui.base.k.a(getContext(), getString(a.i.wallet_order_info_phone), getResources().getStringArray(a.b.wallet_phone_call), "", new WalletBindCardResultUI.7(this));
    AppMethodBeat.o(70764);
    return localDialog;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(70767);
    super.onDestroy();
    this.MCd.dead();
    removeSceneEndListener(1979);
    AppMethodBeat.o(70767);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(70766);
    if (paramInt == 4)
    {
      done();
      AppMethodBeat.o(70766);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(70766);
    return bool;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(70757);
    super.onResume();
    Log.i("MicroMsg.WalletBindCardResultUI", "onResume, isFirstInit: %s activityPromotions: %s, isClickTinyappActivity: %s, isClickActivity: %s, recommendTinyAppInfo: %s", new Object[] { Boolean.valueOf(this.VMA), this.VMo, Boolean.valueOf(this.VMy), Boolean.valueOf(this.VMz), this.VMk });
    if (this.VMA)
    {
      this.VMA = false;
      AppMethodBeat.o(70757);
      return;
    }
    if ((this.VMo != null) && (this.VMz))
    {
      doSceneProgress(new ad(this.VMo.VEu.ehe, this.VMo.VEu.VGv, this.VMo.VEu.VGw, this.VMo.VEu.VGx, this.VMo.VEu.VGu, this.VMo.VEu.VGy, this.VMi.hAk, this.VMi.VEr, this.VMi.VEs, this.VMi.VEs));
      AppMethodBeat.o(70757);
      return;
    }
    if ((this.VMy) && (this.VMk != null)) {
      doSceneProgress(new ad(this.VMi.VEu.ehe, this.VMi.VEu.VGv, this.VMi.VEu.VGw, this.VMi.VEu.VGx, this.VMi.VEu.VGy, this.VMi.VEu.VGu, this.VMi.hAk, this.VMi.VEr, this.VMi.VEs, this.VMi.VEs));
    }
    AppMethodBeat.o(70757);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(70769);
    if ((paramp instanceof ad)) {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (ad)paramp;
        paramp = new WalletOrderInfoNewUI.a(paramString.rwB);
        if (this.VMl == null) {
          break label78;
        }
        this.VMm.put(paramString.Vyi, paramp);
        ikA();
        iky();
      }
    }
    label78:
    while (!(paramp instanceof com.tencent.mm.plugin.wallet_core.c.s)) {
      for (;;)
      {
        AppMethodBeat.o(70769);
        return false;
        if (this.VMy)
        {
          this.VMm.put(paramString.Vyi, paramp);
          ikA();
          iky();
        }
      }
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = (com.tencent.mm.plugin.wallet_core.c.s)paramp;
      paramp = paramString.VxR;
      if ((this.VMo != null) && (this.VMo.VEu.ehe == paramString.VxT.VEu.ehe))
      {
        Log.i("MicroMsg.WalletBindCardResultUI", "activityAwardState: %s", new Object[] { this.VMo });
        this.VMp = paramp;
        ikA();
        iky();
        if ((!Util.isNullOrNil(paramString.resultMsg)) && (!"3".equals(paramp))) {
          this.VMx.setText(paramString.resultMsg);
        }
      }
      if ((!"-1".equals(paramp)) && (!"0".equals(paramp)) && (!Util.isNullOrNil(paramString.VxS))) {
        com.tencent.mm.ui.base.k.c(this, paramString.VxS, "", true);
      }
      while (!"0".equals(paramp))
      {
        AppMethodBeat.o(70769);
        return true;
      }
      if (!Util.isNullOrNil(paramString.VxS)) {}
      for (paramString = paramString.VxS;; paramString = getString(a.i.wallet_pay_award_got))
      {
        Toast.makeText(this, paramString, 0).show();
        break;
      }
    }
    paramp = paramString;
    if (Util.isNullOrNil(paramString)) {
      paramp = getString(a.i.wallet_unknown_err);
    }
    com.tencent.mm.ui.base.k.a(this, paramp, null, false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(70769);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void sK(int paramInt)
  {
    AppMethodBeat.i(70771);
    h localh = h.OAn;
    if (this.VMi.VEu == null) {}
    for (String str = "";; str = Util.nullAs(this.VMi.VEu.ehe, ""))
    {
      localh.b(14877, new Object[] { str, this.VMi.VEr, Integer.valueOf(paramInt), this.VMi.hAk });
      AppMethodBeat.o(70771);
      return;
    }
  }
  
  public void setContentViewVisibility(int paramInt)
  {
    AppMethodBeat.i(70770);
    getContentView().setVisibility(paramInt);
    AppMethodBeat.o(70770);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletBindCardResultUI
 * JD-Core Version:    0.7.0.1
 */