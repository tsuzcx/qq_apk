package com.tencent.mm.plugin.wallet_core.model.mall;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ao;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class d
{
  private static d Icw = null;
  private Map<String, MallNews> Icv;
  
  private d()
  {
    AppMethodBeat.i(70568);
    this.Icv = new HashMap();
    amZ();
    AppMethodBeat.o(70568);
  }
  
  private static MallNews aVw(String paramString)
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
        localMallNews.FJm = ((String)localMap.get(".sysmsg.mallactivitynew.activityid"));
        localMallNews.type = ((String)localMap.get(".sysmsg.mallactivitynew.type"));
        localMallNews.dDG = Util.getInt((String)localMap.get(".sysmsg.mallactivitynew.showtype"), 0);
        if (localMap.containsKey(".sysmsg.mallactivitynew.showflag"))
        {
          localMallNews.Icl = ((String)localMap.get(".sysmsg.mallactivitynew.showflag"));
          if (localMap.containsKey(".sysmsg.mallactivitynew.newsTipFlag"))
          {
            localMallNews.Icm = ((String)localMap.get(".sysmsg.mallactivitynew.newsTipFlag"));
            localMallNews.Ics = paramString;
            boolean bool = Util.isNullOrNil(localMallNews.iLU);
            if (!bool) {
              break;
            }
            AppMethodBeat.o(70574);
            return null;
          }
        }
        else
        {
          localMallNews.Icl = "0";
          continue;
        }
        localMallNews.Icm = "0";
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
  
  private boolean eDw()
  {
    AppMethodBeat.i(70571);
    Log.d("MicroMsg.MallNewsManagerNewVersion", "notifyNewsMap.size : " + this.Icv.size());
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = this.Icv.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      if (!Util.isNullOrNil((String)localObject))
      {
        localObject = (MallNews)this.Icv.get(localObject);
        localStringBuffer.append(((MallNews)localObject).Ics.replace("</mallactivitynew></sysmsg>;", "").replaceAll("<activityid>([^<]*)</activityid>", "").replaceAll("<type>([^<]*)</type>", "").replaceAll("<showflag>([^<]*)</showflag>", "").replaceAll("<newsTipFlag>([^<]*)</newsTipFlag>", "") + "<activityid>" + ((MallNews)localObject).FJm + "</activityid><type>" + ((MallNews)localObject).type + "</type><showflag>" + ((MallNews)localObject).Icl + "</showflag><newsTipFlag>" + ((MallNews)localObject).Icm + "</newsTipFlag></mallactivitynew></sysmsg>;");
      }
    }
    Log.d("MicroMsg.MallNewsManagerNewVersion", "save data  : " + localStringBuffer.toString());
    g.aAi();
    g.aAh().azQ().set(270341, localStringBuffer.toString());
    AppMethodBeat.o(70571);
    return true;
  }
  
  public static d fSk()
  {
    AppMethodBeat.i(70567);
    if (Icw == null) {
      Icw = new d();
    }
    d locald = Icw;
    AppMethodBeat.o(70567);
    return locald;
  }
  
  public final MallNews aVv(String paramString)
  {
    AppMethodBeat.i(70573);
    Log.d("MicroMsg.MallNewsManagerNewVersion", "removeNewsInIndexUI : ".concat(String.valueOf(paramString)));
    if ((!Util.isNullOrNil(paramString)) && (this.Icv.containsKey(paramString)))
    {
      paramString = (MallNews)this.Icv.get(paramString);
      if ("0".equals(paramString.Icl))
      {
        paramString.Icl = "1";
        eDw();
      }
      AppMethodBeat.o(70573);
      return paramString;
    }
    AppMethodBeat.o(70573);
    return null;
  }
  
  public final MallNews aVx(String paramString)
  {
    AppMethodBeat.i(70572);
    paramString = (MallNews)this.Icv.get(paramString);
    AppMethodBeat.o(70572);
    return paramString;
  }
  
  public final void amZ()
  {
    AppMethodBeat.i(70569);
    this.Icv.clear();
    g.aAi();
    Object localObject = (String)g.aAh().azQ().get(270341, "");
    Log.d("MicroMsg.MallNewsManagerNewVersion", "data : ".concat(String.valueOf(localObject)));
    localObject = Util.stringsToList(((String)localObject).split(";")).iterator();
    while (((Iterator)localObject).hasNext())
    {
      MallNews localMallNews = aVw((String)((Iterator)localObject).next());
      if (localMallNews != null) {
        this.Icv.put(localMallNews.iLU, localMallNews);
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
    paramMallNews.Ics = ("<sysmsg><mallactivitynew><functionid>" + paramMallNews.iLU + "</functionid><activityid>" + paramMallNews.FJm + "</activityid><type>" + paramMallNews.type + "</type><showflag>" + paramMallNews.Icl + "</showflag><newsTipFlag>" + paramMallNews.Icm + "</newsTipFlag></mallactivitynew></sysmsg>;");
    this.Icv.put(paramMallNews.iLU, paramMallNews);
    eDw();
    AppMethodBeat.o(70570);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.mall.d
 * JD-Core Version:    0.7.0.1
 */