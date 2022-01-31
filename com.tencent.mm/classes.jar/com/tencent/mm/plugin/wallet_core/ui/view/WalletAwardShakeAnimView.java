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
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.i.c;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.y;

public class WalletAwardShakeAnimView
  extends RelativeLayout
{
  long iam;
  c mBT;
  private View qHV;
  private TextView qHW;
  private boolean qHX = false;
  private boolean qHY = false;
  private String qHZ;
  private int qIa = 0;
  private String qIb;
  private int qIc = 0;
  private ValueAnimator qId;
  private WalletAwardShakeAnimView.a qIe;
  Runnable qIf = new WalletAwardShakeAnimView.1(this);
  
  public WalletAwardShakeAnimView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public WalletAwardShakeAnimView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void bXf()
  {
    if (this.qId != null) {
      this.qId.cancel();
    }
    this.qId = ValueAnimator.ofFloat(new float[] { -30.0F, 30.0F });
    this.qId.setInterpolator(new LinearInterpolator());
    this.qId.setRepeatMode(2);
    this.qId.setRepeatCount(-1);
    this.qId.setDuration(300L);
    this.qId.addUpdateListener(new WalletAwardShakeAnimView.4(this));
    this.qId.start();
  }
  
  private void init()
  {
    y.gt(getContext()).inflate(a.g.wallet_award_shake_anim_view, this);
    findViewById(a.f.background).setBackground(getResources().getDrawable(a.h.wallet_new_shakea_anim_view_bg));
    this.qHV = findViewById(a.f.shake_icon);
    this.qHW = ((TextView)findViewById(a.f.shake_hint_wording));
  }
  
  public final void destroy()
  {
    if (this.mBT != null)
    {
      this.mBT.aFJ();
      this.mBT = null;
    }
    this.qHY = false;
    this.qHX = false;
    if (this.qId != null) {
      this.qId.cancel();
    }
    this.qHV.setRotation(0.0F);
    if (!bk.bl(this.qHZ))
    {
      this.qHW.setText(this.qHZ);
      if (this.qIa == 0) {
        break label118;
      }
      this.qHW.setTextColor(this.qIa);
    }
    for (;;)
    {
      ai.S(this.qIf);
      return;
      this.qHW.setText(getResources().getText(a.i.wallet_shake_award_hint_wording));
      break;
      label118:
      this.qHW.setTextColor(Color.parseColor("#E24C4C"));
    }
  }
  
  public void setAfterHintWording(String paramString)
  {
    this.qIb = paramString;
  }
  
  public void setAfterHintWordingColor(int paramInt)
  {
    this.qIc = paramInt;
  }
  
  public void setShakeHintWording(String paramString)
  {
    this.qHZ = paramString;
    this.qHW.setText(paramString);
  }
  
  public void setShakeHintWordingColor(int paramInt)
  {
    this.qIa = paramInt;
    this.qHW.setTextColor(paramInt);
  }
  
  public void setShakeOrClickCallback(WalletAwardShakeAnimView.a parama)
  {
    this.qIe = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.WalletAwardShakeAnimView
 * JD-Core Version:    0.7.0.1
 */