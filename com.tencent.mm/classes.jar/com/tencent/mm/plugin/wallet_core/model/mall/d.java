package com.tencent.mm.plugin.wallet_core.model.mall;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ab;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class d
{
  private static d AiU = null;
  private Map<String, MallNews> AiT;
  
  private d()
  {
    AppMethodBeat.i(70568);
    this.AiT = new HashMap();
    VL();
    AppMethodBeat.o(70568);
  }
  
  private static MallNews aub(String paramString)
  {
    AppMethodBeat.i(70574);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(70574);
      return null;
    }
    Map localMap = bw.K(paramString, "sysmsg");
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
        localMallNews.yCo = ((String)localMap.get(".sysmsg.mallactivitynew.activityid"));
        localMallNews.type = ((String)localMap.get(".sysmsg.mallactivitynew.type"));
        localMallNews.dcz = bt.getInt((String)localMap.get(".sysmsg.mallactivitynew.showtype"), 0);
        if (localMap.containsKey(".sysmsg.mallactivitynew.showflag"))
        {
          localMallNews.AiI = ((String)localMap.get(".sysmsg.mallactivitynew.showflag"));
          if (localMap.containsKey(".sysmsg.mallactivitynew.newsTipFlag"))
          {
            localMallNews.AiJ = ((String)localMap.get(".sysmsg.mallactivitynew.newsTipFlag"));
            localMallNews.AiQ = paramString;
            boolean bool = bt.isNullOrNil(localMallNews.gVf);
            if (!bool) {
              break;
            }
            AppMethodBeat.o(70574);
            return null;
          }
        }
        else
        {
          localMallNews.AiI = "0";
          continue;
        }
        localMallNews.AiJ = "0";
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
  
  private boolean dbD()
  {
    AppMethodBeat.i(70571);
    ad.d("MicroMsg.MallNewsManagerNewVersion", "notifyNewsMap.size : " + this.AiT.size());
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = this.AiT.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      if (!bt.isNullOrNil((String)localObject))
      {
        localObject = (MallNews)this.AiT.get(localObject);
        localStringBuffer.append(((MallNews)localObject).AiQ.replace("</mallactivitynew></sysmsg>;", "").replaceAll("<activityid>([^<]*)</activityid>", "").replaceAll("<type>([^<]*)</type>", "").replaceAll("<showflag>([^<]*)</showflag>", "").replaceAll("<newsTipFlag>([^<]*)</newsTipFlag>", "") + "<activityid>" + ((MallNews)localObject).yCo + "</activityid><type>" + ((MallNews)localObject).type + "</type><showflag>" + ((MallNews)localObject).AiI + "</showflag><newsTipFlag>" + ((MallNews)localObject).AiJ + "</newsTipFlag></mallactivitynew></sysmsg>;");
      }
    }
    ad.d("MicroMsg.MallNewsManagerNewVersion", "save data  : " + localStringBuffer.toString());
    g.afC();
    g.afB().afk().set(270341, localStringBuffer.toString());
    AppMethodBeat.o(70571);
    return true;
  }
  
  public static d edw()
  {
    AppMethodBeat.i(70567);
    if (AiU == null) {
      AiU = new d();
    }
    d locald = AiU;
    AppMethodBeat.o(70567);
    return locald;
  }
  
  public final void VL()
  {
    AppMethodBeat.i(70569);
    this.AiT.clear();
    g.afC();
    Object localObject = (String)g.afB().afk().get(270341, "");
    ad.d("MicroMsg.MallNewsManagerNewVersion", "data : ".concat(String.valueOf(localObject)));
    localObject = bt.S(((String)localObject).split(";")).iterator();
    while (((Iterator)localObject).hasNext())
    {
      MallNews localMallNews = aub((String)((Iterator)localObject).next());
      if (localMallNews != null) {
        this.AiT.put(localMallNews.gVf, localMallNews);
      }
    }
    AppMethodBeat.o(70569);
  }
  
  public final MallNews aua(String paramString)
  {
    AppMethodBeat.i(70573);
    ad.d("MicroMsg.MallNewsManagerNewVersion", "removeNewsInIndexUI : ".concat(String.valueOf(paramString)));
    if ((!bt.isNullOrNil(paramString)) && (this.AiT.containsKey(paramString)))
    {
      paramString = (MallNews)this.AiT.get(paramString);
      if ("0".equals(paramString.AiI))
      {
        paramString.AiI = "1";
        dbD();
      }
      AppMethodBeat.o(70573);
      return paramString;
    }
    AppMethodBeat.o(70573);
    return null;
  }
  
  public final MallNews auc(String paramString)
  {
    AppMethodBeat.i(70572);
    paramString = (MallNews)this.AiT.get(paramString);
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
    paramMallNews.AiQ = ("<sysmsg><mallactivitynew><functionid>" + paramMallNews.gVf + "</functionid><activityid>" + paramMallNews.yCo + "</activityid><type>" + paramMallNews.type + "</type><showflag>" + paramMallNews.AiI + "</showflag><newsTipFlag>" + paramMallNews.AiJ + "</newsTipFlag></mallactivitynew></sysmsg>;");
    this.AiT.put(paramMallNews.gVf, paramMallNews);
    dbD();
    AppMethodBeat.o(70570);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.mall.d
 * JD-Core Version:    0.7.0.1
 */