package com.tencent.mm.pluginsdk.ui.span;

import android.text.SpannableString;

public abstract interface e
{
  public abstract boolean J(CharSequence paramCharSequence);
  
  public abstract boolean K(CharSequence paramCharSequence);
  
  public abstract SpannableString n(CharSequence paramCharSequence, int paramInt);
  
  public static final class a
  {
    protected static e DBY;
    
    public static final void a(e parame)
    {
      DBY = parame;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.span.e
 * JD-Core Version:    0.7.0.1
 */