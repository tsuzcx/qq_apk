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
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.yp;
import com.tencent.mm.plugin.remittance.model.BusiRemittanceResp;
import com.tencent.mm.plugin.remittance.model.f;
import com.tencent.mm.plugin.remittance.model.i;
import com.tencent.mm.plugin.remittance.model.j;
import com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget;
import com.tencent.mm.plugin.wallet_core.utils.g;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.dk;
import com.tencent.mm.protocal.protobuf.px;
import com.tencent.mm.protocal.protobuf.py;
import com.tencent.mm.protocal.protobuf.qh;
import com.tencent.mm.protocal.protobuf.rd;
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
  private String app_id;
  private TextView lCL;
  private int mChannel;
  private Button mkr;
  private int qal;
  private String wxW;
  private int xXx;
  private String xXy;
  private String yaK;
  private String yae;
  private ViewGroup ybA;
  private ViewGroup ybB;
  private View ybC;
  private LinearLayout ybD;
  private String ybE;
  private String ybF;
  private String ybG;
  private double ybH;
  private String ybI;
  private String ybJ;
  private String ybK;
  private int ybL;
  private String ybM;
  private String ybN;
  private com.tencent.mm.bx.b ybO;
  private boolean ybP;
  private String ybQ;
  private BusiRemittanceResp ybR;
  private py ybS;
  private boolean ybT;
  private Runnable ybU;
  private dk ybV;
  private int ybW;
  private e.a.a.c ybX;
  private WalletSuccPageAwardWidget ybY;
  private ViewGroup ybZ;
  private TextView ybq;
  private TextView ybr;
  private TextView ybs;
  private TextView ybt;
  private CdnImageView ybu;
  private TextView ybv;
  private TextView ybw;
  private Button ybx;
  private ViewGroup yby;
  private ViewGroup ybz;
  private ViewGroup yca;
  private ViewGroup ycb;
  private TextView ycc;
  private boolean ycd;
  private com.tencent.mm.sdk.b.c<yp> yce;
  private boolean ycf;
  private Runnable ycg;
  
  public RemittanceBusiResultUI()
  {
    AppMethodBeat.i(67998);
    this.ybP = false;
    this.ybT = false;
    this.ybU = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(67990);
        RemittanceBusiResultUI.a(RemittanceBusiResultUI.this);
        j localj = new j(RemittanceBusiResultUI.b(RemittanceBusiResultUI.this), RemittanceBusiResultUI.c(RemittanceBusiResultUI.this), RemittanceBusiResultUI.d(RemittanceBusiResultUI.this).dDp, RemittanceBusiResultUI.e(RemittanceBusiResultUI.this) - 1, System.currentTimeMillis());
        RemittanceBusiResultUI.this.doSceneProgress(localj);
        RemittanceBusiResultUI.f(RemittanceBusiResultUI.this);
        AppMethodBeat.o(67990);
      }
    };
    this.ybV = new dk();
    this.ycd = false;
    this.yce = new RemittanceBusiResultUI.2(this);
    this.ycf = true;
    this.ycg = new RemittanceBusiResultUI.8(this);
    AppMethodBeat.o(67998);
  }
  
  private void a(j paramj)
  {
    AppMethodBeat.i(68008);
    this.yca.setVisibility(8);
    this.ybZ.setVisibility(8);
    this.ycb.setVisibility(8);
    TextView localTextView = (TextView)findViewById(2131306040);
    final View localView = findViewById(2131306041);
    LinkedList localLinkedList;
    int i;
    Object localObject2;
    int j;
    Object localObject1;
    if ((paramj != null) && (paramj.xXW != null) && (paramj.xXW.FMb.size() > 0))
    {
      localLinkedList = paramj.xXW.FMb;
      if (localLinkedList != null)
      {
        i = localLinkedList.size();
        ad.i("MicroMsg.RemittanceBusiResultUI", "discountInfoList: %s, size: %s received_amount: %s", new Object[] { localLinkedList, Integer.valueOf(i), Long.valueOf(paramj.xXW.FMa) });
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
        this.yca.removeAllViews();
        this.ybZ.setOnClickListener(null);
        if (j <= 1) {
          break label505;
        }
        paramj = paramj.xXW.FMe;
        this.ycf = true;
        localView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(67995);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceBusiResultUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
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
        this.ybZ.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(67996);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceBusiResultUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
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
            localLayoutParams.bottomMargin = com.tencent.mm.cc.a.fromDPToPix(this, 6);
            ((TextView)localObject2).setLayoutParams(localLayoutParams);
            ((TextView)localObject2).setTextSize(1, 12.0F);
            ((TextView)localObject2).setTextColor(getResources().getColor(2131099777));
            ((TextView)localObject2).setText((CharSequence)localObject1);
            this.yca.addView((View)localObject2);
            i += 1;
            continue;
            i = 0;
            break;
          }
        }
        this.yca.setVisibility(0);
        this.ybZ.setVisibility(0);
        localObject1 = paramj;
        label401:
        if (this.ycf)
        {
          localView.setVisibility(0);
          paramj = bt.bI((String)localObject1, "");
          paramj = new SpannableString(paramj + " ");
          if (j <= 1) {
            break label487;
          }
          findViewById(2131306042).setVisibility(0);
        }
        for (;;)
        {
          localTextView.setText(paramj);
          this.ybZ.setVisibility(8);
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
    this.ybD.removeAllViews();
    Object localObject1;
    if ((this.ybR != null) && (!bt.isNullOrNil(this.ybR.xXI))) {
      localObject1 = this.ybR.xXI;
    }
    label569:
    label586:
    for (;;)
    {
      Object localObject2;
      if ((eE(this.yby)) && (eE(this.ybz)) && (eE(this.ycb)) && (eE(this.ybA)) && (eE(this.ybB)) && (!WalletSuccPageAwardWidget.a(this.ybX)) && (eE(findViewById(2131306041))) && (eE(this.ybZ)))
      {
        localObject2 = (ViewGroup)getLayoutInflater().inflate(2131493902, this.ybD, false);
        this.ybD.addView((View)localObject2);
        paramj = (CdnImageView)((ViewGroup)localObject2).findViewById(2131304006);
        localObject2 = (TextView)((ViewGroup)localObject2).findViewById(2131303742);
        if (!bt.isNullOrNil(this.xXy))
        {
          if (this.ybW == 1) {
            paramj.setRoundCorner(true);
          }
          paramj.setUrl(this.xXy);
          label203:
          ((TextView)localObject2).setText((CharSequence)localObject1);
        }
      }
      for (;;)
      {
        dJG();
        AppMethodBeat.o(68010);
        return;
        if (!bt.isNullOrNil(this.yae))
        {
          localObject2 = e.gO(this.yae, 6);
          localObject1 = localObject2;
          if (bt.isNullOrNil(this.ybQ)) {
            break label586;
          }
          localObject1 = getString(2131762438, new Object[] { localObject2, this.ybQ });
          break;
        }
        localObject2 = e.gO(e.zf(this.ybG), 6);
        localObject1 = localObject2;
        if (bt.isNullOrNil(this.ybQ)) {
          break label586;
        }
        localObject1 = getString(2131762438, new Object[] { localObject2, this.ybQ });
        break;
        if (this.ybW == 1)
        {
          a.b.d(paramj, this.ybG);
          break label203;
        }
        a.b.c(paramj, this.ybG);
        break label203;
        localObject2 = (ViewGroup)getLayoutInflater().inflate(2131495250, this.ybD, false);
        this.ybD.addView((View)localObject2);
        localObject2 = (CdnImageView)findViewById(2131304006);
        TextView localTextView1 = (TextView)findViewById(2131303742);
        View localView = findViewById(2131301357);
        TextView localTextView2 = (TextView)findViewById(2131303741);
        localTextView1.setText(k.c(this, (CharSequence)localObject1));
        ((CdnImageView)localObject2).setVisibility(0);
        if (!bt.isNullOrNil(this.xXy))
        {
          if (this.ybW == 1) {
            ((CdnImageView)localObject2).setRoundCorner(true);
          }
          ((CdnImageView)localObject2).setUrl(this.xXy);
        }
        for (;;)
        {
          localView.setVisibility(8);
          localTextView2.setVisibility(8);
          if (paramj == null) {
            break;
          }
          if (paramj.xXW.FMd != 1) {
            break label569;
          }
          localView.setVisibility(0);
          localTextView2.setVisibility(0);
          localTextView2.setText(e.D(paramj.xXW.FMa / 100.0D));
          break;
          if (this.ybW == 1) {
            a.b.d((ImageView)localObject2, this.ybG);
          } else {
            a.b.c((ImageView)localObject2, this.ybG);
          }
        }
        localView.setVisibility(8);
        localTextView2.setVisibility(8);
      }
    }
  }
  
  private void dJG()
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
    ad.i("MicroMsg.RemittanceBusiResultUI", "finish this %s %s", new Object[] { this, bt.flS() });
    if (this.ycd)
    {
      AppMethodBeat.o(67999);
      return;
    }
    super.finish();
    this.ycd = true;
    AppMethodBeat.o(67999);
  }
  
  public int getLayoutId()
  {
    return 2131495251;
  }
  
  public void initView()
  {
    AppMethodBeat.i(68002);
    this.lCL = ((TextView)findViewById(2131303743));
    this.ybq = ((TextView)findViewById(2131303734));
    this.ybr = ((TextView)findViewById(2131303740));
    this.ybs = ((TextView)findViewById(2131303736));
    this.ybt = ((TextView)findViewById(2131303738));
    this.yby = ((LinearLayout)findViewById(2131303739));
    this.ybz = ((LinearLayout)findViewById(2131303735));
    this.ybA = ((LinearLayout)findViewById(2131303737));
    this.ybu = ((CdnImageView)findViewById(2131303730));
    this.ybv = ((TextView)findViewById(2131303732));
    this.ybw = ((TextView)findViewById(2131303731));
    this.ybx = ((Button)findViewById(2131303728));
    this.ybB = ((ViewGroup)findViewById(2131303729));
    this.mkr = ((Button)findViewById(2131303733));
    this.ybC = findViewById(2131304828);
    this.ybD = ((LinearLayout)findViewById(2131303995));
    this.ybq.setText(e.C(this.ybH));
    aq.o(this.ycg, 500L);
    if (!bt.isNullOrNil(this.ybE))
    {
      this.ybr.setText(this.ybE);
      this.yby.setVisibility(0);
      if (bt.isNullOrNil(this.ybF)) {
        break label413;
      }
      this.ybs.setText(this.ybF);
      this.ybz.setVisibility(0);
    }
    for (;;)
    {
      this.mkr.setOnClickListener(new RemittanceBusiResultUI.3(this));
      this.ybY = ((WalletSuccPageAwardWidget)findViewById(2131297022));
      this.ybZ = ((ViewGroup)findViewById(2131299143));
      this.yca = ((ViewGroup)findViewById(2131299141));
      this.ycb = ((ViewGroup)findViewById(2131303089));
      this.ycc = ((TextView)findViewById(2131303088));
      AppMethodBeat.o(68002);
      return;
      this.yby.setVisibility(8);
      break;
      label413:
      this.ybz.setVisibility(8);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(68001);
    super.onCreate(paramBundle);
    addSceneEndListener(1537);
    addSceneEndListener(1680);
    addSceneEndListener(2504);
    this.yce.alive();
    if (d.ly(21))
    {
      if (!d.ly(23)) {
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
      this.yae = getIntent().getStringExtra("key_mch_name");
      this.ybR = ((BusiRemittanceResp)getIntent().getParcelableExtra("BusiRemittanceResp"));
      this.ybH = getIntent().getDoubleExtra("key_money", 0.0D);
      this.ybG = getIntent().getStringExtra("key_rcver_name");
      this.ybQ = getIntent().getStringExtra("key_rcver_true_name");
      this.ybE = getIntent().getStringExtra("key_rcv_desc");
      this.ybF = getIntent().getStringExtra("key_pay_desc");
      this.ybI = getIntent().getStringExtra("key_f2f_id");
      this.wxW = getIntent().getStringExtra("key_trans_id");
      this.yaK = getIntent().getStringExtra("key_rcvr_open_id");
      this.ybN = getIntent().getStringExtra("key_check_sign");
      this.ybJ = getIntent().getStringExtra("key_pay_desc");
      this.ybK = getIntent().getStringExtra("key_rcv_desc");
      this.ybL = getIntent().getIntExtra("key_scan_sceen", 0);
      this.mChannel = getIntent().getIntExtra("key_channel", 0);
      this.ybM = getIntent().getStringExtra("key_succ_page_extend");
      paramBundle = getIntent().getByteArrayExtra("AfterPlaceOrderCommReq");
      this.ybS = i.awn(getIntent().getStringExtra("key_succ_fault_config"));
      try
      {
        this.ybV.parseFrom(paramBundle);
        this.ybW = getIntent().getIntExtra("key_succ_show_avatar_type", 0);
        this.xXx = getIntent().getIntExtra("key_succ_show_avatar_show", 0);
        this.xXy = getIntent().getStringExtra("key_succ_show_avatar_url");
        this.app_id = getIntent().getStringExtra("app_id");
        this.ybP = false;
        ad.i("MicroMsg.RemittanceBusiResultUI", "fetch data");
        ad.i("MicroMsg.RemittanceBusiResultUI", "fetchData() mBusiF2FFaultConfig.flag:%s mBusiF2FFaultConfig.succpage_first_delay_ms:%s", new Object[] { Integer.valueOf(this.ybS.dDp), Integer.valueOf(this.ybS.FLe) });
        if (bt.jx(this.ybS.dDp, 1))
        {
          aq.o(this.ybU, this.ybS.FLe);
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
          ad.printErrStackTrace("MicroMsg.RemittanceBusiResultUI", paramBundle, "", new Object[0]);
          continue;
          doSceneProgress(new j(this.ybV, this.ybM));
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
    this.yce.dead();
    if (this.ybX != null) {
      this.ybY.onDestroy();
    }
    aq.aA(this.ycg);
    AppMethodBeat.o(68006);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(68005);
    super.onResume();
    if (this.ybP)
    {
      ad.i("MicroMsg.RemittanceBusiResultUI", "do act qry");
      int i = (int)Math.round(this.ybH * 100.0D);
      doSceneProgress(new f(this.ybI, this.wxW, this.yaK, i, this.ybO, this.ybN), false);
      this.ybP = false;
    }
    if (this.ybX != null) {
      this.ybY.onResume();
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
        if (this.ybT)
        {
          ad.i("MicroMsg.RemittanceBusiResultUI", "NetSceneBusiF2fSucpage success(mIfSuccNetSceneBusiF2fSucpage:%s)", new Object[] { Boolean.valueOf(this.ybT) });
          if (this.ybX == null) {
            break label809;
          }
        }
      }
    }
    label809:
    for (boolean bool = this.ybY.onSceneEnd(paramInt1, paramInt2, paramString, paramn);; bool = false)
    {
      this.ybC.setVisibility(8);
      AppMethodBeat.o(68003);
      return bool;
      if (((j)localObject).xXW.ozR == 0)
      {
        this.ybT = true;
        aq.aA(this.ybU);
        ad.i("MicroMsg.RemittanceBusiResultUI", "exposure info: %s", new Object[] { ((j)localObject).xXW.CZq });
        this.ybX = ((j)localObject).xXW.CZq;
        if (WalletSuccPageAwardWidget.a(this.ybX))
        {
          ad.i("MicroMsg.RemittanceBusiResultUI", "setAwardWidget, mTransId: %s", new Object[] { this.wxW });
          this.ybY.a(this, this.ybX, this.wxW, true, (ImageView)findViewById(2131297029));
          this.ybY.init();
          this.ybY.setVisibility(0);
          ImageView localImageView = (ImageView)findViewById(2131297029);
          localImageView.post(new RemittanceBusiResultUI.4(this, localImageView, (ViewGroup)findViewById(2131304380)));
          dJG();
          label324:
          a((j)localObject);
          aq.aA(this.ycg);
          if (bt.isNullOrNil(((j)localObject).xXW.FMf)) {
            break label448;
          }
          if (!bt.isNullOrNil(((j)localObject).xXW.FMg)) {
            break label426;
          }
          this.ybt.setTextColor(getResources().getColor(2131100707));
          label382:
          this.ybt.setText(((j)localObject).xXW.FMf);
          this.ybA.setVisibility(0);
        }
        for (;;)
        {
          b((j)localObject);
          break;
          this.ybY.setVisibility(8);
          break label324;
          label426:
          this.ybt.setTextColor(g.cl(((j)localObject).xXW.FMg, true));
          break label382;
          label448:
          this.ybA.setVisibility(8);
        }
      }
      ad.e("MicroMsg.RemittanceBusiResultUI", "result response: %s, %s, %s", new Object[] { Integer.valueOf(((j)localObject).xXW.ozR), ((j)localObject).xXW.ozS, Boolean.valueOf(((j)localObject).xXW.FMh) });
      if (((j)localObject).xXW.FMh) {
        break;
      }
      this.ybT = true;
      aq.aA(this.ybU);
      break;
      ad.e("MicroMsg.RemittanceBusiResultUI", "net error: %s", new Object[] { localObject });
      break;
      if (!(paramn instanceof f)) {
        break;
      }
      localObject = (f)paramn;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (((f)localObject).xXL.ozR == 0)
        {
          localObject = ((f)localObject).xXL.FLd;
          if (localObject != null)
          {
            this.ybu.setUrl(((rd)localObject).dDH);
            this.ybv.setText(((rd)localObject).title);
            this.ybw.setText(((rd)localObject).CXN);
            this.ybx.setText(((rd)localObject).Dhj);
            this.ybx.setOnClickListener(new RemittanceBusiResultUI.5(this, (rd)localObject));
            this.ybx.setBackgroundResource(2131233827);
            this.ybx.setTextColor(getResources().getColor(2131101183));
            this.ybB.setVisibility(0);
            dJG();
            break;
          }
          ad.i("MicroMsg.RemittanceBusiResultUI", "app info is null");
          this.ybB.setVisibility(8);
          break;
        }
        ad.e("MicroMsg.RemittanceBusiResultUI", "qry response: %s, %s", new Object[] { Integer.valueOf(((f)localObject).xXL.ozR), ((f)localObject).xXL.ozS });
        Toast.makeText(this, ((f)localObject).xXL.ozS, 1).show();
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