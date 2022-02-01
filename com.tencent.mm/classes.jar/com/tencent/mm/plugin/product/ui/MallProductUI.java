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
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.sy;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.platformtools.r.a;
import com.tencent.mm.plugin.product.model.l;
import com.tencent.mm.plugin.product.model.m.a;
import com.tencent.mm.plugin.wxpay.a.b;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.k.d;
import com.tencent.mm.wallet_core.ui.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class MallProductUI
  extends MallBaseUI
  implements r.a
{
  private HtmlTextView MRX;
  private TextView MSS;
  private f MSY;
  protected com.tencent.mm.plugin.product.model.b MSp;
  private LinearLayout MTA;
  private LinearLayout MTB;
  private ImageView MTC;
  private TextView MTD;
  private HtmlTextView MTE;
  private RelativeLayout MTF;
  private ListView MTG;
  private k MTH = null;
  private Button MTI;
  private ListView MTx;
  private a MTy;
  private TextView pJi;
  private Button qgp;
  
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
        if (!Util.isNullOrNil(paramAnonymousMenuItem.MSp.MQB))
        {
          com.tencent.mm.kernel.h.baF();
          com.tencent.mm.kernel.h.baD().mCm.a(new com.tencent.mm.plugin.product.model.e(paramAnonymousMenuItem.MSp.gAo(), paramAnonymousMenuItem.MSp.MQB), 0);
        }
        paramAnonymousMenuItem.MSp.clear();
        MallProductUI.this.finish();
        AppMethodBeat.o(67065);
        return true;
      }
    });
    this.MTA = ((LinearLayout)findViewById(a.f.mall_product_normal_ll));
    this.MTB = ((LinearLayout)findViewById(a.f.mall_product_sold_out_ll));
    this.MTC = ((ImageView)findViewById(a.f.mall_product_img));
    this.pJi = ((TextView)findViewById(a.f.mall_product_desc));
    this.MSS = ((TextView)findViewById(a.f.mall_product_price));
    this.MTD = ((TextView)findViewById(a.f.mall_product_org_price));
    this.MTD.getPaint().setFlags(16);
    this.MTF = ((RelativeLayout)findViewById(a.f.mall_product_detail_rl));
    this.MRX = ((HtmlTextView)findViewById(a.f.mall_product_detail));
    this.MTE = ((HtmlTextView)findViewById(a.f.mall_product_oss_info));
    this.MTx = ((ListView)findViewById(a.f.mall_product_actions_lv));
    this.MTy = new a(this);
    this.MTx.setAdapter(this.MTy);
    this.MTx.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(67066);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).sc(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).hB(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/product/ui/MallProductUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
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
          Object localObject2 = MallProductUI.this.MSp.MQz;
          if ((((l)localObject2).MRd.MRp != null) && (((l)localObject2).MRd.MRp.size() > 0))
          {
            localObject1 = new ArrayList();
            localObject2 = ((l)localObject2).MRd.MRp.iterator();
            while (((Iterator)localObject2).hasNext()) {
              ((ArrayList)localObject1).add((String)((Iterator)localObject2).next());
            }
            paramAnonymousAdapterView.aeq = localObject1;
          }
        }
      }
    });
    this.MTI = ((Button)findViewById(a.f.mall_product_seller_btn));
    this.MTI.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67067);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/product/ui/MallProductUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        paramAnonymousView = MallProductUI.e(MallProductUI.this);
        i.ao(paramAnonymousView.mContext, paramAnonymousView.MSp.gAh());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/product/ui/MallProductUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(67067);
      }
    });
    this.MTG = ((ListView)findViewById(a.f.mall_product_sold_out_lv));
    this.MTH = new k(this);
    this.MTH.MTb = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(67068);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).sc(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).hB(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/product/ui/MallProductUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        paramAnonymousView = (m)paramAnonymousView.getTag();
        paramAnonymousAdapterView = MallProductUI.e(MallProductUI.this);
        if ((paramAnonymousView != null) && (paramAnonymousView.MTm != null))
        {
          paramAnonymousView = paramAnonymousView.MTm;
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
          i.aS(paramAnonymousAdapterView.mContext, (Intent)localObject);
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
    this.MTG.setAdapter(this.MTH);
    this.qgp = ((Button)findViewById(a.f.mall_product_go_sku_list));
    this.qgp.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67069);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/product/ui/MallProductUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
        paramAnonymousView = MallProductUI.e(MallProductUI.this);
        if (paramAnonymousView.MSp.gAl())
        {
          localObject1 = paramAnonymousView.mContext;
          Object localObject2 = new Intent(paramAnonymousView.mContext, MallProductSelectSkuUI.class);
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
          com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/plugin/product/ui/MallProductHelper", "goSelectSku", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Activity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/product/ui/MallProductHelper", "goSelectSku", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.plugin.report.service.h.OAn.b(11008, new Object[] { paramAnonymousView.MSp.gAh(), paramAnonymousView.MSp.MQz.MQZ, Integer.valueOf(f.mScene), Integer.valueOf(1) });
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/product/ui/MallProductUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(67069);
          return;
          aa.makeText(paramAnonymousView.mContext, a.i.mall_product_data_loading, 1).show();
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
        if ((MallProductUI.this.MSp.gAb().MSl & 0x1) > 0) {
          bool = true;
        }
        Log.d("MicroMsg.MallProductConfig", "isShowSellerEntry, ret = ".concat(String.valueOf(bool)));
        if (bool) {
          localArrayList.add(MallProductUI.this.getString(a.i.mall_product_seller_opt));
        }
        com.tencent.mm.ui.base.k.b(MallProductUI.this.getContext(), null, (String[])localArrayList.toArray(new String[localArrayList.size()]), null, new k.d()
        {
          public final void qz(int paramAnonymous2Int)
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
              Object localObject1 = localf.MSp.gAr();
              Object localObject2 = new Intent();
              ((Intent)localObject2).putExtra("Retr_Msg_content", (String)localObject1);
              ((Intent)localObject2).putExtra("Retr_Msg_Type", 2);
              if (!Util.isNullOrNil(localf.MSp.MQz.gAu())) {
                ((Intent)localObject2).putExtra("Retr_Msg_thumb_path", localf.MSp.gAi());
              }
              ((Intent)localObject2).putExtra("Retr_go_to_chattingUI", false);
              ((Intent)localObject2).putExtra("Retr_show_success_tips", true);
              ((Intent)localObject2).putExtra("Retr_Msg_Type", 2);
              com.tencent.mm.br.c.g(localf.mContext, ".ui.transmit.MsgRetransmitUI", (Intent)localObject2);
              if (f.mScene == 4) {
                com.tencent.mm.plugin.report.service.h.OAn.b(10651, new Object[] { Integer.valueOf(11), Integer.valueOf(1), Integer.valueOf(0) });
              }
              AppMethodBeat.o(67070);
              return;
              localf = MallProductUI.e(MallProductUI.this);
              localObject2 = localf.MSp.MQz;
              localObject1 = new Intent();
              ((Intent)localObject1).putExtra("KContentObjDesc", localf.MSp.gAs());
              ((Intent)localObject1).putExtra("Ksnsupload_title", ((l)localObject2).MRd.name);
              ((Intent)localObject1).putExtra("Ksnsupload_link", localf.MSp.gAj());
              ((Intent)localObject1).putExtra("Ksnsupload_imgurl", localf.MSp.MQz.gAu());
              if (!Util.isNullOrNil(localf.MSp.MQz.gAu())) {
                ((Intent)localObject1).putExtra("KsnsUpload_imgPath", localf.MSp.gAi());
              }
              ((Intent)localObject1).putExtra("Ksnsupload_type", 6);
              ((Intent)localObject1).putExtra("KUploadProduct_UserData", localf.MSp.a((l)localObject2));
              ((Intent)localObject1).putExtra("KUploadProduct_subType", ((l)localObject2).MRa);
              localObject2 = ad.Jo("scan_product");
              ad.bCb().M((String)localObject2, true).q("prePublishId", "scan_product");
              ((Intent)localObject1).putExtra("reportSessionId", (String)localObject2);
              com.tencent.mm.br.c.b(localf.mContext, "sns", ".ui.SnsUploadUI", (Intent)localObject1);
              if (f.mScene == 4) {
                com.tencent.mm.plugin.report.service.h.OAn.b(10651, new Object[] { Integer.valueOf(11), Integer.valueOf(0), Integer.valueOf(0) });
              }
              AppMethodBeat.o(67070);
              return;
              MallProductUI.e(MallProductUI.this).gAy();
              AppMethodBeat.o(67070);
              return;
              localf = MallProductUI.e(MallProductUI.this);
              i.an(localf.mContext, localf.MSp.gAh());
            }
          }
        });
        AppMethodBeat.o(67071);
        return true;
      }
    });
    showOptionMenu(false);
    this.MTC.setFocusable(true);
    this.MTC.setFocusableInTouchMode(true);
    this.MTC.requestFocus();
    AppMethodBeat.o(67076);
  }
  
  public final void k(String paramString, final Bitmap paramBitmap)
  {
    AppMethodBeat.i(67079);
    if ((paramString != null) && (paramString.equals(this.MSp.MQH))) {
      this.MTC.post(new Runnable()
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
    com.tencent.mm.plugin.product.a.a.gzY();
    this.MSp = com.tencent.mm.plugin.product.a.a.gzZ();
    this.MSY = new f(getContext(), new f.a()
    {
      public final void J(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString)
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
          MallProductUI.this.aRO(paramAnonymousString);
        }
        AppMethodBeat.o(67064);
      }
    });
    paramBundle = this.MSY;
    Object localObject = getIntent();
    l locall = new l();
    com.tencent.mm.kernel.h.baH().postAtFrontOfWorker(new f.1(paramBundle, (Intent)localObject, locall));
    paramBundle.MSn = true;
    localObject = new sy();
    ((sy)localObject).hWs.errCode = -1;
    ((sy)localObject).callback = new f.2(paramBundle, (sy)localObject);
    ((sy)localObject).asyncPublish(Looper.getMainLooper());
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
    this.MSY.onStop();
    super.onPause();
    AppMethodBeat.o(67075);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(67074);
    super.onResume();
    this.MSY.onStart();
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
    Object localObject = this.MSp.MQz;
    if (localObject == null)
    {
      showOptionMenu(false);
      AppMethodBeat.o(67078);
      return;
    }
    showOptionMenu(true);
    setContentViewVisibility(0);
    this.MTA.setVisibility(0);
    this.MTB.setVisibility(8);
    if (((l)localObject).MRd != null)
    {
      this.pJi.setText(((l)localObject).MRd.name);
      this.MSS.setText(com.tencent.mm.plugin.product.model.a.I(((l)localObject).MRd.MRn, ((l)localObject).MRd.MRo, ((l)localObject).MRd.MEq));
      this.MTD.setText(com.tencent.mm.plugin.product.model.a.d(((l)localObject).MRd.MRm, ((l)localObject).MRd.MEq));
    }
    if (this.MSp.gAk() <= 0)
    {
      this.qgp.setEnabled(false);
      this.qgp.setText(a.i.mall_product_sold_out);
      if ((((l)localObject).MRd == null) || (((l)localObject).MRd.MRw == null) || (((l)localObject).MRd.MRw.size() <= 0)) {
        break label435;
      }
      this.MTx.setVisibility(0);
      this.MTy.js(((l)localObject).MRd.MRw);
      this.MTy.notifyDataSetChanged();
      label221:
      if ((((l)localObject).MRd == null) || (Util.isNullOrNil(((l)localObject).MRd.detail))) {
        break label447;
      }
      this.MTF.setVisibility(0);
      this.MRX.setVisibility(0);
      this.MRX.setText(((l)localObject).MRd.detail);
      label271:
      if (Util.isNullOrNil(((l)localObject).MRi)) {
        break label468;
      }
      this.MTE.setVisibility(0);
      this.MTE.setText(((l)localObject).MRi);
    }
    for (;;)
    {
      showOptionMenu(true);
      if (!Util.isNullOrNil(this.MSp.MQH))
      {
        localObject = r.a(new c(this.MSp.MQH));
        this.MTC.setImageBitmap((Bitmap)localObject);
        r.a(this);
      }
      AppMethodBeat.o(67078);
      return;
      if (this.MSp.MQz.MRc <= 0)
      {
        this.qgp.setEnabled(false);
        this.qgp.setText(a.i.mall_product_sold_limit);
        break;
      }
      this.qgp.setEnabled(true);
      if (!Util.isNullOrNil(((l)localObject).MRh))
      {
        this.qgp.setText(((l)localObject).MRh);
        break;
      }
      this.qgp.setText(a.i.mall_product_go_sku_list);
      break;
      label435:
      this.MTx.setVisibility(8);
      break label221;
      label447:
      this.MTF.setVisibility(8);
      this.MRX.setVisibility(8);
      break label271;
      label468:
      this.MTE.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductUI
 * JD-Core Version:    0.7.0.1
 */