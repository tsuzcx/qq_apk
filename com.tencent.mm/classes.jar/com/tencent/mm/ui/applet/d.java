package com.tencent.mm.ui.applet;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

public final class d
{
  private static int zgX = 0;
  
  public static void ic(Context paramContext)
  {
    AppMethodBeat.i(29988);
    if (zgX > 0)
    {
      AppMethodBeat.o(29988);
      return;
    }
    paramContext = new d.a(paramContext, LayoutInflater.from(paramContext).inflate(2130971035, null));
    paramContext.zgF.addView(paramContext.zgE, paramContext.zgG);
    zgX += 1;
    AppMethodBeat.o(29988);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.applet.d
 * JD-Core Version:    0.7.0.1
 */