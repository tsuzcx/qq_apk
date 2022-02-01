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

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryPostTip;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "postTipIv", "Landroid/widget/ImageView;", "getPostTipIv", "()Landroid/widget/ImageView;", "setPostTipIv", "(Landroid/widget/ImageView;)V", "postTipLayout", "Landroid/widget/LinearLayout;", "getPostTipLayout", "()Landroid/widget/LinearLayout;", "setPostTipLayout", "(Landroid/widget/LinearLayout;)V", "postTipTv", "Landroid/widget/TextView;", "getPostTipTv", "()Landroid/widget/TextView;", "setPostTipTv", "(Landroid/widget/TextView;)V", "updatePostStatus", "", "item", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "Companion", "plugin-story_release"})
public final class StoryGalleryPostTip
  extends RelativeLayout
{
  public static final String TAG = "MicroMsg.StoryGalleryPostTip";
  public static final a yzn;
  private LinearLayout yzk;
  private ImageView yzl;
  public TextView yzm;
  
  static
  {
    AppMethodBeat.i(120417);
    yzn = new a((byte)0);
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
    this.yzl = ((ImageView)paramContext);
    paramContext = findViewById(2131305438);
    k.g(paramContext, "findViewById(R.id.story_gallery_post_tip_tv)");
    this.yzm = ((TextView)paramContext);
    this.yzl.setImageDrawable(am.e(getResources().getDrawable(2131690566), -65536));
    setVisibility(8);
    AppMethodBeat.o(120416);
  }
  
  public final ImageView getPostTipIv()
  {
    return this.yzl;
  }
  
  public final LinearLayout getPostTipLayout()
  {
    return this.yzk;
  }
  
  public final TextView getPostTipTv()
  {
    return this.yzm;
  }
  
  public final void setPostTipIv(ImageView paramImageView)
  {
    AppMethodBeat.i(120414);
    k.h(paramImageView, "<set-?>");
    this.yzl = paramImageView;
    AppMethodBeat.o(120414);
  }
  
  public final void setPostTipLayout(LinearLayout paramLinearLayout)
  {
    this.yzk = paramLinearLayout;
  }
  
  public final void setPostTipTv(TextView paramTextView)
  {
    AppMethodBeat.i(120415);
    k.h(paramTextView, "<set-?>");
    this.yzm = paramTextView;
    AppMethodBeat.o(120415);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryPostTip$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-story_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryPostTip
 * JD-Core Version:    0.7.0.1
 */