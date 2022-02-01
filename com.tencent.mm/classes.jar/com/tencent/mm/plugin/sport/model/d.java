package com.tencent.mm.plugin.sport.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bjk;
import com.tencent.mm.protocal.protobuf.bjl;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Calendar;

public final class d
  extends n
  implements k
{
  private bjk AYu;
  public bjl AYv;
  private f callback;
  private b hZD;
  
  public d()
  {
    AppMethodBeat.i(161592);
    Object localObject = new b.a();
    ((b.a)localObject).funcId = 1734;
    ((b.a)localObject).uri = "/cgi-bin/mmoc-bin/hardware/getsteplist";
    ((b.a)localObject).hQF = new bjk();
    ((b.a)localObject).hQG = new bjl();
    this.hZD = ((b.a)localObject).aDS();
    this.AYu = ((bjk)this.hZD.hQD.hQJ);
    localObject = Calendar.getInstance();
    ((Calendar)localObject).add(5, -1);
    ((Calendar)localObject).set(10, 23);
    ((Calendar)localObject).set(12, 59);
    ((Calendar)localObject).set(13, 59);
    long l1 = ((Calendar)localObject).getTimeInMillis();
    ((Calendar)localObject).add(5, -120);
    ((Calendar)localObject).set(10, 0);
    ((Calendar)localObject).set(12, 0);
    ((Calendar)localObject).set(13, 0);
    long l2 = ((Calendar)localObject).getTimeInMillis();
    this.AYu.GvI = ((int)(l2 / 1000L));
    this.AYu.GvJ = ((int)(l1 / 1000L));
    AppMethodBeat.o(161592);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(149299);
    this.callback = paramf;
    int i = dispatch(parame, this.hZD, this);
    AppMethodBeat.o(149299);
    return i;
  }
  
  public final int getType()
  {
    return 1734;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(149300);
    ae.i("MicroMsg.Sport.NetSceneGetStepList", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.AYv = ((bjl)this.hZD.hQE.hQJ);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(149300);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.model.d
 * JD-Core Version:    0.7.0.1
 */