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
import com.tencent.mm.g.a.ox;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.product.b.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
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
  private Button iwY;
  private TextView kFd;
  private HtmlTextView uxh;
  protected com.tencent.mm.plugin.product.b.c uxz;
  private ListView uyH;
  private a uyI;
  private LinearLayout uyK;
  private LinearLayout uyL;
  private ImageView uyM;
  private TextView uyN;
  private HtmlTextView uyO;
  private RelativeLayout uyP;
  private ListView uyQ;
  private k uyR = null;
  private Button uyS;
  private TextView uyc;
  private f uyi;
  
  protected final void cE()
  {
    AppMethodBeat.i(67078);
    Object localObject = this.uxz.uvI;
    if (localObject == null)
    {
      showOptionMenu(false);
      AppMethodBeat.o(67078);
      return;
    }
    showOptionMenu(true);
    setContentViewVisibility(0);
    this.uyK.setVisibility(0);
    this.uyL.setVisibility(8);
    if (((m)localObject).uwm != null)
    {
      this.kFd.setText(((m)localObject).uwm.name);
      this.uyc.setText(com.tencent.mm.plugin.product.b.b.D(((m)localObject).uwm.uwx, ((m)localObject).uwm.uwy, ((m)localObject).uwm.uop));
      this.uyN.setText(com.tencent.mm.plugin.product.b.b.c(((m)localObject).uwm.uww, ((m)localObject).uwm.uop));
    }
    if (this.uxz.dbu() <= 0)
    {
      this.iwY.setEnabled(false);
      this.iwY.setText(2131761134);
      if ((((m)localObject).uwm == null) || (((m)localObject).uwm.uwG == null) || (((m)localObject).uwm.uwG.size() <= 0)) {
        break label431;
      }
      this.uyH.setVisibility(0);
      this.uyI.eu(((m)localObject).uwm.uwG);
      this.uyI.notifyDataSetChanged();
      label218:
      if ((((m)localObject).uwm == null) || (bt.isNullOrNil(((m)localObject).uwm.detail))) {
        break label443;
      }
      this.uyP.setVisibility(0);
      this.uxh.setVisibility(0);
      this.uxh.setText(((m)localObject).uwm.detail);
      label268:
      if (bt.isNullOrNil(((m)localObject).uwr)) {
        break label464;
      }
      this.uyO.setVisibility(0);
      this.uyO.setText(((m)localObject).uwr);
    }
    for (;;)
    {
      showOptionMenu(true);
      if (!bt.isNullOrNil(this.uxz.uvQ))
      {
        localObject = u.a(new c(this.uxz.uvQ));
        this.uyM.setImageBitmap((Bitmap)localObject);
        u.a(this);
      }
      AppMethodBeat.o(67078);
      return;
      if (this.uxz.uvI.uwl <= 0)
      {
        this.iwY.setEnabled(false);
        this.iwY.setText(2131761133);
        break;
      }
      this.iwY.setEnabled(true);
      if (!bt.isNullOrNil(((m)localObject).uwq))
      {
        this.iwY.setText(((m)localObject).uwq);
        break;
      }
      this.iwY.setText(2131761121);
      break;
      label431:
      this.uyH.setVisibility(8);
      break label218;
      label443:
      this.uyP.setVisibility(8);
      this.uxh.setVisibility(8);
      break label268;
      label464:
      this.uyO.setVisibility(8);
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
        if (!bt.isNullOrNil(paramAnonymousMenuItem.uxz.uvK))
        {
          g.afC();
          g.afA().gcy.a(new com.tencent.mm.plugin.product.b.f(paramAnonymousMenuItem.uxz.dby(), paramAnonymousMenuItem.uxz.uvK), 0);
        }
        paramAnonymousMenuItem.uxz.clear();
        MallProductUI.this.finish();
        AppMethodBeat.o(67065);
        return true;
      }
    });
    this.uyK = ((LinearLayout)findViewById(2131302092));
    this.uyL = ((LinearLayout)findViewById(2131302113));
    this.uyM = ((ImageView)findViewById(2131302090));
    this.kFd = ((TextView)findViewById(2131302086));
    this.uyc = ((TextView)findViewById(2131302095));
    this.uyN = ((TextView)findViewById(2131302093));
    this.uyN.getPaint().setFlags(16);
    this.uyP = ((RelativeLayout)findViewById(2131302088));
    this.uxh = ((HtmlTextView)findViewById(2131302087));
    this.uyO = ((HtmlTextView)findViewById(2131302094));
    this.uyH = ((ListView)findViewById(2131302085));
    this.uyI = new a(this);
    this.uyH.setAdapter(this.uyI);
    this.uyH.setOnItemClickListener(new AdapterView.OnItemClickListener()
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
          Object localObject = MallProductUI.this.uxz.uvI;
          if ((((m)localObject).uwm.uwz != null) && (((m)localObject).uwm.uwz.size() > 0))
          {
            ArrayList localArrayList = new ArrayList();
            localObject = ((m)localObject).uwm.uwz.iterator();
            while (((Iterator)localObject).hasNext()) {
              localArrayList.add((String)((Iterator)localObject).next());
            }
            paramAnonymousAdapterView.uxi = localArrayList;
          }
        }
      }
    });
    this.uyS = ((Button)findViewById(2131302105));
    this.uyS.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67067);
        paramAnonymousView = MallProductUI.e(MallProductUI.this);
        com.tencent.mm.wallet_core.ui.e.ad(paramAnonymousView.jgS, paramAnonymousView.uxz.dbr());
        AppMethodBeat.o(67067);
      }
    });
    this.uyQ = ((ListView)findViewById(2131302114));
    this.uyR = new k(this);
    this.uyR.uyl = new MallProductUI.5(this);
    this.uyQ.setAdapter(this.uyR);
    this.iwY = ((Button)findViewById(2131302089));
    this.iwY.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67069);
        paramAnonymousView = MallProductUI.e(MallProductUI.this);
        if (paramAnonymousView.uxz.dbv())
        {
          Activity localActivity = paramAnonymousView.jgS;
          Object localObject = new Intent(paramAnonymousView.jgS, MallProductSelectSkuUI.class);
          localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(localActivity, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/product/ui/MallProductHelper", "goSelectSku", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localActivity.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(localActivity, "com/tencent/mm/plugin/product/ui/MallProductHelper", "goSelectSku", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.plugin.report.service.h.vKh.f(11008, new Object[] { paramAnonymousView.uxz.dbr(), paramAnonymousView.uxz.uvI.uwi, Integer.valueOf(f.mScene), Integer.valueOf(1) });
          AppMethodBeat.o(67069);
          return;
        }
        t.makeText(paramAnonymousView.jgS, 2131761119, 1).show();
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
        if ((MallProductUI.this.uxz.dbl().uxv & 0x1) > 0) {
          bool = true;
        }
        ad.d("MicroMsg.MallProductConfig", "isShowSellerEntry, ret = ".concat(String.valueOf(bool)));
        if (bool) {
          localArrayList.add(MallProductUI.this.getString(2131761132));
        }
        com.tencent.mm.ui.base.h.b(MallProductUI.this.getContext(), null, (String[])localArrayList.toArray(new String[localArrayList.size()]), null, new h.c()
        {
          public final void kM(int paramAnonymous2Int)
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
              Object localObject1 = localf.uxz.dbB();
              Object localObject2 = new Intent();
              ((Intent)localObject2).putExtra("Retr_Msg_content", (String)localObject1);
              ((Intent)localObject2).putExtra("Retr_Msg_Type", 2);
              if (!bt.isNullOrNil(localf.uxz.uvI.dbE())) {
                ((Intent)localObject2).putExtra("Retr_Msg_thumb_path", localf.uxz.dbs());
              }
              ((Intent)localObject2).putExtra("Retr_go_to_chattingUI", false);
              ((Intent)localObject2).putExtra("Retr_show_success_tips", true);
              ((Intent)localObject2).putExtra("Retr_Msg_Type", 2);
              d.e(localf.jgS, ".ui.transmit.MsgRetransmitUI", (Intent)localObject2);
              if (f.mScene == 4) {
                com.tencent.mm.plugin.report.service.h.vKh.f(10651, new Object[] { Integer.valueOf(11), Integer.valueOf(1), Integer.valueOf(0) });
              }
              AppMethodBeat.o(67070);
              return;
              localf = MallProductUI.e(MallProductUI.this);
              localObject2 = localf.uxz.uvI;
              localObject1 = new Intent();
              ((Intent)localObject1).putExtra("KContentObjDesc", localf.uxz.dbC());
              ((Intent)localObject1).putExtra("Ksnsupload_title", ((m)localObject2).uwm.name);
              ((Intent)localObject1).putExtra("Ksnsupload_link", localf.uxz.dbt());
              ((Intent)localObject1).putExtra("Ksnsupload_imgurl", localf.uxz.uvI.dbE());
              if (!bt.isNullOrNil(localf.uxz.uvI.dbE())) {
                ((Intent)localObject1).putExtra("KsnsUpload_imgPath", localf.uxz.dbs());
              }
              ((Intent)localObject1).putExtra("Ksnsupload_type", 6);
              ((Intent)localObject1).putExtra("KUploadProduct_UserData", localf.uxz.a((m)localObject2));
              ((Intent)localObject1).putExtra("KUploadProduct_subType", ((m)localObject2).uwj);
              localObject2 = y.tD("scan_product");
              y.arz().E((String)localObject2, true).m("prePublishId", "scan_product");
              ((Intent)localObject1).putExtra("reportSessionId", (String)localObject2);
              d.b(localf.jgS, "sns", ".ui.SnsUploadUI", (Intent)localObject1);
              if (f.mScene == 4) {
                com.tencent.mm.plugin.report.service.h.vKh.f(10651, new Object[] { Integer.valueOf(11), Integer.valueOf(0), Integer.valueOf(0) });
              }
              AppMethodBeat.o(67070);
              return;
              MallProductUI.e(MallProductUI.this).dbI();
              AppMethodBeat.o(67070);
              return;
              localf = MallProductUI.e(MallProductUI.this);
              com.tencent.mm.wallet_core.ui.e.ac(localf.jgS, localf.uxz.dbr());
            }
          }
        });
        AppMethodBeat.o(67071);
        return true;
      }
    });
    showOptionMenu(false);
    this.uyM.setFocusable(true);
    this.uyM.setFocusableInTouchMode(true);
    this.uyM.requestFocus();
    AppMethodBeat.o(67076);
  }
  
  public final void l(String paramString, final Bitmap paramBitmap)
  {
    AppMethodBeat.i(67079);
    if ((paramString != null) && (paramString.equals(this.uxz.uvQ))) {
      this.uyM.post(new Runnable()
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
    com.tencent.mm.plugin.product.a.a.dbi();
    this.uxz = com.tencent.mm.plugin.product.a.a.dbj();
    this.uyi = new f(getContext(), new f.a()
    {
      public final void E(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString)
      {
        AppMethodBeat.i(67064);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          MallProductUI.this.cE();
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
          MallProductUI.this.akw(paramAnonymousString);
        }
        AppMethodBeat.o(67064);
      }
    });
    paramBundle = this.uyi;
    Object localObject = getIntent();
    m localm = new m();
    g.afE().a(new f.1(paramBundle, (Intent)localObject, localm));
    paramBundle.uxx = true;
    localObject = new ox();
    ((ox)localObject).dup.errCode = -1;
    ((ox)localObject).callback = new f.2(paramBundle, (ox)localObject);
    com.tencent.mm.sdk.b.a.ESL.a((com.tencent.mm.sdk.b.b)localObject, Looper.getMainLooper());
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
    this.uyi.onStop();
    super.onPause();
    AppMethodBeat.o(67075);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(67074);
    super.onResume();
    this.uyi.onStart();
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