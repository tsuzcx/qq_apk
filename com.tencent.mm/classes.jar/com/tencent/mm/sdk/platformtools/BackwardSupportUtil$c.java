package com.tencent.mm.sdk.platformtools;

import android.os.Build.VERSION;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;

public final class BackwardSupportUtil$c
{
  public static void b(ListView paramListView)
  {
    AppMethodBeat.i(156073);
    if (paramListView == null)
    {
      AppMethodBeat.o(156073);
      return;
    }
    if (Build.VERSION.SDK_INT >= 8)
    {
      new bn();
      bn.c(paramListView);
      AppMethodBeat.o(156073);
      return;
    }
    new bm();
    paramListView.setSelection(0);
    AppMethodBeat.o(156073);
  }
  
  public static void b(ListView paramListView, int paramInt)
  {
    AppMethodBeat.i(156074);
    if (paramListView == null)
    {
      AppMethodBeat.o(156074);
      return;
    }
    if (Build.VERSION.SDK_INT >= 8)
    {
      new bn();
      bn.d(paramListView, paramInt);
      AppMethodBeat.o(156074);
      return;
    }
    new bm();
    paramListView.setSelection(paramInt);
    AppMethodBeat.o(156074);
  }
  
  public static void c(ListView paramListView, int paramInt)
  {
    AppMethodBeat.i(156075);
    if (paramListView == null)
    {
      AppMethodBeat.o(156075);
      return;
    }
    if (Build.VERSION.SDK_INT >= 11)
    {
      new bn();
      int i = paramListView.getFirstVisiblePosition();
      if ((i < paramInt) && (i + 10 < paramInt)) {
        paramListView.setSelectionFromTop(paramInt - 10, 0);
      }
      for (;;)
      {
        if (Build.VERSION.SDK_INT >= 11)
        {
          com.tencent.mm.hellhoundlib.b.a locala = c.a(paramInt, c.a(0, new com.tencent.mm.hellhoundlib.b.a()));
          com.tencent.mm.hellhoundlib.a.a.a(paramListView, locala.adn(), "com/tencent/mm/sdk/platformtools/SmoothScrollToPosition22", "doScrollFromTop", "(Landroid/widget/ListView;I)V", "Undefined", "smoothScrollToPositionFromTop", "(II)V");
          paramListView.smoothScrollToPositionFromTop(((Integer)locala.lS(0)).intValue(), ((Integer)locala.lS(1)).intValue());
          com.tencent.mm.hellhoundlib.a.a.a(paramListView, "com/tencent/mm/sdk/platformtools/SmoothScrollToPosition22", "doScrollFromTop", "(Landroid/widget/ListView;I)V", "Undefined", "smoothScrollToPositionFromTop", "(II)V");
        }
        AppMethodBeat.o(156075);
        return;
        if ((i > paramInt) && (i - 10 > paramInt)) {
          paramListView.setSelectionFromTop(paramInt + 10, 0);
        }
      }
    }
    new bm();
    paramListView.setSelectionFromTop(paramInt, 0);
    AppMethodBeat.o(156075);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c
 * JD-Core Version:    0.7.0.1
 */