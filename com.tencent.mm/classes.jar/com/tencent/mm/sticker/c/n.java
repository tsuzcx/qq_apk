package com.tencent.mm.sticker.c;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.protocal.protobuf.bde;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/sticker/task/IPCGetLensList;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Landroid/os/Bundle;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-sticker_release"})
public final class n
  implements b<Bundle, Bundle>
{
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/sticker/task/IPCGetLensList$invoke$1", "Lcom/tencent/mm/sticker/task/GetLensListCallback;", "onResult", "", "errType", "", "errCode", "response", "Lcom/tencent/mm/protocal/protobuf/GetLensListResponse;", "plugin-sticker_release"})
  public static final class a
    implements h
  {
    a(d paramd) {}
    
    public final void a(int paramInt1, int paramInt2, bde parambde)
    {
      AppMethodBeat.i(105996);
      Bundle localBundle = new Bundle();
      localBundle.putInt(k.fou(), paramInt1);
      localBundle.putInt(k.foz(), paramInt2);
      if (parambde != null)
      {
        parambde = parambde.toByteArray();
        if (parambde != null) {
          localBundle.putByteArray(k.foA(), parambde);
        }
      }
      parambde = this.jDK;
      if (parambde != null)
      {
        parambde.be(localBundle);
        AppMethodBeat.o(105996);
        return;
      }
      AppMethodBeat.o(105996);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sticker.c.n
 * JD-Core Version:    0.7.0.1
 */