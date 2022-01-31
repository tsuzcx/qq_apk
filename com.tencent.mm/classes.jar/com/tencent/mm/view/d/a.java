package com.tencent.mm.view.d;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.f;
import com.tencent.mm.at.a.c.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class a
  implements m
{
  private com.tencent.mm.at.a.d.a<String, Bitmap> ATY;
  
  public a()
  {
    AppMethodBeat.i(63019);
    this.ATY = new com.tencent.mm.at.a.d.a(150);
    AppMethodBeat.o(63019);
  }
  
  public final void c(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(63021);
    if (bo.isNullOrNil(paramString))
    {
      ab.w("MicroMsg.emoji.EmojiLoaderMemoryCache", "[cpan] put failed. key is null.");
      AppMethodBeat.o(63021);
      return;
    }
    if (paramBitmap == null)
    {
      ab.w("MicroMsg.emoji.EmojiLoaderMemoryCache", "[cpan] put failed.value is null.");
      AppMethodBeat.o(63021);
      return;
    }
    this.ATY.put(paramString, paramBitmap);
    AppMethodBeat.o(63021);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(63022);
    try
    {
      if (this.ATY == null) {
        break label160;
      }
      Object localObject1 = this.ATY.snapshot();
      if ((!((Map)localObject1).isEmpty()) && (((Map)localObject1).size() > 0))
      {
        localObject1 = ((Map)localObject1).entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Bitmap localBitmap = (Bitmap)((Map.Entry)((Iterator)localObject1).next()).getValue();
          if ((localBitmap != null) && (!localBitmap.isRecycled())) {
            ab.i("MicroMsg.emoji.EmojiLoaderMemoryCache", "recycle bitmap:%s, not need", new Object[] { localBitmap.toString() });
          }
        }
      }
      localObject3 = this.ATY;
    }
    finally
    {
      AppMethodBeat.o(63022);
    }
    Object localObject3;
    if (((com.tencent.mm.at.a.d.a)localObject3).eQf == null)
    {
      localObject3 = new NullPointerException("mData == null");
      AppMethodBeat.o(63022);
      throw ((Throwable)localObject3);
    }
    ((com.tencent.mm.at.a.d.a)localObject3).eQf.trimToSize(-1);
    label160:
    AppMethodBeat.o(63022);
  }
  
  public final Bitmap lK(String paramString)
  {
    AppMethodBeat.i(63020);
    if (!bo.isNullOrNil(paramString))
    {
      paramString = (Bitmap)this.ATY.get(paramString);
      AppMethodBeat.o(63020);
      return paramString;
    }
    AppMethodBeat.o(63020);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.view.d.a
 * JD-Core Version:    0.7.0.1
 */