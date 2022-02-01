package com.tencent.mm.plugin.sns.ui.widget;

import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.b.ab;
import kotlinx.coroutines.dc;
import kotlinx.coroutines.p;
import kotlinx.coroutines.q;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/ui/widget/SnsAdTimelineVideoViewKtProxy;", "Lcom/tencent/mm/plugin/sns/ui/item/fullcard/business/breakFrameCard/IVideoControllerForBreakFrame;", "videoView", "Lcom/tencent/mm/plugin/sns/ui/widget/SnsAdTimelineVideoView;", "(Lcom/tencent/mm/plugin/sns/ui/widget/SnsAdTimelineVideoView;)V", "completionFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "", "getCompletionFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "completionFlow$delegate", "Lkotlin/Lazy;", "getVideoView", "()Lcom/tencent/mm/plugin/sns/ui/widget/SnsAdTimelineVideoView;", "getCurrentPosInMills", "", "pause", "", "prepare", "videoPath", "", "layoutParams", "Landroid/widget/FrameLayout$LayoutParams;", "(Ljava/lang/String;Landroid/widget/FrameLayout$LayoutParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resume", "seek", "to", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "seekToAsync", "start", "stop", "Companion", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  implements com.tencent.mm.plugin.sns.ui.item.a.a.a.d
{
  public static final c.a RWL;
  final SnsAdTimelineVideoView RWM;
  private final j RWN;
  
  static
  {
    AppMethodBeat.i(309206);
    RWL = new c.a((byte)0);
    AppMethodBeat.o(309206);
  }
  
  public c(SnsAdTimelineVideoView paramSnsAdTimelineVideoView)
  {
    AppMethodBeat.i(309193);
    this.RWM = paramSnsAdTimelineVideoView;
    this.RWN = kotlin.k.cm((kotlin.g.a.a)c.b.RWO);
    AppMethodBeat.o(309193);
  }
  
  public final Object a(final String paramString, FrameLayout.LayoutParams paramLayoutParams, kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(309216);
    if (this.RWM.Fey)
    {
      paramString = ah.aiuX;
      AppMethodBeat.o(309216);
      return paramString;
    }
    paramString = dc.b(10000L, (m)new c(this, paramString, null), paramd);
    AppMethodBeat.o(309216);
    return paramString;
  }
  
  public final Object d(long paramLong, kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(309233);
    this.RWM.seekTo((int)paramLong);
    paramd = ah.aiuX;
    AppMethodBeat.o(309233);
    return paramd;
  }
  
  public final ab<Boolean> getCompletionFlow()
  {
    AppMethodBeat.i(309249);
    ab localab = (ab)this.RWN.getValue();
    AppMethodBeat.o(309249);
    return localab;
  }
  
  public final long getCurrentPosInMills()
  {
    AppMethodBeat.i(309239);
    long l = this.RWM.getCurrentPositionMs();
    AppMethodBeat.o(309239);
    return l;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(309224);
    this.RWM.pause();
    AppMethodBeat.o(309224);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(309229);
    this.RWM.start();
    AppMethodBeat.o(309229);
  }
  
  public final void start()
  {
    AppMethodBeat.i(309210);
    this.RWM.start();
    AppMethodBeat.o(309210);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(309244);
    this.RWM.clear();
    AppMethodBeat.o(309244);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    Object L$0;
    Object Uf;
    int label;
    
    c(c paramc, String paramString, kotlin.d.d<? super c> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(309263);
      paramObject = (kotlin.d.d)new c(this.RWP, paramString, paramd);
      AppMethodBeat.o(309263);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(309259);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(309259);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.RWP;
        String str = paramString;
        this.L$0 = paramObject;
        this.Uf = str;
        this.label = 1;
        q localq = new q(kotlin.d.a.b.au((kotlin.d.d)this), 1);
        localq.kBA();
        p localp = (p)localq;
        paramObject.RWM.setOnPrepared((androidx.core.f.a)new a(localp));
        localp.bg((kotlin.g.a.b)new b(paramObject));
        paramObject.RWM.setVideoPath(str);
        paramObject = localq.getResult();
        if (paramObject == kotlin.d.a.a.aiwj) {
          s.u((kotlin.d.d)this, "frame");
        }
        if (paramObject == locala)
        {
          AppMethodBeat.o(309259);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(309259);
      return paramObject;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Ljava/lang/Void;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a<T>
      implements androidx.core.f.a
    {
      a(p<? super ah> paramp) {}
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends u
      implements kotlin.g.a.b<Throwable, ah>
    {
      b(c paramc)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.c
 * JD-Core Version:    0.7.0.1
 */