package android.support.wearable.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.wearable.k;
import android.util.AttributeSet;
import android.view.MotionEvent;

@TargetApi(20)
public class DelayedConfirmationView
  extends CircledImageView
{
  private long DA;
  private Handler DB = new Handler()
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      DelayedConfirmationView.a(DelayedConfirmationView.this, SystemClock.elapsedRealtime());
      DelayedConfirmationView.this.invalidate();
      if (DelayedConfirmationView.a(DelayedConfirmationView.this) - DelayedConfirmationView.b(DelayedConfirmationView.this) < DelayedConfirmationView.c(DelayedConfirmationView.this)) {
        DelayedConfirmationView.e(DelayedConfirmationView.this).sendEmptyMessageDelayed(0, DelayedConfirmationView.d(DelayedConfirmationView.this));
      }
      while ((DelayedConfirmationView.b(DelayedConfirmationView.this) <= 0L) || (DelayedConfirmationView.f(DelayedConfirmationView.this) == null)) {
        return;
      }
      DelayedConfirmationView.f(DelayedConfirmationView.this).fk();
    }
  };
  private long Dw;
  private long Dx = 0L;
  private g Dy;
  private long Dz;
  
  public DelayedConfirmationView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public DelayedConfirmationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public DelayedConfirmationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, k.zC, paramInt, 0);
    this.Dx = paramContext.getInteger(k.zD, 33);
    setProgress(0.0F);
    paramContext.recycle();
  }
  
  public final void a(g paramg)
  {
    this.Dy = paramg;
  }
  
  public final void fj()
  {
    this.Dw = 5000L;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.Dz > 0L) {
      setProgress((float)(this.DA - this.Dz) / (float)this.Dw);
    }
    super.onDraw(paramCanvas);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return false;
      if (this.Dy != null) {
        this.Dy.fl();
      }
    }
  }
  
  public final void start()
  {
    this.Dz = SystemClock.elapsedRealtime();
    this.DA = SystemClock.elapsedRealtime();
    this.DB.sendEmptyMessageDelayed(0, this.Dx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.wearable.view.DelayedConfirmationView
 * JD-Core Version:    0.7.0.1
 */