package com.tencent.mm.plugin.remittance.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.vk;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.t.v;
import com.tencent.mm.plugin.fingerprint.b.i;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.pu;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.e;
import java.util.List;

@com.tencent.mm.ui.base.a(19)
public class RemittanceResultNewUI
  extends RemittanceResultUI
{
  private static int[] qrt = null;
  private int jUm;
  private int jUn;
  private com.tencent.mm.ui.widget.c.a jVd;
  private n.d lNZ;
  private View.OnTouchListener mAc;
  private View.OnLongClickListener mAd;
  private int mPayScene;
  private String mReceiverName;
  private PayInfo pVo;
  private LinearLayout qlB;
  private d.a.a.c qnc;
  private WalletSuccPageAwardWidget qnd;
  private boolean qni;
  private com.tencent.mm.sdk.b.c<vk> qnj;
  private int qpX;
  private LinearLayout qph;
  private LinearLayout qpi;
  private LinearLayout qpj;
  private TextView qpk;
  private TextView qpl;
  private TextView qpm;
  private TextView qpn;
  private TextView qpo;
  private Orders qrf;
  private boolean qrg;
  private TextView qrh;
  private ViewGroup qri;
  private TextView qrj;
  private WalletTextView qrk;
  private ViewGroup qrl;
  private ViewGroup qrm;
  private ViewGroup qrn;
  private TextView qro;
  private TextView qrp;
  private WalletTextView qrq;
  private pu qrr;
  private Button qrs;
  
  public RemittanceResultNewUI()
  {
    AppMethodBeat.i(45123);
    this.qni = false;
    this.qnj = new RemittanceResultNewUI.1(this);
    this.jVd = null;
    this.qpX = 0;
    this.lNZ = new RemittanceResultNewUI.3(this);
    this.mAc = new RemittanceResultNewUI.4(this);
    this.mAd = new RemittanceResultNewUI.5(this);
    AppMethodBeat.o(45123);
  }
  
  private ViewGroup bj(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(45132);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.RemittanceResultNewUI", "setF2FNameView");
    if (paramBoolean)
    {
      localViewGroup = (ViewGroup)getLayoutInflater().inflate(2130969489, this.qrm, false);
      localImageView = (ImageView)localViewGroup.findViewById(2131823856);
      localTextView = (TextView)localViewGroup.findViewById(2131823857);
      a.b.a(localImageView, this.mReceiverName, 0.06F, false);
      localTextView.setText(paramString);
      this.qrm.addView(localViewGroup);
      AppMethodBeat.o(45132);
      return localViewGroup;
    }
    ViewGroup localViewGroup = (ViewGroup)getLayoutInflater().inflate(2130969488, this.qrm, false);
    ImageView localImageView = (ImageView)localViewGroup.findViewById(2131823856);
    TextView localTextView = (TextView)localViewGroup.findViewById(2131823857);
    a.b.a(localImageView, this.mReceiverName, 0.06F, false);
    localTextView.setText(paramString);
    this.qrm.addView(localViewGroup);
    AppMethodBeat.o(45132);
    return localViewGroup;
  }
  
  private View chC()
  {
    boolean bool = true;
    AppMethodBeat.i(45135);
    if (this.qrf != null)
    {
      if (this.qrf.qjD > 0.0D) {}
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.RemittanceResultNewUI", "need set charge fee: %s", new Object[] { Boolean.valueOf(bool) });
        if (this.qrf.qjD <= 0.0D) {
          break;
        }
        String str1 = getString(2131302616);
        String str2 = e.e(this.qrf.qjD, this.qrf.ppp);
        ViewGroup localViewGroup = (ViewGroup)getLayoutInflater().inflate(2130969486, this.qrm, false);
        TextView localTextView1 = (TextView)localViewGroup.findViewById(2131821212);
        ImageView localImageView = (ImageView)localViewGroup.findViewById(2131821210);
        TextView localTextView2 = (TextView)localViewGroup.findViewById(2131821007);
        localTextView1.setText(str1);
        localImageView.setVisibility(8);
        localTextView2.setText(str2);
        this.qrm.addView(localViewGroup);
        AppMethodBeat.o(45135);
        return localViewGroup;
        bool = false;
      }
    }
    AppMethodBeat.o(45135);
    return null;
  }
  
  private void chD()
  {
    AppMethodBeat.i(45136);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.RemittanceResultNewUI", "endRemittance");
    if (getInput().containsKey("key_realname_guide_helper"))
    {
      RealnameGuideHelper localRealnameGuideHelper = (RealnameGuideHelper)getInput().getParcelable("key_realname_guide_helper");
      if (localRealnameGuideHelper != null)
      {
        Bundle localBundle = new Bundle();
        localBundle.putString("realname_verify_process_jump_activity", ".ui.RemittanceResultUI");
        localBundle.putString("realname_verify_process_jump_plugin", "remittance");
        localRealnameGuideHelper.b(this, localBundle, new RemittanceResultNewUI.6(this));
        localRealnameGuideHelper.a(this, localBundle, new RemittanceResultNewUI.7(this));
        getInput().remove("key_realname_guide_helper");
      }
      AppMethodBeat.o(45136);
      return;
    }
    chE();
    AppMethodBeat.o(45136);
  }
  
  private void chE()
  {
    AppMethodBeat.i(45137);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.RemittanceResultNewUI", "doEndRemittance");
    getProcess().b(this, getInput());
    new ak().postDelayed(new RemittanceResultNewUI.8(this), 100L);
    AppMethodBeat.o(45137);
  }
  
  public static int m(Context paramContext, String paramString, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(45129);
    int j = com.tencent.mm.cb.a.fromDPToPix(paramContext, 16);
    if (qrt == null) {
      qrt = v.dh(paramContext);
    }
    j = (qrt[0] - com.tencent.mm.cb.a.fromDPToPix(paramContext, 88) - paramInt) / j;
    int k = paramString.length();
    paramInt = k / j;
    if (paramInt > 2) {
      paramInt = i;
    }
    while (paramInt != 0)
    {
      AppMethodBeat.o(45129);
      return j * 2 - 5;
      if (paramInt == 2)
      {
        paramInt = i;
        if (k % j > 0) {}
      }
      else
      {
        paramInt = 0;
      }
    }
    paramInt = paramString.length();
    AppMethodBeat.o(45129);
    return paramInt;
  }
  
  protected final boolean chF()
  {
    return false;
  }
  
  public void finish()
  {
    AppMethodBeat.i(45124);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.RemittanceResultNewUI", "finish this %s %s", new Object[] { this, bo.dtY() });
    if (this.qni)
    {
      AppMethodBeat.o(45124);
      return;
    }
    super.finish();
    this.qni = true;
    AppMethodBeat.o(45124);
  }
  
  public int getLayoutId()
  {
    return 2130970577;
  }
  
  public void initView()
  {
    AppMethodBeat.i(45131);
    setBackBtn(null);
    showHomeBtn(false);
    enableBackMenu(false);
    this.qrh = ((TextView)findViewById(2131827186));
    this.qri = ((ViewGroup)findViewById(2131827322));
    this.qrj = ((TextView)findViewById(2131827323));
    this.qrk = ((WalletTextView)findViewById(2131827324));
    this.qrl = ((ViewGroup)findViewById(2131827331));
    this.qrm = ((ViewGroup)findViewById(2131827194));
    this.qrn = ((ViewGroup)findViewById(2131827325));
    this.qro = ((TextView)findViewById(2131827326));
    this.qrp = ((TextView)findViewById(2131827327));
    this.qrq = ((WalletTextView)findViewById(2131827328));
    this.qrs = ((Button)findViewById(2131827337));
    this.qrs.setOnClickListener(new RemittanceResultNewUI.2(this));
    this.qnd = ((WalletSuccPageAwardWidget)findViewById(2131827212));
    this.qph = ((LinearLayout)findViewById(2131827251));
    this.qpi = ((LinearLayout)findViewById(2131822911));
    this.qlB = ((LinearLayout)findViewById(2131827255));
    this.qpj = ((LinearLayout)findViewById(2131827330));
    this.qpk = ((TextView)findViewById(2131827253));
    this.qpl = ((TextView)findViewById(2131827254));
    this.qpm = ((TextView)findViewById(2131827258));
    this.qpn = ((TextView)findViewById(2131827259));
    this.qpo = ((TextView)findViewById(2131827260));
    Object localObject1 = e.nE(this.mReceiverName);
    if ((this.mPayScene == 31) || (this.mPayScene == 5))
    {
      this.qrp.setText(e.avZ(this.qrf.ppp));
      this.qrq.setText(e.E(this.qrf.cnL));
      if (this.mPayScene == 31)
      {
        localObject1 = getString(2131302619, new Object[] { localObject1 });
        if (!bo.isNullOrNil((String)localObject1)) {
          this.qro.setText(j.b(this, (CharSequence)localObject1, this.qro.getTextSize()));
        }
        for (;;)
        {
          this.qrn.setVisibility(0);
          if (this.qrf.qjD > 0.0D)
          {
            chC();
            ((ViewGroup.MarginLayoutParams)this.qrl.getLayoutParams()).topMargin = com.tencent.mm.cb.a.fromDPToPix(this, 20);
            this.qrl.setVisibility(0);
            this.qrm.setVisibility(0);
          }
          ((i)g.E(i.class)).g(this);
          AppMethodBeat.o(45131);
          return;
          this.qro.setVisibility(8);
        }
      }
      if ((this.pVo.wgv == null) || (!this.pVo.wgv.getBoolean("extinfo_key_10"))) {
        break label1465;
      }
    }
    label1410:
    label1415:
    label1430:
    label1436:
    label1455:
    label1460:
    label1465:
    for (boolean bool = true;; bool = false) {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.RemittanceResultNewUI", "isEmojiReward: %s", new Object[] { Boolean.valueOf(bool) });
        if (bool)
        {
          this.qro.setText(getString(2131302578));
          break;
        }
        if ((this.qrf.ujl == null) || (this.qrf.ujl.get(0) == null) || (TextUtils.isEmpty(((Orders.Commodity)this.qrf.ujl.get(0)).ppe))) {
          break;
        }
        this.qro.setText(((Orders.Commodity)this.qrf.ujl.get(0)).ppe);
        break;
        localObject1 = getInput().getByteArray("key_succpage_resp");
        if (localObject1 != null) {
          this.qrr = new pu();
        }
        try
        {
          this.qrr.parseFrom((byte[])localObject1);
          this.qnc = this.qrr.ukr;
          localObject4 = e.nE(this.mReceiverName);
          this.qrj.setText(e.avZ(this.qrf.ppp));
          this.qrk.setText(e.E(this.qrf.cnL));
          this.qrm.removeAllViews();
          if ((this.mPayScene == 32) || (this.mPayScene == 33) || (this.mPayScene == 48))
          {
            localObject1 = "";
            if (this.pVo.wgv != null) {
              localObject1 = this.pVo.wgv.getString("extinfo_key_2");
            }
            localObject3 = localObject4;
            if (localObject4 != null)
            {
              localObject3 = localObject4;
              if (((String)localObject4).length() > 10) {
                localObject3 = ((String)localObject4).substring(0, 10) + "...";
              }
            }
            if (bo.isNullOrNil((String)localObject1)) {
              break label1460;
            }
            if (bo.isNullOrNil((String)localObject3)) {
              break label1392;
            }
            localObject1 = e.awc((String)localObject1);
            localObject1 = (String)localObject3 + "(" + (String)localObject1 + ")";
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.RemittanceResultNewUI", "setF2FReceiverRemarkView");
            localObject4 = this.pVo.wgv.getString("extinfo_key_3");
            String str = this.pVo.wgv.getString("extinfo_key_8");
            if (bo.isNullOrNil((String)localObject4)) {
              break label1410;
            }
            localObject3 = (ViewGroup)getLayoutInflater().inflate(2130969487, this.qrm, false);
            localObject5 = (TextView)((ViewGroup)localObject3).findViewById(2131821212);
            localTextView1 = (TextView)((ViewGroup)localObject3).findViewById(2131821007);
            if (bo.isNullOrNil(str)) {
              break label1395;
            }
            ((TextView)localObject5).setText(str);
            localTextView1.setText((CharSequence)localObject4);
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.RemittanceResultNewUI", "setF2FPayerRemarkView");
            str = this.pVo.wgv.getString("extinfo_key_6");
            localObject5 = this.pVo.wgv.getString("extinfo_key_7");
            if (bo.isNullOrNil((String)localObject5)) {
              break label1430;
            }
            localObject4 = (ViewGroup)getLayoutInflater().inflate(2130969487, this.qrm, false);
            localTextView1 = (TextView)((ViewGroup)localObject4).findViewById(2131821212);
            TextView localTextView2 = (TextView)((ViewGroup)localObject4).findViewById(2131821007);
            if (bo.isNullOrNil(str)) {
              break label1415;
            }
            localTextView1.setText(str);
            localTextView2.setText((CharSequence)localObject5);
            localObject5 = chC();
            if ((localObject3 == null) && (localObject4 == null) && (localObject5 == null)) {
              break label1455;
            }
            bool = false;
            this.qrl.setVisibility(0);
            this.qrm.setVisibility(0);
            if (!WalletSuccPageAwardWidget.a(this.qnc)) {
              break label1436;
            }
            str = "";
            if (this.qrf.ujl.size() > 0) {
              str = ((Orders.Commodity)this.qrf.ujl.get(0)).cnJ;
            }
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.RemittanceResultNewUI", "transId: %s", new Object[] { str });
            this.qnd.a(this, this.qnc, str, true, (ImageView)findViewById(2131824152));
            this.qnd.init();
            this.qnd.setVisibility(0);
            bj((String)localObject1, false);
            if (localObject3 != null) {
              this.qrm.addView((View)localObject3);
            }
            if (localObject4 != null) {
              this.qrm.addView((View)localObject4);
            }
            if (localObject5 != null) {
              this.qrm.addView((View)localObject5);
            }
          }
          this.qri.setVisibility(0);
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Object localObject5;
            TextView localTextView1;
            this.qrr = null;
            this.qnc = null;
            com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.RemittanceResultNewUI", localException, "parse f2FPaySucPageResp error: %s", new Object[] { localException.getMessage() });
            continue;
            label1392:
            continue;
            label1395:
            ((TextView)localObject5).setText(getString(2131298439));
            continue;
            Object localObject3 = null;
            continue;
            localTextView1.setText(getString(2131298438));
            continue;
            Object localObject4 = null;
            continue;
            this.qnd.setVisibility(8);
            bj(localException, bool);
            continue;
            bool = true;
            continue;
            Object localObject2 = localObject3;
          }
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(45125);
    super.onCreate(paramBundle);
    if (d.fv(21))
    {
      if (!d.fv(23)) {
        break label130;
      }
      getWindow().setStatusBarColor(-1);
      getWindow().getDecorView().setSystemUiVisibility(8192);
    }
    for (;;)
    {
      if (getSupportActionBar() != null) {
        getSupportActionBar().hide();
      }
      this.qnj.alive();
      this.qrf = ((Orders)getInput().getParcelable("key_orders"));
      this.pVo = ((PayInfo)getInput().getParcelable("key_pay_info"));
      if (this.pVo != null) {
        break;
      }
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.RemittanceResultNewUI", "payInfo is null!!!");
      finish();
      AppMethodBeat.o(45125);
      return;
      label130:
      getWindow().setStatusBarColor(Color.parseColor("#E5E5E5"));
    }
    String str = "";
    paramBundle = "";
    if (this.pVo.wgv != null)
    {
      this.qrg = this.pVo.wgv.getBoolean("extinfo_key_4");
      str = this.pVo.wgv.getString("extinfo_key_1");
      paramBundle = this.pVo.wgv.getString("extinfo_key_16");
    }
    int i = this.pVo.cCD;
    this.mPayScene = i;
    this.mReceiverName = str;
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.RemittanceResultNewUI", "payScene: %s", new Object[] { Integer.valueOf(i) });
    initView();
    if (this.mPayScene == 31)
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.RemittanceResultNewUI", "transId: %s", new Object[] { paramBundle });
      com.tencent.mm.plugin.remittance.a.c.cgH().cgK().fY(paramBundle, this.mReceiverName);
    }
    AppMethodBeat.o(45125);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(45130);
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    paramContextMenu.add(0, 0, 0, getString(2131296895));
    AppMethodBeat.o(45130);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(45142);
    super.onDestroy();
    this.qnj.dead();
    if (WalletSuccPageAwardWidget.a(this.qnc)) {
      this.qnd.onDestroy();
    }
    AppMethodBeat.o(45142);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(45126);
    if (paramInt == 4) {
      chD();
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(45126);
    return bool;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(45141);
    super.onResume();
    if (WalletSuccPageAwardWidget.a(this.qnc)) {
      this.qnd.onResume();
    }
    AppMethodBeat.o(45141);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(45139);
    if (WalletSuccPageAwardWidget.a(this.qnc))
    {
      bool = this.qnd.onSceneEnd(paramInt1, paramInt2, paramString, paramm);
      AppMethodBeat.o(45139);
      return bool;
    }
    boolean bool = super.onSceneEnd(paramInt1, paramInt2, paramString, paramm);
    AppMethodBeat.o(45139);
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void setContentViewVisibility(int paramInt)
  {
    AppMethodBeat.i(45140);
    getContentView().setVisibility(paramInt);
    AppMethodBeat.o(45140);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceResultNewUI
 * JD-Core Version:    0.7.0.1
 */