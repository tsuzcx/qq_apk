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
import com.tencent.mm.ak.f.a;
import com.tencent.mm.ak.f.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.c.av;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.cc;
import com.tencent.mm.model.cc.a;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.scanner.i;
import com.tencent.mm.plugin.scanner.model.a.a;
import com.tencent.mm.plugin.scanner.util.k.a;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.protocal.protobuf.mx;
import com.tencent.mm.protocal.protobuf.mz;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bo;
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
  implements com.tencent.mm.ak.g, u.a
{
  private com.tencent.mm.modelgeo.d fmW;
  private b.a fnd;
  protected ProgressDialog fts;
  private boolean hxW;
  private TextView iIc;
  private com.tencent.mm.sdk.b.c kce;
  private int mScene;
  private long mStartTime;
  private long msgId;
  private String pbW;
  protected com.tencent.mm.ui.base.preference.f screen;
  private TextView titleTv;
  private boolean udt;
  private List<MusicPreference> veY;
  private HashMap<String, Boolean> xdA;
  private d.a xdB;
  private String xdC;
  private boolean xdD;
  private String xdE;
  private boolean xdF;
  private boolean xdG;
  private boolean xdH;
  private com.tencent.mm.plugin.scanner.history.a.a xdI;
  private cc.a xdJ;
  private MusicPreference.a xdK;
  private boolean xdL;
  private ImageView xdm;
  private ImageView xdn;
  private View xdo;
  private TextView xdp;
  private ImageView xdq;
  private View xdr;
  private LinearLayout xds;
  private ImageView xdt;
  private k.a xdu;
  private View xdv;
  private int xdw;
  private int xdx;
  private ProductUI.a xdy;
  private boolean xdz;
  
  public ProductUI()
  {
    AppMethodBeat.i(51876);
    this.xdw = 0;
    this.fts = null;
    this.xdz = false;
    this.xdD = false;
    this.xdF = false;
    this.xdG = false;
    this.xdH = false;
    this.hxW = false;
    this.fnd = new b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(51851);
        if (paramAnonymousBoolean)
        {
          ac.i("MicroMsg.scanner.ProductUI", "getLocation suc");
          if (ProductUI.a(ProductUI.this) != null)
          {
            ac.i("MicroMsg.scanner.ProductUI", "do getActionInfoScene, lng=" + paramAnonymousFloat1 + ", lat=" + paramAnonymousFloat2);
            com.tencent.mm.plugin.scanner.model.f localf = new com.tencent.mm.plugin.scanner.model.f(ProductUI.b(ProductUI.this), com.tencent.mm.plugin.scanner.model.o.fh(ProductUI.a(ProductUI.this).xml), ProductUI.c(ProductUI.this), ProductUI.d(ProductUI.this), paramAnonymousFloat1, paramAnonymousFloat2);
            com.tencent.mm.kernel.g.agi().a(localf, 0);
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
        if ((!ProductUI.i(ProductUI.this)) && (!com.tencent.mm.modelgeo.d.aEM()))
        {
          ProductUI.j(ProductUI.this);
          com.tencent.mm.ui.base.h.a(ProductUI.this, ProductUI.this.getString(2131760082), ProductUI.this.getString(2131755906), ProductUI.this.getString(2131760598), ProductUI.this.getString(2131755691), false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(51850);
              com.tencent.mm.modelgeo.d.cE(ProductUI.this);
              AppMethodBeat.o(51850);
            }
          }, null);
        }
        ac.w("MicroMsg.scanner.ProductUI", "getLocation fail");
        AppMethodBeat.o(51851);
        return false;
      }
    };
    this.xdJ = new cc.a()
    {
      public final void a(f.a paramAnonymousa)
      {
        AppMethodBeat.i(51861);
        Object localObject1 = z.a(paramAnonymousa.fXi.DPV);
        ac.i("MicroMsg.scanner.ProductUI", "lo-scanner-onRecieveMsg");
        paramAnonymousa = ProductUI.a(ProductUI.this);
        Object localObject2;
        if ((paramAnonymousa != null) && (!bs.isNullOrNil((String)localObject1)))
        {
          localObject1 = bv.L((String)localObject1, "sysmsg");
          localObject2 = (String)((Map)localObject1).get(".sysmsg.scanproductinfo.product.id");
          if ((!bs.isNullOrNil(paramAnonymousa.field_productid)) && (paramAnonymousa.field_productid.equals(localObject2))) {
            break label143;
          }
          ac.i("MicroMsg.ProductUpdateLogic", "lo-scanner-doUpdateActionLogicByNewXml: product id not match, productId=" + bs.nullAsNil((String)localObject2) + ", target=" + paramAnonymousa.field_productid);
        }
        for (;;)
        {
          ap.f(new Runnable()
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
            LinkedList localLinkedList = ((com.tencent.mm.plugin.scanner.model.a)((List)localObject1).get(i)).lio;
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
          ac.i("MicroMsg.ProductUpdateLogic", "lo-scanner-doUpdateActionLogicByNewXml: toUpdateSize=" + ((Map)localObject2).size());
          com.tencent.mm.plugin.scanner.model.o.b(paramAnonymousa.xml, (Map)localObject2);
        }
      }
      
      public final void a(f.c paramAnonymousc) {}
    };
    this.xdK = new MusicPreference.a()
    {
      public final void d(MusicPreference paramAnonymousMusicPreference)
      {
        AppMethodBeat.i(51854);
        if (paramAnonymousMusicPreference == null)
        {
          ac.e("MicroMsg.scanner.ProductUI", "onMusicPrefClick, musicPref == null");
          AppMethodBeat.o(51854);
          return;
        }
        if ((bs.isNullOrNil(paramAnonymousMusicPreference.wYs)) && (bs.isNullOrNil(paramAnonymousMusicPreference.wYt)))
        {
          ac.w("MicroMsg.scanner.ProductUI", "wifiurl = null,  wapurl = null");
          if (!bs.isNullOrNil(paramAnonymousMusicPreference.wYu)) {
            ProductUI.a(ProductUI.this, paramAnonymousMusicPreference.wYu);
          }
          AppMethodBeat.o(51854);
          return;
        }
        String str1 = String.format("%s_cd_%s", new Object[] { paramAnonymousMusicPreference.wYs, paramAnonymousMusicPreference.mKey });
        int j;
        ArrayList localArrayList;
        int i;
        label193:
        MusicPreference localMusicPreference;
        String str2;
        if (!ProductUI.arS(str1))
        {
          if (paramAnonymousMusicPreference.getTitle() == null)
          {
            ac.e("MicroMsg.scanner.ProductUI", "onPlayBtnClick, getTitle() == null");
            AppMethodBeat.o(51854);
            return;
          }
          j = -1;
          if (ProductUI.o(ProductUI.this) == null)
          {
            str1 = null;
            paramAnonymousMusicPreference = String.format("%s_cd_%s", new Object[] { paramAnonymousMusicPreference.wYs, paramAnonymousMusicPreference.mKey });
            localArrayList = new ArrayList();
            Iterator localIterator = ProductUI.p(ProductUI.this).iterator();
            i = 0;
            if (!localIterator.hasNext()) {
              break label330;
            }
            localMusicPreference = (MusicPreference)localIterator.next();
            str2 = String.format("%s_cd_%s", new Object[] { localMusicPreference.wYs, localMusicPreference.mKey });
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
          localArrayList.add(com.tencent.mm.ay.g.a(5, str1, localMusicPreference.getTitle().toString(), "", localMusicPreference.wYu, localMusicPreference.wYt, localMusicPreference.wYs, str2, com.tencent.mm.kernel.g.agR().ghC, str1, "", "wx482a4001c37e2b74"));
          i += 1;
          break label193;
          str1 = ProductUI.o(ProductUI.this).aNl();
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
            com.tencent.mm.ay.a.aGt();
            ac.d("MicroMsg.scanner.ProductUI", "isTheSameId, playMusicId : [%s]", new Object[] { str1 });
          }
        }
      }
    };
    this.xdL = true;
    this.kce = new ProductUI.5(this);
    AppMethodBeat.o(51876);
  }
  
  private void a(final k.a parama)
  {
    AppMethodBeat.i(51883);
    if (parama == null)
    {
      ac.e("MicroMsg.scanner.ProductUI", "refreshViewByProduct(), pd == null");
      finish();
      AppMethodBeat.o(51883);
      return;
    }
    if (!bs.isNullOrNil(parama.field_thumburl)) {
      this.xdy = new ProductUI.a(parama);
    }
    dAi();
    if ((!bs.isNullOrNil(parama.field_introtitle)) && (!bs.isNullOrNil(parama.field_introlink)))
    {
      this.iIc.setText(parama.field_introtitle);
      this.iIc.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(51869);
          ProductUI.a(ProductUI.this, 10003, parama.field_introlink);
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("rawUrl", parama.field_introlink);
          paramAnonymousView.putExtra("geta8key_scene", ProductUI.m(ProductUI.this));
          com.tencent.mm.br.d.b(ProductUI.this.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
          AppMethodBeat.o(51869);
        }
      });
      this.iIc.setVisibility(0);
      this.xdw = this.xdu.field_functionType;
      if (parama.field_xmlType != 3) {
        break label399;
      }
      this.titleTv.setText(parama.field_title);
      if (bs.isNullOrNil(parama.field_certification)) {
        break label312;
      }
      this.xdp.setText(parama.field_certification);
      this.xdq.setVisibility(0);
      label166:
      if ((parama.field_type != 1) && (parama.field_type != 2)) {
        break label359;
      }
      this.xdm = ((ImageView)findViewById(2131303432));
      findViewById(2131303432).setVisibility(0);
      findViewById(2131303435).setVisibility(8);
      label219:
      if (!bs.isNullOrNil(parama.field_playurl))
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
            localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/scanner/ui/ProductUI$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
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
      ac.v("MicroMsg.scanner.ProductUI", "start postToMainThread initBodyView");
      ap.f(new Runnable()
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
      this.iIc.setVisibility(8);
      break;
      label312:
      this.xdp.setText(parama.field_source);
      this.xdq.setVisibility(8);
      this.xdr.setOnClickListener(null);
      this.xdr.setBackgroundDrawable(null);
      this.xdr.setFocusable(false);
      break label166;
      label359:
      this.xdm = ((ImageView)findViewById(2131303435));
      findViewById(2131303435).setVisibility(0);
      findViewById(2131303432).setVisibility(8);
      break label219;
      label399:
      if (parama.field_xmlType == 4)
      {
        this.xdm = ((ImageView)findViewById(2131303435));
        findViewById(2131303435).setVisibility(0);
        findViewById(2131303432).setVisibility(8);
        this.xdm.setImageResource(2131691126);
        this.xdm.setBackgroundResource(2131691126);
        this.titleTv.setText(2131762827);
        this.xdp.setText(null);
      }
    }
  }
  
  private static boolean arO(String paramString)
  {
    AppMethodBeat.i(51889);
    com.tencent.mm.ay.f localf = com.tencent.mm.ay.a.aGy();
    if ((localf != null) && (localf.hNQ == 5) && (paramString.equals(localf.hNS)) && (com.tencent.mm.ay.a.aGv()))
    {
      AppMethodBeat.o(51889);
      return true;
    }
    AppMethodBeat.o(51889);
    return false;
  }
  
  private static String arP(String paramString)
  {
    AppMethodBeat.i(51893);
    if (bs.isNullOrNil(paramString))
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
      ac.w("MicroMsg.scanner.ProductUI", paramString + ";" + localException.getLocalizedMessage());
      AppMethodBeat.o(51893);
    }
    return null;
  }
  
  private static boolean arQ(String paramString)
  {
    AppMethodBeat.i(51895);
    paramString = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(paramString);
    if ((paramString != null) && ((int)paramString.fLJ > 0) && (com.tencent.mm.n.b.ln(paramString.field_type)))
    {
      AppMethodBeat.o(51895);
      return true;
    }
    AppMethodBeat.o(51895);
    return false;
  }
  
  private void arR(String paramString)
  {
    AppMethodBeat.i(51896);
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putString("jsapi_args_appid", com.tencent.mm.plugin.scanner.model.m.MO(this.xdw));
    localIntent.putExtra("jsapiargs", localBundle);
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("pay_channel", 3);
    localIntent.putExtra("geta8key_scene", blB());
    com.tencent.mm.br.d.b(getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(51896);
  }
  
  private void b(k.a parama)
  {
    AppMethodBeat.i(51885);
    if ((parama == null) || (parama.xml == null) || (parama.xml.size() == 0) || (this.screen == null))
    {
      AppMethodBeat.o(51885);
      return;
    }
    this.screen.removeAll();
    int i = 0;
    while (i < parama.xml.size())
    {
      Object localObject2 = (com.tencent.mm.plugin.scanner.model.a)parama.xml.get(i);
      Object localObject1;
      Object localObject3;
      if ((localObject2 != null) && (((com.tencent.mm.plugin.scanner.model.a)localObject2).lio != null) && (((com.tencent.mm.plugin.scanner.model.a)localObject2).lio.size() != 0) && (((com.tencent.mm.plugin.scanner.model.a)localObject2).wYo != 1) && (((com.tencent.mm.plugin.scanner.model.a)localObject2).wYq))
      {
        if (i != 0)
        {
          localObject1 = new Preference(this);
          ((Preference)localObject1).setLayoutResource(2131495109);
          this.screen.b((Preference)localObject1);
        }
        if ((!bs.isNullOrNil(((com.tencent.mm.plugin.scanner.model.a)localObject2).title)) && ((((com.tencent.mm.plugin.scanner.model.a)localObject2).type == 6) || (((com.tencent.mm.plugin.scanner.model.a)localObject2).type == 7)))
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
        while (j < ((com.tencent.mm.plugin.scanner.model.a)localObject2).lio.size())
        {
          localObject3 = (a.a)((com.tencent.mm.plugin.scanner.model.a)localObject2).lio.get(j);
          if (((a.a)localObject3).type == 10) {
            ((List)localObject1).add(localObject3);
          }
          j += 1;
        }
        if (((List)localObject1).size() > 0)
        {
          localObject2 = new g(this);
          ((g)localObject2).setKey(i * 100);
          ((g)localObject2).vFV = ((List)localObject1);
          this.screen.b((Preference)localObject2);
        }
      }
      i += 1;
      continue;
      label353:
      int j = 0;
      label355:
      a.a locala;
      if (j < ((com.tencent.mm.plugin.scanner.model.a)localObject2).lio.size())
      {
        localObject3 = i * 100 + j;
        locala = (a.a)((com.tencent.mm.plugin.scanner.model.a)localObject2).lio.get(j);
        if (locala.type == 11)
        {
          this.xdD = true;
          this.xdE = locala.name;
        }
        if (locala.cZX != 2)
        {
          if (locala.cZX != 1) {
            break label509;
          }
          if (!bs.isNullOrNil(locala.image))
          {
            localObject1 = new b(this);
            ((b)localObject1).setKey((String)localObject3);
            ((b)localObject1).pdo = locala.image;
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
          ((MusicPreference)localObject1).wYs = locala.wYs;
          ((MusicPreference)localObject1).wYt = locala.wYt;
          ((MusicPreference)localObject1).wYu = locala.wYu;
          if (!arO(String.format("%s_cd_%s", new Object[] { locala.wYs, localObject3 })))
          {
            ((MusicPreference)localObject1).pY(false);
            ((MusicPreference)localObject1).xcS = this.xdK;
            this.screen.b((Preference)localObject1);
            com.tencent.mm.sdk.b.a.GpY.c(this.kce);
            if (this.veY == null) {
              this.veY = new ArrayList();
            }
            if (this.xdL) {
              this.veY.add(localObject1);
            }
          }
        }
        for (;;)
        {
          label610:
          if ((j >= ((com.tencent.mm.plugin.scanner.model.a)localObject2).lio.size() - 1) || (locala.type == 12) || (((a.a)((com.tencent.mm.plugin.scanner.model.a)localObject2).lio.get(j + 1)).type == 12) || (((a.a)((com.tencent.mm.plugin.scanner.model.a)localObject2).lio.get(j + 1)).cZX == 1) || (!d(j, ((com.tencent.mm.plugin.scanner.model.a)localObject2).lio))) {
            break label1185;
          }
          localObject1 = new f(this);
          this.screen.b((Preference)localObject1);
          break;
          ((MusicPreference)localObject1).pY(true);
          break label610;
          if (locala.type == 6)
          {
            localObject1 = new d(this);
            ((d)localObject1).setKey((String)localObject3);
            ((d)localObject1).mTitle = locala.name;
            ((d)localObject1).setSummary(locala.desc);
            this.screen.b((Preference)localObject1);
            ((d)localObject1).xcH = this.xdB;
          }
          else if (locala.type == 12)
          {
            localObject1 = new e(this);
            ((e)localObject1).setKey((String)localObject3);
            ((e)localObject1).pdo = locala.thumburl;
            ((e)localObject1).screen = this.screen;
            this.screen.b((Preference)localObject1);
          }
          else
          {
            if (locala.type == 2)
            {
              if (arQ(locala.username)) {}
              for (localObject1 = locala.wYA;; localObject1 = locala.wYz)
              {
                a locala1 = new a(this);
                locala1.setKey((String)localObject3);
                locala1.setTitle((CharSequence)localObject1);
                locala1.setSummary(locala.desc);
                locala1.xbk = locala.hlf;
                this.screen.b(locala1);
                break;
              }
            }
            if (locala.type == 22)
            {
              localObject1 = new c(this);
              ((c)localObject1).setKey((String)localObject3);
              if (!bs.isNullOrNil(locala.nickname)) {
                ((c)localObject1).ooX = (locala.nickname + ":");
              }
              ((c)localObject1).mContent = locala.content;
              ((c)localObject1).xcv = locala.thumburl;
              this.screen.b((Preference)localObject1);
            }
            else
            {
              localObject1 = new a(this);
              ((a)localObject1).setKey((String)localObject3);
              ((a)localObject1).setTitle(locala.name);
              ((a)localObject1).setSummary(locala.desc);
              ((a)localObject1).xbk = locala.hlf;
              ((a)localObject1).pbZ = locala.iconUrl;
              this.screen.b((Preference)localObject1);
            }
          }
        }
      }
    }
    this.screen.notifyDataSetChanged();
    ac.d("MicroMsg.scanner.ProductUI", "initBodyView finish");
    if (this.veY != null) {
      this.xdL = false;
    }
    AppMethodBeat.o(51885);
  }
  
  private void bR(int paramInt, String paramString)
  {
    AppMethodBeat.i(51890);
    if (this.xdu == null)
    {
      AppMethodBeat.o(51890);
      return;
    }
    paramString = new com.tencent.mm.plugin.scanner.model.k(this.xdu.field_productid, "", paramInt, paramString, 0, 0);
    com.tencent.mm.kernel.g.agi().a(paramString, 0);
    AppMethodBeat.o(51890);
  }
  
  private int blB()
  {
    if (this.xdw == 4) {
      return 11;
    }
    if (this.xdw == 3) {
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
        if (((a.a)paramLinkedList.get(paramInt)).cZX != 2)
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
  
  private void dAi()
  {
    AppMethodBeat.i(51882);
    this.xdx = getContext().getResources().getDimensionPixelSize(2131166695);
    if ((this.xdu != null) && ((this.xdu.field_type == 1) || (this.xdu.field_type == 2)))
    {
      this.xdx = getContext().getResources().getDimensionPixelSize(2131166696);
      Object localObject = this.xdn.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).height = this.xdx;
      this.xdn.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = this.xdo.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).height = this.xdx;
      this.xds.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (RelativeLayout)findViewById(2131303430);
      ViewGroup.LayoutParams localLayoutParams = ((RelativeLayout)localObject).getLayoutParams();
      localLayoutParams.height = this.xdx;
      ((RelativeLayout)localObject).setLayoutParams(localLayoutParams);
      localObject = this.xds.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).height = this.xdx;
      this.xds.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    AppMethodBeat.o(51882);
  }
  
  private void dAj()
  {
    AppMethodBeat.i(51884);
    this.msgId = getIntent().getLongExtra("key_ProductUI_chatting_msgId", 0L);
    if ((this.msgId > 0L) && (com.tencent.mm.kernel.g.agM()))
    {
      bo localbo = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().vP(this.msgId);
      if (localbo.field_msgId > 0L)
      {
        localbo.rf(this.xdy.aNl());
        ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().a(this.msgId, localbo);
      }
    }
    AppMethodBeat.o(51884);
  }
  
  private void dAk()
  {
    AppMethodBeat.i(51887);
    if ((this.xdu == null) || (this.xdu.xml == null) || (this.xdu.xml.size() == 0) || (this.screen == null))
    {
      AppMethodBeat.o(51887);
      return;
    }
    int i = 0;
    while (i < this.xdu.xml.size())
    {
      com.tencent.mm.plugin.scanner.model.a locala = (com.tencent.mm.plugin.scanner.model.a)this.xdu.xml.get(i);
      if ((locala != null) && (locala.lio != null) && (locala.lio.size() != 0))
      {
        int j = 0;
        if (j < locala.lio.size())
        {
          a.a locala1 = (a.a)locala.lio.get(j);
          MusicPreference localMusicPreference;
          if (locala1.type == 5)
          {
            String str = i * 100 + j;
            localMusicPreference = (MusicPreference)this.screen.aPN(str);
            if (localMusicPreference != null)
            {
              if (arO(String.format("%s_cd_%s", new Object[] { locala1.wYs, str }))) {
                break label221;
              }
              localMusicPreference.pY(false);
            }
          }
          for (;;)
          {
            j += 1;
            break;
            label221:
            localMusicPreference.pY(true);
          }
        }
      }
      i += 1;
    }
    this.screen.notifyDataSetChanged();
    AppMethodBeat.o(51887);
  }
  
  private int dAl()
  {
    if (this.xdw == 3) {
      return 47;
    }
    return 49;
  }
  
  private void dAm()
  {
    AppMethodBeat.i(51897);
    if (this.xdu != null)
    {
      ac.i("MicroMsg.scanner.ProductUI", "doUpdateActionLogic, flag=:" + this.xdu.field_getaction);
      if ((this.xdu.field_getaction & 0x2) > 0)
      {
        this.fmW = com.tencent.mm.modelgeo.d.aEL();
        if (this.fmW != null)
        {
          this.fmW.b(this.fnd);
          AppMethodBeat.o(51897);
        }
      }
      else if ((this.xdu.field_getaction & 0x1) > 0)
      {
        com.tencent.mm.plugin.scanner.model.f localf = new com.tencent.mm.plugin.scanner.model.f(this.pbW, com.tencent.mm.plugin.scanner.model.o.fh(this.xdu.xml), this.mScene, this.xdC, 0.0D, 0.0D);
        com.tencent.mm.kernel.g.agi().a(localf, 0);
      }
    }
    AppMethodBeat.o(51897);
  }
  
  private void dAn()
  {
    AppMethodBeat.i(51899);
    if (!com.tencent.mm.plugin.scanner.util.e.dBq())
    {
      ac.e("MicroMsg.scanner.ProductUI", "mHistoryItem ScanHistoryUtil.shouldShowHistoryList() is false!");
      AppMethodBeat.o(51899);
      return;
    }
    com.tencent.mm.plugin.scanner.history.a.a locala = new com.tencent.mm.plugin.scanner.history.a.a();
    locala.field_productId = this.pbW;
    if (!i.dza().dzb().get(locala, new String[0])) {}
    for (boolean bool = i.dza().dzb().insert(this.xdI); bool; bool = i.dza().dzb().update(this.xdI, new String[0]))
    {
      ac.i("MicroMsg.scanner.ProductUI", "mHistoryItem insert success!");
      this.xdG = true;
      AppMethodBeat.o(51899);
      return;
    }
    ac.e("MicroMsg.scanner.ProductUI", "mHistoryItem insert fail!");
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
    this.pbW = paramString1;
    this.xdC = paramString2;
    paramString1 = new com.tencent.mm.plugin.scanner.model.g(paramString1, this.mScene, paramString2);
    com.tencent.mm.kernel.g.agi().a(paramString1, 0);
    if (!paramBoolean)
    {
      paramString2 = getContext();
      getString(2131755906);
      this.fts = com.tencent.mm.ui.base.h.c(paramString2, getString(2131762836), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(51859);
          ac.d("MicroMsg.scanner.ProductUI", "User cancel");
          com.tencent.mm.kernel.g.agi().a(paramString1);
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
    this.xdn = ((ImageView)findViewById(2131303429));
    this.xdo = findViewById(2131303434);
    this.xdq = ((ImageView)findViewById(2131303424));
    this.xdv = findViewById(2131303420);
    this.xds = ((LinearLayout)findViewById(2131303433));
    this.xdt = ((ImageView)findViewById(2131303431));
    this.xdr = findViewById(2131303423);
    t(this.xdv, 0.0F);
    Object localObject;
    String str;
    if (com.tencent.mm.cc.a.id(getContext()))
    {
      this.titleTv.setTextSize(0, getContext().getResources().getDimensionPixelSize(2131165266) * com.tencent.mm.cc.a.hS(getContext()));
      this.xdp = ((TextView)findViewById(2131303422));
      this.iIc = ((TextView)findViewById(2131304328));
      this.xdA = new HashMap();
      this.xdB = new d.a()
      {
        public final void a(String paramAnonymousString, Boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(51863);
          if ((paramAnonymousString != null) && (paramAnonymousString.length() > 0)) {
            ProductUI.k(ProductUI.this).put(paramAnonymousString, paramAnonymousBoolean);
          }
          AppMethodBeat.o(51863);
        }
        
        public final Boolean arM(String paramAnonymousString)
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
        
        public final void dAh()
        {
          AppMethodBeat.i(51865);
          if (ProductUI.this.screen != null) {
            ProductUI.this.screen.notifyDataSetChanged();
          }
          AppMethodBeat.o(51865);
        }
      };
      this.xdI = new com.tencent.mm.plugin.scanner.history.a.a();
      this.xdI.field_ScanTime = System.currentTimeMillis();
      this.xdI.field_scene = this.mScene;
      if (this.mScene != 5) {
        break label428;
      }
      this.xdF = true;
      localObject = getIntent().getStringExtra("key_Qrcode_Url");
      str = arP((String)localObject);
      this.xdI.field_qrcodeUrl = ((String)localObject);
      this.xdI.field_productId = str;
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
      this.xdr.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(51868);
          if ((ProductUI.a(ProductUI.this) != null) && (!bs.isNullOrNil(ProductUI.a(ProductUI.this).field_certificationurl)))
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
      this.titleTv.setTextSize(0, com.tencent.mm.cc.a.au(getContext(), 2131165266));
      break;
      label428:
      if (this.mScene == 4)
      {
        localObject = getIntent().getStringExtra("key_product_id");
        str = getIntent().getStringExtra("key_Qrcode_Url");
        if (!bs.isNullOrNil((String)localObject))
        {
          u((String)localObject, str, false);
        }
        else
        {
          ac.e("MicroMsg.scanner.ProductUI", "jsapi jump finish productId null");
          finish();
          AppMethodBeat.o(51881);
        }
      }
      else
      {
        this.xdH = getIntent().getBooleanExtra("key_is_from_barcode", false);
        this.xdF = getIntent().getBooleanExtra("key_need_add_to_history", false);
        localObject = getIntent().getStringExtra("key_Product_xml");
        if (!bs.isNullOrNil((String)localObject))
        {
          int i = getIntent().getIntExtra("key_Product_funcType", 0);
          this.xdu = com.tencent.mm.plugin.scanner.model.m.ev((String)localObject, i);
          if (this.xdu == null)
          {
            ac.e("MicroMsg.scanner.ProductUI", "initView(), product == null");
            finish();
            AppMethodBeat.o(51881);
            return;
          }
          this.pbW = this.xdu.field_productid;
          this.xdC = this.xdu.field_extinfo;
          if ((this.xdF) && (!TextUtils.isEmpty(this.pbW)))
          {
            this.xdI.field_xmlContent = ((String)localObject);
            this.xdI.field_qrcodeUrl = this.xdC;
            this.xdI.field_productId = this.pbW;
            this.xdI.field_funcType = i;
            dAn();
          }
          for (;;)
          {
            localObject = this.xdu;
            getIntent().getBooleanExtra("key_ProductUI_addToDB", true);
            a((k.a)localObject);
            if ((i != 0) || (bs.isNullOrNil(this.xdu.field_productid))) {
              break label772;
            }
            u(this.xdu.field_productid, this.xdu.field_extinfo, true);
            break;
            ac.i("MicroMsg.scanner.ProductUI", "shouldAddToHistory:" + this.xdF + " mProductId:" + this.pbW);
          }
          dAm();
        }
        else
        {
          localObject = getIntent().getStringExtra("key_Product_ID");
          if (bs.isNullOrNil((String)localObject)) {
            break label807;
          }
          u((String)localObject, null, false);
        }
      }
    }
    label807:
    ac.e("MicroMsg.scanner.ProductUI", "normal finish productId null");
    finish();
    AppMethodBeat.o(51881);
  }
  
  public final void k(final String paramString, final Bitmap paramBitmap)
  {
    AppMethodBeat.i(51891);
    if ((!bs.isNullOrNil(paramString)) && (this.xdu != null) && (paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      ac.d("MicroMsg.scanner.ProductUI", "onGetPictureFinish: notifyKey=".concat(String.valueOf(paramString)));
      ap.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(51858);
          if ((paramString.equals(ProductUI.a(ProductUI.this).field_thumburl)) && (ProductUI.s(ProductUI.this) != null)) {
            ac.i("MicroMsg.scanner.ProductUI", "onGetPictureFinish: notifyKey=" + paramString);
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
              ac.e("MicroMsg.scanner.ProductUI", "onGetPictureFinish : [%s]", new Object[] { localException.getLocalizedMessage() });
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
    this.mStartTime = bs.aNx();
    this.mScene = getIntent().getIntExtra("key_ProductUI_getProductInfoScene", 0);
    u.b(this);
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().a("scanproductinfo", this.xdJ, true);
    initView();
    AppMethodBeat.o(51877);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(51880);
    u.c(this);
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().b("scanproductinfo", this.xdJ, true);
    com.tencent.mm.sdk.b.a.GpY.d(this.kce);
    if (this.fmW != null) {
      this.fmW.c(this.fnd);
    }
    bR(10100, bs.aNx() - this.mStartTime);
    super.onDestroy();
    AppMethodBeat.o(51880);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(51879);
    com.tencent.mm.kernel.g.agi().b(1063, this);
    com.tencent.mm.kernel.g.agi().b(1068, this);
    super.onPause();
    AppMethodBeat.o(51879);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(51888);
    ac.i("MicroMsg.scanner.ProductUI", "onPreferenceTreeClick item: [%s]", new Object[] { paramPreference.mKey });
    if ((this.xdu == null) || (this.xdu.xml == null))
    {
      ac.e("MicroMsg.scanner.ProductUI", "product == null || product.actionlist == null");
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
        ac.v("MicroMsg.scanner.ProductUI", "keyId=[%s], ii=[%s], jj=[%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
        if ((j < 0) || (j >= this.xdu.xml.size()))
        {
          ac.w("MicroMsg.scanner.ProductUI", "index out of bounds, ii=[%s], list Size=[%s]", new Object[] { Integer.valueOf(j), Integer.valueOf(this.xdu.xml.size()) });
          AppMethodBeat.o(51888);
          return false;
        }
        locala = (com.tencent.mm.plugin.scanner.model.a)this.xdu.xml.get(j);
        if (locala == null)
        {
          ac.w("MicroMsg.scanner.ProductUI", "actionList == null");
          AppMethodBeat.o(51888);
          return false;
        }
        if ((k < 0) || (k >= locala.lio.size()))
        {
          ac.w("MicroMsg.scanner.ProductUI", "index out of bounds, jj=[%s], actions Size=[%s]", new Object[] { Integer.valueOf(k), Integer.valueOf(locala.lio.size()) });
          AppMethodBeat.o(51888);
          return false;
        }
        locala1 = (a.a)locala.lio.get(k);
        if (locala1 == null)
        {
          ac.w("MicroMsg.scanner.ProductUI", "action == null");
          AppMethodBeat.o(51888);
          return false;
        }
        ac.i("MicroMsg.scanner.ProductUI", "action.type = [%s]", new Object[] { Integer.valueOf(locala1.type) });
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
          ac.d("MicroMsg.scanner.ProductUI", "Default go url:" + locala1.link);
          if (bs.isNullOrNil(locala1.link)) {
            break label1271;
          }
          arR(locala1.link);
        }
      }
      catch (Exception paramf)
      {
        com.tencent.mm.plugin.scanner.model.a locala;
        ac.e("MicroMsg.scanner.ProductUI", "onPreferenceTreeClick, [%s]", new Object[] { paramf.getMessage() });
        ac.printErrStackTrace("MicroMsg.scanner.ProductUI", paramf, "", new Object[0]);
        AppMethodBeat.o(51888);
        return false;
      }
      paramf = new com.tencent.mm.plugin.scanner.model.k(this.xdu.field_productid, locala1.wYv, locala1.type, paramf, locala.lio.size(), locala1.cZX);
      com.tencent.mm.kernel.g.agi().a(paramf, 0);
      AppMethodBeat.o(51888);
      return true;
      paramPreference = locala1.link;
      paramf = paramPreference;
      if (!bs.isNullOrNil(locala1.link))
      {
        arR(locala1.link);
        paramf = paramPreference;
        continue;
        paramPreference = locala1.username;
        paramf = paramPreference;
        if (!bs.isNullOrNil(locala1.username))
        {
          paramf = locala1.username;
          if (arQ(paramf))
          {
            localIntent = new Intent();
            localIntent.putExtra("Chat_User", paramf);
            localIntent.putExtra("finish_direct", true);
            localIntent.putExtra("add_scene", dAl());
            com.tencent.mm.plugin.scanner.g.iyx.d(localIntent, getContext());
            paramf = paramPreference;
          }
          else if (TextUtils.isEmpty(paramf))
          {
            ac.v("MicroMsg.scanner.ProductUI", "username is null");
            paramf = paramPreference;
          }
          else
          {
            localIntent = new Intent();
            localIntent.putExtra("Contact_User", paramf);
            localIntent.putExtra("force_get_contact", true);
            localIntent.putExtra("Contact_Scene", dAl());
            com.tencent.mm.plugin.scanner.g.iyx.c(localIntent, this);
            paramf = paramPreference;
            continue;
            paramf = locala1.wYu;
            localIntent.putExtra("rawUrl", locala1.wYu);
            localIntent.putExtra("geta8key_scene", blB());
            com.tencent.mm.plugin.scanner.g.iyx.i(localIntent, this);
            com.tencent.mm.ay.a.aGt();
            dAk();
            continue;
            paramPreference = locala1.wYw;
            paramf = paramPreference;
            if (!bs.isNullOrNil(locala1.wYw))
            {
              localIntent.putExtra("key_product_id", locala1.wYw);
              localIntent.putExtra("key_product_scene", 12);
              com.tencent.mm.br.d.b(this, "product", ".ui.MallProductUI", localIntent);
              paramf = paramPreference;
              continue;
              paramf = locala1.wYw;
              localIntent.putExtra("key_card_id", locala1.wYy);
              localIntent.putExtra("key_card_ext", locala1.wYx);
              localIntent.putExtra("key_from_scene", 9);
              com.tencent.mm.br.d.b(this, "card", ".ui.CardDetailUI", localIntent);
              continue;
              localIntent.setClass(this, ProductFurtherInfoUI.class);
              localIntent.putExtra("key_Product_xml", this.xdu.field_xml);
              localIntent.putExtra("key_title", locala1.name);
              paramf = new com.tencent.mm.hellhoundlib.b.a().ba(localIntent);
              com.tencent.mm.hellhoundlib.a.a.a(this, paramf.aeD(), "com/tencent/mm/plugin/scanner/ui/ProductUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              startActivity((Intent)paramf.lR(0));
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/ProductUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramf = null;
              continue;
              paramf = locala1.wYp;
              localIntent.setClass(this, ProductPurchaseAreaUI.class);
              localIntent.putExtra("key_Product_xml", this.xdu.field_xml);
              localIntent.putExtra("referkey", locala1.wYp);
              localIntent.putExtra("key_Product_funcType", this.xdw);
              paramPreference = new com.tencent.mm.hellhoundlib.b.a().ba(localIntent);
              com.tencent.mm.hellhoundlib.a.a.a(this, paramPreference.aeD(), "com/tencent/mm/plugin/scanner/ui/ProductUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              startActivity((Intent)paramPreference.lR(0));
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/ProductUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              continue;
              paramPreference = locala1.link;
              paramf = paramPreference;
              if (!bs.isNullOrNil(locala1.link))
              {
                arR(locala1.link);
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
    com.tencent.mm.kernel.g.agi().a(1063, this);
    com.tencent.mm.kernel.g.agi().a(1068, this);
    AppMethodBeat.o(51878);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(51892);
    if (paramn == null)
    {
      ac.w("MicroMsg.scanner.ProductUI", "scene == null");
      AppMethodBeat.o(51892);
      return;
    }
    if (paramn.getType() == 1063)
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ac.e("MicroMsg.scanner.ProductUI", "onSceneEnd() errType = [%s], errCode = [%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        AppMethodBeat.o(51892);
        return;
      }
      paramString = (com.tencent.mm.plugin.scanner.model.g)paramn;
      if ((paramString.rr != null) && (paramString.rr.hvs.hvw != null)) {}
      for (paramString = (mz)paramString.rr.hvs.hvw; paramString == null; paramString = null)
      {
        ac.w("MicroMsg.scanner.ProductUI", "onSceneEnd productInfo == null");
        AppMethodBeat.o(51892);
        return;
      }
      if (paramString.Eci != null)
      {
        ac.d("MicroMsg.scanner.ProductUI", "onSceneEnd  productInfo.DescXML != null");
        paramn = com.tencent.mm.plugin.scanner.model.m.ev(paramString.Eci, this.xdw);
        if ((this.xdu != null) && (this.xdu.field_xml != null) && (paramn != null) && (paramn.field_xml != null) && (!this.xdu.field_xml.equals(paramn.field_xml)))
        {
          this.xdu = paramn;
          a(this.xdu);
        }
        for (;;)
        {
          if ((this.fts != null) && (this.fts.isShowing())) {
            this.fts.dismiss();
          }
          dAm();
          if ((!this.xdF) || (this.xdG) || (TextUtils.isEmpty(this.pbW))) {
            break;
          }
          this.xdI.field_xmlContent = paramString.Eci;
          this.xdI.field_funcType = this.xdw;
          dAn();
          AppMethodBeat.o(51892);
          return;
          if ((paramn != null) && (paramn.field_xml != null))
          {
            this.xdu = paramn;
            a(this.xdu);
          }
        }
        ac.i("MicroMsg.scanner.ProductUI", "shouldAddToHistory:" + this.xdF + " mProductId:" + this.pbW + "  hasAddToHistory:" + this.xdG);
      }
      AppMethodBeat.o(51892);
      return;
    }
    if ((paramn.getType() == 1068) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = ((mx)((com.tencent.mm.plugin.scanner.model.f)paramn).rr.hvs.hvw).Ech;
      if ((this.xdu != null) && (com.tencent.mm.plugin.scanner.model.o.b(this.xdu.xml, com.tencent.mm.plugin.scanner.model.o.fi(paramString)))) {
        b(this.xdu);
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
    int afO;
    ProductScrollView xdS;
    boolean xdT;
    private ProductScrollView.a xdU;
    
    public b()
    {
      AppMethodBeat.i(51875);
      this.xdU = new ProductScrollView.a()
      {
        public final void chO()
        {
          float f3 = 1.0F;
          AppMethodBeat.i(51874);
          ProductUI.b localb = ProductUI.b.this;
          int i = localb.xdS.getScrollY();
          float f1;
          label65:
          float f2;
          if (i < 0)
          {
            f1 = -1.0F;
            ac.v("MicroMsg.ProductUI.HeaderEffectHelper", "rate=".concat(String.valueOf(f1)));
            if (f1 != 1.0F) {
              break label211;
            }
            if (!localb.xdT)
            {
              localb.xdT = true;
              if (ProductUI.x(localb.xdM) != null)
              {
                float f4 = 1.0F - f1 - 0.2F;
                f2 = f4;
                if (f4 <= 0.0F) {
                  f2 = 0.0F;
                }
                if (f1 == 0.0F) {
                  f2 = 1.0F;
                }
                ProductUI.u(ProductUI.x(localb.xdM), f2);
              }
              if (ProductUI.y(localb.xdM) != null)
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
            ProductUI.u(ProductUI.y(localb.xdM), f2);
            AppMethodBeat.o(51874);
            return;
            if ((i >= ProductUI.z(localb.xdM) - localb.afO) || (ProductUI.z(localb.xdM) == 0.0F))
            {
              f1 = 1.0F;
              break;
            }
            f1 = i * 1.37F / ProductUI.z(localb.xdM);
            break;
            label211:
            localb.xdT = false;
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
      this.xdS = ((ProductScrollView)ProductUI.this.findViewById(2131303539));
      this.xdS.setOnScrollListener(this.xdU);
      this.afO = ProductUI.w(ProductUI.this);
      AppMethodBeat.o(51875);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ProductUI
 * JD-Core Version:    0.7.0.1
 */