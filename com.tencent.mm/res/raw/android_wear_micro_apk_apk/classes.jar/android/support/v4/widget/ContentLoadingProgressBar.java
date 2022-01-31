package android.support.v4.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;

public class ContentLoadingProgressBar
  extends ProgressBar
{
  boolean aF = false;
  long nU = -1L;
  boolean nV = false;
  boolean nW = false;
  private final Runnable nX = new Runnable()
  {
    public final void run()
    {
      ContentLoadingProgressBar.this.nV = false;
      ContentLoadingProgressBar.this.nU = -1L;
      ContentLoadingProgressBar.this.setVisibility(8);
    }
  };
  private final Runnable nY = new Runnable()
  {
    public final void run()
    {
      ContentLoadingProgressBar.this.nW = false;
      if (!ContentLoadingProgressBar.this.aF)
      {
        ContentLoadingProgressBar.this.nU = System.currentTimeMillis();
        ContentLoadingProgressBar.this.setVisibility(0);
      }
    }
  };
  
  public ContentLoadingProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
  }
  
  private void cb()
  {
    removeCallbacks(this.nX);
    removeCallbacks(this.nY);
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    cb();
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    cb();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.widget.ContentLoadingProgressBar
 * JD-Core Version:    0.7.0.1
 */