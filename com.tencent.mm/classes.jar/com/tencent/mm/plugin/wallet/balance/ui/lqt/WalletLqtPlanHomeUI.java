package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.wallet.balance.model.lqt.CgiLqtPlanIndex;
import com.tencent.mm.plugin.wallet.balance.model.lqt.CgiLqtPlanIndex.BannerParcel;
import com.tencent.mm.plugin.wallet.balance.model.lqt.CgiLqtPlanIndex.MngPlanItemParcel;
import com.tencent.mm.plugin.wallet.balance.model.lqt.CgiLqtPlanIndex.MoreRecordsParcel;
import com.tencent.mm.plugin.wallet.balance.model.lqt.CgiLqtPlanIndex.PlanIndexParcel;
import com.tencent.mm.plugin.wallet.balance.model.lqt.CgiLqtPlanIndex.PlanItemParcel;
import com.tencent.mm.plugin.wallet.balance.model.lqt.CgiLqtPlanIndex.TransTipsItemParcel;
import com.tencent.mm.plugin.wallet.balance.model.lqt.q;
import com.tencent.mm.plugin.wallet.balance.model.lqt.z;
import com.tencent.mm.plugin.wallet.balance.model.lqt.z.a;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.byl;
import com.tencent.mm.protocal.protobuf.bzy;
import com.tencent.mm.protocal.protobuf.ccc;
import com.tencent.mm.protocal.protobuf.cli;
import com.tencent.mm.protocal.protobuf.clj;
import com.tencent.mm.protocal.protobuf.dpp;
import com.tencent.mm.protocal.protobuf.iu;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.wallet_core.c.a.a;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.mm.wallet_core.ui.h;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class WalletLqtPlanHomeUI
  extends WalletLqtBasePresenterUI
{
  private ListView CUL;
  private TextView CUM;
  private TextView CUN;
  private LinearLayout CUO;
  private Button CUP;
  private RelativeLayout CUQ;
  private LinearLayout CUR;
  private RelativeLayout CUS;
  private LinearLayout CUT;
  private TextView CUU;
  private z CUV;
  private a CUW;
  private List<clj> CUX;
  private cli CUY;
  private int requestCode;
  private ViewGroup uRT;
  
  public WalletLqtPlanHomeUI()
  {
    AppMethodBeat.i(68942);
    this.CUV = ((z)am(z.class));
    this.CUW = new a((byte)0);
    this.CUX = new ArrayList();
    AppMethodBeat.o(68942);
  }
  
  private void VQ(int paramInt)
  {
    AppMethodBeat.i(68947);
    ae.i("MicroMsg.WalletLqtPlanHomeUI", "go to add plan ui -> add");
    Intent localIntent = new Intent(this, WalletLqtPlanAddUI.class);
    localIntent.putExtra("key_mode", 1);
    startActivityForResult(localIntent, paramInt);
    AppMethodBeat.o(68947);
  }
  
  private void b(cli paramcli)
  {
    AppMethodBeat.i(68946);
    ae.i("MicroMsg.WalletLqtPlanHomeUI", "limit: %s", new Object[] { Long.valueOf(paramcli.COr) });
    this.uRT.setVisibility(0);
    if (paramcli.COr <= paramcli.Hxz.size())
    {
      this.uRT.findViewById(2131301635).setVisibility(8);
      TextView localTextView = (TextView)this.uRT.findViewById(2131301636);
      localTextView.setPadding(com.tencent.mm.cb.a.fromDPToPix(getContext(), 24), 0, 0, 0);
      localTextView.setText(paramcli.COu);
      localTextView.setTextColor(getContext().getResources().getColor(2131100490));
      this.uRT.setEnabled(false);
      AppMethodBeat.o(68946);
      return;
    }
    this.uRT.findViewById(2131301635).setVisibility(0);
    paramcli = (TextView)this.uRT.findViewById(2131301636);
    paramcli.setPadding(0, 0, 0, 0);
    paramcli.setText(2131765374);
    paramcli.setTextColor(getResources().getColor(2131100711));
    this.uRT.setEnabled(true);
    AppMethodBeat.o(68946);
  }
  
  private void c(final cli paramcli)
  {
    AppMethodBeat.i(68949);
    ae.d("MicroMsg.WalletLqtPlanHomeUI", "update view");
    if (paramcli != null)
    {
      if ((paramcli.Hxz == null) || (paramcli.Hxz.isEmpty()))
      {
        ae.i("MicroMsg.WalletLqtPlanHomeUI", "show empty view");
        if (this.requestCode == 3)
        {
          eGD();
          this.CUX = paramcli.Hxz;
          this.CUW.notifyDataSetChanged();
          this.uRT.setVisibility(8);
          AppMethodBeat.o(68949);
          return;
        }
        finish();
        AppMethodBeat.o(68949);
        return;
      }
      if (bu.isNullOrNil(paramcli.COv)) {
        setMMTitle("");
      }
      for (;;)
      {
        setActionbarColor(getContext().getResources().getColor(2131099648));
        this.CUQ.setVisibility(8);
        this.CUL.setVisibility(0);
        b(paramcli);
        this.CUX = paramcli.Hxz;
        this.CUW.notifyDataSetChanged();
        if ((paramcli.HxA == null) || (bu.isNullOrNil(paramcli.HxA.title))) {
          break;
        }
        this.CUU.setText(paramcli.HxA.title);
        this.CUR.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(68930);
            b localb = new b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtPlanHomeUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            ae.i("MicroMsg.WalletLqtPlanHomeUI", "click banner");
            f.p(WalletLqtPlanHomeUI.this.getContext(), paramcli.HxA.url, true);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtPlanHomeUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(68930);
          }
        });
        this.CUR.setVisibility(0);
        AppMethodBeat.o(68949);
        return;
        setMMTitle(paramcli.COv);
      }
      this.CUR.setVisibility(8);
      AppMethodBeat.o(68949);
      return;
    }
    ae.i("MicroMsg.WalletLqtPlanHomeUI", "resp is null");
    finish();
    AppMethodBeat.o(68949);
  }
  
  private void eGD()
  {
    AppMethodBeat.i(68948);
    ae.i("MicroMsg.WalletLqtPlanHomeUI", "show null plan home ui");
    setMMTitle(getString(2131765488));
    this.CUS = ((RelativeLayout)findViewById(2131301689));
    this.CUS.setVisibility(0);
    this.CUT = ((LinearLayout)findViewById(2131301688));
    this.CUT.setOnClickListener(new WalletLqtPlanHomeUI.4(this));
    AppMethodBeat.o(68948);
  }
  
  private void eGE()
  {
    AppMethodBeat.i(68950);
    q localq = new q();
    localq.b(new CgiLqtPlanIndex());
    localq.a(new a.a() {}, 0L);
    AppMethodBeat.o(68950);
  }
  
  public int getLayoutId()
  {
    return 2131494621;
  }
  
  public void initView()
  {
    AppMethodBeat.i(68944);
    this.CUL = ((ListView)findViewById(2131301609));
    this.CUM = ((TextView)findViewById(2131301607));
    this.CUN = ((TextView)findViewById(2131301605));
    this.CUO = ((LinearLayout)findViewById(2131301608));
    this.CUP = ((Button)findViewById(2131301604));
    this.CUQ = ((RelativeLayout)findViewById(2131301606));
    this.CUR = ((LinearLayout)findViewById(2131301646));
    this.CUU = ((TextView)findViewById(2131301647));
    this.CUW = new a((byte)0);
    this.CUL.setAdapter(this.CUW);
    this.uRT = ((ViewGroup)LayoutInflater.from(this).inflate(2131494620, this.CUL, false));
    this.uRT.setOnClickListener(new WalletLqtPlanHomeUI.3(this));
    this.CUL.addFooterView(this.uRT);
    this.CUP.setOnClickListener(new WalletLqtPlanHomeUI.1(this));
    this.CUL.setOnItemClickListener(new WalletLqtPlanHomeUI.2(this));
    AppMethodBeat.o(68944);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(68945);
    ae.i("MicroMsg.WalletLqtPlanHomeUI", "activity result: %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
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
        final Dialog localDialog = h.c(getContext(), false, null);
        z.a locala = this.CUV.CPu;
        com.tencent.mm.vending.g.g.h(Integer.valueOf(paramInt1), Integer.valueOf(j), str).c(locala).f(new com.tencent.mm.vending.c.a() {}).a(new d.a()
        {
          public final void ce(Object paramAnonymousObject)
          {
            AppMethodBeat.i(68933);
            localDialog.dismiss();
            if ((paramAnonymousObject instanceof m)) {
              ((m)paramAnonymousObject).D(WalletLqtPlanHomeUI.this.getContext(), false);
            }
            AppMethodBeat.o(68933);
          }
        });
        continue;
        if (paramInt2 == -1)
        {
          eGE();
          continue;
          if (paramInt2 == -1)
          {
            eGE();
            this.CUS.setVisibility(8);
            continue;
            if (paramInt2 == -1) {
              eGE();
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
    setActionbarColor(getResources().getColor(2131099648));
    setStatusColor();
    hideActionbarLine();
    initView();
    int i = getIntent().getIntExtra("key_plan_go_scene_ui", 0);
    ae.i("MicroMsg.WalletLqtPlanHomeUI", "WalletLqtPlanHomeUI scene：%s", new Object[] { Integer.valueOf(i) });
    CgiLqtPlanIndex.PlanIndexParcel localPlanIndexParcel;
    switch (i)
    {
    default: 
      ae.i("MicroMsg.WalletLqtPlanHomeUI", "go to plan home ui");
      paramBundle = getIntent().getParcelableExtra("key_plan_index_resp");
      if (!(paramBundle instanceof CgiLqtPlanIndex.PlanIndexParcel)) {
        break label662;
      }
      localPlanIndexParcel = (CgiLqtPlanIndex.PlanIndexParcel)paramBundle;
      if (localPlanIndexParcel == null) {
        paramBundle = null;
      }
      break;
    }
    for (;;)
    {
      this.CUY = paramBundle;
      c(this.CUY);
      AppMethodBeat.o(68943);
      return;
      VQ(65282);
      AppMethodBeat.o(68943);
      return;
      eGD();
      AppMethodBeat.o(68943);
      return;
      paramBundle = new cli();
      paramBundle.oGt = localPlanIndexParcel.oGt;
      paramBundle.oGu = localPlanIndexParcel.oGu;
      Iterator localIterator1 = localPlanIndexParcel.COq.iterator();
      while (localIterator1.hasNext())
      {
        CgiLqtPlanIndex.PlanItemParcel localPlanItemParcel = (CgiLqtPlanIndex.PlanItemParcel)localIterator1.next();
        clj localclj = new clj();
        localclj.fMJ = localPlanItemParcel.fMJ;
        localclj.dPq = localPlanItemParcel.dPq;
        localclj.dlT = localPlanItemParcel.dlT;
        localclj.wSp = localPlanItemParcel.wSp;
        localclj.COw = localPlanItemParcel.COw;
        localclj.COx = localPlanItemParcel.COx;
        localclj.COC = localPlanItemParcel.COC;
        localclj.yhW = localPlanItemParcel.yhW;
        if (localPlanItemParcel.COy != null)
        {
          localclj.HxC = new dpp();
          localclj.HxC.COD = localPlanItemParcel.COy.COD;
          localclj.HxC.hDr = localPlanItemParcel.COy.hDr;
        }
        if (localPlanItemParcel.COz != null)
        {
          localclj.HxD = new ccc();
          localclj.HxD.title = localPlanItemParcel.COz.title;
          localclj.HxD.url = localPlanItemParcel.COz.url;
        }
        if (localPlanItemParcel.COA != null)
        {
          localclj.HxE = new bzy();
          localclj.HxE.COn = localPlanItemParcel.COA.COn;
          localclj.HxE.COo = localPlanItemParcel.COA.COo;
          Iterator localIterator2 = localPlanItemParcel.COA.COp.iterator();
          while (localIterator2.hasNext())
          {
            Integer localInteger = (Integer)localIterator2.next();
            localclj.HxE.HnH.add(localInteger);
          }
        }
        localclj.COB = localPlanItemParcel.COB;
        localclj.state = localPlanItemParcel.state;
        localclj.uVs = localPlanItemParcel.uVs;
        paramBundle.Hxz.add(localclj);
      }
      paramBundle.COr = localPlanIndexParcel.COr;
      paramBundle.COs = localPlanIndexParcel.COs;
      if (localPlanIndexParcel.COt != null)
      {
        paramBundle.HxA = new iu();
        paramBundle.HxA.title = localPlanIndexParcel.COt.title;
        paramBundle.HxA.url = localPlanIndexParcel.COt.url;
      }
      paramBundle.COu = localPlanIndexParcel.COu;
      paramBundle.COv = localPlanIndexParcel.COv;
    }
    label662:
    ae.i("MicroMsg.WalletLqtPlanHomeUI", "parcelable no instanceof CgiLqtPlanIndex.PlanIndexParcel");
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
    
    private clj VR(int paramInt)
    {
      AppMethodBeat.i(68937);
      clj localclj = (clj)WalletLqtPlanHomeUI.d(WalletLqtPlanHomeUI.this).get(paramInt);
      AppMethodBeat.o(68937);
      return localclj;
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
        localView = LayoutInflater.from(WalletLqtPlanHomeUI.this.getContext()).inflate(2131494619, paramViewGroup, false);
        localView.setTag(new WalletLqtPlanHomeUI.b(WalletLqtPlanHomeUI.this, localView));
      }
      paramView = VR(paramInt);
      paramViewGroup = (WalletLqtPlanHomeUI.b)localView.getTag();
      paramViewGroup.CVd.setPrefix(ah.fWc());
      Object localObject = f.b(paramView.dPq, "100", 2, RoundingMode.HALF_UP);
      if (((BigDecimal)localObject).intValue() == ((BigDecimal)localObject).doubleValue())
      {
        paramViewGroup.CVd.setText(WalletLqtPlanHomeUI.aFr(((BigDecimal)localObject).intValue()));
        paramViewGroup.CVg.setText(String.format("%s %s(%s)", new Object[] { paramView.uVs, paramView.COC, paramView.wSp }));
        localObject = u.a(new com.tencent.mm.plugin.wallet_core.ui.view.c(paramView.yhW));
        if (localObject != null) {
          paramViewGroup.CTr.setImageBitmap((Bitmap)localObject);
        }
        if ((paramView.HxC == null) || (bu.isNullOrNil(paramView.HxC.COD))) {
          break label429;
        }
        paramViewGroup.CVh.setText(paramView.HxC.COD);
        if (bu.isNullOrNil(paramView.HxC.hDr)) {
          break label406;
        }
        paramViewGroup.CVh.setTextColor(com.tencent.mm.plugin.wallet_core.utils.g.cp(paramView.HxC.hDr, true));
        label277:
        paramViewGroup.CVh.setVisibility(0);
        label285:
        paramViewGroup.CVk.setVisibility(8);
        paramViewGroup.CVi.setVisibility(8);
        if (paramView.HxD != null) {
          paramViewGroup.CVf.setOnClickListener(new WalletLqtPlanHomeUI.b.1(paramViewGroup, paramView));
        }
        if (paramView.state == 1) {
          break label441;
        }
        paramViewGroup.CVj.setVisibility(0);
        paramViewGroup.CVg.setAlpha(0.2F);
        paramViewGroup.CVd.setAlpha(0.2F);
        paramViewGroup.CTr.setAlpha(0.3F);
        paramViewGroup.CVe.setAlpha(1.0F);
      }
      for (;;)
      {
        AppMethodBeat.o(68938);
        return localView;
        paramViewGroup.CVd.setText(WalletLqtPlanHomeUI.aFr(((BigDecimal)localObject).toString()));
        break;
        label406:
        paramViewGroup.CVh.setTextColor(paramViewGroup.CUZ.getResources().getColor(2131099676));
        break label277;
        label429:
        paramViewGroup.CVh.setVisibility(8);
        break label285;
        label441:
        paramViewGroup.CVj.setVisibility(8);
        paramViewGroup.CVg.setAlpha(1.0F);
        paramViewGroup.CVd.setAlpha(1.0F);
        paramViewGroup.CTr.setAlpha(1.0F);
        paramViewGroup.CVe.setAlpha(1.0F);
      }
    }
  }
  
  public final class b
  {
    public CdnImageView CTr;
    public WalletTextView CVd;
    public ImageView CVe;
    public LinearLayout CVf;
    public TextView CVg;
    public TextView CVh;
    public TextView CVi;
    public TextView CVj;
    public LinearLayout CVk;
    public View kFh;
    
    public b(View paramView)
    {
      AppMethodBeat.i(68941);
      this.kFh = paramView;
      this.CVd = ((WalletTextView)paramView.findViewById(2131301601));
      this.CVe = ((ImageView)paramView.findViewById(2131301602));
      this.CVj = ((TextView)paramView.findViewById(2131301603));
      this.CVg = ((TextView)paramView.findViewById(2131301598));
      this.CVh = ((TextView)paramView.findViewById(2131301599));
      this.CVi = ((TextView)paramView.findViewById(2131301597));
      this.CVk = ((LinearLayout)paramView.findViewById(2131301596));
      this.CTr = ((CdnImageView)paramView.findViewById(2131301595));
      this.CVf = ((LinearLayout)paramView.findViewById(2131301600));
      int i = com.tencent.mm.cb.a.fromDPToPix(WalletLqtPlanHomeUI.this.getContext(), 50);
      bu.n(this.CVe, i, i, i, i);
      AppMethodBeat.o(68941);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanHomeUI
 * JD-Core Version:    0.7.0.1
 */