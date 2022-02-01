package com.tencent.mm.plugin.textstatus.conversation.d;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k.b;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/conversation/data/TextStatusPagerDataUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "initSelectIndex", "", "getInitSelectIndex", "()I", "initSelectIndex$delegate", "Lkotlin/Lazy;", "pageCnt", "getPageCnt", "pageCnt$delegate", "scene", "getScene", "scene$delegate", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends UIComponent
{
  public static final a TiZ;
  private final j Tja;
  private final j Tjb;
  private final j pmx;
  
  static
  {
    AppMethodBeat.i(290938);
    TiZ = new a((byte)0);
    AppMethodBeat.o(290938);
  }
  
  public e(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(290915);
    this.pmx = kotlin.k.cm((a)new d(this));
    this.Tja = kotlin.k.cm((a)new c(this));
    this.Tjb = kotlin.k.cm((a)new b(this));
    AppMethodBeat.o(290915);
  }
  
  public final int hGw()
  {
    AppMethodBeat.i(290946);
    int i = ((Number)this.Tjb.getValue()).intValue();
    AppMethodBeat.o(290946);
    return i;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/conversation/data/TextStatusPagerDataUIC$Companion;", "", "()V", "TAG", "", "getPageCnt", "", "context", "Landroid/content/Context;", "of", "Lcom/tencent/mm/plugin/textstatus/conversation/data/TextStatusPagerDataUIC;", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static int kn(Context paramContext)
    {
      AppMethodBeat.i(290951);
      s.u(paramContext, "context");
      com.tencent.mm.ui.component.k localk = com.tencent.mm.ui.component.k.aeZF;
      paramContext = com.tencent.mm.ui.component.k.nq(paramContext).q(e.class);
      s.s(paramContext, "UICProvider.of(context).…PagerDataUIC::class.java)");
      int i = e.a((e)paramContext);
      AppMethodBeat.o(290951);
      return i;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<Integer>
  {
    b(e parame)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements a<Integer>
  {
    c(e parame)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements a<Integer>
  {
    d(e parame)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.conversation.d.e
 * JD-Core Version:    0.7.0.1
 */