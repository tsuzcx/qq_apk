package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class y$b
{
  final String fnF;
  final int type;
  
  y$b(int paramInt, String paramString)
  {
    this.type = paramInt;
    this.fnF = paramString;
  }
  
  final Object aoU()
  {
    AppMethodBeat.i(5477);
    if (this.fnF == y.cPJ())
    {
      AppMethodBeat.o(5477);
      return null;
    }
    try
    {
      int i = this.type;
      switch (i)
      {
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject;
        ab.e("MicroMsg.ConfigStorage", "exception:%s", new Object[] { bo.l(localException) });
      }
    }
    AppMethodBeat.o(5477);
    return null;
    localObject = Integer.valueOf(this.fnF);
    AppMethodBeat.o(5477);
    return localObject;
    localObject = Long.valueOf(this.fnF);
    AppMethodBeat.o(5477);
    return localObject;
    localObject = this.fnF;
    AppMethodBeat.o(5477);
    return localObject;
    localObject = Boolean.valueOf(this.fnF);
    AppMethodBeat.o(5477);
    return localObject;
    localObject = Float.valueOf(this.fnF);
    AppMethodBeat.o(5477);
    return localObject;
    localObject = Double.valueOf(this.fnF);
    AppMethodBeat.o(5477);
    return localObject;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(5476);
    if (paramObject == null)
    {
      AppMethodBeat.o(5476);
      return false;
    }
    if (!(paramObject instanceof b))
    {
      AppMethodBeat.o(5476);
      return false;
    }
    paramObject = (b)paramObject;
    if (this.type != paramObject.type)
    {
      AppMethodBeat.o(5476);
      return false;
    }
    if (this.fnF == null)
    {
      if (paramObject.fnF == null)
      {
        AppMethodBeat.o(5476);
        return true;
      }
      AppMethodBeat.o(5476);
      return false;
    }
    boolean bool = this.fnF.equals(paramObject.fnF);
    AppMethodBeat.o(5476);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.y.b
 * JD-Core Version:    0.7.0.1
 */