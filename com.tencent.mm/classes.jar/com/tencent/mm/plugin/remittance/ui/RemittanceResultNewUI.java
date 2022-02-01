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
import android.view.MenuItem;
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
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.aaa;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.remittance.model.ac;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.vt;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.KeyBoardUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.f;
import java.util.List;

@com.tencent.mm.ui.base.a(19)
public class RemittanceResultNewUI
  extends RemittanceResultUI
{
  private static int[] Cxc = null;
  private PayInfo BDB;
  private LinearLayout Cre;
  private e.a.a.c CsF;
  private WalletSuccPageAwardWidget CsG;
  private boolean CsL;
  private IListener<aaa> CsM;
  private LinearLayout CuN;
  private LinearLayout CuO;
  private LinearLayout CuP;
  private TextView CuQ;
  private TextView CuR;
  private TextView CuS;
  private TextView CuT;
  private TextView CuU;
  private int CvI;
  private Orders CwO;
  private boolean CwP;
  private TextView CwQ;
  private ViewGroup CwR;
  private TextView CwS;
  private WalletTextView CwT;
  private ViewGroup CwU;
  private ViewGroup CwV;
  private ViewGroup CwW;
  private TextView CwX;
  private TextView CwY;
  private WalletTextView CwZ;
  private vt Cxa;
  private Button Cxb;
  private int mPayScene;
  private String mReceiverName;
  private int ppd;
  private int ppe;
  private com.tencent.mm.ui.widget.b.a pqr;
  private o.g rJj;
  private View.OnTouchListener tia;
  private View.OnLongClickListener tib;
  
  public RemittanceResultNewUI()
  {
    AppMethodBeat.i(68287);
    this.CsL = false;
    this.CsM = new IListener() {};
    this.pqr = null;
    this.CvI = 0;
    this.rJj = new o.g()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(68281);
        paramAnonymousMenuItem = "";
        if (Util.isEqual(RemittanceResultNewUI.c(RemittanceResultNewUI.this), 2131306872)) {
          paramAnonymousMenuItem = RemittanceResultNewUI.d(RemittanceResultNewUI.this).getText().toString().trim();
        }
        while (!Util.isEqual(RemittanceResultNewUI.c(RemittanceResultNewUI.this), 2131306844))
        {
          ClipboardHelper.setText(MMApplicationContext.getContext(), null, paramAnonymousMenuItem);
          com.tencent.mm.ui.base.h.cD(RemittanceResultNewUI.this, RemittanceResultNewUI.this.getString(2131755773));
          AppMethodBeat.o(68281);
          return;
        }
        paramAnonymousMenuItem = new StringBuilder();
        paramAnonymousMenuItem.append(RemittanceResultNewUI.e(RemittanceResultNewUI.this).getText().toString().trim() + " ");
        String str = RemittanceResultNewUI.b(RemittanceResultNewUI.this).getText().toString().trim();
        if (str.endsWith(RemittanceResultNewUI.this.getString(2131764512))) {
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
    this.tia = new RemittanceResultNewUI.4(this);
    this.tib = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68283);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceResultNewUI$6", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.axR());
        Log.d("MicroMsg.RemittanceResultNewUI", "onLongClick");
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
  
  private ViewGroup ca(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(68294);
    Log.i("MicroMsg.RemittanceResultNewUI", "setF2FNameView");
    int i;
    if (paramBoolean)
    {
      localViewGroup = (ViewGroup)getLayoutInflater().inflate(2131494059, this.CwV, false);
      localCdnImageView = (CdnImageView)localViewGroup.findViewById(2131306862);
      localTextView = (TextView)localViewGroup.findViewById(2131306531);
      if ((Util.isNullOrNil(this.mReceiverName)) && (this.BDB.iqp != null))
      {
        i = BackwardSupportUtil.BitmapFactory.fromDPToPix(this, 56.0F);
        localCdnImageView.setRoundCorner(true);
        localCdnImageView.s(this.BDB.iqp.getString("extinfo_key_27"), i, i, 2131231957);
      }
      for (;;)
      {
        localTextView.setText(paramString);
        this.CwV.addView(localViewGroup);
        AppMethodBeat.o(68294);
        return localViewGroup;
        a.b.a(localCdnImageView, this.mReceiverName, 0.06F, false);
      }
    }
    ViewGroup localViewGroup = (ViewGroup)getLayoutInflater().inflate(2131494058, this.CwV, false);
    CdnImageView localCdnImageView = (CdnImageView)localViewGroup.findViewById(2131306862);
    TextView localTextView = (TextView)localViewGroup.findViewById(2131306531);
    if ((Util.isNullOrNil(this.mReceiverName)) && (this.BDB.iqp != null))
    {
      i = BackwardSupportUtil.BitmapFactory.fromDPToPix(this, 28.0F);
      localCdnImageView.setRoundCorner(true);
      localCdnImageView.s(this.BDB.iqp.getString("extinfo_key_27"), i, i, 2131231957);
    }
    for (;;)
    {
      localTextView.setText(paramString);
      this.CwV.addView(localViewGroup);
      AppMethodBeat.o(68294);
      return localViewGroup;
      a.b.a(localCdnImageView, this.mReceiverName, 0.06F, false);
    }
  }
  
  private View eOk()
  {
    boolean bool = true;
    AppMethodBeat.i(68295);
    if (this.CwO != null)
    {
      if (this.CwO.CoZ > 0.0D) {}
      for (;;)
      {
        Log.i("MicroMsg.RemittanceResultNewUI", "need set charge fee: %s", new Object[] { Boolean.valueOf(bool) });
        if (this.CwO.CoZ <= 0.0D) {
          break;
        }
        String str1 = getString(2131764589);
        String str2 = f.d(this.CwO.CoZ, this.CwO.AOl);
        ViewGroup localViewGroup = (ViewGroup)getLayoutInflater().inflate(2131494056, this.CwV, false);
        TextView localTextView1 = (TextView)localViewGroup.findViewById(2131309249);
        ImageView localImageView = (ImageView)localViewGroup.findViewById(2131297134);
        TextView localTextView2 = (TextView)localViewGroup.findViewById(2131299510);
        localTextView1.setText(str1);
        localImageView.setVisibility(8);
        localTextView2.setText(str2);
        this.CwV.addView(localViewGroup);
        AppMethodBeat.o(68295);
        return localViewGroup;
        bool = false;
      }
    }
    AppMethodBeat.o(68295);
    return null;
  }
  
  private void eOl()
  {
    AppMethodBeat.i(68296);
    Log.i("MicroMsg.RemittanceResultNewUI", "endRemittance");
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
    eOm();
    AppMethodBeat.o(68296);
  }
  
  private void eOm()
  {
    AppMethodBeat.i(68297);
    Log.i("MicroMsg.RemittanceResultNewUI", "doEndRemittance");
    getProcess().b(this, getInput());
    new MMHandler().postDelayed(new Runnable()
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
        if ((!Util.isNullOrNil(RemittanceResultNewUI.l(RemittanceResultNewUI.this))) && (!RemittanceResultNewUI.m(RemittanceResultNewUI.this)))
        {
          Intent localIntent = new Intent();
          localIntent.putExtra("Chat_User", RemittanceResultNewUI.l(RemittanceResultNewUI.this));
          localIntent.putExtra("finish_direct", false);
          com.tencent.mm.br.c.f(RemittanceResultNewUI.this, ".ui.chatting.ChattingUI", localIntent);
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
    if (Cxc == null) {
      Cxc = KeyBoardUtil.getScreenWH(paramContext);
    }
    j = (Cxc[0] - com.tencent.mm.cb.a.fromDPToPix(paramContext, 88) - paramInt) / j;
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
  
  protected final boolean eOn()
  {
    return false;
  }
  
  public void finish()
  {
    AppMethodBeat.i(68288);
    Log.i("MicroMsg.RemittanceResultNewUI", "finish this %s %s", new Object[] { this, Util.getStack() });
    if (this.CsL)
    {
      AppMethodBeat.o(68288);
      return;
    }
    super.finish();
    this.CsL = true;
    AppMethodBeat.o(68288);
  }
  
  public int getLayoutId()
  {
    return 2131496110;
  }
  
  public void initView()
  {
    AppMethodBeat.i(68291);
    setBackBtn(null);
    showHomeBtn(false);
    enableBackMenu(false);
    this.CwQ = ((TextView)findViewById(2131305815));
    this.CwR = ((ViewGroup)findViewById(2131300296));
    this.CwS = ((TextView)findViewById(2131300290));
    this.CwT = ((WalletTextView)findViewById(2131300288));
    this.CwU = ((ViewGroup)findViewById(2131300294));
    this.CwV = ((ViewGroup)findViewById(2131300295));
    this.CwW = ((ViewGroup)findViewById(2131305484));
    this.CwX = ((TextView)findViewById(2131305483));
    this.CwY = ((TextView)findViewById(2131305480));
    this.CwZ = ((WalletTextView)findViewById(2131305479));
    this.Cxb = ((Button)findViewById(2131309392));
    this.Cxb.setOnClickListener(new RemittanceResultNewUI.2(this));
    this.CsG = ((WalletSuccPageAwardWidget)findViewById(2131297151));
    this.CuN = ((LinearLayout)findViewById(2131306906));
    this.CuO = ((LinearLayout)findViewById(2131306870));
    this.Cre = ((LinearLayout)findViewById(2131306843));
    this.CuP = ((LinearLayout)findViewById(2131306844));
    this.CuQ = ((TextView)findViewById(2131306875));
    this.CuR = ((TextView)findViewById(2131306872));
    this.CuS = ((TextView)findViewById(2131305219));
    this.CuT = ((TextView)findViewById(2131296552));
    this.CuU = ((TextView)findViewById(2131296551));
    Object localObject1 = f.getDisplayName(this.mReceiverName);
    if ((this.mPayScene == 31) || (this.mPayScene == 5))
    {
      this.CwY.setText(f.bpp(this.CwO.AOl));
      this.CwZ.setText(f.formatMoney2f(this.CwO.dDO));
      if (this.mPayScene == 31)
      {
        localObject1 = getString(2131764592, new Object[] { localObject1 });
        if (!Util.isNullOrNil((String)localObject1)) {
          this.CwX.setText(l.b(this, (CharSequence)localObject1, this.CwX.getTextSize()));
        }
        for (;;)
        {
          this.CwW.setVisibility(0);
          if (this.CwO.CoZ > 0.0D)
          {
            eOk();
            ((ViewGroup.MarginLayoutParams)this.CwU.getLayoutParams()).topMargin = com.tencent.mm.cb.a.fromDPToPix(this, 20);
            this.CwU.setVisibility(0);
            this.CwV.setVisibility(0);
          }
          ((com.tencent.mm.plugin.fingerprint.b.h)g.af(com.tencent.mm.plugin.fingerprint.b.h.class)).i(this);
          AppMethodBeat.o(68291);
          return;
          this.CwX.setVisibility(8);
        }
      }
      if ((this.BDB.iqp == null) || (!this.BDB.iqp.getBoolean("extinfo_key_10"))) {
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
        Log.i("MicroMsg.RemittanceResultNewUI", "isEmojiReward: %s", new Object[] { Boolean.valueOf(bool) });
        if (bool)
        {
          this.CwX.setText(getString(2131764551));
          break;
        }
        if ((this.CwO.HZd == null) || (this.CwO.HZd.get(0) == null) || (TextUtils.isEmpty(((Orders.Commodity)this.CwO.HZd.get(0)).AOa))) {
          break;
        }
        this.CwX.setText(((Orders.Commodity)this.CwO.HZd.get(0)).AOa);
        break;
        localObject1 = getInput().getByteArray("key_succpage_resp");
        if (localObject1 != null) {
          this.Cxa = new vt();
        }
        try
        {
          this.Cxa.parseFrom((byte[])localObject1);
          this.CsF = this.Cxa.Iah;
          localObject3 = f.getDisplayName(this.mReceiverName);
          this.CwS.setText(f.bpp(this.CwO.AOl));
          this.CwT.setText(f.formatMoney2f(this.CwO.dDO));
          this.CwV.removeAllViews();
          if ((this.mPayScene == 32) || (this.mPayScene == 33) || (this.mPayScene == 48))
          {
            localObject1 = localObject3;
            if (Util.isNullOrNil((String)localObject3))
            {
              localObject1 = localObject3;
              if (this.BDB.iqp != null) {
                localObject1 = this.BDB.iqp.getString("extinfo_key_28");
              }
            }
            localObject3 = "";
            if (this.BDB.iqp != null) {
              localObject3 = this.BDB.iqp.getString("extinfo_key_2");
            }
            localObject4 = localObject1;
            if (localObject1 != null)
            {
              localObject4 = localObject1;
              if (((String)localObject1).length() > 10) {
                localObject4 = ((String)localObject1).substring(0, 10) + "...";
              }
            }
            if (Util.isNullOrNil((String)localObject3)) {
              break label1500;
            }
            if (Util.isNullOrNil((String)localObject4)) {
              break label1430;
            }
            localObject1 = f.bps((String)localObject3);
            localObject1 = (String)localObject4 + "(" + (String)localObject1 + ")";
            Log.i("MicroMsg.RemittanceResultNewUI", "setF2FReceiverRemarkView");
            localObject4 = this.BDB.iqp.getString("extinfo_key_3");
            String str = this.BDB.iqp.getString("extinfo_key_8");
            if (Util.isNullOrNil((String)localObject4)) {
              break label1450;
            }
            localObject3 = (ViewGroup)getLayoutInflater().inflate(2131494057, this.CwV, false);
            localObject5 = (TextView)((ViewGroup)localObject3).findViewById(2131309249);
            localTextView1 = (TextView)((ViewGroup)localObject3).findViewById(2131299510);
            if (Util.isNullOrNil(str)) {
              break label1435;
            }
            ((TextView)localObject5).setText(str);
            localTextView1.setText((CharSequence)localObject4);
            Log.i("MicroMsg.RemittanceResultNewUI", "setF2FPayerRemarkView");
            str = this.BDB.iqp.getString("extinfo_key_6");
            localObject5 = this.BDB.iqp.getString("extinfo_key_7");
            if (Util.isNullOrNil((String)localObject5)) {
              break label1470;
            }
            localObject4 = (ViewGroup)getLayoutInflater().inflate(2131494057, this.CwV, false);
            localTextView1 = (TextView)((ViewGroup)localObject4).findViewById(2131309249);
            TextView localTextView2 = (TextView)((ViewGroup)localObject4).findViewById(2131299510);
            if (Util.isNullOrNil(str)) {
              break label1455;
            }
            localTextView1.setText(str);
            localTextView2.setText((CharSequence)localObject5);
            localObject5 = eOk();
            if ((localObject3 == null) && (localObject4 == null) && (localObject5 == null)) {
              break label1495;
            }
            bool = false;
            this.CwU.setVisibility(0);
            this.CwV.setVisibility(0);
            if (!WalletSuccPageAwardWidget.a(this.CsF)) {
              break label1476;
            }
            str = "";
            if (this.CwO.HZd.size() > 0) {
              str = ((Orders.Commodity)this.CwO.HZd.get(0)).dDM;
            }
            Log.i("MicroMsg.RemittanceResultNewUI", "transId: %s", new Object[] { str });
            this.CsG.a(this, this.CsF, str, true, (ImageView)findViewById(2131297171));
            this.CsG.init();
            this.CsG.setVisibility(0);
            ca((String)localObject1, false);
            if (localObject3 != null) {
              this.CwV.addView((View)localObject3);
            }
            if (localObject4 != null) {
              this.CwV.addView((View)localObject4);
            }
            if (localObject5 != null) {
              this.CwV.addView((View)localObject5);
            }
          }
          this.CwR.setVisibility(0);
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Object localObject5;
            TextView localTextView1;
            this.Cxa = null;
            this.CsF = null;
            Log.printErrStackTrace("MicroMsg.RemittanceResultNewUI", localException, "parse f2FPaySucPageResp error: %s", new Object[] { localException.getMessage() });
            continue;
            Object localObject2 = localObject3;
            continue;
            ((TextView)localObject5).setText(getString(2131757670));
            continue;
            Object localObject3 = null;
            continue;
            localTextView1.setText(getString(2131757669));
            continue;
            Object localObject4 = null;
            continue;
            this.CsG.setVisibility(8);
            ca(localObject2, bool);
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
    if (com.tencent.mm.compatible.util.d.oD(21))
    {
      if (!com.tencent.mm.compatible.util.d.oD(23)) {
        break label126;
      }
      getWindow().setStatusBarColor(getResources().getColor(2131101424));
    }
    for (;;)
    {
      if (getSupportActionBar() != null) {
        getSupportActionBar().hide();
      }
      this.CsM.alive();
      this.CwO = ((Orders)getInput().getParcelable("key_orders"));
      this.BDB = ((PayInfo)getInput().getParcelable("key_pay_info"));
      if (this.BDB != null) {
        break;
      }
      Log.e("MicroMsg.RemittanceResultNewUI", "payInfo is null!!!");
      finish();
      AppMethodBeat.o(68289);
      return;
      label126:
      getWindow().setStatusBarColor(getResources().getColor(2131099687));
    }
    String str = "";
    paramBundle = "";
    if (this.BDB.iqp != null)
    {
      this.CwP = this.BDB.iqp.getBoolean("extinfo_key_4");
      str = this.BDB.iqp.getString("extinfo_key_1");
      paramBundle = this.BDB.iqp.getString("extinfo_key_16");
    }
    int i = this.BDB.dVv;
    this.mPayScene = i;
    this.mReceiverName = str;
    Log.i("MicroMsg.RemittanceResultNewUI", "payScene: %s", new Object[] { Integer.valueOf(i) });
    initView();
    if (this.mPayScene == 31)
    {
      Log.i("MicroMsg.RemittanceResultNewUI", "transId: %s", new Object[] { paramBundle });
      com.tencent.mm.plugin.remittance.a.c.eMU().eMX().jM(paramBundle, this.mReceiverName);
    }
    AppMethodBeat.o(68289);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(68293);
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    paramContextMenu.add(0, 0, 0, getString(2131755772));
    AppMethodBeat.o(68293);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(68301);
    super.onDestroy();
    this.CsM.dead();
    if (WalletSuccPageAwardWidget.a(this.CsF)) {
      this.CsG.onDestroy();
    }
    AppMethodBeat.o(68301);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(68290);
    if (paramInt == 4) {
      eOl();
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(68290);
    return bool;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(68300);
    super.onResume();
    if (WalletSuccPageAwardWidget.a(this.CsF)) {
      this.CsG.onResume();
    }
    AppMethodBeat.o(68300);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(68298);
    if (WalletSuccPageAwardWidget.a(this.CsF))
    {
      bool = this.CsG.onSceneEnd(paramInt1, paramInt2, paramString, paramq);
      AppMethodBeat.o(68298);
      return bool;
    }
    boolean bool = super.onSceneEnd(paramInt1, paramInt2, paramString, paramq);
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