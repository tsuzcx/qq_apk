package com.tencent.mm.plugin.webview.ui.tools;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.util.Base64;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ImageView;
import com.tencent.luggage.sdk.launching.ActivityStarterIpcDelegate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.m;
import com.tencent.mm.autogen.a.m.b;
import com.tencent.mm.autogen.a.wu;
import com.tencent.mm.b.q;
import com.tencent.mm.k.e.b;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.brandservice.api.c.a;
import com.tencent.mm.plugin.handoff.model.HandOffURL;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.webview.c.c;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.e.g;
import com.tencent.mm.plugin.webview.jsapi.j.15;
import com.tencent.mm.plugin.webview.jsapi.j.21;
import com.tencent.mm.plugin.webview.jsapi.j.24;
import com.tencent.mm.plugin.webview.jsapi.j.6;
import com.tencent.mm.plugin.webview.jsapi.j.7;
import com.tencent.mm.plugin.webview.jsapi.j.73;
import com.tencent.mm.plugin.webview.jsapi.j.76;
import com.tencent.mm.plugin.webview.jsapi.j.77;
import com.tencent.mm.plugin.webview.jsapi.j.8;
import com.tencent.mm.plugin.webview.jsapi.j.9;
import com.tencent.mm.plugin.webview.jsapi.p.a;
import com.tencent.mm.plugin.webview.k.n;
import com.tencent.mm.plugin.webview.model.ar;
import com.tencent.mm.plugin.webview.model.ba;
import com.tencent.mm.plugin.webview.stub.f.a;
import com.tencent.mm.plugin.webview.ui.tools.floatball.b;
import com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.ddx;
import com.tencent.mm.protocal.protobuf.ghm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.SdcardUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MMFalseProgressBar;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.f.b;
import com.tencent.mm.ui.f.s;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import com.tencent.qqvideo.proxy.api.FactoryProxyManager;
import com.tencent.qqvideo.proxy.api.IPlayManager;
import com.tencent.threadpool.i;
import com.tencent.xweb.ao;
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

public final class s
  extends f.a
{
  private final WeakReference<WebViewUI> WOf;
  
  public s(WebViewUI paramWebViewUI)
  {
    AppMethodBeat.i(80008);
    this.WOf = new WeakReference(paramWebViewUI);
    AppMethodBeat.o(80008);
  }
  
  private void D(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(296124);
    if ((paramBundle != null) && (this.WOf.get() != null) && (((WebViewUI)this.WOf.get()).Wzl != null)) {
      ((WebViewUI)this.WOf.get()).Wzl.Wyk.a(new com.tencent.mm.plugin.webview.ui.tools.floatball.a(paramInt, paramBundle));
    }
    AppMethodBeat.o(296124);
  }
  
  private int avS(String paramString)
  {
    AppMethodBeat.i(80027);
    int i = ((WebViewUI)this.WOf.get()).avS(paramString);
    AppMethodBeat.o(80027);
    return i;
  }
  
  private Intent getIntent()
  {
    AppMethodBeat.i(80026);
    Intent localIntent = ((WebViewUI)this.WOf.get()).getIntent();
    AppMethodBeat.o(80026);
    return localIntent;
  }
  
  private float mn()
  {
    AppMethodBeat.i(80031);
    if (((WebViewUI)this.WOf.get()).sMP != null)
    {
      f = ((WebViewUI)this.WOf.get()).sMP.getMMDensity();
      AppMethodBeat.o(80031);
      return f;
    }
    float f = com.tencent.mm.ce.c.iRA();
    AppMethodBeat.o(80031);
    return f;
  }
  
  public final void Il(final boolean paramBoolean)
  {
    AppMethodBeat.i(80017);
    if ((this.WOf.get() == null) || (((WebViewUI)this.WOf.get()).isFinishing()))
    {
      AppMethodBeat.o(80017);
      return;
    }
    final boolean bool = ((WebViewUI)this.WOf.get()).getIntent().getBooleanExtra("forceHideShare", false);
    Log.d("MicroMsg.WebViewStubCallbackAIDLStub", "[cpan] setShareBtnVisible:%d visible:%b  forceHideShare:%b", new Object[] { Long.valueOf(System.currentTimeMillis()), Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(79974);
        if ((s.a(s.this).get() == null) || (((WebViewUI)s.a(s.this).get()).isFinishing()))
        {
          AppMethodBeat.o(79974);
          return;
        }
        if (bool)
        {
          if ((((WebViewUI)s.a(s.this).get()).sMP != null) && (!Util.isNullOrNil(((WebViewUI)s.a(s.this).get()).sMP.getUrl()))) {
            ((WebViewUI)s.a(s.this).get()).WXK.put(((WebViewUI)s.a(s.this).get()).sMP.getUrl(), Boolean.FALSE);
          }
          ((WebViewUI)s.a(s.this).get()).IN(false);
          AppMethodBeat.o(79974);
          return;
        }
        if ((((WebViewUI)s.a(s.this).get()).sMP != null) && (!Util.isNullOrNil(((WebViewUI)s.a(s.this).get()).sMP.getUrl()))) {
          ((WebViewUI)s.a(s.this).get()).WXK.put(((WebViewUI)s.a(s.this).get()).sMP.getUrl(), Boolean.valueOf(paramBoolean));
        }
        ((WebViewUI)s.a(s.this).get()).IN(paramBoolean);
        AppMethodBeat.o(79974);
      }
    });
    AppMethodBeat.o(80017);
  }
  
  public final void Im(final boolean paramBoolean)
  {
    AppMethodBeat.i(80018);
    if ((this.WOf.get() == null) || (((WebViewUI)this.WOf.get()).isFinishing()))
    {
      AppMethodBeat.o(80018);
      return;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(79975);
        if ((s.a(s.this).get() == null) || (((WebViewUI)s.a(s.this).get()).isFinishing()))
        {
          AppMethodBeat.o(79975);
          return;
        }
        ((WebViewUI)s.a(s.this).get()).IL(paramBoolean);
        AppMethodBeat.o(79975);
      }
    });
    AppMethodBeat.o(80018);
  }
  
  public final void In(boolean paramBoolean)
  {
    AppMethodBeat.i(80030);
    if ((this.WOf.get() == null) || (((WebViewUI)this.WOf.get()).isFinishing()))
    {
      AppMethodBeat.o(80030);
      return;
    }
    ((WebViewUI)this.WOf.get()).IR(paramBoolean);
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
    if ((this.WOf.get() == null) || (((WebViewUI)this.WOf.get()).isFinishing()))
    {
      AppMethodBeat.o(80012);
      return false;
    }
    if (((WebViewUI)this.WOf.get()).WlX != null)
    {
      paramString1 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(79973);
          if ((s.a(s.this).get() == null) || (((WebViewUI)s.a(s.this).get()).isFinishing()))
          {
            AppMethodBeat.o(79973);
            return;
          }
          ((WebViewUI)s.a(s.this).get()).WlX.a(paramString1, paramString2, com.tencent.mm.plugin.webview.jsapi.p.bm(paramBundle), paramBoolean);
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
  
  public final void aF(Bundle paramBundle)
  {
    AppMethodBeat.i(80020);
    if ((this.WOf.get() == null) || (((WebViewUI)this.WOf.get()).isFinishing()))
    {
      AppMethodBeat.o(80020);
      return;
    }
    Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "IUIController, closeWindow");
    if (paramBundle != null)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("result_data", paramBundle);
      ((WebViewUI)this.WOf.get()).setResult(-1, localIntent);
    }
    com.tencent.threadpool.h.ahAA.bk(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(79976);
        ((WebViewUI)s.a(s.this).get()).finish();
        AppMethodBeat.o(79976);
      }
    });
    AppMethodBeat.o(80020);
  }
  
  public final boolean asR(final int paramInt)
  {
    AppMethodBeat.i(80011);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(79972);
        if ((s.a(s.this).get() == null) || (((WebViewUI)s.a(s.this).get()).isFinishing()))
        {
          AppMethodBeat.o(79972);
          return;
        }
        ((WebViewUI)s.a(s.this).get()).setProgressBarIndeterminateVisibility(false);
        Log.d("MicroMsg.WebViewStubCallbackAIDLStub", "[cpan] set title pb visibility:%d", new Object[] { Integer.valueOf(paramInt) });
        if (paramInt == 0)
        {
          if ((!((WebViewUI)s.a(s.this).get()).WXU) && (!((WebViewUI)s.a(s.this).get()).WXV) && (!((WebViewUI)s.a(s.this).get()).dhy()))
          {
            ((WebViewUI)s.a(s.this).get()).WWR.start();
            AppMethodBeat.o(79972);
          }
        }
        else {
          ((WebViewUI)s.a(s.this).get()).WWR.finish();
        }
        AppMethodBeat.o(79972);
      }
    });
    AppMethodBeat.o(80011);
    return true;
  }
  
  public final void bif(String paramString)
  {
    final int i = 0;
    AppMethodBeat.i(80021);
    if ((this.WOf.get() == null) || (((WebViewUI)this.WOf.get()).isFinishing()))
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
          AppMethodBeat.i(79978);
          if ((s.a(s.this).get() == null) || (((WebViewUI)s.a(s.this).get()).isFinishing()))
          {
            AppMethodBeat.o(79978);
            return;
          }
          ((WebViewUI)s.a(s.this).get()).atq(i);
          AppMethodBeat.o(79978);
        }
      });
      AppMethodBeat.o(80021);
    }
    if (((WebViewUI)this.WOf.get()).sMP == null)
    {
      Log.e("MicroMsg.WebViewStubCallbackAIDLStub", "setFontSizeCb fail, viewWV is null");
      AppMethodBeat.o(80021);
      return;
    }
  }
  
  public final void bk(Bundle paramBundle)
  {
    AppMethodBeat.i(80029);
    if ((this.WOf.get() == null) || (((WebViewUI)this.WOf.get()).isFinishing()))
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
      localObject = ((WebViewUI)this.WOf.get()).sMP.getUrl();
      if (((WebViewUI)this.WOf.get()).WXM.containsKey(localObject)) {
        ((WebViewUI)this.WOf.get()).WXM.remove(localObject);
      }
      ((WebViewUI)this.WOf.get()).WXM.put(localObject, paramBundle);
    }
    AppMethodBeat.o(80029);
  }
  
  public final String cxY()
  {
    AppMethodBeat.i(296162);
    if ((this.WOf.get() == null) || (((WebViewUI)this.WOf.get()).isFinishing()))
    {
      AppMethodBeat.o(296162);
      return null;
    }
    String str = ((WebViewUI)this.WOf.get()).Wzl.Wwz;
    AppMethodBeat.o(296162);
    return str;
  }
  
  public final void f(String paramString1, final String paramString2, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(80023);
    if ((this.WOf.get() == null) || (((WebViewUI)this.WOf.get()).isFinishing()))
    {
      AppMethodBeat.o(80023);
      return;
    }
    Log.d("MicroMsg.WebViewStubCallbackAIDLStub", "result: ".concat(String.valueOf(paramString2)));
    if ((((WebViewUI)this.WOf.get()).WYh.sLJ == null) || (paramString1 == null) || (!paramString1.equals(((WebViewUI)this.WOf.get()).WYh.sLJ.XsV)))
    {
      AppMethodBeat.o(80023);
      return;
    }
    if (((WebViewUI)this.WOf.get()).WYh.sLJ != null) {
      ((WebViewUI)this.WOf.get()).WYh.sLJ.iCR();
    }
    if ((paramString2 == null) || (((WebViewUI)this.WOf.get()).WYh == null))
    {
      AppMethodBeat.o(80023);
      return;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(79979);
        if ((s.a(s.this).get() == null) || (((WebViewUI)s.a(s.this).get()).isFinishing()) || (((WebViewUI)s.a(s.this).get()).sMP == null))
        {
          AppMethodBeat.o(79979);
          return;
        }
        WebViewLongClickHelper localWebViewLongClickHelper = ((WebViewUI)s.a(s.this).get()).WYh;
        Log.i("MicroMsg.WebViewLongClickHelper", "onGetQRCodeResult");
        localWebViewLongClickHelper.iuK();
        localWebViewLongClickHelper.ixH();
        AppMethodBeat.o(79979);
      }
    });
    AppMethodBeat.o(80023);
  }
  
  public final String getCurrentUrl()
  {
    AppMethodBeat.i(80014);
    if ((this.WOf.get() == null) || (((WebViewUI)this.WOf.get()).isFinishing()))
    {
      AppMethodBeat.o(80014);
      return null;
    }
    String str = ((WebViewUI)this.WOf.get()).fqa();
    AppMethodBeat.o(80014);
    return str;
  }
  
  public final boolean i(int paramInt, final Bundle paramBundle)
  {
    AppMethodBeat.i(80009);
    Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "callback, actionCode = ".concat(String.valueOf(paramInt)));
    Object localObject1 = (WebViewUI)this.WOf.get();
    if ((localObject1 == null) || (((WebViewUI)localObject1).isFinishing()))
    {
      AppMethodBeat.o(80009);
      return false;
    }
    final com.tencent.mm.plugin.webview.jsapi.j localj = ((WebViewUI)localObject1).WlX;
    Object localObject2 = ((WebViewUI)localObject1).sLD;
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
            if ((this.WWs == null) || (this.WWs.isFinishing()))
            {
              AppMethodBeat.o(79944);
              return;
            }
            if ((localj != null) && (this.QNT != null) && (this.QNT.iwo().sk(42))) {
              localj.j(paramBundle, "download_succ");
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
            if ((this.WWs == null) || (this.WWs.isFinishing()))
            {
              AppMethodBeat.o(79955);
              return;
            }
            if ((localj != null) && (this.QNT != null) && (this.QNT.iwo().sk(42))) {
              localj.j(paramBundle, "download_fail");
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
            if ((this.WWs == null) || (this.WWs.isFinishing()))
            {
              AppMethodBeat.o(79966);
              return;
            }
            if ((localj != null) && (this.QNT != null) && (this.QNT.iwo().sk(42))) {
              localj.j(paramBundle, "download_removed");
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
            if ((this.WWs == null) || (this.WWs.isFinishing()))
            {
              AppMethodBeat.o(79977);
              return;
            }
            if ((localj != null) && (this.QNT != null) && (this.QNT.iwo().sk(42))) {
              localj.j(paramBundle, "download_pause");
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
            if ((this.WWs == null) || (this.WWs.isFinishing()))
            {
              AppMethodBeat.o(79988);
              return;
            }
            if ((localj != null) && (this.QNT != null) && (this.QNT.iwo().sk(42))) {
              localj.j(paramBundle, "download_resumed");
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
            if ((this.WWs == null) || (this.WWs.isFinishing()))
            {
              AppMethodBeat.o(80003);
              return;
            }
            if ((localj != null) && (this.QNT != null) && (this.QNT.iwo().sk(42))) {
              localj.j(paramBundle, "download_start");
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
            if ((this.WWs == null) || (this.WWs.isFinishing()))
            {
              AppMethodBeat.o(80005);
              return;
            }
            if ((localj != null) && (this.QNT != null) && (this.QNT.iwo().sk(42))) {
              localj.a(this.etl, l, f, this.sNl);
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
            if ((this.WWs == null) || (this.WWs.isFinishing()))
            {
              AppMethodBeat.o(80006);
              return;
            }
            if ((localj != null) && (this.QNT != null))
            {
              this.QNT.iwo();
              if (JsapiPermissionWrapper.iPV())
              {
                localj.hR(this.rKU, this.cl);
                AppMethodBeat.o(80006);
                return;
              }
            }
            if ((localj != null) && (this.WWJ.booleanValue()))
            {
              localj.hR(this.rKU, this.cl);
              AppMethodBeat.o(80006);
              return;
            }
            if (localj == null) {}
            for (boolean bool1 = true;; bool1 = false)
            {
              if (this.QNT == null) {
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
            if ((this.WWs == null) || (this.WWs.isFinishing()))
            {
              AppMethodBeat.o(80007);
              return;
            }
            if (localj != null)
            {
              com.tencent.mm.plugin.webview.jsapi.j localj = localj;
              String str = this.WWK;
              int i = this.sNn;
              if (!localj.UcS)
              {
                Log.e("MicroMsg.JsApiHandler", "onMediaFileUploadProgress fail, not ready");
                AppMethodBeat.o(80007);
                return;
              }
              Log.i("MicroMsg.JsApiHandler", "onMediaFileUploadProgress, local id : %s, percent : %d", new Object[] { str, Integer.valueOf(i) });
              HashMap localHashMap = new HashMap();
              localHashMap.put("localId", str);
              localHashMap.put("percent", Integer.valueOf(i));
              MMHandlerThread.postToMainThread(new j.15(localj, p.a.b("onMediaFileUploadProgress", localHashMap, localj.WDI, localj.KQY)));
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
            if ((this.WWs == null) || (this.WWs.isFinishing()))
            {
              AppMethodBeat.o(79945);
              return;
            }
            if (localj != null) {
              localj.hS(this.sNm, this.sNn);
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
            if ((this.WWs == null) || (this.WWs.isFinishing()))
            {
              AppMethodBeat.o(79946);
              return;
            }
            if (localj != null)
            {
              com.tencent.mm.plugin.webview.jsapi.j localj = localj;
              String str1 = this.IxC;
              int i = this.srg;
              String str2 = this.WWu;
              int j = this.val$errCode;
              String str3 = this.val$errMsg;
              String str4 = this.WWv;
              String str5 = this.LJv;
              if (!localj.UcS)
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
              MMHandlerThread.postToMainThread(new j.21(localj, p.a.b("onBackgroundAudioStateChange", localHashMap, localj.WDI, localj.KQY)));
            }
            AppMethodBeat.o(79946);
          }
        });
        continue;
        if (paramBundle != null)
        {
          paramBundle.putString("application_language", ((WebViewUI)localObject1).sLC.getLanguage());
          ((WebViewUI)localObject1).WXO = WebViewUI.a.bC(paramBundle);
          continue;
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(79947);
              if ((this.WWs == null) || (this.WWs.isFinishing()))
              {
                AppMethodBeat.o(79947);
                return;
              }
              if (localj != null) {
                localj.hT(this.sNo, this.eEd);
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
              if ((this.WWs == null) || (this.WWs.isFinishing()))
              {
                AppMethodBeat.o(79948);
                return;
              }
              if (localj != null) {
                localj.hU(this.sNp, this.eEd);
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
              if ((this.WWs == null) || (this.WWs.isFinishing()))
              {
                AppMethodBeat.o(79949);
                return;
              }
              if (localj != null) {
                localj.hV(this.sNo, this.eEd);
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
              if ((this.WWs == null) || (this.WWs.isFinishing()))
              {
                AppMethodBeat.o(79950);
                return;
              }
              if (localj != null) {
                localj.hW(this.sNp, this.eEd);
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
              if ((this.WWs == null) || (this.WWs.isFinishing()))
              {
                AppMethodBeat.o(79951);
                return;
              }
              if (localj != null) {
                localj.cg(this.sNf);
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
              if ((this.WWs == null) || (this.WWs.isFinishing()))
              {
                AppMethodBeat.o(79952);
                return;
              }
              if (localj != null)
              {
                com.tencent.mm.plugin.webview.jsapi.j localj = localj;
                int i = this.val$errCode;
                if (!localj.UcS)
                {
                  Log.e("MicroMsg.JsApiHandler", "onNfcTouch fail, not ready");
                  AppMethodBeat.o(79952);
                  return;
                }
                Log.i("MicroMsg.JsApiHandler", "onNfcTouch errCode=%d", new Object[] { Integer.valueOf(i) });
                HashMap localHashMap = new HashMap();
                localHashMap.put("errCode", Integer.valueOf(i));
                MMHandlerThread.postToMainThread(new j.24(localj, p.a.b("onNfcTouch", localHashMap, localj.WDI, localj.KQY)));
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
              if ((this.WWs == null) || (this.WWs.isFinishing()))
              {
                AppMethodBeat.o(79953);
                return;
              }
              this.WWs.setMMSubTitle(c.i.webview_recording);
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
              if ((this.WWs == null) || (this.WWs.isFinishing()))
              {
                AppMethodBeat.o(79954);
                return;
              }
              this.WWs.setMMSubTitle(null);
              if (localj != null) {
                localj.ch(this.sNf);
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
              if ((this.WWs == null) || (this.WWs.isFinishing()))
              {
                AppMethodBeat.o(79956);
                return;
              }
              this.WWs.setMMSubTitle(null);
              AppMethodBeat.o(79956);
            }
          });
          continue;
          if (localj != null)
          {
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                boolean bool = true;
                AppMethodBeat.i(79957);
                if ((this.WWs == null) || (this.WWs.isFinishing()))
                {
                  AppMethodBeat.o(79957);
                  return;
                }
                if ((!paramBundle.containsKey("jsapi_preverify_fun_list")) || (this.QNT == null)) {
                  if (this.QNT != null) {
                    Log.e("MicroMsg.WebViewStubCallbackAIDLStub", "has JSAPI_CONTROL_BYTES wvPerm %b", new Object[] { Boolean.valueOf(bool) });
                  }
                }
                for (;;)
                {
                  if (localj != null) {
                    localj.itz();
                  }
                  AppMethodBeat.o(79957);
                  return;
                  bool = false;
                  break;
                  this.QNT.br(paramBundle);
                }
              }
            });
            continue;
            if (localj != null)
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
                    localObject6 = new ddx();
                    ((ddx)localObject6).parseFrom(paramBundle.getByteArray((String)localObject5));
                    ((LinkedList)localObject1).add(localObject6);
                  }
                }
              }
              catch (IOException paramBundle)
              {
                Log.printErrStackTrace("MicroMsg.WebViewStubCallbackAIDLStub", paramBundle, "parse webCompt", new Object[0]);
              }
              if (localj.itJ() != null)
              {
                localj.itJ().c((String)localObject2, (String)localObject3, (LinkedList)localObject1);
                continue;
                localObject3 = paramBundle.getString("exdevice_device_id");
                final boolean bool = paramBundle.getBoolean("exdevice_is_complete");
                MMHandlerThread.postToMainThread(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(79958);
                    if ((this.WWs == null) || (this.WWs.isFinishing()))
                    {
                      AppMethodBeat.o(79958);
                      return;
                    }
                    com.tencent.mm.plugin.webview.jsapi.j localj;
                    byte[] arrayOfByte;
                    boolean bool2;
                    Object localObject;
                    if (localj != null)
                    {
                      localj = localj;
                      String str = this.rKU;
                      arrayOfByte = this.WWw;
                      boolean bool1 = bool;
                      bool2 = this.WWy;
                      if (!localj.UcS)
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
                        com.tencent.mm.plugin.webview.jsapi.exdevice.a.itT();
                        if ((com.tencent.mm.plugin.webview.jsapi.exdevice.a.cT(arrayOfByte)) || ((arrayOfByte != null) && (bool2))) {
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
                            localj.WDz.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + (String)localObject + ")", null);
                            if (!bool2) {
                              com.tencent.mm.plugin.webview.jsapi.exdevice.a.itT().WEX = arrayOfByte;
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
                      localObject = p.a.a("onScanWXDeviceResult", (JSONObject)localObject, localj.WDI, localj.KQY);
                    }
                    label337:
                    Log.e("MicroMsg.WebViewStubCallbackAIDLStub", "hakon can not call onScanWXDeviceResult, %s, %s", new Object[] { localj, this.QNT });
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
                    if ((this.WWs == null) || (this.WWs.isFinishing()))
                    {
                      AppMethodBeat.o(79959);
                      return;
                    }
                    if (localj != null)
                    {
                      com.tencent.mm.plugin.webview.jsapi.j localj = localj;
                      String str = this.rKU;
                      byte[] arrayOfByte = this.WWz;
                      Object localObject = this.ypP;
                      if (!localj.UcS)
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
                      MMHandlerThread.postToMainThread(new j.6(localj, p.a.b("onReceiveDataFromWXDevice", (Map)localObject, localj.WDI, localj.KQY)));
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
                    if ((this.WWs == null) || (this.WWs.isFinishing()))
                    {
                      AppMethodBeat.o(79960);
                      return;
                    }
                    com.tencent.mm.plugin.webview.jsapi.j localj;
                    HashMap localHashMap;
                    if (localj != null)
                    {
                      localj = localj;
                      String str = this.rKU;
                      boolean bool = this.WWA;
                      if (!localj.UcS)
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
                      MMHandlerThread.postToMainThread(new j.7(localj, p.a.b("onWXDeviceBindStateChange", localHashMap, localj.WDI, localj.KQY)));
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
                    if ((this.WWs == null) || (this.WWs.isFinishing()))
                    {
                      AppMethodBeat.o(79961);
                      return;
                    }
                    com.tencent.mm.plugin.webview.jsapi.j localj;
                    HashMap localHashMap;
                    if (localj != null)
                    {
                      localj = localj;
                      boolean bool = this.WWB;
                      if (!localj.UcS)
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
                      MMHandlerThread.postToMainThread(new j.8(localj, p.a.b("onWXDeviceBluetoothStateChange", localHashMap, localj.WDI, localj.KQY)));
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
                    if ((this.WWs == null) || (this.WWs.isFinishing()))
                    {
                      AppMethodBeat.o(79962);
                      return;
                    }
                    com.tencent.mm.plugin.webview.jsapi.j localj;
                    HashMap localHashMap;
                    if (localj != null)
                    {
                      localj = localj;
                      boolean bool = this.WWB;
                      if (!localj.UcS)
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
                      MMHandlerThread.postToMainThread(new j.9(localj, p.a.b("onWXDeviceLanStateChange", localHashMap, localj.WDI, localj.KQY)));
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
                    if ((this.WWs == null) || (this.WWs.isFinishing()))
                    {
                      AppMethodBeat.o(79963);
                      return;
                    }
                    if (localj != null) {
                      localj.bjL(this.val$message);
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
                    if ((this.WWs == null) || (this.WWs.isFinishing()))
                    {
                      AppMethodBeat.o(79964);
                      return;
                    }
                    if (localj != null) {
                      localj.a(this.qCD, this.sNg, this.sNh, this.oEK, this.sNi, this.sNj);
                    }
                    AppMethodBeat.o(79964);
                  }
                });
                continue;
                if ((localObject1 != null) && (!((WebViewUI)localObject1).isFinishing()))
                {
                  ((WebViewUI)localObject1).q(paramInt, paramBundle);
                  continue;
                  ((WebViewUI)localObject1).E(paramInt, paramBundle);
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
                    label2174:
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
                        break label2174;
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
                      if ((this.WWs == null) || (this.WWs.isFinishing()))
                      {
                        AppMethodBeat.o(79965);
                        return;
                      }
                      if (localj != null)
                      {
                        com.tencent.mm.plugin.webview.jsapi.j localj = localj;
                        JSONArray localJSONArray = this.WWC;
                        if (!localj.UcS)
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
                        MMHandlerThread.postToMainThread(new j.73(localj, p.a.b("onGetMsgProofItems", localHashMap, localj.WDI, localj.KQY)));
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
                      if ((this.WWs == null) || (this.WWs.isFinishing()))
                      {
                        AppMethodBeat.o(79967);
                        return;
                      }
                      if (localj != null) {
                        localj.bjO(this.val$netType);
                      }
                      AppMethodBeat.o(79967);
                    }
                  });
                  continue;
                  if ((this.WOf.get() != null) && (((WebViewUI)this.WOf.get()).Wzl != null))
                  {
                    ((WebViewUI)this.WOf.get()).Wzl.isc();
                    continue;
                    paramBundle = new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(79968);
                        if ((this.WWs == null) || (this.WWs.isFinishing()))
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
                            if (this.WWs.WYo != null) {
                              this.WWs.WYo.setIcon(Util.nullAsNil((String)localObject1));
                            }
                            if (this.WWs.WYr != null) {
                              this.WWs.WYr.ahT((String)localObject1);
                            }
                            this.WWs.WYq.ahT((String)localObject1);
                          }
                          str1 = paramBundle.getString("key_brand_name");
                          localObject2 = paramBundle.getString("key_brand_user_name");
                          localObject1 = paramBundle.getString("key_title");
                          if (!Util.isNullOrNil((String)localObject2)) {
                            this.WWs.getIntent().putExtra("srcUsername", (String)localObject2);
                          }
                          Log.i("FloatBall", "currentMpInfo, brandName:%s, title:%s", new Object[] { str1, localObject1 });
                          if (this.WWs.Wyi != null)
                          {
                            localObject2 = this.WWs.Wyi;
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
                          if (this.WWs.WYh != null)
                          {
                            localObject2 = this.WWs.WYh;
                            localBundle1 = paramBundle;
                            if (localBundle1 != null)
                            {
                              bool = localBundle1.getBoolean("key_forbidForward");
                              WebViewLongClickHelper.GYh.put(WebViewLongClickHelper.aiC(((WebViewLongClickHelper)localObject2).sML), Boolean.valueOf(bool));
                            }
                          }
                          if ((!Util.isNullOrNil((String)localObject1)) || (this.WWs.getMMTitle() == null)) {
                            break label736;
                          }
                          localObject1 = this.WWs.getMMTitle().toString();
                        }
                        label448:
                        label605:
                        label736:
                        for (;;)
                        {
                          if (!Util.isNullOrNil((String)localObject1))
                          {
                            if (this.WWs.WYr != null) {
                              this.WWs.WYr.updateTitle((String)localObject1);
                            }
                            this.WWs.WYq.ahU((String)localObject1);
                            if (this.WWs.WYo != null) {
                              this.WWs.WYo.setTitle((String)localObject1);
                            }
                            if ((!Util.isNullOrNil(str1)) && (this.WWs.WYr != null)) {
                              this.WWs.WYr.aNR(str1);
                            }
                            if (this.WWs.WYo != null) {
                              ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.handoff.a.a.class)).e(this.WWs.WYo);
                            }
                            AppMethodBeat.o(79968);
                            return;
                            Log.d("MicroMsg.WebViewUIStyleHelper", "updateCurrentInfo url %s", new Object[] { str2 });
                            String str3 = WebViewUIStyleHelper.aiC(str2);
                            Bundle localBundle2 = (Bundle)WebViewUIStyleHelper.GYh.get(str3);
                            if (localBundle2 == null)
                            {
                              WebViewUIStyleHelper.GYh.put(str3, localBundle1);
                              if ((!WebViewUIStyleHelper.bF(localBundle1)) || (!WebViewUIStyleHelper.fEm()) || (!((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).aiy(str2))) {
                                break label605;
                              }
                              if (WebViewUIStyleHelper.bE(localBundle1)) {
                                ((WebViewUIStyleHelper)localObject2).izy();
                              }
                              ((WebViewUIStyleHelper)localObject2).aiO(localBundle1.getString("key_brand_user_name"));
                              break;
                            }
                            if (localBundle2.getBoolean("key_current_info_show")) {}
                            for (bool = true;; bool = false)
                            {
                              localBundle1.putBoolean("key_current_info_show", bool);
                              WebViewUIStyleHelper.GYh.put(str3, localBundle1);
                              break;
                            }
                            ((WebViewUIStyleHelper)localObject2).izw();
                            break;
                          }
                          localObject1 = this.WWs.WYq;
                          if (((b)localObject1).vjV != null) {}
                          for (localObject1 = ((b)localObject1).vjV.name;; localObject1 = null)
                          {
                            if (Util.isNullOrNil((String)localObject1)) {
                              this.WWs.WYq.ahU(str1);
                            }
                            if (Util.isNullOrNil(this.WWs.WYr.WHP.title)) {
                              this.WWs.WYr.updateTitle(str1);
                            }
                            if ((this.WWs.WYo == null) || (!Util.isNullOrNil(this.WWs.WYo.getTitle())) || (Util.isNullOrNil(str1))) {
                              break;
                            }
                            this.WWs.WYo.setTitle(str1);
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
                      com.tencent.threadpool.h.ahAA.bm(paramBundle);
                      continue;
                      paramBundle = paramBundle.getString("service_click_tid");
                      Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "on service click, update tid = %s", new Object[] { paramBundle });
                      ((WebViewUI)localObject1).WYm = paramBundle;
                      ((WebViewUI)localObject1).WYn = System.currentTimeMillis();
                      MMHandlerThread.postToMainThread(new Runnable()
                      {
                        public final void run()
                        {
                          AppMethodBeat.i(79969);
                          if ((this.WWs == null) || (this.WWs.isFinishing()))
                          {
                            AppMethodBeat.o(79969);
                            return;
                          }
                          if (this.WWs.sMP != null)
                          {
                            com.tencent.mm.plugin.normsg.a.d.MtP.a(this.WWs.sMP, wu.class);
                            if (this.WWs.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).getBoolean("forceTrigger", false))
                            {
                              Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "on service click, test");
                              new wu().publish();
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
                          if ((this.WWs == null) || (this.WWs.isFinishing()))
                          {
                            AppMethodBeat.o(79970);
                            return;
                          }
                          if (localj != null)
                          {
                            com.tencent.mm.plugin.webview.jsapi.j localj = localj;
                            String str = this.WWD;
                            int i = this.WWE;
                            if (!localj.UcS)
                            {
                              Log.e("MicroMsg.JsApiHandler", "not ready");
                              AppMethodBeat.o(79970);
                              return;
                            }
                            HashMap localHashMap = new HashMap();
                            localHashMap.put("postId", str);
                            localHashMap.put("result", Integer.valueOf(i));
                            MMHandlerThread.postToMainThread(new j.76(localj, p.a.b("onPublishHaowanEnd", localHashMap, localj.WDI, localj.KQY)));
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
                          if ((this.WWs == null) || (this.WWs.isFinishing()))
                          {
                            AppMethodBeat.o(79971);
                            return;
                          }
                          if (localj != null)
                          {
                            com.tencent.mm.plugin.webview.jsapi.j localj = localj;
                            String str = this.WWD;
                            float f = this.tKF;
                            if (!localj.UcS)
                            {
                              Log.e("MicroMsg.JsApiHandler", "not ready");
                              AppMethodBeat.o(79971);
                              return;
                            }
                            HashMap localHashMap = new HashMap();
                            localHashMap.put("postId", str);
                            localHashMap.put("percent", Float.valueOf(f));
                            MMHandlerThread.postToMainThread(new j.77(localj, p.a.b("onPublishHaowanProgress", localHashMap, localj.WDI, localj.KQY)));
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
  }
  
  public final void ioZ()
  {
    AppMethodBeat.i(80019);
    if ((this.WOf.get() == null) || (((WebViewUI)this.WOf.get()).isFinishing()))
    {
      AppMethodBeat.o(80019);
      return;
    }
    if (((WebViewUI)this.WOf.get()).WlX != null) {
      ((WebViewUI)this.WOf.get()).WlX.ioZ();
    }
    AppMethodBeat.o(80019);
  }
  
  public final String ipa()
  {
    AppMethodBeat.i(80013);
    if ((this.WOf.get() == null) || (((WebViewUI)this.WOf.get()).isFinishing()))
    {
      AppMethodBeat.o(80013);
      return null;
    }
    String str = ((WebViewUI)this.WOf.get()).dgY();
    AppMethodBeat.o(80013);
    return str;
  }
  
  public final String ipb()
  {
    AppMethodBeat.i(80015);
    if ((this.WOf.get() == null) || (((WebViewUI)this.WOf.get()).isFinishing()))
    {
      AppMethodBeat.o(80015);
      return null;
    }
    String str = ((WebViewUI)this.WOf.get()).getIntent().getStringExtra("srcUsername");
    AppMethodBeat.o(80015);
    return str;
  }
  
  public final int ipc()
  {
    AppMethodBeat.i(80016);
    if ((this.WOf.get() == null) || (((WebViewUI)this.WOf.get()).isFinishing()))
    {
      AppMethodBeat.o(80016);
      return 0;
    }
    int i = ((WebViewUI)this.WOf.get()).Wzl.cxN();
    AppMethodBeat.o(80016);
    return i;
  }
  
  public final void ipd()
  {
    AppMethodBeat.i(80022);
    if ((this.WOf.get() == null) || (((WebViewUI)this.WOf.get()).isFinishing()))
    {
      AppMethodBeat.o(80022);
      return;
    }
    if (((WebViewUI)this.WOf.get()).WlX != null) {
      ((WebViewUI)this.WOf.get()).WlX.ipd();
    }
    AppMethodBeat.o(80022);
  }
  
  public final Bundle m(int paramInt, final Bundle paramBundle)
  {
    AppMethodBeat.i(80028);
    Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "invokeAsResult, actionCode = ".concat(String.valueOf(paramInt)));
    final Bundle localBundle = new Bundle();
    if ((this.WOf.get() == null) || (((WebViewUI)this.WOf.get()).isFinishing()))
    {
      AppMethodBeat.o(80028);
      return localBundle;
    }
    Object localObject1 = ((WebViewUI)this.WOf.get()).sLD;
    switch (paramInt)
    {
    default: 
      Log.e("MicroMsg.WebViewStubCallbackAIDLStub", "undefine action code!!!");
    }
    for (;;)
    {
      AppMethodBeat.o(80028);
      return localBundle;
      ((WebViewUI)this.WOf.get()).WYe = true;
      continue;
      localObject1 = new m();
      ((m)localObject1).hyZ.context = ((WebViewUI)this.WOf.get()).getContext();
      ((m)localObject1).hyZ.actionCode = paramInt;
      if (4003 == paramInt)
      {
        paramBundle = paramBundle.getString("apdu");
        ((m)localObject1).hyZ.hzb = paramBundle;
      }
      boolean bool2;
      for (;;)
      {
        ((m)localObject1).callback = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(79982);
            localBundle.putAll(this.WWH.hza.hze);
            AppMethodBeat.o(79982);
          }
        };
        ((m)localObject1).publish();
        break;
        if (4004 == paramInt)
        {
          localObject4 = paramBundle.getString("apdus");
          bool1 = paramBundle.getBoolean("breakIfFail", true);
          bool2 = paramBundle.getBoolean("breakIfTrue", false);
          ((m)localObject1).hyZ.hzb = ((String)localObject4);
          ((m)localObject1).hyZ.hzc = bool1;
          ((m)localObject1).hyZ.hzd = bool2;
        }
      }
      localBundle.putString("KPublisherId", ((WebViewUI)this.WOf.get()).iag);
      paramBundle = getIntent();
      if (paramBundle == null) {
        continue;
      }
      paramInt = avS(getIntent().getStringExtra("geta8key_username"));
      localBundle.putString("preChatName", paramBundle.getStringExtra("preChatName"));
      localBundle.putInt("preMsgIndex", paramBundle.getIntExtra("preMsgIndex", 0));
      localBundle.putString("prePublishId", paramBundle.getStringExtra("prePublishId"));
      localBundle.putString("preUsername", paramBundle.getStringExtra("preUsername"));
      localBundle.putInt("getA8KeyScene", paramInt);
      localBundle.putString("referUrl", ((WebViewUI)this.WOf.get()).iyB());
      localBundle.putString("url", ((WebViewUI)this.WOf.get()).fqa());
      localBundle.putString("rawUrl", ((WebViewUI)this.WOf.get()).dgY());
      localBundle.putInt("preChatTYPE", getIntent().getIntExtra("preChatTYPE", 0));
      localBundle.putString("KAppId", paramBundle.getStringExtra("KAppId"));
      ((WebViewUI)this.WOf.get()).bB(localBundle);
      continue;
      localBundle.putString("KSessionId", ((WebViewUI)this.WOf.get()).sessionId);
      localBundle.putString("KUserAgent", ((WebViewUI)this.WOf.get()).getUserAgent());
      localBundle.putString("KUrl", ((WebViewUI)this.WOf.get()).fqa());
      paramInt = avS(getIntent().getStringExtra("geta8key_username"));
      if ((paramInt != 7) && (paramInt != 56)) {
        continue;
      }
      localBundle.putString("geta8key_username", getIntent().getStringExtra("geta8key_username"));
      continue;
      paramBundle = getIntent();
      if (paramBundle == null) {
        continue;
      }
      localBundle.putString("publishIdPrefix", paramBundle.getStringExtra("publishIdPrefix"));
      localBundle.putString("reportSessionId", paramBundle.getStringExtra("reportSessionId"));
      continue;
      localBundle.putInt("pay_channel", getIntent().getIntExtra("pay_channel", -1));
      Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "key value: pay channel(%d)", new Object[] { Integer.valueOf(getIntent().getIntExtra("pay_channel", -1)) });
      continue;
      localBundle.putInt("pay_chat_type", getIntent().getIntExtra("pay_chat_type", 0));
      Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "key value: pay chat type(%d)", new Object[] { Integer.valueOf(getIntent().getIntExtra("pay_chat_type", 0)) });
      continue;
      localBundle.putInt("code_scene", getIntent().getIntExtra("code_scene", 0));
      Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "key value: pay code scene(%d)", new Object[] { Integer.valueOf(getIntent().getIntExtra("code_scene", 0)) });
      continue;
      localBundle.putInt("scene", getIntent().getIntExtra("scene", -1));
      Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "Key value: Scene(%d)", new Object[] { Integer.valueOf(getIntent().getIntExtra("scene", 0)) });
      continue;
      paramInt = getIntent().getIntExtra("geta8key_scene", 0);
      localBundle.putInt("geta8key_scene", paramInt);
      Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "Key value: getA8KeyScene(%d)", new Object[] { Integer.valueOf(paramInt) });
      continue;
      paramBundle = (WebViewUI)this.WOf.get();
      if (paramBundle == null)
      {
        Log.e("MicroMsg.WebViewStubCallbackAIDLStub", "GetA8key req params, WebViewUI is nil");
        continue;
      }
      paramBundle = paramBundle.Wzl;
      if (paramBundle == null)
      {
        Log.e("MicroMsg.WebViewStubCallbackAIDLStub", "GetA8key req params, controller is nil");
        continue;
      }
      paramBundle = paramBundle.isD();
      localBundle.putInt("key_get_a8key_req_params_req_id", paramBundle.getSessionId());
      localBundle.putString("key_get_a8key_req_params_msg_id", paramBundle.iwm());
      localBundle.putString("key_get_a8key_req_params_username", paramBundle.getUsername());
      localBundle.putString("key_get_a8key_req_params_msg_username", paramBundle.iwl());
      continue;
      D(paramInt, paramBundle);
      if (((WebViewUI)this.WOf.get()).sLC.isSDCardAvailable())
      {
        long l = SdcardUtil.getAvailableExternalMemorySize2();
        Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "availableSize = %d", new Object[] { Long.valueOf(l) });
        if (l < 524288000L)
        {
          Log.e("MicroMsg.WebViewStubCallbackAIDLStub", "available size not enough");
          label1709:
          paramInt = FactoryProxyManager.getPlayManager().init(MMApplicationContext.getContext(), null);
        }
      }
      for (;;)
      {
        if (paramInt == 0)
        {
          if (((WebViewUI)this.WOf.get()).WYk == null)
          {
            ((WebViewUI)this.WOf.get()).WYk = ((WebViewUI)this.WOf.get()).iym();
            FactoryProxyManager.getPlayManager().setUtilsObject(((WebViewUI)this.WOf.get()).WYk);
          }
          i = FactoryProxyManager.getPlayManager().getLocalServerPort();
          Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "webview video init result = %d, local port = %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
          ((WebViewUI)this.WOf.get()).iyk().atK(i);
        }
        localBundle.putInt("webview_video_proxy_init", paramInt);
        break;
        paramBundle = new u(com.tencent.mm.plugin.webview.a.Wui);
        bool1 = true;
        if (!paramBundle.jKS())
        {
          bool1 = paramBundle.jKY();
          Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "create proxy cache path : %s, %b", new Object[] { paramBundle.coT(), Boolean.valueOf(bool1) });
        }
        if (!bool1) {
          break label1709;
        }
        paramInt = FactoryProxyManager.getPlayManager().init(MMApplicationContext.getContext(), q.n(paramBundle.coT(), false));
        FactoryProxyManager.getPlayManager().setMaxStorageSize(200L);
        continue;
        Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "sdcard not available");
        paramInt = FactoryProxyManager.getPlayManager().init(MMApplicationContext.getContext(), null);
      }
      D(paramInt, paramBundle);
      localObject1 = paramBundle.getString("webview_video_proxy_cdn_urls");
      Object localObject4 = paramBundle.getString("webview_video_proxy_fileId");
      paramInt = paramBundle.getInt("webview_video_proxy_file_size");
      int i = paramBundle.getInt("webview_video_proxy_file_duration");
      int j = paramBundle.getInt("webview_video_proxy_file_type");
      int k = FactoryProxyManager.getPlayManager().startPlay((String)localObject1, j, (String)localObject4, paramInt, i);
      paramBundle = FactoryProxyManager.getPlayManager().buildPlayURLMp4(k);
      Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "cdnurls = %s, filedId = %s, fileSize = %d, fileDuration = %d, fileType = %d, playDataId = %d, localUrl = %s", new Object[] { localObject1, localObject4, Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), paramBundle });
      localBundle.putInt("webview_video_proxy_play_data_id", k);
      localBundle.putString("webview_video_proxy_local_url", paramBundle);
      continue;
      D(paramInt, paramBundle);
      paramInt = paramBundle.getInt("webview_video_proxy_play_data_id");
      Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "webview proxy stop play, play id = %d", new Object[] { Integer.valueOf(paramInt) });
      if (paramInt <= 0) {
        continue;
      }
      FactoryProxyManager.getPlayManager().stopPlay(paramInt);
      continue;
      D(paramInt, paramBundle);
      paramInt = paramBundle.getInt("webview_video_proxy_play_state");
      FactoryProxyManager.getPlayManager().setPlayerState(paramInt);
      continue;
      D(paramInt, paramBundle);
      paramInt = paramBundle.getInt("webview_video_proxy_net_state");
      FactoryProxyManager.getPlayManager().setNetWorkState(paramInt);
      continue;
      D(paramInt, paramBundle);
      paramInt = paramBundle.getInt("webview_video_proxy_play_data_id");
      i = paramBundle.getInt("webview_video_proxy_play_remain_time");
      FactoryProxyManager.getPlayManager().setRemainTime(paramInt, i);
      continue;
      D(paramInt, paramBundle);
      paramInt = paramBundle.getInt("webview_video_proxy_play_data_id");
      i = paramBundle.getInt("webview_video_proxy_preload_duration");
      Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "playid = %d, duration = %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      localBundle.putInt("webview_video_proxy_pre_load_result", FactoryProxyManager.getPlayManager().preLoad(paramInt, i));
      continue;
      D(paramInt, paramBundle);
      if (paramBundle.getInt("webview_disable_bounce_scroll_top", 0) <= 0) {
        continue;
      }
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(79983);
          if ((s.a(s.this).get() == null) || (((WebViewUI)s.a(s.this).get()).isFinishing()))
          {
            AppMethodBeat.o(79983);
            return;
          }
          ((WebViewUI)s.a(s.this).get()).WYD.IJ(true);
          AppMethodBeat.o(79983);
        }
      });
      continue;
      D(paramInt, paramBundle);
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(79984);
          if ((s.a(s.this).get() == null) || (((WebViewUI)s.a(s.this).get()).isFinishing()))
          {
            AppMethodBeat.o(79984);
            return;
          }
          Object localObject = (WebViewUI)s.a(s.this).get();
          ((WebViewUI)localObject).WYD.WVU = new WebViewUI.7((WebViewUI)localObject);
          localObject = ((WebViewUI)localObject).WYD;
          ((p)localObject).qWv = true;
          if (((p)localObject).WVW != null)
          {
            ((p)localObject).WVW.setVisibility(0);
            ((p)localObject).WVW.setMMOverScrollOffsetListener((LogoWebViewWrapper.b)localObject);
            ((p)localObject).WVW.setFastScrollBack(true);
            ((p)localObject).WVW.IJ(false);
            ((p)localObject).WVW.setReleaseTargetHeight(((p)localObject).WVX);
          }
          if (((p)localObject).WVV != null)
          {
            ((p)localObject).WVV.setWillNotDraw(true);
            ((p)localObject).WVV.setImageResource(p.WVY);
            ((p)localObject).WVV.setVisibility(0);
            ((p)localObject).WVV.setAlpha(0.0F);
            ((p)localObject).WVV.setWillNotDraw(false);
            ((p)localObject).WVV.invalidate();
          }
          ((p)localObject).iyb();
          AppMethodBeat.o(79984);
        }
      });
      continue;
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(79985);
          if ((s.a(s.this).get() == null) || (((WebViewUI)s.a(s.this).get()).isFinishing()))
          {
            AppMethodBeat.o(79985);
            return;
          }
          ((WebViewUI)s.a(s.this).get()).WYD.stopLoading();
          AppMethodBeat.o(79985);
        }
      });
      continue;
      D(paramInt, paramBundle);
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(79986);
          if ((s.a(s.this).get() == null) || (((WebViewUI)s.a(s.this).get()).isFinishing()))
          {
            AppMethodBeat.o(79986);
            return;
          }
          ((WebViewUI)s.a(s.this).get()).WYD.iya();
          AppMethodBeat.o(79986);
        }
      });
      continue;
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(79987);
          if ((s.a(s.this).get() == null) || (((WebViewUI)s.a(s.this).get()).isFinishing()))
          {
            AppMethodBeat.o(79987);
            return;
          }
          ((WebViewUI)s.a(s.this).get()).WYD.startLoading();
          AppMethodBeat.o(79987);
        }
      });
      continue;
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(79989);
          if ((s.a(s.this).get() == null) || (((WebViewUI)s.a(s.this).get()).isFinishing()))
          {
            AppMethodBeat.o(79989);
            return;
          }
          WebViewUI localWebViewUI = (WebViewUI)s.a(s.this).get();
          if (localWebViewUI.sMP != null) {
            localWebViewUI.sMP.evaluateJavascript("javascript:(function(){return window.getComputedStyle(document.body,null).backgroundColor})()", new WebViewUI.8(localWebViewUI));
          }
          AppMethodBeat.o(79989);
        }
      });
      continue;
      localObject1 = paramBundle.getString("show_kb_placeholder");
      paramInt = paramBundle.getInt("show_kb_max_length");
      i = paramBundle.getInt("show_kb_show_remind_word_count");
      localObject4 = paramBundle.getString("show_kb_text");
      boolean bool1 = paramBundle.getBoolean("show_kb_to_show");
      Object localObject5 = paramBundle.getString("key_show_kb_custom_params");
      paramBundle = new HashMap();
      try
      {
        localObject5 = new JSONObject((String)localObject5);
        paramBundle.put("showType", ((JSONObject)localObject5).optString("showType"));
        paramBundle.put("leftWords", ((JSONObject)localObject5).optString("leftWords"));
        paramBundle.put("rightWords", ((JSONObject)localObject5).optString("rightWords"));
        paramBundle.put("editBoxHeight", ((JSONObject)localObject5).optString("editBoxHeight"));
        paramBundle.put("sendButtonWord", ((JSONObject)localObject5).optString("sendButtonWord"));
        if ((this.WOf.get() == null) || (((WebViewUI)this.WOf.get()).isFinishing()))
        {
          AppMethodBeat.o(80028);
          return null;
        }
        if (bool1)
        {
          ((WebViewUI)this.WOf.get()).a((String)localObject4, (String)localObject1, paramInt, i, paramBundle);
          continue;
        }
        ((WebViewUI)this.WOf.get()).iyG();
        continue;
        if ((this.WOf.get() == null) || (((WebViewUI)this.WOf.get()).isFinishing())) {
          continue;
        }
        localBundle.putInt("height", ((WebViewUI)this.WOf.get()).iyH());
        continue;
        D(paramInt, paramBundle);
        localObject1 = paramBundle.getString("set_page_title_text");
        localObject4 = (WebViewUI)this.WOf.get();
        if ((localObject4 == null) || (((WebViewUI)localObject4).isFinishing()) || (!((WebViewUI)localObject4).PhI)) {
          continue;
        }
        if (localObject1 != null) {
          ((WebViewUI)localObject4).setMMTitle((String)localObject1);
        }
        float f = paramBundle.getFloat("set_page_title_alpha", 1.0F);
        ((WebViewUI)localObject4).setMMTitleColor(f.fo(paramBundle.getString("set_page_title_color"), ((WebViewUI)this.WOf.get()).iyx()));
        if ((f < 0.0F) || (f > 1.0D)) {
          continue;
        }
        ((WebViewUI)localObject4).setTitleAlpha(f);
        continue;
        D(paramInt, paramBundle);
        localObject4 = paramBundle.getString("set_navigation_bar_buttons_text");
        localObject1 = paramBundle.getString("set_navigation_bar_buttons_icon_data");
        bool1 = paramBundle.getBoolean("set_navigation_bar_buttons_hide_right_button", false);
        boolean bool3 = paramBundle.getBoolean("set_navigation_bar_right_style", false);
        if (!Util.isNullOrNil((String)localObject1)) {}
        Object localObject2;
        for (;;)
        {
          try
          {
            localObject1 = f.blD((String)localObject1);
            paramInt = f.fo(paramBundle.getString("set_navigation_bar_buttons_left_text_color"), -16777216);
            bool2 = paramBundle.getBoolean("set_navigation_bar_buttons_need_click_event", false);
            i = (int)f.blC(paramBundle.getString("set_navigation_bar_buttons_text_color"));
            if ((this.WOf.get() == null) || (((WebViewUI)this.WOf.get()).isFinishing())) {
              break;
            }
            if ((bool3) && (((WebViewUI)this.WOf.get()).iyj() != null)) {
              ((WebViewUI)this.WOf.get()).iyj().iBI();
            }
            if (!bool1) {
              break label3081;
            }
            ((WebViewUI)this.WOf.get()).IR(true);
          }
          catch (Exception localException1)
          {
            Log.e("MicroMsg.WebViewStubCallbackAIDLStub", "setNavigationBarButtons, decode base64 image, exception = %s", new Object[] { localException1 });
            localObject2 = null;
            continue;
          }
          localObject2 = null;
        }
        label3081:
        paramBundle = ((WebViewUI)this.WOf.get()).fqa();
        if (!Util.isNullOrNil(paramBundle))
        {
          paramBundle = (Boolean)((WebViewUI)this.WOf.get()).WXN.get(paramBundle);
          if (paramBundle == null)
          {
            bool1 = false;
            label3130:
            ((WebViewUI)this.WOf.get()).IR(Boolean.valueOf(bool1).booleanValue());
            if ((localObject2 == null) || (((Bitmap)localObject2).isRecycled())) {
              break label3273;
            }
            ((WebViewUI)this.WOf.get()).b((String)localObject4, new BitmapDrawable(((WebViewUI)this.WOf.get()).getResources(), (Bitmap)localObject2));
            if (bool2) {
              ((WebViewUI)this.WOf.get()).updateOptionMenuListener(0, new MenuItem.OnMenuItemClickListener()
              {
                public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
                {
                  AppMethodBeat.i(297007);
                  Log.d("MicroMsg.WebViewStubCallbackAIDLStub", "click item: %s", new Object[] { Integer.valueOf(paramAnonymousMenuItem.getItemId()) });
                  ((WebViewUI)s.a(s.this).get()).WlX.itH();
                  AppMethodBeat.o(297007);
                  return false;
                }
              }, null);
            }
          }
          while (((WebViewUI)this.WOf.get()).iyR() != 16)
          {
            ((WebViewUI)this.WOf.get()).auw(paramInt);
            break;
            bool1 = paramBundle.booleanValue();
            break label3130;
            label3273:
            if (!Util.isNullOrNil((String)localObject4))
            {
              if (i == -1) {
                ((WebViewUI)this.WOf.get()).addTextOptionMenu(0, (String)localObject4, new MenuItem.OnMenuItemClickListener()
                {
                  public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
                  {
                    AppMethodBeat.i(296770);
                    Log.d("MicroMsg.WebViewStubCallbackAIDLStub", "click item: %s", new Object[] { Integer.valueOf(paramAnonymousMenuItem.getItemId()) });
                    ((WebViewUI)s.a(s.this).get()).WlX.itH();
                    AppMethodBeat.o(296770);
                    return false;
                  }
                });
              } else {
                ((WebViewUI)this.WOf.get()).addTextOptionMenu(0, (String)localObject4, i, new MenuItem.OnMenuItemClickListener()
                {
                  public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
                  {
                    AppMethodBeat.i(297003);
                    Log.d("MicroMsg.WebViewStubCallbackAIDLStub", "click item: %s", new Object[] { Integer.valueOf(paramAnonymousMenuItem.getItemId()) });
                    ((WebViewUI)s.a(s.this).get()).WlX.itH();
                    AppMethodBeat.o(297003);
                    return false;
                  }
                });
              }
            }
            else {
              ((WebViewUI)this.WOf.get()).addIconOptionMenu(0, ((WebViewUI)this.WOf.get()).iyT(), new MenuItem.OnMenuItemClickListener()
              {
                public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
                {
                  AppMethodBeat.i(296365);
                  Log.d("MicroMsg.WebViewStubCallbackAIDLStub", "click item: %s", new Object[] { Integer.valueOf(paramAnonymousMenuItem.getItemId()) });
                  ((WebViewUI)s.a(s.this).get()).WlX.itH();
                  AppMethodBeat.o(296365);
                  return false;
                }
              }, ((WebViewUI)this.WOf.get()).WYK);
            }
          }
          D(paramInt, paramBundle);
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(79998);
              if ((s.a(s.this).get() == null) || (((WebViewUI)s.a(s.this).get()).isFinishing()))
              {
                AppMethodBeat.o(79998);
                return;
              }
              boolean bool = paramBundle.getBoolean("enable_fullscreen_params_enable", false);
              if (s.b(s.this) != null) {
                s.b(s.this).removeExtra("show_full_screen");
              }
              ((WebViewUI)s.a(s.this).get()).bD(bool, false);
              AppMethodBeat.o(79998);
            }
          });
          continue;
          if ((this.WOf.get() == null) || (((WebViewUI)this.WOf.get()).isFinishing()))
          {
            localBundle.putBoolean("isFullScreen", false);
            continue;
          }
          localBundle.putBoolean("isFullScreen", ((WebViewUI)this.WOf.get()).cHN());
          continue;
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(79999);
              if ((s.a(s.this).get() == null) || (((WebViewUI)s.a(s.this).get()).isFinishing()))
              {
                AppMethodBeat.o(79999);
                return;
              }
              if ((((WebViewUI)s.a(s.this).get()).WXP != null) && (((WebViewUI)s.a(s.this).get()).WXP.isShowing())) {
                ((WebViewUI)s.a(s.this).get()).WXP.dismiss();
              }
              AppMethodBeat.o(79999);
            }
          });
          continue;
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(80000);
              if ((s.a(s.this).get() == null) || (((WebViewUI)s.a(s.this).get()).isFinishing()))
              {
                AppMethodBeat.o(80000);
                return;
              }
              ((WebViewUI)s.a(s.this).get()).WXO = null;
              AppMethodBeat.o(80000);
            }
          });
          continue;
          bool1 = paramBundle.getBoolean("clear_webview_cache_clear_cookie", false);
          Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "includeCookie = %b", new Object[] { Boolean.valueOf(bool1) });
          paramBundle = new Intent();
          paramBundle.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE");
          paramBundle.putExtra("tools_clean_webview_cache_ignore_cookie", bool1);
          com.tencent.mm.xwebutil.c.cs(paramBundle);
          continue;
          if (!paramBundle.getString("enterprise_action").equals("enterprise_get_context_bizchat")) {
            continue;
          }
          localBundle.putString("enterprise_context_biz", getIntent().getStringExtra("enterprise_biz_name"));
          localBundle.putLong("enterprise_context_bizchatid", getIntent().getLongExtra("biz_chat_chat_id", -1L));
          continue;
          D(paramInt, paramBundle);
          paramInt = f.fo(paramBundle.getString("key_set_bounce_background_color"), ((WebViewUI)this.WOf.get()).getResources().getColor(c.c.webview_logo_bg_color));
          ((WebViewUI)this.WOf.get()).WYD.aut(paramInt);
          continue;
          localObject2 = getIntent();
          if (paramBundle == null) {
            continue;
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
            localBundle.putString("newMsgId", t.uA(((Intent)localObject2).getLongExtra("k_expose_msg_id", 0L)));
            continue;
            if (!Util.isNullOrNil(((Intent)localObject2).getStringExtra("k_webview_img")))
            {
              paramBundle = ((Intent)localObject2).getStringExtra("k_webview_img");
              localObject4 = y.bi(paramBundle, 0, (int)y.bEl(paramBundle));
              y.deleteFile(paramBundle);
              localBundle.putString("webviewImg", Base64.encodeToString((byte[])localObject4, 0));
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
          D(paramInt, paramBundle);
          if ((this.WOf.get() == null) || (((WebViewUI)this.WOf.get()).isFinishing())) {
            continue;
          }
          ((WebViewUI)this.WOf.get()).bl(paramBundle);
          continue;
          localBundle.putStringArray("webview_get_route_url_list", ((WebViewUI)this.WOf.get()).Wzl.isw().iwj());
          localBundle.putInt("webview_get_route_url_geta8key_scene", avS(getIntent().getStringExtra("geta8key_username")));
          localBundle.putString("geta8key_username", getIntent().getStringExtra("geta8key_username"));
          continue;
          localObject2 = ((WebViewUI)this.WOf.get()).fqa();
          localObject4 = ao.getCookie((String)localObject2);
          Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "url = %s, cookie = %s", new Object[] { localObject2, localObject4 });
          localBundle.putString("cookie", (String)localObject4);
          localBundle.putFloat("density", mn());
          if (paramBundle == null) {
            continue;
          }
          localBundle.putString("currentUrlPath", com.tencent.mm.plugin.webview.modeltools.k.bkR(paramBundle.getString("currentPicUrl")));
          continue;
          localBundle.putBoolean("from_shortcut", ((WebViewUI)this.WOf.get()).WXv);
          continue;
          paramBundle.setClassLoader(WebViewUI.class.getClassLoader());
          com.tencent.mm.br.c.b((Context)this.WOf.get(), paramBundle.getString("open_ui_with_webview_ui_plugin_name"), paramBundle.getString("open_ui_with_webview_ui_plugin_entry"), new Intent().putExtras(paramBundle.getBundle("open_ui_with_webview_ui_extras")).putExtra("KPublisherId", ((WebViewUI)this.WOf.get()).iag).putExtra("key_search_icon_and_hint_fix_default", true));
          continue;
          D(paramInt, paramBundle);
          localObject2 = paramBundle.getString("traceid");
          paramBundle = paramBundle.getString("username");
          r.WWq.ow((String)localObject2, paramBundle);
          continue;
          paramBundle = ((WebViewUI)this.WOf.get()).getMMTitle();
          localObject2 = getCurrentUrl();
          if ((Util.isNullOrNil(paramBundle)) && (((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).aiy((String)localObject2)))
          {
            paramBundle = getIntent().getStringExtra("webpageTitle");
            localBundle.putString("webview_current_url", (String)localObject2);
            if (paramBundle != null) {}
            for (paramBundle = paramBundle.toString();; paramBundle = "")
            {
              localBundle.putString("webview_current_title", paramBundle);
              localBundle.putString("webview_current_desc", (String)localObject2);
              break;
            }
            if ((this.WOf.get() == null) || (((WebViewUI)this.WOf.get()).Wzl == null)) {
              continue;
            }
            paramBundle = paramBundle.getString("webview_current_url");
            localBundle.putString("k_share_url", ((WebViewUI)this.WOf.get()).Wzl.isD().bkG(paramBundle));
            continue;
            if ((this.WOf.get() == null) || (((WebViewUI)this.WOf.get()).Wzl == null)) {
              continue;
            }
            localBundle.putBoolean("k_text_url_share", ((WebViewUI)this.WOf.get()).Wzl.irH());
            continue;
            paramBundle = ((WebViewUI)this.WOf.get()).getMMTitle();
            localObject2 = getCurrentUrl();
            localObject4 = ipa();
            localObject5 = getIntent();
            if (localObject5 != null)
            {
              localBundle.putString("share_report_pre_msg_url", ((Intent)localObject5).getStringExtra("share_report_pre_msg_url"));
              localBundle.putString("share_report_pre_msg_title", ((Intent)localObject5).getStringExtra("share_report_pre_msg_title"));
              localBundle.putString("share_report_pre_msg_desc", ((Intent)localObject5).getStringExtra("share_report_pre_msg_desc"));
              localBundle.putString("share_report_pre_msg_icon_url", ((Intent)localObject5).getStringExtra("share_report_pre_msg_icon_url"));
              localBundle.putString("share_report_pre_msg_appid", ((Intent)localObject5).getStringExtra("share_report_pre_msg_appid"));
              localBundle.putInt("share_report_from_scene", ((Intent)localObject5).getIntExtra("share_report_from_scene", 0));
              localBundle.putString("share_report_biz_username", ((Intent)localObject5).getStringExtra("share_report_biz_username"));
              localObject5 = ((Intent)localObject5).getBundleExtra("ad_report_bundle");
              if ((!Util.isNullOrNil((String)localObject2)) && (localObject5 != null) && (!Util.isNullOrNil(((Bundle)localObject5).getString("ad_report_ux_info"))))
              {
                localObject7 = Uri.parse((String)localObject2);
                localObject6 = ((Uri)localObject7).getQueryParameter("mid");
                localObject7 = ((Uri)localObject7).getQueryParameter("idx");
                ((Bundle)localObject5).putString("ad_report_mid", (String)localObject6);
                ((Bundle)localObject5).putString("ad_report_idx", (String)localObject7);
                localBundle.putBundle("ad_report_bundle", (Bundle)localObject5);
              }
            }
            localBundle.putString("rawUrl", (String)localObject4);
            localBundle.putString("share_report_current_url", (String)localObject2);
            if (paramBundle != null) {}
            for (paramBundle = paramBundle.toString();; paramBundle = "")
            {
              localBundle.putString("share_report_current_title", paramBundle);
              if ((this.WOf.get() == null) || (((WebViewUI)this.WOf.get()).Wzl == null)) {
                break;
              }
              paramBundle = ((WebViewUI)this.WOf.get()).Wzl;
              if (paramBundle == null) {
                break;
              }
              paramBundle = paramBundle.isD();
              localBundle.putInt("key_get_a8key_req_params_req_id", paramBundle.getSessionId());
              localBundle.putInt("geta8key_scene", paramBundle.getScene());
              break;
            }
            if (((WebViewUI)this.WOf.get()).iyf())
            {
              localBundle.putString("result", "not_return");
              continue;
            }
            localBundle.putString("full_url", Util.nullAsNil(((WebViewUI)this.WOf.get()).sMq));
            if ((((WebViewUI)this.WOf.get()).iyg() != null) && (((WebViewUI)this.WOf.get()).iyg().size() != 0))
            {
              localBundle.putInt("set_cookie", 1);
              ao.oQ(MMApplicationContext.getContext());
              paramBundle = ((WebViewUI)this.WOf.get()).iyg().keySet().iterator();
              while (paramBundle.hasNext())
              {
                localObject2 = (String)paramBundle.next();
                ao.setCookie(Util.getDomin(((WebViewUI)this.WOf.get()).sMq), (String)localObject2 + "=" + (String)((WebViewUI)this.WOf.get()).iyg().get(localObject2));
              }
              ao.setCookie(Util.getDomin(((WebViewUI)this.WOf.get()).sMq), "httponly");
              ao.kgo();
              Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "cookies:%s", new Object[] { ao.getCookie(Util.getDomin(((WebViewUI)this.WOf.get()).sMq)) });
              continue;
            }
            localBundle.putInt("set_cookie", 0);
            continue;
            bool1 = paramBundle.getBoolean("add_shortcut_status");
            if (((WebViewUI)this.WOf.get()).WlX == null) {
              continue;
            }
            ((WebViewUI)this.WOf.get()).WlX.IA(bool1);
            continue;
            localBundle.putBoolean("is_from_keep_top", getIntent().getBooleanExtra("is_from_keep_top", false));
            continue;
            if (((WebViewUI)this.WOf.get()).WXe != null) {
              ((WebViewUI)this.WOf.get()).WXe.disable();
            }
            ((WebViewUI)this.WOf.get()).Wzx = paramBundle.getInt("screen_orientation", -1);
            if (((WebViewUI)this.WOf.get()).Wzx == 1001)
            {
              ((WebViewUI)this.WOf.get()).Wzx = 0;
              if (((WebViewUI)this.WOf.get()).WXe != null)
              {
                Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "OrientationListener, start listen orientation change");
                ((WebViewUI)this.WOf.get()).WXe.enable();
              }
            }
            for (;;)
            {
              ((WebViewUI)this.WOf.get()).setMMOrientation();
              break;
              if (((WebViewUI)this.WOf.get()).Wzx == 1002)
              {
                ((WebViewUI)this.WOf.get()).Wzx = 1;
                if (((WebViewUI)this.WOf.get()).WXe != null)
                {
                  Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "OrientationListener, start listen orientation change");
                  ((WebViewUI)this.WOf.get()).WXe.enable();
                }
              }
            }
            ((WebViewUI)this.WOf.get()).bA(paramBundle);
            continue;
            localBundle.putInt("web_page_count", WebViewUI.WXZ);
            continue;
            localBundle.putString("geta8key_data_req_url", ((WebViewUI)this.WOf.get()).dgY());
            localBundle.putString("geta8key_data_username", getIntent().getStringExtra("geta8key_username"));
            localBundle.putInt("geta8key_data_scene", avS(getIntent().getStringExtra("geta8key_username")));
            localBundle.putInt("geta8key_data_reason", 8);
            if (((WebViewUI)this.WOf.get()).sMP.getIsX5Kernel()) {
              localBundle.putInt("geta8key_data_flag", 1);
            }
            for (;;)
            {
              this.WOf.get();
              localBundle.putString("geta8key_data_net_type", ba.fTX());
              localBundle.putInt("geta8key_session_id", ((WebViewUI)this.WOf.get()).WXw);
              localBundle.putInt("webview_binder_id", ((WebViewUI)this.WOf.get()).irL());
              localBundle.putByteArray("k_a8key_cookie", ((WebViewUI)this.WOf.get()).WXx);
              localBundle.putString("geta8key_data_appid", getIntent().getStringExtra("geta8key_open_webview_appid"));
              break;
              localBundle.putInt("geta8key_data_flag", 0);
            }
            paramBundle.getString("geta8key_result_req_url");
            localObject4 = paramBundle.getString("geta8key_result_full_url");
            if (!Util.isNullOrNil((String)localObject4))
            {
              localObject5 = new JsapiPermissionWrapper(paramBundle.getByteArray("geta8key_result_jsapi_perm_control_bytes"));
              localObject6 = new GeneralControlWrapper(paramBundle.getInt("geta8key_result_general_ctrl_b1"));
              ((g)localObject2).a(((String)localObject4).replaceFirst("http://", "https//"), (JsapiPermissionWrapper)localObject5, (GeneralControlWrapper)localObject6);
              localObject2 = paramBundle.getStringArray("geta8key_result_http_header_key_list");
              localObject4 = paramBundle.getStringArray("geta8key_result_http_header_value_list");
              localObject5 = new HashMap();
              if ((localObject2 != null) && (localObject4 != null) && (localObject2.length > 0) && (localObject4.length > 0) && (localObject2.length == localObject4.length))
              {
                paramInt = 0;
                while (paramInt < localObject2.length)
                {
                  ((Map)localObject5).put(localObject2[paramInt], localObject4[paramInt]);
                  paramInt += 1;
                }
              }
              paramBundle = paramBundle.getString("geta8key_result_title");
              if ((paramBundle == null) || (paramBundle.length() <= 0)) {
                continue;
              }
              ((WebViewUI)this.WOf.get()).setMMTitle(paramBundle);
              continue;
            }
            Log.e("MicroMsg.WebViewStubCallbackAIDLStub", "updatePageAuth fail fullUrl is null");
            continue;
            if (!(this.WOf.get() instanceof GameWebViewUI)) {
              continue;
            }
            paramBundle = (GameWebViewUI)this.WOf.get();
            localBundle.putString("raw_url", paramBundle.dgY());
            localBundle.putString("page_key", paramBundle.iAR());
            paramBundle = paramBundle.getWePkgPlugin();
            if (paramBundle == null) {
              continue;
            }
            localBundle.putString("comm_js_version", com.tencent.mm.plugin.wepkg.f.iEX());
            localBundle.putString("wepkg_version", paramBundle.iEW());
            localBundle.putBoolean("is_used_wepkg", paramBundle.isAvailable());
            continue;
            localBundle.putString("current_url", ((WebViewUI)this.WOf.get()).fqa());
            localBundle.putString("raw_url", ((WebViewUI)this.WOf.get()).dgY());
            continue;
            if (!(this.WOf.get() instanceof GameWebViewUI)) {
              continue;
            }
            ((GameWebViewUI)this.WOf.get()).iAP();
            continue;
            if (!(this.WOf.get() instanceof GameWebViewUI)) {
              continue;
            }
            ((GameWebViewUI)this.WOf.get()).iAQ();
            continue;
            ((WebViewUI)this.WOf.get()).aNr();
            continue;
            localBundle.putString("webpageTitle", ((WebViewUI)this.WOf.get()).getIntent().getStringExtra("webpageTitle"));
            localBundle.putString("thumbUrl", ((WebViewUI)this.WOf.get()).getIntent().getStringExtra("thumbUrl"));
            localBundle.putString("thumbPath", ((WebViewUI)this.WOf.get()).getIntent().getStringExtra("thumbPath"));
            if (!Util.isNullOrNil(((WebViewUI)this.WOf.get()).Wzl.irF()))
            {
              localBundle.putString("webview_current_url", ((WebViewUI)this.WOf.get()).Wzl.irF());
              continue;
            }
            localBundle.putString("webview_current_url", ((WebViewUI)this.WOf.get()).dgY());
            continue;
            localBundle.putBoolean("webview_allow_msg_tail", ((WebViewUI)this.WOf.get()).iyq());
            continue;
            paramBundle = null;
            localObject2 = new Bundle();
            ((Bundle)localObject2).putInt("WebViewShare_BinderID", ((WebViewUI)this.WOf.get()).hashCode());
            ((Bundle)localObject2).putString("WebViewShare_wv_url", ((WebViewUI)this.WOf.get()).sMP.getUrl());
            try
            {
              localObject2 = ((WebViewUI)this.WOf.get()).Wzl.sLC.m(109, (Bundle)localObject2);
              if (localObject2 == null) {
                break label7884;
              }
              localObject2 = ((Bundle)localObject2).getString("key_hao_kan_title");
              paramBundle = (Bundle)localObject2;
            }
            catch (Exception localException2)
            {
              for (;;)
              {
                Log.e("MicroMsg.WebViewStubCallbackAIDLStub", "setHaoKanStatus e=%s", new Object[] { localException2.getMessage() });
              }
            }
            Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "AC_SHOW_HAO_KAN_DIALOG  title:".concat(String.valueOf(paramBundle)));
            n.a((Context)this.WOf.get(), paramBundle, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(296358);
                if (paramAnonymousDialogInterface == null) {}
                for (paramAnonymousDialogInterface = "";; paramAnonymousDialogInterface = ((com.tencent.mm.ui.widget.a.e)paramAnonymousDialogInterface).jHE())
                {
                  ((WebViewUI)s.a(s.this).get()).WlX.D(1, paramAnonymousDialogInterface, 0);
                  AppMethodBeat.o(296358);
                  return;
                }
              }
            });
            continue;
            if ((!(this.WOf.get() instanceof com.tencent.mm.plugin.webview.g.a.a)) || (paramBundle == null)) {
              continue;
            }
            Object localObject3 = (com.tencent.mm.plugin.webview.g.a.a)this.WOf.get();
            localObject4 = paramBundle.getString("action");
            if ("writeComment".equals(localObject4))
            {
              ((com.tencent.mm.plugin.webview.g.a.a)localObject3).bu(paramBundle);
              continue;
            }
            if (!"closeComment".equals(localObject4)) {
              continue;
            }
            ((com.tencent.mm.plugin.webview.g.a.a)localObject3).iwD();
            continue;
            if ((!(this.WOf.get() instanceof com.tencent.mm.plugin.webview.g.a.a)) || (paramBundle == null)) {
              continue;
            }
            localObject3 = (com.tencent.mm.plugin.webview.g.a.a)this.WOf.get();
            localObject4 = paramBundle.getString("action");
            paramInt = -1;
            switch (((String)localObject4).hashCode())
            {
            }
            for (;;)
            {
              switch (paramInt)
              {
              default: 
                break;
              case 0: 
                ((com.tencent.mm.plugin.webview.g.a.a)localObject3).bt(paramBundle);
                break;
                if (((String)localObject4).equals("writeComment"))
                {
                  paramInt = 0;
                  continue;
                  if (((String)localObject4).equals("showToast"))
                  {
                    paramInt = 1;
                    continue;
                    if (((String)localObject4).equals("readArticle"))
                    {
                      paramInt = 2;
                      continue;
                      if (((String)localObject4).equals("writeCommentReply")) {
                        paramInt = 3;
                      }
                    }
                  }
                }
                break;
              }
            }
            ((com.tencent.mm.plugin.webview.g.a.a)localObject3).bv(paramBundle);
            continue;
            ((com.tencent.mm.plugin.webview.g.a.a)localObject3).bs(paramBundle);
            continue;
            ((com.tencent.mm.plugin.webview.g.a.a)localObject3).bw(paramBundle);
            continue;
            if ((((WebViewUI)this.WOf.get()).Psj != null) && (((WebViewUI)this.WOf.get()).Psj.isShowing())) {
              ((WebViewUI)this.WOf.get()).Psj.dismiss();
            }
            if (paramBundle == null)
            {
              Log.w("MicroMsg.WebViewStubCallbackAIDLStub", "show dialog, data is null");
              continue;
            }
            paramBundle.getString("title", ((WebViewUI)this.WOf.get()).getString(c.i.app_tip));
            localObject3 = paramBundle.getString("message", ((WebViewUI)this.WOf.get()).getString(c.i.app_waiting));
            bool1 = paramBundle.getBoolean("cancelable", true);
            ((WebViewUI)this.WOf.get()).Psj = com.tencent.mm.ui.base.k.a((Context)this.WOf.get(), (String)localObject3, bool1, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymousDialogInterface)
              {
                AppMethodBeat.i(80002);
                Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "WebViewUITipsDialogCancel");
                try
                {
                  paramBundle.putInt("WebViewShare_BinderID", ((WebViewUI)s.a(s.this).get()).Wzl.irL());
                  ((WebViewUI)s.a(s.this).get()).sLC.m(111, paramBundle);
                  AppMethodBeat.o(80002);
                  return;
                }
                catch (Exception paramAnonymousDialogInterface)
                {
                  Log.e("MicroMsg.WebViewStubCallbackAIDLStub", "hide dialog err %s", new Object[] { paramAnonymousDialogInterface.getMessage() });
                  AppMethodBeat.o(80002);
                }
              }
            });
            continue;
            if ((((WebViewUI)this.WOf.get()).Psj == null) || (!((WebViewUI)this.WOf.get()).Psj.isShowing())) {
              continue;
            }
            ((WebViewUI)this.WOf.get()).Psj.dismiss();
            continue;
            localObject5 = (WebViewUI)this.WOf.get();
            if (localObject5 == null)
            {
              Log.e("MicroMsg.WebViewStubCallbackAIDLStub", "AC_ON_FAST_LOAD but null WebViewUI");
              continue;
            }
            Object localObject6 = new c.a();
            Object localObject7 = new Intent();
            if (paramBundle.getInt("item_show_type") == 5)
            {
              ((Intent)localObject7).putExtras(paramBundle);
              com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1061L, 21L, 1L, false);
            }
            for (;;)
            {
              ((Intent)localObject7).putExtra("geta8key_scene", paramBundle.getInt("geta8key_scene", ipc()));
              paramInt = paramBundle.getInt("scene");
              i = paramBundle.getInt(f.b.adwc, 10000);
              localObject4 = paramBundle.getString("url");
              localObject3 = localObject4;
              if (((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).isMpUrl((String)localObject4))
              {
                j = (int)(System.currentTimeMillis() / 1000L);
                localObject3 = ((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).e((String)localObject4, paramInt, i, j);
              }
              if (((WebViewUI)localObject5).getIntent() != null) {
                ((Intent)localObject7).putExtra(f.s.adxe, ((WebViewUI)localObject5).getIntent().getStringExtra(f.s.adxe));
              }
              localObject4 = (com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class);
              j = paramBundle.getInt("item_show_type");
              paramBundle.getBoolean("isNativePage");
              localBundle.putBoolean("success", ((com.tencent.mm.plugin.brandservice.api.c)localObject4).a((Context)localObject5, (String)localObject3, j, paramInt, i, (Intent)localObject7, paramBundle.getInt("openType"), (c.a)localObject6));
              if ((((c.a)localObject6).success) || (((c.a)localObject6).message == null)) {
                break;
              }
              localBundle.putString("desc", ((c.a)localObject6).message);
              break;
              ((Intent)localObject7).putExtra("KPublisherId", paramBundle.getString("KPublisherId"));
            }
            paramBundle = (WebViewUI)this.WOf.get();
            if ((paramBundle == null) || (paramBundle.getIntent() == null))
            {
              com.tencent.mm.plugin.ad.a.o("WebViewStubCallback activity[%s]", new Object[] { paramBundle });
              paramBundle = Bundle.EMPTY;
              AppMethodBeat.o(80028);
              return paramBundle;
            }
            localObject3 = new Bundle(1);
            ((Bundle)localObject3).putString(f.s.adxe, paramBundle.getIntent().getStringExtra(f.s.adxe));
            com.tencent.mm.plugin.ad.a.o("WebViewStubCallback activity[%s] adUxInfo[%s]", new Object[] { paramBundle, ((Bundle)localObject3).getString(f.s.adxe) });
            AppMethodBeat.o(80028);
            return localObject3;
            paramBundle = new Bundle(1);
            paramBundle.putString("ad_info_traceId", r.WWq.getTraceId());
            AppMethodBeat.o(80028);
            return paramBundle;
            paramBundle = new Bundle(1);
            localObject3 = (WebViewUI)this.WOf.get();
            if ((localObject3 == null) || (((WebViewUI)localObject3).getIntent() == null))
            {
              Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "AC_GET_H5_PAY_COOKIE but null WebViewUI");
              continue;
            }
            paramBundle.putString("key_h5pay_cookie", getIntent().getStringExtra("key_h5pay_cookie"));
            AppMethodBeat.o(80028);
            return paramBundle;
            paramBundle = (Activity)this.WOf.get();
            if (paramBundle != null) {
              localBundle.putParcelable("delegate", ActivityStarterIpcDelegate.bq(paramBundle));
            }
            AppMethodBeat.o(80028);
            return localBundle;
          }
        }
      }
      catch (Exception localException3)
      {
        for (;;)
        {
          continue;
          label7884:
          paramBundle = null;
          continue;
          continue;
          paramBundle = null;
        }
      }
    }
  }
  
  public final Bundle nK(String paramString1, String paramString2)
  {
    AppMethodBeat.i(80033);
    paramString1 = com.tencent.mm.protocal.c.iPz();
    AppMethodBeat.o(80033);
    return paramString1;
  }
  
  public final void nL(final String paramString1, String paramString2)
  {
    AppMethodBeat.i(80025);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(79981);
        if ((s.a(s.this).get() == null) || (((WebViewUI)s.a(s.this).get()).isFinishing()))
        {
          AppMethodBeat.o(79981);
          return;
        }
        if (!Util.isNullOrNil(((WebViewUI)s.a(s.this).get()).sMP.getUrl()))
        {
          Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "setPageOwner, userName = " + paramString1);
          ((WebViewUI)s.a(s.this).get()).WXL.put(((WebViewUI)s.a(s.this).get()).sMP.getUrl(), paramString1);
          AppMethodBeat.o(79981);
          return;
        }
        Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "setPageOwner, null url");
        AppMethodBeat.o(79981);
      }
    });
    AppMethodBeat.o(80025);
  }
  
  public final void nM(final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(80032);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(80004);
        if ((s.a(s.this).get() == null) || (((WebViewUI)s.a(s.this).get()).isFinishing()))
        {
          AppMethodBeat.o(80004);
          return;
        }
        if (!Util.isNullOrNil(paramString1))
        {
          if (!Util.isNullOrNil(paramString2)) {
            s.b(s.this).putExtra("view_port_code", paramString2);
          }
          ((WebViewUI)s.a(s.this).get()).loadUrl(paramString1);
        }
        AppMethodBeat.o(80004);
      }
    });
    AppMethodBeat.o(80032);
  }
  
  public final void y(final int paramInt, final Bundle paramBundle)
  {
    AppMethodBeat.i(80024);
    if ((this.WOf.get() == null) || (((WebViewUI)this.WOf.get()).isFinishing()))
    {
      AppMethodBeat.o(80024);
      return;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(79980);
        if ((s.a(s.this).get() == null) || (((WebViewUI)s.a(s.this).get()).isFinishing()) || (((WebViewUI)s.a(s.this).get()).sMP == null))
        {
          AppMethodBeat.o(79980);
          return;
        }
        Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "setMenuItemsVisible, actionCode = " + paramInt);
        Object localObject2 = new HashSet();
        String str = ((WebViewUI)s.a(s.this).get()).sMP.getUrl();
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
        Object localObject1;
        for (;;)
        {
          localObject1 = (SparseBooleanArray)((WebViewUI)s.a(s.this).get()).WYi.WVh.get(str);
          switch (paramInt)
          {
          default: 
            AppMethodBeat.o(79980);
            return;
            if (paramBundle == null)
            {
              Log.w("MicroMsg.WebViewStubCallbackAIDLStub", "setMenuItemsVisible data is null.");
              AppMethodBeat.o(79980);
              return;
            }
            localObject1 = paramBundle.getStringArrayList("menu_item_list");
            if ((localObject1 == null) || (((List)localObject1).size() == 0))
            {
              Log.w("MicroMsg.WebViewStubCallbackAIDLStub", "setMenuItemsVisible menuItems is null or nil.");
              AppMethodBeat.o(79980);
              return;
            }
            ((Set)localObject2).addAll((Collection)localObject1);
            ((Set)localObject2).remove("menuItem:exposeArticle");
            ((Set)localObject2).remove("menuItem:keepTop");
            ((Set)localObject2).remove("menuItem:cancelKeepTop");
            ((Set)localObject2).remove("menuItem:profile");
            ((Set)localObject2).remove("menuItem:addContact");
            if (!((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).isMpUrl(str))
            {
              ((Set)localObject2).remove("menuItem:setFont");
              ((Set)localObject2).remove("menuItem:refresh");
            }
            break;
          }
        }
        if (localObject1 == null)
        {
          localObject1 = new SparseBooleanArray();
          ((WebViewUI)s.a(s.this).get()).WYi.WVh.put(str, localObject1);
          ((WebViewUI)s.a(s.this).get()).WYi.h(str, s.b(s.this));
        }
        for (;;)
        {
          localObject2 = ((Set)localObject2).iterator();
          int i;
          while (((Iterator)localObject2).hasNext())
          {
            i = Util.nullAs((Integer)((WebViewUI)s.a(s.this).get()).WYi.WVi.get(((Iterator)localObject2).next()), -1);
            if (i >= 0) {
              ((SparseBooleanArray)localObject1).put(i, true);
            }
          }
          ((WebViewUI)s.a(s.this).get()).WYi.aNr();
          AppMethodBeat.o(79980);
          return;
          if (localObject1 == null) {
            break;
          }
          localObject2 = ((Set)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            i = Util.nullAs((Integer)((WebViewUI)s.a(s.this).get()).WYi.WVi.get(((Iterator)localObject2).next()), -1);
            if (i >= 0) {
              ((SparseBooleanArray)localObject1).delete(i);
            }
          }
          ((WebViewUI)s.a(s.this).get()).WYi.aNr();
          break;
        }
      }
    });
    AppMethodBeat.o(80024);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.s
 * JD-Core Version:    0.7.0.1
 */