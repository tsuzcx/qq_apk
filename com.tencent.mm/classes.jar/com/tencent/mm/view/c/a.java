package com.tencent.mm.view.c;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.c.o;
import com.tencent.mm.b.f;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class a
  implements o
{
  private com.tencent.mm.av.a.d.a<String, Bitmap> LQQ;
  
  public a()
  {
    AppMethodBeat.i(105276);
    this.LQQ = new com.tencent.mm.av.a.d.a(150);
    AppMethodBeat.o(105276);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(105279);
    try
    {
      if (this.LQQ == null) {
        break label160;
      }
      Object localObject1 = this.LQQ.snapshot();
      if ((!((Map)localObject1).isEmpty()) && (((Map)localObject1).size() > 0))
      {
        localObject1 = ((Map)localObject1).entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Bitmap localBitmap = (Bitmap)((Map.Entry)((Iterator)localObject1).next()).getValue();
          if ((localBitmap != null) && (!localBitmap.isRecycled())) {
            ae.i("MicroMsg.emoji.EmojiLoaderMemoryCache", "recycle bitmap:%s, not need", new Object[] { localBitmap.toString() });
          }
        }
      }
      localObject3 = this.LQQ;
    }
    finally
    {
      AppMethodBeat.o(105279);
    }
    Object localObject3;
    if (((com.tencent.mm.av.a.d.a)localObject3).hjg == null)
    {
      localObject3 = new NullPointerException("mData == null");
      AppMethodBeat.o(105279);
      throw ((Throwable)localObject3);
    }
    ((com.tencent.mm.av.a.d.a)localObject3).hjg.trimToSize(-1);
    label160:
    AppMethodBeat.o(105279);
  }
  
  public final void put(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(105278);
    if (bu.isNullOrNil(paramString))
    {
      ae.w("MicroMsg.emoji.EmojiLoaderMemoryCache", "[cpan] put failed. key is null.");
      AppMethodBeat.o(105278);
      return;
    }
    if (paramBitmap == null)
    {
      ae.w("MicroMsg.emoji.EmojiLoaderMemoryCache", "[cpan] put failed.value is null.");
      AppMethodBeat.o(105278);
      return;
    }
    this.LQQ.put(paramString, paramBitmap);
    AppMethodBeat.o(105278);
  }
  
  public final Bitmap wA(String paramString)
  {
    AppMethodBeat.i(105277);
    if (!bu.isNullOrNil(paramString))
    {
      paramString = (Bitmap)this.LQQ.get(paramString);
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