package com.tencent.scanlib.a;

import android.hardware.Camera;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.scanlib.a;

final class e
  implements g.a
{
  public static g.a.a hla()
  {
    AppMethodBeat.i(3545);
    g.a.a locala = new g.a.a();
    try
    {
      locala.gII = Camera.open();
      locala.dYT = 0;
      if (locala.gII == null)
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
      localException.dYT = 90;
      localException.gII.setDisplayOrientation(90);
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
        localException.dYT = 90;
        localException.gII.setDisplayOrientation(180);
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
            i = a.cL(localObject[1]);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.scanlib.a.e
 * JD-Core Version:    0.7.0.1
 */