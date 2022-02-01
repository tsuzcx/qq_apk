package org.tensorflow.lite.flex;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.Closeable;
import org.tensorflow.lite.a.a;
import org.tensorflow.lite.b;

public class FlexDelegate
  implements Closeable, b
{
  private long Ujw;
  
  static
  {
    AppMethodBeat.i(238991);
    if (!a.Ujx.value) {
      Log.e("MicroMsg.FlexDelegate", "load library error");
    }
    AppMethodBeat.o(238991);
  }
  
  public FlexDelegate()
  {
    AppMethodBeat.i(238989);
    this.Ujw = nativeCreateDelegate();
    AppMethodBeat.o(238989);
  }
  
  private static native long nativeCreateDelegate();
  
  private static native void nativeDeleteDelegate(long paramLong);
  
  private static native long nativeInitTensorFlow();
  
  public void close()
  {
    AppMethodBeat.i(238990);
    if (this.Ujw != 0L)
    {
      nativeDeleteDelegate(this.Ujw);
      this.Ujw = 0L;
    }
    AppMethodBeat.o(238990);
  }
  
  public final long getNativeHandle()
  {
    return this.Ujw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     org.tensorflow.lite.flex.FlexDelegate
 * JD-Core Version:    0.7.0.1
 */