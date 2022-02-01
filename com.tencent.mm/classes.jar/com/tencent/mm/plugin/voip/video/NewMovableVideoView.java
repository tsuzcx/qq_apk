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
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.voip.video.render.VoIPRenderSurfaceView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.t;

public class NewMovableVideoView
  extends VoIPRenderSurfaceView
{
  public int Cna;
  private int Cnb;
  private int Cnc;
  private float daO;
  private float daP;
  private long kKU;
  private View.OnClickListener mOnClickListener;
  private int mScreenHeight;
  public int mScreenWidth;
  public int mWidth;
  
  public NewMovableVideoView(Context paramContext)
  {
    this(paramContext, null);
    AppMethodBeat.i(216559);
    setZOrderOnTop(true);
    AppMethodBeat.o(216559);
  }
  
  public NewMovableVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(216560);
    this.mWidth = 320;
    this.Cna = 240;
    this.Cnb = 800;
    this.Cnc = 480;
    this.mScreenWidth = 0;
    this.mScreenHeight = 0;
    setZOrderOnTop(true);
    AppMethodBeat.o(216560);
  }
  
  public final void iw(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(216562);
    this.mWidth = paramInt1;
    this.Cna = paramInt2;
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    WindowManager localWindowManager = (WindowManager)getContext().getSystemService("window");
    if (this.mScreenWidth == 0)
    {
      this.mScreenWidth = localWindowManager.getDefaultDisplay().getWidth();
      this.mScreenHeight = localWindowManager.getDefaultDisplay().getHeight();
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(paramInt1, paramInt2);
    localLayoutParams.addRule(21, -1);
    localLayoutParams.topMargin = (a.fromDPToPix(getContext(), 12) + t.jW(getContext()));
    localLayoutParams.rightMargin = (localLayoutParams.topMargin - t.jW(getContext()));
    setLayoutParams(localLayoutParams);
    this.Cnb = (this.mScreenHeight - this.Cna);
    this.Cnc = (this.mScreenWidth - this.mWidth);
    localWindowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
    AppMethodBeat.o(216562);
  }
  
  public final void iy(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(216564);
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(paramInt1, paramInt2);
    localLayoutParams2.rightMargin = localLayoutParams1.rightMargin;
    localLayoutParams2.topMargin = localLayoutParams1.topMargin;
    localLayoutParams2.addRule(21, -1);
    this.mWidth = paramInt1;
    this.Cna = paramInt2;
    setLayoutParams(localLayoutParams2);
    AppMethodBeat.o(216564);
  }
  
  public final void iz(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(221688);
    iw(paramInt1, paramInt2);
    AppMethodBeat.o(221688);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = 0;
    AppMethodBeat.i(216561);
    ad.d("MicroMsg.MovableVideoView", "event: " + paramMotionEvent.getAction());
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(216561);
      return true;
      this.daO = paramMotionEvent.getRawX();
      this.daP = paramMotionEvent.getRawY();
      this.kKU = System.currentTimeMillis();
      continue;
      float f1 = paramMotionEvent.getRawX() - this.daO;
      float f2 = paramMotionEvent.getRawY() - this.daP;
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
          this.daO = paramMotionEvent.getRawX();
          this.daP = paramMotionEvent.getRawY();
          break;
          i = m;
          if (m <= this.Cnc) {
            break label174;
          }
          i = this.Cnc;
          break label174;
          label244:
          if (k > this.Cnb) {
            i = this.Cnb;
          } else {
            i = k;
          }
        }
        long l = System.currentTimeMillis();
        if ((this.kKU != 0L) && (l - this.kKU < 300L) && (l - this.kKU >= 0L) && (this.mOnClickListener != null)) {
          this.mOnClickListener.onClick(this);
        }
        g.yhR.f(11079, new Object[] { Integer.valueOf(2) });
      }
    }
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mOnClickListener = paramOnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.NewMovableVideoView
 * JD-Core Version:    0.7.0.1
 */