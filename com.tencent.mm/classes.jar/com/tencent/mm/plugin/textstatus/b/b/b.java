package com.tencent.mm.plugin.textstatus.b.b;

import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/convert/like/LikeItemConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/textstatus/model/like/LikeItem;", "()V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "Companion", "plugin-textstatus_release"})
public final class b
  extends e<com.tencent.mm.plugin.textstatus.f.c.b>
{
  public static final b.a FXR;
  
  static
  {
    AppMethodBeat.i(216109);
    FXR = new b.a((byte)0);
    AppMethodBeat.o(216109);
  }
  
  public final void a(RecyclerView paramRecyclerView, h paramh, int paramInt)
  {
    AppMethodBeat.i(216107);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramh, "holder");
    AppMethodBeat.o(216107);
  }
  
  public final int getLayoutId()
  {
    return 2131496687;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.b.b.b
 * JD-Core Version:    0.7.0.1
 */