package com.tencent.mm.ui.component;

import android.content.res.Configuration;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(k=3, mv={1, 5, 1}, xi=48)
public final class g$a
{
  public static void a(g paramg, Configuration paramConfiguration)
  {
    AppMethodBeat.i(250287);
    s.u(paramg, "this");
    s.u(paramConfiguration, "newConfig");
    AppMethodBeat.o(250287);
  }
  
  public static void a(g paramg, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(250279);
    s.u(paramg, "this");
    s.u(paramArrayOfString, "permissions");
    s.u(paramArrayOfInt, "grantResults");
    AppMethodBeat.o(250279);
  }
  
  public static boolean a(g paramg, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(250292);
    s.u(paramg, "this");
    s.u(paramKeyEvent, "event");
    AppMethodBeat.o(250292);
    return false;
  }
  
  public static boolean b(g paramg, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(250296);
    s.u(paramg, "this");
    s.u(paramKeyEvent, "event");
    AppMethodBeat.o(250296);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.component.g.a
 * JD-Core Version:    0.7.0.1
 */