package kotlinx.coroutines.android;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.l;
import kotlinx.coroutines.internal.MainDispatcherFactory;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/coroutines/android/AndroidDispatcherFactory;", "Lkotlinx/coroutines/internal/MainDispatcherFactory;", "()V", "loadPriority", "", "getLoadPriority", "()I", "createDispatcher", "Lkotlinx/coroutines/android/HandlerContext;", "allFactories", "", "hintOnError", "", "kotlinx-coroutines-android"})
public final class AndroidDispatcherFactory
  implements MainDispatcherFactory
{
  public final a createDispatcher(List<? extends MainDispatcherFactory> paramList)
  {
    AppMethodBeat.i(187960);
    paramList = new a(c.k(Looper.getMainLooper()), "Main");
    AppMethodBeat.o(187960);
    return paramList;
  }
  
  public final int getLoadPriority()
  {
    return 1073741823;
  }
  
  public final String hintOnError()
  {
    return "For tests Dispatchers.setMain from kotlinx-coroutines-test module can be used";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.android.AndroidDispatcherFactory
 * JD-Core Version:    0.7.0.1
 */