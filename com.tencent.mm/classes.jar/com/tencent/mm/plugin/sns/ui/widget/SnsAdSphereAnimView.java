package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.widget.a.a;
import com.tencent.mm.plugin.sns.ui.widget.a.f;
import com.tencent.mm.sdk.platformtools.ad;

public class SnsAdSphereAnimView
  extends View
{
  public static int xXr = 1;
  public static int xXs = 2;
  public static int xXt = 3;
  private long iYB;
  public Context mContext;
  public Handler xSa;
  public a xXu;
  public int xXv;
  private Runnable xXw;
  
  public SnsAdSphereAnimView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(179378);
    this.xXv = 0;
    this.iYB = 0L;
    this.xSa = new Handler(Looper.getMainLooper());
    this.xXw = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(179377);
        SnsAdSphereAnimView.this.invalidate();
        AppMethodBeat.o(179377);
      }
    };
    this.mContext = paramContext;
    AppMethodBeat.o(179378);
  }
  
  public SnsAdSphereAnimView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(179379);
    this.xXv = 0;
    this.iYB = 0L;
    this.xSa = new Handler(Looper.getMainLooper());
    this.xXw = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(179377);
        SnsAdSphereAnimView.this.invalidate();
        AppMethodBeat.o(179377);
      }
    };
    this.mContext = paramContext;
    AppMethodBeat.o(179379);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(179380);
    ad.i("SnsAdSphereAnimView", "clear");
    this.xSa.removeCallbacksAndMessages(null);
    if (this.xXu != null)
    {
      this.xXu.clear();
      this.xXu = null;
    }
    AppMethodBeat.o(179380);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(179381);
    super.onDetachedFromWindow();
    clear();
    AppMethodBeat.o(179381);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(179383);
    super.onDraw(paramCanvas);
    if (this.xXu != null)
    {
      this.xXu.draw(paramCanvas);
      long l1 = System.currentTimeMillis();
      long l2 = l1 - this.iYB;
      this.iYB = l1;
      if (l2 >= 16L)
      {
        invalidate();
        AppMethodBeat.o(179383);
        return;
      }
      this.xSa.postDelayed(this.xXw, 16L - l2);
    }
    AppMethodBeat.o(179383);
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(179382);
    super.setVisibility(paramInt);
    if (paramInt != 0) {
      this.xSa.removeCallbacksAndMessages(null);
    }
    AppMethodBeat.o(179382);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.SnsAdSphereAnimView
 * JD-Core Version:    0.7.0.1
 */