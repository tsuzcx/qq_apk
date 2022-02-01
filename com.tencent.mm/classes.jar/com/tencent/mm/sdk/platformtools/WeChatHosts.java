package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WeChatHosts
{
  public static final String TAG = "MicroMsg.WeChatHosts";
  
  public static String domainString(int paramInt)
  {
    AppMethodBeat.i(200973);
    String str = MMApplicationContext.getContext().getString(paramInt);
    AppMethodBeat.o(200973);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.WeChatHosts
 * JD-Core Version:    0.7.0.1
 */