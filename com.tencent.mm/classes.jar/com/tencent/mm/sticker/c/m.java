package com.tencent.mm.sticker.c;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.protocal.protobuf.chz;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/sticker/task/IPCGetLensInfo;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Landroid/os/Bundle;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-sticker_release"})
public final class m
  implements b<Bundle, Bundle>
{
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/sticker/task/IPCGetLensInfo$invoke$1", "Lcom/tencent/mm/sticker/task/GetLensInfoCallback;", "onResult", "", "errType", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-sticker_release"})
  public static final class a
    implements c
  {
    a(d paramd) {}
    
    public final void a(int paramInt, chz paramchz)
    {
      AppMethodBeat.i(105994);
      Bundle localBundle = new Bundle();
      localBundle.putInt(f.gzo(), paramInt);
      if (paramchz == null)
      {
        paramchz = this.kFf;
        if (paramchz != null)
        {
          paramchz.bn(localBundle);
          AppMethodBeat.o(105994);
          return;
        }
        AppMethodBeat.o(105994);
        return;
      }
      localBundle.putByteArray(f.gzp(), paramchz.toByteArray());
      paramchz = this.kFf;
      if (paramchz != null)
      {
        paramchz.bn(localBundle);
        AppMethodBeat.o(105994);
        return;
      }
      AppMethodBeat.o(105994);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sticker.c.m
 * JD-Core Version:    0.7.0.1
 */