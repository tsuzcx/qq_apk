package com.tencent.mm.plugin.textstatus.b;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.textstatus.f.f.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.h;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/convert/SquareItemConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/textstatus/model/square/SquareItem;", "()V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "Companion", "plugin-textstatus_release"})
public final class e
  extends com.tencent.mm.view.recyclerview.e<com.tencent.mm.plugin.textstatus.f.e.e>
{
  public static final a FXC;
  
  static
  {
    AppMethodBeat.i(216069);
    FXC = new a((byte)0);
    AppMethodBeat.o(216069);
  }
  
  public final void a(RecyclerView paramRecyclerView, h paramh, int paramInt)
  {
    AppMethodBeat.i(216067);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramh, "holder");
    AppMethodBeat.o(216067);
  }
  
  public final int getLayoutId()
  {
    return 2131496705;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/convert/SquareItemConvert$Companion;", "", "()V", "TAG", "", "plugin-textstatus_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(com.tencent.mm.plugin.textstatus.f.e.e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(216066);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      a.b("com/tencent/mm/plugin/textstatus/convert/SquareItemConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      paramView = this.FXD.FZz;
      localObject = this.FXD.FYf;
      b.a locala = com.tencent.mm.plugin.textstatus.f.f.b.FZG;
      paramView = new com.tencent.mm.plugin.textstatus.f.i(paramView, (String)localObject, "hello", com.tencent.mm.plugin.textstatus.f.f.b.fvX(), 4);
      g.azz().a(paramView.getType(), (com.tencent.mm.ak.i)new com.tencent.mm.ak.i()
      {
        public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
        {
          AppMethodBeat.i(216065);
          if ((paramAnonymousq instanceof com.tencent.mm.plugin.textstatus.f.i))
          {
            g.azz().b(((com.tencent.mm.plugin.textstatus.f.i)paramAnonymousq).getType(), (com.tencent.mm.ak.i)this);
            if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0)) {
              Log.i("MicroMsg.TxtStatus.SquareItemConvert", "onSceneEnd NetSceneTextStatusLike ok");
            }
          }
          AppMethodBeat.o(216065);
        }
      });
      g.azz().b((q)paramView);
      a.a(this, "com/tencent/mm/plugin/textstatus/convert/SquareItemConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(216066);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.b.e
 * JD-Core Version:    0.7.0.1
 */