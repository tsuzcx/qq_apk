package com.tencent.mm.wear.app.b;

import com.tencent.mm.wear.a.f.c;
import com.tencent.mm.wear.app.ui.MMActivity;
import java.io.File;
import java.io.IOException;

public final class d
  extends com.tencent.mm.wear.app.g.a
{
  private com.tencent.mm.wear.app.a.e aaS;
  private f aaV;
  
  private boolean lR()
  {
    Object localObject1 = new com.tencent.mm.wear.app.a.g();
    ((com.tencent.mm.wear.app.a.g)localObject1).aaO = 11001;
    Object localObject2 = new com.tencent.mm.e.a.e();
    ((com.tencent.mm.e.a.e)localObject2).Vs = 0L;
    try
    {
      ((com.tencent.mm.wear.app.a.g)localObject1).data = ((com.tencent.mm.e.a.e)localObject2).toByteArray();
      label36:
      localObject1 = this.aaS.a((com.tencent.mm.wear.app.a.g)localObject1);
      if ((((com.tencent.mm.wear.app.a.h)localObject1).aaw != 0) || (((com.tencent.mm.wear.app.a.h)localObject1).data == null))
      {
        com.tencent.mm.wear.a.c.d.a("MicroMsg.InitResourceTask", "emoji compact resp error %s", new Object[] { ((com.tencent.mm.wear.app.a.h)localObject1).toString() });
        com.tencent.mm.wear.a.b.a.aiT.post(new e(this, 11001, 131072));
        return false;
      }
      com.tencent.mm.wear.a.c.d.c("MicroMsg.InitResourceTask", "receive emoji compact size = %d", new Object[] { Integer.valueOf(((com.tencent.mm.wear.app.a.h)localObject1).data.length) });
      localObject2 = new File(h.mh(), com.tencent.mm.wear.app.emoji.a.mz());
      ((File)localObject2).delete();
      localObject2 = ((File)localObject2).getAbsolutePath();
      localObject1 = ((com.tencent.mm.wear.app.a.h)localObject1).data;
      return c.a(new File((String)localObject2), (byte[])localObject1);
    }
    catch (IOException localIOException)
    {
      break label36;
    }
  }
  
  public final void a(f paramf)
  {
    this.aaV = paramf;
  }
  
  protected final void execute()
  {
    this.aaS = new com.tencent.mm.wear.app.a.e(h.mb().lS());
    this.aaS.setTimeout(30000L);
    Object localObject;
    if (MMActivity.ne())
    {
      localObject = new com.tencent.mm.wear.app.a.g();
      ((com.tencent.mm.wear.app.a.g)localObject).aaO = 11033;
      ((com.tencent.mm.wear.app.a.g)localObject).data = "arm_v7".getBytes();
      localObject = this.aaS.a((com.tencent.mm.wear.app.a.g)localObject);
      if ((((com.tencent.mm.wear.app.a.h)localObject).aaw == 0) && (((com.tencent.mm.wear.app.a.h)localObject).data != null)) {
        break label280;
      }
      com.tencent.mm.wear.a.c.d.a("MicroMsg.InitResourceTask", "stlPortShared so resp error %s", new Object[] { ((com.tencent.mm.wear.app.a.h)localObject).toString() });
      com.tencent.mm.wear.a.b.a.aiT.post(new e(this, 11033, 131072));
      bool = false;
      if (bool) {
        com.tencent.mm.wear.a.b.a.aiT.post(new e(this, 11033, 0));
      }
      localObject = new com.tencent.mm.wear.app.a.g();
      ((com.tencent.mm.wear.app.a.g)localObject).aaO = 11030;
      ((com.tencent.mm.wear.app.a.g)localObject).data = "arm_v7".getBytes();
      localObject = this.aaS.a((com.tencent.mm.wear.app.a.g)localObject);
      if ((((com.tencent.mm.wear.app.a.h)localObject).aaw == 0) && (((com.tencent.mm.wear.app.a.h)localObject).data != null)) {
        break label319;
      }
      com.tencent.mm.wear.a.c.d.a("MicroMsg.InitResourceTask", "silk so resp error %s", new Object[] { ((com.tencent.mm.wear.app.a.h)localObject).toString() });
      com.tencent.mm.wear.a.b.a.aiT.post(new e(this, 11030, 131072));
    }
    for (boolean bool = false;; bool = com.tencent.mm.wear.a.f.d.d("wechatvoicesilk", (byte[])localObject))
    {
      if (bool) {
        com.tencent.mm.wear.a.b.a.aiT.post(new e(this, 11030, 0));
      }
      if (lR()) {
        com.tencent.mm.wear.a.b.a.aiT.post(new e(this, 11001, 0));
      }
      return;
      label280:
      localObject = ((com.tencent.mm.wear.app.a.h)localObject).data;
      com.tencent.mm.wear.a.c.d.c("MicroMsg.InitResourceTask", "receive stlPortShared so size = %d", new Object[] { Integer.valueOf(localObject.length) });
      com.tencent.mm.wear.a.f.d.V("stlport_shared");
      bool = com.tencent.mm.wear.a.f.d.d("stlport_shared", (byte[])localObject);
      break;
      label319:
      localObject = ((com.tencent.mm.wear.app.a.h)localObject).data;
      com.tencent.mm.wear.a.c.d.c("MicroMsg.InitResourceTask", "receive silk so size = %d", new Object[] { Integer.valueOf(localObject.length) });
      com.tencent.mm.wear.a.f.d.V("wechatvoicesilk");
    }
  }
  
  protected final String getName()
  {
    return "InitResourceTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.b.d
 * JD-Core Version:    0.7.0.1
 */