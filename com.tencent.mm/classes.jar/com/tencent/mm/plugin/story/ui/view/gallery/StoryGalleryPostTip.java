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
import com.tencent.mm.ui.am;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryPostTip;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "postTipIv", "Landroid/widget/ImageView;", "getPostTipIv", "()Landroid/widget/ImageView;", "setPostTipIv", "(Landroid/widget/ImageView;)V", "postTipLayout", "Landroid/widget/LinearLayout;", "getPostTipLayout", "()Landroid/widget/LinearLayout;", "setPostTipLayout", "(Landroid/widget/LinearLayout;)V", "postTipTv", "Landroid/widget/TextView;", "getPostTipTv", "()Landroid/widget/TextView;", "setPostTipTv", "(Landroid/widget/TextView;)V", "updatePostStatus", "", "item", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "Companion", "plugin-story_release"})
public final class StoryGalleryPostTip
  extends RelativeLayout
{
  public static final String TAG = "MicroMsg.StoryGalleryPostTip";
  public static final StoryGalleryPostTip.a zMB;
  public TextView zMA;
  private LinearLayout zMy;
  private ImageView zMz;
  
  static
  {
    AppMethodBeat.i(120417);
    zMB = new StoryGalleryPostTip.a((byte)0);
    TAG = "MicroMsg.StoryGalleryPostTip";
    AppMethodBeat.o(120417);
  }
  
  public StoryGalleryPostTip(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(120416);
    View.inflate(paramContext, 2131495697, (ViewGroup)this);
    paramContext = findViewById(2131305437);
    k.g(paramContext, "findViewById(R.id.story_gallery_post_tip_iv)");
    this.zMz = ((ImageView)paramContext);
    paramContext = findViewById(2131305438);
    k.g(paramContext, "findViewById(R.id.story_gallery_post_tip_tv)");
    this.zMA = ((TextView)paramContext);
    this.zMz.setImageDrawable(am.e(getResources().getDrawable(2131690566), -65536));
    setVisibility(8);
    AppMethodBeat.o(120416);
  }
  
  public final ImageView getPostTipIv()
  {
    return this.zMz;
  }
  
  public final LinearLayout getPostTipLayout()
  {
    return this.zMy;
  }
  
  public final TextView getPostTipTv()
  {
    return this.zMA;
  }
  
  public final void setPostTipIv(ImageView paramImageView)
  {
    AppMethodBeat.i(120414);
    k.h(paramImageView, "<set-?>");
    this.zMz = paramImageView;
    AppMethodBeat.o(120414);
  }
  
  public final void setPostTipLayout(LinearLayout paramLinearLayout)
  {
    this.zMy = paramLinearLayout;
  }
  
  public final void setPostTipTv(TextView paramTextView)
  {
    AppMethodBeat.i(120415);
    k.h(paramTextView, "<set-?>");
    this.zMA = paramTextView;
    AppMethodBeat.o(120415);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryPostTip
 * JD-Core Version:    0.7.0.1
 */