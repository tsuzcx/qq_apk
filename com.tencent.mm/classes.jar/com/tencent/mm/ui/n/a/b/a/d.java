package com.tencent.mm.ui.n.a.b.a;

import android.util.Pair;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.chatting.view.ChattingAvatarImageView;
import com.tencent.mm.ui.chatting.viewitems.ad.a;
import com.tencent.mm.ui.chatting.viewitems.c.a;
import com.tencent.mm.ui.n.a.e;
import com.tencent.mm.ui.n.a.e.a;
import com.tencent.mm.ui.n.a.g;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public final class d
  extends com.tencent.mm.plugin.appbrand.jsapi.c<g>
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "shakeVisibleBubblesAndAvatars";
  private static final float[] XKc = { 15.0F, 12.0F, 9.0F, 6.0F, 3.0F };
  private static final long[] XKd = { 0L, 50L, 100L, 150L, 200L };
  private Animation XKe;
  private Animation XKf;
  private final AnimationSet[] XKg;
  private final AnimationSet[] XKh;
  private final AnimationSet[] XKi;
  private final AnimationSet[] XKj;
  private final AnimationSet[] XKk;
  private final AnimationSet[] XKl;
  private boolean XKm;
  
  public d()
  {
    AppMethodBeat.i(284727);
    this.XKe = null;
    this.XKf = null;
    this.XKg = new AnimationSet[5];
    this.XKh = new AnimationSet[5];
    this.XKi = new AnimationSet[5];
    this.XKj = new AnimationSet[5];
    this.XKk = new AnimationSet[5];
    this.XKl = new AnimationSet[5];
    this.XKm = false;
    AppMethodBeat.o(284727);
  }
  
  private static AnimationSet a(b[] paramArrayOfb, float paramFloat)
  {
    AppMethodBeat.i(284730);
    AnimationSet localAnimationSet = new AnimationSet(false);
    int i = 0;
    if (i < paramArrayOfb.length)
    {
      b localb = paramArrayOfb[i];
      RotateAnimation localRotateAnimation = new RotateAnimation(0.0F, localb.XKp, 1, paramFloat, 1, 0.0F);
      localRotateAnimation.setDuration(localb.duration);
      localRotateAnimation.setStartOffset(localb.bdS);
      if (i == 0) {
        localRotateAnimation.setInterpolator(new AccelerateInterpolator());
      }
      for (;;)
      {
        localAnimationSet.addAnimation(localRotateAnimation);
        i += 1;
        break;
        if (i == paramArrayOfb.length - 1) {
          localRotateAnimation.setInterpolator(new DecelerateInterpolator());
        } else {
          localRotateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        }
      }
    }
    AppMethodBeat.o(284730);
    return localAnimationSet;
  }
  
  private static void a(AnimationSet[] paramArrayOfAnimationSet)
  {
    AppMethodBeat.i(284729);
    int j = paramArrayOfAnimationSet.length;
    int i = 0;
    while (i < j)
    {
      AnimationSet localAnimationSet = paramArrayOfAnimationSet[i];
      Object localObject = localAnimationSet.getAnimations();
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          c((Animation)((Iterator)localObject).next());
        }
      }
      c(localAnimationSet);
      i += 1;
    }
    AppMethodBeat.o(284729);
  }
  
  private static void c(Animation paramAnimation)
  {
    AppMethodBeat.i(284728);
    if (paramAnimation != null) {
      paramAnimation.reset();
    }
    AppMethodBeat.o(284728);
  }
  
  static final class b
  {
    public float XKp;
    public long bdS;
    public long duration;
    
    public b(float paramFloat, long paramLong1, long paramLong2)
    {
      this.XKp = paramFloat;
      this.duration = paramLong1;
      this.bdS = paramLong2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.n.a.b.a.d
 * JD-Core Version:    0.7.0.1
 */