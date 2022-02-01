package com.tencent.mm.pluginsdk.ui.span;

import android.text.GetChars;
import android.text.Spannable;
import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class q
  implements GetChars, Spannable, CharSequence
{
  private SpannableString YoI;
  
  public q()
  {
    AppMethodBeat.i(152310);
    this.YoI = null;
    this.YoI = new SpannableString("");
    AppMethodBeat.o(152310);
  }
  
  public q(Spannable paramSpannable)
  {
    AppMethodBeat.i(245201);
    this.YoI = null;
    this.YoI = new SpannableString(paramSpannable);
    AppMethodBeat.o(245201);
  }
  
  public q(SpannableString paramSpannableString)
  {
    this.YoI = null;
    this.YoI = paramSpannableString;
  }
  
  public q(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(152311);
    this.YoI = null;
    this.YoI = new SpannableString(paramCharSequence);
    AppMethodBeat.o(152311);
  }
  
  public q(String paramString)
  {
    AppMethodBeat.i(152312);
    this.YoI = null;
    this.YoI = new SpannableString(paramString);
    AppMethodBeat.o(152312);
  }
  
  private void b(Object paramObject, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(152316);
    if ((paramInt1 >= 0) && (paramInt2 <= this.YoI.length())) {
      this.YoI.setSpan(paramObject, paramInt1, paramInt2, paramInt3);
    }
    AppMethodBeat.o(152316);
  }
  
  public final void a(Object paramObject, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(369598);
    a(paramObject, paramCharSequence, 0);
    AppMethodBeat.o(369598);
  }
  
  public final void a(Object paramObject, CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(245205);
    b(paramObject, paramInt, paramCharSequence.length() + paramInt, 33);
    AppMethodBeat.o(245205);
  }
  
  public final char charAt(int paramInt)
  {
    AppMethodBeat.i(152323);
    char c = this.YoI.charAt(paramInt);
    AppMethodBeat.o(152323);
    return c;
  }
  
  public final void getChars(int paramInt1, int paramInt2, char[] paramArrayOfChar, int paramInt3)
  {
    AppMethodBeat.i(152326);
    this.YoI.getChars(paramInt1, paramInt2, paramArrayOfChar, paramInt3);
    AppMethodBeat.o(152326);
  }
  
  public final int getSpanEnd(Object paramObject)
  {
    AppMethodBeat.i(152319);
    int i = this.YoI.getSpanEnd(paramObject);
    AppMethodBeat.o(152319);
    return i;
  }
  
  public final int getSpanFlags(Object paramObject)
  {
    AppMethodBeat.i(152320);
    int i = this.YoI.getSpanFlags(paramObject);
    AppMethodBeat.o(152320);
    return i;
  }
  
  public final int getSpanStart(Object paramObject)
  {
    AppMethodBeat.i(152318);
    int i = this.YoI.getSpanStart(paramObject);
    AppMethodBeat.o(152318);
    return i;
  }
  
  public final <T> T[] getSpans(int paramInt1, int paramInt2, Class<T> paramClass)
  {
    AppMethodBeat.i(152317);
    paramClass = this.YoI.getSpans(paramInt1, paramInt2, paramClass);
    AppMethodBeat.o(152317);
    return paramClass;
  }
  
  public final int length()
  {
    AppMethodBeat.i(152322);
    int i = this.YoI.length();
    AppMethodBeat.o(152322);
    return i;
  }
  
  public final int nextSpanTransition(int paramInt1, int paramInt2, Class paramClass)
  {
    AppMethodBeat.i(152321);
    paramInt1 = this.YoI.nextSpanTransition(paramInt1, paramInt2, paramClass);
    AppMethodBeat.o(152321);
    return paramInt1;
  }
  
  public final void removeSpan(Object paramObject)
  {
    AppMethodBeat.i(152325);
    this.YoI.removeSpan(paramObject);
    AppMethodBeat.o(152325);
  }
  
  public final void setSpan(Object paramObject, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(152315);
    b(paramObject, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(152315);
  }
  
  public final CharSequence subSequence(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(152324);
    CharSequence localCharSequence = this.YoI.subSequence(paramInt1, paramInt2);
    AppMethodBeat.o(152324);
    return localCharSequence;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(152327);
    String str = this.YoI.toString();
    AppMethodBeat.o(152327);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.span.q
 * JD-Core Version:    0.7.0.1
 */