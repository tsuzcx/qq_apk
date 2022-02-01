package com.tencent.mm.plugin.webview.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.DisplayMetrics;
import android.util.SparseBooleanArray;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.m.d.a;
import com.tencent.mm.m.d.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.webview.c.j;
import com.tencent.mm.plugin.webview.c.l.a;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.model.ax;
import com.tencent.mm.plugin.webview.model.ax.d;
import com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n.b;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.o;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.vfs.q;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class i
  extends a
{
  Set<Integer> CxA;
  ArrayList<d.b> CxB;
  Boolean CxC;
  protected Map<String, SparseBooleanArray> Cxs;
  protected Map<String, Integer> Cxt;
  af<String, Bitmap> Cxu;
  HashMap<String, String> Cxv;
  public String Cxw;
  HashMap<String, Integer> Cxx;
  public boolean Cxy;
  public boolean Cxz;
  private int height;
  private String kQX;
  com.tencent.mm.ui.widget.a.e mdB;
  public boolean nPt;
  private int width;
  
  public i(WebViewUI paramWebViewUI)
  {
    super(paramWebViewUI);
    AppMethodBeat.i(79877);
    this.Cxs = new HashMap();
    this.Cxt = new HashMap();
    this.Cxu = new af(12);
    this.Cxv = new HashMap();
    this.kQX = "";
    this.Cxx = new HashMap();
    this.Cxy = true;
    this.Cxz = false;
    this.nPt = false;
    this.CxA = new HashSet();
    this.width = paramWebViewUI.getResources().getDisplayMetrics().widthPixels;
    this.height = paramWebViewUI.getResources().getDisplayMetrics().heightPixels;
    AppMethodBeat.o(79877);
  }
  
  private void VG(int paramInt)
  {
    AppMethodBeat.i(79891);
    String str2 = eCT().aAP(eCT().eDS());
    if ((TextUtils.isEmpty(eCT().eDS())) || (TextUtils.isEmpty(str2)))
    {
      ac.i("MicroMsg.WebViewMenuHelper", "stev appId is null or empty");
      AppMethodBeat.o(79891);
      return;
    }
    ac.i("MicroMsg.WebViewMenuHelper", "stev appId %s", new Object[] { str2 });
    long l = bs.aNx();
    ac.d("MicroMsg.WebViewMenuHelper", "stev report(%s), clickTimestamp : %d, appID : %s, url : %s, sessionId : %s, actionType : %d, flag : %d", new Object[] { Integer.valueOf(13377), Long.valueOf(l), str2, eCT().eDS(), eCT().sessionId, Integer.valueOf(3), Integer.valueOf(paramInt) });
    Object localObject = "";
    try
    {
      str1 = p.encode(eCT().eDS(), "UTF-8");
      localObject = str1;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        String str1;
        int i;
        ac.printErrStackTrace("MicroMsg.WebViewMenuHelper", localUnsupportedEncodingException, "", new Object[0]);
      }
    }
    i = eCT().aAT(eCT().getIntent().getStringExtra("geta8key_username"));
    str1 = "";
    if ((i == 7) || (i == 56)) {
      str1 = eCT().getIntent().getStringExtra("geta8key_username");
    }
    com.tencent.mm.plugin.report.service.h.wUl.f(13377, new Object[] { Long.valueOf(l), str2, localObject, eCT().sessionId, Integer.valueOf(3), Integer.valueOf(paramInt), Integer.valueOf(0), str1 });
    AppMethodBeat.o(79891);
  }
  
  protected static boolean a(JsapiPermissionWrapper paramJsapiPermissionWrapper, int paramInt)
  {
    AppMethodBeat.i(79882);
    if (paramJsapiPermissionWrapper == null)
    {
      AppMethodBeat.o(79882);
      return false;
    }
    paramInt = paramJsapiPermissionWrapper.XF(paramInt);
    if ((paramInt == 1) || (paramInt == 10))
    {
      AppMethodBeat.o(79882);
      return true;
    }
    AppMethodBeat.o(79882);
    return false;
  }
  
  protected static boolean b(JsapiPermissionWrapper paramJsapiPermissionWrapper, int paramInt)
  {
    AppMethodBeat.i(79883);
    if (paramJsapiPermissionWrapper == null)
    {
      AppMethodBeat.o(79883);
      return false;
    }
    if (paramJsapiPermissionWrapper.XF(paramInt) == 10)
    {
      AppMethodBeat.o(79883);
      return true;
    }
    AppMethodBeat.o(79883);
    return false;
  }
  
  private ArrayList<d.b> eDp()
  {
    AppMethodBeat.i(79888);
    Object localObject = eCT().nKq.getUrl();
    if (eCT().CzL.containsKey(localObject))
    {
      localObject = (ArrayList)eCT().CzL.get(localObject);
      AppMethodBeat.o(79888);
      return localObject;
    }
    AppMethodBeat.o(79888);
    return null;
  }
  
  private int eDv()
  {
    AppMethodBeat.i(79901);
    if ((eCT() == null) || (eCT().kYu == null))
    {
      ac.e("MicroMsg.WebViewMenuHelper", "getShareFuncFlag params failed");
      AppMethodBeat.o(79901);
      return -1;
    }
    JsapiPermissionWrapper localJsapiPermissionWrapper = eCT().kYu.eCm();
    if (a(localJsapiPermissionWrapper, 21, 1)) {}
    for (int i = 1;; i = 0)
    {
      int j = i;
      if (a(localJsapiPermissionWrapper, 23, 2)) {
        j = i | 0x2;
      }
      ac.i("MicroMsg.WebViewMenuHelper", "getShareFuncFlag %d", new Object[] { Integer.valueOf(j) });
      AppMethodBeat.o(79901);
      return j;
    }
  }
  
  private void gJ(List<String> paramList)
  {
    AppMethodBeat.i(79894);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(79894);
      return;
    }
    Iterator localIterator = paramList.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label308;
      }
      String str2 = (String)localIterator.next();
      if (this.Cxu.get(str2) != null) {
        ac.i("MicroMsg.WebViewMenuHelper", "find %s icon from cache ok", new Object[] { str2 });
      }
      for (;;)
      {
        if (!this.Cxv.containsKey(str2)) {
          break label216;
        }
        ac.i("MicroMsg.WebViewMenuHelper", "find %s nick from cache ok", new Object[] { str2 });
        break;
        ac.w("MicroMsg.WebViewMenuHelper", "not found %s icon from cache, try to load", new Object[] { str2 });
        try
        {
          paramList = eCT().Cfr.kYt.aCP(str2);
          if (!bs.isNullOrNil(paramList))
          {
            paramList = e.aDe(paramList);
            if (paramList != null)
            {
              ac.i("MicroMsg.WebViewMenuHelper", "load ok, and cache it");
              this.Cxu.put(str2, paramList);
            }
          }
        }
        catch (Exception paramList)
        {
          ac.w("MicroMsg.WebViewMenuHelper", "getheadimg, ex = " + paramList.getMessage());
        }
      }
      label216:
      ac.w("MicroMsg.WebViewMenuHelper", "not found %s nick from cache, try to load", new Object[] { str2 });
      paramList = null;
      try
      {
        String str1 = eCT().Cfr.kYt.wk(str2);
        paramList = str1;
        ac.i("MicroMsg.WebViewMenuHelper", "load nick ok");
        paramList = str1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ac.w("MicroMsg.WebViewMenuHelper", "onAttach, ex = " + localException.getMessage());
        }
      }
      this.Cxv.put(str2, paramList);
    }
    label308:
    AppMethodBeat.o(79894);
  }
  
  protected final boolean VF(int paramInt)
  {
    AppMethodBeat.i(79881);
    SparseBooleanArray localSparseBooleanArray = (SparseBooleanArray)this.Cxs.get(eCT().nKq.getUrl());
    if ((localSparseBooleanArray != null) && (localSparseBooleanArray.get(paramInt, false)))
    {
      AppMethodBeat.o(79881);
      return false;
    }
    AppMethodBeat.o(79881);
    return true;
  }
  
  public final void WT()
  {
    AppMethodBeat.i(79885);
    if (this.nPt) {
      bMr();
    }
    AppMethodBeat.o(79885);
  }
  
  protected final boolean a(JsapiPermissionWrapper paramJsapiPermissionWrapper, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(79902);
    if (paramJsapiPermissionWrapper == null)
    {
      AppMethodBeat.o(79902);
      return false;
    }
    if ((paramJsapiPermissionWrapper.XF(paramInt1) == 1) && (VF(paramInt2)))
    {
      AppMethodBeat.o(79902);
      return true;
    }
    AppMethodBeat.o(79902);
    return false;
  }
  
  final void aDl(String paramString)
  {
    AppMethodBeat.i(79889);
    eCT().Cjc.cf("sendAppMessage", false);
    com.tencent.mm.plugin.webview.c.f localf = eCT().Cjc;
    if (!localf.Apr)
    {
      ac.e("MicroMsg.JsApiHandler", "onSendToEnterprise fail, not ready");
      AppMethodBeat.o(79889);
      return;
    }
    Object localObject = new HashMap();
    ((HashMap)localObject).put("scene", "enterprise");
    localObject = l.a.b("menu:share:appmessage", (Map)localObject, localf.Cjz, localf.CjA);
    localf.Cjr.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + (String)localObject + ")", null);
    try
    {
      localf.kYt.ac("connector_local_send", paramString, localf.CjB);
      localf.kYt.ac("scene", "enterprise", localf.CjB);
      AppMethodBeat.o(79889);
      return;
    }
    catch (Exception paramString)
    {
      ac.w("MicroMsg.JsApiHandler", "jsapiBundlePutString, ex = " + paramString.getMessage());
      AppMethodBeat.o(79889);
    }
  }
  
  /* Error */
  protected final void aDm(String paramString)
  {
    // Byte code:
    //   0: ldc_w 835
    //   3: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokevirtual 220	com/tencent/mm/plugin/webview/ui/tools/a:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   10: invokevirtual 224	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   13: ldc 226
    //   15: invokevirtual 231	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   18: astore 7
    //   20: aload_0
    //   21: invokevirtual 156	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   24: invokevirtual 470	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:eyJ	()Ljava/lang/String;
    //   27: astore 8
    //   29: aconst_null
    //   30: astore 4
    //   32: aload 8
    //   34: invokestatic 439	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
    //   37: ifne +13 -> 50
    //   40: aload 8
    //   42: invokestatic 598	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   45: invokevirtual 838	android/net/Uri:getHost	()Ljava/lang/String;
    //   48: astore 4
    //   50: aload 4
    //   52: invokestatic 439	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
    //   55: ifne +495 -> 550
    //   58: aload 4
    //   60: ldc_w 840
    //   63: invokevirtual 843	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   66: ifeq +484 -> 550
    //   69: ldc_w 845
    //   72: iconst_1
    //   73: anewarray 183	java/lang/Object
    //   76: dup
    //   77: iconst_0
    //   78: aload 8
    //   80: ldc_w 588
    //   83: invokestatic 219	com/tencent/mm/compatible/util/p:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   86: aastore
    //   87: invokestatic 849	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   90: astore 4
    //   92: aload_0
    //   93: invokevirtual 156	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   96: aload_0
    //   97: invokevirtual 156	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   100: getfield 442	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:nKq	Lcom/tencent/mm/ui/widget/MMWebView;
    //   103: invokevirtual 445	com/tencent/mm/ui/widget/MMWebView:getUrl	()Ljava/lang/String;
    //   106: invokevirtual 164	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:aAP	(Ljava/lang/String;)Ljava/lang/String;
    //   109: astore 9
    //   111: ldc 172
    //   113: ldc_w 851
    //   116: iconst_1
    //   117: anewarray 183	java/lang/Object
    //   120: dup
    //   121: iconst_0
    //   122: getstatic 854	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   125: aastore
    //   126: invokestatic 211	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   129: aload 9
    //   131: invokestatic 170	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   134: ifne +175 -> 309
    //   137: aload_0
    //   138: invokevirtual 156	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   141: getfield 442	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:nKq	Lcom/tencent/mm/ui/widget/MMWebView;
    //   144: invokevirtual 445	com/tencent/mm/ui/widget/MMWebView:getUrl	()Ljava/lang/String;
    //   147: invokestatic 170	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   150: ifne +159 -> 309
    //   153: invokestatic 192	com/tencent/mm/sdk/platformtools/bs:aNx	()J
    //   156: lstore_2
    //   157: ldc 172
    //   159: ldc_w 856
    //   162: bipush 7
    //   164: anewarray 183	java/lang/Object
    //   167: dup
    //   168: iconst_0
    //   169: sipush 13377
    //   172: invokestatic 200	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   175: aastore
    //   176: dup
    //   177: iconst_1
    //   178: lload_2
    //   179: invokestatic 205	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   182: aastore
    //   183: dup
    //   184: iconst_2
    //   185: aload 9
    //   187: aastore
    //   188: dup
    //   189: iconst_3
    //   190: aload_0
    //   191: invokevirtual 156	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   194: getfield 442	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:nKq	Lcom/tencent/mm/ui/widget/MMWebView;
    //   197: invokevirtual 445	com/tencent/mm/ui/widget/MMWebView:getUrl	()Ljava/lang/String;
    //   200: aastore
    //   201: dup
    //   202: iconst_4
    //   203: aload_0
    //   204: invokevirtual 156	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   207: getfield 208	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:sessionId	Ljava/lang/String;
    //   210: aastore
    //   211: dup
    //   212: iconst_5
    //   213: iconst_4
    //   214: invokestatic 200	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   217: aastore
    //   218: dup
    //   219: bipush 6
    //   221: iconst_1
    //   222: invokestatic 200	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   225: aastore
    //   226: invokestatic 211	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   229: ldc 105
    //   231: astore 5
    //   233: aload_0
    //   234: invokevirtual 156	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   237: getfield 442	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:nKq	Lcom/tencent/mm/ui/widget/MMWebView;
    //   240: invokevirtual 445	com/tencent/mm/ui/widget/MMWebView:getUrl	()Ljava/lang/String;
    //   243: ldc 213
    //   245: invokestatic 219	com/tencent/mm/compatible/util/p:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   248: astore 6
    //   250: aload 6
    //   252: astore 5
    //   254: getstatic 241	com/tencent/mm/plugin/report/service/h:wUl	Lcom/tencent/mm/plugin/report/service/h;
    //   257: sipush 13377
    //   260: bipush 6
    //   262: anewarray 183	java/lang/Object
    //   265: dup
    //   266: iconst_0
    //   267: lload_2
    //   268: invokestatic 205	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   271: aastore
    //   272: dup
    //   273: iconst_1
    //   274: aload 9
    //   276: aastore
    //   277: dup
    //   278: iconst_2
    //   279: aload 5
    //   281: aastore
    //   282: dup
    //   283: iconst_3
    //   284: aload_0
    //   285: invokevirtual 156	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   288: getfield 208	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:sessionId	Ljava/lang/String;
    //   291: aastore
    //   292: dup
    //   293: iconst_4
    //   294: iconst_4
    //   295: invokestatic 200	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   298: aastore
    //   299: dup
    //   300: iconst_5
    //   301: iconst_1
    //   302: invokestatic 200	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   305: aastore
    //   306: invokevirtual 245	com/tencent/mm/plugin/report/service/h:f	(I[Ljava/lang/Object;)V
    //   309: aload 4
    //   311: astore 5
    //   313: aload 4
    //   315: invokestatic 439	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
    //   318: ifeq +23 -> 341
    //   321: ldc_w 858
    //   324: iconst_1
    //   325: anewarray 183	java/lang/Object
    //   328: dup
    //   329: iconst_0
    //   330: bipush 34
    //   332: invokestatic 200	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   335: aastore
    //   336: invokestatic 849	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   339: astore 5
    //   341: new 228	android/content/Intent
    //   344: dup
    //   345: invokespecial 859	android/content/Intent:<init>	()V
    //   348: astore 4
    //   350: aload_1
    //   351: invokestatic 439	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
    //   354: ifne +23 -> 377
    //   357: aload 4
    //   359: ldc_w 861
    //   362: aload_1
    //   363: ldc 213
    //   365: invokevirtual 865	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   368: bipush 11
    //   370: invokestatic 871	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   373: invokevirtual 875	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   376: pop
    //   377: ldc 172
    //   379: ldc_w 877
    //   382: iconst_2
    //   383: anewarray 183	java/lang/Object
    //   386: dup
    //   387: iconst_0
    //   388: aload 8
    //   390: aastore
    //   391: dup
    //   392: iconst_1
    //   393: aload_0
    //   394: invokevirtual 156	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   397: invokevirtual 584	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bLL	()Ljava/lang/String;
    //   400: aastore
    //   401: invokestatic 186	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   404: aload 4
    //   406: ldc_w 879
    //   409: aload 5
    //   411: invokevirtual 875	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   414: pop
    //   415: aload 4
    //   417: ldc_w 881
    //   420: aload 8
    //   422: invokevirtual 875	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   425: pop
    //   426: aload 4
    //   428: ldc_w 883
    //   431: aload_0
    //   432: invokevirtual 156	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   435: invokevirtual 584	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bLL	()Ljava/lang/String;
    //   438: invokevirtual 875	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   441: pop
    //   442: aload 4
    //   444: ldc_w 885
    //   447: aload_0
    //   448: invokevirtual 156	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   451: aload 7
    //   453: invokevirtual 235	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:aAT	(Ljava/lang/String;)I
    //   456: invokevirtual 888	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   459: pop
    //   460: aload 4
    //   462: ldc_w 890
    //   465: iconst_1
    //   466: invokevirtual 893	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   469: pop
    //   470: aload_0
    //   471: invokevirtual 156	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   474: aload_0
    //   475: invokevirtual 156	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   478: ldc_w 894
    //   481: invokevirtual 286	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
    //   484: ldc 105
    //   486: aload_0
    //   487: invokevirtual 156	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   490: ldc_w 895
    //   493: invokevirtual 286	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
    //   496: aload_0
    //   497: invokevirtual 156	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   500: ldc_w 896
    //   503: invokevirtual 286	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
    //   506: iconst_0
    //   507: new 34	com/tencent/mm/plugin/webview/ui/tools/i$5
    //   510: dup
    //   511: aload_0
    //   512: aload 4
    //   514: invokespecial 899	com/tencent/mm/plugin/webview/ui/tools/i$5:<init>	(Lcom/tencent/mm/plugin/webview/ui/tools/i;Landroid/content/Intent;)V
    //   517: new 36	com/tencent/mm/plugin/webview/ui/tools/i$6
    //   520: dup
    //   521: aload_0
    //   522: aload 4
    //   524: invokespecial 900	com/tencent/mm/plugin/webview/ui/tools/i$6:<init>	(Lcom/tencent/mm/plugin/webview/ui/tools/i;Landroid/content/Intent;)V
    //   527: invokestatic 903	com/tencent/mm/ui/base/h:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLandroid/content/DialogInterface$OnClickListener;Landroid/content/DialogInterface$OnClickListener;)Lcom/tencent/mm/ui/widget/a/d;
    //   530: pop
    //   531: ldc_w 835
    //   534: invokestatic 147	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   537: return
    //   538: astore 4
    //   540: ldc 172
    //   542: aload 4
    //   544: invokevirtual 904	java/io/UnsupportedEncodingException:getMessage	()Ljava/lang/String;
    //   547: invokestatic 300	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   550: aconst_null
    //   551: astore 4
    //   553: goto -461 -> 92
    //   556: astore 6
    //   558: ldc 172
    //   560: aload 6
    //   562: ldc 105
    //   564: iconst_0
    //   565: anewarray 183	java/lang/Object
    //   568: invokestatic 249	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   571: goto -317 -> 254
    //   574: astore_1
    //   575: ldc 172
    //   577: new 409	java/lang/StringBuilder
    //   580: dup
    //   581: ldc_w 906
    //   584: invokespecial 413	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   587: aload_1
    //   588: invokevirtual 904	java/io/UnsupportedEncodingException:getMessage	()Ljava/lang/String;
    //   591: invokevirtual 417	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   594: invokevirtual 422	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   597: invokestatic 300	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   600: goto -223 -> 377
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	603	0	this	i
    //   0	603	1	paramString	String
    //   156	112	2	l	long
    //   30	493	4	localObject1	Object
    //   538	5	4	localUnsupportedEncodingException1	UnsupportedEncodingException
    //   551	1	4	localObject2	Object
    //   231	179	5	localObject3	Object
    //   248	3	6	str1	String
    //   556	5	6	localUnsupportedEncodingException2	UnsupportedEncodingException
    //   18	434	7	str2	String
    //   27	394	8	str3	String
    //   109	166	9	str4	String
    // Exception table:
    //   from	to	target	type
    //   69	92	538	java/io/UnsupportedEncodingException
    //   233	250	556	java/io/UnsupportedEncodingException
    //   357	377	574	java/io/UnsupportedEncodingException
  }
  
  protected final void bHN()
  {
    AppMethodBeat.i(79897);
    String str1 = eCT().aAP(eCT().eDS());
    String str2 = eCT().getIntent().getStringExtra("shortcut_user_name");
    if ((bs.isNullOrNil(str1)) || (bs.isNullOrNil(str2)))
    {
      ac.e("MicroMsg.WebViewMenuHelper", "addShortcut, appid or username is null");
      AppMethodBeat.o(79897);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("KAppId", str1);
    localBundle.putString("shortcut_user_name", str2);
    localBundle.putInt("webviewui_binder_id", hashCode());
    try
    {
      eCT().Cfr.kYt.k(80, localBundle);
      AppMethodBeat.o(79897);
      return;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.WebViewMenuHelper", "addShortcut, e = " + localException.getMessage());
      AppMethodBeat.o(79897);
    }
  }
  
  protected final void bMr()
  {
    AppMethodBeat.i(79887);
    this.CxB = eDp();
    if ((this.CxB != null) && (this.CxB.size() > 0))
    {
      bool = true;
      this.CxC = Boolean.valueOf(bool);
      if (!this.nPt) {
        if (!this.CxC.booleanValue()) {
          break label167;
        }
      }
    }
    label167:
    for (this.mdB = new com.tencent.mm.ui.widget.a.e(eCT(), 1, false);; this.mdB = new com.tencent.mm.ui.widget.a.e(eCT(), 0, true))
    {
      this.mdB.ISy = new com.tencent.mm.ui.base.n.a()
      {
        public final void a(ImageView paramAnonymousImageView, MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(79858);
          if (i.e(paramAnonymousMenuItem))
          {
            paramAnonymousImageView.setVisibility(8);
            AppMethodBeat.o(79858);
            return;
          }
          paramAnonymousMenuItem = paramAnonymousMenuItem.getTitle();
          if ((i.this.Cxu.get(paramAnonymousMenuItem) != null) && (!((Bitmap)i.this.Cxu.get(paramAnonymousMenuItem)).isRecycled()))
          {
            paramAnonymousImageView.setImageBitmap((Bitmap)i.this.Cxu.get(paramAnonymousMenuItem));
            AppMethodBeat.o(79858);
            return;
          }
          ac.w("MicroMsg.WebViewMenuHelper", "on attach icon, load from cache fail");
          try
          {
            Object localObject = i.this.eCT().Cfr.kYt.aCP(paramAnonymousMenuItem);
            if (!bs.isNullOrNil((String)localObject))
            {
              localObject = e.aDe((String)localObject);
              if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
              {
                paramAnonymousImageView.setImageBitmap((Bitmap)localObject);
                i.this.Cxu.put(paramAnonymousMenuItem, localObject);
              }
            }
            AppMethodBeat.o(79858);
            return;
          }
          catch (Exception paramAnonymousImageView)
          {
            ac.w("MicroMsg.WebViewMenuHelper", "getheadimg, ex = " + paramAnonymousImageView.getMessage());
            AppMethodBeat.o(79858);
          }
        }
      };
      this.mdB.ISz = new n.b()
      {
        public final void a(TextView paramAnonymousTextView, MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(79869);
          paramAnonymousMenuItem = paramAnonymousMenuItem.getTitle();
          if (paramAnonymousTextView != null)
          {
            String str = (String)i.this.Cxv.get(paramAnonymousMenuItem);
            if (bs.isNullOrNil(str))
            {
              paramAnonymousTextView.setText(paramAnonymousMenuItem);
              AppMethodBeat.o(79869);
              return;
            }
            paramAnonymousTextView.setText(k.b(i.this.eCT(), str, paramAnonymousTextView.getTextSize()));
          }
          AppMethodBeat.o(79869);
        }
      };
      localObject2 = new n.d()
      {
        /* Error */
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          // Byte code:
          //   0: iconst_0
          //   1: istore_2
          //   2: ldc 27
          //   4: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
          //   7: aload_0
          //   8: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   11: iconst_0
          //   12: putfield 37	com/tencent/mm/plugin/webview/ui/tools/i:nPt	Z
          //   15: aload_1
          //   16: invokestatic 41	com/tencent/mm/plugin/webview/ui/tools/i:e	(Landroid/view/MenuItem;)Z
          //   19: ifeq +145 -> 164
          //   22: aload_1
          //   23: invokeinterface 47 1 0
          //   28: checkcast 49	com/tencent/mm/m/d$b
          //   31: astore 4
          //   33: aload 4
          //   35: ifnull +123 -> 158
          //   38: aload_0
          //   39: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   42: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   45: getfield 59	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Cjc	Lcom/tencent/mm/plugin/webview/c/f;
          //   48: astore_1
          //   49: aload_1
          //   50: getfield 64	com/tencent/mm/plugin/webview/c/f:Apr	Z
          //   53: ifne +16 -> 69
          //   56: ldc 66
          //   58: ldc 68
          //   60: invokestatic 73	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   63: ldc 27
          //   65: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   68: return
          //   69: ldc 66
          //   71: ldc 78
          //   73: invokestatic 80	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
          //   76: new 82	java/util/HashMap
          //   79: dup
          //   80: invokespecial 83	java/util/HashMap:<init>	()V
          //   83: astore 5
          //   85: aload 5
          //   87: ldc 85
          //   89: aload 4
          //   91: getfield 88	com/tencent/mm/m/d$b:key	Ljava/lang/String;
          //   94: invokevirtual 92	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
          //   97: pop
          //   98: aload 5
          //   100: ldc 94
          //   102: aload 4
          //   104: getfield 96	com/tencent/mm/m/d$b:title	Ljava/lang/String;
          //   107: invokevirtual 92	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
          //   110: pop
          //   111: ldc 98
          //   113: aload 5
          //   115: aload_1
          //   116: getfield 101	com/tencent/mm/plugin/webview/c/f:Cjz	Z
          //   119: aload_1
          //   120: getfield 104	com/tencent/mm/plugin/webview/c/f:CjA	Ljava/lang/String;
          //   123: invokestatic 110	com/tencent/mm/plugin/webview/c/l$a:b	(Ljava/lang/String;Ljava/util/Map;ZLjava/lang/String;)Ljava/lang/String;
          //   126: astore 4
          //   128: aload_1
          //   129: getfield 114	com/tencent/mm/plugin/webview/c/f:Cjr	Lcom/tencent/mm/ui/widget/MMWebView;
          //   132: new 116	java/lang/StringBuilder
          //   135: dup
          //   136: ldc 118
          //   138: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   141: aload 4
          //   143: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   146: ldc 127
          //   148: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   151: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   154: aconst_null
          //   155: invokevirtual 137	com/tencent/mm/ui/widget/MMWebView:evaluateJavascript	(Ljava/lang/String;Landroid/webkit/ValueCallback;)V
          //   158: ldc 27
          //   160: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   163: return
          //   164: ldc 139
          //   166: ldc 141
          //   168: iconst_1
          //   169: anewarray 4	java/lang/Object
          //   172: dup
          //   173: iconst_0
          //   174: aload_1
          //   175: invokeinterface 145 1 0
          //   180: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   183: aastore
          //   184: invokestatic 154	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   187: aload_1
          //   188: invokeinterface 145 1 0
          //   193: lookupswitch	default:+315->508, 1:+564->757, 2:+796->989, 3:+1111->1304, 5:+1188->1381, 6:+1567->1760, 7:+1630->1823, 8:+2070->2263, 9:+2228->2421, 10:+2328->2521, 11:+1322->1515, 12:+2393->2586, 15:+2524->2717, 16:+2589->2782, 17:+2654->2847, 18:+2719->2912, 19:+2784->2977, 20:+3122->3315, 21:+3319->3512, 22:+3477->3670, 23:+695->888, 24:+3883->4076, 25:+2849->3042, 26:+3058->3251, 27:+484->677, 28:+1500->1693, 29:+3947->4140, 31:+4011->4204, 33:+3674->3867, 34:+4135->4328, 35:+4233->4426, 36:+4304->4497, 37:+2006->2199, 38:+981->1174, 39:+1046->1239, 40:+4442->4635, 41:+4442->4635, 42:+4442->4635, 99:+4375->4568
          //   509: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   512: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   515: getfield 158	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Cfc	Lcom/tencent/mm/plugin/webview/model/ax;
          //   518: invokevirtual 164	com/tencent/mm/plugin/webview/model/ax:eBM	()Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   521: iconst_3
          //   522: anewarray 4	java/lang/Object
          //   525: dup
          //   526: iconst_0
          //   527: aload_0
          //   528: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   531: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   534: invokevirtual 167	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bLL	()Ljava/lang/String;
          //   537: aastore
          //   538: dup
          //   539: iconst_1
          //   540: bipush 16
          //   542: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   545: aastore
          //   546: dup
          //   547: iconst_2
          //   548: iconst_1
          //   549: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   552: aastore
          //   553: invokevirtual 173	com/tencent/mm/plugin/webview/model/ax$d:B	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   556: invokevirtual 176	com/tencent/mm/plugin/webview/model/ax$d:report	()V
          //   559: new 116	java/lang/StringBuilder
          //   562: dup
          //   563: invokespecial 177	java/lang/StringBuilder:<init>	()V
          //   566: aload_1
          //   567: invokeinterface 181 1 0
          //   572: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
          //   575: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   578: astore 4
          //   580: aload 4
          //   582: invokestatic 190	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
          //   585: ifne +4295 -> 4880
          //   588: new 192	android/os/Bundle
          //   591: dup
          //   592: invokespecial 193	android/os/Bundle:<init>	()V
          //   595: astore_1
          //   596: aload_1
          //   597: ldc 195
          //   599: aload 4
          //   601: invokevirtual 198	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
          //   604: aload_0
          //   605: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   608: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   611: getfield 202	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Cfr	Lcom/tencent/mm/plugin/webview/core/h;
          //   614: getfield 208	com/tencent/mm/plugin/webview/core/h:kYt	Lcom/tencent/mm/plugin/webview/stub/e;
          //   617: bipush 50
          //   619: aload_1
          //   620: invokeinterface 214 3 0
          //   625: astore_1
          //   626: aload_1
          //   627: ifnull +4263 -> 4890
          //   630: aload_1
          //   631: ldc 216
          //   633: invokevirtual 220	android/os/Bundle:getInt	(Ljava/lang/String;)I
          //   636: istore_2
          //   637: iload_2
          //   638: iconst_2
          //   639: if_icmpne +4026 -> 4665
          //   642: iconst_1
          //   643: istore_2
          //   644: aload_1
          //   645: ldc 216
          //   647: invokevirtual 220	android/os/Bundle:getInt	(Ljava/lang/String;)I
          //   650: istore_3
          //   651: iload_3
          //   652: iconst_3
          //   653: if_icmpne +4017 -> 4670
          //   656: iconst_1
          //   657: istore_2
          //   658: iload_2
          //   659: ifeq +4035 -> 4694
          //   662: aload_0
          //   663: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   666: aload 4
          //   668: invokevirtual 223	com/tencent/mm/plugin/webview/ui/tools/i:aDl	(Ljava/lang/String;)V
          //   671: ldc 27
          //   673: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   676: return
          //   677: aload_0
          //   678: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   681: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   684: getfield 158	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Cfc	Lcom/tencent/mm/plugin/webview/model/ax;
          //   687: invokevirtual 164	com/tencent/mm/plugin/webview/model/ax:eBM	()Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   690: iconst_3
          //   691: anewarray 4	java/lang/Object
          //   694: dup
          //   695: iconst_0
          //   696: aload_0
          //   697: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   700: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   703: invokevirtual 167	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bLL	()Ljava/lang/String;
          //   706: aastore
          //   707: dup
          //   708: iconst_1
          //   709: bipush 32
          //   711: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   714: aastore
          //   715: dup
          //   716: iconst_2
          //   717: iconst_1
          //   718: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   721: aastore
          //   722: invokevirtual 173	com/tencent/mm/plugin/webview/model/ax$d:B	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   725: invokevirtual 176	com/tencent/mm/plugin/webview/model/ax$d:report	()V
          //   728: aload_0
          //   729: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   732: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   735: invokevirtual 227	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:eAn	()Z
          //   738: ifne +4142 -> 4880
          //   741: aload_0
          //   742: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   745: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   748: invokevirtual 230	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:finish	()V
          //   751: ldc 27
          //   753: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   756: return
          //   757: aload_0
          //   758: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   761: invokevirtual 233	com/tencent/mm/plugin/webview/ui/tools/a:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   764: invokevirtual 237	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
          //   767: ldc 239
          //   769: invokevirtual 245	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
          //   772: astore_1
          //   773: aload_0
          //   774: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   777: invokevirtual 233	com/tencent/mm/plugin/webview/ui/tools/a:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   780: invokevirtual 237	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
          //   783: ldc 247
          //   785: invokevirtual 245	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
          //   788: astore 4
          //   790: aload_0
          //   791: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   794: invokevirtual 233	com/tencent/mm/plugin/webview/ui/tools/a:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   797: invokevirtual 237	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
          //   800: ldc 249
          //   802: invokevirtual 245	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
          //   805: astore 5
          //   807: aload_0
          //   808: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   811: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   814: getfield 158	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Cfc	Lcom/tencent/mm/plugin/webview/model/ax;
          //   817: invokevirtual 164	com/tencent/mm/plugin/webview/model/ax:eBM	()Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   820: bipush 6
          //   822: anewarray 4	java/lang/Object
          //   825: dup
          //   826: iconst_0
          //   827: aload_0
          //   828: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   831: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   834: invokevirtual 167	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bLL	()Ljava/lang/String;
          //   837: aastore
          //   838: dup
          //   839: iconst_1
          //   840: iconst_1
          //   841: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   844: aastore
          //   845: dup
          //   846: iconst_2
          //   847: iconst_1
          //   848: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   851: aastore
          //   852: dup
          //   853: iconst_3
          //   854: aload_1
          //   855: aastore
          //   856: dup
          //   857: iconst_4
          //   858: aload 4
          //   860: aastore
          //   861: dup
          //   862: iconst_5
          //   863: aload 5
          //   865: aastore
          //   866: invokevirtual 173	com/tencent/mm/plugin/webview/model/ax$d:B	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   869: invokevirtual 176	com/tencent/mm/plugin/webview/model/ax$d:report	()V
          //   872: aload_0
          //   873: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   876: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   879: invokevirtual 252	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:dFh	()V
          //   882: ldc 27
          //   884: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   887: return
          //   888: new 241	android/content/Intent
          //   891: dup
          //   892: invokespecial 253	android/content/Intent:<init>	()V
          //   895: astore_1
          //   896: aload_0
          //   897: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   900: invokevirtual 233	com/tencent/mm/plugin/webview/ui/tools/a:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   903: invokevirtual 237	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
          //   906: ldc 255
          //   908: invokevirtual 245	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
          //   911: astore 4
          //   913: aload 4
          //   915: ifnull +41 -> 956
          //   918: aload_1
          //   919: ldc_w 257
          //   922: iconst_1
          //   923: invokevirtual 261	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
          //   926: pop
          //   927: aload_1
          //   928: ldc 255
          //   930: aload 4
          //   932: invokevirtual 264	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
          //   935: pop
          //   936: aload_0
          //   937: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   940: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   943: ldc_w 266
          //   946: aload_1
          //   947: invokestatic 271	com/tencent/mm/br/d:e	(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;)V
          //   950: ldc 27
          //   952: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   955: return
          //   956: aload_1
          //   957: ldc_w 273
          //   960: aload_0
          //   961: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   964: invokevirtual 233	com/tencent/mm/plugin/webview/ui/tools/a:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   967: invokevirtual 237	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
          //   970: ldc_w 275
          //   973: ldc2_w 276
          //   976: invokevirtual 281	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
          //   979: invokestatic 286	java/lang/Long:valueOf	(J)Ljava/lang/Long;
          //   982: invokevirtual 289	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;
          //   985: pop
          //   986: goto -50 -> 936
          //   989: aload_0
          //   990: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   993: invokevirtual 233	com/tencent/mm/plugin/webview/ui/tools/a:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   996: invokevirtual 237	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
          //   999: ldc 239
          //   1001: invokevirtual 245	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
          //   1004: astore_1
          //   1005: aload_0
          //   1006: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1009: invokevirtual 233	com/tencent/mm/plugin/webview/ui/tools/a:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1012: invokevirtual 237	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
          //   1015: ldc 247
          //   1017: invokevirtual 245	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
          //   1020: astore 4
          //   1022: aload_0
          //   1023: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1026: invokevirtual 233	com/tencent/mm/plugin/webview/ui/tools/a:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1029: invokevirtual 237	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
          //   1032: ldc 249
          //   1034: invokevirtual 245	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
          //   1037: astore 5
          //   1039: aload_0
          //   1040: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1043: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1046: getfield 158	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Cfc	Lcom/tencent/mm/plugin/webview/model/ax;
          //   1049: invokevirtual 164	com/tencent/mm/plugin/webview/model/ax:eBM	()Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   1052: bipush 6
          //   1054: anewarray 4	java/lang/Object
          //   1057: dup
          //   1058: iconst_0
          //   1059: aload_0
          //   1060: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1063: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1066: invokevirtual 167	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bLL	()Ljava/lang/String;
          //   1069: aastore
          //   1070: dup
          //   1071: iconst_1
          //   1072: iconst_2
          //   1073: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1076: aastore
          //   1077: dup
          //   1078: iconst_2
          //   1079: iconst_1
          //   1080: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1083: aastore
          //   1084: dup
          //   1085: iconst_3
          //   1086: aload_1
          //   1087: aastore
          //   1088: dup
          //   1089: iconst_4
          //   1090: aload 4
          //   1092: aastore
          //   1093: dup
          //   1094: iconst_5
          //   1095: aload 5
          //   1097: aastore
          //   1098: invokevirtual 173	com/tencent/mm/plugin/webview/model/ax$d:B	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   1101: invokevirtual 176	com/tencent/mm/plugin/webview/model/ax$d:report	()V
          //   1104: aload_0
          //   1105: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1108: getfield 293	com/tencent/mm/plugin/webview/ui/tools/i:Cxx	Ljava/util/HashMap;
          //   1111: aload_0
          //   1112: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1115: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1118: getfield 296	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:nKq	Lcom/tencent/mm/ui/widget/MMWebView;
          //   1121: invokevirtual 299	com/tencent/mm/ui/widget/MMWebView:getUrl	()Ljava/lang/String;
          //   1124: invokevirtual 303	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
          //   1127: ifeq +33 -> 1160
          //   1130: aload_0
          //   1131: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1134: getfield 293	com/tencent/mm/plugin/webview/ui/tools/i:Cxx	Ljava/util/HashMap;
          //   1137: aload_0
          //   1138: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1141: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1144: getfield 296	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:nKq	Lcom/tencent/mm/ui/widget/MMWebView;
          //   1147: invokevirtual 299	com/tencent/mm/ui/widget/MMWebView:getUrl	()Ljava/lang/String;
          //   1150: invokevirtual 307	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
          //   1153: checkcast 147	java/lang/Integer
          //   1156: invokevirtual 310	java/lang/Integer:intValue	()I
          //   1159: istore_2
          //   1160: aload_0
          //   1161: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1164: iload_2
          //   1165: invokestatic 314	com/tencent/mm/plugin/webview/ui/tools/i:a	(Lcom/tencent/mm/plugin/webview/ui/tools/i;I)V
          //   1168: ldc 27
          //   1170: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1173: return
          //   1174: aload_0
          //   1175: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1178: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1181: getfield 158	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Cfc	Lcom/tencent/mm/plugin/webview/model/ax;
          //   1184: invokevirtual 164	com/tencent/mm/plugin/webview/model/ax:eBM	()Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   1187: iconst_3
          //   1188: anewarray 4	java/lang/Object
          //   1191: dup
          //   1192: iconst_0
          //   1193: aload_0
          //   1194: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1197: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1200: invokevirtual 167	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bLL	()Ljava/lang/String;
          //   1203: aastore
          //   1204: dup
          //   1205: iconst_1
          //   1206: bipush 36
          //   1208: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1211: aastore
          //   1212: dup
          //   1213: iconst_2
          //   1214: iconst_1
          //   1215: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1218: aastore
          //   1219: invokevirtual 173	com/tencent/mm/plugin/webview/model/ax$d:B	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   1222: invokevirtual 176	com/tencent/mm/plugin/webview/model/ax$d:report	()V
          //   1225: aload_0
          //   1226: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1229: iconst_1
          //   1230: invokestatic 316	com/tencent/mm/plugin/webview/ui/tools/i:b	(Lcom/tencent/mm/plugin/webview/ui/tools/i;I)V
          //   1233: ldc 27
          //   1235: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1238: return
          //   1239: aload_0
          //   1240: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1243: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1246: getfield 158	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Cfc	Lcom/tencent/mm/plugin/webview/model/ax;
          //   1249: invokevirtual 164	com/tencent/mm/plugin/webview/model/ax:eBM	()Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   1252: iconst_3
          //   1253: anewarray 4	java/lang/Object
          //   1256: dup
          //   1257: iconst_0
          //   1258: aload_0
          //   1259: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1262: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1265: invokevirtual 167	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bLL	()Ljava/lang/String;
          //   1268: aastore
          //   1269: dup
          //   1270: iconst_1
          //   1271: bipush 37
          //   1273: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1276: aastore
          //   1277: dup
          //   1278: iconst_2
          //   1279: iconst_1
          //   1280: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1283: aastore
          //   1284: invokevirtual 173	com/tencent/mm/plugin/webview/model/ax$d:B	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   1287: invokevirtual 176	com/tencent/mm/plugin/webview/model/ax$d:report	()V
          //   1290: aload_0
          //   1291: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1294: iconst_0
          //   1295: invokestatic 316	com/tencent/mm/plugin/webview/ui/tools/i:b	(Lcom/tencent/mm/plugin/webview/ui/tools/i;I)V
          //   1298: ldc 27
          //   1300: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1303: return
          //   1304: aload_0
          //   1305: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1308: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1311: getfield 158	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Cfc	Lcom/tencent/mm/plugin/webview/model/ax;
          //   1314: invokevirtual 164	com/tencent/mm/plugin/webview/model/ax:eBM	()Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   1317: iconst_3
          //   1318: anewarray 4	java/lang/Object
          //   1321: dup
          //   1322: iconst_0
          //   1323: aload_0
          //   1324: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1327: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1330: invokevirtual 167	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bLL	()Ljava/lang/String;
          //   1333: aastore
          //   1334: dup
          //   1335: iconst_1
          //   1336: iconst_3
          //   1337: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1340: aastore
          //   1341: dup
          //   1342: iconst_2
          //   1343: iconst_1
          //   1344: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1347: aastore
          //   1348: invokevirtual 173	com/tencent/mm/plugin/webview/model/ax$d:B	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   1351: invokevirtual 176	com/tencent/mm/plugin/webview/model/ax$d:report	()V
          //   1354: getstatic 322	com/tencent/mm/plugin/report/service/h:wUl	Lcom/tencent/mm/plugin/report/service/h;
          //   1357: ldc2_w 323
          //   1360: ldc2_w 325
          //   1363: lconst_1
          //   1364: iconst_0
          //   1365: invokevirtual 330	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
          //   1368: aload_0
          //   1369: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1372: invokevirtual 333	com/tencent/mm/plugin/webview/ui/tools/i:eDq	()V
          //   1375: ldc 27
          //   1377: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1380: return
          //   1381: aload_0
          //   1382: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1385: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1388: getfield 158	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Cfc	Lcom/tencent/mm/plugin/webview/model/ax;
          //   1391: invokevirtual 164	com/tencent/mm/plugin/webview/model/ax:eBM	()Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   1394: iconst_3
          //   1395: anewarray 4	java/lang/Object
          //   1398: dup
          //   1399: iconst_0
          //   1400: aload_0
          //   1401: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1404: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1407: invokevirtual 167	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bLL	()Ljava/lang/String;
          //   1410: aastore
          //   1411: dup
          //   1412: iconst_1
          //   1413: iconst_4
          //   1414: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1417: aastore
          //   1418: dup
          //   1419: iconst_2
          //   1420: iconst_1
          //   1421: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1424: aastore
          //   1425: invokevirtual 173	com/tencent/mm/plugin/webview/model/ax$d:B	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   1428: invokevirtual 176	com/tencent/mm/plugin/webview/model/ax$d:report	()V
          //   1431: aload_0
          //   1432: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1435: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1438: getfield 336	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:CzK	Ljava/util/HashMap;
          //   1441: aload_0
          //   1442: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1445: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1448: getfield 296	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:nKq	Lcom/tencent/mm/ui/widget/MMWebView;
          //   1451: invokevirtual 299	com/tencent/mm/ui/widget/MMWebView:getUrl	()Ljava/lang/String;
          //   1454: invokevirtual 307	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
          //   1457: checkcast 338	java/lang/String
          //   1460: astore 4
          //   1462: aload 4
          //   1464: astore_1
          //   1465: aload 4
          //   1467: ifnonnull +19 -> 1486
          //   1470: aload_0
          //   1471: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1474: invokevirtual 233	com/tencent/mm/plugin/webview/ui/tools/a:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1477: invokevirtual 237	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
          //   1480: ldc 249
          //   1482: invokevirtual 245	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
          //   1485: astore_1
          //   1486: aload_0
          //   1487: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1490: ldc_w 340
          //   1493: bipush 43
          //   1495: invokevirtual 344	com/tencent/mm/plugin/webview/ui/tools/i:fs	(Ljava/lang/String;I)V
          //   1498: aload_0
          //   1499: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1502: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1505: aload_1
          //   1506: invokevirtual 347	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:aDq	(Ljava/lang/String;)V
          //   1509: ldc 27
          //   1511: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1514: return
          //   1515: aload_0
          //   1516: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1519: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1522: getfield 158	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Cfc	Lcom/tencent/mm/plugin/webview/model/ax;
          //   1525: invokevirtual 164	com/tencent/mm/plugin/webview/model/ax:eBM	()Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   1528: iconst_3
          //   1529: anewarray 4	java/lang/Object
          //   1532: dup
          //   1533: iconst_0
          //   1534: aload_0
          //   1535: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1538: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1541: invokevirtual 167	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bLL	()Ljava/lang/String;
          //   1544: aastore
          //   1545: dup
          //   1546: iconst_1
          //   1547: bipush 8
          //   1549: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1552: aastore
          //   1553: dup
          //   1554: iconst_2
          //   1555: iconst_1
          //   1556: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1559: aastore
          //   1560: invokevirtual 173	com/tencent/mm/plugin/webview/model/ax$d:B	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   1563: invokevirtual 176	com/tencent/mm/plugin/webview/model/ax$d:report	()V
          //   1566: aload_0
          //   1567: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1570: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1573: getfield 351	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:CyX	Landroid/view/View;
          //   1576: invokevirtual 356	android/view/View:getVisibility	()I
          //   1579: bipush 8
          //   1581: if_icmpne +51 -> 1632
          //   1584: aload_0
          //   1585: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1588: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1591: ldc_w 357
          //   1594: invokestatic 363	android/view/animation/AnimationUtils:loadAnimation	(Landroid/content/Context;I)Landroid/view/animation/Animation;
          //   1597: astore_1
          //   1598: aload_0
          //   1599: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1602: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1605: getfield 351	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:CyX	Landroid/view/View;
          //   1608: aload_1
          //   1609: invokevirtual 367	android/view/View:startAnimation	(Landroid/view/animation/Animation;)V
          //   1612: aload_0
          //   1613: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1616: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1619: getfield 351	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:CyX	Landroid/view/View;
          //   1622: iconst_0
          //   1623: invokevirtual 370	android/view/View:setVisibility	(I)V
          //   1626: ldc 27
          //   1628: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1631: return
          //   1632: aload_0
          //   1633: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1636: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1639: ldc_w 371
          //   1642: invokestatic 363	android/view/animation/AnimationUtils:loadAnimation	(Landroid/content/Context;I)Landroid/view/animation/Animation;
          //   1645: astore_1
          //   1646: aload_1
          //   1647: new 13	com/tencent/mm/plugin/webview/ui/tools/i$14$1
          //   1650: dup
          //   1651: aload_0
          //   1652: invokespecial 374	com/tencent/mm/plugin/webview/ui/tools/i$14$1:<init>	(Lcom/tencent/mm/plugin/webview/ui/tools/i$14;)V
          //   1655: invokevirtual 380	android/view/animation/Animation:setAnimationListener	(Landroid/view/animation/Animation$AnimationListener;)V
          //   1658: aload_0
          //   1659: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1662: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1665: getfield 351	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:CyX	Landroid/view/View;
          //   1668: aload_1
          //   1669: invokevirtual 367	android/view/View:startAnimation	(Landroid/view/animation/Animation;)V
          //   1672: aload_0
          //   1673: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1676: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1679: getfield 351	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:CyX	Landroid/view/View;
          //   1682: bipush 8
          //   1684: invokevirtual 370	android/view/View:setVisibility	(I)V
          //   1687: ldc 27
          //   1689: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1692: return
          //   1693: aload_0
          //   1694: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1697: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1700: getfield 158	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Cfc	Lcom/tencent/mm/plugin/webview/model/ax;
          //   1703: invokevirtual 164	com/tencent/mm/plugin/webview/model/ax:eBM	()Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   1706: iconst_3
          //   1707: anewarray 4	java/lang/Object
          //   1710: dup
          //   1711: iconst_0
          //   1712: aload_0
          //   1713: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1716: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1719: invokevirtual 167	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bLL	()Ljava/lang/String;
          //   1722: aastore
          //   1723: dup
          //   1724: iconst_1
          //   1725: bipush 10
          //   1727: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1730: aastore
          //   1731: dup
          //   1732: iconst_2
          //   1733: iconst_1
          //   1734: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1737: aastore
          //   1738: invokevirtual 173	com/tencent/mm/plugin/webview/model/ax$d:B	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   1741: invokevirtual 176	com/tencent/mm/plugin/webview/model/ax$d:report	()V
          //   1744: aload_0
          //   1745: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1748: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1751: invokevirtual 383	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:eEf	()V
          //   1754: ldc 27
          //   1756: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1759: return
          //   1760: aload_0
          //   1761: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1764: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1767: getfield 158	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Cfc	Lcom/tencent/mm/plugin/webview/model/ax;
          //   1770: invokevirtual 164	com/tencent/mm/plugin/webview/model/ax:eBM	()Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   1773: iconst_3
          //   1774: anewarray 4	java/lang/Object
          //   1777: dup
          //   1778: iconst_0
          //   1779: aload_0
          //   1780: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1783: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1786: invokevirtual 167	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bLL	()Ljava/lang/String;
          //   1789: aastore
          //   1790: dup
          //   1791: iconst_1
          //   1792: iconst_5
          //   1793: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1796: aastore
          //   1797: dup
          //   1798: iconst_2
          //   1799: iconst_1
          //   1800: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1803: aastore
          //   1804: invokevirtual 173	com/tencent/mm/plugin/webview/model/ax$d:B	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   1807: invokevirtual 176	com/tencent/mm/plugin/webview/model/ax$d:report	()V
          //   1810: aload_0
          //   1811: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1814: invokestatic 385	com/tencent/mm/plugin/webview/ui/tools/i:a	(Lcom/tencent/mm/plugin/webview/ui/tools/i;)V
          //   1817: ldc 27
          //   1819: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1822: return
          //   1823: aload_0
          //   1824: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1827: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1830: getfield 158	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Cfc	Lcom/tencent/mm/plugin/webview/model/ax;
          //   1833: invokevirtual 164	com/tencent/mm/plugin/webview/model/ax:eBM	()Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   1836: iconst_3
          //   1837: anewarray 4	java/lang/Object
          //   1840: dup
          //   1841: iconst_0
          //   1842: aload_0
          //   1843: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1846: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1849: invokevirtual 167	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bLL	()Ljava/lang/String;
          //   1852: aastore
          //   1853: dup
          //   1854: iconst_1
          //   1855: bipush 13
          //   1857: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1860: aastore
          //   1861: dup
          //   1862: iconst_2
          //   1863: iconst_1
          //   1864: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1867: aastore
          //   1868: invokevirtual 173	com/tencent/mm/plugin/webview/model/ax$d:B	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   1871: invokevirtual 176	com/tencent/mm/plugin/webview/model/ax$d:report	()V
          //   1874: aload_0
          //   1875: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1878: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1881: astore 5
          //   1883: aload 5
          //   1885: getfield 386	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:kYt	Lcom/tencent/mm/plugin/webview/stub/e;
          //   1888: astore 6
          //   1890: aload 5
          //   1892: invokevirtual 389	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:isFinishing	()Z
          //   1895: ifne +254 -> 2149
          //   1898: aload 5
          //   1900: invokevirtual 392	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:eyJ	()Ljava/lang/String;
          //   1903: astore 4
          //   1905: aload 4
          //   1907: invokestatic 190	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
          //   1910: ifeq +18 -> 1928
          //   1913: ldc_w 394
          //   1916: ldc_w 396
          //   1919: invokestatic 73	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   1922: ldc 27
          //   1924: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1927: return
          //   1928: aload 4
          //   1930: astore_1
          //   1931: aload 6
          //   1933: ifnull +13 -> 1946
          //   1936: aload 6
          //   1938: aload 4
          //   1940: invokeinterface 399 2 0
          //   1945: astore_1
          //   1946: aload_1
          //   1947: astore 4
          //   1949: aload_1
          //   1950: ldc_w 401
          //   1953: invokevirtual 404	java/lang/String:startsWith	(Ljava/lang/String;)Z
          //   1956: ifne +28 -> 1984
          //   1959: aload_1
          //   1960: astore 4
          //   1962: aload_1
          //   1963: ldc_w 406
          //   1966: invokevirtual 404	java/lang/String:startsWith	(Ljava/lang/String;)Z
          //   1969: ifne +15 -> 1984
          //   1972: ldc_w 401
          //   1975: aload_1
          //   1976: invokestatic 409	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
          //   1979: invokevirtual 412	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
          //   1982: astore 4
          //   1984: new 241	android/content/Intent
          //   1987: dup
          //   1988: ldc_w 414
          //   1991: aload 4
          //   1993: invokestatic 420	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
          //   1996: invokespecial 423	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
          //   1999: astore_1
          //   2000: aload 5
          //   2002: invokestatic 427	com/tencent/mm/sdk/platformtools/bs:ja	(Landroid/content/Context;)Z
          //   2005: ifne +9 -> 2014
          //   2008: invokestatic 432	com/tencent/mm/sdk/platformtools/i:eUv	()Z
          //   2011: ifeq +168 -> 2179
          //   2014: ldc_w 394
          //   2017: ldc_w 434
          //   2020: iconst_2
          //   2021: anewarray 4	java/lang/Object
          //   2024: dup
          //   2025: iconst_0
          //   2026: aload 5
          //   2028: invokestatic 427	com/tencent/mm/sdk/platformtools/bs:ja	(Landroid/content/Context;)Z
          //   2031: invokestatic 439	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
          //   2034: aastore
          //   2035: dup
          //   2036: iconst_1
          //   2037: invokestatic 432	com/tencent/mm/sdk/platformtools/i:eUv	()Z
          //   2040: invokestatic 439	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
          //   2043: aastore
          //   2044: invokestatic 154	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   2047: new 441	com/tencent/mm/hellhoundlib/b/a
          //   2050: dup
          //   2051: invokespecial 442	com/tencent/mm/hellhoundlib/b/a:<init>	()V
          //   2054: aload_1
          //   2055: invokevirtual 446	com/tencent/mm/hellhoundlib/b/a:ba	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
          //   2058: astore_1
          //   2059: aload 5
          //   2061: aload_1
          //   2062: invokevirtual 450	com/tencent/mm/hellhoundlib/b/a:aeD	()[Ljava/lang/Object;
          //   2065: ldc_w 452
          //   2068: ldc_w 454
          //   2071: ldc_w 456
          //   2074: ldc_w 458
          //   2077: ldc_w 460
          //   2080: ldc_w 462
          //   2083: invokestatic 467	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
          //   2086: aload 5
          //   2088: aload_1
          //   2089: iconst_0
          //   2090: invokevirtual 471	com/tencent/mm/hellhoundlib/b/a:lR	(I)Ljava/lang/Object;
          //   2093: checkcast 241	android/content/Intent
          //   2096: invokevirtual 473	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:startActivity	(Landroid/content/Intent;)V
          //   2099: aload 5
          //   2101: ldc_w 452
          //   2104: ldc_w 454
          //   2107: ldc_w 456
          //   2110: ldc_w 458
          //   2113: ldc_w 460
          //   2116: ldc_w 462
          //   2119: invokestatic 476	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
          //   2122: ldc 27
          //   2124: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   2127: return
          //   2128: astore_1
          //   2129: ldc_w 394
          //   2132: ldc_w 478
          //   2135: iconst_1
          //   2136: anewarray 4	java/lang/Object
          //   2139: dup
          //   2140: iconst_0
          //   2141: aload_1
          //   2142: invokevirtual 481	java/lang/Exception:getMessage	()Ljava/lang/String;
          //   2145: aastore
          //   2146: invokestatic 483	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   2149: ldc 27
          //   2151: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   2154: return
          //   2155: astore_1
          //   2156: ldc_w 394
          //   2159: ldc_w 485
          //   2162: iconst_1
          //   2163: anewarray 4	java/lang/Object
          //   2166: dup
          //   2167: iconst_0
          //   2168: aload_1
          //   2169: aastore
          //   2170: invokestatic 483	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   2173: aload 4
          //   2175: astore_1
          //   2176: goto -230 -> 1946
          //   2179: aload 5
          //   2181: aload 5
          //   2183: aload_1
          //   2184: aload 4
          //   2186: invokestatic 490	com/tencent/mm/plugin/webview/modeltools/a:a	(Landroid/app/Activity;Landroid/content/Intent;Ljava/lang/String;)Landroid/content/Intent;
          //   2189: iconst_2
          //   2190: invokevirtual 494	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:startActivityForResult	(Landroid/content/Intent;I)V
          //   2193: ldc 27
          //   2195: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   2198: return
          //   2199: aload_0
          //   2200: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   2203: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2206: getfield 158	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Cfc	Lcom/tencent/mm/plugin/webview/model/ax;
          //   2209: invokevirtual 164	com/tencent/mm/plugin/webview/model/ax:eBM	()Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   2212: iconst_3
          //   2213: anewarray 4	java/lang/Object
          //   2216: dup
          //   2217: iconst_0
          //   2218: aload_0
          //   2219: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   2222: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2225: invokevirtual 167	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bLL	()Ljava/lang/String;
          //   2228: aastore
          //   2229: dup
          //   2230: iconst_1
          //   2231: bipush 35
          //   2233: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   2236: aastore
          //   2237: dup
          //   2238: iconst_2
          //   2239: iconst_1
          //   2240: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   2243: aastore
          //   2244: invokevirtual 173	com/tencent/mm/plugin/webview/model/ax$d:B	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   2247: invokevirtual 176	com/tencent/mm/plugin/webview/model/ax$d:report	()V
          //   2250: aload_0
          //   2251: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   2254: invokestatic 496	com/tencent/mm/plugin/webview/ui/tools/i:b	(Lcom/tencent/mm/plugin/webview/ui/tools/i;)V
          //   2257: ldc 27
          //   2259: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   2262: return
          //   2263: aload_0
          //   2264: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   2267: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2270: getfield 158	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Cfc	Lcom/tencent/mm/plugin/webview/model/ax;
          //   2273: invokevirtual 164	com/tencent/mm/plugin/webview/model/ax:eBM	()Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   2276: iconst_3
          //   2277: anewarray 4	java/lang/Object
          //   2280: dup
          //   2281: iconst_0
          //   2282: aload_0
          //   2283: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   2286: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2289: invokevirtual 167	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bLL	()Ljava/lang/String;
          //   2292: aastore
          //   2293: dup
          //   2294: iconst_1
          //   2295: bipush 15
          //   2297: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   2300: aastore
          //   2301: dup
          //   2302: iconst_2
          //   2303: iconst_1
          //   2304: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   2307: aastore
          //   2308: invokevirtual 173	com/tencent/mm/plugin/webview/model/ax$d:B	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   2311: invokevirtual 176	com/tencent/mm/plugin/webview/model/ax$d:report	()V
          //   2314: aload_0
          //   2315: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   2318: astore_1
          //   2319: aload_1
          //   2320: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2323: getfield 59	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Cjc	Lcom/tencent/mm/plugin/webview/c/f;
          //   2326: ldc_w 498
          //   2329: iconst_1
          //   2330: invokevirtual 502	com/tencent/mm/plugin/webview/c/f:cf	(Ljava/lang/String;Z)V
          //   2333: aload_1
          //   2334: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2337: getfield 59	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Cjc	Lcom/tencent/mm/plugin/webview/c/f;
          //   2340: astore_1
          //   2341: aload_1
          //   2342: getfield 64	com/tencent/mm/plugin/webview/c/f:Apr	Z
          //   2345: ifne +17 -> 2362
          //   2348: ldc 66
          //   2350: ldc_w 504
          //   2353: invokestatic 73	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   2356: ldc 27
          //   2358: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   2361: return
          //   2362: ldc_w 506
          //   2365: new 82	java/util/HashMap
          //   2368: dup
          //   2369: invokespecial 83	java/util/HashMap:<init>	()V
          //   2372: aload_1
          //   2373: getfield 101	com/tencent/mm/plugin/webview/c/f:Cjz	Z
          //   2376: aload_1
          //   2377: getfield 104	com/tencent/mm/plugin/webview/c/f:CjA	Ljava/lang/String;
          //   2380: invokestatic 110	com/tencent/mm/plugin/webview/c/l$a:b	(Ljava/lang/String;Ljava/util/Map;ZLjava/lang/String;)Ljava/lang/String;
          //   2383: astore 4
          //   2385: aload_1
          //   2386: getfield 114	com/tencent/mm/plugin/webview/c/f:Cjr	Lcom/tencent/mm/ui/widget/MMWebView;
          //   2389: new 116	java/lang/StringBuilder
          //   2392: dup
          //   2393: ldc 118
          //   2395: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   2398: aload 4
          //   2400: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   2403: ldc 127
          //   2405: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   2408: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   2411: aconst_null
          //   2412: invokevirtual 137	com/tencent/mm/ui/widget/MMWebView:evaluateJavascript	(Ljava/lang/String;Landroid/webkit/ValueCallback;)V
          //   2415: ldc 27
          //   2417: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   2420: return
          //   2421: aload_0
          //   2422: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   2425: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2428: getfield 158	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Cfc	Lcom/tencent/mm/plugin/webview/model/ax;
          //   2431: invokevirtual 164	com/tencent/mm/plugin/webview/model/ax:eBM	()Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   2434: iconst_3
          //   2435: anewarray 4	java/lang/Object
          //   2438: dup
          //   2439: iconst_0
          //   2440: aload_0
          //   2441: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   2444: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2447: invokevirtual 167	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bLL	()Ljava/lang/String;
          //   2450: aastore
          //   2451: dup
          //   2452: iconst_1
          //   2453: bipush 7
          //   2455: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   2458: aastore
          //   2459: dup
          //   2460: iconst_2
          //   2461: iconst_1
          //   2462: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   2465: aastore
          //   2466: invokevirtual 173	com/tencent/mm/plugin/webview/model/ax$d:B	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   2469: invokevirtual 176	com/tencent/mm/plugin/webview/model/ax$d:report	()V
          //   2472: aload_0
          //   2473: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   2476: astore_1
          //   2477: aload_1
          //   2478: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2481: aload_1
          //   2482: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2485: ldc_w 507
          //   2488: invokevirtual 511	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
          //   2491: aconst_null
          //   2492: aconst_null
          //   2493: aload_1
          //   2494: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2497: ldc_w 512
          //   2500: invokevirtual 511	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
          //   2503: new 514	com/tencent/mm/plugin/webview/ui/tools/i$7
          //   2506: dup
          //   2507: aload_1
          //   2508: invokespecial 516	com/tencent/mm/plugin/webview/ui/tools/i$7:<init>	(Lcom/tencent/mm/plugin/webview/ui/tools/i;)V
          //   2511: invokestatic 521	com/tencent/mm/ui/base/h:a	(Landroid/content/Context;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Lcom/tencent/mm/ui/base/h$d;)Landroid/app/Dialog;
          //   2514: pop
          //   2515: ldc 27
          //   2517: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   2520: return
          //   2521: aload_0
          //   2522: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   2525: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2528: getfield 158	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Cfc	Lcom/tencent/mm/plugin/webview/model/ax;
          //   2531: invokevirtual 164	com/tencent/mm/plugin/webview/model/ax:eBM	()Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   2534: iconst_3
          //   2535: anewarray 4	java/lang/Object
          //   2538: dup
          //   2539: iconst_0
          //   2540: aload_0
          //   2541: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   2544: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2547: invokevirtual 167	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bLL	()Ljava/lang/String;
          //   2550: aastore
          //   2551: dup
          //   2552: iconst_1
          //   2553: bipush 11
          //   2555: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   2558: aastore
          //   2559: dup
          //   2560: iconst_2
          //   2561: iconst_1
          //   2562: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   2565: aastore
          //   2566: invokevirtual 173	com/tencent/mm/plugin/webview/model/ax$d:B	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   2569: invokevirtual 176	com/tencent/mm/plugin/webview/model/ax$d:report	()V
          //   2572: aload_0
          //   2573: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   2576: aconst_null
          //   2577: invokevirtual 524	com/tencent/mm/plugin/webview/ui/tools/i:aDm	(Ljava/lang/String;)V
          //   2580: ldc 27
          //   2582: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   2585: return
          //   2586: aload_0
          //   2587: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   2590: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2593: getfield 158	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Cfc	Lcom/tencent/mm/plugin/webview/model/ax;
          //   2596: invokevirtual 164	com/tencent/mm/plugin/webview/model/ax:eBM	()Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   2599: iconst_3
          //   2600: anewarray 4	java/lang/Object
          //   2603: dup
          //   2604: iconst_0
          //   2605: aload_0
          //   2606: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   2609: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2612: invokevirtual 167	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bLL	()Ljava/lang/String;
          //   2615: aastore
          //   2616: dup
          //   2617: iconst_1
          //   2618: bipush 6
          //   2620: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   2623: aastore
          //   2624: dup
          //   2625: iconst_2
          //   2626: iconst_1
          //   2627: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   2630: aastore
          //   2631: invokevirtual 173	com/tencent/mm/plugin/webview/model/ax$d:B	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   2634: invokevirtual 176	com/tencent/mm/plugin/webview/model/ax$d:report	()V
          //   2637: new 241	android/content/Intent
          //   2640: dup
          //   2641: invokespecial 253	android/content/Intent:<init>	()V
          //   2644: astore_1
          //   2645: aload_1
          //   2646: ldc_w 526
          //   2649: iconst_2
          //   2650: invokevirtual 529	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
          //   2653: pop
          //   2654: aload_1
          //   2655: ldc_w 531
          //   2658: aload_0
          //   2659: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   2662: invokevirtual 233	com/tencent/mm/plugin/webview/ui/tools/a:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2665: invokevirtual 237	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
          //   2668: ldc_w 533
          //   2671: ldc2_w 534
          //   2674: invokevirtual 281	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
          //   2677: invokevirtual 538	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
          //   2680: pop
          //   2681: aload_0
          //   2682: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   2685: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2688: ldc_w 540
          //   2691: aload_1
          //   2692: invokestatic 544	com/tencent/mm/plugin/fav/a/b:b	(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;)V
          //   2695: aload_0
          //   2696: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   2699: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2702: getfield 158	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Cfc	Lcom/tencent/mm/plugin/webview/model/ax;
          //   2705: ldc_w 546
          //   2708: invokevirtual 549	com/tencent/mm/plugin/webview/model/ax:aCe	(Ljava/lang/String;)V
          //   2711: ldc 27
          //   2713: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   2716: return
          //   2717: aload_0
          //   2718: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   2721: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2724: getfield 158	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Cfc	Lcom/tencent/mm/plugin/webview/model/ax;
          //   2727: invokevirtual 164	com/tencent/mm/plugin/webview/model/ax:eBM	()Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   2730: iconst_3
          //   2731: anewarray 4	java/lang/Object
          //   2734: dup
          //   2735: iconst_0
          //   2736: aload_0
          //   2737: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   2740: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2743: invokevirtual 167	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bLL	()Ljava/lang/String;
          //   2746: aastore
          //   2747: dup
          //   2748: iconst_1
          //   2749: bipush 19
          //   2751: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   2754: aastore
          //   2755: dup
          //   2756: iconst_2
          //   2757: iconst_1
          //   2758: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   2761: aastore
          //   2762: invokevirtual 173	com/tencent/mm/plugin/webview/model/ax$d:B	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   2765: invokevirtual 176	com/tencent/mm/plugin/webview/model/ax$d:report	()V
          //   2768: aload_0
          //   2769: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   2772: aload_1
          //   2773: invokestatic 552	com/tencent/mm/plugin/webview/ui/tools/i:a	(Lcom/tencent/mm/plugin/webview/ui/tools/i;Landroid/view/MenuItem;)V
          //   2776: ldc 27
          //   2778: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   2781: return
          //   2782: aload_0
          //   2783: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   2786: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2789: getfield 158	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Cfc	Lcom/tencent/mm/plugin/webview/model/ax;
          //   2792: invokevirtual 164	com/tencent/mm/plugin/webview/model/ax:eBM	()Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   2795: iconst_3
          //   2796: anewarray 4	java/lang/Object
          //   2799: dup
          //   2800: iconst_0
          //   2801: aload_0
          //   2802: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   2805: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2808: invokevirtual 167	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bLL	()Ljava/lang/String;
          //   2811: aastore
          //   2812: dup
          //   2813: iconst_1
          //   2814: bipush 21
          //   2816: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   2819: aastore
          //   2820: dup
          //   2821: iconst_2
          //   2822: iconst_1
          //   2823: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   2826: aastore
          //   2827: invokevirtual 173	com/tencent/mm/plugin/webview/model/ax$d:B	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   2830: invokevirtual 176	com/tencent/mm/plugin/webview/model/ax$d:report	()V
          //   2833: aload_0
          //   2834: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   2837: aload_1
          //   2838: invokestatic 552	com/tencent/mm/plugin/webview/ui/tools/i:a	(Lcom/tencent/mm/plugin/webview/ui/tools/i;Landroid/view/MenuItem;)V
          //   2841: ldc 27
          //   2843: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   2846: return
          //   2847: aload_0
          //   2848: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   2851: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2854: getfield 158	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Cfc	Lcom/tencent/mm/plugin/webview/model/ax;
          //   2857: invokevirtual 164	com/tencent/mm/plugin/webview/model/ax:eBM	()Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   2860: iconst_3
          //   2861: anewarray 4	java/lang/Object
          //   2864: dup
          //   2865: iconst_0
          //   2866: aload_0
          //   2867: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   2870: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2873: invokevirtual 167	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bLL	()Ljava/lang/String;
          //   2876: aastore
          //   2877: dup
          //   2878: iconst_1
          //   2879: bipush 20
          //   2881: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   2884: aastore
          //   2885: dup
          //   2886: iconst_2
          //   2887: iconst_1
          //   2888: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   2891: aastore
          //   2892: invokevirtual 173	com/tencent/mm/plugin/webview/model/ax$d:B	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   2895: invokevirtual 176	com/tencent/mm/plugin/webview/model/ax$d:report	()V
          //   2898: aload_0
          //   2899: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   2902: aload_1
          //   2903: invokestatic 552	com/tencent/mm/plugin/webview/ui/tools/i:a	(Lcom/tencent/mm/plugin/webview/ui/tools/i;Landroid/view/MenuItem;)V
          //   2906: ldc 27
          //   2908: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   2911: return
          //   2912: aload_0
          //   2913: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   2916: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2919: getfield 158	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Cfc	Lcom/tencent/mm/plugin/webview/model/ax;
          //   2922: invokevirtual 164	com/tencent/mm/plugin/webview/model/ax:eBM	()Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   2925: iconst_3
          //   2926: anewarray 4	java/lang/Object
          //   2929: dup
          //   2930: iconst_0
          //   2931: aload_0
          //   2932: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   2935: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2938: invokevirtual 167	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bLL	()Ljava/lang/String;
          //   2941: aastore
          //   2942: dup
          //   2943: iconst_1
          //   2944: bipush 22
          //   2946: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   2949: aastore
          //   2950: dup
          //   2951: iconst_2
          //   2952: iconst_1
          //   2953: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   2956: aastore
          //   2957: invokevirtual 173	com/tencent/mm/plugin/webview/model/ax$d:B	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   2960: invokevirtual 176	com/tencent/mm/plugin/webview/model/ax$d:report	()V
          //   2963: aload_0
          //   2964: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   2967: aload_1
          //   2968: invokestatic 552	com/tencent/mm/plugin/webview/ui/tools/i:a	(Lcom/tencent/mm/plugin/webview/ui/tools/i;Landroid/view/MenuItem;)V
          //   2971: ldc 27
          //   2973: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   2976: return
          //   2977: aload_0
          //   2978: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   2981: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2984: getfield 158	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Cfc	Lcom/tencent/mm/plugin/webview/model/ax;
          //   2987: invokevirtual 164	com/tencent/mm/plugin/webview/model/ax:eBM	()Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   2990: iconst_3
          //   2991: anewarray 4	java/lang/Object
          //   2994: dup
          //   2995: iconst_0
          //   2996: aload_0
          //   2997: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   3000: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3003: invokevirtual 167	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bLL	()Ljava/lang/String;
          //   3006: aastore
          //   3007: dup
          //   3008: iconst_1
          //   3009: bipush 23
          //   3011: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3014: aastore
          //   3015: dup
          //   3016: iconst_2
          //   3017: iconst_1
          //   3018: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3021: aastore
          //   3022: invokevirtual 173	com/tencent/mm/plugin/webview/model/ax$d:B	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   3025: invokevirtual 176	com/tencent/mm/plugin/webview/model/ax$d:report	()V
          //   3028: aload_0
          //   3029: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   3032: aload_1
          //   3033: invokestatic 552	com/tencent/mm/plugin/webview/ui/tools/i:a	(Lcom/tencent/mm/plugin/webview/ui/tools/i;Landroid/view/MenuItem;)V
          //   3036: ldc 27
          //   3038: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   3041: return
          //   3042: aload_0
          //   3043: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   3046: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3049: getfield 158	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Cfc	Lcom/tencent/mm/plugin/webview/model/ax;
          //   3052: invokevirtual 164	com/tencent/mm/plugin/webview/model/ax:eBM	()Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   3055: iconst_3
          //   3056: anewarray 4	java/lang/Object
          //   3059: dup
          //   3060: iconst_0
          //   3061: aload_0
          //   3062: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   3065: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3068: invokevirtual 167	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bLL	()Ljava/lang/String;
          //   3071: aastore
          //   3072: dup
          //   3073: iconst_1
          //   3074: bipush 26
          //   3076: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3079: aastore
          //   3080: dup
          //   3081: iconst_2
          //   3082: iconst_1
          //   3083: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3086: aastore
          //   3087: invokevirtual 173	com/tencent/mm/plugin/webview/model/ax$d:B	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   3090: invokevirtual 176	com/tencent/mm/plugin/webview/model/ax$d:report	()V
          //   3093: aload_0
          //   3094: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   3097: astore_1
          //   3098: aload_1
          //   3099: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3102: getfield 59	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Cjc	Lcom/tencent/mm/plugin/webview/c/f;
          //   3105: ldc_w 554
          //   3108: iconst_1
          //   3109: invokevirtual 502	com/tencent/mm/plugin/webview/c/f:cf	(Ljava/lang/String;Z)V
          //   3112: aload_1
          //   3113: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3116: getfield 59	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Cjc	Lcom/tencent/mm/plugin/webview/c/f;
          //   3119: astore_1
          //   3120: aload_1
          //   3121: getfield 64	com/tencent/mm/plugin/webview/c/f:Apr	Z
          //   3124: ifne +17 -> 3141
          //   3127: ldc 66
          //   3129: ldc_w 556
          //   3132: invokestatic 73	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   3135: ldc 27
          //   3137: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   3140: return
          //   3141: ldc_w 558
          //   3144: new 82	java/util/HashMap
          //   3147: dup
          //   3148: invokespecial 83	java/util/HashMap:<init>	()V
          //   3151: aload_1
          //   3152: getfield 101	com/tencent/mm/plugin/webview/c/f:Cjz	Z
          //   3155: aload_1
          //   3156: getfield 104	com/tencent/mm/plugin/webview/c/f:CjA	Ljava/lang/String;
          //   3159: invokestatic 110	com/tencent/mm/plugin/webview/c/l$a:b	(Ljava/lang/String;Ljava/util/Map;ZLjava/lang/String;)Ljava/lang/String;
          //   3162: astore 4
          //   3164: aload_1
          //   3165: getfield 114	com/tencent/mm/plugin/webview/c/f:Cjr	Lcom/tencent/mm/ui/widget/MMWebView;
          //   3168: new 116	java/lang/StringBuilder
          //   3171: dup
          //   3172: ldc 118
          //   3174: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   3177: aload 4
          //   3179: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   3182: ldc 127
          //   3184: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   3187: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   3190: aconst_null
          //   3191: invokevirtual 137	com/tencent/mm/ui/widget/MMWebView:evaluateJavascript	(Ljava/lang/String;Landroid/webkit/ValueCallback;)V
          //   3194: aload_1
          //   3195: getfield 559	com/tencent/mm/plugin/webview/c/f:kYt	Lcom/tencent/mm/plugin/webview/stub/e;
          //   3198: ldc_w 561
          //   3201: ldc_w 563
          //   3204: aload_1
          //   3205: getfield 567	com/tencent/mm/plugin/webview/c/f:CjB	I
          //   3208: invokeinterface 571 4 0
          //   3213: ldc 27
          //   3215: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   3218: return
          //   3219: astore_1
          //   3220: ldc 66
          //   3222: new 116	java/lang/StringBuilder
          //   3225: dup
          //   3226: ldc_w 573
          //   3229: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   3232: aload_1
          //   3233: invokevirtual 481	java/lang/Exception:getMessage	()Ljava/lang/String;
          //   3236: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   3239: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   3242: invokestatic 576	com/tencent/mm/sdk/platformtools/ac:w	(Ljava/lang/String;Ljava/lang/String;)V
          //   3245: ldc 27
          //   3247: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   3250: return
          //   3251: aload_0
          //   3252: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   3255: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3258: getfield 158	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Cfc	Lcom/tencent/mm/plugin/webview/model/ax;
          //   3261: invokevirtual 164	com/tencent/mm/plugin/webview/model/ax:eBM	()Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   3264: iconst_3
          //   3265: anewarray 4	java/lang/Object
          //   3268: dup
          //   3269: iconst_0
          //   3270: aload_0
          //   3271: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   3274: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3277: invokevirtual 167	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bLL	()Ljava/lang/String;
          //   3280: aastore
          //   3281: dup
          //   3282: iconst_1
          //   3283: bipush 27
          //   3285: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3288: aastore
          //   3289: dup
          //   3290: iconst_2
          //   3291: iconst_1
          //   3292: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3295: aastore
          //   3296: invokevirtual 173	com/tencent/mm/plugin/webview/model/ax$d:B	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   3299: invokevirtual 176	com/tencent/mm/plugin/webview/model/ax$d:report	()V
          //   3302: aload_0
          //   3303: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   3306: invokestatic 579	com/tencent/mm/plugin/webview/ui/tools/i:c	(Lcom/tencent/mm/plugin/webview/ui/tools/i;)V
          //   3309: ldc 27
          //   3311: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   3314: return
          //   3315: aload_0
          //   3316: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   3319: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3322: getfield 158	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Cfc	Lcom/tencent/mm/plugin/webview/model/ax;
          //   3325: invokevirtual 164	com/tencent/mm/plugin/webview/model/ax:eBM	()Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   3328: iconst_3
          //   3329: anewarray 4	java/lang/Object
          //   3332: dup
          //   3333: iconst_0
          //   3334: aload_0
          //   3335: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   3338: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3341: invokevirtual 167	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bLL	()Ljava/lang/String;
          //   3344: aastore
          //   3345: dup
          //   3346: iconst_1
          //   3347: bipush 17
          //   3349: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3352: aastore
          //   3353: dup
          //   3354: iconst_2
          //   3355: iconst_1
          //   3356: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3359: aastore
          //   3360: invokevirtual 173	com/tencent/mm/plugin/webview/model/ax$d:B	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   3363: invokevirtual 176	com/tencent/mm/plugin/webview/model/ax$d:report	()V
          //   3366: aload_0
          //   3367: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   3370: astore_1
          //   3371: aload_1
          //   3372: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3375: getfield 59	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Cjc	Lcom/tencent/mm/plugin/webview/c/f;
          //   3378: ldc_w 581
          //   3381: iconst_1
          //   3382: invokevirtual 502	com/tencent/mm/plugin/webview/c/f:cf	(Ljava/lang/String;Z)V
          //   3385: aload_1
          //   3386: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3389: getfield 59	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Cjc	Lcom/tencent/mm/plugin/webview/c/f;
          //   3392: astore_1
          //   3393: aload_1
          //   3394: getfield 64	com/tencent/mm/plugin/webview/c/f:Apr	Z
          //   3397: ifne +17 -> 3414
          //   3400: ldc 66
          //   3402: ldc_w 583
          //   3405: invokestatic 73	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   3408: ldc 27
          //   3410: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   3413: return
          //   3414: aload_1
          //   3415: iconst_1
          //   3416: invokevirtual 587	com/tencent/mm/plugin/webview/c/f:UN	(I)Landroid/os/Bundle;
          //   3419: astore 4
          //   3421: aload 4
          //   3423: ifnull +30 -> 3453
          //   3426: aload 4
          //   3428: ldc_w 589
          //   3431: iconst_0
          //   3432: invokevirtual 593	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
          //   3435: ifeq +18 -> 3453
          //   3438: aload_1
          //   3439: aload 4
          //   3441: ldc_w 581
          //   3444: invokevirtual 596	com/tencent/mm/plugin/webview/c/f:i	(Landroid/os/Bundle;Ljava/lang/String;)V
          //   3447: ldc 27
          //   3449: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   3452: return
          //   3453: ldc_w 598
          //   3456: new 82	java/util/HashMap
          //   3459: dup
          //   3460: invokespecial 83	java/util/HashMap:<init>	()V
          //   3463: aload_1
          //   3464: getfield 101	com/tencent/mm/plugin/webview/c/f:Cjz	Z
          //   3467: aload_1
          //   3468: getfield 104	com/tencent/mm/plugin/webview/c/f:CjA	Ljava/lang/String;
          //   3471: invokestatic 110	com/tencent/mm/plugin/webview/c/l$a:b	(Ljava/lang/String;Ljava/util/Map;ZLjava/lang/String;)Ljava/lang/String;
          //   3474: astore 4
          //   3476: aload_1
          //   3477: getfield 114	com/tencent/mm/plugin/webview/c/f:Cjr	Lcom/tencent/mm/ui/widget/MMWebView;
          //   3480: new 116	java/lang/StringBuilder
          //   3483: dup
          //   3484: ldc 118
          //   3486: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   3489: aload 4
          //   3491: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   3494: ldc 127
          //   3496: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   3499: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   3502: aconst_null
          //   3503: invokevirtual 137	com/tencent/mm/ui/widget/MMWebView:evaluateJavascript	(Ljava/lang/String;Landroid/webkit/ValueCallback;)V
          //   3506: ldc 27
          //   3508: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   3511: return
          //   3512: aload_0
          //   3513: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   3516: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3519: getfield 158	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Cfc	Lcom/tencent/mm/plugin/webview/model/ax;
          //   3522: invokevirtual 164	com/tencent/mm/plugin/webview/model/ax:eBM	()Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   3525: iconst_3
          //   3526: anewarray 4	java/lang/Object
          //   3529: dup
          //   3530: iconst_0
          //   3531: aload_0
          //   3532: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   3535: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3538: invokevirtual 167	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bLL	()Ljava/lang/String;
          //   3541: aastore
          //   3542: dup
          //   3543: iconst_1
          //   3544: bipush 18
          //   3546: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3549: aastore
          //   3550: dup
          //   3551: iconst_2
          //   3552: iconst_1
          //   3553: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3556: aastore
          //   3557: invokevirtual 173	com/tencent/mm/plugin/webview/model/ax$d:B	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   3560: invokevirtual 176	com/tencent/mm/plugin/webview/model/ax$d:report	()V
          //   3563: aload_0
          //   3564: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   3567: astore_1
          //   3568: aload_1
          //   3569: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3572: getfield 59	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Cjc	Lcom/tencent/mm/plugin/webview/c/f;
          //   3575: ldc_w 600
          //   3578: iconst_1
          //   3579: invokevirtual 502	com/tencent/mm/plugin/webview/c/f:cf	(Ljava/lang/String;Z)V
          //   3582: aload_1
          //   3583: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3586: getfield 59	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Cjc	Lcom/tencent/mm/plugin/webview/c/f;
          //   3589: astore_1
          //   3590: aload_1
          //   3591: getfield 64	com/tencent/mm/plugin/webview/c/f:Apr	Z
          //   3594: ifne +17 -> 3611
          //   3597: ldc 66
          //   3599: ldc_w 602
          //   3602: invokestatic 73	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   3605: ldc 27
          //   3607: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   3610: return
          //   3611: ldc_w 604
          //   3614: new 82	java/util/HashMap
          //   3617: dup
          //   3618: invokespecial 83	java/util/HashMap:<init>	()V
          //   3621: aload_1
          //   3622: getfield 101	com/tencent/mm/plugin/webview/c/f:Cjz	Z
          //   3625: aload_1
          //   3626: getfield 104	com/tencent/mm/plugin/webview/c/f:CjA	Ljava/lang/String;
          //   3629: invokestatic 110	com/tencent/mm/plugin/webview/c/l$a:b	(Ljava/lang/String;Ljava/util/Map;ZLjava/lang/String;)Ljava/lang/String;
          //   3632: astore 4
          //   3634: aload_1
          //   3635: getfield 114	com/tencent/mm/plugin/webview/c/f:Cjr	Lcom/tencent/mm/ui/widget/MMWebView;
          //   3638: new 116	java/lang/StringBuilder
          //   3641: dup
          //   3642: ldc 118
          //   3644: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   3647: aload 4
          //   3649: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   3652: ldc 127
          //   3654: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   3657: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   3660: aconst_null
          //   3661: invokevirtual 137	com/tencent/mm/ui/widget/MMWebView:evaluateJavascript	(Ljava/lang/String;Landroid/webkit/ValueCallback;)V
          //   3664: ldc 27
          //   3666: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   3669: return
          //   3670: aload_0
          //   3671: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   3674: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3677: getfield 158	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Cfc	Lcom/tencent/mm/plugin/webview/model/ax;
          //   3680: invokevirtual 164	com/tencent/mm/plugin/webview/model/ax:eBM	()Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   3683: iconst_3
          //   3684: anewarray 4	java/lang/Object
          //   3687: dup
          //   3688: iconst_0
          //   3689: aload_0
          //   3690: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   3693: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3696: invokevirtual 167	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bLL	()Ljava/lang/String;
          //   3699: aastore
          //   3700: dup
          //   3701: iconst_1
          //   3702: bipush 24
          //   3704: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3707: aastore
          //   3708: dup
          //   3709: iconst_2
          //   3710: iconst_1
          //   3711: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3714: aastore
          //   3715: invokevirtual 173	com/tencent/mm/plugin/webview/model/ax$d:B	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   3718: invokevirtual 176	com/tencent/mm/plugin/webview/model/ax$d:report	()V
          //   3721: aload_0
          //   3722: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   3725: astore_1
          //   3726: aload_1
          //   3727: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3730: getfield 59	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Cjc	Lcom/tencent/mm/plugin/webview/c/f;
          //   3733: ldc_w 606
          //   3736: iconst_1
          //   3737: invokevirtual 502	com/tencent/mm/plugin/webview/c/f:cf	(Ljava/lang/String;Z)V
          //   3740: aload_1
          //   3741: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3744: getfield 59	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Cjc	Lcom/tencent/mm/plugin/webview/c/f;
          //   3747: astore_1
          //   3748: aload_1
          //   3749: getfield 64	com/tencent/mm/plugin/webview/c/f:Apr	Z
          //   3752: ifne +17 -> 3769
          //   3755: ldc 66
          //   3757: ldc_w 608
          //   3760: invokestatic 73	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   3763: ldc 27
          //   3765: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   3768: return
          //   3769: aload_1
          //   3770: iconst_1
          //   3771: invokevirtual 587	com/tencent/mm/plugin/webview/c/f:UN	(I)Landroid/os/Bundle;
          //   3774: astore 4
          //   3776: aload 4
          //   3778: ifnull +30 -> 3808
          //   3781: aload 4
          //   3783: ldc_w 589
          //   3786: iconst_0
          //   3787: invokevirtual 593	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
          //   3790: ifeq +18 -> 3808
          //   3793: aload_1
          //   3794: aload 4
          //   3796: ldc_w 606
          //   3799: invokevirtual 596	com/tencent/mm/plugin/webview/c/f:i	(Landroid/os/Bundle;Ljava/lang/String;)V
          //   3802: ldc 27
          //   3804: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   3807: return
          //   3808: ldc_w 610
          //   3811: new 82	java/util/HashMap
          //   3814: dup
          //   3815: invokespecial 83	java/util/HashMap:<init>	()V
          //   3818: aload_1
          //   3819: getfield 101	com/tencent/mm/plugin/webview/c/f:Cjz	Z
          //   3822: aload_1
          //   3823: getfield 104	com/tencent/mm/plugin/webview/c/f:CjA	Ljava/lang/String;
          //   3826: invokestatic 110	com/tencent/mm/plugin/webview/c/l$a:b	(Ljava/lang/String;Ljava/util/Map;ZLjava/lang/String;)Ljava/lang/String;
          //   3829: astore 4
          //   3831: aload_1
          //   3832: getfield 114	com/tencent/mm/plugin/webview/c/f:Cjr	Lcom/tencent/mm/ui/widget/MMWebView;
          //   3835: new 116	java/lang/StringBuilder
          //   3838: dup
          //   3839: ldc 118
          //   3841: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   3844: aload 4
          //   3846: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   3849: ldc 127
          //   3851: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   3854: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   3857: aconst_null
          //   3858: invokevirtual 137	com/tencent/mm/ui/widget/MMWebView:evaluateJavascript	(Ljava/lang/String;Landroid/webkit/ValueCallback;)V
          //   3861: ldc 27
          //   3863: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   3866: return
          //   3867: aload_0
          //   3868: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   3871: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3874: getfield 158	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Cfc	Lcom/tencent/mm/plugin/webview/model/ax;
          //   3877: invokevirtual 164	com/tencent/mm/plugin/webview/model/ax:eBM	()Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   3880: iconst_3
          //   3881: anewarray 4	java/lang/Object
          //   3884: dup
          //   3885: iconst_0
          //   3886: aload_0
          //   3887: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   3890: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3893: invokevirtual 167	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bLL	()Ljava/lang/String;
          //   3896: aastore
          //   3897: dup
          //   3898: iconst_1
          //   3899: bipush 14
          //   3901: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3904: aastore
          //   3905: dup
          //   3906: iconst_2
          //   3907: iconst_1
          //   3908: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3911: aastore
          //   3912: invokevirtual 173	com/tencent/mm/plugin/webview/model/ax$d:B	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   3915: invokevirtual 176	com/tencent/mm/plugin/webview/model/ax$d:report	()V
          //   3918: aload_0
          //   3919: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   3922: astore_1
          //   3923: aload_1
          //   3924: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3927: getfield 59	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Cjc	Lcom/tencent/mm/plugin/webview/c/f;
          //   3930: ldc_w 554
          //   3933: iconst_1
          //   3934: invokevirtual 502	com/tencent/mm/plugin/webview/c/f:cf	(Ljava/lang/String;Z)V
          //   3937: aload_1
          //   3938: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3941: getfield 59	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Cjc	Lcom/tencent/mm/plugin/webview/c/f;
          //   3944: astore_1
          //   3945: aload_1
          //   3946: getfield 64	com/tencent/mm/plugin/webview/c/f:Apr	Z
          //   3949: ifne +17 -> 3966
          //   3952: ldc 66
          //   3954: ldc_w 612
          //   3957: invokestatic 73	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   3960: ldc 27
          //   3962: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   3965: return
          //   3966: ldc_w 558
          //   3969: new 82	java/util/HashMap
          //   3972: dup
          //   3973: invokespecial 83	java/util/HashMap:<init>	()V
          //   3976: aload_1
          //   3977: getfield 101	com/tencent/mm/plugin/webview/c/f:Cjz	Z
          //   3980: aload_1
          //   3981: getfield 104	com/tencent/mm/plugin/webview/c/f:CjA	Ljava/lang/String;
          //   3984: invokestatic 110	com/tencent/mm/plugin/webview/c/l$a:b	(Ljava/lang/String;Ljava/util/Map;ZLjava/lang/String;)Ljava/lang/String;
          //   3987: astore 4
          //   3989: aload_1
          //   3990: getfield 114	com/tencent/mm/plugin/webview/c/f:Cjr	Lcom/tencent/mm/ui/widget/MMWebView;
          //   3993: new 116	java/lang/StringBuilder
          //   3996: dup
          //   3997: ldc 118
          //   3999: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   4002: aload 4
          //   4004: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   4007: ldc 127
          //   4009: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   4012: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   4015: aconst_null
          //   4016: invokevirtual 137	com/tencent/mm/ui/widget/MMWebView:evaluateJavascript	(Ljava/lang/String;Landroid/webkit/ValueCallback;)V
          //   4019: aload_1
          //   4020: getfield 559	com/tencent/mm/plugin/webview/c/f:kYt	Lcom/tencent/mm/plugin/webview/stub/e;
          //   4023: ldc_w 561
          //   4026: ldc_w 614
          //   4029: aload_1
          //   4030: getfield 567	com/tencent/mm/plugin/webview/c/f:CjB	I
          //   4033: invokeinterface 571 4 0
          //   4038: ldc 27
          //   4040: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   4043: return
          //   4044: astore_1
          //   4045: ldc 66
          //   4047: new 116	java/lang/StringBuilder
          //   4050: dup
          //   4051: ldc_w 573
          //   4054: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   4057: aload_1
          //   4058: invokevirtual 481	java/lang/Exception:getMessage	()Ljava/lang/String;
          //   4061: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   4064: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   4067: invokestatic 576	com/tencent/mm/sdk/platformtools/ac:w	(Ljava/lang/String;Ljava/lang/String;)V
          //   4070: ldc 27
          //   4072: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   4075: return
          //   4076: aload_0
          //   4077: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   4080: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4083: getfield 158	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Cfc	Lcom/tencent/mm/plugin/webview/model/ax;
          //   4086: invokevirtual 164	com/tencent/mm/plugin/webview/model/ax:eBM	()Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   4089: iconst_3
          //   4090: anewarray 4	java/lang/Object
          //   4093: dup
          //   4094: iconst_0
          //   4095: aload_0
          //   4096: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   4099: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4102: invokevirtual 167	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bLL	()Ljava/lang/String;
          //   4105: aastore
          //   4106: dup
          //   4107: iconst_1
          //   4108: bipush 16
          //   4110: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   4113: aastore
          //   4114: dup
          //   4115: iconst_2
          //   4116: iconst_1
          //   4117: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   4120: aastore
          //   4121: invokevirtual 173	com/tencent/mm/plugin/webview/model/ax$d:B	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   4124: invokevirtual 176	com/tencent/mm/plugin/webview/model/ax$d:report	()V
          //   4127: aload_0
          //   4128: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   4131: invokestatic 617	com/tencent/mm/plugin/webview/ui/tools/i:d	(Lcom/tencent/mm/plugin/webview/ui/tools/i;)V
          //   4134: ldc 27
          //   4136: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   4139: return
          //   4140: aload_0
          //   4141: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   4144: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4147: getfield 158	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Cfc	Lcom/tencent/mm/plugin/webview/model/ax;
          //   4150: invokevirtual 164	com/tencent/mm/plugin/webview/model/ax:eBM	()Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   4153: iconst_3
          //   4154: anewarray 4	java/lang/Object
          //   4157: dup
          //   4158: iconst_0
          //   4159: aload_0
          //   4160: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   4163: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4166: invokevirtual 167	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bLL	()Ljava/lang/String;
          //   4169: aastore
          //   4170: dup
          //   4171: iconst_1
          //   4172: bipush 31
          //   4174: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   4177: aastore
          //   4178: dup
          //   4179: iconst_2
          //   4180: iconst_1
          //   4181: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   4184: aastore
          //   4185: invokevirtual 173	com/tencent/mm/plugin/webview/model/ax$d:B	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   4188: invokevirtual 176	com/tencent/mm/plugin/webview/model/ax$d:report	()V
          //   4191: aload_0
          //   4192: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   4195: invokevirtual 620	com/tencent/mm/plugin/webview/ui/tools/i:bHN	()V
          //   4198: ldc 27
          //   4200: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   4203: return
          //   4204: getstatic 322	com/tencent/mm/plugin/report/service/h:wUl	Lcom/tencent/mm/plugin/report/service/h;
          //   4207: ldc2_w 621
          //   4210: lconst_1
          //   4211: lconst_1
          //   4212: iconst_0
          //   4213: invokevirtual 330	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
          //   4216: aload_0
          //   4217: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   4220: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4223: getfield 158	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Cfc	Lcom/tencent/mm/plugin/webview/model/ax;
          //   4226: invokevirtual 164	com/tencent/mm/plugin/webview/model/ax:eBM	()Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   4229: iconst_3
          //   4230: anewarray 4	java/lang/Object
          //   4233: dup
          //   4234: iconst_0
          //   4235: aload_0
          //   4236: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   4239: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4242: invokevirtual 167	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bLL	()Ljava/lang/String;
          //   4245: aastore
          //   4246: dup
          //   4247: iconst_1
          //   4248: bipush 28
          //   4250: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   4253: aastore
          //   4254: dup
          //   4255: iconst_2
          //   4256: iconst_1
          //   4257: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   4260: aastore
          //   4261: invokevirtual 173	com/tencent/mm/plugin/webview/model/ax$d:B	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   4264: invokevirtual 176	com/tencent/mm/plugin/webview/model/ax$d:report	()V
          //   4267: aload_0
          //   4268: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   4271: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4274: getfield 626	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Czg	Lcom/tencent/mm/plugin/webview/ui/tools/widget/WebViewSearchContentInputFooter;
          //   4277: invokevirtual 631	com/tencent/mm/plugin/webview/ui/tools/widget/WebViewSearchContentInputFooter:isShown	()Z
          //   4280: ifne +600 -> 4880
          //   4283: aload_0
          //   4284: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   4287: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4290: getfield 626	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Czg	Lcom/tencent/mm/plugin/webview/ui/tools/widget/WebViewSearchContentInputFooter;
          //   4293: invokevirtual 634	com/tencent/mm/plugin/webview/ui/tools/widget/WebViewSearchContentInputFooter:reset	()V
          //   4296: aload_0
          //   4297: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   4300: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4303: getfield 626	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Czg	Lcom/tencent/mm/plugin/webview/ui/tools/widget/WebViewSearchContentInputFooter;
          //   4306: invokevirtual 637	com/tencent/mm/plugin/webview/ui/tools/widget/WebViewSearchContentInputFooter:eGK	()V
          //   4309: aload_0
          //   4310: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   4313: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4316: getfield 626	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Czg	Lcom/tencent/mm/plugin/webview/ui/tools/widget/WebViewSearchContentInputFooter;
          //   4319: invokevirtual 640	com/tencent/mm/plugin/webview/ui/tools/widget/WebViewSearchContentInputFooter:show	()V
          //   4322: ldc 27
          //   4324: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   4327: return
          //   4328: aload_0
          //   4329: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   4332: astore_1
          //   4333: ldc 139
          //   4335: ldc_w 642
          //   4338: invokestatic 80	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
          //   4341: aload_1
          //   4342: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4345: getfield 59	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Cjc	Lcom/tencent/mm/plugin/webview/c/f;
          //   4348: ifnull +72 -> 4420
          //   4351: aload_1
          //   4352: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4355: getfield 59	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Cjc	Lcom/tencent/mm/plugin/webview/c/f;
          //   4358: astore_1
          //   4359: aload_1
          //   4360: getfield 64	com/tencent/mm/plugin/webview/c/f:Apr	Z
          //   4363: ifne +17 -> 4380
          //   4366: ldc 66
          //   4368: ldc_w 644
          //   4371: invokestatic 73	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   4374: ldc 27
          //   4376: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   4379: return
          //   4380: ldc 66
          //   4382: ldc_w 646
          //   4385: invokestatic 80	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
          //   4388: new 648	com/tencent/mm/plugin/webview/c/f$19
          //   4391: dup
          //   4392: aload_1
          //   4393: ldc_w 650
          //   4396: new 82	java/util/HashMap
          //   4399: dup
          //   4400: invokespecial 83	java/util/HashMap:<init>	()V
          //   4403: aload_1
          //   4404: getfield 101	com/tencent/mm/plugin/webview/c/f:Cjz	Z
          //   4407: aload_1
          //   4408: getfield 104	com/tencent/mm/plugin/webview/c/f:CjA	Ljava/lang/String;
          //   4411: invokestatic 110	com/tencent/mm/plugin/webview/c/l$a:b	(Ljava/lang/String;Ljava/util/Map;ZLjava/lang/String;)Ljava/lang/String;
          //   4414: invokespecial 653	com/tencent/mm/plugin/webview/c/f$19:<init>	(Lcom/tencent/mm/plugin/webview/c/f;Ljava/lang/String;)V
          //   4417: invokestatic 659	com/tencent/mm/sdk/platformtools/ap:f	(Ljava/lang/Runnable;)V
          //   4420: ldc 27
          //   4422: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   4425: return
          //   4426: aload_0
          //   4427: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   4430: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4433: getfield 158	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Cfc	Lcom/tencent/mm/plugin/webview/model/ax;
          //   4436: invokevirtual 164	com/tencent/mm/plugin/webview/model/ax:eBM	()Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   4439: iconst_3
          //   4440: anewarray 4	java/lang/Object
          //   4443: dup
          //   4444: iconst_0
          //   4445: aload_0
          //   4446: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   4449: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4452: invokevirtual 167	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bLL	()Ljava/lang/String;
          //   4455: aastore
          //   4456: dup
          //   4457: iconst_1
          //   4458: bipush 33
          //   4460: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   4463: aastore
          //   4464: dup
          //   4465: iconst_2
          //   4466: iconst_1
          //   4467: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   4470: aastore
          //   4471: invokevirtual 173	com/tencent/mm/plugin/webview/model/ax$d:B	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   4474: invokevirtual 176	com/tencent/mm/plugin/webview/model/ax$d:report	()V
          //   4477: aload_0
          //   4478: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   4481: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4484: getfield 663	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:CAr	Lcom/tencent/mm/plugin/webview/ui/tools/b/a;
          //   4487: iconst_1
          //   4488: invokevirtual 669	com/tencent/mm/plugin/webview/ui/tools/b/a:ga	(Z)V
          //   4491: ldc 27
          //   4493: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   4496: return
          //   4497: aload_0
          //   4498: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   4501: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4504: getfield 158	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Cfc	Lcom/tencent/mm/plugin/webview/model/ax;
          //   4507: invokevirtual 164	com/tencent/mm/plugin/webview/model/ax:eBM	()Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   4510: iconst_3
          //   4511: anewarray 4	java/lang/Object
          //   4514: dup
          //   4515: iconst_0
          //   4516: aload_0
          //   4517: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   4520: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4523: invokevirtual 167	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bLL	()Ljava/lang/String;
          //   4526: aastore
          //   4527: dup
          //   4528: iconst_1
          //   4529: bipush 34
          //   4531: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   4534: aastore
          //   4535: dup
          //   4536: iconst_2
          //   4537: iconst_1
          //   4538: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   4541: aastore
          //   4542: invokevirtual 173	com/tencent/mm/plugin/webview/model/ax$d:B	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   4545: invokevirtual 176	com/tencent/mm/plugin/webview/model/ax$d:report	()V
          //   4548: aload_0
          //   4549: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   4552: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4555: getfield 663	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:CAr	Lcom/tencent/mm/plugin/webview/ui/tools/b/a;
          //   4558: iconst_0
          //   4559: invokevirtual 669	com/tencent/mm/plugin/webview/ui/tools/b/a:ga	(Z)V
          //   4562: ldc 27
          //   4564: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   4567: return
          //   4568: aload_0
          //   4569: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   4572: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4575: getfield 158	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Cfc	Lcom/tencent/mm/plugin/webview/model/ax;
          //   4578: invokevirtual 164	com/tencent/mm/plugin/webview/model/ax:eBM	()Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   4581: iconst_3
          //   4582: anewarray 4	java/lang/Object
          //   4585: dup
          //   4586: iconst_0
          //   4587: aload_0
          //   4588: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   4591: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4594: invokevirtual 167	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bLL	()Ljava/lang/String;
          //   4597: aastore
          //   4598: dup
          //   4599: iconst_1
          //   4600: bipush 99
          //   4602: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   4605: aastore
          //   4606: dup
          //   4607: iconst_2
          //   4608: iconst_1
          //   4609: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   4612: aastore
          //   4613: invokevirtual 173	com/tencent/mm/plugin/webview/model/ax$d:B	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   4616: invokevirtual 176	com/tencent/mm/plugin/webview/model/ax$d:report	()V
          //   4619: aload_0
          //   4620: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   4623: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4626: invokevirtual 672	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:eEg	()V
          //   4629: ldc 27
          //   4631: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   4634: return
          //   4635: aload_0
          //   4636: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   4639: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4642: getfield 59	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Cjc	Lcom/tencent/mm/plugin/webview/c/f;
          //   4645: ldc_w 650
          //   4648: aconst_null
          //   4649: new 674	org/json/JSONObject
          //   4652: dup
          //   4653: invokespecial 675	org/json/JSONObject:<init>	()V
          //   4656: invokevirtual 678	com/tencent/mm/plugin/webview/c/f:b	(Ljava/lang/String;Ljava/util/Map;Lorg/json/JSONObject;)V
          //   4659: ldc 27
          //   4661: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   4664: return
          //   4665: iconst_0
          //   4666: istore_2
          //   4667: goto -4023 -> 644
          //   4670: iconst_0
          //   4671: istore_2
          //   4672: goto -4014 -> 658
          //   4675: astore_1
          //   4676: iconst_0
          //   4677: istore_2
          //   4678: ldc 139
          //   4680: aload_1
          //   4681: ldc_w 680
          //   4684: iconst_0
          //   4685: anewarray 4	java/lang/Object
          //   4688: invokestatic 684	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
          //   4691: goto -4033 -> 658
          //   4694: aload_0
          //   4695: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   4698: astore_1
          //   4699: aload_1
          //   4700: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4703: getfield 59	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Cjc	Lcom/tencent/mm/plugin/webview/c/f;
          //   4706: ldc_w 554
          //   4709: iconst_0
          //   4710: invokevirtual 502	com/tencent/mm/plugin/webview/c/f:cf	(Ljava/lang/String;Z)V
          //   4713: aload_1
          //   4714: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4717: getfield 59	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Cjc	Lcom/tencent/mm/plugin/webview/c/f;
          //   4720: astore_1
          //   4721: aload_1
          //   4722: getfield 64	com/tencent/mm/plugin/webview/c/f:Apr	Z
          //   4725: ifne +17 -> 4742
          //   4728: ldc 66
          //   4730: ldc_w 686
          //   4733: invokestatic 73	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   4736: ldc 27
          //   4738: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   4741: return
          //   4742: new 82	java/util/HashMap
          //   4745: dup
          //   4746: invokespecial 83	java/util/HashMap:<init>	()V
          //   4749: astore 5
          //   4751: aload 5
          //   4753: ldc_w 561
          //   4756: ldc_w 688
          //   4759: invokevirtual 92	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
          //   4762: pop
          //   4763: ldc_w 558
          //   4766: aload 5
          //   4768: aload_1
          //   4769: getfield 101	com/tencent/mm/plugin/webview/c/f:Cjz	Z
          //   4772: aload_1
          //   4773: getfield 104	com/tencent/mm/plugin/webview/c/f:CjA	Ljava/lang/String;
          //   4776: invokestatic 110	com/tencent/mm/plugin/webview/c/l$a:b	(Ljava/lang/String;Ljava/util/Map;ZLjava/lang/String;)Ljava/lang/String;
          //   4779: astore 5
          //   4781: aload_1
          //   4782: getfield 114	com/tencent/mm/plugin/webview/c/f:Cjr	Lcom/tencent/mm/ui/widget/MMWebView;
          //   4785: new 116	java/lang/StringBuilder
          //   4788: dup
          //   4789: ldc 118
          //   4791: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   4794: aload 5
          //   4796: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   4799: ldc 127
          //   4801: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   4804: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   4807: aconst_null
          //   4808: invokevirtual 137	com/tencent/mm/ui/widget/MMWebView:evaluateJavascript	(Ljava/lang/String;Landroid/webkit/ValueCallback;)V
          //   4811: aload_1
          //   4812: getfield 559	com/tencent/mm/plugin/webview/c/f:kYt	Lcom/tencent/mm/plugin/webview/stub/e;
          //   4815: ldc_w 690
          //   4818: aload 4
          //   4820: aload_1
          //   4821: getfield 567	com/tencent/mm/plugin/webview/c/f:CjB	I
          //   4824: invokeinterface 571 4 0
          //   4829: aload_1
          //   4830: getfield 559	com/tencent/mm/plugin/webview/c/f:kYt	Lcom/tencent/mm/plugin/webview/stub/e;
          //   4833: ldc_w 561
          //   4836: ldc_w 688
          //   4839: aload_1
          //   4840: getfield 567	com/tencent/mm/plugin/webview/c/f:CjB	I
          //   4843: invokeinterface 571 4 0
          //   4848: ldc 27
          //   4850: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   4853: return
          //   4854: astore_1
          //   4855: ldc 66
          //   4857: new 116	java/lang/StringBuilder
          //   4860: dup
          //   4861: ldc_w 573
          //   4864: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   4867: aload_1
          //   4868: invokevirtual 481	java/lang/Exception:getMessage	()Ljava/lang/String;
          //   4871: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   4874: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   4877: invokestatic 576	com/tencent/mm/sdk/platformtools/ac:w	(Ljava/lang/String;Ljava/lang/String;)V
          //   4880: ldc 27
          //   4882: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   4885: return
          //   4886: astore_1
          //   4887: goto -209 -> 4678
          //   4890: iconst_0
          //   4891: istore_2
          //   4892: goto -4234 -> 658
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	4895	0	this	14
          //   0	4895	1	paramAnonymousMenuItem	MenuItem
          //   0	4895	2	paramAnonymousInt	int
          //   650	4	3	i	int
          //   31	4788	4	localObject1	Object
          //   83	4712	5	localObject2	Object
          //   1888	49	6	locale	com.tencent.mm.plugin.webview.stub.e
          // Exception table:
          //   from	to	target	type
          //   2000	2014	2128	java/lang/Exception
          //   2014	2127	2128	java/lang/Exception
          //   2179	2193	2128	java/lang/Exception
          //   1936	1946	2155	java/lang/Exception
          //   3194	3213	3219	java/lang/Exception
          //   4019	4038	4044	java/lang/Exception
          //   588	626	4675	java/lang/Exception
          //   630	637	4675	java/lang/Exception
          //   4811	4848	4854	java/lang/Exception
          //   644	651	4886	java/lang/Exception
        }
      };
      this.mdB.ISv = ((n.d)localObject2);
      this.mdB.Ihj = new e.b()
      {
        public final void onDismiss()
        {
          i.this.nPt = false;
        }
      };
      if (eCT().kYu != null) {
        break label187;
      }
      ac.e("MicroMsg.WebViewMenuHelper", "get permission failed");
      AppMethodBeat.o(79887);
      return;
      bool = false;
      break;
    }
    label187:
    Object localObject3 = eCT().Cfr.kYu.eCm();
    this.mdB.ISu = new n.c()
    {
      /* Error */
      public final void onCreateMMMenu(l paramAnonymousl)
      {
        // Byte code:
        //   0: ldc 29
        //   2: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: getstatic 41	com/tencent/mm/plugin/report/service/h:wUl	Lcom/tencent/mm/plugin/report/service/h;
        //   8: ldc2_w 42
        //   11: lconst_0
        //   12: lconst_1
        //   13: iconst_0
        //   14: invokevirtual 47	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
        //   17: aload_1
        //   18: invokevirtual 52	com/tencent/mm/ui/base/l:clear	()V
        //   21: aload_0
        //   22: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   25: getfield 56	com/tencent/mm/plugin/webview/ui/tools/i:CxC	Ljava/lang/Boolean;
        //   28: invokevirtual 62	java/lang/Boolean:booleanValue	()Z
        //   31: ifeq +90 -> 121
        //   34: aload_0
        //   35: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   38: getfield 66	com/tencent/mm/plugin/webview/ui/tools/i:CxB	Ljava/util/ArrayList;
        //   41: invokevirtual 72	java/util/ArrayList:size	()I
        //   44: istore_3
        //   45: iconst_0
        //   46: istore_2
        //   47: iload_2
        //   48: iload_3
        //   49: if_icmpge +66 -> 115
        //   52: aload_0
        //   53: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   56: getfield 66	com/tencent/mm/plugin/webview/ui/tools/i:CxB	Ljava/util/ArrayList;
        //   59: iload_2
        //   60: invokevirtual 76	java/util/ArrayList:get	(I)Ljava/lang/Object;
        //   63: checkcast 78	com/tencent/mm/m/d$b
        //   66: astore 8
        //   68: aload_1
        //   69: aload 8
        //   71: getfield 82	com/tencent/mm/m/d$b:id	I
        //   74: aload 8
        //   76: getfield 86	com/tencent/mm/m/d$b:title	Ljava/lang/String;
        //   79: invokevirtual 90	com/tencent/mm/ui/base/l:c	(ILjava/lang/CharSequence;)Landroid/view/MenuItem;
        //   82: checkcast 92	com/tencent/mm/ui/base/m
        //   85: astore 9
        //   87: aload 9
        //   89: aload 8
        //   91: putfield 96	com/tencent/mm/ui/base/m:Hyn	Landroid/view/ContextMenu$ContextMenuInfo;
        //   94: aload 9
        //   96: aconst_null
        //   97: invokevirtual 100	com/tencent/mm/ui/base/m:setIcon	(Landroid/graphics/drawable/Drawable;)Landroid/view/MenuItem;
        //   100: pop
        //   101: aload 9
        //   103: iconst_0
        //   104: invokevirtual 103	com/tencent/mm/ui/base/m:setIcon	(I)Landroid/view/MenuItem;
        //   107: pop
        //   108: iload_2
        //   109: iconst_1
        //   110: iadd
        //   111: istore_2
        //   112: goto -65 -> 47
        //   115: ldc 29
        //   117: invokestatic 106	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   120: return
        //   121: aload_0
        //   122: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   125: iconst_1
        //   126: invokestatic 109	com/tencent/mm/plugin/webview/ui/tools/i:c	(Lcom/tencent/mm/plugin/webview/ui/tools/i;I)Z
        //   129: ifeq +70 -> 199
        //   132: aload_0
        //   133: getfield 21	com/tencent/mm/plugin/webview/ui/tools/i$16:CxG	Lcom/tencent/mm/protocal/JsapiPermissionWrapper;
        //   136: bipush 21
        //   138: invokestatic 113	com/tencent/mm/plugin/webview/ui/tools/i:a	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
        //   141: ifeq +58 -> 199
        //   144: aload_0
        //   145: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   148: iconst_1
        //   149: invokevirtual 117	com/tencent/mm/plugin/webview/ui/tools/i:VF	(I)Z
        //   152: ifeq +47 -> 199
        //   155: aload_1
        //   156: iconst_1
        //   157: aload_0
        //   158: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   161: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   164: ldc 122
        //   166: invokevirtual 128	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
        //   169: ldc 129
        //   171: aload_0
        //   172: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   175: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   178: invokevirtual 133	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getResources	()Landroid/content/res/Resources;
        //   181: ldc 134
        //   183: invokevirtual 140	android/content/res/Resources:getColor	(I)I
        //   186: aload_0
        //   187: getfield 21	com/tencent/mm/plugin/webview/ui/tools/i$16:CxG	Lcom/tencent/mm/protocal/JsapiPermissionWrapper;
        //   190: bipush 21
        //   192: invokestatic 143	com/tencent/mm/plugin/webview/ui/tools/i:b	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
        //   195: invokevirtual 146	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;IIZ)Landroid/view/MenuItem;
        //   198: pop
        //   199: aload_0
        //   200: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   203: iconst_2
        //   204: invokestatic 109	com/tencent/mm/plugin/webview/ui/tools/i:c	(Lcom/tencent/mm/plugin/webview/ui/tools/i;I)Z
        //   207: ifeq +56 -> 263
        //   210: aload_0
        //   211: getfield 21	com/tencent/mm/plugin/webview/ui/tools/i$16:CxG	Lcom/tencent/mm/protocal/JsapiPermissionWrapper;
        //   214: bipush 23
        //   216: invokestatic 113	com/tencent/mm/plugin/webview/ui/tools/i:a	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
        //   219: ifeq +44 -> 263
        //   222: aload_0
        //   223: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   226: iconst_2
        //   227: invokevirtual 117	com/tencent/mm/plugin/webview/ui/tools/i:VF	(I)Z
        //   230: ifeq +33 -> 263
        //   233: aload_1
        //   234: iconst_2
        //   235: aload_0
        //   236: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   239: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   242: ldc 147
        //   244: invokevirtual 128	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
        //   247: ldc 148
        //   249: iconst_0
        //   250: aload_0
        //   251: getfield 21	com/tencent/mm/plugin/webview/ui/tools/i$16:CxG	Lcom/tencent/mm/protocal/JsapiPermissionWrapper;
        //   254: bipush 23
        //   256: invokestatic 143	com/tencent/mm/plugin/webview/ui/tools/i:b	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
        //   259: invokevirtual 146	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;IIZ)Landroid/view/MenuItem;
        //   262: pop
        //   263: new 150	android/os/Bundle
        //   266: dup
        //   267: invokespecial 151	android/os/Bundle:<init>	()V
        //   270: astore 8
        //   272: aload 8
        //   274: ldc 153
        //   276: aload_0
        //   277: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   280: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   283: getfield 157	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Cfr	Lcom/tencent/mm/plugin/webview/core/h;
        //   286: invokevirtual 162	com/tencent/mm/plugin/webview/core/h:eyt	()I
        //   289: invokevirtual 166	android/os/Bundle:putInt	(Ljava/lang/String;I)V
        //   292: aload 8
        //   294: ldc 168
        //   296: aload_0
        //   297: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   300: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   303: getfield 157	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Cfr	Lcom/tencent/mm/plugin/webview/core/h;
        //   306: getfield 174	com/tencent/mm/plugin/webview/core/BaseWebViewController:nKq	Lcom/tencent/mm/ui/widget/MMWebView;
        //   309: invokevirtual 180	com/tencent/mm/ui/widget/MMWebView:getUrl	()Ljava/lang/String;
        //   312: invokevirtual 184	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
        //   315: aload_0
        //   316: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   319: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   322: getfield 157	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Cfr	Lcom/tencent/mm/plugin/webview/core/h;
        //   325: getfield 188	com/tencent/mm/plugin/webview/core/h:kYt	Lcom/tencent/mm/plugin/webview/stub/e;
        //   328: bipush 109
        //   330: aload 8
        //   332: invokeinterface 194 3 0
        //   337: astore 8
        //   339: aload 8
        //   341: ifnull +1741 -> 2082
        //   344: aload 8
        //   346: ldc 196
        //   348: iconst_0
        //   349: invokevirtual 200	android/os/Bundle:getInt	(Ljava/lang/String;I)I
        //   352: istore_2
        //   353: aload 8
        //   355: ldc 202
        //   357: iconst_m1
        //   358: invokevirtual 200	android/os/Bundle:getInt	(Ljava/lang/String;I)I
        //   361: istore 4
        //   363: iload_2
        //   364: istore_3
        //   365: iload 4
        //   367: istore_2
        //   368: iload_3
        //   369: iconst_1
        //   370: if_icmpne +67 -> 437
        //   373: aload_0
        //   374: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   377: bipush 38
        //   379: invokestatic 109	com/tencent/mm/plugin/webview/ui/tools/i:c	(Lcom/tencent/mm/plugin/webview/ui/tools/i;I)Z
        //   382: ifeq +1531 -> 1913
        //   385: aload_0
        //   386: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   389: bipush 38
        //   391: invokevirtual 117	com/tencent/mm/plugin/webview/ui/tools/i:VF	(I)Z
        //   394: ifeq +1519 -> 1913
        //   397: iload_2
        //   398: ifne +1515 -> 1913
        //   401: aload_1
        //   402: bipush 38
        //   404: aload_0
        //   405: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   408: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   411: ldc 203
        //   413: invokevirtual 128	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
        //   416: ldc 204
        //   418: aload_0
        //   419: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   422: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   425: invokevirtual 133	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getResources	()Landroid/content/res/Resources;
        //   428: ldc 205
        //   430: invokevirtual 140	android/content/res/Resources:getColor	(I)I
        //   433: invokevirtual 208	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;II)Landroid/view/MenuItem;
        //   436: pop
        //   437: aload_0
        //   438: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   441: iconst_3
        //   442: invokestatic 109	com/tencent/mm/plugin/webview/ui/tools/i:c	(Lcom/tencent/mm/plugin/webview/ui/tools/i;I)Z
        //   445: ifeq +139 -> 584
        //   448: aload_0
        //   449: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   452: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   455: getfield 212	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Czs	Z
        //   458: ifeq +61 -> 519
        //   461: aload_0
        //   462: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   465: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   468: invokevirtual 215	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:eDS	()Ljava/lang/String;
        //   471: invokestatic 221	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
        //   474: ifne +110 -> 584
        //   477: aload_0
        //   478: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   481: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   484: getfield 224	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:CAN	Ljava/lang/String;
        //   487: invokestatic 221	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
        //   490: ifne +94 -> 584
        //   493: aload_0
        //   494: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   497: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   500: invokevirtual 215	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:eDS	()Ljava/lang/String;
        //   503: aload_0
        //   504: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   507: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   510: getfield 224	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:CAN	Ljava/lang/String;
        //   513: invokevirtual 229	java/lang/String:startsWith	(Ljava/lang/String;)Z
        //   516: ifne +68 -> 584
        //   519: aload_0
        //   520: getfield 21	com/tencent/mm/plugin/webview/ui/tools/i$16:CxG	Lcom/tencent/mm/protocal/JsapiPermissionWrapper;
        //   523: sipush 323
        //   526: invokestatic 113	com/tencent/mm/plugin/webview/ui/tools/i:a	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
        //   529: ifeq +55 -> 584
        //   532: aload_0
        //   533: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   536: invokevirtual 232	com/tencent/mm/plugin/webview/ui/tools/i:eDs	()Z
        //   539: ifeq +45 -> 584
        //   542: aload_0
        //   543: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   546: iconst_3
        //   547: invokevirtual 117	com/tencent/mm/plugin/webview/ui/tools/i:VF	(I)Z
        //   550: ifeq +34 -> 584
        //   553: aload_1
        //   554: iconst_3
        //   555: aload_0
        //   556: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   559: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   562: ldc 233
        //   564: invokevirtual 128	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
        //   567: ldc 234
        //   569: iconst_0
        //   570: aload_0
        //   571: getfield 21	com/tencent/mm/plugin/webview/ui/tools/i$16:CxG	Lcom/tencent/mm/protocal/JsapiPermissionWrapper;
        //   574: sipush 323
        //   577: invokestatic 143	com/tencent/mm/plugin/webview/ui/tools/i:b	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
        //   580: invokevirtual 146	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;IIZ)Landroid/view/MenuItem;
        //   583: pop
        //   584: aload_0
        //   585: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   588: bipush 25
        //   590: invokestatic 109	com/tencent/mm/plugin/webview/ui/tools/i:c	(Lcom/tencent/mm/plugin/webview/ui/tools/i;I)Z
        //   593: ifeq +104 -> 697
        //   596: aload_0
        //   597: getfield 21	com/tencent/mm/plugin/webview/ui/tools/i$16:CxG	Lcom/tencent/mm/protocal/JsapiPermissionWrapper;
        //   600: sipush 322
        //   603: invokestatic 113	com/tencent/mm/plugin/webview/ui/tools/i:a	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
        //   606: ifeq +91 -> 697
        //   609: aload_0
        //   610: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   613: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   616: invokestatic 240	com/tencent/wework/api/WWAPIFactory:lg	(Landroid/content/Context;)Lcom/tencent/wework/api/IWWAPI;
        //   619: invokeinterface 245 1 0
        //   624: ifeq +73 -> 697
        //   627: aload_0
        //   628: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   631: bipush 25
        //   633: invokevirtual 117	com/tencent/mm/plugin/webview/ui/tools/i:VF	(I)Z
        //   636: ifeq +61 -> 697
        //   639: aload_0
        //   640: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   643: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   646: invokestatic 240	com/tencent/wework/api/WWAPIFactory:lg	(Landroid/content/Context;)Lcom/tencent/wework/api/IWWAPI;
        //   649: invokeinterface 248 1 0
        //   654: astore 8
        //   656: aload_1
        //   657: bipush 25
        //   659: aload_0
        //   660: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   663: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   666: ldc 249
        //   668: iconst_1
        //   669: anewarray 4	java/lang/Object
        //   672: dup
        //   673: iconst_0
        //   674: aload 8
        //   676: aastore
        //   677: invokevirtual 252	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
        //   680: ldc 253
        //   682: iconst_0
        //   683: aload_0
        //   684: getfield 21	com/tencent/mm/plugin/webview/ui/tools/i$16:CxG	Lcom/tencent/mm/protocal/JsapiPermissionWrapper;
        //   687: sipush 322
        //   690: invokestatic 143	com/tencent/mm/plugin/webview/ui/tools/i:b	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
        //   693: invokevirtual 146	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;IIZ)Landroid/view/MenuItem;
        //   696: pop
        //   697: aload_0
        //   698: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   701: bipush 33
        //   703: invokestatic 109	com/tencent/mm/plugin/webview/ui/tools/i:c	(Lcom/tencent/mm/plugin/webview/ui/tools/i;I)Z
        //   706: ifeq +90 -> 796
        //   709: aload_0
        //   710: getfield 21	com/tencent/mm/plugin/webview/ui/tools/i$16:CxG	Lcom/tencent/mm/protocal/JsapiPermissionWrapper;
        //   713: bipush 31
        //   715: invokestatic 113	com/tencent/mm/plugin/webview/ui/tools/i:a	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
        //   718: ifeq +78 -> 796
        //   721: aload_0
        //   722: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   725: bipush 30
        //   727: invokevirtual 117	com/tencent/mm/plugin/webview/ui/tools/i:VF	(I)Z
        //   730: ifeq +66 -> 796
        //   733: aload_0
        //   734: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   737: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   740: getfield 157	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Cfr	Lcom/tencent/mm/plugin/webview/core/h;
        //   743: getfield 188	com/tencent/mm/plugin/webview/core/h:kYt	Lcom/tencent/mm/plugin/webview/stub/e;
        //   746: bipush 78
        //   748: aconst_null
        //   749: invokeinterface 194 3 0
        //   754: ldc 255
        //   756: iconst_0
        //   757: invokevirtual 259	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
        //   760: ifeq +36 -> 796
        //   763: aload_1
        //   764: bipush 33
        //   766: aload_0
        //   767: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   770: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   773: ldc_w 260
        //   776: invokevirtual 128	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
        //   779: ldc_w 261
        //   782: iconst_0
        //   783: aload_0
        //   784: getfield 21	com/tencent/mm/plugin/webview/ui/tools/i$16:CxG	Lcom/tencent/mm/protocal/JsapiPermissionWrapper;
        //   787: bipush 31
        //   789: invokestatic 143	com/tencent/mm/plugin/webview/ui/tools/i:b	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
        //   792: invokevirtual 146	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;IIZ)Landroid/view/MenuItem;
        //   795: pop
        //   796: aload_0
        //   797: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   800: bipush 26
        //   802: invokestatic 109	com/tencent/mm/plugin/webview/ui/tools/i:c	(Lcom/tencent/mm/plugin/webview/ui/tools/i;I)Z
        //   805: ifeq +88 -> 893
        //   808: aload_0
        //   809: getfield 21	com/tencent/mm/plugin/webview/ui/tools/i$16:CxG	Lcom/tencent/mm/protocal/JsapiPermissionWrapper;
        //   812: sipush 278
        //   815: invokestatic 113	com/tencent/mm/plugin/webview/ui/tools/i:a	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
        //   818: ifeq +75 -> 893
        //   821: aload_0
        //   822: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   825: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   828: aload_0
        //   829: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   832: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   835: getfield 262	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:nKq	Lcom/tencent/mm/ui/widget/MMWebView;
        //   838: invokevirtual 180	com/tencent/mm/ui/widget/MMWebView:getUrl	()Ljava/lang/String;
        //   841: invokestatic 268	com/tencent/mm/plugin/webview/stub/a:bx	(Landroid/content/Context;Ljava/lang/String;)Z
        //   844: ifeq +49 -> 893
        //   847: aload_0
        //   848: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   851: bipush 26
        //   853: invokevirtual 117	com/tencent/mm/plugin/webview/ui/tools/i:VF	(I)Z
        //   856: ifeq +37 -> 893
        //   859: aload_1
        //   860: bipush 26
        //   862: aload_0
        //   863: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   866: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   869: ldc_w 269
        //   872: invokevirtual 128	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
        //   875: ldc_w 270
        //   878: iconst_0
        //   879: aload_0
        //   880: getfield 21	com/tencent/mm/plugin/webview/ui/tools/i$16:CxG	Lcom/tencent/mm/protocal/JsapiPermissionWrapper;
        //   883: sipush 278
        //   886: invokestatic 143	com/tencent/mm/plugin/webview/ui/tools/i:b	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
        //   889: invokevirtual 146	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;IIZ)Landroid/view/MenuItem;
        //   892: pop
        //   893: aload_0
        //   894: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   897: bipush 7
        //   899: invokestatic 109	com/tencent/mm/plugin/webview/ui/tools/i:c	(Lcom/tencent/mm/plugin/webview/ui/tools/i;I)Z
        //   902: ifeq +75 -> 977
        //   905: aload_0
        //   906: getfield 21	com/tencent/mm/plugin/webview/ui/tools/i$16:CxG	Lcom/tencent/mm/protocal/JsapiPermissionWrapper;
        //   909: bipush 45
        //   911: invokestatic 113	com/tencent/mm/plugin/webview/ui/tools/i:a	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
        //   914: ifeq +63 -> 977
        //   917: aload_0
        //   918: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   921: bipush 7
        //   923: invokevirtual 117	com/tencent/mm/plugin/webview/ui/tools/i:VF	(I)Z
        //   926: ifeq +51 -> 977
        //   929: aload_1
        //   930: bipush 7
        //   932: aload_0
        //   933: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   936: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   939: ldc_w 271
        //   942: invokevirtual 128	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
        //   945: ldc_w 272
        //   948: aload_0
        //   949: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   952: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   955: invokevirtual 133	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getResources	()Landroid/content/res/Resources;
        //   958: ldc_w 273
        //   961: invokevirtual 140	android/content/res/Resources:getColor	(I)I
        //   964: aload_0
        //   965: getfield 21	com/tencent/mm/plugin/webview/ui/tools/i$16:CxG	Lcom/tencent/mm/protocal/JsapiPermissionWrapper;
        //   968: bipush 45
        //   970: invokestatic 143	com/tencent/mm/plugin/webview/ui/tools/i:b	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
        //   973: invokevirtual 146	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;IIZ)Landroid/view/MenuItem;
        //   976: pop
        //   977: aload_0
        //   978: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   981: invokevirtual 276	com/tencent/mm/plugin/webview/ui/tools/a:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   984: invokevirtual 280	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
        //   987: ldc_w 282
        //   990: invokevirtual 288	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
        //   993: astore 8
        //   995: aload_0
        //   996: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   999: invokevirtual 276	com/tencent/mm/plugin/webview/ui/tools/a:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   1002: invokevirtual 280	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
        //   1005: ldc_w 290
        //   1008: ldc2_w 291
        //   1011: invokevirtual 296	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
        //   1014: lstore 5
        //   1016: aload_0
        //   1017: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1020: bipush 23
        //   1022: invokestatic 109	com/tencent/mm/plugin/webview/ui/tools/i:c	(Lcom/tencent/mm/plugin/webview/ui/tools/i;I)Z
        //   1025: ifeq +51 -> 1076
        //   1028: aload_0
        //   1029: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1032: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   1035: getfield 157	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Cfr	Lcom/tencent/mm/plugin/webview/core/h;
        //   1038: getfield 188	com/tencent/mm/plugin/webview/core/h:kYt	Lcom/tencent/mm/plugin/webview/stub/e;
        //   1041: lload 5
        //   1043: aload 8
        //   1045: invokeinterface 300 4 0
        //   1050: ifeq +26 -> 1076
        //   1053: aload_1
        //   1054: bipush 23
        //   1056: aload_0
        //   1057: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1060: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   1063: ldc_w 301
        //   1066: invokevirtual 128	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
        //   1069: ldc_w 302
        //   1072: invokevirtual 305	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;I)Landroid/view/MenuItem;
        //   1075: pop
        //   1076: aload_0
        //   1077: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1080: bipush 24
        //   1082: invokestatic 109	com/tencent/mm/plugin/webview/ui/tools/i:c	(Lcom/tencent/mm/plugin/webview/ui/tools/i;I)Z
        //   1085: ifeq +139 -> 1224
        //   1088: aload_0
        //   1089: getfield 21	com/tencent/mm/plugin/webview/ui/tools/i$16:CxG	Lcom/tencent/mm/protocal/JsapiPermissionWrapper;
        //   1092: bipush 43
        //   1094: invokestatic 113	com/tencent/mm/plugin/webview/ui/tools/i:a	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
        //   1097: ifeq +127 -> 1224
        //   1100: aload_0
        //   1101: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1104: bipush 24
        //   1106: invokevirtual 117	com/tencent/mm/plugin/webview/ui/tools/i:VF	(I)Z
        //   1109: ifeq +115 -> 1224
        //   1112: aload_0
        //   1113: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1116: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   1119: ldc_w 307
        //   1122: invokestatic 312	com/tencent/mm/pluginsdk/model/app/q:t	(Landroid/content/Context;Ljava/lang/String;)Z
        //   1125: ifne +99 -> 1224
        //   1128: new 150	android/os/Bundle
        //   1131: dup
        //   1132: invokespecial 151	android/os/Bundle:<init>	()V
        //   1135: astore 8
        //   1137: aload 8
        //   1139: ldc_w 314
        //   1142: ldc_w 316
        //   1145: invokevirtual 184	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
        //   1148: aload_0
        //   1149: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1152: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   1155: getfield 157	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Cfr	Lcom/tencent/mm/plugin/webview/core/h;
        //   1158: getfield 188	com/tencent/mm/plugin/webview/core/h:kYt	Lcom/tencent/mm/plugin/webview/stub/e;
        //   1161: bipush 71
        //   1163: aload 8
        //   1165: invokeinterface 194 3 0
        //   1170: astore 8
        //   1172: aload 8
        //   1174: ifnull +866 -> 2040
        //   1177: aload 8
        //   1179: ldc_w 316
        //   1182: invokevirtual 318	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
        //   1185: istore 7
        //   1187: iload 7
        //   1189: ifeq +35 -> 1224
        //   1192: aload_1
        //   1193: bipush 24
        //   1195: aload_0
        //   1196: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1199: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   1202: ldc_w 319
        //   1205: invokevirtual 128	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
        //   1208: ldc_w 320
        //   1211: aload_0
        //   1212: getfield 21	com/tencent/mm/plugin/webview/ui/tools/i$16:CxG	Lcom/tencent/mm/protocal/JsapiPermissionWrapper;
        //   1215: bipush 43
        //   1217: invokestatic 143	com/tencent/mm/plugin/webview/ui/tools/i:b	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
        //   1220: invokevirtual 323	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;IZ)Landroid/view/MenuItem;
        //   1223: pop
        //   1224: aload_0
        //   1225: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1228: bipush 8
        //   1230: invokestatic 109	com/tencent/mm/plugin/webview/ui/tools/i:c	(Lcom/tencent/mm/plugin/webview/ui/tools/i;I)Z
        //   1233: ifeq +110 -> 1343
        //   1236: aload_0
        //   1237: getfield 21	com/tencent/mm/plugin/webview/ui/tools/i$16:CxG	Lcom/tencent/mm/protocal/JsapiPermissionWrapper;
        //   1240: bipush 36
        //   1242: invokestatic 113	com/tencent/mm/plugin/webview/ui/tools/i:a	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
        //   1245: ifeq +98 -> 1343
        //   1248: aload_0
        //   1249: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1252: bipush 8
        //   1254: invokevirtual 117	com/tencent/mm/plugin/webview/ui/tools/i:VF	(I)Z
        //   1257: ifeq +86 -> 1343
        //   1260: aconst_null
        //   1261: astore 8
        //   1263: aload_0
        //   1264: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1267: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   1270: getfield 157	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Cfr	Lcom/tencent/mm/plugin/webview/core/h;
        //   1273: getfield 188	com/tencent/mm/plugin/webview/core/h:kYt	Lcom/tencent/mm/plugin/webview/stub/e;
        //   1276: invokeinterface 326 1 0
        //   1281: astore 9
        //   1283: aload 9
        //   1285: astore 8
        //   1287: aload 8
        //   1289: invokestatic 221	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
        //   1292: ifne +754 -> 2046
        //   1295: aload_1
        //   1296: bipush 8
        //   1298: aload_0
        //   1299: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1302: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   1305: ldc_w 327
        //   1308: invokevirtual 128	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
        //   1311: ldc_w 328
        //   1314: aload_0
        //   1315: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1318: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   1321: invokevirtual 133	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getResources	()Landroid/content/res/Resources;
        //   1324: ldc_w 273
        //   1327: invokevirtual 140	android/content/res/Resources:getColor	(I)I
        //   1330: aload_0
        //   1331: getfield 21	com/tencent/mm/plugin/webview/ui/tools/i$16:CxG	Lcom/tencent/mm/protocal/JsapiPermissionWrapper;
        //   1334: bipush 36
        //   1336: invokestatic 143	com/tencent/mm/plugin/webview/ui/tools/i:b	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
        //   1339: invokevirtual 146	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;IIZ)Landroid/view/MenuItem;
        //   1342: pop
        //   1343: aload_0
        //   1344: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1347: bipush 20
        //   1349: invokestatic 109	com/tencent/mm/plugin/webview/ui/tools/i:c	(Lcom/tencent/mm/plugin/webview/ui/tools/i;I)Z
        //   1352: ifeq +73 -> 1425
        //   1355: aload_0
        //   1356: getfield 21	com/tencent/mm/plugin/webview/ui/tools/i$16:CxG	Lcom/tencent/mm/protocal/JsapiPermissionWrapper;
        //   1359: bipush 91
        //   1361: invokestatic 113	com/tencent/mm/plugin/webview/ui/tools/i:a	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
        //   1364: ifeq +61 -> 1425
        //   1367: aload_0
        //   1368: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1371: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   1374: invokestatic 332	com/tencent/mm/plugin/webview/stub/a:gP	(Landroid/content/Context;)Z
        //   1377: ifeq +48 -> 1425
        //   1380: aload_0
        //   1381: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1384: bipush 20
        //   1386: invokevirtual 117	com/tencent/mm/plugin/webview/ui/tools/i:VF	(I)Z
        //   1389: ifeq +36 -> 1425
        //   1392: aload_1
        //   1393: bipush 20
        //   1395: aload_0
        //   1396: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1399: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   1402: ldc_w 333
        //   1405: invokevirtual 128	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
        //   1408: ldc_w 334
        //   1411: iconst_0
        //   1412: aload_0
        //   1413: getfield 21	com/tencent/mm/plugin/webview/ui/tools/i$16:CxG	Lcom/tencent/mm/protocal/JsapiPermissionWrapper;
        //   1416: bipush 91
        //   1418: invokestatic 143	com/tencent/mm/plugin/webview/ui/tools/i:b	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
        //   1421: invokevirtual 146	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;IIZ)Landroid/view/MenuItem;
        //   1424: pop
        //   1425: aload_0
        //   1426: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1429: bipush 22
        //   1431: invokestatic 109	com/tencent/mm/plugin/webview/ui/tools/i:c	(Lcom/tencent/mm/plugin/webview/ui/tools/i;I)Z
        //   1434: ifeq +75 -> 1509
        //   1437: aload_0
        //   1438: getfield 21	com/tencent/mm/plugin/webview/ui/tools/i$16:CxG	Lcom/tencent/mm/protocal/JsapiPermissionWrapper;
        //   1441: sipush 133
        //   1444: invokestatic 113	com/tencent/mm/plugin/webview/ui/tools/i:a	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
        //   1447: ifeq +62 -> 1509
        //   1450: aload_0
        //   1451: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1454: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   1457: invokestatic 332	com/tencent/mm/plugin/webview/stub/a:gP	(Landroid/content/Context;)Z
        //   1460: ifeq +49 -> 1509
        //   1463: aload_0
        //   1464: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1467: bipush 22
        //   1469: invokevirtual 117	com/tencent/mm/plugin/webview/ui/tools/i:VF	(I)Z
        //   1472: ifeq +37 -> 1509
        //   1475: aload_1
        //   1476: bipush 22
        //   1478: aload_0
        //   1479: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1482: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   1485: ldc_w 335
        //   1488: invokevirtual 128	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
        //   1491: ldc_w 336
        //   1494: iconst_0
        //   1495: aload_0
        //   1496: getfield 21	com/tencent/mm/plugin/webview/ui/tools/i$16:CxG	Lcom/tencent/mm/protocal/JsapiPermissionWrapper;
        //   1499: sipush 133
        //   1502: invokestatic 143	com/tencent/mm/plugin/webview/ui/tools/i:b	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
        //   1505: invokevirtual 146	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;IIZ)Landroid/view/MenuItem;
        //   1508: pop
        //   1509: aload_0
        //   1510: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1513: iconst_0
        //   1514: invokestatic 109	com/tencent/mm/plugin/webview/ui/tools/i:c	(Lcom/tencent/mm/plugin/webview/ui/tools/i;I)Z
        //   1517: ifeq +133 -> 1650
        //   1520: aload_0
        //   1521: getfield 21	com/tencent/mm/plugin/webview/ui/tools/i$16:CxG	Lcom/tencent/mm/protocal/JsapiPermissionWrapper;
        //   1524: bipush 43
        //   1526: invokestatic 113	com/tencent/mm/plugin/webview/ui/tools/i:a	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
        //   1529: ifeq +121 -> 1650
        //   1532: aload_0
        //   1533: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1536: iconst_0
        //   1537: invokevirtual 117	com/tencent/mm/plugin/webview/ui/tools/i:VF	(I)Z
        //   1540: ifeq +110 -> 1650
        //   1543: aload_0
        //   1544: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1547: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   1550: getfield 157	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Cfr	Lcom/tencent/mm/plugin/webview/core/h;
        //   1553: getfield 188	com/tencent/mm/plugin/webview/core/h:kYt	Lcom/tencent/mm/plugin/webview/stub/e;
        //   1556: invokeinterface 339 1 0
        //   1561: ifeq +89 -> 1650
        //   1564: aload_0
        //   1565: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1568: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   1571: getfield 157	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Cfr	Lcom/tencent/mm/plugin/webview/core/h;
        //   1574: getfield 188	com/tencent/mm/plugin/webview/core/h:kYt	Lcom/tencent/mm/plugin/webview/stub/e;
        //   1577: invokeinterface 343 1 0
        //   1582: astore 8
        //   1584: aload 8
        //   1586: invokeinterface 349 1 0
        //   1591: astore 9
        //   1593: aload 9
        //   1595: invokeinterface 354 1 0
        //   1600: ifeq +458 -> 2058
        //   1603: aload_1
        //   1604: aload 9
        //   1606: invokeinterface 358 1 0
        //   1611: checkcast 226	java/lang/String
        //   1614: invokevirtual 362	com/tencent/mm/ui/base/l:add	(Ljava/lang/CharSequence;)Landroid/view/MenuItem;
        //   1617: pop
        //   1618: goto -25 -> 1593
        //   1621: astore 8
        //   1623: ldc_w 364
        //   1626: new 366	java/lang/StringBuilder
        //   1629: dup
        //   1630: ldc_w 368
        //   1633: invokespecial 371	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   1636: aload 8
        //   1638: invokevirtual 374	java/lang/Exception:getMessage	()Ljava/lang/String;
        //   1641: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1644: invokevirtual 381	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   1647: invokestatic 386	com/tencent/mm/sdk/platformtools/ac:w	(Ljava/lang/String;Ljava/lang/String;)V
        //   1650: aload_0
        //   1651: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1654: bipush 27
        //   1656: invokestatic 109	com/tencent/mm/plugin/webview/ui/tools/i:c	(Lcom/tencent/mm/plugin/webview/ui/tools/i;I)Z
        //   1659: ifeq +55 -> 1714
        //   1662: aload_0
        //   1663: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1666: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   1669: getfield 390	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Czb	Lcom/tencent/mm/plugin/webview/ui/tools/widget/MovingImageButton;
        //   1672: ifnull +42 -> 1714
        //   1675: aload_0
        //   1676: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1679: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   1682: getfield 390	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Czb	Lcom/tencent/mm/plugin/webview/ui/tools/widget/MovingImageButton;
        //   1685: invokevirtual 395	com/tencent/mm/plugin/webview/ui/tools/widget/MovingImageButton:getVisibility	()I
        //   1688: ifne +26 -> 1714
        //   1691: aload_1
        //   1692: bipush 27
        //   1694: aload_0
        //   1695: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1698: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   1701: ldc_w 396
        //   1704: invokevirtual 128	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
        //   1707: ldc_w 397
        //   1710: invokevirtual 305	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;I)Landroid/view/MenuItem;
        //   1713: pop
        //   1714: aload_0
        //   1715: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1718: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   1721: aload_0
        //   1722: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1725: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   1728: invokevirtual 215	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:eDS	()Ljava/lang/String;
        //   1731: invokevirtual 400	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:aAP	(Ljava/lang/String;)Ljava/lang/String;
        //   1734: astore 8
        //   1736: aload_0
        //   1737: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1740: invokevirtual 276	com/tencent/mm/plugin/webview/ui/tools/a:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   1743: invokevirtual 280	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
        //   1746: ldc_w 402
        //   1749: invokevirtual 288	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
        //   1752: astore 9
        //   1754: aload_0
        //   1755: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1758: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   1761: getfield 405	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Czu	Z
        //   1764: ifne +89 -> 1853
        //   1767: aload 8
        //   1769: invokestatic 221	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
        //   1772: ifne +81 -> 1853
        //   1775: aload 9
        //   1777: invokestatic 221	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
        //   1780: ifne +73 -> 1853
        //   1783: aload_0
        //   1784: getfield 21	com/tencent/mm/plugin/webview/ui/tools/i$16:CxG	Lcom/tencent/mm/protocal/JsapiPermissionWrapper;
        //   1787: sipush 255
        //   1790: invokestatic 113	com/tencent/mm/plugin/webview/ui/tools/i:a	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
        //   1793: ifeq +60 -> 1853
        //   1796: aload_0
        //   1797: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1800: bipush 29
        //   1802: invokevirtual 117	com/tencent/mm/plugin/webview/ui/tools/i:VF	(I)Z
        //   1805: ifeq +48 -> 1853
        //   1808: aload_0
        //   1809: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1812: bipush 29
        //   1814: invokestatic 109	com/tencent/mm/plugin/webview/ui/tools/i:c	(Lcom/tencent/mm/plugin/webview/ui/tools/i;I)Z
        //   1817: ifeq +36 -> 1853
        //   1820: aload_1
        //   1821: bipush 29
        //   1823: aload_0
        //   1824: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1827: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   1830: ldc_w 406
        //   1833: invokevirtual 128	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
        //   1836: ldc_w 407
        //   1839: aload_0
        //   1840: getfield 21	com/tencent/mm/plugin/webview/ui/tools/i$16:CxG	Lcom/tencent/mm/protocal/JsapiPermissionWrapper;
        //   1843: sipush 255
        //   1846: invokestatic 143	com/tencent/mm/plugin/webview/ui/tools/i:b	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
        //   1849: invokevirtual 323	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;IZ)Landroid/view/MenuItem;
        //   1852: pop
        //   1853: aload_0
        //   1854: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1857: iconst_1
        //   1858: putfield 410	com/tencent/mm/plugin/webview/ui/tools/i:nPt	Z
        //   1861: aload_0
        //   1862: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1865: getfield 414	com/tencent/mm/plugin/webview/ui/tools/i:mdB	Lcom/tencent/mm/ui/widget/a/e;
        //   1868: invokevirtual 419	com/tencent/mm/ui/widget/a/e:fvu	()V
        //   1871: ldc 29
        //   1873: invokestatic 106	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   1876: return
        //   1877: astore 8
        //   1879: iconst_m1
        //   1880: istore_3
        //   1881: ldc_w 364
        //   1884: new 366	java/lang/StringBuilder
        //   1887: dup
        //   1888: ldc_w 421
        //   1891: invokespecial 371	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   1894: aload 8
        //   1896: invokevirtual 374	java/lang/Exception:getMessage	()Ljava/lang/String;
        //   1899: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1902: invokevirtual 381	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   1905: invokestatic 424	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   1908: iconst_m1
        //   1909: istore_2
        //   1910: goto -1542 -> 368
        //   1913: aload_0
        //   1914: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1917: bipush 39
        //   1919: invokevirtual 117	com/tencent/mm/plugin/webview/ui/tools/i:VF	(I)Z
        //   1922: ifeq -1485 -> 437
        //   1925: iload_2
        //   1926: iconst_1
        //   1927: if_icmpne -1490 -> 437
        //   1930: aload_1
        //   1931: bipush 39
        //   1933: aload_0
        //   1934: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1937: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   1940: ldc_w 425
        //   1943: invokevirtual 128	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
        //   1946: ldc_w 426
        //   1949: aload_0
        //   1950: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1953: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:eCT	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   1956: invokevirtual 133	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getResources	()Landroid/content/res/Resources;
        //   1959: ldc 205
        //   1961: invokevirtual 140	android/content/res/Resources:getColor	(I)I
        //   1964: invokevirtual 208	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;II)Landroid/view/MenuItem;
        //   1967: pop
        //   1968: goto -1531 -> 437
        //   1971: astore 8
        //   1973: ldc_w 364
        //   1976: aload 8
        //   1978: ldc_w 428
        //   1981: iconst_0
        //   1982: anewarray 4	java/lang/Object
        //   1985: invokestatic 432	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   1988: goto -1192 -> 796
        //   1991: astore 8
        //   1993: ldc_w 364
        //   1996: aload 8
        //   1998: ldc_w 428
        //   2001: iconst_0
        //   2002: anewarray 4	java/lang/Object
        //   2005: invokestatic 432	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   2008: goto -932 -> 1076
        //   2011: astore 8
        //   2013: ldc_w 364
        //   2016: new 366	java/lang/StringBuilder
        //   2019: dup
        //   2020: ldc_w 368
        //   2023: invokespecial 371	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   2026: aload 8
        //   2028: invokevirtual 374	java/lang/Exception:getMessage	()Ljava/lang/String;
        //   2031: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   2034: invokevirtual 381	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   2037: invokestatic 386	com/tencent/mm/sdk/platformtools/ac:w	(Ljava/lang/String;Ljava/lang/String;)V
        //   2040: iconst_0
        //   2041: istore 7
        //   2043: goto -856 -> 1187
        //   2046: ldc_w 364
        //   2049: ldc_w 434
        //   2052: invokestatic 436	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   2055: goto -712 -> 1343
        //   2058: aload_0
        //   2059: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:CxD	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   2062: aload 8
        //   2064: invokestatic 439	com/tencent/mm/plugin/webview/ui/tools/i:a	(Lcom/tencent/mm/plugin/webview/ui/tools/i;Ljava/util/List;)V
        //   2067: goto -417 -> 1650
        //   2070: astore 9
        //   2072: goto -785 -> 1287
        //   2075: astore 8
        //   2077: iload_2
        //   2078: istore_3
        //   2079: goto -198 -> 1881
        //   2082: iconst_m1
        //   2083: istore_2
        //   2084: iconst_m1
        //   2085: istore_3
        //   2086: goto -1718 -> 368
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	2089	0	this	16
        //   0	2089	1	paramAnonymousl	l
        //   46	2038	2	i	int
        //   44	2042	3	j	int
        //   361	5	4	k	int
        //   1014	28	5	l	long
        //   1185	857	7	bool	boolean
        //   66	1519	8	localObject1	Object
        //   1621	16	8	localException1	Exception
        //   1734	34	8	str	String
        //   1877	18	8	localException2	Exception
        //   1971	6	8	localException3	Exception
        //   1991	6	8	localException4	Exception
        //   2011	52	8	localException5	Exception
        //   2075	1	8	localException6	Exception
        //   85	1691	9	localObject2	Object
        //   2070	1	9	localException7	Exception
        // Exception table:
        //   from	to	target	type
        //   1509	1593	1621	java/lang/Exception
        //   1593	1618	1621	java/lang/Exception
        //   2058	2067	1621	java/lang/Exception
        //   263	339	1877	java/lang/Exception
        //   344	353	1877	java/lang/Exception
        //   733	796	1971	java/lang/Exception
        //   1016	1076	1991	java/lang/Exception
        //   1128	1172	2011	java/lang/Exception
        //   1177	1187	2011	java/lang/Exception
        //   1263	1283	2070	java/lang/Exception
        //   353	363	2075	java/lang/Exception
      }
    };
    Object localObject4 = eCT().eyJ();
    eCT();
    Object localObject1 = n.aDs((String)localObject4);
    boolean bool = ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).isMpUrl((String)localObject4);
    this.mdB.Jfj = new n.c()
    {
      public final void onCreateMMMenu(l paramAnonymousl)
      {
        AppMethodBeat.i(79873);
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(480L, 0L, 1L, false);
        paramAnonymousl.clear();
        if (i.this.CxC.booleanValue())
        {
          AppMethodBeat.o(79873);
          return;
        }
        if ((i.this.eCT().CAr != null) && (i.this.eCT().CAr.CBb.eAu()))
        {
          if ((!i.c(i.this, 35)) || (!i.this.VF(35)) || (i.this.eCT().CAr.bGo())) {
            break label279;
          }
          paramAnonymousl.a(35, i.this.eCT().getString(2131762178), 2131690574);
        }
        for (;;)
        {
          switch (i.this.eCT().CAy)
          {
          }
          try
          {
            label168:
            LinkedList localLinkedList = i.this.eCT().eEh();
            int i;
            label279:
            if (localLinkedList != null)
            {
              i = 0;
              label187:
              if ((i < localLinkedList.size()) && (i < 8))
              {
                d.a locala = (d.a)localLinkedList.get(i);
                m localm = null;
                if ("index".equals(bs.nullAsNil(locala.id))) {
                  localm = (m)paramAnonymousl.a(15, i.this.eCT().getString(2131766098), 2131689814);
                }
                for (;;)
                {
                  if (localm != null) {
                    localm.kbL = locala.url;
                  }
                  i += 1;
                  break label187;
                  if ((!i.this.VF(36)) || (!i.this.eCT().CAr.bGo())) {
                    break;
                  }
                  paramAnonymousl.a(36, i.this.eCT().getString(2131762168), 2131690573);
                  break;
                  paramAnonymousl.a(40, i.this.eCT().getString(2131766150), 2131690335);
                  break label168;
                  paramAnonymousl.a(41, i.this.eCT().getString(2131766148), 2131690334);
                  break label168;
                  paramAnonymousl.a(42, i.this.eCT().getString(2131766149), 2131690335);
                  break label168;
                  if ("categories".equals(bs.nullAsNil(locala.id))) {
                    localm = (m)paramAnonymousl.a(16, i.this.eCT().getString(2131766097), 2131689813);
                  } else if ("cart".equals(bs.nullAsNil(locala.id))) {
                    localm = (m)paramAnonymousl.a(17, i.this.eCT().getString(2131766096), 2131689812);
                  } else if ("profile".equals(bs.nullAsNil(locala.id))) {
                    localm = (m)paramAnonymousl.a(18, i.this.eCT().getString(2131766100), 2131689820);
                  } else if ("member".equals(bs.nullAsNil(locala.id))) {
                    localm = (m)paramAnonymousl.a(19, i.this.eCT().getString(2131766099), 2131689815);
                  }
                }
              }
            }
            try
            {
              bool1 = i.this.eCT().Cfr.kYt.wH((String)localObject);
              if (bool1) {}
            }
            catch (Exception localException4)
            {
              for (;;)
              {
                boolean bool1;
                try
                {
                  Object localObject;
                  i.this.eCT().Cfr.kYt.aCV((String)localObject);
                  if (i.this.VF(10)) {
                    paramAnonymousl.a(10, i.this.eCT().getString(2131756596), 2131690646);
                  }
                  if ((i.c(i.this, 6)) && (i.a(this.CxG, 44)) && (i.this.VF(6))) {
                    paramAnonymousl.a(6, i.this.eCT().getString(2131766247), 2131690588, i.b(this.CxG, 44));
                  }
                  if ((i.c(i.this, 28)) && (i.this.VF(28))) {
                    paramAnonymousl.a(28, i.this.eCT().getString(2131766077), 2131690644);
                  }
                  if (i.c(i.this, 31)) {
                    paramAnonymousl.a(31, i.this.eCT().getString(2131766282), 2131689494);
                  }
                  if ((this.CxG.DIA != null) && (i.this.eCT().Czs) && (!bs.isNullOrNil(i.this.eCT().eDS())) && (!bs.isNullOrNil(i.this.eCT().CAN)) && (i.this.eCT().eDS().startsWith(i.this.eCT().CAN)) && (i.this.eCT().getIntent().getBooleanExtra("key_detail_can_delete", true)) && (i.this.eDs()))
                  {
                    if ((i.c(i.this, 12)) && (i.this.VF(12))) {
                      paramAnonymousl.a(12, i.this.eCT().getString(2131758846), 2131689794);
                    }
                    if (i.c(i.this, 9)) {
                      paramAnonymousl.a(9, i.this.eCT().getString(2131755707), 2131689802);
                    }
                  }
                  if (i.c(i.this, 37))
                  {
                    i.this.eCT();
                    if ((com.tencent.mm.plugin.webview.c.a(i.this.eCT().nKq)) && (i.this.VF(37))) {
                      paramAnonymousl.a(37, i.this.eCT().getString(2131766125), 2131690669);
                    }
                  }
                  if ((i.c(i.this, 11)) && (i.a(this.CxG, 18)) && (i.this.VF(11))) {
                    paramAnonymousl.a(11, i.this.eCT().getString(2131762162), 2131690578, i.b(this.CxG, 18));
                  }
                  if ((com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.h.DEBUG) || (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pZB, 0) == 1))
                  {
                    localObject = i.this.eCT();
                    if (!j.eAd()) {
                      break label1564;
                    }
                    i = 2131766119;
                    paramAnonymousl.a(99, ((WebViewUI)localObject).getString(i), 2131691441, false);
                  }
                  i.this.nPt = true;
                  i.this.mdB.fvu();
                  AppMethodBeat.o(79873);
                  return;
                  localException4 = localException4;
                  ac.e("MicroMsg.WebViewMenuHelper", "sharebtn click fail isBizContact, ex = " + localException4.getMessage());
                  bool1 = false;
                }
                catch (Exception localException2)
                {
                  ac.e("MicroMsg.WebViewMenuHelper", "sharebtn click fail triggerGetContact, ex = " + localException2.getMessage());
                  continue;
                }
                boolean bool2;
                try
                {
                  bool1 = i.this.eCT().Cfr.kYt.wG(localException2);
                  if (bool1)
                  {
                    bool1 = i.a(this.CxG, 19);
                    bool2 = i.b(this.CxG, 19);
                    boolean bool3 = i.this.eCT().eyQ();
                    if ((!i.c(i.this, 5)) || (!bool1) || (!i.this.VF(5))) {
                      continue;
                    }
                    if (!bool3) {
                      break label1520;
                    }
                    paramAnonymousl.a(5, i.this.eCT().getString(2131766259), 2131690612, bool2);
                  }
                }
                catch (Exception localException3)
                {
                  for (;;)
                  {
                    ac.e("MicroMsg.WebViewMenuHelper", "sharebtn click fail, ex = " + localException3.getMessage());
                    bool1 = false;
                    continue;
                    bool1 = i.a(this.CxG, 20);
                    bool2 = i.b(this.CxG, 20);
                  }
                }
                if ((this.CxI == null) || (!this.CxI.CsU))
                {
                  paramAnonymousl.a(5, i.this.eCT().getString(2131766258), 2131690612, bool2);
                  continue;
                  i = 2131766120;
                }
              }
            }
          }
          catch (Exception localException1)
          {
            ac.e("MicroMsg.WebViewMenuHelper", "exception in add jd menu, " + localException1.getMessage());
            localObject = i.this.eCT().getIntent().getStringExtra("srcUsername");
            if (bs.isNullOrNil((String)localObject)) {}
          }
        }
      }
    };
    this.mdB.Jfl = ((n.d)localObject2);
    Object localObject2 = eCT().Cfr.getCurrentUrl();
    if (!bs.isNullOrNil((String)localObject2))
    {
      localObject3 = Uri.parse((String)localObject2).getHost();
      localObject4 = eCT().getString(2131766116, new Object[] { localObject3 });
      if (bs.isNullOrNil(this.Cxw)) {
        if ((bool) && (localObject1 != null) && (((n.a)localObject1).isDataValid()))
        {
          localObject2 = LayoutInflater.from(eCT()).inflate(2131494913, null);
          localObject3 = (ImageView)((View)localObject2).findViewById(2131301214);
          Object localObject5 = (TextView)((View)localObject2).findViewById(2131306141);
          localObject4 = ((View)localObject2).findViewById(2131298761);
          ((TextView)localObject5).setText(((n.a)localObject1).CBi);
          localObject5 = new c.a();
          ((c.a)localObject5).hKw = true;
          ((c.a)localObject5).gLt = true;
          ((c.a)localObject5).hKI = 2131231875;
          com.tencent.mm.av.a.a.aFG().a(((n.a)localObject1).CBj, (ImageView)localObject3, ((c.a)localObject5).aFT());
          ((View)localObject4).setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(175795);
              i.this.fs("Contact_Scene", 173);
              i.this.eCT().Cfc.eBM().B(new Object[] { i.this.eCT().bLL(), Integer.valueOf(38), Integer.valueOf(1) }).report();
              i.this.eCT().aDq(this.CxI.hyx);
              if (i.this.mdB != null) {
                i.this.mdB.bmi();
              }
              AppMethodBeat.o(175795);
            }
          });
          o.gD((View)localObject4);
          this.mdB.J((View)localObject2, true);
          if (!eCT().Czc) {
            break label778;
          }
          this.mdB.lcG = true;
          this.mdB.lcH = true;
          label512:
          if ((eCT().Czg == null) || (!eCT().Czg.isShown())) {
            break label797;
          }
          eCT().Czg.hide();
          this.mdB.cED();
        }
      }
    }
    for (;;)
    {
      if (eCT().Cjc != null) {
        eCT().Cjc.aCo("");
      }
      AppMethodBeat.o(79887);
      return;
      if (bs.isNullOrNil((String)localObject3)) {
        break;
      }
      this.mdB.p((CharSequence)localObject4, 1);
      break;
      localObject3 = LayoutInflater.from(eCT()).inflate(2131494914, null);
      localObject1 = (MMNeat7extView)((View)localObject3).findViewById(2131299007);
      this.mdB.J((View)localObject3, false);
      localObject3 = k.g(((MMNeat7extView)localObject1).getContext(), bs.nullAsNil(this.Cxw), (int)((MMNeat7extView)localObject1).getTextSize());
      ((MMNeat7extView)localObject1).ar((CharSequence)localObject3);
      localObject3 = (ClickableSpan[])((SpannableString)localObject3).getSpans(0, ((SpannableString)localObject3).length(), ClickableSpan.class);
      if ((localObject3 == null) || (localObject3.length <= 0)) {
        break;
      }
      ac.i("MicroMsg.WebViewMenuHelper", "terry h5 apply show");
      com.tencent.mm.plugin.report.service.h.wUl.f(16337, new Object[] { localObject2, Integer.valueOf(1), Integer.valueOf(0) });
      ((MMNeat7extView)localObject1).setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.g((NeatTextView)localObject1, new com.tencent.mm.pluginsdk.ui.span.n(((MMNeat7extView)localObject1).getContext()))
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(175796);
          boolean bool = super.onTouch(paramAnonymousView, paramAnonymousMotionEvent);
          if (bool)
          {
            ac.i("MMNeatTouchListener", "terry h5 apply click");
            com.tencent.mm.plugin.report.service.h.wUl.f(16337, new Object[] { this.val$url, Integer.valueOf(1), Integer.valueOf(1) });
          }
          AppMethodBeat.o(175796);
          return bool;
        }
      });
      break;
      this.mdB.p(" ", 1);
      break;
      label778:
      this.mdB.lcG = false;
      this.mdB.lcH = false;
      break label512;
      label797:
      eCT().hideVKB();
      this.mdB.cED();
    }
  }
  
  public final void bMt()
  {
    AppMethodBeat.i(79900);
    if ((eCT() == null) || (eCT().nKq == null) || (eCT().kYu == null))
    {
      ac.e("MicroMsg.WebViewMenuHelper", "setShareFuncFlag params failed");
      AppMethodBeat.o(79900);
      return;
    }
    String str = eCT().nKq.getUrl();
    if (!bs.isNullOrNil(str))
    {
      try
      {
        boolean bool = new URL(str).getHost().equals("mp.weixin.qq.com");
        if (bool) {
          break label135;
        }
        AppMethodBeat.o(79900);
        return;
      }
      catch (Exception localException)
      {
        ac.e("MicroMsg.WebViewMenuHelper", "create url fail : " + localException.getLocalizedMessage());
        AppMethodBeat.o(79900);
        return;
      }
    }
    else
    {
      AppMethodBeat.o(79900);
      return;
    }
    label135:
    int i = eDv();
    if (eCT().Cjc != null) {
      eCT().Cjc.fd("setFuncFlag", i);
    }
    AppMethodBeat.o(79900);
  }
  
  public final void eDm()
  {
    AppMethodBeat.i(79879);
    this.Cxt.clear();
    this.Cxt.put("menuItem:share:brand", Integer.valueOf(0));
    this.Cxt.put("menuItem:share:appMessage", Integer.valueOf(1));
    this.Cxt.put("menuItem:share:dataMessage", Integer.valueOf(23));
    this.Cxt.put("menuItem:share:timeline", Integer.valueOf(2));
    this.Cxt.put("menuItem:favorite", Integer.valueOf(3));
    this.Cxt.put("menuItem:profile", Integer.valueOf(5));
    this.Cxt.put("menuItem:addContact", Integer.valueOf(5));
    this.Cxt.put("menuItem:copyUrl", Integer.valueOf(6));
    this.Cxt.put("menuItem:openWithSafari", Integer.valueOf(7));
    this.Cxt.put("menuItem:share:email", Integer.valueOf(8));
    this.Cxt.put("menuItem:delete", Integer.valueOf(9));
    this.Cxt.put("menuItem:exposeArticle", Integer.valueOf(10));
    this.Cxt.put("menuItem:setFont", Integer.valueOf(11));
    this.Cxt.put("menuItem:editTag", Integer.valueOf(12));
    this.Cxt.put("menuItem:share:qq", Integer.valueOf(20));
    this.Cxt.put("menuItem:share:weiboApp", Integer.valueOf(21));
    this.Cxt.put("menuItem:share:QZone", Integer.valueOf(22));
    this.Cxt.put("menuItem:share:Facebook", Integer.valueOf(33));
    this.Cxt.put("menuItem:share:enterprise", Integer.valueOf(24));
    this.Cxt.put("menuItem:refresh", Integer.valueOf(28));
    this.Cxt.put("menuItem:share:wework", Integer.valueOf(25));
    this.Cxt.put("menuItem:share:weread", Integer.valueOf(26));
    this.Cxt.put("menuItem:addShortcut", Integer.valueOf(29));
    this.Cxt.put("menuItem:search", Integer.valueOf(31));
    this.Cxt.put("menuItem:readArticle", Integer.valueOf(34));
    this.Cxt.put("menuItem:minimize", Integer.valueOf(35));
    this.Cxt.put("menuItem:cancelMinimize", Integer.valueOf(36));
    this.Cxt.put("menuItem:translate", Integer.valueOf(37));
    this.Cxt.put("menuItem:haoKan", Integer.valueOf(38));
    this.Cxt.put("menuItem:cancelHaoKan", Integer.valueOf(39));
    this.Cxt.put("menuItem:ttsStart", Integer.valueOf(40));
    this.Cxt.put("menuItem:ttsPause", Integer.valueOf(41));
    this.Cxt.put("menuItem:ttsResume", Integer.valueOf(42));
    AppMethodBeat.o(79879);
  }
  
  protected final void eDn()
  {
    AppMethodBeat.i(79884);
    if (!this.Cxz)
    {
      AppMethodBeat.o(79884);
      return;
    }
    this.Cxy = false;
    eCT().CAJ = false;
    this.Cxz = false;
    if (this.nPt) {
      bMr();
    }
    AppMethodBeat.o(79884);
  }
  
  public final void eDo()
  {
    AppMethodBeat.i(79886);
    this.Cxy = true;
    this.CxA.clear();
    if ((eCT() instanceof GameWebViewUI))
    {
      this.CxA.add(Integer.valueOf(11));
      this.CxA.add(Integer.valueOf(28));
      AppMethodBeat.o(79886);
      return;
    }
    this.CxA.add(Integer.valueOf(7));
    this.CxA.add(Integer.valueOf(11));
    this.CxA.add(Integer.valueOf(28));
    AppMethodBeat.o(79886);
  }
  
  protected final void eDq()
  {
    AppMethodBeat.i(79892);
    if (eCT().Cjc != null) {
      eCT().Cjc.aCo("fav");
    }
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putLong("msg_id", eCT().getIntent().getLongExtra("msg_id", -9223372036854775808L));
    ((Bundle)localObject1).putString("sns_local_id", eCT().getIntent().getStringExtra("sns_local_id"));
    ((Bundle)localObject1).putInt("news_svr_id", eCT().getIntent().getIntExtra("news_svr_id", 0));
    ((Bundle)localObject1).putString("news_svr_tweetid", eCT().getIntent().getStringExtra("news_svr_tweetid"));
    ((Bundle)localObject1).putInt("message_index", eCT().getIntent().getIntExtra("message_index", 0));
    ((Bundle)localObject1).putString("rawUrl", eCT().bLL());
    Object localObject2;
    if ((!bs.isNullOrNil(eCT().bLL())) && (eCT().bLL().endsWith("#rd")))
    {
      localObject2 = eCT().bLL().substring(0, eCT().bLL().length() - 3);
      if ((!bs.isNullOrNil(eCT().eDS())) && (!eCT().eDS().startsWith((String)localObject2)))
      {
        ((Bundle)localObject1).putString("rawUrl", eCT().eDS());
        ((Bundle)localObject1).putLong("msg_id", -9223372036854775808L);
      }
      localObject2 = eCT().getIntent();
      if (localObject2 != null)
      {
        ((Bundle)localObject1).putString("preChatName", ((Intent)localObject2).getStringExtra("preChatName"));
        ((Bundle)localObject1).putInt("preMsgIndex", ((Intent)localObject2).getIntExtra("preMsgIndex", 0));
        ((Bundle)localObject1).putString("prePublishId", ((Intent)localObject2).getStringExtra("prePublishId"));
        ((Bundle)localObject1).putString("preUsername", ((Intent)localObject2).getStringExtra("preUsername"));
      }
    }
    for (;;)
    {
      boolean bool;
      try
      {
        for (;;)
        {
          localObject1 = eCT().Cfr.kYt.aG((Bundle)localObject1);
          if (!((com.tencent.mm.plugin.webview.stub.c)localObject1).eCB()) {
            break label786;
          }
          eCT().Cjc.cf("sendAppMessage", false);
          localObject1 = eCT().Cjc;
          localObject2 = eDr();
          ac.i("MicroMsg.JsApiHandler", "onFavorite %b", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.webview.c.f)localObject1).Apr) });
          bool = ((com.tencent.mm.plugin.webview.c.f)localObject1).Apr;
          if (!bool) {
            try
            {
              ((com.tencent.mm.plugin.webview.c.f)localObject1).kYt.ac("scene", "favorite", ((com.tencent.mm.plugin.webview.c.f)localObject1).CjB);
              ((com.tencent.mm.plugin.webview.c.f)localObject1).i(((com.tencent.mm.plugin.webview.c.f)localObject1).bu((Map)localObject2), "sendAppMessage");
              ac.i("MicroMsg.WebViewMenuHelper", "on favorite simple url");
              AppMethodBeat.o(79892);
              return;
              if ((bs.isNullOrNil(eCT().eDS())) || (eCT().eDS().startsWith(eCT().bLL()))) {
                break;
              }
              ((Bundle)localObject1).putString("rawUrl", eCT().eDS());
              ((Bundle)localObject1).putLong("msg_id", -9223372036854775808L);
            }
            catch (Exception localException1)
            {
              for (;;)
              {
                ac.w("MicroMsg.JsApiHandler", "jsapiBundlePutString, ex = " + localException1.getMessage());
              }
            }
          }
        }
        localObject2 = localException2.UN(1);
      }
      catch (Exception localException2)
      {
        ac.e("MicroMsg.WebViewMenuHelper", "edw, favoriteUrl fail, ex = " + localException2.getMessage());
        AppMethodBeat.o(79892);
        return;
      }
      if (localObject2 != null)
      {
        bool = ((Bundle)localObject2).getBoolean("WebViewShare_reslut", false);
        if (bool) {
          try
          {
            localException2.kYt.ac("scene", "favorite", localException2.CjB);
            localException2.i((Bundle)localObject2, "sendAppMessage");
          }
          catch (Exception localException4)
          {
            for (;;)
            {
              ac.w("MicroMsg.JsApiHandler", "jsapiBundlePutString, ex = " + localException4.getMessage());
            }
          }
        }
      }
      localObject2 = new HashMap();
      ((HashMap)localObject2).put("scene", "favorite");
      localObject2 = l.a.b("menu:share:appmessage", (Map)localObject2, localException2.Cjz, localException2.CjA);
      localException2.Cjr.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + (String)localObject2 + ")", null);
      try
      {
        localException2.kYt.ac("scene", "favorite", localException2.CjB);
      }
      catch (Exception localException3)
      {
        ac.w("MicroMsg.JsApiHandler", "jsapiBundlePutString, ex = " + localException3.getMessage());
      }
    }
    label786:
    com.tencent.mm.plugin.fav.ui.e.a(localException3.getRet(), eCT(), eCT().sXH);
    if (localException3.getRet() == 0)
    {
      VG(1);
      AppMethodBeat.o(79892);
      return;
    }
    VG(2);
    AppMethodBeat.o(79892);
  }
  
  public final HashMap<String, String> eDr()
  {
    AppMethodBeat.i(79893);
    if (!eCT().CAJ)
    {
      AppMethodBeat.o(79893);
      return null;
    }
    Intent localIntent = eCT().getIntent();
    String str1 = localIntent.getStringExtra("share_report_pre_msg_url");
    String str2 = localIntent.getStringExtra("share_report_pre_msg_title");
    String str3 = localIntent.getStringExtra("share_report_pre_msg_icon_url");
    HashMap localHashMap = new HashMap();
    localHashMap.put("share_report_pre_msg_url", str1);
    localHashMap.put("share_report_pre_msg_title", str2);
    localHashMap.put("share_report_pre_msg_desc", localIntent.getStringExtra("share_report_pre_msg_desc"));
    localHashMap.put("share_report_pre_msg_icon_url", str3);
    AppMethodBeat.o(79893);
    return localHashMap;
  }
  
  final boolean eDs()
  {
    AppMethodBeat.i(79896);
    try
    {
      boolean bool = eCT().Cfr.kYt.aCT("favorite");
      AppMethodBeat.o(79896);
      return bool;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.WebViewMenuHelper", localException, "", new Object[0]);
      AppMethodBeat.o(79896);
    }
    return false;
  }
  
  public final Bundle eDt()
  {
    AppMethodBeat.i(79898);
    Bundle localBundle = new Bundle();
    localBundle.putInt("funcFlag", eDv());
    AppMethodBeat.o(79898);
    return localBundle;
  }
  
  public final void eDu()
  {
    AppMethodBeat.i(79899);
    if ((eCT() == null) || (eCT().kYu == null))
    {
      ac.e("MicroMsg.WebViewMenuHelper", "showShareMenu params failed");
      AppMethodBeat.o(79899);
      return;
    }
    final JsapiPermissionWrapper localJsapiPermissionWrapper = eCT().kYu.eCm();
    if ((!a(localJsapiPermissionWrapper, 21, 1)) && (!a(localJsapiPermissionWrapper, 23, 2)))
    {
      com.tencent.mm.ui.base.h.cg(eCT(), eCT().getString(2131766260));
      AppMethodBeat.o(79899);
      return;
    }
    com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(eCT(), 1, false);
    locale.ISu = new n.c()
    {
      public final void onCreateMMMenu(l paramAnonymousl)
      {
        AppMethodBeat.i(210031);
        if (i.this.a(localJsapiPermissionWrapper, 23, 2)) {
          paramAnonymousl.a(2, i.this.eCT().getString(2131762164), 2131689817, false);
        }
        if (i.this.a(localJsapiPermissionWrapper, 21, 1)) {
          paramAnonymousl.a(1, i.this.eCT().getString(2131762163), 2131689831, false);
        }
        AppMethodBeat.o(210031);
      }
    };
    locale.ISv = new n.d()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        paramAnonymousInt = 0;
        AppMethodBeat.i(210032);
        switch (paramAnonymousMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(210032);
          return;
          paramAnonymousMenuItem = i.this.eCT().getIntent().getStringExtra("KPublisherId");
          String str1 = i.this.eCT().getIntent().getStringExtra("KAppId");
          String str2 = i.this.eCT().getIntent().getStringExtra("srcUsername");
          i.this.eCT().Cfc.eBM().B(new Object[] { i.this.eCT().bLL(), Integer.valueOf(1), Integer.valueOf(1), paramAnonymousMenuItem, str1, str2 }).report();
          i.this.eCT().dFh();
          AppMethodBeat.o(210032);
          return;
          paramAnonymousMenuItem = i.this.eCT().getIntent().getStringExtra("KPublisherId");
          str1 = i.this.eCT().getIntent().getStringExtra("KAppId");
          str2 = i.this.eCT().getIntent().getStringExtra("srcUsername");
          i.this.eCT().Cfc.eBM().B(new Object[] { i.this.eCT().bLL(), Integer.valueOf(2), Integer.valueOf(1), paramAnonymousMenuItem, str1, str2 }).report();
          if (i.this.Cxx.containsKey(i.this.eCT().nKq.getUrl())) {
            paramAnonymousInt = ((Integer)i.this.Cxx.get(i.this.eCT().nKq.getUrl())).intValue();
          }
          i.a(i.this, paramAnonymousInt);
        }
      }
    };
    locale.p(" ", 1);
    locale.cED();
    AppMethodBeat.o(79899);
  }
  
  public final void f(String paramString, Intent paramIntent)
  {
    AppMethodBeat.i(188374);
    SparseBooleanArray localSparseBooleanArray2 = (SparseBooleanArray)this.Cxs.get(paramString);
    SparseBooleanArray localSparseBooleanArray1 = localSparseBooleanArray2;
    if (localSparseBooleanArray2 == null)
    {
      localSparseBooleanArray1 = new SparseBooleanArray();
      this.Cxs.put(paramString, localSparseBooleanArray1);
    }
    if (localSparseBooleanArray1 != null)
    {
      localSparseBooleanArray1.put(34, true);
      localSparseBooleanArray1.put(10, paramIntent.getBooleanExtra("key_menu_hide_expose", false));
    }
    AppMethodBeat.o(188374);
  }
  
  public final void fs(String paramString, int paramInt)
  {
    AppMethodBeat.i(79895);
    if (eCT().Cjc != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt(paramString, paramInt);
      paramString = eCT().Cjc;
      try
      {
        paramString.kYt.a(21, localBundle, paramString.CjB);
        AppMethodBeat.o(79895);
        return;
      }
      catch (Exception paramString)
      {
        ac.printErrStackTrace("MicroMsg.JsApiHandler", paramString, "", new Object[0]);
        ac.w("MicroMsg.JsApiHandler", "updateJsapiArgsBundleKV, ex = ".concat(String.valueOf(paramString)));
      }
    }
    AppMethodBeat.o(79895);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(79878);
    Iterator localIterator = this.Cxs.values().iterator();
    while (localIterator.hasNext())
    {
      SparseBooleanArray localSparseBooleanArray = (SparseBooleanArray)localIterator.next();
      if (localSparseBooleanArray != null) {
        localSparseBooleanArray.clear();
      }
    }
    this.Cxs.clear();
    this.Cxx.clear();
    if ((this.mdB != null) && (this.mdB.isShowing())) {
      this.mdB.bmi();
    }
    AppMethodBeat.o(79878);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.i
 * JD-Core Version:    0.7.0.1
 */