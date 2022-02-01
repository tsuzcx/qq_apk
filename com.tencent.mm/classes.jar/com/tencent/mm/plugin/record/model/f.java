package com.tencent.mm.plugin.record.model;

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
import com.tencent.mm.protocal.protobuf.aay;
import com.tencent.mm.protocal.protobuf.aaz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class f
  extends p
  implements m
{
  private a NAd;
  private h callback;
  private c rr;
  
  public f(String paramString1, String paramString2, String paramString3, int paramInt, a parama)
  {
    AppMethodBeat.i(9462);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new aay();
    ((c.a)localObject).otF = new aaz();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/checkmd5";
    ((c.a)localObject).funcId = 939;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (aay)c.b.b(this.rr.otB);
    ((aay)localObject).fileid = paramString1;
    ((aay)localObject).md5 = paramString2;
    ((aay)localObject).YZH = paramString3;
    ((aay)localObject).Zjp = paramInt;
    this.NAd = parama;
    Log.i("MicroMsg.NetSceneCheckMd5", "summersafecdn NetSceneCheckMd5 fileid[%s], md5[%s], newmd5[%s], crc[%d], stack[%s]", new Object[] { ((aay)localObject).fileid, ((aay)localObject).md5, ((aay)localObject).YZH, Integer.valueOf(((aay)localObject).Zjp), Util.getStack() });
    AppMethodBeat.o(9462);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(9463);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(9463);
    return i;
  }
  
  public final int getType()
  {
    return 939;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(9464);
    Log.i("MicroMsg.NetSceneCheckMd5", "summersafecdn onGYNetEnd [%d, %d, %s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    if (this.NAd != null)
    {
      if ((paramInt2 == 0) && (paramInt3 == 0)) {
        break label101;
      }
      paramString = this.NAd;
    }
    for (;;)
    {
      paramArrayOfByte = "";
      params = paramString;
      for (paramString = paramArrayOfByte;; paramString = paramArrayOfByte)
      {
        params.aH(paramString, paramInt2, paramInt3);
        AppMethodBeat.o(9464);
        return;
        label101:
        params = (aaz)c.c.b(((c)params).otC);
        paramString = this.NAd;
        if (params == null) {
          break;
        }
        paramArrayOfByte = params.aeskey;
        params = paramString;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void aH(String paramString, int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.record.model.f
 * JD-Core Version:    0.7.0.1
 */