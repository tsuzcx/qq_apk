package com.tencent.mm.view.refreshLayout.g;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.view.refreshLayout.WxRefreshLayout;
import com.tencent.mm.view.refreshLayout.a.c;
import com.tencent.mm.view.refreshLayout.a.d;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/view/refreshLayout/widget/RefreshAnimationHelper;", "", "layout", "Lcom/tencent/mm/view/refreshLayout/WxRefreshLayout;", "stateCenter", "Lcom/tencent/mm/view/refreshLayout/widget/LayoutStateCenter;", "(Lcom/tencent/mm/view/refreshLayout/WxRefreshLayout;Lcom/tencent/mm/view/refreshLayout/widget/LayoutStateCenter;)V", "animationRunnable", "Ljava/lang/Runnable;", "getAnimationRunnable", "()Ljava/lang/Runnable;", "setAnimationRunnable", "(Ljava/lang/Runnable;)V", "cValues", "Lcom/tencent/mm/view/refreshLayout/config/CommonValue;", "reboundAnimator", "Landroid/animation/ValueAnimator;", "getReboundAnimator", "()Landroid/animation/ValueAnimator;", "setReboundAnimator", "(Landroid/animation/ValueAnimator;)V", "animSpinner", "endSpinner", "", "startDelay", "interpolator", "Landroid/view/animation/Interpolator;", "duration", "animSpinnerBounce", "", "velocity", "", "cancelRebound", "interceptAnimatorByAction", "", "action", "onFlingRun", "resetAnim", "setCommonValue", "commonValue", "BounceRunnable", "FlingRunnable", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public final a agPj;
  public com.tencent.mm.view.refreshLayout.a.b agPn;
  public final WxRefreshLayout agRh;
  public Runnable agRl;
  public ValueAnimator agRm;
  
  public b(WxRefreshLayout paramWxRefreshLayout, a parama)
  {
    AppMethodBeat.i(235114);
    this.agRh = paramWxRefreshLayout;
    this.agPj = parama;
    AppMethodBeat.o(235114);
  }
  
  private static final void a(b paramb, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(235118);
    s.u(paramb, "this$0");
    paramb = paramb.agRh;
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramb = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(235118);
      throw paramb;
    }
    paramb.db(((Integer)paramValueAnimator).intValue(), false);
    AppMethodBeat.o(235118);
  }
  
  public final ValueAnimator a(int paramInt1, int paramInt2, Interpolator paramInterpolator, int paramInt3)
  {
    Object localObject2 = null;
    AppMethodBeat.i(235165);
    com.tencent.mm.view.refreshLayout.a.b localb = this.agPn;
    Object localObject1 = localb;
    if (localb == null)
    {
      s.bIx("cValues");
      localObject1 = null;
    }
    if (((com.tencent.mm.view.refreshLayout.a.b)localObject1).agPU != paramInt1)
    {
      jNU();
      this.agRl = null;
      localObject1 = this.agPn;
      if (localObject1 == null)
      {
        s.bIx("cValues");
        localObject1 = localObject2;
      }
      for (;;)
      {
        localObject1 = ValueAnimator.ofInt(new int[] { ((com.tencent.mm.view.refreshLayout.a.b)localObject1).agPU, paramInt1 });
        ((ValueAnimator)localObject1).setDuration(paramInt3);
        ((ValueAnimator)localObject1).setInterpolator((TimeInterpolator)paramInterpolator);
        ((ValueAnimator)localObject1).addListener((Animator.AnimatorListener)new c(this));
        ((ValueAnimator)localObject1).addUpdateListener(new b..ExternalSyntheticLambda0(this));
        ((ValueAnimator)localObject1).setStartDelay(paramInt2);
        ((ValueAnimator)localObject1).start();
        paramInterpolator = ah.aiuX;
        this.agRm = ((ValueAnimator)localObject1);
        paramInterpolator = this.agRm;
        AppMethodBeat.o(235165);
        return paramInterpolator;
      }
    }
    AppMethodBeat.o(235165);
    return null;
  }
  
  public final void a(com.tencent.mm.view.refreshLayout.a.b paramb)
  {
    AppMethodBeat.i(235147);
    s.u(paramb, "commonValue");
    this.agPn = paramb;
    AppMethodBeat.o(235147);
  }
  
  public final boolean aGp(int paramInt)
  {
    AppMethodBeat.i(235156);
    ValueAnimator localValueAnimator;
    if (paramInt == 0)
    {
      localValueAnimator = this.agRm;
      if (localValueAnimator != null)
      {
        if ((this.agPj.agRi.isFinishing) || (this.agPj.jNJ()) || (this.agPj.jNK()))
        {
          AppMethodBeat.o(235156);
          return true;
        }
        if (!this.agPj.jNL()) {
          break label112;
        }
        this.agPj.c(com.tencent.mm.view.refreshLayout.e.b.agQQ);
      }
    }
    for (;;)
    {
      localValueAnimator.setDuration(0L);
      localValueAnimator.cancel();
      this.agRm = null;
      this.agRl = null;
      if (this.agRm == null) {
        break;
      }
      AppMethodBeat.o(235156);
      return true;
      label112:
      if (this.agPj.jNM()) {
        this.agPj.c(com.tencent.mm.view.refreshLayout.e.b.agQS);
      }
    }
    AppMethodBeat.o(235156);
    return false;
  }
  
  public final void eB(float paramFloat)
  {
    AppMethodBeat.i(235151);
    this.agRl = new b(paramFloat).jNV();
    AppMethodBeat.o(235151);
  }
  
  public final void jNU()
  {
    AppMethodBeat.i(235169);
    ValueAnimator localValueAnimator = this.agRm;
    if (localValueAnimator != null)
    {
      localValueAnimator.setDuration(0L);
      localValueAnimator.cancel();
      this.agRm = null;
    }
    AppMethodBeat.o(235169);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/view/refreshLayout/widget/RefreshAnimationHelper$BounceRunnable;", "Ljava/lang/Runnable;", "velocity", "", "smoothDistance", "", "(Lcom/tencent/mm/view/refreshLayout/widget/RefreshAnimationHelper;FI)V", "frame", "getFrame", "()I", "setFrame", "(I)V", "frameDelay", "getFrameDelay", "setFrameDelay", "lastTime", "", "getLastTime", "()J", "setLastTime", "(J)V", "offset", "getOffset", "()F", "setOffset", "(F)V", "getSmoothDistance", "setSmoothDistance", "getVelocity", "setVelocity", "run", "", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
    implements Runnable
  {
    private float aac;
    private int agRn;
    private int agRo;
    private int agRp;
    private long mJI;
    private float offset;
    
    public a(int paramInt)
    {
      AppMethodBeat.i(235101);
      this.aac = paramInt;
      int i;
      this.agRn = i;
      this.agRp = 10;
      this.mJI = AnimationUtils.currentAnimationTimeMillis();
      b.c(b.this).getMainHandler().postDelayed((Runnable)this, this.agRp);
      if (this.aac > 0.0F)
      {
        b.b(b.this).c(com.tencent.mm.view.refreshLayout.e.b.agQQ);
        AppMethodBeat.o(235101);
        return;
      }
      b.b(b.this).c(com.tencent.mm.view.refreshLayout.e.b.agQS);
      AppMethodBeat.o(235101);
    }
    
    public final void run()
    {
      Object localObject2 = null;
      AppMethodBeat.i(235111);
      Object localObject3;
      Object localObject1;
      if ((b.this.agRl == this) && (!b.b(b.this).agRi.isFinishing))
      {
        float f2 = this.aac;
        localObject3 = b.a(b.this);
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          s.bIx("cValues");
          localObject1 = null;
        }
        float f1;
        if (Math.abs(((com.tencent.mm.view.refreshLayout.a.b)localObject1).agPU) >= Math.abs(this.agRn)) {
          if (this.agRn != 0)
          {
            this.agRo += 1;
            f1 = (float)Math.pow(0.45D, this.agRo * 2);
          }
        }
        for (;;)
        {
          this.aac = (f1 * f2);
          long l = AnimationUtils.currentAnimationTimeMillis();
          f1 = (float)(l - this.mJI) * 1.0F / 1000.0F * this.aac;
          if (Math.abs(f1) < 1.0F) {
            break;
          }
          this.mJI = l;
          this.offset = (f1 + this.offset);
          b.c(b.this).ez(this.offset);
          b.c(b.this).getMainHandler().postDelayed((Runnable)this, this.agRp);
          AppMethodBeat.o(235111);
          return;
          this.agRo += 1;
          f1 = (float)Math.pow(0.85D, this.agRo * 2);
          continue;
          this.agRo += 1;
          f1 = (float)Math.pow(0.95D, this.agRo * 2);
        }
        if ((!b.b(b.this).agRj.mlX) || (!b.b(b.this).agRj.agQI)) {
          break label474;
        }
        b.b(b.this).c(com.tencent.mm.view.refreshLayout.e.b.agQP);
        b.this.agRl = null;
        localObject3 = b.a(b.this);
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          s.bIx("cValues");
          localObject1 = null;
        }
        if (Math.abs(((com.tencent.mm.view.refreshLayout.a.b)localObject1).agPU) >= Math.abs(this.agRn))
        {
          localObject3 = b.c(b.this).getContext();
          localObject1 = b.a(b.this);
          if (localObject1 != null) {
            break label522;
          }
          s.bIx("cValues");
          localObject1 = localObject2;
        }
      }
      label522:
      for (;;)
      {
        int i = Math.min(Math.max((int)(Math.abs(((com.tencent.mm.view.refreshLayout.a.b)localObject1).agPU - this.agRn) / ((Context)localObject3).getResources().getDisplayMetrics().density), 30), 100);
        b.this.a(this.agRn, 0, b.c(b.this).getInterpolator(), i * 10);
        AppMethodBeat.o(235111);
        return;
        label474:
        if ((!b.b(b.this).agRj.mlX) || (!b.b(b.this).agRj.agQJ)) {
          break;
        }
        b.b(b.this).c(com.tencent.mm.view.refreshLayout.e.b.agQR);
        break;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/view/refreshLayout/widget/RefreshAnimationHelper$FlingRunnable;", "Ljava/lang/Runnable;", "velocity", "", "(Lcom/tencent/mm/view/refreshLayout/widget/RefreshAnimationHelper;F)V", "damping", "getDamping", "()F", "setDamping", "(F)V", "frameDelay", "", "getFrameDelay", "()I", "setFrameDelay", "(I)V", "lastTime", "", "getLastTime", "()J", "setLastTime", "(J)V", "offset", "getOffset", "setOffset", "startTime", "getStartTime", "setStartTime", "getVelocity", "setVelocity", "run", "", "start", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    implements Runnable
  {
    private float aac;
    private float agJd;
    private int agRp;
    private long mJI;
    private int offset;
    private long startTime;
    
    public b()
    {
      AppMethodBeat.i(235090);
      Object localObject;
      this.aac = localObject;
      com.tencent.mm.view.refreshLayout.a.b localb = b.a(b.this);
      this$1 = localb;
      if (localb == null)
      {
        s.bIx("cValues");
        this$1 = null;
      }
      this.offset = b.this.agPU;
      this.agRp = 10;
      this.agJd = 0.98F;
      this.mJI = AnimationUtils.currentAnimationTimeMillis();
      AppMethodBeat.o(235090);
    }
    
    public final Runnable jNV()
    {
      AppMethodBeat.i(235102);
      if (b.b(b.this).agRi.isFinishing)
      {
        AppMethodBeat.o(235102);
        return null;
      }
      com.tencent.mm.view.refreshLayout.a.b localb = b.a(b.this);
      Object localObject = localb;
      if (localb == null)
      {
        s.bIx("cValues");
        localObject = null;
      }
      if (((com.tencent.mm.view.refreshLayout.a.b)localObject).agPU != 0)
      {
        if (!b.b(b.this).agRi.LWA)
        {
          localb = b.a(b.this);
          localObject = localb;
          if (localb == null)
          {
            s.bIx("cValues");
            localObject = null;
          }
          if ((((com.tencent.mm.view.refreshLayout.a.b)localObject).agQh) && (b.c(b.this).getCommonConfig().agPI))
          {
            localb = b.a(b.this);
            localObject = localb;
            if (localb == null)
            {
              s.bIx("cValues");
              localObject = null;
            }
            if ((!((com.tencent.mm.view.refreshLayout.a.b)localObject).agQi) || (!b.c(b.this).Oc(b.c(b.this).getCommonConfig().Jcx))) {}
          }
        }
        else
        {
          if (!b.b(b.this).isLoading())
          {
            localb = b.a(b.this);
            localObject = localb;
            if (localb == null)
            {
              s.bIx("cValues");
              localObject = null;
            }
            if ((((com.tencent.mm.view.refreshLayout.a.b)localObject).agQh) && (b.c(b.this).getCommonConfig().agPI))
            {
              localb = b.a(b.this);
              localObject = localb;
              if (localb == null)
              {
                s.bIx("cValues");
                localObject = null;
              }
              if ((!((com.tencent.mm.view.refreshLayout.a.b)localObject).agQi) || (!b.c(b.this).Oc(b.c(b.this).getCommonConfig().Jcx))) {}
            }
          }
          else
          {
            localb = b.a(b.this);
            localObject = localb;
            if (localb == null)
            {
              s.bIx("cValues");
              localObject = null;
            }
            if (((com.tencent.mm.view.refreshLayout.a.b)localObject).agPU < -b.c(b.this).getFooterConfig().footerHeight) {
              break label419;
            }
          }
          if (!b.b(b.this).jME()) {
            break label654;
          }
          localb = b.a(b.this);
          localObject = localb;
          if (localb == null)
          {
            s.bIx("cValues");
            localObject = null;
          }
          if (((com.tencent.mm.view.refreshLayout.a.b)localObject).agPU <= b.c(b.this).getHeaderConfig().headerHeight) {
            break label654;
          }
        }
        label419:
        int j = 0;
        localb = b.a(b.this);
        localObject = localb;
        if (localb == null)
        {
          s.bIx("cValues");
          localObject = null;
        }
        int i = ((com.tencent.mm.view.refreshLayout.a.b)localObject).agPU;
        localb = b.a(b.this);
        localObject = localb;
        if (localb == null)
        {
          s.bIx("cValues");
          localObject = null;
        }
        int k = ((com.tencent.mm.view.refreshLayout.a.b)localObject).agPU;
        float f1 = this.aac;
        while (k * i > 0)
        {
          double d = this.agJd;
          j += 1;
          f1 *= (float)Math.pow(d, this.agRp * j / 10.0F);
          float f2 = this.agRp * 1.0F / 1000.0F * f1;
          if (Math.abs(f2) < 1.0F)
          {
            if ((b.b(b.this).agRi.LWA) && ((!b.b(b.this).jME()) || (i <= b.c(b.this).getHeaderConfig().headerHeight)) && ((b.b(b.this).jME()) || (i >= -b.c(b.this).getFooterConfig().footerHeight))) {
              break;
            }
            AppMethodBeat.o(235102);
            return null;
          }
          i += (int)f2;
        }
      }
      label654:
      this.startTime = AnimationUtils.currentAnimationTimeMillis();
      b.c(b.this).getMainHandler().postDelayed((Runnable)this, this.agRp);
      localObject = (Runnable)this;
      AppMethodBeat.o(235102);
      return localObject;
    }
    
    public final void run()
    {
      Object localObject2 = null;
      AppMethodBeat.i(235108);
      if ((b.this.agRl == this) && (!b.b(b.this).agRi.isFinishing))
      {
        long l1 = AnimationUtils.currentAnimationTimeMillis();
        long l2 = this.mJI;
        this.aac *= (float)Math.pow(this.agJd, (float)(l1 - this.startTime) / (1000.0F / this.agRp));
        float f = this.aac;
        f = (float)(l1 - l2) * 1.0F / 1000.0F * f;
        if (Math.abs(f) > 1.0F)
        {
          this.mJI = l1;
          this.offset += (int)f;
          com.tencent.mm.view.refreshLayout.a.b localb = b.a(b.this);
          Object localObject1 = localb;
          if (localb == null)
          {
            s.bIx("cValues");
            localObject1 = null;
          }
          if (((com.tencent.mm.view.refreshLayout.a.b)localObject1).agPU * this.offset > 0)
          {
            b.c(b.this).db(this.offset, true);
            b.c(b.this).getMainHandler().postDelayed((Runnable)this, this.agRp);
            AppMethodBeat.o(235108);
            return;
          }
          b.this.agRl = null;
          b.c(b.this).db(0, true);
          localObject1 = com.tencent.mm.view.refreshLayout.f.a.agRg;
          localObject1 = b.c(b.this).getContentView();
          if (localObject1 == null)
          {
            localObject1 = null;
            com.tencent.mm.view.refreshLayout.f.a.bF((View)localObject1, (int)-this.aac);
            localb = b.a(b.this);
            localObject1 = localb;
            if (localb == null)
            {
              s.bIx("cValues");
              localObject1 = null;
            }
            if ((!((com.tencent.mm.view.refreshLayout.a.b)localObject1).agPX) || (f <= 0.0F)) {
              break label360;
            }
            localObject1 = b.a(b.this);
            if (localObject1 != null) {
              break label349;
            }
            s.bIx("cValues");
            localObject1 = localObject2;
          }
          label349:
          for (;;)
          {
            ((com.tencent.mm.view.refreshLayout.a.b)localObject1).agPX = false;
            AppMethodBeat.o(235108);
            return;
            localObject1 = ((com.tencent.mm.view.refreshLayout.b.a)localObject1).jNz();
            break;
          }
        }
        else
        {
          b.this.agRl = null;
        }
      }
      label360:
      AppMethodBeat.o(235108);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/view/refreshLayout/widget/RefreshAnimationHelper$animSpinner$1$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends AnimatorListenerAdapter
  {
    c(b paramb) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      Object localObject = null;
      AppMethodBeat.i(235100);
      if ((paramAnimator != null) && (paramAnimator.getDuration() == 0L)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(235100);
        return;
      }
      this.agRq.agRm = null;
      paramAnimator = b.a(this.agRq);
      if (paramAnimator == null)
      {
        s.bIx("cValues");
        paramAnimator = localObject;
      }
      while ((paramAnimator.agPU == 0) && (b.b(this.agRq).agRi != com.tencent.mm.view.refreshLayout.e.b.agQO) && (!b.b(this.agRq).agRi.LWA) && (!b.b(this.agRq).agRi.mlX))
      {
        b.b(this.agRq).a(com.tencent.mm.view.refreshLayout.e.b.agQO);
        AppMethodBeat.o(235100);
        return;
      }
      if (b.b(this.agRq).agRi != b.b(this.agRq).agRj) {
        b.b(this.agRq).d(b.b(this.agRq).agRi);
      }
      AppMethodBeat.o(235100);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.view.refreshLayout.g.b
 * JD-Core Version:    0.7.0.1
 */