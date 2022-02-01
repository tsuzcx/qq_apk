package com.tencent.mm.sticker.c;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.protocal.protobuf.dhp;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sticker/task/IPCGetLensInfo;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Landroid/os/Bundle;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-sticker_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
  implements d<Bundle, Bundle>
{
  @Metadata(d1={""}, d2={"com/tencent/mm/sticker/task/IPCGetLensInfo$invoke$1", "Lcom/tencent/mm/sticker/task/GetLensInfoCallback;", "onResult", "", "errType", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-sticker_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements c
  {
    a(com.tencent.mm.ipcinvoker.f<Bundle> paramf) {}
    
    public final void a(int paramInt, dhp paramdhp)
    {
      AppMethodBeat.i(105994);
      Bundle localBundle = new Bundle();
      localBundle.putInt(f.iWO(), paramInt);
      if (paramdhp == null)
      {
        paramdhp = this.mht;
        if (paramdhp != null)
        {
          paramdhp.onCallback(localBundle);
          AppMethodBeat.o(105994);
        }
      }
      else
      {
        localBundle.putByteArray(f.iWP(), paramdhp.toByteArray());
        paramdhp = this.mht;
        if (paramdhp != null) {
          paramdhp.onCallback(localBundle);
        }
      }
      AppMethodBeat.o(105994);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sticker.c.m
 * JD-Core Version:    0.7.0.1
 */