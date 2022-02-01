package com.tencent.mm.pluginsdk.ui.span;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ClickableSpan;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.util.c;
import java.util.LinkedList;

public final class l
{
  static LinkedList<i> Krd;
  private static boolean Kre;
  public static final a Krf;
  public static b Krg;
  
  static
  {
    AppMethodBeat.i(152309);
    Krd = new LinkedList();
    Kre = Util.isOverseasUser(MMApplicationContext.getContext());
    Krf = new a()
    {
      public final void a(r paramAnonymousr)
      {
        AppMethodBeat.i(223850);
        if (l.Krg.enable()) {}
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousr.KrV = bool;
          AppMethodBeat.o(223850);
          return;
        }
      }
    };
    Krg = new b()
    {
      public final boolean enable()
      {
        return false;
      }
    };
    AppMethodBeat.o(152309);
  }
  
  public static SpannableString B(TextView paramTextView)
  {
    AppMethodBeat.i(152304);
    paramTextView = a(paramTextView.getContext(), paramTextView, (int)paramTextView.getTextSize(), null, null);
    AppMethodBeat.o(152304);
    return paramTextView;
  }
  
  private static SpannableString a(Context paramContext, TextView paramTextView, int paramInt1, int paramInt2, int paramInt3, Object paramObject, a parama)
  {
    AppMethodBeat.i(223858);
    paramContext = new r(paramContext);
    paramContext.KrK = true;
    paramContext.KrG = true;
    paramContext.KrH = true;
    paramContext.KrJ = Kre;
    paramContext.KrY = paramInt2;
    paramContext.KrL = true;
    paramContext.KrO = false;
    paramContext.KrQ = aiK(paramInt2);
    paramContext.Ksa = true;
    paramContext.Ksb = paramObject;
    paramContext = paramContext.C(paramTextView);
    paramContext.gwE = paramInt3;
    if (paramInt2 == 1)
    {
      paramContext.KrM = true;
      paramContext.KrP = true;
    }
    for (;;)
    {
      if (parama != null) {
        parama.a(paramContext);
      }
      paramContext = paramContext.b(paramTextView.getText(), paramInt1, true);
      AppMethodBeat.o(223858);
      return paramContext;
      if (paramInt2 == 2)
      {
        paramContext.KrM = false;
        paramContext.KrP = false;
      }
    }
  }
  
  private static SpannableString a(Context paramContext, TextView paramTextView, int paramInt, Object paramObject, a parama)
  {
    AppMethodBeat.i(223865);
    paramContext = new r(paramContext);
    paramContext.KrK = false;
    paramContext.KrG = false;
    paramContext.KrH = false;
    paramContext.KrJ = false;
    paramContext.KrL = false;
    paramContext.KrO = false;
    paramContext.Ksa = true;
    paramContext = paramContext.C(paramTextView);
    paramContext.Ksb = paramObject;
    paramContext.KrY = 1;
    paramContext.KrM = false;
    paramContext.KrP = false;
    if (parama != null) {
      parama.a(paramContext);
    }
    paramContext = paramContext.b(paramTextView.getText(), paramInt, false);
    AppMethodBeat.o(223865);
    return paramContext;
  }
  
  private static SpannableString a(Context paramContext, TextView paramTextView, int paramInt1, boolean paramBoolean, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(223859);
    paramContext = new r(paramContext);
    paramContext.KrK = true;
    paramContext.KrG = true;
    paramContext.KrH = true;
    paramContext.KrR = true;
    paramContext.KrT = true;
    paramContext.KrY = 1;
    paramContext.KrL = true;
    paramContext.KrO = false;
    paramContext.Ksa = true;
    paramContext = paramContext.C(paramTextView);
    paramContext.KrM = true;
    paramContext.KrP = true;
    if (paramObject != null) {
      paramContext.Ksb = paramObject;
    }
    paramContext = paramContext.b(paramTextView.getText(), paramInt1, paramBoolean);
    AppMethodBeat.o(223859);
    return paramContext;
  }
  
  public static SpannableString a(Context paramContext, CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(162012);
    paramContext = a(paramContext, paramCharSequence, paramInt1, paramInt2, false, null);
    AppMethodBeat.o(162012);
    return paramContext;
  }
  
  public static SpannableString a(Context paramContext, CharSequence paramCharSequence, int paramInt1, int paramInt2, Object paramObject, String paramString)
  {
    AppMethodBeat.i(152282);
    paramContext = a(paramContext, paramCharSequence, paramInt1, paramInt2, paramObject, paramString, 0, null);
    AppMethodBeat.o(152282);
    return paramContext;
  }
  
  public static SpannableString a(Context paramContext, CharSequence paramCharSequence, int paramInt1, int paramInt2, Object paramObject, String paramString, int paramInt3, a parama)
  {
    AppMethodBeat.i(223856);
    paramContext = a(paramContext, paramInt2, paramObject, paramString);
    paramContext.gwE = paramInt3;
    if (parama != null) {
      parama.a(paramContext);
    }
    paramContext = paramContext.b(paramCharSequence, paramInt1, true);
    AppMethodBeat.o(223856);
    return paramContext;
  }
  
  public static SpannableString a(Context paramContext, CharSequence paramCharSequence, int paramInt1, int paramInt2, Object paramObject, boolean paramBoolean)
  {
    AppMethodBeat.i(162013);
    paramContext = new r(paramContext);
    paramContext.KrK = true;
    paramContext.KrG = true;
    paramContext.KrH = true;
    paramContext.KrJ = Kre;
    paramContext.KrT = true;
    paramContext.KrY = paramInt2;
    paramContext.KrL = true;
    paramContext.KrO = false;
    paramContext.Ksa = true;
    paramContext.Ksb = paramObject;
    paramContext.KrX = paramBoolean;
    if (paramInt2 == 1)
    {
      paramContext.KrM = true;
      paramContext.KrP = true;
    }
    for (;;)
    {
      paramContext = paramContext.b(paramCharSequence, paramInt1, false);
      AppMethodBeat.o(162013);
      return paramContext;
      if (paramInt2 == 2)
      {
        paramContext.KrM = false;
        paramContext.KrP = false;
      }
    }
  }
  
  public static SpannableString a(Context paramContext, CharSequence paramCharSequence, int paramInt1, int paramInt2, boolean paramBoolean, Object paramObject)
  {
    AppMethodBeat.i(223861);
    paramContext = a(paramContext, paramCharSequence, paramInt1, paramInt2, paramBoolean, paramObject, null);
    AppMethodBeat.o(223861);
    return paramContext;
  }
  
  public static SpannableString a(Context paramContext, CharSequence paramCharSequence, int paramInt1, int paramInt2, boolean paramBoolean, Object paramObject, a parama)
  {
    AppMethodBeat.i(223862);
    paramContext = new r(paramContext);
    paramContext.KrK = true;
    paramContext.KrG = true;
    paramContext.KrH = true;
    paramContext.KrJ = Kre;
    paramContext.KrY = paramInt2;
    paramContext.KrL = true;
    paramContext.KrO = false;
    paramContext.Ksa = true;
    paramContext.KrQ = aiK(paramInt2);
    paramContext.Ksb = paramObject;
    if (paramInt2 == 1)
    {
      paramContext.KrM = true;
      paramContext.KrP = true;
    }
    for (;;)
    {
      if (parama != null) {
        parama.a(paramContext);
      }
      paramContext = paramContext.b(paramCharSequence, paramInt1, true);
      AppMethodBeat.o(223862);
      return paramContext;
      if (paramInt2 == 2)
      {
        paramContext.KrM = false;
        paramContext.KrP = false;
        paramContext.KrW = paramBoolean;
        paramContext.gwE = 2;
      }
    }
  }
  
  public static SpannableString a(Context paramContext, CharSequence paramCharSequence, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(152297);
    paramContext = a(paramContext, paramCharSequence, paramInt, 1, paramObject, false);
    AppMethodBeat.o(152297);
    return paramContext;
  }
  
  public static SpannableString a(Context paramContext, CharSequence paramCharSequence, int paramInt, Object paramObject, String paramString, a parama)
  {
    AppMethodBeat.i(223857);
    paramContext = a(paramContext, 1, paramObject, paramString);
    paramContext.KrG = false;
    if (parama != null) {
      parama.a(paramContext);
    }
    paramContext = paramContext.b(paramCharSequence, paramInt, true);
    AppMethodBeat.o(223857);
    return paramContext;
  }
  
  private static SpannableString a(Context paramContext, CharSequence paramCharSequence, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(152293);
    paramContext = new r(paramContext);
    paramContext.KrL = false;
    paramContext.KrM = false;
    paramContext.KrG = false;
    paramContext.KrH = false;
    paramContext.KrO = false;
    paramContext.KrK = false;
    paramContext.Ksa = false;
    paramContext = paramContext.b(paramCharSequence, paramInt, paramBoolean);
    e(paramContext);
    AppMethodBeat.o(152293);
    return paramContext;
  }
  
  public static SpannableString a(Context paramContext, CharSequence paramCharSequence, int paramInt, boolean paramBoolean, Object paramObject)
  {
    AppMethodBeat.i(152277);
    paramContext = new r(paramContext);
    paramContext.KrR = true;
    paramContext.KrG = true;
    paramContext.KrT = true;
    paramContext.KrY = 1;
    paramContext.KrO = false;
    paramContext.Ksa = true;
    paramContext = paramContext.C(null);
    paramContext.KrM = true;
    paramContext.KrP = true;
    if (paramObject != null) {
      paramContext.Ksb = paramObject;
    }
    paramContext = paramContext.b(paramCharSequence, paramInt, paramBoolean);
    AppMethodBeat.o(152277);
    return paramContext;
  }
  
  public static SpannableString a(TextView paramTextView, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(223851);
    paramTextView = a(paramTextView, paramInt1, paramInt2, paramObject, null);
    AppMethodBeat.o(223851);
    return paramTextView;
  }
  
  public static SpannableString a(TextView paramTextView, int paramInt1, int paramInt2, Object paramObject, a parama)
  {
    AppMethodBeat.i(223852);
    if (paramTextView == null)
    {
      Log.e("MicroMsg.MMSpanManager", "spanForTextView, textView cannot be null!");
      paramTextView = new SpannableString("");
      AppMethodBeat.o(223852);
      return paramTextView;
    }
    paramTextView = a(paramTextView.getContext(), paramTextView, (int)paramTextView.getTextSize(), paramInt1, paramInt2, paramObject, parama);
    AppMethodBeat.o(223852);
    return paramTextView;
  }
  
  public static SpannableString a(TextView paramTextView, a parama, Object paramObject)
  {
    AppMethodBeat.i(223853);
    if (paramTextView == null)
    {
      Log.e("MicroMsg.MMSpanManager", "spanForTextView, textView cannot be null!");
      paramTextView = new SpannableString("");
      AppMethodBeat.o(223853);
      return paramTextView;
    }
    Object localObject = paramTextView.getContext();
    int i = (int)paramTextView.getTextSize();
    localObject = new r((Context)localObject);
    ((r)localObject).KrK = true;
    ((r)localObject).KrG = true;
    ((r)localObject).KrH = true;
    ((r)localObject).KrJ = Kre;
    ((r)localObject).KrY = 2;
    ((r)localObject).KrL = true;
    ((r)localObject).KrO = false;
    ((r)localObject).KrQ = aiK(2);
    ((r)localObject).Ksa = true;
    ((r)localObject).Ksb = paramObject;
    paramObject = ((r)localObject).C(paramTextView);
    paramObject.gwE = 2;
    paramObject.mAdTagClickCallback = parama;
    paramObject.mAdTagClickScene = 30;
    paramObject.KrM = false;
    paramObject.KrP = false;
    paramTextView = paramObject.b(paramTextView.getText(), i, true);
    AppMethodBeat.o(223853);
    return paramTextView;
  }
  
  public static SpannableString a(TextView paramTextView, Object paramObject)
  {
    AppMethodBeat.i(152278);
    paramTextView = a(paramTextView, true, paramObject);
    AppMethodBeat.o(152278);
    return paramTextView;
  }
  
  public static SpannableString a(TextView paramTextView, Object paramObject, a parama)
  {
    AppMethodBeat.i(223854);
    if (paramTextView == null)
    {
      Log.e("MicroMsg.MMSpanManager", "spanForTextView, textView cannot be null!");
      paramTextView = new SpannableString("");
      AppMethodBeat.o(223854);
      return paramTextView;
    }
    Object localObject = paramTextView.getContext();
    int i = (int)paramTextView.getTextSize();
    localObject = new r((Context)localObject);
    ((r)localObject).KrK = true;
    ((r)localObject).KrG = true;
    ((r)localObject).KrH = true;
    ((r)localObject).KrJ = Kre;
    ((r)localObject).KrY = 1;
    ((r)localObject).KrL = true;
    ((r)localObject).KrO = false;
    ((r)localObject).Ksa = true;
    localObject = ((r)localObject).C(paramTextView);
    ((r)localObject).Ksb = paramObject;
    ((r)localObject).mSessionId = null;
    ((r)localObject).KrM = true;
    ((r)localObject).KrP = true;
    if (parama != null) {
      parama.a((r)localObject);
    }
    paramTextView = ((r)localObject).b(paramTextView.getText(), i, true);
    AppMethodBeat.o(223854);
    return paramTextView;
  }
  
  public static SpannableString a(TextView paramTextView, boolean paramBoolean, Object paramObject)
  {
    AppMethodBeat.i(152279);
    if (paramTextView == null)
    {
      Log.e("MicroMsg.MMSpanManager", "spanForTextView, textView cannot be null!");
      paramTextView = new SpannableString("");
      AppMethodBeat.o(152279);
      return paramTextView;
    }
    paramTextView = a(paramTextView.getContext(), paramTextView, (int)paramTextView.getTextSize(), paramBoolean, 1, paramObject);
    AppMethodBeat.o(152279);
    return paramTextView;
  }
  
  private static r a(Context paramContext, int paramInt, Object paramObject, String paramString)
  {
    AppMethodBeat.i(152285);
    paramContext = new r(paramContext);
    paramContext.KrK = true;
    paramContext.KrG = true;
    paramContext.KrH = true;
    paramContext.KrJ = Kre;
    paramContext.KrY = paramInt;
    paramContext.KrL = true;
    paramContext.KrO = false;
    paramContext.Ksa = true;
    paramContext = paramContext.C(null);
    paramContext.Ksb = paramObject;
    paramContext.mSessionId = paramString;
    if ((paramInt == 1) || (paramInt == 4))
    {
      paramContext.KrM = true;
      paramContext.KrP = true;
    }
    for (;;)
    {
      if ("zh_CN".equals(LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()))) {
        paramContext.KrN = true;
      }
      paramContext.KrQ = aiK(paramInt);
      AppMethodBeat.o(152285);
      return paramContext;
      if (paramInt == 2)
      {
        paramContext.KrM = false;
        paramContext.KrP = false;
      }
    }
  }
  
  public static void a(i parami)
  {
    AppMethodBeat.i(152275);
    Krd.add(parami);
    AppMethodBeat.o(152275);
  }
  
  private static boolean aiK(int paramInt)
  {
    AppMethodBeat.i(223860);
    if ((paramInt == 2) || (paramInt == 3))
    {
      localObject = c.QYz;
      if (c.hdg())
      {
        AppMethodBeat.o(223860);
        return true;
      }
      localObject = (b)g.af(b.class);
      locala = b.a.shv;
      localc = c.QYz;
      if (((b)localObject).a(locala, c.hdj()) == 1)
      {
        AppMethodBeat.o(223860);
        return true;
      }
      AppMethodBeat.o(223860);
      return false;
    }
    Object localObject = c.QYz;
    if (c.hdg())
    {
      AppMethodBeat.o(223860);
      return true;
    }
    localObject = (b)g.af(b.class);
    b.a locala = b.a.shu;
    c localc = c.QYz;
    if (((b)localObject).a(locala, c.hdi()) == 1)
    {
      AppMethodBeat.o(223860);
      return true;
    }
    AppMethodBeat.o(223860);
    return false;
  }
  
  public static SpannableString b(Context paramContext, CharSequence paramCharSequence, float paramFloat)
  {
    AppMethodBeat.i(152288);
    paramContext = a(paramContext, paramCharSequence, (int)paramFloat, true);
    AppMethodBeat.o(152288);
    return paramContext;
  }
  
  private static SpannableString b(Context paramContext, CharSequence paramCharSequence, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(152301);
    paramContext = new r(paramContext);
    paramContext.KrK = false;
    paramContext.KrG = true;
    paramContext.KrH = true;
    paramContext.KrR = true;
    paramContext.KrS = paramBoolean;
    paramContext.KrT = true;
    paramContext.KrY = 1;
    paramContext.KrL = false;
    paramContext.KrO = false;
    paramContext.KrM = false;
    paramContext.KrP = false;
    paramContext.Ksa = false;
    paramContext = paramContext.b(paramCharSequence, paramInt, true);
    AppMethodBeat.o(152301);
    return paramContext;
  }
  
  public static SpannableString b(TextView paramTextView, Object paramObject, a parama)
  {
    AppMethodBeat.i(223864);
    if (paramTextView == null)
    {
      Log.e("MicroMsg.MMSpanManager", "spanForTextView, textView cannot be null!");
      paramTextView = new SpannableString("");
      AppMethodBeat.o(223864);
      return paramTextView;
    }
    paramTextView = a(paramTextView.getContext(), paramTextView, (int)paramTextView.getTextSize(), paramObject, parama);
    AppMethodBeat.o(223864);
    return paramTextView;
  }
  
  public static void b(i parami)
  {
    AppMethodBeat.i(152276);
    Krd.remove(parami);
    AppMethodBeat.o(152276);
  }
  
  public static String bfh(String paramString)
  {
    AppMethodBeat.i(152302);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(152302);
      return paramString;
    }
    r localr = new r(MMApplicationContext.getContext());
    localr.KrK = false;
    localr.KrG = true;
    localr.KrH = true;
    localr.KrR = true;
    localr.KrS = true;
    localr.KrT = true;
    localr.KrY = 1;
    localr.KrL = false;
    localr.KrO = false;
    localr.KrM = false;
    localr.KrP = false;
    localr.KrU = false;
    localr.Ksa = false;
    paramString = localr.b(paramString, 0, false).toString();
    AppMethodBeat.o(152302);
    return paramString;
  }
  
  public static SpannableString c(Context paramContext, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(152292);
    paramContext = a(paramContext, paramCharSequence, 0, true);
    AppMethodBeat.o(152292);
    return paramContext;
  }
  
  public static SpannableString c(Context paramContext, CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(223855);
    paramContext = new r(paramContext);
    paramContext.KrK = false;
    paramContext.KrG = false;
    paramContext.KrH = false;
    paramContext.KrJ = Kre;
    paramContext.KrY = 1;
    paramContext.KrL = false;
    paramContext.KrO = false;
    paramContext.KrQ = aiK(1);
    paramContext.Ksa = true;
    paramContext.KrT = true;
    paramContext = paramContext.b(paramCharSequence, paramInt, false);
    AppMethodBeat.o(223855);
    return paramContext;
  }
  
  public static void clearCache()
  {
    AppMethodBeat.i(152303);
    Log.i("MicroMsg.MMSpanManager", "clear MMSpanManager cache");
    r.clearCache();
    AppMethodBeat.o(152303);
  }
  
  public static SpannableString d(Context paramContext, CharSequence paramCharSequence, float paramFloat)
  {
    AppMethodBeat.i(152289);
    paramContext = a(paramContext, paramCharSequence, (int)paramFloat, false);
    AppMethodBeat.o(152289);
    return paramContext;
  }
  
  public static SpannableString d(Context paramContext, CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(152284);
    paramContext = new r(paramContext);
    paramContext.KrK = true;
    paramContext.KrG = true;
    paramContext.KrH = true;
    paramContext.KrJ = Kre;
    paramContext.KrY = 1;
    paramContext.KrL = true;
    paramContext.KrO = false;
    paramContext.Ksa = false;
    paramContext = paramContext.C(null);
    paramContext.Ksb = null;
    paramContext.mSessionId = null;
    paramContext.KrM = true;
    paramContext.KrP = true;
    paramContext = paramContext.b(paramCharSequence, paramInt, true);
    AppMethodBeat.o(152284);
    return paramContext;
  }
  
  public static CharSequence d(Context paramContext, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(152305);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    localSpannableStringBuilder.append(paramCharSequence);
    int i = paramCharSequence.length();
    localSpannableStringBuilder.append(" ");
    paramContext = paramContext.getResources().getDrawable(2131691299);
    paramContext.setBounds(0, 0, paramContext.getIntrinsicWidth(), paramContext.getIntrinsicHeight());
    localSpannableStringBuilder.setSpan(new com.tencent.mm.ui.widget.a(paramContext), i, i + 1, 18);
    AppMethodBeat.o(152305);
    return localSpannableStringBuilder;
  }
  
  public static SpannableString e(Context paramContext, CharSequence paramCharSequence, float paramFloat)
  {
    AppMethodBeat.i(152300);
    paramContext = b(paramContext, paramCharSequence, (int)paramFloat, false);
    AppMethodBeat.o(152300);
    return paramContext;
  }
  
  public static SpannableString e(Context paramContext, CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(152287);
    paramContext = a(paramContext, paramCharSequence, paramInt, true);
    AppMethodBeat.o(152287);
    return paramContext;
  }
  
  private static void e(Spannable paramSpannable)
  {
    int i = 0;
    AppMethodBeat.i(152291);
    ClickableSpan[] arrayOfClickableSpan = (ClickableSpan[])paramSpannable.getSpans(0, paramSpannable.length(), ClickableSpan.class);
    while (i < arrayOfClickableSpan.length)
    {
      paramSpannable.removeSpan(arrayOfClickableSpan[i]);
      i += 1;
    }
    AppMethodBeat.o(152291);
  }
  
  public static SpannableString f(Context paramContext, CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(152290);
    paramContext = new r(paramContext);
    paramContext.KrL = false;
    paramContext.KrM = false;
    paramContext.KrG = false;
    paramContext.KrH = false;
    paramContext.KrO = false;
    paramContext.KrY = paramInt;
    paramContext.KrK = false;
    paramContext.Ksa = false;
    paramContext = paramContext.b(paramCharSequence, 0, true);
    e(paramContext);
    AppMethodBeat.o(152290);
    return paramContext;
  }
  
  public static SpannableString g(Context paramContext, CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(152296);
    paramContext = new r(paramContext);
    paramContext.KrK = true;
    paramContext.KrG = true;
    paramContext.KrH = true;
    paramContext.KrJ = Kre;
    paramContext.KrT = true;
    paramContext.KrY = 1;
    paramContext.KrL = true;
    paramContext.KrO = false;
    paramContext.Ksa = true;
    paramContext.Ksb = null;
    paramContext.KrM = true;
    paramContext.KrP = true;
    paramContext = paramContext.b(paramCharSequence, paramInt, true);
    AppMethodBeat.o(152296);
    return paramContext;
  }
  
  public static SpannableString h(Context paramContext, CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(223863);
    paramContext = new r(paramContext);
    paramContext.KrK = false;
    paramContext.KrG = true;
    paramContext.KrH = false;
    paramContext.KrJ = Kre;
    paramContext.KrT = false;
    paramContext.KrY = 1;
    paramContext.KrL = true;
    paramContext.KrO = false;
    paramContext.Ksa = true;
    paramContext.KrM = false;
    paramContext.KrP = false;
    paramContext = paramContext.b(paramCharSequence, paramInt, true);
    AppMethodBeat.o(223863);
    return paramContext;
  }
  
  public static SpannableString i(Context paramContext, CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(152299);
    paramContext = b(paramContext, paramCharSequence, paramInt, true);
    AppMethodBeat.o(152299);
    return paramContext;
  }
  
  public static SpannableString j(Context paramContext, CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(152307);
    paramContext = new r(paramContext);
    paramContext.KrK = false;
    paramContext.KrG = true;
    paramContext.KrH = true;
    paramContext.KrI = false;
    paramContext.KrR = false;
    paramContext.KrS = false;
    paramContext.KrT = false;
    paramContext.KrY = 1;
    paramContext.KrL = false;
    paramContext.KrO = false;
    paramContext.KrM = false;
    paramContext.KrP = false;
    paramContext.Ksa = true;
    paramContext = paramContext.b(paramCharSequence, paramInt, true);
    AppMethodBeat.o(152307);
    return paramContext;
  }
  
  public static SpannableString p(TextView paramTextView, int paramInt)
  {
    AppMethodBeat.i(152280);
    paramTextView = a(paramTextView, paramInt, 0, null);
    AppMethodBeat.o(152280);
    return paramTextView;
  }
  
  public static abstract interface a
  {
    public abstract void a(r paramr);
  }
  
  public static abstract interface b
  {
    public abstract boolean enable();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.span.l
 * JD-Core Version:    0.7.0.1
 */