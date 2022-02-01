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
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.ao;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class MMSightTopCountdownCoverView
  extends FrameLayout
{
  final MMHandler mHandler;
  final View zBU;
  private final ImageView zBV;
  final TextView zBW;
  final TextView zBX;
  long zBY;
  long zBZ;
  final Runnable zCa;
  final Runnable zCb;
  final ObjectAnimator zCc;
  
  public MMSightTopCountdownCoverView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(94569);
    this.mHandler = new MMHandler(Looper.getMainLooper());
    this.zCa = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94567);
        MMSightTopCountdownCoverView.a(MMSightTopCountdownCoverView.this);
        AppMethodBeat.o(94567);
      }
    };
    this.zCb = new Runnable()
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
    LayoutInflater.from(getContext()).inflate(2131495657, this, true);
    this.zBU = findViewById(2131298251);
    this.zBV = ((ImageView)findViewById(2131299264));
    this.zBW = ((TextView)findViewById(2131299265));
    this.zBX = ((TextView)findViewById(2131299261));
    this.zCc = ObjectAnimator.ofFloat(this.zBV, "alpha", new float[] { 1.0F, 0.0F, 1.0F });
    this.zCc.setDuration(2000L);
    this.zCc.setInterpolator(new AccelerateInterpolator());
    this.zCc.setRepeatCount(-1);
    this.zCc.setRepeatMode(1);
    setBackgroundColor(Color.argb(Math.round(127.5F), 0, 0, 0));
    ekK();
    setVisibility(8);
    AppMethodBeat.o(94569);
  }
  
  public MMSightTopCountdownCoverView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(94570);
    this.mHandler = new MMHandler(Looper.getMainLooper());
    this.zCa = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94567);
        MMSightTopCountdownCoverView.a(MMSightTopCountdownCoverView.this);
        AppMethodBeat.o(94567);
      }
    };
    this.zCb = new Runnable()
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
    LayoutInflater.from(getContext()).inflate(2131495657, this, true);
    this.zBU = findViewById(2131298251);
    this.zBV = ((ImageView)findViewById(2131299264));
    this.zBW = ((TextView)findViewById(2131299265));
    this.zBX = ((TextView)findViewById(2131299261));
    this.zCc = ObjectAnimator.ofFloat(this.zBV, "alpha", new float[] { 1.0F, 0.0F, 1.0F });
    this.zCc.setDuration(2000L);
    this.zCc.setInterpolator(new AccelerateInterpolator());
    this.zCc.setRepeatCount(-1);
    this.zCc.setRepeatMode(1);
    setBackgroundColor(Color.argb(Math.round(127.5F), 0, 0, 0));
    ekK();
    setVisibility(8);
    AppMethodBeat.o(94570);
  }
  
  private void ekK()
  {
    AppMethodBeat.i(94571);
    Object localObject = getContext();
    if (!(localObject instanceof Activity))
    {
      AppMethodBeat.o(94571);
      return;
    }
    localObject = ao.bl((Activity)localObject);
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
  
  private void ekN()
  {
    AppMethodBeat.i(94575);
    ekM();
    this.zCc.cancel();
    AppMethodBeat.o(94575);
  }
  
  public final void ekL()
  {
    AppMethodBeat.i(94572);
    if (this.zBZ > 0L)
    {
      ekN();
      this.zBV.setAlpha(1.0F);
      this.zBW.setText(String.format(Locale.US, "%02d:%02d", new Object[] { Integer.valueOf(0), Integer.valueOf(0) }));
      this.zBZ = 0L;
      this.zBY = 0L;
    }
    AppMethodBeat.o(94572);
  }
  
  final void ekM()
  {
    AppMethodBeat.i(94574);
    this.mHandler.removeCallbacks(this.zCb);
    this.mHandler.removeCallbacks(this.zCa);
    AppMethodBeat.o(94574);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(94573);
    super.onDetachedFromWindow();
    ekN();
    AppMethodBeat.o(94573);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.MMSightTopCountdownCoverView
 * JD-Core Version:    0.7.0.1
 */