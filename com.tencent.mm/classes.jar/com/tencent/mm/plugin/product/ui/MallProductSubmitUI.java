package com.tencent.mm.plugin.product.ui;

import android.app.Activity;
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
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.product.b.k;
import com.tencent.mm.plugin.product.b.l;
import com.tencent.mm.plugin.product.b.m;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.alj;
import com.tencent.mm.protocal.protobuf.dp;
import com.tencent.mm.protocal.protobuf.dtx;
import com.tencent.mm.protocal.protobuf.eiy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ListViewInScrollView;
import com.tencent.mm.ui.widget.a.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MallProductSubmitUI
  extends MallBaseUI
  implements u.a
{
  private com.tencent.mm.plugin.product.b.e GTk;
  private com.tencent.mm.plugin.product.b.c GUN;
  private RelativeLayout GVM;
  private TextView GVN;
  private TextView GVO;
  private MallProductItemView GVP;
  private MallProductItemView GVQ;
  private TextView GVR;
  private TextView GVS;
  private TextView GVT;
  private TextView GVU;
  private ListView GVV;
  private a GVW;
  private ImageView GVp;
  private TextView GVq;
  private f GVw;
  private Button njb;
  private TextView pPT;
  
  private void updateView()
  {
    AppMethodBeat.i(67058);
    m localm = this.GUN.GSV;
    Object localObject1;
    label187:
    String str;
    if (this.GTk != null)
    {
      this.GVq.setText(com.tencent.mm.plugin.product.b.b.E(this.GTk.GTo, this.GTk.GTo, localm.GTz.GHz) + " x " + this.GUN.mCount);
      if (!Util.isNullOrNil(this.GUN.foY()))
      {
        localObject1 = u.a(new c(this.GUN.foY()));
        this.GVp.setImageBitmap((Bitmap)localObject1);
        u.a(this);
      }
      this.pPT.setText(localm.GTz.name);
      this.GVR.setText(this.GUN.foZ());
      localObject1 = this.GUN.fpc();
      if ((localObject1 == null) || (Util.isNullOrNil(((dtx)localObject1).COk))) {
        break label595;
      }
      this.GVQ.setSummary(((dtx)localObject1).COk);
      str = "";
      localObject1 = str;
      if (!this.GUN.foX().fpt())
      {
        localObject1 = this.GUN.GTa;
        if (localObject1 == null) {
          break label607;
        }
        this.GVP.setEnabled(true);
        this.GVP.setClickable(true);
        this.GVP.setSummary(com.tencent.mm.plugin.product.b.b.a(this, (alj)localObject1));
        localObject1 = getString(a.i.mall_product_submit_price_express, new Object[] { com.tencent.mm.plugin.product.b.b.c(((alj)localObject1).SaG, ((alj)localObject1).SuH) });
        this.GVO.setVisibility(8);
      }
      label281:
      str = "";
      int i = this.GUN.fpb();
      if (i > 0)
      {
        Util.isNullOrNil((String)localObject1);
        str = getString(a.i.mall_product_submit_price_discount, new Object[] { com.tencent.mm.plugin.product.b.b.c(i, localm.GTz.GHz) });
      }
      Object localObject2 = this.GUN.aH(this);
      if (((LinkedList)localObject2).size() <= 0) {
        break label650;
      }
      this.GVV.setVisibility(0);
      this.GVW.gs((List)localObject2);
      this.GVW.notifyDataSetChanged();
      label371:
      localObject2 = this.GUN.GTb;
      if (localObject2 != null) {
        this.GVN.setText(Html.fromHtml(String.format("%s %s<br><br>%s %s %s", new Object[] { ((dp)localObject2).UserName, ((dp)localObject2).RIX, ((dp)localObject2).mVz, ((dp)localObject2).mVA, ((dp)localObject2).COk })));
      }
      localObject1 = (String)localObject1 + str;
      if (Util.isNullOrNil((String)localObject1)) {
        break label662;
      }
      localObject1 = getString(a.i.mall_product_submit_price_desc_more, new Object[] { localObject1 });
      this.GVS.setText((CharSequence)localObject1);
      this.GVT.setVisibility(8);
      this.GVS.setVisibility(0);
    }
    for (;;)
    {
      this.GVU.setText(com.tencent.mm.plugin.product.b.b.c(this.GUN.fpa(), localm.GTz.GHz));
      this.njb.setEnabled(this.GUN.fpj());
      AppMethodBeat.o(67058);
      return;
      this.GVq.setText(com.tencent.mm.plugin.product.b.b.E(localm.GTz.GTK, localm.GTz.GTL, localm.GTz.GHz));
      break;
      label595:
      this.GVQ.setSummary("");
      break label187;
      label607:
      this.GVP.setEnabled(false);
      this.GVP.setClickable(false);
      this.GVP.setSummary(getString(a.i.mall_product_submit_price_express_err));
      this.GVO.setVisibility(0);
      localObject1 = str;
      break label281;
      label650:
      this.GVV.setVisibility(8);
      break label371;
      label662:
      this.GVT.setVisibility(0);
      this.GVS.setVisibility(8);
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
    this.GVM = ((RelativeLayout)findViewById(a.f.mall_product_submit_address_rl));
    this.GVN = ((TextView)findViewById(a.f.mall_product_submit_address_summary_tv));
    this.GVO = ((TextView)findViewById(a.f.mall_product_submit_address_summary_err_tv));
    this.GVP = ((MallProductItemView)findViewById(a.f.mall_product_submit_express));
    this.GVQ = ((MallProductItemView)findViewById(a.f.mall_product_submit_invoice));
    this.GVp = ((ImageView)findViewById(a.f.mall_product_submit_img_iv));
    this.pPT = ((TextView)findViewById(a.f.mall_product_submit_title_tv));
    this.GVR = ((TextView)findViewById(a.f.mall_product_submit_list_tv));
    this.GVq = ((TextView)findViewById(a.f.mall_product_submit_price_tv));
    this.GVS = ((TextView)findViewById(a.f.mall_product_submit_price_desc_tv));
    this.GVT = ((TextView)findViewById(a.f.mall_product_submit_price_desc_left_tv));
    this.GVU = ((TextView)findViewById(a.f.mall_product_submit_total_price_tv));
    this.GVV = ((ListView)findViewById(a.f.mall_product_submit_preferential_lv));
    this.GVW = new a(this);
    this.GVV.setAdapter(this.GVW);
    this.GVV.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(67047);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).sg(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).Fs(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/product/ui/MallProductSubmitUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
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
          Object localObject2 = MallProductSubmitUI.b(MallProductSubmitUI.this).GSV;
          if ((((m)localObject2).GTz.GTM != null) && (((m)localObject2).GTz.GTM.size() > 0))
          {
            localObject1 = new ArrayList();
            localObject2 = ((m)localObject2).GTz.GTM.iterator();
            while (((Iterator)localObject2).hasNext()) {
              ((ArrayList)localObject1).add((String)((Iterator)localObject2).next());
            }
            paramAnonymousAdapterView.GUv = localObject1;
            continue;
            if ((paramAnonymousAdapterView.GUv instanceof String)) {
              MallProductSubmitUI.b(MallProductSubmitUI.this).GTe = ((String)paramAnonymousAdapterView.GUv);
            }
          }
        }
      }
    });
    this.njb = ((Button)findViewById(a.f.mall_product_submit_submit));
    this.njb.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67048);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/product/ui/MallProductSubmitUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        paramAnonymousView = MallProductSubmitUI.d(MallProductSubmitUI.this);
        int i;
        if (paramAnonymousView.GUN.fpj())
        {
          if (paramAnonymousView.GUN.fpa() != 0) {
            break label129;
          }
          i = 1;
          if (i == 0) {
            break label134;
          }
          h.aHH();
          localObject = h.aHF().kcd;
          eiy localeiy = paramAnonymousView.GUN.fpl();
          paramAnonymousView.GUN.getAppId();
          ((t)localObject).a(new k(localeiy), 0);
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
          h.aHH();
          h.aHF().kcd.a(new l(paramAnonymousView.GUN.fpl(), paramAnonymousView.GUN.getAppId()), 0);
        }
      }
    });
    this.GVM.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67049);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/product/ui/MallProductSubmitUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        paramAnonymousView = MallProductSubmitUI.d(MallProductSubmitUI.this);
        localObject = new Intent();
        ((Intent)localObject).putExtra("launch_from_webview", true);
        com.tencent.mm.by.c.a(paramAnonymousView.mContext, "address", ".ui.WalletSelectAddrUI", (Intent)localObject, 1, false);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/product/ui/MallProductSubmitUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(67049);
      }
    });
    this.GVP.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67050);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/product/ui/MallProductSubmitUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        MallProductSubmitUI.this.showDialog(1);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/product/ui/MallProductSubmitUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(67050);
      }
    });
    this.GVQ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67051);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/product/ui/MallProductSubmitUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        paramAnonymousView = MallProductSubmitUI.d(MallProductSubmitUI.this);
        localObject = new Intent(paramAnonymousView.mContext, MallProductReceiptUI.class);
        paramAnonymousView.mContext.startActivityForResult((Intent)localObject, 4);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/product/ui/MallProductSubmitUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(67051);
      }
    });
    MallProductItemView localMallProductItemView = this.GVQ;
    boolean bool;
    if ((this.GUN.foX().GUK & 0x2) > 0)
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
      if (this.GUN.foX().fpt())
      {
        this.GVP.setEnabled(false);
        this.GVP.setClickable(false);
        this.GVP.setSummary(getString(a.i.mall_product_submit_price_express_free));
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
      if (!Util.isNullOrNil(this.GUN.foY())) {
        break;
      }
      AppMethodBeat.o(67060);
      return;
    }
    this.GVp.post(new Runnable()
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
    this.GVw.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(67059);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(67054);
    super.onCreate(paramBundle);
    this.GVw = new f(getContext(), new f.a()
    {
      public final void F(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString)
      {
        AppMethodBeat.i(67046);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          MallProductSubmitUI.a(MallProductSubmitUI.this);
          AppMethodBeat.o(67046);
          return;
        }
        MallProductSubmitUI.this.aUG(paramAnonymousString);
        AppMethodBeat.o(67046);
      }
    });
    com.tencent.mm.plugin.product.a.a.foU();
    this.GUN = com.tencent.mm.plugin.product.a.a.foV();
    this.GTk = this.GUN.GTk;
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
      localObject2 = this.GUN.GTi;
    } while (localObject2 == null);
    Object localObject1 = new ArrayList();
    Object localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((List)localObject1).add(com.tencent.mm.plugin.product.b.b.a(this, (alj)((Iterator)localObject2).next()));
    }
    localObject2 = getString(a.i.mall_product_submit_express);
    AdapterView.OnItemClickListener local8 = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(67053);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousAdapterView);
        localb.bn(paramAnonymousView);
        localb.sg(paramAnonymousInt);
        localb.Fs(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/product/ui/MallProductSubmitUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
        MallProductSubmitUI.this.dismissDialog(1);
        MallProductSubmitUI.b(MallProductSubmitUI.this).abf(paramAnonymousInt);
        MallProductSubmitUI.a(MallProductSubmitUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/product/ui/MallProductSubmitUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(67053);
      }
    };
    d.a locala = new d.a(this);
    ListViewInScrollView localListViewInScrollView = (ListViewInScrollView)View.inflate(this, a.g.mm_list, null);
    localListViewInScrollView.setOnItemClickListener(new d.1(local8, locala));
    locala.GUF = ((List)localObject1);
    locala.GUG = 0;
    localListViewInScrollView.setAdapter(locala);
    localObject1 = new com.tencent.mm.ui.widget.a.d.a(this);
    ((com.tencent.mm.ui.widget.a.d.a)localObject1).bBc((String)localObject2);
    ((com.tencent.mm.ui.widget.a.d.a)localObject1).iI(localListViewInScrollView);
    ((com.tencent.mm.ui.widget.a.d.a)localObject1).f(null);
    localObject1 = ((com.tencent.mm.ui.widget.a.d.a)localObject1).icu();
    ((d)localObject1).show();
    AppMethodBeat.o(67061);
    return localObject1;
  }
  
  public void onStart()
  {
    AppMethodBeat.i(67055);
    this.GVw.onStart();
    super.onStart();
    AppMethodBeat.o(67055);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(67056);
    this.GVw.onStop();
    super.onStop();
    AppMethodBeat.o(67056);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductSubmitUI
 * JD-Core Version:    0.7.0.1
 */