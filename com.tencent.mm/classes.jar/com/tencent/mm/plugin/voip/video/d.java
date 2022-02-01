package com.tencent.mm.plugin.voip.video;

import android.content.Context;
import android.media.ToneGenerator;
import android.provider.Settings.System;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;

public final class d
{
  public static Context mContext;
  private static final HashMap<String, Integer> zuq;
  public Object zur;
  public ToneGenerator zus;
  private final int zut;
  
  static
  {
    AppMethodBeat.i(115579);
    HashMap localHashMap = new HashMap();
    zuq = localHashMap;
    localHashMap.put("1", Integer.valueOf(1));
    zuq.put("2", Integer.valueOf(2));
    zuq.put("3", Integer.valueOf(3));
    zuq.put("4", Integer.valueOf(4));
    zuq.put("5", Integer.valueOf(5));
    zuq.put("6", Integer.valueOf(6));
    zuq.put("7", Integer.valueOf(7));
    zuq.put("8", Integer.valueOf(8));
    zuq.put("9", Integer.valueOf(9));
    zuq.put("0", Integer.valueOf(0));
    zuq.put("#", Integer.valueOf(11));
    zuq.put("*", Integer.valueOf(10));
    AppMethodBeat.o(115579);
  }
  
  private d()
  {
    AppMethodBeat.i(115576);
    this.zur = new Object();
    this.zut = 250;
    AppMethodBeat.o(115576);
  }
  
  public d(Context arg1)
  {
    AppMethodBeat.i(115575);
    this.zur = new Object();
    this.zut = 250;
    mContext = ???;
    if (??? != null) {
      try
      {
        synchronized (this.zur)
        {
          if ((dWZ()) && (this.zus == null)) {
            this.zus = new ToneGenerator(3, 66);
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
        this.zus = null;
      }
    }
  }
  
  public static int atm(String paramString)
  {
    AppMethodBeat.i(115578);
    if ((paramString == null) || (paramString.equals("")))
    {
      AppMethodBeat.o(115578);
      return -1;
    }
    if (zuq.containsKey(paramString))
    {
      int i = ((Integer)zuq.get(paramString)).intValue();
      AppMethodBeat.o(115578);
      return i;
    }
    AppMethodBeat.o(115578);
    return -1;
  }
  
  public static boolean dWZ()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.d
 * JD-Core Version:    0.7.0.1
 */