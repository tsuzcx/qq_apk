package com.tencent.mm.plugin.product.ui;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.platformtools.r.a;
import com.tencent.mm.plugin.product.model.d;
import com.tencent.mm.plugin.product.model.j;
import com.tencent.mm.plugin.product.model.k;
import com.tencent.mm.plugin.product.model.l;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.aou;
import com.tencent.mm.protocal.protobuf.ee;
import com.tencent.mm.protocal.protobuf.ems;
import com.tencent.mm.protocal.protobuf.fdf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ListViewInScrollView;
import com.tencent.mm.ui.widget.a.e.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MallProductSubmitUI
  extends MallBaseUI
  implements r.a
{
  private d MQO;
  private ImageView MSR;
  private TextView MSS;
  private f MSY;
  private com.tencent.mm.plugin.product.model.b MSp;
  private RelativeLayout MTo;
  private TextView MTp;
  private TextView MTq;
  private MallProductItemView MTr;
  private MallProductItemView MTs;
  private TextView MTt;
  private TextView MTu;
  private TextView MTv;
  private TextView MTw;
  private ListView MTx;
  private a MTy;
  private Button qgp;
  private TextView sUt;
  
  private void updateView()
  {
    AppMethodBeat.i(67058);
    l locall = this.MSp.MQz;
    Object localObject1;
    label187:
    String str;
    if (this.MQO != null)
    {
      this.MSS.setText(com.tencent.mm.plugin.product.model.a.I(this.MQO.MQS, this.MQO.MQS, locall.MRd.MEq) + " x " + this.MSp.mCount);
      if (!Util.isNullOrNil(this.MSp.gAc()))
      {
        localObject1 = r.a(new c(this.MSp.gAc()));
        this.MSR.setImageBitmap((Bitmap)localObject1);
        r.a(this);
      }
      this.sUt.setText(locall.MRd.name);
      this.MTt.setText(this.MSp.gAd());
      localObject1 = this.MSp.gAg();
      if ((localObject1 == null) || (Util.isNullOrNil(((ems)localObject1).IIu))) {
        break label600;
      }
      this.MTs.setSummary(((ems)localObject1).IIu);
      str = "";
      localObject1 = str;
      if (!this.MSp.gAb().gAx())
      {
        localObject1 = this.MSp.MQE;
        if (localObject1 == null) {
          break label612;
        }
        this.MTr.setEnabled(true);
        this.MTr.setClickable(true);
        this.MTr.setSummary(com.tencent.mm.plugin.product.model.a.a(this, (aou)localObject1));
        localObject1 = getString(a.i.mall_product_submit_price_express, new Object[] { com.tencent.mm.plugin.product.model.a.d(((aou)localObject1).YYF, ((aou)localObject1).Zuw) });
        this.MTq.setVisibility(8);
      }
      label281:
      str = "";
      int i = this.MSp.gAf();
      if (i > 0)
      {
        Util.isNullOrNil((String)localObject1);
        str = getString(a.i.mall_product_submit_price_discount, new Object[] { com.tencent.mm.plugin.product.model.a.d(i, locall.MRd.MEq) });
      }
      Object localObject2 = this.MSp.bj(this);
      if ((localObject2 == null) || (((LinkedList)localObject2).size() <= 0)) {
        break label655;
      }
      this.MTx.setVisibility(0);
      this.MTy.js((List)localObject2);
      this.MTy.notifyDataSetChanged();
      label376:
      localObject2 = this.MSp.MQF;
      if (localObject2 != null) {
        this.MTp.setText(Html.fromHtml(String.format("%s %s<br><br>%s %s %s", new Object[] { ((ee)localObject2).UserName, ((ee)localObject2).YGl, ((ee)localObject2).pSg, ((ee)localObject2).pSh, ((ee)localObject2).IIu })));
      }
      localObject1 = (String)localObject1 + str;
      if (Util.isNullOrNil((String)localObject1)) {
        break label667;
      }
      localObject1 = getString(a.i.mall_product_submit_price_desc_more, new Object[] { localObject1 });
      this.MTu.setText((CharSequence)localObject1);
      this.MTv.setVisibility(8);
      this.MTu.setVisibility(0);
    }
    for (;;)
    {
      this.MTw.setText(com.tencent.mm.plugin.product.model.a.d(this.MSp.gAe(), locall.MRd.MEq));
      this.qgp.setEnabled(this.MSp.gAn());
      AppMethodBeat.o(67058);
      return;
      this.MSS.setText(com.tencent.mm.plugin.product.model.a.I(locall.MRd.MRn, locall.MRd.MRo, locall.MRd.MEq));
      break;
      label600:
      this.MTs.setSummary("");
      break label187;
      label612:
      this.MTr.setEnabled(false);
      this.MTr.setClickable(false);
      this.MTr.setSummary(getString(a.i.mall_product_submit_price_express_err));
      this.MTq.setVisibility(0);
      localObject1 = str;
      break label281;
      label655:
      this.MTx.setVisibility(8);
      break label376;
      label667:
      this.MTv.setVisibility(0);
      this.MTu.setVisibility(8);
    }
  }
  
  public int getLayoutId()
  {
    return a.g.product_submit_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(67057);
    setMMTitle(a.i.mall_product_submit_title);
    this.MTo = ((RelativeLayout)findViewById(a.f.mall_product_submit_address_rl));
    this.MTp = ((TextView)findViewById(a.f.mall_product_submit_address_summary_tv));
    this.MTq = ((TextView)findViewById(a.f.mall_product_submit_address_summary_err_tv));
    this.MTr = ((MallProductItemView)findViewById(a.f.mall_product_submit_express));
    this.MTs = ((MallProductItemView)findViewById(a.f.mall_product_submit_invoice));
    this.MSR = ((ImageView)findViewById(a.f.mall_product_submit_img_iv));
    this.sUt = ((TextView)findViewById(a.f.mall_product_submit_title_tv));
    this.MTt = ((TextView)findViewById(a.f.mall_product_submit_list_tv));
    this.MSS = ((TextView)findViewById(a.f.mall_product_submit_price_tv));
    this.MTu = ((TextView)findViewById(a.f.mall_product_submit_price_desc_tv));
    this.MTv = ((TextView)findViewById(a.f.mall_product_submit_price_desc_left_tv));
    this.MTw = ((TextView)findViewById(a.f.mall_product_submit_total_price_tv));
    this.MTx = ((ListView)findViewById(a.f.mall_product_submit_preferential_lv));
    this.MTy = new a(this);
    this.MTx.setAdapter(this.MTy);
    this.MTx.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(67047);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).sc(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).hB(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/product/ui/MallProductSubmitUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
        paramAnonymousAdapterView = (b)paramAnonymousView.getTag();
        switch (paramAnonymousAdapterView.type)
        {
        }
        for (;;)
        {
          MallProductSubmitUI.c(MallProductSubmitUI.this).a(MallProductSubmitUI.this, paramAnonymousView, paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/product/ui/MallProductSubmitUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(67047);
          return;
          Object localObject2 = MallProductSubmitUI.b(MallProductSubmitUI.this).MQz;
          if ((((l)localObject2).MRd.MRp != null) && (((l)localObject2).MRd.MRp.size() > 0))
          {
            localObject1 = new ArrayList();
            localObject2 = ((l)localObject2).MRd.MRp.iterator();
            while (((Iterator)localObject2).hasNext()) {
              ((ArrayList)localObject1).add((String)((Iterator)localObject2).next());
            }
            paramAnonymousAdapterView.aeq = localObject1;
            continue;
            if ((paramAnonymousAdapterView.aeq instanceof String)) {
              MallProductSubmitUI.b(MallProductSubmitUI.this).MQI = ((String)paramAnonymousAdapterView.aeq);
            }
          }
        }
      }
    });
    this.qgp = ((Button)findViewById(a.f.mall_product_submit_submit));
    this.qgp.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67048);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/product/ui/MallProductSubmitUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        paramAnonymousView = MallProductSubmitUI.d(MallProductSubmitUI.this);
        int i;
        if (paramAnonymousView.MSp.gAn())
        {
          if (paramAnonymousView.MSp.gAe() != 0) {
            break label129;
          }
          i = 1;
          if (i == 0) {
            break label134;
          }
          h.baF();
          localObject = h.baD().mCm;
          fdf localfdf = paramAnonymousView.MSp.gAp();
          paramAnonymousView.MSp.getAppId();
          ((s)localObject).a(new j(localfdf), 0);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/product/ui/MallProductSubmitUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(67048);
          return;
          label129:
          i = 0;
          break;
          label134:
          h.baF();
          h.baD().mCm.a(new k(paramAnonymousView.MSp.gAp(), paramAnonymousView.MSp.getAppId()), 0);
        }
      }
    });
    this.MTo.setOnClickListener(new MallProductSubmitUI.4(this));
    this.MTr.setOnClickListener(new MallProductSubmitUI.5(this));
    this.MTs.setOnClickListener(new MallProductSubmitUI.6(this));
    MallProductItemView localMallProductItemView = this.MTs;
    boolean bool;
    if ((this.MSp.gAb().MSm & 0x2) > 0)
    {
      bool = true;
      Log.d("MicroMsg.MallProductConfig", "hasReceipt, ret = ".concat(String.valueOf(bool)));
      if (!bool) {
        break label411;
      }
    }
    label411:
    for (int i = 0;; i = 8)
    {
      localMallProductItemView.setVisibility(i);
      if (this.MSp.gAb().gAx())
      {
        this.MTr.setEnabled(false);
        this.MTr.setClickable(false);
        this.MTr.setSummary(getString(a.i.mall_product_submit_price_express_free));
      }
      AppMethodBeat.o(67057);
      return;
      bool = false;
      break;
    }
  }
  
  public final void k(String paramString, final Bitmap paramBitmap)
  {
    AppMethodBeat.i(67060);
    paramString = new StringBuilder().append(paramString).append(", bitmap = ");
    if (paramBitmap == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.MallProductSubmitUI", bool);
      if (!Util.isNullOrNil(this.MSp.gAc())) {
        break;
      }
      AppMethodBeat.o(67060);
      return;
    }
    this.MSR.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(67052);
        MallProductSubmitUI.e(MallProductSubmitUI.this).setImageBitmap(paramBitmap);
        AppMethodBeat.o(67052);
      }
    });
    AppMethodBeat.o(67060);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(67059);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.MSY.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(67059);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(67054);
    super.onCreate(paramBundle);
    this.MSY = new f(getContext(), new f.a()
    {
      public final void J(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString)
      {
        AppMethodBeat.i(67046);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          MallProductSubmitUI.a(MallProductSubmitUI.this);
          AppMethodBeat.o(67046);
          return;
        }
        MallProductSubmitUI.this.aRO(paramAnonymousString);
        AppMethodBeat.o(67046);
      }
    });
    com.tencent.mm.plugin.product.a.a.gzY();
    this.MSp = com.tencent.mm.plugin.product.a.a.gzZ();
    this.MQO = this.MSp.MQO;
    initView();
    updateView();
    AppMethodBeat.o(67054);
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    AppMethodBeat.i(67061);
    switch (paramInt)
    {
    }
    do
    {
      localObject1 = super.onCreateDialog(paramInt);
      AppMethodBeat.o(67061);
      return localObject1;
      localObject2 = this.MSp.MQM;
    } while (localObject2 == null);
    Object localObject1 = new ArrayList();
    Object localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((List)localObject1).add(com.tencent.mm.plugin.product.model.a.a(this, (aou)((Iterator)localObject2).next()));
    }
    localObject2 = getString(a.i.mall_product_submit_express);
    AdapterView.OnItemClickListener local8 = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(67053);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousAdapterView);
        localb.cH(paramAnonymousView);
        localb.sc(paramAnonymousInt);
        localb.hB(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/product/ui/MallProductSubmitUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
        MallProductSubmitUI.this.dismissDialog(1);
        MallProductSubmitUI.b(MallProductSubmitUI.this).afy(paramAnonymousInt);
        MallProductSubmitUI.a(MallProductSubmitUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/product/ui/MallProductSubmitUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(67053);
      }
    };
    d.a locala = new d.a(this);
    ListViewInScrollView localListViewInScrollView = (ListViewInScrollView)View.inflate(this, a.g.mm_list, null);
    localListViewInScrollView.setOnItemClickListener(new d.1(local8, locala));
    locala.MSh = ((List)localObject1);
    locala.MSi = 0;
    localListViewInScrollView.setAdapter(locala);
    localObject1 = new e.a(this);
    ((e.a)localObject1).bDv((String)localObject2);
    ((e.a)localObject1).md(localListViewInScrollView);
    ((e.a)localObject1).e(null);
    localObject1 = ((e.a)localObject1).jHH();
    ((com.tencent.mm.ui.widget.a.e)localObject1).show();
    AppMethodBeat.o(67061);
    return localObject1;
  }
  
  public void onStart()
  {
    AppMethodBeat.i(67055);
    this.MSY.onStart();
    super.onStart();
    AppMethodBeat.o(67055);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(67056);
    this.MSY.onStop();
    super.onStop();
    AppMethodBeat.o(67056);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductSubmitUI
 * JD-Core Version:    0.7.0.1
 */