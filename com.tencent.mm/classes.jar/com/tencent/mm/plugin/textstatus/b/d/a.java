package com.tencent.mm.plugin.textstatus.b.d;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.textstatus.b.f;
import com.tencent.mm.plugin.textstatus.g.e.f.c;
import com.tencent.mm.plugin.textstatus.ui.TextStatusSameTopicsActivity;
import com.tencent.mm.plugin.textstatus.ui.TextStatusSameTopicsActivity.a;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.i;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/convert/topic/SameOtherTopicItemConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/textstatus/model/topic/SameTopicFriendsItem;", "maxAvatarNum", "", "source", "(II)V", "getMaxAvatarNum", "()I", "getSource", "getLayoutId", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "Companion", "plugin-textstatus_release"})
public final class a
  extends e<com.tencent.mm.plugin.textstatus.g.f.a>
{
  public static final a.a MAN;
  private final int MAM;
  final int source;
  
  static
  {
    AppMethodBeat.i(238290);
    MAN = new a.a((byte)0);
    AppMethodBeat.o(238290);
  }
  
  public a(int paramInt1, int paramInt2)
  {
    this.MAM = paramInt1;
    this.source = paramInt2;
  }
  
  public final void a(RecyclerView paramRecyclerView, i parami, int paramInt)
  {
    AppMethodBeat.i(238279);
    p.k(paramRecyclerView, "recyclerView");
    p.k(parami, "holder");
    AppMethodBeat.o(238279);
  }
  
  public final int getLayoutId()
  {
    return b.f.Myd;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(a parama, com.tencent.mm.plugin.textstatus.g.f.a parama1, i parami) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(235792);
      Object localObject = new b();
      ((b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/convert/topic/SameOtherTopicItemConvert$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
      int i = this.MAQ.MEm.lxh.size();
      if (i > 0)
      {
        if (i != 1) {
          break label203;
        }
        paramView = (com.tencent.mm.plugin.textstatus.g.e.a)this.MAQ.MEm.lxh.get(0);
        localObject = new Intent();
        ((Intent)localObject).putExtra("Contact_User", paramView.field_UserName);
        ((Intent)localObject).putExtra("CONTACT_INFO_UI_SOURCE", 53);
        c.b(this.tDl.getContext(), "profile", ".ui.ContactInfoUI", (Intent)localObject, 213);
        localObject = com.tencent.mm.plugin.textstatus.h.a.MGJ;
        localObject = paramView.field_IconID;
        p.j(localObject, "userItem.field_IconID");
        paramView = paramView.field_UserName;
        p.j(paramView, "userItem.field_UserName");
        com.tencent.mm.plugin.textstatus.h.a.a(3L, (String)localObject, this.MAQ.MEm.lxh.size(), paramView, null, null, this.MAO.source, 48);
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/convert/topic/SameOtherTopicItemConvert$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(235792);
        return;
        label203:
        paramView = TextStatusSameTopicsActivity.MNZ;
        paramView = this.tDl.getContext();
        p.j(paramView, "holder.context");
        TextStatusSameTopicsActivity.a.a(paramView, this.MAQ.MEm.topicId, false, 2, ((com.tencent.mm.plugin.textstatus.g.e.a)this.MAQ.MEm.lxh.get(0)).field_UserName);
        paramView = com.tencent.mm.plugin.textstatus.h.a.MGJ;
        paramView = ((com.tencent.mm.plugin.textstatus.g.e.a)this.MAQ.MEm.lxh.get(0)).field_IconID;
        p.j(paramView, "item.info.items[0].field_IconID");
        com.tencent.mm.plugin.textstatus.h.a.a(2L, paramView, this.MAQ.MEm.lxh.size(), null, null, null, this.MAO.source, 56);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.b.d.a
 * JD-Core Version:    0.7.0.1
 */