package com.tencent.mm.wallet_core.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.vq;
import com.tencent.mm.model.bq.a;
import com.tencent.mm.model.ch;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.pluginsdk.ui.span.n;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.e.m;
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

public final class f
{
  private static final String[] Dwn;
  protected static final Pattern FzN;
  private static final com.tencent.mm.sdk.platformtools.ah<Integer, Typeface> LWL;
  private static SimpleDateFormat pog;
  
  static
  {
    AppMethodBeat.i(73054);
    FzN = Pattern.compile("((?:(http|https|Http|Https):\\/\\/(?:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,64}(?:\\:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,25})?\\@)?)?((?:(?:[a-zA-Z0-9][a-zA-Z0-9\\-\\_]{0,64}\\.)+(?:(?:aero|arpa|asia|a[cdefgilmnoqrstuwxz])|(?:biz|b[abdefghijmnorstvwyz])|(?:cat|com|coop|c[acdfghiklmnoruvxyz])|d[ejkmoz]|(?:edu|e[cegrstu])|f[ijkmor]|(?:gov|g[abdefghilmnpqrstuwy])|h[kmnrtu]|(?:info|int|i[delmnoqrst])|(?:jobs|j[emop])|k[eghimnrwyz]|l[abcikrstuvy]|(?:mil|mobi|museum|m[acdeghklmnopqrstuvwxyz])|(?:name|net|n[acefgilopruz])|(?:org|om)|(?:pro|p[aefghklmnrstwy])|qa|r[eouw]|s[abcdeghijklmnortuvyz]|(?:tel|travel|t[cdfghjklmnoprtvwz])|u[agkmsyz]|v[aceginu]|w[fs]|y[etu]|z[amw]))|(?:(?:25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(?:25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(?:25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(?:25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9])))(?:\\:\\d{1,5})?)(\\/(?:(?:[a-zA-Z0-9\\;\\/\\?\\:\\@\\&\\=\\#\\~\\-\\.\\+\\!\\*\\'\\(\\)\\,\\_])|(?:\\%[a-fA-F0-9]{2}))*)?");
    Dwn = new String[] { "ABC_DEBIT", "ABC_CREDIT", "CITIC_CREDIT", "CMBC_DEBIT", "COMM_DEBIT", "HSBC_DEBIT" };
    LWL = new com.tencent.mm.sdk.platformtools.ah(4);
    pog = null;
    AppMethodBeat.o(73054);
  }
  
  public static String C(double paramDouble)
  {
    AppMethodBeat.i(72996);
    String str = String.format("%.2f", new Object[] { Double.valueOf(paramDouble) });
    AppMethodBeat.o(72996);
    return str;
  }
  
  public static String D(double paramDouble)
  {
    AppMethodBeat.i(72995);
    String str = d(paramDouble, "");
    AppMethodBeat.o(72995);
    return str;
  }
  
  public static long E(double paramDouble)
  {
    AppMethodBeat.i(73018);
    long l = Math.round(100.0D * paramDouble);
    AppMethodBeat.o(73018);
    return l;
  }
  
  public static Bitmap T(Bitmap paramBitmap)
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
      ae.d("MicroMsg.WalletBaseUtil ", bool + "  degree:90.0");
      AppMethodBeat.o(73026);
      return paramBitmap;
      bool = false;
    }
  }
  
  public static void U(Bitmap paramBitmap)
  {
    AppMethodBeat.i(73025);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
      paramBitmap.recycle();
    }
    AppMethodBeat.o(73025);
  }
  
  public static double a(String paramString1, String paramString2, int paramInt, RoundingMode paramRoundingMode)
  {
    AppMethodBeat.i(190256);
    double d = b(paramString1, paramString2, paramInt, paramRoundingMode).doubleValue();
    AppMethodBeat.o(190256);
    return d;
  }
  
  public static long a(String paramString1, String paramString2, RoundingMode paramRoundingMode)
  {
    AppMethodBeat.i(73038);
    long l = b(paramString1, paramString2, 0, paramRoundingMode).longValue();
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
  
  public static void a(Context paramContext, String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(73003);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("showShare", paramBoolean);
    localIntent.putExtra("allow_mix_content_mode", false);
    com.tencent.mm.br.d.b(paramContext, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent, paramInt);
    AppMethodBeat.o(73003);
  }
  
  public static void a(TextView paramTextView, String paramString, int paramInt, e parame, Context paramContext)
  {
    AppMethodBeat.i(190257);
    paramTextView.setClickable(true);
    paramTextView.setOnTouchListener(new n(paramContext));
    paramString = new SpannableString(paramString);
    paramString.setSpan(parame, 0, paramInt, 18);
    paramTextView.setText(paramString);
    AppMethodBeat.o(190257);
  }
  
  public static void a(final TextView paramTextView, final String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(73031);
    if (paramTextView == null)
    {
      ae.e("MicroMsg.WalletBaseUtil ", "hy: text view is null.");
      AppMethodBeat.o(73031);
      return;
    }
    if (bu.isNullOrNil(paramString2))
    {
      ae.w("MicroMsg.WalletBaseUtil ", "hy: msg is null. set text view to gone");
      paramTextView.setVisibility(8);
      AppMethodBeat.o(73031);
      return;
    }
    paramTextView.setVisibility(0);
    paramTextView.setText(paramString2);
    com.tencent.mm.protocal.g.gi(baq(paramString1), 0);
    if (!bu.isNullOrNil(paramString3)) {
      paramTextView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(72987);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/wallet_core/ui/WalletBaseUtil$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          ae.i("MicroMsg.WalletBaseUtil ", "hy: on click banner");
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("rawUrl", this.val$url);
          paramAnonymousView.putExtra("showShare", true);
          com.tencent.mm.br.d.b(paramTextView.getContext(), "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramAnonymousView);
          com.tencent.mm.protocal.g.gi(f.aYh(paramString1), 1);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/wallet_core/ui/WalletBaseUtil$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(72987);
        }
      });
    }
    AppMethodBeat.o(73031);
  }
  
  public static void a(String paramString, final b paramb)
  {
    AppMethodBeat.i(73020);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.a(new com.tencent.mm.model.bq(new bq.a()
    {
      public final void a(com.tencent.mm.network.e paramAnonymouse)
      {
        AppMethodBeat.i(72984);
        if ((paramAnonymouse == null) || (paramAnonymouse.aFs() == null))
        {
          AppMethodBeat.o(72984);
          return;
        }
        if (bu.isNullOrNil(this.val$key))
        {
          ae.w("MicroMsg.WalletBaseUtil ", "hy: key is null");
          AppMethodBeat.o(72984);
          return;
        }
        try
        {
          paramAnonymouse = paramAnonymouse.aFs().DO(this.val$key);
          if (paramb == null) {
            break label145;
          }
          if (paramAnonymouse != null)
          {
            paramb.dr(f.cK(paramAnonymouse));
            AppMethodBeat.o(72984);
            return;
          }
        }
        catch (Exception paramAnonymouse)
        {
          ae.e("MicroMsg.WalletBaseUtil ", "hy: deserialize failed: %s", new Object[] { paramAnonymouse.toString() });
          if (paramb != null) {
            paramb.dr(null);
          }
          AppMethodBeat.o(72984);
          return;
        }
        paramb.dr(null);
        label145:
        AppMethodBeat.o(72984);
      }
    }), 0);
    AppMethodBeat.o(73020);
  }
  
  public static void a(c... paramVarArgs)
  {
    AppMethodBeat.i(73019);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.a(new com.tencent.mm.model.bq(new bq.a()
    {
      public final void a(com.tencent.mm.network.e paramAnonymouse)
      {
        AppMethodBeat.i(72983);
        if ((paramAnonymouse == null) || (paramAnonymouse.aFs() == null))
        {
          AppMethodBeat.o(72983);
          return;
        }
        if ((this.LWN == null) || (this.LWN.length == 0))
        {
          ae.w("MicroMsg.WalletBaseUtil ", "hy: kvs is null or length is 0");
          AppMethodBeat.o(72983);
          return;
        }
        try
        {
          f.c[] arrayOfc = this.LWN;
          int j = arrayOfc.length;
          int i = 0;
          while (i < j)
          {
            f.c localc = arrayOfc[i];
            if ((localc != null) && (!bu.isNullOrNil(localc.key))) {
              paramAnonymouse.aFs().i(localc.key, f.et(localc.cfK));
            }
            i += 1;
          }
          AppMethodBeat.o(72983);
          return;
        }
        catch (Exception paramAnonymouse)
        {
          ae.e("MicroMsg.WalletBaseUtil ", "hy: serialize failed: %s", new Object[] { paramAnonymouse.toString() });
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
      ae.i("MicroMsg.WalletBaseUtil ", "adjust max width: %s", new Object[] { Integer.valueOf(j) });
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
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.a(new com.tencent.mm.model.bq(new bq.a()
    {
      public final void a(com.tencent.mm.network.e paramAnonymouse)
      {
        AppMethodBeat.i(72986);
        if ((paramAnonymouse == null) || (paramAnonymouse.aFs() == null))
        {
          AppMethodBeat.o(72986);
          return;
        }
        if ((this.LWP == null) || (this.LWP.length == 0))
        {
          ae.w("MicroMsg.WalletBaseUtil ", "hy: keys is null");
          AppMethodBeat.o(72986);
          return;
        }
        HashMap localHashMap = new HashMap();
        int i = 0;
        for (;;)
        {
          try
          {
            if (i < this.LWP.length)
            {
              String str = this.LWP[i];
              if (!bu.isNullOrNil(str))
              {
                byte[] arrayOfByte = paramAnonymouse.aFs().DO(str);
                if (arrayOfByte != null) {
                  localHashMap.put(str, f.cK(arrayOfByte));
                }
              }
              else
              {
                ae.e("MicroMsg.WalletBaseUtil ", "hy: key is null");
              }
            }
          }
          catch (Exception paramAnonymouse)
          {
            ae.e("MicroMsg.WalletBaseUtil ", "hy: deserialize failed: %s", new Object[] { paramAnonymouse.toString() });
            if (parama != null) {
              parama.bc(null);
            }
            AppMethodBeat.o(72986);
            return;
          }
          if (parama != null) {
            parama.bc(localHashMap);
          }
          AppMethodBeat.o(72986);
          return;
          i += 1;
        }
      }
    }), 0);
    AppMethodBeat.o(73029);
  }
  
  public static Typeface aR(Context paramContext, int paramInt)
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
        paramContext = Typeface.createFromAsset(paramContext.getAssets(), agY(paramInt));
        AppMethodBeat.o(72991);
        return paramContext;
      }
      Typeface localTypeface2 = (Typeface)LWL.get(Integer.valueOf(paramInt));
      Typeface localTypeface1 = localTypeface2;
      if (localTypeface2 == null)
      {
        localTypeface1 = Typeface.createFromAsset(paramContext.getAssets(), agY(paramInt));
        LWL.put(Integer.valueOf(paramInt), localTypeface1);
      }
      AppMethodBeat.o(72991);
      return localTypeface1;
    }
    catch (Exception paramContext)
    {
      ae.e("MicroMsg.WalletBaseUtil ", "getWalletTypeface() Exception:%s %s", new Object[] { paramContext.getClass().getSimpleName(), paramContext.getMessage() });
      paramContext = Typeface.DEFAULT;
      AppMethodBeat.o(72991);
    }
    return paramContext;
  }
  
  public static void aW(View paramView, final int paramInt)
  {
    AppMethodBeat.i(73045);
    final View localView = (View)paramView.getParent();
    localView.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(72988);
        Rect localRect = new Rect();
        this.val$view.getHitRect(localRect);
        localRect.top -= paramInt;
        localRect.bottom += paramInt;
        localRect.left -= paramInt;
        localRect.right += paramInt;
        localView.setTouchDelegate(new TouchDelegate(localRect, this.val$view));
        AppMethodBeat.o(72988);
      }
    });
    AppMethodBeat.o(73045);
  }
  
  public static void aY(Context paramContext, String paramString)
  {
    AppMethodBeat.i(182537);
    p(paramContext, paramString, true);
    AppMethodBeat.o(182537);
  }
  
  public static void ae(Context paramContext, String paramString)
  {
    AppMethodBeat.i(73004);
    if (TextUtils.isEmpty(paramString))
    {
      ae.v("MicroMsg.WalletBaseUtil ", "username is null");
      AppMethodBeat.o(73004);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("Contact_User", paramString);
    localIntent.putExtra("force_get_contact", true);
    com.tencent.mm.br.d.b(paramContext, "profile", ".ui.ContactInfoUI", localIntent);
    AppMethodBeat.o(73004);
  }
  
  public static void af(Context paramContext, String paramString)
  {
    AppMethodBeat.i(73001);
    if (TextUtils.isEmpty(paramString))
    {
      ae.v("MicroMsg.WalletBaseUtil ", "username is null");
      AppMethodBeat.o(73001);
      return;
    }
    if (x.An(paramString))
    {
      ag(paramContext, paramString);
      AppMethodBeat.o(73001);
      return;
    }
    ae(paramContext, paramString);
    AppMethodBeat.o(73001);
  }
  
  public static void ag(Context paramContext, String paramString)
  {
    AppMethodBeat.i(73006);
    if (TextUtils.isEmpty(paramString))
    {
      ae.v("MicroMsg.WalletBaseUtil ", "username is null");
      AppMethodBeat.o(73006);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("Chat_User", paramString);
    localIntent.putExtra("finish_direct", true);
    com.tencent.mm.br.d.f(paramContext, ".ui.chatting.ChattingUI", localIntent);
    AppMethodBeat.o(73006);
  }
  
  public static String agY(int paramInt)
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
  
  public static String agZ(int paramInt)
  {
    AppMethodBeat.i(72999);
    String str = a(paramInt, new SimpleDateFormat("MM-dd HH:mm"), new SimpleDateFormat("yyyy-MM-dd HH:mm"));
    AppMethodBeat.o(72999);
    return str;
  }
  
  public static void aha(int paramInt)
  {
    AppMethodBeat.i(73030);
    com.tencent.mm.plugin.report.service.g.yxI.f(12719, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(1) });
    AppMethodBeat.o(73030);
  }
  
  public static void aj(Context paramContext, String paramString)
  {
    AppMethodBeat.i(73049);
    DialogInterface.OnClickListener local2 = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(72982);
        if ((this.val$context instanceof Activity)) {
          ((Activity)this.val$context).finish();
        }
        AppMethodBeat.o(72982);
      }
    };
    String str = paramString;
    if (bu.isNullOrNil(paramString)) {
      str = ak.getContext().getString(2131765901);
    }
    h.d(paramContext, str, "", local2);
    AppMethodBeat.o(73049);
  }
  
  public static void an(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(182535);
    Intent localIntent = new Intent();
    localIntent.putExtras(paramIntent);
    localIntent.putExtra("allow_mix_content_mode", false);
    com.tencent.mm.br.d.b(paramContext, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(182535);
  }
  
  public static double b(String paramString1, String paramString2, RoundingMode paramRoundingMode)
  {
    AppMethodBeat.i(73041);
    double d = c(paramString1, paramString2, 2, paramRoundingMode).doubleValue();
    AppMethodBeat.o(73041);
    return d;
  }
  
  public static BigDecimal b(String paramString1, String paramString2, int paramInt, RoundingMode paramRoundingMode)
  {
    AppMethodBeat.i(73040);
    try
    {
      if (bu.getDouble(paramString1, 0.0D) == 0.0D) {}
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
      ae.printErrStackTrace("MicroMsg.WalletBaseUtil ", paramString1, "", new Object[0]);
      paramString1 = new BigDecimal(0);
      AppMethodBeat.o(73040);
    }
  }
  
  public static void b(Context paramContext, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(182536);
    Intent localIntent = new Intent();
    localIntent.putExtras(paramIntent);
    localIntent.putExtra("allow_mix_content_mode", false);
    com.tencent.mm.br.d.b(paramContext, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent, paramInt);
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
    if ((paramBoolean1) && (!bu.isNullOrNil(paramString2)))
    {
      localLinkedList1.add(paramContext.getString(2131765085, new Object[] { paramString2 }));
      localLinkedList2.add(Integer.valueOf(2));
      localLinkedList1.add(paramContext.getString(2131765086, new Object[] { paramString2 }));
      localLinkedList2.add(Integer.valueOf(3));
    }
    h.a(paramContext, "", localLinkedList1, localLinkedList2, "", new f.1(paramContext, paramString1));
    AppMethodBeat.o(73014);
  }
  
  public static void ba(ArrayList<Bitmap> paramArrayList)
  {
    AppMethodBeat.i(73024);
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      int i = paramArrayList.size() - 1;
      while (i > 0)
      {
        U((Bitmap)paramArrayList.remove(i));
        i -= 1;
      }
    }
    AppMethodBeat.o(73024);
  }
  
  public static String bah(String paramString)
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
    if (("1".equals(paramString)) || (bu.isNullOrNil(paramString)))
    {
      paramString = com.tencent.mm.wallet_core.c.ah.fWc();
      AppMethodBeat.o(72994);
      return paramString;
    }
    AppMethodBeat.o(72994);
    return paramString;
  }
  
  public static String bai(String paramString)
  {
    AppMethodBeat.i(72997);
    if (("CNY".equals(paramString)) || ("1".equals(paramString)) || (bu.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(72997);
      return "¥";
    }
    AppMethodBeat.o(72997);
    return paramString;
  }
  
  public static boolean baj(String paramString)
  {
    AppMethodBeat.i(73007);
    if (!FzN.matcher(paramString).matches())
    {
      AppMethodBeat.o(73007);
      return false;
    }
    AppMethodBeat.o(73007);
    return true;
  }
  
  public static String bak(String paramString)
  {
    AppMethodBeat.i(73008);
    if (bu.isNullOrNil(paramString))
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
  
  public static String bal(String paramString)
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
  
  public static String bam(String paramString)
  {
    AppMethodBeat.i(73012);
    if ((paramString != null) && (paramString.length() > 0))
    {
      String str = paramString.substring(1, paramString.length());
      ae.d("MicroMsg.WalletBaseUtil ", "tail : ".concat(String.valueOf(str)));
      paramString = paramString.substring(0, 1);
      ae.d("MicroMsg.WalletBaseUtil ", "head : ".concat(String.valueOf(paramString)));
      ae.d("MicroMsg.WalletBaseUtil ", "after : ".concat(String.valueOf(paramString)));
      paramString = "*".concat(String.valueOf(str));
      AppMethodBeat.o(73012);
      return paramString;
    }
    AppMethodBeat.o(73012);
    return "";
  }
  
  public static String ban(String paramString)
  {
    AppMethodBeat.i(73013);
    if ((paramString != null) && (paramString.length() >= 2))
    {
      paramString = "**".concat(String.valueOf(paramString.substring(paramString.length() - 1, paramString.length())));
      AppMethodBeat.o(73013);
      return paramString;
    }
    paramString = bam(paramString);
    AppMethodBeat.o(73013);
    return paramString;
  }
  
  public static String bao(String paramString)
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
      localStringBuilder.append(mM(paramString.substring(i * 4, j), ""));
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
  
  public static String bap(String paramString)
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
      localStringBuilder.append(mM(paramString.substring(i * 4, j), " "));
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
  
  private static int baq(String paramString)
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
  
  public static String bar(String paramString)
  {
    AppMethodBeat.i(73034);
    if (bu.isNullOrNil(paramString))
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
  
  public static int bas(String paramString)
  {
    AppMethodBeat.i(73046);
    if ((bu.isNullOrNil(paramString)) || (paramString.length() < 2))
    {
      ae.w("MicroMsg.WalletBaseUtil ", "illegal reqkey: %s", new Object[] { paramString });
      AppMethodBeat.o(73046);
      return 0;
    }
    com.tencent.mm.storage.c localc = com.tencent.mm.model.c.d.aDI().xi("100456");
    if (!localc.isValid())
    {
      ae.w("MicroMsg.WalletBaseUtil ", "invalid abtest value");
      AppMethodBeat.o(73046);
      return 0;
    }
    if (bu.getInt((String)localc.fsy().get("open"), 0) == 0)
    {
      ae.i("MicroMsg.WalletBaseUtil ", "abtest unopened");
      AppMethodBeat.o(73046);
      return 0;
    }
    if ((paramString.startsWith("ts_wx")) || (paramString.startsWith("offline_wx")) || (paramString.startsWith("up_wx")) || (paramString.startsWith("wx"))) {}
    for (int i = bu.getInt(paramString.substring(paramString.length() - 2), 0);; i = 0)
    {
      ae.d("MicroMsg.WalletBaseUtil ", "parse group id: %s, reqKey: %s", new Object[] { Integer.valueOf(i), paramString });
      AppMethodBeat.o(73046);
      return i;
    }
  }
  
  public static void bat(String paramString)
  {
    AppMethodBeat.i(73047);
    String str = paramString;
    if (bu.isNullOrNil(paramString)) {
      str = ak.getContext().getString(2131765901);
    }
    Toast.makeText(ak.getContext(), str, 1).show();
    AppMethodBeat.o(73047);
  }
  
  public static BigDecimal c(String paramString1, String paramString2, int paramInt, RoundingMode paramRoundingMode)
  {
    AppMethodBeat.i(73044);
    try
    {
      double d1 = bu.getDouble(paramString1, 0.0D);
      double d2 = bu.getDouble(paramString2, 0.0D);
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
        AppMethodBeat.o(73044);
        return paramString1;
        paramString1 = paramString1.trim();
        break;
      }
      return paramString1;
    }
    catch (Exception paramString1)
    {
      ae.printErrStackTrace("MicroMsg.WalletBaseUtil ", paramString1, "", new Object[0]);
      paramString1 = new BigDecimal(0);
      AppMethodBeat.o(73044);
    }
  }
  
  public static Typeface cr(Context paramContext, String paramString)
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
      paramContext = aR(paramContext, j);
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
  
  public static void cs(Context paramContext, String paramString)
  {
    AppMethodBeat.i(163888);
    if (TextUtils.isEmpty(paramString))
    {
      ae.v("MicroMsg.WalletBaseUtil ", "username is null");
      AppMethodBeat.o(163888);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("Contact_User", paramString);
    localIntent.putExtra("force_get_contact", true);
    com.tencent.mm.br.d.b(paramContext, "profile", ".ui.ContactInfoUI", localIntent, 2);
    AppMethodBeat.o(163888);
  }
  
  public static void ct(Context paramContext, String paramString)
  {
    AppMethodBeat.i(73017);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(73017);
      return;
    }
    paramString = new Intent("android.intent.action.DIAL", Uri.parse("tel:".concat(String.valueOf(paramString))));
    paramString.addFlags(268435456);
    paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramString);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString.ahE(), "com/tencent/mm/wallet_core/ui/WalletBaseUtil", "dial", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramString.mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/wallet_core/ui/WalletBaseUtil", "dial", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(73017);
  }
  
  public static void cu(Context paramContext, String paramString)
  {
    AppMethodBeat.i(73028);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("showShare", false);
    localIntent.putExtra("pay_channel", 1);
    com.tencent.mm.br.d.b(paramContext, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(73028);
  }
  
  public static void cv(Context paramContext, String paramString)
  {
    AppMethodBeat.i(162284);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("showShare", false);
    localIntent.putExtra("pay_channel", 1);
    localIntent.putExtra(e.m.JpI, true);
    com.tencent.mm.br.d.b(paramContext, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(162284);
  }
  
  public static void cw(Context paramContext, String paramString)
  {
    AppMethodBeat.i(73048);
    String str = paramString;
    if (bu.isNullOrNil(paramString)) {
      str = ak.getContext().getString(2131765901);
    }
    h.d(paramContext, str, "", new DialogInterface.OnClickListener()
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
    if (("1".equals(paramString)) || (bu.isNullOrNil(paramString)))
    {
      paramString = String.format(com.tencent.mm.wallet_core.c.ah.fWc() + "%.2f", new Object[] { Double.valueOf(paramDouble) });
      AppMethodBeat.o(72993);
      return paramString;
    }
    paramString = String.format(paramString + "%.2f", new Object[] { Double.valueOf(paramDouble) });
    AppMethodBeat.o(72993);
    return paramString;
  }
  
  public static void d(int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(73033);
    com.tencent.mm.plugin.report.service.g.yxI.f(13375, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(1), Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(73033);
  }
  
  public static void d(MMActivity paramMMActivity, String paramString)
  {
    AppMethodBeat.i(73015);
    Intent localIntent = new Intent();
    localIntent.putExtra("BaseScanUI_select_scan_mode", 7);
    localIntent.putExtra("bank_card_owner", paramString);
    com.tencent.mm.br.d.b(paramMMActivity, "scanner", ".ui.ScanCardUI", localIntent);
    AppMethodBeat.o(73015);
  }
  
  public static Typeface fV(Context paramContext)
  {
    AppMethodBeat.i(72989);
    paramContext = aR(paramContext, 4);
    AppMethodBeat.o(72989);
    return paramContext;
  }
  
  public static void fWv() {}
  
  public static void fWw()
  {
    AppMethodBeat.i(73021);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.a(new com.tencent.mm.model.bq(new bq.a()
    {
      public final void a(com.tencent.mm.network.e paramAnonymouse)
      {
        AppMethodBeat.i(72985);
        paramAnonymouse.aFu();
        AppMethodBeat.o(72985);
      }
    }), 0);
    AppMethodBeat.o(73021);
  }
  
  public static String fWx()
  {
    AppMethodBeat.i(162285);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qFV, 0) == 0) {}
    for (long l = ch.aDc();; l = ch.aDa())
    {
      String str = Long.toString(l / 1000L);
      AppMethodBeat.o(162285);
      return str;
    }
  }
  
  public static void g(TextView paramTextView, String paramString)
  {
    AppMethodBeat.i(73037);
    paramString = gY(paramString, 10);
    paramTextView.setText(k.b(paramTextView.getContext(), paramString, paramTextView.getTextSize()));
    AppMethodBeat.o(73037);
  }
  
  public static String gX(String paramString, int paramInt)
  {
    AppMethodBeat.i(73035);
    if (bu.isNullOrNil(paramString))
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
  
  public static String gY(String paramString, int paramInt)
  {
    AppMethodBeat.i(73036);
    paramString = gX(zP(paramString), paramInt);
    AppMethodBeat.o(73036);
    return paramString;
  }
  
  public static String getUsername()
  {
    AppMethodBeat.i(73010);
    com.tencent.mm.kernel.g.ajP().aiU();
    String str = v.aAC();
    AppMethodBeat.o(73010);
    return str;
  }
  
  public static void kV(Context paramContext)
  {
    AppMethodBeat.i(73005);
    if (paramContext == null)
    {
      ae.e("MicroMsg.WalletBaseUtil ", "hy: jump to preference error. context is null");
      AppMethodBeat.o(73005);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.addFlags(67108864);
    localIntent.putExtra("preferred_tab", 3);
    com.tencent.mm.br.d.f(paramContext, "com.tencent.mm.ui.LauncherUI", localIntent);
    AppMethodBeat.o(73005);
  }
  
  public static boolean m(JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(73009);
    boolean bool = "1".equals(paramJSONObject.optString(paramString, "0"));
    AppMethodBeat.o(73009);
    return bool;
  }
  
  private static String mM(String paramString1, String paramString2)
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
  
  public static int mN(String paramString1, String paramString2)
  {
    AppMethodBeat.i(73042);
    int i = c(paramString1, paramString2, 0, RoundingMode.HALF_UP).intValue();
    AppMethodBeat.o(73042);
    return i;
  }
  
  public static long mO(String paramString1, String paramString2)
  {
    AppMethodBeat.i(73043);
    long l = c(paramString1, paramString2, 0, RoundingMode.HALF_UP).longValue();
    AppMethodBeat.o(73043);
    return l;
  }
  
  public static void o(Context paramContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(162283);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("showShare", paramBoolean);
    localIntent.putExtra(e.m.JpI, true);
    localIntent.putExtra("allow_mix_content_mode", false);
    com.tencent.mm.br.d.b(paramContext, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(162283);
  }
  
  public static String oy(int paramInt)
  {
    AppMethodBeat.i(72998);
    if (pog == null) {
      pog = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    }
    String str = pog.format(new Date(paramInt * 1000L));
    AppMethodBeat.o(72998);
    return str;
  }
  
  public static void p(Context paramContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(73002);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("showShare", paramBoolean);
    localIntent.putExtra("allow_mix_content_mode", false);
    com.tencent.mm.br.d.b(paramContext, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
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
      ae.e("erik", "setShowSoftInputOnFocus exception!");
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
        ae.printErrStackTrace("MicroMsg.WalletBaseUtil ", localException, "", new Object[0]);
        AppMethodBeat.o(72992);
        return;
      }
    }
    catch (Exception paramEditText)
    {
      ae.printErrStackTrace("MicroMsg.WalletBaseUtil ", paramEditText, "", new Object[0]);
      AppMethodBeat.o(72992);
    }
  }
  
  public static void u(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(73050);
    vq localvq = new vq();
    localvq.dKT.userName = paramString1;
    localvq.dKT.dKV = bu.bI(paramString2, "");
    localvq.dKT.aDD = paramInt1;
    localvq.dKT.scene = paramInt2;
    localvq.dKT.dKW = 0;
    com.tencent.mm.sdk.b.a.IvT.l(localvq);
    AppMethodBeat.o(73050);
  }
  
  public static String zP(String paramString)
  {
    AppMethodBeat.i(73016);
    com.tencent.mm.kernel.g.ajS();
    Object localObject = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().aUL(paramString);
    if (localObject != null) {}
    for (localObject = ((com.tencent.mm.contact.c)localObject).adG();; localObject = null)
    {
      if (bu.isNullOrNil((String)localObject)) {}
      for (;;)
      {
        AppMethodBeat.o(73016);
        return paramString;
        paramString = (String)localObject;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void bc(Map<String, Object> paramMap);
  }
  
  public static abstract interface b
  {
    public abstract void dr(Object paramObject);
  }
  
  public static final class c
  {
    public Object cfK = null;
    public String key = null;
    
    public c() {}
    
    public c(String paramString, Object paramObject)
    {
      this.key = paramString;
      this.cfK = paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.f
 * JD-Core Version:    0.7.0.1
 */