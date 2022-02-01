package com.tencent.tavkit.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListUtils
{
  public static <T> List<T> listWithObjects(T... paramVarArgs)
  {
    AppMethodBeat.i(204798);
    paramVarArgs = new ArrayList(Arrays.asList(paramVarArgs));
    AppMethodBeat.o(204798);
    return paramVarArgs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tavkit.utils.ListUtils
 * JD-Core Version:    0.7.0.1
 */