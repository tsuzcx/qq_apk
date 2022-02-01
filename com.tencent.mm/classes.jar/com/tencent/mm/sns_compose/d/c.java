package com.tencent.mm.sns_compose.d;

import android.content.Context;
import androidx.compose.runtime.az;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.thumbplayer.downloader.i;
import com.tencent.mm.plugin.thumbplayer.view.ThumbPlayerVideoView;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.pluginsdk.ui.tools.i.a;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.sdk.coroutines.LifecycleScope;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sns_compose/widget/PlayerState;", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$IVideoCallback;", "Landroidx/compose/runtime/RememberObserver;", "context", "Landroid/content/Context;", "snsId", "", "localId", "", "media", "Lcom/tencent/mm/protocal/protobuf/MediaObj;", "createTime", "scope", "Lcom/tencent/mm/sdk/coroutines/LifecycleScope;", "(Landroid/content/Context;Ljava/lang/String;ILcom/tencent/mm/protocal/protobuf/MediaObj;ILcom/tencent/mm/sdk/coroutines/LifecycleScope;)V", "getContext", "()Landroid/content/Context;", "getCreateTime", "()I", "isPlay", "", "()Z", "setPlay", "(Z)V", "getLocalId", "getMedia", "()Lcom/tencent/mm/protocal/protobuf/MediaObj;", "getScope", "()Lcom/tencent/mm/sdk/coroutines/LifecycleScope;", "getSnsId", "()Ljava/lang/String;", "videoView", "Lcom/tencent/mm/plugin/thumbplayer/view/ThumbPlayerVideoView;", "viewPath", "getViewPath", "setViewPath", "(Ljava/lang/String;)V", "getPlayer", "Landroid/view/View;", "init", "", "onAbandoned", "onCompletion", "onError", "what", "extra", "onForgotten", "onGetVideoSize", "width", "height", "onPlayTime", "playTime", "videoTime", "onPrepared", "onRemembered", "pause", "resume", "stop", "updatePlayState", "play", "Companion", "sns-compose_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  implements az, i.a
{
  public static final int Ue;
  public static final c.a acAc;
  static final List<ThumbPlayerVideoView> acAe;
  public ThumbPlayerVideoView HOn;
  String acAd;
  final LifecycleScope aczV;
  private final Context context;
  final int createTime;
  public boolean hJg;
  public final String hQX;
  final dmz ibT;
  final int icg;
  
  static
  {
    AppMethodBeat.i(235469);
    acAc = new c.a((byte)0);
    Ue = 8;
    acAe = Collections.synchronizedList((List)new LinkedList());
    AppMethodBeat.o(235469);
  }
  
  public c(Context paramContext, String paramString, int paramInt1, dmz paramdmz, int paramInt2, LifecycleScope paramLifecycleScope)
  {
    AppMethodBeat.i(235441);
    this.context = paramContext;
    this.hQX = paramString;
    this.icg = paramInt1;
    this.ibT = paramdmz;
    this.createTime = paramInt2;
    this.aczV = paramLifecycleScope;
    Log.v("MiscroMsg.PlayerState", "PlayerState  snsId:" + this.hQX + " playerRecycler:" + acAe.size());
    AppMethodBeat.o(235441);
  }
  
  public final void Qz()
  {
    AppMethodBeat.i(235513);
    Log.i("MiscroMsg.PlayerState", "onPrepared snsId:" + this.hQX + " isPlay:" + this.hJg);
    if (this.hJg)
    {
      ThumbPlayerVideoView localThumbPlayerVideoView = this.HOn;
      if (localThumbPlayerVideoView != null) {
        localThumbPlayerVideoView.start();
      }
    }
    AppMethodBeat.o(235513);
  }
  
  public final void fG(int paramInt1, int paramInt2) {}
  
  public final int gw(int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public final void mJ()
  {
    AppMethodBeat.i(235497);
    Log.i("MiscroMsg.PlayerState", s.X("onRemembered snsId:", this.hQX));
    this.acAd = com.tencent.mm.sns_compose.a.acyR.a(this.icg, this.ibT);
    AppMethodBeat.o(235497);
  }
  
  public final void mK()
  {
    AppMethodBeat.i(235486);
    LifecycleScope.launchDefault$default(this.aczV, null, (m)new c(this, null), 1, null);
    AppMethodBeat.o(235486);
  }
  
  public final void mL()
  {
    AppMethodBeat.i(235479);
    mK();
    AppMethodBeat.o(235479);
  }
  
  public final void onCompletion() {}
  
  public final void onError(int paramInt1, int paramInt2) {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    Object L$0;
    int label;
    
    b(c paramc, kotlin.d.d<? super b> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(235470);
      paramObject = (kotlin.d.d)new b(this.acAf, paramd);
      AppMethodBeat.o(235470);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(235462);
      Object localObject = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(235462);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        Log.i("MiscroMsg.PlayerState", "getPlayer snsId:" + this.acAf.hQX + " isPlay:" + this.acAf.hJg);
        if (c.a(this.acAf) == null)
        {
          paramObject = ah.aiuX;
          AppMethodBeat.o(235462);
          return paramObject;
        }
        paramObject = c.a(this.acAf);
        s.checkNotNull(paramObject);
        if (paramObject.isInitialized())
        {
          paramObject = c.a(this.acAf);
          s.checkNotNull(paramObject);
          paramObject.stop();
        }
        if (this.acAf.acAd == null) {
          this.acAf.acAd = com.tencent.mm.sns_compose.a.acyR.a(this.acAf.icg, this.acAf.ibT);
        }
        if (this.acAf.acAd != null)
        {
          paramObject = c.a(this.acAf);
          s.checkNotNull(paramObject);
          paramObject.setVideoPath(this.acAf.acAd);
          paramObject = c.a(this.acAf);
          s.checkNotNull(paramObject);
          paramObject.setVideoCallback((i.a)this.acAf);
          paramObject = c.a(this.acAf);
          s.checkNotNull(paramObject);
          paramObject.setLoop(true);
          paramObject = c.a(this.acAf);
          s.checkNotNull(paramObject);
          paramObject.setScaleType(i.e.XYN);
          paramObject = ah.aiuX;
          AppMethodBeat.o(235462);
          return paramObject;
        }
        paramObject = new com.tencent.mm.plugin.thumbplayer.downloader.d(com.tencent.mm.sns_compose.a.acyR.a(this.acAf.icg, this.acAf.ibT, this.acAf.createTime));
        paramObject.start();
        kotlin.d.d locald = (kotlin.d.d)this;
        this.L$0 = paramObject;
        this.label = 1;
        if (paramObject.ao(locald) == localObject)
        {
          AppMethodBeat.o(235462);
          return localObject;
        }
        break;
      case 1: 
        localObject = (com.tencent.mm.plugin.thumbplayer.downloader.d)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        paramObject = localObject;
      }
      for (;;)
      {
        localObject = c.a(this.acAf);
        s.checkNotNull(localObject);
        ((ThumbPlayerVideoView)localObject).setResourceDownloader((i)paramObject);
        paramObject = c.a(this.acAf);
        s.checkNotNull(paramObject);
        paramObject.prepare();
        break;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    c(c paramc, kotlin.d.d<? super c> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(235471);
      paramObject = (kotlin.d.d)new c(this.acAf, paramd);
      AppMethodBeat.o(235471);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(235463);
      Object localObject = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(235463);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      if (c.a(this.acAf) != null)
      {
        paramObject = c.a(this.acAf);
        if (paramObject != null) {
          paramObject.setVideoCallback(null);
        }
        paramObject = c.a(this.acAf);
        if (paramObject != null) {
          paramObject.stop();
        }
        paramObject = c.iVA();
        localObject = c.a(this.acAf);
        s.checkNotNull(localObject);
        paramObject.add(localObject);
        Log.i("MiscroMsg.PlayerState", "onForgotten recycler :" + c.iVA().size() + ' ');
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(235463);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sns_compose.d.c
 * JD-Core Version:    0.7.0.1
 */