package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class oa
{
  public static void a(Throwable paramThrowable)
  {
    AppMethodBeat.i(149593);
    if ((paramThrowable instanceof oc))
    {
      paramThrowable = (oc)paramThrowable;
      AppMethodBeat.o(149593);
      throw paramThrowable;
    }
    if ((paramThrowable instanceof ob))
    {
      Throwable localThrowable = ((ob)paramThrowable).getCause();
      if ((localThrowable instanceof RuntimeException))
      {
        paramThrowable = (RuntimeException)localThrowable;
        AppMethodBeat.o(149593);
        throw paramThrowable;
      }
      paramThrowable = (ob)paramThrowable;
      AppMethodBeat.o(149593);
      throw paramThrowable;
    }
    if ((paramThrowable instanceof StackOverflowError))
    {
      paramThrowable = (StackOverflowError)paramThrowable;
      AppMethodBeat.o(149593);
      throw paramThrowable;
    }
    if ((paramThrowable instanceof VirtualMachineError))
    {
      paramThrowable = (VirtualMachineError)paramThrowable;
      AppMethodBeat.o(149593);
      throw paramThrowable;
    }
    if ((paramThrowable instanceof ThreadDeath))
    {
      paramThrowable = (ThreadDeath)paramThrowable;
      AppMethodBeat.o(149593);
      throw paramThrowable;
    }
    if ((paramThrowable instanceof LinkageError))
    {
      paramThrowable = (LinkageError)paramThrowable;
      AppMethodBeat.o(149593);
      throw paramThrowable;
    }
    AppMethodBeat.o(149593);
  }
  
  public static void a(List<? extends Throwable> paramList)
  {
    AppMethodBeat.i(149594);
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      if (paramList.size() == 1)
      {
        paramList = (Throwable)paramList.get(0);
        if ((paramList instanceof RuntimeException))
        {
          paramList = (RuntimeException)paramList;
          AppMethodBeat.o(149594);
          throw paramList;
        }
        if ((paramList instanceof Error))
        {
          paramList = (Error)paramList;
          AppMethodBeat.o(149594);
          throw paramList;
        }
        paramList = new RuntimeException(paramList);
        AppMethodBeat.o(149594);
        throw paramList;
      }
      paramList = new nz("Multiple exceptions", paramList);
      AppMethodBeat.o(149594);
      throw paramList;
    }
    AppMethodBeat.o(149594);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.oa
 * JD-Core Version:    0.7.0.1
 */