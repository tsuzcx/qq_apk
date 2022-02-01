package com.tencent.mm.plugin.scanner.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
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
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f.a;
import com.tencent.mm.al.f.c;
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.cn;
import com.tencent.mm.g.a.cn.a;
import com.tencent.mm.g.a.cn.b;
import com.tencent.mm.g.a.ln;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.cc;
import com.tencent.mm.model.cc.a;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.scanner.model.a.a;
import com.tencent.mm.plugin.scanner.util.k.a;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.protocal.protobuf.mq;
import com.tencent.mm.protocal.protobuf.ms;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bl;
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
  implements com.tencent.mm.al.g, u.a
{
  private com.tencent.mm.modelgeo.d fjC;
  private b.a fjJ;
  protected ProgressDialog fpP;
  private boolean gXx;
  private TextView ihU;
  private com.tencent.mm.sdk.b.c jBI;
  private int mScene;
  private long mStartTime;
  private long msgId;
  private String oyw;
  private boolean sVh;
  protected com.tencent.mm.ui.base.preference.f screen;
  private List<MusicPreference> tWo;
  private TextView titleTv;
  private ImageView vSB;
  private ImageView vSC;
  private View vSD;
  private TextView vSE;
  private ImageView vSF;
  private View vSG;
  private LinearLayout vSH;
  private ImageView vSI;
  private k.a vSJ;
  private View vSK;
  private int vSL;
  private int vSM;
  private ProductUI.a vSN;
  private boolean vSO;
  private HashMap<String, Boolean> vSP;
  private d.a vSQ;
  private String vSR;
  private boolean vSS;
  private String vST;
  private boolean vSU;
  private boolean vSV;
  private boolean vSW;
  private com.tencent.mm.plugin.scanner.history.a.a vSX;
  private cc.a vSY;
  private MusicPreference.a vSZ;
  private boolean vTa;
  
  public ProductUI()
  {
    AppMethodBeat.i(51876);
    this.vSL = 0;
    this.fpP = null;
    this.vSO = false;
    this.vSS = false;
    this.vSU = false;
    this.vSV = false;
    this.vSW = false;
    this.gXx = false;
    this.fjJ = new b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(51851);
        if (paramAnonymousBoolean)
        {
          ad.i("MicroMsg.scanner.ProductUI", "getLocation suc");
          if (ProductUI.a(ProductUI.this) != null)
          {
            ad.i("MicroMsg.scanner.ProductUI", "do getActionInfoScene, lng=" + paramAnonymousFloat1 + ", lat=" + paramAnonymousFloat2);
            com.tencent.mm.plugin.scanner.model.f localf = new com.tencent.mm.plugin.scanner.model.f(ProductUI.b(ProductUI.this), com.tencent.mm.plugin.scanner.model.o.fa(ProductUI.a(ProductUI.this).wbf), ProductUI.c(ProductUI.this), ProductUI.d(ProductUI.this), paramAnonymousFloat1, paramAnonymousFloat2);
            com.tencent.mm.kernel.g.aeS().a(localf, 0);
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
        if ((!ProductUI.i(ProductUI.this)) && (!com.tencent.mm.modelgeo.d.axU()))
        {
          ProductUI.j(ProductUI.this);
          com.tencent.mm.ui.base.h.a(ProductUI.this, ProductUI.this.getString(2131760082), ProductUI.this.getString(2131755906), ProductUI.this.getString(2131760598), ProductUI.this.getString(2131755691), false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(51850);
              com.tencent.mm.modelgeo.d.cv(ProductUI.this);
              AppMethodBeat.o(51850);
            }
          }, null);
        }
        ad.w("MicroMsg.scanner.ProductUI", "getLocation fail");
        AppMethodBeat.o(51851);
        return false;
      }
    };
    this.vSY = new cc.a()
    {
      public final void a(f.a paramAnonymousa)
      {
        AppMethodBeat.i(51861);
        Object localObject1 = z.a(paramAnonymousa.fTo.Cxz);
        ad.i("MicroMsg.scanner.ProductUI", "lo-scanner-onRecieveMsg");
        paramAnonymousa = ProductUI.a(ProductUI.this);
        Object localObject2;
        if ((paramAnonymousa != null) && (!bt.isNullOrNil((String)localObject1)))
        {
          localObject1 = bw.K((String)localObject1, "sysmsg");
          localObject2 = (String)((Map)localObject1).get(".sysmsg.scanproductinfo.product.id");
          if ((!bt.isNullOrNil(paramAnonymousa.field_productid)) && (paramAnonymousa.field_productid.equals(localObject2))) {
            break label143;
          }
          ad.i("MicroMsg.ProductUpdateLogic", "lo-scanner-doUpdateActionLogicByNewXml: product id not match, productId=" + bt.nullAsNil((String)localObject2) + ", target=" + paramAnonymousa.field_productid);
        }
        for (;;)
        {
          aq.f(new Runnable()
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
          localObject1 = com.tencent.mm.plugin.scanner.model.a.m((Map)localObject1, ".sysmsg.scanproductinfo.product");
          localObject2 = new HashMap();
          int i = 0;
          while (i < ((List)localObject1).size())
          {
            LinkedList localLinkedList = ((com.tencent.mm.plugin.scanner.model.a)((List)localObject1).get(i)).kGU;
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
          ad.i("MicroMsg.ProductUpdateLogic", "lo-scanner-doUpdateActionLogicByNewXml: toUpdateSize=" + ((Map)localObject2).size());
          com.tencent.mm.plugin.scanner.model.o.b(paramAnonymousa.wbf, (Map)localObject2);
        }
      }
      
      public final void a(f.c paramAnonymousc) {}
    };
    this.vSZ = new MusicPreference.a()
    {
      public final void d(MusicPreference paramAnonymousMusicPreference)
      {
        AppMethodBeat.i(51854);
        if (paramAnonymousMusicPreference == null)
        {
          ad.e("MicroMsg.scanner.ProductUI", "onMusicPrefClick, musicPref == null");
          AppMethodBeat.o(51854);
          return;
        }
        if ((bt.isNullOrNil(paramAnonymousMusicPreference.vNW)) && (bt.isNullOrNil(paramAnonymousMusicPreference.vNX)))
        {
          ad.w("MicroMsg.scanner.ProductUI", "wifiurl = null,  wapurl = null");
          if (!bt.isNullOrNil(paramAnonymousMusicPreference.vNY)) {
            ProductUI.a(ProductUI.this, paramAnonymousMusicPreference.vNY);
          }
          AppMethodBeat.o(51854);
          return;
        }
        String str1 = String.format("%s_cd_%s", new Object[] { paramAnonymousMusicPreference.vNW, paramAnonymousMusicPreference.mKey });
        int j;
        ArrayList localArrayList;
        int i;
        label193:
        MusicPreference localMusicPreference;
        String str2;
        if (!ProductUI.amJ(str1))
        {
          if (paramAnonymousMusicPreference.getTitle() == null)
          {
            ad.e("MicroMsg.scanner.ProductUI", "onPlayBtnClick, getTitle() == null");
            AppMethodBeat.o(51854);
            return;
          }
          j = -1;
          if (ProductUI.o(ProductUI.this) == null)
          {
            str1 = null;
            paramAnonymousMusicPreference = String.format("%s_cd_%s", new Object[] { paramAnonymousMusicPreference.vNW, paramAnonymousMusicPreference.mKey });
            localArrayList = new ArrayList();
            Iterator localIterator = ProductUI.p(ProductUI.this).iterator();
            i = 0;
            if (!localIterator.hasNext()) {
              break label330;
            }
            localMusicPreference = (MusicPreference)localIterator.next();
            str2 = String.format("%s_cd_%s", new Object[] { localMusicPreference.vNW, localMusicPreference.mKey });
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
          localArrayList.add(com.tencent.mm.az.g.a(5, str1, localMusicPreference.getTitle().toString(), "", localMusicPreference.vNY, localMusicPreference.vNX, localMusicPreference.vNW, str2, com.tencent.mm.kernel.g.afB().gcW, str1, "", "wx482a4001c37e2b74"));
          i += 1;
          break label193;
          str1 = ProductUI.o(ProductUI.this).aGy();
          break;
          if (j < 0)
          {
            AppMethodBeat.o(51854);
            return;
          }
          com.tencent.mm.az.a.f(localArrayList, j);
          for (;;)
          {
            ProductUI.q(ProductUI.this);
            AppMethodBeat.o(51854);
            return;
            com.tencent.mm.az.a.azD();
            ad.d("MicroMsg.scanner.ProductUI", "isTheSameId, playMusicId : [%s]", new Object[] { str1 });
          }
        }
      }
    };
    this.vTa = true;
    this.jBI = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(51876);
  }
  
  private void a(final k.a parama)
  {
    AppMethodBeat.i(51883);
    if (parama == null)
    {
      ad.e("MicroMsg.scanner.ProductUI", "refreshViewByProduct(), pd == null");
      finish();
      AppMethodBeat.o(51883);
      return;
    }
    if (!bt.isNullOrNil(parama.field_thumburl)) {
      this.vSN = new ProductUI.a(parama);
    }
    dmc();
    if ((!bt.isNullOrNil(parama.field_introtitle)) && (!bt.isNullOrNil(parama.field_introlink)))
    {
      this.ihU.setText(parama.field_introtitle);
      this.ihU.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(51869);
          ProductUI.a(ProductUI.this, 10003, parama.field_introlink);
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("rawUrl", parama.field_introlink);
          paramAnonymousView.putExtra("geta8key_scene", ProductUI.m(ProductUI.this));
          com.tencent.mm.bs.d.b(ProductUI.this.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
          AppMethodBeat.o(51869);
        }
      });
      this.ihU.setVisibility(0);
      this.vSL = this.vSJ.field_functionType;
      if (parama.field_xmlType != 3) {
        break label399;
      }
      this.titleTv.setText(parama.field_title);
      if (bt.isNullOrNil(parama.field_certification)) {
        break label312;
      }
      this.vSE.setText(parama.field_certification);
      this.vSF.setVisibility(0);
      label166:
      if ((parama.field_type != 1) && (parama.field_type != 2)) {
        break label359;
      }
      this.vSB = ((ImageView)findViewById(2131303432));
      findViewById(2131303432).setVisibility(0);
      findViewById(2131303435).setVisibility(8);
      label219:
      if (!bt.isNullOrNil(parama.field_playurl))
      {
        ImageView localImageView = (ImageView)findViewById(2131303428);
        localImageView.setVisibility(0);
        localImageView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(51870);
            Object localObject = new Intent("android.intent.action.VIEW");
            com.tencent.mm.sdk.platformtools.m.a(ProductUI.this.getContext(), (Intent)localObject, Uri.parse(parama.field_playurl), "video/*");
            paramAnonymousView = ProductUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/scanner/ui/ProductUI$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/scanner/ui/ProductUI$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
      ad.v("MicroMsg.scanner.ProductUI", "start postToMainThread initBodyView");
      aq.f(new Runnable()
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
      this.ihU.setVisibility(8);
      break;
      label312:
      this.vSE.setText(parama.field_source);
      this.vSF.setVisibility(8);
      this.vSG.setOnClickListener(null);
      this.vSG.setBackgroundDrawable(null);
      this.vSG.setFocusable(false);
      break label166;
      label359:
      this.vSB = ((ImageView)findViewById(2131303435));
      findViewById(2131303435).setVisibility(0);
      findViewById(2131303432).setVisibility(8);
      break label219;
      label399:
      if (parama.field_xmlType == 4)
      {
        this.vSB = ((ImageView)findViewById(2131303435));
        findViewById(2131303435).setVisibility(0);
        findViewById(2131303432).setVisibility(8);
        this.vSB.setImageResource(2131691126);
        this.vSB.setBackgroundResource(2131691126);
        this.titleTv.setText(2131762827);
        this.vSE.setText(null);
      }
    }
  }
  
  private static boolean amF(String paramString)
  {
    AppMethodBeat.i(51889);
    com.tencent.mm.az.f localf = com.tencent.mm.az.a.azI();
    if ((localf != null) && (localf.hnn == 5) && (paramString.equals(localf.hnp)) && (com.tencent.mm.az.a.azF()))
    {
      AppMethodBeat.o(51889);
      return true;
    }
    AppMethodBeat.o(51889);
    return false;
  }
  
  private static String amG(String paramString)
  {
    AppMethodBeat.i(51893);
    if (bt.isNullOrNil(paramString))
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
      ad.w("MicroMsg.scanner.ProductUI", paramString + ";" + localException.getLocalizedMessage());
      AppMethodBeat.o(51893);
    }
    return null;
  }
  
  private static boolean amH(String paramString)
  {
    AppMethodBeat.i(51895);
    paramString = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(paramString);
    if ((paramString != null) && ((int)paramString.fId > 0) && (com.tencent.mm.n.b.ls(paramString.field_type)))
    {
      AppMethodBeat.o(51895);
      return true;
    }
    AppMethodBeat.o(51895);
    return false;
  }
  
  private void amI(String paramString)
  {
    AppMethodBeat.i(51896);
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putString("jsapi_args_appid", com.tencent.mm.plugin.scanner.model.m.KN(this.vSL));
    localIntent.putExtra("jsapiargs", localBundle);
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("pay_channel", 3);
    localIntent.putExtra("geta8key_scene", beH());
    com.tencent.mm.bs.d.b(getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(51896);
  }
  
  private void b(k.a parama)
  {
    AppMethodBeat.i(51885);
    if ((parama == null) || (parama.wbf == null) || (parama.wbf.size() == 0) || (this.screen == null))
    {
      AppMethodBeat.o(51885);
      return;
    }
    this.screen.removeAll();
    int i = 0;
    while (i < parama.wbf.size())
    {
      Object localObject2 = (com.tencent.mm.plugin.scanner.model.a)parama.wbf.get(i);
      Object localObject1;
      Object localObject3;
      if ((localObject2 != null) && (((com.tencent.mm.plugin.scanner.model.a)localObject2).kGU != null) && (((com.tencent.mm.plugin.scanner.model.a)localObject2).kGU.size() != 0) && (((com.tencent.mm.plugin.scanner.model.a)localObject2).vNS != 1) && (((com.tencent.mm.plugin.scanner.model.a)localObject2).vNU))
      {
        if (i != 0)
        {
          localObject1 = new Preference(this);
          ((Preference)localObject1).setLayoutResource(2131495109);
          this.screen.b((Preference)localObject1);
        }
        if ((!bt.isNullOrNil(((com.tencent.mm.plugin.scanner.model.a)localObject2).title)) && ((((com.tencent.mm.plugin.scanner.model.a)localObject2).type == 6) || (((com.tencent.mm.plugin.scanner.model.a)localObject2).type == 7)))
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
        while (j < ((com.tencent.mm.plugin.scanner.model.a)localObject2).kGU.size())
        {
          localObject3 = (a.a)((com.tencent.mm.plugin.scanner.model.a)localObject2).kGU.get(j);
          if (((a.a)localObject3).type == 10) {
            ((List)localObject1).add(localObject3);
          }
          j += 1;
        }
        if (((List)localObject1).size() > 0)
        {
          localObject2 = new g(this);
          ((g)localObject2).setKey(i * 100);
          ((g)localObject2).uxc = ((List)localObject1);
          this.screen.b((Preference)localObject2);
        }
      }
      i += 1;
      continue;
      label353:
      int j = 0;
      label355:
      a.a locala;
      if (j < ((com.tencent.mm.plugin.scanner.model.a)localObject2).kGU.size())
      {
        localObject3 = i * 100 + j;
        locala = (a.a)((com.tencent.mm.plugin.scanner.model.a)localObject2).kGU.get(j);
        if (locala.type == 11)
        {
          this.vSS = true;
          this.vST = locala.name;
        }
        if (locala.dcz != 2)
        {
          if (locala.dcz != 1) {
            break label509;
          }
          if (!bt.isNullOrNil(locala.image))
          {
            localObject1 = new b(this);
            ((b)localObject1).setKey((String)localObject3);
            ((b)localObject1).ozO = locala.image;
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
          ((MusicPreference)localObject1).vNW = locala.vNW;
          ((MusicPreference)localObject1).vNX = locala.vNX;
          ((MusicPreference)localObject1).vNY = locala.vNY;
          if (!amF(String.format("%s_cd_%s", new Object[] { locala.vNW, localObject3 })))
          {
            ((MusicPreference)localObject1).pa(false);
            ((MusicPreference)localObject1).vSh = this.vSZ;
            this.screen.b((Preference)localObject1);
            com.tencent.mm.sdk.b.a.ESL.c(this.jBI);
            if (this.tWo == null) {
              this.tWo = new ArrayList();
            }
            if (this.vTa) {
              this.tWo.add(localObject1);
            }
          }
        }
        for (;;)
        {
          label610:
          if ((j >= ((com.tencent.mm.plugin.scanner.model.a)localObject2).kGU.size() - 1) || (locala.type == 12) || (((a.a)((com.tencent.mm.plugin.scanner.model.a)localObject2).kGU.get(j + 1)).type == 12) || (((a.a)((com.tencent.mm.plugin.scanner.model.a)localObject2).kGU.get(j + 1)).dcz == 1) || (!d(j, ((com.tencent.mm.plugin.scanner.model.a)localObject2).kGU))) {
            break label1185;
          }
          localObject1 = new f(this);
          this.screen.b((Preference)localObject1);
          break;
          ((MusicPreference)localObject1).pa(true);
          break label610;
          if (locala.type == 6)
          {
            localObject1 = new d(this);
            ((d)localObject1).setKey((String)localObject3);
            ((d)localObject1).mTitle = locala.name;
            ((d)localObject1).setSummary(locala.desc);
            this.screen.b((Preference)localObject1);
            ((d)localObject1).vRW = this.vSQ;
          }
          else if (locala.type == 12)
          {
            localObject1 = new e(this);
            ((e)localObject1).setKey((String)localObject3);
            ((e)localObject1).ozO = locala.thumburl;
            ((e)localObject1).screen = this.screen;
            this.screen.b((Preference)localObject1);
          }
          else
          {
            if (locala.type == 2)
            {
              if (amH(locala.username)) {}
              for (localObject1 = locala.vOe;; localObject1 = locala.vOd)
              {
                a locala1 = new a(this);
                locala1.setKey((String)localObject3);
                locala1.setTitle((CharSequence)localObject1);
                locala1.setSummary(locala.desc);
                locala1.vQC = locala.gKF;
                this.screen.b(locala1);
                break;
              }
            }
            if (locala.type == 22)
            {
              localObject1 = new c(this);
              ((c)localObject1).setKey((String)localObject3);
              if (!bt.isNullOrNil(locala.nickname)) {
                ((c)localObject1).nLX = (locala.nickname + ":");
              }
              ((c)localObject1).mContent = locala.content;
              ((c)localObject1).vRK = locala.thumburl;
              this.screen.b((Preference)localObject1);
            }
            else
            {
              localObject1 = new a(this);
              ((a)localObject1).setKey((String)localObject3);
              ((a)localObject1).setTitle(locala.name);
              ((a)localObject1).setSummary(locala.desc);
              ((a)localObject1).vQC = locala.gKF;
              ((a)localObject1).oyz = locala.iconUrl;
              this.screen.b((Preference)localObject1);
            }
          }
        }
      }
    }
    this.screen.notifyDataSetChanged();
    ad.d("MicroMsg.scanner.ProductUI", "initBodyView finish");
    if (this.tWo != null) {
      this.vTa = false;
    }
    AppMethodBeat.o(51885);
  }
  
  private void bN(int paramInt, String paramString)
  {
    AppMethodBeat.i(51890);
    if (this.vSJ == null)
    {
      AppMethodBeat.o(51890);
      return;
    }
    paramString = new com.tencent.mm.plugin.scanner.model.k(this.vSJ.field_productid, "", paramInt, paramString, 0, 0);
    com.tencent.mm.kernel.g.aeS().a(paramString, 0);
    AppMethodBeat.o(51890);
  }
  
  private int beH()
  {
    if (this.vSL == 4) {
      return 11;
    }
    if (this.vSL == 3) {
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
        if (((a.a)paramLinkedList.get(paramInt)).dcz != 2)
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
  
  private void dmc()
  {
    AppMethodBeat.i(51882);
    this.vSM = getContext().getResources().getDimensionPixelSize(2131166695);
    if ((this.vSJ != null) && ((this.vSJ.field_type == 1) || (this.vSJ.field_type == 2)))
    {
      this.vSM = getContext().getResources().getDimensionPixelSize(2131166696);
      Object localObject = this.vSC.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).height = this.vSM;
      this.vSC.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = this.vSD.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).height = this.vSM;
      this.vSH.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (RelativeLayout)findViewById(2131303430);
      ViewGroup.LayoutParams localLayoutParams = ((RelativeLayout)localObject).getLayoutParams();
      localLayoutParams.height = this.vSM;
      ((RelativeLayout)localObject).setLayoutParams(localLayoutParams);
      localObject = this.vSH.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).height = this.vSM;
      this.vSH.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    AppMethodBeat.o(51882);
  }
  
  private void dmd()
  {
    AppMethodBeat.i(51884);
    this.msgId = getIntent().getLongExtra("key_ProductUI_chatting_msgId", 0L);
    if ((this.msgId > 0L) && (com.tencent.mm.kernel.g.afw()))
    {
      bl localbl = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().rm(this.msgId);
      if (localbl.field_msgId > 0L)
      {
        localbl.nZ(this.vSN.aGy());
        ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().a(this.msgId, localbl);
      }
    }
    AppMethodBeat.o(51884);
  }
  
  private void dme()
  {
    AppMethodBeat.i(51887);
    if ((this.vSJ == null) || (this.vSJ.wbf == null) || (this.vSJ.wbf.size() == 0) || (this.screen == null))
    {
      AppMethodBeat.o(51887);
      return;
    }
    int i = 0;
    while (i < this.vSJ.wbf.size())
    {
      com.tencent.mm.plugin.scanner.model.a locala = (com.tencent.mm.plugin.scanner.model.a)this.vSJ.wbf.get(i);
      if ((locala != null) && (locala.kGU != null) && (locala.kGU.size() != 0))
      {
        int j = 0;
        if (j < locala.kGU.size())
        {
          a.a locala1 = (a.a)locala.kGU.get(j);
          MusicPreference localMusicPreference;
          if (locala1.type == 5)
          {
            String str = i * 100 + j;
            localMusicPreference = (MusicPreference)this.screen.aKk(str);
            if (localMusicPreference != null)
            {
              if (amF(String.format("%s_cd_%s", new Object[] { locala1.vNW, str }))) {
                break label221;
              }
              localMusicPreference.pa(false);
            }
          }
          for (;;)
          {
            j += 1;
            break;
            label221:
            localMusicPreference.pa(true);
          }
        }
      }
      i += 1;
    }
    this.screen.notifyDataSetChanged();
    AppMethodBeat.o(51887);
  }
  
  private int dmf()
  {
    if (this.vSL == 3) {
      return 47;
    }
    return 49;
  }
  
  private void dmg()
  {
    AppMethodBeat.i(51897);
    if (this.vSJ != null)
    {
      ad.i("MicroMsg.scanner.ProductUI", "doUpdateActionLogic, flag=:" + this.vSJ.field_getaction);
      if ((this.vSJ.field_getaction & 0x2) > 0)
      {
        this.fjC = com.tencent.mm.modelgeo.d.axT();
        if (this.fjC != null)
        {
          this.fjC.b(this.fjJ);
          AppMethodBeat.o(51897);
        }
      }
      else if ((this.vSJ.field_getaction & 0x1) > 0)
      {
        com.tencent.mm.plugin.scanner.model.f localf = new com.tencent.mm.plugin.scanner.model.f(this.oyw, com.tencent.mm.plugin.scanner.model.o.fa(this.vSJ.wbf), this.mScene, this.vSR, 0.0D, 0.0D);
        com.tencent.mm.kernel.g.aeS().a(localf, 0);
      }
    }
    AppMethodBeat.o(51897);
  }
  
  private void dmh()
  {
    AppMethodBeat.i(51899);
    if (!com.tencent.mm.plugin.scanner.util.e.dni())
    {
      ad.e("MicroMsg.scanner.ProductUI", "mHistoryItem ScanHistoryUtil.shouldShowHistoryList() is false!");
      AppMethodBeat.o(51899);
      return;
    }
    com.tencent.mm.plugin.scanner.history.a.a locala = new com.tencent.mm.plugin.scanner.history.a.a();
    locala.field_productId = this.oyw;
    if (!com.tencent.mm.plugin.scanner.h.dkY().dkZ().get(locala, new String[0])) {}
    for (boolean bool = com.tencent.mm.plugin.scanner.h.dkY().dkZ().insert(this.vSX); bool; bool = com.tencent.mm.plugin.scanner.h.dkY().dkZ().update(this.vSX, new String[0]))
    {
      ad.i("MicroMsg.scanner.ProductUI", "mHistoryItem insert success!");
      this.vSV = true;
      AppMethodBeat.o(51899);
      return;
    }
    ad.e("MicroMsg.scanner.ProductUI", "mHistoryItem insert fail!");
    AppMethodBeat.o(51899);
  }
  
  private static void s(View paramView, float paramFloat)
  {
    AppMethodBeat.i(51898);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(paramFloat, paramFloat);
    localAlphaAnimation.setDuration(0L);
    localAlphaAnimation.setFillAfter(true);
    paramView.startAnimation(localAlphaAnimation);
    AppMethodBeat.o(51898);
  }
  
  private void u(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(51894);
    this.oyw = paramString1;
    this.vSR = paramString2;
    paramString1 = new com.tencent.mm.plugin.scanner.model.g(paramString1, this.mScene, paramString2);
    com.tencent.mm.kernel.g.aeS().a(paramString1, 0);
    if (!paramBoolean)
    {
      paramString2 = getContext();
      getString(2131755906);
      this.fpP = com.tencent.mm.ui.base.h.c(paramString2, getString(2131762836), true, new ProductUI.8(this, paramString1));
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
    this.vSC = ((ImageView)findViewById(2131303429));
    this.vSD = findViewById(2131303434);
    this.vSF = ((ImageView)findViewById(2131303424));
    this.vSK = findViewById(2131303420);
    this.vSH = ((LinearLayout)findViewById(2131303433));
    this.vSI = ((ImageView)findViewById(2131303431));
    this.vSG = findViewById(2131303423);
    s(this.vSK, 0.0F);
    Object localObject;
    String str;
    if (com.tencent.mm.cd.a.hS(getContext()))
    {
      this.titleTv.setTextSize(0, getContext().getResources().getDimensionPixelSize(2131165266) * com.tencent.mm.cd.a.hH(getContext()));
      this.vSE = ((TextView)findViewById(2131303422));
      this.ihU = ((TextView)findViewById(2131304328));
      this.vSP = new HashMap();
      this.vSQ = new d.a()
      {
        public final void a(String paramAnonymousString, Boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(51863);
          if ((paramAnonymousString != null) && (paramAnonymousString.length() > 0)) {
            ProductUI.k(ProductUI.this).put(paramAnonymousString, paramAnonymousBoolean);
          }
          AppMethodBeat.o(51863);
        }
        
        public final Boolean amD(String paramAnonymousString)
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
        
        public final void dmb()
        {
          AppMethodBeat.i(51865);
          if (ProductUI.this.screen != null) {
            ProductUI.this.screen.notifyDataSetChanged();
          }
          AppMethodBeat.o(51865);
        }
      };
      this.vSX = new com.tencent.mm.plugin.scanner.history.a.a();
      this.vSX.field_ScanTime = System.currentTimeMillis();
      this.vSX.field_scene = this.mScene;
      if (this.mScene != 5) {
        break label428;
      }
      this.vSU = true;
      localObject = getIntent().getStringExtra("key_Qrcode_Url");
      str = amG((String)localObject);
      this.vSX.field_qrcodeUrl = ((String)localObject);
      this.vSX.field_productId = str;
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
          ProductUI.l(ProductUI.this);
          AppMethodBeat.o(51866);
        }
      });
      findViewById(2131303425).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(51867);
          ProductUI.l(ProductUI.this);
          AppMethodBeat.o(51867);
        }
      });
      this.vSG.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(51868);
          if ((ProductUI.a(ProductUI.this) != null) && (!bt.isNullOrNil(ProductUI.a(ProductUI.this).field_certificationurl)))
          {
            ProductUI.a(ProductUI.this, 10002, ProductUI.a(ProductUI.this).field_certificationurl);
            ProductUI.a(ProductUI.this, ProductUI.a(ProductUI.this).field_certificationurl);
          }
          AppMethodBeat.o(51868);
        }
      });
      new b();
      AppMethodBeat.o(51881);
      return;
      this.titleTv.setTextSize(0, com.tencent.mm.cd.a.ao(getContext(), 2131165266));
      break;
      label428:
      if (this.mScene == 4)
      {
        localObject = getIntent().getStringExtra("key_product_id");
        str = getIntent().getStringExtra("key_Qrcode_Url");
        if (!bt.isNullOrNil((String)localObject))
        {
          u((String)localObject, str, false);
        }
        else
        {
          ad.e("MicroMsg.scanner.ProductUI", "jsapi jump finish productId null");
          finish();
          AppMethodBeat.o(51881);
        }
      }
      else
      {
        this.vSW = getIntent().getBooleanExtra("key_is_from_barcode", false);
        this.vSU = getIntent().getBooleanExtra("key_need_add_to_history", false);
        localObject = getIntent().getStringExtra("key_Product_xml");
        if (!bt.isNullOrNil((String)localObject))
        {
          int i = getIntent().getIntExtra("key_Product_funcType", 0);
          this.vSJ = com.tencent.mm.plugin.scanner.model.m.en((String)localObject, i);
          if (this.vSJ == null)
          {
            ad.e("MicroMsg.scanner.ProductUI", "initView(), product == null");
            finish();
            AppMethodBeat.o(51881);
            return;
          }
          this.oyw = this.vSJ.field_productid;
          this.vSR = this.vSJ.field_extinfo;
          if ((this.vSU) && (!TextUtils.isEmpty(this.oyw)))
          {
            this.vSX.field_xmlContent = ((String)localObject);
            this.vSX.field_qrcodeUrl = this.vSR;
            this.vSX.field_productId = this.oyw;
            this.vSX.field_funcType = i;
            dmh();
          }
          for (;;)
          {
            localObject = this.vSJ;
            getIntent().getBooleanExtra("key_ProductUI_addToDB", true);
            a((k.a)localObject);
            if ((i != 0) || (bt.isNullOrNil(this.vSJ.field_productid))) {
              break label772;
            }
            u(this.vSJ.field_productid, this.vSJ.field_extinfo, true);
            break;
            ad.i("MicroMsg.scanner.ProductUI", "shouldAddToHistory:" + this.vSU + " mProductId:" + this.oyw);
          }
          dmg();
        }
        else
        {
          localObject = getIntent().getStringExtra("key_Product_ID");
          if (bt.isNullOrNil((String)localObject)) {
            break label807;
          }
          u((String)localObject, null, false);
        }
      }
    }
    label807:
    ad.e("MicroMsg.scanner.ProductUI", "normal finish productId null");
    finish();
    AppMethodBeat.o(51881);
  }
  
  public final void l(final String paramString, final Bitmap paramBitmap)
  {
    AppMethodBeat.i(51891);
    if ((!bt.isNullOrNil(paramString)) && (this.vSJ != null) && (paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      ad.d("MicroMsg.scanner.ProductUI", "onGetPictureFinish: notifyKey=".concat(String.valueOf(paramString)));
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(51858);
          if ((paramString.equals(ProductUI.a(ProductUI.this).field_thumburl)) && (ProductUI.s(ProductUI.this) != null)) {
            ad.i("MicroMsg.scanner.ProductUI", "onGetPictureFinish: notifyKey=" + paramString);
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
              ad.e("MicroMsg.scanner.ProductUI", "onGetPictureFinish : [%s]", new Object[] { localException.getLocalizedMessage() });
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
    this.mStartTime = bt.aGK();
    this.mScene = getIntent().getIntExtra("key_ProductUI_getProductInfoScene", 0);
    u.b(this);
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().a("scanproductinfo", this.vSY, true);
    initView();
    AppMethodBeat.o(51877);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(51880);
    u.c(this);
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().b("scanproductinfo", this.vSY, true);
    com.tencent.mm.sdk.b.a.ESL.d(this.jBI);
    if (this.fjC != null) {
      this.fjC.c(this.fjJ);
    }
    bN(10100, bt.aGK() - this.mStartTime);
    super.onDestroy();
    AppMethodBeat.o(51880);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(51879);
    com.tencent.mm.kernel.g.aeS().b(1063, this);
    com.tencent.mm.kernel.g.aeS().b(1068, this);
    super.onPause();
    AppMethodBeat.o(51879);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(51888);
    ad.i("MicroMsg.scanner.ProductUI", "onPreferenceTreeClick item: [%s]", new Object[] { paramPreference.mKey });
    if ((this.vSJ == null) || (this.vSJ.wbf == null))
    {
      ad.e("MicroMsg.scanner.ProductUI", "product == null || product.actionlist == null");
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
        ad.v("MicroMsg.scanner.ProductUI", "keyId=[%s], ii=[%s], jj=[%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
        if ((j < 0) || (j >= this.vSJ.wbf.size()))
        {
          ad.w("MicroMsg.scanner.ProductUI", "index out of bounds, ii=[%s], list Size=[%s]", new Object[] { Integer.valueOf(j), Integer.valueOf(this.vSJ.wbf.size()) });
          AppMethodBeat.o(51888);
          return false;
        }
        locala = (com.tencent.mm.plugin.scanner.model.a)this.vSJ.wbf.get(j);
        if (locala == null)
        {
          ad.w("MicroMsg.scanner.ProductUI", "actionList == null");
          AppMethodBeat.o(51888);
          return false;
        }
        if ((k < 0) || (k >= locala.kGU.size()))
        {
          ad.w("MicroMsg.scanner.ProductUI", "index out of bounds, jj=[%s], actions Size=[%s]", new Object[] { Integer.valueOf(k), Integer.valueOf(locala.kGU.size()) });
          AppMethodBeat.o(51888);
          return false;
        }
        locala1 = (a.a)locala.kGU.get(k);
        if (locala1 == null)
        {
          ad.w("MicroMsg.scanner.ProductUI", "action == null");
          AppMethodBeat.o(51888);
          return false;
        }
        ad.i("MicroMsg.scanner.ProductUI", "action.type = [%s]", new Object[] { Integer.valueOf(locala1.type) });
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
          ad.d("MicroMsg.scanner.ProductUI", "Default go url:" + locala1.link);
          if (bt.isNullOrNil(locala1.link)) {
            break label1271;
          }
          amI(locala1.link);
        }
      }
      catch (Exception paramf)
      {
        com.tencent.mm.plugin.scanner.model.a locala;
        ad.e("MicroMsg.scanner.ProductUI", "onPreferenceTreeClick, [%s]", new Object[] { paramf.getMessage() });
        ad.printErrStackTrace("MicroMsg.scanner.ProductUI", paramf, "", new Object[0]);
        AppMethodBeat.o(51888);
        return false;
      }
      paramf = new com.tencent.mm.plugin.scanner.model.k(this.vSJ.field_productid, locala1.vNZ, locala1.type, paramf, locala.kGU.size(), locala1.dcz);
      com.tencent.mm.kernel.g.aeS().a(paramf, 0);
      AppMethodBeat.o(51888);
      return true;
      paramPreference = locala1.link;
      paramf = paramPreference;
      if (!bt.isNullOrNil(locala1.link))
      {
        amI(locala1.link);
        paramf = paramPreference;
        continue;
        paramPreference = locala1.username;
        paramf = paramPreference;
        if (!bt.isNullOrNil(locala1.username))
        {
          paramf = locala1.username;
          if (amH(paramf))
          {
            localIntent = new Intent();
            localIntent.putExtra("Chat_User", paramf);
            localIntent.putExtra("finish_direct", true);
            localIntent.putExtra("add_scene", dmf());
            com.tencent.mm.plugin.scanner.f.hYt.d(localIntent, getContext());
            paramf = paramPreference;
          }
          else if (TextUtils.isEmpty(paramf))
          {
            ad.v("MicroMsg.scanner.ProductUI", "username is null");
            paramf = paramPreference;
          }
          else
          {
            localIntent = new Intent();
            localIntent.putExtra("Contact_User", paramf);
            localIntent.putExtra("force_get_contact", true);
            localIntent.putExtra("Contact_Scene", dmf());
            com.tencent.mm.plugin.scanner.f.hYt.c(localIntent, this);
            paramf = paramPreference;
            continue;
            paramf = locala1.vNY;
            localIntent.putExtra("rawUrl", locala1.vNY);
            localIntent.putExtra("geta8key_scene", beH());
            com.tencent.mm.plugin.scanner.f.hYt.i(localIntent, this);
            com.tencent.mm.az.a.azD();
            dme();
            continue;
            paramPreference = locala1.vOa;
            paramf = paramPreference;
            if (!bt.isNullOrNil(locala1.vOa))
            {
              localIntent.putExtra("key_product_id", locala1.vOa);
              localIntent.putExtra("key_product_scene", 12);
              com.tencent.mm.bs.d.b(this, "product", ".ui.MallProductUI", localIntent);
              paramf = paramPreference;
              continue;
              paramf = locala1.vOa;
              localIntent.putExtra("key_card_id", locala1.vOc);
              localIntent.putExtra("key_card_ext", locala1.vOb);
              localIntent.putExtra("key_from_scene", 9);
              com.tencent.mm.bs.d.b(this, "card", ".ui.CardDetailUI", localIntent);
              continue;
              localIntent.setClass(this, ProductFurtherInfoUI.class);
              localIntent.putExtra("key_Product_xml", this.vSJ.field_xml);
              localIntent.putExtra("key_title", locala1.name);
              paramf = new com.tencent.mm.hellhoundlib.b.a().bd(localIntent);
              com.tencent.mm.hellhoundlib.a.a.a(this, paramf.adn(), "com/tencent/mm/plugin/scanner/ui/ProductUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              startActivity((Intent)paramf.lS(0));
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/ProductUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramf = null;
              continue;
              paramf = locala1.vNT;
              localIntent.setClass(this, ProductPurchaseAreaUI.class);
              localIntent.putExtra("key_Product_xml", this.vSJ.field_xml);
              localIntent.putExtra("referkey", locala1.vNT);
              localIntent.putExtra("key_Product_funcType", this.vSL);
              paramPreference = new com.tencent.mm.hellhoundlib.b.a().bd(localIntent);
              com.tencent.mm.hellhoundlib.a.a.a(this, paramPreference.adn(), "com/tencent/mm/plugin/scanner/ui/ProductUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              startActivity((Intent)paramPreference.lS(0));
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/ProductUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              continue;
              paramPreference = locala1.link;
              paramf = paramPreference;
              if (!bt.isNullOrNil(locala1.link))
              {
                amI(locala1.link);
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
    com.tencent.mm.kernel.g.aeS().a(1063, this);
    com.tencent.mm.kernel.g.aeS().a(1068, this);
    AppMethodBeat.o(51878);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(51892);
    if (paramn == null)
    {
      ad.w("MicroMsg.scanner.ProductUI", "scene == null");
      AppMethodBeat.o(51892);
      return;
    }
    if (paramn.getType() == 1063)
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ad.e("MicroMsg.scanner.ProductUI", "onSceneEnd() errType = [%s], errCode = [%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        AppMethodBeat.o(51892);
        return;
      }
      paramString = (com.tencent.mm.plugin.scanner.model.g)paramn;
      if ((paramString.rr != null) && (paramString.rr.gUT.gUX != null)) {}
      for (paramString = (ms)paramString.rr.gUT.gUX; paramString == null; paramString = null)
      {
        ad.w("MicroMsg.scanner.ProductUI", "onSceneEnd productInfo == null");
        AppMethodBeat.o(51892);
        return;
      }
      if (paramString.CJG != null)
      {
        ad.d("MicroMsg.scanner.ProductUI", "onSceneEnd  productInfo.DescXML != null");
        paramn = com.tencent.mm.plugin.scanner.model.m.en(paramString.CJG, this.vSL);
        if ((this.vSJ != null) && (this.vSJ.field_xml != null) && (paramn != null) && (paramn.field_xml != null) && (!this.vSJ.field_xml.equals(paramn.field_xml)))
        {
          this.vSJ = paramn;
          a(this.vSJ);
        }
        for (;;)
        {
          if ((this.fpP != null) && (this.fpP.isShowing())) {
            this.fpP.dismiss();
          }
          dmg();
          if ((!this.vSU) || (this.vSV) || (TextUtils.isEmpty(this.oyw))) {
            break;
          }
          this.vSX.field_xmlContent = paramString.CJG;
          this.vSX.field_funcType = this.vSL;
          dmh();
          AppMethodBeat.o(51892);
          return;
          if ((paramn != null) && (paramn.field_xml != null))
          {
            this.vSJ = paramn;
            a(this.vSJ);
          }
        }
        ad.i("MicroMsg.scanner.ProductUI", "shouldAddToHistory:" + this.vSU + " mProductId:" + this.oyw + "  hasAddToHistory:" + this.vSV);
      }
      AppMethodBeat.o(51892);
      return;
    }
    if ((paramn.getType() == 1068) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = ((mq)((com.tencent.mm.plugin.scanner.model.f)paramn).rr.gUT.gUX).CJF;
      if ((this.vSJ != null) && (com.tencent.mm.plugin.scanner.model.o.b(this.vSJ.wbf, com.tencent.mm.plugin.scanner.model.o.fb(paramString)))) {
        b(this.vSJ);
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
    int aeU;
    ProductScrollView vTh;
    boolean vTi;
    private ProductScrollView.a vTj;
    
    public b()
    {
      AppMethodBeat.i(51875);
      this.vTj = new ProductScrollView.a()
      {
        public final void caF()
        {
          float f3 = 1.0F;
          AppMethodBeat.i(51874);
          ProductUI.b localb = ProductUI.b.this;
          int i = localb.vTh.getScrollY();
          float f1;
          label65:
          float f2;
          if (i < 0)
          {
            f1 = -1.0F;
            ad.v("MicroMsg.ProductUI.HeaderEffectHelper", "rate=".concat(String.valueOf(f1)));
            if (f1 != 1.0F) {
              break label211;
            }
            if (!localb.vTi)
            {
              localb.vTi = true;
              if (ProductUI.x(localb.vTb) != null)
              {
                float f4 = 1.0F - f1 - 0.2F;
                f2 = f4;
                if (f4 <= 0.0F) {
                  f2 = 0.0F;
                }
                if (f1 == 0.0F) {
                  f2 = 1.0F;
                }
                ProductUI.t(ProductUI.x(localb.vTb), f2);
              }
              if (ProductUI.y(localb.vTb) != null)
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
            ProductUI.t(ProductUI.y(localb.vTb), f2);
            AppMethodBeat.o(51874);
            return;
            if ((i >= ProductUI.z(localb.vTb) - localb.aeU) || (ProductUI.z(localb.vTb) == 0.0F))
            {
              f1 = 1.0F;
              break;
            }
            f1 = i * 1.37F / ProductUI.z(localb.vTb);
            break;
            label211:
            localb.vTi = false;
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
      this.vTh = ((ProductScrollView)ProductUI.this.findViewById(2131303539));
      this.vTh.setOnScrollListener(this.vTj);
      this.aeU = ProductUI.w(ProductUI.this);
      AppMethodBeat.o(51875);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ProductUI
 * JD-Core Version:    0.7.0.1
 */