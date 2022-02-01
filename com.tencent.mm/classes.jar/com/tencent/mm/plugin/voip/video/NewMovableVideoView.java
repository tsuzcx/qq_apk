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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.aa;

public class NewMovableVideoView
  extends VoIPRenderSurfaceView
{
  public int UMD;
  private int UME;
  private int UMF;
  private float hpx;
  private float hpy;
  private View.OnClickListener mOnClickListener;
  private int mScreenHeight;
  public int mScreenWidth;
  public int mWidth;
  private long rTy;
  
  public NewMovableVideoView(Context paramContext)
  {
    this(paramContext, null);
    AppMethodBeat.i(292823);
    setZOrderOnTop(true);
    AppMethodBeat.o(292823);
  }
  
  public NewMovableVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(292830);
    this.mWidth = 320;
    this.UMD = 240;
    this.UME = 800;
    this.UMF = 480;
    this.mScreenWidth = 0;
    this.mScreenHeight = 0;
    setZOrderOnTop(true);
    AppMethodBeat.o(292830);
  }
  
  public final void mG(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(292844);
    this.mWidth = paramInt1;
    this.UMD = paramInt2;
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    WindowManager localWindowManager = (WindowManager)getContext().getSystemService("window");
    if (this.mScreenWidth == 0)
    {
      this.mScreenWidth = localWindowManager.getDefaultDisplay().getWidth();
      this.mScreenHeight = localWindowManager.getDefaultDisplay().getHeight();
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(paramInt1, paramInt2);
    localLayoutParams.addRule(21, -1);
    localLayoutParams.topMargin = (a.fromDPToPix(getContext(), 12) + aa.be(getContext()));
    localLayoutParams.rightMargin = (localLayoutParams.topMargin - aa.be(getContext()));
    setLayoutParams(localLayoutParams);
    this.UME = (this.mScreenHeight - this.UMD);
    this.UMF = (this.mScreenWidth - this.mWidth);
    localWindowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
    AppMethodBeat.o(292844);
  }
  
  public final void mI(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(292854);
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(paramInt1, paramInt2);
    localLayoutParams2.rightMargin = localLayoutParams1.rightMargin;
    localLayoutParams2.topMargin = localLayoutParams1.topMargin;
    localLayoutParams2.addRule(21, -1);
    this.mWidth = paramInt1;
    this.UMD = paramInt2;
    setLayoutParams(localLayoutParams2);
    AppMethodBeat.o(292854);
  }
  
  public final void mJ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(369826);
    mG(paramInt1, paramInt2);
    AppMethodBeat.o(369826);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = 0;
    AppMethodBeat.i(292840);
    Log.d("MicroMsg.MovableVideoView", "event: " + paramMotionEvent.getAction());
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(292840);
      return true;
      this.hpx = paramMotionEvent.getRawX();
      this.hpy = paramMotionEvent.getRawY();
      this.rTy = System.currentTimeMillis();
      continue;
      float f1 = paramMotionEvent.getRawX() - this.hpx;
      float f2 = paramMotionEvent.getRawY() - this.hpy;
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
          this.hpx = paramMotionEvent.getRawX();
          this.hpy = paramMotionEvent.getRawY();
          break;
          i = m;
          if (m <= this.UMF) {
            break label174;
          }
          i = this.UMF;
          break label174;
          label244:
          if (k > this.UME) {
            i = this.UME;
          } else {
            i = k;
          }
        }
        long l = System.currentTimeMillis();
        if ((this.rTy != 0L) && (l - this.rTy < 300L) && (l - this.rTy >= 0L) && (this.mOnClickListener != null)) {
          this.mOnClickListener.onClick(this);
        }
        h.OAn.b(11079, new Object[] { Integer.valueOf(2) });
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