package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class WeChatPermissions
{
  public static final String PERMISSION_MATRIX_STRATEGYNOTIFY()
  {
    AppMethodBeat.i(200977);
    String str = MMApplicationContext.getApplicationId() + ".matrix.strategynotify";
    AppMethodBeat.o(200977);
    return str;
  }
  
  public static final String PERMISSION_MM_MESSAGE()
  {
    AppMethodBeat.i(200975);
    String str = MMApplicationContext.getApplicationId() + ".permission.MM_MESSAGE";
    AppMethodBeat.o(200975);
    return str;
  }
  
  public static final String PERMISSION_WEAR_MESSAGE()
  {
    AppMethodBeat.i(200976);
    String str = MMApplicationContext.getApplicationId() + ".wear.message";
    AppMethodBeat.o(200976);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.WeChatPermissions
 * JD-Core Version:    0.7.0.1
 */