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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.widget.c;

public final class a
{
  static final int CBk;
  a CBl;
  final b CBm;
  boolean CBn;
  PointF CBo;
  boolean CBp;
  boolean CBq;
  boolean mIsShowing;
  int mScreenHeight;
  int mScreenWidth;
  
  static
  {
    int i = b.CBy;
    CBk = i * i;
  }
  
  public a(b paramb)
  {
    AppMethodBeat.i(80412);
    this.CBo = new PointF();
    this.CBm = paramb;
    paramb = (WindowManager)ai.getContext().getSystemService("window");
    WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
    if (d.kZ(26)) {}
    for (localLayoutParams.type = 2038;; localLayoutParams.type = 2002)
    {
      localLayoutParams.format = 1;
      localLayoutParams.flags = 40;
      localLayoutParams.gravity = 85;
      localLayoutParams.width = b.CBz;
      localLayoutParams.height = b.CBz;
      localLayoutParams.x = 0;
      localLayoutParams.y = 0;
      this.CBl = new a(ai.getContext());
      try
      {
        this.CBl.setVisibility(8);
        paramb.addView(this.CBl, localLayoutParams);
        AppMethodBeat.o(80412);
        return;
      }
      catch (Exception paramb)
      {
        ac.e("MicroMsg.BagCancelController", "showCanceller add failed %s", new Object[] { paramb });
        AppMethodBeat.o(80412);
      }
    }
  }
  
  static final class a
    extends FrameLayout
  {
    View mContentView;
    Vibrator mtQ;
    ImageView pHG;
    
    public a(Context paramContext)
    {
      super();
      AppMethodBeat.i(80409);
      this.mtQ = ((Vibrator)paramContext.getSystemService("vibrator"));
      LayoutInflater.from(paramContext).inflate(2131496081, this);
      this.pHG = ((ImageView)findViewById(2131297203));
      paramContext = (RelativeLayout.LayoutParams)this.pHG.getLayoutParams();
      paramContext.height = b.CBy;
      paramContext.width = b.CBy;
      this.pHG.setLayoutParams(paramContext);
      this.mContentView = findViewById(2131298739);
      AppMethodBeat.o(80409);
    }
    
    final void af(float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(80410);
      ScaleAnimation localScaleAnimation = new ScaleAnimation(paramFloat1, paramFloat2, paramFloat1, paramFloat2, 1, 1.0F, 1, 1.0F);
      localScaleAnimation.setFillAfter(true);
      localScaleAnimation.setDuration(50L);
      this.pHG.startAnimation(localScaleAnimation);
      AppMethodBeat.o(80410);
    }
  }
  
  public static abstract interface b
  {
    public abstract void eEI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.a
 * JD-Core Version:    0.7.0.1
 */