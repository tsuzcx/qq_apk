package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

final class j$a
{
  private static HashMap<String, a> aeCc;
  private int Fvz = 0;
  private String LhS = "";
  private long addTime = 0L;
  private int aeCb = 0;
  private int height;
  private int osy;
  private int width;
  
  static
  {
    AppMethodBeat.i(36006);
    aeCc = new HashMap();
    AppMethodBeat.o(36006);
  }
  
  public static void iV(String paramString, int paramInt)
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
      paramString = (a)aeCc.get(paramString);
      if (paramString != null) {
        paramString.osy = paramInt;
      }
      paramString = new HashSet();
      localObject = aeCc.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        a locala = (a)aeCc.get(str);
        if (locala != null)
        {
          long l = Util.milliSecondsToNow(locala.addTime);
          Log.i("MicroMsg.ImageGalleryHolderImage", "dkprog report: diff:%d [%d,%d,%d] succ:%d change:%d str:%s file:%s", new Object[] { Long.valueOf(l), Integer.valueOf(locala.osy), Integer.valueOf(locala.width), Integer.valueOf(locala.height), Integer.valueOf(locala.Fvz), Integer.valueOf(locala.aeCb), locala.LhS, str });
          if (l >= 60000L)
          {
            if ((locala.osy > 0) && (!Util.isNullOrNil(locala.LhS))) {
              h.OAn.b(11713, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(41), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(locala.osy), Integer.valueOf(locala.width), Integer.valueOf(locala.height), Integer.valueOf(locala.Fvz), Integer.valueOf(locala.aeCb), locala.LhS });
            }
            paramString.add(str);
          }
        }
      }
      paramString = paramString.iterator();
    }
    finally
    {
      Log.e("MicroMsg.ImageGalleryHolderImage", "get useopt  setTotalLen :%s", new Object[] { Util.stackTraceToString(paramString) });
      AppMethodBeat.o(36004);
      return;
    }
    while (paramString.hasNext())
    {
      localObject = (String)paramString.next();
      aeCc.remove(localObject);
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
      a locala2 = (a)aeCc.get(paramString);
      a locala1 = locala2;
      if (locala2 == null)
      {
        locala1 = new a();
        locala1.addTime = Util.nowMilliSecond();
        aeCc.put(paramString, locala1);
      }
      locala1.height = paramInt2;
      locala1.width = paramInt1;
      locala1.LhS = (locala1.LhS + paramInt3 + "|");
      if (paramInt3 > 0) {
        if (locala1.Fvz == 0) {
          locala1.Fvz = paramInt3;
        }
      }
      for (;;)
      {
        Log.i("MicroMsg.ImageGalleryHolderImage", "dkprog addBit: [%d,%d,%d] succ:%d change:%d str:%s file:%s", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(locala1.Fvz), Integer.valueOf(locala1.aeCb), locala1.LhS, paramString });
        AppMethodBeat.o(36005);
        return;
        if (locala1.Fvz != 0)
        {
          locala1.aeCb += 1;
          locala1.Fvz = 0;
        }
      }
      return;
    }
    finally
    {
      Log.e("MicroMsg.ImageGalleryHolderImage", "get useopt  addBit :%s", new Object[] { Util.stackTraceToString(paramString) });
      AppMethodBeat.o(36005);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.j.a
 * JD-Core Version:    0.7.0.1
 */