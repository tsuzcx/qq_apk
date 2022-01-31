package com.tencent.mm.wear.app.c;

import com.tencent.mm.wear.a.c.d;
import com.tencent.mm.wear.app.a.e;
import java.io.File;
import java.io.IOException;

final class g
  extends com.tencent.mm.wear.app.g.a
{
  private a acV;
  
  public g(b paramb, a parama)
  {
    this.acV = parama;
  }
  
  protected final void execute()
  {
    Object localObject = new e(com.tencent.mm.wear.app.b.h.mb().lS());
    com.tencent.mm.wear.app.a.g localg = new com.tencent.mm.wear.app.a.g();
    localg.aaO = 11006;
    try
    {
      localg.data = this.acV.acJ.getBytes("utf8");
      label45:
      localObject = ((e)localObject).a(localg);
      if ((((com.tencent.mm.wear.app.a.h)localObject).aaw == 0) && (((com.tencent.mm.wear.app.a.h)localObject).data != null))
      {
        d.c("MicroMsg.MMImageLoader", "request emoji success %s", new Object[] { this.acV.acJ });
        com.tencent.mm.wear.a.f.c.a(new File(com.tencent.mm.wear.app.b.h.ml(), this.acV.acJ), ((com.tencent.mm.wear.app.a.h)localObject).data);
        b.d(this.acW).e(new c(this.acW, this.acV));
      }
      return;
    }
    catch (IOException localIOException)
    {
      break label45;
    }
  }
  
  protected final String getName()
  {
    return "RequestEmojiTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.c.g
 * JD-Core Version:    0.7.0.1
 */