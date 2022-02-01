package com.tencent.mm.plugin.soter.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class d
  extends q
  implements m
{
  private h LvX;
  
  public abstract void Sl(int paramInt);
  
  public abstract void d(int paramInt1, int paramInt2, String paramString, s params);
  
  public abstract void epa();
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    int i = 1;
    Log.i("MicroMsg.NetSceneSoterBase", "onGYNetEnd errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.LvX = new h(new a((byte)0));
    this.LvX.Lwa = -3202;
    paramArrayOfByte = this.LvX;
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
      if ((paramInt2 == 4) && (paramInt3 == paramArrayOfByte.Lwa))
      {
        paramInt1 = i;
        if (paramArrayOfByte.LvZ != null)
        {
          paramArrayOfByte.LvZ.fZW();
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
    
    public final void ahM(int paramInt)
    {
      AppMethodBeat.i(130810);
      d.this.Sl(paramInt);
      AppMethodBeat.o(130810);
    }
    
    public final void fZW()
    {
      AppMethodBeat.i(130809);
      d.this.epa();
      AppMethodBeat.o(130809);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.b.d
 * JD-Core Version:    0.7.0.1
 */