package com.tencent.mm.plugin.subapp.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.ar.c;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.vfs.i;

public final class b
  implements ar.c
{
  private static int QW(int paramInt)
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
  
  private static int QX(int paramInt)
  {
    AppMethodBeat.i(28913);
    paramInt = QW(paramInt);
    if (paramInt == -1)
    {
      AppMethodBeat.o(28913);
      return 0;
    }
    AppMethodBeat.o(28913);
    return 1 << paramInt;
  }
  
  private String aC(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(28908);
    az.ayM();
    if (!c.isSDCardAvailable())
    {
      AppMethodBeat.o(28908);
      return null;
    }
    String str = aD(paramInt, paramBoolean);
    if (i.eA(str))
    {
      AppMethodBeat.o(28908);
      return str;
    }
    ayx();
    AppMethodBeat.o(28908);
    return null;
  }
  
  private String aD(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(28911);
    paramInt = QX(paramInt);
    if (paramInt == 0)
    {
      AppMethodBeat.o(28911);
      return null;
    }
    String str = A(paramInt, paramBoolean);
    AppMethodBeat.o(28911);
    return str;
  }
  
  public final String A(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(28912);
    if (paramInt == 0)
    {
      AppMethodBeat.o(28912);
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder().append(com.tencent.mm.loader.j.b.apk()).append("vuserpic_").append(Integer.toHexString(paramInt));
    if (paramBoolean) {}
    for (String str = "_HD";; str = "")
    {
      str = str + ".png";
      AppMethodBeat.o(28912);
      return str;
    }
  }
  
  public final void ayx()
  {
    AppMethodBeat.i(28909);
    az.ayM();
    if (!c.isSDCardAvailable())
    {
      AppMethodBeat.o(28909);
      return;
    }
    az.ayM();
    long l1 = bs.a((Long)c.agA().get(66051, null), 0L);
    long l2 = bs.eWj();
    if (432000000L > l2 - l1)
    {
      AppMethodBeat.o(28909);
      return;
    }
    az.ayM();
    c.agA().set(66051, Long.valueOf(l2));
    new a();
    AppMethodBeat.o(28909);
  }
  
  public final String nR(int paramInt)
  {
    AppMethodBeat.i(28906);
    String str = aC(paramInt, true);
    AppMethodBeat.o(28906);
    return str;
  }
  
  public final String nS(int paramInt)
  {
    AppMethodBeat.i(28907);
    String str = aC(paramInt, false);
    AppMethodBeat.o(28907);
    return str;
  }
  
  public final boolean nT(int paramInt)
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
      if ((!i.eA(A(1 << i & paramInt, false))) || (!i.eA(A(1 << i & paramInt, true))))
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
      az.agi().a(167, this);
      a locala = new a();
      az.agi().a(locala, 0);
      AppMethodBeat.o(28904);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(28905);
      az.agi().b(167, this);
      AppMethodBeat.o(28905);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.b.b
 * JD-Core Version:    0.7.0.1
 */