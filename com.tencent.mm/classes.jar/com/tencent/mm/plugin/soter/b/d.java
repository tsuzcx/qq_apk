package com.tencent.mm.plugin.soter.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class d
  extends q
  implements m
{
  private h Fhs;
  
  public abstract void MO(int paramInt);
  
  public abstract void d(int paramInt1, int paramInt2, String paramString, s params);
  
  public abstract void dKB();
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    int i = 1;
    Log.i("MicroMsg.NetSceneSoterBase", "onGYNetEnd errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.Fhs = new h(new a((byte)0));
    this.Fhs.Fhv = -3202;
    paramArrayOfByte = this.Fhs;
    if ((paramInt2 == 4) && (paramInt3 == -3200))
    {
      com.tencent.soter.a.a.a(new h.1(paramArrayOfByte), true, new f());
      paramInt1 = i;
    }
    for (;;)
    {
      if (paramInt1 == 0) {
        d(paramInt2, paramInt3, paramString, params);
      }
      return;
      if ((paramInt2 == 4) && (paramInt3 == paramArrayOfByte.Fhv))
      {
        paramInt1 = i;
        if (paramArrayOfByte.Fhu != null)
        {
          paramArrayOfByte.Fhu.flA();
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
    
    public final void aas(int paramInt)
    {
      AppMethodBeat.i(130810);
      d.this.MO(paramInt);
      AppMethodBeat.o(130810);
    }
    
    public final void flA()
    {
      AppMethodBeat.i(130809);
      d.this.dKB();
      AppMethodBeat.o(130809);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.b.d
 * JD-Core Version:    0.7.0.1
 */