package com.tencent.mm.plugin.wallet_core.model.mall;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
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
  private static d OUI = null;
  private Map<String, MallNews> OUH;
  
  private d()
  {
    AppMethodBeat.i(70568);
    this.OUH = new HashMap();
    ata();
    AppMethodBeat.o(70568);
  }
  
  private static MallNews bhf(String paramString)
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
        localMallNews.oym = ((String)localMap.get(".sysmsg.mallactivitynew.activityid"));
        localMallNews.type = ((String)localMap.get(".sysmsg.mallactivitynew.type"));
        localMallNews.fwp = Util.getInt((String)localMap.get(".sysmsg.mallactivitynew.showtype"), 0);
        if (localMap.containsKey(".sysmsg.mallactivitynew.showflag"))
        {
          localMallNews.OUx = ((String)localMap.get(".sysmsg.mallactivitynew.showflag"));
          if (localMap.containsKey(".sysmsg.mallactivitynew.newsTipFlag"))
          {
            localMallNews.OUy = ((String)localMap.get(".sysmsg.mallactivitynew.newsTipFlag"));
            localMallNews.OUE = paramString;
            boolean bool = Util.isNullOrNil(localMallNews.lCb);
            if (!bool) {
              break;
            }
            AppMethodBeat.o(70574);
            return null;
          }
        }
        else
        {
          localMallNews.OUx = "0";
          continue;
        }
        localMallNews.OUy = "0";
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
  
  private boolean fpp()
  {
    AppMethodBeat.i(70571);
    Log.d("MicroMsg.MallNewsManagerNewVersion", "notifyNewsMap.size : " + this.OUH.size());
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = this.OUH.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      if (!Util.isNullOrNil((String)localObject))
      {
        localObject = (MallNews)this.OUH.get(localObject);
        localStringBuffer.append(((MallNews)localObject).OUE.replace("</mallactivitynew></sysmsg>;", "").replaceAll("<activityid>([^<]*)</activityid>", "").replaceAll("<type>([^<]*)</type>", "").replaceAll("<showflag>([^<]*)</showflag>", "").replaceAll("<newsTipFlag>([^<]*)</newsTipFlag>", "") + "<activityid>" + ((MallNews)localObject).oym + "</activityid><type>" + ((MallNews)localObject).type + "</type><showflag>" + ((MallNews)localObject).OUx + "</showflag><newsTipFlag>" + ((MallNews)localObject).OUy + "</newsTipFlag></mallactivitynew></sysmsg>;");
      }
    }
    Log.d("MicroMsg.MallNewsManagerNewVersion", "save data  : " + localStringBuffer.toString());
    h.aHH();
    h.aHG().aHp().i(270341, localStringBuffer.toString());
    AppMethodBeat.o(70571);
    return true;
  }
  
  public static d gKP()
  {
    AppMethodBeat.i(70567);
    if (OUI == null) {
      OUI = new d();
    }
    d locald = OUI;
    AppMethodBeat.o(70567);
    return locald;
  }
  
  public final void ata()
  {
    AppMethodBeat.i(70569);
    this.OUH.clear();
    h.aHH();
    Object localObject = (String)h.aHG().aHp().b(270341, "");
    Log.d("MicroMsg.MallNewsManagerNewVersion", "data : ".concat(String.valueOf(localObject)));
    localObject = Util.stringsToList(((String)localObject).split(";")).iterator();
    while (((Iterator)localObject).hasNext())
    {
      MallNews localMallNews = bhf((String)((Iterator)localObject).next());
      if (localMallNews != null) {
        this.OUH.put(localMallNews.lCb, localMallNews);
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
    paramMallNews.OUE = ("<sysmsg><mallactivitynew><functionid>" + paramMallNews.lCb + "</functionid><activityid>" + paramMallNews.oym + "</activityid><type>" + paramMallNews.type + "</type><showflag>" + paramMallNews.OUx + "</showflag><newsTipFlag>" + paramMallNews.OUy + "</newsTipFlag></mallactivitynew></sysmsg>;");
    this.OUH.put(paramMallNews.lCb, paramMallNews);
    fpp();
    AppMethodBeat.o(70570);
  }
  
  public final MallNews bhe(String paramString)
  {
    AppMethodBeat.i(70573);
    Log.d("MicroMsg.MallNewsManagerNewVersion", "removeNewsInIndexUI : ".concat(String.valueOf(paramString)));
    if ((!Util.isNullOrNil(paramString)) && (this.OUH.containsKey(paramString)))
    {
      paramString = (MallNews)this.OUH.get(paramString);
      if ("0".equals(paramString.OUx))
      {
        paramString.OUx = "1";
        fpp();
      }
      AppMethodBeat.o(70573);
      return paramString;
    }
    AppMethodBeat.o(70573);
    return null;
  }
  
  public final MallNews bhg(String paramString)
  {
    AppMethodBeat.i(70572);
    paramString = (MallNews)this.OUH.get(paramString);
    AppMethodBeat.o(70572);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.mall.d
 * JD-Core Version:    0.7.0.1
 */