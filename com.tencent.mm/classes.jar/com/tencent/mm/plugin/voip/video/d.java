package com.tencent.mm.plugin.voip.video;

import android.content.Context;
import android.media.ToneGenerator;
import android.provider.Settings.System;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;

public final class d
{
  public static Context mContext;
  private static final HashMap<String, Integer> tFS;
  public Object tFT;
  public ToneGenerator tFU;
  private final int tFV;
  
  static
  {
    AppMethodBeat.i(5056);
    HashMap localHashMap = new HashMap();
    tFS = localHashMap;
    localHashMap.put("1", Integer.valueOf(1));
    tFS.put("2", Integer.valueOf(2));
    tFS.put("3", Integer.valueOf(3));
    tFS.put("4", Integer.valueOf(4));
    tFS.put("5", Integer.valueOf(5));
    tFS.put("6", Integer.valueOf(6));
    tFS.put("7", Integer.valueOf(7));
    tFS.put("8", Integer.valueOf(8));
    tFS.put("9", Integer.valueOf(9));
    tFS.put("0", Integer.valueOf(0));
    tFS.put("#", Integer.valueOf(11));
    tFS.put("*", Integer.valueOf(10));
    AppMethodBeat.o(5056);
  }
  
  private d()
  {
    AppMethodBeat.i(5053);
    this.tFT = new Object();
    this.tFV = 250;
    AppMethodBeat.o(5053);
  }
  
  public d(Context arg1)
  {
    AppMethodBeat.i(5052);
    this.tFT = new Object();
    this.tFV = 250;
    mContext = ???;
    if (??? != null) {
      try
      {
        synchronized (this.tFT)
        {
          if ((cPE()) && (this.tFU == null)) {
            this.tFU = new ToneGenerator(3, 66);
          }
          AppMethodBeat.o(5052);
          return;
        }
        AppMethodBeat.o(5052);
      }
      catch (Exception ???)
      {
        ab.d("MicroMsg.DTMFToneGenerator", "获取音频发生器单例失败！！！");
        ab.d("MicroMsg.DTMFToneGenerator", ???.getMessage());
        this.tFU = null;
      }
    }
  }
  
  public static int aeK(String paramString)
  {
    AppMethodBeat.i(5055);
    if ((paramString == null) || (paramString.equals("")))
    {
      AppMethodBeat.o(5055);
      return -1;
    }
    if (tFS.containsKey(paramString))
    {
      int i = ((Integer)tFS.get(paramString)).intValue();
      AppMethodBeat.o(5055);
      return i;
    }
    AppMethodBeat.o(5055);
    return -1;
  }
  
  public static boolean cPE()
  {
    AppMethodBeat.i(5054);
    if (Settings.System.getInt(mContext.getContentResolver(), "dtmf_tone", 1) == 1)
    {
      AppMethodBeat.o(5054);
      return true;
    }
    AppMethodBeat.o(5054);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.d
 * JD-Core Version:    0.7.0.1
 */