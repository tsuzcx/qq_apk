package com.tencent.mm.sticker.c;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.vending.e.a;
import com.tencent.mm.vending.e.b;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/sticker/task/GetLensListTaskProcess;", "Lcom/tencent/mm/sticker/task/GetLensListTask;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "type", "", "pageBuff", "", "lensCtx", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "callback", "Lcom/tencent/mm/sticker/task/GetLensListCallback;", "(I[B[BLcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;Lcom/tencent/mm/sticker/task/GetLensListCallback;)V", "getCallback", "()Lcom/tencent/mm/sticker/task/GetLensListCallback;", "setCallback", "(Lcom/tencent/mm/sticker/task/GetLensListCallback;)V", "dead", "", "plugin-sticker_release"})
public final class l
  extends i
  implements a
{
  h Inw;
  
  public l(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, b<a> paramb, h paramh)
  {
    AppMethodBeat.i(105993);
    this.Inw = paramh;
    if (paramb != null) {
      paramb.keep((a)this);
    }
    paramb = new Bundle();
    paramb.putInt(k.fow(), paramInt);
    paramb.putByteArray(k.fox(), paramArrayOfByte1);
    paramb.putByteArray(k.foy(), paramArrayOfByte2);
    com.tencent.mm.ipcinvoker.h.a(aj.getPackageName(), (Parcelable)paramb, n.class, (d)new d() {});
    AppMethodBeat.o(105993);
  }
  
  public final void dead()
  {
    this.Inw = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sticker.c.l
 * JD-Core Version:    0.7.0.1
 */