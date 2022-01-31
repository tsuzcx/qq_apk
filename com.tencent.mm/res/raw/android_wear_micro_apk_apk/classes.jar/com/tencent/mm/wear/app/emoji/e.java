package com.tencent.mm.wear.app.emoji;

import android.content.Context;
import android.text.SpannableString;
import com.tencent.mm.sdk.platformtools.q;

public final class e
{
  static int abV = 0;
  private static e abW;
  
  public static SpannableString a(Context paramContext, CharSequence paramCharSequence, int paramInt)
  {
    if ((paramCharSequence == null) || (q.D(paramCharSequence.toString()))) {
      return new SpannableString("");
    }
    if (a.mw() == null) {
      return new SpannableString(paramCharSequence);
    }
    if ((paramCharSequence == null) || (q.D(paramCharSequence.toString()))) {
      return new SpannableString("");
    }
    abV = com.tencent.mm.f.a.x(paramContext);
    if ((paramCharSequence instanceof SpannableString)) {}
    for (paramCharSequence = (SpannableString)paramCharSequence;; paramCharSequence = new SpannableString(paramCharSequence))
    {
      paramCharSequence = a.mw().a(paramCharSequence, paramInt);
      c.mA().a(paramContext, paramCharSequence, paramInt);
      return paramCharSequence;
    }
  }
  
  public static e mB()
  {
    if (abW == null) {
      abW = new e();
    }
    return abW;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.emoji.e
 * JD-Core Version:    0.7.0.1
 */