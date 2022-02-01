package com.tencent.mm.plugin.ringtone.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ringtone/data/ConstantsRingtone;", "", "()V", "Companion", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a OBW;
  
  static
  {
    AppMethodBeat.i(272988);
    OBW = new a((byte)0);
    AppMethodBeat.o(272988);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ringtone/data/ConstantsRingtone$Companion;", "", "()V", "EXCLUSIVE_LIST_INIT", "", "EXCLUSIVE_LIST_INIT_FROM_CACHE", "EXCLUSIVE_LIST_MORE", "EXCLUSIVE_LIST_NO_MORE", "EXCLUSIVE_LIST_NULL", "EXCLUSIVE_MEMBER_DELETE", "EXCLUSIVE_USER_TYPE", "KV_NAME", "", "RINGTONE_EXCLUSIVE_HAS_BEEN_EDUCATED", "RINGTONE_INIT", "RINGTONE_PLAY", "RINGTONE_RECOMMEND_SCENE", "RINGTONE_SEARCH_SCENE", "RINGTONE_SEARCH_TYPE", "RINGTONE_SETTING_SCENE_FINDER_QUICK", "RINGTONE_SETTING_SCENE_VOIP_QUICK", "RINGTONE_STOP", "SEARCH_RINGTONE_INIT", "SEARCH_RINGTONE_LOADING", "SEARCH_RINGTONE_MORE", "SEARCH_RINGTONE_NULL", "applyScreenProjectionHasBeenEducate", "", "checkExclusiveRingtoneEduShow", "", "getMMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static MultiProcessMMKV aBP()
    {
      AppMethodBeat.i(273041);
      MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("mmkv_ringtone_info");
      s.s(localMultiProcessMMKV, "getMMKV(KV_NAME)");
      AppMethodBeat.o(273041);
      return localMultiProcessMMKV;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ringtone.b.a
 * JD-Core Version:    0.7.0.1
 */