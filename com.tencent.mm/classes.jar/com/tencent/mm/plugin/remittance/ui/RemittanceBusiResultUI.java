package com.tencent.mm.plugin.remittance.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.b;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.xk;
import com.tencent.mm.plugin.remittance.model.BusiRemittanceResp;
import com.tencent.mm.plugin.remittance.model.f;
import com.tencent.mm.plugin.remittance.model.i;
import com.tencent.mm.plugin.remittance.model.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget;
import com.tencent.mm.plugin.wallet_core.utils.g;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.dh;
import com.tencent.mm.protocal.protobuf.ol;
import com.tencent.mm.protocal.protobuf.om;
import com.tencent.mm.protocal.protobuf.ov;
import com.tencent.mm.protocal.protobuf.pr;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.tools.p;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(19)
public class RemittanceBusiResultUI
  extends WalletBaseUI
{
  private TextView kEu;
  private Button lkJ;
  private int mChannel;
  private int oTv;
  private String ujI;
  private String vCX;
  private String vCs;
  private TextView vDD;
  private TextView vDE;
  private TextView vDF;
  private TextView vDG;
  private CdnImageView vDH;
  private TextView vDI;
  private TextView vDJ;
  private Button vDK;
  private ViewGroup vDL;
  private ViewGroup vDM;
  private ViewGroup vDN;
  private ViewGroup vDO;
  private View vDP;
  private LinearLayout vDQ;
  private String vDR;
  private String vDS;
  private String vDT;
  private double vDU;
  private String vDV;
  private String vDW;
  private String vDX;
  private int vDY;
  private String vDZ;
  private String vEa;
  private b vEb;
  private boolean vEc;
  private String vEd;
  private BusiRemittanceResp vEe;
  private om vEf;
  private boolean vEg;
  private Runnable vEh;
  private dh vEi;
  private int vEj;
  private e.a.a.c vEk;
  private WalletSuccPageAwardWidget vEl;
  private ViewGroup vEm;
  private ViewGroup vEn;
  private ViewGroup vEo;
  private TextView vEp;
  private boolean vEq;
  private com.tencent.mm.sdk.b.c<xk> vEr;
  private boolean vEs;
  private Runnable vEt;
  private int vzL;
  private String vzM;
  
  public RemittanceBusiResultUI()
  {
    AppMethodBeat.i(67998);
    this.vEc = false;
    this.vEg = false;
    this.vEh = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(67990);
        RemittanceBusiResultUI.a(RemittanceBusiResultUI.this);
        j localj = new j(RemittanceBusiResultUI.b(RemittanceBusiResultUI.this), RemittanceBusiResultUI.c(RemittanceBusiResultUI.this), RemittanceBusiResultUI.d(RemittanceBusiResultUI.this).dtM, RemittanceBusiResultUI.e(RemittanceBusiResultUI.this) - 1, System.currentTimeMillis());
        RemittanceBusiResultUI.this.doSceneProgress(localj);
        RemittanceBusiResultUI.f(RemittanceBusiResultUI.this);
        AppMethodBeat.o(67990);
      }
    };
    this.vEi = new dh();
    this.vEq = false;
    this.vEr = new com.tencent.mm.sdk.b.c() {};
    this.vEs = true;
    this.vEt = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(67997);
        RemittanceBusiResultUI.m(RemittanceBusiResultUI.this);
        AppMethodBeat.o(67997);
      }
    };
    AppMethodBeat.o(67998);
  }
  
  private void a(j paramj)
  {
    AppMethodBeat.i(68008);
    this.vEn.setVisibility(8);
    this.vEm.setVisibility(8);
    this.vEo.setVisibility(8);
    TextView localTextView = (TextView)findViewById(2131306040);
    final View localView = findViewById(2131306041);
    LinkedList localLinkedList;
    int i;
    Object localObject2;
    int j;
    Object localObject1;
    if ((paramj != null) && (paramj.vAk != null) && (paramj.vAk.CNa.size() > 0))
    {
      localLinkedList = paramj.vAk.CNa;
      if (localLinkedList != null)
      {
        i = localLinkedList.size();
        ad.i("MicroMsg.RemittanceBusiResultUI", "discountInfoList: %s, size: %s received_amount: %s", new Object[] { localLinkedList, Integer.valueOf(i), Long.valueOf(paramj.vAk.CMZ) });
        localObject2 = "";
        j = localLinkedList.size();
        localObject1 = localObject2;
        if (localLinkedList == null) {
          break label401;
        }
        localObject1 = localObject2;
        if (localLinkedList.size() <= 0) {
          break label401;
        }
        this.vEn.removeAllViews();
        this.vEm.setOnClickListener(null);
        if (j <= 1) {
          break label505;
        }
        paramj = paramj.vAk.CNd;
        this.vEs = true;
        localView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            boolean bool = false;
            AppMethodBeat.i(67995);
            if (RemittanceBusiResultUI.i(RemittanceBusiResultUI.this))
            {
              localView.setVisibility(8);
              RemittanceBusiResultUI.j(RemittanceBusiResultUI.this).setVisibility(0);
              paramAnonymousView = RemittanceBusiResultUI.this;
              RemittanceBusiResultUI.k(RemittanceBusiResultUI.this);
              RemittanceBusiResultUI.l(paramAnonymousView);
            }
            for (;;)
            {
              paramAnonymousView = RemittanceBusiResultUI.this;
              if (!RemittanceBusiResultUI.i(RemittanceBusiResultUI.this)) {
                bool = true;
              }
              RemittanceBusiResultUI.a(paramAnonymousView, bool);
              AppMethodBeat.o(67995);
              return;
              localView.setVisibility(0);
              RemittanceBusiResultUI.j(RemittanceBusiResultUI.this).setVisibility(8);
              RemittanceBusiResultUI.l(RemittanceBusiResultUI.this);
            }
          }
        });
        this.vEm.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            boolean bool = false;
            AppMethodBeat.i(67996);
            if (RemittanceBusiResultUI.i(RemittanceBusiResultUI.this))
            {
              localView.setVisibility(8);
              RemittanceBusiResultUI.j(RemittanceBusiResultUI.this).setVisibility(0);
              paramAnonymousView = RemittanceBusiResultUI.this;
              RemittanceBusiResultUI.k(RemittanceBusiResultUI.this);
              RemittanceBusiResultUI.l(paramAnonymousView);
            }
            for (;;)
            {
              paramAnonymousView = RemittanceBusiResultUI.this;
              if (!RemittanceBusiResultUI.i(RemittanceBusiResultUI.this)) {
                bool = true;
              }
              RemittanceBusiResultUI.a(paramAnonymousView, bool);
              AppMethodBeat.o(67996);
              return;
              localView.setVisibility(0);
              RemittanceBusiResultUI.j(RemittanceBusiResultUI.this).setVisibility(8);
              RemittanceBusiResultUI.l(RemittanceBusiResultUI.this);
            }
          }
        });
      }
    }
    for (;;)
    {
      if ((j == 1) && (localLinkedList.get(0) != null)) {
        paramj = (String)localLinkedList.get(0);
      }
      for (;;)
      {
        i = 0;
        for (;;)
        {
          if (i < localLinkedList.size())
          {
            localObject1 = (String)localLinkedList.get(i);
            localObject2 = new TextView(getContext());
            LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
            localLayoutParams.bottomMargin = com.tencent.mm.cd.a.fromDPToPix(this, 6);
            ((TextView)localObject2).setLayoutParams(localLayoutParams);
            ((TextView)localObject2).setTextSize(1, 12.0F);
            ((TextView)localObject2).setTextColor(getResources().getColor(2131099777));
            ((TextView)localObject2).setText((CharSequence)localObject1);
            this.vEn.addView((View)localObject2);
            i += 1;
            continue;
            i = 0;
            break;
          }
        }
        this.vEn.setVisibility(0);
        this.vEm.setVisibility(0);
        localObject1 = paramj;
        label401:
        if (this.vEs)
        {
          localView.setVisibility(0);
          paramj = bt.by((String)localObject1, "");
          paramj = new SpannableString(paramj + " ");
          if (j <= 1) {
            break label487;
          }
          findViewById(2131306042).setVisibility(0);
        }
        for (;;)
        {
          localTextView.setText(paramj);
          this.vEm.setVisibility(8);
          AppMethodBeat.o(68008);
          return;
          label487:
          findViewById(2131306042).setVisibility(8);
        }
      }
      label505:
      paramj = "";
    }
  }
  
  private void b(j paramj)
  {
    AppMethodBeat.i(68010);
    this.vDQ.removeAllViews();
    Object localObject1;
    if ((this.vEe != null) && (!bt.isNullOrNil(this.vEe.vzW))) {
      localObject1 = this.vEe.vzW;
    }
    label569:
    label586:
    for (;;)
    {
      Object localObject2;
      if ((ej(this.vDL)) && (ej(this.vDM)) && (ej(this.vEo)) && (ej(this.vDN)) && (ej(this.vDO)) && (!WalletSuccPageAwardWidget.a(this.vEk)) && (ej(findViewById(2131306041))) && (ej(this.vEm)))
      {
        localObject2 = (ViewGroup)getLayoutInflater().inflate(2131493902, this.vDQ, false);
        this.vDQ.addView((View)localObject2);
        paramj = (CdnImageView)((ViewGroup)localObject2).findViewById(2131304006);
        localObject2 = (TextView)((ViewGroup)localObject2).findViewById(2131303742);
        if (!bt.isNullOrNil(this.vzM))
        {
          if (this.vEj == 1) {
            paramj.setRoundCorner(true);
          }
          paramj.setUrl(this.vzM);
          label203:
          ((TextView)localObject2).setText((CharSequence)localObject1);
        }
      }
      for (;;)
      {
        dkm();
        AppMethodBeat.o(68010);
        return;
        if (!bt.isNullOrNil(this.vCs))
        {
          localObject2 = e.gn(this.vCs, 6);
          localObject1 = localObject2;
          if (bt.isNullOrNil(this.vEd)) {
            break label586;
          }
          localObject1 = getString(2131762438, new Object[] { localObject2, this.vEd });
          break;
        }
        localObject2 = e.gn(e.sh(this.vDT), 6);
        localObject1 = localObject2;
        if (bt.isNullOrNil(this.vEd)) {
          break label586;
        }
        localObject1 = getString(2131762438, new Object[] { localObject2, this.vEd });
        break;
        if (this.vEj == 1)
        {
          a.b.d(paramj, this.vDT);
          break label203;
        }
        a.b.c(paramj, this.vDT);
        break label203;
        localObject2 = (ViewGroup)getLayoutInflater().inflate(2131495250, this.vDQ, false);
        this.vDQ.addView((View)localObject2);
        localObject2 = (CdnImageView)findViewById(2131304006);
        TextView localTextView1 = (TextView)findViewById(2131303742);
        View localView = findViewById(2131301357);
        TextView localTextView2 = (TextView)findViewById(2131303741);
        localTextView1.setText(k.c(this, (CharSequence)localObject1));
        ((CdnImageView)localObject2).setVisibility(0);
        if (!bt.isNullOrNil(this.vzM))
        {
          if (this.vEj == 1) {
            ((CdnImageView)localObject2).setRoundCorner(true);
          }
          ((CdnImageView)localObject2).setUrl(this.vzM);
        }
        for (;;)
        {
          localView.setVisibility(8);
          localTextView2.setVisibility(8);
          if (paramj == null) {
            break;
          }
          if (paramj.vAk.CNc != 1) {
            break label569;
          }
          localView.setVisibility(0);
          localTextView2.setVisibility(0);
          localTextView2.setText(e.E(paramj.vAk.CMZ / 100.0D));
          break;
          if (this.vEj == 1) {
            a.b.d((ImageView)localObject2, this.vDT);
          } else {
            a.b.c((ImageView)localObject2, this.vDT);
          }
        }
        localView.setVisibility(8);
        localTextView2.setVisibility(8);
      }
    }
  }
  
  private void dkm()
  {
    AppMethodBeat.i(68009);
    p.a(this, (ScrollView)findViewById(2131304380), findViewById(2131297629), findViewById(2131296668), findViewById(2131297452), 32, 0.0F, true);
    AppMethodBeat.o(68009);
  }
  
  private static boolean ej(View paramView)
  {
    AppMethodBeat.i(68004);
    if ((paramView == null) || (paramView.getVisibility() == 8))
    {
      AppMethodBeat.o(68004);
      return true;
    }
    AppMethodBeat.o(68004);
    return false;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(68000);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(68000);
    return bool;
  }
  
  public void finish()
  {
    AppMethodBeat.i(67999);
    ad.i("MicroMsg.RemittanceBusiResultUI", "finish this %s %s", new Object[] { this, bt.eGN() });
    if (this.vEq)
    {
      AppMethodBeat.o(67999);
      return;
    }
    super.finish();
    this.vEq = true;
    AppMethodBeat.o(67999);
  }
  
  public int getLayoutId()
  {
    return 2131495251;
  }
  
  public void initView()
  {
    AppMethodBeat.i(68002);
    this.kEu = ((TextView)findViewById(2131303743));
    this.vDD = ((TextView)findViewById(2131303734));
    this.vDE = ((TextView)findViewById(2131303740));
    this.vDF = ((TextView)findViewById(2131303736));
    this.vDG = ((TextView)findViewById(2131303738));
    this.vDL = ((LinearLayout)findViewById(2131303739));
    this.vDM = ((LinearLayout)findViewById(2131303735));
    this.vDN = ((LinearLayout)findViewById(2131303737));
    this.vDH = ((CdnImageView)findViewById(2131303730));
    this.vDI = ((TextView)findViewById(2131303732));
    this.vDJ = ((TextView)findViewById(2131303731));
    this.vDK = ((Button)findViewById(2131303728));
    this.vDO = ((ViewGroup)findViewById(2131303729));
    this.lkJ = ((Button)findViewById(2131303733));
    this.vDP = findViewById(2131304828);
    this.vDQ = ((LinearLayout)findViewById(2131303995));
    this.vDD.setText(e.D(this.vDU));
    aq.n(this.vEt, 500L);
    if (!bt.isNullOrNil(this.vDR))
    {
      this.vDE.setText(this.vDR);
      this.vDL.setVisibility(0);
      if (bt.isNullOrNil(this.vDS)) {
        break label413;
      }
      this.vDF.setText(this.vDS);
      this.vDM.setVisibility(0);
    }
    for (;;)
    {
      this.lkJ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67992);
          if (RemittanceBusiResultUI.g(RemittanceBusiResultUI.this) == 56) {
            h.vKh.f(19821, new Object[] { Integer.valueOf(10) });
          }
          RemittanceBusiResultUI.this.finish();
          AppMethodBeat.o(67992);
        }
      });
      this.vEl = ((WalletSuccPageAwardWidget)findViewById(2131297022));
      this.vEm = ((ViewGroup)findViewById(2131299143));
      this.vEn = ((ViewGroup)findViewById(2131299141));
      this.vEo = ((ViewGroup)findViewById(2131303089));
      this.vEp = ((TextView)findViewById(2131303088));
      AppMethodBeat.o(68002);
      return;
      this.vDL.setVisibility(8);
      break;
      label413:
      this.vDM.setVisibility(8);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(68001);
    super.onCreate(paramBundle);
    addSceneEndListener(1537);
    addSceneEndListener(1680);
    addSceneEndListener(2504);
    this.vEr.alive();
    if (d.lf(21))
    {
      if (!d.lf(23)) {
        break label507;
      }
      getWindow().setStatusBarColor(getContext().getResources().getColor(2131101179));
    }
    for (;;)
    {
      if (getSupportActionBar() != null) {
        getSupportActionBar().hide();
      }
      setBackBtn(null);
      showHomeBtn(false);
      enableBackMenu(false);
      this.vCs = getIntent().getStringExtra("key_mch_name");
      this.vEe = ((BusiRemittanceResp)getIntent().getParcelableExtra("BusiRemittanceResp"));
      this.vDU = getIntent().getDoubleExtra("key_money", 0.0D);
      this.vDT = getIntent().getStringExtra("key_rcver_name");
      this.vEd = getIntent().getStringExtra("key_rcver_true_name");
      this.vDR = getIntent().getStringExtra("key_rcv_desc");
      this.vDS = getIntent().getStringExtra("key_pay_desc");
      this.vDV = getIntent().getStringExtra("key_f2f_id");
      this.ujI = getIntent().getStringExtra("key_trans_id");
      this.vCX = getIntent().getStringExtra("key_rcvr_open_id");
      this.vEa = getIntent().getStringExtra("key_check_sign");
      this.vDW = getIntent().getStringExtra("key_pay_desc");
      this.vDX = getIntent().getStringExtra("key_rcv_desc");
      this.vDY = getIntent().getIntExtra("key_scan_sceen", 0);
      this.mChannel = getIntent().getIntExtra("key_channel", 0);
      this.vDZ = getIntent().getStringExtra("key_succ_page_extend");
      paramBundle = getIntent().getByteArrayExtra("AfterPlaceOrderCommReq");
      this.vEf = i.amg(getIntent().getStringExtra("key_succ_fault_config"));
      try
      {
        this.vEi.parseFrom(paramBundle);
        this.vEj = getIntent().getIntExtra("key_succ_show_avatar_type", 0);
        this.vzL = getIntent().getIntExtra("key_succ_show_avatar_show", 0);
        this.vzM = getIntent().getStringExtra("key_succ_show_avatar_url");
        this.vEc = false;
        ad.i("MicroMsg.RemittanceBusiResultUI", "fetch data");
        ad.i("MicroMsg.RemittanceBusiResultUI", "fetchData() mBusiF2FFaultConfig.flag:%s mBusiF2FFaultConfig.succpage_first_delay_ms:%s", new Object[] { Integer.valueOf(this.vEf.dtM), Integer.valueOf(this.vEf.CMd) });
        if (bt.iY(this.vEf.dtM, 1))
        {
          aq.n(this.vEh, this.vEf.CMd);
          initView();
          AppMethodBeat.o(68001);
          return;
          label507:
          getWindow().setStatusBarColor(getContext().getResources().getColor(2131099679));
        }
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.RemittanceBusiResultUI", paramBundle, "", new Object[0]);
          continue;
          doSceneProgress(new j(this.vEi, this.vDZ));
        }
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(68006);
    super.onDestroy();
    removeSceneEndListener(1537);
    removeSceneEndListener(1680);
    removeSceneEndListener(2504);
    this.vEr.dead();
    if (this.vEk != null) {
      this.vEl.onDestroy();
    }
    aq.az(this.vEt);
    AppMethodBeat.o(68006);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(68005);
    super.onResume();
    if (this.vEc)
    {
      ad.i("MicroMsg.RemittanceBusiResultUI", "do act qry");
      int i = (int)Math.round(this.vDU * 100.0D);
      doSceneProgress(new f(this.vDV, this.ujI, this.vCX, i, this.vEb, this.vEa), false);
      this.vEc = false;
    }
    if (this.vEk != null) {
      this.vEl.onResume();
    }
    AppMethodBeat.o(68005);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(68003);
    ad.i("MicroMsg.RemittanceBusiResultUI", "errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scenetype:" + paramn.getType());
    Object localObject;
    if ((paramn instanceof j))
    {
      localObject = (j)paramn;
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        if (this.vEg)
        {
          ad.i("MicroMsg.RemittanceBusiResultUI", "NetSceneBusiF2fSucpage success(mIfSuccNetSceneBusiF2fSucpage:%s)", new Object[] { Boolean.valueOf(this.vEg) });
          if (this.vEk == null) {
            break label809;
          }
        }
      }
    }
    label809:
    for (boolean bool = this.vEl.onSceneEnd(paramInt1, paramInt2, paramString, paramn);; bool = false)
    {
      this.vDP.setVisibility(8);
      AppMethodBeat.o(68003);
      return bool;
      if (((j)localObject).vAk.ntx == 0)
      {
        this.vEg = true;
        aq.az(this.vEh);
        ad.i("MicroMsg.RemittanceBusiResultUI", "exposure info: %s", new Object[] { ((j)localObject).vAk.AgD });
        this.vEk = ((j)localObject).vAk.AgD;
        if (WalletSuccPageAwardWidget.a(this.vEk))
        {
          ad.i("MicroMsg.RemittanceBusiResultUI", "setAwardWidget, mTransId: %s", new Object[] { this.ujI });
          this.vEl.a(this, this.vEk, this.ujI, true, (ImageView)findViewById(2131297029));
          this.vEl.init();
          this.vEl.setVisibility(0);
          ImageView localImageView = (ImageView)findViewById(2131297029);
          localImageView.post(new RemittanceBusiResultUI.4(this, localImageView, (ViewGroup)findViewById(2131304380)));
          dkm();
          label324:
          a((j)localObject);
          aq.az(this.vEt);
          if (bt.isNullOrNil(((j)localObject).vAk.CNe)) {
            break label448;
          }
          if (!bt.isNullOrNil(((j)localObject).vAk.CNf)) {
            break label426;
          }
          this.vDG.setTextColor(getResources().getColor(2131100707));
          label382:
          this.vDG.setText(((j)localObject).vAk.CNe);
          this.vDN.setVisibility(0);
        }
        for (;;)
        {
          b((j)localObject);
          break;
          this.vEl.setVisibility(8);
          break label324;
          label426:
          this.vDG.setTextColor(g.bW(((j)localObject).vAk.CNf, true));
          break label382;
          label448:
          this.vDN.setVisibility(8);
        }
      }
      ad.e("MicroMsg.RemittanceBusiResultUI", "result response: %s, %s, %s", new Object[] { Integer.valueOf(((j)localObject).vAk.ntx), ((j)localObject).vAk.nty, Boolean.valueOf(((j)localObject).vAk.CNg) });
      if (((j)localObject).vAk.CNg) {
        break;
      }
      this.vEg = true;
      aq.az(this.vEh);
      break;
      ad.e("MicroMsg.RemittanceBusiResultUI", "net error: %s", new Object[] { localObject });
      break;
      if (!(paramn instanceof f)) {
        break;
      }
      localObject = (f)paramn;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (((f)localObject).vzZ.ntx == 0)
        {
          localObject = ((f)localObject).vzZ.CMc;
          if (localObject != null)
          {
            this.vDH.setUrl(((pr)localObject).dub);
            this.vDI.setText(((pr)localObject).title);
            this.vDJ.setText(((pr)localObject).Afa);
            this.vDK.setText(((pr)localObject).Aox);
            this.vDK.setOnClickListener(new RemittanceBusiResultUI.5(this, (pr)localObject));
            this.vDK.setBackgroundResource(2131233827);
            this.vDK.setTextColor(getResources().getColor(2131101183));
            this.vDO.setVisibility(0);
            dkm();
            break;
          }
          ad.i("MicroMsg.RemittanceBusiResultUI", "app info is null");
          this.vDO.setVisibility(8);
          break;
        }
        ad.e("MicroMsg.RemittanceBusiResultUI", "qry response: %s, %s", new Object[] { Integer.valueOf(((f)localObject).vzZ.ntx), ((f)localObject).vzZ.nty });
        Toast.makeText(this, ((f)localObject).vzZ.nty, 1).show();
        break;
      }
      ad.e("MicroMsg.RemittanceBusiResultUI", "net error: %s", new Object[] { localObject });
      break;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void setContentViewVisibility(int paramInt)
  {
    AppMethodBeat.i(68007);
    getContentView().setVisibility(paramInt);
    AppMethodBeat.o(68007);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBusiResultUI
 * JD-Core Version:    0.7.0.1
 */