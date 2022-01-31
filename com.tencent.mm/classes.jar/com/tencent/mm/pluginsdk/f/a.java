package com.tencent.mm.pluginsdk.f;

import android.content.ClipData;
import android.content.Context;
import android.os.Build.VERSION;

public final class a
{
  public static void a(Context paramContext, CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      new b();
      ((android.content.ClipboardManager)paramContext.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(paramCharSequence1, paramCharSequence2));
      return;
    }
    new c();
    ((android.text.ClipboardManager)paramContext.getSystemService("clipboard")).setText(paramCharSequence2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.f.a
 * JD-Core Version:    0.7.0.1
 */