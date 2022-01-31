package com.tencent.wecall.talkroom.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.c.c;

public final class j
{
  public static boolean axD(String paramString)
  {
    AppMethodBeat.i(128001);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(128001);
      return false;
    }
    boolean bool = paramString.startsWith("client_");
    AppMethodBeat.o(128001);
    return bool;
  }
  
  public static int dXV()
  {
    AppMethodBeat.i(128002);
    try
    {
      int i = a.dXg().nTj;
      AppMethodBeat.o(128002);
      return i;
    }
    catch (Exception localException)
    {
      c.w("tagorewang:VoiceGroupUtil", new Object[] { "getActiveRoomId err: ", localException });
      AppMethodBeat.o(128002);
    }
    return 0;
  }
  
  public static long dXW()
  {
    AppMethodBeat.i(128003);
    try
    {
      long l = a.dXg().tFh;
      AppMethodBeat.o(128003);
      return l;
    }
    catch (Exception localException)
    {
      c.w("tagorewang:VoiceGroupUtil", new Object[] { "getActiveRoomKey err: ", localException });
      AppMethodBeat.o(128003);
    }
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.j
 * JD-Core Version:    0.7.0.1
 */