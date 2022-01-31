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
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.bi.a;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.protocal.f;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

public final class e
{
  private static SimpleDateFormat iMX = null;
  private static final String[] qCr;
  protected static final Pattern sjz = Pattern.compile("((?:(http|https|Http|Https):\\/\\/(?:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,64}(?:\\:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,25})?\\@)?)?((?:(?:[a-zA-Z0-9][a-zA-Z0-9\\-\\_]{0,64}\\.)+(?:(?:aero|arpa|asia|a[cdefgilmnoqrstuwxz])|(?:biz|b[abdefghijmnorstvwyz])|(?:cat|com|coop|c[acdfghiklmnoruvxyz])|d[ejkmoz]|(?:edu|e[cegrstu])|f[ijkmor]|(?:gov|g[abdefghilmnpqrstuwy])|h[kmnrtu]|(?:info|int|i[delmnoqrst])|(?:jobs|j[emop])|k[eghimnrwyz]|l[abcikrstuvy]|(?:mil|mobi|museum|m[acdeghklmnopqrstuvwxyz])|(?:name|net|n[acefgilopruz])|(?:org|om)|(?:pro|p[aefghklmnrstwy])|qa|r[eouw]|s[abcdeghijklmnortuvyz]|(?:tel|travel|t[cdfghjklmnoprtvwz])|u[agkmsyz]|v[aceginu]|w[fs]|y[etu]|z[amw]))|(?:(?:25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(?:25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(?:25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(?:25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9])))(?:\\:\\d{1,5})?)(\\/(?:(?:[a-zA-Z0-9\\;\\/\\?\\:\\@\\&\\=\\#\\~\\-\\.\\+\\!\\*\\'\\(\\)\\,\\_])|(?:\\%[a-fA-F0-9]{2}))*)?");
  private static final com.tencent.mm.sdk.platformtools.ab<Integer, Typeface> wCq;
  
  static
  {
    qCr = new String[] { "ABC_DEBIT", "ABC_CREDIT", "CITIC_CREDIT", "CMBC_DEBIT", "COMM_DEBIT", "HSBC_DEBIT" };
    wCq = new com.tencent.mm.sdk.platformtools.ab(4);
  }
  
  public static String A(double paramDouble)
  {
    return String.format("%.2f", new Object[] { Double.valueOf(paramDouble) });
  }
  
  public static String B(double paramDouble)
  {
    return d(paramDouble, "");
  }
  
  public static long C(double paramDouble)
  {
    return Math.round(100.0D * paramDouble);
  }
  
  public static String Ja(int paramInt)
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
  
  public static String Jb(int paramInt)
  {
    return a(paramInt, new SimpleDateFormat("MM-dd HH:mm"), new SimpleDateFormat("yyyy-MM-dd HH:mm"));
  }
  
  public static void Jc(int paramInt)
  {
    com.tencent.mm.plugin.report.service.h.nFQ.f(12719, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(1) });
  }
  
  public static double a(String paramString1, String paramString2, RoundingMode paramRoundingMode)
  {
    return b(paramString1, paramString2, paramRoundingMode).doubleValue();
  }
  
  public static String a(int paramInt, SimpleDateFormat paramSimpleDateFormat1, SimpleDateFormat paramSimpleDateFormat2)
  {
    long l = paramInt * 1000L;
    GregorianCalendar localGregorianCalendar1 = new GregorianCalendar();
    GregorianCalendar localGregorianCalendar2 = new GregorianCalendar();
    localGregorianCalendar2.setTimeInMillis(l);
    if (localGregorianCalendar1.get(1) == localGregorianCalendar2.get(1)) {
      return paramSimpleDateFormat1.format(new Date(l));
    }
    return paramSimpleDateFormat2.format(new Date(l));
  }
  
  public static void a(int paramInt1, long paramLong, int paramInt2)
  {
    com.tencent.mm.plugin.report.service.h.nFQ.f(13375, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(1), Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    LinkedList localLinkedList1 = new LinkedList();
    LinkedList localLinkedList2 = new LinkedList();
    localLinkedList1.add(paramContext.getString(a.i.wallet_card_aggreement_user));
    localLinkedList2.add(Integer.valueOf(0));
    if ((paramString1 != null) && (paramBoolean2))
    {
      localLinkedList1.add(paramContext.getString(a.i.wallet_card_aggreement_bank));
      localLinkedList2.add(Integer.valueOf(1));
    }
    if ((paramBoolean1) && (!bk.bl(paramString2)))
    {
      localLinkedList1.add(paramContext.getString(a.i.wallet_card_agreemnet_wxcredit_bank, new Object[] { paramString2 }));
      localLinkedList2.add(Integer.valueOf(2));
      localLinkedList1.add(paramContext.getString(a.i.wallet_card_agreemnet_wxcredit_get, new Object[] { paramString2 }));
      localLinkedList2.add(Integer.valueOf(3));
    }
    com.tencent.mm.ui.base.h.a(paramContext, "", localLinkedList1, localLinkedList2, "", new e.1(paramContext, paramString1));
  }
  
  public static void a(TextView paramTextView, String paramString1, String paramString2, String paramString3)
  {
    if (paramTextView == null) {
      y.e("MicroMsg.WalletBaseUtil ", "hy: text view is null.");
    }
    do
    {
      return;
      if (bk.bl(paramString2))
      {
        y.w("MicroMsg.WalletBaseUtil ", "hy: msg is null. set text view to gone");
        paramTextView.setVisibility(8);
        return;
      }
      paramTextView.setVisibility(0);
      paramTextView.setText(paramString2);
      f.eZ(afp(paramString1), 0);
    } while (bk.bl(paramString3));
    paramTextView.setOnClickListener(new e.6(paramString3, paramTextView, paramString1));
  }
  
  public static void a(String paramString, e.b paramb)
  {
    g.DQ();
    g.DO().dJT.a(new bi(new e.3(paramString, paramb)), 0);
  }
  
  public static void a(c... paramVarArgs)
  {
    g.DQ();
    g.DO().dJT.a(new bi(new e.2(paramVarArgs)), 0);
  }
  
  public static void a(String[] paramArrayOfString, final a parama)
  {
    g.DQ();
    g.DO().dJT.a(new bi(new bi.a()
    {
      public final void a(com.tencent.mm.network.e paramAnonymouse)
      {
        if ((paramAnonymouse == null) || (paramAnonymouse.KR() == null)) {
          return;
        }
        if ((this.wCu == null) || (this.wCu.length == 0))
        {
          y.w("MicroMsg.WalletBaseUtil ", "hy: keys is null");
          return;
        }
        HashMap localHashMap = new HashMap();
        int i = 0;
        for (;;)
        {
          try
          {
            if (i >= this.wCu.length) {
              break label156;
            }
            String str = this.wCu[i];
            if (!bk.bl(str))
            {
              byte[] arrayOfByte = paramAnonymouse.KR().ks(str);
              if (arrayOfByte != null) {
                localHashMap.put(str, e.bJ(arrayOfByte));
              }
            }
            else
            {
              y.e("MicroMsg.WalletBaseUtil ", "hy: key is null");
            }
          }
          catch (Exception paramAnonymouse)
          {
            y.e("MicroMsg.WalletBaseUtil ", "hy: deserialize failed: %s", new Object[] { paramAnonymouse.toString() });
          }
          if (parama == null) {
            break;
          }
          parama.Q(null);
          return;
          label156:
          if (parama == null) {
            break;
          }
          parama.Q(localHashMap);
          return;
          i += 1;
        }
      }
    }), 0);
  }
  
  public static void aa(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      y.v("MicroMsg.WalletBaseUtil ", "username is null");
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("Contact_User", paramString);
    localIntent.putExtra("force_get_contact", true);
    com.tencent.mm.br.d.b(paramContext, "profile", ".ui.ContactInfoUI", localIntent);
  }
  
  public static void ab(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      y.v("MicroMsg.WalletBaseUtil ", "username is null");
      return;
    }
    if (s.hk(paramString))
    {
      bF(paramContext, paramString);
      return;
    }
    aa(paramContext, paramString);
  }
  
  public static String afg(String paramString)
  {
    String str;
    if ("CNY".equals(paramString)) {
      str = "¥";
    }
    do
    {
      return str;
      if ("ZAR".equals(paramString)) {
        return "R";
      }
      if (("1".equals(paramString)) || (bk.bl(paramString))) {
        return com.tencent.mm.wallet_core.c.ab.cML();
      }
      str = paramString;
    } while (!"HKD".equals(paramString));
    return "$";
  }
  
  public static String afh(String paramString)
  {
    String str;
    if ((!"CNY".equals(paramString)) && (!"1".equals(paramString)))
    {
      str = paramString;
      if (!bk.bl(paramString)) {}
    }
    else
    {
      str = "¥";
    }
    return str;
  }
  
  public static boolean afi(String paramString)
  {
    return sjz.matcher(paramString).matches();
  }
  
  public static String afj(String paramString)
  {
    if (bk.bl(paramString)) {
      return paramString;
    }
    String str = "";
    int i = 0;
    while (i < paramString.length() - 1)
    {
      str = str + "*";
      i += 1;
    }
    return str + paramString.substring(paramString.length() - 1, paramString.length());
  }
  
  public static String afk(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.length() > 8)
      {
        int i = paramString.length();
        str = paramString.substring(0, i - 8);
        paramString = paramString.substring(i - 4);
        str = str + "****" + paramString;
      }
    }
    return str;
  }
  
  public static String afl(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0))
    {
      String str = paramString.substring(1, paramString.length());
      y.d("MicroMsg.WalletBaseUtil ", "tail : " + str);
      paramString = paramString.substring(0, 1);
      y.d("MicroMsg.WalletBaseUtil ", "head : " + paramString);
      y.d("MicroMsg.WalletBaseUtil ", "after : " + paramString);
      return "*" + str;
    }
    return "";
  }
  
  public static String afm(String paramString)
  {
    if ((paramString != null) && (paramString.length() >= 2))
    {
      paramString = paramString.substring(paramString.length() - 1, paramString.length());
      return "**" + paramString;
    }
    return afl(paramString);
  }
  
  public static String afn(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int k = paramString.length() / 4;
    int i = 0;
    while (i < k + 1)
    {
      int j = Math.min((i + 1) * 4, paramString.length());
      localStringBuilder.append(gH(paramString.substring(i * 4, j), ""));
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
    return localStringBuilder.toString();
  }
  
  public static String afo(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
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
      localStringBuilder.append(gH(paramString.substring(i * 4, j), " "));
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
    return localStringBuilder.toString();
  }
  
  private static int afp(String paramString)
  {
    if ("1".equals(paramString)) {
      return 0;
    }
    if ("2".equals(paramString)) {
      return 4;
    }
    if ("3".equals(paramString)) {
      return 12;
    }
    if ("4".equals(paramString)) {
      return 2;
    }
    if ("5".equals(paramString)) {
      return 8;
    }
    if ("6".equals(paramString)) {
      return 14;
    }
    if ("7".equals(paramString)) {
      return 16;
    }
    if ("8".equals(paramString)) {
      return 10;
    }
    return -1;
  }
  
  public static String afq(String paramString)
  {
    if (bk.bl(paramString)) {}
    while (paramString.length() <= 14) {
      return paramString;
    }
    return paramString.substring(0, 14) + "...";
  }
  
  public static int afr(String paramString)
  {
    if ((bk.bl(paramString)) || (paramString.length() < 2))
    {
      y.w("MicroMsg.WalletBaseUtil ", "illegal reqkey: %s", new Object[] { paramString });
      return 0;
    }
    com.tencent.mm.storage.c localc = com.tencent.mm.model.c.c.IX().fJ("100456");
    if (!localc.isValid())
    {
      y.w("MicroMsg.WalletBaseUtil ", "invalid abtest value");
      return 0;
    }
    if (bk.getInt((String)localc.ctr().get("open"), 0) == 0)
    {
      y.i("MicroMsg.WalletBaseUtil ", "abtest unopened");
      return 0;
    }
    if ((paramString.startsWith("ts_wx")) || (paramString.startsWith("offline_wx")) || (paramString.startsWith("up_wx")) || (paramString.startsWith("wx"))) {}
    for (int i = bk.getInt(paramString.substring(paramString.length() - 2), 0);; i = 0)
    {
      y.d("MicroMsg.WalletBaseUtil ", "parse group id: %s, reqKey: %s", new Object[] { Integer.valueOf(i), paramString });
      return i;
    }
  }
  
  public static void ak(ArrayList<Bitmap> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      int i = paramArrayList.size() - 1;
      while (i > 0)
      {
        w((Bitmap)paramArrayList.remove(i));
        i -= 1;
      }
    }
  }
  
  public static BigDecimal b(String paramString1, String paramString2, RoundingMode paramRoundingMode)
  {
    try
    {
      if (bk.getDouble(paramString1, 0.0D) == 0.0D) {}
      for (paramString1 = "0";; paramString1 = paramString1.trim()) {
        return new BigDecimal(paramString1).divide(new BigDecimal(paramString2.trim())).setScale(2, paramRoundingMode);
      }
      return new BigDecimal(0);
    }
    catch (Exception paramString1)
    {
      y.printErrStackTrace("MicroMsg.WalletBaseUtil ", paramString1, "", new Object[0]);
    }
  }
  
  public static void bF(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      y.v("MicroMsg.WalletBaseUtil ", "username is null");
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("Chat_User", paramString);
    localIntent.putExtra("finish_direct", true);
    com.tencent.mm.br.d.e(paramContext, ".ui.chatting.ChattingUI", localIntent);
  }
  
  public static void bG(Context paramContext, String paramString)
  {
    if (bk.bl(paramString)) {
      return;
    }
    paramString = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + paramString));
    paramString.addFlags(268435456);
    paramContext.startActivity(paramString);
  }
  
  public static void bH(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("showShare", false);
    localIntent.putExtra("pay_channel", 1);
    com.tencent.mm.br.d.b(paramContext, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
  }
  
  public static BigDecimal c(String paramString1, String paramString2, RoundingMode paramRoundingMode)
  {
    try
    {
      double d1 = bk.getDouble(paramString1, 0.0D);
      double d2 = bk.getDouble(paramString2, 0.0D);
      BigDecimal localBigDecimal;
      if (d1 == 0.0D)
      {
        paramString1 = "0";
        localBigDecimal = new BigDecimal(paramString1);
        if (d2 != 0.0D) {
          break label71;
        }
      }
      label71:
      for (paramString1 = "0";; paramString1 = paramString2.trim())
      {
        return localBigDecimal.multiply(new BigDecimal(paramString1)).setScale(0, paramRoundingMode);
        paramString1 = paramString1.trim();
        break;
      }
      return new BigDecimal(0);
    }
    catch (Exception paramString1)
    {
      y.printErrStackTrace("MicroMsg.WalletBaseUtil ", paramString1, "", new Object[0]);
    }
  }
  
  public static void cNo() {}
  
  public static void cNp()
  {
    g.DQ();
    g.DO().dJT.a(new bi(new e.4()), 0);
  }
  
  public static boolean cNq()
  {
    k localk = (k)g.r(k.class);
    if (localk == null)
    {
      y.w("MicroMsg.WalletBaseUtil ", "bio no finger mgr!");
      return false;
    }
    boolean bool1 = localk.aSG();
    boolean bool2 = localk.aST();
    y.i("MicroMsg.WalletBaseUtil ", "has fp: %s, has faceid: %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    return (bool1) || (bool2);
  }
  
  public static String d(double paramDouble, String paramString)
  {
    if ("CNY".equals(paramString)) {
      return String.format("¥%.2f", new Object[] { Double.valueOf(paramDouble) });
    }
    if ("ZAR".equals(paramString)) {
      return String.format("R%.2f", new Object[] { Double.valueOf(paramDouble) });
    }
    if (("1".equals(paramString)) || (bk.bl(paramString))) {
      return String.format(com.tencent.mm.wallet_core.c.ab.cML() + "%.2f", new Object[] { Double.valueOf(paramDouble) });
    }
    return String.format(paramString + "%.2f", new Object[] { Double.valueOf(paramDouble) });
  }
  
  public static void d(MMActivity paramMMActivity, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("BaseScanUI_select_scan_mode", 7);
    localIntent.putExtra("bank_card_owner", paramString);
    com.tencent.mm.br.d.b(paramMMActivity, "scanner", ".ui.BaseScanUI", localIntent);
  }
  
  public static Typeface dO(Context paramContext)
  {
    Object localObject;
    if (Build.VERSION.SDK_INT > 23) {
      localObject = Typeface.createFromAsset(paramContext.getAssets(), Ja(4));
    }
    Typeface localTypeface;
    do
    {
      return localObject;
      localTypeface = (Typeface)wCq.get(Integer.valueOf(4));
      localObject = localTypeface;
    } while (localTypeface != null);
    paramContext = Typeface.createFromAsset(paramContext.getAssets(), Ja(4));
    wCq.put(Integer.valueOf(4), paramContext);
    return paramContext;
  }
  
  public static String dP(String paramString, int paramInt)
  {
    if (bk.bl(paramString)) {}
    while (paramString.length() <= paramInt) {
      return paramString;
    }
    return paramString.substring(0, paramInt) + "...";
  }
  
  public static String dQ(String paramString, int paramInt)
  {
    return dP(gV(paramString), paramInt);
  }
  
  public static void f(TextView paramTextView, String paramString)
  {
    paramString = dQ(paramString, 10);
    paramTextView.setText(com.tencent.mm.pluginsdk.ui.d.j.a(paramTextView.getContext(), paramString, paramTextView.getTextSize()));
  }
  
  private static String gH(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
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
    return localStringBuilder.toString();
  }
  
  public static int gI(String paramString1, String paramString2)
  {
    return c(paramString1, paramString2, RoundingMode.HALF_UP).intValue();
  }
  
  public static long gJ(String paramString1, String paramString2)
  {
    return c(paramString1, paramString2, RoundingMode.HALF_UP).longValue();
  }
  
  public static String gV(String paramString)
  {
    g.DQ();
    Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abk(paramString);
    if (localObject != null) {}
    for (localObject = ((com.tencent.mm.n.a)localObject).Bq();; localObject = null)
    {
      if (bk.bl((String)localObject)) {
        return paramString;
      }
      return localObject;
    }
  }
  
  public static String getUsername()
  {
    g.DN().CX();
    return q.Gj();
  }
  
  public static String hP(int paramInt)
  {
    if (iMX == null) {
      iMX = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    }
    return iMX.format(new Date(paramInt * 1000L));
  }
  
  public static void hn(Context paramContext)
  {
    if (paramContext == null)
    {
      y.e("MicroMsg.WalletBaseUtil ", "hy: jump to preference error. context is null");
      return;
    }
    Intent localIntent = new Intent();
    localIntent.addFlags(67108864);
    localIntent.putExtra("preferred_tab", 3);
    com.tencent.mm.br.d.e(paramContext, "com.tencent.mm.ui.LauncherUI", localIntent);
  }
  
  public static void l(Context paramContext, String paramString, boolean paramBoolean)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("showShare", paramBoolean);
    com.tencent.mm.br.d.b(paramContext, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
  }
  
  public static boolean o(JSONObject paramJSONObject, String paramString)
  {
    return "1".equals(paramJSONObject.optString(paramString, "0"));
  }
  
  public static void q(Context paramContext, String paramString, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("showShare", false);
    com.tencent.mm.br.d.b(paramContext, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent, paramInt);
  }
  
  public static void setNoSystemInputOnEditText(EditText paramEditText)
  {
    if (Build.VERSION.SDK_INT < 11)
    {
      paramEditText.setInputType(0);
      return;
    }
    try
    {
      Method localMethod1 = EditText.class.getMethod("setShowSoftInputOnFocus", new Class[] { Boolean.TYPE });
      localMethod1.setAccessible(false);
      localMethod1.invoke(paramEditText, new Object[] { Boolean.valueOf(false) });
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      y.e("erik", "setShowSoftInputOnFocus exception!");
      try
      {
        Method localMethod2 = EditText.class.getMethod("setSoftInputShownOnFocus", new Class[] { Boolean.TYPE });
        localMethod2.setAccessible(false);
        localMethod2.invoke(paramEditText, new Object[] { Boolean.valueOf(false) });
        return;
      }
      catch (Exception localException)
      {
        paramEditText.setInputType(0);
        y.printErrStackTrace("MicroMsg.WalletBaseUtil ", localException, "", new Object[0]);
        return;
      }
    }
    catch (Exception paramEditText)
    {
      y.printErrStackTrace("MicroMsg.WalletBaseUtil ", paramEditText, "", new Object[0]);
    }
  }
  
  public static Bitmap v(Bitmap paramBitmap)
  {
    boolean bool = true;
    Object localObject = new Matrix();
    ((Matrix)localObject).reset();
    ((Matrix)localObject).setRotate(90.0F, paramBitmap.getWidth() / 2, paramBitmap.getHeight() / 2);
    paramBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject, true);
    localObject = new StringBuilder("resultBmp is null: ");
    if (paramBitmap == null) {}
    for (;;)
    {
      y.d("MicroMsg.WalletBaseUtil ", bool + "  degree:90.0");
      return paramBitmap;
      bool = false;
    }
  }
  
  public static void w(Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
      paramBitmap.recycle();
    }
  }
  
  public static abstract interface a
  {
    public abstract void Q(Map<String, Object> paramMap);
  }
  
  public static final class c
  {
    public String key = null;
    public Object uhK = null;
    
    public c() {}
    
    public c(String paramString, Object paramObject)
    {
      this.key = paramString;
      this.uhK = paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.e
 * JD-Core Version:    0.7.0.1
 */