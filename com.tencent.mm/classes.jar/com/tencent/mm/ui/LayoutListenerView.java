package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

public class LayoutListenerView
  extends FrameLayout
{
  private byte[] JuC;
  private a JuD;
  private c JuE;
  private b JuF;
  private String TAG;
  
  public LayoutListenerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(141306);
    this.TAG = "MicroMsg.LayoutListenerView";
    this.JuC = new byte[0];
    AppMethodBeat.o(141306);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(141312);
    synchronized (this.JuC)
    {
      this.JuD = null;
      this.JuE = null;
      this.JuF = null;
      super.onDetachedFromWindow();
      AppMethodBeat.o(141312);
      return;
    }
  }
  
  @TargetApi(14)
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(141311);
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    ae.d(this.TAG, "jacks onInitializeAccessibilityEvent");
    AppMethodBeat.o(141311);
  }
  
  @TargetApi(14)
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    AppMethodBeat.i(141309);
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    ae.d(this.TAG, "jacks onInitializeAccessibilityNodeInfo");
    AppMethodBeat.o(141309);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(141307);
    synchronized (this.JuC)
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    AppMethodBeat.o(141307);
    throw localObject1;
    localObject2 = finally;
    AppMethodBeat.o(141307);
    throw localObject2;
  }
  
  @TargetApi(14)
  public void onPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(141310);
    super.onPopulateAccessibilityEvent(paramAccessibilityEvent);
    ae.d(this.TAG, "jacks onPopulateAccessibilityEvent");
    AppMethodBeat.o(141310);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(141308);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    synchronized (this.JuC)
    {
      if (this.JuE != null) {
        this.JuE.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
      }
      AppMethodBeat.o(141308);
      return;
    }
  }
  
  public void setOnLayoutListener(a parama)
  {
    synchronized (this.JuC)
    {
      this.JuD = parama;
      return;
    }
  }
  
  public void setOnPreLayoutListener(b paramb)
  {
    synchronized (this.JuC)
    {
      this.JuF = paramb;
      return;
    }
  }
  
  public void setOnResizedListener(c paramc)
  {
    synchronized (this.JuC)
    {
      this.JuE = paramc;
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