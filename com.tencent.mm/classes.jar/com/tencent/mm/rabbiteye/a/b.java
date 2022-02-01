package com.tencent.mm.rabbiteye.a;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public static String gut()
  {
    AppMethodBeat.i(186315);
    Object localObject = new StringBuilder();
    StackTraceElement[] arrayOfStackTraceElement = Looper.getMainLooper().getThread().getStackTrace();
    int j = arrayOfStackTraceElement.length;
    int i = 0;
    while (i < j)
    {
      ((StringBuilder)localObject).append(arrayOfStackTraceElement[i].toString()).append("\n");
      i += 1;
    }
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(186315);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.rabbiteye.a.b
 * JD-Core Version:    0.7.0.1
 */