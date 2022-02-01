package kotlinx.coroutines.android;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import java.util.List;
import kotlinx.coroutines.internal.MainDispatcherFactory;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/coroutines/android/AndroidDispatcherFactory;", "Lkotlinx/coroutines/internal/MainDispatcherFactory;", "()V", "loadPriority", "", "getLoadPriority", "()I", "createDispatcher", "Lkotlinx/coroutines/android/HandlerContext;", "allFactories", "", "hintOnError", "", "kotlinx-coroutines-android"})
public final class AndroidDispatcherFactory
  implements MainDispatcherFactory
{
  public final a createDispatcher(List<? extends MainDispatcherFactory> paramList)
  {
    AppMethodBeat.i(186990);
    paramList = new a(c.q(Looper.getMainLooper()), "Main");
    AppMethodBeat.o(186990);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.android.AndroidDispatcherFactory
 * JD-Core Version:    0.7.0.1
 */