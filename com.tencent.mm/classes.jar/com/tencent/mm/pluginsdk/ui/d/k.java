package com.tencent.mm.pluginsdk.ui.d;

import android.text.GetChars;
import android.text.Spannable;
import android.text.SpannableString;

public final class k
  implements GetChars, Spannable, CharSequence
{
  private SpannableString sjJ = null;
  
  public k()
  {
    this.sjJ = new SpannableString("");
  }
  
  public k(SpannableString paramSpannableString)
  {
    this.sjJ = paramSpannableString;
  }
  
  public k(CharSequence paramCharSequence)
  {
    this.sjJ = new SpannableString(paramCharSequence);
  }
  
  public k(String paramString)
  {
    this.sjJ = new SpannableString(paramString);
  }
  
  private void a(Object paramObject, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 >= 0) && (paramInt2 <= this.sjJ.length())) {
      this.sjJ.setSpan(paramObject, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public final void a(Object paramObject, CharSequence paramCharSequence)
  {
    a(paramObject, paramCharSequence, 0);
  }
  
  public final void a(Object paramObject, CharSequence paramCharSequence, int paramInt)
  {
    a(paramObject, paramInt, paramCharSequence.length() + paramInt, 33);
  }
  
  public final char charAt(int paramInt)
  {
    return this.sjJ.charAt(paramInt);
  }
  
  public final void getChars(int paramInt1, int paramInt2, char[] paramArrayOfChar, int paramInt3)
  {
    this.sjJ.getChars(paramInt1, paramInt2, paramArrayOfChar, paramInt3);
  }
  
  public final int getSpanEnd(Object paramObject)
  {
    return this.sjJ.getSpanEnd(paramObject);
  }
  
  public final int getSpanFlags(Object paramObject)
  {
    return this.sjJ.getSpanFlags(paramObject);
  }
  
  public final int getSpanStart(Object paramObject)
  {
    return this.sjJ.getSpanStart(paramObject);
  }
  
  public final <T> T[] getSpans(int paramInt1, int paramInt2, Class<T> paramClass)
  {
    return this.sjJ.getSpans(paramInt1, paramInt2, paramClass);
  }
  
  public final int length()
  {
    return this.sjJ.length();
  }
  
  public final int nextSpanTransition(int paramInt1, int paramInt2, Class paramClass)
  {
    return this.sjJ.nextSpanTransition(paramInt1, paramInt2, paramClass);
  }
  
  public final void removeSpan(Object paramObject)
  {
    this.sjJ.removeSpan(paramObject);
  }
  
  public final void setSpan(Object paramObject, int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramObject, paramInt1, paramInt2, paramInt3);
  }
  
  public final CharSequence subSequence(int paramInt1, int paramInt2)
  {
    return this.sjJ.subSequence(paramInt1, paramInt2);
  }
  
  public final String toString()
  {
    return this.sjJ.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.d.k
 * JD-Core Version:    0.7.0.1
 */