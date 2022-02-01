package io.clipworks.displaysys;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class DSDisplaySys
{
  public static float getMainScreenScaleFactor()
  {
    AppMethodBeat.i(189511);
    float f = Resources.getSystem().getDisplayMetrics().density;
    AppMethodBeat.o(189511);
    return f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     io.clipworks.displaysys.DSDisplaySys
 * JD-Core Version:    0.7.0.1
 */