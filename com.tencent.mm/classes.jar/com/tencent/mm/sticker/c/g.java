package com.tencent.mm.sticker.c;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.protocal.protobuf.bpl;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.vending.e.a;
import com.tencent.mm.vending.e.b;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/sticker/task/GetLensInfoTaskProcess;", "Lcom/tencent/mm/sticker/task/GetLensInfoTask;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "lensId", "", "callback", "Lcom/tencent/mm/sticker/task/GetLensInfoCallback;", "(Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;Ljava/lang/String;Lcom/tencent/mm/sticker/task/GetLensInfoCallback;)V", "getCallback", "()Lcom/tencent/mm/sticker/task/GetLensInfoCallback;", "setCallback", "(Lcom/tencent/mm/sticker/task/GetLensInfoCallback;)V", "dead", "", "plugin-sticker_release"})
public final class g
  extends d
  implements a
{
  c GBs;
  
  public g(b<a> paramb, final String paramString, c paramc)
  {
    super(paramString);
    AppMethodBeat.i(105989);
    this.GBs = paramc;
    if (paramb != null) {
      paramb.keep((a)this);
    }
    paramb = new Bundle();
    paramb.putString(f.eYJ(), paramString);
    h.a(ai.getPackageName(), (Parcelable)paramb, m.class, (com.tencent.mm.ipcinvoker.d)new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(105989);
  }
  
  public final void dead()
  {
    AppMethodBeat.i(105988);
    ac.i(f.abZ(), "dead: ");
    this.GBs = null;
    AppMethodBeat.o(105988);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sticker.c.g
 * JD-Core Version:    0.7.0.1
 */