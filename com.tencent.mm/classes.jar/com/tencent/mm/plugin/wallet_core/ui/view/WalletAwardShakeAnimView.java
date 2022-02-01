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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.z;

public class WalletAwardShakeAnimView
  extends RelativeLayout
{
  private View DDR;
  private TextView DDS;
  private String DDT;
  private int DDU;
  private String DDV;
  private int DDW;
  private ValueAnimator DDX;
  private a DDY;
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
    this.DDU = 0;
    this.DDW = 0;
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
    this.DDU = 0;
    this.DDW = 0;
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
  
  private void eMj()
  {
    AppMethodBeat.i(71505);
    if (this.DDX != null) {
      this.DDX.cancel();
    }
    this.DDX = ValueAnimator.ofFloat(new float[] { -30.0F, 30.0F });
    this.DDX.setInterpolator(new LinearInterpolator());
    this.DDX.setRepeatMode(2);
    this.DDX.setRepeatCount(-1);
    this.DDX.setDuration(300L);
    this.DDX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(71498);
        WalletAwardShakeAnimView.j(WalletAwardShakeAnimView.this).setRotation(((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
        AppMethodBeat.o(71498);
      }
    });
    this.DDX.start();
    AppMethodBeat.o(71505);
  }
  
  private void init()
  {
    AppMethodBeat.i(71501);
    z.jV(getContext()).inflate(2131495897, this);
    findViewById(2131297029).setBackground(getResources().getDrawable(2131691403));
    this.DDR = findViewById(2131304678);
    this.DDS = ((TextView)findViewById(2131304677));
    AppMethodBeat.o(71501);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(71506);
    if (this.shakeSensor != null)
    {
      this.shakeSensor.cdt();
      this.shakeSensor = null;
    }
    this.isInvokeCallback = false;
    this.isStartShake = false;
    if (this.DDX != null) {
      this.DDX.cancel();
    }
    this.DDR.setRotation(0.0F);
    if (!bu.isNullOrNil(this.DDT))
    {
      this.DDS.setText(this.DDT);
      if (this.DDU == 0) {
        break label128;
      }
      this.DDS.setTextColor(this.DDU);
    }
    for (;;)
    {
      ar.ay(this.delayNofiyRunnable);
      AppMethodBeat.o(71506);
      return;
      this.DDS.setText(getResources().getText(2131765880));
      break;
      label128:
      this.DDS.setTextColor(getResources().getColor(2131100800));
    }
  }
  
  public final void eMi()
  {
    AppMethodBeat.i(71504);
    ae.i("MicroMsg.WalletAwardShakeAnimView", "startShake");
    getContext();
    this.shakeSensor = new d();
    this.shakeSensor.a(new d.a()
    {
      public final void onRelease() {}
      
      public final void onShake(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(71496);
        ae.i("MicroMsg.WalletAwardShakeAnimView", "onShake");
        long l = bu.aO(WalletAwardShakeAnimView.b(WalletAwardShakeAnimView.this));
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
        WalletAwardShakeAnimView.a(WalletAwardShakeAnimView.this, bu.HQ());
        WalletAwardShakeAnimView.d(WalletAwardShakeAnimView.this);
        if (!WalletAwardShakeAnimView.e(WalletAwardShakeAnimView.this))
        {
          WalletAwardShakeAnimView.f(WalletAwardShakeAnimView.this);
          WalletAwardShakeAnimView.g(WalletAwardShakeAnimView.this);
        }
        AppMethodBeat.o(71496);
      }
    });
    this.lastShakeTime = bu.HQ();
    setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(71497);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/wallet_core/ui/view/WalletAwardShakeAnimView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (!WalletAwardShakeAnimView.e(WalletAwardShakeAnimView.this))
        {
          WalletAwardShakeAnimView.f(WalletAwardShakeAnimView.this);
          be.aI(WalletAwardShakeAnimView.this.getContext(), 2131763618);
          WalletAwardShakeAnimView.h(WalletAwardShakeAnimView.this);
          if (WalletAwardShakeAnimView.i(WalletAwardShakeAnimView.this) != null) {
            WalletAwardShakeAnimView.i(WalletAwardShakeAnimView.this).uJ(false);
          }
        }
        a.a(this, "com/tencent/mm/plugin/wallet_core/ui/view/WalletAwardShakeAnimView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(71497);
      }
    });
    ar.ay(this.delayNofiyRunnable);
    ar.o(this.delayNofiyRunnable, 3000L);
    AppMethodBeat.o(71504);
  }
  
  public void setAfterHintWording(String paramString)
  {
    this.DDV = paramString;
  }
  
  public void setAfterHintWordingColor(int paramInt)
  {
    this.DDW = paramInt;
  }
  
  public void setShakeHintWording(String paramString)
  {
    AppMethodBeat.i(71502);
    this.DDT = paramString;
    this.DDS.setText(paramString);
    AppMethodBeat.o(71502);
  }
  
  public void setShakeHintWordingColor(int paramInt)
  {
    AppMethodBeat.i(71503);
    this.DDU = paramInt;
    this.DDS.setTextColor(paramInt);
    AppMethodBeat.o(71503);
  }
  
  public void setShakeOrClickCallback(a parama)
  {
    this.DDY = parama;
  }
  
  public static abstract interface a
  {
    public abstract void uJ(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.WalletAwardShakeAnimView
 * JD-Core Version:    0.7.0.1
 */