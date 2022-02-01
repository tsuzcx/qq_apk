package com.tencent.mm.plugin.product.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.platformtools.r.a;
import com.tencent.mm.plugin.product.b.m;
import com.tencent.mm.plugin.product.model.d;
import com.tencent.mm.plugin.product.model.l;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.aa;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class MallProductSelectSkuUI
  extends MallBaseUI
  implements r.a
{
  private d MQO;
  private l MQz;
  private ImageView MSR;
  private TextView MSS;
  private TextView MST;
  private Button MSU;
  private ListView MSV;
  private MallProductSelectAmountView MSW = null;
  private i MSX = null;
  private f MSY;
  private com.tencent.mm.plugin.product.model.b MSp;
  private TextView sUt;
  
  private void updateView()
  {
    AppMethodBeat.i(67022);
    if (this.MQz != null)
    {
      if ((this.MQO == null) || (this.MQz.MRd == null)) {
        break label180;
      }
      this.MSS.setText(com.tencent.mm.plugin.product.model.a.I(this.MQO.MQS, this.MQO.MQT, this.MQz.MRd.MEq));
    }
    for (;;)
    {
      if (this.MQz.MRd != null) {
        this.sUt.setText(this.MQz.MRd.name);
      }
      if (!Util.isNullOrNil(this.MSp.gAc()))
      {
        Bitmap localBitmap = r.a(new c(this.MSp.gAc()));
        this.MSR.setImageBitmap(localBitmap);
        r.a(this);
      }
      this.MST.setVisibility(8);
      this.MSW.ky(this.MSp.gAk(), this.MSp.MQz.MRc);
      this.MSX.notifyDataSetChanged();
      AppMethodBeat.o(67022);
      return;
      label180:
      this.MSS.setText(com.tencent.mm.plugin.product.model.a.I(this.MQz.MRd.MRn, this.MQz.MRd.MRo, this.MQz.MRd.MEq));
    }
  }
  
  public int getLayoutId()
  {
    return a.g.product_select_sku_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(67021);
    setMMTitle(a.i.mall_product_select_sku_title);
    this.MSR = ((ImageView)findViewById(a.f.mall_product_select_sku_img_iv));
    this.sUt = ((TextView)findViewById(a.f.mall_product_select_sku_title_tv));
    this.MSS = ((TextView)findViewById(a.f.mall_product_select_sku_price_tv));
    this.MST = ((TextView)findViewById(a.f.mall_product_select_sku_err));
    this.MSU = ((Button)findViewById(a.f.mall_product_select_sku_pre_submit));
    this.MSV = ((ListView)findViewById(a.f.mall_product_sku_lv));
    this.MSW = ((MallProductSelectAmountView)findViewById(a.f.select_amount));
    this.MSW.setAmount(this.MSp.mCount);
    this.MSX = new i(this);
    if ((this.MQz != null) && (this.MQz.MRd != null) && (this.MQz.MRd.MRv != null)) {
      this.MSX.MTa = this.MQz.MRd.MRv;
    }
    for (;;)
    {
      this.MSX.MTb = new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          Object localObject1 = null;
          AppMethodBeat.i(67013);
          Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramAnonymousAdapterView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramAnonymousView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject2).sc(paramAnonymousInt);
          ((com.tencent.mm.hellhoundlib.b.b)localObject2).hB(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/product/ui/MallProductSelectSkuUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
          Object localObject3 = (Pair)paramAnonymousView.getTag();
          paramAnonymousView = MallProductSelectSkuUI.this;
          localObject2 = MallProductSelectSkuUI.b(MallProductSelectSkuUI.this);
          paramAnonymousAdapterView = (String)((Pair)localObject3).first;
          localObject3 = (String)((Pair)localObject3).second;
          Log.d("MicroMsg.MallProductManager", "selectSkuInfo (" + paramAnonymousAdapterView + " , " + (String)localObject3 + ")");
          if ((((com.tencent.mm.plugin.product.model.b)localObject2).MQL.containsKey(paramAnonymousAdapterView)) && (((String)((com.tencent.mm.plugin.product.model.b)localObject2).MQL.get(paramAnonymousAdapterView)).equals(localObject3)))
          {
            ((com.tencent.mm.plugin.product.model.b)localObject2).MQL.remove(paramAnonymousAdapterView);
            ((com.tencent.mm.plugin.product.model.b)localObject2).MQD = com.tencent.mm.plugin.product.model.b.aP(((com.tencent.mm.plugin.product.model.b)localObject2).MQL);
            if (((com.tencent.mm.plugin.product.model.b)localObject2).MQK != null) {
              paramAnonymousAdapterView = (d)((com.tencent.mm.plugin.product.model.b)localObject2).MQK.get(((com.tencent.mm.plugin.product.model.b)localObject2).MQD);
            }
          }
          for (((com.tencent.mm.plugin.product.model.b)localObject2).MQO = paramAnonymousAdapterView;; ((com.tencent.mm.plugin.product.model.b)localObject2).MQO = ((d)((com.tencent.mm.plugin.product.model.b)localObject2).MQK.get(((com.tencent.mm.plugin.product.model.b)localObject2).MQD)))
          {
            ((com.tencent.mm.plugin.product.model.b)localObject2).gAq();
            paramAnonymousAdapterView = ((com.tencent.mm.plugin.product.model.b)localObject2).MQO;
            do
            {
              MallProductSelectSkuUI.a(paramAnonymousView, paramAnonymousAdapterView);
              MallProductSelectSkuUI.a(MallProductSelectSkuUI.this);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/product/ui/MallProductSelectSkuUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(67013);
              return;
              paramAnonymousAdapterView = null;
              break;
              ((com.tencent.mm.plugin.product.model.b)localObject2).MQL.put(paramAnonymousAdapterView, localObject3);
              ((com.tencent.mm.plugin.product.model.b)localObject2).MQD = com.tencent.mm.plugin.product.model.b.aP(((com.tencent.mm.plugin.product.model.b)localObject2).MQL);
              Log.d("MicroMsg.MallProductManager", "getSkuInfoId (" + ((com.tencent.mm.plugin.product.model.b)localObject2).MQD + ")");
              paramAnonymousAdapterView = localObject1;
            } while (((com.tencent.mm.plugin.product.model.b)localObject2).MQK == null);
          }
        }
      };
      this.MSV.setAdapter(this.MSX);
      this.MSW.setOnAmountChangeListener(new MallProductSelectAmountView.a()
      {
        public final void kz(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(67015);
          switch (paramAnonymousInt2)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(67015);
            return;
            MallProductSelectSkuUI.c(MallProductSelectSkuUI.this).setText(a.i.mall_product_select_sku_amount_err);
            MallProductSelectSkuUI.c(MallProductSelectSkuUI.this).setVisibility(0);
            AppMethodBeat.o(67015);
            return;
            MallProductSelectSkuUI.c(MallProductSelectSkuUI.this).setText(MallProductSelectSkuUI.this.getString(a.i.mall_product_select_sku_amount_limit_err, new Object[] { Integer.valueOf(paramAnonymousInt1) }));
            MallProductSelectSkuUI.c(MallProductSelectSkuUI.this).setVisibility(0);
          }
        }
        
        public final void onChange(int paramAnonymousInt)
        {
          AppMethodBeat.i(67014);
          MallProductSelectSkuUI.b(MallProductSelectSkuUI.this).mCount = paramAnonymousInt;
          MallProductSelectSkuUI.c(MallProductSelectSkuUI.this).setVisibility(8);
          AppMethodBeat.o(67014);
        }
      });
      this.MSU.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67016);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/product/ui/MallProductSelectSkuUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          localObject = MallProductSelectSkuUI.d(MallProductSelectSkuUI.this);
          if (((f)localObject).MSn) {
            aa.makeText(((f)localObject).mContext, a.i.mall_product_data_loading, 1).show();
          }
          label285:
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/product/ui/MallProductSelectSkuUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(67016);
            return;
            if (((f)localObject).MSp.gAm())
            {
              if (((f)localObject).MSp.MQF != null)
              {
                h.baF();
                h.baD().mCm.a(new com.tencent.mm.plugin.product.model.i(((f)localObject).MSp.gAo(), f.mScene), 0);
              }
              else
              {
                com.tencent.mm.br.c.g(((f)localObject).mContext, "address", ".ui.WalletAddAddressUI", 2);
              }
            }
            else
            {
              paramAnonymousView = ((f)localObject).MSp;
              m localm;
              if ((paramAnonymousView.MQL != null) && (paramAnonymousView.MQL.size() < paramAnonymousView.MQJ) && (paramAnonymousView.MQJ > 0))
              {
                Iterator localIterator = paramAnonymousView.MQz.MRd.MRv.iterator();
                do
                {
                  if (!localIterator.hasNext()) {
                    break;
                  }
                  localm = (m)localIterator.next();
                } while (paramAnonymousView.MQL.containsKey(localm.MRF));
              }
              for (paramAnonymousView = localm.MRG;; paramAnonymousView = null)
              {
                if (Util.isNullOrNil(paramAnonymousView)) {
                  break label285;
                }
                aa.makeText(((f)localObject).mContext, ((f)localObject).mContext.getString(a.i.mall_product_select_sku_err, new Object[] { paramAnonymousView }), 0).show();
                break;
              }
            }
          }
        }
      });
      this.MSR.setFocusable(true);
      this.MSR.setFocusableInTouchMode(true);
      this.MSR.requestFocus();
      AppMethodBeat.o(67021);
      return;
      Log.e("MicroMsg.MallProductSelectSkuUI", "Illage mProductInfo.base_attr.sku_table");
    }
  }
  
  public final void k(String paramString, final Bitmap paramBitmap)
  {
    AppMethodBeat.i(67024);
    paramString = new StringBuilder().append(paramString).append(", bitmap = ");
    if (paramBitmap == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.MallProductSelectSkuUI", bool);
      if (!Util.isNullOrNil(this.MSp.gAc())) {
        break;
      }
      AppMethodBeat.o(67024);
      return;
    }
    this.MSR.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(67017);
        MallProductSelectSkuUI.e(MallProductSelectSkuUI.this).setImageBitmap(paramBitmap);
        AppMethodBeat.o(67017);
      }
    });
    AppMethodBeat.o(67024);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(67023);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.MSY.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(67023);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(67018);
    super.onCreate(paramBundle);
    this.MSY = new f(getContext(), new f.a()
    {
      public final void J(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString)
      {
        AppMethodBeat.i(67012);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          MallProductSelectSkuUI.a(MallProductSelectSkuUI.this);
          AppMethodBeat.o(67012);
          return;
        }
        MallProductSelectSkuUI.this.aRO(paramAnonymousString);
        AppMethodBeat.o(67012);
      }
    });
    com.tencent.mm.plugin.product.a.a.gzY();
    this.MSp = com.tencent.mm.plugin.product.a.a.gzZ();
    this.MQz = this.MSp.MQz;
    initView();
    updateView();
    AppMethodBeat.o(67018);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(67019);
    this.MSY.onStart();
    super.onStart();
    AppMethodBeat.o(67019);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(67020);
    this.MSY.onStop();
    super.onStop();
    AppMethodBeat.o(67020);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductSelectSkuUI
 * JD-Core Version:    0.7.0.1
 */