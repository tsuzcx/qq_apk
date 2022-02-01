package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class WeChatPermissions
{
  public static final String PERMISSION_MATRIX_STRATEGYNOTIFY()
  {
    AppMethodBeat.i(249290);
    String str = MMApplicationContext.getApplicationId() + ".matrix.strategynotify";
    AppMethodBeat.o(249290);
    return str;
  }
  
  public static final String PERMISSION_MM_MESSAGE()
  {
    AppMethodBeat.i(249288);
    String str = MMApplicationContext.getApplicationId() + ".permission.MM_MESSAGE";
    AppMethodBeat.o(249288);
    return str;
  }
  
  public static final String PERMISSION_WEAR_MESSAGE()
  {
    AppMethodBeat.i(249289);
    String str = MMApplicationContext.getApplicationId() + ".wear.message";
    AppMethodBeat.o(249289);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.WeChatPermissions
 * JD-Core Version:    0.7.0.1
 */