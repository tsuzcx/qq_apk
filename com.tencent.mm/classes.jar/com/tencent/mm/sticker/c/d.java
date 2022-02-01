package com.tencent.mm.sticker.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vending.e.a;
import com.tencent.mm.vending.e.b;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sticker/task/GetLensInfoTask;", "", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "lensId", "", "callback", "Lcom/tencent/mm/sticker/task/GetLensInfoCallback;", "(Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;Ljava/lang/String;Lcom/tencent/mm/sticker/task/GetLensInfoCallback;)V", "Companion", "plugin-sticker_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class d
{
  public static final a acDm = new a((byte)0);
  
  public d(String paramString) {}
  
  public static final void a(b<a> paramb, String paramString, c paramc)
  {
    a.a(paramb, paramString, paramc);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/sticker/task/GetLensInfoTask$Companion;", "", "()V", "ERR_INVALID", "", "ERR_NETWORK", "ERR_OK", "getLensInfo", "", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "lensId", "", "callback", "Lcom/tencent/mm/sticker/task/GetLensInfoCallback;", "plugin-sticker_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static void a(b<a> paramb, String paramString, c paramc)
    {
      AppMethodBeat.i(105983);
      s.u(paramString, "lensId");
      if (MMApplicationContext.isMainProcess())
      {
        new e(paramb, paramString, paramc);
        AppMethodBeat.o(105983);
        return;
      }
      new g(paramb, paramString, paramc);
      AppMethodBeat.o(105983);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sticker.c.d
 * JD-Core Version:    0.7.0.1
 */