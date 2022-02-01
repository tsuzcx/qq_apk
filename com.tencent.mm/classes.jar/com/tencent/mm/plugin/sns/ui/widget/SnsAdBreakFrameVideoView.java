package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.widget.alphavideo.AdAlphaPlayerView;
import com.tencent.mm.plugin.sns.ad.widget.alphavideo.AdAlphaPlayerView.11;
import com.tencent.mm.plugin.sns.ad.widget.alphavideo.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;
import com.tencent.thumbplayer.api.ITPPlayer;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnSeekCompleteListener;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.b.ab;
import kotlinx.coroutines.b.ad;
import kotlinx.coroutines.b.w;
import kotlinx.coroutines.cx;
import kotlinx.coroutines.dc;
import kotlinx.coroutines.q;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/ui/widget/SnsAdBreakFrameVideoView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mm/plugin/sns/ui/item/fullcard/business/breakFrameCard/IVideoControllerForBreakFrame;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "_completionFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "get_completionFlow", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "set_completionFlow", "(Lkotlinx/coroutines/flow/MutableSharedFlow;)V", "canClickAction", "Lkotlin/Function0;", "getCanClickAction", "()Lkotlin/jvm/functions/Function0;", "setCanClickAction", "(Lkotlin/jvm/functions/Function0;)V", "canClickArea", "Landroid/graphics/Rect;", "getCanClickArea", "()Landroid/graphics/Rect;", "setCanClickArea", "(Landroid/graphics/Rect;)V", "completionFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "getCompletionFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "detachedListener", "Landroidx/core/util/Consumer;", "Ljava/lang/Void;", "getDetachedListener", "()Landroidx/core/util/Consumer;", "setDetachedListener", "(Landroidx/core/util/Consumer;)V", "mPlayerView", "Lcom/tencent/mm/plugin/sns/ad/widget/alphavideo/AdAlphaPlayerView;", "getMPlayerView", "()Lcom/tencent/mm/plugin/sns/ad/widget/alphavideo/AdAlphaPlayerView;", "setMPlayerView", "(Lcom/tencent/mm/plugin/sns/ad/widget/alphavideo/AdAlphaPlayerView;)V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "setScope", "(Lkotlinx/coroutines/CoroutineScope;)V", "toRemoveViewList", "", "Landroid/view/View;", "getToRemoveViewList", "()Ljava/util/List;", "setToRemoveViewList", "(Ljava/util/List;)V", "addViewRemovedOnStop", "", "view", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "getCurrentPosInMills", "", "init", "onAttachedToWindow", "onDetachedFromWindow", "pause", "prepare", "videoPath", "", "layoutParams", "Landroid/widget/FrameLayout$LayoutParams;", "(Ljava/lang/String;Landroid/widget/FrameLayout$LayoutParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "restart", "resume", "seek", "to", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "seekToAsync", "setCanClickRect", "rect", "canClick", "start", "startPrepare", "onPrepared", "stop", "Companion", "DetachedListener", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class SnsAdBreakFrameVideoView
  extends FrameLayout
  implements com.tencent.mm.plugin.sns.ui.item.a.a.a.d
{
  public static final SnsAdBreakFrameVideoView.a RVG;
  AdAlphaPlayerView RVH;
  private androidx.core.f.a<Void> RVI;
  private w<Boolean> RVJ;
  public List<View> RVK;
  public kotlin.g.a.a<Boolean> RVL;
  public Rect RVM;
  aq scope;
  
  static
  {
    AppMethodBeat.i(309268);
    RVG = new SnsAdBreakFrameVideoView.a((byte)0);
    AppMethodBeat.o(309268);
  }
  
  public SnsAdBreakFrameVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(309264);
    this.RVJ = ad.a(1, 0, null, 6);
    this.RVK = ((List)new ArrayList());
    AppMethodBeat.o(309264);
  }
  
  public final Object a(final String paramString, final FrameLayout.LayoutParams paramLayoutParams, kotlin.d.d<? super ah> paramd)
  {
    int i = 1;
    AppMethodBeat.i(309321);
    AdAlphaPlayerView localAdAlphaPlayerView = getMPlayerView();
    if ((localAdAlphaPlayerView != null) && (localAdAlphaPlayerView.sIt == true)) {}
    while (i != 0)
    {
      paramString = ah.aiuX;
      AppMethodBeat.o(309321);
      return paramString;
      i = 0;
    }
    paramString = dc.b(10000L, (m)new b(this, paramString, paramLayoutParams, null), paramd);
    AppMethodBeat.o(309321);
    return paramString;
  }
  
  public final Object d(final long paramLong, kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(309331);
    paramd = dc.b(1000L, (m)new c(this, paramLong, null), paramd);
    AppMethodBeat.o(309331);
    return paramd;
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(309337);
    kotlin.g.a.a locala = this.RVL;
    Rect localRect = this.RVM;
    boolean bool;
    if ((paramMotionEvent == null) || (locala == null) || (localRect == null))
    {
      Log.d("SnsAdCoverVideoView", s.X("dispatchTouchEvent() called with: ev = ", paramMotionEvent));
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(309337);
      return bool;
    }
    if ((paramMotionEvent.getX() > localRect.left) && (paramMotionEvent.getX() < localRect.right) && (paramMotionEvent.getY() > localRect.top) && (paramMotionEvent.getY() < localRect.bottom) && (((Boolean)locala.invoke()).booleanValue()))
    {
      Log.d("SnsAdCoverVideoView", s.X("dispatchTouchEvent() called with: ev = ", paramMotionEvent));
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(309337);
      return bool;
    }
    Log.d("SnsAdCoverVideoView", "dispatchTouchEvent dont try call click");
    AppMethodBeat.o(309337);
    return false;
  }
  
  public final kotlin.g.a.a<Boolean> getCanClickAction()
  {
    return this.RVL;
  }
  
  public final Rect getCanClickArea()
  {
    return this.RVM;
  }
  
  public final ab<Boolean> getCompletionFlow()
  {
    return (ab)this.RVJ;
  }
  
  public final long getCurrentPosInMills()
  {
    AppMethodBeat.i(309334);
    Object localObject = this.RVH;
    if (localObject == null)
    {
      AppMethodBeat.o(309334);
      return -1L;
    }
    localObject = ((AdAlphaPlayerView)localObject).QeH;
    if (localObject == null)
    {
      AppMethodBeat.o(309334);
      return -1L;
    }
    long l = ((com.tencent.mm.plugin.thumbplayer.e.a)localObject).getCurrentPositionMs();
    AppMethodBeat.o(309334);
    return l;
  }
  
  public final androidx.core.f.a<Void> getDetachedListener()
  {
    return this.RVI;
  }
  
  public final AdAlphaPlayerView getMPlayerView()
  {
    return this.RVH;
  }
  
  public final aq getScope()
  {
    return this.scope;
  }
  
  public final List<View> getToRemoveViewList()
  {
    return this.RVK;
  }
  
  public final w<Boolean> get_completionFlow()
  {
    return this.RVJ;
  }
  
  protected final void onAttachedToWindow()
  {
    AppMethodBeat.i(309312);
    super.onAttachedToWindow();
    AppMethodBeat.o(309312);
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(309315);
    super.onDetachedFromWindow();
    androidx.core.f.a locala = this.RVI;
    if (locala != null) {
      locala.accept(null);
    }
    this.RVI = null;
    AppMethodBeat.o(309315);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(309323);
    AdAlphaPlayerView localAdAlphaPlayerView = this.RVH;
    if (localAdAlphaPlayerView != null)
    {
      c.i("AdAlphaPlayerView", "pauseAd");
      localAdAlphaPlayerView.qRV = false;
      if (localAdAlphaPlayerView.QeI != null) {
        localAdAlphaPlayerView.QeI.ajV(3);
      }
    }
    try
    {
      if (localAdAlphaPlayerView.QeH != null) {
        localAdAlphaPlayerView.QeH.pause();
      }
      if (localAdAlphaPlayerView.QeG != null) {
        localAdAlphaPlayerView.QeG.onPause();
      }
    }
    finally
    {
      for (;;)
      {
        c.e("AdAlphaPlayerView", "pause failed", localThrowable);
      }
    }
    Log.i("SnsAdCoverVideoView", "pause");
    AppMethodBeat.o(309323);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(309329);
    AdAlphaPlayerView localAdAlphaPlayerView = this.RVH;
    if (localAdAlphaPlayerView != null) {
      localAdAlphaPlayerView.resume();
    }
    Log.i("SnsAdCoverVideoView", "resume");
    AppMethodBeat.o(309329);
  }
  
  public final void setCanClickAction(kotlin.g.a.a<Boolean> parama)
  {
    this.RVL = parama;
  }
  
  public final void setCanClickArea(Rect paramRect)
  {
    this.RVM = paramRect;
  }
  
  public final void setDetachedListener(androidx.core.f.a<Void> parama)
  {
    this.RVI = parama;
  }
  
  public final void setMPlayerView(AdAlphaPlayerView paramAdAlphaPlayerView)
  {
    this.RVH = paramAdAlphaPlayerView;
  }
  
  public final void setScope(aq paramaq)
  {
    this.scope = paramaq;
  }
  
  public final void setToRemoveViewList(List<View> paramList)
  {
    AppMethodBeat.i(309295);
    s.u(paramList, "<set-?>");
    this.RVK = paramList;
    AppMethodBeat.o(309295);
  }
  
  public final void set_completionFlow(w<Boolean> paramw)
  {
    AppMethodBeat.i(309288);
    s.u(paramw, "<set-?>");
    this.RVJ = paramw;
    AppMethodBeat.o(309288);
  }
  
  public final void start()
  {
    AppMethodBeat.i(309327);
    AdAlphaPlayerView localAdAlphaPlayerView = this.RVH;
    if (localAdAlphaPlayerView != null) {
      localAdAlphaPlayerView.resume();
    }
    Log.i("SnsAdCoverVideoView", "start");
    AppMethodBeat.o(309327);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(309318);
    Object localObject = this.scope;
    if (localObject != null) {
      ar.a((aq)localObject, null);
    }
    this.scope = null;
    localObject = this.RVH;
    if (localObject != null) {
      ((AdAlphaPlayerView)localObject).setPrepared(false);
    }
    this.RVJ.jc(null);
    localObject = this.RVH;
    if (localObject != null) {
      ((AdAlphaPlayerView)localObject).stop();
    }
    removeView((View)this.RVH);
    kotlin.a.p.e(this.RVK, (kotlin.g.a.b)new SnsAdBreakFrameVideoView.e(this));
    this.RVH = null;
    this.RVM = null;
    this.RVL = null;
    AppMethodBeat.o(309318);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    Object L$0;
    Object Uf;
    Object VC;
    int label;
    
    b(SnsAdBreakFrameVideoView paramSnsAdBreakFrameVideoView, String paramString, FrameLayout.LayoutParams paramLayoutParams, kotlin.d.d<? super b> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(309252);
      paramObject = (kotlin.d.d)new b(this.RVN, paramString, paramLayoutParams, paramd);
      AppMethodBeat.o(309252);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(309247);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(309247);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        SnsAdBreakFrameVideoView localSnsAdBreakFrameVideoView = this.RVN;
        Object localObject2 = paramString;
        Object localObject1 = paramLayoutParams;
        this.L$0 = localSnsAdBreakFrameVideoView;
        this.Uf = localObject2;
        this.VC = localObject1;
        this.label = 1;
        q localq = new q(kotlin.d.a.b.au((kotlin.d.d)this), 1);
        localq.kBA();
        Object localObject3 = (kotlinx.coroutines.p)localq;
        ((kotlinx.coroutines.p)localObject3).bg((kotlin.g.a.b)SnsAdBreakFrameVideoView.b.a.RVP);
        paramObject = localObject2;
        if (localObject2 == null) {
          paramObject = "";
        }
        localObject2 = (androidx.core.f.a)new b((kotlinx.coroutines.p)localObject3);
        s.u(paramObject, "videoPath");
        Log.d("SnsAdCoverVideoView", s.X("startPrepare() called with: videoPath = ", paramObject));
        localObject3 = localSnsAdBreakFrameVideoView.scope;
        if (localObject3 != null) {
          ar.a((aq)localObject3, null);
        }
        localSnsAdBreakFrameVideoView.scope = ar.b(ar.kBZ(), (f)cx.g(null));
        localObject3 = localSnsAdBreakFrameVideoView.RVH;
        if (localObject3 != null) {
          ((AdAlphaPlayerView)localObject3).stop();
        }
        localSnsAdBreakFrameVideoView.removeView((View)localSnsAdBreakFrameVideoView.RVH);
        localSnsAdBreakFrameVideoView.RVH = new AdAlphaPlayerView(localSnsAdBreakFrameVideoView.getContext());
        localObject3 = localSnsAdBreakFrameVideoView.RVH;
        if (localObject3 != null) {
          ((AdAlphaPlayerView)localObject3).setOnPrepared((androidx.core.f.a)localObject2);
        }
        if (localObject1 == null) {
          localObject1 = new FrameLayout.LayoutParams(-1, -1);
        }
        for (;;)
        {
          localSnsAdBreakFrameVideoView.addView((View)localSnsAdBreakFrameVideoView.RVH, 0, (ViewGroup.LayoutParams)localObject1);
          Log.d("SnsAdCoverVideoView", s.X("startPrepare() called with: videoPath = ", paramObject));
          localObject1 = localSnsAdBreakFrameVideoView.RVH;
          if (localObject1 != null)
          {
            paramObject = y.n(paramObject, false);
            localObject2 = (com.tencent.mm.plugin.sns.ad.widget.alphavideo.a)new SnsAdBreakFrameVideoView.d(localSnsAdBreakFrameVideoView);
            ((AdAlphaPlayerView)localObject1).eDC = paramObject;
            ((AdAlphaPlayerView)localObject1).QeL = true;
            ((AdAlphaPlayerView)localObject1).QeK = false;
            ((AdAlphaPlayerView)localObject1).QeM = true;
            ((AdAlphaPlayerView)localObject1).QeI = ((com.tencent.mm.plugin.sns.ad.widget.alphavideo.a)localObject2);
            ((com.tencent.mm.plugin.sns.ad.widget.alphavideo.a)localObject2).ajV(1);
          }
          try
          {
            paramObject = localSnsAdBreakFrameVideoView.RVH;
            if (paramObject != null)
            {
              c.i("AdAlphaPlayerView", "prepare");
              if (paramObject.QeI != null) {
                paramObject.QeI.ajV(2);
              }
              localObject1 = new TextureView(paramObject.getContext());
              ((TextureView)localObject1).setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
              ((TextureView)localObject1).setOpaque(false);
              paramObject.eDa = ((TextureView)localObject1);
              Log.d("AdAlphaPlayerView", "prepare() called ".concat(String.valueOf(paramObject.eDa.getSurfaceTexture())));
              paramObject.eDa.setSurfaceTextureListener(new AdAlphaPlayerView.11(paramObject));
              paramObject.addView(paramObject.eDa, 0);
            }
          }
          finally
          {
            for (;;)
            {
              Log.e("SnsAdCoverVideoView", paramObject.toString());
            }
          }
          Log.i("SnsAdCoverVideoView", "startPrepare() init end ");
          paramObject = localq.getResult();
          if (paramObject == kotlin.d.a.a.aiwj) {
            s.u((kotlin.d.d)this, "frame");
          }
          if (paramObject != locala) {
            break label562;
          }
          AppMethodBeat.o(309247);
          return locala;
        }
      }
      ResultKt.throwOnFailure(paramObject);
      label562:
      paramObject = ah.aiuX;
      AppMethodBeat.o(309247);
      return paramObject;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Ljava/lang/Void;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
    static final class b<T>
      implements androidx.core.f.a
    {
      b(kotlinx.coroutines.p<? super ah> paramp) {}
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    Object L$0;
    long Yx;
    int label;
    
    c(SnsAdBreakFrameVideoView paramSnsAdBreakFrameVideoView, long paramLong, kotlin.d.d<? super c> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(309248);
      paramObject = (kotlin.d.d)new c(this.RVN, paramLong, paramd);
      AppMethodBeat.o(309248);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(309245);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(309245);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        Object localObject1 = this.RVN;
        long l = paramLong;
        this.L$0 = localObject1;
        this.Yx = l;
        this.label = 1;
        paramObject = new q(kotlin.d.a.b.au((kotlin.d.d)this), 1);
        paramObject.kBA();
        kotlinx.coroutines.p localp = (kotlinx.coroutines.p)paramObject;
        Object localObject3 = ((SnsAdBreakFrameVideoView)localObject1).getMPlayerView();
        if (localObject3 != null)
        {
          localObject3 = ((AdAlphaPlayerView)localObject3).QeH;
          if (localObject3 != null) {
            ((com.tencent.mm.plugin.thumbplayer.e.a)localObject3).setOnSeekCompleteListener((ITPPlayerListener.IOnSeekCompleteListener)new a(localp, (SnsAdBreakFrameVideoView)localObject1));
          }
        }
        localp.bg((kotlin.g.a.b)new b((SnsAdBreakFrameVideoView)localObject1));
        try
        {
          localObject1 = ((SnsAdBreakFrameVideoView)localObject1).getMPlayerView();
          if (localObject1 != null)
          {
            localObject1 = ((AdAlphaPlayerView)localObject1).QeH;
            if (localObject1 != null) {
              ((com.tencent.mm.plugin.thumbplayer.e.a)localObject1).seekTo((int)l, 3);
            }
          }
        }
        finally
        {
          for (;;)
          {
            Log.e("SnsAdCoverVideoView", "seek() called with: error", new Object[] { localObject2 });
          }
        }
        paramObject = paramObject.getResult();
        if (paramObject == kotlin.d.a.a.aiwj) {
          s.u((kotlin.d.d)this, "frame");
        }
        if (paramObject != locala) {
          break label268;
        }
        AppMethodBeat.o(309245);
        return locala;
      }
      ResultKt.throwOnFailure(paramObject);
      label268:
      paramObject = ah.aiuX;
      AppMethodBeat.o(309245);
      return paramObject;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/thumbplayer/api/ITPPlayer;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      implements ITPPlayerListener.IOnSeekCompleteListener
    {
      a(kotlinx.coroutines.p<? super ah> paramp, SnsAdBreakFrameVideoView paramSnsAdBreakFrameVideoView) {}
      
      public final void onSeekComplete(ITPPlayer paramITPPlayer)
      {
        AppMethodBeat.i(309246);
        paramITPPlayer = this.Isp;
        Result.Companion localCompanion = Result.Companion;
        paramITPPlayer.resumeWith(Result.constructor-impl(ah.aiuX));
        paramITPPlayer = this.RVN.getMPlayerView();
        if (paramITPPlayer != null)
        {
          paramITPPlayer = paramITPPlayer.QeH;
          if (paramITPPlayer != null) {
            paramITPPlayer.setOnSeekCompleteListener(null);
          }
        }
        AppMethodBeat.o(309246);
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends u
      implements kotlin.g.a.b<Throwable, ah>
    {
      b(SnsAdBreakFrameVideoView paramSnsAdBreakFrameVideoView)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.SnsAdBreakFrameVideoView
 * JD-Core Version:    0.7.0.1
 */