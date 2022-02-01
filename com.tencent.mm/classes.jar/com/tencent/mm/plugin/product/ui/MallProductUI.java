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
import com.tencent.mm.g.a.pg;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.product.b.n.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
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
  private Button iXb;
  private TextView lgw;
  private TextView vGV;
  private HtmlTextView vGa;
  protected com.tencent.mm.plugin.product.b.c vGs;
  private ListView vHA;
  private a vHB;
  private LinearLayout vHD;
  private LinearLayout vHE;
  private ImageView vHF;
  private TextView vHG;
  private HtmlTextView vHH;
  private RelativeLayout vHI;
  private ListView vHJ;
  private k vHK = null;
  private Button vHL;
  private f vHb;
  
  protected final void cL()
  {
    AppMethodBeat.i(67078);
    Object localObject = this.vGs.vEB;
    if (localObject == null)
    {
      showOptionMenu(false);
      AppMethodBeat.o(67078);
      return;
    }
    showOptionMenu(true);
    setContentViewVisibility(0);
    this.vHD.setVisibility(0);
    this.vHE.setVisibility(8);
    if (((com.tencent.mm.plugin.product.b.m)localObject).vFf != null)
    {
      this.lgw.setText(((com.tencent.mm.plugin.product.b.m)localObject).vFf.name);
      this.vGV.setText(com.tencent.mm.plugin.product.b.b.C(((com.tencent.mm.plugin.product.b.m)localObject).vFf.vFq, ((com.tencent.mm.plugin.product.b.m)localObject).vFf.vFr, ((com.tencent.mm.plugin.product.b.m)localObject).vFf.vxl));
      this.vHG.setText(com.tencent.mm.plugin.product.b.b.c(((com.tencent.mm.plugin.product.b.m)localObject).vFf.vFp, ((com.tencent.mm.plugin.product.b.m)localObject).vFf.vxl));
    }
    if (this.vGs.dpc() <= 0)
    {
      this.iXb.setEnabled(false);
      this.iXb.setText(2131761134);
      if ((((com.tencent.mm.plugin.product.b.m)localObject).vFf == null) || (((com.tencent.mm.plugin.product.b.m)localObject).vFf.vFz == null) || (((com.tencent.mm.plugin.product.b.m)localObject).vFf.vFz.size() <= 0)) {
        break label431;
      }
      this.vHA.setVisibility(0);
      this.vHB.ey(((com.tencent.mm.plugin.product.b.m)localObject).vFf.vFz);
      this.vHB.notifyDataSetChanged();
      label218:
      if ((((com.tencent.mm.plugin.product.b.m)localObject).vFf == null) || (bs.isNullOrNil(((com.tencent.mm.plugin.product.b.m)localObject).vFf.detail))) {
        break label443;
      }
      this.vHI.setVisibility(0);
      this.vGa.setVisibility(0);
      this.vGa.setText(((com.tencent.mm.plugin.product.b.m)localObject).vFf.detail);
      label268:
      if (bs.isNullOrNil(((com.tencent.mm.plugin.product.b.m)localObject).vFk)) {
        break label464;
      }
      this.vHH.setVisibility(0);
      this.vHH.setText(((com.tencent.mm.plugin.product.b.m)localObject).vFk);
    }
    for (;;)
    {
      showOptionMenu(true);
      if (!bs.isNullOrNil(this.vGs.vEJ))
      {
        localObject = u.a(new c(this.vGs.vEJ));
        this.vHF.setImageBitmap((Bitmap)localObject);
        u.a(this);
      }
      AppMethodBeat.o(67078);
      return;
      if (this.vGs.vEB.vFe <= 0)
      {
        this.iXb.setEnabled(false);
        this.iXb.setText(2131761133);
        break;
      }
      this.iXb.setEnabled(true);
      if (!bs.isNullOrNil(((com.tencent.mm.plugin.product.b.m)localObject).vFj))
      {
        this.iXb.setText(((com.tencent.mm.plugin.product.b.m)localObject).vFj);
        break;
      }
      this.iXb.setText(2131761121);
      break;
      label431:
      this.vHA.setVisibility(8);
      break label218;
      label443:
      this.vHI.setVisibility(8);
      this.vGa.setVisibility(8);
      break label268;
      label464:
      this.vHH.setVisibility(8);
    }
  }
  
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
        if (!bs.isNullOrNil(paramAnonymousMenuItem.vGs.vED))
        {
          g.agS();
          g.agQ().ghe.a(new com.tencent.mm.plugin.product.b.f(paramAnonymousMenuItem.vGs.dpg(), paramAnonymousMenuItem.vGs.vED), 0);
        }
        paramAnonymousMenuItem.vGs.clear();
        MallProductUI.this.finish();
        AppMethodBeat.o(67065);
        return true;
      }
    });
    this.vHD = ((LinearLayout)findViewById(2131302092));
    this.vHE = ((LinearLayout)findViewById(2131302113));
    this.vHF = ((ImageView)findViewById(2131302090));
    this.lgw = ((TextView)findViewById(2131302086));
    this.vGV = ((TextView)findViewById(2131302095));
    this.vHG = ((TextView)findViewById(2131302093));
    this.vHG.getPaint().setFlags(16);
    this.vHI = ((RelativeLayout)findViewById(2131302088));
    this.vGa = ((HtmlTextView)findViewById(2131302087));
    this.vHH = ((HtmlTextView)findViewById(2131302094));
    this.vHA = ((ListView)findViewById(2131302085));
    this.vHB = new a(this);
    this.vHA.setAdapter(this.vHB);
    this.vHA.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(67066);
        paramAnonymousAdapterView = (b)paramAnonymousView.getTag();
        switch (paramAnonymousAdapterView.type)
        {
        }
        for (;;)
        {
          MallProductUI.f(MallProductUI.this).a(MallProductUI.this, paramAnonymousView, paramAnonymousInt);
          AppMethodBeat.o(67066);
          return;
          Object localObject = MallProductUI.this.vGs.vEB;
          if ((((com.tencent.mm.plugin.product.b.m)localObject).vFf.vFs != null) && (((com.tencent.mm.plugin.product.b.m)localObject).vFf.vFs.size() > 0))
          {
            ArrayList localArrayList = new ArrayList();
            localObject = ((com.tencent.mm.plugin.product.b.m)localObject).vFf.vFs.iterator();
            while (((Iterator)localObject).hasNext()) {
              localArrayList.add((String)((Iterator)localObject).next());
            }
            paramAnonymousAdapterView.vGb = localArrayList;
          }
        }
      }
    });
    this.vHL = ((Button)findViewById(2131302105));
    this.vHL.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67067);
        paramAnonymousView = MallProductUI.e(MallProductUI.this);
        com.tencent.mm.wallet_core.ui.e.ae(paramAnonymousView.jHh, paramAnonymousView.vGs.doZ());
        AppMethodBeat.o(67067);
      }
    });
    this.vHJ = ((ListView)findViewById(2131302114));
    this.vHK = new k(this);
    this.vHK.vHe = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(67068);
        paramAnonymousView = (m)paramAnonymousView.getTag();
        paramAnonymousAdapterView = MallProductUI.e(MallProductUI.this);
        if ((paramAnonymousView != null) && (paramAnonymousView.vHp != null))
        {
          paramAnonymousView = paramAnonymousView.vHp;
          ac.i("MicroMsg.MallProductUI", "goProductUI type : " + paramAnonymousView.type);
          switch (paramAnonymousView.type)
          {
          }
        }
        for (;;)
        {
          AppMethodBeat.o(67068);
          return;
          Intent localIntent = new Intent();
          localIntent.putExtra("rawUrl", paramAnonymousView.url);
          com.tencent.mm.wallet_core.ui.e.al(paramAnonymousAdapterView.jHh, localIntent);
          AppMethodBeat.o(67068);
          return;
          paramAnonymousView = paramAnonymousView.data.replace("product_id=", "");
          localIntent = new Intent();
          localIntent.putExtra("key_product_id", paramAnonymousView);
          localIntent.putExtra("key_product_scene", 6);
          d.b(paramAnonymousAdapterView.jHh, "mall", ".product.ui.MallProductUI", localIntent);
          paramAnonymousAdapterView.jHh.finish();
        }
      }
    };
    this.vHJ.setAdapter(this.vHK);
    this.iXb = ((Button)findViewById(2131302089));
    this.iXb.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67069);
        paramAnonymousView = MallProductUI.e(MallProductUI.this);
        if (paramAnonymousView.vGs.dpd())
        {
          Activity localActivity = paramAnonymousView.jHh;
          Object localObject = new Intent(paramAnonymousView.jHh, MallProductSelectSkuUI.class);
          localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(localActivity, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/product/ui/MallProductHelper", "goSelectSku", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localActivity.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(localActivity, "com/tencent/mm/plugin/product/ui/MallProductHelper", "goSelectSku", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.plugin.report.service.h.wUl.f(11008, new Object[] { paramAnonymousView.vGs.doZ(), paramAnonymousView.vGs.vEB.vFb, Integer.valueOf(f.mScene), Integer.valueOf(1) });
          AppMethodBeat.o(67069);
          return;
        }
        t.makeText(paramAnonymousView.jHh, 2131761119, 1).show();
        AppMethodBeat.o(67069);
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
        if ((MallProductUI.this.vGs.doT().vGo & 0x1) > 0) {
          bool = true;
        }
        ac.d("MicroMsg.MallProductConfig", "isShowSellerEntry, ret = ".concat(String.valueOf(bool)));
        if (bool) {
          localArrayList.add(MallProductUI.this.getString(2131761132));
        }
        com.tencent.mm.ui.base.h.b(MallProductUI.this.getContext(), null, (String[])localArrayList.toArray(new String[localArrayList.size()]), null, new h.c()
        {
          public final void kG(int paramAnonymous2Int)
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
              Object localObject1 = localf.vGs.dpj();
              Object localObject2 = new Intent();
              ((Intent)localObject2).putExtra("Retr_Msg_content", (String)localObject1);
              ((Intent)localObject2).putExtra("Retr_Msg_Type", 2);
              if (!bs.isNullOrNil(localf.vGs.vEB.dpm())) {
                ((Intent)localObject2).putExtra("Retr_Msg_thumb_path", localf.vGs.dpa());
              }
              ((Intent)localObject2).putExtra("Retr_go_to_chattingUI", false);
              ((Intent)localObject2).putExtra("Retr_show_success_tips", true);
              ((Intent)localObject2).putExtra("Retr_Msg_Type", 2);
              d.e(localf.jHh, ".ui.transmit.MsgRetransmitUI", (Intent)localObject2);
              if (f.mScene == 4) {
                com.tencent.mm.plugin.report.service.h.wUl.f(10651, new Object[] { Integer.valueOf(11), Integer.valueOf(1), Integer.valueOf(0) });
              }
              AppMethodBeat.o(67070);
              return;
              localf = MallProductUI.e(MallProductUI.this);
              localObject2 = localf.vGs.vEB;
              localObject1 = new Intent();
              ((Intent)localObject1).putExtra("KContentObjDesc", localf.vGs.dpk());
              ((Intent)localObject1).putExtra("Ksnsupload_title", ((com.tencent.mm.plugin.product.b.m)localObject2).vFf.name);
              ((Intent)localObject1).putExtra("Ksnsupload_link", localf.vGs.dpb());
              ((Intent)localObject1).putExtra("Ksnsupload_imgurl", localf.vGs.vEB.dpm());
              if (!bs.isNullOrNil(localf.vGs.vEB.dpm())) {
                ((Intent)localObject1).putExtra("KsnsUpload_imgPath", localf.vGs.dpa());
              }
              ((Intent)localObject1).putExtra("Ksnsupload_type", 6);
              ((Intent)localObject1).putExtra("KUploadProduct_UserData", localf.vGs.a((com.tencent.mm.plugin.product.b.m)localObject2));
              ((Intent)localObject1).putExtra("KUploadProduct_subType", ((com.tencent.mm.plugin.product.b.m)localObject2).vFc);
              localObject2 = y.xJ("scan_product");
              y.ayq().F((String)localObject2, true).l("prePublishId", "scan_product");
              ((Intent)localObject1).putExtra("reportSessionId", (String)localObject2);
              d.b(localf.jHh, "sns", ".ui.SnsUploadUI", (Intent)localObject1);
              if (f.mScene == 4) {
                com.tencent.mm.plugin.report.service.h.wUl.f(10651, new Object[] { Integer.valueOf(11), Integer.valueOf(0), Integer.valueOf(0) });
              }
              AppMethodBeat.o(67070);
              return;
              MallProductUI.e(MallProductUI.this).dpq();
              AppMethodBeat.o(67070);
              return;
              localf = MallProductUI.e(MallProductUI.this);
              com.tencent.mm.wallet_core.ui.e.ad(localf.jHh, localf.vGs.doZ());
            }
          }
        });
        AppMethodBeat.o(67071);
        return true;
      }
    });
    showOptionMenu(false);
    this.vHF.setFocusable(true);
    this.vHF.setFocusableInTouchMode(true);
    this.vHF.requestFocus();
    AppMethodBeat.o(67076);
  }
  
  public final void k(String paramString, final Bitmap paramBitmap)
  {
    AppMethodBeat.i(67079);
    if ((paramString != null) && (paramString.equals(this.vGs.vEJ))) {
      this.vHF.post(new Runnable()
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
    com.tencent.mm.plugin.product.a.a.doQ();
    this.vGs = com.tencent.mm.plugin.product.a.a.doR();
    this.vHb = new f(getContext(), new f.a()
    {
      public final void D(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString)
      {
        AppMethodBeat.i(67064);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          MallProductUI.this.cL();
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
          MallProductUI.this.apv(paramAnonymousString);
        }
        AppMethodBeat.o(67064);
      }
    });
    paramBundle = this.vHb;
    Object localObject = getIntent();
    com.tencent.mm.plugin.product.b.m localm = new com.tencent.mm.plugin.product.b.m();
    g.agU().a(new f.1(paramBundle, (Intent)localObject, localm));
    paramBundle.vGq = true;
    localObject = new pg();
    ((pg)localObject).dsa.errCode = -1;
    ((pg)localObject).callback = new f.2(paramBundle, (pg)localObject);
    com.tencent.mm.sdk.b.a.GpY.a((com.tencent.mm.sdk.b.b)localObject, Looper.getMainLooper());
    AppMethodBeat.o(67073);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(67077);
    super.onNewIntent(paramIntent);
    ac.v("MicroMsg.MallProductUI", "onNewIntent");
    setIntent(paramIntent);
    AppMethodBeat.o(67077);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(67075);
    this.vHb.onStop();
    super.onPause();
    AppMethodBeat.o(67075);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(67074);
    super.onResume();
    this.vHb.onStart();
    AppMethodBeat.o(67074);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductUI
 * JD-Core Version:    0.7.0.1
 */