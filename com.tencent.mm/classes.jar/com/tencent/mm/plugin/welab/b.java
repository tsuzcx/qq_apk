package com.tencent.mm.plugin.welab;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.a.a.c;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.f.a.nq;
import com.tencent.mm.f.a.rt;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class b
{
  public static final b QFc;
  public c PCP;
  public com.tencent.mm.plugin.welab.d.a QFd;
  public Map<String, com.tencent.mm.plugin.welab.a.a.b> QFe;
  public com.tencent.mm.plugin.welab.a.a.b QFf;
  
  static
  {
    AppMethodBeat.i(146208);
    QFc = new b();
    AppMethodBeat.o(146208);
  }
  
  public b()
  {
    AppMethodBeat.i(146200);
    this.QFe = new HashMap();
    c.a locala = new c.a();
    locala.lRD = true;
    locala.lRC = true;
    this.PCP = locala.bmL();
    AppMethodBeat.o(146200);
  }
  
  public static String a(com.tencent.mm.plugin.welab.d.a.a parama)
  {
    AppMethodBeat.i(146201);
    String str = "";
    Object localObject = QFc.bny(parama.field_LabsAppId);
    if (localObject != null)
    {
      str = ((com.tencent.mm.plugin.welab.a.a.b)localObject).hcZ();
      Log.i("WelabMgr", "get appName from opener , appid %s, appName %s", new Object[] { parama.field_LabsAppId, str });
    }
    localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = parama.bnH("field_Title");
    }
    AppMethodBeat.o(146201);
    return localObject;
  }
  
  public static String b(com.tencent.mm.plugin.welab.d.a.a parama)
  {
    AppMethodBeat.i(146202);
    String str = "";
    Object localObject = QFc.bny(parama.field_LabsAppId);
    if (localObject != null)
    {
      str = ((com.tencent.mm.plugin.welab.a.a.b)localObject).hcY();
      Log.i("WelabMgr", "get icon url from opener , appid %s, url %s", new Object[] { parama.field_LabsAppId, str });
    }
    localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = parama.field_Icon;
    }
    AppMethodBeat.o(146202);
    return localObject;
  }
  
  private com.tencent.mm.plugin.welab.a.a.b bny(String paramString)
  {
    AppMethodBeat.i(146203);
    paramString = (com.tencent.mm.plugin.welab.a.a.b)this.QFe.get(paramString);
    AppMethodBeat.o(146203);
    return paramString;
  }
  
  public static b hcS()
  {
    return QFc;
  }
  
  public static List<com.tencent.mm.plugin.welab.d.a.a> hcU()
  {
    AppMethodBeat.i(248551);
    ArrayList localArrayList = new ArrayList();
    com.tencent.mm.plugin.welab.d.a.a locala = new com.tencent.mm.plugin.welab.d.a.a();
    locala.field_LabsAppId = "wximeplugin";
    locala.field_Title_cn = "微信键盘";
    locala.field_Desc_cn = "在这里可以设置专属你的微信键盘";
    localArrayList.add(locala);
    Log.i("WelabMgr", "getHardcodeOnlineApp lab %s", new Object[] { localArrayList.toString() });
    AppMethodBeat.o(248551);
    return localArrayList;
  }
  
  public static void jf(List<com.tencent.mm.plugin.welab.d.a.a> paramList)
  {
    AppMethodBeat.i(146207);
    if (!paramList.isEmpty())
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        com.tencent.mm.plugin.welab.d.a.a locala = (com.tencent.mm.plugin.welab.d.a.a)paramList.next();
        if ((!locala.hdd()) && (!locala.isExpired())) {
          localArrayList.add(locala.field_LabsAppId);
        }
      }
      paramList = new rt();
      paramList.fQV.fQW = localArrayList;
      EventCenter.instance.publish(paramList);
      paramList = localArrayList.iterator();
      while (paramList.hasNext()) {
        if ("labs_nearbylife".equals((String)paramList.next()))
        {
          EventCenter.instance.publish(new nq());
          AppMethodBeat.o(146207);
          return;
        }
      }
    }
    AppMethodBeat.o(146207);
  }
  
  public final com.tencent.mm.plugin.welab.d.a.a bnz(String paramString)
  {
    AppMethodBeat.i(146206);
    com.tencent.mm.plugin.welab.d.a locala = this.QFd;
    com.tencent.mm.plugin.welab.d.a.a locala1 = new com.tencent.mm.plugin.welab.d.a.a();
    locala1.field_LabsAppId = paramString;
    locala.get(locala1, new String[0]);
    AppMethodBeat.o(146206);
    return locala1;
  }
  
  public final List<com.tencent.mm.plugin.welab.d.a.a> hcT()
  {
    AppMethodBeat.i(146205);
    List localList = this.QFd.hda();
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.welab.d.a.a locala = (com.tencent.mm.plugin.welab.d.a.a)localIterator.next();
      if ((!locala.isRunning()) || ((locala.field_Switch != 2) && (locala.field_Switch != 1)) || ("labs1de6f3".equals(locala.field_LabsAppId))) {
        localIterator.remove();
      }
    }
    Log.i("WelabMgr", "online lab %s", new Object[] { localList.toString() });
    AppMethodBeat.o(146205);
    return localList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.b
 * JD-Core Version:    0.7.0.1
 */