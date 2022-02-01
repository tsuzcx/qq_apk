package android.support.v4.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;

public class ContentLoadingProgressBar
  extends ProgressBar
{
  boolean co = false;
  long pI = -1L;
  boolean pJ = false;
  boolean pK = false;
  private final Runnable pL = new Runnable()
  {
    public final void run()
    {
      ContentLoadingProgressBar.this.pJ = false;
      ContentLoadingProgressBar.this.pI = -1L;
      ContentLoadingProgressBar.this.setVisibility(8);
    }
  };
  private final Runnable pM = new Runnable()
  {
    public final void run()
    {
      ContentLoadingProgressBar.this.pK = false;
      if (!ContentLoadingProgressBar.this.co)
      {
        ContentLoadingProgressBar.this.pI = System.currentTimeMillis();
        ContentLoadingProgressBar.this.setVisibility(0);
      }
    }
  };
  
  public ContentLoadingProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
  }
  
  private void cf()
  {
    removeCallbacks(this.pL);
    removeCallbacks(this.pM);
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    cf();
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    cf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.widget.ContentLoadingProgressBar
 * JD-Core Version:    0.7.0.1
 */