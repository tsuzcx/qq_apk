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
import com.tencent.mm.aw.a.a.c.a;
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
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bt;
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
  protected Map<String, SparseBooleanArray> Bfg;
  protected Map<String, Integer> Bfh;
  ag<String, Bitmap> Bfi;
  HashMap<String, String> Bfj;
  public String Bfk;
  HashMap<String, Integer> Bfl;
  public boolean Bfm;
  public boolean Bfn;
  Set<Integer> Bfo;
  ArrayList<d.b> Bfp;
  Boolean Bfq;
  private int height;
  private String kpE;
  com.tencent.mm.ui.widget.a.e lBF;
  public boolean nmt;
  private int width;
  
  public i(WebViewUI paramWebViewUI)
  {
    super(paramWebViewUI);
    AppMethodBeat.i(79877);
    this.Bfg = new HashMap();
    this.Bfh = new HashMap();
    this.Bfi = new ag(12);
    this.Bfj = new HashMap();
    this.kpE = "";
    this.Bfl = new HashMap();
    this.Bfm = true;
    this.Bfn = false;
    this.nmt = false;
    this.Bfo = new HashSet();
    this.width = paramWebViewUI.getResources().getDisplayMetrics().widthPixels;
    this.height = paramWebViewUI.getResources().getDisplayMetrics().heightPixels;
    AppMethodBeat.o(79877);
  }
  
  private void Ty(int paramInt)
  {
    AppMethodBeat.i(79891);
    String str2 = enA().avx(enA().eox());
    if ((TextUtils.isEmpty(enA().eox())) || (TextUtils.isEmpty(str2)))
    {
      ad.i("MicroMsg.WebViewMenuHelper", "stev appId is null or empty");
      AppMethodBeat.o(79891);
      return;
    }
    ad.i("MicroMsg.WebViewMenuHelper", "stev appId %s", new Object[] { str2 });
    long l = bt.aGK();
    ad.d("MicroMsg.WebViewMenuHelper", "stev report(%s), clickTimestamp : %d, appID : %s, url : %s, sessionId : %s, actionType : %d, flag : %d", new Object[] { Integer.valueOf(13377), Long.valueOf(l), str2, enA().eox(), enA().sessionId, Integer.valueOf(3), Integer.valueOf(paramInt) });
    Object localObject = "";
    try
    {
      str1 = p.encode(enA().eox(), "UTF-8");
      localObject = str1;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        String str1;
        int i;
        ad.printErrStackTrace("MicroMsg.WebViewMenuHelper", localUnsupportedEncodingException, "", new Object[0]);
      }
    }
    i = enA().avB(enA().getIntent().getStringExtra("geta8key_username"));
    str1 = "";
    if ((i == 7) || (i == 56)) {
      str1 = enA().getIntent().getStringExtra("geta8key_username");
    }
    com.tencent.mm.plugin.report.service.h.vKh.f(13377, new Object[] { Long.valueOf(l), str2, localObject, enA().sessionId, Integer.valueOf(3), Integer.valueOf(paramInt), Integer.valueOf(0), str1 });
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
    paramInt = paramJsapiPermissionWrapper.Vw(paramInt);
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
    if (paramJsapiPermissionWrapper.Vw(paramInt) == 10)
    {
      AppMethodBeat.o(79883);
      return true;
    }
    AppMethodBeat.o(79883);
    return false;
  }
  
  private ArrayList<d.b> enW()
  {
    AppMethodBeat.i(79888);
    Object localObject = enA().nhy.getUrl();
    if (enA().Bhy.containsKey(localObject))
    {
      localObject = (ArrayList)enA().Bhy.get(localObject);
      AppMethodBeat.o(79888);
      return localObject;
    }
    AppMethodBeat.o(79888);
    return null;
  }
  
  private int eob()
  {
    AppMethodBeat.i(79901);
    if ((enA() == null) || (enA().kxg == null))
    {
      ad.e("MicroMsg.WebViewMenuHelper", "getShareFuncFlag params failed");
      AppMethodBeat.o(79901);
      return -1;
    }
    JsapiPermissionWrapper localJsapiPermissionWrapper = enA().kxg.emR();
    if (a(localJsapiPermissionWrapper, 21, 1)) {}
    for (int i = 1;; i = 0)
    {
      int j = i;
      if (a(localJsapiPermissionWrapper, 23, 2)) {
        j = i | 0x2;
      }
      ad.i("MicroMsg.WebViewMenuHelper", "getShareFuncFlag %d", new Object[] { Integer.valueOf(j) });
      AppMethodBeat.o(79901);
      return j;
    }
  }
  
  private void gy(List<String> paramList)
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
      if (this.Bfi.get(str2) != null) {
        ad.i("MicroMsg.WebViewMenuHelper", "find %s icon from cache ok", new Object[] { str2 });
      }
      for (;;)
      {
        if (!this.Bfj.containsKey(str2)) {
          break label216;
        }
        ad.i("MicroMsg.WebViewMenuHelper", "find %s nick from cache ok", new Object[] { str2 });
        break;
        ad.w("MicroMsg.WebViewMenuHelper", "not found %s icon from cache, try to load", new Object[] { str2 });
        try
        {
          paramList = enA().AMZ.kxf.axx(str2);
          if (!bt.isNullOrNil(paramList))
          {
            paramList = e.axM(paramList);
            if (paramList != null)
            {
              ad.i("MicroMsg.WebViewMenuHelper", "load ok, and cache it");
              this.Bfi.put(str2, paramList);
            }
          }
        }
        catch (Exception paramList)
        {
          ad.w("MicroMsg.WebViewMenuHelper", "getheadimg, ex = " + paramList.getMessage());
        }
      }
      label216:
      ad.w("MicroMsg.WebViewMenuHelper", "not found %s nick from cache, try to load", new Object[] { str2 });
      paramList = null;
      try
      {
        String str1 = enA().AMZ.kxf.sh(str2);
        paramList = str1;
        ad.i("MicroMsg.WebViewMenuHelper", "load nick ok");
        paramList = str1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.w("MicroMsg.WebViewMenuHelper", "onAttach, ex = " + localException.getMessage());
        }
      }
      this.Bfj.put(str2, paramList);
    }
    label308:
    AppMethodBeat.o(79894);
  }
  
  protected final boolean Tx(int paramInt)
  {
    AppMethodBeat.i(79881);
    SparseBooleanArray localSparseBooleanArray = (SparseBooleanArray)this.Bfg.get(enA().nhy.getUrl());
    if ((localSparseBooleanArray != null) && (localSparseBooleanArray.get(paramInt, false)))
    {
      AppMethodBeat.o(79881);
      return false;
    }
    AppMethodBeat.o(79881);
    return true;
  }
  
  public final void VV()
  {
    AppMethodBeat.i(79885);
    if (this.nmt) {
      bFd();
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
    if ((paramJsapiPermissionWrapper.Vw(paramInt1) == 1) && (Tx(paramInt2)))
    {
      AppMethodBeat.o(79902);
      return true;
    }
    AppMethodBeat.o(79902);
    return false;
  }
  
  public final void axT(String paramString)
  {
    AppMethodBeat.i(79880);
    SparseBooleanArray localSparseBooleanArray2 = (SparseBooleanArray)this.Bfg.get(paramString);
    SparseBooleanArray localSparseBooleanArray1 = localSparseBooleanArray2;
    if (localSparseBooleanArray2 == null)
    {
      localSparseBooleanArray1 = new SparseBooleanArray();
      this.Bfg.put(paramString, localSparseBooleanArray1);
    }
    if (localSparseBooleanArray1 != null) {
      localSparseBooleanArray1.put(34, true);
    }
    AppMethodBeat.o(79880);
  }
  
  final void axU(String paramString)
  {
    AppMethodBeat.i(79889);
    enA().AQP.bZ("sendAppMessage", false);
    com.tencent.mm.plugin.webview.c.f localf = enA().AQP;
    if (!localf.yZR)
    {
      ad.e("MicroMsg.JsApiHandler", "onSendToEnterprise fail, not ready");
      AppMethodBeat.o(79889);
      return;
    }
    Object localObject = new HashMap();
    ((HashMap)localObject).put("scene", "enterprise");
    localObject = l.a.b("menu:share:appmessage", (Map)localObject, localf.ARm, localf.ARn);
    localf.ARe.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + (String)localObject + ")", null);
    try
    {
      localf.kxf.ab("connector_local_send", paramString, localf.ARo);
      localf.kxf.ab("scene", "enterprise", localf.ARo);
      AppMethodBeat.o(79889);
      return;
    }
    catch (Exception paramString)
    {
      ad.w("MicroMsg.JsApiHandler", "jsapiBundlePutString, ex = " + paramString.getMessage());
      AppMethodBeat.o(79889);
    }
  }
  
  /* Error */
  protected final void axV(String paramString)
  {
    // Byte code:
    //   0: ldc_w 845
    //   3: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokevirtual 224	com/tencent/mm/plugin/webview/ui/tools/a:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   10: invokevirtual 228	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   13: ldc 230
    //   15: invokevirtual 235	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   18: astore 8
    //   20: aload_0
    //   21: invokevirtual 160	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   24: invokevirtual 475	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:ejo	()Ljava/lang/String;
    //   27: astore 9
    //   29: aconst_null
    //   30: astore 5
    //   32: aload 9
    //   34: invokestatic 444	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   37: ifne +13 -> 50
    //   40: aload 9
    //   42: invokestatic 601	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   45: invokevirtual 848	android/net/Uri:getHost	()Ljava/lang/String;
    //   48: astore 5
    //   50: aload 5
    //   52: invokestatic 444	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   55: ifne +514 -> 569
    //   58: aload 5
    //   60: ldc_w 850
    //   63: invokevirtual 853	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   66: ifeq +503 -> 569
    //   69: ldc_w 855
    //   72: iconst_1
    //   73: anewarray 187	java/lang/Object
    //   76: dup
    //   77: iconst_0
    //   78: aload 9
    //   80: ldc_w 591
    //   83: invokestatic 223	com/tencent/mm/compatible/util/p:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   86: aastore
    //   87: invokestatic 859	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   90: astore 5
    //   92: aload_0
    //   93: invokevirtual 160	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   96: aload_0
    //   97: invokevirtual 160	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   100: getfield 447	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:nhy	Lcom/tencent/mm/ui/widget/MMWebView;
    //   103: invokevirtual 450	com/tencent/mm/ui/widget/MMWebView:getUrl	()Ljava/lang/String;
    //   106: invokevirtual 168	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:avx	(Ljava/lang/String;)Ljava/lang/String;
    //   109: astore 10
    //   111: aload_0
    //   112: invokevirtual 160	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   115: getfield 734	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:kxg	Lcom/tencent/mm/plugin/webview/e/g;
    //   118: invokevirtual 863	com/tencent/mm/plugin/webview/e/g:emS	()Lcom/tencent/mm/protocal/GeneralControlWrapper;
    //   121: invokevirtual 868	com/tencent/mm/protocal/GeneralControlWrapper:eBQ	()Z
    //   124: istore_2
    //   125: ldc 176
    //   127: ldc_w 870
    //   130: iconst_1
    //   131: anewarray 187	java/lang/Object
    //   134: dup
    //   135: iconst_0
    //   136: iload_2
    //   137: invokestatic 338	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   140: aastore
    //   141: invokestatic 215	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   144: aload 10
    //   146: invokestatic 174	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   149: ifne +179 -> 328
    //   152: iload_2
    //   153: ifeq +175 -> 328
    //   156: aload_0
    //   157: invokevirtual 160	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   160: getfield 447	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:nhy	Lcom/tencent/mm/ui/widget/MMWebView;
    //   163: invokevirtual 450	com/tencent/mm/ui/widget/MMWebView:getUrl	()Ljava/lang/String;
    //   166: invokestatic 174	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   169: ifne +159 -> 328
    //   172: invokestatic 196	com/tencent/mm/sdk/platformtools/bt:aGK	()J
    //   175: lstore_3
    //   176: ldc 176
    //   178: ldc_w 872
    //   181: bipush 7
    //   183: anewarray 187	java/lang/Object
    //   186: dup
    //   187: iconst_0
    //   188: sipush 13377
    //   191: invokestatic 204	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   194: aastore
    //   195: dup
    //   196: iconst_1
    //   197: lload_3
    //   198: invokestatic 209	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   201: aastore
    //   202: dup
    //   203: iconst_2
    //   204: aload 10
    //   206: aastore
    //   207: dup
    //   208: iconst_3
    //   209: aload_0
    //   210: invokevirtual 160	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   213: getfield 447	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:nhy	Lcom/tencent/mm/ui/widget/MMWebView;
    //   216: invokevirtual 450	com/tencent/mm/ui/widget/MMWebView:getUrl	()Ljava/lang/String;
    //   219: aastore
    //   220: dup
    //   221: iconst_4
    //   222: aload_0
    //   223: invokevirtual 160	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   226: getfield 212	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:sessionId	Ljava/lang/String;
    //   229: aastore
    //   230: dup
    //   231: iconst_5
    //   232: iconst_4
    //   233: invokestatic 204	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   236: aastore
    //   237: dup
    //   238: bipush 6
    //   240: iconst_1
    //   241: invokestatic 204	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   244: aastore
    //   245: invokestatic 215	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   248: ldc 109
    //   250: astore 6
    //   252: aload_0
    //   253: invokevirtual 160	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   256: getfield 447	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:nhy	Lcom/tencent/mm/ui/widget/MMWebView;
    //   259: invokevirtual 450	com/tencent/mm/ui/widget/MMWebView:getUrl	()Ljava/lang/String;
    //   262: ldc 217
    //   264: invokestatic 223	com/tencent/mm/compatible/util/p:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   267: astore 7
    //   269: aload 7
    //   271: astore 6
    //   273: getstatic 245	com/tencent/mm/plugin/report/service/h:vKh	Lcom/tencent/mm/plugin/report/service/h;
    //   276: sipush 13377
    //   279: bipush 6
    //   281: anewarray 187	java/lang/Object
    //   284: dup
    //   285: iconst_0
    //   286: lload_3
    //   287: invokestatic 209	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   290: aastore
    //   291: dup
    //   292: iconst_1
    //   293: aload 10
    //   295: aastore
    //   296: dup
    //   297: iconst_2
    //   298: aload 6
    //   300: aastore
    //   301: dup
    //   302: iconst_3
    //   303: aload_0
    //   304: invokevirtual 160	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   307: getfield 212	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:sessionId	Ljava/lang/String;
    //   310: aastore
    //   311: dup
    //   312: iconst_4
    //   313: iconst_4
    //   314: invokestatic 204	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   317: aastore
    //   318: dup
    //   319: iconst_5
    //   320: iconst_1
    //   321: invokestatic 204	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   324: aastore
    //   325: invokevirtual 249	com/tencent/mm/plugin/report/service/h:f	(I[Ljava/lang/Object;)V
    //   328: aload 5
    //   330: astore 6
    //   332: aload 5
    //   334: invokestatic 444	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   337: ifeq +23 -> 360
    //   340: ldc_w 874
    //   343: iconst_1
    //   344: anewarray 187	java/lang/Object
    //   347: dup
    //   348: iconst_0
    //   349: bipush 34
    //   351: invokestatic 204	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   354: aastore
    //   355: invokestatic 859	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   358: astore 6
    //   360: new 232	android/content/Intent
    //   363: dup
    //   364: invokespecial 875	android/content/Intent:<init>	()V
    //   367: astore 5
    //   369: aload_1
    //   370: invokestatic 444	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   373: ifne +23 -> 396
    //   376: aload 5
    //   378: ldc_w 877
    //   381: aload_1
    //   382: ldc 217
    //   384: invokevirtual 881	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   387: bipush 11
    //   389: invokestatic 887	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   392: invokevirtual 891	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   395: pop
    //   396: ldc 176
    //   398: ldc_w 893
    //   401: iconst_2
    //   402: anewarray 187	java/lang/Object
    //   405: dup
    //   406: iconst_0
    //   407: aload 9
    //   409: aastore
    //   410: dup
    //   411: iconst_1
    //   412: aload_0
    //   413: invokevirtual 160	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   416: invokevirtual 587	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bEx	()Ljava/lang/String;
    //   419: aastore
    //   420: invokestatic 190	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   423: aload 5
    //   425: ldc_w 895
    //   428: aload 6
    //   430: invokevirtual 891	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   433: pop
    //   434: aload 5
    //   436: ldc_w 897
    //   439: aload 9
    //   441: invokevirtual 891	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   444: pop
    //   445: aload 5
    //   447: ldc_w 899
    //   450: aload_0
    //   451: invokevirtual 160	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   454: invokevirtual 587	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bEx	()Ljava/lang/String;
    //   457: invokevirtual 891	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   460: pop
    //   461: aload 5
    //   463: ldc_w 901
    //   466: aload_0
    //   467: invokevirtual 160	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   470: aload 8
    //   472: invokevirtual 239	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:avB	(Ljava/lang/String;)I
    //   475: invokevirtual 904	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   478: pop
    //   479: aload 5
    //   481: ldc_w 906
    //   484: iconst_0
    //   485: invokevirtual 909	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   488: pop
    //   489: aload_0
    //   490: invokevirtual 160	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   493: aload_0
    //   494: invokevirtual 160	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   497: ldc_w 910
    //   500: invokevirtual 290	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
    //   503: ldc 109
    //   505: aload_0
    //   506: invokevirtual 160	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   509: ldc_w 911
    //   512: invokevirtual 290	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
    //   515: aload_0
    //   516: invokevirtual 160	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   519: ldc_w 912
    //   522: invokevirtual 290	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
    //   525: iconst_0
    //   526: new 42	com/tencent/mm/plugin/webview/ui/tools/i$7
    //   529: dup
    //   530: aload_0
    //   531: aload 5
    //   533: invokespecial 915	com/tencent/mm/plugin/webview/ui/tools/i$7:<init>	(Lcom/tencent/mm/plugin/webview/ui/tools/i;Landroid/content/Intent;)V
    //   536: new 44	com/tencent/mm/plugin/webview/ui/tools/i$8
    //   539: dup
    //   540: aload_0
    //   541: aload 5
    //   543: invokespecial 916	com/tencent/mm/plugin/webview/ui/tools/i$8:<init>	(Lcom/tencent/mm/plugin/webview/ui/tools/i;Landroid/content/Intent;)V
    //   546: invokestatic 919	com/tencent/mm/ui/base/h:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLandroid/content/DialogInterface$OnClickListener;Landroid/content/DialogInterface$OnClickListener;)Lcom/tencent/mm/ui/widget/a/d;
    //   549: pop
    //   550: ldc_w 845
    //   553: invokestatic 151	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   556: return
    //   557: astore 5
    //   559: ldc 176
    //   561: aload 5
    //   563: invokevirtual 920	java/io/UnsupportedEncodingException:getMessage	()Ljava/lang/String;
    //   566: invokestatic 304	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   569: aconst_null
    //   570: astore 5
    //   572: goto -480 -> 92
    //   575: astore 7
    //   577: ldc 176
    //   579: aload 7
    //   581: ldc 109
    //   583: iconst_0
    //   584: anewarray 187	java/lang/Object
    //   587: invokestatic 253	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   590: goto -317 -> 273
    //   593: astore_1
    //   594: ldc 176
    //   596: new 414	java/lang/StringBuilder
    //   599: dup
    //   600: ldc_w 922
    //   603: invokespecial 418	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   606: aload_1
    //   607: invokevirtual 920	java/io/UnsupportedEncodingException:getMessage	()Ljava/lang/String;
    //   610: invokevirtual 422	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   613: invokevirtual 427	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   616: invokestatic 304	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   619: goto -223 -> 396
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	622	0	this	i
    //   0	622	1	paramString	String
    //   124	29	2	bool	boolean
    //   175	112	3	l	long
    //   30	512	5	localObject1	Object
    //   557	5	5	localUnsupportedEncodingException1	UnsupportedEncodingException
    //   570	1	5	localObject2	Object
    //   250	179	6	localObject3	Object
    //   267	3	7	str1	String
    //   575	5	7	localUnsupportedEncodingException2	UnsupportedEncodingException
    //   18	453	8	str2	String
    //   27	413	9	str3	String
    //   109	185	10	str4	String
    // Exception table:
    //   from	to	target	type
    //   69	92	557	java/io/UnsupportedEncodingException
    //   252	269	575	java/io/UnsupportedEncodingException
    //   376	396	593	java/io/UnsupportedEncodingException
  }
  
  protected final void bAR()
  {
    AppMethodBeat.i(79897);
    String str1 = enA().avx(enA().eox());
    String str2 = enA().getIntent().getStringExtra("shortcut_user_name");
    if ((bt.isNullOrNil(str1)) || (bt.isNullOrNil(str2)))
    {
      ad.e("MicroMsg.WebViewMenuHelper", "addShortcut, appid or username is null");
      AppMethodBeat.o(79897);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("KAppId", str1);
    localBundle.putString("shortcut_user_name", str2);
    localBundle.putInt("webviewui_binder_id", hashCode());
    try
    {
      enA().AMZ.kxf.j(80, localBundle);
      AppMethodBeat.o(79897);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.WebViewMenuHelper", "addShortcut, e = " + localException.getMessage());
      AppMethodBeat.o(79897);
    }
  }
  
  protected final void bFd()
  {
    AppMethodBeat.i(79887);
    this.Bfp = enW();
    if ((this.Bfp != null) && (this.Bfp.size() > 0))
    {
      bool = true;
      this.Bfq = Boolean.valueOf(bool);
      if (!this.nmt) {
        if (!this.Bfq.booleanValue()) {
          break label167;
        }
      }
    }
    label167:
    for (this.lBF = new com.tencent.mm.ui.widget.a.e(enA(), 1, false);; this.lBF = new com.tencent.mm.ui.widget.a.e(enA(), 0, true))
    {
      this.lBF.Hsb = new com.tencent.mm.ui.base.n.a()
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
          if ((i.this.Bfi.get(paramAnonymousMenuItem) != null) && (!((Bitmap)i.this.Bfi.get(paramAnonymousMenuItem)).isRecycled()))
          {
            paramAnonymousImageView.setImageBitmap((Bitmap)i.this.Bfi.get(paramAnonymousMenuItem));
            AppMethodBeat.o(79858);
            return;
          }
          ad.w("MicroMsg.WebViewMenuHelper", "on attach icon, load from cache fail");
          try
          {
            Object localObject = i.this.enA().AMZ.kxf.axx(paramAnonymousMenuItem);
            if (!bt.isNullOrNil((String)localObject))
            {
              localObject = e.axM((String)localObject);
              if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
              {
                paramAnonymousImageView.setImageBitmap((Bitmap)localObject);
                i.this.Bfi.put(paramAnonymousMenuItem, localObject);
              }
            }
            AppMethodBeat.o(79858);
            return;
          }
          catch (Exception paramAnonymousImageView)
          {
            ad.w("MicroMsg.WebViewMenuHelper", "getheadimg, ex = " + paramAnonymousImageView.getMessage());
            AppMethodBeat.o(79858);
          }
        }
      };
      this.lBF.Hsc = new n.b()
      {
        public final void a(TextView paramAnonymousTextView, MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(79869);
          paramAnonymousMenuItem = paramAnonymousMenuItem.getTitle();
          if (paramAnonymousTextView != null)
          {
            String str = (String)i.this.Bfj.get(paramAnonymousMenuItem);
            if (bt.isNullOrNil(str))
            {
              paramAnonymousTextView.setText(paramAnonymousMenuItem);
              AppMethodBeat.o(79869);
              return;
            }
            paramAnonymousTextView.setText(k.b(i.this.enA(), str, paramAnonymousTextView.getTextSize()));
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
          //   8: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   11: iconst_0
          //   12: putfield 37	com/tencent/mm/plugin/webview/ui/tools/i:nmt	Z
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
          //   39: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   42: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   45: getfield 59	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:AQP	Lcom/tencent/mm/plugin/webview/c/f;
          //   48: astore_1
          //   49: aload_1
          //   50: getfield 64	com/tencent/mm/plugin/webview/c/f:yZR	Z
          //   53: ifne +16 -> 69
          //   56: ldc 66
          //   58: ldc 68
          //   60: invokestatic 73	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   63: ldc 27
          //   65: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   68: return
          //   69: ldc 66
          //   71: ldc 78
          //   73: invokestatic 80	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
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
          //   116: getfield 101	com/tencent/mm/plugin/webview/c/f:ARm	Z
          //   119: aload_1
          //   120: getfield 104	com/tencent/mm/plugin/webview/c/f:ARn	Ljava/lang/String;
          //   123: invokestatic 110	com/tencent/mm/plugin/webview/c/l$a:b	(Ljava/lang/String;Ljava/util/Map;ZLjava/lang/String;)Ljava/lang/String;
          //   126: astore 4
          //   128: aload_1
          //   129: getfield 114	com/tencent/mm/plugin/webview/c/f:ARe	Lcom/tencent/mm/ui/widget/MMWebView;
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
          //   184: invokestatic 154	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   187: aload_1
          //   188: invokeinterface 145 1 0
          //   193: lookupswitch	default:+315->508, 1:+564->757, 2:+824->1017, 3:+1165->1358, 5:+1268->1461, 6:+1647->1840, 7:+1710->1903, 8:+2150->2343, 9:+2308->2501, 10:+2408->2601, 11:+1402->1595, 12:+2473->2666, 15:+2604->2797, 16:+2669->2862, 17:+2734->2927, 18:+2799->2992, 19:+2864->3057, 20:+3202->3395, 21:+3425->3618, 22:+3583->3776, 23:+721->914, 24:+4015->4208, 25:+2929->3122, 26:+3138->3331, 27:+484->677, 28:+1580->1773, 29:+4079->4272, 31:+4143->4336, 33:+3806->3999, 34:+4267->4460, 35:+4365->4558, 36:+4436->4629, 37:+2086->2279, 38:+1035->1228, 39:+1100->1293, 40:+4574->4767, 41:+4574->4767, 42:+4574->4767, 99:+4507->4700
          //   509: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   512: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   515: getfield 158	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:AMJ	Lcom/tencent/mm/plugin/webview/model/ax;
          //   518: invokevirtual 164	com/tencent/mm/plugin/webview/model/ax:emr	()Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   521: iconst_3
          //   522: anewarray 4	java/lang/Object
          //   525: dup
          //   526: iconst_0
          //   527: aload_0
          //   528: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   531: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   534: invokevirtual 167	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bEx	()Ljava/lang/String;
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
          //   553: invokevirtual 173	com/tencent/mm/plugin/webview/model/ax$d:z	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ax$d;
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
          //   582: invokestatic 190	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
          //   585: ifne +4427 -> 5012
          //   588: new 192	android/os/Bundle
          //   591: dup
          //   592: invokespecial 193	android/os/Bundle:<init>	()V
          //   595: astore_1
          //   596: aload_1
          //   597: ldc 195
          //   599: aload 4
          //   601: invokevirtual 198	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
          //   604: aload_0
          //   605: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   608: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   611: getfield 202	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:AMZ	Lcom/tencent/mm/plugin/webview/core/h;
          //   614: getfield 208	com/tencent/mm/plugin/webview/core/h:kxf	Lcom/tencent/mm/plugin/webview/stub/e;
          //   617: bipush 50
          //   619: aload_1
          //   620: invokeinterface 214 3 0
          //   625: astore_1
          //   626: aload_1
          //   627: ifnull +4395 -> 5022
          //   630: aload_1
          //   631: ldc 216
          //   633: invokevirtual 220	android/os/Bundle:getInt	(Ljava/lang/String;)I
          //   636: istore_2
          //   637: iload_2
          //   638: iconst_2
          //   639: if_icmpne +4158 -> 4797
          //   642: iconst_1
          //   643: istore_2
          //   644: aload_1
          //   645: ldc 216
          //   647: invokevirtual 220	android/os/Bundle:getInt	(Ljava/lang/String;)I
          //   650: istore_3
          //   651: iload_3
          //   652: iconst_3
          //   653: if_icmpne +4149 -> 4802
          //   656: iconst_1
          //   657: istore_2
          //   658: iload_2
          //   659: ifeq +4167 -> 4826
          //   662: aload_0
          //   663: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   666: aload 4
          //   668: invokevirtual 223	com/tencent/mm/plugin/webview/ui/tools/i:axU	(Ljava/lang/String;)V
          //   671: ldc 27
          //   673: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   676: return
          //   677: aload_0
          //   678: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   681: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   684: getfield 158	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:AMJ	Lcom/tencent/mm/plugin/webview/model/ax;
          //   687: invokevirtual 164	com/tencent/mm/plugin/webview/model/ax:emr	()Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   690: iconst_3
          //   691: anewarray 4	java/lang/Object
          //   694: dup
          //   695: iconst_0
          //   696: aload_0
          //   697: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   700: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   703: invokevirtual 167	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bEx	()Ljava/lang/String;
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
          //   722: invokevirtual 173	com/tencent/mm/plugin/webview/model/ax$d:z	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   725: invokevirtual 176	com/tencent/mm/plugin/webview/model/ax$d:report	()V
          //   728: aload_0
          //   729: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   732: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   735: invokevirtual 227	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:ekR	()Z
          //   738: ifne +4274 -> 5012
          //   741: aload_0
          //   742: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   745: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   748: invokevirtual 230	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:finish	()V
          //   751: ldc 27
          //   753: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   756: return
          //   757: aload_0
          //   758: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   761: invokevirtual 233	com/tencent/mm/plugin/webview/ui/tools/a:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   764: invokevirtual 237	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
          //   767: ldc 239
          //   769: invokevirtual 245	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
          //   772: astore_1
          //   773: aload_0
          //   774: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   777: invokevirtual 233	com/tencent/mm/plugin/webview/ui/tools/a:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   780: invokevirtual 237	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
          //   783: ldc 247
          //   785: invokevirtual 245	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
          //   788: astore 4
          //   790: aload_0
          //   791: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   794: invokevirtual 233	com/tencent/mm/plugin/webview/ui/tools/a:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   797: invokevirtual 237	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
          //   800: ldc 249
          //   802: invokevirtual 245	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
          //   805: astore 5
          //   807: aload_0
          //   808: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   811: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   814: getfield 158	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:AMJ	Lcom/tencent/mm/plugin/webview/model/ax;
          //   817: invokevirtual 164	com/tencent/mm/plugin/webview/model/ax:emr	()Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   820: bipush 6
          //   822: anewarray 4	java/lang/Object
          //   825: dup
          //   826: iconst_0
          //   827: aload_0
          //   828: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   831: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   834: invokevirtual 167	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bEx	()Ljava/lang/String;
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
          //   866: invokevirtual 173	com/tencent/mm/plugin/webview/model/ax$d:z	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   869: invokevirtual 176	com/tencent/mm/plugin/webview/model/ax$d:report	()V
          //   872: aload_0
          //   873: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   876: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   879: aload_0
          //   880: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   883: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   886: getfield 253	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:kxg	Lcom/tencent/mm/plugin/webview/e/g;
          //   889: invokevirtual 259	com/tencent/mm/plugin/webview/e/g:emS	()Lcom/tencent/mm/protocal/GeneralControlWrapper;
          //   892: invokevirtual 264	com/tencent/mm/protocal/GeneralControlWrapper:eBQ	()Z
          //   895: putfield 267	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Bhd	Z
          //   898: aload_0
          //   899: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   902: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   905: invokevirtual 270	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:dqY	()V
          //   908: ldc 27
          //   910: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   913: return
          //   914: new 241	android/content/Intent
          //   917: dup
          //   918: invokespecial 271	android/content/Intent:<init>	()V
          //   921: astore_1
          //   922: aload_0
          //   923: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   926: invokevirtual 233	com/tencent/mm/plugin/webview/ui/tools/a:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   929: invokevirtual 237	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
          //   932: ldc_w 273
          //   935: invokevirtual 245	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
          //   938: astore 4
          //   940: aload 4
          //   942: ifnull +42 -> 984
          //   945: aload_1
          //   946: ldc_w 275
          //   949: iconst_1
          //   950: invokevirtual 279	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
          //   953: pop
          //   954: aload_1
          //   955: ldc_w 273
          //   958: aload 4
          //   960: invokevirtual 282	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
          //   963: pop
          //   964: aload_0
          //   965: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   968: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   971: ldc_w 284
          //   974: aload_1
          //   975: invokestatic 289	com/tencent/mm/bs/d:e	(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;)V
          //   978: ldc 27
          //   980: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   983: return
          //   984: aload_1
          //   985: ldc_w 291
          //   988: aload_0
          //   989: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   992: invokevirtual 233	com/tencent/mm/plugin/webview/ui/tools/a:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   995: invokevirtual 237	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
          //   998: ldc_w 293
          //   1001: ldc2_w 294
          //   1004: invokevirtual 299	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
          //   1007: invokestatic 304	java/lang/Long:valueOf	(J)Ljava/lang/Long;
          //   1010: invokevirtual 307	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;
          //   1013: pop
          //   1014: goto -50 -> 964
          //   1017: aload_0
          //   1018: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1021: invokevirtual 233	com/tencent/mm/plugin/webview/ui/tools/a:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1024: invokevirtual 237	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
          //   1027: ldc 239
          //   1029: invokevirtual 245	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
          //   1032: astore_1
          //   1033: aload_0
          //   1034: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1037: invokevirtual 233	com/tencent/mm/plugin/webview/ui/tools/a:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1040: invokevirtual 237	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
          //   1043: ldc 247
          //   1045: invokevirtual 245	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
          //   1048: astore 4
          //   1050: aload_0
          //   1051: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1054: invokevirtual 233	com/tencent/mm/plugin/webview/ui/tools/a:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1057: invokevirtual 237	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
          //   1060: ldc 249
          //   1062: invokevirtual 245	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
          //   1065: astore 5
          //   1067: aload_0
          //   1068: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1071: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1074: getfield 158	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:AMJ	Lcom/tencent/mm/plugin/webview/model/ax;
          //   1077: invokevirtual 164	com/tencent/mm/plugin/webview/model/ax:emr	()Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   1080: bipush 6
          //   1082: anewarray 4	java/lang/Object
          //   1085: dup
          //   1086: iconst_0
          //   1087: aload_0
          //   1088: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1091: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1094: invokevirtual 167	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bEx	()Ljava/lang/String;
          //   1097: aastore
          //   1098: dup
          //   1099: iconst_1
          //   1100: iconst_2
          //   1101: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1104: aastore
          //   1105: dup
          //   1106: iconst_2
          //   1107: iconst_1
          //   1108: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1111: aastore
          //   1112: dup
          //   1113: iconst_3
          //   1114: aload_1
          //   1115: aastore
          //   1116: dup
          //   1117: iconst_4
          //   1118: aload 4
          //   1120: aastore
          //   1121: dup
          //   1122: iconst_5
          //   1123: aload 5
          //   1125: aastore
          //   1126: invokevirtual 173	com/tencent/mm/plugin/webview/model/ax$d:z	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   1129: invokevirtual 176	com/tencent/mm/plugin/webview/model/ax$d:report	()V
          //   1132: aload_0
          //   1133: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1136: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1139: aload_0
          //   1140: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1143: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1146: getfield 253	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:kxg	Lcom/tencent/mm/plugin/webview/e/g;
          //   1149: invokevirtual 259	com/tencent/mm/plugin/webview/e/g:emS	()Lcom/tencent/mm/protocal/GeneralControlWrapper;
          //   1152: invokevirtual 264	com/tencent/mm/protocal/GeneralControlWrapper:eBQ	()Z
          //   1155: putfield 267	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Bhd	Z
          //   1158: aload_0
          //   1159: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1162: getfield 311	com/tencent/mm/plugin/webview/ui/tools/i:Bfl	Ljava/util/HashMap;
          //   1165: aload_0
          //   1166: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1169: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1172: getfield 314	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:nhy	Lcom/tencent/mm/ui/widget/MMWebView;
          //   1175: invokevirtual 317	com/tencent/mm/ui/widget/MMWebView:getUrl	()Ljava/lang/String;
          //   1178: invokevirtual 321	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
          //   1181: ifeq +33 -> 1214
          //   1184: aload_0
          //   1185: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1188: getfield 311	com/tencent/mm/plugin/webview/ui/tools/i:Bfl	Ljava/util/HashMap;
          //   1191: aload_0
          //   1192: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1195: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1198: getfield 314	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:nhy	Lcom/tencent/mm/ui/widget/MMWebView;
          //   1201: invokevirtual 317	com/tencent/mm/ui/widget/MMWebView:getUrl	()Ljava/lang/String;
          //   1204: invokevirtual 325	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
          //   1207: checkcast 147	java/lang/Integer
          //   1210: invokevirtual 328	java/lang/Integer:intValue	()I
          //   1213: istore_2
          //   1214: aload_0
          //   1215: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1218: iload_2
          //   1219: invokestatic 332	com/tencent/mm/plugin/webview/ui/tools/i:a	(Lcom/tencent/mm/plugin/webview/ui/tools/i;I)V
          //   1222: ldc 27
          //   1224: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1227: return
          //   1228: aload_0
          //   1229: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1232: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1235: getfield 158	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:AMJ	Lcom/tencent/mm/plugin/webview/model/ax;
          //   1238: invokevirtual 164	com/tencent/mm/plugin/webview/model/ax:emr	()Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   1241: iconst_3
          //   1242: anewarray 4	java/lang/Object
          //   1245: dup
          //   1246: iconst_0
          //   1247: aload_0
          //   1248: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1251: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1254: invokevirtual 167	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bEx	()Ljava/lang/String;
          //   1257: aastore
          //   1258: dup
          //   1259: iconst_1
          //   1260: bipush 36
          //   1262: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1265: aastore
          //   1266: dup
          //   1267: iconst_2
          //   1268: iconst_1
          //   1269: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1272: aastore
          //   1273: invokevirtual 173	com/tencent/mm/plugin/webview/model/ax$d:z	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   1276: invokevirtual 176	com/tencent/mm/plugin/webview/model/ax$d:report	()V
          //   1279: aload_0
          //   1280: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1283: iconst_1
          //   1284: invokestatic 334	com/tencent/mm/plugin/webview/ui/tools/i:b	(Lcom/tencent/mm/plugin/webview/ui/tools/i;I)V
          //   1287: ldc 27
          //   1289: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1292: return
          //   1293: aload_0
          //   1294: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1297: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1300: getfield 158	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:AMJ	Lcom/tencent/mm/plugin/webview/model/ax;
          //   1303: invokevirtual 164	com/tencent/mm/plugin/webview/model/ax:emr	()Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   1306: iconst_3
          //   1307: anewarray 4	java/lang/Object
          //   1310: dup
          //   1311: iconst_0
          //   1312: aload_0
          //   1313: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1316: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1319: invokevirtual 167	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bEx	()Ljava/lang/String;
          //   1322: aastore
          //   1323: dup
          //   1324: iconst_1
          //   1325: bipush 37
          //   1327: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1330: aastore
          //   1331: dup
          //   1332: iconst_2
          //   1333: iconst_1
          //   1334: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1337: aastore
          //   1338: invokevirtual 173	com/tencent/mm/plugin/webview/model/ax$d:z	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   1341: invokevirtual 176	com/tencent/mm/plugin/webview/model/ax$d:report	()V
          //   1344: aload_0
          //   1345: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1348: iconst_0
          //   1349: invokestatic 334	com/tencent/mm/plugin/webview/ui/tools/i:b	(Lcom/tencent/mm/plugin/webview/ui/tools/i;I)V
          //   1352: ldc 27
          //   1354: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1357: return
          //   1358: aload_0
          //   1359: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1362: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1365: getfield 158	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:AMJ	Lcom/tencent/mm/plugin/webview/model/ax;
          //   1368: invokevirtual 164	com/tencent/mm/plugin/webview/model/ax:emr	()Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   1371: iconst_3
          //   1372: anewarray 4	java/lang/Object
          //   1375: dup
          //   1376: iconst_0
          //   1377: aload_0
          //   1378: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1381: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1384: invokevirtual 167	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bEx	()Ljava/lang/String;
          //   1387: aastore
          //   1388: dup
          //   1389: iconst_1
          //   1390: iconst_3
          //   1391: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1394: aastore
          //   1395: dup
          //   1396: iconst_2
          //   1397: iconst_1
          //   1398: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1401: aastore
          //   1402: invokevirtual 173	com/tencent/mm/plugin/webview/model/ax$d:z	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   1405: invokevirtual 176	com/tencent/mm/plugin/webview/model/ax$d:report	()V
          //   1408: getstatic 340	com/tencent/mm/plugin/report/service/h:vKh	Lcom/tencent/mm/plugin/report/service/h;
          //   1411: ldc2_w 341
          //   1414: ldc2_w 343
          //   1417: lconst_1
          //   1418: iconst_0
          //   1419: invokevirtual 348	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
          //   1422: aload_0
          //   1423: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1426: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1429: aload_0
          //   1430: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1433: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1436: getfield 253	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:kxg	Lcom/tencent/mm/plugin/webview/e/g;
          //   1439: invokevirtual 259	com/tencent/mm/plugin/webview/e/g:emS	()Lcom/tencent/mm/protocal/GeneralControlWrapper;
          //   1442: invokevirtual 264	com/tencent/mm/protocal/GeneralControlWrapper:eBQ	()Z
          //   1445: putfield 267	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Bhd	Z
          //   1448: aload_0
          //   1449: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1452: invokevirtual 351	com/tencent/mm/plugin/webview/ui/tools/i:enX	()V
          //   1455: ldc 27
          //   1457: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1460: return
          //   1461: aload_0
          //   1462: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1465: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1468: getfield 158	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:AMJ	Lcom/tencent/mm/plugin/webview/model/ax;
          //   1471: invokevirtual 164	com/tencent/mm/plugin/webview/model/ax:emr	()Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   1474: iconst_3
          //   1475: anewarray 4	java/lang/Object
          //   1478: dup
          //   1479: iconst_0
          //   1480: aload_0
          //   1481: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1484: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1487: invokevirtual 167	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bEx	()Ljava/lang/String;
          //   1490: aastore
          //   1491: dup
          //   1492: iconst_1
          //   1493: iconst_4
          //   1494: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1497: aastore
          //   1498: dup
          //   1499: iconst_2
          //   1500: iconst_1
          //   1501: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1504: aastore
          //   1505: invokevirtual 173	com/tencent/mm/plugin/webview/model/ax$d:z	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   1508: invokevirtual 176	com/tencent/mm/plugin/webview/model/ax$d:report	()V
          //   1511: aload_0
          //   1512: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1515: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1518: getfield 354	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Bhx	Ljava/util/HashMap;
          //   1521: aload_0
          //   1522: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1525: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1528: getfield 314	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:nhy	Lcom/tencent/mm/ui/widget/MMWebView;
          //   1531: invokevirtual 317	com/tencent/mm/ui/widget/MMWebView:getUrl	()Ljava/lang/String;
          //   1534: invokevirtual 325	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
          //   1537: checkcast 356	java/lang/String
          //   1540: astore 4
          //   1542: aload 4
          //   1544: astore_1
          //   1545: aload 4
          //   1547: ifnonnull +19 -> 1566
          //   1550: aload_0
          //   1551: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1554: invokevirtual 233	com/tencent/mm/plugin/webview/ui/tools/a:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1557: invokevirtual 237	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
          //   1560: ldc 249
          //   1562: invokevirtual 245	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
          //   1565: astore_1
          //   1566: aload_0
          //   1567: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1570: ldc_w 358
          //   1573: bipush 43
          //   1575: invokevirtual 362	com/tencent/mm/plugin/webview/ui/tools/i:fk	(Ljava/lang/String;I)V
          //   1578: aload_0
          //   1579: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1582: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1585: aload_1
          //   1586: invokevirtual 365	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:axZ	(Ljava/lang/String;)V
          //   1589: ldc 27
          //   1591: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1594: return
          //   1595: aload_0
          //   1596: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1599: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1602: getfield 158	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:AMJ	Lcom/tencent/mm/plugin/webview/model/ax;
          //   1605: invokevirtual 164	com/tencent/mm/plugin/webview/model/ax:emr	()Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   1608: iconst_3
          //   1609: anewarray 4	java/lang/Object
          //   1612: dup
          //   1613: iconst_0
          //   1614: aload_0
          //   1615: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1618: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1621: invokevirtual 167	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bEx	()Ljava/lang/String;
          //   1624: aastore
          //   1625: dup
          //   1626: iconst_1
          //   1627: bipush 8
          //   1629: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1632: aastore
          //   1633: dup
          //   1634: iconst_2
          //   1635: iconst_1
          //   1636: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1639: aastore
          //   1640: invokevirtual 173	com/tencent/mm/plugin/webview/model/ax$d:z	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   1643: invokevirtual 176	com/tencent/mm/plugin/webview/model/ax$d:report	()V
          //   1646: aload_0
          //   1647: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1650: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1653: getfield 369	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:BgK	Landroid/view/View;
          //   1656: invokevirtual 374	android/view/View:getVisibility	()I
          //   1659: bipush 8
          //   1661: if_icmpne +51 -> 1712
          //   1664: aload_0
          //   1665: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1668: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1671: ldc_w 375
          //   1674: invokestatic 381	android/view/animation/AnimationUtils:loadAnimation	(Landroid/content/Context;I)Landroid/view/animation/Animation;
          //   1677: astore_1
          //   1678: aload_0
          //   1679: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1682: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1685: getfield 369	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:BgK	Landroid/view/View;
          //   1688: aload_1
          //   1689: invokevirtual 385	android/view/View:startAnimation	(Landroid/view/animation/Animation;)V
          //   1692: aload_0
          //   1693: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1696: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1699: getfield 369	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:BgK	Landroid/view/View;
          //   1702: iconst_0
          //   1703: invokevirtual 388	android/view/View:setVisibility	(I)V
          //   1706: ldc 27
          //   1708: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1711: return
          //   1712: aload_0
          //   1713: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1716: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1719: ldc_w 389
          //   1722: invokestatic 381	android/view/animation/AnimationUtils:loadAnimation	(Landroid/content/Context;I)Landroid/view/animation/Animation;
          //   1725: astore_1
          //   1726: aload_1
          //   1727: new 13	com/tencent/mm/plugin/webview/ui/tools/i$14$1
          //   1730: dup
          //   1731: aload_0
          //   1732: invokespecial 392	com/tencent/mm/plugin/webview/ui/tools/i$14$1:<init>	(Lcom/tencent/mm/plugin/webview/ui/tools/i$14;)V
          //   1735: invokevirtual 398	android/view/animation/Animation:setAnimationListener	(Landroid/view/animation/Animation$AnimationListener;)V
          //   1738: aload_0
          //   1739: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1742: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1745: getfield 369	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:BgK	Landroid/view/View;
          //   1748: aload_1
          //   1749: invokevirtual 385	android/view/View:startAnimation	(Landroid/view/animation/Animation;)V
          //   1752: aload_0
          //   1753: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1756: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1759: getfield 369	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:BgK	Landroid/view/View;
          //   1762: bipush 8
          //   1764: invokevirtual 388	android/view/View:setVisibility	(I)V
          //   1767: ldc 27
          //   1769: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1772: return
          //   1773: aload_0
          //   1774: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1777: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1780: getfield 158	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:AMJ	Lcom/tencent/mm/plugin/webview/model/ax;
          //   1783: invokevirtual 164	com/tencent/mm/plugin/webview/model/ax:emr	()Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   1786: iconst_3
          //   1787: anewarray 4	java/lang/Object
          //   1790: dup
          //   1791: iconst_0
          //   1792: aload_0
          //   1793: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1796: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1799: invokevirtual 167	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bEx	()Ljava/lang/String;
          //   1802: aastore
          //   1803: dup
          //   1804: iconst_1
          //   1805: bipush 10
          //   1807: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1810: aastore
          //   1811: dup
          //   1812: iconst_2
          //   1813: iconst_1
          //   1814: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1817: aastore
          //   1818: invokevirtual 173	com/tencent/mm/plugin/webview/model/ax$d:z	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   1821: invokevirtual 176	com/tencent/mm/plugin/webview/model/ax$d:report	()V
          //   1824: aload_0
          //   1825: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1828: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1831: invokevirtual 401	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:eoK	()V
          //   1834: ldc 27
          //   1836: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1839: return
          //   1840: aload_0
          //   1841: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1844: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1847: getfield 158	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:AMJ	Lcom/tencent/mm/plugin/webview/model/ax;
          //   1850: invokevirtual 164	com/tencent/mm/plugin/webview/model/ax:emr	()Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   1853: iconst_3
          //   1854: anewarray 4	java/lang/Object
          //   1857: dup
          //   1858: iconst_0
          //   1859: aload_0
          //   1860: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1863: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1866: invokevirtual 167	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bEx	()Ljava/lang/String;
          //   1869: aastore
          //   1870: dup
          //   1871: iconst_1
          //   1872: iconst_5
          //   1873: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1876: aastore
          //   1877: dup
          //   1878: iconst_2
          //   1879: iconst_1
          //   1880: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1883: aastore
          //   1884: invokevirtual 173	com/tencent/mm/plugin/webview/model/ax$d:z	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   1887: invokevirtual 176	com/tencent/mm/plugin/webview/model/ax$d:report	()V
          //   1890: aload_0
          //   1891: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1894: invokestatic 403	com/tencent/mm/plugin/webview/ui/tools/i:a	(Lcom/tencent/mm/plugin/webview/ui/tools/i;)V
          //   1897: ldc 27
          //   1899: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1902: return
          //   1903: aload_0
          //   1904: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1907: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1910: getfield 158	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:AMJ	Lcom/tencent/mm/plugin/webview/model/ax;
          //   1913: invokevirtual 164	com/tencent/mm/plugin/webview/model/ax:emr	()Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   1916: iconst_3
          //   1917: anewarray 4	java/lang/Object
          //   1920: dup
          //   1921: iconst_0
          //   1922: aload_0
          //   1923: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1926: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1929: invokevirtual 167	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bEx	()Ljava/lang/String;
          //   1932: aastore
          //   1933: dup
          //   1934: iconst_1
          //   1935: bipush 13
          //   1937: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1940: aastore
          //   1941: dup
          //   1942: iconst_2
          //   1943: iconst_1
          //   1944: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1947: aastore
          //   1948: invokevirtual 173	com/tencent/mm/plugin/webview/model/ax$d:z	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   1951: invokevirtual 176	com/tencent/mm/plugin/webview/model/ax$d:report	()V
          //   1954: aload_0
          //   1955: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1958: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1961: astore 5
          //   1963: aload 5
          //   1965: getfield 404	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:kxf	Lcom/tencent/mm/plugin/webview/stub/e;
          //   1968: astore 6
          //   1970: aload 5
          //   1972: invokevirtual 407	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:isFinishing	()Z
          //   1975: ifne +254 -> 2229
          //   1978: aload 5
          //   1980: invokevirtual 410	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:ejo	()Ljava/lang/String;
          //   1983: astore 4
          //   1985: aload 4
          //   1987: invokestatic 190	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
          //   1990: ifeq +18 -> 2008
          //   1993: ldc_w 412
          //   1996: ldc_w 414
          //   1999: invokestatic 73	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   2002: ldc 27
          //   2004: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   2007: return
          //   2008: aload 4
          //   2010: astore_1
          //   2011: aload 6
          //   2013: ifnull +13 -> 2026
          //   2016: aload 6
          //   2018: aload 4
          //   2020: invokeinterface 417 2 0
          //   2025: astore_1
          //   2026: aload_1
          //   2027: astore 4
          //   2029: aload_1
          //   2030: ldc_w 419
          //   2033: invokevirtual 422	java/lang/String:startsWith	(Ljava/lang/String;)Z
          //   2036: ifne +28 -> 2064
          //   2039: aload_1
          //   2040: astore 4
          //   2042: aload_1
          //   2043: ldc_w 424
          //   2046: invokevirtual 422	java/lang/String:startsWith	(Ljava/lang/String;)Z
          //   2049: ifne +15 -> 2064
          //   2052: ldc_w 419
          //   2055: aload_1
          //   2056: invokestatic 427	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
          //   2059: invokevirtual 430	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
          //   2062: astore 4
          //   2064: new 241	android/content/Intent
          //   2067: dup
          //   2068: ldc_w 432
          //   2071: aload 4
          //   2073: invokestatic 438	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
          //   2076: invokespecial 441	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
          //   2079: astore_1
          //   2080: aload 5
          //   2082: invokestatic 445	com/tencent/mm/sdk/platformtools/bt:iP	(Landroid/content/Context;)Z
          //   2085: ifne +9 -> 2094
          //   2088: invokestatic 450	com/tencent/mm/sdk/platformtools/i:eFb	()Z
          //   2091: ifeq +168 -> 2259
          //   2094: ldc_w 412
          //   2097: ldc_w 452
          //   2100: iconst_2
          //   2101: anewarray 4	java/lang/Object
          //   2104: dup
          //   2105: iconst_0
          //   2106: aload 5
          //   2108: invokestatic 445	com/tencent/mm/sdk/platformtools/bt:iP	(Landroid/content/Context;)Z
          //   2111: invokestatic 457	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
          //   2114: aastore
          //   2115: dup
          //   2116: iconst_1
          //   2117: invokestatic 450	com/tencent/mm/sdk/platformtools/i:eFb	()Z
          //   2120: invokestatic 457	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
          //   2123: aastore
          //   2124: invokestatic 154	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   2127: new 459	com/tencent/mm/hellhoundlib/b/a
          //   2130: dup
          //   2131: invokespecial 460	com/tencent/mm/hellhoundlib/b/a:<init>	()V
          //   2134: aload_1
          //   2135: invokevirtual 464	com/tencent/mm/hellhoundlib/b/a:bd	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
          //   2138: astore_1
          //   2139: aload 5
          //   2141: aload_1
          //   2142: invokevirtual 468	com/tencent/mm/hellhoundlib/b/a:adn	()[Ljava/lang/Object;
          //   2145: ldc_w 470
          //   2148: ldc_w 472
          //   2151: ldc_w 474
          //   2154: ldc_w 476
          //   2157: ldc_w 478
          //   2160: ldc_w 480
          //   2163: invokestatic 485	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
          //   2166: aload 5
          //   2168: aload_1
          //   2169: iconst_0
          //   2170: invokevirtual 489	com/tencent/mm/hellhoundlib/b/a:lS	(I)Ljava/lang/Object;
          //   2173: checkcast 241	android/content/Intent
          //   2176: invokevirtual 491	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:startActivity	(Landroid/content/Intent;)V
          //   2179: aload 5
          //   2181: ldc_w 470
          //   2184: ldc_w 472
          //   2187: ldc_w 474
          //   2190: ldc_w 476
          //   2193: ldc_w 478
          //   2196: ldc_w 480
          //   2199: invokestatic 494	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
          //   2202: ldc 27
          //   2204: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   2207: return
          //   2208: astore_1
          //   2209: ldc_w 412
          //   2212: ldc_w 496
          //   2215: iconst_1
          //   2216: anewarray 4	java/lang/Object
          //   2219: dup
          //   2220: iconst_0
          //   2221: aload_1
          //   2222: invokevirtual 499	java/lang/Exception:getMessage	()Ljava/lang/String;
          //   2225: aastore
          //   2226: invokestatic 501	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   2229: ldc 27
          //   2231: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   2234: return
          //   2235: astore_1
          //   2236: ldc_w 412
          //   2239: ldc_w 503
          //   2242: iconst_1
          //   2243: anewarray 4	java/lang/Object
          //   2246: dup
          //   2247: iconst_0
          //   2248: aload_1
          //   2249: aastore
          //   2250: invokestatic 501	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   2253: aload 4
          //   2255: astore_1
          //   2256: goto -230 -> 2026
          //   2259: aload 5
          //   2261: aload 5
          //   2263: aload_1
          //   2264: aload 4
          //   2266: invokestatic 508	com/tencent/mm/plugin/webview/modeltools/a:a	(Landroid/app/Activity;Landroid/content/Intent;Ljava/lang/String;)Landroid/content/Intent;
          //   2269: iconst_2
          //   2270: invokevirtual 512	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:startActivityForResult	(Landroid/content/Intent;I)V
          //   2273: ldc 27
          //   2275: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   2278: return
          //   2279: aload_0
          //   2280: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   2283: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2286: getfield 158	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:AMJ	Lcom/tencent/mm/plugin/webview/model/ax;
          //   2289: invokevirtual 164	com/tencent/mm/plugin/webview/model/ax:emr	()Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   2292: iconst_3
          //   2293: anewarray 4	java/lang/Object
          //   2296: dup
          //   2297: iconst_0
          //   2298: aload_0
          //   2299: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   2302: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2305: invokevirtual 167	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bEx	()Ljava/lang/String;
          //   2308: aastore
          //   2309: dup
          //   2310: iconst_1
          //   2311: bipush 35
          //   2313: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   2316: aastore
          //   2317: dup
          //   2318: iconst_2
          //   2319: iconst_1
          //   2320: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   2323: aastore
          //   2324: invokevirtual 173	com/tencent/mm/plugin/webview/model/ax$d:z	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   2327: invokevirtual 176	com/tencent/mm/plugin/webview/model/ax$d:report	()V
          //   2330: aload_0
          //   2331: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   2334: invokestatic 514	com/tencent/mm/plugin/webview/ui/tools/i:b	(Lcom/tencent/mm/plugin/webview/ui/tools/i;)V
          //   2337: ldc 27
          //   2339: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   2342: return
          //   2343: aload_0
          //   2344: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   2347: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2350: getfield 158	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:AMJ	Lcom/tencent/mm/plugin/webview/model/ax;
          //   2353: invokevirtual 164	com/tencent/mm/plugin/webview/model/ax:emr	()Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   2356: iconst_3
          //   2357: anewarray 4	java/lang/Object
          //   2360: dup
          //   2361: iconst_0
          //   2362: aload_0
          //   2363: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   2366: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2369: invokevirtual 167	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bEx	()Ljava/lang/String;
          //   2372: aastore
          //   2373: dup
          //   2374: iconst_1
          //   2375: bipush 15
          //   2377: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   2380: aastore
          //   2381: dup
          //   2382: iconst_2
          //   2383: iconst_1
          //   2384: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   2387: aastore
          //   2388: invokevirtual 173	com/tencent/mm/plugin/webview/model/ax$d:z	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   2391: invokevirtual 176	com/tencent/mm/plugin/webview/model/ax$d:report	()V
          //   2394: aload_0
          //   2395: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   2398: astore_1
          //   2399: aload_1
          //   2400: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2403: getfield 59	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:AQP	Lcom/tencent/mm/plugin/webview/c/f;
          //   2406: ldc_w 516
          //   2409: iconst_1
          //   2410: invokevirtual 520	com/tencent/mm/plugin/webview/c/f:bZ	(Ljava/lang/String;Z)V
          //   2413: aload_1
          //   2414: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2417: getfield 59	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:AQP	Lcom/tencent/mm/plugin/webview/c/f;
          //   2420: astore_1
          //   2421: aload_1
          //   2422: getfield 64	com/tencent/mm/plugin/webview/c/f:yZR	Z
          //   2425: ifne +17 -> 2442
          //   2428: ldc 66
          //   2430: ldc_w 522
          //   2433: invokestatic 73	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   2436: ldc 27
          //   2438: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   2441: return
          //   2442: ldc_w 524
          //   2445: new 82	java/util/HashMap
          //   2448: dup
          //   2449: invokespecial 83	java/util/HashMap:<init>	()V
          //   2452: aload_1
          //   2453: getfield 101	com/tencent/mm/plugin/webview/c/f:ARm	Z
          //   2456: aload_1
          //   2457: getfield 104	com/tencent/mm/plugin/webview/c/f:ARn	Ljava/lang/String;
          //   2460: invokestatic 110	com/tencent/mm/plugin/webview/c/l$a:b	(Ljava/lang/String;Ljava/util/Map;ZLjava/lang/String;)Ljava/lang/String;
          //   2463: astore 4
          //   2465: aload_1
          //   2466: getfield 114	com/tencent/mm/plugin/webview/c/f:ARe	Lcom/tencent/mm/ui/widget/MMWebView;
          //   2469: new 116	java/lang/StringBuilder
          //   2472: dup
          //   2473: ldc 118
          //   2475: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   2478: aload 4
          //   2480: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   2483: ldc 127
          //   2485: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   2488: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   2491: aconst_null
          //   2492: invokevirtual 137	com/tencent/mm/ui/widget/MMWebView:evaluateJavascript	(Ljava/lang/String;Landroid/webkit/ValueCallback;)V
          //   2495: ldc 27
          //   2497: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   2500: return
          //   2501: aload_0
          //   2502: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   2505: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2508: getfield 158	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:AMJ	Lcom/tencent/mm/plugin/webview/model/ax;
          //   2511: invokevirtual 164	com/tencent/mm/plugin/webview/model/ax:emr	()Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   2514: iconst_3
          //   2515: anewarray 4	java/lang/Object
          //   2518: dup
          //   2519: iconst_0
          //   2520: aload_0
          //   2521: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   2524: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2527: invokevirtual 167	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bEx	()Ljava/lang/String;
          //   2530: aastore
          //   2531: dup
          //   2532: iconst_1
          //   2533: bipush 7
          //   2535: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   2538: aastore
          //   2539: dup
          //   2540: iconst_2
          //   2541: iconst_1
          //   2542: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   2545: aastore
          //   2546: invokevirtual 173	com/tencent/mm/plugin/webview/model/ax$d:z	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   2549: invokevirtual 176	com/tencent/mm/plugin/webview/model/ax$d:report	()V
          //   2552: aload_0
          //   2553: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   2556: astore_1
          //   2557: aload_1
          //   2558: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2561: aload_1
          //   2562: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2565: ldc_w 525
          //   2568: invokevirtual 529	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
          //   2571: aconst_null
          //   2572: aconst_null
          //   2573: aload_1
          //   2574: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2577: ldc_w 530
          //   2580: invokevirtual 529	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
          //   2583: new 532	com/tencent/mm/plugin/webview/ui/tools/i$9
          //   2586: dup
          //   2587: aload_1
          //   2588: invokespecial 534	com/tencent/mm/plugin/webview/ui/tools/i$9:<init>	(Lcom/tencent/mm/plugin/webview/ui/tools/i;)V
          //   2591: invokestatic 539	com/tencent/mm/ui/base/h:a	(Landroid/content/Context;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Lcom/tencent/mm/ui/base/h$d;)Landroid/app/Dialog;
          //   2594: pop
          //   2595: ldc 27
          //   2597: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   2600: return
          //   2601: aload_0
          //   2602: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   2605: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2608: getfield 158	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:AMJ	Lcom/tencent/mm/plugin/webview/model/ax;
          //   2611: invokevirtual 164	com/tencent/mm/plugin/webview/model/ax:emr	()Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   2614: iconst_3
          //   2615: anewarray 4	java/lang/Object
          //   2618: dup
          //   2619: iconst_0
          //   2620: aload_0
          //   2621: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   2624: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2627: invokevirtual 167	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bEx	()Ljava/lang/String;
          //   2630: aastore
          //   2631: dup
          //   2632: iconst_1
          //   2633: bipush 11
          //   2635: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   2638: aastore
          //   2639: dup
          //   2640: iconst_2
          //   2641: iconst_1
          //   2642: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   2645: aastore
          //   2646: invokevirtual 173	com/tencent/mm/plugin/webview/model/ax$d:z	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   2649: invokevirtual 176	com/tencent/mm/plugin/webview/model/ax$d:report	()V
          //   2652: aload_0
          //   2653: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   2656: aconst_null
          //   2657: invokevirtual 542	com/tencent/mm/plugin/webview/ui/tools/i:axV	(Ljava/lang/String;)V
          //   2660: ldc 27
          //   2662: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   2665: return
          //   2666: aload_0
          //   2667: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   2670: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2673: getfield 158	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:AMJ	Lcom/tencent/mm/plugin/webview/model/ax;
          //   2676: invokevirtual 164	com/tencent/mm/plugin/webview/model/ax:emr	()Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   2679: iconst_3
          //   2680: anewarray 4	java/lang/Object
          //   2683: dup
          //   2684: iconst_0
          //   2685: aload_0
          //   2686: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   2689: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2692: invokevirtual 167	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bEx	()Ljava/lang/String;
          //   2695: aastore
          //   2696: dup
          //   2697: iconst_1
          //   2698: bipush 6
          //   2700: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   2703: aastore
          //   2704: dup
          //   2705: iconst_2
          //   2706: iconst_1
          //   2707: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   2710: aastore
          //   2711: invokevirtual 173	com/tencent/mm/plugin/webview/model/ax$d:z	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   2714: invokevirtual 176	com/tencent/mm/plugin/webview/model/ax$d:report	()V
          //   2717: new 241	android/content/Intent
          //   2720: dup
          //   2721: invokespecial 271	android/content/Intent:<init>	()V
          //   2724: astore_1
          //   2725: aload_1
          //   2726: ldc_w 544
          //   2729: iconst_2
          //   2730: invokevirtual 547	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
          //   2733: pop
          //   2734: aload_1
          //   2735: ldc_w 549
          //   2738: aload_0
          //   2739: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   2742: invokevirtual 233	com/tencent/mm/plugin/webview/ui/tools/a:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2745: invokevirtual 237	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
          //   2748: ldc_w 551
          //   2751: ldc2_w 552
          //   2754: invokevirtual 299	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
          //   2757: invokevirtual 556	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
          //   2760: pop
          //   2761: aload_0
          //   2762: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   2765: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2768: ldc_w 558
          //   2771: aload_1
          //   2772: invokestatic 562	com/tencent/mm/plugin/fav/a/b:b	(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;)V
          //   2775: aload_0
          //   2776: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   2779: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2782: getfield 158	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:AMJ	Lcom/tencent/mm/plugin/webview/model/ax;
          //   2785: ldc_w 564
          //   2788: invokevirtual 567	com/tencent/mm/plugin/webview/model/ax:awM	(Ljava/lang/String;)V
          //   2791: ldc 27
          //   2793: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   2796: return
          //   2797: aload_0
          //   2798: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   2801: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2804: getfield 158	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:AMJ	Lcom/tencent/mm/plugin/webview/model/ax;
          //   2807: invokevirtual 164	com/tencent/mm/plugin/webview/model/ax:emr	()Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   2810: iconst_3
          //   2811: anewarray 4	java/lang/Object
          //   2814: dup
          //   2815: iconst_0
          //   2816: aload_0
          //   2817: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   2820: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2823: invokevirtual 167	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bEx	()Ljava/lang/String;
          //   2826: aastore
          //   2827: dup
          //   2828: iconst_1
          //   2829: bipush 19
          //   2831: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   2834: aastore
          //   2835: dup
          //   2836: iconst_2
          //   2837: iconst_1
          //   2838: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   2841: aastore
          //   2842: invokevirtual 173	com/tencent/mm/plugin/webview/model/ax$d:z	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   2845: invokevirtual 176	com/tencent/mm/plugin/webview/model/ax$d:report	()V
          //   2848: aload_0
          //   2849: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   2852: aload_1
          //   2853: invokestatic 570	com/tencent/mm/plugin/webview/ui/tools/i:a	(Lcom/tencent/mm/plugin/webview/ui/tools/i;Landroid/view/MenuItem;)V
          //   2856: ldc 27
          //   2858: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   2861: return
          //   2862: aload_0
          //   2863: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   2866: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2869: getfield 158	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:AMJ	Lcom/tencent/mm/plugin/webview/model/ax;
          //   2872: invokevirtual 164	com/tencent/mm/plugin/webview/model/ax:emr	()Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   2875: iconst_3
          //   2876: anewarray 4	java/lang/Object
          //   2879: dup
          //   2880: iconst_0
          //   2881: aload_0
          //   2882: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   2885: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2888: invokevirtual 167	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bEx	()Ljava/lang/String;
          //   2891: aastore
          //   2892: dup
          //   2893: iconst_1
          //   2894: bipush 21
          //   2896: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   2899: aastore
          //   2900: dup
          //   2901: iconst_2
          //   2902: iconst_1
          //   2903: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   2906: aastore
          //   2907: invokevirtual 173	com/tencent/mm/plugin/webview/model/ax$d:z	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   2910: invokevirtual 176	com/tencent/mm/plugin/webview/model/ax$d:report	()V
          //   2913: aload_0
          //   2914: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   2917: aload_1
          //   2918: invokestatic 570	com/tencent/mm/plugin/webview/ui/tools/i:a	(Lcom/tencent/mm/plugin/webview/ui/tools/i;Landroid/view/MenuItem;)V
          //   2921: ldc 27
          //   2923: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   2926: return
          //   2927: aload_0
          //   2928: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   2931: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2934: getfield 158	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:AMJ	Lcom/tencent/mm/plugin/webview/model/ax;
          //   2937: invokevirtual 164	com/tencent/mm/plugin/webview/model/ax:emr	()Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   2940: iconst_3
          //   2941: anewarray 4	java/lang/Object
          //   2944: dup
          //   2945: iconst_0
          //   2946: aload_0
          //   2947: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   2950: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2953: invokevirtual 167	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bEx	()Ljava/lang/String;
          //   2956: aastore
          //   2957: dup
          //   2958: iconst_1
          //   2959: bipush 20
          //   2961: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   2964: aastore
          //   2965: dup
          //   2966: iconst_2
          //   2967: iconst_1
          //   2968: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   2971: aastore
          //   2972: invokevirtual 173	com/tencent/mm/plugin/webview/model/ax$d:z	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   2975: invokevirtual 176	com/tencent/mm/plugin/webview/model/ax$d:report	()V
          //   2978: aload_0
          //   2979: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   2982: aload_1
          //   2983: invokestatic 570	com/tencent/mm/plugin/webview/ui/tools/i:a	(Lcom/tencent/mm/plugin/webview/ui/tools/i;Landroid/view/MenuItem;)V
          //   2986: ldc 27
          //   2988: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   2991: return
          //   2992: aload_0
          //   2993: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   2996: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2999: getfield 158	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:AMJ	Lcom/tencent/mm/plugin/webview/model/ax;
          //   3002: invokevirtual 164	com/tencent/mm/plugin/webview/model/ax:emr	()Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   3005: iconst_3
          //   3006: anewarray 4	java/lang/Object
          //   3009: dup
          //   3010: iconst_0
          //   3011: aload_0
          //   3012: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   3015: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3018: invokevirtual 167	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bEx	()Ljava/lang/String;
          //   3021: aastore
          //   3022: dup
          //   3023: iconst_1
          //   3024: bipush 22
          //   3026: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3029: aastore
          //   3030: dup
          //   3031: iconst_2
          //   3032: iconst_1
          //   3033: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3036: aastore
          //   3037: invokevirtual 173	com/tencent/mm/plugin/webview/model/ax$d:z	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   3040: invokevirtual 176	com/tencent/mm/plugin/webview/model/ax$d:report	()V
          //   3043: aload_0
          //   3044: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   3047: aload_1
          //   3048: invokestatic 570	com/tencent/mm/plugin/webview/ui/tools/i:a	(Lcom/tencent/mm/plugin/webview/ui/tools/i;Landroid/view/MenuItem;)V
          //   3051: ldc 27
          //   3053: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   3056: return
          //   3057: aload_0
          //   3058: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   3061: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3064: getfield 158	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:AMJ	Lcom/tencent/mm/plugin/webview/model/ax;
          //   3067: invokevirtual 164	com/tencent/mm/plugin/webview/model/ax:emr	()Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   3070: iconst_3
          //   3071: anewarray 4	java/lang/Object
          //   3074: dup
          //   3075: iconst_0
          //   3076: aload_0
          //   3077: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   3080: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3083: invokevirtual 167	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bEx	()Ljava/lang/String;
          //   3086: aastore
          //   3087: dup
          //   3088: iconst_1
          //   3089: bipush 23
          //   3091: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3094: aastore
          //   3095: dup
          //   3096: iconst_2
          //   3097: iconst_1
          //   3098: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3101: aastore
          //   3102: invokevirtual 173	com/tencent/mm/plugin/webview/model/ax$d:z	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   3105: invokevirtual 176	com/tencent/mm/plugin/webview/model/ax$d:report	()V
          //   3108: aload_0
          //   3109: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   3112: aload_1
          //   3113: invokestatic 570	com/tencent/mm/plugin/webview/ui/tools/i:a	(Lcom/tencent/mm/plugin/webview/ui/tools/i;Landroid/view/MenuItem;)V
          //   3116: ldc 27
          //   3118: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   3121: return
          //   3122: aload_0
          //   3123: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   3126: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3129: getfield 158	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:AMJ	Lcom/tencent/mm/plugin/webview/model/ax;
          //   3132: invokevirtual 164	com/tencent/mm/plugin/webview/model/ax:emr	()Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   3135: iconst_3
          //   3136: anewarray 4	java/lang/Object
          //   3139: dup
          //   3140: iconst_0
          //   3141: aload_0
          //   3142: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   3145: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3148: invokevirtual 167	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bEx	()Ljava/lang/String;
          //   3151: aastore
          //   3152: dup
          //   3153: iconst_1
          //   3154: bipush 26
          //   3156: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3159: aastore
          //   3160: dup
          //   3161: iconst_2
          //   3162: iconst_1
          //   3163: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3166: aastore
          //   3167: invokevirtual 173	com/tencent/mm/plugin/webview/model/ax$d:z	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   3170: invokevirtual 176	com/tencent/mm/plugin/webview/model/ax$d:report	()V
          //   3173: aload_0
          //   3174: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   3177: astore_1
          //   3178: aload_1
          //   3179: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3182: getfield 59	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:AQP	Lcom/tencent/mm/plugin/webview/c/f;
          //   3185: ldc_w 572
          //   3188: iconst_1
          //   3189: invokevirtual 520	com/tencent/mm/plugin/webview/c/f:bZ	(Ljava/lang/String;Z)V
          //   3192: aload_1
          //   3193: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3196: getfield 59	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:AQP	Lcom/tencent/mm/plugin/webview/c/f;
          //   3199: astore_1
          //   3200: aload_1
          //   3201: getfield 64	com/tencent/mm/plugin/webview/c/f:yZR	Z
          //   3204: ifne +17 -> 3221
          //   3207: ldc 66
          //   3209: ldc_w 574
          //   3212: invokestatic 73	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   3215: ldc 27
          //   3217: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   3220: return
          //   3221: ldc_w 576
          //   3224: new 82	java/util/HashMap
          //   3227: dup
          //   3228: invokespecial 83	java/util/HashMap:<init>	()V
          //   3231: aload_1
          //   3232: getfield 101	com/tencent/mm/plugin/webview/c/f:ARm	Z
          //   3235: aload_1
          //   3236: getfield 104	com/tencent/mm/plugin/webview/c/f:ARn	Ljava/lang/String;
          //   3239: invokestatic 110	com/tencent/mm/plugin/webview/c/l$a:b	(Ljava/lang/String;Ljava/util/Map;ZLjava/lang/String;)Ljava/lang/String;
          //   3242: astore 4
          //   3244: aload_1
          //   3245: getfield 114	com/tencent/mm/plugin/webview/c/f:ARe	Lcom/tencent/mm/ui/widget/MMWebView;
          //   3248: new 116	java/lang/StringBuilder
          //   3251: dup
          //   3252: ldc 118
          //   3254: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   3257: aload 4
          //   3259: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   3262: ldc 127
          //   3264: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   3267: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   3270: aconst_null
          //   3271: invokevirtual 137	com/tencent/mm/ui/widget/MMWebView:evaluateJavascript	(Ljava/lang/String;Landroid/webkit/ValueCallback;)V
          //   3274: aload_1
          //   3275: getfield 577	com/tencent/mm/plugin/webview/c/f:kxf	Lcom/tencent/mm/plugin/webview/stub/e;
          //   3278: ldc_w 579
          //   3281: ldc_w 581
          //   3284: aload_1
          //   3285: getfield 585	com/tencent/mm/plugin/webview/c/f:ARo	I
          //   3288: invokeinterface 589 4 0
          //   3293: ldc 27
          //   3295: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   3298: return
          //   3299: astore_1
          //   3300: ldc 66
          //   3302: new 116	java/lang/StringBuilder
          //   3305: dup
          //   3306: ldc_w 591
          //   3309: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   3312: aload_1
          //   3313: invokevirtual 499	java/lang/Exception:getMessage	()Ljava/lang/String;
          //   3316: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   3319: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   3322: invokestatic 594	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
          //   3325: ldc 27
          //   3327: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   3330: return
          //   3331: aload_0
          //   3332: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   3335: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3338: getfield 158	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:AMJ	Lcom/tencent/mm/plugin/webview/model/ax;
          //   3341: invokevirtual 164	com/tencent/mm/plugin/webview/model/ax:emr	()Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   3344: iconst_3
          //   3345: anewarray 4	java/lang/Object
          //   3348: dup
          //   3349: iconst_0
          //   3350: aload_0
          //   3351: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   3354: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3357: invokevirtual 167	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bEx	()Ljava/lang/String;
          //   3360: aastore
          //   3361: dup
          //   3362: iconst_1
          //   3363: bipush 27
          //   3365: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3368: aastore
          //   3369: dup
          //   3370: iconst_2
          //   3371: iconst_1
          //   3372: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3375: aastore
          //   3376: invokevirtual 173	com/tencent/mm/plugin/webview/model/ax$d:z	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   3379: invokevirtual 176	com/tencent/mm/plugin/webview/model/ax$d:report	()V
          //   3382: aload_0
          //   3383: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   3386: invokestatic 597	com/tencent/mm/plugin/webview/ui/tools/i:c	(Lcom/tencent/mm/plugin/webview/ui/tools/i;)V
          //   3389: ldc 27
          //   3391: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   3394: return
          //   3395: aload_0
          //   3396: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   3399: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3402: aload_0
          //   3403: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   3406: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3409: getfield 253	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:kxg	Lcom/tencent/mm/plugin/webview/e/g;
          //   3412: invokevirtual 259	com/tencent/mm/plugin/webview/e/g:emS	()Lcom/tencent/mm/protocal/GeneralControlWrapper;
          //   3415: invokevirtual 264	com/tencent/mm/protocal/GeneralControlWrapper:eBQ	()Z
          //   3418: putfield 267	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Bhd	Z
          //   3421: aload_0
          //   3422: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   3425: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3428: getfield 158	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:AMJ	Lcom/tencent/mm/plugin/webview/model/ax;
          //   3431: invokevirtual 164	com/tencent/mm/plugin/webview/model/ax:emr	()Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   3434: iconst_3
          //   3435: anewarray 4	java/lang/Object
          //   3438: dup
          //   3439: iconst_0
          //   3440: aload_0
          //   3441: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   3444: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3447: invokevirtual 167	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bEx	()Ljava/lang/String;
          //   3450: aastore
          //   3451: dup
          //   3452: iconst_1
          //   3453: bipush 17
          //   3455: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3458: aastore
          //   3459: dup
          //   3460: iconst_2
          //   3461: iconst_1
          //   3462: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3465: aastore
          //   3466: invokevirtual 173	com/tencent/mm/plugin/webview/model/ax$d:z	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   3469: invokevirtual 176	com/tencent/mm/plugin/webview/model/ax$d:report	()V
          //   3472: aload_0
          //   3473: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   3476: astore_1
          //   3477: aload_1
          //   3478: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3481: getfield 59	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:AQP	Lcom/tencent/mm/plugin/webview/c/f;
          //   3484: ldc_w 599
          //   3487: iconst_1
          //   3488: invokevirtual 520	com/tencent/mm/plugin/webview/c/f:bZ	(Ljava/lang/String;Z)V
          //   3491: aload_1
          //   3492: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3495: getfield 59	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:AQP	Lcom/tencent/mm/plugin/webview/c/f;
          //   3498: astore_1
          //   3499: aload_1
          //   3500: getfield 64	com/tencent/mm/plugin/webview/c/f:yZR	Z
          //   3503: ifne +17 -> 3520
          //   3506: ldc 66
          //   3508: ldc_w 601
          //   3511: invokestatic 73	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   3514: ldc 27
          //   3516: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   3519: return
          //   3520: aload_1
          //   3521: iconst_1
          //   3522: invokevirtual 605	com/tencent/mm/plugin/webview/c/f:SF	(I)Landroid/os/Bundle;
          //   3525: astore 4
          //   3527: aload 4
          //   3529: ifnull +30 -> 3559
          //   3532: aload 4
          //   3534: ldc_w 607
          //   3537: iconst_0
          //   3538: invokevirtual 611	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
          //   3541: ifeq +18 -> 3559
          //   3544: aload_1
          //   3545: aload 4
          //   3547: ldc_w 599
          //   3550: invokevirtual 615	com/tencent/mm/plugin/webview/c/f:h	(Landroid/os/Bundle;Ljava/lang/String;)V
          //   3553: ldc 27
          //   3555: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   3558: return
          //   3559: ldc_w 617
          //   3562: new 82	java/util/HashMap
          //   3565: dup
          //   3566: invokespecial 83	java/util/HashMap:<init>	()V
          //   3569: aload_1
          //   3570: getfield 101	com/tencent/mm/plugin/webview/c/f:ARm	Z
          //   3573: aload_1
          //   3574: getfield 104	com/tencent/mm/plugin/webview/c/f:ARn	Ljava/lang/String;
          //   3577: invokestatic 110	com/tencent/mm/plugin/webview/c/l$a:b	(Ljava/lang/String;Ljava/util/Map;ZLjava/lang/String;)Ljava/lang/String;
          //   3580: astore 4
          //   3582: aload_1
          //   3583: getfield 114	com/tencent/mm/plugin/webview/c/f:ARe	Lcom/tencent/mm/ui/widget/MMWebView;
          //   3586: new 116	java/lang/StringBuilder
          //   3589: dup
          //   3590: ldc 118
          //   3592: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   3595: aload 4
          //   3597: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   3600: ldc 127
          //   3602: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   3605: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   3608: aconst_null
          //   3609: invokevirtual 137	com/tencent/mm/ui/widget/MMWebView:evaluateJavascript	(Ljava/lang/String;Landroid/webkit/ValueCallback;)V
          //   3612: ldc 27
          //   3614: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   3617: return
          //   3618: aload_0
          //   3619: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   3622: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3625: getfield 158	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:AMJ	Lcom/tencent/mm/plugin/webview/model/ax;
          //   3628: invokevirtual 164	com/tencent/mm/plugin/webview/model/ax:emr	()Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   3631: iconst_3
          //   3632: anewarray 4	java/lang/Object
          //   3635: dup
          //   3636: iconst_0
          //   3637: aload_0
          //   3638: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   3641: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3644: invokevirtual 167	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bEx	()Ljava/lang/String;
          //   3647: aastore
          //   3648: dup
          //   3649: iconst_1
          //   3650: bipush 18
          //   3652: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3655: aastore
          //   3656: dup
          //   3657: iconst_2
          //   3658: iconst_1
          //   3659: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3662: aastore
          //   3663: invokevirtual 173	com/tencent/mm/plugin/webview/model/ax$d:z	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   3666: invokevirtual 176	com/tencent/mm/plugin/webview/model/ax$d:report	()V
          //   3669: aload_0
          //   3670: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   3673: astore_1
          //   3674: aload_1
          //   3675: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3678: getfield 59	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:AQP	Lcom/tencent/mm/plugin/webview/c/f;
          //   3681: ldc_w 619
          //   3684: iconst_1
          //   3685: invokevirtual 520	com/tencent/mm/plugin/webview/c/f:bZ	(Ljava/lang/String;Z)V
          //   3688: aload_1
          //   3689: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3692: getfield 59	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:AQP	Lcom/tencent/mm/plugin/webview/c/f;
          //   3695: astore_1
          //   3696: aload_1
          //   3697: getfield 64	com/tencent/mm/plugin/webview/c/f:yZR	Z
          //   3700: ifne +17 -> 3717
          //   3703: ldc 66
          //   3705: ldc_w 621
          //   3708: invokestatic 73	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   3711: ldc 27
          //   3713: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   3716: return
          //   3717: ldc_w 623
          //   3720: new 82	java/util/HashMap
          //   3723: dup
          //   3724: invokespecial 83	java/util/HashMap:<init>	()V
          //   3727: aload_1
          //   3728: getfield 101	com/tencent/mm/plugin/webview/c/f:ARm	Z
          //   3731: aload_1
          //   3732: getfield 104	com/tencent/mm/plugin/webview/c/f:ARn	Ljava/lang/String;
          //   3735: invokestatic 110	com/tencent/mm/plugin/webview/c/l$a:b	(Ljava/lang/String;Ljava/util/Map;ZLjava/lang/String;)Ljava/lang/String;
          //   3738: astore 4
          //   3740: aload_1
          //   3741: getfield 114	com/tencent/mm/plugin/webview/c/f:ARe	Lcom/tencent/mm/ui/widget/MMWebView;
          //   3744: new 116	java/lang/StringBuilder
          //   3747: dup
          //   3748: ldc 118
          //   3750: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   3753: aload 4
          //   3755: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   3758: ldc 127
          //   3760: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   3763: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   3766: aconst_null
          //   3767: invokevirtual 137	com/tencent/mm/ui/widget/MMWebView:evaluateJavascript	(Ljava/lang/String;Landroid/webkit/ValueCallback;)V
          //   3770: ldc 27
          //   3772: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   3775: return
          //   3776: aload_0
          //   3777: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   3780: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3783: aload_0
          //   3784: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   3787: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3790: getfield 253	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:kxg	Lcom/tencent/mm/plugin/webview/e/g;
          //   3793: invokevirtual 259	com/tencent/mm/plugin/webview/e/g:emS	()Lcom/tencent/mm/protocal/GeneralControlWrapper;
          //   3796: invokevirtual 264	com/tencent/mm/protocal/GeneralControlWrapper:eBQ	()Z
          //   3799: putfield 267	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Bhd	Z
          //   3802: aload_0
          //   3803: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   3806: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3809: getfield 158	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:AMJ	Lcom/tencent/mm/plugin/webview/model/ax;
          //   3812: invokevirtual 164	com/tencent/mm/plugin/webview/model/ax:emr	()Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   3815: iconst_3
          //   3816: anewarray 4	java/lang/Object
          //   3819: dup
          //   3820: iconst_0
          //   3821: aload_0
          //   3822: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   3825: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3828: invokevirtual 167	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bEx	()Ljava/lang/String;
          //   3831: aastore
          //   3832: dup
          //   3833: iconst_1
          //   3834: bipush 24
          //   3836: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3839: aastore
          //   3840: dup
          //   3841: iconst_2
          //   3842: iconst_1
          //   3843: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3846: aastore
          //   3847: invokevirtual 173	com/tencent/mm/plugin/webview/model/ax$d:z	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   3850: invokevirtual 176	com/tencent/mm/plugin/webview/model/ax$d:report	()V
          //   3853: aload_0
          //   3854: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   3857: astore_1
          //   3858: aload_1
          //   3859: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3862: getfield 59	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:AQP	Lcom/tencent/mm/plugin/webview/c/f;
          //   3865: ldc_w 625
          //   3868: iconst_1
          //   3869: invokevirtual 520	com/tencent/mm/plugin/webview/c/f:bZ	(Ljava/lang/String;Z)V
          //   3872: aload_1
          //   3873: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3876: getfield 59	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:AQP	Lcom/tencent/mm/plugin/webview/c/f;
          //   3879: astore_1
          //   3880: aload_1
          //   3881: getfield 64	com/tencent/mm/plugin/webview/c/f:yZR	Z
          //   3884: ifne +17 -> 3901
          //   3887: ldc 66
          //   3889: ldc_w 627
          //   3892: invokestatic 73	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   3895: ldc 27
          //   3897: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   3900: return
          //   3901: aload_1
          //   3902: iconst_1
          //   3903: invokevirtual 605	com/tencent/mm/plugin/webview/c/f:SF	(I)Landroid/os/Bundle;
          //   3906: astore 4
          //   3908: aload 4
          //   3910: ifnull +30 -> 3940
          //   3913: aload 4
          //   3915: ldc_w 607
          //   3918: iconst_0
          //   3919: invokevirtual 611	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
          //   3922: ifeq +18 -> 3940
          //   3925: aload_1
          //   3926: aload 4
          //   3928: ldc_w 625
          //   3931: invokevirtual 615	com/tencent/mm/plugin/webview/c/f:h	(Landroid/os/Bundle;Ljava/lang/String;)V
          //   3934: ldc 27
          //   3936: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   3939: return
          //   3940: ldc_w 629
          //   3943: new 82	java/util/HashMap
          //   3946: dup
          //   3947: invokespecial 83	java/util/HashMap:<init>	()V
          //   3950: aload_1
          //   3951: getfield 101	com/tencent/mm/plugin/webview/c/f:ARm	Z
          //   3954: aload_1
          //   3955: getfield 104	com/tencent/mm/plugin/webview/c/f:ARn	Ljava/lang/String;
          //   3958: invokestatic 110	com/tencent/mm/plugin/webview/c/l$a:b	(Ljava/lang/String;Ljava/util/Map;ZLjava/lang/String;)Ljava/lang/String;
          //   3961: astore 4
          //   3963: aload_1
          //   3964: getfield 114	com/tencent/mm/plugin/webview/c/f:ARe	Lcom/tencent/mm/ui/widget/MMWebView;
          //   3967: new 116	java/lang/StringBuilder
          //   3970: dup
          //   3971: ldc 118
          //   3973: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   3976: aload 4
          //   3978: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   3981: ldc 127
          //   3983: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   3986: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   3989: aconst_null
          //   3990: invokevirtual 137	com/tencent/mm/ui/widget/MMWebView:evaluateJavascript	(Ljava/lang/String;Landroid/webkit/ValueCallback;)V
          //   3993: ldc 27
          //   3995: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   3998: return
          //   3999: aload_0
          //   4000: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   4003: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4006: getfield 158	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:AMJ	Lcom/tencent/mm/plugin/webview/model/ax;
          //   4009: invokevirtual 164	com/tencent/mm/plugin/webview/model/ax:emr	()Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   4012: iconst_3
          //   4013: anewarray 4	java/lang/Object
          //   4016: dup
          //   4017: iconst_0
          //   4018: aload_0
          //   4019: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   4022: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4025: invokevirtual 167	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bEx	()Ljava/lang/String;
          //   4028: aastore
          //   4029: dup
          //   4030: iconst_1
          //   4031: bipush 14
          //   4033: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   4036: aastore
          //   4037: dup
          //   4038: iconst_2
          //   4039: iconst_1
          //   4040: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   4043: aastore
          //   4044: invokevirtual 173	com/tencent/mm/plugin/webview/model/ax$d:z	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   4047: invokevirtual 176	com/tencent/mm/plugin/webview/model/ax$d:report	()V
          //   4050: aload_0
          //   4051: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   4054: astore_1
          //   4055: aload_1
          //   4056: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4059: getfield 59	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:AQP	Lcom/tencent/mm/plugin/webview/c/f;
          //   4062: ldc_w 572
          //   4065: iconst_1
          //   4066: invokevirtual 520	com/tencent/mm/plugin/webview/c/f:bZ	(Ljava/lang/String;Z)V
          //   4069: aload_1
          //   4070: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4073: getfield 59	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:AQP	Lcom/tencent/mm/plugin/webview/c/f;
          //   4076: astore_1
          //   4077: aload_1
          //   4078: getfield 64	com/tencent/mm/plugin/webview/c/f:yZR	Z
          //   4081: ifne +17 -> 4098
          //   4084: ldc 66
          //   4086: ldc_w 631
          //   4089: invokestatic 73	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   4092: ldc 27
          //   4094: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   4097: return
          //   4098: ldc_w 576
          //   4101: new 82	java/util/HashMap
          //   4104: dup
          //   4105: invokespecial 83	java/util/HashMap:<init>	()V
          //   4108: aload_1
          //   4109: getfield 101	com/tencent/mm/plugin/webview/c/f:ARm	Z
          //   4112: aload_1
          //   4113: getfield 104	com/tencent/mm/plugin/webview/c/f:ARn	Ljava/lang/String;
          //   4116: invokestatic 110	com/tencent/mm/plugin/webview/c/l$a:b	(Ljava/lang/String;Ljava/util/Map;ZLjava/lang/String;)Ljava/lang/String;
          //   4119: astore 4
          //   4121: aload_1
          //   4122: getfield 114	com/tencent/mm/plugin/webview/c/f:ARe	Lcom/tencent/mm/ui/widget/MMWebView;
          //   4125: new 116	java/lang/StringBuilder
          //   4128: dup
          //   4129: ldc 118
          //   4131: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   4134: aload 4
          //   4136: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   4139: ldc 127
          //   4141: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   4144: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   4147: aconst_null
          //   4148: invokevirtual 137	com/tencent/mm/ui/widget/MMWebView:evaluateJavascript	(Ljava/lang/String;Landroid/webkit/ValueCallback;)V
          //   4151: aload_1
          //   4152: getfield 577	com/tencent/mm/plugin/webview/c/f:kxf	Lcom/tencent/mm/plugin/webview/stub/e;
          //   4155: ldc_w 579
          //   4158: ldc_w 633
          //   4161: aload_1
          //   4162: getfield 585	com/tencent/mm/plugin/webview/c/f:ARo	I
          //   4165: invokeinterface 589 4 0
          //   4170: ldc 27
          //   4172: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   4175: return
          //   4176: astore_1
          //   4177: ldc 66
          //   4179: new 116	java/lang/StringBuilder
          //   4182: dup
          //   4183: ldc_w 591
          //   4186: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   4189: aload_1
          //   4190: invokevirtual 499	java/lang/Exception:getMessage	()Ljava/lang/String;
          //   4193: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   4196: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   4199: invokestatic 594	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
          //   4202: ldc 27
          //   4204: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   4207: return
          //   4208: aload_0
          //   4209: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   4212: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4215: getfield 158	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:AMJ	Lcom/tencent/mm/plugin/webview/model/ax;
          //   4218: invokevirtual 164	com/tencent/mm/plugin/webview/model/ax:emr	()Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   4221: iconst_3
          //   4222: anewarray 4	java/lang/Object
          //   4225: dup
          //   4226: iconst_0
          //   4227: aload_0
          //   4228: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   4231: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4234: invokevirtual 167	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bEx	()Ljava/lang/String;
          //   4237: aastore
          //   4238: dup
          //   4239: iconst_1
          //   4240: bipush 16
          //   4242: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   4245: aastore
          //   4246: dup
          //   4247: iconst_2
          //   4248: iconst_1
          //   4249: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   4252: aastore
          //   4253: invokevirtual 173	com/tencent/mm/plugin/webview/model/ax$d:z	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   4256: invokevirtual 176	com/tencent/mm/plugin/webview/model/ax$d:report	()V
          //   4259: aload_0
          //   4260: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   4263: invokestatic 636	com/tencent/mm/plugin/webview/ui/tools/i:d	(Lcom/tencent/mm/plugin/webview/ui/tools/i;)V
          //   4266: ldc 27
          //   4268: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   4271: return
          //   4272: aload_0
          //   4273: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   4276: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4279: getfield 158	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:AMJ	Lcom/tencent/mm/plugin/webview/model/ax;
          //   4282: invokevirtual 164	com/tencent/mm/plugin/webview/model/ax:emr	()Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   4285: iconst_3
          //   4286: anewarray 4	java/lang/Object
          //   4289: dup
          //   4290: iconst_0
          //   4291: aload_0
          //   4292: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   4295: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4298: invokevirtual 167	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bEx	()Ljava/lang/String;
          //   4301: aastore
          //   4302: dup
          //   4303: iconst_1
          //   4304: bipush 31
          //   4306: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   4309: aastore
          //   4310: dup
          //   4311: iconst_2
          //   4312: iconst_1
          //   4313: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   4316: aastore
          //   4317: invokevirtual 173	com/tencent/mm/plugin/webview/model/ax$d:z	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   4320: invokevirtual 176	com/tencent/mm/plugin/webview/model/ax$d:report	()V
          //   4323: aload_0
          //   4324: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   4327: invokevirtual 639	com/tencent/mm/plugin/webview/ui/tools/i:bAR	()V
          //   4330: ldc 27
          //   4332: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   4335: return
          //   4336: getstatic 340	com/tencent/mm/plugin/report/service/h:vKh	Lcom/tencent/mm/plugin/report/service/h;
          //   4339: ldc2_w 640
          //   4342: lconst_1
          //   4343: lconst_1
          //   4344: iconst_0
          //   4345: invokevirtual 348	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
          //   4348: aload_0
          //   4349: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   4352: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4355: getfield 158	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:AMJ	Lcom/tencent/mm/plugin/webview/model/ax;
          //   4358: invokevirtual 164	com/tencent/mm/plugin/webview/model/ax:emr	()Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   4361: iconst_3
          //   4362: anewarray 4	java/lang/Object
          //   4365: dup
          //   4366: iconst_0
          //   4367: aload_0
          //   4368: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   4371: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4374: invokevirtual 167	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bEx	()Ljava/lang/String;
          //   4377: aastore
          //   4378: dup
          //   4379: iconst_1
          //   4380: bipush 28
          //   4382: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   4385: aastore
          //   4386: dup
          //   4387: iconst_2
          //   4388: iconst_1
          //   4389: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   4392: aastore
          //   4393: invokevirtual 173	com/tencent/mm/plugin/webview/model/ax$d:z	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   4396: invokevirtual 176	com/tencent/mm/plugin/webview/model/ax$d:report	()V
          //   4399: aload_0
          //   4400: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   4403: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4406: getfield 645	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:BgT	Lcom/tencent/mm/plugin/webview/ui/tools/widget/WebViewSearchContentInputFooter;
          //   4409: invokevirtual 650	com/tencent/mm/plugin/webview/ui/tools/widget/WebViewSearchContentInputFooter:isShown	()Z
          //   4412: ifne +600 -> 5012
          //   4415: aload_0
          //   4416: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   4419: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4422: getfield 645	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:BgT	Lcom/tencent/mm/plugin/webview/ui/tools/widget/WebViewSearchContentInputFooter;
          //   4425: invokevirtual 653	com/tencent/mm/plugin/webview/ui/tools/widget/WebViewSearchContentInputFooter:reset	()V
          //   4428: aload_0
          //   4429: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   4432: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4435: getfield 645	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:BgT	Lcom/tencent/mm/plugin/webview/ui/tools/widget/WebViewSearchContentInputFooter;
          //   4438: invokevirtual 656	com/tencent/mm/plugin/webview/ui/tools/widget/WebViewSearchContentInputFooter:erq	()V
          //   4441: aload_0
          //   4442: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   4445: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4448: getfield 645	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:BgT	Lcom/tencent/mm/plugin/webview/ui/tools/widget/WebViewSearchContentInputFooter;
          //   4451: invokevirtual 659	com/tencent/mm/plugin/webview/ui/tools/widget/WebViewSearchContentInputFooter:show	()V
          //   4454: ldc 27
          //   4456: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   4459: return
          //   4460: aload_0
          //   4461: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   4464: astore_1
          //   4465: ldc 139
          //   4467: ldc_w 661
          //   4470: invokestatic 80	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
          //   4473: aload_1
          //   4474: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4477: getfield 59	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:AQP	Lcom/tencent/mm/plugin/webview/c/f;
          //   4480: ifnull +72 -> 4552
          //   4483: aload_1
          //   4484: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4487: getfield 59	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:AQP	Lcom/tencent/mm/plugin/webview/c/f;
          //   4490: astore_1
          //   4491: aload_1
          //   4492: getfield 64	com/tencent/mm/plugin/webview/c/f:yZR	Z
          //   4495: ifne +17 -> 4512
          //   4498: ldc 66
          //   4500: ldc_w 663
          //   4503: invokestatic 73	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   4506: ldc 27
          //   4508: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   4511: return
          //   4512: ldc 66
          //   4514: ldc_w 665
          //   4517: invokestatic 80	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
          //   4520: new 667	com/tencent/mm/plugin/webview/c/f$19
          //   4523: dup
          //   4524: aload_1
          //   4525: ldc_w 669
          //   4528: new 82	java/util/HashMap
          //   4531: dup
          //   4532: invokespecial 83	java/util/HashMap:<init>	()V
          //   4535: aload_1
          //   4536: getfield 101	com/tencent/mm/plugin/webview/c/f:ARm	Z
          //   4539: aload_1
          //   4540: getfield 104	com/tencent/mm/plugin/webview/c/f:ARn	Ljava/lang/String;
          //   4543: invokestatic 110	com/tencent/mm/plugin/webview/c/l$a:b	(Ljava/lang/String;Ljava/util/Map;ZLjava/lang/String;)Ljava/lang/String;
          //   4546: invokespecial 672	com/tencent/mm/plugin/webview/c/f$19:<init>	(Lcom/tencent/mm/plugin/webview/c/f;Ljava/lang/String;)V
          //   4549: invokestatic 678	com/tencent/mm/sdk/platformtools/aq:f	(Ljava/lang/Runnable;)V
          //   4552: ldc 27
          //   4554: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   4557: return
          //   4558: aload_0
          //   4559: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   4562: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4565: getfield 158	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:AMJ	Lcom/tencent/mm/plugin/webview/model/ax;
          //   4568: invokevirtual 164	com/tencent/mm/plugin/webview/model/ax:emr	()Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   4571: iconst_3
          //   4572: anewarray 4	java/lang/Object
          //   4575: dup
          //   4576: iconst_0
          //   4577: aload_0
          //   4578: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   4581: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4584: invokevirtual 167	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bEx	()Ljava/lang/String;
          //   4587: aastore
          //   4588: dup
          //   4589: iconst_1
          //   4590: bipush 33
          //   4592: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   4595: aastore
          //   4596: dup
          //   4597: iconst_2
          //   4598: iconst_1
          //   4599: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   4602: aastore
          //   4603: invokevirtual 173	com/tencent/mm/plugin/webview/model/ax$d:z	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   4606: invokevirtual 176	com/tencent/mm/plugin/webview/model/ax$d:report	()V
          //   4609: aload_0
          //   4610: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   4613: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4616: getfield 682	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Bie	Lcom/tencent/mm/plugin/webview/ui/tools/b/a;
          //   4619: iconst_1
          //   4620: invokevirtual 688	com/tencent/mm/plugin/webview/ui/tools/b/a:fE	(Z)V
          //   4623: ldc 27
          //   4625: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   4628: return
          //   4629: aload_0
          //   4630: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   4633: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4636: getfield 158	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:AMJ	Lcom/tencent/mm/plugin/webview/model/ax;
          //   4639: invokevirtual 164	com/tencent/mm/plugin/webview/model/ax:emr	()Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   4642: iconst_3
          //   4643: anewarray 4	java/lang/Object
          //   4646: dup
          //   4647: iconst_0
          //   4648: aload_0
          //   4649: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   4652: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4655: invokevirtual 167	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bEx	()Ljava/lang/String;
          //   4658: aastore
          //   4659: dup
          //   4660: iconst_1
          //   4661: bipush 34
          //   4663: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   4666: aastore
          //   4667: dup
          //   4668: iconst_2
          //   4669: iconst_1
          //   4670: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   4673: aastore
          //   4674: invokevirtual 173	com/tencent/mm/plugin/webview/model/ax$d:z	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   4677: invokevirtual 176	com/tencent/mm/plugin/webview/model/ax$d:report	()V
          //   4680: aload_0
          //   4681: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   4684: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4687: getfield 682	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Bie	Lcom/tencent/mm/plugin/webview/ui/tools/b/a;
          //   4690: iconst_0
          //   4691: invokevirtual 688	com/tencent/mm/plugin/webview/ui/tools/b/a:fE	(Z)V
          //   4694: ldc 27
          //   4696: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   4699: return
          //   4700: aload_0
          //   4701: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   4704: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4707: getfield 158	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:AMJ	Lcom/tencent/mm/plugin/webview/model/ax;
          //   4710: invokevirtual 164	com/tencent/mm/plugin/webview/model/ax:emr	()Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   4713: iconst_3
          //   4714: anewarray 4	java/lang/Object
          //   4717: dup
          //   4718: iconst_0
          //   4719: aload_0
          //   4720: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   4723: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4726: invokevirtual 167	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bEx	()Ljava/lang/String;
          //   4729: aastore
          //   4730: dup
          //   4731: iconst_1
          //   4732: bipush 99
          //   4734: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   4737: aastore
          //   4738: dup
          //   4739: iconst_2
          //   4740: iconst_1
          //   4741: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   4744: aastore
          //   4745: invokevirtual 173	com/tencent/mm/plugin/webview/model/ax$d:z	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ax$d;
          //   4748: invokevirtual 176	com/tencent/mm/plugin/webview/model/ax$d:report	()V
          //   4751: aload_0
          //   4752: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   4755: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4758: invokevirtual 691	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:eoL	()V
          //   4761: ldc 27
          //   4763: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   4766: return
          //   4767: aload_0
          //   4768: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   4771: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4774: getfield 59	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:AQP	Lcom/tencent/mm/plugin/webview/c/f;
          //   4777: ldc_w 669
          //   4780: aconst_null
          //   4781: new 693	org/json/JSONObject
          //   4784: dup
          //   4785: invokespecial 694	org/json/JSONObject:<init>	()V
          //   4788: invokevirtual 697	com/tencent/mm/plugin/webview/c/f:b	(Ljava/lang/String;Ljava/util/Map;Lorg/json/JSONObject;)V
          //   4791: ldc 27
          //   4793: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   4796: return
          //   4797: iconst_0
          //   4798: istore_2
          //   4799: goto -4155 -> 644
          //   4802: iconst_0
          //   4803: istore_2
          //   4804: goto -4146 -> 658
          //   4807: astore_1
          //   4808: iconst_0
          //   4809: istore_2
          //   4810: ldc 139
          //   4812: aload_1
          //   4813: ldc_w 699
          //   4816: iconst_0
          //   4817: anewarray 4	java/lang/Object
          //   4820: invokestatic 703	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
          //   4823: goto -4165 -> 658
          //   4826: aload_0
          //   4827: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   4830: astore_1
          //   4831: aload_1
          //   4832: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4835: getfield 59	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:AQP	Lcom/tencent/mm/plugin/webview/c/f;
          //   4838: ldc_w 572
          //   4841: iconst_0
          //   4842: invokevirtual 520	com/tencent/mm/plugin/webview/c/f:bZ	(Ljava/lang/String;Z)V
          //   4845: aload_1
          //   4846: invokevirtual 53	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4849: getfield 59	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:AQP	Lcom/tencent/mm/plugin/webview/c/f;
          //   4852: astore_1
          //   4853: aload_1
          //   4854: getfield 64	com/tencent/mm/plugin/webview/c/f:yZR	Z
          //   4857: ifne +17 -> 4874
          //   4860: ldc 66
          //   4862: ldc_w 705
          //   4865: invokestatic 73	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   4868: ldc 27
          //   4870: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   4873: return
          //   4874: new 82	java/util/HashMap
          //   4877: dup
          //   4878: invokespecial 83	java/util/HashMap:<init>	()V
          //   4881: astore 5
          //   4883: aload 5
          //   4885: ldc_w 579
          //   4888: ldc_w 707
          //   4891: invokevirtual 92	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
          //   4894: pop
          //   4895: ldc_w 576
          //   4898: aload 5
          //   4900: aload_1
          //   4901: getfield 101	com/tencent/mm/plugin/webview/c/f:ARm	Z
          //   4904: aload_1
          //   4905: getfield 104	com/tencent/mm/plugin/webview/c/f:ARn	Ljava/lang/String;
          //   4908: invokestatic 110	com/tencent/mm/plugin/webview/c/l$a:b	(Ljava/lang/String;Ljava/util/Map;ZLjava/lang/String;)Ljava/lang/String;
          //   4911: astore 5
          //   4913: aload_1
          //   4914: getfield 114	com/tencent/mm/plugin/webview/c/f:ARe	Lcom/tencent/mm/ui/widget/MMWebView;
          //   4917: new 116	java/lang/StringBuilder
          //   4920: dup
          //   4921: ldc 118
          //   4923: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   4926: aload 5
          //   4928: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   4931: ldc 127
          //   4933: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   4936: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   4939: aconst_null
          //   4940: invokevirtual 137	com/tencent/mm/ui/widget/MMWebView:evaluateJavascript	(Ljava/lang/String;Landroid/webkit/ValueCallback;)V
          //   4943: aload_1
          //   4944: getfield 577	com/tencent/mm/plugin/webview/c/f:kxf	Lcom/tencent/mm/plugin/webview/stub/e;
          //   4947: ldc_w 709
          //   4950: aload 4
          //   4952: aload_1
          //   4953: getfield 585	com/tencent/mm/plugin/webview/c/f:ARo	I
          //   4956: invokeinterface 589 4 0
          //   4961: aload_1
          //   4962: getfield 577	com/tencent/mm/plugin/webview/c/f:kxf	Lcom/tencent/mm/plugin/webview/stub/e;
          //   4965: ldc_w 579
          //   4968: ldc_w 707
          //   4971: aload_1
          //   4972: getfield 585	com/tencent/mm/plugin/webview/c/f:ARo	I
          //   4975: invokeinterface 589 4 0
          //   4980: ldc 27
          //   4982: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   4985: return
          //   4986: astore_1
          //   4987: ldc 66
          //   4989: new 116	java/lang/StringBuilder
          //   4992: dup
          //   4993: ldc_w 591
          //   4996: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   4999: aload_1
          //   5000: invokevirtual 499	java/lang/Exception:getMessage	()Ljava/lang/String;
          //   5003: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   5006: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   5009: invokestatic 594	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
          //   5012: ldc 27
          //   5014: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   5017: return
          //   5018: astore_1
          //   5019: goto -209 -> 4810
          //   5022: iconst_0
          //   5023: istore_2
          //   5024: goto -4366 -> 658
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	5027	0	this	14
          //   0	5027	1	paramAnonymousMenuItem	MenuItem
          //   0	5027	2	paramAnonymousInt	int
          //   650	4	3	i	int
          //   31	4920	4	localObject1	Object
          //   83	4844	5	localObject2	Object
          //   1968	49	6	locale	com.tencent.mm.plugin.webview.stub.e
          // Exception table:
          //   from	to	target	type
          //   2080	2094	2208	java/lang/Exception
          //   2094	2207	2208	java/lang/Exception
          //   2259	2273	2208	java/lang/Exception
          //   2016	2026	2235	java/lang/Exception
          //   3274	3293	3299	java/lang/Exception
          //   4151	4170	4176	java/lang/Exception
          //   588	626	4807	java/lang/Exception
          //   630	637	4807	java/lang/Exception
          //   4943	4980	4986	java/lang/Exception
          //   644	651	5018	java/lang/Exception
        }
      };
      this.lBF.HrY = ((n.d)localObject2);
      this.lBF.GHn = new e.b()
      {
        public final void onDismiss()
        {
          i.this.nmt = false;
        }
      };
      if (enA().kxg != null) {
        break label187;
      }
      ad.e("MicroMsg.WebViewMenuHelper", "get permission failed");
      AppMethodBeat.o(79887);
      return;
      bool = false;
      break;
    }
    label187:
    Object localObject3 = enA().AMZ.kxg.emR();
    this.lBF.HrX = new n.c()
    {
      /* Error */
      public final void onCreateMMMenu(l paramAnonymousl)
      {
        // Byte code:
        //   0: ldc 29
        //   2: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: getstatic 41	com/tencent/mm/plugin/report/service/h:vKh	Lcom/tencent/mm/plugin/report/service/h;
        //   8: ldc2_w 42
        //   11: lconst_0
        //   12: lconst_1
        //   13: iconst_0
        //   14: invokevirtual 47	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
        //   17: aload_1
        //   18: invokevirtual 52	com/tencent/mm/ui/base/l:clear	()V
        //   21: aload_0
        //   22: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   25: getfield 56	com/tencent/mm/plugin/webview/ui/tools/i:Bfq	Ljava/lang/Boolean;
        //   28: invokevirtual 62	java/lang/Boolean:booleanValue	()Z
        //   31: ifeq +90 -> 121
        //   34: aload_0
        //   35: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   38: getfield 66	com/tencent/mm/plugin/webview/ui/tools/i:Bfp	Ljava/util/ArrayList;
        //   41: invokevirtual 72	java/util/ArrayList:size	()I
        //   44: istore_3
        //   45: iconst_0
        //   46: istore_2
        //   47: iload_2
        //   48: iload_3
        //   49: if_icmpge +66 -> 115
        //   52: aload_0
        //   53: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   56: getfield 66	com/tencent/mm/plugin/webview/ui/tools/i:Bfp	Ljava/util/ArrayList;
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
        //   91: putfield 96	com/tencent/mm/ui/base/m:FYy	Landroid/view/ContextMenu$ContextMenuInfo;
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
        //   122: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   125: iconst_1
        //   126: invokestatic 109	com/tencent/mm/plugin/webview/ui/tools/i:c	(Lcom/tencent/mm/plugin/webview/ui/tools/i;I)Z
        //   129: ifeq +70 -> 199
        //   132: aload_0
        //   133: getfield 21	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfu	Lcom/tencent/mm/protocal/JsapiPermissionWrapper;
        //   136: bipush 21
        //   138: invokestatic 113	com/tencent/mm/plugin/webview/ui/tools/i:a	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
        //   141: ifeq +58 -> 199
        //   144: aload_0
        //   145: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   148: iconst_1
        //   149: invokevirtual 117	com/tencent/mm/plugin/webview/ui/tools/i:Tx	(I)Z
        //   152: ifeq +47 -> 199
        //   155: aload_1
        //   156: iconst_1
        //   157: aload_0
        //   158: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   161: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   164: ldc 122
        //   166: invokevirtual 128	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
        //   169: ldc 129
        //   171: aload_0
        //   172: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   175: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   178: invokevirtual 133	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getResources	()Landroid/content/res/Resources;
        //   181: ldc 134
        //   183: invokevirtual 140	android/content/res/Resources:getColor	(I)I
        //   186: aload_0
        //   187: getfield 21	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfu	Lcom/tencent/mm/protocal/JsapiPermissionWrapper;
        //   190: bipush 21
        //   192: invokestatic 143	com/tencent/mm/plugin/webview/ui/tools/i:b	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
        //   195: invokevirtual 146	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;IIZ)Landroid/view/MenuItem;
        //   198: pop
        //   199: aload_0
        //   200: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   203: iconst_2
        //   204: invokestatic 109	com/tencent/mm/plugin/webview/ui/tools/i:c	(Lcom/tencent/mm/plugin/webview/ui/tools/i;I)Z
        //   207: ifeq +56 -> 263
        //   210: aload_0
        //   211: getfield 21	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfu	Lcom/tencent/mm/protocal/JsapiPermissionWrapper;
        //   214: bipush 23
        //   216: invokestatic 113	com/tencent/mm/plugin/webview/ui/tools/i:a	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
        //   219: ifeq +44 -> 263
        //   222: aload_0
        //   223: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   226: iconst_2
        //   227: invokevirtual 117	com/tencent/mm/plugin/webview/ui/tools/i:Tx	(I)Z
        //   230: ifeq +33 -> 263
        //   233: aload_1
        //   234: iconst_2
        //   235: aload_0
        //   236: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   239: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   242: ldc 147
        //   244: invokevirtual 128	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
        //   247: ldc 148
        //   249: iconst_0
        //   250: aload_0
        //   251: getfield 21	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfu	Lcom/tencent/mm/protocal/JsapiPermissionWrapper;
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
        //   277: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   280: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   283: getfield 157	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:AMZ	Lcom/tencent/mm/plugin/webview/core/h;
        //   286: invokevirtual 162	com/tencent/mm/plugin/webview/core/h:eiZ	()I
        //   289: invokevirtual 166	android/os/Bundle:putInt	(Ljava/lang/String;I)V
        //   292: aload 8
        //   294: ldc 168
        //   296: aload_0
        //   297: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   300: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   303: getfield 157	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:AMZ	Lcom/tencent/mm/plugin/webview/core/h;
        //   306: getfield 174	com/tencent/mm/plugin/webview/core/BaseWebViewController:nhy	Lcom/tencent/mm/ui/widget/MMWebView;
        //   309: invokevirtual 180	com/tencent/mm/ui/widget/MMWebView:getUrl	()Ljava/lang/String;
        //   312: invokevirtual 184	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
        //   315: aload_0
        //   316: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   319: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   322: getfield 157	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:AMZ	Lcom/tencent/mm/plugin/webview/core/h;
        //   325: getfield 188	com/tencent/mm/plugin/webview/core/h:kxf	Lcom/tencent/mm/plugin/webview/stub/e;
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
        //   374: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   377: bipush 38
        //   379: invokestatic 109	com/tencent/mm/plugin/webview/ui/tools/i:c	(Lcom/tencent/mm/plugin/webview/ui/tools/i;I)Z
        //   382: ifeq +1531 -> 1913
        //   385: aload_0
        //   386: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   389: bipush 38
        //   391: invokevirtual 117	com/tencent/mm/plugin/webview/ui/tools/i:Tx	(I)Z
        //   394: ifeq +1519 -> 1913
        //   397: iload_2
        //   398: ifne +1515 -> 1913
        //   401: aload_1
        //   402: bipush 38
        //   404: aload_0
        //   405: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   408: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   411: ldc 203
        //   413: invokevirtual 128	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
        //   416: ldc 204
        //   418: aload_0
        //   419: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   422: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   425: invokevirtual 133	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getResources	()Landroid/content/res/Resources;
        //   428: ldc 205
        //   430: invokevirtual 140	android/content/res/Resources:getColor	(I)I
        //   433: invokevirtual 208	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;II)Landroid/view/MenuItem;
        //   436: pop
        //   437: aload_0
        //   438: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   441: iconst_3
        //   442: invokestatic 109	com/tencent/mm/plugin/webview/ui/tools/i:c	(Lcom/tencent/mm/plugin/webview/ui/tools/i;I)Z
        //   445: ifeq +139 -> 584
        //   448: aload_0
        //   449: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   452: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   455: getfield 212	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Bhf	Z
        //   458: ifeq +61 -> 519
        //   461: aload_0
        //   462: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   465: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   468: invokevirtual 215	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:eox	()Ljava/lang/String;
        //   471: invokestatic 221	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
        //   474: ifne +110 -> 584
        //   477: aload_0
        //   478: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   481: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   484: getfield 224	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:BiA	Ljava/lang/String;
        //   487: invokestatic 221	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
        //   490: ifne +94 -> 584
        //   493: aload_0
        //   494: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   497: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   500: invokevirtual 215	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:eox	()Ljava/lang/String;
        //   503: aload_0
        //   504: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   507: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   510: getfield 224	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:BiA	Ljava/lang/String;
        //   513: invokevirtual 229	java/lang/String:startsWith	(Ljava/lang/String;)Z
        //   516: ifne +68 -> 584
        //   519: aload_0
        //   520: getfield 21	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfu	Lcom/tencent/mm/protocal/JsapiPermissionWrapper;
        //   523: sipush 323
        //   526: invokestatic 113	com/tencent/mm/plugin/webview/ui/tools/i:a	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
        //   529: ifeq +55 -> 584
        //   532: aload_0
        //   533: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   536: invokevirtual 232	com/tencent/mm/plugin/webview/ui/tools/i:enZ	()Z
        //   539: ifeq +45 -> 584
        //   542: aload_0
        //   543: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   546: iconst_3
        //   547: invokevirtual 117	com/tencent/mm/plugin/webview/ui/tools/i:Tx	(I)Z
        //   550: ifeq +34 -> 584
        //   553: aload_1
        //   554: iconst_3
        //   555: aload_0
        //   556: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   559: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   562: ldc 233
        //   564: invokevirtual 128	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
        //   567: ldc 234
        //   569: iconst_0
        //   570: aload_0
        //   571: getfield 21	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfu	Lcom/tencent/mm/protocal/JsapiPermissionWrapper;
        //   574: sipush 323
        //   577: invokestatic 143	com/tencent/mm/plugin/webview/ui/tools/i:b	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
        //   580: invokevirtual 146	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;IIZ)Landroid/view/MenuItem;
        //   583: pop
        //   584: aload_0
        //   585: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   588: bipush 25
        //   590: invokestatic 109	com/tencent/mm/plugin/webview/ui/tools/i:c	(Lcom/tencent/mm/plugin/webview/ui/tools/i;I)Z
        //   593: ifeq +104 -> 697
        //   596: aload_0
        //   597: getfield 21	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfu	Lcom/tencent/mm/protocal/JsapiPermissionWrapper;
        //   600: sipush 322
        //   603: invokestatic 113	com/tencent/mm/plugin/webview/ui/tools/i:a	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
        //   606: ifeq +91 -> 697
        //   609: aload_0
        //   610: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   613: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   616: invokestatic 240	com/tencent/wework/api/WWAPIFactory:kS	(Landroid/content/Context;)Lcom/tencent/wework/api/IWWAPI;
        //   619: invokeinterface 245 1 0
        //   624: ifeq +73 -> 697
        //   627: aload_0
        //   628: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   631: bipush 25
        //   633: invokevirtual 117	com/tencent/mm/plugin/webview/ui/tools/i:Tx	(I)Z
        //   636: ifeq +61 -> 697
        //   639: aload_0
        //   640: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   643: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   646: invokestatic 240	com/tencent/wework/api/WWAPIFactory:kS	(Landroid/content/Context;)Lcom/tencent/wework/api/IWWAPI;
        //   649: invokeinterface 248 1 0
        //   654: astore 8
        //   656: aload_1
        //   657: bipush 25
        //   659: aload_0
        //   660: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   663: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
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
        //   684: getfield 21	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfu	Lcom/tencent/mm/protocal/JsapiPermissionWrapper;
        //   687: sipush 322
        //   690: invokestatic 143	com/tencent/mm/plugin/webview/ui/tools/i:b	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
        //   693: invokevirtual 146	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;IIZ)Landroid/view/MenuItem;
        //   696: pop
        //   697: aload_0
        //   698: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   701: bipush 33
        //   703: invokestatic 109	com/tencent/mm/plugin/webview/ui/tools/i:c	(Lcom/tencent/mm/plugin/webview/ui/tools/i;I)Z
        //   706: ifeq +90 -> 796
        //   709: aload_0
        //   710: getfield 21	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfu	Lcom/tencent/mm/protocal/JsapiPermissionWrapper;
        //   713: bipush 31
        //   715: invokestatic 113	com/tencent/mm/plugin/webview/ui/tools/i:a	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
        //   718: ifeq +78 -> 796
        //   721: aload_0
        //   722: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   725: bipush 30
        //   727: invokevirtual 117	com/tencent/mm/plugin/webview/ui/tools/i:Tx	(I)Z
        //   730: ifeq +66 -> 796
        //   733: aload_0
        //   734: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   737: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   740: getfield 157	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:AMZ	Lcom/tencent/mm/plugin/webview/core/h;
        //   743: getfield 188	com/tencent/mm/plugin/webview/core/h:kxf	Lcom/tencent/mm/plugin/webview/stub/e;
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
        //   767: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   770: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   773: ldc_w 260
        //   776: invokevirtual 128	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
        //   779: ldc_w 261
        //   782: iconst_0
        //   783: aload_0
        //   784: getfield 21	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfu	Lcom/tencent/mm/protocal/JsapiPermissionWrapper;
        //   787: bipush 31
        //   789: invokestatic 143	com/tencent/mm/plugin/webview/ui/tools/i:b	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
        //   792: invokevirtual 146	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;IIZ)Landroid/view/MenuItem;
        //   795: pop
        //   796: aload_0
        //   797: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   800: bipush 26
        //   802: invokestatic 109	com/tencent/mm/plugin/webview/ui/tools/i:c	(Lcom/tencent/mm/plugin/webview/ui/tools/i;I)Z
        //   805: ifeq +88 -> 893
        //   808: aload_0
        //   809: getfield 21	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfu	Lcom/tencent/mm/protocal/JsapiPermissionWrapper;
        //   812: sipush 278
        //   815: invokestatic 113	com/tencent/mm/plugin/webview/ui/tools/i:a	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
        //   818: ifeq +75 -> 893
        //   821: aload_0
        //   822: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   825: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   828: aload_0
        //   829: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   832: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   835: getfield 262	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:nhy	Lcom/tencent/mm/ui/widget/MMWebView;
        //   838: invokevirtual 180	com/tencent/mm/ui/widget/MMWebView:getUrl	()Ljava/lang/String;
        //   841: invokestatic 268	com/tencent/mm/plugin/webview/stub/a:bw	(Landroid/content/Context;Ljava/lang/String;)Z
        //   844: ifeq +49 -> 893
        //   847: aload_0
        //   848: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   851: bipush 26
        //   853: invokevirtual 117	com/tencent/mm/plugin/webview/ui/tools/i:Tx	(I)Z
        //   856: ifeq +37 -> 893
        //   859: aload_1
        //   860: bipush 26
        //   862: aload_0
        //   863: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   866: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   869: ldc_w 269
        //   872: invokevirtual 128	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
        //   875: ldc_w 270
        //   878: iconst_0
        //   879: aload_0
        //   880: getfield 21	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfu	Lcom/tencent/mm/protocal/JsapiPermissionWrapper;
        //   883: sipush 278
        //   886: invokestatic 143	com/tencent/mm/plugin/webview/ui/tools/i:b	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
        //   889: invokevirtual 146	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;IIZ)Landroid/view/MenuItem;
        //   892: pop
        //   893: aload_0
        //   894: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   897: bipush 7
        //   899: invokestatic 109	com/tencent/mm/plugin/webview/ui/tools/i:c	(Lcom/tencent/mm/plugin/webview/ui/tools/i;I)Z
        //   902: ifeq +75 -> 977
        //   905: aload_0
        //   906: getfield 21	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfu	Lcom/tencent/mm/protocal/JsapiPermissionWrapper;
        //   909: bipush 45
        //   911: invokestatic 113	com/tencent/mm/plugin/webview/ui/tools/i:a	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
        //   914: ifeq +63 -> 977
        //   917: aload_0
        //   918: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   921: bipush 7
        //   923: invokevirtual 117	com/tencent/mm/plugin/webview/ui/tools/i:Tx	(I)Z
        //   926: ifeq +51 -> 977
        //   929: aload_1
        //   930: bipush 7
        //   932: aload_0
        //   933: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   936: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   939: ldc_w 271
        //   942: invokevirtual 128	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
        //   945: ldc_w 272
        //   948: aload_0
        //   949: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   952: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   955: invokevirtual 133	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getResources	()Landroid/content/res/Resources;
        //   958: ldc_w 273
        //   961: invokevirtual 140	android/content/res/Resources:getColor	(I)I
        //   964: aload_0
        //   965: getfield 21	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfu	Lcom/tencent/mm/protocal/JsapiPermissionWrapper;
        //   968: bipush 45
        //   970: invokestatic 143	com/tencent/mm/plugin/webview/ui/tools/i:b	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
        //   973: invokevirtual 146	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;IIZ)Landroid/view/MenuItem;
        //   976: pop
        //   977: aload_0
        //   978: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   981: invokevirtual 276	com/tencent/mm/plugin/webview/ui/tools/a:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   984: invokevirtual 280	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
        //   987: ldc_w 282
        //   990: invokevirtual 288	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
        //   993: astore 8
        //   995: aload_0
        //   996: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   999: invokevirtual 276	com/tencent/mm/plugin/webview/ui/tools/a:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   1002: invokevirtual 280	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
        //   1005: ldc_w 290
        //   1008: ldc2_w 291
        //   1011: invokevirtual 296	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
        //   1014: lstore 5
        //   1016: aload_0
        //   1017: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1020: bipush 23
        //   1022: invokestatic 109	com/tencent/mm/plugin/webview/ui/tools/i:c	(Lcom/tencent/mm/plugin/webview/ui/tools/i;I)Z
        //   1025: ifeq +51 -> 1076
        //   1028: aload_0
        //   1029: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1032: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   1035: getfield 157	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:AMZ	Lcom/tencent/mm/plugin/webview/core/h;
        //   1038: getfield 188	com/tencent/mm/plugin/webview/core/h:kxf	Lcom/tencent/mm/plugin/webview/stub/e;
        //   1041: lload 5
        //   1043: aload 8
        //   1045: invokeinterface 300 4 0
        //   1050: ifeq +26 -> 1076
        //   1053: aload_1
        //   1054: bipush 23
        //   1056: aload_0
        //   1057: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1060: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   1063: ldc_w 301
        //   1066: invokevirtual 128	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
        //   1069: ldc_w 302
        //   1072: invokevirtual 305	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;I)Landroid/view/MenuItem;
        //   1075: pop
        //   1076: aload_0
        //   1077: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1080: bipush 24
        //   1082: invokestatic 109	com/tencent/mm/plugin/webview/ui/tools/i:c	(Lcom/tencent/mm/plugin/webview/ui/tools/i;I)Z
        //   1085: ifeq +139 -> 1224
        //   1088: aload_0
        //   1089: getfield 21	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfu	Lcom/tencent/mm/protocal/JsapiPermissionWrapper;
        //   1092: bipush 43
        //   1094: invokestatic 113	com/tencent/mm/plugin/webview/ui/tools/i:a	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
        //   1097: ifeq +127 -> 1224
        //   1100: aload_0
        //   1101: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1104: bipush 24
        //   1106: invokevirtual 117	com/tencent/mm/plugin/webview/ui/tools/i:Tx	(I)Z
        //   1109: ifeq +115 -> 1224
        //   1112: aload_0
        //   1113: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1116: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
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
        //   1149: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1152: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   1155: getfield 157	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:AMZ	Lcom/tencent/mm/plugin/webview/core/h;
        //   1158: getfield 188	com/tencent/mm/plugin/webview/core/h:kxf	Lcom/tencent/mm/plugin/webview/stub/e;
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
        //   1196: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1199: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   1202: ldc_w 319
        //   1205: invokevirtual 128	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
        //   1208: ldc_w 320
        //   1211: aload_0
        //   1212: getfield 21	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfu	Lcom/tencent/mm/protocal/JsapiPermissionWrapper;
        //   1215: bipush 43
        //   1217: invokestatic 143	com/tencent/mm/plugin/webview/ui/tools/i:b	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
        //   1220: invokevirtual 323	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;IZ)Landroid/view/MenuItem;
        //   1223: pop
        //   1224: aload_0
        //   1225: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1228: bipush 8
        //   1230: invokestatic 109	com/tencent/mm/plugin/webview/ui/tools/i:c	(Lcom/tencent/mm/plugin/webview/ui/tools/i;I)Z
        //   1233: ifeq +110 -> 1343
        //   1236: aload_0
        //   1237: getfield 21	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfu	Lcom/tencent/mm/protocal/JsapiPermissionWrapper;
        //   1240: bipush 36
        //   1242: invokestatic 113	com/tencent/mm/plugin/webview/ui/tools/i:a	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
        //   1245: ifeq +98 -> 1343
        //   1248: aload_0
        //   1249: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1252: bipush 8
        //   1254: invokevirtual 117	com/tencent/mm/plugin/webview/ui/tools/i:Tx	(I)Z
        //   1257: ifeq +86 -> 1343
        //   1260: aconst_null
        //   1261: astore 8
        //   1263: aload_0
        //   1264: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1267: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   1270: getfield 157	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:AMZ	Lcom/tencent/mm/plugin/webview/core/h;
        //   1273: getfield 188	com/tencent/mm/plugin/webview/core/h:kxf	Lcom/tencent/mm/plugin/webview/stub/e;
        //   1276: invokeinterface 326 1 0
        //   1281: astore 9
        //   1283: aload 9
        //   1285: astore 8
        //   1287: aload 8
        //   1289: invokestatic 221	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
        //   1292: ifne +754 -> 2046
        //   1295: aload_1
        //   1296: bipush 8
        //   1298: aload_0
        //   1299: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1302: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   1305: ldc_w 327
        //   1308: invokevirtual 128	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
        //   1311: ldc_w 328
        //   1314: aload_0
        //   1315: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1318: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   1321: invokevirtual 133	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getResources	()Landroid/content/res/Resources;
        //   1324: ldc_w 273
        //   1327: invokevirtual 140	android/content/res/Resources:getColor	(I)I
        //   1330: aload_0
        //   1331: getfield 21	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfu	Lcom/tencent/mm/protocal/JsapiPermissionWrapper;
        //   1334: bipush 36
        //   1336: invokestatic 143	com/tencent/mm/plugin/webview/ui/tools/i:b	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
        //   1339: invokevirtual 146	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;IIZ)Landroid/view/MenuItem;
        //   1342: pop
        //   1343: aload_0
        //   1344: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1347: bipush 20
        //   1349: invokestatic 109	com/tencent/mm/plugin/webview/ui/tools/i:c	(Lcom/tencent/mm/plugin/webview/ui/tools/i;I)Z
        //   1352: ifeq +73 -> 1425
        //   1355: aload_0
        //   1356: getfield 21	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfu	Lcom/tencent/mm/protocal/JsapiPermissionWrapper;
        //   1359: bipush 91
        //   1361: invokestatic 113	com/tencent/mm/plugin/webview/ui/tools/i:a	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
        //   1364: ifeq +61 -> 1425
        //   1367: aload_0
        //   1368: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1371: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   1374: invokestatic 332	com/tencent/mm/plugin/webview/stub/a:gE	(Landroid/content/Context;)Z
        //   1377: ifeq +48 -> 1425
        //   1380: aload_0
        //   1381: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1384: bipush 20
        //   1386: invokevirtual 117	com/tencent/mm/plugin/webview/ui/tools/i:Tx	(I)Z
        //   1389: ifeq +36 -> 1425
        //   1392: aload_1
        //   1393: bipush 20
        //   1395: aload_0
        //   1396: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1399: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   1402: ldc_w 333
        //   1405: invokevirtual 128	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
        //   1408: ldc_w 334
        //   1411: iconst_0
        //   1412: aload_0
        //   1413: getfield 21	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfu	Lcom/tencent/mm/protocal/JsapiPermissionWrapper;
        //   1416: bipush 91
        //   1418: invokestatic 143	com/tencent/mm/plugin/webview/ui/tools/i:b	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
        //   1421: invokevirtual 146	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;IIZ)Landroid/view/MenuItem;
        //   1424: pop
        //   1425: aload_0
        //   1426: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1429: bipush 22
        //   1431: invokestatic 109	com/tencent/mm/plugin/webview/ui/tools/i:c	(Lcom/tencent/mm/plugin/webview/ui/tools/i;I)Z
        //   1434: ifeq +75 -> 1509
        //   1437: aload_0
        //   1438: getfield 21	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfu	Lcom/tencent/mm/protocal/JsapiPermissionWrapper;
        //   1441: sipush 133
        //   1444: invokestatic 113	com/tencent/mm/plugin/webview/ui/tools/i:a	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
        //   1447: ifeq +62 -> 1509
        //   1450: aload_0
        //   1451: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1454: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   1457: invokestatic 332	com/tencent/mm/plugin/webview/stub/a:gE	(Landroid/content/Context;)Z
        //   1460: ifeq +49 -> 1509
        //   1463: aload_0
        //   1464: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1467: bipush 22
        //   1469: invokevirtual 117	com/tencent/mm/plugin/webview/ui/tools/i:Tx	(I)Z
        //   1472: ifeq +37 -> 1509
        //   1475: aload_1
        //   1476: bipush 22
        //   1478: aload_0
        //   1479: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1482: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   1485: ldc_w 335
        //   1488: invokevirtual 128	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
        //   1491: ldc_w 336
        //   1494: iconst_0
        //   1495: aload_0
        //   1496: getfield 21	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfu	Lcom/tencent/mm/protocal/JsapiPermissionWrapper;
        //   1499: sipush 133
        //   1502: invokestatic 143	com/tencent/mm/plugin/webview/ui/tools/i:b	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
        //   1505: invokevirtual 146	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;IIZ)Landroid/view/MenuItem;
        //   1508: pop
        //   1509: aload_0
        //   1510: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1513: iconst_0
        //   1514: invokestatic 109	com/tencent/mm/plugin/webview/ui/tools/i:c	(Lcom/tencent/mm/plugin/webview/ui/tools/i;I)Z
        //   1517: ifeq +133 -> 1650
        //   1520: aload_0
        //   1521: getfield 21	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfu	Lcom/tencent/mm/protocal/JsapiPermissionWrapper;
        //   1524: bipush 43
        //   1526: invokestatic 113	com/tencent/mm/plugin/webview/ui/tools/i:a	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
        //   1529: ifeq +121 -> 1650
        //   1532: aload_0
        //   1533: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1536: iconst_0
        //   1537: invokevirtual 117	com/tencent/mm/plugin/webview/ui/tools/i:Tx	(I)Z
        //   1540: ifeq +110 -> 1650
        //   1543: aload_0
        //   1544: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1547: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   1550: getfield 157	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:AMZ	Lcom/tencent/mm/plugin/webview/core/h;
        //   1553: getfield 188	com/tencent/mm/plugin/webview/core/h:kxf	Lcom/tencent/mm/plugin/webview/stub/e;
        //   1556: invokeinterface 339 1 0
        //   1561: ifeq +89 -> 1650
        //   1564: aload_0
        //   1565: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1568: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   1571: getfield 157	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:AMZ	Lcom/tencent/mm/plugin/webview/core/h;
        //   1574: getfield 188	com/tencent/mm/plugin/webview/core/h:kxf	Lcom/tencent/mm/plugin/webview/stub/e;
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
        //   1647: invokestatic 386	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
        //   1650: aload_0
        //   1651: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1654: bipush 27
        //   1656: invokestatic 109	com/tencent/mm/plugin/webview/ui/tools/i:c	(Lcom/tencent/mm/plugin/webview/ui/tools/i;I)Z
        //   1659: ifeq +55 -> 1714
        //   1662: aload_0
        //   1663: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1666: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   1669: getfield 390	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:BgO	Lcom/tencent/mm/plugin/webview/ui/tools/widget/MovingImageButton;
        //   1672: ifnull +42 -> 1714
        //   1675: aload_0
        //   1676: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1679: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   1682: getfield 390	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:BgO	Lcom/tencent/mm/plugin/webview/ui/tools/widget/MovingImageButton;
        //   1685: invokevirtual 395	com/tencent/mm/plugin/webview/ui/tools/widget/MovingImageButton:getVisibility	()I
        //   1688: ifne +26 -> 1714
        //   1691: aload_1
        //   1692: bipush 27
        //   1694: aload_0
        //   1695: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1698: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   1701: ldc_w 396
        //   1704: invokevirtual 128	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
        //   1707: ldc_w 397
        //   1710: invokevirtual 305	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;I)Landroid/view/MenuItem;
        //   1713: pop
        //   1714: aload_0
        //   1715: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1718: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   1721: aload_0
        //   1722: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1725: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   1728: invokevirtual 215	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:eox	()Ljava/lang/String;
        //   1731: invokevirtual 400	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:avx	(Ljava/lang/String;)Ljava/lang/String;
        //   1734: astore 8
        //   1736: aload_0
        //   1737: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1740: invokevirtual 276	com/tencent/mm/plugin/webview/ui/tools/a:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   1743: invokevirtual 280	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
        //   1746: ldc_w 402
        //   1749: invokevirtual 288	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
        //   1752: astore 9
        //   1754: aload_0
        //   1755: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1758: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   1761: getfield 405	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Bhh	Z
        //   1764: ifne +89 -> 1853
        //   1767: aload 8
        //   1769: invokestatic 221	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
        //   1772: ifne +81 -> 1853
        //   1775: aload 9
        //   1777: invokestatic 221	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
        //   1780: ifne +73 -> 1853
        //   1783: aload_0
        //   1784: getfield 21	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfu	Lcom/tencent/mm/protocal/JsapiPermissionWrapper;
        //   1787: sipush 255
        //   1790: invokestatic 113	com/tencent/mm/plugin/webview/ui/tools/i:a	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
        //   1793: ifeq +60 -> 1853
        //   1796: aload_0
        //   1797: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1800: bipush 29
        //   1802: invokevirtual 117	com/tencent/mm/plugin/webview/ui/tools/i:Tx	(I)Z
        //   1805: ifeq +48 -> 1853
        //   1808: aload_0
        //   1809: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1812: bipush 29
        //   1814: invokestatic 109	com/tencent/mm/plugin/webview/ui/tools/i:c	(Lcom/tencent/mm/plugin/webview/ui/tools/i;I)Z
        //   1817: ifeq +36 -> 1853
        //   1820: aload_1
        //   1821: bipush 29
        //   1823: aload_0
        //   1824: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1827: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   1830: ldc_w 406
        //   1833: invokevirtual 128	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
        //   1836: ldc_w 407
        //   1839: aload_0
        //   1840: getfield 21	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfu	Lcom/tencent/mm/protocal/JsapiPermissionWrapper;
        //   1843: sipush 255
        //   1846: invokestatic 143	com/tencent/mm/plugin/webview/ui/tools/i:b	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
        //   1849: invokevirtual 323	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;IZ)Landroid/view/MenuItem;
        //   1852: pop
        //   1853: aload_0
        //   1854: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1857: iconst_1
        //   1858: putfield 410	com/tencent/mm/plugin/webview/ui/tools/i:nmt	Z
        //   1861: aload_0
        //   1862: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1865: getfield 414	com/tencent/mm/plugin/webview/ui/tools/i:lBF	Lcom/tencent/mm/ui/widget/a/e;
        //   1868: invokevirtual 419	com/tencent/mm/ui/widget/a/e:ffw	()V
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
        //   1905: invokestatic 424	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   1908: iconst_m1
        //   1909: istore_2
        //   1910: goto -1542 -> 368
        //   1913: aload_0
        //   1914: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1917: bipush 39
        //   1919: invokevirtual 117	com/tencent/mm/plugin/webview/ui/tools/i:Tx	(I)Z
        //   1922: ifeq -1485 -> 437
        //   1925: iload_2
        //   1926: iconst_1
        //   1927: if_icmpne -1490 -> 437
        //   1930: aload_1
        //   1931: bipush 39
        //   1933: aload_0
        //   1934: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1937: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   1940: ldc_w 425
        //   1943: invokevirtual 128	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
        //   1946: ldc_w 426
        //   1949: aload_0
        //   1950: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1953: invokevirtual 121	com/tencent/mm/plugin/webview/ui/tools/i:enA	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
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
        //   1985: invokestatic 432	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   1988: goto -1192 -> 796
        //   1991: astore 8
        //   1993: ldc_w 364
        //   1996: aload 8
        //   1998: ldc_w 428
        //   2001: iconst_0
        //   2002: anewarray 4	java/lang/Object
        //   2005: invokestatic 432	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
        //   2037: invokestatic 386	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
        //   2040: iconst_0
        //   2041: istore 7
        //   2043: goto -856 -> 1187
        //   2046: ldc_w 364
        //   2049: ldc_w 434
        //   2052: invokestatic 436	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   2055: goto -712 -> 1343
        //   2058: aload_0
        //   2059: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$16:Bfr	Lcom/tencent/mm/plugin/webview/ui/tools/i;
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
    Object localObject4 = enA().ejo();
    enA();
    Object localObject1 = n.ayb((String)localObject4);
    boolean bool = ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).isMpUrl((String)localObject4);
    this.lBF.HEP = new n.c()
    {
      public final void onCreateMMMenu(l paramAnonymousl)
      {
        AppMethodBeat.i(79873);
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(480L, 0L, 1L, false);
        paramAnonymousl.clear();
        if (i.this.Bfq.booleanValue())
        {
          AppMethodBeat.o(79873);
          return;
        }
        if ((i.this.enA().Bie != null) && (i.this.enA().Bie.BiO.ekY()))
        {
          if ((!i.c(i.this, 35)) || (!i.this.Tx(35)) || (i.this.enA().Bie.bzs())) {
            break label279;
          }
          paramAnonymousl.a(35, i.this.enA().getString(2131762178), 2131690574);
        }
        for (;;)
        {
          switch (i.this.enA().Bil)
          {
          }
          try
          {
            label168:
            LinkedList localLinkedList = i.this.enA().eoM();
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
                if ("index".equals(bt.nullAsNil(locala.id))) {
                  localm = (m)paramAnonymousl.a(15, i.this.enA().getString(2131766098), 2131689814);
                }
                for (;;)
                {
                  if (localm != null) {
                    localm.jBp = locala.url;
                  }
                  i += 1;
                  break label187;
                  if ((!i.this.Tx(36)) || (!i.this.enA().Bie.bzs())) {
                    break;
                  }
                  paramAnonymousl.a(36, i.this.enA().getString(2131762168), 2131690573);
                  break;
                  paramAnonymousl.a(40, i.this.enA().getString(2131766150), 2131690335);
                  break label168;
                  paramAnonymousl.a(41, i.this.enA().getString(2131766148), 2131690334);
                  break label168;
                  paramAnonymousl.a(42, i.this.enA().getString(2131766149), 2131690335);
                  break label168;
                  if ("categories".equals(bt.nullAsNil(locala.id))) {
                    localm = (m)paramAnonymousl.a(16, i.this.enA().getString(2131766097), 2131689813);
                  } else if ("cart".equals(bt.nullAsNil(locala.id))) {
                    localm = (m)paramAnonymousl.a(17, i.this.enA().getString(2131766096), 2131689812);
                  } else if ("profile".equals(bt.nullAsNil(locala.id))) {
                    localm = (m)paramAnonymousl.a(18, i.this.enA().getString(2131766100), 2131689820);
                  } else if ("member".equals(bt.nullAsNil(locala.id))) {
                    localm = (m)paramAnonymousl.a(19, i.this.enA().getString(2131766099), 2131689815);
                  }
                }
              }
            }
            try
            {
              bool1 = i.this.enA().AMZ.kxf.sE((String)localObject);
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
                  i.this.enA().AMZ.kxf.axD((String)localObject);
                  if (i.this.Tx(10)) {
                    paramAnonymousl.a(10, i.this.enA().getString(2131756596), 2131690646);
                  }
                  if ((i.c(i.this, 6)) && (i.a(this.Bfu, 44)) && (i.this.Tx(6))) {
                    paramAnonymousl.a(6, i.this.enA().getString(2131766247), 2131690588, i.b(this.Bfu, 44));
                  }
                  if ((i.c(i.this, 28)) && (i.this.Tx(28))) {
                    paramAnonymousl.a(28, i.this.enA().getString(2131766077), 2131690644);
                  }
                  if (i.c(i.this, 31)) {
                    paramAnonymousl.a(31, i.this.enA().getString(2131766282), 2131689494);
                  }
                  if ((this.Bfu.Cqi != null) && (i.this.enA().Bhf) && (!bt.isNullOrNil(i.this.enA().eox())) && (!bt.isNullOrNil(i.this.enA().BiA)) && (i.this.enA().eox().startsWith(i.this.enA().BiA)) && (i.this.enA().getIntent().getBooleanExtra("key_detail_can_delete", true)) && (i.this.enZ()))
                  {
                    if ((i.c(i.this, 12)) && (i.this.Tx(12))) {
                      paramAnonymousl.a(12, i.this.enA().getString(2131758846), 2131689794);
                    }
                    if (i.c(i.this, 9)) {
                      paramAnonymousl.a(9, i.this.enA().getString(2131755707), 2131689802);
                    }
                  }
                  if (i.c(i.this, 37))
                  {
                    i.this.enA();
                    if ((com.tencent.mm.plugin.webview.c.a(i.this.enA().nhy)) && (i.this.Tx(37))) {
                      paramAnonymousl.a(37, i.this.enA().getString(2131766125), 2131690669);
                    }
                  }
                  if ((i.c(i.this, 11)) && (i.a(this.Bfu, 18)) && (i.this.Tx(11))) {
                    paramAnonymousl.a(11, i.this.enA().getString(2131762162), 2131690578, i.b(this.Bfu, 18));
                  }
                  if ((com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.h.DEBUG) || (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pvn, 0) == 1))
                  {
                    localObject = i.this.enA();
                    if (!j.ekH()) {
                      break label1564;
                    }
                    i = 2131766119;
                    paramAnonymousl.a(99, ((WebViewUI)localObject).getString(i), 2131691441, false);
                  }
                  i.this.nmt = true;
                  i.this.lBF.ffw();
                  AppMethodBeat.o(79873);
                  return;
                  localException4 = localException4;
                  ad.e("MicroMsg.WebViewMenuHelper", "sharebtn click fail isBizContact, ex = " + localException4.getMessage());
                  bool1 = false;
                }
                catch (Exception localException2)
                {
                  ad.e("MicroMsg.WebViewMenuHelper", "sharebtn click fail triggerGetContact, ex = " + localException2.getMessage());
                  continue;
                }
                boolean bool2;
                try
                {
                  bool1 = i.this.enA().AMZ.kxf.sD(localException2);
                  if (bool1)
                  {
                    bool1 = i.a(this.Bfu, 19);
                    bool2 = i.b(this.Bfu, 19);
                    boolean bool3 = i.this.enA().ejv();
                    if ((!i.c(i.this, 5)) || (!bool1) || (!i.this.Tx(5))) {
                      continue;
                    }
                    if (!bool3) {
                      break label1520;
                    }
                    paramAnonymousl.a(5, i.this.enA().getString(2131766259), 2131690612, bool2);
                  }
                }
                catch (Exception localException3)
                {
                  for (;;)
                  {
                    ad.e("MicroMsg.WebViewMenuHelper", "sharebtn click fail, ex = " + localException3.getMessage());
                    bool1 = false;
                    continue;
                    bool1 = i.a(this.Bfu, 20);
                    bool2 = i.b(this.Bfu, 20);
                  }
                }
                if ((this.Bfw == null) || (!this.Bfw.BaH))
                {
                  paramAnonymousl.a(5, i.this.enA().getString(2131766258), 2131690612, bool2);
                  continue;
                  i = 2131766120;
                }
              }
            }
          }
          catch (Exception localException1)
          {
            ad.e("MicroMsg.WebViewMenuHelper", "exception in add jd menu, " + localException1.getMessage());
            localObject = i.this.enA().getIntent().getStringExtra("srcUsername");
            if (bt.isNullOrNil((String)localObject)) {}
          }
        }
      }
    };
    this.lBF.HER = ((n.d)localObject2);
    Object localObject2 = enA().AMZ.getCurrentUrl();
    if (!bt.isNullOrNil((String)localObject2))
    {
      localObject3 = Uri.parse((String)localObject2).getHost();
      localObject4 = enA().getString(2131766116, new Object[] { localObject3 });
      if (bt.isNullOrNil(this.Bfk)) {
        if ((bool) && (localObject1 != null) && (((n.a)localObject1).isDataValid()))
        {
          localObject2 = LayoutInflater.from(enA()).inflate(2131494913, null);
          localObject3 = (ImageView)((View)localObject2).findViewById(2131301214);
          Object localObject5 = (TextView)((View)localObject2).findViewById(2131306141);
          localObject4 = ((View)localObject2).findViewById(2131298761);
          ((TextView)localObject5).setText(((n.a)localObject1).BiV);
          localObject5 = new c.a();
          ((c.a)localObject5).hjT = true;
          ((c.a)localObject5).gkG = true;
          ((c.a)localObject5).hkf = 2131231875;
          com.tencent.mm.aw.a.a.ayO().a(((n.a)localObject1).BiW, (ImageView)localObject3, ((c.a)localObject5).azc());
          ((View)localObject4).setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(175795);
              i.this.fk("Contact_Scene", 173);
              i.this.enA().AMJ.emr().z(new Object[] { i.this.enA().bEx(), Integer.valueOf(38), Integer.valueOf(1) }).report();
              i.this.enA().axZ(this.Bfw.gXY);
              if (i.this.lBF != null) {
                i.this.lBF.bfo();
              }
              AppMethodBeat.o(175795);
            }
          });
          o.gp((View)localObject4);
          this.lBF.J((View)localObject2, true);
          if (!enA().BgP) {
            break label763;
          }
          this.lBF.kBo = true;
        }
      }
    }
    for (this.lBF.kBp = true;; this.lBF.kBp = false)
    {
      if ((enA().BgT == null) || (!enA().BgT.isShown())) {
        break label782;
      }
      enA().BgT.hide();
      aq.n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(79876);
          if ((i.this.enA().isFinishing()) || (i.this.enA().BhN))
          {
            ad.i("MicroMsg.WebViewMenuHelper", "tryShow bottom sheet failed, the activity has been destroyed.");
            AppMethodBeat.o(79876);
            return;
          }
          i.this.lBF.csG();
          AppMethodBeat.o(79876);
        }
      }, 100L);
      AppMethodBeat.o(79887);
      return;
      if (bt.isNullOrNil((String)localObject3)) {
        break;
      }
      this.lBF.q((CharSequence)localObject4, 1);
      break;
      localObject3 = LayoutInflater.from(enA()).inflate(2131494914, null);
      localObject1 = (MMNeat7extView)((View)localObject3).findViewById(2131299007);
      this.lBF.J((View)localObject3, false);
      localObject3 = k.f(((MMNeat7extView)localObject1).getContext(), bt.nullAsNil(this.Bfk), (int)((MMNeat7extView)localObject1).getTextSize());
      ((MMNeat7extView)localObject1).aq((CharSequence)localObject3);
      localObject3 = (ClickableSpan[])((SpannableString)localObject3).getSpans(0, ((SpannableString)localObject3).length(), ClickableSpan.class);
      if ((localObject3 == null) || (localObject3.length <= 0)) {
        break;
      }
      ad.i("MicroMsg.WebViewMenuHelper", "terry h5 apply show");
      com.tencent.mm.plugin.report.service.h.vKh.f(16337, new Object[] { localObject2, Integer.valueOf(1), Integer.valueOf(0) });
      ((MMNeat7extView)localObject1).setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.g((NeatTextView)localObject1, new com.tencent.mm.pluginsdk.ui.span.n(((MMNeat7extView)localObject1).getContext()))
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(175796);
          boolean bool = super.onTouch(paramAnonymousView, paramAnonymousMotionEvent);
          if (bool)
          {
            ad.i("MMNeatTouchListener", "terry h5 apply click");
            com.tencent.mm.plugin.report.service.h.vKh.f(16337, new Object[] { this.val$url, Integer.valueOf(1), Integer.valueOf(1) });
          }
          AppMethodBeat.o(175796);
          return bool;
        }
      });
      break;
      this.lBF.q(" ", 1);
      break;
      label763:
      this.lBF.kBo = false;
    }
    label782:
    enA().hideVKB();
    aq.n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(175785);
        if ((i.this.enA().isFinishing()) || (i.this.enA().BhN))
        {
          ad.i("MicroMsg.WebViewMenuHelper", "tryShow bottom sheet failed, the activity has been destroyed.");
          AppMethodBeat.o(175785);
          return;
        }
        i.this.lBF.csG();
        AppMethodBeat.o(175785);
      }
    }, 100L);
    AppMethodBeat.o(79887);
  }
  
  public final void bFe()
  {
    AppMethodBeat.i(79899);
    if ((enA() == null) || (enA().kxg == null))
    {
      ad.e("MicroMsg.WebViewMenuHelper", "showShareMenu params failed");
      AppMethodBeat.o(79899);
      return;
    }
    final JsapiPermissionWrapper localJsapiPermissionWrapper = enA().kxg.emR();
    if ((!a(localJsapiPermissionWrapper, 21, 1)) && (!a(localJsapiPermissionWrapper, 23, 2)))
    {
      com.tencent.mm.ui.base.h.cf(enA(), enA().getString(2131766260));
      AppMethodBeat.o(79899);
      return;
    }
    com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(enA(), 1, false);
    locale.HrX = new n.c()
    {
      public final void onCreateMMMenu(l paramAnonymousl)
      {
        AppMethodBeat.i(175793);
        if (i.this.a(localJsapiPermissionWrapper, 23, 2)) {
          paramAnonymousl.a(2, i.this.enA().getString(2131762164), 2131689817, false);
        }
        if (i.this.a(localJsapiPermissionWrapper, 21, 1)) {
          paramAnonymousl.a(1, i.this.enA().getString(2131762163), 2131689831, false);
        }
        AppMethodBeat.o(175793);
      }
    };
    locale.HrY = new n.d()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        paramAnonymousInt = 0;
        AppMethodBeat.i(175794);
        switch (paramAnonymousMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(175794);
          return;
          paramAnonymousMenuItem = i.this.enA().getIntent().getStringExtra("KPublisherId");
          String str1 = i.this.enA().getIntent().getStringExtra("KAppId");
          String str2 = i.this.enA().getIntent().getStringExtra("srcUsername");
          i.this.enA().AMJ.emr().z(new Object[] { i.this.enA().bEx(), Integer.valueOf(1), Integer.valueOf(1), paramAnonymousMenuItem, str1, str2 }).report();
          i.this.enA().Bhd = i.this.enA().kxg.emS().eBQ();
          i.this.enA().dqY();
          AppMethodBeat.o(175794);
          return;
          paramAnonymousMenuItem = i.this.enA().getIntent().getStringExtra("KPublisherId");
          str1 = i.this.enA().getIntent().getStringExtra("KAppId");
          str2 = i.this.enA().getIntent().getStringExtra("srcUsername");
          i.this.enA().AMJ.emr().z(new Object[] { i.this.enA().bEx(), Integer.valueOf(2), Integer.valueOf(1), paramAnonymousMenuItem, str1, str2 }).report();
          i.this.enA().Bhd = i.this.enA().kxg.emS().eBQ();
          if (i.this.Bfl.containsKey(i.this.enA().nhy.getUrl())) {
            paramAnonymousInt = ((Integer)i.this.Bfl.get(i.this.enA().nhy.getUrl())).intValue();
          }
          i.a(i.this, paramAnonymousInt);
        }
      }
    };
    locale.q(" ", 1);
    locale.csG();
    AppMethodBeat.o(79899);
  }
  
  public final void bFg()
  {
    AppMethodBeat.i(79900);
    if ((enA() == null) || (enA().nhy == null) || (enA().kxg == null))
    {
      ad.e("MicroMsg.WebViewMenuHelper", "setShareFuncFlag params failed");
      AppMethodBeat.o(79900);
      return;
    }
    String str = enA().nhy.getUrl();
    if (!bt.isNullOrNil(str))
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
        ad.e("MicroMsg.WebViewMenuHelper", "create url fail : " + localException.getLocalizedMessage());
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
    int i = eob();
    if (enA().AQP != null) {
      enA().AQP.eV("setFuncFlag", i);
    }
    AppMethodBeat.o(79900);
  }
  
  public final void enT()
  {
    AppMethodBeat.i(79879);
    this.Bfh.clear();
    this.Bfh.put("menuItem:share:brand", Integer.valueOf(0));
    this.Bfh.put("menuItem:share:appMessage", Integer.valueOf(1));
    this.Bfh.put("menuItem:share:dataMessage", Integer.valueOf(23));
    this.Bfh.put("menuItem:share:timeline", Integer.valueOf(2));
    this.Bfh.put("menuItem:favorite", Integer.valueOf(3));
    this.Bfh.put("menuItem:profile", Integer.valueOf(5));
    this.Bfh.put("menuItem:addContact", Integer.valueOf(5));
    this.Bfh.put("menuItem:copyUrl", Integer.valueOf(6));
    this.Bfh.put("menuItem:openWithSafari", Integer.valueOf(7));
    this.Bfh.put("menuItem:share:email", Integer.valueOf(8));
    this.Bfh.put("menuItem:delete", Integer.valueOf(9));
    this.Bfh.put("menuItem:exposeArticle", Integer.valueOf(10));
    this.Bfh.put("menuItem:setFont", Integer.valueOf(11));
    this.Bfh.put("menuItem:editTag", Integer.valueOf(12));
    this.Bfh.put("menuItem:share:qq", Integer.valueOf(20));
    this.Bfh.put("menuItem:share:weiboApp", Integer.valueOf(21));
    this.Bfh.put("menuItem:share:QZone", Integer.valueOf(22));
    this.Bfh.put("menuItem:share:Facebook", Integer.valueOf(33));
    this.Bfh.put("menuItem:share:enterprise", Integer.valueOf(24));
    this.Bfh.put("menuItem:refresh", Integer.valueOf(28));
    this.Bfh.put("menuItem:share:wework", Integer.valueOf(25));
    this.Bfh.put("menuItem:share:weread", Integer.valueOf(26));
    this.Bfh.put("menuItem:addShortcut", Integer.valueOf(29));
    this.Bfh.put("menuItem:search", Integer.valueOf(31));
    this.Bfh.put("menuItem:readArticle", Integer.valueOf(34));
    this.Bfh.put("menuItem:minimize", Integer.valueOf(35));
    this.Bfh.put("menuItem:cancelMinimize", Integer.valueOf(36));
    this.Bfh.put("menuItem:translate", Integer.valueOf(37));
    this.Bfh.put("menuItem:haoKan", Integer.valueOf(38));
    this.Bfh.put("menuItem:cancelHaoKan", Integer.valueOf(39));
    this.Bfh.put("menuItem:ttsStart", Integer.valueOf(40));
    this.Bfh.put("menuItem:ttsPause", Integer.valueOf(41));
    this.Bfh.put("menuItem:ttsResume", Integer.valueOf(42));
    AppMethodBeat.o(79879);
  }
  
  protected final void enU()
  {
    AppMethodBeat.i(79884);
    if (!this.Bfn)
    {
      AppMethodBeat.o(79884);
      return;
    }
    this.Bfm = false;
    enA().Biw = false;
    this.Bfn = false;
    if (this.nmt) {
      bFd();
    }
    AppMethodBeat.o(79884);
  }
  
  public final void enV()
  {
    AppMethodBeat.i(79886);
    this.Bfm = true;
    this.Bfo.clear();
    if ((enA() instanceof GameWebViewUI))
    {
      this.Bfo.add(Integer.valueOf(11));
      this.Bfo.add(Integer.valueOf(28));
      AppMethodBeat.o(79886);
      return;
    }
    this.Bfo.add(Integer.valueOf(7));
    this.Bfo.add(Integer.valueOf(11));
    this.Bfo.add(Integer.valueOf(28));
    AppMethodBeat.o(79886);
  }
  
  protected final void enX()
  {
    AppMethodBeat.i(79892);
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putLong("msg_id", enA().getIntent().getLongExtra("msg_id", -9223372036854775808L));
    ((Bundle)localObject1).putString("sns_local_id", enA().getIntent().getStringExtra("sns_local_id"));
    ((Bundle)localObject1).putInt("news_svr_id", enA().getIntent().getIntExtra("news_svr_id", 0));
    ((Bundle)localObject1).putString("news_svr_tweetid", enA().getIntent().getStringExtra("news_svr_tweetid"));
    ((Bundle)localObject1).putInt("message_index", enA().getIntent().getIntExtra("message_index", 0));
    ((Bundle)localObject1).putString("rawUrl", enA().bEx());
    Object localObject2;
    if ((!bt.isNullOrNil(enA().bEx())) && (enA().bEx().endsWith("#rd")))
    {
      localObject2 = enA().bEx().substring(0, enA().bEx().length() - 3);
      if ((!bt.isNullOrNil(enA().eox())) && (!enA().eox().startsWith((String)localObject2)))
      {
        ((Bundle)localObject1).putString("rawUrl", enA().eox());
        ((Bundle)localObject1).putLong("msg_id", -9223372036854775808L);
      }
      localObject2 = enA().getIntent();
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
          localObject1 = enA().AMZ.kxf.aB((Bundle)localObject1);
          if (!((com.tencent.mm.plugin.webview.stub.c)localObject1).enh()) {
            break label763;
          }
          enA().AQP.bZ("sendAppMessage", false);
          localObject1 = enA().AQP;
          localObject2 = enY();
          ad.i("MicroMsg.JsApiHandler", "onFavorite %b", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.webview.c.f)localObject1).yZR) });
          bool = ((com.tencent.mm.plugin.webview.c.f)localObject1).yZR;
          if (!bool) {
            try
            {
              ((com.tencent.mm.plugin.webview.c.f)localObject1).kxf.ab("scene", "favorite", ((com.tencent.mm.plugin.webview.c.f)localObject1).ARo);
              ((com.tencent.mm.plugin.webview.c.f)localObject1).h(((com.tencent.mm.plugin.webview.c.f)localObject1).bp((Map)localObject2), "sendAppMessage");
              ad.i("MicroMsg.WebViewMenuHelper", "on favorite simple url");
              AppMethodBeat.o(79892);
              return;
              if ((bt.isNullOrNil(enA().eox())) || (enA().eox().startsWith(enA().bEx()))) {
                break;
              }
              ((Bundle)localObject1).putString("rawUrl", enA().eox());
              ((Bundle)localObject1).putLong("msg_id", -9223372036854775808L);
            }
            catch (Exception localException1)
            {
              for (;;)
              {
                ad.w("MicroMsg.JsApiHandler", "jsapiBundlePutString, ex = " + localException1.getMessage());
              }
            }
          }
        }
        localObject2 = localException2.SF(1);
      }
      catch (Exception localException2)
      {
        ad.e("MicroMsg.WebViewMenuHelper", "edw, favoriteUrl fail, ex = " + localException2.getMessage());
        AppMethodBeat.o(79892);
        return;
      }
      if (localObject2 != null)
      {
        bool = ((Bundle)localObject2).getBoolean("WebViewShare_reslut", false);
        if (bool) {
          try
          {
            localException2.kxf.ab("scene", "favorite", localException2.ARo);
            localException2.h((Bundle)localObject2, "sendAppMessage");
          }
          catch (Exception localException4)
          {
            for (;;)
            {
              ad.w("MicroMsg.JsApiHandler", "jsapiBundlePutString, ex = " + localException4.getMessage());
            }
          }
        }
      }
      localObject2 = new HashMap();
      ((HashMap)localObject2).put("scene", "favorite");
      localObject2 = l.a.b("menu:share:appmessage", (Map)localObject2, localException2.ARm, localException2.ARn);
      localException2.ARe.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + (String)localObject2 + ")", null);
      try
      {
        localException2.kxf.ab("scene", "favorite", localException2.ARo);
      }
      catch (Exception localException3)
      {
        ad.w("MicroMsg.JsApiHandler", "jsapiBundlePutString, ex = " + localException3.getMessage());
      }
    }
    label763:
    com.tencent.mm.plugin.fav.ui.e.a(localException3.getRet(), enA(), enA().rPQ);
    if (localException3.getRet() == 0)
    {
      Ty(1);
      AppMethodBeat.o(79892);
      return;
    }
    Ty(2);
    AppMethodBeat.o(79892);
  }
  
  public final HashMap<String, String> enY()
  {
    AppMethodBeat.i(79893);
    if (!enA().Biw)
    {
      AppMethodBeat.o(79893);
      return null;
    }
    Intent localIntent = enA().getIntent();
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
  
  final boolean enZ()
  {
    AppMethodBeat.i(79896);
    try
    {
      boolean bool = enA().AMZ.kxf.axB("favorite");
      AppMethodBeat.o(79896);
      return bool;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.WebViewMenuHelper", localException, "", new Object[0]);
      AppMethodBeat.o(79896);
    }
    return false;
  }
  
  public final Bundle eoa()
  {
    AppMethodBeat.i(79898);
    Bundle localBundle = new Bundle();
    localBundle.putInt("funcFlag", eob());
    AppMethodBeat.o(79898);
    return localBundle;
  }
  
  public final void fk(String paramString, int paramInt)
  {
    AppMethodBeat.i(79895);
    if (enA().AQP != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt(paramString, paramInt);
      paramString = enA().AQP;
      try
      {
        paramString.kxf.a(21, localBundle, paramString.ARo);
        AppMethodBeat.o(79895);
        return;
      }
      catch (Exception paramString)
      {
        ad.printErrStackTrace("MicroMsg.JsApiHandler", paramString, "", new Object[0]);
        ad.w("MicroMsg.JsApiHandler", "updateJsapiArgsBundleKV, ex = ".concat(String.valueOf(paramString)));
      }
    }
    AppMethodBeat.o(79895);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(79878);
    Iterator localIterator = this.Bfg.values().iterator();
    while (localIterator.hasNext())
    {
      SparseBooleanArray localSparseBooleanArray = (SparseBooleanArray)localIterator.next();
      if (localSparseBooleanArray != null) {
        localSparseBooleanArray.clear();
      }
    }
    this.Bfg.clear();
    this.Bfl.clear();
    if ((this.lBF != null) && (this.lBF.isShowing())) {
      this.lBF.bfo();
    }
    AppMethodBeat.o(79878);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.i
 * JD-Core Version:    0.7.0.1
 */