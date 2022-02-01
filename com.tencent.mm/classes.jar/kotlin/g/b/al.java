package kotlin.g.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;

public final class al
{
  public final ArrayList<Object> hqL;
  
  public al(int paramInt)
  {
    AppMethodBeat.i(128982);
    this.hqL = new ArrayList(paramInt);
    AppMethodBeat.o(128982);
  }
  
  public final void add(Object paramObject)
  {
    AppMethodBeat.i(128984);
    this.hqL.add(paramObject);
    AppMethodBeat.o(128984);
  }
  
  public final void hx(Object paramObject)
  {
    AppMethodBeat.i(128983);
    if (paramObject == null)
    {
      AppMethodBeat.o(128983);
      return;
    }
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      if (paramObject.length > 0)
      {
        this.hqL.ensureCapacity(this.hqL.size() + paramObject.length);
        Collections.addAll(this.hqL, paramObject);
      }
      AppMethodBeat.o(128983);
      return;
    }
    paramObject = new UnsupportedOperationException("Don't know how to spread " + paramObject.getClass());
    AppMethodBeat.o(128983);
    throw paramObject;
  }
  
  public final Object[] toArray(Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(128985);
    paramArrayOfObject = this.hqL.toArray(paramArrayOfObject);
    AppMethodBeat.o(128985);
    return paramArrayOfObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.g.b.al
 * JD-Core Version:    0.7.0.1
 */