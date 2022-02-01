package com.tencent.mm.plugin.voip.video;

import android.content.Context;
import android.media.ToneGenerator;
import android.provider.Settings.System;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;

public final class c
{
  private static final HashMap<String, Integer> NYj;
  public static Context mContext;
  public Object NYk;
  public ToneGenerator NYl;
  private final int NYm;
  
  static
  {
    AppMethodBeat.i(115579);
    HashMap localHashMap = new HashMap();
    NYj = localHashMap;
    localHashMap.put("1", Integer.valueOf(1));
    NYj.put("2", Integer.valueOf(2));
    NYj.put("3", Integer.valueOf(3));
    NYj.put("4", Integer.valueOf(4));
    NYj.put("5", Integer.valueOf(5));
    NYj.put("6", Integer.valueOf(6));
    NYj.put("7", Integer.valueOf(7));
    NYj.put("8", Integer.valueOf(8));
    NYj.put("9", Integer.valueOf(9));
    NYj.put("0", Integer.valueOf(0));
    NYj.put("#", Integer.valueOf(11));
    NYj.put("*", Integer.valueOf(10));
    AppMethodBeat.o(115579);
  }
  
  private c()
  {
    AppMethodBeat.i(115576);
    this.NYk = new Object();
    this.NYm = 250;
    AppMethodBeat.o(115576);
  }
  
  public c(Context arg1)
  {
    AppMethodBeat.i(115575);
    this.NYk = new Object();
    this.NYm = 250;
    mContext = ???;
    if (??? != null) {
      try
      {
        synchronized (this.NYk)
        {
          if ((gDk()) && (this.NYl == null)) {
            this.NYl = new ToneGenerator(3, 66);
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
        this.NYl = null;
      }
    }
  }
  
  public static int bgl(String paramString)
  {
    AppMethodBeat.i(115578);
    if ((paramString == null) || (paramString.equals("")))
    {
      AppMethodBeat.o(115578);
      return -1;
    }
    if (NYj.containsKey(paramString))
    {
      int i = ((Integer)NYj.get(paramString)).intValue();
      AppMethodBeat.o(115578);
      return i;
    }
    AppMethodBeat.o(115578);
    return -1;
  }
  
  public static boolean gDk()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.c
 * JD-Core Version:    0.7.0.1
 */