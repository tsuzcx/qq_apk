package kotlinx.coroutines.a;

import a.f.b.j;
import a.l;
import a.l.m;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"AVAILABLE_PROCESSORS", "", "getAVAILABLE_PROCESSORS", "()I", "systemProp", "", "propertyName", "", "defaultValue", "minValue", "maxValue", "", "kotlinx-coroutines-core"})
public final class n
{
  private static final int CJu;
  
  static
  {
    AppMethodBeat.i(118445);
    CJu = Runtime.getRuntime().availableProcessors();
    AppMethodBeat.o(118445);
  }
  
  public static final String azw(String paramString)
  {
    AppMethodBeat.i(118441);
    j.q(paramString, "propertyName");
    try
    {
      paramString = System.getProperty(paramString);
      AppMethodBeat.o(118441);
      return paramString;
    }
    catch (SecurityException paramString)
    {
      for (;;)
      {
        paramString = null;
      }
    }
  }
  
  private static long d(String paramString, long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(118443);
    j.q(paramString, "propertyName");
    String str = azw(paramString);
    if (str == null)
    {
      AppMethodBeat.o(118443);
      return paramLong1;
    }
    Long localLong = m.azv(str);
    if (localLong != null)
    {
      paramLong1 = localLong.longValue();
      if ((paramLong2 > paramLong1) || (paramLong3 < paramLong1))
      {
        paramString = (Throwable)new IllegalStateException(("System property '" + paramString + "' should be in range " + paramLong2 + ".." + paramLong3 + ", but is '" + paramLong1 + '\'').toString());
        AppMethodBeat.o(118443);
        throw paramString;
      }
    }
    else
    {
      paramString = (Throwable)new IllegalStateException(("System property '" + paramString + "' has unrecognized value '" + str + '\'').toString());
      AppMethodBeat.o(118443);
      throw paramString;
    }
    AppMethodBeat.o(118443);
    return paramLong1;
  }
  
  public static final int eqo()
  {
    return CJu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     kotlinx.coroutines.a.n
 * JD-Core Version:    0.7.0.1
 */