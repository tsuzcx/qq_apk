package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ao
{
  private ao.a<String, Bitmap> a;
  
  public ao(int paramInt)
  {
    AppMethodBeat.i(149632);
    this.a = new ao.a(paramInt);
    AppMethodBeat.o(149632);
  }
  
  public Bitmap a(String paramString)
  {
    AppMethodBeat.i(149635);
    paramString = (Bitmap)this.a.a(paramString);
    AppMethodBeat.o(149635);
    return paramString;
  }
  
  public void a()
  {
    AppMethodBeat.i(149633);
    this.a.a();
    AppMethodBeat.o(149633);
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(149634);
    this.a.a(paramString, paramBitmap);
    AppMethodBeat.o(149634);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ao
 * JD-Core Version:    0.7.0.1
 */