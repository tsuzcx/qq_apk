package com.tencent.mm.ui.base;

import android.content.Context;
import android.view.LayoutInflater;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/base/LuggageLayoutInflaterFactory;", "Lcom/tencent/mm/ui/base/ILayoutInflaterFactory;", "()V", "realFactory", "create", "Landroid/view/LayoutInflater;", "context", "Landroid/content/Context;", "override", "", "overrideFactory", "luggage-commons-widget_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  implements h
{
  public static final j adPk;
  private static h adPl;
  
  static
  {
    AppMethodBeat.i(251374);
    adPk = new j();
    adPl = (h)e.adOj;
    AppMethodBeat.o(251374);
  }
  
  public static void a(h paramh)
  {
    AppMethodBeat.i(251369);
    s.u(paramh, "overrideFactory");
    adPl = paramh;
    AppMethodBeat.o(251369);
  }
  
  public final LayoutInflater ex(Context paramContext)
  {
    AppMethodBeat.i(251379);
    s.u(paramContext, "context");
    paramContext = adPl.ex(paramContext);
    AppMethodBeat.o(251379);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.j
 * JD-Core Version:    0.7.0.1
 */