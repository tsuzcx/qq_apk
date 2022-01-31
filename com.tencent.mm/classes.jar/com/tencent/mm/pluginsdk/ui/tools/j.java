package com.tencent.mm.pluginsdk.ui.tools;

import android.annotation.TargetApi;
import android.widget.ListView;
import com.tencent.mm.sdk.platformtools.y;

@TargetApi(11)
public final class j
{
  public static void a(ListView paramListView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramListView == null) {
      return;
    }
    y.i("MicroMsg.ChattingUI.ScrollController", "setSelectionFromTop position %s smooth %s", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean) });
    paramListView.setItemChecked(paramInt1, true);
    paramListView.setSelectionFromTop(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.j
 * JD-Core Version:    0.7.0.1
 */