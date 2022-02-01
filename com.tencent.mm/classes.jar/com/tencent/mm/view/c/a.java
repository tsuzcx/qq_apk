package com.tencent.mm.view.c;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a.c.o;
import com.tencent.mm.b.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class a
  implements o
{
  private com.tencent.mm.aw.a.d.a<String, Bitmap> Iag;
  
  public a()
  {
    AppMethodBeat.i(105276);
    this.Iag = new com.tencent.mm.aw.a.d.a(150);
    AppMethodBeat.o(105276);
  }
  
  public final void c(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(105278);
    if (bt.isNullOrNil(paramString))
    {
      ad.w("MicroMsg.emoji.EmojiLoaderMemoryCache", "[cpan] put failed. key is null.");
      AppMethodBeat.o(105278);
      return;
    }
    if (paramBitmap == null)
    {
      ad.w("MicroMsg.emoji.EmojiLoaderMemoryCache", "[cpan] put failed.value is null.");
      AppMethodBeat.o(105278);
      return;
    }
    this.Iag.put(paramString, paramBitmap);
    AppMethodBeat.o(105278);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(105279);
    try
    {
      if (this.Iag == null) {
        break label160;
      }
      Object localObject1 = this.Iag.snapshot();
      if ((!((Map)localObject1).isEmpty()) && (((Map)localObject1).size() > 0))
      {
        localObject1 = ((Map)localObject1).entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Bitmap localBitmap = (Bitmap)((Map.Entry)((Iterator)localObject1).next()).getValue();
          if ((localBitmap != null) && (!localBitmap.isRecycled())) {
            ad.i("MicroMsg.emoji.EmojiLoaderMemoryCache", "recycle bitmap:%s, not need", new Object[] { localBitmap.toString() });
          }
        }
      }
      localObject3 = this.Iag;
    }
    finally
    {
      AppMethodBeat.o(105279);
    }
    Object localObject3;
    if (((com.tencent.mm.aw.a.d.a)localObject3).glI == null)
    {
      localObject3 = new NullPointerException("mData == null");
      AppMethodBeat.o(105279);
      throw ((Throwable)localObject3);
    }
    ((com.tencent.mm.aw.a.d.a)localObject3).glI.trimToSize(-1);
    label160:
    AppMethodBeat.o(105279);
  }
  
  public final Bitmap pT(String paramString)
  {
    AppMethodBeat.i(105277);
    if (!bt.isNullOrNil(paramString))
    {
      paramString = (Bitmap)this.Iag.get(paramString);
      AppMethodBeat.o(105277);
      return paramString;
    }
    AppMethodBeat.o(105277);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.c.a
 * JD-Core Version:    0.7.0.1
 */