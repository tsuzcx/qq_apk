package com.tencent.tavkit.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListUtils
{
  public static <T> List<T> listWithObjects(T... paramVarArgs)
  {
    AppMethodBeat.i(219972);
    paramVarArgs = new ArrayList(Arrays.asList(paramVarArgs));
    AppMethodBeat.o(219972);
    return paramVarArgs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tavkit.utils.ListUtils
 * JD-Core Version:    0.7.0.1
 */