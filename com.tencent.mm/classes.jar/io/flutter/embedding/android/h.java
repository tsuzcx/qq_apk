package io.flutter.embedding.android;

import android.util.LongSparseArray;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicLong;

public final class h
{
  private static h aapK;
  public final LongSparseArray<MotionEvent> aapI;
  public final PriorityQueue<Long> aapJ;
  
  private h()
  {
    AppMethodBeat.i(254327);
    this.aapI = new LongSparseArray();
    this.aapJ = new PriorityQueue();
    AppMethodBeat.o(254327);
  }
  
  public static h iAH()
  {
    AppMethodBeat.i(254326);
    if (aapK == null) {
      aapK = new h();
    }
    h localh = aapK;
    AppMethodBeat.o(254326);
    return localh;
  }
  
  public final a aL(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(254328);
    a locala = a.iAI();
    this.aapI.put(a.a(locala), MotionEvent.obtain(paramMotionEvent));
    this.aapJ.add(Long.valueOf(a.a(locala)));
    AppMethodBeat.o(254328);
    return locala;
  }
  
  public static final class a
  {
    private static final AtomicLong aapL;
    final long id;
    
    static
    {
      AppMethodBeat.i(255722);
      aapL = new AtomicLong(0L);
      AppMethodBeat.o(255722);
    }
    
    private a(long paramLong)
    {
      this.id = paramLong;
    }
    
    public static a Xq(long paramLong)
    {
      AppMethodBeat.i(255719);
      a locala = new a(paramLong);
      AppMethodBeat.o(255719);
      return locala;
    }
    
    public static a iAI()
    {
      AppMethodBeat.i(255720);
      a locala = Xq(aapL.incrementAndGet());
      AppMethodBeat.o(255720);
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.embedding.android.h
 * JD-Core Version:    0.7.0.1
 */