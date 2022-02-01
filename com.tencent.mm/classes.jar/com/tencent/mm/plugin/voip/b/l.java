package com.tencent.mm.plugin.voip.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class l
{
  private static Map<Integer, String> CDn;
  
  static
  {
    AppMethodBeat.i(115526);
    HashMap localHashMap = new HashMap();
    CDn = localHashMap;
    localHashMap.put(Integer.valueOf(0), "CALLING_STATE_VIDEO_INVITING");
    CDn.put(Integer.valueOf(1), "CALLING_STATE_VOICE_INVITING");
    CDn.put(Integer.valueOf(2), "CALLING_STATE_VIDEO_WAITTING_ACCEPT");
    CDn.put(Integer.valueOf(3), "CALLING_STATE_VOICE_WAITTING_ACCEPT");
    CDn.put(Integer.valueOf(4), "CALLING_STATE_VIDEO_CONNECTING");
    CDn.put(Integer.valueOf(5), "CALLING_STATE_VOICE_CONNECTING");
    CDn.put(Integer.valueOf(6), "CALLING_STATE_VIDEO_TALKING");
    CDn.put(Integer.valueOf(7), "CALLING_STATE_VOICE_TALKING");
    CDn.put(Integer.valueOf(8), "CALLING_STATE_FINISH");
    CDn.put(Integer.valueOf(256), "CALLED_STATE_VIDEO_INVITING");
    CDn.put(Integer.valueOf(257), "CALLED_STATE_VOICE_INVITING");
    CDn.put(Integer.valueOf(258), "CALLED_STATE_VIDEO_CONNECTING");
    CDn.put(Integer.valueOf(259), "CALLED_STATE_VOICE_CONNECTING");
    CDn.put(Integer.valueOf(260), "CALLED_STATE_VIDEO_TALKING");
    CDn.put(Integer.valueOf(261), "CALLED_STATE_VOICE_TALKING");
    CDn.put(Integer.valueOf(262), "CALLED_STATE_FINISH");
    CDn.put(Integer.valueOf(4096), "ACTION_NOP");
    CDn.put(Integer.valueOf(4097), "ACTION_INVITE_RESPOND");
    CDn.put(Integer.valueOf(4098), "ACTION_CANCEL_INVITE");
    CDn.put(Integer.valueOf(4099), "ACTION_REJECT_INVITE");
    CDn.put(Integer.valueOf(4100), "ACTION_ACCEPT_INVITE");
    CDn.put(Integer.valueOf(4101), "ACTION_CLOSE_CAMERA");
    CDn.put(Integer.valueOf(4102), "ACTION_CONNECT_SUCC");
    CDn.put(Integer.valueOf(4103), "ACTION_SELF_HANGUP");
    CDn.put(Integer.valueOf(4104), "ACTION_ANOTHER_HANGUP");
    CDn.put(Integer.valueOf(4105), "ACTION_INVITE_TIMEOUT");
    CDn.put(Integer.valueOf(4106), "ACTION_SO_SHUTDOWN");
    CDn.put(Integer.valueOf(4107), "ACTION_PHONE_COMING");
    CDn.put(Integer.valueOf(4108), "ACTION_IGNORE_INVITE");
    CDn.put(Integer.valueOf(4109), "ACTION_ON_ERROR");
    CDn.put(Integer.valueOf(4110), "ACTION_SESSION_CALLED");
    AppMethodBeat.o(115526);
  }
  
  public static String Vr(int paramInt)
  {
    AppMethodBeat.i(115523);
    if (CDn.containsKey(Integer.valueOf(paramInt)))
    {
      String str = (String)CDn.get(Integer.valueOf(paramInt));
      AppMethodBeat.o(115523);
      return str;
    }
    AppMethodBeat.o(115523);
    return "no found value";
  }
  
  public static m Vs(int paramInt)
  {
    AppMethodBeat.i(115524);
    m localm = new m(paramInt);
    localm.ay(256, 4098, 262);
    localm.ay(256, 4099, 262);
    localm.ay(256, 4105, 262);
    localm.ay(256, 4106, 262);
    localm.ay(256, 4107, 262);
    localm.ay(256, 4108, 262);
    localm.ay(256, 4109, 262);
    localm.ay(256, 4100, 258);
    localm.ay(256, 4101, 257);
    localm.ay(257, 4100, 259);
    localm.ay(257, 4098, 262);
    localm.ay(257, 4099, 262);
    localm.ay(257, 4105, 262);
    localm.ay(257, 4106, 262);
    localm.ay(257, 4107, 262);
    localm.ay(257, 4108, 262);
    localm.ay(257, 4109, 262);
    localm.ay(258, 4098, 262);
    localm.ay(258, 4106, 262);
    localm.ay(258, 4107, 262);
    localm.ay(258, 4103, 262);
    localm.ay(258, 4109, 262);
    localm.ay(258, 4102, 260);
    localm.ay(259, 4102, 261);
    localm.ay(259, 4098, 262);
    localm.ay(259, 4106, 262);
    localm.ay(259, 4107, 262);
    localm.ay(259, 4103, 262);
    localm.ay(259, 4109, 262);
    localm.ay(260, 4101, 261);
    localm.ay(260, 4103, 262);
    localm.ay(260, 4104, 262);
    localm.ay(260, 4106, 262);
    localm.ay(260, 4107, 262);
    localm.ay(260, 4109, 262);
    localm.ay(261, 4103, 262);
    localm.ay(261, 4104, 262);
    localm.ay(261, 4106, 262);
    localm.ay(261, 4107, 262);
    localm.ay(261, 4109, 262);
    AppMethodBeat.o(115524);
    return localm;
  }
  
  public static m Vt(int paramInt)
  {
    AppMethodBeat.i(115525);
    m localm = new m(paramInt);
    localm.ay(0, 4098, 8);
    localm.ay(0, 4106, 8);
    localm.ay(0, 4107, 8);
    localm.ay(0, 4109, 8);
    localm.ay(0, 4097, 2);
    localm.ay(0, 4101, 1);
    localm.ay(1, 4097, 3);
    localm.ay(1, 4098, 8);
    localm.ay(1, 4106, 8);
    localm.ay(1, 4107, 8);
    localm.ay(1, 4109, 8);
    localm.ay(2, 4098, 8);
    localm.ay(2, 4099, 8);
    localm.ay(2, 4105, 8);
    localm.ay(2, 4106, 8);
    localm.ay(2, 4107, 8);
    localm.ay(2, 4109, 8);
    localm.ay(2, 4100, 4);
    localm.ay(2, 4101, 3);
    localm.ay(3, 4100, 5);
    localm.ay(3, 4098, 8);
    localm.ay(3, 4099, 8);
    localm.ay(3, 4105, 8);
    localm.ay(3, 4106, 8);
    localm.ay(3, 4107, 8);
    localm.ay(3, 4109, 8);
    localm.ay(4, 4102, 6);
    localm.ay(4, 4101, 5);
    localm.ay(5, 4102, 7);
    localm.ay(6, 4103, 8);
    localm.ay(6, 4104, 8);
    localm.ay(6, 4106, 8);
    localm.ay(6, 4107, 8);
    localm.ay(6, 4109, 8);
    localm.ay(6, 4101, 7);
    localm.ay(7, 4103, 8);
    localm.ay(7, 4104, 8);
    localm.ay(7, 4106, 8);
    localm.ay(7, 4107, 8);
    localm.ay(7, 4109, 8);
    localm.ay(4, 4098, 8);
    localm.ay(4, 4099, 8);
    localm.ay(4, 4106, 8);
    localm.ay(4, 4107, 8);
    localm.ay(4, 4103, 8);
    localm.ay(4, 4109, 8);
    localm.ay(5, 4098, 8);
    localm.ay(5, 4099, 8);
    localm.ay(5, 4106, 8);
    localm.ay(5, 4107, 8);
    localm.ay(5, 4103, 8);
    localm.ay(5, 4109, 8);
    localm.ay(0, 4110, 4);
    localm.ay(1, 4110, 5);
    AppMethodBeat.o(115525);
    return localm;
  }
  
  public static boolean Vu(int paramInt)
  {
    return (260 == paramInt) || (261 == paramInt) || (6 == paramInt) || (7 == paramInt);
  }
  
  public static boolean Vv(int paramInt)
  {
    return (paramInt == 0) || (2 == paramInt) || (4 == paramInt) || (6 == paramInt) || (256 == paramInt) || (258 == paramInt) || (260 == paramInt);
  }
  
  public static boolean Vw(int paramInt)
  {
    return (1 == paramInt) || (paramInt == 0) || (2 == paramInt) || (3 == paramInt);
  }
  
  public static boolean Vx(int paramInt)
  {
    return (paramInt == 256) || (paramInt == 257);
  }
  
  public static int aE(boolean paramBoolean1, boolean paramBoolean2)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.b.l
 * JD-Core Version:    0.7.0.1
 */