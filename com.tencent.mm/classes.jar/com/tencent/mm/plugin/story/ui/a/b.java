package com.tencent.mm.plugin.story.ui.a;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.story.a.d;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/adapter/GalleryAvatarAdapter;", "Lcom/tencent/mm/plugin/story/ui/adapter/GalleryHeaderAdapter;", "Lcom/tencent/mm/plugin/story/ui/adapter/GalleryAvatarAdapter$GalleryAvatarViewHolder;", "()V", "chatRoom", "", "getChatRoom", "()Ljava/lang/String;", "setChatRoom", "(Ljava/lang/String;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "GalleryAvatarViewHolder", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends d<a>
{
  public String pJq;
  
  private static final void a(String paramString, b paramb, a parama, View paramView)
  {
    AppMethodBeat.i(367325);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramString);
    localb.cH(paramb);
    localb.cH(parama);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/story/ui/adapter/GalleryAvatarAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramString, "$user");
    s.u(paramb, "this$0");
    s.u(parama, "$holder");
    if (paramView.isSelected())
    {
      paramView = new Intent();
      paramView.putExtra("Contact_User", paramString);
      paramView.putExtra("Contact_ChatRoomId", paramb.pJq);
      paramView.putExtra("CONTACT_INFO_UI_SOURCE", 15);
      c.b(parama.caK.getContext(), "profile", ".ui.ContactInfoUI", paramView);
    }
    a.a(new Object(), "com/tencent/mm/plugin/story/ui/adapter/GalleryAvatarAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(367325);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(119721);
    int i = this.pUj.size();
    AppMethodBeat.o(119721);
    return i;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/adapter/GalleryAvatarAdapter$GalleryAvatarViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/adapter/GalleryAvatarAdapter;Landroid/view/View;)V", "avatarIv", "Landroid/widget/ImageView;", "getAvatarIv", "()Landroid/widget/ImageView;", "nickNameTv", "Landroid/widget/TextView;", "getNickNameTv", "()Landroid/widget/TextView;", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
    extends RecyclerView.v
  {
    final ImageView lKK;
    final TextView pRg;
    
    public a()
    {
      super();
      AppMethodBeat.i(119719);
      this$1 = localObject.findViewById(a.d.avatar_iv);
      s.s(b.this, "itemView.findViewById(R.id.avatar_iv)");
      this.lKK = ((ImageView)b.this);
      this$1 = localObject.findViewById(a.d.nickname_tv);
      s.s(b.this, "itemView.findViewById(R.id.nickname_tv)");
      this.pRg = ((TextView)b.this);
      com.tencent.mm.ae.d.h(this.pRg);
      AppMethodBeat.o(119719);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.a.b
 * JD-Core Version:    0.7.0.1
 */