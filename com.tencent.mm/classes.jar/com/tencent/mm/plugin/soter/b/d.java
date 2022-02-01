package com.tencent.mm.plugin.soter.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.ac;

public abstract class d
  extends n
  implements k
{
  private h znc;
  
  public abstract void Fn(int paramInt);
  
  public abstract void cHM();
  
  public abstract void d(int paramInt1, int paramInt2, String paramString, q paramq);
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    int i = 1;
    ac.i("MicroMsg.NetSceneSoterBase", "onGYNetEnd errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.znc = new h(new a((byte)0));
    this.znc.znf = -3202;
    paramArrayOfByte = this.znc;
    if ((paramInt2 == 4) && (paramInt3 == -3200))
    {
      com.tencent.soter.a.a.a(new h.1(paramArrayOfByte), true, new f());
      paramInt1 = i;
    }
    for (;;)
    {
      if (paramInt1 == 0) {
        d(paramInt2, paramInt3, paramString, paramq);
      }
      return;
      if ((paramInt2 == 4) && (paramInt3 == paramArrayOfByte.znf))
      {
        paramInt1 = i;
        if (paramArrayOfByte.zne != null)
        {
          paramArrayOfByte.zne.dTe();
          paramInt1 = i;
        }
      }
      else
      {
        paramInt1 = 0;
      }
    }
  }
  
  final class a
    implements a
  {
    private a() {}
    
    public final void Qh(int paramInt)
    {
      AppMethodBeat.i(130810);
      d.this.Fn(paramInt);
      AppMethodBeat.o(130810);
    }
    
    public final void dTe()
    {
      AppMethodBeat.i(130809);
      d.this.cHM();
      AppMethodBeat.o(130809);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.b.d
 * JD-Core Version:    0.7.0.1
 */