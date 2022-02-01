package com.tencent.mm.plugin.performance.elf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public final class a
{
  public static HashMap<Class, AbstractProcessChecker> cDF;
  
  static
  {
    AppMethodBeat.i(124995);
    cDF = new HashMap();
    AppMethodBeat.o(124995);
  }
  
  public static <T extends AbstractProcessChecker> T aS(Class<? extends AbstractProcessChecker> paramClass)
  {
    AppMethodBeat.i(124994);
    if (cDF.containsKey(paramClass))
    {
      paramClass = (AbstractProcessChecker)cDF.get(paramClass);
      AppMethodBeat.o(124994);
      return paramClass;
    }
    try
    {
      AbstractProcessChecker localAbstractProcessChecker = (AbstractProcessChecker)paramClass.newInstance();
      cDF.put(paramClass, localAbstractProcessChecker);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.elf.a
 * JD-Core Version:    0.7.0.1
 */