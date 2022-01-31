package com.tencent.mm.plugin.sns.a.b;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.a.a.a.g;
import com.tencent.mm.memory.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.d;

public final class j
{
  public static j rac;
  public g<String, Bitmap> rab;
  
  static
  {
    AppMethodBeat.i(145241);
    rac = new j();
    AppMethodBeat.o(145241);
  }
  
  private j()
  {
    AppMethodBeat.i(145239);
    this.rab = new g(5);
    AppMethodBeat.o(145239);
  }
  
  public final Bitmap getBitmap(String paramString)
  {
    AppMethodBeat.i(145240);
    Bitmap localBitmap1;
    if (this.rab.Z(paramString))
    {
      localBitmap1 = (Bitmap)this.rab.Y(paramString);
      if (localBitmap1 != null)
      {
        ab.i("MicroMsg.SnsTimelineAdResourceMgr", "hit cache %s", new Object[] { paramString });
        AppMethodBeat.o(145240);
        return localBitmap1;
      }
    }
    ab.i("MicroMsg.SnsTimelineAdResourceMgr", "not hit cache %s", new Object[] { paramString });
    long l = System.currentTimeMillis();
    Bitmap localBitmap2 = l.XQ().a(paramString, null);
    if (localBitmap2 != null)
    {
      localBitmap1 = d.a(localBitmap2, true, 0.1F * localBitmap2.getWidth());
      ab.d("MicroMsg.SnsBitmapUtil", "decode used %dms %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), localBitmap2 });
    }
    for (;;)
    {
      if (localBitmap1 != null) {
        this.rab.put(paramString, localBitmap1);
      }
      AppMethodBeat.o(145240);
      return localBitmap1;
      localBitmap1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.a.b.j
 * JD-Core Version:    0.7.0.1
 */