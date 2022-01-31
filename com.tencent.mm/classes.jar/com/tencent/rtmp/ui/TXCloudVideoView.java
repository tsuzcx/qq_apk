package com.tencent.rtmp.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.view.TextureView;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.liteav.j;
import com.tencent.liteav.renderer.TXCFocusIndicatorView;
import com.tencent.liteav.renderer.TXCGLSurfaceView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class TXCloudVideoView
  extends FrameLayout
  implements View.OnTouchListener
{
  private static final int FOCUS_AREA_SIZE_DP = 70;
  private static final String TAG = "TXCloudVideoView";
  private float mBottom;
  private j mCapture;
  private int mCaptureHeight;
  private int mCaptureWidth;
  private int mCurrentScale;
  protected TXDashBoard mDashBoard;
  private boolean mFocus;
  private int mFocusAreaSize;
  protected TXCFocusIndicatorView mFocusIndicatorView;
  protected TXCGLSurfaceView mGLSurfaceView;
  private float mLeft;
  private float mRight;
  private ScaleGestureDetector mScaleGestureDetector;
  private ScaleGestureDetector.OnScaleGestureListener mScaleGestureListener;
  private float mTop;
  private TXCloudVideoView.a mTouchFocusRunnable;
  private String mUserId;
  protected TextureView mVideoView;
  private boolean mZoom;
  
  public TXCloudVideoView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TXCloudVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(65570);
    this.mCaptureWidth = 0;
    this.mCaptureHeight = 0;
    this.mLeft = 0.0F;
    this.mRight = 0.0F;
    this.mTop = 0.0F;
    this.mBottom = 0.0F;
    this.mFocusAreaSize = 0;
    this.mUserId = "";
    this.mFocus = false;
    this.mZoom = false;
    this.mCurrentScale = 1;
    this.mScaleGestureDetector = null;
    this.mScaleGestureListener = new ScaleGestureDetector.OnScaleGestureListener()
    {
      public boolean onScale(ScaleGestureDetector paramAnonymousScaleGestureDetector)
      {
        float f1 = 1.1F;
        AppMethodBeat.i(146895);
        int j;
        float f2;
        if (TXCloudVideoView.this.mCapture != null)
        {
          j = TXCloudVideoView.this.mCapture.e();
          if (j > 0)
          {
            f2 = paramAnonymousScaleGestureDetector.getScaleFactor();
            if (f2 <= 1.0F) {
              break label227;
            }
            f2 = 0.2F / j * (j - TXCloudVideoView.this.mCurrentScale) + 1.0F;
            if (f2 > 1.1F) {
              break label323;
            }
          }
        }
        for (;;)
        {
          label76:
          int k = Math.round(TXCloudVideoView.this.mCurrentScale * f1);
          int i = k;
          if (k == TXCloudVideoView.this.mCurrentScale)
          {
            if (f1 > 1.0F) {
              i = k + 1;
            }
          }
          else
          {
            label119:
            k = i;
            if (i >= j) {
              k = j;
            }
            i = k;
            if (k <= 1) {
              i = 1;
            }
            if (f1 <= 1.0F) {
              break label285;
            }
            if (i >= TXCloudVideoView.this.mCurrentScale) {
              break label315;
            }
            i = TXCloudVideoView.this.mCurrentScale;
          }
          label285:
          label315:
          for (;;)
          {
            TXCloudVideoView.access$502(TXCloudVideoView.this, i);
            if (TXCloudVideoView.this.mCapture != null) {
              TXCloudVideoView.this.mCapture.a(TXCloudVideoView.this.mCurrentScale);
            }
            AppMethodBeat.o(146895);
            return false;
            j = 0;
            break;
            label227:
            if (f2 >= 1.0F) {
              break label318;
            }
            f2 = 1.0F - 0.2F / j * TXCloudVideoView.this.mCurrentScale;
            f1 = f2;
            if (f2 < 0.9F) {
              break label76;
            }
            f1 = 0.9F;
            break label76;
            i = k;
            if (f1 >= 1.0F) {
              break label119;
            }
            i = k - 1;
            break label119;
            if ((f1 < 1.0F) && (i > TXCloudVideoView.this.mCurrentScale)) {
              i = TXCloudVideoView.this.mCurrentScale;
            }
          }
          label318:
          f1 = f2;
          continue;
          label323:
          f1 = f2;
        }
      }
      
      public boolean onScaleBegin(ScaleGestureDetector paramAnonymousScaleGestureDetector)
      {
        return true;
      }
      
      public void onScaleEnd(ScaleGestureDetector paramAnonymousScaleGestureDetector) {}
    };
    this.mTouchFocusRunnable = new TXCloudVideoView.a(this, null);
    this.mDashBoard = new TXDashBoard(paramContext);
    this.mScaleGestureDetector = new ScaleGestureDetector(paramContext, this.mScaleGestureListener);
    AppMethodBeat.o(65570);
  }
  
  private int clamp(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 > paramInt3) {
      return paramInt3;
    }
    if (paramInt1 < paramInt2) {
      return paramInt2;
    }
    return paramInt1;
  }
  
  private Rect getTouchRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat)
  {
    AppMethodBeat.i(65577);
    if ((this.mFocusAreaSize == 0) && (this.mGLSurfaceView != null)) {
      this.mFocusAreaSize = ((int)(70.0F * this.mGLSurfaceView.getResources().getDisplayMetrics().density + 0.5F));
    }
    int i = Float.valueOf(this.mFocusAreaSize * paramFloat).intValue();
    paramInt1 = clamp(paramInt1 - i / 2, 0, paramInt3 - i);
    paramInt2 = clamp(paramInt2 - i / 2, 0, paramInt4 - i);
    Rect localRect = new Rect(paramInt1, paramInt2, paramInt1 + i, i + paramInt2);
    AppMethodBeat.o(65577);
    return localRect;
  }
  
  public static int px2dip(Context paramContext, float paramFloat)
  {
    AppMethodBeat.i(146892);
    int i = (int)(paramFloat / paramContext.getResources().getDisplayMetrics().density + 0.5F);
    AppMethodBeat.o(146892);
    return i;
  }
  
  private void updateDbMargin()
  {
    AppMethodBeat.i(146893);
    if (this.mDashBoard != null) {
      this.mDashBoard.a((int)this.mLeft, (int)this.mTop, (int)this.mRight, (int)this.mBottom);
    }
    AppMethodBeat.o(146893);
  }
  
  public void addVideoView(TextureView paramTextureView)
  {
    AppMethodBeat.i(65572);
    if (this.mVideoView != null) {
      removeView(this.mVideoView);
    }
    this.mVideoView = paramTextureView;
    addView(this.mVideoView);
    resetLogView();
    AppMethodBeat.o(65572);
  }
  
  public void addVideoView(TXCGLSurfaceView paramTXCGLSurfaceView)
  {
    AppMethodBeat.i(65571);
    if (this.mGLSurfaceView != null) {
      removeView(this.mGLSurfaceView);
    }
    this.mGLSurfaceView = paramTXCGLSurfaceView;
    addView(this.mGLSurfaceView);
    resetLogView();
    AppMethodBeat.o(65571);
  }
  
  public void appendEventInfo(String paramString)
  {
    AppMethodBeat.i(146888);
    if (this.mDashBoard != null) {
      this.mDashBoard.a(paramString);
    }
    AppMethodBeat.o(146888);
  }
  
  public void clearLastFrame(boolean paramBoolean)
  {
    AppMethodBeat.i(65575);
    if (paramBoolean) {
      setVisibility(8);
    }
    AppMethodBeat.o(65575);
  }
  
  public void clearLog()
  {
    AppMethodBeat.i(65580);
    if (this.mDashBoard != null) {
      this.mDashBoard.a();
    }
    AppMethodBeat.o(65580);
  }
  
  public void disableLog(boolean paramBoolean)
  {
    AppMethodBeat.i(65578);
    if (this.mDashBoard != null) {
      this.mDashBoard.a(paramBoolean);
    }
    AppMethodBeat.o(65578);
  }
  
  public TXCGLSurfaceView getGLSurfaceView()
  {
    return this.mGLSurfaceView;
  }
  
  public TextureView getHWVideoView()
  {
    return this.mVideoView;
  }
  
  public String getUserId()
  {
    return this.mUserId;
  }
  
  public TextureView getVideoView()
  {
    return this.mVideoView;
  }
  
  public void onDestroy() {}
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(146885);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    updateDbMargin();
    if (this.mDashBoard != null)
    {
      this.mDashBoard.setStatusTextSize((float)(px2dip(getContext(), getWidth()) / 30.0D));
      this.mDashBoard.setEventTextSize((float)(px2dip(getContext(), getWidth()) / 25.0D));
    }
    if ((this.mCaptureWidth != 0) && (this.mCaptureHeight != 0)) {
      updateVideoViewSize(this.mCaptureWidth, this.mCaptureHeight);
    }
    AppMethodBeat.o(146885);
  }
  
  public void onPause() {}
  
  public void onResume() {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(65585);
    if ((paramMotionEvent.getPointerCount() == 1) && (paramMotionEvent.getAction() == 0))
    {
      this.mTouchFocusRunnable.a(paramView);
      this.mTouchFocusRunnable.a(paramMotionEvent);
      postDelayed(this.mTouchFocusRunnable, 100L);
    }
    for (;;)
    {
      if ((this.mZoom) && (paramMotionEvent.getAction() == 0)) {
        performClick();
      }
      boolean bool = this.mZoom;
      AppMethodBeat.o(65585);
      return bool;
      if ((paramMotionEvent.getPointerCount() > 1) && (paramMotionEvent.getAction() == 2))
      {
        removeCallbacks(this.mTouchFocusRunnable);
        onTouchFocus(-1, -1);
        if ((this.mScaleGestureDetector != null) && (this.mZoom)) {
          this.mScaleGestureDetector.onTouchEvent(paramMotionEvent);
        }
      }
    }
  }
  
  public void onTouchFocus(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(65576);
    if (this.mGLSurfaceView == null)
    {
      AppMethodBeat.o(65576);
      return;
    }
    if ((paramInt1 < 0) || (paramInt2 < 0))
    {
      if (this.mFocusIndicatorView != null) {
        this.mFocusIndicatorView.setVisibility(8);
      }
      AppMethodBeat.o(65576);
      return;
    }
    if (this.mFocusIndicatorView == null)
    {
      this.mFocusIndicatorView = new TXCFocusIndicatorView(getContext());
      this.mFocusIndicatorView.setVisibility(0);
      addView(this.mFocusIndicatorView);
    }
    Rect localRect = getTouchRect(paramInt1, paramInt2, this.mGLSurfaceView.getWidth(), this.mGLSurfaceView.getHeight(), 1.0F);
    this.mFocusIndicatorView.show(localRect.left, localRect.top, localRect.right - localRect.left);
    AppMethodBeat.o(65576);
  }
  
  public void removeFocusIndicatorView()
  {
    AppMethodBeat.i(65574);
    if (this.mFocusIndicatorView != null)
    {
      removeView(this.mFocusIndicatorView);
      this.mFocusIndicatorView = null;
    }
    AppMethodBeat.o(65574);
  }
  
  public void removeVideoView()
  {
    AppMethodBeat.i(65573);
    if (this.mVideoView != null)
    {
      removeView(this.mVideoView);
      this.mVideoView = null;
    }
    if (this.mGLSurfaceView != null)
    {
      removeView(this.mGLSurfaceView);
      this.mGLSurfaceView = null;
    }
    AppMethodBeat.o(65573);
  }
  
  protected void resetLogView()
  {
    AppMethodBeat.i(146884);
    if (this.mDashBoard != null)
    {
      removeView(this.mDashBoard);
      addView(this.mDashBoard);
    }
    AppMethodBeat.o(146884);
  }
  
  public void setDashBoardStatusInfo(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(146887);
    if (this.mDashBoard != null) {
      this.mDashBoard.a(paramCharSequence);
    }
    AppMethodBeat.o(146887);
  }
  
  public void setLogMargin(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(146890);
    this.mLeft = paramFloat1;
    this.mRight = paramFloat2;
    this.mTop = paramFloat3;
    this.mBottom = paramFloat4;
    if (this.mDashBoard != null) {
      this.mDashBoard.a((int)this.mLeft, (int)this.mTop, (int)this.mRight, (int)this.mBottom);
    }
    AppMethodBeat.o(146890);
  }
  
  public void setLogMarginRatio(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(146891);
    getWidth();
    getHeight();
    postDelayed(new TXCloudVideoView.1(this, paramFloat1, paramFloat2, paramFloat3, paramFloat4), 100L);
    AppMethodBeat.o(146891);
  }
  
  public void setLogText(Bundle paramBundle1, Bundle paramBundle2, int paramInt)
  {
    AppMethodBeat.i(65581);
    if (this.mDashBoard != null) {
      this.mDashBoard.a(paramBundle1, paramBundle2, paramInt);
    }
    AppMethodBeat.o(65581);
  }
  
  public void setMirror(boolean paramBoolean) {}
  
  public void setRenderMode(int paramInt) {}
  
  public void setRenderRotation(int paramInt) {}
  
  public void setUserId(String paramString)
  {
    this.mUserId = paramString;
  }
  
  public void showLog(boolean paramBoolean)
  {
    AppMethodBeat.i(65579);
    TXDashBoard localTXDashBoard;
    if (this.mDashBoard != null)
    {
      localTXDashBoard = this.mDashBoard;
      if (!paramBoolean) {
        break label36;
      }
    }
    label36:
    for (int i = 2;; i = 0)
    {
      localTXDashBoard.setShowLevel(i);
      AppMethodBeat.o(65579);
      return;
    }
  }
  
  public void showVideoDebugLog(int paramInt)
  {
    AppMethodBeat.i(146889);
    if (this.mDashBoard != null) {
      this.mDashBoard.setShowLevel(paramInt);
    }
    AppMethodBeat.o(146889);
  }
  
  public void start(boolean paramBoolean1, boolean paramBoolean2, j paramj)
  {
    AppMethodBeat.i(146894);
    this.mFocus = paramBoolean1;
    this.mZoom = paramBoolean2;
    if ((this.mFocus) || (this.mZoom))
    {
      setOnTouchListener(this);
      this.mCapture = paramj;
    }
    if (this.mGLSurfaceView != null) {
      this.mGLSurfaceView.setVisibility(0);
    }
    AppMethodBeat.o(146894);
  }
  
  public void stop(boolean paramBoolean)
  {
    AppMethodBeat.i(65584);
    if ((this.mFocus) || (this.mZoom)) {
      setOnTouchListener(null);
    }
    this.mCapture = null;
    if ((paramBoolean) && (this.mGLSurfaceView != null)) {
      this.mGLSurfaceView.setVisibility(8);
    }
    AppMethodBeat.o(65584);
  }
  
  public void updateVideoViewSize(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(146886);
    if (this.mGLSurfaceView != null) {}
    int j;
    int i;
    for (Object localObject1 = this.mGLSurfaceView;; localObject1 = this.mVideoView)
    {
      j = getWidth();
      i = getHeight();
      if ((paramInt2 != 0) && (i != 0)) {
        break label70;
      }
      AppMethodBeat.o(146886);
      return;
      if (this.mVideoView == null) {
        break;
      }
    }
    AppMethodBeat.o(146886);
    return;
    label70:
    this.mCaptureWidth = paramInt1;
    this.mCaptureHeight = paramInt2;
    float f = paramInt1 * 1.0F / paramInt2;
    if (f > j * 1.0F / i)
    {
      i = (int)(j / f);
      paramInt1 = (getHeight() - i) / 2;
      paramInt2 = 0;
    }
    Object localObject2;
    for (;;)
    {
      localObject2 = ((View)localObject1).getLayoutParams();
      if (localObject2 == null) {
        break label231;
      }
      localObject2 = (FrameLayout.LayoutParams)localObject2;
      if ((((FrameLayout.LayoutParams)localObject2).width != j) || (((FrameLayout.LayoutParams)localObject2).height != i)) {
        break;
      }
      AppMethodBeat.o(146886);
      return;
      j = (int)(f * i);
      paramInt2 = (getWidth() - j) / 2;
      paramInt1 = 0;
    }
    ((FrameLayout.LayoutParams)localObject2).width = j;
    ((FrameLayout.LayoutParams)localObject2).height = i;
    for (;;)
    {
      ((FrameLayout.LayoutParams)localObject2).leftMargin = paramInt2;
      ((FrameLayout.LayoutParams)localObject2).topMargin = paramInt1;
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      AppMethodBeat.o(146886);
      return;
      label231:
      localObject2 = new FrameLayout.LayoutParams(j, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.rtmp.ui.TXCloudVideoView
 * JD-Core Version:    0.7.0.1
 */