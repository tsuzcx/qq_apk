package kotlin.l.b.a.b.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class i$e<ContainingType extends r, Type>
{
  final ContainingType abgt;
  final r abgu;
  public final i.d abgv;
  final Class abgw;
  final Method abgx;
  final Type bUV;
  
  i$e(ContainingType paramContainingType, Type paramType, r paramr, i.d paramd, Class paramClass)
  {
    AppMethodBeat.i(59475);
    if (paramContainingType == null)
    {
      paramContainingType = new IllegalArgumentException("Null containingTypeDefaultInstance");
      AppMethodBeat.o(59475);
      throw paramContainingType;
    }
    if ((paramd.abgq == aa.a.abhc) && (paramr == null))
    {
      paramContainingType = new IllegalArgumentException("Null messageDefaultInstance");
      AppMethodBeat.o(59475);
      throw paramContainingType;
    }
    this.abgt = paramContainingType;
    this.bUV = paramType;
    this.abgu = paramr;
    this.abgv = paramd;
    this.abgw = paramClass;
    if (k.a.class.isAssignableFrom(paramClass))
    {
      this.abgx = i.b(paramClass, "valueOf", new Class[] { Integer.TYPE });
      AppMethodBeat.o(59475);
      return;
    }
    this.abgx = null;
    AppMethodBeat.o(59475);
  }
  
  final Object fB(Object paramObject)
  {
    AppMethodBeat.i(268105);
    if (this.abgv.abgr)
    {
      if (this.abgv.abgq.abhk == aa.b.abht)
      {
        ArrayList localArrayList = new ArrayList();
        paramObject = ((List)paramObject).iterator();
        while (paramObject.hasNext()) {
          localArrayList.add(fC(paramObject.next()));
        }
        AppMethodBeat.o(268105);
        return localArrayList;
      }
      AppMethodBeat.o(268105);
      return paramObject;
    }
    paramObject = fC(paramObject);
    AppMethodBeat.o(268105);
    return paramObject;
  }
  
  public final Object fC(Object paramObject)
  {
    AppMethodBeat.i(59476);
    if (this.abgv.abgq.abhk == aa.b.abht)
    {
      paramObject = i.c(this.abgx, new Object[] { (Integer)paramObject });
      AppMethodBeat.o(59476);
      return paramObject;
    }
    AppMethodBeat.o(59476);
    return paramObject;
  }
  
  final Object fD(Object paramObject)
  {
    AppMethodBeat.i(59477);
    if (this.abgv.abgq.abhk == aa.b.abht)
    {
      int i = ((k.a)paramObject).getNumber();
      AppMethodBeat.o(59477);
      return Integer.valueOf(i);
    }
    AppMethodBeat.o(59477);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.h.i.e
 * JD-Core Version:    0.7.0.1
 */