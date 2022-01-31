package com.tencent.mm.plugin.remittance.ui;

import com.tencent.mm.protocal.c.jy;
import com.tencent.mm.protocal.c.yz;
import com.tencent.mm.protocal.c.za;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.math.BigInteger;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
{
  yz nzH = null;
  jy nzI;
  
  private static boolean a(List<za> paramList, yz paramyz)
  {
    if (paramyz.sEJ.size() == 0) {
      return false;
    }
    HashSet localHashSet = new HashSet();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localHashSet.add(Long.valueOf(((za)paramList.next()).sXU));
    }
    paramList = paramyz.sEJ.iterator();
    while (paramList.hasNext()) {
      if (!localHashSet.contains(Long.valueOf(((za)paramList.next()).sXU))) {
        return false;
      }
    }
    return true;
  }
  
  public final void LP(String paramString)
  {
    this.nzH = null;
    if (paramString == null) {
      this.nzH = null;
    }
    yz localyz;
    do
    {
      return;
      Iterator localIterator;
      while (!localIterator.hasNext())
      {
        if (this.nzI == null)
        {
          y.e("MicroMsg.FavorInfoPicked", "error setSelectFavorComposeId currentFavorResp is null");
          this.nzH = null;
          return;
        }
        localIterator = this.nzI.sEK.iterator();
      }
      localyz = (yz)localIterator.next();
    } while (!paramString.equals(localyz.sXL));
    this.nzH = localyz;
  }
  
  public final boolean a(List<za> paramList, za paramza)
  {
    if (this.nzI == null)
    {
      y.e("MicroMsg.FavorInfoPicked", "error setFavorInfoList currentFavorResp is null");
      return false;
    }
    if (paramza != null) {}
    for (Object localObject1 = new BigInteger(Long.toBinaryString(paramza.sXU), 2).toString();; localObject1 = null)
    {
      Object localObject2 = new LinkedList();
      Iterator localIterator = this.nzI.sEK.iterator();
      while (localIterator.hasNext())
      {
        yz localyz = (yz)localIterator.next();
        if ((paramza == null) || ((!bk.bl((String)localObject1)) && (localyz.sXL.contains((CharSequence)localObject1)))) {
          ((List)localObject2).add(localyz);
        }
      }
      paramza = new LinkedList();
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (yz)((Iterator)localObject1).next();
        if (a(paramList, (yz)localObject2)) {
          paramza.add(localObject2);
        }
      }
      if (paramza.size() > 0)
      {
        Collections.sort(paramza, new a.a(this));
        this.nzH = ((yz)paramza.get(0));
        return true;
      }
      this.nzH = null;
      return false;
    }
  }
  
  public final void bwj()
  {
    y.i("MicroMsg.FavorInfoPicked", "cleanBusiF2FFavor");
    this.nzI = null;
    this.nzH = null;
  }
  
  public final List<za> bwk()
  {
    if (this.nzI != null) {
      return this.nzI.sEJ;
    }
    return new LinkedList();
  }
  
  public final boolean bwl()
  {
    return this.nzI != null;
  }
  
  public final boolean bwm()
  {
    return (this.nzI != null) && (this.nzI.sEJ != null) && (this.nzI.sEJ.size() > 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.a
 * JD-Core Version:    0.7.0.1
 */