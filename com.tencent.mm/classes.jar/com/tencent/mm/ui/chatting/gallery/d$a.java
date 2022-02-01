package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

final class d$a
{
  private static HashMap<String, a> Kmd;
  private int Kma = 0;
  private String Kmb = "";
  private int Kmc = 0;
  private long deP = 0L;
  private int hPI;
  private int height;
  private int width;
  
  static
  {
    AppMethodBeat.i(36006);
    Kmd = new HashMap();
    AppMethodBeat.o(36006);
  }
  
  public static void gM(String paramString, int paramInt)
  {
    AppMethodBeat.i(36004);
    Object localObject;
    try
    {
      boolean bool = bu.isNullOrNil(paramString);
      if ((bool) || (paramInt == 0))
      {
        AppMethodBeat.o(36004);
        return;
      }
      paramString = (a)Kmd.get(paramString);
      if (paramString != null) {
        paramString.hPI = paramInt;
      }
      paramString = new HashSet();
      localObject = Kmd.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        a locala = (a)Kmd.get(str);
        if (locala != null)
        {
          long l = bu.DD(locala.deP);
          ae.i("MicroMsg.ImageGalleryHolderImage", "dkprog report: diff:%d [%d,%d,%d] succ:%d change:%d str:%s file:%s", new Object[] { Long.valueOf(l), Integer.valueOf(locala.hPI), Integer.valueOf(locala.width), Integer.valueOf(locala.height), Integer.valueOf(locala.Kma), Integer.valueOf(locala.Kmc), locala.Kmb, str });
          if (l >= 60000L)
          {
            if ((locala.hPI > 0) && (!bu.isNullOrNil(locala.Kmb))) {
              g.yxI.f(11713, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(41), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(locala.hPI), Integer.valueOf(locala.width), Integer.valueOf(locala.height), Integer.valueOf(locala.Kma), Integer.valueOf(locala.Kmc), locala.Kmb });
            }
            paramString.add(str);
          }
        }
      }
      paramString = paramString.iterator();
    }
    catch (Throwable paramString)
    {
      ae.e("MicroMsg.ImageGalleryHolderImage", "get useopt  setTotalLen :%s", new Object[] { bu.o(paramString) });
      AppMethodBeat.o(36004);
      return;
    }
    while (paramString.hasNext())
    {
      localObject = (String)paramString.next();
      Kmd.remove(localObject);
    }
    AppMethodBeat.o(36004);
  }
  
  public static void t(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(36005);
    try
    {
      boolean bool = bu.isNullOrNil(paramString);
      if ((bool) || (paramInt1 == 0) || (paramInt2 == 0))
      {
        AppMethodBeat.o(36005);
        return;
      }
      a locala2 = (a)Kmd.get(paramString);
      a locala1 = locala2;
      if (locala2 == null)
      {
        locala1 = new a();
        locala1.deP = bu.fpO();
        Kmd.put(paramString, locala1);
      }
      locala1.height = paramInt2;
      locala1.width = paramInt1;
      locala1.Kmb = (locala1.Kmb + paramInt3 + "|");
      if (paramInt3 > 0) {
        if (locala1.Kma == 0) {
          locala1.Kma = paramInt3;
        }
      }
      for (;;)
      {
        ae.i("MicroMsg.ImageGalleryHolderImage", "dkprog addBit: [%d,%d,%d] succ:%d change:%d str:%s file:%s", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(locala1.Kma), Integer.valueOf(locala1.Kmc), locala1.Kmb, paramString });
        AppMethodBeat.o(36005);
        return;
        if (locala1.Kma != 0)
        {
          locala1.Kmc += 1;
          locala1.Kma = 0;
        }
      }
      return;
    }
    catch (Throwable paramString)
    {
      ae.e("MicroMsg.ImageGalleryHolderImage", "get useopt  addBit :%s", new Object[] { bu.o(paramString) });
      AppMethodBeat.o(36005);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.d.a
 * JD-Core Version:    0.7.0.1
 */