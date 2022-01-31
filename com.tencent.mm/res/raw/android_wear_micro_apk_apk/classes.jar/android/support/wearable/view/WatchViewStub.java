package android.support.wearable.view;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.wearable.k;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;

@TargetApi(20)
public class WatchViewStub
  extends FrameLayout
{
  private boolean At;
  private int DQ;
  private int DR;
  private boolean DS;
  private boolean DT;
  private boolean DU;
  private w DV;
  
  public WatchViewStub(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public WatchViewStub(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public WatchViewStub(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, k.yf, 0, 0);
    this.DQ = paramContext.getResourceId(k.yg, 0);
    this.DR = paramContext.getResourceId(k.yh, 0);
    this.DS = true;
    paramContext.recycle();
  }
  
  private void fu()
  {
    removeAllViews();
    if ((this.DR == 0) && (!isInEditMode())) {
      throw new IllegalStateException("You must supply a roundLayout resource");
    }
    if ((this.DQ == 0) && (!isInEditMode())) {
      throw new IllegalStateException("You must supply a rectLayout resource");
    }
    if (this.At) {}
    for (int i = this.DR;; i = this.DQ)
    {
      LayoutInflater.from(getContext()).inflate(i, this);
      this.DS = false;
      if (this.DV != null) {
        this.DV.a(this);
      }
      return;
    }
  }
  
  public final void a(w paramw)
  {
    this.DV = paramw;
  }
  
  public WindowInsets onApplyWindowInsets(WindowInsets paramWindowInsets)
  {
    this.DT = true;
    boolean bool = paramWindowInsets.isRound();
    if (bool != this.At)
    {
      this.At = bool;
      this.DS = true;
    }
    if (this.DS) {
      fu();
    }
    return paramWindowInsets;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    Context localContext = getContext();
    boolean bool;
    if ((localContext instanceof Activity)) {
      if ((((Activity)localContext).getWindow().getAttributes().flags & 0x2000000) != 0) {
        bool = true;
      }
    }
    for (;;)
    {
      this.DU = bool;
      this.DT = false;
      requestApplyInsets();
      return;
      bool = false;
      continue;
      bool = false;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((this.DU) && (!this.DT)) {
      Log.w("WatchViewStub", "onApplyWindowInsets was not called. WatchViewStub should be the the root of your layout. If an OnApplyWindowInsetsListener was attached to this view, it must forward the insets on by calling view.onApplyWindowInsets.");
    }
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    if ((this.DS) && (!this.DU)) {
      fu();
    }
    super.onMeasure(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.wearable.view.WatchViewStub
 * JD-Core Version:    0.7.0.1
 */