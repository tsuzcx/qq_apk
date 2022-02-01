package com.tencent.mm.plugin.subapp.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.model.az.c;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.vfs.u;

public final class b
  implements az.c
{
  private static int aiD(int paramInt)
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
  
  private static int aiE(int paramInt)
  {
    AppMethodBeat.i(28913);
    paramInt = aiD(paramInt);
    if (paramInt == -1)
    {
      AppMethodBeat.o(28913);
      return 0;
    }
    AppMethodBeat.o(28913);
    return 1 << paramInt;
  }
  
  private String bl(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(28908);
    bh.beI();
    if (!c.isSDCardAvailable())
    {
      AppMethodBeat.o(28908);
      return null;
    }
    String str = bm(paramInt, paramBoolean);
    if (u.agG(str))
    {
      AppMethodBeat.o(28908);
      return str;
    }
    bet();
    AppMethodBeat.o(28908);
    return null;
  }
  
  private String bm(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(28911);
    paramInt = aiE(paramInt);
    if (paramInt == 0)
    {
      AppMethodBeat.o(28911);
      return null;
    }
    String str = G(paramInt, paramBoolean);
    AppMethodBeat.o(28911);
    return str;
  }
  
  public final String G(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(28912);
    if (paramInt == 0)
    {
      AppMethodBeat.o(28912);
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder().append(com.tencent.mm.loader.j.b.aSP()).append("vuserpic_").append(Integer.toHexString(paramInt));
    if (paramBoolean) {}
    for (String str = "_HD";; str = "")
    {
      str = str + ".png";
      AppMethodBeat.o(28912);
      return str;
    }
  }
  
  public final void bet()
  {
    AppMethodBeat.i(28909);
    bh.beI();
    if (!c.isSDCardAvailable())
    {
      AppMethodBeat.o(28909);
      return;
    }
    bh.beI();
    long l1 = Util.nullAs((Long)c.aHp().b(66051, null), 0L);
    long l2 = Util.nowMilliSecond();
    if (432000000L > l2 - l1)
    {
      AppMethodBeat.o(28909);
      return;
    }
    bh.beI();
    c.aHp().i(66051, Long.valueOf(l2));
    new a();
    AppMethodBeat.o(28909);
  }
  
  public final String uS(int paramInt)
  {
    AppMethodBeat.i(28906);
    String str = bl(paramInt, true);
    AppMethodBeat.o(28906);
    return str;
  }
  
  public final String uT(int paramInt)
  {
    AppMethodBeat.i(28907);
    String str = bl(paramInt, false);
    AppMethodBeat.o(28907);
    return str;
  }
  
  public final boolean uU(int paramInt)
  {
    AppMethodBeat.i(28910);
    if (paramInt == 0)
    {
      AppMethodBeat.o(28910);
      return false;
    }
    int i = 0;
    while (i < 32)
    {
      if ((!u.agG(G(1 << i & paramInt, false))) || (!u.agG(G(1 << i & paramInt, true))))
      {
        AppMethodBeat.o(28910);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(28910);
    return true;
  }
  
  static final class a
    implements i
  {
    public a()
    {
      AppMethodBeat.i(28904);
      bh.aGY().a(167, this);
      a locala = new a();
      bh.aGY().a(locala, 0);
      AppMethodBeat.o(28904);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
    {
      AppMethodBeat.i(28905);
      bh.aGY().b(167, this);
      AppMethodBeat.o(28905);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.b.b
 * JD-Core Version:    0.7.0.1
 */