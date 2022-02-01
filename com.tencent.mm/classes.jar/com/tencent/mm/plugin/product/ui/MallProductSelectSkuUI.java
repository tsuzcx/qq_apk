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
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.product.b.e;
import com.tencent.mm.plugin.product.b.j;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.w;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class MallProductSelectSkuUI
  extends MallBaseUI
  implements u.a
{
  private com.tencent.mm.plugin.product.b.m GSV;
  private e GTk;
  private com.tencent.mm.plugin.product.b.c GUN;
  private ImageView GVp;
  private TextView GVq;
  private TextView GVr;
  private Button GVs;
  private ListView GVt;
  private MallProductSelectAmountView GVu = null;
  private i GVv = null;
  private f GVw;
  private TextView pPT;
  
  private void updateView()
  {
    AppMethodBeat.i(67022);
    if (this.GSV != null)
    {
      if ((this.GTk == null) || (this.GSV.GTz == null)) {
        break label180;
      }
      this.GVq.setText(com.tencent.mm.plugin.product.b.b.E(this.GTk.GTo, this.GTk.GTp, this.GSV.GTz.GHz));
    }
    for (;;)
    {
      if (this.GSV.GTz != null) {
        this.pPT.setText(this.GSV.GTz.name);
      }
      if (!Util.isNullOrNil(this.GUN.foY()))
      {
        Bitmap localBitmap = u.a(new c(this.GUN.foY()));
        this.GVp.setImageBitmap(localBitmap);
        u.a(this);
      }
      this.GVr.setVisibility(8);
      this.GVu.iS(this.GUN.fpg(), this.GUN.GSV.GTy);
      this.GVv.notifyDataSetChanged();
      AppMethodBeat.o(67022);
      return;
      label180:
      this.GVq.setText(com.tencent.mm.plugin.product.b.b.E(this.GSV.GTz.GTK, this.GSV.GTz.GTL, this.GSV.GTz.GHz));
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
    this.GVp = ((ImageView)findViewById(a.f.mall_product_select_sku_img_iv));
    this.pPT = ((TextView)findViewById(a.f.mall_product_select_sku_title_tv));
    this.GVq = ((TextView)findViewById(a.f.mall_product_select_sku_price_tv));
    this.GVr = ((TextView)findViewById(a.f.mall_product_select_sku_err));
    this.GVs = ((Button)findViewById(a.f.mall_product_select_sku_pre_submit));
    this.GVt = ((ListView)findViewById(a.f.mall_product_sku_lv));
    this.GVu = ((MallProductSelectAmountView)findViewById(a.f.select_amount));
    this.GVu.setAmount(this.GUN.mCount);
    this.GVv = new i(this);
    if ((this.GSV != null) && (this.GSV.GTz != null) && (this.GSV.GTz.GTS != null)) {
      this.GVv.GVy = this.GSV.GTz.GTS;
    }
    for (;;)
    {
      this.GVv.GVz = new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          Object localObject1 = null;
          AppMethodBeat.i(67013);
          Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject2).bn(paramAnonymousAdapterView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject2).bn(paramAnonymousView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject2).sg(paramAnonymousInt);
          ((com.tencent.mm.hellhoundlib.b.b)localObject2).Fs(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/product/ui/MallProductSelectSkuUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aFi());
          Object localObject3 = (Pair)paramAnonymousView.getTag();
          paramAnonymousView = MallProductSelectSkuUI.this;
          localObject2 = MallProductSelectSkuUI.b(MallProductSelectSkuUI.this);
          paramAnonymousAdapterView = (String)((Pair)localObject3).first;
          localObject3 = (String)((Pair)localObject3).second;
          Log.d("MicroMsg.MallProductManager", "selectSkuInfo (" + paramAnonymousAdapterView + " , " + (String)localObject3 + ")");
          if ((((com.tencent.mm.plugin.product.b.c)localObject2).GTh.containsKey(paramAnonymousAdapterView)) && (((String)((com.tencent.mm.plugin.product.b.c)localObject2).GTh.get(paramAnonymousAdapterView)).equals(localObject3)))
          {
            ((com.tencent.mm.plugin.product.b.c)localObject2).GTh.remove(paramAnonymousAdapterView);
            ((com.tencent.mm.plugin.product.b.c)localObject2).GSZ = com.tencent.mm.plugin.product.b.c.az(((com.tencent.mm.plugin.product.b.c)localObject2).GTh);
            if (((com.tencent.mm.plugin.product.b.c)localObject2).GTg != null) {
              paramAnonymousAdapterView = (e)((com.tencent.mm.plugin.product.b.c)localObject2).GTg.get(((com.tencent.mm.plugin.product.b.c)localObject2).GSZ);
            }
          }
          for (((com.tencent.mm.plugin.product.b.c)localObject2).GTk = paramAnonymousAdapterView;; ((com.tencent.mm.plugin.product.b.c)localObject2).GTk = ((e)((com.tencent.mm.plugin.product.b.c)localObject2).GTg.get(((com.tencent.mm.plugin.product.b.c)localObject2).GSZ)))
          {
            ((com.tencent.mm.plugin.product.b.c)localObject2).fpm();
            paramAnonymousAdapterView = ((com.tencent.mm.plugin.product.b.c)localObject2).GTk;
            do
            {
              MallProductSelectSkuUI.a(paramAnonymousView, paramAnonymousAdapterView);
              MallProductSelectSkuUI.a(MallProductSelectSkuUI.this);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/product/ui/MallProductSelectSkuUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(67013);
              return;
              paramAnonymousAdapterView = null;
              break;
              ((com.tencent.mm.plugin.product.b.c)localObject2).GTh.put(paramAnonymousAdapterView, localObject3);
              ((com.tencent.mm.plugin.product.b.c)localObject2).GSZ = com.tencent.mm.plugin.product.b.c.az(((com.tencent.mm.plugin.product.b.c)localObject2).GTh);
              Log.d("MicroMsg.MallProductManager", "getSkuInfoId (" + ((com.tencent.mm.plugin.product.b.c)localObject2).GSZ + ")");
              paramAnonymousAdapterView = localObject1;
            } while (((com.tencent.mm.plugin.product.b.c)localObject2).GTg == null);
          }
        }
      };
      this.GVt.setAdapter(this.GVv);
      this.GVu.setOnAmountChangeListener(new MallProductSelectAmountView.a()
      {
        public final void iT(int paramAnonymousInt1, int paramAnonymousInt2)
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
        
        public final void kp(int paramAnonymousInt)
        {
          AppMethodBeat.i(67014);
          MallProductSelectSkuUI.b(MallProductSelectSkuUI.this).mCount = paramAnonymousInt;
          MallProductSelectSkuUI.c(MallProductSelectSkuUI.this).setVisibility(8);
          AppMethodBeat.o(67014);
        }
      });
      this.GVs.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67016);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/product/ui/MallProductSelectSkuUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          localObject = MallProductSelectSkuUI.d(MallProductSelectSkuUI.this);
          if (((f)localObject).GUL) {
            w.makeText(((f)localObject).mContext, a.i.mall_product_data_loading, 1).show();
          }
          label285:
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/product/ui/MallProductSelectSkuUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(67016);
            return;
            if (((f)localObject).GUN.fpi())
            {
              if (((f)localObject).GUN.GTb != null)
              {
                h.aHH();
                h.aHF().kcd.a(new j(((f)localObject).GUN.fpk(), f.mScene), 0);
              }
              else
              {
                com.tencent.mm.by.c.f(((f)localObject).mContext, "address", ".ui.WalletAddAddressUI", 2);
              }
            }
            else
            {
              paramAnonymousView = ((f)localObject).GUN;
              com.tencent.mm.plugin.product.c.m localm;
              if ((paramAnonymousView.GTh != null) && (paramAnonymousView.GTh.size() < paramAnonymousView.GTf) && (paramAnonymousView.GTf > 0))
              {
                Iterator localIterator = paramAnonymousView.GSV.GTz.GTS.iterator();
                do
                {
                  if (!localIterator.hasNext()) {
                    break;
                  }
                  localm = (com.tencent.mm.plugin.product.c.m)localIterator.next();
                } while (paramAnonymousView.GTh.containsKey(localm.GUc));
              }
              for (paramAnonymousView = localm.GUd;; paramAnonymousView = null)
              {
                if (Util.isNullOrNil(paramAnonymousView)) {
                  break label285;
                }
                w.makeText(((f)localObject).mContext, ((f)localObject).mContext.getString(a.i.mall_product_select_sku_err, new Object[] { paramAnonymousView }), 0).show();
                break;
              }
            }
          }
        }
      });
      this.GVp.setFocusable(true);
      this.GVp.setFocusableInTouchMode(true);
      this.GVp.requestFocus();
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
      if (!Util.isNullOrNil(this.GUN.foY())) {
        break;
      }
      AppMethodBeat.o(67024);
      return;
    }
    this.GVp.post(new Runnable()
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
    this.GVw.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(67023);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(67018);
    super.onCreate(paramBundle);
    this.GVw = new f(getContext(), new f.a()
    {
      public final void F(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString)
      {
        AppMethodBeat.i(67012);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          MallProductSelectSkuUI.a(MallProductSelectSkuUI.this);
          AppMethodBeat.o(67012);
          return;
        }
        MallProductSelectSkuUI.this.aUG(paramAnonymousString);
        AppMethodBeat.o(67012);
      }
    });
    com.tencent.mm.plugin.product.a.a.foU();
    this.GUN = com.tencent.mm.plugin.product.a.a.foV();
    this.GSV = this.GUN.GSV;
    initView();
    updateView();
    AppMethodBeat.o(67018);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(67019);
    this.GVw.onStart();
    super.onStart();
    AppMethodBeat.o(67019);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(67020);
    this.GVw.onStop();
    super.onStop();
    AppMethodBeat.o(67020);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductSelectSkuUI
 * JD-Core Version:    0.7.0.1
 */