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
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.c.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.widget.e;

public final class a
{
  static final int WZK;
  boolean LCZ;
  a WZL;
  final b WZM;
  boolean WZN;
  PointF WZO;
  boolean WZP;
  boolean WZQ;
  int mScreenHeight;
  int mScreenWidth;
  
  static
  {
    int i = b.WZY;
    WZK = i * i;
  }
  
  public a(b paramb)
  {
    AppMethodBeat.i(80412);
    this.WZO = new PointF();
    this.WZM = paramb;
    paramb = (WindowManager)MMApplicationContext.getContext().getSystemService("window");
    WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
    if (d.rb(26)) {}
    for (localLayoutParams.type = 2038;; localLayoutParams.type = 2002)
    {
      localLayoutParams.format = 1;
      localLayoutParams.flags = 40;
      localLayoutParams.gravity = 85;
      localLayoutParams.width = b.WZZ;
      localLayoutParams.height = b.WZZ;
      localLayoutParams.x = 0;
      localLayoutParams.y = 0;
      this.WZL = new a(MMApplicationContext.getContext());
      try
      {
        this.WZL.setVisibility(8);
        paramb.addView(this.WZL, localLayoutParams);
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
    Vibrator cqQ;
    View mContentView;
    ImageView yBc;
    
    public a(Context paramContext)
    {
      super();
      AppMethodBeat.i(80409);
      this.cqQ = ((Vibrator)paramContext.getSystemService("vibrator"));
      LayoutInflater.from(paramContext).inflate(c.g.webview_bag_canceller, this);
      this.yBc = ((ImageView)findViewById(c.f.bg));
      paramContext = (RelativeLayout.LayoutParams)this.yBc.getLayoutParams();
      paramContext.height = b.WZY;
      paramContext.width = b.WZY;
      this.yBc.setLayoutParams(paramContext);
      this.mContentView = findViewById(c.f.content);
      AppMethodBeat.o(80409);
    }
    
    final void bb(float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(80410);
      ScaleAnimation localScaleAnimation = new ScaleAnimation(paramFloat1, paramFloat2, paramFloat1, paramFloat2, 1, 1.0F, 1, 1.0F);
      localScaleAnimation.setFillAfter(true);
      localScaleAnimation.setDuration(50L);
      this.yBc.startAnimation(localScaleAnimation);
      AppMethodBeat.o(80410);
    }
  }
  
  public static abstract interface b
  {
    public abstract void izB();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.a
 * JD-Core Version:    0.7.0.1
 */