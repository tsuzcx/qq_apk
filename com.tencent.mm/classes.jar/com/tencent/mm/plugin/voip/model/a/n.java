package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public abstract class n<REQ, RESP>
  extends q
  implements com.tencent.mm.network.m
{
  protected l NMN = com.tencent.mm.plugin.voip.model.m.gza();
  private i NQy;
  private i callback;
  protected d rr;
  
  public int doScene(g paramg, i parami)
  {
    int i = gAV();
    if (i != 0) {
      return i;
    }
    this.NQy = parami;
    this.callback = gAU();
    return dispatch(paramg, this.rr, this);
  }
  
  public abstract i gAU();
  
  public int gAV()
  {
    return 0;
  }
  
  public final void gAX()
  {
    Log.i("MicroMsg.VoipNetSceneBase", "netscene " + getClass().getSimpleName() + '@' + Integer.toHexString(hashCode()) + " is started.");
    h.aGY().a(this, 0);
  }
  
  public final <RESP> RESP gAY()
  {
    return d.c.b(this.rr.lBS);
  }
  
  public final <REQ> REQ gAZ()
  {
    return d.b.b(this.rr.lBR);
  }
  
  public void kQ(int paramInt1, int paramInt2) {}
  
  public void onGYNetEnd(int paramInt1, final int paramInt2, final int paramInt3, final String paramString, s params, byte[] paramArrayOfByte)
  {
    kQ(paramInt2, paramInt3);
    if (this.NQy != null) {
      this.NQy.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.callback != null) {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(115258);
          if (n.a(n.this) != null) {
            n.a(n.this).onSceneEnd(paramInt2, paramInt3, paramString, n.this);
          }
          AppMethodBeat.o(115258);
        }
      });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.n
 * JD-Core Version:    0.7.0.1
 */