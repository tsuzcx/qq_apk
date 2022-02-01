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
import com.tencent.mm.plugin.voip.video.render.VoIPRenderSurfaceView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.u;

public class NewMovableVideoView
  extends VoIPRenderSurfaceView
{
  public int HhR;
  private int HhS;
  private int HhT;
  private float dsy;
  private float dsz;
  private long lTb;
  private View.OnClickListener mOnClickListener;
  private int mScreenHeight;
  public int mScreenWidth;
  public int mWidth;
  
  public NewMovableVideoView(Context paramContext)
  {
    this(paramContext, null);
    AppMethodBeat.i(235822);
    setZOrderOnTop(true);
    AppMethodBeat.o(235822);
  }
  
  public NewMovableVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(235823);
    this.mWidth = 320;
    this.HhR = 240;
    this.HhS = 800;
    this.HhT = 480;
    this.mScreenWidth = 0;
    this.mScreenHeight = 0;
    setZOrderOnTop(true);
    AppMethodBeat.o(235823);
  }
  
  public final void jF(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(235825);
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
    AppMethodBeat.o(235825);
  }
  
  public final void jH(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(235827);
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(paramInt1, paramInt2);
    localLayoutParams2.rightMargin = localLayoutParams1.rightMargin;
    localLayoutParams2.topMargin = localLayoutParams1.topMargin;
    localLayoutParams2.addRule(21, -1);
    this.mWidth = paramInt1;
    this.HhR = paramInt2;
    setLayoutParams(localLayoutParams2);
    AppMethodBeat.o(235827);
  }
  
  public final void jI(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(258477);
    jF(paramInt1, paramInt2);
    AppMethodBeat.o(258477);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = 0;
    AppMethodBeat.i(235824);
    Log.d("MicroMsg.MovableVideoView", "event: " + paramMotionEvent.getAction());
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(235824);
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
 * Qualified Name:     com.tencent.mm.plugin.voip.video.NewMovableVideoView
 * JD-Core Version:    0.7.0.1
 */