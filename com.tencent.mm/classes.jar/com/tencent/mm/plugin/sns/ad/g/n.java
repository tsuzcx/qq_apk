package com.tencent.mm.plugin.sns.ad.g;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.a.a.a.g;
import com.tencent.mm.plugin.sns.d.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class n
{
  public static n Dwr;
  public g<String, Bitmap> Dwq;
  
  static
  {
    AppMethodBeat.i(95042);
    Dwr = new n();
    AppMethodBeat.o(95042);
  }
  
  private n()
  {
    AppMethodBeat.i(95040);
    this.Dwq = new g(5);
    AppMethodBeat.o(95040);
  }
  
  public final Bitmap getBitmap(String paramString)
  {
    AppMethodBeat.i(95041);
    if (this.Dwq.check(paramString))
    {
      localBitmap = (Bitmap)this.Dwq.aT(paramString);
      if (localBitmap != null)
      {
        Log.i("MicroMsg.SnsTimelineAdResourceMgr", "hit cache %s", new Object[] { paramString });
        AppMethodBeat.o(95041);
        return localBitmap;
      }
    }
    Log.i("MicroMsg.SnsTimelineAdResourceMgr", "not hit cache %s", new Object[] { paramString });
    Bitmap localBitmap = a.k(paramString, 0.1F);
    if (localBitmap != null) {
      this.Dwq.put(paramString, localBitmap);
    }
    AppMethodBeat.o(95041);
    return localBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.g.n
 * JD-Core Version:    0.7.0.1
 */