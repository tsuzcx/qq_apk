package com.tencent.mm.sticker.c;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.protocal.protobuf.dhp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vending.e.a;
import com.tencent.mm.vending.e.b;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sticker/task/GetLensInfoTaskProcess;", "Lcom/tencent/mm/sticker/task/GetLensInfoTask;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "lensId", "", "callback", "Lcom/tencent/mm/sticker/task/GetLensInfoCallback;", "(Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;Ljava/lang/String;Lcom/tencent/mm/sticker/task/GetLensInfoCallback;)V", "getCallback", "()Lcom/tencent/mm/sticker/task/GetLensInfoCallback;", "setCallback", "(Lcom/tencent/mm/sticker/task/GetLensInfoCallback;)V", "dead", "", "plugin-sticker_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends d
  implements a
{
  private c acDq;
  
  public g(b<a> paramb, String paramString, c paramc)
  {
    super(paramString);
    AppMethodBeat.i(105989);
    this.acDq = paramc;
    if (paramb != null) {
      paramb.keep((a)this);
    }
    paramb = new Bundle();
    paramb.putString(f.iWN(), paramString);
    j.a(MMApplicationContext.getPackageName(), (Parcelable)paramb, m.class, new g..ExternalSyntheticLambda0(paramString, this));
    AppMethodBeat.o(105989);
  }
  
  private static final void a(Bundle paramBundle, String paramString, g paramg)
  {
    AppMethodBeat.i(233895);
    s.u(paramString, "$lensId");
    s.u(paramg, "this$0");
    int i;
    if (paramBundle == null)
    {
      i = 0;
      Log.i(f.aUw(), "IPCInvoker: " + paramString + ", " + i);
      if (paramBundle != null) {
        break label98;
      }
    }
    label98:
    for (paramBundle = null;; paramBundle = paramBundle.getByteArray(f.iWP()))
    {
      if (paramBundle != null) {
        break label109;
      }
      paramBundle = paramg.acDq;
      if (paramBundle == null) {
        break label140;
      }
      paramBundle.a(i, null);
      AppMethodBeat.o(233895);
      return;
      i = paramBundle.getInt(f.iWO());
      break;
    }
    label109:
    paramString = new dhp();
    paramString.parseFrom(paramBundle);
    paramBundle = paramg.acDq;
    if (paramBundle != null) {
      paramBundle.a(i, paramString);
    }
    label140:
    AppMethodBeat.o(233895);
  }
  
  private static final void a(String paramString, g paramg, Bundle paramBundle)
  {
    AppMethodBeat.i(233897);
    s.u(paramString, "$lensId");
    s.u(paramg, "this$0");
    h.ahAA.bm(new g..ExternalSyntheticLambda1(paramBundle, paramString, paramg));
    AppMethodBeat.o(233897);
  }
  
  public final void dead()
  {
    AppMethodBeat.i(105988);
    Log.i(f.aUw(), "dead: ");
    this.acDq = null;
    AppMethodBeat.o(105988);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sticker.c.g
 * JD-Core Version:    0.7.0.1
 */