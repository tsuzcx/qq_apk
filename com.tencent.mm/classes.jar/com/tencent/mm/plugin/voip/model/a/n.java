package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public abstract class n<REQ, RESP>
  extends p
  implements com.tencent.mm.network.m
{
  private com.tencent.mm.am.h UDk;
  protected l UzB = com.tencent.mm.plugin.voip.model.m.hWU();
  private com.tencent.mm.am.h callback;
  protected c rr;
  
  public int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    int i = hYU();
    if (i != 0) {
      return i;
    }
    this.UDk = paramh;
    this.callback = hYT();
    return dispatch(paramg, this.rr, this);
  }
  
  public abstract com.tencent.mm.am.h hYT();
  
  public int hYU()
  {
    return 0;
  }
  
  public final void hYW()
  {
    Log.i("MicroMsg.VoipNetSceneBase", "netscene " + getClass().getSimpleName() + '@' + Integer.toHexString(hashCode()) + " is started.");
    com.tencent.mm.kernel.h.aZW().a(this, 0);
  }
  
  public final <RESP> RESP hYX()
  {
    return c.c.b(this.rr.otC);
  }
  
  public final <REQ> REQ hYY()
  {
    return c.b.b(this.rr.otB);
  }
  
  public void mD(int paramInt1, int paramInt2) {}
  
  public void onGYNetEnd(int paramInt1, final int paramInt2, final int paramInt3, final String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    mD(paramInt2, paramInt3);
    if (this.UDk != null) {
      this.UDk.onSceneEnd(paramInt2, paramInt3, paramString, this);
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