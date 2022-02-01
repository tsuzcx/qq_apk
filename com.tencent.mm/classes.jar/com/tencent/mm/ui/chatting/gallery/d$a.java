package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

final class d$a
{
  private static HashMap<String, a> IbA;
  private int Ibx = 0;
  private String Iby = "";
  private int Ibz = 0;
  private long cSx = 0L;
  private int height;
  private int hux;
  private int width;
  
  static
  {
    AppMethodBeat.i(36006);
    IbA = new HashMap();
    AppMethodBeat.o(36006);
  }
  
  public static void gg(String paramString, int paramInt)
  {
    AppMethodBeat.i(36004);
    Object localObject;
    try
    {
      boolean bool = bs.isNullOrNil(paramString);
      if ((bool) || (paramInt == 0))
      {
        AppMethodBeat.o(36004);
        return;
      }
      paramString = (a)IbA.get(paramString);
      if (paramString != null) {
        paramString.hux = paramInt;
      }
      paramString = new HashSet();
      localObject = IbA.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        a locala = (a)IbA.get(str);
        if (locala != null)
        {
          long l = bs.Ap(locala.cSx);
          ac.i("MicroMsg.ImageGalleryHolderImage", "dkprog report: diff:%d [%d,%d,%d] succ:%d change:%d str:%s file:%s", new Object[] { Long.valueOf(l), Integer.valueOf(locala.hux), Integer.valueOf(locala.width), Integer.valueOf(locala.height), Integer.valueOf(locala.Ibx), Integer.valueOf(locala.Ibz), locala.Iby, str });
          if (l >= 60000L)
          {
            if ((locala.hux > 0) && (!bs.isNullOrNil(locala.Iby))) {
              h.wUl.f(11713, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(41), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(locala.hux), Integer.valueOf(locala.width), Integer.valueOf(locala.height), Integer.valueOf(locala.Ibx), Integer.valueOf(locala.Ibz), locala.Iby });
            }
            paramString.add(str);
          }
        }
      }
      paramString = paramString.iterator();
    }
    catch (Throwable paramString)
    {
      ac.e("MicroMsg.ImageGalleryHolderImage", "get useopt  setTotalLen :%s", new Object[] { bs.m(paramString) });
      AppMethodBeat.o(36004);
      return;
    }
    while (paramString.hasNext())
    {
      localObject = (String)paramString.next();
      IbA.remove(localObject);
    }
    AppMethodBeat.o(36004);
  }
  
  public static void t(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(36005);
    try
    {
      boolean bool = bs.isNullOrNil(paramString);
      if ((bool) || (paramInt1 == 0) || (paramInt2 == 0))
      {
        AppMethodBeat.o(36005);
        return;
      }
      a locala2 = (a)IbA.get(paramString);
      a locala1 = locala2;
      if (locala2 == null)
      {
        locala1 = new a();
        locala1.cSx = bs.eWj();
        IbA.put(paramString, locala1);
      }
      locala1.height = paramInt2;
      locala1.width = paramInt1;
      locala1.Iby = (locala1.Iby + paramInt3 + "|");
      if (paramInt3 > 0) {
        if (locala1.Ibx == 0) {
          locala1.Ibx = paramInt3;
        }
      }
      for (;;)
      {
        ac.i("MicroMsg.ImageGalleryHolderImage", "dkprog addBit: [%d,%d,%d] succ:%d change:%d str:%s file:%s", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(locala1.Ibx), Integer.valueOf(locala1.Ibz), locala1.Iby, paramString });
        AppMethodBeat.o(36005);
        return;
        if (locala1.Ibx != 0)
        {
          locala1.Ibz += 1;
          locala1.Ibx = 0;
        }
      }
      return;
    }
    catch (Throwable paramString)
    {
      ac.e("MicroMsg.ImageGalleryHolderImage", "get useopt  addBit :%s", new Object[] { bs.m(paramString) });
      AppMethodBeat.o(36005);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.d.a
 * JD-Core Version:    0.7.0.1
 */