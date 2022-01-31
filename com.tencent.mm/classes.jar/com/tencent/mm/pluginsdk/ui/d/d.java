package com.tencent.mm.pluginsdk.ui.d;

import android.text.SpannableString;

public abstract interface d
{
  public abstract SpannableString g(CharSequence paramCharSequence, int paramInt);
  
  public abstract boolean v(CharSequence paramCharSequence);
  
  public abstract boolean w(CharSequence paramCharSequence);
  
  public static final class a
  {
    protected static d sjp;
    
    public static final void a(d paramd)
    {
      sjp = paramd;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.d.d
 * JD-Core Version:    0.7.0.1
 */