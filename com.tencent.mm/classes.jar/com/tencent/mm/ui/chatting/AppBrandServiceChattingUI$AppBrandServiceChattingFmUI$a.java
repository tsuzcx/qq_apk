package com.tencent.mm.ui.chatting;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.vfs.e;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

final class AppBrandServiceChattingUI$AppBrandServiceChattingFmUI$a
  implements Runnable
{
  private j.b cEn;
  private String cwc;
  private boolean hKA;
  private String hKv;
  private String hKx;
  private String hKz;
  private String zwh;
  
  public final void run()
  {
    AppMethodBeat.i(153824);
    Object localObject2 = new byte[0];
    if (!bo.isNullOrNil(this.hKz))
    {
      Bitmap localBitmap = b.acD().a("file://" + this.hKz, null);
      if (localBitmap != null)
      {
        localObject1 = localBitmap;
        if (!localBitmap.isRecycled()) {}
      }
      else
      {
        localBitmap = d.aoV(this.hKx);
        localObject1 = localBitmap;
        if (this.hKA)
        {
          boolean bool = e.deleteFile(this.hKz);
          ab.v("MicroMsg.AppBrandServiceChattingUI", "decode thumb icon bitmap by path(%s), and deleted(%s) file.", new Object[] { this.hKx, Boolean.valueOf(bool) });
          localObject1 = localBitmap;
        }
      }
      if ((localObject1 == null) || (((Bitmap)localObject1).isRecycled())) {
        break label203;
      }
      ab.i("MicroMsg.AppBrandServiceChattingUI", "thumb image is not null ");
      localObject2 = new ByteArrayOutputStream();
      ((Bitmap)localObject1).compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject2);
    }
    for (Object localObject1 = ((ByteArrayOutputStream)localObject2).toByteArray();; localObject1 = localObject2)
    {
      l.a(this.cEn, this.cwc, this.hKv, this.zwh, null, (byte[])localObject1);
      AppMethodBeat.o(153824);
      return;
      localObject1 = b.acD().a(this.hKx, null);
      break;
      label203:
      ab.e("MicroMsg.AppBrandServiceChattingUI", "thumb image is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a
 * JD-Core Version:    0.7.0.1
 */