package com.tencent.mm.plugin.welab.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.welab.e.b;
import com.tencent.mm.plugin.welab.ui.WelabMainUI;

public final class c
  implements com.tencent.mm.plugin.welab.a.a.c
{
  public final void D(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(80572);
    paramIntent.setClass(paramContext, WelabMainUI.class);
    if ((dho()) || (dhp())) {}
    for (int i = 1;; i = 0)
    {
      paramIntent.putExtra("para_from_with_red_point", i);
      paramContext.startActivity(paramIntent);
      AppMethodBeat.o(80572);
      return;
    }
  }
  
  public final boolean dho()
  {
    AppMethodBeat.i(80573);
    b.dhC();
    if ((b.dhF()) && (!dhp()))
    {
      AppMethodBeat.o(80573);
      return true;
    }
    AppMethodBeat.o(80573);
    return false;
  }
  
  public final boolean dhp()
  {
    AppMethodBeat.i(80574);
    b.dhC();
    if (!b.dhG())
    {
      b.dhC();
      if (b.dhF())
      {
        AppMethodBeat.o(80574);
        return true;
      }
    }
    AppMethodBeat.o(80574);
    return false;
  }
  
  public final boolean dhq()
  {
    AppMethodBeat.i(80575);
    if (!dhp())
    {
      AppMethodBeat.o(80575);
      return true;
    }
    AppMethodBeat.o(80575);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.a.c
 * JD-Core Version:    0.7.0.1
 */