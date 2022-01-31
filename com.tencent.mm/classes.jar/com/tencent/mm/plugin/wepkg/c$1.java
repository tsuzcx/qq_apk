package com.tencent.mm.plugin.wepkg;

import com.tencent.mm.plugin.wepkg.event.ReloadNotify;
import com.tencent.mm.sdk.platformtools.bk;

final class c$1
  implements com.tencent.mm.plugin.wepkg.event.a
{
  c$1(c paramc) {}
  
  public final void bI(Object paramObject)
  {
    int j;
    int i;
    if ((paramObject instanceof ReloadNotify))
    {
      paramObject = (ReloadNotify)paramObject;
      if ((paramObject != null) && (paramObject.rOS != null) && (paramObject.rOS.length > 0))
      {
        paramObject = paramObject.rOS;
        j = paramObject.length;
        i = 0;
      }
    }
    for (;;)
    {
      if (i < j)
      {
        Object localObject = paramObject[i];
        if ((localObject.equals(a.cjz())) || ((!bk.bl(c.a(this.rNZ))) && (localObject.equals(c.a(this.rNZ))))) {
          c.b(this.rNZ);
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.c.1
 * JD-Core Version:    0.7.0.1
 */