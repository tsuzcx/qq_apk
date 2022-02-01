package com.tencent.mm.plugin.remittance.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
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
import androidx.appcompat.app.ActionBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.f.a.abh;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.remittance.model.ak;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.vv;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.KeyBoardUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.g;
import java.util.List;

@com.tencent.mm.ui.base.a(19)
public class RemittanceResultNewUI
  extends RemittanceResultUI
{
  private static int[] Ivv = null;
  private PayInfo HzF;
  private LinearLayout IoD;
  private e.a.a.c Iqj;
  private WalletSuccPageAwardWidget Iqk;
  private boolean Iqp;
  private IListener<abh> Iqq;
  private LinearLayout IsC;
  private LinearLayout IsD;
  private LinearLayout IsE;
  private TextView IsF;
  private TextView IsG;
  private TextView IsH;
  private TextView IsI;
  private TextView IsJ;
  private int Ity;
  private Orders Ivh;
  private boolean Ivi;
  private TextView Ivj;
  private ViewGroup Ivk;
  private TextView Ivl;
  private WalletTextView Ivm;
  private ViewGroup Ivn;
  private ViewGroup Ivo;
  private ViewGroup Ivp;
  private TextView Ivq;
  private TextView Ivr;
  private WalletTextView Ivs;
  private vv Ivt;
  private Button Ivu;
  private int mPayScene;
  private String mReceiverName;
  private int syc;
  private int syd;
  private com.tencent.mm.ui.widget.b.a szq;
  private q.g voR;
  private View.OnTouchListener wOs;
  private View.OnLongClickListener wOt;
  
  public RemittanceResultNewUI()
  {
    AppMethodBeat.i(68287);
    this.Iqp = false;
    this.Iqq = new IListener() {};
    this.szq = null;
    this.Ity = 0;
    this.voR = new q.g()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(68281);
        paramAnonymousMenuItem = "";
        if (Util.isEqual(RemittanceResultNewUI.c(RemittanceResultNewUI.this), a.f.remittance_desc_content_tv)) {
          paramAnonymousMenuItem = RemittanceResultNewUI.d(RemittanceResultNewUI.this).getText().toString().trim();
        }
        while (!Util.isEqual(RemittanceResultNewUI.c(RemittanceResultNewUI.this), a.f.remittance_address_content_ll))
        {
          ClipboardHelper.setText(MMApplicationContext.getContext(), null, paramAnonymousMenuItem);
          com.tencent.mm.ui.base.h.cO(RemittanceResultNewUI.this, RemittanceResultNewUI.this.getString(a.i.app_copy_ok));
          AppMethodBeat.o(68281);
          return;
        }
        paramAnonymousMenuItem = new StringBuilder();
        paramAnonymousMenuItem.append(RemittanceResultNewUI.e(RemittanceResultNewUI.this).getText().toString().trim() + " ");
        String str = RemittanceResultNewUI.b(RemittanceResultNewUI.this).getText().toString().trim();
        if (str.endsWith(RemittanceResultNewUI.this.getString(a.i.remittance_desc_operation_collapse))) {
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
    this.wOs = new View.OnTouchListener()
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
    this.wOt = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68283);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/remittance/ui/RemittanceResultNewUI$6", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aFi());
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
  
  private ViewGroup ck(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(68294);
    Log.i("MicroMsg.RemittanceResultNewUI", "setF2FNameView");
    int i;
    if (paramBoolean)
    {
      localViewGroup = (ViewGroup)getLayoutInflater().inflate(a.g.f2f_transfer_single_big_avatar_detail_item, this.Ivo, false);
      localCdnImageView = (CdnImageView)localViewGroup.findViewById(a.f.remittance_busi_logo);
      localTextView = (TextView)localViewGroup.findViewById(a.f.rbru_rcvr_tv);
      if ((Util.isNullOrNil(this.mReceiverName)) && (this.HzF.lfu != null))
      {
        i = BackwardSupportUtil.BitmapFactory.fromDPToPix(this, 56.0F);
        localCdnImageView.setRoundCorner(true);
        localCdnImageView.w(this.HzF.lfu.getString("extinfo_key_27"), i, i, a.e.default_avatar);
      }
      for (;;)
      {
        localTextView.setText(paramString);
        this.Ivo.addView(localViewGroup);
        AppMethodBeat.o(68294);
        return localViewGroup;
        a.b.a(localCdnImageView, this.mReceiverName, 0.06F, false);
      }
    }
    ViewGroup localViewGroup = (ViewGroup)getLayoutInflater().inflate(a.g.f2f_transfer_new_detail_item, this.Ivo, false);
    CdnImageView localCdnImageView = (CdnImageView)localViewGroup.findViewById(a.f.remittance_busi_logo);
    TextView localTextView = (TextView)localViewGroup.findViewById(a.f.rbru_rcvr_tv);
    if ((Util.isNullOrNil(this.mReceiverName)) && (this.HzF.lfu != null))
    {
      i = BackwardSupportUtil.BitmapFactory.fromDPToPix(this, 28.0F);
      localCdnImageView.setRoundCorner(true);
      localCdnImageView.w(this.HzF.lfu.getString("extinfo_key_27"), i, i, a.e.default_avatar);
    }
    for (;;)
    {
      localTextView.setText(paramString);
      this.Ivo.addView(localViewGroup);
      AppMethodBeat.o(68294);
      return localViewGroup;
      a.b.a(localCdnImageView, this.mReceiverName, 0.06F, false);
    }
  }
  
  private View fAZ()
  {
    boolean bool = true;
    AppMethodBeat.i(68295);
    if (this.Ivh != null)
    {
      if (this.Ivh.Imo > 0.0D) {}
      for (;;)
      {
        Log.i("MicroMsg.RemittanceResultNewUI", "need set charge fee: %s", new Object[] { Boolean.valueOf(bool) });
        if (this.Ivh.Imo <= 0.0D) {
          break;
        }
        String str1 = getString(a.i.remittance_result_charge_fee_wording);
        String str2 = g.d(this.Ivh.Imo, this.Ivh.GHz);
        ViewGroup localViewGroup = (ViewGroup)getLayoutInflater().inflate(a.g.f2f_transfer_detail_item, this.Ivo, false);
        TextView localTextView1 = (TextView)localViewGroup.findViewById(a.f.title_tv);
        ImageView localImageView = (ImageView)localViewGroup.findViewById(a.f.avatar_iv);
        TextView localTextView2 = (TextView)localViewGroup.findViewById(a.f.desc_tv);
        localTextView1.setText(str1);
        localImageView.setVisibility(8);
        localTextView2.setText(str2);
        this.Ivo.addView(localViewGroup);
        AppMethodBeat.o(68295);
        return localViewGroup;
        bool = false;
      }
    }
    AppMethodBeat.o(68295);
    return null;
  }
  
  private void fBa()
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
    fBb();
    AppMethodBeat.o(68296);
  }
  
  private void fBb()
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
          com.tencent.mm.by.c.f(RemittanceResultNewUI.this, ".ui.chatting.ChattingUI", localIntent);
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
    int j = com.tencent.mm.ci.a.fromDPToPix(paramContext, 16);
    if (Ivv == null) {
      Ivv = KeyBoardUtil.getScreenWH(paramContext);
    }
    j = (Ivv[0] - com.tencent.mm.ci.a.fromDPToPix(paramContext, 88) - paramInt) / j;
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
  
  protected final boolean fBc()
  {
    return false;
  }
  
  public void finish()
  {
    AppMethodBeat.i(68288);
    Log.i("MicroMsg.RemittanceResultNewUI", "finish this %s %s", new Object[] { this, Util.getStack() });
    if (this.Iqp)
    {
      AppMethodBeat.o(68288);
      return;
    }
    super.finish();
    this.Iqp = true;
    AppMethodBeat.o(68288);
  }
  
  public int getLayoutId()
  {
    return a.g.remittance_result_new_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(68291);
    setBackBtn(null);
    showHomeBtn(false);
    enableBackMenu(false);
    this.Ivj = ((TextView)findViewById(a.f.pay_succ_wording_tv));
    this.Ivk = ((ViewGroup)findViewById(a.f.f2f_transfer_result_money_layout));
    this.Ivl = ((TextView)findViewById(a.f.f2f_money_unit_tv));
    this.Ivm = ((WalletTextView)findViewById(a.f.f2f_money_amount_tv));
    this.Ivn = ((ViewGroup)findViewById(a.f.f2f_transfer_detail_layout));
    this.Ivo = ((ViewGroup)findViewById(a.f.f2f_transfer_detail_list_layout));
    this.Ivp = ((ViewGroup)findViewById(a.f.normal_transfer_result_money_layout));
    this.Ivq = ((TextView)findViewById(a.f.normal_transfer_desc_tv));
    this.Ivr = ((TextView)findViewById(a.f.normal_money_unit_tv));
    this.Ivs = ((WalletTextView)findViewById(a.f.normal_money_amount_tv));
    this.Ivu = ((Button)findViewById(a.f.transfer_finish_button));
    this.Ivu.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68280);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/remittance/ui/RemittanceResultNewUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        RemittanceResultNewUI.a(RemittanceResultNewUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceResultNewUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(68280);
      }
    });
    this.Iqk = ((WalletSuccPageAwardWidget)findViewById(a.f.award_widget));
    this.IsC = ((LinearLayout)findViewById(a.f.remittance_info_container));
    this.IsD = ((LinearLayout)findViewById(a.f.remittance_desc_container));
    this.IoD = ((LinearLayout)findViewById(a.f.remittance_address_container));
    this.IsE = ((LinearLayout)findViewById(a.f.remittance_address_content_ll));
    this.IsF = ((TextView)findViewById(a.f.remittance_desc_tv));
    this.IsG = ((TextView)findViewById(a.f.remittance_desc_content_tv));
    this.IsH = ((TextView)findViewById(a.f.name_telephone_tv));
    this.IsI = ((TextView)findViewById(a.f.address_detail_tv));
    this.IsJ = ((TextView)findViewById(a.f.address_detail_spread_tv));
    Object localObject1 = g.PJ(this.mReceiverName);
    if ((this.mPayScene == 31) || (this.mPayScene == 5))
    {
      this.Ivr.setText(g.bCm(this.Ivh.GHz));
      this.Ivs.setText(g.formatMoney2f(this.Ivh.fwy));
      if (this.mPayScene == 31)
      {
        localObject1 = getString(a.i.remittance_result_receiver_desc, new Object[] { localObject1 });
        if (!Util.isNullOrNil((String)localObject1)) {
          this.Ivq.setText(l.b(this, (CharSequence)localObject1, this.Ivq.getTextSize()));
        }
        for (;;)
        {
          this.Ivp.setVisibility(0);
          if (this.Ivh.Imo > 0.0D)
          {
            fAZ();
            ((ViewGroup.MarginLayoutParams)this.Ivn.getLayoutParams()).topMargin = com.tencent.mm.ci.a.fromDPToPix(this, 20);
            this.Ivn.setVisibility(0);
            this.Ivo.setVisibility(0);
          }
          ((com.tencent.mm.plugin.fingerprint.b.h)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.fingerprint.b.h.class)).j(this);
          AppMethodBeat.o(68291);
          return;
          this.Ivq.setVisibility(8);
        }
      }
      if ((this.HzF.lfu == null) || (!this.HzF.lfu.getBoolean("extinfo_key_10"))) {
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
          this.Ivq.setText(getString(a.i.remittance_emoji_reward_desc));
          break;
        }
        if ((this.Ivh.ORd == null) || (this.Ivh.ORd.get(0) == null) || (TextUtils.isEmpty(((Orders.Commodity)this.Ivh.ORd.get(0)).GHo))) {
          break;
        }
        this.Ivq.setText(((Orders.Commodity)this.Ivh.ORd.get(0)).GHo);
        break;
        localObject1 = getInput().getByteArray("key_succpage_resp");
        if (localObject1 != null) {
          this.Ivt = new vv();
        }
        try
        {
          this.Ivt.parseFrom((byte[])localObject1);
          this.Iqj = this.Ivt.OSs;
          localObject3 = g.PJ(this.mReceiverName);
          this.Ivl.setText(g.bCm(this.Ivh.GHz));
          this.Ivm.setText(g.formatMoney2f(this.Ivh.fwy));
          this.Ivo.removeAllViews();
          if ((this.mPayScene == 32) || (this.mPayScene == 33) || (this.mPayScene == 48))
          {
            localObject1 = localObject3;
            if (Util.isNullOrNil((String)localObject3))
            {
              localObject1 = localObject3;
              if (this.HzF.lfu != null) {
                localObject1 = this.HzF.lfu.getString("extinfo_key_28");
              }
            }
            localObject3 = "";
            if (this.HzF.lfu != null) {
              localObject3 = this.HzF.lfu.getString("extinfo_key_2");
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
            localObject1 = g.bCp((String)localObject3);
            localObject1 = (String)localObject4 + "(" + (String)localObject1 + ")";
            Log.i("MicroMsg.RemittanceResultNewUI", "setF2FReceiverRemarkView");
            localObject4 = this.HzF.lfu.getString("extinfo_key_3");
            String str = this.HzF.lfu.getString("extinfo_key_8");
            if (Util.isNullOrNil((String)localObject4)) {
              break label1450;
            }
            localObject3 = (ViewGroup)getLayoutInflater().inflate(a.g.f2f_transfer_detail_item_2, this.Ivo, false);
            localObject5 = (TextView)((ViewGroup)localObject3).findViewById(a.f.title_tv);
            localTextView1 = (TextView)((ViewGroup)localObject3).findViewById(a.f.desc_tv);
            if (Util.isNullOrNil(str)) {
              break label1435;
            }
            ((TextView)localObject5).setText(str);
            localTextView1.setText((CharSequence)localObject4);
            Log.i("MicroMsg.RemittanceResultNewUI", "setF2FPayerRemarkView");
            str = this.HzF.lfu.getString("extinfo_key_6");
            localObject5 = this.HzF.lfu.getString("extinfo_key_7");
            if (Util.isNullOrNil((String)localObject5)) {
              break label1470;
            }
            localObject4 = (ViewGroup)getLayoutInflater().inflate(a.g.f2f_transfer_detail_item_2, this.Ivo, false);
            localTextView1 = (TextView)((ViewGroup)localObject4).findViewById(a.f.title_tv);
            TextView localTextView2 = (TextView)((ViewGroup)localObject4).findViewById(a.f.desc_tv);
            if (Util.isNullOrNil(str)) {
              break label1455;
            }
            localTextView1.setText(str);
            localTextView2.setText((CharSequence)localObject5);
            localObject5 = fAZ();
            if ((localObject3 == null) && (localObject4 == null) && (localObject5 == null)) {
              break label1495;
            }
            bool = false;
            this.Ivn.setVisibility(0);
            this.Ivo.setVisibility(0);
            if (!WalletSuccPageAwardWidget.a(this.Iqj)) {
              break label1476;
            }
            str = "";
            if (this.Ivh.ORd.size() > 0) {
              str = ((Orders.Commodity)this.Ivh.ORd.get(0)).fww;
            }
            Log.i("MicroMsg.RemittanceResultNewUI", "transId: %s", new Object[] { str });
            this.Iqk.a(this, this.Iqj, str, true, (ImageView)findViewById(a.f.background));
            this.Iqk.init();
            this.Iqk.setVisibility(0);
            ck((String)localObject1, false);
            if (localObject3 != null) {
              this.Ivo.addView((View)localObject3);
            }
            if (localObject4 != null) {
              this.Ivo.addView((View)localObject4);
            }
            if (localObject5 != null) {
              this.Ivo.addView((View)localObject5);
            }
          }
          this.Ivk.setVisibility(0);
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Object localObject5;
            TextView localTextView1;
            this.Ivt = null;
            this.Iqj = null;
            Log.printErrStackTrace("MicroMsg.RemittanceResultNewUI", localException, "parse f2FPaySucPageResp error: %s", new Object[] { localException.getMessage() });
            continue;
            Object localObject2 = localObject3;
            continue;
            ((TextView)localObject5).setText(getString(a.i.collect_create_qrcode_receiver_msg_title));
            continue;
            Object localObject3 = null;
            continue;
            localTextView1.setText(getString(a.i.collect_create_qrcode_payer_msg_title));
            continue;
            Object localObject4 = null;
            continue;
            this.Iqk.setVisibility(8);
            ck(localObject2, bool);
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
    if (com.tencent.mm.compatible.util.d.qV(21))
    {
      if (!com.tencent.mm.compatible.util.d.qV(23)) {
        break label126;
      }
      getWindow().setStatusBarColor(getResources().getColor(a.c.white));
    }
    for (;;)
    {
      if (getSupportActionBar() != null) {
        getSupportActionBar().hide();
      }
      this.Iqq.alive();
      this.Ivh = ((Orders)getInput().getParcelable("key_orders"));
      this.HzF = ((PayInfo)getInput().getParcelable("key_pay_info"));
      if (this.HzF != null) {
        break;
      }
      Log.e("MicroMsg.RemittanceResultNewUI", "payInfo is null!!!");
      finish();
      AppMethodBeat.o(68289);
      return;
      label126:
      getWindow().setStatusBarColor(getResources().getColor(a.c.BW_90));
    }
    String str = "";
    paramBundle = "";
    if (this.HzF.lfu != null)
    {
      this.Ivi = this.HzF.lfu.getBoolean("extinfo_key_4");
      str = this.HzF.lfu.getString("extinfo_key_1");
      paramBundle = this.HzF.lfu.getString("extinfo_key_16");
    }
    int i = this.HzF.fOY;
    this.mPayScene = i;
    this.mReceiverName = str;
    Log.i("MicroMsg.RemittanceResultNewUI", "payScene: %s", new Object[] { Integer.valueOf(i) });
    initView();
    if (this.mPayScene == 31)
    {
      Log.i("MicroMsg.RemittanceResultNewUI", "transId: %s", new Object[] { paramBundle });
      com.tencent.mm.plugin.remittance.a.c.fzJ().fzM().kd(paramBundle, this.mReceiverName);
    }
    AppMethodBeat.o(68289);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(68293);
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    paramContextMenu.add(0, 0, 0, getString(a.i.app_copy));
    AppMethodBeat.o(68293);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(68301);
    super.onDestroy();
    this.Iqq.dead();
    if (WalletSuccPageAwardWidget.a(this.Iqj)) {
      this.Iqk.onDestroy();
    }
    AppMethodBeat.o(68301);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(68290);
    if (paramInt == 4) {
      fBa();
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(68290);
    return bool;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(68300);
    super.onResume();
    if (WalletSuccPageAwardWidget.a(this.Iqj)) {
      this.Iqk.onResume();
    }
    AppMethodBeat.o(68300);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(68298);
    if (WalletSuccPageAwardWidget.a(this.Iqj))
    {
      bool = this.Iqk.onSceneEnd(paramInt1, paramInt2, paramString, paramq);
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