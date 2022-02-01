package org.tensorflow.lite;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PBool;
import org.tensorflow.lite.a.a;

public final class TensorFlowLite
{
  private static final Throwable ajZJ;
  private static volatile boolean isInit;
  
  static
  {
    AppMethodBeat.i(187255);
    isInit = false;
    if (!a.ajZL.value)
    {
      ajZJ = new Throwable("Wechat is not ready for TensorFlow!!! it maybe load Library error");
      AppMethodBeat.o(187255);
      return;
    }
    ajZJ = null;
    AppMethodBeat.o(187255);
  }
  
  public static void init()
  {
    AppMethodBeat.i(187242);
    if (isInit)
    {
      AppMethodBeat.o(187242);
      return;
    }
    try
    {
      nativeRuntimeVersion();
      isInit = true;
      AppMethodBeat.o(187242);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      if (ajZJ != null) {
        localObject = ajZJ;
      }
      Object localObject = new UnsatisfiedLinkError("Failed to load native TensorFlow Lite methods. Check that the correct native libraries are present, and, if using a custom native library, have been properly loaded via System.loadLibrary():\n  ".concat(String.valueOf(localObject)));
      AppMethodBeat.o(187242);
      throw ((Throwable)localObject);
    }
  }
  
  public static String kKc()
  {
    AppMethodBeat.i(187236);
    init();
    String str = nativeRuntimeVersion();
    AppMethodBeat.o(187236);
    return str;
  }
  
  public static native String nativeRuntimeVersion();
  
  public static native String nativeSchemaVersion();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.tensorflow.lite.TensorFlowLite
 * JD-Core Version:    0.7.0.1
 */