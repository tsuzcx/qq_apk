package com.tencent.xweb;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebBackForwardList;
import android.webkit.WebView.FindListener;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.internal.CookieInternal.ICookieManagerInternal;
import com.tencent.xweb.internal.CookieInternal.ICookieSyncManagerInternal;
import com.tencent.xweb.internal.IWebView;
import com.tencent.xweb.internal.IWebView.a;
import com.tencent.xweb.internal.WebViewWrapperFactory;
import com.tencent.xweb.internal.WebViewWrapperFactory.IWebViewProvider;
import com.tencent.xweb.internal.g;
import com.tencent.xweb.internal.h;
import com.tencent.xweb.internal.i;
import com.tencent.xweb.util.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWebCoreInfo;

public class WebView
  extends FrameLayout
  implements IWebView
{
  private static com.tencent.xweb.b.f aifA;
  private static WebViewKind aifq;
  private static String aifr;
  private static boolean aifs;
  private static com.tencent.xweb.x5.a.c aift;
  private static boolean aifu;
  private View.OnLongClickListener afTp;
  private int aifB;
  public boolean aifv;
  private IWebView aifw;
  private WebViewKind aifx;
  private com.tencent.xweb.internal.e aify;
  private com.tencent.xweb.b.e aifz;
  
  static
  {
    AppMethodBeat.i(156917);
    XWalkEnvironment.initInterface();
    aifq = WebViewKind.aifH;
    aifr = "";
    aifs = false;
    aifu = false;
    aifA = new com.tencent.xweb.b.f();
    AppMethodBeat.o(156917);
  }
  
  public WebView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public WebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public WebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, WebViewKind.aifH);
  }
  
  public WebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt, WebViewKind paramWebViewKind)
  {
    super((Context)localObject, paramAttributeSet, paramInt);
    AppMethodBeat.i(156815);
    this.aifv = false;
    this.aifx = WebViewKind.aifH;
    this.aifB = -1;
    this.aifz = new com.tencent.xweb.b.e();
    this.aifz.ailC = System.currentTimeMillis();
    b(paramWebViewKind);
    paramAttributeSet = this.aifz;
    paramAttributeSet.ailD = System.currentTimeMillis();
    paramAttributeSet.vSl = (paramAttributeSet.ailD - paramAttributeSet.ailC);
    paramAttributeSet.ailE = 1;
    if (!com.tencent.xweb.b.e.aily)
    {
      com.tencent.xweb.b.e.aily = true;
      paramAttributeSet.ailB = true;
    }
    org.xwalk.core.Log.i("KVReportForWebView", "finishCreateWebView, isFirstCreatedWebView:" + paramAttributeSet.ailB);
    paramWebViewKind = new StringBuilder().append(ao.kge()).append(",").append(XWalkEnvironment.getInstalledNewstVersionForCurAbi()).append(",");
    if (paramAttributeSet.ailz)
    {
      paramContext = "1";
      paramWebViewKind = paramWebViewKind.append(paramContext).append(",");
      if (!paramAttributeSet.ailA) {
        break label552;
      }
      paramContext = "1";
      label216:
      paramWebViewKind = paramWebViewKind.append(paramContext).append(",").append(paramAttributeSet.aiiT).append(",").append(paramAttributeSet.ailC).append(",").append(paramAttributeSet.ailD).append(",").append(paramAttributeSet.vSl).append(",").append(paramAttributeSet.ailE).append(",").append(paramAttributeSet.ailF).append(",").append(paramAttributeSet.ailG).append(",").append(paramAttributeSet.ailH).append(",").append(paramAttributeSet.ailI).append(",").append(paramAttributeSet.ailJ).append(",").append(paramAttributeSet.ailK).append(",").append(paramAttributeSet.ailL).append(",").append(paramAttributeSet.ailM).append(",").append(paramAttributeSet.ailN).append(",").append(paramAttributeSet.ailO).append(",").append(paramAttributeSet.ailP).append(",").append(paramAttributeSet.ailQ).append(",").append(paramAttributeSet.ailR).append(",").append(paramAttributeSet.ailS).append(",").append(paramAttributeSet.ailT).append(",");
      if (!paramAttributeSet.ailB) {
        break label559;
      }
    }
    label552:
    label559:
    for (paramContext = "1";; paramContext = "0")
    {
      paramContext = paramContext;
      org.xwalk.core.Log.i("KVReportForWebView", "report:".concat(String.valueOf(paramContext)));
      com.tencent.xweb.util.l.ev(24340, paramContext);
      org.xwalk.core.Log.w("WebView", "###### create webview costTime:" + this.aifz.vSl);
      AppMethodBeat.o(156815);
      return;
      paramContext = "0";
      break;
      paramContext = "0";
      break label216;
    }
  }
  
  private static boolean a(Context paramContext, WebViewKind paramWebViewKind)
  {
    AppMethodBeat.i(212423);
    XWalkEnvironment.addXWalkInitializeLog("WebView", "tryInitWebViewCore start, type:".concat(String.valueOf(paramWebViewKind)));
    if ((paramWebViewKind == WebViewKind.aifJ) && (!com.tencent.xweb.x5.a.e.kiZ()))
    {
      XWalkEnvironment.addXWalkInitializeLog("WebView", "webview type is x5 but no tbs sdk compiled");
      AppMethodBeat.o(212423);
      return false;
    }
    if ((paramWebViewKind == WebViewKind.aifI) || (paramWebViewKind == WebViewKind.aifL))
    {
      localObject = XWalkEnvironment.getWebViewKindFromAvailableVersion();
      if ((localObject != WebViewKind.aifH) && (paramWebViewKind != localObject))
      {
        XWalkEnvironment.addXWalkInitializeLog("WebView", "try init type:" + paramWebViewKind + ", but actual type:" + localObject);
        AppMethodBeat.o(212423);
        return false;
      }
    }
    if (com.tencent.xweb.internal.c.c(paramWebViewKind))
    {
      XWalkEnvironment.addXWalkInitializeLog("WebView", "tryInitWebViewCore, has recent crash");
      com.tencent.xweb.util.l.i(paramWebViewKind);
      AppMethodBeat.o(212423);
      return false;
    }
    Object localObject = com.tencent.xweb.internal.c.c("LOAD_CORE", paramWebViewKind);
    ((com.tencent.xweb.internal.c)localObject).kgZ();
    com.tencent.xweb.internal.c localc = com.tencent.xweb.internal.c.d("LOAD_CORE", paramWebViewKind);
    localc.kgZ();
    for (;;)
    {
      try
      {
        WebViewWrapperFactory.IWebViewProvider localIWebViewProvider = WebViewWrapperFactory.e(paramWebViewKind);
        if (localIWebViewProvider == null) {
          continue;
        }
        boolean bool2 = localIWebViewProvider.initWebviewCore(paramContext, null);
        bool1 = bool2;
        if (!bool2) {
          continue;
        }
        XWalkEnvironment.addXWalkInitializeLog("WebView", "tryInitWebViewCore success");
        c.kfo().aien = localIWebViewProvider.getCookieManager();
        d.kfq().aiep = localIWebViewProvider.getCookieSyncManager();
        com.tencent.xweb.util.l.h(paramWebViewKind);
        ((com.tencent.xweb.internal.c)localObject).kha();
        localc.kha();
        bool1 = bool2;
      }
      finally
      {
        XWalkEnvironment.addXWalkInitializeLog("WebView", "tryInitWebViewCore failed, type:" + paramWebViewKind + ", error:" + paramContext);
        XWalkEnvironment.addXWalkInitializeLog("WebView", "crash stack: " + android.util.Log.getStackTraceString(paramContext));
        com.tencent.xweb.util.l.j(paramWebViewKind);
        boolean bool1 = false;
        continue;
      }
      AppMethodBeat.o(212423);
      return bool1;
      bool1 = false;
      XWalkEnvironment.addXWalkInitializeLog("WebView", "tryInitWebViewCore failed");
    }
  }
  
  private static boolean a(Context paramContext, WebViewKind paramWebViewKind, PreInitCallback paramPreInitCallback, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(212415);
        boolean bool = a(paramContext, paramWebViewKind);
        if ((!bool) && (paramBoolean))
        {
          org.xwalk.core.Log.w("WebView", "initWebviewCoreInternal failed, type:" + paramWebViewKind + ", try other webview types");
          WebViewKind[] arrayOfWebViewKind = new WebViewKind[4];
          arrayOfWebViewKind[0] = WebViewKind.aifL;
          arrayOfWebViewKind[1] = WebViewKind.aifI;
          arrayOfWebViewKind[2] = WebViewKind.aifK;
          arrayOfWebViewKind[3] = WebViewKind.aifJ;
          int i = 0;
          paramBoolean = bool;
          if (i < 4)
          {
            if (arrayOfWebViewKind[i] != paramWebViewKind)
            {
              paramBoolean = a(paramContext, arrayOfWebViewKind[i]);
              bool = paramBoolean;
              if (paramBoolean) {
                aifq = arrayOfWebViewKind[i];
              }
            }
          }
          else
          {
            if (paramBoolean) {
              break label206;
            }
            org.xwalk.core.Log.e("WebView", "initWebviewCoreInternal failed");
            if (paramPreInitCallback != null) {
              paramPreInitCallback.aDm();
            }
            com.tencent.xweb.util.l.kiw();
            AppMethodBeat.o(212415);
            paramBoolean = false;
            return paramBoolean;
          }
          i += 1;
          continue;
        }
        else
        {
          paramBoolean = bool;
          if (!bool) {
            continue;
          }
          aifq = paramWebViewKind;
          paramBoolean = bool;
          continue;
        }
        if (paramPreInitCallback == null) {
          break label216;
        }
      }
      finally {}
      label206:
      paramPreInitCallback.onCoreInitFinished();
      label216:
      XWalkEnvironment.addXWalkInitializeLog("WebView", "initWebviewCoreInternal success, type:" + aifq + ", sdkVer:" + ao.kge() + ", apkVer:" + XWalkEnvironment.getAvailableVersion());
      AppMethodBeat.o(212415);
      paramBoolean = true;
    }
  }
  
  /* Error */
  private void b(WebViewKind paramWebViewKind)
  {
    // Byte code:
    //   0: ldc_w 425
    //   3: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc_w 265
    //   9: new 150	java/lang/StringBuilder
    //   12: dup
    //   13: ldc_w 427
    //   16: invokespecial 155	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   19: invokestatic 430	com/tencent/xweb/WebView:getCurWebType	()Lcom/tencent/xweb/WebView$WebViewKind;
    //   22: invokevirtual 305	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   25: ldc_w 432
    //   28: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: aload_1
    //   32: invokevirtual 305	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   35: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokestatic 279	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   41: invokestatic 435	org/xwalk/core/XWalkEnvironment:getApplicationContext	()Landroid/content/Context;
    //   44: ifnonnull +10 -> 54
    //   47: aload_0
    //   48: invokevirtual 438	com/tencent/xweb/WebView:getContext	()Landroid/content/Context;
    //   51: invokestatic 441	org/xwalk/core/XWalkEnvironment:init	(Landroid/content/Context;)V
    //   54: aload_0
    //   55: getfield 111	com/tencent/xweb/WebView:aifx	Lcom/tencent/xweb/WebView$WebViewKind;
    //   58: getstatic 66	com/tencent/xweb/WebView$WebViewKind:aifH	Lcom/tencent/xweb/WebView$WebViewKind;
    //   61: if_acmpeq +44 -> 105
    //   64: aload_0
    //   65: getfield 118	com/tencent/xweb/WebView:aifz	Lcom/tencent/xweb/b/e;
    //   68: iconst_1
    //   69: putfield 189	com/tencent/xweb/b/e:ailz	Z
    //   72: ldc_w 265
    //   75: new 150	java/lang/StringBuilder
    //   78: dup
    //   79: ldc_w 443
    //   82: invokespecial 155	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   85: aload_0
    //   86: getfield 111	com/tencent/xweb/WebView:aifx	Lcom/tencent/xweb/WebView$WebViewKind;
    //   89: invokevirtual 305	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   92: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: invokestatic 279	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   98: ldc_w 425
    //   101: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   104: return
    //   105: invokestatic 449	com/tencent/xweb/internal/i:khf	()Lcom/tencent/xweb/internal/i;
    //   108: invokevirtual 452	com/tencent/xweb/internal/i:khi	()Z
    //   111: ifeq +281 -> 392
    //   114: aload_0
    //   115: getstatic 402	com/tencent/xweb/WebView$WebViewKind:aifK	Lcom/tencent/xweb/WebView$WebViewKind;
    //   118: putfield 111	com/tencent/xweb/WebView:aifx	Lcom/tencent/xweb/WebView$WebViewKind;
    //   121: ldc_w 265
    //   124: ldc_w 454
    //   127: invokestatic 279	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   130: aload_0
    //   131: invokevirtual 438	com/tencent/xweb/WebView:getContext	()Landroid/content/Context;
    //   134: getstatic 402	com/tencent/xweb/WebView$WebViewKind:aifK	Lcom/tencent/xweb/WebView$WebViewKind;
    //   137: invokestatic 395	com/tencent/xweb/WebView:a	(Landroid/content/Context;Lcom/tencent/xweb/WebView$WebViewKind;)Z
    //   140: pop
    //   141: aload_0
    //   142: getfield 118	com/tencent/xweb/WebView:aifz	Lcom/tencent/xweb/b/e;
    //   145: invokestatic 457	com/tencent/xweb/WebView:getCurStrModule	()Ljava/lang/String;
    //   148: putfield 197	com/tencent/xweb/b/e:aiiT	Ljava/lang/String;
    //   151: aload_0
    //   152: getfield 118	com/tencent/xweb/WebView:aifz	Lcom/tencent/xweb/b/e;
    //   155: astore_1
    //   156: aload_1
    //   157: aload_0
    //   158: getfield 111	com/tencent/xweb/WebView:aifx	Lcom/tencent/xweb/WebView$WebViewKind;
    //   161: invokevirtual 460	com/tencent/xweb/WebView$WebViewKind:ordinal	()I
    //   164: putfield 206	com/tencent/xweb/b/e:ailG	I
    //   167: aload_1
    //   168: invokestatic 124	java/lang/System:currentTimeMillis	()J
    //   171: putfield 209	com/tencent/xweb/b/e:ailH	J
    //   174: aload_1
    //   175: aload_1
    //   176: getfield 209	com/tencent/xweb/b/e:ailH	J
    //   179: aload_1
    //   180: getfield 128	com/tencent/xweb/b/e:ailC	J
    //   183: lsub
    //   184: putfield 203	com/tencent/xweb/b/e:ailF	J
    //   187: ldc_w 265
    //   190: new 150	java/lang/StringBuilder
    //   193: dup
    //   194: ldc_w 462
    //   197: invokespecial 155	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   200: aload_0
    //   201: getfield 111	com/tencent/xweb/WebView:aifx	Lcom/tencent/xweb/WebView$WebViewKind;
    //   204: invokevirtual 305	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   207: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: invokestatic 279	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   213: aload_0
    //   214: aload_0
    //   215: getfield 111	com/tencent/xweb/WebView:aifx	Lcom/tencent/xweb/WebView$WebViewKind;
    //   218: aload_0
    //   219: invokestatic 465	com/tencent/xweb/internal/WebViewWrapperFactory:a	(Lcom/tencent/xweb/WebView$WebViewKind;Lcom/tencent/xweb/WebView;)Lcom/tencent/xweb/internal/IWebView;
    //   222: putfield 467	com/tencent/xweb/WebView:aifw	Lcom/tencent/xweb/internal/IWebView;
    //   225: aload_0
    //   226: getfield 467	com/tencent/xweb/WebView:aifw	Lcom/tencent/xweb/internal/IWebView;
    //   229: ifnonnull +655 -> 884
    //   232: aload_0
    //   233: getfield 118	com/tencent/xweb/WebView:aifz	Lcom/tencent/xweb/b/e;
    //   236: iconst_2
    //   237: invokevirtual 470	com/tencent/xweb/b/e:aJD	(I)V
    //   240: aload_0
    //   241: getfield 118	com/tencent/xweb/WebView:aifz	Lcom/tencent/xweb/b/e;
    //   244: invokestatic 124	java/lang/System:currentTimeMillis	()J
    //   247: putfield 224	com/tencent/xweb/b/e:ailM	J
    //   250: ldc_w 265
    //   253: ldc_w 472
    //   256: invokestatic 279	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   259: iconst_4
    //   260: anewarray 13	com/tencent/xweb/WebView$WebViewKind
    //   263: astore_1
    //   264: aload_1
    //   265: iconst_0
    //   266: getstatic 296	com/tencent/xweb/WebView$WebViewKind:aifL	Lcom/tencent/xweb/WebView$WebViewKind;
    //   269: aastore
    //   270: aload_1
    //   271: iconst_1
    //   272: getstatic 293	com/tencent/xweb/WebView$WebViewKind:aifI	Lcom/tencent/xweb/WebView$WebViewKind;
    //   275: aastore
    //   276: aload_1
    //   277: iconst_2
    //   278: getstatic 402	com/tencent/xweb/WebView$WebViewKind:aifK	Lcom/tencent/xweb/WebView$WebViewKind;
    //   281: aastore
    //   282: aload_1
    //   283: iconst_3
    //   284: getstatic 282	com/tencent/xweb/WebView$WebViewKind:aifJ	Lcom/tencent/xweb/WebView$WebViewKind;
    //   287: aastore
    //   288: iconst_0
    //   289: istore_2
    //   290: iload_2
    //   291: iconst_4
    //   292: if_icmpge +53 -> 345
    //   295: aload_1
    //   296: iload_2
    //   297: aaload
    //   298: aload_0
    //   299: getfield 111	com/tencent/xweb/WebView:aifx	Lcom/tencent/xweb/WebView$WebViewKind;
    //   302: if_acmpeq +233 -> 535
    //   305: aload_0
    //   306: invokevirtual 438	com/tencent/xweb/WebView:getContext	()Landroid/content/Context;
    //   309: aload_1
    //   310: iload_2
    //   311: aaload
    //   312: aconst_null
    //   313: iconst_0
    //   314: invokestatic 474	com/tencent/xweb/WebView:initWebviewCore	(Landroid/content/Context;Lcom/tencent/xweb/WebView$WebViewKind;Lcom/tencent/xweb/WebView$PreInitCallback;Z)Z
    //   317: ifeq +218 -> 535
    //   320: aload_0
    //   321: aload_1
    //   322: iload_2
    //   323: aaload
    //   324: aload_0
    //   325: invokestatic 465	com/tencent/xweb/internal/WebViewWrapperFactory:a	(Lcom/tencent/xweb/WebView$WebViewKind;Lcom/tencent/xweb/WebView;)Lcom/tencent/xweb/internal/IWebView;
    //   328: putfield 467	com/tencent/xweb/WebView:aifw	Lcom/tencent/xweb/internal/IWebView;
    //   331: aload_0
    //   332: getfield 467	com/tencent/xweb/WebView:aifw	Lcom/tencent/xweb/internal/IWebView;
    //   335: ifnull +200 -> 535
    //   338: aload_0
    //   339: invokestatic 430	com/tencent/xweb/WebView:getCurWebType	()Lcom/tencent/xweb/WebView$WebViewKind;
    //   342: putfield 111	com/tencent/xweb/WebView:aifx	Lcom/tencent/xweb/WebView$WebViewKind;
    //   345: aload_0
    //   346: getfield 467	com/tencent/xweb/WebView:aifw	Lcom/tencent/xweb/internal/IWebView;
    //   349: ifnonnull +193 -> 542
    //   352: aload_0
    //   353: getfield 118	com/tencent/xweb/WebView:aifz	Lcom/tencent/xweb/b/e;
    //   356: iconst_2
    //   357: iconst_0
    //   358: invokevirtual 478	com/tencent/xweb/b/e:qe	(II)V
    //   361: ldc_w 265
    //   364: ldc_w 480
    //   367: invokestatic 406	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   370: invokestatic 483	com/tencent/xweb/util/l:kix	()V
    //   373: new 485	com/tencent/xweb/e
    //   376: dup
    //   377: ldc_w 487
    //   380: invokespecial 488	com/tencent/xweb/e:<init>	(Ljava/lang/String;)V
    //   383: astore_1
    //   384: ldc_w 425
    //   387: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   390: aload_1
    //   391: athrow
    //   392: aload_1
    //   393: getstatic 402	com/tencent/xweb/WebView$WebViewKind:aifK	Lcom/tencent/xweb/WebView$WebViewKind;
    //   396: if_acmpne +31 -> 427
    //   399: aload_0
    //   400: aload_1
    //   401: putfield 111	com/tencent/xweb/WebView:aifx	Lcom/tencent/xweb/WebView$WebViewKind;
    //   404: ldc_w 265
    //   407: ldc_w 490
    //   410: invokestatic 279	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   413: aload_0
    //   414: invokevirtual 438	com/tencent/xweb/WebView:getContext	()Landroid/content/Context;
    //   417: getstatic 402	com/tencent/xweb/WebView$WebViewKind:aifK	Lcom/tencent/xweb/WebView$WebViewKind;
    //   420: invokestatic 395	com/tencent/xweb/WebView:a	(Landroid/content/Context;Lcom/tencent/xweb/WebView$WebViewKind;)Z
    //   423: pop
    //   424: goto -283 -> 141
    //   427: invokestatic 430	com/tencent/xweb/WebView:getCurWebType	()Lcom/tencent/xweb/WebView$WebViewKind;
    //   430: getstatic 66	com/tencent/xweb/WebView$WebViewKind:aifH	Lcom/tencent/xweb/WebView$WebViewKind;
    //   433: if_acmpne +92 -> 525
    //   436: aload_0
    //   437: getfield 118	com/tencent/xweb/WebView:aifz	Lcom/tencent/xweb/b/e;
    //   440: iconst_0
    //   441: putfield 194	com/tencent/xweb/b/e:ailA	Z
    //   444: aload_0
    //   445: invokevirtual 438	com/tencent/xweb/WebView:getContext	()Landroid/content/Context;
    //   448: ldc_w 492
    //   451: invokestatic 495	org/xwalk/core/XWalkEnvironment:getSafeModuleName	(Ljava/lang/String;)Ljava/lang/String;
    //   454: invokestatic 498	com/tencent/xweb/WebView:bHJ	(Ljava/lang/String;)Ljava/lang/String;
    //   457: invokestatic 502	com/tencent/xweb/WebView:getPreferedWebviewType	(Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/xweb/WebView$WebViewKind;
    //   460: astore_1
    //   461: ldc_w 265
    //   464: ldc_w 504
    //   467: aload_1
    //   468: invokestatic 253	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   471: invokevirtual 257	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   474: invokestatic 279	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   477: aload_1
    //   478: getstatic 66	com/tencent/xweb/WebView$WebViewKind:aifH	Lcom/tencent/xweb/WebView$WebViewKind;
    //   481: if_acmpeq +23 -> 504
    //   484: aload_0
    //   485: aload_1
    //   486: putfield 111	com/tencent/xweb/WebView:aifx	Lcom/tencent/xweb/WebView$WebViewKind;
    //   489: aload_0
    //   490: invokevirtual 438	com/tencent/xweb/WebView:getContext	()Landroid/content/Context;
    //   493: aload_0
    //   494: getfield 111	com/tencent/xweb/WebView:aifx	Lcom/tencent/xweb/WebView$WebViewKind;
    //   497: invokestatic 395	com/tencent/xweb/WebView:a	(Landroid/content/Context;Lcom/tencent/xweb/WebView$WebViewKind;)Z
    //   500: pop
    //   501: goto -360 -> 141
    //   504: aload_0
    //   505: getstatic 402	com/tencent/xweb/WebView$WebViewKind:aifK	Lcom/tencent/xweb/WebView$WebViewKind;
    //   508: putfield 111	com/tencent/xweb/WebView:aifx	Lcom/tencent/xweb/WebView$WebViewKind;
    //   511: aload_0
    //   512: invokevirtual 438	com/tencent/xweb/WebView:getContext	()Landroid/content/Context;
    //   515: getstatic 402	com/tencent/xweb/WebView$WebViewKind:aifK	Lcom/tencent/xweb/WebView$WebViewKind;
    //   518: invokestatic 395	com/tencent/xweb/WebView:a	(Landroid/content/Context;Lcom/tencent/xweb/WebView$WebViewKind;)Z
    //   521: pop
    //   522: goto -381 -> 141
    //   525: aload_0
    //   526: invokestatic 430	com/tencent/xweb/WebView:getCurWebType	()Lcom/tencent/xweb/WebView$WebViewKind;
    //   529: putfield 111	com/tencent/xweb/WebView:aifx	Lcom/tencent/xweb/WebView$WebViewKind;
    //   532: goto -391 -> 141
    //   535: iload_2
    //   536: iconst_1
    //   537: iadd
    //   538: istore_2
    //   539: goto -249 -> 290
    //   542: aload_0
    //   543: getfield 118	com/tencent/xweb/WebView:aifz	Lcom/tencent/xweb/b/e;
    //   546: iconst_1
    //   547: aload_0
    //   548: getfield 111	com/tencent/xweb/WebView:aifx	Lcom/tencent/xweb/WebView$WebViewKind;
    //   551: invokevirtual 460	com/tencent/xweb/WebView$WebViewKind:ordinal	()I
    //   554: invokevirtual 478	com/tencent/xweb/b/e:qe	(II)V
    //   557: aload_0
    //   558: getfield 118	com/tencent/xweb/WebView:aifz	Lcom/tencent/xweb/b/e;
    //   561: astore_1
    //   562: aload_1
    //   563: aload_0
    //   564: getfield 111	com/tencent/xweb/WebView:aifx	Lcom/tencent/xweb/WebView$WebViewKind;
    //   567: invokevirtual 460	com/tencent/xweb/WebView$WebViewKind:ordinal	()I
    //   570: putfield 236	com/tencent/xweb/b/e:ailQ	I
    //   573: aload_1
    //   574: invokestatic 124	java/lang/System:currentTimeMillis	()J
    //   577: putfield 239	com/tencent/xweb/b/e:ailR	J
    //   580: aload_0
    //   581: aload_0
    //   582: getfield 467	com/tencent/xweb/WebView:aifw	Lcom/tencent/xweb/internal/IWebView;
    //   585: invokeinterface 508 1 0
    //   590: invokevirtual 512	com/tencent/xweb/WebView:addView	(Landroid/view/View;)V
    //   593: aload_0
    //   594: getfield 111	com/tencent/xweb/WebView:aifx	Lcom/tencent/xweb/WebView$WebViewKind;
    //   597: getstatic 282	com/tencent/xweb/WebView$WebViewKind:aifJ	Lcom/tencent/xweb/WebView$WebViewKind;
    //   600: if_acmpne +307 -> 907
    //   603: aload_0
    //   604: getfield 467	com/tencent/xweb/WebView:aifw	Lcom/tencent/xweb/internal/IWebView;
    //   607: invokeinterface 516 1 0
    //   612: ifnull +283 -> 895
    //   615: aload_0
    //   616: iconst_1
    //   617: putfield 109	com/tencent/xweb/WebView:aifv	Z
    //   620: ldc_w 265
    //   623: ldc_w 518
    //   626: invokestatic 168	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   629: aload_0
    //   630: getfield 467	com/tencent/xweb/WebView:aifw	Lcom/tencent/xweb/internal/IWebView;
    //   633: invokeinterface 522 1 0
    //   638: ifnull +24 -> 662
    //   641: aload_0
    //   642: getfield 467	com/tencent/xweb/WebView:aifw	Lcom/tencent/xweb/internal/IWebView;
    //   645: invokeinterface 522 1 0
    //   650: aload_0
    //   651: getfield 467	com/tencent/xweb/WebView:aifw	Lcom/tencent/xweb/internal/IWebView;
    //   654: invokeinterface 526 1 0
    //   659: invokevirtual 531	com/tencent/xweb/ag:a	(Lcom/tencent/xweb/internal/f;)V
    //   662: aload_0
    //   663: getfield 467	com/tencent/xweb/WebView:aifw	Lcom/tencent/xweb/internal/IWebView;
    //   666: invokeinterface 535 1 0
    //   671: ifnull +24 -> 695
    //   674: aload_0
    //   675: getfield 467	com/tencent/xweb/WebView:aifw	Lcom/tencent/xweb/internal/IWebView;
    //   678: invokeinterface 535 1 0
    //   683: aload_0
    //   684: getfield 467	com/tencent/xweb/WebView:aifw	Lcom/tencent/xweb/internal/IWebView;
    //   687: invokeinterface 526 1 0
    //   692: putfield 541	com/tencent/xweb/z:aifb	Lcom/tencent/xweb/internal/f;
    //   695: aload_0
    //   696: getfield 467	com/tencent/xweb/WebView:aifw	Lcom/tencent/xweb/internal/IWebView;
    //   699: invokeinterface 544 1 0
    //   704: new 546	com/tencent/xweb/WebView$1
    //   707: dup
    //   708: aload_0
    //   709: invokespecial 549	com/tencent/xweb/WebView$1:<init>	(Lcom/tencent/xweb/WebView;)V
    //   712: invokevirtual 555	android/view/View:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   715: aload_0
    //   716: invokestatic 559	com/tencent/xweb/internal/WebViewWrapperFactory:khn	()Lcom/tencent/xweb/internal/WebViewWrapperFactory$IWebViewProvider;
    //   719: ldc_w 561
    //   722: iconst_1
    //   723: anewarray 563	java/lang/Object
    //   726: dup
    //   727: iconst_0
    //   728: aload_0
    //   729: aastore
    //   730: invokeinterface 567 3 0
    //   735: checkcast 569	com/tencent/xweb/internal/e
    //   738: putfield 571	com/tencent/xweb/WebView:aify	Lcom/tencent/xweb/internal/e;
    //   741: aload_0
    //   742: getfield 571	com/tencent/xweb/WebView:aify	Lcom/tencent/xweb/internal/e;
    //   745: invokeinterface 574 1 0
    //   750: aload_0
    //   751: invokevirtual 577	com/tencent/xweb/WebView:getWebCoreType	()Lcom/tencent/xweb/WebView$WebViewKind;
    //   754: getstatic 293	com/tencent/xweb/WebView$WebViewKind:aifI	Lcom/tencent/xweb/WebView$WebViewKind;
    //   757: if_acmpeq +13 -> 770
    //   760: aload_0
    //   761: invokevirtual 577	com/tencent/xweb/WebView:getWebCoreType	()Lcom/tencent/xweb/WebView$WebViewKind;
    //   764: getstatic 296	com/tencent/xweb/WebView$WebViewKind:aifL	Lcom/tencent/xweb/WebView$WebViewKind;
    //   767: if_acmpne +44 -> 811
    //   770: aload_0
    //   771: invokevirtual 438	com/tencent/xweb/WebView:getContext	()Landroid/content/Context;
    //   774: astore_1
    //   775: aload_1
    //   776: instanceof 25
    //   779: ifeq +14 -> 793
    //   782: aload_1
    //   783: checkcast 25	com/tencent/xweb/WebView$d
    //   786: aload_0
    //   787: getfield 467	com/tencent/xweb/WebView:aifw	Lcom/tencent/xweb/internal/IWebView;
    //   790: putfield 580	com/tencent/xweb/WebView$d:aifO	Lcom/tencent/xweb/internal/IWebView;
    //   793: aload_0
    //   794: invokevirtual 577	com/tencent/xweb/WebView:getWebCoreType	()Lcom/tencent/xweb/WebView$WebViewKind;
    //   797: invokestatic 585	com/tencent/xweb/internal/l:d	(Lcom/tencent/xweb/WebView$WebViewKind;)Lcom/tencent/xweb/internal/g;
    //   800: astore_1
    //   801: aload_1
    //   802: ifnull +9 -> 811
    //   805: aload_1
    //   806: invokeinterface 590 1 0
    //   811: aload_0
    //   812: invokevirtual 594	com/tencent/xweb/WebView:getSettings	()Lcom/tencent/xweb/ad;
    //   815: invokevirtual 599	com/tencent/xweb/ad:getUserAgentString	()Ljava/lang/String;
    //   818: astore_1
    //   819: aload_0
    //   820: invokevirtual 594	com/tencent/xweb/WebView:getSettings	()Lcom/tencent/xweb/ad;
    //   823: new 150	java/lang/StringBuilder
    //   826: dup
    //   827: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   830: aload_1
    //   831: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   834: ldc_w 601
    //   837: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   840: invokestatic 606	org/xwalk/core/XWalkGrayValueUtil:getGrayValue	()I
    //   843: invokevirtual 178	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   846: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   849: invokevirtual 609	com/tencent/xweb/ad:setUserAgentString	(Ljava/lang/String;)V
    //   852: aload_0
    //   853: getfield 118	com/tencent/xweb/WebView:aifz	Lcom/tencent/xweb/b/e;
    //   856: astore_1
    //   857: aload_1
    //   858: invokestatic 124	java/lang/System:currentTimeMillis	()J
    //   861: putfield 242	com/tencent/xweb/b/e:ailS	J
    //   864: aload_1
    //   865: aload_1
    //   866: getfield 242	com/tencent/xweb/b/e:ailS	J
    //   869: aload_1
    //   870: getfield 239	com/tencent/xweb/b/e:ailR	J
    //   873: lsub
    //   874: putfield 245	com/tencent/xweb/b/e:ailT	J
    //   877: ldc_w 425
    //   880: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   883: return
    //   884: aload_0
    //   885: getfield 118	com/tencent/xweb/WebView:aifz	Lcom/tencent/xweb/b/e;
    //   888: iconst_1
    //   889: invokevirtual 470	com/tencent/xweb/b/e:aJD	(I)V
    //   892: goto -335 -> 557
    //   895: ldc_w 265
    //   898: ldc_w 611
    //   901: invokestatic 168	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   904: goto -275 -> 629
    //   907: ldc_w 265
    //   910: new 150	java/lang/StringBuilder
    //   913: dup
    //   914: ldc_w 613
    //   917: invokespecial 155	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   920: aload_0
    //   921: getfield 111	com/tencent/xweb/WebView:aifx	Lcom/tencent/xweb/WebView$WebViewKind;
    //   924: invokevirtual 305	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   927: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   930: invokestatic 168	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   933: goto -304 -> 629
    //   936: astore_1
    //   937: ldc_w 265
    //   940: ldc_w 615
    //   943: aload_1
    //   944: invokestatic 253	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   947: invokevirtual 257	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   950: invokestatic 406	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   953: aload_0
    //   954: new 8	com/tencent/xweb/WebView$2
    //   957: dup
    //   958: aload_0
    //   959: invokespecial 616	com/tencent/xweb/WebView$2:<init>	(Lcom/tencent/xweb/WebView;)V
    //   962: putfield 571	com/tencent/xweb/WebView:aify	Lcom/tencent/xweb/internal/e;
    //   965: goto -215 -> 750
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	968	0	this	WebView
    //   0	968	1	paramWebViewKind	WebViewKind
    //   289	250	2	i	int
    // Exception table:
    //   from	to	target	type
    //   715	750	936	finally
  }
  
  private static String bHJ(String paramString)
  {
    AppMethodBeat.i(212402);
    String str;
    if (paramString != null)
    {
      str = paramString;
      if (!paramString.isEmpty()) {}
    }
    else
    {
      str = "tools";
    }
    aifr = str;
    com.tencent.xweb.util.l.bIe(str);
    AppMethodBeat.o(212402);
    return str;
  }
  
  @Deprecated
  public static void disablePlatformNotifications()
  {
    AppMethodBeat.i(156877);
    if (getCurWebType() == WebViewKind.aifK) {
      com.tencent.xweb.util.k.rc("android.webkit.WebView", "disablePlatformNotifications");
    }
    AppMethodBeat.o(156877);
  }
  
  @Deprecated
  public static void enablePlatformNotifications()
  {
    AppMethodBeat.i(156876);
    if (getCurWebType() == WebViewKind.aifK) {
      com.tencent.xweb.util.k.rc("android.webkit.WebView", "enablePlatformNotifications");
    }
    AppMethodBeat.o(156876);
  }
  
  public static void forceEnableFrameCostProfile(boolean paramBoolean)
  {
    AppMethodBeat.i(212514);
    g localg = com.tencent.xweb.internal.l.d(getCurWebType());
    if (localg != null) {
      localg.khd().forceEnableFrameCostProfile(paramBoolean);
    }
    AppMethodBeat.o(212514);
  }
  
  public static void forceFlushCategory(String paramString)
  {
    AppMethodBeat.i(212507);
    g localg = com.tencent.xweb.internal.l.d(getCurWebType());
    if (localg != null) {
      localg.khd().forceFlushCategory(paramString);
    }
    AppMethodBeat.o(212507);
  }
  
  @Deprecated
  public static boolean getCanReboot()
  {
    AppMethodBeat.i(156860);
    if ((aifs) && (XWebCoreInfo.getInstalledNewestVersionForCurAbi(XWalkEnvironment.getApplicationContext()) > 0))
    {
      org.xwalk.core.Log.i("WebView", "getCanReboot, need reboot because of has installed xweb core");
      AppMethodBeat.o(156860);
      return true;
    }
    if (((getCurWebType() == WebViewKind.aifI) || (getCurWebType() == WebViewKind.aifL)) && (XWalkEnvironment.getAvailableVersion() > 0) && (XWalkEnvironment.getInstalledNewstVersionForCurAbi() > XWalkEnvironment.getAvailableVersion()))
    {
      org.xwalk.core.Log.i("WebView", "getCanReboot, need reboot because of has newer xweb version");
      AppMethodBeat.o(156860);
      return true;
    }
    if (getCurWebType() == WebViewKind.aifJ)
    {
      if (aift != null)
      {
        boolean bool = aift.getCanReboot();
        AppMethodBeat.o(156860);
        return bool;
      }
      org.xwalk.core.Log.e("WebView", "getCanReboot, X5WebViewEx is null");
    }
    if (i.khf().khj())
    {
      org.xwalk.core.Log.i("WebView", "getCanReboot, need reboot because of waiting for switch");
      AppMethodBeat.o(156860);
      return true;
    }
    AppMethodBeat.o(156860);
    return false;
  }
  
  @Deprecated
  public static String getCrashExtraMessage(Context paramContext)
  {
    AppMethodBeat.i(156859);
    if (aift != null)
    {
      paramContext = aift.getCrashExtraMessage(paramContext);
      AppMethodBeat.o(156859);
      return paramContext;
    }
    org.xwalk.core.Log.e("WebView", "getCrashExtraMessage, X5WebViewEx is null");
    AppMethodBeat.o(156859);
    return "";
  }
  
  public static String getCurStrModule()
  {
    return aifr;
  }
  
  public static WebViewKind getCurWebType()
  {
    return aifq;
  }
  
  @Deprecated
  public static int getInstalledTbsCoreVersion(Context paramContext)
  {
    AppMethodBeat.i(156856);
    if (aift != null)
    {
      int i = aift.getTbsCoreVersion(paramContext);
      AppMethodBeat.o(156856);
      return i;
    }
    org.xwalk.core.Log.e("WebView", "getInstalledTbsCoreVersion, X5WebViewEx is null");
    AppMethodBeat.o(156856);
    return 0;
  }
  
  public static WebViewKind getPreferedWebviewType(Context paramContext, WebViewKind paramWebViewKind, String paramString)
  {
    AppMethodBeat.i(156809);
    XWalkEnvironment.addXWalkInitializeLog("WebView", "getPreferedWebviewType start, kind:" + paramWebViewKind + ", module:" + paramString);
    if (aifq != WebViewKind.aifH)
    {
      XWalkEnvironment.addXWalkInitializeLog("WebView", "getPreferedWebviewType end, already get webview type:" + aifq);
      paramContext = aifq;
      AppMethodBeat.o(156809);
      return paramContext;
    }
    XWalkEnvironment.init(paramContext);
    if (b.khu())
    {
      XWalkEnvironment.addXWalkInitializeLog("WebView", "getPreferedWebviewType end, x86 device, use sys");
      com.tencent.xweb.util.l.Br(69L);
      paramContext = WebViewKind.aifK;
      AppMethodBeat.o(156809);
      return paramContext;
    }
    paramContext = aa.kfE().bHG(paramString);
    if (paramContext != WebViewKind.aifH)
    {
      XWalkEnvironment.addXWalkInitializeLog("WebView", "use hard code webview type:".concat(String.valueOf(paramContext)));
      paramWebViewKind = paramContext;
    }
    for (;;)
    {
      com.tencent.xweb.util.l.g(paramWebViewKind);
      paramContext = paramWebViewKind;
      if (paramWebViewKind == WebViewKind.aifJ)
      {
        paramContext = paramWebViewKind;
        if (!com.tencent.xweb.x5.a.e.kiZ())
        {
          paramContext = WebViewKind.aifI;
          XWalkEnvironment.addXWalkInitializeLog("WebView", "x5 sdk is not available, use xweb");
        }
      }
      if (paramContext != WebViewKind.aifI)
      {
        paramWebViewKind = paramContext;
        if (paramContext != WebViewKind.aifL) {}
      }
      else
      {
        paramWebViewKind = paramContext;
        if (!XWalkEnvironment.hasAvailableVersion())
        {
          paramWebViewKind = WebViewKind.aifK;
          aifs = true;
          XWalkEnvironment.addXWalkInitializeLog("WebView", "xweb is not available, use sys");
        }
      }
      i.b(paramWebViewKind, paramString);
      if (i.khf().khk())
      {
        paramWebViewKind = WebViewKind.aifK;
        XWalkEnvironment.addXWalkInitializeLog("WebView", "LoadUrlWatchDog is switched, use sys");
      }
      XWalkEnvironment.addXWalkInitializeLog("WebView", "getPreferedWebviewType end, final webview type:".concat(String.valueOf(paramWebViewKind)));
      AppMethodBeat.o(156809);
      return paramWebViewKind;
      if (a.keX().bHh(paramString) != WebViewKind.aifH)
      {
        paramWebViewKind = a.keX().bHh(paramString);
        XWalkEnvironment.addXWalkInitializeLog("WebView", "use cmd config webview type:".concat(String.valueOf(paramWebViewKind)));
      }
    }
  }
  
  public static WebViewKind getPreferedWebviewType(Context paramContext, String paramString)
  {
    AppMethodBeat.i(156808);
    paramContext = getPreferedWebviewType(paramContext, WebViewKind.aifI, paramString);
    AppMethodBeat.o(156808);
    return paramContext;
  }
  
  @Deprecated
  public static int getTbsCoreVersion(Context paramContext)
  {
    AppMethodBeat.i(156857);
    if (aift != null)
    {
      int i = aift.getTbsCoreVersion(paramContext);
      AppMethodBeat.o(156857);
      return i;
    }
    org.xwalk.core.Log.e("WebView", "getTbsCoreVersion, X5WebViewEx is null");
    AppMethodBeat.o(156857);
    return 0;
  }
  
  @Deprecated
  public static int getTbsSDKVersion(Context paramContext)
  {
    AppMethodBeat.i(156858);
    if (aift != null)
    {
      int i = aift.getTbsSDKVersion(paramContext);
      AppMethodBeat.o(156858);
      return i;
    }
    org.xwalk.core.Log.e("WebView", "getTbsSDKVersion, X5WebViewEx is null");
    AppMethodBeat.o(156858);
    return 0;
  }
  
  @Deprecated
  public static int getUsingTbsCoreVersion(Context paramContext)
  {
    AppMethodBeat.i(156855);
    if (aifq == WebViewKind.aifJ)
    {
      if (aift != null)
      {
        int i = aift.getTbsCoreVersion(paramContext);
        AppMethodBeat.o(156855);
        return i;
      }
      org.xwalk.core.Log.e("WebView", "getUsingTbsCoreVersion, X5WebViewEx is null");
    }
    AppMethodBeat.o(156855);
    return 0;
  }
  
  @Deprecated
  public static boolean hasInited()
  {
    AppMethodBeat.i(156814);
    if (getCurWebType() == WebViewKind.aifH)
    {
      org.xwalk.core.Log.i("WebView", "hasInited false, current webview type is NONE");
      AppMethodBeat.o(156814);
      return false;
    }
    WebViewWrapperFactory.IWebViewProvider localIWebViewProvider = WebViewWrapperFactory.e(getCurWebType());
    if (localIWebViewProvider == null)
    {
      org.xwalk.core.Log.i("WebView", "hasInited false, current webview provider is null");
      AppMethodBeat.o(156814);
      return false;
    }
    boolean bool = localIWebViewProvider.hasInited();
    AppMethodBeat.o(156814);
    return bool;
  }
  
  @Deprecated
  public static void initWebviewCore(Context paramContext, WebViewKind paramWebViewKind, String paramString, PreInitCallback paramPreInitCallback)
  {
    int i = 1;
    AppMethodBeat.i(156810);
    XWalkEnvironment.addXWalkInitializeLog("WebView", "initWebviewCore, kind:" + paramWebViewKind + ", module:" + paramString);
    if (aifq != WebViewKind.aifH)
    {
      if (aifq != paramWebViewKind)
      {
        XWalkEnvironment.addXWalkInitializeLog("WebView", "initWebviewCore, set invalid webview kind:" + paramWebViewKind + ", expected:" + aifq);
        if (paramPreInitCallback != null)
        {
          paramPreInitCallback.aDm();
          AppMethodBeat.o(156810);
        }
      }
      else
      {
        XWalkEnvironment.addXWalkInitializeLog("WebView", "initWebviewCore, already init webview kind:".concat(String.valueOf(paramWebViewKind)));
        if (paramPreInitCallback != null) {
          paramPreInitCallback.onCoreInitFinished();
        }
      }
      AppMethodBeat.o(156810);
      return;
    }
    aifA.ailV = System.currentTimeMillis();
    paramString = bHJ(paramString);
    aa.oP(paramContext);
    XWalkEnvironment.init(paramContext);
    u.init();
    int j = XWalkEnvironment.getAvailableVersion();
    XWalkEnvironment.addXWalkInitializeLog("WebView", "initWebviewCore, availableVersion:".concat(String.valueOf(j)));
    if (j <= 0)
    {
      y.kfx();
      boolean bool = initWebviewCore(paramContext, getPreferedWebviewType(paramContext, paramWebViewKind, paramString), paramPreInitCallback, true);
      paramContext = aifA;
      j = aifq.ordinal();
      paramContext.aiiT = paramString;
      paramContext.ailU = j;
      paramContext.ailW = System.currentTimeMillis();
      paramContext.ailX = (paramContext.ailW - paramContext.ailV);
      if (!bool) {
        break label430;
      }
    }
    for (;;)
    {
      paramContext.ailY = i;
      paramContext = ao.kge() + "," + XWalkEnvironment.getInstalledNewstVersionForCurAbi() + "," + paramContext.aiiT + "," + paramContext.ailU + "," + paramContext.ailV + "," + paramContext.ailW + "," + paramContext.ailX + "," + paramContext.ailY;
      org.xwalk.core.Log.i("KVReportForWebViewCore", "report:".concat(String.valueOf(paramContext)));
      com.tencent.xweb.util.l.ev(24761, paramContext);
      AppMethodBeat.o(156810);
      return;
      int k = WebViewWrapperFactory.kho();
      XWalkEnvironment.addXWalkInitializeLog("WebView", "initWebviewCore, embedVersion:".concat(String.valueOf(k)));
      if (j >= k) {
        break;
      }
      y.kfx();
      break;
      label430:
      i = 2;
    }
  }
  
  public static boolean initWebviewCore(Context paramContext, WebViewKind paramWebViewKind, PreInitCallback paramPreInitCallback, boolean paramBoolean)
  {
    try
    {
      AppMethodBeat.i(212407);
      XWalkEnvironment.addXWalkInitializeLog("WebView", "initWebviewCore, kind:" + paramWebViewKind + ", bTryOtherWebtype:" + paramBoolean);
      paramBoolean = a(paramContext, paramWebViewKind, paramPreInitCallback, paramBoolean);
      AppMethodBeat.o(212407);
      return paramBoolean;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static boolean isPinus()
  {
    AppMethodBeat.i(212524);
    if (getCurWebType() == WebViewKind.aifL)
    {
      AppMethodBeat.o(212524);
      return true;
    }
    AppMethodBeat.o(212524);
    return false;
  }
  
  @Deprecated
  public static boolean isSys()
  {
    AppMethodBeat.i(156914);
    if (getCurWebType() == WebViewKind.aifK)
    {
      AppMethodBeat.o(156914);
      return true;
    }
    AppMethodBeat.o(156914);
    return false;
  }
  
  @Deprecated
  public static boolean isX5()
  {
    AppMethodBeat.i(156913);
    if (getCurWebType() == WebViewKind.aifJ)
    {
      AppMethodBeat.o(156913);
      return true;
    }
    AppMethodBeat.o(156913);
    return false;
  }
  
  @Deprecated
  public static boolean isXWalk()
  {
    AppMethodBeat.i(156912);
    if ((getCurWebType() == WebViewKind.aifI) || (getCurWebType() == WebViewKind.aifL))
    {
      AppMethodBeat.o(156912);
      return true;
    }
    AppMethodBeat.o(156912);
    return false;
  }
  
  @Deprecated
  public static boolean isXWebCoreInited()
  {
    return aifu;
  }
  
  private List<TextureView> mM(View paramView)
  {
    AppMethodBeat.i(156836);
    ArrayList localArrayList = new ArrayList();
    if ((paramView instanceof TextureView)) {
      localArrayList.add((TextureView)paramView);
    }
    for (;;)
    {
      AppMethodBeat.o(156836);
      return localArrayList;
      if ((paramView instanceof ViewGroup))
      {
        paramView = (ViewGroup)paramView;
        int i = 0;
        while (i < paramView.getChildCount())
        {
          localArrayList.addAll(mM(paramView.getChildAt(i)));
          i += 1;
        }
      }
    }
  }
  
  public static void onXWebCoreInited()
  {
    aifu = true;
  }
  
  public static void reinitToPinus()
  {
    AppMethodBeat.i(212433);
    XWalkEnvironment.addXWalkInitializeLog("WebView", "reinitToPinus");
    aifq = WebViewKind.aifH;
    XWalkEnvironment.refreshVersionInfo();
    initWebviewCore(XWalkEnvironment.getApplicationContext(), WebViewKind.aifL, aifr, null);
    com.tencent.xweb.util.l.y(1749L, 66L, 1L);
    AppMethodBeat.o(212433);
  }
  
  public static void reinitToXWalk()
  {
    AppMethodBeat.i(212428);
    XWalkEnvironment.addXWalkInitializeLog("WebView", "reinitToXWalk");
    aifq = WebViewKind.aifH;
    XWalkEnvironment.refreshVersionInfo();
    initWebviewCore(XWalkEnvironment.getApplicationContext(), WebViewKind.aifI, aifr, null);
    com.tencent.xweb.util.l.y(1749L, 66L, 1L);
    AppMethodBeat.o(212428);
  }
  
  public static void setAllKindsFpsProfileEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(212512);
    g localg = com.tencent.xweb.internal.l.d(getCurWebType());
    if (localg != null) {
      localg.khd().setAllKindsFpsProfileEnable(paramBoolean);
    }
    AppMethodBeat.o(212512);
  }
  
  public static boolean setProfileResultCallback(String paramString, m paramm)
  {
    AppMethodBeat.i(183498);
    g localg = com.tencent.xweb.internal.l.d(getCurWebType());
    if (localg != null)
    {
      boolean bool = localg.khd().setProfileResultCallback(paramString, paramm);
      AppMethodBeat.o(183498);
      return bool;
    }
    AppMethodBeat.o(183498);
    return false;
  }
  
  public static void setX5Interface(com.tencent.xweb.x5.a.c paramc)
  {
    aift = paramc;
  }
  
  public void _disablePlatformNotifications() {}
  
  public void _enablePlatformNotifications() {}
  
  public void addJavascriptInterface(Object paramObject, String paramString)
  {
    AppMethodBeat.i(156875);
    this.aifw.addJavascriptInterface(paramObject, paramString);
    AppMethodBeat.o(156875);
  }
  
  public boolean canGoBack()
  {
    AppMethodBeat.i(156888);
    boolean bool = this.aifw.canGoBack();
    AppMethodBeat.o(156888);
    return bool;
  }
  
  public boolean canGoForward()
  {
    AppMethodBeat.i(156900);
    boolean bool = this.aifw.canGoForward();
    AppMethodBeat.o(156900);
    return bool;
  }
  
  public Bitmap captureBitmap()
  {
    AppMethodBeat.i(212556);
    Bitmap localBitmap = this.aifw.captureBitmap();
    AppMethodBeat.o(212556);
    return localBitmap;
  }
  
  public void captureBitmap(IWebView.a parama)
  {
    AppMethodBeat.i(156817);
    org.xwalk.core.Log.d("WebView", "[captureBitmap]");
    this.aifw.captureBitmap(parama);
    AppMethodBeat.o(156817);
  }
  
  public void clearHistory()
  {
    AppMethodBeat.i(156899);
    this.aifw.clearHistory();
    AppMethodBeat.o(156899);
  }
  
  public void clearMatches()
  {
    AppMethodBeat.i(156847);
    this.aifw.clearMatches();
    AppMethodBeat.o(156847);
  }
  
  public void clearSslPreferences()
  {
    AppMethodBeat.i(156862);
    this.aifw.clearSslPreferences();
    AppMethodBeat.o(156862);
  }
  
  public void clearView()
  {
    AppMethodBeat.i(156890);
    this.aifw.clearView();
    AppMethodBeat.o(156890);
  }
  
  public WebBackForwardList copyBackForwardList()
  {
    AppMethodBeat.i(212969);
    WebBackForwardList localWebBackForwardList = this.aifw.copyBackForwardList();
    AppMethodBeat.o(212969);
    return localWebBackForwardList;
  }
  
  public void destroy()
  {
    AppMethodBeat.i(156891);
    Context localContext = getContext();
    if ((localContext instanceof d)) {
      ((d)localContext).aifO = null;
    }
    this.aifw.destroy();
    AppMethodBeat.o(156891);
  }
  
  public void disableVideoJsCallback(boolean paramBoolean)
  {
    AppMethodBeat.i(156910);
    this.aifw.disableVideoJsCallback(paramBoolean);
    AppMethodBeat.o(156910);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(156818);
    super.dispatchDraw(paramCanvas);
    AppMethodBeat.o(156818);
  }
  
  public void drawCanvas(Canvas paramCanvas)
  {
    AppMethodBeat.i(156834);
    if (isXWalkKernel())
    {
      paramCanvas.drawBitmap(getBitmap(), 0.0F, 0.0F, null);
      AppMethodBeat.o(156834);
      return;
    }
    draw(paramCanvas);
    AppMethodBeat.o(156834);
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    AppMethodBeat.i(156816);
    boolean bool = super.drawChild(paramCanvas, paramView, paramLong);
    AppMethodBeat.o(156816);
    return bool;
  }
  
  public void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(156894);
    this.aifw.evaluateJavascript(paramString, paramValueCallback);
    AppMethodBeat.o(156894);
  }
  
  public void findAllAsync(String paramString)
  {
    AppMethodBeat.i(156849);
    this.aifw.findAllAsync(paramString);
    AppMethodBeat.o(156849);
  }
  
  public void findNext(boolean paramBoolean)
  {
    AppMethodBeat.i(156848);
    this.aifw.findNext(paramBoolean);
    AppMethodBeat.o(156848);
  }
  
  public String getAbstractInfo()
  {
    AppMethodBeat.i(156851);
    String str = this.aifw.getAbstractInfo();
    AppMethodBeat.o(156851);
    return str;
  }
  
  public Bitmap getBitmap()
  {
    AppMethodBeat.i(156835);
    Bitmap localBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
    Paint localPaint;
    Object localObject2;
    Object localObject3;
    if (localBitmap != null)
    {
      localBitmap.eraseColor(-1);
      Canvas localCanvas = new Canvas(localBitmap);
      if (!isXWalkKernel()) {
        break label208;
      }
      try
      {
        localPaint = new Paint();
        localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
        localObject2 = mM(this).iterator();
        for (;;)
        {
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = ((TextureView)((Iterator)localObject2).next()).getBitmap();
            if (localObject3 != null)
            {
              localCanvas.drawBitmap((Bitmap)localObject3, 0.0F, 0.0F, localPaint);
              continue;
              AppMethodBeat.o(156835);
            }
          }
        }
      }
      finally
      {
        org.xwalk.core.Log.e("WebView", "getBitmap, error:".concat(String.valueOf(localObject1)));
      }
    }
    for (;;)
    {
      return localBitmap;
      org.xwalk.core.Log.e("WebView", "getBitmap, textureViewBitmap = null");
      break;
      localObject2 = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
      localObject3 = new Canvas((Bitmap)localObject2);
      getTopView().draw((Canvas)localObject3);
      localObject1.drawBitmap((Bitmap)localObject2, 0.0F, 0.0F, localPaint);
      continue;
      label208:
      draw(localObject1);
    }
  }
  
  public int getContentHeight()
  {
    AppMethodBeat.i(156864);
    int i = this.aifw.getContentHeight();
    AppMethodBeat.o(156864);
    return i;
  }
  
  public CookieInternal.ICookieManagerInternal getCookieManager()
  {
    return null;
  }
  
  public CookieInternal.ICookieSyncManagerInternal getCookieSyncManager()
  {
    return null;
  }
  
  public z getCurWebChromeClient()
  {
    AppMethodBeat.i(156853);
    z localz = this.aifw.getCurWebChromeClient();
    AppMethodBeat.o(156853);
    return localz;
  }
  
  public ag getCurWebviewClient()
  {
    AppMethodBeat.i(156852);
    ag localag = this.aifw.getCurWebviewClient();
    AppMethodBeat.o(156852);
    return localag;
  }
  
  public com.tencent.xweb.internal.f getDefalutOpProvider()
  {
    return null;
  }
  
  public a getFullscreenVideoKind()
  {
    AppMethodBeat.i(156895);
    a locala = this.aifw.getFullscreenVideoKind();
    AppMethodBeat.o(156895);
    return locala;
  }
  
  public b getHitTestResult()
  {
    AppMethodBeat.i(156845);
    b localb = this.aifw.getHitTestResult();
    AppMethodBeat.o(156845);
    return localb;
  }
  
  public String[] getHttpAuthUsernamePassword(String paramString1, String paramString2)
  {
    AppMethodBeat.i(212985);
    paramString1 = this.aifw.getHttpAuthUsernamePassword(paramString1, paramString2);
    AppMethodBeat.o(212985);
    return paramString1;
  }
  
  public boolean getImageBitmapToFile(String paramString1, String paramString2, String paramString3, k paramk)
  {
    AppMethodBeat.i(156916);
    boolean bool = this.aifw.getImageBitmapToFile(paramString1, paramString2, paramString3, paramk);
    AppMethodBeat.o(156916);
    return bool;
  }
  
  public float getScale()
  {
    AppMethodBeat.i(156865);
    float f = this.aifw.getScale();
    AppMethodBeat.o(156865);
    return f;
  }
  
  public int getScrollHeight()
  {
    AppMethodBeat.i(156907);
    int i = this.aifw.getScrollHeight();
    AppMethodBeat.o(156907);
    return i;
  }
  
  public ad getSettings()
  {
    AppMethodBeat.i(156878);
    ad localad = this.aifw.getSettings();
    AppMethodBeat.o(156878);
    return localad;
  }
  
  public String getTitle()
  {
    AppMethodBeat.i(156846);
    String str = this.aifw.getTitle();
    AppMethodBeat.o(156846);
    return str;
  }
  
  public ViewGroup getTopView()
  {
    AppMethodBeat.i(156840);
    ViewGroup localViewGroup = this.aifw.getTopView();
    AppMethodBeat.o(156840);
    return localViewGroup;
  }
  
  public String getUrl()
  {
    AppMethodBeat.i(156841);
    String str = this.aifw.getUrl();
    AppMethodBeat.o(156841);
    return str;
  }
  
  public String getVersionInfo()
  {
    AppMethodBeat.i(156850);
    String str = this.aifw.getVersionInfo();
    AppMethodBeat.o(156850);
    return str;
  }
  
  public View getView()
  {
    AppMethodBeat.i(156839);
    View localView = this.aifw.getView();
    AppMethodBeat.o(156839);
    return localView;
  }
  
  public int getVisibleTitleHeight()
  {
    AppMethodBeat.i(156869);
    int i = this.aifw.getVisibleTitleHeight();
    AppMethodBeat.o(156869);
    return i;
  }
  
  public WebViewKind getWebCoreType()
  {
    return this.aifx;
  }
  
  public int getWebScrollX()
  {
    AppMethodBeat.i(156867);
    int i = this.aifw.getWebScrollX();
    AppMethodBeat.o(156867);
    return i;
  }
  
  public int getWebScrollY()
  {
    AppMethodBeat.i(156866);
    int i = this.aifw.getWebScrollY();
    AppMethodBeat.o(156866);
    return i;
  }
  
  public af getWebViewCallbackClient()
  {
    AppMethodBeat.i(212664);
    af localaf = this.aifw.getWebViewCallbackClient();
    AppMethodBeat.o(212664);
    return localaf;
  }
  
  public View getWebViewUI()
  {
    AppMethodBeat.i(156879);
    View localView = this.aifw.getWebViewUI();
    AppMethodBeat.o(156879);
    return localView;
  }
  
  public Object getX5WebViewExtension()
  {
    AppMethodBeat.i(156820);
    Object localObject = this.aifw.getX5WebViewExtension();
    AppMethodBeat.o(156820);
    return localObject;
  }
  
  public void goBack()
  {
    AppMethodBeat.i(156889);
    this.aifw.goBack();
    AppMethodBeat.o(156889);
  }
  
  public void goForward()
  {
    AppMethodBeat.i(156901);
    this.aifw.goForward();
    AppMethodBeat.o(156901);
  }
  
  public boolean hasEnteredFullscreen()
  {
    AppMethodBeat.i(156892);
    boolean bool = this.aifw.hasEnteredFullscreen();
    AppMethodBeat.o(156892);
    return bool;
  }
  
  public Bundle invokeMiscMethod(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(156897);
    paramString = this.aifw.invokeMiscMethod(paramString, paramBundle);
    AppMethodBeat.o(156897);
    return paramString;
  }
  
  public boolean isOverScrollStart()
  {
    AppMethodBeat.i(156868);
    boolean bool = this.aifw.isOverScrollStart();
    AppMethodBeat.o(156868);
    return bool;
  }
  
  public boolean isSysKernel()
  {
    return this.aifx == WebViewKind.aifK;
  }
  
  public boolean isX5WrappedKernel()
  {
    AppMethodBeat.i(212766);
    if (getCurWebType() == WebViewKind.aifJ)
    {
      AppMethodBeat.o(212766);
      return true;
    }
    AppMethodBeat.o(212766);
    return false;
  }
  
  public boolean isX5WrappedSysKernel()
  {
    AppMethodBeat.i(175639);
    if ((getCurWebType() == WebViewKind.aifJ) && (!this.aifv))
    {
      AppMethodBeat.o(175639);
      return true;
    }
    AppMethodBeat.o(175639);
    return false;
  }
  
  public boolean isXWalkKernel()
  {
    return (this.aifx == WebViewKind.aifI) || (this.aifx == WebViewKind.aifL);
  }
  
  public void leaveFullscreen()
  {
    AppMethodBeat.i(156893);
    this.aifw.leaveFullscreen();
    AppMethodBeat.o(156893);
  }
  
  public void loadData(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(156863);
    this.aifw.loadData(paramString1, paramString2, paramString3);
    com.tencent.xweb.util.l.a(paramString1, this);
    reportLoadByReason();
    AppMethodBeat.o(156863);
  }
  
  public void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(156871);
    this.aifw.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
    com.tencent.xweb.util.l.a(paramString1, this);
    AppMethodBeat.o(156871);
  }
  
  public void loadUrl(String paramString)
  {
    AppMethodBeat.i(156884);
    if (this.aify.bHK(paramString))
    {
      this.aifw.loadUrl("http://weixin.qq.com/");
      AppMethodBeat.o(156884);
      return;
    }
    this.aifw.loadUrl(paramString);
    com.tencent.xweb.util.l.a(paramString, this);
    reportLoadByReason();
    AppMethodBeat.o(156884);
  }
  
  public void loadUrl(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(156874);
    if (this.aify.bHK(paramString))
    {
      this.aifw.loadUrl("http://weixin.qq.com/");
      AppMethodBeat.o(156874);
      return;
    }
    Object localObject1 = null;
    Object localObject2 = null;
    if (paramMap != null)
    {
      localObject1 = localObject2;
      if (paramMap == null) {}
    }
    try
    {
      localObject1 = new HashMap();
      ((Map)localObject1).putAll(paramMap);
      this.aifw.loadUrl(paramString, (Map)localObject1);
      com.tencent.xweb.util.l.a(paramString, this);
      reportLoadByReason();
      AppMethodBeat.o(156874);
      return;
    }
    finally
    {
      AppMethodBeat.o(156874);
    }
  }
  
  @Deprecated
  public void manualStartFrameCostProfiler()
  {
    AppMethodBeat.i(156886);
    g localg = com.tencent.xweb.internal.l.d(getCurWebType());
    if (localg != null) {
      localg.khd().bHB("xprofile.frameCost");
    }
    AppMethodBeat.o(156886);
  }
  
  @Deprecated
  public void manualStopFrameCostProfiler(n paramn)
  {
    AppMethodBeat.i(156887);
    g localg = com.tencent.xweb.internal.l.d(getCurWebType());
    if (localg != null) {
      localg.khd().a(paramn);
    }
    AppMethodBeat.o(156887);
  }
  
  public void onHide()
  {
    AppMethodBeat.i(156906);
    this.aifw.onHide();
    AppMethodBeat.o(156906);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(156830);
    this.aifw.onPause();
    AppMethodBeat.o(156830);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(156829);
    this.aifw.onResume();
    AppMethodBeat.o(156829);
  }
  
  public void onShow()
  {
    AppMethodBeat.i(156905);
    this.aifw.onShow();
    AppMethodBeat.o(156905);
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    AppMethodBeat.i(156833);
    super.onVisibilityChanged(paramView, paramInt);
    if (this.aifw != null) {
      this.aifw.getView().setVisibility(paramInt);
    }
    AppMethodBeat.o(156833);
  }
  
  public void onWebViewScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public boolean overlayHorizontalScrollbar()
  {
    AppMethodBeat.i(156870);
    boolean bool = this.aifw.overlayHorizontalScrollbar();
    AppMethodBeat.o(156870);
    return bool;
  }
  
  public void reload()
  {
    AppMethodBeat.i(156861);
    this.aifw.reload();
    AppMethodBeat.o(156861);
  }
  
  public void removeJavascriptInterface(String paramString)
  {
    AppMethodBeat.i(156842);
    this.aifw.removeJavascriptInterface(paramString);
    AppMethodBeat.o(156842);
  }
  
  public void reportLoadByReason()
  {
    AppMethodBeat.i(156915);
    com.tencent.xweb.util.l.aJF(this.aifB);
    this.aifB = -1;
    AppMethodBeat.o(156915);
  }
  
  public boolean savePage(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(156898);
    boolean bool = this.aifw.savePage(paramString1, paramString2, paramInt);
    AppMethodBeat.o(156898);
    return bool;
  }
  
  public void setA8keyReason(int paramInt)
  {
    this.aifB = paramInt;
  }
  
  public void setBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(156832);
    org.xwalk.core.Log.i("WebView", "setBackgroundColor, color:" + Integer.toHexString(paramInt));
    super.setBackgroundColor(paramInt);
    if (this.aifw != null) {
      this.aifw.getWebViewUI().setBackgroundColor(paramInt);
    }
    AppMethodBeat.o(156832);
  }
  
  public void setBottomHeight(int paramInt)
  {
    AppMethodBeat.i(156904);
    this.aifw.setBottomHeight(paramInt);
    AppMethodBeat.o(156904);
  }
  
  public void setDownloadListener(DownloadListener paramDownloadListener)
  {
    AppMethodBeat.i(156882);
    this.aifw.setDownloadListener(paramDownloadListener);
    AppMethodBeat.o(156882);
  }
  
  public void setFindListener(WebView.FindListener paramFindListener)
  {
    AppMethodBeat.i(156883);
    this.aifw.setFindListener(paramFindListener);
    AppMethodBeat.o(156883);
  }
  
  public void setFocusable(boolean paramBoolean)
  {
    AppMethodBeat.i(156837);
    if (!paramBoolean)
    {
      setDescendantFocusability(393216);
      super.setFocusable(false);
      AppMethodBeat.o(156837);
      return;
    }
    setDescendantFocusability(131072);
    super.setFocusable(false);
    AppMethodBeat.o(156837);
  }
  
  public void setFocusableInTouchMode(boolean paramBoolean)
  {
    AppMethodBeat.i(156838);
    if (!paramBoolean)
    {
      setDescendantFocusability(393216);
      super.setFocusableInTouchMode(false);
      AppMethodBeat.o(156838);
      return;
    }
    setDescendantFocusability(131072);
    super.setFocusableInTouchMode(false);
    AppMethodBeat.o(156838);
  }
  
  public void setHorizontalScrollBarEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(156909);
    this.aifw.setHorizontalScrollBarEnabled(paramBoolean);
    AppMethodBeat.o(156909);
  }
  
  public void setHttpAuthUsernamePassword(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(212977);
    this.aifw.setHttpAuthUsernamePassword(paramString1, paramString2, paramString3, paramString4);
    AppMethodBeat.o(212977);
  }
  
  public void setJSExceptionListener(ai paramai)
  {
    AppMethodBeat.i(156896);
    this.aifw.setJSExceptionListener(paramai);
    AppMethodBeat.o(156896);
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    this.afTp = paramOnLongClickListener;
  }
  
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    AppMethodBeat.i(156831);
    this.aifw.getWebViewUI().setOnTouchListener(paramOnTouchListener);
    AppMethodBeat.o(156831);
  }
  
  public void setVerticalScrollBarEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(156908);
    this.aifw.setVerticalScrollBarEnabled(paramBoolean);
    AppMethodBeat.o(156908);
  }
  
  public w setVideoJsCallback(x paramx)
  {
    AppMethodBeat.i(156911);
    paramx = this.aifw.setVideoJsCallback(paramx);
    AppMethodBeat.o(156911);
    return paramx;
  }
  
  public void setWebChromeClient(z paramz)
  {
    AppMethodBeat.i(156881);
    if (paramz != null) {
      paramz.aifb = this.aifw.getDefalutOpProvider();
    }
    this.aifw.setWebChromeClient(paramz);
    AppMethodBeat.o(156881);
  }
  
  public void setWebContentsSize(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(212997);
    this.aifw.setWebContentsSize(paramInt1, paramInt2);
    AppMethodBeat.o(212997);
  }
  
  public void setWebViewCallbackClient(af paramaf)
  {
    AppMethodBeat.i(156844);
    this.aifw.setWebViewCallbackClient(paramaf);
    AppMethodBeat.o(156844);
  }
  
  public void setWebViewClient(ag paramag)
  {
    AppMethodBeat.i(156880);
    if (paramag != null) {
      paramag.a(this.aifw.getDefalutOpProvider());
    }
    this.aifw.setWebViewClient(paramag);
    AppMethodBeat.o(156880);
  }
  
  public void setWebViewClientExtension(com.tencent.xweb.x5.export.external.extension.proxy.a parama)
  {
    AppMethodBeat.i(156821);
    this.aifw.setWebViewClientExtension(parama);
    AppMethodBeat.o(156821);
  }
  
  public void setXWebKeyEventHandler(al paramal)
  {
    AppMethodBeat.i(212992);
    this.aifw.setXWebKeyEventHandler(paramal);
    AppMethodBeat.o(212992);
  }
  
  public void smoothScroll(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(156903);
    this.aifw.smoothScroll(paramInt1, paramInt2, paramLong);
    AppMethodBeat.o(156903);
  }
  
  public void startLongScreenshot(s params, boolean paramBoolean)
  {
    AppMethodBeat.i(156885);
    if (((this.aifw instanceof h)) && (this.aifx == WebViewKind.aifI)) {
      ((h)this.aifw).a(((ViewGroup)getWebViewUI()).getChildAt(0), paramBoolean, params);
    }
    AppMethodBeat.o(156885);
  }
  
  public void stopLoading()
  {
    AppMethodBeat.i(156843);
    this.aifw.stopLoading();
    AppMethodBeat.o(156843);
  }
  
  public void super_computeScroll()
  {
    AppMethodBeat.i(156826);
    this.aifw.super_computeScroll();
    AppMethodBeat.o(156826);
  }
  
  public boolean super_dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(156825);
    boolean bool = this.aifw.super_dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(156825);
    return bool;
  }
  
  public boolean super_onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(156823);
    boolean bool = this.aifw.super_onInterceptTouchEvent(paramMotionEvent);
    AppMethodBeat.o(156823);
    return bool;
  }
  
  public void super_onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(156824);
    this.aifw.super_onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(156824);
  }
  
  public void super_onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(156827);
    this.aifw.super_onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(156827);
  }
  
  public boolean super_onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(156822);
    boolean bool = this.aifw.super_onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(156822);
    return bool;
  }
  
  public boolean super_overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    AppMethodBeat.i(156828);
    paramBoolean = this.aifw.super_overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
    AppMethodBeat.o(156828);
    return paramBoolean;
  }
  
  public boolean supportFeature(int paramInt)
  {
    AppMethodBeat.i(156902);
    boolean bool = this.aifw.supportFeature(paramInt);
    AppMethodBeat.o(156902);
    return bool;
  }
  
  public boolean supportSetWebContentsSize()
  {
    AppMethodBeat.i(213007);
    boolean bool = this.aifw.supportSetWebContentsSize();
    AppMethodBeat.o(213007);
    return bool;
  }
  
  public boolean zoomIn()
  {
    AppMethodBeat.i(156873);
    boolean bool = this.aifw.zoomIn();
    AppMethodBeat.o(156873);
    return bool;
  }
  
  public boolean zoomOut()
  {
    AppMethodBeat.i(156872);
    boolean bool = this.aifw.zoomOut();
    AppMethodBeat.o(156872);
    return bool;
  }
  
  public static abstract interface PreInitCallback
  {
    public abstract void aDm();
    
    public abstract void onCoreInitFinished();
  }
  
  public static enum WebViewKind
  {
    static
    {
      AppMethodBeat.i(156805);
      aifH = new WebViewKind("WV_KIND_NONE", 0);
      aifI = new WebViewKind("WV_KIND_CW", 1);
      aifJ = new WebViewKind("WV_KIND_X5", 2);
      aifK = new WebViewKind("WV_KIND_SYS", 3);
      aifL = new WebViewKind("WV_KIND_PINUS", 4);
      aifM = new WebViewKind[] { aifH, aifI, aifJ, aifK, aifL };
      AppMethodBeat.o(156805);
    }
    
    private WebViewKind() {}
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(156802);
      aifD = new a("NOT_HOOK", 0);
      aifE = new a("HOOK_NOT_EVALUTE_JS", 1);
      aifF = new a("HOOK_EVALUTE_JS", 2);
      aifG = new a[] { aifD, aifE, aifF };
      AppMethodBeat.o(156802);
    }
    
    private a() {}
  }
  
  public static class b
  {
    public String mExtra;
    public int mType = 0;
  }
  
  public final class c
  {
    private WebView aifN;
    
    public c() {}
    
    public final WebView getWebView()
    {
      try
      {
        WebView localWebView = this.aifN;
        return localWebView;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
  }
  
  static final class d
    extends MutableContextWrapper
  {
    IWebView aifO;
    
    public d(Context paramContext)
    {
      super();
    }
    
    public final void setBaseContext(Context paramContext)
    {
      AppMethodBeat.i(156806);
      super.setBaseContext(paramContext);
      org.xwalk.core.Log.i("WebView", "setBaseContext, context:" + paramContext + ", webViewType:" + WebView.getCurWebType());
      paramContext = WebViewWrapperFactory.e(WebView.getCurWebType());
      if (paramContext != null) {
        paramContext.excute("BASE_CONTEXT_CHANGED", new Object[] { this.aifO });
      }
      AppMethodBeat.o(156806);
    }
    
    public final void unbindService(ServiceConnection paramServiceConnection)
    {
      AppMethodBeat.i(156807);
      try
      {
        super.unbindService(paramServiceConnection);
        AppMethodBeat.o(156807);
        return;
      }
      catch (IllegalArgumentException paramServiceConnection)
      {
        org.xwalk.core.Log.e("WebView", "XWebContextWrapper unbindService IllegalArgumentException:".concat(String.valueOf(paramServiceConnection)));
        AppMethodBeat.o(156807);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.WebView
 * JD-Core Version:    0.7.0.1
 */