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
import com.tencent.mm.g.a.kf;
import com.tencent.mm.g.a.kf.a;
import com.tencent.mm.g.a.ut;
import com.tencent.mm.g.a.xs;
import com.tencent.mm.plugin.wallet_core.model.BindCardOrder;
import com.tencent.mm.plugin.wallet_core.model.r.a;
import com.tencent.mm.plugin.wallet_core.model.r.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import java.util.HashMap;

@com.tencent.mm.ui.base.a(3)
public class WalletBindCardResultUI
  extends WalletBaseUI
{
  private WalletOrderInfoNewUI.b BCA;
  private HashMap<String, WalletOrderInfoNewUI.a> BCB;
  private String BCC;
  private BindCardOrder BCD;
  private String BCE;
  private Button BCF;
  private ImageView BCG;
  private ViewGroup BCH;
  private CdnImageView BCI;
  private TextView BCJ;
  private TextView BCK;
  private View BCL;
  private Button BCM;
  private ViewGroup BCN;
  private boolean BCO;
  private boolean BCP;
  private boolean BCQ;
  private com.tencent.mm.wallet_core.d BCR;
  private BindCardOrder BCv;
  private boolean BCw;
  private String BCx;
  private String BCy;
  private r.b BCz;
  private int Bxy;
  private PayInfo mPayInfo;
  private c vvs;
  private String vyB;
  private String wRe;
  private TextView wSw;
  
  public WalletBindCardResultUI()
  {
    AppMethodBeat.i(70755);
    this.vyB = null;
    this.BCw = false;
    this.BCB = new HashMap();
    this.BCD = null;
    this.BCE = "-1";
    this.BCO = false;
    this.BCP = false;
    this.BCQ = false;
    this.vvs = new c() {};
    AppMethodBeat.o(70755);
  }
  
  private void Tw(String paramString)
  {
    AppMethodBeat.i(70762);
    etl();
    e.o(this, paramString, false);
    AppMethodBeat.o(70762);
  }
  
  private void eti()
  {
    AppMethodBeat.i(70759);
    this.BCN.setVisibility(0);
    AppMethodBeat.o(70759);
  }
  
  private void etj()
  {
    AppMethodBeat.i(70760);
    this.wSw.setText(this.BCv.Bvh);
    AppMethodBeat.o(70760);
  }
  
  private void etk()
  {
    AppMethodBeat.i(70761);
    this.BCH.setVisibility(4);
    this.BCP = false;
    this.BCO = false;
    if (this.BCv != null) {
      if (this.BCv.Bvn != null)
      {
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WalletBindCardResultUI", "activityPromotions: %s", new Object[] { this.BCD });
        if ((this.BCv == null) || ((!this.BCv.eqY()) && (!this.BCv.era())) || (this.BCv.Bvn.BoC <= 0L) || (bs.isNullOrNil(this.BCv.Bvo.Bxt))) {
          break label854;
        }
        this.BCD = this.BCv;
        this.BCL.setVisibility(8);
        this.BCI.setRoundCorner(true);
        this.BCM.setEnabled(true);
        this.BCM.setBackgroundResource(2131231365);
        this.BCK.setCompoundDrawables(null, null, null, null);
        localObject = (WalletOrderInfoNewUI.a)this.BCB.get(this.BCD.Bvn.BoC);
        if (localObject == null) {
          break label639;
        }
        if (!bs.isNullOrNil(((WalletOrderInfoNewUI.a)localObject).drM)) {
          this.BCI.setUrl(((WalletOrderInfoNewUI.a)localObject).drM);
        }
        if (!bs.isNullOrNil(((WalletOrderInfoNewUI.a)localObject).dlQ)) {
          this.BCJ.setText(((WalletOrderInfoNewUI.a)localObject).dlQ);
        }
        if (!bs.isNullOrNil(((WalletOrderInfoNewUI.a)localObject).BGR))
        {
          this.BCM.setText(((WalletOrderInfoNewUI.a)localObject).BGR);
          this.BCM.setBackgroundResource(2131234694);
        }
        localLayoutParams = (RelativeLayout.LayoutParams)this.BCK.getLayoutParams();
        if ((localObject == null) || (bs.isNullOrNil(((WalletOrderInfoNewUI.a)localObject).title))) {
          break label693;
        }
        this.BCK.setText(((WalletOrderInfoNewUI.a)localObject).title);
        localLayoutParams.addRule(15, 0);
        this.BCK.setLayoutParams(localLayoutParams);
        this.BCM.setVisibility(0);
        this.BCM.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(70750);
            com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WalletBindCardResultUI", "click activity button");
            WalletBindCardResultUI.b(WalletBindCardResultUI.this);
            AppMethodBeat.o(70750);
          }
        });
        if (this.BCD.Bvn.Bxo != 1L) {
          this.BCH.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(70751);
              com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WalletBindCardResultUI", "click activity layout");
              WalletBindCardResultUI.b(WalletBindCardResultUI.this);
              AppMethodBeat.o(70751);
            }
          });
        }
        localObject = this.BCE;
        i = -1;
        switch (((String)localObject).hashCode())
        {
        default: 
          switch (i)
          {
          default: 
            localObject = this.BCJ.getText();
            if ((!bs.aj((CharSequence)localObject)) && (((CharSequence)localObject).length() > 9))
            {
              this.BCJ.setText(((CharSequence)localObject).subSequence(0, 9));
              this.BCJ.append("...");
            }
            localObject = (ViewGroup.MarginLayoutParams)this.BCH.getLayoutParams();
            ((ViewGroup.MarginLayoutParams)localObject).topMargin = com.tencent.mm.cc.a.fromDPToPix(this, 50);
            this.BCH.setLayoutParams((ViewGroup.LayoutParams)localObject);
            this.BCH.setVisibility(0);
          }
          break;
        }
      }
    }
    label639:
    while ((this.BCv.Bvp == null) || (bs.isNullOrNil(this.BCv.Bvp.AZE)) || (!this.BCv.eqZ())) {
      for (;;)
      {
        RelativeLayout.LayoutParams localLayoutParams;
        int i;
        if (this.BCJ.getVisibility() == 0) {
          this.BCJ.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(70753);
              if ((WalletBindCardResultUI.g(WalletBindCardResultUI.this).getVisibility() == 0) && (WalletBindCardResultUI.h(WalletBindCardResultUI.this).getRight() >= WalletBindCardResultUI.g(WalletBindCardResultUI.this).getLeft()) && (!bs.aj(WalletBindCardResultUI.h(WalletBindCardResultUI.this).getText())))
              {
                float f1 = WalletBindCardResultUI.h(WalletBindCardResultUI.this).getTextSize();
                com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WalletBindCardResultUI", "tinyAppDescTv size exceed, tinyAppDescTv.getRight(): %s, tinyAppButton.getLeft(): %s", new Object[] { Integer.valueOf(WalletBindCardResultUI.h(WalletBindCardResultUI.this).getRight()), Integer.valueOf(WalletBindCardResultUI.g(WalletBindCardResultUI.this).getLeft()) });
                Paint localPaint = new Paint();
                localPaint.setTextSize(f1);
                String str = WalletBindCardResultUI.h(WalletBindCardResultUI.this).getText().toString();
                f1 = localPaint.measureText(str);
                float f2 = WalletBindCardResultUI.h(WalletBindCardResultUI.this).getRight() - WalletBindCardResultUI.g(WalletBindCardResultUI.this).getLeft();
                int i = 1;
                while ((localPaint.measureText(str.substring(0, str.length() - i - 1)) > f1 - f2) && (i <= str.length() - 1)) {
                  i += 1;
                }
                com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WalletBindCardResultUI", "tinyAppDescTv, exceed len, final search count: %s, text.length: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(str.length()) });
                WalletBindCardResultUI.h(WalletBindCardResultUI.this).setText(str.substring(0, str.length() - i - 1));
                WalletBindCardResultUI.h(WalletBindCardResultUI.this).append("...");
              }
              AppMethodBeat.o(70753);
            }
          });
        }
        if (this.BCH.getVisibility() == 8)
        {
          localObject = (ViewGroup.MarginLayoutParams)this.BCG.getLayoutParams();
          ((ViewGroup.MarginLayoutParams)localObject).topMargin = com.tencent.mm.cc.a.fromDPToPix(this, 91);
          this.BCG.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        AppMethodBeat.o(70761);
        return;
        this.BCI.setUrl(this.BCv.Bvo.vFL);
        this.BCJ.setText(this.BCv.Bvo.name);
        this.BCM.setText(this.BCv.Bvo.Bxt);
        continue;
        if (!bs.isNullOrNil(this.BCv.Bvo.title))
        {
          this.BCK.setText(this.BCv.Bvo.title);
          localLayoutParams.addRule(15, 0);
        }
        else
        {
          this.BCK.setVisibility(8);
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
                      this.BCM.setEnabled(false);
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
    this.BCx = this.BCv.Bvp.AZE;
    this.BCy = this.BCv.Bvp.AZF;
    this.Bxy = this.BCv.Bvp.Bxy;
    this.BCz = this.BCv.Bvp;
    this.BCI.setUrl(this.BCv.Bvp.Bxv);
    this.BCJ.setText(this.BCv.Bvp.Bxw);
    this.BCK.setText(getString(2131764967));
    this.BCK.setVisibility(0);
    this.BCI.setRoundCorner(true);
    this.BCM.setEnabled(true);
    this.BCM.setBackgroundResource(2131231365);
    Object localObject = (RelativeLayout.LayoutParams)this.BCK.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).addRule(15, 0);
    this.BCK.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (this.BCv.Bvn.BoC > 0L)
    {
      if (!bs.isNullOrNil(this.BCv.Bvp.Bxx))
      {
        this.BCM.setVisibility(0);
        this.BCM.setText(this.BCv.Bvp.Bxx);
        this.BCL.setVisibility(8);
      }
      localObject = (WalletOrderInfoNewUI.a)this.BCB.get(this.BCv.Bvn.BoC);
      if (localObject != null)
      {
        if (!bs.isNullOrNil(((WalletOrderInfoNewUI.a)localObject).Bxv)) {
          this.BCI.setUrl(((WalletOrderInfoNewUI.a)localObject).Bxv);
        }
        if (!bs.isNullOrNil(((WalletOrderInfoNewUI.a)localObject).Bxw)) {
          this.BCJ.setText(((WalletOrderInfoNewUI.a)localObject).Bxw);
        }
        if (!bs.isNullOrNil(((WalletOrderInfoNewUI.a)localObject).Bxx))
        {
          this.BCM.setText(((WalletOrderInfoNewUI.a)localObject).Bxx);
          this.BCM.setBackgroundResource(2131234694);
        }
        if (!bs.isNullOrNil(((WalletOrderInfoNewUI.a)localObject).AZE)) {
          this.BCx = ((WalletOrderInfoNewUI.a)localObject).AZE;
        }
        if (!bs.isNullOrNil(((WalletOrderInfoNewUI.a)localObject).AZF)) {
          this.BCy = ((WalletOrderInfoNewUI.a)localObject).AZF;
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
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WalletBindCardResultUI", "click tiny app, userName: %s, path: %s, version: %s", new Object[] { WalletBindCardResultUI.c(WalletBindCardResultUI.this), WalletBindCardResultUI.d(WalletBindCardResultUI.this), Integer.valueOf(WalletBindCardResultUI.e(WalletBindCardResultUI.this)) });
          WalletBindCardResultUI.this.mx(2);
          paramAnonymousView = new ut();
          paramAnonymousView.dxt.userName = WalletBindCardResultUI.c(WalletBindCardResultUI.this);
          paramAnonymousView.dxt.dxv = bs.bG(WalletBindCardResultUI.d(WalletBindCardResultUI.this), "");
          paramAnonymousView.dxt.scene = 1034;
          paramAnonymousView.dxt.dxw = 0;
          if (WalletBindCardResultUI.e(WalletBindCardResultUI.this) > 0) {
            paramAnonymousView.dxt.aBM = WalletBindCardResultUI.e(WalletBindCardResultUI.this);
          }
          com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousView);
          if ((!bs.isNullOrNil(WalletBindCardResultUI.f(WalletBindCardResultUI.this).Bvp.Bxx)) && (WalletBindCardResultUI.f(WalletBindCardResultUI.this).Bvn.BoC > 0L))
          {
            WalletBindCardResultUI.a(WalletBindCardResultUI.this, true);
            AppMethodBeat.o(70752);
            return;
          }
          WalletBindCardResultUI.a(WalletBindCardResultUI.this, false);
          AppMethodBeat.o(70752);
        }
      };
      this.BCH.setOnClickListener((View.OnClickListener)localObject);
      this.BCM.setOnClickListener((View.OnClickListener)localObject);
      localObject = this.BCJ.getText();
      if ((bs.aj((CharSequence)localObject)) || (((CharSequence)localObject).length() <= 9)) {
        break;
      }
      this.BCJ.setText(((CharSequence)localObject).subSequence(0, 9));
      this.BCJ.append("...");
      break;
      this.BCM.setVisibility(8);
      this.BCL.setVisibility(8);
    }
  }
  
  private void etl()
  {
    int i = 0;
    AppMethodBeat.i(70768);
    if (!this.BCw)
    {
      kf localkf = new kf();
      localkf.dlK.requestCode = 4;
      kf.a locala = localkf.dlK;
      if (getInput().getBoolean("intent_pay_end", false)) {
        i = -1;
      }
      locala.bPH = i;
      com.tencent.mm.sdk.b.a.GpY.l(localkf);
      this.BCw = true;
    }
    AppMethodBeat.o(70768);
  }
  
  public final void done()
  {
    AppMethodBeat.i(70765);
    Bundle localBundle = new Bundle();
    if (this.BCR != null)
    {
      this.BCR.a(this, 0, localBundle);
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
    this.BCG = ((ImageView)findViewById(2131307115));
    this.wSw = ((TextView)findViewById(2131303156));
    this.BCF = ((Button)findViewById(2131303152));
    showHomeBtn(false);
    enableBackMenu(false);
    String str = getString(2131755779);
    if ((this.BCv != null) && (!bs.isNullOrNil(this.BCv.Bvg))) {
      this.BCF.setText(this.BCv.Bvg);
    }
    for (;;)
    {
      this.BCF.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(70749);
          WalletBindCardResultUI.this.done();
          AppMethodBeat.o(70749);
        }
      });
      this.BCN = ((ViewGroup)findViewById(2131306773));
      this.BCH = ((ViewGroup)findViewById(2131305855));
      this.BCI = ((CdnImageView)findViewById(2131305857));
      this.BCI.setUseSdcardCache(true);
      this.BCJ = ((TextView)findViewById(2131305854));
      this.BCK = ((TextView)findViewById(2131305859));
      this.BCM = ((Button)findViewById(2131305852));
      this.BCL = findViewById(2131305856);
      this.BCN.setVisibility(4);
      etj();
      etk();
      eti();
      if ((!bs.isNullOrNil(this.BCv.Bvi)) && (!bs.isNullOrNil(this.BCv.Bvj))) {
        ((TextView)findViewById(2131303157)).setText(getString(2131765065, new Object[] { this.BCv.Bvi, this.BCv.Bvj }));
      }
      AppMethodBeat.o(70758);
      return;
      this.BCF.setText(str);
    }
  }
  
  public final void mx(int paramInt)
  {
    AppMethodBeat.i(70771);
    com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.wUl;
    if (this.BCv.Bvn == null) {}
    for (String str = "";; str = bs.bG(this.BCv.Bvn.BoC, ""))
    {
      localh.f(14877, new Object[] { str, this.BCv.Bvk, Integer.valueOf(paramInt), this.BCv.cZz });
      AppMethodBeat.o(70771);
      return;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(70763);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WalletBindCardResultUI", "onActivityResult %d %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 1)
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WalletBindCardResultUI", "do query pay arawrd");
      doSceneProgress(new com.tencent.mm.plugin.wallet_core.c.ac(this.BCA.Bpb, this.BCA.BGT, this.BCA.BGU, this.BCA.BGV, this.BCA.Bzd, this.BCA.BGW, this.BCv.cZz, this.BCv.Bvk, this.BCv.Bvl, this.BCv.Bvl));
    }
    AppMethodBeat.o(70763);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(70756);
    super.onCreate(paramBundle);
    if (com.tencent.mm.compatible.util.d.kZ(21))
    {
      if (!com.tencent.mm.compatible.util.d.kZ(23)) {
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
      this.BCv = paramBundle;
      setContentViewVisibility(0);
      initView();
      this.BCR = getProcess();
      etj();
      mx(1);
      addSceneEndListener(1979);
      com.tencent.mm.sdk.b.a.GpY.c(this.vvs);
      this.BCQ = true;
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
    Dialog localDialog = com.tencent.mm.ui.base.h.a(getContext(), getString(2131765565), getResources().getStringArray(2130903098), "", new WalletBindCardResultUI.7(this));
    AppMethodBeat.o(70764);
    return localDialog;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(70767);
    super.onDestroy();
    com.tencent.mm.sdk.b.a.GpY.d(this.vvs);
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
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WalletBindCardResultUI", "onResume, isFirstInit: %s activityPromotions: %s, isClickTinyappActivity: %s, isClickActivity: %s, recommendTinyAppInfo: %s", new Object[] { Boolean.valueOf(this.BCQ), this.BCD, Boolean.valueOf(this.BCO), Boolean.valueOf(this.BCP), this.BCz });
    if (this.BCQ)
    {
      this.BCQ = false;
      AppMethodBeat.o(70757);
      return;
    }
    if ((this.BCD != null) && (this.BCP))
    {
      doSceneProgress(new com.tencent.mm.plugin.wallet_core.c.ac(this.BCD.Bvn.BoC, this.BCD.Bvn.Bxp, this.BCD.Bvn.Bxq, this.BCD.Bvn.Bxr, this.BCD.Bvn.Bxo, this.BCD.Bvn.Bxs, this.BCv.cZz, this.BCv.Bvk, this.BCv.Bvl, this.BCv.Bvl));
      AppMethodBeat.o(70757);
      return;
    }
    if ((this.BCO) && (this.BCz != null)) {
      doSceneProgress(new com.tencent.mm.plugin.wallet_core.c.ac(this.BCv.Bvn.BoC, this.BCv.Bvn.Bxp, this.BCv.Bvn.Bxq, this.BCv.Bvn.Bxr, this.BCv.Bvn.Bxs, this.BCv.Bvn.Bxo, this.BCv.cZz, this.BCv.Bvk, this.BCv.Bvl, this.BCv.Bvl));
    }
    AppMethodBeat.o(70757);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(70769);
    if ((paramn instanceof com.tencent.mm.plugin.wallet_core.c.ac)) {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (com.tencent.mm.plugin.wallet_core.c.ac)paramn;
        paramn = new WalletOrderInfoNewUI.a(paramString.jWw);
        if (this.BCA == null) {
          break label78;
        }
        this.BCB.put(paramString.Bpb, paramn);
        etk();
        eti();
      }
    }
    label78:
    while (!(paramn instanceof com.tencent.mm.plugin.wallet_core.c.r)) {
      for (;;)
      {
        AppMethodBeat.o(70769);
        return false;
        if (this.BCO)
        {
          this.BCB.put(paramString.Bpb, paramn);
          etk();
          eti();
        }
      }
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = (com.tencent.mm.plugin.wallet_core.c.r)paramn;
      paramn = paramString.BoJ;
      if ((this.BCD != null) && (this.BCD.Bvn.BoC == paramString.BoL.Bvn.BoC))
      {
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WalletBindCardResultUI", "activityAwardState: %s", new Object[] { this.BCD });
        this.BCE = paramn;
        etk();
        eti();
        if ((!bs.isNullOrNil(paramString.fsq)) && (!"3".equals(paramn))) {
          this.BCM.setText(paramString.fsq);
        }
      }
      if ((!"-1".equals(paramn)) && (!"0".equals(paramn)) && (!bs.isNullOrNil(paramString.BoK))) {
        com.tencent.mm.ui.base.h.c(this, paramString.BoK, "", true);
      }
      while (!"0".equals(paramn))
      {
        AppMethodBeat.o(70769);
        return true;
      }
      if (!bs.isNullOrNil(paramString.BoK)) {}
      for (paramString = paramString.BoK;; paramString = getString(2131765658))
      {
        Toast.makeText(this, paramString, 0).show();
        break;
      }
    }
    paramn = paramString;
    if (bs.isNullOrNil(paramString)) {
      paramn = getString(2131765901);
    }
    com.tencent.mm.ui.base.h.a(this, paramn, null, false, new DialogInterface.OnClickListener()
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