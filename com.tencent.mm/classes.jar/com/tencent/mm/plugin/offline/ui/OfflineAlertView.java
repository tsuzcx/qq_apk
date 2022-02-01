package com.tencent.mm.plugin.offline.ui;

import android.content.Context;
import android.content.Intent;
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
import com.tencent.mm.bs.d;
import com.tencent.mm.plugin.wallet_core.model.q;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.plugin.wallet_core.model.r.a;
import com.tencent.mm.pluginsdk.ui.applet.u;
import com.tencent.mm.pluginsdk.ui.span.h;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.w;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.wallet_core.c.c.a;
import java.util.Iterator;
import java.util.List;

public class OfflineAlertView
  extends LinearLayout
{
  private View contentView;
  ViewGroup iLQ;
  h oca;
  public int wzc;
  boolean wzd;
  private a wze;
  CountDownTimer wzf;
  
  public OfflineAlertView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(66351);
    this.wzc = 0;
    this.contentView = null;
    this.iLQ = null;
    this.wzd = true;
    this.wze = null;
    init();
    AppMethodBeat.o(66351);
  }
  
  public OfflineAlertView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(66352);
    this.wzc = 0;
    this.contentView = null;
    this.iLQ = null;
    this.wzd = true;
    this.wze = null;
    init();
    AppMethodBeat.o(66352);
  }
  
  private static r.a a(r paramr, String paramString)
  {
    AppMethodBeat.i(199111);
    paramr = paramr.CXF.iterator();
    while (paramr.hasNext())
    {
      r.a locala = (r.a)paramr.next();
      if (locala.language.equals(paramString))
      {
        AppMethodBeat.o(199111);
        return locala;
      }
    }
    AppMethodBeat.o(199111);
    return null;
  }
  
  private void init()
  {
    AppMethodBeat.i(66353);
    this.contentView = LayoutInflater.from(getContext()).inflate(2131495983, this);
    this.iLQ = ((ViewGroup)this.contentView.findViewById(2131302988));
    this.iLQ.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(199096);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/offline/ui/OfflineAlertView$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/offline/ui/OfflineAlertView$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(199096);
        return true;
      }
    });
    AppMethodBeat.o(66353);
  }
  
  public final boolean Mj(int paramInt)
  {
    AppMethodBeat.i(66360);
    if (isShowing())
    {
      if (paramInt == this.wzc)
      {
        AppMethodBeat.o(66360);
        return true;
      }
      if ((paramInt == 2) && ((this.wzc == 3) || (this.wzc == 4) || (this.wzc == 2) || (this.wzc == 5)))
      {
        AppMethodBeat.o(66360);
        return true;
      }
      if ((paramInt == 5) && (this.wzc == 4))
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
      if ((paramInt == 8) && ((this.wzc == 5) || (this.wzc == 4) || (this.wzc == 2)))
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
    this.wzc = paramInt;
    setVisibility(0);
    this.iLQ.removeAllViews();
    View localView = LayoutInflater.from(getContext()).inflate(2131495995, null);
    if (paramInt == 6) {
      ((TextView)localView.findViewById(2131296636)).setText(2131761790);
    }
    for (;;)
    {
      ViewGroup localViewGroup = (ViewGroup)localView.findViewById(2131304275);
      if (localViewGroup != null) {
        localViewGroup.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(199109);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/offline/ui/OfflineAlertView$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("wallet_lock_jsapi_scene", 2);
            d.b(paramView.getContext(), "wallet", ".pwd.ui.WalletSecuritySettingUI", paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/offline/ui/OfflineAlertView$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(199109);
          }
        });
      }
      this.iLQ.addView(localView);
      ((Button)this.contentView.findViewById(2131300871)).setOnClickListener(paramOnClickListener);
      this.wzd = false;
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
      AppMethodBeat.o(66357);
      return;
      if (((paramInt == 3) || (paramInt == 1)) && (com.tencent.mm.ax.b.FU((String)com.tencent.mm.kernel.g.ajC().ajl().get(274436, null)))) {
        ((TextView)localView.findViewById(2131296636)).setText(2131761799);
      }
    }
  }
  
  public final void a(final View paramView, final r paramr)
  {
    AppMethodBeat.i(199110);
    this.wzc = 8;
    setVisibility(0);
    this.wzd = false;
    this.iLQ.removeAllViews();
    Object localObject = LayoutInflater.from(getContext()).inflate(2131495990, this.iLQ, false);
    this.iLQ.addView((View)localObject);
    TextView localTextView1 = (TextView)((View)localObject).findViewById(2131302001);
    TextView localTextView2 = (TextView)((View)localObject).findViewById(2131305510);
    Button localButton = (Button)((View)localObject).findViewById(2131300871);
    localObject = (WeImageView)((View)localObject).findViewById(2131300901);
    ((WeImageView)localObject).setImageResource(2131690585);
    ((WeImageView)localObject).setIconColor(getResources().getColor(2131101127));
    localObject = ac.iM(aj.getContext());
    if ((((String)localObject).equals("zh_CN")) || (((String)localObject).equals("zh_HK")) || (((String)localObject).equals("zh_TW"))) {}
    for (localObject = a(paramr, (String)localObject);; localObject = a(paramr, "en"))
    {
      if (localObject != null)
      {
        localTextView1.setText(((r.a)localObject).CXA);
        localTextView2.setText(((r.a)localObject).CXB);
        localButton.setText(((r.a)localObject).CXG);
      }
      localButton.setTextColor(getResources().getColor(2131100161));
      localButton.setBackgroundResource(2131231365);
      localButton.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(199103);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/offline/ui/OfflineAlertView$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if (paramr.ozA == 2) {
            com.tencent.mm.wallet_core.ui.e.aW(OfflineAlertView.this.getContext(), paramr.url);
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.g.yhR.f(20258, new Object[] { Integer.valueOf(2) });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/offline/ui/OfflineAlertView$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(199103);
            return;
            if (paramr.ozA == 3) {
              com.tencent.mm.wallet_core.ui.e.v(paramr.CVP, paramr.CVQ, 0, 1000);
            }
          }
        }
      });
      paramView.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(199104);
          ad.i("MicroMsg.OfflineAlertView", "qrCodeView.getHeight%s %s", new Object[] { Integer.valueOf(paramView.getHeight()), Integer.valueOf(paramView.getMeasuredHeight()) });
          FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)OfflineAlertView.a(OfflineAlertView.this).getLayoutParams();
          if (paramView.getHeight() > 0)
          {
            localLayoutParams.height = paramView.getHeight();
            OfflineAlertView.a(OfflineAlertView.this).setLayoutParams(localLayoutParams);
          }
          if (OfflineAlertView.b(OfflineAlertView.this) != null) {
            OfflineAlertView.b(OfflineAlertView.this).onShow();
          }
          AppMethodBeat.o(199104);
        }
      });
      AppMethodBeat.o(199110);
      return;
    }
  }
  
  public final void a(final View paramView, final Runnable paramRunnable1, final Runnable paramRunnable2)
  {
    AppMethodBeat.i(66354);
    this.wzc = 2;
    setVisibility(0);
    this.iLQ.removeAllViews();
    View localView = LayoutInflater.from(getContext()).inflate(2131495992, null);
    this.iLQ.addView(localView);
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
    this.wzc = 5;
    setVisibility(0);
    this.wzd = false;
    this.iLQ.removeAllViews();
    View localView = LayoutInflater.from(getContext()).inflate(2131495995, null);
    this.iLQ.addView(localView);
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
        AppMethodBeat.i(199097);
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
        AppMethodBeat.o(199097);
      }
    });
    AppMethodBeat.o(66358);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(66361);
    if (this.iLQ != null) {
      this.iLQ.removeAllViews();
    }
    setVisibility(8);
    if (this.wze != null) {
      this.wze.onClose();
    }
    if (this.wzf != null) {
      this.wzf.cancel();
    }
    if (this.oca != null) {
      k.b(this.oca);
    }
    this.wzc = 0;
    this.wzd = true;
    AppMethodBeat.o(66361);
  }
  
  public final void ew(final View paramView)
  {
    AppMethodBeat.i(66355);
    setVisibility(0);
    this.iLQ.removeAllViews();
    View localView = LayoutInflater.from(getContext()).inflate(2131495989, null);
    this.iLQ.addView(localView);
    com.tencent.mm.plugin.report.service.g.yhR.f(13750, new Object[] { Integer.valueOf(1) });
    this.wzc = 4;
    paramView.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(199105);
        OfflineAlertView.a(OfflineAlertView.this, paramView);
        AppMethodBeat.o(199105);
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
    this.wze = parama;
  }
  
  public static abstract interface a
  {
    public abstract void onClose();
    
    public abstract void onShow();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.OfflineAlertView
 * JD-Core Version:    0.7.0.1
 */