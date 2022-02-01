package j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lokio/SegmentPool;", "", "()V", "HASH_BUCKET_COUNT", "", "LOCK", "Lokio/Segment;", "MAX_SIZE", "getMAX_SIZE", "()I", "byteCount", "getByteCount", "hashBuckets", "", "Ljava/util/concurrent/atomic/AtomicReference;", "[Ljava/util/concurrent/atomic/AtomicReference;", "firstRef", "recycle", "", "segment", "take", "okio"}, k=1, mv={1, 4, 1})
public final class w
{
  private static final int MAX_SIZE;
  private static final v ajTA;
  private static final int ajTB;
  private static final AtomicReference<v>[] ajTC;
  public static final w ajTD;
  
  static
  {
    int i = 0;
    AppMethodBeat.i(186503);
    ajTD = new w();
    MAX_SIZE = 65536;
    ajTA = new v(new byte[0], 0, 0, false);
    int j = Integer.highestOneBit(Runtime.getRuntime().availableProcessors() * 2 - 1);
    ajTB = j;
    AtomicReference[] arrayOfAtomicReference = new AtomicReference[j];
    while (i < j)
    {
      arrayOfAtomicReference[i] = new AtomicReference();
      i += 1;
    }
    ajTC = arrayOfAtomicReference;
    AppMethodBeat.o(186503);
  }
  
  public static final void b(v paramv)
  {
    AppMethodBeat.i(186494);
    s.u(paramv, "segment");
    if ((paramv.ajTx == null) && (paramv.ajTy == null)) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramv = (Throwable)new IllegalArgumentException("Failed requirement.".toString());
      AppMethodBeat.o(186494);
      throw paramv;
    }
    if (paramv.ajwa)
    {
      AppMethodBeat.o(186494);
      return;
    }
    AtomicReference localAtomicReference = kJc();
    v localv = (v)localAtomicReference.get();
    if (localv == ajTA)
    {
      AppMethodBeat.o(186494);
      return;
    }
    if (localv != null) {}
    for (i = localv.limit; i >= MAX_SIZE; i = 0)
    {
      AppMethodBeat.o(186494);
      return;
    }
    paramv.ajTx = localv;
    paramv.pos = 0;
    paramv.limit = (i + 8192);
    if (!localAtomicReference.compareAndSet(localv, paramv)) {
      paramv.ajTx = null;
    }
    AppMethodBeat.o(186494);
  }
  
  public static final v kJb()
  {
    AppMethodBeat.i(186293);
    Object localObject = kJc();
    v localv = (v)((AtomicReference)localObject).getAndSet(ajTA);
    if (localv == ajTA)
    {
      localObject = new v();
      AppMethodBeat.o(186293);
      return localObject;
    }
    if (localv == null)
    {
      ((AtomicReference)localObject).set(null);
      localObject = new v();
      AppMethodBeat.o(186293);
      return localObject;
    }
    ((AtomicReference)localObject).set(localv.ajTx);
    localv.ajTx = null;
    localv.limit = 0;
    AppMethodBeat.o(186293);
    return localv;
  }
  
  private static AtomicReference<v> kJc()
  {
    AppMethodBeat.i(186499);
    Object localObject = Thread.currentThread();
    s.s(localObject, "Thread.currentThread()");
    int i = (int)(((Thread)localObject).getId() & ajTB - 1L);
    localObject = ajTC[i];
    AppMethodBeat.o(186499);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     j.w
 * JD-Core Version:    0.7.0.1
 */