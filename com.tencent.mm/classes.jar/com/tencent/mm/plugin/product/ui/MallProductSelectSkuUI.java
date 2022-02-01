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
import com.tencent.mm.al.q;
import com.tencent.mm.bs.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.product.b.e;
import com.tencent.mm.plugin.product.b.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.t;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class MallProductSelectSkuUI
  extends MallBaseUI
  implements u.a
{
  private TextView lCL;
  private com.tencent.mm.plugin.product.b.m wLH;
  private e wLW;
  private com.tencent.mm.plugin.product.b.c wNz;
  private ImageView wOb;
  private TextView wOc;
  private TextView wOd;
  private Button wOe;
  private ListView wOf;
  private MallProductSelectAmountView wOg = null;
  private i wOh = null;
  private f wOi;
  
  private void updateView()
  {
    AppMethodBeat.i(67022);
    if (this.wLH != null)
    {
      if ((this.wLW == null) || (this.wLH.wMl == null)) {
        break label180;
      }
      this.wOc.setText(com.tencent.mm.plugin.product.b.b.D(this.wLW.wMa, this.wLW.wMb, this.wLH.wMl.wCF));
    }
    for (;;)
    {
      if (this.wLH.wMl != null) {
        this.lCL.setText(this.wLH.wMl.name);
      }
      if (!bt.isNullOrNil(this.wNz.dzw()))
      {
        Bitmap localBitmap = u.a(new c(this.wNz.dzw()));
        this.wOb.setImageBitmap(localBitmap);
        u.a(this);
      }
      this.wOd.setVisibility(8);
      this.wOg.hb(this.wNz.dzE(), this.wNz.wLH.wMk);
      this.wOh.notifyDataSetChanged();
      AppMethodBeat.o(67022);
      return;
      label180:
      this.wOc.setText(com.tencent.mm.plugin.product.b.b.D(this.wLH.wMl.wMw, this.wLH.wMl.wMx, this.wLH.wMl.wCF));
    }
  }
  
  public int getLayoutId()
  {
    return 2131495128;
  }
  
  public void initView()
  {
    AppMethodBeat.i(67021);
    setMMTitle(2131761130);
    this.wOb = ((ImageView)findViewById(2131302100));
    this.lCL = ((TextView)findViewById(2131302104));
    this.wOc = ((TextView)findViewById(2131302102));
    this.wOd = ((TextView)findViewById(2131302099));
    this.wOe = ((Button)findViewById(2131302101));
    this.wOf = ((ListView)findViewById(2131302107));
    this.wOg = ((MallProductSelectAmountView)findViewById(2131304492));
    this.wOg.setAmount(this.wNz.mCount);
    this.wOh = new i(this);
    if ((this.wLH != null) && (this.wLH.wMl != null) && (this.wLH.wMl.wME != null)) {
      this.wOh.wOk = this.wLH.wMl.wME;
    }
    for (;;)
    {
      this.wOh.wOl = new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          Object localObject1 = null;
          AppMethodBeat.i(67013);
          Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject2).bd(paramAnonymousAdapterView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject2).bd(paramAnonymousView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject2).mr(paramAnonymousInt);
          ((com.tencent.mm.hellhoundlib.b.b)localObject2).qY(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/product/ui/MallProductSelectSkuUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject2).ahq());
          Object localObject3 = (Pair)paramAnonymousView.getTag();
          paramAnonymousView = MallProductSelectSkuUI.this;
          localObject2 = MallProductSelectSkuUI.b(MallProductSelectSkuUI.this);
          paramAnonymousAdapterView = (String)((Pair)localObject3).first;
          localObject3 = (String)((Pair)localObject3).second;
          ad.d("MicroMsg.MallProductManager", "selectSkuInfo (" + paramAnonymousAdapterView + " , " + (String)localObject3 + ")");
          if ((((com.tencent.mm.plugin.product.b.c)localObject2).wLT.containsKey(paramAnonymousAdapterView)) && (((String)((com.tencent.mm.plugin.product.b.c)localObject2).wLT.get(paramAnonymousAdapterView)).equals(localObject3)))
          {
            ((com.tencent.mm.plugin.product.b.c)localObject2).wLT.remove(paramAnonymousAdapterView);
            ((com.tencent.mm.plugin.product.b.c)localObject2).wLL = com.tencent.mm.plugin.product.b.c.az(((com.tencent.mm.plugin.product.b.c)localObject2).wLT);
            if (((com.tencent.mm.plugin.product.b.c)localObject2).wLS != null) {
              paramAnonymousAdapterView = (e)((com.tencent.mm.plugin.product.b.c)localObject2).wLS.get(((com.tencent.mm.plugin.product.b.c)localObject2).wLL);
            }
          }
          for (((com.tencent.mm.plugin.product.b.c)localObject2).wLW = paramAnonymousAdapterView;; ((com.tencent.mm.plugin.product.b.c)localObject2).wLW = ((e)((com.tencent.mm.plugin.product.b.c)localObject2).wLS.get(((com.tencent.mm.plugin.product.b.c)localObject2).wLL)))
          {
            ((com.tencent.mm.plugin.product.b.c)localObject2).dzK();
            paramAnonymousAdapterView = ((com.tencent.mm.plugin.product.b.c)localObject2).wLW;
            do
            {
              MallProductSelectSkuUI.a(paramAnonymousView, paramAnonymousAdapterView);
              MallProductSelectSkuUI.a(MallProductSelectSkuUI.this);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/product/ui/MallProductSelectSkuUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(67013);
              return;
              paramAnonymousAdapterView = null;
              break;
              ((com.tencent.mm.plugin.product.b.c)localObject2).wLT.put(paramAnonymousAdapterView, localObject3);
              ((com.tencent.mm.plugin.product.b.c)localObject2).wLL = com.tencent.mm.plugin.product.b.c.az(((com.tencent.mm.plugin.product.b.c)localObject2).wLT);
              ad.d("MicroMsg.MallProductManager", "getSkuInfoId (" + ((com.tencent.mm.plugin.product.b.c)localObject2).wLL + ")");
              paramAnonymousAdapterView = localObject1;
            } while (((com.tencent.mm.plugin.product.b.c)localObject2).wLS == null);
          }
        }
      };
      this.wOf.setAdapter(this.wOh);
      this.wOg.setOnAmountChangeListener(new MallProductSelectAmountView.a()
      {
        public final void hD(int paramAnonymousInt)
        {
          AppMethodBeat.i(67014);
          MallProductSelectSkuUI.b(MallProductSelectSkuUI.this).mCount = paramAnonymousInt;
          MallProductSelectSkuUI.c(MallProductSelectSkuUI.this).setVisibility(8);
          AppMethodBeat.o(67014);
        }
        
        public final void hc(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(67015);
          switch (paramAnonymousInt2)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(67015);
            return;
            MallProductSelectSkuUI.c(MallProductSelectSkuUI.this).setText(2131761125);
            MallProductSelectSkuUI.c(MallProductSelectSkuUI.this).setVisibility(0);
            AppMethodBeat.o(67015);
            return;
            MallProductSelectSkuUI.c(MallProductSelectSkuUI.this).setText(MallProductSelectSkuUI.this.getString(2131761126, new Object[] { Integer.valueOf(paramAnonymousInt1) }));
            MallProductSelectSkuUI.c(MallProductSelectSkuUI.this).setVisibility(0);
          }
        }
      });
      this.wOe.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67016);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/product/ui/MallProductSelectSkuUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          localObject = MallProductSelectSkuUI.d(MallProductSelectSkuUI.this);
          if (((f)localObject).wNx) {
            t.makeText(((f)localObject).kbt, 2131761119, 1).show();
          }
          label283:
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/product/ui/MallProductSelectSkuUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(67016);
            return;
            if (((f)localObject).wNz.dzG())
            {
              if (((f)localObject).wNz.wLN != null)
              {
                g.ajD();
                g.ajB().gAO.a(new j(((f)localObject).wNz.dzI(), f.mScene), 0);
              }
              else
              {
                d.c(((f)localObject).kbt, "address", ".ui.WalletAddAddressUI", 2);
              }
            }
            else
            {
              paramAnonymousView = ((f)localObject).wNz;
              com.tencent.mm.plugin.product.c.m localm;
              if ((paramAnonymousView.wLT != null) && (paramAnonymousView.wLT.size() < paramAnonymousView.wLR) && (paramAnonymousView.wLR > 0))
              {
                Iterator localIterator = paramAnonymousView.wLH.wMl.wME.iterator();
                do
                {
                  if (!localIterator.hasNext()) {
                    break;
                  }
                  localm = (com.tencent.mm.plugin.product.c.m)localIterator.next();
                } while (paramAnonymousView.wLT.containsKey(localm.wMO));
              }
              for (paramAnonymousView = localm.wMP;; paramAnonymousView = null)
              {
                if (bt.isNullOrNil(paramAnonymousView)) {
                  break label283;
                }
                t.makeText(((f)localObject).kbt, ((f)localObject).kbt.getString(2131761128, new Object[] { paramAnonymousView }), 0).show();
                break;
              }
            }
          }
        }
      });
      this.wOb.setFocusable(true);
      this.wOb.setFocusableInTouchMode(true);
      this.wOb.requestFocus();
      AppMethodBeat.o(67021);
      return;
      ad.e("MicroMsg.MallProductSelectSkuUI", "Illage mProductInfo.base_attr.sku_table");
    }
  }
  
  public final void k(String paramString, final Bitmap paramBitmap)
  {
    AppMethodBeat.i(67024);
    paramString = new StringBuilder().append(paramString).append(", bitmap = ");
    if (paramBitmap == null) {}
    for (boolean bool = true;; bool = false)
    {
      ad.d("MicroMsg.MallProductSelectSkuUI", bool);
      if (!bt.isNullOrNil(this.wNz.dzw())) {
        break;
      }
      AppMethodBeat.o(67024);
      return;
    }
    this.wOb.post(new Runnable()
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
    this.wOi.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(67023);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(67018);
    super.onCreate(paramBundle);
    this.wOi = new f(getContext(), new f.a()
    {
      public final void E(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString)
      {
        AppMethodBeat.i(67012);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          MallProductSelectSkuUI.a(MallProductSelectSkuUI.this);
          AppMethodBeat.o(67012);
          return;
        }
        MallProductSelectSkuUI.this.auB(paramAnonymousString);
        AppMethodBeat.o(67012);
      }
    });
    com.tencent.mm.plugin.product.a.a.dzs();
    this.wNz = com.tencent.mm.plugin.product.a.a.dzt();
    this.wLH = this.wNz.wLH;
    initView();
    updateView();
    AppMethodBeat.o(67018);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(67019);
    this.wOi.onStart();
    super.onStart();
    AppMethodBeat.o(67019);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(67020);
    this.wOi.onStop();
    super.onStop();
    AppMethodBeat.o(67020);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductSelectSkuUI
 * JD-Core Version:    0.7.0.1
 */