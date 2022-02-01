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
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.product.b.e;
import com.tencent.mm.plugin.product.b.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class MallProductSelectSkuUI
  extends MallBaseUI
  implements u.a
{
  private com.tencent.mm.plugin.product.b.m AYX;
  private e AZm;
  private com.tencent.mm.plugin.product.b.c BaP;
  private ImageView Bbr;
  private TextView Bbs;
  private TextView Bbt;
  private Button Bbu;
  private ListView Bbv;
  private MallProductSelectAmountView Bbw = null;
  private i Bbx = null;
  private f Bby;
  private TextView mPa;
  
  private void updateView()
  {
    AppMethodBeat.i(67022);
    if (this.AYX != null)
    {
      if ((this.AZm == null) || (this.AYX.AZB == null)) {
        break label180;
      }
      this.Bbs.setText(com.tencent.mm.plugin.product.b.b.C(this.AZm.AZq, this.AZm.AZr, this.AYX.AZB.AOl));
    }
    for (;;)
    {
      if (this.AYX.AZB != null) {
        this.mPa.setText(this.AYX.AZB.name);
      }
      if (!Util.isNullOrNil(this.BaP.eDf()))
      {
        Bitmap localBitmap = com.tencent.mm.platformtools.u.a(new c(this.BaP.eDf()));
        this.Bbr.setImageBitmap(localBitmap);
        com.tencent.mm.platformtools.u.a(this);
      }
      this.Bbt.setVisibility(8);
      this.Bbw.hN(this.BaP.eDn(), this.BaP.AYX.AZA);
      this.Bbx.notifyDataSetChanged();
      AppMethodBeat.o(67022);
      return;
      label180:
      this.Bbs.setText(com.tencent.mm.plugin.product.b.b.C(this.AYX.AZB.AZM, this.AYX.AZB.AZN, this.AYX.AZB.AOl));
    }
  }
  
  public int getLayoutId()
  {
    return 2131495971;
  }
  
  public void initView()
  {
    AppMethodBeat.i(67021);
    setMMTitle(2131762917);
    this.Bbr = ((ImageView)findViewById(2131304439));
    this.mPa = ((TextView)findViewById(2131304443));
    this.Bbs = ((TextView)findViewById(2131304441));
    this.Bbt = ((TextView)findViewById(2131304438));
    this.Bbu = ((Button)findViewById(2131304440));
    this.Bbv = ((ListView)findViewById(2131304446));
    this.Bbw = ((MallProductSelectAmountView)findViewById(2131307497));
    this.Bbw.setAmount(this.BaP.mCount);
    this.Bbx = new i(this);
    if ((this.AYX != null) && (this.AYX.AZB != null) && (this.AYX.AZB.AZU != null)) {
      this.Bbx.BbA = this.AYX.AZB.AZU;
    }
    for (;;)
    {
      this.Bbx.BbB = new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          Object localObject1 = null;
          AppMethodBeat.i(67013);
          Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject2).bm(paramAnonymousAdapterView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject2).bm(paramAnonymousView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject2).pH(paramAnonymousInt);
          ((com.tencent.mm.hellhoundlib.b.b)localObject2).zo(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/product/ui/MallProductSelectSkuUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject2).axR());
          Object localObject3 = (Pair)paramAnonymousView.getTag();
          paramAnonymousView = MallProductSelectSkuUI.this;
          localObject2 = MallProductSelectSkuUI.b(MallProductSelectSkuUI.this);
          paramAnonymousAdapterView = (String)((Pair)localObject3).first;
          localObject3 = (String)((Pair)localObject3).second;
          Log.d("MicroMsg.MallProductManager", "selectSkuInfo (" + paramAnonymousAdapterView + " , " + (String)localObject3 + ")");
          if ((((com.tencent.mm.plugin.product.b.c)localObject2).AZj.containsKey(paramAnonymousAdapterView)) && (((String)((com.tencent.mm.plugin.product.b.c)localObject2).AZj.get(paramAnonymousAdapterView)).equals(localObject3)))
          {
            ((com.tencent.mm.plugin.product.b.c)localObject2).AZj.remove(paramAnonymousAdapterView);
            ((com.tencent.mm.plugin.product.b.c)localObject2).AZb = com.tencent.mm.plugin.product.b.c.aF(((com.tencent.mm.plugin.product.b.c)localObject2).AZj);
            if (((com.tencent.mm.plugin.product.b.c)localObject2).AZi != null) {
              paramAnonymousAdapterView = (e)((com.tencent.mm.plugin.product.b.c)localObject2).AZi.get(((com.tencent.mm.plugin.product.b.c)localObject2).AZb);
            }
          }
          for (((com.tencent.mm.plugin.product.b.c)localObject2).AZm = paramAnonymousAdapterView;; ((com.tencent.mm.plugin.product.b.c)localObject2).AZm = ((e)((com.tencent.mm.plugin.product.b.c)localObject2).AZi.get(((com.tencent.mm.plugin.product.b.c)localObject2).AZb)))
          {
            ((com.tencent.mm.plugin.product.b.c)localObject2).eDt();
            paramAnonymousAdapterView = ((com.tencent.mm.plugin.product.b.c)localObject2).AZm;
            do
            {
              MallProductSelectSkuUI.a(paramAnonymousView, paramAnonymousAdapterView);
              MallProductSelectSkuUI.a(MallProductSelectSkuUI.this);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/product/ui/MallProductSelectSkuUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(67013);
              return;
              paramAnonymousAdapterView = null;
              break;
              ((com.tencent.mm.plugin.product.b.c)localObject2).AZj.put(paramAnonymousAdapterView, localObject3);
              ((com.tencent.mm.plugin.product.b.c)localObject2).AZb = com.tencent.mm.plugin.product.b.c.aF(((com.tencent.mm.plugin.product.b.c)localObject2).AZj);
              Log.d("MicroMsg.MallProductManager", "getSkuInfoId (" + ((com.tencent.mm.plugin.product.b.c)localObject2).AZb + ")");
              paramAnonymousAdapterView = localObject1;
            } while (((com.tencent.mm.plugin.product.b.c)localObject2).AZi == null);
          }
        }
      };
      this.Bbv.setAdapter(this.Bbx);
      this.Bbw.setOnAmountChangeListener(new MallProductSelectAmountView.a()
      {
        public final void hO(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(67015);
          switch (paramAnonymousInt2)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(67015);
            return;
            MallProductSelectSkuUI.c(MallProductSelectSkuUI.this).setText(2131762912);
            MallProductSelectSkuUI.c(MallProductSelectSkuUI.this).setVisibility(0);
            AppMethodBeat.o(67015);
            return;
            MallProductSelectSkuUI.c(MallProductSelectSkuUI.this).setText(MallProductSelectSkuUI.this.getString(2131762913, new Object[] { Integer.valueOf(paramAnonymousInt1) }));
            MallProductSelectSkuUI.c(MallProductSelectSkuUI.this).setVisibility(0);
          }
        }
        
        public final void iZ(int paramAnonymousInt)
        {
          AppMethodBeat.i(67014);
          MallProductSelectSkuUI.b(MallProductSelectSkuUI.this).mCount = paramAnonymousInt;
          MallProductSelectSkuUI.c(MallProductSelectSkuUI.this).setVisibility(8);
          AppMethodBeat.o(67014);
        }
      });
      this.Bbu.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67016);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/product/ui/MallProductSelectSkuUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          localObject = MallProductSelectSkuUI.d(MallProductSelectSkuUI.this);
          if (((f)localObject).BaN) {
            com.tencent.mm.ui.base.u.makeText(((f)localObject).mContext, 2131762906, 1).show();
          }
          label283:
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/product/ui/MallProductSelectSkuUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(67016);
            return;
            if (((f)localObject).BaP.eDp())
            {
              if (((f)localObject).BaP.AZd != null)
              {
                g.aAi();
                g.aAg().hqi.a(new j(((f)localObject).BaP.eDr(), f.mScene), 0);
              }
              else
              {
                com.tencent.mm.br.c.d(((f)localObject).mContext, "address", ".ui.WalletAddAddressUI", 2);
              }
            }
            else
            {
              paramAnonymousView = ((f)localObject).BaP;
              com.tencent.mm.plugin.product.c.m localm;
              if ((paramAnonymousView.AZj != null) && (paramAnonymousView.AZj.size() < paramAnonymousView.AZh) && (paramAnonymousView.AZh > 0))
              {
                Iterator localIterator = paramAnonymousView.AYX.AZB.AZU.iterator();
                do
                {
                  if (!localIterator.hasNext()) {
                    break;
                  }
                  localm = (com.tencent.mm.plugin.product.c.m)localIterator.next();
                } while (paramAnonymousView.AZj.containsKey(localm.Bae));
              }
              for (paramAnonymousView = localm.Baf;; paramAnonymousView = null)
              {
                if (Util.isNullOrNil(paramAnonymousView)) {
                  break label283;
                }
                com.tencent.mm.ui.base.u.makeText(((f)localObject).mContext, ((f)localObject).mContext.getString(2131762915, new Object[] { paramAnonymousView }), 0).show();
                break;
              }
            }
          }
        }
      });
      this.Bbr.setFocusable(true);
      this.Bbr.setFocusableInTouchMode(true);
      this.Bbr.requestFocus();
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
      if (!Util.isNullOrNil(this.BaP.eDf())) {
        break;
      }
      AppMethodBeat.o(67024);
      return;
    }
    this.Bbr.post(new Runnable()
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
    this.Bby.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(67023);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(67018);
    super.onCreate(paramBundle);
    this.Bby = new f(getContext(), new f.a()
    {
      public final void D(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString)
      {
        AppMethodBeat.i(67012);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          MallProductSelectSkuUI.a(MallProductSelectSkuUI.this);
          AppMethodBeat.o(67012);
          return;
        }
        MallProductSelectSkuUI.this.aKi(paramAnonymousString);
        AppMethodBeat.o(67012);
      }
    });
    com.tencent.mm.plugin.product.a.a.eDb();
    this.BaP = com.tencent.mm.plugin.product.a.a.eDc();
    this.AYX = this.BaP.AYX;
    initView();
    updateView();
    AppMethodBeat.o(67018);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(67019);
    this.Bby.onStart();
    super.onStart();
    AppMethodBeat.o(67019);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(67020);
    this.Bby.onStop();
    super.onStop();
    AppMethodBeat.o(67020);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductSelectSkuUI
 * JD-Core Version:    0.7.0.1
 */