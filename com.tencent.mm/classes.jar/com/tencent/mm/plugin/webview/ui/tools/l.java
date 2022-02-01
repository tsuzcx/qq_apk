package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.j.b;
import com.tencent.mm.g.a.sp;
import com.tencent.mm.m.d.b;
import com.tencent.mm.plugin.brandservice.a.b.a;
import com.tencent.mm.plugin.handoff.model.HandOffURL;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic;
import com.tencent.mm.plugin.webview.c.f.11;
import com.tencent.mm.plugin.webview.c.f.18;
import com.tencent.mm.plugin.webview.c.f.20;
import com.tencent.mm.plugin.webview.c.f.4;
import com.tencent.mm.plugin.webview.c.f.5;
import com.tencent.mm.plugin.webview.c.f.6;
import com.tencent.mm.plugin.webview.c.f.63;
import com.tencent.mm.plugin.webview.c.f.66;
import com.tencent.mm.plugin.webview.c.f.67;
import com.tencent.mm.plugin.webview.c.f.7;
import com.tencent.mm.plugin.webview.c.l.a;
import com.tencent.mm.plugin.webview.model.aq;
import com.tencent.mm.plugin.webview.model.ax;
import com.tencent.mm.plugin.webview.stub.f.a;
import com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.bmn;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.MMFalseProgressBar;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.e.b;
import com.tencent.mm.ui.e.m;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.qqvideo.proxy.api.FactoryProxyManager;
import com.tencent.qqvideo.proxy.api.IPlayManager;
import com.tencent.xweb.WebView.c;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xwalk.core.XWalkEnvironment;

public final class l
  extends f.a
{
  private final WeakReference<WebViewUI> CsH;
  
  public l(WebViewUI paramWebViewUI)
  {
    AppMethodBeat.i(80008);
    this.CsH = new WeakReference(paramWebViewUI);
    AppMethodBeat.o(80008);
  }
  
  private int aAT(String paramString)
  {
    AppMethodBeat.i(80027);
    int i = ((WebViewUI)this.CsH.get()).aAT(paramString);
    AppMethodBeat.o(80027);
    return i;
  }
  
  private float bxg()
  {
    AppMethodBeat.i(80031);
    float f = com.tencent.mm.cd.a.eSs();
    if ((((WebViewUI)this.CsH.get()).nKq != null) && (((WebViewUI)this.CsH.get()).nKq.getWebCoreType() == WebView.c.KzZ) && (XWalkEnvironment.getUsingCustomContext())) {
      f = ((WebViewUI)this.CsH.get()).nKq.getResources().getDisplayMetrics().density;
    }
    for (;;)
    {
      AppMethodBeat.o(80031);
      return f;
    }
  }
  
  private Intent getIntent()
  {
    AppMethodBeat.i(80026);
    Intent localIntent = ((WebViewUI)this.CsH.get()).getIntent();
    AppMethodBeat.o(80026);
    return localIntent;
  }
  
  public final boolean Vr(final int paramInt)
  {
    AppMethodBeat.i(80011);
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(79973);
        if ((l.a(l.this).get() == null) || (((WebViewUI)l.a(l.this).get()).isFinishing()))
        {
          AppMethodBeat.o(79973);
          return;
        }
        ((WebViewUI)l.a(l.this).get()).setProgressBarIndeterminateVisibility(false);
        ac.d("MicroMsg.WebViewStubCallbackAIDLStub", "[cpan] set title pb visibility:%d", new Object[] { Integer.valueOf(paramInt) });
        if (paramInt == 0)
        {
          if ((!((WebViewUI)l.a(l.this).get()).CzU) && (!((WebViewUI)l.a(l.this).get()).CzV) && (!((WebViewUI)l.a(l.this).get()).bME()))
          {
            ((WebViewUI)l.a(l.this).get()).CyR.start();
            AppMethodBeat.o(79973);
          }
        }
        else {
          ((WebViewUI)l.a(l.this).get()).CyR.finish();
        }
        AppMethodBeat.o(79973);
      }
    });
    AppMethodBeat.o(80011);
    return true;
  }
  
  public final boolean a(com.tencent.mm.plugin.webview.stub.d paramd)
  {
    AppMethodBeat.i(80010);
    AppMethodBeat.o(80010);
    return true;
  }
  
  public final boolean a(final String paramString1, final String paramString2, final Bundle paramBundle, final boolean paramBoolean)
  {
    AppMethodBeat.i(80012);
    if ((this.CsH.get() == null) || (((WebViewUI)this.CsH.get()).isFinishing()))
    {
      AppMethodBeat.o(80012);
      return false;
    }
    if (((WebViewUI)this.CsH.get()).Cjc != null)
    {
      paramString1 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(79974);
          if ((l.a(l.this).get() == null) || (((WebViewUI)l.a(l.this).get()).isFinishing()))
          {
            AppMethodBeat.o(79974);
            return;
          }
          ((WebViewUI)l.a(l.this).get()).Cjc.a(paramString1, paramString2, com.tencent.mm.plugin.webview.c.l.at(paramBundle), paramBoolean);
          AppMethodBeat.o(79974);
        }
      };
      if (!ap.isMainThread()) {
        break label87;
      }
      paramString1.run();
    }
    for (;;)
    {
      AppMethodBeat.o(80012);
      return false;
      label87:
      ap.f(paramString1);
    }
  }
  
  public final void aCM(String paramString)
  {
    final int i = 0;
    AppMethodBeat.i(80021);
    if ((this.CsH.get() == null) || (((WebViewUI)this.CsH.get()).isFinishing()))
    {
      AppMethodBeat.o(80021);
      return;
    }
    try
    {
      int j = bs.getInt(paramString, 0);
      i = j;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ac.e("MicroMsg.WebViewStubCallbackAIDLStub", "setFontSizeCb, ex = " + paramString.getMessage());
      }
      ap.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(79978);
          if ((l.a(l.this).get() == null) || (((WebViewUI)l.a(l.this).get()).isFinishing()))
          {
            AppMethodBeat.o(79978);
            return;
          }
          ((WebViewUI)l.a(l.this).get()).US(i);
          AppMethodBeat.o(79978);
        }
      });
      AppMethodBeat.o(80021);
    }
    if (((WebViewUI)this.CsH.get()).nKq == null)
    {
      ac.e("MicroMsg.WebViewStubCallbackAIDLStub", "setFontSizeCb fail, viewWV is null");
      AppMethodBeat.o(80021);
      return;
    }
  }
  
  public final void aD(Bundle paramBundle)
  {
    AppMethodBeat.i(80020);
    if ((this.CsH.get() == null) || (((WebViewUI)this.CsH.get()).isFinishing()))
    {
      AppMethodBeat.o(80020);
      return;
    }
    ac.i("MicroMsg.WebViewStubCallbackAIDLStub", "IUIController, closeWindow");
    if (paramBundle != null)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("result_data", paramBundle);
      ((WebViewUI)this.CsH.get()).setResult(-1, localIntent);
    }
    ((WebViewUI)this.CsH.get()).finish();
    AppMethodBeat.o(80020);
  }
  
  public final void aE(Bundle paramBundle)
  {
    AppMethodBeat.i(80029);
    if ((this.CsH.get() == null) || (((WebViewUI)this.CsH.get()).isFinishing()))
    {
      AppMethodBeat.o(80029);
      return;
    }
    ac.i("MicroMsg.WebViewStubCallbackAIDLStub", "setCustomMenu");
    Object localObject = paramBundle.getStringArrayList("keys");
    ArrayList localArrayList = paramBundle.getStringArrayList("titles");
    int j = ((ArrayList)localObject).size();
    paramBundle = new ArrayList();
    int i = 0;
    while (i < j)
    {
      paramBundle.add(new d.b((String)((ArrayList)localObject).get(i), (String)localArrayList.get(i)));
      i += 1;
    }
    if (((ArrayList)localObject).size() > 0)
    {
      localObject = ((WebViewUI)this.CsH.get()).nKq.getUrl();
      if (((WebViewUI)this.CsH.get()).CzL.containsKey(localObject)) {
        ((WebViewUI)this.CsH.get()).CzL.remove(localObject);
      }
      ((WebViewUI)this.CsH.get()).CzL.put(localObject, paramBundle);
    }
    AppMethodBeat.o(80029);
  }
  
  public final String dKq()
  {
    AppMethodBeat.i(188387);
    if ((this.CsH.get() == null) || (((WebViewUI)this.CsH.get()).isFinishing()))
    {
      AppMethodBeat.o(188387);
      return null;
    }
    String str = ((WebViewUI)this.CsH.get()).dKq();
    AppMethodBeat.o(188387);
    return str;
  }
  
  public final void e(String paramString1, final String paramString2, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(80023);
    if ((this.CsH.get() == null) || (((WebViewUI)this.CsH.get()).isFinishing()))
    {
      AppMethodBeat.o(80023);
      return;
    }
    ac.d("MicroMsg.WebViewStubCallbackAIDLStub", "result: ".concat(String.valueOf(paramString2)));
    if ((((WebViewUI)this.CsH.get()).CAi.kYA == null) || (paramString1 == null) || (!paramString1.equals(((WebViewUI)this.CsH.get()).CAi.kYA.CsC)))
    {
      AppMethodBeat.o(80023);
      return;
    }
    if (((WebViewUI)this.CsH.get()).CAi.kYA != null) {
      ((WebViewUI)this.CsH.get()).CAi.kYA.eCf();
    }
    if ((paramString2 == null) || (((WebViewUI)this.CsH.get()).CAi == null))
    {
      AppMethodBeat.o(80023);
      return;
    }
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(79979);
        if ((l.a(l.this).get() == null) || (((WebViewUI)l.a(l.this).get()).isFinishing()) || (((WebViewUI)l.a(l.this).get()).nKq == null))
        {
          AppMethodBeat.o(79979);
          return;
        }
        ((WebViewUI)l.a(l.this).get()).CAi.ay(paramString2, paramInt1, paramInt2);
        AppMethodBeat.o(79979);
      }
    });
    AppMethodBeat.o(80023);
  }
  
  public final String eCA()
  {
    AppMethodBeat.i(80015);
    if ((this.CsH.get() == null) || (((WebViewUI)this.CsH.get()).isFinishing()))
    {
      AppMethodBeat.o(80015);
      return null;
    }
    String str = ((WebViewUI)this.CsH.get()).getIntent().getStringExtra("srcUsername");
    AppMethodBeat.o(80015);
    return str;
  }
  
  public final String eCy()
  {
    AppMethodBeat.i(80013);
    if ((this.CsH.get() == null) || (((WebViewUI)this.CsH.get()).isFinishing()))
    {
      AppMethodBeat.o(80013);
      return null;
    }
    String str = ((WebViewUI)this.CsH.get()).bLL();
    AppMethodBeat.o(80013);
    return str;
  }
  
  public final int eCz()
  {
    AppMethodBeat.i(80016);
    if ((this.CsH.get() == null) || (((WebViewUI)this.CsH.get()).isFinishing()))
    {
      AppMethodBeat.o(80016);
      return 0;
    }
    int i = ((WebViewUI)this.CsH.get()).blB();
    AppMethodBeat.o(80016);
    return i;
  }
  
  public final Bundle eH(String paramString1, String paramString2)
  {
    AppMethodBeat.i(80033);
    paramString1 = com.tencent.mm.protocal.c.aIx(null);
    AppMethodBeat.o(80033);
    return paramString1;
  }
  
  public final void ezP()
  {
    AppMethodBeat.i(80022);
    if ((this.CsH.get() == null) || (((WebViewUI)this.CsH.get()).isFinishing()))
    {
      AppMethodBeat.o(80022);
      return;
    }
    if (((WebViewUI)this.CsH.get()).Cjc != null) {
      ((WebViewUI)this.CsH.get()).Cjc.ezP();
    }
    AppMethodBeat.o(80022);
  }
  
  public final void ezQ()
  {
    AppMethodBeat.i(80019);
    if ((this.CsH.get() == null) || (((WebViewUI)this.CsH.get()).isFinishing()))
    {
      AppMethodBeat.o(80019);
      return;
    }
    if (((WebViewUI)this.CsH.get()).Cjc != null) {
      ((WebViewUI)this.CsH.get()).Cjc.ezQ();
    }
    AppMethodBeat.o(80019);
  }
  
  public final boolean g(int paramInt, final Bundle paramBundle)
  {
    AppMethodBeat.i(80009);
    ac.i("MicroMsg.WebViewStubCallbackAIDLStub", "callback, actionCode = ".concat(String.valueOf(paramInt)));
    Object localObject1 = (WebViewUI)this.CsH.get();
    if ((localObject1 == null) || (((WebViewUI)localObject1).isFinishing()))
    {
      AppMethodBeat.o(80009);
      return false;
    }
    final com.tencent.mm.plugin.webview.c.f localf = ((WebViewUI)localObject1).Cjc;
    Object localObject2 = ((WebViewUI)localObject1).kYu;
    switch (paramInt)
    {
    default: 
      ac.e("MicroMsg.WebViewStubCallbackAIDLStub", "undefine action code!!!");
    }
    for (;;)
    {
      AppMethodBeat.o(80009);
      return true;
      if (!((WebViewUI)localObject1).isFinishing())
      {
        ((WebViewUI)localObject1).finish();
        continue;
        ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(79944);
            if ((this.Cyc == null) || (this.Cyc.isFinishing()))
            {
              AppMethodBeat.o(79944);
              return;
            }
            if ((localf != null) && (this.ymm != null) && (this.ymm.eCm().ma(42))) {
              localf.j(paramBundle, "download_succ");
            }
            AppMethodBeat.o(79944);
          }
        });
        continue;
        ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(79955);
            if ((this.Cyc == null) || (this.Cyc.isFinishing()))
            {
              AppMethodBeat.o(79955);
              return;
            }
            if ((localf != null) && (this.ymm != null) && (this.ymm.eCm().ma(42))) {
              localf.j(paramBundle, "download_fail");
            }
            AppMethodBeat.o(79955);
          }
        });
        continue;
        ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(79966);
            if ((this.Cyc == null) || (this.Cyc.isFinishing()))
            {
              AppMethodBeat.o(79966);
              return;
            }
            if ((localf != null) && (this.ymm != null) && (this.ymm.eCm().ma(42))) {
              localf.j(paramBundle, "download_removed");
            }
            AppMethodBeat.o(79966);
          }
        });
        continue;
        ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(79977);
            if ((this.Cyc == null) || (this.Cyc.isFinishing()))
            {
              AppMethodBeat.o(79977);
              return;
            }
            if ((localf != null) && (this.ymm != null) && (this.ymm.eCm().ma(42))) {
              localf.j(paramBundle, "download_pause");
            }
            AppMethodBeat.o(79977);
          }
        });
        continue;
        ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(79988);
            if ((this.Cyc == null) || (this.Cyc.isFinishing()))
            {
              AppMethodBeat.o(79988);
              return;
            }
            if ((localf != null) && (this.ymm != null) && (this.ymm.eCm().ma(42))) {
              localf.j(paramBundle, "download_resumed");
            }
            AppMethodBeat.o(79988);
          }
        });
        continue;
        ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(80003);
            if ((this.Cyc == null) || (this.Cyc.isFinishing()))
            {
              AppMethodBeat.o(80003);
              return;
            }
            if ((localf != null) && (this.ymm != null) && (this.ymm.eCm().ma(42))) {
              localf.j(paramBundle, "download_start");
            }
            AppMethodBeat.o(80003);
          }
        });
        continue;
        final long l = paramBundle.getLong("download_manager_downloadid");
        paramInt = paramBundle.getInt("download_manager_progress");
        final float f = paramBundle.getFloat("download_manager_progress_float");
        ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(80005);
            if ((this.Cyc == null) || (this.Cyc.isFinishing()))
            {
              AppMethodBeat.o(80005);
              return;
            }
            if ((localf != null) && (this.ymm != null) && (this.ymm.eCm().ma(42))) {
              localf.a(this.val$appId, l, f, this.CyI);
            }
            AppMethodBeat.o(80005);
          }
        });
        continue;
        ap.f(new Runnable()
        {
          public final void run()
          {
            boolean bool2 = false;
            AppMethodBeat.i(80006);
            if ((this.Cyc == null) || (this.Cyc.isFinishing()))
            {
              AppMethodBeat.o(80006);
              return;
            }
            if ((localf != null) && (this.ymm != null))
            {
              this.ymm.eCm();
              localf.fe(this.Cyl, this.rf);
              AppMethodBeat.o(80006);
              return;
            }
            if ((localf != null) && (this.CyJ.booleanValue()))
            {
              localf.fe(this.Cyl, this.rf);
              AppMethodBeat.o(80006);
              return;
            }
            if (localf == null) {}
            for (boolean bool1 = true;; bool1 = false)
            {
              if (this.ymm == null) {
                bool2 = true;
              }
              ac.w("MicroMsg.WebViewStubCallbackAIDLStub", "something null, %s, %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
              AppMethodBeat.o(80006);
              return;
            }
          }
        });
        continue;
        ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(80007);
            if ((this.Cyc == null) || (this.Cyc.isFinishing()))
            {
              AppMethodBeat.o(80007);
              return;
            }
            if (localf != null)
            {
              com.tencent.mm.plugin.webview.c.f localf = localf;
              String str = this.CyK;
              int i = this.Cyg;
              if (!localf.Apr)
              {
                ac.e("MicroMsg.JsApiHandler", "onMediaFileUploadProgress fail, not ready");
                AppMethodBeat.o(80007);
                return;
              }
              ac.i("MicroMsg.JsApiHandler", "onMediaFileUploadProgress, local id : %s, percent : %d", new Object[] { str, Integer.valueOf(i) });
              HashMap localHashMap = new HashMap();
              localHashMap.put("localId", str);
              localHashMap.put("percent", Integer.valueOf(i));
              ap.f(new f.11(localf, l.a.b("onMediaFileUploadProgress", localHashMap, localf.Cjz, localf.CjA)));
            }
            AppMethodBeat.o(80007);
          }
        });
        continue;
        ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(79945);
            if ((this.Cyc == null) || (this.Cyc.isFinishing()))
            {
              AppMethodBeat.o(79945);
              return;
            }
            if (localf != null) {
              localf.ff(this.Cyf, this.Cyg);
            }
            AppMethodBeat.o(79945);
          }
        });
        continue;
        ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(79946);
            if ((this.Cyc == null) || (this.Cyc.isFinishing()))
            {
              AppMethodBeat.o(79946);
              return;
            }
            if (localf != null)
            {
              com.tencent.mm.plugin.webview.c.f localf = localf;
              String str1 = this.oKy;
              int i = this.kIx;
              String str2 = this.Cyh;
              int j = this.val$errCode;
              String str3 = this.val$errMsg;
              String str4 = this.Cyi;
              String str5 = this.vcV;
              if (!localf.Apr)
              {
                ac.e("MicroMsg.JsApiHandler", "onBackgroundAudioStateChange fail, not ready");
                AppMethodBeat.o(79946);
                return;
              }
              ac.i("MicroMsg.JsApiHandler", "onBackgroundAudioStateChange, state : %s, duration : %d, src:%s, errCode:%d, errMsg:%s, srcId:%s", new Object[] { str1, Integer.valueOf(i), str2, Integer.valueOf(j), str3, str4 });
              HashMap localHashMap = new HashMap();
              localHashMap.put("state", str1);
              localHashMap.put("duration", Integer.valueOf(i));
              localHashMap.put("src", str2);
              localHashMap.put("errCode", Integer.valueOf(j));
              localHashMap.put("errMsg", str3);
              localHashMap.put("srcId", str4);
              localHashMap.put("audioId", str5);
              ap.f(new f.18(localf, l.a.b("onBackgroundAudioStateChange", localHashMap, localf.Cjz, localf.CjA)));
            }
            AppMethodBeat.o(79946);
          }
        });
        continue;
        if (paramBundle != null)
        {
          paramBundle.putString("application_language", ((WebViewUI)localObject1).kYt.getLanguage());
          ((WebViewUI)localObject1).CzN = WebViewUI.a.aK(paramBundle);
          continue;
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(79947);
              if ((this.Cyc == null) || (this.Cyc.isFinishing()))
              {
                AppMethodBeat.o(79947);
                return;
              }
              if (localf != null) {
                localf.fg(this.Cyj, this.ckK);
              }
              AppMethodBeat.o(79947);
            }
          });
          continue;
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(79948);
              if ((this.Cyc == null) || (this.Cyc.isFinishing()))
              {
                AppMethodBeat.o(79948);
                return;
              }
              if (localf != null) {
                localf.fh(this.taQ, this.ckK);
              }
              AppMethodBeat.o(79948);
            }
          });
          continue;
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(79949);
              if ((this.Cyc == null) || (this.Cyc.isFinishing()))
              {
                AppMethodBeat.o(79949);
                return;
              }
              if (localf != null) {
                localf.fi(this.Cyj, this.ckK);
              }
              AppMethodBeat.o(79949);
            }
          });
          continue;
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(79950);
              if ((this.Cyc == null) || (this.Cyc.isFinishing()))
              {
                AppMethodBeat.o(79950);
                return;
              }
              if (localf != null) {
                localf.fj(this.taQ, this.ckK);
              }
              AppMethodBeat.o(79950);
            }
          });
          continue;
          localObject2 = new HashMap();
          ((Map)localObject2).put("err_msg", paramBundle.getString("playResult"));
          ((Map)localObject2).put("localId", paramBundle.getString("localId"));
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(79951);
              if ((this.Cyc == null) || (this.Cyc.isFinishing()))
              {
                AppMethodBeat.o(79951);
                return;
              }
              if (localf != null) {
                localf.bv(this.Cyk);
              }
              AppMethodBeat.o(79951);
            }
          });
          continue;
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(79952);
              if ((this.Cyc == null) || (this.Cyc.isFinishing()))
              {
                AppMethodBeat.o(79952);
                return;
              }
              if (localf != null)
              {
                com.tencent.mm.plugin.webview.c.f localf = localf;
                int i = this.val$errCode;
                if (!localf.Apr)
                {
                  ac.e("MicroMsg.JsApiHandler", "onNfcTouch fail, not ready");
                  AppMethodBeat.o(79952);
                  return;
                }
                ac.i("MicroMsg.JsApiHandler", "onNfcTouch errCode=%d", new Object[] { Integer.valueOf(i) });
                HashMap localHashMap = new HashMap();
                localHashMap.put("errCode", Integer.valueOf(i));
                ap.f(new f.20(localf, l.a.b("onNfcTouch", localHashMap, localf.Cjz, localf.CjA)));
              }
              AppMethodBeat.o(79952);
            }
          });
          continue;
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(79953);
              if ((this.Cyc == null) || (this.Cyc.isFinishing()))
              {
                AppMethodBeat.o(79953);
                return;
              }
              this.Cyc.setMMSubTitle(2131766134);
              AppMethodBeat.o(79953);
            }
          });
          continue;
          localObject2 = new HashMap();
          ((Map)localObject2).put("localId", paramBundle.getString("localId"));
          ((Map)localObject2).put("err_msg", paramBundle.getString("recordResult"));
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(79954);
              if ((this.Cyc == null) || (this.Cyc.isFinishing()))
              {
                AppMethodBeat.o(79954);
                return;
              }
              this.Cyc.setMMSubTitle(null);
              if (localf != null) {
                localf.bw(this.Cyk);
              }
              AppMethodBeat.o(79954);
            }
          });
          continue;
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(79956);
              if ((this.Cyc == null) || (this.Cyc.isFinishing()))
              {
                AppMethodBeat.o(79956);
                return;
              }
              this.Cyc.setMMSubTitle(null);
              AppMethodBeat.o(79956);
            }
          });
          continue;
          if (localf != null)
          {
            ap.f(new Runnable()
            {
              public final void run()
              {
                boolean bool = true;
                AppMethodBeat.i(79957);
                if ((this.Cyc == null) || (this.Cyc.isFinishing()))
                {
                  AppMethodBeat.o(79957);
                  return;
                }
                if ((!paramBundle.containsKey("jsapi_preverify_fun_list")) || (this.ymm == null)) {
                  if (this.ymm != null) {
                    ac.e("MicroMsg.WebViewStubCallbackAIDLStub", "has JSAPI_CONTROL_BYTES wvPerm %b", new Object[] { Boolean.valueOf(bool) });
                  }
                }
                for (;;)
                {
                  if (localf != null) {
                    localf.ezL();
                  }
                  AppMethodBeat.o(79957);
                  return;
                  bool = false;
                  break;
                  this.ymm.ax(paramBundle);
                }
              }
            });
            continue;
            if (localf != null)
            {
              Object localObject4;
              Object localObject5;
              Object localObject6;
              try
              {
                localObject1 = new LinkedList();
                localObject2 = paramBundle.getString("__appId");
                localObject3 = paramBundle.getString("__url");
                if (paramBundle.containsKey("__webComptList"))
                {
                  localObject4 = paramBundle.getStringArrayList("__webComptList").iterator();
                  while (((Iterator)localObject4).hasNext())
                  {
                    localObject5 = (String)((Iterator)localObject4).next();
                    localObject6 = new bmn();
                    ((bmn)localObject6).parseFrom(paramBundle.getByteArray((String)localObject5));
                    ((LinkedList)localObject1).add(localObject6);
                  }
                }
              }
              catch (IOException paramBundle)
              {
                ac.printErrStackTrace("MicroMsg.WebViewStubCallbackAIDLStub", paramBundle, "parse webCompt", new Object[0]);
              }
              localf.CjR.c((String)localObject2, (String)localObject3, (LinkedList)localObject1);
              continue;
              Object localObject3 = paramBundle.getString("exdevice_device_id");
              final boolean bool = paramBundle.getBoolean("exdevice_is_complete");
              ap.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(79958);
                  if ((this.Cyc == null) || (this.Cyc.isFinishing()))
                  {
                    AppMethodBeat.o(79958);
                    return;
                  }
                  com.tencent.mm.plugin.webview.c.f localf;
                  byte[] arrayOfByte;
                  boolean bool2;
                  Object localObject;
                  if (localf != null)
                  {
                    localf = localf;
                    String str = this.Cyl;
                    arrayOfByte = this.Cym;
                    boolean bool1 = bool;
                    bool2 = this.Cyo;
                    if (!localf.Apr)
                    {
                      ac.e("MicroMsg.JsApiHandler", "onScanWXDeviceResult fail, not ready");
                      AppMethodBeat.o(79958);
                      return;
                    }
                    if (arrayOfByte == null) {}
                    for (int i = 0;; i = arrayOfByte.length)
                    {
                      ac.i("MicroMsg.JsApiHandler", "onScanWXDeviceResult: device id = %s, isCompleted = %s, %s", new Object[] { str, Boolean.valueOf(bool1), Integer.valueOf(i) });
                      if (!bs.isNullOrNil(str)) {
                        break;
                      }
                      ac.e("MicroMsg.JsApiHandler", "parameter error!!!");
                      AppMethodBeat.o(79958);
                      return;
                    }
                    localObject = new JSONObject();
                    try
                    {
                      JSONArray localJSONArray = new JSONArray();
                      JSONObject localJSONObject = new JSONObject();
                      localJSONObject.put("deviceId", str);
                      com.tencent.mm.plugin.webview.c.a.a.eAh();
                      if ((com.tencent.mm.plugin.webview.c.a.a.bY(arrayOfByte)) || ((arrayOfByte != null) && (bool2))) {
                        localJSONObject.put("base64BroadcastData", Base64.encodeToString(arrayOfByte, 2));
                      }
                      localJSONArray.put(localJSONObject);
                      ((JSONObject)localObject).put("devices", localJSONArray);
                      if (!bool1) {
                        break label337;
                      }
                      ((JSONObject)localObject).put("isCompleted", "1");
                    }
                    catch (Exception localException2)
                    {
                      try
                      {
                        for (;;)
                        {
                          ac.i("MicroMsg.JsApiHandler", "hakon onScanWXDeviceResult, %s", new Object[] { localObject });
                          localf.Cjr.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + (String)localObject + ")", null);
                          if (!bool2) {
                            com.tencent.mm.plugin.webview.c.a.a.eAh().CkF = arrayOfByte;
                          }
                          AppMethodBeat.o(79958);
                          return;
                          ((JSONObject)localObject).put("isCompleted", "0");
                        }
                        localException2 = localException2;
                        ac.e("MicroMsg.JsApiHandler", "Ex in onScanWXDeviceResult, %s", new Object[] { localException2.getMessage() });
                      }
                      catch (Exception localException1)
                      {
                        for (;;)
                        {
                          ac.w("MicroMsg.JsApiHandler", "onScanWXDeviceResult, %s", new Object[] { localException1.getMessage() });
                        }
                      }
                    }
                    localObject = l.a.a("onScanWXDeviceResult", (JSONObject)localObject, localf.Cjz, localf.CjA);
                  }
                  label337:
                  ac.e("MicroMsg.WebViewStubCallbackAIDLStub", "hakon can not call onScanWXDeviceResult, %s, %s", new Object[] { localf, this.ymm });
                  AppMethodBeat.o(79958);
                }
              });
              continue;
              localObject2 = paramBundle.getString("exdevice_device_id");
              localObject3 = paramBundle.getString("exdevice_brand_name");
              ap.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(79959);
                  if ((this.Cyc == null) || (this.Cyc.isFinishing()))
                  {
                    AppMethodBeat.o(79959);
                    return;
                  }
                  if (localf != null)
                  {
                    com.tencent.mm.plugin.webview.c.f localf = localf;
                    String str = this.Cyl;
                    byte[] arrayOfByte = this.Cyp;
                    Object localObject = this.pxg;
                    if (!localf.Apr)
                    {
                      ac.e("MicroMsg.JsApiHandler", "onReceiveDataFromWXDevice fail, not ready");
                      AppMethodBeat.o(79959);
                      return;
                    }
                    ac.i("MicroMsg.JsApiHandler", "onReceiveDataFromWXDevice: device id = %s, brandName = %s", new Object[] { str, localObject });
                    if ((bs.isNullOrNil(str)) || (bs.isNullOrNil((String)localObject)) || (arrayOfByte == null))
                    {
                      ac.e("MicroMsg.JsApiHandler", "parameter error!!!");
                      AppMethodBeat.o(79959);
                      return;
                    }
                    localObject = new HashMap();
                    ((Map)localObject).put("deviceId", str);
                    ((Map)localObject).put("base64Data", Base64.encodeToString(arrayOfByte, 2));
                    ap.f(new f.4(localf, l.a.b("onReceiveDataFromWXDevice", (Map)localObject, localf.Cjz, localf.CjA)));
                  }
                  AppMethodBeat.o(79959);
                }
              });
              continue;
              ap.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(79960);
                  if ((this.Cyc == null) || (this.Cyc.isFinishing()))
                  {
                    AppMethodBeat.o(79960);
                    return;
                  }
                  com.tencent.mm.plugin.webview.c.f localf;
                  HashMap localHashMap;
                  if (localf != null)
                  {
                    localf = localf;
                    String str = this.Cyl;
                    boolean bool = this.Cyq;
                    if (!localf.Apr)
                    {
                      ac.e("MicroMsg.JsApiHandler", "onWXDeviceBindStateChange fail, not ready");
                      AppMethodBeat.o(79960);
                      return;
                    }
                    ac.i("MicroMsg.JsApiHandler", "onWXDeviceBindStateChange: device id = %s, isBound = %s", new Object[] { str, Boolean.valueOf(bool) });
                    if (bs.isNullOrNil(str))
                    {
                      ac.e("MicroMsg.JsApiHandler", "parameter error!!!");
                      AppMethodBeat.o(79960);
                      return;
                    }
                    localHashMap = new HashMap();
                    localHashMap.put("deviceId", str);
                    if (!bool) {
                      break label180;
                    }
                    localHashMap.put("state", "bind");
                  }
                  for (;;)
                  {
                    ap.f(new f.5(localf, l.a.b("onWXDeviceBindStateChange", localHashMap, localf.Cjz, localf.CjA)));
                    AppMethodBeat.o(79960);
                    return;
                    label180:
                    localHashMap.put("state", "unbind");
                  }
                }
              });
              continue;
              ap.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(79961);
                  if ((this.Cyc == null) || (this.Cyc.isFinishing()))
                  {
                    AppMethodBeat.o(79961);
                    return;
                  }
                  com.tencent.mm.plugin.webview.c.f localf;
                  HashMap localHashMap;
                  if (localf != null)
                  {
                    localf = localf;
                    boolean bool = this.Cyr;
                    if (!localf.Apr)
                    {
                      ac.e("MicroMsg.JsApiHandler", "onWXDeviceBTStateChange fail, not ready");
                      AppMethodBeat.o(79961);
                      return;
                    }
                    ac.i("MicroMsg.JsApiHandler", "onWXDeviceBTStateChange: state = %s", new Object[] { Boolean.valueOf(bool) });
                    localHashMap = new HashMap();
                    if (!bool) {
                      break label137;
                    }
                    localHashMap.put("state", "on");
                  }
                  for (;;)
                  {
                    ap.f(new f.6(localf, l.a.b("onWXDeviceBluetoothStateChange", localHashMap, localf.Cjz, localf.CjA)));
                    AppMethodBeat.o(79961);
                    return;
                    label137:
                    localHashMap.put("state", "off");
                  }
                }
              });
              continue;
              ap.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(79962);
                  if ((this.Cyc == null) || (this.Cyc.isFinishing()))
                  {
                    AppMethodBeat.o(79962);
                    return;
                  }
                  com.tencent.mm.plugin.webview.c.f localf;
                  HashMap localHashMap;
                  if (localf != null)
                  {
                    localf = localf;
                    boolean bool = this.Cyr;
                    if (!localf.Apr)
                    {
                      ac.e("MicroMsg.JsApiHandler", "onWXDeviceLanStateChange fail, not ready");
                      AppMethodBeat.o(79962);
                      return;
                    }
                    ac.i("MicroMsg.JsApiHandler", "onWXDeviceLanStateChange: state = %s", new Object[] { Boolean.valueOf(bool) });
                    localHashMap = new HashMap();
                    if (!bool) {
                      break label137;
                    }
                    localHashMap.put("state", "on");
                  }
                  for (;;)
                  {
                    ap.f(new f.7(localf, l.a.b("onWXDeviceLanStateChange", localHashMap, localf.Cjz, localf.CjA)));
                    AppMethodBeat.o(79962);
                    return;
                    label137:
                    localHashMap.put("state", "off");
                  }
                }
              });
              continue;
              ap.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(79963);
                  if ((this.Cyc == null) || (this.Cyc.isFinishing()))
                  {
                    AppMethodBeat.o(79963);
                    return;
                  }
                  if (localf != null) {
                    localf.aBo(this.val$message);
                  }
                  AppMethodBeat.o(79963);
                }
              });
              continue;
              ap.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(79964);
                  if ((this.Cyc == null) || (this.Cyc.isFinishing()))
                  {
                    AppMethodBeat.o(79964);
                    return;
                  }
                  if (localf != null) {
                    localf.a(this.jkg, this.Cys, this.Cyt, this.hFn, this.Cyu, this.Cyv);
                  }
                  AppMethodBeat.o(79964);
                }
              });
              continue;
              if ((localObject1 != null) && (!((WebViewUI)localObject1).isFinishing()))
              {
                ((WebViewUI)localObject1).n(paramInt, paramBundle);
                continue;
                ((WebViewUI)localObject1).y(paramInt, paramBundle);
                continue;
                localObject2 = paramBundle.getStringArray("msgIds");
                localObject3 = paramBundle.getStringArray("contents");
                localObject4 = paramBundle.getStringArray("senders");
                localObject5 = paramBundle.getIntArray("msgTypes");
                paramBundle = paramBundle.getIntArray("msgTimes");
                localObject6 = new JSONArray();
                if (localObject2 == null) {
                  paramInt = 0;
                }
                for (;;)
                {
                  int i = 0;
                  label2128:
                  if (i < paramInt) {
                    try
                    {
                      JSONObject localJSONObject = new JSONObject();
                      localJSONObject.put("newMsgId", localObject2[i]);
                      localJSONObject.put("content", localObject3[i]);
                      localJSONObject.put("sender", localObject4[i]);
                      localJSONObject.put("msgType", localObject5[i]);
                      localJSONObject.put("msgTime", paramBundle[i]);
                      ((JSONArray)localObject6).put(localJSONObject);
                      i += 1;
                      break label2128;
                      paramInt = localObject2.length;
                    }
                    catch (JSONException localJSONException)
                    {
                      for (;;)
                      {
                        ac.e("MicroMsg.WebViewStubCallbackAIDLStub", "GetMsgProofItems exception " + localJSONException.getMessage());
                      }
                    }
                  }
                }
                ap.f(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(79965);
                    if ((this.Cyc == null) || (this.Cyc.isFinishing()))
                    {
                      AppMethodBeat.o(79965);
                      return;
                    }
                    if (localf != null)
                    {
                      com.tencent.mm.plugin.webview.c.f localf = localf;
                      JSONArray localJSONArray = this.val$jsonArray;
                      if (!localf.Apr)
                      {
                        ac.e("MicroMsg.JsApiHandler", "not ready");
                        AppMethodBeat.o(79965);
                        return;
                      }
                      if (localJSONArray == null)
                      {
                        ac.e("MicroMsg.JsApiHandler", "onGetMsgProofItems fail, not ready");
                        AppMethodBeat.o(79965);
                        return;
                      }
                      ac.i("MicroMsg.JsApiHandler", "onGetMsgProofItems success, ready");
                      HashMap localHashMap = new HashMap();
                      localHashMap.put("msgs", localJSONArray);
                      ap.f(new f.63(localf, l.a.b("onGetMsgProofItems", localHashMap, localf.Cjz, localf.CjA)));
                    }
                    AppMethodBeat.o(79965);
                  }
                });
                continue;
                ap.f(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(79967);
                    if ((this.Cyc == null) || (this.Cyc.isFinishing()))
                    {
                      AppMethodBeat.o(79967);
                      return;
                    }
                    if (localf != null) {
                      localf.aBr(this.Cyw);
                    }
                    AppMethodBeat.o(79967);
                  }
                });
                continue;
                ap.f(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(79968);
                    if ((this.Cyc == null) || (this.Cyc.isFinishing()))
                    {
                      AppMethodBeat.o(79968);
                      return;
                    }
                    String str1;
                    String str2;
                    Object localObject1;
                    Object localObject2;
                    boolean bool;
                    if (paramBundle != null)
                    {
                      str1 = paramBundle.getString("key_bag_icon");
                      this.Cyc.CAp.setIcon(bs.nullAsNil(str1));
                      this.Cyc.CAr.SN(paramBundle.getString("key_bag_icon"));
                      str2 = paramBundle.getString("key_brand_name");
                      localObject1 = paramBundle.getString("key_brand_user_name");
                      str1 = paramBundle.getString("key_title");
                      if (!bs.isNullOrNil((String)localObject1)) {
                        this.Cyc.getIntent().putExtra("srcUsername", (String)localObject1);
                      }
                      ac.i("FloatBall", "currentMpInfo, brandName:%s, title:%s", new Object[] { str2, str1 });
                      if (this.Cyc.CAq != null)
                      {
                        localObject1 = paramBundle;
                        if (localObject1 != null)
                        {
                          localObject2 = ((Bundle)localObject1).getString("key_url");
                          if (!bs.isNullOrNil((String)localObject2)) {
                            break label340;
                          }
                          ac.w("MicroMsg.WebViewUIStyleHelper", "updateCurrentInfo url is null");
                        }
                      }
                      if (this.Cyc.CAi != null)
                      {
                        localObject1 = this.Cyc.CAi;
                        localObject2 = paramBundle;
                        if (localObject2 != null)
                        {
                          bool = ((Bundle)localObject2).getBoolean("key_forbidForward");
                          h.Cxp.put(h.Tk(((h)localObject1).lUn), Boolean.valueOf(bool));
                        }
                      }
                      if ((!bs.isNullOrNil(str1)) || (this.Cyc.getMMTitle() == null)) {
                        break label504;
                      }
                      str1 = this.Cyc.getMMTitle().toString();
                    }
                    label340:
                    label504:
                    for (;;)
                    {
                      if (!bs.isNullOrNil(str1))
                      {
                        this.Cyc.CAr.SO(str1);
                        this.Cyc.CAp.setTitle(str1);
                      }
                      for (;;)
                      {
                        ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).e(this.Cyc.CAp);
                        AppMethodBeat.o(79968);
                        return;
                        ac.d("MicroMsg.WebViewUIStyleHelper", "updateCurrentInfo url %s", new Object[] { localObject2 });
                        localObject2 = n.Tk((String)localObject2);
                        Bundle localBundle = (Bundle)n.Cxp.get(localObject2);
                        if (localBundle == null)
                        {
                          n.Cxp.put(localObject2, localObject1);
                          break;
                        }
                        if (localBundle.getBoolean("key_current_info_show")) {}
                        for (bool = true;; bool = false)
                        {
                          ((Bundle)localObject1).putBoolean("key_current_info_show", bool);
                          n.Cxp.put(localObject2, localObject1);
                          break;
                        }
                        if (bs.isNullOrNil(this.Cyc.CAr.getName())) {
                          this.Cyc.CAr.SO(str2);
                        }
                        if ((bs.isNullOrNil(this.Cyc.CAp.title)) && (!bs.isNullOrNil(str2))) {
                          this.Cyc.CAp.setTitle(str2);
                        }
                      }
                    }
                  }
                });
                continue;
                paramBundle = paramBundle.getString("service_click_tid");
                ac.i("MicroMsg.WebViewStubCallbackAIDLStub", "on service click, update tid = %s", new Object[] { paramBundle });
                ((WebViewUI)localObject1).CAn = paramBundle;
                ((WebViewUI)localObject1).CAo = System.currentTimeMillis();
                ap.f(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(79969);
                    if ((this.Cyc == null) || (this.Cyc.isFinishing()))
                    {
                      AppMethodBeat.o(79969);
                      return;
                    }
                    if (this.Cyc.nKq != null)
                    {
                      com.tencent.mm.plugin.normsg.a.b.vor.a(this.Cyc.nKq, sp.class);
                      if (this.Cyc.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).getBoolean("forceTrigger", false))
                      {
                        ac.i("MicroMsg.WebViewStubCallbackAIDLStub", "on service click, test");
                        com.tencent.mm.sdk.b.a.GpY.l(new sp());
                      }
                    }
                    AppMethodBeat.o(79969);
                  }
                });
                continue;
                ap.f(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(79970);
                    if ((this.Cyc == null) || (this.Cyc.isFinishing()))
                    {
                      AppMethodBeat.o(79970);
                      return;
                    }
                    h localh = this.Cyc.CAi;
                    Object localObject = paramBundle;
                    ac.i("MicroMsg.WebViewLongClickHelper", "onFetchQrCodeResp");
                    int i = ((Bundle)localObject).getInt("key_resp_ret", -1);
                    localObject = ((Bundle)localObject).getByteArray("key_resp_item_bytes");
                    localh.kYG.q(i, (byte[])localObject);
                    AppMethodBeat.o(79970);
                  }
                });
                continue;
                ap.f(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(79971);
                    if ((this.Cyc == null) || (this.Cyc.isFinishing()))
                    {
                      AppMethodBeat.o(79971);
                      return;
                    }
                    if (localf != null)
                    {
                      com.tencent.mm.plugin.webview.c.f localf = localf;
                      String str = this.Cyx;
                      int i = this.Cyy;
                      if (!localf.Apr)
                      {
                        ac.e("MicroMsg.JsApiHandler", "not ready");
                        AppMethodBeat.o(79971);
                        return;
                      }
                      HashMap localHashMap = new HashMap();
                      localHashMap.put("postId", str);
                      localHashMap.put("result", Integer.valueOf(i));
                      ap.f(new f.66(localf, l.a.b("onPublishHaowanEnd", localHashMap, localf.Cjz, localf.CjA)));
                    }
                    AppMethodBeat.o(79971);
                  }
                });
                continue;
                ap.f(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(79972);
                    if ((this.Cyc == null) || (this.Cyc.isFinishing()))
                    {
                      AppMethodBeat.o(79972);
                      return;
                    }
                    if (localf != null)
                    {
                      com.tencent.mm.plugin.webview.c.f localf = localf;
                      String str = this.Cyx;
                      float f = this.lOi;
                      if (!localf.Apr)
                      {
                        ac.e("MicroMsg.JsApiHandler", "not ready");
                        AppMethodBeat.o(79972);
                        return;
                      }
                      HashMap localHashMap = new HashMap();
                      localHashMap.put("postId", str);
                      localHashMap.put("percent", Float.valueOf(f));
                      ap.f(new f.67(localf, l.a.b("onPublishHaowanProgress", localHashMap, localf.Cjz, localf.CjA)));
                    }
                    AppMethodBeat.o(79972);
                  }
                });
              }
            }
          }
        }
      }
    }
  }
  
  public final String getCurrentUrl()
  {
    AppMethodBeat.i(80014);
    if ((this.CsH.get() == null) || (((WebViewUI)this.CsH.get()).isFinishing()))
    {
      AppMethodBeat.o(80014);
      return null;
    }
    String str = ((WebViewUI)this.CsH.get()).eyJ();
    AppMethodBeat.o(80014);
    return str;
  }
  
  public final Bundle k(final int paramInt, final Bundle paramBundle)
  {
    AppMethodBeat.i(80028);
    ac.i("MicroMsg.WebViewStubCallbackAIDLStub", "invokeAsResult, actionCode = ".concat(String.valueOf(paramInt)));
    final Bundle localBundle = new Bundle();
    if ((this.CsH.get() == null) || (((WebViewUI)this.CsH.get()).isFinishing()))
    {
      AppMethodBeat.o(80028);
      return localBundle;
    }
    Object localObject1 = ((WebViewUI)this.CsH.get()).kYu;
    switch (paramInt)
    {
    default: 
      ac.e("MicroMsg.WebViewStubCallbackAIDLStub", "undefine action code!!!");
    }
    for (;;)
    {
      AppMethodBeat.o(80028);
      return localBundle;
      ((WebViewUI)this.CsH.get()).CAe = true;
      continue;
      localObject1 = new com.tencent.mm.g.a.j();
      ((com.tencent.mm.g.a.j)localObject1).cYw.context = ((WebViewUI)this.CsH.get()).getContext();
      ((com.tencent.mm.g.a.j)localObject1).cYw.actionCode = paramInt;
      if (4003 == paramInt)
      {
        paramBundle = paramBundle.getString("apdu");
        ((com.tencent.mm.g.a.j)localObject1).cYw.cYy = paramBundle;
      }
      Object localObject2;
      final boolean bool1;
      final boolean bool2;
      for (;;)
      {
        ((com.tencent.mm.g.a.j)localObject1).callback = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(79982);
            localBundle.putAll(this.CyB.cYx.cYB);
            AppMethodBeat.o(79982);
          }
        };
        com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject1);
        break;
        if (4004 == paramInt)
        {
          localObject2 = paramBundle.getString("apdus");
          bool1 = paramBundle.getBoolean("breakIfFail", true);
          bool2 = paramBundle.getBoolean("breakIfTrue", false);
          ((com.tencent.mm.g.a.j)localObject1).cYw.cYy = ((String)localObject2);
          ((com.tencent.mm.g.a.j)localObject1).cYw.cYz = bool1;
          ((com.tencent.mm.g.a.j)localObject1).cYw.cYA = bool2;
        }
      }
      localBundle.putString("KPublisherId", ((WebViewUI)this.CsH.get()).dvr);
      paramBundle = getIntent();
      if (paramBundle != null)
      {
        paramInt = aAT(getIntent().getStringExtra("geta8key_username"));
        localBundle.putString("preChatName", paramBundle.getStringExtra("preChatName"));
        localBundle.putInt("preMsgIndex", paramBundle.getIntExtra("preMsgIndex", 0));
        localBundle.putString("prePublishId", paramBundle.getStringExtra("prePublishId"));
        localBundle.putString("preUsername", paramBundle.getStringExtra("preUsername"));
        localBundle.putInt("getA8KeyScene", paramInt);
        localBundle.putString("referUrl", ((WebViewUI)this.CsH.get()).eDT());
        localBundle.putString("url", ((WebViewUI)this.CsH.get()).eyJ());
        localBundle.putString("rawUrl", ((WebViewUI)this.CsH.get()).bLL());
        localBundle.putInt("preChatTYPE", getIntent().getIntExtra("preChatTYPE", 0));
        localBundle.putString("KAppId", paramBundle.getStringExtra("KAppId"));
        paramBundle = (WebViewUI)this.CsH.get();
        if (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).isMpUrl(paramBundle.bLL()))
        {
          localBundle.putInt("_DATA_CENTER_ITEM_SHOW_TYPE", paramBundle.Czp);
          continue;
          localBundle.putString("KSessionId", ((WebViewUI)this.CsH.get()).sessionId);
          localBundle.putString("KUserAgent", ((WebViewUI)this.CsH.get()).getUserAgent());
          localBundle.putString("KUrl", ((WebViewUI)this.CsH.get()).eyJ());
          paramInt = aAT(getIntent().getStringExtra("geta8key_username"));
          if ((paramInt == 7) || (paramInt == 56))
          {
            localBundle.putString("geta8key_username", getIntent().getStringExtra("geta8key_username"));
            continue;
            paramBundle = getIntent();
            if (paramBundle != null)
            {
              localBundle.putString("publishIdPrefix", paramBundle.getStringExtra("publishIdPrefix"));
              localBundle.putString("reportSessionId", paramBundle.getStringExtra("reportSessionId"));
              continue;
              localBundle.putInt("pay_channel", getIntent().getIntExtra("pay_channel", -1));
              ac.i("MicroMsg.WebViewStubCallbackAIDLStub", "key value: pay channel(%d)", new Object[] { Integer.valueOf(getIntent().getIntExtra("pay_channel", -1)) });
              continue;
              localBundle.putInt("scene", getIntent().getIntExtra("scene", -1));
              ac.i("MicroMsg.WebViewStubCallbackAIDLStub", "Key value: Scene(%d)", new Object[] { Integer.valueOf(getIntent().getIntExtra("scene", 0)) });
              continue;
              paramInt = getIntent().getIntExtra("geta8key_scene", 0);
              localBundle.putInt("geta8key_scene", paramInt);
              ac.i("MicroMsg.WebViewStubCallbackAIDLStub", "Key value: getA8KeyScene(%d)", new Object[] { Integer.valueOf(paramInt) });
              continue;
              if (((WebViewUI)this.CsH.get()).kYt.isSDCardAvailable())
              {
                long l = bh.eVQ();
                ac.i("MicroMsg.WebViewStubCallbackAIDLStub", "availableSize = %d", new Object[] { Long.valueOf(l) });
                if (l < 524288000L)
                {
                  ac.e("MicroMsg.WebViewStubCallbackAIDLStub", "available size not enough");
                  label1465:
                  paramInt = FactoryProxyManager.getPlayManager().init(ai.getContext(), null);
                }
              }
              for (;;)
              {
                if (paramInt == 0)
                {
                  if (((WebViewUI)this.CsH.get()).CAk == null)
                  {
                    ((WebViewUI)this.CsH.get()).CAk = new f((WebViewUI)this.CsH.get());
                    FactoryProxyManager.getPlayManager().setUtilsObject(((WebViewUI)this.CsH.get()).CAk);
                  }
                  i = FactoryProxyManager.getPlayManager().getLocalServerPort();
                  ac.i("MicroMsg.WebViewStubCallbackAIDLStub", "webview video init result = %d, local port = %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
                  paramBundle = ((WebViewUI)this.CsH.get()).eDF();
                  if ((i <= 0) || (i > 65535)) {
                    ac.e("MicroMsg.WebViewResourceInterrupter", "err port = %d", new Object[] { Integer.valueOf(i) });
                  }
                  if (!paramBundle.CqN.contains(Integer.valueOf(i))) {
                    paramBundle.CqN.add(Integer.valueOf(i));
                  }
                }
                localBundle.putInt("webview_video_proxy_init", paramInt);
                break;
                paramBundle = new com.tencent.mm.vfs.e(com.tencent.mm.plugin.webview.a.CcB);
                bool1 = true;
                if (!paramBundle.exists())
                {
                  bool1 = paramBundle.mkdirs();
                  ac.i("MicroMsg.WebViewStubCallbackAIDLStub", "create proxy cache path : %s, %b", new Object[] { com.tencent.mm.vfs.q.B(paramBundle.fxV()), Boolean.valueOf(bool1) });
                }
                if (!bool1) {
                  break label1465;
                }
                paramInt = FactoryProxyManager.getPlayManager().init(ai.getContext(), com.tencent.mm.b.q.k(com.tencent.mm.vfs.q.B(paramBundle.fxV()), false));
                FactoryProxyManager.getPlayManager().setMaxStorageSize(200L);
                continue;
                ac.i("MicroMsg.WebViewStubCallbackAIDLStub", "sdcard not available");
                paramInt = FactoryProxyManager.getPlayManager().init(ai.getContext(), null);
              }
              localObject1 = paramBundle.getString("webview_video_proxy_cdn_urls");
              localObject2 = paramBundle.getString("webview_video_proxy_fileId");
              paramInt = paramBundle.getInt("webview_video_proxy_file_size");
              int i = paramBundle.getInt("webview_video_proxy_file_duration");
              int j = paramBundle.getInt("webview_video_proxy_file_type");
              int k = FactoryProxyManager.getPlayManager().startPlay((String)localObject1, j, (String)localObject2, paramInt, i);
              paramBundle = FactoryProxyManager.getPlayManager().buildPlayURLMp4(k);
              ac.i("MicroMsg.WebViewStubCallbackAIDLStub", "cdnurls = %s, filedId = %s, fileSize = %d, fileDuration = %d, fileType = %d, playDataId = %d, localUrl = %s", new Object[] { localObject1, localObject2, Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), paramBundle });
              localBundle.putInt("webview_video_proxy_play_data_id", k);
              localBundle.putString("webview_video_proxy_local_url", paramBundle);
              continue;
              paramInt = paramBundle.getInt("webview_video_proxy_play_data_id");
              ac.i("MicroMsg.WebViewStubCallbackAIDLStub", "webview proxy stop play, play id = %d", new Object[] { Integer.valueOf(paramInt) });
              if (paramInt > 0)
              {
                FactoryProxyManager.getPlayManager().stopPlay(paramInt);
                continue;
                paramInt = paramBundle.getInt("webview_video_proxy_play_state");
                FactoryProxyManager.getPlayManager().setPlayerState(paramInt);
                continue;
                paramInt = paramBundle.getInt("webview_video_proxy_net_state");
                FactoryProxyManager.getPlayManager().setNetWorkState(paramInt);
                continue;
                paramInt = paramBundle.getInt("webview_video_proxy_play_data_id");
                i = paramBundle.getInt("webview_video_proxy_play_remain_time");
                FactoryProxyManager.getPlayManager().setRemainTime(paramInt, i);
                continue;
                paramInt = paramBundle.getInt("webview_video_proxy_play_data_id");
                i = paramBundle.getInt("webview_video_proxy_preload_duration");
                ac.i("MicroMsg.WebViewStubCallbackAIDLStub", "playid = %d, duration = %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
                localBundle.putInt("webview_video_proxy_pre_load_result", FactoryProxyManager.getPlayManager().preLoad(paramInt, i));
                continue;
                if (paramBundle.getInt("webview_disable_bounce_scroll_top", 0) > 0)
                {
                  ap.f(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(79983);
                      if ((l.a(l.this).get() == null) || (((WebViewUI)l.a(l.this).get()).isFinishing()))
                      {
                        AppMethodBeat.o(79983);
                        return;
                      }
                      ((WebViewUI)l.a(l.this).get()).CAF.ut(true);
                      AppMethodBeat.o(79983);
                    }
                  });
                  continue;
                  ap.f(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(79984);
                      if ((l.a(l.this).get() == null) || (((WebViewUI)l.a(l.this).get()).isFinishing()))
                      {
                        AppMethodBeat.o(79984);
                        return;
                      }
                      Object localObject = (WebViewUI)l.a(l.this).get();
                      ((WebViewUI)localObject).CAF.CxJ = new WebViewUI.3((WebViewUI)localObject);
                      localObject = ((WebViewUI)localObject).CAF;
                      ((j)localObject).jCl = true;
                      if (((j)localObject).CxL != null)
                      {
                        ((j)localObject).CxL.setVisibility(0);
                        ((j)localObject).CxL.setMMOverScrollOffsetListener((LogoWebViewWrapper.b)localObject);
                        ((j)localObject).CxL.setFastScrollBack(true);
                        ((j)localObject).CxL.ut(false);
                        ((j)localObject).CxL.setReleaseTargetHeight(((j)localObject).CxM);
                      }
                      if (((j)localObject).CxK != null)
                      {
                        ((j)localObject).CxK.setWillNotDraw(true);
                        ((j)localObject).CxK.setImageResource(j.CxN);
                        ((j)localObject).CxK.setVisibility(0);
                        ((j)localObject).CxK.setAlpha(0.0F);
                        ((j)localObject).CxK.setWillNotDraw(false);
                        ((j)localObject).CxK.invalidate();
                      }
                      ((j)localObject).eDy();
                      AppMethodBeat.o(79984);
                    }
                  });
                  continue;
                  ap.f(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(79985);
                      if ((l.a(l.this).get() == null) || (((WebViewUI)l.a(l.this).get()).isFinishing()))
                      {
                        AppMethodBeat.o(79985);
                        return;
                      }
                      ((WebViewUI)l.a(l.this).get()).CAF.stopLoading();
                      AppMethodBeat.o(79985);
                    }
                  });
                  continue;
                  ap.f(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(79986);
                      if ((l.a(l.this).get() == null) || (((WebViewUI)l.a(l.this).get()).isFinishing()))
                      {
                        AppMethodBeat.o(79986);
                        return;
                      }
                      ((WebViewUI)l.a(l.this).get()).CAF.eDw();
                      AppMethodBeat.o(79986);
                    }
                  });
                  continue;
                  ap.f(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(79987);
                      if ((l.a(l.this).get() == null) || (((WebViewUI)l.a(l.this).get()).isFinishing()))
                      {
                        AppMethodBeat.o(79987);
                        return;
                      }
                      ((WebViewUI)l.a(l.this).get()).CAF.startLoading();
                      AppMethodBeat.o(79987);
                    }
                  });
                  continue;
                  ap.f(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(79989);
                      if ((l.a(l.this).get() == null) || (((WebViewUI)l.a(l.this).get()).isFinishing()))
                      {
                        AppMethodBeat.o(79989);
                        return;
                      }
                      WebViewUI localWebViewUI = (WebViewUI)l.a(l.this).get();
                      if (localWebViewUI.nKq != null) {
                        localWebViewUI.nKq.evaluateJavascript("javascript:(function(){return window.getComputedStyle(document.body,null).backgroundColor})()", new WebViewUI.4(localWebViewUI));
                      }
                      AppMethodBeat.o(79989);
                    }
                  });
                  continue;
                  ap.f(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(79990);
                      if ((l.a(l.this).get() == null) || (((WebViewUI)l.a(l.this).get()).isFinishing()))
                      {
                        AppMethodBeat.o(79990);
                        return;
                      }
                      ((WebViewUI)l.a(l.this).get()).ft(this.CyC, this.CyD);
                      AppMethodBeat.o(79990);
                    }
                  });
                  continue;
                  if ((this.CsH.get() != null) && (!((WebViewUI)this.CsH.get()).isFinishing()))
                  {
                    localBundle.putInt("height", ((WebViewUI)this.CsH.get()).eDX());
                    continue;
                    localObject1 = paramBundle.getString("set_page_title_text");
                    paramBundle = paramBundle.getString("set_page_title_color");
                    localObject2 = (WebViewUI)this.CsH.get();
                    if ((com.tencent.mm.compatible.util.d.kZ(21)) && (((WebViewUI)localObject2).eDQ())) {}
                    for (paramInt = -16777216;; paramInt = ((WebViewUI)localObject2).getResources().getColor(2131099874))
                    {
                      e.fr(paramBundle, paramInt);
                      ap.f(new Runnable()
                      {
                        public final void run()
                        {
                          AppMethodBeat.i(79991);
                          if ((l.a(l.this).get() == null) || (((WebViewUI)l.a(l.this).get()).isFinishing()))
                          {
                            AppMethodBeat.o(79991);
                            return;
                          }
                          if (!((WebViewUI)l.a(l.this).get()).xkQ)
                          {
                            AppMethodBeat.o(79991);
                            return;
                          }
                          if (this.cNi != null) {
                            ((WebViewUI)l.a(l.this).get()).setMMTitle(this.cNi);
                          }
                          AppMethodBeat.o(79991);
                        }
                      });
                      break;
                    }
                    localObject2 = paramBundle.getString("set_navigation_bar_buttons_text");
                    localObject1 = paramBundle.getString("set_navigation_bar_buttons_icon_data");
                    bool1 = paramBundle.getBoolean("set_navigation_bar_buttons_hide_right_button", false);
                    bool2 = paramBundle.getBoolean("set_navigation_bar_right_style", false);
                    if (!bs.isNullOrNil((String)localObject1)) {}
                    for (;;)
                    {
                      try
                      {
                        localObject1 = e.aDg((String)localObject1);
                        paramInt = e.fr(paramBundle.getString("set_navigation_bar_buttons_left_text_color"), -16777216);
                        ap.f(new Runnable()
                        {
                          public final void run()
                          {
                            AppMethodBeat.i(79992);
                            if ((l.a(l.this).get() == null) || (((WebViewUI)l.a(l.this).get()).isFinishing()))
                            {
                              AppMethodBeat.o(79992);
                              return;
                            }
                            if (bool2) {
                              ((WebViewUI)l.a(l.this).get()).CAr.eEP();
                            }
                            if (bool1)
                            {
                              ((WebViewUI)l.a(l.this).get()).ux(true);
                              AppMethodBeat.o(79992);
                              return;
                            }
                            Object localObject = ((WebViewUI)l.a(l.this).get()).eyJ();
                            if (!bs.isNullOrNil((String)localObject)) {}
                            for (localObject = (Boolean)((WebViewUI)l.a(l.this).get()).CzM.get(localObject);; localObject = null)
                            {
                              boolean bool;
                              if (localObject == null)
                              {
                                bool = false;
                                ((WebViewUI)l.a(l.this).get()).ux(Boolean.valueOf(bool).booleanValue());
                                if ((this.Cms == null) || (this.Cms.isRecycled())) {
                                  break label307;
                                }
                                ((WebViewUI)l.a(l.this).get()).b(this.fLm, new BitmapDrawable(((WebViewUI)l.a(l.this).get()).getResources(), this.Cms));
                                if (this.Cmt) {
                                  ((WebViewUI)l.a(l.this).get()).updateOptionMenuListener(0, new MenuItem.OnMenuItemClickListener()
                                  {
                                    public final boolean onMenuItemClick(MenuItem paramAnonymous2MenuItem)
                                    {
                                      AppMethodBeat.i(188381);
                                      ac.d("MicroMsg.WebViewStubCallbackAIDLStub", "click item: %s", new Object[] { Integer.valueOf(paramAnonymous2MenuItem.getItemId()) });
                                      ((WebViewUI)l.a(l.this).get()).Cjc.ezT();
                                      AppMethodBeat.o(188381);
                                      return false;
                                    }
                                  }, null);
                                }
                              }
                              for (;;)
                              {
                                ((WebViewUI)l.a(l.this).get()).VJ(paramInt);
                                AppMethodBeat.o(79992);
                                return;
                                bool = ((Boolean)localObject).booleanValue();
                                break;
                                label307:
                                if (!bs.isNullOrNil(this.fLm))
                                {
                                  if (this.Cmv == -1) {
                                    ((WebViewUI)l.a(l.this).get()).addTextOptionMenu(0, this.fLm, new MenuItem.OnMenuItemClickListener()
                                    {
                                      public final boolean onMenuItemClick(MenuItem paramAnonymous2MenuItem)
                                      {
                                        AppMethodBeat.i(188382);
                                        ac.d("MicroMsg.WebViewStubCallbackAIDLStub", "click item: %s", new Object[] { Integer.valueOf(paramAnonymous2MenuItem.getItemId()) });
                                        ((WebViewUI)l.a(l.this).get()).Cjc.ezT();
                                        AppMethodBeat.o(188382);
                                        return false;
                                      }
                                    });
                                  } else {
                                    ((WebViewUI)l.a(l.this).get()).addTextOptionMenu(0, this.fLm, this.Cmv, new MenuItem.OnMenuItemClickListener()
                                    {
                                      public final boolean onMenuItemClick(MenuItem paramAnonymous2MenuItem)
                                      {
                                        AppMethodBeat.i(188383);
                                        ac.d("MicroMsg.WebViewStubCallbackAIDLStub", "click item: %s", new Object[] { Integer.valueOf(paramAnonymous2MenuItem.getItemId()) });
                                        ((WebViewUI)l.a(l.this).get()).Cjc.ezT();
                                        AppMethodBeat.o(188383);
                                        return false;
                                      }
                                    });
                                  }
                                }
                                else {
                                  ((WebViewUI)l.a(l.this).get()).addIconOptionMenu(0, ((WebViewUI)l.a(l.this).get()).eEi(), new MenuItem.OnMenuItemClickListener()
                                  {
                                    public final boolean onMenuItemClick(MenuItem paramAnonymous2MenuItem)
                                    {
                                      AppMethodBeat.i(188384);
                                      ac.d("MicroMsg.WebViewStubCallbackAIDLStub", "click item: %s", new Object[] { Integer.valueOf(paramAnonymous2MenuItem.getItemId()) });
                                      ((WebViewUI)l.a(l.this).get()).Cjc.ezT();
                                      AppMethodBeat.o(188384);
                                      return false;
                                    }
                                  }, ((WebViewUI)l.a(l.this).get()).CAL);
                                }
                              }
                            }
                          }
                        });
                      }
                      catch (Exception localException)
                      {
                        localObject1 = null;
                        ac.e("MicroMsg.WebViewStubCallbackAIDLStub", "setNavigationBarButtons, decode base64 image, exception = %s", new Object[] { localException });
                        continue;
                      }
                      localObject1 = null;
                    }
                    ap.f(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(79997);
                        if ((l.a(l.this).get() == null) || (((WebViewUI)l.a(l.this).get()).isFinishing()))
                        {
                          AppMethodBeat.o(79997);
                          return;
                        }
                        boolean bool = paramBundle.getBoolean("enable_fullscreen_params_enable", false);
                        if (l.b(l.this) != null) {
                          l.b(l.this).removeExtra("show_full_screen");
                        }
                        ((WebViewUI)l.a(l.this).get()).aC(bool, false);
                        AppMethodBeat.o(79997);
                      }
                    });
                    continue;
                    if ((this.CsH.get() == null) || (((WebViewUI)this.CsH.get()).isFinishing()))
                    {
                      localBundle.putBoolean("isFullScreen", false);
                    }
                    else
                    {
                      localBundle.putBoolean("isFullScreen", ((WebViewUI)this.CsH.get()).Czc);
                      continue;
                      ap.f(new Runnable()
                      {
                        public final void run()
                        {
                          AppMethodBeat.i(79998);
                          if ((l.a(l.this).get() == null) || (((WebViewUI)l.a(l.this).get()).isFinishing()))
                          {
                            AppMethodBeat.o(79998);
                            return;
                          }
                          if ((((WebViewUI)l.a(l.this).get()).CzO != null) && (((WebViewUI)l.a(l.this).get()).CzO.isShowing())) {
                            ((WebViewUI)l.a(l.this).get()).CzO.dismiss();
                          }
                          AppMethodBeat.o(79998);
                        }
                      });
                      continue;
                      ap.f(new Runnable()
                      {
                        public final void run()
                        {
                          AppMethodBeat.i(79999);
                          if ((l.a(l.this).get() == null) || (((WebViewUI)l.a(l.this).get()).isFinishing()))
                          {
                            AppMethodBeat.o(79999);
                            return;
                          }
                          ((WebViewUI)l.a(l.this).get()).CzN = null;
                          AppMethodBeat.o(79999);
                        }
                      });
                      continue;
                      bool1 = paramBundle.getBoolean("clear_webview_cache_clear_cookie", false);
                      ac.i("MicroMsg.WebViewStubCallbackAIDLStub", "includeCookie = %b", new Object[] { Boolean.valueOf(bool1) });
                      paramBundle = new Intent();
                      paramBundle.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE");
                      paramBundle.putExtra("tools_clean_webview_cache_ignore_cookie", bool1);
                      com.tencent.mm.cq.d.bt(paramBundle);
                      continue;
                      if (paramBundle.getString("enterprise_action").equals("enterprise_get_context_bizchat"))
                      {
                        localBundle.putString("enterprise_context_biz", getIntent().getStringExtra("enterprise_biz_name"));
                        localBundle.putLong("enterprise_context_bizchatid", getIntent().getLongExtra("biz_chat_chat_id", -1L));
                        continue;
                        paramInt = e.fr(paramBundle.getString("key_set_bounce_background_color"), ((WebViewUI)this.CsH.get()).getResources().getColor(2131101165));
                        ((WebViewUI)this.CsH.get()).CAF.VH(paramInt);
                        continue;
                        localObject1 = getIntent();
                        if (paramBundle != null)
                        {
                          paramInt = paramBundle.getInt("scene");
                          switch (paramInt)
                          {
                          default: 
                            ac.i("MicroMsg.WebViewStubCallbackAIDLStub", "unknown expose scene: %d", new Object[] { Integer.valueOf(paramInt) });
                          }
                          for (;;)
                          {
                            localBundle.putString("username", ((Intent)localObject1).getStringExtra("k_username"));
                            break;
                            localBundle.putStringArrayList("proof", ((Intent)localObject1).getStringArrayListExtra("k_outside_expose_proof_item_list"));
                            continue;
                            localBundle.putString("newMsgId", com.tencent.mm.plugin.sns.data.q.wW(((Intent)localObject1).getLongExtra("k_expose_msg_id", 0L)));
                            continue;
                            if (!bs.isNullOrNil(((Intent)localObject1).getStringExtra("k_webview_img")))
                            {
                              paramBundle = ((Intent)localObject1).getStringExtra("k_webview_img");
                              localObject2 = com.tencent.mm.vfs.i.aU(paramBundle, 0, (int)com.tencent.mm.vfs.i.aSp(paramBundle));
                              com.tencent.mm.vfs.i.deleteFile(paramBundle);
                              localBundle.putString("webviewImg", Base64.encodeToString((byte[])localObject2, 0));
                            }
                            if (((Intent)localObject1).getStringExtra("k_webview_html") != null) {
                              localBundle.putString("webviewHtml", ((Intent)localObject1).getStringExtra("k_webview_html"));
                            }
                            paramBundle = new StringBuilder();
                            paramBundle.append("<exposecontent>");
                            paramBundle.append("<weburl>");
                            if (((Intent)localObject1).getStringExtra("k_expose_url") != null) {
                              paramBundle.append(((Intent)localObject1).getStringExtra("k_expose_url"));
                            }
                            paramBundle.append("</weburl>");
                            paramBundle.append("<firstJumpUrl>");
                            if (((Intent)localObject1).getStringExtra("k_expose_raw_url") != null) {
                              paramBundle.append(((Intent)localObject1).getStringExtra("k_expose_raw_url"));
                            }
                            paramBundle.append("</firstJumpUrl>");
                            paramBundle.append("<webscence>");
                            paramBundle.append(((Intent)localObject1).getIntExtra("k_expose_web_scene", 0));
                            paramBundle.append("</webscence>");
                            paramBundle.append("</exposecontent>");
                            localBundle.putString("url", paramBundle.toString());
                            continue;
                            localBundle.putString("newMsgId", String.valueOf(((Intent)localObject1).getLongExtra("k_expose_msg_id", 0L)));
                            localBundle.putStringArrayList("proof", ((Intent)localObject1).getStringArrayListExtra("k_outside_expose_proof_item_list"));
                            localBundle.putInt("msgType", ((Intent)localObject1).getIntExtra("k_expose_msg_type", 0));
                          }
                          ap.f(new Runnable()
                          {
                            public final void run()
                            {
                              AppMethodBeat.i(80000);
                              if ((l.a(l.this).get() == null) || (((WebViewUI)l.a(l.this).get()).isFinishing()))
                              {
                                AppMethodBeat.o(80000);
                                return;
                              }
                              ((WebViewUI)l.a(l.this).get()).aJ(paramBundle);
                              AppMethodBeat.o(80000);
                            }
                          });
                          continue;
                          localBundle.putStringArray("webview_get_route_url_list", ((WebViewUI)this.CsH.get()).CAh.eCk());
                          localBundle.putInt("webview_get_route_url_geta8key_scene", aAT(getIntent().getStringExtra("geta8key_username")));
                          localBundle.putString("geta8key_username", getIntent().getStringExtra("geta8key_username"));
                          continue;
                          localObject1 = ((WebViewUI)this.CsH.get()).eyJ();
                          localObject2 = com.tencent.xweb.c.fJa().getCookie((String)localObject1);
                          ac.i("MicroMsg.WebViewStubCallbackAIDLStub", "url = %s, cookie = %s", new Object[] { localObject1, localObject2 });
                          localBundle.putString("cookie", (String)localObject2);
                          localBundle.putFloat("density", bxg());
                          if (paramBundle != null)
                          {
                            localBundle.putString("currentUrlPath", com.tencent.mm.plugin.webview.modeltools.j.aCv(paramBundle.getString("currentPicUrl")));
                            continue;
                            localBundle.putBoolean("from_shortcut", ((WebViewUI)this.CsH.get()).Czu);
                            continue;
                            paramBundle.setClassLoader(WebViewUI.class.getClassLoader());
                            com.tencent.mm.br.d.b((Context)this.CsH.get(), paramBundle.getString("open_ui_with_webview_ui_plugin_name"), paramBundle.getString("open_ui_with_webview_ui_plugin_entry"), new Intent().putExtras(paramBundle.getBundle("open_ui_with_webview_ui_extras")).putExtra("KPublisherId", ((WebViewUI)this.CsH.get()).dvr));
                            continue;
                            localObject1 = paramBundle.getString("traceid");
                            paramBundle = paramBundle.getString("username");
                            k.Cya.kC((String)localObject1, paramBundle);
                            continue;
                            paramBundle = ((WebViewUI)this.CsH.get()).getMMTitle();
                            localObject1 = getCurrentUrl();
                            localBundle.putString("webview_current_url", (String)localObject1);
                            if (paramBundle != null) {}
                            for (paramBundle = paramBundle.toString();; paramBundle = "")
                            {
                              localBundle.putString("webview_current_title", paramBundle);
                              localBundle.putString("webview_current_desc", (String)localObject1);
                              break;
                            }
                            paramBundle = ((WebViewUI)this.CsH.get()).getMMTitle();
                            localObject1 = getCurrentUrl();
                            localObject2 = getIntent();
                            Object localObject4;
                            Object localObject3;
                            if (localObject2 != null)
                            {
                              localBundle.putString("share_report_pre_msg_url", ((Intent)localObject2).getStringExtra("share_report_pre_msg_url"));
                              localBundle.putString("share_report_pre_msg_title", ((Intent)localObject2).getStringExtra("share_report_pre_msg_title"));
                              localBundle.putString("share_report_pre_msg_desc", ((Intent)localObject2).getStringExtra("share_report_pre_msg_desc"));
                              localBundle.putString("share_report_pre_msg_icon_url", ((Intent)localObject2).getStringExtra("share_report_pre_msg_icon_url"));
                              localBundle.putString("share_report_pre_msg_appid", ((Intent)localObject2).getStringExtra("share_report_pre_msg_appid"));
                              localBundle.putInt("share_report_from_scene", ((Intent)localObject2).getIntExtra("share_report_from_scene", 0));
                              localBundle.putString("share_report_biz_username", ((Intent)localObject2).getStringExtra("share_report_biz_username"));
                              localObject2 = ((Intent)localObject2).getBundleExtra("ad_report_bundle");
                              if ((!bs.isNullOrNil((String)localObject1)) && (localObject2 != null) && (!bs.isNullOrNil(((Bundle)localObject2).getString("ad_report_ux_info"))))
                              {
                                localObject4 = Uri.parse((String)localObject1);
                                localObject3 = ((Uri)localObject4).getQueryParameter("mid");
                                localObject4 = ((Uri)localObject4).getQueryParameter("idx");
                                ((Bundle)localObject2).putString("ad_report_mid", (String)localObject3);
                                ((Bundle)localObject2).putString("ad_report_idx", (String)localObject4);
                                localBundle.putBundle("ad_report_bundle", (Bundle)localObject2);
                              }
                            }
                            localBundle.putString("share_report_current_url", (String)localObject1);
                            if (paramBundle != null) {}
                            for (paramBundle = paramBundle.toString();; paramBundle = "")
                            {
                              localBundle.putString("share_report_current_title", paramBundle);
                              break;
                            }
                            if (((WebViewUI)this.CsH.get()).eDB())
                            {
                              localBundle.putString("result", "not_return");
                            }
                            else
                            {
                              localBundle.putString("full_url", bs.nullAsNil(((WebViewUI)this.CsH.get()).nJQ));
                              if ((((WebViewUI)this.CsH.get()).eDC() != null) && (((WebViewUI)this.CsH.get()).eDC().size() != 0))
                              {
                                localBundle.putInt("set_cookie", 1);
                                com.tencent.xweb.d.li(ai.getContext());
                                paramBundle = com.tencent.xweb.c.fJa();
                                localObject1 = ((WebViewUI)this.CsH.get()).eDC().keySet().iterator();
                                while (((Iterator)localObject1).hasNext())
                                {
                                  localObject2 = (String)((Iterator)localObject1).next();
                                  paramBundle.setCookie(bs.aLP(((WebViewUI)this.CsH.get()).nJQ), (String)localObject2 + "=" + (String)((WebViewUI)this.CsH.get()).eDC().get(localObject2));
                                }
                                paramBundle.setCookie(bs.aLP(((WebViewUI)this.CsH.get()).nJQ), "httponly");
                                com.tencent.xweb.d.fJc();
                                com.tencent.xweb.d.sync();
                                ac.i("MicroMsg.WebViewStubCallbackAIDLStub", "cookies:%s", new Object[] { paramBundle.getCookie(bs.aLP(((WebViewUI)this.CsH.get()).nJQ)) });
                              }
                              else
                              {
                                localBundle.putInt("set_cookie", 0);
                                continue;
                                bool1 = paramBundle.getBoolean("add_shortcut_status");
                                if (((WebViewUI)this.CsH.get()).Cjc != null)
                                {
                                  ((WebViewUI)this.CsH.get()).Cjc.uj(bool1);
                                  continue;
                                  localBundle.putBoolean("is_from_keep_top", getIntent().getBooleanExtra("is_from_keep_top", false));
                                  continue;
                                  if (((WebViewUI)this.CsH.get()).Cze != null) {
                                    ((WebViewUI)this.CsH.get()).Cze.disable();
                                  }
                                  ((WebViewUI)this.CsH.get()).screenOrientation = paramBundle.getInt("screen_orientation", -1);
                                  if (((WebViewUI)this.CsH.get()).screenOrientation == 1001)
                                  {
                                    ((WebViewUI)this.CsH.get()).screenOrientation = 0;
                                    if (((WebViewUI)this.CsH.get()).Cze != null)
                                    {
                                      ac.i("MicroMsg.WebViewStubCallbackAIDLStub", "OrientationListener, start listen orientation change");
                                      ((WebViewUI)this.CsH.get()).Cze.enable();
                                    }
                                  }
                                  for (;;)
                                  {
                                    ((WebViewUI)this.CsH.get()).setMMOrientation();
                                    break;
                                    if (((WebViewUI)this.CsH.get()).screenOrientation == 1002)
                                    {
                                      ((WebViewUI)this.CsH.get()).screenOrientation = 1;
                                      if (((WebViewUI)this.CsH.get()).Cze != null)
                                      {
                                        ac.i("MicroMsg.WebViewStubCallbackAIDLStub", "OrientationListener, start listen orientation change");
                                        ((WebViewUI)this.CsH.get()).Cze.enable();
                                      }
                                    }
                                  }
                                  ((WebViewUI)this.CsH.get()).aI(paramBundle);
                                  continue;
                                  localBundle.putInt("web_page_count", WebViewUI.CzZ);
                                  continue;
                                  localBundle.putString("geta8key_data_req_url", ((WebViewUI)this.CsH.get()).bLL());
                                  localBundle.putString("geta8key_data_username", getIntent().getStringExtra("geta8key_username"));
                                  localBundle.putInt("geta8key_data_scene", aAT(getIntent().getStringExtra("geta8key_username")));
                                  localBundle.putInt("geta8key_data_reason", 8);
                                  if (((WebViewUI)this.CsH.get()).nKq.getIsX5Kernel()) {
                                    localBundle.putInt("geta8key_data_flag", 1);
                                  }
                                  for (;;)
                                  {
                                    this.CsH.get();
                                    localBundle.putString("geta8key_data_net_type", ax.cWt());
                                    localBundle.putInt("geta8key_session_id", ((WebViewUI)this.CsH.get()).Czv);
                                    localBundle.putInt("webview_binder_id", ((WebViewUI)this.CsH.get()).eyt());
                                    localBundle.putByteArray("k_a8key_cookie", ((WebViewUI)this.CsH.get()).Czw);
                                    localBundle.putString("geta8key_data_appid", getIntent().getStringExtra("geta8key_open_webview_appid"));
                                    break;
                                    localBundle.putInt("geta8key_data_flag", 0);
                                  }
                                  paramBundle.getString("geta8key_result_req_url");
                                  localObject2 = paramBundle.getString("geta8key_result_full_url");
                                  if (!bs.isNullOrNil((String)localObject2))
                                  {
                                    localObject3 = new JsapiPermissionWrapper(paramBundle.getByteArray("geta8key_result_jsapi_perm_control_bytes"));
                                    localObject4 = new GeneralControlWrapper(paramBundle.getInt("geta8key_result_general_ctrl_b1"));
                                    ((com.tencent.mm.plugin.webview.e.g)localObject1).a(((String)localObject2).replaceFirst("http://", "https//"), (JsapiPermissionWrapper)localObject3, (GeneralControlWrapper)localObject4);
                                    localObject1 = paramBundle.getStringArray("geta8key_result_http_header_key_list");
                                    localObject2 = paramBundle.getStringArray("geta8key_result_http_header_value_list");
                                    localObject3 = new HashMap();
                                    if ((localObject1 != null) && (localObject2 != null) && (localObject1.length > 0) && (localObject2.length > 0) && (localObject1.length == localObject2.length))
                                    {
                                      paramInt = 0;
                                      while (paramInt < localObject1.length)
                                      {
                                        ((Map)localObject3).put(localObject1[paramInt], localObject2[paramInt]);
                                        paramInt += 1;
                                      }
                                    }
                                    paramBundle = paramBundle.getString("geta8key_result_title");
                                    if ((paramBundle != null) && (paramBundle.length() > 0)) {
                                      ((WebViewUI)this.CsH.get()).setMMTitle(paramBundle);
                                    }
                                  }
                                  else
                                  {
                                    ac.e("MicroMsg.WebViewStubCallbackAIDLStub", "updatePageAuth fail fullUrl is null");
                                    continue;
                                    if ((this.CsH.get() instanceof GameWebViewUI))
                                    {
                                      paramBundle = (GameWebViewUI)this.CsH.get();
                                      localBundle.putString("raw_url", paramBundle.bLL());
                                      localBundle.putString("page_key", paramBundle.eFv());
                                      paramBundle = paramBundle.CEM;
                                      if (paramBundle != null)
                                      {
                                        localBundle.putString("comm_js_version", com.tencent.mm.plugin.wepkg.c.eIN());
                                        localBundle.putString("wepkg_version", paramBundle.eIM());
                                        localBundle.putBoolean("is_used_wepkg", paramBundle.CZo);
                                        continue;
                                        localBundle.putString("current_url", ((WebViewUI)this.CsH.get()).eyJ());
                                        localBundle.putString("raw_url", ((WebViewUI)this.CsH.get()).bLL());
                                        continue;
                                        if ((this.CsH.get() instanceof GameWebViewUI))
                                        {
                                          paramBundle = (GameWebViewUI)this.CsH.get();
                                          paramBundle.sYo.CFK = System.currentTimeMillis();
                                          paramBundle.sYb.fYP = 1;
                                          continue;
                                          if ((this.CsH.get() instanceof GameWebViewUI))
                                          {
                                            ((GameWebViewUI)this.CsH.get()).sYo.CFL = System.currentTimeMillis();
                                            continue;
                                            ((WebViewUI)this.CsH.get()).WT();
                                            continue;
                                            if (((this.CsH.get() instanceof com.tencent.mm.plugin.webview.g.a.b)) && (paramBundle != null))
                                            {
                                              localObject1 = (com.tencent.mm.plugin.webview.g.a.b)this.CsH.get();
                                              localObject2 = paramBundle.getString("action");
                                              if ("writeComment".equals(localObject2))
                                              {
                                                ((com.tencent.mm.plugin.webview.g.a.b)localObject1).aA(paramBundle);
                                              }
                                              else if ("closeComment".equals(localObject2))
                                              {
                                                ((com.tencent.mm.plugin.webview.g.a.b)localObject1).eCr();
                                                continue;
                                                if (((this.CsH.get() instanceof com.tencent.mm.plugin.webview.g.a.b)) && (paramBundle != null))
                                                {
                                                  localObject1 = (com.tencent.mm.plugin.webview.g.a.b)this.CsH.get();
                                                  localObject2 = paramBundle.getString("action");
                                                  paramInt = -1;
                                                  switch (((String)localObject2).hashCode())
                                                  {
                                                  default: 
                                                    label5460:
                                                    switch (paramInt)
                                                    {
                                                    }
                                                    break;
                                                  }
                                                }
                                                for (;;)
                                                {
                                                  if (((this.CsH.get() instanceof com.tencent.mm.plugin.webview.g.a.c)) && (paramBundle != null))
                                                  {
                                                    localObject1 = (com.tencent.mm.plugin.webview.g.a.c)this.CsH.get();
                                                    localObject2 = paramBundle.getString("action");
                                                    if ("share".equals(localObject2))
                                                    {
                                                      ((com.tencent.mm.plugin.webview.g.a.c)localObject1).O(paramBundle);
                                                      break;
                                                      if (!((String)localObject2).equals("writeComment")) {
                                                        break label5460;
                                                      }
                                                      paramInt = 0;
                                                      break label5460;
                                                      if (!((String)localObject2).equals("showToast")) {
                                                        break label5460;
                                                      }
                                                      paramInt = 1;
                                                      break label5460;
                                                      if (!((String)localObject2).equals("readArticle")) {
                                                        break label5460;
                                                      }
                                                      paramInt = 2;
                                                      break label5460;
                                                      if (!((String)localObject2).equals("writeCommentReply")) {
                                                        break label5460;
                                                      }
                                                      paramInt = 3;
                                                      break label5460;
                                                      ((com.tencent.mm.plugin.webview.g.a.b)localObject1).az(paramBundle);
                                                      continue;
                                                      ((com.tencent.mm.plugin.webview.g.a.b)localObject1).aB(paramBundle);
                                                      continue;
                                                      ((com.tencent.mm.plugin.webview.g.a.b)localObject1).ay(paramBundle);
                                                      continue;
                                                      ((com.tencent.mm.plugin.webview.g.a.b)localObject1).aC(paramBundle);
                                                      continue;
                                                    }
                                                    if ("switchVideo".equals(localObject2))
                                                    {
                                                      ((com.tencent.mm.plugin.webview.g.a.c)localObject1).P(paramBundle);
                                                      break;
                                                    }
                                                    if ("createAdWebview".equals(localObject2))
                                                    {
                                                      localBundle.putBoolean("ret", ((com.tencent.mm.plugin.webview.g.a.c)localObject1).Q(paramBundle));
                                                      break;
                                                    }
                                                    if ("closeAdWebview".equals(localObject2))
                                                    {
                                                      ((com.tencent.mm.plugin.webview.g.a.c)localObject1).bMu();
                                                      break;
                                                    }
                                                    if ("getMPVideoState".equals(localObject2))
                                                    {
                                                      localBundle.putAll(((com.tencent.mm.plugin.webview.g.a.c)localObject1).bMw());
                                                      break;
                                                    }
                                                    if ("sendMPPageData".equals(localObject2))
                                                    {
                                                      ((com.tencent.mm.plugin.webview.g.a.c)localObject1).R(paramBundle);
                                                      break;
                                                    }
                                                    if ("getFuncFlag".equals(localObject2))
                                                    {
                                                      localBundle.putAll(((com.tencent.mm.plugin.webview.g.a.c)localObject1).bMs());
                                                      break;
                                                    }
                                                    if ("closeDotWebview".equals(localObject2))
                                                    {
                                                      ((com.tencent.mm.plugin.webview.g.a.c)localObject1).S(paramBundle);
                                                      break;
                                                    }
                                                    if ("hideDotWebview".equals(localObject2))
                                                    {
                                                      ((com.tencent.mm.plugin.webview.g.a.c)localObject1).T(paramBundle);
                                                      break;
                                                    }
                                                    if ("setDotScriptData".equals(localObject2))
                                                    {
                                                      ((com.tencent.mm.plugin.webview.g.a.c)localObject1).V(paramBundle);
                                                      break;
                                                    }
                                                    if (!"opPlayer".equals(localObject2)) {
                                                      break;
                                                    }
                                                    ((com.tencent.mm.plugin.webview.g.a.c)localObject1).W(paramBundle);
                                                    break;
                                                  }
                                                }
                                                if (paramBundle != null)
                                                {
                                                  localObject1 = paramBundle.getString("action");
                                                  if ("getFuncFlag".equals(localObject1))
                                                  {
                                                    localBundle.putAll(((WebViewUI)this.CsH.get()).CAj.eDt());
                                                  }
                                                  else if ("share".equals(localObject1))
                                                  {
                                                    ((WebViewUI)this.CsH.get()).O(paramBundle);
                                                    continue;
                                                    if ((((WebViewUI)this.CsH.get()).CyT != null) && (((WebViewUI)this.CsH.get()).CyT.isShowing())) {
                                                      ((WebViewUI)this.CsH.get()).CyT.dismiss();
                                                    }
                                                    if (paramBundle == null)
                                                    {
                                                      ac.w("MicroMsg.WebViewStubCallbackAIDLStub", "show dialog, data is null");
                                                    }
                                                    else
                                                    {
                                                      paramBundle.getString("title", ((WebViewUI)this.CsH.get()).getString(2131755906));
                                                      localObject1 = paramBundle.getString("message", ((WebViewUI)this.CsH.get()).getString(2131755936));
                                                      bool1 = paramBundle.getBoolean("cancelable", true);
                                                      ((WebViewUI)this.CsH.get()).CyT = com.tencent.mm.ui.base.h.b((Context)this.CsH.get(), (String)localObject1, bool1, new DialogInterface.OnCancelListener()
                                                      {
                                                        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
                                                        {
                                                          AppMethodBeat.i(188385);
                                                          ac.i("MicroMsg.WebViewStubCallbackAIDLStub", "WebViewUITipsDialogCancel");
                                                          try
                                                          {
                                                            paramBundle.putInt("WebViewShare_BinderID", ((WebViewUI)l.a(l.this).get()).eyt());
                                                            ((WebViewUI)l.a(l.this).get()).kYt.k(111, paramBundle);
                                                            AppMethodBeat.o(188385);
                                                            return;
                                                          }
                                                          catch (Exception paramAnonymousDialogInterface)
                                                          {
                                                            ac.e("MicroMsg.WebViewStubCallbackAIDLStub", "hide dialog err %s", new Object[] { paramAnonymousDialogInterface.getMessage() });
                                                            AppMethodBeat.o(188385);
                                                          }
                                                        }
                                                      });
                                                      continue;
                                                      if ((((WebViewUI)this.CsH.get()).CyT != null) && (((WebViewUI)this.CsH.get()).CyT.isShowing()))
                                                      {
                                                        ((WebViewUI)this.CsH.get()).CyT.dismiss();
                                                        continue;
                                                        localObject3 = (WebViewUI)this.CsH.get();
                                                        if (localObject3 == null)
                                                        {
                                                          ac.e("MicroMsg.WebViewStubCallbackAIDLStub", "AC_ON_FAST_LOAD but null WebViewUI");
                                                        }
                                                        else
                                                        {
                                                          localObject4 = new b.a();
                                                          Intent localIntent = new Intent();
                                                          if (paramBundle.getBoolean("isNativePage"))
                                                          {
                                                            localIntent.putExtras(paramBundle);
                                                            float f = bxg();
                                                            com.tencent.mm.plugin.webview.g.g.a((Context)localObject3, paramBundle.getString("currentInfo"), f, localIntent, ((WebViewUI)localObject3).Czc);
                                                            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1061L, 21L, 1L, false);
                                                          }
                                                          paramInt = paramBundle.getInt("scene");
                                                          i = paramBundle.getInt(e.b.HgY, 10000);
                                                          localObject2 = paramBundle.getString("url");
                                                          localObject1 = localObject2;
                                                          if (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).isMpUrl((String)localObject2))
                                                          {
                                                            j = (int)(System.currentTimeMillis() / 1000L);
                                                            localObject1 = ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).d((String)localObject2, paramInt, i, j);
                                                          }
                                                          if (((WebViewUI)localObject3).getIntent() != null) {
                                                            localIntent.putExtra(e.m.HhJ, ((WebViewUI)localObject3).getIntent().getStringExtra(e.m.HhJ));
                                                          }
                                                          localObject2 = (com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class);
                                                          j = paramBundle.getInt("item_show_type");
                                                          paramBundle.getBoolean("isNativePage");
                                                          localBundle.putBoolean("success", ((com.tencent.mm.plugin.brandservice.a.b)localObject2).a((Context)localObject3, (String)localObject1, j, paramInt, i, localIntent, paramBundle.getInt("openType"), (b.a)localObject4));
                                                          if ((!((b.a)localObject4).success) && (((b.a)localObject4).message != null))
                                                          {
                                                            localBundle.putString("desc", ((b.a)localObject4).message);
                                                            continue;
                                                            paramBundle = (WebViewUI)this.CsH.get();
                                                            if ((paramBundle == null) || (paramBundle.getIntent() == null))
                                                            {
                                                              com.tencent.mm.plugin.t.a.q("WebViewStubCallback activity[%s]", new Object[] { paramBundle });
                                                              paramBundle = Bundle.EMPTY;
                                                              AppMethodBeat.o(80028);
                                                              return paramBundle;
                                                            }
                                                            localObject1 = new Bundle(1);
                                                            ((Bundle)localObject1).putString(e.m.HhJ, paramBundle.getIntent().getStringExtra(e.m.HhJ));
                                                            com.tencent.mm.plugin.t.a.q("WebViewStubCallback activity[%s] adUxInfo[%s]", new Object[] { paramBundle, ((Bundle)localObject1).getString(e.m.HhJ) });
                                                            AppMethodBeat.o(80028);
                                                            return localObject1;
                                                            paramBundle = new Bundle(1);
                                                            paramBundle.putString("ad_info_traceId", k.Cya.yeN);
                                                            AppMethodBeat.o(80028);
                                                            return paramBundle;
                                                            paramBundle = new Bundle(1);
                                                            localObject1 = (WebViewUI)this.CsH.get();
                                                            if ((localObject1 != null) && (((WebViewUI)localObject1).getIntent() != null)) {
                                                              break;
                                                            }
                                                            ac.i("MicroMsg.WebViewStubCallbackAIDLStub", "AC_GET_H5_PAY_COOKIE but null WebViewUI");
                                                          }
                                                        }
                                                      }
                                                    }
                                                  }
                                                }
                                              }
                                            }
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    paramBundle.putString("key_h5pay_cookie", getIntent().getStringExtra("key_h5pay_cookie"));
    AppMethodBeat.o(80028);
    return paramBundle;
  }
  
  public final void kA(final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(80032);
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(188386);
        if ((l.a(l.this).get() == null) || (((WebViewUI)l.a(l.this).get()).isFinishing()))
        {
          AppMethodBeat.o(188386);
          return;
        }
        if (!bs.isNullOrNil(paramString1))
        {
          if (!bs.isNullOrNil(paramString2)) {
            l.b(l.this).putExtra("view_port_code", paramString2);
          }
          ((WebViewUI)l.a(l.this).get()).loadUrl(paramString1);
        }
        AppMethodBeat.o(188386);
      }
    });
    AppMethodBeat.o(80032);
  }
  
  public final void kz(final String paramString1, String paramString2)
  {
    AppMethodBeat.i(80025);
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(79981);
        if ((l.a(l.this).get() == null) || (((WebViewUI)l.a(l.this).get()).isFinishing()))
        {
          AppMethodBeat.o(79981);
          return;
        }
        if (!bs.isNullOrNil(((WebViewUI)l.a(l.this).get()).nKq.getUrl()))
        {
          ac.i("MicroMsg.WebViewStubCallbackAIDLStub", "setPageOwner, userName = " + paramString1);
          ((WebViewUI)l.a(l.this).get()).CzK.put(((WebViewUI)l.a(l.this).get()).nKq.getUrl(), paramString1);
          AppMethodBeat.o(79981);
          return;
        }
        ac.i("MicroMsg.WebViewStubCallbackAIDLStub", "setPageOwner, null url");
        AppMethodBeat.o(79981);
      }
    });
    AppMethodBeat.o(80025);
  }
  
  public final void u(final int paramInt, final Bundle paramBundle)
  {
    AppMethodBeat.i(80024);
    if ((this.CsH.get() == null) || (((WebViewUI)this.CsH.get()).isFinishing()))
    {
      AppMethodBeat.o(80024);
      return;
    }
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(79980);
        if ((l.a(l.this).get() == null) || (((WebViewUI)l.a(l.this).get()).isFinishing()) || (((WebViewUI)l.a(l.this).get()).nKq == null))
        {
          AppMethodBeat.o(79980);
          return;
        }
        ac.i("MicroMsg.WebViewStubCallbackAIDLStub", "setMenuItemsVisible, actionCode = " + paramInt);
        Object localObject2 = new HashSet();
        if ((paramInt == 3003) || (paramInt == 3004))
        {
          ((Set)localObject2).add("menuItem:share:brand");
          ((Set)localObject2).add("menuItem:share:appMessage");
          ((Set)localObject2).add("menuItem:share:dataMessage");
          ((Set)localObject2).add("menuItem:share:timeline");
          ((Set)localObject2).add("menuItem:favorite");
          ((Set)localObject2).add("menuItem:profile");
          ((Set)localObject2).add("menuItem:addContact");
          ((Set)localObject2).add("menuItem:copyUrl");
          ((Set)localObject2).add("menuItem:openWithSafari");
          ((Set)localObject2).add("menuItem:share:email");
          ((Set)localObject2).add("menuItem:delete");
          ((Set)localObject2).add("menuItem:editTag");
          ((Set)localObject2).add("menuItem:readMode");
          ((Set)localObject2).add("menuItem:originPage");
          ((Set)localObject2).add("menuItem:share:qq");
          ((Set)localObject2).add("menuItem:share:weiboApp");
          ((Set)localObject2).add("menuItem:share:QZone");
          ((Set)localObject2).add("menuItem:share:Facebook");
          ((Set)localObject2).add("menuItem:share:enterprise");
          ((Set)localObject2).add("menuItem:share:wework");
          ((Set)localObject2).add("menuItem:share:weread");
          ((Set)localObject2).add("menuItem:addShortcut");
          ((Set)localObject2).add("menuItem:haoKan");
          ((Set)localObject2).add("menuItem:cancelHaoKan");
        }
        String str;
        Object localObject1;
        for (;;)
        {
          str = ((WebViewUI)l.a(l.this).get()).nKq.getUrl();
          localObject1 = (SparseBooleanArray)((WebViewUI)l.a(l.this).get()).CAj.Cxs.get(str);
          switch (paramInt)
          {
          default: 
            AppMethodBeat.o(79980);
            return;
            if (paramBundle == null)
            {
              ac.w("MicroMsg.WebViewStubCallbackAIDLStub", "setMenuItemsVisible data is null.");
              AppMethodBeat.o(79980);
              return;
            }
            localObject1 = paramBundle.getStringArrayList("menu_item_list");
            if ((localObject1 == null) || (((List)localObject1).size() == 0))
            {
              ac.w("MicroMsg.WebViewStubCallbackAIDLStub", "setMenuItemsVisible menuItems is null or nil.");
              AppMethodBeat.o(79980);
              return;
            }
            ((Set)localObject2).addAll((Collection)localObject1);
            ((Set)localObject2).remove("menuItem:exposeArticle");
            ((Set)localObject2).remove("menuItem:setFont");
            ((Set)localObject2).remove("menuItem:keepTop");
            ((Set)localObject2).remove("menuItem:cancelKeepTop");
            ((Set)localObject2).remove("menuItem:profile");
            ((Set)localObject2).remove("menuItem:addContact");
            ((Set)localObject2).remove("menuItem:refresh");
          }
        }
        if (localObject1 == null)
        {
          localObject1 = new SparseBooleanArray();
          ((WebViewUI)l.a(l.this).get()).CAj.Cxs.put(str, localObject1);
          ((WebViewUI)l.a(l.this).get()).CAj.f(str, l.b(l.this));
        }
        for (;;)
        {
          localObject2 = ((Set)localObject2).iterator();
          int i;
          while (((Iterator)localObject2).hasNext())
          {
            i = bs.a((Integer)((WebViewUI)l.a(l.this).get()).CAj.Cxt.get(((Iterator)localObject2).next()), -1);
            if (i >= 0) {
              ((SparseBooleanArray)localObject1).put(i, true);
            }
          }
          ((WebViewUI)l.a(l.this).get()).CAj.WT();
          AppMethodBeat.o(79980);
          return;
          if (localObject1 == null) {
            break;
          }
          localObject2 = ((Set)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            i = bs.a((Integer)((WebViewUI)l.a(l.this).get()).CAj.Cxt.get(((Iterator)localObject2).next()), -1);
            if (i >= 0) {
              ((SparseBooleanArray)localObject1).delete(i);
            }
          }
          ((WebViewUI)l.a(l.this).get()).CAj.WT();
          break;
        }
      }
    });
    AppMethodBeat.o(80024);
  }
  
  public final void uq(final boolean paramBoolean)
  {
    AppMethodBeat.i(80017);
    if ((this.CsH.get() == null) || (((WebViewUI)this.CsH.get()).isFinishing()))
    {
      AppMethodBeat.o(80017);
      return;
    }
    final boolean bool = ((WebViewUI)this.CsH.get()).getIntent().getBooleanExtra("forceHideShare", false);
    ac.d("MicroMsg.WebViewStubCallbackAIDLStub", "[cpan] setShareBtnVisible:%d visible:%b  forceHideShare:%b", new Object[] { Long.valueOf(System.currentTimeMillis()), Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(79975);
        if ((l.a(l.this).get() == null) || (((WebViewUI)l.a(l.this).get()).isFinishing()))
        {
          AppMethodBeat.o(79975);
          return;
        }
        if (bool)
        {
          if ((((WebViewUI)l.a(l.this).get()).nKq != null) && (!bs.isNullOrNil(((WebViewUI)l.a(l.this).get()).nKq.getUrl()))) {
            ((WebViewUI)l.a(l.this).get()).CzJ.put(((WebViewUI)l.a(l.this).get()).nKq.getUrl(), Boolean.FALSE);
          }
          ((WebViewUI)l.a(l.this).get()).uv(false);
          AppMethodBeat.o(79975);
          return;
        }
        if ((((WebViewUI)l.a(l.this).get()).nKq != null) && (!bs.isNullOrNil(((WebViewUI)l.a(l.this).get()).nKq.getUrl()))) {
          ((WebViewUI)l.a(l.this).get()).CzJ.put(((WebViewUI)l.a(l.this).get()).nKq.getUrl(), Boolean.valueOf(paramBoolean));
        }
        ((WebViewUI)l.a(l.this).get()).uv(paramBoolean);
        AppMethodBeat.o(79975);
      }
    });
    AppMethodBeat.o(80017);
  }
  
  public final void ur(final boolean paramBoolean)
  {
    AppMethodBeat.i(80018);
    if ((this.CsH.get() == null) || (((WebViewUI)this.CsH.get()).isFinishing()))
    {
      AppMethodBeat.o(80018);
      return;
    }
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(79976);
        if ((l.a(l.this).get() == null) || (((WebViewUI)l.a(l.this).get()).isFinishing()))
        {
          AppMethodBeat.o(79976);
          return;
        }
        ((WebViewUI)l.a(l.this).get()).uu(paramBoolean);
        AppMethodBeat.o(79976);
      }
    });
    AppMethodBeat.o(80018);
  }
  
  public final void us(boolean paramBoolean)
  {
    AppMethodBeat.i(80030);
    if ((this.CsH.get() == null) || (((WebViewUI)this.CsH.get()).isFinishing()))
    {
      AppMethodBeat.o(80030);
      return;
    }
    ((WebViewUI)this.CsH.get()).ux(paramBoolean);
    AppMethodBeat.o(80030);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.l
 * JD-Core Version:    0.7.0.1
 */