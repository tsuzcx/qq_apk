package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cus;
import com.tencent.mm.protocal.protobuf.cut;
import com.tencent.mm.sdk.platformtools.Log;

public final class ac
  extends q
  implements m
{
  public cut Pyy;
  private int Pyz;
  public int businessType;
  private i callback;
  public String fIY;
  public int fPp;
  private d lKU;
  public int scene;
  public String sessionId;
  
  public ac(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString1, long paramLong, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(211377);
    this.scene = paramInt1;
    this.Pyz = paramInt3;
    this.fPp = paramInt4;
    this.businessType = paramInt2;
    this.fIY = paramString2;
    this.sessionId = paramString3;
    Log.i("MicroMsg.FTS.NetSceneWebSearchGuide", "scene %d, h5Version=%d type=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt3), Integer.valueOf(paramInt2) });
    Object localObject = new d.a();
    ((d.a)localObject).funcId = 1048;
    ((d.a)localObject).uri = "/cgi-bin/mmsearch-bin/searchguide";
    ((d.a)localObject).lBU = new cus();
    ((d.a)localObject).lBV = new cut();
    this.lKU = ((d.a)localObject).bgN();
    localObject = (cus)d.b.b(this.lKU.lBR);
    ((cus)localObject).CPw = paramInt1;
    ((cus)localObject).Tkv = paramInt3;
    ((cus)localObject).TwK = ai.czn();
    ((cus)localObject).CQK = paramInt2;
    ((cus)localObject).vhq = paramString1;
    ((cus)localObject).TCv = paramLong;
    ((cus)localObject).SessionId = paramString3;
    ((cus)localObject).TCw = paramString4;
    ((cus)localObject).TwL = ai.gQO();
    ah.c(paramInt1, paramString3, "", "", paramString2, paramInt2);
    AppMethodBeat.o(211377);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(117639);
    this.callback = parami;
    int i = dispatch(paramg, this.lKU, this);
    AppMethodBeat.o(117639);
    return i;
  }
  
  public final int getType()
  {
    return 1048;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(117640);
    Log.i("MicroMsg.FTS.NetSceneWebSearchGuide", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(117640);
      return;
    }
    this.Pyy = ((cut)d.c.b(this.lKU.lBS));
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(117640);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.ac
 * JD-Core Version:    0.7.0.1
 */