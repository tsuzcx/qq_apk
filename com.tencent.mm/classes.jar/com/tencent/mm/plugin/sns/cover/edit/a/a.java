package com.tencent.mm.plugin.sns.cover.edit.a;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar;
import com.tencent.mm.plugin.mmsight.segment.c.b;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.cropvideo.EditVideoSeekBarView;
import com.tencent.mm.plugin.sight.base.f;
import com.tencent.mm.plugin.sns.b.f;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/cover/edit/plugin/SnsCoverCropVideoPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/AutoRegisterPlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/mmsight/segment/ISegmentSeekBar$OnSeekBarChangedListener;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "coverGuideView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getCoverGuideView", "()Landroid/view/View;", "coverGuideView$delegate", "Lkotlin/Lazy;", "cropThumbView", "Lcom/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditVideoSeekBarView;", "getCropThumbView", "()Lcom/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditVideoSeekBarView;", "cropThumbView$delegate", "info", "Lcom/tencent/mm/plugin/sight/base/MediaInfo;", "normalLayout", "getNormalLayout", "normalLayout$delegate", "initLogic", "", "initThumbBarView", "onBackPress", "", "onClick", "v", "onDown", "left", "start", "", "end", "onMove", "onRecyclerChanged", "onUp", "showCropLayout", "showNormalLayout", "syncCropVideoLength", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.plugin.recordvideo.plugin.a
  implements View.OnClickListener, c.b
{
  private final j Qlf;
  private final j Qlg;
  private final j Qlh;
  private com.tencent.mm.plugin.sight.base.b Qli;
  private RecordConfigProvider oaV;
  
  public a(com.tencent.mm.plugin.recordvideo.plugin.parent.a parama)
  {
    super(parama);
    AppMethodBeat.i(307378);
    this.Qlf = k.cm((kotlin.g.a.a)new a.c(parama));
    this.Qlg = k.cm((kotlin.g.a.a)new a.b(parama));
    this.Qlh = k.cm((kotlin.g.a.a)new a.a(parama));
    AppMethodBeat.o(307378);
  }
  
  private static final void a(a parama, View paramView)
  {
    AppMethodBeat.i(307416);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/cover/edit/plugin/SnsCoverCropVideoPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "this$0");
    paramView = parama.Qli;
    int i;
    if (paramView == null)
    {
      i = 0;
      localObject = parama.oaV;
      paramView = (View)localObject;
      if (localObject == null)
      {
        s.bIx("configProvider");
        paramView = null;
      }
      if (i <= paramView.NHZ) {
        break label136;
      }
      com.tencent.mm.plugin.recordvideo.plugin.parent.a.b.a(parama.GrC, com.tencent.mm.plugin.recordvideo.plugin.parent.a.c.NQu);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/sns/cover/edit/plugin/SnsCoverCropVideoPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(307416);
      return;
      i = paramView.videoDuration;
      break;
      label136:
      parama.hey().Leu.reset();
      parama.heA();
      com.tencent.mm.plugin.recordvideo.plugin.parent.a.b.a(parama.GrC, com.tencent.mm.plugin.recordvideo.plugin.parent.a.c.NON);
    }
  }
  
  private void aT(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(307409);
    Object localObject = this.Qli;
    if (localObject != null)
    {
      int i = kotlin.h.a.eH(((com.tencent.mm.plugin.sight.base.b)localObject).videoDuration * paramFloat1);
      int j = kotlin.h.a.eH(((com.tencent.mm.plugin.sight.base.b)localObject).videoDuration * paramFloat2);
      localObject = new Bundle();
      ((Bundle)localObject).putInt("EDIT_CROP_VIDEO_LENGTH_START_TIME_INT", i);
      ((Bundle)localObject).putInt("EDIT_CROP_VIDEO_LENGTH_END_TIME_INT", j);
      this.GrC.a(com.tencent.mm.plugin.recordvideo.plugin.parent.a.c.NOJ, (Bundle)localObject);
    }
    AppMethodBeat.o(307409);
  }
  
  private static final void b(a parama, View paramView)
  {
    AppMethodBeat.i(307421);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/cover/edit/plugin/SnsCoverCropVideoPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "this$0");
    parama.heA();
    com.tencent.mm.plugin.recordvideo.plugin.parent.a.b.a(parama.GrC, com.tencent.mm.plugin.recordvideo.plugin.parent.a.c.NOO);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/sns/cover/edit/plugin/SnsCoverCropVideoPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(307421);
  }
  
  private final void heA()
  {
    AppMethodBeat.i(307401);
    hey().animate().alpha(0.0F).setDuration(300L).setListener((Animator.AnimatorListener)new d(this));
    AppMethodBeat.o(307401);
  }
  
  private final View hex()
  {
    AppMethodBeat.i(307384);
    View localView = (View)this.Qlf.getValue();
    AppMethodBeat.o(307384);
    return localView;
  }
  
  private final EditVideoSeekBarView hey()
  {
    AppMethodBeat.i(307390);
    EditVideoSeekBarView localEditVideoSeekBarView = (EditVideoSeekBarView)this.Qlg.getValue();
    AppMethodBeat.o(307390);
    return localEditVideoSeekBarView;
  }
  
  private final View hez()
  {
    AppMethodBeat.i(307396);
    View localView = (View)this.Qlh.getValue();
    AppMethodBeat.o(307396);
    return localView;
  }
  
  public final void a(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(307468);
    s.u(paramRecordConfigProvider, "configProvider");
    super.a(paramRecordConfigProvider);
    ((ViewGroup)this.GrC).findViewById(b.f.sns_cover_crop).setOnClickListener((View.OnClickListener)this);
    this.oaV = paramRecordConfigProvider;
    this.Qli = f.aVX(paramRecordConfigProvider.NId);
    AppMethodBeat.o(307468);
  }
  
  public final void aE(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(307481);
    aT(paramFloat1, paramFloat2);
    AppMethodBeat.o(307481);
  }
  
  public final void aF(float paramFloat1, float paramFloat2) {}
  
  public final void b(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(307485);
    com.tencent.mm.plugin.recordvideo.plugin.parent.a.b.a(this.GrC, com.tencent.mm.plugin.recordvideo.plugin.parent.a.c.NOL);
    AppMethodBeat.o(307485);
  }
  
  public final void c(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(307487);
    aT(paramFloat1, paramFloat2);
    com.tencent.mm.plugin.recordvideo.plugin.parent.a.b.a(this.GrC, com.tencent.mm.plugin.recordvideo.plugin.parent.a.c.NOM);
    AppMethodBeat.o(307487);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(307496);
    if (hex().getVisibility() != 0)
    {
      heA();
      com.tencent.mm.plugin.recordvideo.plugin.parent.a.b.a(this.GrC, com.tencent.mm.plugin.recordvideo.plugin.parent.a.c.NON);
      AppMethodBeat.o(307496);
      return true;
    }
    boolean bool = super.onBackPress();
    AppMethodBeat.o(307496);
    return bool;
  }
  
  public final void onClick(View paramView)
  {
    Object localObject1 = null;
    AppMethodBeat.i(307474);
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/cover/edit/plugin/SnsCoverCropVideoPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    int i;
    if (paramView == null)
    {
      paramView = null;
      i = b.f.sns_cover_crop;
      if (paramView != null) {
        break label84;
      }
    }
    label84:
    while (paramView.intValue() != i)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/cover/edit/plugin/SnsCoverCropVideoPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(307474);
      return;
      paramView = Integer.valueOf(paramView.getId());
      break;
    }
    hex().setVisibility(4);
    hez().setVisibility(4);
    hey().setVisibility(0);
    hey().setAlpha(0.0F);
    hey().clearAnimation();
    hey().animate().alpha(1.0F).setDuration(100L).setListener(null);
    EditVideoSeekBarView localEditVideoSeekBarView;
    String str;
    if ((this.Qli != null) && (!hey().getHasInit()))
    {
      localEditVideoSeekBarView = hey();
      localObject2 = this.oaV;
      paramView = (View)localObject2;
      if (localObject2 == null)
      {
        s.bIx("configProvider");
        paramView = null;
      }
      str = paramView.NId;
      s.s(str, "configProvider.inputVideoPath");
      localObject2 = this.oaV;
      paramView = (View)localObject2;
      if (localObject2 == null)
      {
        s.bIx("configProvider");
        paramView = null;
      }
      i = paramView.NHZ;
      paramView = this.Qli;
      s.checkNotNull(paramView);
      i = Math.min(i, paramView.videoDuration);
      paramView = this.oaV;
      if (paramView != null) {
        break label348;
      }
      s.bIx("configProvider");
      paramView = localObject1;
    }
    label348:
    for (;;)
    {
      localEditVideoSeekBarView.aJ(str, i, (int)Math.ceil(paramView.NIa * 1.0D / 1000.0D));
      hey().setThumbBarSeekListener((c.b)this);
      hey().setCancelButtonClickListener(new a..ExternalSyntheticLambda1(this));
      hey().setFinishButtonClickListener(new a..ExternalSyntheticLambda0(this));
      com.tencent.mm.plugin.recordvideo.plugin.parent.a.b.a(this.GrC, com.tencent.mm.plugin.recordvideo.plugin.parent.a.c.NOH);
      break;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/sns/cover/edit/plugin/SnsCoverCropVideoPlugin$showNormalLayout$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends AnimatorListenerAdapter
  {
    d(a parama) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(307360);
      s.u(paramAnimator, "animation");
      a.a(this.Qlj).setVisibility(4);
      a.a(this.Qlj).setAlpha(1.0F);
      a.b(this.Qlj).setVisibility(0);
      a.c(this.Qlj).setVisibility(0);
      AppMethodBeat.o(307360);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.cover.edit.a.a
 * JD-Core Version:    0.7.0.1
 */