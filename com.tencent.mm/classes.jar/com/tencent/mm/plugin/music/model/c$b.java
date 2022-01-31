package com.tencent.mm.plugin.music.model;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.model.e.a;
import com.tencent.mm.plugin.music.model.e.b;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.ui.af;

final class c$b
  implements Runnable
{
  a oZD;
  
  c$b(c paramc, a parama)
  {
    this.oZD = parama;
  }
  
  public final void run()
  {
    AppMethodBeat.i(104878);
    Object localObject = new bcs();
    ((bcs)localObject).Id = this.oZD.field_songMediaId;
    ((bcs)localObject).xrS = this.oZD.field_songAlbumUrl;
    ((bcs)localObject).xrT = this.oZD.field_songAlbumType;
    ((bcs)localObject).Url = ((bcs)localObject).xrS;
    localObject = n.raQ.b((bcs)localObject);
    if (localObject != null)
    {
      localObject = d.g((Bitmap)localObject, 10);
      this.oZA.a(this.oZD, (Bitmap)localObject);
      localObject = af.ao((Bitmap)localObject);
      if (!this.oZD.y((int[])localObject)) {
        this.oZD = e.bVM().ap(this.oZD.field_musicId, localObject[0], localObject[1]);
      }
      if ((this.oZA.oZx != null) && (this.oZD != null)) {
        this.oZA.oZx.a(this.oZD, (int[])localObject);
      }
    }
    AppMethodBeat.o(104878);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.c.b
 * JD-Core Version:    0.7.0.1
 */