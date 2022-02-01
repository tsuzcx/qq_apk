package com.tencent.mm.plugin.wallet_core.model.mall;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.aq;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class d
{
  private static d VKZ = null;
  private Map<String, MallNews> VKY;
  
  private d()
  {
    AppMethodBeat.i(70568);
    this.VKY = new HashMap();
    aNi();
    AppMethodBeat.o(70568);
  }
  
  private static MallNews bgP(String paramString)
  {
    AppMethodBeat.i(70574);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(70574);
      return null;
    }
    Map localMap = XmlParser.parseXml(paramString, "sysmsg", null);
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
        localMallNews.rBJ = ((String)localMap.get(".sysmsg.mallactivitynew.activityid"));
        localMallNews.type = ((String)localMap.get(".sysmsg.mallactivitynew.type"));
        localMallNews.hAN = Util.getInt((String)localMap.get(".sysmsg.mallactivitynew.showtype"), 0);
        if (localMap.containsKey(".sysmsg.mallactivitynew.showflag"))
        {
          localMallNews.VKO = ((String)localMap.get(".sysmsg.mallactivitynew.showflag"));
          if (localMap.containsKey(".sysmsg.mallactivitynew.newsTipFlag"))
          {
            localMallNews.VKP = ((String)localMap.get(".sysmsg.mallactivitynew.newsTipFlag"));
            localMallNews.VKV = paramString;
            boolean bool = Util.isNullOrNil(localMallNews.otL);
            if (!bool) {
              break;
            }
            AppMethodBeat.o(70574);
            return null;
          }
        }
        else
        {
          localMallNews.VKO = "0";
          continue;
        }
        localMallNews.VKP = "0";
      }
      catch (Exception paramString)
      {
        Log.e("MicroMsg.MallNewsManagerNewVersion", "cmdid error");
        AppMethodBeat.o(70574);
        return null;
      }
    }
    AppMethodBeat.o(70574);
    return localMallNews;
  }
  
  private boolean gAt()
  {
    AppMethodBeat.i(70571);
    Log.d("MicroMsg.MallNewsManagerNewVersion", "notifyNewsMap.size : " + this.VKY.size());
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = this.VKY.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      if (!Util.isNullOrNil((String)localObject))
      {
        localObject = (MallNews)this.VKY.get(localObject);
        localStringBuffer.append(((MallNews)localObject).VKV.replace("</mallactivitynew></sysmsg>;", "").replaceAll("<activityid>([^<]*)</activityid>", "").replaceAll("<type>([^<]*)</type>", "").replaceAll("<showflag>([^<]*)</showflag>", "").replaceAll("<newsTipFlag>([^<]*)</newsTipFlag>", "") + "<activityid>" + ((MallNews)localObject).rBJ + "</activityid><type>" + ((MallNews)localObject).type + "</type><showflag>" + ((MallNews)localObject).VKO + "</showflag><newsTipFlag>" + ((MallNews)localObject).VKP + "</newsTipFlag></mallactivitynew></sysmsg>;");
      }
    }
    Log.d("MicroMsg.MallNewsManagerNewVersion", "save data  : " + localStringBuffer.toString());
    h.baF();
    h.baE().ban().B(270341, localStringBuffer.toString());
    AppMethodBeat.o(70571);
    return true;
  }
  
  public static d ikh()
  {
    AppMethodBeat.i(70567);
    if (VKZ == null) {
      VKZ = new d();
    }
    d locald = VKZ;
    AppMethodBeat.o(70567);
    return locald;
  }
  
  public final void aNi()
  {
    AppMethodBeat.i(70569);
    this.VKY.clear();
    h.baF();
    Object localObject = (String)h.baE().ban().d(270341, "");
    Log.d("MicroMsg.MallNewsManagerNewVersion", "data : ".concat(String.valueOf(localObject)));
    localObject = Util.stringsToList(((String)localObject).split(";")).iterator();
    while (((Iterator)localObject).hasNext())
    {
      MallNews localMallNews = bgP((String)((Iterator)localObject).next());
      if (localMallNews != null) {
        this.VKY.put(localMallNews.otL, localMallNews);
      }
    }
    AppMethodBeat.o(70569);
  }
  
  public final void b(MallNews paramMallNews)
  {
    AppMethodBeat.i(70570);
    if (paramMallNews == null)
    {
      Log.w("MicroMsg.MallNewsManagerNewVersion", "null obj");
      AppMethodBeat.o(70570);
      return;
    }
    paramMallNews.VKV = ("<sysmsg><mallactivitynew><functionid>" + paramMallNews.otL + "</functionid><activityid>" + paramMallNews.rBJ + "</activityid><type>" + paramMallNews.type + "</type><showflag>" + paramMallNews.VKO + "</showflag><newsTipFlag>" + paramMallNews.VKP + "</newsTipFlag></mallactivitynew></sysmsg>;");
    this.VKY.put(paramMallNews.otL, paramMallNews);
    gAt();
    AppMethodBeat.o(70570);
  }
  
  public final MallNews bgO(String paramString)
  {
    AppMethodBeat.i(70573);
    Log.d("MicroMsg.MallNewsManagerNewVersion", "removeNewsInIndexUI : ".concat(String.valueOf(paramString)));
    if ((!Util.isNullOrNil(paramString)) && (this.VKY.containsKey(paramString)))
    {
      paramString = (MallNews)this.VKY.get(paramString);
      if ("0".equals(paramString.VKO))
      {
        paramString.VKO = "1";
        gAt();
      }
      AppMethodBeat.o(70573);
      return paramString;
    }
    AppMethodBeat.o(70573);
    return null;
  }
  
  public final MallNews bgQ(String paramString)
  {
    AppMethodBeat.i(70572);
    paramString = (MallNews)this.VKY.get(paramString);
    AppMethodBeat.o(70572);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.mall.d
 * JD-Core Version:    0.7.0.1
 */