package com.tencent.tavkit.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListUtils
{
  public static <T> List<T> listWithObjects(T... paramVarArgs)
  {
    AppMethodBeat.i(192170);
    paramVarArgs = new ArrayList(Arrays.asList(paramVarArgs));
    AppMethodBeat.o(192170);
    return paramVarArgs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tavkit.utils.ListUtils
 * JD-Core Version:    0.7.0.1
 */