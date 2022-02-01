package com.tencent.scanlib.a;

import android.hardware.Camera;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.scanlib.a;

final class e
  implements g.a
{
  public static g.a.a fmI()
  {
    AppMethodBeat.i(3545);
    g.a.a locala = new g.a.a();
    try
    {
      locala.fDV = Camera.open();
      locala.dwp = 0;
      if (locala.fDV == null)
      {
        AppMethodBeat.o(3545);
        return null;
      }
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(3545);
      return null;
    }
    if (Build.DISPLAY.startsWith("Flyme"))
    {
      localException.dwp = 90;
      localException.fDV.setDisplayOrientation(90);
    }
    label176:
    for (;;)
    {
      AppMethodBeat.o(3545);
      return localException;
      int i;
      if (!Build.MODEL.equals("M9")) {
        i = -1;
      }
      for (;;)
      {
        if (i < 7093) {
          break label176;
        }
        localException.dwp = 90;
        localException.fDV.setDisplayOrientation(180);
        break;
        Object localObject = Build.DISPLAY;
        if (((String)localObject).substring(0, 0).equals("1"))
        {
          i = -1;
        }
        else
        {
          localObject = ((String)localObject).split("-");
          if ((localObject == null) || (localObject.length < 2)) {
            i = -1;
          } else {
            i = a.ep(localObject[1]);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.scanlib.a.e
 * JD-Core Version:    0.7.0.1
 */