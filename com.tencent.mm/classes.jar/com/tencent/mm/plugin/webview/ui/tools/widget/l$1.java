package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class l$1
  extends m
{
  l$1(l paraml) {}
  
  public final void af(Bundle paramBundle)
  {
    AppMethodBeat.i(10022);
    if (((this.vsM.vsK instanceof e)) && (((e)this.vsM.vsK).abM()))
    {
      AppMethodBeat.o(10022);
      return;
    }
    super.af(paramBundle);
    AppMethodBeat.o(10022);
  }
  
  public final boolean e(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(10021);
    if (this.vsM.vsK != null)
    {
      bool = this.vsM.vsK.e(paramInt, paramBundle);
      AppMethodBeat.o(10021);
      return bool;
    }
    boolean bool = super.e(paramInt, paramBundle);
    AppMethodBeat.o(10021);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.l.1
 * JD-Core Version:    0.7.0.1
 */