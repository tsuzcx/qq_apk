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
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.product.b.k;
import com.tencent.mm.plugin.product.b.l;
import com.tencent.mm.plugin.product.b.m;
import com.tencent.mm.protocal.protobuf.aec;
import com.tencent.mm.protocal.protobuf.chi;
import com.tencent.mm.protocal.protobuf.df;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.ListViewInScrollView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MallProductSubmitUI
  extends MallBaseUI
  implements u.a
{
  private Button iwY;
  private TextView kEu;
  private com.tencent.mm.plugin.product.b.e uvX;
  private com.tencent.mm.plugin.product.b.c uxz;
  private TextView uyA;
  private MallProductItemView uyB;
  private MallProductItemView uyC;
  private TextView uyD;
  private TextView uyE;
  private TextView uyF;
  private TextView uyG;
  private ListView uyH;
  private a uyI;
  private ImageView uyb;
  private TextView uyc;
  private f uyi;
  private RelativeLayout uyy;
  private TextView uyz;
  
  private void cE()
  {
    AppMethodBeat.i(67058);
    m localm = this.uxz.uvI;
    Object localObject1;
    label187:
    String str;
    if (this.uvX != null)
    {
      this.uyc.setText(com.tencent.mm.plugin.product.b.b.D(this.uvX.uwb, this.uvX.uwb, localm.uwm.uop) + " x " + this.uxz.mCount);
      if (!bt.isNullOrNil(this.uxz.dbm()))
      {
        localObject1 = u.a(new c(this.uxz.dbm()));
        this.uyb.setImageBitmap((Bitmap)localObject1);
        u.a(this);
      }
      this.kEu.setText(localm.uwm.name);
      this.uyD.setText(this.uxz.dbn());
      localObject1 = this.uxz.dbq();
      if ((localObject1 == null) || (bt.isNullOrNil(((chi)localObject1).saB))) {
        break label593;
      }
      this.uyC.setSummary(((chi)localObject1).saB);
      str = "";
      localObject1 = str;
      if (!this.uxz.dbl().dbH())
      {
        localObject1 = this.uxz.uvN;
        if (localObject1 == null) {
          break label605;
        }
        this.uyB.setEnabled(true);
        this.uyB.setClickable(true);
        this.uyB.setSummary(com.tencent.mm.plugin.product.b.b.a(this, (aec)localObject1));
        localObject1 = getString(2131761145, new Object[] { com.tencent.mm.plugin.product.b.b.c(((aec)localObject1).CNG, ((aec)localObject1).PriceType) });
        this.uyA.setVisibility(8);
      }
      label280:
      str = "";
      int i = this.uxz.dbp();
      if (i > 0)
      {
        bt.isNullOrNil((String)localObject1);
        str = getString(2131761144, new Object[] { com.tencent.mm.plugin.product.b.b.c(i, localm.uwm.uop) });
      }
      Object localObject2 = this.uxz.av(this);
      if (((LinkedList)localObject2).size() <= 0) {
        break label648;
      }
      this.uyH.setVisibility(0);
      this.uyI.eu((List)localObject2);
      this.uyI.notifyDataSetChanged();
      label369:
      localObject2 = this.uxz.uvO;
      if (localObject2 != null) {
        this.uyz.setText(Html.fromHtml(String.format("%s %s<br><br>%s %s %s", new Object[] { ((df)localObject2).mAQ, ((df)localObject2).CxQ, ((df)localObject2).ijN, ((df)localObject2).ijO, ((df)localObject2).saB })));
      }
      localObject1 = (String)localObject1 + str;
      if (bt.isNullOrNil((String)localObject1)) {
        break label660;
      }
      localObject1 = getString(2131761143, new Object[] { localObject1 });
      this.uyE.setText((CharSequence)localObject1);
      this.uyF.setVisibility(8);
      this.uyE.setVisibility(0);
    }
    for (;;)
    {
      this.uyG.setText(com.tencent.mm.plugin.product.b.b.c(this.uxz.dbo(), localm.uwm.uop));
      this.iwY.setEnabled(this.uxz.dbx());
      AppMethodBeat.o(67058);
      return;
      this.uyc.setText(com.tencent.mm.plugin.product.b.b.D(localm.uwm.uwx, localm.uwm.uwy, localm.uwm.uop));
      break;
      label593:
      this.uyC.setSummary("");
      break label187;
      label605:
      this.uyB.setEnabled(false);
      this.uyB.setClickable(false);
      this.uyB.setSummary(getString(2131761146));
      this.uyA.setVisibility(0);
      localObject1 = str;
      break label280;
      label648:
      this.uyH.setVisibility(8);
      break label369;
      label660:
      this.uyF.setVisibility(0);
      this.uyE.setVisibility(8);
    }
  }
  
  public int getLayoutId()
  {
    return 2131495131;
  }
  
  public void initView()
  {
    AppMethodBeat.i(67057);
    setMMTitle(2131761149);
    this.uyy = ((RelativeLayout)findViewById(2131302115));
    this.uyz = ((TextView)findViewById(2131302117));
    this.uyA = ((TextView)findViewById(2131302116));
    this.uyB = ((MallProductItemView)findViewById(2131302119));
    this.uyC = ((MallProductItemView)findViewById(2131302121));
    this.uyb = ((ImageView)findViewById(2131302120));
    this.kEu = ((TextView)findViewById(2131302128));
    this.uyD = ((TextView)findViewById(2131302122));
    this.uyc = ((TextView)findViewById(2131302126));
    this.uyE = ((TextView)findViewById(2131302125));
    this.uyF = ((TextView)findViewById(2131302124));
    this.uyG = ((TextView)findViewById(2131302129));
    this.uyH = ((ListView)findViewById(2131302123));
    this.uyI = new a(this);
    this.uyH.setAdapter(this.uyI);
    this.uyH.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(67047);
        paramAnonymousAdapterView = (b)paramAnonymousView.getTag();
        switch (paramAnonymousAdapterView.type)
        {
        }
        for (;;)
        {
          MallProductSubmitUI.c(MallProductSubmitUI.this).a(MallProductSubmitUI.this, paramAnonymousView, paramAnonymousInt);
          AppMethodBeat.o(67047);
          return;
          Object localObject = MallProductSubmitUI.b(MallProductSubmitUI.this).uvI;
          if ((((m)localObject).uwm.uwz != null) && (((m)localObject).uwm.uwz.size() > 0))
          {
            ArrayList localArrayList = new ArrayList();
            localObject = ((m)localObject).uwm.uwz.iterator();
            while (((Iterator)localObject).hasNext()) {
              localArrayList.add((String)((Iterator)localObject).next());
            }
            paramAnonymousAdapterView.uxi = localArrayList;
            continue;
            if ((paramAnonymousAdapterView.uxi instanceof String)) {
              MallProductSubmitUI.b(MallProductSubmitUI.this).uvR = ((String)paramAnonymousAdapterView.uxi);
            }
          }
        }
      }
    });
    this.iwY = ((Button)findViewById(2131302127));
    this.iwY.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67048);
        paramAnonymousView = MallProductSubmitUI.d(MallProductSubmitUI.this);
        if (paramAnonymousView.uxz.dbx())
        {
          if (paramAnonymousView.uxz.dbo() == 0) {}
          for (int i = 1; i != 0; i = 0)
          {
            g.afC();
            g.afA().gcy.a(new k(paramAnonymousView.uxz.dbz()), 0);
            AppMethodBeat.o(67048);
            return;
          }
          g.afC();
          g.afA().gcy.a(new l(paramAnonymousView.uxz.dbz(), paramAnonymousView.uxz.getAppId()), 0);
        }
        AppMethodBeat.o(67048);
      }
    });
    this.uyy.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67049);
        paramAnonymousView = MallProductSubmitUI.d(MallProductSubmitUI.this);
        Intent localIntent = new Intent();
        localIntent.putExtra("launch_from_webview", true);
        com.tencent.mm.bs.d.a(paramAnonymousView.jgS, "address", ".ui.WalletSelectAddrUI", localIntent, 1, false);
        AppMethodBeat.o(67049);
      }
    });
    this.uyB.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67050);
        MallProductSubmitUI.this.showDialog(1);
        AppMethodBeat.o(67050);
      }
    });
    this.uyC.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67051);
        paramAnonymousView = MallProductSubmitUI.d(MallProductSubmitUI.this);
        Intent localIntent = new Intent(paramAnonymousView.jgS, MallProductReceiptUI.class);
        paramAnonymousView.jgS.startActivityForResult(localIntent, 4);
        AppMethodBeat.o(67051);
      }
    });
    MallProductItemView localMallProductItemView = this.uyC;
    boolean bool;
    if ((this.uxz.dbl().uxw & 0x2) > 0)
    {
      bool = true;
      ad.d("MicroMsg.MallProductConfig", "hasReceipt, ret = ".concat(String.valueOf(bool)));
      if (!bool) {
        break label411;
      }
    }
    label411:
    for (int i = 0;; i = 8)
    {
      localMallProductItemView.setVisibility(i);
      if (this.uxz.dbl().dbH())
      {
        this.uyB.setEnabled(false);
        this.uyB.setClickable(false);
        this.uyB.setSummary(getString(2131761147));
      }
      AppMethodBeat.o(67057);
      return;
      bool = false;
      break;
    }
  }
  
  public final void l(String paramString, final Bitmap paramBitmap)
  {
    AppMethodBeat.i(67060);
    paramString = new StringBuilder().append(paramString).append(", bitmap = ");
    if (paramBitmap == null) {}
    for (boolean bool = true;; bool = false)
    {
      ad.d("MicroMsg.MallProductSubmitUI", bool);
      if (!bt.isNullOrNil(this.uxz.dbm())) {
        break;
      }
      AppMethodBeat.o(67060);
      return;
    }
    this.uyb.post(new Runnable()
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
    this.uyi.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(67059);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(67054);
    super.onCreate(paramBundle);
    this.uyi = new f(getContext(), new f.a()
    {
      public final void E(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString)
      {
        AppMethodBeat.i(67046);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          MallProductSubmitUI.a(MallProductSubmitUI.this);
          AppMethodBeat.o(67046);
          return;
        }
        MallProductSubmitUI.this.akw(paramAnonymousString);
        AppMethodBeat.o(67046);
      }
    });
    com.tencent.mm.plugin.product.a.a.dbi();
    this.uxz = com.tencent.mm.plugin.product.a.a.dbj();
    this.uvX = this.uxz.uvX;
    initView();
    cE();
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
      localObject2 = this.uxz.uvV;
    } while (localObject2 == null);
    Object localObject1 = new ArrayList();
    Object localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((List)localObject1).add(com.tencent.mm.plugin.product.b.b.a(this, (aec)((Iterator)localObject2).next()));
    }
    localObject2 = getString(2131761138);
    AdapterView.OnItemClickListener local8 = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(67053);
        MallProductSubmitUI.this.dismissDialog(1);
        MallProductSubmitUI.b(MallProductSubmitUI.this).IY(paramAnonymousInt);
        MallProductSubmitUI.a(MallProductSubmitUI.this);
        AppMethodBeat.o(67053);
      }
    };
    d.a locala = new d.a(this);
    ListViewInScrollView localListViewInScrollView = (ListViewInScrollView)View.inflate(this, 2131494797, null);
    localListViewInScrollView.setOnItemClickListener(new d.1(local8, locala));
    locala.aHT = ((List)localObject1);
    locala.uxs = 0;
    localListViewInScrollView.setAdapter(locala);
    localObject1 = new com.tencent.mm.ui.widget.a.d.a(this);
    ((com.tencent.mm.ui.widget.a.d.a)localObject1).aMf((String)localObject2);
    ((com.tencent.mm.ui.widget.a.d.a)localObject1).gs(localListViewInScrollView);
    ((com.tencent.mm.ui.widget.a.d.a)localObject1).e(null);
    localObject1 = ((com.tencent.mm.ui.widget.a.d.a)localObject1).fft();
    ((com.tencent.mm.ui.widget.a.d)localObject1).show();
    AppMethodBeat.o(67061);
    return localObject1;
  }
  
  public void onStart()
  {
    AppMethodBeat.i(67055);
    this.uyi.onStart();
    super.onStart();
    AppMethodBeat.o(67055);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(67056);
    this.uyi.onStop();
    super.onStop();
    AppMethodBeat.o(67056);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductSubmitUI
 * JD-Core Version:    0.7.0.1
 */