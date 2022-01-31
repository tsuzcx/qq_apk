package com.tencent.mm.pluginsdk.f;

import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;

final class b
{
  @TargetApi(11)
  public static void b(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    AppMethodBeat.i(79448);
    ((ClipboardManager)ah.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(paramCharSequence1, paramCharSequence2));
    AppMethodBeat.o(79448);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.f.b
 * JD-Core Version:    0.7.0.1
 */