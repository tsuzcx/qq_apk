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
import com.tencent.mm.plugin.wallet.balance.model.lqt.ab;
import com.tencent.mm.plugin.wallet.balance.model.lqt.ab.a;
import com.tencent.mm.plugin.wallet.balance.model.lqt.q;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.cmd;
import com.tencent.mm.protocal.protobuf.cpa;
import com.tencent.mm.protocal.protobuf.cre;
import com.tencent.mm.protocal.protobuf.dbs;
import com.tencent.mm.protocal.protobuf.dbt;
import com.tencent.mm.protocal.protobuf.ejl;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
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
  private RelativeLayout HAa;
  private LinearLayout HAb;
  private RelativeLayout HAc;
  private LinearLayout HAd;
  private TextView HAe;
  private ab HAf;
  private a HAg;
  private List<dbt> HAh;
  private dbs HAi;
  private ListView HzV;
  private TextView HzW;
  private TextView HzX;
  private LinearLayout HzY;
  private Button HzZ;
  private int requestCode;
  private ViewGroup ykw;
  
  public WalletLqtPlanHomeUI()
  {
    AppMethodBeat.i(68942);
    this.HAf = ((ab)aq(ab.class));
    this.HAg = new a((byte)0);
    this.HAh = new ArrayList();
    AppMethodBeat.o(68942);
  }
  
  private void aer(int paramInt)
  {
    AppMethodBeat.i(68947);
    Log.i("MicroMsg.WalletLqtPlanHomeUI", "go to add plan ui -> add");
    Intent localIntent = new Intent(this, WalletLqtPlanAddUI.class);
    localIntent.putExtra("key_mode", 1);
    startActivityForResult(localIntent, paramInt);
    AppMethodBeat.o(68947);
  }
  
  private void b(dbs paramdbs)
  {
    AppMethodBeat.i(68946);
    Log.i("MicroMsg.WalletLqtPlanHomeUI", "limit: %s", new Object[] { Long.valueOf(paramdbs.Hth) });
    this.ykw.setVisibility(0);
    if (paramdbs.Hth <= paramdbs.MGC.size())
    {
      this.ykw.findViewById(2131303904).setVisibility(8);
      TextView localTextView = (TextView)this.ykw.findViewById(2131303905);
      localTextView.setPadding(com.tencent.mm.cb.a.fromDPToPix(getContext(), 24), 0, 0, 0);
      localTextView.setText(paramdbs.Htk);
      localTextView.setTextColor(getContext().getResources().getColor(2131100594));
      this.ykw.setEnabled(false);
      AppMethodBeat.o(68946);
      return;
    }
    this.ykw.findViewById(2131303904).setVisibility(0);
    paramdbs = (TextView)this.ykw.findViewById(2131303905);
    paramdbs.setPadding(0, 0, 0, 0);
    paramdbs.setText(2131767817);
    paramdbs.setTextColor(getResources().getColor(2131100904));
    this.ykw.setEnabled(true);
    AppMethodBeat.o(68946);
  }
  
  private void c(final dbs paramdbs)
  {
    AppMethodBeat.i(68949);
    Log.d("MicroMsg.WalletLqtPlanHomeUI", "update view");
    if (paramdbs != null)
    {
      if ((paramdbs.MGC == null) || (paramdbs.MGC.isEmpty()))
      {
        Log.i("MicroMsg.WalletLqtPlanHomeUI", "show empty view");
        if (this.requestCode == 3)
        {
          fNO();
          this.HAh = paramdbs.MGC;
          this.HAg.notifyDataSetChanged();
          this.ykw.setVisibility(8);
          AppMethodBeat.o(68949);
          return;
        }
        finish();
        AppMethodBeat.o(68949);
        return;
      }
      if (Util.isNullOrNil(paramdbs.Htl)) {
        setMMTitle("");
      }
      for (;;)
      {
        setActionbarColor(getContext().getResources().getColor(2131099648));
        this.HAa.setVisibility(8);
        this.HzV.setVisibility(0);
        b(paramdbs);
        this.HAh = paramdbs.MGC;
        this.HAg.notifyDataSetChanged();
        if ((paramdbs.MGD == null) || (Util.isNullOrNil(paramdbs.MGD.title))) {
          break;
        }
        this.HAe.setText(paramdbs.MGD.title);
        this.HAb.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(68930);
            b localb = new b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtPlanHomeUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            Log.i("MicroMsg.WalletLqtPlanHomeUI", "click banner");
            f.p(WalletLqtPlanHomeUI.this.getContext(), paramdbs.MGD.url, true);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtPlanHomeUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(68930);
          }
        });
        this.HAb.setVisibility(0);
        AppMethodBeat.o(68949);
        return;
        setMMTitle(paramdbs.Htl);
      }
      this.HAb.setVisibility(8);
      AppMethodBeat.o(68949);
      return;
    }
    Log.i("MicroMsg.WalletLqtPlanHomeUI", "resp is null");
    finish();
    AppMethodBeat.o(68949);
  }
  
  private void fNO()
  {
    AppMethodBeat.i(68948);
    Log.i("MicroMsg.WalletLqtPlanHomeUI", "show null plan home ui");
    setMMTitle(getString(2131767937));
    this.HAc = ((RelativeLayout)findViewById(2131303988));
    this.HAc.setVisibility(0);
    this.HAd = ((LinearLayout)findViewById(2131303987));
    this.HAd.setOnClickListener(new WalletLqtPlanHomeUI.4(this));
    AppMethodBeat.o(68948);
  }
  
  private void fNP()
  {
    AppMethodBeat.i(68950);
    q localq = new q();
    localq.b(new CgiLqtPlanIndex());
    localq.a(new a.a() {}, 0L);
    AppMethodBeat.o(68950);
  }
  
  public int getLayoutId()
  {
    return 2131495343;
  }
  
  public void initView()
  {
    AppMethodBeat.i(68944);
    this.HzV = ((ListView)findViewById(2131303878));
    this.HzW = ((TextView)findViewById(2131303876));
    this.HzX = ((TextView)findViewById(2131303874));
    this.HzY = ((LinearLayout)findViewById(2131303877));
    this.HzZ = ((Button)findViewById(2131303873));
    this.HAa = ((RelativeLayout)findViewById(2131303875));
    this.HAb = ((LinearLayout)findViewById(2131303924));
    this.HAe = ((TextView)findViewById(2131303925));
    this.HAg = new a((byte)0);
    this.HzV.setAdapter(this.HAg);
    this.ykw = ((ViewGroup)LayoutInflater.from(this).inflate(2131495342, this.HzV, false));
    this.ykw.setOnClickListener(new WalletLqtPlanHomeUI.3(this));
    this.HzV.addFooterView(this.ykw);
    this.HzZ.setOnClickListener(new WalletLqtPlanHomeUI.1(this));
    this.HzV.setOnItemClickListener(new WalletLqtPlanHomeUI.2(this));
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
        final Dialog localDialog = h.c(getContext(), false, null);
        ab.a locala = this.HAf.Hul;
        com.tencent.mm.vending.g.g.h(Integer.valueOf(paramInt1), Integer.valueOf(j), str).c(locala).f(new com.tencent.mm.vending.c.a() {}).a(new d.a()
        {
          public final void cn(Object paramAnonymousObject)
          {
            AppMethodBeat.i(68933);
            localDialog.dismiss();
            if ((paramAnonymousObject instanceof m)) {
              ((m)paramAnonymousObject).G(WalletLqtPlanHomeUI.this.getContext(), false);
            }
            AppMethodBeat.o(68933);
          }
        });
        continue;
        if (paramInt2 == -1)
        {
          fNP();
          continue;
          if (paramInt2 == -1)
          {
            fNP();
            this.HAc.setVisibility(8);
            continue;
            if (paramInt2 == -1) {
              fNP();
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
    Log.i("MicroMsg.WalletLqtPlanHomeUI", "WalletLqtPlanHomeUI scene：%s", new Object[] { Integer.valueOf(i) });
    CgiLqtPlanIndex.PlanIndexParcel localPlanIndexParcel;
    switch (i)
    {
    default: 
      Log.i("MicroMsg.WalletLqtPlanHomeUI", "go to plan home ui");
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
      this.HAi = paramBundle;
      c(this.HAi);
      AppMethodBeat.o(68943);
      return;
      aer(65282);
      AppMethodBeat.o(68943);
      return;
      fNO();
      AppMethodBeat.o(68943);
      return;
      paramBundle = new dbs();
      paramBundle.pTZ = localPlanIndexParcel.pTZ;
      paramBundle.pUa = localPlanIndexParcel.pUa;
      Iterator localIterator1 = localPlanIndexParcel.Htg.iterator();
      while (localIterator1.hasNext())
      {
        CgiLqtPlanIndex.PlanItemParcel localPlanItemParcel = (CgiLqtPlanIndex.PlanItemParcel)localIterator1.next();
        dbt localdbt = new dbt();
        localdbt.grV = localPlanItemParcel.grV;
        localdbt.eht = localPlanItemParcel.eht;
        localdbt.dDj = localPlanItemParcel.dDj;
        localdbt.AOk = localPlanItemParcel.AOk;
        localdbt.Htm = localPlanItemParcel.Htm;
        localdbt.Htn = localPlanItemParcel.Htn;
        localdbt.Hts = localPlanItemParcel.Hts;
        localdbt.CiX = localPlanItemParcel.CiX;
        if (localPlanItemParcel.Hto != null)
        {
          localdbt.MGF = new ejl();
          localdbt.MGF.Htt = localPlanItemParcel.Hto.Htt;
          localdbt.MGF.ixw = localPlanItemParcel.Hto.ixw;
        }
        if (localPlanItemParcel.Htp != null)
        {
          localdbt.MGG = new cre();
          localdbt.MGG.title = localPlanItemParcel.Htp.title;
          localdbt.MGG.url = localPlanItemParcel.Htp.url;
        }
        if (localPlanItemParcel.Htq != null)
        {
          localdbt.MGH = new cpa();
          localdbt.MGH.Htd = localPlanItemParcel.Htq.Htd;
          localdbt.MGH.Hte = localPlanItemParcel.Htq.Hte;
          Iterator localIterator2 = localPlanItemParcel.Htq.Htf.iterator();
          while (localIterator2.hasNext())
          {
            Integer localInteger = (Integer)localIterator2.next();
            localdbt.MGH.Mvb.add(localInteger);
          }
        }
        localdbt.Htr = localPlanItemParcel.Htr;
        localdbt.state = localPlanItemParcel.state;
        localdbt.ynT = localPlanItemParcel.ynT;
        paramBundle.MGC.add(localdbt);
      }
      paramBundle.Hth = localPlanIndexParcel.Hth;
      paramBundle.Hti = localPlanIndexParcel.Hti;
      if (localPlanIndexParcel.Htj != null)
      {
        paramBundle.MGD = new jh();
        paramBundle.MGD.title = localPlanIndexParcel.Htj.title;
        paramBundle.MGD.url = localPlanIndexParcel.Htj.url;
      }
      paramBundle.Htk = localPlanIndexParcel.Htk;
      paramBundle.Htl = localPlanIndexParcel.Htl;
    }
    label662:
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
    
    private dbt aes(int paramInt)
    {
      AppMethodBeat.i(68937);
      dbt localdbt = (dbt)WalletLqtPlanHomeUI.d(WalletLqtPlanHomeUI.this).get(paramInt);
      AppMethodBeat.o(68937);
      return localdbt;
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
        localView = LayoutInflater.from(WalletLqtPlanHomeUI.this.getContext()).inflate(2131495341, paramViewGroup, false);
        localView.setTag(new WalletLqtPlanHomeUI.b(WalletLqtPlanHomeUI.this, localView));
      }
      paramView = aes(paramInt);
      paramViewGroup = (WalletLqtPlanHomeUI.b)localView.getTag();
      paramViewGroup.HAn.setPrefix(ah.hhz());
      Object localObject = f.b(paramView.eht, "100", 2, RoundingMode.HALF_UP);
      if (((BigDecimal)localObject).intValue() == ((BigDecimal)localObject).doubleValue())
      {
        paramViewGroup.HAn.setText(WalletLqtPlanHomeUI.aUP(((BigDecimal)localObject).intValue()));
        paramViewGroup.HAq.setText(String.format("%s %s(%s)", new Object[] { paramView.ynT, paramView.Hts, paramView.AOk }));
        localObject = u.a(new com.tencent.mm.plugin.wallet_core.ui.view.c(paramView.CiX));
        if (localObject != null) {
          paramViewGroup.HyB.setImageBitmap((Bitmap)localObject);
        }
        if ((paramView.MGF == null) || (Util.isNullOrNil(paramView.MGF.Htt))) {
          break label429;
        }
        paramViewGroup.HAr.setText(paramView.MGF.Htt);
        if (Util.isNullOrNil(paramView.MGF.ixw)) {
          break label406;
        }
        paramViewGroup.HAr.setTextColor(com.tencent.mm.plugin.wallet_core.utils.g.cI(paramView.MGF.ixw, true));
        label277:
        paramViewGroup.HAr.setVisibility(0);
        label285:
        paramViewGroup.HAu.setVisibility(8);
        paramViewGroup.HAs.setVisibility(8);
        if (paramView.MGG != null) {
          paramViewGroup.HAp.setOnClickListener(new WalletLqtPlanHomeUI.b.1(paramViewGroup, paramView));
        }
        if (paramView.state == 1) {
          break label441;
        }
        paramViewGroup.HAt.setVisibility(0);
        paramViewGroup.HAq.setAlpha(0.2F);
        paramViewGroup.HAn.setAlpha(0.2F);
        paramViewGroup.HyB.setAlpha(0.3F);
        paramViewGroup.HAo.setAlpha(1.0F);
      }
      for (;;)
      {
        AppMethodBeat.o(68938);
        return localView;
        paramViewGroup.HAn.setText(WalletLqtPlanHomeUI.aUP(((BigDecimal)localObject).toString()));
        break;
        label406:
        paramViewGroup.HAr.setTextColor(paramViewGroup.HAj.getResources().getColor(2131099683));
        break label277;
        label429:
        paramViewGroup.HAr.setVisibility(8);
        break label285;
        label441:
        paramViewGroup.HAt.setVisibility(8);
        paramViewGroup.HAq.setAlpha(1.0F);
        paramViewGroup.HAn.setAlpha(1.0F);
        paramViewGroup.HyB.setAlpha(1.0F);
        paramViewGroup.HAo.setAlpha(1.0F);
      }
    }
  }
  
  public final class b
  {
    public WalletTextView HAn;
    public ImageView HAo;
    public LinearLayout HAp;
    public TextView HAq;
    public TextView HAr;
    public TextView HAs;
    public TextView HAt;
    public LinearLayout HAu;
    public CdnImageView HyB;
    public View lJI;
    
    public b(View paramView)
    {
      AppMethodBeat.i(68941);
      this.lJI = paramView;
      this.HAn = ((WalletTextView)paramView.findViewById(2131303870));
      this.HAo = ((ImageView)paramView.findViewById(2131303871));
      this.HAt = ((TextView)paramView.findViewById(2131303872));
      this.HAq = ((TextView)paramView.findViewById(2131303867));
      this.HAr = ((TextView)paramView.findViewById(2131303868));
      this.HAs = ((TextView)paramView.findViewById(2131303866));
      this.HAu = ((LinearLayout)paramView.findViewById(2131303865));
      this.HyB = ((CdnImageView)paramView.findViewById(2131303864));
      this.HAp = ((LinearLayout)paramView.findViewById(2131303869));
      int i = com.tencent.mm.cb.a.fromDPToPix(WalletLqtPlanHomeUI.this.getContext(), 50);
      Util.expandViewTouchArea(this.HAo, i, i, i, i);
      AppMethodBeat.o(68941);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanHomeUI
 * JD-Core Version:    0.7.0.1
 */