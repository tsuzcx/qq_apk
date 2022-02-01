package com.tencent.mm.plugin.webview.ui.tools;

import android.app.Activity;
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
import android.os.Looper;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ImageView;
import com.tencent.luggage.sdk.launching.ActivityStarterIpcDelegate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.k.b;
import com.tencent.mm.f.a.ve;
import com.tencent.mm.n.e.b;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.brandservice.a.c.a;
import com.tencent.mm.plugin.handoff.model.HandOffURL;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.webview.c.c;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.d.h.15;
import com.tencent.mm.plugin.webview.d.h.21;
import com.tencent.mm.plugin.webview.d.h.24;
import com.tencent.mm.plugin.webview.d.h.6;
import com.tencent.mm.plugin.webview.d.h.7;
import com.tencent.mm.plugin.webview.d.h.72;
import com.tencent.mm.plugin.webview.d.h.74;
import com.tencent.mm.plugin.webview.d.h.76;
import com.tencent.mm.plugin.webview.d.h.8;
import com.tencent.mm.plugin.webview.d.h.9;
import com.tencent.mm.plugin.webview.d.n.a;
import com.tencent.mm.plugin.webview.model.ar;
import com.tencent.mm.plugin.webview.model.ba;
import com.tencent.mm.plugin.webview.modeltools.j;
import com.tencent.mm.plugin.webview.stub.f.a;
import com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI;
import com.tencent.mm.plugin.wepkg.f;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.cnf;
import com.tencent.mm.protocal.protobuf.fky;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.SdcardUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MMFalseProgressBar;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.f.b;
import com.tencent.mm.ui.f.r;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.vfs.u;
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

public final class n
  extends f.a
{
  private final WeakReference<WebViewUI> PXH;
  
  public n(WebViewUI paramWebViewUI)
  {
    AppMethodBeat.i(80008);
    this.PXH = new WeakReference(paramWebViewUI);
    AppMethodBeat.o(80008);
  }
  
  private void A(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(226061);
    if ((paramBundle != null) && (this.PXH.get() != null) && (((WebViewUI)this.PXH.get()).PIQ != null)) {
      ((WebViewUI)this.PXH.get()).PIQ.PHK.a(new com.tencent.mm.plugin.webview.ui.tools.floatball.a(paramInt, paramBundle));
    }
    AppMethodBeat.o(226061);
  }
  
  private int bjD(String paramString)
  {
    AppMethodBeat.i(80027);
    int i = ((WebViewUI)this.PXH.get()).bjD(paramString);
    AppMethodBeat.o(80027);
    return i;
  }
  
  private float clS()
  {
    AppMethodBeat.i(80031);
    float f = com.tencent.mm.cj.a.hrl();
    if ((((WebViewUI)this.PXH.get()).pHS != null) && (((WebViewUI)this.PXH.get()).pHS.getWebCoreType() == WebView.c.aabm) && (XWalkEnvironment.getUsingCustomContext())) {
      f = ((WebViewUI)this.PXH.get()).pHS.getResources().getDisplayMetrics().density;
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
    Intent localIntent = ((WebViewUI)this.PXH.get()).getIntent();
    AppMethodBeat.o(80026);
    return localIntent;
  }
  
  public final void CG(final boolean paramBoolean)
  {
    AppMethodBeat.i(80017);
    if ((this.PXH.get() == null) || (((WebViewUI)this.PXH.get()).isFinishing()))
    {
      AppMethodBeat.o(80017);
      return;
    }
    final boolean bool = ((WebViewUI)this.PXH.get()).getIntent().getBooleanExtra("forceHideShare", false);
    Log.d("MicroMsg.WebViewStubCallbackAIDLStub", "[cpan] setShareBtnVisible:%d visible:%b  forceHideShare:%b", new Object[] { Long.valueOf(System.currentTimeMillis()), Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(79974);
        if ((n.a(n.this).get() == null) || (((WebViewUI)n.a(n.this).get()).isFinishing()))
        {
          AppMethodBeat.o(79974);
          return;
        }
        if (bool)
        {
          if ((((WebViewUI)n.a(n.this).get()).pHS != null) && (!Util.isNullOrNil(((WebViewUI)n.a(n.this).get()).pHS.getUrl()))) {
            ((WebViewUI)n.a(n.this).get()).QfM.put(((WebViewUI)n.a(n.this).get()).pHS.getUrl(), Boolean.FALSE);
          }
          ((WebViewUI)n.a(n.this).get()).Df(false);
          AppMethodBeat.o(79974);
          return;
        }
        if ((((WebViewUI)n.a(n.this).get()).pHS != null) && (!Util.isNullOrNil(((WebViewUI)n.a(n.this).get()).pHS.getUrl()))) {
          ((WebViewUI)n.a(n.this).get()).QfM.put(((WebViewUI)n.a(n.this).get()).pHS.getUrl(), Boolean.valueOf(paramBoolean));
        }
        ((WebViewUI)n.a(n.this).get()).Df(paramBoolean);
        AppMethodBeat.o(79974);
      }
    });
    AppMethodBeat.o(80017);
  }
  
  public final void CH(final boolean paramBoolean)
  {
    AppMethodBeat.i(80018);
    if ((this.PXH.get() == null) || (((WebViewUI)this.PXH.get()).isFinishing()))
    {
      AppMethodBeat.o(80018);
      return;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(79975);
        if ((n.a(n.this).get() == null) || (((WebViewUI)n.a(n.this).get()).isFinishing()))
        {
          AppMethodBeat.o(79975);
          return;
        }
        ((WebViewUI)n.a(n.this).get()).Dd(paramBoolean);
        AppMethodBeat.o(79975);
      }
    });
    AppMethodBeat.o(80018);
  }
  
  public final void CI(boolean paramBoolean)
  {
    AppMethodBeat.i(80030);
    if ((this.PXH.get() == null) || (((WebViewUI)this.PXH.get()).isFinishing()))
    {
      AppMethodBeat.o(80030);
      return;
    }
    ((WebViewUI)this.PXH.get()).Dj(paramBoolean);
    AppMethodBeat.o(80030);
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
    if ((this.PXH.get() == null) || (((WebViewUI)this.PXH.get()).isFinishing()))
    {
      AppMethodBeat.o(80012);
      return false;
    }
    if (((WebViewUI)this.PXH.get()).PvJ != null)
    {
      paramString1 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(79973);
          if ((n.a(n.this).get() == null) || (((WebViewUI)n.a(n.this).get()).isFinishing()))
          {
            AppMethodBeat.o(79973);
            return;
          }
          ((WebViewUI)n.a(n.this).get()).PvJ.a(paramString1, paramString2, com.tencent.mm.plugin.webview.d.n.aJ(paramBundle), paramBoolean);
          AppMethodBeat.o(79973);
        }
      };
      if (!MMHandlerThread.isMainThread()) {
        break label90;
      }
      paramString1.run();
    }
    for (;;)
    {
      AppMethodBeat.o(80012);
      return false;
      label90:
      MMHandlerThread.postToMainThread(paramString1);
    }
  }
  
  public final void aH(Bundle paramBundle)
  {
    AppMethodBeat.i(80029);
    if ((this.PXH.get() == null) || (((WebViewUI)this.PXH.get()).isFinishing()))
    {
      AppMethodBeat.o(80029);
      return;
    }
    Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "setCustomMenu");
    Object localObject = paramBundle.getStringArrayList("keys");
    ArrayList localArrayList = paramBundle.getStringArrayList("titles");
    int j = ((ArrayList)localObject).size();
    paramBundle = new ArrayList();
    int i = 0;
    while (i < j)
    {
      paramBundle.add(new e.b((String)((ArrayList)localObject).get(i), (String)localArrayList.get(i)));
      i += 1;
    }
    if (((ArrayList)localObject).size() > 0)
    {
      localObject = ((WebViewUI)this.PXH.get()).pHS.getUrl();
      if (((WebViewUI)this.PXH.get()).QfO.containsKey(localObject)) {
        ((WebViewUI)this.PXH.get()).QfO.remove(localObject);
      }
      ((WebViewUI)this.PXH.get()).QfO.put(localObject, paramBundle);
    }
    AppMethodBeat.o(80029);
  }
  
  public final void aI(Bundle paramBundle)
  {
    AppMethodBeat.i(80020);
    if ((this.PXH.get() == null) || (((WebViewUI)this.PXH.get()).isFinishing()))
    {
      AppMethodBeat.o(80020);
      return;
    }
    Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "IUIController, closeWindow");
    if (paramBundle != null)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("result_data", paramBundle);
      ((WebViewUI)this.PXH.get()).setResult(-1, localIntent);
    }
    ((WebViewUI)this.PXH.get()).finish();
    AppMethodBeat.o(80020);
  }
  
  public final boolean amZ(final int paramInt)
  {
    AppMethodBeat.i(80011);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(79972);
        if ((n.a(n.this).get() == null) || (((WebViewUI)n.a(n.this).get()).isFinishing()))
        {
          AppMethodBeat.o(79972);
          return;
        }
        ((WebViewUI)n.a(n.this).get()).setProgressBarIndeterminateVisibility(false);
        Log.d("MicroMsg.WebViewStubCallbackAIDLStub", "[cpan] set title pb visibility:%d", new Object[] { Integer.valueOf(paramInt) });
        if (paramInt == 0)
        {
          if ((!((WebViewUI)n.a(n.this).get()).QfW) && (!((WebViewUI)n.a(n.this).get()).QfX) && (!((WebViewUI)n.a(n.this).get()).cDW()))
          {
            ((WebViewUI)n.a(n.this).get()).QeT.start();
            AppMethodBeat.o(79972);
          }
        }
        else {
          ((WebViewUI)n.a(n.this).get()).QeT.finish();
        }
        AppMethodBeat.o(79972);
      }
    });
    AppMethodBeat.o(80011);
    return true;
  }
  
  public final String bXN()
  {
    AppMethodBeat.i(226034);
    if ((this.PXH.get() == null) || (((WebViewUI)this.PXH.get()).isFinishing()))
    {
      AppMethodBeat.o(226034);
      return null;
    }
    String str = ((WebViewUI)this.PXH.get()).PIQ.PFN;
    AppMethodBeat.o(226034);
    return str;
  }
  
  public final void bix(String paramString)
  {
    final int i = 0;
    AppMethodBeat.i(80021);
    if ((this.PXH.get() == null) || (((WebViewUI)this.PXH.get()).isFinishing()))
    {
      AppMethodBeat.o(80021);
      return;
    }
    try
    {
      int j = Util.getInt(paramString, 0);
      i = j;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.e("MicroMsg.WebViewStubCallbackAIDLStub", "setFontSizeCb, ex = " + paramString.getMessage());
      }
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(79976);
          if ((n.a(n.this).get() == null) || (((WebViewUI)n.a(n.this).get()).isFinishing()))
          {
            AppMethodBeat.o(79976);
            return;
          }
          ((WebViewUI)n.a(n.this).get()).aoF(i);
          AppMethodBeat.o(79976);
        }
      });
      AppMethodBeat.o(80021);
    }
    if (((WebViewUI)this.PXH.get()).pHS == null)
    {
      Log.e("MicroMsg.WebViewStubCallbackAIDLStub", "setFontSizeCb fail, viewWV is null");
      AppMethodBeat.o(80021);
      return;
    }
  }
  
  public final void e(String paramString1, final String paramString2, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(80023);
    if ((this.PXH.get() == null) || (((WebViewUI)this.PXH.get()).isFinishing()))
    {
      AppMethodBeat.o(80023);
      return;
    }
    Log.d("MicroMsg.WebViewStubCallbackAIDLStub", "result: ".concat(String.valueOf(paramString2)));
    if ((((WebViewUI)this.PXH.get()).Qgj.pGJ == null) || (paramString1 == null) || (!paramString1.equals(((WebViewUI)this.PXH.get()).Qgj.pGJ.PXC)))
    {
      AppMethodBeat.o(80023);
      return;
    }
    if (((WebViewUI)this.PXH.get()).Qgj.pGJ != null) {
      ((WebViewUI)this.PXH.get()).Qgj.pGJ.gWy();
    }
    if ((paramString2 == null) || (((WebViewUI)this.PXH.get()).Qgj == null))
    {
      AppMethodBeat.o(80023);
      return;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(79978);
        if ((n.a(n.this).get() == null) || (((WebViewUI)n.a(n.this).get()).isFinishing()) || (((WebViewUI)n.a(n.this).get()).pHS == null))
        {
          AppMethodBeat.o(79978);
          return;
        }
        WebViewLongClickHelper localWebViewLongClickHelper = ((WebViewUI)n.a(n.this).get()).Qgj;
        Log.i("MicroMsg.WebViewLongClickHelper", "onGetQRCodeResult");
        localWebViewLongClickHelper.gUZ();
        localWebViewLongClickHelper.gXL();
        AppMethodBeat.o(79978);
      }
    });
    AppMethodBeat.o(80023);
  }
  
  public final void gPF()
  {
    AppMethodBeat.i(80019);
    if ((this.PXH.get() == null) || (((WebViewUI)this.PXH.get()).isFinishing()))
    {
      AppMethodBeat.o(80019);
      return;
    }
    if (((WebViewUI)this.PXH.get()).PvJ != null) {
      ((WebViewUI)this.PXH.get()).PvJ.gPF();
    }
    AppMethodBeat.o(80019);
  }
  
  public final String gPG()
  {
    AppMethodBeat.i(80013);
    if ((this.PXH.get() == null) || (((WebViewUI)this.PXH.get()).isFinishing()))
    {
      AppMethodBeat.o(80013);
      return null;
    }
    String str = ((WebViewUI)this.PXH.get()).cDu();
    AppMethodBeat.o(80013);
    return str;
  }
  
  public final String gPH()
  {
    AppMethodBeat.i(80015);
    if ((this.PXH.get() == null) || (((WebViewUI)this.PXH.get()).isFinishing()))
    {
      AppMethodBeat.o(80015);
      return null;
    }
    String str = ((WebViewUI)this.PXH.get()).getIntent().getStringExtra("srcUsername");
    AppMethodBeat.o(80015);
    return str;
  }
  
  public final int gPI()
  {
    AppMethodBeat.i(80016);
    if ((this.PXH.get() == null) || (((WebViewUI)this.PXH.get()).isFinishing()))
    {
      AppMethodBeat.o(80016);
      return 0;
    }
    int i = ((WebViewUI)this.PXH.get()).PIQ.bXC();
    AppMethodBeat.o(80016);
    return i;
  }
  
  public final void gPJ()
  {
    AppMethodBeat.i(80022);
    if ((this.PXH.get() == null) || (((WebViewUI)this.PXH.get()).isFinishing()))
    {
      AppMethodBeat.o(80022);
      return;
    }
    if (((WebViewUI)this.PXH.get()).PvJ != null) {
      ((WebViewUI)this.PXH.get()).PvJ.gPJ();
    }
    AppMethodBeat.o(80022);
  }
  
  public final String getCurrentUrl()
  {
    AppMethodBeat.i(80014);
    if ((this.PXH.get() == null) || (((WebViewUI)this.PXH.get()).isFinishing()))
    {
      AppMethodBeat.o(80014);
      return null;
    }
    String str = ((WebViewUI)this.PXH.get()).elY();
    AppMethodBeat.o(80014);
    return str;
  }
  
  public final boolean h(int paramInt, final Bundle paramBundle)
  {
    AppMethodBeat.i(80009);
    Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "callback, actionCode = ".concat(String.valueOf(paramInt)));
    Object localObject1 = (WebViewUI)this.PXH.get();
    if ((localObject1 == null) || (((WebViewUI)localObject1).isFinishing()))
    {
      AppMethodBeat.o(80009);
      return false;
    }
    final com.tencent.mm.plugin.webview.d.h localh = ((WebViewUI)localObject1).PvJ;
    Object localObject2 = ((WebViewUI)localObject1).pGD;
    switch (paramInt)
    {
    default: 
      Log.e("MicroMsg.WebViewStubCallbackAIDLStub", "undefine action code!!!");
    }
    for (;;)
    {
      AppMethodBeat.o(80009);
      return true;
      if (!((WebViewUI)localObject1).isFinishing())
      {
        ((WebViewUI)localObject1).finish();
        continue;
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(79944);
            if ((this.Qet == null) || (this.Qet.isFinishing()))
            {
              AppMethodBeat.o(79944);
              return;
            }
            if ((localh != null) && (this.KpM != null) && (this.KpM.gWI().so(42))) {
              localh.j(paramBundle, "download_succ");
            }
            AppMethodBeat.o(79944);
          }
        });
        continue;
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(79955);
            if ((this.Qet == null) || (this.Qet.isFinishing()))
            {
              AppMethodBeat.o(79955);
              return;
            }
            if ((localh != null) && (this.KpM != null) && (this.KpM.gWI().so(42))) {
              localh.j(paramBundle, "download_fail");
            }
            AppMethodBeat.o(79955);
          }
        });
        continue;
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(79966);
            if ((this.Qet == null) || (this.Qet.isFinishing()))
            {
              AppMethodBeat.o(79966);
              return;
            }
            if ((localh != null) && (this.KpM != null) && (this.KpM.gWI().so(42))) {
              localh.j(paramBundle, "download_removed");
            }
            AppMethodBeat.o(79966);
          }
        });
        continue;
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(79977);
            if ((this.Qet == null) || (this.Qet.isFinishing()))
            {
              AppMethodBeat.o(79977);
              return;
            }
            if ((localh != null) && (this.KpM != null) && (this.KpM.gWI().so(42))) {
              localh.j(paramBundle, "download_pause");
            }
            AppMethodBeat.o(79977);
          }
        });
        continue;
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(79988);
            if ((this.Qet == null) || (this.Qet.isFinishing()))
            {
              AppMethodBeat.o(79988);
              return;
            }
            if ((localh != null) && (this.KpM != null) && (this.KpM.gWI().so(42))) {
              localh.j(paramBundle, "download_resumed");
            }
            AppMethodBeat.o(79988);
          }
        });
        continue;
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(80003);
            if ((this.Qet == null) || (this.Qet.isFinishing()))
            {
              AppMethodBeat.o(80003);
              return;
            }
            if ((localh != null) && (this.KpM != null) && (this.KpM.gWI().so(42))) {
              localh.j(paramBundle, "download_start");
            }
            AppMethodBeat.o(80003);
          }
        });
        continue;
        final long l = paramBundle.getLong("download_manager_downloadid");
        paramInt = paramBundle.getInt("download_manager_progress");
        final float f = paramBundle.getFloat("download_manager_progress_float");
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(80005);
            if ((this.Qet == null) || (this.Qet.isFinishing()))
            {
              AppMethodBeat.o(80005);
              return;
            }
            if ((localh != null) && (this.KpM != null) && (this.KpM.gWI().so(42))) {
              localh.a(this.val$appId, l, f, this.pIu);
            }
            AppMethodBeat.o(80005);
          }
        });
        continue;
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            boolean bool2 = false;
            AppMethodBeat.i(80006);
            if ((this.Qet == null) || (this.Qet.isFinishing()))
            {
              AppMethodBeat.o(80006);
              return;
            }
            if ((localh != null) && (this.KpM != null))
            {
              this.KpM.gWI();
              localh.gR(this.oHg, this.cl);
              AppMethodBeat.o(80006);
              return;
            }
            if ((localh != null) && (this.QeL.booleanValue()))
            {
              localh.gR(this.oHg, this.cl);
              AppMethodBeat.o(80006);
              return;
            }
            if (localh == null) {}
            for (boolean bool1 = true;; bool1 = false)
            {
              if (this.KpM == null) {
                bool2 = true;
              }
              Log.w("MicroMsg.WebViewStubCallbackAIDLStub", "something null, %s, %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
              AppMethodBeat.o(80006);
              return;
            }
          }
        });
        continue;
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(80007);
            if ((this.Qet == null) || (this.Qet.isFinishing()))
            {
              AppMethodBeat.o(80007);
              return;
            }
            if (localh != null)
            {
              com.tencent.mm.plugin.webview.d.h localh = localh;
              String str = this.QeM;
              int i = this.pIw;
              if (!localh.NoX)
              {
                Log.e("MicroMsg.JsApiHandler", "onMediaFileUploadProgress fail, not ready");
                AppMethodBeat.o(80007);
                return;
              }
              Log.i("MicroMsg.JsApiHandler", "onMediaFileUploadProgress, local id : %s, percent : %d", new Object[] { str, Integer.valueOf(i) });
              HashMap localHashMap = new HashMap();
              localHashMap.put("localId", str);
              localHashMap.put("percent", Integer.valueOf(i));
              MMHandlerThread.postToMainThread(new h.15(localh, n.a.b("onMediaFileUploadProgress", localHashMap, localh.PNx, localh.EVx)));
            }
            AppMethodBeat.o(80007);
          }
        });
        continue;
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(79945);
            if ((this.Qet == null) || (this.Qet.isFinishing()))
            {
              AppMethodBeat.o(79945);
              return;
            }
            if (localh != null) {
              localh.gS(this.pIv, this.pIw);
            }
            AppMethodBeat.o(79945);
          }
        });
        continue;
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(79946);
            if ((this.Qet == null) || (this.Qet.isFinishing()))
            {
              AppMethodBeat.o(79946);
              return;
            }
            if (localh != null)
            {
              com.tencent.mm.plugin.webview.d.h localh = localh;
              String str1 = this.CDx;
              int i = this.pmn;
              String str2 = this.Qew;
              int j = this.val$errCode;
              String str3 = this.val$errMsg;
              String str4 = this.Qex;
              String str5 = this.FOA;
              if (!localh.NoX)
              {
                Log.e("MicroMsg.JsApiHandler", "onBackgroundAudioStateChange fail, not ready");
                AppMethodBeat.o(79946);
                return;
              }
              Log.i("MicroMsg.JsApiHandler", "onBackgroundAudioStateChange, state : %s, duration : %d, src:%s, errCode:%d, errMsg:%s, srcId:%s", new Object[] { str1, Integer.valueOf(i), str2, Integer.valueOf(j), str3, str4 });
              HashMap localHashMap = new HashMap();
              localHashMap.put("state", str1);
              localHashMap.put("duration", Integer.valueOf(i));
              localHashMap.put("src", str2);
              localHashMap.put("errCode", Integer.valueOf(j));
              localHashMap.put("errMsg", str3);
              localHashMap.put("srcId", str4);
              localHashMap.put("audioId", str5);
              MMHandlerThread.postToMainThread(new h.21(localh, n.a.b("onBackgroundAudioStateChange", localHashMap, localh.PNx, localh.EVx)));
            }
            AppMethodBeat.o(79946);
          }
        });
        continue;
        if (paramBundle != null)
        {
          paramBundle.putString("application_language", ((WebViewUI)localObject1).pGC.getLanguage());
          ((WebViewUI)localObject1).QfQ = WebViewUI.a.aZ(paramBundle);
          continue;
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(79947);
              if ((this.Qet == null) || (this.Qet.isFinishing()))
              {
                AppMethodBeat.o(79947);
                return;
              }
              if (localh != null) {
                localh.gT(this.pIx, this.cKs);
              }
              AppMethodBeat.o(79947);
            }
          });
          continue;
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(79948);
              if ((this.Qet == null) || (this.Qet.isFinishing()))
              {
                AppMethodBeat.o(79948);
                return;
              }
              if (localh != null) {
                localh.gU(this.pIy, this.cKs);
              }
              AppMethodBeat.o(79948);
            }
          });
          continue;
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(79949);
              if ((this.Qet == null) || (this.Qet.isFinishing()))
              {
                AppMethodBeat.o(79949);
                return;
              }
              if (localh != null) {
                localh.gV(this.pIx, this.cKs);
              }
              AppMethodBeat.o(79949);
            }
          });
          continue;
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(79950);
              if ((this.Qet == null) || (this.Qet.isFinishing()))
              {
                AppMethodBeat.o(79950);
                return;
              }
              if (localh != null) {
                localh.gW(this.pIy, this.cKs);
              }
              AppMethodBeat.o(79950);
            }
          });
          continue;
          localObject2 = new HashMap();
          ((Map)localObject2).put("err_msg", paramBundle.getString("playResult"));
          ((Map)localObject2).put("localId", paramBundle.getString("localId"));
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(79951);
              if ((this.Qet == null) || (this.Qet.isFinishing()))
              {
                AppMethodBeat.o(79951);
                return;
              }
              if (localh != null) {
                localh.bN(this.pIo);
              }
              AppMethodBeat.o(79951);
            }
          });
          continue;
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(79952);
              if ((this.Qet == null) || (this.Qet.isFinishing()))
              {
                AppMethodBeat.o(79952);
                return;
              }
              if (localh != null)
              {
                com.tencent.mm.plugin.webview.d.h localh = localh;
                int i = this.val$errCode;
                if (!localh.NoX)
                {
                  Log.e("MicroMsg.JsApiHandler", "onNfcTouch fail, not ready");
                  AppMethodBeat.o(79952);
                  return;
                }
                Log.i("MicroMsg.JsApiHandler", "onNfcTouch errCode=%d", new Object[] { Integer.valueOf(i) });
                HashMap localHashMap = new HashMap();
                localHashMap.put("errCode", Integer.valueOf(i));
                MMHandlerThread.postToMainThread(new h.24(localh, n.a.b("onNfcTouch", localHashMap, localh.PNx, localh.EVx)));
              }
              AppMethodBeat.o(79952);
            }
          });
          continue;
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(79953);
              if ((this.Qet == null) || (this.Qet.isFinishing()))
              {
                AppMethodBeat.o(79953);
                return;
              }
              this.Qet.setMMSubTitle(c.i.webview_recording);
              AppMethodBeat.o(79953);
            }
          });
          continue;
          localObject2 = new HashMap();
          ((Map)localObject2).put("localId", paramBundle.getString("localId"));
          ((Map)localObject2).put("err_msg", paramBundle.getString("recordResult"));
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(79954);
              if ((this.Qet == null) || (this.Qet.isFinishing()))
              {
                AppMethodBeat.o(79954);
                return;
              }
              this.Qet.setMMSubTitle(null);
              if (localh != null) {
                localh.bO(this.pIo);
              }
              AppMethodBeat.o(79954);
            }
          });
          continue;
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(79956);
              if ((this.Qet == null) || (this.Qet.isFinishing()))
              {
                AppMethodBeat.o(79956);
                return;
              }
              this.Qet.setMMSubTitle(null);
              AppMethodBeat.o(79956);
            }
          });
          continue;
          if (localh != null)
          {
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                boolean bool = true;
                AppMethodBeat.i(79957);
                if ((this.Qet == null) || (this.Qet.isFinishing()))
                {
                  AppMethodBeat.o(79957);
                  return;
                }
                if ((!paramBundle.containsKey("jsapi_preverify_fun_list")) || (this.KpM == null)) {
                  if (this.KpM != null) {
                    Log.e("MicroMsg.WebViewStubCallbackAIDLStub", "has JSAPI_CONTROL_BYTES wvPerm %b", new Object[] { Boolean.valueOf(bool) });
                  }
                }
                for (;;)
                {
                  if (localh != null) {
                    localh.gTS();
                  }
                  AppMethodBeat.o(79957);
                  return;
                  bool = false;
                  break;
                  this.KpM.aN(paramBundle);
                }
              }
            });
            continue;
            if (localh != null)
            {
              Object localObject3;
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
                    localObject6 = new cnf();
                    ((cnf)localObject6).parseFrom(paramBundle.getByteArray((String)localObject5));
                    ((LinkedList)localObject1).add(localObject6);
                  }
                }
              }
              catch (IOException paramBundle)
              {
                Log.printErrStackTrace("MicroMsg.WebViewStubCallbackAIDLStub", paramBundle, "parse webCompt", new Object[0]);
              }
              if (localh.gUc() != null)
              {
                localh.gUc().c((String)localObject2, (String)localObject3, (LinkedList)localObject1);
                continue;
                localObject3 = paramBundle.getString("exdevice_device_id");
                final boolean bool = paramBundle.getBoolean("exdevice_is_complete");
                MMHandlerThread.postToMainThread(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(79958);
                    if ((this.Qet == null) || (this.Qet.isFinishing()))
                    {
                      AppMethodBeat.o(79958);
                      return;
                    }
                    com.tencent.mm.plugin.webview.d.h localh;
                    byte[] arrayOfByte;
                    boolean bool2;
                    Object localObject;
                    if (localh != null)
                    {
                      localh = localh;
                      String str = this.oHg;
                      arrayOfByte = this.Qey;
                      boolean bool1 = bool;
                      bool2 = this.QeA;
                      if (!localh.NoX)
                      {
                        Log.e("MicroMsg.JsApiHandler", "onScanWXDeviceResult fail, not ready");
                        AppMethodBeat.o(79958);
                        return;
                      }
                      if (arrayOfByte == null) {}
                      for (int i = 0;; i = arrayOfByte.length)
                      {
                        Log.i("MicroMsg.JsApiHandler", "onScanWXDeviceResult: device id = %s, isCompleted = %s, %s", new Object[] { str, Boolean.valueOf(bool1), Integer.valueOf(i) });
                        if (!Util.isNullOrNil(str)) {
                          break;
                        }
                        Log.e("MicroMsg.JsApiHandler", "parameter error!!!");
                        AppMethodBeat.o(79958);
                        return;
                      }
                      localObject = new JSONObject();
                      try
                      {
                        JSONArray localJSONArray = new JSONArray();
                        JSONObject localJSONObject = new JSONObject();
                        localJSONObject.put("deviceId", str);
                        com.tencent.mm.plugin.webview.d.a.a.gUm();
                        if ((com.tencent.mm.plugin.webview.d.a.a.cQ(arrayOfByte)) || ((arrayOfByte != null) && (bool2))) {
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
                            Log.i("MicroMsg.JsApiHandler", "hakon onScanWXDeviceResult, %s", new Object[] { localObject });
                            localh.PNp.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + (String)localObject + ")", null);
                            if (!bool2) {
                              com.tencent.mm.plugin.webview.d.a.a.gUm().POL = arrayOfByte;
                            }
                            AppMethodBeat.o(79958);
                            return;
                            ((JSONObject)localObject).put("isCompleted", "0");
                          }
                          localException2 = localException2;
                          Log.e("MicroMsg.JsApiHandler", "Ex in onScanWXDeviceResult, %s", new Object[] { localException2.getMessage() });
                        }
                        catch (Exception localException1)
                        {
                          for (;;)
                          {
                            Log.w("MicroMsg.JsApiHandler", "onScanWXDeviceResult, %s", new Object[] { localException1.getMessage() });
                          }
                        }
                      }
                      localObject = n.a.a("onScanWXDeviceResult", (JSONObject)localObject, localh.PNx, localh.EVx);
                    }
                    label337:
                    Log.e("MicroMsg.WebViewStubCallbackAIDLStub", "hakon can not call onScanWXDeviceResult, %s, %s", new Object[] { localh, this.KpM });
                    AppMethodBeat.o(79958);
                  }
                });
                continue;
                localObject2 = paramBundle.getString("exdevice_device_id");
                localObject3 = paramBundle.getString("exdevice_brand_name");
                MMHandlerThread.postToMainThread(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(79959);
                    if ((this.Qet == null) || (this.Qet.isFinishing()))
                    {
                      AppMethodBeat.o(79959);
                      return;
                    }
                    if (localh != null)
                    {
                      com.tencent.mm.plugin.webview.d.h localh = localh;
                      String str = this.oHg;
                      byte[] arrayOfByte = this.QeB;
                      Object localObject = this.vdS;
                      if (!localh.NoX)
                      {
                        Log.e("MicroMsg.JsApiHandler", "onReceiveDataFromWXDevice fail, not ready");
                        AppMethodBeat.o(79959);
                        return;
                      }
                      Log.i("MicroMsg.JsApiHandler", "onReceiveDataFromWXDevice: device id = %s, brandName = %s", new Object[] { str, localObject });
                      if ((Util.isNullOrNil(str)) || (Util.isNullOrNil((String)localObject)) || (arrayOfByte == null))
                      {
                        Log.e("MicroMsg.JsApiHandler", "parameter error!!!");
                        AppMethodBeat.o(79959);
                        return;
                      }
                      localObject = new HashMap();
                      ((Map)localObject).put("deviceId", str);
                      ((Map)localObject).put("base64Data", Base64.encodeToString(arrayOfByte, 2));
                      MMHandlerThread.postToMainThread(new h.6(localh, n.a.b("onReceiveDataFromWXDevice", (Map)localObject, localh.PNx, localh.EVx)));
                    }
                    AppMethodBeat.o(79959);
                  }
                });
                continue;
                MMHandlerThread.postToMainThread(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(79960);
                    if ((this.Qet == null) || (this.Qet.isFinishing()))
                    {
                      AppMethodBeat.o(79960);
                      return;
                    }
                    com.tencent.mm.plugin.webview.d.h localh;
                    HashMap localHashMap;
                    if (localh != null)
                    {
                      localh = localh;
                      String str = this.oHg;
                      boolean bool = this.QeC;
                      if (!localh.NoX)
                      {
                        Log.e("MicroMsg.JsApiHandler", "onWXDeviceBindStateChange fail, not ready");
                        AppMethodBeat.o(79960);
                        return;
                      }
                      Log.i("MicroMsg.JsApiHandler", "onWXDeviceBindStateChange: device id = %s, isBound = %s", new Object[] { str, Boolean.valueOf(bool) });
                      if (Util.isNullOrNil(str))
                      {
                        Log.e("MicroMsg.JsApiHandler", "parameter error!!!");
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
                      MMHandlerThread.postToMainThread(new h.7(localh, n.a.b("onWXDeviceBindStateChange", localHashMap, localh.PNx, localh.EVx)));
                      AppMethodBeat.o(79960);
                      return;
                      label180:
                      localHashMap.put("state", "unbind");
                    }
                  }
                });
                continue;
                MMHandlerThread.postToMainThread(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(79961);
                    if ((this.Qet == null) || (this.Qet.isFinishing()))
                    {
                      AppMethodBeat.o(79961);
                      return;
                    }
                    com.tencent.mm.plugin.webview.d.h localh;
                    HashMap localHashMap;
                    if (localh != null)
                    {
                      localh = localh;
                      boolean bool = this.QeD;
                      if (!localh.NoX)
                      {
                        Log.e("MicroMsg.JsApiHandler", "onWXDeviceBTStateChange fail, not ready");
                        AppMethodBeat.o(79961);
                        return;
                      }
                      Log.i("MicroMsg.JsApiHandler", "onWXDeviceBTStateChange: state = %s", new Object[] { Boolean.valueOf(bool) });
                      localHashMap = new HashMap();
                      if (!bool) {
                        break label137;
                      }
                      localHashMap.put("state", "on");
                    }
                    for (;;)
                    {
                      MMHandlerThread.postToMainThread(new h.8(localh, n.a.b("onWXDeviceBluetoothStateChange", localHashMap, localh.PNx, localh.EVx)));
                      AppMethodBeat.o(79961);
                      return;
                      label137:
                      localHashMap.put("state", "off");
                    }
                  }
                });
                continue;
                MMHandlerThread.postToMainThread(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(79962);
                    if ((this.Qet == null) || (this.Qet.isFinishing()))
                    {
                      AppMethodBeat.o(79962);
                      return;
                    }
                    com.tencent.mm.plugin.webview.d.h localh;
                    HashMap localHashMap;
                    if (localh != null)
                    {
                      localh = localh;
                      boolean bool = this.QeD;
                      if (!localh.NoX)
                      {
                        Log.e("MicroMsg.JsApiHandler", "onWXDeviceLanStateChange fail, not ready");
                        AppMethodBeat.o(79962);
                        return;
                      }
                      Log.i("MicroMsg.JsApiHandler", "onWXDeviceLanStateChange: state = %s", new Object[] { Boolean.valueOf(bool) });
                      localHashMap = new HashMap();
                      if (!bool) {
                        break label137;
                      }
                      localHashMap.put("state", "on");
                    }
                    for (;;)
                    {
                      MMHandlerThread.postToMainThread(new h.9(localh, n.a.b("onWXDeviceLanStateChange", localHashMap, localh.PNx, localh.EVx)));
                      AppMethodBeat.o(79962);
                      return;
                      label137:
                      localHashMap.put("state", "off");
                    }
                  }
                });
                continue;
                MMHandlerThread.postToMainThread(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(79963);
                    if ((this.Qet == null) || (this.Qet.isFinishing()))
                    {
                      AppMethodBeat.o(79963);
                      return;
                    }
                    if (localh != null) {
                      localh.bkb(this.val$message);
                    }
                    AppMethodBeat.o(79963);
                  }
                });
                continue;
                MMHandlerThread.postToMainThread(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(79964);
                    if ((this.Qet == null) || (this.Qet.isFinishing()))
                    {
                      AppMethodBeat.o(79964);
                      return;
                    }
                    if (localh != null) {
                      localh.a(this.nCI, this.pIp, this.pIq, this.lMd, this.pIr, this.pIs);
                    }
                    AppMethodBeat.o(79964);
                  }
                });
                continue;
                if ((localObject1 != null) && (!((WebViewUI)localObject1).isFinishing()))
                {
                  ((WebViewUI)localObject1).o(paramInt, paramBundle);
                  continue;
                  ((WebViewUI)localObject1).B(paramInt, paramBundle);
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
                    label2166:
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
                        break label2166;
                        paramInt = localObject2.length;
                      }
                      catch (JSONException localJSONException)
                      {
                        for (;;)
                        {
                          Log.e("MicroMsg.WebViewStubCallbackAIDLStub", "GetMsgProofItems exception " + localJSONException.getMessage());
                        }
                      }
                    }
                  }
                  MMHandlerThread.postToMainThread(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(79965);
                      if ((this.Qet == null) || (this.Qet.isFinishing()))
                      {
                        AppMethodBeat.o(79965);
                        return;
                      }
                      if (localh != null)
                      {
                        com.tencent.mm.plugin.webview.d.h localh = localh;
                        JSONArray localJSONArray = this.QeE;
                        if (!localh.NoX)
                        {
                          Log.e("MicroMsg.JsApiHandler", "not ready");
                          AppMethodBeat.o(79965);
                          return;
                        }
                        if (localJSONArray == null)
                        {
                          Log.e("MicroMsg.JsApiHandler", "onGetMsgProofItems fail, not ready");
                          AppMethodBeat.o(79965);
                          return;
                        }
                        Log.i("MicroMsg.JsApiHandler", "onGetMsgProofItems success, ready");
                        HashMap localHashMap = new HashMap();
                        localHashMap.put("msgs", localJSONArray);
                        MMHandlerThread.postToMainThread(new h.72(localh, n.a.b("onGetMsgProofItems", localHashMap, localh.PNx, localh.EVx)));
                      }
                      AppMethodBeat.o(79965);
                    }
                  });
                  continue;
                  MMHandlerThread.postToMainThread(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(79967);
                      if ((this.Qet == null) || (this.Qet.isFinishing()))
                      {
                        AppMethodBeat.o(79967);
                        return;
                      }
                      if (localh != null) {
                        localh.bke(this.val$netType);
                      }
                      AppMethodBeat.o(79967);
                    }
                  });
                  continue;
                  paramBundle = new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(79968);
                      if ((this.Qet == null) || (this.Qet.isFinishing()))
                      {
                        AppMethodBeat.o(79968);
                        return;
                      }
                      Object localObject1;
                      String str1;
                      Object localObject2;
                      Bundle localBundle1;
                      String str2;
                      boolean bool;
                      if (paramBundle != null)
                      {
                        localObject1 = paramBundle.getString("key_bag_icon");
                        if (!Util.isNullOrNil((String)localObject1))
                        {
                          if (this.Qet.Qgq != null) {
                            this.Qet.Qgq.setIcon(Util.nullAsNil((String)localObject1));
                          }
                          if (this.Qet.Qgt != null) {
                            this.Qet.Qgt.aox((String)localObject1);
                          }
                          this.Qet.Qgs.aox((String)localObject1);
                        }
                        str1 = paramBundle.getString("key_brand_name");
                        localObject2 = paramBundle.getString("key_brand_user_name");
                        localObject1 = paramBundle.getString("key_title");
                        if (!Util.isNullOrNil((String)localObject2)) {
                          this.Qet.getIntent().putExtra("srcUsername", (String)localObject2);
                        }
                        Log.i("FloatBall", "currentMpInfo, brandName:%s, title:%s", new Object[] { str1, localObject1 });
                        if (this.Qet.PHI != null)
                        {
                          localObject2 = this.Qet.PHI;
                          localBundle1 = paramBundle;
                          if (localBundle1 != null)
                          {
                            str2 = localBundle1.getString("key_url");
                            if (!Util.isNullOrNil(str2)) {
                              break label448;
                            }
                            Log.w("MicroMsg.WebViewUIStyleHelper", "updateCurrentInfo url is null");
                          }
                        }
                        if (this.Qet.Qgj != null)
                        {
                          localObject2 = this.Qet.Qgj;
                          localBundle1 = paramBundle;
                          if (localBundle1 != null)
                          {
                            bool = localBundle1.getBoolean("key_forbidForward");
                            WebViewLongClickHelper.BrL.put(WebViewLongClickHelper.apf(((WebViewLongClickHelper)localObject2).pHO), Boolean.valueOf(bool));
                          }
                        }
                        if ((!Util.isNullOrNil((String)localObject1)) || (this.Qet.getMMTitle() == null)) {
                          break label728;
                        }
                        localObject1 = this.Qet.getMMTitle().toString();
                      }
                      label448:
                      label598:
                      label728:
                      for (;;)
                      {
                        if (!Util.isNullOrNil((String)localObject1))
                        {
                          if (this.Qet.Qgt != null) {
                            this.Qet.Qgt.aMT((String)localObject1);
                          }
                          this.Qet.Qgs.aoy((String)localObject1);
                          if (this.Qet.Qgq != null) {
                            this.Qet.Qgq.setTitle((String)localObject1);
                          }
                          if ((!Util.isNullOrNil(str1)) && (this.Qet.Qgt != null)) {
                            this.Qet.Qgt.aQZ(str1);
                          }
                          if (this.Qet.Qgq != null) {
                            ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.handoff.a.a.class)).e(this.Qet.Qgq);
                          }
                          AppMethodBeat.o(79968);
                          return;
                          Log.d("MicroMsg.WebViewUIStyleHelper", "updateCurrentInfo url %s", new Object[] { str2 });
                          String str3 = p.apf(str2);
                          Bundle localBundle2 = (Bundle)p.BrL.get(str3);
                          if (localBundle2 == null)
                          {
                            p.BrL.put(str3, localBundle1);
                            label504:
                            if ((!p.bz(localBundle1)) || (!p.gZs()) || (!((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).apb(str2))) {
                              break label598;
                            }
                            if (p.bb(localBundle1)) {
                              ((p)localObject2).gZy();
                            }
                            ((p)localObject2).apt(localBundle1.getString("key_brand_user_name"));
                            break;
                          }
                          if (localBundle2.getBoolean("key_current_info_show")) {}
                          for (bool = true;; bool = false)
                          {
                            localBundle1.putBoolean("key_current_info_show", bool);
                            p.BrL.put(str3, localBundle1);
                            break label504;
                            break;
                          }
                        }
                        localObject1 = this.Qet.Qgs;
                        if (((com.tencent.mm.plugin.webview.ui.tools.floatball.b)localObject1).rYE != null) {}
                        for (localObject1 = ((com.tencent.mm.plugin.webview.ui.tools.floatball.b)localObject1).rYE.name;; localObject1 = null)
                        {
                          if (Util.isNullOrNil((String)localObject1)) {
                            this.Qet.Qgs.aoy(str1);
                          }
                          if (Util.isNullOrNil(this.Qet.Qgt.PRr.title)) {
                            this.Qet.Qgt.aMT(str1);
                          }
                          if ((this.Qet.Qgq == null) || (!Util.isNullOrNil(this.Qet.Qgq.getTitle())) || (Util.isNullOrNil(str1))) {
                            break;
                          }
                          this.Qet.Qgq.setTitle(str1);
                          break;
                        }
                      }
                    }
                  };
                  if (Thread.currentThread() == Looper.getMainLooper().getThread())
                  {
                    paramBundle.run();
                  }
                  else
                  {
                    com.tencent.e.h.ZvG.be(paramBundle);
                    continue;
                    paramBundle = paramBundle.getString("service_click_tid");
                    Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "on service click, update tid = %s", new Object[] { paramBundle });
                    ((WebViewUI)localObject1).Qgo = paramBundle;
                    ((WebViewUI)localObject1).Qgp = System.currentTimeMillis();
                    MMHandlerThread.postToMainThread(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(79969);
                        if ((this.Qet == null) || (this.Qet.isFinishing()))
                        {
                          AppMethodBeat.o(79969);
                          return;
                        }
                        if (this.Qet.pHS != null)
                        {
                          com.tencent.mm.plugin.normsg.a.d.GxJ.a(this.Qet.pHS, ve.class);
                          if (this.Qet.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).getBoolean("forceTrigger", false))
                          {
                            Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "on service click, test");
                            EventCenter.instance.publish(new ve());
                          }
                        }
                        AppMethodBeat.o(79969);
                      }
                    });
                    continue;
                    MMHandlerThread.postToMainThread(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(79970);
                        if ((this.Qet == null) || (this.Qet.isFinishing()))
                        {
                          AppMethodBeat.o(79970);
                          return;
                        }
                        if (localh != null)
                        {
                          com.tencent.mm.plugin.webview.d.h localh = localh;
                          String str = this.QeF;
                          int i = this.QeG;
                          if (!localh.NoX)
                          {
                            Log.e("MicroMsg.JsApiHandler", "not ready");
                            AppMethodBeat.o(79970);
                            return;
                          }
                          HashMap localHashMap = new HashMap();
                          localHashMap.put("postId", str);
                          localHashMap.put("result", Integer.valueOf(i));
                          MMHandlerThread.postToMainThread(new h.74(localh, n.a.b("onPublishHaowanEnd", localHashMap, localh.PNx, localh.EVx)));
                        }
                        AppMethodBeat.o(79970);
                      }
                    });
                    continue;
                    MMHandlerThread.postToMainThread(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(79971);
                        if ((this.Qet == null) || (this.Qet.isFinishing()))
                        {
                          AppMethodBeat.o(79971);
                          return;
                        }
                        if (localh != null)
                        {
                          com.tencent.mm.plugin.webview.d.h localh = localh;
                          String str = this.QeF;
                          float f = this.qFP;
                          if (!localh.NoX)
                          {
                            Log.e("MicroMsg.JsApiHandler", "not ready");
                            AppMethodBeat.o(79971);
                            return;
                          }
                          HashMap localHashMap = new HashMap();
                          localHashMap.put("postId", str);
                          localHashMap.put("percent", Float.valueOf(f));
                          MMHandlerThread.postToMainThread(new h.76(localh, n.a.b("onPublishHaowanProgress", localHashMap, localh.PNx, localh.EVx)));
                        }
                        AppMethodBeat.o(79971);
                      }
                    });
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public final Bundle l(int paramInt, final Bundle paramBundle)
  {
    AppMethodBeat.i(80028);
    Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "invokeAsResult, actionCode = ".concat(String.valueOf(paramInt)));
    final Bundle localBundle = new Bundle();
    if ((this.PXH.get() == null) || (((WebViewUI)this.PXH.get()).isFinishing()))
    {
      AppMethodBeat.o(80028);
      return localBundle;
    }
    Object localObject1 = ((WebViewUI)this.PXH.get()).pGD;
    Object localObject3;
    boolean bool1;
    boolean bool2;
    label1613:
    int i;
    int j;
    Object localObject2;
    switch (paramInt)
    {
    default: 
      Log.e("MicroMsg.WebViewStubCallbackAIDLStub", "undefine action code!!!");
    case 48: 
    case 49: 
    case 100000: 
    case 4001: 
    case 4002: 
    case 4003: 
    case 4004: 
    case 4005: 
    case 4008: 
    case 18: 
    case 77: 
    case 33: 
    case 22: 
    case 303: 
    case 25: 
    case 99: 
    case 1020: 
    case 5001: 
    case 5002: 
    case 5003: 
    case 5004: 
    case 5005: 
    case 5006: 
    case 5007: 
    case 38: 
    case 34: 
    case 36: 
    case 47: 
    case 35: 
    case 39: 
    case 37: 
    case 79: 
    case 43: 
      for (;;)
      {
        AppMethodBeat.o(80028);
        return localBundle;
        ((WebViewUI)this.PXH.get()).Qgg = true;
        continue;
        localObject1 = new com.tencent.mm.f.a.k();
        ((com.tencent.mm.f.a.k)localObject1).fuF.context = ((WebViewUI)this.PXH.get()).getContext();
        ((com.tencent.mm.f.a.k)localObject1).fuF.actionCode = paramInt;
        if (4003 == paramInt)
        {
          paramBundle = paramBundle.getString("apdu");
          ((com.tencent.mm.f.a.k)localObject1).fuF.fuH = paramBundle;
        }
        for (;;)
        {
          ((com.tencent.mm.f.a.k)localObject1).callback = new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(79981);
              localBundle.putAll(this.QeJ.fuG.fuK);
              AppMethodBeat.o(79981);
            }
          };
          EventCenter.instance.publish((IEvent)localObject1);
          break;
          if (4004 == paramInt)
          {
            localObject3 = paramBundle.getString("apdus");
            bool1 = paramBundle.getBoolean("breakIfFail", true);
            bool2 = paramBundle.getBoolean("breakIfTrue", false);
            ((com.tencent.mm.f.a.k)localObject1).fuF.fuH = ((String)localObject3);
            ((com.tencent.mm.f.a.k)localObject1).fuF.fuI = bool1;
            ((com.tencent.mm.f.a.k)localObject1).fuF.fuJ = bool2;
          }
        }
        localBundle.putString("KPublisherId", ((WebViewUI)this.PXH.get()).fUj);
        paramBundle = getIntent();
        if (paramBundle != null)
        {
          paramInt = bjD(getIntent().getStringExtra("geta8key_username"));
          localBundle.putString("preChatName", paramBundle.getStringExtra("preChatName"));
          localBundle.putInt("preMsgIndex", paramBundle.getIntExtra("preMsgIndex", 0));
          localBundle.putString("prePublishId", paramBundle.getStringExtra("prePublishId"));
          localBundle.putString("preUsername", paramBundle.getStringExtra("preUsername"));
          localBundle.putInt("getA8KeyScene", paramInt);
          localBundle.putString("referUrl", ((WebViewUI)this.PXH.get()).gYF());
          localBundle.putString("url", ((WebViewUI)this.PXH.get()).elY());
          localBundle.putString("rawUrl", ((WebViewUI)this.PXH.get()).cDu());
          localBundle.putInt("preChatTYPE", getIntent().getIntExtra("preChatTYPE", 0));
          localBundle.putString("KAppId", paramBundle.getStringExtra("KAppId"));
          ((WebViewUI)this.PXH.get()).aY(localBundle);
          continue;
          localBundle.putString("KSessionId", ((WebViewUI)this.PXH.get()).sessionId);
          localBundle.putString("KUserAgent", ((WebViewUI)this.PXH.get()).getUserAgent());
          localBundle.putString("KUrl", ((WebViewUI)this.PXH.get()).elY());
          paramInt = bjD(getIntent().getStringExtra("geta8key_username"));
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
              Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "key value: pay channel(%d)", new Object[] { Integer.valueOf(getIntent().getIntExtra("pay_channel", -1)) });
              continue;
              localBundle.putInt("pay_chat_type", getIntent().getIntExtra("pay_chat_type", 0));
              Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "key value: pay chat type(%d)", new Object[] { Integer.valueOf(getIntent().getIntExtra("pay_chat_type", 0)) });
              continue;
              localBundle.putInt("scene", getIntent().getIntExtra("scene", -1));
              Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "Key value: Scene(%d)", new Object[] { Integer.valueOf(getIntent().getIntExtra("scene", 0)) });
              continue;
              paramInt = getIntent().getIntExtra("geta8key_scene", 0);
              localBundle.putInt("geta8key_scene", paramInt);
              Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "Key value: getA8KeyScene(%d)", new Object[] { Integer.valueOf(paramInt) });
              continue;
              paramBundle = (WebViewUI)this.PXH.get();
              if (paramBundle == null)
              {
                Log.e("MicroMsg.WebViewStubCallbackAIDLStub", "GetA8key req params, WebViewUI is nil");
              }
              else
              {
                paramBundle = paramBundle.PIQ;
                if (paramBundle == null)
                {
                  Log.e("MicroMsg.WebViewStubCallbackAIDLStub", "GetA8key req params, controller is nil");
                }
                else
                {
                  paramBundle = paramBundle.gSU();
                  localBundle.putInt("key_get_a8key_req_params_req_id", paramBundle.getSessionId());
                  localBundle.putString("key_get_a8key_req_params_msg_id", paramBundle.gWH());
                  localBundle.putString("key_get_a8key_req_params_username", paramBundle.getUsername());
                  localBundle.putString("key_get_a8key_req_params_msg_username", paramBundle.gWG());
                  continue;
                  A(paramInt, paramBundle);
                  if (((WebViewUI)this.PXH.get()).pGC.isSDCardAvailable())
                  {
                    long l = SdcardUtil.getAvailableExternalMemorySize2();
                    Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "availableSize = %d", new Object[] { Long.valueOf(l) });
                    if (l < 524288000L)
                    {
                      Log.e("MicroMsg.WebViewStubCallbackAIDLStub", "available size not enough");
                      paramInt = FactoryProxyManager.getPlayManager().init(MMApplicationContext.getContext(), null);
                    }
                  }
                  for (;;)
                  {
                    if (paramInt == 0)
                    {
                      if (((WebViewUI)this.PXH.get()).Qgl == null)
                      {
                        ((WebViewUI)this.PXH.get()).Qgl = ((WebViewUI)this.PXH.get()).gYr();
                        FactoryProxyManager.getPlayManager().setUtilsObject(((WebViewUI)this.PXH.get()).Qgl);
                      }
                      i = FactoryProxyManager.getPlayManager().getLocalServerPort();
                      Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "webview video init result = %d, local port = %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
                      ((WebViewUI)this.PXH.get()).gYp().anR(i);
                    }
                    localBundle.putInt("webview_video_proxy_init", paramInt);
                    break;
                    paramBundle = new com.tencent.mm.vfs.q(com.tencent.mm.plugin.webview.a.PDD);
                    bool1 = true;
                    if (!paramBundle.ifE())
                    {
                      bool1 = paramBundle.ifL();
                      Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "create proxy cache path : %s, %b", new Object[] { paramBundle.bOF(), Boolean.valueOf(bool1) });
                    }
                    if (!bool1) {
                      break label1613;
                    }
                    paramInt = FactoryProxyManager.getPlayManager().init(MMApplicationContext.getContext(), com.tencent.mm.b.q.n(paramBundle.bOF(), false));
                    FactoryProxyManager.getPlayManager().setMaxStorageSize(200L);
                    continue;
                    Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "sdcard not available");
                    paramInt = FactoryProxyManager.getPlayManager().init(MMApplicationContext.getContext(), null);
                  }
                  A(paramInt, paramBundle);
                  localObject1 = paramBundle.getString("webview_video_proxy_cdn_urls");
                  localObject3 = paramBundle.getString("webview_video_proxy_fileId");
                  paramInt = paramBundle.getInt("webview_video_proxy_file_size");
                  i = paramBundle.getInt("webview_video_proxy_file_duration");
                  j = paramBundle.getInt("webview_video_proxy_file_type");
                  int k = FactoryProxyManager.getPlayManager().startPlay((String)localObject1, j, (String)localObject3, paramInt, i);
                  paramBundle = FactoryProxyManager.getPlayManager().buildPlayURLMp4(k);
                  Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "cdnurls = %s, filedId = %s, fileSize = %d, fileDuration = %d, fileType = %d, playDataId = %d, localUrl = %s", new Object[] { localObject1, localObject3, Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), paramBundle });
                  localBundle.putInt("webview_video_proxy_play_data_id", k);
                  localBundle.putString("webview_video_proxy_local_url", paramBundle);
                  continue;
                  A(paramInt, paramBundle);
                  paramInt = paramBundle.getInt("webview_video_proxy_play_data_id");
                  Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "webview proxy stop play, play id = %d", new Object[] { Integer.valueOf(paramInt) });
                  if (paramInt > 0)
                  {
                    FactoryProxyManager.getPlayManager().stopPlay(paramInt);
                    continue;
                    A(paramInt, paramBundle);
                    paramInt = paramBundle.getInt("webview_video_proxy_play_state");
                    FactoryProxyManager.getPlayManager().setPlayerState(paramInt);
                    continue;
                    A(paramInt, paramBundle);
                    paramInt = paramBundle.getInt("webview_video_proxy_net_state");
                    FactoryProxyManager.getPlayManager().setNetWorkState(paramInt);
                    continue;
                    A(paramInt, paramBundle);
                    paramInt = paramBundle.getInt("webview_video_proxy_play_data_id");
                    i = paramBundle.getInt("webview_video_proxy_play_remain_time");
                    FactoryProxyManager.getPlayManager().setRemainTime(paramInt, i);
                    continue;
                    A(paramInt, paramBundle);
                    paramInt = paramBundle.getInt("webview_video_proxy_play_data_id");
                    i = paramBundle.getInt("webview_video_proxy_preload_duration");
                    Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "playid = %d, duration = %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
                    localBundle.putInt("webview_video_proxy_pre_load_result", FactoryProxyManager.getPlayManager().preLoad(paramInt, i));
                    continue;
                    A(paramInt, paramBundle);
                    if (paramBundle.getInt("webview_disable_bounce_scroll_top", 0) > 0)
                    {
                      MMHandlerThread.postToMainThread(new Runnable()
                      {
                        public final void run()
                        {
                          AppMethodBeat.i(79982);
                          if ((n.a(n.this).get() == null) || (((WebViewUI)n.a(n.this).get()).isFinishing()))
                          {
                            AppMethodBeat.o(79982);
                            return;
                          }
                          ((WebViewUI)n.a(n.this).get()).QgG.Dc(true);
                          AppMethodBeat.o(79982);
                        }
                      });
                      continue;
                      A(paramInt, paramBundle);
                      MMHandlerThread.postToMainThread(new Runnable()
                      {
                        public final void run()
                        {
                          AppMethodBeat.i(79983);
                          if ((n.a(n.this).get() == null) || (((WebViewUI)n.a(n.this).get()).isFinishing()))
                          {
                            AppMethodBeat.o(79983);
                            return;
                          }
                          Object localObject = (WebViewUI)n.a(n.this).get();
                          ((WebViewUI)localObject).QgG.QdZ = new WebViewUI.5((WebViewUI)localObject);
                          localObject = ((WebViewUI)localObject).QgG;
                          ((l)localObject).nWH = true;
                          if (((l)localObject).Qeb != null)
                          {
                            ((l)localObject).Qeb.setVisibility(0);
                            ((l)localObject).Qeb.setMMOverScrollOffsetListener((LogoWebViewWrapper.b)localObject);
                            ((l)localObject).Qeb.setFastScrollBack(true);
                            ((l)localObject).Qeb.Dc(false);
                            ((l)localObject).Qeb.setReleaseTargetHeight(((l)localObject).Qec);
                          }
                          if (((l)localObject).Qea != null)
                          {
                            ((l)localObject).Qea.setWillNotDraw(true);
                            ((l)localObject).Qea.setImageResource(l.Qed);
                            ((l)localObject).Qea.setVisibility(0);
                            ((l)localObject).Qea.setAlpha(0.0F);
                            ((l)localObject).Qea.setWillNotDraw(false);
                            ((l)localObject).Qea.invalidate();
                          }
                          ((l)localObject).gYf();
                          AppMethodBeat.o(79983);
                        }
                      });
                      continue;
                      MMHandlerThread.postToMainThread(new Runnable()
                      {
                        public final void run()
                        {
                          AppMethodBeat.i(79984);
                          if ((n.a(n.this).get() == null) || (((WebViewUI)n.a(n.this).get()).isFinishing()))
                          {
                            AppMethodBeat.o(79984);
                            return;
                          }
                          ((WebViewUI)n.a(n.this).get()).QgG.stopLoading();
                          AppMethodBeat.o(79984);
                        }
                      });
                      continue;
                      A(paramInt, paramBundle);
                      MMHandlerThread.postToMainThread(new Runnable()
                      {
                        public final void run()
                        {
                          AppMethodBeat.i(79985);
                          if ((n.a(n.this).get() == null) || (((WebViewUI)n.a(n.this).get()).isFinishing()))
                          {
                            AppMethodBeat.o(79985);
                            return;
                          }
                          ((WebViewUI)n.a(n.this).get()).QgG.gYe();
                          AppMethodBeat.o(79985);
                        }
                      });
                      continue;
                      MMHandlerThread.postToMainThread(new Runnable()
                      {
                        public final void run()
                        {
                          AppMethodBeat.i(79986);
                          if ((n.a(n.this).get() == null) || (((WebViewUI)n.a(n.this).get()).isFinishing()))
                          {
                            AppMethodBeat.o(79986);
                            return;
                          }
                          ((WebViewUI)n.a(n.this).get()).QgG.startLoading();
                          AppMethodBeat.o(79986);
                        }
                      });
                      continue;
                      MMHandlerThread.postToMainThread(new Runnable()
                      {
                        public final void run()
                        {
                          AppMethodBeat.i(79987);
                          if ((n.a(n.this).get() == null) || (((WebViewUI)n.a(n.this).get()).isFinishing()))
                          {
                            AppMethodBeat.o(79987);
                            return;
                          }
                          WebViewUI localWebViewUI = (WebViewUI)n.a(n.this).get();
                          if (localWebViewUI.pHS != null) {
                            localWebViewUI.pHS.evaluateJavascript("javascript:(function(){return window.getComputedStyle(document.body,null).backgroundColor})()", new WebViewUI.6(localWebViewUI));
                          }
                          AppMethodBeat.o(79987);
                        }
                      });
                      continue;
                      localObject1 = paramBundle.getString("show_kb_placeholder");
                      paramInt = paramBundle.getInt("show_kb_max_length");
                      i = paramBundle.getInt("show_kb_show_remind_word_count");
                      localObject3 = paramBundle.getString("show_kb_text");
                      bool1 = paramBundle.getBoolean("show_kb_to_show");
                      if ((this.PXH.get() == null) || (((WebViewUI)this.PXH.get()).isFinishing()))
                      {
                        AppMethodBeat.o(80028);
                        return null;
                      }
                      if (bool1)
                      {
                        ((WebViewUI)this.PXH.get()).t((String)localObject3, (String)localObject1, paramInt, i);
                      }
                      else
                      {
                        ((WebViewUI)this.PXH.get()).gYJ();
                        continue;
                        if ((this.PXH.get() != null) && (!((WebViewUI)this.PXH.get()).isFinishing()))
                        {
                          localBundle.putInt("height", ((WebViewUI)this.PXH.get()).gYK());
                          continue;
                          A(paramInt, paramBundle);
                          localObject1 = paramBundle.getString("set_page_title_text");
                          localObject3 = (WebViewUI)this.PXH.get();
                          if ((localObject3 != null) && (!((WebViewUI)localObject3).isFinishing()) && (((WebViewUI)localObject3).IYi))
                          {
                            if (localObject1 != null) {
                              ((WebViewUI)localObject3).setMMTitle((String)localObject1);
                            }
                            float f = paramBundle.getFloat("set_page_title_alpha", 1.0F);
                            ((WebViewUI)localObject3).setMMTitleColor(e.he(paramBundle.getString("set_page_title_color"), ((WebViewUI)this.PXH.get()).gYB()));
                            if ((f >= 0.0F) && (f <= 1.0D)) {
                              ((WebViewUI)localObject3).setTitleAlpha(f);
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
    case 44: 
      A(paramInt, paramBundle);
      localObject3 = paramBundle.getString("set_navigation_bar_buttons_text");
      localObject1 = paramBundle.getString("set_navigation_bar_buttons_icon_data");
      bool1 = paramBundle.getBoolean("set_navigation_bar_buttons_hide_right_button", false);
      boolean bool3 = paramBundle.getBoolean("set_navigation_bar_right_style", false);
      if (!Util.isNullOrNil((String)localObject1)) {}
      for (;;)
      {
        try
        {
          localObject1 = e.bmc((String)localObject1);
          paramInt = e.he(paramBundle.getString("set_navigation_bar_buttons_left_text_color"), -16777216);
          bool2 = paramBundle.getBoolean("set_navigation_bar_buttons_need_click_event", false);
          i = (int)e.bmb(paramBundle.getString("set_navigation_bar_buttons_text_color"));
          if ((this.PXH.get() == null) || (((WebViewUI)this.PXH.get()).isFinishing())) {
            break;
          }
          if ((bool3) && (((WebViewUI)this.PXH.get()).gYo() != null)) {
            ((WebViewUI)this.PXH.get()).gYo().hbw();
          }
          if (!bool1) {
            break label2866;
          }
          ((WebViewUI)this.PXH.get()).Dj(true);
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.WebViewStubCallbackAIDLStub", "setNavigationBarButtons, decode base64 image, exception = %s", new Object[] { localException });
          localObject2 = null;
          continue;
        }
        localObject2 = null;
      }
      label2866:
      paramBundle = ((WebViewUI)this.PXH.get()).elY();
      if (Util.isNullOrNil(paramBundle)) {
        break;
      }
    }
    for (paramBundle = (Boolean)((WebViewUI)this.PXH.get()).QfP.get(paramBundle);; paramBundle = null)
    {
      if (paramBundle == null)
      {
        bool1 = false;
        label2915:
        ((WebViewUI)this.PXH.get()).Dj(Boolean.valueOf(bool1).booleanValue());
        if ((localObject2 == null) || (((Bitmap)localObject2).isRecycled())) {
          break label3040;
        }
        ((WebViewUI)this.PXH.get()).b((String)localObject3, new BitmapDrawable(((WebViewUI)this.PXH.get()).getResources(), (Bitmap)localObject2));
        if (bool2) {
          ((WebViewUI)this.PXH.get()).updateOptionMenuListener(0, new MenuItem.OnMenuItemClickListener()
          {
            public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
            {
              AppMethodBeat.i(214692);
              Log.d("MicroMsg.WebViewStubCallbackAIDLStub", "click item: %s", new Object[] { Integer.valueOf(paramAnonymousMenuItem.getItemId()) });
              ((WebViewUI)n.a(n.this).get()).PvJ.gUa();
              AppMethodBeat.o(214692);
              return false;
            }
          }, null);
        }
      }
      for (;;)
      {
        ((WebViewUI)this.PXH.get()).aoC(paramInt);
        break;
        bool1 = paramBundle.booleanValue();
        break label2915;
        label3040:
        if (!Util.isNullOrNil((String)localObject3))
        {
          if (i == -1) {
            ((WebViewUI)this.PXH.get()).addTextOptionMenu(0, (String)localObject3, new MenuItem.OnMenuItemClickListener()
            {
              public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
              {
                AppMethodBeat.i(236144);
                Log.d("MicroMsg.WebViewStubCallbackAIDLStub", "click item: %s", new Object[] { Integer.valueOf(paramAnonymousMenuItem.getItemId()) });
                ((WebViewUI)n.a(n.this).get()).PvJ.gUa();
                AppMethodBeat.o(236144);
                return false;
              }
            });
          } else {
            ((WebViewUI)this.PXH.get()).addTextOptionMenu(0, (String)localObject3, i, new MenuItem.OnMenuItemClickListener()
            {
              public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
              {
                AppMethodBeat.i(234129);
                Log.d("MicroMsg.WebViewStubCallbackAIDLStub", "click item: %s", new Object[] { Integer.valueOf(paramAnonymousMenuItem.getItemId()) });
                ((WebViewUI)n.a(n.this).get()).PvJ.gUa();
                AppMethodBeat.o(234129);
                return false;
              }
            });
          }
        }
        else {
          ((WebViewUI)this.PXH.get()).addIconOptionMenu(0, ((WebViewUI)this.PXH.get()).gYV(), new MenuItem.OnMenuItemClickListener()
          {
            public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
            {
              AppMethodBeat.i(241325);
              Log.d("MicroMsg.WebViewStubCallbackAIDLStub", "click item: %s", new Object[] { Integer.valueOf(paramAnonymousMenuItem.getItemId()) });
              ((WebViewUI)n.a(n.this).get()).PvJ.gUa();
              AppMethodBeat.o(241325);
              return false;
            }
          }, ((WebViewUI)this.PXH.get()).QgN);
        }
      }
      A(paramInt, paramBundle);
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(79997);
          if ((n.a(n.this).get() == null) || (((WebViewUI)n.a(n.this).get()).isFinishing()))
          {
            AppMethodBeat.o(79997);
            return;
          }
          boolean bool = paramBundle.getBoolean("enable_fullscreen_params_enable", false);
          if (n.b(n.this) != null) {
            n.b(n.this).removeExtra("show_full_screen");
          }
          ((WebViewUI)n.a(n.this).get()).bh(bool, false);
          AppMethodBeat.o(79997);
        }
      });
      break;
      if ((this.PXH.get() == null) || (((WebViewUI)this.PXH.get()).isFinishing()))
      {
        localBundle.putBoolean("isFullScreen", false);
        break;
      }
      localBundle.putBoolean("isFullScreen", ((WebViewUI)this.PXH.get()).cgP());
      break;
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(79998);
          if ((n.a(n.this).get() == null) || (((WebViewUI)n.a(n.this).get()).isFinishing()))
          {
            AppMethodBeat.o(79998);
            return;
          }
          if ((((WebViewUI)n.a(n.this).get()).QfR != null) && (((WebViewUI)n.a(n.this).get()).QfR.isShowing())) {
            ((WebViewUI)n.a(n.this).get()).QfR.dismiss();
          }
          AppMethodBeat.o(79998);
        }
      });
      break;
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(79999);
          if ((n.a(n.this).get() == null) || (((WebViewUI)n.a(n.this).get()).isFinishing()))
          {
            AppMethodBeat.o(79999);
            return;
          }
          ((WebViewUI)n.a(n.this).get()).QfQ = null;
          AppMethodBeat.o(79999);
        }
      });
      break;
      bool1 = paramBundle.getBoolean("clear_webview_cache_clear_cookie", false);
      Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "includeCookie = %b", new Object[] { Boolean.valueOf(bool1) });
      paramBundle = new Intent();
      paramBundle.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE");
      paramBundle.putExtra("tools_clean_webview_cache_ignore_cookie", bool1);
      com.tencent.mm.xwebutil.c.bN(paramBundle);
      break;
      if (!paramBundle.getString("enterprise_action").equals("enterprise_get_context_bizchat")) {
        break;
      }
      localBundle.putString("enterprise_context_biz", getIntent().getStringExtra("enterprise_biz_name"));
      localBundle.putLong("enterprise_context_bizchatid", getIntent().getLongExtra("biz_chat_chat_id", -1L));
      break;
      A(paramInt, paramBundle);
      paramInt = e.he(paramBundle.getString("key_set_bounce_background_color"), ((WebViewUI)this.PXH.get()).getResources().getColor(c.c.webview_logo_bg_color));
      ((WebViewUI)this.PXH.get()).QgG.aoA(paramInt);
      break;
      localObject2 = getIntent();
      if (paramBundle == null) {
        break;
      }
      paramInt = paramBundle.getInt("scene");
      switch (paramInt)
      {
      default: 
        Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "unknown expose scene: %d", new Object[] { Integer.valueOf(paramInt) });
      }
      for (;;)
      {
        localBundle.putString("username", ((Intent)localObject2).getStringExtra("k_username"));
        break;
        localBundle.putStringArrayList("proof", ((Intent)localObject2).getStringArrayListExtra("k_outside_expose_proof_item_list"));
        continue;
        localBundle.putString("newMsgId", t.Qu(((Intent)localObject2).getLongExtra("k_expose_msg_id", 0L)));
        continue;
        if (!Util.isNullOrNil(((Intent)localObject2).getStringExtra("k_webview_img")))
        {
          paramBundle = ((Intent)localObject2).getStringExtra("k_webview_img");
          localObject3 = u.aY(paramBundle, 0, (int)u.bBQ(paramBundle));
          u.deleteFile(paramBundle);
          localBundle.putString("webviewImg", Base64.encodeToString((byte[])localObject3, 0));
        }
        if (((Intent)localObject2).getStringExtra("k_webview_html") != null) {
          localBundle.putString("webviewHtml", ((Intent)localObject2).getStringExtra("k_webview_html"));
        }
        paramBundle = new StringBuilder();
        paramBundle.append("<exposecontent>");
        paramBundle.append("<weburl>");
        if (((Intent)localObject2).getStringExtra("k_expose_url") != null) {
          paramBundle.append(((Intent)localObject2).getStringExtra("k_expose_url"));
        }
        paramBundle.append("</weburl>");
        paramBundle.append("<firstJumpUrl>");
        if (((Intent)localObject2).getStringExtra("k_expose_raw_url") != null) {
          paramBundle.append(((Intent)localObject2).getStringExtra("k_expose_raw_url"));
        }
        paramBundle.append("</firstJumpUrl>");
        paramBundle.append("<webscence>");
        paramBundle.append(((Intent)localObject2).getIntExtra("k_expose_web_scene", 0));
        paramBundle.append("</webscence>");
        paramBundle.append("</exposecontent>");
        localBundle.putString("url", paramBundle.toString());
        continue;
        localBundle.putString("newMsgId", String.valueOf(((Intent)localObject2).getLongExtra("k_expose_msg_id", 0L)));
        localBundle.putStringArrayList("proof", ((Intent)localObject2).getStringArrayListExtra("k_outside_expose_proof_item_list"));
        localBundle.putInt("msgType", ((Intent)localObject2).getIntExtra("k_expose_msg_type", 0));
        continue;
        localBundle.putString("realChatUser", ((Intent)localObject2).getStringExtra("k_realchatuser"));
      }
      A(paramInt, paramBundle);
      if ((this.PXH.get() == null) || (((WebViewUI)this.PXH.get()).isFinishing())) {
        break;
      }
      ((WebViewUI)this.PXH.get()).aX(paramBundle);
      break;
      localBundle.putStringArray("webview_get_route_url_list", ((WebViewUI)this.PXH.get()).PIQ.gSO().gWE());
      localBundle.putInt("webview_get_route_url_geta8key_scene", bjD(getIntent().getStringExtra("geta8key_username")));
      localBundle.putString("geta8key_username", getIntent().getStringExtra("geta8key_username"));
      break;
      localObject2 = ((WebViewUI)this.PXH.get()).elY();
      localObject3 = com.tencent.xweb.c.ivX().getCookie((String)localObject2);
      Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "url = %s, cookie = %s", new Object[] { localObject2, localObject3 });
      localBundle.putString("cookie", (String)localObject3);
      localBundle.putFloat("density", clS());
      if (paramBundle == null) {
        break;
      }
      localBundle.putString("currentUrlPath", j.blm(paramBundle.getString("currentPicUrl")));
      break;
      localBundle.putBoolean("from_shortcut", ((WebViewUI)this.PXH.get()).Qfx);
      break;
      paramBundle.setClassLoader(WebViewUI.class.getClassLoader());
      com.tencent.mm.by.c.b((Context)this.PXH.get(), paramBundle.getString("open_ui_with_webview_ui_plugin_name"), paramBundle.getString("open_ui_with_webview_ui_plugin_entry"), new Intent().putExtras(paramBundle.getBundle("open_ui_with_webview_ui_extras")).putExtra("KPublisherId", ((WebViewUI)this.PXH.get()).fUj).putExtra("key_search_icon_and_hint_fix_default", true));
      break;
      A(paramInt, paramBundle);
      localObject2 = paramBundle.getString("traceid");
      paramBundle = paramBundle.getString("username");
      m.Qer.mF((String)localObject2, paramBundle);
      break;
      paramBundle = ((WebViewUI)this.PXH.get()).getMMTitle();
      localObject2 = getCurrentUrl();
      if ((Util.isNullOrNil(paramBundle)) && (((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).apb((String)localObject2))) {
        paramBundle = getIntent().getStringExtra("webpageTitle");
      }
      for (;;)
      {
        localBundle.putString("webview_current_url", (String)localObject2);
        if (paramBundle != null) {}
        for (paramBundle = paramBundle.toString();; paramBundle = "")
        {
          localBundle.putString("webview_current_title", paramBundle);
          localBundle.putString("webview_current_desc", (String)localObject2);
          break;
        }
        paramBundle = ((WebViewUI)this.PXH.get()).getMMTitle();
        localObject2 = getCurrentUrl();
        localObject3 = getIntent();
        if (localObject3 != null)
        {
          localBundle.putString("share_report_pre_msg_url", ((Intent)localObject3).getStringExtra("share_report_pre_msg_url"));
          localBundle.putString("share_report_pre_msg_title", ((Intent)localObject3).getStringExtra("share_report_pre_msg_title"));
          localBundle.putString("share_report_pre_msg_desc", ((Intent)localObject3).getStringExtra("share_report_pre_msg_desc"));
          localBundle.putString("share_report_pre_msg_icon_url", ((Intent)localObject3).getStringExtra("share_report_pre_msg_icon_url"));
          localBundle.putString("share_report_pre_msg_appid", ((Intent)localObject3).getStringExtra("share_report_pre_msg_appid"));
          localBundle.putInt("share_report_from_scene", ((Intent)localObject3).getIntExtra("share_report_from_scene", 0));
          localBundle.putString("share_report_biz_username", ((Intent)localObject3).getStringExtra("share_report_biz_username"));
          localObject3 = ((Intent)localObject3).getBundleExtra("ad_report_bundle");
          if ((!Util.isNullOrNil((String)localObject2)) && (localObject3 != null) && (!Util.isNullOrNil(((Bundle)localObject3).getString("ad_report_ux_info"))))
          {
            localObject5 = Uri.parse((String)localObject2);
            localObject4 = ((Uri)localObject5).getQueryParameter("mid");
            localObject5 = ((Uri)localObject5).getQueryParameter("idx");
            ((Bundle)localObject3).putString("ad_report_mid", (String)localObject4);
            ((Bundle)localObject3).putString("ad_report_idx", (String)localObject5);
            localBundle.putBundle("ad_report_bundle", (Bundle)localObject3);
          }
        }
        localBundle.putString("share_report_current_url", (String)localObject2);
        if (paramBundle != null) {}
        for (paramBundle = paramBundle.toString();; paramBundle = "")
        {
          localBundle.putString("share_report_current_title", paramBundle);
          break;
        }
        if (((WebViewUI)this.PXH.get()).gYj())
        {
          localBundle.putString("result", "not_return");
          break;
        }
        localBundle.putString("full_url", Util.nullAsNil(((WebViewUI)this.PXH.get()).pHq));
        if ((((WebViewUI)this.PXH.get()).gYk() != null) && (((WebViewUI)this.PXH.get()).gYk().size() != 0))
        {
          localBundle.putInt("set_cookie", 1);
          com.tencent.xweb.d.my(MMApplicationContext.getContext());
          paramBundle = com.tencent.xweb.c.ivX();
          localObject2 = ((WebViewUI)this.PXH.get()).gYk().keySet().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (String)((Iterator)localObject2).next();
            paramBundle.setCookie(Util.getDomin(((WebViewUI)this.PXH.get()).pHq), (String)localObject3 + "=" + (String)((WebViewUI)this.PXH.get()).gYk().get(localObject3));
          }
          paramBundle.setCookie(Util.getDomin(((WebViewUI)this.PXH.get()).pHq), "httponly");
          com.tencent.xweb.d.ivZ();
          com.tencent.xweb.d.sync();
          Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "cookies:%s", new Object[] { paramBundle.getCookie(Util.getDomin(((WebViewUI)this.PXH.get()).pHq)) });
          break;
        }
        localBundle.putInt("set_cookie", 0);
        break;
        bool1 = paramBundle.getBoolean("add_shortcut_status");
        if (((WebViewUI)this.PXH.get()).PvJ == null) {
          break;
        }
        ((WebViewUI)this.PXH.get()).PvJ.CS(bool1);
        break;
        localBundle.putBoolean("is_from_keep_top", getIntent().getBooleanExtra("is_from_keep_top", false));
        break;
        if (((WebViewUI)this.PXH.get()).Qfg != null) {
          ((WebViewUI)this.PXH.get()).Qfg.disable();
        }
        ((WebViewUI)this.PXH.get()).PJe = paramBundle.getInt("screen_orientation", -1);
        if (((WebViewUI)this.PXH.get()).PJe == 1001)
        {
          ((WebViewUI)this.PXH.get()).PJe = 0;
          if (((WebViewUI)this.PXH.get()).Qfg != null)
          {
            Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "OrientationListener, start listen orientation change");
            ((WebViewUI)this.PXH.get()).Qfg.enable();
          }
        }
        for (;;)
        {
          ((WebViewUI)this.PXH.get()).setMMOrientation();
          break;
          if (((WebViewUI)this.PXH.get()).PJe == 1002)
          {
            ((WebViewUI)this.PXH.get()).PJe = 1;
            if (((WebViewUI)this.PXH.get()).Qfg != null)
            {
              Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "OrientationListener, start listen orientation change");
              ((WebViewUI)this.PXH.get()).Qfg.enable();
            }
          }
        }
        ((WebViewUI)this.PXH.get()).aW(paramBundle);
        break;
        localBundle.putInt("web_page_count", WebViewUI.Qgb);
        break;
        localBundle.putString("geta8key_data_req_url", ((WebViewUI)this.PXH.get()).cDu());
        localBundle.putString("geta8key_data_username", getIntent().getStringExtra("geta8key_username"));
        localBundle.putInt("geta8key_data_scene", bjD(getIntent().getStringExtra("geta8key_username")));
        localBundle.putInt("geta8key_data_reason", 8);
        if (((WebViewUI)this.PXH.get()).pHS.getIsX5Kernel()) {
          localBundle.putInt("geta8key_data_flag", 1);
        }
        for (;;)
        {
          this.PXH.get();
          localBundle.putString("geta8key_data_net_type", ba.gVU());
          localBundle.putInt("geta8key_session_id", ((WebViewUI)this.PXH.get()).Qfy);
          localBundle.putInt("webview_binder_id", ((WebViewUI)this.PXH.get()).gSo());
          localBundle.putByteArray("k_a8key_cookie", ((WebViewUI)this.PXH.get()).Qfz);
          localBundle.putString("geta8key_data_appid", getIntent().getStringExtra("geta8key_open_webview_appid"));
          break;
          localBundle.putInt("geta8key_data_flag", 0);
        }
        paramBundle.getString("geta8key_result_req_url");
        localObject3 = paramBundle.getString("geta8key_result_full_url");
        if (!Util.isNullOrNil((String)localObject3))
        {
          localObject4 = new JsapiPermissionWrapper(paramBundle.getByteArray("geta8key_result_jsapi_perm_control_bytes"));
          localObject5 = new GeneralControlWrapper(paramBundle.getInt("geta8key_result_general_ctrl_b1"));
          ((com.tencent.mm.plugin.webview.f.g)localObject2).a(((String)localObject3).replaceFirst("http://", "https//"), (JsapiPermissionWrapper)localObject4, (GeneralControlWrapper)localObject5);
          localObject2 = paramBundle.getStringArray("geta8key_result_http_header_key_list");
          localObject3 = paramBundle.getStringArray("geta8key_result_http_header_value_list");
          localObject4 = new HashMap();
          if ((localObject2 != null) && (localObject3 != null) && (localObject2.length > 0) && (localObject3.length > 0) && (localObject2.length == localObject3.length))
          {
            paramInt = 0;
            while (paramInt < localObject2.length)
            {
              ((Map)localObject4).put(localObject2[paramInt], localObject3[paramInt]);
              paramInt += 1;
            }
          }
          paramBundle = paramBundle.getString("geta8key_result_title");
          if ((paramBundle == null) || (paramBundle.length() <= 0)) {
            break;
          }
          ((WebViewUI)this.PXH.get()).setMMTitle(paramBundle);
          break;
        }
        Log.e("MicroMsg.WebViewStubCallbackAIDLStub", "updatePageAuth fail fullUrl is null");
        break;
        if (!(this.PXH.get() instanceof GameWebViewUI)) {
          break;
        }
        paramBundle = (GameWebViewUI)this.PXH.get();
        localBundle.putString("raw_url", paramBundle.cDu());
        localBundle.putString("page_key", paramBundle.haE());
        paramBundle = paramBundle.getWePkgPlugin();
        if (paramBundle == null) {
          break;
        }
        localBundle.putString("comm_js_version", f.hep());
        localBundle.putString("wepkg_version", paramBundle.heo());
        localBundle.putBoolean("is_used_wepkg", paramBundle.isAvailable());
        break;
        localBundle.putString("current_url", ((WebViewUI)this.PXH.get()).elY());
        localBundle.putString("raw_url", ((WebViewUI)this.PXH.get()).cDu());
        break;
        if (!(this.PXH.get() instanceof GameWebViewUI)) {
          break;
        }
        ((GameWebViewUI)this.PXH.get()).haC();
        break;
        if (!(this.PXH.get() instanceof GameWebViewUI)) {
          break;
        }
        ((GameWebViewUI)this.PXH.get()).haD();
        break;
        ((WebViewUI)this.PXH.get()).atk();
        break;
        if ((!(this.PXH.get() instanceof com.tencent.mm.plugin.webview.h.a.b)) || (paramBundle == null)) {
          break;
        }
        localObject2 = (com.tencent.mm.plugin.webview.h.a.b)this.PXH.get();
        localObject3 = paramBundle.getString("action");
        if ("writeComment".equals(localObject3))
        {
          ((com.tencent.mm.plugin.webview.h.a.b)localObject2).aQ(paramBundle);
          break;
        }
        if (!"closeComment".equals(localObject3)) {
          break;
        }
        ((com.tencent.mm.plugin.webview.h.a.b)localObject2).gWN();
        break;
        if (((this.PXH.get() instanceof com.tencent.mm.plugin.webview.h.a.b)) && (paramBundle != null))
        {
          localObject2 = (com.tencent.mm.plugin.webview.h.a.b)this.PXH.get();
          localObject3 = paramBundle.getString("action");
          paramInt = -1;
          switch (((String)localObject3).hashCode())
          {
          default: 
            label6176:
            switch (paramInt)
            {
            }
            break;
          }
        }
        while ((paramBundle != null) && ("share".equals(paramBundle.getString("action"))))
        {
          ((WebViewUI)this.PXH.get()).gYb();
          break;
          if (!((String)localObject3).equals("writeComment")) {
            break label6176;
          }
          paramInt = 0;
          break label6176;
          if (!((String)localObject3).equals("showToast")) {
            break label6176;
          }
          paramInt = 1;
          break label6176;
          if (!((String)localObject3).equals("readArticle")) {
            break label6176;
          }
          paramInt = 2;
          break label6176;
          if (!((String)localObject3).equals("writeCommentReply")) {
            break label6176;
          }
          paramInt = 3;
          break label6176;
          ((com.tencent.mm.plugin.webview.h.a.b)localObject2).aP(paramBundle);
          continue;
          ((com.tencent.mm.plugin.webview.h.a.b)localObject2).aR(paramBundle);
          continue;
          ((com.tencent.mm.plugin.webview.h.a.b)localObject2).aO(paramBundle);
          continue;
          ((com.tencent.mm.plugin.webview.h.a.b)localObject2).aS(paramBundle);
        }
        if ((((WebViewUI)this.PXH.get()).QeV != null) && (((WebViewUI)this.PXH.get()).QeV.isShowing())) {
          ((WebViewUI)this.PXH.get()).QeV.dismiss();
        }
        if (paramBundle == null)
        {
          Log.w("MicroMsg.WebViewStubCallbackAIDLStub", "show dialog, data is null");
          break;
        }
        paramBundle.getString("title", ((WebViewUI)this.PXH.get()).getString(c.i.app_tip));
        localObject2 = paramBundle.getString("message", ((WebViewUI)this.PXH.get()).getString(c.i.app_waiting));
        bool1 = paramBundle.getBoolean("cancelable", true);
        ((WebViewUI)this.PXH.get()).QeV = com.tencent.mm.ui.base.h.a((Context)this.PXH.get(), (String)localObject2, bool1, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(236802);
            Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "WebViewUITipsDialogCancel");
            try
            {
              paramBundle.putInt("WebViewShare_BinderID", ((WebViewUI)n.a(n.this).get()).PIQ.gSo());
              ((WebViewUI)n.a(n.this).get()).pGC.l(111, paramBundle);
              AppMethodBeat.o(236802);
              return;
            }
            catch (Exception paramAnonymousDialogInterface)
            {
              Log.e("MicroMsg.WebViewStubCallbackAIDLStub", "hide dialog err %s", new Object[] { paramAnonymousDialogInterface.getMessage() });
              AppMethodBeat.o(236802);
            }
          }
        });
        break;
        if ((((WebViewUI)this.PXH.get()).QeV == null) || (!((WebViewUI)this.PXH.get()).QeV.isShowing())) {
          break;
        }
        ((WebViewUI)this.PXH.get()).QeV.dismiss();
        break;
        Object localObject4 = (WebViewUI)this.PXH.get();
        if (localObject4 == null)
        {
          Log.e("MicroMsg.WebViewStubCallbackAIDLStub", "AC_ON_FAST_LOAD but null WebViewUI");
          break;
        }
        Object localObject5 = new c.a();
        Intent localIntent = new Intent();
        if (paramBundle.getInt("item_show_type") == 5)
        {
          localIntent.putExtras(paramBundle);
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1061L, 21L, 1L, false);
        }
        for (;;)
        {
          paramInt = paramBundle.getInt("scene");
          i = paramBundle.getInt(f.b.VRU, 10000);
          localObject3 = paramBundle.getString("url");
          localObject2 = localObject3;
          if (((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).isMpUrl((String)localObject3))
          {
            j = (int)(System.currentTimeMillis() / 1000L);
            localObject2 = ((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).e((String)localObject3, paramInt, i, j);
          }
          if (((WebViewUI)localObject4).getIntent() != null) {
            localIntent.putExtra(f.r.VSW, ((WebViewUI)localObject4).getIntent().getStringExtra(f.r.VSW));
          }
          localObject3 = (com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class);
          j = paramBundle.getInt("item_show_type");
          paramBundle.getBoolean("isNativePage");
          localBundle.putBoolean("success", ((com.tencent.mm.plugin.brandservice.a.c)localObject3).a((Context)localObject4, (String)localObject2, j, paramInt, i, localIntent, paramBundle.getInt("openType"), (c.a)localObject5));
          if ((((c.a)localObject5).success) || (((c.a)localObject5).message == null)) {
            break;
          }
          localBundle.putString("desc", ((c.a)localObject5).message);
          break;
          localIntent.putExtra("KPublisherId", paramBundle.getString("KPublisherId"));
        }
        paramBundle = (WebViewUI)this.PXH.get();
        if ((paramBundle == null) || (paramBundle.getIntent() == null))
        {
          com.tencent.mm.plugin.ac.a.o("WebViewStubCallback activity[%s]", new Object[] { paramBundle });
          paramBundle = Bundle.EMPTY;
          AppMethodBeat.o(80028);
          return paramBundle;
        }
        localObject2 = new Bundle(1);
        ((Bundle)localObject2).putString(f.r.VSW, paramBundle.getIntent().getStringExtra(f.r.VSW));
        com.tencent.mm.plugin.ac.a.o("WebViewStubCallback activity[%s] adUxInfo[%s]", new Object[] { paramBundle, ((Bundle)localObject2).getString(f.r.VSW) });
        AppMethodBeat.o(80028);
        return localObject2;
        paramBundle = new Bundle(1);
        paramBundle.putString("ad_info_traceId", m.Qer.getTraceId());
        AppMethodBeat.o(80028);
        return paramBundle;
        paramBundle = new Bundle(1);
        localObject2 = (WebViewUI)this.PXH.get();
        if ((localObject2 == null) || (((WebViewUI)localObject2).getIntent() == null))
        {
          Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "AC_GET_H5_PAY_COOKIE but null WebViewUI");
          break;
        }
        paramBundle.putString("key_h5pay_cookie", getIntent().getStringExtra("key_h5pay_cookie"));
        AppMethodBeat.o(80028);
        return paramBundle;
        paramBundle = (Activity)this.PXH.get();
        if (paramBundle != null) {
          localBundle.putParcelable("delegate", ActivityStarterIpcDelegate.aH(paramBundle));
        }
        AppMethodBeat.o(80028);
        return localBundle;
      }
    }
  }
  
  public final Bundle lY(String paramString1, String paramString2)
  {
    AppMethodBeat.i(80033);
    paramString1 = com.tencent.mm.protocal.c.hoD();
    AppMethodBeat.o(80033);
    return paramString1;
  }
  
  public final void lZ(final String paramString1, String paramString2)
  {
    AppMethodBeat.i(80025);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(79980);
        if ((n.a(n.this).get() == null) || (((WebViewUI)n.a(n.this).get()).isFinishing()))
        {
          AppMethodBeat.o(79980);
          return;
        }
        if (!Util.isNullOrNil(((WebViewUI)n.a(n.this).get()).pHS.getUrl()))
        {
          Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "setPageOwner, userName = " + paramString1);
          ((WebViewUI)n.a(n.this).get()).QfN.put(((WebViewUI)n.a(n.this).get()).pHS.getUrl(), paramString1);
          AppMethodBeat.o(79980);
          return;
        }
        Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "setPageOwner, null url");
        AppMethodBeat.o(79980);
      }
    });
    AppMethodBeat.o(80025);
  }
  
  public final void ma(final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(80032);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(80001);
        if ((n.a(n.this).get() == null) || (((WebViewUI)n.a(n.this).get()).isFinishing()))
        {
          AppMethodBeat.o(80001);
          return;
        }
        if (!Util.isNullOrNil(paramString1))
        {
          if (!Util.isNullOrNil(paramString2)) {
            n.b(n.this).putExtra("view_port_code", paramString2);
          }
          ((WebViewUI)n.a(n.this).get()).loadUrl(paramString1);
        }
        AppMethodBeat.o(80001);
      }
    });
    AppMethodBeat.o(80032);
  }
  
  public final void v(final int paramInt, final Bundle paramBundle)
  {
    AppMethodBeat.i(80024);
    if ((this.PXH.get() == null) || (((WebViewUI)this.PXH.get()).isFinishing()))
    {
      AppMethodBeat.o(80024);
      return;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(79979);
        if ((n.a(n.this).get() == null) || (((WebViewUI)n.a(n.this).get()).isFinishing()) || (((WebViewUI)n.a(n.this).get()).pHS == null))
        {
          AppMethodBeat.o(79979);
          return;
        }
        Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "setMenuItemsVisible, actionCode = " + paramInt);
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
          ((Set)localObject2).add("menuItem:share:wework_LOCAL");
          ((Set)localObject2).add("menuItem:share:weread");
          ((Set)localObject2).add("menuItem:addShortcut");
          ((Set)localObject2).add("menuItem:haoKan");
          ((Set)localObject2).add("menuItem:cancelHaoKan");
        }
        String str;
        Object localObject1;
        for (;;)
        {
          str = ((WebViewUI)n.a(n.this).get()).pHS.getUrl();
          localObject1 = (SparseBooleanArray)((WebViewUI)n.a(n.this).get()).Qgk.Qdt.get(str);
          switch (paramInt)
          {
          default: 
            AppMethodBeat.o(79979);
            return;
            if (paramBundle == null)
            {
              Log.w("MicroMsg.WebViewStubCallbackAIDLStub", "setMenuItemsVisible data is null.");
              AppMethodBeat.o(79979);
              return;
            }
            localObject1 = paramBundle.getStringArrayList("menu_item_list");
            if ((localObject1 == null) || (((List)localObject1).size() == 0))
            {
              Log.w("MicroMsg.WebViewStubCallbackAIDLStub", "setMenuItemsVisible menuItems is null or nil.");
              AppMethodBeat.o(79979);
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
          ((WebViewUI)n.a(n.this).get()).Qgk.Qdt.put(str, localObject1);
          ((WebViewUI)n.a(n.this).get()).Qgk.g(str, n.b(n.this));
        }
        for (;;)
        {
          localObject2 = ((Set)localObject2).iterator();
          int i;
          while (((Iterator)localObject2).hasNext())
          {
            i = Util.nullAs((Integer)((WebViewUI)n.a(n.this).get()).Qgk.Qdu.get(((Iterator)localObject2).next()), -1);
            if (i >= 0) {
              ((SparseBooleanArray)localObject1).put(i, true);
            }
          }
          ((WebViewUI)n.a(n.this).get()).Qgk.atk();
          AppMethodBeat.o(79979);
          return;
          if (localObject1 == null) {
            break;
          }
          localObject2 = ((Set)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            i = Util.nullAs((Integer)((WebViewUI)n.a(n.this).get()).Qgk.Qdu.get(((Iterator)localObject2).next()), -1);
            if (i >= 0) {
              ((SparseBooleanArray)localObject1).delete(i);
            }
          }
          ((WebViewUI)n.a(n.this).get()).Qgk.atk();
          break;
        }
      }
    });
    AppMethodBeat.o(80024);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.n
 * JD-Core Version:    0.7.0.1
 */