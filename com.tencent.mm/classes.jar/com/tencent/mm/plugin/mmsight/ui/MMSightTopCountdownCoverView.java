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
import com.tencent.mm.ui.aw;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class MMSightTopCountdownCoverView
  extends FrameLayout
{
  final View Lcr;
  private final ImageView Lcs;
  final TextView Lct;
  final TextView Lcu;
  long Lcv;
  long Lcw;
  final Runnable Lcx;
  final Runnable Lcy;
  final ObjectAnimator Lcz;
  final MMHandler mHandler;
  
  public MMSightTopCountdownCoverView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(94569);
    this.mHandler = new MMHandler(Looper.getMainLooper());
    this.Lcx = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94567);
        MMSightTopCountdownCoverView.a(MMSightTopCountdownCoverView.this);
        AppMethodBeat.o(94567);
      }
    };
    this.Lcy = new Runnable()
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
        MMSightTopCountdownCoverView.f(MMSightTopCountdownCoverView.this);
        AppMethodBeat.o(94568);
      }
    };
    LayoutInflater.from(getContext()).inflate(a.f.mmsight_record_top_countdown_cover, this, true);
    this.Lcr = findViewById(a.e.center_anchor);
    this.Lcs = ((ImageView)findViewById(a.e.countdown_reddot));
    this.Lct = ((TextView)findViewById(a.e.countdown_text));
    this.Lcu = ((TextView)findViewById(a.e.countdown_hint));
    this.Lcz = ObjectAnimator.ofFloat(this.Lcs, "alpha", new float[] { 1.0F, 0.0F, 1.0F });
    this.Lcz.setDuration(2000L);
    this.Lcz.setInterpolator(new AccelerateInterpolator());
    this.Lcz.setRepeatCount(-1);
    this.Lcz.setRepeatMode(1);
    setBackgroundColor(Color.argb(Math.round(127.5F), 0, 0, 0));
    gdf();
    setVisibility(8);
    AppMethodBeat.o(94569);
  }
  
  public MMSightTopCountdownCoverView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(94570);
    this.mHandler = new MMHandler(Looper.getMainLooper());
    this.Lcx = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94567);
        MMSightTopCountdownCoverView.a(MMSightTopCountdownCoverView.this);
        AppMethodBeat.o(94567);
      }
    };
    this.Lcy = new Runnable()
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
        MMSightTopCountdownCoverView.f(MMSightTopCountdownCoverView.this);
        AppMethodBeat.o(94568);
      }
    };
    LayoutInflater.from(getContext()).inflate(a.f.mmsight_record_top_countdown_cover, this, true);
    this.Lcr = findViewById(a.e.center_anchor);
    this.Lcs = ((ImageView)findViewById(a.e.countdown_reddot));
    this.Lct = ((TextView)findViewById(a.e.countdown_text));
    this.Lcu = ((TextView)findViewById(a.e.countdown_hint));
    this.Lcz = ObjectAnimator.ofFloat(this.Lcs, "alpha", new float[] { 1.0F, 0.0F, 1.0F });
    this.Lcz.setDuration(2000L);
    this.Lcz.setInterpolator(new AccelerateInterpolator());
    this.Lcz.setRepeatCount(-1);
    this.Lcz.setRepeatMode(1);
    setBackgroundColor(Color.argb(Math.round(127.5F), 0, 0, 0));
    gdf();
    setVisibility(8);
    AppMethodBeat.o(94570);
  }
  
  private void gdf()
  {
    AppMethodBeat.i(94571);
    Object localObject = getContext();
    if (!(localObject instanceof Activity))
    {
      AppMethodBeat.o(94571);
      return;
    }
    localObject = aw.bV((Activity)localObject);
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
  
  private void gdi()
  {
    AppMethodBeat.i(94575);
    gdh();
    this.Lcz.cancel();
    AppMethodBeat.o(94575);
  }
  
  public final void gdg()
  {
    AppMethodBeat.i(94572);
    if (this.Lcw > 0L)
    {
      gdi();
      this.Lcs.setAlpha(1.0F);
      this.Lct.setText(String.format(Locale.US, "%02d:%02d", new Object[] { Integer.valueOf(0), Integer.valueOf(0) }));
      this.Lcw = 0L;
      this.Lcv = 0L;
    }
    AppMethodBeat.o(94572);
  }
  
  final void gdh()
  {
    AppMethodBeat.i(94574);
    this.mHandler.removeCallbacks(this.Lcy);
    this.mHandler.removeCallbacks(this.Lcx);
    AppMethodBeat.o(94574);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(94573);
    super.onDetachedFromWindow();
    gdi();
    AppMethodBeat.o(94573);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.MMSightTopCountdownCoverView
 * JD-Core Version:    0.7.0.1
 */