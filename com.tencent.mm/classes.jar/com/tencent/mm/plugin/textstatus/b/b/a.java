package com.tencent.mm.plugin.textstatus.b.b;

import android.content.Intent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.textstatus.a.f;
import com.tencent.mm.plugin.textstatus.conversation.d.f.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/convert/like/LikeHistoryItemConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/textstatus/model/like/LikeHistoryItem;", "()V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.view.recyclerview.f<com.tencent.mm.plugin.textstatus.h.d.a>
{
  public static final a.a Tkh;
  
  static
  {
    AppMethodBeat.i(290301);
    Tkh = new a.a((byte)0);
    AppMethodBeat.o(290301);
  }
  
  private static final void a(au paramau, j paramj, View paramView)
  {
    AppMethodBeat.i(290298);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramau);
    localb.cH(paramj);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/convert/like/LikeHistoryItemConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramj, "$holder");
    paramView = new Intent();
    paramView.putExtra("Contact_User", paramau.field_username);
    paramView.putExtra("CONTACT_INFO_UI_SOURCE", 54);
    c.b(paramj.context, "profile", ".ui.ContactInfoUI", paramView, 213);
    ((com.tencent.mm.plugin.textstatus.a.f)h.az(com.tencent.mm.plugin.textstatus.a.f.class)).report22210(paramau.field_username, 4L);
    paramj = com.tencent.mm.plugin.textstatus.conversation.d.f.Tjd;
    paramau = paramau.field_username;
    s.s(paramau, "contact.username");
    f.a.bdG(paramau);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/textstatus/convert/like/LikeHistoryItemConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(290298);
  }
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(290321);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    AppMethodBeat.o(290321);
  }
  
  public final int getLayoutId()
  {
    return a.f.Tfv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.b.b.a
 * JD-Core Version:    0.7.0.1
 */