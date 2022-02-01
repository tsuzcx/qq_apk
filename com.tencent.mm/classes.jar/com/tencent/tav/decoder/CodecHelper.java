package com.tencent.tav.decoder;

import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.AudioCapabilities;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.VideoCapabilities;
import android.media.MediaCodecList;
import android.os.Build.VERSION;
import android.util.Range;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CGSize;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CodecHelper
{
  public static final int MAX_BIT_RATE = 8000000;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(201733);
    TAG = CodecHelper.class.getSimpleName();
    AppMethodBeat.o(201733);
  }
  
  public static boolean checkAudioOutSupported(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(201732);
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
        AppMethodBeat.o(201732);
        return true;
        i = 0;
        break;
        j += 1;
        break label100;
        AppMethodBeat.o(201732);
        return false;
      }
    }
  }
  
  public static boolean checkVideoOutSupported(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString)
  {
    AppMethodBeat.i(201731);
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
          AppMethodBeat.o(201731);
          return true;
        }
      }
    }
    AppMethodBeat.o(201731);
    return false;
  }
  
  public static CGSize correctSupportSize(CGSize paramCGSize, String paramString)
  {
    AppMethodBeat.i(201725);
    int n = (int)paramCGSize.width;
    int m = (int)paramCGSize.height;
    int i1 = MediaCodecList.getCodecCount();
    paramCGSize = null;
    int i = 0;
    int j;
    if ((i < i1) && (paramCGSize == null))
    {
      MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
      if (!localMediaCodecInfo.isEncoder()) {
        break label222;
      }
      String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
      int k = 0;
      j = 0;
      while ((j < arrayOfString.length) && (k == 0))
      {
        if (arrayOfString[j].equals(paramString)) {
          k = 1;
        }
        j += 1;
      }
      if (k == 0) {
        break label222;
      }
      paramCGSize = localMediaCodecInfo;
    }
    label222:
    for (;;)
    {
      i += 1;
      break;
      j = getWidthAlignment(paramCGSize, paramString);
      i = getHeightAlignment(paramCGSize, paramString);
      j = (int)(Math.ceil(n * 1.0F / j) * j);
      i = (int)(Math.ceil(m * 1.0F / i) * i);
      if (!isSupported(paramCGSize, paramString, j, i))
      {
        j = (int)(Math.ceil(n / 16.0F) * 16.0D);
        i = (int)(Math.ceil(m / 16.0F) * 16.0D);
      }
      for (;;)
      {
        paramCGSize = new CGSize(j, i);
        AppMethodBeat.o(201725);
        return paramCGSize;
      }
    }
  }
  
  private static List<MediaCodecInfo> decoderCodecInfo(String paramString)
  {
    AppMethodBeat.i(201726);
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
    AppMethodBeat.o(201726);
    return localArrayList;
  }
  
  private static List<MediaCodecInfo> encoderCodecInfo(String paramString)
  {
    AppMethodBeat.i(201727);
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
    AppMethodBeat.o(201727);
    return localArrayList;
  }
  
  private static int getHeightAlignment(MediaCodecInfo paramMediaCodecInfo, String paramString)
  {
    AppMethodBeat.i(201729);
    if (Build.VERSION.SDK_INT >= 21)
    {
      if (paramMediaCodecInfo != null)
      {
        int i = paramMediaCodecInfo.getCapabilitiesForType(paramString).getVideoCapabilities().getHeightAlignment();
        AppMethodBeat.o(201729);
        return i;
      }
      AppMethodBeat.o(201729);
      return 16;
    }
    AppMethodBeat.o(201729);
    return 16;
  }
  
  private static int getWidthAlignment(MediaCodecInfo paramMediaCodecInfo, String paramString)
  {
    AppMethodBeat.i(201728);
    if (Build.VERSION.SDK_INT >= 21)
    {
      if (paramMediaCodecInfo != null)
      {
        int i = paramMediaCodecInfo.getCapabilitiesForType(paramString).getVideoCapabilities().getWidthAlignment();
        AppMethodBeat.o(201728);
        return i;
      }
      AppMethodBeat.o(201728);
      return 16;
    }
    AppMethodBeat.o(201728);
    return 16;
  }
  
  private static boolean isSupported(MediaCodecInfo paramMediaCodecInfo, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(201730);
    if ((Build.VERSION.SDK_INT >= 21) && (paramMediaCodecInfo != null) && (paramMediaCodecInfo.getCapabilitiesForType(paramString).getVideoCapabilities().isSizeSupported(paramInt1, paramInt2)))
    {
      AppMethodBeat.o(201730);
      return true;
    }
    AppMethodBeat.o(201730);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tav.decoder.CodecHelper
 * JD-Core Version:    0.7.0.1
 */