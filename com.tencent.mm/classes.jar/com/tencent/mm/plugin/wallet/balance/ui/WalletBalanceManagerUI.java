package com.tencent.mm.plugin.wallet.balance.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cm.f;
import com.tencent.mm.g.a.vd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ECardInfo;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.ak;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.d;
import com.tencent.mm.plugin.wallet_core.model.j;
import com.tencent.mm.plugin.wallet_core.model.n;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.protocal.protobuf.ba;
import com.tencent.mm.protocal.protobuf.bry;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.ui.q.b;
import com.tencent.mm.wallet_core.c.ae;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import org.json.JSONException;
import org.json.JSONObject;

public class WalletBalanceManagerUI
  extends WalletBaseUI
  implements n
{
  protected int mScene;
  protected TextView tNM;
  private ViewGroup tOA;
  private TextView tOB;
  private ImageView tOC;
  protected Bankcard tOD;
  private ba tOE;
  private j tOF;
  private com.tencent.mm.plugin.wallet.balance.a.a tOG;
  private d tOH;
  private ProgressBar tOI;
  protected TextView tOw;
  protected Button tOx;
  protected View tOy;
  protected TextView tOz;
  
  private boolean cRf()
  {
    AppMethodBeat.i(45450);
    s.cRG();
    if ((s.cRH().cUt().cRf()) && (this.tOD.ufM > 0.0D))
    {
      AppMethodBeat.o(45450);
      return true;
    }
    AppMethodBeat.o(45450);
    return false;
  }
  
  private void cRg()
  {
    AppMethodBeat.i(142288);
    if (this.tOF != null)
    {
      if (!bo.isNullOrNil(this.tOF.cyA))
      {
        this.tOB.setText(this.tOF.cyA);
        if (!bo.isNullOrNil(this.tOF.color))
        {
          this.tOB.setTextColor(Color.parseColor(this.tOF.color));
          Drawable localDrawable = this.tOC.getDrawable();
          if (localDrawable != null) {
            localDrawable.setColorFilter(Color.parseColor(this.tOF.color), PorterDuff.Mode.SRC_ATOP);
          }
        }
        this.tOA.setOnClickListener(new WalletBalanceManagerUI.5(this));
        this.tOA.setVisibility(0);
        AppMethodBeat.o(142288);
        return;
      }
      this.tOA.setVisibility(8);
      AppMethodBeat.o(142288);
      return;
    }
    this.tOA.setVisibility(8);
    AppMethodBeat.o(142288);
  }
  
  protected final void bJ()
  {
    AppMethodBeat.i(45448);
    s.cRG();
    this.tOD = s.cRH().tOD;
    if (this.tOD != null)
    {
      if (this.tOD.ufM >= 0.0D)
      {
        this.tOw.setText(com.tencent.mm.wallet_core.ui.e.F(this.tOD.ufM));
        if (!cRf()) {
          break label224;
        }
        this.tOx.setVisibility(0);
      }
    }
    else
    {
      label70:
      localObject = findViewById(2131825956);
      g.RM();
      if (((Integer)g.RL().Ru().get(ac.a.yHk, Integer.valueOf(-1))).intValue() != 1) {
        break label236;
      }
      ((View)localObject).setVisibility(0);
    }
    for (;;)
    {
      if (!new ak().cUi()) {
        break label245;
      }
      g.RM();
      localObject = (String)g.RL().Ru().get(ac.a.yCw, getString(2131302324));
      this.tOy.setVisibility(0);
      this.tOz.setTextColor(getResources().getColor(2131690635));
      this.tOz.setText((CharSequence)localObject);
      this.tOy.setOnClickListener(new WalletBalanceManagerUI.14(this));
      AppMethodBeat.o(45448);
      return;
      this.tOw.setText(getString(2131305111));
      break;
      label224:
      this.tOx.setVisibility(8);
      break label70;
      label236:
      ((View)localObject).setVisibility(8);
    }
    label245:
    s.cRG();
    if (s.cRH().cUR() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      s.cRG();
      localObject = s.cRH().cUS();
      s.cRG();
      String str = s.cRH().cUT();
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletBalanceManagerUI", "isShowLqtCell:%s lqtCellTitle:%s lqtCellWording:%s", new Object[] { Boolean.valueOf(bool), localObject, str });
      if ((bool) && ((!bo.isNullOrNil((String)localObject)) || (!bo.isNullOrNil(str)))) {
        break label487;
      }
      s.cRG();
      if (!s.cRH().cUA()) {
        break;
      }
      this.tOy.setVisibility(0);
      this.tOy.setOnClickListener(new WalletBalanceManagerUI.15(this));
      localObject = this.tOz;
      s.cRG();
      ((TextView)localObject).setText(s.cRH().cUw());
      AppMethodBeat.o(45448);
      return;
    }
    s.cRG();
    Object localObject = s.cRH();
    if ((localObject != null) && (((am)localObject).cUt().cUe()) && (!TextUtils.isEmpty(((am)localObject).cUw())) && (!TextUtils.isEmpty(((am)localObject).cUx())))
    {
      this.tOy.setVisibility(0);
      this.tOz.setText(((am)localObject).cUw());
      this.tOy.setOnClickListener(new WalletBalanceManagerUI.2(this, (am)localObject));
      AppMethodBeat.o(45448);
      return;
    }
    this.tOy.setVisibility(8);
    label487:
    AppMethodBeat.o(45448);
  }
  
  protected void cRd()
  {
    AppMethodBeat.i(45443);
    this.tOH.b(new WalletBalanceManagerUI.9(this));
    AppMethodBeat.o(45443);
  }
  
  protected void cRe()
  {
    AppMethodBeat.i(45445);
    startActivity(WalletBalanceSaveUI.class);
    AppMethodBeat.o(45445);
  }
  
  protected final void cfA()
  {
    AppMethodBeat.i(45449);
    removeAllOptionMenu();
    try
    {
      String str1 = (String)g.RL().Ru().get(ac.a.yIQ, "");
      if (!bo.isNullOrNil(str1))
      {
        bool = new JSONObject(str1).optBoolean("is_show_menu", false);
        if (!bool) {
          break label129;
        }
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletBalanceManagerUI", "go new menu logic");
        if (this.tOE != null) {
          break label106;
        }
        com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.WalletBalanceManagerUI", "actionsheet is null");
        AppMethodBeat.o(45449);
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.WalletBalanceManagerUI", localJSONException, "", new Object[0]);
        boolean bool = false;
      }
      label106:
      addIconOptionMenu(0, 2131230740, new WalletBalanceManagerUI.3(this));
      AppMethodBeat.o(45449);
      return;
    }
    label129:
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletBalanceManagerUI", "go old menu logic");
    if (this.tOD != null)
    {
      s.cRG();
      s.cRH();
      if (!bo.isNullOrNil(this.tOD.ufP))
      {
        String str2 = getString(2131304821);
        if (!bo.isNullOrNil(this.tOD.ufR))
        {
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletBalanceManagerUI", "carson: entry_word：%s", new Object[] { this.tOD.ufR });
          str2 = this.tOD.ufR;
        }
        addTextOptionMenu(0, str2, new WalletBalanceManagerUI.4(this), q.b.zbH);
      }
    }
    AppMethodBeat.o(45449);
  }
  
  public int getLayoutId()
  {
    return 2130971129;
  }
  
  public void initView()
  {
    AppMethodBeat.i(45446);
    setMMTitle("");
    this.tOw = ((TextView)findViewById(2131828951));
    this.tOI = ((ProgressBar)findViewById(2131828952));
    this.tNM = ((TextView)findViewById(2131828936));
    ((Button)findViewById(2131822914)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(45436);
        WalletBalanceManagerUI.this.cRe();
        com.tencent.mm.wallet_core.ui.e.RX(14);
        AppMethodBeat.o(45436);
      }
    });
    this.tOx = ((Button)findViewById(2131828956));
    this.tOx.setOnClickListener(new WalletBalanceManagerUI.11(this));
    Object localObject = (TextView)findViewById(2131828959);
    boolean bool;
    if (!aa.dsG().equals("zh_CN"))
    {
      bool = true;
      if (bool) {
        break label289;
      }
      ((TextView)localObject).setOnClickListener(new WalletBalanceManagerUI.12(this));
      ((TextView)localObject).setVisibility(0);
    }
    for (;;)
    {
      ((TextView)findViewById(2131828960)).setText(ae.dSy());
      this.tOA = ((ViewGroup)findViewById(2131828953));
      this.tOB = ((TextView)findViewById(2131828954));
      this.tOC = ((ImageView)findViewById(2131828955));
      this.tOy = findViewById(2131828957);
      this.tOz = ((TextView)findViewById(2131828958));
      localObject = new vd();
      ((vd)localObject).cLE.bSd = "2";
      ((vd)localObject).callback = new WalletBalanceManagerUI.13(this, (vd)localObject);
      com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
      AppMethodBeat.o(45446);
      return;
      bool = bo.hl(ah.getContext());
      break;
      label289:
      ((TextView)localObject).setVisibility(8);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(45442);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(2131690709));
    hideActionbarLine();
    ((com.tencent.mm.plugin.walletlock.a.b)g.E(com.tencent.mm.plugin.walletlock.a.b.class)).a(this, null);
    setBackBtn(new WalletBalanceManagerUI.1(this), 2131230737);
    this.mScene = getIntent().getIntExtra("key_scene_balance_manager", 0);
    paramBundle = ECardInfo.cTt();
    if (paramBundle != null)
    {
      if (paramBundle.wkQ != 1) {
        break label203;
      }
      paramBundle = new Bundle();
      isTransparent();
      com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, paramBundle, null, 0);
    }
    for (;;)
    {
      addSceneEndListener(621);
      t.cTU();
      ag.a(this);
      initView();
      this.tOH = new d(this.tOw, this.tOI, 10);
      com.tencent.mm.wallet_core.c.z.id(2, 0);
      h.qsU.e(11850, new Object[] { Integer.valueOf(6), Integer.valueOf(0) });
      com.tencent.mm.wallet_core.ui.e.RX(10);
      AppMethodBeat.o(45442);
      return;
      label203:
      if (paramBundle.wkQ == 3)
      {
        paramBundle = ECardInfo.cTu();
        if (paramBundle != null) {
          com.tencent.mm.plugin.wallet_core.ui.m.a(this, paramBundle, 1);
        }
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(45444);
    removeSceneEndListener(621);
    t.cTU();
    ag.b(this);
    this.tOH.release();
    this.tOG = null;
    super.onDestroy();
    AppMethodBeat.o(45444);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(45453);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletBalanceManagerUI", "jumpFethProcess from bind ui flag:" + paramIntent.getIntExtra("from_bind_ui", 0));
    if (paramIntent.getIntExtra("from_bind_ui", 0) == com.tencent.mm.plugin.wallet.balance.a.tLU)
    {
      com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.balance.b.class, null, null);
      com.tencent.mm.wallet_core.ui.e.RX(15);
    }
    AppMethodBeat.o(45453);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(45447);
    bJ();
    cRd();
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletBalanceManagerUI", "do query balance menu");
    if (this.tOG != null) {
      this.tOG.cancel();
    }
    this.tOG = new com.tencent.mm.plugin.wallet.balance.a.a();
    this.tOG.adl().b(new WalletBalanceManagerUI.8(this));
    super.onResume();
    com.tencent.mm.plugin.walletlock.a.b localb = (com.tencent.mm.plugin.walletlock.a.b)g.E(com.tencent.mm.plugin.walletlock.a.b.class);
    localb.a(this, localb.cXt(), null);
    AppMethodBeat.o(45447);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(45451);
    if ((paramInt1 == 0) && (paramInt2 == 0) && (!(paramm instanceof com.tencent.mm.plugin.wallet.bind.a.b)) && ((paramm instanceof com.tencent.mm.plugin.wallet_core.c.ab)))
    {
      this.tOF = ((com.tencent.mm.plugin.wallet_core.c.ab)paramm).ucb;
      cRg();
      bJ();
      cfA();
    }
    AppMethodBeat.o(45451);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void yO(int paramInt)
  {
    AppMethodBeat.i(45452);
    s.cRG();
    this.tOD = s.cRH().tOD;
    if (this.tOD != null)
    {
      if (this.tOD.ufM >= 0.0D)
      {
        this.tOw.setText(com.tencent.mm.wallet_core.ui.e.F(this.tOD.ufM));
        AppMethodBeat.o(45452);
        return;
      }
      this.tOw.setText(getString(2131305111));
    }
    AppMethodBeat.o(45452);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI
 * JD-Core Version:    0.7.0.1
 */