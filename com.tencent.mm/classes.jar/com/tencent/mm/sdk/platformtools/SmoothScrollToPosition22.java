package com.tencent.mm.sdk.platformtools;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;

class SmoothScrollToPosition22
  implements BackwardSupportUtil.SmoothScrollFactory.IScroll
{
  private static final int SCROLL_UNIT = 10;
  private byte _hellAccFlag_;
  
  @TargetApi(8)
  public void doScroll(ListView paramListView)
  {
    AppMethodBeat.i(156352);
    if (paramListView.getFirstVisiblePosition() > 10) {
      paramListView.setSelection(10);
    }
    if (Build.VERSION.SDK_INT >= 8)
    {
      com.tencent.mm.hellhoundlib.b.a locala = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(paramListView, locala.axQ(), "com/tencent/mm/sdk/platformtools/SmoothScrollToPosition22", "doScroll", "(Landroid/widget/ListView;)V", "Undefined", "smoothScrollToPosition", "(I)V");
      paramListView.smoothScrollToPosition(((Integer)locala.pG(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(paramListView, "com/tencent/mm/sdk/platformtools/SmoothScrollToPosition22", "doScroll", "(Landroid/widget/ListView;)V", "Undefined", "smoothScrollToPosition", "(I)V");
    }
    AppMethodBeat.o(156352);
  }
  
  @TargetApi(8)
  public void doScroll(ListView paramListView, int paramInt)
  {
    AppMethodBeat.i(156353);
    int i = paramListView.getFirstVisiblePosition();
    if ((i > paramInt) && (i - paramInt > 10)) {
      paramListView.setSelection(paramInt + 10);
    }
    for (;;)
    {
      if (Build.VERSION.SDK_INT >= 8)
      {
        com.tencent.mm.hellhoundlib.b.a locala = c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(paramListView, locala.axQ(), "com/tencent/mm/sdk/platformtools/SmoothScrollToPosition22", "doScroll", "(Landroid/widget/ListView;I)V", "Undefined", "smoothScrollToPosition", "(I)V");
        paramListView.smoothScrollToPosition(((Integer)locala.pG(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(paramListView, "com/tencent/mm/sdk/platformtools/SmoothScrollToPosition22", "doScroll", "(Landroid/widget/ListView;I)V", "Undefined", "smoothScrollToPosition", "(I)V");
      }
      AppMethodBeat.o(156353);
      return;
      if ((i < paramInt) && (paramInt - i > 10)) {
        paramListView.setSelection(paramInt - 10);
      }
    }
  }
  
  @TargetApi(11)
  public void doScrollFromTop(ListView paramListView, int paramInt)
  {
    AppMethodBeat.i(215440);
    paramListView.getFirstVisiblePosition();
    paramListView.setSelection(paramInt);
    AppMethodBeat.o(215440);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.SmoothScrollToPosition22
 * JD-Core Version:    0.7.0.1
 */