package com.tencent.mm.plugin.subapp.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.model.ay.c;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.vfs.s;

public final class b
  implements ay.c
{
  private static int abi(int paramInt)
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
  
  private static int abj(int paramInt)
  {
    AppMethodBeat.i(28913);
    paramInt = abi(paramInt);
    if (paramInt == -1)
    {
      AppMethodBeat.o(28913);
      return 0;
    }
    AppMethodBeat.o(28913);
    return 1 << paramInt;
  }
  
  private String ba(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(28908);
    bg.aVF();
    if (!c.isSDCardAvailable())
    {
      AppMethodBeat.o(28908);
      return null;
    }
    String str = bb(paramInt, paramBoolean);
    if (s.YS(str))
    {
      AppMethodBeat.o(28908);
      return str;
    }
    aVq();
    AppMethodBeat.o(28908);
    return null;
  }
  
  private String bb(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(28911);
    paramInt = abj(paramInt);
    if (paramInt == 0)
    {
      AppMethodBeat.o(28911);
      return null;
    }
    String str = E(paramInt, paramBoolean);
    AppMethodBeat.o(28911);
    return str;
  }
  
  public final String E(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(28912);
    if (paramInt == 0)
    {
      AppMethodBeat.o(28912);
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder().append(com.tencent.mm.loader.j.b.aKN()).append("vuserpic_").append(Integer.toHexString(paramInt));
    if (paramBoolean) {}
    for (String str = "_HD";; str = "")
    {
      str = str + ".png";
      AppMethodBeat.o(28912);
      return str;
    }
  }
  
  public final void aVq()
  {
    AppMethodBeat.i(28909);
    bg.aVF();
    if (!c.isSDCardAvailable())
    {
      AppMethodBeat.o(28909);
      return;
    }
    bg.aVF();
    long l1 = Util.nullAs((Long)c.azQ().get(66051, null), 0L);
    long l2 = Util.nowMilliSecond();
    if (432000000L > l2 - l1)
    {
      AppMethodBeat.o(28909);
      return;
    }
    bg.aVF();
    c.azQ().set(66051, Long.valueOf(l2));
    new a();
    AppMethodBeat.o(28909);
  }
  
  public final String rV(int paramInt)
  {
    AppMethodBeat.i(28906);
    String str = ba(paramInt, true);
    AppMethodBeat.o(28906);
    return str;
  }
  
  public final String rW(int paramInt)
  {
    AppMethodBeat.i(28907);
    String str = ba(paramInt, false);
    AppMethodBeat.o(28907);
    return str;
  }
  
  public final boolean rX(int paramInt)
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
      if ((!s.YS(E(1 << i & paramInt, false))) || (!s.YS(E(1 << i & paramInt, true))))
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
      bg.azz().a(167, this);
      a locala = new a();
      bg.azz().a(locala, 0);
      AppMethodBeat.o(28904);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
    {
      AppMethodBeat.i(28905);
      bg.azz().b(167, this);
      AppMethodBeat.o(28905);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.b.b
 * JD-Core Version:    0.7.0.1
 */