package com.tencent.mm.plugin.subapp.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ao.c;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;

public final class b
  implements ao.c
{
  private static int Gj(int paramInt)
  {
    if (paramInt == 0)
    {
      i = -1;
      return i;
    }
    int i = 0;
    int j = paramInt;
    paramInt = i;
    for (;;)
    {
      i = paramInt;
      if (paramInt >= 32) {
        break;
      }
      j = j >> 1 & 0x7FFFFFFF;
      i = paramInt;
      if (j == 0) {
        break;
      }
      paramInt += 1;
    }
  }
  
  private static int Gk(int paramInt)
  {
    AppMethodBeat.i(25234);
    paramInt = Gj(paramInt);
    if (paramInt == -1)
    {
      AppMethodBeat.o(25234);
      return 0;
    }
    AppMethodBeat.o(25234);
    return 1 << paramInt;
  }
  
  private String al(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(25229);
    aw.aaz();
    if (!c.isSDCardAvailable())
    {
      AppMethodBeat.o(25229);
      return null;
    }
    String str = am(paramInt, paramBoolean);
    if (com.tencent.mm.a.e.cN(str))
    {
      AppMethodBeat.o(25229);
      return str;
    }
    aak();
    AppMethodBeat.o(25229);
    return null;
  }
  
  private String am(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(25232);
    paramInt = Gk(paramInt);
    if (paramInt == 0)
    {
      AppMethodBeat.o(25232);
      return null;
    }
    String str = B(paramInt, paramBoolean);
    AppMethodBeat.o(25232);
    return str;
  }
  
  public final String B(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(25233);
    if (paramInt == 0)
    {
      AppMethodBeat.o(25233);
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder().append(com.tencent.mm.compatible.util.e.ess).append("vuserpic_").append(Integer.toHexString(paramInt));
    if (paramBoolean) {}
    for (String str = "_HD";; str = "")
    {
      str = str + ".png";
      AppMethodBeat.o(25233);
      return str;
    }
  }
  
  public final void aak()
  {
    AppMethodBeat.i(25230);
    aw.aaz();
    if (!c.isSDCardAvailable())
    {
      AppMethodBeat.o(25230);
      return;
    }
    aw.aaz();
    long l1 = bo.a((Long)c.Ru().get(66051, null), 0L);
    long l2 = bo.aoy();
    if (432000000L > l2 - l1)
    {
      AppMethodBeat.o(25230);
      return;
    }
    aw.aaz();
    c.Ru().set(66051, Long.valueOf(l2));
    new b.a();
    AppMethodBeat.o(25230);
  }
  
  public final String kx(int paramInt)
  {
    AppMethodBeat.i(25227);
    String str = al(paramInt, true);
    AppMethodBeat.o(25227);
    return str;
  }
  
  public final String ky(int paramInt)
  {
    AppMethodBeat.i(25228);
    String str = al(paramInt, false);
    AppMethodBeat.o(25228);
    return str;
  }
  
  public final boolean kz(int paramInt)
  {
    AppMethodBeat.i(25231);
    if (paramInt == 0)
    {
      AppMethodBeat.o(25231);
      return false;
    }
    int i = 0;
    while (i < 32)
    {
      if ((!com.tencent.mm.a.e.cN(B(1 << i & paramInt, false))) || (!com.tencent.mm.a.e.cN(B(1 << i & paramInt, true))))
      {
        AppMethodBeat.o(25231);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(25231);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.a.b
 * JD-Core Version:    0.7.0.1
 */