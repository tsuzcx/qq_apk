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
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.product.b.k;
import com.tencent.mm.plugin.product.b.l;
import com.tencent.mm.plugin.product.b.m;
import com.tencent.mm.protocal.protobuf.akg;
import com.tencent.mm.protocal.protobuf.dki;
import com.tencent.mm.protocal.protobuf.dr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
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
  private com.tencent.mm.plugin.product.b.e AZm;
  private com.tencent.mm.plugin.product.b.c BaP;
  private RelativeLayout BbO;
  private TextView BbP;
  private TextView BbQ;
  private MallProductItemView BbR;
  private MallProductItemView BbS;
  private TextView BbT;
  private TextView BbU;
  private TextView BbV;
  private TextView BbW;
  private ListView BbX;
  private a BbY;
  private ImageView Bbr;
  private TextView Bbs;
  private f Bby;
  private Button krs;
  private TextView mPa;
  
  private void updateView()
  {
    AppMethodBeat.i(67058);
    m localm = this.BaP.AYX;
    Object localObject1;
    label187:
    String str;
    if (this.AZm != null)
    {
      this.Bbs.setText(com.tencent.mm.plugin.product.b.b.C(this.AZm.AZq, this.AZm.AZq, localm.AZB.AOl) + " x " + this.BaP.mCount);
      if (!Util.isNullOrNil(this.BaP.eDf()))
      {
        localObject1 = u.a(new c(this.BaP.eDf()));
        this.Bbr.setImageBitmap((Bitmap)localObject1);
        u.a(this);
      }
      this.mPa.setText(localm.AZB.name);
      this.BbT.setText(this.BaP.eDg());
      localObject1 = this.BaP.eDj();
      if ((localObject1 == null) || (Util.isNullOrNil(((dki)localObject1).xKd))) {
        break label593;
      }
      this.BbS.setSummary(((dki)localObject1).xKd);
      str = "";
      localObject1 = str;
      if (!this.BaP.eDe().eDA())
      {
        localObject1 = this.BaP.AZc;
        if (localObject1 == null) {
          break label605;
        }
        this.BbR.setEnabled(true);
        this.BbR.setClickable(true);
        this.BbR.setSummary(com.tencent.mm.plugin.product.b.b.a(this, (akg)localObject1));
        localObject1 = getString(2131762932, new Object[] { com.tencent.mm.plugin.product.b.b.c(((akg)localObject1).KZx, ((akg)localObject1).PriceType) });
        this.BbQ.setVisibility(8);
      }
      label280:
      str = "";
      int i = this.BaP.eDi();
      if (i > 0)
      {
        Util.isNullOrNil((String)localObject1);
        str = getString(2131762931, new Object[] { com.tencent.mm.plugin.product.b.b.c(i, localm.AZB.AOl) });
      }
      Object localObject2 = this.BaP.aB(this);
      if (((LinkedList)localObject2).size() <= 0) {
        break label648;
      }
      this.BbX.setVisibility(0);
      this.BbY.fO((List)localObject2);
      this.BbY.notifyDataSetChanged();
      label369:
      localObject2 = this.BaP.AZd;
      if (localObject2 != null) {
        this.BbP.setText(Html.fromHtml(String.format("%s %s<br><br>%s %s %s", new Object[] { ((dr)localObject2).UserName, ((dr)localObject2).KHE, ((dr)localObject2).kdZ, ((dr)localObject2).kea, ((dr)localObject2).xKd })));
      }
      localObject1 = (String)localObject1 + str;
      if (Util.isNullOrNil((String)localObject1)) {
        break label660;
      }
      localObject1 = getString(2131762930, new Object[] { localObject1 });
      this.BbU.setText((CharSequence)localObject1);
      this.BbV.setVisibility(8);
      this.BbU.setVisibility(0);
    }
    for (;;)
    {
      this.BbW.setText(com.tencent.mm.plugin.product.b.b.c(this.BaP.eDh(), localm.AZB.AOl));
      this.krs.setEnabled(this.BaP.eDq());
      AppMethodBeat.o(67058);
      return;
      this.Bbs.setText(com.tencent.mm.plugin.product.b.b.C(localm.AZB.AZM, localm.AZB.AZN, localm.AZB.AOl));
      break;
      label593:
      this.BbS.setSummary("");
      break label187;
      label605:
      this.BbR.setEnabled(false);
      this.BbR.setClickable(false);
      this.BbR.setSummary(getString(2131762933));
      this.BbQ.setVisibility(0);
      localObject1 = str;
      break label280;
      label648:
      this.BbX.setVisibility(8);
      break label369;
      label660:
      this.BbV.setVisibility(0);
      this.BbU.setVisibility(8);
    }
  }
  
  public int getLayoutId()
  {
    return 2131495974;
  }
  
  public void initView()
  {
    AppMethodBeat.i(67057);
    setMMTitle(2131762936);
    this.BbO = ((RelativeLayout)findViewById(2131304454));
    this.BbP = ((TextView)findViewById(2131304456));
    this.BbQ = ((TextView)findViewById(2131304455));
    this.BbR = ((MallProductItemView)findViewById(2131304458));
    this.BbS = ((MallProductItemView)findViewById(2131304460));
    this.Bbr = ((ImageView)findViewById(2131304459));
    this.mPa = ((TextView)findViewById(2131304467));
    this.BbT = ((TextView)findViewById(2131304461));
    this.Bbs = ((TextView)findViewById(2131304465));
    this.BbU = ((TextView)findViewById(2131304464));
    this.BbV = ((TextView)findViewById(2131304463));
    this.BbW = ((TextView)findViewById(2131304468));
    this.BbX = ((ListView)findViewById(2131304462));
    this.BbY = new a(this);
    this.BbX.setAdapter(this.BbY);
    this.BbX.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(67047);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).pH(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).zo(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/product/ui/MallProductSubmitUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
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
          Object localObject2 = MallProductSubmitUI.b(MallProductSubmitUI.this).AYX;
          if ((((m)localObject2).AZB.AZO != null) && (((m)localObject2).AZB.AZO.size() > 0))
          {
            localObject1 = new ArrayList();
            localObject2 = ((m)localObject2).AZB.AZO.iterator();
            while (((Iterator)localObject2).hasNext()) {
              ((ArrayList)localObject1).add((String)((Iterator)localObject2).next());
            }
            paramAnonymousAdapterView.Bax = localObject1;
            continue;
            if ((paramAnonymousAdapterView.Bax instanceof String)) {
              MallProductSubmitUI.b(MallProductSubmitUI.this).AZg = ((String)paramAnonymousAdapterView.Bax);
            }
          }
        }
      }
    });
    this.krs = ((Button)findViewById(2131304466));
    this.krs.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67048);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/product/ui/MallProductSubmitUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = MallProductSubmitUI.d(MallProductSubmitUI.this);
        int i;
        if (paramAnonymousView.BaP.eDq())
        {
          if (paramAnonymousView.BaP.eDh() != 0) {
            break label115;
          }
          i = 1;
          if (i == 0) {
            break label120;
          }
          g.aAi();
          g.aAg().hqi.a(new k(paramAnonymousView.BaP.eDs()), 0);
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
          g.aAi();
          g.aAg().hqi.a(new l(paramAnonymousView.BaP.eDs(), paramAnonymousView.BaP.getAppId()), 0);
        }
      }
    });
    this.BbO.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67049);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/product/ui/MallProductSubmitUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        paramAnonymousView = MallProductSubmitUI.d(MallProductSubmitUI.this);
        localObject = new Intent();
        ((Intent)localObject).putExtra("launch_from_webview", true);
        com.tencent.mm.br.c.a(paramAnonymousView.mContext, "address", ".ui.WalletSelectAddrUI", (Intent)localObject, 1, false);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/product/ui/MallProductSubmitUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(67049);
      }
    });
    this.BbR.setOnClickListener(new MallProductSubmitUI.5(this));
    this.BbS.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67051);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/product/ui/MallProductSubmitUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        paramAnonymousView = MallProductSubmitUI.d(MallProductSubmitUI.this);
        localObject = new Intent(paramAnonymousView.mContext, MallProductReceiptUI.class);
        paramAnonymousView.mContext.startActivityForResult((Intent)localObject, 4);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/product/ui/MallProductSubmitUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(67051);
      }
    });
    MallProductItemView localMallProductItemView = this.BbS;
    boolean bool;
    if ((this.BaP.eDe().BaM & 0x2) > 0)
    {
      bool = true;
      Log.d("MicroMsg.MallProductConfig", "hasReceipt, ret = ".concat(String.valueOf(bool)));
      if (!bool) {
        break label411;
      }
    }
    label411:
    for (int i = 0;; i = 8)
    {
      localMallProductItemView.setVisibility(i);
      if (this.BaP.eDe().eDA())
      {
        this.BbR.setEnabled(false);
        this.BbR.setClickable(false);
        this.BbR.setSummary(getString(2131762934));
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
      Log.d("MicroMsg.MallProductSubmitUI", bool);
      if (!Util.isNullOrNil(this.BaP.eDf())) {
        break;
      }
      AppMethodBeat.o(67060);
      return;
    }
    this.Bbr.post(new Runnable()
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
    this.Bby.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(67059);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(67054);
    super.onCreate(paramBundle);
    this.Bby = new f(getContext(), new f.a()
    {
      public final void D(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString)
      {
        AppMethodBeat.i(67046);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          MallProductSubmitUI.a(MallProductSubmitUI.this);
          AppMethodBeat.o(67046);
          return;
        }
        MallProductSubmitUI.this.aKi(paramAnonymousString);
        AppMethodBeat.o(67046);
      }
    });
    com.tencent.mm.plugin.product.a.a.eDb();
    this.BaP = com.tencent.mm.plugin.product.a.a.eDc();
    this.AZm = this.BaP.AZm;
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
      localObject2 = this.BaP.AZk;
    } while (localObject2 == null);
    Object localObject1 = new ArrayList();
    Object localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((List)localObject1).add(com.tencent.mm.plugin.product.b.b.a(this, (akg)((Iterator)localObject2).next()));
    }
    localObject2 = getString(2131762925);
    AdapterView.OnItemClickListener local8 = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(67053);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousAdapterView);
        localb.bm(paramAnonymousView);
        localb.pH(paramAnonymousInt);
        localb.zo(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/product/ui/MallProductSubmitUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
        MallProductSubmitUI.this.dismissDialog(1);
        MallProductSubmitUI.b(MallProductSubmitUI.this).Ut(paramAnonymousInt);
        MallProductSubmitUI.a(MallProductSubmitUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/product/ui/MallProductSubmitUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(67053);
      }
    };
    d.a locala = new d.a(this);
    ListViewInScrollView localListViewInScrollView = (ListViewInScrollView)View.inflate(this, 2131495531, null);
    localListViewInScrollView.setOnItemClickListener(new d.1(local8, locala));
    locala.aKs = ((List)localObject1);
    locala.BaH = 0;
    localListViewInScrollView.setAdapter(locala);
    localObject1 = new com.tencent.mm.ui.widget.a.d.a(this);
    ((com.tencent.mm.ui.widget.a.d.a)localObject1).bon((String)localObject2);
    ((com.tencent.mm.ui.widget.a.d.a)localObject1).hs(localListViewInScrollView);
    ((com.tencent.mm.ui.widget.a.d.a)localObject1).f(null);
    localObject1 = ((com.tencent.mm.ui.widget.a.d.a)localObject1).hbn();
    ((d)localObject1).show();
    AppMethodBeat.o(67061);
    return localObject1;
  }
  
  public void onStart()
  {
    AppMethodBeat.i(67055);
    this.Bby.onStart();
    super.onStart();
    AppMethodBeat.o(67055);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(67056);
    this.Bby.onStop();
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