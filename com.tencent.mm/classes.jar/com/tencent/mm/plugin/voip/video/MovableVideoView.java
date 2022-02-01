package com.tencent.mm.plugin.voip.video;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.u;

public class MovableVideoView
  extends OpenGlView
{
  public int HhR = 240;
  private int HhS = 800;
  private int HhT = 480;
  private float dsy;
  private float dsz;
  private long lTb;
  private View.OnClickListener mOnClickListener;
  private int mScreenHeight = 0;
  public int mScreenWidth = 0;
  public int mWidth = 320;
  
  public MovableVideoView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MovableVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final void jF(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115638);
    this.mWidth = paramInt1;
    this.HhR = paramInt2;
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    WindowManager localWindowManager = (WindowManager)getContext().getSystemService("window");
    if (this.mScreenWidth == 0)
    {
      this.mScreenWidth = localWindowManager.getDefaultDisplay().getWidth();
      this.mScreenHeight = localWindowManager.getDefaultDisplay().getHeight();
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(paramInt1, paramInt2);
    localLayoutParams.addRule(21, -1);
    localLayoutParams.topMargin = (a.fromDPToPix(getContext(), 12) + u.ay(getContext()));
    localLayoutParams.rightMargin = (localLayoutParams.topMargin - u.ay(getContext()));
    setLayoutParams(localLayoutParams);
    this.HhS = (this.mScreenHeight - this.HhR);
    this.HhT = (this.mScreenWidth - this.mWidth);
    localWindowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
    AppMethodBeat.o(115638);
  }
  
  public final void jG(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(258476);
    jF(paramInt1, paramInt2);
    AppMethodBeat.o(258476);
  }
  
  public final void jH(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115640);
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(paramInt1, paramInt2);
    localLayoutParams2.rightMargin = localLayoutParams1.rightMargin;
    localLayoutParams2.topMargin = localLayoutParams1.topMargin;
    localLayoutParams2.addRule(21, -1);
    this.mWidth = paramInt1;
    this.HhR = paramInt2;
    setLayoutParams(localLayoutParams2);
    AppMethodBeat.o(115640);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = 0;
    AppMethodBeat.i(115637);
    Log.d("MicroMsg.MovableVideoView", "event: " + paramMotionEvent.getAction());
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(115637);
      return true;
      this.dsy = paramMotionEvent.getRawX();
      this.dsz = paramMotionEvent.getRawY();
      this.lTb = System.currentTimeMillis();
      continue;
      float f1 = paramMotionEvent.getRawX() - this.dsy;
      float f2 = paramMotionEvent.getRawY() - this.dsz;
      if ((Math.abs(f1) > 1.0F) || (Math.abs(f2) > 1.0F))
      {
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)getLayoutParams();
        int m = (int)(localLayoutParams.rightMargin - f1);
        int k = (int)(f2 + localLayoutParams.topMargin);
        int i;
        if (m < 0)
        {
          i = 0;
          label174:
          localLayoutParams.rightMargin = i;
          if (k >= 0) {
            break label244;
          }
          i = j;
        }
        for (;;)
        {
          localLayoutParams.topMargin = i;
          setLayoutParams(localLayoutParams);
          this.dsy = paramMotionEvent.getRawX();
          this.dsz = paramMotionEvent.getRawY();
          break;
          i = m;
          if (m <= this.HhT) {
            break label174;
          }
          i = this.HhT;
          break label174;
          label244:
          if (k > this.HhS) {
            i = this.HhS;
          } else {
            i = k;
          }
        }
        long l = System.currentTimeMillis();
        if ((this.lTb != 0L) && (l - this.lTb < 300L) && (l - this.lTb >= 0L) && (this.mOnClickListener != null)) {
          this.mOnClickListener.onClick(this);
        }
        h.CyF.a(11079, new Object[] { Integer.valueOf(2) });
      }
    }
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mOnClickListener = paramOnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.MovableVideoView
 * JD-Core Version:    0.7.0.1
 */