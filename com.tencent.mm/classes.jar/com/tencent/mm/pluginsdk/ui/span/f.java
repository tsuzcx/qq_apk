package com.tencent.mm.pluginsdk.ui.span;

import android.content.Context;
import android.text.SpannableString;

public abstract interface f
{
  public abstract boolean M(CharSequence paramCharSequence);
  
  public abstract boolean N(CharSequence paramCharSequence);
  
  public abstract SpannableString b(Context paramContext, CharSequence paramCharSequence, int paramInt);
  
  public static final class a
  {
    protected static f KqF;
    
    public static final void a(f paramf)
    {
      KqF = paramf;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.span.f
 * JD-Core Version:    0.7.0.1
 */