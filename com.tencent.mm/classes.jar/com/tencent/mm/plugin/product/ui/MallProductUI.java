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
import com.tencent.mm.ak.q;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.pr;
import com.tencent.mm.model.z;
import com.tencent.mm.model.z.b;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.product.b.n.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
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
  private Button jtd;
  private TextView lHT;
  private HtmlTextView xcU;
  private TextView xdQ;
  private f xdW;
  protected com.tencent.mm.plugin.product.b.c xdn;
  private ImageView xeA;
  private TextView xeB;
  private HtmlTextView xeC;
  private RelativeLayout xeD;
  private ListView xeE;
  private k xeF = null;
  private Button xeG;
  private ListView xev;
  private a xew;
  private LinearLayout xey;
  private LinearLayout xez;
  
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
        if (!bu.isNullOrNil(paramAnonymousMenuItem.xdn.xbx))
        {
          com.tencent.mm.kernel.g.ajS();
          com.tencent.mm.kernel.g.ajQ().gDv.a(new com.tencent.mm.plugin.product.b.f(paramAnonymousMenuItem.xdn.dCZ(), paramAnonymousMenuItem.xdn.xbx), 0);
        }
        paramAnonymousMenuItem.xdn.clear();
        MallProductUI.this.finish();
        AppMethodBeat.o(67065);
        return true;
      }
    });
    this.xey = ((LinearLayout)findViewById(2131302092));
    this.xez = ((LinearLayout)findViewById(2131302113));
    this.xeA = ((ImageView)findViewById(2131302090));
    this.lHT = ((TextView)findViewById(2131302086));
    this.xdQ = ((TextView)findViewById(2131302095));
    this.xeB = ((TextView)findViewById(2131302093));
    this.xeB.getPaint().setFlags(16);
    this.xeD = ((RelativeLayout)findViewById(2131302088));
    this.xcU = ((HtmlTextView)findViewById(2131302087));
    this.xeC = ((HtmlTextView)findViewById(2131302094));
    this.xev = ((ListView)findViewById(2131302085));
    this.xew = new a(this);
    this.xev.setAdapter(this.xew);
    this.xev.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(67066);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).mu(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).rl(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/product/ui/MallProductUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
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
          Object localObject2 = MallProductUI.this.xdn.xbv;
          if ((((com.tencent.mm.plugin.product.b.m)localObject2).xbZ.xcm != null) && (((com.tencent.mm.plugin.product.b.m)localObject2).xbZ.xcm.size() > 0))
          {
            localObject1 = new ArrayList();
            localObject2 = ((com.tencent.mm.plugin.product.b.m)localObject2).xbZ.xcm.iterator();
            while (((Iterator)localObject2).hasNext()) {
              ((ArrayList)localObject1).add((String)((Iterator)localObject2).next());
            }
            paramAnonymousAdapterView.xcV = localObject1;
          }
        }
      }
    });
    this.xeG = ((Button)findViewById(2131302105));
    this.xeG.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67067);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/product/ui/MallProductUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramAnonymousView = MallProductUI.e(MallProductUI.this);
        com.tencent.mm.wallet_core.ui.f.af(paramAnonymousView.keK, paramAnonymousView.xdn.dCS());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/product/ui/MallProductUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(67067);
      }
    });
    this.xeE = ((ListView)findViewById(2131302114));
    this.xeF = new k(this);
    this.xeF.xdZ = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(67068);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).mu(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).rl(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/product/ui/MallProductUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        paramAnonymousView = (m)paramAnonymousView.getTag();
        paramAnonymousAdapterView = MallProductUI.e(MallProductUI.this);
        if ((paramAnonymousView != null) && (paramAnonymousView.xek != null))
        {
          paramAnonymousView = paramAnonymousView.xek;
          ae.i("MicroMsg.MallProductUI", "goProductUI type : " + paramAnonymousView.type);
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
          com.tencent.mm.wallet_core.ui.f.an(paramAnonymousAdapterView.keK, (Intent)localObject);
          continue;
          paramAnonymousView = paramAnonymousView.data.replace("product_id=", "");
          localObject = new Intent();
          ((Intent)localObject).putExtra("key_product_id", paramAnonymousView);
          ((Intent)localObject).putExtra("key_product_scene", 6);
          d.b(paramAnonymousAdapterView.keK, "mall", ".product.ui.MallProductUI", (Intent)localObject);
          paramAnonymousAdapterView.keK.finish();
        }
      }
    };
    this.xeE.setAdapter(this.xeF);
    this.jtd = ((Button)findViewById(2131302089));
    this.jtd.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67069);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/product/ui/MallProductUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
        paramAnonymousView = MallProductUI.e(MallProductUI.this);
        if (paramAnonymousView.xdn.dCW())
        {
          localObject1 = paramAnonymousView.keK;
          Object localObject2 = new Intent(paramAnonymousView.keK, MallProductSelectSkuUI.class);
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahE(), "com/tencent/mm/plugin/product/ui/MallProductHelper", "goSelectSku", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Activity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/product/ui/MallProductHelper", "goSelectSku", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.plugin.report.service.g.yxI.f(11008, new Object[] { paramAnonymousView.xdn.dCS(), paramAnonymousView.xdn.xbv.xbV, Integer.valueOf(f.mScene), Integer.valueOf(1) });
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/product/ui/MallProductUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(67069);
          return;
          t.makeText(paramAnonymousView.keK, 2131761119, 1).show();
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
        if ((MallProductUI.this.xdn.dCM().xdj & 0x1) > 0) {
          bool = true;
        }
        ae.d("MicroMsg.MallProductConfig", "isShowSellerEntry, ret = ".concat(String.valueOf(bool)));
        if (bool) {
          localArrayList.add(MallProductUI.this.getString(2131761132));
        }
        h.b(MallProductUI.this.getContext(), null, (String[])localArrayList.toArray(new String[localArrayList.size()]), null, new h.c()
        {
          public final void lh(int paramAnonymous2Int)
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
              Object localObject1 = localf.xdn.dDc();
              Object localObject2 = new Intent();
              ((Intent)localObject2).putExtra("Retr_Msg_content", (String)localObject1);
              ((Intent)localObject2).putExtra("Retr_Msg_Type", 2);
              if (!bu.isNullOrNil(localf.xdn.xbv.dDf())) {
                ((Intent)localObject2).putExtra("Retr_Msg_thumb_path", localf.xdn.dCT());
              }
              ((Intent)localObject2).putExtra("Retr_go_to_chattingUI", false);
              ((Intent)localObject2).putExtra("Retr_show_success_tips", true);
              ((Intent)localObject2).putExtra("Retr_Msg_Type", 2);
              d.f(localf.keK, ".ui.transmit.MsgRetransmitUI", (Intent)localObject2);
              if (f.mScene == 4) {
                com.tencent.mm.plugin.report.service.g.yxI.f(10651, new Object[] { Integer.valueOf(11), Integer.valueOf(1), Integer.valueOf(0) });
              }
              AppMethodBeat.o(67070);
              return;
              localf = MallProductUI.e(MallProductUI.this);
              localObject2 = localf.xdn.xbv;
              localObject1 = new Intent();
              ((Intent)localObject1).putExtra("KContentObjDesc", localf.xdn.dDd());
              ((Intent)localObject1).putExtra("Ksnsupload_title", ((com.tencent.mm.plugin.product.b.m)localObject2).xbZ.name);
              ((Intent)localObject1).putExtra("Ksnsupload_link", localf.xdn.dCU());
              ((Intent)localObject1).putExtra("Ksnsupload_imgurl", localf.xdn.xbv.dDf());
              if (!bu.isNullOrNil(localf.xdn.xbv.dDf())) {
                ((Intent)localObject1).putExtra("KsnsUpload_imgPath", localf.xdn.dCT());
              }
              ((Intent)localObject1).putExtra("Ksnsupload_type", 6);
              ((Intent)localObject1).putExtra("KUploadProduct_UserData", localf.xdn.a((com.tencent.mm.plugin.product.b.m)localObject2));
              ((Intent)localObject1).putExtra("KUploadProduct_subType", ((com.tencent.mm.plugin.product.b.m)localObject2).xbW);
              localObject2 = z.Br("scan_product");
              z.aBG().F((String)localObject2, true).k("prePublishId", "scan_product");
              ((Intent)localObject1).putExtra("reportSessionId", (String)localObject2);
              d.b(localf.keK, "sns", ".ui.SnsUploadUI", (Intent)localObject1);
              if (f.mScene == 4) {
                com.tencent.mm.plugin.report.service.g.yxI.f(10651, new Object[] { Integer.valueOf(11), Integer.valueOf(0), Integer.valueOf(0) });
              }
              AppMethodBeat.o(67070);
              return;
              MallProductUI.e(MallProductUI.this).dDj();
              AppMethodBeat.o(67070);
              return;
              localf = MallProductUI.e(MallProductUI.this);
              com.tencent.mm.wallet_core.ui.f.ae(localf.keK, localf.xdn.dCS());
            }
          }
        });
        AppMethodBeat.o(67071);
        return true;
      }
    });
    showOptionMenu(false);
    this.xeA.setFocusable(true);
    this.xeA.setFocusableInTouchMode(true);
    this.xeA.requestFocus();
    AppMethodBeat.o(67076);
  }
  
  public final void k(String paramString, final Bitmap paramBitmap)
  {
    AppMethodBeat.i(67079);
    if ((paramString != null) && (paramString.equals(this.xdn.xbD))) {
      this.xeA.post(new Runnable()
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
    com.tencent.mm.plugin.product.a.a.dCJ();
    this.xdn = com.tencent.mm.plugin.product.a.a.dCK();
    this.xdW = new f(getContext(), new f.a()
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
          MallProductUI.this.avQ(paramAnonymousString);
        }
        AppMethodBeat.o(67064);
      }
    });
    paramBundle = this.xdW;
    Object localObject = getIntent();
    com.tencent.mm.plugin.product.b.m localm = new com.tencent.mm.plugin.product.b.m();
    com.tencent.mm.kernel.g.ajU().a(new f.1(paramBundle, (Intent)localObject, localm));
    paramBundle.xdl = true;
    localObject = new pr();
    ((pr)localObject).dEZ.errCode = -1;
    ((pr)localObject).callback = new f.2(paramBundle, (pr)localObject);
    com.tencent.mm.sdk.b.a.IvT.a((com.tencent.mm.sdk.b.b)localObject, Looper.getMainLooper());
    AppMethodBeat.o(67073);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(67077);
    super.onNewIntent(paramIntent);
    ae.v("MicroMsg.MallProductUI", "onNewIntent");
    setIntent(paramIntent);
    AppMethodBeat.o(67077);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(67075);
    this.xdW.onStop();
    super.onPause();
    AppMethodBeat.o(67075);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(67074);
    super.onResume();
    this.xdW.onStart();
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
    Object localObject = this.xdn.xbv;
    if (localObject == null)
    {
      showOptionMenu(false);
      AppMethodBeat.o(67078);
      return;
    }
    showOptionMenu(true);
    setContentViewVisibility(0);
    this.xey.setVisibility(0);
    this.xez.setVisibility(8);
    if (((com.tencent.mm.plugin.product.b.m)localObject).xbZ != null)
    {
      this.lHT.setText(((com.tencent.mm.plugin.product.b.m)localObject).xbZ.name);
      this.xdQ.setText(com.tencent.mm.plugin.product.b.b.D(((com.tencent.mm.plugin.product.b.m)localObject).xbZ.xck, ((com.tencent.mm.plugin.product.b.m)localObject).xbZ.xcl, ((com.tencent.mm.plugin.product.b.m)localObject).xbZ.wSq));
      this.xeB.setText(com.tencent.mm.plugin.product.b.b.c(((com.tencent.mm.plugin.product.b.m)localObject).xbZ.xcj, ((com.tencent.mm.plugin.product.b.m)localObject).xbZ.wSq));
    }
    if (this.xdn.dCV() <= 0)
    {
      this.jtd.setEnabled(false);
      this.jtd.setText(2131761134);
      if ((((com.tencent.mm.plugin.product.b.m)localObject).xbZ == null) || (((com.tencent.mm.plugin.product.b.m)localObject).xbZ.xct == null) || (((com.tencent.mm.plugin.product.b.m)localObject).xbZ.xct.size() <= 0)) {
        break label435;
      }
      this.xev.setVisibility(0);
      this.xew.eT(((com.tencent.mm.plugin.product.b.m)localObject).xbZ.xct);
      this.xew.notifyDataSetChanged();
      label221:
      if ((((com.tencent.mm.plugin.product.b.m)localObject).xbZ == null) || (bu.isNullOrNil(((com.tencent.mm.plugin.product.b.m)localObject).xbZ.detail))) {
        break label447;
      }
      this.xeD.setVisibility(0);
      this.xcU.setVisibility(0);
      this.xcU.setText(((com.tencent.mm.plugin.product.b.m)localObject).xbZ.detail);
      label271:
      if (bu.isNullOrNil(((com.tencent.mm.plugin.product.b.m)localObject).xce)) {
        break label468;
      }
      this.xeC.setVisibility(0);
      this.xeC.setText(((com.tencent.mm.plugin.product.b.m)localObject).xce);
    }
    for (;;)
    {
      showOptionMenu(true);
      if (!bu.isNullOrNil(this.xdn.xbD))
      {
        localObject = u.a(new c(this.xdn.xbD));
        this.xeA.setImageBitmap((Bitmap)localObject);
        u.a(this);
      }
      AppMethodBeat.o(67078);
      return;
      if (this.xdn.xbv.xbY <= 0)
      {
        this.jtd.setEnabled(false);
        this.jtd.setText(2131761133);
        break;
      }
      this.jtd.setEnabled(true);
      if (!bu.isNullOrNil(((com.tencent.mm.plugin.product.b.m)localObject).xcd))
      {
        this.jtd.setText(((com.tencent.mm.plugin.product.b.m)localObject).xcd);
        break;
      }
      this.jtd.setText(2131761121);
      break;
      label435:
      this.xev.setVisibility(8);
      break label221;
      label447:
      this.xeD.setVisibility(8);
      this.xcU.setVisibility(8);
      break label271;
      label468:
      this.xeC.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductUI
 * JD-Core Version:    0.7.0.1
 */