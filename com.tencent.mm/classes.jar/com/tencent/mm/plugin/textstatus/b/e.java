package com.tencent.mm.plugin.textstatus.b;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.textstatus.b.f;
import com.tencent.mm.plugin.textstatus.g.e.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/convert/SquareItemConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/textstatus/model/square/SquareItem;", "()V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "Companion", "plugin-textstatus_release"})
public final class e
  extends com.tencent.mm.view.recyclerview.e<com.tencent.mm.plugin.textstatus.g.d.e>
{
  public static final a MAe;
  
  static
  {
    AppMethodBeat.i(233457);
    MAe = new a((byte)0);
    AppMethodBeat.o(233457);
  }
  
  public final void a(RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.i parami, int paramInt)
  {
    AppMethodBeat.i(233454);
    p.k(paramRecyclerView, "recyclerView");
    p.k(parami, "holder");
    AppMethodBeat.o(233454);
  }
  
  public final int getLayoutId()
  {
    return b.f.Myk;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/convert/SquareItemConvert$Companion;", "", "()V", "TAG", "", "plugin-textstatus_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(com.tencent.mm.plugin.textstatus.g.d.e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(237573);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      a.c("com/tencent/mm/plugin/textstatus/convert/SquareItemConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      paramView = this.MAf.topicId;
      localObject = this.MAf.MBU;
      b.a locala = com.tencent.mm.plugin.textstatus.g.e.b.MDX;
      paramView = new com.tencent.mm.plugin.textstatus.g.l(paramView, (String)localObject, "hello", com.tencent.mm.plugin.textstatus.g.e.b.gmd(), 4);
      h.aGY().a(paramView.getType(), (com.tencent.mm.an.i)new com.tencent.mm.an.i()
      {
        public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
        {
          AppMethodBeat.i(237482);
          if ((paramAnonymousq instanceof com.tencent.mm.plugin.textstatus.g.l))
          {
            h.aGY().b(((com.tencent.mm.plugin.textstatus.g.l)paramAnonymousq).getType(), (com.tencent.mm.an.i)this);
            if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0)) {
              Log.i("MicroMsg.TextStatus.SquareItemConvert", "onSceneEnd NetSceneTextStatusLike ok");
            }
          }
          AppMethodBeat.o(237482);
        }
      });
      h.aGY().b((q)paramView);
      a.a(this, "com/tencent/mm/plugin/textstatus/convert/SquareItemConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(237573);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.b.e
 * JD-Core Version:    0.7.0.1
 */