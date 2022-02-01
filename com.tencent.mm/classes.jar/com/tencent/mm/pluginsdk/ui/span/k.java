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
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.widget.a;
import java.util.LinkedList;

public final class k
{
  static LinkedList<h> DCu;
  private static boolean DCv;
  
  static
  {
    AppMethodBeat.i(152309);
    DCu = new LinkedList();
    DCv = bs.ja(ai.getContext());
    AppMethodBeat.o(152309);
  }
  
  private static SpannableString a(Context paramContext, TextView paramTextView, int paramInt, boolean paramBoolean, Object paramObject)
  {
    AppMethodBeat.i(152286);
    paramContext = new q(paramContext);
    paramContext.DDa = true;
    paramContext.DCW = true;
    paramContext.DCX = true;
    paramContext.DDg = true;
    paramContext.DDi = true;
    paramContext.DDm = 1;
    paramContext.DDb = true;
    paramContext.DDe = false;
    paramContext.DDo = true;
    paramContext = paramContext.w(paramTextView);
    paramContext.DDc = true;
    paramContext.DDf = true;
    if (paramObject != null) {
      paramContext.DDp = paramObject;
    }
    paramContext = paramContext.b(paramTextView.getText(), paramInt, paramBoolean);
    AppMethodBeat.o(152286);
    return paramContext;
  }
  
  public static SpannableString a(Context paramContext, CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(152284);
    paramContext = new q(paramContext);
    paramContext.DDa = true;
    paramContext.DCW = true;
    paramContext.DCX = true;
    paramContext.DCZ = DCv;
    paramContext.DDm = 1;
    paramContext.DDb = true;
    paramContext.DDe = false;
    paramContext.DDo = false;
    paramContext = paramContext.w(null);
    paramContext.DDp = null;
    paramContext.mSessionId = null;
    paramContext.DDc = true;
    paramContext.DDf = true;
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
    paramContext.DDa = true;
    paramContext.DCW = true;
    paramContext.DCX = true;
    paramContext.DCZ = DCv;
    paramContext.DDi = true;
    paramContext.DDm = paramInt2;
    paramContext.DDb = true;
    paramContext.DDe = false;
    paramContext.DDo = true;
    paramContext.DDp = paramObject;
    paramContext.DDl = paramBoolean;
    if (paramInt2 == 1)
    {
      paramContext.DDc = true;
      paramContext.DDf = true;
    }
    for (;;)
    {
      paramContext = paramContext.b(paramCharSequence, paramInt1, false);
      AppMethodBeat.o(162013);
      return paramContext;
      if (paramInt2 == 2)
      {
        paramContext.DDc = false;
        paramContext.DDf = false;
      }
    }
  }
  
  public static SpannableString a(Context paramContext, CharSequence paramCharSequence, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(152294);
    paramContext = new q(paramContext);
    paramContext.DDa = true;
    paramContext.DCW = true;
    paramContext.DCX = true;
    paramContext.DCZ = DCv;
    paramContext.DDm = paramInt2;
    paramContext.DDb = true;
    paramContext.DDe = false;
    paramContext.DDo = true;
    if (paramInt2 == 1)
    {
      paramContext.DDc = true;
      paramContext.DDf = true;
    }
    for (;;)
    {
      paramContext = paramContext.b(paramCharSequence, paramInt1, true);
      AppMethodBeat.o(152294);
      return paramContext;
      if (paramInt2 == 2)
      {
        paramContext.DDc = false;
        paramContext.DDf = false;
        paramContext.DDk = paramBoolean;
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
    paramContext.DCW = false;
    paramContext = paramContext.b(paramCharSequence, paramInt, true);
    AppMethodBeat.o(152283);
    return paramContext;
  }
  
  private static SpannableString a(Context paramContext, CharSequence paramCharSequence, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(152293);
    paramContext = new q(paramContext);
    paramContext.DDb = false;
    paramContext.DDc = false;
    paramContext.DCW = false;
    paramContext.DCX = false;
    paramContext.DDe = false;
    paramContext.DDa = false;
    paramContext.DDo = false;
    paramContext = paramContext.b(paramCharSequence, paramInt, paramBoolean);
    e(paramContext);
    AppMethodBeat.o(152293);
    return paramContext;
  }
  
  public static SpannableString a(Context paramContext, CharSequence paramCharSequence, int paramInt, boolean paramBoolean, Object paramObject)
  {
    AppMethodBeat.i(152277);
    paramContext = new q(paramContext);
    paramContext.DDg = true;
    paramContext.DCW = true;
    paramContext.DDi = true;
    paramContext.DDm = 1;
    paramContext.DDe = false;
    paramContext.DDo = true;
    paramContext = paramContext.w(null);
    paramContext.DDc = true;
    paramContext.DDf = true;
    if (paramObject != null) {
      paramContext.DDp = paramObject;
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
      ac.e("MicroMsg.MMSpanManager", "spanForTextView, textView cannot be null!");
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
    paramContext.DDa = true;
    paramContext.DCW = true;
    paramContext.DCX = true;
    paramContext.DCZ = DCv;
    paramContext.DDm = paramInt;
    paramContext.DDb = true;
    paramContext.DDe = false;
    paramContext.DDo = true;
    paramContext = paramContext.w(null);
    paramContext.DDp = paramObject;
    paramContext.mSessionId = paramString;
    if ((paramInt == 1) || (paramInt == 4))
    {
      paramContext.DDc = true;
      paramContext.DDf = true;
    }
    for (;;)
    {
      if ("zh_CN".equals(ab.iC(ai.getContext()))) {
        paramContext.DDd = true;
      }
      AppMethodBeat.o(152285);
      return paramContext;
      if (paramInt == 2)
      {
        paramContext.DDc = false;
        paramContext.DDf = false;
      }
    }
  }
  
  public static void a(h paramh)
  {
    AppMethodBeat.i(152275);
    DCu.add(paramh);
    AppMethodBeat.o(152275);
  }
  
  public static String aHF(String paramString)
  {
    AppMethodBeat.i(152302);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(152302);
      return paramString;
    }
    q localq = new q(ai.getContext());
    localq.DDa = false;
    localq.DCW = true;
    localq.DCX = true;
    localq.DDg = true;
    localq.DDh = true;
    localq.DDi = true;
    localq.DDm = 1;
    localq.DDb = false;
    localq.DDe = false;
    localq.DDc = false;
    localq.DDf = false;
    localq.DDj = false;
    localq.DDo = false;
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
    paramContext.DDa = false;
    paramContext.DCW = true;
    paramContext.DCX = true;
    paramContext.DDg = true;
    paramContext.DDh = paramBoolean;
    paramContext.DDi = true;
    paramContext.DDm = 1;
    paramContext.DDb = false;
    paramContext.DDe = false;
    paramContext.DDc = false;
    paramContext.DDf = false;
    paramContext.DDo = false;
    paramContext = paramContext.b(paramCharSequence, paramInt, true);
    AppMethodBeat.o(152301);
    return paramContext;
  }
  
  public static SpannableString b(TextView paramTextView, Object paramObject)
  {
    AppMethodBeat.i(152281);
    if (paramTextView == null)
    {
      ac.e("MicroMsg.MMSpanManager", "spanForTextView, textView cannot be null!");
      paramTextView = new SpannableString("");
      AppMethodBeat.o(152281);
      return paramTextView;
    }
    Object localObject = paramTextView.getContext();
    int i = (int)paramTextView.getTextSize();
    localObject = new q((Context)localObject);
    ((q)localObject).DDa = true;
    ((q)localObject).DCW = true;
    ((q)localObject).DCX = true;
    ((q)localObject).DCZ = DCv;
    ((q)localObject).DDm = 1;
    ((q)localObject).DDb = true;
    ((q)localObject).DDe = false;
    ((q)localObject).DDo = true;
    localObject = ((q)localObject).w(paramTextView);
    ((q)localObject).DDp = paramObject;
    ((q)localObject).mSessionId = null;
    ((q)localObject).DDc = true;
    ((q)localObject).DDf = true;
    paramTextView = ((q)localObject).b(paramTextView.getText(), i, true);
    AppMethodBeat.o(152281);
    return paramTextView;
  }
  
  public static void b(h paramh)
  {
    AppMethodBeat.i(152276);
    DCu.remove(paramh);
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
    paramContext.DDb = false;
    paramContext.DDc = false;
    paramContext.DCW = false;
    paramContext.DCX = false;
    paramContext.DDe = false;
    paramContext.DDm = paramInt;
    paramContext.DDa = false;
    paramContext.DDo = false;
    paramContext = paramContext.b(paramCharSequence, 0, true);
    e(paramContext);
    AppMethodBeat.o(152290);
    return paramContext;
  }
  
  public static void clearCache()
  {
    AppMethodBeat.i(152303);
    ac.i("MicroMsg.MMSpanManager", "clear MMSpanManager cache");
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
    paramContext.DDa = true;
    paramContext.DCW = true;
    paramContext.DCX = true;
    paramContext.DCZ = DCv;
    paramContext.DDi = true;
    paramContext.DDm = 1;
    paramContext.DDb = true;
    paramContext.DDe = false;
    paramContext.DDo = true;
    paramContext.DDp = null;
    paramContext.DDc = true;
    paramContext.DDf = true;
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
  
  public static SpannableString e(Context paramContext, CharSequence paramCharSequence, float paramFloat)
  {
    AppMethodBeat.i(152300);
    paramContext = b(paramContext, paramCharSequence, (int)paramFloat, false);
    AppMethodBeat.o(152300);
    return paramContext;
  }
  
  public static SpannableString e(Context paramContext, CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(192697);
    paramContext = new q(paramContext);
    paramContext.DDa = false;
    paramContext.DCW = true;
    paramContext.DCX = false;
    paramContext.DCZ = DCv;
    paramContext.DDi = false;
    paramContext.DDm = 1;
    paramContext.DDb = true;
    paramContext.DDe = false;
    paramContext.DDo = true;
    paramContext.DDc = false;
    paramContext.DDf = false;
    paramContext = paramContext.b(paramCharSequence, paramInt, true);
    AppMethodBeat.o(192697);
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
    AppMethodBeat.i(152299);
    paramContext = b(paramContext, paramCharSequence, paramInt, true);
    AppMethodBeat.o(152299);
    return paramContext;
  }
  
  public static SpannableString g(Context paramContext, CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(152307);
    paramContext = new q(paramContext);
    paramContext.DDa = false;
    paramContext.DCW = true;
    paramContext.DCX = true;
    paramContext.DCY = false;
    paramContext.DDg = false;
    paramContext.DDh = false;
    paramContext.DDi = false;
    paramContext.DDm = 1;
    paramContext.DDb = false;
    paramContext.DDe = false;
    paramContext.DDc = false;
    paramContext.DDf = false;
    paramContext.DDo = true;
    paramContext = paramContext.b(paramCharSequence, paramInt, true);
    AppMethodBeat.o(152307);
    return paramContext;
  }
  
  public static SpannableString m(TextView paramTextView, int paramInt)
  {
    AppMethodBeat.i(152280);
    if (paramTextView == null)
    {
      ac.e("MicroMsg.MMSpanManager", "spanForTextView, textView cannot be null!");
      paramTextView = new SpannableString("");
      AppMethodBeat.o(152280);
      return paramTextView;
    }
    Object localObject = paramTextView.getContext();
    int i = (int)paramTextView.getTextSize();
    localObject = new q((Context)localObject);
    ((q)localObject).DDa = true;
    ((q)localObject).DCW = true;
    ((q)localObject).DCX = true;
    ((q)localObject).DCZ = DCv;
    ((q)localObject).DDm = paramInt;
    ((q)localObject).DDb = true;
    ((q)localObject).DDe = false;
    ((q)localObject).DDo = true;
    localObject = ((q)localObject).w(paramTextView);
    if (paramInt == 1)
    {
      ((q)localObject).DDc = true;
      ((q)localObject).DDf = true;
    }
    for (;;)
    {
      paramTextView = ((q)localObject).b(paramTextView.getText(), i, true);
      AppMethodBeat.o(152280);
      return paramTextView;
      if (paramInt == 2)
      {
        ((q)localObject).DDc = false;
        ((q)localObject).DDf = false;
      }
    }
  }
  
  public static SpannableString v(TextView paramTextView)
  {
    AppMethodBeat.i(152304);
    if (paramTextView == null)
    {
      ac.e("MicroMsg.MMSpanManager", "spanForTextView, textView cannot be null!");
      paramTextView = new SpannableString("");
      AppMethodBeat.o(152304);
      return paramTextView;
    }
    Object localObject = paramTextView.getContext();
    int i = (int)paramTextView.getTextSize();
    localObject = new q((Context)localObject);
    ((q)localObject).DDa = false;
    ((q)localObject).DCW = false;
    ((q)localObject).DCX = false;
    ((q)localObject).DCZ = false;
    ((q)localObject).DDb = false;
    ((q)localObject).DDe = false;
    ((q)localObject).DDo = true;
    localObject = ((q)localObject).w(paramTextView);
    ((q)localObject).DDc = false;
    ((q)localObject).DDf = false;
    paramTextView = ((q)localObject).b(paramTextView.getText(), i, false);
    AppMethodBeat.o(152304);
    return paramTextView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.span.k
 * JD-Core Version:    0.7.0.1
 */