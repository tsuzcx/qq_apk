package com.tencent.mm.plugin.remittance.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.ade;
import com.tencent.mm.autogen.a.az;
import com.tencent.mm.autogen.a.zp;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.remittance.model.BusiRemittanceResp;
import com.tencent.mm.plugin.remittance.model.aa;
import com.tencent.mm.plugin.remittance.model.l;
import com.tencent.mm.plugin.remittance.model.m;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget;
import com.tencent.mm.plugin.wallet_core.utils.n;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.eh;
import com.tencent.mm.protocal.protobuf.se;
import com.tencent.mm.protocal.protobuf.sf;
import com.tencent.mm.protocal.protobuf.so;
import com.tencent.mm.protocal.protobuf.tl;
import com.tencent.mm.protocal.protobuf.ug;
import com.tencent.mm.protocal.protobuf.up;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import g.a.a.c;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(19)
public class RemittanceBusiResultUI
  extends WalletBaseUI
{
  private String MyF;
  private int OhM;
  private String OhN;
  private String OlF;
  private TextView OmP;
  private TextView OmQ;
  private TextView OmR;
  private TextView OmS;
  private TextView OmT;
  private CdnImageView OmU;
  private TextView OmV;
  private TextView OmW;
  private TextView OmX;
  private Button OmY;
  private ViewGroup OmZ;
  private String Omj;
  private ug OnA;
  private int OnB;
  private c OnC;
  private WalletSuccPageAwardWidget OnD;
  private ViewGroup OnE;
  private ViewGroup OnF;
  private ViewGroup OnG;
  private TextView OnH;
  private boolean OnI;
  private IListener<ade> OnJ;
  private boolean OnK;
  private Runnable OnL;
  private ViewGroup Ona;
  private ViewGroup Onb;
  private ViewGroup Onc;
  private View Ond;
  private LinearLayout One;
  private String Onf;
  private String Ong;
  private String Onh;
  private double Oni;
  private String Onj;
  private String Onk;
  private String Onl;
  private int Onm;
  private String Onn;
  private String Ono;
  private com.tencent.mm.bx.b Onp;
  private boolean Onq;
  private String Onr;
  private BusiRemittanceResp Ons;
  private sf Ont;
  private boolean Onu;
  private ResultReceiver Onv;
  private LinearLayout Onw;
  private LinearLayout Onx;
  private Runnable Ony;
  private eh Onz;
  private String app_id;
  private int mChannel;
  private int mPayScene;
  private TextView sUt;
  private Button tHj;
  private int ypf;
  
  public RemittanceBusiResultUI()
  {
    AppMethodBeat.i(67998);
    this.Onq = false;
    this.Onu = false;
    this.Ony = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(67990);
        if (RemittanceBusiResultUI.a(RemittanceBusiResultUI.this) == 65)
        {
          Log.i("MicroMsg.RemittanceBusiResultUI", "mPayScene == WalletConstantsProtocal.MMPAY_PAY_SCENE_PERSONAL_PAYMENT_PROCESS,do not doNetSceneBusiF2fSucpage");
          AppMethodBeat.o(67990);
          return;
        }
        RemittanceBusiResultUI.b(RemittanceBusiResultUI.this);
        m localm = new m(RemittanceBusiResultUI.c(RemittanceBusiResultUI.this), RemittanceBusiResultUI.d(RemittanceBusiResultUI.this), RemittanceBusiResultUI.e(RemittanceBusiResultUI.this).eQp, RemittanceBusiResultUI.f(RemittanceBusiResultUI.this) - 1, System.currentTimeMillis());
        RemittanceBusiResultUI.this.doSceneProgress(localm);
        RemittanceBusiResultUI.g(RemittanceBusiResultUI.this);
        AppMethodBeat.o(67990);
      }
    };
    this.Onz = new eh();
    this.OnA = new ug();
    this.OnI = false;
    this.OnJ = new IListener(f.hfK) {};
    this.OnK = true;
    this.OnL = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(67997);
        RemittanceBusiResultUI.p(RemittanceBusiResultUI.this);
        AppMethodBeat.o(67997);
      }
    };
    AppMethodBeat.o(67998);
  }
  
  private void a(m paramm)
  {
    AppMethodBeat.i(289159);
    if (!Util.isNullOrNil(paramm.OiX.YYd))
    {
      if (Util.isNullOrNil(paramm.OiX.YYe)) {
        this.OmT.setTextColor(getResources().getColor(a.c.normal_color));
      }
      for (;;)
      {
        this.OmT.setText(paramm.OiX.YYd);
        this.Onb.setVisibility(0);
        AppMethodBeat.o(289159);
        return;
        this.OmT.setTextColor(n.dE(paramm.OiX.YYe, true));
      }
    }
    this.Onb.setVisibility(8);
    AppMethodBeat.o(289159);
  }
  
  private void b(m paramm)
  {
    AppMethodBeat.i(68008);
    this.OnF.setVisibility(8);
    this.OnE.setVisibility(8);
    this.OnG.setVisibility(8);
    TextView localTextView = (TextView)findViewById(a.f.total_favor_desc);
    final View localView = findViewById(a.f.total_favor_desc_pack_up);
    LinkedList localLinkedList;
    int i;
    Object localObject2;
    int j;
    Object localObject1;
    if ((paramm != null) && (paramm.OiX != null) && (paramm.OiX.YXZ.size() > 0))
    {
      localLinkedList = paramm.OiX.YXZ;
      if (localLinkedList != null)
      {
        i = localLinkedList.size();
        Log.i("MicroMsg.RemittanceBusiResultUI", "discountInfoList: %s, size: %s received_amount: %s", new Object[] { localLinkedList, Integer.valueOf(i), Long.valueOf(paramm.OiX.YXY) });
        localObject2 = "";
        j = localLinkedList.size();
        localObject1 = localObject2;
        if (localLinkedList == null) {
          break label407;
        }
        localObject1 = localObject2;
        if (localLinkedList.size() <= 0) {
          break label407;
        }
        this.OnF.removeAllViews();
        this.OnE.setOnClickListener(null);
        if (j <= 1) {
          break label512;
        }
        paramm = paramm.OiX.YYc;
        this.OnK = true;
        localView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(67995);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/remittance/ui/RemittanceBusiResultUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            if (RemittanceBusiResultUI.l(RemittanceBusiResultUI.this))
            {
              localView.setVisibility(8);
              RemittanceBusiResultUI.m(RemittanceBusiResultUI.this).setVisibility(0);
              paramAnonymousView = RemittanceBusiResultUI.this;
              RemittanceBusiResultUI.n(RemittanceBusiResultUI.this);
              RemittanceBusiResultUI.o(paramAnonymousView);
              paramAnonymousView = RemittanceBusiResultUI.this;
              if (RemittanceBusiResultUI.l(RemittanceBusiResultUI.this)) {
                break label152;
              }
            }
            label152:
            for (boolean bool = true;; bool = false)
            {
              RemittanceBusiResultUI.a(paramAnonymousView, bool);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceBusiResultUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(67995);
              return;
              localView.setVisibility(0);
              RemittanceBusiResultUI.m(RemittanceBusiResultUI.this).setVisibility(8);
              RemittanceBusiResultUI.o(RemittanceBusiResultUI.this);
              break;
            }
          }
        });
        this.OnE.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(67996);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/remittance/ui/RemittanceBusiResultUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            if (RemittanceBusiResultUI.l(RemittanceBusiResultUI.this))
            {
              localView.setVisibility(8);
              RemittanceBusiResultUI.m(RemittanceBusiResultUI.this).setVisibility(0);
              paramAnonymousView = RemittanceBusiResultUI.this;
              RemittanceBusiResultUI.n(RemittanceBusiResultUI.this);
              RemittanceBusiResultUI.o(paramAnonymousView);
              paramAnonymousView = RemittanceBusiResultUI.this;
              if (RemittanceBusiResultUI.l(RemittanceBusiResultUI.this)) {
                break label152;
              }
            }
            label152:
            for (boolean bool = true;; bool = false)
            {
              RemittanceBusiResultUI.a(paramAnonymousView, bool);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceBusiResultUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(67996);
              return;
              localView.setVisibility(0);
              RemittanceBusiResultUI.m(RemittanceBusiResultUI.this).setVisibility(8);
              RemittanceBusiResultUI.o(RemittanceBusiResultUI.this);
              break;
            }
          }
        });
      }
    }
    for (;;)
    {
      if ((j == 1) && (localLinkedList.get(0) != null)) {
        paramm = (String)localLinkedList.get(0);
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
            localLayoutParams.bottomMargin = com.tencent.mm.cd.a.fromDPToPix(this, 6);
            ((TextView)localObject2).setLayoutParams(localLayoutParams);
            ((TextView)localObject2).setTextSize(1, 12.0F);
            ((TextView)localObject2).setTextColor(getResources().getColor(a.c.Orange));
            ((TextView)localObject2).setText((CharSequence)localObject1);
            this.OnF.addView((View)localObject2);
            i += 1;
            continue;
            i = 0;
            break;
          }
        }
        this.OnF.setVisibility(0);
        this.OnE.setVisibility(0);
        localObject1 = paramm;
        label407:
        if (this.OnK)
        {
          localView.setVisibility(0);
          paramm = Util.nullAs((String)localObject1, "");
          paramm = new SpannableString(paramm + " ");
          if (j <= 1) {
            break label494;
          }
          findViewById(a.f.total_favor_pack_up_arrow).setVisibility(0);
        }
        for (;;)
        {
          localTextView.setText(paramm);
          this.OnE.setVisibility(8);
          AppMethodBeat.o(68008);
          return;
          label494:
          findViewById(a.f.total_favor_pack_up_arrow).setVisibility(8);
        }
      }
      label512:
      paramm = "";
    }
  }
  
  private void c(m paramm)
  {
    AppMethodBeat.i(68010);
    this.One.removeAllViews();
    Object localObject1;
    if ((this.Ons != null) && (!Util.isNullOrNil(this.Ons.OhY))) {
      localObject1 = this.Ons.OhY;
    }
    label570:
    label587:
    for (;;)
    {
      Object localObject2;
      if ((iO(this.OmZ)) && (iO(this.Ona)) && (iO(this.OnG)) && (iO(this.Onb)) && (iO(this.Onc)) && (!WalletSuccPageAwardWidget.a(this.OnC)) && (iO(findViewById(a.f.total_favor_desc_pack_up))) && (iO(this.OnE)))
      {
        localObject2 = (ViewGroup)getLayoutInflater().inflate(a.g.f2f_transfer_single_big_avatar_detail_item, this.One, false);
        this.One.addView((View)localObject2);
        paramm = (CdnImageView)((ViewGroup)localObject2).findViewById(a.f.remittance_busi_logo);
        localObject2 = (TextView)((ViewGroup)localObject2).findViewById(a.f.rbru_rcvr_tv);
        if (!Util.isNullOrNil(this.OhN))
        {
          if (this.OnB == 1) {
            paramm.setRoundCorner(true);
          }
          paramm.setUrl(this.OhN);
          label204:
          ((TextView)localObject2).setText((CharSequence)localObject1);
        }
      }
      for (;;)
      {
        gMI();
        AppMethodBeat.o(68010);
        return;
        if (!Util.isNullOrNil(this.OlF))
        {
          localObject2 = com.tencent.mm.wallet_core.ui.i.jo(this.OlF, 6);
          localObject1 = localObject2;
          if (Util.isNullOrNil(this.Onr)) {
            break label587;
          }
          localObject1 = getString(a.i.remittance_collect_block, new Object[] { localObject2, this.Onr });
          break;
        }
        localObject2 = com.tencent.mm.wallet_core.ui.i.jo(com.tencent.mm.wallet_core.ui.i.getDisplayName(this.Onh), 6);
        localObject1 = localObject2;
        if (Util.isNullOrNil(this.Onr)) {
          break label587;
        }
        localObject1 = getString(a.i.remittance_collect_block, new Object[] { localObject2, this.Onr });
        break;
        if (this.OnB == 1)
        {
          a.b.h(paramm, this.Onh);
          break label204;
        }
        a.b.g(paramm, this.Onh);
        break label204;
        localObject2 = (ViewGroup)getLayoutInflater().inflate(a.g.remittance_busi_recv_item_ui, this.One, false);
        this.One.addView((View)localObject2);
        localObject2 = (CdnImageView)findViewById(a.f.remittance_busi_logo);
        TextView localTextView1 = (TextView)findViewById(a.f.rbru_rcvr_tv);
        View localView = findViewById(a.f.layout_money_really);
        TextView localTextView2 = (TextView)findViewById(a.f.rbru_rcvr_money_tv);
        localTextView1.setText(com.tencent.mm.pluginsdk.ui.span.p.b(this, (CharSequence)localObject1));
        ((CdnImageView)localObject2).setVisibility(0);
        if (!Util.isNullOrNil(this.OhN))
        {
          if (this.OnB == 1) {
            ((CdnImageView)localObject2).setRoundCorner(true);
          }
          ((CdnImageView)localObject2).setUrl(this.OhN);
        }
        for (;;)
        {
          localView.setVisibility(8);
          localTextView2.setVisibility(8);
          if (paramm == null) {
            break;
          }
          if (paramm.OiX.YYb != 1) {
            break label570;
          }
          localView.setVisibility(0);
          localTextView2.setVisibility(0);
          localTextView2.setText(com.tencent.mm.wallet_core.ui.i.X(paramm.OiX.YXY / 100.0D));
          break;
          if (this.OnB == 1) {
            a.b.h((ImageView)localObject2, this.Onh);
          } else {
            a.b.g((ImageView)localObject2, this.Onh);
          }
        }
        localView.setVisibility(8);
        localTextView2.setVisibility(8);
      }
    }
  }
  
  private void gMH()
  {
    AppMethodBeat.i(289157);
    if (WalletSuccPageAwardWidget.a(this.OnC))
    {
      Log.i("MicroMsg.RemittanceBusiResultUI", "setAwardWidget, mTransId: %s", new Object[] { this.MyF });
      this.OnD.a(this, this.OnC, this.MyF, true, (ImageView)findViewById(a.f.background));
      this.OnD.init();
      this.OnD.setVisibility(0);
      final ImageView localImageView = (ImageView)findViewById(a.f.background);
      localImageView.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(67993);
          ViewGroup.LayoutParams localLayoutParams = localImageView.getLayoutParams();
          if (this.OnO != null)
          {
            localLayoutParams.width = this.OnO.getWidth();
            localLayoutParams.height = this.OnO.getHeight();
            localImageView.setLayoutParams(localLayoutParams);
          }
          AppMethodBeat.o(67993);
        }
      });
      gMI();
      AppMethodBeat.o(289157);
      return;
    }
    this.OnD.setVisibility(8);
    AppMethodBeat.o(289157);
  }
  
  private void gMI()
  {
    AppMethodBeat.i(68009);
    com.tencent.mm.ui.tools.p.a(this, (ScrollView)findViewById(a.f.scrollview_layout), findViewById(a.f.busi_result_layout), findViewById(a.f.anchor_layout), findViewById(a.f.bottom_layout), 32, 0.0F, true);
    AppMethodBeat.o(68009);
  }
  
  private static boolean iO(View paramView)
  {
    AppMethodBeat.i(68004);
    if ((paramView == null) || (paramView.getVisibility() == 8))
    {
      AppMethodBeat.o(68004);
      return true;
    }
    AppMethodBeat.o(68004);
    return false;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(68000);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(68000);
    return bool;
  }
  
  public void finish()
  {
    AppMethodBeat.i(67999);
    Log.i("MicroMsg.RemittanceBusiResultUI", "finish this %s %s", new Object[] { this, Util.getStack() });
    if (this.OnI)
    {
      AppMethodBeat.o(67999);
      return;
    }
    super.finish();
    this.OnI = true;
    AppMethodBeat.o(67999);
  }
  
  public int getLayoutId()
  {
    return a.g.remittance_busi_result_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(68002);
    this.sUt = ((TextView)findViewById(a.f.rbru_title_tv));
    this.OmP = ((TextView)findViewById(a.f.rbru_money_tv));
    this.OmQ = ((TextView)findViewById(a.f.rbru_money_tv_unit));
    this.OmR = ((TextView)findViewById(a.f.rbru_rcv_desc_tv));
    this.OmS = ((TextView)findViewById(a.f.rbru_pay_desc_tv));
    this.OmT = ((TextView)findViewById(a.f.rbru_pay_notice_tv));
    this.OmZ = ((LinearLayout)findViewById(a.f.rbru_rcv_desc_layout));
    this.Ona = ((LinearLayout)findViewById(a.f.rbru_pay_desc_layout));
    this.Onb = ((LinearLayout)findViewById(a.f.rbru_pay_notice_layout));
    this.OmU = ((CdnImageView)findViewById(a.f.rbru_app_logo_iv));
    this.OmV = ((TextView)findViewById(a.f.rbru_app_title_tv));
    this.OmW = ((TextView)findViewById(a.f.rbru_app_subtitle_tv));
    this.OmY = ((Button)findViewById(a.f.rbru_app_btn));
    this.Onc = ((ViewGroup)findViewById(a.f.rbru_app_layout));
    this.tHj = ((Button)findViewById(a.f.rbru_finish_btn));
    this.Ond = findViewById(a.f.single_line_view);
    this.One = ((LinearLayout)findViewById(a.f.remittance_busi_avatar_desc));
    this.Onw = ((LinearLayout)findViewById(a.f.f2f_transfer_info_list_layout));
    this.Onx = ((LinearLayout)findViewById(a.f.rbru_money_ll));
    this.OmX = ((TextView)findViewById(a.f.pay_succ_wording_tv));
    aw.a(this.OmX.getPaint(), 0.8F);
    this.OmP.setText(com.tencent.mm.wallet_core.ui.i.formatMoney2f(this.Oni));
    this.OmP.setTextSize(1, 48.0F);
    this.OmQ.setTextSize(1, 48.0F);
    MMHandlerThread.postToMainThreadDelayed(this.OnL, 500L);
    if (!Util.isNullOrNil(this.Onf))
    {
      this.OmR.setText(this.Onf);
      this.OmZ.setVisibility(0);
      if (Util.isNullOrNil(this.Ong)) {
        break label504;
      }
      this.OmS.setText(this.Ong);
      this.Ona.setVisibility(0);
    }
    for (;;)
    {
      this.tHj.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67992);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/remittance/ui/RemittanceBusiResultUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if (RemittanceBusiResultUI.h(RemittanceBusiResultUI.this) == 56) {
            h.OAn.b(19821, new Object[] { Integer.valueOf(10), RemittanceBusiResultUI.i(RemittanceBusiResultUI.this), Integer.valueOf(0) });
          }
          if ((RemittanceBusiResultUI.a(RemittanceBusiResultUI.this) == 65) && (RemittanceBusiResultUI.j(RemittanceBusiResultUI.this) != null))
          {
            Log.i("MicroMsg.RemittanceBusiResultUI", "mFinishBtn mPayScene == WalletConstantsProtocal.MMPAY_PAY_SCENE_PERSONAL_PAYMENT_PROCESS");
            RemittanceBusiResultUI.j(RemittanceBusiResultUI.this).send(-1, null);
          }
          if (RemittanceBusiResultUI.h(RemittanceBusiResultUI.this) == 71) {
            new az().publish();
          }
          RemittanceBusiResultUI.this.finish();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceBusiResultUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(67992);
        }
      });
      this.OnD = ((WalletSuccPageAwardWidget)findViewById(a.f.award_widget));
      this.OnE = ((ViewGroup)findViewById(a.f.discount_info_list_layout));
      this.OnF = ((ViewGroup)findViewById(a.f.discount_desc_list_layout));
      this.OnG = ((ViewGroup)findViewById(a.f.original_feeinfo_layout));
      this.OnH = ((TextView)findViewById(a.f.origin_fee_tv));
      AppMethodBeat.o(68002);
      return;
      this.OmZ.setVisibility(8);
      break;
      label504:
      this.Ona.setVisibility(8);
    }
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(289235);
    Log.i("MicroMsg.RemittanceBusiResultUI", "onBackPressed()");
    if ((this.mPayScene == 65) && (this.Onv != null))
    {
      Log.i("MicroMsg.RemittanceBusiResultUI", "mPayScene == WalletConstantsProtocal.MMPAY_PAY_SCENE_PERSONAL_PAYMENT_PROCESS");
      this.Onv.send(-1, null);
    }
    for (;;)
    {
      super.onBackPressed();
      AppMethodBeat.o(289235);
      return;
      if (this.mChannel == 71) {
        new az().publish();
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(68001);
    super.onCreate(paramBundle);
    addSceneEndListener(1537);
    addSceneEndListener(1680);
    addSceneEndListener(2504);
    addSceneEndListener(4587);
    this.OnJ.alive();
    if (d.rb(21))
    {
      if (d.rb(23)) {
        getWindow().setStatusBarColor(getContext().getResources().getColor(a.c.white));
      }
    }
    else
    {
      if (getSupportActionBar() != null) {
        getSupportActionBar().hide();
      }
      setBackBtn(null);
      showHomeBtn(false);
      enableBackMenu(false);
      this.OlF = getIntent().getStringExtra("key_mch_name");
      this.Ons = ((BusiRemittanceResp)getIntent().getParcelableExtra("BusiRemittanceResp"));
      this.Oni = getIntent().getDoubleExtra("key_money", 0.0D);
      this.Onh = getIntent().getStringExtra("key_rcver_name");
      this.Onr = getIntent().getStringExtra("key_rcver_true_name");
      this.Onf = getIntent().getStringExtra("key_rcv_desc");
      this.Ong = getIntent().getStringExtra("key_pay_desc");
      this.Onj = getIntent().getStringExtra("key_f2f_id");
      this.MyF = getIntent().getStringExtra("key_trans_id");
      this.Omj = getIntent().getStringExtra("key_rcvr_open_id");
      this.Ono = getIntent().getStringExtra("key_check_sign");
      this.Onk = getIntent().getStringExtra("key_pay_desc");
      this.Onl = getIntent().getStringExtra("key_rcv_desc");
      this.Onm = getIntent().getIntExtra("key_scan_sceen", 0);
      this.mChannel = getIntent().getIntExtra("key_channel", 0);
      this.Onn = getIntent().getStringExtra("key_succ_page_extend");
      this.Ont = l.aTU(getIntent().getStringExtra("key_succ_fault_config"));
      this.Onv = ((ResultReceiver)getIntent().getParcelableExtra("key_open_result_receiver"));
      this.mPayScene = getIntent().getIntExtra("pay_scene", 0);
      Log.i("MicroMsg.RemittanceBusiResultUI", "mPayScene:%s", new Object[] { Integer.valueOf(this.mPayScene) });
      if (this.mPayScene != 65) {
        break label599;
      }
      paramBundle = getIntent().getByteArrayExtra("AfterPlaceOrderCommReqC2C");
    }
    for (;;)
    {
      try
      {
        this.OnA.parseFrom(paramBundle);
        this.OnB = getIntent().getIntExtra("key_succ_show_avatar_type", 0);
        this.OhM = getIntent().getIntExtra("key_succ_show_avatar_show", 0);
        this.OhN = getIntent().getStringExtra("key_succ_show_avatar_url");
        this.app_id = getIntent().getStringExtra("app_id");
        this.Onq = false;
        Log.i("MicroMsg.RemittanceBusiResultUI", "fetch data");
        if (this.mPayScene != 65) {
          break label640;
        }
        Log.i("MicroMsg.RemittanceBusiResultUI", "mPayScene == WalletConstantsProtocal.MMPAY_PAY_SCENE_PERSONAL_PAYMENT_PROCESS，do NetSceneC2CSuccPage");
        doSceneProgress(new aa(this.OnA));
        initView();
        AppMethodBeat.o(68001);
        return;
        getWindow().setStatusBarColor(getContext().getResources().getColor(a.c.BW_93));
      }
      catch (Exception paramBundle)
      {
        Log.printErrStackTrace("MicroMsg.RemittanceBusiResultUI", paramBundle, "parse reqC2C failed", new Object[0]);
        continue;
      }
      label599:
      paramBundle = getIntent().getByteArrayExtra("AfterPlaceOrderCommReq");
      try
      {
        this.Onz.parseFrom(paramBundle);
      }
      catch (Exception paramBundle)
      {
        Log.printErrStackTrace("MicroMsg.RemittanceBusiResultUI", paramBundle, "parse req failed", new Object[0]);
      }
      continue;
      label640:
      Log.i("MicroMsg.RemittanceBusiResultUI", "fetchData() mBusiF2FFaultConfig.flag:%s mBusiF2FFaultConfig.succpage_first_delay_ms:%s", new Object[] { Integer.valueOf(this.Ont.eQp), Integer.valueOf(this.Ont.YXd) });
      if (Util.isEqual(this.Ont.eQp, 1)) {
        MMHandlerThread.postToMainThreadDelayed(this.Ony, this.Ont.YXd);
      } else {
        doSceneProgress(new m(this.Onz, this.Onn));
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(68006);
    super.onDestroy();
    removeSceneEndListener(1537);
    removeSceneEndListener(1680);
    removeSceneEndListener(2504);
    removeSceneEndListener(4587);
    this.OnJ.dead();
    if (this.OnC != null) {
      this.OnD.onDestroy();
    }
    MMHandlerThread.removeRunnable(this.OnL);
    AppMethodBeat.o(68006);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(68005);
    super.onResume();
    if (this.Onq)
    {
      Log.i("MicroMsg.RemittanceBusiResultUI", "do act qry");
      int i = (int)Math.round(this.Oni * 100.0D);
      doSceneProgress(new com.tencent.mm.plugin.remittance.model.i(this.Onj, this.MyF, this.Omj, i, this.Onp, this.Ono), false);
      this.Onq = false;
    }
    if (this.OnC != null) {
      this.OnD.onResume();
    }
    AppMethodBeat.o(68005);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(68003);
    Log.i("MicroMsg.RemittanceBusiResultUI", "errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scenetype:" + paramp.getType());
    Object localObject1;
    if ((paramp instanceof m))
    {
      localObject1 = (m)paramp;
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        if (this.Onu)
        {
          Log.i("MicroMsg.RemittanceBusiResultUI", "NetSceneBusiF2fSucpage success(mIfSuccNetSceneBusiF2fSucpage:%s)", new Object[] { Boolean.valueOf(this.Onu) });
          if (this.OnC == null) {
            break label1266;
          }
        }
      }
    }
    label427:
    label1266:
    for (boolean bool = this.OnD.onSceneEnd(paramInt1, paramInt2, paramString, paramp);; bool = false)
    {
      this.Ond.setVisibility(8);
      AppMethodBeat.o(68003);
      return bool;
      if (((m)localObject1).OiX.wuz == 0)
      {
        this.Onu = true;
        MMHandlerThread.removeRunnable(this.Ony);
        Log.i("MicroMsg.RemittanceBusiResultUI", "exposure info: %s", new Object[] { ((m)localObject1).OiX.VIz });
        this.OnC = ((m)localObject1).OiX.VIz;
        gMH();
        b((m)localObject1);
        MMHandlerThread.removeRunnable(this.OnL);
        a((m)localObject1);
        c((m)localObject1);
        break;
      }
      Log.e("MicroMsg.RemittanceBusiResultUI", "result response: %s, %s, %s", new Object[] { Integer.valueOf(((m)localObject1).OiX.wuz), ((m)localObject1).OiX.wuA, Boolean.valueOf(((m)localObject1).OiX.YYf) });
      if (((m)localObject1).OiX.YYf) {
        break;
      }
      this.Onu = true;
      MMHandlerThread.removeRunnable(this.Ony);
      break;
      Log.e("MicroMsg.RemittanceBusiResultUI", "net error: %s", new Object[] { localObject1 });
      break;
      if ((paramp instanceof aa))
      {
        Log.i("MicroMsg.RemittanceBusiResultUI", "scene instanceof NetSceneC2CSuccPage");
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          if (this.Onu)
          {
            Log.i("MicroMsg.RemittanceBusiResultUI", "NetSceneBusiF2fSucpage success(mIfSuccNetSceneBusiF2fSucpage:%s)", new Object[] { Boolean.valueOf(this.Onu) });
            break;
          }
          localObject1 = (aa)paramp;
          Object localObject2;
          if (((aa)localObject1).Ojv == null)
          {
            localObject1 = new up();
            localObject2 = new m();
            ((m)localObject2).OiX = new so();
            ((m)localObject2).OiX.wuz = ((up)localObject1).wuz;
            ((m)localObject2).OiX.wuA = ((up)localObject1).wuA;
            ((m)localObject2).OiX.VIz = ((up)localObject1).VIz;
            ((m)localObject2).OiX.YXY = ((up)localObject1).YXY;
            ((m)localObject2).OiX.YYb = ((up)localObject1).YYb;
            ((m)localObject2).OiX.YXZ = ((up)localObject1).YXZ;
            ((m)localObject2).OiX.YYa = ((up)localObject1).YYa;
            ((m)localObject2).OiX.YYc = ((up)localObject1).YYc;
            ((m)localObject2).OiX.YYd = ((up)localObject1).YYd;
            ((m)localObject2).OiX.YYe = ((up)localObject1).YYe;
            if (((m)localObject2).OiX.wuz != 0) {
              break label910;
            }
            this.Onu = true;
            MMHandlerThread.removeRunnable(this.Ony);
            Log.i("MicroMsg.RemittanceBusiResultUI", "exposure info: %s", new Object[] { ((m)localObject2).OiX.VIz });
            this.OnC = ((m)localObject2).OiX.VIz;
            gMH();
            b((m)localObject2);
            MMHandlerThread.removeRunnable(this.OnL);
            a((m)localObject2);
            this.One.removeAllViews();
            Log.i("MicroMsg.RemittanceBusiResultUI", "setF2fAvatarNameImpC2C: name：%s，money：%s，photourl：%s", new Object[] { this.Onh, Double.valueOf(this.Oni), this.OhN });
            localObject1 = (ViewGroup)getLayoutInflater().inflate(a.g.f2f_transfer_single_big_avatar_detail_item, this.One, false);
            this.One.addView((View)localObject1);
            localObject2 = this.Onh;
            ((TextView)((ViewGroup)localObject1).findViewById(a.f.rbru_rcvr_tv)).setText(com.tencent.mm.pluginsdk.ui.span.p.b(this, (CharSequence)localObject2));
            localObject1 = (CdnImageView)((ViewGroup)localObject1).findViewById(a.f.remittance_busi_logo);
            if (Util.isNullOrNil(this.OhN)) {
              break label900;
            }
            ((CdnImageView)localObject1).setRoundCorner(true);
            ((CdnImageView)localObject1).setRoundCornerRate(0.1F);
            ((CdnImageView)localObject1).setUrl(this.OhN);
          }
          for (;;)
          {
            localObject1 = (LinearLayout.LayoutParams)this.Onw.getLayoutParams();
            ((LinearLayout.LayoutParams)localObject1).topMargin = com.tencent.mm.cd.a.fromDPToPix(getContext(), 48);
            this.Onw.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            localObject1 = (LinearLayout.LayoutParams)this.Onx.getLayoutParams();
            ((LinearLayout.LayoutParams)localObject1).topMargin = com.tencent.mm.cd.a.fromDPToPix(getContext(), 0);
            this.Onx.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            this.sUt.setVisibility(8);
            gMI();
            break;
            localObject1 = ((aa)localObject1).Ojv;
            break label427;
            ((CdnImageView)localObject1).setVisibility(8);
          }
          Log.e("MicroMsg.RemittanceBusiResultUI", "result response: %s, %s, %s", new Object[] { Integer.valueOf(((m)localObject2).OiX.wuz), ((m)localObject2).OiX.wuA, Boolean.valueOf(((m)localObject2).OiX.YYf) });
          if (((m)localObject2).OiX.YYf) {
            break;
          }
          this.Onu = true;
          MMHandlerThread.removeRunnable(this.Ony);
          break;
        }
        Toast.makeText(this, a.i.wallet_data_err, 1).show();
        Log.e("MicroMsg.RemittanceBusiResultUI", "NetSceneC2CSuccPage net error");
        break;
      }
      if (!(paramp instanceof com.tencent.mm.plugin.remittance.model.i)) {
        break;
      }
      localObject1 = (com.tencent.mm.plugin.remittance.model.i)paramp;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (((com.tencent.mm.plugin.remittance.model.i)localObject1).Oim.wuz == 0)
        {
          localObject1 = ((com.tencent.mm.plugin.remittance.model.i)localObject1).Oim.YXc;
          if (localObject1 != null)
          {
            this.OmU.setUrl(((tl)localObject1).icon);
            this.OmV.setText(((tl)localObject1).title);
            this.OmW.setText(((tl)localObject1).VGA);
            this.OmY.setText(((tl)localObject1).VQT);
            this.OmY.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(67994);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.cH(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/remittance/ui/RemittanceBusiResultUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
                Log.i("MicroMsg.RemittanceBusiResultUI", "app type: %s", new Object[] { Integer.valueOf(this.OnP.type) });
                if (this.OnP.type == 1)
                {
                  RemittanceBusiResultUI.k(RemittanceBusiResultUI.this);
                  paramAnonymousView = new zp();
                  paramAnonymousView.icM.userName = this.OnP.YBP;
                  paramAnonymousView.icM.icO = Util.nullAs(this.OnP.YBQ, "");
                  paramAnonymousView.icM.scene = 1034;
                  paramAnonymousView.icM.icP = 0;
                  paramAnonymousView.publish();
                }
                for (;;)
                {
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceBusiResultUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(67994);
                  return;
                  if (this.OnP.type == 2)
                  {
                    RemittanceBusiResultUI.k(RemittanceBusiResultUI.this);
                    com.tencent.mm.wallet_core.ui.i.p(RemittanceBusiResultUI.this.getContext(), this.OnP.url, true);
                  }
                }
              }
            });
            this.OmY.setBackgroundResource(a.e.remittance_busi_app_disable_bg);
            this.OmY.setTextColor(getResources().getColor(a.c.white_text_color_disabled));
            this.Onc.setVisibility(0);
            gMI();
            break;
          }
          Log.i("MicroMsg.RemittanceBusiResultUI", "app info is null");
          this.Onc.setVisibility(8);
          break;
        }
        Log.e("MicroMsg.RemittanceBusiResultUI", "qry response: %s, %s", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.remittance.model.i)localObject1).Oim.wuz), ((com.tencent.mm.plugin.remittance.model.i)localObject1).Oim.wuA });
        Toast.makeText(this, ((com.tencent.mm.plugin.remittance.model.i)localObject1).Oim.wuA, 1).show();
        break;
      }
      Log.e("MicroMsg.RemittanceBusiResultUI", "net error: %s", new Object[] { localObject1 });
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
    AppMethodBeat.i(68007);
    getContentView().setVisibility(paramInt);
    AppMethodBeat.o(68007);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBusiResultUI
 * JD-Core Version:    0.7.0.1
 */