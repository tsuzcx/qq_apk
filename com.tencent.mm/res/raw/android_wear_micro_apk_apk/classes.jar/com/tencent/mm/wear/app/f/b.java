package com.tencent.mm.wear.app.f;

import com.tencent.mm.wear.app.a.e;

public final class b
  extends com.tencent.mm.wear.app.g.a
{
  private long aaA = 10000L;
  private int aaO;
  private e aaS;
  private byte[] aen;
  private boolean aeo;
  private d aep;
  
  public b(int paramInt, byte[] paramArrayOfByte)
  {
    this.aaO = paramInt;
    this.aen = paramArrayOfByte;
  }
  
  public final void F(boolean paramBoolean)
  {
    this.aeo = paramBoolean;
  }
  
  public final void a(d paramd)
  {
    this.aep = paramd;
  }
  
  public final void cancel()
  {
    if (this.aaS != null) {
      this.aaS.cancel();
    }
  }
  
  protected final void execute()
  {
    this.aaS = new e(com.tencent.mm.wear.app.b.h.mb().lS());
    this.aaS.setTimeout(this.aaA);
    Object localObject = new com.tencent.mm.wear.app.a.g();
    ((com.tencent.mm.wear.app.a.g)localObject).aaO = this.aaO;
    if ((this.aeo) && (this.aen != null))
    {
      this.aen = com.tencent.mm.wear.app.b.h.mb().k(this.aen);
      if (this.aen == null)
      {
        com.tencent.mm.wear.a.c.d.a("MicroMsg.CommonTask", "common task fail encryptData = null %d", new Object[] { Integer.valueOf(this.aaO) });
        com.tencent.mm.wear.a.b.a.aiT.post(new c(this, this.aaO, 65536, null));
        return;
      }
    }
    ((com.tencent.mm.wear.app.a.g)localObject).data = this.aen;
    localObject = this.aaS.a((com.tencent.mm.wear.app.a.g)localObject);
    if ((((com.tencent.mm.wear.app.a.h)localObject).aaw == 0) && (((com.tencent.mm.wear.app.a.h)localObject).data != null))
    {
      if (this.aeo)
      {
        localObject = com.tencent.mm.wear.app.b.h.mb().l(((com.tencent.mm.wear.app.a.h)localObject).data);
        if (localObject == null)
        {
          com.tencent.mm.wear.a.c.d.a("MicroMsg.CommonTask", "common task fail decryptData = null %d", new Object[] { Integer.valueOf(this.aaO) });
          com.tencent.mm.wear.a.b.a.aiT.post(new c(this, this.aaO, 65536, null));
          return;
        }
        com.tencent.mm.wear.a.c.d.c("MicroMsg.CommonTask", "common task success %d", new Object[] { Integer.valueOf(this.aaO) });
        com.tencent.mm.wear.a.b.a.aiT.post(new c(this, this.aaO, 0, (byte[])localObject));
        return;
      }
      com.tencent.mm.wear.a.c.d.c("MicroMsg.CommonTask", "common task success %d", new Object[] { Integer.valueOf(this.aaO) });
      com.tencent.mm.wear.a.b.a.aiT.post(new c(this, this.aaO, 0, ((com.tencent.mm.wear.app.a.h)localObject).data));
      return;
    }
    com.tencent.mm.wear.a.b.a.aiT.post(new c(this, this.aaO, 131072, null));
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