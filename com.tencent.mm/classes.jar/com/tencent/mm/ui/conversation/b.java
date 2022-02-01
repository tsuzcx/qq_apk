package com.tencent.mm.ui.conversation;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public final class b
{
  private static final String[] Kse = { "M3X", "M5s", "M5", "MX6", "U10", "U20", "M2 E", "M A5", "DIG-AL00", "DIG-TL10", "NCE-AL00", "NCE-TL10", "MYA-TL10", "MYA-AL10", "NEM-AL10" };
  
  public static boolean fIB()
  {
    AppMethodBeat.i(38272);
    if ((Build.VERSION.SDK_INT == 23) && (Build.MODEL != null))
    {
      String[] arrayOfString = Kse;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        if (arrayOfString[i].equalsIgnoreCase(Build.MODEL))
        {
          ad.i("CompatSupportV27", "for weird crash, %s", new Object[] { Build.MODEL });
          AppMethodBeat.o(38272);
          return true;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(38272);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.b
 * JD-Core Version:    0.7.0.1
 */