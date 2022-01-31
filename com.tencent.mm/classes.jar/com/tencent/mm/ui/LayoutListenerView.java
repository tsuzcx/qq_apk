package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import com.tencent.mm.sdk.platformtools.y;

public class LayoutListenerView
  extends FrameLayout
{
  private String TAG = "MicroMsg.LayoutListenerView";
  private byte[] uLU = new byte[0];
  private a uLV;
  private c uLW;
  private b uLX;
  
  public LayoutListenerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onDetachedFromWindow()
  {
    synchronized (this.uLU)
    {
      this.uLV = null;
      this.uLW = null;
      this.uLX = null;
      super.onDetachedFromWindow();
      return;
    }
  }
  
  @TargetApi(14)
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    y.d(this.TAG, "jacks onInitializeAccessibilityEvent");
  }
  
  @TargetApi(14)
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    y.d(this.TAG, "jacks onInitializeAccessibilityNodeInfo");
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    synchronized (this.uLU)
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    throw localObject2;
  }
  
  @TargetApi(14)
  public void onPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onPopulateAccessibilityEvent(paramAccessibilityEvent);
    y.d(this.TAG, "jacks onPopulateAccessibilityEvent");
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    synchronized (this.uLU)
    {
      if (this.uLW != null) {
        this.uLW.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
      }
      return;
    }
  }
  
  public void setOnLayoutListener(a parama)
  {
    synchronized (this.uLU)
    {
      this.uLV = parama;
      return;
    }
  }
  
  public void setOnPreLayoutListener(b paramb)
  {
    synchronized (this.uLU)
    {
      this.uLX = paramb;
      return;
    }
  }
  
  public void setOnResizedListener(c paramc)
  {
    synchronized (this.uLU)
    {
      this.uLW = paramc;
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