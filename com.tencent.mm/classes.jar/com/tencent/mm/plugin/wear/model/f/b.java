package com.tencent.mm.plugin.wear.model.f;

import android.content.Context;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.protocal.protobuf.eyz;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.ca;

public abstract class b
  extends c
{
  protected static String c(String paramString, ca paramca)
  {
    if (ab.Eq(paramString))
    {
      paramString = d(paramString, paramca);
      return String.format(MMApplicationContext.getContext().getString(2131763669), new Object[] { h.aWo(paramString), Character.valueOf('​'), h.aP(paramca).iAc });
    }
    return String.format(MMApplicationContext.getContext().getString(2131763670), new Object[] { h.aP(paramca).iAc });
  }
  
  protected static String d(String paramString, ca paramca)
  {
    Object localObject = paramString;
    if (ab.Eq(paramString))
    {
      int i = bp.Kp(paramca.field_content);
      localObject = paramString;
      if (i != -1)
      {
        paramca = paramca.field_content.substring(0, i).trim();
        localObject = paramString;
        if (paramca != null)
        {
          localObject = paramString;
          if (paramca.length() > 0) {
            localObject = paramca;
          }
        }
      }
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.f.b
 * JD-Core Version:    0.7.0.1
 */