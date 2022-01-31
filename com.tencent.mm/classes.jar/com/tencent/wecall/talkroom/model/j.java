package com.tencent.wecall.talkroom.model;

import android.text.TextUtils;
import com.tencent.pb.common.c.c;

public final class j
{
  public static boolean agI(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return paramString.startsWith("client_");
  }
  
  public static int cRY()
  {
    try
    {
      int i = a.cRq().lvU;
      return i;
    }
    catch (Exception localException)
    {
      c.x("tagorewang:VoiceGroupUtil", new Object[] { "getActiveRoomId err: ", localException });
    }
    return 0;
  }
  
  public static long cRZ()
  {
    try
    {
      long l = a.cRq().xdR;
      return l;
    }
    catch (Exception localException)
    {
      c.x("tagorewang:VoiceGroupUtil", new Object[] { "getActiveRoomKey err: ", localException });
    }
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.j
 * JD-Core Version:    0.7.0.1
 */