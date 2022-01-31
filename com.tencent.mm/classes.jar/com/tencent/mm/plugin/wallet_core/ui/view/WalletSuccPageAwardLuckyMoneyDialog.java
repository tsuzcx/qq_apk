package com.tencent.mm.plugin.wallet_core.ui.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import d.a.a.f;
import java.io.IOException;

@a(3)
public class WalletSuccPageAwardLuckyMoneyDialog
  extends MMActivity
{
  private ViewGroup owk;
  private ImageView uxw;
  private f uxx;
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2130971253;
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(47939);
    super.onCreate(paramBundle);
    if (getSupportActionBar() != null) {
      getSupportActionBar().hide();
    }
    if (d.fv(19)) {
      getWindow().setFlags(67108864, 67108864);
    }
    paramBundle = getIntent().getByteArrayExtra("key_layer_info");
    if (paramBundle == null)
    {
      ab.e("MicroMsg.WalletSuccPageAwardLuckyMoneyDialog", "WalletSuccPageAwardLuckyMoneyDialog onCreate error! cannot get layerInfoBytes!");
      finish();
    }
    this.uxx = new f();
    try
    {
      this.uxx.parseFrom(paramBundle);
      this.owk = ((ViewGroup)findViewById(2131821724));
      this.uxw = ((ImageView)findViewById(2131826502));
      this.uxw.setOnClickListener(new WalletSuccPageAwardLuckyMoneyDialog.1(this));
      paramBundle = this.owk;
      WalletSuccPageAwardLuckyMoneyDialog.2 local2 = new WalletSuccPageAwardLuckyMoneyDialog.2(this);
      ScaleAnimation localScaleAnimation1 = new ScaleAnimation(0.0F, 0.96F, 0.0F, 0.96F, 1, 0.5F, 1, 0.5F);
      localScaleAnimation1.setDuration(300L);
      localScaleAnimation1.setInterpolator(new OvershootInterpolator());
      localScaleAnimation1.setFillAfter(true);
      final ScaleAnimation localScaleAnimation2 = new ScaleAnimation(0.96F, 1.0F, 0.96F, 1.0F, 1, 0.5F, 1, 0.5F);
      localScaleAnimation2.setDuration(100L);
      localScaleAnimation2.setFillAfter(true);
      localScaleAnimation1.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(47938);
          paramBundle.startAnimation(localScaleAnimation2);
          AppMethodBeat.o(47938);
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
      localScaleAnimation2.setAnimationListener(local2);
      if (paramBundle != null) {
        paramBundle.startAnimation(localScaleAnimation1);
      }
      AppMethodBeat.o(47939);
      return;
    }
    catch (IOException paramBundle)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.WalletSuccPageAwardLuckyMoneyDialog", paramBundle, "parse layer info byte error! %s", new Object[] { paramBundle.getMessage() });
        finish();
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardLuckyMoneyDialog
 * JD-Core Version:    0.7.0.1
 */