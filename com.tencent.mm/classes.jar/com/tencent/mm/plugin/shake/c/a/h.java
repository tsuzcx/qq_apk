package com.tencent.mm.plugin.shake.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.bx.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dlj;
import com.tencent.mm.protocal.protobuf.dlk;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class h
  extends f
{
  private com.tencent.mm.am.h callback;
  private final c rr;
  
  public h(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    super(0L);
    AppMethodBeat.i(273608);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new dlj();
    ((c.a)localObject).otF = new dlk();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/mmqqshakemusic";
    ((c.a)localObject).funcId = 5245;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (dlj)c.b.b(this.rr.otB);
    ((dlj)localObject).Zsu = new b(paramArrayOfByte);
    ((dlj)localObject).scene = 0;
    if (paramBoolean) {
      i = 1;
    }
    ((dlj)localObject).aaRx = i;
    ((dlj)localObject).oUj = paramInt2;
    ((dlj)localObject).offset = paramInt1;
    ((dlj)localObject).id = String.valueOf(paramInt3);
    AppMethodBeat.o(273608);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(273616);
    dlj localdlj = (dlj)c.b.b(this.rr.otB);
    Log.i("MicroMsg.NetSceneShakeMusicAndSing", "doScene id: %s, offset: %d, endFlag: %d， seq: %d， data length: %d", new Object[] { localdlj.id, Integer.valueOf(localdlj.offset), Integer.valueOf(localdlj.aaRx), Integer.valueOf(localdlj.oUj), Integer.valueOf(localdlj.Zsu.toByteArray().length) });
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(273616);
    return i;
  }
  
  public final esc gXF()
  {
    AppMethodBeat.i(273611);
    dlk localdlk = (dlk)c.c.b(this.rr.otC);
    AppMethodBeat.o(273611);
    return localdlk;
  }
  
  public final int getType()
  {
    return 5245;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(273617);
    params = (dlk)c.c.b(this.rr.otC);
    Log.i("MicroMsg.NetSceneShakeMusicAndSing", "errType: %d, errCode: %d, errMsg: %s, rep: appId: %s， endFlag: %d, maxPacketSize: %d, interval: %d, music size: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, params.appid, Integer.valueOf(params.aaRx), Integer.valueOf(params.aaRz), Integer.valueOf(params.interval), Integer.valueOf(params.aaRA.size()) });
    if ((paramInt2 == 0) && (paramInt3 == 0) && (params.aaRx == 1)) {
      this.hPw = true;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(273617);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.c.a.h
 * JD-Core Version:    0.7.0.1
 */