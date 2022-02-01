package com.tencent.mm.plugin.scanner.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.e.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.cr;
import com.tencent.mm.g.a.cr.a;
import com.tencent.mm.g.a.cr.b;
import com.tencent.mm.g.a.mg;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.cf.a;
import com.tencent.mm.model.z.b;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.scanner.model.a.a;
import com.tencent.mm.plugin.scanner.model.p;
import com.tencent.mm.plugin.scanner.model.r;
import com.tencent.mm.plugin.scanner.util.k;
import com.tencent.mm.plugin.scanner.util.k.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.protocal.protobuf.nt;
import com.tencent.mm.protocal.protobuf.nv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ProductUI
  extends MMPreference
  implements com.tencent.mm.ak.f, u.a
{
  private com.tencent.mm.modelgeo.d fHi;
  private b.a fHp;
  protected ProgressDialog fOC;
  private boolean hTj;
  private TextView jee;
  private com.tencent.mm.sdk.b.c kzS;
  private int mScene;
  private long mStartTime;
  private long msgId;
  private String pMk;
  protected com.tencent.mm.ui.base.preference.f screen;
  private TextView titleTv;
  private boolean vsk;
  private List<MusicPreference> wzY;
  private ProductUI.a yHA;
  private boolean yHB;
  private HashMap<String, Boolean> yHC;
  private d.a yHD;
  private String yHE;
  private boolean yHF;
  private String yHG;
  private boolean yHH;
  private boolean yHI;
  private boolean yHJ;
  private com.tencent.mm.plugin.scanner.history.a.a yHK;
  private cf.a yHL;
  private MusicPreference.a yHM;
  private boolean yHN;
  private ImageView yHo;
  private ImageView yHp;
  private View yHq;
  private TextView yHr;
  private ImageView yHs;
  private View yHt;
  private LinearLayout yHu;
  private ImageView yHv;
  private k.a yHw;
  private View yHx;
  private int yHy;
  private int yHz;
  
  public ProductUI()
  {
    AppMethodBeat.i(51876);
    this.yHy = 0;
    this.fOC = null;
    this.yHB = false;
    this.yHF = false;
    this.yHH = false;
    this.yHI = false;
    this.yHJ = false;
    this.hTj = false;
    this.fHp = new b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(51851);
        if (paramAnonymousBoolean)
        {
          ae.i("MicroMsg.scanner.ProductUI", "getLocation suc");
          if (ProductUI.a(ProductUI.this) != null)
          {
            ae.i("MicroMsg.scanner.ProductUI", "do getActionInfoScene, lng=" + paramAnonymousFloat1 + ", lat=" + paramAnonymousFloat2);
            com.tencent.mm.plugin.scanner.model.i locali = new com.tencent.mm.plugin.scanner.model.i(ProductUI.b(ProductUI.this), r.fC(ProductUI.a(ProductUI.this).yQm), ProductUI.c(ProductUI.this), ProductUI.d(ProductUI.this), paramAnonymousFloat1, paramAnonymousFloat2);
            com.tencent.mm.kernel.g.ajj().a(locali, 0);
          }
          if (ProductUI.e(ProductUI.this) != null) {
            ProductUI.e(ProductUI.this).c(ProductUI.f(ProductUI.this));
          }
          if (!ProductUI.g(ProductUI.this))
          {
            ProductUI.h(ProductUI.this);
            com.tencent.mm.modelstat.o.a(2011, paramAnonymousFloat1, paramAnonymousFloat2, (int)paramAnonymousDouble2);
          }
          AppMethodBeat.o(51851);
          return false;
        }
        if ((!ProductUI.i(ProductUI.this)) && (!com.tencent.mm.modelgeo.d.aIi()))
        {
          ProductUI.j(ProductUI.this);
          com.tencent.mm.ui.base.h.a(ProductUI.this, ProductUI.this.getString(2131760082), ProductUI.this.getString(2131755906), ProductUI.this.getString(2131760598), ProductUI.this.getString(2131755691), false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(51850);
              com.tencent.mm.modelgeo.d.cD(ProductUI.this);
              AppMethodBeat.o(51850);
            }
          }, null);
        }
        ae.w("MicroMsg.scanner.ProductUI", "getLocation fail");
        AppMethodBeat.o(51851);
        return false;
      }
    };
    this.yHL = new cf.a()
    {
      public final void a(e.a paramAnonymousa)
      {
        AppMethodBeat.i(51861);
        Object localObject1 = com.tencent.mm.platformtools.z.a(paramAnonymousa.gte.FNI);
        ae.i("MicroMsg.scanner.ProductUI", "lo-scanner-onRecieveMsg");
        paramAnonymousa = ProductUI.a(ProductUI.this);
        Object localObject2;
        if ((paramAnonymousa != null) && (!bu.isNullOrNil((String)localObject1)))
        {
          localObject1 = bx.M((String)localObject1, "sysmsg");
          localObject2 = (String)((Map)localObject1).get(".sysmsg.scanproductinfo.product.id");
          if ((!bu.isNullOrNil(paramAnonymousa.field_productid)) && (paramAnonymousa.field_productid.equals(localObject2))) {
            break label143;
          }
          ae.i("MicroMsg.ProductUpdateLogic", "lo-scanner-doUpdateActionLogicByNewXml: product id not match, productId=" + bu.nullAsNil((String)localObject2) + ", target=" + paramAnonymousa.field_productid);
        }
        for (;;)
        {
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(51860);
              ProductUI.a(ProductUI.this, ProductUI.a(ProductUI.this));
              AppMethodBeat.o(51860);
            }
          });
          AppMethodBeat.o(51861);
          return;
          label143:
          localObject1 = com.tencent.mm.plugin.scanner.model.a.n((Map)localObject1, ".sysmsg.scanproductinfo.product");
          localObject2 = new HashMap();
          int i = 0;
          while (i < ((List)localObject1).size())
          {
            LinkedList localLinkedList = ((com.tencent.mm.plugin.scanner.model.a)((List)localObject1).get(i)).lJQ;
            if (localLinkedList != null)
            {
              int j = 0;
              while (j < localLinkedList.size())
              {
                a.a locala = (a.a)localLinkedList.get(j);
                if (locala != null) {
                  ((Map)localObject2).put(locala.key, locala);
                }
                j += 1;
              }
            }
            i += 1;
          }
          ae.i("MicroMsg.ProductUpdateLogic", "lo-scanner-doUpdateActionLogicByNewXml: toUpdateSize=" + ((Map)localObject2).size());
          r.b(paramAnonymousa.yQm, (Map)localObject2);
        }
      }
      
      public final void a(e.c paramAnonymousc) {}
    };
    this.yHM = new MusicPreference.a()
    {
      public final void d(MusicPreference paramAnonymousMusicPreference)
      {
        AppMethodBeat.i(51854);
        if (paramAnonymousMusicPreference == null)
        {
          ae.e("MicroMsg.scanner.ProductUI", "onMusicPrefClick, musicPref == null");
          AppMethodBeat.o(51854);
          return;
        }
        if ((bu.isNullOrNil(paramAnonymousMusicPreference.yCa)) && (bu.isNullOrNil(paramAnonymousMusicPreference.yCb)))
        {
          ae.w("MicroMsg.scanner.ProductUI", "wifiurl = null,  wapurl = null");
          if (!bu.isNullOrNil(paramAnonymousMusicPreference.yCc)) {
            ProductUI.a(ProductUI.this, paramAnonymousMusicPreference.yCc);
          }
          AppMethodBeat.o(51854);
          return;
        }
        String str1 = String.format("%s_cd_%s", new Object[] { paramAnonymousMusicPreference.yCa, paramAnonymousMusicPreference.mKey });
        int j;
        ArrayList localArrayList;
        int i;
        label193:
        MusicPreference localMusicPreference;
        String str2;
        if (!ProductUI.ayi(str1))
        {
          if (paramAnonymousMusicPreference.getTitle() == null)
          {
            ae.e("MicroMsg.scanner.ProductUI", "onPlayBtnClick, getTitle() == null");
            AppMethodBeat.o(51854);
            return;
          }
          j = -1;
          if (ProductUI.o(ProductUI.this) == null)
          {
            str1 = null;
            paramAnonymousMusicPreference = String.format("%s_cd_%s", new Object[] { paramAnonymousMusicPreference.yCa, paramAnonymousMusicPreference.mKey });
            localArrayList = new ArrayList();
            Iterator localIterator = ProductUI.p(ProductUI.this).iterator();
            i = 0;
            if (!localIterator.hasNext()) {
              break label330;
            }
            localMusicPreference = (MusicPreference)localIterator.next();
            str2 = String.format("%s_cd_%s", new Object[] { localMusicPreference.yCa, localMusicPreference.mKey });
            if (!paramAnonymousMusicPreference.equals(str2)) {
              break label381;
            }
            j = i;
          }
        }
        label330:
        label381:
        for (;;)
        {
          localArrayList.add(com.tencent.mm.ay.g.a(5, str1, localMusicPreference.getTitle().toString(), "", localMusicPreference.yCc, localMusicPreference.yCb, localMusicPreference.yCa, str2, com.tencent.mm.kernel.g.ajR().gDT, str1, "", "wx482a4001c37e2b74"));
          i += 1;
          break label193;
          str1 = ProductUI.o(ProductUI.this).aQV();
          break;
          if (j < 0)
          {
            AppMethodBeat.o(51854);
            return;
          }
          com.tencent.mm.ay.a.f(localArrayList, j);
          for (;;)
          {
            ProductUI.q(ProductUI.this);
            AppMethodBeat.o(51854);
            return;
            com.tencent.mm.ay.a.aJX();
            ae.d("MicroMsg.scanner.ProductUI", "isTheSameId, playMusicId : [%s]", new Object[] { str1 });
          }
        }
      }
    };
    this.yHN = true;
    this.kzS = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(51876);
  }
  
  private void a(final k.a parama)
  {
    AppMethodBeat.i(51883);
    if (parama == null)
    {
      ae.e("MicroMsg.scanner.ProductUI", "refreshViewByProduct(), pd == null");
      finish();
      AppMethodBeat.o(51883);
      return;
    }
    if (!bu.isNullOrNil(parama.field_thumburl)) {
      this.yHA = new ProductUI.a(parama);
    }
    dOZ();
    if ((!bu.isNullOrNil(parama.field_introtitle)) && (!bu.isNullOrNil(parama.field_introlink)))
    {
      this.jee.setText(parama.field_introtitle);
      this.jee.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(51869);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ProductUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          ProductUI.a(ProductUI.this, 10003, parama.field_introlink);
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("rawUrl", parama.field_introlink);
          paramAnonymousView.putExtra("geta8key_scene", ProductUI.m(ProductUI.this));
          com.tencent.mm.br.d.b(ProductUI.this.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/ProductUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(51869);
        }
      });
      this.jee.setVisibility(0);
      this.yHy = this.yHw.field_functionType;
      if (parama.field_xmlType != 3) {
        break label399;
      }
      this.titleTv.setText(parama.field_title);
      if (bu.isNullOrNil(parama.field_certification)) {
        break label312;
      }
      this.yHr.setText(parama.field_certification);
      this.yHs.setVisibility(0);
      label166:
      if ((parama.field_type != 1) && (parama.field_type != 2)) {
        break label359;
      }
      this.yHo = ((ImageView)findViewById(2131303432));
      findViewById(2131303432).setVisibility(0);
      findViewById(2131303435).setVisibility(8);
      label219:
      if (!bu.isNullOrNil(parama.field_playurl))
      {
        ImageView localImageView = (ImageView)findViewById(2131303428);
        localImageView.setVisibility(0);
        localImageView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(51870);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ProductUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
            localObject = new Intent("android.intent.action.VIEW");
            com.tencent.mm.sdk.platformtools.o.a(ProductUI.this.getContext(), (Intent)localObject, Uri.parse(parama.field_playurl), "video/*");
            paramAnonymousView = ProductUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/scanner/ui/ProductUI$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/scanner/ui/ProductUI$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/ProductUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(51870);
          }
        });
      }
      addIconOptionMenu(0, 2131690603, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(51852);
          ProductUI.n(ProductUI.this);
          AppMethodBeat.o(51852);
          return true;
        }
      });
    }
    for (;;)
    {
      ae.v("MicroMsg.scanner.ProductUI", "start postToMainThread initBodyView");
      ar.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(51853);
          ProductUI.a(ProductUI.this, parama);
          ProductUI.b(ProductUI.this, parama);
          AppMethodBeat.o(51853);
        }
      });
      AppMethodBeat.o(51883);
      return;
      this.jee.setVisibility(8);
      break;
      label312:
      this.yHr.setText(parama.field_source);
      this.yHs.setVisibility(8);
      this.yHt.setOnClickListener(null);
      this.yHt.setBackgroundDrawable(null);
      this.yHt.setFocusable(false);
      break label166;
      label359:
      this.yHo = ((ImageView)findViewById(2131303435));
      findViewById(2131303435).setVisibility(0);
      findViewById(2131303432).setVisibility(8);
      break label219;
      label399:
      if (parama.field_xmlType == 4)
      {
        this.yHo = ((ImageView)findViewById(2131303435));
        findViewById(2131303435).setVisibility(0);
        findViewById(2131303432).setVisibility(8);
        this.yHo.setImageResource(2131691126);
        this.yHo.setBackgroundResource(2131691126);
        this.titleTv.setText(2131762827);
        this.yHr.setText(null);
      }
    }
  }
  
  private static boolean aye(String paramString)
  {
    AppMethodBeat.i(51889);
    com.tencent.mm.ay.f localf = com.tencent.mm.ay.a.aKc();
    if ((localf != null) && (localf.ijX == 5) && (paramString.equals(localf.ijZ)) && (com.tencent.mm.ay.a.aJZ()))
    {
      AppMethodBeat.o(51889);
      return true;
    }
    AppMethodBeat.o(51889);
    return false;
  }
  
  private static String ayf(String paramString)
  {
    AppMethodBeat.i(51893);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(51893);
      return null;
    }
    try
    {
      String str = Uri.parse(paramString).getQueryParameter("p");
      AppMethodBeat.o(51893);
      return str;
    }
    catch (Exception localException)
    {
      ae.w("MicroMsg.scanner.ProductUI", paramString + ";" + localException.getLocalizedMessage());
      AppMethodBeat.o(51893);
    }
    return null;
  }
  
  private static boolean ayg(String paramString)
  {
    AppMethodBeat.i(51895);
    paramString = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(paramString);
    if ((paramString != null) && ((int)paramString.ght > 0) && (com.tencent.mm.contact.c.lO(paramString.field_type)))
    {
      AppMethodBeat.o(51895);
      return true;
    }
    AppMethodBeat.o(51895);
    return false;
  }
  
  private void ayh(String paramString)
  {
    AppMethodBeat.i(51896);
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putString("jsapi_args_appid", p.OW(this.yHy));
    localIntent.putExtra("jsapiargs", localBundle);
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("pay_channel", 3);
    localIntent.putExtra("geta8key_scene", bpW());
    com.tencent.mm.br.d.b(getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(51896);
  }
  
  private void b(k.a parama)
  {
    AppMethodBeat.i(51885);
    if ((parama == null) || (parama.yQm == null) || (parama.yQm.size() == 0) || (this.screen == null))
    {
      AppMethodBeat.o(51885);
      return;
    }
    this.screen.removeAll();
    int i = 0;
    while (i < parama.yQm.size())
    {
      Object localObject2 = (com.tencent.mm.plugin.scanner.model.a)parama.yQm.get(i);
      Object localObject1;
      Object localObject3;
      if ((localObject2 != null) && (((com.tencent.mm.plugin.scanner.model.a)localObject2).lJQ != null) && (((com.tencent.mm.plugin.scanner.model.a)localObject2).lJQ.size() != 0) && (((com.tencent.mm.plugin.scanner.model.a)localObject2).yBW != 1) && (((com.tencent.mm.plugin.scanner.model.a)localObject2).yBY))
      {
        if (i != 0)
        {
          localObject1 = new Preference(this);
          ((Preference)localObject1).setLayoutResource(2131495109);
          this.screen.b((Preference)localObject1);
        }
        if ((!bu.isNullOrNil(((com.tencent.mm.plugin.scanner.model.a)localObject2).title)) && ((((com.tencent.mm.plugin.scanner.model.a)localObject2).type == 6) || (((com.tencent.mm.plugin.scanner.model.a)localObject2).type == 7)))
        {
          localObject1 = new CategoryWithTitlePreference(this);
          ((CategoryWithTitlePreference)localObject1).setTitle(((com.tencent.mm.plugin.scanner.model.a)localObject2).title);
          this.screen.b((Preference)localObject1);
        }
        if (((com.tencent.mm.plugin.scanner.model.a)localObject2).type != 6) {
          break label353;
        }
        localObject1 = new ArrayList();
        j = 0;
        while (j < ((com.tencent.mm.plugin.scanner.model.a)localObject2).lJQ.size())
        {
          localObject3 = (a.a)((com.tencent.mm.plugin.scanner.model.a)localObject2).lJQ.get(j);
          if (((a.a)localObject3).type == 10) {
            ((List)localObject1).add(localObject3);
          }
          j += 1;
        }
        if (((List)localObject1).size() > 0)
        {
          localObject2 = new g(this);
          ((g)localObject2).setKey(i * 100);
          ((g)localObject2).xcP = ((List)localObject1);
          this.screen.b((Preference)localObject2);
        }
      }
      i += 1;
      continue;
      label353:
      int j = 0;
      label355:
      a.a locala;
      if (j < ((com.tencent.mm.plugin.scanner.model.a)localObject2).lJQ.size())
      {
        localObject3 = i * 100 + j;
        locala = (a.a)((com.tencent.mm.plugin.scanner.model.a)localObject2).lJQ.get(j);
        if (locala.type == 11)
        {
          this.yHF = true;
          this.yHG = locala.name;
        }
        if (locala.dmr != 2)
        {
          if (locala.dmr != 1) {
            break label509;
          }
          if (!bu.isNullOrNil(locala.image))
          {
            localObject1 = new b(this);
            ((b)localObject1).setKey((String)localObject3);
            ((b)localObject1).yFn = locala.image;
            ((b)localObject1).screen = this.screen;
            this.screen.b((Preference)localObject1);
          }
        }
      }
      label1185:
      for (;;)
      {
        j += 1;
        break label355;
        break;
        label509:
        if (locala.type == 5)
        {
          localObject1 = new MusicPreference(this);
          ((MusicPreference)localObject1).setKey((String)localObject3);
          ((MusicPreference)localObject1).setTitle(locala.name);
          ((MusicPreference)localObject1).yCa = locala.yCa;
          ((MusicPreference)localObject1).yCb = locala.yCb;
          ((MusicPreference)localObject1).yCc = locala.yCc;
          if (!aye(String.format("%s_cd_%s", new Object[] { locala.yCa, localObject3 })))
          {
            ((MusicPreference)localObject1).qD(false);
            ((MusicPreference)localObject1).yGU = this.yHM;
            this.screen.b((Preference)localObject1);
            com.tencent.mm.sdk.b.a.IvT.c(this.kzS);
            if (this.wzY == null) {
              this.wzY = new ArrayList();
            }
            if (this.yHN) {
              this.wzY.add(localObject1);
            }
          }
        }
        for (;;)
        {
          label610:
          if ((j >= ((com.tencent.mm.plugin.scanner.model.a)localObject2).lJQ.size() - 1) || (locala.type == 12) || (((a.a)((com.tencent.mm.plugin.scanner.model.a)localObject2).lJQ.get(j + 1)).type == 12) || (((a.a)((com.tencent.mm.plugin.scanner.model.a)localObject2).lJQ.get(j + 1)).dmr == 1) || (!d(j, ((com.tencent.mm.plugin.scanner.model.a)localObject2).lJQ))) {
            break label1185;
          }
          localObject1 = new f(this);
          this.screen.b((Preference)localObject1);
          break;
          ((MusicPreference)localObject1).qD(true);
          break label610;
          if (locala.type == 6)
          {
            localObject1 = new d(this);
            ((d)localObject1).setKey((String)localObject3);
            ((d)localObject1).mTitle = locala.name;
            ((d)localObject1).setSummary(locala.desc);
            this.screen.b((Preference)localObject1);
            ((d)localObject1).yGJ = this.yHD;
          }
          else if (locala.type == 12)
          {
            localObject1 = new e(this);
            ((e)localObject1).setKey((String)localObject3);
            ((e)localObject1).yFn = locala.thumburl;
            ((e)localObject1).screen = this.screen;
            this.screen.b((Preference)localObject1);
          }
          else
          {
            if (locala.type == 2)
            {
              if (ayg(locala.username)) {}
              for (localObject1 = locala.yCi;; localObject1 = locala.yCh)
              {
                a locala1 = new a(this);
                locala1.setKey((String)localObject3);
                locala1.setTitle((CharSequence)localObject1);
                locala1.setSummary(locala.desc);
                locala1.yFk = locala.hGg;
                this.screen.b(locala1);
                break;
              }
            }
            if (locala.type == 22)
            {
              localObject1 = new c(this);
              ((c)localObject1).setKey((String)localObject3);
              if (!bu.isNullOrNil(locala.nickname)) {
                ((c)localObject1).oYU = (locala.nickname + ":");
              }
              ((c)localObject1).mContent = locala.content;
              ((c)localObject1).yGx = locala.thumburl;
              this.screen.b((Preference)localObject1);
            }
            else
            {
              localObject1 = new a(this);
              ((a)localObject1).setKey((String)localObject3);
              ((a)localObject1).setTitle(locala.name);
              ((a)localObject1).setSummary(locala.desc);
              ((a)localObject1).yFk = locala.hGg;
              ((a)localObject1).pMn = locala.iconUrl;
              this.screen.b((Preference)localObject1);
            }
          }
        }
      }
    }
    this.screen.notifyDataSetChanged();
    ae.d("MicroMsg.scanner.ProductUI", "initBodyView finish");
    if (this.wzY != null) {
      this.yHN = false;
    }
    AppMethodBeat.o(51885);
  }
  
  private void bY(int paramInt, String paramString)
  {
    AppMethodBeat.i(51890);
    if (this.yHw == null)
    {
      AppMethodBeat.o(51890);
      return;
    }
    paramString = new com.tencent.mm.plugin.scanner.model.n(this.yHw.field_productid, "", paramInt, paramString, 0, 0);
    com.tencent.mm.kernel.g.ajj().a(paramString, 0);
    AppMethodBeat.o(51890);
  }
  
  private int bpW()
  {
    if (this.yHy == 4) {
      return 11;
    }
    if (this.yHy == 3) {
      return 12;
    }
    return 0;
  }
  
  private static boolean d(int paramInt, LinkedList<a.a> paramLinkedList)
  {
    AppMethodBeat.i(51886);
    if (paramLinkedList != null)
    {
      paramInt += 1;
      while (paramInt < paramLinkedList.size())
      {
        if (((a.a)paramLinkedList.get(paramInt)).dmr != 2)
        {
          AppMethodBeat.o(51886);
          return true;
        }
        paramInt += 1;
      }
    }
    AppMethodBeat.o(51886);
    return false;
  }
  
  private void dOZ()
  {
    AppMethodBeat.i(51882);
    this.yHz = getContext().getResources().getDimensionPixelSize(2131166695);
    if ((this.yHw != null) && ((this.yHw.field_type == 1) || (this.yHw.field_type == 2)))
    {
      this.yHz = getContext().getResources().getDimensionPixelSize(2131166696);
      Object localObject = this.yHp.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).height = this.yHz;
      this.yHp.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = this.yHq.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).height = this.yHz;
      this.yHu.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (RelativeLayout)findViewById(2131303430);
      ViewGroup.LayoutParams localLayoutParams = ((RelativeLayout)localObject).getLayoutParams();
      localLayoutParams.height = this.yHz;
      ((RelativeLayout)localObject).setLayoutParams(localLayoutParams);
      localObject = this.yHu.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).height = this.yHz;
      this.yHu.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    AppMethodBeat.o(51882);
  }
  
  private void dPa()
  {
    AppMethodBeat.i(51884);
    this.msgId = getIntent().getLongExtra("key_ProductUI_chatting_msgId", 0L);
    if ((this.msgId > 0L) && (com.tencent.mm.kernel.g.ajM()))
    {
      bv localbv = ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().ys(this.msgId);
      if (localbv.field_msgId > 0L)
      {
        localbv.uj(this.yHA.aQV());
        ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().a(this.msgId, localbv);
      }
    }
    AppMethodBeat.o(51884);
  }
  
  private void dPb()
  {
    AppMethodBeat.i(51887);
    if ((this.yHw == null) || (this.yHw.yQm == null) || (this.yHw.yQm.size() == 0) || (this.screen == null))
    {
      AppMethodBeat.o(51887);
      return;
    }
    int i = 0;
    while (i < this.yHw.yQm.size())
    {
      com.tencent.mm.plugin.scanner.model.a locala = (com.tencent.mm.plugin.scanner.model.a)this.yHw.yQm.get(i);
      if ((locala != null) && (locala.lJQ != null) && (locala.lJQ.size() != 0))
      {
        int j = 0;
        if (j < locala.lJQ.size())
        {
          a.a locala1 = (a.a)locala.lJQ.get(j);
          MusicPreference localMusicPreference;
          if (locala1.type == 5)
          {
            String str = i * 100 + j;
            localMusicPreference = (MusicPreference)this.screen.aXe(str);
            if (localMusicPreference != null)
            {
              if (aye(String.format("%s_cd_%s", new Object[] { locala1.yCa, str }))) {
                break label221;
              }
              localMusicPreference.qD(false);
            }
          }
          for (;;)
          {
            j += 1;
            break;
            label221:
            localMusicPreference.qD(true);
          }
        }
      }
      i += 1;
    }
    this.screen.notifyDataSetChanged();
    AppMethodBeat.o(51887);
  }
  
  private int dPc()
  {
    if (this.yHy == 3) {
      return 47;
    }
    return 49;
  }
  
  private void dPd()
  {
    AppMethodBeat.i(51897);
    if (this.yHw != null)
    {
      ae.i("MicroMsg.scanner.ProductUI", "doUpdateActionLogic, flag=:" + this.yHw.field_getaction);
      if ((this.yHw.field_getaction & 0x2) > 0)
      {
        this.fHi = com.tencent.mm.modelgeo.d.aIh();
        if (this.fHi != null)
        {
          this.fHi.b(this.fHp);
          AppMethodBeat.o(51897);
        }
      }
      else if ((this.yHw.field_getaction & 0x1) > 0)
      {
        com.tencent.mm.plugin.scanner.model.i locali = new com.tencent.mm.plugin.scanner.model.i(this.pMk, r.fC(this.yHw.yQm), this.mScene, this.yHE, 0.0D, 0.0D);
        com.tencent.mm.kernel.g.ajj().a(locali, 0);
      }
    }
    AppMethodBeat.o(51897);
  }
  
  private void dPe()
  {
    AppMethodBeat.i(51899);
    if (!com.tencent.mm.plugin.scanner.util.e.dQh())
    {
      ae.e("MicroMsg.scanner.ProductUI", "mHistoryItem ScanHistoryUtil.shouldShowHistoryList() is false!");
      AppMethodBeat.o(51899);
      return;
    }
    com.tencent.mm.plugin.scanner.history.a.a locala = new com.tencent.mm.plugin.scanner.history.a.a();
    locala.field_productId = this.pMk;
    if (!com.tencent.mm.plugin.scanner.j.dNQ().dNR().get(locala, new String[0])) {}
    for (boolean bool = com.tencent.mm.plugin.scanner.j.dNQ().dNR().insert(this.yHK); bool; bool = com.tencent.mm.plugin.scanner.j.dNQ().dNR().update(this.yHK, new String[0]))
    {
      ae.i("MicroMsg.scanner.ProductUI", "mHistoryItem insert success!");
      this.yHI = true;
      AppMethodBeat.o(51899);
      return;
    }
    ae.e("MicroMsg.scanner.ProductUI", "mHistoryItem insert fail!");
    AppMethodBeat.o(51899);
  }
  
  private static void t(View paramView, float paramFloat)
  {
    AppMethodBeat.i(51898);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(paramFloat, paramFloat);
    localAlphaAnimation.setDuration(0L);
    localAlphaAnimation.setFillAfter(true);
    paramView.startAnimation(localAlphaAnimation);
    AppMethodBeat.o(51898);
  }
  
  private void u(final String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(51894);
    this.pMk = paramString1;
    this.yHE = paramString2;
    paramString1 = new com.tencent.mm.plugin.scanner.model.j(paramString1, this.mScene, paramString2);
    com.tencent.mm.kernel.g.ajj().a(paramString1, 0);
    if (!paramBoolean)
    {
      paramString2 = getContext();
      getString(2131755906);
      this.fOC = com.tencent.mm.ui.base.h.c(paramString2, getString(2131762836), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(51859);
          ae.d("MicroMsg.scanner.ProductUI", "User cancel");
          com.tencent.mm.kernel.g.ajj().a(paramString1);
          AppMethodBeat.o(51859);
        }
      });
    }
    AppMethodBeat.o(51894);
  }
  
  public int getHeaderResourceId()
  {
    return 2131495118;
  }
  
  public int getLayoutId()
  {
    return 2131495111;
  }
  
  public int getResourceId()
  {
    return 2131951701;
  }
  
  public void initView()
  {
    AppMethodBeat.i(51881);
    setMMTitle(2131762864);
    this.screen = getPreferenceScreen();
    if (getSupportActionBar() != null)
    {
      getSupportActionBar().setBackgroundDrawable(null);
      getSupportActionBar();
    }
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(51862);
        if (ProductUI.c(ProductUI.this) == 4) {
          ProductUI.this.setResult(0);
        }
        ProductUI.this.finish();
        AppMethodBeat.o(51862);
        return true;
      }
    });
    this.titleTv = ((TextView)findViewById(2131303439));
    this.yHp = ((ImageView)findViewById(2131303429));
    this.yHq = findViewById(2131303434);
    this.yHs = ((ImageView)findViewById(2131303424));
    this.yHx = findViewById(2131303420);
    this.yHu = ((LinearLayout)findViewById(2131303433));
    this.yHv = ((ImageView)findViewById(2131303431));
    this.yHt = findViewById(2131303423);
    t(this.yHx, 0.0F);
    Object localObject;
    String str;
    if (com.tencent.mm.cb.a.ir(getContext()))
    {
      this.titleTv.setTextSize(0, getContext().getResources().getDimensionPixelSize(2131165266) * com.tencent.mm.cb.a.ig(getContext()));
      this.yHr = ((TextView)findViewById(2131303422));
      this.jee = ((TextView)findViewById(2131304328));
      this.yHC = new HashMap();
      this.yHD = new d.a()
      {
        public final Boolean ayc(String paramAnonymousString)
        {
          AppMethodBeat.i(51864);
          if ((paramAnonymousString != null) && (paramAnonymousString.length() > 0))
          {
            paramAnonymousString = (Boolean)ProductUI.k(ProductUI.this).get(paramAnonymousString);
            AppMethodBeat.o(51864);
            return paramAnonymousString;
          }
          AppMethodBeat.o(51864);
          return null;
        }
        
        public final void b(String paramAnonymousString, Boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(51863);
          if ((paramAnonymousString != null) && (paramAnonymousString.length() > 0)) {
            ProductUI.k(ProductUI.this).put(paramAnonymousString, paramAnonymousBoolean);
          }
          AppMethodBeat.o(51863);
        }
        
        public final void dOY()
        {
          AppMethodBeat.i(51865);
          if (ProductUI.this.screen != null) {
            ProductUI.this.screen.notifyDataSetChanged();
          }
          AppMethodBeat.o(51865);
        }
      };
      this.yHK = new com.tencent.mm.plugin.scanner.history.a.a();
      this.yHK.field_ScanTime = System.currentTimeMillis();
      this.yHK.field_scene = this.mScene;
      if (this.mScene != 5) {
        break label428;
      }
      this.yHH = true;
      localObject = getIntent().getStringExtra("key_Qrcode_Url");
      str = ayf((String)localObject);
      this.yHK.field_qrcodeUrl = ((String)localObject);
      this.yHK.field_productId = str;
      u(str, (String)localObject, false);
    }
    label772:
    for (;;)
    {
      findViewById(2131303436).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(51866);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ProductUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          ProductUI.l(ProductUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/ProductUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(51866);
        }
      });
      findViewById(2131303425).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(51867);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ProductUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          ProductUI.l(ProductUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/ProductUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(51867);
        }
      });
      this.yHt.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(51868);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ProductUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if ((ProductUI.a(ProductUI.this) != null) && (!bu.isNullOrNil(ProductUI.a(ProductUI.this).field_certificationurl)))
          {
            ProductUI.a(ProductUI.this, 10002, ProductUI.a(ProductUI.this).field_certificationurl);
            ProductUI.a(ProductUI.this, ProductUI.a(ProductUI.this).field_certificationurl);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/ProductUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(51868);
        }
      });
      new b();
      AppMethodBeat.o(51881);
      return;
      this.titleTv.setTextSize(0, com.tencent.mm.cb.a.ax(getContext(), 2131165266));
      break;
      label428:
      if (this.mScene == 4)
      {
        localObject = getIntent().getStringExtra("key_product_id");
        str = getIntent().getStringExtra("key_Qrcode_Url");
        if (!bu.isNullOrNil((String)localObject))
        {
          u((String)localObject, str, false);
        }
        else
        {
          ae.e("MicroMsg.scanner.ProductUI", "jsapi jump finish productId null");
          finish();
          AppMethodBeat.o(51881);
        }
      }
      else
      {
        this.yHJ = getIntent().getBooleanExtra("key_is_from_barcode", false);
        this.yHH = getIntent().getBooleanExtra("key_need_add_to_history", false);
        localObject = getIntent().getStringExtra("key_Product_xml");
        if (!bu.isNullOrNil((String)localObject))
        {
          int i = getIntent().getIntExtra("key_Product_funcType", 0);
          this.yHw = p.eV((String)localObject, i);
          if (this.yHw == null)
          {
            ae.e("MicroMsg.scanner.ProductUI", "initView(), product == null");
            finish();
            AppMethodBeat.o(51881);
            return;
          }
          this.pMk = this.yHw.field_productid;
          this.yHE = this.yHw.field_extinfo;
          if ((this.yHH) && (!TextUtils.isEmpty(this.pMk)))
          {
            this.yHK.field_xmlContent = ((String)localObject);
            this.yHK.field_qrcodeUrl = this.yHE;
            this.yHK.field_productId = this.pMk;
            this.yHK.field_funcType = i;
            dPe();
          }
          for (;;)
          {
            localObject = this.yHw;
            getIntent().getBooleanExtra("key_ProductUI_addToDB", true);
            a((k.a)localObject);
            if ((i != 0) || (bu.isNullOrNil(this.yHw.field_productid))) {
              break label772;
            }
            u(this.yHw.field_productid, this.yHw.field_extinfo, true);
            break;
            ae.i("MicroMsg.scanner.ProductUI", "shouldAddToHistory:" + this.yHH + " mProductId:" + this.pMk);
          }
          dPd();
        }
        else
        {
          localObject = getIntent().getStringExtra("key_Product_ID");
          if (bu.isNullOrNil((String)localObject)) {
            break label807;
          }
          u((String)localObject, null, false);
        }
      }
    }
    label807:
    ae.e("MicroMsg.scanner.ProductUI", "normal finish productId null");
    finish();
    AppMethodBeat.o(51881);
  }
  
  public final void k(final String paramString, final Bitmap paramBitmap)
  {
    AppMethodBeat.i(51891);
    if ((!bu.isNullOrNil(paramString)) && (this.yHw != null) && (paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      ae.d("MicroMsg.scanner.ProductUI", "onGetPictureFinish: notifyKey=".concat(String.valueOf(paramString)));
      ar.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(51858);
          if ((paramString.equals(ProductUI.a(ProductUI.this).field_thumburl)) && (ProductUI.s(ProductUI.this) != null)) {
            ae.i("MicroMsg.scanner.ProductUI", "onGetPictureFinish: notifyKey=" + paramString);
          }
          try
          {
            ProductUI.s(ProductUI.this).setImageBitmap(paramBitmap);
            ProductUI.s(ProductUI.this).setBackgroundDrawable(null);
            ProductUI.s(ProductUI.this).setBackgroundColor(-1);
            ProductUI.t(ProductUI.this);
            ProductUI.u(ProductUI.this);
            if ((paramString.equals(ProductUI.a(ProductUI.this).field_headerbackgroundurl)) && (ProductUI.v(ProductUI.this) != null)) {
              ProductUI.v(ProductUI.this).setImageBitmap(paramBitmap);
            }
            AppMethodBeat.o(51858);
            return;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              ae.e("MicroMsg.scanner.ProductUI", "onGetPictureFinish : [%s]", new Object[] { localException.getLocalizedMessage() });
            }
          }
        }
      });
    }
    AppMethodBeat.o(51891);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(51877);
    super.onCreate(paramBundle);
    this.mStartTime = bu.aRi();
    this.mScene = getIntent().getIntExtra("key_ProductUI_getProductInfoScene", 0);
    u.b(this);
    ((s)com.tencent.mm.kernel.g.ad(s.class)).getSysCmdMsgExtension().a("scanproductinfo", this.yHL, true);
    initView();
    AppMethodBeat.o(51877);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(51880);
    u.c(this);
    ((s)com.tencent.mm.kernel.g.ad(s.class)).getSysCmdMsgExtension().b("scanproductinfo", this.yHL, true);
    com.tencent.mm.sdk.b.a.IvT.d(this.kzS);
    if (this.fHi != null) {
      this.fHi.c(this.fHp);
    }
    bY(10100, bu.aRi() - this.mStartTime);
    super.onDestroy();
    AppMethodBeat.o(51880);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(51879);
    com.tencent.mm.kernel.g.ajj().b(1063, this);
    com.tencent.mm.kernel.g.ajj().b(1068, this);
    super.onPause();
    AppMethodBeat.o(51879);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(51888);
    ae.i("MicroMsg.scanner.ProductUI", "onPreferenceTreeClick item: [%s]", new Object[] { paramPreference.mKey });
    if ((this.yHw == null) || (this.yHw.yQm == null))
    {
      ae.e("MicroMsg.scanner.ProductUI", "product == null || product.actionlist == null");
      AppMethodBeat.o(51888);
      return false;
    }
    for (;;)
    {
      a.a locala1;
      Intent localIntent;
      try
      {
        int i = Integer.valueOf(paramPreference.mKey).intValue();
        int j = i / 100;
        int k = i % 100;
        ae.v("MicroMsg.scanner.ProductUI", "keyId=[%s], ii=[%s], jj=[%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
        if ((j < 0) || (j >= this.yHw.yQm.size()))
        {
          ae.w("MicroMsg.scanner.ProductUI", "index out of bounds, ii=[%s], list Size=[%s]", new Object[] { Integer.valueOf(j), Integer.valueOf(this.yHw.yQm.size()) });
          AppMethodBeat.o(51888);
          return false;
        }
        locala = (com.tencent.mm.plugin.scanner.model.a)this.yHw.yQm.get(j);
        if (locala == null)
        {
          ae.w("MicroMsg.scanner.ProductUI", "actionList == null");
          AppMethodBeat.o(51888);
          return false;
        }
        if ((k < 0) || (k >= locala.lJQ.size()))
        {
          ae.w("MicroMsg.scanner.ProductUI", "index out of bounds, jj=[%s], actions Size=[%s]", new Object[] { Integer.valueOf(k), Integer.valueOf(locala.lJQ.size()) });
          AppMethodBeat.o(51888);
          return false;
        }
        locala1 = (a.a)locala.lJQ.get(k);
        if (locala1 == null)
        {
          ae.w("MicroMsg.scanner.ProductUI", "action == null");
          AppMethodBeat.o(51888);
          return false;
        }
        ae.i("MicroMsg.scanner.ProductUI", "action.type = [%s]", new Object[] { Integer.valueOf(locala1.type) });
        localIntent = new Intent();
        switch (locala1.type)
        {
        case 13: 
        case 14: 
        case 15: 
        case 16: 
        case 17: 
        case 18: 
        case 19: 
        case 20: 
          ae.d("MicroMsg.scanner.ProductUI", "Default go url:" + locala1.link);
          if (bu.isNullOrNil(locala1.link)) {
            break label1271;
          }
          ayh(locala1.link);
        }
      }
      catch (Exception paramf)
      {
        com.tencent.mm.plugin.scanner.model.a locala;
        ae.e("MicroMsg.scanner.ProductUI", "onPreferenceTreeClick, [%s]", new Object[] { paramf.getMessage() });
        ae.printErrStackTrace("MicroMsg.scanner.ProductUI", paramf, "", new Object[0]);
        AppMethodBeat.o(51888);
        return false;
      }
      paramf = new com.tencent.mm.plugin.scanner.model.n(this.yHw.field_productid, locala1.yCd, locala1.type, paramf, locala.lJQ.size(), locala1.dmr);
      com.tencent.mm.kernel.g.ajj().a(paramf, 0);
      AppMethodBeat.o(51888);
      return true;
      paramPreference = locala1.link;
      paramf = paramPreference;
      if (!bu.isNullOrNil(locala1.link))
      {
        ayh(locala1.link);
        paramf = paramPreference;
        continue;
        paramPreference = locala1.username;
        paramf = paramPreference;
        if (!bu.isNullOrNil(locala1.username))
        {
          paramf = locala1.username;
          if (ayg(paramf))
          {
            localIntent = new Intent();
            localIntent.putExtra("Chat_User", paramf);
            localIntent.putExtra("finish_direct", true);
            localIntent.putExtra("add_scene", dPc());
            com.tencent.mm.plugin.scanner.h.iUz.d(localIntent, getContext());
            paramf = paramPreference;
          }
          else if (TextUtils.isEmpty(paramf))
          {
            ae.v("MicroMsg.scanner.ProductUI", "username is null");
            paramf = paramPreference;
          }
          else
          {
            localIntent = new Intent();
            localIntent.putExtra("Contact_User", paramf);
            localIntent.putExtra("force_get_contact", true);
            localIntent.putExtra("Contact_Scene", dPc());
            com.tencent.mm.plugin.scanner.h.iUz.c(localIntent, this);
            paramf = paramPreference;
            continue;
            paramf = locala1.yCc;
            localIntent.putExtra("rawUrl", locala1.yCc);
            localIntent.putExtra("geta8key_scene", bpW());
            com.tencent.mm.plugin.scanner.h.iUz.i(localIntent, this);
            com.tencent.mm.ay.a.aJX();
            dPb();
            continue;
            paramPreference = locala1.yCe;
            paramf = paramPreference;
            if (!bu.isNullOrNil(locala1.yCe))
            {
              localIntent.putExtra("key_product_id", locala1.yCe);
              localIntent.putExtra("key_product_scene", 12);
              com.tencent.mm.br.d.b(this, "product", ".ui.MallProductUI", localIntent);
              paramf = paramPreference;
              continue;
              paramf = locala1.yCe;
              localIntent.putExtra("key_card_id", locala1.yCg);
              localIntent.putExtra("key_card_ext", locala1.yCf);
              localIntent.putExtra("key_from_scene", 9);
              com.tencent.mm.br.d.b(this, "card", ".ui.CardDetailUI", localIntent);
              continue;
              localIntent.setClass(this, ProductFurtherInfoUI.class);
              localIntent.putExtra("key_Product_xml", this.yHw.field_xml);
              localIntent.putExtra("key_title", locala1.name);
              paramf = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
              com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahE(), "com/tencent/mm/plugin/scanner/ui/ProductUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              startActivity((Intent)paramf.mt(0));
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/ProductUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramf = null;
              continue;
              paramf = locala1.yBX;
              localIntent.setClass(this, ProductPurchaseAreaUI.class);
              localIntent.putExtra("key_Product_xml", this.yHw.field_xml);
              localIntent.putExtra("referkey", locala1.yBX);
              localIntent.putExtra("key_Product_funcType", this.yHy);
              paramPreference = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
              com.tencent.mm.hellhoundlib.a.a.a(this, paramPreference.ahE(), "com/tencent/mm/plugin/scanner/ui/ProductUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              startActivity((Intent)paramPreference.mt(0));
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/ProductUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              continue;
              paramPreference = locala1.link;
              paramf = paramPreference;
              if (!bu.isNullOrNil(locala1.link))
              {
                ayh(locala1.link);
                paramf = paramPreference;
                continue;
                paramf = null;
                continue;
                continue;
                label1271:
                paramf = null;
              }
            }
          }
        }
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(51878);
    super.onResume();
    com.tencent.mm.kernel.g.ajj().a(1063, this);
    com.tencent.mm.kernel.g.ajj().a(1068, this);
    AppMethodBeat.o(51878);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(51892);
    if (paramn == null)
    {
      ae.w("MicroMsg.scanner.ProductUI", "scene == null");
      AppMethodBeat.o(51892);
      return;
    }
    if (paramn.getType() == 1063)
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ae.e("MicroMsg.scanner.ProductUI", "onSceneEnd() errType = [%s], errCode = [%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        AppMethodBeat.o(51892);
        return;
      }
      paramString = (com.tencent.mm.plugin.scanner.model.j)paramn;
      if ((paramString.rr != null) && (paramString.rr.hQE.hQJ != null)) {}
      for (paramString = (nv)paramString.rr.hQE.hQJ; paramString == null; paramString = null)
      {
        ae.w("MicroMsg.scanner.ProductUI", "onSceneEnd productInfo == null");
        AppMethodBeat.o(51892);
        return;
      }
      if (paramString.GaA != null)
      {
        ae.d("MicroMsg.scanner.ProductUI", "onSceneEnd  productInfo.DescXML != null");
        paramn = p.eV(paramString.GaA, this.yHy);
        if ((this.yHw != null) && (this.yHw.field_xml != null) && (paramn != null) && (paramn.field_xml != null) && (!this.yHw.field_xml.equals(paramn.field_xml)))
        {
          this.yHw = paramn;
          a(this.yHw);
        }
        for (;;)
        {
          if ((this.fOC != null) && (this.fOC.isShowing())) {
            this.fOC.dismiss();
          }
          dPd();
          if ((!this.yHH) || (this.yHI) || (TextUtils.isEmpty(this.pMk))) {
            break;
          }
          this.yHK.field_xmlContent = paramString.GaA;
          this.yHK.field_funcType = this.yHy;
          dPe();
          AppMethodBeat.o(51892);
          return;
          if ((paramn != null) && (paramn.field_xml != null))
          {
            this.yHw = paramn;
            a(this.yHw);
          }
        }
        ae.i("MicroMsg.scanner.ProductUI", "shouldAddToHistory:" + this.yHH + " mProductId:" + this.pMk + "  hasAddToHistory:" + this.yHI);
      }
      AppMethodBeat.o(51892);
      return;
    }
    if ((paramn.getType() == 1068) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = ((nt)((com.tencent.mm.plugin.scanner.model.i)paramn).rr.hQE.hQJ).Gaz;
      if ((this.yHw != null) && (r.b(this.yHw.yQm, r.fD(paramString)))) {
        b(this.yHw);
      }
    }
    AppMethodBeat.o(51892);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class b
  {
    int ahF;
    ProductScrollView yHU;
    boolean yHV;
    private ProductScrollView.a yHW;
    
    public b()
    {
      AppMethodBeat.i(51875);
      this.yHW = new ProductScrollView.a()
      {
        public final void cnI()
        {
          float f3 = 1.0F;
          AppMethodBeat.i(51874);
          ProductUI.b localb = ProductUI.b.this;
          int i = localb.yHU.getScrollY();
          float f1;
          label65:
          float f2;
          if (i < 0)
          {
            f1 = -1.0F;
            ae.v("MicroMsg.ProductUI.HeaderEffectHelper", "rate=".concat(String.valueOf(f1)));
            if (f1 != 1.0F) {
              break label211;
            }
            if (!localb.yHV)
            {
              localb.yHV = true;
              if (ProductUI.x(localb.yHO) != null)
              {
                float f4 = 1.0F - f1 - 0.2F;
                f2 = f4;
                if (f4 <= 0.0F) {
                  f2 = 0.0F;
                }
                if (f1 == 0.0F) {
                  f2 = 1.0F;
                }
                ProductUI.u(ProductUI.x(localb.yHO), f2);
              }
              if (ProductUI.y(localb.yHO) != null)
              {
                if (f1 != 0.0F) {
                  break label220;
                }
                f2 = 0.0F;
              }
            }
          }
          for (;;)
          {
            ProductUI.u(ProductUI.y(localb.yHO), f2);
            AppMethodBeat.o(51874);
            return;
            if ((i >= ProductUI.z(localb.yHO) - localb.ahF) || (ProductUI.z(localb.yHO) == 0.0F))
            {
              f1 = 1.0F;
              break;
            }
            f1 = i * 1.37F / ProductUI.z(localb.yHO);
            break;
            label211:
            localb.yHV = false;
            break label65;
            label220:
            f2 = f3;
            if (f1 >= 0.0F)
            {
              f1 += 0.2F;
              f2 = f3;
              if (f1 <= 1.0F) {
                f2 = f1;
              }
            }
          }
        }
      };
      this.yHU = ((ProductScrollView)ProductUI.this.findViewById(2131303539));
      this.yHU.setOnScrollListener(this.yHW);
      this.ahF = ProductUI.w(ProductUI.this);
      AppMethodBeat.o(51875);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ProductUI
 * JD-Core Version:    0.7.0.1
 */