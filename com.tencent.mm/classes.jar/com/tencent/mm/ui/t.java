package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/LiveExptConfig;", "", "()V", "TAG", "", "getChatListShowFlashingSwitch", "", "getChatRoomBarFlashingSwitch", "getChatRoomCardFlashingSwitch", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class t
{
  public static final t adCS;
  
  static
  {
    AppMethodBeat.i(249195);
    adCS = new t();
    AppMethodBeat.o(249195);
  }
  
  public static boolean jjA()
  {
    AppMethodBeat.i(249188);
    boolean bool = ((c)h.ax(c.class)).a(c.a.zqx, false);
    Log.i("MicroMsg.LiveExptConfig", s.X("ChatListShowFlashingSwitch: ", Boolean.valueOf(bool)));
    AppMethodBeat.o(249188);
    return bool;
  }
  
  public static boolean jjy()
  {
    AppMethodBeat.i(249182);
    boolean bool = ((c)h.ax(c.class)).a(c.a.zqv, false);
    Log.i("MicroMsg.LiveExptConfig", s.X("ChatRoomBarFlashingSwitch: ", Boolean.valueOf(bool)));
    AppMethodBeat.o(249182);
    return bool;
  }
  
  public static boolean jjz()
  {
    AppMethodBeat.i(249184);
    boolean bool = ((c)h.ax(c.class)).a(c.a.zqw, false);
    Log.i("MicroMsg.LiveExptConfig", s.X("ChatRoomCardFlashingSwitch: ", Boolean.valueOf(bool)));
    AppMethodBeat.o(249184);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.t
 * JD-Core Version:    0.7.0.1
 */