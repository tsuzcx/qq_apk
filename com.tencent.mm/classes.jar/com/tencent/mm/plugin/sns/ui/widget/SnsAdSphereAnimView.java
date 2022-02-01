package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.widget.a.a;
import com.tencent.mm.plugin.sns.ad.widget.a.c;
import com.tencent.mm.plugin.sns.ad.widget.a.d;
import com.tencent.mm.plugin.sns.ad.widget.a.e;
import com.tencent.mm.plugin.sns.ad.widget.a.f;
import com.tencent.mm.sdk.platformtools.Log;

public class SnsAdSphereAnimView
  extends FrameLayout
{
  public static int LsX = 1;
  public static int LsY = 2;
  public static int LsZ = 3;
  public static int Lta = 4;
  public Handler JMp;
  public a Ltb;
  public int Ltc;
  public Context mContext;
  private long nTm;
  
  public SnsAdSphereAnimView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(179378);
    this.Ltc = 0;
    this.nTm = 0L;
    this.JMp = new Handler(Looper.getMainLooper());
    this.mContext = paramContext;
    AppMethodBeat.o(179378);
  }
  
  public SnsAdSphereAnimView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(179379);
    this.Ltc = 0;
    this.nTm = 0L;
    this.JMp = new Handler(Looper.getMainLooper());
    this.mContext = paramContext;
    AppMethodBeat.o(179379);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(179380);
    Log.i("SnsAdSphereAnimView", "clear");
    if (this.Ltb != null)
    {
      this.Ltb.clear();
      this.Ltb = null;
    }
    this.JMp.removeCallbacksAndMessages(null);
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