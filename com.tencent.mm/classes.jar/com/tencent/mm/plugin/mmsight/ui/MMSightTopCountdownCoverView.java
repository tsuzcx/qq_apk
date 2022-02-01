package com.tencent.mm.plugin.mmsight.ui;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.w.a.e;
import com.tencent.mm.plugin.w.a.f;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.ar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class MMSightTopCountdownCoverView
  extends FrameLayout
{
  final View FgQ;
  private final ImageView FgR;
  final TextView FgS;
  final TextView FgT;
  long FgU;
  long FgV;
  final Runnable FgW;
  final Runnable FgX;
  final ObjectAnimator FgY;
  final MMHandler mHandler;
  
  public MMSightTopCountdownCoverView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(94569);
    this.mHandler = new MMHandler(Looper.getMainLooper());
    this.FgW = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94567);
        MMSightTopCountdownCoverView.a(MMSightTopCountdownCoverView.this);
        AppMethodBeat.o(94567);
      }
    };
    this.FgX = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94568);
        long l2 = MMSightTopCountdownCoverView.b(MMSightTopCountdownCoverView.this) - 400L - MMSightTopCountdownCoverView.c(MMSightTopCountdownCoverView.this);
        long l1 = l2 / TimeUnit.MINUTES.toMillis(1L);
        l2 = Math.max(Math.round(l2 % TimeUnit.MINUTES.toMillis(1L) / TimeUnit.SECONDS.toMillis(1L)), 0L);
        String str = String.format(Locale.US, "%02d:%02d", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
        MMSightTopCountdownCoverView.d(MMSightTopCountdownCoverView.this).setText(str);
        MMSightTopCountdownCoverView.e(MMSightTopCountdownCoverView.this).postDelayed(this, 1000L);
        MMSightTopCountdownCoverView.a(MMSightTopCountdownCoverView.this, MMSightTopCountdownCoverView.c(MMSightTopCountdownCoverView.this) + 1000L);
        AppMethodBeat.o(94568);
      }
    };
    LayoutInflater.from(getContext()).inflate(a.f.mmsight_record_top_countdown_cover, this, true);
    this.FgQ = findViewById(a.e.center_anchor);
    this.FgR = ((ImageView)findViewById(a.e.countdown_reddot));
    this.FgS = ((TextView)findViewById(a.e.countdown_text));
    this.FgT = ((TextView)findViewById(a.e.countdown_hint));
    this.FgY = ObjectAnimator.ofFloat(this.FgR, "alpha", new float[] { 1.0F, 0.0F, 1.0F });
    this.FgY.setDuration(2000L);
    this.FgY.setInterpolator(new AccelerateInterpolator());
    this.FgY.setRepeatCount(-1);
    this.FgY.setRepeatMode(1);
    setBackgroundColor(Color.argb(Math.round(127.5F), 0, 0, 0));
    eUt();
    setVisibility(8);
    AppMethodBeat.o(94569);
  }
  
  public MMSightTopCountdownCoverView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(94570);
    this.mHandler = new MMHandler(Looper.getMainLooper());
    this.FgW = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94567);
        MMSightTopCountdownCoverView.a(MMSightTopCountdownCoverView.this);
        AppMethodBeat.o(94567);
      }
    };
    this.FgX = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94568);
        long l2 = MMSightTopCountdownCoverView.b(MMSightTopCountdownCoverView.this) - 400L - MMSightTopCountdownCoverView.c(MMSightTopCountdownCoverView.this);
        long l1 = l2 / TimeUnit.MINUTES.toMillis(1L);
        l2 = Math.max(Math.round(l2 % TimeUnit.MINUTES.toMillis(1L) / TimeUnit.SECONDS.toMillis(1L)), 0L);
        String str = String.format(Locale.US, "%02d:%02d", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
        MMSightTopCountdownCoverView.d(MMSightTopCountdownCoverView.this).setText(str);
        MMSightTopCountdownCoverView.e(MMSightTopCountdownCoverView.this).postDelayed(this, 1000L);
        MMSightTopCountdownCoverView.a(MMSightTopCountdownCoverView.this, MMSightTopCountdownCoverView.c(MMSightTopCountdownCoverView.this) + 1000L);
        AppMethodBeat.o(94568);
      }
    };
    LayoutInflater.from(getContext()).inflate(a.f.mmsight_record_top_countdown_cover, this, true);
    this.FgQ = findViewById(a.e.center_anchor);
    this.FgR = ((ImageView)findViewById(a.e.countdown_reddot));
    this.FgS = ((TextView)findViewById(a.e.countdown_text));
    this.FgT = ((TextView)findViewById(a.e.countdown_hint));
    this.FgY = ObjectAnimator.ofFloat(this.FgR, "alpha", new float[] { 1.0F, 0.0F, 1.0F });
    this.FgY.setDuration(2000L);
    this.FgY.setInterpolator(new AccelerateInterpolator());
    this.FgY.setRepeatCount(-1);
    this.FgY.setRepeatMode(1);
    setBackgroundColor(Color.argb(Math.round(127.5F), 0, 0, 0));
    eUt();
    setVisibility(8);
    AppMethodBeat.o(94570);
  }
  
  private void eUt()
  {
    AppMethodBeat.i(94571);
    Object localObject = getContext();
    if (!(localObject instanceof Activity))
    {
      AppMethodBeat.o(94571);
      return;
    }
    localObject = ar.br((Activity)localObject);
    int j = getPaddingLeft();
    if (localObject != null) {
      i = getPaddingTop();
    }
    for (int i = ((Rect)localObject).top + i;; i = getPaddingTop())
    {
      setPadding(j, i, getPaddingRight(), getPaddingBottom());
      AppMethodBeat.o(94571);
      return;
    }
  }
  
  private void eUw()
  {
    AppMethodBeat.i(94575);
    eUv();
    this.FgY.cancel();
    AppMethodBeat.o(94575);
  }
  
  public final void eUu()
  {
    AppMethodBeat.i(94572);
    if (this.FgV > 0L)
    {
      eUw();
      this.FgR.setAlpha(1.0F);
      this.FgS.setText(String.format(Locale.US, "%02d:%02d", new Object[] { Integer.valueOf(0), Integer.valueOf(0) }));
      this.FgV = 0L;
      this.FgU = 0L;
    }
    AppMethodBeat.o(94572);
  }
  
  final void eUv()
  {
    AppMethodBeat.i(94574);
    this.mHandler.removeCallbacks(this.FgX);
    this.mHandler.removeCallbacks(this.FgW);
    AppMethodBeat.o(94574);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(94573);
    super.onDetachedFromWindow();
    eUw();
    AppMethodBeat.o(94573);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.MMSightTopCountdownCoverView
 * JD-Core Version:    0.7.0.1
 */