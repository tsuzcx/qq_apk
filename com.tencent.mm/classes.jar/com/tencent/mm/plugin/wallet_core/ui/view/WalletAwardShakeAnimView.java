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
import com.tencent.mm.pluginsdk.j.d;
import com.tencent.mm.pluginsdk.j.d.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.y;

public class WalletAwardShakeAnimView
  extends RelativeLayout
{
  private View AtB;
  private TextView AtC;
  private String AtD;
  private int AtE;
  private String AtF;
  private int AtG;
  private ValueAnimator AtH;
  private a AtI;
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
    this.AtE = 0;
    this.AtG = 0;
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
    this.AtE = 0;
    this.AtG = 0;
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
  
  private void efa()
  {
    AppMethodBeat.i(71505);
    if (this.AtH != null) {
      this.AtH.cancel();
    }
    this.AtH = ValueAnimator.ofFloat(new float[] { -30.0F, 30.0F });
    this.AtH.setInterpolator(new LinearInterpolator());
    this.AtH.setRepeatMode(2);
    this.AtH.setRepeatCount(-1);
    this.AtH.setDuration(300L);
    this.AtH.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(71498);
        WalletAwardShakeAnimView.j(WalletAwardShakeAnimView.this).setRotation(((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
        AppMethodBeat.o(71498);
      }
    });
    this.AtH.start();
    AppMethodBeat.o(71505);
  }
  
  private void init()
  {
    AppMethodBeat.i(71501);
    y.js(getContext()).inflate(2131495897, this);
    findViewById(2131297029).setBackground(getResources().getDrawable(2131691403));
    this.AtB = findViewById(2131304678);
    this.AtC = ((TextView)findViewById(2131304677));
    AppMethodBeat.o(71501);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(71506);
    if (this.shakeSensor != null)
    {
      this.shakeSensor.bQk();
      this.shakeSensor = null;
    }
    this.isInvokeCallback = false;
    this.isStartShake = false;
    if (this.AtH != null) {
      this.AtH.cancel();
    }
    this.AtB.setRotation(0.0F);
    if (!bt.isNullOrNil(this.AtD))
    {
      this.AtC.setText(this.AtD);
      if (this.AtE == 0) {
        break label128;
      }
      this.AtC.setTextColor(this.AtE);
    }
    for (;;)
    {
      aq.az(this.delayNofiyRunnable);
      AppMethodBeat.o(71506);
      return;
      this.AtC.setText(getResources().getText(2131765880));
      break;
      label128:
      this.AtC.setTextColor(getResources().getColor(2131100800));
    }
  }
  
  public final void eeZ()
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
        long l = bt.aS(WalletAwardShakeAnimView.b(WalletAwardShakeAnimView.this));
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
        WalletAwardShakeAnimView.a(WalletAwardShakeAnimView.this, bt.GC());
        WalletAwardShakeAnimView.d(WalletAwardShakeAnimView.this);
        if (!WalletAwardShakeAnimView.e(WalletAwardShakeAnimView.this))
        {
          WalletAwardShakeAnimView.f(WalletAwardShakeAnimView.this);
          WalletAwardShakeAnimView.g(WalletAwardShakeAnimView.this);
        }
        AppMethodBeat.o(71496);
      }
    });
    this.lastShakeTime = bt.GC();
    setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(71497);
        if (!WalletAwardShakeAnimView.e(WalletAwardShakeAnimView.this))
        {
          WalletAwardShakeAnimView.f(WalletAwardShakeAnimView.this);
          bd.az(WalletAwardShakeAnimView.this.getContext(), 2131763618);
          WalletAwardShakeAnimView.h(WalletAwardShakeAnimView.this);
          if (WalletAwardShakeAnimView.i(WalletAwardShakeAnimView.this) != null) {
            WalletAwardShakeAnimView.i(WalletAwardShakeAnimView.this).sQ(false);
          }
        }
        AppMethodBeat.o(71497);
      }
    });
    aq.az(this.delayNofiyRunnable);
    aq.n(this.delayNofiyRunnable, 3000L);
    AppMethodBeat.o(71504);
  }
  
  public void setAfterHintWording(String paramString)
  {
    this.AtF = paramString;
  }
  
  public void setAfterHintWordingColor(int paramInt)
  {
    this.AtG = paramInt;
  }
  
  public void setShakeHintWording(String paramString)
  {
    AppMethodBeat.i(71502);
    this.AtD = paramString;
    this.AtC.setText(paramString);
    AppMethodBeat.o(71502);
  }
  
  public void setShakeHintWordingColor(int paramInt)
  {
    AppMethodBeat.i(71503);
    this.AtE = paramInt;
    this.AtC.setTextColor(paramInt);
    AppMethodBeat.o(71503);
  }
  
  public void setShakeOrClickCallback(a parama)
  {
    this.AtI = parama;
  }
  
  public static abstract interface a
  {
    public abstract void sQ(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.WalletAwardShakeAnimView
 * JD-Core Version:    0.7.0.1
 */