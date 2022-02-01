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
import com.tencent.mm.n.d.a;
import com.tencent.mm.n.d.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.c.j;
import com.tencent.mm.plugin.webview.c.l.a;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.model.ay;
import com.tencent.mm.plugin.webview.model.ay.d;
import com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n.b;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.tools.o;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.a.e.b;
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
  protected Map<String, SparseBooleanArray> Eba;
  protected Map<String, Integer> Ebb;
  ag<String, Bitmap> Ebc;
  HashMap<String, String> Ebd;
  public String Ebe;
  HashMap<String, Integer> Ebf;
  public boolean Ebg;
  public boolean Ebh;
  Set<Integer> Ebi;
  ArrayList<d.b> Ebj;
  Boolean Ebk;
  private int height;
  private String lny;
  com.tencent.mm.ui.widget.a.e mDL;
  public boolean orZ;
  private int width;
  
  public i(WebViewUI paramWebViewUI)
  {
    super(paramWebViewUI);
    AppMethodBeat.i(79877);
    this.Eba = new HashMap();
    this.Ebb = new HashMap();
    this.Ebc = new ag(12);
    this.Ebd = new HashMap();
    this.lny = "";
    this.Ebf = new HashMap();
    this.Ebg = true;
    this.Ebh = false;
    this.orZ = false;
    this.Ebi = new HashSet();
    this.width = paramWebViewUI.getResources().getDisplayMetrics().widthPixels;
    this.height = paramWebViewUI.getResources().getDisplayMetrics().heightPixels;
    AppMethodBeat.o(79877);
  }
  
  private void Xv(int paramInt)
  {
    AppMethodBeat.i(79891);
    String str2 = eRK().aGj(eRK().eSK());
    if ((TextUtils.isEmpty(eRK().eSK())) || (TextUtils.isEmpty(str2)))
    {
      ad.i("MicroMsg.WebViewMenuHelper", "stev appId is null or empty");
      AppMethodBeat.o(79891);
      return;
    }
    ad.i("MicroMsg.WebViewMenuHelper", "stev appId %s", new Object[] { str2 });
    long l = bt.aQJ();
    ad.d("MicroMsg.WebViewMenuHelper", "stev report(%s), clickTimestamp : %d, appID : %s, url : %s, sessionId : %s, actionType : %d, flag : %d", new Object[] { Integer.valueOf(13377), Long.valueOf(l), str2, eRK().eSK(), eRK().sessionId, Integer.valueOf(3), Integer.valueOf(paramInt) });
    Object localObject = "";
    try
    {
      str1 = com.tencent.mm.compatible.util.q.encode(eRK().eSK(), "UTF-8");
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
    i = eRK().aGo(eRK().getIntent().getStringExtra("geta8key_username"));
    str1 = "";
    if ((i == 7) || (i == 56)) {
      str1 = eRK().getIntent().getStringExtra("geta8key_username");
    }
    com.tencent.mm.plugin.report.service.g.yhR.f(13377, new Object[] { Long.valueOf(l), str2, localObject, eRK().sessionId, Integer.valueOf(3), Integer.valueOf(paramInt), Integer.valueOf(0), str1 });
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
    paramInt = paramJsapiPermissionWrapper.ZB(paramInt);
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
    if (paramJsapiPermissionWrapper.ZB(paramInt) == 10)
    {
      AppMethodBeat.o(79883);
      return true;
    }
    AppMethodBeat.o(79883);
    return false;
  }
  
  private ArrayList<d.b> eSh()
  {
    AppMethodBeat.i(79888);
    Object localObject = eRK().omW.getUrl();
    if (eRK().Edt.containsKey(localObject))
    {
      localObject = (ArrayList)eRK().Edt.get(localObject);
      AppMethodBeat.o(79888);
      return localObject;
    }
    AppMethodBeat.o(79888);
    return null;
  }
  
  private void gV(List<String> paramList)
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
      if (this.Ebc.get(str2) != null) {
        ad.i("MicroMsg.WebViewMenuHelper", "find %s icon from cache ok", new Object[] { str2 });
      }
      for (;;)
      {
        if (!this.Ebd.containsKey(str2)) {
          break label216;
        }
        ad.i("MicroMsg.WebViewMenuHelper", "find %s nick from cache ok", new Object[] { str2 });
        break;
        ad.w("MicroMsg.WebViewMenuHelper", "not found %s icon from cache, try to load", new Object[] { str2 });
        try
        {
          paramList = eRK().DIv.lvv.aIq(str2);
          if (!bt.isNullOrNil(paramList))
          {
            paramList = e.aIF(paramList);
            if (paramList != null)
            {
              ad.i("MicroMsg.WebViewMenuHelper", "load ok, and cache it");
              this.Ebc.put(str2, paramList);
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
        String str1 = eRK().DIv.lvv.zf(str2);
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
      this.Ebd.put(str2, paramList);
    }
    label308:
    AppMethodBeat.o(79894);
  }
  
  protected final void Cs(final long paramLong)
  {
    AppMethodBeat.i(208017);
    this.Ebj = eSh();
    boolean bool;
    if ((this.Ebj != null) && (this.Ebj.size() > 0))
    {
      bool = true;
      this.Ebk = Boolean.valueOf(bool);
      if (!this.orZ) {
        if (!this.Ebk.booleanValue()) {
          break label172;
        }
      }
    }
    Object localObject2;
    label172:
    for (this.mDL = new com.tencent.mm.ui.widget.a.e(eRK(), 1, false);; this.mDL = new com.tencent.mm.ui.widget.a.e(eRK(), 0, true))
    {
      this.mDL.KJC = new com.tencent.mm.ui.base.n.a()
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
          if ((i.this.Ebc.get(paramAnonymousMenuItem) != null) && (!((Bitmap)i.this.Ebc.get(paramAnonymousMenuItem)).isRecycled()))
          {
            paramAnonymousImageView.setImageBitmap((Bitmap)i.this.Ebc.get(paramAnonymousMenuItem));
            AppMethodBeat.o(79858);
            return;
          }
          ad.w("MicroMsg.WebViewMenuHelper", "on attach icon, load from cache fail");
          try
          {
            Object localObject = i.this.eRK().DIv.lvv.aIq(paramAnonymousMenuItem);
            if (!bt.isNullOrNil((String)localObject))
            {
              localObject = e.aIF((String)localObject);
              if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
              {
                paramAnonymousImageView.setImageBitmap((Bitmap)localObject);
                i.this.Ebc.put(paramAnonymousMenuItem, localObject);
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
      this.mDL.KJD = new n.b()
      {
        public final void a(TextView paramAnonymousTextView, MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(79869);
          paramAnonymousMenuItem = paramAnonymousMenuItem.getTitle();
          if (paramAnonymousTextView != null)
          {
            String str = (String)i.this.Ebd.get(paramAnonymousMenuItem);
            if (bt.isNullOrNil(str))
            {
              paramAnonymousTextView.setText(paramAnonymousMenuItem);
              AppMethodBeat.o(79869);
              return;
            }
            paramAnonymousTextView.setText(k.b(i.this.eRK(), str, paramAnonymousTextView.getTextSize()));
          }
          AppMethodBeat.o(79869);
        }
      };
      localObject2 = new n.e()
      {
        /* Error */
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          // Byte code:
          //   0: ldc 28
          //   2: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
          //   5: aload_0
          //   6: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   9: iconst_0
          //   10: putfield 38	com/tencent/mm/plugin/webview/ui/tools/i:orZ	Z
          //   13: aload_1
          //   14: invokestatic 42	com/tencent/mm/plugin/webview/ui/tools/i:e	(Landroid/view/MenuItem;)Z
          //   17: ifeq +145 -> 162
          //   20: aload_1
          //   21: invokeinterface 48 1 0
          //   26: checkcast 50	com/tencent/mm/n/d$b
          //   29: astore 4
          //   31: aload 4
          //   33: ifnull +123 -> 156
          //   36: aload_0
          //   37: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   40: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   43: getfield 60	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:DzP	Lcom/tencent/mm/plugin/webview/c/f;
          //   46: astore_1
          //   47: aload_1
          //   48: getfield 65	com/tencent/mm/plugin/webview/c/f:BHY	Z
          //   51: ifne +16 -> 67
          //   54: ldc 67
          //   56: ldc 69
          //   58: invokestatic 74	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   61: ldc 28
          //   63: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   66: return
          //   67: ldc 67
          //   69: ldc 79
          //   71: invokestatic 81	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
          //   74: new 83	java/util/HashMap
          //   77: dup
          //   78: invokespecial 84	java/util/HashMap:<init>	()V
          //   81: astore 5
          //   83: aload 5
          //   85: ldc 86
          //   87: aload 4
          //   89: getfield 89	com/tencent/mm/n/d$b:key	Ljava/lang/String;
          //   92: invokevirtual 93	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
          //   95: pop
          //   96: aload 5
          //   98: ldc 95
          //   100: aload 4
          //   102: getfield 97	com/tencent/mm/n/d$b:title	Ljava/lang/String;
          //   105: invokevirtual 93	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
          //   108: pop
          //   109: ldc 99
          //   111: aload 5
          //   113: aload_1
          //   114: getfield 102	com/tencent/mm/plugin/webview/c/f:DMD	Z
          //   117: aload_1
          //   118: getfield 105	com/tencent/mm/plugin/webview/c/f:vJP	Ljava/lang/String;
          //   121: invokestatic 111	com/tencent/mm/plugin/webview/c/l$a:b	(Ljava/lang/String;Ljava/util/Map;ZLjava/lang/String;)Ljava/lang/String;
          //   124: astore 4
          //   126: aload_1
          //   127: getfield 115	com/tencent/mm/plugin/webview/c/f:DMv	Lcom/tencent/mm/ui/widget/MMWebView;
          //   130: new 117	java/lang/StringBuilder
          //   133: dup
          //   134: ldc 119
          //   136: invokespecial 122	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   139: aload 4
          //   141: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   144: ldc 128
          //   146: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   149: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   152: aconst_null
          //   153: invokevirtual 138	com/tencent/mm/ui/widget/MMWebView:evaluateJavascript	(Ljava/lang/String;Landroid/webkit/ValueCallback;)V
          //   156: ldc 28
          //   158: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   161: return
          //   162: ldc 140
          //   164: ldc 142
          //   166: iconst_1
          //   167: anewarray 4	java/lang/Object
          //   170: dup
          //   171: iconst_0
          //   172: aload_1
          //   173: invokeinterface 146 1 0
          //   178: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   181: aastore
          //   182: invokestatic 155	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   185: aload_1
          //   186: invokeinterface 146 1 0
          //   191: lookupswitch	default:+313->504, 1:+564->755, 2:+799->990, 3:+1117->1308, 5:+1194->1385, 6:+1573->1764, 7:+1636->1827, 8:+2124->2315, 9:+2282->2473, 10:+2382->2573, 11:+1328->1519, 12:+2447->2638, 15:+2578->2769, 16:+2643->2834, 17:+2708->2899, 18:+2773->2964, 19:+2838->3029, 20:+3176->3367, 21:+3373->3564, 22:+3531->3722, 23:+696->887, 24:+3937->4128, 25:+2903->3094, 26:+3112->3303, 27:+484->675, 28:+1506->1697, 29:+4001->4192, 31:+4065->4256, 33:+3728->3919, 34:+4189->4380, 35:+4287->4478, 36:+4358->4549, 37:+2060->2251, 38:+987->1178, 39:+1052->1243, 40:+4496->4687, 41:+4496->4687, 42:+4496->4687, 99:+4429->4620
          //   505: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   508: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   511: getfield 159	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:DIg	Lcom/tencent/mm/plugin/webview/model/ay;
          //   514: invokevirtual 165	com/tencent/mm/plugin/webview/model/ay:eQG	()Lcom/tencent/mm/plugin/webview/model/ay$d;
          //   517: iconst_3
          //   518: anewarray 4	java/lang/Object
          //   521: dup
          //   522: iconst_0
          //   523: aload_0
          //   524: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   527: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   530: invokevirtual 168	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bQm	()Ljava/lang/String;
          //   533: aastore
          //   534: dup
          //   535: iconst_1
          //   536: bipush 16
          //   538: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   541: aastore
          //   542: dup
          //   543: iconst_2
          //   544: iconst_1
          //   545: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   548: aastore
          //   549: invokevirtual 174	com/tencent/mm/plugin/webview/model/ay$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ay$d;
          //   552: invokevirtual 177	com/tencent/mm/plugin/webview/model/ay$d:report	()V
          //   555: new 117	java/lang/StringBuilder
          //   558: dup
          //   559: invokespecial 178	java/lang/StringBuilder:<init>	()V
          //   562: aload_1
          //   563: invokeinterface 182 1 0
          //   568: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
          //   571: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   574: astore 4
          //   576: aload 4
          //   578: invokestatic 191	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
          //   581: ifne +4351 -> 4932
          //   584: iconst_0
          //   585: istore_2
          //   586: new 193	android/os/Bundle
          //   589: dup
          //   590: invokespecial 194	android/os/Bundle:<init>	()V
          //   593: astore_1
          //   594: aload_1
          //   595: ldc 196
          //   597: aload 4
          //   599: invokevirtual 199	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
          //   602: aload_0
          //   603: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   606: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   609: getfield 203	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:DIv	Lcom/tencent/mm/plugin/webview/core/h;
          //   612: getfield 209	com/tencent/mm/plugin/webview/core/h:lvv	Lcom/tencent/mm/plugin/webview/stub/e;
          //   615: bipush 50
          //   617: aload_1
          //   618: invokeinterface 215 3 0
          //   623: astore_1
          //   624: aload_1
          //   625: ifnull +31 -> 656
          //   628: aload_1
          //   629: ldc 217
          //   631: invokevirtual 221	android/os/Bundle:getInt	(Ljava/lang/String;)I
          //   634: istore_2
          //   635: iload_2
          //   636: iconst_2
          //   637: if_icmpne +4080 -> 4717
          //   640: iconst_1
          //   641: istore_2
          //   642: aload_1
          //   643: ldc 217
          //   645: invokevirtual 221	android/os/Bundle:getInt	(Ljava/lang/String;)I
          //   648: istore_3
          //   649: iload_3
          //   650: iconst_3
          //   651: if_icmpne +4071 -> 4722
          //   654: iconst_1
          //   655: istore_2
          //   656: iload_2
          //   657: ifeq +4089 -> 4746
          //   660: aload_0
          //   661: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   664: aload 4
          //   666: invokevirtual 224	com/tencent/mm/plugin/webview/ui/tools/i:aIM	(Ljava/lang/String;)V
          //   669: ldc 28
          //   671: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   674: return
          //   675: aload_0
          //   676: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   679: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   682: getfield 159	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:DIg	Lcom/tencent/mm/plugin/webview/model/ay;
          //   685: invokevirtual 165	com/tencent/mm/plugin/webview/model/ay:eQG	()Lcom/tencent/mm/plugin/webview/model/ay$d;
          //   688: iconst_3
          //   689: anewarray 4	java/lang/Object
          //   692: dup
          //   693: iconst_0
          //   694: aload_0
          //   695: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   698: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   701: invokevirtual 168	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bQm	()Ljava/lang/String;
          //   704: aastore
          //   705: dup
          //   706: iconst_1
          //   707: bipush 32
          //   709: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   712: aastore
          //   713: dup
          //   714: iconst_2
          //   715: iconst_1
          //   716: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   719: aastore
          //   720: invokevirtual 174	com/tencent/mm/plugin/webview/model/ay$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ay$d;
          //   723: invokevirtual 177	com/tencent/mm/plugin/webview/model/ay$d:report	()V
          //   726: aload_0
          //   727: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   730: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   733: invokevirtual 228	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:ePd	()Z
          //   736: ifne +4196 -> 4932
          //   739: aload_0
          //   740: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   743: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   746: invokevirtual 231	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:finish	()V
          //   749: ldc 28
          //   751: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   754: return
          //   755: aload_0
          //   756: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   759: invokevirtual 234	com/tencent/mm/plugin/webview/ui/tools/a:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   762: invokevirtual 238	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
          //   765: ldc 240
          //   767: invokevirtual 246	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
          //   770: astore_1
          //   771: aload_0
          //   772: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   775: invokevirtual 234	com/tencent/mm/plugin/webview/ui/tools/a:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   778: invokevirtual 238	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
          //   781: ldc 248
          //   783: invokevirtual 246	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
          //   786: astore 4
          //   788: aload_0
          //   789: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   792: invokevirtual 234	com/tencent/mm/plugin/webview/ui/tools/a:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   795: invokevirtual 238	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
          //   798: ldc 250
          //   800: invokevirtual 246	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
          //   803: astore 5
          //   805: aload_0
          //   806: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   809: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   812: getfield 159	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:DIg	Lcom/tencent/mm/plugin/webview/model/ay;
          //   815: invokevirtual 165	com/tencent/mm/plugin/webview/model/ay:eQG	()Lcom/tencent/mm/plugin/webview/model/ay$d;
          //   818: bipush 6
          //   820: anewarray 4	java/lang/Object
          //   823: dup
          //   824: iconst_0
          //   825: aload_0
          //   826: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   829: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   832: invokevirtual 168	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bQm	()Ljava/lang/String;
          //   835: aastore
          //   836: dup
          //   837: iconst_1
          //   838: iconst_1
          //   839: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   842: aastore
          //   843: dup
          //   844: iconst_2
          //   845: iconst_1
          //   846: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   849: aastore
          //   850: dup
          //   851: iconst_3
          //   852: aload_1
          //   853: aastore
          //   854: dup
          //   855: iconst_4
          //   856: aload 4
          //   858: aastore
          //   859: dup
          //   860: iconst_5
          //   861: aload 5
          //   863: aastore
          //   864: invokevirtual 174	com/tencent/mm/plugin/webview/model/ay$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ay$d;
          //   867: invokevirtual 177	com/tencent/mm/plugin/webview/model/ay$d:report	()V
          //   870: aload_0
          //   871: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   874: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   877: iconst_0
          //   878: invokevirtual 253	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:XA	(I)V
          //   881: ldc 28
          //   883: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   886: return
          //   887: new 242	android/content/Intent
          //   890: dup
          //   891: invokespecial 254	android/content/Intent:<init>	()V
          //   894: astore_1
          //   895: aload_0
          //   896: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   899: invokevirtual 234	com/tencent/mm/plugin/webview/ui/tools/a:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   902: invokevirtual 238	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
          //   905: ldc_w 256
          //   908: invokevirtual 246	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
          //   911: astore 4
          //   913: aload 4
          //   915: ifnull +42 -> 957
          //   918: aload_1
          //   919: ldc_w 258
          //   922: iconst_1
          //   923: invokevirtual 262	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
          //   926: pop
          //   927: aload_1
          //   928: ldc_w 256
          //   931: aload 4
          //   933: invokevirtual 265	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
          //   936: pop
          //   937: aload_0
          //   938: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   941: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   944: ldc_w 267
          //   947: aload_1
          //   948: invokestatic 273	com/tencent/mm/bs/d:f	(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;)V
          //   951: ldc 28
          //   953: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   956: return
          //   957: aload_1
          //   958: ldc_w 275
          //   961: aload_0
          //   962: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   965: invokevirtual 234	com/tencent/mm/plugin/webview/ui/tools/a:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   968: invokevirtual 238	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
          //   971: ldc_w 277
          //   974: ldc2_w 278
          //   977: invokevirtual 283	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
          //   980: invokestatic 288	java/lang/Long:valueOf	(J)Ljava/lang/Long;
          //   983: invokevirtual 291	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;
          //   986: pop
          //   987: goto -50 -> 937
          //   990: aload_0
          //   991: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   994: invokevirtual 234	com/tencent/mm/plugin/webview/ui/tools/a:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   997: invokevirtual 238	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
          //   1000: ldc 240
          //   1002: invokevirtual 246	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
          //   1005: astore_1
          //   1006: aload_0
          //   1007: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1010: invokevirtual 234	com/tencent/mm/plugin/webview/ui/tools/a:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1013: invokevirtual 238	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
          //   1016: ldc 248
          //   1018: invokevirtual 246	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
          //   1021: astore 4
          //   1023: aload_0
          //   1024: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1027: invokevirtual 234	com/tencent/mm/plugin/webview/ui/tools/a:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1030: invokevirtual 238	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
          //   1033: ldc 250
          //   1035: invokevirtual 246	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
          //   1038: astore 5
          //   1040: aload_0
          //   1041: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1044: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1047: getfield 159	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:DIg	Lcom/tencent/mm/plugin/webview/model/ay;
          //   1050: invokevirtual 165	com/tencent/mm/plugin/webview/model/ay:eQG	()Lcom/tencent/mm/plugin/webview/model/ay$d;
          //   1053: bipush 6
          //   1055: anewarray 4	java/lang/Object
          //   1058: dup
          //   1059: iconst_0
          //   1060: aload_0
          //   1061: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1064: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1067: invokevirtual 168	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bQm	()Ljava/lang/String;
          //   1070: aastore
          //   1071: dup
          //   1072: iconst_1
          //   1073: iconst_2
          //   1074: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1077: aastore
          //   1078: dup
          //   1079: iconst_2
          //   1080: iconst_1
          //   1081: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1084: aastore
          //   1085: dup
          //   1086: iconst_3
          //   1087: aload_1
          //   1088: aastore
          //   1089: dup
          //   1090: iconst_4
          //   1091: aload 4
          //   1093: aastore
          //   1094: dup
          //   1095: iconst_5
          //   1096: aload 5
          //   1098: aastore
          //   1099: invokevirtual 174	com/tencent/mm/plugin/webview/model/ay$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ay$d;
          //   1102: invokevirtual 177	com/tencent/mm/plugin/webview/model/ay$d:report	()V
          //   1105: iconst_0
          //   1106: istore_2
          //   1107: aload_0
          //   1108: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1111: getfield 295	com/tencent/mm/plugin/webview/ui/tools/i:Ebf	Ljava/util/HashMap;
          //   1114: aload_0
          //   1115: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1118: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1121: getfield 298	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:omW	Lcom/tencent/mm/ui/widget/MMWebView;
          //   1124: invokevirtual 301	com/tencent/mm/ui/widget/MMWebView:getUrl	()Ljava/lang/String;
          //   1127: invokevirtual 305	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
          //   1130: ifeq +33 -> 1163
          //   1133: aload_0
          //   1134: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1137: getfield 295	com/tencent/mm/plugin/webview/ui/tools/i:Ebf	Ljava/util/HashMap;
          //   1140: aload_0
          //   1141: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1144: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1147: getfield 298	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:omW	Lcom/tencent/mm/ui/widget/MMWebView;
          //   1150: invokevirtual 301	com/tencent/mm/ui/widget/MMWebView:getUrl	()Ljava/lang/String;
          //   1153: invokevirtual 309	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
          //   1156: checkcast 148	java/lang/Integer
          //   1159: invokevirtual 312	java/lang/Integer:intValue	()I
          //   1162: istore_2
          //   1163: aload_0
          //   1164: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1167: iload_2
          //   1168: iconst_0
          //   1169: invokestatic 316	com/tencent/mm/plugin/webview/ui/tools/i:a	(Lcom/tencent/mm/plugin/webview/ui/tools/i;II)V
          //   1172: ldc 28
          //   1174: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1177: return
          //   1178: aload_0
          //   1179: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1182: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1185: getfield 159	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:DIg	Lcom/tencent/mm/plugin/webview/model/ay;
          //   1188: invokevirtual 165	com/tencent/mm/plugin/webview/model/ay:eQG	()Lcom/tencent/mm/plugin/webview/model/ay$d;
          //   1191: iconst_3
          //   1192: anewarray 4	java/lang/Object
          //   1195: dup
          //   1196: iconst_0
          //   1197: aload_0
          //   1198: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1201: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1204: invokevirtual 168	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bQm	()Ljava/lang/String;
          //   1207: aastore
          //   1208: dup
          //   1209: iconst_1
          //   1210: bipush 36
          //   1212: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1215: aastore
          //   1216: dup
          //   1217: iconst_2
          //   1218: iconst_1
          //   1219: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1222: aastore
          //   1223: invokevirtual 174	com/tencent/mm/plugin/webview/model/ay$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ay$d;
          //   1226: invokevirtual 177	com/tencent/mm/plugin/webview/model/ay$d:report	()V
          //   1229: aload_0
          //   1230: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1233: iconst_1
          //   1234: invokestatic 319	com/tencent/mm/plugin/webview/ui/tools/i:a	(Lcom/tencent/mm/plugin/webview/ui/tools/i;I)V
          //   1237: ldc 28
          //   1239: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1242: return
          //   1243: aload_0
          //   1244: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1247: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1250: getfield 159	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:DIg	Lcom/tencent/mm/plugin/webview/model/ay;
          //   1253: invokevirtual 165	com/tencent/mm/plugin/webview/model/ay:eQG	()Lcom/tencent/mm/plugin/webview/model/ay$d;
          //   1256: iconst_3
          //   1257: anewarray 4	java/lang/Object
          //   1260: dup
          //   1261: iconst_0
          //   1262: aload_0
          //   1263: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1266: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1269: invokevirtual 168	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bQm	()Ljava/lang/String;
          //   1272: aastore
          //   1273: dup
          //   1274: iconst_1
          //   1275: bipush 37
          //   1277: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1280: aastore
          //   1281: dup
          //   1282: iconst_2
          //   1283: iconst_1
          //   1284: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1287: aastore
          //   1288: invokevirtual 174	com/tencent/mm/plugin/webview/model/ay$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ay$d;
          //   1291: invokevirtual 177	com/tencent/mm/plugin/webview/model/ay$d:report	()V
          //   1294: aload_0
          //   1295: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1298: iconst_0
          //   1299: invokestatic 319	com/tencent/mm/plugin/webview/ui/tools/i:a	(Lcom/tencent/mm/plugin/webview/ui/tools/i;I)V
          //   1302: ldc 28
          //   1304: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1307: return
          //   1308: aload_0
          //   1309: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1312: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1315: getfield 159	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:DIg	Lcom/tencent/mm/plugin/webview/model/ay;
          //   1318: invokevirtual 165	com/tencent/mm/plugin/webview/model/ay:eQG	()Lcom/tencent/mm/plugin/webview/model/ay$d;
          //   1321: iconst_3
          //   1322: anewarray 4	java/lang/Object
          //   1325: dup
          //   1326: iconst_0
          //   1327: aload_0
          //   1328: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1331: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1334: invokevirtual 168	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bQm	()Ljava/lang/String;
          //   1337: aastore
          //   1338: dup
          //   1339: iconst_1
          //   1340: iconst_3
          //   1341: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1344: aastore
          //   1345: dup
          //   1346: iconst_2
          //   1347: iconst_1
          //   1348: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1351: aastore
          //   1352: invokevirtual 174	com/tencent/mm/plugin/webview/model/ay$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ay$d;
          //   1355: invokevirtual 177	com/tencent/mm/plugin/webview/model/ay$d:report	()V
          //   1358: getstatic 325	com/tencent/mm/plugin/report/service/g:yhR	Lcom/tencent/mm/plugin/report/service/g;
          //   1361: ldc2_w 326
          //   1364: ldc2_w 328
          //   1367: lconst_1
          //   1368: iconst_0
          //   1369: invokevirtual 333	com/tencent/mm/plugin/report/service/g:idkeyStat	(JJJZ)V
          //   1372: aload_0
          //   1373: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1376: invokevirtual 336	com/tencent/mm/plugin/webview/ui/tools/i:eSi	()V
          //   1379: ldc 28
          //   1381: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1384: return
          //   1385: aload_0
          //   1386: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1389: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1392: getfield 159	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:DIg	Lcom/tencent/mm/plugin/webview/model/ay;
          //   1395: invokevirtual 165	com/tencent/mm/plugin/webview/model/ay:eQG	()Lcom/tencent/mm/plugin/webview/model/ay$d;
          //   1398: iconst_3
          //   1399: anewarray 4	java/lang/Object
          //   1402: dup
          //   1403: iconst_0
          //   1404: aload_0
          //   1405: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1408: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1411: invokevirtual 168	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bQm	()Ljava/lang/String;
          //   1414: aastore
          //   1415: dup
          //   1416: iconst_1
          //   1417: iconst_4
          //   1418: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1421: aastore
          //   1422: dup
          //   1423: iconst_2
          //   1424: iconst_1
          //   1425: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1428: aastore
          //   1429: invokevirtual 174	com/tencent/mm/plugin/webview/model/ay$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ay$d;
          //   1432: invokevirtual 177	com/tencent/mm/plugin/webview/model/ay$d:report	()V
          //   1435: aload_0
          //   1436: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1439: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1442: getfield 339	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Eds	Ljava/util/HashMap;
          //   1445: aload_0
          //   1446: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1449: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1452: getfield 298	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:omW	Lcom/tencent/mm/ui/widget/MMWebView;
          //   1455: invokevirtual 301	com/tencent/mm/ui/widget/MMWebView:getUrl	()Ljava/lang/String;
          //   1458: invokevirtual 309	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
          //   1461: checkcast 341	java/lang/String
          //   1464: astore 4
          //   1466: aload 4
          //   1468: astore_1
          //   1469: aload 4
          //   1471: ifnonnull +19 -> 1490
          //   1474: aload_0
          //   1475: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1478: invokevirtual 234	com/tencent/mm/plugin/webview/ui/tools/a:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1481: invokevirtual 238	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
          //   1484: ldc 250
          //   1486: invokevirtual 246	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
          //   1489: astore_1
          //   1490: aload_0
          //   1491: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1494: ldc_w 343
          //   1497: bipush 43
          //   1499: invokevirtual 347	com/tencent/mm/plugin/webview/ui/tools/i:fP	(Ljava/lang/String;I)V
          //   1502: aload_0
          //   1503: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1506: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1509: aload_1
          //   1510: invokevirtual 350	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:aIR	(Ljava/lang/String;)V
          //   1513: ldc 28
          //   1515: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1518: return
          //   1519: aload_0
          //   1520: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1523: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1526: getfield 159	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:DIg	Lcom/tencent/mm/plugin/webview/model/ay;
          //   1529: invokevirtual 165	com/tencent/mm/plugin/webview/model/ay:eQG	()Lcom/tencent/mm/plugin/webview/model/ay$d;
          //   1532: iconst_3
          //   1533: anewarray 4	java/lang/Object
          //   1536: dup
          //   1537: iconst_0
          //   1538: aload_0
          //   1539: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1542: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1545: invokevirtual 168	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bQm	()Ljava/lang/String;
          //   1548: aastore
          //   1549: dup
          //   1550: iconst_1
          //   1551: bipush 8
          //   1553: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1556: aastore
          //   1557: dup
          //   1558: iconst_2
          //   1559: iconst_1
          //   1560: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1563: aastore
          //   1564: invokevirtual 174	com/tencent/mm/plugin/webview/model/ay$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ay$d;
          //   1567: invokevirtual 177	com/tencent/mm/plugin/webview/model/ay$d:report	()V
          //   1570: aload_0
          //   1571: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1574: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1577: getfield 354	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:EcG	Landroid/view/View;
          //   1580: invokevirtual 359	android/view/View:getVisibility	()I
          //   1583: bipush 8
          //   1585: if_icmpne +51 -> 1636
          //   1588: aload_0
          //   1589: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1592: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1595: ldc_w 360
          //   1598: invokestatic 366	android/view/animation/AnimationUtils:loadAnimation	(Landroid/content/Context;I)Landroid/view/animation/Animation;
          //   1601: astore_1
          //   1602: aload_0
          //   1603: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1606: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1609: getfield 354	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:EcG	Landroid/view/View;
          //   1612: aload_1
          //   1613: invokevirtual 370	android/view/View:startAnimation	(Landroid/view/animation/Animation;)V
          //   1616: aload_0
          //   1617: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1620: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1623: getfield 354	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:EcG	Landroid/view/View;
          //   1626: iconst_0
          //   1627: invokevirtual 373	android/view/View:setVisibility	(I)V
          //   1630: ldc 28
          //   1632: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1635: return
          //   1636: aload_0
          //   1637: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1640: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1643: ldc_w 374
          //   1646: invokestatic 366	android/view/animation/AnimationUtils:loadAnimation	(Landroid/content/Context;I)Landroid/view/animation/Animation;
          //   1649: astore_1
          //   1650: aload_1
          //   1651: new 13	com/tencent/mm/plugin/webview/ui/tools/i$12$1
          //   1654: dup
          //   1655: aload_0
          //   1656: invokespecial 377	com/tencent/mm/plugin/webview/ui/tools/i$12$1:<init>	(Lcom/tencent/mm/plugin/webview/ui/tools/i$12;)V
          //   1659: invokevirtual 383	android/view/animation/Animation:setAnimationListener	(Landroid/view/animation/Animation$AnimationListener;)V
          //   1662: aload_0
          //   1663: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1666: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1669: getfield 354	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:EcG	Landroid/view/View;
          //   1672: aload_1
          //   1673: invokevirtual 370	android/view/View:startAnimation	(Landroid/view/animation/Animation;)V
          //   1676: aload_0
          //   1677: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1680: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1683: getfield 354	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:EcG	Landroid/view/View;
          //   1686: bipush 8
          //   1688: invokevirtual 373	android/view/View:setVisibility	(I)V
          //   1691: ldc 28
          //   1693: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1696: return
          //   1697: aload_0
          //   1698: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1701: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1704: getfield 159	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:DIg	Lcom/tencent/mm/plugin/webview/model/ay;
          //   1707: invokevirtual 165	com/tencent/mm/plugin/webview/model/ay:eQG	()Lcom/tencent/mm/plugin/webview/model/ay$d;
          //   1710: iconst_3
          //   1711: anewarray 4	java/lang/Object
          //   1714: dup
          //   1715: iconst_0
          //   1716: aload_0
          //   1717: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1720: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1723: invokevirtual 168	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bQm	()Ljava/lang/String;
          //   1726: aastore
          //   1727: dup
          //   1728: iconst_1
          //   1729: bipush 10
          //   1731: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1734: aastore
          //   1735: dup
          //   1736: iconst_2
          //   1737: iconst_1
          //   1738: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1741: aastore
          //   1742: invokevirtual 174	com/tencent/mm/plugin/webview/model/ay$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ay$d;
          //   1745: invokevirtual 177	com/tencent/mm/plugin/webview/model/ay$d:report	()V
          //   1748: aload_0
          //   1749: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1752: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1755: invokevirtual 386	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:eSX	()V
          //   1758: ldc 28
          //   1760: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1763: return
          //   1764: aload_0
          //   1765: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1768: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1771: getfield 159	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:DIg	Lcom/tencent/mm/plugin/webview/model/ay;
          //   1774: invokevirtual 165	com/tencent/mm/plugin/webview/model/ay:eQG	()Lcom/tencent/mm/plugin/webview/model/ay$d;
          //   1777: iconst_3
          //   1778: anewarray 4	java/lang/Object
          //   1781: dup
          //   1782: iconst_0
          //   1783: aload_0
          //   1784: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1787: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1790: invokevirtual 168	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bQm	()Ljava/lang/String;
          //   1793: aastore
          //   1794: dup
          //   1795: iconst_1
          //   1796: iconst_5
          //   1797: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1800: aastore
          //   1801: dup
          //   1802: iconst_2
          //   1803: iconst_1
          //   1804: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1807: aastore
          //   1808: invokevirtual 174	com/tencent/mm/plugin/webview/model/ay$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ay$d;
          //   1811: invokevirtual 177	com/tencent/mm/plugin/webview/model/ay$d:report	()V
          //   1814: aload_0
          //   1815: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1818: invokestatic 388	com/tencent/mm/plugin/webview/ui/tools/i:a	(Lcom/tencent/mm/plugin/webview/ui/tools/i;)V
          //   1821: ldc 28
          //   1823: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1826: return
          //   1827: aload_0
          //   1828: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1831: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1834: getfield 159	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:DIg	Lcom/tencent/mm/plugin/webview/model/ay;
          //   1837: invokevirtual 165	com/tencent/mm/plugin/webview/model/ay:eQG	()Lcom/tencent/mm/plugin/webview/model/ay$d;
          //   1840: iconst_3
          //   1841: anewarray 4	java/lang/Object
          //   1844: dup
          //   1845: iconst_0
          //   1846: aload_0
          //   1847: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1850: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1853: invokevirtual 168	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bQm	()Ljava/lang/String;
          //   1856: aastore
          //   1857: dup
          //   1858: iconst_1
          //   1859: bipush 13
          //   1861: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1864: aastore
          //   1865: dup
          //   1866: iconst_2
          //   1867: iconst_1
          //   1868: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1871: aastore
          //   1872: invokevirtual 174	com/tencent/mm/plugin/webview/model/ay$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ay$d;
          //   1875: invokevirtual 177	com/tencent/mm/plugin/webview/model/ay$d:report	()V
          //   1878: aload_0
          //   1879: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   1882: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1885: astore 5
          //   1887: aload 5
          //   1889: getfield 392	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:EaP	Lcom/tencent/mm/plugin/webview/modeltools/a;
          //   1892: astore 6
          //   1894: aload 5
          //   1896: getfield 393	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:lvv	Lcom/tencent/mm/plugin/webview/stub/e;
          //   1899: astore 7
          //   1901: aload 5
          //   1903: invokevirtual 396	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:isFinishing	()Z
          //   1906: ifne +214 -> 2120
          //   1909: aload 5
          //   1911: invokevirtual 399	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:eNy	()Ljava/lang/String;
          //   1914: astore 4
          //   1916: aload 4
          //   1918: invokestatic 191	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
          //   1921: ifeq +18 -> 1939
          //   1924: ldc_w 401
          //   1927: ldc_w 403
          //   1930: invokestatic 74	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   1933: ldc 28
          //   1935: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1938: return
          //   1939: aload 4
          //   1941: astore_1
          //   1942: aload 7
          //   1944: ifnull +13 -> 1957
          //   1947: aload 7
          //   1949: aload 4
          //   1951: invokeinterface 406 2 0
          //   1956: astore_1
          //   1957: aload_1
          //   1958: astore 4
          //   1960: aload_1
          //   1961: ldc_w 408
          //   1964: invokevirtual 411	java/lang/String:startsWith	(Ljava/lang/String;)Z
          //   1967: ifne +28 -> 1995
          //   1970: aload_1
          //   1971: astore 4
          //   1973: aload_1
          //   1974: ldc_w 413
          //   1977: invokevirtual 411	java/lang/String:startsWith	(Ljava/lang/String;)Z
          //   1980: ifne +15 -> 1995
          //   1983: ldc_w 408
          //   1986: aload_1
          //   1987: invokestatic 416	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
          //   1990: invokevirtual 419	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
          //   1993: astore 4
          //   1995: new 242	android/content/Intent
          //   1998: dup
          //   1999: ldc_w 421
          //   2002: aload 4
          //   2004: invokestatic 427	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
          //   2007: invokespecial 430	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
          //   2010: astore_1
          //   2011: aload 5
          //   2013: invokestatic 434	com/tencent/mm/sdk/platformtools/bt:jk	(Landroid/content/Context;)Z
          //   2016: ifne +9 -> 2025
          //   2019: invokestatic 439	com/tencent/mm/sdk/platformtools/j:fjZ	()Z
          //   2022: ifeq +209 -> 2231
          //   2025: ldc_w 401
          //   2028: ldc_w 441
          //   2031: iconst_2
          //   2032: anewarray 4	java/lang/Object
          //   2035: dup
          //   2036: iconst_0
          //   2037: aload 5
          //   2039: invokestatic 434	com/tencent/mm/sdk/platformtools/bt:jk	(Landroid/content/Context;)Z
          //   2042: invokestatic 446	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
          //   2045: aastore
          //   2046: dup
          //   2047: iconst_1
          //   2048: invokestatic 439	com/tencent/mm/sdk/platformtools/j:fjZ	()Z
          //   2051: invokestatic 446	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
          //   2054: aastore
          //   2055: invokestatic 155	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   2058: bipush 29
          //   2060: invokestatic 452	com/tencent/mm/compatible/util/d:ly	(I)Z
          //   2063: ifeq +87 -> 2150
          //   2066: aload 5
          //   2068: iconst_0
          //   2069: aload_1
          //   2070: ldc_w 453
          //   2073: invokestatic 459	android/app/PendingIntent:getActivity	(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;
          //   2076: aload 5
          //   2078: iconst_1
          //   2079: aconst_null
          //   2080: new 461	com/tencent/mm/plugin/webview/modeltools/a$1
          //   2083: dup
          //   2084: aload 6
          //   2086: invokespecial 464	com/tencent/mm/plugin/webview/modeltools/a$1:<init>	(Lcom/tencent/mm/plugin/webview/modeltools/a;)V
          //   2089: aconst_null
          //   2090: invokevirtual 468	android/app/PendingIntent:send	(Landroid/content/Context;ILandroid/content/Intent;Landroid/app/PendingIntent$OnFinished;Landroid/os/Handler;)V
          //   2093: ldc 28
          //   2095: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   2098: return
          //   2099: astore_1
          //   2100: ldc_w 401
          //   2103: ldc_w 470
          //   2106: iconst_1
          //   2107: anewarray 4	java/lang/Object
          //   2110: dup
          //   2111: iconst_0
          //   2112: aload_1
          //   2113: invokevirtual 473	java/lang/Exception:getMessage	()Ljava/lang/String;
          //   2116: aastore
          //   2117: invokestatic 475	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   2120: ldc 28
          //   2122: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   2125: return
          //   2126: astore_1
          //   2127: ldc_w 401
          //   2130: ldc_w 477
          //   2133: iconst_1
          //   2134: anewarray 4	java/lang/Object
          //   2137: dup
          //   2138: iconst_0
          //   2139: aload_1
          //   2140: aastore
          //   2141: invokestatic 475	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   2144: aload 4
          //   2146: astore_1
          //   2147: goto -190 -> 1957
          //   2150: new 479	com/tencent/mm/hellhoundlib/b/a
          //   2153: dup
          //   2154: invokespecial 480	com/tencent/mm/hellhoundlib/b/a:<init>	()V
          //   2157: aload_1
          //   2158: invokevirtual 484	com/tencent/mm/hellhoundlib/b/a:bc	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
          //   2161: astore_1
          //   2162: aload 5
          //   2164: aload_1
          //   2165: invokevirtual 488	com/tencent/mm/hellhoundlib/b/a:ahp	()[Ljava/lang/Object;
          //   2168: ldc_w 490
          //   2171: ldc_w 492
          //   2174: ldc_w 494
          //   2177: ldc_w 496
          //   2180: ldc_w 498
          //   2183: ldc_w 500
          //   2186: invokestatic 505	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
          //   2189: aload 5
          //   2191: aload_1
          //   2192: iconst_0
          //   2193: invokevirtual 509	com/tencent/mm/hellhoundlib/b/a:mq	(I)Ljava/lang/Object;
          //   2196: checkcast 242	android/content/Intent
          //   2199: invokevirtual 511	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:startActivity	(Landroid/content/Intent;)V
          //   2202: aload 5
          //   2204: ldc_w 490
          //   2207: ldc_w 492
          //   2210: ldc_w 494
          //   2213: ldc_w 496
          //   2216: ldc_w 498
          //   2219: ldc_w 500
          //   2222: invokestatic 514	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
          //   2225: ldc 28
          //   2227: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   2230: return
          //   2231: aload 5
          //   2233: aload 5
          //   2235: aload_1
          //   2236: aload 4
          //   2238: invokestatic 519	com/tencent/mm/plugin/webview/modeltools/a:a	(Landroid/app/Activity;Landroid/content/Intent;Ljava/lang/String;)Landroid/content/Intent;
          //   2241: iconst_2
          //   2242: invokevirtual 523	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:startActivityForResult	(Landroid/content/Intent;I)V
          //   2245: ldc 28
          //   2247: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   2250: return
          //   2251: aload_0
          //   2252: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   2255: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2258: getfield 159	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:DIg	Lcom/tencent/mm/plugin/webview/model/ay;
          //   2261: invokevirtual 165	com/tencent/mm/plugin/webview/model/ay:eQG	()Lcom/tencent/mm/plugin/webview/model/ay$d;
          //   2264: iconst_3
          //   2265: anewarray 4	java/lang/Object
          //   2268: dup
          //   2269: iconst_0
          //   2270: aload_0
          //   2271: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   2274: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2277: invokevirtual 168	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bQm	()Ljava/lang/String;
          //   2280: aastore
          //   2281: dup
          //   2282: iconst_1
          //   2283: bipush 35
          //   2285: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   2288: aastore
          //   2289: dup
          //   2290: iconst_2
          //   2291: iconst_1
          //   2292: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   2295: aastore
          //   2296: invokevirtual 174	com/tencent/mm/plugin/webview/model/ay$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ay$d;
          //   2299: invokevirtual 177	com/tencent/mm/plugin/webview/model/ay$d:report	()V
          //   2302: aload_0
          //   2303: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   2306: invokestatic 525	com/tencent/mm/plugin/webview/ui/tools/i:b	(Lcom/tencent/mm/plugin/webview/ui/tools/i;)V
          //   2309: ldc 28
          //   2311: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   2314: return
          //   2315: aload_0
          //   2316: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   2319: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2322: getfield 159	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:DIg	Lcom/tencent/mm/plugin/webview/model/ay;
          //   2325: invokevirtual 165	com/tencent/mm/plugin/webview/model/ay:eQG	()Lcom/tencent/mm/plugin/webview/model/ay$d;
          //   2328: iconst_3
          //   2329: anewarray 4	java/lang/Object
          //   2332: dup
          //   2333: iconst_0
          //   2334: aload_0
          //   2335: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   2338: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2341: invokevirtual 168	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bQm	()Ljava/lang/String;
          //   2344: aastore
          //   2345: dup
          //   2346: iconst_1
          //   2347: bipush 15
          //   2349: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   2352: aastore
          //   2353: dup
          //   2354: iconst_2
          //   2355: iconst_1
          //   2356: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   2359: aastore
          //   2360: invokevirtual 174	com/tencent/mm/plugin/webview/model/ay$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ay$d;
          //   2363: invokevirtual 177	com/tencent/mm/plugin/webview/model/ay$d:report	()V
          //   2366: aload_0
          //   2367: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   2370: astore_1
          //   2371: aload_1
          //   2372: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2375: getfield 60	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:DzP	Lcom/tencent/mm/plugin/webview/c/f;
          //   2378: ldc_w 527
          //   2381: iconst_1
          //   2382: invokevirtual 531	com/tencent/mm/plugin/webview/c/f:cn	(Ljava/lang/String;Z)V
          //   2385: aload_1
          //   2386: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2389: getfield 60	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:DzP	Lcom/tencent/mm/plugin/webview/c/f;
          //   2392: astore_1
          //   2393: aload_1
          //   2394: getfield 65	com/tencent/mm/plugin/webview/c/f:BHY	Z
          //   2397: ifne +17 -> 2414
          //   2400: ldc 67
          //   2402: ldc_w 533
          //   2405: invokestatic 74	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   2408: ldc 28
          //   2410: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   2413: return
          //   2414: ldc_w 535
          //   2417: new 83	java/util/HashMap
          //   2420: dup
          //   2421: invokespecial 84	java/util/HashMap:<init>	()V
          //   2424: aload_1
          //   2425: getfield 102	com/tencent/mm/plugin/webview/c/f:DMD	Z
          //   2428: aload_1
          //   2429: getfield 105	com/tencent/mm/plugin/webview/c/f:vJP	Ljava/lang/String;
          //   2432: invokestatic 111	com/tencent/mm/plugin/webview/c/l$a:b	(Ljava/lang/String;Ljava/util/Map;ZLjava/lang/String;)Ljava/lang/String;
          //   2435: astore 4
          //   2437: aload_1
          //   2438: getfield 115	com/tencent/mm/plugin/webview/c/f:DMv	Lcom/tencent/mm/ui/widget/MMWebView;
          //   2441: new 117	java/lang/StringBuilder
          //   2444: dup
          //   2445: ldc 119
          //   2447: invokespecial 122	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   2450: aload 4
          //   2452: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   2455: ldc 128
          //   2457: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   2460: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   2463: aconst_null
          //   2464: invokevirtual 138	com/tencent/mm/ui/widget/MMWebView:evaluateJavascript	(Ljava/lang/String;Landroid/webkit/ValueCallback;)V
          //   2467: ldc 28
          //   2469: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   2472: return
          //   2473: aload_0
          //   2474: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   2477: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2480: getfield 159	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:DIg	Lcom/tencent/mm/plugin/webview/model/ay;
          //   2483: invokevirtual 165	com/tencent/mm/plugin/webview/model/ay:eQG	()Lcom/tencent/mm/plugin/webview/model/ay$d;
          //   2486: iconst_3
          //   2487: anewarray 4	java/lang/Object
          //   2490: dup
          //   2491: iconst_0
          //   2492: aload_0
          //   2493: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   2496: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2499: invokevirtual 168	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bQm	()Ljava/lang/String;
          //   2502: aastore
          //   2503: dup
          //   2504: iconst_1
          //   2505: bipush 7
          //   2507: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   2510: aastore
          //   2511: dup
          //   2512: iconst_2
          //   2513: iconst_1
          //   2514: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   2517: aastore
          //   2518: invokevirtual 174	com/tencent/mm/plugin/webview/model/ay$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ay$d;
          //   2521: invokevirtual 177	com/tencent/mm/plugin/webview/model/ay$d:report	()V
          //   2524: aload_0
          //   2525: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   2528: astore_1
          //   2529: aload_1
          //   2530: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2533: aload_1
          //   2534: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2537: ldc_w 536
          //   2540: invokevirtual 540	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
          //   2543: aconst_null
          //   2544: aconst_null
          //   2545: aload_1
          //   2546: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2549: ldc_w 541
          //   2552: invokevirtual 540	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
          //   2555: new 543	com/tencent/mm/plugin/webview/ui/tools/i$7
          //   2558: dup
          //   2559: aload_1
          //   2560: invokespecial 545	com/tencent/mm/plugin/webview/ui/tools/i$7:<init>	(Lcom/tencent/mm/plugin/webview/ui/tools/i;)V
          //   2563: invokestatic 550	com/tencent/mm/ui/base/h:a	(Landroid/content/Context;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Lcom/tencent/mm/ui/base/h$d;)Landroid/app/Dialog;
          //   2566: pop
          //   2567: ldc 28
          //   2569: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   2572: return
          //   2573: aload_0
          //   2574: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   2577: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2580: getfield 159	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:DIg	Lcom/tencent/mm/plugin/webview/model/ay;
          //   2583: invokevirtual 165	com/tencent/mm/plugin/webview/model/ay:eQG	()Lcom/tencent/mm/plugin/webview/model/ay$d;
          //   2586: iconst_3
          //   2587: anewarray 4	java/lang/Object
          //   2590: dup
          //   2591: iconst_0
          //   2592: aload_0
          //   2593: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   2596: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2599: invokevirtual 168	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bQm	()Ljava/lang/String;
          //   2602: aastore
          //   2603: dup
          //   2604: iconst_1
          //   2605: bipush 11
          //   2607: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   2610: aastore
          //   2611: dup
          //   2612: iconst_2
          //   2613: iconst_1
          //   2614: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   2617: aastore
          //   2618: invokevirtual 174	com/tencent/mm/plugin/webview/model/ay$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ay$d;
          //   2621: invokevirtual 177	com/tencent/mm/plugin/webview/model/ay$d:report	()V
          //   2624: aload_0
          //   2625: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   2628: aconst_null
          //   2629: invokevirtual 553	com/tencent/mm/plugin/webview/ui/tools/i:aIN	(Ljava/lang/String;)V
          //   2632: ldc 28
          //   2634: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   2637: return
          //   2638: aload_0
          //   2639: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   2642: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2645: getfield 159	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:DIg	Lcom/tencent/mm/plugin/webview/model/ay;
          //   2648: invokevirtual 165	com/tencent/mm/plugin/webview/model/ay:eQG	()Lcom/tencent/mm/plugin/webview/model/ay$d;
          //   2651: iconst_3
          //   2652: anewarray 4	java/lang/Object
          //   2655: dup
          //   2656: iconst_0
          //   2657: aload_0
          //   2658: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   2661: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2664: invokevirtual 168	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bQm	()Ljava/lang/String;
          //   2667: aastore
          //   2668: dup
          //   2669: iconst_1
          //   2670: bipush 6
          //   2672: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   2675: aastore
          //   2676: dup
          //   2677: iconst_2
          //   2678: iconst_1
          //   2679: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   2682: aastore
          //   2683: invokevirtual 174	com/tencent/mm/plugin/webview/model/ay$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ay$d;
          //   2686: invokevirtual 177	com/tencent/mm/plugin/webview/model/ay$d:report	()V
          //   2689: new 242	android/content/Intent
          //   2692: dup
          //   2693: invokespecial 254	android/content/Intent:<init>	()V
          //   2696: astore_1
          //   2697: aload_1
          //   2698: ldc_w 555
          //   2701: iconst_2
          //   2702: invokevirtual 558	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
          //   2705: pop
          //   2706: aload_1
          //   2707: ldc_w 560
          //   2710: aload_0
          //   2711: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   2714: invokevirtual 234	com/tencent/mm/plugin/webview/ui/tools/a:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2717: invokevirtual 238	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
          //   2720: ldc_w 562
          //   2723: ldc2_w 563
          //   2726: invokevirtual 283	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
          //   2729: invokevirtual 567	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
          //   2732: pop
          //   2733: aload_0
          //   2734: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   2737: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2740: ldc_w 569
          //   2743: aload_1
          //   2744: invokestatic 573	com/tencent/mm/plugin/fav/a/b:b	(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;)V
          //   2747: aload_0
          //   2748: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   2751: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2754: getfield 159	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:DIg	Lcom/tencent/mm/plugin/webview/model/ay;
          //   2757: ldc_w 575
          //   2760: invokevirtual 578	com/tencent/mm/plugin/webview/model/ay:aHE	(Ljava/lang/String;)V
          //   2763: ldc 28
          //   2765: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   2768: return
          //   2769: aload_0
          //   2770: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   2773: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2776: getfield 159	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:DIg	Lcom/tencent/mm/plugin/webview/model/ay;
          //   2779: invokevirtual 165	com/tencent/mm/plugin/webview/model/ay:eQG	()Lcom/tencent/mm/plugin/webview/model/ay$d;
          //   2782: iconst_3
          //   2783: anewarray 4	java/lang/Object
          //   2786: dup
          //   2787: iconst_0
          //   2788: aload_0
          //   2789: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   2792: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2795: invokevirtual 168	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bQm	()Ljava/lang/String;
          //   2798: aastore
          //   2799: dup
          //   2800: iconst_1
          //   2801: bipush 19
          //   2803: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   2806: aastore
          //   2807: dup
          //   2808: iconst_2
          //   2809: iconst_1
          //   2810: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   2813: aastore
          //   2814: invokevirtual 174	com/tencent/mm/plugin/webview/model/ay$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ay$d;
          //   2817: invokevirtual 177	com/tencent/mm/plugin/webview/model/ay$d:report	()V
          //   2820: aload_0
          //   2821: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   2824: aload_1
          //   2825: invokestatic 581	com/tencent/mm/plugin/webview/ui/tools/i:a	(Lcom/tencent/mm/plugin/webview/ui/tools/i;Landroid/view/MenuItem;)V
          //   2828: ldc 28
          //   2830: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   2833: return
          //   2834: aload_0
          //   2835: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   2838: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2841: getfield 159	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:DIg	Lcom/tencent/mm/plugin/webview/model/ay;
          //   2844: invokevirtual 165	com/tencent/mm/plugin/webview/model/ay:eQG	()Lcom/tencent/mm/plugin/webview/model/ay$d;
          //   2847: iconst_3
          //   2848: anewarray 4	java/lang/Object
          //   2851: dup
          //   2852: iconst_0
          //   2853: aload_0
          //   2854: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   2857: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2860: invokevirtual 168	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bQm	()Ljava/lang/String;
          //   2863: aastore
          //   2864: dup
          //   2865: iconst_1
          //   2866: bipush 21
          //   2868: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   2871: aastore
          //   2872: dup
          //   2873: iconst_2
          //   2874: iconst_1
          //   2875: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   2878: aastore
          //   2879: invokevirtual 174	com/tencent/mm/plugin/webview/model/ay$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ay$d;
          //   2882: invokevirtual 177	com/tencent/mm/plugin/webview/model/ay$d:report	()V
          //   2885: aload_0
          //   2886: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   2889: aload_1
          //   2890: invokestatic 581	com/tencent/mm/plugin/webview/ui/tools/i:a	(Lcom/tencent/mm/plugin/webview/ui/tools/i;Landroid/view/MenuItem;)V
          //   2893: ldc 28
          //   2895: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   2898: return
          //   2899: aload_0
          //   2900: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   2903: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2906: getfield 159	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:DIg	Lcom/tencent/mm/plugin/webview/model/ay;
          //   2909: invokevirtual 165	com/tencent/mm/plugin/webview/model/ay:eQG	()Lcom/tencent/mm/plugin/webview/model/ay$d;
          //   2912: iconst_3
          //   2913: anewarray 4	java/lang/Object
          //   2916: dup
          //   2917: iconst_0
          //   2918: aload_0
          //   2919: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   2922: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2925: invokevirtual 168	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bQm	()Ljava/lang/String;
          //   2928: aastore
          //   2929: dup
          //   2930: iconst_1
          //   2931: bipush 20
          //   2933: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   2936: aastore
          //   2937: dup
          //   2938: iconst_2
          //   2939: iconst_1
          //   2940: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   2943: aastore
          //   2944: invokevirtual 174	com/tencent/mm/plugin/webview/model/ay$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ay$d;
          //   2947: invokevirtual 177	com/tencent/mm/plugin/webview/model/ay$d:report	()V
          //   2950: aload_0
          //   2951: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   2954: aload_1
          //   2955: invokestatic 581	com/tencent/mm/plugin/webview/ui/tools/i:a	(Lcom/tencent/mm/plugin/webview/ui/tools/i;Landroid/view/MenuItem;)V
          //   2958: ldc 28
          //   2960: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   2963: return
          //   2964: aload_0
          //   2965: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   2968: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2971: getfield 159	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:DIg	Lcom/tencent/mm/plugin/webview/model/ay;
          //   2974: invokevirtual 165	com/tencent/mm/plugin/webview/model/ay:eQG	()Lcom/tencent/mm/plugin/webview/model/ay$d;
          //   2977: iconst_3
          //   2978: anewarray 4	java/lang/Object
          //   2981: dup
          //   2982: iconst_0
          //   2983: aload_0
          //   2984: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   2987: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2990: invokevirtual 168	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bQm	()Ljava/lang/String;
          //   2993: aastore
          //   2994: dup
          //   2995: iconst_1
          //   2996: bipush 22
          //   2998: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3001: aastore
          //   3002: dup
          //   3003: iconst_2
          //   3004: iconst_1
          //   3005: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3008: aastore
          //   3009: invokevirtual 174	com/tencent/mm/plugin/webview/model/ay$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ay$d;
          //   3012: invokevirtual 177	com/tencent/mm/plugin/webview/model/ay$d:report	()V
          //   3015: aload_0
          //   3016: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   3019: aload_1
          //   3020: invokestatic 581	com/tencent/mm/plugin/webview/ui/tools/i:a	(Lcom/tencent/mm/plugin/webview/ui/tools/i;Landroid/view/MenuItem;)V
          //   3023: ldc 28
          //   3025: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   3028: return
          //   3029: aload_0
          //   3030: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   3033: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3036: getfield 159	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:DIg	Lcom/tencent/mm/plugin/webview/model/ay;
          //   3039: invokevirtual 165	com/tencent/mm/plugin/webview/model/ay:eQG	()Lcom/tencent/mm/plugin/webview/model/ay$d;
          //   3042: iconst_3
          //   3043: anewarray 4	java/lang/Object
          //   3046: dup
          //   3047: iconst_0
          //   3048: aload_0
          //   3049: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   3052: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3055: invokevirtual 168	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bQm	()Ljava/lang/String;
          //   3058: aastore
          //   3059: dup
          //   3060: iconst_1
          //   3061: bipush 23
          //   3063: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3066: aastore
          //   3067: dup
          //   3068: iconst_2
          //   3069: iconst_1
          //   3070: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3073: aastore
          //   3074: invokevirtual 174	com/tencent/mm/plugin/webview/model/ay$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ay$d;
          //   3077: invokevirtual 177	com/tencent/mm/plugin/webview/model/ay$d:report	()V
          //   3080: aload_0
          //   3081: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   3084: aload_1
          //   3085: invokestatic 581	com/tencent/mm/plugin/webview/ui/tools/i:a	(Lcom/tencent/mm/plugin/webview/ui/tools/i;Landroid/view/MenuItem;)V
          //   3088: ldc 28
          //   3090: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   3093: return
          //   3094: aload_0
          //   3095: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   3098: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3101: getfield 159	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:DIg	Lcom/tencent/mm/plugin/webview/model/ay;
          //   3104: invokevirtual 165	com/tencent/mm/plugin/webview/model/ay:eQG	()Lcom/tencent/mm/plugin/webview/model/ay$d;
          //   3107: iconst_3
          //   3108: anewarray 4	java/lang/Object
          //   3111: dup
          //   3112: iconst_0
          //   3113: aload_0
          //   3114: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   3117: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3120: invokevirtual 168	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bQm	()Ljava/lang/String;
          //   3123: aastore
          //   3124: dup
          //   3125: iconst_1
          //   3126: bipush 26
          //   3128: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3131: aastore
          //   3132: dup
          //   3133: iconst_2
          //   3134: iconst_1
          //   3135: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3138: aastore
          //   3139: invokevirtual 174	com/tencent/mm/plugin/webview/model/ay$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ay$d;
          //   3142: invokevirtual 177	com/tencent/mm/plugin/webview/model/ay$d:report	()V
          //   3145: aload_0
          //   3146: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   3149: astore_1
          //   3150: aload_1
          //   3151: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3154: getfield 60	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:DzP	Lcom/tencent/mm/plugin/webview/c/f;
          //   3157: ldc_w 583
          //   3160: iconst_1
          //   3161: invokevirtual 531	com/tencent/mm/plugin/webview/c/f:cn	(Ljava/lang/String;Z)V
          //   3164: aload_1
          //   3165: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3168: getfield 60	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:DzP	Lcom/tencent/mm/plugin/webview/c/f;
          //   3171: astore_1
          //   3172: aload_1
          //   3173: getfield 65	com/tencent/mm/plugin/webview/c/f:BHY	Z
          //   3176: ifne +17 -> 3193
          //   3179: ldc 67
          //   3181: ldc_w 585
          //   3184: invokestatic 74	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   3187: ldc 28
          //   3189: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   3192: return
          //   3193: ldc_w 587
          //   3196: new 83	java/util/HashMap
          //   3199: dup
          //   3200: invokespecial 84	java/util/HashMap:<init>	()V
          //   3203: aload_1
          //   3204: getfield 102	com/tencent/mm/plugin/webview/c/f:DMD	Z
          //   3207: aload_1
          //   3208: getfield 105	com/tencent/mm/plugin/webview/c/f:vJP	Ljava/lang/String;
          //   3211: invokestatic 111	com/tencent/mm/plugin/webview/c/l$a:b	(Ljava/lang/String;Ljava/util/Map;ZLjava/lang/String;)Ljava/lang/String;
          //   3214: astore 4
          //   3216: aload_1
          //   3217: getfield 115	com/tencent/mm/plugin/webview/c/f:DMv	Lcom/tencent/mm/ui/widget/MMWebView;
          //   3220: new 117	java/lang/StringBuilder
          //   3223: dup
          //   3224: ldc 119
          //   3226: invokespecial 122	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   3229: aload 4
          //   3231: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   3234: ldc 128
          //   3236: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   3239: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   3242: aconst_null
          //   3243: invokevirtual 138	com/tencent/mm/ui/widget/MMWebView:evaluateJavascript	(Ljava/lang/String;Landroid/webkit/ValueCallback;)V
          //   3246: aload_1
          //   3247: getfield 588	com/tencent/mm/plugin/webview/c/f:lvv	Lcom/tencent/mm/plugin/webview/stub/e;
          //   3250: ldc_w 590
          //   3253: ldc_w 592
          //   3256: aload_1
          //   3257: getfield 596	com/tencent/mm/plugin/webview/c/f:DMF	I
          //   3260: invokeinterface 600 4 0
          //   3265: ldc 28
          //   3267: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   3270: return
          //   3271: astore_1
          //   3272: ldc 67
          //   3274: new 117	java/lang/StringBuilder
          //   3277: dup
          //   3278: ldc_w 602
          //   3281: invokespecial 122	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   3284: aload_1
          //   3285: invokevirtual 473	java/lang/Exception:getMessage	()Ljava/lang/String;
          //   3288: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   3291: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   3294: invokestatic 605	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
          //   3297: ldc 28
          //   3299: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   3302: return
          //   3303: aload_0
          //   3304: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   3307: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3310: getfield 159	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:DIg	Lcom/tencent/mm/plugin/webview/model/ay;
          //   3313: invokevirtual 165	com/tencent/mm/plugin/webview/model/ay:eQG	()Lcom/tencent/mm/plugin/webview/model/ay$d;
          //   3316: iconst_3
          //   3317: anewarray 4	java/lang/Object
          //   3320: dup
          //   3321: iconst_0
          //   3322: aload_0
          //   3323: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   3326: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3329: invokevirtual 168	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bQm	()Ljava/lang/String;
          //   3332: aastore
          //   3333: dup
          //   3334: iconst_1
          //   3335: bipush 27
          //   3337: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3340: aastore
          //   3341: dup
          //   3342: iconst_2
          //   3343: iconst_1
          //   3344: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3347: aastore
          //   3348: invokevirtual 174	com/tencent/mm/plugin/webview/model/ay$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ay$d;
          //   3351: invokevirtual 177	com/tencent/mm/plugin/webview/model/ay$d:report	()V
          //   3354: aload_0
          //   3355: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   3358: invokestatic 608	com/tencent/mm/plugin/webview/ui/tools/i:c	(Lcom/tencent/mm/plugin/webview/ui/tools/i;)V
          //   3361: ldc 28
          //   3363: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   3366: return
          //   3367: aload_0
          //   3368: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   3371: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3374: getfield 159	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:DIg	Lcom/tencent/mm/plugin/webview/model/ay;
          //   3377: invokevirtual 165	com/tencent/mm/plugin/webview/model/ay:eQG	()Lcom/tencent/mm/plugin/webview/model/ay$d;
          //   3380: iconst_3
          //   3381: anewarray 4	java/lang/Object
          //   3384: dup
          //   3385: iconst_0
          //   3386: aload_0
          //   3387: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   3390: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3393: invokevirtual 168	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bQm	()Ljava/lang/String;
          //   3396: aastore
          //   3397: dup
          //   3398: iconst_1
          //   3399: bipush 17
          //   3401: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3404: aastore
          //   3405: dup
          //   3406: iconst_2
          //   3407: iconst_1
          //   3408: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3411: aastore
          //   3412: invokevirtual 174	com/tencent/mm/plugin/webview/model/ay$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ay$d;
          //   3415: invokevirtual 177	com/tencent/mm/plugin/webview/model/ay$d:report	()V
          //   3418: aload_0
          //   3419: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   3422: astore_1
          //   3423: aload_1
          //   3424: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3427: getfield 60	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:DzP	Lcom/tencent/mm/plugin/webview/c/f;
          //   3430: ldc_w 610
          //   3433: iconst_1
          //   3434: invokevirtual 531	com/tencent/mm/plugin/webview/c/f:cn	(Ljava/lang/String;Z)V
          //   3437: aload_1
          //   3438: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3441: getfield 60	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:DzP	Lcom/tencent/mm/plugin/webview/c/f;
          //   3444: astore_1
          //   3445: aload_1
          //   3446: getfield 65	com/tencent/mm/plugin/webview/c/f:BHY	Z
          //   3449: ifne +17 -> 3466
          //   3452: ldc 67
          //   3454: ldc_w 612
          //   3457: invokestatic 74	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   3460: ldc 28
          //   3462: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   3465: return
          //   3466: aload_1
          //   3467: iconst_1
          //   3468: invokevirtual 616	com/tencent/mm/plugin/webview/c/f:WE	(I)Landroid/os/Bundle;
          //   3471: astore 4
          //   3473: aload 4
          //   3475: ifnull +30 -> 3505
          //   3478: aload 4
          //   3480: ldc_w 618
          //   3483: iconst_0
          //   3484: invokevirtual 622	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
          //   3487: ifeq +18 -> 3505
          //   3490: aload_1
          //   3491: aload 4
          //   3493: ldc_w 610
          //   3496: invokevirtual 626	com/tencent/mm/plugin/webview/c/f:h	(Landroid/os/Bundle;Ljava/lang/String;)V
          //   3499: ldc 28
          //   3501: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   3504: return
          //   3505: ldc_w 628
          //   3508: new 83	java/util/HashMap
          //   3511: dup
          //   3512: invokespecial 84	java/util/HashMap:<init>	()V
          //   3515: aload_1
          //   3516: getfield 102	com/tencent/mm/plugin/webview/c/f:DMD	Z
          //   3519: aload_1
          //   3520: getfield 105	com/tencent/mm/plugin/webview/c/f:vJP	Ljava/lang/String;
          //   3523: invokestatic 111	com/tencent/mm/plugin/webview/c/l$a:b	(Ljava/lang/String;Ljava/util/Map;ZLjava/lang/String;)Ljava/lang/String;
          //   3526: astore 4
          //   3528: aload_1
          //   3529: getfield 115	com/tencent/mm/plugin/webview/c/f:DMv	Lcom/tencent/mm/ui/widget/MMWebView;
          //   3532: new 117	java/lang/StringBuilder
          //   3535: dup
          //   3536: ldc 119
          //   3538: invokespecial 122	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   3541: aload 4
          //   3543: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   3546: ldc 128
          //   3548: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   3551: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   3554: aconst_null
          //   3555: invokevirtual 138	com/tencent/mm/ui/widget/MMWebView:evaluateJavascript	(Ljava/lang/String;Landroid/webkit/ValueCallback;)V
          //   3558: ldc 28
          //   3560: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   3563: return
          //   3564: aload_0
          //   3565: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   3568: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3571: getfield 159	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:DIg	Lcom/tencent/mm/plugin/webview/model/ay;
          //   3574: invokevirtual 165	com/tencent/mm/plugin/webview/model/ay:eQG	()Lcom/tencent/mm/plugin/webview/model/ay$d;
          //   3577: iconst_3
          //   3578: anewarray 4	java/lang/Object
          //   3581: dup
          //   3582: iconst_0
          //   3583: aload_0
          //   3584: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   3587: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3590: invokevirtual 168	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bQm	()Ljava/lang/String;
          //   3593: aastore
          //   3594: dup
          //   3595: iconst_1
          //   3596: bipush 18
          //   3598: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3601: aastore
          //   3602: dup
          //   3603: iconst_2
          //   3604: iconst_1
          //   3605: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3608: aastore
          //   3609: invokevirtual 174	com/tencent/mm/plugin/webview/model/ay$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ay$d;
          //   3612: invokevirtual 177	com/tencent/mm/plugin/webview/model/ay$d:report	()V
          //   3615: aload_0
          //   3616: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   3619: astore_1
          //   3620: aload_1
          //   3621: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3624: getfield 60	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:DzP	Lcom/tencent/mm/plugin/webview/c/f;
          //   3627: ldc_w 630
          //   3630: iconst_1
          //   3631: invokevirtual 531	com/tencent/mm/plugin/webview/c/f:cn	(Ljava/lang/String;Z)V
          //   3634: aload_1
          //   3635: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3638: getfield 60	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:DzP	Lcom/tencent/mm/plugin/webview/c/f;
          //   3641: astore_1
          //   3642: aload_1
          //   3643: getfield 65	com/tencent/mm/plugin/webview/c/f:BHY	Z
          //   3646: ifne +17 -> 3663
          //   3649: ldc 67
          //   3651: ldc_w 632
          //   3654: invokestatic 74	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   3657: ldc 28
          //   3659: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   3662: return
          //   3663: ldc_w 634
          //   3666: new 83	java/util/HashMap
          //   3669: dup
          //   3670: invokespecial 84	java/util/HashMap:<init>	()V
          //   3673: aload_1
          //   3674: getfield 102	com/tencent/mm/plugin/webview/c/f:DMD	Z
          //   3677: aload_1
          //   3678: getfield 105	com/tencent/mm/plugin/webview/c/f:vJP	Ljava/lang/String;
          //   3681: invokestatic 111	com/tencent/mm/plugin/webview/c/l$a:b	(Ljava/lang/String;Ljava/util/Map;ZLjava/lang/String;)Ljava/lang/String;
          //   3684: astore 4
          //   3686: aload_1
          //   3687: getfield 115	com/tencent/mm/plugin/webview/c/f:DMv	Lcom/tencent/mm/ui/widget/MMWebView;
          //   3690: new 117	java/lang/StringBuilder
          //   3693: dup
          //   3694: ldc 119
          //   3696: invokespecial 122	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   3699: aload 4
          //   3701: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   3704: ldc 128
          //   3706: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   3709: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   3712: aconst_null
          //   3713: invokevirtual 138	com/tencent/mm/ui/widget/MMWebView:evaluateJavascript	(Ljava/lang/String;Landroid/webkit/ValueCallback;)V
          //   3716: ldc 28
          //   3718: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   3721: return
          //   3722: aload_0
          //   3723: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   3726: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3729: getfield 159	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:DIg	Lcom/tencent/mm/plugin/webview/model/ay;
          //   3732: invokevirtual 165	com/tencent/mm/plugin/webview/model/ay:eQG	()Lcom/tencent/mm/plugin/webview/model/ay$d;
          //   3735: iconst_3
          //   3736: anewarray 4	java/lang/Object
          //   3739: dup
          //   3740: iconst_0
          //   3741: aload_0
          //   3742: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   3745: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3748: invokevirtual 168	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bQm	()Ljava/lang/String;
          //   3751: aastore
          //   3752: dup
          //   3753: iconst_1
          //   3754: bipush 24
          //   3756: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3759: aastore
          //   3760: dup
          //   3761: iconst_2
          //   3762: iconst_1
          //   3763: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3766: aastore
          //   3767: invokevirtual 174	com/tencent/mm/plugin/webview/model/ay$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ay$d;
          //   3770: invokevirtual 177	com/tencent/mm/plugin/webview/model/ay$d:report	()V
          //   3773: aload_0
          //   3774: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   3777: astore_1
          //   3778: aload_1
          //   3779: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3782: getfield 60	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:DzP	Lcom/tencent/mm/plugin/webview/c/f;
          //   3785: ldc_w 636
          //   3788: iconst_1
          //   3789: invokevirtual 531	com/tencent/mm/plugin/webview/c/f:cn	(Ljava/lang/String;Z)V
          //   3792: aload_1
          //   3793: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3796: getfield 60	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:DzP	Lcom/tencent/mm/plugin/webview/c/f;
          //   3799: astore_1
          //   3800: aload_1
          //   3801: getfield 65	com/tencent/mm/plugin/webview/c/f:BHY	Z
          //   3804: ifne +17 -> 3821
          //   3807: ldc 67
          //   3809: ldc_w 638
          //   3812: invokestatic 74	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   3815: ldc 28
          //   3817: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   3820: return
          //   3821: aload_1
          //   3822: iconst_1
          //   3823: invokevirtual 616	com/tencent/mm/plugin/webview/c/f:WE	(I)Landroid/os/Bundle;
          //   3826: astore 4
          //   3828: aload 4
          //   3830: ifnull +30 -> 3860
          //   3833: aload 4
          //   3835: ldc_w 618
          //   3838: iconst_0
          //   3839: invokevirtual 622	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
          //   3842: ifeq +18 -> 3860
          //   3845: aload_1
          //   3846: aload 4
          //   3848: ldc_w 636
          //   3851: invokevirtual 626	com/tencent/mm/plugin/webview/c/f:h	(Landroid/os/Bundle;Ljava/lang/String;)V
          //   3854: ldc 28
          //   3856: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   3859: return
          //   3860: ldc_w 640
          //   3863: new 83	java/util/HashMap
          //   3866: dup
          //   3867: invokespecial 84	java/util/HashMap:<init>	()V
          //   3870: aload_1
          //   3871: getfield 102	com/tencent/mm/plugin/webview/c/f:DMD	Z
          //   3874: aload_1
          //   3875: getfield 105	com/tencent/mm/plugin/webview/c/f:vJP	Ljava/lang/String;
          //   3878: invokestatic 111	com/tencent/mm/plugin/webview/c/l$a:b	(Ljava/lang/String;Ljava/util/Map;ZLjava/lang/String;)Ljava/lang/String;
          //   3881: astore 4
          //   3883: aload_1
          //   3884: getfield 115	com/tencent/mm/plugin/webview/c/f:DMv	Lcom/tencent/mm/ui/widget/MMWebView;
          //   3887: new 117	java/lang/StringBuilder
          //   3890: dup
          //   3891: ldc 119
          //   3893: invokespecial 122	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   3896: aload 4
          //   3898: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   3901: ldc 128
          //   3903: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   3906: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   3909: aconst_null
          //   3910: invokevirtual 138	com/tencent/mm/ui/widget/MMWebView:evaluateJavascript	(Ljava/lang/String;Landroid/webkit/ValueCallback;)V
          //   3913: ldc 28
          //   3915: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   3918: return
          //   3919: aload_0
          //   3920: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   3923: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3926: getfield 159	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:DIg	Lcom/tencent/mm/plugin/webview/model/ay;
          //   3929: invokevirtual 165	com/tencent/mm/plugin/webview/model/ay:eQG	()Lcom/tencent/mm/plugin/webview/model/ay$d;
          //   3932: iconst_3
          //   3933: anewarray 4	java/lang/Object
          //   3936: dup
          //   3937: iconst_0
          //   3938: aload_0
          //   3939: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   3942: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3945: invokevirtual 168	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bQm	()Ljava/lang/String;
          //   3948: aastore
          //   3949: dup
          //   3950: iconst_1
          //   3951: bipush 14
          //   3953: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3956: aastore
          //   3957: dup
          //   3958: iconst_2
          //   3959: iconst_1
          //   3960: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3963: aastore
          //   3964: invokevirtual 174	com/tencent/mm/plugin/webview/model/ay$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ay$d;
          //   3967: invokevirtual 177	com/tencent/mm/plugin/webview/model/ay$d:report	()V
          //   3970: aload_0
          //   3971: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   3974: astore_1
          //   3975: aload_1
          //   3976: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3979: getfield 60	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:DzP	Lcom/tencent/mm/plugin/webview/c/f;
          //   3982: ldc_w 583
          //   3985: iconst_1
          //   3986: invokevirtual 531	com/tencent/mm/plugin/webview/c/f:cn	(Ljava/lang/String;Z)V
          //   3989: aload_1
          //   3990: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3993: getfield 60	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:DzP	Lcom/tencent/mm/plugin/webview/c/f;
          //   3996: astore_1
          //   3997: aload_1
          //   3998: getfield 65	com/tencent/mm/plugin/webview/c/f:BHY	Z
          //   4001: ifne +17 -> 4018
          //   4004: ldc 67
          //   4006: ldc_w 642
          //   4009: invokestatic 74	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   4012: ldc 28
          //   4014: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   4017: return
          //   4018: ldc_w 587
          //   4021: new 83	java/util/HashMap
          //   4024: dup
          //   4025: invokespecial 84	java/util/HashMap:<init>	()V
          //   4028: aload_1
          //   4029: getfield 102	com/tencent/mm/plugin/webview/c/f:DMD	Z
          //   4032: aload_1
          //   4033: getfield 105	com/tencent/mm/plugin/webview/c/f:vJP	Ljava/lang/String;
          //   4036: invokestatic 111	com/tencent/mm/plugin/webview/c/l$a:b	(Ljava/lang/String;Ljava/util/Map;ZLjava/lang/String;)Ljava/lang/String;
          //   4039: astore 4
          //   4041: aload_1
          //   4042: getfield 115	com/tencent/mm/plugin/webview/c/f:DMv	Lcom/tencent/mm/ui/widget/MMWebView;
          //   4045: new 117	java/lang/StringBuilder
          //   4048: dup
          //   4049: ldc 119
          //   4051: invokespecial 122	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   4054: aload 4
          //   4056: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   4059: ldc 128
          //   4061: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   4064: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   4067: aconst_null
          //   4068: invokevirtual 138	com/tencent/mm/ui/widget/MMWebView:evaluateJavascript	(Ljava/lang/String;Landroid/webkit/ValueCallback;)V
          //   4071: aload_1
          //   4072: getfield 588	com/tencent/mm/plugin/webview/c/f:lvv	Lcom/tencent/mm/plugin/webview/stub/e;
          //   4075: ldc_w 590
          //   4078: ldc_w 644
          //   4081: aload_1
          //   4082: getfield 596	com/tencent/mm/plugin/webview/c/f:DMF	I
          //   4085: invokeinterface 600 4 0
          //   4090: ldc 28
          //   4092: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   4095: return
          //   4096: astore_1
          //   4097: ldc 67
          //   4099: new 117	java/lang/StringBuilder
          //   4102: dup
          //   4103: ldc_w 602
          //   4106: invokespecial 122	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   4109: aload_1
          //   4110: invokevirtual 473	java/lang/Exception:getMessage	()Ljava/lang/String;
          //   4113: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   4116: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   4119: invokestatic 605	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
          //   4122: ldc 28
          //   4124: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   4127: return
          //   4128: aload_0
          //   4129: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   4132: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4135: getfield 159	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:DIg	Lcom/tencent/mm/plugin/webview/model/ay;
          //   4138: invokevirtual 165	com/tencent/mm/plugin/webview/model/ay:eQG	()Lcom/tencent/mm/plugin/webview/model/ay$d;
          //   4141: iconst_3
          //   4142: anewarray 4	java/lang/Object
          //   4145: dup
          //   4146: iconst_0
          //   4147: aload_0
          //   4148: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   4151: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4154: invokevirtual 168	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bQm	()Ljava/lang/String;
          //   4157: aastore
          //   4158: dup
          //   4159: iconst_1
          //   4160: bipush 16
          //   4162: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   4165: aastore
          //   4166: dup
          //   4167: iconst_2
          //   4168: iconst_1
          //   4169: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   4172: aastore
          //   4173: invokevirtual 174	com/tencent/mm/plugin/webview/model/ay$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ay$d;
          //   4176: invokevirtual 177	com/tencent/mm/plugin/webview/model/ay$d:report	()V
          //   4179: aload_0
          //   4180: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   4183: invokestatic 647	com/tencent/mm/plugin/webview/ui/tools/i:d	(Lcom/tencent/mm/plugin/webview/ui/tools/i;)V
          //   4186: ldc 28
          //   4188: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   4191: return
          //   4192: aload_0
          //   4193: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   4196: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4199: getfield 159	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:DIg	Lcom/tencent/mm/plugin/webview/model/ay;
          //   4202: invokevirtual 165	com/tencent/mm/plugin/webview/model/ay:eQG	()Lcom/tencent/mm/plugin/webview/model/ay$d;
          //   4205: iconst_3
          //   4206: anewarray 4	java/lang/Object
          //   4209: dup
          //   4210: iconst_0
          //   4211: aload_0
          //   4212: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   4215: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4218: invokevirtual 168	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bQm	()Ljava/lang/String;
          //   4221: aastore
          //   4222: dup
          //   4223: iconst_1
          //   4224: bipush 31
          //   4226: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   4229: aastore
          //   4230: dup
          //   4231: iconst_2
          //   4232: iconst_1
          //   4233: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   4236: aastore
          //   4237: invokevirtual 174	com/tencent/mm/plugin/webview/model/ay$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ay$d;
          //   4240: invokevirtual 177	com/tencent/mm/plugin/webview/model/ay$d:report	()V
          //   4243: aload_0
          //   4244: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   4247: invokevirtual 650	com/tencent/mm/plugin/webview/ui/tools/i:bLY	()V
          //   4250: ldc 28
          //   4252: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   4255: return
          //   4256: getstatic 325	com/tencent/mm/plugin/report/service/g:yhR	Lcom/tencent/mm/plugin/report/service/g;
          //   4259: ldc2_w 651
          //   4262: lconst_1
          //   4263: lconst_1
          //   4264: iconst_0
          //   4265: invokevirtual 333	com/tencent/mm/plugin/report/service/g:idkeyStat	(JJJZ)V
          //   4268: aload_0
          //   4269: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   4272: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4275: getfield 159	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:DIg	Lcom/tencent/mm/plugin/webview/model/ay;
          //   4278: invokevirtual 165	com/tencent/mm/plugin/webview/model/ay:eQG	()Lcom/tencent/mm/plugin/webview/model/ay$d;
          //   4281: iconst_3
          //   4282: anewarray 4	java/lang/Object
          //   4285: dup
          //   4286: iconst_0
          //   4287: aload_0
          //   4288: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   4291: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4294: invokevirtual 168	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bQm	()Ljava/lang/String;
          //   4297: aastore
          //   4298: dup
          //   4299: iconst_1
          //   4300: bipush 28
          //   4302: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   4305: aastore
          //   4306: dup
          //   4307: iconst_2
          //   4308: iconst_1
          //   4309: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   4312: aastore
          //   4313: invokevirtual 174	com/tencent/mm/plugin/webview/model/ay$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ay$d;
          //   4316: invokevirtual 177	com/tencent/mm/plugin/webview/model/ay$d:report	()V
          //   4319: aload_0
          //   4320: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   4323: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4326: getfield 656	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:EcP	Lcom/tencent/mm/plugin/webview/ui/tools/widget/WebViewSearchContentInputFooter;
          //   4329: invokevirtual 661	com/tencent/mm/plugin/webview/ui/tools/widget/WebViewSearchContentInputFooter:isShown	()Z
          //   4332: ifne +600 -> 4932
          //   4335: aload_0
          //   4336: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   4339: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4342: getfield 656	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:EcP	Lcom/tencent/mm/plugin/webview/ui/tools/widget/WebViewSearchContentInputFooter;
          //   4345: invokevirtual 664	com/tencent/mm/plugin/webview/ui/tools/widget/WebViewSearchContentInputFooter:reset	()V
          //   4348: aload_0
          //   4349: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   4352: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4355: getfield 656	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:EcP	Lcom/tencent/mm/plugin/webview/ui/tools/widget/WebViewSearchContentInputFooter;
          //   4358: invokevirtual 667	com/tencent/mm/plugin/webview/ui/tools/widget/WebViewSearchContentInputFooter:eVK	()V
          //   4361: aload_0
          //   4362: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   4365: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4368: getfield 656	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:EcP	Lcom/tencent/mm/plugin/webview/ui/tools/widget/WebViewSearchContentInputFooter;
          //   4371: invokevirtual 670	com/tencent/mm/plugin/webview/ui/tools/widget/WebViewSearchContentInputFooter:show	()V
          //   4374: ldc 28
          //   4376: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   4379: return
          //   4380: aload_0
          //   4381: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   4384: astore_1
          //   4385: ldc 140
          //   4387: ldc_w 672
          //   4390: invokestatic 81	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
          //   4393: aload_1
          //   4394: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4397: getfield 60	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:DzP	Lcom/tencent/mm/plugin/webview/c/f;
          //   4400: ifnull +72 -> 4472
          //   4403: aload_1
          //   4404: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4407: getfield 60	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:DzP	Lcom/tencent/mm/plugin/webview/c/f;
          //   4410: astore_1
          //   4411: aload_1
          //   4412: getfield 65	com/tencent/mm/plugin/webview/c/f:BHY	Z
          //   4415: ifne +17 -> 4432
          //   4418: ldc 67
          //   4420: ldc_w 674
          //   4423: invokestatic 74	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   4426: ldc 28
          //   4428: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   4431: return
          //   4432: ldc 67
          //   4434: ldc_w 676
          //   4437: invokestatic 81	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
          //   4440: new 678	com/tencent/mm/plugin/webview/c/f$20
          //   4443: dup
          //   4444: aload_1
          //   4445: ldc_w 680
          //   4448: new 83	java/util/HashMap
          //   4451: dup
          //   4452: invokespecial 84	java/util/HashMap:<init>	()V
          //   4455: aload_1
          //   4456: getfield 102	com/tencent/mm/plugin/webview/c/f:DMD	Z
          //   4459: aload_1
          //   4460: getfield 105	com/tencent/mm/plugin/webview/c/f:vJP	Ljava/lang/String;
          //   4463: invokestatic 111	com/tencent/mm/plugin/webview/c/l$a:b	(Ljava/lang/String;Ljava/util/Map;ZLjava/lang/String;)Ljava/lang/String;
          //   4466: invokespecial 683	com/tencent/mm/plugin/webview/c/f$20:<init>	(Lcom/tencent/mm/plugin/webview/c/f;Ljava/lang/String;)V
          //   4469: invokestatic 688	com/tencent/mm/sdk/platformtools/aq:f	(Ljava/lang/Runnable;)V
          //   4472: ldc 28
          //   4474: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   4477: return
          //   4478: aload_0
          //   4479: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   4482: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4485: getfield 159	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:DIg	Lcom/tencent/mm/plugin/webview/model/ay;
          //   4488: invokevirtual 165	com/tencent/mm/plugin/webview/model/ay:eQG	()Lcom/tencent/mm/plugin/webview/model/ay$d;
          //   4491: iconst_3
          //   4492: anewarray 4	java/lang/Object
          //   4495: dup
          //   4496: iconst_0
          //   4497: aload_0
          //   4498: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   4501: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4504: invokevirtual 168	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bQm	()Ljava/lang/String;
          //   4507: aastore
          //   4508: dup
          //   4509: iconst_1
          //   4510: bipush 33
          //   4512: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   4515: aastore
          //   4516: dup
          //   4517: iconst_2
          //   4518: iconst_1
          //   4519: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   4522: aastore
          //   4523: invokevirtual 174	com/tencent/mm/plugin/webview/model/ay$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ay$d;
          //   4526: invokevirtual 177	com/tencent/mm/plugin/webview/model/ay$d:report	()V
          //   4529: aload_0
          //   4530: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   4533: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4536: getfield 692	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:EdZ	Lcom/tencent/mm/plugin/webview/ui/tools/floatball/a;
          //   4539: iconst_1
          //   4540: invokevirtual 698	com/tencent/mm/plugin/webview/ui/tools/floatball/a:gf	(Z)V
          //   4543: ldc 28
          //   4545: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   4548: return
          //   4549: aload_0
          //   4550: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   4553: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4556: getfield 159	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:DIg	Lcom/tencent/mm/plugin/webview/model/ay;
          //   4559: invokevirtual 165	com/tencent/mm/plugin/webview/model/ay:eQG	()Lcom/tencent/mm/plugin/webview/model/ay$d;
          //   4562: iconst_3
          //   4563: anewarray 4	java/lang/Object
          //   4566: dup
          //   4567: iconst_0
          //   4568: aload_0
          //   4569: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   4572: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4575: invokevirtual 168	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bQm	()Ljava/lang/String;
          //   4578: aastore
          //   4579: dup
          //   4580: iconst_1
          //   4581: bipush 34
          //   4583: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   4586: aastore
          //   4587: dup
          //   4588: iconst_2
          //   4589: iconst_1
          //   4590: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   4593: aastore
          //   4594: invokevirtual 174	com/tencent/mm/plugin/webview/model/ay$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ay$d;
          //   4597: invokevirtual 177	com/tencent/mm/plugin/webview/model/ay$d:report	()V
          //   4600: aload_0
          //   4601: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   4604: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4607: getfield 692	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:EdZ	Lcom/tencent/mm/plugin/webview/ui/tools/floatball/a;
          //   4610: iconst_0
          //   4611: invokevirtual 698	com/tencent/mm/plugin/webview/ui/tools/floatball/a:gf	(Z)V
          //   4614: ldc 28
          //   4616: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   4619: return
          //   4620: aload_0
          //   4621: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   4624: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4627: getfield 159	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:DIg	Lcom/tencent/mm/plugin/webview/model/ay;
          //   4630: invokevirtual 165	com/tencent/mm/plugin/webview/model/ay:eQG	()Lcom/tencent/mm/plugin/webview/model/ay$d;
          //   4633: iconst_3
          //   4634: anewarray 4	java/lang/Object
          //   4637: dup
          //   4638: iconst_0
          //   4639: aload_0
          //   4640: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   4643: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4646: invokevirtual 168	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bQm	()Ljava/lang/String;
          //   4649: aastore
          //   4650: dup
          //   4651: iconst_1
          //   4652: bipush 99
          //   4654: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   4657: aastore
          //   4658: dup
          //   4659: iconst_2
          //   4660: iconst_1
          //   4661: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   4664: aastore
          //   4665: invokevirtual 174	com/tencent/mm/plugin/webview/model/ay$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ay$d;
          //   4668: invokevirtual 177	com/tencent/mm/plugin/webview/model/ay$d:report	()V
          //   4671: aload_0
          //   4672: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   4675: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4678: invokevirtual 701	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:eSY	()V
          //   4681: ldc 28
          //   4683: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   4686: return
          //   4687: aload_0
          //   4688: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   4691: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4694: getfield 60	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:DzP	Lcom/tencent/mm/plugin/webview/c/f;
          //   4697: ldc_w 680
          //   4700: aconst_null
          //   4701: new 703	org/json/JSONObject
          //   4704: dup
          //   4705: invokespecial 704	org/json/JSONObject:<init>	()V
          //   4708: invokevirtual 707	com/tencent/mm/plugin/webview/c/f:b	(Ljava/lang/String;Ljava/util/Map;Lorg/json/JSONObject;)V
          //   4711: ldc 28
          //   4713: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   4716: return
          //   4717: iconst_0
          //   4718: istore_2
          //   4719: goto -4077 -> 642
          //   4722: iconst_0
          //   4723: istore_2
          //   4724: goto -4068 -> 656
          //   4727: astore_1
          //   4728: iconst_0
          //   4729: istore_2
          //   4730: ldc 140
          //   4732: aload_1
          //   4733: ldc_w 709
          //   4736: iconst_0
          //   4737: anewarray 4	java/lang/Object
          //   4740: invokestatic 713	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
          //   4743: goto -4087 -> 656
          //   4746: aload_0
          //   4747: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$12:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
          //   4750: astore_1
          //   4751: aload_1
          //   4752: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4755: getfield 60	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:DzP	Lcom/tencent/mm/plugin/webview/c/f;
          //   4758: ldc_w 583
          //   4761: iconst_0
          //   4762: invokevirtual 531	com/tencent/mm/plugin/webview/c/f:cn	(Ljava/lang/String;Z)V
          //   4765: aload_1
          //   4766: invokevirtual 54	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4769: getfield 60	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:DzP	Lcom/tencent/mm/plugin/webview/c/f;
          //   4772: astore_1
          //   4773: aload_1
          //   4774: getfield 65	com/tencent/mm/plugin/webview/c/f:BHY	Z
          //   4777: ifne +17 -> 4794
          //   4780: ldc 67
          //   4782: ldc_w 715
          //   4785: invokestatic 74	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   4788: ldc 28
          //   4790: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   4793: return
          //   4794: new 83	java/util/HashMap
          //   4797: dup
          //   4798: invokespecial 84	java/util/HashMap:<init>	()V
          //   4801: astore 5
          //   4803: aload 5
          //   4805: ldc_w 590
          //   4808: ldc_w 717
          //   4811: invokevirtual 93	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
          //   4814: pop
          //   4815: ldc_w 587
          //   4818: aload 5
          //   4820: aload_1
          //   4821: getfield 102	com/tencent/mm/plugin/webview/c/f:DMD	Z
          //   4824: aload_1
          //   4825: getfield 105	com/tencent/mm/plugin/webview/c/f:vJP	Ljava/lang/String;
          //   4828: invokestatic 111	com/tencent/mm/plugin/webview/c/l$a:b	(Ljava/lang/String;Ljava/util/Map;ZLjava/lang/String;)Ljava/lang/String;
          //   4831: astore 5
          //   4833: aload_1
          //   4834: getfield 115	com/tencent/mm/plugin/webview/c/f:DMv	Lcom/tencent/mm/ui/widget/MMWebView;
          //   4837: new 117	java/lang/StringBuilder
          //   4840: dup
          //   4841: ldc 119
          //   4843: invokespecial 122	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   4846: aload 5
          //   4848: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   4851: ldc 128
          //   4853: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   4856: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   4859: aconst_null
          //   4860: invokevirtual 138	com/tencent/mm/ui/widget/MMWebView:evaluateJavascript	(Ljava/lang/String;Landroid/webkit/ValueCallback;)V
          //   4863: aload_1
          //   4864: getfield 588	com/tencent/mm/plugin/webview/c/f:lvv	Lcom/tencent/mm/plugin/webview/stub/e;
          //   4867: ldc_w 719
          //   4870: aload 4
          //   4872: aload_1
          //   4873: getfield 596	com/tencent/mm/plugin/webview/c/f:DMF	I
          //   4876: invokeinterface 600 4 0
          //   4881: aload_1
          //   4882: getfield 588	com/tencent/mm/plugin/webview/c/f:lvv	Lcom/tencent/mm/plugin/webview/stub/e;
          //   4885: ldc_w 590
          //   4888: ldc_w 717
          //   4891: aload_1
          //   4892: getfield 596	com/tencent/mm/plugin/webview/c/f:DMF	I
          //   4895: invokeinterface 600 4 0
          //   4900: ldc 28
          //   4902: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   4905: return
          //   4906: astore_1
          //   4907: ldc 67
          //   4909: new 117	java/lang/StringBuilder
          //   4912: dup
          //   4913: ldc_w 602
          //   4916: invokespecial 122	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   4919: aload_1
          //   4920: invokevirtual 473	java/lang/Exception:getMessage	()Ljava/lang/String;
          //   4923: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   4926: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   4929: invokestatic 605	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
          //   4932: ldc 28
          //   4934: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   4937: return
          //   4938: astore_1
          //   4939: goto -209 -> 4730
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	4942	0	this	12
          //   0	4942	1	paramAnonymousMenuItem	MenuItem
          //   0	4942	2	paramAnonymousInt	int
          //   648	4	3	i	int
          //   29	4842	4	localObject1	Object
          //   81	4766	5	localObject2	Object
          //   1892	193	6	locala	com.tencent.mm.plugin.webview.modeltools.a
          //   1899	49	7	locale	com.tencent.mm.plugin.webview.stub.e
          // Exception table:
          //   from	to	target	type
          //   2011	2025	2099	java/lang/Exception
          //   2025	2098	2099	java/lang/Exception
          //   2150	2230	2099	java/lang/Exception
          //   2231	2245	2099	java/lang/Exception
          //   1947	1957	2126	java/lang/Exception
          //   3246	3265	3271	java/lang/Exception
          //   4071	4090	4096	java/lang/Exception
          //   586	624	4727	java/lang/Exception
          //   628	635	4727	java/lang/Exception
          //   4863	4900	4906	java/lang/Exception
          //   642	649	4938	java/lang/Exception
        }
      };
      this.mDL.KJz = ((n.e)localObject2);
      this.mDL.JXC = new e.b()
      {
        public final void onDismiss()
        {
          i.this.orZ = false;
        }
      };
      if (eRK().lvw != null) {
        break label192;
      }
      ad.e("MicroMsg.WebViewMenuHelper", "get permission failed");
      AppMethodBeat.o(208017);
      return;
      bool = false;
      break;
    }
    label192:
    Object localObject3 = eRK().DIv.lvw.eRg();
    this.mDL.KJy = new n.d()
    {
      /* Error */
      public final void onCreateMMMenu(l paramAnonymousl)
      {
        // Byte code:
        //   0: ldc 30
        //   2: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: getstatic 42	com/tencent/mm/plugin/report/service/g:yhR	Lcom/tencent/mm/plugin/report/service/g;
        //   8: ldc2_w 43
        //   11: lconst_0
        //   12: lconst_1
        //   13: iconst_0
        //   14: invokevirtual 48	com/tencent/mm/plugin/report/service/g:idkeyStat	(JJJZ)V
        //   17: aload_1
        //   18: invokevirtual 53	com/tencent/mm/ui/base/l:clear	()V
        //   21: aload_0
        //   22: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   25: getfield 57	com/tencent/mm/plugin/webview/ui/tools/i:Ebk	Ljava/lang/Boolean;
        //   28: invokevirtual 63	java/lang/Boolean:booleanValue	()Z
        //   31: ifeq +90 -> 121
        //   34: aload_0
        //   35: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   38: getfield 67	com/tencent/mm/plugin/webview/ui/tools/i:Ebj	Ljava/util/ArrayList;
        //   41: invokevirtual 73	java/util/ArrayList:size	()I
        //   44: istore_3
        //   45: iconst_0
        //   46: istore_2
        //   47: iload_2
        //   48: iload_3
        //   49: if_icmpge +66 -> 115
        //   52: aload_0
        //   53: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   56: getfield 67	com/tencent/mm/plugin/webview/ui/tools/i:Ebj	Ljava/util/ArrayList;
        //   59: iload_2
        //   60: invokevirtual 77	java/util/ArrayList:get	(I)Ljava/lang/Object;
        //   63: checkcast 79	com/tencent/mm/n/d$b
        //   66: astore 8
        //   68: aload_1
        //   69: aload 8
        //   71: getfield 83	com/tencent/mm/n/d$b:id	I
        //   74: aload 8
        //   76: getfield 87	com/tencent/mm/n/d$b:title	Ljava/lang/String;
        //   79: invokevirtual 91	com/tencent/mm/ui/base/l:c	(ILjava/lang/CharSequence;)Landroid/view/MenuItem;
        //   82: checkcast 93	com/tencent/mm/ui/base/m
        //   85: astore 9
        //   87: aload 9
        //   89: aload 8
        //   91: putfield 97	com/tencent/mm/ui/base/m:Jme	Landroid/view/ContextMenu$ContextMenuInfo;
        //   94: aload 9
        //   96: aconst_null
        //   97: invokevirtual 101	com/tencent/mm/ui/base/m:setIcon	(Landroid/graphics/drawable/Drawable;)Landroid/view/MenuItem;
        //   100: pop
        //   101: aload 9
        //   103: iconst_0
        //   104: invokevirtual 104	com/tencent/mm/ui/base/m:setIcon	(I)Landroid/view/MenuItem;
        //   107: pop
        //   108: iload_2
        //   109: iconst_1
        //   110: iadd
        //   111: istore_2
        //   112: goto -65 -> 47
        //   115: ldc 30
        //   117: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   120: return
        //   121: aload_0
        //   122: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   125: iconst_1
        //   126: invokestatic 111	com/tencent/mm/plugin/webview/ui/tools/i:b	(Lcom/tencent/mm/plugin/webview/ui/tools/i;I)Z
        //   129: ifeq +70 -> 199
        //   132: aload_0
        //   133: getfield 21	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebo	Lcom/tencent/mm/protocal/JsapiPermissionWrapper;
        //   136: bipush 21
        //   138: invokestatic 115	com/tencent/mm/plugin/webview/ui/tools/i:a	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
        //   141: ifeq +58 -> 199
        //   144: aload_0
        //   145: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   148: iconst_1
        //   149: invokevirtual 119	com/tencent/mm/plugin/webview/ui/tools/i:Xu	(I)Z
        //   152: ifeq +47 -> 199
        //   155: aload_1
        //   156: iconst_1
        //   157: aload_0
        //   158: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   161: invokevirtual 123	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   164: ldc 124
        //   166: invokevirtual 130	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
        //   169: ldc 131
        //   171: aload_0
        //   172: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   175: invokevirtual 123	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   178: invokevirtual 135	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getResources	()Landroid/content/res/Resources;
        //   181: ldc 136
        //   183: invokevirtual 142	android/content/res/Resources:getColor	(I)I
        //   186: aload_0
        //   187: getfield 21	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebo	Lcom/tencent/mm/protocal/JsapiPermissionWrapper;
        //   190: bipush 21
        //   192: invokestatic 144	com/tencent/mm/plugin/webview/ui/tools/i:b	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
        //   195: invokevirtual 147	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;IIZ)Landroid/view/MenuItem;
        //   198: pop
        //   199: aload_0
        //   200: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   203: iconst_2
        //   204: invokestatic 111	com/tencent/mm/plugin/webview/ui/tools/i:b	(Lcom/tencent/mm/plugin/webview/ui/tools/i;I)Z
        //   207: ifeq +56 -> 263
        //   210: aload_0
        //   211: getfield 21	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebo	Lcom/tencent/mm/protocal/JsapiPermissionWrapper;
        //   214: bipush 23
        //   216: invokestatic 115	com/tencent/mm/plugin/webview/ui/tools/i:a	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
        //   219: ifeq +44 -> 263
        //   222: aload_0
        //   223: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   226: iconst_2
        //   227: invokevirtual 119	com/tencent/mm/plugin/webview/ui/tools/i:Xu	(I)Z
        //   230: ifeq +33 -> 263
        //   233: aload_1
        //   234: iconst_2
        //   235: aload_0
        //   236: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   239: invokevirtual 123	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   242: ldc 148
        //   244: invokevirtual 130	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
        //   247: ldc 149
        //   249: iconst_0
        //   250: aload_0
        //   251: getfield 21	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebo	Lcom/tencent/mm/protocal/JsapiPermissionWrapper;
        //   254: bipush 23
        //   256: invokestatic 144	com/tencent/mm/plugin/webview/ui/tools/i:b	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
        //   259: invokevirtual 147	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;IIZ)Landroid/view/MenuItem;
        //   262: pop
        //   263: new 151	android/os/Bundle
        //   266: dup
        //   267: invokespecial 152	android/os/Bundle:<init>	()V
        //   270: astore 8
        //   272: aload 8
        //   274: ldc 154
        //   276: aload_0
        //   277: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   280: invokevirtual 123	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   283: getfield 158	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:DIv	Lcom/tencent/mm/plugin/webview/core/h;
        //   286: invokevirtual 163	com/tencent/mm/plugin/webview/core/h:eNj	()I
        //   289: invokevirtual 167	android/os/Bundle:putInt	(Ljava/lang/String;I)V
        //   292: aload 8
        //   294: ldc 169
        //   296: aload_0
        //   297: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   300: invokevirtual 123	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   303: getfield 158	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:DIv	Lcom/tencent/mm/plugin/webview/core/h;
        //   306: getfield 175	com/tencent/mm/plugin/webview/core/BaseWebViewController:omW	Lcom/tencent/mm/ui/widget/MMWebView;
        //   309: invokevirtual 181	com/tencent/mm/ui/widget/MMWebView:getUrl	()Ljava/lang/String;
        //   312: invokevirtual 185	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
        //   315: aload_0
        //   316: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   319: invokevirtual 123	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   322: getfield 158	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:DIv	Lcom/tencent/mm/plugin/webview/core/h;
        //   325: getfield 189	com/tencent/mm/plugin/webview/core/h:lvv	Lcom/tencent/mm/plugin/webview/stub/e;
        //   328: bipush 109
        //   330: aload 8
        //   332: invokeinterface 195 3 0
        //   337: astore 8
        //   339: aload 8
        //   341: ifnull +1742 -> 2083
        //   344: aload 8
        //   346: ldc 197
        //   348: iconst_0
        //   349: invokevirtual 201	android/os/Bundle:getInt	(Ljava/lang/String;I)I
        //   352: istore_2
        //   353: aload 8
        //   355: ldc 203
        //   357: iconst_m1
        //   358: invokevirtual 201	android/os/Bundle:getInt	(Ljava/lang/String;I)I
        //   361: istore 4
        //   363: iload_2
        //   364: istore_3
        //   365: iload 4
        //   367: istore_2
        //   368: iload_3
        //   369: iconst_1
        //   370: if_icmpne +67 -> 437
        //   373: aload_0
        //   374: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   377: bipush 38
        //   379: invokestatic 111	com/tencent/mm/plugin/webview/ui/tools/i:b	(Lcom/tencent/mm/plugin/webview/ui/tools/i;I)Z
        //   382: ifeq +1532 -> 1914
        //   385: aload_0
        //   386: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   389: bipush 38
        //   391: invokevirtual 119	com/tencent/mm/plugin/webview/ui/tools/i:Xu	(I)Z
        //   394: ifeq +1520 -> 1914
        //   397: iload_2
        //   398: ifne +1516 -> 1914
        //   401: aload_1
        //   402: bipush 38
        //   404: aload_0
        //   405: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   408: invokevirtual 123	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   411: ldc 204
        //   413: invokevirtual 130	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
        //   416: ldc 205
        //   418: aload_0
        //   419: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   422: invokevirtual 123	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   425: invokevirtual 135	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getResources	()Landroid/content/res/Resources;
        //   428: ldc 206
        //   430: invokevirtual 142	android/content/res/Resources:getColor	(I)I
        //   433: invokevirtual 209	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;II)Landroid/view/MenuItem;
        //   436: pop
        //   437: aload_0
        //   438: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   441: iconst_3
        //   442: invokestatic 111	com/tencent/mm/plugin/webview/ui/tools/i:b	(Lcom/tencent/mm/plugin/webview/ui/tools/i;I)Z
        //   445: ifeq +139 -> 584
        //   448: aload_0
        //   449: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   452: invokevirtual 123	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   455: getfield 213	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Eda	Z
        //   458: ifeq +61 -> 519
        //   461: aload_0
        //   462: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   465: invokevirtual 123	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   468: invokevirtual 216	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:eSK	()Ljava/lang/String;
        //   471: invokestatic 222	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
        //   474: ifne +110 -> 584
        //   477: aload_0
        //   478: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   481: invokevirtual 123	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   484: getfield 225	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Eev	Ljava/lang/String;
        //   487: invokestatic 222	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
        //   490: ifne +94 -> 584
        //   493: aload_0
        //   494: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   497: invokevirtual 123	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   500: invokevirtual 216	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:eSK	()Ljava/lang/String;
        //   503: aload_0
        //   504: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   507: invokevirtual 123	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   510: getfield 225	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Eev	Ljava/lang/String;
        //   513: invokevirtual 230	java/lang/String:startsWith	(Ljava/lang/String;)Z
        //   516: ifne +68 -> 584
        //   519: aload_0
        //   520: getfield 21	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebo	Lcom/tencent/mm/protocal/JsapiPermissionWrapper;
        //   523: sipush 323
        //   526: invokestatic 115	com/tencent/mm/plugin/webview/ui/tools/i:a	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
        //   529: ifeq +55 -> 584
        //   532: aload_0
        //   533: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   536: invokevirtual 233	com/tencent/mm/plugin/webview/ui/tools/i:eSk	()Z
        //   539: ifeq +45 -> 584
        //   542: aload_0
        //   543: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   546: iconst_3
        //   547: invokevirtual 119	com/tencent/mm/plugin/webview/ui/tools/i:Xu	(I)Z
        //   550: ifeq +34 -> 584
        //   553: aload_1
        //   554: iconst_3
        //   555: aload_0
        //   556: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   559: invokevirtual 123	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   562: ldc 234
        //   564: invokevirtual 130	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
        //   567: ldc 235
        //   569: iconst_0
        //   570: aload_0
        //   571: getfield 21	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebo	Lcom/tencent/mm/protocal/JsapiPermissionWrapper;
        //   574: sipush 323
        //   577: invokestatic 144	com/tencent/mm/plugin/webview/ui/tools/i:b	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
        //   580: invokevirtual 147	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;IIZ)Landroid/view/MenuItem;
        //   583: pop
        //   584: aload_0
        //   585: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   588: bipush 25
        //   590: invokestatic 111	com/tencent/mm/plugin/webview/ui/tools/i:b	(Lcom/tencent/mm/plugin/webview/ui/tools/i;I)Z
        //   593: ifeq +104 -> 697
        //   596: aload_0
        //   597: getfield 21	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebo	Lcom/tencent/mm/protocal/JsapiPermissionWrapper;
        //   600: sipush 322
        //   603: invokestatic 115	com/tencent/mm/plugin/webview/ui/tools/i:a	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
        //   606: ifeq +91 -> 697
        //   609: aload_0
        //   610: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   613: invokevirtual 123	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   616: invokestatic 241	com/tencent/wework/api/WWAPIFactory:lt	(Landroid/content/Context;)Lcom/tencent/wework/api/IWWAPI;
        //   619: invokeinterface 246 1 0
        //   624: ifeq +73 -> 697
        //   627: aload_0
        //   628: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   631: bipush 25
        //   633: invokevirtual 119	com/tencent/mm/plugin/webview/ui/tools/i:Xu	(I)Z
        //   636: ifeq +61 -> 697
        //   639: aload_0
        //   640: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   643: invokevirtual 123	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   646: invokestatic 241	com/tencent/wework/api/WWAPIFactory:lt	(Landroid/content/Context;)Lcom/tencent/wework/api/IWWAPI;
        //   649: invokeinterface 249 1 0
        //   654: astore 8
        //   656: aload_1
        //   657: bipush 25
        //   659: aload_0
        //   660: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   663: invokevirtual 123	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   666: ldc 250
        //   668: iconst_1
        //   669: anewarray 4	java/lang/Object
        //   672: dup
        //   673: iconst_0
        //   674: aload 8
        //   676: aastore
        //   677: invokevirtual 253	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
        //   680: ldc 254
        //   682: iconst_0
        //   683: aload_0
        //   684: getfield 21	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebo	Lcom/tencent/mm/protocal/JsapiPermissionWrapper;
        //   687: sipush 322
        //   690: invokestatic 144	com/tencent/mm/plugin/webview/ui/tools/i:b	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
        //   693: invokevirtual 147	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;IIZ)Landroid/view/MenuItem;
        //   696: pop
        //   697: aload_0
        //   698: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   701: bipush 33
        //   703: invokestatic 111	com/tencent/mm/plugin/webview/ui/tools/i:b	(Lcom/tencent/mm/plugin/webview/ui/tools/i;I)Z
        //   706: ifeq +91 -> 797
        //   709: aload_0
        //   710: getfield 21	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebo	Lcom/tencent/mm/protocal/JsapiPermissionWrapper;
        //   713: bipush 31
        //   715: invokestatic 115	com/tencent/mm/plugin/webview/ui/tools/i:a	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
        //   718: ifeq +79 -> 797
        //   721: aload_0
        //   722: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   725: bipush 33
        //   727: invokevirtual 119	com/tencent/mm/plugin/webview/ui/tools/i:Xu	(I)Z
        //   730: ifeq +67 -> 797
        //   733: aload_0
        //   734: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   737: invokevirtual 123	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   740: getfield 158	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:DIv	Lcom/tencent/mm/plugin/webview/core/h;
        //   743: getfield 189	com/tencent/mm/plugin/webview/core/h:lvv	Lcom/tencent/mm/plugin/webview/stub/e;
        //   746: bipush 78
        //   748: aconst_null
        //   749: invokeinterface 195 3 0
        //   754: ldc_w 256
        //   757: iconst_0
        //   758: invokevirtual 260	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
        //   761: ifeq +36 -> 797
        //   764: aload_1
        //   765: bipush 33
        //   767: aload_0
        //   768: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   771: invokevirtual 123	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   774: ldc_w 261
        //   777: invokevirtual 130	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
        //   780: ldc_w 262
        //   783: iconst_0
        //   784: aload_0
        //   785: getfield 21	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebo	Lcom/tencent/mm/protocal/JsapiPermissionWrapper;
        //   788: bipush 31
        //   790: invokestatic 144	com/tencent/mm/plugin/webview/ui/tools/i:b	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
        //   793: invokevirtual 147	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;IIZ)Landroid/view/MenuItem;
        //   796: pop
        //   797: aload_0
        //   798: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   801: bipush 26
        //   803: invokestatic 111	com/tencent/mm/plugin/webview/ui/tools/i:b	(Lcom/tencent/mm/plugin/webview/ui/tools/i;I)Z
        //   806: ifeq +88 -> 894
        //   809: aload_0
        //   810: getfield 21	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebo	Lcom/tencent/mm/protocal/JsapiPermissionWrapper;
        //   813: sipush 278
        //   816: invokestatic 115	com/tencent/mm/plugin/webview/ui/tools/i:a	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
        //   819: ifeq +75 -> 894
        //   822: aload_0
        //   823: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   826: invokevirtual 123	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   829: aload_0
        //   830: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   833: invokevirtual 123	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   836: getfield 263	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:omW	Lcom/tencent/mm/ui/widget/MMWebView;
        //   839: invokevirtual 181	com/tencent/mm/ui/widget/MMWebView:getUrl	()Ljava/lang/String;
        //   842: invokestatic 269	com/tencent/mm/plugin/webview/stub/a:bB	(Landroid/content/Context;Ljava/lang/String;)Z
        //   845: ifeq +49 -> 894
        //   848: aload_0
        //   849: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   852: bipush 26
        //   854: invokevirtual 119	com/tencent/mm/plugin/webview/ui/tools/i:Xu	(I)Z
        //   857: ifeq +37 -> 894
        //   860: aload_1
        //   861: bipush 26
        //   863: aload_0
        //   864: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   867: invokevirtual 123	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   870: ldc_w 270
        //   873: invokevirtual 130	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
        //   876: ldc_w 271
        //   879: iconst_0
        //   880: aload_0
        //   881: getfield 21	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebo	Lcom/tencent/mm/protocal/JsapiPermissionWrapper;
        //   884: sipush 278
        //   887: invokestatic 144	com/tencent/mm/plugin/webview/ui/tools/i:b	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
        //   890: invokevirtual 147	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;IIZ)Landroid/view/MenuItem;
        //   893: pop
        //   894: aload_0
        //   895: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   898: bipush 7
        //   900: invokestatic 111	com/tencent/mm/plugin/webview/ui/tools/i:b	(Lcom/tencent/mm/plugin/webview/ui/tools/i;I)Z
        //   903: ifeq +75 -> 978
        //   906: aload_0
        //   907: getfield 21	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebo	Lcom/tencent/mm/protocal/JsapiPermissionWrapper;
        //   910: bipush 45
        //   912: invokestatic 115	com/tencent/mm/plugin/webview/ui/tools/i:a	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
        //   915: ifeq +63 -> 978
        //   918: aload_0
        //   919: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   922: bipush 7
        //   924: invokevirtual 119	com/tencent/mm/plugin/webview/ui/tools/i:Xu	(I)Z
        //   927: ifeq +51 -> 978
        //   930: aload_1
        //   931: bipush 7
        //   933: aload_0
        //   934: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   937: invokevirtual 123	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   940: ldc_w 272
        //   943: invokevirtual 130	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
        //   946: ldc_w 273
        //   949: aload_0
        //   950: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   953: invokevirtual 123	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   956: invokevirtual 135	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getResources	()Landroid/content/res/Resources;
        //   959: ldc_w 274
        //   962: invokevirtual 142	android/content/res/Resources:getColor	(I)I
        //   965: aload_0
        //   966: getfield 21	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebo	Lcom/tencent/mm/protocal/JsapiPermissionWrapper;
        //   969: bipush 45
        //   971: invokestatic 144	com/tencent/mm/plugin/webview/ui/tools/i:b	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
        //   974: invokevirtual 147	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;IIZ)Landroid/view/MenuItem;
        //   977: pop
        //   978: aload_0
        //   979: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   982: invokevirtual 277	com/tencent/mm/plugin/webview/ui/tools/a:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   985: invokevirtual 281	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
        //   988: ldc_w 283
        //   991: invokevirtual 289	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
        //   994: astore 8
        //   996: aload_0
        //   997: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1000: invokevirtual 277	com/tencent/mm/plugin/webview/ui/tools/a:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   1003: invokevirtual 281	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
        //   1006: ldc_w 291
        //   1009: ldc2_w 292
        //   1012: invokevirtual 297	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
        //   1015: lstore 5
        //   1017: aload_0
        //   1018: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1021: bipush 23
        //   1023: invokestatic 111	com/tencent/mm/plugin/webview/ui/tools/i:b	(Lcom/tencent/mm/plugin/webview/ui/tools/i;I)Z
        //   1026: ifeq +51 -> 1077
        //   1029: aload_0
        //   1030: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1033: invokevirtual 123	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   1036: getfield 158	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:DIv	Lcom/tencent/mm/plugin/webview/core/h;
        //   1039: getfield 189	com/tencent/mm/plugin/webview/core/h:lvv	Lcom/tencent/mm/plugin/webview/stub/e;
        //   1042: lload 5
        //   1044: aload 8
        //   1046: invokeinterface 301 4 0
        //   1051: ifeq +26 -> 1077
        //   1054: aload_1
        //   1055: bipush 23
        //   1057: aload_0
        //   1058: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1061: invokevirtual 123	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   1064: ldc_w 302
        //   1067: invokevirtual 130	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
        //   1070: ldc_w 303
        //   1073: invokevirtual 306	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;I)Landroid/view/MenuItem;
        //   1076: pop
        //   1077: aload_0
        //   1078: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1081: bipush 24
        //   1083: invokestatic 111	com/tencent/mm/plugin/webview/ui/tools/i:b	(Lcom/tencent/mm/plugin/webview/ui/tools/i;I)Z
        //   1086: ifeq +139 -> 1225
        //   1089: aload_0
        //   1090: getfield 21	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebo	Lcom/tencent/mm/protocal/JsapiPermissionWrapper;
        //   1093: bipush 43
        //   1095: invokestatic 115	com/tencent/mm/plugin/webview/ui/tools/i:a	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
        //   1098: ifeq +127 -> 1225
        //   1101: aload_0
        //   1102: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1105: bipush 24
        //   1107: invokevirtual 119	com/tencent/mm/plugin/webview/ui/tools/i:Xu	(I)Z
        //   1110: ifeq +115 -> 1225
        //   1113: aload_0
        //   1114: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1117: invokevirtual 123	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   1120: ldc_w 308
        //   1123: invokestatic 313	com/tencent/mm/pluginsdk/model/app/q:s	(Landroid/content/Context;Ljava/lang/String;)Z
        //   1126: ifne +99 -> 1225
        //   1129: new 151	android/os/Bundle
        //   1132: dup
        //   1133: invokespecial 152	android/os/Bundle:<init>	()V
        //   1136: astore 8
        //   1138: aload 8
        //   1140: ldc_w 315
        //   1143: ldc_w 317
        //   1146: invokevirtual 185	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
        //   1149: aload_0
        //   1150: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1153: invokevirtual 123	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   1156: getfield 158	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:DIv	Lcom/tencent/mm/plugin/webview/core/h;
        //   1159: getfield 189	com/tencent/mm/plugin/webview/core/h:lvv	Lcom/tencent/mm/plugin/webview/stub/e;
        //   1162: bipush 71
        //   1164: aload 8
        //   1166: invokeinterface 195 3 0
        //   1171: astore 8
        //   1173: aload 8
        //   1175: ifnull +866 -> 2041
        //   1178: aload 8
        //   1180: ldc_w 317
        //   1183: invokevirtual 319	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
        //   1186: istore 7
        //   1188: iload 7
        //   1190: ifeq +35 -> 1225
        //   1193: aload_1
        //   1194: bipush 24
        //   1196: aload_0
        //   1197: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1200: invokevirtual 123	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   1203: ldc_w 320
        //   1206: invokevirtual 130	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
        //   1209: ldc_w 321
        //   1212: aload_0
        //   1213: getfield 21	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebo	Lcom/tencent/mm/protocal/JsapiPermissionWrapper;
        //   1216: bipush 43
        //   1218: invokestatic 144	com/tencent/mm/plugin/webview/ui/tools/i:b	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
        //   1221: invokevirtual 324	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;IZ)Landroid/view/MenuItem;
        //   1224: pop
        //   1225: aload_0
        //   1226: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1229: bipush 8
        //   1231: invokestatic 111	com/tencent/mm/plugin/webview/ui/tools/i:b	(Lcom/tencent/mm/plugin/webview/ui/tools/i;I)Z
        //   1234: ifeq +110 -> 1344
        //   1237: aload_0
        //   1238: getfield 21	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebo	Lcom/tencent/mm/protocal/JsapiPermissionWrapper;
        //   1241: bipush 36
        //   1243: invokestatic 115	com/tencent/mm/plugin/webview/ui/tools/i:a	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
        //   1246: ifeq +98 -> 1344
        //   1249: aload_0
        //   1250: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1253: bipush 8
        //   1255: invokevirtual 119	com/tencent/mm/plugin/webview/ui/tools/i:Xu	(I)Z
        //   1258: ifeq +86 -> 1344
        //   1261: aconst_null
        //   1262: astore 8
        //   1264: aload_0
        //   1265: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1268: invokevirtual 123	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   1271: getfield 158	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:DIv	Lcom/tencent/mm/plugin/webview/core/h;
        //   1274: getfield 189	com/tencent/mm/plugin/webview/core/h:lvv	Lcom/tencent/mm/plugin/webview/stub/e;
        //   1277: invokeinterface 327 1 0
        //   1282: astore 9
        //   1284: aload 9
        //   1286: astore 8
        //   1288: aload 8
        //   1290: invokestatic 222	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
        //   1293: ifne +754 -> 2047
        //   1296: aload_1
        //   1297: bipush 8
        //   1299: aload_0
        //   1300: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1303: invokevirtual 123	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   1306: ldc_w 328
        //   1309: invokevirtual 130	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
        //   1312: ldc_w 329
        //   1315: aload_0
        //   1316: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1319: invokevirtual 123	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   1322: invokevirtual 135	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getResources	()Landroid/content/res/Resources;
        //   1325: ldc_w 274
        //   1328: invokevirtual 142	android/content/res/Resources:getColor	(I)I
        //   1331: aload_0
        //   1332: getfield 21	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebo	Lcom/tencent/mm/protocal/JsapiPermissionWrapper;
        //   1335: bipush 36
        //   1337: invokestatic 144	com/tencent/mm/plugin/webview/ui/tools/i:b	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
        //   1340: invokevirtual 147	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;IIZ)Landroid/view/MenuItem;
        //   1343: pop
        //   1344: aload_0
        //   1345: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1348: bipush 20
        //   1350: invokestatic 111	com/tencent/mm/plugin/webview/ui/tools/i:b	(Lcom/tencent/mm/plugin/webview/ui/tools/i;I)Z
        //   1353: ifeq +73 -> 1426
        //   1356: aload_0
        //   1357: getfield 21	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebo	Lcom/tencent/mm/protocal/JsapiPermissionWrapper;
        //   1360: bipush 91
        //   1362: invokestatic 115	com/tencent/mm/plugin/webview/ui/tools/i:a	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
        //   1365: ifeq +61 -> 1426
        //   1368: aload_0
        //   1369: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1372: invokevirtual 123	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   1375: invokestatic 333	com/tencent/mm/plugin/webview/stub/a:gU	(Landroid/content/Context;)Z
        //   1378: ifeq +48 -> 1426
        //   1381: aload_0
        //   1382: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1385: bipush 20
        //   1387: invokevirtual 119	com/tencent/mm/plugin/webview/ui/tools/i:Xu	(I)Z
        //   1390: ifeq +36 -> 1426
        //   1393: aload_1
        //   1394: bipush 20
        //   1396: aload_0
        //   1397: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1400: invokevirtual 123	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   1403: ldc_w 334
        //   1406: invokevirtual 130	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
        //   1409: ldc_w 335
        //   1412: iconst_0
        //   1413: aload_0
        //   1414: getfield 21	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebo	Lcom/tencent/mm/protocal/JsapiPermissionWrapper;
        //   1417: bipush 91
        //   1419: invokestatic 144	com/tencent/mm/plugin/webview/ui/tools/i:b	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
        //   1422: invokevirtual 147	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;IIZ)Landroid/view/MenuItem;
        //   1425: pop
        //   1426: aload_0
        //   1427: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1430: bipush 22
        //   1432: invokestatic 111	com/tencent/mm/plugin/webview/ui/tools/i:b	(Lcom/tencent/mm/plugin/webview/ui/tools/i;I)Z
        //   1435: ifeq +75 -> 1510
        //   1438: aload_0
        //   1439: getfield 21	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebo	Lcom/tencent/mm/protocal/JsapiPermissionWrapper;
        //   1442: sipush 133
        //   1445: invokestatic 115	com/tencent/mm/plugin/webview/ui/tools/i:a	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
        //   1448: ifeq +62 -> 1510
        //   1451: aload_0
        //   1452: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1455: invokevirtual 123	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   1458: invokestatic 333	com/tencent/mm/plugin/webview/stub/a:gU	(Landroid/content/Context;)Z
        //   1461: ifeq +49 -> 1510
        //   1464: aload_0
        //   1465: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1468: bipush 22
        //   1470: invokevirtual 119	com/tencent/mm/plugin/webview/ui/tools/i:Xu	(I)Z
        //   1473: ifeq +37 -> 1510
        //   1476: aload_1
        //   1477: bipush 22
        //   1479: aload_0
        //   1480: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1483: invokevirtual 123	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   1486: ldc_w 336
        //   1489: invokevirtual 130	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
        //   1492: ldc_w 337
        //   1495: iconst_0
        //   1496: aload_0
        //   1497: getfield 21	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebo	Lcom/tencent/mm/protocal/JsapiPermissionWrapper;
        //   1500: sipush 133
        //   1503: invokestatic 144	com/tencent/mm/plugin/webview/ui/tools/i:b	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
        //   1506: invokevirtual 147	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;IIZ)Landroid/view/MenuItem;
        //   1509: pop
        //   1510: aload_0
        //   1511: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1514: iconst_0
        //   1515: invokestatic 111	com/tencent/mm/plugin/webview/ui/tools/i:b	(Lcom/tencent/mm/plugin/webview/ui/tools/i;I)Z
        //   1518: ifeq +133 -> 1651
        //   1521: aload_0
        //   1522: getfield 21	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebo	Lcom/tencent/mm/protocal/JsapiPermissionWrapper;
        //   1525: bipush 43
        //   1527: invokestatic 115	com/tencent/mm/plugin/webview/ui/tools/i:a	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
        //   1530: ifeq +121 -> 1651
        //   1533: aload_0
        //   1534: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1537: iconst_0
        //   1538: invokevirtual 119	com/tencent/mm/plugin/webview/ui/tools/i:Xu	(I)Z
        //   1541: ifeq +110 -> 1651
        //   1544: aload_0
        //   1545: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1548: invokevirtual 123	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   1551: getfield 158	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:DIv	Lcom/tencent/mm/plugin/webview/core/h;
        //   1554: getfield 189	com/tencent/mm/plugin/webview/core/h:lvv	Lcom/tencent/mm/plugin/webview/stub/e;
        //   1557: invokeinterface 340 1 0
        //   1562: ifeq +89 -> 1651
        //   1565: aload_0
        //   1566: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1569: invokevirtual 123	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   1572: getfield 158	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:DIv	Lcom/tencent/mm/plugin/webview/core/h;
        //   1575: getfield 189	com/tencent/mm/plugin/webview/core/h:lvv	Lcom/tencent/mm/plugin/webview/stub/e;
        //   1578: invokeinterface 344 1 0
        //   1583: astore 8
        //   1585: aload 8
        //   1587: invokeinterface 350 1 0
        //   1592: astore 9
        //   1594: aload 9
        //   1596: invokeinterface 355 1 0
        //   1601: ifeq +458 -> 2059
        //   1604: aload_1
        //   1605: aload 9
        //   1607: invokeinterface 359 1 0
        //   1612: checkcast 227	java/lang/String
        //   1615: invokevirtual 363	com/tencent/mm/ui/base/l:add	(Ljava/lang/CharSequence;)Landroid/view/MenuItem;
        //   1618: pop
        //   1619: goto -25 -> 1594
        //   1622: astore 8
        //   1624: ldc_w 365
        //   1627: new 367	java/lang/StringBuilder
        //   1630: dup
        //   1631: ldc_w 369
        //   1634: invokespecial 372	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   1637: aload 8
        //   1639: invokevirtual 375	java/lang/Exception:getMessage	()Ljava/lang/String;
        //   1642: invokevirtual 379	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1645: invokevirtual 382	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   1648: invokestatic 387	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
        //   1651: aload_0
        //   1652: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1655: bipush 27
        //   1657: invokestatic 111	com/tencent/mm/plugin/webview/ui/tools/i:b	(Lcom/tencent/mm/plugin/webview/ui/tools/i;I)Z
        //   1660: ifeq +55 -> 1715
        //   1663: aload_0
        //   1664: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1667: invokevirtual 123	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   1670: getfield 391	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:EcK	Lcom/tencent/mm/plugin/webview/ui/tools/widget/MovingImageButton;
        //   1673: ifnull +42 -> 1715
        //   1676: aload_0
        //   1677: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1680: invokevirtual 123	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   1683: getfield 391	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:EcK	Lcom/tencent/mm/plugin/webview/ui/tools/widget/MovingImageButton;
        //   1686: invokevirtual 396	com/tencent/mm/plugin/webview/ui/tools/widget/MovingImageButton:getVisibility	()I
        //   1689: ifne +26 -> 1715
        //   1692: aload_1
        //   1693: bipush 27
        //   1695: aload_0
        //   1696: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1699: invokevirtual 123	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   1702: ldc_w 397
        //   1705: invokevirtual 130	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
        //   1708: ldc_w 398
        //   1711: invokevirtual 306	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;I)Landroid/view/MenuItem;
        //   1714: pop
        //   1715: aload_0
        //   1716: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1719: invokevirtual 123	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   1722: aload_0
        //   1723: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1726: invokevirtual 123	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   1729: invokevirtual 216	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:eSK	()Ljava/lang/String;
        //   1732: invokevirtual 401	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:aGj	(Ljava/lang/String;)Ljava/lang/String;
        //   1735: astore 8
        //   1737: aload_0
        //   1738: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1741: invokevirtual 277	com/tencent/mm/plugin/webview/ui/tools/a:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   1744: invokevirtual 281	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
        //   1747: ldc_w 403
        //   1750: invokevirtual 289	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
        //   1753: astore 9
        //   1755: aload_0
        //   1756: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1759: invokevirtual 123	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   1762: getfield 406	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Edc	Z
        //   1765: ifne +89 -> 1854
        //   1768: aload 8
        //   1770: invokestatic 222	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
        //   1773: ifne +81 -> 1854
        //   1776: aload 9
        //   1778: invokestatic 222	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
        //   1781: ifne +73 -> 1854
        //   1784: aload_0
        //   1785: getfield 21	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebo	Lcom/tencent/mm/protocal/JsapiPermissionWrapper;
        //   1788: sipush 255
        //   1791: invokestatic 115	com/tencent/mm/plugin/webview/ui/tools/i:a	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
        //   1794: ifeq +60 -> 1854
        //   1797: aload_0
        //   1798: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1801: bipush 29
        //   1803: invokevirtual 119	com/tencent/mm/plugin/webview/ui/tools/i:Xu	(I)Z
        //   1806: ifeq +48 -> 1854
        //   1809: aload_0
        //   1810: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1813: bipush 29
        //   1815: invokestatic 111	com/tencent/mm/plugin/webview/ui/tools/i:b	(Lcom/tencent/mm/plugin/webview/ui/tools/i;I)Z
        //   1818: ifeq +36 -> 1854
        //   1821: aload_1
        //   1822: bipush 29
        //   1824: aload_0
        //   1825: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1828: invokevirtual 123	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   1831: ldc_w 407
        //   1834: invokevirtual 130	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
        //   1837: ldc_w 408
        //   1840: aload_0
        //   1841: getfield 21	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebo	Lcom/tencent/mm/protocal/JsapiPermissionWrapper;
        //   1844: sipush 255
        //   1847: invokestatic 144	com/tencent/mm/plugin/webview/ui/tools/i:b	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
        //   1850: invokevirtual 324	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;IZ)Landroid/view/MenuItem;
        //   1853: pop
        //   1854: aload_0
        //   1855: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1858: iconst_1
        //   1859: putfield 411	com/tencent/mm/plugin/webview/ui/tools/i:orZ	Z
        //   1862: aload_0
        //   1863: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1866: getfield 415	com/tencent/mm/plugin/webview/ui/tools/i:mDL	Lcom/tencent/mm/ui/widget/a/e;
        //   1869: invokevirtual 420	com/tencent/mm/ui/widget/a/e:fMg	()V
        //   1872: ldc 30
        //   1874: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   1877: return
        //   1878: astore 8
        //   1880: iconst_m1
        //   1881: istore_3
        //   1882: ldc_w 365
        //   1885: new 367	java/lang/StringBuilder
        //   1888: dup
        //   1889: ldc_w 422
        //   1892: invokespecial 372	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   1895: aload 8
        //   1897: invokevirtual 375	java/lang/Exception:getMessage	()Ljava/lang/String;
        //   1900: invokevirtual 379	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1903: invokevirtual 382	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   1906: invokestatic 425	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   1909: iconst_m1
        //   1910: istore_2
        //   1911: goto -1543 -> 368
        //   1914: aload_0
        //   1915: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1918: bipush 39
        //   1920: invokevirtual 119	com/tencent/mm/plugin/webview/ui/tools/i:Xu	(I)Z
        //   1923: ifeq -1486 -> 437
        //   1926: iload_2
        //   1927: iconst_1
        //   1928: if_icmpne -1491 -> 437
        //   1931: aload_1
        //   1932: bipush 39
        //   1934: aload_0
        //   1935: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1938: invokevirtual 123	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   1941: ldc_w 426
        //   1944: invokevirtual 130	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
        //   1947: ldc_w 427
        //   1950: aload_0
        //   1951: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   1954: invokevirtual 123	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
        //   1957: invokevirtual 135	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getResources	()Landroid/content/res/Resources;
        //   1960: ldc 206
        //   1962: invokevirtual 142	android/content/res/Resources:getColor	(I)I
        //   1965: invokevirtual 209	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;II)Landroid/view/MenuItem;
        //   1968: pop
        //   1969: goto -1532 -> 437
        //   1972: astore 8
        //   1974: ldc_w 365
        //   1977: aload 8
        //   1979: ldc_w 429
        //   1982: iconst_0
        //   1983: anewarray 4	java/lang/Object
        //   1986: invokestatic 433	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   1989: goto -1192 -> 797
        //   1992: astore 8
        //   1994: ldc_w 365
        //   1997: aload 8
        //   1999: ldc_w 429
        //   2002: iconst_0
        //   2003: anewarray 4	java/lang/Object
        //   2006: invokestatic 433	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   2009: goto -932 -> 1077
        //   2012: astore 8
        //   2014: ldc_w 365
        //   2017: new 367	java/lang/StringBuilder
        //   2020: dup
        //   2021: ldc_w 369
        //   2024: invokespecial 372	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   2027: aload 8
        //   2029: invokevirtual 375	java/lang/Exception:getMessage	()Ljava/lang/String;
        //   2032: invokevirtual 379	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   2035: invokevirtual 382	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   2038: invokestatic 387	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
        //   2041: iconst_0
        //   2042: istore 7
        //   2044: goto -856 -> 1188
        //   2047: ldc_w 365
        //   2050: ldc_w 435
        //   2053: invokestatic 437	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   2056: goto -712 -> 1344
        //   2059: aload_0
        //   2060: getfield 19	com/tencent/mm/plugin/webview/ui/tools/i$14:Ebl	Lcom/tencent/mm/plugin/webview/ui/tools/i;
        //   2063: aload 8
        //   2065: invokestatic 440	com/tencent/mm/plugin/webview/ui/tools/i:a	(Lcom/tencent/mm/plugin/webview/ui/tools/i;Ljava/util/List;)V
        //   2068: goto -417 -> 1651
        //   2071: astore 9
        //   2073: goto -785 -> 1288
        //   2076: astore 8
        //   2078: iload_2
        //   2079: istore_3
        //   2080: goto -198 -> 1882
        //   2083: iconst_m1
        //   2084: istore_2
        //   2085: iconst_m1
        //   2086: istore_3
        //   2087: goto -1719 -> 368
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	2090	0	this	14
        //   0	2090	1	paramAnonymousl	l
        //   46	2039	2	i	int
        //   44	2043	3	j	int
        //   361	5	4	k	int
        //   1015	28	5	l	long
        //   1186	857	7	bool	boolean
        //   66	1520	8	localObject1	Object
        //   1622	16	8	localException1	Exception
        //   1735	34	8	str	String
        //   1878	18	8	localException2	Exception
        //   1972	6	8	localException3	Exception
        //   1992	6	8	localException4	Exception
        //   2012	52	8	localException5	Exception
        //   2076	1	8	localException6	Exception
        //   85	1692	9	localObject2	Object
        //   2071	1	9	localException7	Exception
        // Exception table:
        //   from	to	target	type
        //   1510	1594	1622	java/lang/Exception
        //   1594	1619	1622	java/lang/Exception
        //   2059	2068	1622	java/lang/Exception
        //   263	339	1878	java/lang/Exception
        //   344	353	1878	java/lang/Exception
        //   733	797	1972	java/lang/Exception
        //   1017	1077	1992	java/lang/Exception
        //   1129	1173	2012	java/lang/Exception
        //   1178	1188	2012	java/lang/Exception
        //   1264	1284	2071	java/lang/Exception
        //   353	363	2076	java/lang/Exception
      }
    };
    Object localObject4 = eRK().eNy();
    eRK();
    Object localObject1 = n.aIT((String)localObject4);
    int i;
    if ((com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class) != null) && (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).isMpUrl((String)localObject4)))
    {
      i = 1;
      this.mDL.KWs = new n.d()
      {
        public final void onCreateMMMenu(l paramAnonymousl)
        {
          AppMethodBeat.i(79873);
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(480L, 0L, 1L, false);
          paramAnonymousl.clear();
          if (i.this.Ebk.booleanValue())
          {
            AppMethodBeat.o(79873);
            return;
          }
          if ((i.this.eRK().EdZ != null) && (i.this.eRK().EdZ.EeJ.ePk()))
          {
            if ((!i.b(i.this, 35)) || (!i.this.Xu(35)) || (i.this.eRK().EdZ.bKz())) {
              break label279;
            }
            paramAnonymousl.a(35, i.this.eRK().getString(2131762178), 2131690574);
          }
          for (;;)
          {
            switch (i.this.eRK().Eeg)
            {
            }
            try
            {
              label168:
              LinkedList localLinkedList = i.this.eRK().eSZ();
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
                    localm = (m)paramAnonymousl.a(15, i.this.eRK().getString(2131766098), 2131689814);
                  }
                  for (;;)
                  {
                    if (localm != null) {
                      localm.kwk = locala.url;
                    }
                    i += 1;
                    break label187;
                    if ((!i.this.Xu(36)) || (!i.this.eRK().EdZ.bKz())) {
                      break;
                    }
                    paramAnonymousl.a(36, i.this.eRK().getString(2131762168), 2131690573);
                    break;
                    paramAnonymousl.a(40, i.this.eRK().getString(2131766150), 2131690335);
                    break label168;
                    paramAnonymousl.a(41, i.this.eRK().getString(2131766148), 2131690334);
                    break label168;
                    paramAnonymousl.a(42, i.this.eRK().getString(2131766149), 2131690335);
                    break label168;
                    if ("categories".equals(bt.nullAsNil(locala.id))) {
                      localm = (m)paramAnonymousl.a(16, i.this.eRK().getString(2131766097), 2131689813);
                    } else if ("cart".equals(bt.nullAsNil(locala.id))) {
                      localm = (m)paramAnonymousl.a(17, i.this.eRK().getString(2131766096), 2131689812);
                    } else if ("profile".equals(bt.nullAsNil(locala.id))) {
                      localm = (m)paramAnonymousl.a(18, i.this.eRK().getString(2131766100), 2131689820);
                    } else if ("member".equals(bt.nullAsNil(locala.id))) {
                      localm = (m)paramAnonymousl.a(19, i.this.eRK().getString(2131766099), 2131689815);
                    }
                  }
                }
              }
              try
              {
                bool1 = i.this.eRK().DIv.lvv.zE((String)localObject);
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
                    i.this.eRK().DIv.lvv.aIw((String)localObject);
                    if (i.this.Xu(10)) {
                      paramAnonymousl.a(10, i.this.eRK().getString(2131756596), 2131690646);
                    }
                    if ((i.b(i.this, 6)) && (i.a(this.Ebo, 44)) && (i.this.Xu(6))) {
                      paramAnonymousl.a(6, i.this.eRK().getString(2131766247), 2131690588, i.b(this.Ebo, 44));
                    }
                    if ((i.b(i.this, 28)) && (i.this.Xu(28))) {
                      paramAnonymousl.a(28, i.this.eRK().getString(2131766077), 2131690644);
                    }
                    if (((paramLong & 1L) == 0L) && (i.b(i.this, 31))) {
                      paramAnonymousl.a(31, i.this.eRK().getString(2131766282), 2131689494);
                    }
                    if ((this.Ebo.FnH != null) && (i.this.eRK().Eda) && (!bt.isNullOrNil(i.this.eRK().eSK())) && (!bt.isNullOrNil(i.this.eRK().Eev)) && (i.this.eRK().eSK().startsWith(i.this.eRK().Eev)) && (i.this.eRK().getIntent().getBooleanExtra("key_detail_can_delete", true)) && (i.this.eSk()))
                    {
                      if ((i.b(i.this, 12)) && (i.this.Xu(12))) {
                        paramAnonymousl.a(12, i.this.eRK().getString(2131758846), 2131689794);
                      }
                      if (i.b(i.this, 9)) {
                        paramAnonymousl.a(9, i.this.eRK().getString(2131755707), 2131689802);
                      }
                    }
                    if (i.b(i.this, 37))
                    {
                      i.this.eRK();
                      if ((com.tencent.mm.plugin.webview.c.a(i.this.eRK().omW)) && (i.this.Xu(37))) {
                        paramAnonymousl.a(37, i.this.eRK().getString(2131766125), 2131690669);
                      }
                    }
                    if (((paramLong & 0x2) == 0L) && (i.b(i.this, 11)) && (i.a(this.Ebo, 18)) && (i.this.Xu(11))) {
                      paramAnonymousl.a(11, i.this.eRK().getString(2131762162), 2131690578, i.b(this.Ebo, 18));
                    }
                    if ((com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.i.DEBUG) || (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qEO, 0) == 1))
                    {
                      localObject = i.this.eRK();
                      if (!j.eOR()) {
                        break label1588;
                      }
                      i = 2131766119;
                      paramAnonymousl.a(99, ((WebViewUI)localObject).getString(i), 2131691441, false);
                    }
                    i.this.orZ = true;
                    i.this.mDL.fMg();
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
                    bool1 = i.this.eRK().DIv.lvv.zD(localException2);
                    if (bool1)
                    {
                      bool1 = i.a(this.Ebo, 19);
                      bool2 = i.b(this.Ebo, 19);
                      boolean bool3 = i.this.eRK().eNF();
                      if ((!i.b(i.this, 5)) || (!bool1) || (!i.this.Xu(5))) {
                        continue;
                      }
                      if (!bool3) {
                        break label1544;
                      }
                      paramAnonymousl.a(5, i.this.eRK().getString(2131766259), 2131690612, bool2);
                    }
                  }
                  catch (Exception localException3)
                  {
                    for (;;)
                    {
                      ad.e("MicroMsg.WebViewMenuHelper", "sharebtn click fail, ex = " + localException3.getMessage());
                      bool1 = false;
                      continue;
                      bool1 = i.a(this.Ebo, 20);
                      bool2 = i.b(this.Ebo, 20);
                    }
                  }
                  if ((this.Ebq == null) || (!this.Ebq.DWz))
                  {
                    paramAnonymousl.a(5, i.this.eRK().getString(2131766258), 2131690612, bool2);
                    continue;
                    i = 2131766120;
                  }
                }
              }
            }
            catch (Exception localException1)
            {
              ad.e("MicroMsg.WebViewMenuHelper", "exception in add jd menu, " + localException1.getMessage());
              localObject = i.this.eRK().getIntent().getStringExtra("srcUsername");
              if (bt.isNullOrNil((String)localObject)) {}
            }
          }
        }
      };
      this.mDL.KWv = ((n.e)localObject2);
      localObject2 = eRK().DIv.getCurrentUrl();
      if (bt.isNullOrNil((String)localObject2)) {
        break label813;
      }
      localObject3 = Uri.parse((String)localObject2).getHost();
      localObject4 = eRK().getString(2131766116, new Object[] { localObject3 });
      if (!bt.isNullOrNil(this.Ebe)) {
        break label642;
      }
      if ((i == 0) || (localObject1 == null) || (!((n.a)localObject1).isDataValid())) {
        break label621;
      }
      localObject2 = LayoutInflater.from(eRK()).inflate(2131494913, null);
      localObject3 = (ImageView)((View)localObject2).findViewById(2131301214);
      Object localObject5 = (TextView)((View)localObject2).findViewById(2131306141);
      localObject4 = ((View)localObject2).findViewById(2131298761);
      ((TextView)localObject5).setText(((n.a)localObject1).EeQ);
      localObject5 = new c.a();
      ((c.a)localObject5).idq = true;
      ((c.a)localObject5).hfi = true;
      ((c.a)localObject5).idD = 2131231875;
      com.tencent.mm.aw.a.a.aIP().a(((n.a)localObject1).EeR, (ImageView)localObject3, ((c.a)localObject5).aJc());
      ((View)localObject4).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(175795);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/WebViewMenuHelper$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          i.this.fP("Contact_Scene", 173);
          i.this.eRK().DIg.eQG().C(new Object[] { i.this.eRK().bQm(), Integer.valueOf(38), Integer.valueOf(1) }).report();
          i.this.eRK().aIR(this.Ebq.hQR);
          if (i.this.mDL != null) {
            i.this.mDL.bpT();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/WebViewMenuHelper$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(175795);
        }
      });
      o.gU((View)localObject4);
      this.mDL.K((View)localObject2, true);
      label521:
      if (!eRK().EcL) {
        break label827;
      }
      this.mDL.lzG = true;
      this.mDL.lzH = true;
      label547:
      if ((eRK().EcP == null) || (!eRK().EcP.isShown())) {
        break label846;
      }
      eRK().EcP.hide();
      this.mDL.cMW();
    }
    for (;;)
    {
      if (eRK().DzP != null) {
        eRK().DzP.aGN("");
      }
      AppMethodBeat.o(208017);
      return;
      i = 0;
      break;
      label621:
      if (bt.isNullOrNil((String)localObject3)) {
        break label521;
      }
      this.mDL.p((CharSequence)localObject4, 1);
      break label521;
      label642:
      localObject3 = LayoutInflater.from(eRK()).inflate(2131494914, null);
      localObject1 = (MMNeat7extView)((View)localObject3).findViewById(2131299007);
      this.mDL.K((View)localObject3, false);
      localObject3 = k.g(((MMNeat7extView)localObject1).getContext(), bt.nullAsNil(this.Ebe), (int)((MMNeat7extView)localObject1).getTextSize());
      ((MMNeat7extView)localObject1).ar((CharSequence)localObject3);
      localObject3 = (ClickableSpan[])((SpannableString)localObject3).getSpans(0, ((SpannableString)localObject3).length(), ClickableSpan.class);
      if ((localObject3 == null) || (localObject3.length <= 0)) {
        break label521;
      }
      ad.i("MicroMsg.WebViewMenuHelper", "terry h5 apply show");
      com.tencent.mm.plugin.report.service.g.yhR.f(16337, new Object[] { localObject2, Integer.valueOf(1), Integer.valueOf(0) });
      ((MMNeat7extView)localObject1).setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.g((NeatTextView)localObject1, new com.tencent.mm.pluginsdk.ui.span.n(((MMNeat7extView)localObject1).getContext()))
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(175796);
          boolean bool = super.onTouch(paramAnonymousView, paramAnonymousMotionEvent);
          if (bool)
          {
            ad.i("MMNeatTouchListener", "terry h5 apply click");
            com.tencent.mm.plugin.report.service.g.yhR.f(16337, new Object[] { this.val$url, Integer.valueOf(1), Integer.valueOf(1) });
          }
          AppMethodBeat.o(175796);
          return bool;
        }
      });
      break label521;
      label813:
      this.mDL.p(" ", 1);
      break label521;
      label827:
      this.mDL.lzG = false;
      this.mDL.lzH = false;
      break label547;
      label846:
      eRK().hideVKB();
      this.mDL.cMW();
    }
  }
  
  protected final boolean Xu(int paramInt)
  {
    AppMethodBeat.i(79881);
    SparseBooleanArray localSparseBooleanArray = (SparseBooleanArray)this.Eba.get(eRK().omW.getUrl());
    if ((localSparseBooleanArray != null) && (localSparseBooleanArray.get(paramInt, false)))
    {
      AppMethodBeat.o(79881);
      return false;
    }
    AppMethodBeat.o(79881);
    return true;
  }
  
  public final void Zm()
  {
    AppMethodBeat.i(79885);
    if (this.orZ) {
      Cs(0L);
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
    if ((paramJsapiPermissionWrapper.ZB(paramInt1) == 1) && (Xu(paramInt2)))
    {
      AppMethodBeat.o(79902);
      return true;
    }
    AppMethodBeat.o(79902);
    return false;
  }
  
  final void aIM(String paramString)
  {
    AppMethodBeat.i(79889);
    eRK().DzP.cn("sendAppMessage", false);
    f localf = eRK().DzP;
    if (!localf.BHY)
    {
      ad.e("MicroMsg.JsApiHandler", "onSendToEnterprise fail, not ready");
      AppMethodBeat.o(79889);
      return;
    }
    Object localObject = new HashMap();
    ((HashMap)localObject).put("scene", "enterprise");
    localObject = l.a.b("menu:share:appmessage", (Map)localObject, localf.DMD, localf.vJP);
    localf.DMv.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + (String)localObject + ")", null);
    try
    {
      localf.lvv.ah("connector_local_send", paramString, localf.DMF);
      localf.lvv.ah("scene", "enterprise", localf.DMF);
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
  protected final void aIN(String paramString)
  {
    // Byte code:
    //   0: ldc_w 1068
    //   3: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokevirtual 220	com/tencent/mm/plugin/webview/ui/tools/a:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   10: invokevirtual 224	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   13: ldc 226
    //   15: invokevirtual 231	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   18: astore 7
    //   20: aload_0
    //   21: invokevirtual 156	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   24: invokevirtual 522	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:eNy	()Ljava/lang/String;
    //   27: astore 8
    //   29: aconst_null
    //   30: astore 4
    //   32: aload 8
    //   34: invokestatic 497	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   37: ifne +13 -> 50
    //   40: aload 8
    //   42: invokestatic 612	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   45: invokevirtual 862	android/net/Uri:getHost	()Ljava/lang/String;
    //   48: astore 4
    //   50: aload 4
    //   52: invokestatic 497	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   55: ifne +495 -> 550
    //   58: aload 4
    //   60: ldc_w 1070
    //   63: invokevirtual 1073	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   66: ifeq +484 -> 550
    //   69: ldc_w 1075
    //   72: iconst_1
    //   73: anewarray 183	java/lang/Object
    //   76: dup
    //   77: iconst_0
    //   78: aload 8
    //   80: ldc_w 602
    //   83: invokestatic 219	com/tencent/mm/compatible/util/q:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   86: aastore
    //   87: invokestatic 1079	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   90: astore 4
    //   92: aload_0
    //   93: invokevirtual 156	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   96: aload_0
    //   97: invokevirtual 156	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   100: getfield 323	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:omW	Lcom/tencent/mm/ui/widget/MMWebView;
    //   103: invokevirtual 328	com/tencent/mm/ui/widget/MMWebView:getUrl	()Ljava/lang/String;
    //   106: invokevirtual 164	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:aGj	(Ljava/lang/String;)Ljava/lang/String;
    //   109: astore 9
    //   111: ldc 172
    //   113: ldc_w 1081
    //   116: iconst_1
    //   117: anewarray 183	java/lang/Object
    //   120: dup
    //   121: iconst_0
    //   122: getstatic 1084	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   125: aastore
    //   126: invokestatic 211	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   129: aload 9
    //   131: invokestatic 170	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   134: ifne +175 -> 309
    //   137: aload_0
    //   138: invokevirtual 156	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   141: getfield 323	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:omW	Lcom/tencent/mm/ui/widget/MMWebView;
    //   144: invokevirtual 328	com/tencent/mm/ui/widget/MMWebView:getUrl	()Ljava/lang/String;
    //   147: invokestatic 170	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   150: ifne +159 -> 309
    //   153: invokestatic 192	com/tencent/mm/sdk/platformtools/bt:aQJ	()J
    //   156: lstore_2
    //   157: ldc 172
    //   159: ldc_w 1086
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
    //   191: invokevirtual 156	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   194: getfield 323	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:omW	Lcom/tencent/mm/ui/widget/MMWebView;
    //   197: invokevirtual 328	com/tencent/mm/ui/widget/MMWebView:getUrl	()Ljava/lang/String;
    //   200: aastore
    //   201: dup
    //   202: iconst_4
    //   203: aload_0
    //   204: invokevirtual 156	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
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
    //   226: invokestatic 211	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   229: ldc 105
    //   231: astore 5
    //   233: aload_0
    //   234: invokevirtual 156	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   237: getfield 323	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:omW	Lcom/tencent/mm/ui/widget/MMWebView;
    //   240: invokevirtual 328	com/tencent/mm/ui/widget/MMWebView:getUrl	()Ljava/lang/String;
    //   243: ldc 213
    //   245: invokestatic 219	com/tencent/mm/compatible/util/q:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   248: astore 6
    //   250: aload 6
    //   252: astore 5
    //   254: getstatic 241	com/tencent/mm/plugin/report/service/g:yhR	Lcom/tencent/mm/plugin/report/service/g;
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
    //   285: invokevirtual 156	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
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
    //   306: invokevirtual 245	com/tencent/mm/plugin/report/service/g:f	(I[Ljava/lang/Object;)V
    //   309: aload 4
    //   311: astore 5
    //   313: aload 4
    //   315: invokestatic 497	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   318: ifeq +23 -> 341
    //   321: ldc_w 1088
    //   324: iconst_1
    //   325: anewarray 183	java/lang/Object
    //   328: dup
    //   329: iconst_0
    //   330: bipush 34
    //   332: invokestatic 200	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   335: aastore
    //   336: invokestatic 1079	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   339: astore 5
    //   341: new 228	android/content/Intent
    //   344: dup
    //   345: invokespecial 1089	android/content/Intent:<init>	()V
    //   348: astore 4
    //   350: aload_1
    //   351: invokestatic 497	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   354: ifne +23 -> 377
    //   357: aload 4
    //   359: ldc_w 1091
    //   362: aload_1
    //   363: ldc 213
    //   365: invokevirtual 1095	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   368: bipush 11
    //   370: invokestatic 1101	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   373: invokevirtual 1105	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   376: pop
    //   377: ldc 172
    //   379: ldc_w 1107
    //   382: iconst_2
    //   383: anewarray 183	java/lang/Object
    //   386: dup
    //   387: iconst_0
    //   388: aload 8
    //   390: aastore
    //   391: dup
    //   392: iconst_1
    //   393: aload_0
    //   394: invokevirtual 156	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   397: invokevirtual 598	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bQm	()Ljava/lang/String;
    //   400: aastore
    //   401: invokestatic 186	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   404: aload 4
    //   406: ldc_w 1109
    //   409: aload 5
    //   411: invokevirtual 1105	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   414: pop
    //   415: aload 4
    //   417: ldc_w 1111
    //   420: aload 8
    //   422: invokevirtual 1105	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   425: pop
    //   426: aload 4
    //   428: ldc_w 1113
    //   431: aload_0
    //   432: invokevirtual 156	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   435: invokevirtual 598	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bQm	()Ljava/lang/String;
    //   438: invokevirtual 1105	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   441: pop
    //   442: aload 4
    //   444: ldc_w 1115
    //   447: aload_0
    //   448: invokevirtual 156	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   451: aload 7
    //   453: invokevirtual 235	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:aGo	(Ljava/lang/String;)I
    //   456: invokevirtual 1118	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   459: pop
    //   460: aload 4
    //   462: ldc_w 1120
    //   465: iconst_1
    //   466: invokevirtual 1123	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   469: pop
    //   470: aload_0
    //   471: invokevirtual 156	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   474: aload_0
    //   475: invokevirtual 156	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   478: ldc_w 1124
    //   481: invokevirtual 286	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
    //   484: ldc 105
    //   486: aload_0
    //   487: invokevirtual 156	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   490: ldc_w 1125
    //   493: invokevirtual 286	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
    //   496: aload_0
    //   497: invokevirtual 156	com/tencent/mm/plugin/webview/ui/tools/i:eRK	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   500: ldc_w 1126
    //   503: invokevirtual 286	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
    //   506: iconst_0
    //   507: new 34	com/tencent/mm/plugin/webview/ui/tools/i$5
    //   510: dup
    //   511: aload_0
    //   512: aload 4
    //   514: invokespecial 1129	com/tencent/mm/plugin/webview/ui/tools/i$5:<init>	(Lcom/tencent/mm/plugin/webview/ui/tools/i;Landroid/content/Intent;)V
    //   517: new 36	com/tencent/mm/plugin/webview/ui/tools/i$6
    //   520: dup
    //   521: aload_0
    //   522: aload 4
    //   524: invokespecial 1130	com/tencent/mm/plugin/webview/ui/tools/i$6:<init>	(Lcom/tencent/mm/plugin/webview/ui/tools/i;Landroid/content/Intent;)V
    //   527: invokestatic 1133	com/tencent/mm/ui/base/h:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLandroid/content/DialogInterface$OnClickListener;Landroid/content/DialogInterface$OnClickListener;)Lcom/tencent/mm/ui/widget/a/d;
    //   530: pop
    //   531: ldc_w 1068
    //   534: invokestatic 147	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   537: return
    //   538: astore 4
    //   540: ldc 172
    //   542: aload 4
    //   544: invokevirtual 1134	java/io/UnsupportedEncodingException:getMessage	()Ljava/lang/String;
    //   547: invokestatic 300	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   550: aconst_null
    //   551: astore 4
    //   553: goto -461 -> 92
    //   556: astore 6
    //   558: ldc 172
    //   560: aload 6
    //   562: ldc 105
    //   564: iconst_0
    //   565: anewarray 183	java/lang/Object
    //   568: invokestatic 249	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   571: goto -317 -> 254
    //   574: astore_1
    //   575: ldc 172
    //   577: new 469	java/lang/StringBuilder
    //   580: dup
    //   581: ldc_w 1136
    //   584: invokespecial 473	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   587: aload_1
    //   588: invokevirtual 1134	java/io/UnsupportedEncodingException:getMessage	()Ljava/lang/String;
    //   591: invokevirtual 477	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   594: invokevirtual 482	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   597: invokestatic 300	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
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
  
  protected final void bLY()
  {
    AppMethodBeat.i(79897);
    String str1 = eRK().aGj(eRK().eSK());
    String str2 = eRK().getIntent().getStringExtra("shortcut_user_name");
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
      eRK().DIv.lvv.k(80, localBundle);
      AppMethodBeat.o(79897);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.WebViewMenuHelper", "addShortcut, e = " + localException.getMessage());
      AppMethodBeat.o(79897);
    }
  }
  
  protected final void bQS()
  {
    AppMethodBeat.i(221644);
    Cs(0L);
    AppMethodBeat.o(221644);
  }
  
  public final void bQT()
  {
    AppMethodBeat.i(79900);
    if ((eRK() == null) || (eRK().omW == null) || (eRK().lvw == null))
    {
      ad.e("MicroMsg.WebViewMenuHelper", "setShareFuncFlag params failed");
      AppMethodBeat.o(79900);
      return;
    }
    String str = eRK().omW.getUrl();
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
    int i = eSm();
    if (eRK().DzP != null) {
      eRK().DzP.fA("setFuncFlag", i);
    }
    AppMethodBeat.o(79900);
  }
  
  public final void eSe()
  {
    AppMethodBeat.i(79879);
    this.Ebb.clear();
    this.Ebb.put("menuItem:share:brand", Integer.valueOf(0));
    this.Ebb.put("menuItem:share:appMessage", Integer.valueOf(1));
    this.Ebb.put("menuItem:share:dataMessage", Integer.valueOf(23));
    this.Ebb.put("menuItem:share:timeline", Integer.valueOf(2));
    this.Ebb.put("menuItem:favorite", Integer.valueOf(3));
    this.Ebb.put("menuItem:profile", Integer.valueOf(5));
    this.Ebb.put("menuItem:addContact", Integer.valueOf(5));
    this.Ebb.put("menuItem:copyUrl", Integer.valueOf(6));
    this.Ebb.put("menuItem:openWithSafari", Integer.valueOf(7));
    this.Ebb.put("menuItem:share:email", Integer.valueOf(8));
    this.Ebb.put("menuItem:delete", Integer.valueOf(9));
    this.Ebb.put("menuItem:exposeArticle", Integer.valueOf(10));
    this.Ebb.put("menuItem:setFont", Integer.valueOf(11));
    this.Ebb.put("menuItem:editTag", Integer.valueOf(12));
    this.Ebb.put("menuItem:share:qq", Integer.valueOf(20));
    this.Ebb.put("menuItem:share:weiboApp", Integer.valueOf(21));
    this.Ebb.put("menuItem:share:QZone", Integer.valueOf(22));
    this.Ebb.put("menuItem:share:facebook", Integer.valueOf(33));
    this.Ebb.put("menuItem:share:enterprise", Integer.valueOf(24));
    this.Ebb.put("menuItem:refresh", Integer.valueOf(28));
    this.Ebb.put("menuItem:share:wework", Integer.valueOf(25));
    this.Ebb.put("menuItem:share:weread", Integer.valueOf(26));
    this.Ebb.put("menuItem:addShortcut", Integer.valueOf(29));
    this.Ebb.put("menuItem:search", Integer.valueOf(31));
    this.Ebb.put("menuItem:readArticle", Integer.valueOf(34));
    this.Ebb.put("menuItem:minimize", Integer.valueOf(35));
    this.Ebb.put("menuItem:cancelMinimize", Integer.valueOf(36));
    this.Ebb.put("menuItem:translate", Integer.valueOf(37));
    this.Ebb.put("menuItem:haoKan", Integer.valueOf(38));
    this.Ebb.put("menuItem:cancelHaoKan", Integer.valueOf(39));
    this.Ebb.put("menuItem:ttsStart", Integer.valueOf(40));
    this.Ebb.put("menuItem:ttsPause", Integer.valueOf(41));
    this.Ebb.put("menuItem:ttsResume", Integer.valueOf(42));
    AppMethodBeat.o(79879);
  }
  
  protected final void eSf()
  {
    AppMethodBeat.i(79884);
    if (!this.Ebh)
    {
      AppMethodBeat.o(79884);
      return;
    }
    this.Ebg = false;
    eRK().Eer = false;
    this.Ebh = false;
    if (this.orZ) {
      Cs(0L);
    }
    AppMethodBeat.o(79884);
  }
  
  public final void eSg()
  {
    AppMethodBeat.i(79886);
    this.Ebg = true;
    this.Ebi.clear();
    if ((eRK() instanceof GameWebViewUI))
    {
      this.Ebi.add(Integer.valueOf(11));
      this.Ebi.add(Integer.valueOf(28));
      AppMethodBeat.o(79886);
      return;
    }
    this.Ebi.add(Integer.valueOf(7));
    this.Ebi.add(Integer.valueOf(11));
    this.Ebi.add(Integer.valueOf(28));
    AppMethodBeat.o(79886);
  }
  
  protected final void eSi()
  {
    AppMethodBeat.i(79892);
    if (eRK().DzP != null)
    {
      eRK().DzP.aGN("fav");
      eRK().DzP.cn("sendAppMessage", false);
      eRK().DzP.m(eSj());
      AppMethodBeat.o(79892);
      return;
    }
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putLong("msg_id", eRK().getIntent().getLongExtra("msg_id", -9223372036854775808L));
    ((Bundle)localObject1).putString("sns_local_id", eRK().getIntent().getStringExtra("sns_local_id"));
    ((Bundle)localObject1).putInt("news_svr_id", eRK().getIntent().getIntExtra("news_svr_id", 0));
    ((Bundle)localObject1).putString("news_svr_tweetid", eRK().getIntent().getStringExtra("news_svr_tweetid"));
    ((Bundle)localObject1).putInt("message_index", eRK().getIntent().getIntExtra("message_index", 0));
    ((Bundle)localObject1).putString("rawUrl", eRK().bQm());
    Object localObject2;
    if ((!bt.isNullOrNil(eRK().bQm())) && (eRK().bQm().endsWith("#rd")))
    {
      localObject2 = eRK().bQm().substring(0, eRK().bQm().length() - 3);
      if ((!bt.isNullOrNil(eRK().eSK())) && (!eRK().eSK().startsWith((String)localObject2)))
      {
        ((Bundle)localObject1).putString("rawUrl", eRK().eSK());
        ((Bundle)localObject1).putLong("msg_id", -9223372036854775808L);
      }
    }
    for (;;)
    {
      localObject2 = eRK().getIntent();
      if (localObject2 != null)
      {
        ((Bundle)localObject1).putString("preChatName", ((Intent)localObject2).getStringExtra("preChatName"));
        ((Bundle)localObject1).putInt("preMsgIndex", ((Intent)localObject2).getIntExtra("preMsgIndex", 0));
        ((Bundle)localObject1).putString("prePublishId", ((Intent)localObject2).getStringExtra("prePublishId"));
        ((Bundle)localObject1).putString("preUsername", ((Intent)localObject2).getStringExtra("preUsername"));
      }
      try
      {
        localObject1 = eRK().DIv.lvv.aL((Bundle)localObject1);
        if (((com.tencent.mm.plugin.webview.stub.c)localObject1).eRs())
        {
          eRK().DzP.cn("sendAppMessage", false);
          eRK().DzP.m(eSj());
          ad.i("MicroMsg.WebViewMenuHelper", "on favorite simple url");
          AppMethodBeat.o(79892);
          return;
          if ((!bt.isNullOrNil(eRK().eSK())) && (!eRK().eSK().startsWith(eRK().bQm())))
          {
            ((Bundle)localObject1).putString("rawUrl", eRK().eSK());
            ((Bundle)localObject1).putLong("msg_id", -9223372036854775808L);
          }
        }
        else
        {
          com.tencent.mm.plugin.fav.ui.e.a(((com.tencent.mm.plugin.webview.stub.c)localObject1).getRet(), eRK(), eRK().tUH);
          if (((com.tencent.mm.plugin.webview.stub.c)localObject1).getRet() == 0)
          {
            Xv(1);
            AppMethodBeat.o(79892);
            return;
          }
        }
      }
      catch (Exception localException)
      {
        ad.e("MicroMsg.WebViewMenuHelper", "edw, favoriteUrl fail, ex = " + localException.getMessage());
        AppMethodBeat.o(79892);
        return;
      }
    }
    Xv(2);
    AppMethodBeat.o(79892);
  }
  
  public final HashMap<String, String> eSj()
  {
    AppMethodBeat.i(79893);
    if (!eRK().Eer)
    {
      AppMethodBeat.o(79893);
      return null;
    }
    Intent localIntent = eRK().getIntent();
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
  
  final boolean eSk()
  {
    AppMethodBeat.i(79896);
    try
    {
      boolean bool = eRK().DIv.lvv.aIu("favorite");
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
  
  public final void eSl()
  {
    AppMethodBeat.i(79899);
    if ((eRK() == null) || (eRK().lvw == null))
    {
      ad.e("MicroMsg.WebViewMenuHelper", "showShareMenu params failed");
      AppMethodBeat.o(79899);
      return;
    }
    final JsapiPermissionWrapper localJsapiPermissionWrapper = eRK().lvw.eRg();
    if ((!a(localJsapiPermissionWrapper, 21, 1)) && (!a(localJsapiPermissionWrapper, 23, 2)))
    {
      com.tencent.mm.ui.base.h.cl(eRK(), eRK().getString(2131766260));
      AppMethodBeat.o(79899);
      return;
    }
    com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(eRK(), 1, false);
    locale.KJy = new n.d()
    {
      public final void onCreateMMMenu(l paramAnonymousl)
      {
        AppMethodBeat.i(208012);
        if (i.this.a(localJsapiPermissionWrapper, 21, 1)) {
          paramAnonymousl.a(1, i.this.eRK().getString(2131762163), 2131689831, false);
        }
        if (i.this.a(localJsapiPermissionWrapper, 23, 2)) {
          paramAnonymousl.a(2, i.this.eRK().getString(2131762164), 2131689817, false);
        }
        AppMethodBeat.o(208012);
      }
    };
    locale.KJz = new n.e()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        paramAnonymousInt = 0;
        AppMethodBeat.i(208013);
        switch (paramAnonymousMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(208013);
          return;
          paramAnonymousMenuItem = i.this.eRK().getIntent().getStringExtra("KPublisherId");
          String str1 = i.this.eRK().getIntent().getStringExtra("KAppId");
          String str2 = i.this.eRK().getIntent().getStringExtra("srcUsername");
          i.this.eRK().DIg.eQG().C(new Object[] { i.this.eRK().bQm(), Integer.valueOf(1), Integer.valueOf(1), paramAnonymousMenuItem, str1, str2 }).report();
          i.this.eRK().XA(1);
          AppMethodBeat.o(208013);
          return;
          paramAnonymousMenuItem = i.this.eRK().getIntent().getStringExtra("KPublisherId");
          str1 = i.this.eRK().getIntent().getStringExtra("KAppId");
          str2 = i.this.eRK().getIntent().getStringExtra("srcUsername");
          i.this.eRK().DIg.eQG().C(new Object[] { i.this.eRK().bQm(), Integer.valueOf(2), Integer.valueOf(1), paramAnonymousMenuItem, str1, str2 }).report();
          if (i.this.Ebf.containsKey(i.this.eRK().omW.getUrl())) {
            paramAnonymousInt = ((Integer)i.this.Ebf.get(i.this.eRK().omW.getUrl())).intValue();
          }
          i.a(i.this, paramAnonymousInt, 1);
        }
      }
    };
    locale.p(" ", 1);
    locale.cMW();
    AppMethodBeat.o(79899);
  }
  
  public final int eSm()
  {
    AppMethodBeat.i(79901);
    if ((eRK() == null) || (eRK().lvw == null))
    {
      ad.e("MicroMsg.WebViewMenuHelper", "getShareFuncFlag params failed");
      AppMethodBeat.o(79901);
      return -1;
    }
    JsapiPermissionWrapper localJsapiPermissionWrapper = eRK().lvw.eRg();
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
  
  public final void f(String paramString, Intent paramIntent)
  {
    AppMethodBeat.i(208015);
    SparseBooleanArray localSparseBooleanArray2 = (SparseBooleanArray)this.Eba.get(paramString);
    SparseBooleanArray localSparseBooleanArray1 = localSparseBooleanArray2;
    if (localSparseBooleanArray2 == null)
    {
      localSparseBooleanArray1 = new SparseBooleanArray();
      this.Eba.put(paramString, localSparseBooleanArray1);
    }
    if (localSparseBooleanArray1 != null)
    {
      localSparseBooleanArray1.put(34, true);
      localSparseBooleanArray1.put(10, paramIntent.getBooleanExtra("key_menu_hide_expose", false));
    }
    AppMethodBeat.o(208015);
  }
  
  public final void fP(String paramString, int paramInt)
  {
    AppMethodBeat.i(79895);
    if (eRK().DzP != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt(paramString, paramInt);
      paramString = eRK().DzP;
      try
      {
        paramString.lvv.a(21, localBundle, paramString.DMF);
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
    Iterator localIterator = this.Eba.values().iterator();
    while (localIterator.hasNext())
    {
      SparseBooleanArray localSparseBooleanArray = (SparseBooleanArray)localIterator.next();
      if (localSparseBooleanArray != null) {
        localSparseBooleanArray.clear();
      }
    }
    this.Eba.clear();
    this.Ebf.clear();
    if ((this.mDL != null) && (this.mDL.isShowing())) {
      this.mDL.bpT();
    }
    AppMethodBeat.o(79878);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.i
 * JD-Core Version:    0.7.0.1
 */