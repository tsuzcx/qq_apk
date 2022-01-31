package com.tencent.mm.pluginsdk.f;

import android.content.Context;
import android.text.ClipboardManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;

final class c
{
  public static void L(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(79449);
    ((ClipboardManager)ah.getContext().getSystemService("clipboard")).setText(paramCharSequence);
    AppMethodBeat.o(79449);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.f.c
 * JD-Core Version:    0.7.0.1
 */