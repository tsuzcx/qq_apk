package com.tencent.mm.plugin.websearch.api;

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
import com.tencent.mm.protocal.protobuf.dly;
import com.tencent.mm.protocal.protobuf.dlz;
import com.tencent.mm.sdk.platformtools.Log;

public final class ad
  extends p
  implements m
{
  public dlz WoF;
  private int WoG;
  public int businessType;
  private h callback;
  public String hOG;
  public int hVk;
  private c oDw;
  public int scene;
  public String sessionId;
  
  public ad(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString1, long paramLong, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(315322);
    this.scene = paramInt1;
    this.WoG = paramInt3;
    this.hVk = paramInt4;
    this.businessType = paramInt2;
    this.hOG = paramString2;
    this.sessionId = paramString3;
    Log.i("MicroMsg.FTS.NetSceneWebSearchGuide", "scene %d, h5Version=%d type=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt3), Integer.valueOf(paramInt2) });
    Object localObject = new c.a();
    ((c.a)localObject).funcId = 1048;
    ((c.a)localObject).uri = "/cgi-bin/mmsearch-bin/searchguide";
    ((c.a)localObject).otE = new dly();
    ((c.a)localObject).otF = new dlz();
    this.oDw = ((c.a)localObject).bEF();
    localObject = (dly)c.b.b(this.oDw.otB);
    ((dly)localObject).IJG = paramInt1;
    ((dly)localObject).aayc = paramInt3;
    ((dly)localObject).aaLr = aj.dch();
    ((dly)localObject).IKW = paramInt2;
    ((dly)localObject).yts = paramString1;
    ((dly)localObject).aaSb = paramLong;
    ((dly)localObject).SessionId = paramString3;
    ((dly)localObject).aaSc = paramString4;
    ((dly)localObject).aaLs = aj.iqa();
    ai.d(paramInt1, paramString3, "", "", paramString2, paramInt2);
    AppMethodBeat.o(315322);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(117639);
    this.callback = paramh;
    int i = dispatch(paramg, this.oDw, this);
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
      ai.a(this.scene, this.sessionId, "", "", this.hOG, false, "", getType());
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(117640);
      return;
    }
    this.WoF = ((dlz)c.c.b(this.oDw.otC));
    ai.a(this.scene, this.sessionId, "", "", this.hOG, true, "", getType());
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(117640);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.ad
 * JD-Core Version:    0.7.0.1
 */