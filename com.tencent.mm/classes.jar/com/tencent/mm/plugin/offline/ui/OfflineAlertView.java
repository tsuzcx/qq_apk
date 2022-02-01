package com.tencent.mm.plugin.offline.ui;

import android.content.Context;
import android.content.Intent;
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
import com.tencent.mm.br.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.wallet_core.model.q;
import com.tencent.mm.pluginsdk.ui.applet.u;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.w;
import com.tencent.mm.wallet_core.c.c.a;

public class OfflineAlertView
  extends LinearLayout
{
  private View contentView;
  ViewGroup isN;
  com.tencent.mm.pluginsdk.ui.span.h nAR;
  public int vtK;
  boolean vtL;
  private a vtM;
  CountDownTimer vtN;
  
  public OfflineAlertView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(66351);
    this.vtK = 0;
    this.contentView = null;
    this.isN = null;
    this.vtL = true;
    this.vtM = null;
    init();
    AppMethodBeat.o(66351);
  }
  
  public OfflineAlertView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(66352);
    this.vtK = 0;
    this.contentView = null;
    this.isN = null;
    this.vtL = true;
    this.vtM = null;
    init();
    AppMethodBeat.o(66352);
  }
  
  private void init()
  {
    AppMethodBeat.i(66353);
    this.contentView = LayoutInflater.from(getContext()).inflate(2131495983, this);
    this.isN = ((ViewGroup)this.contentView.findViewById(2131302988));
    AppMethodBeat.o(66353);
  }
  
  public final boolean KH(int paramInt)
  {
    AppMethodBeat.i(66360);
    if (isShowing())
    {
      if (paramInt == this.vtK)
      {
        AppMethodBeat.o(66360);
        return true;
      }
      if ((paramInt == 2) && ((this.vtK == 3) || (this.vtK == 4) || (this.vtK == 2) || (this.vtK == 5)))
      {
        AppMethodBeat.o(66360);
        return true;
      }
      if ((paramInt == 5) && (this.vtK == 4))
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
    this.vtK = paramInt;
    setVisibility(0);
    this.isN.removeAllViews();
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
            AppMethodBeat.i(66348);
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("wallet_lock_jsapi_scene", 2);
            d.b(paramView.getContext(), "wallet", ".pwd.ui.WalletSecuritySettingUI", paramAnonymousView);
            AppMethodBeat.o(66348);
          }
        });
      }
      this.isN.addView(localView);
      ((Button)this.contentView.findViewById(2131300871)).setOnClickListener(paramOnClickListener);
      this.vtL = false;
      paramView.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(66349);
          ac.i("MicroMsg.OfflineAlertView", "qrCodeView.getHeight%s %s", new Object[] { Integer.valueOf(paramView.getHeight()), Integer.valueOf(paramView.getMeasuredHeight()) });
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
      if (((paramInt == 3) || (paramInt == 1)) && (b.CQ((String)g.agR().agA().get(274436, null)))) {
        ((TextView)localView.findViewById(2131296636)).setText(2131761799);
      }
    }
  }
  
  public final void a(final View paramView, final Runnable paramRunnable1, final Runnable paramRunnable2)
  {
    AppMethodBeat.i(66354);
    setVisibility(0);
    this.isN.removeAllViews();
    View localView = LayoutInflater.from(getContext()).inflate(2131495992, null);
    this.isN.addView(localView);
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
    this.vtK = 5;
    setVisibility(0);
    this.vtL = false;
    this.isN.removeAllViews();
    View localView = LayoutInflater.from(getContext()).inflate(2131495995, null);
    this.isN.addView(localView);
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
        ac.i("MicroMsg.OfflineAlertView", "qrCodeView.getHeight%s %s", new Object[] { Integer.valueOf(paramView.getHeight()), Integer.valueOf(paramView.getMeasuredHeight()) });
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
    if (this.isN != null) {
      this.isN.removeAllViews();
    }
    setVisibility(8);
    if (this.vtM != null) {
      this.vtM.onClose();
    }
    if (this.vtN != null) {
      this.vtN.cancel();
    }
    if (this.nAR != null) {
      k.b(this.nAR);
    }
    this.vtK = 0;
    this.vtL = true;
    AppMethodBeat.o(66361);
  }
  
  public final void en(final View paramView)
  {
    AppMethodBeat.i(66355);
    setVisibility(0);
    this.isN.removeAllViews();
    View localView = LayoutInflater.from(getContext()).inflate(2131495989, null);
    this.isN.addView(localView);
    com.tencent.mm.plugin.report.service.h.wUl.f(13750, new Object[] { Integer.valueOf(1) });
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
    this.vtM = parama;
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