package com.tencent.mm.plugin.welab;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a.a.c;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.g.a.lo;
import com.tencent.mm.g.a.pf;
import com.tencent.mm.plugin.welab.a.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class a
{
  public static final a BBB;
  public c AJq;
  public com.tencent.mm.plugin.welab.d.a BBC;
  public Map<String, b> BBD;
  public b BBE;
  
  static
  {
    AppMethodBeat.i(146208);
    BBB = new a();
    AppMethodBeat.o(146208);
  }
  
  public a()
  {
    AppMethodBeat.i(146200);
    this.BBD = new HashMap();
    c.a locala = new c.a();
    locala.hjU = true;
    locala.hjT = true;
    this.AJq = locala.azc();
    AppMethodBeat.o(146200);
  }
  
  public static String a(com.tencent.mm.plugin.welab.d.a.a parama)
  {
    AppMethodBeat.i(146201);
    String str = "";
    Object localObject = BBB.ayV(parama.field_LabsAppId);
    if (localObject != null)
    {
      str = ((b)localObject).esi();
      ad.i("WelabMgr", "get appName from opener , appid %s, appName %s", new Object[] { parama.field_LabsAppId, str });
    }
    localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = parama.aze("field_Title");
    }
    AppMethodBeat.o(146201);
    return localObject;
  }
  
  private b ayV(String paramString)
  {
    AppMethodBeat.i(146203);
    paramString = (b)this.BBD.get(paramString);
    AppMethodBeat.o(146203);
    return paramString;
  }
  
  public static void az(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(146204);
    e.aA(paramBoolean1, paramBoolean2);
    AppMethodBeat.o(146204);
  }
  
  public static String b(com.tencent.mm.plugin.welab.d.a.a parama)
  {
    AppMethodBeat.i(146202);
    String str = "";
    Object localObject = BBB.ayV(parama.field_LabsAppId);
    if (localObject != null)
    {
      str = ((b)localObject).esh();
      ad.i("WelabMgr", "get icon url from opener , appid %s, url %s", new Object[] { parama.field_LabsAppId, str });
    }
    localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = parama.field_Icon;
    }
    AppMethodBeat.o(146202);
    return localObject;
  }
  
  public static a esb()
  {
    return BBB;
  }
  
  public static void gB(List<com.tencent.mm.plugin.welab.d.a.a> paramList)
  {
    AppMethodBeat.i(146207);
    if (!paramList.isEmpty())
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        com.tencent.mm.plugin.welab.d.a.a locala = (com.tencent.mm.plugin.welab.d.a.a)paramList.next();
        if ((!locala.esn()) && (!locala.isExpired())) {
          localArrayList.add(locala.field_LabsAppId);
        }
      }
      paramList = new pf();
      paramList.duM.duN = localArrayList;
      com.tencent.mm.sdk.b.a.ESL.l(paramList);
      paramList = localArrayList.iterator();
      while (paramList.hasNext()) {
        if ("labs_nearbylife".equals((String)paramList.next()))
        {
          com.tencent.mm.sdk.b.a.ESL.l(new lo());
          AppMethodBeat.o(146207);
          return;
        }
      }
    }
    AppMethodBeat.o(146207);
  }
  
  public final com.tencent.mm.plugin.welab.d.a.a ayW(String paramString)
  {
    AppMethodBeat.i(146206);
    com.tencent.mm.plugin.welab.d.a locala = this.BBC;
    com.tencent.mm.plugin.welab.d.a.a locala1 = new com.tencent.mm.plugin.welab.d.a.a();
    locala1.field_LabsAppId = paramString;
    locala.get(locala1, new String[0]);
    AppMethodBeat.o(146206);
    return locala1;
  }
  
  public final List<com.tencent.mm.plugin.welab.d.a.a> esc()
  {
    AppMethodBeat.i(146205);
    List localList = this.BBC.esj();
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.welab.d.a.a locala = (com.tencent.mm.plugin.welab.d.a.a)localIterator.next();
      if ((!locala.isRunning()) || ((locala.field_Switch != 2) && (locala.field_Switch != 1)) || ("labs1de6f3".equals(locala.field_LabsAppId))) {
        localIterator.remove();
      }
    }
    ad.i("WelabMgr", "online lab %s", new Object[] { localList.toString() });
    AppMethodBeat.o(146205);
    return localList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.a
 * JD-Core Version:    0.7.0.1
 */