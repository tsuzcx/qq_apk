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
import com.tencent.mm.protocal.protobuf.ahk;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.protobuf.di;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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
  private Button jqk;
  private TextView lCL;
  private com.tencent.mm.plugin.product.b.e wLW;
  private com.tencent.mm.plugin.product.b.c wNz;
  private TextView wOA;
  private MallProductItemView wOB;
  private MallProductItemView wOC;
  private TextView wOD;
  private TextView wOE;
  private TextView wOF;
  private TextView wOG;
  private ListView wOH;
  private a wOI;
  private ImageView wOb;
  private TextView wOc;
  private f wOi;
  private RelativeLayout wOy;
  private TextView wOz;
  
  private void updateView()
  {
    AppMethodBeat.i(67058);
    m localm = this.wNz.wLH;
    Object localObject1;
    label187:
    String str;
    if (this.wLW != null)
    {
      this.wOc.setText(com.tencent.mm.plugin.product.b.b.D(this.wLW.wMa, this.wLW.wMa, localm.wMl.wCF) + " x " + this.wNz.mCount);
      if (!bt.isNullOrNil(this.wNz.dzw()))
      {
        localObject1 = u.a(new c(this.wNz.dzw()));
        this.wOb.setImageBitmap((Bitmap)localObject1);
        u.a(this);
      }
      this.lCL.setText(localm.wMl.name);
      this.wOD.setText(this.wNz.dzx());
      localObject1 = this.wNz.dzA();
      if ((localObject1 == null) || (bt.isNullOrNil(((crm)localObject1).ugo))) {
        break label593;
      }
      this.wOC.setSummary(((crm)localObject1).ugo);
      str = "";
      localObject1 = str;
      if (!this.wNz.dzv().dzR())
      {
        localObject1 = this.wNz.wLM;
        if (localObject1 == null) {
          break label605;
        }
        this.wOB.setEnabled(true);
        this.wOB.setClickable(true);
        this.wOB.setSummary(com.tencent.mm.plugin.product.b.b.a(this, (ahk)localObject1));
        localObject1 = getString(2131761145, new Object[] { com.tencent.mm.plugin.product.b.b.c(((ahk)localObject1).FMH, ((ahk)localObject1).PriceType) });
        this.wOA.setVisibility(8);
      }
      label280:
      str = "";
      int i = this.wNz.dzz();
      if (i > 0)
      {
        bt.isNullOrNil((String)localObject1);
        str = getString(2131761144, new Object[] { com.tencent.mm.plugin.product.b.b.c(i, localm.wMl.wCF) });
      }
      Object localObject2 = this.wNz.az(this);
      if (((LinkedList)localObject2).size() <= 0) {
        break label648;
      }
      this.wOH.setVisibility(0);
      this.wOI.eL((List)localObject2);
      this.wOI.notifyDataSetChanged();
      label369:
      localObject2 = this.wNz.wLN;
      if (localObject2 != null) {
        this.wOz.setText(Html.fromHtml(String.format("%s %s<br><br>%s %s %s", new Object[] { ((di)localObject2).nDo, ((di)localObject2).FvB, ((di)localObject2).jdd, ((di)localObject2).jde, ((di)localObject2).ugo })));
      }
      localObject1 = (String)localObject1 + str;
      if (bt.isNullOrNil((String)localObject1)) {
        break label660;
      }
      localObject1 = getString(2131761143, new Object[] { localObject1 });
      this.wOE.setText((CharSequence)localObject1);
      this.wOF.setVisibility(8);
      this.wOE.setVisibility(0);
    }
    for (;;)
    {
      this.wOG.setText(com.tencent.mm.plugin.product.b.b.c(this.wNz.dzy(), localm.wMl.wCF));
      this.jqk.setEnabled(this.wNz.dzH());
      AppMethodBeat.o(67058);
      return;
      this.wOc.setText(com.tencent.mm.plugin.product.b.b.D(localm.wMl.wMw, localm.wMl.wMx, localm.wMl.wCF));
      break;
      label593:
      this.wOC.setSummary("");
      break label187;
      label605:
      this.wOB.setEnabled(false);
      this.wOB.setClickable(false);
      this.wOB.setSummary(getString(2131761146));
      this.wOA.setVisibility(0);
      localObject1 = str;
      break label280;
      label648:
      this.wOH.setVisibility(8);
      break label369;
      label660:
      this.wOF.setVisibility(0);
      this.wOE.setVisibility(8);
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
    this.wOy = ((RelativeLayout)findViewById(2131302115));
    this.wOz = ((TextView)findViewById(2131302117));
    this.wOA = ((TextView)findViewById(2131302116));
    this.wOB = ((MallProductItemView)findViewById(2131302119));
    this.wOC = ((MallProductItemView)findViewById(2131302121));
    this.wOb = ((ImageView)findViewById(2131302120));
    this.lCL = ((TextView)findViewById(2131302128));
    this.wOD = ((TextView)findViewById(2131302122));
    this.wOc = ((TextView)findViewById(2131302126));
    this.wOE = ((TextView)findViewById(2131302125));
    this.wOF = ((TextView)findViewById(2131302124));
    this.wOG = ((TextView)findViewById(2131302129));
    this.wOH = ((ListView)findViewById(2131302123));
    this.wOI = new a(this);
    this.wOH.setAdapter(this.wOI);
    this.wOH.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(67047);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).mr(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).qY(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/product/ui/MallProductSubmitUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
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
          Object localObject2 = MallProductSubmitUI.b(MallProductSubmitUI.this).wLH;
          if ((((m)localObject2).wMl.wMy != null) && (((m)localObject2).wMl.wMy.size() > 0))
          {
            localObject1 = new ArrayList();
            localObject2 = ((m)localObject2).wMl.wMy.iterator();
            while (((Iterator)localObject2).hasNext()) {
              ((ArrayList)localObject1).add((String)((Iterator)localObject2).next());
            }
            paramAnonymousAdapterView.wNh = localObject1;
            continue;
            if ((paramAnonymousAdapterView.wNh instanceof String)) {
              MallProductSubmitUI.b(MallProductSubmitUI.this).wLQ = ((String)paramAnonymousAdapterView.wNh);
            }
          }
        }
      }
    });
    this.jqk = ((Button)findViewById(2131302127));
    this.jqk.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67048);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/product/ui/MallProductSubmitUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = MallProductSubmitUI.d(MallProductSubmitUI.this);
        int i;
        if (paramAnonymousView.wNz.dzH())
        {
          if (paramAnonymousView.wNz.dzy() != 0) {
            break label115;
          }
          i = 1;
          if (i == 0) {
            break label120;
          }
          g.ajD();
          g.ajB().gAO.a(new k(paramAnonymousView.wNz.dzJ()), 0);
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
          g.ajD();
          g.ajB().gAO.a(new l(paramAnonymousView.wNz.dzJ(), paramAnonymousView.wNz.getAppId()), 0);
        }
      }
    });
    this.wOy.setOnClickListener(new MallProductSubmitUI.4(this));
    this.wOB.setOnClickListener(new MallProductSubmitUI.5(this));
    this.wOC.setOnClickListener(new MallProductSubmitUI.6(this));
    MallProductItemView localMallProductItemView = this.wOC;
    boolean bool;
    if ((this.wNz.dzv().wNw & 0x2) > 0)
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
      if (this.wNz.dzv().dzR())
      {
        this.wOB.setEnabled(false);
        this.wOB.setClickable(false);
        this.wOB.setSummary(getString(2131761147));
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
      ad.d("MicroMsg.MallProductSubmitUI", bool);
      if (!bt.isNullOrNil(this.wNz.dzw())) {
        break;
      }
      AppMethodBeat.o(67060);
      return;
    }
    this.wOb.post(new Runnable()
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
    this.wOi.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(67059);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(67054);
    super.onCreate(paramBundle);
    this.wOi = new f(getContext(), new f.a()
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
        MallProductSubmitUI.this.auB(paramAnonymousString);
        AppMethodBeat.o(67046);
      }
    });
    com.tencent.mm.plugin.product.a.a.dzs();
    this.wNz = com.tencent.mm.plugin.product.a.a.dzt();
    this.wLW = this.wNz.wLW;
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
      localObject2 = this.wNz.wLU;
    } while (localObject2 == null);
    Object localObject1 = new ArrayList();
    Object localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((List)localObject1).add(com.tencent.mm.plugin.product.b.b.a(this, (ahk)((Iterator)localObject2).next()));
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
        localb.mr(paramAnonymousInt);
        localb.qY(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/product/ui/MallProductSubmitUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
        MallProductSubmitUI.this.dismissDialog(1);
        MallProductSubmitUI.b(MallProductSubmitUI.this).MA(paramAnonymousInt);
        MallProductSubmitUI.a(MallProductSubmitUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/product/ui/MallProductSubmitUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(67053);
      }
    };
    d.a locala = new d.a(this);
    ListViewInScrollView localListViewInScrollView = (ListViewInScrollView)View.inflate(this, 2131494797, null);
    localListViewInScrollView.setOnItemClickListener(new d.1(local8, locala));
    locala.aKA = ((List)localObject1);
    locala.wNr = 0;
    localListViewInScrollView.setAdapter(locala);
    localObject1 = new com.tencent.mm.ui.widget.a.d.a(this);
    ((com.tencent.mm.ui.widget.a.d.a)localObject1).aXF((String)localObject2);
    ((com.tencent.mm.ui.widget.a.d.a)localObject1).gY(localListViewInScrollView);
    ((com.tencent.mm.ui.widget.a.d.a)localObject1).e(null);
    localObject1 = ((com.tencent.mm.ui.widget.a.d.a)localObject1).fMb();
    ((d)localObject1).show();
    AppMethodBeat.o(67061);
    return localObject1;
  }
  
  public void onStart()
  {
    AppMethodBeat.i(67055);
    this.wOi.onStart();
    super.onStart();
    AppMethodBeat.o(67055);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(67056);
    this.wOi.onStop();
    super.onStop();
    AppMethodBeat.o(67056);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductSubmitUI
 * JD-Core Version:    0.7.0.1
 */