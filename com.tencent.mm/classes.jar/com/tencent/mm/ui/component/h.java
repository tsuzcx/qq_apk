package com.tencent.mm.ui.component;

import androidx.lifecycle.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"uicClass", "Ljava/lang/Class;", "U", "Lcom/tencent/mm/ui/component/UIComponent;", "T", "Lcom/tencent/mm/ui/component/ApiUIC;", "withApi", "Landroidx/lifecycle/ViewModel;", "api", "plugin-uic_release"})
public final class h
{
  public static final <U extends x, T extends a> Class<U> h(Class<U> paramClass, Class<T> paramClass1)
  {
    AppMethodBeat.i(231458);
    p.k(paramClass, "$this$withApi");
    p.k(paramClass1, "api");
    Object localObject = g.Xox;
    localObject = (Map)g.hUc();
    paramClass1 = paramClass1.getName();
    p.j(paramClass1, "api.name");
    ((Map)localObject).put(paramClass1, paramClass);
    AppMethodBeat.o(231458);
    return paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.component.h
 * JD-Core Version:    0.7.0.1
 */