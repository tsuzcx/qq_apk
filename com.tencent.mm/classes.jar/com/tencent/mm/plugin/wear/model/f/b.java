package com.tencent.mm.plugin.wear.model.f;

import android.content.Context;
import com.tencent.mm.R.l;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bq;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.protocal.protobuf.fjq;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.ca;

public abstract class b
  extends c
{
  protected static String c(String paramString, ca paramca)
  {
    if (ab.Lj(paramString))
    {
      paramString = d(paramString, paramca);
      return String.format(MMApplicationContext.getContext().getString(R.l.eNt), new Object[] { h.bhV(paramString), Character.valueOf('​'), h.bd(paramca).lpy });
    }
    return String.format(MMApplicationContext.getContext().getString(R.l.eNu), new Object[] { h.bd(paramca).lpy });
  }
  
  protected static String d(String paramString, ca paramca)
  {
    Object localObject = paramString;
    if (ab.Lj(paramString))
    {
      int i = bq.RI(paramca.field_content);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.f.b
 * JD-Core Version:    0.7.0.1
 */