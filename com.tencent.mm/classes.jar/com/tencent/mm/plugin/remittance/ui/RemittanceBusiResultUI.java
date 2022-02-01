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
import com.tencent.mm.bw.b;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.xv;
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
import com.tencent.mm.protocal.protobuf.dj;
import com.tencent.mm.protocal.protobuf.os;
import com.tencent.mm.protocal.protobuf.ot;
import com.tencent.mm.protocal.protobuf.pc;
import com.tencent.mm.protocal.protobuf.py;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
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
  private Button lKB;
  private TextView lfN;
  private int mChannel;
  private int pwG;
  private String vsE;
  private int wJQ;
  private String wJR;
  private String wMx;
  private TextView wNI;
  private TextView wNJ;
  private TextView wNK;
  private TextView wNL;
  private CdnImageView wNM;
  private TextView wNN;
  private TextView wNO;
  private Button wNP;
  private ViewGroup wNQ;
  private ViewGroup wNR;
  private ViewGroup wNS;
  private ViewGroup wNT;
  private View wNU;
  private LinearLayout wNV;
  private String wNW;
  private String wNX;
  private String wNY;
  private double wNZ;
  private String wNc;
  private String wOa;
  private String wOb;
  private String wOc;
  private int wOd;
  private String wOe;
  private String wOf;
  private b wOg;
  private boolean wOh;
  private String wOi;
  private BusiRemittanceResp wOj;
  private ot wOk;
  private boolean wOl;
  private Runnable wOm;
  private dj wOn;
  private int wOo;
  private e.a.a.c wOp;
  private WalletSuccPageAwardWidget wOq;
  private ViewGroup wOr;
  private ViewGroup wOs;
  private ViewGroup wOt;
  private TextView wOu;
  private boolean wOv;
  private com.tencent.mm.sdk.b.c<xv> wOw;
  private boolean wOx;
  private Runnable wOy;
  
  public RemittanceBusiResultUI()
  {
    AppMethodBeat.i(67998);
    this.wOh = false;
    this.wOl = false;
    this.wOm = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(67990);
        RemittanceBusiResultUI.a(RemittanceBusiResultUI.this);
        j localj = new j(RemittanceBusiResultUI.b(RemittanceBusiResultUI.this), RemittanceBusiResultUI.c(RemittanceBusiResultUI.this), RemittanceBusiResultUI.d(RemittanceBusiResultUI.this).drx, RemittanceBusiResultUI.e(RemittanceBusiResultUI.this) - 1, System.currentTimeMillis());
        RemittanceBusiResultUI.this.doSceneProgress(localj);
        RemittanceBusiResultUI.f(RemittanceBusiResultUI.this);
        AppMethodBeat.o(67990);
      }
    };
    this.wOn = new dj();
    this.wOv = false;
    this.wOw = new com.tencent.mm.sdk.b.c() {};
    this.wOx = true;
    this.wOy = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(67997);
        RemittanceBusiResultUI.n(RemittanceBusiResultUI.this);
        AppMethodBeat.o(67997);
      }
    };
    AppMethodBeat.o(67998);
  }
  
  private void a(j paramj)
  {
    AppMethodBeat.i(68008);
    this.wOs.setVisibility(8);
    this.wOr.setVisibility(8);
    this.wOt.setVisibility(8);
    TextView localTextView = (TextView)findViewById(2131306040);
    final View localView = findViewById(2131306041);
    LinkedList localLinkedList;
    int i;
    Object localObject2;
    int j;
    Object localObject1;
    if ((paramj != null) && (paramj.wKp != null) && (paramj.wKp.EfC.size() > 0))
    {
      localLinkedList = paramj.wKp.EfC;
      if (localLinkedList != null)
      {
        i = localLinkedList.size();
        ac.i("MicroMsg.RemittanceBusiResultUI", "discountInfoList: %s, size: %s received_amount: %s", new Object[] { localLinkedList, Integer.valueOf(i), Long.valueOf(paramj.wKp.EfB) });
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
        this.wOs.removeAllViews();
        this.wOr.setOnClickListener(null);
        if (j <= 1) {
          break label505;
        }
        paramj = paramj.wKp.EfF;
        this.wOx = true;
        localView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            boolean bool = false;
            AppMethodBeat.i(67995);
            if (RemittanceBusiResultUI.j(RemittanceBusiResultUI.this))
            {
              localView.setVisibility(8);
              RemittanceBusiResultUI.k(RemittanceBusiResultUI.this).setVisibility(0);
              paramAnonymousView = RemittanceBusiResultUI.this;
              RemittanceBusiResultUI.l(RemittanceBusiResultUI.this);
              RemittanceBusiResultUI.m(paramAnonymousView);
            }
            for (;;)
            {
              paramAnonymousView = RemittanceBusiResultUI.this;
              if (!RemittanceBusiResultUI.j(RemittanceBusiResultUI.this)) {
                bool = true;
              }
              RemittanceBusiResultUI.a(paramAnonymousView, bool);
              AppMethodBeat.o(67995);
              return;
              localView.setVisibility(0);
              RemittanceBusiResultUI.k(RemittanceBusiResultUI.this).setVisibility(8);
              RemittanceBusiResultUI.m(RemittanceBusiResultUI.this);
            }
          }
        });
        this.wOr.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            boolean bool = false;
            AppMethodBeat.i(67996);
            if (RemittanceBusiResultUI.j(RemittanceBusiResultUI.this))
            {
              localView.setVisibility(8);
              RemittanceBusiResultUI.k(RemittanceBusiResultUI.this).setVisibility(0);
              paramAnonymousView = RemittanceBusiResultUI.this;
              RemittanceBusiResultUI.l(RemittanceBusiResultUI.this);
              RemittanceBusiResultUI.m(paramAnonymousView);
            }
            for (;;)
            {
              paramAnonymousView = RemittanceBusiResultUI.this;
              if (!RemittanceBusiResultUI.j(RemittanceBusiResultUI.this)) {
                bool = true;
              }
              RemittanceBusiResultUI.a(paramAnonymousView, bool);
              AppMethodBeat.o(67996);
              return;
              localView.setVisibility(0);
              RemittanceBusiResultUI.k(RemittanceBusiResultUI.this).setVisibility(8);
              RemittanceBusiResultUI.m(RemittanceBusiResultUI.this);
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
            this.wOs.addView((View)localObject2);
            i += 1;
            continue;
            i = 0;
            break;
          }
        }
        this.wOs.setVisibility(0);
        this.wOr.setVisibility(0);
        localObject1 = paramj;
        label401:
        if (this.wOx)
        {
          localView.setVisibility(0);
          paramj = bs.bG((String)localObject1, "");
          paramj = new SpannableString(paramj + " ");
          if (j <= 1) {
            break label487;
          }
          findViewById(2131306042).setVisibility(0);
        }
        for (;;)
        {
          localTextView.setText(paramj);
          this.wOr.setVisibility(8);
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
    this.wNV.removeAllViews();
    Object localObject1;
    if ((this.wOj != null) && (!bs.isNullOrNil(this.wOj.wKb))) {
      localObject1 = this.wOj.wKb;
    }
    label569:
    label586:
    for (;;)
    {
      Object localObject2;
      if ((es(this.wNQ)) && (es(this.wNR)) && (es(this.wOt)) && (es(this.wNS)) && (es(this.wNT)) && (!WalletSuccPageAwardWidget.a(this.wOp)) && (es(findViewById(2131306041))) && (es(this.wOr)))
      {
        localObject2 = (ViewGroup)getLayoutInflater().inflate(2131493902, this.wNV, false);
        this.wNV.addView((View)localObject2);
        paramj = (CdnImageView)((ViewGroup)localObject2).findViewById(2131304006);
        localObject2 = (TextView)((ViewGroup)localObject2).findViewById(2131303742);
        if (!bs.isNullOrNil(this.wJR))
        {
          if (this.wOo == 1) {
            paramj.setRoundCorner(true);
          }
          paramj.setUrl(this.wJR);
          label203:
          ((TextView)localObject2).setText((CharSequence)localObject1);
        }
      }
      for (;;)
      {
        dyo();
        AppMethodBeat.o(68010);
        return;
        if (!bs.isNullOrNil(this.wMx))
        {
          localObject2 = e.gr(this.wMx, 6);
          localObject1 = localObject2;
          if (bs.isNullOrNil(this.wOi)) {
            break label586;
          }
          localObject1 = getString(2131762438, new Object[] { localObject2, this.wOi });
          break;
        }
        localObject2 = e.gr(e.wk(this.wNY), 6);
        localObject1 = localObject2;
        if (bs.isNullOrNil(this.wOi)) {
          break label586;
        }
        localObject1 = getString(2131762438, new Object[] { localObject2, this.wOi });
        break;
        if (this.wOo == 1)
        {
          a.b.d(paramj, this.wNY);
          break label203;
        }
        a.b.c(paramj, this.wNY);
        break label203;
        localObject2 = (ViewGroup)getLayoutInflater().inflate(2131495250, this.wNV, false);
        this.wNV.addView((View)localObject2);
        localObject2 = (CdnImageView)findViewById(2131304006);
        TextView localTextView1 = (TextView)findViewById(2131303742);
        View localView = findViewById(2131301357);
        TextView localTextView2 = (TextView)findViewById(2131303741);
        localTextView1.setText(k.c(this, (CharSequence)localObject1));
        ((CdnImageView)localObject2).setVisibility(0);
        if (!bs.isNullOrNil(this.wJR))
        {
          if (this.wOo == 1) {
            ((CdnImageView)localObject2).setRoundCorner(true);
          }
          ((CdnImageView)localObject2).setUrl(this.wJR);
        }
        for (;;)
        {
          localView.setVisibility(8);
          localTextView2.setVisibility(8);
          if (paramj == null) {
            break;
          }
          if (paramj.wKp.EfE != 1) {
            break label569;
          }
          localView.setVisibility(0);
          localTextView2.setVisibility(0);
          localTextView2.setText(e.D(paramj.wKp.EfB / 100.0D));
          break;
          if (this.wOo == 1) {
            a.b.d((ImageView)localObject2, this.wNY);
          } else {
            a.b.c((ImageView)localObject2, this.wNY);
          }
        }
        localView.setVisibility(8);
        localTextView2.setVisibility(8);
      }
    }
  }
  
  private void dyo()
  {
    AppMethodBeat.i(68009);
    p.a(this, (ScrollView)findViewById(2131304380), findViewById(2131297629), findViewById(2131296668), findViewById(2131297452), 32, 0.0F, true);
    AppMethodBeat.o(68009);
  }
  
  private static boolean es(View paramView)
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
    ac.i("MicroMsg.RemittanceBusiResultUI", "finish this %s %s", new Object[] { this, bs.eWi() });
    if (this.wOv)
    {
      AppMethodBeat.o(67999);
      return;
    }
    super.finish();
    this.wOv = true;
    AppMethodBeat.o(67999);
  }
  
  public int getLayoutId()
  {
    return 2131495251;
  }
  
  public void initView()
  {
    AppMethodBeat.i(68002);
    this.lfN = ((TextView)findViewById(2131303743));
    this.wNI = ((TextView)findViewById(2131303734));
    this.wNJ = ((TextView)findViewById(2131303740));
    this.wNK = ((TextView)findViewById(2131303736));
    this.wNL = ((TextView)findViewById(2131303738));
    this.wNQ = ((LinearLayout)findViewById(2131303739));
    this.wNR = ((LinearLayout)findViewById(2131303735));
    this.wNS = ((LinearLayout)findViewById(2131303737));
    this.wNM = ((CdnImageView)findViewById(2131303730));
    this.wNN = ((TextView)findViewById(2131303732));
    this.wNO = ((TextView)findViewById(2131303731));
    this.wNP = ((Button)findViewById(2131303728));
    this.wNT = ((ViewGroup)findViewById(2131303729));
    this.lKB = ((Button)findViewById(2131303733));
    this.wNU = findViewById(2131304828);
    this.wNV = ((LinearLayout)findViewById(2131303995));
    this.wNI.setText(e.C(this.wNZ));
    ap.n(this.wOy, 500L);
    if (!bs.isNullOrNil(this.wNW))
    {
      this.wNJ.setText(this.wNW);
      this.wNQ.setVisibility(0);
      if (bs.isNullOrNil(this.wNX)) {
        break label413;
      }
      this.wNK.setText(this.wNX);
      this.wNR.setVisibility(0);
    }
    for (;;)
    {
      this.lKB.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67992);
          if (RemittanceBusiResultUI.g(RemittanceBusiResultUI.this) == 56) {
            h.wUl.f(19821, new Object[] { Integer.valueOf(10), RemittanceBusiResultUI.h(RemittanceBusiResultUI.this), Integer.valueOf(0) });
          }
          RemittanceBusiResultUI.this.finish();
          AppMethodBeat.o(67992);
        }
      });
      this.wOq = ((WalletSuccPageAwardWidget)findViewById(2131297022));
      this.wOr = ((ViewGroup)findViewById(2131299143));
      this.wOs = ((ViewGroup)findViewById(2131299141));
      this.wOt = ((ViewGroup)findViewById(2131303089));
      this.wOu = ((TextView)findViewById(2131303088));
      AppMethodBeat.o(68002);
      return;
      this.wNQ.setVisibility(8);
      break;
      label413:
      this.wNR.setVisibility(8);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(68001);
    super.onCreate(paramBundle);
    addSceneEndListener(1537);
    addSceneEndListener(1680);
    addSceneEndListener(2504);
    this.wOw.alive();
    if (d.kZ(21))
    {
      if (!d.kZ(23)) {
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
      this.wMx = getIntent().getStringExtra("key_mch_name");
      this.wOj = ((BusiRemittanceResp)getIntent().getParcelableExtra("BusiRemittanceResp"));
      this.wNZ = getIntent().getDoubleExtra("key_money", 0.0D);
      this.wNY = getIntent().getStringExtra("key_rcver_name");
      this.wOi = getIntent().getStringExtra("key_rcver_true_name");
      this.wNW = getIntent().getStringExtra("key_rcv_desc");
      this.wNX = getIntent().getStringExtra("key_pay_desc");
      this.wOa = getIntent().getStringExtra("key_f2f_id");
      this.vsE = getIntent().getStringExtra("key_trans_id");
      this.wNc = getIntent().getStringExtra("key_rcvr_open_id");
      this.wOf = getIntent().getStringExtra("key_check_sign");
      this.wOb = getIntent().getStringExtra("key_pay_desc");
      this.wOc = getIntent().getStringExtra("key_rcv_desc");
      this.wOd = getIntent().getIntExtra("key_scan_sceen", 0);
      this.mChannel = getIntent().getIntExtra("key_channel", 0);
      this.wOe = getIntent().getStringExtra("key_succ_page_extend");
      paramBundle = getIntent().getByteArrayExtra("AfterPlaceOrderCommReq");
      this.wOk = i.arn(getIntent().getStringExtra("key_succ_fault_config"));
      try
      {
        this.wOn.parseFrom(paramBundle);
        this.wOo = getIntent().getIntExtra("key_succ_show_avatar_type", 0);
        this.wJQ = getIntent().getIntExtra("key_succ_show_avatar_show", 0);
        this.wJR = getIntent().getStringExtra("key_succ_show_avatar_url");
        this.app_id = getIntent().getStringExtra("app_id");
        this.wOh = false;
        ac.i("MicroMsg.RemittanceBusiResultUI", "fetch data");
        ac.i("MicroMsg.RemittanceBusiResultUI", "fetchData() mBusiF2FFaultConfig.flag:%s mBusiF2FFaultConfig.succpage_first_delay_ms:%s", new Object[] { Integer.valueOf(this.wOk.drx), Integer.valueOf(this.wOk.EeF) });
        if (bs.jl(this.wOk.drx, 1))
        {
          ap.n(this.wOm, this.wOk.EeF);
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
          ac.printErrStackTrace("MicroMsg.RemittanceBusiResultUI", paramBundle, "", new Object[0]);
          continue;
          doSceneProgress(new j(this.wOn, this.wOe));
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
    this.wOw.dead();
    if (this.wOp != null) {
      this.wOq.onDestroy();
    }
    ap.aB(this.wOy);
    AppMethodBeat.o(68006);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(68005);
    super.onResume();
    if (this.wOh)
    {
      ac.i("MicroMsg.RemittanceBusiResultUI", "do act qry");
      int i = (int)Math.round(this.wNZ * 100.0D);
      doSceneProgress(new f(this.wOa, this.vsE, this.wNc, i, this.wOg, this.wOf), false);
      this.wOh = false;
    }
    if (this.wOp != null) {
      this.wOq.onResume();
    }
    AppMethodBeat.o(68005);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(68003);
    ac.i("MicroMsg.RemittanceBusiResultUI", "errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scenetype:" + paramn.getType());
    Object localObject;
    if ((paramn instanceof j))
    {
      localObject = (j)paramn;
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        if (this.wOl)
        {
          ac.i("MicroMsg.RemittanceBusiResultUI", "NetSceneBusiF2fSucpage success(mIfSuccNetSceneBusiF2fSucpage:%s)", new Object[] { Boolean.valueOf(this.wOl) });
          if (this.wOp == null) {
            break label809;
          }
        }
      }
    }
    label809:
    for (boolean bool = this.wOq.onSceneEnd(paramInt1, paramInt2, paramString, paramn);; bool = false)
    {
      this.wNU.setVisibility(8);
      AppMethodBeat.o(68003);
      return bool;
      if (((j)localObject).wKp.nWx == 0)
      {
        this.wOl = true;
        ap.aB(this.wOm);
        ac.i("MicroMsg.RemittanceBusiResultUI", "exposure info: %s", new Object[] { ((j)localObject).wKp.ByX });
        this.wOp = ((j)localObject).wKp.ByX;
        if (WalletSuccPageAwardWidget.a(this.wOp))
        {
          ac.i("MicroMsg.RemittanceBusiResultUI", "setAwardWidget, mTransId: %s", new Object[] { this.vsE });
          this.wOq.a(this, this.wOp, this.vsE, true, (ImageView)findViewById(2131297029));
          this.wOq.init();
          this.wOq.setVisibility(0);
          ImageView localImageView = (ImageView)findViewById(2131297029);
          localImageView.post(new RemittanceBusiResultUI.4(this, localImageView, (ViewGroup)findViewById(2131304380)));
          dyo();
          label324:
          a((j)localObject);
          ap.aB(this.wOy);
          if (bs.isNullOrNil(((j)localObject).wKp.EfG)) {
            break label448;
          }
          if (!bs.isNullOrNil(((j)localObject).wKp.EfH)) {
            break label426;
          }
          this.wNL.setTextColor(getResources().getColor(2131100707));
          label382:
          this.wNL.setText(((j)localObject).wKp.EfG);
          this.wNS.setVisibility(0);
        }
        for (;;)
        {
          b((j)localObject);
          break;
          this.wOq.setVisibility(8);
          break label324;
          label426:
          this.wNL.setTextColor(g.cd(((j)localObject).wKp.EfH, true));
          break label382;
          label448:
          this.wNS.setVisibility(8);
        }
      }
      ac.e("MicroMsg.RemittanceBusiResultUI", "result response: %s, %s, %s", new Object[] { Integer.valueOf(((j)localObject).wKp.nWx), ((j)localObject).wKp.nWy, Boolean.valueOf(((j)localObject).wKp.EfI) });
      if (((j)localObject).wKp.EfI) {
        break;
      }
      this.wOl = true;
      ap.aB(this.wOm);
      break;
      ac.e("MicroMsg.RemittanceBusiResultUI", "net error: %s", new Object[] { localObject });
      break;
      if (!(paramn instanceof f)) {
        break;
      }
      localObject = (f)paramn;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (((f)localObject).wKe.nWx == 0)
        {
          localObject = ((f)localObject).wKe.EeE;
          if (localObject != null)
          {
            this.wNM.setUrl(((py)localObject).drM);
            this.wNN.setText(((py)localObject).title);
            this.wNO.setText(((py)localObject).Bxu);
            this.wNP.setText(((py)localObject).BGR);
            this.wNP.setOnClickListener(new RemittanceBusiResultUI.5(this, (py)localObject));
            this.wNP.setBackgroundResource(2131233827);
            this.wNP.setTextColor(getResources().getColor(2131101183));
            this.wNT.setVisibility(0);
            dyo();
            break;
          }
          ac.i("MicroMsg.RemittanceBusiResultUI", "app info is null");
          this.wNT.setVisibility(8);
          break;
        }
        ac.e("MicroMsg.RemittanceBusiResultUI", "qry response: %s, %s", new Object[] { Integer.valueOf(((f)localObject).wKe.nWx), ((f)localObject).wKe.nWy });
        Toast.makeText(this, ((f)localObject).wKe.nWy, 1).show();
        break;
      }
      ac.e("MicroMsg.RemittanceBusiResultUI", "net error: %s", new Object[] { localObject });
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