package com.tencent.mm.wear.app.c;

import com.tencent.mm.wear.a.c.d;
import com.tencent.mm.wear.app.a.e;
import java.io.File;
import java.io.IOException;

final class f
  extends com.tencent.mm.wear.app.g.a
{
  private a acV;
  
  public f(b paramb, a parama)
  {
    this.acV = parama;
  }
  
  protected final void execute()
  {
    Object localObject1 = new e(com.tencent.mm.wear.app.b.h.mb().lS());
    Object localObject2 = new com.tencent.mm.wear.app.a.g();
    ((com.tencent.mm.wear.app.a.g)localObject2).aaO = 11005;
    com.tencent.mm.e.a.a locala = new com.tencent.mm.e.a.a();
    locala.Vm = this.acV.acH;
    locala.Vl = this.acV.acP;
    try
    {
      ((com.tencent.mm.wear.app.a.g)localObject2).data = locala.toByteArray();
      label67:
      localObject2 = ((e)localObject1).a((com.tencent.mm.wear.app.a.g)localObject2);
      if ((((com.tencent.mm.wear.app.a.h)localObject2).aaw == 0) && (((com.tencent.mm.wear.app.a.h)localObject2).data != null)) {
        localObject1 = new com.tencent.mm.e.a.b();
      }
      try
      {
        ((com.tencent.mm.e.a.b)localObject1).h(((com.tencent.mm.wear.app.a.h)localObject2).data);
        label104:
        if (((com.tencent.mm.e.a.b)localObject1).Vn != null)
        {
          localObject2 = b.e(this.acV);
          d.c("MicroMsg.MMImageLoader", "request avatar success %s %s", new Object[] { this.acV.acH, localObject2 });
          localObject2 = new File(com.tencent.mm.wear.app.b.h.mn(), (String)localObject2);
          ((File)localObject2).setLastModified(((com.tencent.mm.e.a.b)localObject1).Vl);
          if (!((File)localObject2).getParentFile().exists()) {
            ((File)localObject2).getParentFile().mkdirs();
          }
          if (com.tencent.mm.wear.a.f.c.a((File)localObject2, ((com.tencent.mm.e.a.b)localObject1).Vn.toByteArray())) {
            b.d(this.acW).e(new c(this.acW, this.acV));
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