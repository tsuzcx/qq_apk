package com.tencent.mm.wallet_core.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.uj;
import com.tencent.mm.model.bn;
import com.tencent.mm.model.bn.a;
import com.tencent.mm.model.ce;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.e.m;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
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
  private static final String[] AlW;
  protected static final Pattern CjR;
  private static final ag<Integer, Typeface> Ifq;
  private static SimpleDateFormat oaB;
  
  static
  {
    AppMethodBeat.i(73054);
    CjR = Pattern.compile("((?:(http|https|Http|Https):\\/\\/(?:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,64}(?:\\:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,25})?\\@)?)?((?:(?:[a-zA-Z0-9][a-zA-Z0-9\\-\\_]{0,64}\\.)+(?:(?:aero|arpa|asia|a[cdefgilmnoqrstuwxz])|(?:biz|b[abdefghijmnorstvwyz])|(?:cat|com|coop|c[acdfghiklmnoruvxyz])|d[ejkmoz]|(?:edu|e[cegrstu])|f[ijkmor]|(?:gov|g[abdefghilmnpqrstuwy])|h[kmnrtu]|(?:info|int|i[delmnoqrst])|(?:jobs|j[emop])|k[eghimnrwyz]|l[abcikrstuvy]|(?:mil|mobi|museum|m[acdeghklmnopqrstuvwxyz])|(?:name|net|n[acefgilopruz])|(?:org|om)|(?:pro|p[aefghklmnrstwy])|qa|r[eouw]|s[abcdeghijklmnortuvyz]|(?:tel|travel|t[cdfghjklmnoprtvwz])|u[agkmsyz]|v[aceginu]|w[fs]|y[etu]|z[amw]))|(?:(?:25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(?:25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(?:25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(?:25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9])))(?:\\:\\d{1,5})?)(\\/(?:(?:[a-zA-Z0-9\\;\\/\\?\\:\\@\\&\\=\\#\\~\\-\\.\\+\\!\\*\\'\\(\\)\\,\\_])|(?:\\%[a-fA-F0-9]{2}))*)?");
    AlW = new String[] { "ABC_DEBIT", "ABC_CREDIT", "CITIC_CREDIT", "CMBC_DEBIT", "COMM_DEBIT", "HSBC_DEBIT" };
    Ifq = new ag(4);
    oaB = null;
    AppMethodBeat.o(73054);
  }
  
  public static String D(double paramDouble)
  {
    AppMethodBeat.i(72996);
    String str = String.format("%.2f", new Object[] { Double.valueOf(paramDouble) });
    AppMethodBeat.o(72996);
    return str;
  }
  
  public static String E(double paramDouble)
  {
    AppMethodBeat.i(72995);
    String str = d(paramDouble, "");
    AppMethodBeat.o(72995);
    return str;
  }
  
  public static long F(double paramDouble)
  {
    AppMethodBeat.i(73018);
    long l = Math.round(100.0D * paramDouble);
    AppMethodBeat.o(73018);
    return l;
  }
  
  public static Bitmap S(Bitmap paramBitmap)
  {
    boolean bool = true;
    AppMethodBeat.i(73026);
    Object localObject = new Matrix();
    ((Matrix)localObject).reset();
    ((Matrix)localObject).setRotate(90.0F, paramBitmap.getWidth() / 2, paramBitmap.getHeight() / 2);
    paramBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject, true);
    localObject = new StringBuilder("resultBmp is null: ");
    if (paramBitmap == null) {}
    for (;;)
    {
      ad.d("MicroMsg.WalletBaseUtil ", bool + "  degree:90.0");
      AppMethodBeat.o(73026);
      return paramBitmap;
      bool = false;
    }
  }
  
  public static void T(Bitmap paramBitmap)
  {
    AppMethodBeat.i(73025);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
      paramBitmap.recycle();
    }
    AppMethodBeat.o(73025);
  }
  
  public static void X(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(182535);
    Intent localIntent = new Intent();
    localIntent.putExtras(paramIntent);
    localIntent.putExtra("allow_mix_content_mode", false);
    com.tencent.mm.bs.d.b(paramContext, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(182535);
  }
  
  public static long a(String paramString1, String paramString2, RoundingMode paramRoundingMode)
  {
    AppMethodBeat.i(73038);
    long l = a(paramString1, paramString2, 0, paramRoundingMode).longValue();
    AppMethodBeat.o(73038);
    return l;
  }
  
  public static String a(int paramInt, SimpleDateFormat paramSimpleDateFormat1, SimpleDateFormat paramSimpleDateFormat2)
  {
    AppMethodBeat.i(73000);
    long l = paramInt * 1000L;
    GregorianCalendar localGregorianCalendar1 = new GregorianCalendar();
    GregorianCalendar localGregorianCalendar2 = new GregorianCalendar();
    localGregorianCalendar2.setTimeInMillis(l);
    if (localGregorianCalendar1.get(1) == localGregorianCalendar2.get(1))
    {
      paramSimpleDateFormat1 = paramSimpleDateFormat1.format(new Date(l));
      AppMethodBeat.o(73000);
      return paramSimpleDateFormat1;
    }
    paramSimpleDateFormat1 = paramSimpleDateFormat2.format(new Date(l));
    AppMethodBeat.o(73000);
    return paramSimpleDateFormat1;
  }
  
  public static BigDecimal a(String paramString1, String paramString2, int paramInt, RoundingMode paramRoundingMode)
  {
    AppMethodBeat.i(73040);
    try
    {
      if (bt.getDouble(paramString1, 0.0D) == 0.0D) {}
      for (paramString1 = "0";; paramString1 = paramString1.trim())
      {
        paramString1 = new BigDecimal(paramString1).divide(new BigDecimal(paramString2.trim()), paramInt, paramRoundingMode);
        AppMethodBeat.o(73040);
        return paramString1;
      }
      return paramString1;
    }
    catch (Exception paramString1)
    {
      ad.printErrStackTrace("MicroMsg.WalletBaseUtil ", paramString1, "", new Object[0]);
      paramString1 = new BigDecimal(0);
      AppMethodBeat.o(73040);
    }
  }
  
  public static void a(Context paramContext, String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(73003);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("showShare", paramBoolean);
    localIntent.putExtra("allow_mix_content_mode", false);
    com.tencent.mm.bs.d.b(paramContext, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent, paramInt);
    AppMethodBeat.o(73003);
  }
  
  public static void a(final TextView paramTextView, final String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(73031);
    if (paramTextView == null)
    {
      ad.e("MicroMsg.WalletBaseUtil ", "hy: text view is null.");
      AppMethodBeat.o(73031);
      return;
    }
    if (bt.isNullOrNil(paramString2))
    {
      ad.w("MicroMsg.WalletBaseUtil ", "hy: msg is null. set text view to gone");
      paramTextView.setVisibility(8);
      AppMethodBeat.o(73031);
      return;
    }
    paramTextView.setVisibility(0);
    paramTextView.setText(paramString2);
    com.tencent.mm.protocal.g.fL(aNl(paramString1), 0);
    if (!bt.isNullOrNil(paramString3)) {
      paramTextView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(72987);
          ad.i("MicroMsg.WalletBaseUtil ", "hy: on click banner");
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("rawUrl", this.val$url);
          paramAnonymousView.putExtra("showShare", true);
          com.tencent.mm.bs.d.b(paramTextView.getContext(), "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramAnonymousView);
          com.tencent.mm.protocal.g.fL(e.aLi(paramString1), 1);
          AppMethodBeat.o(72987);
        }
      });
    }
    AppMethodBeat.o(73031);
  }
  
  public static void a(String paramString, final b paramb)
  {
    AppMethodBeat.i(73020);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(new bn(new bn.a()
    {
      public final void a(com.tencent.mm.network.e paramAnonymouse)
      {
        AppMethodBeat.i(72984);
        if ((paramAnonymouse == null) || (paramAnonymouse.avg() == null))
        {
          AppMethodBeat.o(72984);
          return;
        }
        if (bt.isNullOrNil(this.val$key))
        {
          ad.w("MicroMsg.WalletBaseUtil ", "hy: key is null");
          AppMethodBeat.o(72984);
          return;
        }
        try
        {
          paramAnonymouse = paramAnonymouse.avg().wh(this.val$key);
          if (paramb == null) {
            break label145;
          }
          if (paramAnonymouse != null)
          {
            paramb.dm(e.cB(paramAnonymouse));
            AppMethodBeat.o(72984);
            return;
          }
        }
        catch (Exception paramAnonymouse)
        {
          ad.e("MicroMsg.WalletBaseUtil ", "hy: deserialize failed: %s", new Object[] { paramAnonymouse.toString() });
          if (paramb != null) {
            paramb.dm(null);
          }
          AppMethodBeat.o(72984);
          return;
        }
        paramb.dm(null);
        label145:
        AppMethodBeat.o(72984);
      }
    }), 0);
    AppMethodBeat.o(73020);
  }
  
  public static void a(e.c... paramVarArgs)
  {
    AppMethodBeat.i(73019);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(new bn(new bn.a()
    {
      public final void a(com.tencent.mm.network.e paramAnonymouse)
      {
        AppMethodBeat.i(72983);
        if ((paramAnonymouse == null) || (paramAnonymouse.avg() == null))
        {
          AppMethodBeat.o(72983);
          return;
        }
        if ((this.Ifs == null) || (this.Ifs.length == 0))
        {
          ad.w("MicroMsg.WalletBaseUtil ", "hy: kvs is null or length is 0");
          AppMethodBeat.o(72983);
          return;
        }
        try
        {
          e.c[] arrayOfc = this.Ifs;
          int j = arrayOfc.length;
          int i = 0;
          while (i < j)
          {
            e.c localc = arrayOfc[i];
            if ((localc != null) && (!bt.isNullOrNil(localc.key))) {
              paramAnonymouse.avg().i(localc.key, e.em(localc.bXO));
            }
            i += 1;
          }
          AppMethodBeat.o(72983);
          return;
        }
        catch (Exception paramAnonymouse)
        {
          ad.e("MicroMsg.WalletBaseUtil ", "hy: serialize failed: %s", new Object[] { paramAnonymouse.toString() });
          AppMethodBeat.o(72983);
        }
      }
    }), 0);
    AppMethodBeat.o(73019);
  }
  
  public static void a(WalletFormView[] paramArrayOfWalletFormView)
  {
    int k = 0;
    AppMethodBeat.i(182534);
    if (paramArrayOfWalletFormView.length == 0)
    {
      AppMethodBeat.o(182534);
      return;
    }
    int i = 0;
    int j = 0;
    while (i < paramArrayOfWalletFormView.length)
    {
      j = Math.max(j, (int)paramArrayOfWalletFormView[i].getTitleMeasuredWidth());
      i += 1;
    }
    if (j > 0)
    {
      j += 10;
      ad.i("MicroMsg.WalletBaseUtil ", "adjust max width: %s", new Object[] { Integer.valueOf(j) });
      i = k;
      while (i < paramArrayOfWalletFormView.length)
      {
        paramArrayOfWalletFormView[i].setTitleWidth(j);
        i += 1;
      }
    }
    AppMethodBeat.o(182534);
  }
  
  public static void a(String[] paramArrayOfString, final a parama)
  {
    AppMethodBeat.i(73029);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(new bn(new bn.a()
    {
      public final void a(com.tencent.mm.network.e paramAnonymouse)
      {
        AppMethodBeat.i(72986);
        if ((paramAnonymouse == null) || (paramAnonymouse.avg() == null))
        {
          AppMethodBeat.o(72986);
          return;
        }
        if ((this.Ifu == null) || (this.Ifu.length == 0))
        {
          ad.w("MicroMsg.WalletBaseUtil ", "hy: keys is null");
          AppMethodBeat.o(72986);
          return;
        }
        HashMap localHashMap = new HashMap();
        int i = 0;
        for (;;)
        {
          try
          {
            if (i < this.Ifu.length)
            {
              String str = this.Ifu[i];
              if (!bt.isNullOrNil(str))
              {
                byte[] arrayOfByte = paramAnonymouse.avg().wh(str);
                if (arrayOfByte != null) {
                  localHashMap.put(str, e.cB(arrayOfByte));
                }
              }
              else
              {
                ad.e("MicroMsg.WalletBaseUtil ", "hy: key is null");
              }
            }
          }
          catch (Exception paramAnonymouse)
          {
            ad.e("MicroMsg.WalletBaseUtil ", "hy: deserialize failed: %s", new Object[] { paramAnonymouse.toString() });
            if (parama != null) {
              parama.aP(null);
            }
            AppMethodBeat.o(72986);
            return;
          }
          if (parama != null) {
            parama.aP(localHashMap);
          }
          AppMethodBeat.o(72986);
          return;
          i += 1;
        }
      }
    }), 0);
    AppMethodBeat.o(73029);
  }
  
  public static Typeface aI(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(72991);
    if (paramInt == 8)
    {
      paramContext = Typeface.DEFAULT;
      AppMethodBeat.o(72991);
      return paramContext;
    }
    try
    {
      if (Build.VERSION.SDK_INT > 23)
      {
        paramContext = Typeface.createFromAsset(paramContext.getAssets(), abw(paramInt));
        AppMethodBeat.o(72991);
        return paramContext;
      }
      Typeface localTypeface2 = (Typeface)Ifq.get(Integer.valueOf(paramInt));
      Typeface localTypeface1 = localTypeface2;
      if (localTypeface2 == null)
      {
        localTypeface1 = Typeface.createFromAsset(paramContext.getAssets(), abw(paramInt));
        Ifq.put(Integer.valueOf(paramInt), localTypeface1);
      }
      AppMethodBeat.o(72991);
      return localTypeface1;
    }
    catch (Exception paramContext)
    {
      ad.e("MicroMsg.WalletBaseUtil ", "getWalletTypeface() Exception:%s %s", new Object[] { paramContext.getClass().getSimpleName(), paramContext.getMessage() });
      paramContext = Typeface.DEFAULT;
      AppMethodBeat.o(72991);
    }
    return paramContext;
  }
  
  public static String aNc(String paramString)
  {
    AppMethodBeat.i(72994);
    if ("CNY".equals(paramString))
    {
      AppMethodBeat.o(72994);
      return "¥";
    }
    if ("ZAR".equals(paramString))
    {
      AppMethodBeat.o(72994);
      return "R";
    }
    if (("1".equals(paramString)) || (bt.isNullOrNil(paramString)))
    {
      paramString = ah.fkg();
      AppMethodBeat.o(72994);
      return paramString;
    }
    AppMethodBeat.o(72994);
    return paramString;
  }
  
  public static String aNd(String paramString)
  {
    AppMethodBeat.i(72997);
    if (("CNY".equals(paramString)) || ("1".equals(paramString)) || (bt.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(72997);
      return "¥";
    }
    AppMethodBeat.o(72997);
    return paramString;
  }
  
  public static boolean aNe(String paramString)
  {
    AppMethodBeat.i(73007);
    if (!CjR.matcher(paramString).matches())
    {
      AppMethodBeat.o(73007);
      return false;
    }
    AppMethodBeat.o(73007);
    return true;
  }
  
  public static String aNf(String paramString)
  {
    AppMethodBeat.i(73008);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(73008);
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
    AppMethodBeat.o(73008);
    return paramString;
  }
  
  public static String aNg(String paramString)
  {
    AppMethodBeat.i(73011);
    if ((paramString != null) && (paramString.length() > 8))
    {
      int i = paramString.length();
      String str = paramString.substring(0, i - 8);
      paramString = paramString.substring(i - 4);
      paramString = str + "****" + paramString;
      AppMethodBeat.o(73011);
      return paramString;
    }
    AppMethodBeat.o(73011);
    return paramString;
  }
  
  public static String aNh(String paramString)
  {
    AppMethodBeat.i(73012);
    if ((paramString != null) && (paramString.length() > 0))
    {
      String str = paramString.substring(1, paramString.length());
      ad.d("MicroMsg.WalletBaseUtil ", "tail : ".concat(String.valueOf(str)));
      paramString = paramString.substring(0, 1);
      ad.d("MicroMsg.WalletBaseUtil ", "head : ".concat(String.valueOf(paramString)));
      ad.d("MicroMsg.WalletBaseUtil ", "after : ".concat(String.valueOf(paramString)));
      paramString = "*".concat(String.valueOf(str));
      AppMethodBeat.o(73012);
      return paramString;
    }
    AppMethodBeat.o(73012);
    return "";
  }
  
  public static String aNi(String paramString)
  {
    AppMethodBeat.i(73013);
    if ((paramString != null) && (paramString.length() >= 2))
    {
      paramString = "**".concat(String.valueOf(paramString.substring(paramString.length() - 1, paramString.length())));
      AppMethodBeat.o(73013);
      return paramString;
    }
    paramString = aNh(paramString);
    AppMethodBeat.o(73013);
    return paramString;
  }
  
  public static String aNj(String paramString)
  {
    AppMethodBeat.i(73022);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(73022);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int k = paramString.length() / 4;
    int i = 0;
    while (i < k + 1)
    {
      int j = Math.min((i + 1) * 4, paramString.length());
      localStringBuilder.append(lL(paramString.substring(i * 4, j), ""));
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
    AppMethodBeat.o(73022);
    return paramString;
  }
  
  public static String aNk(String paramString)
  {
    AppMethodBeat.i(73023);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(73023);
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
      localStringBuilder.append(lL(paramString.substring(i * 4, j), " "));
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
    AppMethodBeat.o(73023);
    return paramString;
  }
  
  private static int aNl(String paramString)
  {
    AppMethodBeat.i(73032);
    if ("1".equals(paramString))
    {
      AppMethodBeat.o(73032);
      return 0;
    }
    if ("2".equals(paramString))
    {
      AppMethodBeat.o(73032);
      return 4;
    }
    if ("3".equals(paramString))
    {
      AppMethodBeat.o(73032);
      return 12;
    }
    if ("4".equals(paramString))
    {
      AppMethodBeat.o(73032);
      return 2;
    }
    if ("5".equals(paramString))
    {
      AppMethodBeat.o(73032);
      return 8;
    }
    if ("6".equals(paramString))
    {
      AppMethodBeat.o(73032);
      return 14;
    }
    if ("7".equals(paramString))
    {
      AppMethodBeat.o(73032);
      return 16;
    }
    if ("8".equals(paramString))
    {
      AppMethodBeat.o(73032);
      return 10;
    }
    AppMethodBeat.o(73032);
    return -1;
  }
  
  public static String aNm(String paramString)
  {
    AppMethodBeat.i(73034);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(73034);
      return paramString;
    }
    if (paramString.length() > 14)
    {
      paramString = paramString.substring(0, 14) + "...";
      AppMethodBeat.o(73034);
      return paramString;
    }
    AppMethodBeat.o(73034);
    return paramString;
  }
  
  public static int aNn(String paramString)
  {
    AppMethodBeat.i(73046);
    if ((bt.isNullOrNil(paramString)) || (paramString.length() < 2))
    {
      ad.w("MicroMsg.WalletBaseUtil ", "illegal reqkey: %s", new Object[] { paramString });
      AppMethodBeat.o(73046);
      return 0;
    }
    com.tencent.mm.storage.c localc = com.tencent.mm.model.c.d.aty().qu("100456");
    if (!localc.isValid())
    {
      ad.w("MicroMsg.WalletBaseUtil ", "invalid abtest value");
      AppMethodBeat.o(73046);
      return 0;
    }
    if (bt.getInt((String)localc.eJy().get("open"), 0) == 0)
    {
      ad.i("MicroMsg.WalletBaseUtil ", "abtest unopened");
      AppMethodBeat.o(73046);
      return 0;
    }
    if ((paramString.startsWith("ts_wx")) || (paramString.startsWith("offline_wx")) || (paramString.startsWith("up_wx")) || (paramString.startsWith("wx"))) {}
    for (int i = bt.getInt(paramString.substring(paramString.length() - 2), 0);; i = 0)
    {
      ad.d("MicroMsg.WalletBaseUtil ", "parse group id: %s, reqKey: %s", new Object[] { Integer.valueOf(i), paramString });
      AppMethodBeat.o(73046);
      return i;
    }
  }
  
  public static void aNo(String paramString)
  {
    AppMethodBeat.i(73047);
    String str = paramString;
    if (bt.isNullOrNil(paramString)) {
      str = aj.getContext().getString(2131765901);
    }
    Toast.makeText(aj.getContext(), str, 1).show();
    AppMethodBeat.o(73047);
  }
  
  public static void aQ(ArrayList<Bitmap> paramArrayList)
  {
    AppMethodBeat.i(73024);
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      int i = paramArrayList.size() - 1;
      while (i > 0)
      {
        T((Bitmap)paramArrayList.remove(i));
        i -= 1;
      }
    }
    AppMethodBeat.o(73024);
  }
  
  public static void aS(Context paramContext, String paramString)
  {
    AppMethodBeat.i(182537);
    p(paramContext, paramString, true);
    AppMethodBeat.o(182537);
  }
  
  public static void aS(View paramView, int paramInt)
  {
    AppMethodBeat.i(73045);
    View localView = (View)paramView.getParent();
    localView.post(new e.8(paramView, paramInt, localView));
    AppMethodBeat.o(73045);
  }
  
  public static String abw(int paramInt)
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
  
  public static String abx(int paramInt)
  {
    AppMethodBeat.i(72999);
    String str = a(paramInt, new SimpleDateFormat("MM-dd HH:mm"), new SimpleDateFormat("yyyy-MM-dd HH:mm"));
    AppMethodBeat.o(72999);
    return str;
  }
  
  public static void aby(int paramInt)
  {
    AppMethodBeat.i(73030);
    com.tencent.mm.plugin.report.service.h.vKh.f(12719, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(1) });
    AppMethodBeat.o(73030);
  }
  
  public static void ac(Context paramContext, String paramString)
  {
    AppMethodBeat.i(73004);
    if (TextUtils.isEmpty(paramString))
    {
      ad.v("MicroMsg.WalletBaseUtil ", "username is null");
      AppMethodBeat.o(73004);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("Contact_User", paramString);
    localIntent.putExtra("force_get_contact", true);
    com.tencent.mm.bs.d.b(paramContext, "profile", ".ui.ContactInfoUI", localIntent);
    AppMethodBeat.o(73004);
  }
  
  public static void ad(Context paramContext, String paramString)
  {
    AppMethodBeat.i(73001);
    if (TextUtils.isEmpty(paramString))
    {
      ad.v("MicroMsg.WalletBaseUtil ", "username is null");
      AppMethodBeat.o(73001);
      return;
    }
    if (w.sD(paramString))
    {
      ae(paramContext, paramString);
      AppMethodBeat.o(73001);
      return;
    }
    ac(paramContext, paramString);
    AppMethodBeat.o(73001);
  }
  
  public static void ae(Context paramContext, String paramString)
  {
    AppMethodBeat.i(73006);
    if (TextUtils.isEmpty(paramString))
    {
      ad.v("MicroMsg.WalletBaseUtil ", "username is null");
      AppMethodBeat.o(73006);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("Chat_User", paramString);
    localIntent.putExtra("finish_direct", true);
    com.tencent.mm.bs.d.e(paramContext, ".ui.chatting.ChattingUI", localIntent);
    AppMethodBeat.o(73006);
  }
  
  public static void ah(Context paramContext, String paramString)
  {
    AppMethodBeat.i(73049);
    e.2 local2 = new e.2(paramContext);
    String str = paramString;
    if (bt.isNullOrNil(paramString)) {
      str = aj.getContext().getString(2131765901);
    }
    com.tencent.mm.ui.base.h.d(paramContext, str, "", local2);
    AppMethodBeat.o(73049);
  }
  
  public static double b(String paramString1, String paramString2, RoundingMode paramRoundingMode)
  {
    AppMethodBeat.i(73039);
    double d = a(paramString1, paramString2, 2, paramRoundingMode).doubleValue();
    AppMethodBeat.o(73039);
    return d;
  }
  
  public static BigDecimal b(String paramString1, String paramString2, int paramInt, RoundingMode paramRoundingMode)
  {
    AppMethodBeat.i(73044);
    try
    {
      double d1 = bt.getDouble(paramString1, 0.0D);
      double d2 = bt.getDouble(paramString2, 0.0D);
      BigDecimal localBigDecimal;
      if (d1 == 0.0D)
      {
        paramString1 = "0";
        localBigDecimal = new BigDecimal(paramString1);
        if (d2 != 0.0D) {
          break label85;
        }
      }
      label85:
      for (paramString1 = "0";; paramString1 = paramString2.trim())
      {
        paramString1 = localBigDecimal.multiply(new BigDecimal(paramString1)).setScale(paramInt, paramRoundingMode);
        AppMethodBeat.o(73044);
        return paramString1;
        paramString1 = paramString1.trim();
        break;
      }
      return paramString1;
    }
    catch (Exception paramString1)
    {
      ad.printErrStackTrace("MicroMsg.WalletBaseUtil ", paramString1, "", new Object[0]);
      paramString1 = new BigDecimal(0);
      AppMethodBeat.o(73044);
    }
  }
  
  public static void b(Context paramContext, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(182536);
    Intent localIntent = new Intent();
    localIntent.putExtras(paramIntent);
    localIntent.putExtra("allow_mix_content_mode", false);
    com.tencent.mm.bs.d.b(paramContext, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent, paramInt);
    AppMethodBeat.o(182536);
  }
  
  public static void b(Context paramContext, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(73014);
    LinkedList localLinkedList1 = new LinkedList();
    LinkedList localLinkedList2 = new LinkedList();
    localLinkedList1.add(paramContext.getString(2131765084));
    localLinkedList2.add(Integer.valueOf(0));
    if ((paramString1 != null) && (paramBoolean2))
    {
      localLinkedList1.add(paramContext.getString(2131765082));
      localLinkedList2.add(Integer.valueOf(1));
    }
    if ((paramBoolean1) && (!bt.isNullOrNil(paramString2)))
    {
      localLinkedList1.add(paramContext.getString(2131765085, new Object[] { paramString2 }));
      localLinkedList2.add(Integer.valueOf(2));
      localLinkedList1.add(paramContext.getString(2131765086, new Object[] { paramString2 }));
      localLinkedList2.add(Integer.valueOf(3));
    }
    com.tencent.mm.ui.base.h.a(paramContext, "", localLinkedList1, localLinkedList2, "", new e.1(paramContext, paramString1));
    AppMethodBeat.o(73014);
  }
  
  public static double c(String paramString1, String paramString2, RoundingMode paramRoundingMode)
  {
    AppMethodBeat.i(73041);
    double d = b(paramString1, paramString2, 2, paramRoundingMode).doubleValue();
    AppMethodBeat.o(73041);
    return d;
  }
  
  public static void c(int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(73033);
    com.tencent.mm.plugin.report.service.h.vKh.f(13375, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(1), Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(73033);
  }
  
  public static Typeface cl(Context paramContext, String paramString)
  {
    int j = 0;
    AppMethodBeat.i(72990);
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
      paramContext = aI(paramContext, j);
      AppMethodBeat.o(72990);
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
  
  public static void cm(Context paramContext, String paramString)
  {
    AppMethodBeat.i(163888);
    if (TextUtils.isEmpty(paramString))
    {
      ad.v("MicroMsg.WalletBaseUtil ", "username is null");
      AppMethodBeat.o(163888);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("Contact_User", paramString);
    localIntent.putExtra("force_get_contact", true);
    com.tencent.mm.bs.d.b(paramContext, "profile", ".ui.ContactInfoUI", localIntent, 2);
    AppMethodBeat.o(163888);
  }
  
  public static void cn(Context paramContext, String paramString)
  {
    AppMethodBeat.i(73017);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(73017);
      return;
    }
    paramString = new Intent("android.intent.action.DIAL", Uri.parse("tel:".concat(String.valueOf(paramString))));
    paramString.addFlags(268435456);
    paramString = new com.tencent.mm.hellhoundlib.b.a().bd(paramString);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString.adn(), "com/tencent/mm/wallet_core/ui/WalletBaseUtil", "dial", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramString.lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/wallet_core/ui/WalletBaseUtil", "dial", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(73017);
  }
  
  public static void co(Context paramContext, String paramString)
  {
    AppMethodBeat.i(73028);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("showShare", false);
    localIntent.putExtra("pay_channel", 1);
    com.tencent.mm.bs.d.b(paramContext, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(73028);
  }
  
  public static void cp(Context paramContext, String paramString)
  {
    AppMethodBeat.i(162284);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("showShare", false);
    localIntent.putExtra("pay_channel", 1);
    localIntent.putExtra(e.m.FIC, true);
    com.tencent.mm.bs.d.b(paramContext, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(162284);
  }
  
  public static void cq(Context paramContext, String paramString)
  {
    AppMethodBeat.i(73048);
    String str = paramString;
    if (bt.isNullOrNil(paramString)) {
      str = aj.getContext().getString(2131765901);
    }
    com.tencent.mm.ui.base.h.d(paramContext, str, "", new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(73048);
  }
  
  public static String d(double paramDouble, String paramString)
  {
    AppMethodBeat.i(72993);
    if ("CNY".equals(paramString))
    {
      paramString = String.format("¥%.2f", new Object[] { Double.valueOf(paramDouble) });
      AppMethodBeat.o(72993);
      return paramString;
    }
    if ("ZAR".equals(paramString))
    {
      paramString = String.format("R%.2f", new Object[] { Double.valueOf(paramDouble) });
      AppMethodBeat.o(72993);
      return paramString;
    }
    if (("1".equals(paramString)) || (bt.isNullOrNil(paramString)))
    {
      paramString = String.format(ah.fkg() + "%.2f", new Object[] { Double.valueOf(paramDouble) });
      AppMethodBeat.o(72993);
      return paramString;
    }
    paramString = String.format(paramString + "%.2f", new Object[] { Double.valueOf(paramDouble) });
    AppMethodBeat.o(72993);
    return paramString;
  }
  
  public static void d(MMActivity paramMMActivity, String paramString)
  {
    AppMethodBeat.i(73015);
    Intent localIntent = new Intent();
    localIntent.putExtra("BaseScanUI_select_scan_mode", 7);
    localIntent.putExtra("bank_card_owner", paramString);
    com.tencent.mm.bs.d.b(paramMMActivity, "scanner", ".ui.ScanCardUI", localIntent);
    AppMethodBeat.o(73015);
  }
  
  public static void f(TextView paramTextView, String paramString)
  {
    AppMethodBeat.i(73037);
    paramString = go(paramString, 10);
    paramTextView.setText(com.tencent.mm.pluginsdk.ui.span.k.b(paramTextView.getContext(), paramString, paramTextView.getTextSize()));
    AppMethodBeat.o(73037);
  }
  
  public static void fkA()
  {
    AppMethodBeat.i(73021);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(new bn(new bn.a()
    {
      public final void a(com.tencent.mm.network.e paramAnonymouse)
      {
        AppMethodBeat.i(72985);
        paramAnonymouse.avi();
        AppMethodBeat.o(72985);
      }
    }), 0);
    AppMethodBeat.o(73021);
  }
  
  public static String fkB()
  {
    AppMethodBeat.i(162285);
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pqw, 0) == 0) {}
    for (long l = ce.asS();; l = ce.asQ())
    {
      String str = Long.toString(l / 1000L);
      AppMethodBeat.o(162285);
      return str;
    }
  }
  
  public static void fkz() {}
  
  public static Typeface fy(Context paramContext)
  {
    AppMethodBeat.i(72989);
    paramContext = aI(paramContext, 4);
    AppMethodBeat.o(72989);
    return paramContext;
  }
  
  public static String getUsername()
  {
    AppMethodBeat.i(73010);
    com.tencent.mm.kernel.g.afz().aeD();
    String str = u.aqG();
    AppMethodBeat.o(73010);
    return str;
  }
  
  public static String gn(String paramString, int paramInt)
  {
    AppMethodBeat.i(73035);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(73035);
      return paramString;
    }
    if (paramString.length() > paramInt)
    {
      paramString = paramString.substring(0, paramInt) + "...";
      AppMethodBeat.o(73035);
      return paramString;
    }
    AppMethodBeat.o(73035);
    return paramString;
  }
  
  public static String go(String paramString, int paramInt)
  {
    AppMethodBeat.i(73036);
    paramString = gn(sh(paramString), paramInt);
    AppMethodBeat.o(73036);
    return paramString;
  }
  
  public static void kq(Context paramContext)
  {
    AppMethodBeat.i(73005);
    if (paramContext == null)
    {
      ad.e("MicroMsg.WalletBaseUtil ", "hy: jump to preference error. context is null");
      AppMethodBeat.o(73005);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.addFlags(67108864);
    localIntent.putExtra("preferred_tab", 3);
    com.tencent.mm.bs.d.e(paramContext, "com.tencent.mm.ui.LauncherUI", localIntent);
    AppMethodBeat.o(73005);
  }
  
  private static String lL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(73027);
    if (TextUtils.isEmpty(paramString1))
    {
      AppMethodBeat.o(73027);
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
    AppMethodBeat.o(73027);
    return paramString1;
  }
  
  public static int lM(String paramString1, String paramString2)
  {
    AppMethodBeat.i(73042);
    int i = b(paramString1, paramString2, 0, RoundingMode.HALF_UP).intValue();
    AppMethodBeat.o(73042);
    return i;
  }
  
  public static long lN(String paramString1, String paramString2)
  {
    AppMethodBeat.i(73043);
    long l = b(paramString1, paramString2, 0, RoundingMode.HALF_UP).longValue();
    AppMethodBeat.o(73043);
    return l;
  }
  
  public static boolean m(JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(73009);
    boolean bool = "1".equals(paramJSONObject.optString(paramString, "0"));
    AppMethodBeat.o(73009);
    return bool;
  }
  
  public static String nh(int paramInt)
  {
    AppMethodBeat.i(72998);
    if (oaB == null) {
      oaB = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    }
    String str = oaB.format(new Date(paramInt * 1000L));
    AppMethodBeat.o(72998);
    return str;
  }
  
  public static void o(Context paramContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(162283);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("showShare", paramBoolean);
    localIntent.putExtra(e.m.FIC, true);
    localIntent.putExtra("allow_mix_content_mode", false);
    com.tencent.mm.bs.d.b(paramContext, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(162283);
  }
  
  public static void p(Context paramContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(73002);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("showShare", paramBoolean);
    localIntent.putExtra("allow_mix_content_mode", false);
    com.tencent.mm.bs.d.b(paramContext, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(73002);
  }
  
  public static void setNoSystemInputOnEditText(EditText paramEditText)
  {
    AppMethodBeat.i(72992);
    if (Build.VERSION.SDK_INT < 11)
    {
      paramEditText.setInputType(0);
      AppMethodBeat.o(72992);
      return;
    }
    try
    {
      Method localMethod1 = EditText.class.getMethod("setShowSoftInputOnFocus", new Class[] { Boolean.TYPE });
      localMethod1.setAccessible(false);
      localMethod1.invoke(paramEditText, new Object[] { Boolean.FALSE });
      AppMethodBeat.o(72992);
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      ad.e("erik", "setShowSoftInputOnFocus exception!");
      try
      {
        Method localMethod2 = EditText.class.getMethod("setSoftInputShownOnFocus", new Class[] { Boolean.TYPE });
        localMethod2.setAccessible(false);
        localMethod2.invoke(paramEditText, new Object[] { Boolean.FALSE });
        AppMethodBeat.o(72992);
        return;
      }
      catch (Exception localException)
      {
        paramEditText.setInputType(0);
        ad.printErrStackTrace("MicroMsg.WalletBaseUtil ", localException, "", new Object[0]);
        AppMethodBeat.o(72992);
        return;
      }
    }
    catch (Exception paramEditText)
    {
      ad.printErrStackTrace("MicroMsg.WalletBaseUtil ", paramEditText, "", new Object[0]);
      AppMethodBeat.o(72992);
    }
  }
  
  public static String sh(String paramString)
  {
    AppMethodBeat.i(73016);
    com.tencent.mm.kernel.g.afC();
    Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHX(paramString);
    if (localObject != null) {}
    for (localObject = ((com.tencent.mm.n.b)localObject).ZX();; localObject = null)
    {
      if (bt.isNullOrNil((String)localObject)) {}
      for (;;)
      {
        AppMethodBeat.o(73016);
        return paramString;
        paramString = (String)localObject;
      }
    }
  }
  
  public static void v(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(73050);
    uj localuj = new uj();
    localuj.dzH.userName = paramString1;
    localuj.dzH.dzJ = bt.by(paramString2, "");
    localuj.dzH.aAS = paramInt1;
    localuj.dzH.scene = paramInt2;
    localuj.dzH.dzK = 0;
    com.tencent.mm.sdk.b.a.ESL.l(localuj);
    AppMethodBeat.o(73050);
  }
  
  public static abstract interface a
  {
    public abstract void aP(Map<String, Object> paramMap);
  }
  
  public static abstract interface b
  {
    public abstract void dm(Object paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.e
 * JD-Core Version:    0.7.0.1
 */