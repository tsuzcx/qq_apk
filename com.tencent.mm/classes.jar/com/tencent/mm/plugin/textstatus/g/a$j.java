package com.tencent.mm.plugin.textstatus.g;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelimage.e;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.textstatus.b.f;
import com.tencent.mm.plugin.textstatus.h.f.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
final class a$j
  extends u
  implements a<Object>
{
  a$j(String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, String paramString4)
  {
    super(0);
  }
  
  public final Object invoke()
  {
    AppMethodBeat.i(289896);
    Log.i("MicroMsg.TextStatus.StatusImgHandler", "triggerDownloadThumb update " + this.msb + ' ' + this.svx);
    Object localObject1 = f.TjQ;
    Object localObject2 = f.hGH().bdY(this.mrr);
    if (localObject2 == null)
    {
      localObject1 = null;
      if (localObject1 == null)
      {
        Log.e("MicroMsg.TextStatus.StatusImgHandler", "triggerDownloadThumb TextStatus is null");
        localObject1 = ah.aiuX;
        AppMethodBeat.o(289896);
        return localObject1;
      }
    }
    else
    {
      String str1 = this.msb;
      String str2 = this.svx;
      Bitmap localBitmap = this.eGL;
      localObject1 = this.Tms;
      if (Util.isEqual(str1, ((com.tencent.mm.plugin.textstatus.h.f.b)localObject2).field_StatusID))
      {
        Log.i("MicroMsg.TextStatus.StatusImgHandler", "triggerDownloadThumb update " + str2 + ' ' + str1);
        b.m(localBitmap, str2);
        localObject2 = b.aXb(str2);
        r.bJZ();
        e.g((String)localObject1, (Bitmap)localObject2);
      }
      for (;;)
      {
        localObject1 = ah.aiuX;
        break;
        Log.e("MicroMsg.TextStatus.StatusImgHandler", s.X("triggerDownloadThumb getLatest:", ((com.tencent.mm.plugin.textstatus.h.f.b)localObject2).field_StatusID));
      }
    }
    AppMethodBeat.o(289896);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.g.a.j
 * JD-Core Version:    0.7.0.1
 */