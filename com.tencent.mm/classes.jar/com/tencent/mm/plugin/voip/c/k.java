package com.tencent.mm.plugin.voip.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class k
{
  private static Map<Integer, String> NYf;
  
  static
  {
    AppMethodBeat.i(115526);
    HashMap localHashMap = new HashMap();
    NYf = localHashMap;
    localHashMap.put(Integer.valueOf(0), "CALLING_STATE_VIDEO_INVITING");
    NYf.put(Integer.valueOf(1), "CALLING_STATE_VOICE_INVITING");
    NYf.put(Integer.valueOf(2), "CALLING_STATE_VIDEO_WAITTING_ACCEPT");
    NYf.put(Integer.valueOf(3), "CALLING_STATE_VOICE_WAITTING_ACCEPT");
    NYf.put(Integer.valueOf(4), "CALLING_STATE_VIDEO_CONNECTING");
    NYf.put(Integer.valueOf(5), "CALLING_STATE_VOICE_CONNECTING");
    NYf.put(Integer.valueOf(6), "CALLING_STATE_VIDEO_TALKING");
    NYf.put(Integer.valueOf(7), "CALLING_STATE_VOICE_TALKING");
    NYf.put(Integer.valueOf(8), "CALLING_STATE_FINISH");
    NYf.put(Integer.valueOf(256), "CALLED_STATE_VIDEO_INVITING");
    NYf.put(Integer.valueOf(257), "CALLED_STATE_VOICE_INVITING");
    NYf.put(Integer.valueOf(258), "CALLED_STATE_VIDEO_CONNECTING");
    NYf.put(Integer.valueOf(259), "CALLED_STATE_VOICE_CONNECTING");
    NYf.put(Integer.valueOf(260), "CALLED_STATE_VIDEO_TALKING");
    NYf.put(Integer.valueOf(261), "CALLED_STATE_VOICE_TALKING");
    NYf.put(Integer.valueOf(262), "CALLED_STATE_FINISH");
    NYf.put(Integer.valueOf(4096), "ACTION_NOP");
    NYf.put(Integer.valueOf(4097), "ACTION_INVITE_RESPOND");
    NYf.put(Integer.valueOf(4098), "ACTION_CANCEL_INVITE");
    NYf.put(Integer.valueOf(4099), "ACTION_REJECT_INVITE");
    NYf.put(Integer.valueOf(4100), "ACTION_ACCEPT_INVITE");
    NYf.put(Integer.valueOf(4101), "ACTION_CLOSE_CAMERA");
    NYf.put(Integer.valueOf(4102), "ACTION_CONNECT_SUCC");
    NYf.put(Integer.valueOf(4103), "ACTION_SELF_HANGUP");
    NYf.put(Integer.valueOf(4104), "ACTION_ANOTHER_HANGUP");
    NYf.put(Integer.valueOf(4105), "ACTION_INVITE_TIMEOUT");
    NYf.put(Integer.valueOf(4106), "ACTION_SO_SHUTDOWN");
    NYf.put(Integer.valueOf(4107), "ACTION_PHONE_COMING");
    NYf.put(Integer.valueOf(4108), "ACTION_IGNORE_INVITE");
    NYf.put(Integer.valueOf(4109), "ACTION_ON_ERROR");
    NYf.put(Integer.valueOf(4110), "ACTION_SESSION_CALLED");
    AppMethodBeat.o(115526);
  }
  
  public static l alA(int paramInt)
  {
    AppMethodBeat.i(115524);
    l locall = new l(paramInt);
    locall.aH(256, 4098, 262);
    locall.aH(256, 4099, 262);
    locall.aH(256, 4105, 262);
    locall.aH(256, 4106, 262);
    locall.aH(256, 4107, 262);
    locall.aH(256, 4108, 262);
    locall.aH(256, 4109, 262);
    locall.aH(256, 4100, 258);
    locall.aH(256, 4101, 257);
    locall.aH(257, 4100, 259);
    locall.aH(257, 4098, 262);
    locall.aH(257, 4099, 262);
    locall.aH(257, 4105, 262);
    locall.aH(257, 4106, 262);
    locall.aH(257, 4107, 262);
    locall.aH(257, 4108, 262);
    locall.aH(257, 4109, 262);
    locall.aH(258, 4098, 262);
    locall.aH(258, 4106, 262);
    locall.aH(258, 4107, 262);
    locall.aH(258, 4103, 262);
    locall.aH(258, 4109, 262);
    locall.aH(258, 4102, 260);
    locall.aH(259, 4102, 261);
    locall.aH(259, 4098, 262);
    locall.aH(259, 4106, 262);
    locall.aH(259, 4107, 262);
    locall.aH(259, 4103, 262);
    locall.aH(259, 4109, 262);
    locall.aH(260, 4101, 261);
    locall.aH(260, 4103, 262);
    locall.aH(260, 4104, 262);
    locall.aH(260, 4106, 262);
    locall.aH(260, 4107, 262);
    locall.aH(260, 4109, 262);
    locall.aH(261, 4103, 262);
    locall.aH(261, 4104, 262);
    locall.aH(261, 4106, 262);
    locall.aH(261, 4107, 262);
    locall.aH(261, 4109, 262);
    AppMethodBeat.o(115524);
    return locall;
  }
  
  public static l alB(int paramInt)
  {
    AppMethodBeat.i(115525);
    l locall = new l(paramInt);
    locall.aH(0, 4098, 8);
    locall.aH(0, 4106, 8);
    locall.aH(0, 4107, 8);
    locall.aH(0, 4109, 8);
    locall.aH(0, 4097, 2);
    locall.aH(0, 4101, 1);
    locall.aH(1, 4097, 3);
    locall.aH(1, 4098, 8);
    locall.aH(1, 4106, 8);
    locall.aH(1, 4107, 8);
    locall.aH(1, 4109, 8);
    locall.aH(2, 4098, 8);
    locall.aH(2, 4099, 8);
    locall.aH(2, 4105, 8);
    locall.aH(2, 4106, 8);
    locall.aH(2, 4107, 8);
    locall.aH(2, 4109, 8);
    locall.aH(2, 4100, 4);
    locall.aH(2, 4101, 3);
    locall.aH(3, 4100, 5);
    locall.aH(3, 4098, 8);
    locall.aH(3, 4099, 8);
    locall.aH(3, 4105, 8);
    locall.aH(3, 4106, 8);
    locall.aH(3, 4107, 8);
    locall.aH(3, 4109, 8);
    locall.aH(4, 4102, 6);
    locall.aH(4, 4101, 5);
    locall.aH(5, 4102, 7);
    locall.aH(6, 4103, 8);
    locall.aH(6, 4104, 8);
    locall.aH(6, 4106, 8);
    locall.aH(6, 4107, 8);
    locall.aH(6, 4109, 8);
    locall.aH(6, 4101, 7);
    locall.aH(7, 4103, 8);
    locall.aH(7, 4104, 8);
    locall.aH(7, 4106, 8);
    locall.aH(7, 4107, 8);
    locall.aH(7, 4109, 8);
    locall.aH(4, 4098, 8);
    locall.aH(4, 4099, 8);
    locall.aH(4, 4106, 8);
    locall.aH(4, 4107, 8);
    locall.aH(4, 4103, 8);
    locall.aH(4, 4109, 8);
    locall.aH(5, 4098, 8);
    locall.aH(5, 4099, 8);
    locall.aH(5, 4106, 8);
    locall.aH(5, 4107, 8);
    locall.aH(5, 4103, 8);
    locall.aH(5, 4109, 8);
    locall.aH(0, 4110, 4);
    locall.aH(1, 4110, 5);
    AppMethodBeat.o(115525);
    return locall;
  }
  
  public static boolean alC(int paramInt)
  {
    return (260 == paramInt) || (261 == paramInt) || (6 == paramInt) || (7 == paramInt);
  }
  
  public static boolean alD(int paramInt)
  {
    return (paramInt == 0) || (2 == paramInt) || (4 == paramInt) || (6 == paramInt) || (256 == paramInt) || (258 == paramInt) || (260 == paramInt);
  }
  
  public static boolean alE(int paramInt)
  {
    return (1 == paramInt) || (paramInt == 0) || (2 == paramInt) || (3 == paramInt);
  }
  
  public static boolean alF(int paramInt)
  {
    return (paramInt == 256) || (paramInt == 257);
  }
  
  public static String alz(int paramInt)
  {
    AppMethodBeat.i(115523);
    if (NYf.containsKey(Integer.valueOf(paramInt)))
    {
      String str = (String)NYf.get(Integer.valueOf(paramInt));
      AppMethodBeat.o(115523);
      return str;
    }
    AppMethodBeat.o(115523);
    return "no found value";
  }
  
  public static boolean asM(int paramInt)
  {
    return (paramInt == 262) || (paramInt == 8);
  }
  
  public static int bc(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 1;
    if ((true == paramBoolean1) && (true == paramBoolean2)) {
      i = 0;
    }
    while ((true == paramBoolean1) && (!paramBoolean2)) {
      return i;
    }
    if ((!paramBoolean1) && (true == paramBoolean2)) {
      return 256;
    }
    return 257;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.c.k
 * JD-Core Version:    0.7.0.1
 */