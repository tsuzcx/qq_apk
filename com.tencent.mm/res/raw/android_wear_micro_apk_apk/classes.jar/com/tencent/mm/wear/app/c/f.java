package com.tencent.mm.wear.app.c;

import com.tencent.mm.wear.a.c.d;
import com.tencent.mm.wear.app.a.e;
import java.io.File;
import java.io.IOException;

final class f
  extends com.tencent.mm.wear.app.g.a
{
  private a agw;
  
  public f(b paramb, a parama)
  {
    this.agw = parama;
  }
  
  protected final void execute()
  {
    Object localObject1 = new e(com.tencent.mm.wear.app.b.h.mO().mF());
    Object localObject2 = new com.tencent.mm.wear.app.a.g();
    ((com.tencent.mm.wear.app.a.g)localObject2).aep = 11005;
    com.tencent.mm.e.a.a locala = new com.tencent.mm.e.a.a();
    locala.Xh = this.agw.agi;
    locala.Xg = this.agw.agq;
    try
    {
      ((com.tencent.mm.wear.app.a.g)localObject2).data = locala.toByteArray();
      label67:
      localObject2 = ((e)localObject1).a((com.tencent.mm.wear.app.a.g)localObject2);
      if ((((com.tencent.mm.wear.app.a.h)localObject2).adX == 0) && (((com.tencent.mm.wear.app.a.h)localObject2).data != null)) {
        localObject1 = new com.tencent.mm.e.a.b();
      }
      try
      {
        ((com.tencent.mm.e.a.b)localObject1).h(((com.tencent.mm.wear.app.a.h)localObject2).data);
        label104:
        if (((com.tencent.mm.e.a.b)localObject1).Xi != null)
        {
          localObject2 = b.e(this.agw);
          d.c("MicroMsg.MMImageLoader", "request avatar success %s %s", new Object[] { this.agw.agi, localObject2 });
          localObject2 = new File(com.tencent.mm.wear.app.b.h.mZ(), (String)localObject2);
          ((File)localObject2).setLastModified(((com.tencent.mm.e.a.b)localObject1).Xg);
          if (!((File)localObject2).getParentFile().exists()) {
            ((File)localObject2).getParentFile().mkdirs();
          }
          if (com.tencent.mm.wear.a.f.c.a((File)localObject2, ((com.tencent.mm.e.a.b)localObject1).Xi.toByteArray())) {
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
    return "RequestAvatarTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.c.f
 * JD-Core Version:    0.7.0.1
 */