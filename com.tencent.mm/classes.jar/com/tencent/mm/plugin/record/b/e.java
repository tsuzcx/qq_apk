package com.tencent.mm.plugin.record.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.yx;
import com.tencent.mm.protocal.protobuf.yy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class e
  extends q
  implements m
{
  private a BGv;
  private i callback;
  private d rr;
  
  public e(String paramString1, String paramString2, String paramString3, int paramInt, a parama)
  {
    AppMethodBeat.i(9462);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new yx();
    ((d.a)localObject).iLO = new yy();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/checkmd5";
    ((d.a)localObject).funcId = 939;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (yx)this.rr.iLK.iLR;
    ((yx)localObject).fileid = paramString1;
    ((yx)localObject).md5 = paramString2;
    ((yx)localObject).LaE = paramString3;
    ((yx)localObject).LjY = paramInt;
    this.BGv = parama;
    Log.i("MicroMsg.NetSceneCheckMd5", "summersafecdn NetSceneCheckMd5 fileid[%s], md5[%s], newmd5[%s], crc[%d], stack[%s]", new Object[] { ((yx)localObject).fileid, ((yx)localObject).md5, ((yx)localObject).LaE, Integer.valueOf(((yx)localObject).LjY), Util.getStack() });
    AppMethodBeat.o(9462);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(9463);
    this.callback = parami;
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
    if (this.BGv != null)
    {
      if ((paramInt2 == 0) && (paramInt3 == 0)) {
        break label101;
      }
      paramString = this.BGv;
    }
    for (;;)
    {
      paramArrayOfByte = "";
      params = paramString;
      for (paramString = paramArrayOfByte;; paramString = paramArrayOfByte)
      {
        params.ax(paramString, paramInt2, paramInt3);
        AppMethodBeat.o(9464);
        return;
        label101:
        params = (yy)((d)params).iLL.iLR;
        paramString = this.BGv;
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
    public abstract void ax(String paramString, int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.e
 * JD-Core Version:    0.7.0.1
 */