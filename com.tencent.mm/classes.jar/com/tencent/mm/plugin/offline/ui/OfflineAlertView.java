package com.tencent.mm.plugin.offline.ui;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ax.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.v;

public class OfflineAlertView
  extends LinearLayout
{
  private View contentView;
  ViewGroup hSI;
  com.tencent.mm.pluginsdk.ui.span.h mYs;
  public int ukO;
  boolean ukP;
  private a ukQ;
  CountDownTimer ukR;
  
  public OfflineAlertView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(66351);
    this.ukO = 0;
    this.contentView = null;
    this.hSI = null;
    this.ukP = true;
    this.ukQ = null;
    init();
    AppMethodBeat.o(66351);
  }
  
  public OfflineAlertView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(66352);
    this.ukO = 0;
    this.contentView = null;
    this.hSI = null;
    this.ukP = true;
    this.ukQ = null;
    init();
    AppMethodBeat.o(66352);
  }
  
  private void init()
  {
    AppMethodBeat.i(66353);
    this.contentView = LayoutInflater.from(getContext()).inflate(2131495983, this);
    this.hSI = ((ViewGroup)this.contentView.findViewById(2131302988));
    AppMethodBeat.o(66353);
  }
  
  public final boolean II(int paramInt)
  {
    AppMethodBeat.i(66360);
    if (isShowing())
    {
      if (paramInt == this.ukO)
      {
        AppMethodBeat.o(66360);
        return true;
      }
      if ((paramInt == 2) && ((this.ukO == 3) || (this.ukO == 4) || (this.ukO == 2) || (this.ukO == 5)))
      {
        AppMethodBeat.o(66360);
        return true;
      }
      if ((paramInt == 5) && (this.ukO == 4))
      {
        AppMethodBeat.o(66360);
        return true;
      }
      if (paramInt == 6)
      {
        AppMethodBeat.o(66360);
        return true;
      }
      if (paramInt == 7)
      {
        AppMethodBeat.o(66360);
        return true;
      }
      AppMethodBeat.o(66360);
      return false;
    }
    AppMethodBeat.o(66360);
    return true;
  }
  
  public final void a(View paramView, View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(66356);
    a(paramView, paramOnClickListener, 6);
    AppMethodBeat.o(66356);
  }
  
  final void a(final View paramView, View.OnClickListener paramOnClickListener, int paramInt)
  {
    AppMethodBeat.i(66357);
    this.ukO = paramInt;
    setVisibility(0);
    this.hSI.removeAllViews();
    View localView = LayoutInflater.from(getContext()).inflate(2131495995, null);
    if (paramInt == 6) {
      ((TextView)localView.findViewById(2131296636)).setText(2131761790);
    }
    for (;;)
    {
      ViewGroup localViewGroup = (ViewGroup)localView.findViewById(2131304275);
      if (localViewGroup != null) {
        localViewGroup.setOnClickListener(new OfflineAlertView.11(this, paramView));
      }
      this.hSI.addView(localView);
      ((Button)this.contentView.findViewById(2131300871)).setOnClickListener(paramOnClickListener);
      this.ukP = false;
      paramView.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(66349);
          ad.i("MicroMsg.OfflineAlertView", "qrCodeView.getHeight%s %s", new Object[] { Integer.valueOf(paramView.getHeight()), Integer.valueOf(paramView.getMeasuredHeight()) });
          FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)OfflineAlertView.a(OfflineAlertView.this).getLayoutParams();
          if (paramView.getHeight() > 0)
          {
            localLayoutParams.height = paramView.getHeight();
            OfflineAlertView.a(OfflineAlertView.this).setLayoutParams(localLayoutParams);
            OfflineAlertView.a(OfflineAlertView.this).invalidate();
          }
          if (OfflineAlertView.b(OfflineAlertView.this) != null) {
            OfflineAlertView.b(OfflineAlertView.this).onShow();
          }
          AppMethodBeat.o(66349);
        }
      });
      AppMethodBeat.o(66357);
      return;
      if (((paramInt == 3) || (paramInt == 1)) && (b.yL((String)g.afB().afk().get(274436, null)))) {
        ((TextView)localView.findViewById(2131296636)).setText(2131761799);
      }
    }
  }
  
  public final void a(final View paramView, final Runnable paramRunnable1, final Runnable paramRunnable2)
  {
    AppMethodBeat.i(66354);
    setVisibility(0);
    this.hSI.removeAllViews();
    View localView = LayoutInflater.from(getContext()).inflate(2131495992, null);
    this.hSI.addView(localView);
    paramView.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(66342);
        OfflineAlertView.a(OfflineAlertView.this, paramView, paramRunnable1, paramRunnable2, this.val$type);
        AppMethodBeat.o(66342);
      }
    });
    AppMethodBeat.o(66354);
  }
  
  public final void b(final View paramView, View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(66358);
    this.ukO = 5;
    setVisibility(0);
    this.ukP = false;
    this.hSI.removeAllViews();
    View localView = LayoutInflater.from(getContext()).inflate(2131495995, null);
    this.hSI.addView(localView);
    ((TextView)localView.findViewById(2131296636)).setText(2131761787);
    Button localButton = (Button)localView.findViewById(2131300871);
    localButton.setText(2131761786);
    localButton.setOnClickListener(paramOnClickListener);
    paramOnClickListener = (ViewGroup)localView.findViewById(2131304275);
    if (paramOnClickListener != null) {
      paramOnClickListener.setVisibility(8);
    }
    paramView.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(66350);
        ad.i("MicroMsg.OfflineAlertView", "qrCodeView.getHeight%s %s", new Object[] { Integer.valueOf(paramView.getHeight()), Integer.valueOf(paramView.getMeasuredHeight()) });
        FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)OfflineAlertView.a(OfflineAlertView.this).getLayoutParams();
        if (paramView.getHeight() > 0)
        {
          localLayoutParams.height = paramView.getHeight();
          OfflineAlertView.a(OfflineAlertView.this).setLayoutParams(localLayoutParams);
          OfflineAlertView.a(OfflineAlertView.this).invalidate();
        }
        if (OfflineAlertView.b(OfflineAlertView.this) != null) {
          OfflineAlertView.b(OfflineAlertView.this).onShow();
        }
        AppMethodBeat.o(66350);
      }
    });
    AppMethodBeat.o(66358);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(66361);
    if (this.hSI != null) {
      this.hSI.removeAllViews();
    }
    setVisibility(8);
    if (this.ukQ != null) {
      this.ukQ.onClose();
    }
    if (this.ukR != null) {
      this.ukR.cancel();
    }
    if (this.mYs != null) {
      k.b(this.mYs);
    }
    this.ukO = 0;
    this.ukP = true;
    AppMethodBeat.o(66361);
  }
  
  public final void ee(final View paramView)
  {
    AppMethodBeat.i(66355);
    setVisibility(0);
    this.hSI.removeAllViews();
    View localView = LayoutInflater.from(getContext()).inflate(2131495989, null);
    this.hSI.addView(localView);
    com.tencent.mm.plugin.report.service.h.vKh.f(13750, new Object[] { Integer.valueOf(1) });
    paramView.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(66343);
        OfflineAlertView.a(OfflineAlertView.this, paramView, this.val$type);
        AppMethodBeat.o(66343);
      }
    });
    AppMethodBeat.o(66355);
  }
  
  public final boolean isShowing()
  {
    AppMethodBeat.i(66359);
    if (getVisibility() == 0)
    {
      AppMethodBeat.o(66359);
      return true;
    }
    AppMethodBeat.o(66359);
    return false;
  }
  
  public void setBlurDockerView(ViewGroup paramViewGroup) {}
  
  public void setDialogState(a parama)
  {
    this.ukQ = parama;
  }
  
  public static abstract interface a
  {
    public abstract void onClose();
    
    public abstract void onShow();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.OfflineAlertView
 * JD-Core Version:    0.7.0.1
 */