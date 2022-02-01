package com.tencent.mm.ui.widget.happybubble;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  public static int[] eF(Context paramContext)
  {
    AppMethodBeat.i(143558);
    paramContext = (WindowManager)paramContext.getApplicationContext().getSystemService("window");
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramContext.getDefaultDisplay().getMetrics(localDisplayMetrics);
    int i = localDisplayMetrics.widthPixels;
    int j = localDisplayMetrics.heightPixels;
    AppMethodBeat.o(143558);
    return new int[] { i, j };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.happybubble.c
 * JD-Core Version:    0.7.0.1
 */