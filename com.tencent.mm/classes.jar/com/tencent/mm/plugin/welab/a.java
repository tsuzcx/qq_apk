package com.tencent.mm.plugin.welab;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a.a.c;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.g.a.mg;
import com.tencent.mm.g.a.py;
import com.tencent.mm.plugin.welab.a.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class a
{
  public static final a ExH;
  public c DEF;
  public com.tencent.mm.plugin.welab.d.a ExI;
  public Map<String, b> ExJ;
  public b ExK;
  
  static
  {
    AppMethodBeat.i(146208);
    ExH = new a();
    AppMethodBeat.o(146208);
  }
  
  public a()
  {
    AppMethodBeat.i(146200);
    this.ExJ = new HashMap();
    c.a locala = new c.a();
    locala.idr = true;
    locala.idq = true;
    this.DEF = locala.aJc();
    AppMethodBeat.o(146200);
  }
  
  public static String a(com.tencent.mm.plugin.welab.d.a.a parama)
  {
    AppMethodBeat.i(146201);
    String str = "";
    Object localObject = ExH.aJM(parama.field_LabsAppId);
    if (localObject != null)
    {
      str = ((b)localObject).eWv();
      ad.i("WelabMgr", "get appName from opener , appid %s, appName %s", new Object[] { parama.field_LabsAppId, str });
    }
    localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = parama.aJV("field_Title");
    }
    AppMethodBeat.o(146201);
    return localObject;
  }
  
  private b aJM(String paramString)
  {
    AppMethodBeat.i(146203);
    paramString = (b)this.ExJ.get(paramString);
    AppMethodBeat.o(146203);
    return paramString;
  }
  
  public static void aK(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(146204);
    e.aL(paramBoolean1, paramBoolean2);
    AppMethodBeat.o(146204);
  }
  
  public static String b(com.tencent.mm.plugin.welab.d.a.a parama)
  {
    AppMethodBeat.i(146202);
    String str = "";
    Object localObject = ExH.aJM(parama.field_LabsAppId);
    if (localObject != null)
    {
      str = ((b)localObject).eWu();
      ad.i("WelabMgr", "get icon url from opener , appid %s, url %s", new Object[] { parama.field_LabsAppId, str });
    }
    localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = parama.field_Icon;
    }
    AppMethodBeat.o(146202);
    return localObject;
  }
  
  public static a eWo()
  {
    return ExH;
  }
  
  public static void gY(List<com.tencent.mm.plugin.welab.d.a.a> paramList)
  {
    AppMethodBeat.i(146207);
    if (!paramList.isEmpty())
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        com.tencent.mm.plugin.welab.d.a.a locala = (com.tencent.mm.plugin.welab.d.a.a)paramList.next();
        if ((!locala.eWz()) && (!locala.isExpired())) {
          localArrayList.add(locala.field_LabsAppId);
        }
      }
      paramList = new py();
      paramList.dEr.dEs = localArrayList;
      com.tencent.mm.sdk.b.a.IbL.l(paramList);
      paramList = localArrayList.iterator();
      while (paramList.hasNext()) {
        if ("labs_nearbylife".equals((String)paramList.next()))
        {
          com.tencent.mm.sdk.b.a.IbL.l(new mg());
          AppMethodBeat.o(146207);
          return;
        }
      }
    }
    AppMethodBeat.o(146207);
  }
  
  public final com.tencent.mm.plugin.welab.d.a.a aJN(String paramString)
  {
    AppMethodBeat.i(146206);
    com.tencent.mm.plugin.welab.d.a locala = this.ExI;
    com.tencent.mm.plugin.welab.d.a.a locala1 = new com.tencent.mm.plugin.welab.d.a.a();
    locala1.field_LabsAppId = paramString;
    locala.get(locala1, new String[0]);
    AppMethodBeat.o(146206);
    return locala1;
  }
  
  public final List<com.tencent.mm.plugin.welab.d.a.a> eWp()
  {
    AppMethodBeat.i(146205);
    List localList = this.ExI.eWw();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.a
 * JD-Core Version:    0.7.0.1
 */