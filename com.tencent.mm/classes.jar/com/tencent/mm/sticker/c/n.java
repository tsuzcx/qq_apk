package com.tencent.mm.sticker.c;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.protocal.protobuf.avu;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/sticker/task/IPCGetLensList;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Landroid/os/Bundle;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-sticker_release"})
public final class n
  implements b<Bundle, Bundle>
{
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/sticker/task/IPCGetLensList$invoke$1", "Lcom/tencent/mm/sticker/task/GetLensListCallback;", "onResult", "", "errType", "", "errCode", "response", "Lcom/tencent/mm/protocal/protobuf/GetLensListResponse;", "plugin-sticker_release"})
  public static final class a
    implements h
  {
    a(d paramd) {}
    
    public final void a(int paramInt1, int paramInt2, avu paramavu)
    {
      AppMethodBeat.i(105996);
      Bundle localBundle = new Bundle();
      localBundle.putInt(k.eJp(), paramInt1);
      localBundle.putInt(k.eJu(), paramInt2);
      if (paramavu != null)
      {
        paramavu = paramavu.toByteArray();
        if (paramavu != null) {
          localBundle.putByteArray(k.eJv(), paramavu);
        }
      }
      paramavu = this.iJO;
      if (paramavu != null)
      {
        paramavu.bf(localBundle);
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