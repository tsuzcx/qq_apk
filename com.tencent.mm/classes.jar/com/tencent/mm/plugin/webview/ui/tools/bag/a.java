package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.content.Context;
import android.graphics.PointF;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.widget.c;

public final class a
{
  static final int BiX;
  a BiY;
  final b BiZ;
  boolean Bja;
  PointF Bjb;
  boolean Bjc;
  boolean Bjd;
  boolean mIsShowing;
  int mScreenHeight;
  int mScreenWidth;
  
  static
  {
    int i = b.Bjl;
    BiX = i * i;
  }
  
  public a(b paramb)
  {
    AppMethodBeat.i(80412);
    this.Bjb = new PointF();
    this.BiZ = paramb;
    paramb = (WindowManager)aj.getContext().getSystemService("window");
    WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
    if (d.lf(26)) {}
    for (localLayoutParams.type = 2038;; localLayoutParams.type = 2002)
    {
      localLayoutParams.format = 1;
      localLayoutParams.flags = 40;
      localLayoutParams.gravity = 85;
      localLayoutParams.width = b.Bjm;
      localLayoutParams.height = b.Bjm;
      localLayoutParams.x = 0;
      localLayoutParams.y = 0;
      this.BiY = new a(aj.getContext());
      try
      {
        this.BiY.setVisibility(8);
        paramb.addView(this.BiY, localLayoutParams);
        AppMethodBeat.o(80412);
        return;
      }
      catch (Exception paramb)
      {
        ad.e("MicroMsg.BagCancelController", "showCanceller add failed %s", new Object[] { paramb });
        AppMethodBeat.o(80412);
      }
    }
  }
  
  static final class a
    extends FrameLayout
  {
    Vibrator lRO;
    View mContentView;
    ImageView pev;
    
    public a(Context paramContext)
    {
      super();
      AppMethodBeat.i(80409);
      this.lRO = ((Vibrator)paramContext.getSystemService("vibrator"));
      LayoutInflater.from(paramContext).inflate(2131496081, this);
      this.pev = ((ImageView)findViewById(2131297203));
      paramContext = (RelativeLayout.LayoutParams)this.pev.getLayoutParams();
      paramContext.height = b.Bjl;
      paramContext.width = b.Bjl;
      this.pev.setLayoutParams(paramContext);
      this.mContentView = findViewById(2131298739);
      AppMethodBeat.o(80409);
    }
    
    final void ab(float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(80410);
      ScaleAnimation localScaleAnimation = new ScaleAnimation(paramFloat1, paramFloat2, paramFloat1, paramFloat2, 1, 1.0F, 1, 1.0F);
      localScaleAnimation.setFillAfter(true);
      localScaleAnimation.setDuration(50L);
      this.pev.startAnimation(localScaleAnimation);
      AppMethodBeat.o(80410);
    }
  }
  
  public static abstract interface b
  {
    public abstract void epn();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.a
 * JD-Core Version:    0.7.0.1
 */