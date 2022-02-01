package com.tencent.mm.plugin.offline.ui;

import android.content.Context;
import android.content.res.Resources;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.plugin.wallet_core.model.r.a;
import com.tencent.mm.pluginsdk.ui.span.i;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.ui.x;
import com.tencent.mm.wallet_core.c.c.a;
import com.tencent.mm.wallet_core.ui.e.a;
import com.tencent.mm.wallet_core.ui.f;
import java.util.Iterator;
import java.util.List;

public class OfflineAlertView
  extends LinearLayout
{
  public int AKt;
  boolean AKu;
  private a AKv;
  CountDownTimer AKw;
  private View contentView;
  ViewGroup jLy;
  i ptq;
  
  public OfflineAlertView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(66351);
    this.AKt = 0;
    this.contentView = null;
    this.jLy = null;
    this.AKu = true;
    this.AKv = null;
    init();
    AppMethodBeat.o(66351);
  }
  
  public OfflineAlertView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(66352);
    this.AKt = 0;
    this.contentView = null;
    this.jLy = null;
    this.AKu = true;
    this.AKv = null;
    init();
    AppMethodBeat.o(66352);
  }
  
  private static r.a a(r paramr, String paramString)
  {
    AppMethodBeat.i(213628);
    paramr = paramr.HYy.iterator();
    while (paramr.hasNext())
    {
      r.a locala = (r.a)paramr.next();
      if (locala.language.equals(paramString))
      {
        AppMethodBeat.o(213628);
        return locala;
      }
    }
    AppMethodBeat.o(213628);
    return null;
  }
  
  private void init()
  {
    AppMethodBeat.i(66353);
    this.contentView = LayoutInflater.from(getContext()).inflate(2131496963, this);
    this.jLy = ((ViewGroup)this.contentView.findViewById(2131305579));
    this.jLy.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        return true;
      }
    });
    AppMethodBeat.o(66353);
  }
  
  public final boolean TY(int paramInt)
  {
    AppMethodBeat.i(66360);
    if (isShowing())
    {
      if (paramInt == this.AKt)
      {
        AppMethodBeat.o(66360);
        return true;
      }
      if ((paramInt == 2) && ((this.AKt == 3) || (this.AKt == 4) || (this.AKt == 2) || (this.AKt == 5)))
      {
        AppMethodBeat.o(66360);
        return true;
      }
      if ((paramInt == 5) && (this.AKt == 4))
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
      if ((paramInt == 8) && ((this.AKt == 5) || (this.AKt == 4) || (this.AKt == 2)))
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
    this.AKt = paramInt;
    setVisibility(0);
    this.jLy.removeAllViews();
    View localView = LayoutInflater.from(getContext()).inflate(2131496975, null);
    if (paramInt == 6) {
      ((TextView)localView.findViewById(2131296713)).setText(2131763761);
    }
    for (;;)
    {
      ViewGroup localViewGroup = (ViewGroup)localView.findViewById(2131307203);
      if (localViewGroup != null) {
        localViewGroup.setOnClickListener(new OfflineAlertView.15(this, paramView));
      }
      this.jLy.addView(localView);
      ((Button)this.contentView.findViewById(2131302465)).setOnClickListener(paramOnClickListener);
      this.AKu = false;
      paramView.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(66350);
          Log.i("MicroMsg.OfflineAlertView", "qrCodeView.getHeight%s %s", new Object[] { Integer.valueOf(paramView.getHeight()), Integer.valueOf(paramView.getMeasuredHeight()) });
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
      if (((paramInt == 3) || (paramInt == 1)) && (com.tencent.mm.aw.b.Pi((String)g.aAh().azQ().get(274436, null)))) {
        ((TextView)localView.findViewById(2131296713)).setText(2131763770);
      }
    }
  }
  
  public final void a(final View paramView, final r paramr)
  {
    AppMethodBeat.i(213627);
    this.AKt = 8;
    setVisibility(0);
    this.AKu = false;
    this.jLy.removeAllViews();
    Object localObject = LayoutInflater.from(getContext()).inflate(2131496970, this.jLy, false);
    this.jLy.addView((View)localObject);
    TextView localTextView1 = (TextView)((View)localObject).findViewById(2131304339);
    TextView localTextView2 = (TextView)((View)localObject).findViewById(2131308721);
    Button localButton = (Button)((View)localObject).findViewById(2131302465);
    localObject = (WeImageView)((View)localObject).findViewById(2131302510);
    ((WeImageView)localObject).setImageResource(2131690820);
    ((WeImageView)localObject).setIconColor(getResources().getColor(2131101370));
    localObject = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
    if ((((String)localObject).equals("zh_CN")) || (((String)localObject).equals("zh_HK")) || (((String)localObject).equals("zh_TW"))) {}
    for (localObject = a(paramr, (String)localObject);; localObject = a(paramr, "en"))
    {
      if (localObject != null)
      {
        localTextView1.setText(((r.a)localObject).HYt);
        localTextView2.setText(((r.a)localObject).HYu);
        localButton.setText(((r.a)localObject).HYz);
      }
      localButton.setTextColor(getResources().getColor(2131100194));
      localButton.setBackgroundResource(2131231429);
      localButton.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(213620);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/offline/ui/OfflineAlertView$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (paramr.pTI == 2) {
            f.bn(OfflineAlertView.this.getContext(), paramr.url);
          }
          for (;;)
          {
            h.CyF.a(20258, new Object[] { Integer.valueOf(2) });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/offline/ui/OfflineAlertView$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(213620);
            return;
            if (paramr.pTI == 3) {
              f.u(paramr.HWN, paramr.HWO, 0, 1000);
            }
          }
        }
      });
      paramView.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(213621);
          Log.i("MicroMsg.OfflineAlertView", "qrCodeView.getHeight%s %s", new Object[] { Integer.valueOf(paramView.getHeight()), Integer.valueOf(paramView.getMeasuredHeight()) });
          FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)OfflineAlertView.a(OfflineAlertView.this).getLayoutParams();
          if (paramView.getHeight() > 0)
          {
            localLayoutParams.height = paramView.getHeight();
            OfflineAlertView.a(OfflineAlertView.this).setLayoutParams(localLayoutParams);
          }
          if (OfflineAlertView.b(OfflineAlertView.this) != null) {
            OfflineAlertView.b(OfflineAlertView.this).onShow();
          }
          AppMethodBeat.o(213621);
        }
      });
      AppMethodBeat.o(213627);
      return;
    }
  }
  
  public final void a(final View paramView, final Runnable paramRunnable1, final Runnable paramRunnable2)
  {
    AppMethodBeat.i(66354);
    this.AKt = 2;
    setVisibility(0);
    this.jLy.removeAllViews();
    View localView = LayoutInflater.from(getContext()).inflate(2131496972, null);
    this.jLy.addView(localView);
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
    this.AKt = 5;
    setVisibility(0);
    this.AKu = false;
    this.jLy.removeAllViews();
    View localView = LayoutInflater.from(getContext()).inflate(2131496975, null);
    this.jLy.addView(localView);
    ((TextView)localView.findViewById(2131296713)).setText(2131763758);
    Button localButton = (Button)localView.findViewById(2131302465);
    localButton.setText(2131763757);
    localButton.setOnClickListener(paramOnClickListener);
    paramOnClickListener = (ViewGroup)localView.findViewById(2131307203);
    if (paramOnClickListener != null) {
      paramOnClickListener.setVisibility(8);
    }
    paramView.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(213614);
        Log.i("MicroMsg.OfflineAlertView", "qrCodeView.getHeight%s %s", new Object[] { Integer.valueOf(paramView.getHeight()), Integer.valueOf(paramView.getMeasuredHeight()) });
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
        AppMethodBeat.o(213614);
      }
    });
    AppMethodBeat.o(66358);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(66361);
    if (this.jLy != null) {
      this.jLy.removeAllViews();
    }
    setVisibility(8);
    if (this.AKv != null) {
      this.AKv.onClose();
    }
    if (this.AKw != null) {
      this.AKw.cancel();
    }
    if (this.ptq != null) {
      l.b(this.ptq);
    }
    this.AKt = 0;
    this.AKu = true;
    AppMethodBeat.o(66361);
  }
  
  public final void eE(final View paramView)
  {
    AppMethodBeat.i(66355);
    setVisibility(0);
    this.jLy.removeAllViews();
    View localView = LayoutInflater.from(getContext()).inflate(2131496969, null);
    this.jLy.addView(localView);
    h.CyF.a(13750, new Object[] { Integer.valueOf(1) });
    this.AKt = 4;
    paramView.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(213622);
        OfflineAlertView.a(OfflineAlertView.this, paramView);
        AppMethodBeat.o(213622);
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
    this.AKv = parama;
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