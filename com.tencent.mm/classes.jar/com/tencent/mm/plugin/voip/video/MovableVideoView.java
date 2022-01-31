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
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.t;

public class MovableVideoView
  extends OpenGlView
{
  private float cdx;
  private float cdy;
  private View.OnClickListener mOnClickListener;
  private int mScreenHeight = 0;
  public int mScreenWidth = 0;
  public int mWidth = 320;
  public int tGn = 240;
  private int tGo = 800;
  private int tGp = 480;
  private long tGq;
  
  public MovableVideoView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MovableVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final void gn(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(5066);
    this.mWidth = paramInt1;
    this.tGn = paramInt2;
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    WindowManager localWindowManager = (WindowManager)getContext().getSystemService("window");
    if (this.mScreenWidth == 0)
    {
      this.mScreenWidth = localWindowManager.getDefaultDisplay().getWidth();
      this.mScreenHeight = localWindowManager.getDefaultDisplay().getHeight();
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(paramInt1, paramInt2);
    localLayoutParams.topMargin = (a.fromDPToPix(getContext(), 12) + t.hY(getContext()));
    localLayoutParams.leftMargin = (this.mScreenWidth - this.mWidth - localLayoutParams.topMargin + t.hY(getContext()));
    setLayoutParams(localLayoutParams);
    this.tGo = (this.mScreenHeight - this.tGn);
    this.tGp = (this.mScreenWidth - this.mWidth);
    localWindowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
    AppMethodBeat.o(5066);
  }
  
  public final void go(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(156772);
    gn(paramInt1, paramInt2);
    AppMethodBeat.o(156772);
  }
  
  public final void gp(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(5068);
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(paramInt1, paramInt2);
    localLayoutParams2.leftMargin = localLayoutParams1.leftMargin;
    localLayoutParams2.topMargin = localLayoutParams1.topMargin;
    this.mWidth = paramInt1;
    this.tGn = paramInt2;
    setLayoutParams(localLayoutParams2);
    AppMethodBeat.o(5068);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = 0;
    AppMethodBeat.i(5065);
    ab.d("MicroMsg.MovableVideoView", "event: " + paramMotionEvent.getAction());
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(5065);
      return true;
      this.cdx = paramMotionEvent.getRawX();
      this.cdy = paramMotionEvent.getRawY();
      this.tGq = System.currentTimeMillis();
      continue;
      float f1 = paramMotionEvent.getRawX() - this.cdx;
      float f2 = paramMotionEvent.getRawY() - this.cdy;
      if ((Math.abs(f1) > 1.0F) || (Math.abs(f2) > 1.0F))
      {
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)getLayoutParams();
        int m = (int)(f1 + localLayoutParams.leftMargin);
        int k = (int)(f2 + localLayoutParams.topMargin);
        int i;
        if (m < 0)
        {
          i = 0;
          label175:
          localLayoutParams.leftMargin = i;
          if (k >= 0) {
            break label245;
          }
          i = j;
        }
        for (;;)
        {
          localLayoutParams.topMargin = i;
          setLayoutParams(localLayoutParams);
          this.cdx = paramMotionEvent.getRawX();
          this.cdy = paramMotionEvent.getRawY();
          break;
          i = m;
          if (m <= this.tGp) {
            break label175;
          }
          i = this.tGp;
          break label175;
          label245:
          if (k > this.tGo) {
            i = this.tGo;
          } else {
            i = k;
          }
        }
        long l = System.currentTimeMillis();
        if ((this.tGq != 0L) && (l - this.tGq < 300L) && (l - this.tGq >= 0L) && (this.mOnClickListener != null)) {
          this.mOnClickListener.onClick(this);
        }
        h.qsU.e(11079, new Object[] { Integer.valueOf(2) });
      }
    }
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mOnClickListener = paramOnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.MovableVideoView
 * JD-Core Version:    0.7.0.1
 */