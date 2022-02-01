package com.tencent.mm.plugin.voip.video;

import android.content.Context;
import android.media.ToneGenerator;
import android.provider.Settings.System;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.HashMap;

public final class d
{
  private static final HashMap<String, Integer> CDZ;
  public static Context mContext;
  public Object CEa;
  public ToneGenerator CEb;
  private final int CEc;
  
  static
  {
    AppMethodBeat.i(115579);
    HashMap localHashMap = new HashMap();
    CDZ = localHashMap;
    localHashMap.put("1", Integer.valueOf(1));
    CDZ.put("2", Integer.valueOf(2));
    CDZ.put("3", Integer.valueOf(3));
    CDZ.put("4", Integer.valueOf(4));
    CDZ.put("5", Integer.valueOf(5));
    CDZ.put("6", Integer.valueOf(6));
    CDZ.put("7", Integer.valueOf(7));
    CDZ.put("8", Integer.valueOf(8));
    CDZ.put("9", Integer.valueOf(9));
    CDZ.put("0", Integer.valueOf(0));
    CDZ.put("#", Integer.valueOf(11));
    CDZ.put("*", Integer.valueOf(10));
    AppMethodBeat.o(115579);
  }
  
  private d()
  {
    AppMethodBeat.i(115576);
    this.CEa = new Object();
    this.CEc = 250;
    AppMethodBeat.o(115576);
  }
  
  public d(Context arg1)
  {
    AppMethodBeat.i(115575);
    this.CEa = new Object();
    this.CEc = 250;
    mContext = ???;
    if (??? != null) {
      try
      {
        synchronized (this.CEa)
        {
          if ((eDX()) && (this.CEb == null)) {
            this.CEb = new ToneGenerator(3, 66);
          }
          AppMethodBeat.o(115575);
          return;
        }
        AppMethodBeat.o(115575);
      }
      catch (Exception ???)
      {
        ae.d("MicroMsg.DTMFToneGenerator", "获取音频发生器单例失败！！！");
        ae.d("MicroMsg.DTMFToneGenerator", ???.getMessage());
        this.CEb = null;
      }
    }
  }
  
  public static int aFf(String paramString)
  {
    AppMethodBeat.i(115578);
    if ((paramString == null) || (paramString.equals("")))
    {
      AppMethodBeat.o(115578);
      return -1;
    }
    if (CDZ.containsKey(paramString))
    {
      int i = ((Integer)CDZ.get(paramString)).intValue();
      AppMethodBeat.o(115578);
      return i;
    }
    AppMethodBeat.o(115578);
    return -1;
  }
  
  public static boolean eDX()
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