package com.tencent.mm.plugin.story.ui.view.gallery;

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
import com.tencent.mm.plugin.story.a.d;
import com.tencent.mm.plugin.story.a.e;
import com.tencent.mm.plugin.story.a.f;
import com.tencent.mm.ui.bb;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryPostTip;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "postTipIv", "Landroid/widget/ImageView;", "getPostTipIv", "()Landroid/widget/ImageView;", "setPostTipIv", "(Landroid/widget/ImageView;)V", "postTipLayout", "Landroid/widget/LinearLayout;", "getPostTipLayout", "()Landroid/widget/LinearLayout;", "setPostTipLayout", "(Landroid/widget/LinearLayout;)V", "postTipTv", "Landroid/widget/TextView;", "getPostTipTv", "()Landroid/widget/TextView;", "setPostTipTv", "(Landroid/widget/TextView;)V", "updatePostStatus", "", "item", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "Companion", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class StoryGalleryPostTip
  extends RelativeLayout
{
  public static final StoryGalleryPostTip.a SBE;
  public static final String TAG;
  private LinearLayout SBF;
  private ImageView SBG;
  public TextView SBH;
  
  static
  {
    AppMethodBeat.i(120417);
    SBE = new StoryGalleryPostTip.a((byte)0);
    TAG = "MicroMsg.StoryGalleryPostTip";
    AppMethodBeat.o(120417);
  }
  
  public StoryGalleryPostTip(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(120416);
    View.inflate(paramContext, a.e.SgM, (ViewGroup)this);
    paramContext = findViewById(a.d.Sfy);
    s.s(paramContext, "findViewById(R.id.story_gallery_post_tip_iv)");
    this.SBG = ((ImageView)paramContext);
    paramContext = findViewById(a.d.Sfz);
    s.s(paramContext, "findViewById(R.id.story_gallery_post_tip_tv)");
    this.SBH = ((TextView)paramContext);
    this.SBG.setImageDrawable(bb.e(getResources().getDrawable(a.f.icons_outlined_error), -65536));
    setVisibility(8);
    AppMethodBeat.o(120416);
  }
  
  public final ImageView getPostTipIv()
  {
    return this.SBG;
  }
  
  public final LinearLayout getPostTipLayout()
  {
    return this.SBF;
  }
  
  public final TextView getPostTipTv()
  {
    return this.SBH;
  }
  
  public final void setPostTipIv(ImageView paramImageView)
  {
    AppMethodBeat.i(120414);
    s.u(paramImageView, "<set-?>");
    this.SBG = paramImageView;
    AppMethodBeat.o(120414);
  }
  
  public final void setPostTipLayout(LinearLayout paramLinearLayout)
  {
    this.SBF = paramLinearLayout;
  }
  
  public final void setPostTipTv(TextView paramTextView)
  {
    AppMethodBeat.i(120415);
    s.u(paramTextView, "<set-?>");
    this.SBH = paramTextView;
    AppMethodBeat.o(120415);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryPostTip
 * JD-Core Version:    0.7.0.1
 */