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
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.yp;
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
import com.tencent.mm.protocal.protobuf.uk;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.z;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.e;
import java.util.List;

@com.tencent.mm.ui.base.a(19)
public class RemittanceResultNewUI
  extends RemittanceResultUI
{
  private static int[] ygp = null;
  private int mPayScene;
  private String mReceiverName;
  private int nYw;
  private int nYx;
  private com.tencent.mm.ui.widget.b.a nZK;
  private n.e qlC;
  private View.OnTouchListener rAi;
  private View.OnLongClickListener rAj;
  private PayInfo xnF;
  private LinearLayout yav;
  private e.a.a.c ybX;
  private WalletSuccPageAwardWidget ybY;
  private boolean ycd;
  private com.tencent.mm.sdk.b.c<yp> yce;
  private int yeW;
  private LinearLayout yef;
  private LinearLayout yeg;
  private LinearLayout yeh;
  private TextView yei;
  private TextView yej;
  private TextView yek;
  private TextView yel;
  private TextView yem;
  private Orders ygb;
  private boolean ygc;
  private TextView ygd;
  private ViewGroup yge;
  private TextView ygf;
  private WalletTextView ygg;
  private ViewGroup ygh;
  private ViewGroup ygi;
  private ViewGroup ygj;
  private TextView ygk;
  private TextView ygl;
  private WalletTextView ygm;
  private uk ygn;
  private Button ygo;
  
  public RemittanceResultNewUI()
  {
    AppMethodBeat.i(68287);
    this.ycd = false;
    this.yce = new com.tencent.mm.sdk.b.c() {};
    this.nZK = null;
    this.yeW = 0;
    this.qlC = new RemittanceResultNewUI.3(this);
    this.rAi = new RemittanceResultNewUI.4(this);
    this.rAj = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68283);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceResultNewUI$6", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahq());
        ad.d("MicroMsg.RemittanceResultNewUI", "onLongClick");
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
  
  private ViewGroup bF(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(68294);
    ad.i("MicroMsg.RemittanceResultNewUI", "setF2FNameView");
    int i;
    if (paramBoolean)
    {
      localViewGroup = (ViewGroup)getLayoutInflater().inflate(2131493902, this.ygi, false);
      localCdnImageView = (CdnImageView)localViewGroup.findViewById(2131304006);
      localTextView = (TextView)localViewGroup.findViewById(2131303742);
      if ((bt.isNullOrNil(this.mReceiverName)) && (this.xnF.htZ != null))
      {
        i = BackwardSupportUtil.b.g(this, 56.0F);
        localCdnImageView.setRoundCorner(true);
        localCdnImageView.r(this.xnF.htZ.getString("extinfo_key_27"), i, i, 2131231875);
      }
      for (;;)
      {
        localTextView.setText(paramString);
        this.ygi.addView(localViewGroup);
        AppMethodBeat.o(68294);
        return localViewGroup;
        a.b.a(localCdnImageView, this.mReceiverName, 0.06F, false);
      }
    }
    ViewGroup localViewGroup = (ViewGroup)getLayoutInflater().inflate(2131493901, this.ygi, false);
    CdnImageView localCdnImageView = (CdnImageView)localViewGroup.findViewById(2131304006);
    TextView localTextView = (TextView)localViewGroup.findViewById(2131303742);
    if ((bt.isNullOrNil(this.mReceiverName)) && (this.xnF.htZ != null))
    {
      i = BackwardSupportUtil.b.g(this, 28.0F);
      localCdnImageView.setRoundCorner(true);
      localCdnImageView.r(this.xnF.htZ.getString("extinfo_key_27"), i, i, 2131231875);
    }
    for (;;)
    {
      localTextView.setText(paramString);
      this.ygi.addView(localViewGroup);
      AppMethodBeat.o(68294);
      return localViewGroup;
      a.b.a(localCdnImageView, this.mReceiverName, 0.06F, false);
    }
  }
  
  private View dJS()
  {
    boolean bool = true;
    AppMethodBeat.i(68295);
    if (this.ygb != null)
    {
      if (this.ygb.xYr > 0.0D) {}
      for (;;)
      {
        ad.i("MicroMsg.RemittanceResultNewUI", "need set charge fee: %s", new Object[] { Boolean.valueOf(bool) });
        if (this.ygb.xYr <= 0.0D) {
          break;
        }
        String str1 = getString(2131762522);
        String str2 = e.d(this.ygb.xYr, this.ygb.wCF);
        ViewGroup localViewGroup = (ViewGroup)getLayoutInflater().inflate(2131493899, this.ygi, false);
        TextView localTextView1 = (TextView)localViewGroup.findViewById(2131305948);
        ImageView localImageView = (ImageView)localViewGroup.findViewById(2131297008);
        TextView localTextView2 = (TextView)localViewGroup.findViewById(2131299008);
        localTextView1.setText(str1);
        localImageView.setVisibility(8);
        localTextView2.setText(str2);
        this.ygi.addView(localViewGroup);
        AppMethodBeat.o(68295);
        return localViewGroup;
        bool = false;
      }
    }
    AppMethodBeat.o(68295);
    return null;
  }
  
  private void dJT()
  {
    AppMethodBeat.i(68296);
    ad.i("MicroMsg.RemittanceResultNewUI", "endRemittance");
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
    dJU();
    AppMethodBeat.o(68296);
  }
  
  private void dJU()
  {
    AppMethodBeat.i(68297);
    ad.i("MicroMsg.RemittanceResultNewUI", "doEndRemittance");
    getProcess().b(this, getInput());
    new ap().postDelayed(new Runnable()
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
        if ((!bt.isNullOrNil(RemittanceResultNewUI.l(RemittanceResultNewUI.this))) && (!RemittanceResultNewUI.m(RemittanceResultNewUI.this)))
        {
          Intent localIntent = new Intent();
          localIntent.putExtra("Chat_User", RemittanceResultNewUI.l(RemittanceResultNewUI.this));
          localIntent.putExtra("finish_direct", false);
          com.tencent.mm.bs.d.f(RemittanceResultNewUI.this, ".ui.chatting.ChattingUI", localIntent);
          AppMethodBeat.o(68286);
          return;
        }
        RemittanceResultNewUI.this.finish();
        AppMethodBeat.o(68286);
      }
    }, 100L);
    AppMethodBeat.o(68297);
  }
  
  public static int n(Context paramContext, String paramString, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(68292);
    int j = com.tencent.mm.cc.a.fromDPToPix(paramContext, 16);
    if (ygp == null) {
      ygp = z.eB(paramContext);
    }
    j = (ygp[0] - com.tencent.mm.cc.a.fromDPToPix(paramContext, 88) - paramInt) / j;
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
  
  protected final boolean dJV()
  {
    return false;
  }
  
  public void finish()
  {
    AppMethodBeat.i(68288);
    ad.i("MicroMsg.RemittanceResultNewUI", "finish this %s %s", new Object[] { this, bt.flS() });
    if (this.ycd)
    {
      AppMethodBeat.o(68288);
      return;
    }
    super.finish();
    this.ycd = true;
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
    this.ygd = ((TextView)findViewById(2131303158));
    this.yge = ((ViewGroup)findViewById(2131299655));
    this.ygf = ((TextView)findViewById(2131299649));
    this.ygg = ((WalletTextView)findViewById(2131299647));
    this.ygh = ((ViewGroup)findViewById(2131299653));
    this.ygi = ((ViewGroup)findViewById(2131299654));
    this.ygj = ((ViewGroup)findViewById(2131302901));
    this.ygk = ((TextView)findViewById(2131302900));
    this.ygl = ((TextView)findViewById(2131302898));
    this.ygm = ((WalletTextView)findViewById(2131302897));
    this.ygo = ((Button)findViewById(2131306063));
    this.ygo.setOnClickListener(new RemittanceResultNewUI.2(this));
    this.ybY = ((WalletSuccPageAwardWidget)findViewById(2131297022));
    this.yef = ((LinearLayout)findViewById(2131304043));
    this.yeg = ((LinearLayout)findViewById(2131304014));
    this.yav = ((LinearLayout)findViewById(2131303987));
    this.yeh = ((LinearLayout)findViewById(2131303988));
    this.yei = ((TextView)findViewById(2131304019));
    this.yej = ((TextView)findViewById(2131304016));
    this.yek = ((TextView)findViewById(2131302665));
    this.yel = ((TextView)findViewById(2131296478));
    this.yem = ((TextView)findViewById(2131296477));
    Object localObject1 = e.zf(this.mReceiverName);
    if ((this.mPayScene == 31) || (this.mPayScene == 5))
    {
      this.ygl.setText(e.aYE(this.ygb.wCF));
      this.ygm.setText(e.C(this.ygb.dlx));
      if (this.mPayScene == 31)
      {
        localObject1 = getString(2131762525, new Object[] { localObject1 });
        if (!bt.isNullOrNil((String)localObject1)) {
          this.ygk.setText(k.b(this, (CharSequence)localObject1, this.ygk.getTextSize()));
        }
        for (;;)
        {
          this.ygj.setVisibility(0);
          if (this.ygb.xYr > 0.0D)
          {
            dJS();
            ((ViewGroup.MarginLayoutParams)this.ygh.getLayoutParams()).topMargin = com.tencent.mm.cc.a.fromDPToPix(this, 20);
            this.ygh.setVisibility(0);
            this.ygi.setVisibility(0);
          }
          ((h)g.ab(h.class)).i(this);
          AppMethodBeat.o(68291);
          return;
          this.ygk.setVisibility(8);
        }
      }
      if ((this.xnF.htZ == null) || (!this.xnF.htZ.getBoolean("extinfo_key_10"))) {
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
        ad.i("MicroMsg.RemittanceResultNewUI", "isEmojiReward: %s", new Object[] { Boolean.valueOf(bool) });
        if (bool)
        {
          this.ygk.setText(getString(2131762484));
          break;
        }
        if ((this.ygb.CYk == null) || (this.ygb.CYk.get(0) == null) || (TextUtils.isEmpty(((Orders.Commodity)this.ygb.CYk.get(0)).wCu))) {
          break;
        }
        this.ygk.setText(((Orders.Commodity)this.ygb.CYk.get(0)).wCu);
        break;
        localObject1 = getInput().getByteArray("key_succpage_resp");
        if (localObject1 != null) {
          this.ygn = new uk();
        }
        try
        {
          this.ygn.parseFrom((byte[])localObject1);
          this.ybX = this.ygn.CZq;
          localObject3 = e.zf(this.mReceiverName);
          this.ygf.setText(e.aYE(this.ygb.wCF));
          this.ygg.setText(e.C(this.ygb.dlx));
          this.ygi.removeAllViews();
          if ((this.mPayScene == 32) || (this.mPayScene == 33) || (this.mPayScene == 48))
          {
            localObject1 = localObject3;
            if (bt.isNullOrNil((String)localObject3))
            {
              localObject1 = localObject3;
              if (this.xnF.htZ != null) {
                localObject1 = this.xnF.htZ.getString("extinfo_key_28");
              }
            }
            localObject3 = "";
            if (this.xnF.htZ != null) {
              localObject3 = this.xnF.htZ.getString("extinfo_key_2");
            }
            localObject4 = localObject1;
            if (localObject1 != null)
            {
              localObject4 = localObject1;
              if (((String)localObject1).length() > 10) {
                localObject4 = ((String)localObject1).substring(0, 10) + "...";
              }
            }
            if (bt.isNullOrNil((String)localObject3)) {
              break label1500;
            }
            if (bt.isNullOrNil((String)localObject4)) {
              break label1430;
            }
            localObject1 = e.aYH((String)localObject3);
            localObject1 = (String)localObject4 + "(" + (String)localObject1 + ")";
            ad.i("MicroMsg.RemittanceResultNewUI", "setF2FReceiverRemarkView");
            localObject4 = this.xnF.htZ.getString("extinfo_key_3");
            String str = this.xnF.htZ.getString("extinfo_key_8");
            if (bt.isNullOrNil((String)localObject4)) {
              break label1450;
            }
            localObject3 = (ViewGroup)getLayoutInflater().inflate(2131493900, this.ygi, false);
            localObject5 = (TextView)((ViewGroup)localObject3).findViewById(2131305948);
            localTextView1 = (TextView)((ViewGroup)localObject3).findViewById(2131299008);
            if (bt.isNullOrNil(str)) {
              break label1435;
            }
            ((TextView)localObject5).setText(str);
            localTextView1.setText((CharSequence)localObject4);
            ad.i("MicroMsg.RemittanceResultNewUI", "setF2FPayerRemarkView");
            str = this.xnF.htZ.getString("extinfo_key_6");
            localObject5 = this.xnF.htZ.getString("extinfo_key_7");
            if (bt.isNullOrNil((String)localObject5)) {
              break label1470;
            }
            localObject4 = (ViewGroup)getLayoutInflater().inflate(2131493900, this.ygi, false);
            localTextView1 = (TextView)((ViewGroup)localObject4).findViewById(2131305948);
            TextView localTextView2 = (TextView)((ViewGroup)localObject4).findViewById(2131299008);
            if (bt.isNullOrNil(str)) {
              break label1455;
            }
            localTextView1.setText(str);
            localTextView2.setText((CharSequence)localObject5);
            localObject5 = dJS();
            if ((localObject3 == null) && (localObject4 == null) && (localObject5 == null)) {
              break label1495;
            }
            bool = false;
            this.ygh.setVisibility(0);
            this.ygi.setVisibility(0);
            if (!WalletSuccPageAwardWidget.a(this.ybX)) {
              break label1476;
            }
            str = "";
            if (this.ygb.CYk.size() > 0) {
              str = ((Orders.Commodity)this.ygb.CYk.get(0)).dlv;
            }
            ad.i("MicroMsg.RemittanceResultNewUI", "transId: %s", new Object[] { str });
            this.ybY.a(this, this.ybX, str, true, (ImageView)findViewById(2131297029));
            this.ybY.init();
            this.ybY.setVisibility(0);
            bF((String)localObject1, false);
            if (localObject3 != null) {
              this.ygi.addView((View)localObject3);
            }
            if (localObject4 != null) {
              this.ygi.addView((View)localObject4);
            }
            if (localObject5 != null) {
              this.ygi.addView((View)localObject5);
            }
          }
          this.yge.setVisibility(0);
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Object localObject5;
            TextView localTextView1;
            this.ygn = null;
            this.ybX = null;
            ad.printErrStackTrace("MicroMsg.RemittanceResultNewUI", localException, "parse f2FPaySucPageResp error: %s", new Object[] { localException.getMessage() });
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
            this.ybY.setVisibility(8);
            bF(localObject2, bool);
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
    if (com.tencent.mm.compatible.util.d.ly(21))
    {
      if (!com.tencent.mm.compatible.util.d.ly(23)) {
        break label126;
      }
      getWindow().setStatusBarColor(getResources().getColor(2131101179));
    }
    for (;;)
    {
      if (getSupportActionBar() != null) {
        getSupportActionBar().hide();
      }
      this.yce.alive();
      this.ygb = ((Orders)getInput().getParcelable("key_orders"));
      this.xnF = ((PayInfo)getInput().getParcelable("key_pay_info"));
      if (this.xnF != null) {
        break;
      }
      ad.e("MicroMsg.RemittanceResultNewUI", "payInfo is null!!!");
      finish();
      AppMethodBeat.o(68289);
      return;
      label126:
      getWindow().setStatusBarColor(getResources().getColor(2131099678));
    }
    String str = "";
    paramBundle = "";
    if (this.xnF.htZ != null)
    {
      this.ygc = this.xnF.htZ.getBoolean("extinfo_key_4");
      str = this.xnF.htZ.getString("extinfo_key_1");
      paramBundle = this.xnF.htZ.getString("extinfo_key_16");
    }
    int i = this.xnF.dCC;
    this.mPayScene = i;
    this.mReceiverName = str;
    ad.i("MicroMsg.RemittanceResultNewUI", "payScene: %s", new Object[] { Integer.valueOf(i) });
    initView();
    if (this.mPayScene == 31)
    {
      ad.i("MicroMsg.RemittanceResultNewUI", "transId: %s", new Object[] { paramBundle });
      com.tencent.mm.plugin.remittance.a.c.dIB().dIE().iV(paramBundle, this.mReceiverName);
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
    this.yce.dead();
    if (WalletSuccPageAwardWidget.a(this.ybX)) {
      this.ybY.onDestroy();
    }
    AppMethodBeat.o(68301);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(68290);
    if (paramInt == 4) {
      dJT();
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(68290);
    return bool;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(68300);
    super.onResume();
    if (WalletSuccPageAwardWidget.a(this.ybX)) {
      this.ybY.onResume();
    }
    AppMethodBeat.o(68300);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(68298);
    if (WalletSuccPageAwardWidget.a(this.ybX))
    {
      bool = this.ybY.onSceneEnd(paramInt1, paramInt2, paramString, paramn);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceResultNewUI
 * JD-Core Version:    0.7.0.1
 */