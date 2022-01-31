package com.tencent.mm.plugin.story.ui.view.gallery;

import a.f.b.j;
import a.l;
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
import com.tencent.mm.ui.aj;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryPostTip;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "postTipIv", "Landroid/widget/ImageView;", "getPostTipIv", "()Landroid/widget/ImageView;", "setPostTipIv", "(Landroid/widget/ImageView;)V", "postTipLayout", "Landroid/widget/LinearLayout;", "getPostTipLayout", "()Landroid/widget/LinearLayout;", "setPostTipLayout", "(Landroid/widget/LinearLayout;)V", "postTipTv", "Landroid/widget/TextView;", "getPostTipTv", "()Landroid/widget/TextView;", "setPostTipTv", "(Landroid/widget/TextView;)V", "updatePostStatus", "", "item", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "Companion", "plugin-story_release"})
public final class StoryGalleryPostTip
  extends RelativeLayout
{
  public static final String TAG = "MicroMsg.StoryGalleryPostTip";
  public static final StoryGalleryPostTip.a sTp;
  private LinearLayout sTm;
  private ImageView sTn;
  public TextView sTo;
  
  static
  {
    AppMethodBeat.i(110772);
    sTp = new StoryGalleryPostTip.a((byte)0);
    TAG = "MicroMsg.StoryGalleryPostTip";
    AppMethodBeat.o(110772);
  }
  
  public StoryGalleryPostTip(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(110771);
    View.inflate(paramContext, 2130970959, (ViewGroup)this);
    paramContext = findViewById(2131828422);
    j.p(paramContext, "findViewById(R.id.story_gallery_post_tip_iv)");
    this.sTn = ((ImageView)paramContext);
    paramContext = findViewById(2131828423);
    j.p(paramContext, "findViewById(R.id.story_gallery_post_tip_tv)");
    this.sTo = ((TextView)paramContext);
    this.sTn.setImageDrawable(aj.e(getResources().getDrawable(2131231507), -65536));
    setVisibility(8);
    AppMethodBeat.o(110771);
  }
  
  public final ImageView getPostTipIv()
  {
    return this.sTn;
  }
  
  public final LinearLayout getPostTipLayout()
  {
    return this.sTm;
  }
  
  public final TextView getPostTipTv()
  {
    return this.sTo;
  }
  
  public final void setPostTipIv(ImageView paramImageView)
  {
    AppMethodBeat.i(110769);
    j.q(paramImageView, "<set-?>");
    this.sTn = paramImageView;
    AppMethodBeat.o(110769);
  }
  
  public final void setPostTipLayout(LinearLayout paramLinearLayout)
  {
    this.sTm = paramLinearLayout;
  }
  
  public final void setPostTipTv(TextView paramTextView)
  {
    AppMethodBeat.i(110770);
    j.q(paramTextView, "<set-?>");
    this.sTo = paramTextView;
    AppMethodBeat.o(110770);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryPostTip
 * JD-Core Version:    0.7.0.1
 */