package com.tencent.mm.sticker.c;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.protocal.protobuf.cmf;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sticker/task/IPCGetLensList;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Landroid/os/Bundle;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-sticker_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n
  implements d<Bundle, Bundle>
{
  @Metadata(d1={""}, d2={"com/tencent/mm/sticker/task/IPCGetLensList$invoke$1", "Lcom/tencent/mm/sticker/task/GetLensListCallback;", "onResult", "", "errType", "", "errCode", "response", "Lcom/tencent/mm/protocal/protobuf/GetLensListResponse;", "plugin-sticker_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements h
  {
    a(f<Bundle> paramf) {}
    
    public final void a(int paramInt1, int paramInt2, cmf paramcmf)
    {
      AppMethodBeat.i(105996);
      Bundle localBundle = new Bundle();
      localBundle.putInt(k.iWO(), paramInt1);
      localBundle.putInt(k.iWT(), paramInt2);
      if (paramcmf != null)
      {
        paramcmf = paramcmf.toByteArray();
        if (paramcmf != null) {
          localBundle.putByteArray(k.iWU(), paramcmf);
        }
      }
      paramcmf = this.mht;
      if (paramcmf != null) {
        paramcmf.onCallback(localBundle);
      }
      AppMethodBeat.o(105996);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.sticker.c.n
 * JD-Core Version:    0.7.0.1
 */