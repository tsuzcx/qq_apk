package com.tencent.mm.plugin.subapp.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.model.as.c;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.vfs.i;

public final class b
  implements as.c
{
  private static int SF(int paramInt)
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
  
  private static int SG(int paramInt)
  {
    AppMethodBeat.i(28913);
    paramInt = SF(paramInt);
    if (paramInt == -1)
    {
      AppMethodBeat.o(28913);
      return 0;
    }
    AppMethodBeat.o(28913);
    return 1 << paramInt;
  }
  
  private String aH(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(28908);
    ba.aBQ();
    if (!c.isSDCardAvailable())
    {
      AppMethodBeat.o(28908);
      return null;
    }
    String str = aI(paramInt, paramBoolean);
    if (i.fv(str))
    {
      AppMethodBeat.o(28908);
      return str;
    }
    aBB();
    AppMethodBeat.o(28908);
    return null;
  }
  
  private String aI(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(28911);
    paramInt = SG(paramInt);
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
    StringBuilder localStringBuilder = new StringBuilder().append(com.tencent.mm.loader.j.b.arY()).append("vuserpic_").append(Integer.toHexString(paramInt));
    if (paramBoolean) {}
    for (String str = "_HD";; str = "")
    {
      str = str + ".png";
      AppMethodBeat.o(28912);
      return str;
    }
  }
  
  public final void aBB()
  {
    AppMethodBeat.i(28909);
    ba.aBQ();
    if (!c.isSDCardAvailable())
    {
      AppMethodBeat.o(28909);
      return;
    }
    ba.aBQ();
    long l1 = bt.a((Long)c.ajl().get(66051, null), 0L);
    long l2 = bt.flT();
    if (432000000L > l2 - l1)
    {
      AppMethodBeat.o(28909);
      return;
    }
    ba.aBQ();
    c.ajl().set(66051, Long.valueOf(l2));
    new a();
    AppMethodBeat.o(28909);
  }
  
  public final String or(int paramInt)
  {
    AppMethodBeat.i(28906);
    String str = aH(paramInt, true);
    AppMethodBeat.o(28906);
    return str;
  }
  
  public final String os(int paramInt)
  {
    AppMethodBeat.i(28907);
    String str = aH(paramInt, false);
    AppMethodBeat.o(28907);
    return str;
  }
  
  public final boolean ot(int paramInt)
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
      if ((!i.fv(A(1 << i & paramInt, false))) || (!i.fv(A(1 << i & paramInt, true))))
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
      ba.aiU().a(167, this);
      a locala = new a();
      ba.aiU().a(locala, 0);
      AppMethodBeat.o(28904);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(28905);
      ba.aiU().b(167, this);
      AppMethodBeat.o(28905);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.b.b
 * JD-Core Version:    0.7.0.1
 */