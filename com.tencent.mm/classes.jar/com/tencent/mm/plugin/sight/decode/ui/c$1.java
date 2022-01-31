package com.tencent.mm.plugin.sight.decode.ui;

import android.util.Base64;
import android.widget.TextView;
import com.tencent.mm.as.o;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.pluginsdk.ui.tools.f.a;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class c$1
  implements f.a
{
  c$1(c paramc) {}
  
  public final int cv(int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public final void cw(int paramInt1, int paramInt2) {}
  
  public final void kA()
  {
    y.d("MicroMsg.VideoPopupHelper", com.tencent.mm.compatible.util.g.zH() + " onPrepared");
    c.a(this.ofW);
  }
  
  public final void onError(int paramInt1, int paramInt2)
  {
    y.e("MicroMsg.VideoPopupHelper", "on play video error, what %d extra %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    c.b(this.ofW).stop();
    b.t(Base64.encodeToString((d.bAW() + "[SightPopupHelper] on play video error, what " + paramInt1 + " extra " + paramInt2 + ", path=" + bk.aM(c.c(this.ofW), "")).getBytes(), 2), "FullScreenPlaySight");
    String str = c.c(this.ofW);
    ai.d(new c.1.1(this, o.OJ().a(str, a.getDensity(this.ofW.getContext()), this.ofW.getContext(), -1), str));
  }
  
  public final void ug()
  {
    y.d("MicroMsg.VideoPopupHelper", "on completion");
    c.d(this.ofW).post(new c.1.2(this));
    c.b(this.ofW).setLoop(true);
    c.a(this.ofW);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.ui.c.1
 * JD-Core Version:    0.7.0.1
 */