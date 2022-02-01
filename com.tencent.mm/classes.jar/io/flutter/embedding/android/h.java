package io.flutter.embedding.android;

import android.util.LongSparseArray;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicLong;

public final class h
{
  private static h SNM;
  public final LongSparseArray<MotionEvent> SNK;
  public final PriorityQueue<Long> SNL;
  
  private h()
  {
    AppMethodBeat.i(215119);
    this.SNK = new LongSparseArray();
    this.SNL = new PriorityQueue();
    AppMethodBeat.o(215119);
  }
  
  public static h hwD()
  {
    AppMethodBeat.i(215118);
    if (SNM == null) {
      SNM = new h();
    }
    h localh = SNM;
    AppMethodBeat.o(215118);
    return localh;
  }
  
  public final a aD(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(215120);
    a locala = a.hwE();
    this.SNK.put(a.a(locala), MotionEvent.obtain(paramMotionEvent));
    this.SNL.add(Long.valueOf(a.a(locala)));
    AppMethodBeat.o(215120);
    return locala;
  }
  
  public static final class a
  {
    private static final AtomicLong SNN;
    final long id;
    
    static
    {
      AppMethodBeat.i(215098);
      SNN = new AtomicLong(0L);
      AppMethodBeat.o(215098);
    }
    
    private a(long paramLong)
    {
      this.id = paramLong;
    }
    
    public static a Pa(long paramLong)
    {
      AppMethodBeat.i(215096);
      a locala = new a(paramLong);
      AppMethodBeat.o(215096);
      return locala;
    }
    
    public static a hwE()
    {
      AppMethodBeat.i(215097);
      a locala = Pa(SNN.incrementAndGet());
      AppMethodBeat.o(215097);
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.embedding.android.h
 * JD-Core Version:    0.7.0.1
 */