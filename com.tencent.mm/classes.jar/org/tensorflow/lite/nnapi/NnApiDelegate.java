package org.tensorflow.lite.nnapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.tensorflow.lite.TensorFlowLite;
import org.tensorflow.lite.b;

public class NnApiDelegate
  implements AutoCloseable, b
{
  public long ajZK;
  
  public NnApiDelegate()
  {
    this(new a());
    AppMethodBeat.i(187252);
    AppMethodBeat.o(187252);
  }
  
  private NnApiDelegate(a parama)
  {
    AppMethodBeat.i(187245);
    TensorFlowLite.init();
    int j = parama.ajZM;
    String str1 = parama.ajZN;
    String str2 = parama.cacheDir;
    String str3 = parama.ajZO;
    int i;
    if (parama.ajZP != null)
    {
      i = parama.ajZP.intValue();
      if (parama.ajZQ == null) {
        break label142;
      }
    }
    label142:
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool4;
      if (parama.ajZQ != null)
      {
        bool2 = bool4;
        if (parama.ajZQ.booleanValue()) {
          bool2 = false;
        }
      }
      if (parama.ajZR != null) {
        bool3 = parama.ajZR.booleanValue();
      }
      this.ajZK = createDelegate(j, str1, str2, str3, i, bool1, bool2, bool3);
      AppMethodBeat.o(187245);
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
    AppMethodBeat.i(187286);
    if (this.ajZK != 0L)
    {
      deleteDelegate(this.ajZK);
      this.ajZK = 0L;
    }
    AppMethodBeat.o(187286);
  }
  
  public final long getNativeHandle()
  {
    return this.ajZK;
  }
  
  public static final class a
  {
    int ajZM = -1;
    String ajZN = null;
    String ajZO = null;
    Integer ajZP = null;
    Boolean ajZQ = null;
    Boolean ajZR = null;
    String cacheDir = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     org.tensorflow.lite.nnapi.NnApiDelegate
 * JD-Core Version:    0.7.0.1
 */