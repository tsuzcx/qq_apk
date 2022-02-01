package com.tencent.mm.plugin.remittance.model;

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
import com.tencent.mm.protocal.protobuf.dac;
import com.tencent.mm.protocal.protobuf.dad;
import com.tencent.mm.sdk.platformtools.Log;

public final class aa
  extends q
  implements m
{
  public dad Imf;
  String Img;
  private String Imh;
  private i callback;
  private long gbJ;
  private d kwO;
  
  public aa(String paramString1, long paramLong, String paramString2)
  {
    AppMethodBeat.i(277176);
    this.gbJ = 0L;
    Log.i("Micromsg.NetSceneRemittanceMsgCheck", "transferID: %s, amount:%s msgCheckStr:%s", new Object[] { paramString1, Long.valueOf(paramLong), paramString2 });
    this.Img = paramString1;
    this.gbJ = paramLong;
    this.Imh = paramString2;
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new dac();
    ((d.a)localObject).lBV = new dad();
    ((d.a)localObject).funcId = 6230;
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/transfermsgcheck";
    this.kwO = ((d.a)localObject).bgN();
    localObject = (dac)d.b.b(this.kwO.lBR);
    ((dac)localObject).Inf = paramString1;
    ((dac)localObject).gbJ = paramLong;
    ((dac)localObject).THx = paramString2;
    AppMethodBeat.o(277176);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(277177);
    this.callback = parami;
    int i = dispatch(paramg, this.kwO, this);
    AppMethodBeat.o(277177);
    return i;
  }
  
  public final int getType()
  {
    return 6230;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(277178);
    Log.i("Micromsg.NetSceneRemittanceMsgCheck", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.Imf = ((dad)d.c.b(((d)params).lBS));
    Log.i("Micromsg.NetSceneRemittanceMsgCheck", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.Imf.tqa), this.Imf.tqb });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(277178);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.aa
 * JD-Core Version:    0.7.0.1
 */