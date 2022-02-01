package com.tencent.thumbplayer.core.common;

import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecInfo.VideoCapabilities;
import android.os.Build.VERSION;
import android.util.Range;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public final class TPMediaDecoderInfo
  implements Serializable
{
  private static final int DEFAULT_MAX_HEIGHT = 720;
  private static final int DEFAULT_MAX_WIDTH = 1280;
  private static final String TAG = "TPCodecUtils";
  private final boolean adaptiveDec;
  private int[] colorFormats;
  private final String decMimeType;
  private final String decName;
  private int maxFrameRate;
  private int maxHeight;
  private int maxLumaFrameRate;
  private int maxLumaHeight;
  private int maxLumaWidth;
  private int maxSupportedInstances;
  private int maxWidth;
  private DecoderProfileLevel[] profileLevels;
  private final boolean secureDec;
  private final boolean softwareVideoDec;
  private final boolean tunnelingDec;
  
  public TPMediaDecoderInfo(String paramString1, String paramString2, MediaCodecInfo.CodecCapabilities paramCodecCapabilities)
  {
    AppMethodBeat.i(227608);
    this.decName = paramString2;
    this.decMimeType = paramString1;
    if ((isVideo(paramString1)) && (isSoftwareOnly(paramString2)))
    {
      bool1 = true;
      this.softwareVideoDec = bool1;
      if ((paramCodecCapabilities == null) || (!isAdaptive(paramCodecCapabilities))) {
        break label204;
      }
      bool1 = true;
      label62:
      this.adaptiveDec = bool1;
      if ((paramCodecCapabilities == null) || (!isTunneling(paramCodecCapabilities))) {
        break label210;
      }
      bool1 = true;
      label83:
      this.tunnelingDec = bool1;
      if ((paramCodecCapabilities == null) || (!isSecure(paramCodecCapabilities))) {
        break label216;
      }
    }
    label204:
    label210:
    label216:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.secureDec = bool1;
      if ((paramCodecCapabilities == null) || (paramCodecCapabilities.profileLevels == null) || (paramCodecCapabilities.profileLevels.length <= 0)) {
        break label404;
      }
      paramString2 = new ArrayList();
      MediaCodecInfo.CodecProfileLevel[] arrayOfCodecProfileLevel = paramCodecCapabilities.profileLevels;
      int j = arrayOfCodecProfileLevel.length;
      int i = 0;
      while (i < j)
      {
        MediaCodecInfo.CodecProfileLevel localCodecProfileLevel = arrayOfCodecProfileLevel[i];
        paramString2.add(new DecoderProfileLevel(localCodecProfileLevel.profile, localCodecProfileLevel.level));
        i += 1;
      }
      bool1 = false;
      break;
      bool1 = false;
      break label62;
      bool1 = false;
      break label83;
    }
    this.profileLevels = ((DecoderProfileLevel[])paramString2.toArray(new DecoderProfileLevel[paramString2.size()]));
    if ((paramCodecCapabilities != null) && (paramCodecCapabilities.colorFormats != null) && (paramCodecCapabilities.colorFormats.length > 0)) {}
    for (this.colorFormats = Arrays.copyOf(paramCodecCapabilities.colorFormats, paramCodecCapabilities.colorFormats.length);; this.colorFormats = new int[0])
    {
      this.maxSupportedInstances = getMaxSupportedInstances(paramCodecCapabilities);
      this.maxLumaFrameRate = 30;
      this.maxFrameRate = 30;
      this.maxWidth = 1280;
      this.maxHeight = 720;
      this.maxLumaWidth = 1280;
      this.maxLumaHeight = 720;
      if ((Build.VERSION.SDK_INT >= 21) && (paramString1.contains("video")) && (paramCodecCapabilities != null))
      {
        paramString1 = paramCodecCapabilities.getVideoCapabilities();
        if (paramString1 != null)
        {
          this.maxWidth = getMaxWidth(paramString1);
          this.maxHeight = getMaxHeight(paramString1);
          this.maxLumaFrameRate = getMaxSupportedFrameRate(paramString1);
          this.maxFrameRate = ((Integer)paramString1.getSupportedFrameRates().getUpper()).intValue();
        }
      }
      AppMethodBeat.o(227608);
      return;
      label404:
      this.profileLevels = new DecoderProfileLevel[0];
      break;
    }
  }
  
  private int getMaxHeight(MediaCodecInfo.VideoCapabilities paramVideoCapabilities)
  {
    AppMethodBeat.i(227677);
    if (paramVideoCapabilities != null) {}
    for (paramVideoCapabilities = paramVideoCapabilities.getSupportedHeights();; paramVideoCapabilities = new Range(Integer.valueOf(0), Integer.valueOf(720)))
    {
      int i = ((Integer)paramVideoCapabilities.getUpper()).intValue();
      AppMethodBeat.o(227677);
      return i;
    }
  }
  
  private final int getMaxSupportedFrameRate(MediaCodecInfo.VideoCapabilities paramVideoCapabilities)
  {
    AppMethodBeat.i(227685);
    if (paramVideoCapabilities == null)
    {
      AppMethodBeat.o(227685);
      return 30;
    }
    this.maxLumaWidth = ((Integer)paramVideoCapabilities.getSupportedWidthsFor(this.maxHeight).getUpper()).intValue();
    this.maxLumaHeight = ((Integer)paramVideoCapabilities.getSupportedHeightsFor(this.maxWidth).getUpper()).intValue();
    int i = ((Double)paramVideoCapabilities.getSupportedFrameRatesFor(this.maxWidth, this.maxLumaHeight).getUpper()).intValue();
    AppMethodBeat.o(227685);
    return i;
  }
  
  private int getMaxSupportedInstances(MediaCodecInfo.CodecCapabilities paramCodecCapabilities)
  {
    AppMethodBeat.i(227657);
    if ((paramCodecCapabilities == null) || (Build.VERSION.SDK_INT < 23))
    {
      AppMethodBeat.o(227657);
      return 1;
    }
    int i = paramCodecCapabilities.getMaxSupportedInstances();
    AppMethodBeat.o(227657);
    return i;
  }
  
  private int getMaxWidth(MediaCodecInfo.VideoCapabilities paramVideoCapabilities)
  {
    AppMethodBeat.i(227671);
    if (paramVideoCapabilities != null) {}
    for (paramVideoCapabilities = paramVideoCapabilities.getSupportedWidths();; paramVideoCapabilities = new Range(Integer.valueOf(0), Integer.valueOf(1280)))
    {
      int i = ((Integer)paramVideoCapabilities.getUpper()).intValue();
      AppMethodBeat.o(227671);
      return i;
    }
  }
  
  private boolean isAdaptive(MediaCodecInfo.CodecCapabilities paramCodecCapabilities)
  {
    AppMethodBeat.i(227625);
    if ((Build.VERSION.SDK_INT >= 19) && (paramCodecCapabilities.isFeatureSupported("adaptive-playback")))
    {
      AppMethodBeat.o(227625);
      return true;
    }
    AppMethodBeat.o(227625);
    return false;
  }
  
  private boolean isSecure(MediaCodecInfo.CodecCapabilities paramCodecCapabilities)
  {
    AppMethodBeat.i(227640);
    if ((Build.VERSION.SDK_INT >= 21) && (paramCodecCapabilities.isFeatureSupported("secure-playback")))
    {
      AppMethodBeat.o(227640);
      return true;
    }
    AppMethodBeat.o(227640);
    return false;
  }
  
  private boolean isSoftwareOnly(String paramString)
  {
    AppMethodBeat.i(227649);
    if (paramString == null)
    {
      paramString = "";
      if ((!paramString.startsWith("omx.google.")) && (!paramString.startsWith("omx.ffmpeg.")) && ((!paramString.startsWith("omx.sec.")) || (!paramString.contains(".sw."))) && (!paramString.equals("omx.qcom.video.decoder.hevcswvdec")) && ((!paramString.startsWith("omx.qti.video.decoder")) || (!paramString.contains("sw"))) && (!paramString.startsWith("c2.android.")) && (!paramString.startsWith("c2.google."))) {
        break label110;
      }
    }
    label110:
    for (boolean bool = true;; bool = false)
    {
      AppMethodBeat.o(227649);
      return bool;
      paramString = paramString.toLowerCase();
      break;
    }
  }
  
  private boolean isTunneling(MediaCodecInfo.CodecCapabilities paramCodecCapabilities)
  {
    AppMethodBeat.i(227633);
    if ((Build.VERSION.SDK_INT >= 21) && (paramCodecCapabilities.isFeatureSupported("tunneled-playback")))
    {
      AppMethodBeat.o(227633);
      return true;
    }
    AppMethodBeat.o(227633);
    return false;
  }
  
  private boolean isVideo(String paramString)
  {
    AppMethodBeat.i(227616);
    if (paramString == null)
    {
      AppMethodBeat.o(227616);
      return false;
    }
    boolean bool = paramString.startsWith("video/");
    AppMethodBeat.o(227616);
    return bool;
  }
  
  public final int[] getColorFormats()
  {
    return this.colorFormats;
  }
  
  public final int getDecoderLumaHeight()
  {
    return this.maxLumaHeight;
  }
  
  public final int getDecoderLumaWidth()
  {
    return this.maxLumaWidth;
  }
  
  public final int getDecoderMaxFrameRate()
  {
    return this.maxFrameRate;
  }
  
  public final int getDecoderMaxFrameRateForMaxLuma()
  {
    return this.maxLumaFrameRate;
  }
  
  public final int getDecoderMaxHeight()
  {
    return this.maxHeight;
  }
  
  public final int getDecoderMaxWidth()
  {
    return this.maxWidth;
  }
  
  public final String getDecoderMimeType()
  {
    return this.decMimeType;
  }
  
  public final String getDecoderName()
  {
    return this.decName;
  }
  
  public final DecoderProfileLevel getMaxProfileLevel()
  {
    AppMethodBeat.i(227744);
    Object localObject = new DecoderProfileLevel(0, 0);
    DecoderProfileLevel[] arrayOfDecoderProfileLevel = this.profileLevels;
    int k = arrayOfDecoderProfileLevel.length;
    int i = 0;
    int j = 0;
    if (i < k)
    {
      DecoderProfileLevel localDecoderProfileLevel = arrayOfDecoderProfileLevel[i];
      if (localDecoderProfileLevel.level <= j) {
        break label78;
      }
      j = localDecoderProfileLevel.level;
      localObject = localDecoderProfileLevel;
    }
    label78:
    for (;;)
    {
      i += 1;
      break;
      AppMethodBeat.o(227744);
      return localObject;
    }
  }
  
  public final int getMaxSupportedInstances()
  {
    return this.maxSupportedInstances;
  }
  
  public final DecoderProfileLevel[] getProfileLevels()
  {
    return this.profileLevels;
  }
  
  public final boolean isSecureDecoder()
  {
    return this.secureDec;
  }
  
  public final boolean isVideoSofwareDecoder()
  {
    return this.softwareVideoDec;
  }
  
  final class DecoderProfileLevel
    implements Serializable
  {
    public int level;
    public int profile;
    
    public DecoderProfileLevel(int paramInt1, int paramInt2)
    {
      this.profile = paramInt1;
      this.level = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPMediaDecoderInfo
 * JD-Core Version:    0.7.0.1
 */