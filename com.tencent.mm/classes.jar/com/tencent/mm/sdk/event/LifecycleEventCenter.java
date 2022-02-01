package com.tencent.mm.sdk.event;

import androidx.lifecycle.aa;
import androidx.lifecycle.x;
import androidx.lifecycle.y;
import androidx.lifecycle.y.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sdk/event/LifecycleEventCenter;", "", "()V", "Companion", "wechat-sdk_release"})
public final class LifecycleEventCenter
{
  public static final Companion Companion;
  public static final String TAG = "MicroMsg.Mvvm.LifecycleEventCenter";
  public static final String THREAD_TAG = "Mvvm.EventCenterObserver";
  private static final aa store;
  
  static
  {
    AppMethodBeat.i(192091);
    Companion = new Companion(null);
    store = new aa();
    AppMethodBeat.o(192091);
  }
  
  public static <T extends x> T getEvent(Class<T> paramClass)
  {
    AppMethodBeat.i(192096);
    paramClass = Companion.getEvent(paramClass);
    AppMethodBeat.o(192096);
    return paramClass;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sdk/event/LifecycleEventCenter$Companion;", "", "()V", "TAG", "", "THREAD_TAG", "store", "Landroidx/lifecycle/ViewModelStore;", "getEvent", "T", "Landroidx/lifecycle/ViewModel;", "eventClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "wechat-sdk_release"})
  public static final class Companion
  {
    public final <T extends x> T getEvent(Class<T> paramClass)
    {
      AppMethodBeat.i(189329);
      p.k(paramClass, "eventClass");
      paramClass = new y(LifecycleEventCenter.access$getStore$cp(), (y.b)new y.b()
      {
        public final <T extends x> T create(Class<T> paramAnonymousClass)
        {
          AppMethodBeat.i(194396);
          p.k(paramAnonymousClass, "eventClass");
          paramAnonymousClass = (x)paramAnonymousClass.newInstance();
          AppMethodBeat.o(194396);
          return paramAnonymousClass;
        }
      }).i(paramClass);
      AppMethodBeat.o(189329);
      return paramClass;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sdk.event.LifecycleEventCenter
 * JD-Core Version:    0.7.0.1
 */