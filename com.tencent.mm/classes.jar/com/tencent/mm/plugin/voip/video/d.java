package com.tencent.mm.plugin.voip.video;

import android.content.Context;
import android.media.ToneGenerator;
import android.provider.Settings.System;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.HashMap;

public final class d
{
  private static final HashMap<String, Integer> ANi;
  public static Context mContext;
  public Object ANj;
  public ToneGenerator ANk;
  private final int ANl;
  
  static
  {
    AppMethodBeat.i(115579);
    HashMap localHashMap = new HashMap();
    ANi = localHashMap;
    localHashMap.put("1", Integer.valueOf(1));
    ANi.put("2", Integer.valueOf(2));
    ANi.put("3", Integer.valueOf(3));
    ANi.put("4", Integer.valueOf(4));
    ANi.put("5", Integer.valueOf(5));
    ANi.put("6", Integer.valueOf(6));
    ANi.put("7", Integer.valueOf(7));
    ANi.put("8", Integer.valueOf(8));
    ANi.put("9", Integer.valueOf(9));
    ANi.put("0", Integer.valueOf(0));
    ANi.put("#", Integer.valueOf(11));
    ANi.put("*", Integer.valueOf(10));
    AppMethodBeat.o(115579);
  }
  
  private d()
  {
    AppMethodBeat.i(115576);
    this.ANj = new Object();
    this.ANl = 250;
    AppMethodBeat.o(115576);
  }
  
  public d(Context arg1)
  {
    AppMethodBeat.i(115575);
    this.ANj = new Object();
    this.ANl = 250;
    mContext = ???;
    if (??? != null) {
      try
      {
        synchronized (this.ANj)
        {
          if ((emt()) && (this.ANk == null)) {
            this.ANk = new ToneGenerator(3, 66);
          }
          AppMethodBeat.o(115575);
          return;
        }
        AppMethodBeat.o(115575);
      }
      catch (Exception ???)
      {
        ac.d("MicroMsg.DTMFToneGenerator", "获取音频发生器单例失败！！！");
        ac.d("MicroMsg.DTMFToneGenerator", ???.getMessage());
        this.ANk = null;
      }
    }
  }
  
  public static int ayE(String paramString)
  {
    AppMethodBeat.i(115578);
    if ((paramString == null) || (paramString.equals("")))
    {
      AppMethodBeat.o(115578);
      return -1;
    }
    if (ANi.containsKey(paramString))
    {
      int i = ((Integer)ANi.get(paramString)).intValue();
      AppMethodBeat.o(115578);
      return i;
    }
    AppMethodBeat.o(115578);
    return -1;
  }
  
  public static boolean emt()
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
 * Qualified Name:     com.tencent.mm.plugin.voip.video.d
 * JD-Core Version:    0.7.0.1
 */