package com.tencent.mm.ui.applet;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.b;

public final class c
{
  public static void ib(Context paramContext)
  {
    AppMethodBeat.i(29978);
    new c.a(paramContext, LayoutInflater.from(paramContext).inflate(2130971035, null)).show();
    AppMethodBeat.o(29978);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.applet.c
 * JD-Core Version:    0.7.0.1
 */