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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bc;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.z;

public class WalletAwardShakeAnimView
  extends RelativeLayout
{
  private View BLV;
  private TextView BLW;
  private String BLX;
  private int BLY;
  private String BLZ;
  private int BMa;
  private ValueAnimator BMb;
  private a BMc;
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
    this.BLY = 0;
    this.BMa = 0;
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
    this.BLY = 0;
    this.BMa = 0;
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
  
  private void euv()
  {
    AppMethodBeat.i(71505);
    if (this.BMb != null) {
      this.BMb.cancel();
    }
    this.BMb = ValueAnimator.ofFloat(new float[] { -30.0F, 30.0F });
    this.BMb.setInterpolator(new LinearInterpolator());
    this.BMb.setRepeatMode(2);
    this.BMb.setRepeatCount(-1);
    this.BMb.setDuration(300L);
    this.BMb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(71498);
        WalletAwardShakeAnimView.j(WalletAwardShakeAnimView.this).setRotation(((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
        AppMethodBeat.o(71498);
      }
    });
    this.BMb.start();
    AppMethodBeat.o(71505);
  }
  
  private void init()
  {
    AppMethodBeat.i(71501);
    z.jD(getContext()).inflate(2131495897, this);
    findViewById(2131297029).setBackground(getResources().getDrawable(2131691403));
    this.BLV = findViewById(2131304678);
    this.BLW = ((TextView)findViewById(2131304677));
    AppMethodBeat.o(71501);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(71506);
    if (this.shakeSensor != null)
    {
      this.shakeSensor.bXB();
      this.shakeSensor = null;
    }
    this.isInvokeCallback = false;
    this.isStartShake = false;
    if (this.BMb != null) {
      this.BMb.cancel();
    }
    this.BLV.setRotation(0.0F);
    if (!bs.isNullOrNil(this.BLX))
    {
      this.BLW.setText(this.BLX);
      if (this.BLY == 0) {
        break label128;
      }
      this.BLW.setTextColor(this.BLY);
    }
    for (;;)
    {
      ap.aB(this.delayNofiyRunnable);
      AppMethodBeat.o(71506);
      return;
      this.BLW.setText(getResources().getText(2131765880));
      break;
      label128:
      this.BLW.setTextColor(getResources().getColor(2131100800));
    }
  }
  
  public final void euu()
  {
    AppMethodBeat.i(71504);
    ac.i("MicroMsg.WalletAwardShakeAnimView", "startShake");
    getContext();
    this.shakeSensor = new d();
    this.shakeSensor.a(new d.a()
    {
      public final void onRelease() {}
      
      public final void onShake(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(71496);
        ac.i("MicroMsg.WalletAwardShakeAnimView", "onShake");
        long l = bs.aO(WalletAwardShakeAnimView.b(WalletAwardShakeAnimView.this));
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
        WalletAwardShakeAnimView.a(WalletAwardShakeAnimView.this, bs.Gn());
        WalletAwardShakeAnimView.d(WalletAwardShakeAnimView.this);
        if (!WalletAwardShakeAnimView.e(WalletAwardShakeAnimView.this))
        {
          WalletAwardShakeAnimView.f(WalletAwardShakeAnimView.this);
          WalletAwardShakeAnimView.g(WalletAwardShakeAnimView.this);
        }
        AppMethodBeat.o(71496);
      }
    });
    this.lastShakeTime = bs.Gn();
    setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(71497);
        if (!WalletAwardShakeAnimView.e(WalletAwardShakeAnimView.this))
        {
          WalletAwardShakeAnimView.f(WalletAwardShakeAnimView.this);
          bc.aF(WalletAwardShakeAnimView.this.getContext(), 2131763618);
          WalletAwardShakeAnimView.h(WalletAwardShakeAnimView.this);
          if (WalletAwardShakeAnimView.i(WalletAwardShakeAnimView.this) != null) {
            WalletAwardShakeAnimView.i(WalletAwardShakeAnimView.this).tR(false);
          }
        }
        AppMethodBeat.o(71497);
      }
    });
    ap.aB(this.delayNofiyRunnable);
    ap.n(this.delayNofiyRunnable, 3000L);
    AppMethodBeat.o(71504);
  }
  
  public void setAfterHintWording(String paramString)
  {
    this.BLZ = paramString;
  }
  
  public void setAfterHintWordingColor(int paramInt)
  {
    this.BMa = paramInt;
  }
  
  public void setShakeHintWording(String paramString)
  {
    AppMethodBeat.i(71502);
    this.BLX = paramString;
    this.BLW.setText(paramString);
    AppMethodBeat.o(71502);
  }
  
  public void setShakeHintWordingColor(int paramInt)
  {
    AppMethodBeat.i(71503);
    this.BLY = paramInt;
    this.BLW.setTextColor(paramInt);
    AppMethodBeat.o(71503);
  }
  
  public void setShakeOrClickCallback(a parama)
  {
    this.BMc = parama;
  }
  
  public static abstract interface a
  {
    public abstract void tR(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.WalletAwardShakeAnimView
 * JD-Core Version:    0.7.0.1
 */