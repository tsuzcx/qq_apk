package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

final class d$a
{
  private static HashMap<String, a> GBF;
  private int GBC = 0;
  private String GBD = "";
  private int GBE = 0;
  private long cVb = 0L;
  private int gTY;
  private int height;
  private int width;
  
  static
  {
    AppMethodBeat.i(36006);
    GBF = new HashMap();
    AppMethodBeat.o(36006);
  }
  
  public static void gc(String paramString, int paramInt)
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
      paramString = (a)GBF.get(paramString);
      if (paramString != null) {
        paramString.gTY = paramInt;
      }
      paramString = new HashSet();
      localObject = GBF.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        a locala = (a)GBF.get(str);
        if (locala != null)
        {
          long l = bt.vM(locala.cVb);
          ad.i("MicroMsg.ImageGalleryHolderImage", "dkprog report: diff:%d [%d,%d,%d] succ:%d change:%d str:%s file:%s", new Object[] { Long.valueOf(l), Integer.valueOf(locala.gTY), Integer.valueOf(locala.width), Integer.valueOf(locala.height), Integer.valueOf(locala.GBC), Integer.valueOf(locala.GBE), locala.GBD, str });
          if (l >= 60000L)
          {
            if ((locala.gTY > 0) && (!bt.isNullOrNil(locala.GBD))) {
              h.vKh.f(11713, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(41), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(locala.gTY), Integer.valueOf(locala.width), Integer.valueOf(locala.height), Integer.valueOf(locala.GBC), Integer.valueOf(locala.GBE), locala.GBD });
            }
            paramString.add(str);
          }
        }
      }
      paramString = paramString.iterator();
    }
    catch (Throwable paramString)
    {
      ad.e("MicroMsg.ImageGalleryHolderImage", "get useopt  setTotalLen :%s", new Object[] { bt.m(paramString) });
      AppMethodBeat.o(36004);
      return;
    }
    while (paramString.hasNext())
    {
      localObject = (String)paramString.next();
      GBF.remove(localObject);
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
      a locala2 = (a)GBF.get(paramString);
      a locala1 = locala2;
      if (locala2 == null)
      {
        locala1 = new a();
        locala1.cVb = bt.eGO();
        GBF.put(paramString, locala1);
      }
      locala1.height = paramInt2;
      locala1.width = paramInt1;
      locala1.GBD = (locala1.GBD + paramInt3 + "|");
      if (paramInt3 > 0) {
        if (locala1.GBC == 0) {
          locala1.GBC = paramInt3;
        }
      }
      for (;;)
      {
        ad.i("MicroMsg.ImageGalleryHolderImage", "dkprog addBit: [%d,%d,%d] succ:%d change:%d str:%s file:%s", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(locala1.GBC), Integer.valueOf(locala1.GBE), locala1.GBD, paramString });
        AppMethodBeat.o(36005);
        return;
        if (locala1.GBC != 0)
        {
          locala1.GBE += 1;
          locala1.GBC = 0;
        }
      }
      return;
    }
    catch (Throwable paramString)
    {
      ad.e("MicroMsg.ImageGalleryHolderImage", "get useopt  addBit :%s", new Object[] { bt.m(paramString) });
      AppMethodBeat.o(36005);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.d.a
 * JD-Core Version:    0.7.0.1
 */