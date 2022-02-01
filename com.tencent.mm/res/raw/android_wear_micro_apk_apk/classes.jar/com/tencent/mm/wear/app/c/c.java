package com.tencent.mm.wear.app.c;

import android.graphics.Bitmap;
import com.tencent.mm.wear.a.c.d;
import java.io.File;

final class c
  extends com.tencent.mm.wear.app.g.a
{
  private a agw;
  
  public c(b paramb, a parama)
  {
    this.agw = parama;
  }
  
  protected final void execute()
  {
    switch (this.agw.type)
    {
    default: 
      return;
    case 1: 
      localObject1 = new File(com.tencent.mm.wear.app.b.h.mX(), this.agw.agk);
      d.c("MicroMsg.MMImageLoader", "load image %s", new Object[] { ((File)localObject1).getAbsoluteFile() });
      if (((File)localObject1).exists())
      {
        localObject1 = com.tencent.mm.wear.a.f.c.a((File)localObject1);
        if (this.agw.agr == 1) {
          b.a(this.agx).put(this.agw.agl, localObject1);
        }
        com.tencent.mm.wear.a.b.a.amv.post(new e(this.agx, this.agw));
        return;
      }
      com.tencent.mm.wear.app.b.h.mP().a(new g(this.agx, this.agw));
      return;
    case 3: 
      localObject1 = new File(com.tencent.mm.wear.app.b.h.mZ(), this.agw.agl);
      if (((File)localObject1).exists())
      {
        Object localObject2 = com.tencent.mm.wear.a.f.b.c(com.tencent.mm.wear.a.f.c.a((File)localObject1), this.agw.width, this.agw.height);
        localObject1 = localObject2;
        if (this.agw.ago > 0) {
          localObject1 = com.tencent.mm.wear.a.f.b.a(b.b(this.agx), (Bitmap)localObject2, this.agw.ago);
        }
        localObject2 = localObject1;
        if (this.agw.agp > 0) {
          localObject2 = com.tencent.mm.wear.a.f.b.a((Bitmap)localObject1, this.agw.agp);
        }
        b.c(this.agx).put(this.agw.agl, localObject2);
        com.tencent.mm.wear.a.b.a.amv.post(new e(this.agx, this.agw));
        return;
      }
      com.tencent.mm.wear.app.b.h.mP().a(new f(this.agx, this.agw));
      return;
    }
    Object localObject1 = new File(com.tencent.mm.wear.app.b.h.mY(), this.agw.agl);
    if (((File)localObject1).exists())
    {
      localObject1 = com.tencent.mm.wear.a.f.b.c(com.tencent.mm.wear.a.f.c.a((File)localObject1), this.agw.width, this.agw.height);
      b.c(this.agx).put(this.agw.agl, localObject1);
      com.tencent.mm.wear.a.b.a.amv.post(new e(this.agx, this.agw));
      return;
    }
    com.tencent.mm.wear.app.b.h.mP().a(new h(this.agx, this.agw));
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