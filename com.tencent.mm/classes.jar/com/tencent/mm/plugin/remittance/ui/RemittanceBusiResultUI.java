package com.tencent.mm.plugin.remittance.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.bv.b;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.vk;
import com.tencent.mm.plugin.remittance.model.BusiRemittanceResp;
import com.tencent.mm.plugin.remittance.model.f;
import com.tencent.mm.plugin.remittance.model.i;
import com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.cz;
import com.tencent.mm.protocal.protobuf.mi;
import com.tencent.mm.protocal.protobuf.mj;
import com.tencent.mm.protocal.protobuf.ms;
import com.tencent.mm.protocal.protobuf.nm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(19)
public class RemittanceBusiResultUI
  extends WalletBaseUI
{
  private TextView iJG;
  private int lCJ;
  private int mChannel;
  private Button nJm;
  private String plc;
  private int qiM;
  private String qiN;
  private String qlP;
  private String qll;
  private TextView qmA;
  private TextView qmB;
  private Button qmC;
  private ViewGroup qmD;
  private ViewGroup qmE;
  private ViewGroup qmF;
  private ViewGroup qmG;
  private View qmH;
  private LinearLayout qmI;
  private String qmJ;
  private String qmK;
  private String qmL;
  private double qmM;
  private String qmN;
  private String qmO;
  private String qmP;
  private int qmQ;
  private String qmR;
  private String qmS;
  private b qmT;
  private boolean qmU;
  private String qmV;
  private BusiRemittanceResp qmW;
  private mj qmX;
  private boolean qmY;
  private Runnable qmZ;
  private TextView qmv;
  private TextView qmw;
  private TextView qmx;
  private TextView qmy;
  private CdnImageView qmz;
  private cz qna;
  private int qnb;
  private d.a.a.c qnc;
  private WalletSuccPageAwardWidget qnd;
  private ViewGroup qne;
  private ViewGroup qnf;
  private ViewGroup qng;
  private TextView qnh;
  private boolean qni;
  private com.tencent.mm.sdk.b.c<vk> qnj;
  private boolean qnk;
  private Runnable qnl;
  
  public RemittanceBusiResultUI()
  {
    AppMethodBeat.i(44877);
    this.qmU = false;
    this.qmY = false;
    this.qmZ = new RemittanceBusiResultUI.1(this);
    this.qna = new cz();
    this.qni = false;
    this.qnj = new com.tencent.mm.sdk.b.c() {};
    this.qnk = true;
    this.qnl = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(142169);
        RemittanceBusiResultUI.l(RemittanceBusiResultUI.this);
        AppMethodBeat.o(142169);
      }
    };
    AppMethodBeat.o(44877);
  }
  
  private void a(com.tencent.mm.plugin.remittance.model.j paramj)
  {
    AppMethodBeat.i(142170);
    this.qnf.setVisibility(8);
    this.qne.setVisibility(8);
    this.qng.setVisibility(8);
    TextView localTextView = (TextView)findViewById(2131827190);
    View localView = findViewById(2131827189);
    LinkedList localLinkedList;
    int i;
    Object localObject2;
    int j;
    Object localObject1;
    if ((paramj != null) && (paramj.qjl != null) && (paramj.qjl.wBH.size() > 0))
    {
      localLinkedList = paramj.qjl.wBH;
      if (localLinkedList != null)
      {
        i = localLinkedList.size();
        ab.i("MicroMsg.RemittanceBusiResultUI", "discountInfoList: %s, size: %s received_amount: %s", new Object[] { localLinkedList, Integer.valueOf(i), Long.valueOf(paramj.qjl.wBG) });
        localObject2 = "";
        j = localLinkedList.size();
        localObject1 = localObject2;
        if (localLinkedList == null) {
          break label397;
        }
        localObject1 = localObject2;
        if (localLinkedList.size() <= 0) {
          break label397;
        }
        this.qnf.removeAllViews();
        this.qne.setOnClickListener(null);
        if (j <= 1) {
          break label501;
        }
        paramj = paramj.qjl.wBK;
        this.qnk = true;
        localView.setOnClickListener(new RemittanceBusiResultUI.6(this, localView));
        this.qne.setOnClickListener(new RemittanceBusiResultUI.7(this, localView));
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
            ((TextView)localObject2).setTextColor(Color.parseColor("#FA962A"));
            ((TextView)localObject2).setText((CharSequence)localObject1);
            this.qnf.addView((View)localObject2);
            i += 1;
            continue;
            i = 0;
            break;
          }
        }
        this.qnf.setVisibility(0);
        this.qne.setVisibility(0);
        localObject1 = paramj;
        label397:
        if (this.qnk)
        {
          localView.setVisibility(0);
          paramj = bo.bf((String)localObject1, "");
          paramj = new SpannableString(paramj + " ");
          if (j <= 1) {
            break label483;
          }
          findViewById(2131827191).setVisibility(0);
        }
        for (;;)
        {
          localTextView.setText(paramj);
          this.qne.setVisibility(8);
          AppMethodBeat.o(142170);
          return;
          label483:
          findViewById(2131827191).setVisibility(8);
        }
      }
      label501:
      paramj = "";
    }
  }
  
  private void b(com.tencent.mm.plugin.remittance.model.j paramj)
  {
    AppMethodBeat.i(44889);
    this.qmI.removeAllViews();
    Object localObject2;
    Object localObject1;
    if (!bo.isNullOrNil(this.qll))
    {
      localObject2 = e.eZ(this.qll, 6);
      localObject1 = localObject2;
      if (bo.isNullOrNil(this.qmV)) {
        break label559;
      }
      localObject1 = getString(2131302534, new Object[] { localObject2, this.qmV });
    }
    label542:
    label559:
    for (;;)
    {
      if ((dx(this.qmD)) && (dx(this.qmE)) && (dx(this.qng)) && (dx(this.qmF)) && (dx(this.qmG)) && (!WalletSuccPageAwardWidget.a(this.qnc)) && (dx(findViewById(2131827189))) && (dx(this.qne)))
      {
        localObject2 = (ViewGroup)getLayoutInflater().inflate(2130969489, this.qmI, false);
        this.qmI.addView((View)localObject2);
        paramj = (CdnImageView)((ViewGroup)localObject2).findViewById(2131823856);
        localObject2 = (TextView)((ViewGroup)localObject2).findViewById(2131823857);
        if (!bo.isNullOrNil(this.qiN))
        {
          if (this.qnb == 1) {
            paramj.setRoundCorner(true);
          }
          paramj.setUrl(this.qiN);
          label230:
          ((TextView)localObject2).setText((CharSequence)localObject1);
        }
      }
      for (;;)
      {
        dy(this.qmI);
        AppMethodBeat.o(44889);
        return;
        localObject2 = e.eZ(e.nE(this.qmL), 6);
        localObject1 = localObject2;
        if (bo.isNullOrNil(this.qmV)) {
          break label559;
        }
        localObject1 = getString(2131302534, new Object[] { localObject2, this.qmV });
        break;
        if (this.qnb == 1)
        {
          a.b.s(paramj, this.qmL);
          break label230;
        }
        a.b.c(paramj, this.qmL);
        break label230;
        localObject2 = (ViewGroup)getLayoutInflater().inflate(2130970567, this.qmI, false);
        this.qmI.addView((View)localObject2);
        localObject2 = (CdnImageView)findViewById(2131823856);
        TextView localTextView1 = (TextView)findViewById(2131823857);
        View localView = findViewById(2131827183);
        TextView localTextView2 = (TextView)findViewById(2131827184);
        localTextView1.setText(com.tencent.mm.pluginsdk.ui.d.j.b(this, (CharSequence)localObject1));
        ((CdnImageView)localObject2).setVisibility(0);
        if (!bo.isNullOrNil(this.qiN))
        {
          if (this.qnb == 1) {
            ((CdnImageView)localObject2).setRoundCorner(true);
          }
          ((CdnImageView)localObject2).setUrl(this.qiN);
        }
        for (;;)
        {
          localView.setVisibility(8);
          localTextView2.setVisibility(8);
          if (paramj == null) {
            break;
          }
          if (paramj.qjl.wBJ != 1) {
            break label542;
          }
          localView.setVisibility(0);
          localTextView2.setVisibility(0);
          localTextView2.setText(e.F(paramj.qjl.wBG / 100.0D));
          break;
          if (this.qnb == 1) {
            a.b.s((ImageView)localObject2, this.qmL);
          } else {
            a.b.c((ImageView)localObject2, this.qmL);
          }
        }
        localView.setVisibility(8);
        localTextView2.setVisibility(8);
      }
    }
  }
  
  private static boolean dx(View paramView)
  {
    AppMethodBeat.i(44883);
    if ((paramView == null) || (paramView.getVisibility() == 8))
    {
      AppMethodBeat.o(44883);
      return true;
    }
    AppMethodBeat.o(44883);
    return false;
  }
  
  private void dy(View paramView)
  {
    AppMethodBeat.i(44887);
    View localView = findViewById(2131821249);
    if (localView != null) {
      localView.setVisibility(8);
    }
    paramView.post(new RemittanceBusiResultUI.8(this));
    AppMethodBeat.o(44887);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(44879);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(44879);
    return bool;
  }
  
  public void finish()
  {
    AppMethodBeat.i(44878);
    ab.i("MicroMsg.RemittanceBusiResultUI", "finish this %s %s", new Object[] { this, bo.dtY() });
    if (this.qni)
    {
      AppMethodBeat.o(44878);
      return;
    }
    super.finish();
    this.qni = true;
    AppMethodBeat.o(44878);
  }
  
  public int getLayoutId()
  {
    return 2130970568;
  }
  
  public void initView()
  {
    AppMethodBeat.i(44888);
    this.iJG = ((TextView)findViewById(2131827187));
    this.qmv = ((TextView)findViewById(2131827188));
    this.qmw = ((TextView)findViewById(2131827198));
    this.qmx = ((TextView)findViewById(2131827200));
    this.qmy = ((TextView)findViewById(2131827204));
    this.qmD = ((LinearLayout)findViewById(2131827197));
    this.qmE = ((LinearLayout)findViewById(2131827199));
    this.qmF = ((LinearLayout)findViewById(2131827203));
    this.qmz = ((CdnImageView)findViewById(2131827206));
    this.qmA = ((TextView)findViewById(2131827207));
    this.qmB = ((TextView)findViewById(2131827208));
    this.qmC = ((Button)findViewById(2131827209));
    this.qmG = ((ViewGroup)findViewById(2131827205));
    this.nJm = ((Button)findViewById(2131827214));
    this.qmH = findViewById(2131827196);
    this.qmI = ((LinearLayout)findViewById(2131827195));
    this.qmv.setText(e.E(this.qmM));
    al.p(this.qnl, 500L);
    if (!bo.isNullOrNil(this.qmJ))
    {
      this.qmw.setText(this.qmJ);
      this.qmD.setVisibility(0);
      if (bo.isNullOrNil(this.qmK)) {
        break label413;
      }
      this.qmx.setText(this.qmK);
      this.qmE.setVisibility(0);
    }
    for (;;)
    {
      this.nJm.setOnClickListener(new RemittanceBusiResultUI.3(this));
      this.qnd = ((WalletSuccPageAwardWidget)findViewById(2131827212));
      this.qne = ((ViewGroup)findViewById(2131827192));
      this.qnf = ((ViewGroup)findViewById(2131827193));
      this.qng = ((ViewGroup)findViewById(2131827201));
      this.qnh = ((TextView)findViewById(2131827202));
      AppMethodBeat.o(44888);
      return;
      this.qmD.setVisibility(8);
      break;
      label413:
      this.qmE.setVisibility(8);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(44880);
    super.onCreate(paramBundle);
    addSceneEndListener(1537);
    addSceneEndListener(1680);
    addSceneEndListener(2504);
    this.qnj.alive();
    if (d.fv(21))
    {
      if (!d.fv(23)) {
        break label508;
      }
      getWindow().setStatusBarColor(-1);
      getWindow().getDecorView().setSystemUiVisibility(8192);
    }
    for (;;)
    {
      if (getSupportActionBar() != null) {
        getSupportActionBar().hide();
      }
      setBackBtn(null);
      showHomeBtn(false);
      enableBackMenu(false);
      this.qll = getIntent().getStringExtra("key_mch_name");
      this.qmW = ((BusiRemittanceResp)getIntent().getParcelableExtra("BusiRemittanceResp"));
      this.qmM = getIntent().getDoubleExtra("key_money", 0.0D);
      this.qmL = getIntent().getStringExtra("key_rcver_name");
      this.qmV = getIntent().getStringExtra("key_rcver_true_name");
      this.qmJ = getIntent().getStringExtra("key_rcv_desc");
      this.qmK = getIntent().getStringExtra("key_pay_desc");
      this.qmN = getIntent().getStringExtra("key_f2f_id");
      this.plc = getIntent().getStringExtra("key_trans_id");
      this.qlP = getIntent().getStringExtra("key_rcvr_open_id");
      this.qmS = getIntent().getStringExtra("key_check_sign");
      this.qmO = getIntent().getStringExtra("key_pay_desc");
      this.qmP = getIntent().getStringExtra("key_rcv_desc");
      this.qmQ = getIntent().getIntExtra("key_scan_sceen", 0);
      this.mChannel = getIntent().getIntExtra("key_channel", 0);
      this.qmR = getIntent().getStringExtra("key_succ_page_extend");
      paramBundle = getIntent().getByteArrayExtra("AfterPlaceOrderCommReq");
      this.qmX = i.Yf(getIntent().getStringExtra("key_succ_fault_config"));
      try
      {
        this.qna.parseFrom(paramBundle);
        this.qnb = getIntent().getIntExtra("key_succ_show_avatar_type", 0);
        this.qiM = getIntent().getIntExtra("key_succ_show_avatar_show", 0);
        this.qiN = getIntent().getStringExtra("key_succ_show_avatar_url");
        this.qmU = false;
        ab.i("MicroMsg.RemittanceBusiResultUI", "fetch data");
        ab.i("MicroMsg.RemittanceBusiResultUI", "fetchData() mBusiF2FFaultConfig.flag:%s mBusiF2FFaultConfig.succpage_first_delay_ms:%s", new Object[] { Integer.valueOf(this.qmX.bsY), Integer.valueOf(this.qmX.wAP) });
        if (bo.hl(this.qmX.bsY, 1))
        {
          al.p(this.qmZ, this.qmX.wAP);
          initView();
          AppMethodBeat.o(44880);
          return;
          label508:
          getWindow().setStatusBarColor(Color.parseColor("#E5E5E5"));
        }
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.RemittanceBusiResultUI", paramBundle, "", new Object[0]);
          continue;
          doSceneProgress(new com.tencent.mm.plugin.remittance.model.j(this.qna, this.qmR));
        }
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(44885);
    super.onDestroy();
    removeSceneEndListener(1537);
    removeSceneEndListener(1680);
    removeSceneEndListener(2504);
    this.qnj.dead();
    if (this.qnc != null) {
      this.qnd.onDestroy();
    }
    al.ae(this.qnl);
    AppMethodBeat.o(44885);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(44884);
    super.onResume();
    if (this.qmU)
    {
      ab.i("MicroMsg.RemittanceBusiResultUI", "do act qry");
      int i = (int)Math.round(this.qmM * 100.0D);
      doSceneProgress(new f(this.qmN, this.plc, this.qlP, i, this.qmT, this.qmS), false);
      this.qmU = false;
    }
    if (this.qnc != null) {
      this.qnd.onResume();
    }
    AppMethodBeat.o(44884);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(44882);
    ab.i("MicroMsg.RemittanceBusiResultUI", "errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scenetype:" + paramm.getType());
    Object localObject;
    if ((paramm instanceof com.tencent.mm.plugin.remittance.model.j))
    {
      localObject = (com.tencent.mm.plugin.remittance.model.j)paramm;
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        if (this.qmY)
        {
          ab.i("MicroMsg.RemittanceBusiResultUI", "NetSceneBusiF2fSucpage success(mIfSuccNetSceneBusiF2fSucpage:%s)", new Object[] { Boolean.valueOf(this.qmY) });
          if (this.qnc == null) {
            break label806;
          }
        }
      }
    }
    label420:
    label806:
    for (boolean bool = this.qnd.onSceneEnd(paramInt1, paramInt2, paramString, paramm);; bool = false)
    {
      this.qmH.setVisibility(8);
      AppMethodBeat.o(44882);
      return bool;
      if (((com.tencent.mm.plugin.remittance.model.j)localObject).qjl.koj == 0)
      {
        this.qmY = true;
        al.ae(this.qmZ);
        ab.i("MicroMsg.RemittanceBusiResultUI", "exposure info: %s", new Object[] { ((com.tencent.mm.plugin.remittance.model.j)localObject).qjl.ukr });
        this.qnc = ((com.tencent.mm.plugin.remittance.model.j)localObject).qjl.ukr;
        if (WalletSuccPageAwardWidget.a(this.qnc))
        {
          ab.i("MicroMsg.RemittanceBusiResultUI", "setAwardWidget, mTransId: %s", new Object[] { this.plc });
          this.qnd.a(this, this.qnc, this.plc, true, (ImageView)findViewById(2131824152));
          this.qnd.init();
          this.qnd.setVisibility(0);
          ImageView localImageView = (ImageView)findViewById(2131824152);
          localImageView.post(new RemittanceBusiResultUI.4(this, localImageView));
          dy(this.qnd);
          label318:
          a((com.tencent.mm.plugin.remittance.model.j)localObject);
          al.ae(this.qnl);
          if (bo.isNullOrNil(((com.tencent.mm.plugin.remittance.model.j)localObject).qjl.wBL)) {
            break label441;
          }
          if (!bo.isNullOrNil(((com.tencent.mm.plugin.remittance.model.j)localObject).qjl.wBM)) {
            break label420;
          }
          this.qmy.setTextColor(getResources().getColor(2131690318));
          label376:
          this.qmy.setText(((com.tencent.mm.plugin.remittance.model.j)localObject).qjl.wBL);
          this.qmF.setVisibility(0);
        }
        for (;;)
        {
          b((com.tencent.mm.plugin.remittance.model.j)localObject);
          break;
          this.qnd.setVisibility(8);
          break label318;
          this.qmy.setTextColor(Color.parseColor(((com.tencent.mm.plugin.remittance.model.j)localObject).qjl.wBM));
          break label376;
          label441:
          this.qmF.setVisibility(8);
        }
      }
      ab.e("MicroMsg.RemittanceBusiResultUI", "result response: %s, %s, %s", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.remittance.model.j)localObject).qjl.koj), ((com.tencent.mm.plugin.remittance.model.j)localObject).qjl.kok, Boolean.valueOf(((com.tencent.mm.plugin.remittance.model.j)localObject).qjl.wBN) });
      if (((com.tencent.mm.plugin.remittance.model.j)localObject).qjl.wBN) {
        break;
      }
      this.qmY = true;
      al.ae(this.qmZ);
      break;
      ab.e("MicroMsg.RemittanceBusiResultUI", "net error: %s", new Object[] { localObject });
      break;
      if (!(paramm instanceof f)) {
        break;
      }
      localObject = (f)paramm;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (((f)localObject).qiY.koj == 0)
        {
          localObject = ((f)localObject).qiY.wAO;
          if (localObject != null)
          {
            this.qmz.setUrl(((nm)localObject).cDz);
            this.qmA.setText(((nm)localObject).title);
            this.qmB.setText(((nm)localObject).uiP);
            this.qmC.setText(((nm)localObject).urC);
            this.qmC.setOnClickListener(new RemittanceBusiResultUI.5(this, (nm)localObject));
            this.qmC.setBackgroundResource(2130840140);
            this.qmC.setTextColor(getResources().getColor(2131690712));
            this.qmG.setVisibility(0);
            dy(this.qmG);
            break;
          }
          ab.i("MicroMsg.RemittanceBusiResultUI", "app info is null");
          this.qmG.setVisibility(8);
          break;
        }
        ab.e("MicroMsg.RemittanceBusiResultUI", "qry response: %s, %s", new Object[] { Integer.valueOf(((f)localObject).qiY.koj), ((f)localObject).qiY.kok });
        Toast.makeText(this, ((f)localObject).qiY.kok, 1).show();
        break;
      }
      ab.e("MicroMsg.RemittanceBusiResultUI", "net error: %s", new Object[] { localObject });
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
    AppMethodBeat.i(44886);
    getContentView().setVisibility(paramInt);
    AppMethodBeat.o(44886);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBusiResultUI
 * JD-Core Version:    0.7.0.1
 */