package com.tencent.mm.plugin.wear.model.f;

import android.content.Context;
import com.tencent.mm.R.l;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.protocal.c.cjs;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.bi;

public abstract class b
  extends c
{
  protected static String b(String paramString, bi parambi)
  {
    if (s.fn(paramString))
    {
      paramString = c(paramString, parambi);
      return String.format(ae.getContext().getString(R.l.notification_msg_chatroom_template), new Object[] { h.Rj(paramString), Character.valueOf('​'), h.aa(parambi).kVs });
    }
    return String.format(ae.getContext().getString(R.l.notification_msg_single_template), new Object[] { h.aa(parambi).kVs });
  }
  
  protected static String c(String paramString, bi parambi)
  {
    Object localObject = paramString;
    if (s.fn(paramString))
    {
      int i = bd.iH(parambi.field_content);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.f.b
 * JD-Core Version:    0.7.0.1
 */