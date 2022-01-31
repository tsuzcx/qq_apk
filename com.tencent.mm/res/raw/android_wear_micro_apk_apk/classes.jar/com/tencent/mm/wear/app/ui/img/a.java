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
  e aaS;
  
  private a(DetailImgUI paramDetailImgUI) {}
  
  public final void cancel()
  {
    if (this.aaS != null) {
      this.aaS.cancel();
    }
  }
  
  protected final void execute()
  {
    Object localObject1 = DetailImgUI.j(DetailImgUI.b(this.aga));
    File localFile = new File(com.tencent.mm.wear.app.b.h.mm(), (String)localObject1);
    Object localObject2 = null;
    if (localFile.exists()) {
      localObject1 = c.a(localFile);
    }
    for (;;)
    {
      if ((localObject1 != null) && (c.a(localFile, (byte[])localObject1))) {
        DetailImgUI.a(this.aga, com.tencent.mm.wear.a.f.b.c((byte[])localObject1, MMActivity.nc() * 2, MMActivity.nb() * 2));
      }
      com.tencent.mm.wear.a.b.a.aiT.post(new b(this.aga, (byte)0));
      return;
      this.aaS = new e(com.tencent.mm.wear.app.b.h.mb().lS());
      this.aaS.setTimeout(29000L);
      localObject1 = new com.tencent.mm.wear.app.a.g();
      ((com.tencent.mm.wear.app.a.g)localObject1).aaO = 11007;
      Object localObject3 = new q();
      ((q)localObject3).VO = DetailImgUI.b(this.aga);
      ((q)localObject3).VS = true;
      try
      {
        ((com.tencent.mm.wear.app.a.g)localObject1).data = ((q)localObject3).toByteArray();
        label169:
        com.tencent.mm.wear.app.a.h localh = this.aaS.a((com.tencent.mm.wear.app.a.g)localObject1);
        localObject1 = localObject2;
        if (localh.aaw != 0) {
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
          if (((r)localObject3).Vn == null) {
            continue;
          }
          localObject1 = ((r)localObject3).Vn.toByteArray();
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