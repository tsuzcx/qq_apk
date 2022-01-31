package com.tencent.mm.plugin.wear.model.f;

import android.content.Context;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.protocal.protobuf.cxf;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.bi;

public abstract class b
  extends c
{
  protected static String b(String paramString, bi parambi)
  {
    if (t.lA(paramString))
    {
      paramString = c(paramString, parambi);
      return String.format(ah.getContext().getString(2131301939), new Object[] { h.agg(paramString), Character.valueOf('​'), h.aj(parambi).ntu });
    }
    return String.format(ah.getContext().getString(2131301940), new Object[] { h.aj(parambi).ntu });
  }
  
  protected static String c(String paramString, bi parambi)
  {
    Object localObject = paramString;
    if (t.lA(paramString))
    {
      int i = bf.pt(parambi.field_content);
      localObject = paramString;
      if (i != -1)
      {
        parambi = parambi.field_content.substring(0, i).trim();
        localObject = paramString;
        if (parambi != null)
        {
          localObject = paramString;
          if (parambi.length() > 0) {
            localObject = parambi;
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