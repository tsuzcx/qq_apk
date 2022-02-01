package com.tencent.mm.search;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.e.d;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/search/EmojiSearchConstant;", "", "()V", "KEY_EMOJI_INFO_RESULT", "", "KEY_GET_EMOJI_INFO_DIRECTLY", "KEY_NET_PARAM", "KEY_USERNAME", "SOS_SEARCH_UI_REQUEST_CODE", "", "TAG", "getEmojiSearchSwitch", "", "getHideVKBDelayTime", "", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a acrT;
  
  static
  {
    AppMethodBeat.i(236849);
    acrT = new a();
    AppMethodBeat.o(236849);
  }
  
  public static long iTs()
  {
    AppMethodBeat.i(236846);
    long l = Util.getLong(d.dNI().a("clicfg_emoji_search_hide_keyboard_delay_time", "30000", false, true), 5000L);
    AppMethodBeat.o(236846);
    return l;
  }
  
  public static final boolean iTt()
  {
    AppMethodBeat.i(236848);
    if (Util.getInt(d.dNI().a("clicfg_emoji_search_switch", "1", false, true), 1) > 0)
    {
      AppMethodBeat.o(236848);
      return true;
    }
    AppMethodBeat.o(236848);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.search.a
 * JD-Core Version:    0.7.0.1
 */