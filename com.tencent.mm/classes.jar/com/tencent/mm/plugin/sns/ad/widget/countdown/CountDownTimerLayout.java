package com.tencent.mm.plugin.sns.ad.widget.countdown;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.j;
import androidx.lifecycle.j.a;
import androidx.lifecycle.p;
import androidx.lifecycle.q;
import androidx.lifecycle.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.j.f;
import com.tencent.mm.plugin.sns.ad.j.f.a;
import com.tencent.mm.plugin.sns.ad.j.l;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.sdk.platformtools.Log;

public class CountDownTimerLayout
  extends LinearLayout
  implements p, c
{
  private TextView Qfm;
  private TextView Qfn;
  private TextView Qfo;
  private TextView Qfp;
  private TextView Qfq;
  private boolean Qfr;
  private long Qfs;
  private d Qft;
  private a Qfu;
  
  public CountDownTimerLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(310398);
    this.Qfr = true;
    this.Qfs = -1L;
    dHA();
    AppMethodBeat.o(310398);
  }
  
  public CountDownTimerLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(310411);
    this.Qfr = true;
    this.Qfs = -1L;
    dHA();
    AppMethodBeat.o(310411);
  }
  
  private void dHA()
  {
    AppMethodBeat.i(310421);
    try
    {
      LayoutInflater.from(getContext()).inflate(b.g.sns_ad_timeline_countdown_view, this);
      this.Qfu = new a(this);
      this.Qfm = ((TextView)findViewById(b.f.sns_ad_countdown_day_unit));
      this.Qfn = ((TextView)findViewById(b.f.sns_ad_countdown_day));
      this.Qfo = ((TextView)findViewById(b.f.sns_ad_countdown_hour));
      this.Qfp = ((TextView)findViewById(b.f.sns_ad_countdown_minute));
      this.Qfq = ((TextView)findViewById(b.f.sns_ad_countdown_second));
      return;
    }
    finally
    {
      AppMethodBeat.o(310421);
    }
  }
  
  private static void f(TextView paramTextView, String paramString)
  {
    AppMethodBeat.i(310440);
    if (paramTextView != null) {
      paramTextView.setText(paramString);
    }
    AppMethodBeat.o(310440);
  }
  
  private void setDateTime(f.a parama)
  {
    AppMethodBeat.i(310431);
    if (parama == null)
    {
      Log.w("SnsAd.CountDownTimerLayout", "the date time is null!!");
      AppMethodBeat.o(310431);
      return;
    }
    if (parama.day > 0)
    {
      l.C(this.Qfn, true);
      l.C(this.Qfm, true);
      f(this.Qfn, String.valueOf(parama.day));
    }
    for (;;)
    {
      f(this.Qfo, f.ajP(parama.hour));
      f(this.Qfp, f.ajP(parama.Qdm));
      f(this.Qfq, f.ajP(parama.second));
      AppMethodBeat.o(310431);
      return;
      l.C(this.Qfn, false);
      l.C(this.Qfm, false);
    }
  }
  
  public final void b(long paramLong, f.a parama)
  {
    AppMethodBeat.i(310494);
    try
    {
      this.Qfs = paramLong;
      if ((isAttachedToWindow()) && (this.Qfr)) {
        setDateTime(parama);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(310494);
    }
  }
  
  @z(Ho=j.a.ON_STOP)
  public final void doPause(q paramq)
  {
    AppMethodBeat.i(310477);
    try
    {
      Log.d("SnsAd.CountDownTimerLayout", "the doPause is called");
      this.Qfr = false;
      return;
    }
    finally
    {
      AppMethodBeat.o(310477);
    }
  }
  
  @z(Ho=j.a.ON_RESUME)
  public final void doResume(q paramq)
  {
    AppMethodBeat.i(310485);
    try
    {
      Log.d("SnsAd.CountDownTimerLayout", "the doResume is called");
      this.Qfr = true;
      if ((!this.Qfr) || (!isAttachedToWindow())) {
        return;
      }
      if (this.Qfs >= 0L) {
        setDateTime(f.a(this.Qfs, null));
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(310485);
    }
  }
  
  public d getCountDownVM()
  {
    return this.Qft;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(310446);
    super.onAttachedToWindow();
    try
    {
      Context localContext = getContext();
      if ((localContext instanceof FragmentActivity)) {
        ((FragmentActivity)localContext).getLifecycle().addObserver(this);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(310446);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(310460);
    super.onDetachedFromWindow();
    try
    {
      Object localObject1 = getContext();
      if ((localObject1 instanceof FragmentActivity)) {
        ((FragmentActivity)localObject1).getLifecycle().removeObserver(this);
      }
      localObject1 = getCountDownVM();
      if (this.Qfu != null) {
        a.a((d)localObject1);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(310460);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.countdown.CountDownTimerLayout
 * JD-Core Version:    0.7.0.1
 */