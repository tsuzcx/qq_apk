package com.tencent.mm.plugin.wepkg;

import com.tencent.mm.plugin.wepkg.event.DownloadBigPkgSuccessNotify;
import com.tencent.mm.plugin.wepkg.event.ReloadNotify;

final class a$1
  implements com.tencent.mm.plugin.wepkg.event.a
{
  public final void bI(Object paramObject)
  {
    if ((paramObject instanceof DownloadBigPkgSuccessNotify))
    {
      paramObject = (DownloadBigPkgSuccessNotify)paramObject;
      if ((paramObject != null) && (paramObject.dCD != null) && (paramObject.dCD.equals(a.cjz())) && (b.cjF() == 0)) {
        a.mT();
      }
    }
    for (;;)
    {
      return;
      if ((paramObject instanceof ReloadNotify))
      {
        paramObject = (ReloadNotify)paramObject;
        if ((paramObject == null) || (paramObject.rOS == null) || (paramObject.rOS.length <= 0)) {
          break;
        }
        paramObject = paramObject.rOS;
        int j = paramObject.length;
        int i = 0;
        while (i < j)
        {
          if (paramObject[i].equals(a.cjz()))
          {
            a.cjD();
            return;
          }
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.a.1
 * JD-Core Version:    0.7.0.1
 */