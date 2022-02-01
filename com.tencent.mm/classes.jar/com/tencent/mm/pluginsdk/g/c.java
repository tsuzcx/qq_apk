package com.tencent.mm.pluginsdk.g;

import android.content.Context;
import android.text.ClipboardManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ai;

final class c
{
  public static void S(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(151891);
    ((ClipboardManager)ai.getContext().getSystemService("clipboard")).setText(paramCharSequence);
    AppMethodBeat.o(151891);
  }
  
  public static CharSequence eLv()
  {
    AppMethodBeat.i(151892);
    CharSequence localCharSequence = ((ClipboardManager)ai.getContext().getSystemService("clipboard")).getText();
    AppMethodBeat.o(151892);
    return localCharSequence;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.c
 * JD-Core Version:    0.7.0.1
 */