package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import com.tencent.mm.h.a.cj;
import com.tencent.mm.h.a.cj.b;
import com.tencent.mm.h.a.qb;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aq;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class OnlineVideoView$1
  implements Runnable
{
  OnlineVideoView$1(OnlineVideoView paramOnlineVideoView, int paramInt, boolean paramBoolean) {}
  
  public final void run()
  {
    Object localObject1 = af.bDF().OB(OnlineVideoView.a(this.oRM));
    if (localObject1 == null) {}
    label269:
    do
    {
      return;
      y.i("MicroMsg.OnlineVideoView", "fav download video[%s] farFromScene %d isFromMain %b", new Object[] { OnlineVideoView.a(this.oRM), Integer.valueOf(this.oRK), Boolean.valueOf(this.oRL) });
      Object localObject2 = new cj();
      ((cj)localObject2).bIw.bID = this.oRK;
      ((cj)localObject2).bIw.activity = ((Activity)OnlineVideoView.b(this.oRM));
      com.tencent.mm.plugin.sns.i.a.a((cj)localObject2, (n)localObject1);
      com.tencent.mm.sdk.b.a.udP.m((b)localObject2);
      if (((cj)localObject2).bIx.ret == 0) {
        OnlineVideoView.bHS();
      }
      for (;;)
      {
        if (this.oRL)
        {
          localObject2 = new qb();
          ((qb)localObject2).bZz.bJQ = ((n)localObject1).bGE();
          ((qb)localObject2).bZz.bRV = i.j((n)localObject1);
          com.tencent.mm.sdk.b.a.udP.m((b)localObject2);
        }
        OnlineVideoView.c(this.oRM);
        if (OnlineVideoView.d(this.oRM) == null) {
          break;
        }
        if (!bk.bl(OnlineVideoView.d(this.oRM).getVideoPath())) {
          break label269;
        }
        y.i("MicroMsg.OnlineVideoView", "%d had not set video path to play", new Object[] { Integer.valueOf(this.oRM.hashCode()) });
        localObject1 = aq.a(OnlineVideoView.a(this.oRM), OnlineVideoView.e(this.oRM));
        if (bk.bl((String)localObject1)) {
          break;
        }
        this.oRM.bg((String)localObject1, false);
        return;
        OnlineVideoView.bHT();
      }
    } while (OnlineVideoView.d(this.oRM).isPlaying());
    OnlineVideoView.d(this.oRM).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.OnlineVideoView.1
 * JD-Core Version:    0.7.0.1
 */