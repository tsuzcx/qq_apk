package com.tencent.mm.plugin.order.model;

import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class b
{
  public HashSet<String> mOJ = new HashSet();
  
  public b()
  {
    xO();
  }
  
  private void xO()
  {
    this.mOJ.clear();
    g.DQ();
    Iterator localIterator = bk.G(((String)g.DP().Dz().get(204803, "")).split(";")).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((!bk.bl(str)) && (!this.mOJ.contains(str))) {
        this.mOJ.add(str);
      }
    }
    g.DQ();
    g.DP().Dz().o(204817, Integer.valueOf(this.mOJ.size()));
    y.d("MicroMsg.WalletOrdersManager", "notifyTrans.size() : " + this.mOJ.size());
  }
  
  public final void brz()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = this.mOJ.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!bk.bl(str)) {
        localStringBuffer.append(str + ";");
      }
    }
    g.DQ();
    g.DP().Dz().o(204803, localStringBuffer.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.order.model.b
 * JD-Core Version:    0.7.0.1
 */