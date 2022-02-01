package io.flutter.embedding.android;

import android.util.LongSparseArray;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicLong;

public final class MotionEventTracker
{
  private static MotionEventTracker INSTANCE;
  private final LongSparseArray<MotionEvent> eventById;
  private final PriorityQueue<Long> unusedEvents;
  
  private MotionEventTracker()
  {
    AppMethodBeat.i(190468);
    this.eventById = new LongSparseArray();
    this.unusedEvents = new PriorityQueue();
    AppMethodBeat.o(190468);
  }
  
  public static MotionEventTracker getInstance()
  {
    AppMethodBeat.i(190462);
    if (INSTANCE == null) {
      INSTANCE = new MotionEventTracker();
    }
    MotionEventTracker localMotionEventTracker = INSTANCE;
    AppMethodBeat.o(190462);
    return localMotionEventTracker;
  }
  
  public final MotionEvent pop(MotionEventId paramMotionEventId)
  {
    AppMethodBeat.i(190486);
    while ((!this.unusedEvents.isEmpty()) && (((Long)this.unusedEvents.peek()).longValue() < paramMotionEventId.id)) {
      this.eventById.remove(((Long)this.unusedEvents.poll()).longValue());
    }
    if ((!this.unusedEvents.isEmpty()) && (((Long)this.unusedEvents.peek()).longValue() == paramMotionEventId.id)) {
      this.unusedEvents.poll();
    }
    MotionEvent localMotionEvent = (MotionEvent)this.eventById.get(paramMotionEventId.id);
    this.eventById.remove(paramMotionEventId.id);
    AppMethodBeat.o(190486);
    return localMotionEvent;
  }
  
  public final MotionEventId track(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(190480);
    MotionEventId localMotionEventId = MotionEventId.createUnique();
    this.eventById.put(localMotionEventId.id, MotionEvent.obtain(paramMotionEvent));
    this.unusedEvents.add(Long.valueOf(localMotionEventId.id));
    AppMethodBeat.o(190480);
    return localMotionEventId;
  }
  
  public static class MotionEventId
  {
    private static final AtomicLong ID_COUNTER;
    private final long id;
    
    static
    {
      AppMethodBeat.i(190397);
      ID_COUNTER = new AtomicLong(0L);
      AppMethodBeat.o(190397);
    }
    
    private MotionEventId(long paramLong)
    {
      this.id = paramLong;
    }
    
    public static MotionEventId createUnique()
    {
      AppMethodBeat.i(190382);
      MotionEventId localMotionEventId = from(ID_COUNTER.incrementAndGet());
      AppMethodBeat.o(190382);
      return localMotionEventId;
    }
    
    public static MotionEventId from(long paramLong)
    {
      AppMethodBeat.i(190378);
      MotionEventId localMotionEventId = new MotionEventId(paramLong);
      AppMethodBeat.o(190378);
      return localMotionEventId;
    }
    
    public long getId()
    {
      return this.id;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     io.flutter.embedding.android.MotionEventTracker
 * JD-Core Version:    0.7.0.1
 */