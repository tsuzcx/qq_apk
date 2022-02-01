package com.tencent.mm.plugin.wear.model.f;

import android.content.Context;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.br;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.protocal.protobuf.gge;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;

public abstract class b
  extends c
{
  protected static String c(String paramString, cc paramcc)
  {
    if (au.bwE(paramString))
    {
      paramString = d(paramString, paramcc);
      return String.format(MMApplicationContext.getContext().getString(R.l.gPG), new Object[] { h.bhE(paramString), Character.valueOf('​'), h.bv(paramcc).nUB });
    }
    return String.format(MMApplicationContext.getContext().getString(R.l.gPH), new Object[] { h.bv(paramcc).nUB });
  }
  
  protected static String d(String paramString, cc paramcc)
  {
    Object localObject = paramString;
    if (au.bwE(paramString))
    {
      int i = br.JG(paramcc.field_content);
      localObject = paramString;
      if (i != -1)
      {
        paramcc = paramcc.field_content.substring(0, i).trim();
        localObject = paramString;
        if (paramcc != null)
        {
          localObject = paramString;
          if (paramcc.length() > 0) {
            localObject = paramcc;
          }
        }
      }
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.f.b
 * JD-Core Version:    0.7.0.1
 */