package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.wallet.balance.model.lqt.CgiLqtPlanIndex;
import com.tencent.mm.plugin.wallet.balance.model.lqt.CgiLqtPlanIndex.PlanIndexParcel;
import com.tencent.mm.plugin.wallet.balance.model.lqt.ac;
import com.tencent.mm.plugin.wallet.balance.model.lqt.ac.a;
import com.tencent.mm.plugin.wallet.balance.model.lqt.r;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.plugin.wallet_core.utils.k;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.cuz;
import com.tencent.mm.protocal.protobuf.dlh;
import com.tencent.mm.protocal.protobuf.dli;
import com.tencent.mm.protocal.protobuf.etn;
import com.tencent.mm.protocal.protobuf.iw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.wallet_core.c.a.a;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.i;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class WalletLqtPlanHomeUI
  extends WalletLqtBasePresenterUI
{
  private ViewGroup DKy;
  private ListView OrM;
  private TextView OrN;
  private TextView OrO;
  private LinearLayout OrP;
  private Button OrQ;
  private RelativeLayout OrR;
  private LinearLayout OrS;
  private RelativeLayout OrT;
  private LinearLayout OrU;
  private TextView OrV;
  private ac OrW;
  private a OrX;
  private List<dli> OrY;
  private dlh OrZ;
  private int requestCode;
  
  public WalletLqtPlanHomeUI()
  {
    AppMethodBeat.i(68942);
    this.OrW = ((ac)ap(ac.class));
    this.OrX = new a((byte)0);
    this.OrY = new ArrayList();
    AppMethodBeat.o(68942);
  }
  
  private void ame(int paramInt)
  {
    AppMethodBeat.i(68947);
    Log.i("MicroMsg.WalletLqtPlanHomeUI", "go to add plan ui -> add");
    Intent localIntent = new Intent(this, WalletLqtPlanAddUI.class);
    localIntent.putExtra("key_mode", 1);
    startActivityForResult(localIntent, paramInt);
    AppMethodBeat.o(68947);
  }
  
  private void b(dlh paramdlh)
  {
    AppMethodBeat.i(68946);
    Log.i("MicroMsg.WalletLqtPlanHomeUI", "limit: %s", new Object[] { Long.valueOf(paramdlh.OkS) });
    this.DKy.setVisibility(0);
    if (paramdlh.OkS <= paramdlh.TSp.size())
    {
      this.DKy.findViewById(a.f.lqha_plus_iv).setVisibility(8);
      TextView localTextView = (TextView)this.DKy.findViewById(a.f.lqha_plus_tv);
      localTextView.setPadding(com.tencent.mm.ci.a.fromDPToPix(getContext(), 24), 0, 0, 0);
      localTextView.setText(paramdlh.OkV);
      localTextView.setTextColor(getContext().getResources().getColor(a.c.hint_text_color));
      this.DKy.setEnabled(false);
      AppMethodBeat.o(68946);
      return;
    }
    this.DKy.findViewById(a.f.lqha_plus_iv).setVisibility(0);
    paramdlh = (TextView)this.DKy.findViewById(a.f.lqha_plus_tv);
    paramdlh.setPadding(0, 0, 0, 0);
    paramdlh.setText(a.i.wallet_lqt_add_plan_text2);
    paramdlh.setTextColor(getResources().getColor(a.c.normal_text_color));
    this.DKy.setEnabled(true);
    AppMethodBeat.o(68946);
  }
  
  private void c(final dlh paramdlh)
  {
    AppMethodBeat.i(68949);
    Log.d("MicroMsg.WalletLqtPlanHomeUI", "update view");
    if (paramdlh != null)
    {
      if ((paramdlh.TSp == null) || (paramdlh.TSp.isEmpty()))
      {
        Log.i("MicroMsg.WalletLqtPlanHomeUI", "show empty view");
        if (this.requestCode == 3)
        {
          gGt();
          this.OrY = paramdlh.TSp;
          this.OrX.notifyDataSetChanged();
          this.DKy.setVisibility(8);
          AppMethodBeat.o(68949);
          return;
        }
        finish();
        AppMethodBeat.o(68949);
        return;
      }
      if (Util.isNullOrNil(paramdlh.OkW)) {
        setMMTitle("");
      }
      for (;;)
      {
        setActionbarColor(getContext().getResources().getColor(a.c.BG_0));
        this.OrR.setVisibility(8);
        this.OrM.setVisibility(0);
        b(paramdlh);
        this.OrY = paramdlh.TSp;
        this.OrX.notifyDataSetChanged();
        if ((paramdlh.TSq == null) || (Util.isNullOrNil(paramdlh.TSq.title))) {
          break;
        }
        this.OrV.setText(paramdlh.TSq.title);
        this.OrS.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(68930);
            b localb = new b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtPlanHomeUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            Log.i("MicroMsg.WalletLqtPlanHomeUI", "click banner");
            com.tencent.mm.wallet_core.ui.g.p(WalletLqtPlanHomeUI.this.getContext(), paramdlh.TSq.url, true);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtPlanHomeUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(68930);
          }
        });
        this.OrS.setVisibility(0);
        AppMethodBeat.o(68949);
        return;
        setMMTitle(paramdlh.OkW);
      }
      this.OrS.setVisibility(8);
      AppMethodBeat.o(68949);
      return;
    }
    Log.i("MicroMsg.WalletLqtPlanHomeUI", "resp is null");
    finish();
    AppMethodBeat.o(68949);
  }
  
  private void gGt()
  {
    AppMethodBeat.i(68948);
    Log.i("MicroMsg.WalletLqtPlanHomeUI", "show null plan home ui");
    setMMTitle(getString(a.i.wallet_lqt_salary_save_title));
    this.OrT = ((RelativeLayout)findViewById(a.f.lqt_null_plan_ll));
    this.OrT.setVisibility(0);
    this.OrU = ((LinearLayout)findViewById(a.f.lqt_null_plan_add));
    this.OrU.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68929);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtPlanHomeUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        WalletLqtPlanHomeUI.b(WalletLqtPlanHomeUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtPlanHomeUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(68929);
      }
    });
    AppMethodBeat.o(68948);
  }
  
  private void gGu()
  {
    AppMethodBeat.i(68950);
    r localr = new r();
    localr.d(new CgiLqtPlanIndex());
    localr.a(new a.a() {}, 0L);
    AppMethodBeat.o(68950);
  }
  
  public int getLayoutId()
  {
    return a.g.lqt_plan_home_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(68944);
    this.OrM = ((ListView)findViewById(a.f.lphu_lv));
    this.OrN = ((TextView)findViewById(a.f.lphu_empty_title_tv));
    this.OrO = ((TextView)findViewById(a.f.lphu_empty_desc_tv));
    this.OrP = ((LinearLayout)findViewById(a.f.lphu_empty_top_layout));
    this.OrQ = ((Button)findViewById(a.f.lphu_empty_bottom_btn));
    this.OrR = ((RelativeLayout)findViewById(a.f.lphu_empty_layout));
    this.OrS = ((LinearLayout)findViewById(a.f.lqt_detail_banner_ll));
    this.OrV = ((TextView)findViewById(a.f.lqt_detail_banner_text));
    this.OrX = new a((byte)0);
    this.OrM.setAdapter(this.OrX);
    this.DKy = ((ViewGroup)LayoutInflater.from(this).inflate(a.g.lqt_plan_home_item_add, this.OrM, false));
    this.DKy.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68928);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtPlanHomeUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        WalletLqtPlanHomeUI.a(WalletLqtPlanHomeUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtPlanHomeUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(68928);
      }
    });
    this.OrM.addFooterView(this.DKy);
    this.OrQ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68926);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtPlanHomeUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        WalletLqtPlanHomeUI.a(WalletLqtPlanHomeUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtPlanHomeUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(68926);
      }
    });
    this.OrM.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(68927);
        b localb = new b();
        localb.bn(paramAnonymousAdapterView);
        localb.bn(paramAnonymousView);
        localb.sg(paramAnonymousInt);
        localb.Fs(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtPlanHomeUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
        Log.i("MicroMsg.WalletLqtPlanHomeUI", "pos: %s", new Object[] { Integer.valueOf(paramAnonymousInt) });
        paramAnonymousAdapterView.getAdapter().getItem(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtPlanHomeUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(68927);
      }
    });
    AppMethodBeat.o(68944);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(68945);
    Log.i("MicroMsg.WalletLqtPlanHomeUI", "activity result: %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    int i = paramInt1;
    if (paramInt1 == 5)
    {
      i = paramInt1;
      if (paramInt2 == -1) {
        i = paramIntent.getIntExtra("oper_type", -1);
      }
    }
    this.requestCode = i;
    switch (i)
    {
    }
    for (;;)
    {
      super.onActivityResult(i, paramInt2, paramIntent);
      AppMethodBeat.o(68945);
      return;
      if (paramInt2 == -1)
      {
        String str = paramIntent.getStringExtra("encrypt_pwd");
        paramInt1 = paramIntent.getIntExtra("oper_type", -1);
        int j = paramIntent.getIntExtra("plan_id", -1);
        final Dialog localDialog = i.c(getContext(), false, null);
        ac.a locala = this.OrW.OlX;
        com.tencent.mm.vending.g.g.g(Integer.valueOf(paramInt1), Integer.valueOf(j), str).c(locala).f(new com.tencent.mm.vending.c.a() {}).a(new d.a()
        {
          public final void cm(Object paramAnonymousObject)
          {
            AppMethodBeat.i(68933);
            localDialog.dismiss();
            if ((paramAnonymousObject instanceof m)) {
              ((m)paramAnonymousObject).L(WalletLqtPlanHomeUI.this.getContext(), false);
            }
            AppMethodBeat.o(68933);
          }
        });
        continue;
        if (paramInt2 == -1)
        {
          gGu();
          continue;
          if (paramInt2 == -1)
          {
            gGu();
            this.OrT.setVisibility(8);
            continue;
            if (paramInt2 == -1) {
              gGu();
            } else {
              finish();
            }
          }
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(68943);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    setMMTitle("");
    setActionbarColor(getResources().getColor(a.c.BG_0));
    setStatusColor();
    hideActionbarLine();
    initView();
    int i = getIntent().getIntExtra("key_plan_go_scene_ui", 0);
    Log.i("MicroMsg.WalletLqtPlanHomeUI", "WalletLqtPlanHomeUI scene：%s", new Object[] { Integer.valueOf(i) });
    switch (i)
    {
    default: 
      Log.i("MicroMsg.WalletLqtPlanHomeUI", "go to plan home ui");
      paramBundle = getIntent().getParcelableExtra("key_plan_index_resp");
      if ((paramBundle instanceof CgiLqtPlanIndex.PlanIndexParcel))
      {
        this.OrZ = CgiLqtPlanIndex.a((CgiLqtPlanIndex.PlanIndexParcel)paramBundle);
        c(this.OrZ);
        AppMethodBeat.o(68943);
        return;
      }
      break;
    case 1: 
      ame(65282);
      AppMethodBeat.o(68943);
      return;
    case 2: 
      gGt();
      AppMethodBeat.o(68943);
      return;
    }
    Log.i("MicroMsg.WalletLqtPlanHomeUI", "parcelable no instanceof CgiLqtPlanIndex.PlanIndexParcel");
    finish();
    AppMethodBeat.o(68943);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends BaseAdapter
  {
    private a() {}
    
    private dli amf(int paramInt)
    {
      AppMethodBeat.i(68937);
      dli localdli = (dli)WalletLqtPlanHomeUI.d(WalletLqtPlanHomeUI.this).get(paramInt);
      AppMethodBeat.o(68937);
      return localdli;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(68936);
      int i = WalletLqtPlanHomeUI.d(WalletLqtPlanHomeUI.this).size();
      AppMethodBeat.o(68936);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(68938);
      View localView = paramView;
      if (paramView == null)
      {
        localView = LayoutInflater.from(WalletLqtPlanHomeUI.this.getContext()).inflate(a.g.lqt_plan_home_item, paramViewGroup, false);
        localView.setTag(new WalletLqtPlanHomeUI.b(WalletLqtPlanHomeUI.this, localView));
      }
      paramView = amf(paramInt);
      paramViewGroup = (WalletLqtPlanHomeUI.b)localView.getTag();
      paramViewGroup.Ose.setPrefix(ah.ijb());
      Object localObject = com.tencent.mm.wallet_core.ui.g.b(paramView.gbJ, "100", 2, RoundingMode.HALF_UP);
      if (((BigDecimal)localObject).intValue() == ((BigDecimal)localObject).doubleValue())
      {
        paramViewGroup.Ose.setText(WalletLqtPlanHomeUI.bgy(((BigDecimal)localObject).intValue()));
        paramViewGroup.Osh.setText(String.format("%s %s(%s)", new Object[] { paramView.DNV, paramView.Old, paramView.GHy }));
        localObject = u.a(new com.tencent.mm.plugin.wallet_core.ui.view.c(paramView.IfQ));
        if (localObject != null) {
          paramViewGroup.Oqs.setImageBitmap((Bitmap)localObject);
        }
        if ((paramView.TSs == null) || (Util.isNullOrNil(paramView.TSs.Ole))) {
          break label430;
        }
        paramViewGroup.Osi.setText(paramView.TSs.Ole);
        if (Util.isNullOrNil(paramView.TSs.lmL)) {
          break label407;
        }
        paramViewGroup.Osi.setTextColor(k.cW(paramView.TSs.lmL, true));
        label278:
        paramViewGroup.Osi.setVisibility(0);
        label286:
        paramViewGroup.Osl.setVisibility(8);
        paramViewGroup.Osj.setVisibility(8);
        if (paramView.TSt != null) {
          paramViewGroup.Osg.setOnClickListener(new WalletLqtPlanHomeUI.b.1(paramViewGroup, paramView));
        }
        if (paramView.state == 1) {
          break label442;
        }
        paramViewGroup.Osk.setVisibility(0);
        paramViewGroup.Osh.setAlpha(0.2F);
        paramViewGroup.Ose.setAlpha(0.2F);
        paramViewGroup.Oqs.setAlpha(0.3F);
        paramViewGroup.Osf.setAlpha(1.0F);
      }
      for (;;)
      {
        AppMethodBeat.o(68938);
        return localView;
        paramViewGroup.Ose.setText(WalletLqtPlanHomeUI.bgy(((BigDecimal)localObject).toString()));
        break;
        label407:
        paramViewGroup.Osi.setTextColor(paramViewGroup.Osa.getResources().getColor(a.c.BW_50));
        break label278;
        label430:
        paramViewGroup.Osi.setVisibility(8);
        break label286;
        label442:
        paramViewGroup.Osk.setVisibility(8);
        paramViewGroup.Osh.setAlpha(1.0F);
        paramViewGroup.Ose.setAlpha(1.0F);
        paramViewGroup.Oqs.setAlpha(1.0F);
        paramViewGroup.Osf.setAlpha(1.0F);
      }
    }
  }
  
  public final class b
  {
    public CdnImageView Oqs;
    public WalletTextView Ose;
    public ImageView Osf;
    public LinearLayout Osg;
    public TextView Osh;
    public TextView Osi;
    public TextView Osj;
    public TextView Osk;
    public LinearLayout Osl;
    public View oFW;
    
    public b(View paramView)
    {
      AppMethodBeat.i(68941);
      this.oFW = paramView;
      this.Ose = ((WalletTextView)paramView.findViewById(a.f.lphi_money_tv));
      this.Osf = ((ImageView)paramView.findViewById(a.f.lphi_more_iv));
      this.Osk = ((TextView)paramView.findViewById(a.f.lphi_state_label_tv));
      this.Osh = ((TextView)paramView.findViewById(a.f.lphi_desc1_tv));
      this.Osi = ((TextView)paramView.findViewById(a.f.lphi_desc2_tv));
      this.Osj = ((TextView)paramView.findViewById(a.f.lphi_bottom_tv));
      this.Osl = ((LinearLayout)paramView.findViewById(a.f.lphi_bottom_layout));
      this.Oqs = ((CdnImageView)paramView.findViewById(a.f.lphi_bank_iv));
      this.Osg = ((LinearLayout)paramView.findViewById(a.f.lphi_header_tips_ll));
      int i = com.tencent.mm.ci.a.fromDPToPix(WalletLqtPlanHomeUI.this.getContext(), 50);
      Util.expandViewTouchArea(this.Osf, i, i, i, i);
      AppMethodBeat.o(68941);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanHomeUI
 * JD-Core Version:    0.7.0.1
 */