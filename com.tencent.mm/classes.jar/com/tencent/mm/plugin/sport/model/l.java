package com.tencent.mm.plugin.sport.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.ConfigFileStorageProxyMMKV;
import com.tencent.mm.storage.ap;

public final class l
  extends ap
{
  public l(String paramString)
  {
    super(paramString);
  }
  
  public final long amW(int paramInt)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(263916);
        if (iZu())
        {
          l = this.acGZ.amW(paramInt);
          AppMethodBeat.o(263916);
          return l;
        }
        Object localObject1 = get(paramInt);
        if ((localObject1 instanceof Long))
        {
          l = ((Long)localObject1).longValue();
          AppMethodBeat.o(263916);
          continue;
        }
        if (!(localObject2 instanceof Integer)) {
          break label96;
        }
      }
      finally {}
      long l = ((Integer)localObject2).longValue();
      AppMethodBeat.o(263916);
      continue;
      label96:
      l = 0L;
      AppMethodBeat.o(263916);
    }
  }
  
  public final String bbx(String paramString)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(263921);
        Object localObject;
        if (iZu())
        {
          localObject = this.acGZ;
          if ((((ConfigFileStorageProxyMMKV)localObject).d(301, paramString) instanceof String))
          {
            paramString = (String)((ConfigFileStorageProxyMMKV)localObject).d(301, paramString);
            AppMethodBeat.o(263921);
            return paramString;
          }
          AppMethodBeat.o(263921);
          continue;
        }
        try
        {
          localObject = get(301);
          if ((localObject instanceof String))
          {
            localObject = (String)localObject;
            AppMethodBeat.o(263921);
            paramString = (String)localObject;
          }
          else
          {
            AppMethodBeat.o(263921);
          }
        }
        catch (Exception localException)
        {
          AppMethodBeat.o(263921);
        }
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.model.l
 * JD-Core Version:    0.7.0.1
 */