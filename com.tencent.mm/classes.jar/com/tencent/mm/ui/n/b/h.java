package com.tencent.mm.ui.n.b;

import android.util.Pair;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.RotateAnimation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.a;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.chatting.view.ChattingAvatarImageView;
import com.tencent.mm.ui.chatting.viewitems.ab.a;
import com.tencent.mm.ui.chatting.viewitems.c;
import com.tencent.mm.ui.chatting.viewitems.c.a;
import com.tencent.mm.ui.n.a.b;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/magicemoji/jsapi/MEShakeBubblesAndAvatars;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;", "Lcom/tencent/mm/ui/magicemoji/jsapi/IMEChattingJsApi;", "()V", "arrDelay", "", "arrRotation", "", "avatarAnimationBoomFromLeft", "Ljava/util/LinkedList;", "Landroid/view/animation/AnimationSet;", "avatarAnimationBoomFromRight", "leftBubbleAnimationBoomFromLeft", "leftBubbleAnimationBoomFromRight", "moveLeftAnimation", "Landroid/view/animation/Animation;", "moveRightAnimation", "rightBubbleAnimationBoomFromLeft", "rightBubbleAnimationBoomFromRight", "createShakeAnimation", "shake_para_list", "", "Lcom/tencent/mm/ui/magicemoji/jsapi/MEShakeBubblesAndAvatars$RotateAnimationPara;", "prvotValue", "", "invoke", "", "env", "Lcom/tencent/mm/ui/magicemoji/core/MEChattingMgr;", "data", "Lorg/json/JSONObject;", "makeAnimation", "", "resetAnimation", "animation", "resetAnimationSet", "animationSet", "stopAll", "Companion", "MEAnimationListener", "RotateAnimationPara", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  extends com.tencent.mm.plugin.appbrand.jsapi.p
  implements a
{
  private static final String NAME = "shakeVisibleBubblesAndAvatars";
  public static final h.a afwW;
  private final float[] afwX;
  private final long[] afwY;
  private Animation afwZ;
  private Animation afxa;
  private final LinkedList<AnimationSet> afxb;
  private final LinkedList<AnimationSet> afxc;
  private final LinkedList<AnimationSet> afxd;
  private final LinkedList<AnimationSet> afxe;
  private final LinkedList<AnimationSet> afxf;
  private final LinkedList<AnimationSet> afxg;
  
  static
  {
    AppMethodBeat.i(249863);
    afwW = new h.a((byte)0);
    AppMethodBeat.o(249863);
  }
  
  public h()
  {
    AppMethodBeat.i(249834);
    this.afwX = new float[] { 15.0F, 12.0F, 9.0F, 6.0F, 3.0F };
    this.afwY = new long[] { 0L, 50L, 100L, 150L, 200L };
    this.afxb = new LinkedList();
    this.afxc = new LinkedList();
    this.afxd = new LinkedList();
    this.afxe = new LinkedList();
    this.afxf = new LinkedList();
    this.afxg = new LinkedList();
    AppMethodBeat.o(249834);
  }
  
  private static void a(AnimationSet paramAnimationSet)
  {
    AppMethodBeat.i(249857);
    paramAnimationSet = paramAnimationSet.getAnimations();
    s.s(paramAnimationSet, "animationSet.animations");
    paramAnimationSet = ((Iterable)paramAnimationSet).iterator();
    while (paramAnimationSet.hasNext()) {
      d((Animation)paramAnimationSet.next());
    }
    AppMethodBeat.o(249857);
  }
  
  private static AnimationSet c(List<h.c> paramList, float paramFloat)
  {
    AppMethodBeat.i(249841);
    AnimationSet localAnimationSet = new AnimationSet(false);
    int k = paramList.size() - 1;
    if (k >= 0) {}
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      h.c localc = (h.c)paramList.get(i);
      Animation localAnimation = (Animation)new RotateAnimation(0.0F, localc.afxh, 1, paramFloat, 1, 0.0F);
      localAnimation.setDuration(localc.duration);
      localAnimation.setStartOffset(localc.cXM);
      if (i == 0) {
        localAnimation.setInterpolator((Interpolator)new AccelerateInterpolator());
      }
      for (;;)
      {
        localAnimationSet.addAnimation(localAnimation);
        if (j <= k) {
          break;
        }
        AppMethodBeat.o(249841);
        return localAnimationSet;
        if (i == paramList.size() - 1) {
          localAnimation.setInterpolator((Interpolator)new DecelerateInterpolator());
        } else {
          localAnimation.setInterpolator((Interpolator)new AccelerateDecelerateInterpolator());
        }
      }
    }
  }
  
  private static void d(Animation paramAnimation)
  {
    AppMethodBeat.i(249850);
    if (paramAnimation.hasStarted())
    {
      paramAnimation.cancel();
      paramAnimation.reset();
    }
    AppMethodBeat.o(249850);
  }
  
  public final String a(b paramb, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(249878);
    s.u(paramb, "env");
    s.u(paramJSONObject, "data");
    Log.i("MicroMsg.MEShakeBubblesAndAvatar", "stevecai: shake");
    paramb = paramb.adCQ;
    if ((this.afwZ == null) || (this.afxa == null))
    {
      this.afwZ = AnimationUtils.loadAnimation(MMApplicationContext.getContext(), R.a.fjz);
      this.afxa = AnimationUtils.loadAnimation(MMApplicationContext.getContext(), R.a.fjA);
    }
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      float f = this.afwX[i];
      long l = this.afwY[i];
      Object localObject1 = kotlin.a.p.listOf(new h.c[] { new h.c(f, 50L, l), new h.c(-2.0F * f, 100L, 50L + l), new h.c(2.0F * f, 100L, 150L + l), new h.c(-2.0F * f, 100L, 250L + l), new h.c(f, 50L, 350L + l) });
      Object localObject2 = c((List)localObject1, 0.0F);
      ((AnimationSet)localObject2).addAnimation(this.afwZ);
      this.afxc.add(localObject2);
      localObject2 = c((List)localObject1, 0.0F);
      ((AnimationSet)localObject2).addAnimation(this.afxa);
      this.afxf.add(localObject2);
      localObject2 = c((List)localObject1, 1.0F);
      ((AnimationSet)localObject2).addAnimation(this.afwZ);
      this.afxd.add(localObject2);
      localObject1 = c((List)localObject1, 1.0F);
      ((AnimationSet)localObject1).addAnimation(this.afxa);
      this.afxg.add(localObject1);
      localObject1 = kotlin.a.p.listOf(new h.c[] { new h.c(f, 34L, l), new h.c(-2.0F * f, 67L, 34L + l), new h.c(2.0F * f, 67L, 101L + l), new h.c(-2.0F * f, 67L, 168L + l), new h.c(2.0F * f, 67L, 235L + l), new h.c(-2.0F * f, 67L, 312L + l), new h.c(f, 34L, 379L + l) });
      localObject2 = c((List)localObject1, 0.5F);
      ((AnimationSet)localObject2).addAnimation(this.afwZ);
      this.afxb.add(localObject2);
      localObject1 = c((List)localObject1, 0.5F);
      ((AnimationSet)localObject1).addAnimation(this.afxa);
      this.afxe.add(localObject1);
      if (j >= 5)
      {
        localObject1 = com.tencent.mm.ui.n.c.a.a(paramb, true);
        if (localObject1 == null)
        {
          Log.e("MicroMsg.MEShakeBubblesAndAvatar", "hy: no visible views");
          paramb = a(null, a.e.rVD, null);
          AppMethodBeat.o(249878);
          return paramb;
        }
        boolean bool = paramJSONObject.optBoolean("isFrom", false);
        localObject2 = ((Iterable)localObject1).iterator();
        c.a locala;
        label651:
        ChattingAvatarImageView localChattingAvatarImageView;
        if (((Iterator)localObject2).hasNext())
        {
          paramJSONObject = (Pair)((Iterator)localObject2).next();
          locala = (c.a)paramJSONObject.second;
          if ((locala instanceof ab.a))
          {
            paramb = ((ab.a)locala).hDw;
            localChattingAvatarImageView = locala.avatarIV;
            i = ((List)localObject1).size() - ((List)localObject1).indexOf(paramJSONObject) - 1;
            if (i < this.afwX.length) {
              break label938;
            }
            i = this.afwX.length - 1;
          }
        }
        label896:
        label938:
        for (;;)
        {
          if (paramb != null)
          {
            if (!locala.chattingItem.fXn()) {
              break label847;
            }
            if (bool)
            {
              paramJSONObject = (AnimationSet)this.afxd.get(i);
              label730:
              s.s(paramJSONObject, "{\n                    if…eIndex]\n                }");
              paramJSONObject = (Animation)paramJSONObject;
              paramJSONObject.setAnimationListener((Animation.AnimationListener)new h.b(paramb));
              paramb.startAnimation(paramJSONObject);
            }
          }
          else
          {
            if (localChattingAvatarImageView == null) {
              break;
            }
            if (!bool) {
              break label896;
            }
            paramb = this.afxb.get(i);
            s.s(paramb, "avatarAnimationBoomFromLeft[shakeIndex]");
          }
          for (paramb = (Animation)paramb;; paramb = (Animation)paramb)
          {
            paramb.setAnimationListener((Animation.AnimationListener)new h.b((View)localChattingAvatarImageView));
            localChattingAvatarImageView.startAnimation(paramb);
            break;
            paramb = locala.getMainContainerView();
            break label651;
            paramJSONObject = (AnimationSet)this.afxg.get(i);
            break label730;
            label847:
            if (bool) {}
            for (paramJSONObject = (AnimationSet)this.afxc.get(i);; paramJSONObject = (AnimationSet)this.afxf.get(i))
            {
              s.s(paramJSONObject, "{\n                    if…eIndex]\n                }");
              paramJSONObject = (Animation)paramJSONObject;
              break;
            }
            paramb = this.afxe.get(i);
            s.s(paramb, "avatarAnimationBoomFromRight[shakeIndex]");
          }
          paramb = a(null, a.e.rVt, null);
          AppMethodBeat.o(249878);
          return paramb;
        }
      }
    }
  }
  
  public final void stopAll()
  {
    AppMethodBeat.i(249883);
    Log.i("MicroMsg.MEShakeBubblesAndAvatar", "stevecai: stopAll");
    Object localObject = this.afwZ;
    if (localObject != null) {
      d((Animation)localObject);
    }
    localObject = this.afxa;
    if (localObject != null) {
      d((Animation)localObject);
    }
    localObject = ((Iterable)this.afxb).iterator();
    while (((Iterator)localObject).hasNext()) {
      a((AnimationSet)((Iterator)localObject).next());
    }
    localObject = ((Iterable)this.afxc).iterator();
    while (((Iterator)localObject).hasNext()) {
      a((AnimationSet)((Iterator)localObject).next());
    }
    localObject = ((Iterable)this.afxd).iterator();
    while (((Iterator)localObject).hasNext()) {
      a((AnimationSet)((Iterator)localObject).next());
    }
    localObject = ((Iterable)this.afxe).iterator();
    while (((Iterator)localObject).hasNext()) {
      a((AnimationSet)((Iterator)localObject).next());
    }
    localObject = ((Iterable)this.afxf).iterator();
    while (((Iterator)localObject).hasNext()) {
      a((AnimationSet)((Iterator)localObject).next());
    }
    localObject = ((Iterable)this.afxg).iterator();
    while (((Iterator)localObject).hasNext()) {
      a((AnimationSet)((Iterator)localObject).next());
    }
    AppMethodBeat.o(249883);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.n.b.h
 * JD-Core Version:    0.7.0.1
 */