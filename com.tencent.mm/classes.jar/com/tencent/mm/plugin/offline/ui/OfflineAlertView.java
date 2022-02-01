package com.tencent.mm.plugin.offline.ui;

import android.content.Context;
import android.content.res.Resources;
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
import com.tencent.mm.aw.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.plugin.wallet_core.model.r.a;
import com.tencent.mm.pluginsdk.ui.span.h;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.aj;
import com.tencent.mm.ui.w;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Iterator;
import java.util.List;

public class OfflineAlertView
  extends LinearLayout
{
  private View contentView;
  ViewGroup iOJ;
  h ohO;
  public int wON;
  boolean wOO;
  private a wOP;
  CountDownTimer wOQ;
  
  public OfflineAlertView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(66351);
    this.wON = 0;
    this.contentView = null;
    this.iOJ = null;
    this.wOO = true;
    this.wOP = null;
    init();
    AppMethodBeat.o(66351);
  }
  
  public OfflineAlertView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(66352);
    this.wON = 0;
    this.contentView = null;
    this.iOJ = null;
    this.wOO = true;
    this.wOP = null;
    init();
    AppMethodBeat.o(66352);
  }
  
  private static r.a a(r paramr, String paramString)
  {
    AppMethodBeat.i(189946);
    paramr = paramr.Dpk.iterator();
    while (paramr.hasNext())
    {
      r.a locala = (r.a)paramr.next();
      if (locala.language.equals(paramString))
      {
        AppMethodBeat.o(189946);
        return locala;
      }
    }
    AppMethodBeat.o(189946);
    return null;
  }
  
  private void init()
  {
    AppMethodBeat.i(66353);
    this.contentView = LayoutInflater.from(getContext()).inflate(2131495983, this);
    this.iOJ = ((ViewGroup)this.contentView.findViewById(2131302988));
    this.iOJ.setOnTouchListener(new OfflineAlertView.1(this));
    AppMethodBeat.o(66353);
  }
  
  public final boolean MO(int paramInt)
  {
    AppMethodBeat.i(66360);
    if (isShowing())
    {
      if (paramInt == this.wON)
      {
        AppMethodBeat.o(66360);
        return true;
      }
      if ((paramInt == 2) && ((this.wON == 3) || (this.wON == 4) || (this.wON == 2) || (this.wON == 5)))
      {
        AppMethodBeat.o(66360);
        return true;
      }
      if ((paramInt == 5) && (this.wON == 4))
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
      if ((paramInt == 8) && ((this.wON == 5) || (this.wON == 4) || (this.wON == 2)))
      {
        AppMethodBeat.o(66360);
        return true;
      }
      if (paramInt == 3)
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
    this.wON = paramInt;
    setVisibility(0);
    this.iOJ.removeAllViews();
    View localView = LayoutInflater.from(getContext()).inflate(2131495995, null);
    if (paramInt == 6) {
      ((TextView)localView.findViewById(2131296636)).setText(2131761790);
    }
    for (;;)
    {
      ViewGroup localViewGroup = (ViewGroup)localView.findViewById(2131304275);
      if (localViewGroup != null) {
        localViewGroup.setOnClickListener(new OfflineAlertView.15(this, paramView));
      }
      this.iOJ.addView(localView);
      ((Button)this.contentView.findViewById(2131300871)).setOnClickListener(paramOnClickListener);
      this.wOO = false;
      paramView.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(66350);
          ae.i("MicroMsg.OfflineAlertView", "qrCodeView.getHeight%s %s", new Object[] { Integer.valueOf(paramView.getHeight()), Integer.valueOf(paramView.getMeasuredHeight()) });
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
      AppMethodBeat.o(66357);
      return;
      if (((paramInt == 3) || (paramInt == 1)) && (b.Gw((String)com.tencent.mm.kernel.g.ajR().ajA().get(274436, null)))) {
        ((TextView)localView.findViewById(2131296636)).setText(2131761799);
      }
    }
  }
  
  public final void a(final View paramView, r paramr)
  {
    AppMethodBeat.i(189945);
    this.wON = 8;
    setVisibility(0);
    this.wOO = false;
    this.iOJ.removeAllViews();
    Object localObject = LayoutInflater.from(getContext()).inflate(2131495990, this.iOJ, false);
    this.iOJ.addView((View)localObject);
    TextView localTextView1 = (TextView)((View)localObject).findViewById(2131302001);
    TextView localTextView2 = (TextView)((View)localObject).findViewById(2131305510);
    Button localButton = (Button)((View)localObject).findViewById(2131300871);
    localObject = (WeImageView)((View)localObject).findViewById(2131300901);
    ((WeImageView)localObject).setImageResource(2131690585);
    ((WeImageView)localObject).setIconColor(getResources().getColor(2131101127));
    localObject = ad.iR(ak.getContext());
    if ((((String)localObject).equals("zh_CN")) || (((String)localObject).equals("zh_HK")) || (((String)localObject).equals("zh_TW"))) {}
    for (localObject = a(paramr, (String)localObject);; localObject = a(paramr, "en"))
    {
      if (localObject != null)
      {
        localTextView1.setText(((r.a)localObject).Dpf);
        localTextView2.setText(((r.a)localObject).Dpg);
        localButton.setText(((r.a)localObject).Dpl);
      }
      localButton.setTextColor(getResources().getColor(2131100161));
      localButton.setBackgroundResource(2131231365);
      localButton.setOnClickListener(new OfflineAlertView.7(this, paramr));
      paramView.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(189939);
          ae.i("MicroMsg.OfflineAlertView", "qrCodeView.getHeight%s %s", new Object[] { Integer.valueOf(paramView.getHeight()), Integer.valueOf(paramView.getMeasuredHeight()) });
          FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)OfflineAlertView.a(OfflineAlertView.this).getLayoutParams();
          if (paramView.getHeight() > 0)
          {
            localLayoutParams.height = paramView.getHeight();
            OfflineAlertView.a(OfflineAlertView.this).setLayoutParams(localLayoutParams);
          }
          if (OfflineAlertView.b(OfflineAlertView.this) != null) {
            OfflineAlertView.b(OfflineAlertView.this).onShow();
          }
          AppMethodBeat.o(189939);
        }
      });
      AppMethodBeat.o(189945);
      return;
    }
  }
  
  public final void a(final View paramView, final Runnable paramRunnable1, final Runnable paramRunnable2)
  {
    AppMethodBeat.i(66354);
    this.wON = 2;
    setVisibility(0);
    this.iOJ.removeAllViews();
    View localView = LayoutInflater.from(getContext()).inflate(2131495992, null);
    this.iOJ.addView(localView);
    paramView.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(66343);
        OfflineAlertView.a(OfflineAlertView.this, paramView, paramRunnable1, paramRunnable2);
        AppMethodBeat.o(66343);
      }
    });
    AppMethodBeat.o(66354);
  }
  
  public final void b(final View paramView, View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(66358);
    this.wON = 5;
    setVisibility(0);
    this.wOO = false;
    this.iOJ.removeAllViews();
    View localView = LayoutInflater.from(getContext()).inflate(2131495995, null);
    this.iOJ.addView(localView);
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
        AppMethodBeat.i(189932);
        ae.i("MicroMsg.OfflineAlertView", "qrCodeView.getHeight%s %s", new Object[] { Integer.valueOf(paramView.getHeight()), Integer.valueOf(paramView.getMeasuredHeight()) });
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
        AppMethodBeat.o(189932);
      }
    });
    AppMethodBeat.o(66358);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(66361);
    if (this.iOJ != null) {
      this.iOJ.removeAllViews();
    }
    setVisibility(8);
    if (this.wOP != null) {
      this.wOP.onClose();
    }
    if (this.wOQ != null) {
      this.wOQ.cancel();
    }
    if (this.ohO != null) {
      k.b(this.ohO);
    }
    this.wON = 0;
    this.wOO = true;
    AppMethodBeat.o(66361);
  }
  
  public final void ew(final View paramView)
  {
    AppMethodBeat.i(66355);
    setVisibility(0);
    this.iOJ.removeAllViews();
    View localView = LayoutInflater.from(getContext()).inflate(2131495989, null);
    this.iOJ.addView(localView);
    com.tencent.mm.plugin.report.service.g.yxI.f(13750, new Object[] { Integer.valueOf(1) });
    this.wON = 4;
    paramView.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(189940);
        OfflineAlertView.a(OfflineAlertView.this, paramView);
        AppMethodBeat.o(189940);
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
    this.wOP = parama;
  }
  
  public static abstract interface a
  {
    public abstract void onClose();
    
    public abstract void onShow();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.OfflineAlertView
 * JD-Core Version:    0.7.0.1
 */