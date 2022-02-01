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
import com.tencent.tav.extractor.AssetExtractor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CodecHelper
{
  public static int HARD_CODE_PARALLEL_COUNT = 0;
  public static final int MAX_BIT_RATE = 8000000;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(216107);
    TAG = CodecHelper.class.getSimpleName();
    HARD_CODE_PARALLEL_COUNT = -1;
    AppMethodBeat.o(216107);
  }
  
  public static boolean checkAudioOutSupported(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(216079);
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
        AppMethodBeat.o(216079);
        return true;
        i = 0;
        break;
        j += 1;
        break label100;
        AppMethodBeat.o(216079);
        return false;
      }
    }
  }
  
  public static boolean checkVideoOutSupported(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString)
  {
    AppMethodBeat.i(216038);
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
          AppMethodBeat.o(216038);
          return true;
        }
      }
    }
    AppMethodBeat.o(216038);
    return false;
  }
  
  public static int clampHeight(MediaCodecInfo paramMediaCodecInfo, String paramString, int paramInt)
  {
    AppMethodBeat.i(216031);
    if ((Build.VERSION.SDK_INT < 21) || (paramMediaCodecInfo == null))
    {
      AppMethodBeat.o(216031);
      return paramInt;
    }
    paramInt = ((Integer)paramMediaCodecInfo.getCapabilitiesForType(paramString).getVideoCapabilities().getSupportedHeights().clamp(Integer.valueOf(paramInt))).intValue();
    AppMethodBeat.o(216031);
    return paramInt;
  }
  
  public static int clampWidth(MediaCodecInfo paramMediaCodecInfo, String paramString, int paramInt)
  {
    AppMethodBeat.i(216024);
    if ((Build.VERSION.SDK_INT < 21) || (paramMediaCodecInfo == null))
    {
      AppMethodBeat.o(216024);
      return paramInt;
    }
    paramInt = ((Integer)paramMediaCodecInfo.getCapabilitiesForType(paramString).getVideoCapabilities().getSupportedWidths().clamp(Integer.valueOf(paramInt))).intValue();
    AppMethodBeat.o(216024);
    return paramInt;
  }
  
  public static CGSize correctSupportSize(CGSize paramCGSize, String paramString)
  {
    AppMethodBeat.i(215990);
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
        AppMethodBeat.o(215990);
        return paramCGSize;
      }
    }
  }
  
  private static List<MediaCodecInfo> decoderCodecInfo(String paramString)
  {
    AppMethodBeat.i(215995);
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
    AppMethodBeat.o(215995);
    return localArrayList;
  }
  
  public static List<MediaCodecInfo> encoderCodecInfo(String paramString)
  {
    AppMethodBeat.i(215998);
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
    AppMethodBeat.o(215998);
    return localArrayList;
  }
  
  private static int getHeightAlignment(MediaCodecInfo paramMediaCodecInfo, String paramString)
  {
    AppMethodBeat.i(216011);
    if (Build.VERSION.SDK_INT >= 21)
    {
      if (paramMediaCodecInfo != null)
      {
        int i = paramMediaCodecInfo.getCapabilitiesForType(paramString).getVideoCapabilities().getHeightAlignment();
        AppMethodBeat.o(216011);
        return i;
      }
      AppMethodBeat.o(216011);
      return 16;
    }
    AppMethodBeat.o(216011);
    return 16;
  }
  
  public static int getSupportMaxParallelCount(int paramInt1, int paramInt2, int paramInt3, long paramLong, String paramString)
  {
    AppMethodBeat.i(216070);
    Logger.i(TAG, "getSupportMaxParallelCount print width:%d height:%d frameRate:%d bitRate:%d bitRate:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Long.valueOf(paramLong), paramString });
    if (HARD_CODE_PARALLEL_COUNT >= 0)
    {
      Logger.i(TAG, "hardcode parallel count %d", new Object[] { Integer.valueOf(HARD_CODE_PARALLEL_COUNT) });
      paramInt1 = HARD_CODE_PARALLEL_COUNT;
      AppMethodBeat.o(216070);
      return paramInt1;
    }
    Object localObject = selectCodec(paramString);
    if (localObject == null)
    {
      Logger.e(TAG, "CodecHelper.selectCodec null");
      AppMethodBeat.o(216070);
      return 0;
    }
    paramString = ((MediaCodecInfo)localObject).getCapabilitiesForType(paramString).getVideoCapabilities();
    localObject = paramString.getSupportedWidths();
    Range localRange = paramString.getSupportedHeights();
    if ((localObject == null) || (localRange == null))
    {
      paramString = TAG;
      boolean bool1;
      if (localObject == null)
      {
        bool1 = true;
        if (localRange != null) {
          break label216;
        }
      }
      label216:
      for (boolean bool2 = true;; bool2 = false)
      {
        Logger.e(paramString, "getSupportMaxParallelCount size range error.width null[%b] height null[%b]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        AppMethodBeat.o(216070);
        return 1;
        bool1 = false;
        break;
      }
    }
    Logger.i(TAG, "getSupportMaxParallelCount widthRange:%s heightRange:%s", new Object[] { localObject, localRange });
    int j = paramInt1;
    int i = paramInt2;
    if (!paramString.isSizeSupported(paramInt1, paramInt2))
    {
      Logger.e(TAG, "isSizeSupported false1");
      j = paramInt1 + (paramString.getWidthAlignment() + paramInt1) % paramString.getWidthAlignment();
      i = paramInt2 + (paramString.getHeightAlignment() + paramInt2) % paramString.getHeightAlignment();
    }
    if (!paramString.isSizeSupported(j, i))
    {
      Logger.e(TAG, "isSizeSupported false2");
      AppMethodBeat.o(216070);
      return -1;
    }
    localObject = paramString.getSupportedFrameRatesFor(j, i);
    Logger.i(TAG, "getSupportMaxParallelCount frameRange:%s", new Object[] { localObject });
    if (paramInt3 <= 0)
    {
      paramInt1 = 0;
      paramString = paramString.getBitrateRange();
      Logger.i(TAG, "getSupportMaxParallelCount BitrateRange:%s", new Object[] { paramString });
      if (paramLong > 0L) {
        break label457;
      }
    }
    label457:
    for (paramInt2 = paramInt1;; paramInt2 = (int)(((Integer)paramString.getUpper()).intValue() / paramLong))
    {
      Logger.i(TAG, "getSupportMaxParallelCount frameMaxCount:%d bitrateMaxCount:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      paramInt1 /= 2;
      AppMethodBeat.o(216070);
      return paramInt1;
      paramInt1 = (int)(((Double)((Range)localObject).getUpper()).doubleValue() / paramInt3);
      break;
    }
  }
  
  public static int getSupportMaxParallelCount(String paramString)
  {
    AppMethodBeat.i(216051);
    if (HARD_CODE_PARALLEL_COUNT >= 0)
    {
      Logger.i(TAG, "hardcode parallel count %d", new Object[] { Integer.valueOf(HARD_CODE_PARALLEL_COUNT) });
      i = HARD_CODE_PARALLEL_COUNT;
      AppMethodBeat.o(216051);
      return i;
    }
    AssetExtractor localAssetExtractor = new AssetExtractor();
    localAssetExtractor.setDataSource(paramString);
    int i = DecoderUtils.getFirstTrackIndex(localAssetExtractor, "video/");
    if (i < 0)
    {
      AppMethodBeat.o(216051);
      return 0;
    }
    localAssetExtractor.selectTrack(i);
    paramString = localAssetExtractor.getTrackFormat(i);
    int j;
    label131:
    int k;
    if (paramString.containsKey("width"))
    {
      i = paramString.getInteger("width");
      if (!paramString.containsKey("height")) {
        break label198;
      }
      j = paramString.getInteger("height");
      if (!paramString.containsKey("frame-rate")) {
        break label203;
      }
      k = paramString.getInteger("frame-rate");
      label149:
      if (!paramString.containsKey("bitrate")) {
        break label209;
      }
    }
    label198:
    label203:
    label209:
    for (long l = paramString.getInteger("bitrate");; l = 0L)
    {
      i = getSupportMaxParallelCount(i, j, k, l, paramString.getString("mime"));
      AppMethodBeat.o(216051);
      return i;
      i = 0;
      break;
      j = 0;
      break label131;
      k = 30;
      break label149;
    }
  }
  
  private static int getWidthAlignment(MediaCodecInfo paramMediaCodecInfo, String paramString)
  {
    AppMethodBeat.i(216006);
    if (Build.VERSION.SDK_INT >= 21)
    {
      if (paramMediaCodecInfo != null)
      {
        int i = paramMediaCodecInfo.getCapabilitiesForType(paramString).getVideoCapabilities().getWidthAlignment();
        AppMethodBeat.o(216006);
        return i;
      }
      AppMethodBeat.o(216006);
      return 16;
    }
    AppMethodBeat.o(216006);
    return 16;
  }
  
  private static boolean isSupported(MediaCodecInfo paramMediaCodecInfo, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(216017);
    if ((Build.VERSION.SDK_INT >= 21) && (paramMediaCodecInfo != null) && (paramMediaCodecInfo.getCapabilitiesForType(paramString).getVideoCapabilities().isSizeSupported(paramInt1, paramInt2)))
    {
      AppMethodBeat.o(216017);
      return true;
    }
    AppMethodBeat.o(216017);
    return false;
  }
  
  public static MediaCodecInfo selectCodec(String paramString)
  {
    AppMethodBeat.i(216100);
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
            AppMethodBeat.o(216100);
            return localMediaCodecInfo;
          }
          j += 1;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(216100);
    return null;
  }
  
  public static void selectProfileAndLevel(MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(216092);
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
        AppMethodBeat.o(216092);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.decoder.CodecHelper
 * JD-Core Version:    0.7.0.1
 */