package com.tencent.mm.plugin.wallet_core.model.mall;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ai;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class d
{
  private static d DbH = null;
  private Map<String, MallNews> DbG;
  
  private d()
  {
    AppMethodBeat.i(70568);
    this.DbG = new HashMap();
    Zd();
    AppMethodBeat.o(70568);
  }
  
  private static MallNews aED(String paramString)
  {
    AppMethodBeat.i(70574);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(70574);
      return null;
    }
    Map localMap = bw.M(paramString, "sysmsg");
    if (localMap == null)
    {
      AppMethodBeat.o(70574);
      return null;
    }
    MallNews localMallNews;
    for (;;)
    {
      try
      {
        localMallNews = new MallNews((String)localMap.get(".sysmsg.mallactivitynew.functionid"));
        localMallNews.Bhd = ((String)localMap.get(".sysmsg.mallactivitynew.activityid"));
        localMallNews.type = ((String)localMap.get(".sysmsg.mallactivitynew.type"));
        localMallNews.dlp = bt.getInt((String)localMap.get(".sysmsg.mallactivitynew.showtype"), 0);
        if (localMap.containsKey(".sysmsg.mallactivitynew.showflag"))
        {
          localMallNews.Dbv = ((String)localMap.get(".sysmsg.mallactivitynew.showflag"));
          if (localMap.containsKey(".sysmsg.mallactivitynew.newsTipFlag"))
          {
            localMallNews.Dbw = ((String)localMap.get(".sysmsg.mallactivitynew.newsTipFlag"));
            localMallNews.DbD = paramString;
            boolean bool = bt.isNullOrNil(localMallNews.hNT);
            if (!bool) {
              break;
            }
            AppMethodBeat.o(70574);
            return null;
          }
        }
        else
        {
          localMallNews.Dbv = "0";
          continue;
        }
        localMallNews.Dbw = "0";
      }
      catch (Exception paramString)
      {
        ad.e("MicroMsg.MallNewsManagerNewVersion", "cmdid error");
        AppMethodBeat.o(70574);
        return null;
      }
    }
    AppMethodBeat.o(70574);
    return localMallNews;
  }
  
  private boolean dzN()
  {
    AppMethodBeat.i(70571);
    ad.d("MicroMsg.MallNewsManagerNewVersion", "notifyNewsMap.size : " + this.DbG.size());
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = this.DbG.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      if (!bt.isNullOrNil((String)localObject))
      {
        localObject = (MallNews)this.DbG.get(localObject);
        localStringBuffer.append(((MallNews)localObject).DbD.replace("</mallactivitynew></sysmsg>;", "").replaceAll("<activityid>([^<]*)</activityid>", "").replaceAll("<type>([^<]*)</type>", "").replaceAll("<showflag>([^<]*)</showflag>", "").replaceAll("<newsTipFlag>([^<]*)</newsTipFlag>", "") + "<activityid>" + ((MallNews)localObject).Bhd + "</activityid><type>" + ((MallNews)localObject).type + "</type><showflag>" + ((MallNews)localObject).Dbv + "</showflag><newsTipFlag>" + ((MallNews)localObject).Dbw + "</newsTipFlag></mallactivitynew></sysmsg>;");
      }
    }
    ad.d("MicroMsg.MallNewsManagerNewVersion", "save data  : " + localStringBuffer.toString());
    g.ajD();
    g.ajC().ajl().set(270341, localStringBuffer.toString());
    AppMethodBeat.o(70571);
    return true;
  }
  
  public static d eGX()
  {
    AppMethodBeat.i(70567);
    if (DbH == null) {
      DbH = new d();
    }
    d locald = DbH;
    AppMethodBeat.o(70567);
    return locald;
  }
  
  public final void Zd()
  {
    AppMethodBeat.i(70569);
    this.DbG.clear();
    g.ajD();
    Object localObject = (String)g.ajC().ajl().get(270341, "");
    ad.d("MicroMsg.MallNewsManagerNewVersion", "data : ".concat(String.valueOf(localObject)));
    localObject = bt.U(((String)localObject).split(";")).iterator();
    while (((Iterator)localObject).hasNext())
    {
      MallNews localMallNews = aED((String)((Iterator)localObject).next());
      if (localMallNews != null) {
        this.DbG.put(localMallNews.hNT, localMallNews);
      }
    }
    AppMethodBeat.o(70569);
  }
  
  public final MallNews aEC(String paramString)
  {
    AppMethodBeat.i(70573);
    ad.d("MicroMsg.MallNewsManagerNewVersion", "removeNewsInIndexUI : ".concat(String.valueOf(paramString)));
    if ((!bt.isNullOrNil(paramString)) && (this.DbG.containsKey(paramString)))
    {
      paramString = (MallNews)this.DbG.get(paramString);
      if ("0".equals(paramString.Dbv))
      {
        paramString.Dbv = "1";
        dzN();
      }
      AppMethodBeat.o(70573);
      return paramString;
    }
    AppMethodBeat.o(70573);
    return null;
  }
  
  public final MallNews aEE(String paramString)
  {
    AppMethodBeat.i(70572);
    paramString = (MallNews)this.DbG.get(paramString);
    AppMethodBeat.o(70572);
    return paramString;
  }
  
  public final void b(MallNews paramMallNews)
  {
    AppMethodBeat.i(70570);
    if (paramMallNews == null)
    {
      ad.w("MicroMsg.MallNewsManagerNewVersion", "null obj");
      AppMethodBeat.o(70570);
      return;
    }
    paramMallNews.DbD = ("<sysmsg><mallactivitynew><functionid>" + paramMallNews.hNT + "</functionid><activityid>" + paramMallNews.Bhd + "</activityid><type>" + paramMallNews.type + "</type><showflag>" + paramMallNews.Dbv + "</showflag><newsTipFlag>" + paramMallNews.Dbw + "</newsTipFlag></mallactivitynew></sysmsg>;");
    this.DbG.put(paramMallNews.hNT, paramMallNews);
    dzN();
    AppMethodBeat.o(70570);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.mall.d
 * JD-Core Version:    0.7.0.1
 */