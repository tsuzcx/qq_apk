package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.kn;
import com.tencent.mm.g.a.kn.a;
import com.tencent.mm.g.a.vm;
import com.tencent.mm.g.a.ym;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.c.ac;
import com.tencent.mm.plugin.wallet_core.c.r;
import com.tencent.mm.plugin.wallet_core.model.BindCardOrder;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.plugin.wallet_core.model.s.a;
import com.tencent.mm.plugin.wallet_core.model.s.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import java.util.HashMap;

@com.tencent.mm.ui.base.a(3)
public class WalletBindCardResultUI
  extends WalletBaseUI
{
  private int CXR;
  private BindCardOrder DcN;
  private boolean DcO;
  private String DcP;
  private String DcQ;
  private s.b DcR;
  private WalletOrderInfoNewUI.b DcS;
  private HashMap<String, WalletOrderInfoNewUI.a> DcT;
  private String DcU;
  private BindCardOrder DcV;
  private String DcW;
  private Button DcX;
  private ImageView DcY;
  private ViewGroup DcZ;
  private CdnImageView Dda;
  private TextView Ddb;
  private TextView Ddc;
  private View Ddd;
  private Button Dde;
  private ViewGroup Ddf;
  private boolean Ddg;
  private boolean Ddh;
  private boolean Ddi;
  private com.tencent.mm.wallet_core.d Ddj;
  private PayInfo mPayInfo;
  private c wAM;
  private String wDV;
  private String yeM;
  private TextView ygd;
  
  public WalletBindCardResultUI()
  {
    AppMethodBeat.i(70755);
    this.wDV = null;
    this.DcO = false;
    this.DcT = new HashMap();
    this.DcV = null;
    this.DcW = "-1";
    this.Ddg = false;
    this.Ddh = false;
    this.Ddi = false;
    this.wAM = new c() {};
    AppMethodBeat.o(70755);
  }
  
  private void Xd(String paramString)
  {
    AppMethodBeat.i(70762);
    eHr();
    e.o(this, paramString, false);
    AppMethodBeat.o(70762);
  }
  
  private void eHo()
  {
    AppMethodBeat.i(70759);
    this.Ddf.setVisibility(0);
    AppMethodBeat.o(70759);
  }
  
  private void eHp()
  {
    AppMethodBeat.i(70760);
    this.ygd.setText(this.DcN.CVw);
    AppMethodBeat.o(70760);
  }
  
  private void eHq()
  {
    AppMethodBeat.i(70761);
    this.DcZ.setVisibility(4);
    this.Ddh = false;
    this.Ddg = false;
    if (this.DcN != null) {
      if (this.DcN.CVC != null)
      {
        ad.i("MicroMsg.WalletBindCardResultUI", "activityPromotions: %s", new Object[] { this.DcV });
        if ((this.DcN == null) || ((!this.DcN.eEY()) && (!this.DcN.eFa())) || (this.DcN.CVC.COR <= 0L) || (bt.isNullOrNil(this.DcN.CVD.CXM))) {
          break label854;
        }
        this.DcV = this.DcN;
        this.Ddd.setVisibility(8);
        this.Dda.setRoundCorner(true);
        this.Dde.setEnabled(true);
        this.Dde.setBackgroundResource(2131231365);
        this.Ddc.setCompoundDrawables(null, null, null, null);
        localObject = (WalletOrderInfoNewUI.a)this.DcT.get(this.DcV.CVC.COR);
        if (localObject == null) {
          break label639;
        }
        if (!bt.isNullOrNil(((WalletOrderInfoNewUI.a)localObject).dDH)) {
          this.Dda.setUrl(((WalletOrderInfoNewUI.a)localObject).dDH);
        }
        if (!bt.isNullOrNil(((WalletOrderInfoNewUI.a)localObject).dxD)) {
          this.Ddb.setText(((WalletOrderInfoNewUI.a)localObject).dxD);
        }
        if (!bt.isNullOrNil(((WalletOrderInfoNewUI.a)localObject).Dhj))
        {
          this.Dde.setText(((WalletOrderInfoNewUI.a)localObject).Dhj);
          this.Dde.setBackgroundResource(2131234694);
        }
        localLayoutParams = (RelativeLayout.LayoutParams)this.Ddc.getLayoutParams();
        if ((localObject == null) || (bt.isNullOrNil(((WalletOrderInfoNewUI.a)localObject).title))) {
          break label693;
        }
        this.Ddc.setText(((WalletOrderInfoNewUI.a)localObject).title);
        localLayoutParams.addRule(15, 0);
        this.Ddc.setLayoutParams(localLayoutParams);
        this.Dde.setVisibility(0);
        this.Dde.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(70750);
            b localb = new b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletBindCardResultUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            ad.i("MicroMsg.WalletBindCardResultUI", "click activity button");
            WalletBindCardResultUI.b(WalletBindCardResultUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletBindCardResultUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(70750);
          }
        });
        if (this.DcV.CVC.CXH != 1L) {
          this.DcZ.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(70751);
              b localb = new b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletBindCardResultUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
              ad.i("MicroMsg.WalletBindCardResultUI", "click activity layout");
              WalletBindCardResultUI.b(WalletBindCardResultUI.this);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletBindCardResultUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(70751);
            }
          });
        }
        localObject = this.DcW;
        i = -1;
        switch (((String)localObject).hashCode())
        {
        default: 
          switch (i)
          {
          default: 
            localObject = this.Ddb.getText();
            if ((!bt.ai((CharSequence)localObject)) && (((CharSequence)localObject).length() > 9))
            {
              this.Ddb.setText(((CharSequence)localObject).subSequence(0, 9));
              this.Ddb.append("...");
            }
            localObject = (ViewGroup.MarginLayoutParams)this.DcZ.getLayoutParams();
            ((ViewGroup.MarginLayoutParams)localObject).topMargin = com.tencent.mm.cc.a.fromDPToPix(this, 50);
            this.DcZ.setLayoutParams((ViewGroup.LayoutParams)localObject);
            this.DcZ.setVisibility(0);
          }
          break;
        }
      }
    }
    label639:
    while ((this.DcN.CVE == null) || (bt.isNullOrNil(this.DcN.CVE.CzQ)) || (!this.DcN.eEZ())) {
      for (;;)
      {
        RelativeLayout.LayoutParams localLayoutParams;
        int i;
        if (this.Ddb.getVisibility() == 0) {
          this.Ddb.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(70753);
              if ((WalletBindCardResultUI.g(WalletBindCardResultUI.this).getVisibility() == 0) && (WalletBindCardResultUI.h(WalletBindCardResultUI.this).getRight() >= WalletBindCardResultUI.g(WalletBindCardResultUI.this).getLeft()) && (!bt.ai(WalletBindCardResultUI.h(WalletBindCardResultUI.this).getText())))
              {
                float f1 = WalletBindCardResultUI.h(WalletBindCardResultUI.this).getTextSize();
                ad.i("MicroMsg.WalletBindCardResultUI", "tinyAppDescTv size exceed, tinyAppDescTv.getRight(): %s, tinyAppButton.getLeft(): %s", new Object[] { Integer.valueOf(WalletBindCardResultUI.h(WalletBindCardResultUI.this).getRight()), Integer.valueOf(WalletBindCardResultUI.g(WalletBindCardResultUI.this).getLeft()) });
                Paint localPaint = new Paint();
                localPaint.setTextSize(f1);
                String str = WalletBindCardResultUI.h(WalletBindCardResultUI.this).getText().toString();
                f1 = localPaint.measureText(str);
                float f2 = WalletBindCardResultUI.h(WalletBindCardResultUI.this).getRight() - WalletBindCardResultUI.g(WalletBindCardResultUI.this).getLeft();
                int i = 1;
                while ((localPaint.measureText(str.substring(0, str.length() - i - 1)) > f1 - f2) && (i <= str.length() - 1)) {
                  i += 1;
                }
                ad.i("MicroMsg.WalletBindCardResultUI", "tinyAppDescTv, exceed len, final search count: %s, text.length: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(str.length()) });
                WalletBindCardResultUI.h(WalletBindCardResultUI.this).setText(str.substring(0, str.length() - i - 1));
                WalletBindCardResultUI.h(WalletBindCardResultUI.this).append("...");
              }
              AppMethodBeat.o(70753);
            }
          });
        }
        if (this.DcZ.getVisibility() == 8)
        {
          localObject = (ViewGroup.MarginLayoutParams)this.DcY.getLayoutParams();
          ((ViewGroup.MarginLayoutParams)localObject).topMargin = com.tencent.mm.cc.a.fromDPToPix(this, 91);
          this.DcY.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        AppMethodBeat.o(70761);
        return;
        this.Dda.setUrl(this.DcN.CVD.wMR);
        this.Ddb.setText(this.DcN.CVD.name);
        this.Dde.setText(this.DcN.CVD.CXM);
        continue;
        if (!bt.isNullOrNil(this.DcN.CVD.title))
        {
          this.Ddc.setText(this.DcN.CVD.title);
          localLayoutParams.addRule(15, 0);
        }
        else
        {
          this.Ddc.setVisibility(8);
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
                      this.Dde.setEnabled(false);
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
    this.DcP = this.DcN.CVE.CzQ;
    this.DcQ = this.DcN.CVE.CzR;
    this.CXR = this.DcN.CVE.CXR;
    this.DcR = this.DcN.CVE;
    this.Dda.setUrl(this.DcN.CVE.CXO);
    this.Ddb.setText(this.DcN.CVE.CXP);
    this.Ddc.setText(getString(2131764967));
    this.Ddc.setVisibility(0);
    this.Dda.setRoundCorner(true);
    this.Dde.setEnabled(true);
    this.Dde.setBackgroundResource(2131231365);
    Object localObject = (RelativeLayout.LayoutParams)this.Ddc.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).addRule(15, 0);
    this.Ddc.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (this.DcN.CVC.COR > 0L)
    {
      if (!bt.isNullOrNil(this.DcN.CVE.CXQ))
      {
        this.Dde.setVisibility(0);
        this.Dde.setText(this.DcN.CVE.CXQ);
        this.Ddd.setVisibility(8);
      }
      localObject = (WalletOrderInfoNewUI.a)this.DcT.get(this.DcN.CVC.COR);
      if (localObject != null)
      {
        if (!bt.isNullOrNil(((WalletOrderInfoNewUI.a)localObject).CXO)) {
          this.Dda.setUrl(((WalletOrderInfoNewUI.a)localObject).CXO);
        }
        if (!bt.isNullOrNil(((WalletOrderInfoNewUI.a)localObject).CXP)) {
          this.Ddb.setText(((WalletOrderInfoNewUI.a)localObject).CXP);
        }
        if (!bt.isNullOrNil(((WalletOrderInfoNewUI.a)localObject).CXQ))
        {
          this.Dde.setText(((WalletOrderInfoNewUI.a)localObject).CXQ);
          this.Dde.setBackgroundResource(2131234694);
        }
        if (!bt.isNullOrNil(((WalletOrderInfoNewUI.a)localObject).CzQ)) {
          this.DcP = ((WalletOrderInfoNewUI.a)localObject).CzQ;
        }
        if (!bt.isNullOrNil(((WalletOrderInfoNewUI.a)localObject).CzR)) {
          this.DcQ = ((WalletOrderInfoNewUI.a)localObject).CzR;
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
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletBindCardResultUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          ad.i("MicroMsg.WalletBindCardResultUI", "click tiny app, userName: %s, path: %s, version: %s", new Object[] { WalletBindCardResultUI.c(WalletBindCardResultUI.this), WalletBindCardResultUI.d(WalletBindCardResultUI.this), Integer.valueOf(WalletBindCardResultUI.e(WalletBindCardResultUI.this)) });
          WalletBindCardResultUI.this.mW(2);
          paramAnonymousView = new vm();
          paramAnonymousView.dJF.userName = WalletBindCardResultUI.c(WalletBindCardResultUI.this);
          paramAnonymousView.dJF.dJH = bt.bI(WalletBindCardResultUI.d(WalletBindCardResultUI.this), "");
          paramAnonymousView.dJF.scene = 1034;
          paramAnonymousView.dJF.dJI = 0;
          if (WalletBindCardResultUI.e(WalletBindCardResultUI.this) > 0) {
            paramAnonymousView.dJF.aDD = WalletBindCardResultUI.e(WalletBindCardResultUI.this);
          }
          com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousView);
          if ((!bt.isNullOrNil(WalletBindCardResultUI.f(WalletBindCardResultUI.this).CVE.CXQ)) && (WalletBindCardResultUI.f(WalletBindCardResultUI.this).CVC.COR > 0L)) {
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
      this.DcZ.setOnClickListener((View.OnClickListener)localObject);
      this.Dde.setOnClickListener((View.OnClickListener)localObject);
      localObject = this.Ddb.getText();
      if ((bt.ai((CharSequence)localObject)) || (((CharSequence)localObject).length() <= 9)) {
        break;
      }
      this.Ddb.setText(((CharSequence)localObject).subSequence(0, 9));
      this.Ddb.append("...");
      break;
      this.Dde.setVisibility(8);
      this.Ddd.setVisibility(8);
    }
  }
  
  private void eHr()
  {
    int i = 0;
    AppMethodBeat.i(70768);
    if (!this.DcO)
    {
      kn localkn = new kn();
      localkn.dxx.requestCode = 4;
      kn.a locala = localkn.dxx;
      if (getInput().getBoolean("intent_pay_end", false)) {
        i = -1;
      }
      locala.bZU = i;
      com.tencent.mm.sdk.b.a.IbL.l(localkn);
      this.DcO = true;
    }
    AppMethodBeat.o(70768);
  }
  
  public final void done()
  {
    AppMethodBeat.i(70765);
    Bundle localBundle = new Bundle();
    if (this.Ddj != null)
    {
      this.Ddj.a(this, 0, localBundle);
      AppMethodBeat.o(70765);
      return;
    }
    finish();
    AppMethodBeat.o(70765);
  }
  
  public int getLayoutId()
  {
    return 2131495927;
  }
  
  public void initView()
  {
    AppMethodBeat.i(70758);
    if (getSupportActionBar() != null) {
      getSupportActionBar().hide();
    }
    this.DcY = ((ImageView)findViewById(2131307115));
    this.ygd = ((TextView)findViewById(2131303156));
    this.DcX = ((Button)findViewById(2131303152));
    showHomeBtn(false);
    enableBackMenu(false);
    String str = getString(2131755779);
    if ((this.DcN != null) && (!bt.isNullOrNil(this.DcN.CVv))) {
      this.DcX.setText(this.DcN.CVv);
    }
    for (;;)
    {
      this.DcX.setOnClickListener(new WalletBindCardResultUI.2(this));
      this.Ddf = ((ViewGroup)findViewById(2131306773));
      this.DcZ = ((ViewGroup)findViewById(2131305855));
      this.Dda = ((CdnImageView)findViewById(2131305857));
      this.Dda.setUseSdcardCache(true);
      this.Ddb = ((TextView)findViewById(2131305854));
      this.Ddc = ((TextView)findViewById(2131305859));
      this.Dde = ((Button)findViewById(2131305852));
      this.Ddd = findViewById(2131305856);
      this.Ddf.setVisibility(4);
      eHp();
      eHq();
      eHo();
      if ((!bt.isNullOrNil(this.DcN.CVx)) && (!bt.isNullOrNil(this.DcN.CVy))) {
        ((TextView)findViewById(2131303157)).setText(getString(2131765065, new Object[] { this.DcN.CVx, this.DcN.CVy }));
      }
      AppMethodBeat.o(70758);
      return;
      this.DcX.setText(str);
    }
  }
  
  public final void mW(int paramInt)
  {
    AppMethodBeat.i(70771);
    g localg = g.yhR;
    if (this.DcN.CVC == null) {}
    for (String str = "";; str = bt.bI(this.DcN.CVC.COR, ""))
    {
      localg.f(14877, new Object[] { str, this.DcN.CVz, Integer.valueOf(paramInt), this.DcN.dkR });
      AppMethodBeat.o(70771);
      return;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(70763);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ad.i("MicroMsg.WalletBindCardResultUI", "onActivityResult %d %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 1)
    {
      ad.i("MicroMsg.WalletBindCardResultUI", "do query pay arawrd");
      doSceneProgress(new ac(this.DcS.CPq, this.DcS.Dhl, this.DcS.Dhm, this.DcS.Dhn, this.DcS.CZw, this.DcS.Dho, this.DcN.dkR, this.DcN.CVz, this.DcN.CVA, this.DcN.CVA));
    }
    AppMethodBeat.o(70763);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(70756);
    super.onCreate(paramBundle);
    if (com.tencent.mm.compatible.util.d.ly(21))
    {
      if (!com.tencent.mm.compatible.util.d.ly(23)) {
        break label172;
      }
      getWindow().setStatusBarColor(getResources().getColor(2131101179));
    }
    for (;;)
    {
      setContentViewVisibility(4);
      com.tencent.mm.wallet_core.a.br(this);
      this.mPayInfo = ((PayInfo)getInput().getParcelable("key_pay_info"));
      getInput().getInt("key_pay_type", -1);
      BindCardOrder localBindCardOrder = (BindCardOrder)getInput().getParcelable("key_bindcard_value_result");
      paramBundle = localBindCardOrder;
      if (localBindCardOrder == null) {
        paramBundle = new BindCardOrder();
      }
      this.DcN = paramBundle;
      setContentViewVisibility(0);
      initView();
      this.Ddj = getProcess();
      eHp();
      mW(1);
      addSceneEndListener(1979);
      com.tencent.mm.sdk.b.a.IbL.c(this.wAM);
      this.Ddi = true;
      AppMethodBeat.o(70756);
      return;
      label172:
      getWindow().setStatusBarColor(getResources().getColor(2131099678));
    }
  }
  
  @Deprecated
  public Dialog onCreateDialog(int paramInt)
  {
    AppMethodBeat.i(70764);
    Dialog localDialog = h.a(getContext(), getString(2131765565), getResources().getStringArray(2130903098), "", new WalletBindCardResultUI.7(this));
    AppMethodBeat.o(70764);
    return localDialog;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(70767);
    super.onDestroy();
    com.tencent.mm.sdk.b.a.IbL.d(this.wAM);
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
    ad.i("MicroMsg.WalletBindCardResultUI", "onResume, isFirstInit: %s activityPromotions: %s, isClickTinyappActivity: %s, isClickActivity: %s, recommendTinyAppInfo: %s", new Object[] { Boolean.valueOf(this.Ddi), this.DcV, Boolean.valueOf(this.Ddg), Boolean.valueOf(this.Ddh), this.DcR });
    if (this.Ddi)
    {
      this.Ddi = false;
      AppMethodBeat.o(70757);
      return;
    }
    if ((this.DcV != null) && (this.Ddh))
    {
      doSceneProgress(new ac(this.DcV.CVC.COR, this.DcV.CVC.CXI, this.DcV.CVC.CXJ, this.DcV.CVC.CXK, this.DcV.CVC.CXH, this.DcV.CVC.CXL, this.DcN.dkR, this.DcN.CVz, this.DcN.CVA, this.DcN.CVA));
      AppMethodBeat.o(70757);
      return;
    }
    if ((this.Ddg) && (this.DcR != null)) {
      doSceneProgress(new ac(this.DcN.CVC.COR, this.DcN.CVC.CXI, this.DcN.CVC.CXJ, this.DcN.CVC.CXK, this.DcN.CVC.CXL, this.DcN.CVC.CXH, this.DcN.dkR, this.DcN.CVz, this.DcN.CVA, this.DcN.CVA));
    }
    AppMethodBeat.o(70757);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(70769);
    if ((paramn instanceof ac)) {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (ac)paramn;
        paramn = new WalletOrderInfoNewUI.a(paramString.kqN);
        if (this.DcS == null) {
          break label78;
        }
        this.DcT.put(paramString.CPq, paramn);
        eHq();
        eHo();
      }
    }
    label78:
    while (!(paramn instanceof r)) {
      for (;;)
      {
        AppMethodBeat.o(70769);
        return false;
        if (this.Ddg)
        {
          this.DcT.put(paramString.CPq, paramn);
          eHq();
          eHo();
        }
      }
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = (r)paramn;
      paramn = paramString.COY;
      if ((this.DcV != null) && (this.DcV.CVC.COR == paramString.CPa.CVC.COR))
      {
        ad.i("MicroMsg.WalletBindCardResultUI", "activityAwardState: %s", new Object[] { this.DcV });
        this.DcW = paramn;
        eHq();
        eHo();
        if ((!bt.isNullOrNil(paramString.fKQ)) && (!"3".equals(paramn))) {
          this.Dde.setText(paramString.fKQ);
        }
      }
      if ((!"-1".equals(paramn)) && (!"0".equals(paramn)) && (!bt.isNullOrNil(paramString.COZ))) {
        h.c(this, paramString.COZ, "", true);
      }
      while (!"0".equals(paramn))
      {
        AppMethodBeat.o(70769);
        return true;
      }
      if (!bt.isNullOrNil(paramString.COZ)) {}
      for (paramString = paramString.COZ;; paramString = getString(2131765658))
      {
        Toast.makeText(this, paramString, 0).show();
        break;
      }
    }
    paramn = paramString;
    if (bt.isNullOrNil(paramString)) {
      paramn = getString(2131765901);
    }
    h.a(this, paramn, null, false, new DialogInterface.OnClickListener()
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