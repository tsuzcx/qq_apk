package com.tencent.mm.sticker.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.vending.e.a;
import com.tencent.mm.vending.e.b;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/sticker/task/GetLensListTask;", "", "()V", "Companion", "plugin-sticker_release"})
public abstract class i
{
  public static final a Inq = new a((byte)0);
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/sticker/task/GetLensListTask$Companion;", "", "()V", "GET_LENSLIST_REQ_DEFAULT", "", "GET_LENSLIST_REQ_RECOMMEND", "getLensList", "", "type", "pageBuff", "", "lensCtx", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "callback", "Lcom/tencent/mm/sticker/task/GetLensListCallback;", "plugin-sticker_release"})
  public static final class a
  {
    public static void a(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, b<a> paramb, h paramh)
    {
      AppMethodBeat.i(215386);
      if (aj.cmR())
      {
        new j(paramInt, paramArrayOfByte1, paramArrayOfByte2, paramb, paramh);
        AppMethodBeat.o(215386);
        return;
      }
      new l(paramInt, paramArrayOfByte1, paramArrayOfByte2, paramb, paramh);
      AppMethodBeat.o(215386);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sticker.c.i
 * JD-Core Version:    0.7.0.1
 */