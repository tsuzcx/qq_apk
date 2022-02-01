package com.tencent.mm.plugin.textstatus.b.b;

import android.content.Intent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.textstatus.a.f;
import com.tencent.mm.plugin.textstatus.conversation.d.f.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/convert/like/ReferenceHistoryItemConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/textstatus/model/like/ReferenceHistoryItem;", "()V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends com.tencent.mm.view.recyclerview.f<com.tencent.mm.plugin.textstatus.h.d.c>
{
  public static final d.a Tkl;
  
  static
  {
    AppMethodBeat.i(290300);
    Tkl = new d.a((byte)0);
    AppMethodBeat.o(290300);
  }
  
  private static final void a(au paramau, j paramj, View paramView)
  {
    AppMethodBeat.i(290296);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramau);
    localb.cH(paramj);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/textstatus/convert/like/ReferenceHistoryItemConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramj, "$holder");
    paramView = new Intent();
    paramView.putExtra("Contact_User", paramau.field_username);
    paramView.putExtra("CONTACT_INFO_UI_SOURCE", 54);
    com.tencent.mm.br.c.b(paramj.context, "profile", ".ui.ContactInfoUI", paramView, 213);
    ((com.tencent.mm.plugin.textstatus.a.f)h.az(com.tencent.mm.plugin.textstatus.a.f.class)).report22210(paramau.field_username, 4L);
    paramj = com.tencent.mm.plugin.textstatus.conversation.d.f.Tjd;
    paramau = paramau.field_username;
    s.s(paramau, "contact.username");
    f.a.bdG(paramau);
    a.a(new Object(), "com/tencent/mm/plugin/textstatus/convert/like/ReferenceHistoryItemConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(290296);
  }
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(290320);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    AppMethodBeat.o(290320);
  }
  
  public final int getLayoutId()
  {
    return a.f.TfF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.b.b.d
 * JD-Core Version:    0.7.0.1
 */