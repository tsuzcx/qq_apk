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
import com.tencent.matrix.trace.core.AppMethodBeat;
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
import com.tencent.mm.protocal.protobuf.btd;
import com.tencent.mm.protocal.protobuf.bup;
import com.tencent.mm.protocal.protobuf.bws;
import com.tencent.mm.protocal.protobuf.cfp;
import com.tencent.mm.protocal.protobuf.cfq;
import com.tencent.mm.protocal.protobuf.djd;
import com.tencent.mm.protocal.protobuf.in;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
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
  private ListView BcR;
  private TextView BcS;
  private TextView BcT;
  private LinearLayout BcU;
  private Button BcV;
  private RelativeLayout BcW;
  private LinearLayout BcX;
  private RelativeLayout BcY;
  private LinearLayout BcZ;
  private TextView Bda;
  private z Bdb;
  private a Bdc;
  private List<cfq> Bdd;
  private cfp Bde;
  private int requestCode;
  private ViewGroup tDx;
  
  public WalletLqtPlanHomeUI()
  {
    AppMethodBeat.i(68942);
    this.Bdb = ((z)am(z.class));
    this.Bdc = new a((byte)0);
    this.Bdd = new ArrayList();
    AppMethodBeat.o(68942);
  }
  
  private void Tr(int paramInt)
  {
    AppMethodBeat.i(68947);
    ac.i("MicroMsg.WalletLqtPlanHomeUI", "go to add plan ui -> add");
    Intent localIntent = new Intent(this, WalletLqtPlanAddUI.class);
    localIntent.putExtra("key_mode", 1);
    startActivityForResult(localIntent, paramInt);
    AppMethodBeat.o(68947);
  }
  
  private void b(cfp paramcfp)
  {
    AppMethodBeat.i(68946);
    ac.i("MicroMsg.WalletLqtPlanHomeUI", "limit: %s", new Object[] { Long.valueOf(paramcfp.AWD) });
    this.tDx.setVisibility(0);
    if (paramcfp.AWD <= paramcfp.FtU.size())
    {
      this.tDx.findViewById(2131301635).setVisibility(8);
      TextView localTextView = (TextView)this.tDx.findViewById(2131301636);
      localTextView.setPadding(com.tencent.mm.cc.a.fromDPToPix(getContext(), 24), 0, 0, 0);
      localTextView.setText(paramcfp.AWG);
      localTextView.setTextColor(getContext().getResources().getColor(2131100490));
      this.tDx.setEnabled(false);
      AppMethodBeat.o(68946);
      return;
    }
    this.tDx.findViewById(2131301635).setVisibility(0);
    paramcfp = (TextView)this.tDx.findViewById(2131301636);
    paramcfp.setPadding(0, 0, 0, 0);
    paramcfp.setText(2131765374);
    paramcfp.setTextColor(getResources().getColor(2131100711));
    this.tDx.setEnabled(true);
    AppMethodBeat.o(68946);
  }
  
  private void c(final cfp paramcfp)
  {
    AppMethodBeat.i(68949);
    ac.d("MicroMsg.WalletLqtPlanHomeUI", "update view");
    if (paramcfp != null)
    {
      if ((paramcfp.FtU == null) || (paramcfp.FtU.isEmpty()))
      {
        ac.i("MicroMsg.WalletLqtPlanHomeUI", "show empty view");
        if (this.requestCode == 3)
        {
          eoW();
          this.Bdd = paramcfp.FtU;
          this.Bdc.notifyDataSetChanged();
          this.tDx.setVisibility(8);
          AppMethodBeat.o(68949);
          return;
        }
        finish();
        AppMethodBeat.o(68949);
        return;
      }
      if (bs.isNullOrNil(paramcfp.AWH)) {
        setMMTitle("");
      }
      for (;;)
      {
        setActionbarColor(getContext().getResources().getColor(2131099648));
        this.BcW.setVisibility(8);
        this.BcR.setVisibility(0);
        b(paramcfp);
        this.Bdd = paramcfp.FtU;
        this.Bdc.notifyDataSetChanged();
        if ((paramcfp.FtV == null) || (bs.isNullOrNil(paramcfp.FtV.title))) {
          break;
        }
        this.Bda.setText(paramcfp.FtV.title);
        this.BcX.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(68930);
            ac.i("MicroMsg.WalletLqtPlanHomeUI", "click banner");
            e.o(WalletLqtPlanHomeUI.this.getContext(), paramcfp.FtV.url, true);
            AppMethodBeat.o(68930);
          }
        });
        this.BcX.setVisibility(0);
        AppMethodBeat.o(68949);
        return;
        setMMTitle(paramcfp.AWH);
      }
      this.BcX.setVisibility(8);
      AppMethodBeat.o(68949);
      return;
    }
    ac.i("MicroMsg.WalletLqtPlanHomeUI", "resp is null");
    finish();
    AppMethodBeat.o(68949);
  }
  
  private void eoW()
  {
    AppMethodBeat.i(68948);
    ac.i("MicroMsg.WalletLqtPlanHomeUI", "show null plan home ui");
    setMMTitle(getString(2131765488));
    this.BcY = ((RelativeLayout)findViewById(2131301689));
    this.BcY.setVisibility(0);
    this.BcZ = ((LinearLayout)findViewById(2131301688));
    this.BcZ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68929);
        WalletLqtPlanHomeUI.b(WalletLqtPlanHomeUI.this);
        AppMethodBeat.o(68929);
      }
    });
    AppMethodBeat.o(68948);
  }
  
  private void eoX()
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
    this.BcR = ((ListView)findViewById(2131301609));
    this.BcS = ((TextView)findViewById(2131301607));
    this.BcT = ((TextView)findViewById(2131301605));
    this.BcU = ((LinearLayout)findViewById(2131301608));
    this.BcV = ((Button)findViewById(2131301604));
    this.BcW = ((RelativeLayout)findViewById(2131301606));
    this.BcX = ((LinearLayout)findViewById(2131301646));
    this.Bda = ((TextView)findViewById(2131301647));
    this.Bdc = new a((byte)0);
    this.BcR.setAdapter(this.Bdc);
    this.tDx = ((ViewGroup)LayoutInflater.from(this).inflate(2131494620, this.BcR, false));
    this.tDx.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68928);
        WalletLqtPlanHomeUI.a(WalletLqtPlanHomeUI.this);
        AppMethodBeat.o(68928);
      }
    });
    this.BcR.addFooterView(this.tDx);
    this.BcV.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68926);
        WalletLqtPlanHomeUI.a(WalletLqtPlanHomeUI.this);
        AppMethodBeat.o(68926);
      }
    });
    this.BcR.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(68927);
        ac.i("MicroMsg.WalletLqtPlanHomeUI", "pos: %s", new Object[] { Integer.valueOf(paramAnonymousInt) });
        paramAnonymousAdapterView.getAdapter().getItem(paramAnonymousInt);
        AppMethodBeat.o(68927);
      }
    });
    AppMethodBeat.o(68944);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(68945);
    ac.i("MicroMsg.WalletLqtPlanHomeUI", "activity result: %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
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
        z.a locala = this.Bdb.AXG;
        com.tencent.mm.vending.g.g.h(Integer.valueOf(paramInt1), Integer.valueOf(j), str).c(locala).f(new com.tencent.mm.vending.c.a() {}).a(new d.a()
        {
          public final void cc(Object paramAnonymousObject)
          {
            AppMethodBeat.i(68933);
            localDialog.dismiss();
            if ((paramAnonymousObject instanceof m)) {
              ((m)paramAnonymousObject).B(WalletLqtPlanHomeUI.this.getContext(), false);
            }
            AppMethodBeat.o(68933);
          }
        });
        continue;
        if (paramInt2 == -1)
        {
          eoX();
          continue;
          if (paramInt2 == -1)
          {
            eoX();
            this.BcY.setVisibility(8);
            continue;
            if (paramInt2 == -1) {
              eoX();
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
    ac.i("MicroMsg.WalletLqtPlanHomeUI", "WalletLqtPlanHomeUI scene：%s", new Object[] { Integer.valueOf(i) });
    CgiLqtPlanIndex.PlanIndexParcel localPlanIndexParcel;
    switch (i)
    {
    default: 
      ac.i("MicroMsg.WalletLqtPlanHomeUI", "go to plan home ui");
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
      this.Bde = paramBundle;
      c(this.Bde);
      AppMethodBeat.o(68943);
      return;
      Tr(65282);
      AppMethodBeat.o(68943);
      return;
      eoW();
      AppMethodBeat.o(68943);
      return;
      paramBundle = new cfp();
      paramBundle.nWx = localPlanIndexParcel.nWx;
      paramBundle.nWy = localPlanIndexParcel.nWy;
      Iterator localIterator1 = localPlanIndexParcel.AWC.iterator();
      while (localIterator1.hasNext())
      {
        CgiLqtPlanIndex.PlanItemParcel localPlanItemParcel = (CgiLqtPlanIndex.PlanItemParcel)localIterator1.next();
        cfq localcfq = new cfq();
        localcfq.fsg = localPlanItemParcel.fsg;
        localcfq.dBN = localPlanItemParcel.dBN;
        localcfq.cZz = localPlanItemParcel.cZz;
        localcfq.vxk = localPlanItemParcel.vxk;
        localcfq.AWI = localPlanItemParcel.AWI;
        localcfq.AWJ = localPlanItemParcel.AWJ;
        localcfq.AWO = localPlanItemParcel.AWO;
        localcfq.wEw = localPlanItemParcel.wEw;
        if (localPlanItemParcel.AWK != null)
        {
          localcfq.FtX = new djd();
          localcfq.FtX.AWP = localPlanItemParcel.AWK.AWP;
          localcfq.FtX.hiu = localPlanItemParcel.AWK.hiu;
        }
        if (localPlanItemParcel.AWL != null)
        {
          localcfq.FtY = new bws();
          localcfq.FtY.title = localPlanItemParcel.AWL.title;
          localcfq.FtY.url = localPlanItemParcel.AWL.url;
        }
        if (localPlanItemParcel.AWM != null)
        {
          localcfq.FtZ = new bup();
          localcfq.FtZ.AWz = localPlanItemParcel.AWM.AWz;
          localcfq.FtZ.AWA = localPlanItemParcel.AWM.AWA;
          Iterator localIterator2 = localPlanItemParcel.AWM.AWB.iterator();
          while (localIterator2.hasNext())
          {
            Integer localInteger = (Integer)localIterator2.next();
            localcfq.FtZ.Fky.add(localInteger);
          }
        }
        localcfq.AWN = localPlanItemParcel.AWN;
        localcfq.state = localPlanItemParcel.state;
        localcfq.tGS = localPlanItemParcel.tGS;
        paramBundle.FtU.add(localcfq);
      }
      paramBundle.AWD = localPlanIndexParcel.AWD;
      paramBundle.AWE = localPlanIndexParcel.AWE;
      if (localPlanIndexParcel.AWF != null)
      {
        paramBundle.FtV = new in();
        paramBundle.FtV.title = localPlanIndexParcel.AWF.title;
        paramBundle.FtV.url = localPlanIndexParcel.AWF.url;
      }
      paramBundle.AWG = localPlanIndexParcel.AWG;
      paramBundle.AWH = localPlanIndexParcel.AWH;
    }
    label662:
    ac.i("MicroMsg.WalletLqtPlanHomeUI", "parcelable no instanceof CgiLqtPlanIndex.PlanIndexParcel");
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
    
    private cfq Ts(int paramInt)
    {
      AppMethodBeat.i(68937);
      cfq localcfq = (cfq)WalletLqtPlanHomeUI.d(WalletLqtPlanHomeUI.this).get(paramInt);
      AppMethodBeat.o(68937);
      return localcfq;
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
      paramView = Ts(paramInt);
      paramViewGroup = (WalletLqtPlanHomeUI.b)localView.getTag();
      paramViewGroup.Bdj.setPrefix(ah.fAw());
      Object localObject = e.a(paramView.dBN, "100", 2, RoundingMode.HALF_UP);
      if (((BigDecimal)localObject).intValue() == ((BigDecimal)localObject).doubleValue())
      {
        paramViewGroup.Bdj.setText(WalletLqtPlanHomeUI.ayQ(((BigDecimal)localObject).intValue()));
        paramViewGroup.Bdm.setText(String.format("%s %s(%s)", new Object[] { paramView.tGS, paramView.AWO, paramView.vxk }));
        localObject = u.a(new com.tencent.mm.plugin.wallet_core.ui.view.c(paramView.wEw));
        if (localObject != null) {
          paramViewGroup.Bbx.setImageBitmap((Bitmap)localObject);
        }
        if ((paramView.FtX == null) || (bs.isNullOrNil(paramView.FtX.AWP))) {
          break label429;
        }
        paramViewGroup.Bdn.setText(paramView.FtX.AWP);
        if (bs.isNullOrNil(paramView.FtX.hiu)) {
          break label406;
        }
        paramViewGroup.Bdn.setTextColor(com.tencent.mm.plugin.wallet_core.utils.g.cd(paramView.FtX.hiu, true));
        label277:
        paramViewGroup.Bdn.setVisibility(0);
        label285:
        paramViewGroup.Bdq.setVisibility(8);
        paramViewGroup.Bdo.setVisibility(8);
        if (paramView.FtY != null) {
          paramViewGroup.Bdl.setOnClickListener(new WalletLqtPlanHomeUI.b.1(paramViewGroup, paramView));
        }
        if (paramView.state == 1) {
          break label441;
        }
        paramViewGroup.Bdp.setVisibility(0);
        paramViewGroup.Bdm.setAlpha(0.2F);
        paramViewGroup.Bdj.setAlpha(0.2F);
        paramViewGroup.Bbx.setAlpha(0.3F);
        paramViewGroup.Bdk.setAlpha(1.0F);
      }
      for (;;)
      {
        AppMethodBeat.o(68938);
        return localView;
        paramViewGroup.Bdj.setText(WalletLqtPlanHomeUI.ayQ(((BigDecimal)localObject).toString()));
        break;
        label406:
        paramViewGroup.Bdn.setTextColor(paramViewGroup.Bdf.getResources().getColor(2131099676));
        break label277;
        label429:
        paramViewGroup.Bdn.setVisibility(8);
        break label285;
        label441:
        paramViewGroup.Bdp.setVisibility(8);
        paramViewGroup.Bdm.setAlpha(1.0F);
        paramViewGroup.Bdj.setAlpha(1.0F);
        paramViewGroup.Bbx.setAlpha(1.0F);
        paramViewGroup.Bdk.setAlpha(1.0F);
      }
    }
  }
  
  public final class b
  {
    public CdnImageView Bbx;
    public WalletTextView Bdj;
    public ImageView Bdk;
    public LinearLayout Bdl;
    public TextView Bdm;
    public TextView Bdn;
    public TextView Bdo;
    public TextView Bdp;
    public LinearLayout Bdq;
    public View khe;
    
    public b(View paramView)
    {
      AppMethodBeat.i(68941);
      this.khe = paramView;
      this.Bdj = ((WalletTextView)paramView.findViewById(2131301601));
      this.Bdk = ((ImageView)paramView.findViewById(2131301602));
      this.Bdp = ((TextView)paramView.findViewById(2131301603));
      this.Bdm = ((TextView)paramView.findViewById(2131301598));
      this.Bdn = ((TextView)paramView.findViewById(2131301599));
      this.Bdo = ((TextView)paramView.findViewById(2131301597));
      this.Bdq = ((LinearLayout)paramView.findViewById(2131301596));
      this.Bbx = ((CdnImageView)paramView.findViewById(2131301595));
      this.Bdl = ((LinearLayout)paramView.findViewById(2131301600));
      int i = com.tencent.mm.cc.a.fromDPToPix(WalletLqtPlanHomeUI.this.getContext(), 50);
      bs.n(this.Bdk, i, i, i, i);
      AppMethodBeat.o(68941);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanHomeUI
 * JD-Core Version:    0.7.0.1
 */