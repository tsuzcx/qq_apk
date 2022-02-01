package com.tencent.mm.wear.app.b;

import com.tencent.mm.wear.a.f.c;
import java.io.File;
import java.io.IOException;

public final class d
  extends com.tencent.mm.wear.app.g.a
{
  private com.tencent.mm.wear.app.a.e aet;
  private f aew;
  
  private boolean mE()
  {
    Object localObject1 = new com.tencent.mm.wear.app.a.g();
    ((com.tencent.mm.wear.app.a.g)localObject1).aep = 11001;
    Object localObject2 = new com.tencent.mm.e.a.e();
    ((com.tencent.mm.e.a.e)localObject2).Xn = 0L;
    try
    {
      ((com.tencent.mm.wear.app.a.g)localObject1).data = ((com.tencent.mm.e.a.e)localObject2).toByteArray();
      label36:
      localObject1 = this.aet.a((com.tencent.mm.wear.app.a.g)localObject1);
      if ((((com.tencent.mm.wear.app.a.h)localObject1).adX != 0) || (((com.tencent.mm.wear.app.a.h)localObject1).data == null))
      {
        com.tencent.mm.wear.a.c.d.a("MicroMsg.InitResourceTask", "emoji compact resp error %s", new Object[] { ((com.tencent.mm.wear.app.a.h)localObject1).toString() });
        com.tencent.mm.wear.a.b.a.amv.post(new e(this, 131072));
        return false;
      }
      com.tencent.mm.wear.a.c.d.c("MicroMsg.InitResourceTask", "receive emoji compact size = %d", new Object[] { Integer.valueOf(((com.tencent.mm.wear.app.a.h)localObject1).data.length) });
      localObject2 = new File(h.mT(), com.tencent.mm.wear.app.emoji.a.nl());
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
    this.aew = paramf;
  }
  
  protected final void execute()
  {
    this.aet = new com.tencent.mm.wear.app.a.e(h.mO().mF());
    this.aet.setTimeout(30000L);
    if (mE()) {
      com.tencent.mm.wear.a.b.a.amv.post(new e(this, 0));
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