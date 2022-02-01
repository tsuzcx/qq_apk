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
import com.tencent.mm.b.q;
import com.tencent.mm.g.a.j.b;
import com.tencent.mm.g.a.td;
import com.tencent.mm.n.d.b;
import com.tencent.mm.plugin.brandservice.a.b.a;
import com.tencent.mm.plugin.handoff.model.HandOffURL;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.webview.c.f.13;
import com.tencent.mm.plugin.webview.c.f.19;
import com.tencent.mm.plugin.webview.c.f.21;
import com.tencent.mm.plugin.webview.c.f.5;
import com.tencent.mm.plugin.webview.c.f.6;
import com.tencent.mm.plugin.webview.c.f.66;
import com.tencent.mm.plugin.webview.c.f.68;
import com.tencent.mm.plugin.webview.c.f.69;
import com.tencent.mm.plugin.webview.c.f.7;
import com.tencent.mm.plugin.webview.c.f.8;
import com.tencent.mm.plugin.webview.c.l.a;
import com.tencent.mm.plugin.webview.model.ay;
import com.tencent.mm.plugin.webview.stub.f.a;
import com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.brr;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.MMFalseProgressBar;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.e.b;
import com.tencent.mm.ui.e.m;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.w;
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
  private final WeakReference<WebViewUI> Eol;
  
  public l(WebViewUI paramWebViewUI)
  {
    AppMethodBeat.i(80008);
    this.Eol = new WeakReference(paramWebViewUI);
    AppMethodBeat.o(80008);
  }
  
  private int aHI(String paramString)
  {
    AppMethodBeat.i(80027);
    int i = ((WebViewUI)this.Eol.get()).aHI(paramString);
    AppMethodBeat.o(80027);
    return i;
  }
  
  private float bCg()
  {
    AppMethodBeat.i(80031);
    float f = com.tencent.mm.cc.a.flD();
    if ((((WebViewUI)this.Eol.get()).osM != null) && (((WebViewUI)this.Eol.get()).osM.getWebCoreType() == WebView.c.MNy) && (XWalkEnvironment.getUsingCustomContext())) {
      f = ((WebViewUI)this.Eol.get()).osM.getResources().getDisplayMetrics().density;
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
    Intent localIntent = ((WebViewUI)this.Eol.get()).getIntent();
    AppMethodBeat.o(80026);
    return localIntent;
  }
  
  public final boolean WE(final int paramInt)
  {
    AppMethodBeat.i(80011);
    com.tencent.mm.sdk.platformtools.ar.f(new Runnable()
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
        ae.d("MicroMsg.WebViewStubCallbackAIDLStub", "[cpan] set title pb visibility:%d", new Object[] { Integer.valueOf(paramInt) });
        if (paramInt == 0)
        {
          if ((!((WebViewUI)l.a(l.this).get()).EvE) && (!((WebViewUI)l.a(l.this).get()).EvF) && (!((WebViewUI)l.a(l.this).get()).bSf()))
          {
            ((WebViewUI)l.a(l.this).get()).EuC.start();
            AppMethodBeat.o(79973);
          }
        }
        else {
          ((WebViewUI)l.a(l.this).get()).EuC.finish();
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
    if ((this.Eol.get() == null) || (((WebViewUI)this.Eol.get()).isFinishing()))
    {
      AppMethodBeat.o(80012);
      return false;
    }
    if (((WebViewUI)this.Eol.get()).DRx != null)
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
          ((WebViewUI)l.a(l.this).get()).DRx.a(paramString1, paramString2, com.tencent.mm.plugin.webview.c.l.aB(paramBundle), paramBoolean);
          AppMethodBeat.o(79974);
        }
      };
      if (!com.tencent.mm.sdk.platformtools.ar.isMainThread()) {
        break label87;
      }
      paramString1.run();
    }
    for (;;)
    {
      AppMethodBeat.o(80012);
      return false;
      label87:
      com.tencent.mm.sdk.platformtools.ar.f(paramString1);
    }
  }
  
  public final void aA(Bundle paramBundle)
  {
    AppMethodBeat.i(80020);
    if ((this.Eol.get() == null) || (((WebViewUI)this.Eol.get()).isFinishing()))
    {
      AppMethodBeat.o(80020);
      return;
    }
    ae.i("MicroMsg.WebViewStubCallbackAIDLStub", "IUIController, closeWindow");
    if (paramBundle != null)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("result_data", paramBundle);
      ((WebViewUI)this.Eol.get()).setResult(-1, localIntent);
    }
    ((WebViewUI)this.Eol.get()).finish();
    AppMethodBeat.o(80020);
  }
  
  public final void aHa(String paramString)
  {
    final int i = 0;
    AppMethodBeat.i(80021);
    if ((this.Eol.get() == null) || (((WebViewUI)this.Eol.get()).isFinishing()))
    {
      AppMethodBeat.o(80021);
      return;
    }
    try
    {
      int j = bu.getInt(paramString, 0);
      i = j;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ae.e("MicroMsg.WebViewStubCallbackAIDLStub", "setFontSizeCb, ex = " + paramString.getMessage());
      }
      com.tencent.mm.sdk.platformtools.ar.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(79978);
          if ((l.a(l.this).get() == null) || (((WebViewUI)l.a(l.this).get()).isFinishing()))
          {
            AppMethodBeat.o(79978);
            return;
          }
          ((WebViewUI)l.a(l.this).get()).Xp(i);
          AppMethodBeat.o(79978);
        }
      });
      AppMethodBeat.o(80021);
    }
    if (((WebViewUI)this.Eol.get()).osM == null)
    {
      ae.e("MicroMsg.WebViewStubCallbackAIDLStub", "setFontSizeCb fail, viewWV is null");
      AppMethodBeat.o(80021);
      return;
    }
  }
  
  public final void az(Bundle paramBundle)
  {
    AppMethodBeat.i(80029);
    if ((this.Eol.get() == null) || (((WebViewUI)this.Eol.get()).isFinishing()))
    {
      AppMethodBeat.o(80029);
      return;
    }
    ae.i("MicroMsg.WebViewStubCallbackAIDLStub", "setCustomMenu");
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
      localObject = ((WebViewUI)this.Eol.get()).osM.getUrl();
      if (((WebViewUI)this.Eol.get()).Evv.containsKey(localObject)) {
        ((WebViewUI)this.Eol.get()).Evv.remove(localObject);
      }
      ((WebViewUI)this.Eol.get()).Evv.put(localObject, paramBundle);
    }
    AppMethodBeat.o(80029);
  }
  
  public final void e(String paramString1, final String paramString2, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(80023);
    if ((this.Eol.get() == null) || (((WebViewUI)this.Eol.get()).isFinishing()))
    {
      AppMethodBeat.o(80023);
      return;
    }
    ae.d("MicroMsg.WebViewStubCallbackAIDLStub", "result: ".concat(String.valueOf(paramString2)));
    if ((((WebViewUI)this.Eol.get()).EvS.lAa == null) || (paramString1 == null) || (!paramString1.equals(((WebViewUI)this.Eol.get()).EvS.lAa.Eog)))
    {
      AppMethodBeat.o(80023);
      return;
    }
    if (((WebViewUI)this.Eol.get()).EvS.lAa != null) {
      ((WebViewUI)this.Eol.get()).EvS.lAa.eUL();
    }
    if ((paramString2 == null) || (((WebViewUI)this.Eol.get()).EvS == null))
    {
      AppMethodBeat.o(80023);
      return;
    }
    com.tencent.mm.sdk.platformtools.ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(79979);
        if ((l.a(l.this).get() == null) || (((WebViewUI)l.a(l.this).get()).isFinishing()) || (((WebViewUI)l.a(l.this).get()).osM == null))
        {
          AppMethodBeat.o(79979);
          return;
        }
        ((WebViewUI)l.a(l.this).get()).EvS.aD(paramString2, paramInt1, paramInt2);
        AppMethodBeat.o(79979);
      }
    });
    AppMethodBeat.o(80023);
  }
  
  public final void ePd()
  {
    AppMethodBeat.i(80019);
    if ((this.Eol.get() == null) || (((WebViewUI)this.Eol.get()).isFinishing()))
    {
      AppMethodBeat.o(80019);
      return;
    }
    if (((WebViewUI)this.Eol.get()).DRx != null) {
      ((WebViewUI)this.Eol.get()).DRx.ePd();
    }
    AppMethodBeat.o(80019);
  }
  
  public final String ePe()
  {
    AppMethodBeat.i(80013);
    if ((this.Eol.get() == null) || (((WebViewUI)this.Eol.get()).isFinishing()))
    {
      AppMethodBeat.o(80013);
      return null;
    }
    String str = ((WebViewUI)this.Eol.get()).bRn();
    AppMethodBeat.o(80013);
    return str;
  }
  
  public final String ePf()
  {
    AppMethodBeat.i(80015);
    if ((this.Eol.get() == null) || (((WebViewUI)this.Eol.get()).isFinishing()))
    {
      AppMethodBeat.o(80015);
      return null;
    }
    String str = ((WebViewUI)this.Eol.get()).getIntent().getStringExtra("srcUsername");
    AppMethodBeat.o(80015);
    return str;
  }
  
  public final int ePg()
  {
    AppMethodBeat.i(80016);
    if ((this.Eol.get() == null) || (((WebViewUI)this.Eol.get()).isFinishing()))
    {
      AppMethodBeat.o(80016);
      return 0;
    }
    int i = ((WebViewUI)this.Eol.get()).bpW();
    AppMethodBeat.o(80016);
    return i;
  }
  
  public final void ePh()
  {
    AppMethodBeat.i(80022);
    if ((this.Eol.get() == null) || (((WebViewUI)this.Eol.get()).isFinishing()))
    {
      AppMethodBeat.o(80022);
      return;
    }
    if (((WebViewUI)this.Eol.get()).DRx != null) {
      ((WebViewUI)this.Eol.get()).DRx.ePh();
    }
    AppMethodBeat.o(80022);
  }
  
  public final Bundle eU(String paramString1, String paramString2)
  {
    AppMethodBeat.i(80033);
    paramString1 = com.tencent.mm.protocal.c.aPx(null);
    AppMethodBeat.o(80033);
    return paramString1;
  }
  
  public final String eaf()
  {
    AppMethodBeat.i(198208);
    if ((this.Eol.get() == null) || (((WebViewUI)this.Eol.get()).isFinishing()))
    {
      AppMethodBeat.o(198208);
      return null;
    }
    String str = ((WebViewUI)this.Eol.get()).eaf();
    AppMethodBeat.o(198208);
    return str;
  }
  
  public final boolean g(int paramInt, final Bundle paramBundle)
  {
    AppMethodBeat.i(80009);
    ae.i("MicroMsg.WebViewStubCallbackAIDLStub", "callback, actionCode = ".concat(String.valueOf(paramInt)));
    Object localObject1 = (WebViewUI)this.Eol.get();
    if ((localObject1 == null) || (((WebViewUI)localObject1).isFinishing()))
    {
      AppMethodBeat.o(80009);
      return false;
    }
    final com.tencent.mm.plugin.webview.c.f localf = ((WebViewUI)localObject1).DRx;
    Object localObject2 = ((WebViewUI)localObject1).lzU;
    switch (paramInt)
    {
    default: 
      ae.e("MicroMsg.WebViewStubCallbackAIDLStub", "undefine action code!!!");
    }
    for (;;)
    {
      AppMethodBeat.o(80009);
      return true;
      if (!((WebViewUI)localObject1).isFinishing())
      {
        ((WebViewUI)localObject1).finish();
        continue;
        com.tencent.mm.sdk.platformtools.ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(79944);
            if ((this.EtM == null) || (this.EtM.isFinishing()))
            {
              AppMethodBeat.o(79944);
              return;
            }
            if ((localf != null) && (this.zUd != null) && (this.zUd.eUS().mC(42))) {
              localf.i(paramBundle, "download_succ");
            }
            AppMethodBeat.o(79944);
          }
        });
        continue;
        com.tencent.mm.sdk.platformtools.ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(79955);
            if ((this.EtM == null) || (this.EtM.isFinishing()))
            {
              AppMethodBeat.o(79955);
              return;
            }
            if ((localf != null) && (this.zUd != null) && (this.zUd.eUS().mC(42))) {
              localf.i(paramBundle, "download_fail");
            }
            AppMethodBeat.o(79955);
          }
        });
        continue;
        com.tencent.mm.sdk.platformtools.ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(79966);
            if ((this.EtM == null) || (this.EtM.isFinishing()))
            {
              AppMethodBeat.o(79966);
              return;
            }
            if ((localf != null) && (this.zUd != null) && (this.zUd.eUS().mC(42))) {
              localf.i(paramBundle, "download_removed");
            }
            AppMethodBeat.o(79966);
          }
        });
        continue;
        com.tencent.mm.sdk.platformtools.ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(79977);
            if ((this.EtM == null) || (this.EtM.isFinishing()))
            {
              AppMethodBeat.o(79977);
              return;
            }
            if ((localf != null) && (this.zUd != null) && (this.zUd.eUS().mC(42))) {
              localf.i(paramBundle, "download_pause");
            }
            AppMethodBeat.o(79977);
          }
        });
        continue;
        com.tencent.mm.sdk.platformtools.ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(79988);
            if ((this.EtM == null) || (this.EtM.isFinishing()))
            {
              AppMethodBeat.o(79988);
              return;
            }
            if ((localf != null) && (this.zUd != null) && (this.zUd.eUS().mC(42))) {
              localf.i(paramBundle, "download_resumed");
            }
            AppMethodBeat.o(79988);
          }
        });
        continue;
        com.tencent.mm.sdk.platformtools.ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(80003);
            if ((this.EtM == null) || (this.EtM.isFinishing()))
            {
              AppMethodBeat.o(80003);
              return;
            }
            if ((localf != null) && (this.zUd != null) && (this.zUd.eUS().mC(42))) {
              localf.i(paramBundle, "download_start");
            }
            AppMethodBeat.o(80003);
          }
        });
        continue;
        final long l = paramBundle.getLong("download_manager_downloadid");
        paramInt = paramBundle.getInt("download_manager_progress");
        final float f = paramBundle.getFloat("download_manager_progress_float");
        com.tencent.mm.sdk.platformtools.ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(80005);
            if ((this.EtM == null) || (this.EtM.isFinishing()))
            {
              AppMethodBeat.o(80005);
              return;
            }
            if ((localf != null) && (this.zUd != null) && (this.zUd.eUS().mC(42))) {
              localf.a(this.val$appId, l, f, this.Eut);
            }
            AppMethodBeat.o(80005);
          }
        });
        continue;
        com.tencent.mm.sdk.platformtools.ar.f(new Runnable()
        {
          public final void run()
          {
            boolean bool2 = false;
            AppMethodBeat.i(80006);
            if ((this.EtM == null) || (this.EtM.isFinishing()))
            {
              AppMethodBeat.o(80006);
              return;
            }
            if ((localf != null) && (this.zUd != null))
            {
              this.zUd.eUS();
              localf.fM(this.EtV, this.ta);
              AppMethodBeat.o(80006);
              return;
            }
            if ((localf != null) && (this.Euu.booleanValue()))
            {
              localf.fM(this.EtV, this.ta);
              AppMethodBeat.o(80006);
              return;
            }
            if (localf == null) {}
            for (boolean bool1 = true;; bool1 = false)
            {
              if (this.zUd == null) {
                bool2 = true;
              }
              ae.w("MicroMsg.WebViewStubCallbackAIDLStub", "something null, %s, %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
              AppMethodBeat.o(80006);
              return;
            }
          }
        });
        continue;
        com.tencent.mm.sdk.platformtools.ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(80007);
            if ((this.EtM == null) || (this.EtM.isFinishing()))
            {
              AppMethodBeat.o(80007);
              return;
            }
            if (localf != null)
            {
              com.tencent.mm.plugin.webview.c.f localf = localf;
              String str = this.Euv;
              int i = this.EtQ;
              if (!localf.BZx)
              {
                ae.e("MicroMsg.JsApiHandler", "onMediaFileUploadProgress fail, not ready");
                AppMethodBeat.o(80007);
                return;
              }
              ae.i("MicroMsg.JsApiHandler", "onMediaFileUploadProgress, local id : %s, percent : %d", new Object[] { str, Integer.valueOf(i) });
              HashMap localHashMap = new HashMap();
              localHashMap.put("localId", str);
              localHashMap.put("percent", Integer.valueOf(i));
              com.tencent.mm.sdk.platformtools.ar.f(new f.13(localf, l.a.b("onMediaFileUploadProgress", localHashMap, localf.EeC, localf.vVT)));
            }
            AppMethodBeat.o(80007);
          }
        });
        continue;
        com.tencent.mm.sdk.platformtools.ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(79945);
            if ((this.EtM == null) || (this.EtM.isFinishing()))
            {
              AppMethodBeat.o(79945);
              return;
            }
            if (localf != null) {
              localf.fN(this.EtP, this.EtQ);
            }
            AppMethodBeat.o(79945);
          }
        });
        continue;
        com.tencent.mm.sdk.platformtools.ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(79946);
            if ((this.EtM == null) || (this.EtM.isFinishing()))
            {
              AppMethodBeat.o(79946);
              return;
            }
            if (localf != null)
            {
              com.tencent.mm.plugin.webview.c.f localf = localf;
              String str1 = this.puM;
              int i = this.liC;
              String str2 = this.EtR;
              int j = this.val$errCode;
              String str3 = this.val$errMsg;
              String str4 = this.EtS;
              String str5 = this.wxW;
              if (!localf.BZx)
              {
                ae.e("MicroMsg.JsApiHandler", "onBackgroundAudioStateChange fail, not ready");
                AppMethodBeat.o(79946);
                return;
              }
              ae.i("MicroMsg.JsApiHandler", "onBackgroundAudioStateChange, state : %s, duration : %d, src:%s, errCode:%d, errMsg:%s, srcId:%s", new Object[] { str1, Integer.valueOf(i), str2, Integer.valueOf(j), str3, str4 });
              HashMap localHashMap = new HashMap();
              localHashMap.put("state", str1);
              localHashMap.put("duration", Integer.valueOf(i));
              localHashMap.put("src", str2);
              localHashMap.put("errCode", Integer.valueOf(j));
              localHashMap.put("errMsg", str3);
              localHashMap.put("srcId", str4);
              localHashMap.put("audioId", str5);
              com.tencent.mm.sdk.platformtools.ar.f(new f.19(localf, l.a.b("onBackgroundAudioStateChange", localHashMap, localf.EeC, localf.vVT)));
            }
            AppMethodBeat.o(79946);
          }
        });
        continue;
        if (paramBundle != null)
        {
          paramBundle.putString("application_language", ((WebViewUI)localObject1).lzT.getLanguage());
          ((WebViewUI)localObject1).Evx = WebViewUI.a.aQ(paramBundle);
          continue;
          com.tencent.mm.sdk.platformtools.ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(79947);
              if ((this.EtM == null) || (this.EtM.isFinishing()))
              {
                AppMethodBeat.o(79947);
                return;
              }
              if (localf != null) {
                localf.fO(this.EtT, this.cvQ);
              }
              AppMethodBeat.o(79947);
            }
          });
          continue;
          com.tencent.mm.sdk.platformtools.ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(79948);
              if ((this.EtM == null) || (this.EtM.isFinishing()))
              {
                AppMethodBeat.o(79948);
                return;
              }
              if (localf != null) {
                localf.fP(this.ujI, this.cvQ);
              }
              AppMethodBeat.o(79948);
            }
          });
          continue;
          com.tencent.mm.sdk.platformtools.ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(79949);
              if ((this.EtM == null) || (this.EtM.isFinishing()))
              {
                AppMethodBeat.o(79949);
                return;
              }
              if (localf != null) {
                localf.fQ(this.EtT, this.cvQ);
              }
              AppMethodBeat.o(79949);
            }
          });
          continue;
          com.tencent.mm.sdk.platformtools.ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(79950);
              if ((this.EtM == null) || (this.EtM.isFinishing()))
              {
                AppMethodBeat.o(79950);
                return;
              }
              if (localf != null) {
                localf.fR(this.ujI, this.cvQ);
              }
              AppMethodBeat.o(79950);
            }
          });
          continue;
          localObject2 = new HashMap();
          ((Map)localObject2).put("err_msg", paramBundle.getString("playResult"));
          ((Map)localObject2).put("localId", paramBundle.getString("localId"));
          com.tencent.mm.sdk.platformtools.ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(79951);
              if ((this.EtM == null) || (this.EtM.isFinishing()))
              {
                AppMethodBeat.o(79951);
                return;
              }
              if (localf != null) {
                localf.bE(this.EtU);
              }
              AppMethodBeat.o(79951);
            }
          });
          continue;
          com.tencent.mm.sdk.platformtools.ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(79952);
              if ((this.EtM == null) || (this.EtM.isFinishing()))
              {
                AppMethodBeat.o(79952);
                return;
              }
              if (localf != null)
              {
                com.tencent.mm.plugin.webview.c.f localf = localf;
                int i = this.val$errCode;
                if (!localf.BZx)
                {
                  ae.e("MicroMsg.JsApiHandler", "onNfcTouch fail, not ready");
                  AppMethodBeat.o(79952);
                  return;
                }
                ae.i("MicroMsg.JsApiHandler", "onNfcTouch errCode=%d", new Object[] { Integer.valueOf(i) });
                HashMap localHashMap = new HashMap();
                localHashMap.put("errCode", Integer.valueOf(i));
                com.tencent.mm.sdk.platformtools.ar.f(new f.21(localf, l.a.b("onNfcTouch", localHashMap, localf.EeC, localf.vVT)));
              }
              AppMethodBeat.o(79952);
            }
          });
          continue;
          com.tencent.mm.sdk.platformtools.ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(79953);
              if ((this.EtM == null) || (this.EtM.isFinishing()))
              {
                AppMethodBeat.o(79953);
                return;
              }
              this.EtM.setMMSubTitle(2131766134);
              AppMethodBeat.o(79953);
            }
          });
          continue;
          localObject2 = new HashMap();
          ((Map)localObject2).put("localId", paramBundle.getString("localId"));
          ((Map)localObject2).put("err_msg", paramBundle.getString("recordResult"));
          com.tencent.mm.sdk.platformtools.ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(79954);
              if ((this.EtM == null) || (this.EtM.isFinishing()))
              {
                AppMethodBeat.o(79954);
                return;
              }
              this.EtM.setMMSubTitle(null);
              if (localf != null) {
                localf.bF(this.EtU);
              }
              AppMethodBeat.o(79954);
            }
          });
          continue;
          com.tencent.mm.sdk.platformtools.ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(79956);
              if ((this.EtM == null) || (this.EtM.isFinishing()))
              {
                AppMethodBeat.o(79956);
                return;
              }
              this.EtM.setMMSubTitle(null);
              AppMethodBeat.o(79956);
            }
          });
          continue;
          if (localf != null)
          {
            com.tencent.mm.sdk.platformtools.ar.f(new Runnable()
            {
              public final void run()
              {
                boolean bool = true;
                AppMethodBeat.i(79957);
                if ((this.EtM == null) || (this.EtM.isFinishing()))
                {
                  AppMethodBeat.o(79957);
                  return;
                }
                if ((!paramBundle.containsKey("jsapi_preverify_fun_list")) || (this.zUd == null)) {
                  if (this.zUd != null) {
                    ae.e("MicroMsg.WebViewStubCallbackAIDLStub", "has JSAPI_CONTROL_BYTES wvPerm %b", new Object[] { Boolean.valueOf(bool) });
                  }
                }
                for (;;)
                {
                  if (localf != null) {
                    localf.eSm();
                  }
                  AppMethodBeat.o(79957);
                  return;
                  bool = false;
                  break;
                  this.zUd.aF(paramBundle);
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
                    localObject6 = new brr();
                    ((brr)localObject6).parseFrom(paramBundle.getByteArray((String)localObject5));
                    ((LinkedList)localObject1).add(localObject6);
                  }
                }
              }
              catch (IOException paramBundle)
              {
                ae.printErrStackTrace("MicroMsg.WebViewStubCallbackAIDLStub", paramBundle, "parse webCompt", new Object[0]);
              }
              localf.EeX.c((String)localObject2, (String)localObject3, (LinkedList)localObject1);
              continue;
              Object localObject3 = paramBundle.getString("exdevice_device_id");
              final boolean bool = paramBundle.getBoolean("exdevice_is_complete");
              com.tencent.mm.sdk.platformtools.ar.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(79958);
                  if ((this.EtM == null) || (this.EtM.isFinishing()))
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
                    String str = this.EtV;
                    arrayOfByte = this.EtW;
                    boolean bool1 = bool;
                    bool2 = this.EtY;
                    if (!localf.BZx)
                    {
                      ae.e("MicroMsg.JsApiHandler", "onScanWXDeviceResult fail, not ready");
                      AppMethodBeat.o(79958);
                      return;
                    }
                    if (arrayOfByte == null) {}
                    for (int i = 0;; i = arrayOfByte.length)
                    {
                      ae.i("MicroMsg.JsApiHandler", "onScanWXDeviceResult: device id = %s, isCompleted = %s, %s", new Object[] { str, Boolean.valueOf(bool1), Integer.valueOf(i) });
                      if (!bu.isNullOrNil(str)) {
                        break;
                      }
                      ae.e("MicroMsg.JsApiHandler", "parameter error!!!");
                      AppMethodBeat.o(79958);
                      return;
                    }
                    localObject = new JSONObject();
                    try
                    {
                      JSONArray localJSONArray = new JSONArray();
                      JSONObject localJSONObject = new JSONObject();
                      localJSONObject.put("deviceId", str);
                      com.tencent.mm.plugin.webview.c.a.a.eSG();
                      if ((com.tencent.mm.plugin.webview.c.a.a.ci(arrayOfByte)) || ((arrayOfByte != null) && (bool2))) {
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
                          ae.i("MicroMsg.JsApiHandler", "hakon onScanWXDeviceResult, %s", new Object[] { localObject });
                          localf.Eet.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + (String)localObject + ")", null);
                          if (!bool2) {
                            com.tencent.mm.plugin.webview.c.a.a.eSG().EfJ = arrayOfByte;
                          }
                          AppMethodBeat.o(79958);
                          return;
                          ((JSONObject)localObject).put("isCompleted", "0");
                        }
                        localException2 = localException2;
                        ae.e("MicroMsg.JsApiHandler", "Ex in onScanWXDeviceResult, %s", new Object[] { localException2.getMessage() });
                      }
                      catch (Exception localException1)
                      {
                        for (;;)
                        {
                          ae.w("MicroMsg.JsApiHandler", "onScanWXDeviceResult, %s", new Object[] { localException1.getMessage() });
                        }
                      }
                    }
                    localObject = l.a.a("onScanWXDeviceResult", (JSONObject)localObject, localf.EeC, localf.vVT);
                  }
                  label337:
                  ae.e("MicroMsg.WebViewStubCallbackAIDLStub", "hakon can not call onScanWXDeviceResult, %s, %s", new Object[] { localf, this.zUd });
                  AppMethodBeat.o(79958);
                }
              });
              continue;
              localObject2 = paramBundle.getString("exdevice_device_id");
              localObject3 = paramBundle.getString("exdevice_brand_name");
              com.tencent.mm.sdk.platformtools.ar.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(79959);
                  if ((this.EtM == null) || (this.EtM.isFinishing()))
                  {
                    AppMethodBeat.o(79959);
                    return;
                  }
                  if (localf != null)
                  {
                    com.tencent.mm.plugin.webview.c.f localf = localf;
                    String str = this.EtV;
                    byte[] arrayOfByte = this.EtZ;
                    Object localObject = this.qhq;
                    if (!localf.BZx)
                    {
                      ae.e("MicroMsg.JsApiHandler", "onReceiveDataFromWXDevice fail, not ready");
                      AppMethodBeat.o(79959);
                      return;
                    }
                    ae.i("MicroMsg.JsApiHandler", "onReceiveDataFromWXDevice: device id = %s, brandName = %s", new Object[] { str, localObject });
                    if ((bu.isNullOrNil(str)) || (bu.isNullOrNil((String)localObject)) || (arrayOfByte == null))
                    {
                      ae.e("MicroMsg.JsApiHandler", "parameter error!!!");
                      AppMethodBeat.o(79959);
                      return;
                    }
                    localObject = new HashMap();
                    ((Map)localObject).put("deviceId", str);
                    ((Map)localObject).put("base64Data", Base64.encodeToString(arrayOfByte, 2));
                    com.tencent.mm.sdk.platformtools.ar.f(new f.5(localf, l.a.b("onReceiveDataFromWXDevice", (Map)localObject, localf.EeC, localf.vVT)));
                  }
                  AppMethodBeat.o(79959);
                }
              });
              continue;
              com.tencent.mm.sdk.platformtools.ar.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(79960);
                  if ((this.EtM == null) || (this.EtM.isFinishing()))
                  {
                    AppMethodBeat.o(79960);
                    return;
                  }
                  com.tencent.mm.plugin.webview.c.f localf;
                  HashMap localHashMap;
                  if (localf != null)
                  {
                    localf = localf;
                    String str = this.EtV;
                    boolean bool = this.Eua;
                    if (!localf.BZx)
                    {
                      ae.e("MicroMsg.JsApiHandler", "onWXDeviceBindStateChange fail, not ready");
                      AppMethodBeat.o(79960);
                      return;
                    }
                    ae.i("MicroMsg.JsApiHandler", "onWXDeviceBindStateChange: device id = %s, isBound = %s", new Object[] { str, Boolean.valueOf(bool) });
                    if (bu.isNullOrNil(str))
                    {
                      ae.e("MicroMsg.JsApiHandler", "parameter error!!!");
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
                    com.tencent.mm.sdk.platformtools.ar.f(new f.6(localf, l.a.b("onWXDeviceBindStateChange", localHashMap, localf.EeC, localf.vVT)));
                    AppMethodBeat.o(79960);
                    return;
                    label180:
                    localHashMap.put("state", "unbind");
                  }
                }
              });
              continue;
              com.tencent.mm.sdk.platformtools.ar.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(79961);
                  if ((this.EtM == null) || (this.EtM.isFinishing()))
                  {
                    AppMethodBeat.o(79961);
                    return;
                  }
                  com.tencent.mm.plugin.webview.c.f localf;
                  HashMap localHashMap;
                  if (localf != null)
                  {
                    localf = localf;
                    boolean bool = this.Eub;
                    if (!localf.BZx)
                    {
                      ae.e("MicroMsg.JsApiHandler", "onWXDeviceBTStateChange fail, not ready");
                      AppMethodBeat.o(79961);
                      return;
                    }
                    ae.i("MicroMsg.JsApiHandler", "onWXDeviceBTStateChange: state = %s", new Object[] { Boolean.valueOf(bool) });
                    localHashMap = new HashMap();
                    if (!bool) {
                      break label137;
                    }
                    localHashMap.put("state", "on");
                  }
                  for (;;)
                  {
                    com.tencent.mm.sdk.platformtools.ar.f(new f.7(localf, l.a.b("onWXDeviceBluetoothStateChange", localHashMap, localf.EeC, localf.vVT)));
                    AppMethodBeat.o(79961);
                    return;
                    label137:
                    localHashMap.put("state", "off");
                  }
                }
              });
              continue;
              com.tencent.mm.sdk.platformtools.ar.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(79962);
                  if ((this.EtM == null) || (this.EtM.isFinishing()))
                  {
                    AppMethodBeat.o(79962);
                    return;
                  }
                  com.tencent.mm.plugin.webview.c.f localf;
                  HashMap localHashMap;
                  if (localf != null)
                  {
                    localf = localf;
                    boolean bool = this.Eub;
                    if (!localf.BZx)
                    {
                      ae.e("MicroMsg.JsApiHandler", "onWXDeviceLanStateChange fail, not ready");
                      AppMethodBeat.o(79962);
                      return;
                    }
                    ae.i("MicroMsg.JsApiHandler", "onWXDeviceLanStateChange: state = %s", new Object[] { Boolean.valueOf(bool) });
                    localHashMap = new HashMap();
                    if (!bool) {
                      break label137;
                    }
                    localHashMap.put("state", "on");
                  }
                  for (;;)
                  {
                    com.tencent.mm.sdk.platformtools.ar.f(new f.8(localf, l.a.b("onWXDeviceLanStateChange", localHashMap, localf.EeC, localf.vVT)));
                    AppMethodBeat.o(79962);
                    return;
                    label137:
                    localHashMap.put("state", "off");
                  }
                }
              });
              continue;
              com.tencent.mm.sdk.platformtools.ar.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(79963);
                  if ((this.EtM == null) || (this.EtM.isFinishing()))
                  {
                    AppMethodBeat.o(79963);
                    return;
                  }
                  if (localf != null) {
                    localf.aIe(this.val$message);
                  }
                  AppMethodBeat.o(79963);
                }
              });
              continue;
              com.tencent.mm.sdk.platformtools.ar.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(79964);
                  if ((this.EtM == null) || (this.EtM.isFinishing()))
                  {
                    AppMethodBeat.o(79964);
                    return;
                  }
                  if (localf != null) {
                    localf.a(this.jGU, this.Euc, this.Eud, this.iaK, this.Eue, this.Euf);
                  }
                  AppMethodBeat.o(79964);
                }
              });
              continue;
              if ((localObject1 != null) && (!((WebViewUI)localObject1).isFinishing()))
              {
                ((WebViewUI)localObject1).n(paramInt, paramBundle);
                continue;
                ((WebViewUI)localObject1).z(paramInt, paramBundle);
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
                  label2136:
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
                      break label2136;
                      paramInt = localObject2.length;
                    }
                    catch (JSONException localJSONException)
                    {
                      for (;;)
                      {
                        ae.e("MicroMsg.WebViewStubCallbackAIDLStub", "GetMsgProofItems exception " + localJSONException.getMessage());
                      }
                    }
                  }
                }
                com.tencent.mm.sdk.platformtools.ar.f(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(79965);
                    if ((this.EtM == null) || (this.EtM.isFinishing()))
                    {
                      AppMethodBeat.o(79965);
                      return;
                    }
                    if (localf != null)
                    {
                      com.tencent.mm.plugin.webview.c.f localf = localf;
                      JSONArray localJSONArray = this.val$jsonArray;
                      if (!localf.BZx)
                      {
                        ae.e("MicroMsg.JsApiHandler", "not ready");
                        AppMethodBeat.o(79965);
                        return;
                      }
                      if (localJSONArray == null)
                      {
                        ae.e("MicroMsg.JsApiHandler", "onGetMsgProofItems fail, not ready");
                        AppMethodBeat.o(79965);
                        return;
                      }
                      ae.i("MicroMsg.JsApiHandler", "onGetMsgProofItems success, ready");
                      HashMap localHashMap = new HashMap();
                      localHashMap.put("msgs", localJSONArray);
                      com.tencent.mm.sdk.platformtools.ar.f(new f.66(localf, l.a.b("onGetMsgProofItems", localHashMap, localf.EeC, localf.vVT)));
                    }
                    AppMethodBeat.o(79965);
                  }
                });
                continue;
                com.tencent.mm.sdk.platformtools.ar.f(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(79967);
                    if ((this.EtM == null) || (this.EtM.isFinishing()))
                    {
                      AppMethodBeat.o(79967);
                      return;
                    }
                    if (localf != null) {
                      localf.aIi(this.Eug);
                    }
                    AppMethodBeat.o(79967);
                  }
                });
                continue;
                com.tencent.mm.sdk.platformtools.ar.f(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(79968);
                    if ((this.EtM == null) || (this.EtM.isFinishing()))
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
                      this.EtM.EvZ.setIcon(bu.nullAsNil(str1));
                      this.EtM.Ewb.WX(paramBundle.getString("key_bag_icon"));
                      str2 = paramBundle.getString("key_brand_name");
                      localObject1 = paramBundle.getString("key_brand_user_name");
                      str1 = paramBundle.getString("key_title");
                      if (!bu.isNullOrNil((String)localObject1)) {
                        this.EtM.getIntent().putExtra("srcUsername", (String)localObject1);
                      }
                      ae.i("FloatBall", "currentMpInfo, brandName:%s, title:%s", new Object[] { str2, str1 });
                      if (this.EtM.Ewa != null)
                      {
                        localObject1 = paramBundle;
                        if (localObject1 != null)
                        {
                          localObject2 = ((Bundle)localObject1).getString("key_url");
                          if (!bu.isNullOrNil((String)localObject2)) {
                            break label340;
                          }
                          ae.w("MicroMsg.WebViewUIStyleHelper", "updateCurrentInfo url is null");
                        }
                      }
                      if (this.EtM.EvS != null)
                      {
                        localObject1 = this.EtM.EvS;
                        localObject2 = paramBundle;
                        if (localObject2 != null)
                        {
                          bool = ((Bundle)localObject2).getBoolean("key_forbidForward");
                          h.EsY.put(h.XC(((h)localObject1).mzb), Boolean.valueOf(bool));
                        }
                      }
                      if ((!bu.isNullOrNil(str1)) || (this.EtM.getMMTitle() == null)) {
                        break label504;
                      }
                      str1 = this.EtM.getMMTitle().toString();
                    }
                    label340:
                    label504:
                    for (;;)
                    {
                      if (!bu.isNullOrNil(str1))
                      {
                        this.EtM.Ewb.WY(str1);
                        this.EtM.EvZ.setTitle(str1);
                      }
                      for (;;)
                      {
                        ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).e(this.EtM.EvZ);
                        AppMethodBeat.o(79968);
                        return;
                        ae.d("MicroMsg.WebViewUIStyleHelper", "updateCurrentInfo url %s", new Object[] { localObject2 });
                        localObject2 = n.XC((String)localObject2);
                        Bundle localBundle = (Bundle)n.EsY.get(localObject2);
                        if (localBundle == null)
                        {
                          n.EsY.put(localObject2, localObject1);
                          break;
                        }
                        if (localBundle.getBoolean("key_current_info_show")) {}
                        for (bool = true;; bool = false)
                        {
                          ((Bundle)localObject1).putBoolean("key_current_info_show", bool);
                          n.EsY.put(localObject2, localObject1);
                          break;
                        }
                        if (bu.isNullOrNil(this.EtM.Ewb.getName())) {
                          this.EtM.Ewb.WY(str2);
                        }
                        if ((bu.isNullOrNil(this.EtM.EvZ.title)) && (!bu.isNullOrNil(str2))) {
                          this.EtM.EvZ.setTitle(str2);
                        }
                      }
                    }
                  }
                });
                continue;
                paramBundle = paramBundle.getString("service_click_tid");
                ae.i("MicroMsg.WebViewStubCallbackAIDLStub", "on service click, update tid = %s", new Object[] { paramBundle });
                ((WebViewUI)localObject1).EvX = paramBundle;
                ((WebViewUI)localObject1).EvY = System.currentTimeMillis();
                com.tencent.mm.sdk.platformtools.ar.f(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(79969);
                    if ((this.EtM == null) || (this.EtM.isFinishing()))
                    {
                      AppMethodBeat.o(79969);
                      return;
                    }
                    if (this.EtM.osM != null)
                    {
                      com.tencent.mm.plugin.normsg.a.b.wJt.a(this.EtM.osM, td.class);
                      if (this.EtM.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).getBoolean("forceTrigger", false))
                      {
                        ae.i("MicroMsg.WebViewStubCallbackAIDLStub", "on service click, test");
                        com.tencent.mm.sdk.b.a.IvT.l(new td());
                      }
                    }
                    AppMethodBeat.o(79969);
                  }
                });
                continue;
                com.tencent.mm.sdk.platformtools.ar.f(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(79970);
                    if ((this.EtM == null) || (this.EtM.isFinishing()))
                    {
                      AppMethodBeat.o(79970);
                      return;
                    }
                    h localh = this.EtM.EvS;
                    Object localObject = paramBundle;
                    ae.i("MicroMsg.WebViewLongClickHelper", "onFetchQrCodeResp");
                    int i = ((Bundle)localObject).getInt("key_resp_ret", -1);
                    localObject = ((Bundle)localObject).getByteArray("key_resp_item_bytes");
                    localh.lAg.q(i, (byte[])localObject);
                    AppMethodBeat.o(79970);
                  }
                });
                continue;
                com.tencent.mm.sdk.platformtools.ar.f(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(79971);
                    if ((this.EtM == null) || (this.EtM.isFinishing()))
                    {
                      AppMethodBeat.o(79971);
                      return;
                    }
                    if (localf != null)
                    {
                      com.tencent.mm.plugin.webview.c.f localf = localf;
                      String str = this.Euh;
                      int i = this.Eui;
                      if (!localf.BZx)
                      {
                        ae.e("MicroMsg.JsApiHandler", "not ready");
                        AppMethodBeat.o(79971);
                        return;
                      }
                      HashMap localHashMap = new HashMap();
                      localHashMap.put("postId", str);
                      localHashMap.put("result", Integer.valueOf(i));
                      com.tencent.mm.sdk.platformtools.ar.f(new f.68(localf, l.a.b("onPublishHaowanEnd", localHashMap, localf.EeC, localf.vVT)));
                    }
                    AppMethodBeat.o(79971);
                  }
                });
                continue;
                com.tencent.mm.sdk.platformtools.ar.f(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(79972);
                    if ((this.EtM == null) || (this.EtM.isFinishing()))
                    {
                      AppMethodBeat.o(79972);
                      return;
                    }
                    if (localf != null)
                    {
                      com.tencent.mm.plugin.webview.c.f localf = localf;
                      String str = this.Euh;
                      float f = this.msW;
                      if (!localf.BZx)
                      {
                        ae.e("MicroMsg.JsApiHandler", "not ready");
                        AppMethodBeat.o(79972);
                        return;
                      }
                      HashMap localHashMap = new HashMap();
                      localHashMap.put("postId", str);
                      localHashMap.put("percent", Float.valueOf(f));
                      com.tencent.mm.sdk.platformtools.ar.f(new f.69(localf, l.a.b("onPublishHaowanProgress", localHashMap, localf.EeC, localf.vVT)));
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
    if ((this.Eol.get() == null) || (((WebViewUI)this.Eol.get()).isFinishing()))
    {
      AppMethodBeat.o(80014);
      return null;
    }
    String str = ((WebViewUI)this.Eol.get()).eRj();
    AppMethodBeat.o(80014);
    return str;
  }
  
  public final Bundle k(final int paramInt, final Bundle paramBundle)
  {
    AppMethodBeat.i(80028);
    ae.i("MicroMsg.WebViewStubCallbackAIDLStub", "invokeAsResult, actionCode = ".concat(String.valueOf(paramInt)));
    final Bundle localBundle = new Bundle();
    if ((this.Eol.get() == null) || (((WebViewUI)this.Eol.get()).isFinishing()))
    {
      AppMethodBeat.o(80028);
      return localBundle;
    }
    Object localObject1 = ((WebViewUI)this.Eol.get()).lzU;
    switch (paramInt)
    {
    default: 
      ae.e("MicroMsg.WebViewStubCallbackAIDLStub", "undefine action code!!!");
    }
    for (;;)
    {
      AppMethodBeat.o(80028);
      return localBundle;
      ((WebViewUI)this.Eol.get()).EvO = true;
      continue;
      localObject1 = new com.tencent.mm.g.a.j();
      ((com.tencent.mm.g.a.j)localObject1).dkQ.context = ((WebViewUI)this.Eol.get()).getContext();
      ((com.tencent.mm.g.a.j)localObject1).dkQ.actionCode = paramInt;
      if (4003 == paramInt)
      {
        paramBundle = paramBundle.getString("apdu");
        ((com.tencent.mm.g.a.j)localObject1).dkQ.dkS = paramBundle;
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
            localBundle.putAll(this.Eul.dkR.dkV);
            AppMethodBeat.o(79982);
          }
        };
        com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject1);
        break;
        if (4004 == paramInt)
        {
          localObject2 = paramBundle.getString("apdus");
          bool1 = paramBundle.getBoolean("breakIfFail", true);
          bool2 = paramBundle.getBoolean("breakIfTrue", false);
          ((com.tencent.mm.g.a.j)localObject1).dkQ.dkS = ((String)localObject2);
          ((com.tencent.mm.g.a.j)localObject1).dkQ.dkT = bool1;
          ((com.tencent.mm.g.a.j)localObject1).dkQ.dkU = bool2;
        }
      }
      localBundle.putString("KPublisherId", ((WebViewUI)this.Eol.get()).dIz);
      paramBundle = getIntent();
      if (paramBundle != null)
      {
        paramInt = aHI(getIntent().getStringExtra("geta8key_username"));
        localBundle.putString("preChatName", paramBundle.getStringExtra("preChatName"));
        localBundle.putInt("preMsgIndex", paramBundle.getIntExtra("preMsgIndex", 0));
        localBundle.putString("prePublishId", paramBundle.getStringExtra("prePublishId"));
        localBundle.putString("preUsername", paramBundle.getStringExtra("preUsername"));
        localBundle.putInt("getA8KeyScene", paramInt);
        localBundle.putString("referUrl", ((WebViewUI)this.Eol.get()).eWx());
        localBundle.putString("url", ((WebViewUI)this.Eol.get()).eRj());
        localBundle.putString("rawUrl", ((WebViewUI)this.Eol.get()).bRn());
        localBundle.putInt("preChatTYPE", getIntent().getIntExtra("preChatTYPE", 0));
        localBundle.putString("KAppId", paramBundle.getStringExtra("KAppId"));
        paramBundle = (WebViewUI)this.Eol.get();
        if (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).isMpUrl(paramBundle.bRn()))
        {
          localBundle.putInt("_DATA_CENTER_ITEM_SHOW_TYPE", paramBundle.Eva);
          continue;
          localBundle.putString("KSessionId", ((WebViewUI)this.Eol.get()).sessionId);
          localBundle.putString("KUserAgent", ((WebViewUI)this.Eol.get()).getUserAgent());
          localBundle.putString("KUrl", ((WebViewUI)this.Eol.get()).eRj());
          paramInt = aHI(getIntent().getStringExtra("geta8key_username"));
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
              ae.i("MicroMsg.WebViewStubCallbackAIDLStub", "key value: pay channel(%d)", new Object[] { Integer.valueOf(getIntent().getIntExtra("pay_channel", -1)) });
              continue;
              localBundle.putInt("scene", getIntent().getIntExtra("scene", -1));
              ae.i("MicroMsg.WebViewStubCallbackAIDLStub", "Key value: Scene(%d)", new Object[] { Integer.valueOf(getIntent().getIntExtra("scene", 0)) });
              continue;
              paramInt = getIntent().getIntExtra("geta8key_scene", 0);
              localBundle.putInt("geta8key_scene", paramInt);
              ae.i("MicroMsg.WebViewStubCallbackAIDLStub", "Key value: getA8KeyScene(%d)", new Object[] { Integer.valueOf(paramInt) });
              continue;
              if (((WebViewUI)this.Eol.get()).lzT.isSDCardAvailable())
              {
                long l = bj.fpv();
                ae.i("MicroMsg.WebViewStubCallbackAIDLStub", "availableSize = %d", new Object[] { Long.valueOf(l) });
                if (l < 524288000L)
                {
                  ae.e("MicroMsg.WebViewStubCallbackAIDLStub", "available size not enough");
                  label1465:
                  paramInt = FactoryProxyManager.getPlayManager().init(ak.getContext(), null);
                }
              }
              for (;;)
              {
                if (paramInt == 0)
                {
                  if (((WebViewUI)this.Eol.get()).EvU == null)
                  {
                    ((WebViewUI)this.Eol.get()).EvU = new f((WebViewUI)this.Eol.get());
                    FactoryProxyManager.getPlayManager().setUtilsObject(((WebViewUI)this.Eol.get()).EvU);
                  }
                  i = FactoryProxyManager.getPlayManager().getLocalServerPort();
                  ae.i("MicroMsg.WebViewStubCallbackAIDLStub", "webview video init result = %d, local port = %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
                  paramBundle = ((WebViewUI)this.Eol.get()).eWj();
                  if ((i <= 0) || (i > 65535)) {
                    ae.e("MicroMsg.WebViewResourceInterrupter", "err port = %d", new Object[] { Integer.valueOf(i) });
                  }
                  if (!paramBundle.Emp.contains(Integer.valueOf(i))) {
                    paramBundle.Emp.add(Integer.valueOf(i));
                  }
                }
                localBundle.putInt("webview_video_proxy_init", paramInt);
                break;
                paramBundle = new com.tencent.mm.vfs.k(com.tencent.mm.plugin.webview.a.DXx);
                bool1 = true;
                if (!paramBundle.exists())
                {
                  bool1 = paramBundle.mkdirs();
                  ae.i("MicroMsg.WebViewStubCallbackAIDLStub", "create proxy cache path : %s, %b", new Object[] { w.B(paramBundle.fTh()), Boolean.valueOf(bool1) });
                }
                if (!bool1) {
                  break label1465;
                }
                paramInt = FactoryProxyManager.getPlayManager().init(ak.getContext(), q.k(w.B(paramBundle.fTh()), false));
                FactoryProxyManager.getPlayManager().setMaxStorageSize(200L);
                continue;
                ae.i("MicroMsg.WebViewStubCallbackAIDLStub", "sdcard not available");
                paramInt = FactoryProxyManager.getPlayManager().init(ak.getContext(), null);
              }
              localObject1 = paramBundle.getString("webview_video_proxy_cdn_urls");
              localObject2 = paramBundle.getString("webview_video_proxy_fileId");
              paramInt = paramBundle.getInt("webview_video_proxy_file_size");
              int i = paramBundle.getInt("webview_video_proxy_file_duration");
              int j = paramBundle.getInt("webview_video_proxy_file_type");
              int k = FactoryProxyManager.getPlayManager().startPlay((String)localObject1, j, (String)localObject2, paramInt, i);
              paramBundle = FactoryProxyManager.getPlayManager().buildPlayURLMp4(k);
              ae.i("MicroMsg.WebViewStubCallbackAIDLStub", "cdnurls = %s, filedId = %s, fileSize = %d, fileDuration = %d, fileType = %d, playDataId = %d, localUrl = %s", new Object[] { localObject1, localObject2, Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), paramBundle });
              localBundle.putInt("webview_video_proxy_play_data_id", k);
              localBundle.putString("webview_video_proxy_local_url", paramBundle);
              continue;
              paramInt = paramBundle.getInt("webview_video_proxy_play_data_id");
              ae.i("MicroMsg.WebViewStubCallbackAIDLStub", "webview proxy stop play, play id = %d", new Object[] { Integer.valueOf(paramInt) });
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
                ae.i("MicroMsg.WebViewStubCallbackAIDLStub", "playid = %d, duration = %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
                localBundle.putInt("webview_video_proxy_pre_load_result", FactoryProxyManager.getPlayManager().preLoad(paramInt, i));
                continue;
                if (paramBundle.getInt("webview_disable_bounce_scroll_top", 0) > 0)
                {
                  com.tencent.mm.sdk.platformtools.ar.f(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(79983);
                      if ((l.a(l.this).get() == null) || (((WebViewUI)l.a(l.this).get()).isFinishing()))
                      {
                        AppMethodBeat.o(79983);
                        return;
                      }
                      ((WebViewUI)l.a(l.this).get()).Ewp.vm(true);
                      AppMethodBeat.o(79983);
                    }
                  });
                  continue;
                  com.tencent.mm.sdk.platformtools.ar.f(new Runnable()
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
                      ((WebViewUI)localObject).Ewp.Ett = new WebViewUI.3((WebViewUI)localObject);
                      localObject = ((WebViewUI)localObject).Ewp;
                      ((j)localObject).jZw = true;
                      if (((j)localObject).Etv != null)
                      {
                        ((j)localObject).Etv.setVisibility(0);
                        ((j)localObject).Etv.setMMOverScrollOffsetListener((LogoWebViewWrapper.b)localObject);
                        ((j)localObject).Etv.setFastScrollBack(true);
                        ((j)localObject).Etv.vm(false);
                        ((j)localObject).Etv.setReleaseTargetHeight(((j)localObject).Etw);
                      }
                      if (((j)localObject).Etu != null)
                      {
                        ((j)localObject).Etu.setWillNotDraw(true);
                        ((j)localObject).Etu.setImageResource(j.Etx);
                        ((j)localObject).Etu.setVisibility(0);
                        ((j)localObject).Etu.setAlpha(0.0F);
                        ((j)localObject).Etu.setWillNotDraw(false);
                        ((j)localObject).Etu.invalidate();
                      }
                      ((j)localObject).eWb();
                      AppMethodBeat.o(79984);
                    }
                  });
                  continue;
                  com.tencent.mm.sdk.platformtools.ar.f(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(79985);
                      if ((l.a(l.this).get() == null) || (((WebViewUI)l.a(l.this).get()).isFinishing()))
                      {
                        AppMethodBeat.o(79985);
                        return;
                      }
                      ((WebViewUI)l.a(l.this).get()).Ewp.stopLoading();
                      AppMethodBeat.o(79985);
                    }
                  });
                  continue;
                  com.tencent.mm.sdk.platformtools.ar.f(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(79986);
                      if ((l.a(l.this).get() == null) || (((WebViewUI)l.a(l.this).get()).isFinishing()))
                      {
                        AppMethodBeat.o(79986);
                        return;
                      }
                      ((WebViewUI)l.a(l.this).get()).Ewp.eVZ();
                      AppMethodBeat.o(79986);
                    }
                  });
                  continue;
                  com.tencent.mm.sdk.platformtools.ar.f(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(79987);
                      if ((l.a(l.this).get() == null) || (((WebViewUI)l.a(l.this).get()).isFinishing()))
                      {
                        AppMethodBeat.o(79987);
                        return;
                      }
                      ((WebViewUI)l.a(l.this).get()).Ewp.startLoading();
                      AppMethodBeat.o(79987);
                    }
                  });
                  continue;
                  com.tencent.mm.sdk.platformtools.ar.f(new Runnable()
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
                      if (localWebViewUI.osM != null) {
                        localWebViewUI.osM.evaluateJavascript("javascript:(function(){return window.getComputedStyle(document.body,null).backgroundColor})()", new WebViewUI.4(localWebViewUI));
                      }
                      AppMethodBeat.o(79989);
                    }
                  });
                  continue;
                  com.tencent.mm.sdk.platformtools.ar.f(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(79990);
                      if ((l.a(l.this).get() == null) || (((WebViewUI)l.a(l.this).get()).isFinishing()))
                      {
                        AppMethodBeat.o(79990);
                        return;
                      }
                      ((WebViewUI)l.a(l.this).get()).aE(this.Eum, this.Eun, this.Euo);
                      AppMethodBeat.o(79990);
                    }
                  });
                  continue;
                  if ((this.Eol.get() != null) && (!((WebViewUI)this.Eol.get()).isFinishing()))
                  {
                    localBundle.putInt("height", ((WebViewUI)this.Eol.get()).eWB());
                    continue;
                    localObject1 = paramBundle.getString("set_page_title_text");
                    paramBundle = paramBundle.getString("set_page_title_color");
                    localObject2 = (WebViewUI)this.Eol.get();
                    if ((com.tencent.mm.compatible.util.d.lA(21)) && (((WebViewUI)localObject2).eWu())) {}
                    for (paramInt = -16777216;; paramInt = ((WebViewUI)localObject2).getResources().getColor(2131099874))
                    {
                      e.ee(paramBundle, paramInt);
                      com.tencent.mm.sdk.platformtools.ar.f(new Runnable()
                      {
                        public final void run()
                        {
                          AppMethodBeat.i(79991);
                          if ((l.a(l.this).get() == null) || (((WebViewUI)l.a(l.this).get()).isFinishing()))
                          {
                            AppMethodBeat.o(79991);
                            return;
                          }
                          if (!((WebViewUI)l.a(l.this).get()).yOS)
                          {
                            AppMethodBeat.o(79991);
                            return;
                          }
                          if (this.cZw != null) {
                            ((WebViewUI)l.a(l.this).get()).setMMTitle(this.cZw);
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
                    if (!bu.isNullOrNil((String)localObject1)) {}
                    for (;;)
                    {
                      try
                      {
                        localObject1 = e.aKa((String)localObject1);
                        paramInt = e.ee(paramBundle.getString("set_navigation_bar_buttons_left_text_color"), -16777216);
                        com.tencent.mm.sdk.platformtools.ar.f(new Runnable()
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
                              ((WebViewUI)l.a(l.this).get()).Ewb.eXu();
                            }
                            if (bool1)
                            {
                              ((WebViewUI)l.a(l.this).get()).vq(true);
                              AppMethodBeat.o(79992);
                              return;
                            }
                            Object localObject = ((WebViewUI)l.a(l.this).get()).eRj();
                            if (!bu.isNullOrNil((String)localObject)) {}
                            for (localObject = (Boolean)((WebViewUI)l.a(l.this).get()).Evw.get(localObject);; localObject = null)
                            {
                              boolean bool;
                              if (localObject == null)
                              {
                                bool = false;
                                ((WebViewUI)l.a(l.this).get()).vq(Boolean.valueOf(bool).booleanValue());
                                if ((this.EhO == null) || (this.EhO.isRecycled())) {
                                  break label307;
                                }
                                ((WebViewUI)l.a(l.this).get()).b(this.val$text, new BitmapDrawable(((WebViewUI)l.a(l.this).get()).getResources(), this.EhO));
                                if (this.EhR) {
                                  ((WebViewUI)l.a(l.this).get()).updateOptionMenuListener(0, new MenuItem.OnMenuItemClickListener()
                                  {
                                    public final boolean onMenuItemClick(MenuItem paramAnonymous2MenuItem)
                                    {
                                      AppMethodBeat.i(198202);
                                      ae.d("MicroMsg.WebViewStubCallbackAIDLStub", "click item: %s", new Object[] { Integer.valueOf(paramAnonymous2MenuItem.getItemId()) });
                                      ((WebViewUI)l.a(l.this).get()).DRx.eSs();
                                      AppMethodBeat.o(198202);
                                      return false;
                                    }
                                  }, null);
                                }
                              }
                              for (;;)
                              {
                                ((WebViewUI)l.a(l.this).get()).Ye(paramInt);
                                AppMethodBeat.o(79992);
                                return;
                                bool = ((Boolean)localObject).booleanValue();
                                break;
                                label307:
                                if (!bu.isNullOrNil(this.val$text))
                                {
                                  if (this.EhQ == -1) {
                                    ((WebViewUI)l.a(l.this).get()).addTextOptionMenu(0, this.val$text, new MenuItem.OnMenuItemClickListener()
                                    {
                                      public final boolean onMenuItemClick(MenuItem paramAnonymous2MenuItem)
                                      {
                                        AppMethodBeat.i(198203);
                                        ae.d("MicroMsg.WebViewStubCallbackAIDLStub", "click item: %s", new Object[] { Integer.valueOf(paramAnonymous2MenuItem.getItemId()) });
                                        ((WebViewUI)l.a(l.this).get()).DRx.eSs();
                                        AppMethodBeat.o(198203);
                                        return false;
                                      }
                                    });
                                  } else {
                                    ((WebViewUI)l.a(l.this).get()).addTextOptionMenu(0, this.val$text, this.EhQ, new MenuItem.OnMenuItemClickListener()
                                    {
                                      public final boolean onMenuItemClick(MenuItem paramAnonymous2MenuItem)
                                      {
                                        AppMethodBeat.i(198204);
                                        ae.d("MicroMsg.WebViewStubCallbackAIDLStub", "click item: %s", new Object[] { Integer.valueOf(paramAnonymous2MenuItem.getItemId()) });
                                        ((WebViewUI)l.a(l.this).get()).DRx.eSs();
                                        AppMethodBeat.o(198204);
                                        return false;
                                      }
                                    });
                                  }
                                }
                                else {
                                  ((WebViewUI)l.a(l.this).get()).addIconOptionMenu(0, ((WebViewUI)l.a(l.this).get()).eWN(), new MenuItem.OnMenuItemClickListener()
                                  {
                                    public final boolean onMenuItemClick(MenuItem paramAnonymous2MenuItem)
                                    {
                                      AppMethodBeat.i(198205);
                                      ae.d("MicroMsg.WebViewStubCallbackAIDLStub", "click item: %s", new Object[] { Integer.valueOf(paramAnonymous2MenuItem.getItemId()) });
                                      ((WebViewUI)l.a(l.this).get()).DRx.eSs();
                                      AppMethodBeat.o(198205);
                                      return false;
                                    }
                                  }, ((WebViewUI)l.a(l.this).get()).Ewv);
                                }
                              }
                            }
                          }
                        });
                      }
                      catch (Exception localException)
                      {
                        localObject1 = null;
                        ae.e("MicroMsg.WebViewStubCallbackAIDLStub", "setNavigationBarButtons, decode base64 image, exception = %s", new Object[] { localException });
                        continue;
                      }
                      localObject1 = null;
                    }
                    com.tencent.mm.sdk.platformtools.ar.f(new Runnable()
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
                        ((WebViewUI)l.a(l.this).get()).aI(bool, false);
                        AppMethodBeat.o(79997);
                      }
                    });
                    continue;
                    if ((this.Eol.get() == null) || (((WebViewUI)this.Eol.get()).isFinishing()))
                    {
                      localBundle.putBoolean("isFullScreen", false);
                    }
                    else
                    {
                      localBundle.putBoolean("isFullScreen", ((WebViewUI)this.Eol.get()).EuN);
                      continue;
                      com.tencent.mm.sdk.platformtools.ar.f(new Runnable()
                      {
                        public final void run()
                        {
                          AppMethodBeat.i(79998);
                          if ((l.a(l.this).get() == null) || (((WebViewUI)l.a(l.this).get()).isFinishing()))
                          {
                            AppMethodBeat.o(79998);
                            return;
                          }
                          if ((((WebViewUI)l.a(l.this).get()).Evy != null) && (((WebViewUI)l.a(l.this).get()).Evy.isShowing())) {
                            ((WebViewUI)l.a(l.this).get()).Evy.dismiss();
                          }
                          AppMethodBeat.o(79998);
                        }
                      });
                      continue;
                      com.tencent.mm.sdk.platformtools.ar.f(new Runnable()
                      {
                        public final void run()
                        {
                          AppMethodBeat.i(79999);
                          if ((l.a(l.this).get() == null) || (((WebViewUI)l.a(l.this).get()).isFinishing()))
                          {
                            AppMethodBeat.o(79999);
                            return;
                          }
                          ((WebViewUI)l.a(l.this).get()).Evx = null;
                          AppMethodBeat.o(79999);
                        }
                      });
                      continue;
                      bool1 = paramBundle.getBoolean("clear_webview_cache_clear_cookie", false);
                      ae.i("MicroMsg.WebViewStubCallbackAIDLStub", "includeCookie = %b", new Object[] { Boolean.valueOf(bool1) });
                      paramBundle = new Intent();
                      paramBundle.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE");
                      paramBundle.putExtra("tools_clean_webview_cache_ignore_cookie", bool1);
                      com.tencent.mm.cp.d.bz(paramBundle);
                      continue;
                      if (paramBundle.getString("enterprise_action").equals("enterprise_get_context_bizchat"))
                      {
                        localBundle.putString("enterprise_context_biz", getIntent().getStringExtra("enterprise_biz_name"));
                        localBundle.putLong("enterprise_context_bizchatid", getIntent().getLongExtra("biz_chat_chat_id", -1L));
                        continue;
                        paramInt = e.ee(paramBundle.getString("key_set_bounce_background_color"), ((WebViewUI)this.Eol.get()).getResources().getColor(2131101165));
                        ((WebViewUI)this.Eol.get()).Ewp.Yc(paramInt);
                        continue;
                        localObject1 = getIntent();
                        if (paramBundle != null)
                        {
                          paramInt = paramBundle.getInt("scene");
                          switch (paramInt)
                          {
                          default: 
                            ae.i("MicroMsg.WebViewStubCallbackAIDLStub", "unknown expose scene: %d", new Object[] { Integer.valueOf(paramInt) });
                          }
                          for (;;)
                          {
                            localBundle.putString("username", ((Intent)localObject1).getStringExtra("k_username"));
                            break;
                            localBundle.putStringArrayList("proof", ((Intent)localObject1).getStringArrayListExtra("k_outside_expose_proof_item_list"));
                            continue;
                            localBundle.putString("newMsgId", r.zV(((Intent)localObject1).getLongExtra("k_expose_msg_id", 0L)));
                            continue;
                            if (!bu.isNullOrNil(((Intent)localObject1).getStringExtra("k_webview_img")))
                            {
                              paramBundle = ((Intent)localObject1).getStringExtra("k_webview_img");
                              localObject2 = o.bb(paramBundle, 0, (int)o.aZR(paramBundle));
                              o.deleteFile(paramBundle);
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
                          com.tencent.mm.sdk.platformtools.ar.f(new Runnable()
                          {
                            public final void run()
                            {
                              AppMethodBeat.i(80000);
                              if ((l.a(l.this).get() == null) || (((WebViewUI)l.a(l.this).get()).isFinishing()))
                              {
                                AppMethodBeat.o(80000);
                                return;
                              }
                              ((WebViewUI)l.a(l.this).get()).aP(paramBundle);
                              AppMethodBeat.o(80000);
                            }
                          });
                          continue;
                          localBundle.putStringArray("webview_get_route_url_list", ((WebViewUI)this.Eol.get()).EvR.eUQ());
                          localBundle.putInt("webview_get_route_url_geta8key_scene", aHI(getIntent().getStringExtra("geta8key_username")));
                          localBundle.putString("geta8key_username", getIntent().getStringExtra("geta8key_username"));
                          continue;
                          localObject1 = ((WebViewUI)this.Eol.get()).eRj();
                          localObject2 = com.tencent.xweb.c.geY().getCookie((String)localObject1);
                          ae.i("MicroMsg.WebViewStubCallbackAIDLStub", "url = %s, cookie = %s", new Object[] { localObject1, localObject2 });
                          localBundle.putString("cookie", (String)localObject2);
                          localBundle.putFloat("density", bCg());
                          if (paramBundle != null)
                          {
                            localBundle.putString("currentUrlPath", com.tencent.mm.plugin.webview.modeltools.j.aJo(paramBundle.getString("currentPicUrl")));
                            continue;
                            localBundle.putBoolean("from_shortcut", ((WebViewUI)this.Eol.get()).Eve);
                            continue;
                            paramBundle.setClassLoader(WebViewUI.class.getClassLoader());
                            com.tencent.mm.br.d.b((Context)this.Eol.get(), paramBundle.getString("open_ui_with_webview_ui_plugin_name"), paramBundle.getString("open_ui_with_webview_ui_plugin_entry"), new Intent().putExtras(paramBundle.getBundle("open_ui_with_webview_ui_extras")).putExtra("KPublisherId", ((WebViewUI)this.Eol.get()).dIz));
                            continue;
                            localObject1 = paramBundle.getString("traceid");
                            paramBundle = paramBundle.getString("username");
                            k.EtK.lf((String)localObject1, paramBundle);
                            continue;
                            paramBundle = ((WebViewUI)this.Eol.get()).getMMTitle();
                            localObject1 = getCurrentUrl();
                            localBundle.putString("webview_current_url", (String)localObject1);
                            if (paramBundle != null) {}
                            for (paramBundle = paramBundle.toString();; paramBundle = "")
                            {
                              localBundle.putString("webview_current_title", paramBundle);
                              localBundle.putString("webview_current_desc", (String)localObject1);
                              break;
                            }
                            paramBundle = ((WebViewUI)this.Eol.get()).getMMTitle();
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
                              if ((!bu.isNullOrNil((String)localObject1)) && (localObject2 != null) && (!bu.isNullOrNil(((Bundle)localObject2).getString("ad_report_ux_info"))))
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
                            if (((WebViewUI)this.Eol.get()).eWe())
                            {
                              localBundle.putString("result", "not_return");
                            }
                            else
                            {
                              localBundle.putString("full_url", bu.nullAsNil(((WebViewUI)this.Eol.get()).osm));
                              if ((((WebViewUI)this.Eol.get()).eWf() != null) && (((WebViewUI)this.Eol.get()).eWf().size() != 0))
                              {
                                localBundle.putInt("set_cookie", 1);
                                com.tencent.xweb.d.lB(ak.getContext());
                                paramBundle = com.tencent.xweb.c.geY();
                                localObject1 = ((WebViewUI)this.Eol.get()).eWf().keySet().iterator();
                                while (((Iterator)localObject1).hasNext())
                                {
                                  localObject2 = (String)((Iterator)localObject1).next();
                                  paramBundle.setCookie(bu.aST(((WebViewUI)this.Eol.get()).osm), (String)localObject2 + "=" + (String)((WebViewUI)this.Eol.get()).eWf().get(localObject2));
                                }
                                paramBundle.setCookie(bu.aST(((WebViewUI)this.Eol.get()).osm), "httponly");
                                com.tencent.xweb.d.gfa();
                                com.tencent.xweb.d.sync();
                                ae.i("MicroMsg.WebViewStubCallbackAIDLStub", "cookies:%s", new Object[] { paramBundle.getCookie(bu.aST(((WebViewUI)this.Eol.get()).osm)) });
                              }
                              else
                              {
                                localBundle.putInt("set_cookie", 0);
                                continue;
                                bool1 = paramBundle.getBoolean("add_shortcut_status");
                                if (((WebViewUI)this.Eol.get()).DRx != null)
                                {
                                  ((WebViewUI)this.Eol.get()).DRx.vf(bool1);
                                  continue;
                                  localBundle.putBoolean("is_from_keep_top", getIntent().getBooleanExtra("is_from_keep_top", false));
                                  continue;
                                  if (((WebViewUI)this.Eol.get()).EuP != null) {
                                    ((WebViewUI)this.Eol.get()).EuP.disable();
                                  }
                                  ((WebViewUI)this.Eol.get()).screenOrientation = paramBundle.getInt("screen_orientation", -1);
                                  if (((WebViewUI)this.Eol.get()).screenOrientation == 1001)
                                  {
                                    ((WebViewUI)this.Eol.get()).screenOrientation = 0;
                                    if (((WebViewUI)this.Eol.get()).EuP != null)
                                    {
                                      ae.i("MicroMsg.WebViewStubCallbackAIDLStub", "OrientationListener, start listen orientation change");
                                      ((WebViewUI)this.Eol.get()).EuP.enable();
                                    }
                                  }
                                  for (;;)
                                  {
                                    ((WebViewUI)this.Eol.get()).setMMOrientation();
                                    break;
                                    if (((WebViewUI)this.Eol.get()).screenOrientation == 1002)
                                    {
                                      ((WebViewUI)this.Eol.get()).screenOrientation = 1;
                                      if (((WebViewUI)this.Eol.get()).EuP != null)
                                      {
                                        ae.i("MicroMsg.WebViewStubCallbackAIDLStub", "OrientationListener, start listen orientation change");
                                        ((WebViewUI)this.Eol.get()).EuP.enable();
                                      }
                                    }
                                  }
                                  ((WebViewUI)this.Eol.get()).aO(paramBundle);
                                  continue;
                                  localBundle.putInt("web_page_count", WebViewUI.EvJ);
                                  continue;
                                  localBundle.putString("geta8key_data_req_url", ((WebViewUI)this.Eol.get()).bRn());
                                  localBundle.putString("geta8key_data_username", getIntent().getStringExtra("geta8key_username"));
                                  localBundle.putInt("geta8key_data_scene", aHI(getIntent().getStringExtra("geta8key_username")));
                                  localBundle.putInt("geta8key_data_reason", 8);
                                  if (((WebViewUI)this.Eol.get()).osM.getIsX5Kernel()) {
                                    localBundle.putInt("geta8key_data_flag", 1);
                                  }
                                  for (;;)
                                  {
                                    this.Eol.get();
                                    localBundle.putString("geta8key_data_net_type", ay.diy());
                                    localBundle.putInt("geta8key_session_id", ((WebViewUI)this.Eol.get()).Evf);
                                    localBundle.putInt("webview_binder_id", ((WebViewUI)this.Eol.get()).eQU());
                                    localBundle.putByteArray("k_a8key_cookie", ((WebViewUI)this.Eol.get()).Evg);
                                    localBundle.putString("geta8key_data_appid", getIntent().getStringExtra("geta8key_open_webview_appid"));
                                    break;
                                    localBundle.putInt("geta8key_data_flag", 0);
                                  }
                                  paramBundle.getString("geta8key_result_req_url");
                                  localObject2 = paramBundle.getString("geta8key_result_full_url");
                                  if (!bu.isNullOrNil((String)localObject2))
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
                                      ((WebViewUI)this.Eol.get()).setMMTitle(paramBundle);
                                    }
                                  }
                                  else
                                  {
                                    ae.e("MicroMsg.WebViewStubCallbackAIDLStub", "updatePageAuth fail fullUrl is null");
                                    continue;
                                    if ((this.Eol.get() instanceof GameWebViewUI))
                                    {
                                      paramBundle = (GameWebViewUI)this.Eol.get();
                                      localBundle.putString("raw_url", paramBundle.bRn());
                                      localBundle.putString("page_key", paramBundle.eYe());
                                      paramBundle = paramBundle.EAA;
                                      if (paramBundle != null)
                                      {
                                        localBundle.putString("comm_js_version", com.tencent.mm.plugin.wepkg.d.fbs());
                                        localBundle.putString("wepkg_version", paramBundle.fbr());
                                        localBundle.putBoolean("is_used_wepkg", paramBundle.EVI);
                                        continue;
                                        localBundle.putString("current_url", ((WebViewUI)this.Eol.get()).eRj());
                                        localBundle.putString("raw_url", ((WebViewUI)this.Eol.get()).bRn());
                                        continue;
                                        if ((this.Eol.get() instanceof GameWebViewUI))
                                        {
                                          paramBundle = (GameWebViewUI)this.Eol.get();
                                          paramBundle.ugx.EBz = System.currentTimeMillis();
                                          paramBundle.ugi.guM = 1;
                                          continue;
                                          if ((this.Eol.get() instanceof GameWebViewUI))
                                          {
                                            ((GameWebViewUI)this.Eol.get()).ugx.EBA = System.currentTimeMillis();
                                            continue;
                                            ((WebViewUI)this.Eol.get()).Zv();
                                            continue;
                                            if (((this.Eol.get() instanceof com.tencent.mm.plugin.webview.g.a.b)) && (paramBundle != null))
                                            {
                                              localObject1 = (com.tencent.mm.plugin.webview.g.a.b)this.Eol.get();
                                              localObject2 = paramBundle.getString("action");
                                              if ("writeComment".equals(localObject2))
                                              {
                                                ((com.tencent.mm.plugin.webview.g.a.b)localObject1).aI(paramBundle);
                                              }
                                              else if ("closeComment".equals(localObject2))
                                              {
                                                ((com.tencent.mm.plugin.webview.g.a.b)localObject1).eUX();
                                                continue;
                                                if (((this.Eol.get() instanceof com.tencent.mm.plugin.webview.g.a.b)) && (paramBundle != null))
                                                {
                                                  localObject1 = (com.tencent.mm.plugin.webview.g.a.b)this.Eol.get();
                                                  localObject2 = paramBundle.getString("action");
                                                  paramInt = -1;
                                                  switch (((String)localObject2).hashCode())
                                                  {
                                                  default: 
                                                    label5468:
                                                    switch (paramInt)
                                                    {
                                                    }
                                                    break;
                                                  }
                                                }
                                                for (;;)
                                                {
                                                  if (((this.Eol.get() instanceof com.tencent.mm.plugin.webview.g.a.c)) && (paramBundle != null))
                                                  {
                                                    localObject1 = (com.tencent.mm.plugin.webview.g.a.c)this.Eol.get();
                                                    localObject2 = paramBundle.getString("action");
                                                    if ("share".equals(localObject2))
                                                    {
                                                      ((com.tencent.mm.plugin.webview.g.a.c)localObject1).R(paramBundle);
                                                      break;
                                                      if (!((String)localObject2).equals("writeComment")) {
                                                        break label5468;
                                                      }
                                                      paramInt = 0;
                                                      break label5468;
                                                      if (!((String)localObject2).equals("showToast")) {
                                                        break label5468;
                                                      }
                                                      paramInt = 1;
                                                      break label5468;
                                                      if (!((String)localObject2).equals("readArticle")) {
                                                        break label5468;
                                                      }
                                                      paramInt = 2;
                                                      break label5468;
                                                      if (!((String)localObject2).equals("writeCommentReply")) {
                                                        break label5468;
                                                      }
                                                      paramInt = 3;
                                                      break label5468;
                                                      ((com.tencent.mm.plugin.webview.g.a.b)localObject1).aH(paramBundle);
                                                      continue;
                                                      ((com.tencent.mm.plugin.webview.g.a.b)localObject1).aJ(paramBundle);
                                                      continue;
                                                      ((com.tencent.mm.plugin.webview.g.a.b)localObject1).aG(paramBundle);
                                                      continue;
                                                      ((com.tencent.mm.plugin.webview.g.a.b)localObject1).aK(paramBundle);
                                                      continue;
                                                    }
                                                    if ("switchVideo".equals(localObject2))
                                                    {
                                                      ((com.tencent.mm.plugin.webview.g.a.c)localObject1).S(paramBundle);
                                                      break;
                                                    }
                                                    if ("createAdWebview".equals(localObject2))
                                                    {
                                                      localBundle.putBoolean("ret", ((com.tencent.mm.plugin.webview.g.a.c)localObject1).T(paramBundle));
                                                      break;
                                                    }
                                                    if ("closeAdWebview".equals(localObject2))
                                                    {
                                                      ((com.tencent.mm.plugin.webview.g.a.c)localObject1).bRV();
                                                      break;
                                                    }
                                                    if ("getMPVideoState".equals(localObject2))
                                                    {
                                                      localBundle.putAll(((com.tencent.mm.plugin.webview.g.a.c)localObject1).bRX());
                                                      break;
                                                    }
                                                    if ("sendMPPageData".equals(localObject2))
                                                    {
                                                      ((com.tencent.mm.plugin.webview.g.a.c)localObject1).U(paramBundle);
                                                      break;
                                                    }
                                                    if ("closeDotWebview".equals(localObject2))
                                                    {
                                                      ((com.tencent.mm.plugin.webview.g.a.c)localObject1).V(paramBundle);
                                                      break;
                                                    }
                                                    if ("hideDotWebview".equals(localObject2))
                                                    {
                                                      ((com.tencent.mm.plugin.webview.g.a.c)localObject1).W(paramBundle);
                                                      break;
                                                    }
                                                    if ("setDotScriptData".equals(localObject2))
                                                    {
                                                      ((com.tencent.mm.plugin.webview.g.a.c)localObject1).Y(paramBundle);
                                                      break;
                                                    }
                                                    if (!"opPlayer".equals(localObject2)) {
                                                      break;
                                                    }
                                                    ((com.tencent.mm.plugin.webview.g.a.c)localObject1).Z(paramBundle);
                                                    break;
                                                  }
                                                }
                                                if ((paramBundle != null) && ("share".equals(paramBundle.getString("action"))))
                                                {
                                                  ((WebViewUI)this.Eol.get()).R(paramBundle);
                                                  continue;
                                                  if ((((WebViewUI)this.Eol.get()).EuE != null) && (((WebViewUI)this.Eol.get()).EuE.isShowing())) {
                                                    ((WebViewUI)this.Eol.get()).EuE.dismiss();
                                                  }
                                                  if (paramBundle == null)
                                                  {
                                                    ae.w("MicroMsg.WebViewStubCallbackAIDLStub", "show dialog, data is null");
                                                  }
                                                  else
                                                  {
                                                    paramBundle.getString("title", ((WebViewUI)this.Eol.get()).getString(2131755906));
                                                    localObject1 = paramBundle.getString("message", ((WebViewUI)this.Eol.get()).getString(2131755936));
                                                    bool1 = paramBundle.getBoolean("cancelable", true);
                                                    ((WebViewUI)this.Eol.get()).EuE = com.tencent.mm.ui.base.h.b((Context)this.Eol.get(), (String)localObject1, bool1, new DialogInterface.OnCancelListener()
                                                    {
                                                      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
                                                      {
                                                        AppMethodBeat.i(198206);
                                                        ae.i("MicroMsg.WebViewStubCallbackAIDLStub", "WebViewUITipsDialogCancel");
                                                        try
                                                        {
                                                          paramBundle.putInt("WebViewShare_BinderID", ((WebViewUI)l.a(l.this).get()).eQU());
                                                          ((WebViewUI)l.a(l.this).get()).lzT.k(111, paramBundle);
                                                          AppMethodBeat.o(198206);
                                                          return;
                                                        }
                                                        catch (Exception paramAnonymousDialogInterface)
                                                        {
                                                          ae.e("MicroMsg.WebViewStubCallbackAIDLStub", "hide dialog err %s", new Object[] { paramAnonymousDialogInterface.getMessage() });
                                                          AppMethodBeat.o(198206);
                                                        }
                                                      }
                                                    });
                                                    continue;
                                                    if ((((WebViewUI)this.Eol.get()).EuE != null) && (((WebViewUI)this.Eol.get()).EuE.isShowing()))
                                                    {
                                                      ((WebViewUI)this.Eol.get()).EuE.dismiss();
                                                      continue;
                                                      localObject3 = (WebViewUI)this.Eol.get();
                                                      if (localObject3 == null)
                                                      {
                                                        ae.e("MicroMsg.WebViewStubCallbackAIDLStub", "AC_ON_FAST_LOAD but null WebViewUI");
                                                      }
                                                      else
                                                      {
                                                        localObject4 = new b.a();
                                                        Intent localIntent = new Intent();
                                                        if (paramBundle.getBoolean("isNativePage"))
                                                        {
                                                          localIntent.putExtras(paramBundle);
                                                          float f = bCg();
                                                          com.tencent.mm.plugin.webview.g.g.a((Context)localObject3, paramBundle.getString("currentInfo"), f, localIntent, ((WebViewUI)localObject3).EuN);
                                                          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1061L, 21L, 1L, false);
                                                        }
                                                        paramInt = paramBundle.getInt("scene");
                                                        i = paramBundle.getInt(e.b.JoW, 10000);
                                                        localObject2 = paramBundle.getString("url");
                                                        localObject1 = localObject2;
                                                        if (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).isMpUrl((String)localObject2))
                                                        {
                                                          j = (int)(System.currentTimeMillis() / 1000L);
                                                          localObject1 = ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).d((String)localObject2, paramInt, i, j);
                                                        }
                                                        if (((WebViewUI)localObject3).getIntent() != null) {
                                                          localIntent.putExtra(e.m.JpH, ((WebViewUI)localObject3).getIntent().getStringExtra(e.m.JpH));
                                                        }
                                                        localObject2 = (com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class);
                                                        j = paramBundle.getInt("item_show_type");
                                                        paramBundle.getBoolean("isNativePage");
                                                        localBundle.putBoolean("success", ((com.tencent.mm.plugin.brandservice.a.b)localObject2).a((Context)localObject3, (String)localObject1, j, paramInt, i, localIntent, paramBundle.getInt("openType"), (b.a)localObject4));
                                                        if ((!((b.a)localObject4).success) && (((b.a)localObject4).message != null))
                                                        {
                                                          localBundle.putString("desc", ((b.a)localObject4).message);
                                                          continue;
                                                          paramBundle = (WebViewUI)this.Eol.get();
                                                          if ((paramBundle == null) || (paramBundle.getIntent() == null))
                                                          {
                                                            com.tencent.mm.plugin.t.a.r("WebViewStubCallback activity[%s]", new Object[] { paramBundle });
                                                            paramBundle = Bundle.EMPTY;
                                                            AppMethodBeat.o(80028);
                                                            return paramBundle;
                                                          }
                                                          localObject1 = new Bundle(1);
                                                          ((Bundle)localObject1).putString(e.m.JpH, paramBundle.getIntent().getStringExtra(e.m.JpH));
                                                          com.tencent.mm.plugin.t.a.r("WebViewStubCallback activity[%s] adUxInfo[%s]", new Object[] { paramBundle, ((Bundle)localObject1).getString(e.m.JpH) });
                                                          AppMethodBeat.o(80028);
                                                          return localObject1;
                                                          paramBundle = new Bundle(1);
                                                          paramBundle.putString("ad_info_traceId", k.EtK.zMj);
                                                          AppMethodBeat.o(80028);
                                                          return paramBundle;
                                                          paramBundle = new Bundle(1);
                                                          localObject1 = (WebViewUI)this.Eol.get();
                                                          if ((localObject1 != null) && (((WebViewUI)localObject1).getIntent() != null)) {
                                                            break;
                                                          }
                                                          ae.i("MicroMsg.WebViewStubCallbackAIDLStub", "AC_GET_H5_PAY_COOKIE but null WebViewUI");
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
  
  public final void kG(final String paramString1, String paramString2)
  {
    AppMethodBeat.i(80025);
    com.tencent.mm.sdk.platformtools.ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(79981);
        if ((l.a(l.this).get() == null) || (((WebViewUI)l.a(l.this).get()).isFinishing()))
        {
          AppMethodBeat.o(79981);
          return;
        }
        if (!bu.isNullOrNil(((WebViewUI)l.a(l.this).get()).osM.getUrl()))
        {
          ae.i("MicroMsg.WebViewStubCallbackAIDLStub", "setPageOwner, userName = " + paramString1);
          ((WebViewUI)l.a(l.this).get()).Evu.put(((WebViewUI)l.a(l.this).get()).osM.getUrl(), paramString1);
          AppMethodBeat.o(79981);
          return;
        }
        ae.i("MicroMsg.WebViewStubCallbackAIDLStub", "setPageOwner, null url");
        AppMethodBeat.o(79981);
      }
    });
    AppMethodBeat.o(80025);
  }
  
  public final void kH(final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(80032);
    com.tencent.mm.sdk.platformtools.ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(198207);
        if ((l.a(l.this).get() == null) || (((WebViewUI)l.a(l.this).get()).isFinishing()))
        {
          AppMethodBeat.o(198207);
          return;
        }
        if (!bu.isNullOrNil(paramString1))
        {
          if (!bu.isNullOrNil(paramString2)) {
            l.b(l.this).putExtra("view_port_code", paramString2);
          }
          ((WebViewUI)l.a(l.this).get()).loadUrl(paramString1);
        }
        AppMethodBeat.o(198207);
      }
    });
    AppMethodBeat.o(80032);
  }
  
  public final void u(final int paramInt, final Bundle paramBundle)
  {
    AppMethodBeat.i(80024);
    if ((this.Eol.get() == null) || (((WebViewUI)this.Eol.get()).isFinishing()))
    {
      AppMethodBeat.o(80024);
      return;
    }
    com.tencent.mm.sdk.platformtools.ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(79980);
        if ((l.a(l.this).get() == null) || (((WebViewUI)l.a(l.this).get()).isFinishing()) || (((WebViewUI)l.a(l.this).get()).osM == null))
        {
          AppMethodBeat.o(79980);
          return;
        }
        ae.i("MicroMsg.WebViewStubCallbackAIDLStub", "setMenuItemsVisible, actionCode = " + paramInt);
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
          ((Set)localObject2).add("menuItem:share:facebook");
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
          str = ((WebViewUI)l.a(l.this).get()).osM.getUrl();
          localObject1 = (SparseBooleanArray)((WebViewUI)l.a(l.this).get()).EvT.Etb.get(str);
          switch (paramInt)
          {
          default: 
            AppMethodBeat.o(79980);
            return;
            if (paramBundle == null)
            {
              ae.w("MicroMsg.WebViewStubCallbackAIDLStub", "setMenuItemsVisible data is null.");
              AppMethodBeat.o(79980);
              return;
            }
            localObject1 = paramBundle.getStringArrayList("menu_item_list");
            if ((localObject1 == null) || (((List)localObject1).size() == 0))
            {
              ae.w("MicroMsg.WebViewStubCallbackAIDLStub", "setMenuItemsVisible menuItems is null or nil.");
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
          ((WebViewUI)l.a(l.this).get()).EvT.Etb.put(str, localObject1);
          ((WebViewUI)l.a(l.this).get()).EvT.f(str, l.b(l.this));
        }
        for (;;)
        {
          localObject2 = ((Set)localObject2).iterator();
          int i;
          while (((Iterator)localObject2).hasNext())
          {
            i = bu.a((Integer)((WebViewUI)l.a(l.this).get()).EvT.Etc.get(((Iterator)localObject2).next()), -1);
            if (i >= 0) {
              ((SparseBooleanArray)localObject1).put(i, true);
            }
          }
          ((WebViewUI)l.a(l.this).get()).EvT.Zv();
          AppMethodBeat.o(79980);
          return;
          if (localObject1 == null) {
            break;
          }
          localObject2 = ((Set)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            i = bu.a((Integer)((WebViewUI)l.a(l.this).get()).EvT.Etc.get(((Iterator)localObject2).next()), -1);
            if (i >= 0) {
              ((SparseBooleanArray)localObject1).delete(i);
            }
          }
          ((WebViewUI)l.a(l.this).get()).EvT.Zv();
          break;
        }
      }
    });
    AppMethodBeat.o(80024);
  }
  
  public final void uW(final boolean paramBoolean)
  {
    AppMethodBeat.i(80017);
    if ((this.Eol.get() == null) || (((WebViewUI)this.Eol.get()).isFinishing()))
    {
      AppMethodBeat.o(80017);
      return;
    }
    final boolean bool = ((WebViewUI)this.Eol.get()).getIntent().getBooleanExtra("forceHideShare", false);
    ae.d("MicroMsg.WebViewStubCallbackAIDLStub", "[cpan] setShareBtnVisible:%d visible:%b  forceHideShare:%b", new Object[] { Long.valueOf(System.currentTimeMillis()), Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
    com.tencent.mm.sdk.platformtools.ar.f(new Runnable()
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
          if ((((WebViewUI)l.a(l.this).get()).osM != null) && (!bu.isNullOrNil(((WebViewUI)l.a(l.this).get()).osM.getUrl()))) {
            ((WebViewUI)l.a(l.this).get()).Evt.put(((WebViewUI)l.a(l.this).get()).osM.getUrl(), Boolean.FALSE);
          }
          ((WebViewUI)l.a(l.this).get()).vo(false);
          AppMethodBeat.o(79975);
          return;
        }
        if ((((WebViewUI)l.a(l.this).get()).osM != null) && (!bu.isNullOrNil(((WebViewUI)l.a(l.this).get()).osM.getUrl()))) {
          ((WebViewUI)l.a(l.this).get()).Evt.put(((WebViewUI)l.a(l.this).get()).osM.getUrl(), Boolean.valueOf(paramBoolean));
        }
        ((WebViewUI)l.a(l.this).get()).vo(paramBoolean);
        AppMethodBeat.o(79975);
      }
    });
    AppMethodBeat.o(80017);
  }
  
  public final void uX(final boolean paramBoolean)
  {
    AppMethodBeat.i(80018);
    if ((this.Eol.get() == null) || (((WebViewUI)this.Eol.get()).isFinishing()))
    {
      AppMethodBeat.o(80018);
      return;
    }
    com.tencent.mm.sdk.platformtools.ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(79976);
        if ((l.a(l.this).get() == null) || (((WebViewUI)l.a(l.this).get()).isFinishing()))
        {
          AppMethodBeat.o(79976);
          return;
        }
        ((WebViewUI)l.a(l.this).get()).vn(paramBoolean);
        AppMethodBeat.o(79976);
      }
    });
    AppMethodBeat.o(80018);
  }
  
  public final void uY(boolean paramBoolean)
  {
    AppMethodBeat.i(80030);
    if ((this.Eol.get() == null) || (((WebViewUI)this.Eol.get()).isFinishing()))
    {
      AppMethodBeat.o(80030);
      return;
    }
    ((WebViewUI)this.Eol.get()).vq(paramBoolean);
    AppMethodBeat.o(80030);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.l
 * JD-Core Version:    0.7.0.1
 */