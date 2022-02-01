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
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.rj;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.product.b.n.a;
import com.tencent.mm.plugin.wxpay.a.b;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.wallet_core.ui.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class MallProductUI
  extends MallBaseUI
  implements u.a
{
  protected com.tencent.mm.plugin.product.b.c GUN;
  private HtmlTextView GUu;
  private ListView GVV;
  private a GVW;
  private LinearLayout GVY;
  private LinearLayout GVZ;
  private TextView GVq;
  private f GVw;
  private ImageView GWa;
  private TextView GWb;
  private HtmlTextView GWc;
  private RelativeLayout GWd;
  private ListView GWe;
  private k GWf = null;
  private Button GWg;
  private TextView mMA;
  private Button njb;
  
  public int getLayoutId()
  {
    return a.g.product_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(67076);
    setMMTitle(a.i.mall_product_title);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(67065);
        paramAnonymousMenuItem = MallProductUI.e(MallProductUI.this);
        if (!Util.isNullOrNil(paramAnonymousMenuItem.GUN.GSX))
        {
          com.tencent.mm.kernel.h.aHH();
          com.tencent.mm.kernel.h.aHF().kcd.a(new com.tencent.mm.plugin.product.b.f(paramAnonymousMenuItem.GUN.fpk(), paramAnonymousMenuItem.GUN.GSX), 0);
        }
        paramAnonymousMenuItem.GUN.clear();
        MallProductUI.this.finish();
        AppMethodBeat.o(67065);
        return true;
      }
    });
    this.GVY = ((LinearLayout)findViewById(a.f.mall_product_normal_ll));
    this.GVZ = ((LinearLayout)findViewById(a.f.mall_product_sold_out_ll));
    this.GWa = ((ImageView)findViewById(a.f.mall_product_img));
    this.mMA = ((TextView)findViewById(a.f.mall_product_desc));
    this.GVq = ((TextView)findViewById(a.f.mall_product_price));
    this.GWb = ((TextView)findViewById(a.f.mall_product_org_price));
    this.GWb.getPaint().setFlags(16);
    this.GWd = ((RelativeLayout)findViewById(a.f.mall_product_detail_rl));
    this.GUu = ((HtmlTextView)findViewById(a.f.mall_product_detail));
    this.GWc = ((HtmlTextView)findViewById(a.f.mall_product_oss_info));
    this.GVV = ((ListView)findViewById(a.f.mall_product_actions_lv));
    this.GVW = new a(this);
    this.GVV.setAdapter(this.GVW);
    this.GVV.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(67066);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).sg(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).Fs(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/product/ui/MallProductUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
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
          Object localObject2 = MallProductUI.this.GUN.GSV;
          if ((((com.tencent.mm.plugin.product.b.m)localObject2).GTz.GTM != null) && (((com.tencent.mm.plugin.product.b.m)localObject2).GTz.GTM.size() > 0))
          {
            localObject1 = new ArrayList();
            localObject2 = ((com.tencent.mm.plugin.product.b.m)localObject2).GTz.GTM.iterator();
            while (((Iterator)localObject2).hasNext()) {
              ((ArrayList)localObject1).add((String)((Iterator)localObject2).next());
            }
            paramAnonymousAdapterView.GUv = localObject1;
          }
        }
      }
    });
    this.GWg = ((Button)findViewById(a.f.mall_product_seller_btn));
    this.GWg.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67067);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/product/ui/MallProductUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = MallProductUI.e(MallProductUI.this);
        g.an(paramAnonymousView.mContext, paramAnonymousView.GUN.fpd());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/product/ui/MallProductUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(67067);
      }
    });
    this.GWe = ((ListView)findViewById(a.f.mall_product_sold_out_lv));
    this.GWf = new k(this);
    this.GWf.GVz = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(67068);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).Fs(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/product/ui/MallProductUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        paramAnonymousView = (m)paramAnonymousView.getTag();
        paramAnonymousAdapterView = MallProductUI.e(MallProductUI.this);
        if ((paramAnonymousView != null) && (paramAnonymousView.GVK != null))
        {
          paramAnonymousView = paramAnonymousView.GVK;
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
          g.aJ(paramAnonymousAdapterView.mContext, (Intent)localObject);
          continue;
          paramAnonymousView = paramAnonymousView.data.replace("product_id=", "");
          localObject = new Intent();
          ((Intent)localObject).putExtra("key_product_id", paramAnonymousView);
          ((Intent)localObject).putExtra("key_product_scene", 6);
          com.tencent.mm.by.c.b(paramAnonymousAdapterView.mContext, "mall", ".product.ui.MallProductUI", (Intent)localObject);
          paramAnonymousAdapterView.mContext.finish();
        }
      }
    };
    this.GWe.setAdapter(this.GWf);
    this.njb = ((Button)findViewById(a.f.mall_product_go_sku_list));
    this.njb.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67069);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/product/ui/MallProductUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
        paramAnonymousView = MallProductUI.e(MallProductUI.this);
        if (paramAnonymousView.GUN.fph())
        {
          localObject1 = paramAnonymousView.mContext;
          Object localObject2 = new Intent(paramAnonymousView.mContext, MallProductSelectSkuUI.class);
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject2);
          com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/plugin/product/ui/MallProductHelper", "goSelectSku", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Activity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/product/ui/MallProductHelper", "goSelectSku", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.plugin.report.service.h.IzE.a(11008, new Object[] { paramAnonymousView.GUN.fpd(), paramAnonymousView.GUN.GSV.GTv, Integer.valueOf(f.mScene), Integer.valueOf(1) });
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/product/ui/MallProductUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(67069);
          return;
          w.makeText(paramAnonymousView.mContext, a.i.mall_product_data_loading, 1).show();
        }
      }
    });
    addIconOptionMenu(0, a.h.icons_outlined_more, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        boolean bool = false;
        AppMethodBeat.i(67071);
        paramAnonymousMenuItem = MallProductUI.this.getResources().getStringArray(a.b.mall_product_share_opt_list);
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        while (i < paramAnonymousMenuItem.length)
        {
          localArrayList.add(paramAnonymousMenuItem[i]);
          i += 1;
        }
        if ((MallProductUI.this.GUN.foX().GUJ & 0x1) > 0) {
          bool = true;
        }
        Log.d("MicroMsg.MallProductConfig", "isShowSellerEntry, ret = ".concat(String.valueOf(bool)));
        if (bool) {
          localArrayList.add(MallProductUI.this.getString(a.i.mall_product_seller_opt));
        }
        com.tencent.mm.ui.base.h.b(MallProductUI.this.getContext(), null, (String[])localArrayList.toArray(new String[localArrayList.size()]), null, new h.d()
        {
          public final void qy(int paramAnonymous2Int)
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
              Object localObject1 = localf.GUN.fpn();
              Object localObject2 = new Intent();
              ((Intent)localObject2).putExtra("Retr_Msg_content", (String)localObject1);
              ((Intent)localObject2).putExtra("Retr_Msg_Type", 2);
              if (!Util.isNullOrNil(localf.GUN.GSV.fpq())) {
                ((Intent)localObject2).putExtra("Retr_Msg_thumb_path", localf.GUN.fpe());
              }
              ((Intent)localObject2).putExtra("Retr_go_to_chattingUI", false);
              ((Intent)localObject2).putExtra("Retr_show_success_tips", true);
              ((Intent)localObject2).putExtra("Retr_Msg_Type", 2);
              com.tencent.mm.by.c.f(localf.mContext, ".ui.transmit.MsgRetransmitUI", (Intent)localObject2);
              if (f.mScene == 4) {
                com.tencent.mm.plugin.report.service.h.IzE.a(10651, new Object[] { Integer.valueOf(11), Integer.valueOf(1), Integer.valueOf(0) });
              }
              AppMethodBeat.o(67070);
              return;
              localf = MallProductUI.e(MallProductUI.this);
              localObject2 = localf.GUN.GSV;
              localObject1 = new Intent();
              ((Intent)localObject1).putExtra("KContentObjDesc", localf.GUN.fpo());
              ((Intent)localObject1).putExtra("Ksnsupload_title", ((com.tencent.mm.plugin.product.b.m)localObject2).GTz.name);
              ((Intent)localObject1).putExtra("Ksnsupload_link", localf.GUN.fpf());
              ((Intent)localObject1).putExtra("Ksnsupload_imgurl", localf.GUN.GSV.fpq());
              if (!Util.isNullOrNil(localf.GUN.GSV.fpq())) {
                ((Intent)localObject1).putExtra("KsnsUpload_imgPath", localf.GUN.fpe());
              }
              ((Intent)localObject1).putExtra("Ksnsupload_type", 6);
              ((Intent)localObject1).putExtra("KUploadProduct_UserData", localf.GUN.a((com.tencent.mm.plugin.product.b.m)localObject2));
              ((Intent)localObject1).putExtra("KUploadProduct_subType", ((com.tencent.mm.plugin.product.b.m)localObject2).GTw);
              localObject2 = ad.Rp("scan_product");
              ad.beh().I((String)localObject2, true).k("prePublishId", "scan_product");
              ((Intent)localObject1).putExtra("reportSessionId", (String)localObject2);
              com.tencent.mm.by.c.b(localf.mContext, "sns", ".ui.SnsUploadUI", (Intent)localObject1);
              if (f.mScene == 4) {
                com.tencent.mm.plugin.report.service.h.IzE.a(10651, new Object[] { Integer.valueOf(11), Integer.valueOf(0), Integer.valueOf(0) });
              }
              AppMethodBeat.o(67070);
              return;
              MallProductUI.e(MallProductUI.this).fpu();
              AppMethodBeat.o(67070);
              return;
              localf = MallProductUI.e(MallProductUI.this);
              g.am(localf.mContext, localf.GUN.fpd());
            }
          }
        });
        AppMethodBeat.o(67071);
        return true;
      }
    });
    showOptionMenu(false);
    this.GWa.setFocusable(true);
    this.GWa.setFocusableInTouchMode(true);
    this.GWa.requestFocus();
    AppMethodBeat.o(67076);
  }
  
  public final void k(String paramString, final Bitmap paramBitmap)
  {
    AppMethodBeat.i(67079);
    if ((paramString != null) && (paramString.equals(this.GUN.GTd))) {
      this.GWa.post(new Runnable()
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
    com.tencent.mm.plugin.product.a.a.foU();
    this.GUN = com.tencent.mm.plugin.product.a.a.foV();
    this.GVw = new f(getContext(), new f.a()
    {
      public final void F(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString)
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
                ScrollView localScrollView = (ScrollView)MallProductUI.this.findViewById(a.f.mall_product_sv);
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
          MallProductUI.this.aUG(paramAnonymousString);
        }
        AppMethodBeat.o(67064);
      }
    });
    paramBundle = this.GVw;
    Object localObject = getIntent();
    com.tencent.mm.plugin.product.b.m localm = new com.tencent.mm.plugin.product.b.m();
    com.tencent.mm.kernel.h.aHJ().postAtFrontOfWorker(new f.1(paramBundle, (Intent)localObject, localm));
    paramBundle.GUL = true;
    localObject = new rj();
    ((rj)localObject).fQx.errCode = -1;
    ((rj)localObject).callback = new f.2(paramBundle, (rj)localObject);
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
    this.GVw.onStop();
    super.onPause();
    AppMethodBeat.o(67075);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(67074);
    super.onResume();
    this.GVw.onStart();
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
    Object localObject = this.GUN.GSV;
    if (localObject == null)
    {
      showOptionMenu(false);
      AppMethodBeat.o(67078);
      return;
    }
    showOptionMenu(true);
    setContentViewVisibility(0);
    this.GVY.setVisibility(0);
    this.GVZ.setVisibility(8);
    if (((com.tencent.mm.plugin.product.b.m)localObject).GTz != null)
    {
      this.mMA.setText(((com.tencent.mm.plugin.product.b.m)localObject).GTz.name);
      this.GVq.setText(com.tencent.mm.plugin.product.b.b.E(((com.tencent.mm.plugin.product.b.m)localObject).GTz.GTK, ((com.tencent.mm.plugin.product.b.m)localObject).GTz.GTL, ((com.tencent.mm.plugin.product.b.m)localObject).GTz.GHz));
      this.GWb.setText(com.tencent.mm.plugin.product.b.b.c(((com.tencent.mm.plugin.product.b.m)localObject).GTz.GTJ, ((com.tencent.mm.plugin.product.b.m)localObject).GTz.GHz));
    }
    if (this.GUN.fpg() <= 0)
    {
      this.njb.setEnabled(false);
      this.njb.setText(a.i.mall_product_sold_out);
      if ((((com.tencent.mm.plugin.product.b.m)localObject).GTz == null) || (((com.tencent.mm.plugin.product.b.m)localObject).GTz.GTT == null) || (((com.tencent.mm.plugin.product.b.m)localObject).GTz.GTT.size() <= 0)) {
        break label435;
      }
      this.GVV.setVisibility(0);
      this.GVW.gs(((com.tencent.mm.plugin.product.b.m)localObject).GTz.GTT);
      this.GVW.notifyDataSetChanged();
      label221:
      if ((((com.tencent.mm.plugin.product.b.m)localObject).GTz == null) || (Util.isNullOrNil(((com.tencent.mm.plugin.product.b.m)localObject).GTz.detail))) {
        break label447;
      }
      this.GWd.setVisibility(0);
      this.GUu.setVisibility(0);
      this.GUu.setText(((com.tencent.mm.plugin.product.b.m)localObject).GTz.detail);
      label271:
      if (Util.isNullOrNil(((com.tencent.mm.plugin.product.b.m)localObject).GTE)) {
        break label468;
      }
      this.GWc.setVisibility(0);
      this.GWc.setText(((com.tencent.mm.plugin.product.b.m)localObject).GTE);
    }
    for (;;)
    {
      showOptionMenu(true);
      if (!Util.isNullOrNil(this.GUN.GTd))
      {
        localObject = u.a(new c(this.GUN.GTd));
        this.GWa.setImageBitmap((Bitmap)localObject);
        u.a(this);
      }
      AppMethodBeat.o(67078);
      return;
      if (this.GUN.GSV.GTy <= 0)
      {
        this.njb.setEnabled(false);
        this.njb.setText(a.i.mall_product_sold_limit);
        break;
      }
      this.njb.setEnabled(true);
      if (!Util.isNullOrNil(((com.tencent.mm.plugin.product.b.m)localObject).GTD))
      {
        this.njb.setText(((com.tencent.mm.plugin.product.b.m)localObject).GTD);
        break;
      }
      this.njb.setText(a.i.mall_product_go_sku_list);
      break;
      label435:
      this.GVV.setVisibility(8);
      break label221;
      label447:
      this.GWd.setVisibility(8);
      this.GUu.setVisibility(8);
      break label271;
      label468:
      this.GWc.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductUI
 * JD-Core Version:    0.7.0.1
 */