package org.tensorflow.lite.nnapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.tensorflow.lite.TensorFlowLite;
import org.tensorflow.lite.b;

public class NnApiDelegate
  implements AutoCloseable, b
{
  public long Ujw;
  
  public NnApiDelegate()
  {
    this(new a());
    AppMethodBeat.i(238993);
    AppMethodBeat.o(238993);
  }
  
  private NnApiDelegate(a parama)
  {
    AppMethodBeat.i(238992);
    TensorFlowLite.init();
    int j = parama.Ujy;
    String str1 = parama.Ujz;
    String str2 = parama.cacheDir;
    String str3 = parama.UjA;
    int i;
    if (parama.UjB != null)
    {
      i = parama.UjB.intValue();
      if (parama.UjC == null) {
        break label142;
      }
    }
    label142:
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool4;
      if (parama.UjC != null)
      {
        bool2 = bool4;
        if (parama.UjC.booleanValue()) {
          bool2 = false;
        }
      }
      if (parama.UjD != null) {
        bool3 = parama.UjD.booleanValue();
      }
      this.Ujw = createDelegate(j, str1, str2, str3, i, bool1, bool2, bool3);
      AppMethodBeat.o(238992);
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
    AppMethodBeat.i(238994);
    if (this.Ujw != 0L)
    {
      deleteDelegate(this.Ujw);
      this.Ujw = 0L;
    }
    AppMethodBeat.o(238994);
  }
  
  public final long getNativeHandle()
  {
    return this.Ujw;
  }
  
  public static final class a
  {
    String UjA = null;
    Integer UjB = null;
    Boolean UjC = null;
    Boolean UjD = null;
    int Ujy = -1;
    String Ujz = null;
    String cacheDir = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.tensorflow.lite.nnapi.NnApiDelegate
 * JD-Core Version:    0.7.0.1
 */