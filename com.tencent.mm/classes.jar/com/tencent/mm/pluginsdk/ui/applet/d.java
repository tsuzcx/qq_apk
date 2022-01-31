package com.tencent.mm.pluginsdk.ui.applet;

import com.tencent.mm.ai.a.e;
import com.tencent.mm.ai.a.j;
import com.tencent.mm.ai.a.k;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.z;
import com.tencent.mm.as.a.a.c;
import com.tencent.mm.as.a.a.c.a;
import com.tencent.mm.plugin.biz.b.a;
import com.tencent.mm.sdk.platformtools.bk;

public final class d
  implements p
{
  public final boolean WC(String paramString)
  {
    return f.eW(paramString);
  }
  
  public final Object WD(String paramString)
  {
    j localj2 = z.MC().bY(paramString);
    j localj1;
    if ((localj2 != null) && (!bk.bl(localj2.field_userId)))
    {
      localj1 = localj2;
      if (localj2.field_userId.equals(paramString)) {}
    }
    else
    {
      localj1 = new j();
      localj1.field_userId = paramString;
    }
    return localj1;
  }
  
  public final c WE(String paramString)
  {
    c.a locala = new c.a();
    locala.eri = e.ly(paramString);
    locala.erf = true;
    locala.erC = true;
    locala.eru = b.a.default_avatar;
    return locala.OV();
  }
  
  public final String bJ(Object paramObject)
  {
    return ((j)paramObject).field_userName;
  }
  
  public final String bK(Object paramObject)
  {
    return ((j)paramObject).field_headImageUrl;
  }
  
  public final String bL(Object paramObject)
  {
    return ((j)paramObject).field_userId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.d
 * JD-Core Version:    0.7.0.1
 */