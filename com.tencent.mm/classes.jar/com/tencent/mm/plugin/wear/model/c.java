package com.tencent.mm.plugin.wear.model;

import com.tencent.mm.plugin.wear.model.e.i;
import com.tencent.mm.pluginsdk.o.d.a;
import com.tencent.mm.protocal.c.cjl;
import com.tencent.mm.sdk.platformtools.bk;

public final class c
  implements o.d.a
{
  public final String bYN()
  {
    cjl localcjl = a.bYL().qRu.qRL.qSA;
    if (localcjl != null) {
      return localcjl.tXl + "\n" + localcjl.tXm + "\n" + localcjl.tXn;
    }
    return "Not Connect";
  }
  
  public final void bYO()
  {
    a.bYL().qRA.a(new com.tencent.mm.plugin.wear.model.f.a());
  }
  
  public final boolean bYP()
  {
    Object localObject = a.bYL().qRu.qRL.qSA;
    if ((bk.bl(null)) && (bk.bl(null))) {
      return localObject != null;
    }
    if (bk.bl(null))
    {
      if (localObject != null) {
        throw new NullPointerException();
      }
      return false;
    }
    if (bk.bl(null))
    {
      if (localObject != null)
      {
        localObject = ((cjl)localObject).tXi;
        throw new NullPointerException();
      }
      return false;
    }
    if (localObject != null) {
      throw new NullPointerException();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.c
 * JD-Core Version:    0.7.0.1
 */