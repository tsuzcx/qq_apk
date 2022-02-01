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
import android.os.Looper;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.k.b;
import com.tencent.mm.g.a.ub;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.brandservice.a.b.a;
import com.tencent.mm.plugin.handoff.model.HandOffURL;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic;
import com.tencent.mm.plugin.sns.data.r;
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
import com.tencent.mm.plugin.webview.model.az;
import com.tencent.mm.plugin.webview.stub.f.a;
import com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.cel;
import com.tencent.mm.protocal.protobuf.fah;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.SdcardUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MMFalseProgressBar;
import com.tencent.mm.ui.e.p;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.s;
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

public final class m
  extends f.a
{
  private final WeakReference<WebViewUI> Jbp;
  
  public m(WebViewUI paramWebViewUI)
  {
    AppMethodBeat.i(80008);
    this.Jbp = new WeakReference(paramWebViewUI);
    AppMethodBeat.o(80008);
  }
  
  private int aXI(String paramString)
  {
    AppMethodBeat.i(80027);
    int i = ((WebViewUI)this.Jbp.get()).aXI(paramString);
    AppMethodBeat.o(80027);
    return i;
  }
  
  private float bZk()
  {
    AppMethodBeat.i(80031);
    float f = com.tencent.mm.cc.a.gvp();
    if ((((WebViewUI)this.Jbp.get()).pGj != null) && (((WebViewUI)this.Jbp.get()).pGj.getWebCoreType() == WebView.c.SAt) && (XWalkEnvironment.getUsingCustomContext())) {
      f = ((WebViewUI)this.Jbp.get()).pGj.getResources().getDisplayMetrics().density;
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
    Intent localIntent = ((WebViewUI)this.Jbp.get()).getIntent();
    AppMethodBeat.o(80026);
    return localIntent;
  }
  
  private void y(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(211109);
    if ((paramBundle != null) && (this.Jbp.get() != null) && (((WebViewUI)this.Jbp.get()).IMH != null)) {
      ((WebViewUI)this.Jbp.get()).IMH.ILG.a(new com.tencent.mm.plugin.webview.ui.tools.floatball.a(paramInt, paramBundle));
    }
    AppMethodBeat.o(211109);
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
    if ((this.Jbp.get() == null) || (((WebViewUI)this.Jbp.get()).isFinishing()))
    {
      AppMethodBeat.o(80012);
      return false;
    }
    if (((WebViewUI)this.Jbp.get()).IBw != null)
    {
      paramString1 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(79974);
          if ((m.a(m.this).get() == null) || (((WebViewUI)m.a(m.this).get()).isFinishing()))
          {
            AppMethodBeat.o(79974);
            return;
          }
          ((WebViewUI)m.a(m.this).get()).IBw.a(paramString1, paramString2, com.tencent.mm.plugin.webview.d.n.aN(paramBundle), paramBoolean);
          AppMethodBeat.o(79974);
        }
      };
      if (!MMHandlerThread.isMainThread()) {
        break label87;
      }
      paramString1.run();
    }
    for (;;)
    {
      AppMethodBeat.o(80012);
      return false;
      label87:
      MMHandlerThread.postToMainThread(paramString1);
    }
  }
  
  public final void aL(Bundle paramBundle)
  {
    AppMethodBeat.i(80029);
    if ((this.Jbp.get() == null) || (((WebViewUI)this.Jbp.get()).isFinishing()))
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
      paramBundle.add(new com.tencent.mm.n.e.b((String)((ArrayList)localObject).get(i), (String)localArrayList.get(i)));
      i += 1;
    }
    if (((ArrayList)localObject).size() > 0)
    {
      localObject = ((WebViewUI)this.Jbp.get()).pGj.getUrl();
      if (((WebViewUI)this.Jbp.get()).JiO.containsKey(localObject)) {
        ((WebViewUI)this.Jbp.get()).JiO.remove(localObject);
      }
      ((WebViewUI)this.Jbp.get()).JiO.put(localObject, paramBundle);
    }
    AppMethodBeat.o(80029);
  }
  
  public final void aM(Bundle paramBundle)
  {
    AppMethodBeat.i(80020);
    if ((this.Jbp.get() == null) || (((WebViewUI)this.Jbp.get()).isFinishing()))
    {
      AppMethodBeat.o(80020);
      return;
    }
    Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "IUIController, closeWindow");
    if (paramBundle != null)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("result_data", paramBundle);
      ((WebViewUI)this.Jbp.get()).setResult(-1, localIntent);
    }
    ((WebViewUI)this.Jbp.get()).finish();
    AppMethodBeat.o(80020);
  }
  
  public final void aWP(String paramString)
  {
    final int i = 0;
    AppMethodBeat.i(80021);
    if ((this.Jbp.get() == null) || (((WebViewUI)this.Jbp.get()).isFinishing()))
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
          if ((m.a(m.this).get() == null) || (((WebViewUI)m.a(m.this).get()).isFinishing()))
          {
            AppMethodBeat.o(79978);
            return;
          }
          ((WebViewUI)m.a(m.this).get()).agP(i);
          AppMethodBeat.o(79978);
        }
      });
      AppMethodBeat.o(80021);
    }
    if (((WebViewUI)this.Jbp.get()).pGj == null)
    {
      Log.e("MicroMsg.WebViewStubCallbackAIDLStub", "setFontSizeCb fail, viewWV is null");
      AppMethodBeat.o(80021);
      return;
    }
  }
  
  public final boolean afl(final int paramInt)
  {
    AppMethodBeat.i(80011);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(79973);
        if ((m.a(m.this).get() == null) || (((WebViewUI)m.a(m.this).get()).isFinishing()))
        {
          AppMethodBeat.o(79973);
          return;
        }
        ((WebViewUI)m.a(m.this).get()).setProgressBarIndeterminateVisibility(false);
        Log.d("MicroMsg.WebViewStubCallbackAIDLStub", "[cpan] set title pb visibility:%d", new Object[] { Integer.valueOf(paramInt) });
        if (paramInt == 0)
        {
          if ((!((WebViewUI)m.a(m.this).get()).JiX) && (!((WebViewUI)m.a(m.this).get()).JiY) && (!((WebViewUI)m.a(m.this).get()).cpP()))
          {
            ((WebViewUI)m.a(m.this).get()).JhV.start();
            AppMethodBeat.o(79973);
          }
        }
        else {
          ((WebViewUI)m.a(m.this).get()).JhV.finish();
        }
        AppMethodBeat.o(79973);
      }
    });
    AppMethodBeat.o(80011);
    return true;
  }
  
  public final void e(String paramString1, final String paramString2, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(80023);
    if ((this.Jbp.get() == null) || (((WebViewUI)this.Jbp.get()).isFinishing()))
    {
      AppMethodBeat.o(80023);
      return;
    }
    Log.d("MicroMsg.WebViewStubCallbackAIDLStub", "result: ".concat(String.valueOf(paramString2)));
    if ((((WebViewUI)this.Jbp.get()).Jjl.mHo == null) || (paramString1 == null) || (!paramString1.equals(((WebViewUI)this.Jbp.get()).Jjl.mHo.Jbk)))
    {
      AppMethodBeat.o(80023);
      return;
    }
    if (((WebViewUI)this.Jbp.get()).Jjl.mHo != null) {
      ((WebViewUI)this.Jbp.get()).Jjl.mHo.gdA();
    }
    if ((paramString2 == null) || (((WebViewUI)this.Jbp.get()).Jjl == null))
    {
      AppMethodBeat.o(80023);
      return;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(79979);
        if ((m.a(m.this).get() == null) || (((WebViewUI)m.a(m.this).get()).isFinishing()) || (((WebViewUI)m.a(m.this).get()).pGj == null))
        {
          AppMethodBeat.o(79979);
          return;
        }
        ((WebViewUI)m.a(m.this).get()).Jjl.aF(paramString2, paramInt1, paramInt2);
        AppMethodBeat.o(79979);
      }
    });
    AppMethodBeat.o(80023);
  }
  
  public final String ePp()
  {
    AppMethodBeat.i(211108);
    if ((this.Jbp.get() == null) || (((WebViewUI)this.Jbp.get()).isFinishing()))
    {
      AppMethodBeat.o(211108);
      return null;
    }
    String str = ((WebViewUI)this.Jbp.get()).ePp();
    AppMethodBeat.o(211108);
    return str;
  }
  
  public final boolean f(int paramInt, final Bundle paramBundle)
  {
    AppMethodBeat.i(80009);
    Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "callback, actionCode = ".concat(String.valueOf(paramInt)));
    Object localObject1 = (WebViewUI)this.Jbp.get();
    if ((localObject1 == null) || (((WebViewUI)localObject1).isFinishing()))
    {
      AppMethodBeat.o(80009);
      return false;
    }
    final com.tencent.mm.plugin.webview.d.h localh = ((WebViewUI)localObject1).IBw;
    Object localObject2 = ((WebViewUI)localObject1).mHi;
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
            if ((this.Jhf == null) || (this.Jhf.isFinishing()))
            {
              AppMethodBeat.o(79944);
              return;
            }
            if ((localh != null) && (this.Ecl != null) && (this.Ecl.gdH().pP(42))) {
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
            if ((this.Jhf == null) || (this.Jhf.isFinishing()))
            {
              AppMethodBeat.o(79955);
              return;
            }
            if ((localh != null) && (this.Ecl != null) && (this.Ecl.gdH().pP(42))) {
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
            if ((this.Jhf == null) || (this.Jhf.isFinishing()))
            {
              AppMethodBeat.o(79966);
              return;
            }
            if ((localh != null) && (this.Ecl != null) && (this.Ecl.gdH().pP(42))) {
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
            if ((this.Jhf == null) || (this.Jhf.isFinishing()))
            {
              AppMethodBeat.o(79977);
              return;
            }
            if ((localh != null) && (this.Ecl != null) && (this.Ecl.gdH().pP(42))) {
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
            if ((this.Jhf == null) || (this.Jhf.isFinishing()))
            {
              AppMethodBeat.o(79988);
              return;
            }
            if ((localh != null) && (this.Ecl != null) && (this.Ecl.gdH().pP(42))) {
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
            if ((this.Jhf == null) || (this.Jhf.isFinishing()))
            {
              AppMethodBeat.o(80003);
              return;
            }
            if ((localh != null) && (this.Ecl != null) && (this.Ecl.gdH().pP(42))) {
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
            if ((this.Jhf == null) || (this.Jhf.isFinishing()))
            {
              AppMethodBeat.o(80005);
              return;
            }
            if ((localh != null) && (this.Ecl != null) && (this.Ecl.gdH().pP(42))) {
              localh.a(this.val$appId, l, f, this.JhM);
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
            if ((this.Jhf == null) || (this.Jhf.isFinishing()))
            {
              AppMethodBeat.o(80006);
              return;
            }
            if ((localh != null) && (this.Ecl != null))
            {
              this.Ecl.gdH();
              localh.gj(this.Jhn, this.te);
              AppMethodBeat.o(80006);
              return;
            }
            if ((localh != null) && (this.JhN.booleanValue()))
            {
              localh.gj(this.Jhn, this.te);
              AppMethodBeat.o(80006);
              return;
            }
            if (localh == null) {}
            for (boolean bool1 = true;; bool1 = false)
            {
              if (this.Ecl == null) {
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
            if ((this.Jhf == null) || (this.Jhf.isFinishing()))
            {
              AppMethodBeat.o(80007);
              return;
            }
            if (localh != null)
            {
              com.tencent.mm.plugin.webview.d.h localh = localh;
              String str = this.JhO;
              int i = this.Jhj;
              if (!localh.GBl)
              {
                Log.e("MicroMsg.JsApiHandler", "onMediaFileUploadProgress fail, not ready");
                AppMethodBeat.o(80007);
                return;
              }
              Log.i("MicroMsg.JsApiHandler", "onMediaFileUploadProgress, local id : %s, percent : %d", new Object[] { str, Integer.valueOf(i) });
              HashMap localHashMap = new HashMap();
              localHashMap.put("localId", str);
              localHashMap.put("percent", Integer.valueOf(i));
              MMHandlerThread.postToMainThread(new h.15(localh, n.a.b("onMediaFileUploadProgress", localHashMap, localh.IRj, localh.zpY)));
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
            if ((this.Jhf == null) || (this.Jhf.isFinishing()))
            {
              AppMethodBeat.o(79945);
              return;
            }
            if (localh != null) {
              localh.gk(this.Jhi, this.Jhj);
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
            if ((this.Jhf == null) || (this.Jhf.isFinishing()))
            {
              AppMethodBeat.o(79946);
              return;
            }
            if (localh != null)
            {
              com.tencent.mm.plugin.webview.d.h localh = localh;
              String str1 = this.xzs;
              int i = this.moi;
              String str2 = this.Jhk;
              int j = this.val$errCode;
              String str3 = this.val$errMsg;
              String str4 = this.Jhl;
              String str5 = this.AhE;
              if (!localh.GBl)
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
              MMHandlerThread.postToMainThread(new h.21(localh, n.a.b("onBackgroundAudioStateChange", localHashMap, localh.IRj, localh.zpY)));
            }
            AppMethodBeat.o(79946);
          }
        });
        continue;
        if (paramBundle != null)
        {
          paramBundle.putString("application_language", ((WebViewUI)localObject1).mHh.getLanguage());
          ((WebViewUI)localObject1).JiQ = WebViewUI.a.bc(paramBundle);
          continue;
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(79947);
              if ((this.Jhf == null) || (this.Jhf.isFinishing()))
              {
                AppMethodBeat.o(79947);
                return;
              }
              if (localh != null) {
                localh.gl(this.Jhm, this.cJP);
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
              if ((this.Jhf == null) || (this.Jhf.isFinishing()))
              {
                AppMethodBeat.o(79948);
                return;
              }
              if (localh != null) {
                localh.gm(this.xCb, this.cJP);
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
              if ((this.Jhf == null) || (this.Jhf.isFinishing()))
              {
                AppMethodBeat.o(79949);
                return;
              }
              if (localh != null) {
                localh.gn(this.Jhm, this.cJP);
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
              if ((this.Jhf == null) || (this.Jhf.isFinishing()))
              {
                AppMethodBeat.o(79950);
                return;
              }
              if (localh != null) {
                localh.go(this.xCb, this.cJP);
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
              if ((this.Jhf == null) || (this.Jhf.isFinishing()))
              {
                AppMethodBeat.o(79951);
                return;
              }
              if (localh != null) {
                localh.bI(this.IPs);
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
              if ((this.Jhf == null) || (this.Jhf.isFinishing()))
              {
                AppMethodBeat.o(79952);
                return;
              }
              if (localh != null)
              {
                com.tencent.mm.plugin.webview.d.h localh = localh;
                int i = this.val$errCode;
                if (!localh.GBl)
                {
                  Log.e("MicroMsg.JsApiHandler", "onNfcTouch fail, not ready");
                  AppMethodBeat.o(79952);
                  return;
                }
                Log.i("MicroMsg.JsApiHandler", "onNfcTouch errCode=%d", new Object[] { Integer.valueOf(i) });
                HashMap localHashMap = new HashMap();
                localHashMap.put("errCode", Integer.valueOf(i));
                MMHandlerThread.postToMainThread(new h.24(localh, n.a.b("onNfcTouch", localHashMap, localh.IRj, localh.zpY)));
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
              if ((this.Jhf == null) || (this.Jhf.isFinishing()))
              {
                AppMethodBeat.o(79953);
                return;
              }
              this.Jhf.setMMSubTitle(2131768606);
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
              if ((this.Jhf == null) || (this.Jhf.isFinishing()))
              {
                AppMethodBeat.o(79954);
                return;
              }
              this.Jhf.setMMSubTitle(null);
              if (localh != null) {
                localh.bJ(this.IPs);
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
              if ((this.Jhf == null) || (this.Jhf.isFinishing()))
              {
                AppMethodBeat.o(79956);
                return;
              }
              this.Jhf.setMMSubTitle(null);
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
                if ((this.Jhf == null) || (this.Jhf.isFinishing()))
                {
                  AppMethodBeat.o(79957);
                  return;
                }
                if ((!paramBundle.containsKey("jsapi_preverify_fun_list")) || (this.Ecl == null)) {
                  if (this.Ecl != null) {
                    Log.e("MicroMsg.WebViewStubCallbackAIDLStub", "has JSAPI_CONTROL_BYTES wvPerm %b", new Object[] { Boolean.valueOf(bool) });
                  }
                }
                for (;;)
                {
                  if (localh != null) {
                    localh.gaY();
                  }
                  AppMethodBeat.o(79957);
                  return;
                  bool = false;
                  break;
                  this.Ecl.aR(paramBundle);
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
                    localObject6 = new cel();
                    ((cel)localObject6).parseFrom(paramBundle.getByteArray((String)localObject5));
                    ((LinkedList)localObject1).add(localObject6);
                  }
                }
              }
              catch (IOException paramBundle)
              {
                Log.printErrStackTrace("MicroMsg.WebViewStubCallbackAIDLStub", paramBundle, "parse webCompt", new Object[0]);
              }
              if (localh.gbi() != null)
              {
                localh.gbi().c((String)localObject2, (String)localObject3, (LinkedList)localObject1);
                continue;
                localObject3 = paramBundle.getString("exdevice_device_id");
                final boolean bool = paramBundle.getBoolean("exdevice_is_complete");
                MMHandlerThread.postToMainThread(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(79958);
                    if ((this.Jhf == null) || (this.Jhf.isFinishing()))
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
                      String str = this.Jhn;
                      arrayOfByte = this.Jho;
                      boolean bool1 = bool;
                      bool2 = this.Jhq;
                      if (!localh.GBl)
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
                        com.tencent.mm.plugin.webview.d.a.a.gbs();
                        if ((com.tencent.mm.plugin.webview.d.a.a.cz(arrayOfByte)) || ((arrayOfByte != null) && (bool2))) {
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
                            localh.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + (String)localObject + ")", null);
                            if (!bool2) {
                              com.tencent.mm.plugin.webview.d.a.a.gbs().ISs = arrayOfByte;
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
                      localObject = n.a.a("onScanWXDeviceResult", (JSONObject)localObject, localh.IRj, localh.zpY);
                    }
                    label337:
                    Log.e("MicroMsg.WebViewStubCallbackAIDLStub", "hakon can not call onScanWXDeviceResult, %s, %s", new Object[] { localh, this.Ecl });
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
                    if ((this.Jhf == null) || (this.Jhf.isFinishing()))
                    {
                      AppMethodBeat.o(79959);
                      return;
                    }
                    if (localh != null)
                    {
                      com.tencent.mm.plugin.webview.d.h localh = localh;
                      String str = this.Jhn;
                      byte[] arrayOfByte = this.Jhr;
                      Object localObject = this.rym;
                      if (!localh.GBl)
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
                      MMHandlerThread.postToMainThread(new h.6(localh, n.a.b("onReceiveDataFromWXDevice", (Map)localObject, localh.IRj, localh.zpY)));
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
                    if ((this.Jhf == null) || (this.Jhf.isFinishing()))
                    {
                      AppMethodBeat.o(79960);
                      return;
                    }
                    com.tencent.mm.plugin.webview.d.h localh;
                    HashMap localHashMap;
                    if (localh != null)
                    {
                      localh = localh;
                      String str = this.Jhn;
                      boolean bool = this.Jhs;
                      if (!localh.GBl)
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
                      MMHandlerThread.postToMainThread(new h.7(localh, n.a.b("onWXDeviceBindStateChange", localHashMap, localh.IRj, localh.zpY)));
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
                    if ((this.Jhf == null) || (this.Jhf.isFinishing()))
                    {
                      AppMethodBeat.o(79961);
                      return;
                    }
                    com.tencent.mm.plugin.webview.d.h localh;
                    HashMap localHashMap;
                    if (localh != null)
                    {
                      localh = localh;
                      boolean bool = this.Jht;
                      if (!localh.GBl)
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
                      MMHandlerThread.postToMainThread(new h.8(localh, n.a.b("onWXDeviceBluetoothStateChange", localHashMap, localh.IRj, localh.zpY)));
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
                    if ((this.Jhf == null) || (this.Jhf.isFinishing()))
                    {
                      AppMethodBeat.o(79962);
                      return;
                    }
                    com.tencent.mm.plugin.webview.d.h localh;
                    HashMap localHashMap;
                    if (localh != null)
                    {
                      localh = localh;
                      boolean bool = this.Jht;
                      if (!localh.GBl)
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
                      MMHandlerThread.postToMainThread(new h.9(localh, n.a.b("onWXDeviceLanStateChange", localHashMap, localh.IRj, localh.zpY)));
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
                    if ((this.Jhf == null) || (this.Jhf.isFinishing()))
                    {
                      AppMethodBeat.o(79963);
                      return;
                    }
                    if (localh != null) {
                      localh.aYg(this.val$message);
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
                    if ((this.Jhf == null) || (this.Jhf.isFinishing()))
                    {
                      AppMethodBeat.o(79964);
                      return;
                    }
                    if (localh != null) {
                      localh.a(this.kIS, this.Jhu, this.Jhv, this.iVI, this.Jhw, this.Jhx);
                    }
                    AppMethodBeat.o(79964);
                  }
                });
                continue;
                if ((localObject1 != null) && (!((WebViewUI)localObject1).isFinishing()))
                {
                  ((WebViewUI)localObject1).m(paramInt, paramBundle);
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
                    label2176:
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
                        break label2176;
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
                      if ((this.Jhf == null) || (this.Jhf.isFinishing()))
                      {
                        AppMethodBeat.o(79965);
                        return;
                      }
                      if (localh != null)
                      {
                        com.tencent.mm.plugin.webview.d.h localh = localh;
                        JSONArray localJSONArray = this.Jhy;
                        if (!localh.GBl)
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
                        MMHandlerThread.postToMainThread(new h.72(localh, n.a.b("onGetMsgProofItems", localHashMap, localh.IRj, localh.zpY)));
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
                      if ((this.Jhf == null) || (this.Jhf.isFinishing()))
                      {
                        AppMethodBeat.o(79967);
                        return;
                      }
                      if (localh != null) {
                        localh.aYj(this.val$netType);
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
                      if ((this.Jhf == null) || (this.Jhf.isFinishing()))
                      {
                        AppMethodBeat.o(79968);
                        return;
                      }
                      Object localObject1;
                      String str;
                      Object localObject2;
                      Object localObject3;
                      boolean bool;
                      if (paramBundle != null)
                      {
                        localObject1 = paramBundle.getString("key_bag_icon");
                        if (!Util.isNullOrNil((String)localObject1))
                        {
                          if (this.Jhf.Jjs != null) {
                            this.Jhf.Jjs.setIcon(Util.nullAsNil((String)localObject1));
                          }
                          if (this.Jhf.Jju != null) {
                            this.Jhf.Jju.agS((String)localObject1);
                          }
                          this.Jhf.Jjt.agS((String)localObject1);
                        }
                        str = paramBundle.getString("key_brand_name");
                        localObject2 = paramBundle.getString("key_brand_user_name");
                        localObject1 = paramBundle.getString("key_title");
                        if (!Util.isNullOrNil((String)localObject2)) {
                          this.Jhf.getIntent().putExtra("srcUsername", (String)localObject2);
                        }
                        Log.i("FloatBall", "currentMpInfo, brandName:%s, title:%s", new Object[] { str, localObject1 });
                        if (this.Jhf.ILE != null)
                        {
                          localObject2 = paramBundle;
                          if (localObject2 != null)
                          {
                            localObject3 = ((Bundle)localObject2).getString("key_url");
                            if (!Util.isNullOrNil((String)localObject3)) {
                              break label439;
                            }
                            Log.w("MicroMsg.WebViewUIStyleHelper", "updateCurrentInfo url is null");
                          }
                        }
                        if (this.Jhf.Jjl != null)
                        {
                          localObject2 = this.Jhf.Jjl;
                          localObject3 = paramBundle;
                          if (localObject3 != null)
                          {
                            bool = ((Bundle)localObject3).getBoolean("key_forbidForward");
                            i.Jgg.put(i.ahz(((i)localObject2).nKc), Boolean.valueOf(bool));
                          }
                        }
                        if ((!Util.isNullOrNil((String)localObject1)) || (this.Jhf.getMMTitle() == null)) {
                          break label662;
                        }
                        localObject1 = this.Jhf.getMMTitle().toString();
                      }
                      label662:
                      for (;;)
                      {
                        if (!Util.isNullOrNil((String)localObject1))
                        {
                          if (this.Jhf.Jju != null) {
                            this.Jhf.Jju.aCM((String)localObject1);
                          }
                          this.Jhf.Jjt.agT((String)localObject1);
                          if (this.Jhf.Jjs != null) {
                            this.Jhf.Jjs.setTitle((String)localObject1);
                          }
                          if ((!Util.isNullOrNil(str)) && (this.Jhf.Jju != null)) {
                            this.Jhf.Jju.aGL(str);
                          }
                          if (this.Jhf.Jjs != null) {
                            ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).e(this.Jhf.Jjs);
                          }
                          AppMethodBeat.o(79968);
                          return;
                          label439:
                          Log.d("MicroMsg.WebViewUIStyleHelper", "updateCurrentInfo url %s", new Object[] { localObject3 });
                          localObject3 = o.ahz((String)localObject3);
                          Bundle localBundle = (Bundle)o.Jgg.get(localObject3);
                          if (localBundle == null)
                          {
                            o.Jgg.put(localObject3, localObject2);
                            break;
                          }
                          if (localBundle.getBoolean("key_current_info_show")) {}
                          for (bool = true;; bool = false)
                          {
                            ((Bundle)localObject2).putBoolean("key_current_info_show", bool);
                            o.Jgg.put(localObject3, localObject2);
                            break;
                          }
                        }
                        localObject1 = this.Jhf.Jjt;
                        if (((com.tencent.mm.plugin.webview.ui.tools.floatball.b)localObject1).oWE != null) {}
                        for (localObject1 = ((com.tencent.mm.plugin.webview.ui.tools.floatball.b)localObject1).oWE.name;; localObject1 = null)
                        {
                          if (Util.isNullOrNil((String)localObject1)) {
                            this.Jhf.Jjt.agT(str);
                          }
                          if (Util.isNullOrNil(this.Jhf.Jju.IVb.title)) {
                            this.Jhf.Jju.aCM(str);
                          }
                          if ((this.Jhf.Jjs == null) || (!Util.isNullOrNil(this.Jhf.Jjs.getTitle())) || (Util.isNullOrNil(str))) {
                            break;
                          }
                          this.Jhf.Jjs.setTitle(str);
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
                    com.tencent.f.h.RTc.aX(paramBundle);
                    continue;
                    paramBundle = paramBundle.getString("service_click_tid");
                    Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "on service click, update tid = %s", new Object[] { paramBundle });
                    ((WebViewUI)localObject1).Jjq = paramBundle;
                    ((WebViewUI)localObject1).Jjr = System.currentTimeMillis();
                    MMHandlerThread.postToMainThread(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(79969);
                        if ((this.Jhf == null) || (this.Jhf.isFinishing()))
                        {
                          AppMethodBeat.o(79969);
                          return;
                        }
                        if (this.Jhf.pGj != null)
                        {
                          com.tencent.mm.plugin.normsg.a.d.AEF.a(this.Jhf.pGj, ub.class);
                          if (this.Jhf.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).getBoolean("forceTrigger", false))
                          {
                            Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "on service click, test");
                            EventCenter.instance.publish(new ub());
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
                        if ((this.Jhf == null) || (this.Jhf.isFinishing()))
                        {
                          AppMethodBeat.o(79970);
                          return;
                        }
                        i locali = this.Jhf.Jjl;
                        Object localObject = paramBundle;
                        Log.i("MicroMsg.WebViewLongClickHelper", "onFetchQrCodeResp");
                        int i = ((Bundle)localObject).getInt("key_resp_ret", -1);
                        localObject = ((Bundle)localObject).getByteArray("key_resp_item_bytes");
                        locali.mHu.q(i, (byte[])localObject);
                        AppMethodBeat.o(79970);
                      }
                    });
                    continue;
                    MMHandlerThread.postToMainThread(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(79971);
                        if ((this.Jhf == null) || (this.Jhf.isFinishing()))
                        {
                          AppMethodBeat.o(79971);
                          return;
                        }
                        if (localh != null)
                        {
                          com.tencent.mm.plugin.webview.d.h localh = localh;
                          String str = this.Jhz;
                          int i = this.JhA;
                          if (!localh.GBl)
                          {
                            Log.e("MicroMsg.JsApiHandler", "not ready");
                            AppMethodBeat.o(79971);
                            return;
                          }
                          HashMap localHashMap = new HashMap();
                          localHashMap.put("postId", str);
                          localHashMap.put("result", Integer.valueOf(i));
                          MMHandlerThread.postToMainThread(new h.74(localh, n.a.b("onPublishHaowanEnd", localHashMap, localh.IRj, localh.zpY)));
                        }
                        AppMethodBeat.o(79971);
                      }
                    });
                    continue;
                    MMHandlerThread.postToMainThread(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(79972);
                        if ((this.Jhf == null) || (this.Jhf.isFinishing()))
                        {
                          AppMethodBeat.o(79972);
                          return;
                        }
                        if (localh != null)
                        {
                          com.tencent.mm.plugin.webview.d.h localh = localh;
                          String str = this.Jhz;
                          float f = this.nDE;
                          if (!localh.GBl)
                          {
                            Log.e("MicroMsg.JsApiHandler", "not ready");
                            AppMethodBeat.o(79972);
                            return;
                          }
                          HashMap localHashMap = new HashMap();
                          localHashMap.put("postId", str);
                          localHashMap.put("percent", Float.valueOf(f));
                          MMHandlerThread.postToMainThread(new h.76(localh, n.a.b("onPublishHaowanProgress", localHashMap, localh.IRj, localh.zpY)));
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
    }
  }
  
  public final void fWV()
  {
    AppMethodBeat.i(80019);
    if ((this.Jbp.get() == null) || (((WebViewUI)this.Jbp.get()).isFinishing()))
    {
      AppMethodBeat.o(80019);
      return;
    }
    if (((WebViewUI)this.Jbp.get()).IBw != null) {
      ((WebViewUI)this.Jbp.get()).IBw.fWV();
    }
    AppMethodBeat.o(80019);
  }
  
  public final String fWW()
  {
    AppMethodBeat.i(80013);
    if ((this.Jbp.get() == null) || (((WebViewUI)this.Jbp.get()).isFinishing()))
    {
      AppMethodBeat.o(80013);
      return null;
    }
    String str = ((WebViewUI)this.Jbp.get()).coX();
    AppMethodBeat.o(80013);
    return str;
  }
  
  public final String fWX()
  {
    AppMethodBeat.i(80015);
    if ((this.Jbp.get() == null) || (((WebViewUI)this.Jbp.get()).isFinishing()))
    {
      AppMethodBeat.o(80015);
      return null;
    }
    String str = ((WebViewUI)this.Jbp.get()).getIntent().getStringExtra("srcUsername");
    AppMethodBeat.o(80015);
    return str;
  }
  
  public final int fWY()
  {
    AppMethodBeat.i(80016);
    if ((this.Jbp.get() == null) || (((WebViewUI)this.Jbp.get()).isFinishing()))
    {
      AppMethodBeat.o(80016);
      return 0;
    }
    int i = ((WebViewUI)this.Jbp.get()).bLC();
    AppMethodBeat.o(80016);
    return i;
  }
  
  public final void fWZ()
  {
    AppMethodBeat.i(80022);
    if ((this.Jbp.get() == null) || (((WebViewUI)this.Jbp.get()).isFinishing()))
    {
      AppMethodBeat.o(80022);
      return;
    }
    if (((WebViewUI)this.Jbp.get()).IBw != null) {
      ((WebViewUI)this.Jbp.get()).IBw.fWZ();
    }
    AppMethodBeat.o(80022);
  }
  
  public final Bundle fl(String paramString1, String paramString2)
  {
    AppMethodBeat.i(80033);
    paramString1 = com.tencent.mm.protocal.c.bga(null);
    AppMethodBeat.o(80033);
    return paramString1;
  }
  
  public final String getCurrentUrl()
  {
    AppMethodBeat.i(80014);
    if ((this.Jbp.get() == null) || (((WebViewUI)this.Jbp.get()).isFinishing()))
    {
      AppMethodBeat.o(80014);
      return null;
    }
    String str = ((WebViewUI)this.Jbp.get()).fZM();
    AppMethodBeat.o(80014);
    return str;
  }
  
  public final Bundle j(final int paramInt, final Bundle paramBundle)
  {
    AppMethodBeat.i(80028);
    Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "invokeAsResult, actionCode = ".concat(String.valueOf(paramInt)));
    final Bundle localBundle = new Bundle();
    if ((this.Jbp.get() == null) || (((WebViewUI)this.Jbp.get()).isFinishing()))
    {
      AppMethodBeat.o(80028);
      return localBundle;
    }
    Object localObject1 = ((WebViewUI)this.Jbp.get()).mHi;
    Object localObject2;
    final boolean bool1;
    label1471:
    int i;
    int j;
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
    case 25: 
    case 99: 
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
    case 44: 
    case 45: 
    case 107: 
    case 11: 
    case 12: 
    case 6001: 
    case 71: 
    case 72: 
    case 73: 
    case 53: 
    case 90000: 
    case 90001: 
    case 81: 
    case 101: 
    case 90002: 
      for (;;)
      {
        AppMethodBeat.o(80028);
        return localBundle;
        ((WebViewUI)this.Jbp.get()).Jjh = true;
        continue;
        localObject1 = new com.tencent.mm.g.a.k();
        ((com.tencent.mm.g.a.k)localObject1).dCc.context = ((WebViewUI)this.Jbp.get()).getContext();
        ((com.tencent.mm.g.a.k)localObject1).dCc.actionCode = paramInt;
        if (4003 == paramInt)
        {
          paramBundle = paramBundle.getString("apdu");
          ((com.tencent.mm.g.a.k)localObject1).dCc.dCe = paramBundle;
        }
        final boolean bool2;
        for (;;)
        {
          ((com.tencent.mm.g.a.k)localObject1).callback = new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(79982);
              localBundle.putAll(this.JhD.dCd.dCh);
              AppMethodBeat.o(79982);
            }
          };
          EventCenter.instance.publish((IEvent)localObject1);
          break;
          if (4004 == paramInt)
          {
            localObject2 = paramBundle.getString("apdus");
            bool1 = paramBundle.getBoolean("breakIfFail", true);
            bool2 = paramBundle.getBoolean("breakIfTrue", false);
            ((com.tencent.mm.g.a.k)localObject1).dCc.dCe = ((String)localObject2);
            ((com.tencent.mm.g.a.k)localObject1).dCc.dCf = bool1;
            ((com.tencent.mm.g.a.k)localObject1).dCc.dCg = bool2;
          }
        }
        localBundle.putString("KPublisherId", ((WebViewUI)this.Jbp.get()).eam);
        paramBundle = getIntent();
        if (paramBundle != null)
        {
          paramInt = aXI(getIntent().getStringExtra("geta8key_username"));
          localBundle.putString("preChatName", paramBundle.getStringExtra("preChatName"));
          localBundle.putInt("preMsgIndex", paramBundle.getIntExtra("preMsgIndex", 0));
          localBundle.putString("prePublishId", paramBundle.getStringExtra("prePublishId"));
          localBundle.putString("preUsername", paramBundle.getStringExtra("preUsername"));
          localBundle.putInt("getA8KeyScene", paramInt);
          localBundle.putString("referUrl", ((WebViewUI)this.Jbp.get()).gfv());
          localBundle.putString("url", ((WebViewUI)this.Jbp.get()).fZM());
          localBundle.putString("rawUrl", ((WebViewUI)this.Jbp.get()).coX());
          localBundle.putInt("preChatTYPE", getIntent().getIntExtra("preChatTYPE", 0));
          localBundle.putString("KAppId", paramBundle.getStringExtra("KAppId"));
          paramBundle = (WebViewUI)this.Jbp.get();
          if (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).isMpUrl(paramBundle.coX()))
          {
            localBundle.putInt("_DATA_CENTER_ITEM_SHOW_TYPE", paramBundle.Jit);
            continue;
            localBundle.putString("KSessionId", ((WebViewUI)this.Jbp.get()).sessionId);
            localBundle.putString("KUserAgent", ((WebViewUI)this.Jbp.get()).getUserAgent());
            localBundle.putString("KUrl", ((WebViewUI)this.Jbp.get()).fZM());
            paramInt = aXI(getIntent().getStringExtra("geta8key_username"));
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
                localBundle.putInt("scene", getIntent().getIntExtra("scene", -1));
                Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "Key value: Scene(%d)", new Object[] { Integer.valueOf(getIntent().getIntExtra("scene", 0)) });
                continue;
                paramInt = getIntent().getIntExtra("geta8key_scene", 0);
                localBundle.putInt("geta8key_scene", paramInt);
                Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "Key value: getA8KeyScene(%d)", new Object[] { Integer.valueOf(paramInt) });
                continue;
                y(paramInt, paramBundle);
                if (((WebViewUI)this.Jbp.get()).mHh.isSDCardAvailable())
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
                    if (((WebViewUI)this.Jbp.get()).Jjn == null)
                    {
                      ((WebViewUI)this.Jbp.get()).Jjn = new g((WebViewUI)this.Jbp.get());
                      FactoryProxyManager.getPlayManager().setUtilsObject(((WebViewUI)this.Jbp.get()).Jjn);
                    }
                    i = FactoryProxyManager.getPlayManager().getLocalServerPort();
                    Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "webview video init result = %d, local port = %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
                    paramBundle = ((WebViewUI)this.Jbp.get()).gfg();
                    if ((i <= 0) || (i > 65535)) {
                      Log.e("MicroMsg.WebViewResourceInterrupter", "err port = %d", new Object[] { Integer.valueOf(i) });
                    }
                    if (!paramBundle.IZp.contains(Integer.valueOf(i))) {
                      paramBundle.IZp.add(Integer.valueOf(i));
                    }
                  }
                  localBundle.putInt("webview_video_proxy_init", paramInt);
                  break;
                  paramBundle = new com.tencent.mm.vfs.o(com.tencent.mm.plugin.webview.a.IJo);
                  bool1 = true;
                  if (!paramBundle.exists())
                  {
                    bool1 = paramBundle.mkdirs();
                    Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "create proxy cache path : %s, %b", new Object[] { aa.z(paramBundle.her()), Boolean.valueOf(bool1) });
                  }
                  if (!bool1) {
                    break label1471;
                  }
                  paramInt = FactoryProxyManager.getPlayManager().init(MMApplicationContext.getContext(), com.tencent.mm.b.q.k(aa.z(paramBundle.her()), false));
                  FactoryProxyManager.getPlayManager().setMaxStorageSize(200L);
                  continue;
                  Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "sdcard not available");
                  paramInt = FactoryProxyManager.getPlayManager().init(MMApplicationContext.getContext(), null);
                }
                y(paramInt, paramBundle);
                localObject1 = paramBundle.getString("webview_video_proxy_cdn_urls");
                localObject2 = paramBundle.getString("webview_video_proxy_fileId");
                paramInt = paramBundle.getInt("webview_video_proxy_file_size");
                i = paramBundle.getInt("webview_video_proxy_file_duration");
                j = paramBundle.getInt("webview_video_proxy_file_type");
                int k = FactoryProxyManager.getPlayManager().startPlay((String)localObject1, j, (String)localObject2, paramInt, i);
                paramBundle = FactoryProxyManager.getPlayManager().buildPlayURLMp4(k);
                Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "cdnurls = %s, filedId = %s, fileSize = %d, fileDuration = %d, fileType = %d, playDataId = %d, localUrl = %s", new Object[] { localObject1, localObject2, Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), paramBundle });
                localBundle.putInt("webview_video_proxy_play_data_id", k);
                localBundle.putString("webview_video_proxy_local_url", paramBundle);
                continue;
                y(paramInt, paramBundle);
                paramInt = paramBundle.getInt("webview_video_proxy_play_data_id");
                Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "webview proxy stop play, play id = %d", new Object[] { Integer.valueOf(paramInt) });
                if (paramInt > 0)
                {
                  FactoryProxyManager.getPlayManager().stopPlay(paramInt);
                  continue;
                  y(paramInt, paramBundle);
                  paramInt = paramBundle.getInt("webview_video_proxy_play_state");
                  FactoryProxyManager.getPlayManager().setPlayerState(paramInt);
                  continue;
                  y(paramInt, paramBundle);
                  paramInt = paramBundle.getInt("webview_video_proxy_net_state");
                  FactoryProxyManager.getPlayManager().setNetWorkState(paramInt);
                  continue;
                  y(paramInt, paramBundle);
                  paramInt = paramBundle.getInt("webview_video_proxy_play_data_id");
                  i = paramBundle.getInt("webview_video_proxy_play_remain_time");
                  FactoryProxyManager.getPlayManager().setRemainTime(paramInt, i);
                  continue;
                  y(paramInt, paramBundle);
                  paramInt = paramBundle.getInt("webview_video_proxy_play_data_id");
                  i = paramBundle.getInt("webview_video_proxy_preload_duration");
                  Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "playid = %d, duration = %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
                  localBundle.putInt("webview_video_proxy_pre_load_result", FactoryProxyManager.getPlayManager().preLoad(paramInt, i));
                  continue;
                  y(paramInt, paramBundle);
                  if (paramBundle.getInt("webview_disable_bounce_scroll_top", 0) > 0)
                  {
                    MMHandlerThread.postToMainThread(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(79983);
                        if ((m.a(m.this).get() == null) || (((WebViewUI)m.a(m.this).get()).isFinishing()))
                        {
                          AppMethodBeat.o(79983);
                          return;
                        }
                        ((WebViewUI)m.a(m.this).get()).JjI.zh(true);
                        AppMethodBeat.o(79983);
                      }
                    });
                    continue;
                    y(paramInt, paramBundle);
                    MMHandlerThread.postToMainThread(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(79984);
                        if ((m.a(m.this).get() == null) || (((WebViewUI)m.a(m.this).get()).isFinishing()))
                        {
                          AppMethodBeat.o(79984);
                          return;
                        }
                        Object localObject = (WebViewUI)m.a(m.this).get();
                        ((WebViewUI)localObject).JjI.JgM = new WebViewUI.4((WebViewUI)localObject);
                        localObject = ((WebViewUI)localObject).JjI;
                        ((k)localObject).lcy = true;
                        if (((k)localObject).JgO != null)
                        {
                          ((k)localObject).JgO.setVisibility(0);
                          ((k)localObject).JgO.setMMOverScrollOffsetListener((LogoWebViewWrapper.b)localObject);
                          ((k)localObject).JgO.setFastScrollBack(true);
                          ((k)localObject).JgO.zh(false);
                          ((k)localObject).JgO.setReleaseTargetHeight(((k)localObject).JgP);
                        }
                        if (((k)localObject).JgN != null)
                        {
                          ((k)localObject).JgN.setWillNotDraw(true);
                          ((k)localObject).JgN.setImageResource(k.JgQ);
                          ((k)localObject).JgN.setVisibility(0);
                          ((k)localObject).JgN.setAlpha(0.0F);
                          ((k)localObject).JgN.setWillNotDraw(false);
                          ((k)localObject).JgN.invalidate();
                        }
                        ((k)localObject).geW();
                        AppMethodBeat.o(79984);
                      }
                    });
                    continue;
                    MMHandlerThread.postToMainThread(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(79985);
                        if ((m.a(m.this).get() == null) || (((WebViewUI)m.a(m.this).get()).isFinishing()))
                        {
                          AppMethodBeat.o(79985);
                          return;
                        }
                        ((WebViewUI)m.a(m.this).get()).JjI.stopLoading();
                        AppMethodBeat.o(79985);
                      }
                    });
                    continue;
                    y(paramInt, paramBundle);
                    MMHandlerThread.postToMainThread(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(79986);
                        if ((m.a(m.this).get() == null) || (((WebViewUI)m.a(m.this).get()).isFinishing()))
                        {
                          AppMethodBeat.o(79986);
                          return;
                        }
                        ((WebViewUI)m.a(m.this).get()).JjI.geU();
                        AppMethodBeat.o(79986);
                      }
                    });
                    continue;
                    MMHandlerThread.postToMainThread(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(79987);
                        if ((m.a(m.this).get() == null) || (((WebViewUI)m.a(m.this).get()).isFinishing()))
                        {
                          AppMethodBeat.o(79987);
                          return;
                        }
                        ((WebViewUI)m.a(m.this).get()).JjI.startLoading();
                        AppMethodBeat.o(79987);
                      }
                    });
                    continue;
                    MMHandlerThread.postToMainThread(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(79989);
                        if ((m.a(m.this).get() == null) || (((WebViewUI)m.a(m.this).get()).isFinishing()))
                        {
                          AppMethodBeat.o(79989);
                          return;
                        }
                        WebViewUI localWebViewUI = (WebViewUI)m.a(m.this).get();
                        if (localWebViewUI.pGj != null) {
                          localWebViewUI.pGj.evaluateJavascript("javascript:(function(){return window.getComputedStyle(document.body,null).backgroundColor})()", new WebViewUI.5(localWebViewUI));
                        }
                        AppMethodBeat.o(79989);
                      }
                    });
                    continue;
                    MMHandlerThread.postToMainThread(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(79990);
                        if ((m.a(m.this).get() == null) || (((WebViewUI)m.a(m.this).get()).isFinishing()))
                        {
                          AppMethodBeat.o(79990);
                          return;
                        }
                        ((WebViewUI)m.a(m.this).get()).aG(this.JhE, this.JhF, this.JhG);
                        AppMethodBeat.o(79990);
                      }
                    });
                    continue;
                    if ((this.Jbp.get() != null) && (!((WebViewUI)this.Jbp.get()).isFinishing()))
                    {
                      localBundle.putInt("height", ((WebViewUI)this.Jbp.get()).gfz());
                      continue;
                      localObject1 = paramBundle.getString("set_page_title_text");
                      paramBundle = paramBundle.getString("set_page_title_color");
                      localObject2 = (WebViewUI)this.Jbp.get();
                      if ((com.tencent.mm.compatible.util.d.oD(21)) && (((WebViewUI)localObject2).gfr())) {}
                      for (paramInt = -16777216;; paramInt = ((WebViewUI)localObject2).getResources().getColor(2131099892))
                      {
                        e.gw(paramBundle, paramInt);
                        MMHandlerThread.postToMainThread(new Runnable()
                        {
                          public final void run()
                          {
                            AppMethodBeat.i(79991);
                            if ((m.a(m.this).get() == null) || (((WebViewUI)m.a(m.this).get()).isFinishing()))
                            {
                              AppMethodBeat.o(79991);
                              return;
                            }
                            if (!((WebViewUI)m.a(m.this).get()).CSQ)
                            {
                              AppMethodBeat.o(79991);
                              return;
                            }
                            if (this.dqb != null) {
                              ((WebViewUI)m.a(m.this).get()).setMMTitle(this.dqb);
                            }
                            AppMethodBeat.o(79991);
                          }
                        });
                        break;
                      }
                      y(paramInt, paramBundle);
                      localObject2 = paramBundle.getString("set_navigation_bar_buttons_text");
                      localObject1 = paramBundle.getString("set_navigation_bar_buttons_icon_data");
                      bool1 = paramBundle.getBoolean("set_navigation_bar_buttons_hide_right_button", false);
                      bool2 = paramBundle.getBoolean("set_navigation_bar_right_style", false);
                      if (!Util.isNullOrNil((String)localObject1)) {}
                      for (;;)
                      {
                        try
                        {
                          localObject1 = e.bah((String)localObject1);
                          paramInt = e.gw(paramBundle.getString("set_navigation_bar_buttons_left_text_color"), -16777216);
                          MMHandlerThread.postToMainThread(new Runnable()
                          {
                            public final void run()
                            {
                              AppMethodBeat.i(79992);
                              if ((m.a(m.this).get() == null) || (((WebViewUI)m.a(m.this).get()).isFinishing()))
                              {
                                AppMethodBeat.o(79992);
                                return;
                              }
                              if (bool2)
                              {
                                if (((WebViewUI)m.a(m.this).get()).Jju != null) {
                                  ((WebViewUI)m.a(m.this).get()).Jju.ghZ();
                                }
                                ((WebViewUI)m.a(m.this).get()).Jjt.ghZ();
                              }
                              if (bool1)
                              {
                                ((WebViewUI)m.a(m.this).get()).zl(true);
                                AppMethodBeat.o(79992);
                                return;
                              }
                              Object localObject = ((WebViewUI)m.a(m.this).get()).fZM();
                              if (!Util.isNullOrNil((String)localObject)) {}
                              for (localObject = (Boolean)((WebViewUI)m.a(m.this).get()).JiP.get(localObject);; localObject = null)
                              {
                                boolean bool;
                                if (localObject == null)
                                {
                                  bool = false;
                                  ((WebViewUI)m.a(m.this).get()).zl(Boolean.valueOf(bool).booleanValue());
                                  if ((this.IUD == null) || (this.IUD.isRecycled())) {
                                    break label345;
                                  }
                                  ((WebViewUI)m.a(m.this).get()).b(this.val$text, new BitmapDrawable(((WebViewUI)m.a(m.this).get()).getResources(), this.IUD));
                                  if (this.IUG) {
                                    ((WebViewUI)m.a(m.this).get()).updateOptionMenuListener(0, new MenuItem.OnMenuItemClickListener()
                                    {
                                      public final boolean onMenuItemClick(MenuItem paramAnonymous2MenuItem)
                                      {
                                        AppMethodBeat.i(211102);
                                        Log.d("MicroMsg.WebViewStubCallbackAIDLStub", "click item: %s", new Object[] { Integer.valueOf(paramAnonymous2MenuItem.getItemId()) });
                                        ((WebViewUI)m.a(m.this).get()).IBw.gbg();
                                        AppMethodBeat.o(211102);
                                        return false;
                                      }
                                    }, null);
                                  }
                                }
                                for (;;)
                                {
                                  ((WebViewUI)m.a(m.this).get()).agM(paramInt);
                                  AppMethodBeat.o(79992);
                                  return;
                                  bool = ((Boolean)localObject).booleanValue();
                                  break;
                                  label345:
                                  if (!Util.isNullOrNil(this.val$text))
                                  {
                                    if (this.IUF == -1) {
                                      ((WebViewUI)m.a(m.this).get()).addTextOptionMenu(0, this.val$text, new MenuItem.OnMenuItemClickListener()
                                      {
                                        public final boolean onMenuItemClick(MenuItem paramAnonymous2MenuItem)
                                        {
                                          AppMethodBeat.i(211103);
                                          Log.d("MicroMsg.WebViewStubCallbackAIDLStub", "click item: %s", new Object[] { Integer.valueOf(paramAnonymous2MenuItem.getItemId()) });
                                          ((WebViewUI)m.a(m.this).get()).IBw.gbg();
                                          AppMethodBeat.o(211103);
                                          return false;
                                        }
                                      });
                                    } else {
                                      ((WebViewUI)m.a(m.this).get()).addTextOptionMenu(0, this.val$text, this.IUF, new MenuItem.OnMenuItemClickListener()
                                      {
                                        public final boolean onMenuItemClick(MenuItem paramAnonymous2MenuItem)
                                        {
                                          AppMethodBeat.i(211104);
                                          Log.d("MicroMsg.WebViewStubCallbackAIDLStub", "click item: %s", new Object[] { Integer.valueOf(paramAnonymous2MenuItem.getItemId()) });
                                          ((WebViewUI)m.a(m.this).get()).IBw.gbg();
                                          AppMethodBeat.o(211104);
                                          return false;
                                        }
                                      });
                                    }
                                  }
                                  else {
                                    ((WebViewUI)m.a(m.this).get()).addIconOptionMenu(0, ((WebViewUI)m.a(m.this).get()).gfL(), new MenuItem.OnMenuItemClickListener()
                                    {
                                      public final boolean onMenuItemClick(MenuItem paramAnonymous2MenuItem)
                                      {
                                        AppMethodBeat.i(211105);
                                        Log.d("MicroMsg.WebViewStubCallbackAIDLStub", "click item: %s", new Object[] { Integer.valueOf(paramAnonymous2MenuItem.getItemId()) });
                                        ((WebViewUI)m.a(m.this).get()).IBw.gbg();
                                        AppMethodBeat.o(211105);
                                        return false;
                                      }
                                    }, ((WebViewUI)m.a(m.this).get()).JjO);
                                  }
                                }
                              }
                            }
                          });
                        }
                        catch (Exception localException)
                        {
                          localObject1 = null;
                          Log.e("MicroMsg.WebViewStubCallbackAIDLStub", "setNavigationBarButtons, decode base64 image, exception = %s", new Object[] { localException });
                          continue;
                        }
                        localObject1 = null;
                      }
                      y(paramInt, paramBundle);
                      MMHandlerThread.postToMainThread(new Runnable()
                      {
                        public final void run()
                        {
                          AppMethodBeat.i(79997);
                          if ((m.a(m.this).get() == null) || (((WebViewUI)m.a(m.this).get()).isFinishing()))
                          {
                            AppMethodBeat.o(79997);
                            return;
                          }
                          boolean bool = paramBundle.getBoolean("enable_fullscreen_params_enable", false);
                          if (m.b(m.this) != null) {
                            m.b(m.this).removeExtra("show_full_screen");
                          }
                          ((WebViewUI)m.a(m.this).get()).aV(bool, false);
                          AppMethodBeat.o(79997);
                        }
                      });
                      continue;
                      if ((this.Jbp.get() == null) || (((WebViewUI)this.Jbp.get()).isFinishing()))
                      {
                        localBundle.putBoolean("isFullScreen", false);
                      }
                      else
                      {
                        localBundle.putBoolean("isFullScreen", ((WebViewUI)this.Jbp.get()).Jig);
                        continue;
                        MMHandlerThread.postToMainThread(new Runnable()
                        {
                          public final void run()
                          {
                            AppMethodBeat.i(79998);
                            if ((m.a(m.this).get() == null) || (((WebViewUI)m.a(m.this).get()).isFinishing()))
                            {
                              AppMethodBeat.o(79998);
                              return;
                            }
                            if ((((WebViewUI)m.a(m.this).get()).JiR != null) && (((WebViewUI)m.a(m.this).get()).JiR.isShowing())) {
                              ((WebViewUI)m.a(m.this).get()).JiR.dismiss();
                            }
                            AppMethodBeat.o(79998);
                          }
                        });
                        continue;
                        MMHandlerThread.postToMainThread(new Runnable()
                        {
                          public final void run()
                          {
                            AppMethodBeat.i(79999);
                            if ((m.a(m.this).get() == null) || (((WebViewUI)m.a(m.this).get()).isFinishing()))
                            {
                              AppMethodBeat.o(79999);
                              return;
                            }
                            ((WebViewUI)m.a(m.this).get()).JiQ = null;
                            AppMethodBeat.o(79999);
                          }
                        });
                        continue;
                        bool1 = paramBundle.getBoolean("clear_webview_cache_clear_cookie", false);
                        Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "includeCookie = %b", new Object[] { Boolean.valueOf(bool1) });
                        paramBundle = new Intent();
                        paramBundle.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE");
                        paramBundle.putExtra("tools_clean_webview_cache_ignore_cookie", bool1);
                        com.tencent.mm.cr.d.bJ(paramBundle);
                        continue;
                        if (paramBundle.getString("enterprise_action").equals("enterprise_get_context_bizchat"))
                        {
                          localBundle.putString("enterprise_context_biz", getIntent().getStringExtra("enterprise_biz_name"));
                          localBundle.putLong("enterprise_context_bizchatid", getIntent().getLongExtra("biz_chat_chat_id", -1L));
                          continue;
                          y(paramInt, paramBundle);
                          paramInt = e.gw(paramBundle.getString("key_set_bounce_background_color"), ((WebViewUI)this.Jbp.get()).getResources().getColor(2131101408));
                          ((WebViewUI)this.Jbp.get()).JjI.agK(paramInt);
                          continue;
                          localObject1 = getIntent();
                          if (paramBundle != null)
                          {
                            paramInt = paramBundle.getInt("scene");
                            switch (paramInt)
                            {
                            default: 
                              Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "unknown expose scene: %d", new Object[] { Integer.valueOf(paramInt) });
                            }
                            for (;;)
                            {
                              localBundle.putString("username", ((Intent)localObject1).getStringExtra("k_username"));
                              break;
                              localBundle.putStringArrayList("proof", ((Intent)localObject1).getStringArrayListExtra("k_outside_expose_proof_item_list"));
                              continue;
                              localBundle.putString("newMsgId", r.Jb(((Intent)localObject1).getLongExtra("k_expose_msg_id", 0L)));
                              continue;
                              if (!Util.isNullOrNil(((Intent)localObject1).getStringExtra("k_webview_img")))
                              {
                                paramBundle = ((Intent)localObject1).getStringExtra("k_webview_img");
                                localObject2 = s.aW(paramBundle, 0, (int)s.boW(paramBundle));
                                s.deleteFile(paramBundle);
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
                            y(paramInt, paramBundle);
                            MMHandlerThread.postToMainThread(new Runnable()
                            {
                              public final void run()
                              {
                                AppMethodBeat.i(80000);
                                if ((m.a(m.this).get() == null) || (((WebViewUI)m.a(m.this).get()).isFinishing()))
                                {
                                  AppMethodBeat.o(80000);
                                  return;
                                }
                                ((WebViewUI)m.a(m.this).get()).bb(paramBundle);
                                AppMethodBeat.o(80000);
                              }
                            });
                            continue;
                            localBundle.putStringArray("webview_get_route_url_list", ((WebViewUI)this.Jbp.get()).Jjk.gdF());
                            localBundle.putInt("webview_get_route_url_geta8key_scene", aXI(getIntent().getStringExtra("geta8key_username")));
                            localBundle.putString("geta8key_username", getIntent().getStringExtra("geta8key_username"));
                            continue;
                            localObject1 = ((WebViewUI)this.Jbp.get()).fZM();
                            localObject2 = com.tencent.xweb.c.hsp().getCookie((String)localObject1);
                            Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "url = %s, cookie = %s", new Object[] { localObject1, localObject2 });
                            localBundle.putString("cookie", (String)localObject2);
                            localBundle.putFloat("density", bZk());
                            if (paramBundle != null)
                            {
                              localBundle.putString("currentUrlPath", com.tencent.mm.plugin.webview.modeltools.j.aZt(paramBundle.getString("currentPicUrl")));
                              continue;
                              localBundle.putBoolean("from_shortcut", ((WebViewUI)this.Jbp.get()).Jix);
                              continue;
                              paramBundle.setClassLoader(WebViewUI.class.getClassLoader());
                              com.tencent.mm.br.c.b((Context)this.Jbp.get(), paramBundle.getString("open_ui_with_webview_ui_plugin_name"), paramBundle.getString("open_ui_with_webview_ui_plugin_entry"), new Intent().putExtras(paramBundle.getBundle("open_ui_with_webview_ui_extras")).putExtra("KPublisherId", ((WebViewUI)this.Jbp.get()).eam));
                              continue;
                              y(paramInt, paramBundle);
                              localObject1 = paramBundle.getString("traceid");
                              paramBundle = paramBundle.getString("username");
                              l.Jhd.me((String)localObject1, paramBundle);
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
    case 84: 
      paramBundle = ((WebViewUI)this.Jbp.get()).getMMTitle();
      localObject1 = getCurrentUrl();
      if ((Util.isNullOrNil(paramBundle)) && (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).ahv((String)localObject1))) {
        paramBundle = getIntent().getStringExtra("webpageTitle");
      }
      break;
    }
    for (;;)
    {
      localBundle.putString("webview_current_url", (String)localObject1);
      if (paramBundle != null) {}
      for (paramBundle = paramBundle.toString();; paramBundle = "")
      {
        localBundle.putString("webview_current_title", paramBundle);
        localBundle.putString("webview_current_desc", (String)localObject1);
        break;
      }
      paramBundle = ((WebViewUI)this.Jbp.get()).getMMTitle();
      localObject1 = getCurrentUrl();
      localObject2 = getIntent();
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
        if ((!Util.isNullOrNil((String)localObject1)) && (localObject2 != null) && (!Util.isNullOrNil(((Bundle)localObject2).getString("ad_report_ux_info"))))
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
      if (((WebViewUI)this.Jbp.get()).gfa())
      {
        localBundle.putString("result", "not_return");
        break;
      }
      localBundle.putString("full_url", Util.nullAsNil(((WebViewUI)this.Jbp.get()).pFJ));
      if ((((WebViewUI)this.Jbp.get()).gfb() != null) && (((WebViewUI)this.Jbp.get()).gfb().size() != 0))
      {
        localBundle.putInt("set_cookie", 1);
        com.tencent.xweb.d.lA(MMApplicationContext.getContext());
        paramBundle = com.tencent.xweb.c.hsp();
        localObject1 = ((WebViewUI)this.Jbp.get()).gfb().keySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          paramBundle.setCookie(Util.getDomin(((WebViewUI)this.Jbp.get()).pFJ), (String)localObject2 + "=" + (String)((WebViewUI)this.Jbp.get()).gfb().get(localObject2));
        }
        paramBundle.setCookie(Util.getDomin(((WebViewUI)this.Jbp.get()).pFJ), "httponly");
        com.tencent.xweb.d.hsr();
        com.tencent.xweb.d.sync();
        Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "cookies:%s", new Object[] { paramBundle.getCookie(Util.getDomin(((WebViewUI)this.Jbp.get()).pFJ)) });
        break;
      }
      localBundle.putInt("set_cookie", 0);
      break;
      bool1 = paramBundle.getBoolean("add_shortcut_status");
      if (((WebViewUI)this.Jbp.get()).IBw == null) {
        break;
      }
      ((WebViewUI)this.Jbp.get()).IBw.yX(bool1);
      break;
      localBundle.putBoolean("is_from_keep_top", getIntent().getBooleanExtra("is_from_keep_top", false));
      break;
      if (((WebViewUI)this.Jbp.get()).Jii != null) {
        ((WebViewUI)this.Jbp.get()).Jii.disable();
      }
      ((WebViewUI)this.Jbp.get()).screenOrientation = paramBundle.getInt("screen_orientation", -1);
      if (((WebViewUI)this.Jbp.get()).screenOrientation == 1001)
      {
        ((WebViewUI)this.Jbp.get()).screenOrientation = 0;
        if (((WebViewUI)this.Jbp.get()).Jii != null)
        {
          Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "OrientationListener, start listen orientation change");
          ((WebViewUI)this.Jbp.get()).Jii.enable();
        }
      }
      for (;;)
      {
        ((WebViewUI)this.Jbp.get()).setMMOrientation();
        break;
        if (((WebViewUI)this.Jbp.get()).screenOrientation == 1002)
        {
          ((WebViewUI)this.Jbp.get()).screenOrientation = 1;
          if (((WebViewUI)this.Jbp.get()).Jii != null)
          {
            Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "OrientationListener, start listen orientation change");
            ((WebViewUI)this.Jbp.get()).Jii.enable();
          }
        }
      }
      ((WebViewUI)this.Jbp.get()).ba(paramBundle);
      break;
      localBundle.putInt("web_page_count", WebViewUI.Jjc);
      break;
      localBundle.putString("geta8key_data_req_url", ((WebViewUI)this.Jbp.get()).coX());
      localBundle.putString("geta8key_data_username", getIntent().getStringExtra("geta8key_username"));
      localBundle.putInt("geta8key_data_scene", aXI(getIntent().getStringExtra("geta8key_username")));
      localBundle.putInt("geta8key_data_reason", 8);
      if (((WebViewUI)this.Jbp.get()).pGj.getIsX5Kernel()) {
        localBundle.putInt("geta8key_data_flag", 1);
      }
      for (;;)
      {
        this.Jbp.get();
        localBundle.putString("geta8key_data_net_type", az.gcX());
        localBundle.putInt("geta8key_session_id", ((WebViewUI)this.Jbp.get()).Jiy);
        localBundle.putInt("webview_binder_id", ((WebViewUI)this.Jbp.get()).fZu());
        localBundle.putByteArray("k_a8key_cookie", ((WebViewUI)this.Jbp.get()).Jiz);
        localBundle.putString("geta8key_data_appid", getIntent().getStringExtra("geta8key_open_webview_appid"));
        break;
        localBundle.putInt("geta8key_data_flag", 0);
      }
      paramBundle.getString("geta8key_result_req_url");
      localObject2 = paramBundle.getString("geta8key_result_full_url");
      if (!Util.isNullOrNil((String)localObject2))
      {
        localObject3 = new JsapiPermissionWrapper(paramBundle.getByteArray("geta8key_result_jsapi_perm_control_bytes"));
        localObject4 = new GeneralControlWrapper(paramBundle.getInt("geta8key_result_general_ctrl_b1"));
        ((com.tencent.mm.plugin.webview.f.g)localObject1).a(((String)localObject2).replaceFirst("http://", "https//"), (JsapiPermissionWrapper)localObject3, (GeneralControlWrapper)localObject4);
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
        if ((paramBundle == null) || (paramBundle.length() <= 0)) {
          break;
        }
        ((WebViewUI)this.Jbp.get()).setMMTitle(paramBundle);
        break;
      }
      Log.e("MicroMsg.WebViewStubCallbackAIDLStub", "updatePageAuth fail fullUrl is null");
      break;
      if (!(this.Jbp.get() instanceof GameWebViewUI)) {
        break;
      }
      paramBundle = (GameWebViewUI)this.Jbp.get();
      localBundle.putString("raw_url", paramBundle.coX());
      localBundle.putString("page_key", paramBundle.ghj());
      paramBundle = paramBundle.JpX;
      if (paramBundle == null) {
        break;
      }
      localBundle.putString("comm_js_version", com.tencent.mm.plugin.wepkg.e.gky());
      localBundle.putString("wepkg_version", paramBundle.gkx());
      localBundle.putBoolean("is_used_wepkg", paramBundle.JLC);
      break;
      localBundle.putString("current_url", ((WebViewUI)this.Jbp.get()).fZM());
      localBundle.putString("raw_url", ((WebViewUI)this.Jbp.get()).coX());
      break;
      if (!(this.Jbp.get() instanceof GameWebViewUI)) {
        break;
      }
      paramBundle = (GameWebViewUI)this.Jbp.get();
      paramBundle.xyM.Jra = System.currentTimeMillis();
      paramBundle.xyv.hhB = 1;
      break;
      if (!(this.Jbp.get() instanceof GameWebViewUI)) {
        break;
      }
      ((GameWebViewUI)this.Jbp.get()).xyM.Jrb = System.currentTimeMillis();
      break;
      ((WebViewUI)this.Jbp.get()).ani();
      break;
      if ((!(this.Jbp.get() instanceof com.tencent.mm.plugin.webview.h.a.b)) || (paramBundle == null)) {
        break;
      }
      localObject1 = (com.tencent.mm.plugin.webview.h.a.b)this.Jbp.get();
      localObject2 = paramBundle.getString("action");
      if ("writeComment".equals(localObject2))
      {
        ((com.tencent.mm.plugin.webview.h.a.b)localObject1).aU(paramBundle);
        break;
      }
      if (!"closeComment".equals(localObject2)) {
        break;
      }
      ((com.tencent.mm.plugin.webview.h.a.b)localObject1).gdM();
      break;
      if (((this.Jbp.get() instanceof com.tencent.mm.plugin.webview.h.a.b)) && (paramBundle != null))
      {
        localObject1 = (com.tencent.mm.plugin.webview.h.a.b)this.Jbp.get();
        localObject2 = paramBundle.getString("action");
        paramInt = -1;
        switch (((String)localObject2).hashCode())
        {
        default: 
          label5600:
          switch (paramInt)
          {
          }
          break;
        }
      }
      for (;;)
      {
        if (((this.Jbp.get() instanceof com.tencent.mm.plugin.webview.h.a.c)) && (paramBundle != null))
        {
          localObject1 = (com.tencent.mm.plugin.webview.h.a.c)this.Jbp.get();
          localObject2 = paramBundle.getString("action");
          if ("share".equals(localObject2))
          {
            ((com.tencent.mm.plugin.webview.h.a.c)localObject1).X(paramBundle);
            break;
            if (!((String)localObject2).equals("writeComment")) {
              break label5600;
            }
            paramInt = 0;
            break label5600;
            if (!((String)localObject2).equals("showToast")) {
              break label5600;
            }
            paramInt = 1;
            break label5600;
            if (!((String)localObject2).equals("readArticle")) {
              break label5600;
            }
            paramInt = 2;
            break label5600;
            if (!((String)localObject2).equals("writeCommentReply")) {
              break label5600;
            }
            paramInt = 3;
            break label5600;
            ((com.tencent.mm.plugin.webview.h.a.b)localObject1).aT(paramBundle);
            continue;
            ((com.tencent.mm.plugin.webview.h.a.b)localObject1).aV(paramBundle);
            continue;
            ((com.tencent.mm.plugin.webview.h.a.b)localObject1).aS(paramBundle);
            continue;
            ((com.tencent.mm.plugin.webview.h.a.b)localObject1).aW(paramBundle);
            continue;
          }
          if ("switchVideo".equals(localObject2))
          {
            ((com.tencent.mm.plugin.webview.h.a.c)localObject1).Y(paramBundle);
            break;
          }
          if ("createAdWebview".equals(localObject2))
          {
            localBundle.putBoolean("ret", ((com.tencent.mm.plugin.webview.h.a.c)localObject1).Z(paramBundle));
            break;
          }
          if ("closeAdWebview".equals(localObject2))
          {
            ((com.tencent.mm.plugin.webview.h.a.c)localObject1).cpF();
            break;
          }
          if ("getMPVideoState".equals(localObject2))
          {
            localBundle.putAll(((com.tencent.mm.plugin.webview.h.a.c)localObject1).cpH());
            break;
          }
          if ("sendMPPageData".equals(localObject2))
          {
            ((com.tencent.mm.plugin.webview.h.a.c)localObject1).aa(paramBundle);
            break;
          }
          if ("closeDotWebview".equals(localObject2))
          {
            ((com.tencent.mm.plugin.webview.h.a.c)localObject1).ab(paramBundle);
            break;
          }
          if ("hideDotWebview".equals(localObject2))
          {
            ((com.tencent.mm.plugin.webview.h.a.c)localObject1).ac(paramBundle);
            break;
          }
          if ("setDotScriptData".equals(localObject2))
          {
            ((com.tencent.mm.plugin.webview.h.a.c)localObject1).ae(paramBundle);
            break;
          }
          if (!"opPlayer".equals(localObject2)) {
            break;
          }
          ((com.tencent.mm.plugin.webview.h.a.c)localObject1).af(paramBundle);
          break;
        }
      }
      if ((paramBundle == null) || (!"share".equals(paramBundle.getString("action")))) {
        break;
      }
      ((WebViewUI)this.Jbp.get()).X(paramBundle);
      break;
      if ((((WebViewUI)this.Jbp.get()).JhX != null) && (((WebViewUI)this.Jbp.get()).JhX.isShowing())) {
        ((WebViewUI)this.Jbp.get()).JhX.dismiss();
      }
      if (paramBundle == null)
      {
        Log.w("MicroMsg.WebViewStubCallbackAIDLStub", "show dialog, data is null");
        break;
      }
      paramBundle.getString("title", ((WebViewUI)this.Jbp.get()).getString(2131755998));
      localObject1 = paramBundle.getString("message", ((WebViewUI)this.Jbp.get()).getString(2131756029));
      bool1 = paramBundle.getBoolean("cancelable", true);
      ((WebViewUI)this.Jbp.get()).JhX = com.tencent.mm.ui.base.h.a((Context)this.Jbp.get(), (String)localObject1, bool1, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(211106);
          Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "WebViewUITipsDialogCancel");
          try
          {
            paramBundle.putInt("WebViewShare_BinderID", ((WebViewUI)m.a(m.this).get()).fZu());
            ((WebViewUI)m.a(m.this).get()).mHh.j(111, paramBundle);
            AppMethodBeat.o(211106);
            return;
          }
          catch (Exception paramAnonymousDialogInterface)
          {
            Log.e("MicroMsg.WebViewStubCallbackAIDLStub", "hide dialog err %s", new Object[] { paramAnonymousDialogInterface.getMessage() });
            AppMethodBeat.o(211106);
          }
        }
      });
      break;
      if ((((WebViewUI)this.Jbp.get()).JhX == null) || (!((WebViewUI)this.Jbp.get()).JhX.isShowing())) {
        break;
      }
      ((WebViewUI)this.Jbp.get()).JhX.dismiss();
      break;
      Object localObject3 = (WebViewUI)this.Jbp.get();
      if (localObject3 == null)
      {
        Log.e("MicroMsg.WebViewStubCallbackAIDLStub", "AC_ON_FAST_LOAD but null WebViewUI");
        break;
      }
      Object localObject4 = new b.a();
      Intent localIntent = new Intent();
      if (paramBundle.getBoolean("isNativePage"))
      {
        localIntent.putExtras(paramBundle);
        float f = bZk();
        com.tencent.mm.plugin.webview.h.g.a((Context)localObject3, paramBundle.getString("currentInfo"), f, localIntent, ((WebViewUI)localObject3).Jig);
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(1061L, 21L, 1L, false);
      }
      paramInt = paramBundle.getInt("scene");
      i = paramBundle.getInt(com.tencent.mm.ui.e.b.OyR, 10000);
      localObject2 = paramBundle.getString("url");
      localObject1 = localObject2;
      if (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).isMpUrl((String)localObject2))
      {
        j = (int)(System.currentTimeMillis() / 1000L);
        localObject1 = ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).d((String)localObject2, paramInt, i, j);
      }
      if (((WebViewUI)localObject3).getIntent() != null) {
        localIntent.putExtra(e.p.OzI, ((WebViewUI)localObject3).getIntent().getStringExtra(e.p.OzI));
      }
      localObject2 = (com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class);
      j = paramBundle.getInt("item_show_type");
      paramBundle.getBoolean("isNativePage");
      localBundle.putBoolean("success", ((com.tencent.mm.plugin.brandservice.a.b)localObject2).a((Context)localObject3, (String)localObject1, j, paramInt, i, localIntent, paramBundle.getInt("openType"), (b.a)localObject4));
      if ((((b.a)localObject4).success) || (((b.a)localObject4).message == null)) {
        break;
      }
      localBundle.putString("desc", ((b.a)localObject4).message);
      break;
      paramBundle = (WebViewUI)this.Jbp.get();
      if ((paramBundle == null) || (paramBundle.getIntent() == null))
      {
        com.tencent.mm.plugin.s.a.p("WebViewStubCallback activity[%s]", new Object[] { paramBundle });
        paramBundle = Bundle.EMPTY;
        AppMethodBeat.o(80028);
        return paramBundle;
      }
      localObject1 = new Bundle(1);
      ((Bundle)localObject1).putString(e.p.OzI, paramBundle.getIntent().getStringExtra(e.p.OzI));
      com.tencent.mm.plugin.s.a.p("WebViewStubCallback activity[%s] adUxInfo[%s]", new Object[] { paramBundle, ((Bundle)localObject1).getString(e.p.OzI) });
      AppMethodBeat.o(80028);
      return localObject1;
      paramBundle = new Bundle(1);
      paramBundle.putString("ad_info_traceId", l.Jhd.traceid);
      AppMethodBeat.o(80028);
      return paramBundle;
      paramBundle = new Bundle(1);
      localObject1 = (WebViewUI)this.Jbp.get();
      if ((localObject1 == null) || (((WebViewUI)localObject1).getIntent() == null))
      {
        Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "AC_GET_H5_PAY_COOKIE but null WebViewUI");
        break;
      }
      paramBundle.putString("key_h5pay_cookie", getIntent().getStringExtra("key_h5pay_cookie"));
      AppMethodBeat.o(80028);
      return paramBundle;
    }
  }
  
  public final void lA(final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(80032);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(211107);
        if ((m.a(m.this).get() == null) || (((WebViewUI)m.a(m.this).get()).isFinishing()))
        {
          AppMethodBeat.o(211107);
          return;
        }
        if (!Util.isNullOrNil(paramString1))
        {
          if (!Util.isNullOrNil(paramString2)) {
            m.b(m.this).putExtra("view_port_code", paramString2);
          }
          ((WebViewUI)m.a(m.this).get()).loadUrl(paramString1);
        }
        AppMethodBeat.o(211107);
      }
    });
    AppMethodBeat.o(80032);
  }
  
  public final void lz(final String paramString1, String paramString2)
  {
    AppMethodBeat.i(80025);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(79981);
        if ((m.a(m.this).get() == null) || (((WebViewUI)m.a(m.this).get()).isFinishing()))
        {
          AppMethodBeat.o(79981);
          return;
        }
        if (!Util.isNullOrNil(((WebViewUI)m.a(m.this).get()).pGj.getUrl()))
        {
          Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "setPageOwner, userName = " + paramString1);
          ((WebViewUI)m.a(m.this).get()).JiN.put(((WebViewUI)m.a(m.this).get()).pGj.getUrl(), paramString1);
          AppMethodBeat.o(79981);
          return;
        }
        Log.i("MicroMsg.WebViewStubCallbackAIDLStub", "setPageOwner, null url");
        AppMethodBeat.o(79981);
      }
    });
    AppMethodBeat.o(80025);
  }
  
  public final void t(final int paramInt, final Bundle paramBundle)
  {
    AppMethodBeat.i(80024);
    if ((this.Jbp.get() == null) || (((WebViewUI)this.Jbp.get()).isFinishing()))
    {
      AppMethodBeat.o(80024);
      return;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(79980);
        if ((m.a(m.this).get() == null) || (((WebViewUI)m.a(m.this).get()).isFinishing()) || (((WebViewUI)m.a(m.this).get()).pGj == null))
        {
          AppMethodBeat.o(79980);
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
          str = ((WebViewUI)m.a(m.this).get()).pGj.getUrl();
          localObject1 = (SparseBooleanArray)((WebViewUI)m.a(m.this).get()).Jjm.Jgj.get(str);
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
          ((WebViewUI)m.a(m.this).get()).Jjm.Jgj.put(str, localObject1);
          ((WebViewUI)m.a(m.this).get()).Jjm.g(str, m.b(m.this));
        }
        for (;;)
        {
          localObject2 = ((Set)localObject2).iterator();
          int i;
          while (((Iterator)localObject2).hasNext())
          {
            i = Util.nullAs((Integer)((WebViewUI)m.a(m.this).get()).Jjm.Jgk.get(((Iterator)localObject2).next()), -1);
            if (i >= 0) {
              ((SparseBooleanArray)localObject1).put(i, true);
            }
          }
          ((WebViewUI)m.a(m.this).get()).Jjm.ani();
          AppMethodBeat.o(79980);
          return;
          if (localObject1 == null) {
            break;
          }
          localObject2 = ((Set)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            i = Util.nullAs((Integer)((WebViewUI)m.a(m.this).get()).Jjm.Jgk.get(((Iterator)localObject2).next()), -1);
            if (i >= 0) {
              ((SparseBooleanArray)localObject1).delete(i);
            }
          }
          ((WebViewUI)m.a(m.this).get()).Jjm.ani();
          break;
        }
      }
    });
    AppMethodBeat.o(80024);
  }
  
  public final void yL(final boolean paramBoolean)
  {
    AppMethodBeat.i(80017);
    if ((this.Jbp.get() == null) || (((WebViewUI)this.Jbp.get()).isFinishing()))
    {
      AppMethodBeat.o(80017);
      return;
    }
    final boolean bool = ((WebViewUI)this.Jbp.get()).getIntent().getBooleanExtra("forceHideShare", false);
    Log.d("MicroMsg.WebViewStubCallbackAIDLStub", "[cpan] setShareBtnVisible:%d visible:%b  forceHideShare:%b", new Object[] { Long.valueOf(System.currentTimeMillis()), Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(79975);
        if ((m.a(m.this).get() == null) || (((WebViewUI)m.a(m.this).get()).isFinishing()))
        {
          AppMethodBeat.o(79975);
          return;
        }
        if (bool)
        {
          if ((((WebViewUI)m.a(m.this).get()).pGj != null) && (!Util.isNullOrNil(((WebViewUI)m.a(m.this).get()).pGj.getUrl()))) {
            ((WebViewUI)m.a(m.this).get()).JiM.put(((WebViewUI)m.a(m.this).get()).pGj.getUrl(), Boolean.FALSE);
          }
          ((WebViewUI)m.a(m.this).get()).zj(false);
          AppMethodBeat.o(79975);
          return;
        }
        if ((((WebViewUI)m.a(m.this).get()).pGj != null) && (!Util.isNullOrNil(((WebViewUI)m.a(m.this).get()).pGj.getUrl()))) {
          ((WebViewUI)m.a(m.this).get()).JiM.put(((WebViewUI)m.a(m.this).get()).pGj.getUrl(), Boolean.valueOf(paramBoolean));
        }
        ((WebViewUI)m.a(m.this).get()).zj(paramBoolean);
        AppMethodBeat.o(79975);
      }
    });
    AppMethodBeat.o(80017);
  }
  
  public final void yM(final boolean paramBoolean)
  {
    AppMethodBeat.i(80018);
    if ((this.Jbp.get() == null) || (((WebViewUI)this.Jbp.get()).isFinishing()))
    {
      AppMethodBeat.o(80018);
      return;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(79976);
        if ((m.a(m.this).get() == null) || (((WebViewUI)m.a(m.this).get()).isFinishing()))
        {
          AppMethodBeat.o(79976);
          return;
        }
        ((WebViewUI)m.a(m.this).get()).zi(paramBoolean);
        AppMethodBeat.o(79976);
      }
    });
    AppMethodBeat.o(80018);
  }
  
  public final void yN(boolean paramBoolean)
  {
    AppMethodBeat.i(80030);
    if ((this.Jbp.get() == null) || (((WebViewUI)this.Jbp.get()).isFinishing()))
    {
      AppMethodBeat.o(80030);
      return;
    }
    ((WebViewUI)this.Jbp.get()).zl(paramBoolean);
    AppMethodBeat.o(80030);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.m
 * JD-Core Version:    0.7.0.1
 */