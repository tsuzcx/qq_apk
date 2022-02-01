package org.libpag;

import android.content.res.AssetManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.extra.tools.b;

public class PAGFile
  extends PAGComposition
{
  static
  {
    AppMethodBeat.i(220139);
    b.loadLibrary("libpag");
    nativeInit();
    PAGFont.loadSystemFonts();
    AppMethodBeat.o(220139);
  }
  
  private PAGFile(long paramLong)
  {
    super(paramLong);
  }
  
  public static PAGFile Load(AssetManager paramAssetManager, String paramString)
  {
    AppMethodBeat.i(220137);
    paramAssetManager = LoadFromAssets(paramAssetManager, paramString);
    AppMethodBeat.o(220137);
    return paramAssetManager;
  }
  
  public static PAGFile Load(String paramString)
  {
    AppMethodBeat.i(220135);
    paramString = LoadFromPath(paramString);
    AppMethodBeat.o(220135);
    return paramString;
  }
  
  public static PAGFile Load(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(220136);
    paramArrayOfByte = LoadFromBytes(paramArrayOfByte, paramArrayOfByte.length);
    AppMethodBeat.o(220136);
    return paramArrayOfByte;
  }
  
  private static native PAGFile LoadFromAssets(AssetManager paramAssetManager, String paramString);
  
  private static native PAGFile LoadFromBytes(byte[] paramArrayOfByte, int paramInt);
  
  private static native PAGFile LoadFromPath(String paramString);
  
  public static native int MaxSupportedTagLevel();
  
  private static final native void nativeInit();
  
  public native PAGFile copyOriginal();
  
  public native PAGLayer[] getLayersByEditableIndex(int paramInt1, int paramInt2);
  
  public native PAGText getTextData(int paramInt);
  
  public native void nativeReplaceImage(int paramInt, long paramLong);
  
  public native int numImages();
  
  public native int numTexts();
  
  public native int numVideos();
  
  public native String path();
  
  public void replaceImage(int paramInt, PAGImage paramPAGImage)
  {
    AppMethodBeat.i(220138);
    if (paramPAGImage == null)
    {
      nativeReplaceImage(paramInt, 0L);
      AppMethodBeat.o(220138);
      return;
    }
    nativeReplaceImage(paramInt, paramPAGImage.nativeContext);
    AppMethodBeat.o(220138);
  }
  
  public native void replaceText(int paramInt, PAGText paramPAGText);
  
  public native void setDuration(long paramLong);
  
  public native void setTimeStretchMode(int paramInt);
  
  public native int tagLevel();
  
  public native int timeStretchMode();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.libpag.PAGFile
 * JD-Core Version:    0.7.0.1
 */