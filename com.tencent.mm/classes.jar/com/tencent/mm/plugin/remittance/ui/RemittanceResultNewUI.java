package com.tencent.mm.plugin.remittance.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
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
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.yv;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.b.h;
import com.tencent.mm.plugin.remittance.model.ac;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.um;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.f;
import java.util.List;

@com.tencent.mm.ui.base.a(19)
public class RemittanceResultNewUI
  extends RemittanceResultUI
{
  private static int[] ywg = null;
  private int mPayScene;
  private String mReceiverName;
  private int oef;
  private int oeg;
  private com.tencent.mm.ui.widget.b.a ofu;
  private n.e qsh;
  private View.OnTouchListener rIt;
  private View.OnLongClickListener rIu;
  private PayInfo xDC;
  private LinearLayout yqn;
  private e.a.a.c yrO;
  private WalletSuccPageAwardWidget yrP;
  private boolean yrU;
  private com.tencent.mm.sdk.b.c<yv> yrV;
  private LinearLayout ytW;
  private LinearLayout ytX;
  private LinearLayout ytY;
  private TextView ytZ;
  private int yuN;
  private TextView yua;
  private TextView yub;
  private TextView yuc;
  private TextView yud;
  private Orders yvS;
  private boolean yvT;
  private TextView yvU;
  private ViewGroup yvV;
  private TextView yvW;
  private WalletTextView yvX;
  private ViewGroup yvY;
  private ViewGroup yvZ;
  private ViewGroup ywa;
  private TextView ywb;
  private TextView ywc;
  private WalletTextView ywd;
  private um ywe;
  private Button ywf;
  
  public RemittanceResultNewUI()
  {
    AppMethodBeat.i(68287);
    this.yrU = false;
    this.yrV = new com.tencent.mm.sdk.b.c() {};
    this.ofu = null;
    this.yuN = 0;
    this.qsh = new RemittanceResultNewUI.3(this);
    this.rIt = new RemittanceResultNewUI.4(this);
    this.rIu = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68283);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceResultNewUI$6", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahF());
        ae.d("MicroMsg.RemittanceResultNewUI", "onLongClick");
        if (RemittanceResultNewUI.f(RemittanceResultNewUI.this) == null) {
          RemittanceResultNewUI.a(RemittanceResultNewUI.this, new com.tencent.mm.ui.widget.b.a(RemittanceResultNewUI.this.getContext()));
        }
        RemittanceResultNewUI.f(RemittanceResultNewUI.this).a(paramAnonymousView, RemittanceResultNewUI.this, RemittanceResultNewUI.g(RemittanceResultNewUI.this), RemittanceResultNewUI.h(RemittanceResultNewUI.this), RemittanceResultNewUI.i(RemittanceResultNewUI.this));
        RemittanceResultNewUI.c(RemittanceResultNewUI.this, paramAnonymousView.getId());
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/remittance/ui/RemittanceResultNewUI$6", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(68283);
        return true;
      }
    };
    AppMethodBeat.o(68287);
  }
  
  private ViewGroup bJ(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(68294);
    ae.i("MicroMsg.RemittanceResultNewUI", "setF2FNameView");
    int i;
    if (paramBoolean)
    {
      localViewGroup = (ViewGroup)getLayoutInflater().inflate(2131493902, this.yvZ, false);
      localCdnImageView = (CdnImageView)localViewGroup.findViewById(2131304006);
      localTextView = (TextView)localViewGroup.findViewById(2131303742);
      if ((bu.isNullOrNil(this.mReceiverName)) && (this.xDC.hwN != null))
      {
        i = BackwardSupportUtil.b.h(this, 56.0F);
        localCdnImageView.setRoundCorner(true);
        localCdnImageView.r(this.xDC.hwN.getString("extinfo_key_27"), i, i, 2131231875);
      }
      for (;;)
      {
        localTextView.setText(paramString);
        this.yvZ.addView(localViewGroup);
        AppMethodBeat.o(68294);
        return localViewGroup;
        a.b.a(localCdnImageView, this.mReceiverName, 0.06F, false);
      }
    }
    ViewGroup localViewGroup = (ViewGroup)getLayoutInflater().inflate(2131493901, this.yvZ, false);
    CdnImageView localCdnImageView = (CdnImageView)localViewGroup.findViewById(2131304006);
    TextView localTextView = (TextView)localViewGroup.findViewById(2131303742);
    if ((bu.isNullOrNil(this.mReceiverName)) && (this.xDC.hwN != null))
    {
      i = BackwardSupportUtil.b.h(this, 28.0F);
      localCdnImageView.setRoundCorner(true);
      localCdnImageView.r(this.xDC.hwN.getString("extinfo_key_27"), i, i, 2131231875);
    }
    for (;;)
    {
      localTextView.setText(paramString);
      this.yvZ.addView(localViewGroup);
      AppMethodBeat.o(68294);
      return localViewGroup;
      a.b.a(localCdnImageView, this.mReceiverName, 0.06F, false);
    }
  }
  
  private View dNk()
  {
    boolean bool = true;
    AppMethodBeat.i(68295);
    if (this.yvS != null)
    {
      if (this.yvS.yoj > 0.0D) {}
      for (;;)
      {
        ae.i("MicroMsg.RemittanceResultNewUI", "need set charge fee: %s", new Object[] { Boolean.valueOf(bool) });
        if (this.yvS.yoj <= 0.0D) {
          break;
        }
        String str1 = getString(2131762522);
        String str2 = f.d(this.yvS.yoj, this.yvS.wSq);
        ViewGroup localViewGroup = (ViewGroup)getLayoutInflater().inflate(2131493899, this.yvZ, false);
        TextView localTextView1 = (TextView)localViewGroup.findViewById(2131305948);
        ImageView localImageView = (ImageView)localViewGroup.findViewById(2131297008);
        TextView localTextView2 = (TextView)localViewGroup.findViewById(2131299008);
        localTextView1.setText(str1);
        localImageView.setVisibility(8);
        localTextView2.setText(str2);
        this.yvZ.addView(localViewGroup);
        AppMethodBeat.o(68295);
        return localViewGroup;
        bool = false;
      }
    }
    AppMethodBeat.o(68295);
    return null;
  }
  
  private void dNl()
  {
    AppMethodBeat.i(68296);
    ae.i("MicroMsg.RemittanceResultNewUI", "endRemittance");
    if (getInput().containsKey("key_realname_guide_helper"))
    {
      RealnameGuideHelper localRealnameGuideHelper = (RealnameGuideHelper)getInput().getParcelable("key_realname_guide_helper");
      if (localRealnameGuideHelper != null)
      {
        Bundle localBundle = new Bundle();
        localBundle.putString("realname_verify_process_jump_activity", ".ui.RemittanceResultUI");
        localBundle.putString("realname_verify_process_jump_plugin", "remittance");
        localRealnameGuideHelper.b(this, localBundle, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(68284);
            RemittanceResultNewUI.j(RemittanceResultNewUI.this);
            AppMethodBeat.o(68284);
          }
        });
        localRealnameGuideHelper.a(this, localBundle, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(68285);
            RemittanceResultNewUI.j(RemittanceResultNewUI.this);
            AppMethodBeat.o(68285);
          }
        });
        getInput().remove("key_realname_guide_helper");
      }
      AppMethodBeat.o(68296);
      return;
    }
    dNm();
    AppMethodBeat.o(68296);
  }
  
  private void dNm()
  {
    AppMethodBeat.i(68297);
    ae.i("MicroMsg.RemittanceResultNewUI", "doEndRemittance");
    getProcess().b(this, getInput());
    new aq().postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(68286);
        if ((RemittanceResultNewUI.k(RemittanceResultNewUI.this) == 33) || (RemittanceResultNewUI.k(RemittanceResultNewUI.this) == 32) || (RemittanceResultNewUI.k(RemittanceResultNewUI.this) == 48))
        {
          RemittanceResultNewUI.this.finish();
          AppMethodBeat.o(68286);
          return;
        }
        if ((!bu.isNullOrNil(RemittanceResultNewUI.l(RemittanceResultNewUI.this))) && (!RemittanceResultNewUI.m(RemittanceResultNewUI.this)))
        {
          Intent localIntent = new Intent();
          localIntent.putExtra("Chat_User", RemittanceResultNewUI.l(RemittanceResultNewUI.this));
          localIntent.putExtra("finish_direct", false);
          com.tencent.mm.br.d.f(RemittanceResultNewUI.this, ".ui.chatting.ChattingUI", localIntent);
          AppMethodBeat.o(68286);
          return;
        }
        RemittanceResultNewUI.this.finish();
        AppMethodBeat.o(68286);
      }
    }, 100L);
    AppMethodBeat.o(68297);
  }
  
  public static int m(Context paramContext, String paramString, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(68292);
    int j = com.tencent.mm.cb.a.fromDPToPix(paramContext, 16);
    if (ywg == null) {
      ywg = aa.eF(paramContext);
    }
    j = (ywg[0] - com.tencent.mm.cb.a.fromDPToPix(paramContext, 88) - paramInt) / j;
    int k = paramString.length();
    paramInt = k / j;
    if (paramInt > 2) {
      paramInt = i;
    }
    while (paramInt != 0)
    {
      AppMethodBeat.o(68292);
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
    AppMethodBeat.o(68292);
    return paramInt;
  }
  
  protected final boolean dNn()
  {
    return false;
  }
  
  public void finish()
  {
    AppMethodBeat.i(68288);
    ae.i("MicroMsg.RemittanceResultNewUI", "finish this %s %s", new Object[] { this, bu.fpN() });
    if (this.yrU)
    {
      AppMethodBeat.o(68288);
      return;
    }
    super.finish();
    this.yrU = true;
    AppMethodBeat.o(68288);
  }
  
  public int getLayoutId()
  {
    return 2131495261;
  }
  
  public void initView()
  {
    AppMethodBeat.i(68291);
    setBackBtn(null);
    showHomeBtn(false);
    enableBackMenu(false);
    this.yvU = ((TextView)findViewById(2131303158));
    this.yvV = ((ViewGroup)findViewById(2131299655));
    this.yvW = ((TextView)findViewById(2131299649));
    this.yvX = ((WalletTextView)findViewById(2131299647));
    this.yvY = ((ViewGroup)findViewById(2131299653));
    this.yvZ = ((ViewGroup)findViewById(2131299654));
    this.ywa = ((ViewGroup)findViewById(2131302901));
    this.ywb = ((TextView)findViewById(2131302900));
    this.ywc = ((TextView)findViewById(2131302898));
    this.ywd = ((WalletTextView)findViewById(2131302897));
    this.ywf = ((Button)findViewById(2131306063));
    this.ywf.setOnClickListener(new RemittanceResultNewUI.2(this));
    this.yrP = ((WalletSuccPageAwardWidget)findViewById(2131297022));
    this.ytW = ((LinearLayout)findViewById(2131304043));
    this.ytX = ((LinearLayout)findViewById(2131304014));
    this.yqn = ((LinearLayout)findViewById(2131303987));
    this.ytY = ((LinearLayout)findViewById(2131303988));
    this.ytZ = ((TextView)findViewById(2131304019));
    this.yua = ((TextView)findViewById(2131304016));
    this.yub = ((TextView)findViewById(2131302665));
    this.yuc = ((TextView)findViewById(2131296478));
    this.yud = ((TextView)findViewById(2131296477));
    Object localObject1 = f.zP(this.mReceiverName);
    if ((this.mPayScene == 31) || (this.mPayScene == 5))
    {
      this.ywc.setText(f.bah(this.yvS.wSq));
      this.ywd.setText(f.C(this.yvS.dmz));
      if (this.mPayScene == 31)
      {
        localObject1 = getString(2131762525, new Object[] { localObject1 });
        if (!bu.isNullOrNil((String)localObject1)) {
          this.ywb.setText(k.b(this, (CharSequence)localObject1, this.ywb.getTextSize()));
        }
        for (;;)
        {
          this.ywa.setVisibility(0);
          if (this.yvS.yoj > 0.0D)
          {
            dNk();
            ((ViewGroup.MarginLayoutParams)this.yvY.getLayoutParams()).topMargin = com.tencent.mm.cb.a.fromDPToPix(this, 20);
            this.yvY.setVisibility(0);
            this.yvZ.setVisibility(0);
          }
          ((h)g.ab(h.class)).i(this);
          AppMethodBeat.o(68291);
          return;
          this.ywb.setVisibility(8);
        }
      }
      if ((this.xDC.hwN == null) || (!this.xDC.hwN.getBoolean("extinfo_key_10"))) {
        break label1506;
      }
    }
    label1430:
    label1435:
    label1450:
    label1455:
    label1470:
    label1476:
    label1495:
    label1500:
    label1506:
    for (boolean bool = true;; bool = false) {
      for (;;)
      {
        ae.i("MicroMsg.RemittanceResultNewUI", "isEmojiReward: %s", new Object[] { Boolean.valueOf(bool) });
        if (bool)
        {
          this.ywb.setText(getString(2131762484));
          break;
        }
        if ((this.yvS.DpP == null) || (this.yvS.DpP.get(0) == null) || (TextUtils.isEmpty(((Orders.Commodity)this.yvS.DpP.get(0)).wSf))) {
          break;
        }
        this.ywb.setText(((Orders.Commodity)this.yvS.DpP.get(0)).wSf);
        break;
        localObject1 = getInput().getByteArray("key_succpage_resp");
        if (localObject1 != null) {
          this.ywe = new um();
        }
        try
        {
          this.ywe.parseFrom((byte[])localObject1);
          this.yrO = this.ywe.DqV;
          localObject3 = f.zP(this.mReceiverName);
          this.yvW.setText(f.bah(this.yvS.wSq));
          this.yvX.setText(f.C(this.yvS.dmz));
          this.yvZ.removeAllViews();
          if ((this.mPayScene == 32) || (this.mPayScene == 33) || (this.mPayScene == 48))
          {
            localObject1 = localObject3;
            if (bu.isNullOrNil((String)localObject3))
            {
              localObject1 = localObject3;
              if (this.xDC.hwN != null) {
                localObject1 = this.xDC.hwN.getString("extinfo_key_28");
              }
            }
            localObject3 = "";
            if (this.xDC.hwN != null) {
              localObject3 = this.xDC.hwN.getString("extinfo_key_2");
            }
            localObject4 = localObject1;
            if (localObject1 != null)
            {
              localObject4 = localObject1;
              if (((String)localObject1).length() > 10) {
                localObject4 = ((String)localObject1).substring(0, 10) + "...";
              }
            }
            if (bu.isNullOrNil((String)localObject3)) {
              break label1500;
            }
            if (bu.isNullOrNil((String)localObject4)) {
              break label1430;
            }
            localObject1 = f.bak((String)localObject3);
            localObject1 = (String)localObject4 + "(" + (String)localObject1 + ")";
            ae.i("MicroMsg.RemittanceResultNewUI", "setF2FReceiverRemarkView");
            localObject4 = this.xDC.hwN.getString("extinfo_key_3");
            String str = this.xDC.hwN.getString("extinfo_key_8");
            if (bu.isNullOrNil((String)localObject4)) {
              break label1450;
            }
            localObject3 = (ViewGroup)getLayoutInflater().inflate(2131493900, this.yvZ, false);
            localObject5 = (TextView)((ViewGroup)localObject3).findViewById(2131305948);
            localTextView1 = (TextView)((ViewGroup)localObject3).findViewById(2131299008);
            if (bu.isNullOrNil(str)) {
              break label1435;
            }
            ((TextView)localObject5).setText(str);
            localTextView1.setText((CharSequence)localObject4);
            ae.i("MicroMsg.RemittanceResultNewUI", "setF2FPayerRemarkView");
            str = this.xDC.hwN.getString("extinfo_key_6");
            localObject5 = this.xDC.hwN.getString("extinfo_key_7");
            if (bu.isNullOrNil((String)localObject5)) {
              break label1470;
            }
            localObject4 = (ViewGroup)getLayoutInflater().inflate(2131493900, this.yvZ, false);
            localTextView1 = (TextView)((ViewGroup)localObject4).findViewById(2131305948);
            TextView localTextView2 = (TextView)((ViewGroup)localObject4).findViewById(2131299008);
            if (bu.isNullOrNil(str)) {
              break label1455;
            }
            localTextView1.setText(str);
            localTextView2.setText((CharSequence)localObject5);
            localObject5 = dNk();
            if ((localObject3 == null) && (localObject4 == null) && (localObject5 == null)) {
              break label1495;
            }
            bool = false;
            this.yvY.setVisibility(0);
            this.yvZ.setVisibility(0);
            if (!WalletSuccPageAwardWidget.a(this.yrO)) {
              break label1476;
            }
            str = "";
            if (this.yvS.DpP.size() > 0) {
              str = ((Orders.Commodity)this.yvS.DpP.get(0)).dmx;
            }
            ae.i("MicroMsg.RemittanceResultNewUI", "transId: %s", new Object[] { str });
            this.yrP.a(this, this.yrO, str, true, (ImageView)findViewById(2131297029));
            this.yrP.init();
            this.yrP.setVisibility(0);
            bJ((String)localObject1, false);
            if (localObject3 != null) {
              this.yvZ.addView((View)localObject3);
            }
            if (localObject4 != null) {
              this.yvZ.addView((View)localObject4);
            }
            if (localObject5 != null) {
              this.yvZ.addView((View)localObject5);
            }
          }
          this.yvV.setVisibility(0);
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Object localObject5;
            TextView localTextView1;
            this.ywe = null;
            this.yrO = null;
            ae.printErrStackTrace("MicroMsg.RemittanceResultNewUI", localException, "parse f2FPaySucPageResp error: %s", new Object[] { localException.getMessage() });
            continue;
            Object localObject2 = localObject3;
            continue;
            ((TextView)localObject5).setText(getString(2131757451));
            continue;
            Object localObject3 = null;
            continue;
            localTextView1.setText(getString(2131757450));
            continue;
            Object localObject4 = null;
            continue;
            this.yrP.setVisibility(8);
            bJ(localObject2, bool);
            continue;
            bool = true;
            continue;
            localObject2 = localObject4;
          }
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(68289);
    super.onCreate(paramBundle);
    if (com.tencent.mm.compatible.util.d.lA(21))
    {
      if (!com.tencent.mm.compatible.util.d.lA(23)) {
        break label126;
      }
      getWindow().setStatusBarColor(getResources().getColor(2131101179));
    }
    for (;;)
    {
      if (getSupportActionBar() != null) {
        getSupportActionBar().hide();
      }
      this.yrV.alive();
      this.yvS = ((Orders)getInput().getParcelable("key_orders"));
      this.xDC = ((PayInfo)getInput().getParcelable("key_pay_info"));
      if (this.xDC != null) {
        break;
      }
      ae.e("MicroMsg.RemittanceResultNewUI", "payInfo is null!!!");
      finish();
      AppMethodBeat.o(68289);
      return;
      label126:
      getWindow().setStatusBarColor(getResources().getColor(2131099678));
    }
    String str = "";
    paramBundle = "";
    if (this.xDC.hwN != null)
    {
      this.yvT = this.xDC.hwN.getBoolean("extinfo_key_4");
      str = this.xDC.hwN.getString("extinfo_key_1");
      paramBundle = this.xDC.hwN.getString("extinfo_key_16");
    }
    int i = this.xDC.dDH;
    this.mPayScene = i;
    this.mReceiverName = str;
    ae.i("MicroMsg.RemittanceResultNewUI", "payScene: %s", new Object[] { Integer.valueOf(i) });
    initView();
    if (this.mPayScene == 31)
    {
      ae.i("MicroMsg.RemittanceResultNewUI", "transId: %s", new Object[] { paramBundle });
      com.tencent.mm.plugin.remittance.a.c.dLS().dLV().jb(paramBundle, this.mReceiverName);
    }
    AppMethodBeat.o(68289);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(68293);
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    paramContextMenu.add(0, 0, 0, getString(2131755701));
    AppMethodBeat.o(68293);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(68301);
    super.onDestroy();
    this.yrV.dead();
    if (WalletSuccPageAwardWidget.a(this.yrO)) {
      this.yrP.onDestroy();
    }
    AppMethodBeat.o(68301);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(68290);
    if (paramInt == 4) {
      dNl();
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(68290);
    return bool;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(68300);
    super.onResume();
    if (WalletSuccPageAwardWidget.a(this.yrO)) {
      this.yrP.onResume();
    }
    AppMethodBeat.o(68300);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(68298);
    if (WalletSuccPageAwardWidget.a(this.yrO))
    {
      bool = this.yrP.onSceneEnd(paramInt1, paramInt2, paramString, paramn);
      AppMethodBeat.o(68298);
      return bool;
    }
    boolean bool = super.onSceneEnd(paramInt1, paramInt2, paramString, paramn);
    AppMethodBeat.o(68298);
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void setContentViewVisibility(int paramInt)
  {
    AppMethodBeat.i(68299);
    getContentView().setVisibility(paramInt);
    AppMethodBeat.o(68299);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceResultNewUI
 * JD-Core Version:    0.7.0.1
 */