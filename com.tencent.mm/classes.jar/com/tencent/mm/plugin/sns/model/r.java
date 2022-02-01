package com.tencent.mm.plugin.sns.model;

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
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.fek;
import com.tencent.mm.protocal.protobuf.fel;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

public final class r
  extends p
  implements m
{
  public static List<Long> Qsd;
  public boolean Qss;
  public o Qst;
  public h callback;
  private long ibq;
  public c rr;
  
  static
  {
    AppMethodBeat.i(95600);
    Qsd = new Vector();
    AppMethodBeat.o(95600);
  }
  
  public r(long paramLong)
  {
    AppMethodBeat.i(95597);
    this.Qss = false;
    this.Qst = null;
    this.ibq = paramLong;
    c.a locala = new c.a();
    locala.otE = new fek();
    locala.otF = new fel();
    locala.uri = "/cgi-bin/micromsg-bin/mmsnsobjectdetail";
    locala.funcId = 210;
    locala.otG = 101;
    locala.respCmdId = 1000000101;
    this.rr = locala.bEF();
    ((fek)c.b.b(this.rr.otB)).Id = paramLong;
    Log.d("MicroMsg.NetSceneSnsObjectDetial", "req snsId ".concat(String.valueOf(paramLong)));
    AppMethodBeat.o(95597);
  }
  
  private static boolean uI(long paramLong)
  {
    AppMethodBeat.i(95596);
    Qsd.remove(Long.valueOf(paramLong));
    AppMethodBeat.o(95596);
    return true;
  }
  
  public static boolean uJ(long paramLong)
  {
    AppMethodBeat.i(95595);
    if (Qsd.contains(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(95595);
      return false;
    }
    Qsd.add(Long.valueOf(paramLong));
    AppMethodBeat.o(95595);
    return true;
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(95598);
    this.callback = paramh;
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
      uI(this.ibq);
      AppMethodBeat.o(95599);
      return;
    }
    paramArrayOfByte = ((fel)c.c.b(this.rr.otC)).abDT;
    if (paramArrayOfByte != null)
    {
      Log.i("MicroMsg.NetSceneSnsObjectDetial", "snsdetail xml " + w.b(paramArrayOfByte.ObjectDesc));
      params = new SnsObject();
    }
    try
    {
      params.parseFrom(paramArrayOfByte.toByteArray());
      ap.h(params);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      uI(this.ibq);
      AppMethodBeat.o(95599);
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.NetSceneSnsObjectDetial", paramArrayOfByte, "SnsObject parseFrom error", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.r
 * JD-Core Version:    0.7.0.1
 */