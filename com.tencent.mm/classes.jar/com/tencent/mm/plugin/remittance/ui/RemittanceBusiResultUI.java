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
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.aaa;
import com.tencent.mm.plugin.remittance.model.BusiRemittanceResp;
import com.tencent.mm.plugin.remittance.model.i;
import com.tencent.mm.plugin.remittance.model.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget;
import com.tencent.mm.plugin.wallet_core.utils.g;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.du;
import com.tencent.mm.protocal.protobuf.ra;
import com.tencent.mm.protocal.protobuf.rb;
import com.tencent.mm.protocal.protobuf.rk;
import com.tencent.mm.protocal.protobuf.sh;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.tools.p;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import e.a.a.c;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(19)
public class RemittanceBusiResultUI
  extends WalletBaseUI
{
  private String AJn;
  private int Cof;
  private String Cog;
  private String CqN;
  private TextView CrY;
  private TextView CrZ;
  private String Crs;
  private rb CsA;
  private boolean CsB;
  private Runnable CsC;
  private du CsD;
  private int CsE;
  private c CsF;
  private WalletSuccPageAwardWidget CsG;
  private ViewGroup CsH;
  private ViewGroup CsI;
  private ViewGroup CsJ;
  private TextView CsK;
  private boolean CsL;
  private IListener<aaa> CsM;
  private boolean CsN;
  private Runnable CsO;
  private TextView Csa;
  private TextView Csb;
  private CdnImageView Csc;
  private TextView Csd;
  private TextView Cse;
  private Button Csf;
  private ViewGroup Csg;
  private ViewGroup Csh;
  private ViewGroup Csi;
  private ViewGroup Csj;
  private View Csk;
  private LinearLayout Csl;
  private String Csm;
  private String Csn;
  private String Cso;
  private double Csp;
  private String Csq;
  private String Csr;
  private String Css;
  private int Cst;
  private String Csu;
  private String Csv;
  private com.tencent.mm.bw.b Csw;
  private boolean Csx;
  private String Csy;
  private BusiRemittanceResp Csz;
  private String app_id;
  private int mChannel;
  private TextView mPa;
  private Button nAa;
  private int rxM;
  
  public RemittanceBusiResultUI()
  {
    AppMethodBeat.i(67998);
    this.Csx = false;
    this.CsB = false;
    this.CsC = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(67990);
        RemittanceBusiResultUI.a(RemittanceBusiResultUI.this);
        j localj = new j(RemittanceBusiResultUI.b(RemittanceBusiResultUI.this), RemittanceBusiResultUI.c(RemittanceBusiResultUI.this), RemittanceBusiResultUI.d(RemittanceBusiResultUI.this).cSx, RemittanceBusiResultUI.e(RemittanceBusiResultUI.this) - 1, System.currentTimeMillis());
        RemittanceBusiResultUI.this.doSceneProgress(localj);
        RemittanceBusiResultUI.f(RemittanceBusiResultUI.this);
        AppMethodBeat.o(67990);
      }
    };
    this.CsD = new du();
    this.CsL = false;
    this.CsM = new IListener() {};
    this.CsN = true;
    this.CsO = new Runnable()
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
    this.CsI.setVisibility(8);
    this.CsH.setVisibility(8);
    this.CsJ.setVisibility(8);
    TextView localTextView = (TextView)findViewById(2131309362);
    final View localView = findViewById(2131309363);
    LinkedList localLinkedList;
    int i;
    Object localObject2;
    int j;
    Object localObject1;
    if ((paramj != null) && (paramj.CoE != null) && (paramj.CoE.KYR.size() > 0))
    {
      localLinkedList = paramj.CoE.KYR;
      if (localLinkedList != null)
      {
        i = localLinkedList.size();
        Log.i("MicroMsg.RemittanceBusiResultUI", "discountInfoList: %s, size: %s received_amount: %s", new Object[] { localLinkedList, Integer.valueOf(i), Long.valueOf(paramj.CoE.KYQ) });
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
        this.CsI.removeAllViews();
        this.CsH.setOnClickListener(null);
        if (j <= 1) {
          break label505;
        }
        paramj = paramj.CoE.KYU;
        this.CsN = true;
        localView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(67995);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceBusiResultUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
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
        this.CsH.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(67996);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceBusiResultUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
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
            ((TextView)localObject2).setTextColor(getResources().getColor(2131099792));
            ((TextView)localObject2).setText((CharSequence)localObject1);
            this.CsI.addView((View)localObject2);
            i += 1;
            continue;
            i = 0;
            break;
          }
        }
        this.CsI.setVisibility(0);
        this.CsH.setVisibility(0);
        localObject1 = paramj;
        label401:
        if (this.CsN)
        {
          localView.setVisibility(0);
          paramj = Util.nullAs((String)localObject1, "");
          paramj = new SpannableString(paramj + " ");
          if (j <= 1) {
            break label487;
          }
          findViewById(2131309364).setVisibility(0);
        }
        for (;;)
        {
          localTextView.setText(paramj);
          this.CsH.setVisibility(8);
          AppMethodBeat.o(68008);
          return;
          label487:
          findViewById(2131309364).setVisibility(8);
        }
      }
      label505:
      paramj = "";
    }
  }
  
  private void b(j paramj)
  {
    AppMethodBeat.i(68010);
    this.Csl.removeAllViews();
    Object localObject1;
    if ((this.Csz != null) && (!Util.isNullOrNil(this.Csz.Coq))) {
      localObject1 = this.Csz.Coq;
    }
    label569:
    label586:
    for (;;)
    {
      Object localObject2;
      if ((eM(this.Csg)) && (eM(this.Csh)) && (eM(this.CsJ)) && (eM(this.Csi)) && (eM(this.Csj)) && (!WalletSuccPageAwardWidget.a(this.CsF)) && (eM(findViewById(2131309363))) && (eM(this.CsH)))
      {
        localObject2 = (ViewGroup)getLayoutInflater().inflate(2131494059, this.Csl, false);
        this.Csl.addView((View)localObject2);
        paramj = (CdnImageView)((ViewGroup)localObject2).findViewById(2131306862);
        localObject2 = (TextView)((ViewGroup)localObject2).findViewById(2131306531);
        if (!Util.isNullOrNil(this.Cog))
        {
          if (this.CsE == 1) {
            paramj.setRoundCorner(true);
          }
          paramj.setUrl(this.Cog);
          label203:
          ((TextView)localObject2).setText((CharSequence)localObject1);
        }
      }
      for (;;)
      {
        eNY();
        AppMethodBeat.o(68010);
        return;
        if (!Util.isNullOrNil(this.CqN))
        {
          localObject2 = com.tencent.mm.wallet_core.ui.f.hs(this.CqN, 6);
          localObject1 = localObject2;
          if (Util.isNullOrNil(this.Csy)) {
            break label586;
          }
          localObject1 = getString(2131764504, new Object[] { localObject2, this.Csy });
          break;
        }
        localObject2 = com.tencent.mm.wallet_core.ui.f.hs(com.tencent.mm.wallet_core.ui.f.getDisplayName(this.Cso), 6);
        localObject1 = localObject2;
        if (Util.isNullOrNil(this.Csy)) {
          break label586;
        }
        localObject1 = getString(2131764504, new Object[] { localObject2, this.Csy });
        break;
        if (this.CsE == 1)
        {
          a.b.d(paramj, this.Cso);
          break label203;
        }
        a.b.c(paramj, this.Cso);
        break label203;
        localObject2 = (ViewGroup)getLayoutInflater().inflate(2131496096, this.Csl, false);
        this.Csl.addView((View)localObject2);
        localObject2 = (CdnImageView)findViewById(2131306862);
        TextView localTextView1 = (TextView)findViewById(2131306531);
        View localView = findViewById(2131303091);
        TextView localTextView2 = (TextView)findViewById(2131306530);
        localTextView1.setText(l.c(this, (CharSequence)localObject1));
        ((CdnImageView)localObject2).setVisibility(0);
        if (!Util.isNullOrNil(this.Cog))
        {
          if (this.CsE == 1) {
            ((CdnImageView)localObject2).setRoundCorner(true);
          }
          ((CdnImageView)localObject2).setUrl(this.Cog);
        }
        for (;;)
        {
          localView.setVisibility(8);
          localTextView2.setVisibility(8);
          if (paramj == null) {
            break;
          }
          if (paramj.CoE.KYT != 1) {
            break label569;
          }
          localView.setVisibility(0);
          localTextView2.setVisibility(0);
          localTextView2.setText(com.tencent.mm.wallet_core.ui.f.D(paramj.CoE.KYQ / 100.0D));
          break;
          if (this.CsE == 1) {
            a.b.d((ImageView)localObject2, this.Cso);
          } else {
            a.b.c((ImageView)localObject2, this.Cso);
          }
        }
        localView.setVisibility(8);
        localTextView2.setVisibility(8);
      }
    }
  }
  
  private static boolean eM(View paramView)
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
  
  private void eNY()
  {
    AppMethodBeat.i(68009);
    p.a(this, (ScrollView)findViewById(2131307343), findViewById(2131297891), findViewById(2131296752), findViewById(2131297682), 32, 0.0F, true);
    AppMethodBeat.o(68009);
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
    Log.i("MicroMsg.RemittanceBusiResultUI", "finish this %s %s", new Object[] { this, Util.getStack() });
    if (this.CsL)
    {
      AppMethodBeat.o(67999);
      return;
    }
    super.finish();
    this.CsL = true;
    AppMethodBeat.o(67999);
  }
  
  public int getLayoutId()
  {
    return 2131496097;
  }
  
  public void initView()
  {
    AppMethodBeat.i(68002);
    this.mPa = ((TextView)findViewById(2131306532));
    this.CrY = ((TextView)findViewById(2131306523));
    this.CrZ = ((TextView)findViewById(2131306529));
    this.Csa = ((TextView)findViewById(2131306525));
    this.Csb = ((TextView)findViewById(2131306527));
    this.Csg = ((LinearLayout)findViewById(2131306528));
    this.Csh = ((LinearLayout)findViewById(2131306524));
    this.Csi = ((LinearLayout)findViewById(2131306526));
    this.Csc = ((CdnImageView)findViewById(2131306519));
    this.Csd = ((TextView)findViewById(2131306521));
    this.Cse = ((TextView)findViewById(2131306520));
    this.Csf = ((Button)findViewById(2131306517));
    this.Csj = ((ViewGroup)findViewById(2131306518));
    this.nAa = ((Button)findViewById(2131306522));
    this.Csk = findViewById(2131307914);
    this.Csl = ((LinearLayout)findViewById(2131306851));
    this.CrY.setText(com.tencent.mm.wallet_core.ui.f.formatMoney2f(this.Csp));
    MMHandlerThread.postToMainThreadDelayed(this.CsO, 500L);
    if (!Util.isNullOrNil(this.Csm))
    {
      this.CrZ.setText(this.Csm);
      this.Csg.setVisibility(0);
      if (Util.isNullOrNil(this.Csn)) {
        break label413;
      }
      this.Csa.setText(this.Csn);
      this.Csh.setVisibility(0);
    }
    for (;;)
    {
      this.nAa.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67992);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceBusiResultUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (RemittanceBusiResultUI.g(RemittanceBusiResultUI.this) == 56) {
            h.CyF.a(19821, new Object[] { Integer.valueOf(10), RemittanceBusiResultUI.h(RemittanceBusiResultUI.this), Integer.valueOf(0) });
          }
          RemittanceBusiResultUI.this.finish();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceBusiResultUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(67992);
        }
      });
      this.CsG = ((WalletSuccPageAwardWidget)findViewById(2131297151));
      this.CsH = ((ViewGroup)findViewById(2131299670));
      this.CsI = ((ViewGroup)findViewById(2131299668));
      this.CsJ = ((ViewGroup)findViewById(2131305705));
      this.CsK = ((TextView)findViewById(2131305696));
      AppMethodBeat.o(68002);
      return;
      this.Csg.setVisibility(8);
      break;
      label413:
      this.Csh.setVisibility(8);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(68001);
    super.onCreate(paramBundle);
    addSceneEndListener(1537);
    addSceneEndListener(1680);
    addSceneEndListener(2504);
    this.CsM.alive();
    if (d.oD(21))
    {
      if (!d.oD(23)) {
        break label521;
      }
      getWindow().setStatusBarColor(getContext().getResources().getColor(2131101424));
    }
    for (;;)
    {
      if (getSupportActionBar() != null) {
        getSupportActionBar().hide();
      }
      setBackBtn(null);
      showHomeBtn(false);
      enableBackMenu(false);
      this.CqN = getIntent().getStringExtra("key_mch_name");
      this.Csz = ((BusiRemittanceResp)getIntent().getParcelableExtra("BusiRemittanceResp"));
      this.Csp = getIntent().getDoubleExtra("key_money", 0.0D);
      this.Cso = getIntent().getStringExtra("key_rcver_name");
      this.Csy = getIntent().getStringExtra("key_rcver_true_name");
      this.Csm = getIntent().getStringExtra("key_rcv_desc");
      this.Csn = getIntent().getStringExtra("key_pay_desc");
      this.Csq = getIntent().getStringExtra("key_f2f_id");
      this.AJn = getIntent().getStringExtra("key_trans_id");
      this.Crs = getIntent().getStringExtra("key_rcvr_open_id");
      this.Csv = getIntent().getStringExtra("key_check_sign");
      this.Csr = getIntent().getStringExtra("key_pay_desc");
      this.Css = getIntent().getStringExtra("key_rcv_desc");
      this.Cst = getIntent().getIntExtra("key_scan_sceen", 0);
      this.mChannel = getIntent().getIntExtra("key_channel", 0);
      this.Csu = getIntent().getStringExtra("key_succ_page_extend");
      paramBundle = getIntent().getByteArrayExtra("AfterPlaceOrderCommReq");
      this.CsA = i.aMc(getIntent().getStringExtra("key_succ_fault_config"));
      try
      {
        this.CsD.parseFrom(paramBundle);
        this.CsE = getIntent().getIntExtra("key_succ_show_avatar_type", 0);
        this.Cof = getIntent().getIntExtra("key_succ_show_avatar_show", 0);
        this.Cog = getIntent().getStringExtra("key_succ_show_avatar_url");
        this.app_id = getIntent().getStringExtra("app_id");
        this.Csx = false;
        Log.i("MicroMsg.RemittanceBusiResultUI", "fetch data");
        Log.i("MicroMsg.RemittanceBusiResultUI", "fetchData() mBusiF2FFaultConfig.flag:%s mBusiF2FFaultConfig.succpage_first_delay_ms:%s", new Object[] { Integer.valueOf(this.CsA.cSx), Integer.valueOf(this.CsA.KXU) });
        if (Util.isEqual(this.CsA.cSx, 1))
        {
          MMHandlerThread.postToMainThreadDelayed(this.CsC, this.CsA.KXU);
          initView();
          AppMethodBeat.o(68001);
          return;
          label521:
          getWindow().setStatusBarColor(getContext().getResources().getColor(2131099689));
        }
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.RemittanceBusiResultUI", paramBundle, "", new Object[0]);
          continue;
          doSceneProgress(new j(this.CsD, this.Csu));
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
    this.CsM.dead();
    if (this.CsF != null) {
      this.CsG.onDestroy();
    }
    MMHandlerThread.removeRunnable(this.CsO);
    AppMethodBeat.o(68006);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(68005);
    super.onResume();
    if (this.Csx)
    {
      Log.i("MicroMsg.RemittanceBusiResultUI", "do act qry");
      int i = (int)Math.round(this.Csp * 100.0D);
      doSceneProgress(new com.tencent.mm.plugin.remittance.model.f(this.Csq, this.AJn, this.Crs, i, this.Csw, this.Csv), false);
      this.Csx = false;
    }
    if (this.CsF != null) {
      this.CsG.onResume();
    }
    AppMethodBeat.o(68005);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(68003);
    Log.i("MicroMsg.RemittanceBusiResultUI", "errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scenetype:" + paramq.getType());
    Object localObject;
    if ((paramq instanceof j))
    {
      localObject = (j)paramq;
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        if (this.CsB)
        {
          Log.i("MicroMsg.RemittanceBusiResultUI", "NetSceneBusiF2fSucpage success(mIfSuccNetSceneBusiF2fSucpage:%s)", new Object[] { Boolean.valueOf(this.CsB) });
          if (this.CsF == null) {
            break label809;
          }
        }
      }
    }
    label809:
    for (boolean bool = this.CsG.onSceneEnd(paramInt1, paramInt2, paramString, paramq);; bool = false)
    {
      this.Csk.setVisibility(8);
      AppMethodBeat.o(68003);
      return bool;
      if (((j)localObject).CoE.pTZ == 0)
      {
        this.CsB = true;
        MMHandlerThread.removeRunnable(this.CsC);
        Log.i("MicroMsg.RemittanceBusiResultUI", "exposure info: %s", new Object[] { ((j)localObject).CoE.Iah });
        this.CsF = ((j)localObject).CoE.Iah;
        if (WalletSuccPageAwardWidget.a(this.CsF))
        {
          Log.i("MicroMsg.RemittanceBusiResultUI", "setAwardWidget, mTransId: %s", new Object[] { this.AJn });
          this.CsG.a(this, this.CsF, this.AJn, true, (ImageView)findViewById(2131297171));
          this.CsG.init();
          this.CsG.setVisibility(0);
          ImageView localImageView = (ImageView)findViewById(2131297171);
          localImageView.post(new RemittanceBusiResultUI.4(this, localImageView, (ViewGroup)findViewById(2131307343)));
          eNY();
          label324:
          a((j)localObject);
          MMHandlerThread.removeRunnable(this.CsO);
          if (Util.isNullOrNil(((j)localObject).CoE.KYV)) {
            break label448;
          }
          if (!Util.isNullOrNil(((j)localObject).CoE.KYW)) {
            break label426;
          }
          this.Csb.setTextColor(getResources().getColor(2131100900));
          label382:
          this.Csb.setText(((j)localObject).CoE.KYV);
          this.Csi.setVisibility(0);
        }
        for (;;)
        {
          b((j)localObject);
          break;
          this.CsG.setVisibility(8);
          break label324;
          label426:
          this.Csb.setTextColor(g.cI(((j)localObject).CoE.KYW, true));
          break label382;
          label448:
          this.Csi.setVisibility(8);
        }
      }
      Log.e("MicroMsg.RemittanceBusiResultUI", "result response: %s, %s, %s", new Object[] { Integer.valueOf(((j)localObject).CoE.pTZ), ((j)localObject).CoE.pUa, Boolean.valueOf(((j)localObject).CoE.KYX) });
      if (((j)localObject).CoE.KYX) {
        break;
      }
      this.CsB = true;
      MMHandlerThread.removeRunnable(this.CsC);
      break;
      Log.e("MicroMsg.RemittanceBusiResultUI", "net error: %s", new Object[] { localObject });
      break;
      if (!(paramq instanceof com.tencent.mm.plugin.remittance.model.f)) {
        break;
      }
      localObject = (com.tencent.mm.plugin.remittance.model.f)paramq;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (((com.tencent.mm.plugin.remittance.model.f)localObject).Cot.pTZ == 0)
        {
          localObject = ((com.tencent.mm.plugin.remittance.model.f)localObject).Cot.KXT;
          if (localObject != null)
          {
            this.Csc.setUrl(((sh)localObject).icon);
            this.Csd.setText(((sh)localObject).title);
            this.Cse.setText(((sh)localObject).HYG);
            this.Csf.setText(((sh)localObject).IhY);
            this.Csf.setOnClickListener(new RemittanceBusiResultUI.5(this, (sh)localObject));
            this.Csf.setBackgroundResource(2131234651);
            this.Csf.setTextColor(getResources().getColor(2131101428));
            this.Csj.setVisibility(0);
            eNY();
            break;
          }
          Log.i("MicroMsg.RemittanceBusiResultUI", "app info is null");
          this.Csj.setVisibility(8);
          break;
        }
        Log.e("MicroMsg.RemittanceBusiResultUI", "qry response: %s, %s", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.remittance.model.f)localObject).Cot.pTZ), ((com.tencent.mm.plugin.remittance.model.f)localObject).Cot.pUa });
        Toast.makeText(this, ((com.tencent.mm.plugin.remittance.model.f)localObject).Cot.pUa, 1).show();
        break;
      }
      Log.e("MicroMsg.RemittanceBusiResultUI", "net error: %s", new Object[] { localObject });
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