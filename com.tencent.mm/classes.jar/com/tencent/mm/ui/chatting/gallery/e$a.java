package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

final class e$a
{
  private static HashMap<String, a> zLn;
  private long cgd = 0L;
  private int fsd;
  private int height;
  private int width;
  private int zLk = 0;
  private String zLl = "";
  private int zLm = 0;
  
  static
  {
    AppMethodBeat.i(32091);
    zLn = new HashMap();
    AppMethodBeat.o(32091);
  }
  
  public static void eS(String paramString, int paramInt)
  {
    AppMethodBeat.i(32089);
    Object localObject;
    try
    {
      boolean bool = bo.isNullOrNil(paramString);
      if ((bool) || (paramInt == 0))
      {
        AppMethodBeat.o(32089);
        return;
      }
      paramString = (a)zLn.get(paramString);
      if (paramString != null) {
        paramString.fsd = paramInt;
      }
      paramString = new HashSet();
      localObject = zLn.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        a locala = (a)zLn.get(str);
        if (locala != null)
        {
          long l = bo.hl(locala.cgd);
          ab.i("MicroMsg.ImageGalleryHolderImage", "dkprog report: diff:%d [%d,%d,%d] succ:%d change:%d str:%s file:%s", new Object[] { Long.valueOf(l), Integer.valueOf(locala.fsd), Integer.valueOf(locala.width), Integer.valueOf(locala.height), Integer.valueOf(locala.zLk), Integer.valueOf(locala.zLm), locala.zLl, str });
          if (l >= 60000L)
          {
            if ((locala.fsd > 0) && (!bo.isNullOrNil(locala.zLl))) {
              h.qsU.e(11713, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(41), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(locala.fsd), Integer.valueOf(locala.width), Integer.valueOf(locala.height), Integer.valueOf(locala.zLk), Integer.valueOf(locala.zLm), locala.zLl });
            }
            paramString.add(str);
          }
        }
      }
      paramString = paramString.iterator();
    }
    catch (Throwable paramString)
    {
      ab.e("MicroMsg.ImageGalleryHolderImage", "get useopt  setTotalLen :%s", new Object[] { bo.l(paramString) });
      AppMethodBeat.o(32089);
      return;
    }
    while (paramString.hasNext())
    {
      localObject = (String)paramString.next();
      zLn.remove(localObject);
    }
    AppMethodBeat.o(32089);
  }
  
  public static void q(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(32090);
    try
    {
      boolean bool = bo.isNullOrNil(paramString);
      if ((bool) || (paramInt1 == 0) || (paramInt2 == 0))
      {
        AppMethodBeat.o(32090);
        return;
      }
      a locala2 = (a)zLn.get(paramString);
      a locala1 = locala2;
      if (locala2 == null)
      {
        locala1 = new a();
        locala1.cgd = bo.aoy();
        zLn.put(paramString, locala1);
      }
      locala1.height = paramInt2;
      locala1.width = paramInt1;
      locala1.zLl = (locala1.zLl + paramInt3 + "|");
      if (paramInt3 > 0) {
        if (locala1.zLk == 0) {
          locala1.zLk = paramInt3;
        }
      }
      for (;;)
      {
        ab.i("MicroMsg.ImageGalleryHolderImage", "dkprog addBit: [%d,%d,%d] succ:%d change:%d str:%s file:%s", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(locala1.zLk), Integer.valueOf(locala1.zLm), locala1.zLl, paramString });
        AppMethodBeat.o(32090);
        return;
        if (locala1.zLk != 0)
        {
          locala1.zLm += 1;
          locala1.zLk = 0;
        }
      }
      return;
    }
    catch (Throwable paramString)
    {
      ab.e("MicroMsg.ImageGalleryHolderImage", "get useopt  addBit :%s", new Object[] { bo.l(paramString) });
      AppMethodBeat.o(32090);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.e.a
 * JD-Core Version:    0.7.0.1
 */