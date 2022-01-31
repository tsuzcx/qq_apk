package com.tencent.mm.ui.chatting.gallery;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

final class e$a
{
  private static HashMap<String, a> vvm = new HashMap();
  private int ebK;
  private int height;
  private long ugr = 0L;
  private int vvj = 0;
  private String vvk = "";
  private int vvl = 0;
  private int width;
  
  public static void dI(String paramString, int paramInt)
  {
    Object localObject;
    try
    {
      if (bk.bl(paramString)) {
        return;
      }
      if (paramInt == 0) {
        return;
      }
      paramString = (a)vvm.get(paramString);
      if (paramString != null) {
        paramString.ebK = paramInt;
      }
      paramString = new HashSet();
      localObject = vvm.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        a locala = (a)vvm.get(str);
        if (locala != null)
        {
          long l = bk.co(locala.ugr);
          y.i("MicroMsg.ImageGalleryHolderImage", "dkprog report: diff:%d [%d,%d,%d] succ:%d change:%d str:%s file:%s", new Object[] { Long.valueOf(l), Integer.valueOf(locala.ebK), Integer.valueOf(locala.width), Integer.valueOf(locala.height), Integer.valueOf(locala.vvj), Integer.valueOf(locala.vvl), locala.vvk, str });
          if (l >= 60000L)
          {
            if ((locala.ebK > 0) && (!bk.bl(locala.vvk))) {
              h.nFQ.f(11713, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(41), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(locala.ebK), Integer.valueOf(locala.width), Integer.valueOf(locala.height), Integer.valueOf(locala.vvj), Integer.valueOf(locala.vvl), locala.vvk });
            }
            paramString.add(str);
          }
        }
      }
      paramString = paramString.iterator();
    }
    catch (Throwable paramString)
    {
      y.e("MicroMsg.ImageGalleryHolderImage", "get useopt  setTotalLen :%s", new Object[] { bk.j(paramString) });
      return;
    }
    while (paramString.hasNext())
    {
      localObject = (String)paramString.next();
      vvm.remove(localObject);
    }
  }
  
  public static void n(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    for (;;)
    {
      a locala1;
      try
      {
        if ((bk.bl(paramString)) || (paramInt1 == 0)) {
          break;
        }
        if (paramInt2 == 0) {
          return;
        }
        a locala2 = (a)vvm.get(paramString);
        locala1 = locala2;
        if (locala2 == null)
        {
          locala1 = new a();
          locala1.ugr = bk.UY();
          vvm.put(paramString, locala1);
        }
        locala1.height = paramInt2;
        locala1.width = paramInt1;
        locala1.vvk = (locala1.vvk + paramInt3 + "|");
        if (paramInt3 > 0)
        {
          if (locala1.vvj == 0) {
            locala1.vvj = paramInt3;
          }
          y.i("MicroMsg.ImageGalleryHolderImage", "dkprog addBit: [%d,%d,%d] succ:%d change:%d str:%s file:%s", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(locala1.vvj), Integer.valueOf(locala1.vvl), locala1.vvk, paramString });
          return;
        }
      }
      catch (Throwable paramString)
      {
        y.e("MicroMsg.ImageGalleryHolderImage", "get useopt  addBit :%s", new Object[] { bk.j(paramString) });
        return;
      }
      if (locala1.vvj != 0)
      {
        locala1.vvl += 1;
        locala1.vvj = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.e.a
 * JD-Core Version:    0.7.0.1
 */