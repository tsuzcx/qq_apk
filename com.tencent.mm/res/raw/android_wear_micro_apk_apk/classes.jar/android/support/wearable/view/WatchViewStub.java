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
  private boolean Ci;
  private int FF;
  private int FG;
  private boolean FH;
  private boolean FI;
  private boolean FJ;
  private w FK;
  
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
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, k.zU, 0, 0);
    this.FF = paramContext.getResourceId(k.zV, 0);
    this.FG = paramContext.getResourceId(k.zW, 0);
    this.FH = true;
    paramContext.recycle();
  }
  
  private void fD()
  {
    removeAllViews();
    if ((this.FG == 0) && (!isInEditMode())) {
      throw new IllegalStateException("You must supply a roundLayout resource");
    }
    if ((this.FF == 0) && (!isInEditMode())) {
      throw new IllegalStateException("You must supply a rectLayout resource");
    }
    if (this.Ci) {}
    for (int i = this.FG;; i = this.FF)
    {
      LayoutInflater.from(getContext()).inflate(i, this);
      this.FH = false;
      if (this.FK != null) {
        this.FK.a(this);
      }
      return;
    }
  }
  
  public final void a(w paramw)
  {
    this.FK = paramw;
  }
  
  public WindowInsets onApplyWindowInsets(WindowInsets paramWindowInsets)
  {
    this.FI = true;
    boolean bool = paramWindowInsets.isRound();
    if (bool != this.Ci)
    {
      this.Ci = bool;
      this.FH = true;
    }
    if (this.FH) {
      fD();
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
      this.FJ = bool;
      this.FI = false;
      requestApplyInsets();
      return;
      bool = false;
      continue;
      bool = false;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((this.FJ) && (!this.FI)) {
      Log.w("WatchViewStub", "onApplyWindowInsets was not called. WatchViewStub should be the the root of your layout. If an OnApplyWindowInsetsListener was attached to this view, it must forward the insets on by calling view.onApplyWindowInsets.");
    }
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    if ((this.FH) && (!this.FJ)) {
      fD();
    }
    super.onMeasure(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.wearable.view.WatchViewStub
 * JD-Core Version:    0.7.0.1
 */