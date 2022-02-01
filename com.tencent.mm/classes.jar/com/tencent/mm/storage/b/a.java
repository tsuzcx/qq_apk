package com.tencent.mm.storage.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/storage/fold/FoldConfig;", "", "()V", "MMKV_FOLD_CONFIG_KEY", "", "MMKV_FOLD_CONFIG_NAME", "isCollapseStatus", "", "()Z", "isExpandStatus", "isExistFoldBtn", "setFoldBtnStatus", "", "foldBtnStatus", "", "plugin-messenger-foundation_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a admS;
  
  static
  {
    AppMethodBeat.i(248944);
    admS = new a();
    AppMethodBeat.o(248944);
  }
  
  public static void azk(int paramInt)
  {
    AppMethodBeat.i(248937);
    MultiProcessMMKV.getSingleMMKV("message_fold_config2").encode("fold_button_status_int_sync", paramInt);
    AppMethodBeat.o(248937);
  }
  
  public static boolean jdN()
  {
    AppMethodBeat.i(248933);
    if (MultiProcessMMKV.getSingleMMKV("message_fold_config2").decodeInt("fold_button_status_int_sync", 65536) == 131072)
    {
      AppMethodBeat.o(248933);
      return true;
    }
    AppMethodBeat.o(248933);
    return false;
  }
  
  public static boolean jdO()
  {
    AppMethodBeat.i(248936);
    int i = MultiProcessMMKV.getSingleMMKV("message_fold_config2").decodeInt("fold_button_status_int_sync", 65536);
    if ((i == 262144) || (i == 65536))
    {
      AppMethodBeat.o(248936);
      return true;
    }
    AppMethodBeat.o(248936);
    return false;
  }
  
  public static boolean jdP()
  {
    AppMethodBeat.i(248940);
    if (MultiProcessMMKV.getMMKV("message_fold_config2").decodeInt("fold_button_status_int_sync", 65536) != 65536)
    {
      AppMethodBeat.o(248940);
      return true;
    }
    AppMethodBeat.o(248940);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.b.a
 * JD-Core Version:    0.7.0.1
 */