package d.g.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;

public final class y
{
  public final ArrayList<Object> cQJ;
  
  public y(int paramInt)
  {
    AppMethodBeat.i(128982);
    this.cQJ = new ArrayList(paramInt);
    AppMethodBeat.o(128982);
  }
  
  public final void add(Object paramObject)
  {
    AppMethodBeat.i(128984);
    this.cQJ.add(paramObject);
    AppMethodBeat.o(128984);
  }
  
  public final void eL(Object paramObject)
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
        this.cQJ.ensureCapacity(this.cQJ.size() + paramObject.length);
        Collections.addAll(this.cQJ, paramObject);
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
    paramArrayOfObject = this.cQJ.toArray(paramArrayOfObject);
    AppMethodBeat.o(128985);
    return paramArrayOfObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.g.b.y
 * JD-Core Version:    0.7.0.1
 */