package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;

public final class ak
  extends com.tencent.mm.o.a
  implements com.tencent.mm.cg.a.a<String>
{
  public bi yMq;
  
  public ak() {}
  
  public ak(String paramString)
  {
    super(paramString);
  }
  
  public final void ak(int paramInt, long paramLong)
  {
    AppMethodBeat.i(60132);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(60132);
      return;
      hJ((int)paramLong);
      AppMethodBeat.o(60132);
      return;
      setStatus((int)paramLong);
      AppMethodBeat.o(60132);
      return;
      hL((int)paramLong);
      AppMethodBeat.o(60132);
      return;
      fK(paramLong);
      AppMethodBeat.o(60132);
      return;
      fL(paramLong);
      AppMethodBeat.o(60132);
      return;
      hN((int)paramLong);
      AppMethodBeat.o(60132);
      return;
      hO((int)paramLong);
      AppMethodBeat.o(60132);
      return;
      hP((int)paramLong);
      AppMethodBeat.o(60132);
      return;
      hR((int)paramLong);
    }
  }
  
  public final void aq(bi parambi)
  {
    AppMethodBeat.i(60130);
    setStatus(parambi.field_status);
    hL(parambi.field_isSend);
    if (parambi.byk()) {}
    label95:
    for (;;)
    {
      long l = parambi.field_createTime;
      for (ak localak = this;; localak = this)
      {
        localak.fK(l);
        if (!parambi.dxQ()) {
          break;
        }
        setContent(parambi.dyr());
        AppMethodBeat.o(60130);
        return;
        if (parambi.field_status != 1) {
          break label95;
        }
        l = 9223372036854775807L;
      }
      setContent(parambi.field_content);
      AppMethodBeat.o(60130);
      return;
    }
  }
  
  public final void bJ(int paramInt, String paramString)
  {
    AppMethodBeat.i(60133);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(60133);
      return;
      setUsername(paramString);
      AppMethodBeat.o(60133);
      return;
      setContent(paramString);
      AppMethodBeat.o(60133);
      return;
      jV(paramString);
      AppMethodBeat.o(60133);
      return;
      jW(paramString);
      AppMethodBeat.o(60133);
      return;
      jX(paramString);
      AppMethodBeat.o(60133);
      return;
      jZ(paramString);
    }
  }
  
  public final void dvP() {}
  
  public final void dxc()
  {
    AppMethodBeat.i(60131);
    setStatus(0);
    hL(0);
    setContent("");
    jV("0");
    hJ(0);
    hR(0);
    fM(0L);
    hQ(0);
    hQ(0);
    super.jW("");
    super.jX("");
    AppMethodBeat.o(60131);
  }
  
  public final void r(int paramInt, byte[] paramArrayOfByte) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.ak
 * JD-Core Version:    0.7.0.1
 */