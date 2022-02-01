package com.tencent.xweb.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import org.xwalk.core.XWalkEnvironment;

public final class j$a
{
  public List<i> aaeZ;
  public String fSV;
  
  public final boolean K(double paramDouble)
  {
    AppMethodBeat.i(197597);
    if (this.aaeZ == null)
    {
      AppMethodBeat.o(197597);
      return false;
    }
    Iterator localIterator = this.aaeZ.iterator();
    while (localIterator.hasNext())
    {
      i locali = (i)localIterator.next();
      if ((locali.aaeW <= paramDouble) && (locali.aaeX >= paramDouble))
      {
        if (XWalkEnvironment.getTodayGrayValue() < 10000.0D * locali.J(paramDouble))
        {
          AppMethodBeat.o(197597);
          return true;
        }
        AppMethodBeat.o(197597);
        return false;
      }
    }
    AppMethodBeat.o(197597);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.internal.j.a
 * JD-Core Version:    0.7.0.1
 */