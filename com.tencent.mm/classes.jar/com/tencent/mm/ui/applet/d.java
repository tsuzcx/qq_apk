package com.tencent.mm.ui.applet;

import android.content.Context;
import android.content.res.Resources;
import android.os.Message;
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
import android.widget.TextView;
import com.tencent.mm.R.g;
import com.tencent.mm.R.i;
import com.tencent.mm.sdk.platformtools.ah;

public final class d
{
  private static int uSw = 0;
  
  public static void gG(Context paramContext)
  {
    if (uSw > 0) {
      return;
    }
    paramContext = new d.a(paramContext, LayoutInflater.from(paramContext).inflate(R.i.trace_view, null));
    paramContext.uSe.addView(paramContext.uSd, paramContext.uSf);
    uSw += 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.applet.d
 * JD-Core Version:    0.7.0.1
 */