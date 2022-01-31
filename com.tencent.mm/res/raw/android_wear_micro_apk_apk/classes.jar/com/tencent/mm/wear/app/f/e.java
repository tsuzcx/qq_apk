package com.tencent.mm.wear.app.f;

import com.tencent.mm.wear.a.c.d;
import com.tencent.mm.wear.app.MMApplication;
import com.tencent.mm.wear.app.b.h;

public final class e
  extends com.tencent.mm.wear.app.g.a
{
  private int aaO;
  private int ada;
  private byte[] aen;
  private boolean aer;
  private boolean aes = true;
  private g aet;
  
  public e(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    this.ada = paramInt1;
    this.aaO = paramInt2;
    this.aen = paramArrayOfByte;
  }
  
  public final void G(boolean paramBoolean)
  {
    this.aes = paramBoolean;
  }
  
  public final void a(g paramg)
  {
    this.aet = paramg;
  }
  
  protected final void execute()
  {
    b localb = new b(this.aaO, this.aen);
    localb.F(this.aer);
    h.mc().a(localb);
    d.c("MicroMsg.NotificationTask", "execute notificationId=%d funId=%d", new Object[] { Integer.valueOf(this.ada), Integer.valueOf(this.aaO) });
    if (this.aes) {
      nG();
    }
    com.tencent.mm.wear.app.d.f.i(MMApplication.getContext(), this.ada);
    com.tencent.mm.wear.a.b.a.aiT.post(new f(this, this.aaO));
  }
  
  protected final String getName()
  {
    return "NotificationTask";
  }
  
  public final void mU()
  {
    this.aer = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.f.e
 * JD-Core Version:    0.7.0.1
 */