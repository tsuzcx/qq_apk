package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.f.a.abe;
import com.tencent.mm.f.a.lv;
import com.tencent.mm.f.a.lv.a;
import com.tencent.mm.f.a.xw;
import com.tencent.mm.hellhoundlib.b.b;
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
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.g;
import java.util.HashMap;

@com.tencent.mm.ui.base.a(3)
public class WalletBindCardResultUI
  extends WalletBaseUI
{
  private IListener GFB;
  private String GIN;
  private String Itj;
  private TextView Ivj;
  private ViewGroup NEN;
  private int OQK;
  private BindCardOrder OVS;
  private boolean OVT;
  private String OVU;
  private String OVV;
  private s.b OVW;
  private WalletOrderInfoNewUI.b OVX;
  private HashMap<String, WalletOrderInfoNewUI.a> OVY;
  private String OVZ;
  private BindCardOrder OWa;
  private String OWb;
  private Button OWc;
  private ImageView OWd;
  private ViewGroup OWe;
  private CdnImageView OWf;
  private TextView OWg;
  private TextView OWh;
  private View OWi;
  private Button OWj;
  private boolean OWk;
  private boolean OWl;
  private boolean OWm;
  private com.tencent.mm.wallet_core.d OWn;
  private PayInfo mPayInfo;
  
  public WalletBindCardResultUI()
  {
    AppMethodBeat.i(70755);
    this.GIN = null;
    this.OVT = false;
    this.OVY = new HashMap();
    this.OWa = null;
    this.OWb = "-1";
    this.OWk = false;
    this.OWl = false;
    this.OWm = false;
    this.GFB = new IListener() {};
    AppMethodBeat.o(70755);
  }
  
  private void apy(String paramString)
  {
    AppMethodBeat.i(70762);
    gLk();
    g.p(this, paramString, false);
    AppMethodBeat.o(70762);
  }
  
  private void gLh()
  {
    AppMethodBeat.i(70759);
    this.NEN.setVisibility(0);
    AppMethodBeat.o(70759);
  }
  
  private void gLi()
  {
    AppMethodBeat.i(70760);
    this.Ivj.setText(this.OVS.OOu);
    AppMethodBeat.o(70760);
  }
  
  private void gLj()
  {
    AppMethodBeat.i(70761);
    this.OWe.setVisibility(4);
    this.OWl = false;
    this.OWk = false;
    if (this.OVS != null) {
      if (this.OVS.OOA != null)
      {
        Log.i("MicroMsg.WalletBindCardResultUI", "activityPromotions: %s", new Object[] { this.OWa });
        if ((this.OVS == null) || ((!this.OVS.gIO()) && (!this.OVS.gIQ())) || (this.OVS.OOA.cpu <= 0L) || (Util.isNullOrNil(this.OVS.OOB.OQF))) {
          break label854;
        }
        this.OWa = this.OVS;
        this.OWi.setVisibility(8);
        this.OWf.setRoundCorner(true);
        this.OWj.setEnabled(true);
        this.OWj.setBackgroundResource(a.e.btn_solid_green);
        this.OWh.setCompoundDrawables(null, null, null, null);
        localObject = (WalletOrderInfoNewUI.a)this.OVY.get(this.OWa.OOA.cpu);
        if (localObject == null) {
          break label639;
        }
        if (!Util.isNullOrNil(((WalletOrderInfoNewUI.a)localObject).icon)) {
          this.OWf.setUrl(((WalletOrderInfoNewUI.a)localObject).icon);
        }
        if (!Util.isNullOrNil(((WalletOrderInfoNewUI.a)localObject).wording)) {
          this.OWg.setText(((WalletOrderInfoNewUI.a)localObject).wording);
        }
        if (!Util.isNullOrNil(((WalletOrderInfoNewUI.a)localObject).Pap))
        {
          this.OWj.setText(((WalletOrderInfoNewUI.a)localObject).Pap);
          this.OWj.setBackgroundResource(a.e.wallet_order_info_solid_green_disabled);
        }
        localLayoutParams = (RelativeLayout.LayoutParams)this.OWh.getLayoutParams();
        if ((localObject == null) || (Util.isNullOrNil(((WalletOrderInfoNewUI.a)localObject).title))) {
          break label693;
        }
        this.OWh.setText(((WalletOrderInfoNewUI.a)localObject).title);
        localLayoutParams.addRule(15, 0);
        this.OWh.setLayoutParams(localLayoutParams);
        this.OWj.setVisibility(0);
        this.OWj.setOnClickListener(new WalletBindCardResultUI.3(this));
        if (this.OWa.OOA.OQA != 1L) {
          this.OWe.setOnClickListener(new WalletBindCardResultUI.4(this));
        }
        localObject = this.OWb;
        i = -1;
        switch (((String)localObject).hashCode())
        {
        default: 
          switch (i)
          {
          default: 
            localObject = this.OWg.getText();
            if ((!Util.isNullOrNil((CharSequence)localObject)) && (((CharSequence)localObject).length() > 9))
            {
              this.OWg.setText(((CharSequence)localObject).subSequence(0, 9));
              this.OWg.append("...");
            }
            localObject = (ViewGroup.MarginLayoutParams)this.OWe.getLayoutParams();
            ((ViewGroup.MarginLayoutParams)localObject).topMargin = com.tencent.mm.ci.a.fromDPToPix(this, 50);
            this.OWe.setLayoutParams((ViewGroup.LayoutParams)localObject);
            this.OWe.setVisibility(0);
          }
          break;
        }
      }
    }
    label639:
    while ((this.OVS.OOC == null) || (Util.isNullOrNil(this.OVS.OOC.Ooe)) || (!this.OVS.gIP())) {
      for (;;)
      {
        RelativeLayout.LayoutParams localLayoutParams;
        int i;
        if (this.OWg.getVisibility() == 0) {
          this.OWg.post(new Runnable()
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
        if (this.OWe.getVisibility() == 8)
        {
          localObject = (ViewGroup.MarginLayoutParams)this.OWd.getLayoutParams();
          ((ViewGroup.MarginLayoutParams)localObject).topMargin = com.tencent.mm.ci.a.fromDPToPix(this, 91);
          this.OWd.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        AppMethodBeat.o(70761);
        return;
        this.OWf.setUrl(this.OVS.OOB.GUf);
        this.OWg.setText(this.OVS.OOB.name);
        this.OWj.setText(this.OVS.OOB.OQF);
        continue;
        if (!Util.isNullOrNil(this.OVS.OOB.title))
        {
          this.OWh.setText(this.OVS.OOB.title);
          localLayoutParams.addRule(15, 0);
        }
        else
        {
          this.OWh.setVisibility(8);
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
                      this.OWj.setEnabled(false);
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
    this.OVU = this.OVS.OOC.Ooe;
    this.OVV = this.OVS.OOC.Oof;
    this.OQK = this.OVS.OOC.OQK;
    this.OVW = this.OVS.OOC;
    this.OWf.setUrl(this.OVS.OOC.OQH);
    this.OWg.setText(this.OVS.OOC.OQI);
    this.OWh.setText(getString(a.i.wallet_app_brand_entrance));
    this.OWh.setVisibility(0);
    this.OWf.setRoundCorner(true);
    this.OWj.setEnabled(true);
    this.OWj.setBackgroundResource(a.e.btn_solid_green);
    Object localObject = (RelativeLayout.LayoutParams)this.OWh.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).addRule(15, 0);
    this.OWh.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (this.OVS.OOA.cpu > 0L)
    {
      if (!Util.isNullOrNil(this.OVS.OOC.OQJ))
      {
        this.OWj.setVisibility(0);
        this.OWj.setText(this.OVS.OOC.OQJ);
        this.OWi.setVisibility(8);
      }
      localObject = (WalletOrderInfoNewUI.a)this.OVY.get(this.OVS.OOA.cpu);
      if (localObject != null)
      {
        if (!Util.isNullOrNil(((WalletOrderInfoNewUI.a)localObject).OQH)) {
          this.OWf.setUrl(((WalletOrderInfoNewUI.a)localObject).OQH);
        }
        if (!Util.isNullOrNil(((WalletOrderInfoNewUI.a)localObject).OQI)) {
          this.OWg.setText(((WalletOrderInfoNewUI.a)localObject).OQI);
        }
        if (!Util.isNullOrNil(((WalletOrderInfoNewUI.a)localObject).OQJ))
        {
          this.OWj.setText(((WalletOrderInfoNewUI.a)localObject).OQJ);
          this.OWj.setBackgroundResource(a.e.wallet_order_info_solid_green_disabled);
        }
        if (!Util.isNullOrNil(((WalletOrderInfoNewUI.a)localObject).Ooe)) {
          this.OVU = ((WalletOrderInfoNewUI.a)localObject).Ooe;
        }
        if (!Util.isNullOrNil(((WalletOrderInfoNewUI.a)localObject).Oof)) {
          this.OVV = ((WalletOrderInfoNewUI.a)localObject).Oof;
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
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletBindCardResultUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          Log.i("MicroMsg.WalletBindCardResultUI", "click tiny app, userName: %s, path: %s, version: %s", new Object[] { WalletBindCardResultUI.c(WalletBindCardResultUI.this), WalletBindCardResultUI.d(WalletBindCardResultUI.this), Integer.valueOf(WalletBindCardResultUI.e(WalletBindCardResultUI.this)) });
          WalletBindCardResultUI.this.sN(2);
          paramAnonymousView = new xw();
          paramAnonymousView.fWN.userName = WalletBindCardResultUI.c(WalletBindCardResultUI.this);
          paramAnonymousView.fWN.fWP = Util.nullAs(WalletBindCardResultUI.d(WalletBindCardResultUI.this), "");
          paramAnonymousView.fWN.scene = 1034;
          paramAnonymousView.fWN.fWQ = 0;
          if (WalletBindCardResultUI.e(WalletBindCardResultUI.this) > 0) {
            paramAnonymousView.fWN.appVersion = WalletBindCardResultUI.e(WalletBindCardResultUI.this);
          }
          EventCenter.instance.publish(paramAnonymousView);
          if ((!Util.isNullOrNil(WalletBindCardResultUI.f(WalletBindCardResultUI.this).OOC.OQJ)) && (WalletBindCardResultUI.f(WalletBindCardResultUI.this).OOA.cpu > 0L)) {
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
      this.OWe.setOnClickListener((View.OnClickListener)localObject);
      this.OWj.setOnClickListener((View.OnClickListener)localObject);
      localObject = this.OWg.getText();
      if ((Util.isNullOrNil((CharSequence)localObject)) || (((CharSequence)localObject).length() <= 9)) {
        break;
      }
      this.OWg.setText(((CharSequence)localObject).subSequence(0, 9));
      this.OWg.append("...");
      break;
      this.OWj.setVisibility(8);
      this.OWi.setVisibility(8);
    }
  }
  
  private void gLk()
  {
    int i = 0;
    AppMethodBeat.i(70768);
    if (!this.OVT)
    {
      lv locallv = new lv();
      locallv.fJI.requestCode = 4;
      lv.a locala = locallv.fJI;
      if (getInput().getBoolean("intent_pay_end", false)) {
        i = -1;
      }
      locala.resultCode = i;
      EventCenter.instance.publish(locallv);
      this.OVT = true;
    }
    AppMethodBeat.o(70768);
  }
  
  public final void done()
  {
    AppMethodBeat.i(70765);
    Bundle localBundle = new Bundle();
    if (this.OWn != null)
    {
      this.OWn.a(this, 0, localBundle);
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
    this.OWd = ((ImageView)findViewById(a.f.wxpay_logo_iv));
    this.Ivj = ((TextView)findViewById(a.f.pay_succ_wording));
    this.OWc = ((Button)findViewById(a.f.pay_finish_button));
    showHomeBtn(false);
    enableBackMenu(false);
    String str = getString(a.i.app_finish);
    if ((this.OVS != null) && (!Util.isNullOrNil(this.OVS.OOt))) {
      this.OWc.setText(this.OVS.OOt);
    }
    for (;;)
    {
      this.OWc.setOnClickListener(new WalletBindCardResultUI.2(this));
      this.NEN = ((ViewGroup)findViewById(a.f.wallet_order_info_bottom_layout));
      this.OWe = ((ViewGroup)findViewById(a.f.tinyapp_info_layout));
      this.OWf = ((CdnImageView)findViewById(a.f.tinyapp_logo_iv));
      this.OWf.setUseSdcardCache(true);
      this.OWg = ((TextView)findViewById(a.f.tinyapp_desc_tv));
      this.OWh = ((TextView)findViewById(a.f.tinyapp_name_tv));
      this.OWj = ((Button)findViewById(a.f.tinyapp_button));
      this.OWi = findViewById(a.f.tinyapp_info_touch_mask);
      this.NEN.setVisibility(4);
      gLi();
      gLj();
      gLh();
      if ((!Util.isNullOrNil(this.OVS.OOv)) && (!Util.isNullOrNil(this.OVS.OOw))) {
        ((TextView)findViewById(a.f.pay_succ_wording_tip)).setText(getString(a.i.wallet_bind_card_info_tip, new Object[] { this.OVS.OOv, this.OVS.OOw }));
      }
      AppMethodBeat.o(70758);
      return;
      this.OWc.setText(str);
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
      doSceneProgress(new ad(this.OVX.OIw, this.OVX.Par, this.OVX.Pas, this.OVX.Pat, this.OVX.OSy, this.OVX.Pau, this.OVS.fvP, this.OVS.OOx, this.OVS.OOy, this.OVS.OOy));
    }
    AppMethodBeat.o(70763);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(70756);
    super.onCreate(paramBundle);
    if (com.tencent.mm.compatible.util.d.qV(21))
    {
      if (!com.tencent.mm.compatible.util.d.qV(23)) {
        break label172;
      }
      getWindow().setStatusBarColor(getResources().getColor(a.c.white));
    }
    for (;;)
    {
      setContentViewVisibility(4);
      com.tencent.mm.wallet_core.a.bF(this);
      this.mPayInfo = ((PayInfo)getInput().getParcelable("key_pay_info"));
      getInput().getInt("key_pay_type", -1);
      BindCardOrder localBindCardOrder = (BindCardOrder)getInput().getParcelable("key_bindcard_value_result");
      paramBundle = localBindCardOrder;
      if (localBindCardOrder == null) {
        paramBundle = new BindCardOrder();
      }
      this.OVS = paramBundle;
      setContentViewVisibility(0);
      initView();
      this.OWn = getProcess();
      gLi();
      sN(1);
      addSceneEndListener(1979);
      EventCenter.instance.addListener(this.GFB);
      this.OWm = true;
      AppMethodBeat.o(70756);
      return;
      label172:
      getWindow().setStatusBarColor(getResources().getColor(a.c.BW_90));
    }
  }
  
  @Deprecated
  public Dialog onCreateDialog(int paramInt)
  {
    AppMethodBeat.i(70764);
    Dialog localDialog = com.tencent.mm.ui.base.h.a(getContext(), getString(a.i.wallet_order_info_phone), getResources().getStringArray(a.b.wallet_phone_call), "", new WalletBindCardResultUI.7(this));
    AppMethodBeat.o(70764);
    return localDialog;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(70767);
    super.onDestroy();
    EventCenter.instance.removeListener(this.GFB);
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
    Log.i("MicroMsg.WalletBindCardResultUI", "onResume, isFirstInit: %s activityPromotions: %s, isClickTinyappActivity: %s, isClickActivity: %s, recommendTinyAppInfo: %s", new Object[] { Boolean.valueOf(this.OWm), this.OWa, Boolean.valueOf(this.OWk), Boolean.valueOf(this.OWl), this.OVW });
    if (this.OWm)
    {
      this.OWm = false;
      AppMethodBeat.o(70757);
      return;
    }
    if ((this.OWa != null) && (this.OWl))
    {
      doSceneProgress(new ad(this.OWa.OOA.cpu, this.OWa.OOA.OQB, this.OWa.OOA.OQC, this.OWa.OOA.OQD, this.OWa.OOA.OQA, this.OWa.OOA.OQE, this.OVS.fvP, this.OVS.OOx, this.OVS.OOy, this.OVS.OOy));
      AppMethodBeat.o(70757);
      return;
    }
    if ((this.OWk) && (this.OVW != null)) {
      doSceneProgress(new ad(this.OVS.OOA.cpu, this.OVS.OOA.OQB, this.OVS.OOA.OQC, this.OVS.OOA.OQD, this.OVS.OOA.OQE, this.OVS.OOA.OQA, this.OVS.fvP, this.OVS.OOx, this.OVS.OOy, this.OVS.OOy));
    }
    AppMethodBeat.o(70757);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(70769);
    if ((paramq instanceof ad)) {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (ad)paramq;
        paramq = new WalletOrderInfoNewUI.a(paramString.osF);
        if (this.OVX == null) {
          break label78;
        }
        this.OVY.put(paramString.OIw, paramq);
        gLj();
        gLh();
      }
    }
    label78:
    while (!(paramq instanceof com.tencent.mm.plugin.wallet_core.c.s)) {
      for (;;)
      {
        AppMethodBeat.o(70769);
        return false;
        if (this.OWk)
        {
          this.OVY.put(paramString.OIw, paramq);
          gLj();
          gLh();
        }
      }
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = (com.tencent.mm.plugin.wallet_core.c.s)paramq;
      paramq = paramString.OIe;
      if ((this.OWa != null) && (this.OWa.OOA.cpu == paramString.OIg.OOA.cpu))
      {
        Log.i("MicroMsg.WalletBindCardResultUI", "activityAwardState: %s", new Object[] { this.OWa });
        this.OWb = paramq;
        gLj();
        gLh();
        if ((!Util.isNullOrNil(paramString.resultMsg)) && (!"3".equals(paramq))) {
          this.OWj.setText(paramString.resultMsg);
        }
      }
      if ((!"-1".equals(paramq)) && (!"0".equals(paramq)) && (!Util.isNullOrNil(paramString.OIf))) {
        com.tencent.mm.ui.base.h.c(this, paramString.OIf, "", true);
      }
      while (!"0".equals(paramq))
      {
        AppMethodBeat.o(70769);
        return true;
      }
      if (!Util.isNullOrNil(paramString.OIf)) {}
      for (paramString = paramString.OIf;; paramString = getString(a.i.wallet_pay_award_got))
      {
        Toast.makeText(this, paramString, 0).show();
        break;
      }
    }
    paramq = paramString;
    if (Util.isNullOrNil(paramString)) {
      paramq = getString(a.i.wallet_unknown_err);
    }
    com.tencent.mm.ui.base.h.a(this, paramq, null, false, new DialogInterface.OnClickListener()
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
  
  public final void sN(int paramInt)
  {
    AppMethodBeat.i(70771);
    com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.IzE;
    if (this.OVS.OOA == null) {}
    for (String str = "";; str = Util.nullAs(this.OVS.OOA.cpu, ""))
    {
      localh.a(14877, new Object[] { str, this.OVS.OOx, Integer.valueOf(paramInt), this.OVS.fvP });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletBindCardResultUI
 * JD-Core Version:    0.7.0.1
 */