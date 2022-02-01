package com.tencent.mm.sticker.c;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.protocal.protobuf.bdu;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/sticker/task/IPCGetLensList;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Landroid/os/Bundle;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-sticker_release"})
public final class n
  implements b<Bundle, Bundle>
{
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/sticker/task/IPCGetLensList$invoke$1", "Lcom/tencent/mm/sticker/task/GetLensListCallback;", "onResult", "", "errType", "", "errCode", "response", "Lcom/tencent/mm/protocal/protobuf/GetLensListResponse;", "plugin-sticker_release"})
  public static final class a
    implements h
  {
    a(d paramd) {}
    
    public final void a(int paramInt1, int paramInt2, bdu parambdu)
    {
      AppMethodBeat.i(105996);
      Bundle localBundle = new Bundle();
      localBundle.putInt(k.fsn(), paramInt1);
      localBundle.putInt(k.fss(), paramInt2);
      if (parambdu != null)
      {
        parambdu = parambdu.toByteArray();
        if (parambdu != null) {
          localBundle.putByteArray(k.fst(), parambdu);
        }
      }
      parambdu = this.jGI;
      if (parambdu != null)
      {
        parambdu.be(localBundle);
        AppMethodBeat.o(105996);
        return;
      }
      AppMethodBeat.o(105996);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sticker.c.n
 * JD-Core Version:    0.7.0.1
 */