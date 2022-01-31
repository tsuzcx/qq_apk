package com.tencent.mm.pluginsdk.ui.tools;

import android.annotation.TargetApi;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

@TargetApi(11)
public final class k
{
  public static void a(ListView paramListView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(105869);
    if (paramListView == null)
    {
      AppMethodBeat.o(105869);
      return;
    }
    ab.i("MicroMsg.ChattingUI.ScrollController", "setSelectionFromTop position %s smooth %s", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean) });
    paramListView.setItemChecked(paramInt1, true);
    paramListView.setSelectionFromTop(paramInt1, paramInt2);
    AppMethodBeat.o(105869);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.k
 * JD-Core Version:    0.7.0.1
 */