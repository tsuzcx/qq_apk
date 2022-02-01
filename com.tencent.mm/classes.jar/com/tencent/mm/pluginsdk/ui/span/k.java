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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.a;
import java.util.LinkedList;

public final class k
{
  static LinkedList<h> Ckd;
  private static boolean Cke;
  
  static
  {
    AppMethodBeat.i(152309);
    Ckd = new LinkedList();
    Cke = bt.iP(aj.getContext());
    AppMethodBeat.o(152309);
  }
  
  private static SpannableString a(Context paramContext, TextView paramTextView, int paramInt, boolean paramBoolean, Object paramObject)
  {
    AppMethodBeat.i(152286);
    paramContext = new q(paramContext);
    paramContext.CkJ = true;
    paramContext.CkF = true;
    paramContext.CkG = true;
    paramContext.CkP = true;
    paramContext.CkR = true;
    paramContext.CkV = 1;
    paramContext.CkK = true;
    paramContext.CkN = false;
    paramContext.CkX = true;
    paramContext = paramContext.w(paramTextView);
    paramContext.CkL = true;
    paramContext.CkO = true;
    if (paramObject != null) {
      paramContext.CkY = paramObject;
    }
    paramContext = paramContext.b(paramTextView.getText(), paramInt, paramBoolean);
    AppMethodBeat.o(152286);
    return paramContext;
  }
  
  public static SpannableString a(Context paramContext, CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(152284);
    paramContext = new q(paramContext);
    paramContext.CkJ = true;
    paramContext.CkF = true;
    paramContext.CkG = true;
    paramContext.CkI = Cke;
    paramContext.CkV = 1;
    paramContext.CkK = true;
    paramContext.CkN = false;
    paramContext.CkX = false;
    paramContext = paramContext.w(null);
    paramContext.CkY = null;
    paramContext.mSessionId = null;
    paramContext.CkL = true;
    paramContext.CkO = true;
    paramContext = paramContext.b(paramCharSequence, paramInt, true);
    AppMethodBeat.o(152284);
    return paramContext;
  }
  
  public static SpannableString a(Context paramContext, CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(162012);
    paramContext = a(paramContext, paramCharSequence, paramInt1, paramInt2, false);
    AppMethodBeat.o(162012);
    return paramContext;
  }
  
  public static SpannableString a(Context paramContext, CharSequence paramCharSequence, int paramInt1, int paramInt2, Object paramObject, String paramString)
  {
    AppMethodBeat.i(152282);
    paramContext = a(paramContext, paramInt2, paramObject, paramString).b(paramCharSequence, paramInt1, true);
    AppMethodBeat.o(152282);
    return paramContext;
  }
  
  public static SpannableString a(Context paramContext, CharSequence paramCharSequence, int paramInt1, int paramInt2, Object paramObject, boolean paramBoolean)
  {
    AppMethodBeat.i(162013);
    paramContext = new q(paramContext);
    paramContext.CkJ = true;
    paramContext.CkF = true;
    paramContext.CkG = true;
    paramContext.CkI = Cke;
    paramContext.CkR = true;
    paramContext.CkV = paramInt2;
    paramContext.CkK = true;
    paramContext.CkN = false;
    paramContext.CkX = true;
    paramContext.CkY = paramObject;
    paramContext.CkU = paramBoolean;
    if (paramInt2 == 1)
    {
      paramContext.CkL = true;
      paramContext.CkO = true;
    }
    for (;;)
    {
      paramContext = paramContext.b(paramCharSequence, paramInt1, false);
      AppMethodBeat.o(162013);
      return paramContext;
      if (paramInt2 == 2)
      {
        paramContext.CkL = false;
        paramContext.CkO = false;
      }
    }
  }
  
  public static SpannableString a(Context paramContext, CharSequence paramCharSequence, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(152294);
    paramContext = new q(paramContext);
    paramContext.CkJ = true;
    paramContext.CkF = true;
    paramContext.CkG = true;
    paramContext.CkI = Cke;
    paramContext.CkV = paramInt2;
    paramContext.CkK = true;
    paramContext.CkN = false;
    paramContext.CkX = true;
    if (paramInt2 == 1)
    {
      paramContext.CkL = true;
      paramContext.CkO = true;
    }
    for (;;)
    {
      paramContext = paramContext.b(paramCharSequence, paramInt1, true);
      AppMethodBeat.o(152294);
      return paramContext;
      if (paramInt2 == 2)
      {
        paramContext.CkL = false;
        paramContext.CkO = false;
        paramContext.CkT = paramBoolean;
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
  
  public static SpannableString a(Context paramContext, CharSequence paramCharSequence, int paramInt, Object paramObject, String paramString)
  {
    AppMethodBeat.i(152283);
    paramContext = a(paramContext, 1, paramObject, paramString);
    paramContext.CkF = false;
    paramContext = paramContext.b(paramCharSequence, paramInt, true);
    AppMethodBeat.o(152283);
    return paramContext;
  }
  
  private static SpannableString a(Context paramContext, CharSequence paramCharSequence, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(152293);
    paramContext = new q(paramContext);
    paramContext.CkK = false;
    paramContext.CkL = false;
    paramContext.CkF = false;
    paramContext.CkG = false;
    paramContext.CkN = false;
    paramContext.CkJ = false;
    paramContext.CkX = false;
    paramContext = paramContext.b(paramCharSequence, paramInt, paramBoolean);
    d(paramContext);
    AppMethodBeat.o(152293);
    return paramContext;
  }
  
  public static SpannableString a(Context paramContext, CharSequence paramCharSequence, int paramInt, boolean paramBoolean, Object paramObject)
  {
    AppMethodBeat.i(152277);
    paramContext = new q(paramContext);
    paramContext.CkP = true;
    paramContext.CkF = true;
    paramContext.CkR = true;
    paramContext.CkV = 1;
    paramContext.CkN = false;
    paramContext.CkX = true;
    paramContext = paramContext.w(null);
    paramContext.CkL = true;
    paramContext.CkO = true;
    if (paramObject != null) {
      paramContext.CkY = paramObject;
    }
    paramContext = paramContext.b(paramCharSequence, paramInt, paramBoolean);
    AppMethodBeat.o(152277);
    return paramContext;
  }
  
  public static SpannableString a(TextView paramTextView, Object paramObject)
  {
    AppMethodBeat.i(152278);
    paramTextView = a(paramTextView, true, paramObject);
    AppMethodBeat.o(152278);
    return paramTextView;
  }
  
  public static SpannableString a(TextView paramTextView, boolean paramBoolean, Object paramObject)
  {
    AppMethodBeat.i(152279);
    if (paramTextView == null)
    {
      ad.e("MicroMsg.MMSpanManager", "spanForTextView, textView cannot be null!");
      paramTextView = new SpannableString("");
      AppMethodBeat.o(152279);
      return paramTextView;
    }
    paramTextView = a(paramTextView.getContext(), paramTextView, (int)paramTextView.getTextSize(), paramBoolean, paramObject);
    AppMethodBeat.o(152279);
    return paramTextView;
  }
  
  private static q a(Context paramContext, int paramInt, Object paramObject, String paramString)
  {
    AppMethodBeat.i(152285);
    paramContext = new q(paramContext);
    paramContext.CkJ = true;
    paramContext.CkF = true;
    paramContext.CkG = true;
    paramContext.CkI = Cke;
    paramContext.CkV = paramInt;
    paramContext.CkK = true;
    paramContext.CkN = false;
    paramContext.CkX = true;
    paramContext = paramContext.w(null);
    paramContext.CkY = paramObject;
    paramContext.mSessionId = paramString;
    if ((paramInt == 1) || (paramInt == 4))
    {
      paramContext.CkL = true;
      paramContext.CkO = true;
    }
    for (;;)
    {
      if ("zh_CN".equals(ac.ir(aj.getContext()))) {
        paramContext.CkM = true;
      }
      AppMethodBeat.o(152285);
      return paramContext;
      if (paramInt == 2)
      {
        paramContext.CkL = false;
        paramContext.CkO = false;
      }
    }
  }
  
  public static void a(h paramh)
  {
    AppMethodBeat.i(152275);
    Ckd.add(paramh);
    AppMethodBeat.o(152275);
  }
  
  public static String aCn(String paramString)
  {
    AppMethodBeat.i(152302);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(152302);
      return paramString;
    }
    q localq = new q(aj.getContext());
    localq.CkJ = false;
    localq.CkF = true;
    localq.CkG = true;
    localq.CkP = true;
    localq.CkQ = true;
    localq.CkR = true;
    localq.CkV = 1;
    localq.CkK = false;
    localq.CkN = false;
    localq.CkL = false;
    localq.CkO = false;
    localq.CkS = false;
    localq.CkX = false;
    paramString = localq.b(paramString, 0, false).toString();
    AppMethodBeat.o(152302);
    return paramString;
  }
  
  public static SpannableString b(Context paramContext, CharSequence paramCharSequence, float paramFloat)
  {
    AppMethodBeat.i(152288);
    paramContext = a(paramContext, paramCharSequence, (int)paramFloat, true);
    AppMethodBeat.o(152288);
    return paramContext;
  }
  
  public static SpannableString b(Context paramContext, CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(152287);
    paramContext = a(paramContext, paramCharSequence, paramInt, true);
    AppMethodBeat.o(152287);
    return paramContext;
  }
  
  private static SpannableString b(Context paramContext, CharSequence paramCharSequence, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(152301);
    paramContext = new q(paramContext);
    paramContext.CkJ = false;
    paramContext.CkF = true;
    paramContext.CkG = true;
    paramContext.CkP = true;
    paramContext.CkQ = paramBoolean;
    paramContext.CkR = true;
    paramContext.CkV = 1;
    paramContext.CkK = false;
    paramContext.CkN = false;
    paramContext.CkL = false;
    paramContext.CkO = false;
    paramContext.CkX = false;
    paramContext = paramContext.b(paramCharSequence, paramInt, true);
    AppMethodBeat.o(152301);
    return paramContext;
  }
  
  public static SpannableString b(TextView paramTextView, Object paramObject)
  {
    AppMethodBeat.i(152281);
    if (paramTextView == null)
    {
      ad.e("MicroMsg.MMSpanManager", "spanForTextView, textView cannot be null!");
      paramTextView = new SpannableString("");
      AppMethodBeat.o(152281);
      return paramTextView;
    }
    Object localObject = paramTextView.getContext();
    int i = (int)paramTextView.getTextSize();
    localObject = new q((Context)localObject);
    ((q)localObject).CkJ = true;
    ((q)localObject).CkF = true;
    ((q)localObject).CkG = true;
    ((q)localObject).CkI = Cke;
    ((q)localObject).CkV = 1;
    ((q)localObject).CkK = true;
    ((q)localObject).CkN = false;
    ((q)localObject).CkX = true;
    localObject = ((q)localObject).w(paramTextView);
    ((q)localObject).CkY = paramObject;
    ((q)localObject).mSessionId = null;
    ((q)localObject).CkL = true;
    ((q)localObject).CkO = true;
    paramTextView = ((q)localObject).b(paramTextView.getText(), i, true);
    AppMethodBeat.o(152281);
    return paramTextView;
  }
  
  public static void b(h paramh)
  {
    AppMethodBeat.i(152276);
    Ckd.remove(paramh);
    AppMethodBeat.o(152276);
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
    AppMethodBeat.i(152290);
    paramContext = new q(paramContext);
    paramContext.CkK = false;
    paramContext.CkL = false;
    paramContext.CkF = false;
    paramContext.CkG = false;
    paramContext.CkN = false;
    paramContext.CkV = paramInt;
    paramContext.CkJ = false;
    paramContext.CkX = false;
    paramContext = paramContext.b(paramCharSequence, 0, true);
    d(paramContext);
    AppMethodBeat.o(152290);
    return paramContext;
  }
  
  public static void clearCache()
  {
    AppMethodBeat.i(152303);
    ad.i("MicroMsg.MMSpanManager", "clear MMSpanManager cache");
    q.clearCache();
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
    AppMethodBeat.i(152296);
    paramContext = new q(paramContext);
    paramContext.CkJ = true;
    paramContext.CkF = true;
    paramContext.CkG = true;
    paramContext.CkI = Cke;
    paramContext.CkR = true;
    paramContext.CkV = 1;
    paramContext.CkK = true;
    paramContext.CkN = false;
    paramContext.CkX = true;
    paramContext.CkY = null;
    paramContext.CkL = true;
    paramContext.CkO = true;
    paramContext = paramContext.b(paramCharSequence, paramInt, true);
    AppMethodBeat.o(152296);
    return paramContext;
  }
  
  public static CharSequence d(Context paramContext, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(152305);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    localSpannableStringBuilder.append(paramCharSequence);
    int i = paramCharSequence.length();
    localSpannableStringBuilder.append(" ");
    paramContext = paramContext.getResources().getDrawable(2131691001);
    paramContext.setBounds(0, 0, paramContext.getIntrinsicWidth(), paramContext.getIntrinsicHeight());
    localSpannableStringBuilder.setSpan(new a(paramContext), i, i + 1, 18);
    AppMethodBeat.o(152305);
    return localSpannableStringBuilder;
  }
  
  private static void d(Spannable paramSpannable)
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
  
  public static SpannableString e(Context paramContext, CharSequence paramCharSequence, float paramFloat)
  {
    AppMethodBeat.i(152300);
    paramContext = b(paramContext, paramCharSequence, (int)paramFloat, false);
    AppMethodBeat.o(152300);
    return paramContext;
  }
  
  public static SpannableString e(Context paramContext, CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(152299);
    paramContext = b(paramContext, paramCharSequence, paramInt, true);
    AppMethodBeat.o(152299);
    return paramContext;
  }
  
  public static SpannableStringBuilder e(Context paramContext, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(152306);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    localSpannableStringBuilder.append(" ");
    paramContext = paramContext.getResources().getDrawable(2131231239);
    paramContext.setBounds(0, 0, paramContext.getIntrinsicWidth(), paramContext.getIntrinsicHeight());
    localSpannableStringBuilder.setSpan(new a(paramContext), 0, 1, 17);
    localSpannableStringBuilder.append(" ");
    localSpannableStringBuilder.append(paramCharSequence);
    AppMethodBeat.o(152306);
    return localSpannableStringBuilder;
  }
  
  public static SpannableString f(Context paramContext, CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(152307);
    paramContext = new q(paramContext);
    paramContext.CkJ = false;
    paramContext.CkF = true;
    paramContext.CkG = true;
    paramContext.CkH = false;
    paramContext.CkP = false;
    paramContext.CkQ = false;
    paramContext.CkR = false;
    paramContext.CkV = 1;
    paramContext.CkK = false;
    paramContext.CkN = false;
    paramContext.CkL = false;
    paramContext.CkO = false;
    paramContext.CkX = true;
    paramContext = paramContext.b(paramCharSequence, paramInt, true);
    AppMethodBeat.o(152307);
    return paramContext;
  }
  
  public static SpannableString h(Context paramContext, CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(203578);
    paramContext = new q(paramContext);
    paramContext.CkJ = false;
    paramContext.CkF = true;
    paramContext.CkG = false;
    paramContext.CkI = Cke;
    paramContext.CkR = false;
    paramContext.CkV = 1;
    paramContext.CkK = true;
    paramContext.CkN = false;
    paramContext.CkX = true;
    paramContext.CkL = false;
    paramContext.CkO = false;
    paramContext = paramContext.b(paramCharSequence, paramInt, true);
    AppMethodBeat.o(203578);
    return paramContext;
  }
  
  public static SpannableString m(TextView paramTextView, int paramInt)
  {
    AppMethodBeat.i(152280);
    if (paramTextView == null)
    {
      ad.e("MicroMsg.MMSpanManager", "spanForTextView, textView cannot be null!");
      paramTextView = new SpannableString("");
      AppMethodBeat.o(152280);
      return paramTextView;
    }
    Object localObject = paramTextView.getContext();
    int i = (int)paramTextView.getTextSize();
    localObject = new q((Context)localObject);
    ((q)localObject).CkJ = true;
    ((q)localObject).CkF = true;
    ((q)localObject).CkG = true;
    ((q)localObject).CkI = Cke;
    ((q)localObject).CkV = paramInt;
    ((q)localObject).CkK = true;
    ((q)localObject).CkN = false;
    ((q)localObject).CkX = true;
    localObject = ((q)localObject).w(paramTextView);
    if (paramInt == 1)
    {
      ((q)localObject).CkL = true;
      ((q)localObject).CkO = true;
    }
    for (;;)
    {
      paramTextView = ((q)localObject).b(paramTextView.getText(), i, true);
      AppMethodBeat.o(152280);
      return paramTextView;
      if (paramInt == 2)
      {
        ((q)localObject).CkL = false;
        ((q)localObject).CkO = false;
      }
    }
  }
  
  public static SpannableString v(TextView paramTextView)
  {
    AppMethodBeat.i(152304);
    if (paramTextView == null)
    {
      ad.e("MicroMsg.MMSpanManager", "spanForTextView, textView cannot be null!");
      paramTextView = new SpannableString("");
      AppMethodBeat.o(152304);
      return paramTextView;
    }
    Object localObject = paramTextView.getContext();
    int i = (int)paramTextView.getTextSize();
    localObject = new q((Context)localObject);
    ((q)localObject).CkJ = false;
    ((q)localObject).CkF = false;
    ((q)localObject).CkG = false;
    ((q)localObject).CkI = false;
    ((q)localObject).CkK = false;
    ((q)localObject).CkN = false;
    ((q)localObject).CkX = true;
    localObject = ((q)localObject).w(paramTextView);
    ((q)localObject).CkL = false;
    ((q)localObject).CkO = false;
    paramTextView = ((q)localObject).b(paramTextView.getText(), i, false);
    AppMethodBeat.o(152304);
    return paramTextView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.span.k
 * JD-Core Version:    0.7.0.1
 */