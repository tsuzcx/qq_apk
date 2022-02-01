package com.tencent.mm.plugin.voip.video;

import android.content.Context;
import android.media.ToneGenerator;
import android.provider.Settings.System;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;

public final class c
{
  private static final HashMap<String, Integer> Hhu;
  public static Context mContext;
  public Object Hhv;
  public ToneGenerator Hhw;
  private final int Hhx;
  
  static
  {
    AppMethodBeat.i(115579);
    HashMap localHashMap = new HashMap();
    Hhu = localHashMap;
    localHashMap.put("1", Integer.valueOf(1));
    Hhu.put("2", Integer.valueOf(2));
    Hhu.put("3", Integer.valueOf(3));
    Hhu.put("4", Integer.valueOf(4));
    Hhu.put("5", Integer.valueOf(5));
    Hhu.put("6", Integer.valueOf(6));
    Hhu.put("7", Integer.valueOf(7));
    Hhu.put("8", Integer.valueOf(8));
    Hhu.put("9", Integer.valueOf(9));
    Hhu.put("0", Integer.valueOf(0));
    Hhu.put("#", Integer.valueOf(11));
    Hhu.put("*", Integer.valueOf(10));
    AppMethodBeat.o(115579);
  }
  
  private c()
  {
    AppMethodBeat.i(115576);
    this.Hhv = new Object();
    this.Hhx = 250;
    AppMethodBeat.o(115576);
  }
  
  public c(Context arg1)
  {
    AppMethodBeat.i(115575);
    this.Hhv = new Object();
    this.Hhx = 250;
    mContext = ???;
    if (??? != null) {
      try
      {
        synchronized (this.Hhv)
        {
          if ((fKK()) && (this.Hhw == null)) {
            this.Hhw = new ToneGenerator(3, 66);
          }
          AppMethodBeat.o(115575);
          return;
        }
        AppMethodBeat.o(115575);
      }
      catch (Exception ???)
      {
        Log.d("MicroMsg.DTMFToneGenerator", "获取音频发生器单例失败！！！");
        Log.d("MicroMsg.DTMFToneGenerator", ???.getMessage());
        this.Hhw = null;
      }
    }
  }
  
  public static int aUD(String paramString)
  {
    AppMethodBeat.i(115578);
    if ((paramString == null) || (paramString.equals("")))
    {
      AppMethodBeat.o(115578);
      return -1;
    }
    if (Hhu.containsKey(paramString))
    {
      int i = ((Integer)Hhu.get(paramString)).intValue();
      AppMethodBeat.o(115578);
      return i;
    }
    AppMethodBeat.o(115578);
    return -1;
  }
  
  public static boolean fKK()
  {
    AppMethodBeat.i(115577);
    if (Settings.System.getInt(mContext.getContentResolver(), "dtmf_tone", 1) == 1)
    {
      AppMethodBeat.o(115577);
      return true;
    }
    AppMethodBeat.o(115577);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.c
 * JD-Core Version:    0.7.0.1
 */