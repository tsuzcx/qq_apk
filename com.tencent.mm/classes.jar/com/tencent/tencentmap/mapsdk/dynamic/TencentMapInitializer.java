package com.tencent.tencentmap.mapsdk.dynamic;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class TencentMapInitializer
  implements IInitializer
{
  private static volatile TencentMapInitializer b;
  private IInitializer a;
  
  private TencentMapInitializer(Context paramContext)
  {
    AppMethodBeat.i(101278);
    this.a = a.a(paramContext);
    AppMethodBeat.o(101278);
  }
  
  public static TencentMapInitializer getInstance(Context paramContext)
  {
    AppMethodBeat.i(101279);
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new TencentMapInitializer(paramContext);
      }
      paramContext = b;
      AppMethodBeat.o(101279);
      return paramContext;
    }
    finally
    {
      AppMethodBeat.o(101279);
    }
  }
  
  public void downLoadVectorMapResource()
  {
    AppMethodBeat.i(101280);
    if (this.a == null)
    {
      AppMethodBeat.o(101280);
      return;
    }
    this.a.downLoadVectorMapResource();
    AppMethodBeat.o(101280);
  }
  
  public boolean isVectorMapValid()
  {
    AppMethodBeat.i(101281);
    if (this.a == null)
    {
      AppMethodBeat.o(101281);
      return false;
    }
    boolean bool = this.a.isVectorMapValid();
    AppMethodBeat.o(101281);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.dynamic.TencentMapInitializer
 * JD-Core Version:    0.7.0.1
 */