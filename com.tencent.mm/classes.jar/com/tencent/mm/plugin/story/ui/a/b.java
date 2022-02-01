package com.tencent.mm.plugin.story.ui.a;

import android.content.Intent;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/adapter/GalleryAvatarAdapter;", "Lcom/tencent/mm/plugin/story/ui/adapter/GalleryHeaderAdapter;", "Lcom/tencent/mm/plugin/story/ui/adapter/GalleryAvatarAdapter$GalleryAvatarViewHolder;", "()V", "chatRoom", "", "getChatRoom", "()Ljava/lang/String;", "setChatRoom", "(Ljava/lang/String;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "GalleryAvatarViewHolder", "plugin-story_release"})
public final class b
  extends d<a>
{
  public String jVv;
  
  public final int getItemCount()
  {
    AppMethodBeat.i(119721);
    int i = this.kgc.size();
    AppMethodBeat.o(119721);
    return i;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/adapter/GalleryAvatarAdapter$GalleryAvatarViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/adapter/GalleryAvatarAdapter;Landroid/view/View;)V", "avatarIv", "Landroid/widget/ImageView;", "getAvatarIv", "()Landroid/widget/ImageView;", "nickNameTv", "Landroid/widget/TextView;", "getNickNameTv", "()Landroid/widget/TextView;", "plugin-story_release"})
  public final class a
    extends RecyclerView.v
  {
    final ImageView gyr;
    final TextView kcZ;
    
    public a()
    {
      super();
      AppMethodBeat.i(119719);
      this$1 = localObject.findViewById(2131297134);
      p.g(b.this, "itemView.findViewById(R.id.avatar_iv)");
      this.gyr = ((ImageView)b.this);
      this$1 = localObject.findViewById(2131305440);
      p.g(b.this, "itemView.findViewById(R.id.nickname_tv)");
      this.kcZ = ((TextView)b.this);
      com.tencent.mm.ac.d.f(this.kcZ);
      AppMethodBeat.o(119719);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(b paramb, String paramString, b.a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119720);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      a.b("com/tencent/mm/plugin/story/ui/adapter/GalleryAvatarAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      p.g(paramView, "it");
      if (paramView.isSelected())
      {
        paramView = new Intent();
        paramView.putExtra("Contact_User", this.FxG);
        paramView.putExtra("Contact_ChatRoomId", this.FxF.jVv);
        paramView.putExtra("CONTACT_INFO_UI_SOURCE", 15);
        localObject = this.FxH.aus;
        p.g(localObject, "holder.itemView");
        c.b(((View)localObject).getContext(), "profile", ".ui.ContactInfoUI", paramView);
      }
      a.a(this, "com/tencent/mm/plugin/story/ui/adapter/GalleryAvatarAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119720);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.a.b
 * JD-Core Version:    0.7.0.1
 */