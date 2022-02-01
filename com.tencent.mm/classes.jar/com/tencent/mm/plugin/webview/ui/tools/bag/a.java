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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.widget.c;

public final class a
{
  static final int Jkp;
  boolean AbM;
  a Jkq;
  final b Jkr;
  boolean Jks;
  PointF Jkt;
  boolean Jku;
  boolean mIsShowing;
  int mScreenHeight;
  int mScreenWidth;
  
  static
  {
    int i = b.JkC;
    Jkp = i * i;
  }
  
  public a(b paramb)
  {
    AppMethodBeat.i(80412);
    this.Jkt = new PointF();
    this.Jkr = paramb;
    paramb = (WindowManager)MMApplicationContext.getContext().getSystemService("window");
    WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
    if (d.oD(26)) {}
    for (localLayoutParams.type = 2038;; localLayoutParams.type = 2002)
    {
      localLayoutParams.format = 1;
      localLayoutParams.flags = 40;
      localLayoutParams.gravity = 85;
      localLayoutParams.width = b.JkD;
      localLayoutParams.height = b.JkD;
      localLayoutParams.x = 0;
      localLayoutParams.y = 0;
      this.Jkq = new a(MMApplicationContext.getContext());
      try
      {
        this.Jkq.setVisibility(8);
        paramb.addView(this.Jkq, localLayoutParams);
        AppMethodBeat.o(80412);
        return;
      }
      catch (Exception paramb)
      {
        Log.e("MicroMsg.BagCancelController", "showCanceller add failed %s", new Object[] { paramb });
        AppMethodBeat.o(80412);
      }
    }
  }
  
  static final class a
    extends FrameLayout
  {
    View mContentView;
    Vibrator ooM;
    ImageView rIY;
    
    public a(Context paramContext)
    {
      super();
      AppMethodBeat.i(80409);
      this.ooM = ((Vibrator)paramContext.getSystemService("vibrator"));
      LayoutInflater.from(paramContext).inflate(2131497066, this);
      this.rIY = ((ImageView)findViewById(2131297352));
      paramContext = (RelativeLayout.LayoutParams)this.rIY.getLayoutParams();
      paramContext.height = b.JkC;
      paramContext.width = b.JkC;
      this.rIY.setLayoutParams(paramContext);
      this.mContentView = findViewById(2131299180);
      AppMethodBeat.o(80409);
    }
    
    final void aq(float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(80410);
      ScaleAnimation localScaleAnimation = new ScaleAnimation(paramFloat1, paramFloat2, paramFloat1, paramFloat2, 1, 1.0F, 1, 1.0F);
      localScaleAnimation.setFillAfter(true);
      localScaleAnimation.setDuration(50L);
      this.rIY.startAnimation(localScaleAnimation);
      AppMethodBeat.o(80410);
    }
  }
  
  public static abstract interface b
  {
    public abstract void ggn();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.a
 * JD-Core Version:    0.7.0.1
 */