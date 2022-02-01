package d.g.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;

public final class ac
{
  public final ArrayList<Object> dbZ;
  
  public ac(int paramInt)
  {
    AppMethodBeat.i(128982);
    this.dbZ = new ArrayList(paramInt);
    AppMethodBeat.o(128982);
  }
  
  public final void add(Object paramObject)
  {
    AppMethodBeat.i(128984);
    this.dbZ.add(paramObject);
    AppMethodBeat.o(128984);
  }
  
  public final void eO(Object paramObject)
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
        this.dbZ.ensureCapacity(this.dbZ.size() + paramObject.length);
        Collections.addAll(this.dbZ, paramObject);
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
    paramArrayOfObject = this.dbZ.toArray(paramArrayOfObject);
    AppMethodBeat.o(128985);
    return paramArrayOfObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.g.b.ac
 * JD-Core Version:    0.7.0.1
 */