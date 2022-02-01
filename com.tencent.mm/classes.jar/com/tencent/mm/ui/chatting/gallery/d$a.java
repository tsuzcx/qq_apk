package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

final class d$a
{
  private static HashMap<String, a> Pya;
  private int PxY = 0;
  private int PxZ = 0;
  private long addTime = 0L;
  private int height;
  private int iKP;
  private int width;
  private String zGG = "";
  
  static
  {
    AppMethodBeat.i(36006);
    Pya = new HashMap();
    AppMethodBeat.o(36006);
  }
  
  public static void hf(String paramString, int paramInt)
  {
    AppMethodBeat.i(36004);
    Object localObject;
    try
    {
      boolean bool = Util.isNullOrNil(paramString);
      if ((bool) || (paramInt == 0))
      {
        AppMethodBeat.o(36004);
        return;
      }
      paramString = (a)Pya.get(paramString);
      if (paramString != null) {
        paramString.iKP = paramInt;
      }
      paramString = new HashSet();
      localObject = Pya.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        a locala = (a)Pya.get(str);
        if (locala != null)
        {
          long l = Util.milliSecondsToNow(locala.addTime);
          Log.i("MicroMsg.ImageGalleryHolderImage", "dkprog report: diff:%d [%d,%d,%d] succ:%d change:%d str:%s file:%s", new Object[] { Long.valueOf(l), Integer.valueOf(locala.iKP), Integer.valueOf(locala.width), Integer.valueOf(locala.height), Integer.valueOf(locala.PxY), Integer.valueOf(locala.PxZ), locala.zGG, str });
          if (l >= 60000L)
          {
            if ((locala.iKP > 0) && (!Util.isNullOrNil(locala.zGG))) {
              h.CyF.a(11713, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(41), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(locala.iKP), Integer.valueOf(locala.width), Integer.valueOf(locala.height), Integer.valueOf(locala.PxY), Integer.valueOf(locala.PxZ), locala.zGG });
            }
            paramString.add(str);
          }
        }
      }
      paramString = paramString.iterator();
    }
    catch (Throwable paramString)
    {
      Log.e("MicroMsg.ImageGalleryHolderImage", "get useopt  setTotalLen :%s", new Object[] { Util.stackTraceToString(paramString) });
      AppMethodBeat.o(36004);
      return;
    }
    while (paramString.hasNext())
    {
      localObject = (String)paramString.next();
      Pya.remove(localObject);
    }
    AppMethodBeat.o(36004);
  }
  
  public static void t(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(36005);
    try
    {
      boolean bool = Util.isNullOrNil(paramString);
      if ((bool) || (paramInt1 == 0) || (paramInt2 == 0))
      {
        AppMethodBeat.o(36005);
        return;
      }
      a locala2 = (a)Pya.get(paramString);
      a locala1 = locala2;
      if (locala2 == null)
      {
        locala1 = new a();
        locala1.addTime = Util.nowMilliSecond();
        Pya.put(paramString, locala1);
      }
      locala1.height = paramInt2;
      locala1.width = paramInt1;
      locala1.zGG = (locala1.zGG + paramInt3 + "|");
      if (paramInt3 > 0) {
        if (locala1.PxY == 0) {
          locala1.PxY = paramInt3;
        }
      }
      for (;;)
      {
        Log.i("MicroMsg.ImageGalleryHolderImage", "dkprog addBit: [%d,%d,%d] succ:%d change:%d str:%s file:%s", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(locala1.PxY), Integer.valueOf(locala1.PxZ), locala1.zGG, paramString });
        AppMethodBeat.o(36005);
        return;
        if (locala1.PxY != 0)
        {
          locala1.PxZ += 1;
          locala1.PxY = 0;
        }
      }
      return;
    }
    catch (Throwable paramString)
    {
      Log.e("MicroMsg.ImageGalleryHolderImage", "get useopt  addBit :%s", new Object[] { Util.stackTraceToString(paramString) });
      AppMethodBeat.o(36005);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.d.a
 * JD-Core Version:    0.7.0.1
 */