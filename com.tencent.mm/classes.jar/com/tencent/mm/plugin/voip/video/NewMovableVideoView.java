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
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voip.video.render.VoIPRenderSurfaceView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.t;

public class NewMovableVideoView
  extends VoIPRenderSurfaceView
{
  private float cSe;
  private float cSf;
  private View.OnClickListener mOnClickListener;
  private int mScreenHeight;
  public int mScreenWidth;
  public int mWidth;
  public int zuV;
  private int zuW;
  private int zuX;
  private long zuY;
  
  public NewMovableVideoView(Context paramContext)
  {
    this(paramContext, null);
    AppMethodBeat.i(192179);
    setZOrderOnTop(true);
    AppMethodBeat.o(192179);
  }
  
  public NewMovableVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(192180);
    this.mWidth = 320;
    this.zuV = 240;
    this.zuW = 800;
    this.zuX = 480;
    this.mScreenWidth = 0;
    this.mScreenHeight = 0;
    setZOrderOnTop(true);
    AppMethodBeat.o(192180);
  }
  
  public final void hU(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(192182);
    this.mWidth = paramInt1;
    this.zuV = paramInt2;
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    WindowManager localWindowManager = (WindowManager)getContext().getSystemService("window");
    if (this.mScreenWidth == 0)
    {
      this.mScreenWidth = localWindowManager.getDefaultDisplay().getWidth();
      this.mScreenHeight = localWindowManager.getDefaultDisplay().getHeight();
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(paramInt1, paramInt2);
    localLayoutParams.addRule(21, -1);
    localLayoutParams.topMargin = (a.fromDPToPix(getContext(), 12) + t.jA(getContext()));
    localLayoutParams.rightMargin = (localLayoutParams.topMargin - t.jA(getContext()));
    setLayoutParams(localLayoutParams);
    this.zuW = (this.mScreenHeight - this.zuV);
    this.zuX = (this.mScreenWidth - this.mWidth);
    localWindowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
    AppMethodBeat.o(192182);
  }
  
  public final void hW(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(192184);
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(paramInt1, paramInt2);
    localLayoutParams2.rightMargin = localLayoutParams1.rightMargin;
    localLayoutParams2.topMargin = localLayoutParams1.topMargin;
    localLayoutParams2.addRule(21, -1);
    this.mWidth = paramInt1;
    this.zuV = paramInt2;
    setLayoutParams(localLayoutParams2);
    AppMethodBeat.o(192184);
  }
  
  public final void hX(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(205019);
    hU(paramInt1, paramInt2);
    AppMethodBeat.o(205019);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = 0;
    AppMethodBeat.i(192181);
    ad.d("MicroMsg.MovableVideoView", "event: " + paramMotionEvent.getAction());
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(192181);
      return true;
      this.cSe = paramMotionEvent.getRawX();
      this.cSf = paramMotionEvent.getRawY();
      this.zuY = System.currentTimeMillis();
      continue;
      float f1 = paramMotionEvent.getRawX() - this.cSe;
      float f2 = paramMotionEvent.getRawY() - this.cSf;
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
          this.cSe = paramMotionEvent.getRawX();
          this.cSf = paramMotionEvent.getRawY();
          break;
          i = m;
          if (m <= this.zuX) {
            break label174;
          }
          i = this.zuX;
          break label174;
          label244:
          if (k > this.zuW) {
            i = this.zuW;
          } else {
            i = k;
          }
        }
        long l = System.currentTimeMillis();
        if ((this.zuY != 0L) && (l - this.zuY < 300L) && (l - this.zuY >= 0L) && (this.mOnClickListener != null)) {
          this.mOnClickListener.onClick(this);
        }
        h.vKh.f(11079, new Object[] { Integer.valueOf(2) });
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