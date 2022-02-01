package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.g.a.a;
import com.tencent.mm.plugin.sns.ad.g.a.c;
import com.tencent.mm.plugin.sns.ad.g.a.d;
import com.tencent.mm.plugin.sns.ad.g.a.e;
import com.tencent.mm.plugin.sns.ad.g.a.f;
import com.tencent.mm.sdk.platformtools.ae;

public class SnsAdSphereAnimView
  extends FrameLayout
{
  public static int ATM = 1;
  public static int ATN = 2;
  public static int ATO = 3;
  public static int ATP = 4;
  public Handler AOj;
  public a ATQ;
  public int ATR;
  private long jWf;
  public Context mContext;
  
  public SnsAdSphereAnimView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(179378);
    this.ATR = 0;
    this.jWf = 0L;
    this.AOj = new Handler(Looper.getMainLooper());
    this.mContext = paramContext;
    AppMethodBeat.o(179378);
  }
  
  public SnsAdSphereAnimView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(179379);
    this.ATR = 0;
    this.jWf = 0L;
    this.AOj = new Handler(Looper.getMainLooper());
    this.mContext = paramContext;
    AppMethodBeat.o(179379);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(179380);
    ae.i("SnsAdSphereAnimView", "clear");
    if (this.ATQ != null)
    {
      this.ATQ.clear();
      this.ATQ = null;
    }
    this.AOj.removeCallbacksAndMessages(null);
    AppMethodBeat.o(179380);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(179381);
    super.onDetachedFromWindow();
    clear();
    AppMethodBeat.o(179381);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.SnsAdSphereAnimView
 * JD-Core Version:    0.7.0.1
 */