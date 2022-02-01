package com.tencent.mm.plugin.wear.model.f;

import android.content.Context;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.protocal.protobuf.eer;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.bv;

public abstract class b
  extends c
{
  protected static String c(String paramString, bv parambv)
  {
    if (x.wb(paramString))
    {
      paramString = d(paramString, parambv);
      return String.format(ak.getContext().getString(2131761701), new Object[] { h.aGM(paramString), Character.valueOf('​'), h.aD(parambv).hFS });
    }
    return String.format(ak.getContext().getString(2131761702), new Object[] { h.aD(parambv).hFS });
  }
  
  protected static String d(String paramString, bv parambv)
  {
    Object localObject = paramString;
    if (x.wb(paramString))
    {
      int i = bl.BJ(parambv.field_content);
      localObject = paramString;
      if (i != -1)
      {
        parambv = parambv.field_content.substring(0, i).trim();
        localObject = paramString;
        if (parambv != null)
        {
          localObject = paramString;
          if (parambv.length() > 0) {
            localObject = parambv;
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