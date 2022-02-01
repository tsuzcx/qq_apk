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
import com.tencent.mm.ui.al;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class MMSightTopCountdownCoverView
  extends FrameLayout
{
  final ap mHandler;
  final View vVq;
  private final ImageView vVr;
  final TextView vVs;
  final TextView vVt;
  long vVu;
  long vVv;
  final Runnable vVw;
  final Runnable vVx;
  final ObjectAnimator vVy;
  
  public MMSightTopCountdownCoverView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(94569);
    this.mHandler = new ap(Looper.getMainLooper());
    this.vVw = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94567);
        MMSightTopCountdownCoverView.a(MMSightTopCountdownCoverView.this);
        AppMethodBeat.o(94567);
      }
    };
    this.vVx = new Runnable()
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
    this.vVq = findViewById(2131297932);
    this.vVr = ((ImageView)findViewById(2131298801));
    this.vVs = ((TextView)findViewById(2131298802));
    this.vVt = ((TextView)findViewById(2131298800));
    this.vVy = ObjectAnimator.ofFloat(this.vVr, "alpha", new float[] { 1.0F, 0.0F, 1.0F });
    this.vVy.setDuration(2000L);
    this.vVy.setInterpolator(new AccelerateInterpolator());
    this.vVy.setRepeatCount(-1);
    this.vVy.setRepeatMode(1);
    setBackgroundColor(Color.argb(Math.round(127.5F), 0, 0, 0));
    dnS();
    setVisibility(8);
    AppMethodBeat.o(94569);
  }
  
  public MMSightTopCountdownCoverView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(94570);
    this.mHandler = new ap(Looper.getMainLooper());
    this.vVw = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94567);
        MMSightTopCountdownCoverView.a(MMSightTopCountdownCoverView.this);
        AppMethodBeat.o(94567);
      }
    };
    this.vVx = new Runnable()
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
    this.vVq = findViewById(2131297932);
    this.vVr = ((ImageView)findViewById(2131298801));
    this.vVs = ((TextView)findViewById(2131298802));
    this.vVt = ((TextView)findViewById(2131298800));
    this.vVy = ObjectAnimator.ofFloat(this.vVr, "alpha", new float[] { 1.0F, 0.0F, 1.0F });
    this.vVy.setDuration(2000L);
    this.vVy.setInterpolator(new AccelerateInterpolator());
    this.vVy.setRepeatCount(-1);
    this.vVy.setRepeatMode(1);
    setBackgroundColor(Color.argb(Math.round(127.5F), 0, 0, 0));
    dnS();
    setVisibility(8);
    AppMethodBeat.o(94570);
  }
  
  private void dnS()
  {
    AppMethodBeat.i(94571);
    Object localObject = getContext();
    if (!(localObject instanceof Activity))
    {
      AppMethodBeat.o(94571);
      return;
    }
    localObject = al.bf((Activity)localObject);
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
  
  private void dnV()
  {
    AppMethodBeat.i(94575);
    dnU();
    this.vVy.cancel();
    AppMethodBeat.o(94575);
  }
  
  public final void dnT()
  {
    AppMethodBeat.i(94572);
    if (this.vVv > 0L)
    {
      dnV();
      this.vVr.setAlpha(1.0F);
      this.vVs.setText(String.format(Locale.US, "%02d:%02d", new Object[] { Integer.valueOf(0), Integer.valueOf(0) }));
      this.vVv = 0L;
      this.vVu = 0L;
    }
    AppMethodBeat.o(94572);
  }
  
  final void dnU()
  {
    AppMethodBeat.i(94574);
    this.mHandler.removeCallbacks(this.vVx);
    this.mHandler.removeCallbacks(this.vVw);
    AppMethodBeat.o(94574);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(94573);
    super.onDetachedFromWindow();
    dnV();
    AppMethodBeat.o(94573);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.MMSightTopCountdownCoverView
 * JD-Core Version:    0.7.0.1
 */