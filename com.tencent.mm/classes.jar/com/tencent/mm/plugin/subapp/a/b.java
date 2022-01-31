package com.tencent.mm.plugin.subapp.a;

import com.tencent.mm.model.am.c;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.z;

public final class b
  implements am.c
{
  private String ab(int paramInt, boolean paramBoolean)
  {
    int k = 0;
    au.Hx();
    if (!c.isSDCardAvailable()) {
      return null;
    }
    int i;
    if (paramInt == 0)
    {
      i = -1;
      if (i != -1) {
        break label85;
      }
      paramInt = k;
      label29:
      if (paramInt != 0) {
        break label92;
      }
    }
    label85:
    label92:
    for (String str = null;; str = x(paramInt, paramBoolean))
    {
      if (!com.tencent.mm.a.e.bK(str)) {
        break label103;
      }
      return str;
      i = 0;
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
      paramInt = 1 << i;
      break label29;
    }
    label103:
    Hi();
    return null;
  }
  
  public final void Hi()
  {
    au.Hx();
    if (!c.isSDCardAvailable()) {}
    long l1;
    long l2;
    do
    {
      return;
      au.Hx();
      l1 = bk.a((Long)c.Dz().get(66051, null), 0L);
      l2 = bk.UY();
    } while (432000000L > l2 - l1);
    au.Hx();
    c.Dz().o(66051, Long.valueOf(l2));
    new b.a();
  }
  
  public final String hL(int paramInt)
  {
    return ab(paramInt, true);
  }
  
  public final String hM(int paramInt)
  {
    return ab(paramInt, false);
  }
  
  public final boolean hN(int paramInt)
  {
    if (paramInt == 0) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= 32) {
        break label53;
      }
      if ((!com.tencent.mm.a.e.bK(x(1 << i & paramInt, false))) || (!com.tencent.mm.a.e.bK(x(1 << i & paramInt, true)))) {
        break;
      }
      i += 1;
    }
    label53:
    return true;
  }
  
  public final String x(int paramInt, boolean paramBoolean)
  {
    if (paramInt == 0) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder().append(com.tencent.mm.compatible.util.e.dzE).append("vuserpic_").append(Integer.toHexString(paramInt));
    if (paramBoolean) {}
    for (String str = "_HD";; str = "") {
      return str + ".png";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.a.b
 * JD-Core Version:    0.7.0.1
 */