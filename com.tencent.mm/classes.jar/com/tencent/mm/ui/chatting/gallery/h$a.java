package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

final class h$a
{
  private static HashMap<String, a> WSz;
  private String FlQ = "";
  private int WSx = 0;
  private int WSy = 0;
  private long addTime = 0L;
  private int height;
  private int lAW;
  private int width;
  
  static
  {
    AppMethodBeat.i(36006);
    WSz = new HashMap();
    AppMethodBeat.o(36006);
  }
  
  public static void hO(String paramString, int paramInt)
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
      paramString = (a)WSz.get(paramString);
      if (paramString != null) {
        paramString.lAW = paramInt;
      }
      paramString = new HashSet();
      localObject = WSz.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        a locala = (a)WSz.get(str);
        if (locala != null)
        {
          long l = Util.milliSecondsToNow(locala.addTime);
          Log.i("MicroMsg.ImageGalleryHolderImage", "dkprog report: diff:%d [%d,%d,%d] succ:%d change:%d str:%s file:%s", new Object[] { Long.valueOf(l), Integer.valueOf(locala.lAW), Integer.valueOf(locala.width), Integer.valueOf(locala.height), Integer.valueOf(locala.WSx), Integer.valueOf(locala.WSy), locala.FlQ, str });
          if (l >= 60000L)
          {
            if ((locala.lAW > 0) && (!Util.isNullOrNil(locala.FlQ))) {
              h.IzE.a(11713, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(41), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(locala.lAW), Integer.valueOf(locala.width), Integer.valueOf(locala.height), Integer.valueOf(locala.WSx), Integer.valueOf(locala.WSy), locala.FlQ });
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
      WSz.remove(localObject);
    }
    AppMethodBeat.o(36004);
  }
  
  public static void x(String paramString, int paramInt1, int paramInt2, int paramInt3)
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
      a locala2 = (a)WSz.get(paramString);
      a locala1 = locala2;
      if (locala2 == null)
      {
        locala1 = new a();
        locala1.addTime = Util.nowMilliSecond();
        WSz.put(paramString, locala1);
      }
      locala1.height = paramInt2;
      locala1.width = paramInt1;
      locala1.FlQ = (locala1.FlQ + paramInt3 + "|");
      if (paramInt3 > 0) {
        if (locala1.WSx == 0) {
          locala1.WSx = paramInt3;
        }
      }
      for (;;)
      {
        Log.i("MicroMsg.ImageGalleryHolderImage", "dkprog addBit: [%d,%d,%d] succ:%d change:%d str:%s file:%s", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(locala1.WSx), Integer.valueOf(locala1.WSy), locala1.FlQ, paramString });
        AppMethodBeat.o(36005);
        return;
        if (locala1.WSx != 0)
        {
          locala1.WSy += 1;
          locala1.WSx = 0;
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
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.h.a
 * JD-Core Version:    0.7.0.1
 */