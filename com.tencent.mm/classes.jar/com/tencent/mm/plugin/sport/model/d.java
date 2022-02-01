package com.tencent.mm.plugin.sport.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bek;
import com.tencent.mm.protocal.protobuf.bel;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Calendar;

public final class d
  extends n
  implements k
{
  private g callback;
  private b hEg;
  private bek zoX;
  public bel zoY;
  
  public d()
  {
    AppMethodBeat.i(161592);
    Object localObject = new b.a();
    ((b.a)localObject).funcId = 1734;
    ((b.a)localObject).uri = "/cgi-bin/mmoc-bin/hardware/getsteplist";
    ((b.a)localObject).hvt = new bek();
    ((b.a)localObject).hvu = new bel();
    this.hEg = ((b.a)localObject).aAz();
    this.zoX = ((bek)this.hEg.hvr.hvw);
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
    this.zoX.EvF = ((int)(l2 / 1000L));
    this.zoX.EvG = ((int)(l1 / 1000L));
    AppMethodBeat.o(161592);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(149299);
    this.callback = paramg;
    int i = dispatch(parame, this.hEg, this);
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
    ac.i("MicroMsg.Sport.NetSceneGetStepList", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.zoY = ((bel)this.hEg.hvs.hvw);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(149300);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.model.d
 * JD-Core Version:    0.7.0.1
 */