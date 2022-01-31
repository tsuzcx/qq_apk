package com.tencent.mm.plugin.wallet_core.model.mall;

import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class d
{
  private static d qzP = null;
  public Map<String, MallNews> qzO = new HashMap();
  
  private d()
  {
    xK();
  }
  
  private static MallNews Qy(String paramString)
  {
    if (bk.bl(paramString)) {
      return null;
    }
    Map localMap = bn.s(paramString, "sysmsg");
    if (localMap == null) {
      return null;
    }
    MallNews localMallNews;
    for (;;)
    {
      try
      {
        localMallNews = new MallNews((String)localMap.get(".sysmsg.mallactivitynew.functionid"));
        localMallNews.pva = ((String)localMap.get(".sysmsg.mallactivitynew.activityid"));
        localMallNews.type = ((String)localMap.get(".sysmsg.mallactivitynew.type"));
        localMallNews.showType = bk.getInt((String)localMap.get(".sysmsg.mallactivitynew.showtype"), 0);
        if (localMap.containsKey(".sysmsg.mallactivitynew.showflag"))
        {
          localMallNews.qzD = ((String)localMap.get(".sysmsg.mallactivitynew.showflag"));
          if (localMap.containsKey(".sysmsg.mallactivitynew.newsTipFlag"))
          {
            localMallNews.qzE = ((String)localMap.get(".sysmsg.mallactivitynew.newsTipFlag"));
            localMallNews.qzL = paramString;
            if (!bk.bl(localMallNews.ecR)) {
              break;
            }
            return null;
          }
        }
        else
        {
          localMallNews.qzD = "0";
          continue;
        }
        localMallNews.qzE = "0";
      }
      catch (Exception paramString)
      {
        y.e("MicroMsg.MallNewsManagerNewVersion", "cmdid error");
        return null;
      }
    }
    return localMallNews;
  }
  
  public static d bWk()
  {
    if (qzP == null) {
      qzP = new d();
    }
    return qzP;
  }
  
  public final MallNews Qx(String paramString)
  {
    y.d("MicroMsg.MallNewsManagerNewVersion", "removeNewsInIndexUI : " + paramString);
    if ((!bk.bl(paramString)) && (this.qzO.containsKey(paramString)))
    {
      paramString = (MallNews)this.qzO.get(paramString);
      if ("0".equals(paramString.qzD))
      {
        paramString.qzD = "1";
        bsi();
      }
      return paramString;
    }
    return null;
  }
  
  public final MallNews Qz(String paramString)
  {
    return (MallNews)this.qzO.get(paramString);
  }
  
  public final boolean bsi()
  {
    y.d("MicroMsg.MallNewsManagerNewVersion", "notifyNewsMap.size : " + this.qzO.size());
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = this.qzO.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      if (!bk.bl((String)localObject))
      {
        localObject = (MallNews)this.qzO.get(localObject);
        localStringBuffer.append(((MallNews)localObject).qzL.replace("</mallactivitynew></sysmsg>;", "").replaceAll("<activityid>([^<]*)</activityid>", "").replaceAll("<type>([^<]*)</type>", "").replaceAll("<showflag>([^<]*)</showflag>", "").replaceAll("<newsTipFlag>([^<]*)</newsTipFlag>", "") + "<activityid>" + ((MallNews)localObject).pva + "</activityid><type>" + ((MallNews)localObject).type + "</type><showflag>" + ((MallNews)localObject).qzD + "</showflag><newsTipFlag>" + ((MallNews)localObject).qzE + "</newsTipFlag></mallactivitynew></sysmsg>;");
      }
    }
    y.d("MicroMsg.MallNewsManagerNewVersion", "save data  : " + localStringBuffer.toString());
    g.DQ();
    g.DP().Dz().o(270341, localStringBuffer.toString());
    return true;
  }
  
  public final void xK()
  {
    this.qzO.clear();
    g.DQ();
    Object localObject = (String)g.DP().Dz().get(270341, "");
    y.d("MicroMsg.MallNewsManagerNewVersion", "data : " + (String)localObject);
    localObject = bk.G(((String)localObject).split(";")).iterator();
    while (((Iterator)localObject).hasNext())
    {
      MallNews localMallNews = Qy((String)((Iterator)localObject).next());
      if (localMallNews != null) {
        this.qzO.put(localMallNews.ecR, localMallNews);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.mall.d
 * JD-Core Version:    0.7.0.1
 */