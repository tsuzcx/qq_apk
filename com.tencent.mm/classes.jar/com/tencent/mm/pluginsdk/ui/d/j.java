package com.tencent.mm.pluginsdk.ui.d;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ClickableSpan;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.a;
import java.util.LinkedList;

public final class j
{
  static LinkedList<g> wco;
  private static boolean wcp;
  
  static
  {
    AppMethodBeat.i(79849);
    wco = new LinkedList();
    wcp = bo.hl(ah.getContext());
    AppMethodBeat.o(79849);
  }
  
  private static SpannableString a(Context paramContext, TextView paramTextView, int paramInt, boolean paramBoolean, Object paramObject)
  {
    AppMethodBeat.i(79828);
    paramContext = new p(paramContext);
    paramContext.wcS = true;
    paramContext.wcP = true;
    paramContext.wcX = true;
    paramContext.wcZ = true;
    paramContext.wdd = 1;
    paramContext.wcT = true;
    paramContext.wcV = false;
    paramContext.wdf = true;
    paramContext = paramContext.m(paramTextView);
    paramContext.wcU = true;
    paramContext.wcW = true;
    if (paramObject != null) {
      paramContext.wdg = paramObject;
    }
    paramContext = paramContext.b(paramTextView.getText(), paramInt, paramBoolean);
    AppMethodBeat.o(79828);
    return paramContext;
  }
  
  public static SpannableString a(Context paramContext, CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(79827);
    paramContext = new p(paramContext);
    paramContext.wcS = true;
    paramContext.wcP = true;
    paramContext.wcR = wcp;
    paramContext.wdd = 1;
    paramContext.wcT = true;
    paramContext.wcV = false;
    paramContext.wdf = false;
    paramContext = paramContext.m(null);
    paramContext.wdg = null;
    paramContext.mSessionId = null;
    paramContext.wcU = true;
    paramContext.wcW = true;
    paramContext = paramContext.b(paramCharSequence, paramInt, true);
    AppMethodBeat.o(79827);
    return paramContext;
  }
  
  public static SpannableString a(Context paramContext, CharSequence paramCharSequence, int paramInt1, int paramInt2, Object paramObject, String paramString)
  {
    AppMethodBeat.i(79826);
    paramContext = new p(paramContext);
    paramContext.wcS = true;
    paramContext.wcP = true;
    paramContext.wcR = wcp;
    paramContext.wdd = paramInt2;
    paramContext.wcT = true;
    paramContext.wcV = false;
    paramContext.wdf = true;
    paramContext = paramContext.m(null);
    paramContext.wdg = paramObject;
    paramContext.mSessionId = paramString;
    if (paramInt2 == 1)
    {
      paramContext.wcU = true;
      paramContext.wcW = true;
    }
    for (;;)
    {
      paramContext = paramContext.b(paramCharSequence, paramInt1, true);
      AppMethodBeat.o(79826);
      return paramContext;
      if (paramInt2 == 2)
      {
        paramContext.wcU = false;
        paramContext.wcW = false;
      }
    }
  }
  
  public static SpannableString a(Context paramContext, CharSequence paramCharSequence, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(79836);
    paramContext = new p(paramContext);
    paramContext.wcS = true;
    paramContext.wcP = true;
    paramContext.wcR = wcp;
    paramContext.wdd = paramInt2;
    paramContext.wcT = true;
    paramContext.wcV = false;
    paramContext.wdf = true;
    if (paramInt2 == 1)
    {
      paramContext.wcU = true;
      paramContext.wcW = true;
    }
    for (;;)
    {
      paramContext = paramContext.b(paramCharSequence, paramInt1, true);
      AppMethodBeat.o(79836);
      return paramContext;
      if (paramInt2 == 2)
      {
        paramContext.wcU = false;
        paramContext.wcW = false;
        paramContext.wdb = paramBoolean;
      }
    }
  }
  
  public static SpannableString a(Context paramContext, CharSequence paramCharSequence, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(79839);
    paramContext = a(paramContext, paramCharSequence, paramInt, paramObject, false);
    AppMethodBeat.o(79839);
    return paramContext;
  }
  
  public static SpannableString a(Context paramContext, CharSequence paramCharSequence, int paramInt, Object paramObject, boolean paramBoolean)
  {
    AppMethodBeat.i(79840);
    paramContext = new p(paramContext);
    paramContext.wcS = true;
    paramContext.wcP = true;
    paramContext.wcR = wcp;
    paramContext.wcZ = true;
    paramContext.wdd = 1;
    paramContext.wcT = true;
    paramContext.wcV = false;
    paramContext.wdf = true;
    paramContext.wdg = paramObject;
    paramContext.wdc = paramBoolean;
    paramContext.wcU = true;
    paramContext.wcW = true;
    paramContext = paramContext.b(paramCharSequence, paramInt, false);
    AppMethodBeat.o(79840);
    return paramContext;
  }
  
  private static SpannableString a(Context paramContext, CharSequence paramCharSequence, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(79835);
    paramContext = new p(paramContext);
    paramContext.wcT = false;
    paramContext.wcU = false;
    paramContext.wcP = false;
    paramContext.wcV = false;
    paramContext.wcS = false;
    paramContext.wdf = false;
    paramContext = paramContext.b(paramCharSequence, paramInt, paramBoolean);
    d(paramContext);
    AppMethodBeat.o(79835);
    return paramContext;
  }
  
  public static SpannableString a(Context paramContext, CharSequence paramCharSequence, int paramInt, boolean paramBoolean, Object paramObject)
  {
    AppMethodBeat.i(79821);
    paramContext = new p(paramContext);
    paramContext.wcS = true;
    paramContext.wcP = true;
    paramContext.wcX = true;
    paramContext.wcZ = true;
    paramContext.wdd = 1;
    paramContext.wcT = true;
    paramContext.wcV = false;
    paramContext.wdf = true;
    paramContext = paramContext.m(null);
    paramContext.wcU = true;
    paramContext.wcW = true;
    paramContext.wdg = paramObject;
    paramContext = paramContext.b(paramCharSequence, paramInt, paramBoolean);
    AppMethodBeat.o(79821);
    return paramContext;
  }
  
  public static SpannableString a(TextView paramTextView, Object paramObject)
  {
    AppMethodBeat.i(79822);
    paramTextView = a(paramTextView, true, paramObject);
    AppMethodBeat.o(79822);
    return paramTextView;
  }
  
  public static SpannableString a(TextView paramTextView, boolean paramBoolean, Object paramObject)
  {
    AppMethodBeat.i(79823);
    if (paramTextView == null)
    {
      ab.e("MicroMsg.MMSpanManager", "spanForTextView, textView cannot be null!");
      paramTextView = new SpannableString("");
      AppMethodBeat.o(79823);
      return paramTextView;
    }
    paramTextView = a(paramTextView.getContext(), paramTextView, (int)paramTextView.getTextSize(), paramBoolean, paramObject);
    AppMethodBeat.o(79823);
    return paramTextView;
  }
  
  public static void a(g paramg)
  {
    AppMethodBeat.i(79819);
    wco.add(paramg);
    AppMethodBeat.o(79819);
  }
  
  public static String amy(String paramString)
  {
    AppMethodBeat.i(79844);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(79844);
      return paramString;
    }
    p localp = new p(ah.getContext());
    localp.wcS = false;
    localp.wcP = true;
    localp.wcX = true;
    localp.wcY = true;
    localp.wcZ = true;
    localp.wdd = 1;
    localp.wcT = false;
    localp.wcV = false;
    localp.wcU = false;
    localp.wcW = false;
    localp.wda = false;
    localp.wdf = false;
    paramString = localp.b(paramString, 0, false).toString();
    AppMethodBeat.o(79844);
    return paramString;
  }
  
  public static SpannableString b(Context paramContext, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(79834);
    paramContext = a(paramContext, paramCharSequence, 0, true);
    AppMethodBeat.o(79834);
    return paramContext;
  }
  
  public static SpannableString b(Context paramContext, CharSequence paramCharSequence, float paramFloat)
  {
    AppMethodBeat.i(79830);
    paramContext = a(paramContext, paramCharSequence, (int)paramFloat, true);
    AppMethodBeat.o(79830);
    return paramContext;
  }
  
  public static SpannableString b(Context paramContext, CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(79829);
    paramContext = a(paramContext, paramCharSequence, paramInt, true);
    AppMethodBeat.o(79829);
    return paramContext;
  }
  
  private static SpannableString b(Context paramContext, CharSequence paramCharSequence, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(79843);
    paramContext = new p(paramContext);
    paramContext.wcS = false;
    paramContext.wcP = true;
    paramContext.wcX = true;
    paramContext.wcY = paramBoolean;
    paramContext.wcZ = true;
    paramContext.wdd = 1;
    paramContext.wcT = false;
    paramContext.wcV = false;
    paramContext.wcU = false;
    paramContext.wcW = false;
    paramContext.wdf = false;
    paramContext = paramContext.b(paramCharSequence, paramInt, true);
    AppMethodBeat.o(79843);
    return paramContext;
  }
  
  public static SpannableString b(TextView paramTextView, Object paramObject)
  {
    AppMethodBeat.i(79825);
    if (paramTextView == null)
    {
      ab.e("MicroMsg.MMSpanManager", "spanForTextView, textView cannot be null!");
      paramTextView = new SpannableString("");
      AppMethodBeat.o(79825);
      return paramTextView;
    }
    Object localObject = paramTextView.getContext();
    int i = (int)paramTextView.getTextSize();
    localObject = new p((Context)localObject);
    ((p)localObject).wcS = true;
    ((p)localObject).wcP = true;
    ((p)localObject).wcR = wcp;
    ((p)localObject).wdd = 1;
    ((p)localObject).wcT = true;
    ((p)localObject).wcV = false;
    ((p)localObject).wdf = true;
    localObject = ((p)localObject).m(paramTextView);
    ((p)localObject).wdg = paramObject;
    ((p)localObject).mSessionId = null;
    ((p)localObject).wcU = true;
    ((p)localObject).wcW = true;
    paramTextView = ((p)localObject).b(paramTextView.getText(), i, true);
    AppMethodBeat.o(79825);
    return paramTextView;
  }
  
  public static void b(g paramg)
  {
    AppMethodBeat.i(79820);
    wco.remove(paramg);
    AppMethodBeat.o(79820);
  }
  
  public static SpannableString c(Context paramContext, CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(79832);
    paramContext = new p(paramContext);
    paramContext.wcT = false;
    paramContext.wcU = false;
    paramContext.wcP = false;
    paramContext.wcV = false;
    paramContext.wdd = paramInt;
    paramContext.wcS = false;
    paramContext.wdf = false;
    paramContext = paramContext.b(paramCharSequence, 0, true);
    d(paramContext);
    AppMethodBeat.o(79832);
    return paramContext;
  }
  
  public static CharSequence c(Context paramContext, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(79847);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    localSpannableStringBuilder.append(paramCharSequence);
    int i = paramCharSequence.length();
    localSpannableStringBuilder.append(" ");
    paramContext = paramContext.getResources().getDrawable(2131231832);
    paramContext.setBounds(0, 0, paramContext.getIntrinsicWidth(), paramContext.getIntrinsicHeight());
    localSpannableStringBuilder.setSpan(new a(paramContext), i, i + 1, 18);
    AppMethodBeat.o(79847);
    return localSpannableStringBuilder;
  }
  
  public static void clearCache()
  {
    AppMethodBeat.i(79845);
    ab.i("MicroMsg.MMSpanManager", "clear MMSpanManager cache");
    p.clearCache();
    AppMethodBeat.o(79845);
  }
  
  public static SpannableString d(Context paramContext, CharSequence paramCharSequence, float paramFloat)
  {
    AppMethodBeat.i(79831);
    paramContext = a(paramContext, paramCharSequence, (int)paramFloat, false);
    AppMethodBeat.o(79831);
    return paramContext;
  }
  
  public static SpannableString d(Context paramContext, CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(79837);
    paramContext = a(paramContext, paramCharSequence, paramInt, 1, false);
    AppMethodBeat.o(79837);
    return paramContext;
  }
  
  private static void d(Spannable paramSpannable)
  {
    int i = 0;
    AppMethodBeat.i(79833);
    ClickableSpan[] arrayOfClickableSpan = (ClickableSpan[])paramSpannable.getSpans(0, paramSpannable.length(), ClickableSpan.class);
    while (i < arrayOfClickableSpan.length)
    {
      paramSpannable.removeSpan(arrayOfClickableSpan[i]);
      i += 1;
    }
    AppMethodBeat.o(79833);
  }
  
  public static SpannableString e(Context paramContext, CharSequence paramCharSequence, float paramFloat)
  {
    AppMethodBeat.i(79842);
    paramContext = b(paramContext, paramCharSequence, (int)paramFloat, false);
    AppMethodBeat.o(79842);
    return paramContext;
  }
  
  public static SpannableString e(Context paramContext, CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(79838);
    paramContext = new p(paramContext);
    paramContext.wcS = true;
    paramContext.wcP = true;
    paramContext.wcR = wcp;
    paramContext.wcZ = true;
    paramContext.wdd = 1;
    paramContext.wcT = true;
    paramContext.wcV = false;
    paramContext.wdf = true;
    paramContext.wdg = null;
    paramContext.wcU = true;
    paramContext.wcW = true;
    paramContext = paramContext.b(paramCharSequence, paramInt, true);
    AppMethodBeat.o(79838);
    return paramContext;
  }
  
  public static SpannableString f(Context paramContext, CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(79841);
    paramContext = b(paramContext, paramCharSequence, paramInt, true);
    AppMethodBeat.o(79841);
    return paramContext;
  }
  
  public static SpannableString g(Context paramContext, CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(79848);
    paramContext = new p(paramContext);
    paramContext.wcS = false;
    paramContext.wcP = true;
    paramContext.wcQ = false;
    paramContext.wcX = false;
    paramContext.wcY = false;
    paramContext.wcZ = false;
    paramContext.wdd = 1;
    paramContext.wcT = false;
    paramContext.wcV = false;
    paramContext.wcU = false;
    paramContext.wcW = false;
    paramContext.wdf = true;
    paramContext = paramContext.b(paramCharSequence, paramInt, true);
    AppMethodBeat.o(79848);
    return paramContext;
  }
  
  public static SpannableString k(TextView paramTextView, int paramInt)
  {
    AppMethodBeat.i(79824);
    if (paramTextView == null)
    {
      ab.e("MicroMsg.MMSpanManager", "spanForTextView, textView cannot be null!");
      paramTextView = new SpannableString("");
      AppMethodBeat.o(79824);
      return paramTextView;
    }
    Object localObject = paramTextView.getContext();
    int i = (int)paramTextView.getTextSize();
    localObject = new p((Context)localObject);
    ((p)localObject).wcS = true;
    ((p)localObject).wcP = true;
    ((p)localObject).wcR = wcp;
    ((p)localObject).wdd = paramInt;
    ((p)localObject).wcT = true;
    ((p)localObject).wcV = false;
    ((p)localObject).wdf = true;
    localObject = ((p)localObject).m(paramTextView);
    if (paramInt == 1)
    {
      ((p)localObject).wcU = true;
      ((p)localObject).wcW = true;
    }
    for (;;)
    {
      paramTextView = ((p)localObject).b(paramTextView.getText(), i, true);
      AppMethodBeat.o(79824);
      return paramTextView;
      if (paramInt == 2)
      {
        ((p)localObject).wcU = false;
        ((p)localObject).wcW = false;
      }
    }
  }
  
  public static SpannableString l(TextView paramTextView)
  {
    AppMethodBeat.i(79846);
    if (paramTextView == null)
    {
      ab.e("MicroMsg.MMSpanManager", "spanForTextView, textView cannot be null!");
      paramTextView = new SpannableString("");
      AppMethodBeat.o(79846);
      return paramTextView;
    }
    Object localObject = paramTextView.getContext();
    int i = (int)paramTextView.getTextSize();
    localObject = new p((Context)localObject);
    ((p)localObject).wcS = false;
    ((p)localObject).wcP = false;
    ((p)localObject).wcR = false;
    ((p)localObject).wcT = false;
    ((p)localObject).wcV = false;
    ((p)localObject).wdf = true;
    localObject = ((p)localObject).m(paramTextView);
    ((p)localObject).wcU = false;
    ((p)localObject).wcW = false;
    paramTextView = ((p)localObject).b(paramTextView.getText(), i, false);
    AppMethodBeat.o(79846);
    return paramTextView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.d.j
 * JD-Core Version:    0.7.0.1
 */