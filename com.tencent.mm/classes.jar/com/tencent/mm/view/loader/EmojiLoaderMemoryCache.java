package com.tencent.mm.view.loader;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.oc;
import com.tencent.mm.modelimage.loader.b.o;
import com.tencent.mm.modelimage.loader.c.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class EmojiLoaderMemoryCache
  implements o
{
  private static MMTrimMemoryEventListener agMB = null;
  private a<String, Bitmap> agMA;
  
  public EmojiLoaderMemoryCache()
  {
    AppMethodBeat.i(105276);
    this.agMA = new a(150);
    if (agMB != null) {
      agMB.dead();
    }
    MMTrimMemoryEventListener localMMTrimMemoryEventListener = new MMTrimMemoryEventListener(this);
    agMB = localMMTrimMemoryEventListener;
    localMMTrimMemoryEventListener.alive();
    AppMethodBeat.o(105276);
  }
  
  public final Bitmap Eo(String paramString)
  {
    AppMethodBeat.i(105277);
    if (!Util.isNullOrNil(paramString))
    {
      paramString = (Bitmap)this.agMA.get(paramString);
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
      if (this.agMA != null)
      {
        Object localObject1 = this.agMA.snapshot();
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
        this.agMA.clear();
      }
    }
    finally
    {
      AppMethodBeat.o(105279);
    }
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
    this.agMA.put(paramString, paramBitmap);
    AppMethodBeat.o(105278);
  }
  
  public final void remove(String paramString)
  {
    AppMethodBeat.i(234810);
    a locala = this.agMA;
    if (locala.nsn == null)
    {
      paramString = new NullPointerException("mData == null");
      AppMethodBeat.o(234810);
      throw paramString;
    }
    locala.nsn.remove(paramString);
    AppMethodBeat.o(234810);
  }
  
  static class MMTrimMemoryEventListener
    extends IListener<oc>
  {
    private final WeakReference<EmojiLoaderMemoryCache> nph;
    
    public MMTrimMemoryEventListener(EmojiLoaderMemoryCache paramEmojiLoaderMemoryCache)
    {
      super();
      AppMethodBeat.i(234790);
      this.nph = new WeakReference(paramEmojiLoaderMemoryCache);
      this.__eventId = oc.class.getName().hashCode();
      AppMethodBeat.o(234790);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.view.loader.EmojiLoaderMemoryCache
 * JD-Core Version:    0.7.0.1
 */