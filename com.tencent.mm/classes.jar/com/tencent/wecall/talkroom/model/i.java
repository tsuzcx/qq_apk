package com.tencent.wecall.talkroom.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.c.b;

public final class i
{
  public static boolean bEt(String paramString)
  {
    AppMethodBeat.i(62717);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(62717);
      return false;
    }
    boolean bool = paramString.startsWith("client_");
    AppMethodBeat.o(62717);
    return bool;
  }
  
  public static int ivi()
  {
    AppMethodBeat.i(62718);
    try
    {
      int i = a.iut().DVO;
      AppMethodBeat.o(62718);
      return i;
    }
    catch (Exception localException)
    {
      b.w("tagorewang:VoiceGroupUtil", new Object[] { "getActiveRoomId err: ", localException });
      AppMethodBeat.o(62718);
    }
    return 0;
  }
  
  public static long ivj()
  {
    AppMethodBeat.i(62719);
    try
    {
      long l = a.iut().NXM;
      AppMethodBeat.o(62719);
      return l;
    }
    catch (Exception localException)
    {
      b.w("tagorewang:VoiceGroupUtil", new Object[] { "getActiveRoomKey err: ", localException });
      AppMethodBeat.o(62719);
    }
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.i
 * JD-Core Version:    0.7.0.1
 */