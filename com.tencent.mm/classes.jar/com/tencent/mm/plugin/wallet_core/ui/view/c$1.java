package com.tencent.mm.plugin.wallet_core.ui.view;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.v.b;
import com.tencent.mm.sdk.platformtools.d;

final class c$1
  implements v.b
{
  c$1(c paramc) {}
  
  public final Bitmap wv(String paramString)
  {
    AppMethodBeat.i(47904);
    paramString = d.decodeFile(paramString, null);
    AppMethodBeat.o(47904);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.c.1
 * JD-Core Version:    0.7.0.1
 */