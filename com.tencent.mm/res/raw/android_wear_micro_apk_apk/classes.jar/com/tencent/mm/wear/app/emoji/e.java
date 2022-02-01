package com.tencent.mm.wear.app.emoji;

import android.content.Context;
import android.text.SpannableString;
import com.tencent.mm.sdk.platformtools.q;

public final class e
{
  static int afw = 0;
  private static e afx;
  
  public static SpannableString a(Context paramContext, CharSequence paramCharSequence, int paramInt)
  {
    if ((paramCharSequence == null) || (q.D(paramCharSequence.toString()))) {
      return new SpannableString("");
    }
    if (a.ni() == null) {
      return new SpannableString(paramCharSequence);
    }
    if ((paramCharSequence == null) || (q.D(paramCharSequence.toString()))) {
      return new SpannableString("");
    }
    afw = com.tencent.mm.f.a.y(paramContext);
    if ((paramCharSequence instanceof SpannableString)) {}
    for (paramCharSequence = (SpannableString)paramCharSequence;; paramCharSequence = new SpannableString(paramCharSequence))
    {
      paramCharSequence = a.ni().a(paramCharSequence, paramInt);
      c.nm().a(paramContext, paramCharSequence, paramInt);
      return paramCharSequence;
    }
  }
  
  public static e nn()
  {
    if (afx == null) {
      afx = new e();
    }
    return afx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.emoji.e
 * JD-Core Version:    0.7.0.1
 */