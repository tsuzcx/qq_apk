package com.tencent.mm.plugin.story.ui.view.gallery;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.story.a.a;
import com.tencent.mm.plugin.story.a.d;
import com.tencent.mm.plugin.story.a.e;
import com.tencent.mm.plugin.story.a.f;
import com.tencent.mm.plugin.story.a.g;
import com.tencent.mm.plugin.story.c.a.e;
import com.tencent.mm.plugin.story.model.d;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.bb;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryHolderView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "attrs", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "initMargin", "getInitMargin", "()I", "setInitMargin", "(I)V", "lastScrollAlpha", "", "mActionIv", "Landroid/widget/ImageView;", "mActionView", "Landroid/widget/LinearLayout;", "mBubbleIv", "mIsFirstPullDown", "", "mTitleTv", "Landroid/widget/TextView;", "smallHead", "animClosing", "", "animOpening", "checkSmallHead", "closed", "goStoryCaptureUI", "onClosing", "offset", "onListInnerScroll", "onOpening", "opened", "setVisibility", "visibility", "Companion", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class GalleryHolderView
  extends RelativeLayout
{
  public static final GalleryHolderView.a SAo;
  static final String TAG;
  LinearLayout SAp;
  private ImageView SAq;
  private ImageView SAr;
  private boolean SAs;
  int SAt;
  float SAu;
  TextView sUt;
  
  static
  {
    AppMethodBeat.i(120342);
    SAo = new GalleryHolderView.a((byte)0);
    TAG = "MicroMsg.GalleryHolderView";
    AppMethodBeat.o(120342);
  }
  
  public GalleryHolderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(120341);
    AppMethodBeat.o(120341);
  }
  
  public GalleryHolderView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(120340);
    View.inflate(paramContext, a.e.SgJ, (ViewGroup)this);
    paramAttributeSet = findViewById(a.d.Sfp);
    s.s(paramAttributeSet, "findViewById(R.id.story_…ery_holder_action_layout)");
    this.SAp = ((LinearLayout)paramAttributeSet);
    paramAttributeSet = findViewById(a.d.Sfo);
    s.s(paramAttributeSet, "findViewById(R.id.story_gallery_holder_action_iv)");
    this.SAq = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(a.d.Sfq);
    s.s(paramAttributeSet, "findViewById(R.id.story_gallery_holder_bubble)");
    this.SAr = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(a.d.Sfs);
    s.s(paramAttributeSet, "findViewById(R.id.story_gallery_holder_title_tv)");
    this.sUt = ((TextView)paramAttributeSet);
    this.SAp.setVisibility(4);
    this.SAq.setImageDrawable(bb.e(paramContext.getResources().getDrawable(a.f.icons_filled_camera), paramContext.getResources().getColor(a.a.ScU)));
    this.SAp.setOnClickListener(new GalleryHolderView..ExternalSyntheticLambda0(this));
    setBackgroundColor(paramContext.getResources().getColor(a.a.ScQ));
    paramContext = com.tencent.mm.kernel.h.baE().ban().get(at.a.acYJ, Boolean.TRUE);
    if (paramContext == null)
    {
      paramContext = new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
      AppMethodBeat.o(120340);
      throw paramContext;
    }
    this.SAs = ((Boolean)paramContext).booleanValue();
    if (this.SAs)
    {
      this.sUt.setTextColor(getResources().getColor(a.a.ScN));
      paramContext = this.sUt;
      paramAttributeSet = StoryGalleryView.SBI;
      paramAttributeSet = getResources().getString(a.g.ShR);
      s.s(paramAttributeSet, "resources.getString(R.st…ory_gallery_holder_title)");
      paramContext.setText((CharSequence)StoryGalleryView.a.h((CharSequence)paramAttributeSet, getResources().getColor(a.a.ScN)));
      if (!e.Sjb.huS()) {
        break label377;
      }
      this.SAr.setVisibility(8);
    }
    for (;;)
    {
      this.SAu = 1.0F;
      AppMethodBeat.o(120340);
      return;
      this.sUt.setTextColor(getResources().getColor(a.a.ScR));
      this.sUt.setText((CharSequence)getResources().getString(a.g.ShQ));
      break;
      label377:
      this.SAr.setVisibility(0);
    }
  }
  
  private static final void a(GalleryHolderView paramGalleryHolderView, View paramView)
  {
    AppMethodBeat.i(367665);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramGalleryHolderView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/view/gallery/GalleryHolderView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramGalleryHolderView, "this$0");
    paramView = com.tencent.mm.kernel.h.baE().ban().get(at.a.adfH, Boolean.TRUE);
    if (paramView == null)
    {
      paramGalleryHolderView = new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
      AppMethodBeat.o(367665);
      throw paramGalleryHolderView;
    }
    if (((Boolean)paramView).booleanValue()) {
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adfH, Boolean.FALSE);
    }
    paramView = d.Sjy;
    if (!d.canPostStory())
    {
      paramView = com.tencent.mm.kernel.h.baE().ban().get(at.a.acYs, Integer.valueOf(0));
      if (paramView == null)
      {
        paramGalleryHolderView = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(367665);
        throw paramGalleryHolderView;
      }
      int i = ((Integer)paramView).intValue();
      k.c(paramGalleryHolderView.getContext(), "", paramGalleryHolderView.getContext().getResources().getString(a.g.story_one_day_post_tip, new Object[] { Integer.valueOf(i) }), true);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/story/ui/view/gallery/GalleryHolderView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(367665);
      return;
      paramView = com.tencent.mm.plugin.story.model.e.a.SmE;
      paramGalleryHolderView = paramGalleryHolderView.getContext();
      localObject = com.tencent.mm.plugin.story.g.h.SqZ;
      paramView.startStoryCapture(paramGalleryHolderView, 1, com.tencent.mm.plugin.story.g.h.hyo());
    }
  }
  
  public final int getInitMargin()
  {
    return this.SAt;
  }
  
  public final void hAd()
  {
    AppMethodBeat.i(120337);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { (Animator)ObjectAnimator.ofFloat(this.sUt, "alpha", new float[] { this.sUt.getAlpha(), 0.0F }), (Animator)ObjectAnimator.ofFloat(this.SAp, "alpha", new float[] { this.SAp.getAlpha(), 1.0F }) });
    localAnimatorSet.setDuration(100L);
    localAnimatorSet.start();
    AppMethodBeat.o(120337);
  }
  
  public final void hAe()
  {
    AppMethodBeat.i(120338);
    this.SAp.setVisibility(0);
    this.sUt.setVisibility(4);
    if (this.SAs)
    {
      this.SAs = false;
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acYJ, Boolean.FALSE);
    }
    this.sUt.setTextColor(getResources().getColor(a.a.ScR));
    this.sUt.setText((CharSequence)getResources().getString(a.g.ShQ));
    AppMethodBeat.o(120338);
  }
  
  public final void setInitMargin(int paramInt)
  {
    this.SAt = paramInt;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(120339);
    super.setVisibility(paramInt);
    if (paramInt == 0)
    {
      if (e.Sjb.huS())
      {
        this.SAr.setVisibility(8);
        AppMethodBeat.o(120339);
        return;
      }
      this.SAr.setVisibility(0);
    }
    AppMethodBeat.o(120339);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.GalleryHolderView
 * JD-Core Version:    0.7.0.1
 */