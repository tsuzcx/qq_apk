package com.tencent.mm.plugin.sns.ui.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.thumbplayer.downloader.i;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.bb;
import kotlinx.coroutines.cb;
import kotlinx.coroutines.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/ui/video/VideoResourceDownloaderDelegate;", "", "downloader", "Lcom/tencent/mm/plugin/thumbplayer/downloader/VideoResourceDownloader;", "callback", "Lcom/tencent/mm/plugin/sns/ui/video/VideoResourceDownloaderDelegate$Callback;", "(Lcom/tencent/mm/plugin/thumbplayer/downloader/VideoResourceDownloader;Lcom/tencent/mm/plugin/sns/ui/video/VideoResourceDownloaderDelegate$Callback;)V", "progressMonitorJob", "Lkotlinx/coroutines/Job;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "release", "", "startProgressMonitor", "stopProgressMonitor", "waitForComplete", "waitForMoovReady", "Callback", "Companion", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  public static final f.b RUZ;
  private final a RVa;
  private cb RVb;
  private final i RgU;
  public final aq scope;
  
  static
  {
    AppMethodBeat.i(308579);
    RUZ = new f.b((byte)0);
    AppMethodBeat.o(308579);
  }
  
  public f(i parami, a parama)
  {
    AppMethodBeat.i(308574);
    this.RgU = parami;
    this.RVa = parama;
    this.scope = ar.kBZ();
    AppMethodBeat.o(308574);
  }
  
  public final void hsA()
  {
    AppMethodBeat.i(308586);
    Log.i("MicroMsg.VideoResourceDownloaderDelegate", "stopProgressMonitor");
    cb localcb = this.RVb;
    if (localcb != null) {
      localcb.a(null);
    }
    this.RVb = null;
    AppMethodBeat.o(308586);
  }
  
  public final void hsx()
  {
    AppMethodBeat.i(308581);
    Log.i("MicroMsg.VideoResourceDownloaderDelegate", "waitForMoovReady");
    j.a(this.scope, null, null, (m)new e(this, null), 3);
    AppMethodBeat.o(308581);
  }
  
  public final void hsy()
  {
    AppMethodBeat.i(308582);
    Log.i("MicroMsg.VideoResourceDownloaderDelegate", "waitForComplete");
    j.a(this.scope, null, null, (m)new d(this, null), 3);
    AppMethodBeat.o(308582);
  }
  
  public final void hsz()
  {
    AppMethodBeat.i(308584);
    Log.i("MicroMsg.VideoResourceDownloaderDelegate", "startProgressMonitor");
    cb localcb = this.RVb;
    if (localcb != null) {
      localcb.a(null);
    }
    this.RVb = j.a(this.scope, null, null, (m)new c(this, null), 3);
    AppMethodBeat.o(308584);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/ui/video/VideoResourceDownloaderDelegate$Callback;", "", "onCompleted", "", "onError", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onMoovReady", "onProgress", "percent", "", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void f(Exception paramException);
    
    public abstract void fvq();
    
    public abstract void hmS();
    
    public abstract void onProgress(float paramFloat);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends k
    implements m<aq, d<? super ah>, Object>
  {
    int label;
    
    c(f paramf, d<? super c> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(308570);
      paramd = new c(this.RVc, paramd);
      paramd.L$0 = paramObject;
      paramObject = (d)paramd;
      AppMethodBeat.o(308570);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(308566);
      a locala = a.aiwj;
      Object localObject;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(308566);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (aq)this.L$0;
        if (ar.a(paramObject))
        {
          f.b(this.RVc).onProgress(f.a(this.RVc).hKG());
          localObject = (d)this;
          this.L$0 = paramObject;
          this.label = 1;
          if (bb.e(500L, (d)localObject) != locala) {
            break label157;
          }
          AppMethodBeat.o(308566);
          return locala;
        }
        break;
      case 1: 
        localObject = (aq)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        paramObject = localObject;
      }
      label157:
      for (;;)
      {
        break;
        paramObject = ah.aiuX;
        AppMethodBeat.o(308566);
        return paramObject;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends k
    implements m<aq, d<? super ah>, Object>
  {
    int label;
    
    d(f paramf, d<? super d> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(308568);
      paramObject = (d)new d(this.RVc, paramd);
      AppMethodBeat.o(308568);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(308565);
      a locala = a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(308565);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
      }
      try
      {
        paramObject = f.a(this.RVc);
        d locald = (d)this;
        this.label = 1;
        paramObject = paramObject.ap(locald);
        if (paramObject == locala)
        {
          AppMethodBeat.o(308565);
          return locala;
          ResultKt.throwOnFailure(paramObject);
        }
        Log.i("MicroMsg.VideoResourceDownloaderDelegate", "video is downloaded completely");
        f.b(this.RVc).fvq();
        paramObject = ah.aiuX;
        AppMethodBeat.o(308565);
        return paramObject;
      }
      catch (CancellationException paramObject)
      {
        Log.w("MicroMsg.VideoResourceDownloaderDelegate", "waitForComplete job is canceled");
        paramObject = ah.aiuX;
        AppMethodBeat.o(308565);
        return paramObject;
      }
      catch (Exception paramObject)
      {
        Log.printErrStackTrace("MicroMsg.VideoResourceDownloaderDelegate", (Throwable)paramObject, "waitForComplete", new Object[0]);
        f.b(this.RVc).f(paramObject);
        paramObject = ah.aiuX;
        AppMethodBeat.o(308565);
      }
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends k
    implements m<aq, d<? super ah>, Object>
  {
    int label;
    
    e(f paramf, d<? super e> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(308567);
      paramObject = (d)new e(this.RVc, paramd);
      AppMethodBeat.o(308567);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(308564);
      a locala = a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(308564);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
      }
      try
      {
        paramObject = f.a(this.RVc);
        d locald = (d)this;
        this.label = 1;
        paramObject = paramObject.ao(locald);
        if (paramObject == locala)
        {
          AppMethodBeat.o(308564);
          return locala;
          ResultKt.throwOnFailure(paramObject);
        }
        Log.i("MicroMsg.VideoResourceDownloaderDelegate", "onMoovReady");
        f.b(this.RVc).hmS();
        paramObject = ah.aiuX;
        AppMethodBeat.o(308564);
        return paramObject;
      }
      catch (CancellationException paramObject)
      {
        Log.w("MicroMsg.VideoResourceDownloaderDelegate", "waitForMoovReady job is canceled");
        paramObject = ah.aiuX;
        AppMethodBeat.o(308564);
        return paramObject;
      }
      catch (Exception paramObject)
      {
        Log.printErrStackTrace("MicroMsg.VideoResourceDownloaderDelegate", (Throwable)paramObject, "waitForMoovReady", new Object[0]);
        f.b(this.RVc).f(paramObject);
        paramObject = ah.aiuX;
        AppMethodBeat.o(308564);
      }
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.video.f
 * JD-Core Version:    0.7.0.1
 */