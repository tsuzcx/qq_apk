package com.tencent.mm.plugin.mmsight.ui;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.Locale;

public class MMSightTopCountdownCoverView
  extends FrameLayout
{
  final ak mHandler;
  final View oOp;
  private final ImageView oOq;
  final TextView oOr;
  final TextView oOs;
  long oOt;
  long oOu;
  final Runnable oOv;
  final Runnable oOw;
  final ObjectAnimator oOx;
  
  public MMSightTopCountdownCoverView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(140580);
    this.mHandler = new ak(Looper.getMainLooper());
    this.oOv = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(140578);
        MMSightTopCountdownCoverView.a(MMSightTopCountdownCoverView.this);
        AppMethodBeat.o(140578);
      }
    };
    this.oOw = new MMSightTopCountdownCoverView.2(this);
    LayoutInflater.from(getContext()).inflate(2130970285, this, true);
    this.oOp = findViewById(2131826287);
    this.oOq = ((ImageView)findViewById(2131826289));
    this.oOr = ((TextView)findViewById(2131826288));
    this.oOs = ((TextView)findViewById(2131826290));
    this.oOx = ObjectAnimator.ofFloat(this.oOq, "alpha", new float[] { 1.0F, 0.0F, 1.0F });
    this.oOx.setDuration(2000L);
    this.oOx.setInterpolator(new AccelerateInterpolator());
    this.oOx.setRepeatCount(-1);
    this.oOx.setRepeatMode(1);
    setBackgroundColor(Color.argb(Math.round(127.5F), 0, 0, 0));
    setVisibility(8);
    AppMethodBeat.o(140580);
  }
  
  public MMSightTopCountdownCoverView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(140581);
    this.mHandler = new ak(Looper.getMainLooper());
    this.oOv = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(140578);
        MMSightTopCountdownCoverView.a(MMSightTopCountdownCoverView.this);
        AppMethodBeat.o(140578);
      }
    };
    this.oOw = new MMSightTopCountdownCoverView.2(this);
    LayoutInflater.from(getContext()).inflate(2130970285, this, true);
    this.oOp = findViewById(2131826287);
    this.oOq = ((ImageView)findViewById(2131826289));
    this.oOr = ((TextView)findViewById(2131826288));
    this.oOs = ((TextView)findViewById(2131826290));
    this.oOx = ObjectAnimator.ofFloat(this.oOq, "alpha", new float[] { 1.0F, 0.0F, 1.0F });
    this.oOx.setDuration(2000L);
    this.oOx.setInterpolator(new AccelerateInterpolator());
    this.oOx.setRepeatCount(-1);
    this.oOx.setRepeatMode(1);
    setBackgroundColor(Color.argb(Math.round(127.5F), 0, 0, 0));
    setVisibility(8);
    AppMethodBeat.o(140581);
  }
  
  private void bRS()
  {
    AppMethodBeat.i(140585);
    bRR();
    this.oOx.cancel();
    AppMethodBeat.o(140585);
  }
  
  public final void bRQ()
  {
    AppMethodBeat.i(140582);
    if (this.oOu > 0L)
    {
      bRS();
      this.oOq.setAlpha(1.0F);
      this.oOr.setText(String.format(Locale.US, "%02d:%02d", new Object[] { Integer.valueOf(0), Integer.valueOf(0) }));
      this.oOu = 0L;
      this.oOt = 0L;
    }
    AppMethodBeat.o(140582);
  }
  
  final void bRR()
  {
    AppMethodBeat.i(140584);
    this.mHandler.removeCallbacks(this.oOw);
    this.mHandler.removeCallbacks(this.oOv);
    AppMethodBeat.o(140584);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(140583);
    super.onDetachedFromWindow();
    bRS();
    AppMethodBeat.o(140583);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.MMSightTopCountdownCoverView
 * JD-Core Version:    0.7.0.1
 */