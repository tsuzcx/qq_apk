package com.tencent.mm.wexnet;

import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/wexnet/XNetLibResDebugger;", "", "()V", "KEY_WANT_MARK_RES_RETRY", "", "setUsingDebugSo", "", "debug", "", "usingDebugSo", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final d agWm;
  
  static
  {
    AppMethodBeat.i(231549);
    agWm = new d();
    AppMethodBeat.o(231549);
  }
  
  public static void On(boolean paramBoolean)
  {
    AppMethodBeat.i(231538);
    MultiProcessMMKV.getDefault().putBoolean("xnet_using_debug_so", paramBoolean).commit();
    AppMethodBeat.o(231538);
  }
  
  public static boolean jPO()
  {
    AppMethodBeat.i(231542);
    boolean bool = MultiProcessMMKV.getDefault().getBoolean("xnet_using_debug_so", false);
    AppMethodBeat.o(231542);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.wexnet.d
 * JD-Core Version:    0.7.0.1
 */