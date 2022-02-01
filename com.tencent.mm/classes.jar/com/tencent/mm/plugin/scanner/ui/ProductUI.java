package com.tencent.mm.plugin.scanner.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
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
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.h.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.mx;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.cj;
import com.tencent.mm.model.cj.a;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.platformtools.s.a;
import com.tencent.mm.platformtools.s.b;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.scanner.j;
import com.tencent.mm.plugin.scanner.model.k;
import com.tencent.mm.plugin.scanner.model.p;
import com.tencent.mm.plugin.scanner.model.r;
import com.tencent.mm.plugin.scanner.util.n;
import com.tencent.mm.plugin.scanner.util.n.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.protocal.protobuf.om;
import com.tencent.mm.protocal.protobuf.oo;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.h.e;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ProductUI
  extends MMPreference
  implements com.tencent.mm.ak.i, u.a
{
  private List<MusicPreference> AjG;
  private ImageView CLc;
  private View CLd;
  private TextView CLe;
  private ImageView CLf;
  private View CLg;
  private LinearLayout CLh;
  private ImageView CLi;
  private n.a CLj;
  private View CLk;
  private int CLl;
  private int CLm;
  private a CLn;
  private boolean CLo;
  private HashMap<String, Boolean> CLp;
  private d.a CLq;
  private String CLr;
  private boolean CLs;
  private String CLt;
  private boolean CLu;
  private boolean CLv;
  private com.tencent.mm.plugin.scanner.history.a.a CLw;
  private cj.a CLx;
  private MusicPreference.a CLy;
  private boolean CLz;
  private com.tencent.mm.modelgeo.b.a gmA;
  private com.tencent.mm.modelgeo.d gmt;
  protected ProgressDialog gtM;
  private boolean iOy;
  private TextView kch;
  private IListener lEl;
  private int mScene;
  private long mStartTime;
  private long msgId;
  private String rcD;
  protected com.tencent.mm.ui.base.preference.f screen;
  private TextView titleTv;
  private ImageView uBJ;
  private boolean uOU;
  private boolean uSu;
  
  public ProductUI()
  {
    AppMethodBeat.i(51876);
    this.CLl = 0;
    this.gtM = null;
    this.CLo = false;
    this.CLs = false;
    this.CLu = false;
    this.uOU = false;
    this.CLv = false;
    this.iOy = false;
    this.gmA = new com.tencent.mm.modelgeo.b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(51851);
        if (paramAnonymousBoolean)
        {
          Log.i("MicroMsg.scanner.ProductUI", "getLocation suc");
          if (ProductUI.a(ProductUI.this) != null)
          {
            Log.i("MicroMsg.scanner.ProductUI", "do getActionInfoScene, lng=" + paramAnonymousFloat1 + ", lat=" + paramAnonymousFloat2);
            k localk = new k(ProductUI.b(ProductUI.this), com.tencent.mm.plugin.scanner.model.t.gA(ProductUI.a(ProductUI.this).CUx), ProductUI.c(ProductUI.this), ProductUI.d(ProductUI.this), paramAnonymousFloat1, paramAnonymousFloat2);
            com.tencent.mm.kernel.g.azz().a(localk, 0);
          }
          if (ProductUI.e(ProductUI.this) != null) {
            ProductUI.e(ProductUI.this).c(ProductUI.f(ProductUI.this));
          }
          if (!ProductUI.g(ProductUI.this))
          {
            ProductUI.h(ProductUI.this);
            o.a(2011, paramAnonymousFloat1, paramAnonymousFloat2, (int)paramAnonymousDouble2);
          }
          AppMethodBeat.o(51851);
          return false;
        }
        if ((!ProductUI.i(ProductUI.this)) && (!com.tencent.mm.modelgeo.d.bcc()))
        {
          ProductUI.j(ProductUI.this);
          com.tencent.mm.ui.base.h.a(ProductUI.this, ProductUI.this.getString(2131761461), ProductUI.this.getString(2131755998), ProductUI.this.getString(2131762043), ProductUI.this.getString(2131755761), false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(51850);
              com.tencent.mm.modelgeo.d.cZ(ProductUI.this);
              AppMethodBeat.o(51850);
            }
          }, null);
        }
        Log.w("MicroMsg.scanner.ProductUI", "getLocation fail");
        AppMethodBeat.o(51851);
        return false;
      }
    };
    this.CLx = new cj.a()
    {
      public final void a(h.a paramAnonymousa)
      {
        AppMethodBeat.i(51861);
        Object localObject1 = z.a(paramAnonymousa.heO.KHn);
        Log.i("MicroMsg.scanner.ProductUI", "lo-scanner-onRecieveMsg");
        paramAnonymousa = ProductUI.a(ProductUI.this);
        Object localObject2;
        if ((paramAnonymousa != null) && (!Util.isNullOrNil((String)localObject1)))
        {
          localObject1 = XmlParser.parseXml((String)localObject1, "sysmsg", null);
          localObject2 = (String)((Map)localObject1).get(".sysmsg.scanproductinfo.product.id");
          if ((!Util.isNullOrNil(paramAnonymousa.field_productid)) && (paramAnonymousa.field_productid.equals(localObject2))) {
            break label144;
          }
          Log.i("MicroMsg.ProductUpdateLogic", "lo-scanner-doUpdateActionLogicByNewXml: product id not match, productId=" + Util.nullAsNil((String)localObject2) + ", target=" + paramAnonymousa.field_productid);
        }
        for (;;)
        {
          MMHandlerThread.postToMainThread(new Runnable()
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
          label144:
          localObject1 = com.tencent.mm.plugin.scanner.model.b.o((Map)localObject1, ".sysmsg.scanproductinfo.product");
          localObject2 = new HashMap();
          int i = 0;
          while (i < ((List)localObject1).size())
          {
            LinkedList localLinkedList = ((com.tencent.mm.plugin.scanner.model.b)((List)localObject1).get(i)).mRG;
            if (localLinkedList != null)
            {
              int j = 0;
              while (j < localLinkedList.size())
              {
                com.tencent.mm.plugin.scanner.model.b.a locala = (com.tencent.mm.plugin.scanner.model.b.a)localLinkedList.get(j);
                if (locala != null) {
                  ((Map)localObject2).put(locala.key, locala);
                }
                j += 1;
              }
            }
            i += 1;
          }
          Log.i("MicroMsg.ProductUpdateLogic", "lo-scanner-doUpdateActionLogicByNewXml: toUpdateSize=" + ((Map)localObject2).size());
          com.tencent.mm.plugin.scanner.model.t.b(paramAnonymousa.CUx, (Map)localObject2);
        }
      }
      
      public final void a(h.c paramAnonymousc) {}
    };
    this.CLy = new MusicPreference.a()
    {
      public final void d(MusicPreference paramAnonymousMusicPreference)
      {
        AppMethodBeat.i(51854);
        if (paramAnonymousMusicPreference == null)
        {
          Log.e("MicroMsg.scanner.ProductUI", "onMusicPrefClick, musicPref == null");
          AppMethodBeat.o(51854);
          return;
        }
        if ((Util.isNullOrNil(paramAnonymousMusicPreference.CEJ)) && (Util.isNullOrNil(paramAnonymousMusicPreference.CEK)))
        {
          Log.w("MicroMsg.scanner.ProductUI", "wifiurl = null,  wapurl = null");
          if (!Util.isNullOrNil(paramAnonymousMusicPreference.CEL)) {
            ProductUI.a(ProductUI.this, paramAnonymousMusicPreference.CEL);
          }
          AppMethodBeat.o(51854);
          return;
        }
        String str1 = String.format("%s_cd_%s", new Object[] { paramAnonymousMusicPreference.CEJ, paramAnonymousMusicPreference.mKey });
        int j;
        ArrayList localArrayList;
        int i;
        label193:
        MusicPreference localMusicPreference;
        String str2;
        if (!ProductUI.aMN(str1))
        {
          if (paramAnonymousMusicPreference.getTitle() == null)
          {
            Log.e("MicroMsg.scanner.ProductUI", "onPlayBtnClick, getTitle() == null");
            AppMethodBeat.o(51854);
            return;
          }
          j = -1;
          if (ProductUI.o(ProductUI.this) == null)
          {
            str1 = null;
            paramAnonymousMusicPreference = String.format("%s_cd_%s", new Object[] { paramAnonymousMusicPreference.CEJ, paramAnonymousMusicPreference.mKey });
            localArrayList = new ArrayList();
            Iterator localIterator = ProductUI.p(ProductUI.this).iterator();
            i = 0;
            if (!localIterator.hasNext()) {
              break label330;
            }
            localMusicPreference = (MusicPreference)localIterator.next();
            str2 = String.format("%s_cd_%s", new Object[] { localMusicPreference.CEJ, localMusicPreference.mKey });
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
          localArrayList.add(com.tencent.mm.ay.g.a(5, str1, localMusicPreference.getTitle().toString(), "", localMusicPreference.CEL, localMusicPreference.CEK, localMusicPreference.CEJ, str2, com.tencent.mm.kernel.g.aAh().hqG, str1, "", "wx482a4001c37e2b74"));
          i += 1;
          break label193;
          str1 = ProductUI.o(ProductUI.this).blA();
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
            com.tencent.mm.ay.a.bea();
            Log.d("MicroMsg.scanner.ProductUI", "isTheSameId, playMusicId : [%s]", new Object[] { str1 });
          }
        }
      }
    };
    this.CLz = true;
    this.lEl = new IListener() {};
    AppMethodBeat.o(51876);
  }
  
  private void a(final n.a parama)
  {
    AppMethodBeat.i(51883);
    if (parama == null)
    {
      Log.e("MicroMsg.scanner.ProductUI", "refreshViewByProduct(), pd == null");
      finish();
      AppMethodBeat.o(51883);
      return;
    }
    if (!Util.isNullOrNil(parama.field_thumburl)) {
      this.CLn = new a(parama);
    }
    eQJ();
    if ((!Util.isNullOrNil(parama.field_introtitle)) && (!Util.isNullOrNil(parama.field_introlink)))
    {
      this.kch.setText(parama.field_introtitle);
      this.kch.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(51869);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ProductUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          ProductUI.a(ProductUI.this, 10003, parama.field_introlink);
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("rawUrl", parama.field_introlink);
          paramAnonymousView.putExtra("geta8key_scene", ProductUI.m(ProductUI.this));
          com.tencent.mm.br.c.b(ProductUI.this.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/ProductUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(51869);
        }
      });
      this.kch.setVisibility(0);
      this.CLl = this.CLj.field_functionType;
      if (parama.field_xmlType != 3) {
        break label399;
      }
      this.titleTv.setText(parama.field_title);
      if (Util.isNullOrNil(parama.field_certification)) {
        break label312;
      }
      this.CLe.setText(parama.field_certification);
      this.CLf.setVisibility(0);
      label166:
      if ((parama.field_type != 1) && (parama.field_type != 2)) {
        break label359;
      }
      this.uBJ = ((ImageView)findViewById(2131306163));
      findViewById(2131306163).setVisibility(0);
      findViewById(2131306166).setVisibility(8);
      label219:
      if (!Util.isNullOrNil(parama.field_playurl))
      {
        ImageView localImageView = (ImageView)findViewById(2131306159);
        localImageView.setVisibility(0);
        localImageView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(51870);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ProductUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
            localObject = new Intent("android.intent.action.VIEW");
            FileProviderHelper.setIntentDataAndType(ProductUI.this.getContext(), (Intent)localObject, Uri.parse(parama.field_playurl), "video/*", false);
            paramAnonymousView = ProductUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/scanner/ui/ProductUI$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/scanner/ui/ProductUI$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/ProductUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(51870);
          }
        });
      }
      addIconOptionMenu(0, 2131690843, new MenuItem.OnMenuItemClickListener()
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
      Log.v("MicroMsg.scanner.ProductUI", "start postToMainThread initBodyView");
      MMHandlerThread.postToMainThread(new Runnable()
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
      this.kch.setVisibility(8);
      break;
      label312:
      this.CLe.setText(parama.field_source);
      this.CLf.setVisibility(8);
      this.CLg.setOnClickListener(null);
      this.CLg.setBackgroundDrawable(null);
      this.CLg.setFocusable(false);
      break label166;
      label359:
      this.uBJ = ((ImageView)findViewById(2131306166));
      findViewById(2131306166).setVisibility(0);
      findViewById(2131306163).setVisibility(8);
      break label219;
      label399:
      if (parama.field_xmlType == 4)
      {
        this.uBJ = ((ImageView)findViewById(2131306166));
        findViewById(2131306166).setVisibility(0);
        findViewById(2131306163).setVisibility(8);
        this.uBJ.setImageResource(2131691434);
        this.uBJ.setBackgroundResource(2131691434);
        this.titleTv.setText(2131764934);
        this.CLe.setText(null);
      }
    }
  }
  
  private static boolean aMJ(String paramString)
  {
    AppMethodBeat.i(51889);
    com.tencent.mm.ay.f localf = com.tencent.mm.ay.a.bef();
    if ((localf != null) && (localf.jeT == 5) && (paramString.equals(localf.jeV)) && (com.tencent.mm.ay.a.bec()))
    {
      AppMethodBeat.o(51889);
      return true;
    }
    AppMethodBeat.o(51889);
    return false;
  }
  
  private static String aMK(String paramString)
  {
    AppMethodBeat.i(51893);
    if (Util.isNullOrNil(paramString))
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
      Log.w("MicroMsg.scanner.ProductUI", paramString + ";" + localException.getLocalizedMessage());
      AppMethodBeat.o(51893);
    }
    return null;
  }
  
  private static boolean aML(String paramString)
  {
    AppMethodBeat.i(51895);
    paramString = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramString);
    if ((paramString != null) && ((int)paramString.gMZ > 0) && (com.tencent.mm.contact.c.oR(paramString.field_type)))
    {
      AppMethodBeat.o(51895);
      return true;
    }
    AppMethodBeat.o(51895);
    return false;
  }
  
  private void aMM(String paramString)
  {
    AppMethodBeat.i(51896);
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putString("jsapi_args_appid", r.Wu(this.CLl));
    localIntent.putExtra("jsapiargs", localBundle);
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("pay_channel", 3);
    localIntent.putExtra("geta8key_scene", bLC());
    com.tencent.mm.br.c.b(getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(51896);
  }
  
  private void b(n.a parama)
  {
    AppMethodBeat.i(51885);
    if ((parama == null) || (parama.CUx == null) || (parama.CUx.size() == 0) || (this.screen == null))
    {
      AppMethodBeat.o(51885);
      return;
    }
    this.screen.removeAll();
    int i = 0;
    while (i < parama.CUx.size())
    {
      Object localObject2 = (com.tencent.mm.plugin.scanner.model.b)parama.CUx.get(i);
      Object localObject1;
      Object localObject3;
      if ((localObject2 != null) && (((com.tencent.mm.plugin.scanner.model.b)localObject2).mRG != null) && (((com.tencent.mm.plugin.scanner.model.b)localObject2).mRG.size() != 0) && (((com.tencent.mm.plugin.scanner.model.b)localObject2).CEF != 1) && (((com.tencent.mm.plugin.scanner.model.b)localObject2).CEH))
      {
        if (i != 0)
        {
          localObject1 = new Preference(this);
          ((Preference)localObject1).setLayoutResource(2131495952);
          this.screen.c((Preference)localObject1);
        }
        if ((!Util.isNullOrNil(((com.tencent.mm.plugin.scanner.model.b)localObject2).title)) && ((((com.tencent.mm.plugin.scanner.model.b)localObject2).type == 6) || (((com.tencent.mm.plugin.scanner.model.b)localObject2).type == 7)))
        {
          localObject1 = new CategoryWithTitlePreference(this);
          ((CategoryWithTitlePreference)localObject1).setTitle(((com.tencent.mm.plugin.scanner.model.b)localObject2).title);
          this.screen.c((Preference)localObject1);
        }
        if (((com.tencent.mm.plugin.scanner.model.b)localObject2).type != 6) {
          break label353;
        }
        localObject1 = new ArrayList();
        j = 0;
        while (j < ((com.tencent.mm.plugin.scanner.model.b)localObject2).mRG.size())
        {
          localObject3 = (com.tencent.mm.plugin.scanner.model.b.a)((com.tencent.mm.plugin.scanner.model.b)localObject2).mRG.get(j);
          if (((com.tencent.mm.plugin.scanner.model.b.a)localObject3).type == 10) {
            ((List)localObject1).add(localObject3);
          }
          j += 1;
        }
        if (((List)localObject1).size() > 0)
        {
          localObject2 = new g(this);
          ((g)localObject2).setKey(i * 100);
          ((g)localObject2).Bar = ((List)localObject1);
          this.screen.c((Preference)localObject2);
        }
      }
      i += 1;
      continue;
      label353:
      int j = 0;
      label355:
      com.tencent.mm.plugin.scanner.model.b.a locala;
      if (j < ((com.tencent.mm.plugin.scanner.model.b)localObject2).mRG.size())
      {
        localObject3 = i * 100 + j;
        locala = (com.tencent.mm.plugin.scanner.model.b.a)((com.tencent.mm.plugin.scanner.model.b)localObject2).mRG.get(j);
        if (locala.type == 11)
        {
          this.CLs = true;
          this.CLt = locala.name;
        }
        if (locala.dDG != 2)
        {
          if (locala.dDG != 1) {
            break label509;
          }
          if (!Util.isNullOrNil(locala.image))
          {
            localObject1 = new b(this);
            ((b)localObject1).setKey((String)localObject3);
            ((b)localObject1).CJf = locala.image;
            ((b)localObject1).screen = this.screen;
            this.screen.c((Preference)localObject1);
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
          ((MusicPreference)localObject1).CEJ = locala.CEJ;
          ((MusicPreference)localObject1).CEK = locala.CEK;
          ((MusicPreference)localObject1).CEL = locala.CEL;
          if (!aMJ(String.format("%s_cd_%s", new Object[] { locala.CEJ, localObject3 })))
          {
            ((MusicPreference)localObject1).tV(false);
            ((MusicPreference)localObject1).CKI = this.CLy;
            this.screen.c((Preference)localObject1);
            EventCenter.instance.addListener(this.lEl);
            if (this.AjG == null) {
              this.AjG = new ArrayList();
            }
            if (this.CLz) {
              this.AjG.add(localObject1);
            }
          }
        }
        for (;;)
        {
          label610:
          if ((j >= ((com.tencent.mm.plugin.scanner.model.b)localObject2).mRG.size() - 1) || (locala.type == 12) || (((com.tencent.mm.plugin.scanner.model.b.a)((com.tencent.mm.plugin.scanner.model.b)localObject2).mRG.get(j + 1)).type == 12) || (((com.tencent.mm.plugin.scanner.model.b.a)((com.tencent.mm.plugin.scanner.model.b)localObject2).mRG.get(j + 1)).dDG == 1) || (!e(j, ((com.tencent.mm.plugin.scanner.model.b)localObject2).mRG))) {
            break label1185;
          }
          localObject1 = new f(this);
          this.screen.c((Preference)localObject1);
          break;
          ((MusicPreference)localObject1).tV(true);
          break label610;
          if (locala.type == 6)
          {
            localObject1 = new d(this);
            ((d)localObject1).setKey((String)localObject3);
            ((d)localObject1).mTitle = locala.name;
            ((d)localObject1).setSummary(locala.desc);
            this.screen.c((Preference)localObject1);
            ((d)localObject1).CKx = this.CLq;
          }
          else if (locala.type == 12)
          {
            localObject1 = new e(this);
            ((e)localObject1).setKey((String)localObject3);
            ((e)localObject1).CJf = locala.thumburl;
            ((e)localObject1).screen = this.screen;
            this.screen.c((Preference)localObject1);
          }
          else
          {
            if (locala.type == 2)
            {
              if (aML(locala.username)) {}
              for (localObject1 = locala.CER;; localObject1 = locala.CEQ)
              {
                a locala1 = new a(this);
                locala1.setKey((String)localObject3);
                locala1.setTitle((CharSequence)localObject1);
                locala1.setSummary(locala.desc);
                locala1.CJc = locala.iAq;
                this.screen.c(locala1);
                break;
              }
            }
            if (locala.type == 22)
            {
              localObject1 = new c(this);
              ((c)localObject1).setKey((String)localObject3);
              if (!Util.isNullOrNil(locala.nickname)) {
                ((c)localObject1).qnT = (locala.nickname + ":");
              }
              ((c)localObject1).mContent = locala.content;
              ((c)localObject1).CKl = locala.thumburl;
              this.screen.c((Preference)localObject1);
            }
            else
            {
              localObject1 = new a(this);
              ((a)localObject1).setKey((String)localObject3);
              ((a)localObject1).setTitle(locala.name);
              ((a)localObject1).setSummary(locala.desc);
              ((a)localObject1).CJc = locala.iAq;
              ((a)localObject1).rcG = locala.iconUrl;
              this.screen.c((Preference)localObject1);
            }
          }
        }
      }
    }
    this.screen.notifyDataSetChanged();
    Log.d("MicroMsg.scanner.ProductUI", "initBodyView finish");
    if (this.AjG != null) {
      this.CLz = false;
    }
    AppMethodBeat.o(51885);
  }
  
  private int bLC()
  {
    if (this.CLl == 4) {
      return 11;
    }
    if (this.CLl == 3) {
      return 12;
    }
    return 0;
  }
  
  private void co(int paramInt, String paramString)
  {
    AppMethodBeat.i(51890);
    if (this.CLj == null)
    {
      AppMethodBeat.o(51890);
      return;
    }
    paramString = new p(this.CLj.field_productid, "", paramInt, paramString, 0, 0);
    com.tencent.mm.kernel.g.azz().a(paramString, 0);
    AppMethodBeat.o(51890);
  }
  
  private static boolean e(int paramInt, LinkedList<com.tencent.mm.plugin.scanner.model.b.a> paramLinkedList)
  {
    AppMethodBeat.i(51886);
    if (paramLinkedList != null)
    {
      paramInt += 1;
      while (paramInt < paramLinkedList.size())
      {
        if (((com.tencent.mm.plugin.scanner.model.b.a)paramLinkedList.get(paramInt)).dDG != 2)
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
  
  private void eQJ()
  {
    AppMethodBeat.i(51882);
    this.CLm = getContext().getResources().getDimensionPixelSize(2131166815);
    if ((this.CLj != null) && ((this.CLj.field_type == 1) || (this.CLj.field_type == 2)))
    {
      this.CLm = getContext().getResources().getDimensionPixelSize(2131166816);
      Object localObject = this.CLc.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).height = this.CLm;
      this.CLc.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = this.CLd.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).height = this.CLm;
      this.CLh.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (RelativeLayout)findViewById(2131306161);
      ViewGroup.LayoutParams localLayoutParams = ((RelativeLayout)localObject).getLayoutParams();
      localLayoutParams.height = this.CLm;
      ((RelativeLayout)localObject).setLayoutParams(localLayoutParams);
      localObject = this.CLh.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).height = this.CLm;
      this.CLh.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    AppMethodBeat.o(51882);
  }
  
  private void eQK()
  {
    AppMethodBeat.i(51884);
    this.msgId = getIntent().getLongExtra("key_ProductUI_chatting_msgId", 0L);
    if ((this.msgId > 0L) && (com.tencent.mm.kernel.g.aAc()))
    {
      ca localca = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().Hb(this.msgId);
      if (localca.field_msgId > 0L)
      {
        localca.Cz(this.CLn.blA());
        ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().a(this.msgId, localca);
      }
    }
    AppMethodBeat.o(51884);
  }
  
  private void eQL()
  {
    AppMethodBeat.i(51887);
    if ((this.CLj == null) || (this.CLj.CUx == null) || (this.CLj.CUx.size() == 0) || (this.screen == null))
    {
      AppMethodBeat.o(51887);
      return;
    }
    int i = 0;
    while (i < this.CLj.CUx.size())
    {
      com.tencent.mm.plugin.scanner.model.b localb = (com.tencent.mm.plugin.scanner.model.b)this.CLj.CUx.get(i);
      if ((localb != null) && (localb.mRG != null) && (localb.mRG.size() != 0))
      {
        int j = 0;
        if (j < localb.mRG.size())
        {
          com.tencent.mm.plugin.scanner.model.b.a locala = (com.tencent.mm.plugin.scanner.model.b.a)localb.mRG.get(j);
          MusicPreference localMusicPreference;
          if (locala.type == 5)
          {
            String str = i * 100 + j;
            localMusicPreference = (MusicPreference)this.screen.bmg(str);
            if (localMusicPreference != null)
            {
              if (aMJ(String.format("%s_cd_%s", new Object[] { locala.CEJ, str }))) {
                break label221;
              }
              localMusicPreference.tV(false);
            }
          }
          for (;;)
          {
            j += 1;
            break;
            label221:
            localMusicPreference.tV(true);
          }
        }
      }
      i += 1;
    }
    this.screen.notifyDataSetChanged();
    AppMethodBeat.o(51887);
  }
  
  private int eQM()
  {
    if (this.CLl == 3) {
      return 47;
    }
    return 49;
  }
  
  private void eQN()
  {
    AppMethodBeat.i(51897);
    if (this.CLj != null)
    {
      Log.i("MicroMsg.scanner.ProductUI", "doUpdateActionLogic, flag=:" + this.CLj.field_getaction);
      if ((this.CLj.field_getaction & 0x2) > 0)
      {
        this.gmt = com.tencent.mm.modelgeo.d.bca();
        if (this.gmt != null)
        {
          this.gmt.b(this.gmA);
          AppMethodBeat.o(51897);
        }
      }
      else if ((this.CLj.field_getaction & 0x1) > 0)
      {
        k localk = new k(this.rcD, com.tencent.mm.plugin.scanner.model.t.gA(this.CLj.CUx), this.mScene, this.CLr, 0.0D, 0.0D);
        com.tencent.mm.kernel.g.azz().a(localk, 0);
      }
    }
    AppMethodBeat.o(51897);
  }
  
  private void eQO()
  {
    AppMethodBeat.i(51899);
    if (!com.tencent.mm.plugin.scanner.util.e.eRU())
    {
      Log.e("MicroMsg.scanner.ProductUI", "mHistoryItem ScanHistoryUtil.shouldShowHistoryList() is false!");
      AppMethodBeat.o(51899);
      return;
    }
    com.tencent.mm.plugin.scanner.history.a.a locala = new com.tencent.mm.plugin.scanner.history.a.a();
    locala.field_productId = this.rcD;
    if (!j.eOR().eOS().get(locala, new String[0])) {}
    for (boolean bool = j.eOR().eOS().insert(this.CLw); bool; bool = j.eOR().eOS().update(this.CLw, new String[0]))
    {
      Log.i("MicroMsg.scanner.ProductUI", "mHistoryItem insert success!");
      this.uOU = true;
      AppMethodBeat.o(51899);
      return;
    }
    Log.e("MicroMsg.scanner.ProductUI", "mHistoryItem insert fail!");
    AppMethodBeat.o(51899);
  }
  
  private void y(final String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(51894);
    this.rcD = paramString1;
    this.CLr = paramString2;
    paramString1 = new com.tencent.mm.plugin.scanner.model.l(paramString1, this.mScene, paramString2);
    com.tencent.mm.kernel.g.azz().a(paramString1, 0);
    if (!paramBoolean)
    {
      paramString2 = getContext();
      getString(2131755998);
      this.gtM = com.tencent.mm.ui.base.h.b(paramString2, getString(2131764943), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(51859);
          Log.d("MicroMsg.scanner.ProductUI", "User cancel");
          com.tencent.mm.kernel.g.azz().a(paramString1);
          AppMethodBeat.o(51859);
        }
      });
    }
    AppMethodBeat.o(51894);
  }
  
  private static void z(View paramView, float paramFloat)
  {
    AppMethodBeat.i(51898);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(paramFloat, paramFloat);
    localAlphaAnimation.setDuration(0L);
    localAlphaAnimation.setFillAfter(true);
    paramView.startAnimation(localAlphaAnimation);
    AppMethodBeat.o(51898);
  }
  
  public int getHeaderResourceId()
  {
    return 2131495961;
  }
  
  public int getLayoutId()
  {
    return 2131495954;
  }
  
  public int getResourceId()
  {
    return 2132017245;
  }
  
  public void initView()
  {
    AppMethodBeat.i(51881);
    setMMTitle(2131764974);
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
    this.titleTv = ((TextView)findViewById(2131306173));
    this.CLc = ((ImageView)findViewById(2131306160));
    this.CLd = findViewById(2131306165);
    this.CLf = ((ImageView)findViewById(2131306154));
    this.CLk = findViewById(2131306150);
    this.CLh = ((LinearLayout)findViewById(2131306164));
    this.CLi = ((ImageView)findViewById(2131306162));
    this.CLg = findViewById(2131306153);
    z(this.CLk, 0.0F);
    Object localObject;
    String str;
    if (com.tencent.mm.cb.a.jk(getContext()))
    {
      this.titleTv.setTextSize(0, getContext().getResources().getDimensionPixelSize(2131165270) * com.tencent.mm.cb.a.iZ(getContext()));
      this.CLe = ((TextView)findViewById(2131306152));
      this.kch = ((TextView)findViewById(2131307254));
      this.CLp = new HashMap();
      this.CLq = new d.a()
      {
        public final Boolean aMH(String paramAnonymousString)
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
        
        public final void eQI()
        {
          AppMethodBeat.i(51865);
          if (ProductUI.this.screen != null) {
            ProductUI.this.screen.notifyDataSetChanged();
          }
          AppMethodBeat.o(51865);
        }
      };
      this.CLw = new com.tencent.mm.plugin.scanner.history.a.a();
      this.CLw.field_ScanTime = System.currentTimeMillis();
      this.CLw.field_scene = this.mScene;
      if (this.mScene != 5) {
        break label428;
      }
      this.CLu = true;
      localObject = getIntent().getStringExtra("key_Qrcode_Url");
      str = aMK((String)localObject);
      this.CLw.field_qrcodeUrl = ((String)localObject);
      this.CLw.field_productId = str;
      y(str, (String)localObject, false);
    }
    label772:
    for (;;)
    {
      findViewById(2131306167).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(51866);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ProductUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          ProductUI.l(ProductUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/ProductUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(51866);
        }
      });
      findViewById(2131306156).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(51867);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ProductUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          ProductUI.l(ProductUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/ProductUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(51867);
        }
      });
      this.CLg.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(51868);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ProductUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if ((ProductUI.a(ProductUI.this) != null) && (!Util.isNullOrNil(ProductUI.a(ProductUI.this).field_certificationurl)))
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
      this.titleTv.setTextSize(0, com.tencent.mm.cb.a.aG(getContext(), 2131165270));
      break;
      label428:
      if (this.mScene == 4)
      {
        localObject = getIntent().getStringExtra("key_product_id");
        str = getIntent().getStringExtra("key_Qrcode_Url");
        if (!Util.isNullOrNil((String)localObject))
        {
          y((String)localObject, str, false);
        }
        else
        {
          Log.e("MicroMsg.scanner.ProductUI", "jsapi jump finish productId null");
          finish();
          AppMethodBeat.o(51881);
        }
      }
      else
      {
        this.CLv = getIntent().getBooleanExtra("key_is_from_barcode", false);
        this.CLu = getIntent().getBooleanExtra("key_need_add_to_history", false);
        localObject = getIntent().getStringExtra("key_Product_xml");
        if (!Util.isNullOrNil((String)localObject))
        {
          int i = getIntent().getIntExtra("key_Product_funcType", 0);
          this.CLj = r.fn((String)localObject, i);
          if (this.CLj == null)
          {
            Log.e("MicroMsg.scanner.ProductUI", "initView(), product == null");
            finish();
            AppMethodBeat.o(51881);
            return;
          }
          this.rcD = this.CLj.field_productid;
          this.CLr = this.CLj.field_extinfo;
          if ((this.CLu) && (!TextUtils.isEmpty(this.rcD)))
          {
            this.CLw.field_xmlContent = ((String)localObject);
            this.CLw.field_qrcodeUrl = this.CLr;
            this.CLw.field_productId = this.rcD;
            this.CLw.field_funcType = i;
            eQO();
          }
          for (;;)
          {
            localObject = this.CLj;
            getIntent().getBooleanExtra("key_ProductUI_addToDB", true);
            a((n.a)localObject);
            if ((i != 0) || (Util.isNullOrNil(this.CLj.field_productid))) {
              break label772;
            }
            y(this.CLj.field_productid, this.CLj.field_extinfo, true);
            break;
            Log.i("MicroMsg.scanner.ProductUI", "shouldAddToHistory:" + this.CLu + " mProductId:" + this.rcD);
          }
          eQN();
        }
        else
        {
          localObject = getIntent().getStringExtra("key_Product_ID");
          if (Util.isNullOrNil((String)localObject)) {
            break label807;
          }
          y((String)localObject, null, false);
        }
      }
    }
    label807:
    Log.e("MicroMsg.scanner.ProductUI", "normal finish productId null");
    finish();
    AppMethodBeat.o(51881);
  }
  
  public final void k(final String paramString, final Bitmap paramBitmap)
  {
    AppMethodBeat.i(51891);
    if ((!Util.isNullOrNil(paramString)) && (this.CLj != null) && (paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      Log.d("MicroMsg.scanner.ProductUI", "onGetPictureFinish: notifyKey=".concat(String.valueOf(paramString)));
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(51858);
          if ((paramString.equals(ProductUI.a(ProductUI.this).field_thumburl)) && (ProductUI.s(ProductUI.this) != null)) {
            Log.i("MicroMsg.scanner.ProductUI", "onGetPictureFinish: notifyKey=" + paramString);
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
              Log.e("MicroMsg.scanner.ProductUI", "onGetPictureFinish : [%s]", new Object[] { localException.getLocalizedMessage() });
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
    this.mStartTime = Util.nowSecond();
    this.mScene = getIntent().getIntExtra("key_ProductUI_getProductInfoScene", 0);
    u.b(this);
    ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().a("scanproductinfo", this.CLx, true);
    initView();
    AppMethodBeat.o(51877);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(51880);
    u.c(this);
    ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().b("scanproductinfo", this.CLx, true);
    EventCenter.instance.removeListener(this.lEl);
    if (this.gmt != null) {
      this.gmt.c(this.gmA);
    }
    co(10100, Util.nowSecond() - this.mStartTime);
    super.onDestroy();
    AppMethodBeat.o(51880);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(51879);
    com.tencent.mm.kernel.g.azz().b(1063, this);
    com.tencent.mm.kernel.g.azz().b(1068, this);
    super.onPause();
    AppMethodBeat.o(51879);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(51888);
    Log.i("MicroMsg.scanner.ProductUI", "onPreferenceTreeClick item: [%s]", new Object[] { paramPreference.mKey });
    if ((this.CLj == null) || (this.CLj.CUx == null))
    {
      Log.e("MicroMsg.scanner.ProductUI", "product == null || product.actionlist == null");
      AppMethodBeat.o(51888);
      return false;
    }
    for (;;)
    {
      com.tencent.mm.plugin.scanner.model.b.a locala;
      Intent localIntent;
      try
      {
        int i = Integer.valueOf(paramPreference.mKey).intValue();
        int j = i / 100;
        int k = i % 100;
        Log.v("MicroMsg.scanner.ProductUI", "keyId=[%s], ii=[%s], jj=[%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
        if ((j < 0) || (j >= this.CLj.CUx.size()))
        {
          Log.w("MicroMsg.scanner.ProductUI", "index out of bounds, ii=[%s], list Size=[%s]", new Object[] { Integer.valueOf(j), Integer.valueOf(this.CLj.CUx.size()) });
          AppMethodBeat.o(51888);
          return false;
        }
        localb = (com.tencent.mm.plugin.scanner.model.b)this.CLj.CUx.get(j);
        if (localb == null)
        {
          Log.w("MicroMsg.scanner.ProductUI", "actionList == null");
          AppMethodBeat.o(51888);
          return false;
        }
        if ((k < 0) || (k >= localb.mRG.size()))
        {
          Log.w("MicroMsg.scanner.ProductUI", "index out of bounds, jj=[%s], actions Size=[%s]", new Object[] { Integer.valueOf(k), Integer.valueOf(localb.mRG.size()) });
          AppMethodBeat.o(51888);
          return false;
        }
        locala = (com.tencent.mm.plugin.scanner.model.b.a)localb.mRG.get(k);
        if (locala == null)
        {
          Log.w("MicroMsg.scanner.ProductUI", "action == null");
          AppMethodBeat.o(51888);
          return false;
        }
        Log.i("MicroMsg.scanner.ProductUI", "action.type = [%s]", new Object[] { Integer.valueOf(locala.type) });
        localIntent = new Intent();
        switch (locala.type)
        {
        case 13: 
        case 14: 
        case 15: 
        case 16: 
        case 17: 
        case 18: 
        case 19: 
        case 20: 
          Log.d("MicroMsg.scanner.ProductUI", "Default go url:" + locala.link);
          if (Util.isNullOrNil(locala.link)) {
            break label1271;
          }
          aMM(locala.link);
        }
      }
      catch (Exception paramf)
      {
        com.tencent.mm.plugin.scanner.model.b localb;
        Log.e("MicroMsg.scanner.ProductUI", "onPreferenceTreeClick, [%s]", new Object[] { paramf.getMessage() });
        Log.printErrStackTrace("MicroMsg.scanner.ProductUI", paramf, "", new Object[0]);
        AppMethodBeat.o(51888);
        return false;
      }
      paramf = new p(this.CLj.field_productid, locala.CEM, locala.type, paramf, localb.mRG.size(), locala.dDG);
      com.tencent.mm.kernel.g.azz().a(paramf, 0);
      AppMethodBeat.o(51888);
      return true;
      paramPreference = locala.link;
      paramf = paramPreference;
      if (!Util.isNullOrNil(locala.link))
      {
        aMM(locala.link);
        paramf = paramPreference;
        continue;
        paramPreference = locala.username;
        paramf = paramPreference;
        if (!Util.isNullOrNil(locala.username))
        {
          paramf = locala.username;
          if (aML(paramf))
          {
            localIntent = new Intent();
            localIntent.putExtra("Chat_User", paramf);
            localIntent.putExtra("finish_direct", true);
            localIntent.putExtra("add_scene", eQM());
            com.tencent.mm.plugin.scanner.h.jRt.d(localIntent, getContext());
            paramf = paramPreference;
          }
          else if (TextUtils.isEmpty(paramf))
          {
            Log.v("MicroMsg.scanner.ProductUI", "username is null");
            paramf = paramPreference;
          }
          else
          {
            localIntent = new Intent();
            localIntent.putExtra("Contact_User", paramf);
            localIntent.putExtra("force_get_contact", true);
            localIntent.putExtra("Contact_Scene", eQM());
            com.tencent.mm.plugin.scanner.h.jRt.c(localIntent, this);
            paramf = paramPreference;
            continue;
            paramf = locala.CEL;
            localIntent.putExtra("rawUrl", locala.CEL);
            localIntent.putExtra("geta8key_scene", bLC());
            com.tencent.mm.plugin.scanner.h.jRt.i(localIntent, this);
            com.tencent.mm.ay.a.bea();
            eQL();
            continue;
            paramPreference = locala.CEN;
            paramf = paramPreference;
            if (!Util.isNullOrNil(locala.CEN))
            {
              localIntent.putExtra("key_product_id", locala.CEN);
              localIntent.putExtra("key_product_scene", 12);
              com.tencent.mm.br.c.b(this, "product", ".ui.MallProductUI", localIntent);
              paramf = paramPreference;
              continue;
              paramf = locala.CEN;
              localIntent.putExtra("key_card_id", locala.CEP);
              localIntent.putExtra("key_card_ext", locala.CEO);
              localIntent.putExtra("key_from_scene", 9);
              com.tencent.mm.br.c.b(this, "card", ".ui.CardDetailUI", localIntent);
              continue;
              localIntent.setClass(this, ProductFurtherInfoUI.class);
              localIntent.putExtra("key_Product_xml", this.CLj.field_xml);
              localIntent.putExtra("key_title", locala.name);
              paramf = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
              com.tencent.mm.hellhoundlib.a.a.a(this, paramf.axQ(), "com/tencent/mm/plugin/scanner/ui/ProductUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              startActivity((Intent)paramf.pG(0));
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/ProductUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramf = null;
              continue;
              paramf = locala.CEG;
              localIntent.setClass(this, ProductPurchaseAreaUI.class);
              localIntent.putExtra("key_Product_xml", this.CLj.field_xml);
              localIntent.putExtra("referkey", locala.CEG);
              localIntent.putExtra("key_Product_funcType", this.CLl);
              paramPreference = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
              com.tencent.mm.hellhoundlib.a.a.a(this, paramPreference.axQ(), "com/tencent/mm/plugin/scanner/ui/ProductUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              startActivity((Intent)paramPreference.pG(0));
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/ProductUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              continue;
              paramPreference = locala.link;
              paramf = paramPreference;
              if (!Util.isNullOrNil(locala.link))
              {
                aMM(locala.link);
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
    com.tencent.mm.kernel.g.azz().a(1063, this);
    com.tencent.mm.kernel.g.azz().a(1068, this);
    AppMethodBeat.o(51878);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(51892);
    if (paramq == null)
    {
      Log.w("MicroMsg.scanner.ProductUI", "scene == null");
      AppMethodBeat.o(51892);
      return;
    }
    if (paramq.getType() == 1063)
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.e("MicroMsg.scanner.ProductUI", "onSceneEnd() errType = [%s], errCode = [%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        AppMethodBeat.o(51892);
        return;
      }
      paramString = (com.tencent.mm.plugin.scanner.model.l)paramq;
      if ((paramString.rr != null) && (paramString.rr.iLL.iLR != null)) {}
      for (paramString = (oo)paramString.rr.iLL.iLR; paramString == null; paramString = null)
      {
        Log.w("MicroMsg.scanner.ProductUI", "onSceneEnd productInfo == null");
        AppMethodBeat.o(51892);
        return;
      }
      if (paramString.KUw != null)
      {
        Log.d("MicroMsg.scanner.ProductUI", "onSceneEnd  productInfo.DescXML != null");
        paramq = r.fn(paramString.KUw, this.CLl);
        if ((this.CLj != null) && (this.CLj.field_xml != null) && (paramq != null) && (paramq.field_xml != null) && (!this.CLj.field_xml.equals(paramq.field_xml)))
        {
          this.CLj = paramq;
          a(this.CLj);
        }
        for (;;)
        {
          if ((this.gtM != null) && (this.gtM.isShowing())) {
            this.gtM.dismiss();
          }
          eQN();
          if ((!this.CLu) || (this.uOU) || (TextUtils.isEmpty(this.rcD))) {
            break;
          }
          this.CLw.field_xmlContent = paramString.KUw;
          this.CLw.field_funcType = this.CLl;
          eQO();
          AppMethodBeat.o(51892);
          return;
          if ((paramq != null) && (paramq.field_xml != null))
          {
            this.CLj = paramq;
            a(this.CLj);
          }
        }
        Log.i("MicroMsg.scanner.ProductUI", "shouldAddToHistory:" + this.CLu + " mProductId:" + this.rcD + "  hasAddToHistory:" + this.uOU);
      }
      AppMethodBeat.o(51892);
      return;
    }
    if ((paramq.getType() == 1068) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = ((om)((k)paramq).rr.iLL.iLR).KUv;
      if ((this.CLj != null) && (com.tencent.mm.plugin.scanner.model.t.b(this.CLj.CUx, com.tencent.mm.plugin.scanner.model.t.gB(paramString)))) {
        b(this.CLj);
      }
    }
    AppMethodBeat.o(51892);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public static final class a
    implements com.tencent.mm.platformtools.s
  {
    private n.a CLj;
    
    public a(n.a parama)
    {
      this.CLj = parama;
    }
    
    public final Bitmap a(Bitmap paramBitmap, s.a parama, String paramString)
    {
      AppMethodBeat.i(51872);
      if (s.a.jNh == parama) {}
      try
      {
        BitmapUtil.saveBitmapToImage(paramBitmap, 100, Bitmap.CompressFormat.PNG, blA(), false);
        AppMethodBeat.o(51872);
        return paramBitmap;
      }
      catch (IOException parama)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.scanner.ProductUI", parama, "", new Object[0]);
        }
      }
    }
    
    public final void a(s.a parama, String paramString) {}
    
    public final void ad(String paramString, boolean paramBoolean) {}
    
    public final String blA()
    {
      AppMethodBeat.i(51871);
      String str = j.eOR().jP(this.CLj.field_thumburl, "@S");
      AppMethodBeat.o(51871);
      return str;
    }
    
    public final String blB()
    {
      if (this.CLj == null) {
        return "";
      }
      return this.CLj.field_thumburl;
    }
    
    public final String blC()
    {
      if (this.CLj == null) {
        return "";
      }
      return this.CLj.field_thumburl;
    }
    
    public final boolean blD()
    {
      return false;
    }
    
    public final boolean blE()
    {
      return false;
    }
    
    public final Bitmap blF()
    {
      AppMethodBeat.i(51873);
      if (MMApplicationContext.getContext() == null)
      {
        AppMethodBeat.o(51873);
        return null;
      }
      Bitmap localBitmap = BitmapFactory.decodeResource(MMApplicationContext.getContext().getResources(), 2131234279);
      AppMethodBeat.o(51873);
      return localBitmap;
    }
    
    public final void blG() {}
    
    public final s.b blz()
    {
      return null;
    }
    
    public final String getCacheKey()
    {
      if (this.CLj == null) {
        return "";
      }
      return this.CLj.field_thumburl;
    }
  }
  
  final class b
  {
    ProductScrollView CLG;
    boolean CLH;
    private ProductScrollView.a CLI;
    int mActionBarHeight;
    
    public b()
    {
      AppMethodBeat.i(51875);
      this.CLI = new ProductScrollView.a()
      {
        public final void cLT()
        {
          float f3 = 1.0F;
          AppMethodBeat.i(51874);
          ProductUI.b localb = ProductUI.b.this;
          int i = localb.CLG.getScrollY();
          float f1;
          label65:
          float f2;
          if (i < 0)
          {
            f1 = -1.0F;
            Log.v("MicroMsg.ProductUI.HeaderEffectHelper", "rate=".concat(String.valueOf(f1)));
            if (f1 != 1.0F) {
              break label211;
            }
            if (!localb.CLH)
            {
              localb.CLH = true;
              if (ProductUI.x(localb.CLA) != null)
              {
                float f4 = 1.0F - f1 - 0.2F;
                f2 = f4;
                if (f4 <= 0.0F) {
                  f2 = 0.0F;
                }
                if (f1 == 0.0F) {
                  f2 = 1.0F;
                }
                ProductUI.A(ProductUI.x(localb.CLA), f2);
              }
              if (ProductUI.y(localb.CLA) != null)
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
            ProductUI.A(ProductUI.y(localb.CLA), f2);
            AppMethodBeat.o(51874);
            return;
            if ((i >= ProductUI.z(localb.CLA) - localb.mActionBarHeight) || (ProductUI.z(localb.CLA) == 0.0F))
            {
              f1 = 1.0F;
              break;
            }
            f1 = i * 1.37F / ProductUI.z(localb.CLA);
            break;
            label211:
            localb.CLH = false;
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
      this.CLG = ((ProductScrollView)ProductUI.this.findViewById(2131306308));
      this.CLG.setOnScrollListener(this.CLI);
      this.mActionBarHeight = ProductUI.w(ProductUI.this);
      AppMethodBeat.o(51875);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ProductUI
 * JD-Core Version:    0.7.0.1
 */