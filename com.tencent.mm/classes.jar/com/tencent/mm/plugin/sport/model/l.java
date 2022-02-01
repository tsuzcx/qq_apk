package com.tencent.mm.plugin.sport.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.ConfigFileStorageProxyMMKV;
import com.tencent.mm.storage.an;

public final class l
  extends an
{
  public l(String paramString)
  {
    super(paramString);
  }
  
  public final long ahV(int paramInt)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(221532);
        if (hxP())
        {
          l = this.VfK.ahV(paramInt);
          AppMethodBeat.o(221532);
          return l;
        }
        Object localObject1 = get(paramInt);
        if ((localObject1 instanceof Long))
        {
          l = ((Long)localObject1).longValue();
          AppMethodBeat.o(221532);
          continue;
        }
        if (!(localObject2 instanceof Integer)) {
          break label96;
        }
      }
      finally {}
      long l = ((Integer)localObject2).longValue();
      AppMethodBeat.o(221532);
      continue;
      label96:
      l = 0L;
      AppMethodBeat.o(221532);
    }
  }
  
  public final String bcJ(String paramString)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(221537);
        Object localObject;
        if (hxP())
        {
          localObject = this.VfK;
          if ((((ConfigFileStorageProxyMMKV)localObject).b(301, paramString) instanceof String))
          {
            paramString = (String)((ConfigFileStorageProxyMMKV)localObject).b(301, paramString);
            AppMethodBeat.o(221537);
            return paramString;
          }
          AppMethodBeat.o(221537);
          continue;
        }
        try
        {
          localObject = get(301);
          if ((localObject instanceof String))
          {
            localObject = (String)localObject;
            AppMethodBeat.o(221537);
            paramString = (String)localObject;
          }
          else
          {
            AppMethodBeat.o(221537);
          }
        }
        catch (Exception localException)
        {
          AppMethodBeat.o(221537);
        }
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.model.l
 * JD-Core Version:    0.7.0.1
 */