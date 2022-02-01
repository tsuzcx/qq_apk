package com.tencent.mm.plugin.sns.ad.d;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.a.a.a.g;
import com.tencent.mm.plugin.sns.d.a;
import com.tencent.mm.sdk.platformtools.ac;

public final class l
{
  public static l xKs;
  public g<String, Bitmap> xKr;
  
  static
  {
    AppMethodBeat.i(95042);
    xKs = new l();
    AppMethodBeat.o(95042);
  }
  
  private l()
  {
    AppMethodBeat.i(95040);
    this.xKr = new g(5);
    AppMethodBeat.o(95040);
  }
  
  public final Bitmap getBitmap(String paramString)
  {
    AppMethodBeat.i(95041);
    if (this.xKr.aK(paramString))
    {
      localBitmap = (Bitmap)this.xKr.aJ(paramString);
      if (localBitmap != null)
      {
        ac.i("MicroMsg.SnsTimelineAdResourceMgr", "hit cache %s", new Object[] { paramString });
        AppMethodBeat.o(95041);
        return localBitmap;
      }
    }
    ac.i("MicroMsg.SnsTimelineAdResourceMgr", "not hit cache %s", new Object[] { paramString });
    Bitmap localBitmap = a.l(paramString, 0.1F);
    if (localBitmap != null) {
      this.xKr.put(paramString, localBitmap);
    }
    AppMethodBeat.o(95041);
    return localBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.d.l
 * JD-Core Version:    0.7.0.1
 */