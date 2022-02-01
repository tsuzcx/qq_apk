package com.tencent.mm.plugin.sns.model;

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
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.eac;
import com.tencent.mm.protocal.protobuf.ead;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import java.util.Vector;

public final class r
  extends q
  implements m
{
  public static List<Long> DIc;
  public boolean DIr;
  public h DIs;
  public i callback;
  private long ece;
  public d rr;
  
  static
  {
    AppMethodBeat.i(95600);
    DIc = new Vector();
    AppMethodBeat.o(95600);
  }
  
  public r(long paramLong)
  {
    AppMethodBeat.i(95597);
    this.DIr = false;
    this.DIs = null;
    this.ece = paramLong;
    d.a locala = new d.a();
    locala.iLN = new eac();
    locala.iLO = new ead();
    locala.uri = "/cgi-bin/micromsg-bin/mmsnsobjectdetail";
    locala.funcId = 210;
    locala.iLP = 101;
    locala.respCmdId = 1000000101;
    this.rr = locala.aXF();
    ((eac)this.rr.iLK.iLR).Id = paramLong;
    Log.d("MicroMsg.NetSceneSnsObjectDetial", "req snsId ".concat(String.valueOf(paramLong)));
    AppMethodBeat.o(95597);
  }
  
  private static boolean Jj(long paramLong)
  {
    AppMethodBeat.i(95596);
    DIc.remove(Long.valueOf(paramLong));
    AppMethodBeat.o(95596);
    return true;
  }
  
  public static boolean Jk(long paramLong)
  {
    AppMethodBeat.i(95595);
    if (DIc.contains(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(95595);
      return false;
    }
    DIc.add(Long.valueOf(paramLong));
    AppMethodBeat.o(95595);
    return true;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(95598);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(95598);
    return i;
  }
  
  public final int getType()
  {
    return 210;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(95599);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      Jj(this.ece);
      AppMethodBeat.o(95599);
      return;
    }
    params = ((ead)this.rr.iLL.iLR).MZy;
    if (params != null) {
      Log.i("MicroMsg.NetSceneSnsObjectDetial", "snsdetail xml " + z.b(params.ObjectDesc));
    }
    an.e(params);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    Jj(this.ece);
    AppMethodBeat.o(95599);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.r
 * JD-Core Version:    0.7.0.1
 */