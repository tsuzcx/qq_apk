package com.tencent.thumbplayer.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.utils.f;
import java.util.HashMap;
import java.util.Map;

public final class b
{
  private static String TAG = "TPPlaybackInfo";
  public String KbZ;
  private String Kca;
  public int Kcb;
  public int Kcc;
  public long Kcd;
  private String Kce;
  private int Kcf;
  private long Kcg;
  public int Kch;
  long Kci;
  public long Kcj;
  int Kck;
  public long aQX;
  public long aQY;
  public long bjU;
  private int channels;
  private long sampleRate;
  
  public static b aTI(String paramString)
  {
    AppMethodBeat.i(187519);
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new b();
      AppMethodBeat.o(187519);
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
        f.i(str, paramString + "is empty");
        break;
      }
    }
    paramString = new b();
    if (localHashMap.containsKey("ContainerFormat")) {
      paramString.KbZ = ((String)localHashMap.get("ContainerFormat"));
    }
    if (localHashMap.containsKey("VideoCodec")) {
      paramString.Kca = ((String)localHashMap.get("VideoCodec"));
    }
    if (localHashMap.containsKey("AudioCodec")) {
      paramString.Kce = ((String)localHashMap.get("AudioCodec"));
    }
    if (localHashMap.containsKey("Width")) {
      paramString.aQX = Long.valueOf((String)localHashMap.get("Width")).longValue();
    }
    if (localHashMap.containsKey("Height")) {
      paramString.aQY = Long.valueOf((String)localHashMap.get("Height")).longValue();
    }
    if (localHashMap.containsKey("VideoBitRate")) {
      paramString.Kcd = Long.valueOf((String)localHashMap.get("VideoBitRate")).longValue();
    }
    if (localHashMap.containsKey("AudioBitRate")) {
      paramString.Kcg = Long.valueOf((String)localHashMap.get("AudioBitRate")).longValue();
    }
    if (localHashMap.containsKey("SampleRate")) {
      paramString.sampleRate = Long.valueOf((String)localHashMap.get("SampleRate")).longValue();
    }
    if (localHashMap.containsKey("Channels")) {
      paramString.channels = Integer.valueOf((String)localHashMap.get("Channels")).intValue();
    }
    AppMethodBeat.o(187519);
    return paramString;
  }
  
  public final void clear()
  {
    this.KbZ = null;
    this.Kca = null;
    this.Kcb = 0;
    this.Kcc = 0;
    this.aQX = 0L;
    this.aQY = 0L;
    this.Kcd = 0L;
    this.Kce = null;
    this.Kcf = 0;
    this.Kcg = 0L;
    this.channels = 0;
    this.sampleRate = 0L;
    this.Kch = 0;
    this.Kci = 0L;
    this.bjU = 0L;
    this.Kcj = 0L;
    this.Kck = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.a.b
 * JD-Core Version:    0.7.0.1
 */