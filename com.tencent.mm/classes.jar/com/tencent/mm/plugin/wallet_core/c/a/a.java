package com.tencent.mm.plugin.wallet_core.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ebv;
import com.tencent.mm.protocal.protobuf.ebw;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  extends p
  implements m
{
  private h callback;
  private c rr;
  
  public a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    AppMethodBeat.i(69967);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new ebv();
    ((c.a)localObject).otF = new ebw();
    ((c.a)localObject).uri = "/cgi-bin/mmpay-bin/payibgcheckjsapisign";
    ((c.a)localObject).funcId = 1767;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (ebv)c.b.b(this.rr.otB);
    ((ebv)localObject).oOI = paramString1;
    ((ebv)localObject).ZjJ = paramString4;
    ((ebv)localObject).ZjI = paramString2;
    ((ebv)localObject).ZjK = paramString5;
    ((ebv)localObject).ZjL = paramString6;
    ((ebv)localObject).YNW = paramString3;
    ((ebv)localObject).ZiL = paramString7;
    AppMethodBeat.o(69967);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(69969);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(69969);
    return i;
  }
  
  public final int getType()
  {
    return 1767;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(69968);
    Log.i("MicroMsg.NetSceneIbgCheckJsapi", "check jsapi: errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramArrayOfByte = (ebw)c.c.b(((c)params).otC);
    paramInt1 = paramInt3;
    params = paramString;
    if (paramInt3 == 0)
    {
      paramInt1 = paramInt3;
      params = paramString;
      if (paramInt2 == 0)
      {
        paramInt1 = paramArrayOfByte.ytv;
        params = paramArrayOfByte.ytw;
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt1, params, this);
    AppMethodBeat.o(69968);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.a.a
 * JD-Core Version:    0.7.0.1
 */