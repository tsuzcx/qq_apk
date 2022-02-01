package com.unionpay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.unionpay.a.d;
import com.unionpay.utils.UPUtils;
import com.unionpay.utils.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a
{
  private static String A;
  private static String B;
  private static String C;
  private static String D;
  private static String E;
  private static boolean F;
  private static int G;
  private static String I;
  private static String J;
  private static String K;
  private static String L;
  private static String M;
  private static boolean N;
  private static String O;
  private static int P;
  private static boolean Q;
  private static String T;
  private static String U;
  private static String V;
  private static String a;
  private static final Handler.Callback aisA;
  private static Context aisw;
  private static d aisx;
  private static Handler aisy;
  private static JSONArray aisz;
  private static String b;
  private static String c;
  private static String d;
  private static String e;
  private static String f;
  private static String g;
  private static String h;
  private static String i;
  private static String j;
  private static String k;
  private static String l;
  private static String m;
  private static String n;
  private static String o;
  private static String p;
  private static String q;
  private static String r;
  private static String s;
  private static String t;
  private static String u;
  private static String v;
  private static String w;
  private static String x;
  private static String y;
  private static String z;
  
  static
  {
    AppMethodBeat.i(207415);
    a = "SpId";
    b = "paydata";
    c = "SysProvide";
    d = "UseTestMode";
    e = "SecurityChipType";
    f = "uppayuri";
    g = "resultIntentAction";
    h = "reqOriginalId";
    i = "wapurl";
    j = "actionType";
    k = "dlgstyle";
    l = "com.unionpay.uppay";
    m = "com.unionpay.uppay.PayActivity";
    n = "ex_mode";
    o = "server";
    p = "source";
    q = "samsung_out";
    r = "se_type";
    s = "se_title_logo";
    t = "se_loading_logo";
    u = "se_title_bg_color";
    v = "se_cancel_bg_color";
    w = "02";
    B = "";
    C = "";
    D = "";
    E = "";
    F = false;
    G = 10;
    I = "";
    J = null;
    K = null;
    L = "";
    M = "";
    N = false;
    O = "";
    P = 0;
    Q = false;
    aisx = null;
    aisy = null;
    T = "[{\"type\":\"app\",\"sort\":100,\"package_info\":[{\"schema\":\"com.unionpay\",\"version\":\".*\",\"sign\":\"536C79B93ACFBEA950AE365D8CE1AEF91FEA9535\",\"sort\":101}],\"md5\":\"D75BB2802E61738A9A03BF014F927D9A\"},{\"sort\": 200,\"type\": \"link\",\"url\": \"https://youhui.95516.com/hybrid_v4/html/help/download.html\"}]";
    U = "[{\"type\":\"app\",\"sort\":100,\"package_info\":[{\"schema\":\"com.unionpay.tsmservice\",\"version\":\"^[1-9].*|^0[2-9].*|^01\\.[1-9].*|^01\\.0[1-9].*|^01\\.00\\.[2-9].*|^01\\.00\\.1[012789].*|^01\\.00\\.0[8-9].*\",\"sign\":\"536C79B93ACFBEA950AE365D8CE1AEF91FEA9535\",\"sort\":102},{\"schema\":\"com.unionpay.tsmservice.mi\",\"version\":\"^[1-9].*|^0[2-9].*|^01\\.[1-9].*|^01\\.0[1-9].*|^01\\.00\\.[1-9].*|^01\\.00\\.0[8-9].*\",\"sign\":\"536C79B93ACFBEA950AE365D8CE1AEF91FEA9535\",\"sort\":103}],\"md5\":\"D75BB2802E61738A9A03BF014F927D9A\"}]";
    V = "[{\"type\":\"app\",\"sort\":100,\"package_info\":[{\"schema\":\"com.huawei.wallet\",\"version\":\"([0-9]\\d*)\\.([0-9]\\d*)\\.([0-9]\\d*)\\.([0-9]\\d*)\",\"sign\":\"9095F915D6C143A41CE029209AFECB87AB481DDD\",\"sort\":101},{\"schema\":\"com.huawei.wallet\",\"version\":\"([0-9]\\d*)\\.([0-9]\\d*)\\.([0-9]\\d*)\\.([0-9]\\d*)\",\"sign\":\"059e2480adf8c1c5b3d9ec007645ccfc442a23c5\",\"sort\":102},{\"schema\":\"com.unionpay.tsmservice\",\"version\":\"^[1-9].*|^0[2-9].*|^01\\.[1-9].*|^01\\.0[1-9].*|^01\\.00\\.[2-9].*|^01\\.00\\.1[012789].*|^01\\.00\\.0[8-9].*\",\"sign\":\"536C79B93ACFBEA950AE365D8CE1AEF91FEA9535\",\"sort\":103},{\"schema\":\"com.unionpay.tsmservice.mi\",\"version\":\"^[1-9].*|^0[2-9].*|^01\\.[1-9].*|^01\\.0[1-9].*|^01\\.00\\.[1-9].*|^01\\.00\\.0[8-9].*\",\"sign\":\"536C79B93ACFBEA950AE365D8CE1AEF91FEA9535\",\"sort\":104}],\"md5\":\"D75BB2802E61738A9A03BF014F927D9A\"}]";
    aisA = new c();
    AppMethodBeat.o(207415);
  }
  
  static String a(Context paramContext)
  {
    AppMethodBeat.i(207347);
    paramContext = f(paramContext, true, "0");
    AppMethodBeat.o(207347);
    return paramContext;
  }
  
  static void a(String paramString)
  {
    AppMethodBeat.i(207326);
    Object localObject = new Bundle();
    c(I, (Bundle)localObject, L);
    ((Bundle)localObject).putString(a, J);
    ((Bundle)localObject).putString(c, K);
    ((Bundle)localObject).putString(b, I);
    ((Bundle)localObject).putString(p, C);
    ((Bundle)localObject).putString(r, D);
    if (!TextUtils.isEmpty(D))
    {
      ((Bundle)localObject).putString(s, x);
      ((Bundle)localObject).putString(t, y);
      ((Bundle)localObject).putString(u, z);
      ((Bundle)localObject).putString(v, A);
    }
    ((Bundle)localObject).putString(o, paramString);
    ((Bundle)localObject).putBoolean(k, F);
    ((Bundle)localObject).putInt(h, 2);
    try
    {
      Class localClass = Class.forName("com.unionpay.uppay.PayActivity");
      paramString = new Intent();
      paramString.putExtras((Bundle)localObject);
      paramString.setClass(aisw, localClass);
      if ((aisw instanceof Activity))
      {
        com.tencent.mm.hellhoundlib.a.a.a((Activity)aisw, com.tencent.mm.hellhoundlib.b.c.a(G, new com.tencent.mm.hellhoundlib.b.a()).cG(paramString).aYi(), "com/unionpay/UPPayAssistEx", "a", "(Ljava/lang/String;)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
        AppMethodBeat.o(207326);
        return;
      }
      paramString.addFlags(268435456);
      localObject = aisw;
      paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
      com.tencent.mm.hellhoundlib.a.a.b(localObject, paramString.aYi(), "com/unionpay/UPPayAssistEx", "a", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((Context)localObject).startActivity((Intent)paramString.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/unionpay/UPPayAssistEx", "a", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(207326);
      return;
    }
    catch (ClassNotFoundException paramString)
    {
      AppMethodBeat.o(207326);
    }
  }
  
  private static void a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(207335);
    Bundle localBundle = new Bundle();
    int i1;
    if (!"link".equals(paramString2))
    {
      c(I, localBundle, L);
      localBundle.putString(a, J);
      localBundle.putString(c, K);
      i1 = 0;
    }
    try
    {
      int i2 = Integer.parseInt(L);
      i1 = i2;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label69:
      break label69;
    }
    localBundle.putString(b, UPUtils.forWap(i1, b.a(I)));
    localBundle.putString("magic_data", "949A1CC");
    localBundle.putString(i, paramString1);
    localBundle.putString(j, paramString2);
    try
    {
      paramString1 = new Intent();
      paramString1.putExtras(localBundle);
      paramString1.setClass(aisw, UPPayWapActivity.class);
      com.tencent.mm.hellhoundlib.a.a.a((Activity)aisw, com.tencent.mm.hellhoundlib.b.c.a(G, new com.tencent.mm.hellhoundlib.b.a()).cG(paramString1).aYi(), "com/unionpay/UPPayAssistEx", "a", "(Ljava/lang/String;Ljava/lang/String;)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
      AppMethodBeat.o(207335);
      return;
    }
    catch (Exception paramString1)
    {
      AppMethodBeat.o(207335);
      return;
    }
  }
  
  public static int ap(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(207317);
    aisw = paramContext;
    I = paramString1;
    J = null;
    K = null;
    L = paramString2;
    D = "";
    C = "";
    if (TextUtils.isEmpty("")) {}
    for (E = "0";; E = "1")
    {
      x = null;
      y = null;
      z = null;
      B = "";
      l();
      AppMethodBeat.o(207317);
      return 0;
    }
  }
  
  private static void c(String paramString)
  {
    AppMethodBeat.i(207369);
    try
    {
      paramString = new JSONObject(paramString);
      x = paramString.getString("titleLogo");
      y = paramString.getString("loadingLogo");
      z = paramString.getString("backGroundColor");
      A = paramString.getString("textColor");
      AppMethodBeat.o(207369);
      return;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(207369);
    }
  }
  
  private static void c(String paramString1, Bundle paramBundle, String paramString2)
  {
    AppMethodBeat.i(207342);
    if ((paramString1 == null) || (paramString1.trim().length() <= 0))
    {
      AppMethodBeat.o(207342);
      return;
    }
    if (paramString1.trim().charAt(0) == '<')
    {
      if ((paramString2 != null) && (paramString2.trim().equalsIgnoreCase("00")))
      {
        paramBundle.putBoolean(d, false);
        AppMethodBeat.o(207342);
        return;
      }
      paramBundle.putBoolean(d, true);
      AppMethodBeat.o(207342);
      return;
    }
    paramBundle.putString(n, paramString2);
    AppMethodBeat.o(207342);
  }
  
  private static String d(String paramString)
  {
    AppMethodBeat.i(207380);
    if (paramString != null)
    {
      paramString = Pattern.compile("[\":,\\[\\]{}]").matcher(paramString).replaceAll("").trim();
      AppMethodBeat.o(207380);
      return paramString;
    }
    AppMethodBeat.o(207380);
    return "";
  }
  
  private static JSONArray e(JSONArray paramJSONArray, String paramString)
  {
    AppMethodBeat.i(207367);
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    while ((paramJSONArray != null) && (i1 < paramJSONArray.length()))
    {
      localArrayList.add(paramJSONArray.optJSONObject(i1));
      i1 += 1;
    }
    Collections.sort(localArrayList, new e(paramString));
    paramJSONArray = new JSONArray();
    i1 = 0;
    while (i1 < localArrayList.size())
    {
      paramJSONArray.put((JSONObject)localArrayList.get(i1));
      i1 += 1;
    }
    AppMethodBeat.o(207367);
    return paramJSONArray;
  }
  
  /* Error */
  private static String f(Context paramContext, boolean paramBoolean, String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: ldc_w 543
    //   5: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: new 244	org/json/JSONObject
    //   11: dup
    //   12: invokespecial 544	org/json/JSONObject:<init>	()V
    //   15: astore 6
    //   17: getstatic 183	com/unionpay/a:L	Ljava/lang/String;
    //   20: invokestatic 440	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   23: istore 4
    //   25: iload 4
    //   27: istore_3
    //   28: iload_1
    //   29: ifne +22 -> 51
    //   32: aload 6
    //   34: ldc_w 546
    //   37: iload_3
    //   38: getstatic 177	com/unionpay/a:I	Ljava/lang/String;
    //   41: invokestatic 442	com/unionpay/utils/b:a	(Ljava/lang/String;)Ljava/lang/String;
    //   44: invokestatic 448	com/unionpay/utils/UPUtils:forWap	(ILjava/lang/String;)Ljava/lang/String;
    //   47: invokevirtual 549	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   50: pop
    //   51: aload 6
    //   53: ldc_w 550
    //   56: ldc_w 552
    //   59: invokevirtual 549	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   62: pop
    //   63: invokestatic 558	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   66: invokevirtual 561	java/util/Locale:toString	()Ljava/lang/String;
    //   69: ldc_w 563
    //   72: invokevirtual 566	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   75: ifeq +592 -> 667
    //   78: ldc_w 568
    //   81: astore 5
    //   83: aload 6
    //   85: ldc_w 570
    //   88: aload 5
    //   90: invokevirtual 549	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   93: pop
    //   94: aload 6
    //   96: ldc_w 572
    //   99: ldc_w 574
    //   102: invokevirtual 549	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   105: pop
    //   106: aload_0
    //   107: invokevirtual 578	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   110: invokevirtual 584	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   113: getfield 589	android/util/DisplayMetrics:widthPixels	I
    //   116: istore_3
    //   117: aload_0
    //   118: invokevirtual 578	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   121: invokevirtual 584	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   124: getfield 592	android/util/DisplayMetrics:heightPixels	I
    //   127: istore 4
    //   129: aload 6
    //   131: ldc_w 594
    //   134: new 596	java/lang/StringBuilder
    //   137: dup
    //   138: invokespecial 597	java/lang/StringBuilder:<init>	()V
    //   141: iload_3
    //   142: invokevirtual 601	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   145: ldc_w 603
    //   148: invokevirtual 606	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: iload 4
    //   153: invokevirtual 601	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   156: invokevirtual 607	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: invokevirtual 482	java/lang/String:trim	()Ljava/lang/String;
    //   162: invokevirtual 549	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   165: pop
    //   166: aload 6
    //   168: ldc_w 609
    //   171: ldc_w 611
    //   174: invokevirtual 549	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   177: pop
    //   178: aload 6
    //   180: ldc_w 613
    //   183: getstatic 618	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   186: invokevirtual 482	java/lang/String:trim	()Ljava/lang/String;
    //   189: invokevirtual 549	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   192: pop
    //   193: getstatic 623	android/os/Build:MODEL	Ljava/lang/String;
    //   196: invokevirtual 482	java/lang/String:trim	()Ljava/lang/String;
    //   199: astore 5
    //   201: aload 5
    //   203: ifnull +14 -> 217
    //   206: aload 5
    //   208: ldc_w 625
    //   211: ldc 163
    //   213: invokevirtual 629	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   216: pop
    //   217: aload 6
    //   219: ldc_w 631
    //   222: aload 5
    //   224: invokevirtual 549	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   227: pop
    //   228: aload 6
    //   230: ldc_w 633
    //   233: invokestatic 638	java/util/TimeZone:getDefault	()Ljava/util/TimeZone;
    //   236: iconst_0
    //   237: iconst_0
    //   238: invokevirtual 642	java/util/TimeZone:getDisplayName	(ZI)Ljava/lang/String;
    //   241: invokevirtual 549	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   244: pop
    //   245: aload_0
    //   246: ldc_w 644
    //   249: invokevirtual 647	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   252: checkcast 649	android/net/ConnectivityManager
    //   255: invokevirtual 653	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   258: astore 5
    //   260: aload 5
    //   262: ifnull +438 -> 700
    //   265: aload 5
    //   267: invokevirtual 659	android/net/NetworkInfo:isAvailable	()Z
    //   270: ifeq +430 -> 700
    //   273: aload 5
    //   275: invokevirtual 662	android/net/NetworkInfo:getType	()I
    //   278: ifne +405 -> 683
    //   281: aload 5
    //   283: invokevirtual 666	android/net/NetworkInfo:getState	()Landroid/net/NetworkInfo$State;
    //   286: getstatic 672	android/net/NetworkInfo$State:CONNECTED	Landroid/net/NetworkInfo$State;
    //   289: if_acmpne +386 -> 675
    //   292: new 596	java/lang/StringBuilder
    //   295: dup
    //   296: ldc_w 674
    //   299: invokespecial 675	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   302: aload 5
    //   304: invokevirtual 678	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   307: invokevirtual 606	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: invokevirtual 607	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   313: astore 5
    //   315: aload 6
    //   317: ldc_w 680
    //   320: aload 5
    //   322: invokevirtual 549	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   325: pop
    //   326: aload 6
    //   328: ldc_w 682
    //   331: invokestatic 686	com/unionpay/utils/e:a	()Ljava/lang/String;
    //   334: invokestatic 688	com/unionpay/a:d	(Ljava/lang/String;)Ljava/lang/String;
    //   337: invokevirtual 549	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   340: pop
    //   341: new 690	java/io/File
    //   344: dup
    //   345: ldc_w 692
    //   348: invokespecial 693	java/io/File:<init>	(Ljava/lang/String;)V
    //   351: invokevirtual 696	java/io/File:exists	()Z
    //   354: ifeq +354 -> 708
    //   357: ldc_w 464
    //   360: astore 5
    //   362: aload 6
    //   364: ldc_w 698
    //   367: aload 5
    //   369: invokevirtual 549	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   372: pop
    //   373: new 700	java/lang/StringBuffer
    //   376: dup
    //   377: ldc_w 702
    //   380: invokespecial 703	java/lang/StringBuffer:<init>	(Ljava/lang/String;)V
    //   383: astore 5
    //   385: getstatic 706	android/os/Build$VERSION:SDK_INT	I
    //   388: bipush 10
    //   390: if_icmplt +68 -> 458
    //   393: aload_0
    //   394: ldc_w 708
    //   397: invokevirtual 647	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   400: checkcast 710	android/nfc/NfcManager
    //   403: invokevirtual 714	android/nfc/NfcManager:getDefaultAdapter	()Landroid/nfc/NfcAdapter;
    //   406: astore 7
    //   408: aload 7
    //   410: ifnull +48 -> 458
    //   413: aload 7
    //   415: invokevirtual 719	android/nfc/NfcAdapter:isEnabled	()Z
    //   418: ifeq +297 -> 715
    //   421: aload 5
    //   423: iconst_0
    //   424: bipush 49
    //   426: invokevirtual 723	java/lang/StringBuffer:setCharAt	(IC)V
    //   429: getstatic 706	android/os/Build$VERSION:SDK_INT	I
    //   432: bipush 19
    //   434: if_icmplt +24 -> 458
    //   437: aload_0
    //   438: invokevirtual 727	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   441: ldc_w 729
    //   444: invokevirtual 734	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   447: ifeq +11 -> 458
    //   450: aload 5
    //   452: iconst_1
    //   453: bipush 49
    //   455: invokevirtual 723	java/lang/StringBuffer:setCharAt	(IC)V
    //   458: aload 6
    //   460: ldc_w 736
    //   463: aload 5
    //   465: invokevirtual 737	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   468: invokevirtual 549	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   471: pop
    //   472: aload 6
    //   474: ldc_w 739
    //   477: invokestatic 558	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   480: invokevirtual 742	java/util/Locale:getCountry	()Ljava/lang/String;
    //   483: invokestatic 688	com/unionpay/a:d	(Ljava/lang/String;)Ljava/lang/String;
    //   486: invokevirtual 549	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   489: pop
    //   490: aload_0
    //   491: checkcast 339	android/app/Activity
    //   494: invokevirtual 745	android/app/Activity:getPackageName	()Ljava/lang/String;
    //   497: astore 5
    //   499: aload 5
    //   501: ifnull +230 -> 731
    //   504: aload 6
    //   506: ldc_w 747
    //   509: aload 5
    //   511: invokestatic 688	com/unionpay/a:d	(Ljava/lang/String;)Ljava/lang/String;
    //   514: invokevirtual 549	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   517: pop
    //   518: aload_0
    //   519: invokestatic 751	com/unionpay/utils/e:pm	(Landroid/content/Context;)Landroid/location/Location;
    //   522: astore 5
    //   524: aload 5
    //   526: ifnull +263 -> 789
    //   529: aload 5
    //   531: invokevirtual 757	android/location/Location:getLatitude	()D
    //   534: invokestatic 763	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   537: invokevirtual 764	java/lang/Double:toString	()Ljava/lang/String;
    //   540: astore 5
    //   542: aload 6
    //   544: ldc_w 766
    //   547: aload 5
    //   549: invokestatic 688	com/unionpay/a:d	(Ljava/lang/String;)Ljava/lang/String;
    //   552: invokevirtual 549	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   555: pop
    //   556: aload_0
    //   557: invokestatic 751	com/unionpay/utils/e:pm	(Landroid/content/Context;)Landroid/location/Location;
    //   560: astore_0
    //   561: aload_0
    //   562: ifnull +176 -> 738
    //   565: aload_0
    //   566: invokevirtual 769	android/location/Location:getLongitude	()D
    //   569: invokestatic 763	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   572: invokevirtual 764	java/lang/Double:toString	()Ljava/lang/String;
    //   575: astore_0
    //   576: aload 6
    //   578: ldc_w 771
    //   581: aload_0
    //   582: invokestatic 688	com/unionpay/a:d	(Ljava/lang/String;)Ljava/lang/String;
    //   585: invokevirtual 549	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   588: pop
    //   589: iload_1
    //   590: ifeq +14 -> 604
    //   593: aload 6
    //   595: ldc_w 773
    //   598: ldc 224
    //   600: invokevirtual 549	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   603: pop
    //   604: aload 6
    //   606: ldc_w 775
    //   609: getstatic 165	com/unionpay/a:B	Ljava/lang/String;
    //   612: invokestatic 777	com/unionpay/utils/b:b	(Ljava/lang/String;)Ljava/lang/String;
    //   615: invokevirtual 549	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   618: pop
    //   619: aload 6
    //   621: ldc_w 779
    //   624: getstatic 171	com/unionpay/a:E	Ljava/lang/String;
    //   627: invokevirtual 549	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   630: pop
    //   631: aload 6
    //   633: ldc_w 781
    //   636: aload_2
    //   637: invokevirtual 549	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   640: pop
    //   641: aload 6
    //   643: ldc_w 783
    //   646: ldc_w 785
    //   649: invokevirtual 549	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   652: pop
    //   653: aload 6
    //   655: invokevirtual 786	org/json/JSONObject:toString	()Ljava/lang/String;
    //   658: astore_0
    //   659: ldc_w 543
    //   662: invokestatic 218	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   665: aload_0
    //   666: areturn
    //   667: ldc_w 788
    //   670: astore 5
    //   672: goto -589 -> 83
    //   675: ldc_w 790
    //   678: astore 5
    //   680: goto -365 -> 315
    //   683: aload 5
    //   685: invokevirtual 662	android/net/NetworkInfo:getType	()I
    //   688: iconst_1
    //   689: if_icmpne +92 -> 781
    //   692: ldc_w 792
    //   695: astore 5
    //   697: goto -382 -> 315
    //   700: ldc_w 794
    //   703: astore 5
    //   705: goto -390 -> 315
    //   708: ldc 224
    //   710: astore 5
    //   712: goto -350 -> 362
    //   715: aload 5
    //   717: iconst_0
    //   718: bipush 50
    //   720: invokevirtual 723	java/lang/StringBuffer:setCharAt	(IC)V
    //   723: goto -294 -> 429
    //   726: astore 5
    //   728: goto -256 -> 472
    //   731: ldc 163
    //   733: astore 5
    //   735: goto -231 -> 504
    //   738: ldc 163
    //   740: astore_0
    //   741: goto -165 -> 576
    //   744: astore_0
    //   745: goto -92 -> 653
    //   748: astore_0
    //   749: goto -96 -> 653
    //   752: astore_0
    //   753: goto -100 -> 653
    //   756: astore 5
    //   758: goto -385 -> 373
    //   761: astore 5
    //   763: goto -422 -> 341
    //   766: astore 5
    //   768: goto -442 -> 326
    //   771: astore 5
    //   773: goto -528 -> 245
    //   776: astore 5
    //   778: goto -750 -> 28
    //   781: ldc_w 796
    //   784: astore 5
    //   786: goto -471 -> 315
    //   789: ldc 163
    //   791: astore 5
    //   793: goto -251 -> 542
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	796	0	paramContext	Context
    //   0	796	1	paramBoolean	boolean
    //   0	796	2	paramString	String
    //   1	141	3	i1	int
    //   23	129	4	i2	int
    //   81	635	5	localObject	Object
    //   726	1	5	localException1	Exception
    //   733	1	5	str1	String
    //   756	1	5	localException2	Exception
    //   761	1	5	localException3	Exception
    //   766	1	5	localException4	Exception
    //   771	1	5	localException5	Exception
    //   776	1	5	localNumberFormatException	NumberFormatException
    //   784	8	5	str2	String
    //   15	639	6	localJSONObject	JSONObject
    //   406	8	7	localNfcAdapter	android.nfc.NfcAdapter
    // Exception table:
    //   from	to	target	type
    //   373	408	726	java/lang/Exception
    //   413	429	726	java/lang/Exception
    //   429	458	726	java/lang/Exception
    //   458	472	726	java/lang/Exception
    //   715	723	726	java/lang/Exception
    //   17	25	744	java/lang/Exception
    //   32	51	744	java/lang/Exception
    //   51	78	744	java/lang/Exception
    //   83	201	744	java/lang/Exception
    //   206	217	744	java/lang/Exception
    //   217	228	744	java/lang/Exception
    //   472	499	744	java/lang/Exception
    //   504	524	744	java/lang/Exception
    //   529	542	744	java/lang/Exception
    //   542	561	744	java/lang/Exception
    //   565	576	744	java/lang/Exception
    //   576	589	744	java/lang/Exception
    //   593	604	744	java/lang/Exception
    //   604	653	744	java/lang/Exception
    //   17	25	748	java/util/regex/PatternSyntaxException
    //   32	51	748	java/util/regex/PatternSyntaxException
    //   51	78	748	java/util/regex/PatternSyntaxException
    //   83	201	748	java/util/regex/PatternSyntaxException
    //   206	217	748	java/util/regex/PatternSyntaxException
    //   217	228	748	java/util/regex/PatternSyntaxException
    //   228	245	748	java/util/regex/PatternSyntaxException
    //   245	260	748	java/util/regex/PatternSyntaxException
    //   265	315	748	java/util/regex/PatternSyntaxException
    //   315	326	748	java/util/regex/PatternSyntaxException
    //   326	341	748	java/util/regex/PatternSyntaxException
    //   341	357	748	java/util/regex/PatternSyntaxException
    //   362	373	748	java/util/regex/PatternSyntaxException
    //   373	408	748	java/util/regex/PatternSyntaxException
    //   413	429	748	java/util/regex/PatternSyntaxException
    //   429	458	748	java/util/regex/PatternSyntaxException
    //   458	472	748	java/util/regex/PatternSyntaxException
    //   472	499	748	java/util/regex/PatternSyntaxException
    //   504	524	748	java/util/regex/PatternSyntaxException
    //   529	542	748	java/util/regex/PatternSyntaxException
    //   542	561	748	java/util/regex/PatternSyntaxException
    //   565	576	748	java/util/regex/PatternSyntaxException
    //   576	589	748	java/util/regex/PatternSyntaxException
    //   593	604	748	java/util/regex/PatternSyntaxException
    //   604	653	748	java/util/regex/PatternSyntaxException
    //   683	692	748	java/util/regex/PatternSyntaxException
    //   715	723	748	java/util/regex/PatternSyntaxException
    //   17	25	752	org/json/JSONException
    //   32	51	752	org/json/JSONException
    //   51	78	752	org/json/JSONException
    //   83	201	752	org/json/JSONException
    //   206	217	752	org/json/JSONException
    //   217	228	752	org/json/JSONException
    //   228	245	752	org/json/JSONException
    //   245	260	752	org/json/JSONException
    //   265	315	752	org/json/JSONException
    //   315	326	752	org/json/JSONException
    //   326	341	752	org/json/JSONException
    //   341	357	752	org/json/JSONException
    //   362	373	752	org/json/JSONException
    //   373	408	752	org/json/JSONException
    //   413	429	752	org/json/JSONException
    //   429	458	752	org/json/JSONException
    //   458	472	752	org/json/JSONException
    //   472	499	752	org/json/JSONException
    //   504	524	752	org/json/JSONException
    //   529	542	752	org/json/JSONException
    //   542	561	752	org/json/JSONException
    //   565	576	752	org/json/JSONException
    //   576	589	752	org/json/JSONException
    //   593	604	752	org/json/JSONException
    //   604	653	752	org/json/JSONException
    //   683	692	752	org/json/JSONException
    //   715	723	752	org/json/JSONException
    //   341	357	756	java/lang/Exception
    //   362	373	756	java/lang/Exception
    //   326	341	761	java/lang/Exception
    //   245	260	766	java/lang/Exception
    //   265	315	766	java/lang/Exception
    //   315	326	766	java/lang/Exception
    //   683	692	766	java/lang/Exception
    //   228	245	771	java/lang/Exception
    //   17	25	776	java/lang/NumberFormatException
  }
  
  /* Error */
  private static int l()
  {
    // Byte code:
    //   0: ldc_w 805
    //   3: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: getstatic 337	com/unionpay/a:aisw	Landroid/content/Context;
    //   9: ifnonnull +11 -> 20
    //   12: ldc_w 805
    //   15: invokestatic 218	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   18: iconst_1
    //   19: ireturn
    //   20: getstatic 167	com/unionpay/a:C	Ljava/lang/String;
    //   23: invokestatic 308	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   26: ifeq +12 -> 38
    //   29: getstatic 169	com/unionpay/a:D	Ljava/lang/String;
    //   32: invokestatic 308	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   35: ifne +555 -> 590
    //   38: iconst_1
    //   39: putstatic 173	com/unionpay/a:F	Z
    //   42: getstatic 161	com/unionpay/a:w	Ljava/lang/String;
    //   45: getstatic 169	com/unionpay/a:D	Ljava/lang/String;
    //   48: invokevirtual 287	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   51: ifeq +9 -> 60
    //   54: getstatic 137	com/unionpay/a:q	Ljava/lang/String;
    //   57: putstatic 167	com/unionpay/a:C	Ljava/lang/String;
    //   60: iconst_0
    //   61: putstatic 191	com/unionpay/a:P	I
    //   64: iconst_0
    //   65: putstatic 193	com/unionpay/a:Q	Z
    //   68: new 341	com/tencent/mm/hellhoundlib/b/a
    //   71: dup
    //   72: invokespecial 342	com/tencent/mm/hellhoundlib/b/a:<init>	()V
    //   75: ldc_w 807
    //   78: invokevirtual 351	com/tencent/mm/hellhoundlib/b/a:cG	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   81: astore_1
    //   82: new 4	java/lang/Object
    //   85: dup
    //   86: invokespecial 808	java/lang/Object:<init>	()V
    //   89: astore_2
    //   90: aload_2
    //   91: aload_1
    //   92: invokevirtual 355	com/tencent/mm/hellhoundlib/b/a:aYi	()[Ljava/lang/Object;
    //   95: ldc_w 357
    //   98: ldc_w 809
    //   101: ldc_w 810
    //   104: ldc_w 812
    //   107: ldc_w 814
    //   110: ldc_w 431
    //   113: invokestatic 385	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   116: aload_1
    //   117: iconst_0
    //   118: invokevirtual 389	com/tencent/mm/hellhoundlib/b/a:sb	(I)Ljava/lang/Object;
    //   121: checkcast 253	java/lang/String
    //   124: invokestatic 818	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   127: aload_2
    //   128: ldc_w 357
    //   131: ldc_w 809
    //   134: ldc_w 810
    //   137: ldc_w 812
    //   140: ldc_w 814
    //   143: ldc_w 431
    //   146: invokestatic 396	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   149: getstatic 337	com/unionpay/a:aisw	Landroid/content/Context;
    //   152: new 596	java/lang/StringBuilder
    //   155: dup
    //   156: ldc_w 820
    //   159: invokespecial 675	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   162: getstatic 169	com/unionpay/a:D	Ljava/lang/String;
    //   165: invokevirtual 606	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: invokevirtual 607	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: invokestatic 822	com/unionpay/utils/UPUtils:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   174: astore_2
    //   175: getstatic 337	com/unionpay/a:aisw	Landroid/content/Context;
    //   178: new 596	java/lang/StringBuilder
    //   181: dup
    //   182: ldc_w 824
    //   185: invokespecial 675	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   188: getstatic 169	com/unionpay/a:D	Ljava/lang/String;
    //   191: invokevirtual 606	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: invokevirtual 607	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   197: invokestatic 822	com/unionpay/utils/UPUtils:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   200: astore_1
    //   201: getstatic 337	com/unionpay/a:aisw	Landroid/content/Context;
    //   204: new 596	java/lang/StringBuilder
    //   207: dup
    //   208: ldc_w 826
    //   211: invokespecial 675	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   214: getstatic 169	com/unionpay/a:D	Ljava/lang/String;
    //   217: invokevirtual 606	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: invokevirtual 607	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: invokestatic 822	com/unionpay/utils/UPUtils:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   226: astore_3
    //   227: aload_2
    //   228: invokestatic 308	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   231: ifne +216 -> 447
    //   234: aload_1
    //   235: invokestatic 308	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   238: ifne +209 -> 447
    //   241: aload_3
    //   242: invokestatic 308	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   245: ifne +202 -> 447
    //   248: new 244	org/json/JSONObject
    //   251: dup
    //   252: aload_2
    //   253: invokespecial 470	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   256: astore_2
    //   257: aload_2
    //   258: ldc_w 273
    //   261: invokestatic 249	com/unionpay/utils/i:v	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   264: astore 4
    //   266: aload_1
    //   267: invokestatic 440	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   270: istore_0
    //   271: new 253	java/lang/String
    //   274: dup
    //   275: aload_2
    //   276: ldc_w 820
    //   279: invokevirtual 423	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   282: iconst_2
    //   283: invokestatic 832	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   286: invokespecial 835	java/lang/String:<init>	([B)V
    //   289: astore 5
    //   291: ldc 163
    //   293: astore_1
    //   294: aload_2
    //   295: ldc_w 837
    //   298: invokevirtual 840	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   301: ifeq +22 -> 323
    //   304: new 253	java/lang/String
    //   307: dup
    //   308: aload_2
    //   309: ldc_w 837
    //   312: invokevirtual 423	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   315: iconst_2
    //   316: invokestatic 832	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   319: invokespecial 835	java/lang/String:<init>	([B)V
    //   322: astore_1
    //   323: aload_1
    //   324: astore_2
    //   325: aload_1
    //   326: invokestatic 308	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   329: ifeq +6 -> 335
    //   332: ldc 163
    //   334: astore_2
    //   335: new 596	java/lang/StringBuilder
    //   338: dup
    //   339: invokespecial 597	java/lang/StringBuilder:<init>	()V
    //   342: aload 5
    //   344: invokevirtual 606	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: aload_2
    //   348: invokevirtual 606	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: aload_3
    //   352: invokevirtual 606	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: invokevirtual 607	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   358: invokestatic 841	com/unionpay/utils/UPUtils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   361: invokestatic 442	com/unionpay/utils/b:a	(Ljava/lang/String;)Ljava/lang/String;
    //   364: astore_1
    //   365: iload_0
    //   366: aload 4
    //   368: invokestatic 844	com/unionpay/utils/UPUtils:forConfig	(ILjava/lang/String;)Ljava/lang/String;
    //   371: astore_2
    //   372: aload_2
    //   373: invokestatic 308	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   376: ifne +71 -> 447
    //   379: aload_2
    //   380: aload_1
    //   381: invokevirtual 257	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   384: ifeq +63 -> 447
    //   387: getstatic 169	com/unionpay/a:D	Ljava/lang/String;
    //   390: invokestatic 308	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   393: ifeq +210 -> 603
    //   396: aload 5
    //   398: putstatic 201	com/unionpay/a:T	Ljava/lang/String;
    //   401: getstatic 165	com/unionpay/a:B	Ljava/lang/String;
    //   404: invokestatic 308	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   407: ifne +40 -> 447
    //   410: getstatic 337	com/unionpay/a:aisw	Landroid/content/Context;
    //   413: new 596	java/lang/StringBuilder
    //   416: dup
    //   417: ldc_w 846
    //   420: invokespecial 675	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   423: getstatic 165	com/unionpay/a:B	Ljava/lang/String;
    //   426: invokevirtual 606	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: invokevirtual 607	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   432: invokestatic 822	com/unionpay/utils/UPUtils:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   435: astore_1
    //   436: aload_1
    //   437: invokestatic 308	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   440: ifne +7 -> 447
    //   443: aload_1
    //   444: invokestatic 467	com/unionpay/a:c	(Ljava/lang/String;)V
    //   447: getstatic 169	com/unionpay/a:D	Ljava/lang/String;
    //   450: invokestatic 308	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   453: ifeq +178 -> 631
    //   456: new 233	org/json/JSONArray
    //   459: dup
    //   460: getstatic 201	com/unionpay/a:T	Ljava/lang/String;
    //   463: invokespecial 847	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   466: ldc_w 266
    //   469: invokestatic 269	com/unionpay/a:e	(Lorg/json/JSONArray;Ljava/lang/String;)Lorg/json/JSONArray;
    //   472: putstatic 371	com/unionpay/a:aisz	Lorg/json/JSONArray;
    //   475: getstatic 337	com/unionpay/a:aisw	Landroid/content/Context;
    //   478: astore_1
    //   479: getstatic 183	com/unionpay/a:L	Ljava/lang/String;
    //   482: invokestatic 440	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   485: istore_0
    //   486: iload_0
    //   487: invokestatic 851	com/unionpay/utils/UPUtils:forUrl	(I)Ljava/lang/String;
    //   490: astore_2
    //   491: ldc_w 853
    //   494: aload_2
    //   495: invokestatic 856	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   498: invokevirtual 859	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   501: pop
    //   502: invokestatic 864	com/unionpay/utils/j:kkB	()I
    //   505: pop
    //   506: new 866	com/unionpay/a/d
    //   509: dup
    //   510: aload_2
    //   511: invokespecial 867	com/unionpay/a/d:<init>	(Ljava/lang/String;)V
    //   514: putstatic 195	com/unionpay/a:aisx	Lcom/unionpay/a/d;
    //   517: aload_1
    //   518: iconst_0
    //   519: ldc 224
    //   521: invokestatic 227	com/unionpay/a:f	(Landroid/content/Context;ZLjava/lang/String;)Ljava/lang/String;
    //   524: astore_1
    //   525: getstatic 195	com/unionpay/a:aisx	Lcom/unionpay/a/d;
    //   528: astore_2
    //   529: aload_1
    //   530: ifnull +16 -> 546
    //   533: aload_2
    //   534: aload_1
    //   535: invokevirtual 871	java/lang/String:getBytes	()[B
    //   538: putfield 874	com/unionpay/a/d:d	[B
    //   541: aload_2
    //   542: aload_1
    //   543: putfield 875	com/unionpay/a/d:e	Ljava/lang/String;
    //   546: getstatic 197	com/unionpay/a:aisy	Landroid/os/Handler;
    //   549: ifnonnull +16 -> 565
    //   552: new 877	android/os/Handler
    //   555: dup
    //   556: getstatic 216	com/unionpay/a:aisA	Landroid/os/Handler$Callback;
    //   559: invokespecial 880	android/os/Handler:<init>	(Landroid/os/Handler$Callback;)V
    //   562: putstatic 197	com/unionpay/a:aisy	Landroid/os/Handler;
    //   565: new 882	com/unionpay/d
    //   568: dup
    //   569: invokespecial 883	com/unionpay/d:<init>	()V
    //   572: astore_1
    //   573: invokestatic 889	java/util/concurrent/Executors:newSingleThreadExecutor	()Ljava/util/concurrent/ExecutorService;
    //   576: aload_1
    //   577: invokeinterface 895 2 0
    //   582: ldc_w 805
    //   585: invokestatic 218	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   588: iconst_0
    //   589: ireturn
    //   590: iconst_0
    //   591: putstatic 173	com/unionpay/a:F	Z
    //   594: goto -534 -> 60
    //   597: astore_1
    //   598: iconst_0
    //   599: istore_0
    //   600: goto -329 -> 271
    //   603: ldc_w 897
    //   606: getstatic 169	com/unionpay/a:D	Ljava/lang/String;
    //   609: invokevirtual 257	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   612: ifeq +11 -> 623
    //   615: aload 5
    //   617: putstatic 209	com/unionpay/a:V	Ljava/lang/String;
    //   620: goto -219 -> 401
    //   623: aload 5
    //   625: putstatic 205	com/unionpay/a:U	Ljava/lang/String;
    //   628: goto -227 -> 401
    //   631: ldc_w 897
    //   634: getstatic 169	com/unionpay/a:D	Ljava/lang/String;
    //   637: invokevirtual 257	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   640: ifeq +25 -> 665
    //   643: new 233	org/json/JSONArray
    //   646: dup
    //   647: getstatic 209	com/unionpay/a:V	Ljava/lang/String;
    //   650: invokespecial 847	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   653: ldc_w 266
    //   656: invokestatic 269	com/unionpay/a:e	(Lorg/json/JSONArray;Ljava/lang/String;)Lorg/json/JSONArray;
    //   659: putstatic 371	com/unionpay/a:aisz	Lorg/json/JSONArray;
    //   662: goto -187 -> 475
    //   665: new 233	org/json/JSONArray
    //   668: dup
    //   669: getstatic 205	com/unionpay/a:U	Ljava/lang/String;
    //   672: invokespecial 847	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   675: ldc_w 266
    //   678: invokestatic 269	com/unionpay/a:e	(Lorg/json/JSONArray;Ljava/lang/String;)Lorg/json/JSONArray;
    //   681: putstatic 371	com/unionpay/a:aisz	Lorg/json/JSONArray;
    //   684: goto -209 -> 475
    //   687: astore_2
    //   688: iconst_0
    //   689: istore_0
    //   690: goto -204 -> 486
    //   693: astore_1
    //   694: goto -247 -> 447
    //   697: astore_1
    //   698: goto -223 -> 475
    // Local variable table:
    //   start	length	slot	name	signature
    //   270	420	0	i1	int
    //   81	496	1	localObject1	Object
    //   597	1	1	localNumberFormatException1	NumberFormatException
    //   693	1	1	localException1	Exception
    //   697	1	1	localException2	Exception
    //   89	453	2	localObject2	Object
    //   687	1	2	localNumberFormatException2	NumberFormatException
    //   226	126	3	str1	String
    //   264	103	4	str2	String
    //   289	335	5	str3	String
    // Exception table:
    //   from	to	target	type
    //   266	271	597	java/lang/NumberFormatException
    //   479	486	687	java/lang/NumberFormatException
    //   248	266	693	java/lang/Exception
    //   266	271	693	java/lang/Exception
    //   271	291	693	java/lang/Exception
    //   294	323	693	java/lang/Exception
    //   325	332	693	java/lang/Exception
    //   335	401	693	java/lang/Exception
    //   401	447	693	java/lang/Exception
    //   603	620	693	java/lang/Exception
    //   623	628	693	java/lang/Exception
    //   447	475	697	java/lang/Exception
    //   631	662	697	java/lang/Exception
    //   665	684	697	java/lang/Exception
  }
  
  public static boolean pk(Context paramContext)
  {
    AppMethodBeat.i(207373);
    if ((b.a(paramContext, "com.unionpay")) && ("536C79B93ACFBEA950AE365D8CE1AEF91FEA9535".equalsIgnoreCase(b.b(paramContext, "com.unionpay"))))
    {
      AppMethodBeat.o(207373);
      return true;
    }
    AppMethodBeat.o(207373);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.unionpay.a
 * JD-Core Version:    0.7.0.1
 */