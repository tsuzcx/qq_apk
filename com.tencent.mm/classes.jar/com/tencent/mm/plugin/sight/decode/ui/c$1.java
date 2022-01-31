package com.tencent.mm.plugin.sight.decode.ui;

import android.util.Base64;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.o;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.pluginsdk.ui.tools.e;
import com.tencent.mm.pluginsdk.ui.tools.e.a;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;

final class c$1
  implements e.a
{
  c$1(c paramc) {}
  
  public final void Es()
  {
    AppMethodBeat.i(70281);
    ab.d("MicroMsg.VideoPopupHelper", "on completion");
    c.d(this.qUl).post(new c.1.2(this));
    c.b(this.qUl).setLoop(true);
    c.a(this.qUl);
    AppMethodBeat.o(70281);
  }
  
  public final int dP(int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public final void dQ(int paramInt1, int paramInt2) {}
  
  public final void mG()
  {
    AppMethodBeat.i(70279);
    ab.d("MicroMsg.VideoPopupHelper", com.tencent.mm.compatible.util.g.Mk() + " onPrepared");
    c.a(this.qUl);
    AppMethodBeat.o(70279);
  }
  
  public final void onError(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(70280);
    ab.e("MicroMsg.VideoPopupHelper", "on play video error, what %d extra %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    c.b(this.qUl).stop();
    b.G(Base64.encodeToString((d.cmw() + "[SightPopupHelper] on play video error, what " + paramInt1 + " extra " + paramInt2 + ", path=" + bo.bf(c.c(this.qUl), "")).getBytes(), 2), "FullScreenPlaySight");
    String str = c.c(this.qUl);
    al.d(new c.1.1(this, o.ahC().a(str, a.getDensity(this.qUl.getContext()), this.qUl.getContext(), -1), str));
    AppMethodBeat.o(70280);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.ui.c.1
 * JD-Core Version:    0.7.0.1
 */