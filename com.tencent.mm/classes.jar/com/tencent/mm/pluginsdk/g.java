package com.tencent.mm.pluginsdk;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Pair;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.br.c;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsimple.ad;
import com.tencent.mm.modelsimple.n;
import com.tencent.mm.plugin.appbrand.launching.b.a.a;
import com.tencent.mm.plugin.appbrand.launching.b.a.a.a;
import com.tencent.mm.plugin.biz.b.f;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.ez;
import com.tencent.mm.protocal.protobuf.fqi;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo;
import com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo.WhichApp;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class g
{
  public static final String XNE;
  private static boolean XNF;
  public static final String XNG;
  public static final String XNH;
  public static String XNI;
  private static final Map<String, Long> XNJ;
  
  static
  {
    AppMethodBeat.i(124372);
    XNE = "https://" + WeChatHosts.domainString(b.f.host_support_weixin_qq_com) + "/deeplink/noaccess#wechat_redirect";
    XNF = false;
    XNG = "https://" + WeChatHosts.domainString(b.f.host_support_weixin_qq_com) + "/security";
    XNH = "https://" + WeChatHosts.domainString(b.f.host_support_wechat_com) + "/security";
    XNI = "";
    HashMap localHashMap = new HashMap();
    XNJ = localHashMap;
    localHashMap.put("weixin://", Long.valueOf(0L));
    XNJ.put("weixin://dl/stickers", Long.valueOf(1L));
    XNJ.put("weixin://dl/games", Long.valueOf(2L));
    XNJ.put("weixin://dl/moments", Long.valueOf(4L));
    XNJ.put("weixin://dl/add", Long.valueOf(8L));
    XNJ.put("weixin://dl/shopping", Long.valueOf(16L));
    XNJ.put("weixin://dl/groupchat", Long.valueOf(32L));
    XNJ.put("weixin://dl/scan", Long.valueOf(64L));
    XNJ.put("weixin://dl/profile", Long.valueOf(128L));
    XNJ.put("weixin://dl/settings", Long.valueOf(256L));
    XNJ.put("weixin://dl/general", Long.valueOf(512L));
    XNJ.put("weixin://dl/help", Long.valueOf(1024L));
    XNJ.put("weixin://dl/notifications", Long.valueOf(2048L));
    XNJ.put("weixin://dl/terms", Long.valueOf(4096L));
    XNJ.put("weixin://dl/chat", Long.valueOf(8192L));
    XNJ.put("weixin://dl/features", Long.valueOf(16384L));
    XNJ.put("weixin://dl/clear", Long.valueOf(32768L));
    XNJ.put("weixin://dl/feedback", Long.valueOf(65536L));
    XNJ.put("weixin://dl/faq", Long.valueOf(131072L));
    XNJ.put("weixin://dl/recommendation", Long.valueOf(262144L));
    XNJ.put("weixin://dl/groups", Long.valueOf(524288L));
    XNJ.put("weixin://dl/tags", Long.valueOf(1048576L));
    XNJ.put("weixin://dl/officialaccounts", Long.valueOf(2097152L));
    XNJ.put("weixin://dl/posts", Long.valueOf(4194304L));
    XNJ.put("weixin://dl/favorites", Long.valueOf(8388608L));
    XNJ.put("weixin://dl/privacy", Long.valueOf(16777216L));
    XNJ.put("weixin://dl/security", Long.valueOf(33554432L));
    XNJ.put("weixin://dl/wallet", Long.valueOf(67108864L));
    XNJ.put("weixin://dl/businessPay", Long.valueOf(134217728L));
    XNJ.put("weixin://dl/businessPay/", Long.valueOf(134217728L));
    XNJ.put("weixin://dl/wechatout", Long.valueOf(268435456L));
    XNJ.put("weixin://dl/protection", Long.valueOf(1073741824L));
    XNJ.put("weixin://dl/card", Long.valueOf(2147483648L));
    XNJ.put("weixin://dl/about", Long.valueOf(1125899906842624L));
    XNJ.put("weixin://dl/blacklist", Long.valueOf(4294967296L));
    XNJ.put("weixin://dl/textsize", Long.valueOf(8589934592L));
    XNJ.put("weixin://dl/sight", Long.valueOf(17179869184L));
    XNJ.put("weixin://dl/languages", Long.valueOf(34359738368L));
    XNJ.put("weixin://dl/chathistory", Long.valueOf(68719476736L));
    XNJ.put("weixin://dl/bindqq", Long.valueOf(137438953472L));
    XNJ.put("weixin://dl/bindmobile", Long.valueOf(274877906944L));
    XNJ.put("weixin://dl/bindemail", Long.valueOf(549755813888L));
    XNJ.put("weixin://dl/securityassistant", Long.valueOf(1099511627776L));
    XNJ.put("weixin://dl/broadcastmessage", Long.valueOf(2199023255552L));
    XNJ.put("weixin://dl/setname", Long.valueOf(4398046511104L));
    XNJ.put("weixin://dl/myQRcode", Long.valueOf(8796093022208L));
    XNJ.put("weixin://dl/myaddress", Long.valueOf(17592186044416L));
    XNJ.put("weixin://dl/hidemoments", Long.valueOf(35184372088832L));
    XNJ.put("weixin://dl/blockmoments", Long.valueOf(70368744177664L));
    XNJ.put("weixin://dl/stickersetting", Long.valueOf(140737488355328L));
    XNJ.put("weixin://dl/log", Long.valueOf(281474976710656L));
    XNJ.put("weixin://dl/wechatoutcoupon", Long.valueOf(562949953421312L));
    XNJ.put("weixin://dl/wechatoutshare", Long.valueOf(18014398509481984L));
    XNJ.put("weixin://dl/personalemoticon", Long.valueOf(4503599627370496L));
    XNJ.put("weixin://dl/designeremoji", Long.valueOf(9007199254740992L));
    XNJ.put("weixin://dl/sightdraft", Long.valueOf(576460752303423488L));
    XNJ.put("weixin://dl/jumpWxa/", Long.valueOf(576460752303423489L));
    XNJ.put("weixin://dl/offlinepay/", Long.valueOf(576460752303423490L));
    XNJ.put("weixin://dl/channels/shareVideo/", Long.valueOf(576460752303423492L));
    XNJ.put("weixin://dl/channels/profile/", Long.valueOf(576460752303423496L));
    XNJ.put("weixin://dl/channels/live/", Long.valueOf(576460752303423504L));
    XNJ.put("weixin://dl/channels/feed/", Long.valueOf(576460752303423520L));
    XNJ.put("weixin://dl/customerService/", Long.valueOf(576460752303423552L));
    XNJ.put("weixin://dl/channels/openEvent/", Long.valueOf(576460752303423744L));
    AppMethodBeat.o(124372);
  }
  
  public static void a(final Context paramContext, String paramString1, final int paramInt, final Bundle paramBundle, final g.a parama, String paramString2, String paramString3)
  {
    AppMethodBeat.i(124357);
    LinkedList localLinkedList = new LinkedList();
    ez localez = new ez();
    if ((!Util.isNullOrNil(paramString2)) && (!Util.isNullOrNil(paramString3)))
    {
      Log.i("MicroMsg.DeepLinkHelper", "package name = %s, package signature = %s", new Object[] { paramString2, paramString3 });
      localez.xlr = paramString2;
      localez.signature = paramString3;
      localLinkedList.add(localez);
    }
    if (boY(paramString1))
    {
      AppMethodBeat.o(124357);
      return;
    }
    paramString2 = new ad(paramString1, paramInt, localLinkedList);
    a(paramString1, paramBundle, paramString2);
    paramContext = new com.tencent.mm.am.h()
    {
      public final void onSceneEnd(final int paramAnonymousInt1, final int paramAnonymousInt2, final String paramAnonymousString, final p paramAnonymousp)
      {
        AppMethodBeat.i(124344);
        com.tencent.mm.kernel.h.aZW().b(1200, this);
        Log.i("MicroMsg.DeepLinkHelper", "doTicketsDeepLink: errType = %s; errCode = %s; errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        if ((paramAnonymousp instanceof ad)) {
          com.tencent.threadpool.h.ahAA.bo(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(244489);
              final fqi localfqi = ((ad)paramAnonymousp).bMA();
              final String str = ((ad)paramAnonymousp).bMz();
              g.a(g.this, g.2.this.TKo, localfqi, (ad)paramAnonymousp);
              com.tencent.threadpool.h.ahAA.bk(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(244484);
                  g.2.a(g.2.this, str, g.2.1.this.val$errType, g.2.1.this.val$errCode, g.2.1.this.val$errMsg, localfqi, g.2.1.this.XkH);
                  AppMethodBeat.o(244484);
                }
              });
              AppMethodBeat.o(244489);
            }
          });
        }
        AppMethodBeat.o(124344);
      }
    };
    com.tencent.mm.kernel.h.aZW().a(1200, paramContext);
    com.tencent.mm.kernel.h.aZW().a(paramString2, 0);
    AppMethodBeat.o(124357);
  }
  
  public static void a(Context paramContext, String paramString, int paramInt, g.a parama)
  {
    AppMethodBeat.i(124358);
    a(paramContext, paramString, paramInt, null, parama, null, null);
    AppMethodBeat.o(124358);
  }
  
  public static void a(Context paramContext, String paramString1, int paramInt, g.a parama, String paramString2, String paramString3)
  {
    AppMethodBeat.i(124356);
    a(paramContext, paramString1, paramInt, null, parama, paramString2, paramString3);
    AppMethodBeat.o(124356);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt, String paramString3, g.a parama)
  {
    AppMethodBeat.i(124355);
    if (Util.isNullOrNil(paramString1)) {
      paramString1 = paramString3;
    }
    while (boY(paramString1))
    {
      AppMethodBeat.o(124355);
      return;
    }
    paramString3 = new n(paramString1, paramString2, paramInt, 0, n.bMd(), new byte[0]);
    paramContext = new g.1(paramContext, paramInt, paramString2, paramString1, parama);
    com.tencent.mm.kernel.h.aZW().a(233, paramContext);
    com.tencent.mm.kernel.h.aZW().a(paramString3, 0);
    AppMethodBeat.o(124355);
  }
  
  private static void a(String paramString, Bundle paramBundle, ad paramad)
  {
    AppMethodBeat.i(244540);
    if ((paramString.startsWith("weixin://dl/channels/shareVideo/")) && (paramBundle != null))
    {
      paramString = paramBundle.getString("key_finder_share_video_jump_info_string", "");
      if (!Util.isNullOrNil(paramString)) {
        paramad.Pd(paramString);
      }
    }
    AppMethodBeat.o(244540);
  }
  
  public static boolean a(Context paramContext, int paramInt, byte[] paramArrayOfByte, String paramString)
  {
    AppMethodBeat.i(124361);
    boolean bool = a(paramContext, paramString, 0, paramInt, paramArrayOfByte, null);
    AppMethodBeat.o(124361);
    return bool;
  }
  
  private static boolean a(Context paramContext, String paramString1, int paramInt1, int paramInt2, byte[] paramArrayOfByte, String paramString2)
  {
    AppMethodBeat.i(124364);
    boolean bool = a(paramContext, paramString1, paramInt1, null, paramInt2, paramArrayOfByte, paramString2, 0, "", null);
    AppMethodBeat.o(124364);
    return bool;
  }
  
  /* Error */
  private static boolean a(Context paramContext, String paramString1, int paramInt1, Bundle paramBundle, int paramInt2, byte[] paramArrayOfByte, String paramString2, int paramInt3, String paramString3, g.a parama)
  {
    // Byte code:
    //   0: ldc_w 509
    //   3: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: invokestatic 512	com/tencent/mm/pluginsdk/g:boZ	(Ljava/lang/String;)Ljava/lang/String;
    //   10: astore 14
    //   12: aload 14
    //   14: invokestatic 369	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   17: ifeq +11 -> 28
    //   20: ldc_w 509
    //   23: invokestatic 353	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: iconst_0
    //   27: ireturn
    //   28: getstatic 88	com/tencent/mm/pluginsdk/g:XNJ	Ljava/util/Map;
    //   31: aload 14
    //   33: invokeinterface 515 2 0
    //   38: ifeq +5017 -> 5055
    //   41: getstatic 88	com/tencent/mm/pluginsdk/g:XNJ	Ljava/util/Map;
    //   44: aload 14
    //   46: invokeinterface 519 2 0
    //   51: checkcast 92	java/lang/Long
    //   54: invokevirtual 523	java/lang/Long:longValue	()J
    //   57: lstore 11
    //   59: ldc_w 371
    //   62: ldc_w 525
    //   65: iconst_1
    //   66: anewarray 4	java/lang/Object
    //   69: dup
    //   70: iconst_0
    //   71: lload 11
    //   73: invokestatic 96	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   76: aastore
    //   77: invokestatic 378	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   80: aconst_null
    //   81: astore 14
    //   83: new 527	android/content/Intent
    //   86: dup
    //   87: invokespecial 528	android/content/Intent:<init>	()V
    //   90: astore 9
    //   92: aload 9
    //   94: ldc_w 529
    //   97: invokevirtual 533	android/content/Intent:setFlags	(I)Landroid/content/Intent;
    //   100: pop
    //   101: lload 11
    //   103: lconst_0
    //   104: lcmp
    //   105: ifne +62 -> 167
    //   108: ldc_w 535
    //   111: astore_3
    //   112: aload 9
    //   114: astore 6
    //   116: aload_3
    //   117: invokestatic 369	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   120: ifne +4927 -> 5047
    //   123: aload 6
    //   125: invokestatic 541	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   128: aload_3
    //   129: invokevirtual 545	android/content/Intent:setClassName	(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;
    //   132: pop
    //   133: aload_0
    //   134: ifnull +4798 -> 4932
    //   137: aload_3
    //   138: ldc_w 547
    //   141: invokevirtual 551	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   144: ifeq +4690 -> 4834
    //   147: aload_0
    //   148: ldc_w 553
    //   151: ldc_w 555
    //   154: aload 6
    //   156: invokestatic 561	com/tencent/mm/br/c:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V
    //   159: ldc_w 509
    //   162: invokestatic 353	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   165: iconst_1
    //   166: ireturn
    //   167: lload 11
    //   169: lconst_1
    //   170: lcmp
    //   171: ifne +35 -> 206
    //   174: ldc_w 563
    //   177: astore_3
    //   178: getstatic 569	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   181: sipush 12065
    //   184: iconst_1
    //   185: anewarray 4	java/lang/Object
    //   188: dup
    //   189: iconst_0
    //   190: bipush 7
    //   192: invokestatic 473	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   195: aastore
    //   196: invokevirtual 572	com/tencent/mm/plugin/report/service/h:b	(I[Ljava/lang/Object;)V
    //   199: aload 9
    //   201: astore 6
    //   203: goto -87 -> 116
    //   206: lload 11
    //   208: ldc2_w 107
    //   211: lcmp
    //   212: ifne +35 -> 247
    //   215: aload 9
    //   217: ldc_w 574
    //   220: iconst_1
    //   221: invokevirtual 578	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   224: pop
    //   225: aload 9
    //   227: ldc_w 580
    //   230: bipush 6
    //   232: invokevirtual 583	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   235: pop
    //   236: ldc_w 585
    //   239: astore_3
    //   240: aload 9
    //   242: astore 6
    //   244: goto -128 -> 116
    //   247: lload 11
    //   249: ldc2_w 111
    //   252: lcmp
    //   253: ifne +47 -> 300
    //   256: invokestatic 590	com/tencent/mm/model/z:bBf	()I
    //   259: ldc_w 591
    //   262: iand
    //   263: ifne +32 -> 295
    //   266: iconst_1
    //   267: istore_2
    //   268: iload_2
    //   269: ifeq +7066 -> 7335
    //   272: ldc_w 593
    //   275: astore_1
    //   276: aload 9
    //   278: ldc_w 595
    //   281: iconst_1
    //   282: invokevirtual 578	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   285: pop
    //   286: aload_1
    //   287: astore_3
    //   288: aload 9
    //   290: astore 6
    //   292: goto -176 -> 116
    //   295: iconst_0
    //   296: istore_2
    //   297: goto -29 -> 268
    //   300: lload 11
    //   302: ldc2_w 349
    //   305: lcmp
    //   306: ifne +160 -> 466
    //   309: aload_1
    //   310: invokestatic 601	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   313: astore_1
    //   314: aload_1
    //   315: ldc_w 603
    //   318: invokevirtual 606	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   321: astore 5
    //   323: aload_1
    //   324: ldc_w 608
    //   327: invokevirtual 606	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   330: astore_3
    //   331: aload_1
    //   332: ldc_w 610
    //   335: invokevirtual 606	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   338: astore 6
    //   340: ldc 80
    //   342: astore_1
    //   343: aload_3
    //   344: ldc_w 612
    //   347: invokestatic 617	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   350: pop
    //   351: aload 6
    //   353: ldc_w 612
    //   356: invokestatic 617	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   359: astore_3
    //   360: aload_3
    //   361: astore_1
    //   362: new 619	com/tencent/mm/ad/i
    //   365: dup
    //   366: invokespecial 620	com/tencent/mm/ad/i:<init>	()V
    //   369: astore_3
    //   370: new 619	com/tencent/mm/ad/i
    //   373: dup
    //   374: invokespecial 620	com/tencent/mm/ad/i:<init>	()V
    //   377: astore 6
    //   379: aload 6
    //   381: ldc_w 622
    //   384: aload_1
    //   385: invokevirtual 626	com/tencent/mm/ad/i:m	(Ljava/lang/String;Ljava/lang/Object;)Lcom/tencent/mm/ad/i;
    //   388: pop
    //   389: aload 6
    //   391: ldc_w 628
    //   394: bipush 7
    //   396: invokevirtual 632	com/tencent/mm/ad/i:au	(Ljava/lang/String;I)Lcom/tencent/mm/ad/i;
    //   399: pop
    //   400: aload_3
    //   401: ldc_w 634
    //   404: aload 6
    //   406: invokevirtual 626	com/tencent/mm/ad/i:m	(Ljava/lang/String;Ljava/lang/Object;)Lcom/tencent/mm/ad/i;
    //   409: pop
    //   410: ldc_w 636
    //   413: invokestatic 640	com/tencent/mm/kernel/h:az	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   416: checkcast 636	com/tencent/mm/plugin/findersdk/a/cn
    //   419: aload_0
    //   420: aload_3
    //   421: invokevirtual 641	com/tencent/mm/ad/i:toString	()Ljava/lang/String;
    //   424: new 643	com/tencent/mm/pluginsdk/g$3
    //   427: dup
    //   428: aload 5
    //   430: invokespecial 644	com/tencent/mm/pluginsdk/g$3:<init>	(Ljava/lang/String;)V
    //   433: invokeinterface 648 4 0
    //   438: aload 14
    //   440: astore_3
    //   441: aload 9
    //   443: astore 6
    //   445: goto -329 -> 116
    //   448: astore_3
    //   449: ldc_w 371
    //   452: aload_3
    //   453: ldc_w 650
    //   456: iconst_0
    //   457: anewarray 4	java/lang/Object
    //   460: invokestatic 654	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   463: goto -101 -> 362
    //   466: lload 11
    //   468: ldc2_w 329
    //   471: lcmp
    //   472: ifne +204 -> 676
    //   475: aload_1
    //   476: invokestatic 601	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   479: astore_1
    //   480: aload_1
    //   481: ldc_w 603
    //   484: invokevirtual 606	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   487: astore 15
    //   489: aload_1
    //   490: ldc_w 656
    //   493: invokevirtual 606	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   496: astore 6
    //   498: aload_1
    //   499: ldc_w 658
    //   502: invokevirtual 606	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   505: astore 8
    //   507: ldc 80
    //   509: astore_1
    //   510: ldc 80
    //   512: astore 5
    //   514: aload 6
    //   516: ldc_w 612
    //   519: invokestatic 617	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   522: astore 6
    //   524: aload 6
    //   526: astore_1
    //   527: aload 8
    //   529: ldc_w 612
    //   532: invokestatic 617	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   535: astore 8
    //   537: aload 8
    //   539: astore 5
    //   541: aload 6
    //   543: astore_1
    //   544: aload_3
    //   545: ldc_w 660
    //   548: invokevirtual 480	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   551: astore 8
    //   553: aload_3
    //   554: ldc_w 482
    //   557: invokevirtual 664	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   560: istore_2
    //   561: ldc 80
    //   563: astore 6
    //   565: iload_2
    //   566: iconst_1
    //   567: if_icmpne +12 -> 579
    //   570: aload_3
    //   571: ldc_w 446
    //   574: invokevirtual 480	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   577: astore 6
    //   579: aload_3
    //   580: ldc_w 666
    //   583: invokevirtual 480	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   586: astore_3
    //   587: ldc_w 371
    //   590: ldc_w 668
    //   593: iconst_3
    //   594: anewarray 4	java/lang/Object
    //   597: dup
    //   598: iconst_0
    //   599: iload_2
    //   600: invokestatic 473	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   603: aastore
    //   604: dup
    //   605: iconst_1
    //   606: aload 6
    //   608: aastore
    //   609: dup
    //   610: iconst_2
    //   611: aload 8
    //   613: aastore
    //   614: invokestatic 378	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   617: ldc_w 636
    //   620: invokestatic 640	com/tencent/mm/kernel/h:az	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   623: checkcast 636	com/tencent/mm/plugin/findersdk/a/cn
    //   626: invokeinterface 672 1 0
    //   631: aload 15
    //   633: aload 8
    //   635: aload_1
    //   636: aload 5
    //   638: aload 6
    //   640: aload_3
    //   641: invokeinterface 678 7 0
    //   646: aload 14
    //   648: astore_3
    //   649: aload 9
    //   651: astore 6
    //   653: goto -537 -> 116
    //   656: astore 6
    //   658: ldc_w 371
    //   661: aload 6
    //   663: ldc_w 650
    //   666: iconst_0
    //   667: anewarray 4	java/lang/Object
    //   670: invokestatic 654	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   673: goto -129 -> 544
    //   676: lload 11
    //   678: ldc2_w 333
    //   681: lcmp
    //   682: ifne +85 -> 767
    //   685: aload_1
    //   686: invokestatic 601	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   689: astore_1
    //   690: aload_1
    //   691: ldc_w 603
    //   694: invokevirtual 606	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   697: astore_3
    //   698: aload_1
    //   699: ldc_w 608
    //   702: invokevirtual 606	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   705: astore_1
    //   706: aload_1
    //   707: ldc_w 612
    //   710: invokestatic 617	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   713: astore_1
    //   714: ldc_w 636
    //   717: invokestatic 640	com/tencent/mm/kernel/h:az	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   720: checkcast 636	com/tencent/mm/plugin/findersdk/a/cn
    //   723: invokeinterface 672 1 0
    //   728: aload_0
    //   729: aload_3
    //   730: aload_1
    //   731: invokeinterface 682 4 0
    //   736: aload 14
    //   738: astore_3
    //   739: aload 9
    //   741: astore 6
    //   743: goto -627 -> 116
    //   746: astore_1
    //   747: ldc_w 371
    //   750: aload_1
    //   751: ldc_w 650
    //   754: iconst_0
    //   755: anewarray 4	java/lang/Object
    //   758: invokestatic 654	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   761: ldc 80
    //   763: astore_1
    //   764: goto -50 -> 714
    //   767: lload 11
    //   769: ldc2_w 337
    //   772: lcmp
    //   773: ifne +121 -> 894
    //   776: aload_1
    //   777: invokestatic 601	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   780: astore_1
    //   781: aload_1
    //   782: ldc_w 603
    //   785: invokevirtual 606	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   788: astore 8
    //   790: aload_1
    //   791: ldc_w 684
    //   794: invokevirtual 606	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   797: astore_3
    //   798: aload_1
    //   799: ldc_w 686
    //   802: invokevirtual 606	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   805: astore 6
    //   807: ldc 80
    //   809: astore_1
    //   810: ldc 80
    //   812: astore 5
    //   814: aload_3
    //   815: ldc_w 612
    //   818: invokestatic 617	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   821: astore_3
    //   822: aload_3
    //   823: astore_1
    //   824: aload 6
    //   826: ldc_w 612
    //   829: invokestatic 617	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   832: astore 6
    //   834: aload 6
    //   836: astore_1
    //   837: ldc_w 636
    //   840: invokestatic 640	com/tencent/mm/kernel/h:az	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   843: checkcast 636	com/tencent/mm/plugin/findersdk/a/cn
    //   846: invokeinterface 672 1 0
    //   851: aload_0
    //   852: aload 8
    //   854: aload_3
    //   855: aload_1
    //   856: invokeinterface 690 5 0
    //   861: aload 14
    //   863: astore_3
    //   864: aload 9
    //   866: astore 6
    //   868: goto -752 -> 116
    //   871: astore_3
    //   872: ldc_w 371
    //   875: aload_3
    //   876: ldc_w 650
    //   879: iconst_0
    //   880: anewarray 4	java/lang/Object
    //   883: invokestatic 654	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   886: aload_1
    //   887: astore_3
    //   888: aload 5
    //   890: astore_1
    //   891: goto -54 -> 837
    //   894: lload 11
    //   896: ldc2_w 341
    //   899: lcmp
    //   900: ifne +131 -> 1031
    //   903: aload_1
    //   904: invokestatic 601	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   907: astore_1
    //   908: aload_1
    //   909: ldc_w 603
    //   912: invokevirtual 606	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   915: astore 8
    //   917: aload_1
    //   918: ldc_w 684
    //   921: invokevirtual 606	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   924: astore_3
    //   925: aload_1
    //   926: ldc_w 686
    //   929: invokevirtual 606	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   932: astore 6
    //   934: aload_1
    //   935: ldc_w 692
    //   938: invokevirtual 606	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   941: astore 15
    //   943: ldc 80
    //   945: astore_1
    //   946: ldc 80
    //   948: astore 5
    //   950: aload_3
    //   951: ldc_w 612
    //   954: invokestatic 617	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   957: astore_3
    //   958: aload_3
    //   959: astore_1
    //   960: aload 6
    //   962: ldc_w 612
    //   965: invokestatic 617	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   968: astore 6
    //   970: aload 6
    //   972: astore 5
    //   974: aload_3
    //   975: astore_1
    //   976: ldc_w 636
    //   979: invokestatic 640	com/tencent/mm/kernel/h:az	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   982: checkcast 636	com/tencent/mm/plugin/findersdk/a/cn
    //   985: invokeinterface 672 1 0
    //   990: aload_0
    //   991: aload 8
    //   993: aload_1
    //   994: aload 5
    //   996: aload 15
    //   998: invokeinterface 695 6 0
    //   1003: aload 14
    //   1005: astore_3
    //   1006: aload 9
    //   1008: astore 6
    //   1010: goto -894 -> 116
    //   1013: astore_3
    //   1014: ldc_w 371
    //   1017: aload_3
    //   1018: ldc_w 650
    //   1021: iconst_0
    //   1022: anewarray 4	java/lang/Object
    //   1025: invokestatic 654	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1028: goto -52 -> 976
    //   1031: lload 11
    //   1033: ldc2_w 115
    //   1036: lcmp
    //   1037: ifne +14 -> 1051
    //   1040: ldc_w 697
    //   1043: astore_3
    //   1044: aload 9
    //   1046: astore 6
    //   1048: goto -932 -> 116
    //   1051: lload 11
    //   1053: ldc2_w 119
    //   1056: lcmp
    //   1057: ifne +101 -> 1158
    //   1060: new 699	com/tencent/mm/autogen/a/lq
    //   1063: dup
    //   1064: invokespecial 700	com/tencent/mm/autogen/a/lq:<init>	()V
    //   1067: astore_1
    //   1068: aload_1
    //   1069: invokevirtual 704	com/tencent/mm/autogen/a/lq:publish	()Z
    //   1072: pop
    //   1073: aload_1
    //   1074: getfield 708	com/tencent/mm/autogen/a/lq:hNA	Lcom/tencent/mm/autogen/a/lq$a;
    //   1077: getfield 712	com/tencent/mm/autogen/a/lq$a:url	Ljava/lang/String;
    //   1080: astore_1
    //   1081: aload 14
    //   1083: astore_3
    //   1084: aload 9
    //   1086: astore 6
    //   1088: aload_1
    //   1089: invokestatic 369	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   1092: ifne -976 -> 116
    //   1095: aload 9
    //   1097: ldc_w 714
    //   1100: aload_1
    //   1101: invokevirtual 717	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1104: pop
    //   1105: aload 9
    //   1107: ldc_w 719
    //   1110: iconst_1
    //   1111: invokevirtual 578	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1114: pop
    //   1115: aload 9
    //   1117: ldc_w 721
    //   1120: iconst_1
    //   1121: invokevirtual 578	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1124: pop
    //   1125: aload 9
    //   1127: ldc_w 723
    //   1130: iload 4
    //   1132: invokevirtual 583	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1135: pop
    //   1136: aload 9
    //   1138: ldc_w 725
    //   1141: aload 5
    //   1143: invokevirtual 728	android/content/Intent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
    //   1146: pop
    //   1147: ldc_w 730
    //   1150: astore_3
    //   1151: aload 9
    //   1153: astore 6
    //   1155: goto -1039 -> 116
    //   1158: lload 11
    //   1160: ldc2_w 123
    //   1163: lcmp
    //   1164: ifne +95 -> 1259
    //   1167: aload 9
    //   1169: ldc_w 732
    //   1172: invokestatic 541	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   1175: getstatic 735	com/tencent/mm/plugin/biz/b$f:address_title_launch_chatting	I
    //   1178: invokevirtual 739	android/content/Context:getString	(I)Ljava/lang/String;
    //   1181: invokevirtual 717	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1184: pop
    //   1185: aload 9
    //   1187: ldc_w 741
    //   1190: iconst_0
    //   1191: invokevirtual 583	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1194: pop
    //   1195: aload 9
    //   1197: ldc_w 743
    //   1200: iconst_3
    //   1201: newarray int
    //   1203: dup
    //   1204: iconst_0
    //   1205: getstatic 748	com/tencent/mm/ui/contact/w:affr	I
    //   1208: iastore
    //   1209: dup
    //   1210: iconst_1
    //   1211: sipush 256
    //   1214: iastore
    //   1215: dup
    //   1216: iconst_2
    //   1217: sipush 512
    //   1220: iastore
    //   1221: invokestatic 752	com/tencent/mm/ui/contact/w:R	([I)I
    //   1224: invokevirtual 583	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1227: pop
    //   1228: aload 9
    //   1230: ldc_w 754
    //   1233: iconst_1
    //   1234: invokevirtual 578	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1237: pop
    //   1238: aload 9
    //   1240: ldc_w 756
    //   1243: iconst_2
    //   1244: invokevirtual 583	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1247: pop
    //   1248: ldc_w 758
    //   1251: astore_3
    //   1252: aload 9
    //   1254: astore 6
    //   1256: goto -1140 -> 116
    //   1259: lload 11
    //   1261: ldc2_w 127
    //   1264: lcmp
    //   1265: ifne +24 -> 1289
    //   1268: ldc_w 760
    //   1271: astore_3
    //   1272: aload 9
    //   1274: ldc_w 762
    //   1277: iconst_1
    //   1278: invokevirtual 578	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1281: pop
    //   1282: aload 9
    //   1284: astore 6
    //   1286: goto -1170 -> 116
    //   1289: lload 11
    //   1291: ldc2_w 131
    //   1294: lcmp
    //   1295: ifne +14 -> 1309
    //   1298: ldc_w 764
    //   1301: astore_3
    //   1302: aload 9
    //   1304: astore 6
    //   1306: goto -1190 -> 116
    //   1309: lload 11
    //   1311: ldc2_w 135
    //   1314: lcmp
    //   1315: ifne +14 -> 1329
    //   1318: ldc_w 766
    //   1321: astore_3
    //   1322: aload 9
    //   1324: astore 6
    //   1326: goto -1210 -> 116
    //   1329: lload 11
    //   1331: ldc2_w 139
    //   1334: lcmp
    //   1335: ifne +14 -> 1349
    //   1338: ldc_w 768
    //   1341: astore_3
    //   1342: aload 9
    //   1344: astore 6
    //   1346: goto -1230 -> 116
    //   1349: lload 11
    //   1351: ldc2_w 143
    //   1354: lcmp
    //   1355: ifne +21 -> 1376
    //   1358: invokestatic 541	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   1361: iload 4
    //   1363: invokestatic 772	com/tencent/mm/pluginsdk/g:bi	(Landroid/content/Context;I)V
    //   1366: aload 14
    //   1368: astore_3
    //   1369: aload 9
    //   1371: astore 6
    //   1373: goto -1257 -> 116
    //   1376: lload 11
    //   1378: ldc2_w 147
    //   1381: lcmp
    //   1382: ifne +14 -> 1396
    //   1385: ldc_w 774
    //   1388: astore_3
    //   1389: aload 9
    //   1391: astore 6
    //   1393: goto -1277 -> 116
    //   1396: lload 11
    //   1398: ldc2_w 151
    //   1401: lcmp
    //   1402: ifne +104 -> 1506
    //   1405: aload 9
    //   1407: ldc_w 656
    //   1410: invokestatic 541	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   1413: invokevirtual 778	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   1416: getstatic 781	com/tencent/mm/plugin/biz/b$f:privacy_tip	I
    //   1419: invokevirtual 784	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   1422: invokevirtual 717	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1425: pop
    //   1426: aload 9
    //   1428: ldc_w 714
    //   1431: invokestatic 541	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   1434: invokevirtual 778	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   1437: getstatic 787	com/tencent/mm/plugin/biz/b$f:url_agreement	I
    //   1440: iconst_2
    //   1441: anewarray 4	java/lang/Object
    //   1444: dup
    //   1445: iconst_0
    //   1446: invokestatic 792	com/tencent/mm/sdk/platformtools/LocaleUtil:getApplicationLanguage	()Ljava/lang/String;
    //   1449: aastore
    //   1450: dup
    //   1451: iconst_1
    //   1452: invokestatic 795	com/tencent/mm/sdk/platformtools/LocaleUtil:getCurrentCountryCode	()Ljava/lang/String;
    //   1455: aastore
    //   1456: invokevirtual 798	android/content/res/Resources:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   1459: invokevirtual 717	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1462: pop
    //   1463: aload 9
    //   1465: ldc_w 800
    //   1468: iconst_0
    //   1469: invokevirtual 578	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1472: pop
    //   1473: aload 9
    //   1475: ldc_w 723
    //   1478: iload 4
    //   1480: invokevirtual 583	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1483: pop
    //   1484: aload 9
    //   1486: ldc_w 725
    //   1489: aload 5
    //   1491: invokevirtual 728	android/content/Intent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
    //   1494: pop
    //   1495: ldc_w 730
    //   1498: astore_3
    //   1499: aload 9
    //   1501: astore 6
    //   1503: goto -1387 -> 116
    //   1506: lload 11
    //   1508: ldc2_w 155
    //   1511: lcmp
    //   1512: ifne +14 -> 1526
    //   1515: ldc_w 802
    //   1518: astore_3
    //   1519: aload 9
    //   1521: astore 6
    //   1523: goto -1407 -> 116
    //   1526: lload 11
    //   1528: ldc2_w 159
    //   1531: lcmp
    //   1532: ifne +14 -> 1546
    //   1535: ldc_w 804
    //   1538: astore_3
    //   1539: aload 9
    //   1541: astore 6
    //   1543: goto -1427 -> 116
    //   1546: lload 11
    //   1548: ldc2_w 163
    //   1551: lcmp
    //   1552: ifne +14 -> 1566
    //   1555: ldc_w 806
    //   1558: astore_3
    //   1559: aload 9
    //   1561: astore 6
    //   1563: goto -1447 -> 116
    //   1566: lload 11
    //   1568: ldc2_w 167
    //   1571: lcmp
    //   1572: ifne +492 -> 2064
    //   1575: aload_1
    //   1576: ldc_w 808
    //   1579: invokevirtual 811	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1582: istore_2
    //   1583: iload_2
    //   1584: ifle +5745 -> 7329
    //   1587: aload_1
    //   1588: iload_2
    //   1589: iconst_1
    //   1590: iadd
    //   1591: invokevirtual 814	java/lang/String:substring	(I)Ljava/lang/String;
    //   1594: astore_1
    //   1595: invokestatic 818	com/tencent/mm/kernel/h:baC	()Lcom/tencent/mm/kernel/b;
    //   1598: pop
    //   1599: invokestatic 823	com/tencent/mm/kernel/b:getUin	()I
    //   1602: istore_2
    //   1603: getstatic 828	com/tencent/mm/protocal/d:Yxf	Ljava/lang/String;
    //   1606: ldc_w 830
    //   1609: invokestatic 835	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1612: astore_3
    //   1613: new 37	java/lang/StringBuilder
    //   1616: dup
    //   1617: invokespecial 836	java/lang/StringBuilder:<init>	()V
    //   1620: invokestatic 839	com/tencent/mm/sdk/platformtools/Util:getTimeZoneOffset	()Ljava/lang/String;
    //   1623: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1626: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1629: ldc_w 830
    //   1632: invokestatic 835	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1635: astore 6
    //   1637: iconst_1
    //   1638: invokestatic 845	com/tencent/mm/compatible/deviceinfo/q:eD	(Z)Ljava/lang/String;
    //   1641: ldc_w 830
    //   1644: invokestatic 835	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1647: astore 8
    //   1649: getstatic 848	com/tencent/mm/protocal/d:Yxa	Ljava/lang/String;
    //   1652: ldc_w 830
    //   1655: invokestatic 835	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1658: astore 15
    //   1660: getstatic 851	com/tencent/mm/protocal/d:Yxb	Ljava/lang/String;
    //   1663: ldc_w 830
    //   1666: invokestatic 835	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1669: astore 16
    //   1671: getstatic 854	com/tencent/mm/protocal/d:Yxc	Ljava/lang/String;
    //   1674: ldc_w 830
    //   1677: invokestatic 835	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1680: astore 17
    //   1682: invokestatic 857	com/tencent/mm/kernel/b:aZR	()Ljava/lang/String;
    //   1685: ldc_w 830
    //   1688: invokestatic 835	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1691: astore 18
    //   1693: invokestatic 541	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   1696: invokestatic 861	com/tencent/mm/sdk/platformtools/Util:getSourceeMd5	(Landroid/content/Context;)Ljava/lang/String;
    //   1699: ldc_w 830
    //   1702: invokestatic 835	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1705: astore 19
    //   1707: new 37	java/lang/StringBuilder
    //   1710: dup
    //   1711: ldc_w 863
    //   1714: invokespecial 43	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1717: iload_2
    //   1718: invokevirtual 866	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1721: ldc_w 868
    //   1724: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1727: aload_3
    //   1728: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1731: ldc_w 870
    //   1734: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1737: aload 6
    //   1739: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1742: ldc_w 872
    //   1745: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1748: aload 8
    //   1750: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1753: ldc_w 874
    //   1756: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1759: aload 15
    //   1761: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1764: ldc_w 876
    //   1767: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1770: aload 16
    //   1772: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1775: ldc_w 878
    //   1778: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1781: aload 17
    //   1783: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1786: ldc_w 880
    //   1789: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1792: aload 18
    //   1794: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1797: ldc_w 882
    //   1800: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1803: aload 19
    //   1805: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1808: ldc_w 884
    //   1811: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1814: astore_3
    //   1815: aload_1
    //   1816: invokestatic 369	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   1819: ifeq +209 -> 2028
    //   1822: iconst_0
    //   1823: istore_2
    //   1824: aload_3
    //   1825: iload_2
    //   1826: invokevirtual 866	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1829: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1832: astore_3
    //   1833: new 37	java/lang/StringBuilder
    //   1836: dup
    //   1837: ldc 39
    //   1839: invokespecial 43	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1842: getstatic 49	com/tencent/mm/plugin/biz/b$f:host_support_weixin_qq_com	I
    //   1845: invokestatic 55	com/tencent/mm/sdk/platformtools/WeChatHosts:domainString	(I)Ljava/lang/String;
    //   1848: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1851: ldc_w 886
    //   1854: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1857: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1860: astore 6
    //   1862: new 37	java/lang/StringBuilder
    //   1865: dup
    //   1866: invokespecial 836	java/lang/StringBuilder:<init>	()V
    //   1869: aload 6
    //   1871: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1874: ldc_w 888
    //   1877: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1880: getstatic 891	com/tencent/mm/protocal/d:Yxh	I
    //   1883: invokevirtual 866	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1886: ldc_w 893
    //   1889: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1892: invokestatic 541	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   1895: invokestatic 896	com/tencent/mm/sdk/platformtools/LocaleUtil:getCurrentLanguage	(Landroid/content/Context;)Ljava/lang/String;
    //   1898: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1901: ldc_w 898
    //   1904: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1907: aload_1
    //   1908: invokestatic 901	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   1911: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1914: aload_3
    //   1915: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1918: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1921: astore_1
    //   1922: invokestatic 907	com/tencent/mm/sdk/platformtools/WeChatBrands$AppInfo:current	()Lcom/tencent/mm/sdk/platformtools/WeChatBrands$AppInfo$WhichApp;
    //   1925: invokevirtual 912	com/tencent/mm/sdk/platformtools/WeChatBrands$AppInfo$WhichApp:isMainland	()Z
    //   1928: ifne +13 -> 1941
    //   1931: aload 9
    //   1933: ldc_w 914
    //   1936: iconst_1
    //   1937: invokevirtual 578	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1940: pop
    //   1941: aload 9
    //   1943: ldc_w 800
    //   1946: iconst_0
    //   1947: invokevirtual 578	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1950: pop
    //   1951: aload 9
    //   1953: ldc_w 714
    //   1956: aload_1
    //   1957: invokevirtual 717	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1960: pop
    //   1961: aload 9
    //   1963: ldc_w 916
    //   1966: iconst_1
    //   1967: invokevirtual 578	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1970: pop
    //   1971: aload 9
    //   1973: ldc_w 723
    //   1976: iload 4
    //   1978: invokevirtual 583	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1981: pop
    //   1982: aload 9
    //   1984: ldc_w 725
    //   1987: aload 5
    //   1989: invokevirtual 728	android/content/Intent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
    //   1992: pop
    //   1993: aload 9
    //   1995: ldc_w 918
    //   1998: getstatic 924	com/tencent/mm/protocal/JsapiPermissionWrapper:YxF	Lcom/tencent/mm/protocal/JsapiPermissionWrapper;
    //   2001: invokevirtual 927	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   2004: pop
    //   2005: aload 9
    //   2007: ldc_w 929
    //   2010: getstatic 935	com/tencent/mm/protocal/GeneralControlWrapper:YxA	Lcom/tencent/mm/protocal/GeneralControlWrapper;
    //   2013: invokevirtual 927	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   2016: pop
    //   2017: ldc_w 730
    //   2020: astore_3
    //   2021: aload 9
    //   2023: astore 6
    //   2025: goto -1909 -> 116
    //   2028: iconst_1
    //   2029: istore_2
    //   2030: goto -206 -> 1824
    //   2033: astore_1
    //   2034: ldc_w 371
    //   2037: ldc_w 937
    //   2040: iconst_1
    //   2041: anewarray 4	java/lang/Object
    //   2044: dup
    //   2045: iconst_0
    //   2046: aload_1
    //   2047: invokevirtual 940	java/io/UnsupportedEncodingException:getMessage	()Ljava/lang/String;
    //   2050: aastore
    //   2051: invokestatic 943	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2054: aload 14
    //   2056: astore_3
    //   2057: aload 9
    //   2059: astore 6
    //   2061: goto -1945 -> 116
    //   2064: lload 11
    //   2066: ldc2_w 171
    //   2069: lcmp
    //   2070: ifne +114 -> 2184
    //   2073: invokestatic 818	com/tencent/mm/kernel/h:baC	()Lcom/tencent/mm/kernel/b;
    //   2076: pop
    //   2077: invokestatic 823	com/tencent/mm/kernel/b:getUin	()I
    //   2080: istore_2
    //   2081: invokestatic 947	com/tencent/mm/kernel/h:baE	()Lcom/tencent/mm/kernel/f;
    //   2084: invokevirtual 953	com/tencent/mm/kernel/f:ban	()Lcom/tencent/mm/storage/aq;
    //   2087: sipush 12304
    //   2090: aconst_null
    //   2091: invokevirtual 959	com/tencent/mm/storage/aq:d	(ILjava/lang/Object;)Ljava/lang/Object;
    //   2094: checkcast 470	java/lang/Integer
    //   2097: invokestatic 962	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/Integer;)I
    //   2100: istore 7
    //   2102: invokestatic 541	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   2105: getstatic 965	com/tencent/mm/plugin/biz/b$f:settings_system_notice_url	I
    //   2108: iconst_2
    //   2109: anewarray 4	java/lang/Object
    //   2112: dup
    //   2113: iconst_0
    //   2114: iload_2
    //   2115: invokestatic 473	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2118: aastore
    //   2119: dup
    //   2120: iconst_1
    //   2121: iload 7
    //   2123: invokestatic 473	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2126: aastore
    //   2127: invokevirtual 966	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   2130: astore_1
    //   2131: aload 9
    //   2133: ldc_w 800
    //   2136: iconst_0
    //   2137: invokevirtual 578	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   2140: pop
    //   2141: aload 9
    //   2143: ldc_w 714
    //   2146: aload_1
    //   2147: invokevirtual 717	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2150: pop
    //   2151: aload 9
    //   2153: ldc_w 723
    //   2156: iload 4
    //   2158: invokevirtual 583	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2161: pop
    //   2162: aload 9
    //   2164: ldc_w 725
    //   2167: aload 5
    //   2169: invokevirtual 728	android/content/Intent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
    //   2172: pop
    //   2173: ldc_w 730
    //   2176: astore_3
    //   2177: aload 9
    //   2179: astore 6
    //   2181: goto -2065 -> 116
    //   2184: lload 11
    //   2186: ldc2_w 175
    //   2189: lcmp
    //   2190: ifne +14 -> 2204
    //   2193: ldc_w 968
    //   2196: astore_3
    //   2197: aload 9
    //   2199: astore 6
    //   2201: goto -2085 -> 116
    //   2204: lload 11
    //   2206: ldc2_w 179
    //   2209: lcmp
    //   2210: ifne +14 -> 2224
    //   2213: ldc_w 970
    //   2216: astore_3
    //   2217: aload 9
    //   2219: astore 6
    //   2221: goto -2105 -> 116
    //   2224: lload 11
    //   2226: ldc2_w 183
    //   2229: lcmp
    //   2230: ifne +14 -> 2244
    //   2233: ldc_w 972
    //   2236: astore_3
    //   2237: aload 9
    //   2239: astore 6
    //   2241: goto -2125 -> 116
    //   2244: lload 11
    //   2246: ldc2_w 187
    //   2249: lcmp
    //   2250: ifne +14 -> 2264
    //   2253: ldc_w 974
    //   2256: astore_3
    //   2257: aload 9
    //   2259: astore 6
    //   2261: goto -2145 -> 116
    //   2264: lload 11
    //   2266: ldc2_w 217
    //   2269: lcmp
    //   2270: ifne +35 -> 2305
    //   2273: aload 9
    //   2275: ldc_w 976
    //   2278: iconst_1
    //   2279: invokevirtual 583	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2282: pop
    //   2283: invokestatic 541	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   2286: ldc_w 978
    //   2289: ldc_w 980
    //   2292: aload 9
    //   2294: invokestatic 561	com/tencent/mm/br/c:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V
    //   2297: ldc_w 509
    //   2300: invokestatic 353	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2303: iconst_1
    //   2304: ireturn
    //   2305: lload 11
    //   2307: ldc2_w 191
    //   2310: lcmp
    //   2311: ifne +95 -> 2406
    //   2314: aload 9
    //   2316: ldc_w 982
    //   2319: invokestatic 947	com/tencent/mm/kernel/h:baE	()Lcom/tencent/mm/kernel/f;
    //   2322: invokevirtual 953	com/tencent/mm/kernel/f:ban	()Lcom/tencent/mm/storage/aq;
    //   2325: iconst_2
    //   2326: aconst_null
    //   2327: invokevirtual 959	com/tencent/mm/storage/aq:d	(ILjava/lang/Object;)Ljava/lang/Object;
    //   2330: checkcast 441	java/lang/String
    //   2333: invokevirtual 717	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2336: pop
    //   2337: aload 9
    //   2339: ldc_w 983
    //   2342: invokevirtual 986	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   2345: pop
    //   2346: aload 9
    //   2348: ldc_w 988
    //   2351: iconst_1
    //   2352: invokevirtual 583	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2355: pop
    //   2356: ldc_w 990
    //   2359: astore_3
    //   2360: invokestatic 947	com/tencent/mm/kernel/h:baE	()Lcom/tencent/mm/kernel/f;
    //   2363: invokevirtual 953	com/tencent/mm/kernel/f:ban	()Lcom/tencent/mm/storage/aq;
    //   2366: ldc_w 991
    //   2369: aconst_null
    //   2370: invokevirtual 959	com/tencent/mm/storage/aq:d	(ILjava/lang/Object;)Ljava/lang/Object;
    //   2373: checkcast 470	java/lang/Integer
    //   2376: iconst_0
    //   2377: invokestatic 995	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/Integer;I)I
    //   2380: istore_2
    //   2381: invokestatic 947	com/tencent/mm/kernel/h:baE	()Lcom/tencent/mm/kernel/f;
    //   2384: invokevirtual 953	com/tencent/mm/kernel/f:ban	()Lcom/tencent/mm/storage/aq;
    //   2387: ldc_w 991
    //   2390: iload_2
    //   2391: iconst_1
    //   2392: iadd
    //   2393: invokestatic 473	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2396: invokevirtual 999	com/tencent/mm/storage/aq:B	(ILjava/lang/Object;)V
    //   2399: aload 9
    //   2401: astore 6
    //   2403: goto -2287 -> 116
    //   2406: lload 11
    //   2408: ldc2_w 195
    //   2411: lcmp
    //   2412: ifne +14 -> 2426
    //   2415: ldc_w 1001
    //   2418: astore_3
    //   2419: aload 9
    //   2421: astore 6
    //   2423: goto -2307 -> 116
    //   2426: lload 11
    //   2428: ldc2_w 199
    //   2431: lcmp
    //   2432: ifne +14 -> 2446
    //   2435: ldc_w 1003
    //   2438: astore_3
    //   2439: aload 9
    //   2441: astore 6
    //   2443: goto -2327 -> 116
    //   2446: lload 11
    //   2448: ldc2_w 203
    //   2451: lcmp
    //   2452: ifne +14 -> 2466
    //   2455: ldc_w 1005
    //   2458: astore_3
    //   2459: aload 9
    //   2461: astore 6
    //   2463: goto -2347 -> 116
    //   2466: lload 11
    //   2468: ldc2_w 207
    //   2471: lcmp
    //   2472: ifne +71 -> 2543
    //   2475: ldc_w 1007
    //   2478: invokestatic 1011	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   2481: checkcast 1007	com/tencent/mm/plugin/expt/b/c
    //   2484: getstatic 1017	com/tencent/mm/plugin/expt/b/c$a:yXg	Lcom/tencent/mm/plugin/expt/b/c$a;
    //   2487: iconst_1
    //   2488: invokeinterface 1020 3 0
    //   2493: istore 13
    //   2495: ldc_w 371
    //   2498: ldc_w 1022
    //   2501: iconst_1
    //   2502: anewarray 4	java/lang/Object
    //   2505: dup
    //   2506: iconst_0
    //   2507: iload 13
    //   2509: invokestatic 1027	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2512: aastore
    //   2513: invokestatic 378	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2516: iload 13
    //   2518: ifeq +14 -> 2532
    //   2521: ldc_w 1029
    //   2524: astore_3
    //   2525: aload 9
    //   2527: astore 6
    //   2529: goto -2413 -> 116
    //   2532: ldc_w 1031
    //   2535: astore_3
    //   2536: aload 9
    //   2538: astore 6
    //   2540: goto -2424 -> 116
    //   2543: lload 11
    //   2545: ldc2_w 211
    //   2548: lcmp
    //   2549: ifne +16 -> 2565
    //   2552: aload_1
    //   2553: aload_0
    //   2554: invokestatic 1035	com/tencent/mm/pluginsdk/g:n	(Ljava/lang/String;Landroid/content/Context;)Landroid/content/Intent;
    //   2557: astore 6
    //   2559: aload 14
    //   2561: astore_3
    //   2562: goto -2446 -> 116
    //   2565: lload 11
    //   2567: ldc2_w 221
    //   2570: lcmp
    //   2571: ifne +14 -> 2585
    //   2574: ldc_w 1037
    //   2577: astore_3
    //   2578: aload 9
    //   2580: astore 6
    //   2582: goto -2466 -> 116
    //   2585: lload 11
    //   2587: ldc2_w 225
    //   2590: lcmp
    //   2591: ifne +43 -> 2634
    //   2594: ldc_w 371
    //   2597: ldc_w 1039
    //   2600: invokestatic 1041	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2603: new 1043	com/tencent/mm/autogen/a/mg
    //   2606: dup
    //   2607: invokespecial 1044	com/tencent/mm/autogen/a/mg:<init>	()V
    //   2610: astore_1
    //   2611: aload_1
    //   2612: getfield 1048	com/tencent/mm/autogen/a/mg:hOp	Lcom/tencent/mm/autogen/a/mg$a;
    //   2615: aload_0
    //   2616: putfield 1054	com/tencent/mm/autogen/a/mg$a:context	Landroid/content/Context;
    //   2619: aload_1
    //   2620: invokevirtual 1055	com/tencent/mm/autogen/a/mg:publish	()Z
    //   2623: pop
    //   2624: aload 14
    //   2626: astore_3
    //   2627: aload 9
    //   2629: astore 6
    //   2631: goto -2515 -> 116
    //   2634: lload 11
    //   2636: ldc2_w 233
    //   2639: lcmp
    //   2640: ifne +68 -> 2708
    //   2643: aload 9
    //   2645: ldc_w 1057
    //   2648: invokestatic 541	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   2651: getstatic 1060	com/tencent/mm/plugin/biz/b$f:group_blacklist	I
    //   2654: invokevirtual 739	android/content/Context:getString	(I)Ljava/lang/String;
    //   2657: invokestatic 1066	com/tencent/mm/model/ai:Js	(Ljava/lang/String;)Lcom/tencent/mm/model/ah;
    //   2660: invokevirtual 1071	com/tencent/mm/model/ah:getType	()Ljava/lang/String;
    //   2663: invokevirtual 717	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2666: pop
    //   2667: aload 9
    //   2669: ldc_w 732
    //   2672: invokestatic 541	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   2675: getstatic 1074	com/tencent/mm/plugin/biz/b$f:settings_private_blacklist	I
    //   2678: invokevirtual 739	android/content/Context:getString	(I)Ljava/lang/String;
    //   2681: invokevirtual 717	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2684: pop
    //   2685: aload 9
    //   2687: ldc_w 743
    //   2690: ldc_w 591
    //   2693: invokevirtual 583	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2696: pop
    //   2697: ldc_w 1076
    //   2700: astore_3
    //   2701: aload 9
    //   2703: astore 6
    //   2705: goto -2589 -> 116
    //   2708: lload 11
    //   2710: ldc2_w 237
    //   2713: lcmp
    //   2714: ifne +14 -> 2728
    //   2717: ldc_w 1078
    //   2720: astore_3
    //   2721: aload 9
    //   2723: astore 6
    //   2725: goto -2609 -> 116
    //   2728: lload 11
    //   2730: ldc2_w 241
    //   2733: lcmp
    //   2734: ifne +14 -> 2748
    //   2737: ldc_w 768
    //   2740: astore_3
    //   2741: aload 9
    //   2743: astore 6
    //   2745: goto -2629 -> 116
    //   2748: lload 11
    //   2750: ldc2_w 245
    //   2753: lcmp
    //   2754: ifne +14 -> 2768
    //   2757: ldc_w 1080
    //   2760: astore_3
    //   2761: aload 9
    //   2763: astore 6
    //   2765: goto -2649 -> 116
    //   2768: lload 11
    //   2770: ldc2_w 249
    //   2773: lcmp
    //   2774: ifne +14 -> 2788
    //   2777: ldc_w 1082
    //   2780: astore_3
    //   2781: aload 9
    //   2783: astore 6
    //   2785: goto -2669 -> 116
    //   2788: lload 11
    //   2790: ldc2_w 253
    //   2793: lcmp
    //   2794: ifne +29 -> 2823
    //   2797: aload 9
    //   2799: invokestatic 541	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   2802: ldc_w 1084
    //   2805: invokevirtual 545	android/content/Intent:setClassName	(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;
    //   2808: pop
    //   2809: aload_0
    //   2810: aload 9
    //   2812: invokestatic 1090	com/tencent/mm/ui/MMWizardActivity:aQ	(Landroid/content/Context;Landroid/content/Intent;)V
    //   2815: ldc_w 509
    //   2818: invokestatic 353	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2821: iconst_1
    //   2822: ireturn
    //   2823: lload 11
    //   2825: ldc2_w 257
    //   2828: lcmp
    //   2829: ifne +29 -> 2858
    //   2832: aload 9
    //   2834: invokestatic 541	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   2837: ldc_w 1092
    //   2840: invokevirtual 545	android/content/Intent:setClassName	(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;
    //   2843: pop
    //   2844: aload_0
    //   2845: aload 9
    //   2847: invokestatic 1090	com/tencent/mm/ui/MMWizardActivity:aQ	(Landroid/content/Context;Landroid/content/Intent;)V
    //   2850: ldc_w 509
    //   2853: invokestatic 353	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2856: iconst_1
    //   2857: ireturn
    //   2858: lload 11
    //   2860: ldc2_w 261
    //   2863: lcmp
    //   2864: ifne +14 -> 2878
    //   2867: ldc_w 1094
    //   2870: astore_3
    //   2871: aload 9
    //   2873: astore 6
    //   2875: goto -2759 -> 116
    //   2878: lload 11
    //   2880: ldc2_w 265
    //   2883: lcmp
    //   2884: ifne +34 -> 2918
    //   2887: invokestatic 541	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   2890: ldc_w 1096
    //   2893: ldc_w 1098
    //   2896: aload 9
    //   2898: ldc_w 1100
    //   2901: ldc_w 1102
    //   2904: invokevirtual 717	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2907: invokestatic 561	com/tencent/mm/br/c:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V
    //   2910: ldc_w 509
    //   2913: invokestatic 353	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2916: iconst_1
    //   2917: ireturn
    //   2918: lload 11
    //   2920: ldc2_w 269
    //   2923: lcmp
    //   2924: ifne +14 -> 2938
    //   2927: ldc_w 1104
    //   2930: astore_3
    //   2931: aload 9
    //   2933: astore 6
    //   2935: goto -2819 -> 116
    //   2938: lload 11
    //   2940: ldc2_w 273
    //   2943: lcmp
    //   2944: ifne +14 -> 2958
    //   2947: ldc_w 1106
    //   2950: astore_3
    //   2951: aload 9
    //   2953: astore 6
    //   2955: goto -2839 -> 116
    //   2958: lload 11
    //   2960: ldc2_w 277
    //   2963: lcmp
    //   2964: ifne +14 -> 2978
    //   2967: ldc_w 1108
    //   2970: astore_3
    //   2971: aload 9
    //   2973: astore 6
    //   2975: goto -2859 -> 116
    //   2978: lload 11
    //   2980: ldc2_w 281
    //   2983: lcmp
    //   2984: ifne +35 -> 3019
    //   2987: aload 9
    //   2989: ldc_w 1110
    //   2992: iconst_0
    //   2993: invokevirtual 578	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   2996: pop
    //   2997: invokestatic 541	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   3000: ldc_w 1112
    //   3003: ldc_w 1114
    //   3006: aload 9
    //   3008: invokestatic 1116	com/tencent/mm/br/c:c	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V
    //   3011: ldc_w 509
    //   3014: invokestatic 353	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3017: iconst_1
    //   3018: ireturn
    //   3019: lload 11
    //   3021: ldc2_w 285
    //   3024: lcmp
    //   3025: ifne +47 -> 3072
    //   3028: aload 9
    //   3030: ldc_w 1118
    //   3033: ldc2_w 111
    //   3036: invokevirtual 1121	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   3039: pop
    //   3040: aload 9
    //   3042: ldc_w 1123
    //   3045: iconst_1
    //   3046: invokevirtual 583	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   3049: pop
    //   3050: invokestatic 541	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   3053: ldc_w 1125
    //   3056: ldc_w 1127
    //   3059: aload 9
    //   3061: invokestatic 561	com/tencent/mm/br/c:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V
    //   3064: ldc_w 509
    //   3067: invokestatic 353	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3070: iconst_1
    //   3071: ireturn
    //   3072: lload 11
    //   3074: ldc2_w 289
    //   3077: lcmp
    //   3078: ifne +60 -> 3138
    //   3081: aload 9
    //   3083: ldc_w 1118
    //   3086: ldc2_w 1128
    //   3089: invokevirtual 1121	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   3092: pop
    //   3093: aload 9
    //   3095: ldc_w 1123
    //   3098: iconst_2
    //   3099: invokevirtual 583	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   3102: pop
    //   3103: aload 9
    //   3105: ldc_w 1131
    //   3108: bipush 8
    //   3110: invokevirtual 583	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   3113: pop
    //   3114: invokestatic 541	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   3117: ldc_w 1125
    //   3120: ldc_w 1133
    //   3123: aload 9
    //   3125: invokestatic 561	com/tencent/mm/br/c:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V
    //   3128: aload 14
    //   3130: astore_3
    //   3131: aload 9
    //   3133: astore 6
    //   3135: goto -3019 -> 116
    //   3138: lload 11
    //   3140: ldc2_w 293
    //   3143: lcmp
    //   3144: ifne +14 -> 3158
    //   3147: ldc_w 1135
    //   3150: astore_3
    //   3151: aload 9
    //   3153: astore 6
    //   3155: goto -3039 -> 116
    //   3158: lload 11
    //   3160: ldc2_w 297
    //   3163: lcmp
    //   3164: ifne +44 -> 3208
    //   3167: new 1137	com/tencent/mm/autogen/a/cw
    //   3170: dup
    //   3171: invokespecial 1138	com/tencent/mm/autogen/a/cw:<init>	()V
    //   3174: astore_0
    //   3175: aload_0
    //   3176: getfield 1142	com/tencent/mm/autogen/a/cw:hCN	Lcom/tencent/mm/autogen/a/cw$a;
    //   3179: ldc_w 1144
    //   3182: putfield 1149	com/tencent/mm/autogen/a/cw$a:hCP	Ljava/lang/String;
    //   3185: aload_0
    //   3186: getfield 1142	com/tencent/mm/autogen/a/cw:hCN	Lcom/tencent/mm/autogen/a/cw$a;
    //   3189: invokestatic 541	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   3192: putfield 1150	com/tencent/mm/autogen/a/cw$a:context	Landroid/content/Context;
    //   3195: aload_0
    //   3196: invokevirtual 1151	com/tencent/mm/autogen/a/cw:publish	()Z
    //   3199: pop
    //   3200: ldc_w 509
    //   3203: invokestatic 353	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3206: iconst_1
    //   3207: ireturn
    //   3208: lload 11
    //   3210: ldc2_w 301
    //   3213: lcmp
    //   3214: ifne +49 -> 3263
    //   3217: aload 9
    //   3219: ldc_w 976
    //   3222: iconst_1
    //   3223: invokevirtual 583	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   3226: pop
    //   3227: invokestatic 541	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   3230: ldc_w 978
    //   3233: ldc_w 980
    //   3236: aload 9
    //   3238: invokestatic 561	com/tencent/mm/br/c:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V
    //   3241: invokestatic 541	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   3244: ldc_w 978
    //   3247: ldc_w 1153
    //   3250: aload 9
    //   3252: invokestatic 561	com/tencent/mm/br/c:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V
    //   3255: ldc_w 509
    //   3258: invokestatic 353	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3261: iconst_1
    //   3262: ireturn
    //   3263: lload 11
    //   3265: ldc2_w 305
    //   3268: lcmp
    //   3269: ifne +65 -> 3334
    //   3272: aload 9
    //   3274: ldc_w 976
    //   3277: iconst_1
    //   3278: invokevirtual 583	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   3281: pop
    //   3282: invokestatic 541	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   3285: ldc_w 978
    //   3288: ldc_w 980
    //   3291: aload 9
    //   3293: invokestatic 561	com/tencent/mm/br/c:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V
    //   3296: invokestatic 541	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   3299: ldc_w 978
    //   3302: ldc_w 1153
    //   3305: aload 9
    //   3307: invokestatic 561	com/tencent/mm/br/c:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V
    //   3310: invokestatic 541	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   3313: ldc_w 978
    //   3316: ldc_w 1155
    //   3319: aload 9
    //   3321: invokestatic 561	com/tencent/mm/br/c:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V
    //   3324: aload 14
    //   3326: astore_3
    //   3327: aload 9
    //   3329: astore 6
    //   3331: goto -3215 -> 116
    //   3334: lload 11
    //   3336: ldc2_w 317
    //   3339: lcmp
    //   3340: ifne +112 -> 3452
    //   3343: aload 9
    //   3345: ldc_w 976
    //   3348: iconst_1
    //   3349: invokevirtual 583	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   3352: pop
    //   3353: aload 9
    //   3355: invokestatic 541	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   3358: ldc_w 1157
    //   3361: invokevirtual 545	android/content/Intent:setClassName	(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;
    //   3364: pop
    //   3365: invokestatic 541	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   3368: astore_1
    //   3369: new 1159	com/tencent/mm/hellhoundlib/b/a
    //   3372: dup
    //   3373: invokespecial 1160	com/tencent/mm/hellhoundlib/b/a:<init>	()V
    //   3376: aload 9
    //   3378: invokevirtual 1164	com/tencent/mm/hellhoundlib/b/a:cG	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   3381: astore_3
    //   3382: aload_1
    //   3383: aload_3
    //   3384: invokevirtual 1168	com/tencent/mm/hellhoundlib/b/a:aYi	()[Ljava/lang/Object;
    //   3387: ldc_w 1170
    //   3390: ldc_w 1172
    //   3393: ldc_w 1174
    //   3396: ldc_w 1176
    //   3399: ldc_w 1178
    //   3402: ldc_w 1180
    //   3405: invokestatic 1185	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3408: aload_1
    //   3409: aload_3
    //   3410: iconst_0
    //   3411: invokevirtual 1189	com/tencent/mm/hellhoundlib/b/a:sb	(I)Ljava/lang/Object;
    //   3414: checkcast 527	android/content/Intent
    //   3417: invokevirtual 1191	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   3420: aload_1
    //   3421: ldc_w 1170
    //   3424: ldc_w 1172
    //   3427: ldc_w 1174
    //   3430: ldc_w 1176
    //   3433: ldc_w 1178
    //   3436: ldc_w 1180
    //   3439: invokestatic 1194	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3442: aload 14
    //   3444: astore_3
    //   3445: aload 9
    //   3447: astore 6
    //   3449: goto -3333 -> 116
    //   3452: lload 11
    //   3454: ldc2_w 229
    //   3457: lcmp
    //   3458: ifne +14 -> 3472
    //   3461: ldc_w 1196
    //   3464: astore_3
    //   3465: aload 9
    //   3467: astore 6
    //   3469: goto -3353 -> 116
    //   3472: lload 11
    //   3474: ldc2_w 309
    //   3477: lcmp
    //   3478: ifne +45 -> 3523
    //   3481: aload 9
    //   3483: ldc_w 1198
    //   3486: iconst_1
    //   3487: invokevirtual 583	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   3490: pop
    //   3491: ldc_w 563
    //   3494: astore_3
    //   3495: getstatic 569	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   3498: sipush 12065
    //   3501: iconst_1
    //   3502: anewarray 4	java/lang/Object
    //   3505: dup
    //   3506: iconst_0
    //   3507: bipush 7
    //   3509: invokestatic 473	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3512: aastore
    //   3513: invokevirtual 572	com/tencent/mm/plugin/report/service/h:b	(I[Ljava/lang/Object;)V
    //   3516: aload 9
    //   3518: astore 6
    //   3520: goto -3404 -> 116
    //   3523: lload 11
    //   3525: ldc2_w 313
    //   3528: lcmp
    //   3529: ifne +14 -> 3543
    //   3532: ldc_w 1200
    //   3535: astore_3
    //   3536: aload 9
    //   3538: astore 6
    //   3540: goto -3424 -> 116
    //   3543: lload 11
    //   3545: ldc2_w 321
    //   3548: lcmp
    //   3549: ifne +1033 -> 4582
    //   3552: aload_1
    //   3553: invokestatic 601	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   3556: astore_1
    //   3557: aload_1
    //   3558: ldc_w 603
    //   3561: invokevirtual 606	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   3564: astore 5
    //   3566: aload_1
    //   3567: ldc_w 1202
    //   3570: invokevirtual 606	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   3573: astore 9
    //   3575: aload_1
    //   3576: ldc_w 1204
    //   3579: invokevirtual 606	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   3582: astore 14
    //   3584: aload_1
    //   3585: ldc_w 1206
    //   3588: invokevirtual 606	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   3591: invokestatic 901	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   3594: iconst_0
    //   3595: invokestatic 1209	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   3598: istore 10
    //   3600: aload_1
    //   3601: ldc_w 1211
    //   3604: invokevirtual 606	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   3607: astore 16
    //   3609: aload_1
    //   3610: ldc_w 1213
    //   3613: invokevirtual 606	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   3616: astore 17
    //   3618: aload_1
    //   3619: ldc_w 1215
    //   3622: invokevirtual 606	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   3625: astore 18
    //   3627: aload_1
    //   3628: ldc_w 1217
    //   3631: invokevirtual 606	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   3634: astore 19
    //   3636: aload_1
    //   3637: ldc_w 1219
    //   3640: invokevirtual 606	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   3643: iconst_0
    //   3644: invokestatic 1209	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   3647: istore 4
    //   3649: invokestatic 1225	com/tencent/mm/model/ad:bCb	()Lcom/tencent/mm/model/ad;
    //   3652: ldc_w 1227
    //   3655: iconst_0
    //   3656: invokevirtual 1231	com/tencent/mm/model/ad:M	(Ljava/lang/String;Z)Lcom/tencent/mm/model/ad$b;
    //   3659: astore_0
    //   3660: aload_0
    //   3661: ifnull +22 -> 3683
    //   3664: aload_0
    //   3665: ldc_w 1233
    //   3668: iconst_0
    //   3669: invokestatic 473	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3672: invokevirtual 1238	com/tencent/mm/model/ad$b:get	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   3675: checkcast 470	java/lang/Integer
    //   3678: invokevirtual 1241	java/lang/Integer:intValue	()I
    //   3681: istore 4
    //   3683: ldc_w 371
    //   3686: ldc_w 1243
    //   3689: iconst_5
    //   3690: anewarray 4	java/lang/Object
    //   3693: dup
    //   3694: iconst_0
    //   3695: aload 5
    //   3697: aastore
    //   3698: dup
    //   3699: iconst_1
    //   3700: aload 9
    //   3702: aastore
    //   3703: dup
    //   3704: iconst_2
    //   3705: aload 14
    //   3707: aastore
    //   3708: dup
    //   3709: iconst_3
    //   3710: iload_2
    //   3711: invokestatic 473	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3714: aastore
    //   3715: dup
    //   3716: iconst_4
    //   3717: iload 4
    //   3719: invokestatic 473	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3722: aastore
    //   3723: invokestatic 378	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   3726: invokestatic 1225	com/tencent/mm/model/ad:bCb	()Lcom/tencent/mm/model/ad;
    //   3729: ldc_w 1227
    //   3732: invokevirtual 1247	com/tencent/mm/model/ad:Jn	(Ljava/lang/String;)Lcom/tencent/mm/model/ad$b;
    //   3735: pop
    //   3736: new 1249	com/tencent/mm/plugin/appbrand/report/AppBrandStatObject
    //   3739: dup
    //   3740: invokespecial 1250	com/tencent/mm/plugin/appbrand/report/AppBrandStatObject:<init>	()V
    //   3743: astore 15
    //   3745: aload 8
    //   3747: invokestatic 369	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   3750: ifne +132 -> 3882
    //   3753: aload 15
    //   3755: aload 8
    //   3757: putfield 1253	com/tencent/mm/plugin/appbrand/report/AppBrandStatObject:hzx	Ljava/lang/String;
    //   3760: iload_2
    //   3761: iconst_2
    //   3762: if_icmpeq +9 -> 3771
    //   3765: iload_2
    //   3766: bipush 21
    //   3768: if_icmpne +146 -> 3914
    //   3771: new 1255	com/tencent/mm/plugin/appbrand/api/g
    //   3774: dup
    //   3775: invokespecial 1256	com/tencent/mm/plugin/appbrand/api/g:<init>	()V
    //   3778: astore_0
    //   3779: aload_0
    //   3780: aload 9
    //   3782: putfield 1258	com/tencent/mm/plugin/appbrand/api/g:username	Ljava/lang/String;
    //   3785: aload_0
    //   3786: iload 4
    //   3788: putfield 1261	com/tencent/mm/plugin/appbrand/api/g:euz	I
    //   3791: aload_0
    //   3792: iconst_0
    //   3793: putfield 1264	com/tencent/mm/plugin/appbrand/api/g:version	I
    //   3796: aload_0
    //   3797: aload 14
    //   3799: putfield 1267	com/tencent/mm/plugin/appbrand/api/g:qAF	Ljava/lang/String;
    //   3802: iload 7
    //   3804: ifle +91 -> 3895
    //   3807: aload_0
    //   3808: iload 7
    //   3810: putfield 1270	com/tencent/mm/plugin/appbrand/api/g:scene	I
    //   3813: aload 8
    //   3815: invokestatic 369	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   3818: ifne +87 -> 3905
    //   3821: aload_0
    //   3822: aload 8
    //   3824: putfield 1271	com/tencent/mm/plugin/appbrand/api/g:hzx	Ljava/lang/String;
    //   3827: aload_0
    //   3828: new 1273	com/tencent/mm/plugin/appbrand/config/AppBrandLaunchReferrer
    //   3831: dup
    //   3832: invokespecial 1274	com/tencent/mm/plugin/appbrand/config/AppBrandLaunchReferrer:<init>	()V
    //   3835: putfield 1278	com/tencent/mm/plugin/appbrand/api/g:qAO	Lcom/tencent/mm/plugin/appbrand/config/AppBrandLaunchReferrer;
    //   3838: aload_0
    //   3839: getfield 1278	com/tencent/mm/plugin/appbrand/api/g:qAO	Lcom/tencent/mm/plugin/appbrand/config/AppBrandLaunchReferrer;
    //   3842: aload 5
    //   3844: putfield 1281	com/tencent/mm/plugin/appbrand/config/AppBrandLaunchReferrer:appId	Ljava/lang/String;
    //   3847: aload_0
    //   3848: getfield 1278	com/tencent/mm/plugin/appbrand/api/g:qAO	Lcom/tencent/mm/plugin/appbrand/config/AppBrandLaunchReferrer;
    //   3851: bipush 8
    //   3853: putfield 1284	com/tencent/mm/plugin/appbrand/config/AppBrandLaunchReferrer:qYE	I
    //   3856: ldc_w 1286
    //   3859: invokestatic 1011	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   3862: checkcast 1286	com/tencent/mm/plugin/appbrand/service/t
    //   3865: invokestatic 541	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   3868: aload_0
    //   3869: invokeinterface 1289 3 0
    //   3874: ldc_w 509
    //   3877: invokestatic 353	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3880: iconst_1
    //   3881: ireturn
    //   3882: aload 15
    //   3884: aload 6
    //   3886: invokestatic 1291	java/net/URLEncoder:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   3889: putfield 1253	com/tencent/mm/plugin/appbrand/report/AppBrandStatObject:hzx	Ljava/lang/String;
    //   3892: goto -132 -> 3760
    //   3895: aload_0
    //   3896: sipush 1065
    //   3899: putfield 1270	com/tencent/mm/plugin/appbrand/api/g:scene	I
    //   3902: goto -89 -> 3813
    //   3905: aload_0
    //   3906: aload 5
    //   3908: putfield 1271	com/tencent/mm/plugin/appbrand/api/g:hzx	Ljava/lang/String;
    //   3911: goto -84 -> 3827
    //   3914: iload_2
    //   3915: iconst_1
    //   3916: if_icmpne +541 -> 4457
    //   3919: ldc_w 371
    //   3922: ldc_w 1293
    //   3925: iconst_2
    //   3926: anewarray 4	java/lang/Object
    //   3929: dup
    //   3930: iconst_0
    //   3931: iload 10
    //   3933: invokestatic 473	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3936: aastore
    //   3937: dup
    //   3938: iconst_1
    //   3939: aload 16
    //   3941: aastore
    //   3942: invokestatic 1295	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   3945: aload 16
    //   3947: invokestatic 369	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   3950: ifne +296 -> 4246
    //   3953: new 619	com/tencent/mm/ad/i
    //   3956: dup
    //   3957: aload 16
    //   3959: invokespecial 1296	com/tencent/mm/ad/i:<init>	(Ljava/lang/String;)V
    //   3962: astore_0
    //   3963: ldc_w 1298
    //   3966: invokestatic 1011	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   3969: checkcast 1298	com/tencent/mm/plugin/appbrand/service/s
    //   3972: aload 9
    //   3974: invokeinterface 1301 2 0
    //   3979: astore_3
    //   3980: aload_3
    //   3981: invokestatic 1306	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3984: ifne +241 -> 4225
    //   3987: ldc_w 1286
    //   3990: invokestatic 1011	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   3993: checkcast 1286	com/tencent/mm/plugin/appbrand/service/t
    //   3996: aload_3
    //   3997: iload 4
    //   3999: invokeinterface 1310 3 0
    //   4004: ifeq +221 -> 4225
    //   4007: getstatic 1316	com/tencent/threadpool/h:ahAA	Lcom/tencent/threadpool/i;
    //   4010: new 12	com/tencent/mm/pluginsdk/g$4
    //   4013: dup
    //   4014: aload_0
    //   4015: invokespecial 1319	com/tencent/mm/pluginsdk/g$4:<init>	(Lcom/tencent/mm/ad/i;)V
    //   4018: invokeinterface 1325 2 0
    //   4023: pop
    //   4024: aload_0
    //   4025: ldc_w 1327
    //   4028: invokevirtual 1330	com/tencent/mm/ad/i:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4031: astore_0
    //   4032: aload_0
    //   4033: invokestatic 369	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   4036: ifne +3287 -> 7323
    //   4039: new 619	com/tencent/mm/ad/i
    //   4042: dup
    //   4043: aload_0
    //   4044: invokespecial 1296	com/tencent/mm/ad/i:<init>	(Ljava/lang/String;)V
    //   4047: ldc_w 1332
    //   4050: invokevirtual 1330	com/tencent/mm/ad/i:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4053: astore_0
    //   4054: iconst_1
    //   4055: iload 10
    //   4057: if_icmpne +230 -> 4287
    //   4060: aload 16
    //   4062: invokestatic 369	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   4065: ifne +222 -> 4287
    //   4068: ldc 80
    //   4070: astore_1
    //   4071: new 619	com/tencent/mm/ad/i
    //   4074: dup
    //   4075: aload 16
    //   4077: invokespecial 1296	com/tencent/mm/ad/i:<init>	(Ljava/lang/String;)V
    //   4080: ldc_w 1334
    //   4083: invokevirtual 1330	com/tencent/mm/ad/i:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4086: astore_3
    //   4087: aload_3
    //   4088: astore_1
    //   4089: ldc_w 371
    //   4092: ldc_w 1336
    //   4095: iconst_4
    //   4096: anewarray 4	java/lang/Object
    //   4099: dup
    //   4100: iconst_0
    //   4101: aload 17
    //   4103: aastore
    //   4104: dup
    //   4105: iconst_1
    //   4106: aload 18
    //   4108: aastore
    //   4109: dup
    //   4110: iconst_2
    //   4111: aload 19
    //   4113: aastore
    //   4114: dup
    //   4115: iconst_3
    //   4116: aload_1
    //   4117: aastore
    //   4118: invokestatic 378	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4121: aload 15
    //   4123: sipush 1111
    //   4126: putfield 1337	com/tencent/mm/plugin/appbrand/report/AppBrandStatObject:scene	I
    //   4129: aload 15
    //   4131: new 37	java/lang/StringBuilder
    //   4134: dup
    //   4135: invokespecial 836	java/lang/StringBuilder:<init>	()V
    //   4138: aload 19
    //   4140: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4143: ldc_w 1339
    //   4146: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4149: aload_1
    //   4150: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4153: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4156: putfield 1253	com/tencent/mm/plugin/appbrand/report/AppBrandStatObject:hzx	Ljava/lang/String;
    //   4159: aload_0
    //   4160: invokestatic 369	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   4163: ifne +106 -> 4269
    //   4166: aload 15
    //   4168: ldc_w 1341
    //   4171: iconst_2
    //   4172: anewarray 4	java/lang/Object
    //   4175: dup
    //   4176: iconst_0
    //   4177: aload 15
    //   4179: getfield 1253	com/tencent/mm/plugin/appbrand/report/AppBrandStatObject:hzx	Ljava/lang/String;
    //   4182: aastore
    //   4183: dup
    //   4184: iconst_1
    //   4185: aload_0
    //   4186: aastore
    //   4187: invokestatic 1345	com/tencent/mm/sdk/platformtools/Util:safeFormatString	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   4190: putfield 1253	com/tencent/mm/plugin/appbrand/report/AppBrandStatObject:hzx	Ljava/lang/String;
    //   4193: ldc_w 1286
    //   4196: invokestatic 1011	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   4199: checkcast 1286	com/tencent/mm/plugin/appbrand/service/t
    //   4202: invokestatic 541	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   4205: aload 9
    //   4207: iload 4
    //   4209: aload 14
    //   4211: aload 15
    //   4213: aload 5
    //   4215: aload 16
    //   4217: invokeinterface 1348 8 0
    //   4222: goto -348 -> 3874
    //   4225: aload_0
    //   4226: invokestatic 1350	com/tencent/mm/pluginsdk/g:d	(Lcom/tencent/mm/ad/i;)V
    //   4229: goto -205 -> 4024
    //   4232: astore_0
    //   4233: ldc_w 371
    //   4236: aload_0
    //   4237: ldc 80
    //   4239: iconst_0
    //   4240: anewarray 4	java/lang/Object
    //   4243: invokestatic 654	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4246: ldc 80
    //   4248: astore_0
    //   4249: goto -195 -> 4054
    //   4252: astore_3
    //   4253: ldc_w 371
    //   4256: aload_3
    //   4257: ldc 80
    //   4259: iconst_0
    //   4260: anewarray 4	java/lang/Object
    //   4263: invokestatic 654	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4266: goto -177 -> 4089
    //   4269: aload 8
    //   4271: invokestatic 369	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   4274: ifne -81 -> 4193
    //   4277: aload 15
    //   4279: aload 8
    //   4281: putfield 1253	com/tencent/mm/plugin/appbrand/report/AppBrandStatObject:hzx	Ljava/lang/String;
    //   4284: goto -91 -> 4193
    //   4287: aload_1
    //   4288: ldc_w 1352
    //   4291: invokevirtual 606	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   4294: astore_1
    //   4295: new 1255	com/tencent/mm/plugin/appbrand/api/g
    //   4298: dup
    //   4299: invokespecial 1256	com/tencent/mm/plugin/appbrand/api/g:<init>	()V
    //   4302: astore_3
    //   4303: aload_3
    //   4304: aload 9
    //   4306: putfield 1258	com/tencent/mm/plugin/appbrand/api/g:username	Ljava/lang/String;
    //   4309: aload_3
    //   4310: iload 4
    //   4312: putfield 1261	com/tencent/mm/plugin/appbrand/api/g:euz	I
    //   4315: aload_3
    //   4316: iconst_0
    //   4317: putfield 1264	com/tencent/mm/plugin/appbrand/api/g:version	I
    //   4320: aload_3
    //   4321: aload 14
    //   4323: putfield 1267	com/tencent/mm/plugin/appbrand/api/g:qAF	Ljava/lang/String;
    //   4326: iconst_3
    //   4327: iload 10
    //   4329: if_icmpne +100 -> 4429
    //   4332: aload_3
    //   4333: sipush 1113
    //   4336: putfield 1270	com/tencent/mm/plugin/appbrand/api/g:scene	I
    //   4339: aload_3
    //   4340: aload 5
    //   4342: putfield 1271	com/tencent/mm/plugin/appbrand/api/g:hzx	Ljava/lang/String;
    //   4345: aload_0
    //   4346: invokestatic 369	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   4349: ifne +90 -> 4439
    //   4352: aload_3
    //   4353: ldc_w 1341
    //   4356: iconst_2
    //   4357: anewarray 4	java/lang/Object
    //   4360: dup
    //   4361: iconst_0
    //   4362: aload 5
    //   4364: aastore
    //   4365: dup
    //   4366: iconst_1
    //   4367: aload_0
    //   4368: aastore
    //   4369: invokestatic 1345	com/tencent/mm/sdk/platformtools/Util:safeFormatString	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   4372: putfield 1271	com/tencent/mm/plugin/appbrand/api/g:hzx	Ljava/lang/String;
    //   4375: aload_3
    //   4376: aload_1
    //   4377: putfield 1355	com/tencent/mm/plugin/appbrand/api/g:qAN	Ljava/lang/String;
    //   4380: aload_3
    //   4381: new 1273	com/tencent/mm/plugin/appbrand/config/AppBrandLaunchReferrer
    //   4384: dup
    //   4385: invokespecial 1274	com/tencent/mm/plugin/appbrand/config/AppBrandLaunchReferrer:<init>	()V
    //   4388: putfield 1278	com/tencent/mm/plugin/appbrand/api/g:qAO	Lcom/tencent/mm/plugin/appbrand/config/AppBrandLaunchReferrer;
    //   4391: aload_3
    //   4392: getfield 1278	com/tencent/mm/plugin/appbrand/api/g:qAO	Lcom/tencent/mm/plugin/appbrand/config/AppBrandLaunchReferrer;
    //   4395: aload 5
    //   4397: putfield 1281	com/tencent/mm/plugin/appbrand/config/AppBrandLaunchReferrer:appId	Ljava/lang/String;
    //   4400: aload_3
    //   4401: getfield 1278	com/tencent/mm/plugin/appbrand/api/g:qAO	Lcom/tencent/mm/plugin/appbrand/config/AppBrandLaunchReferrer;
    //   4404: iconst_4
    //   4405: putfield 1284	com/tencent/mm/plugin/appbrand/config/AppBrandLaunchReferrer:qYE	I
    //   4408: ldc_w 1286
    //   4411: invokestatic 1011	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   4414: checkcast 1286	com/tencent/mm/plugin/appbrand/service/t
    //   4417: invokestatic 541	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   4420: aload_3
    //   4421: invokeinterface 1289 3 0
    //   4426: goto -552 -> 3874
    //   4429: aload_3
    //   4430: sipush 1069
    //   4433: putfield 1270	com/tencent/mm/plugin/appbrand/api/g:scene	I
    //   4436: goto -97 -> 4339
    //   4439: aload 8
    //   4441: invokestatic 369	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   4444: ifne -69 -> 4375
    //   4447: aload 15
    //   4449: aload 8
    //   4451: putfield 1253	com/tencent/mm/plugin/appbrand/report/AppBrandStatObject:hzx	Ljava/lang/String;
    //   4454: goto -79 -> 4375
    //   4457: iload_2
    //   4458: bipush 6
    //   4460: if_icmpne +41 -> 4501
    //   4463: aload 15
    //   4465: sipush 1007
    //   4468: putfield 1337	com/tencent/mm/plugin/appbrand/report/AppBrandStatObject:scene	I
    //   4471: ldc_w 1286
    //   4474: invokestatic 1011	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   4477: checkcast 1286	com/tencent/mm/plugin/appbrand/service/t
    //   4480: invokestatic 541	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   4483: aload 9
    //   4485: aconst_null
    //   4486: iload 4
    //   4488: iconst_0
    //   4489: aload 14
    //   4491: aload 15
    //   4493: invokeinterface 1358 8 0
    //   4498: goto -624 -> 3874
    //   4501: iload_2
    //   4502: bipush 7
    //   4504: if_icmpne +41 -> 4545
    //   4507: aload 15
    //   4509: sipush 1008
    //   4512: putfield 1337	com/tencent/mm/plugin/appbrand/report/AppBrandStatObject:scene	I
    //   4515: ldc_w 1286
    //   4518: invokestatic 1011	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   4521: checkcast 1286	com/tencent/mm/plugin/appbrand/service/t
    //   4524: invokestatic 541	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   4527: aload 9
    //   4529: aconst_null
    //   4530: iload 4
    //   4532: iconst_0
    //   4533: aload 14
    //   4535: aload 15
    //   4537: invokeinterface 1358 8 0
    //   4542: goto -668 -> 3874
    //   4545: aload 15
    //   4547: sipush 1000
    //   4550: putfield 1337	com/tencent/mm/plugin/appbrand/report/AppBrandStatObject:scene	I
    //   4553: ldc_w 1286
    //   4556: invokestatic 1011	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   4559: checkcast 1286	com/tencent/mm/plugin/appbrand/service/t
    //   4562: invokestatic 541	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   4565: aload 9
    //   4567: aconst_null
    //   4568: iconst_0
    //   4569: iconst_0
    //   4570: aload 14
    //   4572: aload 15
    //   4574: invokeinterface 1358 8 0
    //   4579: goto -705 -> 3874
    //   4582: lload 11
    //   4584: ldc2_w 325
    //   4587: lcmp
    //   4588: ifne +101 -> 4689
    //   4591: aload_1
    //   4592: invokestatic 601	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   4595: ldc_w 603
    //   4598: invokevirtual 606	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   4601: astore_1
    //   4602: new 527	android/content/Intent
    //   4605: dup
    //   4606: invokespecial 528	android/content/Intent:<init>	()V
    //   4609: astore 5
    //   4611: ldc_w 1360
    //   4614: ldc_w 1362
    //   4617: iconst_1
    //   4618: anewarray 4	java/lang/Object
    //   4621: dup
    //   4622: iconst_0
    //   4623: aload_1
    //   4624: aastore
    //   4625: invokestatic 1295	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4628: aload 14
    //   4630: astore_3
    //   4631: aload 9
    //   4633: astore 6
    //   4635: getstatic 1368	com/tencent/mm/sdk/platformtools/WeChatBrands$Business$Entries:PaymentOpenSdk	Lcom/tencent/mm/sdk/platformtools/WeChatBrands$Business$Entries;
    //   4638: aload_0
    //   4639: invokevirtual 1372	com/tencent/mm/sdk/platformtools/WeChatBrands$Business$Entries:checkAvailable	(Landroid/content/Context;)Z
    //   4642: ifeq -4526 -> 116
    //   4645: aload 5
    //   4647: ldc_w 1374
    //   4650: bipush 8
    //   4652: invokevirtual 583	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   4655: pop
    //   4656: aload 5
    //   4658: ldc_w 1376
    //   4661: aload_1
    //   4662: invokevirtual 717	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   4665: pop
    //   4666: aload_0
    //   4667: ldc_w 1378
    //   4670: ldc_w 1380
    //   4673: aload 5
    //   4675: iconst_0
    //   4676: invokestatic 1383	com/tencent/mm/br/c:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;I)V
    //   4679: aload 14
    //   4681: astore_3
    //   4682: aload 9
    //   4684: astore 6
    //   4686: goto -4570 -> 116
    //   4689: aload 14
    //   4691: astore_3
    //   4692: aload 9
    //   4694: astore 6
    //   4696: lload 11
    //   4698: ldc2_w 345
    //   4701: lcmp
    //   4702: ifne -4586 -> 116
    //   4705: aload_1
    //   4706: invokestatic 601	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   4709: ldc_w 1385
    //   4712: invokevirtual 606	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   4715: astore_1
    //   4716: new 1387	com/tencent/mm/openim/api/OpenIMKefuStartConversationRequest
    //   4719: dup
    //   4720: invokespecial 1388	com/tencent/mm/openim/api/OpenIMKefuStartConversationRequest:<init>	()V
    //   4723: astore_3
    //   4724: aload_3
    //   4725: invokestatic 1393	java/lang/System:currentTimeMillis	()J
    //   4728: putfield 1397	com/tencent/mm/openim/api/OpenIMKefuStartConversationRequest:hBk	J
    //   4731: aload_3
    //   4732: bipush 6
    //   4734: putfield 1400	com/tencent/mm/openim/api/OpenIMKefuStartConversationRequest:prw	I
    //   4737: aload_3
    //   4738: aload_0
    //   4739: putfield 1401	com/tencent/mm/openim/api/OpenIMKefuStartConversationRequest:context	Landroid/content/Context;
    //   4742: aload_3
    //   4743: new 1403	com/tencent/mm/protocal/protobuf/du
    //   4746: dup
    //   4747: invokespecial 1404	com/tencent/mm/protocal/protobuf/du:<init>	()V
    //   4750: putfield 1408	com/tencent/mm/openim/api/OpenIMKefuStartConversationRequest:pry	Lcom/tencent/mm/protocal/protobuf/du;
    //   4753: aload_3
    //   4754: getfield 1408	com/tencent/mm/openim/api/OpenIMKefuStartConversationRequest:pry	Lcom/tencent/mm/protocal/protobuf/du;
    //   4757: aload_1
    //   4758: putfield 1409	com/tencent/mm/protocal/protobuf/du:url	Ljava/lang/String;
    //   4761: aload_3
    //   4762: getfield 1408	com/tencent/mm/openim/api/OpenIMKefuStartConversationRequest:pry	Lcom/tencent/mm/protocal/protobuf/du;
    //   4765: aload_1
    //   4766: putfield 1412	com/tencent/mm/protocal/protobuf/du:YFV	Ljava/lang/String;
    //   4769: aload_3
    //   4770: iconst_1
    //   4771: putfield 1415	com/tencent/mm/openim/api/OpenIMKefuStartConversationRequest:prz	Z
    //   4774: aload_3
    //   4775: aload_3
    //   4776: getfield 1401	com/tencent/mm/openim/api/OpenIMKefuStartConversationRequest:context	Landroid/content/Context;
    //   4779: getstatic 1418	com/tencent/mm/plugin/biz/b$f:open_im_kefu_start_conversation_error_tips	I
    //   4782: invokevirtual 739	android/content/Context:getString	(I)Ljava/lang/String;
    //   4785: putfield 1421	com/tencent/mm/openim/api/OpenIMKefuStartConversationRequest:prA	Ljava/lang/String;
    //   4788: aload_3
    //   4789: aload_3
    //   4790: getfield 1400	com/tencent/mm/openim/api/OpenIMKefuStartConversationRequest:prw	I
    //   4793: invokestatic 1427	com/tencent/mm/openim/api/h$a:xD	(I)I
    //   4796: putfield 1430	com/tencent/mm/openim/api/OpenIMKefuStartConversationRequest:prx	I
    //   4799: aload_3
    //   4800: iconst_1
    //   4801: putfield 1433	com/tencent/mm/openim/api/OpenIMKefuStartConversationRequest:prB	Z
    //   4804: aload_3
    //   4805: iconst_1
    //   4806: putfield 1436	com/tencent/mm/openim/api/OpenIMKefuStartConversationRequest:prD	Z
    //   4809: ldc_w 1438
    //   4812: invokestatic 1011	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   4815: checkcast 1438	com/tencent/mm/openim/api/d
    //   4818: aload_3
    //   4819: invokeinterface 1441 2 0
    //   4824: aload 14
    //   4826: astore_3
    //   4827: aload 9
    //   4829: astore 6
    //   4831: goto -4715 -> 116
    //   4834: new 1159	com/tencent/mm/hellhoundlib/b/a
    //   4837: dup
    //   4838: invokespecial 1160	com/tencent/mm/hellhoundlib/b/a:<init>	()V
    //   4841: aload 6
    //   4843: invokevirtual 1164	com/tencent/mm/hellhoundlib/b/a:cG	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   4846: astore_1
    //   4847: aload_0
    //   4848: aload_1
    //   4849: invokevirtual 1168	com/tencent/mm/hellhoundlib/b/a:aYi	()[Ljava/lang/Object;
    //   4852: ldc_w 1170
    //   4855: ldc_w 1172
    //   4858: ldc_w 1174
    //   4861: ldc_w 1176
    //   4864: ldc_w 1178
    //   4867: ldc_w 1180
    //   4870: invokestatic 1185	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   4873: aload_0
    //   4874: aload_1
    //   4875: iconst_0
    //   4876: invokevirtual 1189	com/tencent/mm/hellhoundlib/b/a:sb	(I)Ljava/lang/Object;
    //   4879: checkcast 527	android/content/Intent
    //   4882: invokevirtual 1191	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   4885: aload_0
    //   4886: ldc_w 1170
    //   4889: ldc_w 1172
    //   4892: ldc_w 1174
    //   4895: ldc_w 1176
    //   4898: ldc_w 1178
    //   4901: ldc_w 1180
    //   4904: invokestatic 1194	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   4907: goto -4748 -> 159
    //   4910: astore_0
    //   4911: ldc_w 371
    //   4914: aload_0
    //   4915: ldc 80
    //   4917: iconst_1
    //   4918: anewarray 4	java/lang/Object
    //   4921: dup
    //   4922: iconst_0
    //   4923: ldc 80
    //   4925: aastore
    //   4926: invokestatic 654	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4929: goto -4770 -> 159
    //   4932: aload_3
    //   4933: ldc_w 547
    //   4936: invokevirtual 551	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   4939: ifeq +28 -> 4967
    //   4942: invokestatic 541	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   4945: ldc_w 553
    //   4948: ldc_w 555
    //   4951: aload 6
    //   4953: invokestatic 561	com/tencent/mm/br/c:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V
    //   4956: invokestatic 541	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   4959: aload 6
    //   4961: invokestatic 1446	com/tencent/mm/ui/base/b:aR	(Landroid/content/Context;Landroid/content/Intent;)V
    //   4964: goto -4805 -> 159
    //   4967: invokestatic 541	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   4970: astore_0
    //   4971: new 1159	com/tencent/mm/hellhoundlib/b/a
    //   4974: dup
    //   4975: invokespecial 1160	com/tencent/mm/hellhoundlib/b/a:<init>	()V
    //   4978: aload 6
    //   4980: invokevirtual 1164	com/tencent/mm/hellhoundlib/b/a:cG	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   4983: astore_1
    //   4984: aload_0
    //   4985: aload_1
    //   4986: invokevirtual 1168	com/tencent/mm/hellhoundlib/b/a:aYi	()[Ljava/lang/Object;
    //   4989: ldc_w 1170
    //   4992: ldc_w 1172
    //   4995: ldc_w 1174
    //   4998: ldc_w 1176
    //   5001: ldc_w 1178
    //   5004: ldc_w 1180
    //   5007: invokestatic 1185	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   5010: aload_0
    //   5011: aload_1
    //   5012: iconst_0
    //   5013: invokevirtual 1189	com/tencent/mm/hellhoundlib/b/a:sb	(I)Ljava/lang/Object;
    //   5016: checkcast 527	android/content/Intent
    //   5019: invokevirtual 1191	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   5022: aload_0
    //   5023: ldc_w 1170
    //   5026: ldc_w 1172
    //   5029: ldc_w 1174
    //   5032: ldc_w 1176
    //   5035: ldc_w 1178
    //   5038: ldc_w 1180
    //   5041: invokestatic 1194	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   5044: goto -88 -> 4956
    //   5047: ldc_w 509
    //   5050: invokestatic 353	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   5053: iconst_0
    //   5054: ireturn
    //   5055: aload 14
    //   5057: ldc_w 1448
    //   5060: invokevirtual 444	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   5063: ifeq +428 -> 5491
    //   5066: new 527	android/content/Intent
    //   5069: dup
    //   5070: invokespecial 528	android/content/Intent:<init>	()V
    //   5073: astore 5
    //   5075: aload 5
    //   5077: ldc_w 529
    //   5080: invokevirtual 533	android/content/Intent:setFlags	(I)Landroid/content/Intent;
    //   5083: pop
    //   5084: aload_1
    //   5085: invokestatic 601	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   5088: astore 6
    //   5090: aload 6
    //   5092: ifnonnull +20 -> 5112
    //   5095: ldc_w 371
    //   5098: ldc_w 1450
    //   5101: invokestatic 1452	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   5104: ldc_w 509
    //   5107: invokestatic 353	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   5110: iconst_0
    //   5111: ireturn
    //   5112: aload 6
    //   5114: ldc_w 1454
    //   5117: invokevirtual 606	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   5120: astore 8
    //   5122: aload 6
    //   5124: ldc_w 1456
    //   5127: invokevirtual 606	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   5130: astore 9
    //   5132: aload 6
    //   5134: ldc_w 608
    //   5137: invokevirtual 606	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   5140: astore_3
    //   5141: aload_3
    //   5142: invokestatic 369	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   5145: ifeq +2175 -> 7320
    //   5148: aload 6
    //   5150: ldc_w 1202
    //   5153: invokevirtual 606	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   5156: astore_3
    //   5157: aload_3
    //   5158: invokestatic 369	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   5161: ifeq +20 -> 5181
    //   5164: ldc_w 371
    //   5167: ldc_w 1458
    //   5170: invokestatic 1452	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   5173: ldc_w 509
    //   5176: invokestatic 353	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   5179: iconst_0
    //   5180: ireturn
    //   5181: aload 6
    //   5183: ldc_w 1459
    //   5186: invokevirtual 606	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   5189: invokestatic 901	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   5192: iconst_0
    //   5193: invokestatic 1209	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   5196: istore 7
    //   5198: iload_2
    //   5199: istore 4
    //   5201: iload 7
    //   5203: ifeq +32 -> 5235
    //   5206: iload_2
    //   5207: istore 4
    //   5209: iload_2
    //   5210: iconst_4
    //   5211: if_icmpne +24 -> 5235
    //   5214: ldc_w 371
    //   5217: ldc_w 1461
    //   5220: iload 7
    //   5222: invokestatic 1463	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   5225: invokevirtual 1466	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   5228: invokestatic 1041	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   5231: iload 7
    //   5233: istore 4
    //   5235: ldc_w 371
    //   5238: ldc_w 1468
    //   5241: iconst_5
    //   5242: anewarray 4	java/lang/Object
    //   5245: dup
    //   5246: iconst_0
    //   5247: aload_3
    //   5248: aastore
    //   5249: dup
    //   5250: iconst_1
    //   5251: aload 8
    //   5253: aastore
    //   5254: dup
    //   5255: iconst_2
    //   5256: iload 4
    //   5258: invokestatic 473	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   5261: aastore
    //   5262: dup
    //   5263: iconst_3
    //   5264: aload_1
    //   5265: aastore
    //   5266: dup
    //   5267: iconst_4
    //   5268: aload 9
    //   5270: aastore
    //   5271: invokestatic 378	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5274: aload 5
    //   5276: invokestatic 541	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   5279: ldc_w 1470
    //   5282: invokevirtual 545	android/content/Intent:setClassName	(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;
    //   5285: pop
    //   5286: aload 5
    //   5288: ldc_w 1472
    //   5291: aload_3
    //   5292: invokevirtual 717	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   5295: pop
    //   5296: aload 5
    //   5298: ldc_w 1474
    //   5301: iconst_1
    //   5302: invokevirtual 578	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   5305: pop
    //   5306: aload 5
    //   5308: ldc_w 1476
    //   5311: iconst_1
    //   5312: invokevirtual 578	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   5315: pop
    //   5316: aload 5
    //   5318: ldc_w 1478
    //   5321: aload 8
    //   5323: invokevirtual 717	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   5326: pop
    //   5327: aload 5
    //   5329: ldc_w 1480
    //   5332: iload 4
    //   5334: invokevirtual 583	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   5337: pop
    //   5338: aload 5
    //   5340: ldc_w 1482
    //   5343: aload 9
    //   5345: iconst_0
    //   5346: invokestatic 1209	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   5349: invokevirtual 583	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   5352: pop
    //   5353: ldc_w 1484
    //   5356: invokestatic 1011	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   5359: checkcast 1484	com/tencent/mm/plugin/messenger/foundation/a/n
    //   5362: invokeinterface 1488 1 0
    //   5367: aload_3
    //   5368: invokeinterface 1494 2 0
    //   5373: astore_1
    //   5374: aload_1
    //   5375: ifnull +11 -> 5386
    //   5378: aload_1
    //   5379: getfield 1499	com/tencent/mm/contact/d:maN	J
    //   5382: l2i
    //   5383: ifgt +32 -> 5415
    //   5386: invokestatic 1505	com/tencent/mm/model/az$a:bCk	()Lcom/tencent/mm/model/az$b;
    //   5389: aload_3
    //   5390: ldc 80
    //   5392: new 1507	com/tencent/mm/pluginsdk/g$5
    //   5395: dup
    //   5396: aload 5
    //   5398: aload_0
    //   5399: invokespecial 1510	com/tencent/mm/pluginsdk/g$5:<init>	(Landroid/content/Intent;Landroid/content/Context;)V
    //   5402: invokeinterface 1515 4 0
    //   5407: ldc_w 509
    //   5410: invokestatic 353	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   5413: iconst_1
    //   5414: ireturn
    //   5415: new 1159	com/tencent/mm/hellhoundlib/b/a
    //   5418: dup
    //   5419: invokespecial 1160	com/tencent/mm/hellhoundlib/b/a:<init>	()V
    //   5422: aload 5
    //   5424: invokevirtual 1164	com/tencent/mm/hellhoundlib/b/a:cG	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   5427: astore_1
    //   5428: aload_0
    //   5429: aload_1
    //   5430: invokevirtual 1168	com/tencent/mm/hellhoundlib/b/a:aYi	()[Ljava/lang/Object;
    //   5433: ldc_w 1170
    //   5436: ldc_w 1172
    //   5439: ldc_w 1174
    //   5442: ldc_w 1176
    //   5445: ldc_w 1178
    //   5448: ldc_w 1180
    //   5451: invokestatic 1185	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   5454: aload_0
    //   5455: aload_1
    //   5456: iconst_0
    //   5457: invokevirtual 1189	com/tencent/mm/hellhoundlib/b/a:sb	(I)Ljava/lang/Object;
    //   5460: checkcast 527	android/content/Intent
    //   5463: invokevirtual 1191	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   5466: aload_0
    //   5467: ldc_w 1170
    //   5470: ldc_w 1172
    //   5473: ldc_w 1174
    //   5476: ldc_w 1176
    //   5479: ldc_w 1178
    //   5482: ldc_w 1180
    //   5485: invokestatic 1194	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   5488: goto -81 -> 5407
    //   5491: aload 14
    //   5493: ldc_w 1517
    //   5496: invokevirtual 444	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   5499: ifne +14 -> 5513
    //   5502: aload 14
    //   5504: ldc_w 1519
    //   5507: invokevirtual 444	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   5510: ifeq +283 -> 5793
    //   5513: ldc_w 371
    //   5516: ldc_w 1521
    //   5519: invokestatic 1041	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   5522: aload_1
    //   5523: invokestatic 601	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   5526: astore 5
    //   5528: aconst_null
    //   5529: astore_1
    //   5530: new 527	android/content/Intent
    //   5533: dup
    //   5534: invokespecial 528	android/content/Intent:<init>	()V
    //   5537: astore_3
    //   5538: aload 5
    //   5540: ifnull +37 -> 5577
    //   5543: aload 5
    //   5545: ldc_w 603
    //   5548: invokevirtual 606	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   5551: astore 5
    //   5553: ldc_w 1523
    //   5556: astore_1
    //   5557: aload_3
    //   5558: ldc_w 1525
    //   5561: aload 5
    //   5563: invokevirtual 717	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   5566: pop
    //   5567: aload_3
    //   5568: ldc_w 580
    //   5571: bipush 6
    //   5573: invokevirtual 583	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   5576: pop
    //   5577: aload_1
    //   5578: invokestatic 369	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   5581: ifne +204 -> 5785
    //   5584: aload_3
    //   5585: invokestatic 541	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   5588: aload_1
    //   5589: invokevirtual 545	android/content/Intent:setClassName	(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;
    //   5592: pop
    //   5593: aload_0
    //   5594: ifnull +83 -> 5677
    //   5597: new 1159	com/tencent/mm/hellhoundlib/b/a
    //   5600: dup
    //   5601: invokespecial 1160	com/tencent/mm/hellhoundlib/b/a:<init>	()V
    //   5604: aload_3
    //   5605: invokevirtual 1164	com/tencent/mm/hellhoundlib/b/a:cG	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   5608: astore_1
    //   5609: aload_0
    //   5610: aload_1
    //   5611: invokevirtual 1168	com/tencent/mm/hellhoundlib/b/a:aYi	()[Ljava/lang/Object;
    //   5614: ldc_w 1170
    //   5617: ldc_w 1172
    //   5620: ldc_w 1174
    //   5623: ldc_w 1176
    //   5626: ldc_w 1178
    //   5629: ldc_w 1180
    //   5632: invokestatic 1185	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   5635: aload_0
    //   5636: aload_1
    //   5637: iconst_0
    //   5638: invokevirtual 1189	com/tencent/mm/hellhoundlib/b/a:sb	(I)Ljava/lang/Object;
    //   5641: checkcast 527	android/content/Intent
    //   5644: invokevirtual 1191	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   5647: aload_0
    //   5648: ldc_w 1170
    //   5651: ldc_w 1172
    //   5654: ldc_w 1174
    //   5657: ldc_w 1176
    //   5660: ldc_w 1178
    //   5663: ldc_w 1180
    //   5666: invokestatic 1194	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   5669: ldc_w 509
    //   5672: invokestatic 353	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   5675: iconst_1
    //   5676: ireturn
    //   5677: invokestatic 541	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   5680: astore_0
    //   5681: new 1159	com/tencent/mm/hellhoundlib/b/a
    //   5684: dup
    //   5685: invokespecial 1160	com/tencent/mm/hellhoundlib/b/a:<init>	()V
    //   5688: aload_3
    //   5689: invokevirtual 1164	com/tencent/mm/hellhoundlib/b/a:cG	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   5692: astore_1
    //   5693: aload_0
    //   5694: aload_1
    //   5695: invokevirtual 1168	com/tencent/mm/hellhoundlib/b/a:aYi	()[Ljava/lang/Object;
    //   5698: ldc_w 1170
    //   5701: ldc_w 1172
    //   5704: ldc_w 1174
    //   5707: ldc_w 1176
    //   5710: ldc_w 1178
    //   5713: ldc_w 1180
    //   5716: invokestatic 1185	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   5719: aload_0
    //   5720: aload_1
    //   5721: iconst_0
    //   5722: invokevirtual 1189	com/tencent/mm/hellhoundlib/b/a:sb	(I)Ljava/lang/Object;
    //   5725: checkcast 527	android/content/Intent
    //   5728: invokevirtual 1191	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   5731: aload_0
    //   5732: ldc_w 1170
    //   5735: ldc_w 1172
    //   5738: ldc_w 1174
    //   5741: ldc_w 1176
    //   5744: ldc_w 1178
    //   5747: ldc_w 1180
    //   5750: invokestatic 1194	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   5753: invokestatic 541	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   5756: aload_3
    //   5757: invokestatic 1446	com/tencent/mm/ui/base/b:aR	(Landroid/content/Context;Landroid/content/Intent;)V
    //   5760: goto -91 -> 5669
    //   5763: astore_0
    //   5764: ldc_w 371
    //   5767: aload_0
    //   5768: ldc 80
    //   5770: iconst_1
    //   5771: anewarray 4	java/lang/Object
    //   5774: dup
    //   5775: iconst_0
    //   5776: ldc 80
    //   5778: aastore
    //   5779: invokestatic 654	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5782: goto -113 -> 5669
    //   5785: ldc_w 509
    //   5788: invokestatic 353	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   5791: iconst_0
    //   5792: ireturn
    //   5793: aload 14
    //   5795: ldc_w 1527
    //   5798: invokevirtual 444	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   5801: ifne +14 -> 5815
    //   5804: aload 14
    //   5806: ldc_w 1529
    //   5809: invokevirtual 444	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   5812: ifeq +250 -> 6062
    //   5815: ldc_w 371
    //   5818: ldc_w 1531
    //   5821: invokestatic 1041	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   5824: new 527	android/content/Intent
    //   5827: dup
    //   5828: invokespecial 528	android/content/Intent:<init>	()V
    //   5831: astore_1
    //   5832: ldc_w 1533
    //   5835: invokestatic 369	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   5838: ifne +216 -> 6054
    //   5841: aload_1
    //   5842: ldc_w 580
    //   5845: bipush 6
    //   5847: invokevirtual 583	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   5850: pop
    //   5851: aload_1
    //   5852: invokestatic 541	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   5855: ldc_w 1533
    //   5858: invokevirtual 545	android/content/Intent:setClassName	(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;
    //   5861: pop
    //   5862: aload_0
    //   5863: ifnull +83 -> 5946
    //   5866: new 1159	com/tencent/mm/hellhoundlib/b/a
    //   5869: dup
    //   5870: invokespecial 1160	com/tencent/mm/hellhoundlib/b/a:<init>	()V
    //   5873: aload_1
    //   5874: invokevirtual 1164	com/tencent/mm/hellhoundlib/b/a:cG	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   5877: astore_1
    //   5878: aload_0
    //   5879: aload_1
    //   5880: invokevirtual 1168	com/tencent/mm/hellhoundlib/b/a:aYi	()[Ljava/lang/Object;
    //   5883: ldc_w 1170
    //   5886: ldc_w 1172
    //   5889: ldc_w 1174
    //   5892: ldc_w 1176
    //   5895: ldc_w 1178
    //   5898: ldc_w 1180
    //   5901: invokestatic 1185	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   5904: aload_0
    //   5905: aload_1
    //   5906: iconst_0
    //   5907: invokevirtual 1189	com/tencent/mm/hellhoundlib/b/a:sb	(I)Ljava/lang/Object;
    //   5910: checkcast 527	android/content/Intent
    //   5913: invokevirtual 1191	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   5916: aload_0
    //   5917: ldc_w 1170
    //   5920: ldc_w 1172
    //   5923: ldc_w 1174
    //   5926: ldc_w 1176
    //   5929: ldc_w 1178
    //   5932: ldc_w 1180
    //   5935: invokestatic 1194	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   5938: ldc_w 509
    //   5941: invokestatic 353	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   5944: iconst_1
    //   5945: ireturn
    //   5946: invokestatic 541	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   5949: astore_0
    //   5950: new 1159	com/tencent/mm/hellhoundlib/b/a
    //   5953: dup
    //   5954: invokespecial 1160	com/tencent/mm/hellhoundlib/b/a:<init>	()V
    //   5957: aload_1
    //   5958: invokevirtual 1164	com/tencent/mm/hellhoundlib/b/a:cG	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   5961: astore_3
    //   5962: aload_0
    //   5963: aload_3
    //   5964: invokevirtual 1168	com/tencent/mm/hellhoundlib/b/a:aYi	()[Ljava/lang/Object;
    //   5967: ldc_w 1170
    //   5970: ldc_w 1172
    //   5973: ldc_w 1174
    //   5976: ldc_w 1176
    //   5979: ldc_w 1178
    //   5982: ldc_w 1180
    //   5985: invokestatic 1185	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   5988: aload_0
    //   5989: aload_3
    //   5990: iconst_0
    //   5991: invokevirtual 1189	com/tencent/mm/hellhoundlib/b/a:sb	(I)Ljava/lang/Object;
    //   5994: checkcast 527	android/content/Intent
    //   5997: invokevirtual 1191	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   6000: aload_0
    //   6001: ldc_w 1170
    //   6004: ldc_w 1172
    //   6007: ldc_w 1174
    //   6010: ldc_w 1176
    //   6013: ldc_w 1178
    //   6016: ldc_w 1180
    //   6019: invokestatic 1194	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   6022: invokestatic 541	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   6025: aload_1
    //   6026: invokestatic 1446	com/tencent/mm/ui/base/b:aR	(Landroid/content/Context;Landroid/content/Intent;)V
    //   6029: goto -91 -> 5938
    //   6032: astore_0
    //   6033: ldc_w 371
    //   6036: aload_0
    //   6037: ldc 80
    //   6039: iconst_1
    //   6040: anewarray 4	java/lang/Object
    //   6043: dup
    //   6044: iconst_0
    //   6045: ldc 80
    //   6047: aastore
    //   6048: invokestatic 654	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6051: goto -113 -> 5938
    //   6054: ldc_w 509
    //   6057: invokestatic 353	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   6060: iconst_0
    //   6061: ireturn
    //   6062: aload 14
    //   6064: ldc_w 1535
    //   6067: invokevirtual 444	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   6070: ifne +14 -> 6084
    //   6073: aload 14
    //   6075: ldc_w 1537
    //   6078: invokevirtual 444	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   6081: ifeq +455 -> 6536
    //   6084: ldc_w 371
    //   6087: ldc_w 1539
    //   6090: invokestatic 1041	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   6093: aload_1
    //   6094: invokestatic 601	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   6097: astore_1
    //   6098: new 527	android/content/Intent
    //   6101: dup
    //   6102: invokespecial 528	android/content/Intent:<init>	()V
    //   6105: astore 6
    //   6107: aload_1
    //   6108: ifnull +420 -> 6528
    //   6111: aload_1
    //   6112: ldc_w 658
    //   6115: invokevirtual 606	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   6118: astore 8
    //   6120: aload_1
    //   6121: ldc_w 1541
    //   6124: invokevirtual 606	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   6127: iconst_0
    //   6128: invokestatic 1209	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   6131: istore 7
    //   6133: aload_1
    //   6134: ldc_w 603
    //   6137: invokevirtual 606	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   6140: invokestatic 901	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   6143: astore 9
    //   6145: aload_1
    //   6146: ldc_w 1543
    //   6149: invokevirtual 606	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   6152: invokestatic 901	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   6155: iconst_0
    //   6156: invokestatic 1209	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   6159: istore 10
    //   6161: ldc_w 371
    //   6164: ldc_w 1545
    //   6167: iconst_4
    //   6168: anewarray 4	java/lang/Object
    //   6171: dup
    //   6172: iconst_0
    //   6173: aload 8
    //   6175: aastore
    //   6176: dup
    //   6177: iconst_1
    //   6178: aload 9
    //   6180: aastore
    //   6181: dup
    //   6182: iconst_2
    //   6183: iload_2
    //   6184: invokestatic 473	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   6187: aastore
    //   6188: dup
    //   6189: iconst_3
    //   6190: iload 10
    //   6192: invokestatic 473	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   6195: aastore
    //   6196: invokestatic 378	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6199: aload 6
    //   6201: ldc_w 714
    //   6204: aload 8
    //   6206: invokevirtual 717	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   6209: pop
    //   6210: aload 6
    //   6212: ldc_w 723
    //   6215: iload 4
    //   6217: invokevirtual 583	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   6220: pop
    //   6221: aload 6
    //   6223: ldc_w 725
    //   6226: aload 5
    //   6228: invokevirtual 728	android/content/Intent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
    //   6231: pop
    //   6232: iload_2
    //   6233: iconst_1
    //   6234: if_icmpne +187 -> 6421
    //   6237: iload 10
    //   6239: iconst_1
    //   6240: if_icmpne +25 -> 6265
    //   6243: aload 6
    //   6245: ldc_w 1547
    //   6248: aload 9
    //   6250: invokevirtual 717	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   6253: pop
    //   6254: aload 6
    //   6256: ldc_w 1549
    //   6259: bipush 53
    //   6261: invokevirtual 583	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   6264: pop
    //   6265: aload 6
    //   6267: ldc_w 1551
    //   6270: iconst_0
    //   6271: invokevirtual 578	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   6274: pop
    //   6275: aload 6
    //   6277: ldc_w 1553
    //   6280: bipush 40
    //   6282: invokevirtual 583	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   6285: pop
    //   6286: bipush 39
    //   6288: invokestatic 1558	com/tencent/mm/pluginsdk/wallet/h:setPayChannel	(I)V
    //   6291: iload 7
    //   6293: iconst_5
    //   6294: if_icmpne +64 -> 6358
    //   6297: aload 6
    //   6299: ldc_w 1560
    //   6302: iconst_1
    //   6303: invokevirtual 578	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   6306: pop
    //   6307: aload 6
    //   6309: ldc_w 1562
    //   6312: ldc_w 1564
    //   6315: iconst_3
    //   6316: anewarray 4	java/lang/Object
    //   6319: dup
    //   6320: iconst_0
    //   6321: aload 9
    //   6323: aastore
    //   6324: dup
    //   6325: iconst_1
    //   6326: iload 7
    //   6328: invokestatic 473	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   6331: aastore
    //   6332: dup
    //   6333: iconst_2
    //   6334: bipush 254
    //   6336: invokestatic 473	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   6339: aastore
    //   6340: invokestatic 1567	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   6343: invokevirtual 717	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   6346: pop
    //   6347: aload 6
    //   6349: ldc_w 1569
    //   6352: aload 9
    //   6354: invokevirtual 717	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   6357: pop
    //   6358: aload 6
    //   6360: ldc_w 1571
    //   6363: getstatic 82	com/tencent/mm/pluginsdk/g:XNI	Ljava/lang/String;
    //   6366: invokevirtual 717	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   6369: pop
    //   6370: aload_3
    //   6371: ifnull +10 -> 6381
    //   6374: aload 6
    //   6376: aload_3
    //   6377: invokevirtual 1575	android/content/Intent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   6380: pop
    //   6381: aload_0
    //   6382: ifnull +121 -> 6503
    //   6385: iload_2
    //   6386: iconst_2
    //   6387: if_icmpne +101 -> 6488
    //   6390: aload 8
    //   6392: invokestatic 601	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   6395: invokestatic 1579	com/tencent/mm/br/c:s	(Landroid/net/Uri;)Z
    //   6398: ifeq +75 -> 6473
    //   6401: aload_0
    //   6402: ldc_w 1581
    //   6405: ldc_w 1583
    //   6408: aload 6
    //   6410: invokestatic 561	com/tencent/mm/br/c:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V
    //   6413: ldc_w 509
    //   6416: invokestatic 353	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   6419: iconst_1
    //   6420: ireturn
    //   6421: iload_2
    //   6422: iconst_2
    //   6423: if_icmpne -132 -> 6291
    //   6426: iload 10
    //   6428: iconst_1
    //   6429: if_icmpne +25 -> 6454
    //   6432: aload 6
    //   6434: ldc_w 1547
    //   6437: aload 9
    //   6439: invokevirtual 717	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   6442: pop
    //   6443: aload 6
    //   6445: ldc_w 1549
    //   6448: bipush 52
    //   6450: invokevirtual 583	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   6453: pop
    //   6454: aload 6
    //   6456: ldc_w 1553
    //   6459: bipush 39
    //   6461: invokevirtual 583	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   6464: pop
    //   6465: bipush 39
    //   6467: invokestatic 1558	com/tencent/mm/pluginsdk/wallet/h:setPayChannel	(I)V
    //   6470: goto -179 -> 6291
    //   6473: aload_0
    //   6474: ldc_w 553
    //   6477: ldc_w 1585
    //   6480: aload 6
    //   6482: invokestatic 561	com/tencent/mm/br/c:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V
    //   6485: goto -72 -> 6413
    //   6488: aload_0
    //   6489: ldc_w 553
    //   6492: ldc_w 555
    //   6495: aload 6
    //   6497: invokestatic 561	com/tencent/mm/br/c:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V
    //   6500: goto -87 -> 6413
    //   6503: invokestatic 541	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   6506: ldc_w 553
    //   6509: ldc_w 555
    //   6512: aload 6
    //   6514: invokestatic 561	com/tencent/mm/br/c:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V
    //   6517: invokestatic 541	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   6520: aload 6
    //   6522: invokestatic 1446	com/tencent/mm/ui/base/b:aR	(Landroid/content/Context;Landroid/content/Intent;)V
    //   6525: goto -112 -> 6413
    //   6528: ldc_w 509
    //   6531: invokestatic 353	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   6534: iconst_0
    //   6535: ireturn
    //   6536: aload 14
    //   6538: ldc_w 1587
    //   6541: invokevirtual 444	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   6544: ifeq +478 -> 7022
    //   6547: ldc_w 371
    //   6550: ldc_w 1589
    //   6553: invokestatic 1041	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   6556: aload_1
    //   6557: invokestatic 601	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   6560: astore 6
    //   6562: new 527	android/content/Intent
    //   6565: dup
    //   6566: invokespecial 528	android/content/Intent:<init>	()V
    //   6569: astore 8
    //   6571: aconst_null
    //   6572: astore_1
    //   6573: aload 6
    //   6575: ifnull +227 -> 6802
    //   6578: aload 6
    //   6580: ldc_w 658
    //   6583: invokevirtual 606	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   6586: astore_1
    //   6587: aload 6
    //   6589: ldc_w 1541
    //   6592: invokevirtual 606	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   6595: iconst_0
    //   6596: invokestatic 1209	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   6599: istore 7
    //   6601: aload 6
    //   6603: ldc_w 603
    //   6606: invokevirtual 606	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   6609: invokestatic 901	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   6612: astore 9
    //   6614: ldc_w 371
    //   6617: ldc_w 1591
    //   6620: iconst_3
    //   6621: anewarray 4	java/lang/Object
    //   6624: dup
    //   6625: iconst_0
    //   6626: aload_1
    //   6627: aastore
    //   6628: dup
    //   6629: iconst_1
    //   6630: aload 9
    //   6632: aastore
    //   6633: dup
    //   6634: iconst_2
    //   6635: iload_2
    //   6636: invokestatic 473	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   6639: aastore
    //   6640: invokestatic 378	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6643: ldc_w 730
    //   6646: astore 6
    //   6648: aload 8
    //   6650: ldc_w 714
    //   6653: aload_1
    //   6654: invokevirtual 717	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   6657: pop
    //   6658: aload 8
    //   6660: ldc_w 723
    //   6663: iload 4
    //   6665: invokevirtual 583	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   6668: pop
    //   6669: aload 8
    //   6671: ldc_w 725
    //   6674: aload 5
    //   6676: invokevirtual 728	android/content/Intent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
    //   6679: pop
    //   6680: aload 8
    //   6682: ldc_w 1547
    //   6685: aload 9
    //   6687: invokevirtual 717	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   6690: pop
    //   6691: aload 8
    //   6693: ldc_w 1549
    //   6696: bipush 57
    //   6698: invokevirtual 583	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   6701: pop
    //   6702: aload 8
    //   6704: ldc_w 1551
    //   6707: iconst_0
    //   6708: invokevirtual 578	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   6711: pop
    //   6712: aload 8
    //   6714: ldc_w 1560
    //   6717: iconst_1
    //   6718: invokevirtual 578	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   6721: pop
    //   6722: aload 8
    //   6724: ldc_w 1562
    //   6727: ldc_w 1593
    //   6730: iconst_3
    //   6731: anewarray 4	java/lang/Object
    //   6734: dup
    //   6735: iconst_0
    //   6736: aload 9
    //   6738: aastore
    //   6739: dup
    //   6740: iconst_1
    //   6741: iload 7
    //   6743: invokestatic 473	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   6746: aastore
    //   6747: dup
    //   6748: iconst_2
    //   6749: bipush 254
    //   6751: invokestatic 473	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   6754: aastore
    //   6755: invokestatic 1567	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   6758: invokevirtual 717	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   6761: pop
    //   6762: aload 8
    //   6764: ldc_w 1569
    //   6767: aload 9
    //   6769: invokevirtual 717	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   6772: pop
    //   6773: aload 8
    //   6775: ldc_w 1571
    //   6778: getstatic 82	com/tencent/mm/pluginsdk/g:XNI	Ljava/lang/String;
    //   6781: invokevirtual 717	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   6784: pop
    //   6785: aload 6
    //   6787: astore_1
    //   6788: aload_3
    //   6789: ifnull +13 -> 6802
    //   6792: aload 8
    //   6794: aload_3
    //   6795: invokevirtual 1575	android/content/Intent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   6798: pop
    //   6799: aload 6
    //   6801: astore_1
    //   6802: aload_1
    //   6803: invokestatic 369	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   6806: ifne +208 -> 7014
    //   6809: aload 8
    //   6811: invokestatic 541	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   6814: aload_1
    //   6815: invokevirtual 545	android/content/Intent:setClassName	(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;
    //   6818: pop
    //   6819: aload_0
    //   6820: ifnull +84 -> 6904
    //   6823: new 1159	com/tencent/mm/hellhoundlib/b/a
    //   6826: dup
    //   6827: invokespecial 1160	com/tencent/mm/hellhoundlib/b/a:<init>	()V
    //   6830: aload 8
    //   6832: invokevirtual 1164	com/tencent/mm/hellhoundlib/b/a:cG	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   6835: astore_1
    //   6836: aload_0
    //   6837: aload_1
    //   6838: invokevirtual 1168	com/tencent/mm/hellhoundlib/b/a:aYi	()[Ljava/lang/Object;
    //   6841: ldc_w 1170
    //   6844: ldc_w 1172
    //   6847: ldc_w 1174
    //   6850: ldc_w 1176
    //   6853: ldc_w 1178
    //   6856: ldc_w 1180
    //   6859: invokestatic 1185	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   6862: aload_0
    //   6863: aload_1
    //   6864: iconst_0
    //   6865: invokevirtual 1189	com/tencent/mm/hellhoundlib/b/a:sb	(I)Ljava/lang/Object;
    //   6868: checkcast 527	android/content/Intent
    //   6871: invokevirtual 1191	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   6874: aload_0
    //   6875: ldc_w 1170
    //   6878: ldc_w 1172
    //   6881: ldc_w 1174
    //   6884: ldc_w 1176
    //   6887: ldc_w 1178
    //   6890: ldc_w 1180
    //   6893: invokestatic 1194	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   6896: ldc_w 509
    //   6899: invokestatic 353	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   6902: iconst_1
    //   6903: ireturn
    //   6904: invokestatic 541	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   6907: astore_0
    //   6908: new 1159	com/tencent/mm/hellhoundlib/b/a
    //   6911: dup
    //   6912: invokespecial 1160	com/tencent/mm/hellhoundlib/b/a:<init>	()V
    //   6915: aload 8
    //   6917: invokevirtual 1164	com/tencent/mm/hellhoundlib/b/a:cG	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   6920: astore_1
    //   6921: aload_0
    //   6922: aload_1
    //   6923: invokevirtual 1168	com/tencent/mm/hellhoundlib/b/a:aYi	()[Ljava/lang/Object;
    //   6926: ldc_w 1170
    //   6929: ldc_w 1172
    //   6932: ldc_w 1174
    //   6935: ldc_w 1176
    //   6938: ldc_w 1178
    //   6941: ldc_w 1180
    //   6944: invokestatic 1185	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   6947: aload_0
    //   6948: aload_1
    //   6949: iconst_0
    //   6950: invokevirtual 1189	com/tencent/mm/hellhoundlib/b/a:sb	(I)Ljava/lang/Object;
    //   6953: checkcast 527	android/content/Intent
    //   6956: invokevirtual 1191	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   6959: aload_0
    //   6960: ldc_w 1170
    //   6963: ldc_w 1172
    //   6966: ldc_w 1174
    //   6969: ldc_w 1176
    //   6972: ldc_w 1178
    //   6975: ldc_w 1180
    //   6978: invokestatic 1194	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   6981: invokestatic 541	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   6984: aload 8
    //   6986: invokestatic 1446	com/tencent/mm/ui/base/b:aR	(Landroid/content/Context;Landroid/content/Intent;)V
    //   6989: goto -93 -> 6896
    //   6992: astore_0
    //   6993: ldc_w 371
    //   6996: aload_0
    //   6997: ldc 80
    //   6999: iconst_1
    //   7000: anewarray 4	java/lang/Object
    //   7003: dup
    //   7004: iconst_0
    //   7005: ldc 80
    //   7007: aastore
    //   7008: invokestatic 654	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   7011: goto -115 -> 6896
    //   7014: ldc_w 509
    //   7017: invokestatic 353	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   7020: iconst_0
    //   7021: ireturn
    //   7022: aload 14
    //   7024: ldc_w 1595
    //   7027: invokevirtual 444	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   7030: ifne +14 -> 7044
    //   7033: aload 14
    //   7035: ldc_w 1597
    //   7038: invokevirtual 444	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   7041: ifeq +267 -> 7308
    //   7044: aload_1
    //   7045: invokestatic 601	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   7048: astore_1
    //   7049: aload_1
    //   7050: ldc_w 603
    //   7053: invokevirtual 606	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   7056: astore 6
    //   7058: aload_1
    //   7059: ldc_w 1599
    //   7062: invokevirtual 606	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   7065: astore 8
    //   7067: aconst_null
    //   7068: astore_1
    //   7069: aconst_null
    //   7070: astore_3
    //   7071: aconst_null
    //   7072: astore 5
    //   7074: iconst_0
    //   7075: istore 4
    //   7077: invokestatic 1225	com/tencent/mm/model/ad:bCb	()Lcom/tencent/mm/model/ad;
    //   7080: ldc_w 1227
    //   7083: iconst_0
    //   7084: invokevirtual 1231	com/tencent/mm/model/ad:M	(Ljava/lang/String;Z)Lcom/tencent/mm/model/ad$b;
    //   7087: astore 15
    //   7089: aload 15
    //   7091: ifnull +66 -> 7157
    //   7094: aload 15
    //   7096: ldc_w 1233
    //   7099: iconst_0
    //   7100: invokestatic 473	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   7103: invokevirtual 1238	com/tencent/mm/model/ad$b:get	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   7106: checkcast 470	java/lang/Integer
    //   7109: invokevirtual 1241	java/lang/Integer:intValue	()I
    //   7112: istore 4
    //   7114: aload 15
    //   7116: ldc_w 1601
    //   7119: ldc 80
    //   7121: invokevirtual 1238	com/tencent/mm/model/ad$b:get	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   7124: checkcast 441	java/lang/String
    //   7127: astore_1
    //   7128: aload 15
    //   7130: ldc_w 1603
    //   7133: ldc 80
    //   7135: invokevirtual 1238	com/tencent/mm/model/ad$b:get	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   7138: checkcast 441	java/lang/String
    //   7141: astore_3
    //   7142: aload 15
    //   7144: ldc_w 1605
    //   7147: ldc 80
    //   7149: invokevirtual 1238	com/tencent/mm/model/ad$b:get	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   7152: checkcast 441	java/lang/String
    //   7155: astore 5
    //   7157: ldc_w 371
    //   7160: ldc_w 1607
    //   7163: iconst_3
    //   7164: anewarray 4	java/lang/Object
    //   7167: dup
    //   7168: iconst_0
    //   7169: aload 6
    //   7171: aastore
    //   7172: dup
    //   7173: iconst_1
    //   7174: iload_2
    //   7175: invokestatic 473	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   7178: aastore
    //   7179: dup
    //   7180: iconst_2
    //   7181: iload 4
    //   7183: invokestatic 473	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   7186: aastore
    //   7187: invokestatic 378	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   7190: invokestatic 1225	com/tencent/mm/model/ad:bCb	()Lcom/tencent/mm/model/ad;
    //   7193: ldc_w 1227
    //   7196: invokevirtual 1247	com/tencent/mm/model/ad:Jn	(Ljava/lang/String;)Lcom/tencent/mm/model/ad$b;
    //   7199: pop
    //   7200: aload 14
    //   7202: ldc_w 1595
    //   7205: invokevirtual 444	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   7208: ifeq +63 -> 7271
    //   7211: iload_2
    //   7212: iconst_1
    //   7213: if_icmpne +50 -> 7263
    //   7216: aconst_null
    //   7217: astore_3
    //   7218: aload 9
    //   7220: instanceof 1609
    //   7223: ifeq +9 -> 7232
    //   7226: aload 9
    //   7228: checkcast 1609	com/tencent/mm/plugin/appbrand/service/t$a
    //   7231: astore_3
    //   7232: ldc_w 1286
    //   7235: invokestatic 1011	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   7238: checkcast 1286	com/tencent/mm/plugin/appbrand/service/t
    //   7241: aload_0
    //   7242: aload 6
    //   7244: aload 8
    //   7246: aload_1
    //   7247: iload 4
    //   7249: aload_3
    //   7250: invokeinterface 1612 7 0
    //   7255: ldc_w 509
    //   7258: invokestatic 353	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   7261: iconst_1
    //   7262: ireturn
    //   7263: ldc_w 509
    //   7266: invokestatic 353	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   7269: iconst_0
    //   7270: ireturn
    //   7271: getstatic 1618	com/tencent/mm/pluginsdk/d:XNw	Lcom/tencent/mm/pluginsdk/d$a;
    //   7274: astore_0
    //   7275: aload 8
    //   7277: aload 6
    //   7279: aload_3
    //   7280: aload 5
    //   7282: invokestatic 1624	com/tencent/mm/pluginsdk/d$a:P	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   7285: ifeq +11 -> 7296
    //   7288: ldc_w 509
    //   7291: invokestatic 353	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   7294: iconst_1
    //   7295: ireturn
    //   7296: iconst_1
    //   7297: putstatic 69	com/tencent/mm/pluginsdk/g:XNF	Z
    //   7300: ldc_w 509
    //   7303: invokestatic 353	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   7306: iconst_0
    //   7307: ireturn
    //   7308: ldc_w 509
    //   7311: invokestatic 353	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   7314: iconst_0
    //   7315: ireturn
    //   7316: astore_1
    //   7317: goto -6907 -> 410
    //   7320: goto -2163 -> 5157
    //   7323: ldc 80
    //   7325: astore_0
    //   7326: goto -3272 -> 4054
    //   7329: ldc 80
    //   7331: astore_1
    //   7332: goto -5737 -> 1595
    //   7335: aconst_null
    //   7336: astore_1
    //   7337: goto -7051 -> 286
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	7340	0	paramContext	Context
    //   0	7340	1	paramString1	String
    //   0	7340	2	paramInt1	int
    //   0	7340	3	paramBundle	Bundle
    //   0	7340	4	paramInt2	int
    //   0	7340	5	paramArrayOfByte	byte[]
    //   0	7340	6	paramString2	String
    //   0	7340	7	paramInt3	int
    //   0	7340	8	paramString3	String
    //   0	7340	9	parama	g.a
    //   3598	2832	10	i	int
    //   57	4640	11	l	long
    //   2493	24	13	bool	boolean
    //   10	7191	14	str1	String
    //   487	6656	15	localObject	Object
    //   1669	2547	16	str2	String
    //   1680	2422	17	str3	String
    //   1691	2416	18	str4	String
    //   1705	2434	19	str5	String
    // Exception table:
    //   from	to	target	type
    //   343	360	448	java/lang/Exception
    //   514	524	656	java/lang/Exception
    //   527	537	656	java/lang/Exception
    //   706	714	746	java/lang/Exception
    //   814	822	871	java/lang/Exception
    //   824	834	871	java/lang/Exception
    //   950	958	1013	java/lang/Exception
    //   960	970	1013	java/lang/Exception
    //   1575	1583	2033	java/io/UnsupportedEncodingException
    //   1587	1595	2033	java/io/UnsupportedEncodingException
    //   1595	1822	2033	java/io/UnsupportedEncodingException
    //   1824	1941	2033	java/io/UnsupportedEncodingException
    //   1941	2017	2033	java/io/UnsupportedEncodingException
    //   3953	4024	4232	java/lang/Exception
    //   4024	4054	4232	java/lang/Exception
    //   4225	4229	4232	java/lang/Exception
    //   4071	4087	4252	com/tencent/mm/ad/g
    //   137	159	4910	java/lang/Exception
    //   4834	4907	4910	java/lang/Exception
    //   4932	4956	4910	java/lang/Exception
    //   4956	4964	4910	java/lang/Exception
    //   4967	5044	4910	java/lang/Exception
    //   5597	5669	5763	java/lang/Exception
    //   5677	5760	5763	java/lang/Exception
    //   5866	5938	6032	java/lang/Exception
    //   5946	6029	6032	java/lang/Exception
    //   6823	6896	6992	java/lang/Exception
    //   6904	6989	6992	java/lang/Exception
    //   370	410	7316	com/tencent/mm/ad/g
  }
  
  public static boolean a(Context paramContext, String paramString1, int paramInt1, Bundle paramBundle, String paramString2, int paramInt2, String paramString3, g.a parama)
  {
    AppMethodBeat.i(244552);
    boolean bool = a(paramContext, paramString1, paramInt1, paramBundle, n.bMd(), new byte[0], paramString2, paramInt2, paramString3, parama);
    AppMethodBeat.o(244552);
    return bool;
  }
  
  public static boolean aa(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(124362);
    boolean bool = a(paramContext, paramString1, 1, n.bMd(), new byte[0], paramString2);
    AppMethodBeat.o(124362);
    return bool;
  }
  
  public static void ab(final Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(124369);
    if (boY(paramString2))
    {
      AppMethodBeat.o(124369);
      return;
    }
    w localw = k.a(paramContext, "", true, null);
    int j = 6;
    int i = j;
    if (!Util.isNullOrNil(paramString1))
    {
      if (!au.bwE(paramString1)) {
        break label77;
      }
      i = 7;
    }
    for (;;)
    {
      a(paramContext, paramString2, i, new g.a()
      {
        public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(244493);
          Log.i("MicroMsg.DeepLinkHelper", "DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, Boolean.valueOf(paramAnonymousBoolean) });
          if ((g.this != null) && (g.this.isShowing())) {
            g.this.dismiss();
          }
          if ((paramAnonymousp != null) && (paramAnonymousInt1 != 0) && (paramAnonymousInt2 != 0) && ((paramAnonymousp instanceof ad)))
          {
            paramAnonymousString = ((ad)paramAnonymousp).bMA();
            if ((paramAnonymousString != null) && (paramContext != null) && (!Util.isNullOrNil(paramAnonymousString.abQg))) {
              com.tencent.mm.ui.base.aa.makeText(paramContext, paramContext.getString(b.f.app_tip) + " : " + Util.nullAsNil(paramAnonymousString.abQg), 0).show();
            }
          }
          AppMethodBeat.o(244493);
        }
      });
      AppMethodBeat.o(124369);
      return;
      label77:
      i = j;
      if (ab.IS(paramString1)) {
        i = 9;
      }
    }
  }
  
  private static void bi(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(124367);
    String str;
    if ((!ChannelUtil.isNokiaAol) && (LocaleUtil.getApplicationLanguage().equals("zh_CN"))) {
      str = paramContext.getString(b.f.wechat_faq_url);
    }
    for (;;)
    {
      Log.d("MicroMsg.DeepLinkHelper", "using faq webpage");
      Intent localIntent = new Intent();
      localIntent.putExtra("rawUrl", str);
      localIntent.putExtra("show_feedback", false);
      localIntent.putExtra("KShowFixToolsBtn", true);
      localIntent.putExtra("geta8key_session_id", paramInt);
      c.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
      AppMethodBeat.o(124367);
      return;
      if (LocaleUtil.getApplicationLanguage().equals("zh_HK")) {
        str = paramContext.getString(b.f.wechat_faq_url_cht);
      } else if (LocaleUtil.getApplicationLanguage().equals("zh_TW")) {
        str = paramContext.getString(b.f.wechat_faq_url_cht_tw);
      } else {
        str = paramContext.getString(b.f.wechat_faq_url_en);
      }
    }
  }
  
  public static String boS(String paramString)
  {
    AppMethodBeat.i(244515);
    if (WeChatBrands.AppInfo.current().isMainland())
    {
      AppMethodBeat.o(244515);
      return paramString;
    }
    if (paramString.startsWith("wechat://")) {
      paramString.replace("wechat://", "weixin://");
    }
    AppMethodBeat.o(244515);
    return paramString;
  }
  
  public static boolean boT(String paramString)
  {
    AppMethodBeat.i(124348);
    paramString = boZ(boS(paramString));
    if ((!XNJ.containsKey(paramString)) && (!boV(paramString)) && (!boX(paramString))) {
      if ((Util.isNullOrNil(paramString)) || ((!paramString.startsWith("weixin://dl/jumpFakeWxa/")) && (!paramString.startsWith("weixin://dl/openNativeView/")))) {
        break label81;
      }
    }
    label81:
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(124348);
      return true;
    }
    AppMethodBeat.o(124348);
    return false;
  }
  
  public static boolean boU(String paramString)
  {
    AppMethodBeat.i(124349);
    boolean bool = boV(boS(paramString));
    AppMethodBeat.o(124349);
    return bool;
  }
  
  private static boolean boV(String paramString)
  {
    AppMethodBeat.i(244520);
    if ((!Util.isNullOrNil(paramString)) && (paramString.startsWith("weixin://dl/business")))
    {
      AppMethodBeat.o(244520);
      return true;
    }
    AppMethodBeat.o(244520);
    return false;
  }
  
  public static boolean boW(String paramString)
  {
    AppMethodBeat.i(124350);
    boolean bool = boX(boS(paramString));
    AppMethodBeat.o(124350);
    return bool;
  }
  
  private static boolean boX(String paramString)
  {
    AppMethodBeat.i(244524);
    if ((!Util.isNullOrNil(paramString)) && (paramString.startsWith("weixin://dl/openbusinesswebview")))
    {
      AppMethodBeat.o(244524);
      return true;
    }
    AppMethodBeat.o(244524);
    return false;
  }
  
  private static boolean boY(String paramString)
  {
    AppMethodBeat.i(124354);
    if (((paramString.equals("weixin://dl/wechatout")) || (paramString.equals("weixin://dl/wechatoutcoupon")) || (paramString.equals("weixin://dl/wechatoutshare"))) && (!iGG()))
    {
      paramString = new Intent();
      paramString.setFlags(268435456);
      paramString.setClassName(MMApplicationContext.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
      paramString.putExtra("rawUrl", XNE);
      c.b(MMApplicationContext.getContext(), "webview", ".ui.tools.WebViewUI", paramString);
      AppMethodBeat.o(124354);
      return true;
    }
    AppMethodBeat.o(124354);
    return false;
  }
  
  private static String boZ(String paramString)
  {
    AppMethodBeat.i(124368);
    String str = null;
    if (!Util.isNullOrNil(paramString))
    {
      paramString = Uri.parse(paramString);
      str = paramString.getScheme() + "://" + paramString.getHost() + paramString.getPath();
    }
    AppMethodBeat.o(124368);
    return str;
  }
  
  public static boolean cB(Context paramContext, String paramString)
  {
    AppMethodBeat.i(244545);
    boolean bool = a(paramContext, paramString, 0, n.bMd(), new byte[0], null);
    AppMethodBeat.o(244545);
    return bool;
  }
  
  public static void cC(Context paramContext, String paramString)
  {
    AppMethodBeat.i(124371);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.DeepLinkHelper", "cpan gotoLoginUI url is null. finish");
      AppMethodBeat.o(124371);
      return;
    }
    Object localObject;
    if (paramString.startsWith("weixin://dl/login/phone_view"))
    {
      localObject = Uri.parse(paramString);
      paramString = ((Uri)localObject).getQueryParameter("cc");
      localObject = ((Uri)localObject).getQueryParameter("num");
      Log.d("MicroMsg.DeepLinkHelper", "cpan gotoLoginUI cc:%s num:%s", new Object[] { paramString, localObject });
      Intent localIntent = new Intent();
      localIntent.putExtra("couttry_code", paramString);
      localIntent.putExtra("input_mobile_number", (String)localObject);
      localIntent.putExtra("from_deep_link", true);
      localIntent.putExtra("mobile_input_purpose", 1);
      localIntent.addFlags(268435456);
      c.b(paramContext, "account", ".ui.MobileInputUI", localIntent);
      AppMethodBeat.o(124371);
      return;
    }
    if (paramString.startsWith("weixin://dl/login/common_view"))
    {
      paramString = Uri.parse(paramString).getQueryParameter("username");
      Log.d("MicroMsg.DeepLinkHelper", "cpan gotoLoginUI  username:%s", new Object[] { paramString });
      localObject = new Intent();
      ((Intent)localObject).putExtra("login_username", paramString);
      ((Intent)localObject).putExtra("from_deep_link", true);
      ((Intent)localObject).addFlags(268435456);
      c.b(paramContext, "account", ".ui.LoginUI", (Intent)localObject);
      AppMethodBeat.o(124371);
      return;
    }
    Log.e("MicroMsg.DeepLinkHelper", "cpan gotoLoginUI url not Correct:%s", new Object[] { paramString });
    AppMethodBeat.o(124371);
  }
  
  public static boolean ce(String paramString, long paramLong)
  {
    AppMethodBeat.i(124347);
    if (!Util.isNullOrNil(paramString))
    {
      paramString = boZ(paramString);
      if (!XNJ.containsKey(paramString)) {
        break label86;
      }
    }
    label86:
    for (long l = ((Long)XNJ.get(paramString)).longValue();; l = -1L)
    {
      if ((l != -1L) && ((l == 0L) || ((l & paramLong) == l))) {}
      for (boolean bool = true;; bool = false)
      {
        AppMethodBeat.o(124347);
        return bool;
      }
    }
  }
  
  private static void d(com.tencent.mm.ad.i parami)
  {
    AppMethodBeat.i(124370);
    if (parami == null)
    {
      AppMethodBeat.o(124370);
      return;
    }
    parami = parami.optString("package_info");
    if (Util.isNullOrNil(parami))
    {
      Log.i("MicroMsg.DeepLinkHelper", "package_info is null in invokeData");
      AppMethodBeat.o(124370);
      return;
    }
    for (;;)
    {
      int i;
      ArrayList localArrayList;
      Object localObject1;
      String str2;
      long l;
      String str3;
      try
      {
        parami = new com.tencent.mm.ad.f(parami);
        i = parami.length();
        if (i <= 0)
        {
          AppMethodBeat.o(124370);
          return;
        }
        String str1 = com.tencent.mm.kernel.h.baE().cachePath + "TempMiniProgram/";
        localArrayList = new ArrayList();
        i = 0;
        if (i >= parami.length()) {
          break label440;
        }
        localObject1 = new com.tencent.mm.ad.i(parami.getString(i));
        str2 = ((com.tencent.mm.ad.i)localObject1).optString("downloadUrl");
        l = ((com.tencent.mm.ad.i)localObject1).optLong("expireTime");
        localObject2 = ((com.tencent.mm.ad.i)localObject1).optString("extraBytes");
        localObject3 = ((com.tencent.mm.ad.i)localObject1).optString("filePath");
        localObject1 = ((com.tencent.mm.ad.i)localObject1).optString("fileMd5");
        if ((Util.isNullOrNil((String)localObject1)) || (Util.isNullOrNil(str2)) || (Util.isNullOrNil((String)localObject3)) || (Util.isNullOrNil((String)localObject2)) || (l <= 0L)) {
          break label463;
        }
        if ((!((String)localObject3).startsWith("content")) || (!y.ZC((String)localObject3)))
        {
          Log.i("MicroMsg.DeepLinkHelper", "file not Exists, path = %s", new Object[] { localObject3 });
        }
        else
        {
          if (!y.ZC(str1)) {
            y.bDX(str1);
          }
          str3 = Util.safeFormatString("%s.%s", new Object[] { localObject1, y.alV((String)localObject3) });
          str3 = str1 + str3;
          if (y.O((String)localObject3, str3, false) <= 0L) {
            Log.e("MicroMsg.DeepLinkHelper", "file copy failed");
          }
        }
      }
      catch (Exception parami)
      {
        Log.e("MicroMsg.DeepLinkHelper", parami.getMessage());
        AppMethodBeat.o(124370);
        return;
      }
      Object localObject2 = Util.decodeHexString((String)localObject2);
      Object localObject3 = new a.a();
      ((a.a)localObject3).ba((byte[])localObject2);
      Log.i("MicroMsg.DeepLinkHelper", ((a.a)localObject3).toString());
      ((a.a)localObject3).tdq = l;
      ((a.a)localObject3).tdo = ((String)localObject1);
      ((a.a)localObject3).tdp = str2;
      localArrayList.add(new Pair(localObject3, str3));
      break label463;
      label440:
      ((a)com.tencent.mm.kernel.h.ax(a.class)).dz(localArrayList);
      AppMethodBeat.o(124370);
      return;
      label463:
      i += 1;
    }
  }
  
  private static boolean iGG()
  {
    AppMethodBeat.i(124353);
    if (com.tencent.mm.kernel.h.baz())
    {
      if (com.tencent.mm.k.i.aRC().getInt("WCOEntranceSwitch", 0) > 0)
      {
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acKL, Boolean.TRUE);
        AppMethodBeat.o(124353);
        return true;
      }
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acKL, Boolean.FALSE);
      AppMethodBeat.o(124353);
      return false;
    }
    AppMethodBeat.o(124353);
    return false;
  }
  
  public static void ll(Context paramContext)
  {
    AppMethodBeat.i(124366);
    bi(paramContext, n.bMd());
    AppMethodBeat.o(124366);
  }
  
  private static Intent n(String paramString, Context paramContext)
  {
    AppMethodBeat.i(244628);
    if ((paramContext != null) && (!Util.isNullOrNil(paramString)) && (paramString.startsWith("weixin://dl/businessPay")))
    {
      Object localObject = Uri.parse(paramString);
      if (localObject == null) {
        break label208;
      }
      paramString = ((Uri)localObject).getQueryParameter("reqkey");
      String str = ((Uri)localObject).getQueryParameter("appid");
      if (!Util.isNullOrNil(paramString))
      {
        localObject = new PayInfo();
        ((PayInfo)localObject).hAT = paramString;
        ((PayInfo)localObject).appId = str;
        ((PayInfo)localObject).hUR = 36;
        ((PayInfo)localObject).egT = false;
        paramString = new Intent();
        paramString.putExtra("key_pay_info", (Parcelable)localObject);
        if ((paramContext instanceof Activity))
        {
          paramString.putExtra("key_context_hashcode", paramContext.hashCode());
          Log.i("MicroMsg.DeepLinkHelper", "startPay context %s %s", new Object[] { paramContext, Integer.valueOf(paramContext.hashCode()) });
        }
        if (z.bBi()) {
          c.b(paramContext, "wallet_payu", ".pay.ui.WalletPayUPayUI", paramString, 1);
        }
        for (;;)
        {
          AppMethodBeat.o(244628);
          return paramString;
          c.b(paramContext, "wallet", ".pay.ui.WalletPayUI", paramString, 1);
        }
      }
      Log.w("MicroMsg.DeepLinkHelper", "reqkey null");
    }
    for (;;)
    {
      AppMethodBeat.o(244628);
      return null;
      label208:
      Log.w("MicroMsg.DeepLinkHelper", "payUri null");
    }
  }
  
  public static boolean p(Uri paramUri)
  {
    AppMethodBeat.i(124351);
    if (paramUri == null)
    {
      AppMethodBeat.o(124351);
      return false;
    }
    if (!com.tencent.mm.pluginsdk.ui.tools.aa.M(paramUri.toString(), "weixin://dl/"))
    {
      AppMethodBeat.o(124351);
      return false;
    }
    String str2 = paramUri.getQueryParameter("ticket");
    String str1 = str2;
    if (Util.isNullOrNil(str2)) {
      str1 = paramUri.getQueryParameter("t");
    }
    if (!Util.isNullOrNil(str1))
    {
      AppMethodBeat.o(124351);
      return true;
    }
    boolean bool = q(paramUri);
    AppMethodBeat.o(124351);
    return bool;
  }
  
  public static boolean q(Uri paramUri)
  {
    AppMethodBeat.i(124352);
    if (paramUri == null)
    {
      AppMethodBeat.o(124352);
      return false;
    }
    if ((paramUri.toString().startsWith("weixin://dl/business/tempsession/")) || (paramUri.toString().startsWith("weixin://dl/businessTempSession/")))
    {
      AppMethodBeat.o(124352);
      return true;
    }
    AppMethodBeat.o(124352);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g
 * JD-Core Version:    0.7.0.1
 */