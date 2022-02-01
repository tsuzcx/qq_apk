package com.tencent.mm.plugin.soter.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class d
  extends p
  implements m
{
  private h RZw;
  
  public abstract void VE(int paramInt);
  
  public abstract void d(int paramInt1, int paramInt2, String paramString, s params);
  
  public abstract void fuc();
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    int i = 1;
    Log.i("MicroMsg.NetSceneSoterBase", "onGYNetEnd errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.RZw = new h(new a((byte)0));
    this.RZw.RZz = -3202;
    paramArrayOfByte = this.RZw;
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
      if ((paramInt2 == 4) && (paramInt3 == paramArrayOfByte.RZz))
      {
        paramInt1 = i;
        if (paramArrayOfByte.RZy != null)
        {
          paramArrayOfByte.RZy.htn();
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
    
    public final void amN(int paramInt)
    {
      AppMethodBeat.i(130810);
      d.this.VE(paramInt);
      AppMethodBeat.o(130810);
    }
    
    public final void htn()
    {
      AppMethodBeat.i(130809);
      d.this.fuc();
      AppMethodBeat.o(130809);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.b.d
 * JD-Core Version:    0.7.0.1
 */