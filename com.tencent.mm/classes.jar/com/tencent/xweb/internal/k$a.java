package com.tencent.xweb.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import org.xwalk.core.XWalkGrayValueUtil;

public final class k$a
{
  public List<j> aikj;
  public String hYT;
  
  public final boolean af(double paramDouble)
  {
    AppMethodBeat.i(212571);
    if (this.aikj == null)
    {
      AppMethodBeat.o(212571);
      return false;
    }
    Iterator localIterator = this.aikj.iterator();
    while (localIterator.hasNext())
    {
      j localj = (j)localIterator.next();
      if ((localj.aikg <= paramDouble) && (localj.aikh >= paramDouble))
      {
        if (XWalkGrayValueUtil.getTodayGrayValue() < 10000.0D * localj.ae(paramDouble))
        {
          AppMethodBeat.o(212571);
          return true;
        }
        AppMethodBeat.o(212571);
        return false;
      }
    }
    AppMethodBeat.o(212571);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.internal.k.a
 * JD-Core Version:    0.7.0.1
 */