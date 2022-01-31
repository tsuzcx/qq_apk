package com.tencent.mm.plugin.remittance.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import b.a.a.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.bv.b;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.remittance.model.BusiRemittanceResp;
import com.tencent.mm.plugin.remittance.model.f;
import com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.c.co;
import com.tencent.mm.protocal.c.jx;
import com.tencent.mm.protocal.c.kg;
import com.tencent.mm.protocal.c.la;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(19)
public class RemittanceBusiResultUI
  extends WalletBaseUI
{
  private TextView haW;
  private int lTG;
  private Button llQ;
  private String mKL;
  private TextView nAN;
  private TextView nAO;
  private TextView nAP;
  private CdnImageView nAQ;
  private TextView nAR;
  private TextView nAS;
  private Button nAT;
  private ViewGroup nAU;
  private ViewGroup nAV;
  private ViewGroup nAW;
  private View nAX;
  private LinearLayout nAY;
  private String nAZ;
  private String nAt;
  private String nBa;
  private String nBb;
  private double nBc;
  private String nBd;
  private String nBe;
  private String nBf;
  private int nBg;
  private String nBh;
  private String nBi;
  private b nBj;
  private boolean nBk = false;
  private String nBl;
  private BusiRemittanceResp nBm;
  private co nBn = new co();
  private int nBo;
  private c nBp;
  private WalletSuccPageAwardWidget nBq;
  private ViewGroup nBr;
  private ViewGroup nBs;
  private ViewGroup nBt;
  private TextView nBu;
  private boolean nBv = true;
  private Runnable nBw = new Runnable()
  {
    public final void run()
    {
      RemittanceBusiResultUI.f(RemittanceBusiResultUI.this);
    }
  };
  private int nxL;
  private String nxM;
  private String nzV;
  
  private void a(com.tencent.mm.plugin.remittance.model.j paramj)
  {
    this.nAY.removeAllViews();
    Object localObject2;
    Object localObject1;
    if (!bk.bl(this.nzV))
    {
      localObject2 = e.dP(this.nzV, 6);
      localObject1 = localObject2;
      if (bk.bl(this.nBl)) {
        break label538;
      }
      localObject1 = getString(a.i.remittance_collect_block, new Object[] { localObject2, this.nBl });
    }
    label521:
    label538:
    for (;;)
    {
      if ((cI(this.nAU)) && (cI(this.nAV)) && (cI(this.nBt)) && (cI(this.nAW)) && (!WalletSuccPageAwardWidget.a(this.nBp)) && (cI(findViewById(a.f.total_favor_desc_pack_up))) && (cI(this.nBr)))
      {
        localObject2 = (ViewGroup)getLayoutInflater().inflate(a.g.f2f_transfer_single_big_avatar_detail_item, this.nAY, false);
        this.nAY.addView((View)localObject2);
        paramj = (CdnImageView)((ViewGroup)localObject2).findViewById(a.f.remittance_busi_logo);
        localObject2 = (TextView)((ViewGroup)localObject2).findViewById(a.f.rbru_rcvr_tv);
        if (!bk.bl(this.nxM))
        {
          if (this.nBo == 1) {
            paramj.setRoundCorner(true);
          }
          paramj.setUrl(this.nxM);
          label215:
          ((TextView)localObject2).setText((CharSequence)localObject1);
        }
      }
      for (;;)
      {
        cJ(this.nAY);
        return;
        localObject2 = e.dP(e.gV(this.nBb), 6);
        localObject1 = localObject2;
        if (bk.bl(this.nBl)) {
          break label538;
        }
        localObject1 = getString(a.i.remittance_collect_block, new Object[] { localObject2, this.nBl });
        break;
        if (this.nBo == 1)
        {
          a.b.n(paramj, this.nBb);
          break label215;
        }
        a.b.a(paramj, this.nBb);
        break label215;
        localObject2 = (ViewGroup)getLayoutInflater().inflate(a.g.remittance_busi_recv_item_ui, this.nAY, false);
        this.nAY.addView((View)localObject2);
        localObject2 = (CdnImageView)findViewById(a.f.remittance_busi_logo);
        TextView localTextView1 = (TextView)findViewById(a.f.rbru_rcvr_tv);
        View localView = findViewById(a.f.layout_money_really);
        TextView localTextView2 = (TextView)findViewById(a.f.rbru_rcvr_money_tv);
        localTextView1.setText(com.tencent.mm.pluginsdk.ui.d.j.b(this, (CharSequence)localObject1));
        ((CdnImageView)localObject2).setVisibility(0);
        if (!bk.bl(this.nxM))
        {
          if (this.nBo == 1) {
            ((CdnImageView)localObject2).setRoundCorner(true);
          }
          ((CdnImageView)localObject2).setUrl(this.nxM);
        }
        for (;;)
        {
          localView.setVisibility(8);
          localTextView2.setVisibility(8);
          if (paramj == null) {
            break;
          }
          if (paramj.nyk.sFs != 1) {
            break label521;
          }
          localView.setVisibility(0);
          localTextView2.setVisibility(0);
          localTextView2.setText(e.B(paramj.nyk.sFp / 100.0D));
          break;
          if (this.nBo == 1) {
            a.b.n((ImageView)localObject2, this.nBb);
          } else {
            a.b.a((ImageView)localObject2, this.nBb);
          }
        }
        localView.setVisibility(8);
        localTextView2.setVisibility(8);
      }
    }
  }
  
  private static boolean cI(View paramView)
  {
    return (paramView == null) || (paramView.getVisibility() == 8);
  }
  
  private void cJ(View paramView)
  {
    findViewById(a.f.bottom_layout).setVisibility(8);
    paramView.post(new RemittanceBusiResultUI.6(this));
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    com.tencent.mm.plugin.remittance.model.j localj;
    Object localObject;
    TextView localTextView1;
    View localView;
    LinkedList localLinkedList;
    int i;
    label277:
    String str;
    int j;
    if ((paramm instanceof com.tencent.mm.plugin.remittance.model.j))
    {
      localj = (com.tencent.mm.plugin.remittance.model.j)paramm;
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        if (localj.nyk.ino == 0)
        {
          y.i("MicroMsg.RemittanceBusiResultUI", "exposure info: %s", new Object[] { localj.nyk.qxJ });
          this.nBp = localj.nyk.qxJ;
          if (WalletSuccPageAwardWidget.a(this.nBp))
          {
            y.i("MicroMsg.RemittanceBusiResultUI", "setAwardWidget, mTransId: %s", new Object[] { this.mKL });
            this.nBq.a(this, this.nBp, this.mKL, true, (ImageView)findViewById(a.f.background));
            this.nBq.init();
            this.nBq.setVisibility(0);
            localObject = (ImageView)findViewById(a.f.background);
            ((ImageView)localObject).post(new RemittanceBusiResultUI.2(this, (ImageView)localObject));
            cJ(this.nBq);
            this.nBs.setVisibility(8);
            this.nBr.setVisibility(8);
            this.nBt.setVisibility(8);
            localTextView1 = (TextView)findViewById(a.f.total_favor_desc);
            localView = findViewById(a.f.total_favor_desc_pack_up);
            if ((localj == null) || (localj.nyk == null) || (localj.nyk.sFq.size() <= 0)) {
              break label693;
            }
            localLinkedList = localj.nyk.sFq;
            if (localLinkedList == null) {
              break label585;
            }
            i = localLinkedList.size();
            y.i("MicroMsg.RemittanceBusiResultUI", "discountInfoList: %s, size: %s received_amount: %s", new Object[] { localLinkedList, Integer.valueOf(i), Long.valueOf(localj.nyk.sFp) });
            str = "";
            j = localLinkedList.size();
            localObject = str;
            if (localLinkedList == null) {
              break label607;
            }
            localObject = str;
            if (localLinkedList.size() <= 0) {
              break label607;
            }
            this.nBs.removeAllViews();
            this.nBr.setOnClickListener(null);
            if (j <= 1) {
              break label1122;
            }
            localObject = localj.nyk.sFt;
            this.nBv = true;
            localView.setOnClickListener(new RemittanceBusiResultUI.4(this, localView));
            this.nBr.setOnClickListener(new RemittanceBusiResultUI.5(this, localView));
          }
        }
      }
    }
    for (;;)
    {
      if ((j == 1) && (localLinkedList.get(0) != null)) {
        localObject = (String)localLinkedList.get(0);
      }
      for (;;)
      {
        i = 0;
        for (;;)
        {
          if (i < localLinkedList.size())
          {
            str = (String)localLinkedList.get(i);
            TextView localTextView2 = new TextView(this.mController.uMN);
            LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
            localLayoutParams.bottomMargin = com.tencent.mm.cb.a.fromDPToPix(this, 6);
            localTextView2.setLayoutParams(localLayoutParams);
            localTextView2.setTextSize(1, 12.0F);
            localTextView2.setTextColor(Color.parseColor("#FA962A"));
            localTextView2.setText(str);
            this.nBs.addView(localTextView2);
            i += 1;
            continue;
            this.nBq.setVisibility(8);
            break;
            label585:
            i = 0;
            break label277;
          }
        }
        this.nBs.setVisibility(0);
        this.nBr.setVisibility(0);
        label607:
        if (this.nBv)
        {
          localView.setVisibility(0);
          localObject = bk.aM((String)localObject, "");
          localObject = new SpannableString((String)localObject + " ");
          if (j > 1)
          {
            findViewById(a.f.total_favor_pack_up_arrow).setVisibility(0);
            localTextView1.setText((CharSequence)localObject);
            this.nBr.setVisibility(8);
          }
        }
        else
        {
          ai.S(this.nBw);
          a(localj);
        }
        label693:
        boolean bool;
        for (;;)
        {
          bool = false;
          if (this.nBp != null) {
            bool = this.nBq.c(paramInt1, paramInt2, paramString, paramm);
          }
          if ((!cI(this.nAU)) || (!cI(this.nAV)) || (!cI(this.nBt))) {
            break label1108;
          }
          this.nAX.setVisibility(8);
          return bool;
          findViewById(a.f.total_favor_pack_up_arrow).setVisibility(8);
          break;
          y.e("MicroMsg.RemittanceBusiResultUI", "result response: %s, %s", new Object[] { Integer.valueOf(localj.nyk.ino), localj.nyk.inp });
          continue;
          y.e("MicroMsg.RemittanceBusiResultUI", "net error: %s", new Object[] { localj });
          continue;
          if ((paramm instanceof f))
          {
            localObject = (f)paramm;
            if ((paramInt1 == 0) && (paramInt2 == 0))
            {
              if (((f)localObject).nxX.ino == 0)
              {
                localObject = ((f)localObject).nxX.sEI;
                if (localObject != null)
                {
                  this.nAQ.setUrl(((la)localObject).bVO);
                  this.nAR.setText(((la)localObject).title);
                  this.nAS.setText(((la)localObject).qwq);
                  this.nAT.setText(((la)localObject).qEu);
                  this.nAT.setOnClickListener(new RemittanceBusiResultUI.3(this, (la)localObject));
                  this.nAT.setBackgroundResource(a.e.remittance_busi_app_disable_bg);
                  this.nAT.setTextColor(getResources().getColor(a.c.white_text_color_disabled));
                  this.nAW.setVisibility(0);
                  cJ(this.nAW);
                }
                else
                {
                  y.i("MicroMsg.RemittanceBusiResultUI", "app info is null");
                  this.nAW.setVisibility(8);
                }
              }
              else
              {
                y.e("MicroMsg.RemittanceBusiResultUI", "qry response: %s, %s", new Object[] { Integer.valueOf(((f)localObject).nxX.ino), ((f)localObject).nxX.inp });
                Toast.makeText(this, ((f)localObject).nxX.inp, 1).show();
              }
            }
            else {
              y.e("MicroMsg.RemittanceBusiResultUI", "net error: %s", new Object[] { localObject });
            }
          }
        }
        label1108:
        this.nAX.setVisibility(0);
        return bool;
      }
      label1122:
      localObject = "";
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected final int getLayoutId()
  {
    return a.g.remittance_busi_result_ui;
  }
  
  protected final void initView()
  {
    this.haW = ((TextView)findViewById(a.f.rbru_title_tv));
    this.nAN = ((TextView)findViewById(a.f.rbru_money_tv));
    this.nAO = ((TextView)findViewById(a.f.rbru_rcv_desc_tv));
    this.nAP = ((TextView)findViewById(a.f.rbru_pay_desc_tv));
    this.nAU = ((LinearLayout)findViewById(a.f.rbru_rcv_desc_layout));
    this.nAV = ((LinearLayout)findViewById(a.f.rbru_pay_desc_layout));
    this.nAQ = ((CdnImageView)findViewById(a.f.rbru_app_logo_iv));
    this.nAR = ((TextView)findViewById(a.f.rbru_app_title_tv));
    this.nAS = ((TextView)findViewById(a.f.rbru_app_subtitle_tv));
    this.nAT = ((Button)findViewById(a.f.rbru_app_btn));
    this.nAW = ((ViewGroup)findViewById(a.f.rbru_app_layout));
    this.llQ = ((Button)findViewById(a.f.rbru_finish_btn));
    this.nAX = findViewById(a.f.single_line_view);
    this.nAY = ((LinearLayout)findViewById(a.f.remittance_busi_avatar_desc));
    this.nAN.setText(e.A(this.nBc));
    ai.l(this.nBw, 500L);
    if (!bk.bl(this.nAZ))
    {
      this.nAO.setText(this.nAZ);
      this.nAU.setVisibility(0);
      if (bk.bl(this.nBa)) {
        break label373;
      }
      this.nAP.setText(this.nBa);
      this.nAV.setVisibility(0);
    }
    for (;;)
    {
      this.llQ.setOnClickListener(new RemittanceBusiResultUI.1(this));
      this.nBq = ((WalletSuccPageAwardWidget)findViewById(a.f.award_widget));
      this.nBr = ((ViewGroup)findViewById(a.f.discount_info_list_layout));
      this.nBs = ((ViewGroup)findViewById(a.f.discount_desc_list_layout));
      this.nBt = ((ViewGroup)findViewById(a.f.original_feeinfo_layout));
      this.nBu = ((TextView)findViewById(a.f.origin_fee_tv));
      return;
      this.nAU.setVisibility(8);
      break;
      label373:
      this.nAV.setVisibility(8);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    kh(1537);
    kh(1680);
    kh(2504);
    if (d.gF(21))
    {
      if (!d.gF(23)) {
        break label426;
      }
      getWindow().setStatusBarColor(-1);
      getWindow().getDecorView().setSystemUiVisibility(8192);
    }
    for (;;)
    {
      if (getSupportActionBar() != null) {
        getSupportActionBar().hide();
      }
      setBackBtn(null);
      showHomeBtn(false);
      enableBackMenu(false);
      this.nzV = getIntent().getStringExtra("key_mch_name");
      this.nBm = ((BusiRemittanceResp)getIntent().getParcelableExtra("BusiRemittanceResp"));
      this.nBc = getIntent().getDoubleExtra("key_money", 0.0D);
      this.nBb = getIntent().getStringExtra("key_rcver_name");
      this.nBl = getIntent().getStringExtra("key_rcver_true_name");
      this.nAZ = getIntent().getStringExtra("key_rcv_desc");
      this.nBa = getIntent().getStringExtra("key_pay_desc");
      this.nBd = getIntent().getStringExtra("key_f2f_id");
      this.mKL = getIntent().getStringExtra("key_trans_id");
      this.nAt = getIntent().getStringExtra("key_rcvr_open_id");
      this.nBi = getIntent().getStringExtra("key_check_sign");
      this.nBe = getIntent().getStringExtra("key_pay_desc");
      this.nBf = getIntent().getStringExtra("key_rcv_desc");
      this.nBg = getIntent().getIntExtra("key_scan_sceen", 0);
      this.lTG = getIntent().getIntExtra("key_channel", 0);
      this.nBh = getIntent().getStringExtra("key_succ_page_extend");
      paramBundle = getIntent().getByteArrayExtra("AfterPlaceOrderCommReq");
      try
      {
        this.nBn.aH(paramBundle);
        this.nBo = getIntent().getIntExtra("key_succ_show_avatar_type", 0);
        this.nxL = getIntent().getIntExtra("key_succ_show_avatar_show", 0);
        this.nxM = getIntent().getStringExtra("key_succ_show_avatar_url");
        this.nBk = false;
        y.i("MicroMsg.RemittanceBusiResultUI", "fetch data");
        a(new com.tencent.mm.plugin.remittance.model.j(this.nBn, this.nBh), true, true);
        initView();
        return;
        label426:
        getWindow().setStatusBarColor(Color.parseColor("#E5E5E5"));
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.RemittanceBusiResultUI", paramBundle, "", new Object[0]);
        }
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ki(1537);
    ki(1680);
    ki(2504);
    if (this.nBp != null) {
      this.nBq.onDestroy();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.nBk)
    {
      y.i("MicroMsg.RemittanceBusiResultUI", "do act qry");
      int i = (int)Math.round(this.nBc * 100.0D);
      a(new f(this.nBd, this.mKL, this.nAt, i, this.nBj, this.nBi), false, false);
      this.nBk = false;
    }
    if (this.nBp != null) {
      this.nBq.onResume();
    }
  }
  
  public final void vN(int paramInt)
  {
    this.mController.contentView.setVisibility(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBusiResultUI
 * JD-Core Version:    0.7.0.1
 */