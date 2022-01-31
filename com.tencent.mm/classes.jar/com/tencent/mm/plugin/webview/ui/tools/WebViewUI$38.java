package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.ui.base.n.c;
import java.util.ArrayList;

final class WebViewUI$38
  implements n.c
{
  WebViewUI$38(WebViewUI paramWebViewUI, Boolean paramBoolean, ArrayList paramArrayList) {}
  
  /* Error */
  public final void a(com.tencent.mm.ui.base.l paraml)
  {
    // Byte code:
    //   0: getstatic 38	com/tencent/mm/plugin/report/service/h:nFQ	Lcom/tencent/mm/plugin/report/service/h;
    //   3: ldc2_w 39
    //   6: lconst_0
    //   7: lconst_1
    //   8: iconst_0
    //   9: invokevirtual 43	com/tencent/mm/plugin/report/service/h:a	(JJJZ)V
    //   12: aload_0
    //   13: getfield 23	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rqd	Ljava/lang/Boolean;
    //   16: invokevirtual 49	java/lang/Boolean:booleanValue	()Z
    //   19: ifeq +78 -> 97
    //   22: aload_0
    //   23: getfield 25	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rqf	Ljava/util/ArrayList;
    //   26: invokevirtual 55	java/util/ArrayList:size	()I
    //   29: istore_3
    //   30: iconst_0
    //   31: istore_2
    //   32: iload_2
    //   33: iload_3
    //   34: if_icmpge +395 -> 429
    //   37: aload_0
    //   38: getfield 25	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rqf	Ljava/util/ArrayList;
    //   41: iload_2
    //   42: invokevirtual 59	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   45: checkcast 61	com/tencent/mm/m/d$b
    //   48: astore 10
    //   50: aload_1
    //   51: aload 10
    //   53: getfield 65	com/tencent/mm/m/d$b:id	I
    //   56: aload 10
    //   58: getfield 69	com/tencent/mm/m/d$b:title	Ljava/lang/String;
    //   61: invokevirtual 75	com/tencent/mm/ui/base/l:e	(ILjava/lang/CharSequence;)Landroid/view/MenuItem;
    //   64: checkcast 77	com/tencent/mm/ui/base/m
    //   67: astore 11
    //   69: aload 11
    //   71: aload 10
    //   73: putfield 81	com/tencent/mm/ui/base/m:uWG	Landroid/view/ContextMenu$ContextMenuInfo;
    //   76: aload 11
    //   78: aconst_null
    //   79: invokevirtual 85	com/tencent/mm/ui/base/m:setIcon	(Landroid/graphics/drawable/Drawable;)Landroid/view/MenuItem;
    //   82: pop
    //   83: aload 11
    //   85: iconst_0
    //   86: invokevirtual 88	com/tencent/mm/ui/base/m:setIcon	(I)Landroid/view/MenuItem;
    //   89: pop
    //   90: iload_2
    //   91: iconst_1
    //   92: iadd
    //   93: istore_2
    //   94: goto -62 -> 32
    //   97: aload_0
    //   98: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   101: invokestatic 92	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:aj	(Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;)Ljava/util/LinkedList;
    //   104: astore 11
    //   106: aload 11
    //   108: ifnull +291 -> 399
    //   111: iconst_0
    //   112: istore_2
    //   113: iload_2
    //   114: aload 11
    //   116: invokevirtual 95	java/util/LinkedList:size	()I
    //   119: if_icmpge +280 -> 399
    //   122: iload_2
    //   123: bipush 8
    //   125: if_icmpge +274 -> 399
    //   128: aload 11
    //   130: iload_2
    //   131: invokevirtual 96	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   134: checkcast 98	com/tencent/mm/m/d$a
    //   137: astore 12
    //   139: aconst_null
    //   140: astore 10
    //   142: ldc 100
    //   144: aload 12
    //   146: getfield 102	com/tencent/mm/m/d$a:id	Ljava/lang/String;
    //   149: invokestatic 108	com/tencent/mm/sdk/platformtools/bk:pm	(Ljava/lang/String;)Ljava/lang/String;
    //   152: invokevirtual 114	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   155: ifeq +45 -> 200
    //   158: aload_1
    //   159: bipush 15
    //   161: aload_0
    //   162: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   165: getstatic 119	com/tencent/mm/R$l:webview_jd_menu_title_index	I
    //   168: invokevirtual 123	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
    //   171: getstatic 128	com/tencent/mm/R$k:bottomsheet_icon_jd_index	I
    //   174: invokevirtual 131	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;I)Landroid/view/MenuItem;
    //   177: checkcast 77	com/tencent/mm/ui/base/m
    //   180: astore 10
    //   182: aload 10
    //   184: ifnull +2420 -> 2604
    //   187: aload 10
    //   189: aload 12
    //   191: getfield 134	com/tencent/mm/m/d$a:url	Ljava/lang/String;
    //   194: putfield 137	com/tencent/mm/ui/base/m:gis	Ljava/lang/String;
    //   197: goto +2407 -> 2604
    //   200: ldc 139
    //   202: aload 12
    //   204: getfield 102	com/tencent/mm/m/d$a:id	Ljava/lang/String;
    //   207: invokestatic 108	com/tencent/mm/sdk/platformtools/bk:pm	(Ljava/lang/String;)Ljava/lang/String;
    //   210: invokevirtual 114	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   213: ifeq +30 -> 243
    //   216: aload_1
    //   217: bipush 16
    //   219: aload_0
    //   220: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   223: getstatic 142	com/tencent/mm/R$l:webview_jd_menu_title_categories	I
    //   226: invokevirtual 123	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
    //   229: getstatic 145	com/tencent/mm/R$k:bottomsheet_icon_jd_collect_list	I
    //   232: invokevirtual 131	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;I)Landroid/view/MenuItem;
    //   235: checkcast 77	com/tencent/mm/ui/base/m
    //   238: astore 10
    //   240: goto -58 -> 182
    //   243: ldc 147
    //   245: aload 12
    //   247: getfield 102	com/tencent/mm/m/d$a:id	Ljava/lang/String;
    //   250: invokestatic 108	com/tencent/mm/sdk/platformtools/bk:pm	(Ljava/lang/String;)Ljava/lang/String;
    //   253: invokevirtual 114	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   256: ifeq +30 -> 286
    //   259: aload_1
    //   260: bipush 17
    //   262: aload_0
    //   263: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   266: getstatic 150	com/tencent/mm/R$l:webview_jd_menu_title_cart	I
    //   269: invokevirtual 123	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
    //   272: getstatic 153	com/tencent/mm/R$k:bottomsheet_icon_jd_cart	I
    //   275: invokevirtual 131	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;I)Landroid/view/MenuItem;
    //   278: checkcast 77	com/tencent/mm/ui/base/m
    //   281: astore 10
    //   283: goto -101 -> 182
    //   286: ldc 155
    //   288: aload 12
    //   290: getfield 102	com/tencent/mm/m/d$a:id	Ljava/lang/String;
    //   293: invokestatic 108	com/tencent/mm/sdk/platformtools/bk:pm	(Ljava/lang/String;)Ljava/lang/String;
    //   296: invokevirtual 114	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   299: ifeq +30 -> 329
    //   302: aload_1
    //   303: bipush 18
    //   305: aload_0
    //   306: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   309: getstatic 158	com/tencent/mm/R$l:webview_jd_menu_title_profile	I
    //   312: invokevirtual 123	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
    //   315: getstatic 161	com/tencent/mm/R$k:bottomsheet_icon_profile	I
    //   318: invokevirtual 131	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;I)Landroid/view/MenuItem;
    //   321: checkcast 77	com/tencent/mm/ui/base/m
    //   324: astore 10
    //   326: goto -144 -> 182
    //   329: ldc 163
    //   331: aload 12
    //   333: getfield 102	com/tencent/mm/m/d$a:id	Ljava/lang/String;
    //   336: invokestatic 108	com/tencent/mm/sdk/platformtools/bk:pm	(Ljava/lang/String;)Ljava/lang/String;
    //   339: invokevirtual 114	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   342: ifeq -160 -> 182
    //   345: aload_1
    //   346: bipush 19
    //   348: aload_0
    //   349: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   352: getstatic 166	com/tencent/mm/R$l:webview_jd_menu_title_member	I
    //   355: invokevirtual 123	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
    //   358: getstatic 169	com/tencent/mm/R$k:bottomsheet_icon_jd_member	I
    //   361: invokevirtual 131	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;I)Landroid/view/MenuItem;
    //   364: checkcast 77	com/tencent/mm/ui/base/m
    //   367: astore 10
    //   369: goto -187 -> 182
    //   372: astore 10
    //   374: ldc 171
    //   376: new 173	java/lang/StringBuilder
    //   379: dup
    //   380: ldc 175
    //   382: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   385: aload 10
    //   387: invokevirtual 182	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   390: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   396: invokestatic 194	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   399: aload_0
    //   400: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   403: getfield 198	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:gGo	Lcom/tencent/mm/plugin/webview/ui/tools/f;
    //   406: ifnull +16 -> 422
    //   409: aload_0
    //   410: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   413: getfield 198	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:gGo	Lcom/tencent/mm/plugin/webview/ui/tools/f;
    //   416: invokevirtual 204	com/tencent/mm/plugin/webview/ui/tools/f:cdI	()Lcom/tencent/mm/protocal/JsapiPermissionWrapper;
    //   419: ifnonnull +11 -> 430
    //   422: ldc 171
    //   424: ldc 206
    //   426: invokestatic 194	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   429: return
    //   430: aload_0
    //   431: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   434: getfield 198	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:gGo	Lcom/tencent/mm/plugin/webview/ui/tools/f;
    //   437: invokevirtual 204	com/tencent/mm/plugin/webview/ui/tools/f:cdI	()Lcom/tencent/mm/protocal/JsapiPermissionWrapper;
    //   440: astore 12
    //   442: aload_0
    //   443: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   446: invokestatic 210	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:ak	(Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;)Z
    //   449: ifeq +50 -> 499
    //   452: aload_0
    //   453: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   456: bipush 35
    //   458: invokevirtual 214	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:CH	(I)Z
    //   461: ifeq +1757 -> 2218
    //   464: aload_0
    //   465: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   468: getfield 218	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:rbN	Lcom/tencent/mm/plugin/webview/ui/tools/bag/h;
    //   471: invokeinterface 223 1 0
    //   476: ifne +1742 -> 2218
    //   479: aload_1
    //   480: bipush 35
    //   482: aload_0
    //   483: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   486: getstatic 226	com/tencent/mm/R$l:readerapp_minimize	I
    //   489: invokevirtual 123	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
    //   492: getstatic 229	com/tencent/mm/R$k:bottomsheet_icon_webview_minimize	I
    //   495: invokevirtual 131	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;I)Landroid/view/MenuItem;
    //   498: pop
    //   499: aload 12
    //   501: bipush 21
    //   503: invokestatic 232	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:a	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
    //   506: ifeq +40 -> 546
    //   509: aload_0
    //   510: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   513: iconst_1
    //   514: invokevirtual 214	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:CH	(I)Z
    //   517: ifeq +29 -> 546
    //   520: aload_1
    //   521: iconst_1
    //   522: aload_0
    //   523: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   526: getstatic 235	com/tencent/mm/R$l:readerapp_alert_retransmit	I
    //   529: invokevirtual 123	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
    //   532: getstatic 238	com/tencent/mm/R$k:bottomsheet_icon_transmit	I
    //   535: aload 12
    //   537: bipush 21
    //   539: invokestatic 241	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:b	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
    //   542: invokevirtual 244	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;IZ)Landroid/view/MenuItem;
    //   545: pop
    //   546: aload 12
    //   548: bipush 23
    //   550: invokestatic 232	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:a	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
    //   553: ifeq +40 -> 593
    //   556: aload_0
    //   557: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   560: iconst_2
    //   561: invokevirtual 214	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:CH	(I)Z
    //   564: ifeq +29 -> 593
    //   567: aload_1
    //   568: iconst_2
    //   569: aload_0
    //   570: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   573: getstatic 247	com/tencent/mm/R$l:readerapp_alert_share_to_timeline	I
    //   576: invokevirtual 123	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
    //   579: getstatic 250	com/tencent/mm/R$k:bottomsheet_icon_moment	I
    //   582: aload 12
    //   584: bipush 23
    //   586: invokestatic 241	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:b	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
    //   589: invokevirtual 244	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;IZ)Landroid/view/MenuItem;
    //   592: pop
    //   593: aload_0
    //   594: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   597: invokestatic 253	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:al	(Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;)Z
    //   600: ifeq +49 -> 649
    //   603: aload_0
    //   604: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   607: invokestatic 257	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:am	(Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;)Ljava/lang/String;
    //   610: invokestatic 261	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   613: ifne +95 -> 708
    //   616: aload_0
    //   617: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   620: invokestatic 264	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:an	(Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;)Ljava/lang/String;
    //   623: invokestatic 261	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   626: ifne +82 -> 708
    //   629: aload_0
    //   630: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   633: invokestatic 257	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:am	(Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;)Ljava/lang/String;
    //   636: aload_0
    //   637: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   640: invokestatic 264	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:an	(Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;)Ljava/lang/String;
    //   643: invokevirtual 267	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   646: ifne +62 -> 708
    //   649: aload 12
    //   651: sipush 323
    //   654: invokestatic 232	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:a	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
    //   657: ifeq +51 -> 708
    //   660: aload_0
    //   661: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   664: invokestatic 270	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:ao	(Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;)Z
    //   667: ifeq +41 -> 708
    //   670: aload_0
    //   671: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   674: iconst_3
    //   675: invokevirtual 214	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:CH	(I)Z
    //   678: ifeq +30 -> 708
    //   681: aload_1
    //   682: iconst_3
    //   683: aload_0
    //   684: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   687: getstatic 273	com/tencent/mm/R$l:plugin_favorite_opt	I
    //   690: invokevirtual 123	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
    //   693: getstatic 276	com/tencent/mm/R$k:bottomsheet_icon_fav	I
    //   696: aload 12
    //   698: sipush 323
    //   701: invokestatic 241	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:b	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
    //   704: invokevirtual 244	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;IZ)Landroid/view/MenuItem;
    //   707: pop
    //   708: aload_0
    //   709: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   712: invokevirtual 280	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   715: ldc_w 282
    //   718: invokevirtual 287	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   721: astore 10
    //   723: aload_0
    //   724: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   727: invokevirtual 280	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   730: ldc_w 289
    //   733: ldc2_w 290
    //   736: invokevirtual 295	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   739: lstore 4
    //   741: aload_0
    //   742: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   745: getfield 299	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:gGn	Lcom/tencent/mm/plugin/webview/stub/d;
    //   748: lload 4
    //   750: aload 10
    //   752: invokeinterface 305 4 0
    //   757: ifeq +23 -> 780
    //   760: aload_1
    //   761: bipush 23
    //   763: aload_0
    //   764: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   767: getstatic 308	com/tencent/mm/R$l:download_other_open	I
    //   770: invokevirtual 123	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
    //   773: getstatic 311	com/tencent/mm/R$k:bottomsheet_icon_other_mode	I
    //   776: invokevirtual 131	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;I)Landroid/view/MenuItem;
    //   779: pop
    //   780: aload_1
    //   781: bipush 31
    //   783: aload_0
    //   784: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   787: getstatic 314	com/tencent/mm/R$l:wv_search_content	I
    //   790: invokevirtual 123	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
    //   793: getstatic 317	com/tencent/mm/R$k:bottomsheet_icon_search	I
    //   796: invokevirtual 131	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;I)Landroid/view/MenuItem;
    //   799: pop
    //   800: aload 12
    //   802: bipush 44
    //   804: invokestatic 232	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:a	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
    //   807: ifeq +42 -> 849
    //   810: aload_0
    //   811: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   814: bipush 6
    //   816: invokevirtual 214	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:CH	(I)Z
    //   819: ifeq +30 -> 849
    //   822: aload_1
    //   823: bipush 6
    //   825: aload_0
    //   826: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   829: getstatic 320	com/tencent/mm/R$l:wv_alert_copy_link	I
    //   832: invokevirtual 123	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
    //   835: getstatic 323	com/tencent/mm/R$k:bottomsheet_icon_copy	I
    //   838: aload 12
    //   840: bipush 44
    //   842: invokestatic 241	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:b	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
    //   845: invokevirtual 244	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;IZ)Landroid/view/MenuItem;
    //   848: pop
    //   849: aload 12
    //   851: getfield 329	com/tencent/mm/protocal/JsapiPermissionWrapper:spq	[B
    //   854: ifnull +150 -> 1004
    //   857: aload_0
    //   858: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   861: invokestatic 253	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:al	(Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;)Z
    //   864: ifeq +140 -> 1004
    //   867: aload_0
    //   868: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   871: invokestatic 257	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:am	(Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;)Ljava/lang/String;
    //   874: invokestatic 261	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   877: ifne +127 -> 1004
    //   880: aload_0
    //   881: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   884: invokestatic 264	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:an	(Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;)Ljava/lang/String;
    //   887: invokestatic 261	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   890: ifne +114 -> 1004
    //   893: aload_0
    //   894: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   897: invokestatic 257	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:am	(Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;)Ljava/lang/String;
    //   900: aload_0
    //   901: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   904: invokestatic 264	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:an	(Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;)Ljava/lang/String;
    //   907: invokevirtual 267	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   910: ifeq +94 -> 1004
    //   913: aload_0
    //   914: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   917: invokevirtual 280	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   920: ldc_w 331
    //   923: iconst_1
    //   924: invokevirtual 335	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   927: ifeq +77 -> 1004
    //   930: aload_0
    //   931: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   934: invokestatic 270	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:ao	(Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;)Z
    //   937: ifeq +67 -> 1004
    //   940: aload_0
    //   941: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   944: bipush 12
    //   946: invokevirtual 214	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:CH	(I)Z
    //   949: ifeq +23 -> 972
    //   952: aload_1
    //   953: bipush 12
    //   955: aload_0
    //   956: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   959: getstatic 338	com/tencent/mm/R$l:favorite_add_tag_tips	I
    //   962: invokevirtual 123	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
    //   965: getstatic 341	com/tencent/mm/R$k:bottomsheet_icon_addtag	I
    //   968: invokevirtual 131	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;I)Landroid/view/MenuItem;
    //   971: pop
    //   972: aload_0
    //   973: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   976: bipush 9
    //   978: invokevirtual 214	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:CH	(I)Z
    //   981: ifeq +23 -> 1004
    //   984: aload_1
    //   985: bipush 9
    //   987: aload_0
    //   988: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   991: getstatic 344	com/tencent/mm/R$l:app_delete	I
    //   994: invokevirtual 123	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
    //   997: getstatic 347	com/tencent/mm/R$k:bottomsheet_icon_del	I
    //   1000: invokevirtual 131	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;I)Landroid/view/MenuItem;
    //   1003: pop
    //   1004: aload_0
    //   1005: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   1008: invokevirtual 280	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   1011: ldc_w 349
    //   1014: invokevirtual 287	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1017: astore 10
    //   1019: aload 10
    //   1021: invokestatic 261	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   1024: ifne +38 -> 1062
    //   1027: aload_0
    //   1028: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   1031: getfield 299	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:gGn	Lcom/tencent/mm/plugin/webview/stub/d;
    //   1034: aload 10
    //   1036: invokeinterface 352 2 0
    //   1041: istore 6
    //   1043: iload 6
    //   1045: ifne +1307 -> 2352
    //   1048: aload_0
    //   1049: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   1052: getfield 299	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:gGn	Lcom/tencent/mm/plugin/webview/stub/d;
    //   1055: aload 10
    //   1057: invokeinterface 355 2 0
    //   1062: aload 12
    //   1064: sipush 313
    //   1067: invokestatic 232	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:a	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
    //   1070: ifeq +43 -> 1113
    //   1073: aload_0
    //   1074: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   1077: bipush 34
    //   1079: invokevirtual 214	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:CH	(I)Z
    //   1082: ifeq +31 -> 1113
    //   1085: aload_1
    //   1086: bipush 34
    //   1088: aload_0
    //   1089: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   1092: getstatic 358	com/tencent/mm/R$l:wv_read_article	I
    //   1095: invokevirtual 123	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
    //   1098: getstatic 361	com/tencent/mm/R$k:bottomsheet_icon_reading	I
    //   1101: aload 12
    //   1103: sipush 313
    //   1106: invokestatic 241	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:b	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
    //   1109: invokevirtual 244	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;IZ)Landroid/view/MenuItem;
    //   1112: pop
    //   1113: aload 12
    //   1115: bipush 45
    //   1117: invokestatic 232	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:a	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
    //   1120: ifeq +42 -> 1162
    //   1123: aload_0
    //   1124: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   1127: bipush 7
    //   1129: invokevirtual 214	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:CH	(I)Z
    //   1132: ifeq +30 -> 1162
    //   1135: aload_1
    //   1136: bipush 7
    //   1138: aload_0
    //   1139: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   1142: getstatic 364	com/tencent/mm/R$l:wv_alert_open_in_browser	I
    //   1145: invokevirtual 123	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
    //   1148: getstatic 367	com/tencent/mm/R$k:bottomsheet_icon_brower	I
    //   1151: aload 12
    //   1153: bipush 45
    //   1155: invokestatic 241	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:b	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
    //   1158: invokevirtual 244	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;IZ)Landroid/view/MenuItem;
    //   1161: pop
    //   1162: aload 12
    //   1164: bipush 43
    //   1166: invokestatic 232	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:a	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
    //   1169: ifeq +119 -> 1288
    //   1172: aload_0
    //   1173: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   1176: bipush 24
    //   1178: invokevirtual 214	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:CH	(I)Z
    //   1181: ifeq +107 -> 1288
    //   1184: aload_0
    //   1185: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   1188: getfield 373	com/tencent/mm/ui/MMActivity:mController	Lcom/tencent/mm/ui/s;
    //   1191: getfield 379	com/tencent/mm/ui/s:uMN	Landroid/support/v7/app/AppCompatActivity;
    //   1194: ldc_w 381
    //   1197: invokestatic 387	com/tencent/mm/pluginsdk/model/app/p:o	(Landroid/content/Context;Ljava/lang/String;)Z
    //   1200: ifne +88 -> 1288
    //   1203: new 389	android/os/Bundle
    //   1206: dup
    //   1207: invokespecial 390	android/os/Bundle:<init>	()V
    //   1210: astore 10
    //   1212: aload 10
    //   1214: ldc_w 392
    //   1217: ldc_w 394
    //   1220: invokevirtual 397	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1223: aload_0
    //   1224: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   1227: getfield 299	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:gGn	Lcom/tencent/mm/plugin/webview/stub/d;
    //   1230: bipush 71
    //   1232: aload 10
    //   1234: invokeinterface 401 3 0
    //   1239: astore 10
    //   1241: aload 10
    //   1243: ifnull +1308 -> 2551
    //   1246: aload 10
    //   1248: ldc_w 394
    //   1251: invokevirtual 404	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   1254: istore 6
    //   1256: iload 6
    //   1258: ifeq +30 -> 1288
    //   1261: aload_1
    //   1262: bipush 24
    //   1264: aload_0
    //   1265: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   1268: getstatic 407	com/tencent/mm/R$l:readerapp_send_to_enterprise	I
    //   1271: invokevirtual 123	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
    //   1274: getstatic 410	com/tencent/mm/R$k:bottomsheet_icon_enterprise	I
    //   1277: aload 12
    //   1279: bipush 43
    //   1281: invokestatic 241	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:b	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
    //   1284: invokevirtual 244	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;IZ)Landroid/view/MenuItem;
    //   1287: pop
    //   1288: aload 12
    //   1290: bipush 18
    //   1292: invokestatic 232	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:a	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
    //   1295: ifeq +42 -> 1337
    //   1298: aload_0
    //   1299: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   1302: bipush 11
    //   1304: invokevirtual 214	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:CH	(I)Z
    //   1307: ifeq +30 -> 1337
    //   1310: aload_1
    //   1311: bipush 11
    //   1313: aload_0
    //   1314: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   1317: getstatic 413	com/tencent/mm/R$l:readerapp_alert_font	I
    //   1320: invokevirtual 123	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
    //   1323: getstatic 416	com/tencent/mm/R$k:bottomsheet_icon_font	I
    //   1326: aload 12
    //   1328: bipush 18
    //   1330: invokestatic 241	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:b	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
    //   1333: invokevirtual 244	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;IZ)Landroid/view/MenuItem;
    //   1336: pop
    //   1337: aload_0
    //   1338: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   1341: bipush 28
    //   1343: invokevirtual 214	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:CH	(I)Z
    //   1346: ifeq +23 -> 1369
    //   1349: aload_1
    //   1350: bipush 28
    //   1352: aload_0
    //   1353: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   1356: getstatic 419	com/tencent/mm/R$l:webview_bottomsheet_refresh	I
    //   1359: invokevirtual 123	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
    //   1362: getstatic 422	com/tencent/mm/R$k:bottomsheet_icon_refresh	I
    //   1365: invokevirtual 131	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;I)Landroid/view/MenuItem;
    //   1368: pop
    //   1369: aload 12
    //   1371: bipush 73
    //   1373: invokestatic 232	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:a	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
    //   1376: ifeq +52 -> 1428
    //   1379: aload_0
    //   1380: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   1383: bipush 14
    //   1385: invokevirtual 214	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:CH	(I)Z
    //   1388: ifeq +40 -> 1428
    //   1391: aload_0
    //   1392: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   1395: invokestatic 425	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:X	(Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;)Z
    //   1398: ifne +30 -> 1428
    //   1401: aload_1
    //   1402: bipush 14
    //   1404: aload_0
    //   1405: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   1408: getstatic 428	com/tencent/mm/R$l:wv_reading_mode	I
    //   1411: invokevirtual 123	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
    //   1414: getstatic 431	com/tencent/mm/R$k:bottomsheet_icon_reader	I
    //   1417: aload 12
    //   1419: bipush 73
    //   1421: invokestatic 241	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:b	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
    //   1424: invokevirtual 244	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;IZ)Landroid/view/MenuItem;
    //   1427: pop
    //   1428: aload_0
    //   1429: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   1432: invokestatic 425	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:X	(Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;)Z
    //   1435: ifeq +35 -> 1470
    //   1438: aload_0
    //   1439: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   1442: bipush 14
    //   1444: invokevirtual 214	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:CH	(I)Z
    //   1447: ifeq +23 -> 1470
    //   1450: aload_1
    //   1451: bipush 14
    //   1453: aload_0
    //   1454: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   1457: getstatic 434	com/tencent/mm/R$l:wv_original_mode	I
    //   1460: invokevirtual 123	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
    //   1463: getstatic 311	com/tencent/mm/R$k:bottomsheet_icon_other_mode	I
    //   1466: invokevirtual 131	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;I)Landroid/view/MenuItem;
    //   1469: pop
    //   1470: aload 12
    //   1472: bipush 47
    //   1474: invokestatic 232	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:a	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
    //   1477: ifeq +42 -> 1519
    //   1480: aload_0
    //   1481: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   1484: bipush 10
    //   1486: invokevirtual 214	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:CH	(I)Z
    //   1489: ifeq +30 -> 1519
    //   1492: aload_1
    //   1493: bipush 10
    //   1495: aload_0
    //   1496: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   1499: getstatic 437	com/tencent/mm/R$l:biz_report_text	I
    //   1502: invokevirtual 123	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
    //   1505: getstatic 440	com/tencent/mm/R$k:bottomsheet_icon_complain	I
    //   1508: aload 12
    //   1510: bipush 47
    //   1512: invokestatic 241	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:b	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
    //   1515: invokevirtual 244	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;IZ)Landroid/view/MenuItem;
    //   1518: pop
    //   1519: aload 12
    //   1521: bipush 36
    //   1523: invokestatic 232	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:a	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
    //   1526: ifeq +71 -> 1597
    //   1529: aload_0
    //   1530: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   1533: bipush 8
    //   1535: invokevirtual 214	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:CH	(I)Z
    //   1538: ifeq +59 -> 1597
    //   1541: aconst_null
    //   1542: astore 10
    //   1544: aload_0
    //   1545: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   1548: getfield 299	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:gGn	Lcom/tencent/mm/plugin/webview/stub/d;
    //   1551: invokeinterface 443 1 0
    //   1556: astore 11
    //   1558: aload 11
    //   1560: astore 10
    //   1562: aload 10
    //   1564: invokestatic 261	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   1567: ifne +990 -> 2557
    //   1570: aload_1
    //   1571: bipush 8
    //   1573: aload_0
    //   1574: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   1577: getstatic 446	com/tencent/mm/R$l:wv_alert_send_mail	I
    //   1580: invokevirtual 123	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
    //   1583: getstatic 449	com/tencent/mm/R$k:bottomsheet_icon_mail	I
    //   1586: aload 12
    //   1588: bipush 36
    //   1590: invokestatic 241	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:b	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
    //   1593: invokevirtual 244	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;IZ)Landroid/view/MenuItem;
    //   1596: pop
    //   1597: aload 12
    //   1599: bipush 31
    //   1601: invokestatic 232	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:a	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
    //   1604: ifeq +67 -> 1671
    //   1607: aload_0
    //   1608: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   1611: bipush 30
    //   1613: invokevirtual 214	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:CH	(I)Z
    //   1616: ifeq +55 -> 1671
    //   1619: aload_0
    //   1620: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   1623: getfield 299	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:gGn	Lcom/tencent/mm/plugin/webview/stub/d;
    //   1626: bipush 78
    //   1628: aconst_null
    //   1629: invokeinterface 401 3 0
    //   1634: ldc_w 451
    //   1637: iconst_0
    //   1638: invokevirtual 453	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   1641: ifeq +30 -> 1671
    //   1644: aload_1
    //   1645: bipush 33
    //   1647: aload_0
    //   1648: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   1651: getstatic 456	com/tencent/mm/R$l:wv_share_to_facebook	I
    //   1654: invokevirtual 123	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
    //   1657: getstatic 459	com/tencent/mm/R$k:default_facebookapp	I
    //   1660: aload 12
    //   1662: bipush 31
    //   1664: invokestatic 241	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:b	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
    //   1667: invokevirtual 244	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;IZ)Landroid/view/MenuItem;
    //   1670: pop
    //   1671: aload 12
    //   1673: sipush 322
    //   1676: invokestatic 232	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:a	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
    //   1679: ifeq +81 -> 1760
    //   1682: aload_0
    //   1683: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   1686: invokestatic 465	com/tencent/wework/api/WWAPIFactory:ik	(Landroid/content/Context;)Lcom/tencent/wework/api/IWWAPI;
    //   1689: invokeinterface 470 1 0
    //   1694: ifeq +66 -> 1760
    //   1697: aload_0
    //   1698: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   1701: bipush 25
    //   1703: invokevirtual 214	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:CH	(I)Z
    //   1706: ifeq +54 -> 1760
    //   1709: aload_0
    //   1710: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   1713: invokestatic 465	com/tencent/wework/api/WWAPIFactory:ik	(Landroid/content/Context;)Lcom/tencent/wework/api/IWWAPI;
    //   1716: invokeinterface 473 1 0
    //   1721: astore 10
    //   1723: aload_1
    //   1724: bipush 25
    //   1726: aload_0
    //   1727: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   1730: getstatic 476	com/tencent/mm/R$l:readerapp_send_to_wework	I
    //   1733: iconst_1
    //   1734: anewarray 4	java/lang/Object
    //   1737: dup
    //   1738: iconst_0
    //   1739: aload 10
    //   1741: aastore
    //   1742: invokevirtual 479	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   1745: getstatic 482	com/tencent/mm/R$k:bottomsheet_icon_wework	I
    //   1748: aload 12
    //   1750: sipush 322
    //   1753: invokestatic 241	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:b	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
    //   1756: invokevirtual 244	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;IZ)Landroid/view/MenuItem;
    //   1759: pop
    //   1760: aload 12
    //   1762: sipush 278
    //   1765: invokestatic 232	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:a	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
    //   1768: ifeq +63 -> 1831
    //   1771: aload_0
    //   1772: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   1775: aload_0
    //   1776: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   1779: getfield 486	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:niQ	Lcom/tencent/mm/ui/widget/MMWebView;
    //   1782: invokevirtual 491	com/tencent/mm/ui/widget/MMWebView:getUrl	()Ljava/lang/String;
    //   1785: invokestatic 496	com/tencent/mm/plugin/webview/stub/a:aY	(Landroid/content/Context;Ljava/lang/String;)Z
    //   1788: ifeq +43 -> 1831
    //   1791: aload_0
    //   1792: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   1795: bipush 26
    //   1797: invokevirtual 214	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:CH	(I)Z
    //   1800: ifeq +31 -> 1831
    //   1803: aload_1
    //   1804: bipush 26
    //   1806: aload_0
    //   1807: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   1810: getstatic 499	com/tencent/mm/R$l:wv_send_to_we_read	I
    //   1813: invokevirtual 123	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
    //   1816: getstatic 502	com/tencent/mm/R$k:bottomsheet_icon_weread	I
    //   1819: aload 12
    //   1821: sipush 278
    //   1824: invokestatic 241	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:b	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
    //   1827: invokevirtual 244	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;IZ)Landroid/view/MenuItem;
    //   1830: pop
    //   1831: aload 12
    //   1833: bipush 91
    //   1835: invokestatic 232	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:a	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
    //   1838: ifeq +52 -> 1890
    //   1841: aload_0
    //   1842: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   1845: invokestatic 506	com/tencent/mm/plugin/webview/stub/a:ez	(Landroid/content/Context;)Z
    //   1848: ifeq +42 -> 1890
    //   1851: aload_0
    //   1852: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   1855: bipush 20
    //   1857: invokevirtual 214	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:CH	(I)Z
    //   1860: ifeq +30 -> 1890
    //   1863: aload_1
    //   1864: bipush 20
    //   1866: aload_0
    //   1867: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   1870: getstatic 509	com/tencent/mm/R$l:wv_share_to_qq	I
    //   1873: invokevirtual 123	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
    //   1876: getstatic 512	com/tencent/mm/R$k:bottomsheet_icon_qq	I
    //   1879: aload 12
    //   1881: bipush 91
    //   1883: invokestatic 241	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:b	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
    //   1886: invokevirtual 244	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;IZ)Landroid/view/MenuItem;
    //   1889: pop
    //   1890: aload 12
    //   1892: sipush 133
    //   1895: invokestatic 232	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:a	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
    //   1898: ifeq +53 -> 1951
    //   1901: aload_0
    //   1902: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   1905: invokestatic 506	com/tencent/mm/plugin/webview/stub/a:ez	(Landroid/content/Context;)Z
    //   1908: ifeq +43 -> 1951
    //   1911: aload_0
    //   1912: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   1915: bipush 22
    //   1917: invokevirtual 214	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:CH	(I)Z
    //   1920: ifeq +31 -> 1951
    //   1923: aload_1
    //   1924: bipush 22
    //   1926: aload_0
    //   1927: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   1930: getstatic 515	com/tencent/mm/R$l:wv_share_to_qzone	I
    //   1933: invokevirtual 123	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
    //   1936: getstatic 518	com/tencent/mm/R$k:bottomsheet_icon_qzone	I
    //   1939: aload 12
    //   1941: sipush 133
    //   1944: invokestatic 241	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:b	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
    //   1947: invokevirtual 244	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;IZ)Landroid/view/MenuItem;
    //   1950: pop
    //   1951: aload 12
    //   1953: bipush 43
    //   1955: invokestatic 232	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:a	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
    //   1958: ifeq +108 -> 2066
    //   1961: aload_0
    //   1962: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   1965: iconst_0
    //   1966: invokevirtual 214	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:CH	(I)Z
    //   1969: ifeq +97 -> 2066
    //   1972: aload_0
    //   1973: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   1976: getfield 299	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:gGn	Lcom/tencent/mm/plugin/webview/stub/d;
    //   1979: invokeinterface 521 1 0
    //   1984: ifeq +82 -> 2066
    //   1987: aload_0
    //   1988: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   1991: getfield 299	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:gGn	Lcom/tencent/mm/plugin/webview/stub/d;
    //   1994: invokeinterface 525 1 0
    //   1999: astore 10
    //   2001: aload 10
    //   2003: invokeinterface 531 1 0
    //   2008: astore 11
    //   2010: aload 11
    //   2012: invokeinterface 536 1 0
    //   2017: ifeq +570 -> 2587
    //   2020: aload_1
    //   2021: aload 11
    //   2023: invokeinterface 540 1 0
    //   2028: checkcast 110	java/lang/String
    //   2031: invokevirtual 544	com/tencent/mm/ui/base/l:add	(Ljava/lang/CharSequence;)Landroid/view/MenuItem;
    //   2034: pop
    //   2035: goto -25 -> 2010
    //   2038: astore 10
    //   2040: ldc 171
    //   2042: new 173	java/lang/StringBuilder
    //   2045: dup
    //   2046: ldc_w 546
    //   2049: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2052: aload 10
    //   2054: invokevirtual 182	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2057: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2060: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2063: invokestatic 549	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   2066: aload_0
    //   2067: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   2070: getfield 553	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:rnz	Lcom/tencent/mm/plugin/webview/ui/tools/widget/MovingImageButton;
    //   2073: ifnull +36 -> 2109
    //   2076: aload_0
    //   2077: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   2080: getfield 553	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:rnz	Lcom/tencent/mm/plugin/webview/ui/tools/widget/MovingImageButton;
    //   2083: invokevirtual 558	com/tencent/mm/plugin/webview/ui/tools/widget/MovingImageButton:getVisibility	()I
    //   2086: ifne +23 -> 2109
    //   2089: aload_1
    //   2090: bipush 27
    //   2092: aload_0
    //   2093: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   2096: getstatic 561	com/tencent/mm/R$l:readerapp_finish_webview	I
    //   2099: invokevirtual 123	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
    //   2102: getstatic 564	com/tencent/mm/R$k:bottomsheet_icon_exit	I
    //   2105: invokevirtual 131	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;I)Landroid/view/MenuItem;
    //   2108: pop
    //   2109: aload_0
    //   2110: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   2113: aload_0
    //   2114: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   2117: invokestatic 257	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:am	(Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;)Ljava/lang/String;
    //   2120: invokevirtual 567	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Tr	(Ljava/lang/String;)Ljava/lang/String;
    //   2123: astore 10
    //   2125: aload_0
    //   2126: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   2129: invokevirtual 280	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   2132: ldc_w 569
    //   2135: invokevirtual 287	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   2138: astore 11
    //   2140: aload_0
    //   2141: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   2144: invokestatic 572	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:u	(Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;)Z
    //   2147: ifne -1718 -> 429
    //   2150: aload 10
    //   2152: invokestatic 261	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   2155: ifne -1726 -> 429
    //   2158: aload 11
    //   2160: invokestatic 261	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   2163: ifne -1734 -> 429
    //   2166: aload 12
    //   2168: sipush 255
    //   2171: invokestatic 232	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:a	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
    //   2174: ifeq -1745 -> 429
    //   2177: aload_0
    //   2178: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   2181: bipush 29
    //   2183: invokevirtual 214	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:CH	(I)Z
    //   2186: ifeq -1757 -> 429
    //   2189: aload_1
    //   2190: bipush 29
    //   2192: aload_0
    //   2193: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   2196: getstatic 575	com/tencent/mm/R$l:readerapp_add_shortcut	I
    //   2199: invokevirtual 123	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
    //   2202: getstatic 578	com/tencent/mm/R$k:webview_add_shortcut	I
    //   2205: aload 12
    //   2207: sipush 255
    //   2210: invokestatic 241	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:b	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
    //   2213: invokevirtual 244	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;IZ)Landroid/view/MenuItem;
    //   2216: pop
    //   2217: return
    //   2218: aload_0
    //   2219: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   2222: bipush 36
    //   2224: invokevirtual 214	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:CH	(I)Z
    //   2227: ifeq -1728 -> 499
    //   2230: aload_0
    //   2231: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   2234: getfield 218	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:rbN	Lcom/tencent/mm/plugin/webview/ui/tools/bag/h;
    //   2237: invokeinterface 223 1 0
    //   2242: ifeq -1743 -> 499
    //   2245: aload_1
    //   2246: bipush 36
    //   2248: aload_0
    //   2249: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   2252: getstatic 581	com/tencent/mm/R$l:readerapp_cancel_minimize	I
    //   2255: invokevirtual 123	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
    //   2258: getstatic 584	com/tencent/mm/R$k:bottomsheet_icon_webview_cancel_minimize	I
    //   2261: invokevirtual 131	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;I)Landroid/view/MenuItem;
    //   2264: pop
    //   2265: goto -1766 -> 499
    //   2268: astore 10
    //   2270: ldc 171
    //   2272: aload 10
    //   2274: ldc_w 586
    //   2277: iconst_0
    //   2278: anewarray 4	java/lang/Object
    //   2281: invokestatic 590	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2284: goto -1504 -> 780
    //   2287: astore 11
    //   2289: ldc 171
    //   2291: new 173	java/lang/StringBuilder
    //   2294: dup
    //   2295: ldc_w 592
    //   2298: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2301: aload 11
    //   2303: invokevirtual 182	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2306: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2309: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2312: invokestatic 194	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2315: iconst_0
    //   2316: istore 6
    //   2318: goto -1275 -> 1043
    //   2321: astore 10
    //   2323: ldc 171
    //   2325: new 173	java/lang/StringBuilder
    //   2328: dup
    //   2329: ldc_w 594
    //   2332: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2335: aload 10
    //   2337: invokevirtual 182	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2340: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2343: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2346: invokestatic 194	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2349: goto -1287 -> 1062
    //   2352: aload_0
    //   2353: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   2356: getfield 299	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:gGn	Lcom/tencent/mm/plugin/webview/stub/d;
    //   2359: aload 10
    //   2361: invokeinterface 597 2 0
    //   2366: istore 6
    //   2368: iload 6
    //   2370: ifeq +125 -> 2495
    //   2373: aload 12
    //   2375: bipush 19
    //   2377: invokestatic 232	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:a	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
    //   2380: istore 8
    //   2382: aload 12
    //   2384: bipush 19
    //   2386: invokestatic 241	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:b	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
    //   2389: istore 7
    //   2391: aload_0
    //   2392: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   2395: invokevirtual 600	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:cel	()Z
    //   2398: istore 9
    //   2400: iload 8
    //   2402: ifeq +14 -> 2416
    //   2405: aload_0
    //   2406: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   2409: iconst_5
    //   2410: invokevirtual 214	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:CH	(I)Z
    //   2413: ifne +8 -> 2421
    //   2416: iload 9
    //   2418: ifeq -1356 -> 1062
    //   2421: iload 6
    //   2423: ifeq +93 -> 2516
    //   2426: getstatic 603	com/tencent/mm/R$l:wv_alert_show_biz_info	I
    //   2429: istore_2
    //   2430: iload 9
    //   2432: ifeq +7 -> 2439
    //   2435: getstatic 606	com/tencent/mm/R$l:wv_alert_show_subbiz_info	I
    //   2438: istore_2
    //   2439: aload_1
    //   2440: iconst_5
    //   2441: aload_0
    //   2442: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   2445: iload_2
    //   2446: invokevirtual 123	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
    //   2449: getstatic 609	com/tencent/mm/R$k:bottomsheet_icon_brand_profile	I
    //   2452: iload 7
    //   2454: invokevirtual 244	com/tencent/mm/ui/base/l:a	(ILjava/lang/CharSequence;IZ)Landroid/view/MenuItem;
    //   2457: pop
    //   2458: goto -1396 -> 1062
    //   2461: astore 10
    //   2463: ldc 171
    //   2465: new 173	java/lang/StringBuilder
    //   2468: dup
    //   2469: ldc_w 611
    //   2472: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2475: aload 10
    //   2477: invokevirtual 182	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2480: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2483: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2486: invokestatic 194	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2489: iconst_0
    //   2490: istore 6
    //   2492: goto -124 -> 2368
    //   2495: aload 12
    //   2497: bipush 20
    //   2499: invokestatic 232	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:a	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
    //   2502: istore 8
    //   2504: aload 12
    //   2506: bipush 20
    //   2508: invokestatic 241	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:b	(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;I)Z
    //   2511: istore 7
    //   2513: goto -122 -> 2391
    //   2516: getstatic 614	com/tencent/mm/R$l:wv_alert_follow_biz	I
    //   2519: istore_2
    //   2520: goto -90 -> 2430
    //   2523: astore 10
    //   2525: ldc 171
    //   2527: new 173	java/lang/StringBuilder
    //   2530: dup
    //   2531: ldc_w 546
    //   2534: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2537: aload 10
    //   2539: invokevirtual 182	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2542: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2545: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2548: invokestatic 549	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   2551: iconst_0
    //   2552: istore 6
    //   2554: goto -1298 -> 1256
    //   2557: ldc 171
    //   2559: ldc_w 616
    //   2562: invokestatic 619	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2565: goto -968 -> 1597
    //   2568: astore 10
    //   2570: ldc 171
    //   2572: aload 10
    //   2574: ldc_w 586
    //   2577: iconst_0
    //   2578: anewarray 4	java/lang/Object
    //   2581: invokestatic 590	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2584: goto -913 -> 1671
    //   2587: aload_0
    //   2588: getfield 21	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38:rpH	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   2591: aload 10
    //   2593: invokestatic 622	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:a	(Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;Ljava/util/List;)V
    //   2596: goto -530 -> 2066
    //   2599: astore 11
    //   2601: goto -1039 -> 1562
    //   2604: iload_2
    //   2605: iconst_1
    //   2606: iadd
    //   2607: istore_2
    //   2608: goto -2495 -> 113
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2611	0	this	38
    //   0	2611	1	paraml	com.tencent.mm.ui.base.l
    //   31	2577	2	i	int
    //   29	6	3	j	int
    //   739	10	4	l	long
    //   1041	1512	6	bool1	boolean
    //   2389	123	7	bool2	boolean
    //   2380	123	8	bool3	boolean
    //   2398	33	9	bool4	boolean
    //   48	320	10	localObject1	Object
    //   372	14	10	localException1	java.lang.Exception
    //   721	1281	10	localObject2	Object
    //   2038	15	10	localException2	java.lang.Exception
    //   2123	28	10	str	java.lang.String
    //   2268	5	10	localException3	java.lang.Exception
    //   2321	39	10	localException4	java.lang.Exception
    //   2461	15	10	localException5	java.lang.Exception
    //   2523	15	10	localException6	java.lang.Exception
    //   2568	24	10	localException7	java.lang.Exception
    //   67	2092	11	localObject3	Object
    //   2287	15	11	localException8	java.lang.Exception
    //   2599	1	11	localException9	java.lang.Exception
    //   137	2368	12	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   97	106	372	java/lang/Exception
    //   113	122	372	java/lang/Exception
    //   128	139	372	java/lang/Exception
    //   142	182	372	java/lang/Exception
    //   187	197	372	java/lang/Exception
    //   200	240	372	java/lang/Exception
    //   243	283	372	java/lang/Exception
    //   286	326	372	java/lang/Exception
    //   329	369	372	java/lang/Exception
    //   1951	2010	2038	java/lang/Exception
    //   2010	2035	2038	java/lang/Exception
    //   2587	2596	2038	java/lang/Exception
    //   741	780	2268	java/lang/Exception
    //   1027	1043	2287	java/lang/Exception
    //   1048	1062	2321	java/lang/Exception
    //   2352	2368	2461	java/lang/Exception
    //   1203	1241	2523	java/lang/Exception
    //   1246	1256	2523	java/lang/Exception
    //   1619	1671	2568	java/lang/Exception
    //   1544	1558	2599	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.38
 * JD-Core Version:    0.7.0.1
 */