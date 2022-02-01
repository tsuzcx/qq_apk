package com.tencent.mm.plugin.profile.ui.tab.list;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.ui.widget.MMNeat7extView;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabVideoAdapter$BizProfileTabVideoVH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "coverHeightForVideo", "", "getCoverHeightForVideo", "()I", "coverHeightForVideo$delegate", "Lkotlin/Lazy;", "coverImageView", "Landroid/widget/ImageView;", "getCoverImageView", "()Landroid/widget/ImageView;", "setCoverImageView", "(Landroid/widget/ImageView;)V", "friendRelateInfoTextView", "Landroid/widget/TextView;", "getFriendRelateInfoTextView", "()Landroid/widget/TextView;", "setFriendRelateInfoTextView", "(Landroid/widget/TextView;)V", "shadowView", "getShadowView", "()Landroid/view/View;", "setShadowView", "titleLayout", "Landroid/view/ViewGroup;", "getTitleLayout", "()Landroid/view/ViewGroup;", "setTitleLayout", "(Landroid/view/ViewGroup;)V", "titleTextView", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "getTitleTextView", "()Lcom/tencent/mm/ui/widget/MMNeat7extView;", "setTitleTextView", "(Lcom/tencent/mm/ui/widget/MMNeat7extView;)V", "videoDurationTextView", "getVideoDurationTextView", "setVideoDurationTextView", "app_release"})
public final class d$c
  extends RecyclerView.v
{
  TextView HhN;
  TextView HhO;
  View HhP;
  ViewGroup HhQ;
  MMNeat7extView HhR;
  final f HhS;
  ImageView cvK;
  
  public d$c(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(252338);
    View localView = paramView.findViewById(R.h.dtE);
    p.j(localView, "itemView.findViewById(R.…profile_item_video_image)");
    this.cvK = ((ImageView)localView);
    localView = paramView.findViewById(R.h.dtD);
    p.j(localView, "itemView.findViewById(R.…e_item_video_duration_tv)");
    this.HhN = ((TextView)localView);
    localView = paramView.findViewById(R.h.dtC);
    p.j(localView, "itemView.findViewById(R.…ofile_item_video_desc_tv)");
    this.HhO = ((TextView)localView);
    localView = paramView.findViewById(R.h.dtB);
    p.j(localView, "itemView.findViewById(R.…e_item_video_desc_shadow)");
    this.HhP = localView;
    localView = paramView.findViewById(R.h.dtF);
    p.j(localView, "itemView.findViewById(R.…_item_video_title_layout)");
    this.HhQ = ((ViewGroup)localView);
    localView = paramView.findViewById(R.h.dtG);
    p.j(localView, "itemView.findViewById(R.…file_item_video_title_tv)");
    this.HhR = ((MMNeat7extView)localView);
    this.HhS = g.ar((a)new d.c.a(paramView));
    AppMethodBeat.o(252338);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.tab.list.d.c
 * JD-Core Version:    0.7.0.1
 */