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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.z;

public class WalletAwardShakeAnimView
  extends RelativeLayout
{
  private View Dmn;
  private TextView Dmo;
  private String Dmp;
  private int Dmq;
  private String Dmr;
  private int Dms;
  private ValueAnimator Dmt;
  private a Dmu;
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
    this.Dmq = 0;
    this.Dms = 0;
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
    this.Dmq = 0;
    this.Dms = 0;
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
  
  private void eIB()
  {
    AppMethodBeat.i(71505);
    if (this.Dmt != null) {
      this.Dmt.cancel();
    }
    this.Dmt = ValueAnimator.ofFloat(new float[] { -30.0F, 30.0F });
    this.Dmt.setInterpolator(new LinearInterpolator());
    this.Dmt.setRepeatMode(2);
    this.Dmt.setRepeatCount(-1);
    this.Dmt.setDuration(300L);
    this.Dmt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(71498);
        WalletAwardShakeAnimView.j(WalletAwardShakeAnimView.this).setRotation(((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
        AppMethodBeat.o(71498);
      }
    });
    this.Dmt.start();
    AppMethodBeat.o(71505);
  }
  
  private void init()
  {
    AppMethodBeat.i(71501);
    z.jO(getContext()).inflate(2131495897, this);
    findViewById(2131297029).setBackground(getResources().getDrawable(2131691403));
    this.Dmn = findViewById(2131304678);
    this.Dmo = ((TextView)findViewById(2131304677));
    AppMethodBeat.o(71501);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(71506);
    if (this.shakeSensor != null)
    {
      this.shakeSensor.cce();
      this.shakeSensor = null;
    }
    this.isInvokeCallback = false;
    this.isStartShake = false;
    if (this.Dmt != null) {
      this.Dmt.cancel();
    }
    this.Dmn.setRotation(0.0F);
    if (!bt.isNullOrNil(this.Dmp))
    {
      this.Dmo.setText(this.Dmp);
      if (this.Dmq == 0) {
        break label128;
      }
      this.Dmo.setTextColor(this.Dmq);
    }
    for (;;)
    {
      aq.aA(this.delayNofiyRunnable);
      AppMethodBeat.o(71506);
      return;
      this.Dmo.setText(getResources().getText(2131765880));
      break;
      label128:
      this.Dmo.setTextColor(getResources().getColor(2131100800));
    }
  }
  
  public final void eIA()
  {
    AppMethodBeat.i(71504);
    ad.i("MicroMsg.WalletAwardShakeAnimView", "startShake");
    getContext();
    this.shakeSensor = new d();
    this.shakeSensor.a(new d.a()
    {
      public final void onRelease() {}
      
      public final void onShake(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(71496);
        ad.i("MicroMsg.WalletAwardShakeAnimView", "onShake");
        long l = bt.aO(WalletAwardShakeAnimView.b(WalletAwardShakeAnimView.this));
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
        WalletAwardShakeAnimView.a(WalletAwardShakeAnimView.this, bt.HI());
        WalletAwardShakeAnimView.d(WalletAwardShakeAnimView.this);
        if (!WalletAwardShakeAnimView.e(WalletAwardShakeAnimView.this))
        {
          WalletAwardShakeAnimView.f(WalletAwardShakeAnimView.this);
          WalletAwardShakeAnimView.g(WalletAwardShakeAnimView.this);
        }
        AppMethodBeat.o(71496);
      }
    });
    this.lastShakeTime = bt.HI();
    setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(71497);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/wallet_core/ui/view/WalletAwardShakeAnimView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (!WalletAwardShakeAnimView.e(WalletAwardShakeAnimView.this))
        {
          WalletAwardShakeAnimView.f(WalletAwardShakeAnimView.this);
          bd.aI(WalletAwardShakeAnimView.this.getContext(), 2131763618);
          WalletAwardShakeAnimView.h(WalletAwardShakeAnimView.this);
          if (WalletAwardShakeAnimView.i(WalletAwardShakeAnimView.this) != null) {
            WalletAwardShakeAnimView.i(WalletAwardShakeAnimView.this).uB(false);
          }
        }
        a.a(this, "com/tencent/mm/plugin/wallet_core/ui/view/WalletAwardShakeAnimView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(71497);
      }
    });
    aq.aA(this.delayNofiyRunnable);
    aq.o(this.delayNofiyRunnable, 3000L);
    AppMethodBeat.o(71504);
  }
  
  public void setAfterHintWording(String paramString)
  {
    this.Dmr = paramString;
  }
  
  public void setAfterHintWordingColor(int paramInt)
  {
    this.Dms = paramInt;
  }
  
  public void setShakeHintWording(String paramString)
  {
    AppMethodBeat.i(71502);
    this.Dmp = paramString;
    this.Dmo.setText(paramString);
    AppMethodBeat.o(71502);
  }
  
  public void setShakeHintWordingColor(int paramInt)
  {
    AppMethodBeat.i(71503);
    this.Dmq = paramInt;
    this.Dmo.setTextColor(paramInt);
    AppMethodBeat.o(71503);
  }
  
  public void setShakeOrClickCallback(a parama)
  {
    this.Dmu = parama;
  }
  
  public static abstract interface a
  {
    public abstract void uB(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.WalletAwardShakeAnimView
 * JD-Core Version:    0.7.0.1
 */