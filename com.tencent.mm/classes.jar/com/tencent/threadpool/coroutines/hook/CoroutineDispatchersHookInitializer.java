package com.tencent.threadpool.coroutines.hook;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.threadpool.coroutines.b;
import com.tencent.threadpool.coroutines.f;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlinx.coroutines.al;
import kotlinx.coroutines.bg;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/threadpool/coroutines/hook/CoroutineDispatchersHookInitializer;", "", "()V", "setup", "", "threadpool-coroutines_release"}, k=1, mv={1, 1, 16})
public final class CoroutineDispatchersHookInitializer
{
  public static final CoroutineDispatchersHookInitializer INSTANCE;
  
  static
  {
    AppMethodBeat.i(226879);
    INSTANCE = new CoroutineDispatchersHookInitializer();
    AppMethodBeat.o(226879);
  }
  
  public static final void setup()
  {
    AppMethodBeat.i(226874);
    synchronized (bg.ajvV)
    {
      if (b.ahAL == null)
      {
        localObject1 = bg.kCi();
        if ((s.p(localObject1, f.jYY()) ^ true)) {
          b.ahAL = (al)localObject1;
        }
      }
      Object localObject1 = a.jYZ();
      if (localObject1 != null) {
        ((Field)localObject1).set(null, f.jYX());
      }
      localObject1 = a.jZa();
      if (localObject1 != null)
      {
        ((Field)localObject1).set(null, f.jYY());
        localObject1 = ah.aiuX;
      }
      AppMethodBeat.o(226874);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.threadpool.coroutines.hook.CoroutineDispatchersHookInitializer
 * JD-Core Version:    0.7.0.1
 */