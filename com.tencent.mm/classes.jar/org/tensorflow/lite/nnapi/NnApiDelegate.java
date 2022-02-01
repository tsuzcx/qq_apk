package org.tensorflow.lite.nnapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.tensorflow.lite.TensorFlowLite;
import org.tensorflow.lite.b;

public class NnApiDelegate
  implements AutoCloseable, b
{
  public long abMR;
  
  public NnApiDelegate()
  {
    this(new a());
    AppMethodBeat.i(240091);
    AppMethodBeat.o(240091);
  }
  
  private NnApiDelegate(a parama)
  {
    AppMethodBeat.i(240088);
    TensorFlowLite.init();
    int j = parama.abMT;
    String str1 = parama.abMU;
    String str2 = parama.cacheDir;
    String str3 = parama.abMV;
    int i;
    if (parama.abMW != null)
    {
      i = parama.abMW.intValue();
      if (parama.abMX == null) {
        break label142;
      }
    }
    label142:
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool4;
      if (parama.abMX != null)
      {
        bool2 = bool4;
        if (parama.abMX.booleanValue()) {
          bool2 = false;
        }
      }
      if (parama.abMY != null) {
        bool3 = parama.abMY.booleanValue();
      }
      this.abMR = createDelegate(j, str1, str2, str3, i, bool1, bool2, bool3);
      AppMethodBeat.o(240088);
      return;
      i = -1;
      break;
    }
  }
  
  private static native long createDelegate(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);
  
  private static native void deleteDelegate(long paramLong);
  
  private static native int getNnapiErrno(long paramLong);
  
  public void close()
  {
    AppMethodBeat.i(240093);
    if (this.abMR != 0L)
    {
      deleteDelegate(this.abMR);
      this.abMR = 0L;
    }
    AppMethodBeat.o(240093);
  }
  
  public final long getNativeHandle()
  {
    return this.abMR;
  }
  
  public static final class a
  {
    int abMT = -1;
    String abMU = null;
    String abMV = null;
    Integer abMW = null;
    Boolean abMX = null;
    Boolean abMY = null;
    String cacheDir = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     org.tensorflow.lite.nnapi.NnApiDelegate
 * JD-Core Version:    0.7.0.1
 */