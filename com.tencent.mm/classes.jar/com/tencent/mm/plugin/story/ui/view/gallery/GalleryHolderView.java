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
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.am;
import d.g.b.k;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryHolderView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "attrs", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "initMargin", "getInitMargin", "()I", "setInitMargin", "(I)V", "lastScrollAlpha", "", "mActionIv", "Landroid/widget/ImageView;", "mActionView", "Landroid/widget/LinearLayout;", "mBubbleIv", "mIsFirstPullDown", "", "mTitleTv", "Landroid/widget/TextView;", "smallHead", "animClosing", "", "animOpening", "checkSmallHead", "closed", "goStoryCaptureUI", "onClosing", "offset", "onListInnerScroll", "onOpening", "opened", "setVisibility", "visibility", "Companion", "plugin-story_release"})
public final class GalleryHolderView
  extends RelativeLayout
{
  static final String TAG = "MicroMsg.GalleryHolderView";
  public static final a yxU;
  TextView kEu;
  LinearLayout yxO;
  private ImageView yxP;
  private ImageView yxQ;
  private boolean yxR;
  int yxS;
  float yxT;
  
  static
  {
    AppMethodBeat.i(120342);
    yxU = new a((byte)0);
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
    k.g(paramAttributeSet, "findViewById(R.id.story_…ery_holder_action_layout)");
    this.yxO = ((LinearLayout)paramAttributeSet);
    paramAttributeSet = findViewById(2131305426);
    k.g(paramAttributeSet, "findViewById(R.id.story_gallery_holder_action_iv)");
    this.yxP = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131305429);
    k.g(paramAttributeSet, "findViewById(R.id.story_gallery_holder_bubble)");
    this.yxQ = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131305431);
    k.g(paramAttributeSet, "findViewById(R.id.story_gallery_holder_title_tv)");
    this.kEu = ((TextView)paramAttributeSet);
    this.yxO.setVisibility(4);
    this.yxP.setImageDrawable(am.e(paramContext.getResources().getDrawable(2131690361), paramContext.getResources().getColor(2131100993)));
    this.yxO.setOnClickListener((View.OnClickListener)new GalleryHolderView.1(this));
    setBackgroundColor(paramContext.getResources().getColor(2131100983));
    paramContext = g.afB();
    k.g(paramContext, "MMKernel.storage()");
    paramContext = paramContext.afk().get(ae.a.Fvd, Boolean.TRUE);
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type kotlin.Boolean");
      AppMethodBeat.o(120340);
      throw paramContext;
    }
    this.yxR = ((Boolean)paramContext).booleanValue();
    if (this.yxR)
    {
      this.kEu.setTextColor(getResources().getColor(2131100960));
      paramContext = this.kEu;
      paramAttributeSet = StoryGalleryView.yzX;
      paramAttributeSet = getResources().getString(2131764278);
      k.g(paramAttributeSet, "resources.getString(R.st…ory_gallery_holder_title)");
      paramContext.setText((CharSequence)StoryGalleryView.a.m((CharSequence)paramAttributeSet, getResources().getColor(2131100960)));
      if (!com.tencent.mm.plugin.story.c.a.e.ydS.dGh()) {
        break label376;
      }
      this.yxQ.setVisibility(8);
    }
    for (;;)
    {
      this.yxT = 1.0F;
      AppMethodBeat.o(120340);
      return;
      this.kEu.setTextColor(getResources().getColor(2131100984));
      this.kEu.setText((CharSequence)getResources().getString(2131764276));
      break;
      label376:
      this.yxQ.setVisibility(0);
    }
  }
  
  public final void dLo()
  {
    AppMethodBeat.i(120337);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { (Animator)ObjectAnimator.ofFloat(this.kEu, "alpha", new float[] { this.kEu.getAlpha(), 0.0F }), (Animator)ObjectAnimator.ofFloat(this.yxO, "alpha", new float[] { this.yxO.getAlpha(), 1.0F }) });
    localAnimatorSet.setDuration(100L);
    localAnimatorSet.start();
    AppMethodBeat.o(120337);
  }
  
  public final void dLp()
  {
    AppMethodBeat.i(120338);
    this.yxO.setVisibility(0);
    this.kEu.setVisibility(4);
    if (this.yxR)
    {
      this.yxR = false;
      com.tencent.mm.kernel.e locale = g.afB();
      k.g(locale, "MMKernel.storage()");
      locale.afk().set(ae.a.Fvd, Boolean.FALSE);
    }
    this.kEu.setTextColor(getResources().getColor(2131100984));
    this.kEu.setText((CharSequence)getResources().getString(2131764276));
    AppMethodBeat.o(120338);
  }
  
  public final int getInitMargin()
  {
    return this.yxS;
  }
  
  public final void setInitMargin(int paramInt)
  {
    this.yxS = paramInt;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(120339);
    super.setVisibility(paramInt);
    if (paramInt == 0)
    {
      if (com.tencent.mm.plugin.story.c.a.e.ydS.dGh())
      {
        this.yxQ.setVisibility(8);
        AppMethodBeat.o(120339);
        return;
      }
      this.yxQ.setVisibility(0);
    }
    AppMethodBeat.o(120339);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryHolderView$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-story_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.GalleryHolderView
 * JD-Core Version:    0.7.0.1
 */