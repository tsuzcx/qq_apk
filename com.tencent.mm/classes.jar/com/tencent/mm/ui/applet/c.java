package com.tencent.mm.ui.applet;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.tencent.mm.R.i;
import com.tencent.mm.ch.b;

public final class c
{
  public static void gF(Context paramContext)
  {
    paramContext = new c.a(paramContext, LayoutInflater.from(paramContext).inflate(R.i.trace_view, null));
    paramContext.uSe.addView(paramContext.uSd, paramContext.uSf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.applet.c
 * JD-Core Version:    0.7.0.1
 */