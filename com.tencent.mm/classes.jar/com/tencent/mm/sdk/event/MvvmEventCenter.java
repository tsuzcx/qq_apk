package com.tencent.mm.sdk.event;

import androidx.lifecycle.af;
import androidx.lifecycle.ah;
import androidx.lifecycle.ah.b;
import androidx.lifecycle.aj;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/event/MvvmEventCenter;", "", "()V", "Companion", "wechat-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MvvmEventCenter
{
  public static final Companion Companion;
  public static final String TAG = "MicroMsg.Mvvm.MvvmEventCenter";
  public static final String THREAD_TAG = "Mvvm.MvvmEventCenter";
  private static final aj store;
  
  static
  {
    AppMethodBeat.i(243254);
    Companion = new Companion(null);
    store = new aj();
    AppMethodBeat.o(243254);
  }
  
  public static final <T extends af> T getEvent(Class<T> paramClass)
  {
    AppMethodBeat.i(243246);
    paramClass = Companion.getEvent(paramClass);
    AppMethodBeat.o(243246);
    return paramClass;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/event/MvvmEventCenter$Companion;", "", "()V", "TAG", "", "THREAD_TAG", "store", "Landroidx/lifecycle/ViewModelStore;", "getEvent", "T", "Landroidx/lifecycle/ViewModel;", "()Landroidx/lifecycle/ViewModel;", "eventClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "wechat-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class Companion
  {
    public final <T extends af> T getEvent(Class<T> paramClass)
    {
      AppMethodBeat.i(243260);
      s.u(paramClass, "eventClass");
      paramClass = new ah(MvvmEventCenter.access$getStore$cp(), (ah.b)new ah.b()
      {
        public final <T extends af> T create(Class<T> paramAnonymousClass)
        {
          AppMethodBeat.i(243257);
          s.u(paramAnonymousClass, "eventClass");
          paramAnonymousClass = (af)paramAnonymousClass.newInstance();
          AppMethodBeat.o(243257);
          return paramAnonymousClass;
        }
      }).q(paramClass);
      s.s(paramClass, "ViewModelProvider(store,…       }).get(eventClass)");
      AppMethodBeat.o(243260);
      return paramClass;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.event.MvvmEventCenter
 * JD-Core Version:    0.7.0.1
 */