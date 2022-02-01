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
import com.tencent.mm.g.a.jx;
import com.tencent.mm.g.a.jx.a;
import com.tencent.mm.g.a.uj;
import com.tencent.mm.g.a.xh;
import com.tencent.mm.plugin.wallet_core.c.ac;
import com.tencent.mm.plugin.wallet_core.model.BindCardOrder;
import com.tencent.mm.plugin.wallet_core.model.r.a;
import com.tencent.mm.plugin.wallet_core.model.r.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import java.util.HashMap;

@com.tencent.mm.ui.base.a(3)
public class WalletBindCardResultUI
  extends WalletBaseUI
{
  private int Afe;
  private BindCardOrder AjZ;
  private boolean Aka;
  private String Akb;
  private String Akc;
  private r.b Akd;
  private WalletOrderInfoNewUI.b Ake;
  private HashMap<String, WalletOrderInfoNewUI.a> Akf;
  private String Akg;
  private BindCardOrder Akh;
  private String Aki;
  private Button Akj;
  private ImageView Akk;
  private ViewGroup Akl;
  private CdnImageView Akm;
  private TextView Akn;
  private TextView Ako;
  private View Akp;
  private Button Akq;
  private ViewGroup Akr;
  private boolean Aks;
  private boolean Akt;
  private boolean Aku;
  private com.tencent.mm.wallet_core.d Akv;
  private PayInfo mPayInfo;
  private c umw;
  private String upF;
  private String vGZ;
  private TextView vIs;
  
  public WalletBindCardResultUI()
  {
    AppMethodBeat.i(70755);
    this.upF = null;
    this.Aka = false;
    this.Akf = new HashMap();
    this.Akh = null;
    this.Aki = "-1";
    this.Aks = false;
    this.Akt = false;
    this.Aku = false;
    this.umw = new c() {};
    AppMethodBeat.o(70755);
  }
  
  private void aur(String paramString)
  {
    AppMethodBeat.i(70762);
    edQ();
    e.p(this, paramString, false);
    AppMethodBeat.o(70762);
  }
  
  private void edN()
  {
    AppMethodBeat.i(70759);
    this.Akr.setVisibility(0);
    AppMethodBeat.o(70759);
  }
  
  private void edO()
  {
    AppMethodBeat.i(70760);
    this.vIs.setText(this.AjZ.AcN);
    AppMethodBeat.o(70760);
  }
  
  private void edP()
  {
    AppMethodBeat.i(70761);
    this.Akl.setVisibility(4);
    this.Akt = false;
    this.Aks = false;
    if (this.AjZ != null) {
      if (this.AjZ.AcT != null)
      {
        ad.i("MicroMsg.WalletBindCardResultUI", "activityPromotions: %s", new Object[] { this.Akh });
        if ((this.AjZ == null) || ((!this.AjZ.ebC()) && (!this.AjZ.ebE())) || (this.AjZ.AcT.zWi <= 0L) || (bt.isNullOrNil(this.AjZ.AcU.AeZ))) {
          break label854;
        }
        this.Akh = this.AjZ;
        this.Akp.setVisibility(8);
        this.Akm.setRoundCorner(true);
        this.Akq.setEnabled(true);
        this.Akq.setBackgroundResource(2131231365);
        this.Ako.setCompoundDrawables(null, null, null, null);
        localObject = (WalletOrderInfoNewUI.a)this.Akf.get(this.Akh.AcT.zWi);
        if (localObject == null) {
          break label639;
        }
        if (!bt.isNullOrNil(((WalletOrderInfoNewUI.a)localObject).dub)) {
          this.Akm.setUrl(((WalletOrderInfoNewUI.a)localObject).dub);
        }
        if (!bt.isNullOrNil(((WalletOrderInfoNewUI.a)localObject).doh)) {
          this.Akn.setText(((WalletOrderInfoNewUI.a)localObject).doh);
        }
        if (!bt.isNullOrNil(((WalletOrderInfoNewUI.a)localObject).Aox))
        {
          this.Akq.setText(((WalletOrderInfoNewUI.a)localObject).Aox);
          this.Akq.setBackgroundResource(2131234694);
        }
        localLayoutParams = (RelativeLayout.LayoutParams)this.Ako.getLayoutParams();
        if ((localObject == null) || (bt.isNullOrNil(((WalletOrderInfoNewUI.a)localObject).title))) {
          break label693;
        }
        this.Ako.setText(((WalletOrderInfoNewUI.a)localObject).title);
        localLayoutParams.addRule(15, 0);
        this.Ako.setLayoutParams(localLayoutParams);
        this.Akq.setVisibility(0);
        this.Akq.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(70750);
            ad.i("MicroMsg.WalletBindCardResultUI", "click activity button");
            WalletBindCardResultUI.b(WalletBindCardResultUI.this);
            AppMethodBeat.o(70750);
          }
        });
        if (this.Akh.AcT.AeU != 1L) {
          this.Akl.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(70751);
              ad.i("MicroMsg.WalletBindCardResultUI", "click activity layout");
              WalletBindCardResultUI.b(WalletBindCardResultUI.this);
              AppMethodBeat.o(70751);
            }
          });
        }
        localObject = this.Aki;
        i = -1;
        switch (((String)localObject).hashCode())
        {
        default: 
          switch (i)
          {
          default: 
            localObject = this.Akn.getText();
            if ((!bt.ai((CharSequence)localObject)) && (((CharSequence)localObject).length() > 9))
            {
              this.Akn.setText(((CharSequence)localObject).subSequence(0, 9));
              this.Akn.append("...");
            }
            localObject = (ViewGroup.MarginLayoutParams)this.Akl.getLayoutParams();
            ((ViewGroup.MarginLayoutParams)localObject).topMargin = com.tencent.mm.cd.a.fromDPToPix(this, 50);
            this.Akl.setLayoutParams((ViewGroup.LayoutParams)localObject);
            this.Akl.setVisibility(0);
          }
          break;
        }
      }
    }
    label639:
    while ((this.AjZ.AcV == null) || (bt.isNullOrNil(this.AjZ.AcV.zHs)) || (!this.AjZ.ebD())) {
      for (;;)
      {
        RelativeLayout.LayoutParams localLayoutParams;
        int i;
        if (this.Akn.getVisibility() == 0) {
          this.Akn.post(new Runnable()
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
        if (this.Akl.getVisibility() == 8)
        {
          localObject = (ViewGroup.MarginLayoutParams)this.Akk.getLayoutParams();
          ((ViewGroup.MarginLayoutParams)localObject).topMargin = com.tencent.mm.cd.a.fromDPToPix(this, 91);
          this.Akk.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        AppMethodBeat.o(70761);
        return;
        this.Akm.setUrl(this.AjZ.AcU.uwS);
        this.Akn.setText(this.AjZ.AcU.name);
        this.Akq.setText(this.AjZ.AcU.AeZ);
        continue;
        if (!bt.isNullOrNil(this.AjZ.AcU.title))
        {
          this.Ako.setText(this.AjZ.AcU.title);
          localLayoutParams.addRule(15, 0);
        }
        else
        {
          this.Ako.setVisibility(8);
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
                      this.Akq.setEnabled(false);
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
    this.Akb = this.AjZ.AcV.zHs;
    this.Akc = this.AjZ.AcV.zHt;
    this.Afe = this.AjZ.AcV.Afe;
    this.Akd = this.AjZ.AcV;
    this.Akm.setUrl(this.AjZ.AcV.Afb);
    this.Akn.setText(this.AjZ.AcV.Afc);
    this.Ako.setText(getString(2131764967));
    this.Ako.setVisibility(0);
    this.Akm.setRoundCorner(true);
    this.Akq.setEnabled(true);
    this.Akq.setBackgroundResource(2131231365);
    Object localObject = (RelativeLayout.LayoutParams)this.Ako.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).addRule(15, 0);
    this.Ako.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (this.AjZ.AcT.zWi > 0L)
    {
      if (!bt.isNullOrNil(this.AjZ.AcV.Afd))
      {
        this.Akq.setVisibility(0);
        this.Akq.setText(this.AjZ.AcV.Afd);
        this.Akp.setVisibility(8);
      }
      localObject = (WalletOrderInfoNewUI.a)this.Akf.get(this.AjZ.AcT.zWi);
      if (localObject != null)
      {
        if (!bt.isNullOrNil(((WalletOrderInfoNewUI.a)localObject).Afb)) {
          this.Akm.setUrl(((WalletOrderInfoNewUI.a)localObject).Afb);
        }
        if (!bt.isNullOrNil(((WalletOrderInfoNewUI.a)localObject).Afc)) {
          this.Akn.setText(((WalletOrderInfoNewUI.a)localObject).Afc);
        }
        if (!bt.isNullOrNil(((WalletOrderInfoNewUI.a)localObject).Afd))
        {
          this.Akq.setText(((WalletOrderInfoNewUI.a)localObject).Afd);
          this.Akq.setBackgroundResource(2131234694);
        }
        if (!bt.isNullOrNil(((WalletOrderInfoNewUI.a)localObject).zHs)) {
          this.Akb = ((WalletOrderInfoNewUI.a)localObject).zHs;
        }
        if (!bt.isNullOrNil(((WalletOrderInfoNewUI.a)localObject).zHt)) {
          this.Akc = ((WalletOrderInfoNewUI.a)localObject).zHt;
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
          ad.i("MicroMsg.WalletBindCardResultUI", "click tiny app, userName: %s, path: %s, version: %s", new Object[] { WalletBindCardResultUI.c(WalletBindCardResultUI.this), WalletBindCardResultUI.d(WalletBindCardResultUI.this), Integer.valueOf(WalletBindCardResultUI.e(WalletBindCardResultUI.this)) });
          WalletBindCardResultUI.this.my(2);
          paramAnonymousView = new uj();
          paramAnonymousView.dzH.userName = WalletBindCardResultUI.c(WalletBindCardResultUI.this);
          paramAnonymousView.dzH.dzJ = bt.by(WalletBindCardResultUI.d(WalletBindCardResultUI.this), "");
          paramAnonymousView.dzH.scene = 1034;
          paramAnonymousView.dzH.dzK = 0;
          if (WalletBindCardResultUI.e(WalletBindCardResultUI.this) > 0) {
            paramAnonymousView.dzH.aAS = WalletBindCardResultUI.e(WalletBindCardResultUI.this);
          }
          com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousView);
          if ((!bt.isNullOrNil(WalletBindCardResultUI.f(WalletBindCardResultUI.this).AcV.Afd)) && (WalletBindCardResultUI.f(WalletBindCardResultUI.this).AcT.zWi > 0L))
          {
            WalletBindCardResultUI.a(WalletBindCardResultUI.this, true);
            AppMethodBeat.o(70752);
            return;
          }
          WalletBindCardResultUI.a(WalletBindCardResultUI.this, false);
          AppMethodBeat.o(70752);
        }
      };
      this.Akl.setOnClickListener((View.OnClickListener)localObject);
      this.Akq.setOnClickListener((View.OnClickListener)localObject);
      localObject = this.Akn.getText();
      if ((bt.ai((CharSequence)localObject)) || (((CharSequence)localObject).length() <= 9)) {
        break;
      }
      this.Akn.setText(((CharSequence)localObject).subSequence(0, 9));
      this.Akn.append("...");
      break;
      this.Akq.setVisibility(8);
      this.Akp.setVisibility(8);
    }
  }
  
  private void edQ()
  {
    int i = 0;
    AppMethodBeat.i(70768);
    if (!this.Aka)
    {
      jx localjx = new jx();
      localjx.dob.requestCode = 4;
      jx.a locala = localjx.dob;
      if (getInput().getBoolean("intent_pay_end", false)) {
        i = -1;
      }
      locala.bRZ = i;
      com.tencent.mm.sdk.b.a.ESL.l(localjx);
      this.Aka = true;
    }
    AppMethodBeat.o(70768);
  }
  
  public final void done()
  {
    AppMethodBeat.i(70765);
    Bundle localBundle = new Bundle();
    if (this.Akv != null)
    {
      this.Akv.a(this, 0, localBundle);
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
    this.Akk = ((ImageView)findViewById(2131307115));
    this.vIs = ((TextView)findViewById(2131303156));
    this.Akj = ((Button)findViewById(2131303152));
    showHomeBtn(false);
    enableBackMenu(false);
    String str = getString(2131755779);
    if ((this.AjZ != null) && (!bt.isNullOrNil(this.AjZ.AcM))) {
      this.Akj.setText(this.AjZ.AcM);
    }
    for (;;)
    {
      this.Akj.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(70749);
          WalletBindCardResultUI.this.done();
          AppMethodBeat.o(70749);
        }
      });
      this.Akr = ((ViewGroup)findViewById(2131306773));
      this.Akl = ((ViewGroup)findViewById(2131305855));
      this.Akm = ((CdnImageView)findViewById(2131305857));
      this.Akm.setUseSdcardCache(true);
      this.Akn = ((TextView)findViewById(2131305854));
      this.Ako = ((TextView)findViewById(2131305859));
      this.Akq = ((Button)findViewById(2131305852));
      this.Akp = findViewById(2131305856);
      this.Akr.setVisibility(4);
      edO();
      edP();
      edN();
      if ((!bt.isNullOrNil(this.AjZ.AcO)) && (!bt.isNullOrNil(this.AjZ.AcP))) {
        ((TextView)findViewById(2131303157)).setText(getString(2131765065, new Object[] { this.AjZ.AcO, this.AjZ.AcP }));
      }
      AppMethodBeat.o(70758);
      return;
      this.Akj.setText(str);
    }
  }
  
  public final void my(int paramInt)
  {
    AppMethodBeat.i(70771);
    com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.vKh;
    if (this.AjZ.AcT == null) {}
    for (String str = "";; str = bt.by(this.AjZ.AcT.zWi, ""))
    {
      localh.f(14877, new Object[] { str, this.AjZ.AcQ, Integer.valueOf(paramInt), this.AjZ.dca });
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
      doSceneProgress(new ac(this.Ake.zWH, this.Ake.Aoz, this.Ake.AoA, this.Ake.AoB, this.Ake.AgJ, this.Ake.AoC, this.AjZ.dca, this.AjZ.AcQ, this.AjZ.AcR, this.AjZ.AcR));
    }
    AppMethodBeat.o(70763);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(70756);
    super.onCreate(paramBundle);
    if (com.tencent.mm.compatible.util.d.lf(21))
    {
      if (!com.tencent.mm.compatible.util.d.lf(23)) {
        break label172;
      }
      getWindow().setStatusBarColor(getResources().getColor(2131101179));
    }
    for (;;)
    {
      setContentViewVisibility(4);
      com.tencent.mm.wallet_core.a.bo(this);
      this.mPayInfo = ((PayInfo)getInput().getParcelable("key_pay_info"));
      getInput().getInt("key_pay_type", -1);
      BindCardOrder localBindCardOrder = (BindCardOrder)getInput().getParcelable("key_bindcard_value_result");
      paramBundle = localBindCardOrder;
      if (localBindCardOrder == null) {
        paramBundle = new BindCardOrder();
      }
      this.AjZ = paramBundle;
      setContentViewVisibility(0);
      initView();
      this.Akv = getProcess();
      edO();
      my(1);
      addSceneEndListener(1979);
      com.tencent.mm.sdk.b.a.ESL.c(this.umw);
      this.Aku = true;
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
    com.tencent.mm.sdk.b.a.ESL.d(this.umw);
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
    ad.i("MicroMsg.WalletBindCardResultUI", "onResume, isFirstInit: %s activityPromotions: %s, isClickTinyappActivity: %s, isClickActivity: %s, recommendTinyAppInfo: %s", new Object[] { Boolean.valueOf(this.Aku), this.Akh, Boolean.valueOf(this.Aks), Boolean.valueOf(this.Akt), this.Akd });
    if (this.Aku)
    {
      this.Aku = false;
      AppMethodBeat.o(70757);
      return;
    }
    if ((this.Akh != null) && (this.Akt))
    {
      doSceneProgress(new ac(this.Akh.AcT.zWi, this.Akh.AcT.AeV, this.Akh.AcT.AeW, this.Akh.AcT.AeX, this.Akh.AcT.AeU, this.Akh.AcT.AeY, this.AjZ.dca, this.AjZ.AcQ, this.AjZ.AcR, this.AjZ.AcR));
      AppMethodBeat.o(70757);
      return;
    }
    if ((this.Aks) && (this.Akd != null)) {
      doSceneProgress(new ac(this.AjZ.AcT.zWi, this.AjZ.AcT.AeV, this.AjZ.AcT.AeW, this.AjZ.AcT.AeX, this.AjZ.AcT.AeY, this.AjZ.AcT.AeU, this.AjZ.dca, this.AjZ.AcQ, this.AjZ.AcR, this.AjZ.AcR));
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
        paramn = new WalletOrderInfoNewUI.a(paramString.jwa);
        if (this.Ake == null) {
          break label78;
        }
        this.Akf.put(paramString.zWH, paramn);
        edP();
        edN();
      }
    }
    label78:
    while (!(paramn instanceof com.tencent.mm.plugin.wallet_core.c.r)) {
      for (;;)
      {
        AppMethodBeat.o(70769);
        return false;
        if (this.Aks)
        {
          this.Akf.put(paramString.zWH, paramn);
          edP();
          edN();
        }
      }
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = (com.tencent.mm.plugin.wallet_core.c.r)paramn;
      paramn = paramString.zWp;
      if ((this.Akh != null) && (this.Akh.AcT.zWi == paramString.zWr.AcT.zWi))
      {
        ad.i("MicroMsg.WalletBindCardResultUI", "activityAwardState: %s", new Object[] { this.Akh });
        this.Aki = paramn;
        edP();
        edN();
        if ((!bt.isNullOrNil(paramString.foR)) && (!"3".equals(paramn))) {
          this.Akq.setText(paramString.foR);
        }
      }
      if ((!"-1".equals(paramn)) && (!"0".equals(paramn)) && (!bt.isNullOrNil(paramString.zWq))) {
        com.tencent.mm.ui.base.h.c(this, paramString.zWq, "", true);
      }
      while (!"0".equals(paramn))
      {
        AppMethodBeat.o(70769);
        return true;
      }
      if (!bt.isNullOrNil(paramString.zWq)) {}
      for (paramString = paramString.zWq;; paramString = getString(2131765658))
      {
        Toast.makeText(this, paramString, 0).show();
        break;
      }
    }
    paramn = paramString;
    if (bt.isNullOrNil(paramString)) {
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