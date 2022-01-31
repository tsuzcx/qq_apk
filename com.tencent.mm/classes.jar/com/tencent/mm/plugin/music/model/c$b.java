package com.tencent.mm.plugin.music.model;

import android.graphics.Bitmap;
import com.tencent.mm.plugin.music.model.e.a;
import com.tencent.mm.plugin.music.model.e.b;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.ui.ak;

public final class c$b
  implements Runnable
{
  a mzx;
  
  public c$b(c paramc, a parama)
  {
    this.mzx = parama;
  }
  
  public final void run()
  {
    Object localObject = new awd();
    ((awd)localObject).lsK = this.mzx.field_songMediaId;
    ((awd)localObject).trP = this.mzx.field_songAlbumUrl;
    ((awd)localObject).trQ = this.mzx.field_songAlbumType;
    ((awd)localObject).kSC = ((awd)localObject).trP;
    localObject = n.omC.b((awd)localObject);
    if (localObject != null)
    {
      localObject = com.tencent.mm.sdk.platformtools.c.f((Bitmap)localObject, 10);
      this.mzu.a(this.mzx, (Bitmap)localObject);
      localObject = ak.Y((Bitmap)localObject);
      if (!this.mzx.o((int[])localObject)) {
        this.mzx = e.bnq().Y(this.mzx.field_musicId, localObject[0], localObject[1]);
      }
      if ((this.mzu.mzr != null) && (this.mzx != null)) {
        this.mzu.mzr.a(this.mzx, (int[])localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.c.b
 * JD-Core Version:    0.7.0.1
 */