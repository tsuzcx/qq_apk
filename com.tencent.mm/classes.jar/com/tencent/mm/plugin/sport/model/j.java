package com.tencent.mm.plugin.sport.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.ConfigFileStorageProxyMMKV;
import com.tencent.mm.storage.ah;

public final class j
  extends ah
{
  public j(String paramString)
  {
    super(paramString);
  }
  
  public final long getLong(int paramInt, long paramLong)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(149327);
        if (fpY())
        {
          paramLong = this.Ipw.getLong(paramInt, paramLong);
          AppMethodBeat.o(149327);
          return paramLong;
        }
        Object localObject1 = get(paramInt);
        if ((localObject1 instanceof Long))
        {
          paramLong = ((Long)localObject1).longValue();
          AppMethodBeat.o(149327);
          continue;
        }
        if (!(localObject2 instanceof Integer)) {
          break label97;
        }
      }
      finally {}
      paramLong = ((Integer)localObject2).longValue();
      AppMethodBeat.o(149327);
      continue;
      label97:
      AppMethodBeat.o(149327);
    }
  }
  
  public final String getString(int paramInt, String paramString)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(149329);
        Object localObject;
        if (fpY())
        {
          localObject = this.Ipw;
          if ((((ConfigFileStorageProxyMMKV)localObject).get(paramInt, paramString) instanceof String))
          {
            paramString = (String)((ConfigFileStorageProxyMMKV)localObject).get(paramInt, paramString);
            AppMethodBeat.o(149329);
            return paramString;
          }
          AppMethodBeat.o(149329);
          continue;
        }
        try
        {
          localObject = get(paramInt);
          if ((localObject instanceof String))
          {
            localObject = (String)localObject;
            AppMethodBeat.o(149329);
            paramString = (String)localObject;
          }
          else
          {
            AppMethodBeat.o(149329);
          }
        }
        catch (Exception localException)
        {
          AppMethodBeat.o(149329);
        }
      }
      finally {}
    }
  }
  
  public final void setString(int paramInt, String paramString)
  {
    try
    {
      AppMethodBeat.i(149328);
      set(paramInt, paramString);
      AppMethodBeat.o(149328);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.model.j
 * JD-Core Version:    0.7.0.1
 */