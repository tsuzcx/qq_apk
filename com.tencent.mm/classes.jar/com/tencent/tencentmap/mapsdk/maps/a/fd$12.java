package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.BitSet;

final class fd$12
  extends eb<BitSet>
{
  public final BitSet a(ff paramff)
  {
    AppMethodBeat.i(147755);
    if (paramff.f() == fg.i)
    {
      paramff.j();
      AppMethodBeat.o(147755);
      return null;
    }
    BitSet localBitSet = new BitSet();
    paramff.a();
    Object localObject = paramff.f();
    int i = 0;
    if (localObject != fg.b)
    {
      boolean bool;
      switch (fd.26.a[localObject.ordinal()])
      {
      default: 
        paramff = new dy("Invalid bitset value type: ".concat(String.valueOf(localObject)));
        AppMethodBeat.o(147755);
        throw paramff;
      case 1: 
        if (paramff.m() != 0) {
          bool = true;
        }
        break;
      }
      for (;;)
      {
        if (bool) {
          localBitSet.set(i);
        }
        i += 1;
        localObject = paramff.f();
        break;
        bool = false;
        continue;
        bool = paramff.i();
        continue;
        localObject = paramff.h();
        try
        {
          int j = Integer.parseInt((String)localObject);
          if (j != 0) {
            bool = true;
          } else {
            bool = false;
          }
        }
        catch (NumberFormatException paramff)
        {
          paramff = new dy("Error: Expecting: bitset number value (1, 0), Found: ".concat(String.valueOf(localObject)));
          AppMethodBeat.o(147755);
          throw paramff;
        }
      }
    }
    paramff.b();
    AppMethodBeat.o(147755);
    return localBitSet;
  }
  
  public final void a(fh paramfh, BitSet paramBitSet)
  {
    AppMethodBeat.i(147756);
    if (paramBitSet == null)
    {
      paramfh.f();
      AppMethodBeat.o(147756);
      return;
    }
    paramfh.b();
    int i = 0;
    if (i < paramBitSet.length())
    {
      if (paramBitSet.get(i)) {}
      for (int j = 1;; j = 0)
      {
        paramfh.a(j);
        i += 1;
        break;
      }
    }
    paramfh.c();
    AppMethodBeat.o(147756);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.fd.12
 * JD-Core Version:    0.7.0.1
 */