package com.tencent.mm.plugin.sns.ui.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.thumbplayer.c.i;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.d.b.a.j;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.ak;
import kotlinx.coroutines.al;
import kotlinx.coroutines.aw;
import kotlinx.coroutines.by;
import kotlinx.coroutines.g;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/sns/ui/video/VideoResourceDownloaderDelegate;", "", "downloader", "Lcom/tencent/mm/plugin/thumbplayer/downloader/VideoResourceDownloader;", "callback", "Lcom/tencent/mm/plugin/sns/ui/video/VideoResourceDownloaderDelegate$Callback;", "(Lcom/tencent/mm/plugin/thumbplayer/downloader/VideoResourceDownloader;Lcom/tencent/mm/plugin/sns/ui/video/VideoResourceDownloaderDelegate$Callback;)V", "progressMonitorJob", "Lkotlinx/coroutines/Job;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "release", "", "startProgressMonitor", "stopProgressMonitor", "waitForComplete", "waitForMoovReady", "Callback", "Companion", "plugin-sns_release"})
public final class f
{
  public static final f.b LrY;
  private final i KHu;
  private by LrW;
  private final a LrX;
  public final ak rcY;
  
  static
  {
    AppMethodBeat.i(268298);
    LrY = new f.b((byte)0);
    AppMethodBeat.o(268298);
  }
  
  public f(i parami, a parama)
  {
    AppMethodBeat.i(268297);
    this.KHu = parami;
    this.LrX = parama;
    this.rcY = al.iRe();
    AppMethodBeat.o(268297);
  }
  
  public final void fZj()
  {
    AppMethodBeat.i(268292);
    Log.i("MicroMsg.VideoResourceDownloaderDelegate", "waitForMoovReady");
    g.b(this.rcY, null, (m)new e(this, null), 3);
    AppMethodBeat.o(268292);
  }
  
  public final void fZk()
  {
    AppMethodBeat.i(268294);
    Log.i("MicroMsg.VideoResourceDownloaderDelegate", "waitForComplete");
    g.b(this.rcY, null, (m)new d(this, null), 3);
    AppMethodBeat.o(268294);
  }
  
  public final void fZl()
  {
    AppMethodBeat.i(268295);
    Log.i("MicroMsg.VideoResourceDownloaderDelegate", "startProgressMonitor");
    by localby = this.LrW;
    if (localby != null) {
      localby.a(null);
    }
    this.LrW = g.b(this.rcY, null, (m)new c(this, null), 3);
    AppMethodBeat.o(268295);
  }
  
  public final void fZm()
  {
    AppMethodBeat.i(268296);
    Log.i("MicroMsg.VideoResourceDownloaderDelegate", "stopProgressMonitor");
    by localby = this.LrW;
    if (localby != null) {
      localby.a(null);
    }
    this.LrW = null;
    AppMethodBeat.o(268296);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/sns/ui/video/VideoResourceDownloaderDelegate$Callback;", "", "onCompleted", "", "onError", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onMoovReady", "onProgress", "percent", "", "plugin-sns_release"})
  public static abstract interface a
  {
    public abstract void cf(float paramFloat);
    
    public abstract void fUA();
    
    public abstract void fUB();
    
    public abstract void onError(Exception paramException);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class c
    extends j
    implements m<ak, d<? super x>, Object>
  {
    Object L$0;
    int label;
    private ak p$;
    
    c(f paramf, d paramd)
    {
      super(paramd);
    }
    
    public final d<x> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(268094);
      p.k(paramd, "completion");
      paramd = new c(this.LrZ, paramd);
      paramd.p$ = ((ak)paramObject);
      AppMethodBeat.o(268094);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(268095);
      paramObject1 = ((c)create(paramObject1, (d)paramObject2)).invokeSuspend(x.aazN);
      AppMethodBeat.o(268095);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(268093);
      a locala = a.aaAA;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(268093);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.p$;
      }
      while (al.a(paramObject))
      {
        f.b(this.LrZ).cf(f.a(this.LrZ).gnT());
        this.L$0 = paramObject;
        this.label = 1;
        if (aw.a(500L, this) == locala)
        {
          AppMethodBeat.o(268093);
          return locala;
          ak localak = (ak)this.L$0;
          ResultKt.throwOnFailure(paramObject);
          paramObject = localak;
        }
      }
      paramObject = x.aazN;
      AppMethodBeat.o(268093);
      return paramObject;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class d
    extends j
    implements m<ak, d<? super x>, Object>
  {
    Object L$0;
    int label;
    private ak p$;
    
    d(f paramf, d paramd)
    {
      super(paramd);
    }
    
    public final d<x> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(267344);
      p.k(paramd, "completion");
      paramd = new d(this.LrZ, paramd);
      paramd.p$ = ((ak)paramObject);
      AppMethodBeat.o(267344);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(267345);
      paramObject1 = ((d)create(paramObject1, (d)paramObject2)).invokeSuspend(x.aazN);
      AppMethodBeat.o(267345);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(267343);
      a locala = a.aaAA;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(267343);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.p$;
      }
      try
      {
        i locali = f.a(this.LrZ);
        this.L$0 = paramObject;
        this.label = 1;
        paramObject = locali.g(this);
        if (paramObject == locala)
        {
          AppMethodBeat.o(267343);
          return locala;
          ResultKt.throwOnFailure(paramObject);
        }
        Log.i("MicroMsg.VideoResourceDownloaderDelegate", "video is downloaded completely");
        f.b(this.LrZ).fUB();
        paramObject = x.aazN;
        AppMethodBeat.o(267343);
        return paramObject;
      }
      catch (CancellationException paramObject)
      {
        Log.w("MicroMsg.VideoResourceDownloaderDelegate", "waitForComplete job is canceled");
        paramObject = x.aazN;
        AppMethodBeat.o(267343);
        return paramObject;
      }
      catch (Exception paramObject)
      {
        Log.printErrStackTrace("MicroMsg.VideoResourceDownloaderDelegate", (Throwable)paramObject, "waitForComplete", new Object[0]);
        f.b(this.LrZ).onError(paramObject);
        paramObject = x.aazN;
        AppMethodBeat.o(267343);
      }
      return paramObject;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class e
    extends j
    implements m<ak, d<? super x>, Object>
  {
    Object L$0;
    int label;
    private ak p$;
    
    e(f paramf, d paramd)
    {
      super(paramd);
    }
    
    public final d<x> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(194395);
      p.k(paramd, "completion");
      paramd = new e(this.LrZ, paramd);
      paramd.p$ = ((ak)paramObject);
      AppMethodBeat.o(194395);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(194398);
      paramObject1 = ((e)create(paramObject1, (d)paramObject2)).invokeSuspend(x.aazN);
      AppMethodBeat.o(194398);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(194394);
      a locala = a.aaAA;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(194394);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.p$;
      }
      try
      {
        i locali = f.a(this.LrZ);
        this.L$0 = paramObject;
        this.label = 1;
        paramObject = locali.f(this);
        if (paramObject == locala)
        {
          AppMethodBeat.o(194394);
          return locala;
          ResultKt.throwOnFailure(paramObject);
        }
        Log.i("MicroMsg.VideoResourceDownloaderDelegate", "onMoovReady");
        f.b(this.LrZ).fUA();
        paramObject = x.aazN;
        AppMethodBeat.o(194394);
        return paramObject;
      }
      catch (CancellationException paramObject)
      {
        Log.w("MicroMsg.VideoResourceDownloaderDelegate", "waitForMoovReady job is canceled");
        paramObject = x.aazN;
        AppMethodBeat.o(194394);
        return paramObject;
      }
      catch (Exception paramObject)
      {
        Log.printErrStackTrace("MicroMsg.VideoResourceDownloaderDelegate", (Throwable)paramObject, "waitForMoovReady", new Object[0]);
        f.b(this.LrZ).onError(paramObject);
        paramObject = x.aazN;
        AppMethodBeat.o(194394);
      }
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.video.f
 * JD-Core Version:    0.7.0.1
 */