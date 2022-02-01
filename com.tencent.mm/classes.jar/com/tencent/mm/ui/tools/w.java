package com.tencent.mm.ui.tools;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.f;
import com.tencent.mm.ci.a;

public final class w
{
  public static int bj(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(177648);
    if (Float.compare(a.ez(paramContext), a.kd(paramContext)) > 0)
    {
      if (paramInt < 10)
      {
        paramInt = a.f.unread_count_shape_large_circle;
        AppMethodBeat.o(177648);
        return paramInt;
      }
      paramInt = a.f.unread_count_shape_large;
      AppMethodBeat.o(177648);
      return paramInt;
    }
    if (paramInt < 10)
    {
      paramInt = a.f.unread_count_shape_circle;
      AppMethodBeat.o(177648);
      return paramInt;
    }
    paramInt = a.f.unread_count_shape;
    AppMethodBeat.o(177648);
    return paramInt;
  }
  
  public static int lE(Context paramContext)
  {
    AppMethodBeat.i(143282);
    float f = a.ez(paramContext);
    if (Float.compare(f, a.kd(paramContext)) > 0)
    {
      i = a.f.unread_count_shape_large;
      AppMethodBeat.o(143282);
      return i;
    }
    if (Float.compare(f, a.kb(paramContext)) > 0)
    {
      i = a.f.unread_count_shape_middle;
      AppMethodBeat.o(143282);
      return i;
    }
    int i = a.f.unread_count_shape;
    AppMethodBeat.o(143282);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.tools.w
 * JD-Core Version:    0.7.0.1
 */