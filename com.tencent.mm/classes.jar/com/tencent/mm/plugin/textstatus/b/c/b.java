package com.tencent.mm.plugin.textstatus.b.c;

import android.content.Intent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.textstatus.a.f;
import com.tencent.mm.plugin.textstatus.h.f.g.c;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.j;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/convert/topic/SameOtherTopicItemConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/textstatus/model/topic/SameTopicFriendsItem;", "maxAvatarNum", "", "source", "(II)V", "getMaxAvatarNum", "()I", "getSource", "getLayoutId", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends f<com.tencent.mm.plugin.textstatus.h.g.b>
{
  public static final b.a Tko;
  private final int Tkp;
  private final int source;
  
  static
  {
    AppMethodBeat.i(290260);
    Tko = new b.a((byte)0);
    AppMethodBeat.o(290260);
  }
  
  public b(int paramInt1, int paramInt2)
  {
    this.Tkp = paramInt1;
    this.source = paramInt2;
  }
  
  private static final void a(com.tencent.mm.plugin.textstatus.h.g.b paramb, j paramj, b paramb1, View paramView)
  {
    AppMethodBeat.i(290256);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramj);
    localb.cH(paramb1);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/convert/topic/SameOtherTopicItemConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "$item");
    s.u(paramj, "$holder");
    s.u(paramb1, "this$0");
    int i = paramb.TnV.bMQ.size();
    if (i > 0)
    {
      if (i != 1) {
        break label260;
      }
      paramView = (com.tencent.mm.plugin.textstatus.h.f.b)paramb.TnV.bMQ.get(0);
      localObject = new Intent();
      ((Intent)localObject).putExtra("Contact_User", paramView.field_UserName);
      ((Intent)localObject).putExtra("CONTACT_INFO_UI_SOURCE", 53);
      c.b(paramj.context, "profile", ".ui.ContactInfoUI", (Intent)localObject, 213);
      paramj = com.tencent.mm.plugin.textstatus.i.b.Trt;
      paramj = paramView.field_IconID;
      paramView = paramView.field_UserName;
      i = paramb.TnV.bMQ.size();
      int j = paramb1.source;
      s.s(paramj, "field_IconID");
      s.s(paramView, "field_UserName");
      com.tencent.mm.plugin.textstatus.i.b.a(3L, paramj, i, paramView, null, null, j, 0L, 176);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/textstatus/convert/topic/SameOtherTopicItemConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(290256);
      return;
      label260:
      paramj = com.tencent.mm.plugin.textstatus.i.b.Trt;
      paramj = ((com.tencent.mm.plugin.textstatus.h.f.b)paramb.TnV.bMQ.get(0)).field_IconID;
      s.s(paramj, "item.info.items[0].field_IconID");
      com.tencent.mm.plugin.textstatus.i.b.a(2L, paramj, paramb.TnV.bMQ.size(), null, null, null, paramb1.source, 0L, 184);
    }
  }
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(290277);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    AppMethodBeat.o(290277);
  }
  
  public final int getLayoutId()
  {
    return a.f.TfH;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k=3, mv={1, 5, 1})
  public static final class b<T>
    implements Comparator
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(290226);
      int i = kotlin.b.a.b((Comparable)Integer.valueOf(((com.tencent.mm.plugin.textstatus.h.f.b)paramT2).field_CreateTime), (Comparable)Integer.valueOf(((com.tencent.mm.plugin.textstatus.h.f.b)paramT1).field_CreateTime));
      AppMethodBeat.o(290226);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.b.c.b
 * JD-Core Version:    0.7.0.1
 */