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
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.ar;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryHolderView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "attrs", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "initMargin", "getInitMargin", "()I", "setInitMargin", "(I)V", "lastScrollAlpha", "", "mActionIv", "Landroid/widget/ImageView;", "mActionView", "Landroid/widget/LinearLayout;", "mBubbleIv", "mIsFirstPullDown", "", "mTitleTv", "Landroid/widget/TextView;", "smallHead", "animClosing", "", "animOpening", "checkSmallHead", "closed", "goStoryCaptureUI", "onClosing", "offset", "onListInnerScroll", "onOpening", "opened", "setVisibility", "visibility", "Companion", "plugin-story_release"})
public final class GalleryHolderView
  extends RelativeLayout
{
  public static final a FEV;
  static final String TAG = "MicroMsg.GalleryHolderView";
  LinearLayout FEP;
  private ImageView FEQ;
  private ImageView FER;
  private boolean FES;
  int FET;
  float FEU;
  TextView mPa;
  
  static
  {
    AppMethodBeat.i(120342);
    FEV = new a((byte)0);
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
    View.inflate(paramContext, 2131496599, (ViewGroup)this);
    paramAttributeSet = findViewById(2131308633);
    p.g(paramAttributeSet, "findViewById(R.id.story_…ery_holder_action_layout)");
    this.FEP = ((LinearLayout)paramAttributeSet);
    paramAttributeSet = findViewById(2131308632);
    p.g(paramAttributeSet, "findViewById(R.id.story_gallery_holder_action_iv)");
    this.FEQ = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131308635);
    p.g(paramAttributeSet, "findViewById(R.id.story_gallery_holder_bubble)");
    this.FER = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131308637);
    p.g(paramAttributeSet, "findViewById(R.id.story_gallery_holder_title_tv)");
    this.mPa = ((TextView)paramAttributeSet);
    this.FEP.setVisibility(4);
    this.FEQ.setImageDrawable(ar.e(paramContext.getResources().getDrawable(2131690501), paramContext.getResources().getColor(2131101223)));
    this.FEP.setOnClickListener((View.OnClickListener)new GalleryHolderView.1(this));
    setBackgroundColor(paramContext.getResources().getColor(2131101213));
    paramContext = g.aAh();
    p.g(paramContext, "MMKernel.storage()");
    paramContext = paramContext.azQ().get(ar.a.OiI, Boolean.TRUE);
    if (paramContext == null)
    {
      paramContext = new t("null cannot be cast to non-null type kotlin.Boolean");
      AppMethodBeat.o(120340);
      throw paramContext;
    }
    this.FES = ((Boolean)paramContext).booleanValue();
    if (this.FES)
    {
      this.mPa.setTextColor(getResources().getColor(2131101188));
      paramContext = this.mPa;
      paramAttributeSet = StoryGalleryView.FGV;
      paramAttributeSet = getResources().getString(2131766536);
      p.g(paramAttributeSet, "resources.getString(R.st…ory_gallery_holder_title)");
      paramContext.setText((CharSequence)StoryGalleryView.a.k((CharSequence)paramAttributeSet, getResources().getColor(2131101188)));
      if (!com.tencent.mm.plugin.story.c.a.e.Fln.fng()) {
        break label376;
      }
      this.FER.setVisibility(8);
    }
    for (;;)
    {
      this.FEU = 1.0F;
      AppMethodBeat.o(120340);
      return;
      this.mPa.setTextColor(getResources().getColor(2131101214));
      this.mPa.setText((CharSequence)getResources().getString(2131766534));
      break;
      label376:
      this.FER.setVisibility(0);
    }
  }
  
  public final void fsl()
  {
    AppMethodBeat.i(120337);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { (Animator)ObjectAnimator.ofFloat(this.mPa, "alpha", new float[] { this.mPa.getAlpha(), 0.0F }), (Animator)ObjectAnimator.ofFloat(this.FEP, "alpha", new float[] { this.FEP.getAlpha(), 1.0F }) });
    localAnimatorSet.setDuration(100L);
    localAnimatorSet.start();
    AppMethodBeat.o(120337);
  }
  
  public final void fsm()
  {
    AppMethodBeat.i(120338);
    this.FEP.setVisibility(0);
    this.mPa.setVisibility(4);
    if (this.FES)
    {
      this.FES = false;
      com.tencent.mm.kernel.e locale = g.aAh();
      p.g(locale, "MMKernel.storage()");
      locale.azQ().set(ar.a.OiI, Boolean.FALSE);
    }
    this.mPa.setTextColor(getResources().getColor(2131101214));
    this.mPa.setText((CharSequence)getResources().getString(2131766534));
    AppMethodBeat.o(120338);
  }
  
  public final int getInitMargin()
  {
    return this.FET;
  }
  
  public final void setInitMargin(int paramInt)
  {
    this.FET = paramInt;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(120339);
    super.setVisibility(paramInt);
    if (paramInt == 0)
    {
      if (com.tencent.mm.plugin.story.c.a.e.Fln.fng())
      {
        this.FER.setVisibility(8);
        AppMethodBeat.o(120339);
        return;
      }
      this.FER.setVisibility(0);
    }
    AppMethodBeat.o(120339);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryHolderView$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-story_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.GalleryHolderView
 * JD-Core Version:    0.7.0.1
 */