package com.tencent.mm.plugin.subapp.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.au.c;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.vfs.o;

public final class b
  implements au.c
{
  private static int Tm(int paramInt)
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
  
  private static int Tn(int paramInt)
  {
    AppMethodBeat.i(28913);
    paramInt = Tm(paramInt);
    if (paramInt == -1)
    {
      AppMethodBeat.o(28913);
      return 0;
    }
    AppMethodBeat.o(28913);
    return 1 << paramInt;
  }
  
  private String aK(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(28908);
    bc.aCg();
    if (!c.isSDCardAvailable())
    {
      AppMethodBeat.o(28908);
      return null;
    }
    String str = aL(paramInt, paramBoolean);
    if (o.fB(str))
    {
      AppMethodBeat.o(28908);
      return str;
    }
    aBR();
    AppMethodBeat.o(28908);
    return null;
  }
  
  private String aL(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(28911);
    paramInt = Tn(paramInt);
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
    StringBuilder localStringBuilder = new StringBuilder().append(com.tencent.mm.loader.j.b.asn()).append("vuserpic_").append(Integer.toHexString(paramInt));
    if (paramBoolean) {}
    for (String str = "_HD";; str = "")
    {
      str = str + ".png";
      AppMethodBeat.o(28912);
      return str;
    }
  }
  
  public final void aBR()
  {
    AppMethodBeat.i(28909);
    bc.aCg();
    if (!c.isSDCardAvailable())
    {
      AppMethodBeat.o(28909);
      return;
    }
    bc.aCg();
    long l1 = bu.a((Long)c.ajA().get(66051, null), 0L);
    long l2 = bu.fpO();
    if (432000000L > l2 - l1)
    {
      AppMethodBeat.o(28909);
      return;
    }
    bc.aCg();
    c.ajA().set(66051, Long.valueOf(l2));
    new a();
    AppMethodBeat.o(28909);
  }
  
  public final String ou(int paramInt)
  {
    AppMethodBeat.i(28906);
    String str = aK(paramInt, true);
    AppMethodBeat.o(28906);
    return str;
  }
  
  public final String ov(int paramInt)
  {
    AppMethodBeat.i(28907);
    String str = aK(paramInt, false);
    AppMethodBeat.o(28907);
    return str;
  }
  
  public final boolean ow(int paramInt)
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
      if ((!o.fB(A(1 << i & paramInt, false))) || (!o.fB(A(1 << i & paramInt, true))))
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
    implements f
  {
    public a()
    {
      AppMethodBeat.i(28904);
      bc.ajj().a(167, this);
      a locala = new a();
      bc.ajj().a(locala, 0);
      AppMethodBeat.o(28904);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(28905);
      bc.ajj().b(167, this);
      AppMethodBeat.o(28905);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.b.b
 * JD-Core Version:    0.7.0.1
 */