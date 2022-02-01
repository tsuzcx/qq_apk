package com.tencent.mm.plugin.p;

import androidx.lifecycle.ab;
import androidx.lifecycle.x;
import androidx.lifecycle.y;
import androidx.lifecycle.y.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/livestorage/LiveDB;", "", "()V", "Companion", "plugin-livestorage_release"})
public final class d
{
  public static final a EiT;
  
  static
  {
    AppMethodBeat.i(254423);
    EiT = new a((byte)0);
    AppMethodBeat.o(254423);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/livestorage/LiveDB$Companion;", "", "()V", "getLiveDB", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "getLiveStorage", "plugin-livestorage_release"})
  public static final class a
  {
    public static <T extends x> T bj(Class<T> paramClass)
    {
      AppMethodBeat.i(254362);
      p.k(paramClass, "modelClass");
      h.aHE().aGH();
      if (!a.class.isAssignableFrom(paramClass))
      {
        paramClass = (Throwable)new IllegalArgumentException("getLiveDB modelClass must extends BaseMMLiveDB");
        AppMethodBeat.o(254362);
        throw paramClass;
      }
      com.tencent.mm.kernel.b localb = h.aHE();
      p.j(localb, "MMKernel.account()");
      paramClass = new y((ab)localb.aGT(), (y.b)new a()).i(paramClass);
      AppMethodBeat.o(254362);
      return paramClass;
    }
    
    public static <T extends x> T bk(Class<T> paramClass)
    {
      AppMethodBeat.i(254365);
      p.k(paramClass, "modelClass");
      h.aHE().aGH();
      if (!b.class.isAssignableFrom(paramClass))
      {
        paramClass = (Throwable)new IllegalArgumentException("getLiveStorage modelClass must extends BaseMMLiveStorage");
        AppMethodBeat.o(254365);
        throw paramClass;
      }
      com.tencent.mm.kernel.b localb = h.aHE();
      p.j(localb, "MMKernel.account()");
      paramClass = new y((ab)localb.aGT(), (y.b)new b()).i(paramClass);
      AppMethodBeat.o(254365);
      return paramClass;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/livestorage/LiveDB$Companion$getLiveDB$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "plugin-livestorage_release"})
    public static final class a
      implements y.b
    {
      public final <T extends x> T create(Class<T> paramClass)
      {
        AppMethodBeat.i(254427);
        p.k(paramClass, "modelClass");
        paramClass = (x)paramClass.newInstance();
        AppMethodBeat.o(254427);
        return paramClass;
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/livestorage/LiveDB$Companion$getLiveStorage$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "plugin-livestorage_release"})
    public static final class b
      implements y.b
    {
      public final <T extends x> T create(Class<T> paramClass)
      {
        AppMethodBeat.i(254526);
        p.k(paramClass, "modelClass");
        paramClass = (x)paramClass.newInstance();
        AppMethodBeat.o(254526);
        return paramClass;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.p.d
 * JD-Core Version:    0.7.0.1
 */