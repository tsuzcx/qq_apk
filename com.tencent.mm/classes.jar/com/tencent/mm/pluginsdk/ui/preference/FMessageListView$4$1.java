package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.text.ClipboardManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.base.h.c;

final class FMessageListView$4$1
  implements h.c
{
  FMessageListView$4$1(FMessageListView.4 param4) {}
  
  public final void iA(int paramInt)
  {
    AppMethodBeat.i(28040);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(28040);
      return;
      ((ClipboardManager)ah.getContext().getSystemService("clipboard")).setText(this.waQ.waP.fjL);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.FMessageListView.4.1
 * JD-Core Version:    0.7.0.1
 */