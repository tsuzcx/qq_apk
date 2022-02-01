package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bto;
import com.tencent.mm.protocal.protobuf.btp;
import com.tencent.mm.sdk.platformtools.Log;

public final class q
  extends com.tencent.mm.ak.q
  implements m
{
  private i heq;
  public final d rr;
  public Object tag;
  
  public q(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(78888);
    Log.d("MicroMsg.NetSceneGetReadingModeInfoProxy", "NetSceneSetOAuthScope doScene url[%s], userAgent[%s], width[%d], height[%d]", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new bto();
    ((d.a)localObject).iLO = new btp();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/getreadingmodeinfo";
    ((d.a)localObject).funcId = 673;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (bto)this.rr.iLK.iLR;
    ((bto)localObject).URL = paramString1;
    ((bto)localObject).Mae = paramString2;
    ((bto)localObject).Width = paramInt1;
    ((bto)localObject).Height = paramInt2;
    AppMethodBeat.o(78888);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(78890);
    Log.i("MicroMsg.NetSceneGetReadingModeInfoProxy", "doScene");
    this.heq = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(78890);
    return i;
  }
  
  public final int getType()
  {
    return 673;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78889);
    Log.i("MicroMsg.NetSceneGetReadingModeInfoProxy", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    this.heq.onSceneEnd(paramInt2, paramInt3, paramString, this);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      Log.e("MicroMsg.NetSceneGetReadingModeInfoProxy", "errType = " + paramInt2 + ", errCode = " + paramInt3);
      AppMethodBeat.o(78889);
      return;
    }
    AppMethodBeat.o(78889);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.q
 * JD-Core Version:    0.7.0.1
 */