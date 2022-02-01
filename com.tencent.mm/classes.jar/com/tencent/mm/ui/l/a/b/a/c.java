package com.tencent.mm.ui.l.a.b.a;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ChattingUIFragment;
import com.tencent.mm.ui.chatting.view.ChattingAvatarImageView;
import com.tencent.mm.ui.chatting.viewitems.aa.a;
import com.tencent.mm.ui.l.a.e;
import com.tencent.mm.ui.l.a.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public final class c
  extends d<g>
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "shakeVisibleBubblesAndAvatars";
  private static final float[] Qmk = { 15.0F, 12.0F, 9.0F, 6.0F, 3.0F };
  private static final long[] Qml = { 0L, 50L, 100L, 150L, 200L };
  private Animation Qmm;
  private Animation Qmn;
  private final AnimationSet[] Qmo;
  private final AnimationSet[] Qmp;
  private final AnimationSet[] Qmq;
  private final AnimationSet[] Qmr;
  private final AnimationSet[] Qms;
  private final AnimationSet[] Qmt;
  
  public c()
  {
    AppMethodBeat.i(258303);
    this.Qmm = null;
    this.Qmn = null;
    this.Qmo = new AnimationSet[5];
    this.Qmp = new AnimationSet[5];
    this.Qmq = new AnimationSet[5];
    this.Qmr = new AnimationSet[5];
    this.Qms = new AnimationSet[5];
    this.Qmt = new AnimationSet[5];
    AppMethodBeat.o(258303);
  }
  
  private static AnimationSet a(a[] paramArrayOfa, float paramFloat)
  {
    AppMethodBeat.i(234439);
    AnimationSet localAnimationSet = new AnimationSet(false);
    int i = 0;
    if (i < paramArrayOfa.length)
    {
      a locala = paramArrayOfa[i];
      RotateAnimation localRotateAnimation = new RotateAnimation(0.0F, locala.Qmw, 1, paramFloat, 1, 0.0F);
      localRotateAnimation.setDuration(locala.duration);
      localRotateAnimation.setStartOffset(locala.buq);
      if (i == 0) {
        localRotateAnimation.setInterpolator(new AccelerateInterpolator());
      }
      for (;;)
      {
        localAnimationSet.addAnimation(localRotateAnimation);
        i += 1;
        break;
        if (i == paramArrayOfa.length - 1) {
          localRotateAnimation.setInterpolator(new DecelerateInterpolator());
        } else {
          localRotateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        }
      }
    }
    AppMethodBeat.o(234439);
    return localAnimationSet;
  }
  
  static final class a
  {
    public float Qmw;
    public long buq;
    public long duration;
    
    public a(float paramFloat, long paramLong1, long paramLong2)
    {
      this.Qmw = paramFloat;
      this.duration = paramLong1;
      this.buq = paramLong2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.l.a.b.a.c
 * JD-Core Version:    0.7.0.1
 */