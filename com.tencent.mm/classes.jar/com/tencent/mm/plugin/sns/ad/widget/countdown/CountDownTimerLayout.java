package com.tencent.mm.plugin.sns.ad.widget.countdown;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.h;
import androidx.lifecycle.h.a;
import androidx.lifecycle.k;
import androidx.lifecycle.t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.i.f;
import com.tencent.mm.plugin.sns.ad.i.f.a;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.sdk.platformtools.Log;

public class CountDownTimerLayout
  extends LinearLayout
  implements k, c
{
  private TextView JLL;
  private TextView JLM;
  private TextView JLN;
  private TextView JLO;
  private TextView JLP;
  private boolean JLQ;
  private long JLR;
  private d JLS;
  private a JLT;
  
  public CountDownTimerLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(207314);
    this.JLQ = true;
    this.JLR = -1L;
    dbb();
    AppMethodBeat.o(207314);
  }
  
  public CountDownTimerLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(207316);
    this.JLQ = true;
    this.JLR = -1L;
    dbb();
    AppMethodBeat.o(207316);
  }
  
  private void dbb()
  {
    AppMethodBeat.i(207317);
    try
    {
      LayoutInflater.from(getContext()).inflate(i.g.sns_ad_timeline_countdown_view, this);
      this.JLT = new a(this);
      this.JLL = ((TextView)findViewById(i.f.sns_ad_countdown_day_unit));
      this.JLM = ((TextView)findViewById(i.f.sns_ad_countdown_day));
      this.JLN = ((TextView)findViewById(i.f.sns_ad_countdown_hour));
      this.JLO = ((TextView)findViewById(i.f.sns_ad_countdown_minute));
      this.JLP = ((TextView)findViewById(i.f.sns_ad_countdown_second));
      AppMethodBeat.o(207317);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(207317);
    }
  }
  
  private static void f(TextView paramTextView, String paramString)
  {
    AppMethodBeat.i(207323);
    if (paramTextView != null) {
      paramTextView.setText(paramString);
    }
    AppMethodBeat.o(207323);
  }
  
  private void setDateTime(f.a parama)
  {
    AppMethodBeat.i(207322);
    if (parama == null)
    {
      Log.w("SnsAd.CountDownTimerLayout", "the date time is null!!");
      AppMethodBeat.o(207322);
      return;
    }
    if (parama.day > 0)
    {
      com.tencent.mm.plugin.sns.ad.i.l.w(this.JLM, true);
      com.tencent.mm.plugin.sns.ad.i.l.w(this.JLL, true);
      f(this.JLM, String.valueOf(parama.day));
    }
    for (;;)
    {
      f(this.JLN, f.afg(parama.hour));
      f(this.JLO, f.afg(parama.JLz));
      f(this.JLP, f.afg(parama.second));
      AppMethodBeat.o(207322);
      return;
      com.tencent.mm.plugin.sns.ad.i.l.w(this.JLM, false);
      com.tencent.mm.plugin.sns.ad.i.l.w(this.JLL, false);
    }
  }
  
  public final void b(long paramLong, f.a parama)
  {
    AppMethodBeat.i(207324);
    try
    {
      this.JLR = paramLong;
      if ((isAttachedToWindow()) && (this.JLQ)) {
        setDateTime(parama);
      }
      AppMethodBeat.o(207324);
      return;
    }
    catch (Throwable parama)
    {
      AppMethodBeat.o(207324);
    }
  }
  
  @t(jl=h.a.ON_STOP)
  public final void doPause(androidx.lifecycle.l paraml)
  {
    AppMethodBeat.i(207320);
    try
    {
      Log.d("SnsAd.CountDownTimerLayout", "the doPause is called");
      this.JLQ = false;
      AppMethodBeat.o(207320);
      return;
    }
    catch (Throwable paraml)
    {
      AppMethodBeat.o(207320);
    }
  }
  
  @t(jl=h.a.ON_RESUME)
  public final void doResume(androidx.lifecycle.l paraml)
  {
    AppMethodBeat.i(207321);
    try
    {
      Log.d("SnsAd.CountDownTimerLayout", "the doResume is called");
      this.JLQ = true;
      if ((!this.JLQ) || (!isAttachedToWindow()))
      {
        AppMethodBeat.o(207321);
        return;
      }
      if (this.JLR >= 0L) {
        setDateTime(f.a(this.JLR, null));
      }
      AppMethodBeat.o(207321);
      return;
    }
    catch (Throwable paraml)
    {
      AppMethodBeat.o(207321);
    }
  }
  
  public d getCountDownVM()
  {
    return this.JLS;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(207318);
    super.onAttachedToWindow();
    try
    {
      Context localContext = getContext();
      if ((localContext instanceof FragmentActivity)) {
        ((FragmentActivity)localContext).getLifecycle().a(this);
      }
      AppMethodBeat.o(207318);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(207318);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(207319);
    super.onDetachedFromWindow();
    try
    {
      Object localObject = getContext();
      if ((localObject instanceof FragmentActivity)) {
        ((FragmentActivity)localObject).getLifecycle().b(this);
      }
      localObject = getCountDownVM();
      if (this.JLT != null) {
        a.a((d)localObject);
      }
      AppMethodBeat.o(207319);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(207319);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.countdown.CountDownTimerLayout
 * JD-Core Version:    0.7.0.1
 */