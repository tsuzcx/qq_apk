package kotlinx.coroutines.internal;

import java.util.List;
import kotlin.Metadata;
import kotlinx.coroutines.cm;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/internal/MainDispatcherFactory;", "", "loadPriority", "", "getLoadPriority", "()I", "createDispatcher", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "allFactories", "", "hintOnError", "", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface MainDispatcherFactory
{
  public abstract cm createDispatcher(List<? extends MainDispatcherFactory> paramList);
  
  public abstract int getLoadPriority();
  
  public abstract String hintOnError();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlinx.coroutines.internal.MainDispatcherFactory
 * JD-Core Version:    0.7.0.1
 */