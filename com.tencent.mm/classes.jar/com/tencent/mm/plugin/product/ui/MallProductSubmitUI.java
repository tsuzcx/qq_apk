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
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.product.b.k;
import com.tencent.mm.plugin.product.b.l;
import com.tencent.mm.plugin.product.b.m;
import com.tencent.mm.protocal.protobuf.ahu;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.protocal.protobuf.di;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.ListViewInScrollView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MallProductSubmitUI
  extends MallBaseUI
  implements u.a
{
  private Button jtd;
  private TextView lHk;
  private com.tencent.mm.plugin.product.b.e xbK;
  private ImageView xdP;
  private TextView xdQ;
  private f xdW;
  private com.tencent.mm.plugin.product.b.c xdn;
  private RelativeLayout xem;
  private TextView xen;
  private TextView xeo;
  private MallProductItemView xep;
  private MallProductItemView xeq;
  private TextView xer;
  private TextView xes;
  private TextView xet;
  private TextView xeu;
  private ListView xev;
  private a xew;
  
  private void updateView()
  {
    AppMethodBeat.i(67058);
    m localm = this.xdn.xbv;
    Object localObject1;
    label187:
    String str;
    if (this.xbK != null)
    {
      this.xdQ.setText(com.tencent.mm.plugin.product.b.b.D(this.xbK.xbO, this.xbK.xbO, localm.xbZ.wSq) + " x " + this.xdn.mCount);
      if (!bu.isNullOrNil(this.xdn.dCN()))
      {
        localObject1 = u.a(new c(this.xdn.dCN()));
        this.xdP.setImageBitmap((Bitmap)localObject1);
        u.a(this);
      }
      this.lHk.setText(localm.xbZ.name);
      this.xer.setText(this.xdn.dCO());
      localObject1 = this.xdn.dCR();
      if ((localObject1 == null) || (bu.isNullOrNil(((csg)localObject1).urL))) {
        break label594;
      }
      this.xeq.setSummary(((csg)localObject1).urL);
      str = "";
      localObject1 = str;
      if (!this.xdn.dCM().dDi())
      {
        localObject1 = this.xdn.xbA;
        if (localObject1 == null) {
          break label606;
        }
        this.xep.setEnabled(true);
        this.xep.setClickable(true);
        this.xep.setSummary(com.tencent.mm.plugin.product.b.b.a(this, (ahu)localObject1));
        localObject1 = getString(2131761145, new Object[] { com.tencent.mm.plugin.product.b.b.c(((ahu)localObject1).Gfg, ((ahu)localObject1).PriceType) });
        this.xeo.setVisibility(8);
      }
      label280:
      str = "";
      int i = this.xdn.dCQ();
      if (i > 0)
      {
        bu.isNullOrNil((String)localObject1);
        str = getString(2131761144, new Object[] { com.tencent.mm.plugin.product.b.b.c(i, localm.xbZ.wSq) });
      }
      Object localObject2 = this.xdn.aA(this);
      if (((LinkedList)localObject2).size() <= 0) {
        break label649;
      }
      this.xev.setVisibility(0);
      this.xew.eT((List)localObject2);
      this.xew.notifyDataSetChanged();
      label370:
      localObject2 = this.xdn.xbB;
      if (localObject2 != null) {
        this.xen.setText(Html.fromHtml(String.format("%s %s<br><br>%s %s %s", new Object[] { ((di)localObject2).nIJ, ((di)localObject2).FNZ, ((di)localObject2).jfW, ((di)localObject2).jfX, ((di)localObject2).urL })));
      }
      localObject1 = (String)localObject1 + str;
      if (bu.isNullOrNil((String)localObject1)) {
        break label661;
      }
      localObject1 = getString(2131761143, new Object[] { localObject1 });
      this.xes.setText((CharSequence)localObject1);
      this.xet.setVisibility(8);
      this.xes.setVisibility(0);
    }
    for (;;)
    {
      this.xeu.setText(com.tencent.mm.plugin.product.b.b.c(this.xdn.dCP(), localm.xbZ.wSq));
      this.jtd.setEnabled(this.xdn.dCY());
      AppMethodBeat.o(67058);
      return;
      this.xdQ.setText(com.tencent.mm.plugin.product.b.b.D(localm.xbZ.xck, localm.xbZ.xcl, localm.xbZ.wSq));
      break;
      label594:
      this.xeq.setSummary("");
      break label187;
      label606:
      this.xep.setEnabled(false);
      this.xep.setClickable(false);
      this.xep.setSummary(getString(2131761146));
      this.xeo.setVisibility(0);
      localObject1 = str;
      break label280;
      label649:
      this.xev.setVisibility(8);
      break label370;
      label661:
      this.xet.setVisibility(0);
      this.xes.setVisibility(8);
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
    this.xem = ((RelativeLayout)findViewById(2131302115));
    this.xen = ((TextView)findViewById(2131302117));
    this.xeo = ((TextView)findViewById(2131302116));
    this.xep = ((MallProductItemView)findViewById(2131302119));
    this.xeq = ((MallProductItemView)findViewById(2131302121));
    this.xdP = ((ImageView)findViewById(2131302120));
    this.lHk = ((TextView)findViewById(2131302128));
    this.xer = ((TextView)findViewById(2131302122));
    this.xdQ = ((TextView)findViewById(2131302126));
    this.xes = ((TextView)findViewById(2131302125));
    this.xet = ((TextView)findViewById(2131302124));
    this.xeu = ((TextView)findViewById(2131302129));
    this.xev = ((ListView)findViewById(2131302123));
    this.xew = new a(this);
    this.xev.setAdapter(this.xew);
    this.xev.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(67047);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).mu(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).rl(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/product/ui/MallProductSubmitUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
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
          Object localObject2 = MallProductSubmitUI.b(MallProductSubmitUI.this).xbv;
          if ((((m)localObject2).xbZ.xcm != null) && (((m)localObject2).xbZ.xcm.size() > 0))
          {
            localObject1 = new ArrayList();
            localObject2 = ((m)localObject2).xbZ.xcm.iterator();
            while (((Iterator)localObject2).hasNext()) {
              ((ArrayList)localObject1).add((String)((Iterator)localObject2).next());
            }
            paramAnonymousAdapterView.xcV = localObject1;
            continue;
            if ((paramAnonymousAdapterView.xcV instanceof String)) {
              MallProductSubmitUI.b(MallProductSubmitUI.this).xbE = ((String)paramAnonymousAdapterView.xcV);
            }
          }
        }
      }
    });
    this.jtd = ((Button)findViewById(2131302127));
    this.jtd.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67048);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/product/ui/MallProductSubmitUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramAnonymousView = MallProductSubmitUI.d(MallProductSubmitUI.this);
        int i;
        if (paramAnonymousView.xdn.dCY())
        {
          if (paramAnonymousView.xdn.dCP() != 0) {
            break label115;
          }
          i = 1;
          if (i == 0) {
            break label120;
          }
          g.ajS();
          g.ajQ().gDv.a(new k(paramAnonymousView.xdn.dDa()), 0);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/product/ui/MallProductSubmitUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(67048);
          return;
          label115:
          i = 0;
          break;
          label120:
          g.ajS();
          g.ajQ().gDv.a(new l(paramAnonymousView.xdn.dDa(), paramAnonymousView.xdn.getAppId()), 0);
        }
      }
    });
    this.xem.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67049);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/product/ui/MallProductSubmitUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        paramAnonymousView = MallProductSubmitUI.d(MallProductSubmitUI.this);
        localObject = new Intent();
        ((Intent)localObject).putExtra("launch_from_webview", true);
        com.tencent.mm.br.d.a(paramAnonymousView.keK, "address", ".ui.WalletSelectAddrUI", (Intent)localObject, 1, false);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/product/ui/MallProductSubmitUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(67049);
      }
    });
    this.xep.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67050);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/product/ui/MallProductSubmitUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        MallProductSubmitUI.this.showDialog(1);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/product/ui/MallProductSubmitUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(67050);
      }
    });
    this.xeq.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67051);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/product/ui/MallProductSubmitUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        paramAnonymousView = MallProductSubmitUI.d(MallProductSubmitUI.this);
        localObject = new Intent(paramAnonymousView.keK, MallProductReceiptUI.class);
        paramAnonymousView.keK.startActivityForResult((Intent)localObject, 4);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/product/ui/MallProductSubmitUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(67051);
      }
    });
    MallProductItemView localMallProductItemView = this.xeq;
    boolean bool;
    if ((this.xdn.dCM().xdk & 0x2) > 0)
    {
      bool = true;
      ae.d("MicroMsg.MallProductConfig", "hasReceipt, ret = ".concat(String.valueOf(bool)));
      if (!bool) {
        break label411;
      }
    }
    label411:
    for (int i = 0;; i = 8)
    {
      localMallProductItemView.setVisibility(i);
      if (this.xdn.dCM().dDi())
      {
        this.xep.setEnabled(false);
        this.xep.setClickable(false);
        this.xep.setSummary(getString(2131761147));
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
      ae.d("MicroMsg.MallProductSubmitUI", bool);
      if (!bu.isNullOrNil(this.xdn.dCN())) {
        break;
      }
      AppMethodBeat.o(67060);
      return;
    }
    this.xdP.post(new Runnable()
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
    this.xdW.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(67059);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(67054);
    super.onCreate(paramBundle);
    this.xdW = new f(getContext(), new f.a()
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
        MallProductSubmitUI.this.avQ(paramAnonymousString);
        AppMethodBeat.o(67046);
      }
    });
    com.tencent.mm.plugin.product.a.a.dCJ();
    this.xdn = com.tencent.mm.plugin.product.a.a.dCK();
    this.xbK = this.xdn.xbK;
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
      localObject2 = this.xdn.xbI;
    } while (localObject2 == null);
    Object localObject1 = new ArrayList();
    Object localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((List)localObject1).add(com.tencent.mm.plugin.product.b.b.a(this, (ahu)((Iterator)localObject2).next()));
    }
    localObject2 = getString(2131761138);
    AdapterView.OnItemClickListener local8 = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(67053);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mu(paramAnonymousInt);
        localb.rl(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/product/ui/MallProductSubmitUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
        MallProductSubmitUI.this.dismissDialog(1);
        MallProductSubmitUI.b(MallProductSubmitUI.this).Ng(paramAnonymousInt);
        MallProductSubmitUI.a(MallProductSubmitUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/product/ui/MallProductSubmitUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(67053);
      }
    };
    d.a locala = new d.a(this);
    ListViewInScrollView localListViewInScrollView = (ListViewInScrollView)View.inflate(this, 2131494797, null);
    localListViewInScrollView.setOnItemClickListener(new d.1(local8, locala));
    locala.aKA = ((List)localObject1);
    locala.xdf = 0;
    localListViewInScrollView.setAdapter(locala);
    localObject1 = new com.tencent.mm.ui.widget.a.d.a(this);
    ((com.tencent.mm.ui.widget.a.d.a)localObject1).aZh((String)localObject2);
    ((com.tencent.mm.ui.widget.a.d.a)localObject1).hd(localListViewInScrollView);
    ((com.tencent.mm.ui.widget.a.d.a)localObject1).e(null);
    localObject1 = ((com.tencent.mm.ui.widget.a.d.a)localObject1).fQv();
    ((com.tencent.mm.ui.widget.a.d)localObject1).show();
    AppMethodBeat.o(67061);
    return localObject1;
  }
  
  public void onStart()
  {
    AppMethodBeat.i(67055);
    this.xdW.onStart();
    super.onStart();
    AppMethodBeat.o(67055);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(67056);
    this.xdW.onStop();
    super.onStop();
    AppMethodBeat.o(67056);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductSubmitUI
 * JD-Core Version:    0.7.0.1
 */