package com.tencent.ttpic.baseutils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;

public class BaseUtils
{
  public static boolean equals(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    AppMethodBeat.i(49593);
    if ((paramCharSequence1 != null) && (paramCharSequence1.equals(paramCharSequence2)))
    {
      AppMethodBeat.o(49593);
      return true;
    }
    AppMethodBeat.o(49593);
    return false;
  }
  
  public static boolean indexOutOfBounds(Collection paramCollection, int paramInt)
  {
    AppMethodBeat.i(49594);
    if ((paramCollection == null) || (paramInt < 0) || (paramInt >= paramCollection.size()))
    {
      AppMethodBeat.o(49594);
      return true;
    }
    AppMethodBeat.o(49594);
    return false;
  }
  
  public static boolean isEmpty(Collection paramCollection)
  {
    AppMethodBeat.i(49591);
    if ((paramCollection == null) || (paramCollection.isEmpty()))
    {
      AppMethodBeat.o(49591);
      return true;
    }
    AppMethodBeat.o(49591);
    return false;
  }
  
  public static int size(Collection paramCollection)
  {
    AppMethodBeat.i(49592);
    if (paramCollection == null)
    {
      AppMethodBeat.o(49592);
      return 0;
    }
    int i = paramCollection.size();
    AppMethodBeat.o(49592);
    return i;
  }
  
  public static int size(Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject == null) {
      return 0;
    }
    return paramArrayOfObject.length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.ttpic.baseutils.BaseUtils
 * JD-Core Version:    0.7.0.1
 */