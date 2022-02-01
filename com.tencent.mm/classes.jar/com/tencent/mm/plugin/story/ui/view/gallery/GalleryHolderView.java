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
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.am;
import d.g.b.k;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryHolderView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "attrs", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "initMargin", "getInitMargin", "()I", "setInitMargin", "(I)V", "lastScrollAlpha", "", "mActionIv", "Landroid/widget/ImageView;", "mActionView", "Landroid/widget/LinearLayout;", "mBubbleIv", "mIsFirstPullDown", "", "mTitleTv", "Landroid/widget/TextView;", "smallHead", "animClosing", "", "animOpening", "checkSmallHead", "closed", "goStoryCaptureUI", "onClosing", "offset", "onListInnerScroll", "onOpening", "opened", "setVisibility", "visibility", "Companion", "plugin-story_release"})
public final class GalleryHolderView
  extends RelativeLayout
{
  static final String TAG = "MicroMsg.GalleryHolderView";
  public static final GalleryHolderView.a zLj;
  TextView lfN;
  LinearLayout zLd;
  private ImageView zLe;
  private ImageView zLf;
  private boolean zLg;
  int zLh;
  float zLi;
  
  static
  {
    AppMethodBeat.i(120342);
    zLj = new GalleryHolderView.a((byte)0);
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
    this.zLd = ((LinearLayout)paramAttributeSet);
    paramAttributeSet = findViewById(2131305426);
    k.g(paramAttributeSet, "findViewById(R.id.story_gallery_holder_action_iv)");
    this.zLe = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131305429);
    k.g(paramAttributeSet, "findViewById(R.id.story_gallery_holder_bubble)");
    this.zLf = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131305431);
    k.g(paramAttributeSet, "findViewById(R.id.story_gallery_holder_title_tv)");
    this.lfN = ((TextView)paramAttributeSet);
    this.zLd.setVisibility(4);
    this.zLe.setImageDrawable(am.e(paramContext.getResources().getDrawable(2131690361), paramContext.getResources().getColor(2131100993)));
    this.zLd.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120336);
        GalleryHolderView.a(this.zLk);
        AppMethodBeat.o(120336);
      }
    });
    setBackgroundColor(paramContext.getResources().getColor(2131100983));
    paramContext = g.agR();
    k.g(paramContext, "MMKernel.storage()");
    paramContext = paramContext.agA().get(ah.a.GSX, Boolean.TRUE);
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type kotlin.Boolean");
      AppMethodBeat.o(120340);
      throw paramContext;
    }
    this.zLg = ((Boolean)paramContext).booleanValue();
    if (this.zLg)
    {
      this.lfN.setTextColor(getResources().getColor(2131100960));
      paramContext = this.lfN;
      paramAttributeSet = StoryGalleryView.zNl;
      paramAttributeSet = getResources().getString(2131764278);
      k.g(paramAttributeSet, "resources.getString(R.st…ory_gallery_holder_title)");
      paramContext.setText((CharSequence)StoryGalleryView.a.l((CharSequence)paramAttributeSet, getResources().getColor(2131100960)));
      if (!com.tencent.mm.plugin.story.c.a.e.zqS.dUI()) {
        break label376;
      }
      this.zLf.setVisibility(8);
    }
    for (;;)
    {
      this.zLi = 1.0F;
      AppMethodBeat.o(120340);
      return;
      this.lfN.setTextColor(getResources().getColor(2131100984));
      this.lfN.setText((CharSequence)getResources().getString(2131764276));
      break;
      label376:
      this.zLf.setVisibility(0);
    }
  }
  
  public final void dZO()
  {
    AppMethodBeat.i(120337);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { (Animator)ObjectAnimator.ofFloat(this.lfN, "alpha", new float[] { this.lfN.getAlpha(), 0.0F }), (Animator)ObjectAnimator.ofFloat(this.zLd, "alpha", new float[] { this.zLd.getAlpha(), 1.0F }) });
    localAnimatorSet.setDuration(100L);
    localAnimatorSet.start();
    AppMethodBeat.o(120337);
  }
  
  public final void dZP()
  {
    AppMethodBeat.i(120338);
    this.zLd.setVisibility(0);
    this.lfN.setVisibility(4);
    if (this.zLg)
    {
      this.zLg = false;
      com.tencent.mm.kernel.e locale = g.agR();
      k.g(locale, "MMKernel.storage()");
      locale.agA().set(ah.a.GSX, Boolean.FALSE);
    }
    this.lfN.setTextColor(getResources().getColor(2131100984));
    this.lfN.setText((CharSequence)getResources().getString(2131764276));
    AppMethodBeat.o(120338);
  }
  
  public final int getInitMargin()
  {
    return this.zLh;
  }
  
  public final void setInitMargin(int paramInt)
  {
    this.zLh = paramInt;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(120339);
    super.setVisibility(paramInt);
    if (paramInt == 0)
    {
      if (com.tencent.mm.plugin.story.c.a.e.zqS.dUI())
      {
        this.zLf.setVisibility(8);
        AppMethodBeat.o(120339);
        return;
      }
      this.zLf.setVisibility(0);
    }
    AppMethodBeat.o(120339);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.GalleryHolderView
 * JD-Core Version:    0.7.0.1
 */