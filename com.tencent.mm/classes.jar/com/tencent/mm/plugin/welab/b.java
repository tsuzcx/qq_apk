package com.tencent.mm.plugin.welab;

import android.text.TextUtils;
import com.tencent.mm.as.a.a.c;
import com.tencent.mm.as.a.a.c.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class b
{
  private static final b rEq = new b();
  public c qXu;
  public com.tencent.mm.plugin.welab.c.a rEr;
  public Map<String, com.tencent.mm.plugin.welab.a.a.b> rEs = new HashMap();
  public com.tencent.mm.plugin.welab.a.a.b rEt;
  
  public b()
  {
    c.a locala = new c.a();
    locala.erf = true;
    locala.ere = true;
    this.qXu = locala.OV();
  }
  
  public static void Q(boolean paramBoolean1, boolean paramBoolean2)
  {
    f.R(paramBoolean1, paramBoolean2);
  }
  
  private com.tencent.mm.plugin.welab.a.a.b Ue(String paramString)
  {
    return (com.tencent.mm.plugin.welab.a.a.b)this.rEs.get(paramString);
  }
  
  public static String a(com.tencent.mm.plugin.welab.c.a.a parama)
  {
    String str = "";
    Object localObject = rEq.Ue(parama.field_LabsAppId);
    if (localObject != null)
    {
      str = parama.field_LabsAppId;
      str = ((com.tencent.mm.plugin.welab.a.a.b)localObject).chk();
      y.i("WelabMgr", "get appName from opener , appid %s, appName %s", new Object[] { parama.field_LabsAppId, str });
    }
    localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = parama.Um("field_Title");
    }
    return localObject;
  }
  
  public static String b(com.tencent.mm.plugin.welab.c.a.a parama)
  {
    String str = "";
    Object localObject = rEq.Ue(parama.field_LabsAppId);
    if (localObject != null)
    {
      str = parama.field_LabsAppId;
      str = ((com.tencent.mm.plugin.welab.a.a.b)localObject).chj();
      y.i("WelabMgr", "get icon url from opener , appid %s, url %s", new Object[] { parama.field_LabsAppId, str });
    }
    localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = parama.field_Icon;
    }
    return localObject;
  }
  
  public static b chc()
  {
    return rEq;
  }
  
  public final com.tencent.mm.plugin.welab.c.a.a Uf(String paramString)
  {
    com.tencent.mm.plugin.welab.c.a locala = this.rEr;
    com.tencent.mm.plugin.welab.c.a.a locala1 = new com.tencent.mm.plugin.welab.c.a.a();
    locala1.field_LabsAppId = paramString;
    locala.b(locala1, new String[0]);
    return locala1;
  }
  
  public final List<com.tencent.mm.plugin.welab.c.a.a> chd()
  {
    List localList = this.rEr.chl();
    Object localObject = localList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      com.tencent.mm.plugin.welab.c.a.a locala = (com.tencent.mm.plugin.welab.c.a.a)((Iterator)localObject).next();
      if ((!locala.isRunning()) || ((locala.field_Switch != 2) && (locala.field_Switch != 1)) || ("labs1de6f3".equals(locala.field_LabsAppId))) {
        ((Iterator)localObject).remove();
      }
    }
    if ("online lab " + localList != null) {}
    for (localObject = localList.toString();; localObject = "")
    {
      y.i("WelabMgr", (String)localObject);
      return localList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.b
 * JD-Core Version:    0.7.0.1
 */