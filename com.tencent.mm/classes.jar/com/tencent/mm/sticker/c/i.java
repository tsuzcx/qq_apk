package com.tencent.mm.sticker.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vending.e.a;
import com.tencent.mm.vending.e.b;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sticker/task/GetLensListTask;", "", "()V", "Companion", "plugin-sticker_release"})
public abstract class i
{
  public static final a Vce = new a((byte)0);
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sticker/task/GetLensListTask$Companion;", "", "()V", "GET_LENSLIST_REQ_DEFAULT", "", "GET_LENSLIST_REQ_RECOMMEND", "getLensList", "", "type", "pageBuff", "", "lensCtx", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "callback", "Lcom/tencent/mm/sticker/task/GetLensListCallback;", "plugin-sticker_release"})
  public static final class a
  {
    public static void a(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, b<a> paramb, h paramh)
    {
      AppMethodBeat.i(232563);
      if (MMApplicationContext.isMainProcess())
      {
        new j(paramInt, paramArrayOfByte1, paramArrayOfByte2, paramb, paramh);
        AppMethodBeat.o(232563);
        return;
      }
      new l(paramInt, paramArrayOfByte1, paramArrayOfByte2, paramb, paramh);
      AppMethodBeat.o(232563);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sticker.c.i
 * JD-Core Version:    0.7.0.1
 */