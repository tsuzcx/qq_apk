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
import com.tencent.mm.ak.n;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.yv;
import com.tencent.mm.plugin.remittance.model.BusiRemittanceResp;
import com.tencent.mm.plugin.remittance.model.i;
import com.tencent.mm.plugin.remittance.model.j;
import com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget;
import com.tencent.mm.plugin.wallet_core.utils.g;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.dk;
import com.tencent.mm.protocal.protobuf.pz;
import com.tencent.mm.protocal.protobuf.qa;
import com.tencent.mm.protocal.protobuf.qj;
import com.tencent.mm.protocal.protobuf.rf;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.tools.p;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(19)
public class RemittanceBusiResultUI
  extends WalletBaseUI
{
  private String app_id;
  private TextView lHk;
  private int mChannel;
  private Button mpo;
  private int qgQ;
  private String wNH;
  private int ynp;
  private String ynq;
  private String ypW;
  private String yqB;
  private String yrA;
  private String yrB;
  private int yrC;
  private String yrD;
  private String yrE;
  private com.tencent.mm.bw.b yrF;
  private boolean yrG;
  private String yrH;
  private BusiRemittanceResp yrI;
  private qa yrJ;
  private boolean yrK;
  private Runnable yrL;
  private dk yrM;
  private int yrN;
  private e.a.a.c yrO;
  private WalletSuccPageAwardWidget yrP;
  private ViewGroup yrQ;
  private ViewGroup yrR;
  private ViewGroup yrS;
  private TextView yrT;
  private boolean yrU;
  private com.tencent.mm.sdk.b.c<yv> yrV;
  private boolean yrW;
  private Runnable yrX;
  private TextView yrh;
  private TextView yri;
  private TextView yrj;
  private TextView yrk;
  private CdnImageView yrl;
  private TextView yrm;
  private TextView yrn;
  private Button yro;
  private ViewGroup yrp;
  private ViewGroup yrq;
  private ViewGroup yrr;
  private ViewGroup yrs;
  private View yrt;
  private LinearLayout yru;
  private String yrv;
  private String yrw;
  private String yrx;
  private double yry;
  private String yrz;
  
  public RemittanceBusiResultUI()
  {
    AppMethodBeat.i(67998);
    this.yrG = false;
    this.yrK = false;
    this.yrL = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(67990);
        RemittanceBusiResultUI.a(RemittanceBusiResultUI.this);
        j localj = new j(RemittanceBusiResultUI.b(RemittanceBusiResultUI.this), RemittanceBusiResultUI.c(RemittanceBusiResultUI.this), RemittanceBusiResultUI.d(RemittanceBusiResultUI.this).dEu, RemittanceBusiResultUI.e(RemittanceBusiResultUI.this) - 1, System.currentTimeMillis());
        RemittanceBusiResultUI.this.doSceneProgress(localj);
        RemittanceBusiResultUI.f(RemittanceBusiResultUI.this);
        AppMethodBeat.o(67990);
      }
    };
    this.yrM = new dk();
    this.yrU = false;
    this.yrV = new com.tencent.mm.sdk.b.c() {};
    this.yrW = true;
    this.yrX = new RemittanceBusiResultUI.8(this);
    AppMethodBeat.o(67998);
  }
  
  private void a(j paramj)
  {
    AppMethodBeat.i(68008);
    this.yrR.setVisibility(8);
    this.yrQ.setVisibility(8);
    this.yrS.setVisibility(8);
    TextView localTextView = (TextView)findViewById(2131306040);
    final View localView = findViewById(2131306041);
    LinkedList localLinkedList;
    int i;
    Object localObject2;
    int j;
    Object localObject1;
    if ((paramj != null) && (paramj.ynO != null) && (paramj.ynO.GeA.size() > 0))
    {
      localLinkedList = paramj.ynO.GeA;
      if (localLinkedList != null)
      {
        i = localLinkedList.size();
        ae.i("MicroMsg.RemittanceBusiResultUI", "discountInfoList: %s, size: %s received_amount: %s", new Object[] { localLinkedList, Integer.valueOf(i), Long.valueOf(paramj.ynO.Gez) });
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
        this.yrR.removeAllViews();
        this.yrQ.setOnClickListener(null);
        if (j <= 1) {
          break label505;
        }
        paramj = paramj.ynO.GeD;
        this.yrW = true;
        localView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(67995);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceBusiResultUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            if (RemittanceBusiResultUI.j(RemittanceBusiResultUI.this))
            {
              localView.setVisibility(8);
              RemittanceBusiResultUI.k(RemittanceBusiResultUI.this).setVisibility(0);
              paramAnonymousView = RemittanceBusiResultUI.this;
              RemittanceBusiResultUI.l(RemittanceBusiResultUI.this);
              RemittanceBusiResultUI.m(paramAnonymousView);
              paramAnonymousView = RemittanceBusiResultUI.this;
              if (RemittanceBusiResultUI.j(RemittanceBusiResultUI.this)) {
                break label152;
              }
            }
            label152:
            for (boolean bool = true;; bool = false)
            {
              RemittanceBusiResultUI.a(paramAnonymousView, bool);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceBusiResultUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(67995);
              return;
              localView.setVisibility(0);
              RemittanceBusiResultUI.k(RemittanceBusiResultUI.this).setVisibility(8);
              RemittanceBusiResultUI.m(RemittanceBusiResultUI.this);
              break;
            }
          }
        });
        this.yrQ.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(67996);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceBusiResultUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            if (RemittanceBusiResultUI.j(RemittanceBusiResultUI.this))
            {
              localView.setVisibility(8);
              RemittanceBusiResultUI.k(RemittanceBusiResultUI.this).setVisibility(0);
              paramAnonymousView = RemittanceBusiResultUI.this;
              RemittanceBusiResultUI.l(RemittanceBusiResultUI.this);
              RemittanceBusiResultUI.m(paramAnonymousView);
              paramAnonymousView = RemittanceBusiResultUI.this;
              if (RemittanceBusiResultUI.j(RemittanceBusiResultUI.this)) {
                break label152;
              }
            }
            label152:
            for (boolean bool = true;; bool = false)
            {
              RemittanceBusiResultUI.a(paramAnonymousView, bool);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceBusiResultUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(67996);
              return;
              localView.setVisibility(0);
              RemittanceBusiResultUI.k(RemittanceBusiResultUI.this).setVisibility(8);
              RemittanceBusiResultUI.m(RemittanceBusiResultUI.this);
              break;
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
            localLayoutParams.bottomMargin = com.tencent.mm.cb.a.fromDPToPix(this, 6);
            ((TextView)localObject2).setLayoutParams(localLayoutParams);
            ((TextView)localObject2).setTextSize(1, 12.0F);
            ((TextView)localObject2).setTextColor(getResources().getColor(2131099777));
            ((TextView)localObject2).setText((CharSequence)localObject1);
            this.yrR.addView((View)localObject2);
            i += 1;
            continue;
            i = 0;
            break;
          }
        }
        this.yrR.setVisibility(0);
        this.yrQ.setVisibility(0);
        localObject1 = paramj;
        label401:
        if (this.yrW)
        {
          localView.setVisibility(0);
          paramj = bu.bI((String)localObject1, "");
          paramj = new SpannableString(paramj + " ");
          if (j <= 1) {
            break label487;
          }
          findViewById(2131306042).setVisibility(0);
        }
        for (;;)
        {
          localTextView.setText(paramj);
          this.yrQ.setVisibility(8);
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
    this.yru.removeAllViews();
    Object localObject1;
    if ((this.yrI != null) && (!bu.isNullOrNil(this.yrI.ynA))) {
      localObject1 = this.yrI.ynA;
    }
    label569:
    label586:
    for (;;)
    {
      Object localObject2;
      if ((eE(this.yrp)) && (eE(this.yrq)) && (eE(this.yrS)) && (eE(this.yrr)) && (eE(this.yrs)) && (!WalletSuccPageAwardWidget.a(this.yrO)) && (eE(findViewById(2131306041))) && (eE(this.yrQ)))
      {
        localObject2 = (ViewGroup)getLayoutInflater().inflate(2131493902, this.yru, false);
        this.yru.addView((View)localObject2);
        paramj = (CdnImageView)((ViewGroup)localObject2).findViewById(2131304006);
        localObject2 = (TextView)((ViewGroup)localObject2).findViewById(2131303742);
        if (!bu.isNullOrNil(this.ynq))
        {
          if (this.yrN == 1) {
            paramj.setRoundCorner(true);
          }
          paramj.setUrl(this.ynq);
          label203:
          ((TextView)localObject2).setText((CharSequence)localObject1);
        }
      }
      for (;;)
      {
        dMY();
        AppMethodBeat.o(68010);
        return;
        if (!bu.isNullOrNil(this.ypW))
        {
          localObject2 = com.tencent.mm.wallet_core.ui.f.gX(this.ypW, 6);
          localObject1 = localObject2;
          if (bu.isNullOrNil(this.yrH)) {
            break label586;
          }
          localObject1 = getString(2131762438, new Object[] { localObject2, this.yrH });
          break;
        }
        localObject2 = com.tencent.mm.wallet_core.ui.f.gX(com.tencent.mm.wallet_core.ui.f.zP(this.yrx), 6);
        localObject1 = localObject2;
        if (bu.isNullOrNil(this.yrH)) {
          break label586;
        }
        localObject1 = getString(2131762438, new Object[] { localObject2, this.yrH });
        break;
        if (this.yrN == 1)
        {
          a.b.d(paramj, this.yrx);
          break label203;
        }
        a.b.c(paramj, this.yrx);
        break label203;
        localObject2 = (ViewGroup)getLayoutInflater().inflate(2131495250, this.yru, false);
        this.yru.addView((View)localObject2);
        localObject2 = (CdnImageView)findViewById(2131304006);
        TextView localTextView1 = (TextView)findViewById(2131303742);
        View localView = findViewById(2131301357);
        TextView localTextView2 = (TextView)findViewById(2131303741);
        localTextView1.setText(k.c(this, (CharSequence)localObject1));
        ((CdnImageView)localObject2).setVisibility(0);
        if (!bu.isNullOrNil(this.ynq))
        {
          if (this.yrN == 1) {
            ((CdnImageView)localObject2).setRoundCorner(true);
          }
          ((CdnImageView)localObject2).setUrl(this.ynq);
        }
        for (;;)
        {
          localView.setVisibility(8);
          localTextView2.setVisibility(8);
          if (paramj == null) {
            break;
          }
          if (paramj.ynO.GeC != 1) {
            break label569;
          }
          localView.setVisibility(0);
          localTextView2.setVisibility(0);
          localTextView2.setText(com.tencent.mm.wallet_core.ui.f.D(paramj.ynO.Gez / 100.0D));
          break;
          if (this.yrN == 1) {
            a.b.d((ImageView)localObject2, this.yrx);
          } else {
            a.b.c((ImageView)localObject2, this.yrx);
          }
        }
        localView.setVisibility(8);
        localTextView2.setVisibility(8);
      }
    }
  }
  
  private void dMY()
  {
    AppMethodBeat.i(68009);
    p.a(this, (ScrollView)findViewById(2131304380), findViewById(2131297629), findViewById(2131296668), findViewById(2131297452), 32, 0.0F, true);
    AppMethodBeat.o(68009);
  }
  
  private static boolean eE(View paramView)
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
    ae.i("MicroMsg.RemittanceBusiResultUI", "finish this %s %s", new Object[] { this, bu.fpN() });
    if (this.yrU)
    {
      AppMethodBeat.o(67999);
      return;
    }
    super.finish();
    this.yrU = true;
    AppMethodBeat.o(67999);
  }
  
  public int getLayoutId()
  {
    return 2131495251;
  }
  
  public void initView()
  {
    AppMethodBeat.i(68002);
    this.lHk = ((TextView)findViewById(2131303743));
    this.yrh = ((TextView)findViewById(2131303734));
    this.yri = ((TextView)findViewById(2131303740));
    this.yrj = ((TextView)findViewById(2131303736));
    this.yrk = ((TextView)findViewById(2131303738));
    this.yrp = ((LinearLayout)findViewById(2131303739));
    this.yrq = ((LinearLayout)findViewById(2131303735));
    this.yrr = ((LinearLayout)findViewById(2131303737));
    this.yrl = ((CdnImageView)findViewById(2131303730));
    this.yrm = ((TextView)findViewById(2131303732));
    this.yrn = ((TextView)findViewById(2131303731));
    this.yro = ((Button)findViewById(2131303728));
    this.yrs = ((ViewGroup)findViewById(2131303729));
    this.mpo = ((Button)findViewById(2131303733));
    this.yrt = findViewById(2131304828);
    this.yru = ((LinearLayout)findViewById(2131303995));
    this.yrh.setText(com.tencent.mm.wallet_core.ui.f.C(this.yry));
    ar.o(this.yrX, 500L);
    if (!bu.isNullOrNil(this.yrv))
    {
      this.yri.setText(this.yrv);
      this.yrp.setVisibility(0);
      if (bu.isNullOrNil(this.yrw)) {
        break label413;
      }
      this.yrj.setText(this.yrw);
      this.yrq.setVisibility(0);
    }
    for (;;)
    {
      this.mpo.setOnClickListener(new RemittanceBusiResultUI.3(this));
      this.yrP = ((WalletSuccPageAwardWidget)findViewById(2131297022));
      this.yrQ = ((ViewGroup)findViewById(2131299143));
      this.yrR = ((ViewGroup)findViewById(2131299141));
      this.yrS = ((ViewGroup)findViewById(2131303089));
      this.yrT = ((TextView)findViewById(2131303088));
      AppMethodBeat.o(68002);
      return;
      this.yrp.setVisibility(8);
      break;
      label413:
      this.yrq.setVisibility(8);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(68001);
    super.onCreate(paramBundle);
    addSceneEndListener(1537);
    addSceneEndListener(1680);
    addSceneEndListener(2504);
    this.yrV.alive();
    if (d.lA(21))
    {
      if (!d.lA(23)) {
        break label521;
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
      this.ypW = getIntent().getStringExtra("key_mch_name");
      this.yrI = ((BusiRemittanceResp)getIntent().getParcelableExtra("BusiRemittanceResp"));
      this.yry = getIntent().getDoubleExtra("key_money", 0.0D);
      this.yrx = getIntent().getStringExtra("key_rcver_name");
      this.yrH = getIntent().getStringExtra("key_rcver_true_name");
      this.yrv = getIntent().getStringExtra("key_rcv_desc");
      this.yrw = getIntent().getStringExtra("key_pay_desc");
      this.yrz = getIntent().getStringExtra("key_f2f_id");
      this.wNH = getIntent().getStringExtra("key_trans_id");
      this.yqB = getIntent().getStringExtra("key_rcvr_open_id");
      this.yrE = getIntent().getStringExtra("key_check_sign");
      this.yrA = getIntent().getStringExtra("key_pay_desc");
      this.yrB = getIntent().getStringExtra("key_rcv_desc");
      this.yrC = getIntent().getIntExtra("key_scan_sceen", 0);
      this.mChannel = getIntent().getIntExtra("key_channel", 0);
      this.yrD = getIntent().getStringExtra("key_succ_page_extend");
      paramBundle = getIntent().getByteArrayExtra("AfterPlaceOrderCommReq");
      this.yrJ = i.axC(getIntent().getStringExtra("key_succ_fault_config"));
      try
      {
        this.yrM.parseFrom(paramBundle);
        this.yrN = getIntent().getIntExtra("key_succ_show_avatar_type", 0);
        this.ynp = getIntent().getIntExtra("key_succ_show_avatar_show", 0);
        this.ynq = getIntent().getStringExtra("key_succ_show_avatar_url");
        this.app_id = getIntent().getStringExtra("app_id");
        this.yrG = false;
        ae.i("MicroMsg.RemittanceBusiResultUI", "fetch data");
        ae.i("MicroMsg.RemittanceBusiResultUI", "fetchData() mBusiF2FFaultConfig.flag:%s mBusiF2FFaultConfig.succpage_first_delay_ms:%s", new Object[] { Integer.valueOf(this.yrJ.dEu), Integer.valueOf(this.yrJ.GdD) });
        if (bu.jB(this.yrJ.dEu, 1))
        {
          ar.o(this.yrL, this.yrJ.GdD);
          initView();
          AppMethodBeat.o(68001);
          return;
          label521:
          getWindow().setStatusBarColor(getContext().getResources().getColor(2131099679));
        }
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          ae.printErrStackTrace("MicroMsg.RemittanceBusiResultUI", paramBundle, "", new Object[0]);
          continue;
          doSceneProgress(new j(this.yrM, this.yrD));
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
    this.yrV.dead();
    if (this.yrO != null) {
      this.yrP.onDestroy();
    }
    ar.ay(this.yrX);
    AppMethodBeat.o(68006);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(68005);
    super.onResume();
    if (this.yrG)
    {
      ae.i("MicroMsg.RemittanceBusiResultUI", "do act qry");
      int i = (int)Math.round(this.yry * 100.0D);
      doSceneProgress(new com.tencent.mm.plugin.remittance.model.f(this.yrz, this.wNH, this.yqB, i, this.yrF, this.yrE), false);
      this.yrG = false;
    }
    if (this.yrO != null) {
      this.yrP.onResume();
    }
    AppMethodBeat.o(68005);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(68003);
    ae.i("MicroMsg.RemittanceBusiResultUI", "errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scenetype:" + paramn.getType());
    Object localObject;
    if ((paramn instanceof j))
    {
      localObject = (j)paramn;
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        if (this.yrK)
        {
          ae.i("MicroMsg.RemittanceBusiResultUI", "NetSceneBusiF2fSucpage success(mIfSuccNetSceneBusiF2fSucpage:%s)", new Object[] { Boolean.valueOf(this.yrK) });
          if (this.yrO == null) {
            break label809;
          }
        }
      }
    }
    label809:
    for (boolean bool = this.yrP.onSceneEnd(paramInt1, paramInt2, paramString, paramn);; bool = false)
    {
      this.yrt.setVisibility(8);
      AppMethodBeat.o(68003);
      return bool;
      if (((j)localObject).ynO.oGt == 0)
      {
        this.yrK = true;
        ar.ay(this.yrL);
        ae.i("MicroMsg.RemittanceBusiResultUI", "exposure info: %s", new Object[] { ((j)localObject).ynO.DqV });
        this.yrO = ((j)localObject).ynO.DqV;
        if (WalletSuccPageAwardWidget.a(this.yrO))
        {
          ae.i("MicroMsg.RemittanceBusiResultUI", "setAwardWidget, mTransId: %s", new Object[] { this.wNH });
          this.yrP.a(this, this.yrO, this.wNH, true, (ImageView)findViewById(2131297029));
          this.yrP.init();
          this.yrP.setVisibility(0);
          ImageView localImageView = (ImageView)findViewById(2131297029);
          localImageView.post(new RemittanceBusiResultUI.4(this, localImageView, (ViewGroup)findViewById(2131304380)));
          dMY();
          label324:
          a((j)localObject);
          ar.ay(this.yrX);
          if (bu.isNullOrNil(((j)localObject).ynO.GeE)) {
            break label448;
          }
          if (!bu.isNullOrNil(((j)localObject).ynO.GeF)) {
            break label426;
          }
          this.yrk.setTextColor(getResources().getColor(2131100707));
          label382:
          this.yrk.setText(((j)localObject).ynO.GeE);
          this.yrr.setVisibility(0);
        }
        for (;;)
        {
          b((j)localObject);
          break;
          this.yrP.setVisibility(8);
          break label324;
          label426:
          this.yrk.setTextColor(g.cp(((j)localObject).ynO.GeF, true));
          break label382;
          label448:
          this.yrr.setVisibility(8);
        }
      }
      ae.e("MicroMsg.RemittanceBusiResultUI", "result response: %s, %s, %s", new Object[] { Integer.valueOf(((j)localObject).ynO.oGt), ((j)localObject).ynO.oGu, Boolean.valueOf(((j)localObject).ynO.GeG) });
      if (((j)localObject).ynO.GeG) {
        break;
      }
      this.yrK = true;
      ar.ay(this.yrL);
      break;
      ae.e("MicroMsg.RemittanceBusiResultUI", "net error: %s", new Object[] { localObject });
      break;
      if (!(paramn instanceof com.tencent.mm.plugin.remittance.model.f)) {
        break;
      }
      localObject = (com.tencent.mm.plugin.remittance.model.f)paramn;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (((com.tencent.mm.plugin.remittance.model.f)localObject).ynD.oGt == 0)
        {
          localObject = ((com.tencent.mm.plugin.remittance.model.f)localObject).ynD.GdC;
          if (localObject != null)
          {
            this.yrl.setUrl(((rf)localObject).dEM);
            this.yrm.setText(((rf)localObject).title);
            this.yrn.setText(((rf)localObject).Dps);
            this.yro.setText(((rf)localObject).DyN);
            this.yro.setOnClickListener(new RemittanceBusiResultUI.5(this, (rf)localObject));
            this.yro.setBackgroundResource(2131233827);
            this.yro.setTextColor(getResources().getColor(2131101183));
            this.yrs.setVisibility(0);
            dMY();
            break;
          }
          ae.i("MicroMsg.RemittanceBusiResultUI", "app info is null");
          this.yrs.setVisibility(8);
          break;
        }
        ae.e("MicroMsg.RemittanceBusiResultUI", "qry response: %s, %s", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.remittance.model.f)localObject).ynD.oGt), ((com.tencent.mm.plugin.remittance.model.f)localObject).ynD.oGu });
        Toast.makeText(this, ((com.tencent.mm.plugin.remittance.model.f)localObject).ynD.oGu, 1).show();
        break;
      }
      ae.e("MicroMsg.RemittanceBusiResultUI", "net error: %s", new Object[] { localObject });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBusiResultUI
 * JD-Core Version:    0.7.0.1
 */