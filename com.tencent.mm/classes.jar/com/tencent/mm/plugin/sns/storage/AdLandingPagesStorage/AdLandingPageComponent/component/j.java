package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.ab;
import com.tencent.mm.autogen.a.xz;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.plugin.sns.ad.j.d;
import com.tencent.mm.plugin.sns.ad.landingpage.helper.a.a.a;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aq;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l;
import com.tencent.mm.plugin.webview.ui.tools.widget.f;
import com.tencent.mm.plugin.webview.ui.tools.widget.f.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.g;
import com.tencent.mm.plugin.webview.ui.tools.widget.i.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ad;
import java.io.OutputStream;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class j
  extends n
  implements com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.a.a
{
  IListener<xz> QOo;
  private final String[] QOp;
  private Runnable QOq;
  com.tencent.mm.plugin.sns.data.j.a QOr;
  private volatile boolean mIsDestroyed;
  MMWebView ooz;
  private com.tencent.mm.plugin.webview.jsapi.j sLO;
  w ubo;
  
  public j(Context paramContext, aa paramaa, ViewGroup paramViewGroup)
  {
    super(paramContext, paramaa, paramViewGroup);
    AppMethodBeat.i(307093);
    this.mIsDestroyed = false;
    this.QOp = new String[] { "weixin.qq.com", "wxs.qq.com", "h5.gdt.qq.com", "xj.gdt.qq.com", "test-xj.gdt.qq.com", "bricks.e.qq.com", "test.bricks.e.qq.com" };
    this.QOq = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(176275);
        try
        {
          Object localObject1 = j.this.ooz;
          if ((localObject1 != null) && (((MMWebView)localObject1).isAttachedToWindow()))
          {
            localObject1 = (ViewGroup)((MMWebView)localObject1).getChildAt(0);
            if ((localObject1 != null) && (((ViewGroup)localObject1).getChildCount() > 0))
            {
              ((ViewGroup)localObject1).setPadding(0, 0, 0, 0);
              localObject1 = ((ViewGroup)localObject1).getChildAt(0);
              if (localObject1 != null) {
                ((View)localObject1).requestLayout();
              }
            }
          }
          AppMethodBeat.o(176275);
          return;
        }
        finally
        {
          Log.w("AdLandingNewH5Comp", "there is something in wevView fix!");
          AppMethodBeat.o(176275);
        }
      }
    };
    this.ubo = null;
    this.QOr = new com.tencent.mm.plugin.sns.data.j.a()
    {
      public final void a(String paramAnonymousString1, boolean paramAnonymousBoolean, String paramAnonymousString2, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(306930);
        j.a(j.this);
        String str = "";
        if (paramAnonymousBundle != null) {}
        for (paramAnonymousBundle = paramAnonymousBundle.getString("jsCallbackId", "");; paramAnonymousBundle = str)
        {
          Log.i("AdLandingNewH5Comp", "qr onFinish, isSucc=" + paramAnonymousBoolean + ", errMsg=" + paramAnonymousString2 + ", url=" + paramAnonymousString1 + ", jsCallbackId=" + paramAnonymousBundle);
          j.this.db(paramAnonymousBundle, paramAnonymousBoolean);
          AppMethodBeat.o(306930);
          return;
          Log.e("AdLandingNewH5Comp", "qr onFinish, extParams==null");
        }
      }
    };
    AppMethodBeat.o(307093);
  }
  
  private boolean aZv(String paramString)
  {
    AppMethodBeat.i(307104);
    int i = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yIn, 1);
    Log.d("AdLandingNewH5Comp", "checkDeviceInfoUrlPermission::expt value is ".concat(String.valueOf(i)));
    if (i == 0)
    {
      AppMethodBeat.o(307104);
      return false;
    }
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(307104);
      return false;
    }
    paramString = Uri.parse(paramString).getHost();
    if ((paramString != null) && (d.z(this.QOp)))
    {
      String[] arrayOfString = this.QOp;
      int j = arrayOfString.length;
      i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        if ((str != null) && (paramString.contains(str)))
        {
          AppMethodBeat.o(307104);
          return true;
        }
        i += 1;
      }
    }
    Log.d("AdLandingNewH5Comp", "checkDeviceInfoUrlPermission::the domain is ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(307104);
    return false;
  }
  
  private static Method cb(Class<?> paramClass)
  {
    AppMethodBeat.i(307108);
    try
    {
      paramClass = paramClass.getMethod("getJsapi", new Class[0]);
      AppMethodBeat.o(307108);
      return paramClass;
    }
    finally
    {
      Log.e("AdLandingNewH5Comp", "there is no method named getJsapi");
      AppMethodBeat.o(307108);
    }
    return null;
  }
  
  private static Method cc(Class<?> paramClass)
  {
    AppMethodBeat.i(307113);
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = localObject3;
    for (;;)
    {
      try
      {
        Method[] arrayOfMethod = paramClass.getDeclaredMethods();
        localObject1 = localObject3;
        int j = arrayOfMethod.length;
        i = 0;
        paramClass = localObject2;
        if (i < j)
        {
          paramClass = arrayOfMethod[i];
          localObject1 = localObject3;
          Class localClass = paramClass.getReturnType();
          localObject1 = localObject3;
          Class[] arrayOfClass = paramClass.getParameterTypes();
          if (localClass != com.tencent.mm.plugin.webview.jsapi.j.class) {
            continue;
          }
          localObject1 = localObject3;
          if (!d.y(arrayOfClass)) {
            continue;
          }
        }
        localObject1 = paramClass;
        if (paramClass == null)
        {
          localObject1 = paramClass;
          Log.w("AdLandingNewH5Comp", "there is no method satisfying the condition");
          localObject1 = paramClass;
        }
      }
      finally
      {
        int i;
        Log.e("AdLandingNewH5Comp", "finding the js method occurs something exception");
        continue;
      }
      AppMethodBeat.o(307113);
      return localObject1;
      i += 1;
    }
  }
  
  private void hiX()
  {
    AppMethodBeat.i(307119);
    if ((this.sLO == null) && (!this.mIsDestroyed)) {}
    for (;;)
    {
      try
      {
        localObject1 = (ab)com.tencent.mm.kernel.h.ax(ab.class);
        if (localObject1 == null) {
          break label242;
        }
        localObject1 = ((ab)localObject1).b(this.ooz);
        if (localObject1 == null) {
          continue;
        }
        Log.d("AdLandingNewH5Comp", "the jsApiHandler is set from service");
        this.sLO = ((com.tencent.mm.plugin.webview.jsapi.j)localObject1);
      }
      finally
      {
        try
        {
          long l = SystemClock.currentThreadTimeMillis();
          Class localClass = this.ooz.getClass();
          Method localMethod = cb(localClass);
          Object localObject1 = localMethod;
          if (localMethod != null) {
            continue;
          }
          Log.i("AdLandingNewH5Comp", "the js method is not found in getJsapiMethod, try to findJsapiMethod");
          localObject1 = cc(localClass);
          if (localObject1 != null) {
            continue;
          }
          Log.w("AdLandingNewH5Comp", "the js method is not found!");
          AppMethodBeat.o(307119);
          return;
          Log.w("AdLandingNewH5Comp", "the jsApiHandler is null from service!");
          continue;
          localObject2 = finally;
          Log.e("AdLandingNewH5Comp", "ensureJsApiHandlerFromService has something wrong!!");
          continue;
          Object localObject3 = localObject2.invoke(this.ooz, new Object[0]);
          if (!(localObject3 instanceof com.tencent.mm.plugin.webview.jsapi.j)) {
            continue;
          }
          Log.i("AdLandingNewH5Comp", "the method return type is js api in ensureJsApiHandlerFromWebView");
          this.sLO = ((com.tencent.mm.plugin.webview.jsapi.j)localObject3);
          Log.i("AdLandingNewH5Comp", "get the js api handler takes : " + (SystemClock.currentThreadTimeMillis() - l));
          AppMethodBeat.o(307119);
          return;
          Log.w("AdLandingNewH5Comp", "the method return value is null ??");
          continue;
          AppMethodBeat.o(307119);
        }
        finally
        {
          Log.e("AdLandingNewH5Comp", "there is no getJsApiHandler method, the jsApiHandler object may be null!!");
        }
      }
      if (this.sLO == null) {}
      return;
      label242:
      Object localObject5 = null;
    }
  }
  
  private void m(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(307099);
    HashMap localHashMap = new HashMap();
    localHashMap.put("ret", Integer.valueOf(paramInt));
    localHashMap.put("device_id", Util.nullAsNil(paramString3));
    g(paramString1, paramString2, localHashMap);
    AppMethodBeat.o(307099);
  }
  
  final void db(final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(307172);
    Log.i("AdLandingNewH5Comp", "callbackQRResultToJS, isSucc=" + paramBoolean + ", callbackId=" + paramString);
    com.tencent.threadpool.h.ahAA.bk(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(307233);
        try
        {
          HashMap localHashMap = new HashMap();
          int i;
          j localj;
          String str2;
          if (paramBoolean)
          {
            i = 1;
            localHashMap.put("ret", Integer.valueOf(i));
            localj = j.this;
            str2 = paramString;
            if (!paramBoolean) {
              break label77;
            }
          }
          label77:
          for (String str1 = "ok";; str1 = "fail")
          {
            localj.g(str2, str1, localHashMap);
            AppMethodBeat.o(307233);
            return;
            i = 2;
            break;
          }
          return;
        }
        finally
        {
          Log.e("AdLandingNewH5Comp", "callbackQRResultToJS exp=" + localObject.toString());
          AppMethodBeat.o(307233);
        }
      }
    });
    AppMethodBeat.o(307172);
  }
  
  final void g(String paramString1, String paramString2, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(307176);
    hiX();
    com.tencent.mm.plugin.webview.jsapi.j localj = this.sLO;
    if (localj != null)
    {
      Log.d("AdLandingNewH5Comp", "the js api handler is called!!");
      localj.a(paramString1, paramString2, paramMap, true);
      AppMethodBeat.o(307176);
      return;
    }
    Log.w("AdLandingNewH5Comp", "the js api handler is null!!");
    AppMethodBeat.o(307176);
  }
  
  public final void h(String paramString1, String paramString2, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(307179);
    g(paramString1, paramString2, paramMap);
    AppMethodBeat.o(307179);
  }
  
  /* Error */
  protected final void had()
  {
    // Byte code:
    //   0: ldc_w 351
    //   3: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokevirtual 355	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/j:hjm	()Ljava/lang/Object;
    //   10: checkcast 357	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aq
    //   13: ifnull +155 -> 168
    //   16: aload_0
    //   17: invokevirtual 361	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/j:getView	()Landroid/view/View;
    //   20: checkcast 363	com/tencent/xweb/WebView
    //   23: astore_2
    //   24: aload_0
    //   25: invokevirtual 355	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/j:hjm	()Ljava/lang/Object;
    //   28: checkcast 357	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aq
    //   31: astore_3
    //   32: aload_3
    //   33: getfield 367	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aq:url	Ljava/lang/String;
    //   36: invokestatic 155	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   39: ifne +165 -> 204
    //   42: invokestatic 373	com/tencent/mm/plugin/sns/model/AdLandingPagesProxy:getInstance	()Lcom/tencent/mm/plugin/sns/model/AdLandingPagesProxy;
    //   45: invokevirtual 376	com/tencent/mm/plugin/sns/model/AdLandingPagesProxy:getUin	()Ljava/lang/String;
    //   48: astore 4
    //   50: ldc_w 378
    //   53: aload 4
    //   55: invokestatic 179	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   58: invokevirtual 143	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   61: astore_1
    //   62: aload_3
    //   63: getfield 367	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aq:url	Ljava/lang/String;
    //   66: iconst_1
    //   67: anewarray 67	java/lang/String
    //   70: dup
    //   71: iconst_0
    //   72: aload_1
    //   73: aastore
    //   74: invokestatic 384	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ar:n	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   77: aload_0
    //   78: invokevirtual 388	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/j:hjn	()Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ai;
    //   81: getfield 393	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ai:uxInfo	Ljava/lang/String;
    //   84: invokestatic 399	com/tencent/mm/plugin/sns/data/t:lY	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   87: astore_1
    //   88: aload_3
    //   89: getfield 403	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aq:subType	I
    //   92: iconst_1
    //   93: if_icmpne +135 -> 228
    //   96: invokestatic 373	com/tencent/mm/plugin/sns/model/AdLandingPagesProxy:getInstance	()Lcom/tencent/mm/plugin/sns/model/AdLandingPagesProxy;
    //   99: aload_3
    //   100: getfield 367	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aq:url	Ljava/lang/String;
    //   103: aload_0
    //   104: invokevirtual 388	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/j:hjn	()Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ai;
    //   107: getfield 393	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ai:uxInfo	Ljava/lang/String;
    //   110: aload 4
    //   112: invokevirtual 407	com/tencent/mm/plugin/sns/model/AdLandingPagesProxy:getAdVoteInfo	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   115: astore_3
    //   116: aload_3
    //   117: invokestatic 410	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   120: ifne +108 -> 228
    //   123: new 273	java/lang/StringBuilder
    //   126: dup
    //   127: invokespecial 411	java/lang/StringBuilder:<init>	()V
    //   130: aload_1
    //   131: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: ldc_w 413
    //   137: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: aload_3
    //   141: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: astore_1
    //   148: ldc 133
    //   150: ldc_w 415
    //   153: aload_1
    //   154: invokestatic 179	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   157: invokevirtual 143	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   160: invokestatic 257	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   163: aload_2
    //   164: aload_1
    //   165: invokevirtual 418	com/tencent/xweb/WebView:loadUrl	(Ljava/lang/String;)V
    //   168: aload_0
    //   169: getfield 420	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/j:QOo	Lcom/tencent/mm/sdk/event/IListener;
    //   172: ifnonnull +25 -> 197
    //   175: aload_0
    //   176: new 8	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingNewH5Comp$10
    //   179: dup
    //   180: aload_0
    //   181: getstatic 426	com/tencent/mm/app/f:hfK	Lcom/tencent/mm/app/f;
    //   184: invokespecial 429	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingNewH5Comp$10:<init>	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/j;Landroidx/lifecycle/q;)V
    //   187: putfield 420	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/j:QOo	Lcom/tencent/mm/sdk/event/IListener;
    //   190: aload_0
    //   191: getfield 420	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/j:QOo	Lcom/tencent/mm/sdk/event/IListener;
    //   194: invokevirtual 434	com/tencent/mm/sdk/event/IListener:alive	()V
    //   197: ldc_w 351
    //   200: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   203: return
    //   204: ldc 133
    //   206: ldc_w 436
    //   209: invokestatic 195	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   212: aload_3
    //   213: getfield 367	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aq:url	Ljava/lang/String;
    //   216: astore_1
    //   217: goto -54 -> 163
    //   220: astore_1
    //   221: ldc_w 351
    //   224: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   227: return
    //   228: goto -80 -> 148
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	231	0	this	j
    //   61	156	1	str1	String
    //   220	1	1	localObject1	Object
    //   23	141	2	localWebView	WebView
    //   31	182	3	localObject2	Object
    //   48	63	4	str2	String
    // Exception table:
    //   from	to	target	type
    //   168	197	220	finally
  }
  
  protected final void hal()
  {
    AppMethodBeat.i(96463);
    ViewGroup.LayoutParams localLayoutParams = this.contentView.getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      ((ViewGroup.MarginLayoutParams)localLayoutParams).setMargins((int)this.QOV.paddingLeft, (int)this.QOV.paddingTop, (int)this.QOV.paddingRight, (int)this.QOV.paddingBottom);
    }
    this.contentView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(96463);
  }
  
  protected final View ham()
  {
    AppMethodBeat.i(96464);
    this.mIsDestroyed = false;
    this.ooz = i.a.Xpw.fJ(this.context);
    this.ooz.setCleanOnDetached(false);
    this.ooz.getSettings().kfP();
    this.ooz.getSettings().kfT();
    this.ooz.getSettings().kfS();
    this.ooz.setWebViewClient(f.a.Xpv.a(this.ooz, false, new g()
    {
      public final boolean i(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(96461);
        Log.i("AdLandingNewH5Comp", "callback, actionCode=".concat(String.valueOf(paramAnonymousInt)));
        switch (paramAnonymousInt)
        {
        default: 
        case 150: 
          for (;;)
          {
            AppMethodBeat.o(96461);
            return false;
            localObject = (aq)j.this.hjm();
            paramAnonymousInt = paramAnonymousBundle.getInt("sns_landing_pages_ad_vote_index");
            paramAnonymousBundle = paramAnonymousBundle.getString("sns_landing_pages_ad_vote_result");
            AdLandingPagesProxy.getInstance().saveAdVoteInfo(((aq)localObject).url, j.this.hjn().uxInfo, j.this.hjn().uin, paramAnonymousInt, 0, paramAnonymousBundle);
          }
        case 151: 
          for (;;)
          {
            try
            {
              localObject = new Intent();
              String str = ar.n(paramAnonymousBundle.getString("sns_landing_pages_ad_jumpurl"), new String[] { "traceid=" + j.this.hjn().qTb, "aid=" + j.this.hjn().aid });
              paramAnonymousBundle = j.this.hjn().hiC();
              if (!TextUtils.isEmpty(paramAnonymousBundle)) {
                break label356;
              }
              paramAnonymousBundle = j.this.hjn().uxInfo;
              Log.i("AdLandingNewH5Comp", "opJumpView, use orig_UxInfo:".concat(String.valueOf(paramAnonymousBundle)));
              str = t.lY(str, paramAnonymousBundle);
              t.i((Intent)localObject, paramAnonymousBundle);
              ((Intent)localObject).putExtra("rawUrl", str);
              ((Intent)localObject).putExtra("useJs", true);
              ((Intent)localObject).putExtra("type", -255);
              ((Intent)localObject).putExtra("geta8key_scene", 2);
              com.tencent.mm.br.c.b(j.this.context, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
              Log.i("AdLandingNewH5Comp", "jumpUrl, finalUrl=".concat(String.valueOf(str)));
            }
            catch (Exception paramAnonymousBundle)
            {
              Log.e("AdLandingNewH5Comp", "OptJump exp=" + paramAnonymousBundle.toString());
            }
            break;
            label356:
            Log.i("AdLandingNewH5Comp", "opJumpView, use updated_UxInfo:".concat(String.valueOf(paramAnonymousBundle)));
          }
        }
        Object localObject = paramAnonymousBundle.getString("sns_landing_pages_h5_params");
        paramAnonymousBundle = paramAnonymousBundle.getString("callbackId");
        boolean bool = j.this.mu((String)localObject, paramAnonymousBundle);
        AppMethodBeat.o(96461);
        return bool;
      }
    }));
    MMWebView localMMWebView = this.ooz;
    AppMethodBeat.o(96464);
    return localMMWebView;
  }
  
  public final void hao()
  {
    AppMethodBeat.i(307149);
    super.hao();
    try
    {
      MMWebView localMMWebView = this.ooz;
      if (localMMWebView != null) {
        localMMWebView.postOnAnimation(this.QOq);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(307149);
    }
  }
  
  public final void has()
  {
    AppMethodBeat.i(96465);
    super.has();
    WebView localWebView = (WebView)getView();
    if ((localWebView != null) && (localWebView.getParent() != null))
    {
      ((ViewGroup)localWebView.getParent()).removeView(localWebView);
      localWebView.setTag(null);
      localWebView.destroy();
    }
    this.mIsDestroyed = true;
    this.sLO = null;
    this.contentView = null;
    AppMethodBeat.o(96465);
  }
  
  final boolean mu(final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(307164);
    Object localObject2;
    try
    {
      Log.i("AdLandingNewH5Comp", "handleJSAPI, params=".concat(String.valueOf(paramString1)));
      localObject2 = new JSONObject(paramString1);
      paramString1 = ((JSONObject)localObject2).optString("funcName");
      if ("opUpdateContentHeight".equals(paramString1)) {
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(307243);
            if ((j.this.contentView != null) && (this.QOt >= 0)) {
              try
              {
                ViewGroup.LayoutParams localLayoutParams = j.this.contentView.getLayoutParams();
                int i = (int)l.a(this.QOt, 1, 750, 1);
                Log.i("AdLandingNewH5Comp", "adJuestHeight, curH=" + localLayoutParams.height + ", newH=" + this.QOt + ", newPx=" + i);
                if (localLayoutParams.height != i)
                {
                  ((aq)j.this.hjm()).QKJ = i;
                  j.this.haC();
                }
                AppMethodBeat.o(307243);
                return;
              }
              catch (Exception localException)
              {
                Log.e("AdLandingNewH5Comp", "adJuestHeight exp=" + localException.toString());
              }
            }
            AppMethodBeat.o(307243);
          }
        });
      }
      for (;;)
      {
        AppMethodBeat.o(307164);
        return false;
        if (!"opStartQRScan".equals(paramString1)) {
          break;
        }
        ((JSONObject)localObject2).getString("scanUrl");
      }
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        Log.e("AdLandingNewH5Comp", "handleJSAPI, exp=" + paramString1.toString());
      }
    }
    Object localObject1;
    int j;
    int i;
    if ("opEndQRScan".equals(paramString1))
    {
      localObject1 = ((JSONObject)localObject2).getString("scanUrl");
      j = ((JSONObject)localObject2).optInt("directJump");
      i = ((JSONObject)localObject2).optInt("syncQrImageDownload");
    }
    for (;;)
    {
      final boolean bool1;
      try
      {
        Log.i("AdLandingNewH5Comp", "handleQR, qrDirectJump=" + j + ", syncQrImageDownload=" + i + ", jsCallbackId=" + paramString2 + ", url=" + (String)localObject1);
        if (j != 1) {
          continue;
        }
        bool1 = true;
      }
      finally
      {
        Log.e("AdLandingNewH5Comp", "handleQR, exp=" + paramString1.toString());
        continue;
        hjm();
        if (i == 0) {
          continue;
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          continue;
        }
        Log.e("AdLandingNewH5Comp", "imageUrl is empty");
        db(paramString2, false);
        continue;
        com.tencent.threadpool.h.ahAA.bk(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(306947);
            if ((j.this.ubo == null) && ((j.this.context instanceof Activity)) && (!((Activity)j.this.context).isFinishing())) {
              j.this.ubo = com.tencent.mm.plugin.sns.ad.landingpage.a.a.aU(j.this.context, b.j.sns_ad_loading);
            }
            if ((j.this.ubo != null) && (!j.this.ubo.isShowing()))
            {
              Log.i("AdLandingNewH5Comp", "showLoading");
              j.this.ubo.show();
            }
            AppMethodBeat.o(306947);
          }
        });
        k.b("adId", (String)localObject1, new g.a()
        {
          public final void aWn(String paramAnonymousString)
          {
            AppMethodBeat.i(307248);
            Log.i("AdLandingNewH5Comp", "onDownloaded succ, imageUrl=" + this.PUd);
            try
            {
              paramAnonymousString = k.mC("adId", this.PUd);
              if ((!TextUtils.isEmpty(paramAnonymousString)) && (y.ZC(paramAnonymousString)))
              {
                Log.i("AdLandingNewH5Comp", "onDownloaded, local file exists, imageUrl=" + this.PUd);
                if (bool1)
                {
                  paramString1.b(paramAnonymousString, this.PUd, j.this.QOr);
                  AppMethodBeat.o(307248);
                  return;
                }
                paramString1.a(paramAnonymousString, this.PUd, j.this.QOr);
                AppMethodBeat.o(307248);
                return;
              }
            }
            finally
            {
              Log.e("AdLandingNewH5Comp", "onDownloaded exp=" + paramAnonymousString.toString());
              j.a(j.this);
              j.this.db(paramString2, false);
              AppMethodBeat.o(307248);
              return;
            }
            j.a(j.this);
            j.this.db(paramString2, false);
            AppMethodBeat.o(307248);
          }
          
          public final void gZM() {}
          
          public final void gZN()
          {
            AppMethodBeat.i(307245);
            Log.e("AdLandingNewH5Comp", "onDownloadError, imageUrl=" + this.PUd);
            j.a(j.this);
            j.this.db(paramString2, false);
            AppMethodBeat.o(307245);
          }
        });
        continue;
        localObject2 = BitmapUtil.getBitmapFromView(this.contentView);
        if (localObject2 == null) {
          break label687;
        }
      }
      localObject2 = new Bundle();
      paramString1 = (aq)hjm();
      if (paramString1 != null)
      {
        paramString1 = paramString1.QKl;
        ((Bundle)localObject2).putString("qrExtInfo", paramString1);
        ((Bundle)localObject2).putInt("qrIsDirectJump", j);
        ((Bundle)localObject2).putString("jsCallbackId", paramString2);
        paramString1 = new com.tencent.mm.plugin.sns.data.j(this.context, hjn(), 2, (Bundle)localObject2);
        localObject2 = k.mC("adId", (String)localObject1);
        if ((TextUtils.isEmpty((CharSequence)localObject2)) || (!y.ZC((String)localObject2))) {
          continue;
        }
        Log.i("AdLandingNewH5Comp", "local file exists, imageUrl=".concat(String.valueOf(localObject1)));
        if (bool1)
        {
          paramString1.b((String)localObject2, (String)localObject1, this.QOr);
          AppMethodBeat.o(307164);
          return true;
          bool1 = false;
          break label1451;
          i = 0;
        }
      }
      else
      {
        paramString1 = "";
        continue;
      }
      paramString1.a((String)localObject2, (String)localObject1, this.QOr);
      continue;
      Log.i("AdLandingNewH5Comp", "shoot webView succ");
      Object localObject3 = k.mC("adId", (String)localObject1 + "_shoot");
      Object localObject4 = y.ap(new u((String)localObject3));
      boolean bool2 = ((Bitmap)localObject2).compress(Bitmap.CompressFormat.JPEG, 100, (OutputStream)localObject4);
      ((OutputStream)localObject4).flush();
      ((OutputStream)localObject4).close();
      if (bool2)
      {
        Log.i("AdLandingNewH5Comp", "shoot save succ");
        if (bool1) {
          paramString1.b((String)localObject3, (String)localObject1, this.QOr);
        }
      }
      for (;;)
      {
        k.b("adId", (String)localObject1, new g.a()
        {
          public final void aWn(String paramAnonymousString)
          {
            AppMethodBeat.i(307239);
            Log.i("AdLandingNewH5Comp", "onDownloaded, imageUrl=" + this.PUd);
            AppMethodBeat.o(307239);
          }
          
          public final void gZM() {}
          
          public final void gZN()
          {
            AppMethodBeat.i(307236);
            Log.e("AdLandingNewH5Comp", "onDownloadError, imageUrl=" + this.PUd);
            AppMethodBeat.o(307236);
          }
        });
        break;
        paramString1.a((String)localObject3, (String)localObject1, this.QOr);
        continue;
        Log.e("AdLandingNewH5Comp", "compressBitmap failed");
        db(paramString2, false);
        continue;
        label687:
        Log.e("AdLandingNewH5Comp", "getBitmapFromView==null");
        db(paramString2, false);
      }
      if ("opGetLocation".equals(paramString1))
      {
        paramString1 = ((JSONObject)localObject2).optString("type");
        paramString2 = com.tencent.mm.plugin.sns.ad.landingpage.helper.a.a.a(this.context, new a(paramString2, this));
        if (paramString2 != null) {
          paramString2.request(paramString1);
        }
        AppMethodBeat.o(307164);
        return true;
      }
      if ("opGetDeviceInfo".equals(paramString1))
      {
        if (!aZv(this.ooz.getUrl())) {
          m(paramString2, -2, "url permission denied", "");
        }
        for (;;)
        {
          AppMethodBeat.o(307164);
          return true;
          if (!com.tencent.mm.pluginsdk.permission.b.g(this.context, new String[] { "android.permission.READ_PHONE_STATE" }))
          {
            m(paramString2, -3, "system permission denied", "");
          }
          else
          {
            paramString1 = q.eD(false);
            if (TextUtils.isEmpty(paramString1)) {
              m(paramString2, -1, "id is empty", "");
            } else {
              m(paramString2, 0, "ok", MD5Util.getMD5String(paramString1));
            }
          }
        }
      }
      if ("requestBindPhoneNumber".equals(paramString1))
      {
        paramString1 = AdLandingPagesProxy.getInstance().getPhoneNumber();
        localObject1 = ((JSONObject)localObject2).optString("requestName");
        localObject2 = ((JSONObject)localObject2).optString("requestIconUrl");
        localObject3 = new StringBuilder("handleBindPhoneNumber, phone.len=");
        if (paramString1 == null) {}
        for (i = 0;; i = paramString1.length())
        {
          Log.i("AdLandingNewH5Comp", i + ", name=" + (String)localObject1 + ", iconUrl=" + (String)localObject2);
          if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject2))) {
            break;
          }
          paramString1 = new HashMap();
          paramString1.put("ret", "-3");
          paramString1.put("err_msg", "params error");
          g(paramString2, "params error", paramString1);
          Log.i("AdLandingNewH5Comp", "handleBindPhoneNumber, params error");
          AppMethodBeat.o(307164);
          return true;
        }
        localObject3 = new com.tencent.mm.ui.widget.a.j(this.context, 0, 0, false);
        ((com.tencent.mm.ui.widget.a.j)localObject3).rootView.setBackgroundColor(this.context.getResources().getColor(b.c.white));
        localObject4 = View.inflate(this.context, b.g.sns_ad_get_bind_phone, null);
        ImageView localImageView = (ImageView)((View)localObject4).findViewById(b.f.request_icon);
        TextView localTextView1 = (TextView)((View)localObject4).findViewById(b.f.request_name);
        TextView localTextView2 = (TextView)((View)localObject4).findViewById(b.f.phone_number_manager_dialog_item_phone);
        View localView4 = ((View)localObject4).findViewById(b.f.phone_number_manager_dialog_item_remark);
        View localView5 = ((View)localObject4).findViewById(b.f.button_group);
        View localView1 = ((View)localObject4).findViewById(b.f.button_i_known);
        View localView2 = ((View)localObject4).findViewById(b.f.request_cancel);
        View localView3 = ((View)localObject4).findViewById(b.f.request_ok);
        if (TextUtils.isEmpty(paramString1))
        {
          localTextView2.setVisibility(0);
          localView4.setVisibility(8);
          localView5.setVisibility(8);
          localView1.setVisibility(0);
          localTextView2.setTextColor(this.context.getResources().getColor(b.c.hint_text_color));
          localTextView2.setText(this.context.getText(b.j.sns_ad_not_bind_phone_number));
        }
        for (;;)
        {
          localTextView1.setText(Util.nullAsNil((String)localObject1));
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject1 = new com.tencent.mm.modelimage.loader.a.c.a();
            ((com.tencent.mm.modelimage.loader.a.c.a)localObject1).oKo = true;
            ((com.tencent.mm.modelimage.loader.a.c.a)localObject1).oKB = b.i.default_avatar_round;
            ((com.tencent.mm.modelimage.loader.a.c.a)localObject1).nrc = true;
            com.tencent.mm.modelimage.loader.a.bKl().a((String)localObject2, localImageView, ((com.tencent.mm.modelimage.loader.a.c.a)localObject1).bKx());
          }
          localView2.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(307228);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.cH(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingNewH5Comp$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
              this.xpj.cyW();
              paramAnonymousView = new HashMap();
              paramAnonymousView.put("ret", "0");
              paramAnonymousView.put("err_msg", "cancel");
              j.this.g(paramString2, "cancel", paramAnonymousView);
              Log.i("AdLandingNewH5Comp", "handleBindPhoneNumber, cancel");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingNewH5Comp$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(307228);
            }
          });
          localView3.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(307225);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.cH(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingNewH5Comp$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
              this.xpj.cyW();
              paramAnonymousView = new HashMap();
              paramAnonymousView.put("ret", "0");
              paramAnonymousView.put("err_msg", "ok");
              paramAnonymousView.put("phoneNumber", paramString1);
              j.this.g(paramString2, "ok", paramAnonymousView);
              Log.i("AdLandingNewH5Comp", "handleBindPhoneNumber, ok");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingNewH5Comp$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(307225);
            }
          });
          localView1.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(307221);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.cH(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingNewH5Comp$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
              this.xpj.cyW();
              paramAnonymousView = new HashMap();
              paramAnonymousView.put("ret", "0");
              paramAnonymousView.put("err_msg", "fail not bind phone");
              j.this.g(paramString2, "fail not bind phone", paramAnonymousView);
              Log.i("AdLandingNewH5Comp", "handleBindPhoneNumber, not bind phone");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingNewH5Comp$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(307221);
            }
          });
          ((com.tencent.mm.ui.widget.a.j)localObject3).setCustomView((View)localObject4);
          ((com.tencent.mm.ui.widget.a.j)localObject3).dDn();
          break;
          localTextView2.setVisibility(0);
          localView4.setVisibility(0);
          localView5.setVisibility(0);
          localView1.setVisibility(8);
          localTextView2.setText(paramString1);
        }
      }
      if (!"openWheelPicker".equals(paramString1)) {
        break;
      }
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.a.a.b.a(this.context, paramString2, (JSONObject)localObject2, this);
      AppMethodBeat.o(307164);
      return true;
      label1451:
      if (i == 1) {
        i = 1;
      }
    }
  }
  
  static final class a
    implements a.a
  {
    private String QOy;
    private Reference<j> QOz;
    
    a(String paramString, j paramj)
    {
      AppMethodBeat.i(307031);
      this.QOy = paramString;
      this.QOz = new WeakReference(paramj);
      AppMethodBeat.o(307031);
    }
    
    public final void aS(Map<String, Object> paramMap)
    {
      AppMethodBeat.i(307038);
      try
      {
        Log.i("AdLandingNewH5Comp", "onGeoCallback is called!");
        String str = this.QOy;
        j localj = (j)this.QOz.get();
        if ((str != null) && (localj != null)) {
          localj.g(str, "GEO", paramMap);
        }
        AppMethodBeat.o(307038);
        return;
      }
      finally
      {
        Log.e("AdLandingNewH5Comp", "there is a exception in onGeoCallback");
        AppMethodBeat.o(307038);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.j
 * JD-Core Version:    0.7.0.1
 */