package com.tencent.mm.wear.app.f;

import com.tencent.mm.wear.app.a.e;

public final class b
  extends com.tencent.mm.wear.app.g.a
{
  private long aeb = 10000L;
  private int aep;
  private e aet;
  private byte[] ahP;
  private boolean ahQ;
  private d ahR;
  
  public b(int paramInt, byte[] paramArrayOfByte)
  {
    this.aep = paramInt;
    this.ahP = paramArrayOfByte;
  }
  
  public final void I(boolean paramBoolean)
  {
    this.ahQ = paramBoolean;
  }
  
  public final void a(d paramd)
  {
    this.ahR = paramd;
  }
  
  public final void cancel()
  {
    if (this.aet != null) {
      this.aet.cancel();
    }
  }
  
  protected final void execute()
  {
    this.aet = new e(com.tencent.mm.wear.app.b.h.mO().mF());
    this.aet.setTimeout(this.aeb);
    Object localObject = new com.tencent.mm.wear.app.a.g();
    ((com.tencent.mm.wear.app.a.g)localObject).aep = this.aep;
    if ((this.ahQ) && (this.ahP != null))
    {
      this.ahP = com.tencent.mm.wear.app.b.h.mO().k(this.ahP);
      if (this.ahP == null)
      {
        com.tencent.mm.wear.a.c.d.a("MicroMsg.CommonTask", "common task fail encryptData = null %d", new Object[] { Integer.valueOf(this.aep) });
        com.tencent.mm.wear.a.b.a.amv.post(new c(this, this.aep, 65536, null));
        return;
      }
    }
    ((com.tencent.mm.wear.app.a.g)localObject).data = this.ahP;
    localObject = this.aet.a((com.tencent.mm.wear.app.a.g)localObject);
    if ((((com.tencent.mm.wear.app.a.h)localObject).adX == 0) && (((com.tencent.mm.wear.app.a.h)localObject).data != null))
    {
      if (this.ahQ)
      {
        localObject = com.tencent.mm.wear.app.b.h.mO().l(((com.tencent.mm.wear.app.a.h)localObject).data);
        if (localObject == null)
        {
          com.tencent.mm.wear.a.c.d.a("MicroMsg.CommonTask", "common task fail decryptData = null %d", new Object[] { Integer.valueOf(this.aep) });
          com.tencent.mm.wear.a.b.a.amv.post(new c(this, this.aep, 65536, null));
          return;
        }
        com.tencent.mm.wear.a.c.d.c("MicroMsg.CommonTask", "common task success %d", new Object[] { Integer.valueOf(this.aep) });
        com.tencent.mm.wear.a.b.a.amv.post(new c(this, this.aep, 0, (byte[])localObject));
        return;
      }
      com.tencent.mm.wear.a.c.d.c("MicroMsg.CommonTask", "common task success %d", new Object[] { Integer.valueOf(this.aep) });
      com.tencent.mm.wear.a.b.a.amv.post(new c(this, this.aep, 0, ((com.tencent.mm.wear.app.a.h)localObject).data));
      return;
    }
    com.tencent.mm.wear.a.b.a.amv.post(new c(this, this.aep, 131072, null));
  }
  
  protected final String getName()
  {
    return "CommonTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.f.b
 * JD-Core Version:    0.7.0.1
 */