package com.tencent.mm.wallet_core.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.so;
import com.tencent.mm.kernel.b;
import com.tencent.mm.model.bk;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

public final class e
{
  private static final com.tencent.mm.sdk.platformtools.ae<Integer, Typeface> AYD;
  private static SimpleDateFormat kTX;
  private static final String[] upb;
  protected static final Pattern wcf;
  
  static
  {
    AppMethodBeat.i(49328);
    wcf = Pattern.compile("((?:(http|https|Http|Https):\\/\\/(?:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,64}(?:\\:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,25})?\\@)?)?((?:(?:[a-zA-Z0-9][a-zA-Z0-9\\-\\_]{0,64}\\.)+(?:(?:aero|arpa|asia|a[cdefgilmnoqrstuwxz])|(?:biz|b[abdefghijmnorstvwyz])|(?:cat|com|coop|c[acdfghiklmnoruvxyz])|d[ejkmoz]|(?:edu|e[cegrstu])|f[ijkmor]|(?:gov|g[abdefghilmnpqrstuwy])|h[kmnrtu]|(?:info|int|i[delmnoqrst])|(?:jobs|j[emop])|k[eghimnrwyz]|l[abcikrstuvy]|(?:mil|mobi|museum|m[acdeghklmnopqrstuvwxyz])|(?:name|net|n[acefgilopruz])|(?:org|om)|(?:pro|p[aefghklmnrstwy])|qa|r[eouw]|s[abcdeghijklmnortuvyz]|(?:tel|travel|t[cdfghjklmnoprtvwz])|u[agkmsyz]|v[aceginu]|w[fs]|y[etu]|z[amw]))|(?:(?:25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(?:25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(?:25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(?:25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9])))(?:\\:\\d{1,5})?)(\\/(?:(?:[a-zA-Z0-9\\;\\/\\?\\:\\@\\&\\=\\#\\~\\-\\.\\+\\!\\*\\'\\(\\)\\,\\_])|(?:\\%[a-fA-F0-9]{2}))*)?");
    upb = new String[] { "ABC_DEBIT", "ABC_CREDIT", "CITIC_CREDIT", "CMBC_DEBIT", "COMM_DEBIT", "HSBC_DEBIT" };
    AYD = new com.tencent.mm.sdk.platformtools.ae(4);
    kTX = null;
    AppMethodBeat.o(49328);
  }
  
  public static String E(double paramDouble)
  {
    AppMethodBeat.i(49270);
    String str = String.format("%.2f", new Object[] { Double.valueOf(paramDouble) });
    AppMethodBeat.o(49270);
    return str;
  }
  
  public static String F(double paramDouble)
  {
    AppMethodBeat.i(49269);
    String str = e(paramDouble, "");
    AppMethodBeat.o(49269);
    return str;
  }
  
  public static long G(double paramDouble)
  {
    AppMethodBeat.i(49292);
    long l = Math.round(100.0D * paramDouble);
    AppMethodBeat.o(49292);
    return l;
  }
  
  public static Bitmap H(Bitmap paramBitmap)
  {
    boolean bool = true;
    AppMethodBeat.i(49300);
    Object localObject = new Matrix();
    ((Matrix)localObject).reset();
    ((Matrix)localObject).setRotate(90.0F, paramBitmap.getWidth() / 2, paramBitmap.getHeight() / 2);
    paramBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject, true);
    localObject = new StringBuilder("resultBmp is null: ");
    if (paramBitmap == null) {}
    for (;;)
    {
      ab.d("MicroMsg.WalletBaseUtil ", bool + "  degree:90.0");
      AppMethodBeat.o(49300);
      return paramBitmap;
      bool = false;
    }
  }
  
  public static void I(Bitmap paramBitmap)
  {
    AppMethodBeat.i(49299);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
      paramBitmap.recycle();
    }
    AppMethodBeat.o(49299);
  }
  
  public static String RV(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "fonts/WeChatSansSS-Medium.ttf";
    case 0: 
      return "fonts/WeChatSansSS-Medium.ttf";
    case 2: 
      return "fonts/WeChatSansSS-Light.ttf";
    case 1: 
      return "fonts/WeChatSansSS-Bold.ttf";
    case 3: 
      return "fonts/WeChatSansSS-Regular.ttf";
    case 4: 
      return "fonts/WeChatSansStd-Medium.ttf";
    case 6: 
      return "fonts/WeChatSansStd-Light.ttf";
    case 5: 
      return "fonts/WeChatSansStd-Bold.ttf";
    }
    return "fonts/WeChatSansStd-Regular.ttf";
  }
  
  public static String RW(int paramInt)
  {
    AppMethodBeat.i(49273);
    String str = a(paramInt, new SimpleDateFormat("MM-dd HH:mm"), new SimpleDateFormat("yyyy-MM-dd HH:mm"));
    AppMethodBeat.o(49273);
    return str;
  }
  
  public static void RX(int paramInt)
  {
    AppMethodBeat.i(49304);
    com.tencent.mm.plugin.report.service.h.qsU.e(12719, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(1) });
    AppMethodBeat.o(49304);
  }
  
  public static long a(String paramString1, String paramString2, RoundingMode paramRoundingMode)
  {
    AppMethodBeat.i(49312);
    long l = a(paramString1, paramString2, 0, paramRoundingMode).longValue();
    AppMethodBeat.o(49312);
    return l;
  }
  
  public static String a(int paramInt, SimpleDateFormat paramSimpleDateFormat1, SimpleDateFormat paramSimpleDateFormat2)
  {
    AppMethodBeat.i(49274);
    long l = paramInt * 1000L;
    GregorianCalendar localGregorianCalendar1 = new GregorianCalendar();
    GregorianCalendar localGregorianCalendar2 = new GregorianCalendar();
    localGregorianCalendar2.setTimeInMillis(l);
    if (localGregorianCalendar1.get(1) == localGregorianCalendar2.get(1))
    {
      paramSimpleDateFormat1 = paramSimpleDateFormat1.format(new Date(l));
      AppMethodBeat.o(49274);
      return paramSimpleDateFormat1;
    }
    paramSimpleDateFormat1 = paramSimpleDateFormat2.format(new Date(l));
    AppMethodBeat.o(49274);
    return paramSimpleDateFormat1;
  }
  
  public static BigDecimal a(String paramString1, String paramString2, int paramInt, RoundingMode paramRoundingMode)
  {
    AppMethodBeat.i(49314);
    try
    {
      if (bo.getDouble(paramString1, 0.0D) == 0.0D) {}
      for (paramString1 = "0";; paramString1 = paramString1.trim())
      {
        paramString1 = new BigDecimal(paramString1).divide(new BigDecimal(paramString2.trim()), paramInt, paramRoundingMode);
        AppMethodBeat.o(49314);
        return paramString1;
      }
      return paramString1;
    }
    catch (Exception paramString1)
    {
      ab.printErrStackTrace("MicroMsg.WalletBaseUtil ", paramString1, "", new Object[0]);
      paramString1 = new BigDecimal(0);
      AppMethodBeat.o(49314);
    }
  }
  
  public static void a(int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(49307);
    com.tencent.mm.plugin.report.service.h.qsU.e(13375, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(1), Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(49307);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(49288);
    LinkedList localLinkedList1 = new LinkedList();
    LinkedList localLinkedList2 = new LinkedList();
    localLinkedList1.add(paramContext.getString(2131304897));
    localLinkedList2.add(Integer.valueOf(0));
    if ((paramString1 != null) && (paramBoolean2))
    {
      localLinkedList1.add(paramContext.getString(2131304895));
      localLinkedList2.add(Integer.valueOf(1));
    }
    if ((paramBoolean1) && (!bo.isNullOrNil(paramString2)))
    {
      localLinkedList1.add(paramContext.getString(2131304898, new Object[] { paramString2 }));
      localLinkedList2.add(Integer.valueOf(2));
      localLinkedList1.add(paramContext.getString(2131304899, new Object[] { paramString2 }));
      localLinkedList2.add(Integer.valueOf(3));
    }
    com.tencent.mm.ui.base.h.a(paramContext, "", localLinkedList1, localLinkedList2, "", new e.1(paramContext, paramString1));
    AppMethodBeat.o(49288);
  }
  
  public static void a(Context paramContext, String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(49277);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("showShare", paramBoolean);
    com.tencent.mm.bq.d.b(paramContext, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent, paramInt);
    AppMethodBeat.o(49277);
  }
  
  public static void a(TextView paramTextView, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(49305);
    if (paramTextView == null)
    {
      ab.e("MicroMsg.WalletBaseUtil ", "hy: text view is null.");
      AppMethodBeat.o(49305);
      return;
    }
    if (bo.isNullOrNil(paramString2))
    {
      ab.w("MicroMsg.WalletBaseUtil ", "hy: msg is null. set text view to gone");
      paramTextView.setVisibility(8);
      AppMethodBeat.o(49305);
      return;
    }
    paramTextView.setVisibility(0);
    paramTextView.setText(paramString2);
    com.tencent.mm.protocal.g.gK(awi(paramString1), 0);
    if (!bo.isNullOrNil(paramString3)) {
      paramTextView.setOnClickListener(new e.6(paramString3, paramTextView, paramString1));
    }
    AppMethodBeat.o(49305);
  }
  
  public static void a(String paramString, e.b paramb)
  {
    AppMethodBeat.i(49294);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.a(new bk(new e.3(paramString, paramb)), 0);
    AppMethodBeat.o(49294);
  }
  
  public static void a(c... paramVarArgs)
  {
    AppMethodBeat.i(49293);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.a(new bk(new e.2(paramVarArgs)), 0);
    AppMethodBeat.o(49293);
  }
  
  public static void a(String[] paramArrayOfString, e.a parama)
  {
    AppMethodBeat.i(49303);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.a(new bk(new e.5(paramArrayOfString, parama)), 0);
    AppMethodBeat.o(49303);
  }
  
  public static Typeface aD(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(49265);
    if (paramInt == 8)
    {
      paramContext = Typeface.DEFAULT;
      AppMethodBeat.o(49265);
      return paramContext;
    }
    if (Build.VERSION.SDK_INT > 23)
    {
      paramContext = Typeface.createFromAsset(paramContext.getAssets(), RV(paramInt));
      AppMethodBeat.o(49265);
      return paramContext;
    }
    Typeface localTypeface2 = (Typeface)AYD.get(Integer.valueOf(paramInt));
    Typeface localTypeface1 = localTypeface2;
    if (localTypeface2 == null)
    {
      localTypeface1 = Typeface.createFromAsset(paramContext.getAssets(), RV(paramInt));
      AYD.put(Integer.valueOf(paramInt), localTypeface1);
    }
    AppMethodBeat.o(49265);
    return localTypeface1;
  }
  
  public static void aE(View paramView, int paramInt)
  {
    AppMethodBeat.i(49320);
    View localView = (View)paramView.getParent();
    localView.post(new e.7(paramView, paramInt, localView));
    AppMethodBeat.o(49320);
  }
  
  public static void ad(Context paramContext, String paramString)
  {
    AppMethodBeat.i(49278);
    if (TextUtils.isEmpty(paramString))
    {
      ab.v("MicroMsg.WalletBaseUtil ", "username is null");
      AppMethodBeat.o(49278);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("Contact_User", paramString);
    localIntent.putExtra("force_get_contact", true);
    com.tencent.mm.bq.d.b(paramContext, "profile", ".ui.ContactInfoUI", localIntent);
    AppMethodBeat.o(49278);
  }
  
  public static void ae(Context paramContext, String paramString)
  {
    AppMethodBeat.i(49275);
    if (TextUtils.isEmpty(paramString))
    {
      ab.v("MicroMsg.WalletBaseUtil ", "username is null");
      AppMethodBeat.o(49275);
      return;
    }
    if (t.nT(paramString))
    {
      af(paramContext, paramString);
      AppMethodBeat.o(49275);
      return;
    }
    ad(paramContext, paramString);
    AppMethodBeat.o(49275);
  }
  
  public static void af(Context paramContext, String paramString)
  {
    AppMethodBeat.i(49280);
    if (TextUtils.isEmpty(paramString))
    {
      ab.v("MicroMsg.WalletBaseUtil ", "username is null");
      AppMethodBeat.o(49280);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("Chat_User", paramString);
    localIntent.putExtra("finish_direct", true);
    com.tencent.mm.bq.d.f(paramContext, ".ui.chatting.ChattingUI", localIntent);
    AppMethodBeat.o(49280);
  }
  
  public static void ai(Context paramContext, String paramString)
  {
    AppMethodBeat.i(49323);
    String str = paramString;
    if (bo.isNullOrNil(paramString)) {
      str = ah.getContext().getString(2131305682);
    }
    com.tencent.mm.ui.base.h.b(paramContext, str, "", true);
    AppMethodBeat.o(49323);
  }
  
  public static void at(ArrayList<Bitmap> paramArrayList)
  {
    AppMethodBeat.i(49298);
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      int i = paramArrayList.size() - 1;
      while (i > 0)
      {
        I((Bitmap)paramArrayList.remove(i));
        i -= 1;
      }
    }
    AppMethodBeat.o(49298);
  }
  
  public static String avZ(String paramString)
  {
    AppMethodBeat.i(49268);
    if ("CNY".equals(paramString))
    {
      AppMethodBeat.o(49268);
      return "¥";
    }
    if ("ZAR".equals(paramString))
    {
      AppMethodBeat.o(49268);
      return "R";
    }
    if (("1".equals(paramString)) || (bo.isNullOrNil(paramString)))
    {
      paramString = com.tencent.mm.wallet_core.c.ae.dSz();
      AppMethodBeat.o(49268);
      return paramString;
    }
    AppMethodBeat.o(49268);
    return paramString;
  }
  
  public static String awa(String paramString)
  {
    AppMethodBeat.i(49271);
    if (("CNY".equals(paramString)) || ("1".equals(paramString)) || (bo.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(49271);
      return "¥";
    }
    AppMethodBeat.o(49271);
    return paramString;
  }
  
  public static boolean awb(String paramString)
  {
    AppMethodBeat.i(49281);
    if (!wcf.matcher(paramString).matches())
    {
      AppMethodBeat.o(49281);
      return false;
    }
    AppMethodBeat.o(49281);
    return true;
  }
  
  public static String awc(String paramString)
  {
    AppMethodBeat.i(49282);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(49282);
      return paramString;
    }
    String str = "";
    int i = 0;
    while (i < paramString.length() - 1)
    {
      str = str + "*";
      i += 1;
    }
    paramString = str + paramString.substring(paramString.length() - 1, paramString.length());
    AppMethodBeat.o(49282);
    return paramString;
  }
  
  public static String awd(String paramString)
  {
    AppMethodBeat.i(49285);
    if ((paramString != null) && (paramString.length() > 8))
    {
      int i = paramString.length();
      String str = paramString.substring(0, i - 8);
      paramString = paramString.substring(i - 4);
      paramString = str + "****" + paramString;
      AppMethodBeat.o(49285);
      return paramString;
    }
    AppMethodBeat.o(49285);
    return paramString;
  }
  
  public static String awe(String paramString)
  {
    AppMethodBeat.i(49286);
    if ((paramString != null) && (paramString.length() > 0))
    {
      String str = paramString.substring(1, paramString.length());
      ab.d("MicroMsg.WalletBaseUtil ", "tail : ".concat(String.valueOf(str)));
      paramString = paramString.substring(0, 1);
      ab.d("MicroMsg.WalletBaseUtil ", "head : ".concat(String.valueOf(paramString)));
      ab.d("MicroMsg.WalletBaseUtil ", "after : ".concat(String.valueOf(paramString)));
      paramString = "*".concat(String.valueOf(str));
      AppMethodBeat.o(49286);
      return paramString;
    }
    AppMethodBeat.o(49286);
    return "";
  }
  
  public static String awf(String paramString)
  {
    AppMethodBeat.i(49287);
    if ((paramString != null) && (paramString.length() >= 2))
    {
      paramString = "**".concat(String.valueOf(paramString.substring(paramString.length() - 1, paramString.length())));
      AppMethodBeat.o(49287);
      return paramString;
    }
    paramString = awe(paramString);
    AppMethodBeat.o(49287);
    return paramString;
  }
  
  public static String awg(String paramString)
  {
    AppMethodBeat.i(49296);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(49296);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int k = paramString.length() / 4;
    int i = 0;
    while (i < k + 1)
    {
      int j = Math.min((i + 1) * 4, paramString.length());
      localStringBuilder.append(iK(paramString.substring(i * 4, j), ""));
      if (j - i * 4 == 4)
      {
        j = 0;
        while (j < 4)
        {
          localStringBuilder.append(" ");
          j += 1;
        }
      }
      i += 1;
    }
    paramString = localStringBuilder.toString();
    AppMethodBeat.o(49296);
    return paramString;
  }
  
  public static String awh(String paramString)
  {
    AppMethodBeat.i(49297);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(49297);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int m = paramString.length() / 4;
    int i = 0;
    while (i < m)
    {
      int k = Math.min((i + 1) * 4, paramString.length());
      int j = k;
      if (k + 4 > paramString.length()) {
        j = paramString.length();
      }
      localStringBuilder.append(iK(paramString.substring(i * 4, j), " "));
      if (j - i * 4 == 4)
      {
        j = 0;
        while (j < 6)
        {
          localStringBuilder.append(" ");
          j += 1;
        }
      }
      i += 1;
    }
    paramString = localStringBuilder.toString();
    AppMethodBeat.o(49297);
    return paramString;
  }
  
  private static int awi(String paramString)
  {
    AppMethodBeat.i(49306);
    if ("1".equals(paramString))
    {
      AppMethodBeat.o(49306);
      return 0;
    }
    if ("2".equals(paramString))
    {
      AppMethodBeat.o(49306);
      return 4;
    }
    if ("3".equals(paramString))
    {
      AppMethodBeat.o(49306);
      return 12;
    }
    if ("4".equals(paramString))
    {
      AppMethodBeat.o(49306);
      return 2;
    }
    if ("5".equals(paramString))
    {
      AppMethodBeat.o(49306);
      return 8;
    }
    if ("6".equals(paramString))
    {
      AppMethodBeat.o(49306);
      return 14;
    }
    if ("7".equals(paramString))
    {
      AppMethodBeat.o(49306);
      return 16;
    }
    if ("8".equals(paramString))
    {
      AppMethodBeat.o(49306);
      return 10;
    }
    AppMethodBeat.o(49306);
    return -1;
  }
  
  public static String awj(String paramString)
  {
    AppMethodBeat.i(49308);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(49308);
      return paramString;
    }
    if (paramString.length() > 14)
    {
      paramString = paramString.substring(0, 14) + "...";
      AppMethodBeat.o(49308);
      return paramString;
    }
    AppMethodBeat.o(49308);
    return paramString;
  }
  
  public static int awk(String paramString)
  {
    AppMethodBeat.i(49321);
    if ((bo.isNullOrNil(paramString)) || (paramString.length() < 2))
    {
      ab.w("MicroMsg.WalletBaseUtil ", "illegal reqkey: %s", new Object[] { paramString });
      AppMethodBeat.o(49321);
      return 0;
    }
    com.tencent.mm.storage.c localc = com.tencent.mm.model.c.c.abU().me("100456");
    if (!localc.isValid())
    {
      ab.w("MicroMsg.WalletBaseUtil ", "invalid abtest value");
      AppMethodBeat.o(49321);
      return 0;
    }
    if (bo.getInt((String)localc.dvN().get("open"), 0) == 0)
    {
      ab.i("MicroMsg.WalletBaseUtil ", "abtest unopened");
      AppMethodBeat.o(49321);
      return 0;
    }
    if ((paramString.startsWith("ts_wx")) || (paramString.startsWith("offline_wx")) || (paramString.startsWith("up_wx")) || (paramString.startsWith("wx"))) {}
    for (int i = bo.getInt(paramString.substring(paramString.length() - 2), 0);; i = 0)
    {
      ab.d("MicroMsg.WalletBaseUtil ", "parse group id: %s, reqKey: %s", new Object[] { Integer.valueOf(i), paramString });
      AppMethodBeat.o(49321);
      return i;
    }
  }
  
  public static void awl(String paramString)
  {
    AppMethodBeat.i(49322);
    String str = paramString;
    if (bo.isNullOrNil(paramString)) {
      str = ah.getContext().getString(2131305682);
    }
    Toast.makeText(ah.getContext(), str, 1).show();
    AppMethodBeat.o(49322);
  }
  
  public static double b(String paramString1, String paramString2, RoundingMode paramRoundingMode)
  {
    AppMethodBeat.i(49313);
    double d = a(paramString1, paramString2, 2, paramRoundingMode).doubleValue();
    AppMethodBeat.o(49313);
    return d;
  }
  
  public static BigDecimal b(String paramString1, String paramString2, int paramInt, RoundingMode paramRoundingMode)
  {
    AppMethodBeat.i(49318);
    try
    {
      double d1 = bo.getDouble(paramString1, 0.0D);
      double d2 = bo.getDouble(paramString2, 0.0D);
      BigDecimal localBigDecimal;
      if (d1 == 0.0D)
      {
        paramString1 = "0";
        localBigDecimal = new BigDecimal(paramString1);
        if (d2 != 0.0D) {
          break label87;
        }
      }
      label87:
      for (paramString1 = "0";; paramString1 = paramString2.trim())
      {
        paramString1 = localBigDecimal.multiply(new BigDecimal(paramString1)).setScale(paramInt, paramRoundingMode);
        AppMethodBeat.o(49318);
        return paramString1;
        paramString1 = paramString1.trim();
        break;
      }
      return paramString1;
    }
    catch (Exception paramString1)
    {
      ab.printErrStackTrace("MicroMsg.WalletBaseUtil ", paramString1, "", new Object[0]);
      paramString1 = new BigDecimal(0);
      AppMethodBeat.o(49318);
    }
  }
  
  public static Typeface bS(Context paramContext, String paramString)
  {
    int j = 0;
    AppMethodBeat.i(49264);
    int i = -1;
    switch (paramString.hashCode())
    {
    default: 
      switch (i)
      {
      }
      break;
    }
    for (j = 8;; j = 4)
    {
      paramContext = aD(paramContext, j);
      AppMethodBeat.o(49264);
      return paramContext;
      if (!paramString.equals("sans_ss")) {
        break;
      }
      i = 0;
      break;
      if (!paramString.equals("sans_std")) {
        break;
      }
      i = 1;
      break;
    }
  }
  
  public static void bT(Context paramContext, String paramString)
  {
    AppMethodBeat.i(49291);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(49291);
      return;
    }
    paramString = new Intent("android.intent.action.DIAL", Uri.parse("tel:".concat(String.valueOf(paramString))));
    paramString.addFlags(268435456);
    paramContext.startActivity(paramString);
    AppMethodBeat.o(49291);
  }
  
  public static void bU(Context paramContext, String paramString)
  {
    AppMethodBeat.i(49302);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("showShare", false);
    localIntent.putExtra("pay_channel", 1);
    com.tencent.mm.bq.d.b(paramContext, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(49302);
  }
  
  public static double c(String paramString1, String paramString2, RoundingMode paramRoundingMode)
  {
    AppMethodBeat.i(49315);
    double d = b(paramString1, paramString2, 2, paramRoundingMode).doubleValue();
    AppMethodBeat.o(49315);
    return d;
  }
  
  public static void d(TextView paramTextView, String paramString)
  {
    AppMethodBeat.i(49311);
    paramString = fa(paramString, 10);
    paramTextView.setText(com.tencent.mm.pluginsdk.ui.d.j.b(paramTextView.getContext(), paramString, paramTextView.getTextSize()));
    AppMethodBeat.o(49311);
  }
  
  public static void d(MMActivity paramMMActivity, String paramString)
  {
    AppMethodBeat.i(49289);
    Intent localIntent = new Intent();
    localIntent.putExtra("BaseScanUI_select_scan_mode", 7);
    localIntent.putExtra("bank_card_owner", paramString);
    com.tencent.mm.bq.d.b(paramMMActivity, "scanner", ".ui.BaseScanUI", localIntent);
    AppMethodBeat.o(49289);
  }
  
  public static void dSS() {}
  
  public static void dST()
  {
    AppMethodBeat.i(49295);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.a(new bk(new e.4()), 0);
    AppMethodBeat.o(49295);
  }
  
  public static boolean dSU()
  {
    AppMethodBeat.i(49319);
    l locall = (l)com.tencent.mm.kernel.g.E(l.class);
    if (locall == null)
    {
      ab.w("MicroMsg.WalletBaseUtil ", "bio no finger mgr!");
      AppMethodBeat.o(49319);
      return false;
    }
    boolean bool1 = locall.bzb();
    boolean bool2 = locall.bzo();
    ab.i("MicroMsg.WalletBaseUtil ", "has fp: %s, has faceid: %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    if ((bool1) || (bool2))
    {
      AppMethodBeat.o(49319);
      return true;
    }
    AppMethodBeat.o(49319);
    return false;
  }
  
  public static String e(double paramDouble, String paramString)
  {
    AppMethodBeat.i(49267);
    if ("CNY".equals(paramString))
    {
      paramString = String.format("¥%.2f", new Object[] { Double.valueOf(paramDouble) });
      AppMethodBeat.o(49267);
      return paramString;
    }
    if ("ZAR".equals(paramString))
    {
      paramString = String.format("R%.2f", new Object[] { Double.valueOf(paramDouble) });
      AppMethodBeat.o(49267);
      return paramString;
    }
    if (("1".equals(paramString)) || (bo.isNullOrNil(paramString)))
    {
      paramString = String.format(com.tencent.mm.wallet_core.c.ae.dSz() + "%.2f", new Object[] { Double.valueOf(paramDouble) });
      AppMethodBeat.o(49267);
      return paramString;
    }
    paramString = String.format(paramString + "%.2f", new Object[] { Double.valueOf(paramDouble) });
    AppMethodBeat.o(49267);
    return paramString;
  }
  
  public static Typeface eA(Context paramContext)
  {
    AppMethodBeat.i(49263);
    paramContext = aD(paramContext, 4);
    AppMethodBeat.o(49263);
    return paramContext;
  }
  
  public static String eZ(String paramString, int paramInt)
  {
    AppMethodBeat.i(49309);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(49309);
      return paramString;
    }
    if (paramString.length() > paramInt)
    {
      paramString = paramString.substring(0, paramInt) + "...";
      AppMethodBeat.o(49309);
      return paramString;
    }
    AppMethodBeat.o(49309);
    return paramString;
  }
  
  public static String fa(String paramString, int paramInt)
  {
    AppMethodBeat.i(49310);
    paramString = eZ(nE(paramString), paramInt);
    AppMethodBeat.o(49310);
    return paramString;
  }
  
  public static String getUsername()
  {
    AppMethodBeat.i(49284);
    com.tencent.mm.kernel.g.RJ().QQ();
    String str = r.Zn();
    AppMethodBeat.o(49284);
    return str;
  }
  
  private static String iK(String paramString1, String paramString2)
  {
    AppMethodBeat.i(49301);
    if (TextUtils.isEmpty(paramString1))
    {
      AppMethodBeat.o(49301);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramString1.length())
    {
      localStringBuilder.append(paramString1.substring(i, i + 1));
      if (i != paramString1.length() - 1) {
        localStringBuilder.append(paramString2);
      }
      i += 1;
    }
    paramString1 = localStringBuilder.toString();
    AppMethodBeat.o(49301);
    return paramString1;
  }
  
  public static int iL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(49316);
    int i = b(paramString1, paramString2, 0, RoundingMode.HALF_UP).intValue();
    AppMethodBeat.o(49316);
    return i;
  }
  
  public static long iM(String paramString1, String paramString2)
  {
    AppMethodBeat.i(49317);
    long l = b(paramString1, paramString2, 0, RoundingMode.HALF_UP).longValue();
    AppMethodBeat.o(49317);
    return l;
  }
  
  public static void iM(Context paramContext)
  {
    AppMethodBeat.i(49279);
    if (paramContext == null)
    {
      ab.e("MicroMsg.WalletBaseUtil ", "hy: jump to preference error. context is null");
      AppMethodBeat.o(49279);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.addFlags(67108864);
    localIntent.putExtra("preferred_tab", 3);
    com.tencent.mm.bq.d.f(paramContext, "com.tencent.mm.ui.LauncherUI", localIntent);
    AppMethodBeat.o(49279);
  }
  
  public static String kB(int paramInt)
  {
    AppMethodBeat.i(49272);
    if (kTX == null) {
      kTX = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    }
    String str = kTX.format(new Date(paramInt * 1000L));
    AppMethodBeat.o(49272);
    return str;
  }
  
  public static void m(Context paramContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(49276);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("showShare", paramBoolean);
    com.tencent.mm.bq.d.b(paramContext, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(49276);
  }
  
  public static boolean n(JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(49283);
    boolean bool = "1".equals(paramJSONObject.optString(paramString, "0"));
    AppMethodBeat.o(49283);
    return bool;
  }
  
  public static String nE(String paramString)
  {
    AppMethodBeat.i(49290);
    com.tencent.mm.kernel.g.RM();
    Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arv(paramString);
    if (localObject != null) {}
    for (localObject = ((com.tencent.mm.n.a)localObject).Of();; localObject = null)
    {
      if (bo.isNullOrNil((String)localObject)) {}
      for (;;)
      {
        AppMethodBeat.o(49290);
        return paramString;
        paramString = (String)localObject;
      }
    }
  }
  
  public static void q(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(49324);
    so localso = new so();
    localso.cIQ.userName = paramString1;
    localso.cIQ.cIS = bo.bf(paramString2, "");
    localso.cIQ.bDc = paramInt1;
    localso.cIQ.scene = paramInt2;
    localso.cIQ.cIT = 0;
    com.tencent.mm.sdk.b.a.ymk.l(localso);
    AppMethodBeat.o(49324);
  }
  
  public static void setNoSystemInputOnEditText(EditText paramEditText)
  {
    AppMethodBeat.i(49266);
    if (Build.VERSION.SDK_INT < 11)
    {
      paramEditText.setInputType(0);
      AppMethodBeat.o(49266);
      return;
    }
    try
    {
      Method localMethod1 = EditText.class.getMethod("setShowSoftInputOnFocus", new Class[] { Boolean.TYPE });
      localMethod1.setAccessible(false);
      localMethod1.invoke(paramEditText, new Object[] { Boolean.FALSE });
      AppMethodBeat.o(49266);
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      ab.e("erik", "setShowSoftInputOnFocus exception!");
      try
      {
        Method localMethod2 = EditText.class.getMethod("setSoftInputShownOnFocus", new Class[] { Boolean.TYPE });
        localMethod2.setAccessible(false);
        localMethod2.invoke(paramEditText, new Object[] { Boolean.FALSE });
        AppMethodBeat.o(49266);
        return;
      }
      catch (Exception localException)
      {
        paramEditText.setInputType(0);
        ab.printErrStackTrace("MicroMsg.WalletBaseUtil ", localException, "", new Object[0]);
        AppMethodBeat.o(49266);
        return;
      }
    }
    catch (Exception paramEditText)
    {
      ab.printErrStackTrace("MicroMsg.WalletBaseUtil ", paramEditText, "", new Object[0]);
      AppMethodBeat.o(49266);
    }
  }
  
  public static final class c
  {
    public String key = null;
    public Object ypP = null;
    
    public c() {}
    
    public c(String paramString, Object paramObject)
    {
      this.key = paramString;
      this.ypP = paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.e
 * JD-Core Version:    0.7.0.1
 */