package com.tencent.mm.plugin.textstatus.b;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.textstatus.a.f;
import com.tencent.mm.plugin.textstatus.h.f.c;
import com.tencent.mm.plugin.textstatus.h.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/convert/SquareItemConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/textstatus/model/square/SquareItem;", "()V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends f<com.tencent.mm.plugin.textstatus.h.e.e>
{
  public static final a TjP;
  
  static
  {
    AppMethodBeat.i(290271);
    TjP = new a((byte)0);
    AppMethodBeat.o(290271);
  }
  
  private static final void a(com.tencent.mm.plugin.textstatus.h.e.e parame, View paramView)
  {
    AppMethodBeat.i(290262);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(parame);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/textstatus/convert/SquareItemConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(parame, "$item");
    paramView = parame.topicId;
    parame = parame.Tly;
    localObject = c.TnI;
    parame = new m(paramView, parame, "hello", c.hHN(), 4);
    com.tencent.mm.kernel.h.aZW().a(parame.getType(), (com.tencent.mm.am.h)new b());
    com.tencent.mm.kernel.h.aZW().a((p)parame, 0);
    a.a(new Object(), "com/tencent/mm/plugin/textstatus/convert/SquareItemConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(290262);
  }
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(290285);
    kotlin.g.b.s.u(paramRecyclerView, "recyclerView");
    kotlin.g.b.s.u(paramj, "holder");
    AppMethodBeat.o(290285);
  }
  
  public final int getLayoutId()
  {
    return a.f.TfN;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/convert/SquareItemConvert$Companion;", "", "()V", "TAG", "", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/textstatus/convert/SquareItemConvert$onBindViewHolder$1$1", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements com.tencent.mm.am.h
  {
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
    {
      AppMethodBeat.i(290227);
      if ((paramp instanceof m))
      {
        com.tencent.mm.kernel.h.aZW().b(((m)paramp).getType(), (com.tencent.mm.am.h)this);
        if ((paramInt1 == 0) && (paramInt2 == 0)) {
          Log.i("MicroMsg.TextStatus.SquareItemConvert", "onSceneEnd NetSceneTextStatusLike ok");
        }
      }
      AppMethodBeat.o(290227);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.b.e
 * JD-Core Version:    0.7.0.1
 */