package com.tencent.mm.plugin.subapp.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.model.ar.c;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.vfs.i;

public final class b
  implements ar.c
{
  private static int OQ(int paramInt)
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
  
  private static int OR(int paramInt)
  {
    AppMethodBeat.i(28913);
    paramInt = OQ(paramInt);
    if (paramInt == -1)
    {
      AppMethodBeat.o(28913);
      return 0;
    }
    AppMethodBeat.o(28913);
    return 1 << paramInt;
  }
  
  private String aA(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(28911);
    paramInt = OR(paramInt);
    if (paramInt == 0)
    {
      AppMethodBeat.o(28911);
      return null;
    }
    String str = A(paramInt, paramBoolean);
    AppMethodBeat.o(28911);
    return str;
  }
  
  private String az(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(28908);
    az.arV();
    if (!c.isSDCardAvailable())
    {
      AppMethodBeat.o(28908);
      return null;
    }
    String str = aA(paramInt, paramBoolean);
    if (i.eK(str))
    {
      AppMethodBeat.o(28908);
      return str;
    }
    arG();
    AppMethodBeat.o(28908);
    return null;
  }
  
  public final String A(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(28912);
    if (paramInt == 0)
    {
      AppMethodBeat.o(28912);
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder().append(com.tencent.mm.loader.j.b.aik()).append("vuserpic_").append(Integer.toHexString(paramInt));
    if (paramBoolean) {}
    for (String str = "_HD";; str = "")
    {
      str = str + ".png";
      AppMethodBeat.o(28912);
      return str;
    }
  }
  
  public final void arG()
  {
    AppMethodBeat.i(28909);
    az.arV();
    if (!c.isSDCardAvailable())
    {
      AppMethodBeat.o(28909);
      return;
    }
    az.arV();
    long l1 = bt.a((Long)c.afk().get(66051, null), 0L);
    long l2 = bt.eGO();
    if (432000000L > l2 - l1)
    {
      AppMethodBeat.o(28909);
      return;
    }
    az.arV();
    c.afk().set(66051, Long.valueOf(l2));
    new a();
    AppMethodBeat.o(28909);
  }
  
  public final String nd(int paramInt)
  {
    AppMethodBeat.i(28906);
    String str = az(paramInt, true);
    AppMethodBeat.o(28906);
    return str;
  }
  
  public final String ne(int paramInt)
  {
    AppMethodBeat.i(28907);
    String str = az(paramInt, false);
    AppMethodBeat.o(28907);
    return str;
  }
  
  public final boolean nf(int paramInt)
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
      if ((!i.eK(A(1 << i & paramInt, false))) || (!i.eK(A(1 << i & paramInt, true))))
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
    implements g
  {
    public a()
    {
      AppMethodBeat.i(28904);
      az.aeS().a(167, this);
      a locala = new a();
      az.aeS().a(locala, 0);
      AppMethodBeat.o(28904);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(28905);
      az.aeS().b(167, this);
      AppMethodBeat.o(28905);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.b.b
 * JD-Core Version:    0.7.0.1
 */