package kotlinx.coroutines.internal;

import d.l;
import java.util.List;
import kotlinx.coroutines.bz;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/coroutines/internal/MainDispatcherFactory;", "", "loadPriority", "", "getLoadPriority", "()I", "createDispatcher", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "allFactories", "", "hintOnError", "", "kotlinx-coroutines-core"})
public abstract interface MainDispatcherFactory
{
  public abstract bz createDispatcher(List<? extends MainDispatcherFactory> paramList);
  
  public abstract int getLoadPriority();
  
  public abstract String hintOnError();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.internal.MainDispatcherFactory
 * JD-Core Version:    0.7.0.1
 */