package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet.balance.a.a.ac;
import com.tencent.mm.plugin.wallet.balance.a.a.q;
import com.tencent.mm.plugin.wallet.balance.a.a.r;
import com.tencent.mm.plugin.wallet.balance.a.a.r.a;
import com.tencent.mm.plugin.wallet.balance.a.a.r.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.bdf;
import com.tencent.mm.protocal.protobuf.bfx;
import com.tencent.mm.protocal.protobuf.bpw;
import com.tencent.mm.protocal.protobuf.yp;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.vending.g.c;
import com.tencent.mm.vending.g.f;
import com.tencent.mm.wallet_core.c.y;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.e;
import java.io.IOException;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class WalletLqtDetailUI
  extends WalletLqtBasePresenterUI
{
  private static final int kzk;
  private Dialog gpx;
  private ak handler;
  private ProgressBar oAZ;
  private View tPA;
  private TextView tPB;
  private View tPC;
  private View tPD;
  private CdnImageView tPE;
  private TextView tPF;
  private TextView tPG;
  private LinearLayout tPH;
  private TextView tPI;
  private TextView tPJ;
  private TextView tPK;
  private TextView tPL;
  private ViewGroup tPM;
  private boolean tPN;
  private WalletLqtDetailUI.a tPO;
  private boolean tPP;
  private q tPj;
  private r tPk;
  private bpw tPl;
  private ViewGroup tPm;
  private TextView tPn;
  private WalletTextView tPo;
  private ViewGroup tPp;
  private TextView tPq;
  private TextView tPr;
  private ViewGroup tPs;
  private TextView tPt;
  private WalletTextView tPu;
  private Button tPv;
  private Button tPw;
  private LinearLayout tPx;
  private TextView tPy;
  private TextView tPz;
  
  static
  {
    AppMethodBeat.i(45557);
    kzk = com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 16);
    AppMethodBeat.o(45557);
  }
  
  public WalletLqtDetailUI()
  {
    AppMethodBeat.i(45545);
    this.tPj = ((q)T(q.class));
    this.tPk = ((r)P(r.class));
    this.tPN = true;
    this.handler = new ak(Looper.getMainLooper());
    this.tPP = false;
    AppMethodBeat.o(45545);
  }
  
  private void Ij(int paramInt)
  {
    AppMethodBeat.i(142300);
    ab.i("MicroMsg.WalletLqtDetailUI", "fetch detail: %s", new Object[] { Integer.valueOf(paramInt) });
    if (this.tPk == null)
    {
      AppMethodBeat.o(142300);
      return;
    }
    this.tPk.tMG.aoV().f(new WalletLqtDetailUI.12(this)).a(new WalletLqtDetailUI.1(this, paramInt));
    AppMethodBeat.o(142300);
  }
  
  private void aeS(String paramString)
  {
    boolean bool2 = true;
    AppMethodBeat.i(45549);
    ab.i("MicroMsg.WalletLqtDetailUI", "go to save ui");
    Intent localIntent = new Intent(this, WalletLqtSaveFetchUI.class);
    String str;
    if (this.tPl != null)
    {
      str = this.tPl.xCP;
      localIntent.putExtra("lqt_save_fund_code", str);
      localIntent.putExtra("lqt_save_fetch_mode", 1);
      if (this.tPl.cMb != 1) {
        break label197;
      }
      bool1 = true;
      label75:
      localIntent.putExtra("lqt_is_show_protocol", bool1);
      if (this.tPl.xDQ != 1) {
        break label202;
      }
    }
    label197:
    label202:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localIntent.putExtra("lqt_is_agree_protocol", bool1);
      localIntent.putStringArrayListExtra("lqt_protocol_list", cRm());
      localIntent.putExtra("lqt_profile_wording", this.tPl.xDJ);
      localIntent.putExtra("lqt_account_type", this.tPl.wMx);
      localIntent.putExtra("lqt_fund_spid", this.tPl.xCR);
      localIntent.putExtra("operate_id", paramString);
      startActivity(localIntent);
      AppMethodBeat.o(45549);
      return;
      str = null;
      break;
      bool1 = false;
      break label75;
    }
  }
  
  private void aeT(String paramString)
  {
    AppMethodBeat.i(45550);
    ab.i("MicroMsg.WalletLqtDetailUI", "go to fetch ui");
    Intent localIntent = new Intent(this, WalletLqtSaveFetchUI.class);
    localIntent.putExtra("lqt_save_fetch_mode", 2);
    localIntent.putExtra("lqt_balance", this.tPl.xwl);
    localIntent.putExtra("lqt_max_redeem_amount", this.tPl.xDX);
    localIntent.putExtra("lqt_redeem_invalid_amount_hint", this.tPl.xDY);
    localIntent.putExtra("lqt_account_type", this.tPl.wMx);
    localIntent.putExtra("operate_id", paramString);
    startActivity(localIntent);
    AppMethodBeat.o(45550);
  }
  
  private void bMz()
  {
    AppMethodBeat.i(142302);
    removeAllOptionMenu();
    if (this.tPl != null)
    {
      if ((this.tPl.xEn != null) && (this.tPl.xEn.size() == 1) && (this.tPl.xEa))
      {
        ab.i("MicroMsg.WalletLqtDetailUI", "show text menu");
        bfx localbfx = (bfx)this.tPl.xEn.get(0);
        addTextOptionMenu(0, localbfx.title, new WalletLqtDetailUI.9(this, localbfx));
        AppMethodBeat.o(142302);
        return;
      }
      addIconOptionMenu(0, 2130839668, new WalletLqtDetailUI.10(this));
    }
    AppMethodBeat.o(142302);
  }
  
  private void bOb()
  {
    AppMethodBeat.i(142301);
    Object localObject1;
    if (this.tPl != null)
    {
      this.tPo.setText(e.E(e.b(this.tPl.xwl, "100", RoundingMode.HALF_UP)));
      localObject1 = (ImageView)findViewById(2131829168);
      label118:
      int i;
      label264:
      label299:
      label342:
      Object localObject2;
      ViewGroup localViewGroup;
      TextView localTextView1;
      TextView localTextView2;
      if (localObject1 != null)
      {
        if (!bo.isNullOrNil(this.tPl.xEb)) {
          ((ImageView)localObject1).setVisibility(0);
        }
      }
      else
      {
        localObject1 = (ImageView)findViewById(2131829173);
        if (localObject1 != null)
        {
          if (bo.isNullOrNil(this.tPl.xEb)) {
            break label530;
          }
          ((ImageView)localObject1).setVisibility(0);
        }
        this.tPp.setOnClickListener(new WalletLqtDetailUI.14(this));
        this.tPq.setText(this.tPl.xDL);
        this.tPr.setText(this.tPl.xDM);
        this.tPt.setText(this.tPl.xDN);
        this.tPu.setText(e.F(e.b(this.tPl.xDO, "100", RoundingMode.HALF_UP)));
        this.tPs.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(45539);
            if (!bo.isNullOrNil(WalletLqtDetailUI.e(WalletLqtDetailUI.this).xEc))
            {
              e.m(WalletLqtDetailUI.this, WalletLqtDetailUI.e(WalletLqtDetailUI.this).xEc, false);
              h.qsU.e(17084, new Object[] { Integer.valueOf(2) });
            }
            AppMethodBeat.o(45539);
          }
        });
        if (bo.isNullOrNil(this.tPl.xEe)) {
          break label539;
        }
        this.tPJ.setText(this.tPl.xEe);
        this.tPJ.setVisibility(0);
        if (bo.isNullOrNil(this.tPl.xEk)) {
          break label550;
        }
        this.tPK.setText(this.tPl.xEk);
        this.tPK.setVisibility(0);
        this.tPx.removeAllViews();
        if ((this.tPl.xEd == null) || (this.tPl.xEd.isEmpty())) {
          break label656;
        }
        localObject1 = this.tPl.xEd.iterator();
        i = 0;
        if (!((Iterator)localObject1).hasNext()) {
          break label834;
        }
        localObject2 = (bfx)((Iterator)localObject1).next();
        localViewGroup = (ViewGroup)getLayoutInflater().inflate(2130970004, this.tPx, false);
        localTextView1 = (TextView)localViewGroup.findViewById(2131825493);
        localTextView2 = (TextView)localViewGroup.findViewById(2131825494);
        View localView = localViewGroup.findViewById(2131825495);
        if (i == this.tPl.xEd.size() - 1) {
          localView.setVisibility(8);
        }
        localTextView1.setText(((bfx)localObject2).title);
        localTextView2.setText(((bfx)localObject2).desc);
        if (((bfx)localObject2).xuO != 1) {
          break label561;
        }
        if (((bfx)localObject2).xuN == 1) {
          localViewGroup.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(45540);
              ab.i("MicroMsg.WalletLqtDetailUI", "go to lqt plan home");
              paramAnonymousView = new Intent(WalletLqtDetailUI.this.getContext(), WalletLqtPlanHomeUI.class);
              WalletLqtDetailUI.this.startActivity(paramAnonymousView);
              h.qsU.e(16807, new Object[] { Integer.valueOf(2), Integer.valueOf(1), "", "", Integer.valueOf(this.tPW.xuN) });
              AppMethodBeat.o(45540);
            }
          });
        }
      }
      for (;;)
      {
        localObject2 = new LinearLayout.LayoutParams(-1, -2, -1.0F);
        this.tPx.addView(localViewGroup, (ViewGroup.LayoutParams)localObject2);
        i += 1;
        break label342;
        ((ImageView)localObject1).setVisibility(8);
        break;
        label530:
        ((ImageView)localObject1).setVisibility(8);
        break label118;
        label539:
        this.tPJ.setVisibility(4);
        break label264;
        label550:
        this.tPK.setVisibility(4);
        break label299;
        label561:
        if (((bfx)localObject2).xuO == 2)
        {
          if (!bo.isNullOrNil(((bfx)localObject2).wPJ))
          {
            localViewGroup.setTag(((bfx)localObject2).wPJ);
            localViewGroup.setOnClickListener(new WalletLqtDetailUI.17(this, localViewGroup, (bfx)localObject2));
          }
        }
        else if ((((bfx)localObject2).xuO == 3) && (!bo.isNullOrNil(((bfx)localObject2).wFW)) && (!bo.isNullOrNil(((bfx)localObject2).wPJ))) {
          localViewGroup.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(45542);
              e.q(this.tPW.wFW, this.tPW.wPJ, 0, 1061);
              h.qsU.e(16807, new Object[] { Integer.valueOf(2), Integer.valueOf(2), this.tPW.wPJ, this.tPW.wFW });
              AppMethodBeat.o(45542);
            }
          });
        }
      }
      label656:
      if ((this.tPl.xDP != null) && (this.tPl.xDP.size() > 0))
      {
        localObject1 = this.tPl.xDP.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (yp)((Iterator)localObject1).next();
          localViewGroup = (ViewGroup)getLayoutInflater().inflate(2130970004, this.tPx, false);
          localTextView1 = (TextView)localViewGroup.findViewById(2131825493);
          localTextView2 = (TextView)localViewGroup.findViewById(2131825494);
          localTextView1.setText(((yp)localObject2).title);
          localTextView2.setText(((yp)localObject2).desc);
          if (!bo.isNullOrNil(((yp)localObject2).wPJ))
          {
            localViewGroup.setTag(((yp)localObject2).wPJ);
            localViewGroup.setOnClickListener(new WalletLqtDetailUI.19(this, localViewGroup));
          }
          localObject2 = new LinearLayout.LayoutParams(-1, -2, -1.0F);
          this.tPx.addView(localViewGroup, (ViewGroup.LayoutParams)localObject2);
        }
      }
      label834:
      if (this.tPx.getChildCount() == 0)
      {
        localObject1 = findViewById(2131829178);
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(4);
        }
      }
      this.tPm.setVisibility(0);
      if (this.tPl.xwl > 0) {
        break label1435;
      }
      this.tPw.setEnabled(false);
      if (b.dsf()) {
        this.tPw.setEnabled(true);
      }
      if (bo.isNullOrNil(this.tPl.xEl)) {
        break label1446;
      }
      this.tPL.setText(this.tPl.xEl);
      e.aE(this.tPL, 50);
      this.tPL.setOnClickListener(new WalletLqtDetailUI.20(this));
      this.tPL.setVisibility(0);
      localObject1 = findViewById(2131829186);
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(0);
      }
      this.tPy.setGravity(3);
      this.tPy.setPadding(com.tencent.mm.cb.a.fromDPToPix(getContext(), 5), 0, 0, 0);
      label1003:
      if (this.tPl.xDS != null)
      {
        this.tPy.setText(this.tPl.xDS.title);
        this.tPy.setOnClickListener(new WalletLqtDetailUI.2(this));
      }
      this.tPA.setVisibility(8);
      if ((this.tPl.xDU != null) && (!bo.isNullOrNil(this.tPl.xDU.title)))
      {
        this.tPA.setVisibility(0);
        this.tPB.setText(this.tPl.xDU.title);
        if (!bo.isNullOrNil(this.tPl.xDU.wPJ)) {
          this.tPA.setOnClickListener(new WalletLqtDetailUI.3(this));
        }
      }
      this.tPD.setVisibility(8);
      this.tPC.setVisibility(8);
      if ((this.tPl.xDV != null) && (!bo.isNullOrNil(this.tPl.xDV.username)))
      {
        this.tPE.setUrl(this.tPl.xDV.kmm);
        this.tPF.setText(this.tPl.xDV.title);
        this.tPG.setText(this.tPl.xDV.desc);
        this.tPD.setOnClickListener(new WalletLqtDetailUI.4(this));
        this.tPC.setVisibility(0);
        this.tPD.setVisibility(0);
      }
      this.tPy.setVisibility(0);
      if (bo.isNullOrNil(this.tPl.tMu)) {
        break label1495;
      }
      this.tPz.setText(this.tPl.tMu);
      label1297:
      if ((this.tPl.xEh == null) || (bo.isNullOrNil(this.tPl.xEh.title))) {
        break label1543;
      }
      this.tPH.setVisibility(0);
      this.tPI.setText(this.tPl.xEh.title);
      this.tPH.setOnClickListener(new WalletLqtDetailUI.5(this));
    }
    for (;;)
    {
      this.tPv.setOnClickListener(new WalletLqtDetailUI.6(this));
      this.tPw.setOnClickListener(new WalletLqtDetailUI.7(this));
      if ((this.tPl.xoA) && (this.tPl.xwr != null)) {
        ac.a(this, this.tPl.xwr);
      }
      bMz();
      AppMethodBeat.o(142301);
      return;
      label1435:
      this.tPw.setEnabled(true);
      break;
      label1446:
      this.tPL.setVisibility(8);
      localObject1 = findViewById(2131829186);
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(0);
      }
      this.tPy.setGravity(17);
      this.tPy.setPadding(0, 0, 0, 0);
      break label1003;
      label1495:
      if (this.tPl.wMx == 1)
      {
        this.tPz.setText(2131305191);
        break label1297;
      }
      if (this.tPl.wMx != 2) {
        break label1297;
      }
      this.tPz.setText(2131305192);
      break label1297;
      label1543:
      this.tPH.setVisibility(8);
    }
  }
  
  private ArrayList<String> cRm()
  {
    AppMethodBeat.i(45547);
    ArrayList localArrayList = new ArrayList();
    if ((this.tPl.xDR != null) && (this.tPl.xDR.size() > 0))
    {
      Iterator localIterator = this.tPl.xDR.iterator();
      while (localIterator.hasNext())
      {
        yp localyp = (yp)localIterator.next();
        if ((!bo.isNullOrNil(localyp.title)) && (!bo.isNullOrNil(localyp.wPJ))) {
          localArrayList.add(String.format("%s||%s", new Object[] { localyp.title, localyp.wPJ }));
        }
      }
    }
    AppMethodBeat.o(45547);
    return localArrayList;
  }
  
  public int getLayoutId()
  {
    return 2130971197;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(45551);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 123) && (paramInt2 == -1))
    {
      this.tPN = false;
      paramIntent = paramIntent.getStringExtra("lqt_enc_pwd");
      if (this.gpx != null) {
        break label118;
      }
      this.gpx = com.tencent.mm.wallet_core.ui.g.c(this, false, null);
    }
    for (;;)
    {
      r.a locala = this.tPk.tMH;
      f.A(paramIntent, Integer.valueOf(this.tPl.wMx)).c(locala).f(new WalletLqtDetailUI.13(this)).a(new WalletLqtDetailUI.11(this));
      AppMethodBeat.o(45551);
      return;
      label118:
      this.gpx.show();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(45546);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(2131690651));
    setActionbarElementColor(getResources().getColor(2131690709));
    hideActionbarLine();
    setMMTitle("");
    ab.i("MicroMsg.WalletLqtDetailUI", "inputAccountType: %s", new Object[] { Integer.valueOf(getIntent().getIntExtra("key_account_type", 1)) });
    this.tPm = ((ViewGroup)findViewById(2131829155));
    this.tPn = ((TextView)findViewById(2131829156));
    this.tPo = ((WalletTextView)findViewById(2131829164));
    this.tPp = ((ViewGroup)findViewById(2131829166));
    this.tPq = ((TextView)findViewById(2131829167));
    this.tPr = ((TextView)findViewById(2131829169));
    this.tPs = ((ViewGroup)findViewById(2131829171));
    this.tPt = ((TextView)findViewById(2131829172));
    this.tPu = ((WalletTextView)findViewById(2131829174));
    this.tPv = ((Button)findViewById(2131829176));
    this.tPw = ((Button)findViewById(2131829177));
    this.tPx = ((LinearLayout)findViewById(2131829179));
    this.tPy = ((TextView)findViewById(2131829187));
    this.tPA = findViewById(2131825518);
    this.tPB = ((TextView)findViewById(2131825519));
    this.tPD = findViewById(2131829181);
    this.tPE = ((CdnImageView)findViewById(2131829182));
    this.tPF = ((TextView)findViewById(2131829183));
    this.tPG = ((TextView)findViewById(2131829184));
    this.tPC = findViewById(2131829180);
    this.tPz = ((TextView)findViewById(2131829188));
    this.tPH = ((LinearLayout)findViewById(2131829159));
    this.tPI = ((TextView)findViewById(2131829160));
    this.tPJ = ((TextView)findViewById(2131829170));
    this.tPK = ((TextView)findViewById(2131829175));
    this.tPL = ((TextView)findViewById(2131829185));
    this.tPM = ((ViewGroup)findViewById(2131829162));
    this.oAZ = ((ProgressBar)findViewById(2131829165));
    this.tPy.setVisibility(4);
    this.tPO = new WalletLqtDetailUI.a(this, (byte)0);
    AppMethodBeat.o(45546);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(45552);
    super.onDestroy();
    this.tPj = null;
    this.tPk = null;
    AppMethodBeat.o(45552);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(45548);
    super.onResume();
    if (this.tPN) {}
    try
    {
      String str = (String)((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(ac.a.yJs, "");
      if (!bo.isNullOrNil(str))
      {
        this.tPl = ((bpw)new bpw().parseFrom(str.getBytes(org.apache.commons.a.a.ISO_8859_1)));
        bOb();
      }
      this.tPO.b(null);
      Ij(0);
      this.tPN = true;
      AppMethodBeat.o(45548);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.WalletLqtDetailUI", localIOException, "", new Object[0]);
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI
 * JD-Core Version:    0.7.0.1
 */