package com.tencent.mm.plugin.product.b;

import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class d
{
  public List<String> mSh = new ArrayList();
  
  public d()
  {
    xK();
  }
  
  private void xK()
  {
    this.mSh.clear();
    g.DQ();
    Object localObject = (String)g.DP().Dz().get(270340, "");
    y.d("MicroMsg.MallNewsManager", "data : " + (String)localObject);
    localObject = bk.G(((String)localObject).split(";")).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (!bk.bl(str)) {
        this.mSh.add(str);
      }
    }
  }
  
  public final boolean bsi()
  {
    y.d("MicroMsg.MallNewsManager", "notifyNewsMap.size : " + this.mSh.size());
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = this.mSh.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((!bk.bl(str)) && (!str.contains(";"))) {
        localStringBuffer.append(str);
      }
    }
    y.d("MicroMsg.MallNewsManager", "save data  : " + localStringBuffer.toString());
    g.DQ();
    g.DP().Dz().o(270340, localStringBuffer.toString());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.product.b.d
 * JD-Core Version:    0.7.0.1
 */