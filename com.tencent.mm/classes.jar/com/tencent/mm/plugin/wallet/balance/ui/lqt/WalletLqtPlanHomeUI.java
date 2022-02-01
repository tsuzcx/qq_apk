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
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.bon;
import com.tencent.mm.protocal.protobuf.bpy;
import com.tencent.mm.protocal.protobuf.bsb;
import com.tencent.mm.protocal.protobuf.caq;
import com.tencent.mm.protocal.protobuf.car;
import com.tencent.mm.protocal.protobuf.ddo;
import com.tencent.mm.protocal.protobuf.ih;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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
  private int requestCode;
  private ViewGroup svI;
  private ListView zKF;
  private TextView zKG;
  private TextView zKH;
  private LinearLayout zKI;
  private Button zKJ;
  private RelativeLayout zKK;
  private LinearLayout zKL;
  private RelativeLayout zKM;
  private LinearLayout zKN;
  private TextView zKO;
  private z zKP;
  private a zKQ;
  private List<car> zKR;
  private caq zKS;
  
  public WalletLqtPlanHomeUI()
  {
    AppMethodBeat.i(68942);
    this.zKP = ((z)am(z.class));
    this.zKQ = new a((byte)0);
    this.zKR = new ArrayList();
    AppMethodBeat.o(68942);
  }
  
  private void Ri(int paramInt)
  {
    AppMethodBeat.i(68947);
    ad.i("MicroMsg.WalletLqtPlanHomeUI", "go to add plan ui -> add");
    Intent localIntent = new Intent(this, WalletLqtPlanAddUI.class);
    localIntent.putExtra("key_mode", 1);
    startActivityForResult(localIntent, paramInt);
    AppMethodBeat.o(68947);
  }
  
  private void b(caq paramcaq)
  {
    AppMethodBeat.i(68946);
    ad.i("MicroMsg.WalletLqtPlanHomeUI", "limit: %s", new Object[] { Long.valueOf(paramcaq.zEq) });
    this.svI.setVisibility(0);
    if (paramcaq.zEq <= paramcaq.DXb.size())
    {
      this.svI.findViewById(2131301635).setVisibility(8);
      TextView localTextView = (TextView)this.svI.findViewById(2131301636);
      localTextView.setPadding(com.tencent.mm.cd.a.fromDPToPix(getContext(), 24), 0, 0, 0);
      localTextView.setText(paramcaq.zEt);
      localTextView.setTextColor(getContext().getResources().getColor(2131100490));
      this.svI.setEnabled(false);
      AppMethodBeat.o(68946);
      return;
    }
    this.svI.findViewById(2131301635).setVisibility(0);
    paramcaq = (TextView)this.svI.findViewById(2131301636);
    paramcaq.setPadding(0, 0, 0, 0);
    paramcaq.setText(2131765374);
    paramcaq.setTextColor(getResources().getColor(2131100711));
    this.svI.setEnabled(true);
    AppMethodBeat.o(68946);
  }
  
  private void c(caq paramcaq)
  {
    AppMethodBeat.i(68949);
    ad.d("MicroMsg.WalletLqtPlanHomeUI", "update view");
    if (paramcaq != null)
    {
      if ((paramcaq.DXb == null) || (paramcaq.DXb.isEmpty()))
      {
        ad.i("MicroMsg.WalletLqtPlanHomeUI", "show empty view");
        if (this.requestCode == 3)
        {
          dZA();
          this.zKR = paramcaq.DXb;
          this.zKQ.notifyDataSetChanged();
          this.svI.setVisibility(8);
          AppMethodBeat.o(68949);
          return;
        }
        finish();
        AppMethodBeat.o(68949);
        return;
      }
      if (bt.isNullOrNil(paramcaq.zEu)) {
        setMMTitle("");
      }
      for (;;)
      {
        setActionbarColor(getContext().getResources().getColor(2131099648));
        this.zKK.setVisibility(8);
        this.zKF.setVisibility(0);
        b(paramcaq);
        this.zKR = paramcaq.DXb;
        this.zKQ.notifyDataSetChanged();
        if ((paramcaq.DXc == null) || (bt.isNullOrNil(paramcaq.DXc.title))) {
          break;
        }
        this.zKO.setText(paramcaq.DXc.title);
        this.zKL.setOnClickListener(new WalletLqtPlanHomeUI.5(this, paramcaq));
        this.zKL.setVisibility(0);
        AppMethodBeat.o(68949);
        return;
        setMMTitle(paramcaq.zEu);
      }
      this.zKL.setVisibility(8);
      AppMethodBeat.o(68949);
      return;
    }
    ad.i("MicroMsg.WalletLqtPlanHomeUI", "resp is null");
    finish();
    AppMethodBeat.o(68949);
  }
  
  private void dZA()
  {
    AppMethodBeat.i(68948);
    ad.i("MicroMsg.WalletLqtPlanHomeUI", "show null plan home ui");
    setMMTitle(getString(2131765488));
    this.zKM = ((RelativeLayout)findViewById(2131301689));
    this.zKM.setVisibility(0);
    this.zKN = ((LinearLayout)findViewById(2131301688));
    this.zKN.setOnClickListener(new View.OnClickListener()
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
  
  private void dZB()
  {
    AppMethodBeat.i(68950);
    q localq = new q();
    localq.b(new CgiLqtPlanIndex());
    localq.a(new WalletLqtPlanHomeUI.6(this), 0L);
    AppMethodBeat.o(68950);
  }
  
  public int getLayoutId()
  {
    return 2131494621;
  }
  
  public void initView()
  {
    AppMethodBeat.i(68944);
    this.zKF = ((ListView)findViewById(2131301609));
    this.zKG = ((TextView)findViewById(2131301607));
    this.zKH = ((TextView)findViewById(2131301605));
    this.zKI = ((LinearLayout)findViewById(2131301608));
    this.zKJ = ((Button)findViewById(2131301604));
    this.zKK = ((RelativeLayout)findViewById(2131301606));
    this.zKL = ((LinearLayout)findViewById(2131301646));
    this.zKO = ((TextView)findViewById(2131301647));
    this.zKQ = new a((byte)0);
    this.zKF.setAdapter(this.zKQ);
    this.svI = ((ViewGroup)LayoutInflater.from(this).inflate(2131494620, this.zKF, false));
    this.svI.setOnClickListener(new WalletLqtPlanHomeUI.3(this));
    this.zKF.addFooterView(this.svI);
    this.zKJ.setOnClickListener(new WalletLqtPlanHomeUI.1(this));
    this.zKF.setOnItemClickListener(new WalletLqtPlanHomeUI.2(this));
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
        z.a locala = this.zKP.zFt;
        com.tencent.mm.vending.g.g.h(Integer.valueOf(paramInt1), Integer.valueOf(j), str).c(locala).f(new com.tencent.mm.vending.c.a() {}).a(new WalletLqtPlanHomeUI.7(this, localDialog));
        continue;
        if (paramInt2 == -1)
        {
          dZB();
          continue;
          if (paramInt2 == -1)
          {
            dZB();
            this.zKM.setVisibility(8);
            continue;
            if (paramInt2 == -1) {
              dZB();
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
      this.zKS = paramBundle;
      c(this.zKS);
      AppMethodBeat.o(68943);
      return;
      Ri(65282);
      AppMethodBeat.o(68943);
      return;
      dZA();
      AppMethodBeat.o(68943);
      return;
      paramBundle = new caq();
      paramBundle.ntx = localPlanIndexParcel.ntx;
      paramBundle.nty = localPlanIndexParcel.nty;
      Iterator localIterator1 = localPlanIndexParcel.zEp.iterator();
      while (localIterator1.hasNext())
      {
        CgiLqtPlanIndex.PlanItemParcel localPlanItemParcel = (CgiLqtPlanIndex.PlanItemParcel)localIterator1.next();
        car localcar = new car();
        localcar.foG = localPlanItemParcel.foG;
        localcar.dEb = localPlanItemParcel.dEb;
        localcar.dca = localPlanItemParcel.dca;
        localcar.uoo = localPlanItemParcel.uoo;
        localcar.zEv = localPlanItemParcel.zEv;
        localcar.zEw = localPlanItemParcel.zEw;
        localcar.zEB = localPlanItemParcel.zEB;
        localcar.vur = localPlanItemParcel.vur;
        if (localPlanItemParcel.zEx != null)
        {
          localcar.DXe = new ddo();
          localcar.DXe.zEC = localPlanItemParcel.zEx.zEC;
          localcar.DXe.gHT = localPlanItemParcel.zEx.gHT;
        }
        if (localPlanItemParcel.zEy != null)
        {
          localcar.DXf = new bsb();
          localcar.DXf.title = localPlanItemParcel.zEy.title;
          localcar.DXf.url = localPlanItemParcel.zEy.url;
        }
        if (localPlanItemParcel.zEz != null)
        {
          localcar.DXg = new bpy();
          localcar.DXg.zEm = localPlanItemParcel.zEz.zEm;
          localcar.DXg.zEn = localPlanItemParcel.zEz.zEn;
          Iterator localIterator2 = localPlanItemParcel.zEz.zEo.iterator();
          while (localIterator2.hasNext())
          {
            Integer localInteger = (Integer)localIterator2.next();
            localcar.DXg.DOh.add(localInteger);
          }
        }
        localcar.zEA = localPlanItemParcel.zEA;
        localcar.state = localPlanItemParcel.state;
        localcar.szi = localPlanItemParcel.szi;
        paramBundle.DXb.add(localcar);
      }
      paramBundle.zEq = localPlanIndexParcel.zEq;
      paramBundle.zEr = localPlanIndexParcel.zEr;
      if (localPlanIndexParcel.zEs != null)
      {
        paramBundle.DXc = new ih();
        paramBundle.DXc.title = localPlanIndexParcel.zEs.title;
        paramBundle.DXc.url = localPlanIndexParcel.zEs.url;
      }
      paramBundle.zEt = localPlanIndexParcel.zEt;
      paramBundle.zEu = localPlanIndexParcel.zEu;
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
    
    private car Rj(int paramInt)
    {
      AppMethodBeat.i(68937);
      car localcar = (car)WalletLqtPlanHomeUI.d(WalletLqtPlanHomeUI.this).get(paramInt);
      AppMethodBeat.o(68937);
      return localcar;
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
      paramView = Rj(paramInt);
      paramViewGroup = (WalletLqtPlanHomeUI.b)localView.getTag();
      paramViewGroup.zKX.setPrefix(ah.fkg());
      Object localObject = e.a(paramView.dEb, "100", 2, RoundingMode.HALF_UP);
      if (((BigDecimal)localObject).intValue() == ((BigDecimal)localObject).doubleValue())
      {
        paramViewGroup.zKX.setText(WalletLqtPlanHomeUI.aty(((BigDecimal)localObject).intValue()));
        paramViewGroup.zLa.setText(String.format("%s %s(%s)", new Object[] { paramView.szi, paramView.zEB, paramView.uoo }));
        localObject = u.a(new com.tencent.mm.plugin.wallet_core.ui.view.c(paramView.vur));
        if (localObject != null) {
          paramViewGroup.zJl.setImageBitmap((Bitmap)localObject);
        }
        if ((paramView.DXe == null) || (bt.isNullOrNil(paramView.DXe.zEC))) {
          break label429;
        }
        paramViewGroup.zLb.setText(paramView.DXe.zEC);
        if (bt.isNullOrNil(paramView.DXe.gHT)) {
          break label406;
        }
        paramViewGroup.zLb.setTextColor(com.tencent.mm.plugin.wallet_core.utils.g.bW(paramView.DXe.gHT, true));
        label277:
        paramViewGroup.zLb.setVisibility(0);
        label285:
        paramViewGroup.zLe.setVisibility(8);
        paramViewGroup.zLc.setVisibility(8);
        if (paramView.DXf != null) {
          paramViewGroup.zKZ.setOnClickListener(new WalletLqtPlanHomeUI.b.1(paramViewGroup, paramView));
        }
        if (paramView.state == 1) {
          break label441;
        }
        paramViewGroup.zLd.setVisibility(0);
        paramViewGroup.zLa.setAlpha(0.2F);
        paramViewGroup.zKX.setAlpha(0.2F);
        paramViewGroup.zJl.setAlpha(0.3F);
        paramViewGroup.zKY.setAlpha(1.0F);
      }
      for (;;)
      {
        AppMethodBeat.o(68938);
        return localView;
        paramViewGroup.zKX.setText(WalletLqtPlanHomeUI.aty(((BigDecimal)localObject).toString()));
        break;
        label406:
        paramViewGroup.zLb.setTextColor(paramViewGroup.zKT.getResources().getColor(2131099676));
        break label277;
        label429:
        paramViewGroup.zLb.setVisibility(8);
        break label285;
        label441:
        paramViewGroup.zLd.setVisibility(8);
        paramViewGroup.zLa.setAlpha(1.0F);
        paramViewGroup.zKX.setAlpha(1.0F);
        paramViewGroup.zJl.setAlpha(1.0F);
        paramViewGroup.zKY.setAlpha(1.0F);
      }
    }
  }
  
  public final class b
  {
    public View jGG;
    public CdnImageView zJl;
    public WalletTextView zKX;
    public ImageView zKY;
    public LinearLayout zKZ;
    public TextView zLa;
    public TextView zLb;
    public TextView zLc;
    public TextView zLd;
    public LinearLayout zLe;
    
    public b(View paramView)
    {
      AppMethodBeat.i(68941);
      this.jGG = paramView;
      this.zKX = ((WalletTextView)paramView.findViewById(2131301601));
      this.zKY = ((ImageView)paramView.findViewById(2131301602));
      this.zLd = ((TextView)paramView.findViewById(2131301603));
      this.zLa = ((TextView)paramView.findViewById(2131301598));
      this.zLb = ((TextView)paramView.findViewById(2131301599));
      this.zLc = ((TextView)paramView.findViewById(2131301597));
      this.zLe = ((LinearLayout)paramView.findViewById(2131301596));
      this.zJl = ((CdnImageView)paramView.findViewById(2131301595));
      this.zKZ = ((LinearLayout)paramView.findViewById(2131301600));
      int i = com.tencent.mm.cd.a.fromDPToPix(WalletLqtPlanHomeUI.this.getContext(), 50);
      bt.n(this.zKY, i, i, i, i);
      AppMethodBeat.o(68941);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanHomeUI
 * JD-Core Version:    0.7.0.1
 */