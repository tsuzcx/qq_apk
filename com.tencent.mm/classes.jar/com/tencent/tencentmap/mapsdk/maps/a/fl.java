package com.tencent.tencentmap.mapsdk.maps.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.e.a;
import com.tencent.tencentmap.mapsdk.a.f.a;
import com.tencent.tencentmap.mapsdk.a.f.b;

public class fl
{
  public static <T> T a(String paramString, Class<T> paramClass)
  {
    Object localObject1 = null;
    AppMethodBeat.i(147942);
    if ((TextUtils.isEmpty(paramString)) || (paramClass == null))
    {
      AppMethodBeat.o(147942);
      return null;
    }
    Object localObject2 = new dl();
    ((dl)localObject2).a(new fl.1().b(), new fm());
    ((dl)localObject2).a(e.a.class, new fo());
    ((dl)localObject2).a(f.b.class, new fq());
    ((dl)localObject2).a(f.a.class, new fp());
    localObject2 = ((dl)localObject2).a();
    try
    {
      paramString = ((dk)localObject2).a(paramString, paramClass);
      AppMethodBeat.o(147942);
      return paramString;
    }
    catch (dy paramString)
    {
      for (;;)
      {
        fr.a(paramString.toString());
        paramString = localObject1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.fl
 * JD-Core Version:    0.7.0.1
 */