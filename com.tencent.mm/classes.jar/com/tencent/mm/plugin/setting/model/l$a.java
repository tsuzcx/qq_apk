package com.tencent.mm.plugin.setting.model;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.h.a.hz;
import com.tencent.mm.h.a.ss;
import com.tencent.mm.h.a.ss.b;
import com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.CountDownLatch;

final class l$a
  implements f, Runnable
{
  CountDownLatch countDownLatch;
  UnfamiliarContactDetailUI.h nRg;
  m nRh;
  long start;
  
  l$a(l paraml, UnfamiliarContactDetailUI.h paramh, CountDownLatch paramCountDownLatch)
  {
    this.nRg = paramh;
    this.countDownLatch = paramCountDownLatch;
  }
  
  static void byH()
  {
    hz localhz = new hz();
    localhz.bPZ.bNb = 3;
    a.udP.m(localhz);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      y.e("MicroMsg.UnfamiliarContactEngine", "[onSceneEnd] errType:%s errCode:%s errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      this.countDownLatch.countDown();
    }
    while (paramm.getType() != 292) {
      return;
    }
    this.nRh = paramm;
    e.post(this, "load_unfamiliar_contact");
  }
  
  public final void run()
  {
    Object localObject = new ss();
    ((ss)localObject).ccj.ccl = this.nRh;
    a.udP.m((b)localObject);
    int j = ((ss)localObject).cck.state;
    localObject = ((ss)localObject).cck.ccm;
    boolean bool;
    if (localObject == null)
    {
      bool = true;
      if (localObject != null) {
        break label156;
      }
    }
    label156:
    for (int i = 0;; i = ((List)localObject).size())
    {
      y.i("MicroMsg.UnfamiliarContactEngine", "[callback] state:%s,tagList is null?%s,tagList size:%s", new Object[] { Integer.valueOf(j), Boolean.valueOf(bool), Integer.valueOf(i) });
      if (j == 1) {
        break label167;
      }
      if (localObject != null) {
        this.nRa.nQW.addAll((Collection)localObject);
      }
      y.i("MicroMsg.UnfamiliarContactEngine", "[AsyncGetSnsTagInfo] %sms", new Object[] { Long.valueOf(System.currentTimeMillis() - this.start) });
      this.countDownLatch.countDown();
      return;
      bool = false;
      break;
    }
    label167:
    if (this.nRg != null) {
      ai.d(new l.a.1(this));
    }
    this.nRa.dKQ.k(new l.a.2(this), 30000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.l.a
 * JD-Core Version:    0.7.0.1
 */