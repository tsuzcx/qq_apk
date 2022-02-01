package com.tencent.mm.view.c;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.c.o;
import com.tencent.mm.b.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class a
  implements o
{
  private com.tencent.mm.av.a.d.a<String, Bitmap> Rpz;
  
  public a()
  {
    AppMethodBeat.i(105276);
    this.Rpz = new com.tencent.mm.av.a.d.a(150);
    AppMethodBeat.o(105276);
  }
  
  public final Bitmap EP(String paramString)
  {
    AppMethodBeat.i(105277);
    if (!Util.isNullOrNil(paramString))
    {
      paramString = (Bitmap)this.Rpz.get(paramString);
      AppMethodBeat.o(105277);
      return paramString;
    }
    AppMethodBeat.o(105277);
    return null;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(105279);
    try
    {
      if (this.Rpz == null) {
        break label160;
      }
      Object localObject1 = this.Rpz.snapshot();
      if ((!((Map)localObject1).isEmpty()) && (((Map)localObject1).size() > 0))
      {
        localObject1 = ((Map)localObject1).entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Bitmap localBitmap = (Bitmap)((Map.Entry)((Iterator)localObject1).next()).getValue();
          if ((localBitmap != null) && (!localBitmap.isRecycled())) {
            Log.i("MicroMsg.emoji.EmojiLoaderMemoryCache", "recycle bitmap:%s, not need", new Object[] { localBitmap.toString() });
          }
        }
      }
      localObject3 = this.Rpz;
    }
    finally
    {
      AppMethodBeat.o(105279);
    }
    Object localObject3;
    if (((com.tencent.mm.av.a.d.a)localObject3).icd == null)
    {
      localObject3 = new NullPointerException("mData == null");
      AppMethodBeat.o(105279);
      throw ((Throwable)localObject3);
    }
    ((com.tencent.mm.av.a.d.a)localObject3).icd.trimToSize(-1);
    label160:
    AppMethodBeat.o(105279);
  }
  
  public final void put(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(105278);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.emoji.EmojiLoaderMemoryCache", "[cpan] put failed. key is null.");
      AppMethodBeat.o(105278);
      return;
    }
    if (paramBitmap == null)
    {
      Log.w("MicroMsg.emoji.EmojiLoaderMemoryCache", "[cpan] put failed.value is null.");
      AppMethodBeat.o(105278);
      return;
    }
    this.Rpz.put(paramString, paramBitmap);
    AppMethodBeat.o(105278);
  }
  
  public final void remove(String paramString)
  {
    AppMethodBeat.i(199830);
    com.tencent.mm.av.a.d.a locala = this.Rpz;
    if (locala.icd == null)
    {
      paramString = new NullPointerException("mData == null");
      AppMethodBeat.o(199830);
      throw paramString;
    }
    locala.icd.remove(paramString);
    AppMethodBeat.o(199830);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.view.c.a
 * JD-Core Version:    0.7.0.1
 */