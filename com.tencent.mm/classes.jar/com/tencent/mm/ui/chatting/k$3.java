package com.tencent.mm.ui.chatting;

import android.content.Context;
import com.tencent.mm.ah.m;
import com.tencent.mm.as.d.a;
import com.tencent.mm.as.e;
import com.tencent.mm.as.f;
import com.tencent.mm.as.o;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.a.d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

final class k$3
  implements d.a
{
  k$3(Context paramContext, String paramString1, e parame, String paramString2) {}
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject) {}
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, m paramm) {}
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, String paramString, m paramm)
  {
    if ((paramInt3 == 0) && (paramInt4 == 0)) {}
    for (paramInt2 = 1; (paramObject instanceof HashMap); paramInt2 = 0)
    {
      paramObject = (HashMap)paramObject;
      if (paramObject == null) {
        break;
      }
      paramObject = paramObject.entrySet().iterator();
      while (paramObject.hasNext())
      {
        paramm = (Map.Entry)paramObject.next();
        paramString = (Long)paramm.getKey();
        paramm = (e)paramm.getValue();
        paramm = o.OJ().o(f.c(paramm), "", "");
        if (paramInt2 != 0)
        {
          au.Hx();
          c.Fy().fe(paramString.longValue());
          com.tencent.mm.plugin.messenger.a.g.bhI().a(this.val$context, this.egy, paramm, paramInt1, this.epf.enA, this.eot);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.k.3
 * JD-Core Version:    0.7.0.1
 */