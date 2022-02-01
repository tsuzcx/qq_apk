package com.tencent.mm.ui.base;

import android.content.Context;
import android.view.LayoutInflater;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/base/DefaultLayoutInflaterFactory;", "Lcom/tencent/mm/ui/base/ILayoutInflaterFactory;", "()V", "create", "Landroid/view/LayoutInflater;", "context", "Landroid/content/Context;", "luggage-commons-widget_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  implements h
{
  public static final e adOj;
  
  static
  {
    AppMethodBeat.i(251390);
    adOj = new e();
    AppMethodBeat.o(251390);
  }
  
  public final LayoutInflater ex(Context paramContext)
  {
    AppMethodBeat.i(251392);
    s.u(paramContext, "context");
    paramContext = LayoutInflater.from(MMApplicationContext.getContext()).cloneInContext(paramContext);
    s.s(paramContext, "from(MMApplicationContex…).cloneInContext(context)");
    AppMethodBeat.o(251392);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.e
 * JD-Core Version:    0.7.0.1
 */