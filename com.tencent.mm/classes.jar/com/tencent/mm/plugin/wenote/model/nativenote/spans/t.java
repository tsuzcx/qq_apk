package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.text.Spannable;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.e;
import java.util.ArrayList;

public abstract class t<V, C extends g<V>>
{
  protected static boolean d(int paramInt, int... paramVarArgs)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < 2)
      {
        int j = paramVarArgs[i];
        if ((paramInt & j) == j) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      i += 1;
    }
  }
  
  protected abstract ArrayList<Object> a(Spannable paramSpannable, e parame, s params);
  
  public abstract void a(WXRTEditText paramWXRTEditText, V paramV);
  
  public abstract int ciY();
  
  protected abstract e p(WXRTEditText paramWXRTEditText);
  
  public final boolean q(WXRTEditText paramWXRTEditText)
  {
    e locale = p(paramWXRTEditText);
    return !a(paramWXRTEditText.getText(), locale, s.rKW).isEmpty();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.spans.t
 * JD-Core Version:    0.7.0.1
 */