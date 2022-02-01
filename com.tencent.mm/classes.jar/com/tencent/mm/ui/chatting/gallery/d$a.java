package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

final class d$a
{
  private static HashMap<String, a> JQS;
  private int JQP = 0;
  private String JQQ = "";
  private int JQR = 0;
  private long ddN = 0L;
  private int hMP;
  private int height;
  private int width;
  
  static
  {
    AppMethodBeat.i(36006);
    JQS = new HashMap();
    AppMethodBeat.o(36006);
  }
  
  public static void gD(String paramString, int paramInt)
  {
    AppMethodBeat.i(36004);
    Object localObject;
    try
    {
      boolean bool = bt.isNullOrNil(paramString);
      if ((bool) || (paramInt == 0))
      {
        AppMethodBeat.o(36004);
        return;
      }
      paramString = (a)JQS.get(paramString);
      if (paramString != null) {
        paramString.hMP = paramInt;
      }
      paramString = new HashSet();
      localObject = JQS.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        a locala = (a)JQS.get(str);
        if (locala != null)
        {
          long l = bt.Df(locala.ddN);
          ad.i("MicroMsg.ImageGalleryHolderImage", "dkprog report: diff:%d [%d,%d,%d] succ:%d change:%d str:%s file:%s", new Object[] { Long.valueOf(l), Integer.valueOf(locala.hMP), Integer.valueOf(locala.width), Integer.valueOf(locala.height), Integer.valueOf(locala.JQP), Integer.valueOf(locala.JQR), locala.JQQ, str });
          if (l >= 60000L)
          {
            if ((locala.hMP > 0) && (!bt.isNullOrNil(locala.JQQ))) {
              g.yhR.f(11713, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(41), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(locala.hMP), Integer.valueOf(locala.width), Integer.valueOf(locala.height), Integer.valueOf(locala.JQP), Integer.valueOf(locala.JQR), locala.JQQ });
            }
            paramString.add(str);
          }
        }
      }
      paramString = paramString.iterator();
    }
    catch (Throwable paramString)
    {
      ad.e("MicroMsg.ImageGalleryHolderImage", "get useopt  setTotalLen :%s", new Object[] { bt.n(paramString) });
      AppMethodBeat.o(36004);
      return;
    }
    while (paramString.hasNext())
    {
      localObject = (String)paramString.next();
      JQS.remove(localObject);
    }
    AppMethodBeat.o(36004);
  }
  
  public static void t(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(36005);
    try
    {
      boolean bool = bt.isNullOrNil(paramString);
      if ((bool) || (paramInt1 == 0) || (paramInt2 == 0))
      {
        AppMethodBeat.o(36005);
        return;
      }
      a locala2 = (a)JQS.get(paramString);
      a locala1 = locala2;
      if (locala2 == null)
      {
        locala1 = new a();
        locala1.ddN = bt.flT();
        JQS.put(paramString, locala1);
      }
      locala1.height = paramInt2;
      locala1.width = paramInt1;
      locala1.JQQ = (locala1.JQQ + paramInt3 + "|");
      if (paramInt3 > 0) {
        if (locala1.JQP == 0) {
          locala1.JQP = paramInt3;
        }
      }
      for (;;)
      {
        ad.i("MicroMsg.ImageGalleryHolderImage", "dkprog addBit: [%d,%d,%d] succ:%d change:%d str:%s file:%s", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(locala1.JQP), Integer.valueOf(locala1.JQR), locala1.JQQ, paramString });
        AppMethodBeat.o(36005);
        return;
        if (locala1.JQP != 0)
        {
          locala1.JQR += 1;
          locala1.JQP = 0;
        }
      }
      return;
    }
    catch (Throwable paramString)
    {
      ad.e("MicroMsg.ImageGalleryHolderImage", "get useopt  addBit :%s", new Object[] { bt.n(paramString) });
      AppMethodBeat.o(36005);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.d.a
 * JD-Core Version:    0.7.0.1
 */