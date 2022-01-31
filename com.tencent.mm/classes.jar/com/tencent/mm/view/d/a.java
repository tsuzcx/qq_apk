package com.tencent.mm.view.d;

import android.graphics.Bitmap;
import com.tencent.mm.as.a.c.m;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class a
  implements m
{
  private com.tencent.mm.as.a.d.a<String, Bitmap> erL = new com.tencent.mm.as.a.d.a(150);
  
  public final void c(String paramString, Bitmap paramBitmap)
  {
    if (bk.bl(paramString))
    {
      y.w("MicroMsg.emoji.EmojiLoaderMemoryCache", "[cpan] put failed. key is null.");
      return;
    }
    if (paramBitmap == null)
    {
      y.w("MicroMsg.emoji.EmojiLoaderMemoryCache", "[cpan] put failed.value is null.");
      return;
    }
    this.erL.put(paramString, paramBitmap);
  }
  
  public final void clear()
  {
    try
    {
      if (this.erL != null)
      {
        Object localObject1 = this.erL.snapshot();
        if ((!((Map)localObject1).isEmpty()) && (((Map)localObject1).size() > 0))
        {
          localObject1 = ((Map)localObject1).entrySet().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            Bitmap localBitmap = (Bitmap)((Map.Entry)((Iterator)localObject1).next()).getValue();
            if ((localBitmap != null) && (!localBitmap.isRecycled())) {
              y.i("MicroMsg.emoji.EmojiLoaderMemoryCache", "recycle bitmap:%s, not need", new Object[] { localBitmap.toString() });
            }
          }
        }
        this.erL.clear();
      }
    }
    finally {}
  }
  
  public final Bitmap jK(String paramString)
  {
    if (!bk.bl(paramString)) {
      return (Bitmap)this.erL.get(paramString);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.view.d.a
 * JD-Core Version:    0.7.0.1
 */