package com.tencent.xweb.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import org.xwalk.core.XWalkEnvironment;

public final class j
{
  public static final class a
  {
    public List<i> SDP;
    public String dZc;
    
    public final boolean I(double paramDouble)
    {
      AppMethodBeat.i(219073);
      if (this.SDP == null)
      {
        AppMethodBeat.o(219073);
        return false;
      }
      Iterator localIterator = this.SDP.iterator();
      while (localIterator.hasNext())
      {
        i locali = (i)localIterator.next();
        if ((locali.SDM <= paramDouble) && (locali.SDN >= paramDouble))
        {
          if (XWalkEnvironment.getTodayGrayValue() < 10000.0D * locali.H(paramDouble))
          {
            AppMethodBeat.o(219073);
            return true;
          }
          AppMethodBeat.o(219073);
          return false;
        }
      }
      AppMethodBeat.o(219073);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.internal.j
 * JD-Core Version:    0.7.0.1
 */