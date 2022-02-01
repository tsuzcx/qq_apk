package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.f.a.a;
import com.tencent.mm.plugin.sns.ad.f.a.c;
import com.tencent.mm.plugin.sns.ad.f.a.d;
import com.tencent.mm.plugin.sns.ad.f.a.e;
import com.tencent.mm.plugin.sns.ad.f.a.f;
import com.tencent.mm.sdk.platformtools.ad;

public class SnsAdSphereAnimView
  extends FrameLayout
{
  public static int ACl = 1;
  public static int ACm = 2;
  public static int ACn = 3;
  public static int ACo = 4;
  public a ACp;
  public int ACq;
  public Handler AwR;
  private long jSO;
  public Context mContext;
  
  public SnsAdSphereAnimView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(179378);
    this.ACq = 0;
    this.jSO = 0L;
    this.AwR = new Handler(Looper.getMainLooper());
    this.mContext = paramContext;
    AppMethodBeat.o(179378);
  }
  
  public SnsAdSphereAnimView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(179379);
    this.ACq = 0;
    this.jSO = 0L;
    this.AwR = new Handler(Looper.getMainLooper());
    this.mContext = paramContext;
    AppMethodBeat.o(179379);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(179380);
    ad.i("SnsAdSphereAnimView", "clear");
    if (this.ACp != null)
    {
      this.ACp.clear();
      this.ACp = null;
    }
    this.AwR.removeCallbacksAndMessages(null);
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