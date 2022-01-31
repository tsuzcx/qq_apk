package android.support.wearable.view;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.wearable.d;
import android.support.wearable.g;
import android.support.wearable.i;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.TextView;

@TargetApi(20)
public class DismissOverlayView
  extends FrameLayout
{
  private SharedPreferences BO;
  private boolean BP = true;
  private TextView BQ;
  private View BR;
  
  public DismissOverlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public DismissOverlayView(final Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(paramContext).inflate(i.wH, this, true);
    setBackgroundResource(d.we);
    setClickable(true);
    if (!isInEditMode())
    {
      this.BO = paramContext.getSharedPreferences("android.support.wearable.DismissOverlay", 0);
      this.BP = this.BO.getBoolean("first_run", true);
    }
    this.BQ = ((TextView)findViewById(g.wA));
    this.BR = findViewById(g.wz);
    this.BR.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        if ((paramContext instanceof Activity)) {
          ((Activity)paramContext).finish();
        }
      }
    });
    setVisibility(8);
  }
  
  public boolean performClick()
  {
    super.performClick();
    animate().alpha(0.0F).setDuration(200L).withEndAction(new Runnable()
    {
      public final void run()
      {
        DismissOverlayView.this.setVisibility(8);
        DismissOverlayView.this.setAlpha(1.0F);
      }
    }).start();
    if (this.BP)
    {
      this.BP = false;
      this.BO.edit().putBoolean("first_run", false).apply();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.wearable.view.DismissOverlayView
 * JD-Core Version:    0.7.0.1
 */