package com.tencent.thumbplayer.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.utils.g;
import java.util.HashMap;
import java.util.Map;

public final class b
{
  private static String TAG = "TPPlaybackInfo";
  public long Gpr;
  public String ahCV;
  String ahCW;
  public int ahCX;
  public int ahCY;
  String ahCZ;
  int ahDa;
  long ahDb;
  public int ahDc;
  long ahDd;
  public long ahDe;
  int ahDf;
  int channels;
  String definition;
  public long durationMs;
  public long height;
  long sampleRate;
  public long width;
  
  public static b bFY(String paramString)
  {
    AppMethodBeat.i(228477);
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new b();
      AppMethodBeat.o(228477);
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
        g.i(str, paramString + "is empty");
        break;
      }
    }
    paramString = new b();
    if (localHashMap.containsKey("ContainerFormat")) {
      paramString.ahCV = ((String)localHashMap.get("ContainerFormat"));
    }
    if (localHashMap.containsKey("VideoCodec")) {
      paramString.ahCW = ((String)localHashMap.get("VideoCodec"));
    }
    if (localHashMap.containsKey("AudioCodec")) {
      paramString.ahCZ = ((String)localHashMap.get("AudioCodec"));
    }
    if (localHashMap.containsKey("Width")) {
      paramString.width = Long.valueOf((String)localHashMap.get("Width")).longValue();
    }
    if (localHashMap.containsKey("Height")) {
      paramString.height = Long.valueOf((String)localHashMap.get("Height")).longValue();
    }
    if (localHashMap.containsKey("VideoBitRate")) {
      paramString.Gpr = Long.valueOf((String)localHashMap.get("VideoBitRate")).longValue();
    }
    if (localHashMap.containsKey("AudioBitRate")) {
      paramString.ahDb = Long.valueOf((String)localHashMap.get("AudioBitRate")).longValue();
    }
    if (localHashMap.containsKey("SampleRate")) {
      paramString.sampleRate = Long.valueOf((String)localHashMap.get("SampleRate")).longValue();
    }
    if (localHashMap.containsKey("Channels")) {
      paramString.channels = Integer.valueOf((String)localHashMap.get("Channels")).intValue();
    }
    if (localHashMap.containsKey("Definition")) {
      paramString.definition = ((String)localHashMap.get("Definition"));
    }
    AppMethodBeat.o(228477);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.a.b
 * JD-Core Version:    0.7.0.1
 */