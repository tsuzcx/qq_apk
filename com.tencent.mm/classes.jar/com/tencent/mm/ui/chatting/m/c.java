package com.tencent.mm.ui.chatting.m;

import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.component.UIComponent;
import java.util.Set;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/utils/SportsMsgReportUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "set", "", "", "getSet", "()Ljava/util/Set;", "set$delegate", "Lkotlin/Lazy;", "clearSet", "", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends UIComponent
{
  private final j aeKC;
  
  public c(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(253880);
    this.aeKC = k.cm((a)a.aeKD);
    AppMethodBeat.o(253880);
  }
  
  public final Set<String> jxe()
  {
    AppMethodBeat.i(253884);
    Set localSet = (Set)this.aeKC.getValue();
    AppMethodBeat.o(253884);
    return localSet;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<Set<String>>
  {
    public static final a aeKD;
    
    static
    {
      AppMethodBeat.i(253876);
      aeKD = new a();
      AppMethodBeat.o(253876);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.m.c
 * JD-Core Version:    0.7.0.1
 */