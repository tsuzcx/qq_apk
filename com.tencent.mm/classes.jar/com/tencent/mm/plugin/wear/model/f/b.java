package com.tencent.mm.plugin.wear.model.f;

import android.content.Context;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.protocal.protobuf.dxa;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.storage.bo;

public abstract class b
  extends c
{
  protected static String c(String paramString, bo parambo)
  {
    if (w.sQ(paramString))
    {
      paramString = d(paramString, parambo);
      return String.format(ai.getContext().getString(2131761701), new Object[] { h.aAi(paramString), Character.valueOf('​'), h.aB(parambo).hkR });
    }
    return String.format(ai.getContext().getString(2131761702), new Object[] { h.aB(parambo).hkR });
  }
  
  protected static String d(String paramString, bo parambo)
  {
    Object localObject = paramString;
    if (w.sQ(paramString))
    {
      int i = bi.yi(parambo.field_content);
      localObject = paramString;
      if (i != -1)
      {
        parambo = parambo.field_content.substring(0, i).trim();
        localObject = paramString;
        if (parambo != null)
        {
          localObject = paramString;
          if (parambo.length() > 0) {
            localObject = parambo;
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