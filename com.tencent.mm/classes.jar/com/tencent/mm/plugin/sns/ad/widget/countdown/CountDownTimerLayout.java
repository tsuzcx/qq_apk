package com.tencent.mm.plugin.sns.ad.widget.countdown;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.i.e;
import com.tencent.mm.plugin.sns.ad.i.e.a;
import com.tencent.mm.plugin.sns.ad.i.m;
import com.tencent.mm.sdk.platformtools.Log;

public class CountDownTimerLayout
  extends LinearLayout
  implements LifecycleObserver, c
{
  private TextView DAi;
  private TextView DAj;
  private TextView DAk;
  private TextView DAl;
  private TextView DAm;
  private boolean DAn;
  private long DAo;
  private d DAp;
  private a DAq;
  
  public CountDownTimerLayout(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(202382);
    this.DAn = true;
    this.DAo = -1L;
    cMn();
    AppMethodBeat.o(202382);
  }
  
  public CountDownTimerLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(202383);
    this.DAn = true;
    this.DAo = -1L;
    cMn();
    AppMethodBeat.o(202383);
  }
  
  public CountDownTimerLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(202384);
    this.DAn = true;
    this.DAo = -1L;
    cMn();
    AppMethodBeat.o(202384);
  }
  
  public CountDownTimerLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    AppMethodBeat.i(202385);
    this.DAn = true;
    this.DAo = -1L;
    cMn();
    AppMethodBeat.o(202385);
  }
  
  private void cMn()
  {
    AppMethodBeat.i(202386);
    try
    {
      LayoutInflater.from(getContext()).inflate(2131496406, this);
      this.DAq = new a(this);
      this.DAi = ((TextView)findViewById(2131307981));
      this.DAj = ((TextView)findViewById(2131307980));
      this.DAk = ((TextView)findViewById(2131307982));
      this.DAl = ((TextView)findViewById(2131307983));
      this.DAm = ((TextView)findViewById(2131307984));
      AppMethodBeat.o(202386);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(202386);
    }
  }
  
  private static void e(TextView paramTextView, String paramString)
  {
    AppMethodBeat.i(202392);
    if (paramTextView != null) {
      paramTextView.setText(paramString);
    }
    AppMethodBeat.o(202392);
  }
  
  private void setDateTime(e.a parama)
  {
    AppMethodBeat.i(202391);
    if (parama == null)
    {
      Log.w("SnsAd.CountDownTimerLayout", "the date time is null!!");
      AppMethodBeat.o(202391);
      return;
    }
    if (parama.grV > 0)
    {
      m.u(this.DAj, true);
      m.u(this.DAi, true);
      e(this.DAj, String.valueOf(parama.grV));
    }
    for (;;)
    {
      e(this.DAk, e.XS(parama.hour));
      e(this.DAl, e.XS(parama.minute));
      e(this.DAm, e.XS(parama.second));
      AppMethodBeat.o(202391);
      return;
      m.u(this.DAj, false);
      m.u(this.DAi, false);
    }
  }
  
  public final void b(long paramLong, e.a parama)
  {
    AppMethodBeat.i(202393);
    try
    {
      this.DAo = paramLong;
      if ((isAttachedToWindow()) && (this.DAn)) {
        setDateTime(parama);
      }
      AppMethodBeat.o(202393);
      return;
    }
    catch (Throwable parama)
    {
      AppMethodBeat.o(202393);
    }
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
  public final void doPause(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(202389);
    try
    {
      Log.d("SnsAd.CountDownTimerLayout", "the doPause is called");
      this.DAn = false;
      AppMethodBeat.o(202389);
      return;
    }
    catch (Throwable paramLifecycleOwner)
    {
      AppMethodBeat.o(202389);
    }
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
  public final void doResume(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(202390);
    try
    {
      Log.d("SnsAd.CountDownTimerLayout", "the doResume is called");
      this.DAn = true;
      if ((!this.DAn) || (!isAttachedToWindow()))
      {
        AppMethodBeat.o(202390);
        return;
      }
      if (this.DAo >= 0L) {
        setDateTime(e.a(this.DAo, null));
      }
      AppMethodBeat.o(202390);
      return;
    }
    catch (Throwable paramLifecycleOwner)
    {
      AppMethodBeat.o(202390);
    }
  }
  
  public d getCountDownVM()
  {
    return this.DAp;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(202387);
    super.onAttachedToWindow();
    try
    {
      Context localContext = getContext();
      if ((localContext instanceof FragmentActivity)) {
        ((FragmentActivity)localContext).getLifecycle().addObserver(this);
      }
      AppMethodBeat.o(202387);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(202387);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(202388);
    super.onDetachedFromWindow();
    try
    {
      Object localObject = getContext();
      if ((localObject instanceof FragmentActivity)) {
        ((FragmentActivity)localObject).getLifecycle().removeObserver(this);
      }
      localObject = getCountDownVM();
      if (this.DAq != null) {
        a.a((d)localObject);
      }
      AppMethodBeat.o(202388);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(202388);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.countdown.CountDownTimerLayout
 * JD-Core Version:    0.7.0.1
 */