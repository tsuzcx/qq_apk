package com.tencent.tav.decoder;

import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.AudioCapabilities;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecInfo.VideoCapabilities;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.util.Range;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.decoder.logger.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CodecHelper
{
  public static final int MAX_BIT_RATE = 8000000;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(214810);
    TAG = CodecHelper.class.getSimpleName();
    AppMethodBeat.o(214810);
  }
  
  public static boolean checkAudioOutSupported(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(214807);
    Object localObject1 = encoderCodecInfo(paramString);
    if (((List)localObject1).size() > 0) {
      localObject1 = ((List)localObject1).iterator();
    }
    label153:
    label169:
    label173:
    for (;;)
    {
      boolean bool;
      int i;
      if (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((MediaCodecInfo)((Iterator)localObject1).next()).getCapabilitiesForType(paramString).getAudioCapabilities();
        bool = ((MediaCodecInfo.AudioCapabilities)localObject2).getBitrateRange().contains(Integer.valueOf(paramInt1));
        if (((MediaCodecInfo.AudioCapabilities)localObject2).getMaxInputChannelCount() >= paramInt2)
        {
          i = 1;
          localObject2 = ((MediaCodecInfo.AudioCapabilities)localObject2).getSupportedSampleRateRanges();
          int k = localObject2.length;
          j = 0;
          label100:
          if (j >= k) {
            break label169;
          }
          if (!localObject2[j].contains(Integer.valueOf(paramInt3))) {
            break label153;
          }
        }
      }
      for (int j = 1;; j = 0)
      {
        if ((!bool) || (i == 0) || (j == 0)) {
          break label173;
        }
        AppMethodBeat.o(214807);
        return true;
        i = 0;
        break;
        j += 1;
        break label100;
        AppMethodBeat.o(214807);
        return false;
      }
    }
  }
  
  public static boolean checkVideoOutSupported(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString)
  {
    AppMethodBeat.i(214806);
    Object localObject = encoderCodecInfo(paramString);
    if (((List)localObject).size() > 0)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MediaCodecInfo.VideoCapabilities localVideoCapabilities = ((MediaCodecInfo)((Iterator)localObject).next()).getCapabilitiesForType(paramString).getVideoCapabilities();
        boolean bool1 = localVideoCapabilities.getBitrateRange().contains(Integer.valueOf(paramInt4));
        boolean bool2 = localVideoCapabilities.getSupportedFrameRates().contains(Integer.valueOf(paramInt3));
        boolean bool3 = localVideoCapabilities.isSizeSupported(paramInt1, paramInt2);
        if ((bool1) && (bool2) && (bool3))
        {
          AppMethodBeat.o(214806);
          return true;
        }
      }
    }
    AppMethodBeat.o(214806);
    return false;
  }
  
  public static int clampHeight(MediaCodecInfo paramMediaCodecInfo, String paramString, int paramInt)
  {
    AppMethodBeat.i(214805);
    if ((Build.VERSION.SDK_INT < 21) || (paramMediaCodecInfo == null))
    {
      AppMethodBeat.o(214805);
      return paramInt;
    }
    paramInt = ((Integer)paramMediaCodecInfo.getCapabilitiesForType(paramString).getVideoCapabilities().getSupportedHeights().clamp(Integer.valueOf(paramInt))).intValue();
    AppMethodBeat.o(214805);
    return paramInt;
  }
  
  public static int clampWidth(MediaCodecInfo paramMediaCodecInfo, String paramString, int paramInt)
  {
    AppMethodBeat.i(214804);
    if ((Build.VERSION.SDK_INT < 21) || (paramMediaCodecInfo == null))
    {
      AppMethodBeat.o(214804);
      return paramInt;
    }
    paramInt = ((Integer)paramMediaCodecInfo.getCapabilitiesForType(paramString).getVideoCapabilities().getSupportedWidths().clamp(Integer.valueOf(paramInt))).intValue();
    AppMethodBeat.o(214804);
    return paramInt;
  }
  
  public static CGSize correctSupportSize(CGSize paramCGSize, String paramString)
  {
    AppMethodBeat.i(214798);
    int i2 = (int)paramCGSize.width;
    int i1 = (int)paramCGSize.height;
    int m = MediaCodecList.getCodecCount();
    paramCGSize = null;
    int i = 0;
    int k;
    int j;
    if ((i < m) && (paramCGSize == null))
    {
      MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
      if (!localMediaCodecInfo.isEncoder()) {
        break label471;
      }
      String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
      k = 0;
      j = 0;
      while ((j < arrayOfString.length) && (k == 0))
      {
        if (arrayOfString[j].equals(paramString)) {
          k = 1;
        }
        j += 1;
      }
      if (k == 0) {
        break label471;
      }
      paramCGSize = localMediaCodecInfo;
    }
    label471:
    for (;;)
    {
      i += 1;
      break;
      j = getWidthAlignment(paramCGSize, paramString);
      i = getHeightAlignment(paramCGSize, paramString);
      m = (int)(Math.ceil(i2 * 1.0F / j) * j);
      k = (int)(Math.ceil(i1 * 1.0F / i) * i);
      Logger.d(TAG, "correctSupportSize 1: target = [" + m + ", " + k + "]");
      i = clampWidth(paramCGSize, paramString, i2);
      if (m != i)
      {
        float f = i * 1.0F / m;
        k = (int)(k * f);
        m = i;
      }
      for (;;)
      {
        Logger.d(TAG, "correctSupportSize 2: target = [" + m + ", " + k + "]");
        int n = clampHeight(paramCGSize, paramString, i1);
        j = k;
        i = m;
        if (k != n)
        {
          i = (int)(n * 1.0F / k * m);
          j = n;
        }
        Logger.d(TAG, "correctSupportSize 3: target = [" + i + ", " + j + "]");
        m = j;
        k = i;
        if (!isSupported(paramCGSize, paramString, i, j))
        {
          k = (int)(Math.ceil(i2 / 16.0F) * 16.0D);
          m = (int)(Math.ceil(i1 / 16.0F) * 16.0D);
        }
        Logger.i(TAG, "correctSupportSize return: target = [" + k + ", " + m + "]");
        paramCGSize = new CGSize(k, m);
        AppMethodBeat.o(214798);
        return paramCGSize;
      }
    }
  }
  
  private static List<MediaCodecInfo> decoderCodecInfo(String paramString)
  {
    AppMethodBeat.i(214799);
    int k = MediaCodecList.getCodecCount();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < k)
    {
      MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
      String[] arrayOfString;
      int m;
      int j;
      if (!localMediaCodecInfo.isEncoder())
      {
        arrayOfString = localMediaCodecInfo.getSupportedTypes();
        m = arrayOfString.length;
        j = 0;
      }
      for (;;)
      {
        if (j < m)
        {
          if (arrayOfString[j].equals(paramString)) {
            localArrayList.add(localMediaCodecInfo);
          }
        }
        else
        {
          i += 1;
          break;
        }
        j += 1;
      }
    }
    AppMethodBeat.o(214799);
    return localArrayList;
  }
  
  private static List<MediaCodecInfo> encoderCodecInfo(String paramString)
  {
    AppMethodBeat.i(214800);
    int k = MediaCodecList.getCodecCount();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < k)
    {
      MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
      String[] arrayOfString;
      int m;
      int j;
      if (localMediaCodecInfo.isEncoder())
      {
        arrayOfString = localMediaCodecInfo.getSupportedTypes();
        m = arrayOfString.length;
        j = 0;
      }
      for (;;)
      {
        if (j < m)
        {
          if (arrayOfString[j].equals(paramString)) {
            localArrayList.add(localMediaCodecInfo);
          }
        }
        else
        {
          i += 1;
          break;
        }
        j += 1;
      }
    }
    AppMethodBeat.o(214800);
    return localArrayList;
  }
  
  private static int getHeightAlignment(MediaCodecInfo paramMediaCodecInfo, String paramString)
  {
    AppMethodBeat.i(214802);
    if (Build.VERSION.SDK_INT >= 21)
    {
      if (paramMediaCodecInfo != null)
      {
        int i = paramMediaCodecInfo.getCapabilitiesForType(paramString).getVideoCapabilities().getHeightAlignment();
        AppMethodBeat.o(214802);
        return i;
      }
      AppMethodBeat.o(214802);
      return 16;
    }
    AppMethodBeat.o(214802);
    return 16;
  }
  
  private static int getWidthAlignment(MediaCodecInfo paramMediaCodecInfo, String paramString)
  {
    AppMethodBeat.i(214801);
    if (Build.VERSION.SDK_INT >= 21)
    {
      if (paramMediaCodecInfo != null)
      {
        int i = paramMediaCodecInfo.getCapabilitiesForType(paramString).getVideoCapabilities().getWidthAlignment();
        AppMethodBeat.o(214801);
        return i;
      }
      AppMethodBeat.o(214801);
      return 16;
    }
    AppMethodBeat.o(214801);
    return 16;
  }
  
  private static boolean isSupported(MediaCodecInfo paramMediaCodecInfo, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(214803);
    if ((Build.VERSION.SDK_INT >= 21) && (paramMediaCodecInfo != null) && (paramMediaCodecInfo.getCapabilitiesForType(paramString).getVideoCapabilities().isSizeSupported(paramInt1, paramInt2)))
    {
      AppMethodBeat.o(214803);
      return true;
    }
    AppMethodBeat.o(214803);
    return false;
  }
  
  public static MediaCodecInfo selectCodec(String paramString)
  {
    AppMethodBeat.i(214809);
    int k = MediaCodecList.getCodecCount();
    int i = 0;
    while (i < k)
    {
      MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
      if (localMediaCodecInfo.isEncoder())
      {
        String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
        int j = 0;
        while (j < arrayOfString.length)
        {
          if (arrayOfString[j].equalsIgnoreCase(paramString))
          {
            AppMethodBeat.o(214809);
            return localMediaCodecInfo;
          }
          j += 1;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(214809);
    return null;
  }
  
  public static void selectProfileAndLevel(MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(214808);
    Object localObject = selectCodec("video/avc");
    int k;
    int j;
    int i;
    int n;
    int m;
    if (localObject != null)
    {
      localObject = ((MediaCodecInfo)localObject).getCapabilitiesForType("video/avc");
      if (((MediaCodecInfo.CodecCapabilities)localObject).profileLevels != null)
      {
        k = 0;
        j = -1;
        i = -1;
        n = j;
        m = i;
        if (k >= ((MediaCodecInfo.CodecCapabilities)localObject).profileLevels.length) {
          break label165;
        }
        if (localObject.profileLevels[k].profile > 8) {
          break label229;
        }
        if (localObject.profileLevels[k].profile > i)
        {
          i = localObject.profileLevels[k].profile;
          j = localObject.profileLevels[k].level;
        }
      }
    }
    label165:
    label229:
    for (;;)
    {
      k += 1;
      break;
      if ((localObject.profileLevels[k].profile == i) && (localObject.profileLevels[k].level > j))
      {
        j = localObject.profileLevels[k].level;
        continue;
        n = -1;
        m = -1;
        if (m == 8)
        {
          paramMediaFormat.setInteger("profile", m);
          paramMediaFormat.setInteger("level", n);
          Logger.i(TAG, String.format("selectProfileAndLevel: 0x%x, 0x%x", new Object[] { Integer.valueOf(m), Integer.valueOf(n) }));
        }
        AppMethodBeat.o(214808);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tav.decoder.CodecHelper
 * JD-Core Version:    0.7.0.1
 */