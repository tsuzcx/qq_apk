package com.tencent.mm.search;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.h.d;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/search/EmojiSearchConstant;", "", "()V", "KEY_NET_PARAM", "", "KEY_USERNAME", "SOS_SEARCH_UI_REQUEST_CODE", "", "TAG", "getEmojiSearchSwitch", "", "getHideVKBDelayTime", "", "plugin-emojisdk_release"})
public final class a
{
  public static final a UWI;
  
  static
  {
    AppMethodBeat.i(226264);
    UWI = new a();
    AppMethodBeat.o(226264);
  }
  
  public static long htm()
  {
    AppMethodBeat.i(226261);
    long l = Util.getLong(d.dgX().a("clicfg_emoji_search_hide_keyboard_delay_time", "30000", false, true), 5000L);
    AppMethodBeat.o(226261);
    return l;
  }
  
  public static final boolean htn()
  {
    AppMethodBeat.i(226262);
    if (Util.getInt(d.dgX().a("clicfg_emoji_search_switch", "1", false, true), 1) > 0)
    {
      AppMethodBeat.o(226262);
      return true;
    }
    AppMethodBeat.o(226262);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.search.a
 * JD-Core Version:    0.7.0.1
 */