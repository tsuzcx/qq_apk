package com.tencent.mm.sandbox.updater;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.protocal.protobuf.bvk;
import com.tencent.mm.sandbox.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.File;

final class c$3
  implements b.a
{
  c$3(c paramc) {}
  
  public final void b(int paramInt1, int paramInt2, bvk parambvk)
  {
    AppMethodBeat.i(28859);
    if (paramInt1 != 0)
    {
      ab.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "scene error. netRet=".concat(String.valueOf(paramInt1)));
      if (paramInt1 == -2) {
        new File(this.ykM.amg()).delete();
      }
      c.e(this.ykM);
      this.ykM.a(c.b(this.ykM));
      AppMethodBeat.o(28859);
      return;
    }
    ab.i("MicroMsg.NetSceneGetUpdatePackFromCDN", "scene success");
    try
    {
      if (e.cM(this.ykM.amg()) < c.f(this.ykM))
      {
        ab.i("MicroMsg.NetSceneGetUpdatePackFromCDN", "scene continue;");
        this.ykM.a(c.b(this.ykM));
        AppMethodBeat.o(28859);
        return;
      }
      if (c.g(this.ykM))
      {
        if (!c.h(this.ykM).equalsIgnoreCase(g.getMD5(this.ykM.amg())))
        {
          ab.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "pack md5 check error");
          new File(this.ykM.amg()).delete();
          c.b(this.ykM).b(2, -1, parambvk);
          AppMethodBeat.o(28859);
          return;
        }
        c.a(this.ykM, parambvk);
        AppMethodBeat.o(28859);
        return;
      }
      if (!c.i(this.ykM).equalsIgnoreCase(g.getMD5(this.ykM.amg())))
      {
        ab.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "update pack check error");
        new File(this.ykM.amg()).delete();
        c.b(this.ykM).b(-1, -1, parambvk);
        AppMethodBeat.o(28859);
        return;
      }
      e.h(com.tencent.mm.sandbox.monitor.c.ykf, c.j(this.ykM) + ".temp", c.k(this.ykM) + ".apk");
      c.b(this.ykM).b(200, 0, parambvk);
      AppMethodBeat.o(28859);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "error occured during pack processing");
      ab.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", localException, "", new Object[0]);
      c.b(this.ykM).b(-1, -1, parambvk);
      AppMethodBeat.o(28859);
    }
  }
  
  public final void dW(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(28858);
    ab.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "progress, total=" + paramInt1 + ", offset=" + paramInt2);
    c.b(this.ykM).dW(paramInt1, paramInt2);
    AppMethodBeat.o(28858);
  }
  
  public final void nJ(long paramLong)
  {
    AppMethodBeat.i(28860);
    c.b(this.ykM).nJ(paramLong);
    AppMethodBeat.o(28860);
  }
  
  public final void nK(long paramLong)
  {
    AppMethodBeat.i(28861);
    c.b(this.ykM).nK(paramLong);
    AppMethodBeat.o(28861);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.c.3
 * JD-Core Version:    0.7.0.1
 */