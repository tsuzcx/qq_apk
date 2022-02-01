package org.tensorflow.lite;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PBool;
import org.tensorflow.lite.a.a;

public final class TensorFlowLite
{
  private static final Throwable Ujv;
  private static volatile boolean isInit;
  
  static
  {
    AppMethodBeat.i(238988);
    isInit = false;
    if (!a.Ujx.value)
    {
      Ujv = new Throwable("Wechat is not ready for TensorFlow!!! it maybe load Library error");
      AppMethodBeat.o(238988);
      return;
    }
    Ujv = null;
    AppMethodBeat.o(238988);
  }
  
  public static String hQt()
  {
    AppMethodBeat.i(238986);
    init();
    String str = nativeRuntimeVersion();
    AppMethodBeat.o(238986);
    return str;
  }
  
  public static void init()
  {
    AppMethodBeat.i(238987);
    if (isInit)
    {
      AppMethodBeat.o(238987);
      return;
    }
    try
    {
      nativeRuntimeVersion();
      isInit = true;
      AppMethodBeat.o(238987);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      if (Ujv != null) {
        localObject = Ujv;
      }
      Object localObject = new UnsatisfiedLinkError("Failed to load native TensorFlow Lite methods. Check that the correct native libraries are present, and, if using a custom native library, have been properly loaded via System.loadLibrary():\n  ".concat(String.valueOf(localObject)));
      AppMethodBeat.o(238987);
      throw ((Throwable)localObject);
    }
  }
  
  public static native String nativeRuntimeVersion();
  
  public static native String nativeSchemaVersion();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     org.tensorflow.lite.TensorFlowLite
 * JD-Core Version:    0.7.0.1
 */