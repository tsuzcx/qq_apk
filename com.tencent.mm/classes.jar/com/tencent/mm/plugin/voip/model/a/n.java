package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public abstract class n<REQ, RESP>
  extends q
  implements com.tencent.mm.network.m
{
  protected l GWA = com.tencent.mm.plugin.voip.model.m.fGM();
  i callback;
  protected d rr;
  private i wPq;
  
  public int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    int i = fIG();
    if (i != 0) {
      return i;
    }
    this.wPq = parami;
    this.callback = fIF();
    return dispatch(paramg, this.rr, this);
  }
  
  public abstract i fIF();
  
  public int fIG()
  {
    return 0;
  }
  
  public final void fII()
  {
    Log.i("MicroMsg.VoipNetSceneBase", "netscene " + getClass().getSimpleName() + '@' + Integer.toHexString(hashCode()) + " is started.");
    com.tencent.mm.kernel.g.azz().a(this, 0);
  }
  
  public final <RESP> RESP fIJ()
  {
    return this.rr.iLL.iLR;
  }
  
  public final <REQ> REQ fIK()
  {
    return this.rr.iLK.iLR;
  }
  
  public void jC(int paramInt1, int paramInt2) {}
  
  public void onGYNetEnd(int paramInt1, final int paramInt2, final int paramInt3, final String paramString, s params, byte[] paramArrayOfByte)
  {
    jC(paramInt2, paramInt3);
    if (this.wPq != null) {
      this.wPq.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.callback != null) {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(115258);
          if (n.this.callback != null) {
            n.this.callback.onSceneEnd(paramInt2, paramInt3, paramString, n.this);
          }
          AppMethodBeat.o(115258);
        }
      });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.n
 * JD-Core Version:    0.7.0.1
 */