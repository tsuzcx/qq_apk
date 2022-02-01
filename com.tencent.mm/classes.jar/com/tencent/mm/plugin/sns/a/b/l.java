package com.tencent.mm.plugin.sns.a.b;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.a.a.a.g;
import com.tencent.mm.plugin.sns.e.a;
import com.tencent.mm.sdk.platformtools.ad;

public final class l
{
  public static l wyR;
  public g<String, Bitmap> wyQ;
  
  static
  {
    AppMethodBeat.i(95042);
    wyR = new l();
    AppMethodBeat.o(95042);
  }
  
  private l()
  {
    AppMethodBeat.i(95040);
    this.wyQ = new g(5);
    AppMethodBeat.o(95040);
  }
  
  public final Bitmap getBitmap(String paramString)
  {
    AppMethodBeat.i(95041);
    if (this.wyQ.aN(paramString))
    {
      localBitmap = (Bitmap)this.wyQ.aM(paramString);
      if (localBitmap != null)
      {
        ad.i("MicroMsg.SnsTimelineAdResourceMgr", "hit cache %s", new Object[] { paramString });
        AppMethodBeat.o(95041);
        return localBitmap;
      }
    }
    ad.i("MicroMsg.SnsTimelineAdResourceMgr", "not hit cache %s", new Object[] { paramString });
    Bitmap localBitmap = a.l(paramString, 0.1F);
    if (localBitmap != null) {
      this.wyQ.put(paramString, localBitmap);
    }
    AppMethodBeat.o(95041);
    return localBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.a.b.l
 * JD-Core Version:    0.7.0.1
 */