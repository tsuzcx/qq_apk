package com.tencent.mm.plugin.story.ui.a;

import a.f.b.j;
import a.l;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.b;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/adapter/GalleryAvatarAdapter$GalleryAvatarViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/adapter/GalleryAvatarAdapter;Landroid/view/View;)V", "avatarIv", "Landroid/widget/ImageView;", "getAvatarIv", "()Landroid/widget/ImageView;", "nickNameTv", "Landroid/widget/TextView;", "getNickNameTv", "()Landroid/widget/TextView;", "plugin-story_release"})
public final class b$a
  extends RecyclerView.v
{
  final ImageView ehv;
  final TextView gvQ;
  
  public b$a(View paramView)
  {
    super(localObject);
    AppMethodBeat.i(110092);
    paramView = localObject.findViewById(2131821210);
    j.p(paramView, "itemView.findViewById(R.id.avatar_iv)");
    this.ehv = ((ImageView)paramView);
    paramView = localObject.findViewById(2131823254);
    j.p(paramView, "itemView.findViewById(R.id.nickname_tv)");
    this.gvQ = ((TextView)paramView);
    b.e(this.gvQ);
    AppMethodBeat.o(110092);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.a.b.a
 * JD-Core Version:    0.7.0.1
 */