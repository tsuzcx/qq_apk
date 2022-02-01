package rx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class b
{
  public static void a(Throwable paramThrowable, rx.e<?> parame)
  {
    AppMethodBeat.i(90049);
    ai(paramThrowable);
    parame.l(paramThrowable);
    AppMethodBeat.o(90049);
  }
  
  public static void a(Throwable paramThrowable, rx.e<?> parame, Object paramObject)
  {
    AppMethodBeat.i(90048);
    ai(paramThrowable);
    parame.l(g.a(paramThrowable, paramObject));
    AppMethodBeat.o(90048);
  }
  
  public static void ai(Throwable paramThrowable)
  {
    if ((paramThrowable instanceof f)) {
      throw ((f)paramThrowable);
    }
    if ((paramThrowable instanceof e)) {
      throw ((e)paramThrowable);
    }
    if ((paramThrowable instanceof d)) {
      throw ((d)paramThrowable);
    }
    if ((paramThrowable instanceof StackOverflowError)) {
      throw ((StackOverflowError)paramThrowable);
    }
    if ((paramThrowable instanceof VirtualMachineError)) {
      throw ((VirtualMachineError)paramThrowable);
    }
    if ((paramThrowable instanceof ThreadDeath)) {
      throw ((ThreadDeath)paramThrowable);
    }
    if ((paramThrowable instanceof LinkageError)) {
      throw ((LinkageError)paramThrowable);
    }
  }
  
  public static Throwable aj(Throwable paramThrowable)
  {
    AppMethodBeat.i(90046);
    int i = 0;
    while (paramThrowable.getCause() != null)
    {
      if (i >= 25)
      {
        paramThrowable = new RuntimeException("Stack too deep to get final cause");
        AppMethodBeat.o(90046);
        return paramThrowable;
      }
      paramThrowable = paramThrowable.getCause();
      i += 1;
    }
    AppMethodBeat.o(90046);
    return paramThrowable;
  }
  
  public static void f(Throwable paramThrowable1, Throwable paramThrowable2)
  {
    AppMethodBeat.i(90045);
    HashSet localHashSet = new HashSet();
    int i = 0;
    Throwable localThrowable;
    for (;;)
    {
      localThrowable = paramThrowable1;
      if (paramThrowable1.getCause() == null) {
        break;
      }
      if (i >= 25)
      {
        AppMethodBeat.o(90045);
        return;
      }
      paramThrowable1 = paramThrowable1.getCause();
      localThrowable = paramThrowable1;
      if (localHashSet.contains(paramThrowable1.getCause())) {
        break;
      }
      localHashSet.add(paramThrowable1.getCause());
      i += 1;
    }
    try
    {
      localThrowable.initCause(paramThrowable2);
      return;
    }
    finally
    {
      AppMethodBeat.o(90045);
    }
  }
  
  public static void pp(List<? extends Throwable> paramList)
  {
    AppMethodBeat.i(90047);
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      if (paramList.size() == 1)
      {
        paramList = (Throwable)paramList.get(0);
        if ((paramList instanceof RuntimeException))
        {
          paramList = (RuntimeException)paramList;
          AppMethodBeat.o(90047);
          throw paramList;
        }
        if ((paramList instanceof Error))
        {
          paramList = (Error)paramList;
          AppMethodBeat.o(90047);
          throw paramList;
        }
        paramList = new RuntimeException(paramList);
        AppMethodBeat.o(90047);
        throw paramList;
      }
      paramList = new a(paramList, (byte)0);
      AppMethodBeat.o(90047);
      throw paramList;
    }
    AppMethodBeat.o(90047);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     rx.a.b
 * JD-Core Version:    0.7.0.1
 */