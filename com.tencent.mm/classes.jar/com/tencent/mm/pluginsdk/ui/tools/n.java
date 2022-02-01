package com.tencent.mm.pluginsdk.ui.tools;

import android.annotation.TargetApi;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

@TargetApi(11)
public final class n
{
  public static void a(ListView paramListView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(141185);
    if (paramListView == null)
    {
      AppMethodBeat.o(141185);
      return;
    }
    ae.i("MicroMsg.ChattingUI.ScrollController", "setSelectionFromTop position %s smooth %s", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean) });
    paramListView.setItemChecked(paramInt1, true);
    paramListView.setSelectionFromTop(paramInt1, paramInt2);
    AppMethodBeat.o(141185);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.n
 * JD-Core Version:    0.7.0.1
 */