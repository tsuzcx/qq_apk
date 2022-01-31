package com.tencent.rtmp.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.liteav.renderer.d;

public class TXCloudVideoView
  extends FrameLayout
{
  private static final int FOCUS_AREA_SIZE_DP = 70;
  private static final String TAG = "TXCloudVideoView";
  private int mFocusAreaSize = 0;
  private com.tencent.liteav.renderer.a mFocusIndicatorView;
  private d mGLSurfaceView;
  private a mLogView;
  private TextureView mVideoView;
  
  public TXCloudVideoView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TXCloudVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mLogView = new a(paramContext);
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
    if ((this.mFocusAreaSize == 0) && (this.mGLSurfaceView != null)) {
      this.mFocusAreaSize = ((int)(70.0F * this.mGLSurfaceView.getResources().getDisplayMetrics().density + 0.5F));
    }
    int i = Float.valueOf(this.mFocusAreaSize * paramFloat).intValue();
    paramInt1 = clamp(paramInt1 - i / 2, 0, paramInt3 - i);
    paramInt2 = clamp(paramInt2 - i / 2, 0, paramInt4 - i);
    return new Rect(paramInt1, paramInt2, paramInt1 + i, i + paramInt2);
  }
  
  public void addVideoView(TextureView paramTextureView)
  {
    if (this.mVideoView != null) {
      removeView(this.mVideoView);
    }
    this.mVideoView = paramTextureView;
    addView(this.mVideoView);
    removeView(this.mLogView);
    addView(this.mLogView);
  }
  
  public void addVideoView(d paramd)
  {
    if (this.mGLSurfaceView != null) {
      removeView(this.mGLSurfaceView);
    }
    this.mGLSurfaceView = paramd;
    addView(this.mGLSurfaceView);
    removeView(this.mLogView);
    addView(this.mLogView);
  }
  
  public void adjustVideoSize() {}
  
  public void clearLastFrame(boolean paramBoolean)
  {
    if (paramBoolean) {
      setVisibility(8);
    }
  }
  
  public void clearLog()
  {
    this.mLogView.a();
  }
  
  public void disableLog(boolean paramBoolean)
  {
    this.mLogView.b(paramBoolean);
  }
  
  public void enableHardwareDecode(boolean paramBoolean) {}
  
  public d getGLSurfaceView()
  {
    return this.mGLSurfaceView;
  }
  
  public TextureView getHWVideoView()
  {
    return this.mVideoView;
  }
  
  public TextureView getVideoView()
  {
    return this.mVideoView;
  }
  
  public void onDestroy() {}
  
  public void onPause() {}
  
  public void onResume() {}
  
  public void onTouchFocus(int paramInt1, int paramInt2)
  {
    if (this.mGLSurfaceView == null) {}
    do
    {
      return;
      if ((paramInt1 >= 0) && (paramInt2 >= 0)) {
        break;
      }
    } while (this.mFocusIndicatorView == null);
    this.mFocusIndicatorView.setVisibility(8);
    return;
    if (this.mFocusIndicatorView == null)
    {
      this.mFocusIndicatorView = new com.tencent.liteav.renderer.a(getContext());
      this.mFocusIndicatorView.setVisibility(0);
      addView(this.mFocusIndicatorView);
    }
    Rect localRect = getTouchRect(paramInt1, paramInt2, this.mGLSurfaceView.getWidth(), this.mGLSurfaceView.getHeight(), 1.0F);
    this.mFocusIndicatorView.a(localRect.left, localRect.top, localRect.right - localRect.left);
  }
  
  public void refreshLastFrame() {}
  
  public void removeVideoView()
  {
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
  }
  
  public void setGLOnTouchListener(View.OnTouchListener paramOnTouchListener) {}
  
  public void setLogMargin(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject = this.mLogView.getLayoutParams();
    if (localObject != null) {}
    for (localObject = (FrameLayout.LayoutParams)localObject;; localObject = new FrameLayout.LayoutParams(-1, -1))
    {
      ((FrameLayout.LayoutParams)localObject).leftMargin = a.a(getContext(), paramInt1);
      ((FrameLayout.LayoutParams)localObject).rightMargin = a.a(getContext(), paramInt2);
      ((FrameLayout.LayoutParams)localObject).topMargin = a.a(getContext(), paramInt3);
      ((FrameLayout.LayoutParams)localObject).bottomMargin = a.a(getContext(), paramInt4);
      this.mLogView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
    }
  }
  
  public void setLogText(Bundle paramBundle1, Bundle paramBundle2, int paramInt)
  {
    this.mLogView.a(paramBundle1, paramBundle2, paramInt);
  }
  
  public void setMirror(boolean paramBoolean) {}
  
  public void setRenderMode(int paramInt) {}
  
  public void setRenderRotation(int paramInt) {}
  
  public void setStreamUrl(String paramString) {}
  
  public void setSurfaceTextureListener(TextureView.SurfaceTextureListener paramSurfaceTextureListener) {}
  
  public void setUseBeautyView(boolean paramBoolean) {}
  
  public void showLog(boolean paramBoolean)
  {
    this.mLogView.a(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.rtmp.ui.TXCloudVideoView
 * JD-Core Version:    0.7.0.1
 */