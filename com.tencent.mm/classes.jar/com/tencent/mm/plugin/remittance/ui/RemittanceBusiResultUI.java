package com.tencent.mm.plugin.remittance.ui;

import android.app.Activity;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.f.a.abh;
import com.tencent.mm.plugin.remittance.model.BusiRemittanceResp;
import com.tencent.mm.plugin.remittance.model.z;
import com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.ds;
import com.tencent.mm.protocal.protobuf.qt;
import com.tencent.mm.protocal.protobuf.qu;
import com.tencent.mm.protocal.protobuf.rd;
import com.tencent.mm.protocal.protobuf.sa;
import com.tencent.mm.protocal.protobuf.sq;
import com.tencent.mm.protocal.protobuf.sz;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.g;
import e.a.a.c;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(19)
public class RemittanceBusiResultUI
  extends WalletBaseUI
{
  private String GCu;
  private int IkY;
  private String IkZ;
  private String IoQ;
  private String Iom;
  private TextView IpA;
  private CdnImageView IpB;
  private TextView IpC;
  private TextView IpD;
  private TextView IpE;
  private Button IpF;
  private ViewGroup IpG;
  private ViewGroup IpH;
  private ViewGroup IpI;
  private ViewGroup IpJ;
  private View IpK;
  private LinearLayout IpL;
  private String IpM;
  private String IpN;
  private String IpO;
  private double IpP;
  private String IpQ;
  private String IpR;
  private String IpS;
  private int IpT;
  private String IpU;
  private String IpV;
  private com.tencent.mm.cd.b IpW;
  private boolean IpX;
  private String IpY;
  private BusiRemittanceResp IpZ;
  private TextView Ipw;
  private TextView Ipx;
  private TextView Ipy;
  private TextView Ipz;
  private qu Iqa;
  private boolean Iqb;
  private ResultReceiver Iqc;
  private LinearLayout Iqd;
  private LinearLayout Iqe;
  private Runnable Iqf;
  private ds Iqg;
  private sq Iqh;
  private int Iqi;
  private c Iqj;
  private WalletSuccPageAwardWidget Iqk;
  private ViewGroup Iql;
  private ViewGroup Iqm;
  private ViewGroup Iqn;
  private TextView Iqo;
  private boolean Iqp;
  private IListener<abh> Iqq;
  private boolean Iqr;
  private Runnable Iqs;
  private String app_id;
  private int mChannel;
  private int mPayScene;
  private TextView pPT;
  private Button qCl;
  private int vds;
  
  public RemittanceBusiResultUI()
  {
    AppMethodBeat.i(67998);
    this.IpX = false;
    this.Iqb = false;
    this.Iqf = new Runnable()
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
        com.tencent.mm.plugin.remittance.model.l locall = new com.tencent.mm.plugin.remittance.model.l(RemittanceBusiResultUI.c(RemittanceBusiResultUI.this), RemittanceBusiResultUI.d(RemittanceBusiResultUI.this), RemittanceBusiResultUI.e(RemittanceBusiResultUI.this).cUP, RemittanceBusiResultUI.f(RemittanceBusiResultUI.this) - 1, System.currentTimeMillis());
        RemittanceBusiResultUI.this.doSceneProgress(locall);
        RemittanceBusiResultUI.g(RemittanceBusiResultUI.this);
        AppMethodBeat.o(67990);
      }
    };
    this.Iqg = new ds();
    this.Iqh = new sq();
    this.Iqp = false;
    this.Iqq = new IListener() {};
    this.Iqr = true;
    this.Iqs = new Runnable()
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
  
  private void a(com.tencent.mm.plugin.remittance.model.l paraml)
  {
    AppMethodBeat.i(275293);
    if (!Util.isNullOrNil(paraml.IlG.Sae))
    {
      if (Util.isNullOrNil(paraml.IlG.Saf)) {
        this.IpA.setTextColor(getResources().getColor(a.c.normal_color));
      }
      for (;;)
      {
        this.IpA.setText(paraml.IlG.Sae);
        this.IpI.setVisibility(0);
        AppMethodBeat.o(275293);
        return;
        this.IpA.setTextColor(com.tencent.mm.plugin.wallet_core.utils.k.cW(paraml.IlG.Saf, true));
      }
    }
    this.IpI.setVisibility(8);
    AppMethodBeat.o(275293);
  }
  
  private void b(com.tencent.mm.plugin.remittance.model.l paraml)
  {
    AppMethodBeat.i(68008);
    this.Iqm.setVisibility(8);
    this.Iql.setVisibility(8);
    this.Iqn.setVisibility(8);
    TextView localTextView = (TextView)findViewById(a.f.total_favor_desc);
    final View localView = findViewById(a.f.total_favor_desc_pack_up);
    LinkedList localLinkedList;
    int i;
    Object localObject2;
    int j;
    Object localObject1;
    if ((paraml != null) && (paraml.IlG != null) && (paraml.IlG.Saa.size() > 0))
    {
      localLinkedList = paraml.IlG.Saa;
      if (localLinkedList != null)
      {
        i = localLinkedList.size();
        Log.i("MicroMsg.RemittanceBusiResultUI", "discountInfoList: %s, size: %s received_amount: %s", new Object[] { localLinkedList, Integer.valueOf(i), Long.valueOf(paraml.IlG.RZZ) });
        localObject2 = "";
        j = localLinkedList.size();
        localObject1 = localObject2;
        if (localLinkedList == null) {
          break label405;
        }
        localObject1 = localObject2;
        if (localLinkedList.size() <= 0) {
          break label405;
        }
        this.Iqm.removeAllViews();
        this.Iql.setOnClickListener(null);
        if (j <= 1) {
          break label510;
        }
        paraml = paraml.IlG.Sad;
        this.Iqr = true;
        localView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(67995);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/remittance/ui/RemittanceBusiResultUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
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
        this.Iql.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(67996);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/remittance/ui/RemittanceBusiResultUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
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
        paraml = (String)localLinkedList.get(0);
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
            localLayoutParams.bottomMargin = com.tencent.mm.ci.a.fromDPToPix(this, 6);
            ((TextView)localObject2).setLayoutParams(localLayoutParams);
            ((TextView)localObject2).setTextSize(1, 12.0F);
            ((TextView)localObject2).setTextColor(getResources().getColor(a.c.Orange));
            ((TextView)localObject2).setText((CharSequence)localObject1);
            this.Iqm.addView((View)localObject2);
            i += 1;
            continue;
            i = 0;
            break;
          }
        }
        this.Iqm.setVisibility(0);
        this.Iql.setVisibility(0);
        localObject1 = paraml;
        label405:
        if (this.Iqr)
        {
          localView.setVisibility(0);
          paraml = Util.nullAs((String)localObject1, "");
          paraml = new SpannableString(paraml + " ");
          if (j <= 1) {
            break label492;
          }
          findViewById(a.f.total_favor_pack_up_arrow).setVisibility(0);
        }
        for (;;)
        {
          localTextView.setText(paraml);
          this.Iql.setVisibility(8);
          AppMethodBeat.o(68008);
          return;
          label492:
          findViewById(a.f.total_favor_pack_up_arrow).setVisibility(8);
        }
      }
      label510:
      paraml = "";
    }
  }
  
  private void c(com.tencent.mm.plugin.remittance.model.l paraml)
  {
    AppMethodBeat.i(68010);
    this.IpL.removeAllViews();
    Object localObject1;
    if ((this.IpZ != null) && (!Util.isNullOrNil(this.IpZ.Ilk))) {
      localObject1 = this.IpZ.Ilk;
    }
    label570:
    label587:
    for (;;)
    {
      Object localObject2;
      if ((fR(this.IpG)) && (fR(this.IpH)) && (fR(this.Iqn)) && (fR(this.IpI)) && (fR(this.IpJ)) && (!WalletSuccPageAwardWidget.a(this.Iqj)) && (fR(findViewById(a.f.total_favor_desc_pack_up))) && (fR(this.Iql)))
      {
        localObject2 = (ViewGroup)getLayoutInflater().inflate(a.g.f2f_transfer_single_big_avatar_detail_item, this.IpL, false);
        this.IpL.addView((View)localObject2);
        paraml = (CdnImageView)((ViewGroup)localObject2).findViewById(a.f.remittance_busi_logo);
        localObject2 = (TextView)((ViewGroup)localObject2).findViewById(a.f.rbru_rcvr_tv);
        if (!Util.isNullOrNil(this.IkZ))
        {
          if (this.Iqi == 1) {
            paraml.setRoundCorner(true);
          }
          paraml.setUrl(this.IkZ);
          label204:
          ((TextView)localObject2).setText((CharSequence)localObject1);
        }
      }
      for (;;)
      {
        fAO();
        AppMethodBeat.o(68010);
        return;
        if (!Util.isNullOrNil(this.Iom))
        {
          localObject2 = g.ic(this.Iom, 6);
          localObject1 = localObject2;
          if (Util.isNullOrNil(this.IpY)) {
            break label587;
          }
          localObject1 = getString(a.i.remittance_collect_block, new Object[] { localObject2, this.IpY });
          break;
        }
        localObject2 = g.ic(g.PJ(this.IpO), 6);
        localObject1 = localObject2;
        if (Util.isNullOrNil(this.IpY)) {
          break label587;
        }
        localObject1 = getString(a.i.remittance_collect_block, new Object[] { localObject2, this.IpY });
        break;
        if (this.Iqi == 1)
        {
          a.b.d(paraml, this.IpO);
          break label204;
        }
        a.b.c(paraml, this.IpO);
        break label204;
        localObject2 = (ViewGroup)getLayoutInflater().inflate(a.g.remittance_busi_recv_item_ui, this.IpL, false);
        this.IpL.addView((View)localObject2);
        localObject2 = (CdnImageView)findViewById(a.f.remittance_busi_logo);
        TextView localTextView1 = (TextView)findViewById(a.f.rbru_rcvr_tv);
        View localView = findViewById(a.f.layout_money_really);
        TextView localTextView2 = (TextView)findViewById(a.f.rbru_rcvr_money_tv);
        localTextView1.setText(com.tencent.mm.pluginsdk.ui.span.l.c(this, (CharSequence)localObject1));
        ((CdnImageView)localObject2).setVisibility(0);
        if (!Util.isNullOrNil(this.IkZ))
        {
          if (this.Iqi == 1) {
            ((CdnImageView)localObject2).setRoundCorner(true);
          }
          ((CdnImageView)localObject2).setUrl(this.IkZ);
        }
        for (;;)
        {
          localView.setVisibility(8);
          localTextView2.setVisibility(8);
          if (paraml == null) {
            break;
          }
          if (paraml.IlG.Sac != 1) {
            break label570;
          }
          localView.setVisibility(0);
          localTextView2.setVisibility(0);
          localTextView2.setText(g.F(paraml.IlG.RZZ / 100.0D));
          break;
          if (this.Iqi == 1) {
            a.b.d((ImageView)localObject2, this.IpO);
          } else {
            a.b.c((ImageView)localObject2, this.IpO);
          }
        }
        localView.setVisibility(8);
        localTextView2.setVisibility(8);
      }
    }
  }
  
  private void fAN()
  {
    AppMethodBeat.i(275292);
    if (WalletSuccPageAwardWidget.a(this.Iqj))
    {
      Log.i("MicroMsg.RemittanceBusiResultUI", "setAwardWidget, mTransId: %s", new Object[] { this.GCu });
      this.Iqk.a(this, this.Iqj, this.GCu, true, (ImageView)findViewById(a.f.background));
      this.Iqk.init();
      this.Iqk.setVisibility(0);
      final ImageView localImageView = (ImageView)findViewById(a.f.background);
      localImageView.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(67993);
          ViewGroup.LayoutParams localLayoutParams = localImageView.getLayoutParams();
          if (this.Iqv != null)
          {
            localLayoutParams.width = this.Iqv.getWidth();
            localLayoutParams.height = this.Iqv.getHeight();
            localImageView.setLayoutParams(localLayoutParams);
          }
          AppMethodBeat.o(67993);
        }
      });
      fAO();
      AppMethodBeat.o(275292);
      return;
    }
    this.Iqk.setVisibility(8);
    AppMethodBeat.o(275292);
  }
  
  private void fAO()
  {
    AppMethodBeat.i(68009);
    com.tencent.mm.ui.tools.q.a(this, (ScrollView)findViewById(a.f.scrollview_layout), findViewById(a.f.busi_result_layout), findViewById(a.f.anchor_layout), findViewById(a.f.bottom_layout), 32, 0.0F, true);
    AppMethodBeat.o(68009);
  }
  
  private static boolean fR(View paramView)
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
    if (this.Iqp)
    {
      AppMethodBeat.o(67999);
      return;
    }
    super.finish();
    this.Iqp = true;
    AppMethodBeat.o(67999);
  }
  
  public int getLayoutId()
  {
    return a.g.remittance_busi_result_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(68002);
    this.pPT = ((TextView)findViewById(a.f.rbru_title_tv));
    this.Ipw = ((TextView)findViewById(a.f.rbru_money_tv));
    this.Ipx = ((TextView)findViewById(a.f.rbru_money_tv_unit));
    this.Ipy = ((TextView)findViewById(a.f.rbru_rcv_desc_tv));
    this.Ipz = ((TextView)findViewById(a.f.rbru_pay_desc_tv));
    this.IpA = ((TextView)findViewById(a.f.rbru_pay_notice_tv));
    this.IpG = ((LinearLayout)findViewById(a.f.rbru_rcv_desc_layout));
    this.IpH = ((LinearLayout)findViewById(a.f.rbru_pay_desc_layout));
    this.IpI = ((LinearLayout)findViewById(a.f.rbru_pay_notice_layout));
    this.IpB = ((CdnImageView)findViewById(a.f.rbru_app_logo_iv));
    this.IpC = ((TextView)findViewById(a.f.rbru_app_title_tv));
    this.IpD = ((TextView)findViewById(a.f.rbru_app_subtitle_tv));
    this.IpF = ((Button)findViewById(a.f.rbru_app_btn));
    this.IpJ = ((ViewGroup)findViewById(a.f.rbru_app_layout));
    this.qCl = ((Button)findViewById(a.f.rbru_finish_btn));
    this.IpK = findViewById(a.f.single_line_view);
    this.IpL = ((LinearLayout)findViewById(a.f.remittance_busi_avatar_desc));
    this.Iqd = ((LinearLayout)findViewById(a.f.f2f_transfer_info_list_layout));
    this.Iqe = ((LinearLayout)findViewById(a.f.rbru_money_ll));
    this.IpE = ((TextView)findViewById(a.f.pay_succ_wording_tv));
    ar.a(this.IpE.getPaint(), 0.8F);
    this.Ipw.setText(g.formatMoney2f(this.IpP));
    this.Ipw.setTextSize(1, 48.0F);
    this.Ipx.setTextSize(1, 48.0F);
    MMHandlerThread.postToMainThreadDelayed(this.Iqs, 500L);
    if (!Util.isNullOrNil(this.IpM))
    {
      this.Ipy.setText(this.IpM);
      this.IpG.setVisibility(0);
      if (Util.isNullOrNil(this.IpN)) {
        break label504;
      }
      this.Ipz.setText(this.IpN);
      this.IpH.setVisibility(0);
    }
    for (;;)
    {
      this.qCl.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67992);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/remittance/ui/RemittanceBusiResultUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (RemittanceBusiResultUI.h(RemittanceBusiResultUI.this) == 56) {
            com.tencent.mm.plugin.report.service.h.IzE.a(19821, new Object[] { Integer.valueOf(10), RemittanceBusiResultUI.i(RemittanceBusiResultUI.this), Integer.valueOf(0) });
          }
          if ((RemittanceBusiResultUI.a(RemittanceBusiResultUI.this) == 65) && (RemittanceBusiResultUI.j(RemittanceBusiResultUI.this) != null))
          {
            Log.i("MicroMsg.RemittanceBusiResultUI", "mFinishBtn mPayScene == WalletConstantsProtocal.MMPAY_PAY_SCENE_PERSONAL_PAYMENT_PROCESS");
            RemittanceBusiResultUI.j(RemittanceBusiResultUI.this).send(-1, null);
          }
          RemittanceBusiResultUI.this.finish();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceBusiResultUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(67992);
        }
      });
      this.Iqk = ((WalletSuccPageAwardWidget)findViewById(a.f.award_widget));
      this.Iql = ((ViewGroup)findViewById(a.f.discount_info_list_layout));
      this.Iqm = ((ViewGroup)findViewById(a.f.discount_desc_list_layout));
      this.Iqn = ((ViewGroup)findViewById(a.f.original_feeinfo_layout));
      this.Iqo = ((TextView)findViewById(a.f.origin_fee_tv));
      AppMethodBeat.o(68002);
      return;
      this.IpG.setVisibility(8);
      break;
      label504:
      this.IpH.setVisibility(8);
    }
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(275295);
    Log.i("MicroMsg.RemittanceBusiResultUI", "onBackPressed()");
    if ((this.mPayScene == 65) && (this.Iqc != null))
    {
      Log.i("MicroMsg.RemittanceBusiResultUI", "mPayScene == WalletConstantsProtocal.MMPAY_PAY_SCENE_PERSONAL_PAYMENT_PROCESS");
      this.Iqc.send(-1, null);
    }
    super.onBackPressed();
    AppMethodBeat.o(275295);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(68001);
    super.onCreate(paramBundle);
    addSceneEndListener(1537);
    addSceneEndListener(1680);
    addSceneEndListener(2504);
    addSceneEndListener(4587);
    this.Iqq.alive();
    if (d.qV(21))
    {
      if (d.qV(23)) {
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
      this.Iom = getIntent().getStringExtra("key_mch_name");
      this.IpZ = ((BusiRemittanceResp)getIntent().getParcelableExtra("BusiRemittanceResp"));
      this.IpP = getIntent().getDoubleExtra("key_money", 0.0D);
      this.IpO = getIntent().getStringExtra("key_rcver_name");
      this.IpY = getIntent().getStringExtra("key_rcver_true_name");
      this.IpM = getIntent().getStringExtra("key_rcv_desc");
      this.IpN = getIntent().getStringExtra("key_pay_desc");
      this.IpQ = getIntent().getStringExtra("key_f2f_id");
      this.GCu = getIntent().getStringExtra("key_trans_id");
      this.IoQ = getIntent().getStringExtra("key_rcvr_open_id");
      this.IpV = getIntent().getStringExtra("key_check_sign");
      this.IpR = getIntent().getStringExtra("key_pay_desc");
      this.IpS = getIntent().getStringExtra("key_rcv_desc");
      this.IpT = getIntent().getIntExtra("key_scan_sceen", 0);
      this.mChannel = getIntent().getIntExtra("key_channel", 0);
      this.IpU = getIntent().getStringExtra("key_succ_page_extend");
      this.Iqa = com.tencent.mm.plugin.remittance.model.k.aWG(getIntent().getStringExtra("key_succ_fault_config"));
      this.Iqc = ((ResultReceiver)getIntent().getParcelableExtra("key_open_result_receiver"));
      this.mPayScene = getIntent().getIntExtra("pay_scene", 0);
      Log.i("MicroMsg.RemittanceBusiResultUI", "mPayScene:%s", new Object[] { Integer.valueOf(this.mPayScene) });
      if (this.mPayScene != 65) {
        break label596;
      }
      paramBundle = getIntent().getByteArrayExtra("AfterPlaceOrderCommReqC2C");
    }
    for (;;)
    {
      try
      {
        this.Iqh.parseFrom(paramBundle);
        this.Iqi = getIntent().getIntExtra("key_succ_show_avatar_type", 0);
        this.IkY = getIntent().getIntExtra("key_succ_show_avatar_show", 0);
        this.IkZ = getIntent().getStringExtra("key_succ_show_avatar_url");
        this.app_id = getIntent().getStringExtra("app_id");
        this.IpX = false;
        Log.i("MicroMsg.RemittanceBusiResultUI", "fetch data");
        if (this.mPayScene != 65) {
          break label636;
        }
        Log.i("MicroMsg.RemittanceBusiResultUI", "mPayScene == WalletConstantsProtocal.MMPAY_PAY_SCENE_PERSONAL_PAYMENT_PROCESS，do NetSceneC2CSuccPage");
        doSceneProgress(new z(this.Iqh));
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
      label596:
      paramBundle = getIntent().getByteArrayExtra("AfterPlaceOrderCommReq");
      try
      {
        this.Iqg.parseFrom(paramBundle);
      }
      catch (Exception paramBundle)
      {
        Log.printErrStackTrace("MicroMsg.RemittanceBusiResultUI", paramBundle, "parse req failed", new Object[0]);
      }
      continue;
      label636:
      Log.i("MicroMsg.RemittanceBusiResultUI", "fetchData() mBusiF2FFaultConfig.flag:%s mBusiF2FFaultConfig.succpage_first_delay_ms:%s", new Object[] { Integer.valueOf(this.Iqa.cUP), Integer.valueOf(this.Iqa.RZd) });
      if (Util.isEqual(this.Iqa.cUP, 1)) {
        MMHandlerThread.postToMainThreadDelayed(this.Iqf, this.Iqa.RZd);
      } else {
        doSceneProgress(new com.tencent.mm.plugin.remittance.model.l(this.Iqg, this.IpU));
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
    this.Iqq.dead();
    if (this.Iqj != null) {
      this.Iqk.onDestroy();
    }
    MMHandlerThread.removeRunnable(this.Iqs);
    AppMethodBeat.o(68006);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(68005);
    super.onResume();
    if (this.IpX)
    {
      Log.i("MicroMsg.RemittanceBusiResultUI", "do act qry");
      int i = (int)Math.round(this.IpP * 100.0D);
      doSceneProgress(new com.tencent.mm.plugin.remittance.model.h(this.IpQ, this.GCu, this.IoQ, i, this.IpW, this.IpV), false);
      this.IpX = false;
    }
    if (this.Iqj != null) {
      this.Iqk.onResume();
    }
    AppMethodBeat.o(68005);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(68003);
    Log.i("MicroMsg.RemittanceBusiResultUI", "errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scenetype:" + paramq.getType());
    Object localObject1;
    if ((paramq instanceof com.tencent.mm.plugin.remittance.model.l))
    {
      localObject1 = (com.tencent.mm.plugin.remittance.model.l)paramq;
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        if (this.Iqb)
        {
          Log.i("MicroMsg.RemittanceBusiResultUI", "NetSceneBusiF2fSucpage success(mIfSuccNetSceneBusiF2fSucpage:%s)", new Object[] { Boolean.valueOf(this.Iqb) });
          if (this.Iqj == null) {
            break label1252;
          }
        }
      }
    }
    label420:
    label1252:
    for (boolean bool = this.Iqk.onSceneEnd(paramInt1, paramInt2, paramString, paramq);; bool = false)
    {
      this.IpK.setVisibility(8);
      AppMethodBeat.o(68003);
      return bool;
      if (((com.tencent.mm.plugin.remittance.model.l)localObject1).IlG.tqa == 0)
      {
        this.Iqb = true;
        MMHandlerThread.removeRunnable(this.Iqf);
        Log.i("MicroMsg.RemittanceBusiResultUI", "exposure info: %s", new Object[] { ((com.tencent.mm.plugin.remittance.model.l)localObject1).IlG.OSs });
        this.Iqj = ((com.tencent.mm.plugin.remittance.model.l)localObject1).IlG.OSs;
        fAN();
        b((com.tencent.mm.plugin.remittance.model.l)localObject1);
        MMHandlerThread.removeRunnable(this.Iqs);
        a((com.tencent.mm.plugin.remittance.model.l)localObject1);
        c((com.tencent.mm.plugin.remittance.model.l)localObject1);
        break;
      }
      Log.e("MicroMsg.RemittanceBusiResultUI", "result response: %s, %s, %s", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.remittance.model.l)localObject1).IlG.tqa), ((com.tencent.mm.plugin.remittance.model.l)localObject1).IlG.tqb, Boolean.valueOf(((com.tencent.mm.plugin.remittance.model.l)localObject1).IlG.Sag) });
      if (((com.tencent.mm.plugin.remittance.model.l)localObject1).IlG.Sag) {
        break;
      }
      this.Iqb = true;
      MMHandlerThread.removeRunnable(this.Iqf);
      break;
      Log.e("MicroMsg.RemittanceBusiResultUI", "net error: %s", new Object[] { localObject1 });
      break;
      if ((paramq instanceof z))
      {
        Log.i("MicroMsg.RemittanceBusiResultUI", "scene instanceof NetSceneC2CSuccPage");
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          if (this.Iqb)
          {
            Log.i("MicroMsg.RemittanceBusiResultUI", "NetSceneBusiF2fSucpage success(mIfSuccNetSceneBusiF2fSucpage:%s)", new Object[] { Boolean.valueOf(this.Iqb) });
            break;
          }
          localObject1 = (z)paramq;
          Object localObject2;
          if (((z)localObject1).Ime == null)
          {
            localObject1 = new sz();
            localObject2 = new com.tencent.mm.plugin.remittance.model.l();
            ((com.tencent.mm.plugin.remittance.model.l)localObject2).IlG = new rd();
            ((com.tencent.mm.plugin.remittance.model.l)localObject2).IlG.tqa = ((sz)localObject1).tqa;
            ((com.tencent.mm.plugin.remittance.model.l)localObject2).IlG.tqb = ((sz)localObject1).tqb;
            ((com.tencent.mm.plugin.remittance.model.l)localObject2).IlG.OSs = ((sz)localObject1).OSs;
            ((com.tencent.mm.plugin.remittance.model.l)localObject2).IlG.RZZ = ((sz)localObject1).RZZ;
            ((com.tencent.mm.plugin.remittance.model.l)localObject2).IlG.Sac = ((sz)localObject1).Sac;
            ((com.tencent.mm.plugin.remittance.model.l)localObject2).IlG.Saa = ((sz)localObject1).Saa;
            ((com.tencent.mm.plugin.remittance.model.l)localObject2).IlG.Sab = ((sz)localObject1).Sab;
            ((com.tencent.mm.plugin.remittance.model.l)localObject2).IlG.Sad = ((sz)localObject1).Sad;
            ((com.tencent.mm.plugin.remittance.model.l)localObject2).IlG.Sae = ((sz)localObject1).Sae;
            ((com.tencent.mm.plugin.remittance.model.l)localObject2).IlG.Saf = ((sz)localObject1).Saf;
            if (((com.tencent.mm.plugin.remittance.model.l)localObject2).IlG.tqa != 0) {
              break label901;
            }
            this.Iqb = true;
            MMHandlerThread.removeRunnable(this.Iqf);
            Log.i("MicroMsg.RemittanceBusiResultUI", "exposure info: %s", new Object[] { ((com.tencent.mm.plugin.remittance.model.l)localObject2).IlG.OSs });
            this.Iqj = ((com.tencent.mm.plugin.remittance.model.l)localObject2).IlG.OSs;
            fAN();
            b((com.tencent.mm.plugin.remittance.model.l)localObject2);
            MMHandlerThread.removeRunnable(this.Iqs);
            a((com.tencent.mm.plugin.remittance.model.l)localObject2);
            this.IpL.removeAllViews();
            Log.i("MicroMsg.RemittanceBusiResultUI", "setF2fAvatarNameImpC2C: name：%s，money：%s，photourl：%s", new Object[] { this.IpO, Double.valueOf(this.IpP), this.IkZ });
            localObject1 = (ViewGroup)getLayoutInflater().inflate(a.g.f2f_transfer_single_big_avatar_detail_item, this.IpL, false);
            this.IpL.addView((View)localObject1);
            localObject2 = this.IpO;
            ((TextView)((ViewGroup)localObject1).findViewById(a.f.rbru_rcvr_tv)).setText(com.tencent.mm.pluginsdk.ui.span.l.c(this, (CharSequence)localObject2));
            localObject1 = (CdnImageView)((ViewGroup)localObject1).findViewById(a.f.remittance_busi_logo);
            if (Util.isNullOrNil(this.IkZ)) {
              break label891;
            }
            ((CdnImageView)localObject1).setRoundCorner(true);
            ((CdnImageView)localObject1).setRoundCornerRate(0.1F);
            ((CdnImageView)localObject1).setUrl(this.IkZ);
          }
          for (;;)
          {
            localObject1 = (LinearLayout.LayoutParams)this.Iqd.getLayoutParams();
            ((LinearLayout.LayoutParams)localObject1).topMargin = com.tencent.mm.ci.a.fromDPToPix(getContext(), 48);
            this.Iqd.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            localObject1 = (LinearLayout.LayoutParams)this.Iqe.getLayoutParams();
            ((LinearLayout.LayoutParams)localObject1).topMargin = com.tencent.mm.ci.a.fromDPToPix(getContext(), 0);
            this.Iqe.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            this.pPT.setVisibility(8);
            fAO();
            break;
            localObject1 = ((z)localObject1).Ime;
            break label420;
            label891:
            ((CdnImageView)localObject1).setVisibility(8);
          }
          Log.e("MicroMsg.RemittanceBusiResultUI", "result response: %s, %s, %s", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.remittance.model.l)localObject2).IlG.tqa), ((com.tencent.mm.plugin.remittance.model.l)localObject2).IlG.tqb, Boolean.valueOf(((com.tencent.mm.plugin.remittance.model.l)localObject2).IlG.Sag) });
          if (((com.tencent.mm.plugin.remittance.model.l)localObject2).IlG.Sag) {
            break;
          }
          this.Iqb = true;
          MMHandlerThread.removeRunnable(this.Iqf);
          break;
        }
        Toast.makeText(this, a.i.wallet_data_err, 1).show();
        Log.e("MicroMsg.RemittanceBusiResultUI", "NetSceneC2CSuccPage net error");
        break;
      }
      if (!(paramq instanceof com.tencent.mm.plugin.remittance.model.h)) {
        break;
      }
      localObject1 = (com.tencent.mm.plugin.remittance.model.h)paramq;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (((com.tencent.mm.plugin.remittance.model.h)localObject1).Ilv.tqa == 0)
        {
          localObject1 = ((com.tencent.mm.plugin.remittance.model.h)localObject1).Ilv.RZc;
          if (localObject1 != null)
          {
            this.IpB.setUrl(((sa)localObject1).icon);
            this.IpC.setText(((sa)localObject1).title);
            this.IpD.setText(((sa)localObject1).OQG);
            this.IpF.setText(((sa)localObject1).Pap);
            this.IpF.setOnClickListener(new RemittanceBusiResultUI.5(this, (sa)localObject1));
            this.IpF.setBackgroundResource(a.e.remittance_busi_app_disable_bg);
            this.IpF.setTextColor(getResources().getColor(a.c.white_text_color_disabled));
            this.IpJ.setVisibility(0);
            fAO();
            break;
          }
          Log.i("MicroMsg.RemittanceBusiResultUI", "app info is null");
          this.IpJ.setVisibility(8);
          break;
        }
        Log.e("MicroMsg.RemittanceBusiResultUI", "qry response: %s, %s", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.remittance.model.h)localObject1).Ilv.tqa), ((com.tencent.mm.plugin.remittance.model.h)localObject1).Ilv.tqb });
        Toast.makeText(this, ((com.tencent.mm.plugin.remittance.model.h)localObject1).Ilv.tqb, 1).show();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBusiResultUI
 * JD-Core Version:    0.7.0.1
 */