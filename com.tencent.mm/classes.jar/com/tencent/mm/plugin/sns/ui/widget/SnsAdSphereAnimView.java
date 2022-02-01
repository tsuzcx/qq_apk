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
import com.tencent.mm.plugin.sns.ui.widget.a.e;
import com.tencent.mm.plugin.sns.ui.widget.a.g;
import com.tencent.mm.sdk.platformtools.ac;

public class SnsAdSphereAnimView
  extends View
{
  public static int zkm = 1;
  public static int zkn = 2;
  public static int zko = 3;
  public static int zkp = 4;
  private long jyR;
  public Context mContext;
  public Handler zeV;
  public a zkq;
  public int zkr;
  private Runnable zks;
  
  public SnsAdSphereAnimView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(179378);
    this.zkr = 0;
    this.jyR = 0L;
    this.zeV = new Handler(Looper.getMainLooper());
    this.zks = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(200661);
        SnsAdSphereAnimView.this.invalidate();
        AppMethodBeat.o(200661);
      }
    };
    this.mContext = paramContext;
    AppMethodBeat.o(179378);
  }
  
  public SnsAdSphereAnimView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(179379);
    this.zkr = 0;
    this.jyR = 0L;
    this.zeV = new Handler(Looper.getMainLooper());
    this.zks = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(200661);
        SnsAdSphereAnimView.this.invalidate();
        AppMethodBeat.o(200661);
      }
    };
    this.mContext = paramContext;
    AppMethodBeat.o(179379);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(179380);
    ac.i("SnsAdSphereAnimView", "clear");
    this.zeV.removeCallbacksAndMessages(null);
    if (this.zkq != null)
    {
      this.zkq.clear();
      this.zkq = null;
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
    if (this.zkq != null)
    {
      this.zkq.draw(paramCanvas);
      long l1 = System.currentTimeMillis();
      long l2 = l1 - this.jyR;
      this.jyR = l1;
      if (l2 >= 16L)
      {
        invalidate();
        AppMethodBeat.o(179383);
        return;
      }
      this.zeV.postDelayed(this.zks, 16L - l2);
    }
    AppMethodBeat.o(179383);
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(179382);
    super.setVisibility(paramInt);
    if (paramInt != 0) {
      this.zeV.removeCallbacksAndMessages(null);
    }
    AppMethodBeat.o(179382);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.SnsAdSphereAnimView
 * JD-Core Version:    0.7.0.1
 */