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
import com.tencent.mm.ui.ao;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryPostTip;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "postTipIv", "Landroid/widget/ImageView;", "getPostTipIv", "()Landroid/widget/ImageView;", "setPostTipIv", "(Landroid/widget/ImageView;)V", "postTipLayout", "Landroid/widget/LinearLayout;", "getPostTipLayout", "()Landroid/widget/LinearLayout;", "setPostTipLayout", "(Landroid/widget/LinearLayout;)V", "postTipTv", "Landroid/widget/TextView;", "getPostTipTv", "()Landroid/widget/TextView;", "setPostTipTv", "(Landroid/widget/TextView;)V", "updatePostStatus", "", "item", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "Companion", "plugin-story_release"})
public final class StoryGalleryPostTip
  extends RelativeLayout
{
  public static final StoryGalleryPostTip.a BvA;
  public static final String TAG = "MicroMsg.StoryGalleryPostTip";
  private LinearLayout Bvx;
  private ImageView Bvy;
  public TextView Bvz;
  
  static
  {
    AppMethodBeat.i(120417);
    BvA = new StoryGalleryPostTip.a((byte)0);
    TAG = "MicroMsg.StoryGalleryPostTip";
    AppMethodBeat.o(120417);
  }
  
  public StoryGalleryPostTip(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(120416);
    View.inflate(paramContext, 2131495697, (ViewGroup)this);
    paramContext = findViewById(2131305437);
    p.g(paramContext, "findViewById(R.id.story_gallery_post_tip_iv)");
    this.Bvy = ((ImageView)paramContext);
    paramContext = findViewById(2131305438);
    p.g(paramContext, "findViewById(R.id.story_gallery_post_tip_tv)");
    this.Bvz = ((TextView)paramContext);
    this.Bvy.setImageDrawable(ao.e(getResources().getDrawable(2131690566), -65536));
    setVisibility(8);
    AppMethodBeat.o(120416);
  }
  
  public final ImageView getPostTipIv()
  {
    return this.Bvy;
  }
  
  public final LinearLayout getPostTipLayout()
  {
    return this.Bvx;
  }
  
  public final TextView getPostTipTv()
  {
    return this.Bvz;
  }
  
  public final void setPostTipIv(ImageView paramImageView)
  {
    AppMethodBeat.i(120414);
    p.h(paramImageView, "<set-?>");
    this.Bvy = paramImageView;
    AppMethodBeat.o(120414);
  }
  
  public final void setPostTipLayout(LinearLayout paramLinearLayout)
  {
    this.Bvx = paramLinearLayout;
  }
  
  public final void setPostTipTv(TextView paramTextView)
  {
    AppMethodBeat.i(120415);
    p.h(paramTextView, "<set-?>");
    this.Bvz = paramTextView;
    AppMethodBeat.o(120415);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryPostTip
 * JD-Core Version:    0.7.0.1
 */