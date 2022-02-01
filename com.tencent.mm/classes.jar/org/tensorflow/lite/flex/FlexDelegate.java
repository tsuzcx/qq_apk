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
  private long abMR;
  
  static
  {
    AppMethodBeat.i(240160);
    if (!a.abMS.value) {
      Log.e("MicroMsg.FlexDelegate", "load library error");
    }
    AppMethodBeat.o(240160);
  }
  
  public FlexDelegate()
  {
    AppMethodBeat.i(240146);
    this.abMR = nativeCreateDelegate();
    AppMethodBeat.o(240146);
  }
  
  private static native long nativeCreateDelegate();
  
  private static native void nativeDeleteDelegate(long paramLong);
  
  private static native long nativeInitTensorFlow();
  
  public void close()
  {
    AppMethodBeat.i(240153);
    if (this.abMR != 0L)
    {
      nativeDeleteDelegate(this.abMR);
      this.abMR = 0L;
    }
    AppMethodBeat.o(240153);
  }
  
  public final long getNativeHandle()
  {
    return this.abMR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     org.tensorflow.lite.flex.FlexDelegate
 * JD-Core Version:    0.7.0.1
 */