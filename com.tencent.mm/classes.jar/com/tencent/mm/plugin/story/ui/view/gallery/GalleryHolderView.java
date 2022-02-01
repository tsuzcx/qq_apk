package com.tencent.mm.plugin.story.ui.view.gallery;

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
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.ao;
import d.g.b.p;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryHolderView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "attrs", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "initMargin", "getInitMargin", "()I", "setInitMargin", "(I)V", "lastScrollAlpha", "", "mActionIv", "Landroid/widget/ImageView;", "mActionView", "Landroid/widget/LinearLayout;", "mBubbleIv", "mIsFirstPullDown", "", "mTitleTv", "Landroid/widget/TextView;", "smallHead", "animClosing", "", "animOpening", "checkSmallHead", "closed", "goStoryCaptureUI", "onClosing", "offset", "onListInnerScroll", "onOpening", "opened", "setVisibility", "visibility", "Companion", "plugin-story_release"})
public final class GalleryHolderView
  extends RelativeLayout
{
  public static final GalleryHolderView.a Bui;
  static final String TAG = "MicroMsg.GalleryHolderView";
  LinearLayout Buc;
  private ImageView Bud;
  private ImageView Bue;
  private boolean Buf;
  int Bug;
  float Buh;
  TextView lHk;
  
  static
  {
    AppMethodBeat.i(120342);
    Bui = new GalleryHolderView.a((byte)0);
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
    View.inflate(paramContext, 2131495694, (ViewGroup)this);
    paramAttributeSet = findViewById(2131305427);
    p.g(paramAttributeSet, "findViewById(R.id.story_…ery_holder_action_layout)");
    this.Buc = ((LinearLayout)paramAttributeSet);
    paramAttributeSet = findViewById(2131305426);
    p.g(paramAttributeSet, "findViewById(R.id.story_gallery_holder_action_iv)");
    this.Bud = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131305429);
    p.g(paramAttributeSet, "findViewById(R.id.story_gallery_holder_bubble)");
    this.Bue = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131305431);
    p.g(paramAttributeSet, "findViewById(R.id.story_gallery_holder_title_tv)");
    this.lHk = ((TextView)paramAttributeSet);
    this.Buc.setVisibility(4);
    this.Bud.setImageDrawable(ao.e(paramContext.getResources().getDrawable(2131690361), paramContext.getResources().getColor(2131100993)));
    this.Buc.setOnClickListener((View.OnClickListener)new GalleryHolderView.1(this));
    setBackgroundColor(paramContext.getResources().getColor(2131100983));
    paramContext = g.ajR();
    p.g(paramContext, "MMKernel.storage()");
    paramContext = paramContext.ajA().get(am.a.Jac, Boolean.TRUE);
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type kotlin.Boolean");
      AppMethodBeat.o(120340);
      throw paramContext;
    }
    this.Buf = ((Boolean)paramContext).booleanValue();
    if (this.Buf)
    {
      this.lHk.setTextColor(getResources().getColor(2131100960));
      paramContext = this.lHk;
      paramAttributeSet = StoryGalleryView.Bwk;
      paramAttributeSet = getResources().getString(2131764278);
      p.g(paramAttributeSet, "resources.getString(R.st…ory_gallery_holder_title)");
      paramContext.setText((CharSequence)StoryGalleryView.a.l((CharSequence)paramAttributeSet, getResources().getColor(2131100960)));
      if (!com.tencent.mm.plugin.story.c.a.e.Bap.ekF()) {
        break label376;
      }
      this.Bue.setVisibility(8);
    }
    for (;;)
    {
      this.Buh = 1.0F;
      AppMethodBeat.o(120340);
      return;
      this.lHk.setTextColor(getResources().getColor(2131100984));
      this.lHk.setText((CharSequence)getResources().getString(2131764276));
      break;
      label376:
      this.Bue.setVisibility(0);
    }
  }
  
  public final void epM()
  {
    AppMethodBeat.i(120337);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { (Animator)ObjectAnimator.ofFloat(this.lHk, "alpha", new float[] { this.lHk.getAlpha(), 0.0F }), (Animator)ObjectAnimator.ofFloat(this.Buc, "alpha", new float[] { this.Buc.getAlpha(), 1.0F }) });
    localAnimatorSet.setDuration(100L);
    localAnimatorSet.start();
    AppMethodBeat.o(120337);
  }
  
  public final void epN()
  {
    AppMethodBeat.i(120338);
    this.Buc.setVisibility(0);
    this.lHk.setVisibility(4);
    if (this.Buf)
    {
      this.Buf = false;
      com.tencent.mm.kernel.e locale = g.ajR();
      p.g(locale, "MMKernel.storage()");
      locale.ajA().set(am.a.Jac, Boolean.FALSE);
    }
    this.lHk.setTextColor(getResources().getColor(2131100984));
    this.lHk.setText((CharSequence)getResources().getString(2131764276));
    AppMethodBeat.o(120338);
  }
  
  public final int getInitMargin()
  {
    return this.Bug;
  }
  
  public final void setInitMargin(int paramInt)
  {
    this.Bug = paramInt;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(120339);
    super.setVisibility(paramInt);
    if (paramInt == 0)
    {
      if (com.tencent.mm.plugin.story.c.a.e.Bap.ekF())
      {
        this.Bue.setVisibility(8);
        AppMethodBeat.o(120339);
        return;
      }
      this.Bue.setVisibility(0);
    }
    AppMethodBeat.o(120339);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.GalleryHolderView
 * JD-Core Version:    0.7.0.1
 */