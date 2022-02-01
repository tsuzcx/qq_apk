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
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.qj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.product.b.n.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class MallProductUI
  extends MallBaseUI
  implements u.a
{
  protected com.tencent.mm.plugin.product.b.c BaP;
  private HtmlTextView Baw;
  private ListView BbX;
  private a BbY;
  private TextView Bbs;
  private f Bby;
  private LinearLayout Bca;
  private LinearLayout Bcb;
  private ImageView Bcc;
  private TextView Bcd;
  private HtmlTextView Bce;
  private RelativeLayout Bcf;
  private ListView Bcg;
  private k Bch = null;
  private Button Bci;
  private TextView jVn;
  private Button krs;
  
  public int getLayoutId()
  {
    return 2131495976;
  }
  
  public void initView()
  {
    AppMethodBeat.i(67076);
    setMMTitle(2131762937);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(67065);
        paramAnonymousMenuItem = MallProductUI.e(MallProductUI.this);
        if (!Util.isNullOrNil(paramAnonymousMenuItem.BaP.AYZ))
        {
          g.aAi();
          g.aAg().hqi.a(new com.tencent.mm.plugin.product.b.f(paramAnonymousMenuItem.BaP.eDr(), paramAnonymousMenuItem.BaP.AYZ), 0);
        }
        paramAnonymousMenuItem.BaP.clear();
        MallProductUI.this.finish();
        AppMethodBeat.o(67065);
        return true;
      }
    });
    this.Bca = ((LinearLayout)findViewById(2131304431));
    this.Bcb = ((LinearLayout)findViewById(2131304452));
    this.Bcc = ((ImageView)findViewById(2131304429));
    this.jVn = ((TextView)findViewById(2131304425));
    this.Bbs = ((TextView)findViewById(2131304434));
    this.Bcd = ((TextView)findViewById(2131304432));
    this.Bcd.getPaint().setFlags(16);
    this.Bcf = ((RelativeLayout)findViewById(2131304427));
    this.Baw = ((HtmlTextView)findViewById(2131304426));
    this.Bce = ((HtmlTextView)findViewById(2131304433));
    this.BbX = ((ListView)findViewById(2131304424));
    this.BbY = new a(this);
    this.BbX.setAdapter(this.BbY);
    this.BbX.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(67066);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).pH(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).zo(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/product/ui/MallProductUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
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
          Object localObject2 = MallProductUI.this.BaP.AYX;
          if ((((com.tencent.mm.plugin.product.b.m)localObject2).AZB.AZO != null) && (((com.tencent.mm.plugin.product.b.m)localObject2).AZB.AZO.size() > 0))
          {
            localObject1 = new ArrayList();
            localObject2 = ((com.tencent.mm.plugin.product.b.m)localObject2).AZB.AZO.iterator();
            while (((Iterator)localObject2).hasNext()) {
              ((ArrayList)localObject1).add((String)((Iterator)localObject2).next());
            }
            paramAnonymousAdapterView.Bax = localObject1;
          }
        }
      }
    });
    this.Bci = ((Button)findViewById(2131304444));
    this.Bci.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67067);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/product/ui/MallProductUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = MallProductUI.e(MallProductUI.this);
        com.tencent.mm.wallet_core.ui.f.an(paramAnonymousView.mContext, paramAnonymousView.BaP.eDk());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/product/ui/MallProductUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(67067);
      }
    });
    this.Bcg = ((ListView)findViewById(2131304453));
    this.Bch = new k(this);
    this.Bch.BbB = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(67068);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).zo(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/product/ui/MallProductUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        paramAnonymousView = (m)paramAnonymousView.getTag();
        paramAnonymousAdapterView = MallProductUI.e(MallProductUI.this);
        if ((paramAnonymousView != null) && (paramAnonymousView.BbM != null))
        {
          paramAnonymousView = paramAnonymousView.BbM;
          Log.i("MicroMsg.MallProductUI", "goProductUI type : " + paramAnonymousView.type);
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
          com.tencent.mm.wallet_core.ui.f.aA(paramAnonymousAdapterView.mContext, (Intent)localObject);
          continue;
          paramAnonymousView = paramAnonymousView.data.replace("product_id=", "");
          localObject = new Intent();
          ((Intent)localObject).putExtra("key_product_id", paramAnonymousView);
          ((Intent)localObject).putExtra("key_product_scene", 6);
          com.tencent.mm.br.c.b(paramAnonymousAdapterView.mContext, "mall", ".product.ui.MallProductUI", (Intent)localObject);
          paramAnonymousAdapterView.mContext.finish();
        }
      }
    };
    this.Bcg.setAdapter(this.Bch);
    this.krs = ((Button)findViewById(2131304428));
    this.krs.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67069);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/product/ui/MallProductUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
        paramAnonymousView = MallProductUI.e(MallProductUI.this);
        if (paramAnonymousView.BaP.eDo())
        {
          localObject1 = paramAnonymousView.mContext;
          Object localObject2 = new Intent(paramAnonymousView.mContext, MallProductSelectSkuUI.class);
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject2);
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/plugin/product/ui/MallProductHelper", "goSelectSku", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Activity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/product/ui/MallProductHelper", "goSelectSku", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.plugin.report.service.h.CyF.a(11008, new Object[] { paramAnonymousView.BaP.eDk(), paramAnonymousView.BaP.AYX.AZx, Integer.valueOf(f.mScene), Integer.valueOf(1) });
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/product/ui/MallProductUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(67069);
          return;
          com.tencent.mm.ui.base.u.makeText(paramAnonymousView.mContext, 2131762906, 1).show();
        }
      }
    });
    addIconOptionMenu(0, 2131690843, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        boolean bool = false;
        AppMethodBeat.i(67071);
        paramAnonymousMenuItem = MallProductUI.this.getResources().getStringArray(2130903068);
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        while (i < paramAnonymousMenuItem.length)
        {
          localArrayList.add(paramAnonymousMenuItem[i]);
          i += 1;
        }
        if ((MallProductUI.this.BaP.eDe().BaL & 0x1) > 0) {
          bool = true;
        }
        Log.d("MicroMsg.MallProductConfig", "isShowSellerEntry, ret = ".concat(String.valueOf(bool)));
        if (bool) {
          localArrayList.add(MallProductUI.this.getString(2131762919));
        }
        com.tencent.mm.ui.base.h.b(MallProductUI.this.getContext(), null, (String[])localArrayList.toArray(new String[localArrayList.size()]), null, new h.d()
        {
          public final void oj(int paramAnonymous2Int)
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
              Object localObject1 = localf.BaP.eDu();
              Object localObject2 = new Intent();
              ((Intent)localObject2).putExtra("Retr_Msg_content", (String)localObject1);
              ((Intent)localObject2).putExtra("Retr_Msg_Type", 2);
              if (!Util.isNullOrNil(localf.BaP.AYX.eDx())) {
                ((Intent)localObject2).putExtra("Retr_Msg_thumb_path", localf.BaP.eDl());
              }
              ((Intent)localObject2).putExtra("Retr_go_to_chattingUI", false);
              ((Intent)localObject2).putExtra("Retr_show_success_tips", true);
              ((Intent)localObject2).putExtra("Retr_Msg_Type", 2);
              com.tencent.mm.br.c.f(localf.mContext, ".ui.transmit.MsgRetransmitUI", (Intent)localObject2);
              if (f.mScene == 4) {
                com.tencent.mm.plugin.report.service.h.CyF.a(10651, new Object[] { Integer.valueOf(11), Integer.valueOf(1), Integer.valueOf(0) });
              }
              AppMethodBeat.o(67070);
              return;
              localf = MallProductUI.e(MallProductUI.this);
              localObject2 = localf.BaP.AYX;
              localObject1 = new Intent();
              ((Intent)localObject1).putExtra("KContentObjDesc", localf.BaP.eDv());
              ((Intent)localObject1).putExtra("Ksnsupload_title", ((com.tencent.mm.plugin.product.b.m)localObject2).AZB.name);
              ((Intent)localObject1).putExtra("Ksnsupload_link", localf.BaP.eDm());
              ((Intent)localObject1).putExtra("Ksnsupload_imgurl", localf.BaP.AYX.eDx());
              if (!Util.isNullOrNil(localf.BaP.AYX.eDx())) {
                ((Intent)localObject1).putExtra("KsnsUpload_imgPath", localf.BaP.eDl());
              }
              ((Intent)localObject1).putExtra("Ksnsupload_type", 6);
              ((Intent)localObject1).putExtra("KUploadProduct_UserData", localf.BaP.a((com.tencent.mm.plugin.product.b.m)localObject2));
              ((Intent)localObject1).putExtra("KUploadProduct_subType", ((com.tencent.mm.plugin.product.b.m)localObject2).AZy);
              localObject2 = ad.JX("scan_product");
              ad.aVe().G((String)localObject2, true).l("prePublishId", "scan_product");
              ((Intent)localObject1).putExtra("reportSessionId", (String)localObject2);
              com.tencent.mm.br.c.b(localf.mContext, "sns", ".ui.SnsUploadUI", (Intent)localObject1);
              if (f.mScene == 4) {
                com.tencent.mm.plugin.report.service.h.CyF.a(10651, new Object[] { Integer.valueOf(11), Integer.valueOf(0), Integer.valueOf(0) });
              }
              AppMethodBeat.o(67070);
              return;
              MallProductUI.e(MallProductUI.this).eDB();
              AppMethodBeat.o(67070);
              return;
              localf = MallProductUI.e(MallProductUI.this);
              com.tencent.mm.wallet_core.ui.f.am(localf.mContext, localf.BaP.eDk());
            }
          }
        });
        AppMethodBeat.o(67071);
        return true;
      }
    });
    showOptionMenu(false);
    this.Bcc.setFocusable(true);
    this.Bcc.setFocusableInTouchMode(true);
    this.Bcc.requestFocus();
    AppMethodBeat.o(67076);
  }
  
  public final void k(String paramString, final Bitmap paramBitmap)
  {
    AppMethodBeat.i(67079);
    if ((paramString != null) && (paramString.equals(this.BaP.AZf))) {
      this.Bcc.post(new Runnable()
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
    com.tencent.mm.plugin.product.a.a.eDb();
    this.BaP = com.tencent.mm.plugin.product.a.a.eDc();
    this.Bby = new f(getContext(), new f.a()
    {
      public final void D(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString)
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
                ScrollView localScrollView = (ScrollView)MallProductUI.this.findViewById(2131304469);
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
          MallProductUI.this.aKi(paramAnonymousString);
        }
        AppMethodBeat.o(67064);
      }
    });
    paramBundle = this.Bby;
    Object localObject = getIntent();
    com.tencent.mm.plugin.product.b.m localm = new com.tencent.mm.plugin.product.b.m();
    g.aAk().postAtFrontOfWorker(new f.1(paramBundle, (Intent)localObject, localm));
    paramBundle.BaN = true;
    localObject = new qj();
    ((qj)localObject).dWL.errCode = -1;
    ((qj)localObject).callback = new f.2(paramBundle, (qj)localObject);
    EventCenter.instance.asyncPublish((IEvent)localObject, Looper.getMainLooper());
    AppMethodBeat.o(67073);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(67077);
    super.onNewIntent(paramIntent);
    Log.v("MicroMsg.MallProductUI", "onNewIntent");
    setIntent(paramIntent);
    AppMethodBeat.o(67077);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(67075);
    this.Bby.onStop();
    super.onPause();
    AppMethodBeat.o(67075);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(67074);
    super.onResume();
    this.Bby.onStart();
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
    Object localObject = this.BaP.AYX;
    if (localObject == null)
    {
      showOptionMenu(false);
      AppMethodBeat.o(67078);
      return;
    }
    showOptionMenu(true);
    setContentViewVisibility(0);
    this.Bca.setVisibility(0);
    this.Bcb.setVisibility(8);
    if (((com.tencent.mm.plugin.product.b.m)localObject).AZB != null)
    {
      this.jVn.setText(((com.tencent.mm.plugin.product.b.m)localObject).AZB.name);
      this.Bbs.setText(com.tencent.mm.plugin.product.b.b.C(((com.tencent.mm.plugin.product.b.m)localObject).AZB.AZM, ((com.tencent.mm.plugin.product.b.m)localObject).AZB.AZN, ((com.tencent.mm.plugin.product.b.m)localObject).AZB.AOl));
      this.Bcd.setText(com.tencent.mm.plugin.product.b.b.c(((com.tencent.mm.plugin.product.b.m)localObject).AZB.AZL, ((com.tencent.mm.plugin.product.b.m)localObject).AZB.AOl));
    }
    if (this.BaP.eDn() <= 0)
    {
      this.krs.setEnabled(false);
      this.krs.setText(2131762921);
      if ((((com.tencent.mm.plugin.product.b.m)localObject).AZB == null) || (((com.tencent.mm.plugin.product.b.m)localObject).AZB.AZV == null) || (((com.tencent.mm.plugin.product.b.m)localObject).AZB.AZV.size() <= 0)) {
        break label435;
      }
      this.BbX.setVisibility(0);
      this.BbY.fO(((com.tencent.mm.plugin.product.b.m)localObject).AZB.AZV);
      this.BbY.notifyDataSetChanged();
      label221:
      if ((((com.tencent.mm.plugin.product.b.m)localObject).AZB == null) || (Util.isNullOrNil(((com.tencent.mm.plugin.product.b.m)localObject).AZB.detail))) {
        break label447;
      }
      this.Bcf.setVisibility(0);
      this.Baw.setVisibility(0);
      this.Baw.setText(((com.tencent.mm.plugin.product.b.m)localObject).AZB.detail);
      label271:
      if (Util.isNullOrNil(((com.tencent.mm.plugin.product.b.m)localObject).AZG)) {
        break label468;
      }
      this.Bce.setVisibility(0);
      this.Bce.setText(((com.tencent.mm.plugin.product.b.m)localObject).AZG);
    }
    for (;;)
    {
      showOptionMenu(true);
      if (!Util.isNullOrNil(this.BaP.AZf))
      {
        localObject = com.tencent.mm.platformtools.u.a(new c(this.BaP.AZf));
        this.Bcc.setImageBitmap((Bitmap)localObject);
        com.tencent.mm.platformtools.u.a(this);
      }
      AppMethodBeat.o(67078);
      return;
      if (this.BaP.AYX.AZA <= 0)
      {
        this.krs.setEnabled(false);
        this.krs.setText(2131762920);
        break;
      }
      this.krs.setEnabled(true);
      if (!Util.isNullOrNil(((com.tencent.mm.plugin.product.b.m)localObject).AZF))
      {
        this.krs.setText(((com.tencent.mm.plugin.product.b.m)localObject).AZF);
        break;
      }
      this.krs.setText(2131762908);
      break;
      label435:
      this.BbX.setVisibility(8);
      break label221;
      label447:
      this.Bcf.setVisibility(8);
      this.Baw.setVisibility(8);
      break label271;
      label468:
      this.Bce.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductUI
 * JD-Core Version:    0.7.0.1
 */