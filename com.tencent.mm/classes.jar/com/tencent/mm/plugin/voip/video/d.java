package com.tencent.mm.plugin.voip.video;

import android.content.Context;
import android.media.ToneGenerator;
import android.provider.Settings.System;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

public final class d
{
  public static Context mContext;
  private static final HashMap<String, Integer> qap;
  public Object qaq = new Object();
  public ToneGenerator qar;
  private final int qas = 250;
  
  static
  {
    HashMap localHashMap = new HashMap();
    qap = localHashMap;
    localHashMap.put("1", Integer.valueOf(1));
    qap.put("2", Integer.valueOf(2));
    qap.put("3", Integer.valueOf(3));
    qap.put("4", Integer.valueOf(4));
    qap.put("5", Integer.valueOf(5));
    qap.put("6", Integer.valueOf(6));
    qap.put("7", Integer.valueOf(7));
    qap.put("8", Integer.valueOf(8));
    qap.put("9", Integer.valueOf(9));
    qap.put("0", Integer.valueOf(0));
    qap.put("#", Integer.valueOf(11));
    qap.put("*", Integer.valueOf(10));
  }
  
  private d() {}
  
  public d(Context arg1)
  {
    mContext = ???;
    if (??? != null) {
      try
      {
        synchronized (this.qaq)
        {
          if ((bSx()) && (this.qar == null)) {
            this.qar = new ToneGenerator(3, 66);
          }
          return;
        }
        return;
      }
      catch (Exception ???)
      {
        y.d("MicroMsg.DTMFToneGenerator", "获取音频发生器单例失败！！！");
        y.d("MicroMsg.DTMFToneGenerator", ???.getMessage());
        this.qar = null;
      }
    }
  }
  
  public static int Qd(String paramString)
  {
    if ((paramString == null) || (paramString.equals(""))) {}
    while (!qap.containsKey(paramString)) {
      return -1;
    }
    return ((Integer)qap.get(paramString)).intValue();
  }
  
  public static boolean bSx()
  {
    return Settings.System.getInt(mContext.getContentResolver(), "dtmf_tone", 1) == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.d
 * JD-Core Version:    0.7.0.1
 */