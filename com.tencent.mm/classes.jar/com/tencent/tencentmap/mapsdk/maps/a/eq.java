package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.EOFException;
import java.io.IOException;

public final class eq
{
  public static dq a(ff paramff)
  {
    AppMethodBeat.i(147634);
    int i = 1;
    try
    {
      paramff.f();
      i = 0;
      paramff = (dq)fd.P.b(paramff);
      AppMethodBeat.o(147634);
      return paramff;
    }
    catch (EOFException paramff)
    {
      if (i != 0)
      {
        paramff = ds.a;
        AppMethodBeat.o(147634);
        return paramff;
      }
      paramff = new dy(paramff);
      AppMethodBeat.o(147634);
      throw paramff;
    }
    catch (fi paramff)
    {
      paramff = new dy(paramff);
      AppMethodBeat.o(147634);
      throw paramff;
    }
    catch (IOException paramff)
    {
      paramff = new dr(paramff);
      AppMethodBeat.o(147634);
      throw paramff;
    }
    catch (NumberFormatException paramff)
    {
      paramff = new dy(paramff);
      AppMethodBeat.o(147634);
      throw paramff;
    }
  }
  
  public static void a(dq paramdq, fh paramfh)
  {
    AppMethodBeat.i(147635);
    fd.P.a(paramfh, paramdq);
    AppMethodBeat.o(147635);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.eq
 * JD-Core Version:    0.7.0.1
 */