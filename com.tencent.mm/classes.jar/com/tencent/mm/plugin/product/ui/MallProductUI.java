package com.tencent.mm.plugin.product.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextPaint;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.pq;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.product.b.n.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.base.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class MallProductUI
  extends MallBaseUI
  implements u.a
{
  private Button jqk;
  private TextView lDu;
  private HtmlTextView wNg;
  protected com.tencent.mm.plugin.product.b.c wNz;
  private ListView wOH;
  private a wOI;
  private LinearLayout wOK;
  private LinearLayout wOL;
  private ImageView wOM;
  private TextView wON;
  private HtmlTextView wOO;
  private RelativeLayout wOP;
  private ListView wOQ;
  private k wOR = null;
  private Button wOS;
  private TextView wOc;
  private f wOi;
  
  public int getLayoutId()
  {
    return 2131495133;
  }
  
  public void initView()
  {
    AppMethodBeat.i(67076);
    setMMTitle(2131761150);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(67065);
        paramAnonymousMenuItem = MallProductUI.e(MallProductUI.this);
        if (!bt.isNullOrNil(paramAnonymousMenuItem.wNz.wLJ))
        {
          com.tencent.mm.kernel.g.ajD();
          com.tencent.mm.kernel.g.ajB().gAO.a(new com.tencent.mm.plugin.product.b.f(paramAnonymousMenuItem.wNz.dzI(), paramAnonymousMenuItem.wNz.wLJ), 0);
        }
        paramAnonymousMenuItem.wNz.clear();
        MallProductUI.this.finish();
        AppMethodBeat.o(67065);
        return true;
      }
    });
    this.wOK = ((LinearLayout)findViewById(2131302092));
    this.wOL = ((LinearLayout)findViewById(2131302113));
    this.wOM = ((ImageView)findViewById(2131302090));
    this.lDu = ((TextView)findViewById(2131302086));
    this.wOc = ((TextView)findViewById(2131302095));
    this.wON = ((TextView)findViewById(2131302093));
    this.wON.getPaint().setFlags(16);
    this.wOP = ((RelativeLayout)findViewById(2131302088));
    this.wNg = ((HtmlTextView)findViewById(2131302087));
    this.wOO = ((HtmlTextView)findViewById(2131302094));
    this.wOH = ((ListView)findViewById(2131302085));
    this.wOI = new a(this);
    this.wOH.setAdapter(this.wOI);
    this.wOH.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(67066);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).mr(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).qY(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/product/ui/MallProductUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
        paramAnonymousAdapterView = (b)paramAnonymousView.getTag();
        switch (paramAnonymousAdapterView.type)
        {
        }
        for (;;)
        {
          MallProductUI.f(MallProductUI.this).a(MallProductUI.this, paramAnonymousView, paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/product/ui/MallProductUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(67066);
          return;
          Object localObject2 = MallProductUI.this.wNz.wLH;
          if ((((com.tencent.mm.plugin.product.b.m)localObject2).wMl.wMy != null) && (((com.tencent.mm.plugin.product.b.m)localObject2).wMl.wMy.size() > 0))
          {
            localObject1 = new ArrayList();
            localObject2 = ((com.tencent.mm.plugin.product.b.m)localObject2).wMl.wMy.iterator();
            while (((Iterator)localObject2).hasNext()) {
              ((ArrayList)localObject1).add((String)((Iterator)localObject2).next());
            }
            paramAnonymousAdapterView.wNh = localObject1;
          }
        }
      }
    });
    this.wOS = ((Button)findViewById(2131302105));
    this.wOS.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67067);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/product/ui/MallProductUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = MallProductUI.e(MallProductUI.this);
        com.tencent.mm.wallet_core.ui.e.ad(paramAnonymousView.kbt, paramAnonymousView.wNz.dzB());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/product/ui/MallProductUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(67067);
      }
    });
    this.wOQ = ((ListView)findViewById(2131302114));
    this.wOR = new k(this);
    this.wOR.wOl = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(67068);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).mr(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).qY(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/product/ui/MallProductUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        paramAnonymousView = (m)paramAnonymousView.getTag();
        paramAnonymousAdapterView = MallProductUI.e(MallProductUI.this);
        if ((paramAnonymousView != null) && (paramAnonymousView.wOw != null))
        {
          paramAnonymousView = paramAnonymousView.wOw;
          ad.i("MicroMsg.MallProductUI", "goProductUI type : " + paramAnonymousView.type);
          switch (paramAnonymousView.type)
          {
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/product/ui/MallProductUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(67068);
          return;
          localObject = new Intent();
          ((Intent)localObject).putExtra("rawUrl", paramAnonymousView.url);
          com.tencent.mm.wallet_core.ui.e.an(paramAnonymousAdapterView.kbt, (Intent)localObject);
          continue;
          paramAnonymousView = paramAnonymousView.data.replace("product_id=", "");
          localObject = new Intent();
          ((Intent)localObject).putExtra("key_product_id", paramAnonymousView);
          ((Intent)localObject).putExtra("key_product_scene", 6);
          d.b(paramAnonymousAdapterView.kbt, "mall", ".product.ui.MallProductUI", (Intent)localObject);
          paramAnonymousAdapterView.kbt.finish();
        }
      }
    };
    this.wOQ.setAdapter(this.wOR);
    this.jqk = ((Button)findViewById(2131302089));
    this.jqk.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67069);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/product/ui/MallProductUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
        paramAnonymousView = MallProductUI.e(MallProductUI.this);
        if (paramAnonymousView.wNz.dzF())
        {
          localObject1 = paramAnonymousView.kbt;
          Object localObject2 = new Intent(paramAnonymousView.kbt, MallProductSelectSkuUI.class);
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahp(), "com/tencent/mm/plugin/product/ui/MallProductHelper", "goSelectSku", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Activity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/product/ui/MallProductHelper", "goSelectSku", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.plugin.report.service.g.yhR.f(11008, new Object[] { paramAnonymousView.wNz.dzB(), paramAnonymousView.wNz.wLH.wMh, Integer.valueOf(f.mScene), Integer.valueOf(1) });
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/product/ui/MallProductUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(67069);
          return;
          t.makeText(paramAnonymousView.kbt, 2131761119, 1).show();
        }
      }
    });
    addIconOptionMenu(0, 2131690603, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        boolean bool = false;
        AppMethodBeat.i(67071);
        paramAnonymousMenuItem = MallProductUI.this.getResources().getStringArray(2130903067);
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        while (i < paramAnonymousMenuItem.length)
        {
          localArrayList.add(paramAnonymousMenuItem[i]);
          i += 1;
        }
        if ((MallProductUI.this.wNz.dzv().wNv & 0x1) > 0) {
          bool = true;
        }
        ad.d("MicroMsg.MallProductConfig", "isShowSellerEntry, ret = ".concat(String.valueOf(bool)));
        if (bool) {
          localArrayList.add(MallProductUI.this.getString(2131761132));
        }
        h.b(MallProductUI.this.getContext(), null, (String[])localArrayList.toArray(new String[localArrayList.size()]), null, new h.c()
        {
          public final void lf(int paramAnonymous2Int)
          {
            AppMethodBeat.i(67070);
            switch (paramAnonymous2Int)
            {
            }
            for (;;)
            {
              AppMethodBeat.o(67070);
              return;
              f localf = MallProductUI.e(MallProductUI.this);
              Object localObject1 = localf.wNz.dzL();
              Object localObject2 = new Intent();
              ((Intent)localObject2).putExtra("Retr_Msg_content", (String)localObject1);
              ((Intent)localObject2).putExtra("Retr_Msg_Type", 2);
              if (!bt.isNullOrNil(localf.wNz.wLH.dzO())) {
                ((Intent)localObject2).putExtra("Retr_Msg_thumb_path", localf.wNz.dzC());
              }
              ((Intent)localObject2).putExtra("Retr_go_to_chattingUI", false);
              ((Intent)localObject2).putExtra("Retr_show_success_tips", true);
              ((Intent)localObject2).putExtra("Retr_Msg_Type", 2);
              d.f(localf.kbt, ".ui.transmit.MsgRetransmitUI", (Intent)localObject2);
              if (f.mScene == 4) {
                com.tencent.mm.plugin.report.service.g.yhR.f(10651, new Object[] { Integer.valueOf(11), Integer.valueOf(1), Integer.valueOf(0) });
              }
              AppMethodBeat.o(67070);
              return;
              localf = MallProductUI.e(MallProductUI.this);
              localObject2 = localf.wNz.wLH;
              localObject1 = new Intent();
              ((Intent)localObject1).putExtra("KContentObjDesc", localf.wNz.dzM());
              ((Intent)localObject1).putExtra("Ksnsupload_title", ((com.tencent.mm.plugin.product.b.m)localObject2).wMl.name);
              ((Intent)localObject1).putExtra("Ksnsupload_link", localf.wNz.dzD());
              ((Intent)localObject1).putExtra("Ksnsupload_imgurl", localf.wNz.wLH.dzO());
              if (!bt.isNullOrNil(localf.wNz.wLH.dzO())) {
                ((Intent)localObject1).putExtra("KsnsUpload_imgPath", localf.wNz.dzC());
              }
              ((Intent)localObject1).putExtra("Ksnsupload_type", 6);
              ((Intent)localObject1).putExtra("KUploadProduct_UserData", localf.wNz.a((com.tencent.mm.plugin.product.b.m)localObject2));
              ((Intent)localObject1).putExtra("KUploadProduct_subType", ((com.tencent.mm.plugin.product.b.m)localObject2).wMi);
              localObject2 = y.AH("scan_product");
              y.aBq().F((String)localObject2, true).k("prePublishId", "scan_product");
              ((Intent)localObject1).putExtra("reportSessionId", (String)localObject2);
              d.b(localf.kbt, "sns", ".ui.SnsUploadUI", (Intent)localObject1);
              if (f.mScene == 4) {
                com.tencent.mm.plugin.report.service.g.yhR.f(10651, new Object[] { Integer.valueOf(11), Integer.valueOf(0), Integer.valueOf(0) });
              }
              AppMethodBeat.o(67070);
              return;
              MallProductUI.e(MallProductUI.this).dzS();
              AppMethodBeat.o(67070);
              return;
              localf = MallProductUI.e(MallProductUI.this);
              com.tencent.mm.wallet_core.ui.e.ac(localf.kbt, localf.wNz.dzB());
            }
          }
        });
        AppMethodBeat.o(67071);
        return true;
      }
    });
    showOptionMenu(false);
    this.wOM.setFocusable(true);
    this.wOM.setFocusableInTouchMode(true);
    this.wOM.requestFocus();
    AppMethodBeat.o(67076);
  }
  
  public final void k(String paramString, final Bitmap paramBitmap)
  {
    AppMethodBeat.i(67079);
    if ((paramString != null) && (paramString.equals(this.wNz.wLP))) {
      this.wOM.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(67072);
          MallProductUI.g(MallProductUI.this).setImageBitmap(paramBitmap);
          AppMethodBeat.o(67072);
        }
      });
    }
    AppMethodBeat.o(67079);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(67073);
    super.onCreate(paramBundle);
    setContentViewVisibility(8);
    boolean bool = getIntent().getBooleanExtra("key_go_finish", false);
    setResult(-1);
    if (bool)
    {
      finish();
      AppMethodBeat.o(67073);
      return;
    }
    initView();
    com.tencent.mm.plugin.product.a.a.dzs();
    this.wNz = com.tencent.mm.plugin.product.a.a.dzt();
    this.wOi = new f(getContext(), new f.a()
    {
      public final void E(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString)
      {
        AppMethodBeat.i(67064);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          MallProductUI.this.updateView();
          if (MallProductUI.a(MallProductUI.this) != null)
          {
            MallProductUI.a(MallProductUI.this).postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(67063);
                ScrollView localScrollView = (ScrollView)MallProductUI.this.findViewById(2131302130);
                if (localScrollView != null) {
                  localScrollView.pageScroll(33);
                }
                AppMethodBeat.o(67063);
              }
            }, 200L);
            AppMethodBeat.o(67064);
          }
        }
        else
        {
          if (paramAnonymousInt2 == -10010003)
          {
            MallProductUI.this.setContentViewVisibility(0);
            MallProductUI.b(MallProductUI.this).setVisibility(8);
            MallProductUI.c(MallProductUI.this).setVisibility(0);
            MallProductUI.d(MallProductUI.this);
            AppMethodBeat.o(67064);
            return;
          }
          MallProductUI.this.auB(paramAnonymousString);
        }
        AppMethodBeat.o(67064);
      }
    });
    paramBundle = this.wOi;
    Object localObject = getIntent();
    com.tencent.mm.plugin.product.b.m localm = new com.tencent.mm.plugin.product.b.m();
    com.tencent.mm.kernel.g.ajF().a(new f.1(paramBundle, (Intent)localObject, localm));
    paramBundle.wNx = true;
    localObject = new pq();
    ((pq)localObject).dDU.errCode = -1;
    ((pq)localObject).callback = new f.2(paramBundle, (pq)localObject);
    com.tencent.mm.sdk.b.a.IbL.a((com.tencent.mm.sdk.b.b)localObject, Looper.getMainLooper());
    AppMethodBeat.o(67073);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(67077);
    super.onNewIntent(paramIntent);
    ad.v("MicroMsg.MallProductUI", "onNewIntent");
    setIntent(paramIntent);
    AppMethodBeat.o(67077);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(67075);
    this.wOi.onStop();
    super.onPause();
    AppMethodBeat.o(67075);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(67074);
    super.onResume();
    this.wOi.onStart();
    AppMethodBeat.o(67074);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected final void updateView()
  {
    AppMethodBeat.i(67078);
    Object localObject = this.wNz.wLH;
    if (localObject == null)
    {
      showOptionMenu(false);
      AppMethodBeat.o(67078);
      return;
    }
    showOptionMenu(true);
    setContentViewVisibility(0);
    this.wOK.setVisibility(0);
    this.wOL.setVisibility(8);
    if (((com.tencent.mm.plugin.product.b.m)localObject).wMl != null)
    {
      this.lDu.setText(((com.tencent.mm.plugin.product.b.m)localObject).wMl.name);
      this.wOc.setText(com.tencent.mm.plugin.product.b.b.D(((com.tencent.mm.plugin.product.b.m)localObject).wMl.wMw, ((com.tencent.mm.plugin.product.b.m)localObject).wMl.wMx, ((com.tencent.mm.plugin.product.b.m)localObject).wMl.wCF));
      this.wON.setText(com.tencent.mm.plugin.product.b.b.c(((com.tencent.mm.plugin.product.b.m)localObject).wMl.wMv, ((com.tencent.mm.plugin.product.b.m)localObject).wMl.wCF));
    }
    if (this.wNz.dzE() <= 0)
    {
      this.jqk.setEnabled(false);
      this.jqk.setText(2131761134);
      if ((((com.tencent.mm.plugin.product.b.m)localObject).wMl == null) || (((com.tencent.mm.plugin.product.b.m)localObject).wMl.wMF == null) || (((com.tencent.mm.plugin.product.b.m)localObject).wMl.wMF.size() <= 0)) {
        break label435;
      }
      this.wOH.setVisibility(0);
      this.wOI.eL(((com.tencent.mm.plugin.product.b.m)localObject).wMl.wMF);
      this.wOI.notifyDataSetChanged();
      label221:
      if ((((com.tencent.mm.plugin.product.b.m)localObject).wMl == null) || (bt.isNullOrNil(((com.tencent.mm.plugin.product.b.m)localObject).wMl.detail))) {
        break label447;
      }
      this.wOP.setVisibility(0);
      this.wNg.setVisibility(0);
      this.wNg.setText(((com.tencent.mm.plugin.product.b.m)localObject).wMl.detail);
      label271:
      if (bt.isNullOrNil(((com.tencent.mm.plugin.product.b.m)localObject).wMq)) {
        break label468;
      }
      this.wOO.setVisibility(0);
      this.wOO.setText(((com.tencent.mm.plugin.product.b.m)localObject).wMq);
    }
    for (;;)
    {
      showOptionMenu(true);
      if (!bt.isNullOrNil(this.wNz.wLP))
      {
        localObject = u.a(new c(this.wNz.wLP));
        this.wOM.setImageBitmap((Bitmap)localObject);
        u.a(this);
      }
      AppMethodBeat.o(67078);
      return;
      if (this.wNz.wLH.wMk <= 0)
      {
        this.jqk.setEnabled(false);
        this.jqk.setText(2131761133);
        break;
      }
      this.jqk.setEnabled(true);
      if (!bt.isNullOrNil(((com.tencent.mm.plugin.product.b.m)localObject).wMp))
      {
        this.jqk.setText(((com.tencent.mm.plugin.product.b.m)localObject).wMp);
        break;
      }
      this.jqk.setText(2131761121);
      break;
      label435:
      this.wOH.setVisibility(8);
      break label221;
      label447:
      this.wOP.setVisibility(8);
      this.wNg.setVisibility(8);
      break label271;
      label468:
      this.wOO.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductUI
 * JD-Core Version:    0.7.0.1
 */