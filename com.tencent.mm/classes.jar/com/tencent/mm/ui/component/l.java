package com.tencent.mm.ui.component;

import androidx.lifecycle.af;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"uic", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "T", "Lcom/tencent/mm/ui/component/ApiUIC;", "Lkotlin/reflect/KClass;", "getUic", "(Lkotlin/reflect/KClass;)Ljava/lang/Class;", "withApi", "U", "Landroidx/lifecycle/ViewModel;", "api", "withInstanceApi", "Lcom/tencent/mm/ui/component/ApiInstance;", "plugin-uic_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class l
{
  public static final <T extends c> Class<UIComponent> a(kotlin.l.c<T> paramc)
  {
    AppMethodBeat.i(250404);
    s.u(paramc, "<this>");
    Object localObject = k.aeZF;
    localObject = k.jxL();
    String str = paramc.klu();
    s.checkNotNull(str);
    localObject = ((HashMap)localObject).get(str);
    if ((localObject instanceof Class)) {}
    for (localObject = (Class)localObject; localObject == null; localObject = null)
    {
      paramc = new RuntimeException(paramc + " never import any instance.");
      AppMethodBeat.o(250404);
      throw paramc;
    }
    AppMethodBeat.o(250404);
    return localObject;
  }
  
  public static final <U extends b, T extends b> Class<U> h(Class<U> paramClass, Class<T> paramClass1)
  {
    AppMethodBeat.i(250394);
    s.u(paramClass, "<this>");
    s.u(paramClass1, "api");
    Object localObject = k.aeZF;
    localObject = (Map)k.jxM();
    paramClass1 = paramClass1.getName();
    s.s(paramClass1, "api.name");
    ((Map)localObject).put(paramClass1, paramClass);
    AppMethodBeat.o(250394);
    return paramClass;
  }
  
  public static final <U extends af, T extends c> Class<U> i(Class<U> paramClass, Class<T> paramClass1)
  {
    AppMethodBeat.i(250399);
    s.u(paramClass, "<this>");
    s.u(paramClass1, "api");
    Object localObject = k.aeZF;
    localObject = (Map)k.jxL();
    paramClass1 = paramClass1.getName();
    s.s(paramClass1, "api.name");
    ((Map)localObject).put(paramClass1, paramClass);
    AppMethodBeat.o(250399);
    return paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.component.l
 * JD-Core Version:    0.7.0.1
 */