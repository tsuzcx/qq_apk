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
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.voip.video.render.VoIPRenderSurfaceView;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.base.t;

public class NewMovableVideoView
  extends VoIPRenderSurfaceView
{
  public int CEE;
  private int CEF;
  private int CEG;
  private float dbQ;
  private float dbR;
  private long kOj;
  private View.OnClickListener mOnClickListener;
  private int mScreenHeight;
  public int mScreenWidth;
  public int mWidth;
  
  public NewMovableVideoView(Context paramContext)
  {
    this(paramContext, null);
    AppMethodBeat.i(210238);
    setZOrderOnTop(true);
    AppMethodBeat.o(210238);
  }
  
  public NewMovableVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(210239);
    this.mWidth = 320;
    this.CEE = 240;
    this.CEF = 800;
    this.CEG = 480;
    this.mScreenWidth = 0;
    this.mScreenHeight = 0;
    setZOrderOnTop(true);
    AppMethodBeat.o(210239);
  }
  
  public final void iA(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(210241);
    this.mWidth = paramInt1;
    this.CEE = paramInt2;
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    WindowManager localWindowManager = (WindowManager)getContext().getSystemService("window");
    if (this.mScreenWidth == 0)
    {
      this.mScreenWidth = localWindowManager.getDefaultDisplay().getWidth();
      this.mScreenHeight = localWindowManager.getDefaultDisplay().getHeight();
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(paramInt1, paramInt2);
    localLayoutParams.addRule(21, -1);
    localLayoutParams.topMargin = (a.fromDPToPix(getContext(), 12) + t.kd(getContext()));
    localLayoutParams.rightMargin = (localLayoutParams.topMargin - t.kd(getContext()));
    setLayoutParams(localLayoutParams);
    this.CEF = (this.mScreenHeight - this.CEE);
    this.CEG = (this.mScreenWidth - this.mWidth);
    localWindowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
    AppMethodBeat.o(210241);
  }
  
  public final void iC(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(210243);
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(paramInt1, paramInt2);
    localLayoutParams2.rightMargin = localLayoutParams1.rightMargin;
    localLayoutParams2.topMargin = localLayoutParams1.topMargin;
    localLayoutParams2.addRule(21, -1);
    this.mWidth = paramInt1;
    this.CEE = paramInt2;
    setLayoutParams(localLayoutParams2);
    AppMethodBeat.o(210243);
  }
  
  public final void iD(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(224119);
    iA(paramInt1, paramInt2);
    AppMethodBeat.o(224119);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = 0;
    AppMethodBeat.i(210240);
    ae.d("MicroMsg.MovableVideoView", "event: " + paramMotionEvent.getAction());
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(210240);
      return true;
      this.dbQ = paramMotionEvent.getRawX();
      this.dbR = paramMotionEvent.getRawY();
      this.kOj = System.currentTimeMillis();
      continue;
      float f1 = paramMotionEvent.getRawX() - this.dbQ;
      float f2 = paramMotionEvent.getRawY() - this.dbR;
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
          this.dbQ = paramMotionEvent.getRawX();
          this.dbR = paramMotionEvent.getRawY();
          break;
          i = m;
          if (m <= this.CEG) {
            break label174;
          }
          i = this.CEG;
          break label174;
          label244:
          if (k > this.CEF) {
            i = this.CEF;
          } else {
            i = k;
          }
        }
        long l = System.currentTimeMillis();
        if ((this.kOj != 0L) && (l - this.kOj < 300L) && (l - this.kOj >= 0L) && (this.mOnClickListener != null)) {
          this.mOnClickListener.onClick(this);
        }
        g.yxI.f(11079, new Object[] { Integer.valueOf(2) });
      }
    }
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mOnClickListener = paramOnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.NewMovableVideoView
 * JD-Core Version:    0.7.0.1
 */