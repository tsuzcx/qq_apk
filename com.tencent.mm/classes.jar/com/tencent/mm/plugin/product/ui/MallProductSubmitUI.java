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
import com.tencent.mm.protocal.protobuf.afb;
import com.tencent.mm.protocal.protobuf.cml;
import com.tencent.mm.protocal.protobuf.dh;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.ListViewInScrollView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MallProductSubmitUI
  extends MallBaseUI
  implements u.a
{
  private Button iXb;
  private TextView lfN;
  private com.tencent.mm.plugin.product.b.e vEQ;
  private ImageView vGU;
  private TextView vGV;
  private com.tencent.mm.plugin.product.b.c vGs;
  private ListView vHA;
  private a vHB;
  private f vHb;
  private RelativeLayout vHr;
  private TextView vHs;
  private TextView vHt;
  private MallProductItemView vHu;
  private MallProductItemView vHv;
  private TextView vHw;
  private TextView vHx;
  private TextView vHy;
  private TextView vHz;
  
  private void cL()
  {
    AppMethodBeat.i(67058);
    m localm = this.vGs.vEB;
    Object localObject1;
    label187:
    String str;
    if (this.vEQ != null)
    {
      this.vGV.setText(com.tencent.mm.plugin.product.b.b.C(this.vEQ.vEU, this.vEQ.vEU, localm.vFf.vxl) + " x " + this.vGs.mCount);
      if (!bs.isNullOrNil(this.vGs.doU()))
      {
        localObject1 = u.a(new c(this.vGs.doU()));
        this.vGU.setImageBitmap((Bitmap)localObject1);
        u.a(this);
      }
      this.lfN.setText(localm.vFf.name);
      this.vHw.setText(this.vGs.doV());
      localObject1 = this.vGs.doY();
      if ((localObject1 == null) || (bs.isNullOrNil(((cml)localObject1).tiv))) {
        break label593;
      }
      this.vHv.setSummary(((cml)localObject1).tiv);
      str = "";
      localObject1 = str;
      if (!this.vGs.doT().dpp())
      {
        localObject1 = this.vGs.vEG;
        if (localObject1 == null) {
          break label605;
        }
        this.vHu.setEnabled(true);
        this.vHu.setClickable(true);
        this.vHu.setSummary(com.tencent.mm.plugin.product.b.b.a(this, (afb)localObject1));
        localObject1 = getString(2131761145, new Object[] { com.tencent.mm.plugin.product.b.b.c(((afb)localObject1).Egi, ((afb)localObject1).PriceType) });
        this.vHt.setVisibility(8);
      }
      label280:
      str = "";
      int i = this.vGs.doX();
      if (i > 0)
      {
        bs.isNullOrNil((String)localObject1);
        str = getString(2131761144, new Object[] { com.tencent.mm.plugin.product.b.b.c(i, localm.vFf.vxl) });
      }
      Object localObject2 = this.vGs.az(this);
      if (((LinkedList)localObject2).size() <= 0) {
        break label648;
      }
      this.vHA.setVisibility(0);
      this.vHB.ey((List)localObject2);
      this.vHB.notifyDataSetChanged();
      label369:
      localObject2 = this.vGs.vEH;
      if (localObject2 != null) {
        this.vHs.setText(Html.fromHtml(String.format("%s %s<br><br>%s %s %s", new Object[] { ((dh)localObject2).ncR, ((dh)localObject2).DQm, ((dh)localObject2).iJU, ((dh)localObject2).iJV, ((dh)localObject2).tiv })));
      }
      localObject1 = (String)localObject1 + str;
      if (bs.isNullOrNil((String)localObject1)) {
        break label660;
      }
      localObject1 = getString(2131761143, new Object[] { localObject1 });
      this.vHx.setText((CharSequence)localObject1);
      this.vHy.setVisibility(8);
      this.vHx.setVisibility(0);
    }
    for (;;)
    {
      this.vHz.setText(com.tencent.mm.plugin.product.b.b.c(this.vGs.doW(), localm.vFf.vxl));
      this.iXb.setEnabled(this.vGs.dpf());
      AppMethodBeat.o(67058);
      return;
      this.vGV.setText(com.tencent.mm.plugin.product.b.b.C(localm.vFf.vFq, localm.vFf.vFr, localm.vFf.vxl));
      break;
      label593:
      this.vHv.setSummary("");
      break label187;
      label605:
      this.vHu.setEnabled(false);
      this.vHu.setClickable(false);
      this.vHu.setSummary(getString(2131761146));
      this.vHt.setVisibility(0);
      localObject1 = str;
      break label280;
      label648:
      this.vHA.setVisibility(8);
      break label369;
      label660:
      this.vHy.setVisibility(0);
      this.vHx.setVisibility(8);
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
    this.vHr = ((RelativeLayout)findViewById(2131302115));
    this.vHs = ((TextView)findViewById(2131302117));
    this.vHt = ((TextView)findViewById(2131302116));
    this.vHu = ((MallProductItemView)findViewById(2131302119));
    this.vHv = ((MallProductItemView)findViewById(2131302121));
    this.vGU = ((ImageView)findViewById(2131302120));
    this.lfN = ((TextView)findViewById(2131302128));
    this.vHw = ((TextView)findViewById(2131302122));
    this.vGV = ((TextView)findViewById(2131302126));
    this.vHx = ((TextView)findViewById(2131302125));
    this.vHy = ((TextView)findViewById(2131302124));
    this.vHz = ((TextView)findViewById(2131302129));
    this.vHA = ((ListView)findViewById(2131302123));
    this.vHB = new a(this);
    this.vHA.setAdapter(this.vHB);
    this.vHA.setOnItemClickListener(new AdapterView.OnItemClickListener()
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
          Object localObject = MallProductSubmitUI.b(MallProductSubmitUI.this).vEB;
          if ((((m)localObject).vFf.vFs != null) && (((m)localObject).vFf.vFs.size() > 0))
          {
            ArrayList localArrayList = new ArrayList();
            localObject = ((m)localObject).vFf.vFs.iterator();
            while (((Iterator)localObject).hasNext()) {
              localArrayList.add((String)((Iterator)localObject).next());
            }
            paramAnonymousAdapterView.vGb = localArrayList;
            continue;
            if ((paramAnonymousAdapterView.vGb instanceof String)) {
              MallProductSubmitUI.b(MallProductSubmitUI.this).vEK = ((String)paramAnonymousAdapterView.vGb);
            }
          }
        }
      }
    });
    this.iXb = ((Button)findViewById(2131302127));
    this.iXb.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67048);
        paramAnonymousView = MallProductSubmitUI.d(MallProductSubmitUI.this);
        if (paramAnonymousView.vGs.dpf())
        {
          if (paramAnonymousView.vGs.doW() == 0) {}
          for (int i = 1; i != 0; i = 0)
          {
            g.agS();
            g.agQ().ghe.a(new k(paramAnonymousView.vGs.dph()), 0);
            AppMethodBeat.o(67048);
            return;
          }
          g.agS();
          g.agQ().ghe.a(new l(paramAnonymousView.vGs.dph(), paramAnonymousView.vGs.getAppId()), 0);
        }
        AppMethodBeat.o(67048);
      }
    });
    this.vHr.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67049);
        paramAnonymousView = MallProductSubmitUI.d(MallProductSubmitUI.this);
        Intent localIntent = new Intent();
        localIntent.putExtra("launch_from_webview", true);
        com.tencent.mm.br.d.a(paramAnonymousView.jHh, "address", ".ui.WalletSelectAddrUI", localIntent, 1, false);
        AppMethodBeat.o(67049);
      }
    });
    this.vHu.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67050);
        MallProductSubmitUI.this.showDialog(1);
        AppMethodBeat.o(67050);
      }
    });
    this.vHv.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67051);
        paramAnonymousView = MallProductSubmitUI.d(MallProductSubmitUI.this);
        Intent localIntent = new Intent(paramAnonymousView.jHh, MallProductReceiptUI.class);
        paramAnonymousView.jHh.startActivityForResult(localIntent, 4);
        AppMethodBeat.o(67051);
      }
    });
    MallProductItemView localMallProductItemView = this.vHv;
    boolean bool;
    if ((this.vGs.doT().vGp & 0x2) > 0)
    {
      bool = true;
      ac.d("MicroMsg.MallProductConfig", "hasReceipt, ret = ".concat(String.valueOf(bool)));
      if (!bool) {
        break label411;
      }
    }
    label411:
    for (int i = 0;; i = 8)
    {
      localMallProductItemView.setVisibility(i);
      if (this.vGs.doT().dpp())
      {
        this.vHu.setEnabled(false);
        this.vHu.setClickable(false);
        this.vHu.setSummary(getString(2131761147));
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
      ac.d("MicroMsg.MallProductSubmitUI", bool);
      if (!bs.isNullOrNil(this.vGs.doU())) {
        break;
      }
      AppMethodBeat.o(67060);
      return;
    }
    this.vGU.post(new Runnable()
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
    this.vHb.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(67059);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(67054);
    super.onCreate(paramBundle);
    this.vHb = new f(getContext(), new f.a()
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
        MallProductSubmitUI.this.apv(paramAnonymousString);
        AppMethodBeat.o(67046);
      }
    });
    com.tencent.mm.plugin.product.a.a.doQ();
    this.vGs = com.tencent.mm.plugin.product.a.a.doR();
    this.vEQ = this.vGs.vEQ;
    initView();
    cL();
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
      localObject2 = this.vGs.vEO;
    } while (localObject2 == null);
    Object localObject1 = new ArrayList();
    Object localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((List)localObject1).add(com.tencent.mm.plugin.product.b.b.a(this, (afb)((Iterator)localObject2).next()));
    }
    localObject2 = getString(2131761138);
    AdapterView.OnItemClickListener local8 = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(67053);
        MallProductSubmitUI.this.dismissDialog(1);
        MallProductSubmitUI.b(MallProductSubmitUI.this).KX(paramAnonymousInt);
        MallProductSubmitUI.a(MallProductSubmitUI.this);
        AppMethodBeat.o(67053);
      }
    };
    d.a locala = new d.a(this);
    ListViewInScrollView localListViewInScrollView = (ListViewInScrollView)View.inflate(this, 2131494797, null);
    localListViewInScrollView.setOnItemClickListener(new d.1(local8, locala));
    locala.aIJ = ((List)localObject1);
    locala.vGl = 0;
    localListViewInScrollView.setAdapter(locala);
    localObject1 = new com.tencent.mm.ui.widget.a.d.a(this);
    ((com.tencent.mm.ui.widget.a.d.a)localObject1).aRH((String)localObject2);
    ((com.tencent.mm.ui.widget.a.d.a)localObject1).gH(localListViewInScrollView);
    ((com.tencent.mm.ui.widget.a.d.a)localObject1).e(null);
    localObject1 = ((com.tencent.mm.ui.widget.a.d.a)localObject1).fvp();
    ((com.tencent.mm.ui.widget.a.d)localObject1).show();
    AppMethodBeat.o(67061);
    return localObject1;
  }
  
  public void onStart()
  {
    AppMethodBeat.i(67055);
    this.vHb.onStart();
    super.onStart();
    AppMethodBeat.o(67055);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(67056);
    this.vHb.onStop();
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