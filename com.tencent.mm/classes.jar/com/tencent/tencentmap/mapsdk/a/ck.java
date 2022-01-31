package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ck
{
  private bj a = null;
  
  ck(bj parambj)
  {
    this.a = parambj;
  }
  
  public final Bitmap a(Context paramContext)
  {
    AppMethodBeat.i(149991);
    if (this.a == null)
    {
      AppMethodBeat.o(149991);
      return null;
    }
    paramContext = this.a.a(paramContext);
    AppMethodBeat.o(149991);
    return paramContext;
  }
  
  public final bj a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ck
 * JD-Core Version:    0.7.0.1
 */