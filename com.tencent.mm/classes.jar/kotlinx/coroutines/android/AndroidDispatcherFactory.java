package kotlinx.coroutines.android;

import a.l;
import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlinx.coroutines.bj;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlinx/coroutines/android/AndroidDispatcherFactory;", "Lkotlinx/coroutines/internal/MainDispatcherFactory;", "()V", "loadPriority", "", "getLoadPriority", "()I", "createDispatcher", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "Companion", "kotlinx-coroutines-android"})
@Keep
public final class AndroidDispatcherFactory
{
  public static final AndroidDispatcherFactory.a Companion;
  
  static
  {
    AppMethodBeat.i(118247);
    Companion = new AndroidDispatcherFactory.a((byte)0);
    AppMethodBeat.o(118247);
  }
  
  public static final bj getDispatcher()
  {
    return (bj)d.CIQ;
  }
  
  public final bj createDispatcher()
  {
    return (bj)d.CIQ;
  }
  
  public final int getLoadPriority()
  {
    return 2147483647;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.android.AndroidDispatcherFactory
 * JD-Core Version:    0.7.0.1
 */