package com.tencent.rtmp.a;

import android.graphics.BitmapRegionDecoder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class b$1
  implements Runnable
{
  b$1(b paramb) {}
  
  public void run()
  {
    AppMethodBeat.i(65978);
    if (b.a(this.a) != null) {
      b.a(this.a).clear();
    }
    if (b.b(this.a) != null)
    {
      Iterator localIterator = b.b(this.a).values().iterator();
      while (localIterator.hasNext())
      {
        BitmapRegionDecoder localBitmapRegionDecoder = (BitmapRegionDecoder)localIterator.next();
        if (localBitmapRegionDecoder != null) {
          localBitmapRegionDecoder.recycle();
        }
      }
      b.b(this.a).clear();
    }
    AppMethodBeat.o(65978);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.rtmp.a.b.1
 * JD-Core Version:    0.7.0.1
 */