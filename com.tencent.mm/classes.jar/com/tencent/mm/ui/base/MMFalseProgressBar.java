package com.tencent.mm.ui.base;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.y;

public class MMFalseProgressBar
  extends ProgressBar
{
  private float St = 0.0F;
  private boolean bnh = false;
  private ah mHandler = new MMFalseProgressBar.1(this, Looper.getMainLooper());
  private float uUE;
  private float uUF;
  private float uUG;
  private float uUH;
  public boolean uUI = true;
  
  public MMFalseProgressBar(Context paramContext)
  {
    this(paramContext, null);
    cAF();
  }
  
  public MMFalseProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MMFalseProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setMax(1000);
    cAF();
  }
  
  private void cAF()
  {
    if (aq.fK(ae.getContext()))
    {
      this.uUE = 4.0F;
      this.uUF = 1.0F;
      this.uUG = 0.3F;
      this.uUH = 50.0F;
      return;
    }
    this.uUE = 2.0F;
    this.uUF = 0.5F;
    this.uUG = 0.15F;
    this.uUH = 50.0F;
  }
  
  public final void finish()
  {
    y.d("MicroMsg.MMFalseProgressBar", "[cpan] finish");
    if (this.mHandler != null) {
      this.mHandler.sendEmptyMessage(1002);
    }
  }
  
  public final void start()
  {
    y.d("MicroMsg.MMFalseProgressBar", "[cpan] start");
    if (!this.uUI) {}
    do
    {
      do
      {
        return;
      } while (this.bnh);
      this.bnh = true;
      cAF();
    } while (this.mHandler == null);
    this.mHandler.sendEmptyMessage(1000);
    this.mHandler.sendEmptyMessage(1001);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMFalseProgressBar
 * JD-Core Version:    0.7.0.1
 */