package io.clipworks.displaysys;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.facebook.jni.HybridData;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class DSRenderView
  extends SurfaceView
  implements SurfaceHolder.Callback
{
  private final HybridData mHybridData;
  
  public DSRenderView(Context paramContext)
  {
    this(paramContext, null, 0, 0);
  }
  
  public DSRenderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public DSRenderView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, 0);
  }
  
  public DSRenderView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    AppMethodBeat.i(189545);
    this.mHybridData = initHybrid();
    getHolder().addCallback(this);
    AppMethodBeat.o(189545);
  }
  
  private native HybridData initHybrid();
  
  private native void nativeOnTouchesBegin(int paramInt, float paramFloat1, float paramFloat2, long paramLong);
  
  private native void nativeOnTouchesCancel(int[] paramArrayOfInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong);
  
  private native void nativeOnTouchesEnd(int paramInt, float paramFloat1, float paramFloat2, long paramLong);
  
  private native void nativeOnTouchesMove(int[] paramArrayOfInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong);
  
  private native void nativeOnVisibilityDidChange(boolean paramBoolean);
  
  public native void nativeOnDidAttachToWindow();
  
  public native void nativeOnDidDetachFromWindow();
  
  public native void nativeOnSizeDidChange(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public native void nativeOnSurfaceDidChange(int paramInt1, int paramInt2, int paramInt3);
  
  public native void nativeOnSurfaceDidCreate(Surface paramSurface);
  
  public native void nativeOnSurfaceDidDestroy();
  
  public void nativeTeardown()
  {
    AppMethodBeat.i(189713);
    this.mHybridData.resetNative();
    AppMethodBeat.o(189713);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(189602);
    super.onAttachedToWindow();
    nativeOnDidAttachToWindow();
    AppMethodBeat.o(189602);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(189611);
    super.onDetachedFromWindow();
    nativeOnDidDetachFromWindow();
    AppMethodBeat.o(189611);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(189633);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    nativeOnSizeDidChange(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(189633);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(189724);
    super.onTouchEvent(paramMotionEvent);
    int j = paramMotionEvent.getPointerCount();
    long l = paramMotionEvent.getEventTime();
    int[] arrayOfInt = new int[j];
    float[] arrayOfFloat1 = new float[j];
    float[] arrayOfFloat2 = new float[j];
    int i = 0;
    while (i < j)
    {
      arrayOfInt[i] = paramMotionEvent.getPointerId(i);
      arrayOfFloat1[i] = paramMotionEvent.getX(i);
      arrayOfFloat2[i] = paramMotionEvent.getY(i);
      i += 1;
    }
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(189724);
      return true;
      i = paramMotionEvent.getAction() >> 8;
      nativeOnTouchesBegin(paramMotionEvent.getPointerId(i), paramMotionEvent.getX(i), paramMotionEvent.getY(i), l);
      continue;
      nativeOnTouchesBegin(paramMotionEvent.getPointerId(0), arrayOfFloat1[0], arrayOfFloat2[0], l);
      continue;
      nativeOnTouchesMove(arrayOfInt, arrayOfFloat1, arrayOfFloat2, l);
      continue;
      i = paramMotionEvent.getAction() >> 8;
      nativeOnTouchesEnd(paramMotionEvent.getPointerId(i), paramMotionEvent.getX(i), paramMotionEvent.getY(i), l);
      continue;
      nativeOnTouchesEnd(paramMotionEvent.getPointerId(0), arrayOfFloat1[0], arrayOfFloat2[0], l);
      continue;
      nativeOnTouchesCancel(arrayOfInt, arrayOfFloat1, arrayOfFloat2, l);
    }
  }
  
  public void onVisibilityAggregated(boolean paramBoolean)
  {
    AppMethodBeat.i(189651);
    super.onVisibilityAggregated(paramBoolean);
    nativeOnVisibilityDidChange(paramBoolean);
    AppMethodBeat.o(189651);
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(189683);
    nativeOnSurfaceDidChange(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(189683);
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(189660);
    nativeOnSurfaceDidCreate(paramSurfaceHolder.getSurface());
    AppMethodBeat.o(189660);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(189671);
    nativeOnSurfaceDidDestroy();
    AppMethodBeat.o(189671);
  }
  
  public void teardown()
  {
    AppMethodBeat.i(189595);
    nativeTeardown();
    AppMethodBeat.o(189595);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.clipworks.displaysys.DSRenderView
 * JD-Core Version:    0.7.0.1
 */