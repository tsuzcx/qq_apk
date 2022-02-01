package com.tencent.mm.plugin.story.ui.a;

import android.content.Intent;
import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import d.g.b.k;
import d.l;
import java.util.ArrayList;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/ui/adapter/GalleryAvatarAdapter;", "Lcom/tencent/mm/plugin/story/ui/adapter/GalleryHeaderAdapter;", "Lcom/tencent/mm/plugin/story/ui/adapter/GalleryAvatarAdapter$GalleryAvatarViewHolder;", "()V", "chatRoom", "", "getChatRoom", "()Ljava/lang/String;", "setChatRoom", "(Ljava/lang/String;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "GalleryAvatarViewHolder", "plugin-story_release"})
public final class b
  extends d<a>
{
  public String iEB;
  
  public final int getItemCount()
  {
    AppMethodBeat.i(119721);
    int i = this.dataList.size();
    AppMethodBeat.o(119721);
    return i;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/ui/adapter/GalleryAvatarAdapter$GalleryAvatarViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/adapter/GalleryAvatarAdapter;Landroid/view/View;)V", "avatarIv", "Landroid/widget/ImageView;", "getAvatarIv", "()Landroid/widget/ImageView;", "nickNameTv", "Landroid/widget/TextView;", "getNickNameTv", "()Landroid/widget/TextView;", "plugin-story_release"})
  public final class a
    extends RecyclerView.w
  {
    final ImageView fxQ;
    final TextView iIU;
    
    public a()
    {
      super();
      AppMethodBeat.i(119719);
      this$1 = localObject.findViewById(2131297008);
      k.g(b.this, "itemView.findViewById(R.id.avatar_iv)");
      this.fxQ = ((ImageView)b.this);
      this$1 = localObject.findViewById(2131302867);
      k.g(b.this, "itemView.findViewById(R.id.nickname_tv)");
      this.iIU = ((TextView)b.this);
      c.e(this.iIU);
      AppMethodBeat.o(119719);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(b paramb, String paramString, b.a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119720);
      k.g(paramView, "it");
      if (paramView.isSelected())
      {
        paramView = new Intent();
        paramView.putExtra("Contact_User", this.zDT);
        paramView.putExtra("Contact_ChatRoomId", this.zDS.iEB);
        paramView.putExtra("CONTACT_INFO_UI_SOURCE", 15);
        View localView = this.zDU.asD;
        k.g(localView, "holder.itemView");
        com.tencent.mm.br.d.b(localView.getContext(), "profile", ".ui.ContactInfoUI", paramView);
      }
      AppMethodBeat.o(119720);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.a.b
 * JD-Core Version:    0.7.0.1
 */