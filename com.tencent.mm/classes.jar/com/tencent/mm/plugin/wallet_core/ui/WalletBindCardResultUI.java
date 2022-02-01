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
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.ko;
import com.tencent.mm.g.a.ko.a;
import com.tencent.mm.g.a.vq;
import com.tencent.mm.g.a.ys;
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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;
import java.util.HashMap;

@com.tencent.mm.ui.base.a(3)
public class WalletBindCardResultUI
  extends WalletBaseUI
{
  private int Dpw;
  private String DuA;
  private Button DuB;
  private ImageView DuC;
  private ViewGroup DuD;
  private CdnImageView DuE;
  private TextView DuF;
  private TextView DuG;
  private View DuH;
  private Button DuI;
  private ViewGroup DuJ;
  private boolean DuK;
  private boolean DuL;
  private boolean DuM;
  private com.tencent.mm.wallet_core.d DuN;
  private BindCardOrder Dur;
  private boolean Dus;
  private String Dut;
  private String Duu;
  private s.b Duv;
  private WalletOrderInfoNewUI.b Duw;
  private HashMap<String, WalletOrderInfoNewUI.a> Dux;
  private String Duy;
  private BindCardOrder Duz;
  private PayInfo mPayInfo;
  private c wQx;
  private String wTG;
  private String yuD;
  private TextView yvU;
  
  public WalletBindCardResultUI()
  {
    AppMethodBeat.i(70755);
    this.wTG = null;
    this.Dus = false;
    this.Dux = new HashMap();
    this.Duz = null;
    this.DuA = "-1";
    this.DuK = false;
    this.DuL = false;
    this.DuM = false;
    this.wQx = new c() {};
    AppMethodBeat.o(70755);
  }
  
  private void XP(String paramString)
  {
    AppMethodBeat.i(70762);
    eKZ();
    f.p(this, paramString, false);
    AppMethodBeat.o(70762);
  }
  
  private void eKW()
  {
    AppMethodBeat.i(70759);
    this.DuJ.setVisibility(0);
    AppMethodBeat.o(70759);
  }
  
  private void eKX()
  {
    AppMethodBeat.i(70760);
    this.yvU.setText(this.Dur.Dnc);
    AppMethodBeat.o(70760);
  }
  
  private void eKY()
  {
    AppMethodBeat.i(70761);
    this.DuD.setVisibility(4);
    this.DuL = false;
    this.DuK = false;
    if (this.Dur != null) {
      if (this.Dur.Dni != null)
      {
        ae.i("MicroMsg.WalletBindCardResultUI", "activityPromotions: %s", new Object[] { this.Duz });
        if ((this.Dur == null) || ((!this.Dur.eIF()) && (!this.Dur.eIH())) || (this.Dur.Dni.vlr <= 0L) || (bu.isNullOrNil(this.Dur.Dnj.Dpr))) {
          break label854;
        }
        this.Duz = this.Dur;
        this.DuH.setVisibility(8);
        this.DuE.setRoundCorner(true);
        this.DuI.setEnabled(true);
        this.DuI.setBackgroundResource(2131231365);
        this.DuG.setCompoundDrawables(null, null, null, null);
        localObject = (WalletOrderInfoNewUI.a)this.Dux.get(this.Duz.Dni.vlr);
        if (localObject == null) {
          break label639;
        }
        if (!bu.isNullOrNil(((WalletOrderInfoNewUI.a)localObject).dEM)) {
          this.DuE.setUrl(((WalletOrderInfoNewUI.a)localObject).dEM);
        }
        if (!bu.isNullOrNil(((WalletOrderInfoNewUI.a)localObject).dyI)) {
          this.DuF.setText(((WalletOrderInfoNewUI.a)localObject).dyI);
        }
        if (!bu.isNullOrNil(((WalletOrderInfoNewUI.a)localObject).DyN))
        {
          this.DuI.setText(((WalletOrderInfoNewUI.a)localObject).DyN);
          this.DuI.setBackgroundResource(2131234694);
        }
        localLayoutParams = (RelativeLayout.LayoutParams)this.DuG.getLayoutParams();
        if ((localObject == null) || (bu.isNullOrNil(((WalletOrderInfoNewUI.a)localObject).title))) {
          break label693;
        }
        this.DuG.setText(((WalletOrderInfoNewUI.a)localObject).title);
        localLayoutParams.addRule(15, 0);
        this.DuG.setLayoutParams(localLayoutParams);
        this.DuI.setVisibility(0);
        this.DuI.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(70750);
            b localb = new b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletBindCardResultUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            ae.i("MicroMsg.WalletBindCardResultUI", "click activity button");
            WalletBindCardResultUI.b(WalletBindCardResultUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletBindCardResultUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(70750);
          }
        });
        if (this.Duz.Dni.Dpm != 1L) {
          this.DuD.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(70751);
              b localb = new b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletBindCardResultUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
              ae.i("MicroMsg.WalletBindCardResultUI", "click activity layout");
              WalletBindCardResultUI.b(WalletBindCardResultUI.this);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletBindCardResultUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(70751);
            }
          });
        }
        localObject = this.DuA;
        i = -1;
        switch (((String)localObject).hashCode())
        {
        default: 
          switch (i)
          {
          default: 
            localObject = this.DuF.getText();
            if ((!bu.ah((CharSequence)localObject)) && (((CharSequence)localObject).length() > 9))
            {
              this.DuF.setText(((CharSequence)localObject).subSequence(0, 9));
              this.DuF.append("...");
            }
            localObject = (ViewGroup.MarginLayoutParams)this.DuD.getLayoutParams();
            ((ViewGroup.MarginLayoutParams)localObject).topMargin = com.tencent.mm.cb.a.fromDPToPix(this, 50);
            this.DuD.setLayoutParams((ViewGroup.LayoutParams)localObject);
            this.DuD.setVisibility(0);
          }
          break;
        }
      }
    }
    label639:
    while ((this.Dur.Dnk == null) || (bu.isNullOrNil(this.Dur.Dnk.CRv)) || (!this.Dur.eIG())) {
      for (;;)
      {
        RelativeLayout.LayoutParams localLayoutParams;
        int i;
        if (this.DuF.getVisibility() == 0) {
          this.DuF.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(70753);
              if ((WalletBindCardResultUI.g(WalletBindCardResultUI.this).getVisibility() == 0) && (WalletBindCardResultUI.h(WalletBindCardResultUI.this).getRight() >= WalletBindCardResultUI.g(WalletBindCardResultUI.this).getLeft()) && (!bu.ah(WalletBindCardResultUI.h(WalletBindCardResultUI.this).getText())))
              {
                float f1 = WalletBindCardResultUI.h(WalletBindCardResultUI.this).getTextSize();
                ae.i("MicroMsg.WalletBindCardResultUI", "tinyAppDescTv size exceed, tinyAppDescTv.getRight(): %s, tinyAppButton.getLeft(): %s", new Object[] { Integer.valueOf(WalletBindCardResultUI.h(WalletBindCardResultUI.this).getRight()), Integer.valueOf(WalletBindCardResultUI.g(WalletBindCardResultUI.this).getLeft()) });
                Paint localPaint = new Paint();
                localPaint.setTextSize(f1);
                String str = WalletBindCardResultUI.h(WalletBindCardResultUI.this).getText().toString();
                f1 = localPaint.measureText(str);
                float f2 = WalletBindCardResultUI.h(WalletBindCardResultUI.this).getRight() - WalletBindCardResultUI.g(WalletBindCardResultUI.this).getLeft();
                int i = 1;
                while ((localPaint.measureText(str.substring(0, str.length() - i - 1)) > f1 - f2) && (i <= str.length() - 1)) {
                  i += 1;
                }
                ae.i("MicroMsg.WalletBindCardResultUI", "tinyAppDescTv, exceed len, final search count: %s, text.length: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(str.length()) });
                WalletBindCardResultUI.h(WalletBindCardResultUI.this).setText(str.substring(0, str.length() - i - 1));
                WalletBindCardResultUI.h(WalletBindCardResultUI.this).append("...");
              }
              AppMethodBeat.o(70753);
            }
          });
        }
        if (this.DuD.getVisibility() == 8)
        {
          localObject = (ViewGroup.MarginLayoutParams)this.DuC.getLayoutParams();
          ((ViewGroup.MarginLayoutParams)localObject).topMargin = com.tencent.mm.cb.a.fromDPToPix(this, 91);
          this.DuC.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        AppMethodBeat.o(70761);
        return;
        this.DuE.setUrl(this.Dur.Dnj.xcF);
        this.DuF.setText(this.Dur.Dnj.name);
        this.DuI.setText(this.Dur.Dnj.Dpr);
        continue;
        if (!bu.isNullOrNil(this.Dur.Dnj.title))
        {
          this.DuG.setText(this.Dur.Dnj.title);
          localLayoutParams.addRule(15, 0);
        }
        else
        {
          this.DuG.setVisibility(8);
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
                      this.DuI.setEnabled(false);
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
    this.Dut = this.Dur.Dnk.CRv;
    this.Duu = this.Dur.Dnk.CRw;
    this.Dpw = this.Dur.Dnk.Dpw;
    this.Duv = this.Dur.Dnk;
    this.DuE.setUrl(this.Dur.Dnk.Dpt);
    this.DuF.setText(this.Dur.Dnk.Dpu);
    this.DuG.setText(getString(2131764967));
    this.DuG.setVisibility(0);
    this.DuE.setRoundCorner(true);
    this.DuI.setEnabled(true);
    this.DuI.setBackgroundResource(2131231365);
    Object localObject = (RelativeLayout.LayoutParams)this.DuG.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).addRule(15, 0);
    this.DuG.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (this.Dur.Dni.vlr > 0L)
    {
      if (!bu.isNullOrNil(this.Dur.Dnk.Dpv))
      {
        this.DuI.setVisibility(0);
        this.DuI.setText(this.Dur.Dnk.Dpv);
        this.DuH.setVisibility(8);
      }
      localObject = (WalletOrderInfoNewUI.a)this.Dux.get(this.Dur.Dni.vlr);
      if (localObject != null)
      {
        if (!bu.isNullOrNil(((WalletOrderInfoNewUI.a)localObject).Dpt)) {
          this.DuE.setUrl(((WalletOrderInfoNewUI.a)localObject).Dpt);
        }
        if (!bu.isNullOrNil(((WalletOrderInfoNewUI.a)localObject).Dpu)) {
          this.DuF.setText(((WalletOrderInfoNewUI.a)localObject).Dpu);
        }
        if (!bu.isNullOrNil(((WalletOrderInfoNewUI.a)localObject).Dpv))
        {
          this.DuI.setText(((WalletOrderInfoNewUI.a)localObject).Dpv);
          this.DuI.setBackgroundResource(2131234694);
        }
        if (!bu.isNullOrNil(((WalletOrderInfoNewUI.a)localObject).CRv)) {
          this.Dut = ((WalletOrderInfoNewUI.a)localObject).CRv;
        }
        if (!bu.isNullOrNil(((WalletOrderInfoNewUI.a)localObject).CRw)) {
          this.Duu = ((WalletOrderInfoNewUI.a)localObject).CRw;
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
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletBindCardResultUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          ae.i("MicroMsg.WalletBindCardResultUI", "click tiny app, userName: %s, path: %s, version: %s", new Object[] { WalletBindCardResultUI.c(WalletBindCardResultUI.this), WalletBindCardResultUI.d(WalletBindCardResultUI.this), Integer.valueOf(WalletBindCardResultUI.e(WalletBindCardResultUI.this)) });
          WalletBindCardResultUI.this.mZ(2);
          paramAnonymousView = new vq();
          paramAnonymousView.dKT.userName = WalletBindCardResultUI.c(WalletBindCardResultUI.this);
          paramAnonymousView.dKT.dKV = bu.bI(WalletBindCardResultUI.d(WalletBindCardResultUI.this), "");
          paramAnonymousView.dKT.scene = 1034;
          paramAnonymousView.dKT.dKW = 0;
          if (WalletBindCardResultUI.e(WalletBindCardResultUI.this) > 0) {
            paramAnonymousView.dKT.aDD = WalletBindCardResultUI.e(WalletBindCardResultUI.this);
          }
          com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousView);
          if ((!bu.isNullOrNil(WalletBindCardResultUI.f(WalletBindCardResultUI.this).Dnk.Dpv)) && (WalletBindCardResultUI.f(WalletBindCardResultUI.this).Dni.vlr > 0L)) {
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
      this.DuD.setOnClickListener((View.OnClickListener)localObject);
      this.DuI.setOnClickListener((View.OnClickListener)localObject);
      localObject = this.DuF.getText();
      if ((bu.ah((CharSequence)localObject)) || (((CharSequence)localObject).length() <= 9)) {
        break;
      }
      this.DuF.setText(((CharSequence)localObject).subSequence(0, 9));
      this.DuF.append("...");
      break;
      this.DuI.setVisibility(8);
      this.DuH.setVisibility(8);
    }
  }
  
  private void eKZ()
  {
    int i = 0;
    AppMethodBeat.i(70768);
    if (!this.Dus)
    {
      ko localko = new ko();
      localko.dyC.requestCode = 4;
      ko.a locala = localko.dyC;
      if (getInput().getBoolean("intent_pay_end", false)) {
        i = -1;
      }
      locala.bZU = i;
      com.tencent.mm.sdk.b.a.IvT.l(localko);
      this.Dus = true;
    }
    AppMethodBeat.o(70768);
  }
  
  public final void done()
  {
    AppMethodBeat.i(70765);
    Bundle localBundle = new Bundle();
    if (this.DuN != null)
    {
      this.DuN.a(this, 0, localBundle);
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
    this.DuC = ((ImageView)findViewById(2131307115));
    this.yvU = ((TextView)findViewById(2131303156));
    this.DuB = ((Button)findViewById(2131303152));
    showHomeBtn(false);
    enableBackMenu(false);
    String str = getString(2131755779);
    if ((this.Dur != null) && (!bu.isNullOrNil(this.Dur.Dnb))) {
      this.DuB.setText(this.Dur.Dnb);
    }
    for (;;)
    {
      this.DuB.setOnClickListener(new WalletBindCardResultUI.2(this));
      this.DuJ = ((ViewGroup)findViewById(2131306773));
      this.DuD = ((ViewGroup)findViewById(2131305855));
      this.DuE = ((CdnImageView)findViewById(2131305857));
      this.DuE.setUseSdcardCache(true);
      this.DuF = ((TextView)findViewById(2131305854));
      this.DuG = ((TextView)findViewById(2131305859));
      this.DuI = ((Button)findViewById(2131305852));
      this.DuH = findViewById(2131305856);
      this.DuJ.setVisibility(4);
      eKX();
      eKY();
      eKW();
      if ((!bu.isNullOrNil(this.Dur.Dnd)) && (!bu.isNullOrNil(this.Dur.Dne))) {
        ((TextView)findViewById(2131303157)).setText(getString(2131765065, new Object[] { this.Dur.Dnd, this.Dur.Dne }));
      }
      AppMethodBeat.o(70758);
      return;
      this.DuB.setText(str);
    }
  }
  
  public final void mZ(int paramInt)
  {
    AppMethodBeat.i(70771);
    g localg = g.yxI;
    if (this.Dur.Dni == null) {}
    for (String str = "";; str = bu.bI(this.Dur.Dni.vlr, ""))
    {
      localg.f(14877, new Object[] { str, this.Dur.Dnf, Integer.valueOf(paramInt), this.Dur.dlT });
      AppMethodBeat.o(70771);
      return;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(70763);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ae.i("MicroMsg.WalletBindCardResultUI", "onActivityResult %d %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 1)
    {
      ae.i("MicroMsg.WalletBindCardResultUI", "do query pay arawrd");
      doSceneProgress(new ac(this.Duw.DgU, this.Duw.DyP, this.Duw.DyQ, this.Duw.DyR, this.Duw.Drb, this.Duw.DyS, this.Dur.dlT, this.Dur.Dnf, this.Dur.Dng, this.Dur.Dng));
    }
    AppMethodBeat.o(70763);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(70756);
    super.onCreate(paramBundle);
    if (com.tencent.mm.compatible.util.d.lA(21))
    {
      if (!com.tencent.mm.compatible.util.d.lA(23)) {
        break label172;
      }
      getWindow().setStatusBarColor(getResources().getColor(2131101179));
    }
    for (;;)
    {
      setContentViewVisibility(4);
      com.tencent.mm.wallet_core.a.bs(this);
      this.mPayInfo = ((PayInfo)getInput().getParcelable("key_pay_info"));
      getInput().getInt("key_pay_type", -1);
      BindCardOrder localBindCardOrder = (BindCardOrder)getInput().getParcelable("key_bindcard_value_result");
      paramBundle = localBindCardOrder;
      if (localBindCardOrder == null) {
        paramBundle = new BindCardOrder();
      }
      this.Dur = paramBundle;
      setContentViewVisibility(0);
      initView();
      this.DuN = getProcess();
      eKX();
      mZ(1);
      addSceneEndListener(1979);
      com.tencent.mm.sdk.b.a.IvT.c(this.wQx);
      this.DuM = true;
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
    com.tencent.mm.sdk.b.a.IvT.d(this.wQx);
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
    ae.i("MicroMsg.WalletBindCardResultUI", "onResume, isFirstInit: %s activityPromotions: %s, isClickTinyappActivity: %s, isClickActivity: %s, recommendTinyAppInfo: %s", new Object[] { Boolean.valueOf(this.DuM), this.Duz, Boolean.valueOf(this.DuK), Boolean.valueOf(this.DuL), this.Duv });
    if (this.DuM)
    {
      this.DuM = false;
      AppMethodBeat.o(70757);
      return;
    }
    if ((this.Duz != null) && (this.DuL))
    {
      doSceneProgress(new ac(this.Duz.Dni.vlr, this.Duz.Dni.Dpn, this.Duz.Dni.Dpo, this.Duz.Dni.Dpp, this.Duz.Dni.Dpm, this.Duz.Dni.Dpq, this.Dur.dlT, this.Dur.Dnf, this.Dur.Dng, this.Dur.Dng));
      AppMethodBeat.o(70757);
      return;
    }
    if ((this.DuK) && (this.Duv != null)) {
      doSceneProgress(new ac(this.Dur.Dni.vlr, this.Dur.Dni.Dpn, this.Dur.Dni.Dpo, this.Dur.Dni.Dpp, this.Dur.Dni.Dpq, this.Dur.Dni.Dpm, this.Dur.dlT, this.Dur.Dnf, this.Dur.Dng, this.Dur.Dng));
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
        paramn = new WalletOrderInfoNewUI.a(paramString.kuc);
        if (this.Duw == null) {
          break label78;
        }
        this.Dux.put(paramString.DgU, paramn);
        eKY();
        eKW();
      }
    }
    label78:
    while (!(paramn instanceof r)) {
      for (;;)
      {
        AppMethodBeat.o(70769);
        return false;
        if (this.DuK)
        {
          this.Dux.put(paramString.DgU, paramn);
          eKY();
          eKW();
        }
      }
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = (r)paramn;
      paramn = paramString.DgC;
      if ((this.Duz != null) && (this.Duz.Dni.vlr == paramString.DgE.Dni.vlr))
      {
        ae.i("MicroMsg.WalletBindCardResultUI", "activityAwardState: %s", new Object[] { this.Duz });
        this.DuA = paramn;
        eKY();
        eKW();
        if ((!bu.isNullOrNil(paramString.fMT)) && (!"3".equals(paramn))) {
          this.DuI.setText(paramString.fMT);
        }
      }
      if ((!"-1".equals(paramn)) && (!"0".equals(paramn)) && (!bu.isNullOrNil(paramString.DgD))) {
        h.c(this, paramString.DgD, "", true);
      }
      while (!"0".equals(paramn))
      {
        AppMethodBeat.o(70769);
        return true;
      }
      if (!bu.isNullOrNil(paramString.DgD)) {}
      for (paramString = paramString.DgD;; paramString = getString(2131765658))
      {
        Toast.makeText(this, paramString, 0).show();
        break;
      }
    }
    paramn = paramString;
    if (bu.isNullOrNil(paramString)) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletBindCardResultUI
 * JD-Core Version:    0.7.0.1
 */