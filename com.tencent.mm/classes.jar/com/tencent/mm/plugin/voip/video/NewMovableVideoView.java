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
import com.tencent.mm.cc.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voip.video.render.VoIPRenderSurfaceView;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.base.t;

public class NewMovableVideoView
  extends VoIPRenderSurfaceView
{
  public int ANN;
  private int ANO;
  private int ANP;
  private float cPy;
  private float cPz;
  private long kpU;
  private View.OnClickListener mOnClickListener;
  private int mScreenHeight;
  public int mScreenWidth;
  public int mWidth;
  
  public NewMovableVideoView(Context paramContext)
  {
    this(paramContext, null);
    AppMethodBeat.i(208512);
    setZOrderOnTop(true);
    AppMethodBeat.o(208512);
  }
  
  public NewMovableVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(208513);
    this.mWidth = 320;
    this.ANN = 240;
    this.ANO = 800;
    this.ANP = 480;
    this.mScreenWidth = 0;
    this.mScreenHeight = 0;
    setZOrderOnTop(true);
    AppMethodBeat.o(208513);
  }
  
  public final void ij(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(208515);
    this.mWidth = paramInt1;
    this.ANN = paramInt2;
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    WindowManager localWindowManager = (WindowManager)getContext().getSystemService("window");
    if (this.mScreenWidth == 0)
    {
      this.mScreenWidth = localWindowManager.getDefaultDisplay().getWidth();
      this.mScreenHeight = localWindowManager.getDefaultDisplay().getHeight();
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(paramInt1, paramInt2);
    localLayoutParams.addRule(21, -1);
    localLayoutParams.topMargin = (a.fromDPToPix(getContext(), 12) + t.jL(getContext()));
    localLayoutParams.rightMargin = (localLayoutParams.topMargin - t.jL(getContext()));
    setLayoutParams(localLayoutParams);
    this.ANO = (this.mScreenHeight - this.ANN);
    this.ANP = (this.mScreenWidth - this.mWidth);
    localWindowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
    AppMethodBeat.o(208515);
  }
  
  public final void il(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(208517);
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(paramInt1, paramInt2);
    localLayoutParams2.rightMargin = localLayoutParams1.rightMargin;
    localLayoutParams2.topMargin = localLayoutParams1.topMargin;
    localLayoutParams2.addRule(21, -1);
    this.mWidth = paramInt1;
    this.ANN = paramInt2;
    setLayoutParams(localLayoutParams2);
    AppMethodBeat.o(208517);
  }
  
  public final void im(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(210540);
    ij(paramInt1, paramInt2);
    AppMethodBeat.o(210540);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = 0;
    AppMethodBeat.i(208514);
    ac.d("MicroMsg.MovableVideoView", "event: " + paramMotionEvent.getAction());
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(208514);
      return true;
      this.cPy = paramMotionEvent.getRawX();
      this.cPz = paramMotionEvent.getRawY();
      this.kpU = System.currentTimeMillis();
      continue;
      float f1 = paramMotionEvent.getRawX() - this.cPy;
      float f2 = paramMotionEvent.getRawY() - this.cPz;
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
          this.cPy = paramMotionEvent.getRawX();
          this.cPz = paramMotionEvent.getRawY();
          break;
          i = m;
          if (m <= this.ANP) {
            break label174;
          }
          i = this.ANP;
          break label174;
          label244:
          if (k > this.ANO) {
            i = this.ANO;
          } else {
            i = k;
          }
        }
        long l = System.currentTimeMillis();
        if ((this.kpU != 0L) && (l - this.kpU < 300L) && (l - this.kpU >= 0L) && (this.mOnClickListener != null)) {
          this.mOnClickListener.onClick(this);
        }
        h.wUl.f(11079, new Object[] { Integer.valueOf(2) });
      }
    }
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mOnClickListener = paramOnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.NewMovableVideoView
 * JD-Core Version:    0.7.0.1
 */