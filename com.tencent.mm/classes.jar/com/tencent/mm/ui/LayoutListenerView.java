package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public class LayoutListenerView
  extends FrameLayout
{
  private String TAG;
  private byte[] yZZ;
  private a zaa;
  private c zab;
  private b zac;
  boolean zad;
  private MotionEvent zae;
  
  public LayoutListenerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(105976);
    this.TAG = "MicroMsg.LayoutListenerView";
    this.yZZ = new byte[0];
    this.zad = false;
    AppMethodBeat.o(105976);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(142715);
    int k;
    if (this.zad)
    {
      int i = paramMotionEvent.getPointerCount();
      int j = paramMotionEvent.getAction();
      k = j & 0xFF;
      ab.d(this.TAG, "dispatchTouchEvent, pointerCount %d, action %d, actionMasked %d.", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
      if (k != 0) {
        break label89;
      }
      this.zae = paramMotionEvent;
    }
    for (;;)
    {
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(142715);
      return bool;
      label89:
      if ((5 == k) && (this.zae != null))
      {
        long l = SystemClock.uptimeMillis();
        MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 2, -100.0F, this.zae.getY(), 0);
        localMotionEvent.setSource(4098);
        super.dispatchTouchEvent(localMotionEvent);
        paramMotionEvent.setAction(1);
      }
    }
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(105982);
    synchronized (this.yZZ)
    {
      this.zaa = null;
      this.zab = null;
      this.zac = null;
      super.onDetachedFromWindow();
      AppMethodBeat.o(105982);
      return;
    }
  }
  
  @TargetApi(14)
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(105981);
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    ab.d(this.TAG, "jacks onInitializeAccessibilityEvent");
    AppMethodBeat.o(105981);
  }
  
  @TargetApi(14)
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    AppMethodBeat.i(105979);
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    ab.d(this.TAG, "jacks onInitializeAccessibilityNodeInfo");
    AppMethodBeat.o(105979);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(105977);
    synchronized (this.yZZ)
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    AppMethodBeat.o(105977);
    throw localObject1;
    localObject2 = finally;
    AppMethodBeat.o(105977);
    throw localObject2;
  }
  
  @TargetApi(14)
  public void onPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(105980);
    super.onPopulateAccessibilityEvent(paramAccessibilityEvent);
    ab.d(this.TAG, "jacks onPopulateAccessibilityEvent");
    AppMethodBeat.o(105980);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(105978);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    synchronized (this.yZZ)
    {
      if (this.zab != null) {
        this.zab.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
      }
      AppMethodBeat.o(105978);
      return;
    }
  }
  
  public void setOnLayoutListener(a parama)
  {
    synchronized (this.yZZ)
    {
      this.zaa = parama;
      return;
    }
  }
  
  public void setOnPreLayoutListener(b paramb)
  {
    synchronized (this.yZZ)
    {
      this.zac = paramb;
      return;
    }
  }
  
  public void setOnResizedListener(c paramc)
  {
    synchronized (this.yZZ)
    {
      this.zab = paramc;
      return;
    }
  }
  
  public static abstract interface a {}
  
  public static abstract interface b {}
  
  public static abstract interface c
  {
    public abstract void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.LayoutListenerView
 * JD-Core Version:    0.7.0.1
 */