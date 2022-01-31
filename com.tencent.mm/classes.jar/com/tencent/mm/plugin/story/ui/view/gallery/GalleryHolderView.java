package com.tencent.mm.plugin.story.ui.view.gallery;

import a.f.b.j;
import a.l;
import a.v;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.aj;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryHolderView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "attrs", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "initMargin", "getInitMargin", "()I", "setInitMargin", "(I)V", "lastScrollAlpha", "", "mActionIv", "Landroid/widget/ImageView;", "mActionView", "Landroid/widget/LinearLayout;", "mBubbleIv", "mIsFirstPullDown", "", "mTitleTv", "Landroid/widget/TextView;", "smallHead", "animClosing", "", "animOpening", "checkSmallHead", "closed", "goStoryCaptureUI", "onClosing", "offset", "onListInnerScroll", "onOpening", "opened", "Companion", "plugin-story_release"})
public final class GalleryHolderView
  extends RelativeLayout
{
  static final String TAG = "MicroMsg.GalleryHolderView";
  public static final GalleryHolderView.a sRS;
  TextView iJG;
  LinearLayout sRM;
  private ImageView sRN;
  private ImageView sRO;
  private boolean sRP;
  int sRQ;
  float sRR;
  
  static
  {
    AppMethodBeat.i(110718);
    sRS = new GalleryHolderView.a((byte)0);
    TAG = "MicroMsg.GalleryHolderView";
    AppMethodBeat.o(110718);
  }
  
  public GalleryHolderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(110717);
    AppMethodBeat.o(110717);
  }
  
  public GalleryHolderView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(110716);
    View.inflate(paramContext, 2130970956, (ViewGroup)this);
    paramAttributeSet = findViewById(2131828412);
    j.p(paramAttributeSet, "findViewById(R.id.story_…ery_holder_action_layout)");
    this.sRM = ((LinearLayout)paramAttributeSet);
    paramAttributeSet = findViewById(2131828413);
    j.p(paramAttributeSet, "findViewById(R.id.story_gallery_holder_action_iv)");
    this.sRN = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131828410);
    j.p(paramAttributeSet, "findViewById(R.id.story_gallery_holder_bubble)");
    this.sRO = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131828411);
    j.p(paramAttributeSet, "findViewById(R.id.story_gallery_holder_title_tv)");
    this.iJG = ((TextView)paramAttributeSet);
    this.sRM.setVisibility(4);
    this.sRN.setImageDrawable(aj.e(paramContext.getResources().getDrawable(2131231442), paramContext.getResources().getColor(2131690552)));
    this.sRM.setOnClickListener((View.OnClickListener)new GalleryHolderView.1(this));
    setBackgroundColor(paramContext.getResources().getColor(2131690549));
    paramContext = g.RL();
    j.p(paramContext, "MMKernel.storage()");
    paramContext = paramContext.Ru().get(ac.a.yLH, Boolean.TRUE);
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type kotlin.Boolean");
      AppMethodBeat.o(110716);
      throw paramContext;
    }
    this.sRP = ((Boolean)paramContext).booleanValue();
    if (this.sRP)
    {
      this.iJG.setTextColor(getResources().getColor(2131690526));
      paramContext = this.iJG;
      paramAttributeSet = StoryGalleryView.sTW;
      paramAttributeSet = getResources().getString(2131304170);
      j.p(paramAttributeSet, "resources.getString(R.st…ory_gallery_holder_title)");
      paramContext.setText((CharSequence)StoryGalleryView.a.m((CharSequence)paramAttributeSet, getResources().getColor(2131690526)));
    }
    for (;;)
    {
      this.sRR = 1.0F;
      AppMethodBeat.o(110716);
      return;
      this.iJG.setTextColor(getResources().getColor(2131690550));
      this.iJG.setText((CharSequence)getResources().getString(2131304168));
    }
  }
  
  public final void cFX()
  {
    AppMethodBeat.i(110714);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { (Animator)ObjectAnimator.ofFloat(this.iJG, "alpha", new float[] { this.iJG.getAlpha(), 0.0F }), (Animator)ObjectAnimator.ofFloat(this.sRM, "alpha", new float[] { this.sRM.getAlpha(), 1.0F }) });
    localAnimatorSet.setDuration(100L);
    localAnimatorSet.start();
    AppMethodBeat.o(110714);
  }
  
  public final void cFY()
  {
    AppMethodBeat.i(110715);
    this.sRM.setVisibility(0);
    this.iJG.setVisibility(4);
    if (this.sRP)
    {
      this.sRP = false;
      e locale = g.RL();
      j.p(locale, "MMKernel.storage()");
      locale.Ru().set(ac.a.yLH, Boolean.FALSE);
    }
    this.iJG.setTextColor(getResources().getColor(2131690550));
    this.iJG.setText((CharSequence)getResources().getString(2131304168));
    AppMethodBeat.o(110715);
  }
  
  public final int getInitMargin()
  {
    return this.sRQ;
  }
  
  public final void setInitMargin(int paramInt)
  {
    this.sRQ = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.GalleryHolderView
 * JD-Core Version:    0.7.0.1
 */