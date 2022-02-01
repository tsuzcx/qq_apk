package com.tencent.thumbplayer.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.utils.d;
import java.util.HashMap;
import java.util.Map;

public final class b
{
  private static String TAG = "TPPlaybackInfo";
  public String LVV;
  private String LVW;
  public int LVX;
  public int LVY;
  public long LVZ;
  private String LWa;
  private int LWb;
  private long LWc;
  public int LWd;
  long LWe;
  public long LWf;
  int LWg;
  public long bbs;
  public long bbt;
  public long bup;
  private int channels;
  private long sampleRate;
  
  public static b aZI(String paramString)
  {
    AppMethodBeat.i(191540);
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new b();
      AppMethodBeat.o(191540);
      return paramString;
    }
    String[] arrayOfString = paramString.split("\n");
    HashMap localHashMap = new HashMap();
    int i = 0;
    while (i < arrayOfString.length)
    {
      if ((!arrayOfString[i].startsWith("#")) && (arrayOfString[i].contains("=")))
      {
        paramString = arrayOfString[i].split("=");
        if ((paramString != null) && (paramString.length >= 2)) {
          localHashMap.put(paramString[0], paramString[1]);
        }
      }
      else
      {
        i += 1;
        continue;
      }
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder("parseInfo, ");
      if ((paramString != null) && (paramString.length > 0)) {}
      for (paramString = paramString[0];; paramString = "param null, ")
      {
        d.i(str, paramString + "is empty");
        break;
      }
    }
    paramString = new b();
    if (localHashMap.containsKey("ContainerFormat")) {
      paramString.LVV = ((String)localHashMap.get("ContainerFormat"));
    }
    if (localHashMap.containsKey("VideoCodec")) {
      paramString.LVW = ((String)localHashMap.get("VideoCodec"));
    }
    if (localHashMap.containsKey("AudioCodec")) {
      paramString.LWa = ((String)localHashMap.get("AudioCodec"));
    }
    if (localHashMap.containsKey("Width")) {
      paramString.bbs = Long.valueOf((String)localHashMap.get("Width")).longValue();
    }
    if (localHashMap.containsKey("Height")) {
      paramString.bbt = Long.valueOf((String)localHashMap.get("Height")).longValue();
    }
    if (localHashMap.containsKey("VideoBitRate")) {
      paramString.LVZ = Long.valueOf((String)localHashMap.get("VideoBitRate")).longValue();
    }
    if (localHashMap.containsKey("AudioBitRate")) {
      paramString.LWc = Long.valueOf((String)localHashMap.get("AudioBitRate")).longValue();
    }
    if (localHashMap.containsKey("SampleRate")) {
      paramString.sampleRate = Long.valueOf((String)localHashMap.get("SampleRate")).longValue();
    }
    if (localHashMap.containsKey("Channels")) {
      paramString.channels = Integer.valueOf((String)localHashMap.get("Channels")).intValue();
    }
    AppMethodBeat.o(191540);
    return paramString;
  }
  
  public final void clear()
  {
    this.LVV = null;
    this.LVW = null;
    this.LVX = 0;
    this.LVY = 0;
    this.bbs = 0L;
    this.bbt = 0L;
    this.LVZ = 0L;
    this.LWa = null;
    this.LWb = 0;
    this.LWc = 0L;
    this.channels = 0;
    this.sampleRate = 0L;
    this.LWd = 0;
    this.LWe = 0L;
    this.bup = 0L;
    this.LWf = 0L;
    this.LWg = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.a.b
 * JD-Core Version:    0.7.0.1
 */