package com.tencent.mm.plugin.wallet_core.ui.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.LinearInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.pluginsdk.l.d;
import com.tencent.mm.pluginsdk.l.d.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.PlaySound;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aa;

public class WalletAwardShakeAnimView
  extends RelativeLayout
{
  private View Ind;
  private TextView Ine;
  private String Inf;
  private int Ing;
  private String Inh;
  private int Ini;
  private ValueAnimator Inj;
  private a Ink;
  private Runnable delayNofiyRunnable;
  private boolean isInvokeCallback;
  private boolean isStartShake;
  private long lastShakeTime;
  private d shakeSensor;
  
  public WalletAwardShakeAnimView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(71499);
    this.isStartShake = false;
    this.isInvokeCallback = false;
    this.Ing = 0;
    this.Ini = 0;
    this.delayNofiyRunnable = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(71495);
        WalletAwardShakeAnimView.a(WalletAwardShakeAnimView.this);
        AppMethodBeat.o(71495);
      }
    };
    init();
    AppMethodBeat.o(71499);
  }
  
  public WalletAwardShakeAnimView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(71500);
    this.isStartShake = false;
    this.isInvokeCallback = false;
    this.Ing = 0;
    this.Ini = 0;
    this.delayNofiyRunnable = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(71495);
        WalletAwardShakeAnimView.a(WalletAwardShakeAnimView.this);
        AppMethodBeat.o(71495);
      }
    };
    init();
    AppMethodBeat.o(71500);
  }
  
  private void fTQ()
  {
    AppMethodBeat.i(71505);
    if (this.Inj != null) {
      this.Inj.cancel();
    }
    this.Inj = ValueAnimator.ofFloat(new float[] { -30.0F, 30.0F });
    this.Inj.setInterpolator(new LinearInterpolator());
    this.Inj.setRepeatMode(2);
    this.Inj.setRepeatCount(-1);
    this.Inj.setDuration(300L);
    this.Inj.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(71498);
        WalletAwardShakeAnimView.j(WalletAwardShakeAnimView.this).setRotation(((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
        AppMethodBeat.o(71498);
      }
    });
    this.Inj.start();
    AppMethodBeat.o(71505);
  }
  
  private void init()
  {
    AppMethodBeat.i(71501);
    aa.jQ(getContext()).inflate(2131496877, this);
    findViewById(2131297171).setBackground(getResources().getDrawable(2131691737));
    this.Ind = findViewById(2131307734);
    this.Ine = ((TextView)findViewById(2131307733));
    AppMethodBeat.o(71501);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(71506);
    if (this.shakeSensor != null)
    {
      this.shakeSensor.cBo();
      this.shakeSensor = null;
    }
    this.isInvokeCallback = false;
    this.isStartShake = false;
    if (this.Inj != null) {
      this.Inj.cancel();
    }
    this.Ind.setRotation(0.0F);
    if (!Util.isNullOrNil(this.Inf))
    {
      this.Ine.setText(this.Inf);
      if (this.Ing == 0) {
        break label128;
      }
      this.Ine.setTextColor(this.Ing);
    }
    for (;;)
    {
      MMHandlerThread.removeRunnable(this.delayNofiyRunnable);
      AppMethodBeat.o(71506);
      return;
      this.Ine.setText(getResources().getText(2131768333));
      break;
      label128:
      this.Ine.setTextColor(getResources().getColor(2131100996));
    }
  }
  
  public final void fTP()
  {
    AppMethodBeat.i(71504);
    Log.i("MicroMsg.WalletAwardShakeAnimView", "startShake");
    getContext();
    this.shakeSensor = new d();
    this.shakeSensor.a(new d.a()
    {
      public final void onRelease() {}
      
      public final void onShake(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(71496);
        Log.i("MicroMsg.WalletAwardShakeAnimView", "onShake");
        long l = Util.ticksToNow(WalletAwardShakeAnimView.b(WalletAwardShakeAnimView.this));
        if (!WalletAwardShakeAnimView.c(WalletAwardShakeAnimView.this))
        {
          if (l < 1200L) {
            AppMethodBeat.o(71496);
          }
        }
        else if (l < 80L)
        {
          AppMethodBeat.o(71496);
          return;
        }
        WalletAwardShakeAnimView.a(WalletAwardShakeAnimView.this, Util.currentTicks());
        WalletAwardShakeAnimView.d(WalletAwardShakeAnimView.this);
        if (!WalletAwardShakeAnimView.e(WalletAwardShakeAnimView.this))
        {
          WalletAwardShakeAnimView.f(WalletAwardShakeAnimView.this);
          WalletAwardShakeAnimView.g(WalletAwardShakeAnimView.this);
        }
        AppMethodBeat.o(71496);
      }
    });
    this.lastShakeTime = Util.currentTicks();
    setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(71497);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/wallet_core/ui/view/WalletAwardShakeAnimView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (!WalletAwardShakeAnimView.e(WalletAwardShakeAnimView.this))
        {
          WalletAwardShakeAnimView.f(WalletAwardShakeAnimView.this);
          PlaySound.play(WalletAwardShakeAnimView.this.getContext(), 2131765806);
          WalletAwardShakeAnimView.h(WalletAwardShakeAnimView.this);
          if (WalletAwardShakeAnimView.i(WalletAwardShakeAnimView.this) != null) {
            WalletAwardShakeAnimView.i(WalletAwardShakeAnimView.this).yx(false);
          }
        }
        a.a(this, "com/tencent/mm/plugin/wallet_core/ui/view/WalletAwardShakeAnimView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(71497);
      }
    });
    MMHandlerThread.removeRunnable(this.delayNofiyRunnable);
    MMHandlerThread.postToMainThreadDelayed(this.delayNofiyRunnable, 3000L);
    AppMethodBeat.o(71504);
  }
  
  public void setAfterHintWording(String paramString)
  {
    this.Inh = paramString;
  }
  
  public void setAfterHintWordingColor(int paramInt)
  {
    this.Ini = paramInt;
  }
  
  public void setShakeHintWording(String paramString)
  {
    AppMethodBeat.i(71502);
    this.Inf = paramString;
    this.Ine.setText(paramString);
    AppMethodBeat.o(71502);
  }
  
  public void setShakeHintWordingColor(int paramInt)
  {
    AppMethodBeat.i(71503);
    this.Ing = paramInt;
    this.Ine.setTextColor(paramInt);
    AppMethodBeat.o(71503);
  }
  
  public void setShakeOrClickCallback(a parama)
  {
    this.Ink = parama;
  }
  
  public static abstract interface a
  {
    public abstract void yx(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.WalletAwardShakeAnimView
 * JD-Core Version:    0.7.0.1
 */