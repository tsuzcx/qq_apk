package org.tensorflow.lite;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PBool;
import org.tensorflow.lite.a.a;

public final class TensorFlowLite
{
  private static final Throwable abMQ;
  private static volatile boolean isInit;
  
  static
  {
    AppMethodBeat.i(240290);
    isInit = false;
    if (!a.abMS.value)
    {
      abMQ = new Throwable("Wechat is not ready for TensorFlow!!! it maybe load Library error");
      AppMethodBeat.o(240290);
      return;
    }
    abMQ = null;
    AppMethodBeat.o(240290);
  }
  
  public static String iVD()
  {
    AppMethodBeat.i(240286);
    init();
    String str = nativeRuntimeVersion();
    AppMethodBeat.o(240286);
    return str;
  }
  
  public static void init()
  {
    AppMethodBeat.i(240287);
    if (isInit)
    {
      AppMethodBeat.o(240287);
      return;
    }
    try
    {
      nativeRuntimeVersion();
      isInit = true;
      AppMethodBeat.o(240287);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      if (abMQ != null) {
        localObject = abMQ;
      }
      Object localObject = new UnsatisfiedLinkError("Failed to load native TensorFlow Lite methods. Check that the correct native libraries are present, and, if using a custom native library, have been properly loaded via System.loadLibrary():\n  ".concat(String.valueOf(localObject)));
      AppMethodBeat.o(240287);
      throw ((Throwable)localObject);
    }
  }
  
  public static native String nativeRuntimeVersion();
  
  public static native String nativeSchemaVersion();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     org.tensorflow.lite.TensorFlowLite
 * JD-Core Version:    0.7.0.1
 */