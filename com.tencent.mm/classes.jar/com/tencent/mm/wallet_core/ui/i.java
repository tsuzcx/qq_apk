package com.tencent.mm.wallet_core.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.zp;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bw;
import com.tencent.mm.model.bw.a;
import com.tencent.mm.model.cn;
import com.tencent.mm.model.z;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.protocal.protobuf.dus;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.LruCache;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.k.e;
import com.tencent.mm.ui.f.s;
import com.tencent.mm.ui.widget.a.j;
import com.tencent.mm.ui.widget.a.j.a;
import com.tencent.mm.wallet_core.model.ai;
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

public final class i
{
  private static final String[] VOb;
  protected static final Pattern Yop;
  private static final LruCache<Integer, Typeface> agVa;
  private static SimpleDateFormat xiR;
  
  static
  {
    AppMethodBeat.i(73054);
    Yop = Pattern.compile("((?:(http|https|Http|Https):\\/\\/(?:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,64}(?:\\:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,25})?\\@)?)?((?:(?:[a-zA-Z0-9][a-zA-Z0-9\\-\\_]{0,64}\\.)+(?:(?:aero|arpa|asia|a[cdefgilmnoqrstuwxz])|(?:biz|b[abdefghijmnorstvwyz])|(?:cat|com|coop|c[acdfghiklmnoruvxyz])|d[ejkmoz]|(?:edu|e[cegrstu])|f[ijkmor]|(?:gov|g[abdefghilmnpqrstuwy])|h[kmnrtu]|(?:info|int|i[delmnoqrst])|(?:jobs|j[emop])|k[eghimnrwyz]|l[abcikrstuvy]|(?:mil|mobi|museum|m[acdeghklmnopqrstuvwxyz])|(?:name|net|n[acefgilopruz])|(?:org|om)|(?:pro|p[aefghklmnrstwy])|qa|r[eouw]|s[abcdeghijklmnortuvyz]|(?:tel|travel|t[cdfghjklmnoprtvwz])|u[agkmsyz]|v[aceginu]|w[fs]|y[etu]|z[amw]))|(?:(?:25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(?:25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(?:25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(?:25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9])))(?:\\:\\d{1,5})?)(\\/(?:(?:[a-zA-Z0-9\\;\\/\\?\\:\\@\\&\\=\\#\\~\\-\\.\\+\\!\\*\\'\\(\\)\\,\\_])|(?:\\%[a-fA-F0-9]{2}))*)?");
    VOb = new String[] { "ABC_DEBIT", "ABC_CREDIT", "CITIC_CREDIT", "CMBC_DEBIT", "COMM_DEBIT", "HSBC_DEBIT" };
    agVa = new LruCache(4);
    xiR = null;
    AppMethodBeat.o(73054);
  }
  
  public static void Q(TextView paramTextView)
  {
    AppMethodBeat.i(242562);
    aw.a(paramTextView.getPaint(), 0.8F);
    AppMethodBeat.o(242562);
  }
  
  public static String X(double paramDouble)
  {
    AppMethodBeat.i(72995);
    String str = e(paramDouble, "");
    AppMethodBeat.o(72995);
    return str;
  }
  
  public static long Y(double paramDouble)
  {
    AppMethodBeat.i(73018);
    long l = Math.round(100.0D * paramDouble);
    AppMethodBeat.o(73018);
    return l;
  }
  
  public static double a(String paramString1, String paramString2, int paramInt, RoundingMode paramRoundingMode)
  {
    AppMethodBeat.i(242500);
    double d = b(paramString1, paramString2, paramInt, paramRoundingMode).doubleValue();
    AppMethodBeat.o(242500);
    return d;
  }
  
  public static long a(String paramString1, String paramString2, RoundingMode paramRoundingMode)
  {
    AppMethodBeat.i(73038);
    long l = b(paramString1, paramString2, 0, paramRoundingMode).longValue();
    AppMethodBeat.o(73038);
    return l;
  }
  
  public static j a(Activity paramActivity, String paramString1, String paramString2, final String paramString3, final com.tencent.mm.wallet_core.model.h paramh)
  {
    AppMethodBeat.i(242593);
    j localj = new j(paramActivity, 1, 3);
    localj.d(paramActivity.getString(a.i.app_disagree), paramActivity.getString(a.i.app_agree));
    localj.a(new j.a()new j.a
    {
      public final void onClick()
      {
        AppMethodBeat.i(242185);
        i.this.cyW();
        paramh.onCancel();
        AppMethodBeat.o(242185);
      }
    }, new j.a()
    {
      public final void onClick()
      {
        AppMethodBeat.i(242184);
        i.this.cyW();
        paramh.cm(1, "");
        AppMethodBeat.o(242184);
      }
    });
    paramh = View.inflate(paramActivity, a.g.wallet_agreement_protocal_dialog_title, null);
    TextView localTextView = (TextView)paramh.findViewById(a.f.wallet_agreement_half_dialog_title);
    aw.a(localTextView.getPaint(), 0.8F);
    localTextView.setText(paramString1);
    localj.setHeaderView(paramh);
    paramString1 = View.inflate(paramActivity, a.g.wallet_agreement_protocal_dialog_content, null);
    paramh = (TextView)paramString1.findViewById(a.f.wallet_agreement_half_dialog_content);
    aw.a(paramh.getPaint(), 0.8F);
    a(paramh, paramString2, 0, paramString2.length(), new f(new f.a()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(242182);
        i.p(i.this, paramString3, true);
        AppMethodBeat.o(242182);
      }
    }), paramActivity);
    localj.setCustomView(paramString1);
    localj.dDn();
    AppMethodBeat.o(242593);
    return localj;
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
  
  public static void a(Context paramContext, final String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(73014);
    LinkedList localLinkedList1 = new LinkedList();
    LinkedList localLinkedList2 = new LinkedList();
    localLinkedList1.add(paramContext.getString(a.i.wallet_card_aggreement_user));
    localLinkedList2.add(Integer.valueOf(0));
    if ((paramString1 != null) && (paramBoolean2))
    {
      localLinkedList1.add(paramContext.getString(a.i.wallet_card_aggreement_bank));
      localLinkedList2.add(Integer.valueOf(1));
    }
    if ((paramBoolean1) && (!Util.isNullOrNil(paramString2)))
    {
      localLinkedList1.add(paramContext.getString(a.i.wallet_card_agreemnet_wxcredit_bank, new Object[] { paramString2 }));
      localLinkedList2.add(Integer.valueOf(2));
      localLinkedList1.add(paramContext.getString(a.i.wallet_card_agreemnet_wxcredit_get, new Object[] { paramString2 }));
      localLinkedList2.add(Integer.valueOf(3));
    }
    k.a(paramContext, "", localLinkedList1, localLinkedList2, "", new k.e()
    {
      public final void onClick(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(72981);
        Intent localIntent = new Intent();
        switch (paramAnonymousInt1)
        {
        }
        for (;;)
        {
          localIntent.putExtra("showShare", false);
          localIntent.putExtra("allow_mix_content_mode", false);
          com.tencent.mm.br.c.b(i.this, "webview", ".ui.tools.WebViewUI", localIntent);
          AppMethodBeat.o(72981);
          return;
          localIntent.putExtra("rawUrl", i.this.getString(a.i.wallet_agreemnet_user, new Object[] { LocaleUtil.getApplicationLanguage() }));
          continue;
          if (paramString1 != null)
          {
            localIntent.putExtra("rawUrl", i.this.getString(a.i.wallet_agreemnet_bank, new Object[] { LocaleUtil.getApplicationLanguage(), paramString1 }));
            continue;
            if (paramString1 != null)
            {
              localIntent.putExtra("rawUrl", i.this.getString(a.i.wallet_agreemnet_wxcredit_bank, new Object[] { LocaleUtil.getApplicationLanguage(), paramString1 }));
              continue;
              if (paramString1 != null) {
                localIntent.putExtra("rawUrl", i.this.getString(a.i.wallet_agreemnet_wxcredit_get, new Object[] { LocaleUtil.getApplicationLanguage(), paramString1 }));
              }
            }
          }
        }
      }
    });
    AppMethodBeat.o(73014);
  }
  
  public static void a(Context paramContext, String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(73003);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("showShare", paramBoolean);
    localIntent.putExtra("allow_mix_content_mode", false);
    com.tencent.mm.br.c.b(paramContext, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent, paramInt);
    AppMethodBeat.o(73003);
  }
  
  public static void a(View paramView, final TextView paramTextView, final String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(242441);
    if (paramTextView == null)
    {
      Log.e("MicroMsg.WalletBaseUtil ", "hy: text view is null.");
      AppMethodBeat.o(242441);
      return;
    }
    if (Util.isNullOrNil(paramString2))
    {
      Log.w("MicroMsg.WalletBaseUtil ", "hy: msg is null. set text view to gone");
      if (paramView != null)
      {
        paramView.setVisibility(8);
        AppMethodBeat.o(242441);
        return;
      }
      paramTextView.setVisibility(8);
      AppMethodBeat.o(242441);
      return;
    }
    if (paramView != null) {
      paramView.setVisibility(0);
    }
    for (;;)
    {
      if (paramTextView != null) {
        paramTextView.setVisibility(0);
      }
      paramTextView.setText(paramString2);
      com.tencent.mm.protocal.g.ik(bET(paramString1), 0);
      if (Util.isNullOrNil(paramString3)) {
        break;
      }
      if (paramView != null)
      {
        paramString2 = (ImageView)paramView.findViewById(a.f.arrow);
        if (paramString2 != null) {
          paramString2.setVisibility(0);
        }
      }
      paramString2 = paramView;
      if (paramView == null) {
        paramString2 = paramTextView;
      }
      paramString2.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(72987);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/wallet_core/ui/WalletBaseUtil$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          Log.i("MicroMsg.WalletBaseUtil ", "hy: on click banner");
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("rawUrl", i.this);
          paramAnonymousView.putExtra("showShare", true);
          com.tencent.mm.br.c.b(paramTextView.getContext(), "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramAnonymousView);
          com.tencent.mm.protocal.g.ik(i.bBA(paramString1), 1);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/wallet_core/ui/WalletBaseUtil$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(72987);
        }
      });
      AppMethodBeat.o(242441);
      return;
      paramTextView.setVisibility(0);
    }
    paramTextView.setMaxLines(2147483647);
    if (paramView != null)
    {
      paramView = (ImageView)paramView.findViewById(a.f.arrow);
      if (paramView != null) {
        paramView.setVisibility(8);
      }
    }
    AppMethodBeat.o(242441);
  }
  
  public static void a(TextView paramTextView, String paramString, int paramInt1, int paramInt2, f paramf, Context paramContext)
  {
    AppMethodBeat.i(242554);
    paramTextView.setClickable(true);
    paramTextView.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.s(paramContext));
    paramString = new SpannableStringBuilder(p.b(paramContext, paramString));
    paramString.setSpan(paramf, paramInt1, paramInt2, 18);
    paramTextView.setText(paramString);
    AppMethodBeat.o(242554);
  }
  
  public static void a(String paramString, final b paramb)
  {
    AppMethodBeat.i(73020);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(new bw(new bw.a()
    {
      public final void b(com.tencent.mm.network.g paramAnonymousg)
      {
        AppMethodBeat.i(72984);
        if ((paramAnonymousg == null) || (paramAnonymousg.bGg() == null))
        {
          AppMethodBeat.o(72984);
          return;
        }
        if (Util.isNullOrNil(i.this))
        {
          Log.w("MicroMsg.WalletBaseUtil ", "hy: key is null");
          AppMethodBeat.o(72984);
          return;
        }
        try
        {
          paramAnonymousg = paramAnonymousg.bGg().LW(i.this);
          if (paramb == null) {
            break label145;
          }
          if (paramAnonymousg != null)
          {
            paramb.fS(i.jdMethod_do(paramAnonymousg));
            AppMethodBeat.o(72984);
            return;
          }
        }
        catch (Exception paramAnonymousg)
        {
          Log.e("MicroMsg.WalletBaseUtil ", "hy: deserialize failed: %s", new Object[] { paramAnonymousg.toString() });
          if (paramb != null) {
            paramb.fS(null);
          }
          AppMethodBeat.o(72984);
          return;
        }
        paramb.fS(null);
        label145:
        AppMethodBeat.o(72984);
      }
    }), 0);
    AppMethodBeat.o(73020);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, int paramInt2, com.tencent.mm.plugin.appbrand.api.i parami)
  {
    AppMethodBeat.i(242543);
    com.tencent.mm.plugin.appbrand.api.g localg = new com.tencent.mm.plugin.appbrand.api.g();
    localg.username = paramString1;
    localg.qAF = Util.nullAs(paramString2, "");
    localg.version = paramInt1;
    localg.scene = paramInt2;
    localg.euz = 0;
    localg.qAU = parami;
    ((t)com.tencent.mm.kernel.h.ax(t.class)).a(MMApplicationContext.getContext(), localg);
    AppMethodBeat.o(242543);
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
      Log.i("MicroMsg.WalletBaseUtil ", "adjust max width: %s", new Object[] { Integer.valueOf(j) });
      i = k;
      while (i < paramArrayOfWalletFormView.length)
      {
        paramArrayOfWalletFormView[i].setTitleWidth(j);
        i += 1;
      }
    }
    AppMethodBeat.o(182534);
  }
  
  public static void a(c... paramVarArgs)
  {
    AppMethodBeat.i(73019);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(new bw(new bw.a()
    {
      public final void b(com.tencent.mm.network.g paramAnonymousg)
      {
        AppMethodBeat.i(72983);
        if ((paramAnonymousg == null) || (paramAnonymousg.bGg() == null))
        {
          AppMethodBeat.o(72983);
          return;
        }
        if ((i.this == null) || (i.this.length == 0))
        {
          Log.w("MicroMsg.WalletBaseUtil ", "hy: kvs is null or length is 0");
          AppMethodBeat.o(72983);
          return;
        }
        try
        {
          i.c[] arrayOfc = i.this;
          int j = arrayOfc.length;
          int i = 0;
          while (i < j)
          {
            i.c localc = arrayOfc[i];
            if ((localc != null) && (!Util.isNullOrNil(localc.key))) {
              paramAnonymousg.bGg().k(localc.key, i.gZ(localc.val));
            }
            i += 1;
          }
          AppMethodBeat.o(72983);
          return;
        }
        catch (Exception paramAnonymousg)
        {
          Log.e("MicroMsg.WalletBaseUtil ", "hy: serialize failed: %s", new Object[] { paramAnonymousg.toString() });
          AppMethodBeat.o(72983);
        }
      }
    }), 0);
    AppMethodBeat.o(73019);
  }
  
  public static void a(String[] paramArrayOfString, final a parama)
  {
    AppMethodBeat.i(73029);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(new bw(new bw.a()
    {
      public final void b(com.tencent.mm.network.g paramAnonymousg)
      {
        AppMethodBeat.i(72986);
        if ((paramAnonymousg == null) || (paramAnonymousg.bGg() == null))
        {
          AppMethodBeat.o(72986);
          return;
        }
        if ((i.this == null) || (i.this.length == 0))
        {
          Log.w("MicroMsg.WalletBaseUtil ", "hy: keys is null");
          AppMethodBeat.o(72986);
          return;
        }
        HashMap localHashMap = new HashMap();
        int i = 0;
        for (;;)
        {
          try
          {
            if (i < i.this.length)
            {
              String str = i.this[i];
              if (!Util.isNullOrNil(str))
              {
                byte[] arrayOfByte = paramAnonymousg.bGg().LW(str);
                if (arrayOfByte != null) {
                  localHashMap.put(str, i.jdMethod_do(arrayOfByte));
                }
              }
              else
              {
                Log.e("MicroMsg.WalletBaseUtil ", "hy: key is null");
              }
            }
          }
          catch (Exception paramAnonymousg)
          {
            Log.e("MicroMsg.WalletBaseUtil ", "hy: deserialize failed: %s", new Object[] { paramAnonymousg.toString() });
            if (parama != null) {
              parama.bm(null);
            }
            AppMethodBeat.o(72986);
            return;
          }
          if (parama != null) {
            parama.bm(localHashMap);
          }
          AppMethodBeat.o(72986);
          return;
          i += 1;
        }
      }
    }), 0);
    AppMethodBeat.o(73029);
  }
  
  public static void aGA(int paramInt)
  {
    AppMethodBeat.i(73030);
    com.tencent.mm.plugin.report.service.h.OAn.b(12719, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(1) });
    AppMethodBeat.o(73030);
  }
  
  public static String aGy(int paramInt)
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
  
  public static String aGz(int paramInt)
  {
    AppMethodBeat.i(72999);
    String str = a(paramInt, new SimpleDateFormat("MM-dd HH:mm"), new SimpleDateFormat("yyyy-MM-dd HH:mm"));
    AppMethodBeat.o(72999);
    return str;
  }
  
  public static int aHm(String paramString)
  {
    AppMethodBeat.i(242572);
    long l = Long.parseLong(paramString.substring(2), 16);
    int i = Color.argb((int)(l >> 24 & 0xFF), (int)(l >> 16 & 0xFF), (int)(l >> 8 & 0xFF), (int)(l & 0xFF));
    AppMethodBeat.o(242572);
    return i;
  }
  
  public static void aS(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(182535);
    Intent localIntent = new Intent();
    localIntent.putExtras(paramIntent);
    localIntent.putExtra("allow_mix_content_mode", false);
    com.tencent.mm.br.c.b(paramContext, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(182535);
  }
  
  public static Bitmap ag(Bitmap paramBitmap)
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
      Log.d("MicroMsg.WalletBaseUtil ", bool + "  degree:90.0");
      AppMethodBeat.o(73026);
      return paramBitmap;
      bool = false;
    }
  }
  
  public static void ah(Bitmap paramBitmap)
  {
    AppMethodBeat.i(73025);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
      paramBitmap.recycle();
    }
    AppMethodBeat.o(73025);
  }
  
  public static void an(Context paramContext, String paramString)
  {
    AppMethodBeat.i(73004);
    if (TextUtils.isEmpty(paramString))
    {
      Log.v("MicroMsg.WalletBaseUtil ", "username is null");
      AppMethodBeat.o(73004);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("Contact_User", paramString);
    localIntent.putExtra("force_get_contact", true);
    com.tencent.mm.br.c.b(paramContext, "profile", ".ui.ContactInfoUI", localIntent);
    AppMethodBeat.o(73004);
  }
  
  public static void ao(Context paramContext, String paramString)
  {
    AppMethodBeat.i(73001);
    if (TextUtils.isEmpty(paramString))
    {
      Log.v("MicroMsg.WalletBaseUtil ", "username is null");
      AppMethodBeat.o(73001);
      return;
    }
    if (ab.IR(paramString))
    {
      ap(paramContext, paramString);
      AppMethodBeat.o(73001);
      return;
    }
    an(paramContext, paramString);
    AppMethodBeat.o(73001);
  }
  
  public static void ap(Context paramContext, String paramString)
  {
    AppMethodBeat.i(73006);
    if (TextUtils.isEmpty(paramString))
    {
      Log.v("MicroMsg.WalletBaseUtil ", "username is null");
      AppMethodBeat.o(73006);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("Chat_User", paramString);
    localIntent.putExtra("finish_direct", true);
    com.tencent.mm.br.c.g(paramContext, ".ui.chatting.ChattingUI", localIntent);
    AppMethodBeat.o(73006);
  }
  
  public static void as(Context paramContext, String paramString)
  {
    AppMethodBeat.i(73049);
    DialogInterface.OnClickListener local2 = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(72982);
        if ((i.this instanceof Activity)) {
          ((Activity)i.this).finish();
        }
        AppMethodBeat.o(72982);
      }
    };
    String str = paramString;
    if (Util.isNullOrNil(paramString)) {
      str = MMApplicationContext.getContext().getString(a.i.wallet_unknown_err);
    }
    k.d(paramContext, str, "", local2);
    AppMethodBeat.o(73049);
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
      if (Util.getDouble(paramString1, 0.0D) == 0.0D) {}
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
      Log.printErrStackTrace("MicroMsg.WalletBaseUtil ", paramString1, "", new Object[0]);
      paramString1 = new BigDecimal(0);
      AppMethodBeat.o(73040);
    }
  }
  
  public static void bC(Context paramContext, String paramString)
  {
    AppMethodBeat.i(182537);
    p(paramContext, paramString, true);
    AppMethodBeat.o(182537);
  }
  
  public static Typeface bE(Context paramContext, int paramInt)
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
        paramContext = Typeface.createFromAsset(paramContext.getAssets(), aGy(paramInt));
        AppMethodBeat.o(72991);
        return paramContext;
      }
      Typeface localTypeface2 = (Typeface)agVa.get(Integer.valueOf(paramInt));
      Typeface localTypeface1 = localTypeface2;
      if (localTypeface2 == null)
      {
        localTypeface1 = Typeface.createFromAsset(paramContext.getAssets(), aGy(paramInt));
        agVa.put(Integer.valueOf(paramInt), localTypeface1);
      }
      AppMethodBeat.o(72991);
      return localTypeface1;
    }
    catch (Exception paramContext)
    {
      Log.e("MicroMsg.WalletBaseUtil ", "getWalletTypeface() Exception:%s %s", new Object[] { paramContext.getClass().getSimpleName(), paramContext.getMessage() });
      paramContext = Typeface.DEFAULT;
      AppMethodBeat.o(72991);
    }
    return paramContext;
  }
  
  public static String bEK(String paramString)
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
    if (("1".equals(paramString)) || (Util.isNullOrNil(paramString)))
    {
      paramString = ai.jOX();
      AppMethodBeat.o(72994);
      return paramString;
    }
    AppMethodBeat.o(72994);
    return paramString;
  }
  
  public static String bEL(String paramString)
  {
    AppMethodBeat.i(72997);
    if (("CNY".equals(paramString)) || ("1".equals(paramString)) || (Util.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(72997);
      return "¥";
    }
    AppMethodBeat.o(72997);
    return paramString;
  }
  
  public static boolean bEM(String paramString)
  {
    AppMethodBeat.i(73007);
    if (!Yop.matcher(paramString).matches())
    {
      AppMethodBeat.o(73007);
      return false;
    }
    AppMethodBeat.o(73007);
    return true;
  }
  
  public static String bEN(String paramString)
  {
    AppMethodBeat.i(73008);
    if (Util.isNullOrNil(paramString))
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
  
  public static String bEO(String paramString)
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
  
  public static String bEP(String paramString)
  {
    AppMethodBeat.i(73012);
    if ((paramString != null) && (paramString.length() > 0))
    {
      String str = paramString.substring(1, paramString.length());
      Log.d("MicroMsg.WalletBaseUtil ", "tail : ".concat(String.valueOf(str)));
      paramString = paramString.substring(0, 1);
      Log.d("MicroMsg.WalletBaseUtil ", "head : ".concat(String.valueOf(paramString)));
      Log.d("MicroMsg.WalletBaseUtil ", "after : ".concat(String.valueOf(paramString)));
      paramString = "*".concat(String.valueOf(str));
      AppMethodBeat.o(73012);
      return paramString;
    }
    AppMethodBeat.o(73012);
    return "";
  }
  
  public static String bEQ(String paramString)
  {
    AppMethodBeat.i(73013);
    if ((paramString != null) && (paramString.length() >= 2))
    {
      paramString = "**".concat(String.valueOf(paramString.substring(paramString.length() - 1, paramString.length())));
      AppMethodBeat.o(73013);
      return paramString;
    }
    paramString = bEP(paramString);
    AppMethodBeat.o(73013);
    return paramString;
  }
  
  public static String bER(String paramString)
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
      localStringBuilder.append(qw(paramString.substring(i * 4, j), ""));
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
  
  public static String bES(String paramString)
  {
    AppMethodBeat.i(73023);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(73023);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int m = paramString.length() / 4;
    int j = paramString.length() % 4;
    localStringBuilder.append(qw(paramString.substring(0, j), ""));
    int i = 0;
    while (i < 4)
    {
      localStringBuilder.append(" ");
      i += 1;
    }
    paramString = paramString.substring(j);
    i = 0;
    while (i < m)
    {
      int k = Math.min((i + 1) * 4, paramString.length());
      j = k;
      if (k + 4 > paramString.length()) {
        j = paramString.length();
      }
      localStringBuilder.append(qw(paramString.substring(i * 4, j), ""));
      if ((j - i * 4 == 4) && (i != m - 1))
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
    AppMethodBeat.o(73023);
    return paramString;
  }
  
  private static int bET(String paramString)
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
  
  public static String bEU(String paramString)
  {
    AppMethodBeat.i(73034);
    if (Util.isNullOrNil(paramString))
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
  
  public static int bEV(String paramString)
  {
    AppMethodBeat.i(73046);
    if ((Util.isNullOrNil(paramString)) || (paramString.length() < 2))
    {
      Log.w("MicroMsg.WalletBaseUtil ", "illegal reqkey: %s", new Object[] { paramString });
      AppMethodBeat.o(73046);
      return 0;
    }
    com.tencent.mm.storage.c localc = com.tencent.mm.model.newabtest.d.bEt().Fd("100456");
    if ((localc == null) || (!localc.isValid()))
    {
      Log.w("MicroMsg.WalletBaseUtil ", "invalid abtest value");
      AppMethodBeat.o(73046);
      return 0;
    }
    if (Util.getInt((String)localc.iWZ().get("open"), 0) == 0)
    {
      Log.i("MicroMsg.WalletBaseUtil ", "abtest unopened");
      AppMethodBeat.o(73046);
      return 0;
    }
    if ((paramString.startsWith("ts_wx")) || (paramString.startsWith("offline_wx")) || (paramString.startsWith("up_wx")) || (paramString.startsWith("wx"))) {}
    for (int i = Util.getInt(paramString.substring(paramString.length() - 2), 0);; i = 0)
    {
      Log.d("MicroMsg.WalletBaseUtil ", "parse group id: %s, reqKey: %s", new Object[] { Integer.valueOf(i), paramString });
      AppMethodBeat.o(73046);
      return i;
    }
  }
  
  public static void bEW(String paramString)
  {
    AppMethodBeat.i(73047);
    String str = paramString;
    if (Util.isNullOrNil(paramString)) {
      str = MMApplicationContext.getContext().getString(a.i.wallet_unknown_err);
    }
    Toast.makeText(MMApplicationContext.getContext(), str, 1).show();
    AppMethodBeat.o(73047);
  }
  
  public static void bG(View paramView, int paramInt)
  {
    AppMethodBeat.i(73045);
    View localView = (View)paramView.getParent();
    localView.post(new i.11(paramView, paramInt, localView));
    AppMethodBeat.o(73045);
  }
  
  public static BigDecimal c(String paramString1, String paramString2, int paramInt, RoundingMode paramRoundingMode)
  {
    AppMethodBeat.i(73044);
    try
    {
      double d1 = Util.getDouble(paramString1, 0.0D);
      double d2 = Util.getDouble(paramString2, 0.0D);
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
      Log.printErrStackTrace("MicroMsg.WalletBaseUtil ", paramString1, "", new Object[0]);
      paramString1 = new BigDecimal(0);
      AppMethodBeat.o(73044);
    }
  }
  
  public static void c(MMActivity paramMMActivity, String paramString)
  {
    AppMethodBeat.i(73015);
    Intent localIntent = new Intent();
    localIntent.putExtra("BaseScanUI_select_scan_mode", 7);
    localIntent.putExtra("bank_card_owner", paramString);
    com.tencent.mm.br.c.b(paramMMActivity, "scanner", ".ui.ScanCardUI", localIntent);
    AppMethodBeat.o(73015);
  }
  
  public static dus cR(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(242585);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(242585);
      return null;
    }
    dus localdus = new dus();
    localdus.abaE = paramJSONObject.optInt("is_show_notice", 0);
    localdus.left_icon = paramJSONObject.optString("left_icon", "");
    localdus.jump_url = paramJSONObject.optString("jump_url", "");
    localdus.wording = paramJSONObject.optString("wording", "");
    localdus.YSS = paramJSONObject.optString("notice_id", "");
    AppMethodBeat.o(242585);
    return localdus;
  }
  
  public static void cj(ArrayList<Bitmap> paramArrayList)
  {
    AppMethodBeat.i(73024);
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      int i = paramArrayList.size() - 1;
      while (i > 0)
      {
        ah((Bitmap)paramArrayList.remove(i));
        i -= 1;
      }
    }
    AppMethodBeat.o(73024);
  }
  
  public static void d(Context paramContext, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(182536);
    Intent localIntent = new Intent();
    localIntent.putExtras(paramIntent);
    localIntent.putExtra("allow_mix_content_mode", false);
    com.tencent.mm.br.c.b(paramContext, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent, paramInt);
    AppMethodBeat.o(182536);
  }
  
  public static Typeface df(Context paramContext, String paramString)
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
      paramContext = bE(paramContext, j);
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
  
  public static void dg(Context paramContext, String paramString)
  {
    AppMethodBeat.i(73017);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(73017);
      return;
    }
    paramString = new Intent("android.intent.action.DIAL", Uri.parse("tel:".concat(String.valueOf(paramString))));
    paramString.addFlags(268435456);
    paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramString.aYi(), "com/tencent/mm/wallet_core/ui/WalletBaseUtil", "dial", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramString.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/wallet_core/ui/WalletBaseUtil", "dial", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(73017);
  }
  
  public static void dh(Context paramContext, String paramString)
  {
    AppMethodBeat.i(73028);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("showShare", false);
    localIntent.putExtra("pay_channel", 1);
    com.tencent.mm.br.c.b(paramContext, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(73028);
  }
  
  public static void di(Context paramContext, String paramString)
  {
    AppMethodBeat.i(162284);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("showShare", false);
    localIntent.putExtra("pay_channel", 1);
    localIntent.putExtra(f.s.adxf, true);
    com.tencent.mm.br.c.b(paramContext, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(162284);
  }
  
  public static void dj(Context paramContext, String paramString)
  {
    AppMethodBeat.i(73048);
    String str = paramString;
    if (Util.isNullOrNil(paramString)) {
      str = MMApplicationContext.getContext().getString(a.i.wallet_unknown_err);
    }
    k.d(paramContext, str, "", new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(73048);
  }
  
  public static String e(double paramDouble, String paramString)
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
    if (("1".equals(paramString)) || (Util.isNullOrNil(paramString)))
    {
      paramString = String.format(ai.jOX() + "%.2f", new Object[] { Double.valueOf(paramDouble) });
      AppMethodBeat.o(72993);
      return paramString;
    }
    paramString = String.format(paramString + "%.2f", new Object[] { Double.valueOf(paramDouble) });
    AppMethodBeat.o(72993);
    return paramString;
  }
  
  public static void f(int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(73033);
    com.tencent.mm.plugin.report.service.h.OAn.b(13375, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(1), Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(73033);
  }
  
  public static String formatMoney2f(double paramDouble)
  {
    AppMethodBeat.i(72996);
    String str = String.format("%.2f", new Object[] { Double.valueOf(paramDouble) });
    AppMethodBeat.o(72996);
    return str;
  }
  
  public static String getDisplayName(String paramString)
  {
    AppMethodBeat.i(73016);
    com.tencent.mm.kernel.h.baF();
    Object localObject = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().bxv(paramString);
    if (localObject != null) {}
    for (localObject = ((com.tencent.mm.contact.d)localObject).aSV();; localObject = null)
    {
      if (Util.isNullOrNil((String)localObject)) {}
      for (;;)
      {
        AppMethodBeat.o(73016);
        return paramString;
        paramString = (String)localObject;
      }
    }
  }
  
  public static String getUsername()
  {
    AppMethodBeat.i(73010);
    com.tencent.mm.kernel.h.baC().aZJ();
    String str = z.bAM();
    AppMethodBeat.o(73010);
    return str;
  }
  
  public static void j(TextView paramTextView, String paramString)
  {
    AppMethodBeat.i(73037);
    paramString = jp(paramString, 10);
    paramTextView.setText(p.b(paramTextView.getContext(), paramString, paramTextView.getTextSize()));
    AppMethodBeat.o(73037);
  }
  
  public static void jPs() {}
  
  public static void jPt()
  {
    AppMethodBeat.i(73021);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(new bw(new i.8()), 0);
    AppMethodBeat.o(73021);
  }
  
  public static String jPu()
  {
    AppMethodBeat.i(162285);
    if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yVL, 0) == 0) {}
    for (long l = cn.bDw();; l = cn.bDu())
    {
      String str = Long.toString(l / 1000L);
      AppMethodBeat.o(162285);
      return str;
    }
  }
  
  public static boolean jPv()
  {
    AppMethodBeat.i(242568);
    int i = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zbH, 1);
    Log.i("MicroMsg.WalletBaseUtil ", "secure switch enableValue: %s", new Object[] { Integer.valueOf(i) });
    if (i == 1)
    {
      AppMethodBeat.o(242568);
      return true;
    }
    AppMethodBeat.o(242568);
    return false;
  }
  
  public static MultiProcessMMKV jPw()
  {
    AppMethodBeat.i(242580);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("wc_pay_device_config");
    AppMethodBeat.o(242580);
    return localMultiProcessMMKV;
  }
  
  public static String jn(String paramString, int paramInt)
  {
    AppMethodBeat.i(242466);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(242466);
      return paramString;
    }
    int j = 0;
    int i = 0;
    if (j < paramString.length()) {
      if (paramString.charAt(j) <= '')
      {
        i += 1;
        label47:
        if (i < paramInt) {
          break label110;
        }
      }
    }
    for (paramInt = j + 1;; paramInt = 0)
    {
      i = paramInt;
      if (paramInt > paramString.length()) {
        i = paramString.length();
      }
      try
      {
        paramInt = paramString.offsetByCodePoints(0, paramString.codePointCount(0, i));
        if ((paramInt < paramString.length()) && (paramInt > 0)) {
          break label141;
        }
        AppMethodBeat.o(242466);
        return paramString;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.WalletBaseUtil ", localException, "", new Object[0]);
        AppMethodBeat.o(242466);
        return paramString;
      }
      i += 2;
      break label47;
      label110:
      j += 1;
      break;
      label141:
      paramString = paramString.substring(0, paramInt) + "...";
      AppMethodBeat.o(242466);
      return paramString;
    }
  }
  
  public static String jo(String paramString, int paramInt)
  {
    AppMethodBeat.i(73035);
    if (Util.isNullOrNil(paramString))
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
  
  public static String jp(String paramString, int paramInt)
  {
    AppMethodBeat.i(73036);
    paramString = jo(getDisplayName(paramString), paramInt);
    AppMethodBeat.o(73036);
    return paramString;
  }
  
  public static Typeface nS(Context paramContext)
  {
    AppMethodBeat.i(72989);
    paramContext = bE(paramContext, 4);
    AppMethodBeat.o(72989);
    return paramContext;
  }
  
  public static void nT(Context paramContext)
  {
    AppMethodBeat.i(73005);
    if (paramContext == null)
    {
      Log.e("MicroMsg.WalletBaseUtil ", "hy: jump to preference error. context is null");
      AppMethodBeat.o(73005);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.addFlags(67108864);
    localIntent.putExtra("preferred_tab", 3);
    com.tencent.mm.br.c.g(paramContext, "com.tencent.mm.ui.LauncherUI", localIntent);
    AppMethodBeat.o(73005);
  }
  
  public static void o(Context paramContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(162283);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("showShare", paramBoolean);
    localIntent.putExtra(f.s.adxf, true);
    localIntent.putExtra("allow_mix_content_mode", false);
    com.tencent.mm.br.c.b(paramContext, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(162283);
  }
  
  public static void p(Context paramContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(73002);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("showShare", paramBoolean);
    localIntent.putExtra("allow_mix_content_mode", false);
    com.tencent.mm.br.c.b(paramContext, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(73002);
  }
  
  private static String qw(String paramString1, String paramString2)
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
  
  public static int qx(String paramString1, String paramString2)
  {
    AppMethodBeat.i(73042);
    int i = c(paramString1, paramString2, 0, RoundingMode.HALF_UP).intValue();
    AppMethodBeat.o(73042);
    return i;
  }
  
  public static long qy(String paramString1, String paramString2)
  {
    AppMethodBeat.i(73043);
    long l = c(paramString1, paramString2, 0, RoundingMode.HALF_UP).longValue();
    AppMethodBeat.o(73043);
    return l;
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
      Log.e("erik", "setShowSoftInputOnFocus exception!");
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
        Log.printErrStackTrace("MicroMsg.WalletBaseUtil ", localException, "", new Object[0]);
        AppMethodBeat.o(72992);
        return;
      }
    }
    catch (Exception paramEditText)
    {
      Log.printErrStackTrace("MicroMsg.WalletBaseUtil ", paramEditText, "", new Object[0]);
      AppMethodBeat.o(72992);
    }
  }
  
  public static boolean u(JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(73009);
    boolean bool = "1".equals(paramJSONObject.optString(paramString, "0"));
    AppMethodBeat.o(73009);
    return bool;
  }
  
  public static String vh(int paramInt)
  {
    AppMethodBeat.i(72998);
    if (xiR == null) {
      xiR = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    }
    String str = xiR.format(new Date(paramInt * 1000L));
    AppMethodBeat.o(72998);
    return str;
  }
  
  public static void y(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(73050);
    zp localzp = new zp();
    localzp.icM.userName = paramString1;
    localzp.icM.icO = Util.nullAs(paramString2, "");
    localzp.icM.appVersion = paramInt1;
    localzp.icM.scene = paramInt2;
    localzp.icM.icP = 0;
    localzp.publish();
    AppMethodBeat.o(73050);
  }
  
  public static abstract interface a
  {
    public abstract void bm(Map<String, Object> paramMap);
  }
  
  public static abstract interface b
  {
    public abstract void fS(Object paramObject);
  }
  
  public static final class c
  {
    public String key = null;
    public Object val = null;
    
    public c() {}
    
    public c(String paramString, Object paramObject)
    {
      this.key = paramString;
      this.val = paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.i
 * JD-Core Version:    0.7.0.1
 */