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
import com.tencent.mm.plugin.product.a.a;
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
  private TextView kEu;
  private com.tencent.mm.plugin.product.b.m uvI;
  private e uvX;
  private com.tencent.mm.plugin.product.b.c uxz;
  private ImageView uyb;
  private TextView uyc;
  private TextView uyd;
  private Button uye;
  private ListView uyf;
  private MallProductSelectAmountView uyg = null;
  private i uyh = null;
  private f uyi;
  
  private void cE()
  {
    AppMethodBeat.i(67022);
    if (this.uvI != null)
    {
      if ((this.uvX == null) || (this.uvI.uwm == null)) {
        break label180;
      }
      this.uyc.setText(com.tencent.mm.plugin.product.b.b.D(this.uvX.uwb, this.uvX.uwc, this.uvI.uwm.uop));
    }
    for (;;)
    {
      if (this.uvI.uwm != null) {
        this.kEu.setText(this.uvI.uwm.name);
      }
      if (!bt.isNullOrNil(this.uxz.dbm()))
      {
        Bitmap localBitmap = u.a(new c(this.uxz.dbm()));
        this.uyb.setImageBitmap(localBitmap);
        u.a(this);
      }
      this.uyd.setVisibility(8);
      this.uyg.gC(this.uxz.dbu(), this.uxz.uvI.uwl);
      this.uyh.notifyDataSetChanged();
      AppMethodBeat.o(67022);
      return;
      label180:
      this.uyc.setText(com.tencent.mm.plugin.product.b.b.D(this.uvI.uwm.uwx, this.uvI.uwm.uwy, this.uvI.uwm.uop));
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
    this.uyb = ((ImageView)findViewById(2131302100));
    this.kEu = ((TextView)findViewById(2131302104));
    this.uyc = ((TextView)findViewById(2131302102));
    this.uyd = ((TextView)findViewById(2131302099));
    this.uye = ((Button)findViewById(2131302101));
    this.uyf = ((ListView)findViewById(2131302107));
    this.uyg = ((MallProductSelectAmountView)findViewById(2131304492));
    this.uyg.setAmount(this.uxz.mCount);
    this.uyh = new i(this);
    if ((this.uvI != null) && (this.uvI.uwm != null) && (this.uvI.uwm.uwF != null)) {
      this.uyh.uyk = this.uvI.uwm.uwF;
    }
    for (;;)
    {
      this.uyh.uyl = new AdapterView.OnItemClickListener()
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
          ad.d("MicroMsg.MallProductManager", "selectSkuInfo (" + str + " , " + (String)localObject + ")");
          if ((localc.uvU.containsKey(str)) && (((String)localc.uvU.get(str)).equals(localObject)))
          {
            localc.uvU.remove(str);
            localc.uvM = com.tencent.mm.plugin.product.b.c.ar(localc.uvU);
            if (localc.uvT != null) {
              paramAnonymousAdapterView = (e)localc.uvT.get(localc.uvM);
            }
          }
          for (localc.uvX = paramAnonymousAdapterView;; localc.uvX = ((e)localc.uvT.get(localc.uvM)))
          {
            localc.dbA();
            paramAnonymousAdapterView = localc.uvX;
            do
            {
              MallProductSelectSkuUI.a(paramAnonymousView, paramAnonymousAdapterView);
              MallProductSelectSkuUI.a(MallProductSelectSkuUI.this);
              AppMethodBeat.o(67013);
              return;
              paramAnonymousAdapterView = null;
              break;
              localc.uvU.put(str, localObject);
              localc.uvM = com.tencent.mm.plugin.product.b.c.ar(localc.uvU);
              ad.d("MicroMsg.MallProductManager", "getSkuInfoId (" + localc.uvM + ")");
            } while (localc.uvT == null);
          }
        }
      };
      this.uyf.setAdapter(this.uyh);
      this.uyg.setOnAmountChangeListener(new MallProductSelectAmountView.a()
      {
        public final void gD(int paramAnonymousInt1, int paramAnonymousInt2)
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
        
        public final void hM(int paramAnonymousInt)
        {
          AppMethodBeat.i(67014);
          MallProductSelectSkuUI.b(MallProductSelectSkuUI.this).mCount = paramAnonymousInt;
          MallProductSelectSkuUI.c(MallProductSelectSkuUI.this).setVisibility(8);
          AppMethodBeat.o(67014);
        }
      });
      this.uye.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67016);
          f localf = MallProductSelectSkuUI.d(MallProductSelectSkuUI.this);
          if (localf.uxx)
          {
            t.makeText(localf.jgS, 2131761119, 1).show();
            AppMethodBeat.o(67016);
            return;
          }
          if (localf.uxz.dbw())
          {
            if (localf.uxz.uvO != null)
            {
              g.afC();
              g.afA().gcy.a(new j(localf.uxz.dby(), f.mScene), 0);
              AppMethodBeat.o(67016);
              return;
            }
            d.b(localf.jgS, "address", ".ui.WalletAddAddressUI", 2);
            AppMethodBeat.o(67016);
            return;
          }
          paramAnonymousView = localf.uxz;
          com.tencent.mm.plugin.product.c.m localm;
          if ((paramAnonymousView.uvU != null) && (paramAnonymousView.uvU.size() < paramAnonymousView.uvS) && (paramAnonymousView.uvS > 0))
          {
            Iterator localIterator = paramAnonymousView.uvI.uwm.uwF.iterator();
            do
            {
              if (!localIterator.hasNext()) {
                break;
              }
              localm = (com.tencent.mm.plugin.product.c.m)localIterator.next();
            } while (paramAnonymousView.uvU.containsKey(localm.uwP));
          }
          for (paramAnonymousView = localm.uwQ;; paramAnonymousView = null)
          {
            if (!bt.isNullOrNil(paramAnonymousView)) {
              t.makeText(localf.jgS, localf.jgS.getString(2131761128, new Object[] { paramAnonymousView }), 0).show();
            }
            AppMethodBeat.o(67016);
            return;
          }
        }
      });
      this.uyb.setFocusable(true);
      this.uyb.setFocusableInTouchMode(true);
      this.uyb.requestFocus();
      AppMethodBeat.o(67021);
      return;
      ad.e("MicroMsg.MallProductSelectSkuUI", "Illage mProductInfo.base_attr.sku_table");
    }
  }
  
  public final void l(String paramString, final Bitmap paramBitmap)
  {
    AppMethodBeat.i(67024);
    paramString = new StringBuilder().append(paramString).append(", bitmap = ");
    if (paramBitmap == null) {}
    for (boolean bool = true;; bool = false)
    {
      ad.d("MicroMsg.MallProductSelectSkuUI", bool);
      if (!bt.isNullOrNil(this.uxz.dbm())) {
        break;
      }
      AppMethodBeat.o(67024);
      return;
    }
    this.uyb.post(new Runnable()
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
    this.uyi.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(67023);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(67018);
    super.onCreate(paramBundle);
    this.uyi = new f(getContext(), new f.a()
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
        MallProductSelectSkuUI.this.akw(paramAnonymousString);
        AppMethodBeat.o(67012);
      }
    });
    a.dbi();
    this.uxz = a.dbj();
    this.uvI = this.uxz.uvI;
    initView();
    cE();
    AppMethodBeat.o(67018);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(67019);
    this.uyi.onStart();
    super.onStart();
    AppMethodBeat.o(67019);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(67020);
    this.uyi.onStop();
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