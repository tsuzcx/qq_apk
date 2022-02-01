package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
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
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.wallet.balance.model.lqt.CgiLqtPlanIndex;
import com.tencent.mm.plugin.wallet.balance.model.lqt.CgiLqtPlanIndex.PlanIndexParcel;
import com.tencent.mm.plugin.wallet.balance.model.lqt.ad;
import com.tencent.mm.plugin.wallet.balance.model.lqt.ad.a;
import com.tencent.mm.plugin.wallet.balance.model.lqt.s;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.plugin.wallet_core.utils.n;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.dmf;
import com.tencent.mm.protocal.protobuf.eds;
import com.tencent.mm.protocal.protobuf.edt;
import com.tencent.mm.protocal.protobuf.foy;
import com.tencent.mm.protocal.protobuf.js;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.wallet_core.model.a.a;
import com.tencent.mm.wallet_core.model.ai;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.i;
import com.tencent.mm.wallet_core.ui.l;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class WalletLqtPlanHomeUI
  extends WalletLqtBasePresenterUI
{
  private ViewGroup JBu;
  private ListView VgS;
  private TextView VgT;
  private TextView VgU;
  private LinearLayout VgV;
  private Button VgW;
  private RelativeLayout VgX;
  private LinearLayout VgY;
  private RelativeLayout VgZ;
  private LinearLayout Vha;
  private TextView Vhb;
  private ad Vhc;
  private a Vhd;
  private List<edt> Vhe;
  private eds Vhf;
  private int hPm;
  
  public WalletLqtPlanHomeUI()
  {
    AppMethodBeat.i(68942);
    this.Vhc = ((ad)aI(ad.class));
    this.Vhd = new a((byte)0);
    this.Vhe = new ArrayList();
    AppMethodBeat.o(68942);
  }
  
  private void arO(int paramInt)
  {
    AppMethodBeat.i(68947);
    Log.i("MicroMsg.WalletLqtPlanHomeUI", "go to add plan ui -> add");
    Intent localIntent = new Intent(this, WalletLqtPlanAddUI.class);
    localIntent.putExtra("key_mode", 1);
    startActivityForResult(localIntent, paramInt);
    AppMethodBeat.o(68947);
  }
  
  private void b(eds parameds)
  {
    AppMethodBeat.i(68946);
    Log.i("MicroMsg.WalletLqtPlanHomeUI", "limit: %s", new Object[] { Long.valueOf(parameds.UZv) });
    this.JBu.setVisibility(0);
    if (parameds.UZv <= parameds.abiO.size())
    {
      this.JBu.findViewById(a.f.lqha_plus_iv).setVisibility(8);
      TextView localTextView = (TextView)this.JBu.findViewById(a.f.lqha_plus_tv);
      localTextView.setPadding(com.tencent.mm.cd.a.fromDPToPix(getContext(), 24), 0, 0, 0);
      localTextView.setText(parameds.UZy);
      localTextView.setTextColor(getContext().getResources().getColor(a.c.hint_text_color));
      this.JBu.setEnabled(false);
      AppMethodBeat.o(68946);
      return;
    }
    this.JBu.findViewById(a.f.lqha_plus_iv).setVisibility(0);
    parameds = (TextView)this.JBu.findViewById(a.f.lqha_plus_tv);
    parameds.setPadding(0, 0, 0, 0);
    parameds.setText(a.i.wallet_lqt_add_plan_text2);
    parameds.setTextColor(getResources().getColor(a.c.normal_text_color));
    this.JBu.setEnabled(true);
    AppMethodBeat.o(68946);
  }
  
  private void c(final eds parameds)
  {
    AppMethodBeat.i(68949);
    Log.d("MicroMsg.WalletLqtPlanHomeUI", "update view");
    if (parameds != null)
    {
      if ((parameds.abiO == null) || (parameds.abiO.isEmpty()))
      {
        Log.i("MicroMsg.WalletLqtPlanHomeUI", "show empty view");
        if (this.hPm == 3)
        {
          ifu();
          this.Vhe = parameds.abiO;
          this.Vhd.notifyDataSetChanged();
          this.JBu.setVisibility(8);
          AppMethodBeat.o(68949);
          return;
        }
        finish();
        AppMethodBeat.o(68949);
        return;
      }
      if (Util.isNullOrNil(parameds.UZz)) {
        setMMTitle("");
      }
      for (;;)
      {
        setActionbarColor(getContext().getResources().getColor(a.c.BG_0));
        this.VgX.setVisibility(8);
        this.VgS.setVisibility(0);
        b(parameds);
        this.Vhe = parameds.abiO;
        this.Vhd.notifyDataSetChanged();
        if ((parameds.abiP == null) || (Util.isNullOrNil(parameds.abiP.title))) {
          break;
        }
        this.Vhb.setText(parameds.abiP.title);
        this.VgY.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(68930);
            b localb = new b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtPlanHomeUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            Log.i("MicroMsg.WalletLqtPlanHomeUI", "click banner");
            i.p(WalletLqtPlanHomeUI.this.getContext(), parameds.abiP.url, true);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtPlanHomeUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(68930);
          }
        });
        this.VgY.setVisibility(0);
        AppMethodBeat.o(68949);
        return;
        setMMTitle(parameds.UZz);
      }
      this.VgY.setVisibility(8);
      AppMethodBeat.o(68949);
      return;
    }
    Log.i("MicroMsg.WalletLqtPlanHomeUI", "resp is null");
    finish();
    AppMethodBeat.o(68949);
  }
  
  private void ifu()
  {
    AppMethodBeat.i(68948);
    Log.i("MicroMsg.WalletLqtPlanHomeUI", "show null plan home ui");
    setMMTitle(getString(a.i.wallet_lqt_salary_save_title));
    this.VgZ = ((RelativeLayout)findViewById(a.f.lqt_null_plan_ll));
    this.VgZ.setVisibility(0);
    this.Vha = ((LinearLayout)findViewById(a.f.lqt_null_plan_add));
    this.Vha.setOnClickListener(new WalletLqtPlanHomeUI.4(this));
    AppMethodBeat.o(68948);
  }
  
  private void ifv()
  {
    AppMethodBeat.i(68950);
    s locals = new s();
    locals.d(new CgiLqtPlanIndex());
    locals.a(new a.a() {}, 0L);
    AppMethodBeat.o(68950);
  }
  
  public int getLayoutId()
  {
    return a.g.lqt_plan_home_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(68944);
    this.VgS = ((ListView)findViewById(a.f.lphu_lv));
    this.VgT = ((TextView)findViewById(a.f.lphu_empty_title_tv));
    this.VgU = ((TextView)findViewById(a.f.lphu_empty_desc_tv));
    this.VgV = ((LinearLayout)findViewById(a.f.lphu_empty_top_layout));
    this.VgW = ((Button)findViewById(a.f.lphu_empty_bottom_btn));
    this.VgX = ((RelativeLayout)findViewById(a.f.lphu_empty_layout));
    this.VgY = ((LinearLayout)findViewById(a.f.lqt_detail_banner_ll));
    this.Vhb = ((TextView)findViewById(a.f.lqt_detail_banner_text));
    this.Vhd = new a((byte)0);
    this.VgS.setAdapter(this.Vhd);
    this.JBu = ((ViewGroup)LayoutInflater.from(this).inflate(a.g.lqt_plan_home_item_add, this.VgS, false));
    this.JBu.setOnClickListener(new WalletLqtPlanHomeUI.3(this));
    this.VgS.addFooterView(this.JBu);
    this.VgW.setOnClickListener(new WalletLqtPlanHomeUI.1(this));
    this.VgS.setOnItemClickListener(new WalletLqtPlanHomeUI.2(this));
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
    this.hPm = i;
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
        final Dialog localDialog = l.c(getContext(), false, null);
        ad.a locala = this.Vhc.VaD;
        g.f(Integer.valueOf(paramInt1), Integer.valueOf(j), str).c(locala).f(new com.tencent.mm.vending.c.a() {}).a(new d.a()
        {
          public final void onInterrupt(Object paramAnonymousObject)
          {
            AppMethodBeat.i(68933);
            localDialog.dismiss();
            if ((paramAnonymousObject instanceof m)) {
              ((m)paramAnonymousObject).U(WalletLqtPlanHomeUI.this.getContext(), false);
            }
            AppMethodBeat.o(68933);
          }
        });
        continue;
        if (paramInt2 == -1)
        {
          ifv();
          continue;
          if (paramInt2 == -1)
          {
            ifv();
            this.VgZ.setVisibility(8);
            continue;
            if (paramInt2 == -1) {
              ifv();
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
        this.Vhf = CgiLqtPlanIndex.a((CgiLqtPlanIndex.PlanIndexParcel)paramBundle);
        c(this.Vhf);
        AppMethodBeat.o(68943);
        return;
      }
      break;
    case 1: 
      arO(65282);
      AppMethodBeat.o(68943);
      return;
    case 2: 
      ifu();
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
    
    private edt arP(int paramInt)
    {
      AppMethodBeat.i(68937);
      edt localedt = (edt)WalletLqtPlanHomeUI.d(WalletLqtPlanHomeUI.this).get(paramInt);
      AppMethodBeat.o(68937);
      return localedt;
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
      paramView = arP(paramInt);
      paramViewGroup = (WalletLqtPlanHomeUI.b)localView.getTag();
      paramViewGroup.Vhk.setPrefix(ai.jOX());
      Object localObject = i.b(paramView.ihV, "100", 2, RoundingMode.HALF_UP);
      if (((BigDecimal)localObject).intValue() == ((BigDecimal)localObject).doubleValue())
      {
        paramViewGroup.Vhk.setText(WalletLqtPlanHomeUI.bgd(((BigDecimal)localObject).intValue()));
        paramViewGroup.Vhn.setText(String.format("%s %s(%s)", new Object[] { paramView.JFk, paramView.UZG, paramView.MEp }));
        localObject = r.a(new com.tencent.mm.plugin.wallet_core.ui.view.c(paramView.Ocp));
        if (localObject != null) {
          paramViewGroup.Vfw.setImageBitmap((Bitmap)localObject);
        }
        if ((paramView.abiR == null) || (Util.isNullOrNil(paramView.abiR.UZH))) {
          break label430;
        }
        paramViewGroup.Vho.setText(paramView.abiR.UZH);
        if (Util.isNullOrNil(paramView.abiR.nRQ)) {
          break label407;
        }
        paramViewGroup.Vho.setTextColor(n.dE(paramView.abiR.nRQ, true));
        label278:
        paramViewGroup.Vho.setVisibility(0);
        label286:
        paramViewGroup.Vhr.setVisibility(8);
        paramViewGroup.Vhp.setVisibility(8);
        if (paramView.abiS != null) {
          paramViewGroup.Vhm.setOnClickListener(new WalletLqtPlanHomeUI.b.1(paramViewGroup, paramView));
        }
        if (paramView.state == 1) {
          break label442;
        }
        paramViewGroup.Vhq.setVisibility(0);
        paramViewGroup.Vhn.setAlpha(0.2F);
        paramViewGroup.Vhk.setAlpha(0.2F);
        paramViewGroup.Vfw.setAlpha(0.3F);
        paramViewGroup.Vhl.setAlpha(1.0F);
      }
      for (;;)
      {
        AppMethodBeat.o(68938);
        return localView;
        paramViewGroup.Vhk.setText(WalletLqtPlanHomeUI.bgd(((BigDecimal)localObject).toString()));
        break;
        label407:
        paramViewGroup.Vho.setTextColor(paramViewGroup.Vhg.getResources().getColor(a.c.BW_50));
        break label278;
        label430:
        paramViewGroup.Vho.setVisibility(8);
        break label286;
        label442:
        paramViewGroup.Vhq.setVisibility(8);
        paramViewGroup.Vhn.setAlpha(1.0F);
        paramViewGroup.Vhk.setAlpha(1.0F);
        paramViewGroup.Vfw.setAlpha(1.0F);
        paramViewGroup.Vhl.setAlpha(1.0F);
      }
    }
  }
  
  public final class b
  {
    public CdnImageView Vfw;
    public WalletTextView Vhk;
    public ImageView Vhl;
    public LinearLayout Vhm;
    public TextView Vhn;
    public TextView Vho;
    public TextView Vhp;
    public TextView Vhq;
    public LinearLayout Vhr;
    public View rootView;
    
    public b(View paramView)
    {
      AppMethodBeat.i(68941);
      this.rootView = paramView;
      this.Vhk = ((WalletTextView)paramView.findViewById(a.f.lphi_money_tv));
      this.Vhl = ((ImageView)paramView.findViewById(a.f.lphi_more_iv));
      this.Vhq = ((TextView)paramView.findViewById(a.f.lphi_state_label_tv));
      this.Vhn = ((TextView)paramView.findViewById(a.f.lphi_desc1_tv));
      this.Vho = ((TextView)paramView.findViewById(a.f.lphi_desc2_tv));
      this.Vhp = ((TextView)paramView.findViewById(a.f.lphi_bottom_tv));
      this.Vhr = ((LinearLayout)paramView.findViewById(a.f.lphi_bottom_layout));
      this.Vfw = ((CdnImageView)paramView.findViewById(a.f.lphi_bank_iv));
      this.Vhm = ((LinearLayout)paramView.findViewById(a.f.lphi_header_tips_ll));
      int i = com.tencent.mm.cd.a.fromDPToPix(WalletLqtPlanHomeUI.this.getContext(), 50);
      Util.expandViewTouchArea(this.Vhl, i, i, i, i);
      AppMethodBeat.o(68941);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanHomeUI
 * JD-Core Version:    0.7.0.1
 */