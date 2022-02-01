package com.tencent.mm.wear.app.ui.img;

import com.tencent.mm.e.a.q;
import com.tencent.mm.e.a.r;
import com.tencent.mm.wear.a.f.c;
import com.tencent.mm.wear.app.a.e;
import com.tencent.mm.wear.app.ui.MMActivity;
import java.io.File;
import java.io.IOException;

final class a
  extends com.tencent.mm.wear.app.g.a
{
  e aet;
  
  private a(DetailImgUI paramDetailImgUI) {}
  
  public final void cancel()
  {
    if (this.aet != null) {
      this.aet.cancel();
    }
  }
  
  protected final void execute()
  {
    Object localObject1 = DetailImgUI.m(DetailImgUI.b(this.ajC));
    File localFile = new File(com.tencent.mm.wear.app.b.h.mY(), (String)localObject1);
    Object localObject2 = null;
    if (localFile.exists()) {
      localObject1 = c.a(localFile);
    }
    for (;;)
    {
      if ((localObject1 != null) && (c.a(localFile, (byte[])localObject1))) {
        DetailImgUI.a(this.ajC, com.tencent.mm.wear.a.f.b.c((byte[])localObject1, MMActivity.nP() * 2, MMActivity.nO() * 2));
      }
      com.tencent.mm.wear.a.b.a.amv.post(new b(this.ajC, (byte)0));
      return;
      this.aet = new e(com.tencent.mm.wear.app.b.h.mO().mF());
      this.aet.setTimeout(29000L);
      localObject1 = new com.tencent.mm.wear.app.a.g();
      ((com.tencent.mm.wear.app.a.g)localObject1).aep = 11007;
      Object localObject3 = new q();
      ((q)localObject3).XJ = DetailImgUI.b(this.ajC);
      ((q)localObject3).XN = true;
      try
      {
        ((com.tencent.mm.wear.app.a.g)localObject1).data = ((q)localObject3).toByteArray();
        label169:
        com.tencent.mm.wear.app.a.h localh = this.aet.a((com.tencent.mm.wear.app.a.g)localObject1);
        localObject1 = localObject2;
        if (localh.adX != 0) {
          continue;
        }
        localObject1 = localObject2;
        if (localh.data == null) {
          continue;
        }
        localObject3 = new r();
        try
        {
          ((r)localObject3).h(localh.data);
          label219:
          localObject1 = localObject2;
          if (((r)localObject3).Xi == null) {
            continue;
          }
          localObject1 = ((r)localObject3).Xi.toByteArray();
        }
        catch (IOException localIOException1)
        {
          break label219;
        }
      }
      catch (IOException localIOException2)
      {
        break label169;
      }
    }
  }
  
  protected final String getName()
  {
    return "LoadImageTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.ui.img.a
 * JD-Core Version:    0.7.0.1
 */