package kotlin.g.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;

public final class ad
{
  public final ArrayList<Object> dtS;
  
  public ad(int paramInt)
  {
    AppMethodBeat.i(128982);
    this.dtS = new ArrayList(paramInt);
    AppMethodBeat.o(128982);
  }
  
  public final void add(Object paramObject)
  {
    AppMethodBeat.i(128984);
    this.dtS.add(paramObject);
    AppMethodBeat.o(128984);
  }
  
  public final void eS(Object paramObject)
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
        this.dtS.ensureCapacity(this.dtS.size() + paramObject.length);
        Collections.addAll(this.dtS, paramObject);
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
    paramArrayOfObject = this.dtS.toArray(paramArrayOfObject);
    AppMethodBeat.o(128985);
    return paramArrayOfObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.g.b.ad
 * JD-Core Version:    0.7.0.1
 */