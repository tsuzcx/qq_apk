package com.tencent.mm.plugin.welab;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.oy;
import com.tencent.mm.autogen.a.ti;
import com.tencent.mm.modelimage.loader.a.c;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class b
{
  public static final b XyA;
  public c Wtu;
  public com.tencent.mm.plugin.welab.d.a XyB;
  public Map<String, com.tencent.mm.plugin.welab.a.a.b> XyC;
  public com.tencent.mm.plugin.welab.a.a.b XyD;
  
  static
  {
    AppMethodBeat.i(146208);
    XyA = new b();
    AppMethodBeat.o(146208);
  }
  
  public b()
  {
    AppMethodBeat.i(146200);
    this.XyC = new HashMap();
    c.a locala = new c.a();
    locala.oKp = true;
    locala.oKo = true;
    this.Wtu = locala.bKx();
    AppMethodBeat.o(146200);
  }
  
  public static String a(com.tencent.mm.plugin.welab.d.a.a parama)
  {
    AppMethodBeat.i(146201);
    String str = "";
    Object localObject = XyA.bnm(parama.field_LabsAppId);
    if (localObject != null)
    {
      str = ((com.tencent.mm.plugin.welab.a.a.b)localObject).iDH();
      Log.i("WelabMgr", "get appName from opener , appid %s, appName %s", new Object[] { parama.field_LabsAppId, str });
    }
    localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = parama.bnv("field_Title");
    }
    AppMethodBeat.o(146201);
    return localObject;
  }
  
  public static String b(com.tencent.mm.plugin.welab.d.a.a parama)
  {
    AppMethodBeat.i(146202);
    String str = "";
    Object localObject = XyA.bnm(parama.field_LabsAppId);
    if (localObject != null)
    {
      str = ((com.tencent.mm.plugin.welab.a.a.b)localObject).iDG();
      Log.i("WelabMgr", "get icon url from opener , appid %s, url %s", new Object[] { parama.field_LabsAppId, str });
    }
    localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = parama.field_Icon;
    }
    AppMethodBeat.o(146202);
    return localObject;
  }
  
  private com.tencent.mm.plugin.welab.a.a.b bnm(String paramString)
  {
    AppMethodBeat.i(146203);
    paramString = (com.tencent.mm.plugin.welab.a.a.b)this.XyC.get(paramString);
    AppMethodBeat.o(146203);
    return paramString;
  }
  
  public static b iDA()
  {
    return XyA;
  }
  
  public static List<com.tencent.mm.plugin.welab.d.a.a> iDC()
  {
    AppMethodBeat.i(262789);
    ArrayList localArrayList = new ArrayList();
    com.tencent.mm.plugin.welab.d.a.a locala = new com.tencent.mm.plugin.welab.d.a.a();
    locala.field_LabsAppId = "wximeplugin";
    locala.field_Title_cn = "微信键盘";
    locala.field_Desc_cn = "在这里可以设置专属你的微信键盘";
    localArrayList.add(locala);
    Log.i("WelabMgr", "getHardcodeOnlineApp lab %s", new Object[] { localArrayList.toString() });
    AppMethodBeat.o(262789);
    return localArrayList;
  }
  
  public static void mo(List<com.tencent.mm.plugin.welab.d.a.a> paramList)
  {
    AppMethodBeat.i(146207);
    if (!paramList.isEmpty())
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        com.tencent.mm.plugin.welab.d.a.a locala = (com.tencent.mm.plugin.welab.d.a.a)paramList.next();
        if ((!locala.iDK()) && (!locala.isExpired())) {
          localArrayList.add(locala.field_LabsAppId);
        }
      }
      paramList = new ti();
      paramList.hWS.hWT = localArrayList;
      paramList.publish();
      paramList = localArrayList.iterator();
      while (paramList.hasNext()) {
        if ("labs_nearbylife".equals((String)paramList.next()))
        {
          new oy().publish();
          AppMethodBeat.o(146207);
          return;
        }
      }
    }
    AppMethodBeat.o(146207);
  }
  
  public final com.tencent.mm.plugin.welab.d.a.a bnn(String paramString)
  {
    AppMethodBeat.i(146206);
    com.tencent.mm.plugin.welab.d.a locala = this.XyB;
    com.tencent.mm.plugin.welab.d.a.a locala1 = new com.tencent.mm.plugin.welab.d.a.a();
    locala1.field_LabsAppId = paramString;
    locala.get(locala1, new String[0]);
    AppMethodBeat.o(146206);
    return locala1;
  }
  
  public final List<com.tencent.mm.plugin.welab.d.a.a> iDB()
  {
    AppMethodBeat.i(146205);
    List localList = this.XyB.iDI();
    Object localObject = localList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      com.tencent.mm.plugin.welab.d.a.a locala = (com.tencent.mm.plugin.welab.d.a.a)((Iterator)localObject).next();
      if ((!locala.isRunning()) || ((locala.field_Switch != 2) && (locala.field_Switch != 1)) || ("labs1de6f3".equals(locala.field_LabsAppId))) {
        ((Iterator)localObject).remove();
      }
    }
    if (localList != null) {}
    for (localObject = localList.toString();; localObject = "")
    {
      Log.i("WelabMgr", "online lab %s", new Object[] { localObject });
      AppMethodBeat.o(146205);
      return localList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.b
 * JD-Core Version:    0.7.0.1
 */