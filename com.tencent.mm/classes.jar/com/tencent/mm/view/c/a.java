package com.tencent.mm.view.c;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.c.o;
import com.tencent.mm.b.f;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class a
  implements o
{
  private com.tencent.mm.av.a.d.a<String, Bitmap> JAW;
  
  public a()
  {
    AppMethodBeat.i(105276);
    this.JAW = new com.tencent.mm.av.a.d.a(150);
    AppMethodBeat.o(105276);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(105279);
    try
    {
      if (this.JAW == null) {
        break label160;
      }
      Object localObject1 = this.JAW.snapshot();
      if ((!((Map)localObject1).isEmpty()) && (((Map)localObject1).size() > 0))
      {
        localObject1 = ((Map)localObject1).entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Bitmap localBitmap = (Bitmap)((Map.Entry)((Iterator)localObject1).next()).getValue();
          if ((localBitmap != null) && (!localBitmap.isRecycled())) {
            ac.i("MicroMsg.emoji.EmojiLoaderMemoryCache", "recycle bitmap:%s, not need", new Object[] { localBitmap.toString() });
          }
        }
      }
      localObject3 = this.JAW;
    }
    finally
    {
      AppMethodBeat.o(105279);
    }
    Object localObject3;
    if (((com.tencent.mm.av.a.d.a)localObject3).gMv == null)
    {
      localObject3 = new NullPointerException("mData == null");
      AppMethodBeat.o(105279);
      throw ((Throwable)localObject3);
    }
    ((com.tencent.mm.av.a.d.a)localObject3).gMv.trimToSize(-1);
    label160:
    AppMethodBeat.o(105279);
  }
  
  public final void put(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(105278);
    if (bs.isNullOrNil(paramString))
    {
      ac.w("MicroMsg.emoji.EmojiLoaderMemoryCache", "[cpan] put failed. key is null.");
      AppMethodBeat.o(105278);
      return;
    }
    if (paramBitmap == null)
    {
      ac.w("MicroMsg.emoji.EmojiLoaderMemoryCache", "[cpan] put failed.value is null.");
      AppMethodBeat.o(105278);
      return;
    }
    this.JAW.put(paramString, paramBitmap);
    AppMethodBeat.o(105278);
  }
  
  public final Bitmap te(String paramString)
  {
    AppMethodBeat.i(105277);
    if (!bs.isNullOrNil(paramString))
    {
      paramString = (Bitmap)this.JAW.get(paramString);
      AppMethodBeat.o(105277);
      return paramString;
    }
    AppMethodBeat.o(105277);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.view.c.a
 * JD-Core Version:    0.7.0.1
 */