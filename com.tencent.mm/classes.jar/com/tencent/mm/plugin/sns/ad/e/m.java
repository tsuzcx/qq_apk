package com.tencent.mm.plugin.sns.ad.e;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.a.a.a.g;
import com.tencent.mm.plugin.sns.d.a;
import com.tencent.mm.sdk.platformtools.ae;

public final class m
{
  public static m zqi;
  public g<String, Bitmap> zqh;
  
  static
  {
    AppMethodBeat.i(95042);
    zqi = new m();
    AppMethodBeat.o(95042);
  }
  
  private m()
  {
    AppMethodBeat.i(95040);
    this.zqh = new g(5);
    AppMethodBeat.o(95040);
  }
  
  public final Bitmap getBitmap(String paramString)
  {
    AppMethodBeat.i(95041);
    if (this.zqh.aM(paramString))
    {
      localBitmap = (Bitmap)this.zqh.aL(paramString);
      if (localBitmap != null)
      {
        ae.i("MicroMsg.SnsTimelineAdResourceMgr", "hit cache %s", new Object[] { paramString });
        AppMethodBeat.o(95041);
        return localBitmap;
      }
    }
    ae.i("MicroMsg.SnsTimelineAdResourceMgr", "not hit cache %s", new Object[] { paramString });
    Bitmap localBitmap = a.m(paramString, 0.1F);
    if (localBitmap != null) {
      this.zqh.put(paramString, localBitmap);
    }
    AppMethodBeat.o(95041);
    return localBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.e.m
 * JD-Core Version:    0.7.0.1
 */