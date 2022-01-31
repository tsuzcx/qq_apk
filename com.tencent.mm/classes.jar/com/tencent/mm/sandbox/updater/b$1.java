package com.tencent.mm.sandbox.updater;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ara;
import com.tencent.mm.protocal.protobuf.bvk;
import com.tencent.mm.sandbox.b.a;
import com.tencent.mm.sandbox.monitor.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.File;

final class b$1
  implements b.a
{
  b$1(b paramb) {}
  
  public final void b(int paramInt1, int paramInt2, bvk parambvk)
  {
    AppMethodBeat.i(28843);
    if ((paramInt1 != 200) || (paramInt2 != 0) || ((parambvk != null) && (parambvk.getBaseResponse().Ret != 0)))
    {
      if ((!this.ykE.drv()) && (b.a(this.ykE) < b.b(this.ykE).length * 5))
      {
        this.ykE.a(b.c(this.ykE));
        AppMethodBeat.o(28843);
        return;
      }
      b.c(this.ykE).b(paramInt1, paramInt2, parambvk);
      AppMethodBeat.o(28843);
      return;
    }
    ara localara = (ara)parambvk;
    ab.d("MicroMsg.NetSceneGetUpdatePack", "onGYNetEnd : file dir = " + com.tencent.mm.compatible.util.e.eQx);
    ab.d("MicroMsg.NetSceneGetUpdatePack", "onGYNetEnd : total len = " + localara.pIx);
    ab.d("MicroMsg.NetSceneGetUpdatePack", "onGYNetEnd : start pos = " + localara.pIy);
    ab.d("MicroMsg.NetSceneGetUpdatePack", "onGYNetEnd : data len = " + localara.pIz);
    if ((localara.pIz <= 0) || (localara.pIA == null))
    {
      ab.e("MicroMsg.NetSceneGetUpdatePack", "data is null");
      b.c(this.ykE).b(paramInt1, -1, null);
      AppMethodBeat.o(28843);
      return;
    }
    if (localara.pIA.getILen() != localara.pIz)
    {
      ab.e("MicroMsg.NetSceneGetUpdatePack", "data len not match with data buf, dataLen = " + localara.pIz + " data buf len = " + localara.pIA.getILen());
      b.c(this.ykE).b(4, -1, null);
      AppMethodBeat.o(28843);
      return;
    }
    if ((localara.pIy < 0) || (localara.pIy + localara.pIz > localara.pIx))
    {
      ab.e("MicroMsg.NetSceneGetUpdatePack", "startPos = " + localara.pIy + " dataLen = " + localara.pIz + " totalLen = " + localara.pIx);
      b.c(this.ykE).b(4, -1, null);
      AppMethodBeat.o(28843);
      return;
    }
    if (localara.pIx <= 0)
    {
      ab.e("MicroMsg.NetSceneGetUpdatePack", "totalLen is invalid: totalLen = " + localara.pIx);
      b.c(this.ykE).b(4, -1, null);
      AppMethodBeat.o(28843);
      return;
    }
    String str1 = c.ykf;
    String str2 = b.d(this.ykE);
    byte[] arrayOfByte = localara.pIA.getBuffer().toByteArray();
    paramInt1 = com.tencent.mm.a.e.b(str1, str2 + ".temp", arrayOfByte);
    if (paramInt1 != 0)
    {
      ab.e("MicroMsg.NetSceneGetUpdatePack", "appendBuf failed : ".concat(String.valueOf(paramInt1)));
      b.c(this.ykE).b(4, -1, null);
      AppMethodBeat.o(28843);
      return;
    }
    b.a(this.ykE, localara.pIz + localara.pIy);
    b.b(this.ykE, localara.pIx);
    b.c(this.ykE).dW(localara.pIx, localara.pIy);
    if (localara.pIy + localara.pIz >= localara.pIx)
    {
      try
      {
        if (b.f(this.ykE).equalsIgnoreCase(g.getMD5(b.e(this.ykE))))
        {
          com.tencent.mm.a.e.h(c.ykf, b.g(this.ykE) + ".temp", b.h(this.ykE) + ".apk");
          b.c(this.ykE).b(200, 0, parambvk);
          AppMethodBeat.o(28843);
          return;
        }
      }
      catch (Exception parambvk)
      {
        ab.printErrStackTrace("MicroMsg.NetSceneGetUpdatePack", parambvk, "", new Object[0]);
        AppMethodBeat.o(28843);
        return;
      }
      ab.e("MicroMsg.NetSceneGetUpdatePack", "update pack check error");
      new File(b.i(this.ykE)).delete();
      b.c(this.ykE).b(-1, -1, parambvk);
      AppMethodBeat.o(28843);
      return;
    }
    this.ykE.a(b.c(this.ykE));
    AppMethodBeat.o(28843);
  }
  
  public final void dW(int paramInt1, int paramInt2) {}
  
  public final void nJ(long paramLong)
  {
    AppMethodBeat.i(28844);
    b.c(this.ykE).nJ(paramLong);
    AppMethodBeat.o(28844);
  }
  
  public final void nK(long paramLong)
  {
    AppMethodBeat.i(28845);
    b.c(this.ykE).nK(paramLong);
    AppMethodBeat.o(28845);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.b.1
 * JD-Core Version:    0.7.0.1
 */