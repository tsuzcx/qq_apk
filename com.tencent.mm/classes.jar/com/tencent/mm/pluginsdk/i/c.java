package com.tencent.mm.pluginsdk.i;

import android.content.Context;
import android.text.ClipboardManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aj;

final class c
{
  public static void R(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(151891);
    ((ClipboardManager)aj.getContext().getSystemService("clipboard")).setText(paramCharSequence);
    AppMethodBeat.o(151891);
  }
  
  public static CharSequence faq()
  {
    AppMethodBeat.i(151892);
    CharSequence localCharSequence = ((ClipboardManager)aj.getContext().getSystemService("clipboard")).getText();
    AppMethodBeat.o(151892);
    return localCharSequence;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.i.c
 * JD-Core Version:    0.7.0.1
 */