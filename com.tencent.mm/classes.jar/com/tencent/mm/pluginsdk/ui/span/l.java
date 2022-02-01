package com.tencent.mm.pluginsdk.ui.span;

import android.text.GetChars;
import android.text.Spannable;
import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l
  implements GetChars, Spannable, CharSequence
{
  private SpannableString FAb;
  
  public l()
  {
    AppMethodBeat.i(152310);
    this.FAb = null;
    this.FAb = new SpannableString("");
    AppMethodBeat.o(152310);
  }
  
  public l(SpannableString paramSpannableString)
  {
    this.FAb = null;
    this.FAb = paramSpannableString;
  }
  
  public l(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(152311);
    this.FAb = null;
    this.FAb = new SpannableString(paramCharSequence);
    AppMethodBeat.o(152311);
  }
  
  public l(String paramString)
  {
    AppMethodBeat.i(152312);
    this.FAb = null;
    this.FAb = new SpannableString(paramString);
    AppMethodBeat.o(152312);
  }
  
  private void a(Object paramObject, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(152316);
    if ((paramInt1 >= 0) && (paramInt2 <= this.FAb.length())) {
      this.FAb.setSpan(paramObject, paramInt1, paramInt2, paramInt3);
    }
    AppMethodBeat.o(152316);
  }
  
  public final void a(Object paramObject, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(152313);
    a(paramObject, 0, paramCharSequence.length() + 0, 33);
    AppMethodBeat.o(152313);
  }
  
  public final void b(Object paramObject, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(224411);
    a(paramObject, paramCharSequence);
    AppMethodBeat.o(224411);
  }
  
  public final char charAt(int paramInt)
  {
    AppMethodBeat.i(152323);
    char c = this.FAb.charAt(paramInt);
    AppMethodBeat.o(152323);
    return c;
  }
  
  public final void getChars(int paramInt1, int paramInt2, char[] paramArrayOfChar, int paramInt3)
  {
    AppMethodBeat.i(152326);
    this.FAb.getChars(paramInt1, paramInt2, paramArrayOfChar, paramInt3);
    AppMethodBeat.o(152326);
  }
  
  public final int getSpanEnd(Object paramObject)
  {
    AppMethodBeat.i(152319);
    int i = this.FAb.getSpanEnd(paramObject);
    AppMethodBeat.o(152319);
    return i;
  }
  
  public final int getSpanFlags(Object paramObject)
  {
    AppMethodBeat.i(152320);
    int i = this.FAb.getSpanFlags(paramObject);
    AppMethodBeat.o(152320);
    return i;
  }
  
  public final int getSpanStart(Object paramObject)
  {
    AppMethodBeat.i(152318);
    int i = this.FAb.getSpanStart(paramObject);
    AppMethodBeat.o(152318);
    return i;
  }
  
  public final <T> T[] getSpans(int paramInt1, int paramInt2, Class<T> paramClass)
  {
    AppMethodBeat.i(152317);
    paramClass = this.FAb.getSpans(paramInt1, paramInt2, paramClass);
    AppMethodBeat.o(152317);
    return paramClass;
  }
  
  public final int length()
  {
    AppMethodBeat.i(152322);
    int i = this.FAb.length();
    AppMethodBeat.o(152322);
    return i;
  }
  
  public final int nextSpanTransition(int paramInt1, int paramInt2, Class paramClass)
  {
    AppMethodBeat.i(152321);
    paramInt1 = this.FAb.nextSpanTransition(paramInt1, paramInt2, paramClass);
    AppMethodBeat.o(152321);
    return paramInt1;
  }
  
  public final void removeSpan(Object paramObject)
  {
    AppMethodBeat.i(152325);
    this.FAb.removeSpan(paramObject);
    AppMethodBeat.o(152325);
  }
  
  public final void setSpan(Object paramObject, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(152315);
    a(paramObject, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(152315);
  }
  
  public final CharSequence subSequence(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(152324);
    CharSequence localCharSequence = this.FAb.subSequence(paramInt1, paramInt2);
    AppMethodBeat.o(152324);
    return localCharSequence;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(152327);
    String str = this.FAb.toString();
    AppMethodBeat.o(152327);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.span.l
 * JD-Core Version:    0.7.0.1
 */