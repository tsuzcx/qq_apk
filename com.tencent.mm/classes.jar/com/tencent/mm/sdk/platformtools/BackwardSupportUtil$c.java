package com.tencent.mm.sdk.platformtools;

import android.os.Build.VERSION;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;

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
      bn.c(paramListView, paramInt);
      AppMethodBeat.o(156074);
      return;
    }
    new bm();
    paramListView.setSelection(paramInt);
    AppMethodBeat.o(156074);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c
 * JD-Core Version:    0.7.0.1
 */