package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.id;
import com.tencent.mm.g.a.ul;
import com.tencent.mm.g.a.ul.b;
import com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.CountDownLatch;

final class l$a
  implements f, Runnable
{
  CountDownLatch countDownLatch;
  UnfamiliarContactDetailUI.h qFd;
  m qFe;
  long start;
  
  l$a(l paraml, UnfamiliarContactDetailUI.h paramh, CountDownLatch paramCountDownLatch)
  {
    this.qFd = paramh;
    this.countDownLatch = paramCountDownLatch;
  }
  
  static void cjR()
  {
    AppMethodBeat.i(126876);
    id localid = new id();
    localid.cxs.cut = 3;
    a.ymk.l(localid);
    AppMethodBeat.o(126876);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(126874);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ab.e("MicroMsg.UnfamiliarContactEngine", "[onSceneEnd] errType:%s errCode:%s errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      this.countDownLatch.countDown();
      AppMethodBeat.o(126874);
      return;
    }
    if (paramm.getType() == 292)
    {
      this.qFe = paramm;
      d.post(this, "load_unfamiliar_contact");
    }
    AppMethodBeat.o(126874);
  }
  
  public final void run()
  {
    AppMethodBeat.i(126875);
    Object localObject = new ul();
    ((ul)localObject).cKT.cKV = this.qFe;
    a.ymk.l((b)localObject);
    int j = ((ul)localObject).cKU.state;
    localObject = ((ul)localObject).cKU.cKW;
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
      ab.i("MicroMsg.UnfamiliarContactEngine", "[callback] state:%s,tagList is null?%s,tagList size:%s", new Object[] { Integer.valueOf(j), Boolean.valueOf(bool), Integer.valueOf(i) });
      if (j == 1) {
        break label177;
      }
      if (localObject != null) {
        this.qEX.qET.addAll((Collection)localObject);
      }
      ab.i("MicroMsg.UnfamiliarContactEngine", "[AsyncGetSnsTagInfo] %sms", new Object[] { Long.valueOf(System.currentTimeMillis() - this.start) });
      this.countDownLatch.countDown();
      AppMethodBeat.o(126875);
      return;
      bool = false;
      break;
    }
    label177:
    if (this.qFd != null) {
      al.d(new l.a.1(this));
    }
    this.qEX.eIo.o(new l.a.2(this), 30000L);
    AppMethodBeat.o(126875);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.l.a
 * JD-Core Version:    0.7.0.1
 */