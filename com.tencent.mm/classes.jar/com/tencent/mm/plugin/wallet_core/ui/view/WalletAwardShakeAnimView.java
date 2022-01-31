package com.tencent.mm.plugin.wallet_core.ui.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.i.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.w;

public class WalletAwardShakeAnimView
  extends RelativeLayout
{
  private Runnable delayNofiyRunnable;
  private boolean isInvokeCallback;
  private boolean isStartShake;
  private long lastShakeTime;
  private d shakeSensor;
  private View uwG;
  private TextView uwH;
  private String uwI;
  private int uwJ;
  private String uwK;
  private int uwL;
  private ValueAnimator uwM;
  private WalletAwardShakeAnimView.a uwN;
  
  public WalletAwardShakeAnimView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(47893);
    this.isStartShake = false;
    this.isInvokeCallback = false;
    this.uwJ = 0;
    this.uwL = 0;
    this.delayNofiyRunnable = new WalletAwardShakeAnimView.1(this);
    init();
    AppMethodBeat.o(47893);
  }
  
  public WalletAwardShakeAnimView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(47894);
    this.isStartShake = false;
    this.isInvokeCallback = false;
    this.uwJ = 0;
    this.uwL = 0;
    this.delayNofiyRunnable = new WalletAwardShakeAnimView.1(this);
    init();
    AppMethodBeat.o(47894);
  }
  
  private void cWG()
  {
    AppMethodBeat.i(47899);
    if (this.uwM != null) {
      this.uwM.cancel();
    }
    this.uwM = ValueAnimator.ofFloat(new float[] { -30.0F, 30.0F });
    this.uwM.setInterpolator(new LinearInterpolator());
    this.uwM.setRepeatMode(2);
    this.uwM.setRepeatCount(-1);
    this.uwM.setDuration(300L);
    this.uwM.addUpdateListener(new WalletAwardShakeAnimView.4(this));
    this.uwM.start();
    AppMethodBeat.o(47899);
  }
  
  private void init()
  {
    AppMethodBeat.i(47895);
    w.hM(getContext()).inflate(2130971125, this);
    findViewById(2131824152).setBackground(getResources().getDrawable(2131232195));
    this.uwG = findViewById(2131828927);
    this.uwH = ((TextView)findViewById(2131828928));
    AppMethodBeat.o(47895);
  }
  
  public final void cWF()
  {
    AppMethodBeat.i(47898);
    ab.i("MicroMsg.WalletAwardShakeAnimView", "startShake");
    getContext();
    this.shakeSensor = new d();
    this.shakeSensor.a(new WalletAwardShakeAnimView.2(this));
    this.lastShakeTime = bo.yB();
    setOnClickListener(new WalletAwardShakeAnimView.3(this));
    al.ae(this.delayNofiyRunnable);
    al.p(this.delayNofiyRunnable, 3000L);
    AppMethodBeat.o(47898);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(47900);
    if (this.shakeSensor != null)
    {
      this.shakeSensor.bjf();
      this.shakeSensor = null;
    }
    this.isInvokeCallback = false;
    this.isStartShake = false;
    if (this.uwM != null) {
      this.uwM.cancel();
    }
    this.uwG.setRotation(0.0F);
    if (!bo.isNullOrNil(this.uwI))
    {
      this.uwH.setText(this.uwI);
      if (this.uwJ == 0) {
        break label130;
      }
      this.uwH.setTextColor(this.uwJ);
    }
    for (;;)
    {
      al.ae(this.delayNofiyRunnable);
      AppMethodBeat.o(47900);
      return;
      this.uwH.setText(getResources().getText(2131305661));
      break;
      label130:
      this.uwH.setTextColor(Color.parseColor("#E24C4C"));
    }
  }
  
  public void setAfterHintWording(String paramString)
  {
    this.uwK = paramString;
  }
  
  public void setAfterHintWordingColor(int paramInt)
  {
    this.uwL = paramInt;
  }
  
  public void setShakeHintWording(String paramString)
  {
    AppMethodBeat.i(47896);
    this.uwI = paramString;
    this.uwH.setText(paramString);
    AppMethodBeat.o(47896);
  }
  
  public void setShakeHintWordingColor(int paramInt)
  {
    AppMethodBeat.i(47897);
    this.uwJ = paramInt;
    this.uwH.setTextColor(paramInt);
    AppMethodBeat.o(47897);
  }
  
  public void setShakeOrClickCallback(WalletAwardShakeAnimView.a parama)
  {
    this.uwN = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.WalletAwardShakeAnimView
 * JD-Core Version:    0.7.0.1
 */