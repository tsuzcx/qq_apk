package com.tencent.mm.sticker.c;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vending.e.a;
import com.tencent.mm.vending.e.b;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/sticker/task/GetLensListTaskProcess;", "Lcom/tencent/mm/sticker/task/GetLensListTask;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "type", "", "pageBuff", "", "lensCtx", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "callback", "Lcom/tencent/mm/sticker/task/GetLensListCallback;", "(I[B[BLcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;Lcom/tencent/mm/sticker/task/GetLensListCallback;)V", "getCallback", "()Lcom/tencent/mm/sticker/task/GetLensListCallback;", "setCallback", "(Lcom/tencent/mm/sticker/task/GetLensListCallback;)V", "dead", "", "plugin-sticker_release"})
public final class l
  extends i
  implements a
{
  h NOB;
  
  public l(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, b<a> paramb, h paramh)
  {
    AppMethodBeat.i(105993);
    this.NOB = paramh;
    if (paramb != null) {
      paramb.keep((a)this);
    }
    paramb = new Bundle();
    paramb.putInt(k.gzq(), paramInt);
    paramb.putByteArray(k.gzr(), paramArrayOfByte1);
    paramb.putByteArray(k.gzs(), paramArrayOfByte2);
    com.tencent.mm.ipcinvoker.h.a(MMApplicationContext.getPackageName(), (Parcelable)paramb, n.class, (d)new d() {});
    AppMethodBeat.o(105993);
  }
  
  public final void dead()
  {
    this.NOB = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sticker.c.l
 * JD-Core Version:    0.7.0.1
 */