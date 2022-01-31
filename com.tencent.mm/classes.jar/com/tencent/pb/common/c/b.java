package com.tencent.pb.common.c;

import java.util.HashMap;
import java.util.Map;

public final class b
{
  public static <E> Map<E, E> C(E... paramVarArgs)
  {
    if (paramVarArgs.length % 2 != 0) {
      throw new IllegalArgumentException("length of map is " + paramVarArgs.length);
    }
    HashMap localHashMap = new HashMap();
    int i = 0;
    while (i < paramVarArgs.length)
    {
      localHashMap.put(paramVarArgs[i], paramVarArgs[(i + 1)]);
      i += 2;
    }
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.pb.common.c.b
 * JD-Core Version:    0.7.0.1
 */