package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
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
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.m.d.b;
import com.tencent.mm.plugin.fav.ui.c;
import com.tencent.mm.plugin.webview.stub.b;
import com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter;
import com.tencent.mm.pluginsdk.ui.d.m;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.n.a;
import com.tencent.mm.ui.base.n.b;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class j
  extends a
{
  int height;
  com.tencent.mm.ui.widget.b.d iOd;
  public boolean kiI;
  protected Map<String, SparseBooleanArray> vcC;
  protected Map<String, Integer> vcD;
  ae<String, Bitmap> vcE;
  HashMap<String, String> vcF;
  String vcG;
  public String vcH;
  HashMap<String, Integer> vcI;
  public boolean vcJ;
  public boolean vcK;
  Set<Integer> vcL;
  ArrayList<d.b> vcM;
  Boolean vcN;
  int width;
  
  public j(WebViewUI paramWebViewUI)
  {
    super(paramWebViewUI);
    AppMethodBeat.i(7658);
    this.vcC = new HashMap();
    this.vcD = new HashMap();
    this.vcE = new ae(12);
    this.vcF = new HashMap();
    this.vcG = "";
    this.vcI = new HashMap();
    this.vcJ = true;
    this.vcK = false;
    this.kiI = false;
    this.vcL = new HashSet();
    this.width = paramWebViewUI.getResources().getDisplayMetrics().widthPixels;
    this.height = paramWebViewUI.getResources().getDisplayMetrics().heightPixels;
    AppMethodBeat.o(7658);
  }
  
  private void Kv(int paramInt)
  {
    AppMethodBeat.i(7672);
    String str2 = ddt().aiu(ddt().vgr);
    if ((TextUtils.isEmpty(ddt().vgr)) || (TextUtils.isEmpty(str2)))
    {
      ab.i("MicroMsg.WebViewMenuHelper", "stev appId is null or empty");
      AppMethodBeat.o(7672);
      return;
    }
    ab.i("MicroMsg.WebViewMenuHelper", "stev appId %s", new Object[] { str2 });
    long l = bo.aox();
    ab.d("MicroMsg.WebViewMenuHelper", "stev report(%s), clickTimestamp : %d, appID : %s, url : %s, sessionId : %s, actionType : %d, flag : %d", new Object[] { Integer.valueOf(13377), Long.valueOf(l), str2, ddt().vgr, ddt().cpW, Integer.valueOf(3), Integer.valueOf(paramInt) });
    Object localObject = "";
    try
    {
      str1 = q.encode(ddt().vgr, "UTF-8");
      localObject = str1;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        String str1;
        int i;
        ab.printErrStackTrace("MicroMsg.WebViewMenuHelper", localUnsupportedEncodingException, "", new Object[0]);
      }
    }
    i = ddt().aio(ddt().getIntent().getStringExtra("geta8key_username"));
    str1 = "";
    if ((i == 7) || (i == 56)) {
      str1 = ddt().getIntent().getStringExtra("geta8key_username");
    }
    com.tencent.mm.plugin.report.service.h.qsU.e(13377, new Object[] { Long.valueOf(l), str2, localObject, ddt().cpW, Integer.valueOf(3), Integer.valueOf(paramInt), Integer.valueOf(0), str1 });
    AppMethodBeat.o(7672);
  }
  
  protected static boolean a(JsapiPermissionWrapper paramJsapiPermissionWrapper, int paramInt)
  {
    AppMethodBeat.i(7663);
    if (paramJsapiPermissionWrapper == null)
    {
      AppMethodBeat.o(7663);
      return false;
    }
    paramInt = paramJsapiPermissionWrapper.MB(paramInt);
    if ((paramInt == 1) || (paramInt == 10))
    {
      AppMethodBeat.o(7663);
      return true;
    }
    AppMethodBeat.o(7663);
    return false;
  }
  
  protected static boolean b(JsapiPermissionWrapper paramJsapiPermissionWrapper, int paramInt)
  {
    AppMethodBeat.i(7664);
    if (paramJsapiPermissionWrapper == null)
    {
      AppMethodBeat.o(7664);
      return false;
    }
    if (paramJsapiPermissionWrapper.MB(paramInt) == 10)
    {
      AppMethodBeat.o(7664);
      return true;
    }
    AppMethodBeat.o(7664);
    return false;
  }
  
  private ArrayList<d.b> ddP()
  {
    AppMethodBeat.i(7669);
    Object localObject = ddt().pOd.getUrl();
    if (ddt().vfm.containsKey(localObject))
    {
      localObject = (ArrayList)ddt().vfm.get(localObject);
      AppMethodBeat.o(7669);
      return localObject;
    }
    AppMethodBeat.o(7669);
    return null;
  }
  
  private int ddU()
  {
    AppMethodBeat.i(153218);
    if ((ddt() == null) || (ddt().igV == null) || (ddt().igV.ddV() == null))
    {
      ab.e("MicroMsg.WebViewMenuHelper", "getShareFuncFlag params failed");
      AppMethodBeat.o(153218);
      return -1;
    }
    JsapiPermissionWrapper localJsapiPermissionWrapper = ddt().igV.ddV();
    if (a(localJsapiPermissionWrapper, 21, 1)) {}
    for (int i = 1;; i = 0)
    {
      int j = i;
      if (a(localJsapiPermissionWrapper, 23, 2)) {
        j = i | 0x2;
      }
      ab.i("MicroMsg.WebViewMenuHelper", "getShareFuncFlag %d", new Object[] { Integer.valueOf(j) });
      AppMethodBeat.o(153218);
      return j;
    }
  }
  
  public final void Km()
  {
    AppMethodBeat.i(138038);
    if (this.kiI) {
      aYo();
    }
    AppMethodBeat.o(138038);
  }
  
  protected final boolean Ku(int paramInt)
  {
    AppMethodBeat.i(7662);
    SparseBooleanArray localSparseBooleanArray = (SparseBooleanArray)this.vcC.get(ddt().pOd.getUrl());
    if ((localSparseBooleanArray != null) && (localSparseBooleanArray.get(paramInt, false)))
    {
      AppMethodBeat.o(7662);
      return false;
    }
    AppMethodBeat.o(7662);
    return true;
  }
  
  protected final boolean a(JsapiPermissionWrapper paramJsapiPermissionWrapper, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(153219);
    if (paramJsapiPermissionWrapper == null)
    {
      AppMethodBeat.o(153219);
      return false;
    }
    if ((paramJsapiPermissionWrapper.MB(paramInt1) == 1) && (Ku(paramInt2)))
    {
      AppMethodBeat.o(153219);
      return true;
    }
    AppMethodBeat.o(153219);
    return false;
  }
  
  protected final void aVC()
  {
    AppMethodBeat.i(7677);
    String str1 = ddt().aiu(ddt().vgp);
    String str2 = ddt().getIntent().getStringExtra("shortcut_user_name");
    if ((bo.isNullOrNil(str1)) || (bo.isNullOrNil(str2)))
    {
      ab.e("MicroMsg.WebViewMenuHelper", "addShortcut, appid or username is null");
      AppMethodBeat.o(7677);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("KAppId", str1);
    localBundle.putString("shortcut_user_name", str2);
    localBundle.putInt("webviewui_binder_id", hashCode());
    try
    {
      ddt().igU.i(80, localBundle);
      AppMethodBeat.o(7677);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.WebViewMenuHelper", "addShortcut, e = " + localException.getMessage());
      AppMethodBeat.o(7677);
    }
  }
  
  protected final void aYo()
  {
    AppMethodBeat.i(7668);
    this.vcM = ddP();
    boolean bool;
    label75:
    String str;
    label171:
    Object localObject1;
    Object localObject2;
    if ((this.vcM != null) && (this.vcM.size() > 0))
    {
      bool = true;
      this.vcN = Boolean.valueOf(bool);
      if (!this.kiI)
      {
        if (!this.vcN.booleanValue()) {
          break label318;
        }
        this.iOd = new com.tencent.mm.ui.widget.b.d(ddt(), 1, false);
      }
      this.iOd.AvY = new n.a()
      {
        public final void a(ImageView paramAnonymousImageView, MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(7642);
          if (j.d(paramAnonymousMenuItem))
          {
            paramAnonymousImageView.setVisibility(8);
            AppMethodBeat.o(7642);
            return;
          }
          paramAnonymousMenuItem = paramAnonymousMenuItem.getTitle();
          if ((j.this.vcE.get(paramAnonymousMenuItem) != null) && (!((Bitmap)j.this.vcE.get(paramAnonymousMenuItem)).isRecycled()))
          {
            paramAnonymousImageView.setImageBitmap((Bitmap)j.this.vcE.get(paramAnonymousMenuItem));
            AppMethodBeat.o(7642);
            return;
          }
          ab.w("MicroMsg.WebViewMenuHelper", "on attach icon, load from cache fail");
          try
          {
            Object localObject = j.this.ddt().igU.ahN(paramAnonymousMenuItem);
            if (!bo.isNullOrNil((String)localObject))
            {
              localObject = g.aie((String)localObject);
              if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
              {
                paramAnonymousImageView.setImageBitmap((Bitmap)localObject);
                j.this.vcE.put(paramAnonymousMenuItem, localObject);
              }
            }
            AppMethodBeat.o(7642);
            return;
          }
          catch (Exception paramAnonymousImageView)
          {
            ab.w("MicroMsg.WebViewMenuHelper", "getheadimg, ex = " + paramAnonymousImageView.getMessage());
            AppMethodBeat.o(7642);
          }
        }
      };
      this.iOd.AvZ = new j.11(this);
      this.iOd.sap = new j.12(this);
      this.iOd.AGQ = new j.13(this);
      this.iOd.sao = new n.c()
      {
        /* Error */
        public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
        {
          // Byte code:
          //   0: sipush 7653
          //   3: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
          //   6: getstatic 38	com/tencent/mm/plugin/report/service/h:qsU	Lcom/tencent/mm/plugin/report/service/h;
          //   9: ldc2_w 39
          //   12: lconst_0
          //   13: lconst_1
          //   14: iconst_0
          //   15: invokevirtual 44	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
          //   18: aload_1
          //   19: invokevirtual 49	com/tencent/mm/ui/base/l:clear	()V
          //   22: aload_0
          //   23: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   26: getfield 53	com/tencent/mm/plugin/webview/ui/tools/j:vcN	Ljava/lang/Boolean;
          //   29: invokevirtual 59	java/lang/Boolean:booleanValue	()Z
          //   32: ifeq +91 -> 123
          //   35: aload_0
          //   36: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   39: getfield 63	com/tencent/mm/plugin/webview/ui/tools/j:vcM	Ljava/util/ArrayList;
          //   42: invokevirtual 69	java/util/ArrayList:size	()I
          //   45: istore_3
          //   46: iconst_0
          //   47: istore_2
          //   48: iload_2
          //   49: iload_3
          //   50: if_icmpge +66 -> 116
          //   53: aload_0
          //   54: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   57: getfield 63	com/tencent/mm/plugin/webview/ui/tools/j:vcM	Ljava/util/ArrayList;
          //   60: iload_2
          //   61: invokevirtual 73	java/util/ArrayList:get	(I)Ljava/lang/Object;
          //   64: checkcast 75	com/tencent/mm/m/d$b
          //   67: astore 12
          //   69: aload_1
          //   70: aload 12
          //   72: getfield 79	com/tencent/mm/m/d$b:id	I
          //   75: aload 12
          //   77: getfield 83	com/tencent/mm/m/d$b:title	Ljava/lang/String;
          //   80: invokevirtual 87	com/tencent/mm/ui/base/l:e	(ILjava/lang/CharSequence;)Landroid/view/MenuItem;
          //   83: checkcast 89	com/tencent/mm/ui/base/m
          //   86: astore 13
          //   88: aload 13
          //   90: aload 12
          //   92: putfield 93	com/tencent/mm/ui/base/m:zkZ	Landroid/view/ContextMenu$ContextMenuInfo;
          //   95: aload 13
          //   97: aconst_null
          //   98: invokevirtual 97	com/tencent/mm/ui/base/m:setIcon	(Landroid/graphics/drawable/Drawable;)Landroid/view/MenuItem;
          //   101: pop
          //   102: aload 13
          //   104: iconst_0
          //   105: invokevirtual 100	com/tencent/mm/ui/base/m:setIcon	(I)Landroid/view/MenuItem;
          //   108: pop
          //   109: iload_2
          //   110: iconst_1
          //   111: iadd
          //   112: istore_2
          //   113: goto -65 -> 48
          //   116: sipush 7653
          //   119: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   122: return
          //   123: aload_0
          //   124: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   127: invokevirtual 107	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   130: invokevirtual 113	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:det	()Ljava/util/LinkedList;
          //   133: astore 13
          //   135: aload 13
          //   137: ifnull +296 -> 433
          //   140: iconst_0
          //   141: istore_2
          //   142: iload_2
          //   143: aload 13
          //   145: invokevirtual 116	java/util/LinkedList:size	()I
          //   148: if_icmpge +285 -> 433
          //   151: iload_2
          //   152: bipush 8
          //   154: if_icmpge +279 -> 433
          //   157: aload 13
          //   159: iload_2
          //   160: invokevirtual 117	java/util/LinkedList:get	(I)Ljava/lang/Object;
          //   163: checkcast 119	com/tencent/mm/m/d$a
          //   166: astore 14
          //   168: aconst_null
          //   169: astore 12
          //   171: ldc 121
          //   173: aload 14
          //   175: getfield 123	com/tencent/mm/m/d$a:id	Ljava/lang/String;
          //   178: invokestatic 129	com/tencent/mm/sdk/platformtools/bo:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
          //   181: invokevirtual 135	java/lang/String:equals	(Ljava/lang/Object;)Z
          //   184: ifeq +46 -> 230
          //   187: aload_1
          //   188: bipush 15
          //   190: aload_0
          //   191: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   194: invokevirtual 107	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   197: ldc 136
          //   199: invokevirtual 140	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
          //   202: ldc 141
          //   204: invokevirtual 145	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;I)Landroid/view/MenuItem;
          //   207: checkcast 89	com/tencent/mm/ui/base/m
          //   210: astore 12
          //   212: aload 12
          //   214: ifnull +3274 -> 3488
          //   217: aload 12
          //   219: aload 14
          //   221: getfield 148	com/tencent/mm/m/d$a:url	Ljava/lang/String;
          //   224: putfield 151	com/tencent/mm/ui/base/m:hBM	Ljava/lang/String;
          //   227: goto +3261 -> 3488
          //   230: ldc 153
          //   232: aload 14
          //   234: getfield 123	com/tencent/mm/m/d$a:id	Ljava/lang/String;
          //   237: invokestatic 129	com/tencent/mm/sdk/platformtools/bo:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
          //   240: invokevirtual 135	java/lang/String:equals	(Ljava/lang/Object;)Z
          //   243: ifeq +31 -> 274
          //   246: aload_1
          //   247: bipush 16
          //   249: aload_0
          //   250: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   253: invokevirtual 107	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   256: ldc 154
          //   258: invokevirtual 140	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
          //   261: ldc 155
          //   263: invokevirtual 145	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;I)Landroid/view/MenuItem;
          //   266: checkcast 89	com/tencent/mm/ui/base/m
          //   269: astore 12
          //   271: goto -59 -> 212
          //   274: ldc 157
          //   276: aload 14
          //   278: getfield 123	com/tencent/mm/m/d$a:id	Ljava/lang/String;
          //   281: invokestatic 129	com/tencent/mm/sdk/platformtools/bo:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
          //   284: invokevirtual 135	java/lang/String:equals	(Ljava/lang/Object;)Z
          //   287: ifeq +31 -> 318
          //   290: aload_1
          //   291: bipush 17
          //   293: aload_0
          //   294: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   297: invokevirtual 107	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   300: ldc 158
          //   302: invokevirtual 140	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
          //   305: ldc 159
          //   307: invokevirtual 145	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;I)Landroid/view/MenuItem;
          //   310: checkcast 89	com/tencent/mm/ui/base/m
          //   313: astore 12
          //   315: goto -103 -> 212
          //   318: ldc 161
          //   320: aload 14
          //   322: getfield 123	com/tencent/mm/m/d$a:id	Ljava/lang/String;
          //   325: invokestatic 129	com/tencent/mm/sdk/platformtools/bo:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
          //   328: invokevirtual 135	java/lang/String:equals	(Ljava/lang/Object;)Z
          //   331: ifeq +31 -> 362
          //   334: aload_1
          //   335: bipush 18
          //   337: aload_0
          //   338: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   341: invokevirtual 107	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   344: ldc 162
          //   346: invokevirtual 140	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
          //   349: ldc 163
          //   351: invokevirtual 145	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;I)Landroid/view/MenuItem;
          //   354: checkcast 89	com/tencent/mm/ui/base/m
          //   357: astore 12
          //   359: goto -147 -> 212
          //   362: ldc 165
          //   364: aload 14
          //   366: getfield 123	com/tencent/mm/m/d$a:id	Ljava/lang/String;
          //   369: invokestatic 129	com/tencent/mm/sdk/platformtools/bo:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
          //   372: invokevirtual 135	java/lang/String:equals	(Ljava/lang/Object;)Z
          //   375: ifeq -163 -> 212
          //   378: aload_1
          //   379: bipush 19
          //   381: aload_0
          //   382: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   385: invokevirtual 107	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   388: ldc 166
          //   390: invokevirtual 140	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
          //   393: ldc 167
          //   395: invokevirtual 145	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;I)Landroid/view/MenuItem;
          //   398: checkcast 89	com/tencent/mm/ui/base/m
          //   401: astore 12
          //   403: goto -191 -> 212
          //   406: astore 12
          //   408: ldc 169
          //   410: new 171	java/lang/StringBuilder
          //   413: dup
          //   414: ldc 173
          //   416: invokespecial 176	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   419: aload 12
          //   421: invokevirtual 180	java/lang/Exception:getMessage	()Ljava/lang/String;
          //   424: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   427: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   430: invokestatic 192	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   433: aload_0
          //   434: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   437: invokevirtual 107	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   440: getfield 196	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:igV	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   443: ifnull +19 -> 462
          //   446: aload_0
          //   447: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   450: invokevirtual 107	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   453: getfield 196	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:igV	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   456: invokevirtual 202	com/tencent/mm/plugin/webview/ui/tools/k:ddV	()Lcom/tencent/mm/protocal/JsapiPermissionWrapper;
          //   459: ifnonnull +17 -> 476
          //   462: ldc 169
          //   464: ldc 204
          //   466: invokestatic 192	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   469: sipush 7653
          //   472: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   475: return
          //   476: aload_0
          //   477: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   480: invokevirtual 107	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   483: getfield 196	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:igV	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   486: invokevirtual 202	com/tencent/mm/plugin/webview/ui/tools/k:ddV	()Lcom/tencent/mm/protocal/JsapiPermissionWrapper;
          //   489: astore 14
          //   491: aload_0
          //   492: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   495: invokevirtual 107	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   498: invokevirtual 207	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:dbc	()Z
          //   501: ifeq +66 -> 567
          //   504: aload_0
          //   505: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   508: bipush 35
          //   510: invokestatic 211	com/tencent/mm/plugin/webview/ui/tools/j:c	(Lcom/tencent/mm/plugin/webview/ui/tools/j;I)Z
          //   513: ifeq +2484 -> 2997
          //   516: aload_0
          //   517: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   520: bipush 35
          //   522: invokevirtual 215	com/tencent/mm/plugin/webview/ui/tools/j:Ku	(I)Z
          //   525: ifeq +2472 -> 2997
          //   528: aload_0
          //   529: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   532: invokevirtual 107	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   535: getfield 219	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:uRy	Lcom/tencent/mm/plugin/webview/ui/tools/bag/h;
          //   538: invokeinterface 224 1 0
          //   543: ifne +2454 -> 2997
          //   546: aload_1
          //   547: bipush 35
          //   549: aload_0
          //   550: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   553: invokevirtual 107	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   556: ldc 225
          //   558: invokevirtual 140	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
          //   561: ldc 226
          //   563: invokevirtual 145	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;I)Landroid/view/MenuItem;
          //   566: pop
          //   567: aload_0
          //   568: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   571: iconst_1
          //   572: invokestatic 211	com/tencent/mm/plugin/webview/ui/tools/j:c	(Lcom/tencent/mm/plugin/webview/ui/tools/j;I)Z
          //   575: ifeq +51 -> 626
          //   578: aload 14
          //   580: bipush 21
          //   582: invokestatic 229	com/tencent/mm/plugin/webview/ui/tools/j:a	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
          //   585: ifeq +41 -> 626
          //   588: aload_0
          //   589: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   592: iconst_1
          //   593: invokevirtual 215	com/tencent/mm/plugin/webview/ui/tools/j:Ku	(I)Z
          //   596: ifeq +30 -> 626
          //   599: aload_1
          //   600: iconst_1
          //   601: aload_0
          //   602: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   605: invokevirtual 107	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   608: ldc 230
          //   610: invokevirtual 140	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
          //   613: ldc 231
          //   615: aload 14
          //   617: bipush 21
          //   619: invokestatic 234	com/tencent/mm/plugin/webview/ui/tools/j:b	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
          //   622: invokevirtual 237	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;IZ)Landroid/view/MenuItem;
          //   625: pop
          //   626: aload_0
          //   627: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   630: iconst_2
          //   631: invokestatic 211	com/tencent/mm/plugin/webview/ui/tools/j:c	(Lcom/tencent/mm/plugin/webview/ui/tools/j;I)Z
          //   634: ifeq +51 -> 685
          //   637: aload 14
          //   639: bipush 23
          //   641: invokestatic 229	com/tencent/mm/plugin/webview/ui/tools/j:a	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
          //   644: ifeq +41 -> 685
          //   647: aload_0
          //   648: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   651: iconst_2
          //   652: invokevirtual 215	com/tencent/mm/plugin/webview/ui/tools/j:Ku	(I)Z
          //   655: ifeq +30 -> 685
          //   658: aload_1
          //   659: iconst_2
          //   660: aload_0
          //   661: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   664: invokevirtual 107	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   667: ldc 238
          //   669: invokevirtual 140	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
          //   672: ldc 239
          //   674: aload 14
          //   676: bipush 23
          //   678: invokestatic 234	com/tencent/mm/plugin/webview/ui/tools/j:b	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
          //   681: invokevirtual 237	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;IZ)Landroid/view/MenuItem;
          //   684: pop
          //   685: iconst_m1
          //   686: istore_3
          //   687: iconst_m1
          //   688: istore 5
          //   690: iload_3
          //   691: istore_2
          //   692: new 241	android/os/Bundle
          //   695: dup
          //   696: invokespecial 242	android/os/Bundle:<init>	()V
          //   699: astore 12
          //   701: iload_3
          //   702: istore_2
          //   703: aload 12
          //   705: ldc 244
          //   707: aload_0
          //   708: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   711: invokevirtual 107	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   714: invokevirtual 247	java/lang/Object:hashCode	()I
          //   717: invokevirtual 251	android/os/Bundle:putInt	(Ljava/lang/String;I)V
          //   720: iload_3
          //   721: istore_2
          //   722: aload 12
          //   724: ldc 253
          //   726: aload_0
          //   727: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   730: invokevirtual 107	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   733: getfield 257	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:pOd	Lcom/tencent/mm/ui/widget/MMWebView;
          //   736: invokevirtual 262	com/tencent/mm/ui/widget/MMWebView:getUrl	()Ljava/lang/String;
          //   739: invokevirtual 265	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
          //   742: iload_3
          //   743: istore_2
          //   744: aload_0
          //   745: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   748: invokevirtual 107	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   751: getfield 269	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:igU	Lcom/tencent/mm/plugin/webview/stub/d;
          //   754: bipush 109
          //   756: aload 12
          //   758: invokeinterface 274 3 0
          //   763: astore 12
          //   765: iload 5
          //   767: istore 4
          //   769: iload_3
          //   770: istore_2
          //   771: aload 12
          //   773: ifnull +30 -> 803
          //   776: iload_3
          //   777: istore_2
          //   778: aload 12
          //   780: ldc_w 276
          //   783: iconst_0
          //   784: invokevirtual 280	android/os/Bundle:getInt	(Ljava/lang/String;I)I
          //   787: istore_3
          //   788: iload_3
          //   789: istore_2
          //   790: aload 12
          //   792: ldc_w 282
          //   795: iconst_m1
          //   796: invokevirtual 280	android/os/Bundle:getInt	(Ljava/lang/String;I)I
          //   799: istore 4
          //   801: iload_3
          //   802: istore_2
          //   803: iload_2
          //   804: iconst_1
          //   805: if_icmpne +55 -> 860
          //   808: aload_0
          //   809: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   812: bipush 38
          //   814: invokestatic 211	com/tencent/mm/plugin/webview/ui/tools/j:c	(Lcom/tencent/mm/plugin/webview/ui/tools/j;I)Z
          //   817: ifeq +2271 -> 3088
          //   820: aload_0
          //   821: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   824: bipush 38
          //   826: invokevirtual 215	com/tencent/mm/plugin/webview/ui/tools/j:Ku	(I)Z
          //   829: ifeq +2259 -> 3088
          //   832: iload 4
          //   834: ifne +2254 -> 3088
          //   837: aload_1
          //   838: bipush 38
          //   840: aload_0
          //   841: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   844: invokevirtual 107	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   847: ldc_w 283
          //   850: invokevirtual 140	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
          //   853: ldc_w 284
          //   856: invokevirtual 145	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;I)Landroid/view/MenuItem;
          //   859: pop
          //   860: aload_0
          //   861: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   864: iconst_3
          //   865: invokestatic 211	com/tencent/mm/plugin/webview/ui/tools/j:c	(Lcom/tencent/mm/plugin/webview/ui/tools/j;I)Z
          //   868: ifeq +136 -> 1004
          //   871: aload_0
          //   872: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   875: invokevirtual 107	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   878: getfield 288	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:veD	Z
          //   881: ifeq +61 -> 942
          //   884: aload_0
          //   885: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   888: invokevirtual 107	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   891: getfield 291	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:vgp	Ljava/lang/String;
          //   894: invokestatic 295	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
          //   897: ifne +107 -> 1004
          //   900: aload_0
          //   901: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   904: invokevirtual 107	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   907: getfield 298	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:vgo	Ljava/lang/String;
          //   910: invokestatic 295	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
          //   913: ifne +91 -> 1004
          //   916: aload_0
          //   917: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   920: invokevirtual 107	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   923: getfield 291	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:vgp	Ljava/lang/String;
          //   926: aload_0
          //   927: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   930: invokevirtual 107	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   933: getfield 298	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:vgo	Ljava/lang/String;
          //   936: invokevirtual 301	java/lang/String:startsWith	(Ljava/lang/String;)Z
          //   939: ifne +65 -> 1004
          //   942: aload 14
          //   944: sipush 323
          //   947: invokestatic 229	com/tencent/mm/plugin/webview/ui/tools/j:a	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
          //   950: ifeq +54 -> 1004
          //   953: aload_0
          //   954: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   957: invokevirtual 304	com/tencent/mm/plugin/webview/ui/tools/j:ddS	()Z
          //   960: ifeq +44 -> 1004
          //   963: aload_0
          //   964: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   967: iconst_3
          //   968: invokevirtual 215	com/tencent/mm/plugin/webview/ui/tools/j:Ku	(I)Z
          //   971: ifeq +33 -> 1004
          //   974: aload_1
          //   975: iconst_3
          //   976: aload_0
          //   977: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   980: invokevirtual 107	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   983: ldc_w 305
          //   986: invokevirtual 140	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
          //   989: ldc_w 306
          //   992: aload 14
          //   994: sipush 323
          //   997: invokestatic 234	com/tencent/mm/plugin/webview/ui/tools/j:b	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
          //   1000: invokevirtual 237	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;IZ)Landroid/view/MenuItem;
          //   1003: pop
          //   1004: aload_0
          //   1005: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1008: invokevirtual 309	com/tencent/mm/plugin/webview/ui/tools/a:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1011: invokevirtual 313	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
          //   1014: ldc_w 315
          //   1017: invokevirtual 320	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
          //   1020: astore 12
          //   1022: aload_0
          //   1023: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1026: invokevirtual 309	com/tencent/mm/plugin/webview/ui/tools/a:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1029: invokevirtual 313	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
          //   1032: ldc_w 322
          //   1035: ldc2_w 323
          //   1038: invokevirtual 328	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
          //   1041: lstore 6
          //   1043: aload_0
          //   1044: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1047: bipush 23
          //   1049: invokestatic 211	com/tencent/mm/plugin/webview/ui/tools/j:c	(Lcom/tencent/mm/plugin/webview/ui/tools/j;I)Z
          //   1052: ifeq +48 -> 1100
          //   1055: aload_0
          //   1056: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1059: invokevirtual 107	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1062: getfield 269	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:igU	Lcom/tencent/mm/plugin/webview/stub/d;
          //   1065: lload 6
          //   1067: aload 12
          //   1069: invokeinterface 332 4 0
          //   1074: ifeq +26 -> 1100
          //   1077: aload_1
          //   1078: bipush 23
          //   1080: aload_0
          //   1081: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1084: invokevirtual 107	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1087: ldc_w 333
          //   1090: invokevirtual 140	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
          //   1093: ldc_w 334
          //   1096: invokevirtual 145	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;I)Landroid/view/MenuItem;
          //   1099: pop
          //   1100: aload_0
          //   1101: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1104: bipush 31
          //   1106: invokestatic 211	com/tencent/mm/plugin/webview/ui/tools/j:c	(Lcom/tencent/mm/plugin/webview/ui/tools/j;I)Z
          //   1109: ifeq +26 -> 1135
          //   1112: aload_1
          //   1113: bipush 31
          //   1115: aload_0
          //   1116: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1119: invokevirtual 107	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1122: ldc_w 335
          //   1125: invokevirtual 140	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
          //   1128: ldc_w 336
          //   1131: invokevirtual 145	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;I)Landroid/view/MenuItem;
          //   1134: pop
          //   1135: aload_0
          //   1136: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1139: bipush 6
          //   1141: invokestatic 211	com/tencent/mm/plugin/webview/ui/tools/j:c	(Lcom/tencent/mm/plugin/webview/ui/tools/j;I)Z
          //   1144: ifeq +55 -> 1199
          //   1147: aload 14
          //   1149: bipush 44
          //   1151: invokestatic 229	com/tencent/mm/plugin/webview/ui/tools/j:a	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
          //   1154: ifeq +45 -> 1199
          //   1157: aload_0
          //   1158: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1161: bipush 6
          //   1163: invokevirtual 215	com/tencent/mm/plugin/webview/ui/tools/j:Ku	(I)Z
          //   1166: ifeq +33 -> 1199
          //   1169: aload_1
          //   1170: bipush 6
          //   1172: aload_0
          //   1173: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1176: invokevirtual 107	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1179: ldc_w 337
          //   1182: invokevirtual 140	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
          //   1185: ldc_w 338
          //   1188: aload 14
          //   1190: bipush 44
          //   1192: invokestatic 234	com/tencent/mm/plugin/webview/ui/tools/j:b	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
          //   1195: invokevirtual 237	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;IZ)Landroid/view/MenuItem;
          //   1198: pop
          //   1199: aload 14
          //   1201: getfield 344	com/tencent/mm/protocal/JsapiPermissionWrapper:wif	[B
          //   1204: ifnull +186 -> 1390
          //   1207: aload_0
          //   1208: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1211: invokevirtual 107	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1214: getfield 288	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:veD	Z
          //   1217: ifeq +173 -> 1390
          //   1220: aload_0
          //   1221: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1224: invokevirtual 107	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1227: getfield 291	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:vgp	Ljava/lang/String;
          //   1230: invokestatic 295	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
          //   1233: ifne +157 -> 1390
          //   1236: aload_0
          //   1237: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1240: invokevirtual 107	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1243: getfield 298	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:vgo	Ljava/lang/String;
          //   1246: invokestatic 295	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
          //   1249: ifne +141 -> 1390
          //   1252: aload_0
          //   1253: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1256: invokevirtual 107	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1259: getfield 291	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:vgp	Ljava/lang/String;
          //   1262: aload_0
          //   1263: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1266: invokevirtual 107	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1269: getfield 298	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:vgo	Ljava/lang/String;
          //   1272: invokevirtual 301	java/lang/String:startsWith	(Ljava/lang/String;)Z
          //   1275: ifeq +115 -> 1390
          //   1278: aload_0
          //   1279: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1282: invokevirtual 309	com/tencent/mm/plugin/webview/ui/tools/a:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1285: invokevirtual 313	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
          //   1288: ldc_w 346
          //   1291: iconst_1
          //   1292: invokevirtual 350	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
          //   1295: ifeq +95 -> 1390
          //   1298: aload_0
          //   1299: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1302: invokevirtual 304	com/tencent/mm/plugin/webview/ui/tools/j:ddS	()Z
          //   1305: ifeq +85 -> 1390
          //   1308: aload_0
          //   1309: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1312: bipush 12
          //   1314: invokestatic 211	com/tencent/mm/plugin/webview/ui/tools/j:c	(Lcom/tencent/mm/plugin/webview/ui/tools/j;I)Z
          //   1317: ifeq +38 -> 1355
          //   1320: aload_0
          //   1321: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1324: bipush 12
          //   1326: invokevirtual 215	com/tencent/mm/plugin/webview/ui/tools/j:Ku	(I)Z
          //   1329: ifeq +26 -> 1355
          //   1332: aload_1
          //   1333: bipush 12
          //   1335: aload_0
          //   1336: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1339: invokevirtual 107	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1342: ldc_w 351
          //   1345: invokevirtual 140	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
          //   1348: ldc_w 352
          //   1351: invokevirtual 145	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;I)Landroid/view/MenuItem;
          //   1354: pop
          //   1355: aload_0
          //   1356: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1359: bipush 9
          //   1361: invokestatic 211	com/tencent/mm/plugin/webview/ui/tools/j:c	(Lcom/tencent/mm/plugin/webview/ui/tools/j;I)Z
          //   1364: ifeq +26 -> 1390
          //   1367: aload_1
          //   1368: bipush 9
          //   1370: aload_0
          //   1371: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1374: invokevirtual 107	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1377: ldc_w 353
          //   1380: invokevirtual 140	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
          //   1383: ldc_w 354
          //   1386: invokevirtual 145	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;I)Landroid/view/MenuItem;
          //   1389: pop
          //   1390: aload_0
          //   1391: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1394: invokevirtual 309	com/tencent/mm/plugin/webview/ui/tools/a:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1397: invokevirtual 313	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
          //   1400: ldc_w 356
          //   1403: invokevirtual 320	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
          //   1406: astore 12
          //   1408: aload 12
          //   1410: invokestatic 295	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
          //   1413: ifne +44 -> 1457
          //   1416: aload_0
          //   1417: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1420: invokevirtual 107	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1423: getfield 269	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:igU	Lcom/tencent/mm/plugin/webview/stub/d;
          //   1426: aload 12
          //   1428: invokeinterface 359 2 0
          //   1433: istore 8
          //   1435: iload 8
          //   1437: ifne +1779 -> 3216
          //   1440: aload_0
          //   1441: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1444: invokevirtual 107	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1447: getfield 269	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:igU	Lcom/tencent/mm/plugin/webview/stub/d;
          //   1450: aload 12
          //   1452: invokeinterface 362 2 0
          //   1457: aload_0
          //   1458: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1461: bipush 34
          //   1463: invokestatic 211	com/tencent/mm/plugin/webview/ui/tools/j:c	(Lcom/tencent/mm/plugin/webview/ui/tools/j;I)Z
          //   1466: ifeq +57 -> 1523
          //   1469: aload 14
          //   1471: sipush 313
          //   1474: invokestatic 229	com/tencent/mm/plugin/webview/ui/tools/j:a	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
          //   1477: ifeq +46 -> 1523
          //   1480: aload_0
          //   1481: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1484: bipush 34
          //   1486: invokevirtual 215	com/tencent/mm/plugin/webview/ui/tools/j:Ku	(I)Z
          //   1489: ifeq +34 -> 1523
          //   1492: aload_1
          //   1493: bipush 34
          //   1495: aload_0
          //   1496: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1499: invokevirtual 107	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1502: ldc_w 363
          //   1505: invokevirtual 140	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
          //   1508: ldc_w 364
          //   1511: aload 14
          //   1513: sipush 313
          //   1516: invokestatic 234	com/tencent/mm/plugin/webview/ui/tools/j:b	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
          //   1519: invokevirtual 237	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;IZ)Landroid/view/MenuItem;
          //   1522: pop
          //   1523: aload_0
          //   1524: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1527: bipush 7
          //   1529: invokestatic 211	com/tencent/mm/plugin/webview/ui/tools/j:c	(Lcom/tencent/mm/plugin/webview/ui/tools/j;I)Z
          //   1532: ifeq +55 -> 1587
          //   1535: aload 14
          //   1537: bipush 45
          //   1539: invokestatic 229	com/tencent/mm/plugin/webview/ui/tools/j:a	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
          //   1542: ifeq +45 -> 1587
          //   1545: aload_0
          //   1546: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1549: bipush 7
          //   1551: invokevirtual 215	com/tencent/mm/plugin/webview/ui/tools/j:Ku	(I)Z
          //   1554: ifeq +33 -> 1587
          //   1557: aload_1
          //   1558: bipush 7
          //   1560: aload_0
          //   1561: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1564: invokevirtual 107	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1567: ldc_w 365
          //   1570: invokevirtual 140	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
          //   1573: ldc_w 366
          //   1576: aload 14
          //   1578: bipush 45
          //   1580: invokestatic 234	com/tencent/mm/plugin/webview/ui/tools/j:b	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
          //   1583: invokevirtual 237	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;IZ)Landroid/view/MenuItem;
          //   1586: pop
          //   1587: aload_0
          //   1588: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1591: bipush 37
          //   1593: invokestatic 211	com/tencent/mm/plugin/webview/ui/tools/j:c	(Lcom/tencent/mm/plugin/webview/ui/tools/j;I)Z
          //   1596: ifeq +62 -> 1658
          //   1599: aload_0
          //   1600: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1603: invokevirtual 107	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1606: pop
          //   1607: aload_0
          //   1608: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1611: invokevirtual 107	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1614: getfield 257	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:pOd	Lcom/tencent/mm/ui/widget/MMWebView;
          //   1617: invokestatic 371	com/tencent/mm/plugin/webview/b:b	(Lcom/tencent/xweb/WebView;)Z
          //   1620: ifeq +38 -> 1658
          //   1623: aload_0
          //   1624: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1627: bipush 37
          //   1629: invokevirtual 215	com/tencent/mm/plugin/webview/ui/tools/j:Ku	(I)Z
          //   1632: ifeq +26 -> 1658
          //   1635: aload_1
          //   1636: bipush 37
          //   1638: aload_0
          //   1639: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1642: invokevirtual 107	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1645: ldc_w 372
          //   1648: invokevirtual 140	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
          //   1651: ldc_w 373
          //   1654: invokevirtual 145	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;I)Landroid/view/MenuItem;
          //   1657: pop
          //   1658: aload_0
          //   1659: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1662: bipush 24
          //   1664: invokestatic 211	com/tencent/mm/plugin/webview/ui/tools/j:c	(Lcom/tencent/mm/plugin/webview/ui/tools/j;I)Z
          //   1667: ifeq +132 -> 1799
          //   1670: aload 14
          //   1672: bipush 43
          //   1674: invokestatic 229	com/tencent/mm/plugin/webview/ui/tools/j:a	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
          //   1677: ifeq +122 -> 1799
          //   1680: aload_0
          //   1681: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1684: bipush 24
          //   1686: invokevirtual 215	com/tencent/mm/plugin/webview/ui/tools/j:Ku	(I)Z
          //   1689: ifeq +110 -> 1799
          //   1692: aload_0
          //   1693: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1696: invokevirtual 107	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1699: ldc_w 375
          //   1702: invokestatic 381	com/tencent/mm/pluginsdk/model/app/p:u	(Landroid/content/Context;Ljava/lang/String;)Z
          //   1705: ifne +94 -> 1799
          //   1708: new 241	android/os/Bundle
          //   1711: dup
          //   1712: invokespecial 242	android/os/Bundle:<init>	()V
          //   1715: astore 12
          //   1717: aload 12
          //   1719: ldc_w 383
          //   1722: ldc_w 385
          //   1725: invokevirtual 265	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
          //   1728: aload_0
          //   1729: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1732: invokevirtual 107	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1735: getfield 269	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:igU	Lcom/tencent/mm/plugin/webview/stub/d;
          //   1738: bipush 71
          //   1740: aload 12
          //   1742: invokeinterface 274 3 0
          //   1747: astore 12
          //   1749: aload 12
          //   1751: ifnull +1684 -> 3435
          //   1754: aload 12
          //   1756: ldc_w 385
          //   1759: invokevirtual 388	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
          //   1762: istore 8
          //   1764: iload 8
          //   1766: ifeq +33 -> 1799
          //   1769: aload_1
          //   1770: bipush 24
          //   1772: aload_0
          //   1773: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1776: invokevirtual 107	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1779: ldc_w 389
          //   1782: invokevirtual 140	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
          //   1785: ldc_w 390
          //   1788: aload 14
          //   1790: bipush 43
          //   1792: invokestatic 234	com/tencent/mm/plugin/webview/ui/tools/j:b	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
          //   1795: invokevirtual 237	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;IZ)Landroid/view/MenuItem;
          //   1798: pop
          //   1799: aload_0
          //   1800: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1803: bipush 11
          //   1805: invokestatic 211	com/tencent/mm/plugin/webview/ui/tools/j:c	(Lcom/tencent/mm/plugin/webview/ui/tools/j;I)Z
          //   1808: ifeq +55 -> 1863
          //   1811: aload 14
          //   1813: bipush 18
          //   1815: invokestatic 229	com/tencent/mm/plugin/webview/ui/tools/j:a	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
          //   1818: ifeq +45 -> 1863
          //   1821: aload_0
          //   1822: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1825: bipush 11
          //   1827: invokevirtual 215	com/tencent/mm/plugin/webview/ui/tools/j:Ku	(I)Z
          //   1830: ifeq +33 -> 1863
          //   1833: aload_1
          //   1834: bipush 11
          //   1836: aload_0
          //   1837: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1840: invokevirtual 107	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1843: ldc_w 391
          //   1846: invokevirtual 140	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
          //   1849: ldc_w 392
          //   1852: aload 14
          //   1854: bipush 18
          //   1856: invokestatic 234	com/tencent/mm/plugin/webview/ui/tools/j:b	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
          //   1859: invokevirtual 237	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;IZ)Landroid/view/MenuItem;
          //   1862: pop
          //   1863: aload_0
          //   1864: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1867: bipush 28
          //   1869: invokestatic 211	com/tencent/mm/plugin/webview/ui/tools/j:c	(Lcom/tencent/mm/plugin/webview/ui/tools/j;I)Z
          //   1872: ifeq +38 -> 1910
          //   1875: aload_0
          //   1876: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1879: bipush 28
          //   1881: invokevirtual 215	com/tencent/mm/plugin/webview/ui/tools/j:Ku	(I)Z
          //   1884: ifeq +26 -> 1910
          //   1887: aload_1
          //   1888: bipush 28
          //   1890: aload_0
          //   1891: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1894: invokevirtual 107	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1897: ldc_w 393
          //   1900: invokevirtual 140	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
          //   1903: ldc_w 394
          //   1906: invokevirtual 145	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;I)Landroid/view/MenuItem;
          //   1909: pop
          //   1910: aload_0
          //   1911: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1914: bipush 14
          //   1916: invokestatic 211	com/tencent/mm/plugin/webview/ui/tools/j:c	(Lcom/tencent/mm/plugin/webview/ui/tools/j;I)Z
          //   1919: ifeq +68 -> 1987
          //   1922: aload 14
          //   1924: bipush 73
          //   1926: invokestatic 229	com/tencent/mm/plugin/webview/ui/tools/j:a	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
          //   1929: ifeq +58 -> 1987
          //   1932: aload_0
          //   1933: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1936: bipush 14
          //   1938: invokevirtual 215	com/tencent/mm/plugin/webview/ui/tools/j:Ku	(I)Z
          //   1941: ifeq +46 -> 1987
          //   1944: aload_0
          //   1945: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1948: invokevirtual 107	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1951: getfield 397	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:vfj	Z
          //   1954: ifne +33 -> 1987
          //   1957: aload_1
          //   1958: bipush 14
          //   1960: aload_0
          //   1961: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1964: invokevirtual 107	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1967: ldc_w 398
          //   1970: invokevirtual 140	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
          //   1973: ldc_w 399
          //   1976: aload 14
          //   1978: bipush 73
          //   1980: invokestatic 234	com/tencent/mm/plugin/webview/ui/tools/j:b	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
          //   1983: invokevirtual 237	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;IZ)Landroid/view/MenuItem;
          //   1986: pop
          //   1987: aload_0
          //   1988: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1991: bipush 14
          //   1993: invokestatic 211	com/tencent/mm/plugin/webview/ui/tools/j:c	(Lcom/tencent/mm/plugin/webview/ui/tools/j;I)Z
          //   1996: ifeq +51 -> 2047
          //   1999: aload_0
          //   2000: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   2003: invokevirtual 107	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2006: getfield 397	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:vfj	Z
          //   2009: ifeq +38 -> 2047
          //   2012: aload_0
          //   2013: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   2016: bipush 14
          //   2018: invokevirtual 215	com/tencent/mm/plugin/webview/ui/tools/j:Ku	(I)Z
          //   2021: ifeq +26 -> 2047
          //   2024: aload_1
          //   2025: bipush 14
          //   2027: aload_0
          //   2028: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   2031: invokevirtual 107	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2034: ldc_w 400
          //   2037: invokevirtual 140	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
          //   2040: ldc_w 334
          //   2043: invokevirtual 145	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;I)Landroid/view/MenuItem;
          //   2046: pop
          //   2047: aload_0
          //   2048: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   2051: bipush 10
          //   2053: invokestatic 211	com/tencent/mm/plugin/webview/ui/tools/j:c	(Lcom/tencent/mm/plugin/webview/ui/tools/j;I)Z
          //   2056: ifeq +55 -> 2111
          //   2059: aload 14
          //   2061: bipush 47
          //   2063: invokestatic 229	com/tencent/mm/plugin/webview/ui/tools/j:a	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
          //   2066: ifeq +45 -> 2111
          //   2069: aload_0
          //   2070: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   2073: bipush 10
          //   2075: invokevirtual 215	com/tencent/mm/plugin/webview/ui/tools/j:Ku	(I)Z
          //   2078: ifeq +33 -> 2111
          //   2081: aload_1
          //   2082: bipush 10
          //   2084: aload_0
          //   2085: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   2088: invokevirtual 107	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2091: ldc_w 401
          //   2094: invokevirtual 140	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
          //   2097: ldc_w 402
          //   2100: aload 14
          //   2102: bipush 47
          //   2104: invokestatic 234	com/tencent/mm/plugin/webview/ui/tools/j:b	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
          //   2107: invokevirtual 237	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;IZ)Landroid/view/MenuItem;
          //   2110: pop
          //   2111: aload_0
          //   2112: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   2115: bipush 8
          //   2117: invokestatic 211	com/tencent/mm/plugin/webview/ui/tools/j:c	(Lcom/tencent/mm/plugin/webview/ui/tools/j;I)Z
          //   2120: ifeq +87 -> 2207
          //   2123: aload 14
          //   2125: bipush 36
          //   2127: invokestatic 229	com/tencent/mm/plugin/webview/ui/tools/j:a	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
          //   2130: ifeq +77 -> 2207
          //   2133: aload_0
          //   2134: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   2137: bipush 8
          //   2139: invokevirtual 215	com/tencent/mm/plugin/webview/ui/tools/j:Ku	(I)Z
          //   2142: ifeq +65 -> 2207
          //   2145: aconst_null
          //   2146: astore 12
          //   2148: aload_0
          //   2149: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   2152: invokevirtual 107	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2155: getfield 269	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:igU	Lcom/tencent/mm/plugin/webview/stub/d;
          //   2158: invokeinterface 405 1 0
          //   2163: astore 13
          //   2165: aload 13
          //   2167: astore 12
          //   2169: aload 12
          //   2171: invokestatic 295	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
          //   2174: ifne +1267 -> 3441
          //   2177: aload_1
          //   2178: bipush 8
          //   2180: aload_0
          //   2181: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   2184: invokevirtual 107	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2187: ldc_w 406
          //   2190: invokevirtual 140	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
          //   2193: ldc_w 407
          //   2196: aload 14
          //   2198: bipush 36
          //   2200: invokestatic 234	com/tencent/mm/plugin/webview/ui/tools/j:b	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
          //   2203: invokevirtual 237	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;IZ)Landroid/view/MenuItem;
          //   2206: pop
          //   2207: aload_0
          //   2208: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   2211: bipush 33
          //   2213: invokestatic 211	com/tencent/mm/plugin/webview/ui/tools/j:c	(Lcom/tencent/mm/plugin/webview/ui/tools/j;I)Z
          //   2216: ifeq +83 -> 2299
          //   2219: aload 14
          //   2221: bipush 31
          //   2223: invokestatic 229	com/tencent/mm/plugin/webview/ui/tools/j:a	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
          //   2226: ifeq +73 -> 2299
          //   2229: aload_0
          //   2230: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   2233: bipush 30
          //   2235: invokevirtual 215	com/tencent/mm/plugin/webview/ui/tools/j:Ku	(I)Z
          //   2238: ifeq +61 -> 2299
          //   2241: aload_0
          //   2242: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   2245: invokevirtual 107	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2248: getfield 269	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:igU	Lcom/tencent/mm/plugin/webview/stub/d;
          //   2251: bipush 78
          //   2253: aconst_null
          //   2254: invokeinterface 274 3 0
          //   2259: ldc_w 409
          //   2262: iconst_0
          //   2263: invokevirtual 411	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
          //   2266: ifeq +33 -> 2299
          //   2269: aload_1
          //   2270: bipush 33
          //   2272: aload_0
          //   2273: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   2276: invokevirtual 107	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2279: ldc_w 412
          //   2282: invokevirtual 140	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
          //   2285: ldc_w 413
          //   2288: aload 14
          //   2290: bipush 31
          //   2292: invokestatic 234	com/tencent/mm/plugin/webview/ui/tools/j:b	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
          //   2295: invokevirtual 237	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;IZ)Landroid/view/MenuItem;
          //   2298: pop
          //   2299: aload_0
          //   2300: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   2303: bipush 25
          //   2305: invokestatic 211	com/tencent/mm/plugin/webview/ui/tools/j:c	(Lcom/tencent/mm/plugin/webview/ui/tools/j;I)Z
          //   2308: ifeq +85 -> 2393
          //   2311: aload 14
          //   2313: sipush 322
          //   2316: invokestatic 229	com/tencent/mm/plugin/webview/ui/tools/j:a	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
          //   2319: ifeq +74 -> 2393
          //   2322: aload_0
          //   2323: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   2326: invokevirtual 107	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2329: invokestatic 419	com/tencent/wework/api/WWAPIFactory:jO	(Landroid/content/Context;)Lcom/tencent/wework/api/IWWAPI;
          //   2332: invokeinterface 424 1 0
          //   2337: ifeq +56 -> 2393
          //   2340: aload_0
          //   2341: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   2344: bipush 25
          //   2346: invokevirtual 215	com/tencent/mm/plugin/webview/ui/tools/j:Ku	(I)Z
          //   2349: ifeq +44 -> 2393
          //   2352: aload_1
          //   2353: bipush 25
          //   2355: aload_0
          //   2356: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   2359: invokevirtual 107	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2362: ldc_w 425
          //   2365: iconst_1
          //   2366: anewarray 4	java/lang/Object
          //   2369: dup
          //   2370: iconst_0
          //   2371: ldc_w 427
          //   2374: aastore
          //   2375: invokevirtual 430	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
          //   2378: ldc_w 431
          //   2381: aload 14
          //   2383: sipush 322
          //   2386: invokestatic 234	com/tencent/mm/plugin/webview/ui/tools/j:b	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
          //   2389: invokevirtual 237	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;IZ)Landroid/view/MenuItem;
          //   2392: pop
          //   2393: aload_0
          //   2394: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   2397: bipush 26
          //   2399: invokestatic 211	com/tencent/mm/plugin/webview/ui/tools/j:c	(Lcom/tencent/mm/plugin/webview/ui/tools/j;I)Z
          //   2402: ifeq +83 -> 2485
          //   2405: aload 14
          //   2407: sipush 278
          //   2410: invokestatic 229	com/tencent/mm/plugin/webview/ui/tools/j:a	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
          //   2413: ifeq +72 -> 2485
          //   2416: aload_0
          //   2417: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   2420: invokevirtual 107	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2423: aload_0
          //   2424: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   2427: invokevirtual 107	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2430: getfield 257	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:pOd	Lcom/tencent/mm/ui/widget/MMWebView;
          //   2433: invokevirtual 262	com/tencent/mm/ui/widget/MMWebView:getUrl	()Ljava/lang/String;
          //   2436: invokestatic 436	com/tencent/mm/plugin/webview/stub/a:bj	(Landroid/content/Context;Ljava/lang/String;)Z
          //   2439: ifeq +46 -> 2485
          //   2442: aload_0
          //   2443: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   2446: bipush 26
          //   2448: invokevirtual 215	com/tencent/mm/plugin/webview/ui/tools/j:Ku	(I)Z
          //   2451: ifeq +34 -> 2485
          //   2454: aload_1
          //   2455: bipush 26
          //   2457: aload_0
          //   2458: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   2461: invokevirtual 107	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2464: ldc_w 437
          //   2467: invokevirtual 140	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
          //   2470: ldc_w 438
          //   2473: aload 14
          //   2475: sipush 278
          //   2478: invokestatic 234	com/tencent/mm/plugin/webview/ui/tools/j:b	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
          //   2481: invokevirtual 237	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;IZ)Landroid/view/MenuItem;
          //   2484: pop
          //   2485: aload_0
          //   2486: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   2489: bipush 20
          //   2491: invokestatic 211	com/tencent/mm/plugin/webview/ui/tools/j:c	(Lcom/tencent/mm/plugin/webview/ui/tools/j;I)Z
          //   2494: ifeq +68 -> 2562
          //   2497: aload 14
          //   2499: bipush 91
          //   2501: invokestatic 229	com/tencent/mm/plugin/webview/ui/tools/j:a	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
          //   2504: ifeq +58 -> 2562
          //   2507: aload_0
          //   2508: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   2511: invokevirtual 107	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2514: invokestatic 442	com/tencent/mm/plugin/webview/stub/a:fw	(Landroid/content/Context;)Z
          //   2517: ifeq +45 -> 2562
          //   2520: aload_0
          //   2521: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   2524: bipush 20
          //   2526: invokevirtual 215	com/tencent/mm/plugin/webview/ui/tools/j:Ku	(I)Z
          //   2529: ifeq +33 -> 2562
          //   2532: aload_1
          //   2533: bipush 20
          //   2535: aload_0
          //   2536: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   2539: invokevirtual 107	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2542: ldc_w 443
          //   2545: invokevirtual 140	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
          //   2548: ldc_w 444
          //   2551: aload 14
          //   2553: bipush 91
          //   2555: invokestatic 234	com/tencent/mm/plugin/webview/ui/tools/j:b	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
          //   2558: invokevirtual 237	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;IZ)Landroid/view/MenuItem;
          //   2561: pop
          //   2562: aload_0
          //   2563: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   2566: bipush 22
          //   2568: invokestatic 211	com/tencent/mm/plugin/webview/ui/tools/j:c	(Lcom/tencent/mm/plugin/webview/ui/tools/j;I)Z
          //   2571: ifeq +70 -> 2641
          //   2574: aload 14
          //   2576: sipush 133
          //   2579: invokestatic 229	com/tencent/mm/plugin/webview/ui/tools/j:a	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
          //   2582: ifeq +59 -> 2641
          //   2585: aload_0
          //   2586: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   2589: invokevirtual 107	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2592: invokestatic 442	com/tencent/mm/plugin/webview/stub/a:fw	(Landroid/content/Context;)Z
          //   2595: ifeq +46 -> 2641
          //   2598: aload_0
          //   2599: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   2602: bipush 22
          //   2604: invokevirtual 215	com/tencent/mm/plugin/webview/ui/tools/j:Ku	(I)Z
          //   2607: ifeq +34 -> 2641
          //   2610: aload_1
          //   2611: bipush 22
          //   2613: aload_0
          //   2614: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   2617: invokevirtual 107	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2620: ldc_w 445
          //   2623: invokevirtual 140	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
          //   2626: ldc_w 446
          //   2629: aload 14
          //   2631: sipush 133
          //   2634: invokestatic 234	com/tencent/mm/plugin/webview/ui/tools/j:b	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
          //   2637: invokevirtual 237	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;IZ)Landroid/view/MenuItem;
          //   2640: pop
          //   2641: aload_0
          //   2642: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   2645: iconst_0
          //   2646: invokestatic 211	com/tencent/mm/plugin/webview/ui/tools/j:c	(Lcom/tencent/mm/plugin/webview/ui/tools/j;I)Z
          //   2649: ifeq +124 -> 2773
          //   2652: aload 14
          //   2654: bipush 43
          //   2656: invokestatic 229	com/tencent/mm/plugin/webview/ui/tools/j:a	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
          //   2659: ifeq +114 -> 2773
          //   2662: aload_0
          //   2663: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   2666: iconst_0
          //   2667: invokevirtual 215	com/tencent/mm/plugin/webview/ui/tools/j:Ku	(I)Z
          //   2670: ifeq +103 -> 2773
          //   2673: aload_0
          //   2674: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   2677: invokevirtual 107	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2680: getfield 269	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:igU	Lcom/tencent/mm/plugin/webview/stub/d;
          //   2683: invokeinterface 449 1 0
          //   2688: ifeq +85 -> 2773
          //   2691: aload_0
          //   2692: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   2695: invokevirtual 107	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2698: getfield 269	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:igU	Lcom/tencent/mm/plugin/webview/stub/d;
          //   2701: invokeinterface 453 1 0
          //   2706: astore 12
          //   2708: aload 12
          //   2710: invokeinterface 459 1 0
          //   2715: astore 13
          //   2717: aload 13
          //   2719: invokeinterface 464 1 0
          //   2724: ifeq +747 -> 3471
          //   2727: aload_1
          //   2728: aload 13
          //   2730: invokeinterface 468 1 0
          //   2735: checkcast 131	java/lang/String
          //   2738: invokevirtual 472	com/tencent/mm/ui/base/l:add	(Ljava/lang/CharSequence;)Landroid/view/MenuItem;
          //   2741: pop
          //   2742: goto -25 -> 2717
          //   2745: astore 12
          //   2747: ldc 169
          //   2749: new 171	java/lang/StringBuilder
          //   2752: dup
          //   2753: ldc_w 474
          //   2756: invokespecial 176	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   2759: aload 12
          //   2761: invokevirtual 180	java/lang/Exception:getMessage	()Ljava/lang/String;
          //   2764: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   2767: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   2770: invokestatic 477	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
          //   2773: aload_0
          //   2774: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   2777: bipush 27
          //   2779: invokestatic 211	com/tencent/mm/plugin/webview/ui/tools/j:c	(Lcom/tencent/mm/plugin/webview/ui/tools/j;I)Z
          //   2782: ifeq +55 -> 2837
          //   2785: aload_0
          //   2786: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   2789: invokevirtual 107	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2792: getfield 481	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:vem	Lcom/tencent/mm/plugin/webview/ui/tools/widget/MovingImageButton;
          //   2795: ifnull +42 -> 2837
          //   2798: aload_0
          //   2799: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   2802: invokevirtual 107	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2805: getfield 481	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:vem	Lcom/tencent/mm/plugin/webview/ui/tools/widget/MovingImageButton;
          //   2808: invokevirtual 486	com/tencent/mm/plugin/webview/ui/tools/widget/MovingImageButton:getVisibility	()I
          //   2811: ifne +26 -> 2837
          //   2814: aload_1
          //   2815: bipush 27
          //   2817: aload_0
          //   2818: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   2821: invokevirtual 107	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2824: ldc_w 487
          //   2827: invokevirtual 140	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
          //   2830: ldc_w 488
          //   2833: invokevirtual 145	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;I)Landroid/view/MenuItem;
          //   2836: pop
          //   2837: aload_0
          //   2838: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   2841: invokevirtual 107	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2844: aload_0
          //   2845: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   2848: invokevirtual 107	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2851: getfield 291	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:vgp	Ljava/lang/String;
          //   2854: invokevirtual 491	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:aiu	(Ljava/lang/String;)Ljava/lang/String;
          //   2857: astore 12
          //   2859: aload_0
          //   2860: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   2863: invokevirtual 309	com/tencent/mm/plugin/webview/ui/tools/a:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2866: invokevirtual 313	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
          //   2869: ldc_w 493
          //   2872: invokevirtual 320	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
          //   2875: astore 13
          //   2877: aload_0
          //   2878: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   2881: invokevirtual 107	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2884: getfield 496	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:veI	Z
          //   2887: ifne +85 -> 2972
          //   2890: aload 12
          //   2892: invokestatic 295	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
          //   2895: ifne +77 -> 2972
          //   2898: aload 13
          //   2900: invokestatic 295	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
          //   2903: ifne +69 -> 2972
          //   2906: aload 14
          //   2908: sipush 255
          //   2911: invokestatic 229	com/tencent/mm/plugin/webview/ui/tools/j:a	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
          //   2914: ifeq +58 -> 2972
          //   2917: aload_0
          //   2918: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   2921: bipush 29
          //   2923: invokevirtual 215	com/tencent/mm/plugin/webview/ui/tools/j:Ku	(I)Z
          //   2926: ifeq +46 -> 2972
          //   2929: aload_0
          //   2930: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   2933: bipush 29
          //   2935: invokestatic 211	com/tencent/mm/plugin/webview/ui/tools/j:c	(Lcom/tencent/mm/plugin/webview/ui/tools/j;I)Z
          //   2938: ifeq +34 -> 2972
          //   2941: aload_1
          //   2942: bipush 29
          //   2944: aload_0
          //   2945: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   2948: invokevirtual 107	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2951: ldc_w 497
          //   2954: invokevirtual 140	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
          //   2957: ldc_w 498
          //   2960: aload 14
          //   2962: sipush 255
          //   2965: invokestatic 234	com/tencent/mm/plugin/webview/ui/tools/j:b	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
          //   2968: invokevirtual 237	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;IZ)Landroid/view/MenuItem;
          //   2971: pop
          //   2972: aload_0
          //   2973: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   2976: iconst_1
          //   2977: putfield 501	com/tencent/mm/plugin/webview/ui/tools/j:kiI	Z
          //   2980: aload_0
          //   2981: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   2984: getfield 505	com/tencent/mm/plugin/webview/ui/tools/j:iOd	Lcom/tencent/mm/ui/widget/b/d;
          //   2987: invokevirtual 510	com/tencent/mm/ui/widget/b/d:dPa	()V
          //   2990: sipush 7653
          //   2993: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   2996: return
          //   2997: aload_0
          //   2998: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   3001: bipush 36
          //   3003: invokevirtual 215	com/tencent/mm/plugin/webview/ui/tools/j:Ku	(I)Z
          //   3006: ifeq -2439 -> 567
          //   3009: aload_0
          //   3010: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   3013: invokevirtual 107	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3016: getfield 219	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:uRy	Lcom/tencent/mm/plugin/webview/ui/tools/bag/h;
          //   3019: invokeinterface 224 1 0
          //   3024: ifeq -2457 -> 567
          //   3027: aload_1
          //   3028: bipush 36
          //   3030: aload_0
          //   3031: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   3034: invokevirtual 107	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3037: ldc_w 511
          //   3040: invokevirtual 140	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
          //   3043: ldc_w 512
          //   3046: invokevirtual 145	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;I)Landroid/view/MenuItem;
          //   3049: pop
          //   3050: goto -2483 -> 567
          //   3053: astore 12
          //   3055: ldc 169
          //   3057: new 171	java/lang/StringBuilder
          //   3060: dup
          //   3061: ldc_w 514
          //   3064: invokespecial 176	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   3067: aload 12
          //   3069: invokevirtual 515	android/os/RemoteException:getMessage	()Ljava/lang/String;
          //   3072: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   3075: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   3078: invokestatic 192	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   3081: iload 5
          //   3083: istore 4
          //   3085: goto -2282 -> 803
          //   3088: aload_0
          //   3089: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   3092: bipush 39
          //   3094: invokevirtual 215	com/tencent/mm/plugin/webview/ui/tools/j:Ku	(I)Z
          //   3097: ifeq -2237 -> 860
          //   3100: iload 4
          //   3102: iconst_1
          //   3103: if_icmpne -2243 -> 860
          //   3106: aload_1
          //   3107: bipush 39
          //   3109: aload_0
          //   3110: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   3113: invokevirtual 107	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3116: ldc_w 516
          //   3119: invokevirtual 140	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
          //   3122: ldc_w 517
          //   3125: invokevirtual 145	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;I)Landroid/view/MenuItem;
          //   3128: pop
          //   3129: goto -2269 -> 860
          //   3132: astore 12
          //   3134: ldc 169
          //   3136: aload 12
          //   3138: ldc_w 519
          //   3141: iconst_0
          //   3142: anewarray 4	java/lang/Object
          //   3145: invokestatic 523	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
          //   3148: goto -2048 -> 1100
          //   3151: astore 13
          //   3153: ldc 169
          //   3155: new 171	java/lang/StringBuilder
          //   3158: dup
          //   3159: ldc_w 525
          //   3162: invokespecial 176	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   3165: aload 13
          //   3167: invokevirtual 180	java/lang/Exception:getMessage	()Ljava/lang/String;
          //   3170: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   3173: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   3176: invokestatic 192	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   3179: iconst_0
          //   3180: istore 8
          //   3182: goto -1747 -> 1435
          //   3185: astore 12
          //   3187: ldc 169
          //   3189: new 171	java/lang/StringBuilder
          //   3192: dup
          //   3193: ldc_w 527
          //   3196: invokespecial 176	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   3199: aload 12
          //   3201: invokevirtual 180	java/lang/Exception:getMessage	()Ljava/lang/String;
          //   3204: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   3207: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   3210: invokestatic 192	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   3213: goto -1756 -> 1457
          //   3216: aload_0
          //   3217: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   3220: invokevirtual 107	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3223: getfield 269	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:igU	Lcom/tencent/mm/plugin/webview/stub/d;
          //   3226: aload 12
          //   3228: invokeinterface 530 2 0
          //   3233: istore 8
          //   3235: iload 8
          //   3237: ifeq +142 -> 3379
          //   3240: aload 14
          //   3242: bipush 19
          //   3244: invokestatic 229	com/tencent/mm/plugin/webview/ui/tools/j:a	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
          //   3247: istore 10
          //   3249: aload 14
          //   3251: bipush 19
          //   3253: invokestatic 234	com/tencent/mm/plugin/webview/ui/tools/j:b	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
          //   3256: istore 9
          //   3258: aload_0
          //   3259: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   3262: invokevirtual 107	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3265: invokevirtual 533	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:deu	()Z
          //   3268: istore 11
          //   3270: aload_0
          //   3271: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   3274: iconst_5
          //   3275: invokestatic 211	com/tencent/mm/plugin/webview/ui/tools/j:c	(Lcom/tencent/mm/plugin/webview/ui/tools/j;I)Z
          //   3278: ifeq -1821 -> 1457
          //   3281: iload 10
          //   3283: ifeq +14 -> 3297
          //   3286: aload_0
          //   3287: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   3290: iconst_5
          //   3291: invokevirtual 215	com/tencent/mm/plugin/webview/ui/tools/j:Ku	(I)Z
          //   3294: ifne +8 -> 3302
          //   3297: iload 11
          //   3299: ifeq -1842 -> 1457
          //   3302: iload 8
          //   3304: ifeq +96 -> 3400
          //   3307: ldc_w 534
          //   3310: istore_2
          //   3311: iload 11
          //   3313: ifeq +7 -> 3320
          //   3316: ldc_w 535
          //   3319: istore_2
          //   3320: aload_1
          //   3321: iconst_5
          //   3322: aload_0
          //   3323: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   3326: invokevirtual 107	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3329: iload_2
          //   3330: invokevirtual 140	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
          //   3333: ldc_w 536
          //   3336: iload 9
          //   3338: invokevirtual 237	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;IZ)Landroid/view/MenuItem;
          //   3341: pop
          //   3342: goto -1885 -> 1457
          //   3345: astore 12
          //   3347: ldc 169
          //   3349: new 171	java/lang/StringBuilder
          //   3352: dup
          //   3353: ldc_w 538
          //   3356: invokespecial 176	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   3359: aload 12
          //   3361: invokevirtual 180	java/lang/Exception:getMessage	()Ljava/lang/String;
          //   3364: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   3367: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   3370: invokestatic 192	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   3373: iconst_0
          //   3374: istore 8
          //   3376: goto -141 -> 3235
          //   3379: aload 14
          //   3381: bipush 20
          //   3383: invokestatic 229	com/tencent/mm/plugin/webview/ui/tools/j:a	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
          //   3386: istore 10
          //   3388: aload 14
          //   3390: bipush 20
          //   3392: invokestatic 234	com/tencent/mm/plugin/webview/ui/tools/j:b	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
          //   3395: istore 9
          //   3397: goto -139 -> 3258
          //   3400: ldc_w 539
          //   3403: istore_2
          //   3404: goto -93 -> 3311
          //   3407: astore 12
          //   3409: ldc 169
          //   3411: new 171	java/lang/StringBuilder
          //   3414: dup
          //   3415: ldc_w 474
          //   3418: invokespecial 176	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   3421: aload 12
          //   3423: invokevirtual 180	java/lang/Exception:getMessage	()Ljava/lang/String;
          //   3426: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   3429: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   3432: invokestatic 477	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
          //   3435: iconst_0
          //   3436: istore 8
          //   3438: goto -1674 -> 1764
          //   3441: ldc 169
          //   3443: ldc_w 541
          //   3446: invokestatic 543	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
          //   3449: goto -1242 -> 2207
          //   3452: astore 12
          //   3454: ldc 169
          //   3456: aload 12
          //   3458: ldc_w 519
          //   3461: iconst_0
          //   3462: anewarray 4	java/lang/Object
          //   3465: invokestatic 523	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
          //   3468: goto -1169 -> 2299
          //   3471: aload_0
          //   3472: getfield 17	com/tencent/mm/plugin/webview/ui/tools/j$14:vcO	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   3475: aload 12
          //   3477: invokestatic 546	com/tencent/mm/plugin/webview/ui/tools/j:a	(Lcom/tencent/mm/plugin/webview/ui/tools/j;Ljava/util/List;)V
          //   3480: goto -707 -> 2773
          //   3483: astore 13
          //   3485: goto -1316 -> 2169
          //   3488: iload_2
          //   3489: iconst_1
          //   3490: iadd
          //   3491: istore_2
          //   3492: goto -3350 -> 142
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	3495	0	this	14
          //   0	3495	1	paramAnonymousl	com.tencent.mm.ui.base.l
          //   47	3445	2	i	int
          //   45	757	3	j	int
          //   767	2337	4	k	int
          //   688	2394	5	m	int
          //   1041	25	6	l	long
          //   1433	2004	8	bool1	boolean
          //   3256	140	9	bool2	boolean
          //   3247	140	10	bool3	boolean
          //   3268	44	11	bool4	boolean
          //   67	335	12	localObject1	Object
          //   406	14	12	localException1	Exception
          //   699	2010	12	localObject2	Object
          //   2745	15	12	localException2	Exception
          //   2857	34	12	str	String
          //   3053	15	12	localRemoteException	android.os.RemoteException
          //   3132	5	12	localException3	Exception
          //   3185	42	12	localException4	Exception
          //   3345	15	12	localException5	Exception
          //   3407	15	12	localException6	Exception
          //   3452	24	12	localException7	Exception
          //   86	2813	13	localObject3	Object
          //   3151	15	13	localException8	Exception
          //   3483	1	13	localException9	Exception
          //   166	3223	14	localObject4	Object
          // Exception table:
          //   from	to	target	type
          //   123	135	406	java/lang/Exception
          //   142	151	406	java/lang/Exception
          //   157	168	406	java/lang/Exception
          //   171	212	406	java/lang/Exception
          //   217	227	406	java/lang/Exception
          //   230	271	406	java/lang/Exception
          //   274	315	406	java/lang/Exception
          //   318	359	406	java/lang/Exception
          //   362	403	406	java/lang/Exception
          //   2641	2717	2745	java/lang/Exception
          //   2717	2742	2745	java/lang/Exception
          //   3471	3480	2745	java/lang/Exception
          //   692	701	3053	android/os/RemoteException
          //   703	720	3053	android/os/RemoteException
          //   722	742	3053	android/os/RemoteException
          //   744	765	3053	android/os/RemoteException
          //   778	788	3053	android/os/RemoteException
          //   790	801	3053	android/os/RemoteException
          //   1043	1100	3132	java/lang/Exception
          //   1416	1435	3151	java/lang/Exception
          //   1440	1457	3185	java/lang/Exception
          //   3216	3235	3345	java/lang/Exception
          //   1708	1749	3407	java/lang/Exception
          //   1754	1764	3407	java/lang/Exception
          //   2241	2299	3452	java/lang/Exception
          //   2148	2165	3483	java/lang/Exception
        }
      };
      if (ddt().pOd == null) {
        break label338;
      }
      str = ddt().pOd.getUrl();
      if (bo.isNullOrNil(str)) {
        break label525;
      }
      localObject1 = Uri.parse(str).getHost();
      localObject2 = ddt().getString(2131305882, new Object[] { localObject1 });
      if (!bo.isNullOrNil(this.vcH)) {
        break label343;
      }
      if (!bo.isNullOrNil((String)localObject1)) {
        this.iOd.r((CharSequence)localObject2, 1);
      }
      label233:
      if (!ddt().ven) {
        break label539;
      }
      this.iOd.vnU = true;
    }
    for (this.iOd.vnV = true;; this.iOd.vnV = false)
    {
      if ((ddt().ves == null) || (!ddt().ves.isShown())) {
        break label558;
      }
      ddt().ves.hide();
      al.p(new j.16(this), 100L);
      AppMethodBeat.o(7668);
      return;
      bool = false;
      break;
      label318:
      this.iOd = new com.tencent.mm.ui.widget.b.d(ddt(), 0, true);
      break label75;
      label338:
      str = null;
      break label171;
      label343:
      View localView = LayoutInflater.from(ddt()).inflate(2130970282, null);
      TextView localTextView = (TextView)localView.findViewById(2131823007);
      localObject1 = (MMNeat7extView)localView.findViewById(2131824774);
      this.iOd.G(localView, false);
      localTextView.setText((CharSequence)localObject2);
      localObject2 = com.tencent.mm.pluginsdk.ui.d.j.g(((MMNeat7extView)localObject1).getContext(), bo.nullAsNil(this.vcH), (int)((MMNeat7extView)localObject1).getTextSize());
      ((MMNeat7extView)localObject1).af((CharSequence)localObject2);
      localObject2 = (ClickableSpan[])((SpannableString)localObject2).getSpans(0, ((SpannableString)localObject2).length(), ClickableSpan.class);
      if ((localObject2 == null) || (localObject2.length <= 0)) {
        break label233;
      }
      ab.i("MicroMsg.WebViewMenuHelper", "terry h5 apply show");
      com.tencent.mm.plugin.report.service.h.qsU.e(16337, new Object[] { str, Integer.valueOf(1), Integer.valueOf(0) });
      ((MMNeat7extView)localObject1).setOnTouchListener(new j.15(this, (NeatTextView)localObject1, new m(((MMNeat7extView)localObject1).getContext()), str));
      break label233;
      label525:
      this.iOd.r(" ", 1);
      break label233;
      label539:
      this.iOd.vnU = false;
    }
    label558:
    ddt().hideVKB();
    al.p(new j.17(this), 100L);
    AppMethodBeat.o(7668);
  }
  
  public final void aYp()
  {
    AppMethodBeat.i(153216);
    if ((ddt() == null) || (ddt().igV == null) || (ddt().igV.ddV() == null))
    {
      ab.e("MicroMsg.WebViewMenuHelper", "showShareMenu params failed");
      AppMethodBeat.o(153216);
      return;
    }
    JsapiPermissionWrapper localJsapiPermissionWrapper = ddt().igV.ddV();
    if ((!a(localJsapiPermissionWrapper, 21, 1)) && (!a(localJsapiPermissionWrapper, 23, 2)))
    {
      com.tencent.mm.ui.base.h.bO(ddt(), ddt().getString(2131306012));
      AppMethodBeat.o(153216);
      return;
    }
    com.tencent.mm.ui.widget.b.d locald = new com.tencent.mm.ui.widget.b.d(ddt(), 1, false);
    locald.sao = new j.9(this, localJsapiPermissionWrapper);
    locald.sap = new j.10(this);
    locald.r(" ", 1);
    locald.crd();
    AppMethodBeat.o(153216);
  }
  
  public final void aYt()
  {
    AppMethodBeat.i(153217);
    if ((ddt() == null) || (ddt().pOd == null) || (ddt().igV == null) || (ddt().igV.ddV() == null))
    {
      ab.e("MicroMsg.WebViewMenuHelper", "setShareFuncFlag params failed");
      AppMethodBeat.o(153217);
      return;
    }
    String str = ddt().pOd.getUrl();
    if (!bo.isNullOrNil(str))
    {
      try
      {
        boolean bool = new URL(str).getHost().equals("mp.weixin.qq.com");
        if (bool) {
          break label148;
        }
        AppMethodBeat.o(153217);
        return;
      }
      catch (Exception localException)
      {
        ab.e("MicroMsg.WebViewMenuHelper", "create url fail : " + localException.getLocalizedMessage());
        AppMethodBeat.o(153217);
        return;
      }
    }
    else
    {
      AppMethodBeat.o(153217);
      return;
    }
    label148:
    int i = ddU();
    if (ddt().uQS != null) {
      ddt().uQS.dU("setFuncFlag", i);
    }
    AppMethodBeat.o(153217);
  }
  
  public final void ail(String paramString)
  {
    AppMethodBeat.i(7661);
    SparseBooleanArray localSparseBooleanArray2 = (SparseBooleanArray)this.vcC.get(paramString);
    SparseBooleanArray localSparseBooleanArray1 = localSparseBooleanArray2;
    if (localSparseBooleanArray2 == null)
    {
      localSparseBooleanArray1 = new SparseBooleanArray();
      this.vcC.put(paramString, localSparseBooleanArray1);
    }
    if (localSparseBooleanArray1 != null) {
      localSparseBooleanArray1.put(34, true);
    }
    AppMethodBeat.o(7661);
  }
  
  final void aim(String paramString)
  {
    AppMethodBeat.i(7670);
    ddt().uQS.bQ("sendAppMessage", false);
    com.tencent.mm.plugin.webview.ui.tools.jsapi.d locald = ddt().uQS;
    if (!locald.ready)
    {
      ab.e("MicroMsg.JsApiHandler", "onSendToEnterprise fail, not ready");
      AppMethodBeat.o(7670);
      return;
    }
    Object localObject = new HashMap();
    ((HashMap)localObject).put("scene", "enterprise");
    localObject = i.a.b("menu:share:appmessage", (Map)localObject, locald.voB, locald.voC);
    locald.vou.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + (String)localObject + ")", null);
    try
    {
      locald.igU.Q("connector_local_send", paramString, locald.uZg);
      locald.igU.Q("scene", "enterprise", locald.uZg);
      AppMethodBeat.o(7670);
      return;
    }
    catch (Exception paramString)
    {
      ab.w("MicroMsg.JsApiHandler", "jsapiBundlePutString, ex = " + paramString.getMessage());
      AppMethodBeat.o(7670);
    }
  }
  
  /* Error */
  protected final void ain(String paramString)
  {
    // Byte code:
    //   0: sipush 7671
    //   3: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokevirtual 187	com/tencent/mm/plugin/webview/ui/tools/a:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   10: invokevirtual 191	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   13: ldc 193
    //   15: invokevirtual 198	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   18: astore 8
    //   20: aload_0
    //   21: invokevirtual 124	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   24: invokevirtual 231	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:dek	()Ljava/lang/String;
    //   27: astore 9
    //   29: aconst_null
    //   30: astore 5
    //   32: aload 9
    //   34: invokestatic 421	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   37: ifne +13 -> 50
    //   40: aload 9
    //   42: invokestatic 681	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   45: invokevirtual 684	android/net/Uri:getHost	()Ljava/lang/String;
    //   48: astore 5
    //   50: aload 5
    //   52: invokestatic 421	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   55: ifne +514 -> 569
    //   58: aload 5
    //   60: ldc_w 845
    //   63: invokevirtual 886	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   66: ifeq +503 -> 569
    //   69: ldc_w 888
    //   72: iconst_1
    //   73: anewarray 150	java/lang/Object
    //   76: dup
    //   77: iconst_0
    //   78: aload 9
    //   80: ldc_w 890
    //   83: invokestatic 186	com/tencent/mm/compatible/util/q:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   86: aastore
    //   87: invokestatic 894	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   90: astore 5
    //   92: aload_0
    //   93: invokevirtual 124	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   96: aload_0
    //   97: invokevirtual 124	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   100: getfield 227	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:pOd	Lcom/tencent/mm/ui/widget/MMWebView;
    //   103: invokevirtual 424	com/tencent/mm/ui/widget/MMWebView:getUrl	()Ljava/lang/String;
    //   106: invokevirtual 131	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:aiu	(Ljava/lang/String;)Ljava/lang/String;
    //   109: astore 10
    //   111: aload_0
    //   112: invokevirtual 124	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   115: getfield 444	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:igV	Lcom/tencent/mm/plugin/webview/ui/tools/k;
    //   118: invokevirtual 898	com/tencent/mm/plugin/webview/ui/tools/k:ddW	()Lcom/tencent/mm/protocal/GeneralControlWrapper;
    //   121: invokevirtual 903	com/tencent/mm/protocal/GeneralControlWrapper:dqx	()Z
    //   124: istore_2
    //   125: ldc 139
    //   127: ldc_w 905
    //   130: iconst_1
    //   131: anewarray 150	java/lang/Object
    //   134: dup
    //   135: iconst_0
    //   136: iload_2
    //   137: invokestatic 318	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   140: aastore
    //   141: invokestatic 178	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   144: aload 10
    //   146: invokestatic 137	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   149: ifne +179 -> 328
    //   152: iload_2
    //   153: ifeq +175 -> 328
    //   156: aload_0
    //   157: invokevirtual 124	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   160: getfield 227	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:pOd	Lcom/tencent/mm/ui/widget/MMWebView;
    //   163: invokevirtual 424	com/tencent/mm/ui/widget/MMWebView:getUrl	()Ljava/lang/String;
    //   166: invokestatic 137	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   169: ifne +159 -> 328
    //   172: invokestatic 159	com/tencent/mm/sdk/platformtools/bo:aox	()J
    //   175: lstore_3
    //   176: ldc 139
    //   178: ldc_w 907
    //   181: bipush 7
    //   183: anewarray 150	java/lang/Object
    //   186: dup
    //   187: iconst_0
    //   188: sipush 13377
    //   191: invokestatic 167	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   194: aastore
    //   195: dup
    //   196: iconst_1
    //   197: lload_3
    //   198: invokestatic 172	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   201: aastore
    //   202: dup
    //   203: iconst_2
    //   204: aload 10
    //   206: aastore
    //   207: dup
    //   208: iconst_3
    //   209: aload_0
    //   210: invokevirtual 124	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   213: getfield 227	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:pOd	Lcom/tencent/mm/ui/widget/MMWebView;
    //   216: invokevirtual 424	com/tencent/mm/ui/widget/MMWebView:getUrl	()Ljava/lang/String;
    //   219: aastore
    //   220: dup
    //   221: iconst_4
    //   222: aload_0
    //   223: invokevirtual 124	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   226: getfield 175	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:cpW	Ljava/lang/String;
    //   229: aastore
    //   230: dup
    //   231: iconst_5
    //   232: iconst_4
    //   233: invokestatic 167	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   236: aastore
    //   237: dup
    //   238: bipush 6
    //   240: iconst_1
    //   241: invokestatic 167	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   244: aastore
    //   245: invokestatic 178	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   248: ldc 74
    //   250: astore 6
    //   252: aload_0
    //   253: invokevirtual 124	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   256: getfield 227	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:pOd	Lcom/tencent/mm/ui/widget/MMWebView;
    //   259: invokevirtual 424	com/tencent/mm/ui/widget/MMWebView:getUrl	()Ljava/lang/String;
    //   262: ldc 180
    //   264: invokestatic 186	com/tencent/mm/compatible/util/q:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   267: astore 7
    //   269: aload 7
    //   271: astore 6
    //   273: getstatic 208	com/tencent/mm/plugin/report/service/h:qsU	Lcom/tencent/mm/plugin/report/service/h;
    //   276: sipush 13377
    //   279: bipush 6
    //   281: anewarray 150	java/lang/Object
    //   284: dup
    //   285: iconst_0
    //   286: lload_3
    //   287: invokestatic 172	java/lang/Long:valueOf	(J)Ljava/lang/Long;
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
    //   304: invokevirtual 124	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   307: getfield 175	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:cpW	Ljava/lang/String;
    //   310: aastore
    //   311: dup
    //   312: iconst_4
    //   313: iconst_4
    //   314: invokestatic 167	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   317: aastore
    //   318: dup
    //   319: iconst_5
    //   320: iconst_1
    //   321: invokestatic 167	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   324: aastore
    //   325: invokevirtual 212	com/tencent/mm/plugin/report/service/h:e	(I[Ljava/lang/Object;)V
    //   328: aload 5
    //   330: astore 6
    //   332: aload 5
    //   334: invokestatic 421	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   337: ifeq +23 -> 360
    //   340: ldc_w 909
    //   343: iconst_1
    //   344: anewarray 150	java/lang/Object
    //   347: dup
    //   348: iconst_0
    //   349: bipush 34
    //   351: invokestatic 167	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   354: aastore
    //   355: invokestatic 894	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   358: astore 6
    //   360: new 195	android/content/Intent
    //   363: dup
    //   364: invokespecial 910	android/content/Intent:<init>	()V
    //   367: astore 5
    //   369: aload_1
    //   370: invokestatic 421	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   373: ifne +23 -> 396
    //   376: aload 5
    //   378: ldc_w 912
    //   381: aload_1
    //   382: ldc 180
    //   384: invokevirtual 916	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   387: bipush 11
    //   389: invokestatic 922	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   392: invokevirtual 926	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   395: pop
    //   396: ldc 139
    //   398: ldc_w 928
    //   401: iconst_2
    //   402: anewarray 150	java/lang/Object
    //   405: dup
    //   406: iconst_0
    //   407: aload 9
    //   409: aastore
    //   410: dup
    //   411: iconst_1
    //   412: aload_0
    //   413: invokevirtual 124	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   416: invokevirtual 931	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:daZ	()Ljava/lang/String;
    //   419: aastore
    //   420: invokestatic 153	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   423: aload 5
    //   425: ldc_w 933
    //   428: aload 6
    //   430: invokevirtual 926	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   433: pop
    //   434: aload 5
    //   436: ldc_w 935
    //   439: aload 9
    //   441: invokevirtual 926	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   444: pop
    //   445: aload 5
    //   447: ldc_w 937
    //   450: aload_0
    //   451: invokevirtual 124	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   454: invokevirtual 931	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:daZ	()Ljava/lang/String;
    //   457: invokevirtual 926	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   460: pop
    //   461: aload 5
    //   463: ldc_w 939
    //   466: aload_0
    //   467: invokevirtual 124	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   470: aload 8
    //   472: invokevirtual 202	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:aio	(Ljava/lang/String;)I
    //   475: invokevirtual 942	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   478: pop
    //   479: aload 5
    //   481: ldc_w 944
    //   484: iconst_0
    //   485: invokevirtual 947	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   488: pop
    //   489: aload_0
    //   490: invokevirtual 124	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   493: aload_0
    //   494: invokevirtual 124	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   497: ldc_w 948
    //   500: invokevirtual 820	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
    //   503: ldc 74
    //   505: aload_0
    //   506: invokevirtual 124	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   509: ldc_w 949
    //   512: invokevirtual 820	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
    //   515: aload_0
    //   516: invokevirtual 124	com/tencent/mm/plugin/webview/ui/tools/j:ddt	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   519: ldc_w 950
    //   522: invokevirtual 820	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
    //   525: iconst_0
    //   526: new 952	com/tencent/mm/plugin/webview/ui/tools/j$5
    //   529: dup
    //   530: aload_0
    //   531: aload 5
    //   533: invokespecial 955	com/tencent/mm/plugin/webview/ui/tools/j$5:<init>	(Lcom/tencent/mm/plugin/webview/ui/tools/j;Landroid/content/Intent;)V
    //   536: new 957	com/tencent/mm/plugin/webview/ui/tools/j$6
    //   539: dup
    //   540: aload_0
    //   541: aload 5
    //   543: invokespecial 958	com/tencent/mm/plugin/webview/ui/tools/j$6:<init>	(Lcom/tencent/mm/plugin/webview/ui/tools/j;Landroid/content/Intent;)V
    //   546: invokestatic 961	com/tencent/mm/ui/base/h:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLandroid/content/DialogInterface$OnClickListener;Landroid/content/DialogInterface$OnClickListener;)Lcom/tencent/mm/ui/widget/b/c;
    //   549: pop
    //   550: sipush 7671
    //   553: invokestatic 116	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   556: return
    //   557: astore 5
    //   559: ldc 139
    //   561: aload 5
    //   563: invokevirtual 962	java/io/UnsupportedEncodingException:getMessage	()Ljava/lang/String;
    //   566: invokestatic 448	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   569: aconst_null
    //   570: astore 5
    //   572: goto -480 -> 92
    //   575: astore 7
    //   577: ldc 139
    //   579: aload 7
    //   581: ldc 74
    //   583: iconst_0
    //   584: anewarray 150	java/lang/Object
    //   587: invokestatic 216	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   590: goto -317 -> 273
    //   593: astore_1
    //   594: ldc 139
    //   596: new 391	java/lang/StringBuilder
    //   599: dup
    //   600: ldc_w 964
    //   603: invokespecial 395	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   606: aload_1
    //   607: invokevirtual 962	java/io/UnsupportedEncodingException:getMessage	()Ljava/lang/String;
    //   610: invokevirtual 399	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   613: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   616: invokestatic 448	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   619: goto -223 -> 396
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	622	0	this	j
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
  
  public final void dR(String paramString, int paramInt)
  {
    AppMethodBeat.i(154902);
    if (ddt().uQS != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt(paramString, paramInt);
      paramString = ddt().uQS;
      try
      {
        paramString.igU.a(21, localBundle, paramString.uZg);
        AppMethodBeat.o(154902);
        return;
      }
      catch (Exception paramString)
      {
        ab.printErrStackTrace("MicroMsg.JsApiHandler", paramString, "", new Object[0]);
        ab.w("MicroMsg.JsApiHandler", "updateJsapiArgsBundleKV, ex = ".concat(String.valueOf(paramString)));
      }
    }
    AppMethodBeat.o(154902);
  }
  
  public final void ddL()
  {
    AppMethodBeat.i(7660);
    this.vcD.clear();
    this.vcD.put("menuItem:share:brand", Integer.valueOf(0));
    this.vcD.put("menuItem:share:appMessage", Integer.valueOf(1));
    this.vcD.put("menuItem:share:dataMessage", Integer.valueOf(23));
    this.vcD.put("menuItem:share:timeline", Integer.valueOf(2));
    this.vcD.put("menuItem:favorite", Integer.valueOf(3));
    this.vcD.put("menuItem:profile", Integer.valueOf(5));
    this.vcD.put("menuItem:addContact", Integer.valueOf(5));
    this.vcD.put("menuItem:copyUrl", Integer.valueOf(6));
    this.vcD.put("menuItem:openWithSafari", Integer.valueOf(7));
    this.vcD.put("menuItem:share:email", Integer.valueOf(8));
    this.vcD.put("menuItem:delete", Integer.valueOf(9));
    this.vcD.put("menuItem:exposeArticle", Integer.valueOf(10));
    this.vcD.put("menuItem:setFont", Integer.valueOf(11));
    this.vcD.put("menuItem:editTag", Integer.valueOf(12));
    this.vcD.put("menuItem:readMode", Integer.valueOf(14));
    this.vcD.put("menuItem:originPage", Integer.valueOf(14));
    this.vcD.put("menuItem:share:qq", Integer.valueOf(20));
    this.vcD.put("menuItem:share:weiboApp", Integer.valueOf(21));
    this.vcD.put("menuItem:share:QZone", Integer.valueOf(22));
    this.vcD.put("menuItem:share:Facebook", Integer.valueOf(33));
    this.vcD.put("menuItem:share:enterprise", Integer.valueOf(24));
    this.vcD.put("menuItem:refresh", Integer.valueOf(28));
    this.vcD.put("menuItem:share:wework", Integer.valueOf(25));
    this.vcD.put("menuItem:share:weread", Integer.valueOf(26));
    this.vcD.put("menuItem:addShortcut", Integer.valueOf(29));
    this.vcD.put("menuItem:search", Integer.valueOf(31));
    this.vcD.put("menuItem:readArticle", Integer.valueOf(34));
    this.vcD.put("menuItem:minimize", Integer.valueOf(35));
    this.vcD.put("menuItem:cancelMinimize", Integer.valueOf(36));
    this.vcD.put("menuItem:translate", Integer.valueOf(37));
    this.vcD.put("menuItem:haoKan", Integer.valueOf(38));
    this.vcD.put("menuItem:cancelHaoKan", Integer.valueOf(39));
    AppMethodBeat.o(7660);
  }
  
  protected final void ddM()
  {
    AppMethodBeat.i(7665);
    if (!this.vcK)
    {
      AppMethodBeat.o(7665);
      return;
    }
    this.vcJ = false;
    ddt().vgl = false;
    this.vcK = false;
    if (this.kiI) {
      aYo();
    }
    AppMethodBeat.o(7665);
  }
  
  public final void ddN()
  {
    AppMethodBeat.i(7666);
    if (this.kiI) {
      aYo();
    }
    AppMethodBeat.o(7666);
  }
  
  public final void ddO()
  {
    AppMethodBeat.i(7667);
    this.vcJ = true;
    this.vcL.clear();
    if ((ddt() instanceof GameWebViewUI))
    {
      this.vcL.add(Integer.valueOf(11));
      this.vcL.add(Integer.valueOf(28));
      AppMethodBeat.o(7667);
      return;
    }
    this.vcL.add(Integer.valueOf(7));
    this.vcL.add(Integer.valueOf(11));
    this.vcL.add(Integer.valueOf(28));
    AppMethodBeat.o(7667);
  }
  
  protected final void ddQ()
  {
    AppMethodBeat.i(7673);
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putLong("msg_id", ddt().getIntent().getLongExtra("msg_id", -9223372036854775808L));
    ((Bundle)localObject1).putString("sns_local_id", ddt().getIntent().getStringExtra("sns_local_id"));
    ((Bundle)localObject1).putInt("news_svr_id", ddt().getIntent().getIntExtra("news_svr_id", 0));
    ((Bundle)localObject1).putString("news_svr_tweetid", ddt().getIntent().getStringExtra("news_svr_tweetid"));
    ((Bundle)localObject1).putInt("message_index", ddt().getIntent().getIntExtra("message_index", 0));
    ((Bundle)localObject1).putString("rawUrl", ddt().cJr);
    Object localObject2;
    if ((!bo.isNullOrNil(ddt().cJr)) && (ddt().cJr.endsWith("#rd")))
    {
      localObject2 = ddt().cJr.substring(0, ddt().cJr.length() - 3);
      if ((!bo.isNullOrNil(ddt().vgr)) && (!ddt().vgr.startsWith((String)localObject2)))
      {
        ((Bundle)localObject1).putString("rawUrl", ddt().vgr);
        ((Bundle)localObject1).putLong("msg_id", -9223372036854775808L);
      }
      localObject2 = ddt().getIntent();
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
          localObject1 = ddt().igU.ai((Bundle)localObject1);
          if (!((b)localObject1).dcU()) {
            break label760;
          }
          ddt().uQS.bQ("sendAppMessage", false);
          localObject1 = ddt().uQS;
          localObject2 = ddR();
          ab.i("MicroMsg.JsApiHandler", "onFavorite %b", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.webview.ui.tools.jsapi.d)localObject1).ready) });
          bool = ((com.tencent.mm.plugin.webview.ui.tools.jsapi.d)localObject1).ready;
          if (!bool) {
            try
            {
              ((com.tencent.mm.plugin.webview.ui.tools.jsapi.d)localObject1).igU.Q("scene", "favorite", ((com.tencent.mm.plugin.webview.ui.tools.jsapi.d)localObject1).uZg);
              ((com.tencent.mm.plugin.webview.ui.tools.jsapi.d)localObject1).h(((com.tencent.mm.plugin.webview.ui.tools.jsapi.d)localObject1).aM((Map)localObject2), "sendAppMessage");
              ab.i("MicroMsg.WebViewMenuHelper", "on favorite simple url");
              AppMethodBeat.o(7673);
              return;
              if ((bo.isNullOrNil(ddt().vgr)) || (ddt().vgr.startsWith(ddt().cJr))) {
                break;
              }
              ((Bundle)localObject1).putString("rawUrl", ddt().vgr);
              ((Bundle)localObject1).putLong("msg_id", -9223372036854775808L);
            }
            catch (Exception localException1)
            {
              for (;;)
              {
                ab.w("MicroMsg.JsApiHandler", "jsapiBundlePutString, ex = " + localException1.getMessage());
              }
            }
          }
        }
        localObject2 = localException2.KS(1);
      }
      catch (Exception localException2)
      {
        ab.e("MicroMsg.WebViewMenuHelper", "edw, favoriteUrl fail, ex = " + localException2.getMessage());
        AppMethodBeat.o(7673);
        return;
      }
      if (localObject2 != null)
      {
        bool = ((Bundle)localObject2).getBoolean("WebViewShare_reslut", false);
        if (bool) {
          try
          {
            localException2.igU.Q("scene", "favorite", localException2.uZg);
            localException2.h((Bundle)localObject2, "sendAppMessage");
          }
          catch (Exception localException4)
          {
            for (;;)
            {
              ab.w("MicroMsg.JsApiHandler", "jsapiBundlePutString, ex = " + localException4.getMessage());
            }
          }
        }
      }
      localObject2 = new HashMap();
      ((HashMap)localObject2).put("scene", "favorite");
      localObject2 = i.a.b("menu:share:appmessage", (Map)localObject2, localException2.voB, localException2.voC);
      localException2.vou.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + (String)localObject2 + ")", null);
      try
      {
        localException2.igU.Q("scene", "favorite", localException2.uZg);
      }
      catch (Exception localException3)
      {
        ab.w("MicroMsg.JsApiHandler", "jsapiBundlePutString, ex = " + localException3.getMessage());
      }
    }
    label760:
    c.a(localException3.getRet(), ddt(), ddt().nkf);
    if (localException3.getRet() == 0)
    {
      Kv(1);
      AppMethodBeat.o(7673);
      return;
    }
    Kv(2);
    AppMethodBeat.o(7673);
  }
  
  public final HashMap<String, String> ddR()
  {
    AppMethodBeat.i(7674);
    if (!ddt().vgl)
    {
      AppMethodBeat.o(7674);
      return null;
    }
    Intent localIntent = ddt().getIntent();
    String str1 = localIntent.getStringExtra("share_report_pre_msg_url");
    String str2 = localIntent.getStringExtra("share_report_pre_msg_title");
    String str3 = localIntent.getStringExtra("share_report_pre_msg_icon_url");
    HashMap localHashMap = new HashMap();
    localHashMap.put("share_report_pre_msg_url", str1);
    localHashMap.put("share_report_pre_msg_title", str2);
    localHashMap.put("share_report_pre_msg_desc", localIntent.getStringExtra("share_report_pre_msg_desc"));
    localHashMap.put("share_report_pre_msg_icon_url", str3);
    AppMethodBeat.o(7674);
    return localHashMap;
  }
  
  final boolean ddS()
  {
    AppMethodBeat.i(7676);
    try
    {
      boolean bool = ddt().igU.ahR("favorite");
      AppMethodBeat.o(7676);
      return bool;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.WebViewMenuHelper", localException, "", new Object[0]);
      AppMethodBeat.o(7676);
    }
    return false;
  }
  
  public final Bundle ddT()
  {
    AppMethodBeat.i(153215);
    Bundle localBundle = new Bundle();
    localBundle.putInt("funcFlag", ddU());
    AppMethodBeat.o(153215);
    return localBundle;
  }
  
  final void eh(List<String> paramList)
  {
    AppMethodBeat.i(7675);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(7675);
      return;
    }
    Iterator localIterator = paramList.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label302;
      }
      String str2 = (String)localIterator.next();
      if (this.vcE.get(str2) != null) {
        ab.i("MicroMsg.WebViewMenuHelper", "find %s icon from cache ok", new Object[] { str2 });
      }
      for (;;)
      {
        if (!this.vcF.containsKey(str2)) {
          break label213;
        }
        ab.i("MicroMsg.WebViewMenuHelper", "find %s nick from cache ok", new Object[] { str2 });
        break;
        ab.w("MicroMsg.WebViewMenuHelper", "not found %s icon from cache, try to load", new Object[] { str2 });
        try
        {
          paramList = ddt().igU.ahN(str2);
          if (!bo.isNullOrNil(paramList))
          {
            paramList = g.aie(paramList);
            if (paramList != null)
            {
              ab.i("MicroMsg.WebViewMenuHelper", "load ok, and cache it");
              this.vcE.put(str2, paramList);
            }
          }
        }
        catch (Exception paramList)
        {
          ab.w("MicroMsg.WebViewMenuHelper", "getheadimg, ex = " + paramList.getMessage());
        }
      }
      label213:
      ab.w("MicroMsg.WebViewMenuHelper", "not found %s nick from cache, try to load", new Object[] { str2 });
      paramList = null;
      try
      {
        String str1 = ddt().igU.nE(str2);
        paramList = str1;
        ab.i("MicroMsg.WebViewMenuHelper", "load nick ok");
        paramList = str1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ab.w("MicroMsg.WebViewMenuHelper", "onAttach, ex = " + localException.getMessage());
        }
      }
      this.vcF.put(str2, paramList);
    }
    label302:
    AppMethodBeat.o(7675);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(7659);
    Iterator localIterator = this.vcC.values().iterator();
    while (localIterator.hasNext())
    {
      SparseBooleanArray localSparseBooleanArray = (SparseBooleanArray)localIterator.next();
      if (localSparseBooleanArray != null) {
        localSparseBooleanArray.clear();
      }
    }
    this.vcC.clear();
    this.vcI.clear();
    AppMethodBeat.o(7659);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.j
 * JD-Core Version:    0.7.0.1
 */