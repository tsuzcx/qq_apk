package com.tencent.mm.plugin.voip.video;

import android.content.Context;
import android.media.ToneGenerator;
import android.provider.Settings.System;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;

public final class d
{
  private static final HashMap<String, Integer> Cmv;
  public static Context mContext;
  public Object Cmw;
  public ToneGenerator Cmx;
  private final int Cmy;
  
  static
  {
    AppMethodBeat.i(115579);
    HashMap localHashMap = new HashMap();
    Cmv = localHashMap;
    localHashMap.put("1", Integer.valueOf(1));
    Cmv.put("2", Integer.valueOf(2));
    Cmv.put("3", Integer.valueOf(3));
    Cmv.put("4", Integer.valueOf(4));
    Cmv.put("5", Integer.valueOf(5));
    Cmv.put("6", Integer.valueOf(6));
    Cmv.put("7", Integer.valueOf(7));
    Cmv.put("8", Integer.valueOf(8));
    Cmv.put("9", Integer.valueOf(9));
    Cmv.put("0", Integer.valueOf(0));
    Cmv.put("#", Integer.valueOf(11));
    Cmv.put("*", Integer.valueOf(10));
    AppMethodBeat.o(115579);
  }
  
  private d()
  {
    AppMethodBeat.i(115576);
    this.Cmw = new Object();
    this.Cmy = 250;
    AppMethodBeat.o(115576);
  }
  
  public d(Context arg1)
  {
    AppMethodBeat.i(115575);
    this.Cmw = new Object();
    this.Cmy = 250;
    mContext = ???;
    if (??? != null) {
      try
      {
        synchronized (this.Cmw)
        {
          if ((eAp()) && (this.Cmx == null)) {
            this.Cmx = new ToneGenerator(3, 66);
          }
          AppMethodBeat.o(115575);
          return;
        }
        AppMethodBeat.o(115575);
      }
      catch (Exception ???)
      {
        ad.d("MicroMsg.DTMFToneGenerator", "获取音频发生器单例失败！！！");
        ad.d("MicroMsg.DTMFToneGenerator", ???.getMessage());
        this.Cmx = null;
      }
    }
  }
  
  public static int aDM(String paramString)
  {
    AppMethodBeat.i(115578);
    if ((paramString == null) || (paramString.equals("")))
    {
      AppMethodBeat.o(115578);
      return -1;
    }
    if (Cmv.containsKey(paramString))
    {
      int i = ((Integer)Cmv.get(paramString)).intValue();
      AppMethodBeat.o(115578);
      return i;
    }
    AppMethodBeat.o(115578);
    return -1;
  }
  
  public static boolean eAp()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.d
 * JD-Core Version:    0.7.0.1
 */