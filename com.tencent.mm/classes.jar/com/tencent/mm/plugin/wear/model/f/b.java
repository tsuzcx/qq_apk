package com.tencent.mm.plugin.wear.model.f;

import android.content.Context;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.protocal.protobuf.eda;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.bu;

public abstract class b
  extends c
{
  protected static String c(String paramString, bu parambu)
  {
    if (w.vF(paramString))
    {
      paramString = d(paramString, parambu);
      return String.format(aj.getContext().getString(2131761701), new Object[] { h.aFs(paramString), Character.valueOf('​'), h.aE(parambu).hDa });
    }
    return String.format(aj.getContext().getString(2131761702), new Object[] { h.aE(parambu).hDa });
  }
  
  protected static String d(String paramString, bu parambu)
  {
    Object localObject = paramString;
    if (w.vF(paramString))
    {
      int i = bj.Bh(parambu.field_content);
      localObject = paramString;
      if (i != -1)
      {
        parambu = parambu.field_content.substring(0, i).trim();
        localObject = paramString;
        if (parambu != null)
        {
          localObject = paramString;
          if (parambu.length() > 0) {
            localObject = parambu;
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