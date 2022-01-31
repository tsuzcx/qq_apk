package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
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
import com.tencent.mm.ai.m;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.iz;
import com.tencent.mm.g.a.iz.a;
import com.tencent.mm.plugin.wallet_core.c.aa;
import com.tencent.mm.plugin.wallet_core.c.p;
import com.tencent.mm.plugin.wallet_core.model.BindCardOrder;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.plugin.wallet_core.model.s.a;
import com.tencent.mm.plugin.wallet_core.model.s.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import java.util.HashMap;

@com.tencent.mm.ui.base.a(3)
public class WalletBindCardResultUI
  extends WalletBaseUI
{
  private PayInfo mPayInfo;
  private com.tencent.mm.sdk.b.c pns;
  private String pqF;
  private String qpN;
  private TextView qrh;
  private int uiT;
  private String unA;
  private BindCardOrder unB;
  private String unC;
  private Button unD;
  private ImageView unE;
  private ViewGroup unF;
  private CdnImageView unG;
  private TextView unH;
  private TextView unI;
  private View unJ;
  private Button unK;
  private ViewGroup unL;
  private boolean unM;
  private boolean unN;
  private boolean unO;
  private com.tencent.mm.wallet_core.c unP;
  private BindCardOrder unt;
  private boolean unu;
  private String unv;
  private String unw;
  private s.b unx;
  private WalletOrderInfoNewUI.b uny;
  private HashMap<String, WalletOrderInfoNewUI.a> unz;
  
  public WalletBindCardResultUI()
  {
    AppMethodBeat.i(47193);
    this.pqF = null;
    this.unu = false;
    this.unz = new HashMap();
    this.unB = null;
    this.unC = "-1";
    this.unM = false;
    this.unN = false;
    this.unO = false;
    this.pns = new WalletBindCardResultUI.1(this);
    AppMethodBeat.o(47193);
  }
  
  private void afI(String paramString)
  {
    AppMethodBeat.i(47200);
    cVu();
    e.m(this, paramString, false);
    AppMethodBeat.o(47200);
  }
  
  private void cVr()
  {
    AppMethodBeat.i(47197);
    this.unL.setVisibility(0);
    AppMethodBeat.o(47197);
  }
  
  private void cVs()
  {
    AppMethodBeat.i(47198);
    this.qrh.setText(this.unt.ugF);
    AppMethodBeat.o(47198);
  }
  
  private void cVt()
  {
    AppMethodBeat.i(47199);
    this.unF.setVisibility(4);
    this.unN = false;
    this.unM = false;
    if (this.unt != null) {
      if (this.unt.ugL != null)
      {
        ab.i("MicroMsg.WalletBindCardResultUI", "activityPromotions: %s", new Object[] { this.unB });
        if ((this.unt == null) || ((!this.unt.cTm()) && (!this.unt.cTo())) || (this.unt.ugL.ubC <= 0L) || (bo.isNullOrNil(this.unt.ugM.uiO))) {
          break label854;
        }
        this.unB = this.unt;
        this.unJ.setVisibility(8);
        this.unG.setRoundCorner(true);
        this.unK.setEnabled(true);
        this.unK.setBackgroundResource(2130838045);
        this.unI.setCompoundDrawables(null, null, null, null);
        localObject = (WalletOrderInfoNewUI.a)this.unz.get(this.unB.ugL.ubC);
        if (localObject == null) {
          break label639;
        }
        if (!bo.isNullOrNil(((WalletOrderInfoNewUI.a)localObject).cDz)) {
          this.unG.setUrl(((WalletOrderInfoNewUI.a)localObject).cDz);
        }
        if (!bo.isNullOrNil(((WalletOrderInfoNewUI.a)localObject).cyA)) {
          this.unH.setText(((WalletOrderInfoNewUI.a)localObject).cyA);
        }
        if (!bo.isNullOrNil(((WalletOrderInfoNewUI.a)localObject).urC))
        {
          this.unK.setText(((WalletOrderInfoNewUI.a)localObject).urC);
          this.unK.setBackgroundResource(2130840866);
        }
        localLayoutParams = (RelativeLayout.LayoutParams)this.unI.getLayoutParams();
        if ((localObject == null) || (bo.isNullOrNil(((WalletOrderInfoNewUI.a)localObject).title))) {
          break label693;
        }
        this.unI.setText(((WalletOrderInfoNewUI.a)localObject).title);
        localLayoutParams.addRule(15, 0);
        this.unI.setLayoutParams(localLayoutParams);
        this.unK.setVisibility(0);
        this.unK.setOnClickListener(new WalletBindCardResultUI.3(this));
        if (this.unB.ugL.uiJ != 1L) {
          this.unF.setOnClickListener(new WalletBindCardResultUI.4(this));
        }
        localObject = this.unC;
        i = -1;
        switch (((String)localObject).hashCode())
        {
        default: 
          switch (i)
          {
          default: 
            localObject = this.unH.getText();
            if ((!bo.aa((CharSequence)localObject)) && (((CharSequence)localObject).length() > 9))
            {
              this.unH.setText(((CharSequence)localObject).subSequence(0, 9));
              this.unH.append("...");
            }
            localObject = (ViewGroup.MarginLayoutParams)this.unF.getLayoutParams();
            ((ViewGroup.MarginLayoutParams)localObject).topMargin = com.tencent.mm.cb.a.fromDPToPix(this, 50);
            this.unF.setLayoutParams((ViewGroup.LayoutParams)localObject);
            this.unF.setVisibility(0);
          }
          break;
        }
      }
    }
    label639:
    while ((this.unt.ugN == null) || (bo.isNullOrNil(this.unt.ugN.ugl)) || (!this.unt.cTn())) {
      for (;;)
      {
        RelativeLayout.LayoutParams localLayoutParams;
        int i;
        if (this.unH.getVisibility() == 0) {
          this.unH.post(new WalletBindCardResultUI.6(this));
        }
        if (this.unF.getVisibility() == 8)
        {
          localObject = (ViewGroup.MarginLayoutParams)this.unE.getLayoutParams();
          ((ViewGroup.MarginLayoutParams)localObject).topMargin = com.tencent.mm.cb.a.fromDPToPix(this, 91);
          this.unE.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        AppMethodBeat.o(47199);
        return;
        this.unG.setUrl(this.unt.ugM.pvi);
        this.unH.setText(this.unt.ugM.name);
        this.unK.setText(this.unt.ugM.uiO);
        continue;
        if (!bo.isNullOrNil(this.unt.ugM.title))
        {
          this.unI.setText(this.unt.ugM.title);
          localLayoutParams.addRule(15, 0);
        }
        else
        {
          this.unI.setVisibility(8);
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
                      this.unK.setEnabled(false);
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
    this.unv = this.unt.ugN.ugl;
    this.unw = this.unt.ugN.uaL;
    this.uiT = this.unt.ugN.uiT;
    this.unx = this.unt.ugN;
    this.unG.setUrl(this.unt.ugN.uiQ);
    this.unH.setText(this.unt.ugN.uiR);
    this.unI.setText(getString(2131304784));
    this.unI.setVisibility(0);
    this.unG.setRoundCorner(true);
    this.unK.setEnabled(true);
    this.unK.setBackgroundResource(2130838045);
    Object localObject = (RelativeLayout.LayoutParams)this.unI.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).addRule(15, 0);
    this.unI.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (this.unt.ugL.ubC > 0L)
    {
      if (!bo.isNullOrNil(this.unt.ugN.uiS))
      {
        this.unK.setVisibility(0);
        this.unK.setText(this.unt.ugN.uiS);
        this.unJ.setVisibility(8);
      }
      localObject = (WalletOrderInfoNewUI.a)this.unz.get(this.unt.ugL.ubC);
      if (localObject != null)
      {
        if (!bo.isNullOrNil(((WalletOrderInfoNewUI.a)localObject).uiQ)) {
          this.unG.setUrl(((WalletOrderInfoNewUI.a)localObject).uiQ);
        }
        if (!bo.isNullOrNil(((WalletOrderInfoNewUI.a)localObject).uiR)) {
          this.unH.setText(((WalletOrderInfoNewUI.a)localObject).uiR);
        }
        if (!bo.isNullOrNil(((WalletOrderInfoNewUI.a)localObject).uiS))
        {
          this.unK.setText(((WalletOrderInfoNewUI.a)localObject).uiS);
          this.unK.setBackgroundResource(2130840866);
        }
        if (!bo.isNullOrNil(((WalletOrderInfoNewUI.a)localObject).ugl)) {
          this.unv = ((WalletOrderInfoNewUI.a)localObject).ugl;
        }
        if (!bo.isNullOrNil(((WalletOrderInfoNewUI.a)localObject).uaL)) {
          this.unw = ((WalletOrderInfoNewUI.a)localObject).uaL;
        }
      }
    }
    for (;;)
    {
      localObject = new WalletBindCardResultUI.5(this);
      this.unF.setOnClickListener((View.OnClickListener)localObject);
      this.unK.setOnClickListener((View.OnClickListener)localObject);
      localObject = this.unH.getText();
      if ((bo.aa((CharSequence)localObject)) || (((CharSequence)localObject).length() <= 9)) {
        break;
      }
      this.unH.setText(((CharSequence)localObject).subSequence(0, 9));
      this.unH.append("...");
      break;
      this.unK.setVisibility(8);
      this.unJ.setVisibility(8);
    }
  }
  
  private void cVu()
  {
    int i = 0;
    AppMethodBeat.i(47206);
    if (!this.unu)
    {
      iz localiz = new iz();
      localiz.cyt.requestCode = 4;
      iz.a locala = localiz.cyt;
      if (getInput().getBoolean("intent_pay_end", false)) {
        i = -1;
      }
      locala.bpE = i;
      com.tencent.mm.sdk.b.a.ymk.l(localiz);
      this.unu = true;
    }
    AppMethodBeat.o(47206);
  }
  
  public final void done()
  {
    AppMethodBeat.i(47203);
    Bundle localBundle = new Bundle();
    if (this.unP != null)
    {
      this.unP.a(this, 0, localBundle);
      AppMethodBeat.o(47203);
      return;
    }
    finish();
    AppMethodBeat.o(47203);
  }
  
  public int getLayoutId()
  {
    return 2130971153;
  }
  
  public void initView()
  {
    AppMethodBeat.i(47196);
    if (getSupportActionBar() != null) {
      getSupportActionBar().hide();
    }
    this.unE = ((ImageView)findViewById(2131829036));
    this.qrh = ((TextView)findViewById(2131829037));
    this.unD = ((Button)findViewById(2131829040));
    showHomeBtn(false);
    enableBackMenu(false);
    String str = getString(2131296964);
    if ((this.unt != null) && (!bo.isNullOrNil(this.unt.ugE))) {
      this.unD.setText(this.unt.ugE);
    }
    for (;;)
    {
      this.unD.setOnClickListener(new WalletBindCardResultUI.2(this));
      this.unL = ((ViewGroup)findViewById(2131829039));
      this.unF = ((ViewGroup)findViewById(2131827332));
      this.unG = ((CdnImageView)findViewById(2131827333));
      this.unG.setUseSdcardCache(true);
      this.unH = ((TextView)findViewById(2131827335));
      this.unI = ((TextView)findViewById(2131827334));
      this.unK = ((Button)findViewById(2131827336));
      this.unJ = findViewById(2131827211);
      this.unL.setVisibility(4);
      cVs();
      cVt();
      cVr();
      if ((!bo.isNullOrNil(this.unt.ugG)) && (!bo.isNullOrNil(this.unt.ugH))) {
        ((TextView)findViewById(2131829038)).setText(getString(2131304878, new Object[] { this.unt.ugG, this.unt.ugH }));
      }
      AppMethodBeat.o(47196);
      return;
      this.unD.setText(str);
    }
  }
  
  public final void jU(int paramInt)
  {
    AppMethodBeat.i(47209);
    com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.qsU;
    if (this.unt.ugL == null) {}
    for (String str = "";; str = bo.bf(this.unt.ugL.ubC, ""))
    {
      localh.e(14877, new Object[] { str, this.unt.ugI, Integer.valueOf(paramInt), this.unt.poq });
      AppMethodBeat.o(47209);
      return;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(47201);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ab.i("MicroMsg.WalletBindCardResultUI", "onActivityResult %d %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 1)
    {
      ab.i("MicroMsg.WalletBindCardResultUI", "do query pay arawrd");
      doSceneProgress(new aa(this.uny.uca, this.uny.urE, this.uny.urF, this.uny.urG, this.uny.ukx, this.uny.urH, this.unt.poq, this.unt.ugI, this.unt.ugJ, this.unt.ugJ));
    }
    AppMethodBeat.o(47201);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(47194);
    super.onCreate(paramBundle);
    if (d.fv(21))
    {
      if (!d.fv(23)) {
        break label176;
      }
      getWindow().setStatusBarColor(-1);
      getWindow().getDecorView().setSystemUiVisibility(8192);
    }
    for (;;)
    {
      setContentViewVisibility(4);
      com.tencent.mm.wallet_core.a.aM(this);
      this.mPayInfo = ((PayInfo)getInput().getParcelable("key_pay_info"));
      getInput().getInt("key_pay_type", -1);
      BindCardOrder localBindCardOrder = (BindCardOrder)getInput().getParcelable("key_bindcard_value_result");
      paramBundle = localBindCardOrder;
      if (localBindCardOrder == null) {
        paramBundle = new BindCardOrder();
      }
      this.unt = paramBundle;
      setContentViewVisibility(0);
      initView();
      this.unP = getProcess();
      cVs();
      jU(1);
      addSceneEndListener(1979);
      com.tencent.mm.sdk.b.a.ymk.c(this.pns);
      this.unO = true;
      AppMethodBeat.o(47194);
      return;
      label176:
      getWindow().setStatusBarColor(Color.parseColor("#E5E5E5"));
    }
  }
  
  @Deprecated
  public Dialog onCreateDialog(int paramInt)
  {
    AppMethodBeat.i(47202);
    Dialog localDialog = com.tencent.mm.ui.base.h.a(getContext(), getString(2131305351), getResources().getStringArray(2131755065), "", new h.c()
    {
      public final void iA(int paramAnonymousInt)
      {
        AppMethodBeat.i(47192);
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(47192);
          return;
          Intent localIntent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + WalletBindCardResultUI.i(WalletBindCardResultUI.this)));
          localIntent.addFlags(268435456);
          WalletBindCardResultUI.this.startActivity(localIntent);
        }
      }
    });
    AppMethodBeat.o(47202);
    return localDialog;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(47205);
    super.onDestroy();
    com.tencent.mm.sdk.b.a.ymk.d(this.pns);
    removeSceneEndListener(1979);
    AppMethodBeat.o(47205);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(47204);
    if (paramInt == 4)
    {
      done();
      AppMethodBeat.o(47204);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(47204);
    return bool;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(47195);
    super.onResume();
    ab.i("MicroMsg.WalletBindCardResultUI", "onResume, isFirstInit: %s activityPromotions: %s, isClickTinyappActivity: %s, isClickActivity: %s, recommendTinyAppInfo: %s", new Object[] { Boolean.valueOf(this.unO), this.unB, Boolean.valueOf(this.unM), Boolean.valueOf(this.unN), this.unx });
    if (this.unO)
    {
      this.unO = false;
      AppMethodBeat.o(47195);
      return;
    }
    if ((this.unB != null) && (this.unN))
    {
      doSceneProgress(new aa(this.unB.ugL.ubC, this.unB.ugL.uiK, this.unB.ugL.uiL, this.unB.ugL.uiM, this.unB.ugL.uiJ, this.unB.ugL.uiN, this.unt.poq, this.unt.ugI, this.unt.ugJ, this.unt.ugJ));
      AppMethodBeat.o(47195);
      return;
    }
    if ((this.unM) && (this.unx != null)) {
      doSceneProgress(new aa(this.unt.ugL.ubC, this.unt.ugL.uiK, this.unt.ugL.uiL, this.unt.ugL.uiM, this.unt.ugL.uiN, this.unt.ugL.uiJ, this.unt.poq, this.unt.ugI, this.unt.ugJ, this.unt.ugJ));
    }
    AppMethodBeat.o(47195);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(47207);
    if ((paramm instanceof aa)) {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (aa)paramm;
        paramm = new WalletOrderInfoNewUI.a(paramString.hxd);
        if (this.uny == null) {
          break label78;
        }
        this.unz.put(paramString.uca, paramm);
        cVt();
        cVr();
      }
    }
    label78:
    while (!(paramm instanceof p)) {
      for (;;)
      {
        AppMethodBeat.o(47207);
        return false;
        if (this.unM)
        {
          this.unz.put(paramString.uca, paramm);
          cVt();
          cVr();
        }
      }
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = (p)paramm;
      paramm = paramString.ubJ;
      if ((this.unB != null) && (this.unB.ugL.ubC == paramString.ubL.ugL.ubC))
      {
        ab.i("MicroMsg.WalletBindCardResultUI", "activityAwardState: %s", new Object[] { this.unB });
        this.unC = paramm;
        cVt();
        cVr();
        if ((!bo.isNullOrNil(paramString.eev)) && (!"3".equals(paramm))) {
          this.unK.setText(paramString.eev);
        }
      }
      if ((!"-1".equals(paramm)) && (!"0".equals(paramm)) && (!bo.isNullOrNil(paramString.ubK))) {
        com.tencent.mm.ui.base.h.b(this, paramString.ubK, "", true);
      }
      while (!"0".equals(paramm))
      {
        AppMethodBeat.o(47207);
        return true;
      }
      if (!bo.isNullOrNil(paramString.ubK)) {}
      for (paramString = paramString.ubK;; paramString = getString(2131305444))
      {
        Toast.makeText(this, paramString, 0).show();
        break;
      }
    }
    paramm = paramString;
    if (bo.isNullOrNil(paramString)) {
      paramm = getString(2131305682);
    }
    com.tencent.mm.ui.base.h.a(this, paramm, null, false, new WalletBindCardResultUI.8(this));
    AppMethodBeat.o(47207);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void setContentViewVisibility(int paramInt)
  {
    AppMethodBeat.i(47208);
    getContentView().setVisibility(paramInt);
    AppMethodBeat.o(47208);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletBindCardResultUI
 * JD-Core Version:    0.7.0.1
 */