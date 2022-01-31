package com.tencent.mm.wear.app.c;

import android.graphics.Bitmap;
import com.tencent.mm.wear.a.c.d;
import java.io.File;

final class c
  extends com.tencent.mm.wear.app.g.a
{
  private a acV;
  
  public c(b paramb, a parama)
  {
    this.acV = parama;
  }
  
  protected final void execute()
  {
    switch (this.acV.type)
    {
    default: 
      return;
    case 1: 
      localObject1 = new File(com.tencent.mm.wear.app.b.h.ml(), this.acV.acJ);
      d.c("MicroMsg.MMImageLoader", "load image %s", new Object[] { ((File)localObject1).getAbsoluteFile() });
      if (((File)localObject1).exists())
      {
        localObject1 = com.tencent.mm.wear.a.f.c.a((File)localObject1);
        if (this.acV.acQ == 1) {
          b.a(this.acW).put(this.acV.acK, localObject1);
        }
        com.tencent.mm.wear.a.b.a.aiT.post(new e(this.acW, this.acV));
        return;
      }
      com.tencent.mm.wear.app.b.h.mc().a(new g(this.acW, this.acV));
      return;
    case 3: 
      localObject1 = new File(com.tencent.mm.wear.app.b.h.mn(), this.acV.acK);
      if (((File)localObject1).exists())
      {
        Object localObject2 = com.tencent.mm.wear.a.f.b.c(com.tencent.mm.wear.a.f.c.a((File)localObject1), this.acV.width, this.acV.height);
        localObject1 = localObject2;
        if (this.acV.acN > 0) {
          localObject1 = com.tencent.mm.wear.a.f.b.a(b.b(this.acW), (Bitmap)localObject2, this.acV.acN);
        }
        localObject2 = localObject1;
        if (this.acV.acO > 0) {
          localObject2 = com.tencent.mm.wear.a.f.b.a((Bitmap)localObject1, this.acV.acO);
        }
        b.c(this.acW).put(this.acV.acK, localObject2);
        com.tencent.mm.wear.a.b.a.aiT.post(new e(this.acW, this.acV));
        return;
      }
      com.tencent.mm.wear.app.b.h.mc().a(new f(this.acW, this.acV));
      return;
    }
    Object localObject1 = new File(com.tencent.mm.wear.app.b.h.mm(), this.acV.acK);
    if (((File)localObject1).exists())
    {
      localObject1 = com.tencent.mm.wear.a.f.b.c(com.tencent.mm.wear.a.f.c.a((File)localObject1), this.acV.width, this.acV.height);
      b.c(this.acW).put(this.acV.acK, localObject1);
      com.tencent.mm.wear.a.b.a.aiT.post(new e(this.acW, this.acV));
      return;
    }
    com.tencent.mm.wear.app.b.h.mc().a(new h(this.acW, this.acV));
  }
  
  protected final String getName()
  {
    return "LoadImageTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.c.c
 * JD-Core Version:    0.7.0.1
 */