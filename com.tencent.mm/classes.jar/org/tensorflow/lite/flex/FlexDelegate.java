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
  private long ajZK;
  
  static
  {
    AppMethodBeat.i(187261);
    if (!a.ajZL.value) {
      Log.e("MicroMsg.FlexDelegate", "load library error");
    }
    AppMethodBeat.o(187261);
  }
  
  public FlexDelegate()
  {
    AppMethodBeat.i(187241);
    this.ajZK = nativeCreateDelegate();
    AppMethodBeat.o(187241);
  }
  
  private static native long nativeCreateDelegate();
  
  private static native void nativeDeleteDelegate(long paramLong);
  
  private static native long nativeInitTensorFlow();
  
  public void close()
  {
    AppMethodBeat.i(187277);
    if (this.ajZK != 0L)
    {
      nativeDeleteDelegate(this.ajZK);
      this.ajZK = 0L;
    }
    AppMethodBeat.o(187277);
  }
  
  public final long getNativeHandle()
  {
    return this.ajZK;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.tensorflow.lite.flex.FlexDelegate
 * JD-Core Version:    0.7.0.1
 */