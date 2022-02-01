package com.tencent.mm.storagebase;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  static final boolean VIZ;
  
  static
  {
    boolean bool = false;
    AppMethodBeat.i(133325);
    String str;
    int i;
    if ((Build.VERSION.SDK_INT == 28) && (Build.BRAND.equals("samsung")))
    {
      str = Build.HARDWARE.toLowerCase();
      i = -1;
      switch (str.hashCode())
      {
      }
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        bool = true;
      }
      VIZ = bool;
      AppMethodBeat.o(133325);
      return;
      if (str.equals("exynos7884"))
      {
        i = 0;
        continue;
        if (str.equals("exynos7884a"))
        {
          i = 1;
          continue;
          if (str.equals("exynos7884b"))
          {
            i = 2;
            continue;
            if (str.equals("exynos7885"))
            {
              i = 3;
              continue;
              if (str.equals("exynos7904"))
              {
                i = 4;
                continue;
                if (str.equals("exynos7905")) {
                  i = 5;
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storagebase.b
 * JD-Core Version:    0.7.0.1
 */