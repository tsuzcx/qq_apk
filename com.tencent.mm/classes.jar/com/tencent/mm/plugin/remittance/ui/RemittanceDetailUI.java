package com.tencent.mm.plugin.remittance.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.a.oj;
import com.tencent.mm.g.a.ok;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.order.c.a.a;
import com.tencent.mm.plugin.remittance.model.u;
import com.tencent.mm.plugin.remittance.model.x;
import com.tencent.mm.plugin.remittance.model.x.a;
import com.tencent.mm.plugin.remittance.model.x.b;
import com.tencent.mm.plugin.remittance.model.x.d;
import com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI;
import com.tencent.mm.plugin.wallet_core.c.ah;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.o;
import com.tencent.mm.wallet_core.c.k;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class RemittanceDetailUI
  extends WalletBaseUI
{
  private int jUm;
  private int jUn;
  private com.tencent.mm.ui.widget.c.a jVd;
  private n.d lNZ;
  private View.OnTouchListener mAc;
  private View.OnLongClickListener mAd;
  protected TextView orU;
  private String ppE;
  private String ppL;
  private LinearLayout qlB;
  private String qlM;
  private int qlN;
  protected String qlT;
  protected TextView qpA;
  protected LinearLayout qpB;
  private LinearLayout qpC;
  private LinearLayout qpD;
  private LinearLayout qpE;
  private LinearLayout qpF;
  private TextView qpG;
  private TextView qpH;
  private TextView qpI;
  private TextView qpJ;
  private TextView qpK;
  protected int qpL;
  protected int qpM;
  public String qpN;
  public String qpO;
  protected String qpP;
  protected int qpQ;
  protected boolean qpR;
  protected int qpS;
  private int qpT;
  private u qpU;
  private com.tencent.mm.sdk.b.c<ok> qpV;
  private com.tencent.mm.sdk.b.c<oj> qpW;
  private int qpX;
  protected ImageView qpa;
  protected TextView qpb;
  protected TextView qpc;
  protected TextView qpd;
  protected TextView qpe;
  protected Button qpf;
  protected LinearLayout qpg;
  private LinearLayout qph;
  private LinearLayout qpi;
  private LinearLayout qpj;
  private TextView qpk;
  private TextView qpl;
  private TextView qpm;
  private TextView qpn;
  private TextView qpo;
  protected RelativeLayout qpp;
  protected ImageView qpq;
  protected TextView qpr;
  protected TextView qps;
  protected ImageView qpt;
  protected Button qpu;
  protected TextView qpv;
  protected View qpw;
  protected View qpx;
  protected View qpy;
  protected Button qpz;
  
  public RemittanceDetailUI()
  {
    AppMethodBeat.i(45027);
    this.qpa = null;
    this.qpb = null;
    this.qpc = null;
    this.qpd = null;
    this.qpe = null;
    this.qpf = null;
    this.orU = null;
    this.qpz = null;
    this.qpA = null;
    this.qpN = null;
    this.qpO = null;
    this.qlT = null;
    this.qpP = null;
    this.qlM = null;
    this.qpQ = 3;
    this.qpR = false;
    this.qpV = new RemittanceDetailUI.1(this);
    this.qpW = new RemittanceDetailUI.12(this);
    this.jVd = null;
    this.qpX = 0;
    this.lNZ = new RemittanceDetailUI.10(this);
    this.mAc = new RemittanceDetailUI.11(this);
    this.mAd = new RemittanceDetailUI.13(this);
    AppMethodBeat.o(45027);
  }
  
  private void a(u paramu)
  {
    AppMethodBeat.i(45042);
    if ("confirm".equals(paramu.qjy))
    {
      Cu(1);
      AppMethodBeat.o(45042);
      return;
    }
    aZ(0, getResources().getString(2131302550));
    AppMethodBeat.o(45042);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, final x paramx)
  {
    AppMethodBeat.i(45037);
    if (paramBoolean1)
    {
      this.qpg.setVisibility(8);
      this.qpB.setVisibility(0);
      if (!bo.isNullOrNil(paramx.qkB.qkH))
      {
        this.qpC.setVisibility(0);
        if (!bo.isNullOrNil(paramx.desc))
        {
          this.qpD.setVisibility(0);
          this.qpH.setText(paramx.desc);
          this.qpH.setOnLongClickListener(this.mAd);
          this.qpH.setOnTouchListener(this.mAc);
          if (bo.isNullOrNil(paramx.qkB.qkH)) {
            break label415;
          }
          this.qpE.setVisibility(0);
          this.qpI.setText(paramx.qkB.qkH + "  " + paramx.qkB.gAF);
          this.qpG.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(45026);
              int i = RemittanceResultNewUI.m(RemittanceDetailUI.this, paramx.qkB.fBq, RemittanceDetailUI.d(RemittanceDetailUI.this).getWidth());
              if (!bo.hl(i, paramx.qkB.fBq.length()))
              {
                String str1 = RemittanceDetailUI.this.getString(2131296829);
                String str2 = paramx.qkB.fBq.substring(0, i) + "... ";
                SpannableString localSpannableString = new SpannableString(str2 + str1);
                com.tencent.mm.plugin.order.c.a locala = new com.tencent.mm.plugin.order.c.a(RemittanceDetailUI.this);
                locala.prW = new a.a()
                {
                  public final void onClick(View paramAnonymous2View)
                  {
                    AppMethodBeat.i(45024);
                    RemittanceDetailUI.e(RemittanceDetailUI.this).setVisibility(8);
                    RemittanceDetailUI.f(RemittanceDetailUI.this).setVisibility(0);
                    o.a(RemittanceDetailUI.this, (ScrollView)RemittanceDetailUI.this.findViewById(2131820898), RemittanceDetailUI.this.findViewById(2131827243), RemittanceDetailUI.this.findViewById(2131827247), RemittanceDetailUI.this.findViewById(2131827281));
                    AppMethodBeat.o(45024);
                  }
                };
                localSpannableString.setSpan(locala, str2.length(), str2.length() + str1.length(), 33);
                RemittanceDetailUI.e(RemittanceDetailUI.this).setOnTouchListener(a.cgY());
                RemittanceDetailUI.e(RemittanceDetailUI.this).setText(localSpannableString);
                str1 = RemittanceDetailUI.this.getString(2131296825);
                str2 = paramx.qkB.fBq + "  ";
                localSpannableString = new SpannableString(str2 + str1);
                locala = new com.tencent.mm.plugin.order.c.a(RemittanceDetailUI.this);
                locala.prW = new RemittanceDetailUI.23.2(this);
                i = str2.length();
                int j = str2.length();
                localSpannableString.setSpan(locala, i, str1.length() + j, 33);
                RemittanceDetailUI.f(RemittanceDetailUI.this).setOnTouchListener(a.cgY());
                RemittanceDetailUI.f(RemittanceDetailUI.this).setText(localSpannableString);
              }
              for (;;)
              {
                RemittanceDetailUI.e(RemittanceDetailUI.this).setVisibility(0);
                RemittanceDetailUI.f(RemittanceDetailUI.this).setVisibility(8);
                RemittanceDetailUI.h(RemittanceDetailUI.this).setOnLongClickListener(RemittanceDetailUI.g(RemittanceDetailUI.this));
                RemittanceDetailUI.h(RemittanceDetailUI.this).setOnTouchListener(RemittanceDetailUI.i(RemittanceDetailUI.this));
                AppMethodBeat.o(45026);
                return;
                RemittanceDetailUI.e(RemittanceDetailUI.this).setText(paramx.qkB.fBq);
                RemittanceDetailUI.f(RemittanceDetailUI.this).setText(paramx.qkB.fBq);
              }
            }
          });
          label180:
          if ((!paramBoolean2) || (bo.isNullOrNil(paramx.qkC.cDz))) {
            break label736;
          }
          this.qpg.setVisibility(0);
          this.qph.setVisibility(0);
          this.qpy.setVisibility(0);
          this.qpp.setVisibility(0);
          this.qpw.setVisibility(0);
          com.tencent.mm.at.a.a.ahM().a(paramx.qkC.cDz, this.qpq);
          this.qpr.setText(paramx.qkC.name);
          this.qps.setText(paramx.qkC.cyA);
          if (paramx.qkC.qkI <= 0) {
            break label684;
          }
          this.qpu.setText(paramx.qkC.qkJ);
          this.qpt.setVisibility(8);
          this.qpu.setVisibility(0);
          this.qpu.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(44998);
              RemittanceDetailUI.a(RemittanceDetailUI.this, paramx.qkC.qkK, paramx, 11);
              AppMethodBeat.o(44998);
            }
          });
          label339:
          if (!bo.isNullOrNil(paramx.qkD.cyA)) {
            break label766;
          }
          this.qpv.setVisibility(8);
        }
      }
    }
    for (;;)
    {
      o.a(this, (ScrollView)findViewById(2131820898), findViewById(2131827243), findViewById(2131827247), findViewById(2131827281));
      AppMethodBeat.o(45037);
      return;
      this.qpD.setVisibility(8);
      break;
      label415:
      this.qpE.setVisibility(8);
      break label180;
      this.qpC.setVisibility(8);
      break label180;
      this.qpg.setVisibility(0);
      this.qpB.setVisibility(8);
      if (!bo.isNullOrNil(paramx.qkB.qkH))
      {
        this.qph.setVisibility(0);
        if (!bo.isNullOrNil(paramx.desc))
        {
          this.qpi.setVisibility(0);
          this.qpl.setText(paramx.desc);
          this.qpl.setOnLongClickListener(this.mAd);
          this.qpl.setOnTouchListener(this.mAc);
        }
        for (;;)
        {
          if (bo.isNullOrNil(paramx.qkB.qkH)) {
            break label624;
          }
          this.qlB.setVisibility(0);
          this.qpm.setText(paramx.qkB.qkH + "  " + paramx.qkB.gAF);
          this.qpk.post(new RemittanceDetailUI.2(this, paramx));
          break;
          this.qpi.setVisibility(8);
        }
        label624:
        this.qlB.setVisibility(8);
        break label180;
      }
      this.qpx.setVisibility(8);
      this.qpi.setVisibility(8);
      this.qlB.setVisibility(8);
      this.qpy.setVisibility(8);
      this.qph.setVisibility(8);
      break label180;
      label684:
      this.qpt.setVisibility(0);
      this.qpu.setVisibility(8);
      this.qpt.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(44999);
          RemittanceDetailUI.a(RemittanceDetailUI.this, paramx.qkC.qkK, paramx, 11);
          AppMethodBeat.o(44999);
        }
      });
      this.qpp.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(45000);
          RemittanceDetailUI.a(RemittanceDetailUI.this, paramx.qkC.qkK, paramx, 11);
          AppMethodBeat.o(45000);
        }
      });
      break label339;
      label736:
      this.qpy.setVisibility(8);
      this.qpp.setVisibility(8);
      this.qpw.setVisibility(8);
      break label339;
      label766:
      this.qpv.setText(paramx.qkD.cyA);
      this.qpv.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(45001);
          RemittanceDetailUI.a(RemittanceDetailUI.this, paramx.qkD.qkK, paramx, 12);
          AppMethodBeat.o(45001);
        }
      });
      this.qpv.setVisibility(0);
    }
  }
  
  private void b(Dialog paramDialog)
  {
    AppMethodBeat.i(45038);
    if (paramDialog != null) {
      paramDialog.dismiss();
    }
    paramDialog = new Intent(this, WalletLqtDetailUI.class);
    paramDialog.putExtra("key_account_type", 0);
    startActivityForResult(paramDialog, 2);
    AppMethodBeat.o(45038);
  }
  
  public static String bi(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(45045);
    String str = com.tencent.mm.wallet_core.ui.e.nE(paramString);
    if (str == null)
    {
      AppMethodBeat.o(45045);
      return "";
    }
    paramString = str;
    if (str.length() > 10)
    {
      paramString = str;
      if (paramBoolean) {
        paramString = str.substring(0, 8) + "...";
      }
    }
    AppMethodBeat.o(45045);
    return paramString;
  }
  
  private void chi()
  {
    AppMethodBeat.i(45040);
    if ((this.qpT != 0) && (this.qlN == 1) && (!bo.isNullOrNil(this.qlM)))
    {
      addIconOptionMenu(0, 2130840873, new RemittanceDetailUI.14(this));
      AppMethodBeat.o(45040);
      return;
    }
    ab.i("MicroMsg.RemittanceDetailUI", "flag: %d, descUrl empty: %B", new Object[] { Integer.valueOf(this.qpT), Boolean.valueOf(bo.isNullOrNil(this.qlM)) });
    removeAllOptionMenu();
    AppMethodBeat.o(45040);
  }
  
  protected void Cu(int paramInt)
  {
    AppMethodBeat.i(45031);
    doSceneProgress(new x(paramInt, this.qpN, this.qlT, this.qpL), true);
    AppMethodBeat.o(45031);
  }
  
  protected void Cv(int paramInt)
  {
    AppMethodBeat.i(45033);
    if (!getIntent().getBooleanExtra("is_sender", false)) {}
    for (com.tencent.mm.plugin.order.model.h localh = new com.tencent.mm.plugin.order.model.h(this.qlT, this.qpP, paramInt);; localh = new com.tencent.mm.plugin.order.model.h(this.qpN, this.qpP, paramInt))
    {
      localh.setProcessName("RemittanceProcess");
      doSceneProgress(localh);
      AppMethodBeat.o(45033);
      return;
    }
  }
  
  protected final void aZ(int paramInt, String paramString)
  {
    AppMethodBeat.i(45043);
    Intent localIntent = new Intent();
    localIntent.putExtra("result_msg", paramString);
    setResult(paramInt, localIntent);
    finish();
    AppMethodBeat.o(45043);
  }
  
  protected void am(Intent paramIntent)
  {
    AppMethodBeat.i(45034);
    d.b(this, "remittance", ".ui.RemittanceResendMsgUI", paramIntent);
    AppMethodBeat.o(45034);
  }
  
  protected void chx()
  {
    AppMethodBeat.i(45035);
    u localu = new u(this.qpN, this.qlT, this.qpS, "confirm", this.qpO, this.qpL);
    localu.setProcessName("RemittanceProcess");
    doSceneProgress(localu);
    AppMethodBeat.o(45035);
  }
  
  protected void chy()
  {
    AppMethodBeat.i(45036);
    u localu = new u(this.qpN, this.qlT, this.qpS, "refuse", this.qpO, this.qpL);
    localu.setProcessName("RemittanceProcess");
    doSceneProgress(localu);
    AppMethodBeat.o(45036);
  }
  
  public void finish()
  {
    AppMethodBeat.i(45044);
    Bundle localBundle = new Bundle();
    localBundle.putString("realname_verify_process_jump_plugin", "remittance");
    localBundle.putString("realname_verify_process_jump_activity", ".ui.RemittanceDetailUI");
    if ((this.qpU != null) && (com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, this.qpU, localBundle, true, 1008)))
    {
      this.qpU = null;
      AppMethodBeat.o(45044);
      return;
    }
    super.finish();
    AppMethodBeat.o(45044);
  }
  
  public int getLayoutId()
  {
    return 2130970570;
  }
  
  public void initView()
  {
    AppMethodBeat.i(45032);
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(2131689615));
    this.qpa = ((ImageView)findViewById(2131827244));
    this.qpb = ((TextView)findViewById(2131827245));
    this.qpc = ((TextView)findViewById(2131827246));
    this.qpf = ((Button)findViewById(2131827249));
    this.orU = ((TextView)findViewById(2131827250));
    this.qpg = ((LinearLayout)findViewById(2131827248));
    this.qph = ((LinearLayout)findViewById(2131827251));
    this.qpi = ((LinearLayout)findViewById(2131822911));
    this.qlB = ((LinearLayout)findViewById(2131827255));
    this.qpj = ((LinearLayout)findViewById(2131827257));
    this.qpk = ((TextView)findViewById(2131827253));
    this.qpl = ((TextView)findViewById(2131827254));
    this.qpm = ((TextView)findViewById(2131827258));
    this.qpn = ((TextView)findViewById(2131827259));
    this.qpo = ((TextView)findViewById(2131827260));
    this.qpp = ((RelativeLayout)findViewById(2131827262));
    this.qpq = ((ImageView)findViewById(2131827263));
    this.qpr = ((TextView)findViewById(2131827264));
    this.qps = ((TextView)findViewById(2131827265));
    this.qpt = ((ImageView)findViewById(2131827266));
    this.qpu = ((Button)findViewById(2131822914));
    this.qpv = ((TextView)findViewById(2131827282));
    this.qpw = findViewById(2131827267);
    this.qpx = findViewById(2131827252);
    this.qpy = findViewById(2131827261);
    this.qpz = ((Button)findViewById(2131827279));
    this.qpA = ((TextView)findViewById(2131827280));
    this.qpB = ((LinearLayout)findViewById(2131827268));
    this.qpC = ((LinearLayout)findViewById(2131827269));
    this.qpD = ((LinearLayout)findViewById(2131827270));
    this.qpE = ((LinearLayout)findViewById(2131827273));
    this.qpF = ((LinearLayout)findViewById(2131827275));
    this.qpG = ((TextView)findViewById(2131827271));
    this.qpH = ((TextView)findViewById(2131827272));
    this.qpI = ((TextView)findViewById(2131827276));
    this.qpJ = ((TextView)findViewById(2131827277));
    this.qpK = ((TextView)findViewById(2131827278));
    this.qpd = ((TextView)findViewById(2131827283));
    this.qpe = ((TextView)findViewById(2131827284));
    AppMethodBeat.o(45032);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(45030);
    ab.i("MicroMsg.RemittanceDetailUI", "onActivityResult %s %s %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent });
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 2) {
      Cu(0);
    }
    AppMethodBeat.o(45030);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(45028);
    super.onCreate(paramBundle);
    this.qpL = getIntent().getIntExtra("invalid_time", 0);
    this.qpM = getIntent().getIntExtra("appmsg_type", 0);
    this.qpN = getIntent().getStringExtra("transaction_id");
    this.qpP = getIntent().getStringExtra("bill_id");
    this.qlT = getIntent().getStringExtra("transfer_id");
    this.qpO = getIntent().getStringExtra("sender_name");
    this.qpQ = getIntent().getIntExtra("effective_date", 3);
    this.qpR = getIntent().getBooleanExtra("is_sender", false);
    this.qpS = getIntent().getIntExtra("total_fee", 0);
    initView();
    Cu(0);
    getIntent();
    com.tencent.mm.sdk.b.a.ymk.c(this.qpV);
    this.qpW.alive();
    AppMethodBeat.o(45028);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(45039);
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    paramContextMenu.add(0, 0, 0, getString(2131296895));
    AppMethodBeat.o(45039);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(45029);
    com.tencent.mm.sdk.b.a.ymk.d(this.qpV);
    if (this.qpW != null) {
      this.qpW.dead();
    }
    super.onDestroy();
    AppMethodBeat.o(45029);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(45041);
    final boolean bool;
    if ((paramm instanceof x))
    {
      final x localx = (x)paramm;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        Object localObject;
        if (localx != null)
        {
          if (localx.nJo)
          {
            this.ppL = r.Zn();
            this.ppE = this.qpO;
            bool = r.Zn().equals(this.ppE);
            this.qpf.setVisibility(8);
            this.qpc.setText(com.tencent.mm.wallet_core.ui.e.e(localx.kNS, localx.ppp));
            paramm = localx.qky;
            paramString = paramm;
            if (!bo.isNullOrNil(paramm))
            {
              paramString = paramm;
              if (paramm.contains("%s")) {
                paramString = paramm.trim().replace("%s", bi(this.ppE, true));
              }
            }
            paramm = localx.qkz;
            localObject = new Bundle();
            ((Bundle)localObject).putString("transaction_id", this.qpN);
            ((Bundle)localObject).putString("receiver_name", this.ppE);
            ((Bundle)localObject).putString("transfer_id", this.qlT);
            ((Bundle)localObject).putInt("total_fee", this.qpS);
            ((Bundle)localObject).putString("sender_name", this.qpO);
            ((Bundle)localObject).putInt("invalid_time", this.qpL);
            ((Bundle)localObject).putParcelable("resend_msg_info", localx.qkE);
            this.orU.setClickable(true);
            this.qpb.setClickable(true);
            this.qpA.setClickable(true);
            paramInt1 = localx.status;
            ab.d("MicroMsg.RemittanceDetailUI", "status: %d", new Object[] { Integer.valueOf(paramInt1) });
          }
        }
        else {
          switch (paramInt1)
          {
          default: 
            finish();
            label344:
            if (!bo.isNullOrNil(localx.qkF)) {
              com.tencent.mm.wallet_core.ui.e.a((TextView)findViewById(2131821672), "7", localx.qkF, localx.qkG);
            }
            this.qpT = localx.qkA;
            g.RM();
            this.qlM = ((String)g.RL().Ru().get(ac.a.yED, ""));
            g.RM();
            this.qlN = ((Integer)g.RL().Ru().get(ac.a.yEE, Integer.valueOf(0))).intValue();
            if (bo.isNullOrNil(this.qlM))
            {
              ah.a(true, this.mNetSceneMgr);
              label465:
              chi();
              if (localx.ppX == 1)
              {
                g.RM();
                if (!((String)g.RL().Ru().get(327729, "0")).equals("0")) {
                  break label3203;
                }
                paramString = getContext();
                if (!r.ZB()) {
                  break label3196;
                }
                paramInt1 = 2131298203;
                label524:
                com.tencent.mm.ui.base.h.a(paramString, paramInt1, 2131305585, new RemittanceDetailUI.15(this));
                g.RM();
                g.RL().Ru().set(327729, "1");
              }
            }
            break;
          }
        }
        for (;;)
        {
          AppMethodBeat.o(45041);
          return true;
          this.ppL = this.qpO;
          this.ppE = r.Zn();
          break;
          if (!bool) {
            if ((!bo.isNullOrNil(paramString)) && (!bo.isNullOrNil(paramm)))
            {
              this.qpb.setText(j.a(this, paramString, (int)this.qpb.getTextSize(), localObject));
              this.orU.setText(j.a(this, paramm, (int)this.orU.getTextSize(), localObject));
              this.qpb.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.m());
              this.orU.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.m());
              label679:
              a(false, false, localx);
            }
          }
          com.tencent.mm.plugin.order.c.a locala;
          for (;;)
          {
            this.qpa.setImageResource(2131231926);
            this.qpd.setText(getString(2131302576, new Object[] { com.tencent.mm.wallet_core.ui.e.kB(localx.qku) }));
            this.qpd.setVisibility(0);
            this.qpe.setVisibility(8);
            break;
            paramString = getString(2131302568, new Object[] { bi(this.ppE, true) });
            this.qpb.setText(j.b(this, paramString, this.qpb.getTextSize()));
            paramString = getString(2131302574, new Object[] { Integer.valueOf(this.qpQ) });
            paramm = getString(2131302610);
            localObject = new SpannableString(paramString + paramm);
            locala = new com.tencent.mm.plugin.order.c.a(this);
            locala.prW = new RemittanceDetailUI.17(this, localx);
            ((SpannableString)localObject).setSpan(locala, paramString.length(), paramString.length() + paramm.length(), 33);
            this.orU.setMovementMethod(LinkMovementMethod.getInstance());
            this.orU.setText((CharSequence)localObject);
            break label679;
            this.qpa.setImageResource(2131231926);
            this.qpz.setVisibility(0);
            this.qpz.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(45018);
                ((com.tencent.mm.pluginsdk.wallet.c)g.E(com.tencent.mm.pluginsdk.wallet.c.class)).eJ(9, 4);
                t.cTI();
                paramAnonymousView = RemittanceDetailUI.this;
                i locali = RemittanceDetailUI.c(RemittanceDetailUI.this);
                new RemittanceDetailUI.18.1(this);
                if (!t.a(paramAnonymousView, locali)) {
                  RemittanceDetailUI.this.chx();
                }
                AppMethodBeat.o(45018);
              }
            });
            if ((bo.isNullOrNil(paramString)) || (bo.isNullOrNil(paramm))) {
              break label1049;
            }
            this.qpb.setText(j.a(this, paramString, (int)this.qpb.getTextSize(), localObject));
            this.qpA.setText(j.a(this, paramm, (int)this.qpA.getTextSize(), localObject));
            this.qpb.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.m());
            this.qpA.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.m());
            a(true, false, localx);
          }
          label1049:
          this.qpb.setText(2131302567);
          if (localx.qkA != 0) {
            if (!bo.isNullOrNil(localx.qkz)) {
              paramString = localx.qkz;
            }
          }
          for (;;)
          {
            paramm = getString(2131302559);
            localObject = new SpannableString(paramString + paramm);
            locala = new com.tencent.mm.plugin.order.c.a(this);
            locala.prW = new a.a()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(45020);
                com.tencent.mm.ui.base.h.d(RemittanceDetailUI.this, RemittanceDetailUI.this.getString(2131302555, new Object[] { RemittanceDetailUI.bi(localx.qkw, false) }), RemittanceDetailUI.this.getString(2131297056), RemittanceDetailUI.this.getString(2131302560), RemittanceDetailUI.this.getString(2131296888), new RemittanceDetailUI.19.1(this), new RemittanceDetailUI.19.2(this));
                AppMethodBeat.o(45020);
              }
            };
            ((SpannableString)localObject).setSpan(locala, paramString.length(), paramString.length() + paramm.length(), 33);
            this.qpA.setMovementMethod(LinkMovementMethod.getInstance());
            this.qpA.setText((CharSequence)localObject);
            break;
            ab.i("MicroMsg.RemittanceDetailUI", "use hardcode wording");
            if (localx.qkA == 1) {}
            for (paramString = "24";; paramString = "2")
            {
              paramString = getString(2131302569, new Object[] { paramString });
              paramm = getString(2131302570, new Object[] { Integer.valueOf(this.qpQ) });
              paramString = paramString + paramm;
              break;
            }
            paramString = getString(2131302570, new Object[] { Integer.valueOf(this.qpQ) });
          }
          this.qpa.setImageResource(2131231923);
          if ((!bo.isNullOrNil(paramString)) && (!bo.isNullOrNil(paramm)))
          {
            this.qpb.setText(j.a(this, paramString, (int)this.qpb.getTextSize(), localObject));
            this.orU.setText(j.a(this, paramm, (int)this.orU.getTextSize(), localObject));
            this.qpb.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.m());
            this.orU.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.m());
            label1404:
            if (!bool) {
              break label1661;
            }
            a(false, true, localx);
          }
          for (;;)
          {
            this.qpd.setText(getString(2131302576, new Object[] { com.tencent.mm.wallet_core.ui.e.kB(localx.qku) }));
            this.qpd.setVisibility(0);
            this.qpe.setText(getString(2131302551, new Object[] { com.tencent.mm.wallet_core.ui.e.kB(localx.qkx) }));
            this.qpe.setVisibility(0);
            break;
            if (bool)
            {
              this.qpb.setText(2131302562);
              paramString = new SpannableStringBuilder(getString(2131302543));
              paramm = new com.tencent.mm.plugin.order.c.a(this);
              paramm.prW = new a.a()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(45021);
                  com.tencent.mm.pluginsdk.wallet.h.an(RemittanceDetailUI.this, 0);
                  AppMethodBeat.o(45021);
                }
              };
              paramString.setSpan(paramm, 0, paramString.length(), 18);
              this.orU.setMovementMethod(LinkMovementMethod.getInstance());
              this.orU.setText(paramString);
              this.orU.setVisibility(0);
              break label1404;
            }
            paramString = bi(this.ppE, true) + getString(2131302562);
            this.qpb.setText(j.b(this, paramString, this.qpb.getTextSize()));
            this.orU.setText(2131302573);
            this.orU.setVisibility(0);
            break label1404;
            label1661:
            a(false, false, localx);
          }
          if ((paramInt1 == 2003) && (!bool))
          {
            this.qpa.setImageResource(2131231925);
            if (!bo.isNullOrNil(paramString))
            {
              this.qpb.setText(j.a(this, paramString, (int)this.qpb.getTextSize(), localObject));
              this.qpb.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.m());
              label1737:
              if (bool) {
                break label2227;
              }
              if (bo.isNullOrNil(paramm)) {
                break label2021;
              }
              this.orU.setText(j.a(this, paramm, (int)this.orU.getTextSize(), localObject));
              this.orU.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.m());
              label1787:
              this.orU.setVisibility(0);
            }
          }
          for (;;)
          {
            a(false, false, localx);
            this.qpd.setText(getString(2131302576, new Object[] { com.tencent.mm.wallet_core.ui.e.kB(localx.qku) }));
            this.qpd.setVisibility(0);
            this.qpe.setText(getString(2131302554, new Object[] { com.tencent.mm.wallet_core.ui.e.kB(localx.qkx) }));
            this.qpe.setVisibility(0);
            break;
            this.qpb.setText(2131302566);
            break label1737;
            this.qpa.setImageResource(2131231924);
            if (!bo.isNullOrNil(paramString))
            {
              this.qpb.setText(j.a(this, paramString, (int)this.qpb.getTextSize(), localObject));
              this.qpb.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.m());
              break label1737;
            }
            if (bool)
            {
              this.qpb.setText(2131302564);
              break label1737;
            }
            paramString = bi(this.ppE, true) + getString(2131302564);
            this.qpb.setText(j.b(this, paramString, this.qpb.getTextSize()));
            break label1737;
            label2021:
            if (("CFT".equals(localx.ppN)) || ("LQT".equals(localx.ppN)))
            {
              bool = "LQT".equals(localx.ppN);
              if (bool)
              {
                paramString = getString(2131302558);
                if (!bool) {
                  break label2202;
                }
              }
              for (paramm = getString(2131302546);; paramm = getString(2131302543))
              {
                localObject = new SpannableString(paramString + paramm);
                locala = new com.tencent.mm.plugin.order.c.a(this);
                locala.prW = new RemittanceDetailUI.21(this, bool);
                paramInt1 = paramString.length();
                paramInt2 = paramString.length();
                ((SpannableString)localObject).setSpan(locala, paramInt1, paramm.length() + paramInt2, 33);
                this.orU.setMovementMethod(LinkMovementMethod.getInstance());
                this.orU.setText((CharSequence)localObject);
                break;
                paramString = getString(2131302556);
                break label2075;
              }
            }
            label2075:
            this.orU.setText(2131302557);
            label2202:
            break label1787;
            label2227:
            this.orU.setVisibility(8);
          }
          if (bool)
          {
            this.qpa.setImageResource(2131231926);
            if ((!bo.isNullOrNil(paramString)) && (!bo.isNullOrNil(paramm)))
            {
              this.qpb.setText(j.a(this, paramString, (int)this.qpb.getTextSize(), localObject));
              this.orU.setText(j.a(this, paramm, (int)this.orU.getTextSize(), localObject));
              this.qpb.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.m());
              this.orU.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.m());
            }
          }
          for (;;)
          {
            a(false, false, localx);
            this.qpd.setText(getString(2131302576, new Object[] { com.tencent.mm.wallet_core.ui.e.kB(localx.qku) }));
            this.qpd.setVisibility(0);
            this.qpe.setText(getString(2131302551, new Object[] { com.tencent.mm.wallet_core.ui.e.kB(localx.qkx) }));
            this.qpe.setVisibility(0);
            break;
            if (!bo.isNullOrNil(localx.qky)) {
              this.qpb.setText(localx.qky);
            }
            for (;;)
            {
              if (bo.isNullOrNil(localx.qkz)) {
                break label2489;
              }
              this.orU.setText(localx.qkz);
              break;
              this.qpb.setText(2131302563);
            }
            label2489:
            this.orU.setText(2131302553);
            continue;
            this.qpa.setImageResource(2131231926);
            if ((!bo.isNullOrNil(paramString)) && (!bo.isNullOrNil(paramm)))
            {
              this.qpb.setText(j.a(this, paramString, (int)this.qpb.getTextSize(), localObject));
              this.orU.setText(j.a(this, paramm, (int)this.orU.getTextSize(), localObject));
              this.qpb.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.m());
              this.orU.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.m());
            }
            else
            {
              if (!bo.isNullOrNil(localx.qky)) {}
              for (;;)
              {
                try
                {
                  this.qpb.setText(String.format(localx.qky, new Object[] { bi(this.ppE, true) }));
                  if (bo.isNullOrNil(localx.qkz)) {
                    break label2716;
                  }
                  this.orU.setText(localx.qkz);
                }
                catch (Exception paramString)
                {
                  ab.printErrStackTrace("MicroMsg.RemittanceDetailUI", paramString, "", new Object[0]);
                }
                this.qpb.setText(getString(2131302565, new Object[] { bi(this.ppE, true) }));
              }
              label2716:
              this.orU.setText("");
            }
          }
          this.qpa.setImageResource(2131231922);
          if ((!bo.isNullOrNil(paramString)) && (!bo.isNullOrNil(paramm)))
          {
            this.qpb.setText(j.a(this, paramString, (int)this.qpb.getTextSize(), localObject));
            this.orU.setText(j.a(this, paramm, (int)this.orU.getTextSize(), localObject));
            this.qpb.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.m());
            this.orU.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.m());
          }
          for (;;)
          {
            a(false, false, localx);
            this.qpd.setText(getString(2131302576, new Object[] { com.tencent.mm.wallet_core.ui.e.kB(localx.qku) }));
            this.qpd.setVisibility(0);
            if (localx.qkx <= 0) {
              break label3172;
            }
            this.qpe.setText(getString(2131302542, new Object[] { com.tencent.mm.wallet_core.ui.e.kB(localx.qkx) }));
            this.qpe.setVisibility(0);
            break;
            if (!bo.isNullOrNil(localx.qky))
            {
              this.qpb.setText(localx.qky);
              label2943:
              if (bo.isNullOrNil(localx.qkz)) {
                break label3141;
              }
              if ((!"CFT".equals(localx.ppN)) && (!"LQT".equals(localx.ppN))) {
                break label3126;
              }
              bool = "LQT".equals(localx.ppN);
              paramm = localx.qkz;
              if (!bool) {
                break label3115;
              }
            }
            label3115:
            for (paramString = getString(2131302546);; paramString = getString(2131302543))
            {
              localObject = new SpannableStringBuilder();
              ((SpannableStringBuilder)localObject).append(paramm);
              ((SpannableStringBuilder)localObject).append(paramString);
              paramString = new com.tencent.mm.plugin.order.c.a(this);
              paramString.prW = new a.a()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(45023);
                  if (bool)
                  {
                    d.H(RemittanceDetailUI.this, "wallet", ".balance.ui.lqt.WalletLqtDetailUI");
                    AppMethodBeat.o(45023);
                    return;
                  }
                  com.tencent.mm.pluginsdk.wallet.h.an(RemittanceDetailUI.this, 0);
                  AppMethodBeat.o(45023);
                }
              };
              ((SpannableStringBuilder)localObject).setSpan(paramString, paramm.length(), ((SpannableStringBuilder)localObject).length(), 18);
              this.orU.setMovementMethod(LinkMovementMethod.getInstance());
              this.orU.setText((CharSequence)localObject);
              break;
              this.qpb.setText(2131302561);
              break label2943;
            }
            label3126:
            this.orU.setText(localx.qkz);
            continue;
            label3141:
            if (bool) {
              this.orU.setText(2131302552);
            } else {
              this.orU.setText(2131302572);
            }
          }
          label3172:
          this.qpe.setVisibility(8);
          break label344;
          ah.a(false, this.mNetSceneMgr);
          break label465;
          label3196:
          paramInt1 = 2131305584;
          break label524;
          label3203:
          if (this.qpT == 0) {
            com.tencent.mm.ui.base.h.bO(getContext(), getString(2131302549));
          }
        }
      }
    }
    else
    {
      if ((paramm instanceof u))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          this.qpU = ((u)paramm);
          if ((this.qpU.isJumpRemind()) && (this.qpU.getJumpRemind().a(this, new RemittanceDetailUI.16(this))))
          {
            AppMethodBeat.o(45041);
            return true;
          }
          a(this.qpU);
          AppMethodBeat.o(45041);
          return true;
        }
        if (paramInt2 == 416)
        {
          paramString = new Bundle();
          paramString.putString("realname_verify_process_jump_plugin", "remittance");
          paramString.putString("realname_verify_process_jump_activity", ".ui.RemittanceDetailUI");
          bool = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, paramInt2, paramm, paramString, 1008);
          AppMethodBeat.o(45041);
          return bool;
        }
        aZ(paramInt2, paramString);
        AppMethodBeat.o(45041);
        return true;
      }
      if ((paramm instanceof ah))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          this.qlM = ((ah)paramm).ucj;
          this.qlN = ((ah)paramm).uck;
          chi();
        }
        for (;;)
        {
          AppMethodBeat.o(45041);
          return true;
          ab.i("MicroMsg.RemittanceDetailUI", "net error");
        }
      }
    }
    if ((paramm instanceof com.tencent.mm.plugin.wallet_core.id_verify.model.e))
    {
      AppMethodBeat.o(45041);
      return true;
    }
    AppMethodBeat.o(45041);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI
 * JD-Core Version:    0.7.0.1
 */