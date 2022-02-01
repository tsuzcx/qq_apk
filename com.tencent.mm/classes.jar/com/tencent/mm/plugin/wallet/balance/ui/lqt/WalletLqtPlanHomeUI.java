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
import com.tencent.mm.protocal.protobuf.bxr;
import com.tencent.mm.protocal.protobuf.bze;
import com.tencent.mm.protocal.protobuf.cbi;
import com.tencent.mm.protocal.protobuf.cko;
import com.tencent.mm.protocal.protobuf.ckp;
import com.tencent.mm.protocal.protobuf.dos;
import com.tencent.mm.protocal.protobuf.iu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.wallet_core.c.a.a;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.e;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class WalletLqtPlanHomeUI
  extends WalletLqtBasePresenterUI
{
  private ListView CDf;
  private TextView CDg;
  private TextView CDh;
  private LinearLayout CDi;
  private Button CDj;
  private RelativeLayout CDk;
  private LinearLayout CDl;
  private RelativeLayout CDm;
  private LinearLayout CDn;
  private TextView CDo;
  private z CDp;
  private a CDq;
  private List<ckp> CDr;
  private cko CDs;
  private int requestCode;
  private ViewGroup uGg;
  
  public WalletLqtPlanHomeUI()
  {
    AppMethodBeat.i(68942);
    this.CDp = ((z)am(z.class));
    this.CDq = new a((byte)0);
    this.CDr = new ArrayList();
    AppMethodBeat.o(68942);
  }
  
  private void Vj(int paramInt)
  {
    AppMethodBeat.i(68947);
    ad.i("MicroMsg.WalletLqtPlanHomeUI", "go to add plan ui -> add");
    Intent localIntent = new Intent(this, WalletLqtPlanAddUI.class);
    localIntent.putExtra("key_mode", 1);
    startActivityForResult(localIntent, paramInt);
    AppMethodBeat.o(68947);
  }
  
  private void b(cko paramcko)
  {
    AppMethodBeat.i(68946);
    ad.i("MicroMsg.WalletLqtPlanHomeUI", "limit: %s", new Object[] { Long.valueOf(paramcko.CwM) });
    this.uGg.setVisibility(0);
    if (paramcko.CwM <= paramcko.HdZ.size())
    {
      this.uGg.findViewById(2131301635).setVisibility(8);
      TextView localTextView = (TextView)this.uGg.findViewById(2131301636);
      localTextView.setPadding(com.tencent.mm.cc.a.fromDPToPix(getContext(), 24), 0, 0, 0);
      localTextView.setText(paramcko.CwP);
      localTextView.setTextColor(getContext().getResources().getColor(2131100490));
      this.uGg.setEnabled(false);
      AppMethodBeat.o(68946);
      return;
    }
    this.uGg.findViewById(2131301635).setVisibility(0);
    paramcko = (TextView)this.uGg.findViewById(2131301636);
    paramcko.setPadding(0, 0, 0, 0);
    paramcko.setText(2131765374);
    paramcko.setTextColor(getResources().getColor(2131100711));
    this.uGg.setEnabled(true);
    AppMethodBeat.o(68946);
  }
  
  private void c(final cko paramcko)
  {
    AppMethodBeat.i(68949);
    ad.d("MicroMsg.WalletLqtPlanHomeUI", "update view");
    if (paramcko != null)
    {
      if ((paramcko.HdZ == null) || (paramcko.HdZ.isEmpty()))
      {
        ad.i("MicroMsg.WalletLqtPlanHomeUI", "show empty view");
        if (this.requestCode == 3)
        {
          eCW();
          this.CDr = paramcko.HdZ;
          this.CDq.notifyDataSetChanged();
          this.uGg.setVisibility(8);
          AppMethodBeat.o(68949);
          return;
        }
        finish();
        AppMethodBeat.o(68949);
        return;
      }
      if (bt.isNullOrNil(paramcko.CwQ)) {
        setMMTitle("");
      }
      for (;;)
      {
        setActionbarColor(getContext().getResources().getColor(2131099648));
        this.CDk.setVisibility(8);
        this.CDf.setVisibility(0);
        b(paramcko);
        this.CDr = paramcko.HdZ;
        this.CDq.notifyDataSetChanged();
        if ((paramcko.Hea == null) || (bt.isNullOrNil(paramcko.Hea.title))) {
          break;
        }
        this.CDo.setText(paramcko.Hea.title);
        this.CDl.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(68930);
            b localb = new b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtPlanHomeUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            ad.i("MicroMsg.WalletLqtPlanHomeUI", "click banner");
            e.o(WalletLqtPlanHomeUI.this.getContext(), paramcko.Hea.url, true);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtPlanHomeUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(68930);
          }
        });
        this.CDl.setVisibility(0);
        AppMethodBeat.o(68949);
        return;
        setMMTitle(paramcko.CwQ);
      }
      this.CDl.setVisibility(8);
      AppMethodBeat.o(68949);
      return;
    }
    ad.i("MicroMsg.WalletLqtPlanHomeUI", "resp is null");
    finish();
    AppMethodBeat.o(68949);
  }
  
  private void eCW()
  {
    AppMethodBeat.i(68948);
    ad.i("MicroMsg.WalletLqtPlanHomeUI", "show null plan home ui");
    setMMTitle(getString(2131765488));
    this.CDm = ((RelativeLayout)findViewById(2131301689));
    this.CDm.setVisibility(0);
    this.CDn = ((LinearLayout)findViewById(2131301688));
    this.CDn.setOnClickListener(new WalletLqtPlanHomeUI.4(this));
    AppMethodBeat.o(68948);
  }
  
  private void eCX()
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
    this.CDf = ((ListView)findViewById(2131301609));
    this.CDg = ((TextView)findViewById(2131301607));
    this.CDh = ((TextView)findViewById(2131301605));
    this.CDi = ((LinearLayout)findViewById(2131301608));
    this.CDj = ((Button)findViewById(2131301604));
    this.CDk = ((RelativeLayout)findViewById(2131301606));
    this.CDl = ((LinearLayout)findViewById(2131301646));
    this.CDo = ((TextView)findViewById(2131301647));
    this.CDq = new a((byte)0);
    this.CDf.setAdapter(this.CDq);
    this.uGg = ((ViewGroup)LayoutInflater.from(this).inflate(2131494620, this.CDf, false));
    this.uGg.setOnClickListener(new WalletLqtPlanHomeUI.3(this));
    this.CDf.addFooterView(this.uGg);
    this.CDj.setOnClickListener(new WalletLqtPlanHomeUI.1(this));
    this.CDf.setOnItemClickListener(new WalletLqtPlanHomeUI.2(this));
    AppMethodBeat.o(68944);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(68945);
    ad.i("MicroMsg.WalletLqtPlanHomeUI", "activity result: %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
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
        final Dialog localDialog = com.tencent.mm.wallet_core.ui.g.c(getContext(), false, null);
        z.a locala = this.CDp.CxP;
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
          eCX();
          continue;
          if (paramInt2 == -1)
          {
            eCX();
            this.CDm.setVisibility(8);
            continue;
            if (paramInt2 == -1) {
              eCX();
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
    ad.i("MicroMsg.WalletLqtPlanHomeUI", "WalletLqtPlanHomeUI scene：%s", new Object[] { Integer.valueOf(i) });
    CgiLqtPlanIndex.PlanIndexParcel localPlanIndexParcel;
    switch (i)
    {
    default: 
      ad.i("MicroMsg.WalletLqtPlanHomeUI", "go to plan home ui");
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
      this.CDs = paramBundle;
      c(this.CDs);
      AppMethodBeat.o(68943);
      return;
      Vj(65282);
      AppMethodBeat.o(68943);
      return;
      eCW();
      AppMethodBeat.o(68943);
      return;
      paramBundle = new cko();
      paramBundle.ozR = localPlanIndexParcel.ozR;
      paramBundle.ozS = localPlanIndexParcel.ozS;
      Iterator localIterator1 = localPlanIndexParcel.CwL.iterator();
      while (localIterator1.hasNext())
      {
        CgiLqtPlanIndex.PlanItemParcel localPlanItemParcel = (CgiLqtPlanIndex.PlanItemParcel)localIterator1.next();
        ckp localckp = new ckp();
        localckp.fKG = localPlanItemParcel.fKG;
        localckp.dOa = localPlanItemParcel.dOa;
        localckp.dkR = localPlanItemParcel.dkR;
        localckp.wCE = localPlanItemParcel.wCE;
        localckp.CwR = localPlanItemParcel.CwR;
        localckp.CwS = localPlanItemParcel.CwS;
        localckp.CwX = localPlanItemParcel.CwX;
        localckp.xSd = localPlanItemParcel.xSd;
        if (localPlanItemParcel.CwT != null)
        {
          localckp.Hec = new dos();
          localckp.Hec.CwY = localPlanItemParcel.CwT.CwY;
          localckp.Hec.hAD = localPlanItemParcel.CwT.hAD;
        }
        if (localPlanItemParcel.CwU != null)
        {
          localckp.Hed = new cbi();
          localckp.Hed.title = localPlanItemParcel.CwU.title;
          localckp.Hed.url = localPlanItemParcel.CwU.url;
        }
        if (localPlanItemParcel.CwV != null)
        {
          localckp.Hee = new bze();
          localckp.Hee.CwI = localPlanItemParcel.CwV.CwI;
          localckp.Hee.CwJ = localPlanItemParcel.CwV.CwJ;
          Iterator localIterator2 = localPlanItemParcel.CwV.CwK.iterator();
          while (localIterator2.hasNext())
          {
            Integer localInteger = (Integer)localIterator2.next();
            localckp.Hee.GUg.add(localInteger);
          }
        }
        localckp.CwW = localPlanItemParcel.CwW;
        localckp.state = localPlanItemParcel.state;
        localckp.uJF = localPlanItemParcel.uJF;
        paramBundle.HdZ.add(localckp);
      }
      paramBundle.CwM = localPlanIndexParcel.CwM;
      paramBundle.CwN = localPlanIndexParcel.CwN;
      if (localPlanIndexParcel.CwO != null)
      {
        paramBundle.Hea = new iu();
        paramBundle.Hea.title = localPlanIndexParcel.CwO.title;
        paramBundle.Hea.url = localPlanIndexParcel.CwO.url;
      }
      paramBundle.CwP = localPlanIndexParcel.CwP;
      paramBundle.CwQ = localPlanIndexParcel.CwQ;
    }
    label662:
    ad.i("MicroMsg.WalletLqtPlanHomeUI", "parcelable no instanceof CgiLqtPlanIndex.PlanIndexParcel");
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
    
    private ckp Vk(int paramInt)
    {
      AppMethodBeat.i(68937);
      ckp localckp = (ckp)WalletLqtPlanHomeUI.d(WalletLqtPlanHomeUI.this).get(paramInt);
      AppMethodBeat.o(68937);
      return localckp;
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
      paramView = Vk(paramInt);
      paramViewGroup = (WalletLqtPlanHomeUI.b)localView.getTag();
      paramViewGroup.CDx.setPrefix(ah.fRG());
      Object localObject = e.b(paramView.dOa, "100", 2, RoundingMode.HALF_UP);
      if (((BigDecimal)localObject).intValue() == ((BigDecimal)localObject).doubleValue())
      {
        paramViewGroup.CDx.setText(WalletLqtPlanHomeUI.aDY(((BigDecimal)localObject).intValue()));
        paramViewGroup.CDA.setText(String.format("%s %s(%s)", new Object[] { paramView.uJF, paramView.CwX, paramView.wCE }));
        localObject = u.a(new com.tencent.mm.plugin.wallet_core.ui.view.c(paramView.xSd));
        if (localObject != null) {
          paramViewGroup.CBK.setImageBitmap((Bitmap)localObject);
        }
        if ((paramView.Hec == null) || (bt.isNullOrNil(paramView.Hec.CwY))) {
          break label429;
        }
        paramViewGroup.CDB.setText(paramView.Hec.CwY);
        if (bt.isNullOrNil(paramView.Hec.hAD)) {
          break label406;
        }
        paramViewGroup.CDB.setTextColor(com.tencent.mm.plugin.wallet_core.utils.g.cl(paramView.Hec.hAD, true));
        label277:
        paramViewGroup.CDB.setVisibility(0);
        label285:
        paramViewGroup.CDE.setVisibility(8);
        paramViewGroup.CDC.setVisibility(8);
        if (paramView.Hed != null) {
          paramViewGroup.CDz.setOnClickListener(new WalletLqtPlanHomeUI.b.1(paramViewGroup, paramView));
        }
        if (paramView.state == 1) {
          break label441;
        }
        paramViewGroup.CDD.setVisibility(0);
        paramViewGroup.CDA.setAlpha(0.2F);
        paramViewGroup.CDx.setAlpha(0.2F);
        paramViewGroup.CBK.setAlpha(0.3F);
        paramViewGroup.CDy.setAlpha(1.0F);
      }
      for (;;)
      {
        AppMethodBeat.o(68938);
        return localView;
        paramViewGroup.CDx.setText(WalletLqtPlanHomeUI.aDY(((BigDecimal)localObject).toString()));
        break;
        label406:
        paramViewGroup.CDB.setTextColor(paramViewGroup.CDt.getResources().getColor(2131099676));
        break label277;
        label429:
        paramViewGroup.CDB.setVisibility(8);
        break label285;
        label441:
        paramViewGroup.CDD.setVisibility(8);
        paramViewGroup.CDA.setAlpha(1.0F);
        paramViewGroup.CDx.setAlpha(1.0F);
        paramViewGroup.CBK.setAlpha(1.0F);
        paramViewGroup.CDy.setAlpha(1.0F);
      }
    }
  }
  
  public final class b
  {
    public CdnImageView CBK;
    public TextView CDA;
    public TextView CDB;
    public TextView CDC;
    public TextView CDD;
    public LinearLayout CDE;
    public WalletTextView CDx;
    public ImageView CDy;
    public LinearLayout CDz;
    public View kBS;
    
    public b(View paramView)
    {
      AppMethodBeat.i(68941);
      this.kBS = paramView;
      this.CDx = ((WalletTextView)paramView.findViewById(2131301601));
      this.CDy = ((ImageView)paramView.findViewById(2131301602));
      this.CDD = ((TextView)paramView.findViewById(2131301603));
      this.CDA = ((TextView)paramView.findViewById(2131301598));
      this.CDB = ((TextView)paramView.findViewById(2131301599));
      this.CDC = ((TextView)paramView.findViewById(2131301597));
      this.CDE = ((LinearLayout)paramView.findViewById(2131301596));
      this.CBK = ((CdnImageView)paramView.findViewById(2131301595));
      this.CDz = ((LinearLayout)paramView.findViewById(2131301600));
      int i = com.tencent.mm.cc.a.fromDPToPix(WalletLqtPlanHomeUI.this.getContext(), 50);
      bt.n(this.CDy, i, i, i, i);
      AppMethodBeat.o(68941);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanHomeUI
 * JD-Core Version:    0.7.0.1
 */