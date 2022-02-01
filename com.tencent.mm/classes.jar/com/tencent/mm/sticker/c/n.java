package com.tencent.mm.sticker.c;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.protocal.protobuf.bxc;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sticker/task/IPCGetLensList;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Landroid/os/Bundle;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-sticker_release"})
public final class n
  implements d<Bundle, Bundle>
{
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/sticker/task/IPCGetLensList$invoke$1", "Lcom/tencent/mm/sticker/task/GetLensListCallback;", "onResult", "", "errType", "", "errCode", "response", "Lcom/tencent/mm/protocal/protobuf/GetLensListResponse;", "plugin-sticker_release"})
  public static final class a
    implements h
  {
    a(f paramf) {}
    
    public final void a(int paramInt1, int paramInt2, bxc parambxc)
    {
      AppMethodBeat.i(105996);
      Bundle localBundle = new Bundle();
      localBundle.putInt(k.hvo(), paramInt1);
      localBundle.putInt(k.hvt(), paramInt2);
      if (parambxc != null)
      {
        parambxc = parambxc.toByteArray();
        if (parambxc != null) {
          localBundle.putByteArray(k.hvu(), parambxc);
        }
      }
      parambxc = this.nyL;
      if (parambxc != null)
      {
        parambxc.aH(localBundle);
        AppMethodBeat.o(105996);
        return;
      }
      AppMethodBeat.o(105996);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sticker.c.n
 * JD-Core Version:    0.7.0.1
 */