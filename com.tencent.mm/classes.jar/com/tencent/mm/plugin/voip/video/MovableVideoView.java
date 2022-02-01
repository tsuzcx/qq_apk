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
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.w;

public class MovableVideoView
  extends OpenGlView
{
  public int NYG = 240;
  private int NYH = 800;
  private int NYI = 480;
  private float flk;
  private float fll;
  private View.OnClickListener mOnClickListener;
  private int mScreenHeight = 0;
  public int mScreenWidth = 0;
  public int mWidth = 320;
  private long oPK;
  
  public MovableVideoView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MovableVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final void kU(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115638);
    this.mWidth = paramInt1;
    this.NYG = paramInt2;
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    WindowManager localWindowManager = (WindowManager)getContext().getSystemService("window");
    if (this.mScreenWidth == 0)
    {
      this.mScreenWidth = localWindowManager.getDefaultDisplay().getWidth();
      this.mScreenHeight = localWindowManager.getDefaultDisplay().getHeight();
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(paramInt1, paramInt2);
    localLayoutParams.addRule(21, -1);
    localLayoutParams.topMargin = (a.fromDPToPix(getContext(), 12) + w.at(getContext()));
    localLayoutParams.rightMargin = (localLayoutParams.topMargin - w.at(getContext()));
    setLayoutParams(localLayoutParams);
    this.NYH = (this.mScreenHeight - this.NYG);
    this.NYI = (this.mScreenWidth - this.mWidth);
    localWindowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
    AppMethodBeat.o(115638);
  }
  
  public final void kV(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(293180);
    kU(paramInt1, paramInt2);
    AppMethodBeat.o(293180);
  }
  
  public final void kW(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115640);
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(paramInt1, paramInt2);
    localLayoutParams2.rightMargin = localLayoutParams1.rightMargin;
    localLayoutParams2.topMargin = localLayoutParams1.topMargin;
    localLayoutParams2.addRule(21, -1);
    this.mWidth = paramInt1;
    this.NYG = paramInt2;
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
      this.flk = paramMotionEvent.getRawX();
      this.fll = paramMotionEvent.getRawY();
      this.oPK = System.currentTimeMillis();
      continue;
      float f1 = paramMotionEvent.getRawX() - this.flk;
      float f2 = paramMotionEvent.getRawY() - this.fll;
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
          this.flk = paramMotionEvent.getRawX();
          this.fll = paramMotionEvent.getRawY();
          break;
          i = m;
          if (m <= this.NYI) {
            break label174;
          }
          i = this.NYI;
          break label174;
          label244:
          if (k > this.NYH) {
            i = this.NYH;
          } else {
            i = k;
          }
        }
        long l = System.currentTimeMillis();
        if ((this.oPK != 0L) && (l - this.oPK < 300L) && (l - this.oPK >= 0L) && (this.mOnClickListener != null)) {
          this.mOnClickListener.onClick(this);
        }
        h.IzE.a(11079, new Object[] { Integer.valueOf(2) });
      }
    }
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mOnClickListener = paramOnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.MovableVideoView
 * JD-Core Version:    0.7.0.1
 */