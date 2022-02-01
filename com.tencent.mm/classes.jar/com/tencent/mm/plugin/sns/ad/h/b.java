package com.tencent.mm.plugin.sns.ad.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.af;
import com.tencent.mm.protocal.protobuf.ag;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
  extends p
  implements m
{
  private h callback;
  private c rr;
  
  public b(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(309871);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new af();
    ((c.a)localObject).otF = new ag();
    ((c.a)localObject).uri = "/cgi-bin/mmoc-bin/adplayinfo/ad_appointment";
    ((c.a)localObject).funcId = 5159;
    this.rr = ((c.a)localObject).bEF();
    localObject = (af)c.b.b(this.rr.otB);
    ((af)localObject).mdG = paramString;
    ((af)localObject).YAM = paramLong;
    ((af)localObject).YAN = paramInt;
    Log.i("NetSceneAdAppointment", "appointmentId=" + paramLong + ", opType=" + paramInt + ", uxInfo=" + paramString);
    AppMethodBeat.o(309871);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(309882);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(309882);
    return i;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(309879);
    int i = this.rr.getType();
    AppMethodBeat.o(309879);
    return i;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(309876);
    Log.i("NetSceneAdAppointment", "errType=" + paramInt2 + ", errCode=" + paramInt3 + ", errMsg=" + paramString);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(309876);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.h.b
 * JD-Core Version:    0.7.0.1
 */