package com.tencent.mm.view.c;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.a.c.o;
import com.tencent.mm.b.f;
import com.tencent.mm.f.a.mv;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class a
  implements o
{
  private static a YQV = null;
  private com.tencent.mm.ay.a.d.a<String, Bitmap> YQU;
  
  public a()
  {
    AppMethodBeat.i(105276);
    this.YQU = new com.tencent.mm.ay.a.d.a(150);
    if (YQV != null) {
      YQV.dead();
    }
    a locala = new a(this);
    YQV = locala;
    locala.alive();
    AppMethodBeat.o(105276);
  }
  
  public final Bitmap LI(String paramString)
  {
    AppMethodBeat.i(105277);
    if (!Util.isNullOrNil(paramString))
    {
      paramString = (Bitmap)this.YQU.get(paramString);
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
      if (this.YQU != null)
      {
        Object localObject1 = this.YQU.snapshot();
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
        this.YQU.clear();
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
    this.YQU.put(paramString, paramBitmap);
    AppMethodBeat.o(105278);
  }
  
  public final void remove(String paramString)
  {
    AppMethodBeat.i(227509);
    com.tencent.mm.ay.a.d.a locala = this.YQU;
    if (locala.kQK == null)
    {
      paramString = new NullPointerException("mData == null");
      AppMethodBeat.o(227509);
      throw paramString;
    }
    locala.kQK.remove(paramString);
    AppMethodBeat.o(227509);
  }
  
  static final class a
    extends IListener<mv>
  {
    private final WeakReference<a> kNt;
    
    public a(a parama)
    {
      AppMethodBeat.i(233031);
      this.kNt = new WeakReference(parama);
      this.__eventId = mv.class.getName().hashCode();
      AppMethodBeat.o(233031);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.view.c.a
 * JD-Core Version:    0.7.0.1
 */