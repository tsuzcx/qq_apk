package com.tencent.mm.sticker.c;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vending.e.a;
import com.tencent.mm.vending.e.b;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sticker/task/GetLensListTaskProcess;", "Lcom/tencent/mm/sticker/task/GetLensListTask;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "type", "", "pageBuff", "", "lensCtx", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "callback", "Lcom/tencent/mm/sticker/task/GetLensListCallback;", "(I[B[BLcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;Lcom/tencent/mm/sticker/task/GetLensListCallback;)V", "getCallback", "()Lcom/tencent/mm/sticker/task/GetLensListCallback;", "setCallback", "(Lcom/tencent/mm/sticker/task/GetLensListCallback;)V", "dead", "", "plugin-sticker_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  extends i
  implements a
{
  private h acDw;
  
  public l(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, b<a> paramb, h paramh)
  {
    AppMethodBeat.i(105993);
    this.acDw = paramh;
    if (paramb != null) {
      paramb.keep((a)this);
    }
    paramb = new Bundle();
    paramb.putInt(k.iWQ(), paramInt);
    paramb.putByteArray(k.iWR(), paramArrayOfByte1);
    paramb.putByteArray(k.iWS(), paramArrayOfByte2);
    j.a(MMApplicationContext.getPackageName(), (Parcelable)paramb, n.class, new l..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(105993);
  }
  
  private static final void a(l paraml, Bundle paramBundle)
  {
    AppMethodBeat.i(233904);
    s.u(paraml, "this$0");
    int i = paramBundle.getInt(k.iWO());
    int j = paramBundle.getInt(k.iWT());
    cmf localcmf = new cmf();
    paramBundle = paramBundle.getByteArray(k.iWU());
    if (paramBundle != null) {
      localcmf.parseFrom(paramBundle);
    }
    Log.i(k.aUw(), "ipc callback: " + i + ' ' + j);
    paraml = paraml.acDw;
    if (paraml != null) {
      paraml.a(i, j, localcmf);
    }
    AppMethodBeat.o(233904);
  }
  
  public final void dead()
  {
    this.acDw = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.sticker.c.l
 * JD-Core Version:    0.7.0.1
 */