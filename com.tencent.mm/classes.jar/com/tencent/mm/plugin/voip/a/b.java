package com.tencent.mm.plugin.voip.a;

import java.util.HashMap;
import java.util.Map;

public final class b
{
  private static Map<Integer, String> pZG;
  
  static
  {
    HashMap localHashMap = new HashMap();
    pZG = localHashMap;
    localHashMap.put(Integer.valueOf(0), "CALLING_STATE_VIDEO_INVITING");
    pZG.put(Integer.valueOf(1), "CALLING_STATE_VOICE_INVITING");
    pZG.put(Integer.valueOf(2), "CALLING_STATE_VIDEO_WAITTING_ACCEPT");
    pZG.put(Integer.valueOf(3), "CALLING_STATE_VOICE_WAITTING_ACCEPT");
    pZG.put(Integer.valueOf(4), "CALLING_STATE_VIDEO_CONNECTING");
    pZG.put(Integer.valueOf(5), "CALLING_STATE_VOICE_CONNECTING");
    pZG.put(Integer.valueOf(6), "CALLING_STATE_VIDEO_TALKING");
    pZG.put(Integer.valueOf(7), "CALLING_STATE_VOICE_TALKING");
    pZG.put(Integer.valueOf(8), "CALLING_STATE_FINISH");
    pZG.put(Integer.valueOf(256), "CALLED_STATE_VIDEO_INVITING");
    pZG.put(Integer.valueOf(257), "CALLED_STATE_VOICE_INVITING");
    pZG.put(Integer.valueOf(258), "CALLED_STATE_VIDEO_CONNECTING");
    pZG.put(Integer.valueOf(259), "CALLED_STATE_VOICE_CONNECTING");
    pZG.put(Integer.valueOf(260), "CALLED_STATE_VIDEO_TALKING");
    pZG.put(Integer.valueOf(261), "CALLED_STATE_VOICE_TALKING");
    pZG.put(Integer.valueOf(262), "CALLED_STATE_FINISH");
    pZG.put(Integer.valueOf(4096), "ACTION_NOP");
    pZG.put(Integer.valueOf(4097), "ACTION_INVITE_RESPOND");
    pZG.put(Integer.valueOf(4098), "ACTION_CANCEL_INVITE");
    pZG.put(Integer.valueOf(4099), "ACTION_REJECT_INVITE");
    pZG.put(Integer.valueOf(4100), "ACTION_ACCEPT_INVITE");
    pZG.put(Integer.valueOf(4101), "ACTION_CLOSE_CAMERA");
    pZG.put(Integer.valueOf(4102), "ACTION_CONNECT_SUCC");
    pZG.put(Integer.valueOf(4103), "ACTION_SELF_HANGUP");
    pZG.put(Integer.valueOf(4104), "ACTION_ANOTHER_HANGUP");
    pZG.put(Integer.valueOf(4105), "ACTION_INVITE_TIMEOUT");
    pZG.put(Integer.valueOf(4106), "ACTION_SO_SHUTDOWN");
    pZG.put(Integer.valueOf(4107), "ACTION_PHONE_COMING");
    pZG.put(Integer.valueOf(4108), "ACTION_IGNORE_INVITE");
    pZG.put(Integer.valueOf(4109), "ACTION_ON_ERROR");
    pZG.put(Integer.valueOf(4110), "ACTION_SESSION_CALLED");
  }
  
  public static String At(int paramInt)
  {
    if (pZG.containsKey(Integer.valueOf(paramInt))) {
      return (String)pZG.get(Integer.valueOf(paramInt));
    }
    return "no found value";
  }
  
  public static c Au(int paramInt)
  {
    c localc = new c(paramInt);
    localc.X(256, 4098, 262);
    localc.X(256, 4099, 262);
    localc.X(256, 4105, 262);
    localc.X(256, 4106, 262);
    localc.X(256, 4107, 262);
    localc.X(256, 4108, 262);
    localc.X(256, 4109, 262);
    localc.X(256, 4100, 258);
    localc.X(256, 4101, 257);
    localc.X(257, 4100, 259);
    localc.X(257, 4098, 262);
    localc.X(257, 4099, 262);
    localc.X(257, 4105, 262);
    localc.X(257, 4106, 262);
    localc.X(257, 4107, 262);
    localc.X(257, 4108, 262);
    localc.X(257, 4109, 262);
    localc.X(258, 4098, 262);
    localc.X(258, 4106, 262);
    localc.X(258, 4107, 262);
    localc.X(258, 4103, 262);
    localc.X(258, 4109, 262);
    localc.X(258, 4102, 260);
    localc.X(259, 4102, 261);
    localc.X(259, 4098, 262);
    localc.X(259, 4106, 262);
    localc.X(259, 4107, 262);
    localc.X(259, 4103, 262);
    localc.X(259, 4109, 262);
    localc.X(260, 4101, 261);
    localc.X(260, 4103, 262);
    localc.X(260, 4104, 262);
    localc.X(260, 4106, 262);
    localc.X(260, 4107, 262);
    localc.X(260, 4109, 262);
    localc.X(261, 4103, 262);
    localc.X(261, 4104, 262);
    localc.X(261, 4106, 262);
    localc.X(261, 4107, 262);
    localc.X(261, 4109, 262);
    return localc;
  }
  
  public static c Av(int paramInt)
  {
    c localc = new c(paramInt);
    localc.X(0, 4098, 8);
    localc.X(0, 4106, 8);
    localc.X(0, 4107, 8);
    localc.X(0, 4109, 8);
    localc.X(0, 4097, 2);
    localc.X(0, 4101, 1);
    localc.X(1, 4097, 3);
    localc.X(1, 4098, 8);
    localc.X(1, 4106, 8);
    localc.X(1, 4107, 8);
    localc.X(1, 4109, 8);
    localc.X(2, 4098, 8);
    localc.X(2, 4099, 8);
    localc.X(2, 4105, 8);
    localc.X(2, 4106, 8);
    localc.X(2, 4107, 8);
    localc.X(2, 4109, 8);
    localc.X(2, 4100, 4);
    localc.X(2, 4101, 3);
    localc.X(3, 4100, 5);
    localc.X(3, 4098, 8);
    localc.X(3, 4099, 8);
    localc.X(3, 4105, 8);
    localc.X(3, 4106, 8);
    localc.X(3, 4107, 8);
    localc.X(3, 4109, 8);
    localc.X(4, 4102, 6);
    localc.X(4, 4101, 5);
    localc.X(5, 4102, 7);
    localc.X(6, 4103, 8);
    localc.X(6, 4104, 8);
    localc.X(6, 4106, 8);
    localc.X(6, 4107, 8);
    localc.X(6, 4109, 8);
    localc.X(6, 4101, 7);
    localc.X(7, 4103, 8);
    localc.X(7, 4104, 8);
    localc.X(7, 4106, 8);
    localc.X(7, 4107, 8);
    localc.X(7, 4109, 8);
    localc.X(4, 4098, 8);
    localc.X(4, 4099, 8);
    localc.X(4, 4106, 8);
    localc.X(4, 4107, 8);
    localc.X(4, 4103, 8);
    localc.X(4, 4109, 8);
    localc.X(5, 4098, 8);
    localc.X(5, 4099, 8);
    localc.X(5, 4106, 8);
    localc.X(5, 4107, 8);
    localc.X(5, 4103, 8);
    localc.X(5, 4109, 8);
    localc.X(0, 4110, 4);
    localc.X(1, 4110, 5);
    return localc;
  }
  
  public static boolean Aw(int paramInt)
  {
    return (260 == paramInt) || (261 == paramInt) || (6 == paramInt) || (7 == paramInt);
  }
  
  public static boolean Ax(int paramInt)
  {
    return (paramInt == 0) || (2 == paramInt) || (4 == paramInt) || (6 == paramInt) || (256 == paramInt) || (258 == paramInt) || (260 == paramInt);
  }
  
  public static boolean Ay(int paramInt)
  {
    return (1 == paramInt) || (paramInt == 0) || (2 == paramInt) || (3 == paramInt);
  }
  
  public static int K(boolean paramBoolean1, boolean paramBoolean2)
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
 * Qualified Name:     com.tencent.mm.plugin.voip.a.b
 * JD-Core Version:    0.7.0.1
 */