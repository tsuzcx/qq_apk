package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.ke;
import com.tencent.mm.g.a.yt;
import com.tencent.mm.g.a.yt.b;
import com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.e;
import com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.CountDownLatch;

final class o$a
  implements com.tencent.f.i.h, com.tencent.mm.ak.i
{
  UnfamiliarContactDetailUI.h CYm;
  q CYn;
  CountDownLatch rDn;
  long start;
  
  o$a(o paramo, UnfamiliarContactDetailUI.h paramh, CountDownLatch paramCountDownLatch)
  {
    this.CYm = paramh;
    this.rDn = paramCountDownLatch;
  }
  
  static void eSH()
  {
    AppMethodBeat.i(73798);
    ke localke = new ke();
    localke.dPe.dKy = 3;
    EventCenter.instance.publish(localke);
    AppMethodBeat.o(73798);
  }
  
  public final String getKey()
  {
    return "load_unfamiliar_contact";
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(73796);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Log.e("MicroMsg.UnfamiliarContactEngine", "[onSceneEnd] errType:%s errCode:%s errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      this.rDn.countDown();
      AppMethodBeat.o(73796);
      return;
    }
    if (paramq.getType() == 292)
    {
      this.CYn = paramq;
      com.tencent.f.h.RTc.aX(this);
    }
    AppMethodBeat.o(73796);
  }
  
  public final void run()
  {
    AppMethodBeat.i(73797);
    Object localObject = new yt();
    ((yt)localObject).eeX.eeZ = this.CYn;
    EventCenter.instance.publish((IEvent)localObject);
    int j = ((yt)localObject).eeY.state;
    localObject = ((yt)localObject).eeY.efa;
    boolean bool;
    if (localObject == null)
    {
      bool = true;
      if (localObject != null) {
        break label166;
      }
    }
    label166:
    for (int i = 0;; i = ((List)localObject).size())
    {
      Log.i("MicroMsg.UnfamiliarContactEngine", "[callback] state:%s,tagList is null?%s,tagList size:%s", new Object[] { Integer.valueOf(j), Boolean.valueOf(bool), Integer.valueOf(i) });
      if (j == 1) {
        break label177;
      }
      if (localObject != null) {
        this.CYh.CYc.addAll((Collection)localObject);
      }
      Log.i("MicroMsg.UnfamiliarContactEngine", "[AsyncGetSnsTagInfo] %sms", new Object[] { Long.valueOf(System.currentTimeMillis() - this.start) });
      this.rDn.countDown();
      AppMethodBeat.o(73797);
      return;
      bool = false;
      break;
    }
    label177:
    if (this.CYm != null) {
      this.CYh.qmq.postUI(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(73794);
          o.a.this.CYm.a(UnfamiliarContactDetailUI.e.DfA);
          AppMethodBeat.o(73794);
        }
      });
    }
    this.CYh.qmq.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(73795);
        o.a.eSH();
        AppMethodBeat.o(73795);
      }
    }, 30000L);
    AppMethodBeat.o(73797);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.o.a
 * JD-Core Version:    0.7.0.1
 */