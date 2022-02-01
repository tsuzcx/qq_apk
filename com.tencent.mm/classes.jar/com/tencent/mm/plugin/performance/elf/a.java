package com.tencent.mm.plugin.performance.elf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public final class a
{
  public static HashMap<Class, AbstractProcessChecker> map;
  
  static
  {
    AppMethodBeat.i(124995);
    map = new HashMap();
    AppMethodBeat.o(124995);
  }
  
  public static <T extends AbstractProcessChecker> T bY(Class<? extends AbstractProcessChecker> paramClass)
  {
    AppMethodBeat.i(124994);
    if (map.containsKey(paramClass))
    {
      paramClass = (AbstractProcessChecker)map.get(paramClass);
      AppMethodBeat.o(124994);
      return paramClass;
    }
    try
    {
      AbstractProcessChecker localAbstractProcessChecker = (AbstractProcessChecker)paramClass.newInstance();
      map.put(paramClass, localAbstractProcessChecker);
      AppMethodBeat.o(124994);
      return localAbstractProcessChecker;
    }
    catch (IllegalAccessException paramClass)
    {
      AppMethodBeat.o(124994);
      return null;
    }
    catch (InstantiationException paramClass)
    {
      label58:
      break label58;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.elf.a
 * JD-Core Version:    0.7.0.1
 */