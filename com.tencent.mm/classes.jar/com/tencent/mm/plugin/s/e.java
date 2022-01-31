package com.tencent.mm.plugin.s;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.VideoCapabilities;
import android.media.MediaCodecList;
import android.util.Range;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;

public final class e
{
  private static long mea = 0L;
  
  private static String a(MediaCodecInfo paramMediaCodecInfo)
  {
    paramMediaCodecInfo = paramMediaCodecInfo.getSupportedTypes();
    int i = 0;
    while (i < paramMediaCodecInfo.length)
    {
      String str = paramMediaCodecInfo[i];
      if ((!bk.bl(str)) && (str.contains("hevc"))) {
        return str;
      }
      i += 1;
    }
    return "";
  }
  
  @TargetApi(21)
  public static boolean bio()
  {
    ArrayList localArrayList1;
    if (d.gF(21))
    {
      MediaCodecInfo[] arrayOfMediaCodecInfo = new MediaCodecList(1).getCodecInfos();
      int j = arrayOfMediaCodecInfo.length;
      localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      int i = 0;
      while (i < j)
      {
        String str = a(arrayOfMediaCodecInfo[i]);
        if (!bk.bl(str))
        {
          localArrayList1.add(Integer.valueOf(i));
          localArrayList2.add(str);
        }
        i += 1;
      }
    }
    return !localArrayList1.isEmpty();
  }
  
  public static boolean bip()
  {
    return bk.co(mea) > 86400000L;
  }
  
  public static String biq()
  {
    y.d("MicroMsg.MediaCodecUtil", "check hevc info last rpt time[%d]", new Object[] { Long.valueOf(mea) });
    for (;;)
    {
      int i;
      int i5;
      try
      {
        mea = bk.UY();
        if (!d.gF(21)) {
          continue;
        }
        l = bk.UZ();
        localObject1 = new MediaCodecList(1).getCodecInfos();
        j = localObject1.length;
        ArrayList localArrayList1 = new ArrayList();
        ArrayList localArrayList2 = new ArrayList();
        i = 0;
        if (i < j)
        {
          localObject2 = a(localObject1[i]);
          if (bk.bl((String)localObject2)) {
            break label834;
          }
          localArrayList1.add(Integer.valueOf(i));
          localArrayList2.add(localObject2);
          break label834;
        }
        if (localArrayList1.isEmpty()) {
          return "";
        }
        k = 0;
        i7 = 0;
        i6 = 0;
        j = 0;
        m = 0;
        n = 0;
        i1 = 0;
        i2 = 0;
        i3 = 0;
        i4 = 0;
        i = 0;
        localObject2 = new StringBuilder();
        localStringBuilder = new StringBuilder();
        i5 = 0;
        bool = false;
        if (i5 < localArrayList1.size())
        {
          int i8 = ((Integer)localArrayList1.get(i5)).intValue();
          Object localObject3 = (String)localArrayList2.get(i5);
          bool = localObject1[i8].isEncoder();
          if (localObject1[i8].isEncoder()) {
            break label850;
          }
          k = 1;
          localObject3 = localObject1[i8].getCapabilitiesForType((String)localObject3);
          if (localObject3 != null)
          {
            i7 = 1;
            localObject3 = ((MediaCodecInfo.CodecCapabilities)localObject3).getVideoCapabilities();
            if (localObject3 == null) {
              break label831;
            }
            j = Math.max(((Integer)((MediaCodecInfo.VideoCapabilities)localObject3).getBitrateRange().getLower()).intValue(), j);
            m = Math.max(((Integer)((MediaCodecInfo.VideoCapabilities)localObject3).getBitrateRange().getUpper()).intValue(), m);
            n = Math.max(((Integer)((MediaCodecInfo.VideoCapabilities)localObject3).getSupportedFrameRates().getLower()).intValue(), n);
            i1 = Math.max(((Integer)((MediaCodecInfo.VideoCapabilities)localObject3).getSupportedFrameRates().getUpper()).intValue(), i1);
            i2 = Math.max(((Integer)((MediaCodecInfo.VideoCapabilities)localObject3).getSupportedWidths().getLower()).intValue(), i2);
            i3 = Math.max(((Integer)((MediaCodecInfo.VideoCapabilities)localObject3).getSupportedWidths().getUpper()).intValue(), i3);
            i4 = Math.max(((Integer)((MediaCodecInfo.VideoCapabilities)localObject3).getSupportedHeights().getLower()).intValue(), i4);
            i = Math.max(((Integer)((MediaCodecInfo.VideoCapabilities)localObject3).getSupportedHeights().getUpper()).intValue(), i);
            ((StringBuilder)localObject2).append(localObject1[i8].getName()).append("|");
            break label841;
          }
          i6 = 1;
          localStringBuilder.append(localObject1[i8].getName()).append("|");
          break label841;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(1).append(",");
        if ((k == 0) || (!bool)) {
          continue;
        }
        ((StringBuilder)localObject1).append(3).append(",");
      }
      catch (Exception localException)
      {
        long l;
        Object localObject1;
        int j;
        Object localObject2;
        int i7;
        int m;
        int n;
        int i1;
        int i2;
        int i3;
        int i4;
        StringBuilder localStringBuilder;
        boolean bool;
        y.printErrStackTrace("MicroMsg.MediaCodecUtil", localException, "report hevc info error %s", new Object[] { localException.toString() });
        return "";
        if (!bool) {
          continue;
        }
        localException.append(2).append(",");
        continue;
      }
      catch (Throwable localThrowable)
      {
        int i6;
        y.printErrStackTrace("MicroMsg.MediaCodecUtil", localThrowable, "report hevc info error %s", new Object[] { localThrowable.toString() });
        continue;
        localThrowable.append(1).append(",");
        continue;
        if (i6 == 0) {
          continue;
        }
        localThrowable.append(2).append(",");
        continue;
        localThrowable.append(1).append(",");
        continue;
        String str = bir();
        return str;
      }
      if ((i7 != 0) && (i6 != 0))
      {
        ((StringBuilder)localObject1).append(3).append(",");
        ((StringBuilder)localObject1).append(((StringBuilder)localObject2).toString()).append(",");
        ((StringBuilder)localObject1).append(localStringBuilder.toString()).append(",");
        ((StringBuilder)localObject1).append(j).append(",").append(m).append(",");
        ((StringBuilder)localObject1).append(n).append(",").append(i1).append(",");
        ((StringBuilder)localObject1).append(i2).append(",").append(i3).append(",");
        ((StringBuilder)localObject1).append(i4).append(",").append(i);
        localObject1 = ((StringBuilder)localObject1).toString();
        y.i("MicroMsg.MediaCodecUtil", "high api 21 cost[%d] hevc info %s", new Object[] { Long.valueOf(bk.cp(l)), localObject1 });
        return localObject1;
      }
      label831:
      continue;
      label834:
      i += 1;
      continue;
      label841:
      i5 += 1;
      continue;
      label850:
      int k = 0;
    }
  }
  
  private static String bir()
  {
    long l = bk.UZ();
    int j = MediaCodecList.getCodecCount();
    Object localObject1 = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < j)
    {
      localObject2 = a(MediaCodecList.getCodecInfoAt(i));
      if (!bk.bl((String)localObject2))
      {
        ((ArrayList)localObject1).add(Integer.valueOf(i));
        localArrayList.add(localObject2);
      }
      i += 1;
    }
    if (((ArrayList)localObject1).isEmpty()) {
      return "";
    }
    boolean bool = false;
    i = 0;
    j = 0;
    int m = 0;
    Object localObject2 = new StringBuilder();
    StringBuilder localStringBuilder = new StringBuilder();
    int k = 0;
    if (k < ((ArrayList)localObject1).size())
    {
      i = ((Integer)((ArrayList)localObject1).get(k)).intValue();
      String str = (String)localArrayList.get(k);
      MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
      bool = localMediaCodecInfo.isEncoder();
      if (!localMediaCodecInfo.isEncoder())
      {
        i = 1;
        label172:
        if (localMediaCodecInfo.getCapabilitiesForType(str) == null) {
          break label212;
        }
        j = 1;
        ((StringBuilder)localObject2).append(localMediaCodecInfo.getName()).append("|");
      }
      for (;;)
      {
        k += 1;
        break;
        i = 0;
        break label172;
        label212:
        m = 1;
        localStringBuilder.append(localMediaCodecInfo.getName()).append("|");
      }
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(1).append(",");
    if ((i != 0) && (bool))
    {
      ((StringBuilder)localObject1).append(3).append(",");
      if ((j == 0) || (m == 0)) {
        break label394;
      }
      ((StringBuilder)localObject1).append(3).append(",");
    }
    for (;;)
    {
      ((StringBuilder)localObject1).append(((StringBuilder)localObject2).toString()).append(",");
      ((StringBuilder)localObject1).append(localStringBuilder.toString());
      localObject1 = ((StringBuilder)localObject1).toString();
      y.i("MicroMsg.MediaCodecUtil", "below api 21 cost[%d] hevc info %s", new Object[] { Long.valueOf(bk.cp(l)), localObject1 });
      return localObject1;
      if (bool)
      {
        ((StringBuilder)localObject1).append(2).append(",");
        break;
      }
      ((StringBuilder)localObject1).append(1).append(",");
      break;
      label394:
      if (m != 0) {
        ((StringBuilder)localObject1).append(2).append(",");
      } else {
        ((StringBuilder)localObject1).append(1).append(",");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.s.e
 * JD-Core Version:    0.7.0.1
 */