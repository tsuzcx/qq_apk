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
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.ai;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class MMSightTopCountdownCoverView
  extends FrameLayout
{
  final ap mHandler;
  final TextView tJA;
  long tJB;
  long tJC;
  final Runnable tJD;
  final Runnable tJE;
  final ObjectAnimator tJF;
  final View tJx;
  private final ImageView tJy;
  final TextView tJz;
  
  public MMSightTopCountdownCoverView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(94569);
    this.mHandler = new ap(Looper.getMainLooper());
    this.tJD = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94567);
        MMSightTopCountdownCoverView.a(MMSightTopCountdownCoverView.this);
        AppMethodBeat.o(94567);
      }
    };
    this.tJE = new Runnable()
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
    LayoutInflater.from(getContext()).inflate(2131494917, this, true);
    this.tJx = findViewById(2131297932);
    this.tJy = ((ImageView)findViewById(2131298801));
    this.tJz = ((TextView)findViewById(2131298802));
    this.tJA = ((TextView)findViewById(2131298800));
    this.tJF = ObjectAnimator.ofFloat(this.tJy, "alpha", new float[] { 1.0F, 0.0F, 1.0F });
    this.tJF.setDuration(2000L);
    this.tJF.setInterpolator(new AccelerateInterpolator());
    this.tJF.setRepeatCount(-1);
    this.tJF.setRepeatMode(1);
    setBackgroundColor(Color.argb(Math.round(127.5F), 0, 0, 0));
    cQK();
    setVisibility(8);
    AppMethodBeat.o(94569);
  }
  
  public MMSightTopCountdownCoverView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(94570);
    this.mHandler = new ap(Looper.getMainLooper());
    this.tJD = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94567);
        MMSightTopCountdownCoverView.a(MMSightTopCountdownCoverView.this);
        AppMethodBeat.o(94567);
      }
    };
    this.tJE = new Runnable()
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
    LayoutInflater.from(getContext()).inflate(2131494917, this, true);
    this.tJx = findViewById(2131297932);
    this.tJy = ((ImageView)findViewById(2131298801));
    this.tJz = ((TextView)findViewById(2131298802));
    this.tJA = ((TextView)findViewById(2131298800));
    this.tJF = ObjectAnimator.ofFloat(this.tJy, "alpha", new float[] { 1.0F, 0.0F, 1.0F });
    this.tJF.setDuration(2000L);
    this.tJF.setInterpolator(new AccelerateInterpolator());
    this.tJF.setRepeatCount(-1);
    this.tJF.setRepeatMode(1);
    setBackgroundColor(Color.argb(Math.round(127.5F), 0, 0, 0));
    cQK();
    setVisibility(8);
    AppMethodBeat.o(94570);
  }
  
  private void cQK()
  {
    AppMethodBeat.i(94571);
    Object localObject = getContext();
    if (!(localObject instanceof Activity))
    {
      AppMethodBeat.o(94571);
      return;
    }
    localObject = ai.bb((Activity)localObject);
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
  
  private void cQN()
  {
    AppMethodBeat.i(94575);
    cQM();
    this.tJF.cancel();
    AppMethodBeat.o(94575);
  }
  
  public final void cQL()
  {
    AppMethodBeat.i(94572);
    if (this.tJC > 0L)
    {
      cQN();
      this.tJy.setAlpha(1.0F);
      this.tJz.setText(String.format(Locale.US, "%02d:%02d", new Object[] { Integer.valueOf(0), Integer.valueOf(0) }));
      this.tJC = 0L;
      this.tJB = 0L;
    }
    AppMethodBeat.o(94572);
  }
  
  final void cQM()
  {
    AppMethodBeat.i(94574);
    this.mHandler.removeCallbacks(this.tJE);
    this.mHandler.removeCallbacks(this.tJD);
    AppMethodBeat.o(94574);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(94573);
    super.onDetachedFromWindow();
    cQN();
    AppMethodBeat.o(94573);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.MMSightTopCountdownCoverView
 * JD-Core Version:    0.7.0.1
 */