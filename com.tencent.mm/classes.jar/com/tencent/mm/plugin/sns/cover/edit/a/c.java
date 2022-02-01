package com.tencent.mm.plugin.sns.cover.edit.a;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.graphics.SurfaceTexture;
import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.sight.base.f;
import com.tencent.mm.plugin.thumbplayer.view.MMTPEffectVideoLayout;
import com.tencent.mm.vfs.y;
import com.tencent.mm.videocomposition.effect.EffectRenderView;
import com.tencent.mm.xeffect.effect.EffectManager;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.q;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/cover/edit/plugin/SnsCoverEffectPreviewPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/AutoRegisterPlugin;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "getContext", "()Landroid/content/Context;", "context$delegate", "Lkotlin/Lazy;", "effectView", "Lcom/tencent/mm/plugin/thumbplayer/view/MMTPEffectVideoLayout;", "getEffectView", "()Lcom/tencent/mm/plugin/thumbplayer/view/MMTPEffectVideoLayout;", "effectView$delegate", "getLocalTPMediaInfo", "Lcom/tencent/mm/plugin/thumbplayer/api/TPMediaInfo;", "path", "", "initLogic", "", "onPause", "onResume", "prepareAndPlayVideo", "filePath", "release", "seek", "timeMs", "", "setPlayRange", "start", "end", "showCropScaleAnimation", "showNormalAnimation", "Companion", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends com.tencent.mm.plugin.recordvideo.plugin.a
{
  public static final c.a Qlu;
  private final j ATU;
  private final j Qlv;
  private RecordConfigProvider oaV;
  
  static
  {
    AppMethodBeat.i(307403);
    Qlu = new c.a((byte)0);
    AppMethodBeat.o(307403);
  }
  
  public c(com.tencent.mm.plugin.recordvideo.plugin.parent.a parama)
  {
    super(parama);
    AppMethodBeat.i(307380);
    this.Qlv = k.cm((kotlin.g.a.a)new c(this));
    this.ATU = k.cm((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(307380);
  }
  
  public final void a(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(307423);
    s.u(paramRecordConfigProvider, "configProvider");
    super.a(paramRecordConfigProvider);
    this.oaV = paramRecordConfigProvider;
    Object localObject2;
    Object localObject1;
    if (y.ZC(paramRecordConfigProvider.NId))
    {
      paramRecordConfigProvider = paramRecordConfigProvider.NId;
      s.s(paramRecordConfigProvider, "mediaPath");
      s.X("prepareAndPlayVideo path:", paramRecordConfigProvider);
      h.jXD();
      heD().fva();
      localObject2 = f.aVX(paramRecordConfigProvider);
      if (localObject2 != null) {
        break label273;
      }
      if (paramRecordConfigProvider != null) {
        break label268;
      }
      localObject1 = "";
      label77:
      localObject1 = new com.tencent.mm.plugin.thumbplayer.a.b("", "", (String)localObject1, 0, 0);
      heD().setMediaInfo((com.tencent.mm.plugin.thumbplayer.a.b)localObject1);
      localObject2 = heD().getPlayer();
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.thumbplayer.e.b)localObject2).Flr = true;
      }
      localObject2 = heD().getPlayer();
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.thumbplayer.e.b)localObject2).setLoop(true);
      }
      localObject2 = heD().getPlayer();
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.thumbplayer.e.b)localObject2).hLh();
      }
      heD().getEffectRenderReport().scene = 1;
      if ((((com.tencent.mm.plugin.thumbplayer.a.b)localObject1).width > 0) || (((com.tencent.mm.plugin.thumbplayer.a.b)localObject1).height > 0)) {
        if ((((com.tencent.mm.plugin.thumbplayer.a.b)localObject1).hYK != 90) && (((com.tencent.mm.plugin.thumbplayer.a.b)localObject1).hYK != 270)) {
          break label325;
        }
      }
    }
    label268:
    label273:
    label325:
    for (float f = ((com.tencent.mm.plugin.thumbplayer.a.b)localObject1).width * 1.0F / ((com.tencent.mm.plugin.thumbplayer.a.b)localObject1).height;; f = ((com.tencent.mm.plugin.thumbplayer.a.b)localObject1).height * 1.0F / ((com.tencent.mm.plugin.thumbplayer.a.b)localObject1).width)
    {
      if (f < 1.777778F) {
        heD().getEffectManager().jQk();
      }
      heD().setOnFirstFrameAvailable((q)new d(paramRecordConfigProvider, this));
      AppMethodBeat.o(307423);
      return;
      paramRecordConfigProvider = paramRecordConfigProvider.NIf;
      break;
      localObject1 = paramRecordConfigProvider;
      break label77;
      if (paramRecordConfigProvider == null) {}
      for (localObject1 = "";; localObject1 = paramRecordConfigProvider)
      {
        localObject1 = new com.tencent.mm.plugin.thumbplayer.a.b("", (String)localObject1, "", ((com.tencent.mm.plugin.sight.base.b)localObject2).width, ((com.tencent.mm.plugin.sight.base.b)localObject2).height);
        ((com.tencent.mm.plugin.thumbplayer.a.b)localObject1).hJv = true;
        ((com.tencent.mm.plugin.thumbplayer.a.b)localObject1).hYK = ((com.tencent.mm.plugin.sight.base.b)localObject2).hYK;
        break;
      }
    }
  }
  
  public final Context getContext()
  {
    AppMethodBeat.i(307412);
    Context localContext = (Context)this.ATU.getValue();
    AppMethodBeat.o(307412);
    return localContext;
  }
  
  public final MMTPEffectVideoLayout heD()
  {
    AppMethodBeat.i(307407);
    MMTPEffectVideoLayout localMMTPEffectVideoLayout = (MMTPEffectVideoLayout)this.Qlv.getValue();
    AppMethodBeat.o(307407);
    return localMMTPEffectVideoLayout;
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(307431);
    super.onPause();
    com.tencent.mm.plugin.thumbplayer.e.b localb = heD().getPlayer();
    if (localb != null) {
      com.tencent.mm.plugin.thumbplayer.e.b.b(localb);
    }
    AppMethodBeat.o(307431);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(307436);
    super.onResume();
    com.tencent.mm.plugin.thumbplayer.e.b localb = heD().getPlayer();
    if (localb != null) {
      localb.hLh();
    }
    AppMethodBeat.o(307436);
  }
  
  public final void release()
  {
    AppMethodBeat.i(307445);
    super.release();
    com.tencent.mm.plugin.thumbplayer.e.b localb = heD().getPlayer();
    if (localb != null) {
      localb.stopAsync();
    }
    localb = heD().getPlayer();
    if (localb != null) {
      localb.recycle();
    }
    heD().TGP.HkF.release();
    AppMethodBeat.o(307445);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/content/Context;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<Context>
  {
    b(c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/thumbplayer/view/MMTPEffectVideoLayout;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<MMTPEffectVideoLayout>
  {
    c(c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/graphics/SurfaceTexture;", "<anonymous parameter 1>", "", "<anonymous parameter 2>"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements q<SurfaceTexture, Integer, Integer, ah>
  {
    d(String paramString, c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/sns/cover/edit/plugin/SnsCoverEffectPreviewPlugin$showCropScaleAnimation$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements Animator.AnimatorListener
  {
    public e(c paramc) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(307368);
      s.u(paramAnimator, "animation");
      AppMethodBeat.o(307368);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(307364);
      s.u(paramAnimator, "animation");
      c.b(this.Qlw).requestLayout();
      AppMethodBeat.o(307364);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator)
    {
      AppMethodBeat.i(307371);
      s.u(paramAnimator, "animation");
      AppMethodBeat.o(307371);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(307357);
      s.u(paramAnimator, "animation");
      AppMethodBeat.o(307357);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.cover.edit.a.c
 * JD-Core Version:    0.7.0.1
 */