package com.tencent.mm.plugin.wear.model.f;

import android.content.Context;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.protocal.protobuf.drj;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.bl;

public abstract class b
  extends c
{
  protected static String c(String paramString, bl parambl)
  {
    if (w.pF(paramString))
    {
      paramString = d(paramString, parambl);
      return String.format(aj.getContext().getString(2131761701), new Object[] { h.auR(paramString), Character.valueOf('​'), h.az(parambl).gKr });
    }
    return String.format(aj.getContext().getString(2131761702), new Object[] { h.az(parambl).gKr });
  }
  
  protected static String d(String paramString, bl parambl)
  {
    Object localObject = paramString;
    if (w.pF(paramString))
    {
      int i = bi.uc(parambl.field_content);
      localObject = paramString;
      if (i != -1)
      {
        parambl = parambl.field_content.substring(0, i).trim();
        localObject = paramString;
        if (parambl != null)
        {
          localObject = paramString;
          if (parambl.length() > 0) {
            localObject = parambl;
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