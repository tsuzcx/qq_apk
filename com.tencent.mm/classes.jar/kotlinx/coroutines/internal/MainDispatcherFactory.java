package kotlinx.coroutines.internal;

import java.util.List;
import kotlin.l;
import kotlinx.coroutines.ce;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/coroutines/internal/MainDispatcherFactory;", "", "loadPriority", "", "getLoadPriority", "()I", "createDispatcher", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "allFactories", "", "hintOnError", "", "kotlinx-coroutines-core"})
public abstract interface MainDispatcherFactory
{
  public abstract ce createDispatcher(List<? extends MainDispatcherFactory> paramList);
  
  public abstract int getLoadPriority();
  
  public abstract String hintOnError();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.internal.MainDispatcherFactory
 * JD-Core Version:    0.7.0.1
 */