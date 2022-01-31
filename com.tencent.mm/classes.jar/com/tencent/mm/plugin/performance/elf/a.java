package com.tencent.mm.plugin.performance.elf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public final class a
{
  public static HashMap<Class, AbstractProcessChecker> bSA;
  
  static
  {
    AppMethodBeat.i(111068);
    bSA = new HashMap();
    AppMethodBeat.o(111068);
  }
  
  public static <T extends AbstractProcessChecker> T an(Class<? extends AbstractProcessChecker> paramClass)
  {
    AppMethodBeat.i(111067);
    if (bSA.containsKey(paramClass))
    {
      paramClass = (AbstractProcessChecker)bSA.get(paramClass);
      AppMethodBeat.o(111067);
      return paramClass;
    }
    try
    {
      AbstractProcessChecker localAbstractProcessChecker = (AbstractProcessChecker)paramClass.newInstance();
      bSA.put(paramClass, localAbstractProcessChecker);
      AppMethodBeat.o(111067);
      return localAbstractProcessChecker;
    }
    catch (IllegalAccessException paramClass)
    {
      AppMethodBeat.o(111067);
      return null;
    }
    catch (InstantiationException paramClass)
    {
      label58:
      break label58;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.elf.a
 * JD-Core Version:    0.7.0.1
 */