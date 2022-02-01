package com.tencent.mm.plugin.welab;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.g.a.mh;
import com.tencent.mm.g.a.pz;
import com.tencent.mm.plugin.welab.a.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class a
{
  public static final a EQd;
  public c DWD;
  public com.tencent.mm.plugin.welab.d.a EQe;
  public Map<String, b> EQf;
  public b EQg;
  
  static
  {
    AppMethodBeat.i(146208);
    EQd = new a();
    AppMethodBeat.o(146208);
  }
  
  public a()
  {
    AppMethodBeat.i(146200);
    this.EQf = new HashMap();
    c.a locala = new c.a();
    locala.igk = true;
    locala.igj = true;
    this.DWD = locala.aJu();
    AppMethodBeat.o(146200);
  }
  
  public static String a(com.tencent.mm.plugin.welab.d.a.a parama)
  {
    AppMethodBeat.i(146201);
    String str = "";
    Object localObject = EQd.aLi(parama.field_LabsAppId);
    if (localObject != null)
    {
      str = ((b)localObject).fah();
      ae.i("WelabMgr", "get appName from opener , appid %s, appName %s", new Object[] { parama.field_LabsAppId, str });
    }
    localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = parama.aLr("field_Title");
    }
    AppMethodBeat.o(146201);
    return localObject;
  }
  
  public static void aJ(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(146204);
    e.aK(paramBoolean1, paramBoolean2);
    AppMethodBeat.o(146204);
  }
  
  private b aLi(String paramString)
  {
    AppMethodBeat.i(146203);
    paramString = (b)this.EQf.get(paramString);
    AppMethodBeat.o(146203);
    return paramString;
  }
  
  public static String b(com.tencent.mm.plugin.welab.d.a.a parama)
  {
    AppMethodBeat.i(146202);
    String str = "";
    Object localObject = EQd.aLi(parama.field_LabsAppId);
    if (localObject != null)
    {
      str = ((b)localObject).fag();
      ae.i("WelabMgr", "get icon url from opener , appid %s, url %s", new Object[] { parama.field_LabsAppId, str });
    }
    localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = parama.field_Icon;
    }
    AppMethodBeat.o(146202);
    return localObject;
  }
  
  public static a faa()
  {
    return EQd;
  }
  
  public static void hi(List<com.tencent.mm.plugin.welab.d.a.a> paramList)
  {
    AppMethodBeat.i(146207);
    if (!paramList.isEmpty())
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        com.tencent.mm.plugin.welab.d.a.a locala = (com.tencent.mm.plugin.welab.d.a.a)paramList.next();
        if ((!locala.fal()) && (!locala.isExpired())) {
          localArrayList.add(locala.field_LabsAppId);
        }
      }
      paramList = new pz();
      paramList.dFw.dFx = localArrayList;
      com.tencent.mm.sdk.b.a.IvT.l(paramList);
      paramList = localArrayList.iterator();
      while (paramList.hasNext()) {
        if ("labs_nearbylife".equals((String)paramList.next()))
        {
          com.tencent.mm.sdk.b.a.IvT.l(new mh());
          AppMethodBeat.o(146207);
          return;
        }
      }
    }
    AppMethodBeat.o(146207);
  }
  
  public final com.tencent.mm.plugin.welab.d.a.a aLj(String paramString)
  {
    AppMethodBeat.i(146206);
    com.tencent.mm.plugin.welab.d.a locala = this.EQe;
    com.tencent.mm.plugin.welab.d.a.a locala1 = new com.tencent.mm.plugin.welab.d.a.a();
    locala1.field_LabsAppId = paramString;
    locala.get(locala1, new String[0]);
    AppMethodBeat.o(146206);
    return locala1;
  }
  
  public final List<com.tencent.mm.plugin.welab.d.a.a> fab()
  {
    AppMethodBeat.i(146205);
    List localList = this.EQe.fai();
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.welab.d.a.a locala = (com.tencent.mm.plugin.welab.d.a.a)localIterator.next();
      if ((!locala.isRunning()) || ((locala.field_Switch != 2) && (locala.field_Switch != 1)) || ("labs1de6f3".equals(locala.field_LabsAppId))) {
        localIterator.remove();
      }
    }
    ae.i("WelabMgr", "online lab %s", new Object[] { localList.toString() });
    AppMethodBeat.o(146205);
    return localList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.a
 * JD-Core Version:    0.7.0.1
 */