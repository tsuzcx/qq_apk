package com.tencent.mm.wear.app.c;

import com.tencent.mm.e.a.q;
import com.tencent.mm.e.a.r;
import com.tencent.mm.wear.a.c.d;
import com.tencent.mm.wear.app.a.e;
import java.io.File;
import java.io.IOException;

final class h
  extends com.tencent.mm.wear.app.g.a
{
  private a agw;
  
  public h(b paramb, a parama)
  {
    this.agw = parama;
  }
  
  protected final void execute()
  {
    Object localObject1 = new e(com.tencent.mm.wear.app.b.h.mO().mF());
    Object localObject2 = new com.tencent.mm.wear.app.a.g();
    ((com.tencent.mm.wear.app.a.g)localObject2).aep = 11007;
    q localq = new q();
    localq.XJ = this.agw.agh;
    localq.XN = this.agw.ags;
    try
    {
      ((com.tencent.mm.wear.app.a.g)localObject2).data = localq.toByteArray();
      label67:
      localObject2 = ((e)localObject1).a((com.tencent.mm.wear.app.a.g)localObject2);
      if ((((com.tencent.mm.wear.app.a.h)localObject2).adX == 0) && (((com.tencent.mm.wear.app.a.h)localObject2).data != null)) {
        localObject1 = new r();
      }
      try
      {
        ((r)localObject1).h(((com.tencent.mm.wear.app.a.h)localObject2).data);
        label104:
        if (((r)localObject1).Xi != null)
        {
          localObject2 = b.e(this.agw);
          d.c("MicroMsg.MMImageLoader", "request msg image success %b %s", new Object[] { Long.valueOf(this.agw.agh), localObject2 });
          localObject2 = new File(com.tencent.mm.wear.app.b.h.mY(), (String)localObject2);
          ((File)localObject2).setLastModified(((r)localObject1).Xg);
          if (!((File)localObject2).getParentFile().exists()) {
            ((File)localObject2).getParentFile().mkdirs();
          }
          if (com.tencent.mm.wear.a.f.c.a((File)localObject2, ((r)localObject1).Xi.toByteArray())) {
            b.d(this.agx).o(new c(this.agx, this.agw));
          }
        }
        return;
      }
      catch (IOException localIOException1)
      {
        break label104;
      }
    }
    catch (IOException localIOException2)
    {
      break label67;
    }
  }
  
  protected final String getName()
  {
    return "RequestMsgImageTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.c.h
 * JD-Core Version:    0.7.0.1
 */