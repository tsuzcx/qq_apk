package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/LiveExptConfig;", "", "()V", "TAG", "", "getChatListShowFlashingSwitch", "", "getChatRoomBarFlashingSwitch", "getChatRoomCardFlashingSwitch", "app_release"})
public final class r
{
  public static final r VYx;
  
  static
  {
    AppMethodBeat.i(274985);
    VYx = new r();
    AppMethodBeat.o(274985);
  }
  
  public static boolean hHn()
  {
    AppMethodBeat.i(274982);
    boolean bool = ((b)h.ae(b.class)).a(b.a.vXG, false);
    Log.i("MicroMsg.LiveExptConfig", "ChatRoomBarFlashingSwitch: ".concat(String.valueOf(bool)));
    AppMethodBeat.o(274982);
    return bool;
  }
  
  public static boolean hHo()
  {
    AppMethodBeat.i(274983);
    boolean bool = ((b)h.ae(b.class)).a(b.a.vXH, false);
    Log.i("MicroMsg.LiveExptConfig", "ChatRoomCardFlashingSwitch: ".concat(String.valueOf(bool)));
    AppMethodBeat.o(274983);
    return bool;
  }
  
  public static boolean hHp()
  {
    AppMethodBeat.i(274984);
    boolean bool = ((b)h.ae(b.class)).a(b.a.vXI, false);
    Log.i("MicroMsg.LiveExptConfig", "ChatListShowFlashingSwitch: ".concat(String.valueOf(bool)));
    AppMethodBeat.o(274984);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.r
 * JD-Core Version:    0.7.0.1
 */