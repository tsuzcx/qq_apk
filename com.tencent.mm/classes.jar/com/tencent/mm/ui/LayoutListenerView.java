package com.tencent.mm.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class LayoutListenerView
  extends FrameLayout
{
  private String TAG;
  private byte[] adCK;
  private a adCL;
  private c adCM;
  private b adCN;
  
  public LayoutListenerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(141306);
    this.TAG = "MicroMsg.LayoutListenerView";
    this.adCK = new byte[0];
    AppMethodBeat.o(141306);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(141312);
    synchronized (this.adCK)
    {
      this.adCL = null;
      this.adCM = null;
      this.adCN = null;
      super.onDetachedFromWindow();
      AppMethodBeat.o(141312);
      return;
    }
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(141311);
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    Log.d(this.TAG, "jacks onInitializeAccessibilityEvent");
    AppMethodBeat.o(141311);
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    AppMethodBeat.i(141309);
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    Log.d(this.TAG, "jacks onInitializeAccessibilityNodeInfo");
    AppMethodBeat.o(141309);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(141307);
    byte[] arrayOfByte = this.adCK;
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    arrayOfByte = this.adCK;
    AppMethodBeat.o(141307);
  }
  
  public void onPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(141310);
    super.onPopulateAccessibilityEvent(paramAccessibilityEvent);
    Log.d(this.TAG, "jacks onPopulateAccessibilityEvent");
    AppMethodBeat.o(141310);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(141308);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    synchronized (this.adCK)
    {
      if (this.adCM != null) {
        this.adCM.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
      }
      AppMethodBeat.o(141308);
      return;
    }
  }
  
  public void setOnLayoutListener(a parama)
  {
    synchronized (this.adCK)
    {
      this.adCL = parama;
      return;
    }
  }
  
  public void setOnPreLayoutListener(b paramb)
  {
    synchronized (this.adCK)
    {
      this.adCN = paramb;
      return;
    }
  }
  
  public void setOnResizedListener(c paramc)
  {
    synchronized (this.adCK)
    {
      this.adCM = paramc;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.LayoutListenerView
 * JD-Core Version:    0.7.0.1
 */