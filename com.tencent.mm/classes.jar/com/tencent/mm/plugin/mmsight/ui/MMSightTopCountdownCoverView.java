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
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.ui.aj;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class MMSightTopCountdownCoverView
  extends FrameLayout
{
  final ao mHandler;
  final View uSh;
  private final ImageView uSi;
  final TextView uSj;
  final TextView uSk;
  long uSl;
  long uSm;
  final Runnable uSn;
  final Runnable uSo;
  final ObjectAnimator uSp;
  
  public MMSightTopCountdownCoverView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(94569);
    this.mHandler = new ao(Looper.getMainLooper());
    this.uSn = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94567);
        MMSightTopCountdownCoverView.a(MMSightTopCountdownCoverView.this);
        AppMethodBeat.o(94567);
      }
    };
    this.uSo = new Runnable()
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
    this.uSh = findViewById(2131297932);
    this.uSi = ((ImageView)findViewById(2131298801));
    this.uSj = ((TextView)findViewById(2131298802));
    this.uSk = ((TextView)findViewById(2131298800));
    this.uSp = ObjectAnimator.ofFloat(this.uSi, "alpha", new float[] { 1.0F, 0.0F, 1.0F });
    this.uSp.setDuration(2000L);
    this.uSp.setInterpolator(new AccelerateInterpolator());
    this.uSp.setRepeatCount(-1);
    this.uSp.setRepeatMode(1);
    setBackgroundColor(Color.argb(Math.round(127.5F), 0, 0, 0));
    deu();
    setVisibility(8);
    AppMethodBeat.o(94569);
  }
  
  public MMSightTopCountdownCoverView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(94570);
    this.mHandler = new ao(Looper.getMainLooper());
    this.uSn = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94567);
        MMSightTopCountdownCoverView.a(MMSightTopCountdownCoverView.this);
        AppMethodBeat.o(94567);
      }
    };
    this.uSo = new Runnable()
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
    this.uSh = findViewById(2131297932);
    this.uSi = ((ImageView)findViewById(2131298801));
    this.uSj = ((TextView)findViewById(2131298802));
    this.uSk = ((TextView)findViewById(2131298800));
    this.uSp = ObjectAnimator.ofFloat(this.uSi, "alpha", new float[] { 1.0F, 0.0F, 1.0F });
    this.uSp.setDuration(2000L);
    this.uSp.setInterpolator(new AccelerateInterpolator());
    this.uSp.setRepeatCount(-1);
    this.uSp.setRepeatMode(1);
    setBackgroundColor(Color.argb(Math.round(127.5F), 0, 0, 0));
    deu();
    setVisibility(8);
    AppMethodBeat.o(94570);
  }
  
  private void deu()
  {
    AppMethodBeat.i(94571);
    Object localObject = getContext();
    if (!(localObject instanceof Activity))
    {
      AppMethodBeat.o(94571);
      return;
    }
    localObject = aj.bf((Activity)localObject);
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
  
  private void dex()
  {
    AppMethodBeat.i(94575);
    dew();
    this.uSp.cancel();
    AppMethodBeat.o(94575);
  }
  
  public final void dev()
  {
    AppMethodBeat.i(94572);
    if (this.uSm > 0L)
    {
      dex();
      this.uSi.setAlpha(1.0F);
      this.uSj.setText(String.format(Locale.US, "%02d:%02d", new Object[] { Integer.valueOf(0), Integer.valueOf(0) }));
      this.uSm = 0L;
      this.uSl = 0L;
    }
    AppMethodBeat.o(94572);
  }
  
  final void dew()
  {
    AppMethodBeat.i(94574);
    this.mHandler.removeCallbacks(this.uSo);
    this.mHandler.removeCallbacks(this.uSn);
    AppMethodBeat.o(94574);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(94573);
    super.onDetachedFromWindow();
    dex();
    AppMethodBeat.o(94573);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.MMSightTopCountdownCoverView
 * JD-Core Version:    0.7.0.1
 */