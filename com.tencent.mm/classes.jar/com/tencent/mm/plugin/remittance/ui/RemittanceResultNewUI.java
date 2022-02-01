package com.tencent.mm.plugin.remittance.ui;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
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
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
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
import com.tencent.mm.g.a.xk;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.remittance.model.ac;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.sf;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.z;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.e;
import java.util.List;

@com.tencent.mm.ui.base.a(19)
public class RemittanceResultNewUI
  extends RemittanceResultUI
{
  private static int[] vIE = null;
  private int mPayScene;
  private String mReceiverName;
  private int mUE;
  private int mUF;
  private com.tencent.mm.ui.widget.b.a mVN;
  private n.d peM;
  private View.OnTouchListener qhG;
  private View.OnLongClickListener qhH;
  private PayInfo uXi;
  private LinearLayout vCJ;
  private e.a.a.c vEk;
  private WalletSuccPageAwardWidget vEl;
  private boolean vEq;
  private com.tencent.mm.sdk.b.c<xk> vEr;
  private LinearLayout vGs;
  private LinearLayout vGt;
  private LinearLayout vGu;
  private TextView vGv;
  private TextView vGw;
  private TextView vGx;
  private TextView vGy;
  private TextView vGz;
  private int vHj;
  private TextView vIA;
  private WalletTextView vIB;
  private sf vIC;
  private Button vID;
  private Orders vIq;
  private boolean vIr;
  private TextView vIs;
  private ViewGroup vIt;
  private TextView vIu;
  private WalletTextView vIv;
  private ViewGroup vIw;
  private ViewGroup vIx;
  private ViewGroup vIy;
  private TextView vIz;
  
  public RemittanceResultNewUI()
  {
    AppMethodBeat.i(68287);
    this.vEq = false;
    this.vEr = new com.tencent.mm.sdk.b.c() {};
    this.mVN = null;
    this.vHj = 0;
    this.peM = new n.d()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(68281);
        ClipboardManager localClipboardManager = (ClipboardManager)aj.getContext().getSystemService("clipboard");
        paramAnonymousMenuItem = "";
        if (bt.iY(RemittanceResultNewUI.c(RemittanceResultNewUI.this), 2131304016)) {
          paramAnonymousMenuItem = RemittanceResultNewUI.d(RemittanceResultNewUI.this).getText().toString().trim();
        }
        while (!bt.iY(RemittanceResultNewUI.c(RemittanceResultNewUI.this), 2131303988))
        {
          localClipboardManager.setPrimaryClip(ClipData.newPlainText(null, paramAnonymousMenuItem));
          com.tencent.mm.ui.base.h.cf(RemittanceResultNewUI.this, RemittanceResultNewUI.this.getString(2131755702));
          AppMethodBeat.o(68281);
          return;
        }
        paramAnonymousMenuItem = new StringBuilder();
        paramAnonymousMenuItem.append(RemittanceResultNewUI.e(RemittanceResultNewUI.this).getText().toString().trim() + " ");
        String str = RemittanceResultNewUI.b(RemittanceResultNewUI.this).getText().toString().trim();
        if (str.endsWith(RemittanceResultNewUI.this.getString(2131762446))) {
          paramAnonymousMenuItem.append(str.substring(0, str.length() - 4));
        }
        for (;;)
        {
          paramAnonymousMenuItem = paramAnonymousMenuItem.toString();
          break;
          paramAnonymousMenuItem.append(str);
        }
      }
    };
    this.qhG = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(68282);
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(68282);
          return false;
          RemittanceResultNewUI.a(RemittanceResultNewUI.this, (int)paramAnonymousMotionEvent.getRawX());
          RemittanceResultNewUI.b(RemittanceResultNewUI.this, (int)paramAnonymousMotionEvent.getRawY());
        }
      }
    };
    this.qhH = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68283);
        ad.d("MicroMsg.RemittanceResultNewUI", "onLongClick");
        if (RemittanceResultNewUI.f(RemittanceResultNewUI.this) == null) {
          RemittanceResultNewUI.a(RemittanceResultNewUI.this, new com.tencent.mm.ui.widget.b.a(RemittanceResultNewUI.this.getContext()));
        }
        RemittanceResultNewUI.f(RemittanceResultNewUI.this).a(paramAnonymousView, RemittanceResultNewUI.this, RemittanceResultNewUI.g(RemittanceResultNewUI.this), RemittanceResultNewUI.h(RemittanceResultNewUI.this), RemittanceResultNewUI.i(RemittanceResultNewUI.this));
        RemittanceResultNewUI.c(RemittanceResultNewUI.this, paramAnonymousView.getId());
        AppMethodBeat.o(68283);
        return true;
      }
    };
    AppMethodBeat.o(68287);
  }
  
  private ViewGroup br(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(68294);
    ad.i("MicroMsg.RemittanceResultNewUI", "setF2FNameView");
    int i;
    if (paramBoolean)
    {
      localViewGroup = (ViewGroup)getLayoutInflater().inflate(2131493902, this.vIx, false);
      localCdnImageView = (CdnImageView)localViewGroup.findViewById(2131304006);
      localTextView = (TextView)localViewGroup.findViewById(2131303742);
      if ((bt.isNullOrNil(this.mReceiverName)) && (this.uXi.Cos != null))
      {
        i = BackwardSupportUtil.b.g(this, 56.0F);
        localCdnImageView.setRoundCorner(true);
        localCdnImageView.r(this.uXi.Cos.getString("extinfo_key_27"), i, i, 2131231875);
      }
      for (;;)
      {
        localTextView.setText(paramString);
        this.vIx.addView(localViewGroup);
        AppMethodBeat.o(68294);
        return localViewGroup;
        a.b.a(localCdnImageView, this.mReceiverName, 0.06F, false);
      }
    }
    ViewGroup localViewGroup = (ViewGroup)getLayoutInflater().inflate(2131493901, this.vIx, false);
    CdnImageView localCdnImageView = (CdnImageView)localViewGroup.findViewById(2131304006);
    TextView localTextView = (TextView)localViewGroup.findViewById(2131303742);
    if ((bt.isNullOrNil(this.mReceiverName)) && (this.uXi.Cos != null))
    {
      i = BackwardSupportUtil.b.g(this, 28.0F);
      localCdnImageView.setRoundCorner(true);
      localCdnImageView.r(this.uXi.Cos.getString("extinfo_key_27"), i, i, 2131231875);
    }
    for (;;)
    {
      localTextView.setText(paramString);
      this.vIx.addView(localViewGroup);
      AppMethodBeat.o(68294);
      return localViewGroup;
      a.b.a(localCdnImageView, this.mReceiverName, 0.06F, false);
    }
  }
  
  private void dkA()
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
          com.tencent.mm.bs.d.e(RemittanceResultNewUI.this, ".ui.chatting.ChattingUI", localIntent);
          AppMethodBeat.o(68286);
          return;
        }
        RemittanceResultNewUI.this.finish();
        AppMethodBeat.o(68286);
      }
    }, 100L);
    AppMethodBeat.o(68297);
  }
  
  private View dky()
  {
    boolean bool = true;
    AppMethodBeat.i(68295);
    if (this.vIq != null)
    {
      if (this.vIq.vAF > 0.0D) {}
      for (;;)
      {
        ad.i("MicroMsg.RemittanceResultNewUI", "need set charge fee: %s", new Object[] { Boolean.valueOf(bool) });
        if (this.vIq.vAF <= 0.0D) {
          break;
        }
        String str1 = getString(2131762522);
        String str2 = e.d(this.vIq.vAF, this.vIq.uop);
        ViewGroup localViewGroup = (ViewGroup)getLayoutInflater().inflate(2131493899, this.vIx, false);
        TextView localTextView1 = (TextView)localViewGroup.findViewById(2131305948);
        ImageView localImageView = (ImageView)localViewGroup.findViewById(2131297008);
        TextView localTextView2 = (TextView)localViewGroup.findViewById(2131299008);
        localTextView1.setText(str1);
        localImageView.setVisibility(8);
        localTextView2.setText(str2);
        this.vIx.addView(localViewGroup);
        AppMethodBeat.o(68295);
        return localViewGroup;
        bool = false;
      }
    }
    AppMethodBeat.o(68295);
    return null;
  }
  
  private void dkz()
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
    dkA();
    AppMethodBeat.o(68296);
  }
  
  public static int n(Context paramContext, String paramString, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(68292);
    int j = com.tencent.mm.cd.a.fromDPToPix(paramContext, 16);
    if (vIE == null) {
      vIE = z.et(paramContext);
    }
    j = (vIE[0] - com.tencent.mm.cd.a.fromDPToPix(paramContext, 88) - paramInt) / j;
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
  
  protected final boolean dkB()
  {
    return false;
  }
  
  public void finish()
  {
    AppMethodBeat.i(68288);
    ad.i("MicroMsg.RemittanceResultNewUI", "finish this %s %s", new Object[] { this, bt.eGN() });
    if (this.vEq)
    {
      AppMethodBeat.o(68288);
      return;
    }
    super.finish();
    this.vEq = true;
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
    this.vIs = ((TextView)findViewById(2131303158));
    this.vIt = ((ViewGroup)findViewById(2131299655));
    this.vIu = ((TextView)findViewById(2131299649));
    this.vIv = ((WalletTextView)findViewById(2131299647));
    this.vIw = ((ViewGroup)findViewById(2131299653));
    this.vIx = ((ViewGroup)findViewById(2131299654));
    this.vIy = ((ViewGroup)findViewById(2131302901));
    this.vIz = ((TextView)findViewById(2131302900));
    this.vIA = ((TextView)findViewById(2131302898));
    this.vIB = ((WalletTextView)findViewById(2131302897));
    this.vID = ((Button)findViewById(2131306063));
    this.vID.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68280);
        RemittanceResultNewUI.a(RemittanceResultNewUI.this);
        AppMethodBeat.o(68280);
      }
    });
    this.vEl = ((WalletSuccPageAwardWidget)findViewById(2131297022));
    this.vGs = ((LinearLayout)findViewById(2131304043));
    this.vGt = ((LinearLayout)findViewById(2131304014));
    this.vCJ = ((LinearLayout)findViewById(2131303987));
    this.vGu = ((LinearLayout)findViewById(2131303988));
    this.vGv = ((TextView)findViewById(2131304019));
    this.vGw = ((TextView)findViewById(2131304016));
    this.vGx = ((TextView)findViewById(2131302665));
    this.vGy = ((TextView)findViewById(2131296478));
    this.vGz = ((TextView)findViewById(2131296477));
    Object localObject1 = e.sh(this.mReceiverName);
    if ((this.mPayScene == 31) || (this.mPayScene == 5))
    {
      this.vIA.setText(e.aNc(this.vIq.uop));
      this.vIB.setText(e.D(this.vIq.dcH));
      if (this.mPayScene == 31)
      {
        localObject1 = getString(2131762525, new Object[] { localObject1 });
        if (!bt.isNullOrNil((String)localObject1)) {
          this.vIz.setText(k.b(this, (CharSequence)localObject1, this.vIz.getTextSize()));
        }
        for (;;)
        {
          this.vIy.setVisibility(0);
          if (this.vIq.vAF > 0.0D)
          {
            dky();
            ((ViewGroup.MarginLayoutParams)this.vIw.getLayoutParams()).topMargin = com.tencent.mm.cd.a.fromDPToPix(this, 20);
            this.vIw.setVisibility(0);
            this.vIx.setVisibility(0);
          }
          ((com.tencent.mm.plugin.fingerprint.b.h)g.ab(com.tencent.mm.plugin.fingerprint.b.h.class)).h(this);
          AppMethodBeat.o(68291);
          return;
          this.vIz.setVisibility(8);
        }
      }
      if ((this.uXi.Cos == null) || (!this.uXi.Cos.getBoolean("extinfo_key_10"))) {
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
          this.vIz.setText(getString(2131762484));
          break;
        }
        if ((this.vIq.Afx == null) || (this.vIq.Afx.get(0) == null) || (TextUtils.isEmpty(((Orders.Commodity)this.vIq.Afx.get(0)).uoe))) {
          break;
        }
        this.vIz.setText(((Orders.Commodity)this.vIq.Afx.get(0)).uoe);
        break;
        localObject1 = getInput().getByteArray("key_succpage_resp");
        if (localObject1 != null) {
          this.vIC = new sf();
        }
        try
        {
          this.vIC.parseFrom((byte[])localObject1);
          this.vEk = this.vIC.AgD;
          localObject3 = e.sh(this.mReceiverName);
          this.vIu.setText(e.aNc(this.vIq.uop));
          this.vIv.setText(e.D(this.vIq.dcH));
          this.vIx.removeAllViews();
          if ((this.mPayScene == 32) || (this.mPayScene == 33) || (this.mPayScene == 48))
          {
            localObject1 = localObject3;
            if (bt.isNullOrNil((String)localObject3))
            {
              localObject1 = localObject3;
              if (this.uXi.Cos != null) {
                localObject1 = this.uXi.Cos.getString("extinfo_key_28");
              }
            }
            localObject3 = "";
            if (this.uXi.Cos != null) {
              localObject3 = this.uXi.Cos.getString("extinfo_key_2");
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
            localObject1 = e.aNf((String)localObject3);
            localObject1 = (String)localObject4 + "(" + (String)localObject1 + ")";
            ad.i("MicroMsg.RemittanceResultNewUI", "setF2FReceiverRemarkView");
            localObject4 = this.uXi.Cos.getString("extinfo_key_3");
            String str = this.uXi.Cos.getString("extinfo_key_8");
            if (bt.isNullOrNil((String)localObject4)) {
              break label1450;
            }
            localObject3 = (ViewGroup)getLayoutInflater().inflate(2131493900, this.vIx, false);
            localObject5 = (TextView)((ViewGroup)localObject3).findViewById(2131305948);
            localTextView1 = (TextView)((ViewGroup)localObject3).findViewById(2131299008);
            if (bt.isNullOrNil(str)) {
              break label1435;
            }
            ((TextView)localObject5).setText(str);
            localTextView1.setText((CharSequence)localObject4);
            ad.i("MicroMsg.RemittanceResultNewUI", "setF2FPayerRemarkView");
            str = this.uXi.Cos.getString("extinfo_key_6");
            localObject5 = this.uXi.Cos.getString("extinfo_key_7");
            if (bt.isNullOrNil((String)localObject5)) {
              break label1470;
            }
            localObject4 = (ViewGroup)getLayoutInflater().inflate(2131493900, this.vIx, false);
            localTextView1 = (TextView)((ViewGroup)localObject4).findViewById(2131305948);
            TextView localTextView2 = (TextView)((ViewGroup)localObject4).findViewById(2131299008);
            if (bt.isNullOrNil(str)) {
              break label1455;
            }
            localTextView1.setText(str);
            localTextView2.setText((CharSequence)localObject5);
            localObject5 = dky();
            if ((localObject3 == null) && (localObject4 == null) && (localObject5 == null)) {
              break label1495;
            }
            bool = false;
            this.vIw.setVisibility(0);
            this.vIx.setVisibility(0);
            if (!WalletSuccPageAwardWidget.a(this.vEk)) {
              break label1476;
            }
            str = "";
            if (this.vIq.Afx.size() > 0) {
              str = ((Orders.Commodity)this.vIq.Afx.get(0)).dcF;
            }
            ad.i("MicroMsg.RemittanceResultNewUI", "transId: %s", new Object[] { str });
            this.vEl.a(this, this.vEk, str, true, (ImageView)findViewById(2131297029));
            this.vEl.init();
            this.vEl.setVisibility(0);
            br((String)localObject1, false);
            if (localObject3 != null) {
              this.vIx.addView((View)localObject3);
            }
            if (localObject4 != null) {
              this.vIx.addView((View)localObject4);
            }
            if (localObject5 != null) {
              this.vIx.addView((View)localObject5);
            }
          }
          this.vIt.setVisibility(0);
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Object localObject5;
            TextView localTextView1;
            this.vIC = null;
            this.vEk = null;
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
            this.vEl.setVisibility(8);
            br(localObject2, bool);
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
    if (com.tencent.mm.compatible.util.d.lf(21))
    {
      if (!com.tencent.mm.compatible.util.d.lf(23)) {
        break label126;
      }
      getWindow().setStatusBarColor(getResources().getColor(2131101179));
    }
    for (;;)
    {
      if (getSupportActionBar() != null) {
        getSupportActionBar().hide();
      }
      this.vEr.alive();
      this.vIq = ((Orders)getInput().getParcelable("key_orders"));
      this.uXi = ((PayInfo)getInput().getParcelable("key_pay_info"));
      if (this.uXi != null) {
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
    if (this.uXi.Cos != null)
    {
      this.vIr = this.uXi.Cos.getBoolean("extinfo_key_4");
      str = this.uXi.Cos.getString("extinfo_key_1");
      paramBundle = this.uXi.Cos.getString("extinfo_key_16");
    }
    int i = this.uXi.dtb;
    this.mPayScene = i;
    this.mReceiverName = str;
    ad.i("MicroMsg.RemittanceResultNewUI", "payScene: %s", new Object[] { Integer.valueOf(i) });
    initView();
    if (this.mPayScene == 31)
    {
      ad.i("MicroMsg.RemittanceResultNewUI", "transId: %s", new Object[] { paramBundle });
      com.tencent.mm.plugin.remittance.a.c.djj().djm().io(paramBundle, this.mReceiverName);
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
    this.vEr.dead();
    if (WalletSuccPageAwardWidget.a(this.vEk)) {
      this.vEl.onDestroy();
    }
    AppMethodBeat.o(68301);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(68290);
    if (paramInt == 4) {
      dkz();
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(68290);
    return bool;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(68300);
    super.onResume();
    if (WalletSuccPageAwardWidget.a(this.vEk)) {
      this.vEl.onResume();
    }
    AppMethodBeat.o(68300);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(68298);
    if (WalletSuccPageAwardWidget.a(this.vEk))
    {
      bool = this.vEl.onSceneEnd(paramInt1, paramInt2, paramString, paramn);
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