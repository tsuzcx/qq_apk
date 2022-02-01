package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class WeChatPermissions
{
  public static final String PERMISSION_MATRIX_STRATEGYNOTIFY()
  {
    AppMethodBeat.i(243698);
    String str = MMApplicationContext.getApplicationId() + ".matrix.strategynotify";
    AppMethodBeat.o(243698);
    return str;
  }
  
  public static final String PERMISSION_MM_MESSAGE()
  {
    AppMethodBeat.i(243689);
    String str = MMApplicationContext.getApplicationId() + ".permission.MM_MESSAGE";
    AppMethodBeat.o(243689);
    return str;
  }
  
  public static final String PERMISSION_WEAR_MESSAGE()
  {
    AppMethodBeat.i(243693);
    String str = MMApplicationContext.getApplicationId() + ".wear.message";
    AppMethodBeat.o(243693);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.WeChatPermissions
 * JD-Core Version:    0.7.0.1
 */