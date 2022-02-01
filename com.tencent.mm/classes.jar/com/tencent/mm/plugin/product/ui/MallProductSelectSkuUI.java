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
import com.tencent.mm.plugin.product.a.a;
import com.tencent.mm.plugin.product.b.e;
import com.tencent.mm.plugin.product.b.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.t;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class MallProductSelectSkuUI
  extends MallBaseUI
  implements u.a
{
  private TextView lfN;
  private com.tencent.mm.plugin.product.b.m vEB;
  private e vEQ;
  private ImageView vGU;
  private TextView vGV;
  private TextView vGW;
  private Button vGX;
  private ListView vGY;
  private MallProductSelectAmountView vGZ = null;
  private com.tencent.mm.plugin.product.b.c vGs;
  private i vHa = null;
  private f vHb;
  
  private void cL()
  {
    AppMethodBeat.i(67022);
    if (this.vEB != null)
    {
      if ((this.vEQ == null) || (this.vEB.vFf == null)) {
        break label180;
      }
      this.vGV.setText(com.tencent.mm.plugin.product.b.b.C(this.vEQ.vEU, this.vEQ.vEV, this.vEB.vFf.vxl));
    }
    for (;;)
    {
      if (this.vEB.vFf != null) {
        this.lfN.setText(this.vEB.vFf.name);
      }
      if (!bs.isNullOrNil(this.vGs.doU()))
      {
        Bitmap localBitmap = u.a(new c(this.vGs.doU()));
        this.vGU.setImageBitmap(localBitmap);
        u.a(this);
      }
      this.vGW.setVisibility(8);
      this.vGZ.gJ(this.vGs.dpc(), this.vGs.vEB.vFe);
      this.vHa.notifyDataSetChanged();
      AppMethodBeat.o(67022);
      return;
      label180:
      this.vGV.setText(com.tencent.mm.plugin.product.b.b.C(this.vEB.vFf.vFq, this.vEB.vFf.vFr, this.vEB.vFf.vxl));
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
    this.vGU = ((ImageView)findViewById(2131302100));
    this.lfN = ((TextView)findViewById(2131302104));
    this.vGV = ((TextView)findViewById(2131302102));
    this.vGW = ((TextView)findViewById(2131302099));
    this.vGX = ((Button)findViewById(2131302101));
    this.vGY = ((ListView)findViewById(2131302107));
    this.vGZ = ((MallProductSelectAmountView)findViewById(2131304492));
    this.vGZ.setAmount(this.vGs.mCount);
    this.vHa = new i(this);
    if ((this.vEB != null) && (this.vEB.vFf != null) && (this.vEB.vFf.vFy != null)) {
      this.vHa.vHd = this.vEB.vFf.vFy;
    }
    for (;;)
    {
      this.vHa.vHe = new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          paramAnonymousAdapterView = null;
          AppMethodBeat.i(67013);
          Object localObject = (Pair)paramAnonymousView.getTag();
          paramAnonymousView = MallProductSelectSkuUI.this;
          com.tencent.mm.plugin.product.b.c localc = MallProductSelectSkuUI.b(MallProductSelectSkuUI.this);
          String str = (String)((Pair)localObject).first;
          localObject = (String)((Pair)localObject).second;
          ac.d("MicroMsg.MallProductManager", "selectSkuInfo (" + str + " , " + (String)localObject + ")");
          if ((localc.vEN.containsKey(str)) && (((String)localc.vEN.get(str)).equals(localObject)))
          {
            localc.vEN.remove(str);
            localc.vEF = com.tencent.mm.plugin.product.b.c.at(localc.vEN);
            if (localc.vEM != null) {
              paramAnonymousAdapterView = (e)localc.vEM.get(localc.vEF);
            }
          }
          for (localc.vEQ = paramAnonymousAdapterView;; localc.vEQ = ((e)localc.vEM.get(localc.vEF)))
          {
            localc.dpi();
            paramAnonymousAdapterView = localc.vEQ;
            do
            {
              MallProductSelectSkuUI.a(paramAnonymousView, paramAnonymousAdapterView);
              MallProductSelectSkuUI.a(MallProductSelectSkuUI.this);
              AppMethodBeat.o(67013);
              return;
              paramAnonymousAdapterView = null;
              break;
              localc.vEN.put(str, localObject);
              localc.vEF = com.tencent.mm.plugin.product.b.c.at(localc.vEN);
              ac.d("MicroMsg.MallProductManager", "getSkuInfoId (" + localc.vEF + ")");
            } while (localc.vEM == null);
          }
        }
      };
      this.vGY.setAdapter(this.vHa);
      this.vGZ.setOnAmountChangeListener(new MallProductSelectAmountView.a()
      {
        public final void gK(int paramAnonymousInt1, int paramAnonymousInt2)
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
        
        public final void hw(int paramAnonymousInt)
        {
          AppMethodBeat.i(67014);
          MallProductSelectSkuUI.b(MallProductSelectSkuUI.this).mCount = paramAnonymousInt;
          MallProductSelectSkuUI.c(MallProductSelectSkuUI.this).setVisibility(8);
          AppMethodBeat.o(67014);
        }
      });
      this.vGX.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67016);
          f localf = MallProductSelectSkuUI.d(MallProductSelectSkuUI.this);
          if (localf.vGq)
          {
            t.makeText(localf.jHh, 2131761119, 1).show();
            AppMethodBeat.o(67016);
            return;
          }
          if (localf.vGs.dpe())
          {
            if (localf.vGs.vEH != null)
            {
              g.agS();
              g.agQ().ghe.a(new j(localf.vGs.dpg(), f.mScene), 0);
              AppMethodBeat.o(67016);
              return;
            }
            d.b(localf.jHh, "address", ".ui.WalletAddAddressUI", 2);
            AppMethodBeat.o(67016);
            return;
          }
          paramAnonymousView = localf.vGs;
          com.tencent.mm.plugin.product.c.m localm;
          if ((paramAnonymousView.vEN != null) && (paramAnonymousView.vEN.size() < paramAnonymousView.vEL) && (paramAnonymousView.vEL > 0))
          {
            Iterator localIterator = paramAnonymousView.vEB.vFf.vFy.iterator();
            do
            {
              if (!localIterator.hasNext()) {
                break;
              }
              localm = (com.tencent.mm.plugin.product.c.m)localIterator.next();
            } while (paramAnonymousView.vEN.containsKey(localm.vFI));
          }
          for (paramAnonymousView = localm.vFJ;; paramAnonymousView = null)
          {
            if (!bs.isNullOrNil(paramAnonymousView)) {
              t.makeText(localf.jHh, localf.jHh.getString(2131761128, new Object[] { paramAnonymousView }), 0).show();
            }
            AppMethodBeat.o(67016);
            return;
          }
        }
      });
      this.vGU.setFocusable(true);
      this.vGU.setFocusableInTouchMode(true);
      this.vGU.requestFocus();
      AppMethodBeat.o(67021);
      return;
      ac.e("MicroMsg.MallProductSelectSkuUI", "Illage mProductInfo.base_attr.sku_table");
    }
  }
  
  public final void k(String paramString, final Bitmap paramBitmap)
  {
    AppMethodBeat.i(67024);
    paramString = new StringBuilder().append(paramString).append(", bitmap = ");
    if (paramBitmap == null) {}
    for (boolean bool = true;; bool = false)
    {
      ac.d("MicroMsg.MallProductSelectSkuUI", bool);
      if (!bs.isNullOrNil(this.vGs.doU())) {
        break;
      }
      AppMethodBeat.o(67024);
      return;
    }
    this.vGU.post(new Runnable()
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
    this.vHb.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(67023);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(67018);
    super.onCreate(paramBundle);
    this.vHb = new f(getContext(), new f.a()
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
        MallProductSelectSkuUI.this.apv(paramAnonymousString);
        AppMethodBeat.o(67012);
      }
    });
    a.doQ();
    this.vGs = a.doR();
    this.vEB = this.vGs.vEB;
    initView();
    cL();
    AppMethodBeat.o(67018);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(67019);
    this.vHb.onStart();
    super.onStart();
    AppMethodBeat.o(67019);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(67020);
    this.vHb.onStop();
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