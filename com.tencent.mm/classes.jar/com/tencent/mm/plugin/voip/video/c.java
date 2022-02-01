package com.tencent.mm.plugin.voip.video;

import android.content.Context;
import android.media.ToneGenerator;
import android.provider.Settings.System;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;

public final class c
{
  private static final HashMap<String, Integer> UMg;
  public static Context mContext;
  public Object UMh;
  public ToneGenerator UMi;
  private final int UMj;
  
  static
  {
    AppMethodBeat.i(115579);
    HashMap localHashMap = new HashMap();
    UMg = localHashMap;
    localHashMap.put("1", Integer.valueOf(1));
    UMg.put("2", Integer.valueOf(2));
    UMg.put("3", Integer.valueOf(3));
    UMg.put("4", Integer.valueOf(4));
    UMg.put("5", Integer.valueOf(5));
    UMg.put("6", Integer.valueOf(6));
    UMg.put("7", Integer.valueOf(7));
    UMg.put("8", Integer.valueOf(8));
    UMg.put("9", Integer.valueOf(9));
    UMg.put("0", Integer.valueOf(0));
    UMg.put("#", Integer.valueOf(11));
    UMg.put("*", Integer.valueOf(10));
    AppMethodBeat.o(115579);
  }
  
  private c()
  {
    AppMethodBeat.i(115576);
    this.UMh = new Object();
    this.UMj = 250;
    AppMethodBeat.o(115576);
  }
  
  public c(Context arg1)
  {
    AppMethodBeat.i(115575);
    this.UMh = new Object();
    this.UMj = 250;
    mContext = ???;
    if (??? != null) {
      try
      {
        synchronized (this.UMh)
        {
          if ((icg()) && (this.UMi == null)) {
            this.UMi = new ToneGenerator(3, 66);
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
        this.UMi = null;
      }
    }
  }
  
  public static int bfP(String paramString)
  {
    AppMethodBeat.i(115578);
    if ((paramString == null) || (paramString.equals("")))
    {
      AppMethodBeat.o(115578);
      return -1;
    }
    if (UMg.containsKey(paramString))
    {
      int i = ((Integer)UMg.get(paramString)).intValue();
      AppMethodBeat.o(115578);
      return i;
    }
    AppMethodBeat.o(115578);
    return -1;
  }
  
  public static boolean icg()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.c
 * JD-Core Version:    0.7.0.1
 */