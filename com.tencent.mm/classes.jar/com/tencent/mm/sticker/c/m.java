package com.tencent.mm.sticker.c;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.protocal.protobuf.cqv;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sticker/task/IPCGetLensInfo;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Landroid/os/Bundle;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-sticker_release"})
public final class m
  implements d<Bundle, Bundle>
{
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/sticker/task/IPCGetLensInfo$invoke$1", "Lcom/tencent/mm/sticker/task/GetLensInfoCallback;", "onResult", "", "errType", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-sticker_release"})
  public static final class a
    implements c
  {
    a(com.tencent.mm.ipcinvoker.f paramf) {}
    
    public final void a(int paramInt, cqv paramcqv)
    {
      AppMethodBeat.i(105994);
      Bundle localBundle = new Bundle();
      localBundle.putInt(f.hvo(), paramInt);
      if (paramcqv == null)
      {
        paramcqv = this.nyL;
        if (paramcqv != null)
        {
          paramcqv.aH(localBundle);
          AppMethodBeat.o(105994);
          return;
        }
        AppMethodBeat.o(105994);
        return;
      }
      localBundle.putByteArray(f.hvp(), paramcqv.toByteArray());
      paramcqv = this.nyL;
      if (paramcqv != null)
      {
        paramcqv.aH(localBundle);
        AppMethodBeat.o(105994);
        return;
      }
      AppMethodBeat.o(105994);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sticker.c.m
 * JD-Core Version:    0.7.0.1
 */