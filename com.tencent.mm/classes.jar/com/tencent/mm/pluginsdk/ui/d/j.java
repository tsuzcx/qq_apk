package com.tencent.mm.pluginsdk.ui.d;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ClickableSpan;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.a;
import java.util.LinkedList;

public final class j
{
  static LinkedList<g> sjH = new LinkedList();
  private static boolean sjI = bk.fV(ae.getContext());
  
  public static String WQ(String paramString)
  {
    if (bk.bl(paramString)) {
      return paramString;
    }
    p localp = new p(ae.getContext());
    localp.sko = false;
    localp.skm = true;
    localp.skt = true;
    localp.sku = true;
    localp.skv = true;
    localp.skx = 1;
    localp.skp = false;
    localp.skr = false;
    localp.skq = false;
    localp.sks = false;
    localp.skw = false;
    localp.skz = false;
    return localp.a(paramString, 0, false).toString();
  }
  
  public static SpannableString a(Context paramContext, CharSequence paramCharSequence, float paramFloat)
  {
    return a(paramContext, paramCharSequence, (int)paramFloat, true);
  }
  
  public static SpannableString a(Context paramContext, CharSequence paramCharSequence, int paramInt)
  {
    paramContext = new p(paramContext);
    paramContext.sko = true;
    paramContext.skm = true;
    paramContext.skn = sjI;
    paramContext.skx = 1;
    paramContext.skp = true;
    paramContext.skr = false;
    paramContext.skz = false;
    paramContext = paramContext.i(null);
    paramContext.skA = null;
    paramContext.fKV = null;
    paramContext.skq = true;
    paramContext.sks = true;
    return paramContext.a(paramCharSequence, paramInt, true);
  }
  
  public static SpannableString a(Context paramContext, CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    paramContext = new p(paramContext);
    paramContext.sko = true;
    paramContext.skm = true;
    paramContext.skn = sjI;
    paramContext.skx = paramInt2;
    paramContext.skp = true;
    paramContext.skr = false;
    paramContext.skz = true;
    if (paramInt2 == 1)
    {
      paramContext.skq = true;
      paramContext.sks = true;
    }
    for (;;)
    {
      return paramContext.a(paramCharSequence, paramInt1, true);
      if (paramInt2 == 2)
      {
        paramContext.skq = false;
        paramContext.sks = false;
      }
    }
  }
  
  public static SpannableString a(Context paramContext, CharSequence paramCharSequence, int paramInt, Object paramObject)
  {
    paramContext = new p(paramContext);
    paramContext.sko = true;
    paramContext.skm = true;
    paramContext.skn = sjI;
    paramContext.skv = true;
    paramContext.skx = 1;
    paramContext.skp = true;
    paramContext.skr = false;
    paramContext.skz = true;
    paramContext.skA = paramObject;
    paramContext.skq = true;
    paramContext.sks = true;
    return paramContext.a(paramCharSequence, paramInt, false);
  }
  
  public static SpannableString a(Context paramContext, CharSequence paramCharSequence, int paramInt, Object paramObject, String paramString)
  {
    paramContext = new p(paramContext);
    paramContext.sko = true;
    paramContext.skm = true;
    paramContext.skn = sjI;
    paramContext.skx = 1;
    paramContext.skp = true;
    paramContext.skr = false;
    paramContext.skz = true;
    paramContext = paramContext.i(null);
    paramContext.skA = paramObject;
    paramContext.fKV = paramString;
    paramContext.skq = true;
    paramContext.sks = true;
    return paramContext.a(paramCharSequence, paramInt, true);
  }
  
  private static SpannableString a(Context paramContext, CharSequence paramCharSequence, int paramInt, boolean paramBoolean)
  {
    paramContext = new p(paramContext);
    paramContext.skp = false;
    paramContext.skq = false;
    paramContext.skm = false;
    paramContext.skr = false;
    paramContext.sko = false;
    paramContext.skz = false;
    paramContext = paramContext.a(paramCharSequence, paramInt, paramBoolean);
    d(paramContext);
    return paramContext;
  }
  
  public static SpannableString a(TextView paramTextView, Object paramObject)
  {
    return a(paramTextView, true, paramObject);
  }
  
  public static SpannableString a(TextView paramTextView, boolean paramBoolean, Object paramObject)
  {
    if (paramTextView == null)
    {
      y.e("MicroMsg.MMSpanManager", "spanForTextView, textView cannot be null!");
      return new SpannableString("");
    }
    Object localObject = paramTextView.getContext();
    int i = (int)paramTextView.getTextSize();
    localObject = new p((Context)localObject);
    ((p)localObject).sko = true;
    ((p)localObject).skm = true;
    ((p)localObject).skt = true;
    ((p)localObject).skv = true;
    ((p)localObject).skx = 1;
    ((p)localObject).skp = true;
    ((p)localObject).skr = false;
    ((p)localObject).skz = true;
    localObject = ((p)localObject).i(paramTextView);
    ((p)localObject).skq = true;
    ((p)localObject).sks = true;
    if (paramObject != null) {
      ((p)localObject).skA = paramObject;
    }
    return ((p)localObject).a(paramTextView.getText(), i, paramBoolean);
  }
  
  public static void a(g paramg)
  {
    sjH.add(paramg);
  }
  
  public static SpannableString b(Context paramContext, CharSequence paramCharSequence)
  {
    return a(paramContext, paramCharSequence, 0, true);
  }
  
  public static SpannableString b(Context paramContext, CharSequence paramCharSequence, float paramFloat)
  {
    return a(paramContext, paramCharSequence, (int)paramFloat, false);
  }
  
  public static SpannableString b(Context paramContext, CharSequence paramCharSequence, int paramInt)
  {
    return a(paramContext, paramCharSequence, paramInt, true);
  }
  
  private static SpannableString b(Context paramContext, CharSequence paramCharSequence, int paramInt, boolean paramBoolean)
  {
    paramContext = new p(paramContext);
    paramContext.sko = false;
    paramContext.skm = true;
    paramContext.skt = true;
    paramContext.sku = paramBoolean;
    paramContext.skv = true;
    paramContext.skx = 1;
    paramContext.skp = false;
    paramContext.skr = false;
    paramContext.skq = false;
    paramContext.sks = false;
    paramContext.skz = false;
    return paramContext.a(paramCharSequence, paramInt, true);
  }
  
  public static SpannableString b(TextView paramTextView, Object paramObject)
  {
    if (paramTextView == null)
    {
      y.e("MicroMsg.MMSpanManager", "spanForTextView, textView cannot be null!");
      return new SpannableString("");
    }
    Object localObject = paramTextView.getContext();
    int i = (int)paramTextView.getTextSize();
    localObject = new p((Context)localObject);
    ((p)localObject).sko = true;
    ((p)localObject).skm = true;
    ((p)localObject).skn = sjI;
    ((p)localObject).skx = 1;
    ((p)localObject).skp = true;
    ((p)localObject).skr = false;
    ((p)localObject).skz = true;
    localObject = ((p)localObject).i(paramTextView);
    ((p)localObject).skA = paramObject;
    ((p)localObject).fKV = null;
    ((p)localObject).skq = true;
    ((p)localObject).sks = true;
    return ((p)localObject).a(paramTextView.getText(), i, true);
  }
  
  public static void b(g paramg)
  {
    sjH.remove(paramg);
  }
  
  public static SpannableString c(Context paramContext, CharSequence paramCharSequence, float paramFloat)
  {
    return b(paramContext, paramCharSequence, (int)paramFloat, false);
  }
  
  public static SpannableString c(Context paramContext, CharSequence paramCharSequence, int paramInt)
  {
    paramContext = new p(paramContext);
    paramContext.skp = false;
    paramContext.skq = false;
    paramContext.skm = false;
    paramContext.skr = false;
    paramContext.skx = paramInt;
    paramContext.sko = false;
    paramContext.skz = false;
    paramContext = paramContext.a(paramCharSequence, 0, true);
    d(paramContext);
    return paramContext;
  }
  
  public static void clearCache()
  {
    y.i("MicroMsg.MMSpanManager", "clear MMSpanManager cache");
    p.clearCache();
  }
  
  public static SpannableString d(Context paramContext, CharSequence paramCharSequence, int paramInt)
  {
    paramContext = new p(paramContext);
    paramContext.sko = true;
    paramContext.skm = true;
    paramContext.skn = sjI;
    paramContext.skv = true;
    paramContext.skx = 1;
    paramContext.skp = true;
    paramContext.skr = false;
    paramContext.skz = true;
    paramContext.skA = null;
    paramContext.skq = true;
    paramContext.sks = true;
    return paramContext.a(paramCharSequence, paramInt, true);
  }
  
  private static void d(Spannable paramSpannable)
  {
    int i = 0;
    ClickableSpan[] arrayOfClickableSpan = (ClickableSpan[])paramSpannable.getSpans(0, paramSpannable.length(), ClickableSpan.class);
    while (i < arrayOfClickableSpan.length)
    {
      paramSpannable.removeSpan(arrayOfClickableSpan[i]);
      i += 1;
    }
  }
  
  public static SpannableString e(Context paramContext, CharSequence paramCharSequence, int paramInt)
  {
    return b(paramContext, paramCharSequence, paramInt, true);
  }
  
  public static CharSequence f(Context paramContext, CharSequence paramCharSequence, int paramInt)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    localSpannableStringBuilder.append(paramCharSequence);
    int i = paramCharSequence.length();
    localSpannableStringBuilder.append(" ");
    paramContext = paramContext.getResources().getDrawable(paramInt);
    paramContext.setBounds(0, 0, paramContext.getIntrinsicWidth(), paramContext.getIntrinsicHeight());
    localSpannableStringBuilder.setSpan(new a(paramContext), i, i + 1, 18);
    return localSpannableStringBuilder;
  }
  
  public static SpannableString h(TextView paramTextView)
  {
    if (paramTextView == null)
    {
      y.e("MicroMsg.MMSpanManager", "spanForTextView, textView cannot be null!");
      return new SpannableString("");
    }
    Object localObject = paramTextView.getContext();
    int i = (int)paramTextView.getTextSize();
    localObject = new p((Context)localObject);
    ((p)localObject).sko = false;
    ((p)localObject).skm = false;
    ((p)localObject).skn = false;
    ((p)localObject).skp = false;
    ((p)localObject).skr = false;
    ((p)localObject).skz = true;
    localObject = ((p)localObject).i(paramTextView);
    ((p)localObject).skq = false;
    ((p)localObject).sks = false;
    return ((p)localObject).a(paramTextView.getText(), i, false);
  }
  
  public static SpannableString h(TextView paramTextView, int paramInt)
  {
    if (paramTextView == null)
    {
      y.e("MicroMsg.MMSpanManager", "spanForTextView, textView cannot be null!");
      return new SpannableString("");
    }
    Object localObject = paramTextView.getContext();
    int i = (int)paramTextView.getTextSize();
    localObject = new p((Context)localObject);
    ((p)localObject).sko = true;
    ((p)localObject).skm = true;
    ((p)localObject).skn = sjI;
    ((p)localObject).skx = paramInt;
    ((p)localObject).skp = true;
    ((p)localObject).skr = false;
    ((p)localObject).skz = true;
    localObject = ((p)localObject).i(paramTextView);
    if (paramInt == 1)
    {
      ((p)localObject).skq = true;
      ((p)localObject).sks = true;
    }
    for (;;)
    {
      return ((p)localObject).a(paramTextView.getText(), i, true);
      if (paramInt == 2)
      {
        ((p)localObject).skq = false;
        ((p)localObject).sks = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.d.j
 * JD-Core Version:    0.7.0.1
 */