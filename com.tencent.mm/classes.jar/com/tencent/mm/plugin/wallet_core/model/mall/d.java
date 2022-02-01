package com.tencent.mm.plugin.wallet_core.model.mall;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.ae;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class d
{
  private static d BBp = null;
  private Map<String, MallNews> BBo;
  
  private d()
  {
    AppMethodBeat.i(70568);
    this.BBo = new HashMap();
    WJ();
    AppMethodBeat.o(70568);
  }
  
  private static MallNews azt(String paramString)
  {
    AppMethodBeat.i(70574);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(70574);
      return null;
    }
    Map localMap = bv.L(paramString, "sysmsg");
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
        localMallNews.zPC = ((String)localMap.get(".sysmsg.mallactivitynew.activityid"));
        localMallNews.type = ((String)localMap.get(".sysmsg.mallactivitynew.type"));
        localMallNews.cZX = bs.getInt((String)localMap.get(".sysmsg.mallactivitynew.showtype"), 0);
        if (localMap.containsKey(".sysmsg.mallactivitynew.showflag"))
        {
          localMallNews.BBd = ((String)localMap.get(".sysmsg.mallactivitynew.showflag"));
          if (localMap.containsKey(".sysmsg.mallactivitynew.newsTipFlag"))
          {
            localMallNews.BBe = ((String)localMap.get(".sysmsg.mallactivitynew.newsTipFlag"));
            localMallNews.BBl = paramString;
            boolean bool = bs.isNullOrNil(localMallNews.hvE);
            if (!bool) {
              break;
            }
            AppMethodBeat.o(70574);
            return null;
          }
        }
        else
        {
          localMallNews.BBd = "0";
          continue;
        }
        localMallNews.BBe = "0";
      }
      catch (Exception paramString)
      {
        ac.e("MicroMsg.MallNewsManagerNewVersion", "cmdid error");
        AppMethodBeat.o(70574);
        return null;
      }
    }
    AppMethodBeat.o(70574);
    return localMallNews;
  }
  
  private boolean dpl()
  {
    AppMethodBeat.i(70571);
    ac.d("MicroMsg.MallNewsManagerNewVersion", "notifyNewsMap.size : " + this.BBo.size());
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = this.BBo.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      if (!bs.isNullOrNil((String)localObject))
      {
        localObject = (MallNews)this.BBo.get(localObject);
        localStringBuffer.append(((MallNews)localObject).BBl.replace("</mallactivitynew></sysmsg>;", "").replaceAll("<activityid>([^<]*)</activityid>", "").replaceAll("<type>([^<]*)</type>", "").replaceAll("<showflag>([^<]*)</showflag>", "").replaceAll("<newsTipFlag>([^<]*)</newsTipFlag>", "") + "<activityid>" + ((MallNews)localObject).zPC + "</activityid><type>" + ((MallNews)localObject).type + "</type><showflag>" + ((MallNews)localObject).BBd + "</showflag><newsTipFlag>" + ((MallNews)localObject).BBe + "</newsTipFlag></mallactivitynew></sysmsg>;");
      }
    }
    ac.d("MicroMsg.MallNewsManagerNewVersion", "save data  : " + localStringBuffer.toString());
    g.agS();
    g.agR().agA().set(270341, localStringBuffer.toString());
    AppMethodBeat.o(70571);
    return true;
  }
  
  public static d esR()
  {
    AppMethodBeat.i(70567);
    if (BBp == null) {
      BBp = new d();
    }
    d locald = BBp;
    AppMethodBeat.o(70567);
    return locald;
  }
  
  public final void WJ()
  {
    AppMethodBeat.i(70569);
    this.BBo.clear();
    g.agS();
    Object localObject = (String)g.agR().agA().get(270341, "");
    ac.d("MicroMsg.MallNewsManagerNewVersion", "data : ".concat(String.valueOf(localObject)));
    localObject = bs.S(((String)localObject).split(";")).iterator();
    while (((Iterator)localObject).hasNext())
    {
      MallNews localMallNews = azt((String)((Iterator)localObject).next());
      if (localMallNews != null) {
        this.BBo.put(localMallNews.hvE, localMallNews);
      }
    }
    AppMethodBeat.o(70569);
  }
  
  public final MallNews azs(String paramString)
  {
    AppMethodBeat.i(70573);
    ac.d("MicroMsg.MallNewsManagerNewVersion", "removeNewsInIndexUI : ".concat(String.valueOf(paramString)));
    if ((!bs.isNullOrNil(paramString)) && (this.BBo.containsKey(paramString)))
    {
      paramString = (MallNews)this.BBo.get(paramString);
      if ("0".equals(paramString.BBd))
      {
        paramString.BBd = "1";
        dpl();
      }
      AppMethodBeat.o(70573);
      return paramString;
    }
    AppMethodBeat.o(70573);
    return null;
  }
  
  public final MallNews azu(String paramString)
  {
    AppMethodBeat.i(70572);
    paramString = (MallNews)this.BBo.get(paramString);
    AppMethodBeat.o(70572);
    return paramString;
  }
  
  public final void b(MallNews paramMallNews)
  {
    AppMethodBeat.i(70570);
    if (paramMallNews == null)
    {
      ac.w("MicroMsg.MallNewsManagerNewVersion", "null obj");
      AppMethodBeat.o(70570);
      return;
    }
    paramMallNews.BBl = ("<sysmsg><mallactivitynew><functionid>" + paramMallNews.hvE + "</functionid><activityid>" + paramMallNews.zPC + "</activityid><type>" + paramMallNews.type + "</type><showflag>" + paramMallNews.BBd + "</showflag><newsTipFlag>" + paramMallNews.BBe + "</newsTipFlag></mallactivitynew></sysmsg>;");
    this.BBo.put(paramMallNews.hvE, paramMallNews);
    dpl();
    AppMethodBeat.o(70570);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.mall.d
 * JD-Core Version:    0.7.0.1
 */