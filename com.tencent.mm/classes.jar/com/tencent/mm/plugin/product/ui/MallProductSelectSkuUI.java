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
import com.tencent.mm.ak.q;
import com.tencent.mm.br.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.product.b.e;
import com.tencent.mm.plugin.product.b.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.t;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class MallProductSelectSkuUI
  extends MallBaseUI
  implements u.a
{
  private TextView lHk;
  private e xbK;
  private com.tencent.mm.plugin.product.b.m xbv;
  private ImageView xdP;
  private TextView xdQ;
  private TextView xdR;
  private Button xdS;
  private ListView xdT;
  private MallProductSelectAmountView xdU = null;
  private i xdV = null;
  private f xdW;
  private com.tencent.mm.plugin.product.b.c xdn;
  
  private void updateView()
  {
    AppMethodBeat.i(67022);
    if (this.xbv != null)
    {
      if ((this.xbK == null) || (this.xbv.xbZ == null)) {
        break label180;
      }
      this.xdQ.setText(com.tencent.mm.plugin.product.b.b.D(this.xbK.xbO, this.xbK.xbP, this.xbv.xbZ.wSq));
    }
    for (;;)
    {
      if (this.xbv.xbZ != null) {
        this.lHk.setText(this.xbv.xbZ.name);
      }
      if (!bu.isNullOrNil(this.xdn.dCN()))
      {
        Bitmap localBitmap = u.a(new c(this.xdn.dCN()));
        this.xdP.setImageBitmap(localBitmap);
        u.a(this);
      }
      this.xdR.setVisibility(8);
      this.xdU.hd(this.xdn.dCV(), this.xdn.xbv.xbY);
      this.xdV.notifyDataSetChanged();
      AppMethodBeat.o(67022);
      return;
      label180:
      this.xdQ.setText(com.tencent.mm.plugin.product.b.b.D(this.xbv.xbZ.xck, this.xbv.xbZ.xcl, this.xbv.xbZ.wSq));
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
    this.xdP = ((ImageView)findViewById(2131302100));
    this.lHk = ((TextView)findViewById(2131302104));
    this.xdQ = ((TextView)findViewById(2131302102));
    this.xdR = ((TextView)findViewById(2131302099));
    this.xdS = ((Button)findViewById(2131302101));
    this.xdT = ((ListView)findViewById(2131302107));
    this.xdU = ((MallProductSelectAmountView)findViewById(2131304492));
    this.xdU.setAmount(this.xdn.mCount);
    this.xdV = new i(this);
    if ((this.xbv != null) && (this.xbv.xbZ != null) && (this.xbv.xbZ.xcs != null)) {
      this.xdV.xdY = this.xbv.xbZ.xcs;
    }
    for (;;)
    {
      this.xdV.xdZ = new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          Object localObject1 = null;
          AppMethodBeat.i(67013);
          Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject2).bd(paramAnonymousAdapterView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject2).bd(paramAnonymousView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject2).mu(paramAnonymousInt);
          ((com.tencent.mm.hellhoundlib.b.b)localObject2).rl(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/product/ui/MallProductSelectSkuUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject2).ahF());
          Object localObject3 = (Pair)paramAnonymousView.getTag();
          paramAnonymousView = MallProductSelectSkuUI.this;
          localObject2 = MallProductSelectSkuUI.b(MallProductSelectSkuUI.this);
          paramAnonymousAdapterView = (String)((Pair)localObject3).first;
          localObject3 = (String)((Pair)localObject3).second;
          ae.d("MicroMsg.MallProductManager", "selectSkuInfo (" + paramAnonymousAdapterView + " , " + (String)localObject3 + ")");
          if ((((com.tencent.mm.plugin.product.b.c)localObject2).xbH.containsKey(paramAnonymousAdapterView)) && (((String)((com.tencent.mm.plugin.product.b.c)localObject2).xbH.get(paramAnonymousAdapterView)).equals(localObject3)))
          {
            ((com.tencent.mm.plugin.product.b.c)localObject2).xbH.remove(paramAnonymousAdapterView);
            ((com.tencent.mm.plugin.product.b.c)localObject2).xbz = com.tencent.mm.plugin.product.b.c.aF(((com.tencent.mm.plugin.product.b.c)localObject2).xbH);
            if (((com.tencent.mm.plugin.product.b.c)localObject2).xbG != null) {
              paramAnonymousAdapterView = (e)((com.tencent.mm.plugin.product.b.c)localObject2).xbG.get(((com.tencent.mm.plugin.product.b.c)localObject2).xbz);
            }
          }
          for (((com.tencent.mm.plugin.product.b.c)localObject2).xbK = paramAnonymousAdapterView;; ((com.tencent.mm.plugin.product.b.c)localObject2).xbK = ((e)((com.tencent.mm.plugin.product.b.c)localObject2).xbG.get(((com.tencent.mm.plugin.product.b.c)localObject2).xbz)))
          {
            ((com.tencent.mm.plugin.product.b.c)localObject2).dDb();
            paramAnonymousAdapterView = ((com.tencent.mm.plugin.product.b.c)localObject2).xbK;
            do
            {
              MallProductSelectSkuUI.a(paramAnonymousView, paramAnonymousAdapterView);
              MallProductSelectSkuUI.a(MallProductSelectSkuUI.this);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/product/ui/MallProductSelectSkuUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(67013);
              return;
              paramAnonymousAdapterView = null;
              break;
              ((com.tencent.mm.plugin.product.b.c)localObject2).xbH.put(paramAnonymousAdapterView, localObject3);
              ((com.tencent.mm.plugin.product.b.c)localObject2).xbz = com.tencent.mm.plugin.product.b.c.aF(((com.tencent.mm.plugin.product.b.c)localObject2).xbH);
              ae.d("MicroMsg.MallProductManager", "getSkuInfoId (" + ((com.tencent.mm.plugin.product.b.c)localObject2).xbz + ")");
              paramAnonymousAdapterView = localObject1;
            } while (((com.tencent.mm.plugin.product.b.c)localObject2).xbG == null);
          }
        }
      };
      this.xdT.setAdapter(this.xdV);
      this.xdU.setOnAmountChangeListener(new MallProductSelectAmountView.a()
      {
        public final void hF(int paramAnonymousInt)
        {
          AppMethodBeat.i(67014);
          MallProductSelectSkuUI.b(MallProductSelectSkuUI.this).mCount = paramAnonymousInt;
          MallProductSelectSkuUI.c(MallProductSelectSkuUI.this).setVisibility(8);
          AppMethodBeat.o(67014);
        }
        
        public final void he(int paramAnonymousInt1, int paramAnonymousInt2)
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
      this.xdS.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67016);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/product/ui/MallProductSelectSkuUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          localObject = MallProductSelectSkuUI.d(MallProductSelectSkuUI.this);
          if (((f)localObject).xdl) {
            t.makeText(((f)localObject).keK, 2131761119, 1).show();
          }
          label283:
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/product/ui/MallProductSelectSkuUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(67016);
            return;
            if (((f)localObject).xdn.dCX())
            {
              if (((f)localObject).xdn.xbB != null)
              {
                g.ajS();
                g.ajQ().gDv.a(new j(((f)localObject).xdn.dCZ(), f.mScene), 0);
              }
              else
              {
                d.c(((f)localObject).keK, "address", ".ui.WalletAddAddressUI", 2);
              }
            }
            else
            {
              paramAnonymousView = ((f)localObject).xdn;
              com.tencent.mm.plugin.product.c.m localm;
              if ((paramAnonymousView.xbH != null) && (paramAnonymousView.xbH.size() < paramAnonymousView.xbF) && (paramAnonymousView.xbF > 0))
              {
                Iterator localIterator = paramAnonymousView.xbv.xbZ.xcs.iterator();
                do
                {
                  if (!localIterator.hasNext()) {
                    break;
                  }
                  localm = (com.tencent.mm.plugin.product.c.m)localIterator.next();
                } while (paramAnonymousView.xbH.containsKey(localm.xcC));
              }
              for (paramAnonymousView = localm.xcD;; paramAnonymousView = null)
              {
                if (bu.isNullOrNil(paramAnonymousView)) {
                  break label283;
                }
                t.makeText(((f)localObject).keK, ((f)localObject).keK.getString(2131761128, new Object[] { paramAnonymousView }), 0).show();
                break;
              }
            }
          }
        }
      });
      this.xdP.setFocusable(true);
      this.xdP.setFocusableInTouchMode(true);
      this.xdP.requestFocus();
      AppMethodBeat.o(67021);
      return;
      ae.e("MicroMsg.MallProductSelectSkuUI", "Illage mProductInfo.base_attr.sku_table");
    }
  }
  
  public final void k(String paramString, final Bitmap paramBitmap)
  {
    AppMethodBeat.i(67024);
    paramString = new StringBuilder().append(paramString).append(", bitmap = ");
    if (paramBitmap == null) {}
    for (boolean bool = true;; bool = false)
    {
      ae.d("MicroMsg.MallProductSelectSkuUI", bool);
      if (!bu.isNullOrNil(this.xdn.dCN())) {
        break;
      }
      AppMethodBeat.o(67024);
      return;
    }
    this.xdP.post(new Runnable()
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
    this.xdW.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(67023);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(67018);
    super.onCreate(paramBundle);
    this.xdW = new f(getContext(), new f.a()
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
        MallProductSelectSkuUI.this.avQ(paramAnonymousString);
        AppMethodBeat.o(67012);
      }
    });
    com.tencent.mm.plugin.product.a.a.dCJ();
    this.xdn = com.tencent.mm.plugin.product.a.a.dCK();
    this.xbv = this.xdn.xbv;
    initView();
    updateView();
    AppMethodBeat.o(67018);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(67019);
    this.xdW.onStart();
    super.onStart();
    AppMethodBeat.o(67019);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(67020);
    this.xdW.onStop();
    super.onStop();
    AppMethodBeat.o(67020);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductSelectSkuUI
 * JD-Core Version:    0.7.0.1
 */