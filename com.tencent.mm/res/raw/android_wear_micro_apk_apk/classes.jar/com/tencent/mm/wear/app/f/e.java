package com.tencent.mm.wear.app.f;

import com.tencent.mm.wear.a.c.d;
import com.tencent.mm.wear.app.MMApplication;
import com.tencent.mm.wear.app.b.h;

public final class e
  extends com.tencent.mm.wear.app.g.a
{
  private int aep;
  private int agB;
  private byte[] ahP;
  private boolean ahT;
  private boolean ahU = true;
  private g ahV;
  
  public e(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    this.agB = paramInt1;
    this.aep = paramInt2;
    this.ahP = paramArrayOfByte;
  }
  
  public final void J(boolean paramBoolean)
  {
    this.ahU = paramBoolean;
  }
  
  public final void a(g paramg)
  {
    this.ahV = paramg;
  }
  
  protected final void execute()
  {
    b localb = new b(this.aep, this.ahP);
    localb.I(this.ahT);
    h.mP().a(localb);
    d.c("MicroMsg.NotificationTask", "execute notificationId=%d funId=%d", new Object[] { Integer.valueOf(this.agB), Integer.valueOf(this.aep) });
    if (this.ahU) {
      ou();
    }
    com.tencent.mm.wear.app.d.g.i(MMApplication.getContext(), this.agB);
    com.tencent.mm.wear.a.b.a.amv.post(new f(this, this.aep));
  }
  
  protected final String getName()
  {
    return "NotificationTask";
  }
  
  public final void nG()
  {
    this.ahT = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.f.e
 * JD-Core Version:    0.7.0.1
 */