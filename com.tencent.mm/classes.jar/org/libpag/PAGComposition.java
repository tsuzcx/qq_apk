package org.libpag;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import org.extra.tools.b;

public class PAGComposition
  extends PAGLayer
{
  static
  {
    AppMethodBeat.i(194869);
    b.loadLibrary("pag");
    nativeInit();
    AppMethodBeat.o(194869);
  }
  
  public PAGComposition(long paramLong)
  {
    super(paramLong);
  }
  
  public static native PAGComposition Make(int paramInt1, int paramInt2);
  
  private static native void nativeInit();
  
  public native void addLayer(PAGLayer paramPAGLayer);
  
  public native void addLayerAt(PAGLayer paramPAGLayer, int paramInt);
  
  public native ByteBuffer audioBytes();
  
  public native PAGMarker[] audioMarkers();
  
  public native long audioStartTime();
  
  public native boolean contains(PAGLayer paramPAGLayer);
  
  public native PAGLayer getLayerAt(int paramInt);
  
  public native int getLayerIndex(PAGLayer paramPAGLayer);
  
  public native PAGLayer[] getLayersByName(String paramString);
  
  public native PAGLayer[] getLayersUnderPoint(float paramFloat1, float paramFloat2);
  
  public native int height();
  
  public native int numChildren();
  
  public int numLayers()
  {
    AppMethodBeat.i(194861);
    int i = numChildren();
    AppMethodBeat.o(194861);
    return i;
  }
  
  public native void removeAllLayers();
  
  public native PAGLayer removeLayer(PAGLayer paramPAGLayer);
  
  public native PAGLayer removeLayerAt(int paramInt);
  
  public native void setContentSize(int paramInt1, int paramInt2);
  
  public native void setLayerIndex(PAGLayer paramPAGLayer, int paramInt);
  
  public native void swapLayer(PAGLayer paramPAGLayer1, PAGLayer paramPAGLayer2);
  
  public native void swapLayerAt(int paramInt1, int paramInt2);
  
  public native int width();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.libpag.PAGComposition
 * JD-Core Version:    0.7.0.1
 */