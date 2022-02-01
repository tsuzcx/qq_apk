package com.tencent.mm.search;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.h.d;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/search/EmojiSearchConstant;", "", "()V", "KEY_NET_PARAM", "", "KEY_USERNAME", "SOS_SEARCH_UI_REQUEST_CODE", "", "TAG", "getEmojiSearchSwitch", "", "getHideVKBDelayTime", "", "plugin-emojisdk_release"})
public final class a
{
  public static final a NJh;
  
  static
  {
    AppMethodBeat.i(200079);
    NJh = new a();
    AppMethodBeat.o(200079);
  }
  
  public static long gxo()
  {
    AppMethodBeat.i(200077);
    long l = Util.getLong(d.cRY().b("clicfg_emoji_search_hide_keyboard_delay_time", "30000", false, true), 5000L);
    AppMethodBeat.o(200077);
    return l;
  }
  
  public static final boolean gxp()
  {
    AppMethodBeat.i(200078);
    if (Util.getInt(d.cRY().b("clicfg_emoji_search_switch", "1", false, true), 1) > 0)
    {
      AppMethodBeat.o(200078);
      return true;
    }
    AppMethodBeat.o(200078);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.search.a
 * JD-Core Version:    0.7.0.1
 */