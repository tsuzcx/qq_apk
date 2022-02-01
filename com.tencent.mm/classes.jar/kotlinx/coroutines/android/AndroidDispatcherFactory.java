package kotlinx.coroutines.android;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;
import kotlinx.coroutines.internal.MainDispatcherFactory;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/android/AndroidDispatcherFactory;", "Lkotlinx/coroutines/internal/MainDispatcherFactory;", "()V", "loadPriority", "", "getLoadPriority", "()I", "createDispatcher", "Lkotlinx/coroutines/android/HandlerContext;", "allFactories", "", "hintOnError", "", "kotlinx-coroutines-android"}, k=1, mv={1, 5, 1}, xi=48)
public final class AndroidDispatcherFactory
  implements MainDispatcherFactory
{
  public final a createDispatcher(List<? extends MainDispatcherFactory> paramList)
  {
    AppMethodBeat.i(188919);
    paramList = new a(c.n(Looper.getMainLooper()));
    AppMethodBeat.o(188919);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlinx.coroutines.android.AndroidDispatcherFactory
 * JD-Core Version:    0.7.0.1
 */