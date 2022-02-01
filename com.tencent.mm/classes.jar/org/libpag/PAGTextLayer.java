package org.libpag;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.extra.tools.b;

public class PAGTextLayer
  extends PAGLayer
{
  static
  {
    AppMethodBeat.i(220211);
    b.loadLibrary("libpag");
    nativeInit();
    AppMethodBeat.o(220211);
  }
  
  public PAGTextLayer(long paramLong)
  {
    super(paramLong);
  }
  
  private static native void nativeInit();
  
  private native void setFont(String paramString1, String paramString2);
  
  public native int fillColor();
  
  public native PAGFont font();
  
  public native float fontSize();
  
  public native void setFillColor(int paramInt);
  
  public void setFont(PAGFont paramPAGFont)
  {
    AppMethodBeat.i(220210);
    setFont(paramPAGFont.fontFamily, paramPAGFont.fontStyle);
    AppMethodBeat.o(220210);
  }
  
  public native void setFontSize(float paramFloat);
  
  public native void setStrokeColor(int paramInt);
  
  public native void setText(String paramString);
  
  public native int strokeColor();
  
  public native String text();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.libpag.PAGTextLayer
 * JD-Core Version:    0.7.0.1
 */