package com.tencent.mm.plugin.secinforeport.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public enum d
  implements c
{
  private static c qEp;
  
  static
  {
    AppMethodBeat.i(126188);
    qEo = new d("INSTANCE");
    qEq = new d[] { qEo };
    qEp = new a((byte)0);
    AppMethodBeat.o(126188);
  }
  
  private d() {}
  
  public static void a(c paramc)
  {
    if (paramc != null) {
      qEp = paramc;
    }
  }
  
  public final void CU(int paramInt)
  {
    AppMethodBeat.i(126186);
    qEp.CU(paramInt);
    AppMethodBeat.o(126186);
  }
  
  public final boolean ac(int paramInt, long paramLong)
  {
    AppMethodBeat.i(126184);
    boolean bool = qEp.ac(paramInt, paramLong);
    AppMethodBeat.o(126184);
    return bool;
  }
  
  public final void fq(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(126185);
    qEp.fq(paramInt1, paramInt2);
    AppMethodBeat.o(126185);
  }
  
  public final void p(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(126187);
    qEp.p(paramInt, paramArrayOfByte);
    AppMethodBeat.o(126187);
  }
  
  static final class a
    implements c
  {
    public final void CU(int paramInt)
    {
      AppMethodBeat.i(126180);
      ab.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
      AppMethodBeat.o(126180);
    }
    
    public final boolean ac(int paramInt, long paramLong)
    {
      AppMethodBeat.i(126178);
      ab.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
      AppMethodBeat.o(126178);
      return false;
    }
    
    public final void fq(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(126179);
      ab.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
      AppMethodBeat.o(126179);
    }
    
    public final void p(int paramInt, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(126181);
      ab.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
      AppMethodBeat.o(126181);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.secinforeport.a.d
 * JD-Core Version:    0.7.0.1
 */