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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.widget.a;
import java.util.LinkedList;

public final class k
{
  private static boolean FAa;
  static LinkedList<h> FzZ;
  
  static
  {
    AppMethodBeat.i(152309);
    FzZ = new LinkedList();
    FAa = bu.jq(ak.getContext());
    AppMethodBeat.o(152309);
  }
  
  private static SpannableString a(Context paramContext, TextView paramTextView, int paramInt, boolean paramBoolean, Object paramObject)
  {
    AppMethodBeat.i(152286);
    paramContext = new q(paramContext);
    paramContext.FAE = true;
    paramContext.FAA = true;
    paramContext.FAB = true;
    paramContext.FAK = true;
    paramContext.FAM = true;
    paramContext.FAQ = 1;
    paramContext.FAF = true;
    paramContext.FAI = false;
    paramContext.FAT = true;
    paramContext = paramContext.u(paramTextView);
    paramContext.FAG = true;
    paramContext.FAJ = true;
    if (paramObject != null) {
      paramContext.FAU = paramObject;
    }
    paramContext = paramContext.b(paramTextView.getText(), paramInt, paramBoolean);
    AppMethodBeat.o(152286);
    return paramContext;
  }
  
  public static SpannableString a(Context paramContext, CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(152284);
    paramContext = new q(paramContext);
    paramContext.FAE = true;
    paramContext.FAA = true;
    paramContext.FAB = true;
    paramContext.FAD = FAa;
    paramContext.FAQ = 1;
    paramContext.FAF = true;
    paramContext.FAI = false;
    paramContext.FAT = false;
    paramContext = paramContext.u(null);
    paramContext.FAU = null;
    paramContext.mSessionId = null;
    paramContext.FAG = true;
    paramContext.FAJ = true;
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
    paramContext.FAE = true;
    paramContext.FAA = true;
    paramContext.FAB = true;
    paramContext.FAD = FAa;
    paramContext.FAM = true;
    paramContext.FAQ = paramInt2;
    paramContext.FAF = true;
    paramContext.FAI = false;
    paramContext.FAT = true;
    paramContext.FAU = paramObject;
    paramContext.FAP = paramBoolean;
    if (paramInt2 == 1)
    {
      paramContext.FAG = true;
      paramContext.FAJ = true;
    }
    for (;;)
    {
      paramContext = paramContext.b(paramCharSequence, paramInt1, false);
      AppMethodBeat.o(162013);
      return paramContext;
      if (paramInt2 == 2)
      {
        paramContext.FAG = false;
        paramContext.FAJ = false;
      }
    }
  }
  
  public static SpannableString a(Context paramContext, CharSequence paramCharSequence, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(152294);
    paramContext = new q(paramContext);
    paramContext.FAE = true;
    paramContext.FAA = true;
    paramContext.FAB = true;
    paramContext.FAD = FAa;
    paramContext.FAQ = paramInt2;
    paramContext.FAF = true;
    paramContext.FAI = false;
    paramContext.FAT = true;
    if (paramInt2 == 1)
    {
      paramContext.FAG = true;
      paramContext.FAJ = true;
    }
    for (;;)
    {
      paramContext = paramContext.b(paramCharSequence, paramInt1, true);
      AppMethodBeat.o(152294);
      return paramContext;
      if (paramInt2 == 2)
      {
        paramContext.FAG = false;
        paramContext.FAJ = false;
        paramContext.FAO = paramBoolean;
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
    paramContext.FAA = false;
    paramContext = paramContext.b(paramCharSequence, paramInt, true);
    AppMethodBeat.o(152283);
    return paramContext;
  }
  
  private static SpannableString a(Context paramContext, CharSequence paramCharSequence, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(152293);
    paramContext = new q(paramContext);
    paramContext.FAF = false;
    paramContext.FAG = false;
    paramContext.FAA = false;
    paramContext.FAB = false;
    paramContext.FAI = false;
    paramContext.FAE = false;
    paramContext.FAT = false;
    paramContext = paramContext.b(paramCharSequence, paramInt, paramBoolean);
    e(paramContext);
    AppMethodBeat.o(152293);
    return paramContext;
  }
  
  public static SpannableString a(Context paramContext, CharSequence paramCharSequence, int paramInt, boolean paramBoolean, Object paramObject)
  {
    AppMethodBeat.i(152277);
    paramContext = new q(paramContext);
    paramContext.FAK = true;
    paramContext.FAA = true;
    paramContext.FAM = true;
    paramContext.FAQ = 1;
    paramContext.FAI = false;
    paramContext.FAT = true;
    paramContext = paramContext.u(null);
    paramContext.FAG = true;
    paramContext.FAJ = true;
    if (paramObject != null) {
      paramContext.FAU = paramObject;
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
      ae.e("MicroMsg.MMSpanManager", "spanForTextView, textView cannot be null!");
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
    paramContext.FAE = true;
    paramContext.FAA = true;
    paramContext.FAB = true;
    paramContext.FAD = FAa;
    paramContext.FAQ = paramInt;
    paramContext.FAF = true;
    paramContext.FAI = false;
    paramContext.FAT = true;
    paramContext = paramContext.u(null);
    paramContext.FAU = paramObject;
    paramContext.mSessionId = paramString;
    if ((paramInt == 1) || (paramInt == 4))
    {
      paramContext.FAG = true;
      paramContext.FAJ = true;
    }
    for (;;)
    {
      if ("zh_CN".equals(ad.iR(ak.getContext()))) {
        paramContext.FAH = true;
      }
      AppMethodBeat.o(152285);
      return paramContext;
      if (paramInt == 2)
      {
        paramContext.FAG = false;
        paramContext.FAJ = false;
      }
    }
  }
  
  public static void a(h paramh)
  {
    AppMethodBeat.i(152275);
    FzZ.add(paramh);
    AppMethodBeat.o(152275);
  }
  
  public static String aOF(String paramString)
  {
    AppMethodBeat.i(152302);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(152302);
      return paramString;
    }
    q localq = new q(ak.getContext());
    localq.FAE = false;
    localq.FAA = true;
    localq.FAB = true;
    localq.FAK = true;
    localq.FAL = true;
    localq.FAM = true;
    localq.FAQ = 1;
    localq.FAF = false;
    localq.FAI = false;
    localq.FAG = false;
    localq.FAJ = false;
    localq.FAN = false;
    localq.FAT = false;
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
    paramContext.FAE = false;
    paramContext.FAA = true;
    paramContext.FAB = true;
    paramContext.FAK = true;
    paramContext.FAL = paramBoolean;
    paramContext.FAM = true;
    paramContext.FAQ = 1;
    paramContext.FAF = false;
    paramContext.FAI = false;
    paramContext.FAG = false;
    paramContext.FAJ = false;
    paramContext.FAT = false;
    paramContext = paramContext.b(paramCharSequence, paramInt, true);
    AppMethodBeat.o(152301);
    return paramContext;
  }
  
  public static SpannableString b(TextView paramTextView, Object paramObject)
  {
    AppMethodBeat.i(152281);
    if (paramTextView == null)
    {
      ae.e("MicroMsg.MMSpanManager", "spanForTextView, textView cannot be null!");
      paramTextView = new SpannableString("");
      AppMethodBeat.o(152281);
      return paramTextView;
    }
    Object localObject = paramTextView.getContext();
    int i = (int)paramTextView.getTextSize();
    localObject = new q((Context)localObject);
    ((q)localObject).FAE = true;
    ((q)localObject).FAA = true;
    ((q)localObject).FAB = true;
    ((q)localObject).FAD = FAa;
    ((q)localObject).FAQ = 1;
    ((q)localObject).FAF = true;
    ((q)localObject).FAI = false;
    ((q)localObject).FAT = true;
    localObject = ((q)localObject).u(paramTextView);
    ((q)localObject).FAU = paramObject;
    ((q)localObject).mSessionId = null;
    ((q)localObject).FAG = true;
    ((q)localObject).FAJ = true;
    paramTextView = ((q)localObject).b(paramTextView.getText(), i, true);
    AppMethodBeat.o(152281);
    return paramTextView;
  }
  
  public static void b(h paramh)
  {
    AppMethodBeat.i(152276);
    FzZ.remove(paramh);
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
    paramContext.FAF = false;
    paramContext.FAG = false;
    paramContext.FAA = false;
    paramContext.FAB = false;
    paramContext.FAI = false;
    paramContext.FAQ = paramInt;
    paramContext.FAE = false;
    paramContext.FAT = false;
    paramContext = paramContext.b(paramCharSequence, 0, true);
    e(paramContext);
    AppMethodBeat.o(152290);
    return paramContext;
  }
  
  public static void clearCache()
  {
    AppMethodBeat.i(152303);
    ae.i("MicroMsg.MMSpanManager", "clear MMSpanManager cache");
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
    paramContext.FAE = true;
    paramContext.FAA = true;
    paramContext.FAB = true;
    paramContext.FAD = FAa;
    paramContext.FAM = true;
    paramContext.FAQ = 1;
    paramContext.FAF = true;
    paramContext.FAI = false;
    paramContext.FAT = true;
    paramContext.FAU = null;
    paramContext.FAG = true;
    paramContext.FAJ = true;
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
    AppMethodBeat.i(218903);
    paramContext = new q(paramContext);
    paramContext.FAE = false;
    paramContext.FAA = true;
    paramContext.FAB = false;
    paramContext.FAD = FAa;
    paramContext.FAM = false;
    paramContext.FAQ = 1;
    paramContext.FAF = true;
    paramContext.FAI = false;
    paramContext.FAT = true;
    paramContext.FAG = false;
    paramContext.FAJ = false;
    paramContext = paramContext.b(paramCharSequence, paramInt, true);
    AppMethodBeat.o(218903);
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
    AppMethodBeat.i(152299);
    paramContext = b(paramContext, paramCharSequence, paramInt, true);
    AppMethodBeat.o(152299);
    return paramContext;
  }
  
  public static SpannableString g(Context paramContext, CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(152307);
    paramContext = new q(paramContext);
    paramContext.FAE = false;
    paramContext.FAA = true;
    paramContext.FAB = true;
    paramContext.FAC = false;
    paramContext.FAK = false;
    paramContext.FAL = false;
    paramContext.FAM = false;
    paramContext.FAQ = 1;
    paramContext.FAF = false;
    paramContext.FAI = false;
    paramContext.FAG = false;
    paramContext.FAJ = false;
    paramContext.FAT = true;
    paramContext = paramContext.b(paramCharSequence, paramInt, true);
    AppMethodBeat.o(152307);
    return paramContext;
  }
  
  public static SpannableString o(TextView paramTextView, int paramInt)
  {
    AppMethodBeat.i(152280);
    if (paramTextView == null)
    {
      ae.e("MicroMsg.MMSpanManager", "spanForTextView, textView cannot be null!");
      paramTextView = new SpannableString("");
      AppMethodBeat.o(152280);
      return paramTextView;
    }
    Object localObject = paramTextView.getContext();
    int i = (int)paramTextView.getTextSize();
    localObject = new q((Context)localObject);
    ((q)localObject).FAE = true;
    ((q)localObject).FAA = true;
    ((q)localObject).FAB = true;
    ((q)localObject).FAD = FAa;
    ((q)localObject).FAQ = paramInt;
    ((q)localObject).FAF = true;
    ((q)localObject).FAI = false;
    ((q)localObject).FAT = true;
    localObject = ((q)localObject).u(paramTextView);
    if (paramInt == 1)
    {
      ((q)localObject).FAG = true;
      ((q)localObject).FAJ = true;
    }
    for (;;)
    {
      paramTextView = ((q)localObject).b(paramTextView.getText(), i, true);
      AppMethodBeat.o(152280);
      return paramTextView;
      if (paramInt == 2)
      {
        ((q)localObject).FAG = false;
        ((q)localObject).FAJ = false;
      }
    }
  }
  
  public static SpannableString t(TextView paramTextView)
  {
    AppMethodBeat.i(152304);
    if (paramTextView == null)
    {
      ae.e("MicroMsg.MMSpanManager", "spanForTextView, textView cannot be null!");
      paramTextView = new SpannableString("");
      AppMethodBeat.o(152304);
      return paramTextView;
    }
    Object localObject = paramTextView.getContext();
    int i = (int)paramTextView.getTextSize();
    localObject = new q((Context)localObject);
    ((q)localObject).FAE = false;
    ((q)localObject).FAA = false;
    ((q)localObject).FAB = false;
    ((q)localObject).FAD = false;
    ((q)localObject).FAF = false;
    ((q)localObject).FAI = false;
    ((q)localObject).FAT = true;
    localObject = ((q)localObject).u(paramTextView);
    ((q)localObject).FAG = false;
    ((q)localObject).FAJ = false;
    paramTextView = ((q)localObject).b(paramTextView.getText(), i, false);
    AppMethodBeat.o(152304);
    return paramTextView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.span.k
 * JD-Core Version:    0.7.0.1
 */