package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import b.a.a.e;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import java.io.IOException;

@a(3)
public class WalletSuccPageAwardLuckyMoneyDialog
  extends MMActivity
{
  private ViewGroup qIO;
  private ImageView qIP;
  private e qIQ;
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  protected final int getLayoutId()
  {
    return a.g.wallet_succ_page_award_lucky_money_dialog;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (getSupportActionBar() != null) {
      getSupportActionBar().hide();
    }
    if (d.gF(19)) {
      getWindow().setFlags(67108864, 67108864);
    }
    paramBundle = getIntent().getByteArrayExtra("key_layer_info");
    if (paramBundle == null)
    {
      y.e("MicroMsg.WalletSuccPageAwardLuckyMoneyDialog", "WalletSuccPageAwardLuckyMoneyDialog onCreate error! cannot get layerInfoBytes!");
      finish();
    }
    this.qIQ = new e();
    try
    {
      this.qIQ.aH(paramBundle);
      this.qIO = ((ViewGroup)findViewById(a.f.content_layout));
      this.qIP = ((ImageView)findViewById(a.f.close_btn));
      this.qIP.setOnClickListener(new WalletSuccPageAwardLuckyMoneyDialog.1(this));
      paramBundle = this.qIO;
      WalletSuccPageAwardLuckyMoneyDialog.2 local2 = new WalletSuccPageAwardLuckyMoneyDialog.2(this);
      ScaleAnimation localScaleAnimation1 = new ScaleAnimation(0.0F, 0.96F, 0.0F, 0.96F, 1, 0.5F, 1, 0.5F);
      localScaleAnimation1.setDuration(300L);
      localScaleAnimation1.setInterpolator(new OvershootInterpolator());
      localScaleAnimation1.setFillAfter(true);
      ScaleAnimation localScaleAnimation2 = new ScaleAnimation(0.96F, 1.0F, 0.96F, 1.0F, 1, 0.5F, 1, 0.5F);
      localScaleAnimation2.setDuration(100L);
      localScaleAnimation2.setFillAfter(true);
      localScaleAnimation1.setAnimationListener(new WalletSuccPageAwardLuckyMoneyDialog.3(this, paramBundle, localScaleAnimation2));
      localScaleAnimation2.setAnimationListener(local2);
      if (paramBundle != null) {
        paramBundle.startAnimation(localScaleAnimation1);
      }
      return;
    }
    catch (IOException paramBundle)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.WalletSuccPageAwardLuckyMoneyDialog", paramBundle, "parse layer info byte error! %s", new Object[] { paramBundle.getMessage() });
        finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardLuckyMoneyDialog
 * JD-Core Version:    0.7.0.1
 */