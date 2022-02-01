package com.tencent.mm.plugin.wallet_core.model.mall;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.aj;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class d
{
  private static d Dtl = null;
  private Map<String, MallNews> Dtk;
  
  private d()
  {
    AppMethodBeat.i(70568);
    this.Dtk = new HashMap();
    Zm();
    AppMethodBeat.o(70568);
  }
  
  private static MallNews aFX(String paramString)
  {
    AppMethodBeat.i(70574);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(70574);
      return null;
    }
    Map localMap = bx.M(paramString, "sysmsg");
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
        localMallNews.ByB = ((String)localMap.get(".sysmsg.mallactivitynew.activityid"));
        localMallNews.type = ((String)localMap.get(".sysmsg.mallactivitynew.type"));
        localMallNews.dmr = bu.getInt((String)localMap.get(".sysmsg.mallactivitynew.showtype"), 0);
        if (localMap.containsKey(".sysmsg.mallactivitynew.showflag"))
        {
          localMallNews.DsZ = ((String)localMap.get(".sysmsg.mallactivitynew.showflag"));
          if (localMap.containsKey(".sysmsg.mallactivitynew.newsTipFlag"))
          {
            localMallNews.Dta = ((String)localMap.get(".sysmsg.mallactivitynew.newsTipFlag"));
            localMallNews.Dth = paramString;
            boolean bool = bu.isNullOrNil(localMallNews.hQM);
            if (!bool) {
              break;
            }
            AppMethodBeat.o(70574);
            return null;
          }
        }
        else
        {
          localMallNews.DsZ = "0";
          continue;
        }
        localMallNews.Dta = "0";
      }
      catch (Exception paramString)
      {
        ae.e("MicroMsg.MallNewsManagerNewVersion", "cmdid error");
        AppMethodBeat.o(70574);
        return null;
      }
    }
    AppMethodBeat.o(70574);
    return localMallNews;
  }
  
  private boolean dDe()
  {
    AppMethodBeat.i(70571);
    ae.d("MicroMsg.MallNewsManagerNewVersion", "notifyNewsMap.size : " + this.Dtk.size());
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = this.Dtk.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      if (!bu.isNullOrNil((String)localObject))
      {
        localObject = (MallNews)this.Dtk.get(localObject);
        localStringBuffer.append(((MallNews)localObject).Dth.replace("</mallactivitynew></sysmsg>;", "").replaceAll("<activityid>([^<]*)</activityid>", "").replaceAll("<type>([^<]*)</type>", "").replaceAll("<showflag>([^<]*)</showflag>", "").replaceAll("<newsTipFlag>([^<]*)</newsTipFlag>", "") + "<activityid>" + ((MallNews)localObject).ByB + "</activityid><type>" + ((MallNews)localObject).type + "</type><showflag>" + ((MallNews)localObject).DsZ + "</showflag><newsTipFlag>" + ((MallNews)localObject).Dta + "</newsTipFlag></mallactivitynew></sysmsg>;");
      }
    }
    ae.d("MicroMsg.MallNewsManagerNewVersion", "save data  : " + localStringBuffer.toString());
    g.ajS();
    g.ajR().ajA().set(270341, localStringBuffer.toString());
    AppMethodBeat.o(70571);
    return true;
  }
  
  public static d eKF()
  {
    AppMethodBeat.i(70567);
    if (Dtl == null) {
      Dtl = new d();
    }
    d locald = Dtl;
    AppMethodBeat.o(70567);
    return locald;
  }
  
  public final void Zm()
  {
    AppMethodBeat.i(70569);
    this.Dtk.clear();
    g.ajS();
    Object localObject = (String)g.ajR().ajA().get(270341, "");
    ae.d("MicroMsg.MallNewsManagerNewVersion", "data : ".concat(String.valueOf(localObject)));
    localObject = bu.U(((String)localObject).split(";")).iterator();
    while (((Iterator)localObject).hasNext())
    {
      MallNews localMallNews = aFX((String)((Iterator)localObject).next());
      if (localMallNews != null) {
        this.Dtk.put(localMallNews.hQM, localMallNews);
      }
    }
    AppMethodBeat.o(70569);
  }
  
  public final MallNews aFW(String paramString)
  {
    AppMethodBeat.i(70573);
    ae.d("MicroMsg.MallNewsManagerNewVersion", "removeNewsInIndexUI : ".concat(String.valueOf(paramString)));
    if ((!bu.isNullOrNil(paramString)) && (this.Dtk.containsKey(paramString)))
    {
      paramString = (MallNews)this.Dtk.get(paramString);
      if ("0".equals(paramString.DsZ))
      {
        paramString.DsZ = "1";
        dDe();
      }
      AppMethodBeat.o(70573);
      return paramString;
    }
    AppMethodBeat.o(70573);
    return null;
  }
  
  public final MallNews aFY(String paramString)
  {
    AppMethodBeat.i(70572);
    paramString = (MallNews)this.Dtk.get(paramString);
    AppMethodBeat.o(70572);
    return paramString;
  }
  
  public final void b(MallNews paramMallNews)
  {
    AppMethodBeat.i(70570);
    if (paramMallNews == null)
    {
      ae.w("MicroMsg.MallNewsManagerNewVersion", "null obj");
      AppMethodBeat.o(70570);
      return;
    }
    paramMallNews.Dth = ("<sysmsg><mallactivitynew><functionid>" + paramMallNews.hQM + "</functionid><activityid>" + paramMallNews.ByB + "</activityid><type>" + paramMallNews.type + "</type><showflag>" + paramMallNews.DsZ + "</showflag><newsTipFlag>" + paramMallNews.Dta + "</newsTipFlag></mallactivitynew></sysmsg>;");
    this.Dtk.put(paramMallNews.hQM, paramMallNews);
    dDe();
    AppMethodBeat.o(70570);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.mall.d
 * JD-Core Version:    0.7.0.1
 */