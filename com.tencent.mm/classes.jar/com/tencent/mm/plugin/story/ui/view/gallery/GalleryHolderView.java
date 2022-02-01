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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.story.a.a;
import com.tencent.mm.plugin.story.a.d;
import com.tencent.mm.plugin.story.a.e;
import com.tencent.mm.plugin.story.a.f;
import com.tencent.mm.plugin.story.a.g;
import com.tencent.mm.plugin.story.c.a.e;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.au;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryHolderView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "attrs", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "initMargin", "getInitMargin", "()I", "setInitMargin", "(I)V", "lastScrollAlpha", "", "mActionIv", "Landroid/widget/ImageView;", "mActionView", "Landroid/widget/LinearLayout;", "mBubbleIv", "mIsFirstPullDown", "", "mTitleTv", "Landroid/widget/TextView;", "smallHead", "animClosing", "", "animOpening", "checkSmallHead", "closed", "goStoryCaptureUI", "onClosing", "offset", "onListInnerScroll", "onOpening", "opened", "setVisibility", "visibility", "Companion", "plugin-story_release"})
public final class GalleryHolderView
  extends RelativeLayout
{
  public static final a LYW;
  static final String TAG = "MicroMsg.GalleryHolderView";
  LinearLayout LYQ;
  private ImageView LYR;
  private ImageView LYS;
  private boolean LYT;
  int LYU;
  float LYV;
  TextView pPT;
  
  static
  {
    AppMethodBeat.i(120342);
    LYW = new a((byte)0);
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
    View.inflate(paramContext, a.e.LCY, (ViewGroup)this);
    paramAttributeSet = findViewById(a.d.LBE);
    p.j(paramAttributeSet, "findViewById(R.id.story_…ery_holder_action_layout)");
    this.LYQ = ((LinearLayout)paramAttributeSet);
    paramAttributeSet = findViewById(a.d.LBD);
    p.j(paramAttributeSet, "findViewById(R.id.story_gallery_holder_action_iv)");
    this.LYR = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(a.d.LBF);
    p.j(paramAttributeSet, "findViewById(R.id.story_gallery_holder_bubble)");
    this.LYS = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(a.d.LBH);
    p.j(paramAttributeSet, "findViewById(R.id.story_gallery_holder_title_tv)");
    this.pPT = ((TextView)paramAttributeSet);
    this.LYQ.setVisibility(4);
    this.LYR.setImageDrawable(au.e(paramContext.getResources().getDrawable(a.f.icons_filled_camera), paramContext.getResources().getColor(a.a.Lzh)));
    this.LYQ.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120336);
        b localb = new b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/story/ui/view/gallery/GalleryHolderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        GalleryHolderView.a(this.LYX);
        a.a(this, "com/tencent/mm/plugin/story/ui/view/gallery/GalleryHolderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(120336);
      }
    });
    setBackgroundColor(paramContext.getResources().getColor(a.a.Lzd));
    paramContext = h.aHG();
    p.j(paramContext, "MMKernel.storage()");
    paramContext = paramContext.aHp().get(ar.a.VwY, Boolean.TRUE);
    if (paramContext == null)
    {
      paramContext = new t("null cannot be cast to non-null type kotlin.Boolean");
      AppMethodBeat.o(120340);
      throw paramContext;
    }
    this.LYT = ((Boolean)paramContext).booleanValue();
    if (this.LYT)
    {
      this.pPT.setTextColor(getResources().getColor(a.a.Lza));
      paramContext = this.pPT;
      paramAttributeSet = StoryGalleryView.MaV;
      paramAttributeSet = getResources().getString(a.g.LEg);
      p.j(paramAttributeSet, "resources.getString(R.st…ory_gallery_holder_title)");
      paramContext.setText((CharSequence)StoryGalleryView.a.m((CharSequence)paramAttributeSet, getResources().getColor(a.a.Lza)));
      if (!e.LFp.gbz()) {
        break label388;
      }
      this.LYS.setVisibility(8);
    }
    for (;;)
    {
      this.LYV = 1.0F;
      AppMethodBeat.o(120340);
      return;
      this.pPT.setTextColor(getResources().getColor(a.a.Lze));
      this.pPT.setText((CharSequence)getResources().getString(a.g.LEf));
      break;
      label388:
      this.LYS.setVisibility(0);
    }
  }
  
  public final int getInitMargin()
  {
    return this.LYU;
  }
  
  public final void ggK()
  {
    AppMethodBeat.i(120337);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { (Animator)ObjectAnimator.ofFloat(this.pPT, "alpha", new float[] { this.pPT.getAlpha(), 0.0F }), (Animator)ObjectAnimator.ofFloat(this.LYQ, "alpha", new float[] { this.LYQ.getAlpha(), 1.0F }) });
    localAnimatorSet.setDuration(100L);
    localAnimatorSet.start();
    AppMethodBeat.o(120337);
  }
  
  public final void ggL()
  {
    AppMethodBeat.i(120338);
    this.LYQ.setVisibility(0);
    this.pPT.setVisibility(4);
    if (this.LYT)
    {
      this.LYT = false;
      f localf = h.aHG();
      p.j(localf, "MMKernel.storage()");
      localf.aHp().set(ar.a.VwY, Boolean.FALSE);
    }
    this.pPT.setTextColor(getResources().getColor(a.a.Lze));
    this.pPT.setText((CharSequence)getResources().getString(a.g.LEf));
    AppMethodBeat.o(120338);
  }
  
  public final void setInitMargin(int paramInt)
  {
    this.LYU = paramInt;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(120339);
    super.setVisibility(paramInt);
    if (paramInt == 0)
    {
      if (e.LFp.gbz())
      {
        this.LYS.setVisibility(8);
        AppMethodBeat.o(120339);
        return;
      }
      this.LYS.setVisibility(0);
    }
    AppMethodBeat.o(120339);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryHolderView$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-story_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.GalleryHolderView
 * JD-Core Version:    0.7.0.1
 */