package com.tencent.mm.plugin.wallet_core.model.mall;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.z;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class d
{
  private static d umz = null;
  private Map<String, MallNews> umy;
  
  private d()
  {
    AppMethodBeat.i(47036);
    this.umy = new HashMap();
    Kc();
    AppMethodBeat.o(47036);
  }
  
  private static MallNews afs(String paramString)
  {
    AppMethodBeat.i(47042);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(47042);
      return null;
    }
    Map localMap = br.F(paramString, "sysmsg");
    if (localMap == null)
    {
      AppMethodBeat.o(47042);
      return null;
    }
    MallNews localMallNews;
    for (;;)
    {
      try
      {
        localMallNews = new MallNews((String)localMap.get(".sysmsg.mallactivitynew.functionid"));
        localMallNews.sWB = ((String)localMap.get(".sysmsg.mallactivitynew.activityid"));
        localMallNews.type = ((String)localMap.get(".sysmsg.mallactivitynew.type"));
        localMallNews.showType = bo.getInt((String)localMap.get(".sysmsg.mallactivitynew.showtype"), 0);
        if (localMap.containsKey(".sysmsg.mallactivitynew.showflag"))
        {
          localMallNews.umn = ((String)localMap.get(".sysmsg.mallactivitynew.showflag"));
          if (localMap.containsKey(".sysmsg.mallactivitynew.newsTipFlag"))
          {
            localMallNews.umo = ((String)localMap.get(".sysmsg.mallactivitynew.newsTipFlag"));
            localMallNews.umv = paramString;
            boolean bool = bo.isNullOrNil(localMallNews.ftd);
            if (!bool) {
              break;
            }
            AppMethodBeat.o(47042);
            return null;
          }
        }
        else
        {
          localMallNews.umn = "0";
          continue;
        }
        localMallNews.umo = "0";
      }
      catch (Exception paramString)
      {
        ab.e("MicroMsg.MallNewsManagerNewVersion", "cmdid error");
        AppMethodBeat.o(47042);
        return null;
      }
    }
    AppMethodBeat.o(47042);
    return localMallNews;
  }
  
  public static d cVb()
  {
    AppMethodBeat.i(47035);
    if (umz == null) {
      umz = new d();
    }
    d locald = umz;
    AppMethodBeat.o(47035);
    return locald;
  }
  
  private boolean cbo()
  {
    AppMethodBeat.i(47039);
    ab.d("MicroMsg.MallNewsManagerNewVersion", "notifyNewsMap.size : " + this.umy.size());
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = this.umy.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      if (!bo.isNullOrNil((String)localObject))
      {
        localObject = (MallNews)this.umy.get(localObject);
        localStringBuffer.append(((MallNews)localObject).umv.replace("</mallactivitynew></sysmsg>;", "").replaceAll("<activityid>([^<]*)</activityid>", "").replaceAll("<type>([^<]*)</type>", "").replaceAll("<showflag>([^<]*)</showflag>", "").replaceAll("<newsTipFlag>([^<]*)</newsTipFlag>", "") + "<activityid>" + ((MallNews)localObject).sWB + "</activityid><type>" + ((MallNews)localObject).type + "</type><showflag>" + ((MallNews)localObject).umn + "</showflag><newsTipFlag>" + ((MallNews)localObject).umo + "</newsTipFlag></mallactivitynew></sysmsg>;");
      }
    }
    ab.d("MicroMsg.MallNewsManagerNewVersion", "save data  : " + localStringBuffer.toString());
    g.RM();
    g.RL().Ru().set(270341, localStringBuffer.toString());
    AppMethodBeat.o(47039);
    return true;
  }
  
  public final void Kc()
  {
    AppMethodBeat.i(47037);
    this.umy.clear();
    g.RM();
    Object localObject = (String)g.RL().Ru().get(270341, "");
    ab.d("MicroMsg.MallNewsManagerNewVersion", "data : ".concat(String.valueOf(localObject)));
    localObject = bo.P(((String)localObject).split(";")).iterator();
    while (((Iterator)localObject).hasNext())
    {
      MallNews localMallNews = afs((String)((Iterator)localObject).next());
      if (localMallNews != null) {
        this.umy.put(localMallNews.ftd, localMallNews);
      }
    }
    AppMethodBeat.o(47037);
  }
  
  public final MallNews afr(String paramString)
  {
    AppMethodBeat.i(47041);
    ab.d("MicroMsg.MallNewsManagerNewVersion", "removeNewsInIndexUI : ".concat(String.valueOf(paramString)));
    if ((!bo.isNullOrNil(paramString)) && (this.umy.containsKey(paramString)))
    {
      paramString = (MallNews)this.umy.get(paramString);
      if ("0".equals(paramString.umn))
      {
        paramString.umn = "1";
        cbo();
      }
      AppMethodBeat.o(47041);
      return paramString;
    }
    AppMethodBeat.o(47041);
    return null;
  }
  
  public final MallNews aft(String paramString)
  {
    AppMethodBeat.i(47040);
    paramString = (MallNews)this.umy.get(paramString);
    AppMethodBeat.o(47040);
    return paramString;
  }
  
  public final void b(MallNews paramMallNews)
  {
    AppMethodBeat.i(47038);
    if (paramMallNews == null)
    {
      ab.w("MicroMsg.MallNewsManagerNewVersion", "null obj");
      AppMethodBeat.o(47038);
      return;
    }
    paramMallNews.umv = ("<sysmsg><mallactivitynew><functionid>" + paramMallNews.ftd + "</functionid><activityid>" + paramMallNews.sWB + "</activityid><type>" + paramMallNews.type + "</type><showflag>" + paramMallNews.umn + "</showflag><newsTipFlag>" + paramMallNews.umo + "</newsTipFlag></mallactivitynew></sysmsg>;");
    this.umy.put(paramMallNews.ftd, paramMallNews);
    cbo();
    AppMethodBeat.o(47038);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.mall.d
 * JD-Core Version:    0.7.0.1
 */